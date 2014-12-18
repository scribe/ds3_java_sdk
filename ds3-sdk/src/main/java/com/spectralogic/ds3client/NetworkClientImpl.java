/*
 * ******************************************************************************
 *   Copyright 2014 Spectra Logic Corporation. All Rights Reserved.
 *   Licensed under the Apache License, Version 2.0 (the "License"). You may not use
 *   this file except in compliance with the License. A copy of the License is located at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   or in the "license" file accompanying this file.
 *   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *   CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *   specific language governing permissions and limitations under the License.
 * ****************************************************************************
 */

package com.spectralogic.ds3client;

import com.google.common.base.Joiner;
import com.google.common.collect.Multimap;
import com.google.common.net.UrlEscapers;
import com.spectralogic.ds3client.commands.Ds3Request;
import com.spectralogic.ds3client.commands.PutObjectRequest;
import com.spectralogic.ds3client.models.SignatureDetails;
import com.spectralogic.ds3client.networking.*;
import com.spectralogic.ds3client.utils.DateFormatter;
import com.spectralogic.ds3client.utils.SSLSetupException;
import com.spectralogic.ds3client.utils.Signature;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ssl.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.message.BasicHttpRequest;

import javax.net.ssl.SSLContext;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.AssertionError;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Map;

class NetworkClientImpl implements NetworkClient {
    final static private String HOST = "HOST";
    final static private String DATE = "DATE";
    final static private String AUTHORIZATION = "Authorization";
    final static private String CONTENT_TYPE = "Content-Type";
    final static private String CONTENT_MD5 = "Content-MD5";

    final private ConnectionDetails connectionDetails;

    NetworkClientImpl(final ConnectionDetails connectionDetails) {
        if (connectionDetails == null) throw new AssertionError("Connection Details cannot be null");
        this.connectionDetails = connectionDetails;
    }

    @Override
    public ConnectionDetails getConnectionDetails() {
        return this.connectionDetails;
    }

    @Override
    public WebResponse getResponse(final Ds3Request request) throws IOException, SignatureException {
        try (final RequestExecutor requestExecutor = new RequestExecutor(request)) {
            int redirectCount = 0;
            do {
                final CloseableHttpResponse response = requestExecutor.execute();
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_TEMPORARY_REDIRECT) {
                    redirectCount++;
                }
                else {
                    return new WebResponseImpl(response);
                }
            } while (redirectCount < this.connectionDetails.getRetries());
            
            throw new TooManyRedirectsException(redirectCount);
        }
    }
    
    private class RequestExecutor implements Closeable {
        private final Ds3Request ds3Request;
        private final InputStream content;
        private final HttpHost host;
        private final String hash;

        public RequestExecutor(final Ds3Request ds3Request) throws IOException {
            this.ds3Request = ds3Request;
            this.host = this.buildHost();
            this.content = ds3Request.getStream();
            if (this.content != null && !this.content.markSupported()) {
                throw new RequiresMarkSupportedException();
            }
            this.hash = this.buildHash();
        }
        
        public CloseableHttpResponse execute() throws IOException, SignatureException {
            if (this.content != null) {
                this.content.reset();
            }
            
            final HttpRequest httpRequest = this.buildHttpRequest();
            this.addHeaders(httpRequest);
            return getClient().execute(this.host, httpRequest, this.getContext());
        }

        private HttpHost buildHost() throws MalformedURLException {
            final URI proxyUri = NetworkClientImpl.this.connectionDetails.getProxy();
            if (proxyUri != null) {
                return new HttpHost(proxyUri.getHost(), proxyUri.getPort(), proxyUri.getScheme());
            } else {
                final URL url = NetUtils.buildUrl(NetworkClientImpl.this.connectionDetails, "/");
                return new HttpHost(url.getHost(), NetUtils.getPort(url), url.getProtocol());
            }
        }

        private CloseableHttpClient getClient() {
            if (NetworkClientImpl.this.getConnectionDetails().isHttps() && !NetworkClientImpl.this.getConnectionDetails().isCertificateVerification()) {
                try {

                    final SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {
                        @Override
                        public boolean isTrusted(final X509Certificate[] chain, final String authType) throws CertificateException {
                            return true;
                        }
                    }).useTLS().build();

                    final SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new AllowAllHostnameVerifier());
                    return HttpClients.custom().setSSLSocketFactory(
                            sslsf).build();

                } catch (final NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
                    throw new SSLSetupException(e);
                }
            }
            else {
                return HttpClients.createDefault();
            }
        }

        private HttpRequest buildHttpRequest() throws IOException {
            final String verb = this.ds3Request.getVerb().toString();
            final String path = this.buildPath();
            if (this.content != null) {
                final BasicHttpEntityEnclosingRequest httpRequest = new BasicHttpEntityEnclosingRequest(verb, path);

                final Ds3InputStreamEntity entityStream = new Ds3InputStreamEntity(this.content, this.ds3Request.getSize(), this.ds3Request.getContentType());
                entityStream.setBufferSize(NetworkClientImpl.this.connectionDetails.getBufferSize());
                httpRequest.setEntity(entityStream);
                return httpRequest;
            } else {
                return new BasicHttpRequest(verb, path);
            }
        }

        private String buildPath() {
            String path = UrlEscapers.urlFragmentEscaper().escape(this.ds3Request.getPath());
            final Map<String, String> queryParams = this.ds3Request.getQueryParams();
            if (!queryParams.isEmpty()) {
                path += "?" + NetUtils.buildQueryString(queryParams);
            }
            return path;
        }

        private void addHeaders(final HttpRequest httpRequest) throws IOException, SignatureException {
            // Add common headers.
            final String date = DateFormatter.dateToRfc882();
            httpRequest.addHeader(HOST, NetUtils.buildHostField(NetworkClientImpl.this.connectionDetails));
            httpRequest.addHeader(DATE, date);
            httpRequest.addHeader(CONTENT_TYPE, this.ds3Request.getContentType().toString());
            
            // Add custom headers.
            for(final Map.Entry<String, String> header: this.ds3Request.getHeaders().entries()) {
                httpRequest.addHeader(header.getKey(), header.getValue());
            }
            
            // Add the hash header.
            if (!this.hash.isEmpty()) {
                httpRequest.addHeader(CONTENT_MD5, this.hash);
            }
            
            // Add the signature header.
            httpRequest.addHeader(AUTHORIZATION, this.getSignature(new SignatureDetails(
                this.ds3Request.getVerb(),
                this.hash,
                this.ds3Request.getContentType().toString(),
                date,
                canonicalizeAmzHeaders(this.ds3Request.getHeaders()),
                UrlEscapers.urlFragmentEscaper().escape(this.ds3Request.getPath()),
                NetworkClientImpl.this.connectionDetails.getCredentials()
            )));
        }
        
		private String canonicalizeAmzHeaders(
				final Multimap<String, String> customHeaders) {
			StringBuilder ret = new StringBuilder();
			for (final Map.Entry<String, Collection<String>> header : customHeaders
					.asMap().entrySet()) {
				final String key = header.getKey().toLowerCase();
				if (key.startsWith(PutObjectRequest.AMZ_META_HEADER)
						&& header.getValue().size() > 0) {
					ret.append(key).append(":");
					ret.append(Joiner.on(",").join(header.getValue()));
					ret.append('\n');
				}
			}
			return ret.toString();
		}

        private String buildHash() throws IOException {
            return this.ds3Request.getChecksum().match(new HashGeneratingMatchHandler(this.content));
        }

        private String getSignature(final SignatureDetails details) throws SignatureException {
            return "AWS " + NetworkClientImpl.this.connectionDetails.getCredentials().getClientId() + ':' + Signature.signature(details);
        }
        
        private HttpClientContext getContext() {
            final HttpClientContext context = new HttpClientContext();
            context.setRequestConfig(
                RequestConfig
                    .custom()
                    .setRedirectsEnabled(false)
                    .build()
            );
            return context;
        }

        @Override
        public void close() throws IOException {
            if (this.content != null) {
                this.content.close();
            }
        }
    }
}