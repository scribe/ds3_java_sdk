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

package com.spectralogic.escapepod.persistence

import com.spectralogic.escapepod.api.*
import io.reactivex.Completable
import jetbrains.exodus.entitystore.PersistentEntityStore
import jetbrains.exodus.entitystore.PersistentEntityStores
import org.slf4j.LoggerFactory
import java.io.File
import java.io.IOException
import java.nio.file.Files
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

    private var entityStore : PersistentEntityStore? = null
    private var xodusService : PersistenceService? = null


    override fun shutdown(): Completable {
        return Completable.create { emitter ->
            entityStore?.close()
            emitter.onComplete()
        }
    }

    override fun startService(): Completable {
        return Completable.create { emitter ->
            LOG.info("Starting Xodus Service")

            try {
                Files.createDirectories(dataDir)
                entityStore = PersistentEntityStores.newInstance(dataDir.toFile())
                xodusService = XodusPersistenceService(entityStore!!)
                emitter.onComplete()
            } catch (e : IOException) {
                LOG.error("Failed to access data directory for Xodus", e)
                emitter.onError(e)
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

    fun clusterHandler(event: ClusterEvent) {
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
            is ClusterLeftEvent -> {
                shutdown().subscribe()
            }
        }
    }

}