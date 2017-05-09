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
        private val clusterConfigService: ClusterConfigService,
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

        val resource = clusterConfigService.getConfig()
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

