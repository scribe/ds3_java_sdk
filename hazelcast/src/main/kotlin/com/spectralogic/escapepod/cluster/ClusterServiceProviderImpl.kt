/*
 * *****************************************************************************
 *    Copyright 2014-2017 Spectra Logic Corporation. All Rights Reserved.
 *    Licensed under the Apache License, Version 2.0 (the "License"). You may not use
 *    this file except in compliance with the License. A copy of the License is located at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *    or in the "license" file accompanying this file.
 *    This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *    CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *    specific language governing permissions and limitations under the License.
 *  ****************************************************************************
 */

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
import java.util.*
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

        return clusterConfigService.getConfig().doOnError { e ->
            LOG.error("This node is not a member of a cluster.  Starting up as un-configured", e)
        }.doOnSuccess {
            LOG.info("attempting to re-join cluster after restart")
        }.flatMapCompletable { (name, _, nodeList) ->

            try {
                val node = nodeList.first()
                innerJoinCluster(node.endpoint +":"+ node.port)
                        .doOnSuccess {
                            clusterLifecycleEvents.onNext(ClusterStartupEvent())
                        }.doOnError {
                            LOG.error("Failed to join cluster on startup", it)
                        }.toCompletable()
            } catch (e: NoSuchElementException) {
                LOG.info("There are no other nodes in the cluster, starting up as a single node cluster")
                innerCreateCluster(name).doOnComplete {
                    clusterLifecycleEvents.onNext(ClusterStartupEvent())
                }
            }
        }.onErrorComplete()
    }

    override fun getService(requestContext: RequestContext): Single<ClusterService> {
        val clusterService = clusterService

        return if (clusterService == null) {
            Single.error(ClusterException(NOT_IN_CLUSTER))
        } else {
            Single.just(InstrumentedClusterService(clusterService, requestContext))
        }
    }

    override fun leaveCluster(): Completable {

        val clusterServiceCopy = clusterService

        return if (clusterServiceCopy == null) {
            Completable.error(ClusterException(NOT_IN_CLUSTER))
        } else {
            LOG.info("Attempting leaving cluster")
            cleanupService(clusterServiceCopy).andThen {
                LOG.info("Left Cluster")
                clusterService = null
                internalLifecycleEvents.onNext(ConfigDeletedChangeEvent())
                clusterLifecycleEvents.onNext(ClusterLeftEvent())
                it.onComplete()
            }
        }
    }

    private fun cleanupService(cluster: HazelcastClusterService): Completable {
        return cluster.getDistributedMap<ClusterNode, ClusterNode>(CLUSTER_MAP).flatMapCompletable {
            it.remove(cluster.getClusterNode())
            cluster.shutdown()
        }
    }

    override fun createCluster(name: String) : Completable {

        if (clusterService != null) {
            return Completable.error(ClusterException(CANNOT_JOIN_NEW_CLUSTER))
        }

        return innerCreateCluster(name).doOnComplete {
            clusterLifecycleEvents.onNext(ClusterCreatedEvent(name))
            internalLifecycleEvents.onNext(ConfigCreatedChangeEvent(name, UUID.randomUUID()))
        }
    }

    private fun innerCreateCluster(name : String) : Completable {
        val config = createCommonClusterConfiguration(name)

        val hazelcastInstance = Hazelcast.newHazelcastInstance(config)

        return createAndConfigureCluster(hazelcastInstance).doOnSuccess {
            clusterService = it
        }.toCompletable()

    }

    override fun joinCluster(endpoint: String) : Single<String> {
        if (clusterService != null) {
            return Single.error(ClusterException(CANNOT_JOIN_NEW_CLUSTER))
        }

       return innerJoinCluster(endpoint).doOnSuccess { name ->
           clusterLifecycleEvents.onNext(ClusterJoinedEvent(name))
       }
    }

    private fun innerJoinCluster(endpoint : String) : Single<String> {
        return clusterClientFactory.createClusterClient(endpoint).clusterName().flatMap { name ->
            val config = createCommonClusterConfiguration(name)

            LOG.info("Attempting join to endpoint: {}", endpoint)

            config.networkConfig.join.tcpIpConfig.members.add(hazelcastEndpoint(endpoint))

            val newHazelcastInstance = Hazelcast.newHazelcastInstance(config)

            createAndConfigureCluster(newHazelcastInstance).doOnSuccess {
                clusterService = it
                internalLifecycleEvents.onNext(ConfigCreatedChangeEvent(name, UUID.randomUUID()))
            }.map {
                name
            }
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
            is ConfigCreatedChangeEvent -> clusterConfigService.createConfig(event.clusterName, event.clusterId)
            is ConfigNodeAddedChangeEvent -> {
                clusterConfigService.addNode(event.clusterNode)
                clusterLifecycleEvents.onNext(ClusterNodeJoinedEvent(event.clusterNode))
            }
            is ConfigNodeRemovedChangeEvent -> {
                clusterConfigService.removeNode(event.clusterNode)
                clusterLifecycleEvents.onNext(ClusterNodeLeftEvent(event.clusterNode))
            }
            is ConfigDeletedChangeEvent -> clusterConfigService.deleteConfig()
        }
    }

    private fun createAndConfigureCluster(hazelcastInstance: HazelcastInstance) : Single<HazelcastClusterService> {
        hazelcastInstance.cluster.addMembershipListener(HazelcastMembershipListener(internalLifecycleEvents))

        val idGenerator = hazelcastInstance.getIdGenerator("clusterNodeId")
        val hazelcastClusterService = HazelcastClusterService(hazelcastInstance, "instance_" + idGenerator.newId())

        val clusterMap = hazelcastClusterService.getDistributedMap<ClusterNode, ClusterNode>(CLUSTER_MAP)

        return clusterMap.map {
            it.put(ClusterNode(hazelcastInterface, hazelcastInstance.config.networkConfig.port), ClusterNode(hazelcastInterface, managementPort))

            it.entryAdded { (clusterNode, publicNode) ->
                if (hazelcastClusterService.getClusterNode() != clusterNode) {
                    clusterLifecycleEvents.onNext(ClusterNodeJoinedEvent(publicNode))
                }
            }

            it.entryRemoved { (clusterNode, publicNode) ->
                if (hazelcastClusterService.getClusterNode() != clusterNode) {
                    clusterLifecycleEvents.onNext(ClusterNodeLeftEvent(publicNode))
                }
            }

            hazelcastClusterService
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

private class ConfigCreatedChangeEvent(val clusterName: String, val clusterId: UUID) : ConfigChangeEvent()
private class ConfigNodeAddedChangeEvent(val clusterNode: ClusterNode) : ConfigChangeEvent()
private class ConfigNodeRemovedChangeEvent(val clusterNode: ClusterNode) : ConfigChangeEvent()
private class ConfigDeletedChangeEvent : ConfigChangeEvent()
