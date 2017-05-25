package com.spectralogic.escapepod.metadatasearch

import com.google.common.base.Joiner
import com.spectralogic.escapepod.api.*
import io.reactivex.Completable
import io.reactivex.Single
import org.apache.http.HttpHost
import org.slf4j.LoggerFactory
import java.io.File
import java.io.Serializable
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Named
import kotlin.collections.HashSet

internal class ElasticSearchServiceProvider
@Inject constructor(
        private val clusterServiceProvider: ClusterServiceProvider,
        @Named("interfaceIp") private val interfaceIp: String,
        @Named("elasticSearchPort") private val elasticSearchPort: Int,
        @Named("elasticSearchBinDir") private val elasticSearchBinDir: Path,
        @Named("elasticSearchConfigDir") private val elasticSearchConfigDir: Path) : MetadataSearchServiceProvider {
    private companion object {
        private val LOG = LoggerFactory.getLogger(ElasticSearchServiceProvider::class.java)
        private val ELASTICSEARCH_CLUSTER_ENDPOINT = "elasticSearchClusterEndpoint"
        private val IS_WINDOWS = System.getProperty("os.name").toLowerCase().indexOf("windows") > -1
    }

    private lateinit var elasticSearchProcess: Process
    private lateinit var elasticSearchService: ElasticSearchService

    override fun createNewMetadataSearchCluster(): Completable {
        // TODO add check to make sure we are not already in a cluster
        return startElasticSearch(true).doOnComplete(this::createElasticSearchService)
    }

    override fun joinMetadataSearchCluster(): Completable {
        // TODO add check to make sure we are not already in a cluster
        return startElasticSearch(true).doOnComplete(this::createElasticSearchService)
    }

    override fun metadataSearchNodeJoinedEvent(): Completable {
        closeElasticSearchProcess()
        LOG.info("Closed ElasticSearch Process")

        return startElasticSearch(false).doOnComplete(this::createElasticSearchService)
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
            else -> LOG.error("Got an unhandled event: $event")
        }
    }

    override fun shutdown(): Completable {
        return Completable.create { emitter ->
            try {

                elasticSearchService.closeConnection()
                LOG.info("Closed ElasticSearch Service")

                closeElasticSearchProcess()
                LOG.info("Closed ElasticSearch Process")

                emitter.onComplete()
            } catch (t: Throwable) {
                emitter.onError(t)
            }
        }
    }

    private fun closeElasticSearchProcess() {
        killElasticSearchProcess()
        elasticSearchProcess.destroy()
        elasticSearchProcess.waitFor(30, TimeUnit.SECONDS)
    }

    private fun killElasticSearchProcess() {
        val pid = getElasticSearchProcessPid()
        LOG.debug("About to kill elasticSearch pid $pid")

        val rt = Runtime.getRuntime()
        if (IS_WINDOWS) {
            rt.exec("taskkill /F /PID $pid")
        } else {
            rt.exec("kill -9 $pid")
        }
    }

    private fun getElasticSearchProcessPid(): Long {
        try {
            val scanner = Scanner(File(elasticSearchBinDir.toString() + "/pid"))
            return scanner.nextLong()
        } catch (e: Exception) {
            LOG.error("Failed to read ElasticSearch pid file", e)
            throw e
        }
    }

    override fun startService(): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getService(): MetadataSearchService {
        return elasticSearchService
    }

    private fun createElasticSearchService() {
        val clusterService = clusterServiceProvider.getService()
        val distributedSet = clusterService.getDistributedSet<ElasticSearchNode>(ELASTICSEARCH_CLUSTER_ENDPOINT)

        LOG.info("creating ElasticSearch client")
        elasticSearchService = ElasticSearchService(distributedSet.map { HttpHost(it.ip, it.port) })
    }

    private fun startElasticSearch(newNode: Boolean): Completable {
        return Completable.create { emitter ->

            try {
                LOG.info("Starting ElasticSearch node")

                val clusterService = clusterServiceProvider.getService()
                createElasticSearchNodeProcess().doOnSuccess { process ->

                    elasticSearchProcess = process
                    elasticSearchProcess.waitFor(30, TimeUnit.SECONDS)

                    if (!elasticSearchProcess.isAlive) {
                        emitter.onError(Exception("Failed to start ElasticSearch node"))
                    } else {
                        if (newNode) {
                            val distributedSet =
                                    clusterService.getDistributedSet<ElasticSearchNode>(ELASTICSEARCH_CLUSTER_ENDPOINT)
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
        return Single.create { emitter ->
            //Create the configuration file before starting elasticSearch node
            createElasticSearchClusterConfig()

            val pidFile = elasticSearchBinDir.toString() + "/pid"
            val process: Process

            if (IS_WINDOWS) {
                process = runProcess(elasticSearchBinDir.toString() + "/elasticsearch.bat", "-d", "-p", pidFile)
            } else {
                process = runProcess(elasticSearchBinDir.toString() + "/elasticsearch", "-d", "-p", pidFile)
            }

            emitter.onSuccess(process)
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

        Files.newBufferedWriter(configFile, Charset.forName("UTF-8"),
                StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE).use {
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
            val strings: HashSet<String> = HashSet()
            clusterServiceProvider.getService().getDistributedSet<ElasticSearchNode>(ELASTICSEARCH_CLUSTER_ENDPOINT).map {
//                fileWriter.write("\"${it.ip}:${it.port}\"")
                strings.add("\"${it.ip}:${it.port}\"")
            }
            fileWriter.write(Joiner.on(",").join(strings))
            fileWriter.write("]\n")

            clusterServiceProvider.getService().clusterNodes().count().doOnSuccess {
                size ->
                fileWriter.write("discovery.zen.minimum_master_nodes: ${(size / 2) + 1}\n")
            }.subscribe()

            //TODO delete this
            fileWriter.write("cluster.routing.allocation.disk.threshold_enabled: false\n")

            clusterServiceProvider.getService().clusterNodes().map {
                (ip, port) ->
                LOG.warn("node.ip = $ip ; node.port = $port")
            }
        }

        return configFile
    }
}

internal class ElasticSearchNode(val ip: String, val port: Int) : Serializable
