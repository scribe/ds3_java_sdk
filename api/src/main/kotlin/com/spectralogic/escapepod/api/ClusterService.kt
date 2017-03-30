package com.spectralogic.escapepod.api

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface ClusterService {
    fun joinCluster(ip: String) : Single<String>
    fun leaveCluster() : Completable
    fun createCluster(name: String) : Completable
    fun clusterNodes() : Observable<ClusterNode>
}

data class ClusterNode(val ip: String, val port: Int)
