package com.spectra.escapepod.http

import com.google.inject.Inject
import com.google.inject.name.Named
import com.spectralogic.escapepod.api.ClusterEvent
import com.spectralogic.escapepod.api.ClusterLeftEvent
import com.spectralogic.escapepod.api.WebService
import com.spectralogic.escapepod.api.WebServiceProvider
import io.reactivex.Completable
import ratpack.handling.Handler
import ratpack.registry.Registry
import ratpack.server.RatpackServer

internal class HttpProvider @Inject constructor (@Named("managementPort") val port:Int, val rootHandler:RootHandler): WebServiceProvider {

    var server : RatpackServer? = null
    val httpRouter : HttpRouter = HttpRouter()

    override fun shutdown(): Completable {
        return Completable.create { emitter ->
            server?.stop()
            emitter.onComplete()
        }
    }

    override fun startService(): Completable {
        return Completable.create { emitter ->

            server = RatpackServer.start { server ->
                server.serverConfig {
                    it.port(port)
                }

                server.handlers {
                    it.prefix("api", rootHandler)
                }
            }
            emitter.onComplete()
        }
    }

    fun clusterHandler(event: ClusterEvent): Unit {
        when(event) {
            is ClusterLeftEvent -> shutdown().subscribe()
        }
    }

    override fun getService(): WebService {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}

internal class HttpRouter() {
    private val list : MutableList<Handler> = ArrayList<Handler>()
    fun register(handler: Handler) {
        list.add(handler )
    }

}
