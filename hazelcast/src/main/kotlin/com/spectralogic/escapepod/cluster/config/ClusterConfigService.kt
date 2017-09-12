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
import com.spectralogic.escapepod.util.append
import com.spectralogic.escapepod.util.resource.Resource
import com.spectralogic.escapepod.util.singleOfNullable
import io.reactivex.Single
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Inject

interface ClusterConfigService {
    fun createConfig(clusterName : String, nodeId: UUID)
    fun getConfig() : Single<ClusterConfig>
    fun addNode(node : ClusterNode)
    fun removeNode(node : ClusterNode)
    fun deleteConfig()
}

class ClusterConfigServiceImpl @Inject constructor(private val clusterConfigResource: Resource<ClusterConfig>): ClusterConfigService {

    private companion object {
        private val LOG = LoggerFactory.getLogger(ClusterConfigServiceImpl::class.java)
    }

    override fun createConfig(clusterName: String, nodeId : UUID) {
        LOG.info("Creating cluster config")
        clusterConfigResource.saveResource(createClusterConfig(clusterName, nodeId))
    }

    private fun createClusterConfig(clusterName: String, nodeId: UUID) : ClusterConfig {
        return ClusterConfig(clusterName, nodeId, emptySequence())
    }

    override fun getConfig(): Single<ClusterConfig> {
        return singleOfNullable(clusterConfigResource.getResource()) {
            Exception("There is no previous configuration")
        }
    }

    override fun addNode(node: ClusterNode) {

        val resource = clusterConfigResource.getResource()

        if (resource != null) {
            val nodeUrls = sequenceOf(node.toConfigNode())

            val updatedConfig = resource.copy(nodeList = resource.nodeList.append(nodeUrls))

            clusterConfigResource.saveResource(updatedConfig)
        } else {
            LOG.warn("Attempting to add a node to the config when there is no configuration")
        }
    }

    override fun removeNode(node: ClusterNode) {

        val resource = clusterConfigResource.getResource()

        if (resource != null) {

            val newList = resource.nodeList.filter { !(it.endpoint == node.ip && it.port == node.port)}

            val updatedConfig = resource.copy(nodeList = newList)
            clusterConfigResource.saveResource(updatedConfig)

        } else {
            LOG.warn("Attempting to remove a node from the config when there is no configuration")
        }
    }

    override fun deleteConfig() {
        clusterConfigResource.deleteResource()
    }

}

private fun ClusterNode.toConfigNode() : NodeUrl {
    return NodeUrl(this.ip, this.port)
}


