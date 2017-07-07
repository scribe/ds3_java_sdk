package com.spectralogic.escapepod.server

import com.google.common.collect.ImmutableList
import com.google.inject.Guice
import com.spectra.escapepod.http.HttpModule
import com.spectralogic.escapepod.cluster.ClusterModule
import com.spectralogic.escapepod.persistence.PersistenceModule
import com.spectralogic.escapepod.util.collections.GuavaCollectors


class Main {

    companion object {

        @JvmStatic
        fun main(arg: Array<String>) {

            val clusterModule = ClusterModule()
            val persistenceModule = PersistenceModule()
            val httpModule = HttpModule()

            val injector = Guice.createInjector(ServerModule(), clusterModule.guiceModule(), persistenceModule.guiceModule(), httpModule.guiceModule())

            Runtime.getRuntime().addShutdownHook(injector.getInstance(ShutdownHook::class.java))

            val moduleList = ImmutableList.of(clusterModule, persistenceModule, httpModule)

            val moduleInstances = moduleList.stream()
                    .map { injector.getInstance(it.moduleLoader()) }
                    .collect(GuavaCollectors.immutableList())

            // 2 stage loading of the modules
            moduleInstances.forEach { it.loadModule() }
            moduleInstances.forEach { it.startModule() }

        }
    }
}
