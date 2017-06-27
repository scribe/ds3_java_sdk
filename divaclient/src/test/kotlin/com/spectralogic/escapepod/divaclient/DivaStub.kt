package com.spectralogic.escapepod.divaclient

import com.spectralogic.escapepod.util.ifNotNull
import org.simpleframework.xml.core.Persister
import ratpack.func.Action
import ratpack.handling.Chain
import ratpack.test.embed.EmbeddedApp
import java.io.StringWriter
import java.util.*

internal class DivaStub {

    private var server : EmbeddedApp? = null

    fun start() {
        if (server != null) {
            throw RuntimeException("The server has already been started")
        }

        server = EmbeddedApp.fromHandlers(DivaStubHandler())
    }

    fun address() : String {
        if (server == null) {
            throw RuntimeException("Cannot stop test server that was not already started")
        } else {
            return "http://" + server!!.address.host + ":" + server!!.address.port
        }
    }

    fun stop() {
        if (server == null) {
            throw RuntimeException("Cannot stop test server that was not already started")
        }

        server.ifNotNull {
            it.close()
            server = null
        }
    }
}

internal class DivaStubHandler : Action<Chain> {

    private val persister = Persister()
    private val sessions = HashMap<UUID, String>()

    override fun execute(chain: Chain) {
        chain.prefix("services/DIVArchiveWS_REST_2.0") { restChain ->
            restChain.post("registerClient") { ctx ->
                ctx.request.body.then { t ->
                    val registerRequest = persister.read(RegisterClient::class.java, t.text)
                    val sessionId = UUID.randomUUID()

                    sessions.put(sessionId, registerRequest.appName)

                    val registerResponse = RegisterClientResponse()
                    registerResponse.sessionId = sessionId.toString()

                    val stringWriter = StringWriter()

                    persister.write(registerResponse, stringWriter)

                    ctx.response.send(stringWriter.toString())
                }
            }
        }
    }
}
