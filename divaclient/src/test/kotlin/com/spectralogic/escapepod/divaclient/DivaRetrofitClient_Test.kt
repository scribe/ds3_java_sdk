package com.spectralogic.escapepod.divaclient

import com.spectralogic.escapepod.divaclient.retrofit.*
import com.spectralogic.escapepod.util.randomInt
import org.junit.Test
import org.assertj.core.api.Assertions.*
import org.junit.AfterClass
import org.junit.BeforeClass

internal class DivaRetrofitClient_Test {

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
        val divaClient = createDivaClient("http://kl-diva7:9763")
//        val address = divaStub.address()
//        println(address)
//        val divaClient = createDivaClient(address)

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
        val divaClient = createDivaClient("http://kl-diva7:9763")
//        val address = divaStub.address()
//        println(address)
//        val divaClient = createDivaClient(address)

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
    fun restoreObject() {
        val divaClient = createDivaClient("http://kl-diva7:9763")
        val clientRegistration = RegisterClient()
        clientRegistration.appName = "Escape_Pod_Test"
        clientRegistration.locName = "1"
        clientRegistration.processId = Int.randomInt().toString()

        val registerClientResponse = divaClient.registerClient(clientRegistration).blockingGet()

        assertThat(registerClientResponse.sessionId).isNotEmpty()

        val restoreObject = RestoreObject()
        restoreObject.objectName = "SM_DV-based_25_576i_25ndf_2s4f_v0_20170524122323.mxf"
        restoreObject.destination = "verde"
        restoreObject.filesPathRoot = ""
        restoreObject.objectCategory = ""
        restoreObject.priorityLevel = "-1"
        restoreObject.sessionId = registerClientResponse.sessionId
        restoreObject.qualityOfService = "0"

        val restoreResponse = divaClient.restoreObject(restoreObject).blockingGet()

        assertThat(restoreResponse.restoreReturn.divaStatus).isEqualTo("1000")
    }
}
