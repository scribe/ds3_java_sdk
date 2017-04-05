package com.spectralogic.escapepod.server

import com.google.inject.Guice
import com.google.inject.Key
import com.google.inject.name.Names
import com.greyrock.escapepod.util.ifNotNull
import com.spectralogic.escapepod.api.*
import com.spectralogic.escapepod.cluster.HazelcastModule
import com.spectralogic.escapepod.persistence.MongoPersistenceModule
import org.slf4j.LoggerFactory
import ratpack.server.RatpackServer

class Main {

    companion object {

        private val LOG = LoggerFactory.getLogger(Main::class.java)

        // TODO need to add a shutdown thread for the persistence layer and any other subprocesses that could be running

        @JvmStatic
        fun main(arg: Array<String>) {
            val injector = Guice.createInjector(ServerModule(), HazelcastModule(), MongoPersistenceModule())

            Runtime.getRuntime().addShutdownHook(injector.getInstance(ShutdownHook::class.java))

            val clusterService = injector.getInstance(ClusterServiceProvider::class.java)
            val persistenceService = injector.getInstance(PersistenceServiceProvider::class.java)

            clusterService.clusterLifecycleEvents(persistenceService::clusterHandler)

            clusterService.clusterLifecycleEvents { event ->
                if (event is ClusterNodeJoinedEvent) {
                    LOG.info("New node joined cluster: {}:{}", event.clusterNode.ip, event.clusterNode.port)
                }
            }

            RatpackServer.start { server ->


                server.serverConfig { config ->
                    val portProvider = injector.getProvider(Key.get(Int::class.java, Names.named("httpPort")))
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
