package com.spectralogic.escapepod.pammigrate

import com.google.inject.AbstractModule
import com.spectralogic.escapepod.api.Module
import com.spectralogic.escapepod.api.ModuleRegistration
import com.spectralogic.escapepod.httpservice.HttpDeregistrationAggregator
import com.spectralogic.escapepod.httpservice.HttpRouter
import io.reactivex.Completable
import org.slf4j.LoggerFactory
import javax.inject.Inject

class PamMigrateModuleRegistration : ModuleRegistration<PamMigrateModule> {
    override fun module(): Class<PamMigrateModule> = PamMigrateModule::class.java

    override fun guiceModule(): AbstractModule = PamMigrateGuiceModule()
}

class PamMigrateModule
@Inject constructor(private val pamMigrateProvider: PamMigrateProvider, private val httpRouter: HttpRouter, private val pamMigrateHandler: PamMigrateHandlerChain) : Module {

    override val name: String = "Pam Migrate"

    private val deregistrationAggregator = HttpDeregistrationAggregator()

    companion object {
        private val LOG = LoggerFactory.getLogger(PamMigrateModule::class.java)
    }

    override fun loadModule(): Completable {
        LOG.info("Loading PamMigrateModule")

        return Completable.create { emitter ->
            deregistrationAggregator.addDeregistration((httpRouter.register("pammigrate", pamMigrateHandler)))
            emitter.onComplete()
        }
    }


    override fun startModule(): Completable {
        return Completable.create { emitter ->
            LOG.info("Starting PamMigrate Module")
            emitter.onComplete()
        }
    }

    override fun shutdownModule(): Completable {
        return Completable.create { emitter ->
            LOG.info("Shutting down PamMigrate Module")
            deregistrationAggregator.deregister()
            emitter.onComplete()
        }
    }
}
