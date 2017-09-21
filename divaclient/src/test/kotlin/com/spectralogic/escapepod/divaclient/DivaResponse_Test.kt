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

import com.spectralogic.escapepod.divaclient.retrofit.GetGroupsListResponse
import com.spectralogic.escapepod.divaclient.retrofit.RegisterClientResponse
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

    @Test
    fun getTapeGroupList() {
        val persister = Persister()

        val getTapeGroupResponse = persister.read(GetGroupsListResponse::class.java, """
            <ns4:getGroupsListResponse xmlns:ns4="http://interaction.api.ws.diva.fpdigital.com/xsd">
            <ns4:return xmlns:ns1="http://response.model.api.ws.diva.fpdigital.com/xsd" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:type="ns1:DivaGroupsListResponse">
            <ns1:divaStatus>divaStatus</ns1:divaStatus>
            <ns1:groups>
            <ns2:groupDesc xmlns:ns2="http://model.api.ws.diva.fpdigital.com/xsd">groupDesc1</ns2:groupDesc>
            <ns2:groupName xmlns:ns2="http://model.api.ws.diva.fpdigital.com/xsd">groupName1</ns2:groupName>
            </ns1:groups>
            <ns1:groups>
            <ns2:groupDesc xmlns:ns2="http://model.api.ws.diva.fpdigital.com/xsd">groupDesc2</ns2:groupDesc>
            <ns2:groupName xmlns:ns2="http://model.api.ws.diva.fpdigital.com/xsd">groupName2</ns2:groupName>
            </ns1:groups>
            </ns4:return>
            </ns4:getGroupsListResponse>""")

        assertThat(getTapeGroupResponse.groupReturn.divaStatus).isEqualTo("divaStatus")
        assertThat(getTapeGroupResponse.groupReturn.groups.size).isEqualTo(2)
    }
}