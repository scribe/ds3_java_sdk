package com.spectralogic.escapepod.cluster

import com.hazelcast.config.Config
import com.hazelcast.core.Hazelcast
import com.hazelcast.core.HazelcastInstance
import com.spectralogic.escapepod.api.ClusterNode
import com.spectralogic.escapepod.api.ClusterService
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import org.slf4j.LoggerFactory
import javax.inject.Inject
import javax.inject.Named

class ClusterServiceImpl @Inject constructor(@Named("hazelcastInterface") private val hazelcastInterface: String, private val hazelcastResource : HazelcastResource) : ClusterService {
    private companion object {
        private val LOG = LoggerFactory.getLogger(ClusterServiceImpl::class.java)

        private val CANNOT_JOIN_NEW_CLUSTER = "Cannot join another cluster when already a member of one"
        private val NOT_IN_CLUSTER = "The server must be a member of a cluster"
    }

    override fun leaveCluster() : Completable {
        return Completable.create { emitter ->
            LOG.info("Attempting leaving cluster")
            hazelcastResource.getInstance().ifPresent(HazelcastInstance::shutdown)
            hazelcastResource.setInstance(null)
            emitter.onComplete()
        }
    }

    override fun createCluster(name: String) : Completable {
        throwIfInCluster(CANNOT_JOIN_NEW_CLUSTER)

        return Completable.create { emitter ->
            val config = Config()
            config.instanceName = name
            val networkConfig = config.networkConfig
            networkConfig.interfaces.isEnabled = true
            networkConfig.interfaces.addInterface(hazelcastInterface)

            val join = networkConfig.join
            join.multicastConfig.isEnabled = false
            join.tcpIpConfig.isEnabled = true

            hazelcastResource.setInstance(Hazelcast.newHazelcastInstance(config))
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

        return Single.create { emitter ->
            try {
                val config = Config()
                val networkConfig = config.networkConfig

                networkConfig.interfaces.isEnabled = true
                networkConfig.interfaces.addInterface(hazelcastInterface)

                val join = networkConfig.join
                join.multicastConfig.isEnabled = false
                val tcpIpConfig = join.tcpIpConfig
                tcpIpConfig.isEnabled = true
                tcpIpConfig.addMember(ip)

                LOG.info("Attempting join to ip: {}", ip)

                val newHazelcastInstance = Hazelcast.newHazelcastInstance(config)
                hazelcastResource.setInstance(newHazelcastInstance)

                emitter.onSuccess(newHazelcastInstance.name)
            } catch (t : Throwable) {
                emitter.onError(t)
            }
        }
    }

    private fun throwIfNotInCluster(message: String) = throwClusterExceptionIf(message) { !hazelcastResource.getInstance().isPresent }

    private fun throwIfInCluster(message: String) = throwClusterExceptionIf(message) { hazelcastResource.getInstance().isPresent }

    private fun throwClusterExceptionIf(message: String, condition : ()->Boolean) {
        if (condition.invoke()) {
            throw ClusterException(message)
        }
    }
}

class ClusterException(message: String) : RuntimeException(message)
