package com.spectralogic.escapepod.api

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable

interface ClusterServiceProvider : ServiceProvider<ClusterService> {
    fun joinCluster(ip: String) : Single<String>
    fun leaveCluster() : Completable
    fun createCluster(name: String) : Completable
    fun clusterLifecycleEvents(onNext : (ClusterEvent) -> Unit, onError : (Throwable) -> Unit) : Disposable
    fun clusterLifecycleEvents(onNext : (ClusterEvent) -> Unit) : Disposable
}

interface ClusterService {
    fun clusterNodes() : Observable<ClusterNode>
    fun <K, V> getDistributedMap(name : String) : DistributedMap<K, V>
    fun <V> getDistributedSet(name : String) : DistributedSet<V>
}

interface DistributedMap<K, V> : MutableMap<K, V> {
    fun entryAdded(onNext : (Pair<K, V>) -> Unit) : Disposable
    fun entryRemoved(onNext : (Pair<K, V>) -> Unit) : Disposable
    fun entryModified(onNext : (Pair<K, V>) -> Unit) : Disposable
}

interface DistributedSet<V> : MutableSet<V> {
    fun entryAdded(onNext : (V) -> Unit) : Disposable
    fun entryRemoved(onNext : (V) -> Unit) : Disposable
}

data class ClusterNode(val ip: String, val port: Int)

abstract class ClusterEvent

class ClusterCreatedEvent(val clusterName : String) : ClusterEvent()

class ClusterJoinedEvent(val clusterName : String) : ClusterEvent()

class ClusterNodeJoinedEvent(val clusterNode : ClusterNode) : ClusterEvent()
class ClusterNodeLeftEvent(val clusterNode: ClusterNode) : ClusterEvent()

class ClusterLeftEvent : ClusterEvent()

class ClusterException(message: String) : RuntimeException(message)
