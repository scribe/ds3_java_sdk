package com.spectralogic.escapepod.divaclient

import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace

/**
 * <ns4:registerClientResponse xmlns:ns4="http://interaction.api.ws.diva.fpdigital.com/xsd">
<ns4:return>5b5a6592-2b56-498d-b204-9abe695ebbfa</ns4:return>
</ns4:registerClientResponse>
 */
@Namespace(prefix = "ns4", reference = "http://interaction.api.ws.diva.fpdigital.com/xsd")
internal class RegisterClientResponse {

    @Namespace(reference = "http://interaction.api.ws.diva.fpdigital.com/xsd")
    @field:Element(name = "return")
    var sessionId : String = ""

}
