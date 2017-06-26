package com.spectralogic.escapepod.divaclient

import org.junit.Test
import org.simpleframework.xml.core.Persister
import org.assertj.core.api.Assertions.*

internal class DivaResponse_Test {

    @Test
    fun registerResponse() {

        val persister = Persister()

        val registerClientResponse = persister.read(RegisterClientResponse::class.java, """
            <ns4:registerClientResponse xmlns:ns4="http://interaction.api.ws.diva.fpdigital.com/xsd">
            <ns4:return>5b5a6592-2b56-498d-b204-9abe695ebbfa</ns4:return>
            </ns4:registerClientResponse>""")

        assertThat(registerClientResponse.sessionId).isEqualTo("5b5a6592-2b56-498d-b204-9abe695ebbfa")
    }
}
