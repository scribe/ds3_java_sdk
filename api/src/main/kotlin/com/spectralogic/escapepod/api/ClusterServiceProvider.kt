package com.spectralogic.escapepod.api

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import java.io.Serializable

interface ClusterServiceProvider : ServiceProvider<ClusterService> {
    fun joinCluster(endpoint: String) : Single<String>
    fun leaveCluster() : Completable
    fun createCluster(name: String) : Completable
    fun clusterLifecycleEvents(): Observable<ClusterEvent>
}

interface ClusterService {
    fun name() : Single<String>
    fun instanceName() : Single<String>
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

data class ClusterNode(val ip: String, val port: Int) : Serializable

/**
 * There are various cluster events that will be emitted depending on what the cluster is doing.
 */
abstract class ClusterEvent

/**
 * This event is thrown when the cluster is first created
 */
class ClusterCreatedEvent(val clusterName : String) : ClusterEvent()

/**
 * This event is thrown when the current node joins a cluster
 */
class ClusterJoinedEvent(val clusterName : String) : ClusterEvent()

/**
 * This event is thrown when a new node joins the cluster
 */
class ClusterNodeJoinedEvent(val clusterNode : ClusterNode) : ClusterEvent()

/**
 * This event is thrown when a node leaves the cluster.
 * This event should not be thrown in the event that the node is restarted.
 */
class ClusterNodeLeftEvent(val clusterNode: ClusterNode) : ClusterEvent()

/**
 * This event is thrown when the current node is started up after a restart
 */
class ClusterStartupEvent : ClusterEvent()

/**
 * This event is thrown when the current node is shutting down gracefully
 */
class ClusterShutdownEvent : ClusterEvent()

/**
 * This event is thrown when the current node leaves the cluster
 */
class ClusterLeftEvent: ClusterEvent()

open class ClusterException(message: String) : RuntimeException(message)
