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

package com.spectralogic.escapepod.cluster.config

import com.spectralogic.escapepod.api.ClusterNode
import com.spectralogic.escapepod.cluster.models.ClusterConfigProto
import com.spectralogic.escapepod.cluster.models.Url
import com.spectralogic.escapepod.util.resource.Resource
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Inject

interface ClusterConfigService {
    fun createConfig(clusterName : String, nodeId: UUID)
    fun getConfig() : ClusterConfigProto.ClusterConfig?
    fun addNode(node : ClusterNode)
    fun removeNode(node : ClusterNode)
    fun deleteConfig()
}

class ClusterConfigServiceImpl @Inject constructor(private val clusterConfigResource: Resource<ClusterConfigProto.ClusterConfig>): ClusterConfigService {

    private companion object {
        private val LOG = LoggerFactory.getLogger(ClusterConfigServiceImpl::class.java)
    }

    override fun createConfig(clusterName: String, nodeId : UUID) {
        LOG.info("Creating cluster config")
        clusterConfigResource.saveResource(createClusterConfig(clusterName, nodeId))
    }

    private fun createClusterConfig(clusterName: String, nodeId: UUID) : ClusterConfigProto.ClusterConfig {
         return ClusterConfigProto.ClusterConfig.newBuilder().setName(clusterName).setNodeId(nodeId.toString()).build()
    }

    override fun getConfig(): ClusterConfigProto.ClusterConfig? {
        return clusterConfigResource.getResource()
    }

    override fun addNode(node: ClusterNode) {

        val resource = clusterConfigResource.getResource()

        if (resource != null) {
            val updatedConfig = ClusterConfigProto.ClusterConfig.newBuilder().mergeFrom(resource).addNodes(node.toConfigNode()).build()
            clusterConfigResource.saveResource(updatedConfig)
        } else {
            LOG.warn("Attempting to add a node to the config when there is no configuration")
        }
    }

    override fun removeNode(node: ClusterNode) {

        val resource = clusterConfigResource.getResource()

        if (resource != null) {

            val newList = resource.nodesList.filter { !(it.host.endpoint == node.ip && it.host.port == node.port)}

            val updatedConfig = ClusterConfigProto.ClusterConfig.newBuilder().setName(resource.name).addAllNodes(newList).build()
            clusterConfigResource.saveResource(updatedConfig)

        } else {
            LOG.warn("Attempting to remove a node from the config when there is no configuration")
        }
    }

    override fun deleteConfig() {
        clusterConfigResource.deleteResource()
    }

}

private fun ClusterNode.toConfigNode() : ClusterConfigProto.ClusterConfig.ClusterNode {
    return ClusterConfigProto.ClusterConfig.ClusterNode.newBuilder().setHost(Url.URL.newBuilder().setEndpoint(this.ip).setPort(this.port)).build()
}


