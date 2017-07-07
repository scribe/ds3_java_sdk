package com.spectra.escapepod.http

import com.google.inject.Inject
import com.google.inject.name.Named
import ratpack.func.Function
import ratpack.handling.Handler
import ratpack.registry.Registry
import ratpack.server.RatpackServerSpec
import ratpack.server.ServerConfig

/**
 * Created by ericb on 7/7/17.
 */
class HttpConfig @Inject constructor(@Named("RootHandler") val handler: Handler, @Named("ManagmentPort") val port: Int): RatpackServerSpec{
    override fun serverConfig(serverConfig: ServerConfig?): RatpackServerSpec {
        return serverConfig(serverConfig).serverConfig {
            it.port(port)
        }
    }

    override fun handler(handlerFactory: Function<in Registry, out Handler>?): RatpackServerSpec {
        return handler(handlerFactory)
    }

    override fun registry(function: Function<in Registry, out Registry>?): RatpackServerSpec {
        return registry(function)
    }
}