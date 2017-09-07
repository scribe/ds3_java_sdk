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

package com.spectralogic.escapepod.metadatasearch

import com.spectralogic.escapepod.api.*
import com.spectralogic.escapepod.metadatasearch.models.ElasticSearchHealthResponse
import com.spectralogic.escapepod.metadatasearch.models.ElasticSearchIndicesResponse
import com.spectralogic.escapepod.metadatasearch.models.ElasticSearchResponse
import com.spectralogic.escapepod.util.JsonMapping
import com.spectralogic.escapepod.util.ReadFileFromResources
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.Single
import org.apache.http.HttpHost
import org.apache.http.entity.ContentType
import org.apache.http.nio.entity.NStringEntity
import org.apache.http.util.EntityUtils
import org.elasticsearch.client.Response
import org.elasticsearch.client.ResponseException
import org.elasticsearch.client.RestClient
import java.util.*
import java.util.stream.Collectors

class ElasticSearchService constructor(private val restClient: RestClient, private val requestContext: RequestContext) : MetadataSearchService {

    private companion object {
        private var PRETTY_TRUE: MutableMap<String, String> = Collections.singletonMap("pretty", "true")
        private var HEAD: String = "HEAD"
        private var GET: String = "GET"
        private var PUT: String = "PUT"
        private var POST: String = "POST"
        private var DELETE: String = "DELETE"
    }


    override fun health(): Single<MetadataSearchHealthResponse> {
        return ReactivexAdapters.createSingle { emitter ->
            val response = restClient.performRequest(
                    GET,
                    "/_cluster/health",
                    PRETTY_TRUE)

            if (response.statusLine.statusCode > 300) {
                emitter.onError(MetadataException(response.statusLine.statusCode, response.statusLine.reasonPhrase))
            } else {
                val elasticSearchHealthResponse = JsonMapping.fromJson(EntityUtils.toString(response.entity).byteInputStream(),
                        ElasticSearchHealthResponse::class.java)

                emitter.onSuccess(MetadataSearchHealthResponse(elasticSearchHealthResponse.clusterName,
                        elasticSearchHealthResponse.status))
            }
        }
    }

    override fun createIndex(blackPearlName: String, numberOfShard: Int, numberOfReplicas: Int): Completable {
        return ReactivexAdapters.createCompletable { emitter ->
            ReadFileFromResources.readFile("elasticsearch/index/createIndex.template")
                    .doOnSuccess { template ->
                        val response = restClient.performRequest(
                                PUT,
                                blackPearlName,
                                PRETTY_TRUE,
                                NStringEntity(String.format(template, numberOfShard, numberOfReplicas),
                                        ContentType.APPLICATION_JSON)
                        )

                        if (response.statusLine.statusCode > 300) {
                            emitter.onError(MetadataException(response.statusLine.statusCode, response.statusLine.reasonPhrase))
                        } else {
                            emitter.onComplete()
                        }
                    }.subscribe()
        }
    }


    override fun updateIndexNumberOfReplicas(blackPearlName: String, numberOfReplicas: Int): Completable {
        return ReactivexAdapters.createCompletable { emitter ->
            ReadFileFromResources.readFile("elasticsearch/index/updateIndexNumberOfReplicas.template")
                    .doOnSuccess { template ->
                        val response = restClient.performRequest(
                                PUT,
                                "/$blackPearlName/_settings",
                                PRETTY_TRUE,
                                NStringEntity(String.format(template, numberOfReplicas),
                                        ContentType.APPLICATION_JSON)
                        )

                        if (response.statusLine.statusCode > 300) {
                            emitter.onError(MetadataException(response.statusLine.statusCode, response.statusLine.reasonPhrase))
                        } else {
                            emitter.onComplete()
                        }
                    }
                    .subscribe()
        }
    }

    override fun getAllIndices(): Observable<MetadataIndex> {
        return ReactivexAdapters.createObservable { emitter ->
            val response = restClient.performRequest(
                    GET,
                    "/_cat/indices",
                    Collections.singletonMap("format", "json")
            )

            if (response.statusLine.statusCode > 300) {
                emitter.onError(MetadataException(response.statusLine.statusCode, response.statusLine.reasonPhrase))
            } else {
                val elasticSearchIndicesResponse =
                        JsonMapping.fromJson(EntityUtils.toString(response.entity).byteInputStream(),
                                ElasticSearchIndicesResponse::class.java)

                elasticSearchIndicesResponse.indices.forEach {
                    (indexName, primaries, replications, numberOfDocuments) ->
                    emitter.onNext(MetadataIndex(indexName, primaries, replications, numberOfDocuments))
                }

                emitter.onComplete()
            }
        }
    }

    private fun ensureIndexExists(index: String) {
        try {
            val response = restClient.performRequest(HEAD, "/$index")
            if (response.statusLine.statusCode != 200) {
                createIndex(index)
            }
        } catch (ex: ResponseException) {
            throw MetadataException(ex.response.statusLine.statusCode, ex.response.statusLine.reasonPhrase, ex)
        } catch (ex: Exception) {
            throw MetadataException(ex)
        }
    }

    override fun indexDocument(blackPearlName: String, bucket: String, fileName: String, metadata: Map<String, String>): Completable =
            indexDocumentHelper(blackPearlName, bucket, fileName, metadata, PUT)

    override fun updateIndexedDocument(blackPearlName: String, bucket: String, fileName: String, metadata: Map<String, String>): Completable =
            indexDocumentHelper(blackPearlName, bucket, fileName, metadata, POST)

    private fun indexDocumentHelper(index: String, bucket: String, id: String, metadata: Map<String, String>,
                                    method: String): Completable {
        return ReactivexAdapters.createCompletable { emitter ->
            ensureIndexExists(index)

            val metadataString = getMetadataString(metadata)
            ReadFileFromResources.readFile("elasticsearch/index/indexFile.template")
                    .doOnSuccess { template ->
                        val entity = NStringEntity(String.format(template, metadataString),
                                ContentType.APPLICATION_JSON)

                        val response = restClient.performRequest(
                                method,
                                "/$index/$bucket/$id",
                                PRETTY_TRUE,
                                entity)

                        if (response.statusLine.statusCode > 300) {
                            emitter.onError(MetadataException(response.statusLine.statusCode, response.statusLine.reasonPhrase))
                        } else {
                            emitter.onComplete()
                        }
                    }
                    .subscribe()
        }
    }

    override fun deleteDocument(blackPearlName: String, bucket: String, fileName: String): Completable =
            deleteHelper("/$blackPearlName/$bucket/$fileName")

    override fun deleteIndex(blackPearlName: String): Completable = deleteHelper("/$blackPearlName")

    private fun deleteHelper(endpoint: String): Completable {
        return ReactivexAdapters.createCompletable { emitter ->
            val response = restClient.performRequest(
                    DELETE,
                    endpoint,
                    PRETTY_TRUE
            )

            if (response.statusLine.statusCode > 300) {
                emitter.onError(MetadataException(response.statusLine.statusCode, response.statusLine.reasonPhrase))
            } else {
                emitter.onComplete()
            }
        }
    }

    override fun searchById(blackPearlName: String, bucket: String, fileName: String): Observable<MetadataSearchHitsNode> =
            searchByIdHelper("/$blackPearlName/$bucket/_search", fileName)

    override fun searchById(blackPearlName: String, fileName: String): Observable<MetadataSearchHitsNode> =
            searchByIdHelper("/$blackPearlName/_search", fileName)

    override fun searchById(fileName: String): Observable<MetadataSearchHitsNode> =
            searchByIdHelper("/_search", fileName)

    private fun searchByIdHelper(endpoint: String, id: String): Observable<MetadataSearchHitsNode> {
        return ReactivexAdapters.createObservable { emitter ->
            ReadFileFromResources.readFile("elasticsearch/search/searchById.template")
                    .doOnSuccess { template ->
                        val response = restClient.performRequest(
                                GET,
                                endpoint,
                                PRETTY_TRUE,
                                NStringEntity(String.format(template, id),
                                        ContentType.APPLICATION_JSON)
                        )

                        searchHelper(response, emitter)
                    }
                    .subscribe()
        }
    }

    override fun searchByMetadata(blackPearlName: String, bucket: String, metadataKey: String, metadataValue: String): Observable<MetadataSearchHitsNode> =
            searchByMetadataHelper("/$blackPearlName/$bucket/_search", metadataKey, metadataValue)

    override fun searchByMetadata(blackPearlName: String, metadataKey: String, metadataValue: String): Observable<MetadataSearchHitsNode> =
            searchByMetadataHelper("/$blackPearlName/_search", metadataKey, metadataValue)

    override fun searchByMetadata(metadataKey: String, metadataValue: String): Observable<MetadataSearchHitsNode> =
            searchByMetadataHelper("/_search", metadataKey, metadataValue)

    private fun searchByMetadataHelper(endpoint: String, key: String, value: String): Observable<MetadataSearchHitsNode> {
        return ReactivexAdapters.createObservable { emitter ->
            ReadFileFromResources.readFile("elasticsearch/search/searchByMetadata.template")
                    .doOnSuccess { template ->
                        val response = restClient.performRequest(
                                GET,
                                endpoint,
                                PRETTY_TRUE,
                                NStringEntity(String.format(template, key, value),
                                        ContentType.APPLICATION_JSON)
                        )

                        searchHelper(response, emitter)
                    }
                    .subscribe()
        }
    }

    override fun searchByMatchAll(blackPearlName: String, bucket: String): Observable<MetadataSearchHitsNode> =
            searchByMatchAllHelper("/$blackPearlName/$bucket/_search")

    override fun searchByMatchAll(blackPearlName: String): Observable<MetadataSearchHitsNode> =
            searchByMatchAllHelper("/$blackPearlName/_search")

    override fun searchByMatchAll(): Observable<MetadataSearchHitsNode> = searchByMatchAllHelper("/_search")

    private fun searchByMatchAllHelper(endpoint: String): Observable<MetadataSearchHitsNode> {
        return ReactivexAdapters.createObservable { emitter ->
            ReadFileFromResources.readFile("elasticsearch/search/searchByMatchAll.template")
                    .doOnSuccess { template ->
                        val response = restClient.performRequest(
                                GET,
                                endpoint,
                                PRETTY_TRUE,
                                NStringEntity(template, ContentType.APPLICATION_JSON)
                        )

                        searchHelper(response, emitter)
                    }
                    .subscribe()
        }
    }

    private fun searchHelper(response: Response, emitter: ObservableEmitter<MetadataSearchHitsNode>) {
        if (response.statusLine.statusCode > 300) {
            emitter.onError(MetadataException(response.statusLine.statusCode, response.statusLine.reasonPhrase))
        } else {
            val elasticSearchResponse = JsonMapping.fromJson(EntityUtils.toString(response.entity).byteInputStream(),
                    ElasticSearchResponse::class.java)

            elasticSearchResponse.hits.hits.map {
                (index, type, id, score, source) ->
                emitter.onNext(MetadataSearchHitsNode(index, type, id, score, source))
            }
            emitter.onComplete()
        }
    }

    private fun getMetadataString(metadata: Map<String, String>): String {
        return metadata.entries
                .stream()
                .map({ entry -> "\"${entry.key}\" : \"${entry.value}\"" })
                .collect(Collectors.joining(", "))
    }
}