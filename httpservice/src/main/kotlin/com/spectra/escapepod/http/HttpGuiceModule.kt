package com.spectra.escapepod.http

import com.google.inject.AbstractModule
import com.google.inject.Singleton
import com.spectralogic.escapepod.api.WebServiceProvider
import ratpack.server.RatpackServerSpec

class HttpGuiceModule() : AbstractModule() {
    override fun configure() {
        bind(WebServiceProvider::class.java).to(HttpProvider::class.java).`in`(Singleton::class.java)
        bind(RootHandler::class.java).`in`(Singleton::class.java)
        bind(ClusterHandlerChain::class.java).`in`(Singleton::class.java)
        bind(ModuleHandler::class.java).`in`(Singleton::class.java)
    }
}
