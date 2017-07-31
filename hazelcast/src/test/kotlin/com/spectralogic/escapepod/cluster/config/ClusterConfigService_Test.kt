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
import com.spectralogic.escapepod.util.ifNotNull
import com.spectralogic.escapepod.util.resource.Resource
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.*

class ClusterConfigService_Test {

    @Test
    fun createConfig() {
        val clusterConfigResource = ResourceStub()
        val clusterConfigService = ClusterConfigServiceImpl(clusterConfigResource)

        val id = UUID.randomUUID()

        clusterConfigService.createConfig("test", id)

        val resource = clusterConfigService.getConfig()

        assertThat(resource).isNotNull()

        resource.ifNotNull {
            assertThat(it.name).isEqualTo("test")
            assertThat(it.nodeId).isEqualTo(id)
        }
    }

    @Test
    fun deleteConfig() {
        val clusterConfigResource = ResourceStub()
        val clusterConfigService = ClusterConfigServiceImpl(clusterConfigResource)

        val id = UUID.randomUUID()

        clusterConfigService.createConfig("test", id)

        clusterConfigService.addNode(ClusterNode("localhost", 8080))
        val resource = clusterConfigService.getConfig()
        assertThat(resource).isNotNull()  // This is a precondition for the rest of the test

        clusterConfigService.deleteConfig()

        assertThat(clusterConfigResource.getResource()).isNull()
    }

    @Test
    fun addNodeToList() {
        val clusterConfigResource = ResourceStub()
        val clusterConfigService = ClusterConfigServiceImpl(clusterConfigResource)

        val id = UUID.randomUUID()

        clusterConfigService.createConfig("test", id)

        clusterConfigService.addNode(ClusterNode("localhost", 8080))

        val resource = clusterConfigService.getConfig()
        assertThat(resource).isNotNull()  // This is a precondition for the rest of the test
        assertThat(resource!!.nodesList).hasSize(1)

        val newNode = ClusterNode("test2", 8090)
        clusterConfigService.addNode(newNode)

        val updatedResource = clusterConfigService.getConfig()

        assertThat(updatedResource).isNotNull()

        assertThat(updatedResource!!.nodesList).hasSize(2)
        assertThat(updatedResource.nodesList.stream().filter { it.host.endpoint == "test2" && it.host.port == 8090 }.count()).isEqualTo(1)
    }

    @Test
    fun remoteNodeFromList() {
        val clusterConfigResource = ResourceStub()
        val clusterConfigService = ClusterConfigServiceImpl(clusterConfigResource)

        val id = UUID.randomUUID()

        clusterConfigService.createConfig("test", id)
        clusterConfigService.addNode(ClusterNode("localhost", 8080))

        val newNode = ClusterNode("test2", 8090)
        clusterConfigService.addNode(newNode)

        val resource = clusterConfigService.getConfig()
        assertThat(resource).isNotNull()  // This is a precondition for the rest of the test
        assertThat(resource!!.nodesList).hasSize(2)

        clusterConfigService.removeNode(ClusterNode("localhost", 8080))
        val updatedResource = clusterConfigService.getConfig()

        assertThat(updatedResource).isNotNull()

        assertThat(updatedResource!!.nodesList).hasSize(1)
        assertThat(updatedResource.nodesList.stream().filter { it.host.endpoint == "test2" && it.host.port == 8090 }.count()).isEqualTo(1)
    }
}


class ResourceStub : Resource<ClusterConfigProto.ClusterConfig> {

    private var resource : ClusterConfigProto.ClusterConfig? = null

    override fun getResource(): ClusterConfigProto.ClusterConfig? {
        return resource
    }

    override fun saveResource(resource: ClusterConfigProto.ClusterConfig) {
        this.resource = resource
    }

    override fun deleteResource() {
        this.resource = null
    }
}
