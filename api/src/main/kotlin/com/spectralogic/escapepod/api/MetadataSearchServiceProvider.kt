package com.spectralogic.escapepod.api

import io.reactivex.Completable

interface MetadataSearchServiceProvider : ServiceProvider<MetadataSearchService> {
    fun joinCluster() : Completable
    fun leaveCluster() : Completable
    fun createNewMetadataSearchCluster() : Completable
    fun clusterHandler(event : ClusterEvent)
}

interface MetadataSearchService
