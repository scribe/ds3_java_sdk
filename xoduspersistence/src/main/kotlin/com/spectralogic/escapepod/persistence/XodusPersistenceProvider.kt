package com.spectralogic.escapepod.persistence

import com.spectralogic.escapepod.api.*
import io.reactivex.Completable
import jetbrains.exodus.entitystore.PersistentEntityStore
import jetbrains.exodus.entitystore.PersistentEntityStores
import org.slf4j.LoggerFactory
import java.io.File
import java.nio.file.Path
import javax.inject.Inject
import javax.inject.Named

internal class XodusPersistenceProvider
@Inject constructor(
        //        private val clusterServiceProvider: ClusterServiceProvider,
//      @Named("interfaceIp") private val interfaceIp : String,
        @Named("dataDir") private val dataDir : Path,
        @Named("persistencePort") private val persistencePort: Int
) : PersistenceServiceProvider{

    private companion object {
        private val LOG = LoggerFactory.getLogger(XodusPersistenceProvider::class.java)
    }

    private lateinit var entityStore : PersistentEntityStore
    private var xodusService : PersistenceService? = null


    override fun shutdown(): Completable {
        return Completable.create { emitter ->
            entityStore.close()
            emitter.onComplete()
        }
    }

    override fun startService(): Completable {
        return Completable.create { emitter ->
            LOG.info("Starting Xodus Service")
            val data : File = dataDir.toFile()
            if(data.exists() && data.isDirectory && data.canRead() && data.canWrite()) {
                entityStore = PersistentEntityStores.newInstance(dataDir.toFile())
                xodusService = XodusPersistenceService(entityStore)
                emitter.onComplete()
            } else {
                emitter.onError(Exception("Failed to start Xodus, could not access ${data.absolutePath}"))
            }
        }
    }

    override fun joinPersistenceCluster(name: String, port: Int): Completable {
        TODO("not implemented")
    }

    override fun getService(): PersistenceService = xodusService as PersistenceService

    override fun createNewPersistenceCluster(name: String, port: Int): Completable {
        TODO("not implemented")
    }

    override fun leavePersistenceCluster(): Completable {
        TODO("not implemented")
    }

    fun clusterHandler(event: ClusterEvent): Unit {
        when(event) {
            is ClusterCreatedEvent -> {
                val createNewPersistenceCluster = createNewPersistenceCluster(event.clusterName, persistencePort)
                createNewPersistenceCluster
                        .doOnError{ t ->
                            LOG.error("Failed to create xodus persistence node", t)
                        }.subscribe()
            }
            is ClusterJoinedEvent -> {
                LOG.info("Attempting to join existing xodus persistence layer")
                joinPersistenceCluster(event.clusterName, persistencePort)
                        .doOnError { t ->
                            LOG.error("Failed to join existing xodus cluster", t)
                        }.subscribe()
            }
            is ClusterStartupEvent -> {
                startup().subscribe()
            }
            is ClusterLeftEvent -> {
                shutdown().subscribe()
            }
        }
    }

    private fun  startup(): Completable {
        return Completable.complete()
    }

}