package com.spectralogic.escapepod.api

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface MetadataSearchServiceProvider : ServiceProvider<MetadataSearchService> {
    fun createNewMetadataSearchCluster(): Completable
    fun joinMetadataSearchCluster(): Completable
    fun metadataSearchNodeJoinedEvent(): Completable
    fun leaveMetadataSearchCluster(): Completable
    fun clusterHandler(event: ClusterEvent)
}

interface MetadataSearchService {
    /***
     * Query the health of the cluster
     * @return
     */
    fun health(): Single<MetadataSearchHealthResponse>

    /***
     * Create an index in the underline search provider with a default of 5 shards and 2 replicas
     * @param numberOfShard
     * @param numberOfReplicas
     * @return
     */
    fun createIndex(index: String, numberOfShard: Int = 5, numberOfReplicas: Int = 2)

    /***
     * Update the number of replicas for the given index
     * @param index
     * @param numberOfReplicas
     * @return
     */
    fun updateIndexNumberOfReplicas(index: String, numberOfReplicas: Int)

    /***
     * Get all the indices in the system
     */
    fun getAllIndices(): Observable<MetadataIndex>

    /***
     * Delete the given index
     * @param index
     * @return
     */
    fun deleteIndex(index: String)

    /***
     * Delete a document from a bucket
     * @param index
     * @param bucket
     * @param id
     */
    fun deleteDocument(index: String, bucket: String, id: String)

    /***
     * Index a document
     * @param index
     * @param bucket
     * @param id
     * @param metadata
     * @return
     */
    fun indexDocument(index: String, bucket: String, id: String, metadata: Map<String, String>)

    /***
     * Update an index document
     * @param index
     * @param bucket
     * @param id
     * @param metadata
     * @return
     */
    fun updateIndexedDocument(index: String, bucket: String, id: String, metadata: Map<String, String>)

    /***
     * Search by id in a bucket
     * @param index
     * @param bucket
     * @param id
     * @return
     */
    fun searchById(index: String, bucket: String, id: String): MetadataSearchResponse

    /***
     * Search by id in all the buckets
     * @param index
     * @param id
     * @return
     */
    fun searchById(index: String, id: String): MetadataSearchResponse

    /***
     * Search by id in all the system
     * @param id
     */
    fun searchById(id: String): MetadataSearchResponse

    /***
     * Search by metadata in a bucket
     * @param index
     * @param bucket
     * @param key
     * @param value
     * @return
     */
    fun searchByMetadata(index: String, bucket: String, key: String, value: String): MetadataSearchResponse

    /***
     * Search by metadata in all the buckets
     * @param index
     * @param key
     * @param value
     * @return
     */
    fun searchByMetadata(index: String, key: String, value: String):  MetadataSearchResponse

    /***
     * Search by metadata in all the system
     * @param key
     * @param value
     */
    fun searchByMetadata(key: String, value: String): MetadataSearchResponse

    /***
     * Return all the indexed documents in a bucket
     * @param index
     * @param bucket
     */
    fun searchByMatchAll(index: String, bucket: String): MetadataSearchResponse

    /***
     * Return all the indexed documents in all the buckets
     * @param index
     */
    fun searchByMatchAll(index: String): MetadataSearchResponse

    /***
     * Return all the indexed documents in all the system
     */
    fun searchByMatchAll(): MetadataSearchResponse

    /***
     * Close the connection to the underline search provider
     */
    fun closeConnection()
}

data class MetadataSearchHealthResponse(val clusterName: String, val status: String)

data class MetadataIndex(val indexName: String, val primaries: Int, val replications: Int, val numberOfDocuments: Long)

data class MetadataSearchResponse(val took: Int, val hits: MetadataSearchHits)

data class MetadataSearchHits(val numberOfHits: Long, val hits: List<MetadataSearchHitsNode>)

data class MetadataSearchHitsNode(val index: String, val type: String, val id: String, val score: Double, val source: Map<String, String>)

class MetadataException : Exception {
    constructor(errorCode: Int, message: String): super("($errorCode, $message)")
    constructor(errorCode: Int, message: String, ex: Exception): super("($errorCode, $message)", ex)
    constructor(ex: Exception): super(ex)
}

