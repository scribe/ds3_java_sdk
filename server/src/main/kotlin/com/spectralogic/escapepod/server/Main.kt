package com.spectralogic.escapepod.server

import com.google.inject.Guice
import com.spectralogic.escapepod.api.Server
import com.spectralogic.escapepod.cache.CacheModule

fun main(arg: Array<String>) {
    println("Did I get Here?")
    val injector = Guice.createInjector(ServerModule(), CacheModule())

    println("Did I get Here??")
    val server = injector.getInstance(Server::class.java)

    println("Did I get Here???")
    server.run()
    println("Did I get Here????")
}
