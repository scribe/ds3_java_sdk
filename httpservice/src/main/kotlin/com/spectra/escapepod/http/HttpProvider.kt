/*
 * *****************************************************************************
 *    Copyright 2014-2017 Spectra Logic Corporation. All Rights Reserved.
 *    Licensed under the Apache License, Version 2.0 (the "License"). You may not use
 *    this file except in compliance with the License. A copy of the License is located at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *    or in the "license" file accompanying this file.
 *    This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *    CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *    specific language governing permissions and limitations under the License.
 *  ****************************************************************************
 */

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
