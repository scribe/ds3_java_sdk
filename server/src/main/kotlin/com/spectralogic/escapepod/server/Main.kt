package com.spectralogic.escapepod.server

import com.google.inject.Guice
import com.spectralogic.escapepod.api.Scheduler
import com.spectralogic.escapepod.api.Server
import com.spectralogic.escapepod.cache.CacheModule
import com.spectralogic.escapepod.scheduler.SchedulerModule

fun main(arg: Array<String>) {
    println("Creating the injector")
    val injector = Guice.createInjector(ServerModule(), CacheModule(), SchedulerModule())

    println("Get the Server instance from the injector")
    val server = injector.getInstance(Server::class.java)

    println("running the server")
    server.run()

    println("Get the Scheduler instance from the injector")
    val scheduler = injector.getInstance(Scheduler::class.java)

    println("starting the scheduler")
    scheduler.start()

    println("migrating data")
    scheduler.migrate("testTapeGroup")

    println("stopping the scheduler")
    scheduler.stop()

}
