/*
 * *****************************************************************************
 *    Copyright 2014-2017 Spectra Logic Corporation. All Rights Reserved.
 *    Licensed under the Apache License, Version 2.0 (the "License"). You may not use
 *    this file except in compliance with the License. A copy of the License is located at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *    or in the "license" file accompanying this file.
 *    This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *    CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *    specific language governing permissions and limitations under the License.
 *  ****************************************************************************
 */

package com.spectralogic.escapepod.ratpack

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.inject.Inject
import com.google.inject.name.Named
import com.spectralogic.escapepod.api.RequestContext
import com.spectralogic.escapepod.httpservice.HttpService
import com.spectralogic.escapepod.httpservice.HttpServiceProvider
import com.spectralogic.escapepod.httpservice.WebUi
import io.reactivex.Completable
import io.reactivex.Single
import org.slf4j.LoggerFactory
import ratpack.server.RatpackServer
import ratpack.server.ServerConfigBuilder
import java.io.File

internal class HttpProvider @Inject constructor (@Named("managementPort") private val port : Int, private val rootApiChain: RootApiChain, private val objectMapper: ObjectMapper, private val webUi: WebUi) : HttpServiceProvider {

    private companion object {
        private val LOG = LoggerFactory.getLogger(HttpProvider::class.java)
        private val staticFilesLoaderPage = "index.html"
    }

    var server : RatpackServer? = null

    override fun shutdown(): Completable {
        return Completable.create { emitter ->
            LOG.info("Stopping ratpack server")
            server?.stop()
            emitter.onComplete()
        }
    }

    override fun startService(): Completable {
        return Completable.create { emitter ->
            LOG.info("Starting ratpack server")
            server = RatpackServer.start { server ->
                server.registryOf {
                    it.add(objectMapper)
                }

                server.serverConfig {
                    it.port(port)
                    maybeSetStaticFileBaseFolder(it)
                }

                server.handlers {
                    it.prefix("api", rootApiChain)
                    it.all(webUi.slashHandler())
                }

            }
            emitter.onComplete()
        }
    }

    private fun maybeSetStaticFileBaseFolder(serverConfigBuilder: ServerConfigBuilder) {
        try {
            val webUiResources = File(webUi.javaClass.classLoader.getResource(staticFilesLoaderPage).path).parentFile
            serverConfigBuilder.baseDir(webUiResources)
        } catch (throwable: Throwable) {
            LOG.error("Could not find folder with web UI files.", throwable)
        }
    }

    override fun getService(requestContext: RequestContext): Single<HttpService> {
        TODO("not implemented")
    }
}
