package com.spectralogic.escapepod.cluster

import com.spectralogic.escapepod.util.ifNotNull
import com.hazelcast.config.Config
import com.hazelcast.core.*
import com.spectralogic.escapepod.api.*
import com.spectralogic.escapepod.cluster.config.ClusterConfigService
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.subjects.PublishSubject
import org.slf4j.LoggerFactory
import javax.inject.Inject
import javax.inject.Named

internal class ClusterServiceProviderImpl
@Inject constructor(
        @Named("interfaceIp") private val hazelcastInterface: String,
        @Named("managementPort") private val managementPort : Int,
        private val clusterConfigService: ClusterConfigService,
        private val clusterClientFactory : ClusterClientFactory
) : ClusterServiceProvider {

    private companion object {
        private val LOG = LoggerFactory.getLogger(ClusterServiceProviderImpl::class.java)

        private const val CANNOT_JOIN_NEW_CLUSTER = "Cannot join another cluster when already a member of one"
        private const val NOT_IN_CLUSTER = "The server must be a member of a cluster"
        private const val CLUSTER_MAP = "cluster_map"
        private const val SHUTDOWN_HOOK = "hazelcast.shutdownhook.enabled"
    }

    private val clusterLifecycleEvents = PublishSubject.create<ClusterEvent>()

    private val internalLifecycleEvents = PublishSubject.create<ConfigChangeEvent>()

    private var clusterService : HazelcastClusterService? = null

    init {
        internalLifecycleEvents.subscribe(this::clusterEventsHandler)
    }

    override fun startService(): Completable {

        val resource = clusterConfigService.getConfig()
        if (resource != null) {
            LOG.info("attempting to re-join cluster after restart")
            val firstNode = resource.nodesList.stream().findFirst()

            if (firstNode.isPresent) {
                val node = firstNode.get()
                return innerJoinCluster(node.host.endpoint + node.host.port)
                        .doOnSuccess {
                            clusterLifecycleEvents.onNext(ClusterStartupEvent())
                        }
                        .toCompletable()
            } else {
                LOG.info("There are no other nodes in the cluster, starting up as a single node cluster")
                return innerCreateCluster(resource.name).doOnComplete {
                    clusterLifecycleEvents.onNext(ClusterStartupEvent())
                }
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
                val distributedMap = it.getDistributedMap<ClusterNode, ClusterNode>(CLUSTER_MAP)
                distributedMap.remove(it.getClusterNode())

                it.shutdown()
            }

            clusterService = null
            internalLifecycleEvents.onNext(ConfigDeletedChangeEvent())
            clusterLifecycleEvents.onNext(ClusterLeftEvent())
            emitter.onComplete()
        }
    }

    override fun createCluster(name: String) : Completable {
        throwIfInCluster(CANNOT_JOIN_NEW_CLUSTER)

        return innerCreateCluster(name).doOnComplete {
            clusterLifecycleEvents.onNext(ClusterCreatedEvent(name))
            internalLifecycleEvents.onNext(ConfigCreatedChangeEvent(name))
        }
    }

    fun innerCreateCluster(name : String) : Completable {

        return Completable.create { emitter ->
            val config = createCommonClusterConfiguration(name)

            val hazelcastInstance = Hazelcast.newHazelcastInstance(config)

            clusterService = createAndConfigureCluster(hazelcastInstance)

            emitter.onComplete()
        }
    }

    override fun joinCluster(endpoint: String) : Single<String> {
        throwIfInCluster(CANNOT_JOIN_NEW_CLUSTER)

       return innerJoinCluster(endpoint).doOnSuccess { name ->
           clusterLifecycleEvents.onNext(ClusterJoinedEvent(name))
       }
    }

    private fun innerJoinCluster(endpoint : String) : Single<String> {
        return clusterClientFactory.createClusterClient(endpoint).clusterName()
               .doOnSuccess { name ->
                   val config = createCommonClusterConfiguration(name)

                   LOG.info("Attempting join to endpoint: {}", endpoint)

                   config.networkConfig.join.tcpIpConfig.members.add(hazelcastEndpoint(endpoint))

                   val newHazelcastInstance = Hazelcast.newHazelcastInstance(config)

                   clusterService = createAndConfigureCluster(newHazelcastInstance)

                   internalLifecycleEvents.onNext(ConfigCreatedChangeEvent(name))
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
        config.setProperty(SHUTDOWN_HOOK, "false")
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
        return Completable.create { emitter ->
            clusterLifecycleEvents.onNext(ClusterShutdownEvent())
            clusterLifecycleEvents.onComplete()
            internalLifecycleEvents.onComplete()

            clusterService.ifNotNull {
                it.shutdown()
            }

            clusterService = null
            emitter.onComplete()
        }
    }

    override fun clusterLifecycleEvents() : Observable<ClusterEvent> {
        return clusterLifecycleEvents
    }

    private fun clusterEventsHandler(event : ConfigChangeEvent) {
        when (event) {
            is ConfigCreatedChangeEvent -> clusterConfigService.createConfig(event.clusterName)
            is ConfigNodeAddedChangeEvent -> clusterConfigService.addNode(event.clusterNode)
            is ConfigNodeRemovedChangeEvent -> clusterConfigService.removeNode(event.clusterNode)
            is ConfigDeletedChangeEvent -> clusterConfigService.deleteConfig()
        }
    }

    private fun createAndConfigureCluster(hazelcastInstance: HazelcastInstance) : HazelcastClusterService {
        hazelcastInstance.cluster.addMembershipListener(HazelcastMembershipListener(internalLifecycleEvents))

        val idGenerator = hazelcastInstance.getIdGenerator("clusterNodeId")
        val hazelcastClusterService = HazelcastClusterService(hazelcastInstance, "instance_" + idGenerator.newId())

        val clusterMap = hazelcastClusterService.getDistributedMap<ClusterNode, ClusterNode>(CLUSTER_MAP)

        clusterMap.put(ClusterNode(hazelcastInterface, hazelcastInstance.config.networkConfig.port), ClusterNode(hazelcastInterface, managementPort))

        clusterMap.entryAdded { (clusterNode, publicNode) ->
            if (hazelcastClusterService.getClusterNode() != clusterNode) {
                clusterLifecycleEvents.onNext(ClusterNodeJoinedEvent(publicNode))
            }
        }

        clusterMap.entryRemoved { (clusterNode, publicNode) ->
            if (hazelcastClusterService.getClusterNode() != clusterNode) {
                clusterLifecycleEvents.onNext(ClusterNodeLeftEvent(publicNode))
            }
        }

        return hazelcastClusterService
    }

    private fun throwIfNotInCluster(message: String) = throwClusterExceptionIf(message) { clusterService == null }

    private fun throwIfInCluster(message: String) = throwClusterExceptionIf(message) { clusterService != null }

    private fun throwClusterExceptionIf(message: String, condition : () -> Boolean) {
        if (condition.invoke()) {
            throw ClusterException(message)
        }
    }
}

private class HazelcastMembershipListener(private val clusterEvents: PublishSubject<ConfigChangeEvent>) : MembershipListener {
    override fun memberRemoved(membershipEvent: MembershipEvent) {
        val address = membershipEvent.member.address
        val clusterNode = ClusterNode(address.host, address.port)
        clusterEvents.onNext(ConfigNodeRemovedChangeEvent(clusterNode))
    }

    override fun memberAdded(membershipEvent: MembershipEvent) {
        val address = membershipEvent.member.address
        val clusterNode = ClusterNode(address.host, address.port)
        clusterEvents.onNext(ConfigNodeAddedChangeEvent(clusterNode))
    }

    override fun memberAttributeChanged(memberAttributeEvent: MemberAttributeEvent) {
    }
}

private abstract class ConfigChangeEvent

private class ConfigCreatedChangeEvent(val clusterName: String) : ConfigChangeEvent()
private class ConfigNodeAddedChangeEvent(val clusterNode: ClusterNode) : ConfigChangeEvent()
private class ConfigNodeRemovedChangeEvent(val clusterNode: ClusterNode) : ConfigChangeEvent()
private class ConfigDeletedChangeEvent : ConfigChangeEvent()
