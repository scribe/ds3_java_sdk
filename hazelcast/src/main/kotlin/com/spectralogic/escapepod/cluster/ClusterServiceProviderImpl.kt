package com.spectralogic.escapepod.cluster

import com.spectralogic.escapepod.util.ifNotNull
import com.hazelcast.config.Config
import com.hazelcast.core.*
import com.hazelcast.map.listener.*
import com.spectralogic.escapepod.api.*
import com.spectralogic.escapepod.cluster.config.ClusterConfigResource
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import org.slf4j.LoggerFactory
import javax.inject.Inject
import javax.inject.Named

internal class ClusterServiceProviderImpl
@Inject constructor(
        @Named("interfaceIp") private val hazelcastInterface: String,
        private val clusterConfigResource: ClusterConfigResource,
        private val clusterClientFactory : ClusterClientFactory
) : ClusterServiceProvider {

    private companion object {
        private val LOG = LoggerFactory.getLogger(ClusterServiceProviderImpl::class.java)

        private val CANNOT_JOIN_NEW_CLUSTER = "Cannot join another cluster when already a member of one"
        private val NOT_IN_CLUSTER = "The server must be a member of a cluster"
    }

    private val clusterLifecycleEvents = PublishSubject.create<ClusterEvent>()

    private var clusterService : HazelcastClusterService? = null

    override fun startService(): Completable {

        val resource = clusterConfigResource.getResource()
        if (resource != null) {
            LOG.info("attempting to re-join cluster after restart")
            val firstNode = resource.nodesList.stream().findFirst()

            if (firstNode.isPresent) {
                val node = firstNode.get()
                return joinCluster(node.host.endpoint + node.host.port)
                        .toCompletable()
            }
        }

        LOG.info("This node is not a member of a cluster.  Starting up as un-configured")
        return Completable.complete()
    }

    override fun getService(): ClusterService {
        throwIfNotInCluster(NOT_IN_CLUSTER)
        return clusterService!!
    }

    override fun leaveCluster() : Completable {
        throwIfNotInCluster(NOT_IN_CLUSTER)
        return Completable.create { emitter ->
            LOG.info("Attempting leaving cluster")

            clusterService.ifNotNull {
                it.hazelcastInstance.shutdown()
            }

            clusterLifecycleEvents.onNext(ClusterLeftEvent())
            emitter.onComplete()
        }
    }

    override fun createCluster(name: String) : Completable {
        throwIfInCluster(CANNOT_JOIN_NEW_CLUSTER)

        return Completable.create { emitter ->
            val config = createCommonClusterConfiguration(name)

            val hazelcastInstance = Hazelcast.newHazelcastInstance(config)

            clusterService = createAndConfigureCluster(hazelcastInstance)

            clusterLifecycleEvents.onNext(ClusterCreatedEvent(name))

            emitter.onComplete()
        }
    }

    override fun joinCluster(endpoint: String) : Single<String> {
        throwIfInCluster(CANNOT_JOIN_NEW_CLUSTER)

       return clusterClientFactory.createClusterClient(endpoint).clusterName()
               .doOnSuccess { name ->
                   val config = createCommonClusterConfiguration(name)

                   LOG.info("Attempting join to endpoint: {}", endpoint)

                   config.networkConfig.join.tcpIpConfig.members.add(hazelcastEndpoint(endpoint))

                   val newHazelcastInstance = Hazelcast.newHazelcastInstance(config)

                   clusterService = createAndConfigureCluster(newHazelcastInstance)

                   clusterLifecycleEvents.onNext(ClusterJoinedEvent(name))
       }
    }

    private fun hazelcastEndpoint(endpoint: String): String {
        val colonIndex = endpoint.indexOf(':')
        if (colonIndex > 0) {
            return endpoint.substring(0, colonIndex)
        }
        return endpoint
    }

    private fun createCommonClusterConfiguration(name : String) : Config {
        val config = Config()
        config.groupConfig.name = name
        val networkConfig = config.networkConfig

        networkConfig.interfaces.isEnabled = true
        networkConfig.interfaces.addInterface(hazelcastInterface)

        val join = networkConfig.join
        join.multicastConfig.isEnabled = false
        val tcpIpConfig = join.tcpIpConfig
        tcpIpConfig.isEnabled = true

        return config
    }

    override fun shutdown() : Completable {
        return leaveCluster()
    }

    override fun clusterLifecycleEvents() : Observable<ClusterEvent> {
        return clusterLifecycleEvents
    }

    private fun createAndConfigureCluster(hazelcastInstance: HazelcastInstance) : HazelcastClusterService {
        hazelcastInstance.cluster.addMembershipListener(HazelcastMembershipListener(clusterLifecycleEvents))

        val idGenerator = hazelcastInstance.getIdGenerator("clusterNodeId")

        return HazelcastClusterService(hazelcastInstance, "instance_" + idGenerator.newId())
    }

    private fun throwIfNotInCluster(message: String) = throwClusterExceptionIf(message) { clusterService == null }

    private fun throwIfInCluster(message: String) = throwClusterExceptionIf(message) { clusterService != null }

    private fun throwClusterExceptionIf(message: String, condition : ()->Boolean) {
        if (condition.invoke()) {
            throw ClusterException(message)
        }
    }
}

internal class HazelcastClusterService(internal val hazelcastInstance: HazelcastInstance, internal val instanceName : String) : ClusterService {
    override fun instanceName(): Single<String> {
        return Single.just(instanceName)
    }

    override fun name(): Single<String> {
        return Single.just(hazelcastInstance.config.groupConfig.name)
    }

    override fun <K, V> getDistributedMap(name: String): DistributedMap<K, V> {
        return HazelcastDistributedMap(hazelcastInstance.getMap(name))
    }

    override fun <V> getDistributedSet(name: String): DistributedSet<V> {
        return HazelcastDistributedSet(hazelcastInstance.getSet(name))
    }

    override fun clusterNodes(): Observable<ClusterNode> {

        return Observable.create { emitter ->
            hazelcastInstance
                .cluster
                .members
                .asSequence()
                .map { ClusterNode(it.address.host, it.address.port) }
                .forEach(emitter::onNext)

            emitter.onComplete()
        }
    }
}

internal class HazelcastDistributedMap<K, V>(hazelcastMap : IMap<K, V>) : MutableMap<K, V> by hazelcastMap, DistributedMap<K, V> {

    private val entryAddedSubject = PublishSubject.create<Pair<K,V>>()
    private val entryRemovedSubject = PublishSubject.create<Pair<K,V>>()
    private val entryModifiedSubject = PublishSubject.create<Pair<K,V>>()

    init {
        val entryListener = object : EntryAddedListener<K, V>, EntryRemovedListener<K, V>, EntryUpdatedListener<K, V>, EntryEvictedListener<K, V> {
            override fun entryAdded(event: EntryEvent<K, V>?) {
                event.ifNotNull {
                    entryAddedSubject.onNext(Pair(it.key, it.value))
                }
            }

            override fun entryRemoved(event: EntryEvent<K, V>?) {
                event.ifNotNull {
                    entryRemovedSubject.onNext(Pair(it.key, it.value))
                }
            }

            override fun entryUpdated(event: EntryEvent<K, V>?) {
                event.ifNotNull {
                    entryModifiedSubject.onNext(Pair(it.key, it.value))
                }
            }

            override fun entryEvicted(event: EntryEvent<K, V>?) {
                event.ifNotNull {
                    entryRemovedSubject.onNext(Pair(it.key, it.value))
                }
            }
        }

        hazelcastMap.addEntryListener(entryListener, true)
    }

    override fun entryAdded(onNext: (Pair<K, V>) -> Unit): Disposable {
        return entryAddedSubject.subscribe(onNext)
    }

    override fun entryRemoved(onNext: (Pair<K, V>) -> Unit): Disposable {
        return entryRemovedSubject.subscribe(onNext)
    }

    override fun entryModified(onNext: (Pair<K, V>) -> Unit): Disposable {
        return entryModifiedSubject.subscribe(onNext)
    }
}

internal class HazelcastDistributedSet<V>(hazelcastSet : ISet<V>) : MutableSet<V> by hazelcastSet, DistributedSet<V> {

    private val entryAddedSubject = PublishSubject.create<V>()
    private val entryRemovedSubject = PublishSubject.create<V>()

    init {
        hazelcastSet.addItemListener(object : ItemListener<V> {
            override fun itemAdded(item: ItemEvent<V>?) {
                item.ifNotNull {
                    entryAddedSubject.onNext(it.item)
                }
            }

            override fun itemRemoved(item: ItemEvent<V>?) {
                item.ifNotNull {
                    entryRemovedSubject.onNext(it.item)
                }
            }
        }, true)
    }


    override fun entryAdded(onNext: (V) -> Unit): Disposable {
        return entryAddedSubject.subscribe(onNext)
    }

    override fun entryRemoved(onNext: (V) -> Unit): Disposable {
        return entryRemovedSubject.subscribe(onNext)
    }
}

internal class HazelcastMembershipListener(private val clusterEvents: PublishSubject<ClusterEvent>) : MembershipListener {
    override fun memberRemoved(membershipEvent: MembershipEvent) {
        val address = membershipEvent.member.address
        val clusterNode = ClusterNode(address.host, address.port)
        clusterEvents.onNext(ClusterNodeLeftEvent(clusterNode))
    }

    override fun memberAdded(membershipEvent: MembershipEvent) {
        val address = membershipEvent.member.address
        val clusterNode = ClusterNode(address.host, address.port)
        clusterEvents.onNext(ClusterNodeJoinedEvent(clusterNode))
    }

    override fun memberAttributeChanged(memberAttributeEvent: MemberAttributeEvent) {
    }
}

