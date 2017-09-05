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

package com.spectralogic.escapepod.metadatasearch

import com.spectralogic.escapepod.api.*
import com.spectralogic.escapepod.util.singleOfNullable
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.functions.BiFunction
import org.apache.http.HttpHost
import org.slf4j.LoggerFactory
import java.io.Serializable
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*
import javax.inject.Inject
import javax.inject.Named

internal class ElasticSearchServiceProvider
@Inject constructor(
        private val clusterServiceProvider: ClusterServiceProvider,
        private val elasticSearchConfigFile: MetadataSearchServiceConfigFile,
        @Named("interfaceIp") private val interfaceIp: String,
        @Named("elasticSearchPort") private val elasticSearchPort: Int,
        @Named("elasticSearchBinDir") private val elasticSearchBinDir: Path) : MetadataSearchServiceProvider {

    companion object {
        private val LOG = LoggerFactory.getLogger(ElasticSearchServiceProvider::class.java)
        private val IS_WINDOWS = System.getProperty("os.name").toLowerCase().indexOf("windows") > -1
        private val ELASTIC_SEARCH_EXE = if (IS_WINDOWS) "elasticsearch.bat" else "elasticsearch"
        private val KILL = if (IS_WINDOWS) "taskkill /F /PID " else "kill -9 "
        private val SLASH = if (IS_WINDOWS) "\\" else "/"

        val ELASTICSEARCH_CLUSTER_ENDPOINT = "elasticSearchClusterEndpoint"
    }

    private var elasticSearchProcess: Process? = null
    private var elasticSearchService: ElasticSearchService? = null

    override fun createNewMetadataSearchCluster(): Completable {
        // TODO add check to make sure we are not already in a cluster
        return startElasticSearch(true).andThen(createElasticSearchService())
    }

    override fun joinMetadataSearchCluster(): Completable {
        // TODO add check to make sure we are not already in a cluster
        return startElasticSearch(true).andThen(createElasticSearchService())
    }

    override fun metadataSearchNodeJoinedEvent(): Completable {
        closeElasticSearchProcess()
        LOG.info("Closed ElasticSearch Process")

        return startElasticSearch(false).andThen(createElasticSearchService())
    }

    override fun leaveMetadataSearchCluster(): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clusterHandler(event: ClusterEvent) {
        when (event) {
            is ClusterCreatedEvent -> {
                LOG.info("ClusterCreatedEvent -> Create ElasticSearch cluster")
                createNewMetadataSearchCluster()
                        .doOnError { t ->
                            LOG.error("Failed to create ElasticSearch node", t)
                        }.subscribe()
            }
            is ClusterJoinedEvent -> {
                LOG.info("ClusterJoinedEvent -> Attempting to join existing ElasticSearch cluster")
                joinMetadataSearchCluster()
                        .doOnError { t ->
                            LOG.error("Failed to join existing ElasticSearch cluster", t)
                        }.subscribe()
            }
            is ClusterNodeJoinedEvent -> {
                LOG.info("ClusterNodeJoinedEvent -> New ElasticSearch Node joined the cluster")
                metadataSearchNodeJoinedEvent()
                        .doOnError { t ->
                            LOG.error("Failed to join the new node to the ElasticSearch cluster", t)
                        }.subscribe()
            }
            is ClusterLeftEvent -> {
                LOG.info("ClusterLeftEvent -> shutdown the elasticSearch node")
                shutdown().subscribe()
            }
            is ClusterStartupEvent -> {
                LOG.info("ClusterStartupEvent -> startup the elasticSearch node after restart")
                joinMetadataSearchCluster()
                        .doOnError { t ->
                            LOG.error("Failed to join existing ElasticSearch cluster after restart", t)
                        }.subscribe()
            }
            else -> LOG.warn("Got an unhandled event: $event")
        }
    }

    override fun shutdown(): Completable {
        return Maybe.just(elasticSearchService).flatMapCompletable {
            it.closeConnection()
        }.doOnError{
            LOG.error("Elastic Search Service is not running", it)
        }.doOnComplete {
            LOG.info("Closed ElasticSearch Service")
        }.onErrorComplete()
                .andThen(closeElasticSearchProcess())
                .doOnComplete {
                    LOG.info("Closed ElasticSearch Process")
                }
    }

    private fun closeElasticSearchProcess() : Completable {
        return killElasticSearchProcess().andThen(Maybe.just(elasticSearchProcess)).flatMapCompletable {
            it.destroy()
            Completable.complete()
        }.doOnError {
            LOG.error("Failed to destroy elastic search process", it)
        }.onErrorComplete()
    }

    private fun killElasticSearchProcess() : Completable {
        return getElasticSearchProcessPid().flatMapCompletable { pid ->
            LOG.debug("About to kill elasticSearch pid $pid")
            val rt = Runtime.getRuntime()
            rt.exec(KILL + pid)
            Completable.complete()
        }.doOnError {
            LOG.error("Failed to kill elastic search process", it)
        }.onErrorComplete()
    }

    private fun getElasticSearchProcessPid(): Single<Long> {
        return Single.create { emitter ->
            try {

                val pidFilePath = Paths.get(elasticSearchBinDir.toString() + SLASH + "pid")

                if (Files.exists(pidFilePath))
                Scanner(pidFilePath.toFile()).use {
                    emitter.onSuccess(it.nextLong())
                }
            } catch (e: Exception) {
                LOG.error("Failed to read ElasticSearch pid file", e)
                emitter.onError(e)
            }
        }
    }

    override fun startService(): Completable {
        LOG.warn("Metadata start service not implemented")
        return Completable.complete()
    }

    override fun getService(): Single<MetadataSearchService> {
        return singleOfNullable(elasticSearchService) {
            Exception("The metadata service has not been started")
        }
    }

    private fun createElasticSearchService() : Completable {
        val clusterService = clusterServiceProvider.getService()
        val distributedSet = clusterService.map {  it.getDistributedSet<ElasticSearchNode>(ELASTICSEARCH_CLUSTER_ENDPOINT) }

        return distributedSet.flatMapCompletable {
            LOG.info("creating ElasticSearch client")
            elasticSearchService = ElasticSearchService(it.map { HttpHost(it.ip, it.port) })
            Completable.complete()
        }
    }

    private fun startElasticSearch(newNode: Boolean): Completable {
        // We only want to process the map call once all the Singles have emitted
        return Single.zip(clusterServiceProvider.getService(),
                createElasticSearchNodeProcess(),
                BiFunction<ClusterService, Process, Pair<ClusterService, Process>> { t1, t2 -> Pair(t1, t2) }
        ).map {
            if (!it.second.isAlive) throw Exception("Failed to start ElasticSearch node")
            LOG.info("Started ElasticSearch")
            it.first
        }.flatMapCompletable { clusterService ->
            if (newNode) {
                LOG.info("Adding ElasticSearch node to distributed cluster list")
                val distributedSet = clusterService.getDistributedSet<ElasticSearchNode>(ELASTICSEARCH_CLUSTER_ENDPOINT)
                distributedSet.add(ElasticSearchNode(interfaceIp, elasticSearchPort))
            }
            Completable.complete()
        }.doOnComplete {
            LOG.info("Started ElasticSearch node")
        }
    }

    private fun createElasticSearchNodeProcess(): Single<Process> {
        //Create the configuration file before starting elasticSearch node

        val pidFile = elasticSearchBinDir.toString() + SLASH + "pid"
        return elasticSearchConfigFile.createConfigFile()
                .andThen(runProcess(elasticSearchBinDir.toString() + SLASH + ELASTIC_SEARCH_EXE, "-d", "-p", pidFile)
                        .doOnSuccess {
                            elasticSearchProcess = it
                })

    }

    //TODO use as a until function
    private fun runProcess(vararg args: String): Single<Process> {
        return Single.create { emitter ->
            val processBuilder = ProcessBuilder(*args)

            LOG.info("Starting command: {}", processBuilder.command().joinToString(" "))

            processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT)
            processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT)
            emitter.onSuccess(processBuilder.start())
        }
    }
}

internal class ElasticSearchNode(val ip: String, val port: Int) : Serializable
