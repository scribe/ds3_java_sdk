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

package com.spectralogic.escapepod.divaclient.retrofit

import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace


/**
 *
 * <xsd:registerClient xmlns:xsd="http://interaction.api.ws.diva.fpdigital.com/xsd">
 *   <xsd:appName>Hello World Application</xsd:appName>
 *   <xsd:locName>2</xsd:locName>
 *   <xsd:processId>1</xsd:processId>
 * </xsd:registerClient>
 */

@Namespace(prefix = "xsd", reference = "http://interaction.api.ws.diva.fpdigital.com/xsd")
internal class RegisterClient {

    @field:Namespace(reference = "http://interaction.api.ws.diva.fpdigital.com/xsd")
    @field:Element
    var appName : String = ""

    @field:Namespace(reference = "http://interaction.api.ws.diva.fpdigital.com/xsd")
    @field:Element
    var locName : String = ""

    @field:Namespace(reference = "http://interaction.api.ws.diva.fpdigital.com/xsd")
    @field:Element
    var processId : String = ""
}

/**
 * <p:getGroupsList xmlns:p="http://interaction.api.ws.diva.fpdigital.com/xsd">
<xs:sessionCode xmlns:xs="http://interaction.api.ws.diva.fpdigital.com/xsd">sessionCode</xs:sessionCode>
</p:getGroupsList>
 */

@Namespace(prefix = "p", reference = "http://interaction.api.ws.diva.fpdigital.com/xsd")
internal class GetGroupsList {

    @field:Namespace(reference = "http://interaction.api.ws.diva.fpdigital.com/xsd", prefix = "xs")
    @field:Element(name = "sessionCode")
    var sessionId : String = ""
}

@Namespace(prefix = "p", reference = "http://interaction.api.ws.diva.fpdigital.com/xsd")
internal class GetSourceDestinationList {

    @field:Namespace(reference = "http://interaction.api.ws.diva.fpdigital.com/xsd", prefix = "xs")
    @field:Element(name = "sessionCode")
    var sessionId : String = ""

    @field:Namespace(reference = "http://interaction.api.ws.diva.fpdigital.com/xsd", prefix = "xs")
    @field:Element(name = "options")
    var options: String = ""
}

@Namespace(prefix = "p", reference = "http://interaction.api.ws.diva.fpdigital.com/xsd")
internal class GetObjectInfo {

    @field:Namespace(reference = "http://interaction.api.ws.diva.fpdigital.com/xsd", prefix = "xs")
    @field:Element(name = "sessionCode")
    var sessionId : String = ""

    @field:Namespace(reference = "http://interaction.api.ws.diva.fpdigital.com/xsd", prefix = "xs")
    @field:Element(name = "objectName")
    var objectName : String = ""

    @field:Namespace(reference = "http://interaction.api.ws.diva.fpdigital.com/xsd", prefix = "xs")
    @field:Element(name = "objectCategory")
    var objectCategory: String? = null
}

@Namespace(prefix = "p", reference = "http://interaction.api.ws.diva.fpdigital.com/xsd")
internal class RestoreObject {

    @field:Namespace(reference = "http://interaction.api.ws.diva.fpdigital.com/xsd", prefix = "xs")
    @field:Element(name = "sessionCode")
    var sessionId : String = ""

    @field:Namespace(reference = "http://interaction.api.ws.diva.fpdigital.com/xsd", prefix = "xs")
    @field:Element
    var objectName : String = ""

    @field:Namespace(reference = "http://interaction.api.ws.diva.fpdigital.com/xsd", prefix = "xs")
    @field:Element
    var objectCategory : String = ""

    @field:Namespace(reference = "http://interaction.api.ws.diva.fpdigital.com/xsd", prefix = "xs")
    @field:Element
    var destination : String = ""

    @field:Namespace(reference = "http://interaction.api.ws.diva.fpdigital.com/xsd", prefix = "xs")
    @field:Element
    var filesPathRoot : String = ""

    @field:Namespace(reference = "http://interaction.api.ws.diva.fpdigital.com/xsd", prefix = "xs")
    @field:Element
    var qualityOfService : Int = 0

    @field:Namespace(reference = "http://interaction.api.ws.diva.fpdigital.com/xsd", prefix = "xs")
    @field:Element
    var priorityLevel : Int = 0

    @field:Namespace(reference = "http://interaction.api.ws.diva.fpdigital.com/xsd", prefix = "xs")
    @field:Element
    var restoreOptions: String = ""
}

@Namespace(prefix = "p", reference = "http://interaction.api.ws.diva.fpdigital.com/xsd")
internal class GetRequestInfo {

    @field:Namespace(reference = "http://interaction.api.ws.diva.fpdigital.com/xsd", prefix = "xs")
    @field:Element(name = "sessionCode")
    var sessionId : String = ""

    @field:Namespace(reference = "http://interaction.api.ws.diva.fpdigital.com/xsd", prefix = "xs")
    @field:Element(name = "requestNumber")
    var requestId: Long = 0L
}


