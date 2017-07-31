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

import com.google.common.base.Joiner
import com.spectralogic.escapepod.api.ClusterServiceProvider
import com.spectralogic.escapepod.api.MetadataSearchServiceConfigFile
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

    override fun createConfigFile() {
        LOG.debug("Writing elasticSearch cluster config")

        val configFile = elasticSearchConfigDir.resolve("elasticsearch.yml")

        Files.newBufferedWriter(configFile, Charset.forName("UTF-8"),
                StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE, StandardOpenOption.WRITE).use {
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
            clusterServiceProvider.getService()
                    .getDistributedSet<ElasticSearchNode>(ElasticSearchServiceProvider.ELASTICSEARCH_CLUSTER_ENDPOINT)
                    .forEach {
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
        }
    }

}
