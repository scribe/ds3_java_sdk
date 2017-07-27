package com.spectralogic.escapepod.cluster

import com.google.inject.AbstractModule
import com.spectralogic.escapepod.api.*
import io.reactivex.Completable
import org.slf4j.LoggerFactory
import javax.inject.Inject

class ClusterModuleRegistration : ModuleRegistration<ClusterModule> {
    override fun module(): Class<ClusterModule> = ClusterModule::class.java

    override fun guiceModule(): AbstractModule = HazelcastGuiceModule()
}

class ClusterModule @Inject constructor(private val clusterServiceProvider: ClusterServiceProvider) : Module {

    private companion object {
        private val LOG = LoggerFactory.getLogger(ClusterModule::class.java)
    }

    override val name: String = "Cluster"

    override fun loadModule(): Completable {

        return Completable.create { emitter ->
            clusterServiceProvider.clusterLifecycleEvents().subscribe { event ->
                when (event) {
                    is ClusterNodeJoinedEvent -> {
                        LOG.info("New node joined cluster: {}:{}", event.clusterNode.ip, event.clusterNode.port)
                    }
                    is ClusterNodeLeftEvent -> {
                        LOG.info("Node left the cluster: {}:{}", event.clusterNode.ip, event.clusterNode.port)
                    }
                }
            }

            emitter.onComplete()
        }
    }

    override fun startModule(): Completable {
        LOG.info("Starting the cluster module")
        return clusterServiceProvider.startService()
    }

    override fun shutdownModule(): Completable = clusterServiceProvider.shutdown()
}
