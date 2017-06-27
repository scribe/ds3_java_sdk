package com.spectralogic.escapepod.divaclient

import org.simpleframework.xml.*

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

/**
 * <ns4:getGroupsListResponse xmlns:ns4="http://interaction.api.ws.diva.fpdigital.com/xsd">
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
</ns4:getGroupsListResponse>
 */


@Namespace(reference = "http://interaction.api.ws.diva.fpdigital.com/xsd", prefix = "ns4")
internal class GetGroupsListResponse {

    @field:Element(name = "return")
    var groupReturn : GetGroupsListReturn = GetGroupsListReturn()
}

@NamespaceList(
            Namespace(reference = "http://response.model.api.ws.diva.fpdigital.com/xsd", prefix = "ns1"),
            Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi")
    )
internal class GetGroupsListReturn {

    @field:Namespace(reference = "http://interaction.api.ws.diva.fpdigital.com/xsd")
    @field:Element
    var divaStatus : String = ""

    @field:Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance")
    @field:Attribute
    var type : String = ""

    @field:Namespace(reference = "http://response.model.api.ws.diva.fpdigital.com/xsd")
    @field:ElementList(inline = true)
    var groups : List<Groups> = ArrayList()

}

/**
 *
<ns2:groupDesc xmlns:ns2="http://model.api.ws.diva.fpdigital.com/xsd">groupDesc2</ns2:groupDesc>
<ns2:groupName xmlns:ns2="http://model.api.ws.diva.fpdigital.com/xsd">groupName2</ns2:groupName>
 */
internal class Groups {
    //@field:Namespace(reference = "http://model.api.ws.diva.fpdigital.com/xsd", prefix = "ns2")
    @field:Element
    var groupDesc : String = ""

    @field:Namespace(reference = "http://model.api.ws.diva.fpdigital.com/xsd", prefix = "ns2")
    @field:Element
    var groupName : String = ""

    @field:Namespace(reference = "http://model.api.ws.diva.fpdigital.com/xsd", prefix = "ns2")
    @field:Element
    var mediaFormatId : String = ""
}