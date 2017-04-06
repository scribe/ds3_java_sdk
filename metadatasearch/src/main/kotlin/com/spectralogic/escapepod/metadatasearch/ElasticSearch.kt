package com.spectralogic.escapepod.metadatasearch

import com.google.common.collect.ImmutableMap
import com.spectralogic.escapepod.util.ReadFileFromResources
import org.apache.http.HttpHost
import org.apache.http.entity.ContentType
import org.apache.http.nio.entity.NStringEntity
import org.apache.http.util.EntityUtils
import org.elasticsearch.client.Response
import org.elasticsearch.client.RestClient
import java.util.*
import java.util.concurrent.TimeUnit


class ElasticSearch : MetadataSearchApi {
    var restClient: RestClient

    constructor(httpHosts: List<HttpHost>) {
        restClient = RestClient.builder(*httpHosts.toTypedArray()).build()
    }

    constructor(restClient: RestClient) {
        this.restClient = restClient
    }

    override fun health(): Response {
        return restClient.performRequest(
                "GET",
                "/_cluster/health",
                Collections.singletonMap("pretty", "true"))
    }

    override fun createIndex(index: String, numberOfShard: Int, numberOfReplicas: Int): Response {
        return restClient.performRequest(
                "PUT",
                index,
                Collections.singletonMap("pretty", "true"),
                NStringEntity(String.format(ReadFileFromResources.readFile("elasticsearch/index/createIndex.json"),
                        numberOfShard, numberOfReplicas), ContentType.APPLICATION_JSON)
        )
    }

    override fun updateIndexNumberOfReplicas(index: String, numberOfReplicas: Int): Response {
        return restClient.performRequest(
                "PUT",
                "/$index/_settings",
                Collections.singletonMap("pretty", "true"),
                NStringEntity(String.format(ReadFileFromResources.readFile("elasticsearch/index/updateIndexNumberOfReplicas.json"),
                        numberOfReplicas), ContentType.APPLICATION_JSON)
        )
    }

    override fun getAllIndices(): Response {
        return restClient.performRequest(
                "GET",
                "/_cat/indices"
        )
    }

    private fun ensureIndexExists(index: String) {
        val response = restClient.performRequest("HEAD", "/$index")
        if (response.statusLine.statusCode != 200){
            createIndex(index)
        }
    }

    override fun indexDocument(index: String, bucket: String, id: String, metadata: Map<String, String>): Response {
        return indexDocumentHelper(index, bucket, id, metadata, "PUT")
    }

    override fun updateIndexedDocument(index: String, bucket: String, id: String, metadata: Map<String, String>): Response {
        return indexDocumentHelper(index, bucket, id, metadata, "POST")
    }

    private fun indexDocumentHelper(index: String, bucket: String, id: String, metadata: Map<String, String>, method:
    String): Response {
        ensureIndexExists(index)

        val metadataString = getMetadataString(metadata)

        val entity = NStringEntity(String.format(ReadFileFromResources.readFile("elasticsearch/index/indexFile.json"), metadataString),
                ContentType.APPLICATION_JSON)

        return restClient.performRequest(
                method,
                "/$index/$bucket/$id",
                Collections.singletonMap("pretty", "true"),
                entity)
    }

    override fun deleteDocument(index: String, bucket: String, id: String): Response {
        return deleteHelper("/$index/$bucket/$id")
    }

    override fun deleteIndex(index: String): Response {
        return deleteHelper("/$index")
    }

    private fun deleteHelper(endpoint: String): Response {
        return restClient.performRequest(
                "DELETE",
                endpoint,
                Collections.singletonMap("pretty", "true")
        )
    }

    override fun searchById(index: String, bucket: String, id: String): Response {
        return searchByIdHelper("/$index/$bucket/_search", id)
    }

    override fun searchById(index: String, id: String): Response {
        return searchByIdHelper("/$index/_search", id)
    }

    override fun searchById(id: String): Response {
        return searchByIdHelper("/_search", id)
    }

    private fun searchByIdHelper(endpoint: String, id: String): Response {
        return restClient.performRequest(
                "GET",
                endpoint,
                Collections.singletonMap("pretty", "true"),
                NStringEntity(String.format(ReadFileFromResources.readFile("elasticsearch/search/searchById.json"), id),
                        ContentType.APPLICATION_JSON)
        )
    }

    override fun searchByMetadata(index: String, bucket: String, key: String, value: String): Response {
        return searchByMetadataHelper("/$index/$bucket/_search", key, value)
    }

    override fun searchByMetadata(index: String, key: String, value: String): Response {
        return searchByMetadataHelper("/$index/_search", key, value)
    }

    override fun searchByMetadata(key: String, value: String): Response {
        return searchByMetadataHelper("/_search", key, value)
    }

    private fun searchByMetadataHelper(endpoint: String, key: String, value: String): Response {
        return restClient.performRequest(
                "GET",
                endpoint,
                Collections.singletonMap("pretty", "true"),
                NStringEntity(String.format(ReadFileFromResources.readFile("elasticsearch/search/searchByMetadata.json"),
                        key, value), ContentType.APPLICATION_JSON)
        )
    }

    override fun searchByMatchAll(index: String, bucket: String): Response {
        return searchByMatchAllHelper("/$index/$bucket/_search")
    }

    override fun searchByMatchAll(index: String): Response {
        return searchByMatchAllHelper("/$index/_search")
    }

    override fun searchByMatchAll(): Response {
        return searchByMatchAllHelper("/_search")
    }

    private fun searchByMatchAllHelper(endpoint: String): Response {
        return restClient.performRequest(
                "GET",
                endpoint,
                Collections.singletonMap("pretty", "true"),
                NStringEntity(ReadFileFromResources.readFile("elasticsearch/search/searchByMatchAll.json"), ContentType.APPLICATION_JSON)
        )
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

//TODO delete all of this play code
fun main(array: Array<String>) {
    println("Start ElasticSearch client with 2 cluster server [localhost:9200, localhost:9201]")
    val searchClient = ElasticSearch(listOf(
            HttpHost("localhost", 9200),
            HttpHost("localhost", 9201)))

    try {
        health(searchClient)

        val index = "2u-11"
        val bucket = "test_bucket_4"

//        createIndex(searchClient, index,  10, 5)
//        deleteIndex(searchClient, index)
//        updateIndexNumberOfReplicas(searchClient, indexDocument, 7)
//        indexDocument(searchClient, index, bucket)
        val fileName = "a26e528f-cfd0-42d1-a6ae-a3cbef13ab10"
//        updateIndexedDocument(searchClient, index, bucket, fileName)
//        searchById(searchClient, index, bucket, fileName)
//        searchById(searchClient, fileName)
//        searchByMetadata(searchClient, index, bucket, "m3", "v3")
//        searchByMetadata(searchClient, index, "m1", "v1.2")
//        searchByMetadata(searchClient, "m1", "v1.2")
//        searchByMatchAll(searchClient, index, bucket)
//        searchByMatchAll(searchClient, index)
        searchByMatchAll(searchClient)
    } catch (e: Exception) {
        println(e)
    } finally {
        println("Close the connection to elastic searchById.json client")
        searchClient.closeConnection()
    }
}

fun searchByMatchAll(searchClient: ElasticSearch, index: String, bucket: String) {
    val response = searchClient.searchByMatchAll(index, bucket)
    println("$response \nentity: ${EntityUtils.toString(response.entity)}")
}

fun searchByMatchAll(searchClient: ElasticSearch, index: String) {
    val response = searchClient.searchByMatchAll(index)
    println("$response \nentity: ${EntityUtils.toString(response.entity)}")
}

fun searchByMatchAll(searchClient: ElasticSearch) {
    val response = searchClient.searchByMatchAll()
    println("$response \nentity: ${EntityUtils.toString(response.entity)}")
}

fun searchByMetadata(searchClient: ElasticSearch, index: String, bucket: String, key: String, value: String) {
    val response = searchClient.searchByMetadata(index, bucket, key, value)
    println("$response \nentity: ${EntityUtils.toString(response.entity)}")
}

fun searchByMetadata(searchClient: ElasticSearch, index: String, key: String, value: String) {
    val response = searchClient.searchByMetadata(index, key, value)
    println("$response \nentity: ${EntityUtils.toString(response.entity)}")
}

fun searchByMetadata(searchClient: ElasticSearch, key: String, value: String) {
    val response = searchClient.searchByMetadata(key, value)
    println("$response \nentity: ${EntityUtils.toString(response.entity)}")
}

fun updateIndexedDocument(searchClient: ElasticSearch, index: String, bucket: String, fileName: String) {
    val metadata = ImmutableMap.of("m1", "v1", "m2", "v2", "m3", "v3")
    val response = searchClient.updateIndexedDocument(index, bucket, fileName, metadata)
    println("$response \nentity: ${EntityUtils.toString(response.entity)}")
}

fun deleteIndex(searchClient: ElasticSearch, index: String) {
    val response = searchClient.deleteIndex(index)
    println("$response \nentity: ${EntityUtils.toString(response.entity)}")
}

fun updateIndexNumberOfReplicas(metadataSearchApi: MetadataSearchApi, index: String, numberOfReplicas: Int) {
    val response = metadataSearchApi.updateIndexNumberOfReplicas(index, numberOfReplicas)
    println("$response \nentity: ${EntityUtils.toString(response.entity)}")
}

fun createIndex(metadataSearchApi: MetadataSearchApi, index: String, numberOfShards: Int, numberOfReplicas: Int) {
    val response = metadataSearchApi.createIndex(index, numberOfShards, numberOfReplicas)
    println("$response \nentity: ${EntityUtils.toString(response.entity)}")
}

private fun searchById(metadataSearchApi: MetadataSearchApi, index: String, bucket: String, id: String) {
    val response = metadataSearchApi.searchById(index, bucket, id)
    println("$response \nentity: ${EntityUtils.toString(response.entity)}")
}

private fun searchById(metadataSearchApi: MetadataSearchApi, index: String, id: String) {
    val response = metadataSearchApi.searchById(index, id)
    println("$response \nentity: ${EntityUtils.toString(response.entity)}")
}

private fun searchById(metadataSearchApi: MetadataSearchApi, id: String) {
    val response = metadataSearchApi.searchById(id)
    println("$response \nentity: ${EntityUtils.toString(response.entity)}")
}

private fun indexDocument(metadataSearchApi: MetadataSearchApi, index: String, bucket: String) {
    //indexDocument a document
    val uuid = UUID.randomUUID().toString()
    val metadata = ImmutableMap.of("m1", "v1.2", "m2", "v2.2", "test", "true")

    val response = metadataSearchApi.indexDocument(index, bucket, uuid, metadata)
    println("$response \nentity: ${EntityUtils.toString(response.entity)}")

    println("Sleep for 5 sec (Near Real Time)")
    TimeUnit.SECONDS.sleep(5)
}

private fun health(metadataSearchApi: MetadataSearchApi) {
    val response = metadataSearchApi.health()
    println("$response \nentity: ${EntityUtils.toString(response.entity)}")
}