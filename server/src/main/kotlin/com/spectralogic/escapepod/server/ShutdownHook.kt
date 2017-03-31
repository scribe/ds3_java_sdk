package com.spectralogic.escapepod.server

import com.spectralogic.escapepod.api.ClusterServiceProvider
import com.spectralogic.escapepod.api.PersistenceServiceProvider
import io.reactivex.Completable
import org.slf4j.LoggerFactory
import javax.inject.Inject

class ShutdownHook @Inject constructor(private val persistenceServiceProvider: PersistenceServiceProvider, private val clusterServiceProvider: ClusterServiceProvider) : Thread() {

    private companion object {
        private val LOG = LoggerFactory.getLogger(ShutdownHook::class.java)
    }

    override fun run() {

        LOG.info("Shutting down all dependant services")

        Completable.mergeArray(persistenceServiceProvider.shutdown(), clusterServiceProvider.shutdown())
                .doOnError { t ->
                    LOG.error("Failed to shutdown services", t)
                }
                .subscribe()
    }
}
