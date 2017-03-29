package com.spectralogic.escapepod.server

import com.google.inject.AbstractModule
import com.google.inject.Provides
import com.spectralogic.escapepod.api.Server
import java.util.concurrent.ExecutorService
import java.util.concurrent.ForkJoinPool
import javax.inject.Singleton

class ServerModule : AbstractModule() {

    private val workers: ExecutorService = ForkJoinPool.commonPool()

    override fun configure() {
        bind(Server::class.java).to(EscapePodServer::class.java)
        bind(RootHandler::class.java).`in`(Singleton::class.java)
        bind(ClusterHandlerChain::class.java).`in`(Singleton::class.java)
    }

    @Provides
    fun workers() : ExecutorService {
        return workers
    }

}
