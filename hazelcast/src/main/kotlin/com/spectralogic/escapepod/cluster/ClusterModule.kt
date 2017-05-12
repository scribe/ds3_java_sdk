package com.spectralogic.escapepod.cluster

import com.google.inject.AbstractModule
import com.spectralogic.escapepod.api.*
import io.reactivex.Completable
import org.slf4j.LoggerFactory
import javax.inject.Inject

class ClusterModule : Module<ClusterModuleLoader> {
    override fun moduleLoader(): Class<ClusterModuleLoader> {
        return ClusterModuleLoader::class.java
    }

    override fun guiceModule(): AbstractModule {
        return HazelcastGuiceModule()
    }
}

class ClusterModuleLoader @Inject constructor(private val clusterServiceProvider: ClusterServiceProvider) : ModuleLoader {

    private companion object {
        private val LOG = LoggerFactory.getLogger(ClusterModuleLoader::class.java)
    }

    override fun loadModule(): Completable {
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

        return clusterServiceProvider.startService()
    }
}
