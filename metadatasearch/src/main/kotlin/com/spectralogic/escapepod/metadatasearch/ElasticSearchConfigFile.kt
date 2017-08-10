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
import com.spectralogic.escapepod.api.MetadataSearchServiceConfigFile
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.functions.Function4
import org.slf4j.LoggerFactory
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

    override fun createConfigFile() : Completable {
        LOG.debug("Writing elasticSearch cluster config")

        val configFile = elasticSearchConfigDir.resolve("elasticsearch.yml")

        Files.newBufferedWriter(configFile, Charset.forName("UTF-8"),
                StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE, StandardOpenOption.WRITE).use { fileWriter ->

            val service = clusterServiceProvider.getService()

            val clusterName: Single<String> = service.flatMap(ClusterService::name)
            val instanceName: Single<String> = service.flatMap(ClusterService::instanceName)
            val clusterNodeCount: Single<Long> = service.flatMap{ clusterService ->
                clusterService.clusterNodes().count()
            }
            val endpoints: Single<String> = service.flatMapObservable {
                Observable.fromIterable(it.getDistributedSet<ElasticSearchNode>(ElasticSearchServiceProvider.ELASTICSEARCH_CLUSTER_ENDPOINT))
            }.map {
                "\"${it.ip}:${it.port}\""
            }.toList()
                    .map { it.joinToString(",") }

            return Single.zip(clusterName, instanceName, clusterNodeCount, endpoints, Function4<String, String, Long, String, ClusterVariables>(::ClusterVariables))
                    .flatMapCompletable {

                        fileWriter.write("cluster.name: ${it.clusterName}\n")

                        fileWriter.write("node.name: ${it.instanceName}\n")

                        fileWriter.write("network.host: $interfaceIp\n")
                        fileWriter.write("http.port: $elasticSearchPort\n")

                        fileWriter.write("discovery.zen.ping.unicast.hosts: [")
                        fileWriter.write(it.endpoints)
                        fileWriter.write("]\n")

                        fileWriter.write("discovery.zen.minimum_master_nodes: ${(it.nodeCount / 2) + 1}\n")
                        fileWriter.write("cluster.routing.allocation.disk.threshold_enabled: false\n")
                        Completable.complete()
                    }
        }
    }
}

private data class ClusterVariables(val clusterName: String, val instanceName: String, val nodeCount: Long, val endpoints: String)