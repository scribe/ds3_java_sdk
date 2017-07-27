package com.spectralogic.escapepod.api

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface MetadataSearchServiceProvider : ServiceProvider<MetadataSearchService>{
    fun createNewMetadataSearchCluster(): Completable
    fun joinMetadataSearchCluster(): Completable
    fun metadataSearchNodeJoinedEvent(): Completable
    fun leaveMetadataSearchCluster(): Completable
    fun clusterHandler(event: ClusterEvent)
}

interface MetadataSearchServiceConfigFile {
    fun createConfigFile()
}

interface MetadataSearchService {

    /***
     * Query the health of the cluster
     */
    fun health(): Single<MetadataSearchHealthResponse>

    /***
     * Create an index for a BlackPearl in the underline search provider with a default of 5 shards and 2 replicas
     * @param numberOfShard
     * @param numberOfReplicas
     */
    fun createIndex(blackPearlName: String, numberOfShard: Int = 5, numberOfReplicas: Int = 2): Completable

    /***
     * Update the number of replicas for the given BlackPearl index
     * @param blackPearlName
     * @param numberOfReplicas
     */
    fun updateIndexNumberOfReplicas(blackPearlName: String, numberOfReplicas: Int): Completable

    /***
     * Get all the BlackPearl indices in the system
     */
    fun getAllIndices(): Observable<MetadataIndex>

    /***
     * Delete the given BlackPearl index from the underline provider
     * @param blackPearlName
     */
    fun deleteIndex(blackPearlName: String): Completable

    /***
     * Delete a document from a bucket in BlackPearl
     * @param blackPearlName
     * @param bucket
     * @param fileName
     */
    fun deleteDocument(blackPearlName: String, bucket: String, fileName: String): Completable

    /***
     * Index a document
     * @param blackPearlName
     * @param bucket
     * @param fileName
     * @param metadata
     */
    fun indexDocument(blackPearlName: String, bucket: String, fileName: String,
                      metadata: Map<String, String>): Completable

    /***
     * Update the metadata for an indexed document
     * @param blackPearlName
     * @param bucket
     * @param fileName
     * @param metadata
     */
    fun updateIndexedDocument(blackPearlName: String, bucket: String, fileName: String, metadata: Map<String, String>): Completable

    /***
     * Return all the indexed documents that satisfy the search by fileName in the given bucket in blackPearlName
     * @param blackPearlName
     * @param bucket
     * @param fileName
     */
    fun searchById(blackPearlName: String, bucket: String, fileName: String): Observable<MetadataSearchHitsNode>

    /***
     * Return all the indexed documents that satisfy the search by fileName in blackPearlName
     * @param blackPearlName
     * @param fileName
     */
    fun searchById(blackPearlName: String, fileName: String): Observable<MetadataSearchHitsNode>

    /***
     * Return all the indexed documents that satisfy the search by fileName in all the system
     * @param fileName
     */
    fun searchById(fileName: String): Observable<MetadataSearchHitsNode>

    /***
     * Return all the indexed documents that satisfy the search by metadata in the given buckets in blackPearlName
     * @param blackPearlName
     * @param bucket
     * @param metadataKey
     * @param metadataValue
     */
    fun searchByMetadata(blackPearlName: String, bucket: String, metadataKey: String, metadataValue: String):
            Observable<MetadataSearchHitsNode>

    /***
     * Return all the indexed documents that satisfy the search by metadata in blackPearlName
     * @param blackPearlName
     * @param metadataKey
     * @param metadataValue
     */
    fun searchByMetadata(blackPearlName: String, metadataKey: String, metadataValue: String):  Observable<MetadataSearchHitsNode>

    /***
     * Return all the indexed documents that satisfy the search by metadata in all the system
     * @param metadataKey
     * @param metadataValue
     */
    fun searchByMetadata(metadataKey: String, metadataValue: String): Observable<MetadataSearchHitsNode>

    /***
     * Return all the indexed documents for the given bucket in blackPealName
     * @param blackPearlName
     * @param bucket
     */
    fun searchByMatchAll(blackPearlName: String, bucket: String): Observable<MetadataSearchHitsNode>

    /***
     * Return all the indexed documents in all the buckets for the given blackPearlName
     * @param blackPearlName
     */
    fun searchByMatchAll(blackPearlName: String): Observable<MetadataSearchHitsNode>

    /***
     * Return all the indexed documents in all the system
     */
    fun searchByMatchAll(): Observable<MetadataSearchHitsNode>
}

data class MetadataSearchHealthResponse(val clusterName: String, val status: String)

data class MetadataIndex(val indexName: String, val primaries: Int, val replications: Int, val numberOfDocuments: Long)

data class MetadataSearchHitsNode(val index: String, val type: String, val id: String, val score: Double, val source: Map<String, String>)

class MetadataException : Exception {
    constructor(errorCode: Int, message: String): super("($errorCode, $message)")
    constructor(errorCode: Int, message: String, ex: Exception): super("($errorCode, $message)", ex)
    constructor(ex: Exception): super(ex)
}

