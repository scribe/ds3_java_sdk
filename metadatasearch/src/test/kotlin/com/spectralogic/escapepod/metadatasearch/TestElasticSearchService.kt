package com.spectralogic.escapepod.metadatasearch

import com.google.common.collect.ImmutableMap
import com.spectralogic.escapepod.api.MetadataIndex
import com.spectralogic.escapepod.api.MetadataSearchHitsNode
import com.spectralogic.escapepod.metadatasearch.api.ElasticSearchMetadataService
import org.apache.http.HttpHost
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.fail
import org.elasticsearch.client.RestClient
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import java.util.concurrent.TimeUnit

class TestElasticSearchService {

    companion object {
        //        private val LOG = LoggerFactory.getLogger(TestElasticSearchService::class.java)
        lateinit internal var metadataSearchService: ElasticSearchMetadataService

        @BeforeClass @JvmStatic
        fun beforeClass() {
            val restClient = RestClient.builder(*arrayOf(
                    HttpHost("localhost", 9200),
                    HttpHost("localhost", 9201))).build()
            metadataSearchService = ElasticSearchService(restClient)
        }

        @AfterClass @JvmStatic
        fun afterClass() {
            metadataSearchService.closeConnection()
        }
    }

    @Test
    fun testHealth() {
        val single = metadataSearchService.health()
        val expected: String = "green"

        val MetadataSearchHealthResponse = single.filter {
            health ->
            health.status == expected
        }.blockingGet()

        if (MetadataSearchHealthResponse == null) {
            fail("Expected cluster status to be $expected")
        }
    }


    @Test
    fun testCreateIndexWithDefaultValues() {
        val index = "test_create_index_with_default_values"
        try {
            metadataSearchService.createIndex(index).subscribe()

            val observable = metadataSearchService.getAllIndices()
            val expected = MetadataIndex(index, 5, 2, 0)

            assertThat(observable.contains(expected).blockingGet()).isTrue()
        } finally {
            metadataSearchService.deleteIndex(index).subscribe()
        }
    }

    @Test
    fun testCreateIndexWithValues() {
        val index = "test_create_index_with_values"
        try {
            metadataSearchService.createIndex(index, 8, 7).subscribe()

            val observable = metadataSearchService.getAllIndices()
            val expected = MetadataIndex(index, 8, 7, 0)

            assertThat(observable.contains(expected).blockingGet()).isTrue()
        } finally {
            metadataSearchService.deleteIndex(index).subscribe()
        }
    }

    @Test
    fun testUpdateIndexNumberOfReplicas() {
        val index = "test_update_index_number_of_replicas"
        try {
            metadataSearchService.createIndex(index).subscribe()
            var observable = metadataSearchService.getAllIndices()
            var expected = MetadataIndex(index, 5, 2, 0)
            assertThat(observable.contains(expected).blockingGet()).isTrue()

            metadataSearchService.updateIndexNumberOfReplicas(index, 9).subscribe()

            observable = metadataSearchService.getAllIndices()
            expected = MetadataIndex(index, 5, 9, 0)
            assertThat(observable.contains(expected).blockingGet()).isTrue()
        } finally {
            metadataSearchService.deleteIndex(index).subscribe()
        }
    }

    @Test
    fun testIndexDocument() {
        val index = "test_index"
        val bucket = "test_bucket"
        val fileName = "test_file"
        val metadata = ImmutableMap.of<String, String>("m1", "v1", "m2", "v2")
        try {
            metadataSearchService.indexDocument(index, bucket, fileName, metadata).subscribe()

            //we need to wait for the new document to be available
            TimeUnit.SECONDS.sleep(5)

            val observable = metadataSearchService.getAllIndices()
            val expected = MetadataIndex(index, 5, 1, 1)
            assertThat(observable.contains(expected).blockingGet()).isTrue()
        } finally {
            metadataSearchService.deleteIndex(index).subscribe()
        }
    }

    @Test
    fun testDeleteIndex() {
        val index = "test_delete_index"
        metadataSearchService.createIndex(index).subscribe()
        var observable = metadataSearchService.getAllIndices()
        var expected = MetadataIndex(index, 5, 2, 0)
        assertThat(observable.contains(expected).blockingGet()).isTrue()

        metadataSearchService.deleteIndex(index).subscribe()
        observable = metadataSearchService.getAllIndices()
        expected = MetadataIndex(index, 5, 2, 0)
        assertThat(observable.contains(expected).blockingGet()).isFalse()
    }

    @Test
    fun testDeleteFile() {
        val index = "test_delete_file"
        val bucket = "test_bucket"
        val fileName = "test_file"
        val metadata = ImmutableMap.of<String, String>("m1", "v1", "m2", "v2")

        try {
            metadataSearchService.indexDocument(index, bucket, fileName, metadata).subscribe()
            TimeUnit.SECONDS.sleep(5)

            var observable = metadataSearchService.getAllIndices()
            var expected = MetadataIndex(index, 5, 1, 1)
            assertThat(observable.contains(expected).blockingGet()).isTrue()

            metadataSearchService.deleteDocument(index, bucket, fileName).subscribe()
            TimeUnit.SECONDS.sleep(5)

            observable = metadataSearchService.getAllIndices()
            expected = MetadataIndex(index, 5, 1, 0)
            assertThat(observable.contains(expected).blockingGet()).isTrue()
        } finally {
            metadataSearchService.deleteIndex(index).subscribe()
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
            metadataSearchService.indexDocument(index1, bucket1, fileName, metadata).subscribe()
            metadataSearchService.indexDocument(index1, bucket2, fileName, metadata).subscribe()
            metadataSearchService.indexDocument(index2, bucket1, fileName, metadata).subscribe()

            TimeUnit.SECONDS.sleep(5)

            var observable = metadataSearchService.searchById(index1, bucket1, fileName)
            assertThat(observable.count().blockingGet()).isEqualTo(1)

            observable = metadataSearchService.searchById(index1, bucket2, fileName)
            assertThat(observable.count().blockingGet()).isEqualTo(1)

            observable = metadataSearchService.searchById(index1, fileName)
            assertThat(observable.count().blockingGet()).isEqualTo(2)

            observable = metadataSearchService.searchById(fileName)
            assertThat(observable.count().blockingGet()).isEqualTo(3)
        } finally {
            metadataSearchService.deleteIndex(index1).subscribe()
            metadataSearchService.deleteIndex(index2).subscribe()
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
            metadataSearchService.indexDocument(index1, bucket1, fileName, metadata).subscribe()
            metadataSearchService.indexDocument(index1, bucket2, fileName, metadata).subscribe()
            metadataSearchService.indexDocument(index2, bucket1, fileName, metadata).subscribe()

            TimeUnit.SECONDS.sleep(5)

            var observable = metadataSearchService.searchByMetadata(index1, bucket1, "m1", "v1")
            assertThat(observable.count().blockingGet()).isEqualTo(1)

            observable = metadataSearchService.searchByMetadata(index1, bucket2, "m1", "v1")
            assertThat(observable.count().blockingGet()).isEqualTo(1)

            observable = metadataSearchService.searchByMetadata(index1, "m1", "v1")
            assertThat(observable.count().blockingGet()).isEqualTo(2)

            observable = metadataSearchService.searchByMetadata("m1", "v1")
            assertThat(observable.count().blockingGet()).isEqualTo(3)
        } finally {
            metadataSearchService.deleteIndex(index1).subscribe()
            metadataSearchService.deleteIndex(index2).subscribe()
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
            metadataSearchService.indexDocument(index1, bucket1, fileName, metadata).subscribe()
            metadataSearchService.indexDocument(index1, bucket2, fileName, metadata).subscribe()
            metadataSearchService.indexDocument(index2, bucket1, fileName, metadata).subscribe()

            TimeUnit.SECONDS.sleep(5)

            var observable = metadataSearchService.searchByMatchAll(index1, bucket1)
            assertThat(observable.count().blockingGet()).isEqualTo(1)

            var expected = MetadataSearchHitsNode(index1, bucket1, fileName, 1.0, metadata)
            assertThat(observable.contains(expected).blockingGet()).isTrue()

            observable = metadataSearchService.searchByMatchAll(index1, bucket2)
            assertThat(observable.count().blockingGet()).isEqualTo(1)

            expected = MetadataSearchHitsNode(index1, bucket2, fileName, 1.0, metadata)
            assertThat(observable.contains(expected).blockingGet()).isTrue()

            observable = metadataSearchService.searchByMatchAll(index1)
            assertThat(observable.count().blockingGet()).isEqualTo(2)

            val expected1 = MetadataSearchHitsNode(index1, bucket1, fileName, 1.0, metadata)
            val expected2 = MetadataSearchHitsNode(index1, bucket2, fileName, 1.0, metadata)
            assertThat(observable.contains(expected1).blockingGet()).isTrue()
            assertThat(observable.contains(expected2).blockingGet()).isTrue()

            observable = metadataSearchService.searchByMatchAll(index2)
            assertThat(observable.count().blockingGet()).isEqualTo(1)

            expected = MetadataSearchHitsNode(index2, bucket1, fileName, 1.0, metadata)
            assertThat(observable.contains(expected).blockingGet()).isTrue()

            observable = metadataSearchService.searchByMatchAll()
            assertThat(observable.count().blockingGet()).isGreaterThanOrEqualTo(3) //could be more than 3 if there was data before the test
        } finally {
            metadataSearchService.deleteIndex(index1).subscribe()
            metadataSearchService.deleteIndex(index2).subscribe()
        }
    }
}