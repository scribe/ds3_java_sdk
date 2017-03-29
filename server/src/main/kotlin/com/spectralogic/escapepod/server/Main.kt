package com.spectralogic.escapepod.server

import com.google.inject.Guice
import com.spectralogic.escapepod.cluster.HazelcastModule
import ratpack.server.RatpackServer

fun main(arg: Array<String>) {
    val injector = Guice.createInjector(ServerModule(), HazelcastModule())

    RatpackServer.start { server ->

        val envVars = System.getenv()

        if ("serverPort" in envVars) {
            server.serverConfig {  config ->
                config.port(envVars["serverPort"]!!.toInt())
            }
        }

        server.handlers { chain ->
            val rootHandler = injector.getInstance(RootHandler::class.java)
            chain.prefix("api", rootHandler)
        }
    }
}
