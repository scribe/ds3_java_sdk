package com.spectralogic.escapepod.metadatasearch

import com.spectralogic.escapepod.api.*
import com.spectralogic.escapepod.metadatasearch.models.ElasticSearchHealthResponse
import com.spectralogic.escapepod.metadatasearch.models.ElasticSearchIndicesResponse
import com.spectralogic.escapepod.metadatasearch.models.ElasticSearchResponse
import com.spectralogic.escapepod.util.JsonMapping
import com.spectralogic.escapepod.util.ReadFileFromResources
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

    override fun health(): MetadataSearchHealthResponse {
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

            return MetadataSearchHealthResponse(elasticSearchHealthResponse.clusterName, elasticSearchHealthResponse.status)
        } catch (ex: ResponseException) {
            throw MetadataException(ex.response.statusLine.statusCode, ex.response.statusLine.reasonPhrase, ex)
        } catch (ex: Exception) {
            throw MetadataException(ex)
        }
    }

    override fun createIndex(index: String, numberOfShard: Int, numberOfReplicas: Int) {
        try {
            val response = restClient.performRequest(
                    "PUT",
                    index,
                    Collections.singletonMap("pretty", "true"),
                    NStringEntity(String.format(ReadFileFromResources.readFile("elasticsearch/index/createIndex.json"),
                            numberOfShard, numberOfReplicas), ContentType.APPLICATION_JSON)
            )

            if (response.statusLine.statusCode > 300) {
                throw MetadataException(response.statusLine.statusCode, response.statusLine.reasonPhrase)
            }
        } catch (ex: ResponseException) {
            throw MetadataException(ex.response.statusLine.statusCode, ex.response.statusLine.reasonPhrase, ex)
        } catch (ex: Exception) {
            throw MetadataException(ex)
        }
    }

    override fun updateIndexNumberOfReplicas(index: String, numberOfReplicas: Int) {
        try {
            val response = restClient.performRequest(
                    "PUT",
                    "/$index/_settings",
                    Collections.singletonMap("pretty", "true"),
                    NStringEntity(String.format(ReadFileFromResources.readFile("elasticsearch/index/updateIndexNumberOfReplicas.json"),
                            numberOfReplicas), ContentType.APPLICATION_JSON)
            )

            if (response.statusLine.statusCode > 300) {
                throw MetadataException(response.statusLine.statusCode, response.statusLine.reasonPhrase)
            }
        } catch (ex: ResponseException) {
            throw MetadataException(ex.response.statusLine.statusCode, ex.response.statusLine.reasonPhrase, ex)
        } catch (ex: Exception) {
            throw MetadataException(ex)
        }
    }

    override fun getAllIndices(): MetadataSearchIndicesResponse {
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


            return MetadataSearchIndicesResponse(
                    elasticSearchIndicesResponse.indices.map {
                        (indexName, primaries, replications, numberOfDocuments) ->
                        MetadataIndex(indexName, primaries, replications, numberOfDocuments)
                    }
            )
        } catch (ex: ResponseException) {
            throw MetadataException(ex.response.statusLine.statusCode, ex.response.statusLine.reasonPhrase, ex)
        } catch (ex: Exception) {
            throw MetadataException(ex)
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

    override fun indexDocument(index: String, bucket: String, id: String, metadata: Map<String, String>) {
        indexDocumentHelper(index, bucket, id, metadata, "PUT")
    }

    override fun updateIndexedDocument(index: String, bucket: String, id: String, metadata: Map<String, String>) {
        indexDocumentHelper(index, bucket, id, metadata, "POST")
    }

    private fun indexDocumentHelper(index: String, bucket: String, id: String, metadata: Map<String, String>,
                                    method: String) {
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
                throw MetadataException(response.statusLine.statusCode, response.statusLine.reasonPhrase)
            }
        } catch (ex: ResponseException) {
            throw MetadataException(ex.response.statusLine.statusCode, ex.response.statusLine.reasonPhrase, ex)
        } catch (ex: Exception) {
            throw MetadataException(ex)
        }
    }

    override fun deleteDocument(index: String, bucket: String, id: String) {
        deleteHelper("/$index/$bucket/$id")
    }

    override fun deleteIndex(index: String) {
        deleteHelper("/$index")
    }

    private fun deleteHelper(endpoint: String) {
        try {
            val response = restClient.performRequest(
                    "DELETE",
                    endpoint,
                    Collections.singletonMap("pretty", "true")
            )

            if (response.statusLine.statusCode > 300) {
                throw MetadataException(response.statusLine.statusCode, response.statusLine.reasonPhrase)
            }
        } catch (ex: ResponseException) {
            throw MetadataException(ex.response.statusLine.statusCode, ex.response.statusLine.reasonPhrase, ex)
        } catch (ex: Exception) {
            throw MetadataException(ex)
        }
    }

    override fun searchById(index: String, bucket: String, id: String): MetadataSearchResponse {
        return searchByIdHelper("/$index/$bucket/_search", id)
    }

    override fun searchById(index: String, id: String): MetadataSearchResponse {
        return searchByIdHelper("/$index/_search", id)
    }

    override fun searchById(id: String): MetadataSearchResponse {
        return searchByIdHelper("/_search", id)
    }

    private fun searchByIdHelper(endpoint: String, id: String): MetadataSearchResponse {
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

            return MetadataSearchResponse(elasticSearchResponse.took,
                    MetadataSearchHits(elasticSearchResponse.hits.numberOfHits, elasticSearchResponse.hits.hits.map {
                        (index, type, id, score, source) ->
                        MetadataSearchHitsNode(index, type, id, score, source)
                    }))
        } catch (ex: ResponseException) {
            throw MetadataException(ex.response.statusLine.statusCode, ex.response.statusLine.reasonPhrase, ex)
        } catch (ex: Exception) {
            throw MetadataException(ex)
        }
    }

    override fun searchByMetadata(index: String, bucket: String, key: String, value: String): MetadataSearchResponse {
        return searchByMetadataHelper("/$index/$bucket/_search", key, value)
    }

    override fun searchByMetadata(index: String, key: String, value: String): MetadataSearchResponse {
        return searchByMetadataHelper("/$index/_search", key, value)
    }

    override fun searchByMetadata(key: String, value: String): MetadataSearchResponse {
        return searchByMetadataHelper("/_search", key, value)
    }

    private fun searchByMetadataHelper(endpoint: String, key: String, value: String): MetadataSearchResponse {
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

            return MetadataSearchResponse(elasticSearchResponse.took,
                    MetadataSearchHits(elasticSearchResponse.hits.numberOfHits, elasticSearchResponse.hits.hits.map {
                        (index, type, id, score, source) ->
                        MetadataSearchHitsNode(index, type, id, score, source)
                    }))
        } catch (ex: ResponseException) {
            throw MetadataException(ex.response.statusLine.statusCode, ex.response.statusLine.reasonPhrase, ex)
        } catch (ex: Exception) {
            throw MetadataException(ex)
        }
    }

    override fun searchByMatchAll(index: String, bucket: String): MetadataSearchResponse {
        return searchByMatchAllHelper("/$index/$bucket/_search")
    }

    override fun searchByMatchAll(index: String): MetadataSearchResponse {
        return searchByMatchAllHelper("/$index/_search")
    }

    override fun searchByMatchAll(): MetadataSearchResponse {
        return searchByMatchAllHelper("/_search")
    }

    private fun searchByMatchAllHelper(endpoint: String): MetadataSearchResponse {
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

            val metadataSearchHit = MetadataSearchHits(
                    elasticSearchResponse.hits.numberOfHits, elasticSearchResponse.hits.hits.map {
                (index, type, id, score, source) ->
                MetadataSearchHitsNode(index, type, id, score, source)
            }
            )

            return MetadataSearchResponse(elasticSearchResponse.took, metadataSearchHit)
        } catch (ex: ResponseException) {
            throw MetadataException(ex.response.statusLine.statusCode, ex.response.statusLine.reasonPhrase, ex)
        } catch (ex: Exception) {
            throw MetadataException(ex)
        }
    }

    private fun getMetadataString(metadata: Map<String, String>): String {
        return metadata.entries
                .stream()
                .map({ entry -> "\"${entry.key}\" : \"${entry.value}\"" })
                .toArray()
                .joinToString(", ")
    }

    override fun closeConnection() {
        restClient.close()
    }
}