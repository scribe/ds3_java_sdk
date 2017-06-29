package com.spectralogic.escapepod.divaclient

import com.spectralogic.escapepod.divaclient.retrofit.*
import com.spectralogic.escapepod.divaclient.session.DivaSessionFactoryImpl
import com.spectralogic.escapepod.restclientutils.RetrofitClientFactoryImpl
import com.spectralogic.escapepod.util.randomInt
import org.junit.Test
import org.assertj.core.api.Assertions.*
import org.junit.AfterClass
import org.junit.BeforeClass

internal class DivaRetrofitClient_Test {
    private val divaRetrofitClientFactoryImpl = RetrofitClientFactoryImpl()
    companion object {

        val divaStub = DivaStub()

        @BeforeClass
        @JvmStatic
        fun beforeClass() {
            divaStub.start()
        }

        @AfterClass
        @JvmStatic
        fun afterClass() {
            divaStub.stop()
        }
    }

    @Test
    fun displayTapeGroups() {
        val divaClient = divaRetrofitClientFactoryImpl.createRestClient("http://kl-diva7:9763", DivaRetrofitClient::class.java, "/services/DIVArchiveWS_REST_2.0/")

        val clientRegistration = RegisterClient()
        clientRegistration.appName = "Escape_Pod_Test"
        clientRegistration.locName = "1"
        clientRegistration.processId = Int.randomInt().toString()

        val registerClientResponse = divaClient.registerClient(clientRegistration).blockingGet()

        assertThat(registerClientResponse.sessionId).isNotEmpty()

        val getGroupsList = GetGroupsList()
        getGroupsList.sessionId = registerClientResponse.sessionId

        val groupList = divaClient.getTapeGroups(getGroupsList).blockingGet()

        assertThat(groupList.groupReturn.divaStatus).isEqualTo("1000")
    }

    @Test
    fun displaySourceDestinationList() {
        val divaClient = divaRetrofitClientFactoryImpl.createRestClient("http://kl-diva7:9763", DivaRetrofitClient::class.java, "/services/DIVArchiveWS_REST_2.0/")

        val clientRegistration = RegisterClient()
        clientRegistration.appName = "Escape_Pod_Test"
        clientRegistration.locName = "1"
        clientRegistration.processId = Int.randomInt().toString()

        val registerClientResponse = divaClient.registerClient(clientRegistration).blockingGet()

        assertThat(registerClientResponse.sessionId).isNotEmpty()

        val getSourceDestinationList = GetSourceDestinationList()
        getSourceDestinationList.sessionId = registerClientResponse.sessionId

        val sourceDestinationList = divaClient.getSourceDestinationList(getSourceDestinationList).blockingGet()

        assertThat(sourceDestinationList.sourceReturn.divaStatus).isEqualTo("1000")
    }

    @Test
    fun objectInfo() {
        val divaClient = divaRetrofitClientFactoryImpl.createRestClient("http://kl-diva7:9763", DivaRetrofitClient::class.java, "/services/DIVArchiveWS_REST_2.0/")

        val clientRegistration = RegisterClient()
        clientRegistration.appName = "Escape_Pod_Test"
        clientRegistration.locName = "1"
        clientRegistration.processId = Int.randomInt().toString()

        val registerClientResponse = divaClient.registerClient(clientRegistration).blockingGet()

        assertThat(registerClientResponse.sessionId).isNotEmpty()

        val getObjectInfo = GetObjectInfo()
        getObjectInfo.objectName = "SM_DV-based_25_576i_25ndf_2s4f_v0_20170524122323.mxf"
        getObjectInfo.objectCategory = ""
        getObjectInfo.sessionId = registerClientResponse.sessionId

        val getObjectInfoResponse = divaClient.getObjectInfo(getObjectInfo).blockingGet()
        assertThat(getObjectInfoResponse.sourceReturn.divaStatus).isEqualTo(1000)
    }

    @Test
    fun restoreObject() {
        val divaClientImpl = DivaClientImpl("http://kl-diva7:9763", RetrofitClientFactoryImpl(), DivaSessionFactoryImpl())
        val restore = divaClientImpl.restore("SM_DV-based_25_576i_25ndf_2s4f_v0_20170524122323.mxf", "", "verde2", "")
        val requestId = restore.blockingGet()
        assertThat(requestId).isNotEqualTo(0)

        val restoreStatus = divaClientImpl.restoreStatus(requestId).blockingGet()
        assertThat(restoreStatus.requestState).isNotEqualTo(0)
        assertThat(restoreStatus.requestState).isNotEqualTo(6)
    }
}
