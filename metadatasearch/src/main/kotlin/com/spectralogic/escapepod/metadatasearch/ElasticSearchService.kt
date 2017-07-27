package com.spectralogic.escapepod.metadatasearch

import com.spectralogic.escapepod.api.MetadataException
import com.spectralogic.escapepod.api.MetadataIndex
import com.spectralogic.escapepod.api.MetadataSearchHealthResponse
import com.spectralogic.escapepod.api.MetadataSearchHitsNode
import com.spectralogic.escapepod.metadatasearch.api.ElasticSearchMetadataService
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

class ElasticSearchService : ElasticSearchMetadataService {

    var restClient: RestClient

    private companion object {
        private var PRETTY_TRUE: MutableMap<String, String> = Collections.singletonMap("pretty", "true")
        private var HEAD: String = "HEAD"
        private var GET: String = "GET"
        private var PUT: String = "PUT"
        private var POST: String = "POST"
        private var DELETE: String = "DELETE"
    }

    constructor(httpHosts: List<HttpHost>) {
        restClient = RestClient.builder(*httpHosts.toTypedArray()).build()
    }

    constructor(restClient: RestClient) {
        this.restClient = restClient
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

    override fun createIndex(index: String, numberOfShard: Int, numberOfReplicas: Int): Completable {
        return ReactivexAdapters.createCompletable { emitter ->
            ReadFileFromResources.readFile("elasticsearch/index/createIndex.template")
                    .doOnSuccess { template ->
                        val response = restClient.performRequest(
                                PUT,
                                index,
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


    override fun updateIndexNumberOfReplicas(index: String, numberOfReplicas: Int): Completable {
        return ReactivexAdapters.createCompletable { emitter ->
            ReadFileFromResources.readFile("elasticsearch/index/updateIndexNumberOfReplicas.template")
                    .doOnSuccess { template ->
                        val response = restClient.performRequest(
                                PUT,
                                "/$index/_settings",
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

    override fun indexDocument(index: String, bucket: String, id: String, metadata: Map<String, String>): Completable {
        return indexDocumentHelper(index, bucket, id, metadata, PUT)
    }

    override fun updateIndexedDocument(index: String, bucket: String, id: String, metadata: Map<String, String>): Completable {
        return indexDocumentHelper(index, bucket, id, metadata, POST)
    }

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

    override fun deleteDocument(index: String, bucket: String, id: String): Completable {
        return deleteHelper("/$index/$bucket/$id")
    }

    override fun deleteIndex(index: String): Completable {
        return deleteHelper("/$index")
    }

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

    override fun searchById(index: String, bucket: String, id: String): Observable<MetadataSearchHitsNode> {
        return searchByIdHelper("/$index/$bucket/_search", id)
    }

    override fun searchById(index: String, id: String): Observable<MetadataSearchHitsNode> {
        return searchByIdHelper("/$index/_search", id)
    }

    override fun searchById(id: String): Observable<MetadataSearchHitsNode> {
        return searchByIdHelper("/_search", id)
    }

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

    override fun searchByMetadata(index: String, bucket: String, key: String, value: String): Observable<MetadataSearchHitsNode> {
        return searchByMetadataHelper("/$index/$bucket/_search", key, value)
    }

    override fun searchByMetadata(index: String, key: String, value: String): Observable<MetadataSearchHitsNode> {
        return searchByMetadataHelper("/$index/_search", key, value)
    }

    override fun searchByMetadata(key: String, value: String): Observable<MetadataSearchHitsNode> {
        return searchByMetadataHelper("/_search", key, value)
    }

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

    override fun searchByMatchAll(index: String, bucket: String): Observable<MetadataSearchHitsNode> {
        return searchByMatchAllHelper("/$index/$bucket/_search")
    }

    override fun searchByMatchAll(index: String): Observable<MetadataSearchHitsNode> {
        return searchByMatchAllHelper("/$index/_search")
    }

    override fun searchByMatchAll(): Observable<MetadataSearchHitsNode> {
        return searchByMatchAllHelper("/_search")
    }

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

    override fun closeConnection(): Completable {
        return ReactivexAdapters.createCompletable { emitter ->
            restClient.close()
            emitter.onComplete()
        }
    }
}