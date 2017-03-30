package com.spectralogic.escapepod.cluster

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

class ClusterServiceImpl @Inject constructor(@Named("hazelcastInterface") private val hazelcastInterface: String, private val hazelcastResource : HazelcastResource) : ClusterService {
    private companion object {
        private val LOG = LoggerFactory.getLogger(ClusterServiceImpl::class.java)

        private val CANNOT_JOIN_NEW_CLUSTER = "Cannot join another cluster when already a member of one"
        private val NOT_IN_CLUSTER = "The server must be a member of a cluster"
    }

    private val clusterEvents = PublishSubject.create<ClusterEvent>()

    override fun leaveCluster() : Completable {
        return Completable.create { emitter ->
            LOG.info("Attempting leaving cluster")
            hazelcastResource.getInstance().ifPresent(HazelcastInstance::shutdown)
            hazelcastResource.setInstance(null)
            clusterEvents.onNext(ClusterLeftEvent())
            emitter.onComplete()
        }
    }

    override fun createCluster(name: String) : Completable {
        throwIfInCluster(CANNOT_JOIN_NEW_CLUSTER)

        return Completable.create { emitter ->
            val config = createCommonClusterConfiguration()
            config.instanceName = name

            val hazelcastInstance = Hazelcast.newHazelcastInstance(config)
            hazelcastResource.setInstance(hazelcastInstance)

            hazelcastInstance.cluster.addMembershipListener(HazelcastMembershipListner(clusterEvents))
            clusterEvents.onNext(ClusterCreatedEvent(name))
            emitter.onComplete()
        }
    }

    override fun clusterNodes(): Observable<ClusterNode> {
        throwIfNotInCluster(NOT_IN_CLUSTER)

        return Observable.create { emitter ->
            hazelcastResource.getInstance().get()
                .cluster
                .members
                .asSequence()
                .map { ClusterNode(it.address.host, it.address.port) }
                .forEach(emitter::onNext)

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
                hazelcastResource.setInstance(newHazelcastInstance)

                newHazelcastInstance.cluster.addMembershipListener(HazelcastMembershipListner(clusterEvents))

                clusterEvents.onNext(ClusterJoinedEvent(newHazelcastInstance.name))
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


    override fun clusterEvents(onNext : (ClusterEvent) -> Unit, onError : (Throwable) -> Unit) : Disposable{
        return clusterEvents.subscribe(onNext, onError)
    }

    override fun clusterEvents(onNext : (ClusterEvent) -> Unit) : Disposable {
        return clusterEvents.subscribe(onNext)
    }

    private fun throwIfNotInCluster(message: String) = throwClusterExceptionIf(message) { !hazelcastResource.getInstance().isPresent }

    private fun throwIfInCluster(message: String) = throwClusterExceptionIf(message) { hazelcastResource.getInstance().isPresent }

    private fun throwClusterExceptionIf(message: String, condition : ()->Boolean) {
        if (condition.invoke()) {
            throw ClusterException(message)
        }
    }
}
class HazelcastMembershipListner(private val clusterEvents: PublishSubject<ClusterEvent>) : MembershipListener {
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

