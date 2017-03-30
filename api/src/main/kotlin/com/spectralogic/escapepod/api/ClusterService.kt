package com.spectralogic.escapepod.api

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable

interface ClusterService {
    fun joinCluster(ip: String) : Single<String>
    fun leaveCluster() : Completable
    fun createCluster(name: String) : Completable
    fun clusterNodes() : Observable<ClusterNode>
    fun clusterEvents(onNext : (ClusterEvent) -> Unit, onError : (Throwable) -> Unit) : Disposable
    fun clusterEvents(onNext : (ClusterEvent) -> Unit) : Disposable
}

data class ClusterNode(val ip: String, val port: Int)

abstract class ClusterEvent

class ClusterCreatedEvent(val clusterName : String) : ClusterEvent()

class ClusterJoinedEvent(val clusterName : String) : ClusterEvent()

class ClusterNodeJoinedEvent(val clusterNode : ClusterNode) : ClusterEvent()

class ClusterNodeLeftEvent(val clusterNode: ClusterNode) : ClusterEvent()

class ClusterLeftEvent : ClusterEvent()

class ClusterException(message: String) : RuntimeException(message)
