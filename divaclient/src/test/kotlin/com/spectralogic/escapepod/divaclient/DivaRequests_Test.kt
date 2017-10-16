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

package com.spectralogic.escapepod.divaclient

import com.spectralogic.escapepod.divaclient.retrofit.RegisterClient
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