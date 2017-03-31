package com.spectralogic.escapepod.server

import com.google.inject.Guice
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
            val persistenceService = injector.getInstance(PersistenceService::class.java)

            clusterService.clusterLifecycleEvents { event ->
                if (event is ClusterCreatedEvent) {
                    persistenceService.createNewPersistenceCluster(event.clusterName, 27017) // TODO default port for Mongo
                } else if (event is ClusterLeftEvent) {
                    persistenceService.shutdown()
                }
            }

            clusterService.clusterLifecycleEvents { event ->
                if (event is ClusterNodeJoinedEvent) {
                    LOG.info("New node joined cluster: {}:{}", event.clusterNode.ip, event.clusterNode.port)
                }
            }

            RatpackServer.start { server ->

                val envVars = System.getenv()

                if ("serverPort" in envVars) {
                    server.serverConfig { config ->
                        config.port(envVars["serverPort"]!!.toInt())
                    }
                }

                server.handlers { chain ->
                    val rootHandler = injector.getInstance(RootHandler::class.java)
                    chain.prefix("api", rootHandler)
                }
            }
        }
    }
}
