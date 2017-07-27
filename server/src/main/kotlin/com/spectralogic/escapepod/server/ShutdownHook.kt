package com.spectralogic.escapepod.server

import com.spectralogic.escapepod.api.Module
import io.reactivex.Completable
import org.slf4j.LoggerFactory

class ShutdownHook constructor(private val modules : Iterable<Module>) : Thread("module-shutdown-hook") {

    private companion object {
        private val LOG = LoggerFactory.getLogger(ShutdownHook::class.java)
    }

    override fun run() {

        LOG.info("Shutting down all modules")

        Completable.merge(modules.map { it.shutdownModule() })
                .doOnError { t ->
                    LOG.error("Failed to shutdown modules", t)
                }
                .subscribe()
    }
}
