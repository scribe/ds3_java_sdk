package com.spectralogic.escapepod.avidmamclient

import com.spectralogic.escapepod.restclientutils.RetrofitClientFactoryImpl
import org.junit.Test
import org.assertj.core.api.Assertions.*

class AvidMamRetrofitClient_Test {

    @Test
    fun login() {
        val retrofitClientFactoryImpl = RetrofitClientFactoryImpl()
        val createDivaClient = retrofitClientFactoryImpl.createRestClient("http://10.129.156.54:9900", AvidMamRetrofitClient::class.java)

        val loginSession = createDivaClient.login("admin", "nimda").blockingGet()

        assertThat(loginSession).isNotNull()
        println(loginSession)
    }

    @Test
    fun getKey() {
        val retrofitClientFactoryImpl = RetrofitClientFactoryImpl()
        val avidMamRetrofitClient = retrofitClientFactoryImpl.createRestClient("http://10.129.156.54:9910", AvidMamRetrofitClient::class.java)

        val version = avidMamRetrofitClient.getKey("Global", "SystemInfo/SystemVersion").blockingGet()

        assertThat(version.value).isNotNull()
        println(version.value)

        val indexPathPrefix = avidMamRetrofitClient.getKey("SpectraBlackPearlConnector_1", "Config/TpfrResultFolder").blockingGet()

        assertThat(indexPathPrefix.value).isNotNull()
        println(indexPathPrefix.value)
    }

    @Test
    fun listDivaAssetsFromDatabase() {
        val avidMamDbClientFactory = AvidMamDbClientFactory()

        val dbClient = avidMamDbClientFactory.createClient("kl-pm-mam59a", "sa", "M8nichts")

        for ((fileName, filePath) in dbClient.listDivaAssets()) {
            println("Filename: $fileName, category: $filePath")
        }
    }
}
