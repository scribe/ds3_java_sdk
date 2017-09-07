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

import com.spectralogic.escapepod.api.ClusterService
import com.spectralogic.escapepod.api.ClusterServiceProvider
import com.spectralogic.escapepod.api.RequestContext
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.functions.Function5
import org.slf4j.LoggerFactory
import java.io.BufferedWriter
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption
import javax.inject.Inject
import javax.inject.Named

internal class ElasticSearchConfigFile
@Inject constructor(
        private val clusterServiceProvider: ClusterServiceProvider,
        @Named("interfaceIp") private val interfaceIp: String,
        @Named("elasticSearchPort") private val elasticSearchPort: Int,
        @Named("elasticSearchConfigDir") private val elasticSearchConfigDir: Path) : MetadataSearchServiceConfigFile {

    private companion object {
        private val LOG = LoggerFactory.getLogger(ElasticSearchConfigFile::class.java)
    }

    override fun createConfigFile(requestContext: RequestContext) : Completable {
        LOG.debug("Writing elasticSearch cluster config")

        val configFile = elasticSearchConfigDir.resolve("elasticsearch.yml")

        try {

            val fileWriterSingle: Single<BufferedWriter> = createFileSingle(configFile)

            val serviceSingle = clusterServiceProvider.getService(requestContext)

            val clusterNameSingle: Single<String> = serviceSingle.flatMap(ClusterService::name)
            val instanceNameSingle: Single<String> = serviceSingle.flatMap(ClusterService::instanceName)
            val clusterNodeCountSingle: Single<Long> = serviceSingle.flatMap{ clusterService ->
                clusterService.clusterNodes().count()
            }

            val endpoints: Single<String> = serviceSingle.map { clusterService ->
                clusterService.getDistributedSet<ElasticSearchNode>(ElasticSearchServiceProvider.ELASTICSEARCH_CLUSTER_ENDPOINT).joinToString(",") { elasticNode ->
                    "\"${elasticNode.ip}:${elasticNode.port}\"" }
            }

            return Single.zip(clusterNameSingle, instanceNameSingle, clusterNodeCountSingle, endpoints, fileWriterSingle, Function5<String, String, Long, String, BufferedWriter, ClusterVariables>(::ClusterVariables))
                    .flatMapCompletable {

                        val fileWriter = it.fileWriter

                        fileWriter.write("cluster.name: ${it.clusterName}\n")

                        fileWriter.write("node.name: ${it.instanceName}\n")

                        fileWriter.write("network.host: $interfaceIp\n")
                        fileWriter.write("http.port: $elasticSearchPort\n")

                        fileWriter.write("discovery.zen.ping.unicast.hosts: [")
                        fileWriter.write(it.endpoints)
                        fileWriter.write("]\n")

                        fileWriter.write("discovery.zen.minimum_master_nodes: ${(it.nodeCount / 2) + 1}\n")
                        fileWriter.write("cluster.routing.allocation.disk.threshold_enabled: false\n")
                        fileWriter.close()
                        Completable.complete()
                    }
        } catch (e: Throwable) {

            return Completable.error(e)
        }
    }

    /**
     * This creates a BufferedWriter that can be included in javarx chains and includes logic to close the resource after
     * the chain has been processed.
     */
    private fun createFileSingle(configFile: Path): Single<BufferedWriter> {
        LOG.info("Creating elastic search config file")
        val bufferedWriter = Files.newBufferedWriter(configFile, Charset.forName("UTF-8"),
                StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE, StandardOpenOption.WRITE)
        val fileWriterSingle: Single<BufferedWriter> = Single.just(bufferedWriter)
        fileWriterSingle.doFinally {
            LOG.info("Closing elastic search config file")
            bufferedWriter.close()
        }
        return fileWriterSingle
    }
}

private data class ClusterVariables(val clusterName: String, val instanceName: String, val nodeCount: Long, val endpoints: String, val fileWriter: BufferedWriter)