package com.spectralogic.escapepod.cluster

import com.greyrock.escapepod.util.ifNotNull
import com.hazelcast.config.Config
import com.hazelcast.core.*
import com.spectralogic.escapepod.api.*
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.Single.create
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import org.slf4j.LoggerFactory
import javax.inject.Inject
import javax.inject.Named

class ClusterServiceProviderImpl @Inject constructor(@Named("hazelcastInterface") private val hazelcastInterface: String) : ClusterServiceProvider {

    private companion object {
        private val LOG = LoggerFactory.getLogger(ClusterServiceProviderImpl::class.java)

        private val CANNOT_JOIN_NEW_CLUSTER = "Cannot join another cluster when already a member of one"
        private val NOT_IN_CLUSTER = "The server must be a member of a cluster"
    }

    private val clusterLifecycleEvents = PublishSubject.create<ClusterEvent>()

    private var clusterService : HazelcastClusterService? = null

    override fun startService(): Completable {

        // TODO read cluster configuration information and create a new service on startup when this is called

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
            val config = createCommonClusterConfiguration()
            config.instanceName = name

            val hazelcastInstance = Hazelcast.newHazelcastInstance(config)

            clusterService = createAndConfigureCluster(hazelcastInstance)

            clusterLifecycleEvents.onNext(ClusterCreatedEvent(name))
            emitter.onComplete()
        }
    }

   override fun joinCluster(ip : String) : Single<String> {
        throwIfInCluster(CANNOT_JOIN_NEW_CLUSTER)

        return create { emitter ->
            try {

                val config = createCommonClusterConfiguration()
                config.networkConfig.join.tcpIpConfig.addMember(ip)

                LOG.info("Attempting join to ip: {}", ip)

                val newHazelcastInstance = Hazelcast.newHazelcastInstance(config)

                clusterService = createAndConfigureCluster(newHazelcastInstance)

                clusterLifecycleEvents.onNext(ClusterJoinedEvent(newHazelcastInstance.name))
                emitter.onSuccess(newHazelcastInstance.name)
            } catch (t : Throwable) {
                emitter.onError(t)
            }
        }
    }

    private fun createCommonClusterConfiguration() : Config {
        val config = Config()
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

    override fun clusterLifecycleEvents(onNext : (ClusterEvent) -> Unit, onError : (Throwable) -> Unit) : Disposable{
        return clusterLifecycleEvents.subscribe(onNext, onError)
    }

    override fun clusterLifecycleEvents(onNext : (ClusterEvent) -> Unit) : Disposable {
        return clusterLifecycleEvents.subscribe(onNext)
    }

    private fun createAndConfigureCluster(hazelcastInstance: HazelcastInstance) : HazelcastClusterService {
        hazelcastInstance.cluster.addMembershipListener(HazelcastMembershipListener(clusterLifecycleEvents))

        return HazelcastClusterService(hazelcastInstance)
    }

    private fun throwIfNotInCluster(message: String) = throwClusterExceptionIf(message) { clusterService == null }

    private fun throwIfInCluster(message: String) = throwClusterExceptionIf(message) { clusterService != null }

    private fun throwClusterExceptionIf(message: String, condition : ()->Boolean) {
        if (condition.invoke()) {
            throw ClusterException(message)
        }
    }
}

class HazelcastClusterService(internal val hazelcastInstance: HazelcastInstance) : ClusterService {

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

class HazelcastMembershipListener(private val clusterEvents: PublishSubject<ClusterEvent>) : MembershipListener {
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

