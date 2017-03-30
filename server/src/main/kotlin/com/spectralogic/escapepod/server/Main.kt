package com.spectralogic.escapepod.server

import com.google.inject.Guice
import com.spectralogic.escapepod.api.ClusterNodeJoinedEvent
import com.spectralogic.escapepod.api.ClusterService
import com.spectralogic.escapepod.cluster.HazelcastModule
import org.slf4j.LoggerFactory
import ratpack.server.RatpackServer

class Main {

    companion object {

        private val LOG = LoggerFactory.getLogger(Main::class.java)

        @JvmStatic
        fun main(arg: Array<String>) {
            val injector = Guice.createInjector(ServerModule(), HazelcastModule())

            val clusterService = injector.getInstance(ClusterService::class.java)

            clusterService.clusterEvents { event ->
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
