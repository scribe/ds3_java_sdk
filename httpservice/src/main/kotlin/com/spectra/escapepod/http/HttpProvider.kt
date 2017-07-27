package com.spectra.escapepod.http

import com.google.inject.Inject
import com.google.inject.name.Named
import com.spectralogic.escapepod.api.ClusterEvent
import com.spectralogic.escapepod.api.ClusterLeftEvent
import com.spectralogic.escapepod.api.WebService
import com.spectralogic.escapepod.api.WebServiceProvider
import io.reactivex.Completable
import org.slf4j.LoggerFactory
import ratpack.handling.Handler
import ratpack.server.RatpackServer

internal class HttpProvider @Inject constructor (@Named("managementPort") private val port : Int, private val rootHandler : RootHandler) : WebServiceProvider {

    private companion object {
        private val LOG = LoggerFactory.getLogger(HttpProvider::class.java)
    }

    var server : RatpackServer? = null
    val httpRouter : HttpRouter = HttpRouter()

    override fun shutdown(): Completable {
        return Completable.create { emitter ->
            LOG.info("Stopping http server")
            server?.stop()
            emitter.onComplete()
        }
    }

    override fun startService(): Completable {
        return Completable.create { emitter ->
            LOG.info("Starting http server")
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

    fun clusterHandler(event: ClusterEvent) {
        when(event) {
            is ClusterLeftEvent -> shutdown().subscribe()
        }
    }

    override fun getService(): WebService {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}

internal class HttpRouter {
    private val list : MutableList<Handler> = ArrayList()
    fun register(handler: Handler) {
        list.add(handler )
    }

}
