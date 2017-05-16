package com.spectralogic.escapepod.api

import io.reactivex.Completable

interface MetadataSearchServiceProvider : ServiceProvider<MetadataSearchService> {
    fun createNewMetadataSearchCluster(): Completable
    fun joinMetadataSearchCluster(): Completable
    fun metadataSearchNodeJoinedEvent(): Completable
    fun leaveMetadataSearchCluster(): Completable
    fun clusterHandler(event: ClusterEvent)
}

interface MetadataSearchService
