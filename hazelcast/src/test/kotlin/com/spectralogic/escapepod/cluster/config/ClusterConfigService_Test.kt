package com.spectralogic.escapepod.cluster.config

import com.spectralogic.escapepod.api.ClusterNode
import com.spectralogic.escapepod.cluster.models.ClusterConfigProto
import com.spectralogic.escapepod.util.ifNotNull
import com.spectralogic.escapepod.util.resource.Resource
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ClusterConfigService_Test {

    @Test
    fun createConfig() {
        val clusterConfigResource = ResourceStub()
        val clusterConfigService = ClusterConfigServiceImpl(clusterConfigResource)

        clusterConfigService.createConfig("test")

        val resource = clusterConfigService.getConfig()

        assertThat(resource).isNotNull()

        resource.ifNotNull {
            assertThat(it.name).isEqualTo("test")
        }
    }

    @Test
    fun deleteConfig() {
        val clusterConfigResource = ResourceStub()
        val clusterConfigService = ClusterConfigServiceImpl(clusterConfigResource)

        clusterConfigService.createConfig("test")

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

        clusterConfigService.createConfig("test")

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

        clusterConfigService.createConfig("test")
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
