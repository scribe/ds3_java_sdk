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

import com.spectralogic.escapepod.util.ifNotNull
import com.mongodb.MongoClient
import com.mongodb.ServerAddress
import com.spectralogic.escapepod.api.*
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.slf4j.LoggerFactory
import java.io.Serializable
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Named

internal class MongoPersistenceProvider
@Inject constructor(
        private val clusterServiceProvider: ClusterServiceProvider,
        @Named("interfaceIp") private val interfaceIp : String,
        @Named("dataDir") private val dataDir : Path,
        @Named("persistencePort") private val persistencePort: Int
): PersistenceServiceProvider {
    private companion object {
        private val LOG = LoggerFactory.getLogger(MongoPersistenceProvider::class.java)
        private const val MONGO_CLUSTER_ENDPOINT = "mongoClusterEndpoint"
    }

    private val disposables : CompositeDisposable = CompositeDisposable()

    private var mongoProcess : Process? = null
    private var mongoClient : MongoClient? = null

    override fun startService(): Completable {
        // No op, wait for startup event to fire
        return Completable.complete()
    }

    override fun getService(): PersistenceService {
        TODO("not implemented")
    }

    override fun joinPersistenceCluster(name : String, port : Int) : Completable {
        return startMongo(name, port)
                .doOnComplete(this::createMongoClient)
    }

    private fun createMongoClient() {
        val clusterService = clusterServiceProvider.getService()
        val distributedSet = clusterService.getDistributedSet<MongoNode>(MONGO_CLUSTER_ENDPOINT)

        LOG.info("creating mongo client")
        mongoClient = MongoClient(distributedSet.map { ServerAddress(it.ip, it.port)})
    }

    private fun newMongoNode(mongoNode: MongoNode) {
        LOG.info("New Mongo Node registered for {}:{}", mongoNode.ip, mongoNode.port)

        mongoClient.ifNotNull {
            LOG.info("Adding new Mongo node to cluster")
            val clusterAddScript = writeClusterAddScript(mongoNode)
            try {
                val initClusterProcess = runProcess("mongo", "--port", persistencePort.toString(), clusterAddScript.toString())

                initClusterProcess.waitFor(30, TimeUnit.SECONDS)
                if (initClusterProcess.isAlive) {
                    initClusterProcess.destroyForcibly()
                } else if (initClusterProcess.exitValue() != 0) {
                    LOG.error("Failed to initialize mongo replica set")
                }

            } finally {
                Files.deleteIfExists(clusterAddScript)
            }
        }
    }

    private fun writeClusterAddScript(mongoNode: MongoNode): Path {
       val createTempFile = Files.createTempFile("mongoConf", ".js")

        LOG.info("temp file for cluster add script: {}", createTempFile.toString())

        Files.newBufferedWriter(createTempFile, Charset.forName("UTF-8"), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE).use {
            it.write("if (db.isMaster().ismaster === true) {\n")
            it.write("rs.add(\"${mongoNode.ip}:${mongoNode.port}\")\n")
            it.write("}\n")
        }

        return createTempFile
    }

    override fun createNewPersistenceCluster(name : String, port : Int) : Completable {
        // create new mongo process

        // TODO add check to make sure we are not already in a cluster

        return startMongo(name, port).doOnComplete {
            val clusterInitScript = writeClusterCreationScript(port)
            try {
                val initClusterProcess = runProcess("mongo", "--port", port.toString(), clusterInitScript.toString())

                initClusterProcess.waitFor(30, TimeUnit.SECONDS)
                if (initClusterProcess.isAlive) {
                    initClusterProcess.destroyForcibly()
                } else if (initClusterProcess.exitValue() != 0) {
                    LOG.error("Failed to initialize mongo replica set")
                }

            } finally {
                Files.deleteIfExists(clusterInitScript)
            }
        }.doOnComplete(this::createMongoClient)
    }

    private fun startup() : Completable {
        return Completable.complete()
    }

    private fun startMongo(name : String, port : Int) : Completable {
        return Completable.create { emitter ->

            try {
                LOG.info("Starting new mongo persistence cluster")

                val clusterService = clusterServiceProvider.getService()
                createMongoNodeProcess(port, name).doOnSuccess { process ->

                    mongoProcess = process

                    if (mongoProcess == null || !mongoProcess!!.isAlive) {
                        emitter.onError(Exception("Failed to startModule mongo node"))
                    } else {

                        val distributedSet = clusterService.getDistributedSet<MongoNode>(MONGO_CLUSTER_ENDPOINT)
                        disposables.add(distributedSet.entryAdded(this::newMongoNode))

                        distributedSet.add(MongoNode(interfaceIp, port))

                        LOG.info("Started mongo node on {}:{}", interfaceIp, port)

                        emitter.onComplete()
                    }

                }.subscribe()

            } catch (t : Throwable) {
                emitter.onError(t)
            }
        }
    }

    private fun writeClusterCreationScript(port : Int) : Path {
        val createTempFile = Files.createTempFile("mongoConf", ".js")

        LOG.info("temp file for init script: {}", createTempFile.toString())

        Files.newBufferedWriter(createTempFile, Charset.forName("UTF-8"), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE).use {
            it.write("rs.initiate({\"_id\": \"test\", \"members\": [{\"_id\": 0, \"host\": \"$interfaceIp:$port\"}]})\n")
        }

        return createTempFile
    }

    private fun createMongoNodeProcess(port: Int, name: String) : Single<Process> {

        val clusterService = clusterServiceProvider.getService()

        return clusterService.instanceName().map { instanceName ->
            val localDataDir = dataDir.resolve("mongoDataDir").resolve(instanceName)

            Files.createDirectories(localDataDir)

            runProcess("mongod", "--port", port.toString(), "--replSet", name, "--dbpath", localDataDir.toString())
        }
    }

    private fun runProcess(vararg args : String) : Process {
        val processBuilder = ProcessBuilder(*args)

        LOG.info("Starting command: {}", processBuilder.command().joinToString(" "))

        processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT)
        processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT)
        return processBuilder.start()
    }

    override fun leavePersistenceCluster(): Completable {

        return Completable.concatArray(Completable.create { _ ->
            //TODO delete any cluster information and cleanup the data directory

        }, shutdown())

    }

    override fun shutdown() : Completable {

        return Completable.create { emitter ->
            try {
                disposables.dispose()

                mongoClient.ifNotNull {
                    it.close()
                    mongoClient = null
                }

                mongoProcess.ifNotNull {
                    it.destroy()
                    it.waitFor(300, TimeUnit.SECONDS)

                    if (it.isAlive) {
                        LOG.error("Mongo instance still active after shutdown attempt")
                    } else {
                        LOG.info("Mongo exited successfully with exit code: {}", it.exitValue())
                    }
                    mongoProcess = null
                }

                emitter.onComplete()
            } catch (t : Throwable) {
                emitter.onError(t)
            }
        }
    }

    fun clusterHandler(event: ClusterEvent) {

        when(event) {
            is ClusterCreatedEvent -> {
                val createNewPersistenceCluster = createNewPersistenceCluster(event.clusterName, persistencePort)
                createNewPersistenceCluster
                    .doOnError{ t ->
                        LOG.error("Failed to create mongo persistence node", t)
                    }.subscribe()
            }
            is ClusterJoinedEvent -> {
                LOG.info("Attempting to join existing mongo persistence layer")
                joinPersistenceCluster(event.clusterName, persistencePort)
                        .doOnError { t ->
                            LOG.error("Failed to join existing mongo cluster", t)
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
}

internal data class MongoNode(val ip : String, val port : Int) : Serializable

internal class MongoPersistenceService : PersistenceService {

}
