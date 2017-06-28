package com.greyrock.escapepod.migrate

import com.spectralogic.tpfr.api.ServerServiceFactoryImpl
import com.spectralogic.tpfr.client.ClientImpl
import com.spectralogic.tpfr.client.model.IndexResult
import io.reactivex.Single
import org.junit.Test
import org.assertj.core.api.Assertions.*

internal class MigrateFromDiva_Test {

    @Test
    fun marquisIndex() {
        val serverServiceFactory = ServerServiceFactoryImpl("http://10.129.156.49:60792")

        val clientImpl = ClientImpl(serverServiceFactory.createServerService())

        val indexStatus = Single.fromFuture(clientImpl.indexFile("\\\\10.129.154.30\\vol2\\SM_DV-based_25_576i_25ndf_2s4f_v0_20170524122308.mxf")).blockingGet()

        if (indexStatus.indexResult == IndexResult.Failed) {
            println("Failed to index: " + indexStatus.errorMessage)
        }

        assertThat(indexStatus.indexResult).isEqualTo(IndexResult.Succeeded)
    }

    @Test
    fun marquisFileStatus() {
        val serverServiceFactory = ServerServiceFactoryImpl("http://10.129.156.49:60792")

        val clientImpl = ClientImpl(serverServiceFactory.createServerService())

        val indexStatus = Single.fromFuture(clientImpl.fileStatus("\\\\10.129.154.30\\vol2\\SM_DV-based_25_576i_25ndf_2s4f_v0_20170524122308.mxf")).blockingGet()

        if (indexStatus.indexResult == IndexResult.Failed) {
            println("Failed to index: " + indexStatus.errorMessage)
        }

        assertThat(indexStatus.indexResult).isEqualTo(IndexResult.Succeeded)
    }
}
