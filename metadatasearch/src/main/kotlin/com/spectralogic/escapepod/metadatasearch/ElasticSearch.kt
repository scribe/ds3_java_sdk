package com.spectralogic.escapepod.metadatasearch

import com.spectralogic.escapepod.api.MetadataSearchApi
import com.spectralogic.escapepod.api.MetadataSearchHealthResponse
import com.spectralogic.escapepod.api.MetadataSearchIndicesResponse
import com.spectralogic.escapepod.api.MetadataSearchResponse
import com.spectralogic.escapepod.metadatasearch.modle.ElasticSearchHealthResponse
import com.spectralogic.escapepod.util.JsonMapping
import com.spectralogic.escapepod.util.ReadFileFromResources
import org.apache.http.HttpHost
import org.apache.http.entity.ContentType
import org.apache.http.nio.entity.NStringEntity
import org.apache.http.util.EntityUtils
import org.elasticsearch.client.RestClient
import java.util.*

class ElasticSearch : MetadataSearchApi {
    var restClient: RestClient

    constructor(httpHosts: List<HttpHost>) {
        restClient = RestClient.builder(*httpHosts.toTypedArray()).build()
    }

    constructor(restClient: RestClient) {
        this.restClient = restClient
    }

    override fun health(): MetadataSearchHealthResponse {
        val response = restClient.performRequest(
                "GET",
                "/_cluster/health",
                Collections.singletonMap("pretty", "true"))

        //TODO in case of a failure, rerun an exaction

        val elasticSearchHealthResponse = JsonMapping.fromJson(EntityUtils.toString(response.entity).byteInputStream(),
                ElasticSearchHealthResponse::class.java)

        return MetadataSearchHealthResponse(elasticSearchHealthResponse.clusterName, elasticSearchHealthResponse.status)

    }

    override fun createIndex(index: String, numberOfShard: Int, numberOfReplicas: Int) {
        val response =  restClient.performRequest(
                "PUT",
                index,
                Collections.singletonMap("pretty", "true"),
                NStringEntity(String.format(ReadFileFromResources.readFile("elasticsearch/index/createIndex.json"),
                        numberOfShard, numberOfReplicas), ContentType.APPLICATION_JSON)
        )

        //TODO in case of a failure, rerun an exaction
    }

    override fun updateIndexNumberOfReplicas(index: String, numberOfReplicas: Int) {
        val response = restClient.performRequest(
                "PUT",
                "/$index/_settings",
                Collections.singletonMap("pretty", "true"),
                NStringEntity(String.format(ReadFileFromResources.readFile("elasticsearch/index/updateIndexNumberOfReplicas.json"),
                        numberOfReplicas), ContentType.APPLICATION_JSON)
        )

        //TODO in case of a failure, rerun an exaction
    }

    override fun getAllIndices(): MetadataSearchIndicesResponse {
        val response = restClient.performRequest(
                "GET",
                "/_cat/indices"
        )

        //TODO in case of a failure, rerun an exaction

        return MetadataSearchIndicesResponse()
    }

    private fun ensureIndexExists(index: String) {
        val response = restClient.performRequest("HEAD", "/$index")
        if (response.statusLine.statusCode != 200){
            createIndex(index)
        }
    }

    override fun indexDocument(index: String, bucket: String, id: String, metadata: Map<String, String>) {
        val response = indexDocumentHelper(index, bucket, id, metadata, "PUT")

        //TODO in case of a failure, rerun an exaction
    }

    override fun updateIndexedDocument(index: String, bucket: String, id: String, metadata: Map<String, String>) {
        val response = indexDocumentHelper(index, bucket, id, metadata, "POST")

        //TODO in case of a failure, rerun an exaction
    }

    private fun indexDocumentHelper(index: String, bucket: String, id: String, metadata: Map<String, String>,
                                    method: String) {
        ensureIndexExists(index)

        val metadataString = getMetadataString(metadata)

        val entity = NStringEntity(String.format(ReadFileFromResources.readFile("elasticsearch/index/indexFile.json"), metadataString),
                ContentType.APPLICATION_JSON)

        val response = restClient.performRequest(
                method,
                "/$index/$bucket/$id",
                Collections.singletonMap("pretty", "true"),
                entity)

        //TODO in case of a failure, rerun an exaction
    }

    override fun deleteDocument(index: String, bucket: String, id: String) {
        val response = deleteHelper("/$index/$bucket/$id")

        //TODO in case of a failure, rerun an exaction
    }

    override fun deleteIndex(index: String) {
        val response = deleteHelper("/$index")

        //TODO in case of a failure, rerun an exaction
    }

    private fun deleteHelper(endpoint: String) {
        val response = restClient.performRequest(
                "DELETE",
                endpoint,
                Collections.singletonMap("pretty", "true")
        )

        //TODO in case of a failure, rerun an exaction
    }

    override fun searchById(index: String, bucket: String, id: String): MetadataSearchResponse {
        val response = searchByIdHelper("/$index/$bucket/_search", id)

        //TODO in case of a failure, rerun an exaction

        return MetadataSearchResponse()
    }

    override fun searchById(index: String, id: String): MetadataSearchResponse {
        return searchByIdHelper("/$index/_search", id)
    }

    override fun searchById(id: String): MetadataSearchResponse {
        return searchByIdHelper("/_search", id)
    }

    private fun searchByIdHelper(endpoint: String, id: String): MetadataSearchResponse {
        val response = restClient.performRequest(
                "GET",
                endpoint,
                Collections.singletonMap("pretty", "true"),
                NStringEntity(String.format(ReadFileFromResources.readFile("elasticsearch/search/searchById.json"), id),
                        ContentType.APPLICATION_JSON)
        )

        //TODO in case of a failure, rerun an exaction

        return MetadataSearchResponse()
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
        val response = restClient.performRequest(
                "GET",
                endpoint,
                Collections.singletonMap("pretty", "true"),
                NStringEntity(String.format(ReadFileFromResources.readFile("elasticsearch/search/searchByMetadata.json"),
                        key, value), ContentType.APPLICATION_JSON)
        )

        //TODO in case of a failure, rerun an exaction

        return MetadataSearchResponse()
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
        val response = restClient.performRequest(
                "GET",
                endpoint,
                Collections.singletonMap("pretty", "true"),
                NStringEntity(ReadFileFromResources.readFile("elasticsearch/search/searchByMatchAll.json"), ContentType.APPLICATION_JSON)
        )

        //TODO in case of a failure, rerun an exaction

        return MetadataSearchResponse()
    }

    private fun getMetadataString(metadata: Map<String, String>): String {
        return metadata.entries
                .stream()
                .map({entry -> "\"${entry.key}\" : \"${entry.value}\""})
                .toArray()
                .joinToString(", ")
    }

    override fun closeConnection() {
        restClient.close()
    }
}