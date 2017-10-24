package com.spectralogic.escapepod.avidpamwsclient

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.inject.AbstractModule
import com.spectralogic.escapepod.api.Module
import com.spectralogic.escapepod.api.ModuleRegistration
import com.spectralogic.escapepod.api.PamExistsException
import com.spectralogic.escapepod.api.PamNotFoundException
import com.spectralogic.escapepod.httpservice.DefaultException
import com.spectralogic.escapepod.httpservice.HttpDeregistrationAggregator
import com.spectralogic.escapepod.httpservice.HttpRouter
import io.reactivex.Completable
import org.slf4j.LoggerFactory
import javax.inject.Inject

class AvidPamWsClientModuleRegistration : ModuleRegistration<AvidPamWsClientModule> {
    override fun module(): Class<AvidPamWsClientModule> = AvidPamWsClientModule::class.java

    override fun guiceModule(): AbstractModule = AvidPamWsClientGuiceModule()
}

class AvidPamWsClientModule
@Inject private constructor(private val httpRouter: HttpRouter, private val avidPamWsClientHandler: AvidPamWsClientHandlerChain) : Module {

    override val name: String = "Avid Pam Ws Client"

    private val deregistrationAggregator = HttpDeregistrationAggregator()

    companion object {
        private val LOG = LoggerFactory.getLogger(AvidPamWsClientModule::class.java)
    }

    override fun loadModule(): Completable {
        LOG.info("Loading AvidPamWsClient Module")

        return Completable.create { emitter ->
            deregistrationAggregator.addDeregistration((httpRouter.register("pam", avidPamWsClientHandler)))
            emitter.onComplete()
        }
    }


    override fun startModule(): Completable {
        return Completable.create { emitter ->
            LOG.info("Starting AvidPamWsClient Module")

            httpRouter.registerExceptionHandler(PamNotFoundException::class.java) { ctx, t ->
                val objectMapper = ctx.get(ObjectMapper::class.java)
                ctx.response
                        .status(404)
                        .send(objectMapper.writeValueAsBytes(DefaultException(t.message, 404)))
            }

            httpRouter.registerExceptionHandler(PamExistsException::class.java) { ctx, t ->
                val objectMapper = ctx.get(ObjectMapper::class.java)
                ctx.response
                        .status(409)
                        .send(objectMapper.writeValueAsBytes(DefaultException(t.message, 409)))
            }

            emitter.onComplete()
        }
    }

    override fun shutdownModule(): Completable {
        return Completable.create { emitter ->
            LOG.info("Shutting down AvidPamWsClient Module")
            deregistrationAggregator.deregister()
            emitter.onComplete()
        }
    }
}
