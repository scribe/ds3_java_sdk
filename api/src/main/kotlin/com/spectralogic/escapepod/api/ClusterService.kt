package com.spectralogic.escapepod.api

import io.reactivex.Observable
import io.reactivex.Single

interface ClusterService {
    fun joinCluster(ip: String) : Single<String>
    fun leaveCluster() : Single<Unit>
    fun createCluster(name: String) : Single<Unit>
    fun clusterNodes() : Observable<ClusterNode>
}

data class ClusterNode(val ip: String, val port: Int)
