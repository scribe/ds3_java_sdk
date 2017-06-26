package com.spectralogic.escapepod.divaclient

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
