package com.spectralogic.escapepod.metadatasearch

import com.spectralogic.escapepod.api.*
import com.spectralogic.escapepod.metadatasearch.models.ElasticSearchHealthResponse
import com.spectralogic.escapepod.metadatasearch.models.ElasticSearchIndicesResponse
import com.spectralogic.escapepod.metadatasearch.models.ElasticSearchResponse
import com.spectralogic.escapepod.util.JsonMapping
import com.spectralogic.escapepod.util.ReadFileFromResources
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import org.apache.http.HttpHost
import org.apache.http.entity.ContentType
import org.apache.http.nio.entity.NStringEntity
import org.apache.http.util.EntityUtils
import org.elasticsearch.client.ResponseException
import org.elasticsearch.client.RestClient
import java.util.*

class ElasticSearchService : MetadataSearchService {
    var restClient: RestClient

    constructor(httpHosts: List<HttpHost>) {
        restClient = RestClient.builder(*httpHosts.toTypedArray()).build()
    }

    constructor(restClient: RestClient) {
        this.restClient = restClient
    }

    override fun health(): Single<MetadataSearchHealthResponse> {
        return Single.create { emitter ->
            try {
                val response = restClient.performRequest(
                        "GET",
                        "/_cluster/health",
                        Collections.singletonMap("pretty", "true"))

                if (response.statusLine.statusCode > 300) {
                    throw MetadataException(response.statusLine.statusCode, response.statusLine.reasonPhrase)
                }

                val elasticSearchHealthResponse = JsonMapping.fromJson(EntityUtils.toString(response.entity).byteInputStream(),
                        ElasticSearchHealthResponse::class.java)
                emitter.onSuccess(MetadataSearchHealthResponse(elasticSearchHealthResponse.clusterName,
                elasticSearchHealthResponse.status))
            } catch (ex: ResponseException) {
                emitter.onError(MetadataException(ex.response.statusLine.statusCode, ex.response.statusLine.reasonPhrase, ex))
            } catch (ex: Exception) {
                emitter.onError(ex)
            }
        }
    }

    override fun createIndex(index: String, numberOfShard: Int, numberOfReplicas: Int): Completable {
        return Completable.create { emitter ->
            try {
                val response = restClient.performRequest(
                        "PUT",
                        index,
                        Collections.singletonMap("pretty", "true"),
                        NStringEntity(String.format(ReadFileFromResources.readFile("elasticsearch/index/createIndex.json"),
                                numberOfShard, numberOfReplicas), ContentType.APPLICATION_JSON)
                )

                if (response.statusLine.statusCode > 300) {
                    emitter.onError(MetadataException(response.statusLine.statusCode, response.statusLine.reasonPhrase))
                }
                emitter.onComplete()
            } catch (ex: ResponseException) {
                emitter.onError(MetadataException(ex.response.statusLine.statusCode,
                        ex.response.statusLine.reasonPhrase, ex))
            } catch (ex: Exception) {
                emitter.onError(MetadataException(ex))
            }
        }
    }

    override fun updateIndexNumberOfReplicas(index: String, numberOfReplicas: Int): Completable {
        return Completable.create { emitter ->
            try {
                val response = restClient.performRequest(
                        "PUT",
                        "/$index/_settings",
                        Collections.singletonMap("pretty", "true"),
                        NStringEntity(String.format(ReadFileFromResources.readFile("elasticsearch/index/updateIndexNumberOfReplicas.json"),
                                numberOfReplicas), ContentType.APPLICATION_JSON)
                )

                if (response.statusLine.statusCode > 300) {
                    emitter.onError(MetadataException(response.statusLine.statusCode, response.statusLine.reasonPhrase))
                }
                emitter.onComplete()
            } catch (ex: ResponseException) {
                emitter.onError(MetadataException(ex.response.statusLine.statusCode,
                        ex.response.statusLine.reasonPhrase, ex))
            } catch (ex: Exception) {
                emitter.onError(MetadataException(ex))
            }
        }
    }

    override fun getAllIndices(): Observable<MetadataIndex> {
        return Observable.create { emitter ->
            try {
                val response = restClient.performRequest(
                        "GET",
                        "/_cat/indices",
                        Collections.singletonMap("format", "json")
                )

                if (response.statusLine.statusCode > 300) {
                    throw MetadataException(response.statusLine.statusCode, response.statusLine.reasonPhrase)
                }

                val elasticSearchIndicesResponse =
                        JsonMapping.fromJson(EntityUtils.toString(response.entity).byteInputStream(),
                                ElasticSearchIndicesResponse::class.java)



                elasticSearchIndicesResponse.indices.map {
                    (indexName, primaries, replications, numberOfDocuments) ->
                    emitter.onNext(MetadataIndex(indexName, primaries, replications, numberOfDocuments))
                }
                emitter.onComplete()
            } catch (ex: ResponseException) {
                emitter.onError(MetadataException(ex.response.statusLine.statusCode, ex.response.statusLine
                        .reasonPhrase, ex))
            } catch (ex: Exception) {
                emitter.onError(MetadataException(ex))
            }
        }
    }

    private fun ensureIndexExists(index: String) {
        try {
            val response = restClient.performRequest("HEAD", "/$index")
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
        return indexDocumentHelper(index, bucket, id, metadata, "PUT")
    }

    override fun updateIndexedDocument(index: String, bucket: String, id: String, metadata: Map<String, String>): Completable {
        return indexDocumentHelper(index, bucket, id, metadata, "POST")
    }

    private fun indexDocumentHelper(index: String, bucket: String, id: String, metadata: Map<String, String>,
                                    method: String): Completable {
        return Completable.create { emitter ->
            ensureIndexExists(index)

            val metadataString = getMetadataString(metadata)

            val entity = NStringEntity(String.format(ReadFileFromResources.readFile("elasticsearch/index/indexFile.json"), metadataString),
                    ContentType.APPLICATION_JSON)

            try {
                val response = restClient.performRequest(
                        method,
                        "/$index/$bucket/$id",
                        Collections.singletonMap("pretty", "true"),
                        entity)

                if (response.statusLine.statusCode > 300) {
                    emitter.onError(MetadataException(response.statusLine.statusCode, response.statusLine.reasonPhrase))
                }
                emitter.onComplete()
            } catch (ex: ResponseException) {
                emitter.onError(MetadataException(ex.response.statusLine.statusCode,
                        ex.response.statusLine.reasonPhrase, ex))
            } catch (ex: Exception) {
                emitter.onError(MetadataException(ex))
            }
        }
    }

    override fun deleteDocument(index: String, bucket: String, id: String): Completable {
        return deleteHelper("/$index/$bucket/$id")
    }

    override fun deleteIndex(index: String): Completable {
        return deleteHelper("/$index")
    }

    private fun deleteHelper(endpoint: String): Completable {
        return Completable.create { emitter ->
            try {
                val response = restClient.performRequest(
                        "DELETE",
                        endpoint,
                        Collections.singletonMap("pretty", "true")
                )

                if (response.statusLine.statusCode > 300) {
                    emitter.onError(MetadataException(response.statusLine.statusCode, response.statusLine.reasonPhrase))
                }
                emitter.onComplete()
            } catch (ex: ResponseException) {
                emitter.onError(MetadataException(ex.response.statusLine.statusCode,
                        ex.response.statusLine.reasonPhrase, ex))
            } catch (ex: Exception) {
                emitter.onError(MetadataException(ex))
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
        return Observable.create { emitter ->
            try {
                val response = restClient.performRequest(
                        "GET",
                        endpoint,
                        Collections.singletonMap("pretty", "true"),
                        NStringEntity(String.format(ReadFileFromResources.readFile("elasticsearch/search/searchById.json"), id),
                                ContentType.APPLICATION_JSON)
                )

                if (response.statusLine.statusCode > 300) {
                    throw MetadataException(response.statusLine.statusCode, response.statusLine.reasonPhrase)
                }

                val elasticSearchResponse = JsonMapping.fromJson(EntityUtils.toString(response.entity).byteInputStream(),
                        ElasticSearchResponse::class.java)

                elasticSearchResponse.hits.hits.map {
                    (index, type, id, score, source) ->
                    emitter.onNext(MetadataSearchHitsNode(index, type, id, score, source))
                }
                emitter.onComplete()
            } catch (ex: ResponseException) {
                emitter.onError(MetadataException(ex.response.statusLine.statusCode, ex.response.statusLine.reasonPhrase,
                ex))
            } catch (ex: Exception) {
                emitter.onError(MetadataException(ex))
            }
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
        return Observable.create { emitter ->
            try {
                val response = restClient.performRequest(
                        "GET",
                        endpoint,
                        Collections.singletonMap("pretty", "true"),
                        NStringEntity(String.format(ReadFileFromResources.readFile("elasticsearch/search/searchByMetadata.json"),
                                key, value), ContentType.APPLICATION_JSON)
                )

                if (response.statusLine.statusCode > 300) {
                    throw MetadataException(response.statusLine.statusCode, response.statusLine.reasonPhrase)
                }

                val elasticSearchResponse = JsonMapping.fromJson(EntityUtils.toString(response.entity).byteInputStream(),
                        ElasticSearchResponse::class.java)

                elasticSearchResponse.hits.hits.map {
                    (index, type, id, score, source) ->
                    emitter.onNext(MetadataSearchHitsNode(index, type, id, score, source))
                }
                emitter.onComplete()
            } catch (ex: ResponseException) {
                emitter.onError(MetadataException(ex.response.statusLine.statusCode,
                        ex.response.statusLine.reasonPhrase, ex))
            } catch (ex: Exception) {
                emitter.onError(MetadataException(ex))
            }
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
        return Observable.create { emitter ->
            try {
                val response = restClient.performRequest(
                        "GET",
                        endpoint,
                        Collections.singletonMap("pretty", "true"),
                        NStringEntity(ReadFileFromResources.readFile("elasticsearch/search/searchByMatchAll.json"), ContentType.APPLICATION_JSON)
                )

                if (response.statusLine.statusCode > 300) {
                    throw MetadataException(response.statusLine.statusCode, response.statusLine.reasonPhrase)
                }

                val elasticSearchResponse = JsonMapping.fromJson(EntityUtils.toString(response.entity).byteInputStream(),
                        ElasticSearchResponse::class.java)

                elasticSearchResponse.hits.hits.map {
                    (index, type, id, score, source) ->
                    emitter.onNext(MetadataSearchHitsNode(index, type, id, score, source))
                }
                emitter.onComplete()
            } catch (ex: ResponseException) {
                emitter.onError(MetadataException(ex.response.statusLine.statusCode,
                        ex.response.statusLine.reasonPhrase, ex))
            } catch (ex: Exception) {
                emitter.onError(MetadataException(ex))
            }
        }
    }

    private fun getMetadataString(metadata: Map<String, String>): String {
        return metadata.entries
                .stream()
                .map({ entry -> "\"${entry.key}\" : \"${entry.value}\"" })
                .toArray()
                .joinToString(", ")
    }

    override fun closeConnection(): Completable {
        return Completable.create { emitter ->
            try {
                restClient.close()
                emitter.onComplete()
            } catch (ex: Exception) {
                emitter.onError(ex)
            }
        }
    }
}