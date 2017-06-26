package com.spectralogic.escapepod.divaclient

import org.junit.Test
import org.assertj.core.api.Assertions.*
import org.simpleframework.xml.core.Persister
import java.io.StringWriter

internal class DivaRequests_Test {

    @Test
    fun requestSerialization() {
        val persister = Persister()

        val registerRequest = RegisterClient()

        registerRequest.appName = "test"
        registerRequest.locName = "test"
        registerRequest.processId = "1"

        val stringWriter = StringWriter()

        persister.write(registerRequest, stringWriter)

        assertThat(stringWriter.toString()).isEqualTo("""
        *<xsd:registerClient xmlns:xsd="http://interaction.api.ws.diva.fpdigital.com/xsd">
        *   <xsd:appName>test</xsd:appName>
        *   <xsd:locName>test</xsd:locName>
        *   <xsd:processId>1</xsd:processId>
        *</xsd:registerClient>""".trimMargin("*"))
    }
}