package com.spectralogic.escapepod.metadatasearch.integration

import com.google.common.collect.ImmutableMap
import com.spectralogic.escapepod.api.MetadataSearchApi
import com.spectralogic.escapepod.metadatasearch.ElasticSearch
import org.apache.http.HttpHost
import org.elasticsearch.client.RestClient
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import org.slf4j.LoggerFactory
import java.util.concurrent.TimeUnit

class TestElasticSearch {

    companion object {
        private val LOG = LoggerFactory.getLogger(TestElasticSearch::class.java)
        private val indexPattern = "%s\\s+\\S+\\s+%d %d %d %d"
        private val searchPattern ="\"hits\" : {\n    \"total\" : %d"
        lateinit var elasticSearch: MetadataSearchApi

        @BeforeClass @JvmStatic
        fun beforeClass() {
            val restClient = RestClient.builder(*arrayOf(
                    HttpHost("localhost", 9200),
                    HttpHost("localhost", 9201))).build()
            elasticSearch = ElasticSearch(restClient)
        }

        @AfterClass @JvmStatic
        fun afterClass() {
            elasticSearch.closeConnection()
        }
    }

    @Test
    fun testCreateIndexWithDefaultValues() {
        val index = "test_create_index_with_default_values"
        try {
            elasticSearch.createIndex(index)

            val response = elasticSearch.getAllIndices()
//            assertThat(EntityUtils.toString(response.entity)).containsPattern(
//                    String.format(indexPattern, index, 5, 2, 0, 0))
        } finally {
            elasticSearch.deleteIndex(index)
        }
    }

    @Test
    fun testCreateIndexWithValues() {
        val index = "test_create_index_with_values"
        try {
            elasticSearch.createIndex(index, 8, 7)

            val response = elasticSearch.getAllIndices()
//            assertThat(EntityUtils.toString(response.entity)).containsPattern(
//                    String.format(indexPattern, index, 8, 7, 0, 0))
        } finally {
            elasticSearch.deleteIndex(index)
        }
    }

    @Test
    fun testUpdateIndexNumberOfReplicas() {
        val index = "test_update_index_number_of_replicas"
        try {
            elasticSearch.createIndex(index)
            var response = elasticSearch.getAllIndices()
//            assertThat(EntityUtils.toString(response.entity)).containsPattern(
//                    String.format(indexPattern, index, 5, 2, 0, 0))

            elasticSearch.updateIndexNumberOfReplicas(index, 9)

            response = elasticSearch.getAllIndices()
//            assertThat(EntityUtils.toString(response.entity)).containsPattern(
//                    String.format(indexPattern, index, 5, 9, 0, 0))
        } finally {
            elasticSearch.deleteIndex(index)
        }
    }

    @Test
    fun testIndexDocument() {
        val index = "test_index"
        val bucket = "test_bucket"
        val fileName = "test_file"
        val metadata = ImmutableMap.of<String, String>("m1", "v1", "m2", "v2")
        try {
            elasticSearch.indexDocument(index, bucket, fileName, metadata)

            //we need to wait for the new document to be available
            TimeUnit.SECONDS.sleep(5)

            val response = elasticSearch.getAllIndices()
//            assertThat(EntityUtils.toString(response.entity)).containsPattern(
//                    String.format(indexPattern, index, 5, 2, 1, 0))

        } finally {
            elasticSearch.deleteIndex(index)
        }
    }

    @Test
    fun testDeleteIndex() {
        val index = "test_delete_index"
        elasticSearch.createIndex(index)
        var response = elasticSearch.getAllIndices()
//        assertThat(EntityUtils.toString(response.entity)).containsPattern(
//                String.format(indexPattern, index, 5, 2, 0, 0))

        elasticSearch.deleteIndex(index)
        response = elasticSearch.getAllIndices()
//        assertThat(EntityUtils.toString(response.entity)).doesNotContain(
//                String.format(indexPattern, index, 5, 2, 0, 0))
    }

    @Test
    fun testDeleteFile() {
        val index = "test_delete_file"
        val bucket = "test_bucket"
        val fileName = "test_file"
        val metadata = ImmutableMap.of<String, String>("m1", "v1", "m2", "v2")

        try {
            elasticSearch.indexDocument(index, bucket, fileName, metadata)
            TimeUnit.SECONDS.sleep(5)

            var response = elasticSearch.getAllIndices()
//            assertThat(EntityUtils.toString(response.entity)).containsPattern(
//                    String.format(indexPattern, index, 5, 2, 1, 0))

            elasticSearch.deleteDocument(index, bucket, fileName)
            TimeUnit.SECONDS.sleep(5)

            response = elasticSearch.getAllIndices()
//            assertThat(EntityUtils.toString(response.entity)).containsPattern(
//                    String.format(indexPattern, index, 5, 2, 0, 0))

        } finally {
            elasticSearch.deleteIndex(index)
        }
    }

    @Test
    fun testSearchById() {
        val index1 = "test_search_by_id_1"
        val index2 = "test_search_by_id_2"
        val bucket1 = "test_bucket_1"
        val bucket2 = "test_bucket_2"
        val fileName = "test_file"
        val metadata = ImmutableMap.of<String, String>("m1", "v1", "m2", "v2")

        try {
            elasticSearch.indexDocument(index1, bucket1, fileName, metadata)
            elasticSearch.indexDocument(index1, bucket2, fileName, metadata)
            elasticSearch.indexDocument(index2, bucket1, fileName, metadata)

            TimeUnit.SECONDS.sleep(5)

            var response = elasticSearch.searchById(index1, bucket1, fileName)
//            assertThat(EntityUtils.toString(response.entity)).contains(
//                    String.format(searchPattern, 1))

            response = elasticSearch.searchById(index1, bucket2, fileName)
//            assertThat(EntityUtils.toString(response.entity)).contains(
//                    String.format(searchPattern, 1))

            response = elasticSearch.searchById(index1,fileName)
//            assertThat(EntityUtils.toString(response.entity)).contains(
//                    String.format(searchPattern, 2))

            response = elasticSearch.searchById(fileName)
//            assertThat(EntityUtils.toString(response.entity)).contains(
//                    String.format(searchPattern, 3))

        } finally {
            elasticSearch.deleteIndex(index1)
            elasticSearch.deleteIndex(index2)
        }
    }

    @Test
    fun testSearchByMetadata() {
        val index1 = "test_search_by_metadata_1"
        val index2 = "test_search_by_metadata_2"
        val bucket1 = "test_bucket_1"
        val bucket2 = "test_bucket_2"
        val fileName = "test_file"
        val metadata = ImmutableMap.of<String, String>("m1", "v1", "m2", "v2")

        try {
            elasticSearch.indexDocument(index1, bucket1, fileName, metadata)
            elasticSearch.indexDocument(index1, bucket2, fileName, metadata)
            elasticSearch.indexDocument(index2, bucket1, fileName, metadata)

            TimeUnit.SECONDS.sleep(5)

            var response = elasticSearch.searchByMetadata(index1, bucket1, "m1", "v1")
//            assertThat(EntityUtils.toString(response.entity)).contains(
//                    String.format(searchPattern, 1))

            response = elasticSearch.searchByMetadata(index1, bucket2, "m1", "v1")
//            assertThat(EntityUtils.toString(response.entity)).contains(
//                    String.format(searchPattern, 1))

            response = elasticSearch.searchByMetadata(index1, "m1", "v1")
//            assertThat(EntityUtils.toString(response.entity)).contains(
//                    String.format(searchPattern, 2))

            response = elasticSearch.searchByMetadata("m1", "v1")
//            assertThat(EntityUtils.toString(response.entity)).contains(
//                    String.format(searchPattern, 3))

        } finally {
            elasticSearch.deleteIndex(index1)
            elasticSearch.deleteIndex(index2)
        }
    }

    @Test
    fun testSearchByMatchAll() {
        val index1 = "test_search_by_match_all_1"
        val index2 = "test_search_by_match_all_2"
        val bucket1 = "test_bucket_1"
        val bucket2 = "test_bucket_2"
        val fileName = "test_file"
        val metadata = ImmutableMap.of<String, String>("m1", "v1", "m2", "v2")

        try {
            elasticSearch.indexDocument(index1, bucket1, fileName, metadata)
            elasticSearch.indexDocument(index1, bucket2, fileName, metadata)
            elasticSearch.indexDocument(index2, bucket1, fileName, metadata)

            TimeUnit.SECONDS.sleep(5)

            var response = elasticSearch.searchByMatchAll(index1, bucket1)
//            assertThat(EntityUtils.toString(response.entity)).contains(
//                    String.format(searchPattern, 1))

            response = elasticSearch.searchByMatchAll(index1, bucket2)
//            assertThat(EntityUtils.toString(response.entity)).contains(
//                    String.format(searchPattern, 1))

            response = elasticSearch.searchByMatchAll(index1)
//            assertThat(EntityUtils.toString(response.entity)).contains(
//                    String.format(searchPattern, 2))

            response = elasticSearch.searchByMatchAll(index2)
//            assertThat(EntityUtils.toString(response.entity)).contains(
//                    String.format(searchPattern, 1))

        } finally {
            elasticSearch.deleteIndex(index1)
            elasticSearch.deleteIndex(index2)
        }
    }
}