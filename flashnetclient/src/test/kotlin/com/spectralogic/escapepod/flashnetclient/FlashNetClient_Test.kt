package com.spectralogic.escapepod.flashnetclient

import com.spectralogic.escapepod.flashnetclient.requests.FlashNetRequestFactoryImpl
import com.spectralogic.escapepod.flashnetclient.transport.SocketProviderImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class FlashNetClient_Test {
    @Test
    fun listGroups() {

        val requestFactoryImpl = FlashNetRequestFactoryImpl(FlashNetConfigImpl())
        val socketProvider = SocketProviderImpl()
        val flashNetClient = FlashNetVideoMediaClient(FlashnetEndpoint("10.98.4.16"), requestFactoryImpl, socketProvider)


        val storageGroups = flashNetClient.listStorageGroups().toList().blockingGet()

        assertThat(storageGroups).isNotNull
        assertThat(storageGroups).isNotEmpty

        storageGroups.forEach(System.out::println)
    }
}