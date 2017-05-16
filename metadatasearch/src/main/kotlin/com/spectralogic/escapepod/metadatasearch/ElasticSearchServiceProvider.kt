package com.spectralogic.escapepod.metadatasearch

import com.spectralogic.escapepod.api.*
import io.reactivex.Completable
import io.reactivex.Single
import org.apache.http.HttpHost
import org.slf4j.LoggerFactory
import java.io.Serializable
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption
import javax.inject.Inject
import javax.inject.Named

internal class ElasticSearchServiceProvider
@Inject constructor(
        private val clusterServiceProvider: ClusterServiceProvider,
        @Named("interfaceIp") private val interfaceIp: String,
        @Named("elasticSearchPort") private val elasticSearchPort: Int,
        @Named("elasticSearchBinDir") private val elasticSearchBinDir: Path,
        @Named("elasticSearchConfigDir") private val elasticSearchConfigDir: Path) : MetadataSearchServiceProvider {
    private companion object {

        private val LOG = LoggerFactory.getLogger(ElasticSearchServiceProvider::class.java)
        private val ElasticSearch_CLUSTER_ENDPOINT = "elasticSearchClusterEndpoint"
    }

    private lateinit var elasticSearchProcess: Process
    private lateinit var elasticSearchClient: ElasticSearch

    override fun createNewMetadataSearchCluster(): Completable {
        // create new ElasticSearch process

        // TODO add check to make sure we are not already in a cluster
        return startElasticSearch(true).doOnComplete(this::createElasticSearchClient)
    }

    override fun joinMetadataSearchCluster(): Completable {
        // TODO add check to make sure we are not already in a cluster
        return startElasticSearch(true).doOnComplete(this::createElasticSearchClient)
    }

    override fun metadataSearchNodeJoinedEvent(): Completable {
        elasticSearchProcess.destroy()
        return startElasticSearch(false).doOnComplete(this::createElasticSearchClient)
    }

    override fun leaveMetadataSearchCluster(): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clusterHandler(event: ClusterEvent) {
//        val createNewMetadataSearchCluster = createNewMetadataSearchCluster()
        if (event is ClusterCreatedEvent) {
            LOG.info("ClusterCreatedEvent -> Create ElasticSearch cluster")
            createNewMetadataSearchCluster()
                    .doOnError { t ->
                        LOG.error("Failed to create ElasticSearch node", t)
                    }.subscribe()
        } else if (event is ClusterJoinedEvent) {
            LOG.info("ClusterJoinedEvent -> Attempting to join existing ElasticSearch cluster")
            joinMetadataSearchCluster()
                    .doOnError { t ->
                        LOG.error("Failed to join existing ElasticSearch cluster", t)
                    }.subscribe()
        } else if (event is ClusterNodeJoinedEvent) {
            LOG.info("ClusterNodeJoinedEvent -> New ElasticSearch Node joined the cluster")
            metadataSearchNodeJoinedEvent()
                    .doOnError { t ->
                        LOG.error("Failed to join the new node to the ElasticSearch cluster", t)
                    }.subscribe()

        } else if (event is ClusterLeftEvent) {
            LOG.info("ClusterLeftEvent -> shutdown the elasticSearch node")
            shutdown().subscribe()
        } else if (event is ClusterStartupEvent) {
            LOG.error("ClusterStartupEvent -> startup the elasticSearch node after restart")
        } else {
            LOG.error("Got an unhandled event: $event")
        }
    }

    override fun shutdown(): Completable {
        throw Exception()
//        return Completable.create { emitter ->
//            try {
//
//                entryAddedDisposable.ifNotNull {
//                    it.dispose()
//                    entryAddedDisposable = null
//                }
//
//                mongoClient.ifNotNull {
//                    it.close()
//                    mongoClient = null
//                }
//
//                mongoProcess.ifNotNull {
//                    it.destroy()
//                    it.waitFor(30, TimeUnit.SECONDS)
//
//                    if (it.isAlive) {
//                        LOG.error("Mongo instance still active after shutdown attempt")
//                    } else {
//                        LOG.info("Mongo exited successfully with exit code: {}", it.exitValue())
//                    }
//                    mongoProcess = null
//                }
//
//                emitter.onComplete()
//            } catch (t : Throwable) {
//                emitter.onError(t)
//            }
//        }
    }

    override fun startService(): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getService(): MetadataSearchService {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun createElasticSearchClient() {
        val clusterService = clusterServiceProvider.getService()
        val distributedSet = clusterService.getDistributedSet<ElasticSearchNode>(ElasticSearch_CLUSTER_ENDPOINT)

        LOG.info("creating ElasticSearch client")
        elasticSearchClient = ElasticSearch(distributedSet.map { HttpHost(it.ip, it.port) })
    }

    private fun startElasticSearch(newNode: Boolean): Completable {
        return Completable.create { emitter ->

            try {
                LOG.info("Starting ElasticSearch node")

                val clusterService = clusterServiceProvider.getService()
                createElasticSearchNodeProcess().doOnSuccess { process ->

                    elasticSearchProcess = process

                    if (!elasticSearchProcess.isAlive) {
                        emitter.onError(Exception("Failed to start ElasticSearch node"))
                    } else {
                        if (newNode) {
                            val distributedSet = clusterService.getDistributedSet<ElasticSearchNode>(ElasticSearch_CLUSTER_ENDPOINT)
                            distributedSet.add(ElasticSearchNode(interfaceIp, elasticSearchPort))
                        }
                        LOG.info("Started ElasticSearch node")
                        emitter.onComplete()
                    }
                }.subscribe()

            } catch (t: Throwable) {
                emitter.onError(t)
            }
        }
    }

    private fun createElasticSearchNodeProcess(): Single<Process> {
        return Single.create {
            //Create the configuration file before starting elasticSearch node
            createElasticSearchClusterConfig()

            //TODO use a diff script for Windows and Linux
            runProcess(elasticSearchBinDir.toString() + "/elasticsearch.bat")
        }
    }

    //TODO use as a until function
    private fun runProcess(vararg args: String): Process {
        val processBuilder = ProcessBuilder(*args)

        LOG.info("Starting command: {}", processBuilder.command().joinToString(" "))

        processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT)
        processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT)
        return processBuilder.start()
    }

    private fun createElasticSearchClusterConfig(): Path {
        LOG.debug("Writing elasticSearch cluster config")

        val configFile = elasticSearchConfigDir.resolve("elasticsearch.yml")

        Files.newBufferedWriter(configFile, Charset.forName("UTF-8"), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE).use {
            val fileWriter = it

            clusterServiceProvider.getService().name().doOnSuccess {
                name ->
                fileWriter.write("cluster.name: $name\n")
            }.subscribe()

            clusterServiceProvider.getService().instanceName().doOnSuccess {
                instanceName ->
                fileWriter.write("node.name: $instanceName\n")
            }.subscribe()

            fileWriter.write("network.host: $interfaceIp\n")
            fileWriter.write("http.port: $elasticSearchPort\n")

            fileWriter.write("discovery.zen.ping.unicast.hosts: [")
            clusterServiceProvider.getService().getDistributedSet<ElasticSearchNode>(ElasticSearch_CLUSTER_ENDPOINT).map {
                fileWriter.write("\"${it.ip}:${it.port}\"")
            }
            fileWriter.write("]\n")

            clusterServiceProvider.getService().clusterNodes().count().doOnSuccess {
                size ->
                fileWriter.write("discovery.zen.minimum_master_nodes: ${(size / 2) + 1}\n")
            }.subscribe()

            //TODO delete this
            fileWriter.write("cluster.routing.allocation.disk.threshold_enabled: false\n")

            clusterServiceProvider.getService().clusterNodes().map {
                (ip, port) ->
                LOG.warn("node.ip = ${ip} ; node.port = ${port}")
            }
        }

        return configFile
    }
}

internal class ElasticSearchNode(val ip: String, val port: Int) : Serializable
