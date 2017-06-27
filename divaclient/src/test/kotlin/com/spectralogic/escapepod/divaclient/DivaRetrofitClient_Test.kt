package com.spectralogic.escapepod.divaclient

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
}
