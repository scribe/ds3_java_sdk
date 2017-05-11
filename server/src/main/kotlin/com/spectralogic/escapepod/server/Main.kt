package com.spectralogic.escapepod.server

import com.google.common.collect.ImmutableList
import com.google.inject.Guice
import com.google.inject.Key
import com.google.inject.name.Names
import com.spectralogic.escapepod.cluster.ClusterModule
import com.spectralogic.escapepod.metadatasearch.MetadataSearchModule
import com.spectralogic.escapepod.persistence.PersistenceModule
import ratpack.server.RatpackServer

class Main {

    companion object {

        @JvmStatic
        fun main(arg: Array<String>) {

            val clusterModule = ClusterModule()
            val persistenceModule = PersistenceModule()
            val metadataSearchModule = MetadataSearchModule()

            val injector = Guice.createInjector(ServerModule(), clusterModule.guiceModule(),
                    persistenceModule.guiceModule(), metadataSearchModule.guiceModule())

            Runtime.getRuntime().addShutdownHook(injector.getInstance(ShutdownHook::class.java))

            ImmutableList.of(clusterModule, /*persistenceModule,*/ metadataSearchModule)
                    .asSequence()
                    .map { injector.getInstance(it.moduleLoader()) }
                    .forEach { it.loadModule().subscribe() }

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
