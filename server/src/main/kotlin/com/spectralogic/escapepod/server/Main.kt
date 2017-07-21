package com.spectralogic.escapepod.server

import com.google.common.collect.ImmutableList
import com.google.inject.Guice
import com.google.inject.Key
import com.google.inject.name.Names
import com.spectralogic.escapepod.cluster.ClusterModule
import com.spectralogic.escapepod.persistence.PersistenceModule
import com.spectralogic.escapepod.util.collections.GuavaCollectors
import ratpack.server.RatpackServer

class Main {

    companion object {

        @JvmStatic
        fun main(arg: Array<String>) {

            val clusterModule = ClusterModule()
            val persistenceModule = PersistenceModule()

            val injector = Guice.createInjector(ServerModule(), clusterModule.guiceModule(), persistenceModule.guiceModule())

            Runtime.getRuntime().addShutdownHook(injector.getInstance(ShutdownHook::class.java))

            val moduleList = ImmutableList.of(clusterModule, persistenceModule)

            val moduleInstances = moduleList.stream()
                    .map { injector.getInstance(it.moduleLoader()) }
                    .collect(GuavaCollectors.immutableList())

            // 2 stage loading of the modules
            moduleInstances.forEach { it.loadModule() }
            moduleInstances.forEach { it.startModule() }

            RatpackServer.start { server ->

                server.serverConfig { config ->
                    val portProvider = injector.getProvider(Key.get(Int::class.java, Names.named("managementPort")))
                    config.port(portProvider.get())
                }

                server.handlers { chain ->
                    val rootHandler = injector.getInstance(RootHandler::class.java)
                    chain.prefix("api", rootHandler)
                }
            }
        }
    }
}
