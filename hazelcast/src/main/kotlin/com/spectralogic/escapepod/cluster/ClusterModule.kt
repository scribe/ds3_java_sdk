package com.spectralogic.escapepod.cluster

import com.google.inject.AbstractModule
import com.spectralogic.escapepod.api.ClusterNodeJoinedEvent
import com.spectralogic.escapepod.api.ClusterServiceProvider
import com.spectralogic.escapepod.api.Module
import com.spectralogic.escapepod.api.ModuleLoader
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
        return Completable.create {
             clusterServiceProvider.clusterLifecycleEvents().subscribe { event ->
                if (event is ClusterNodeJoinedEvent) {
                    LOG.info("New node joined cluster: {}:{}", event.clusterNode.ip, event.clusterNode.port)
                }
            }
        }
    }
}
