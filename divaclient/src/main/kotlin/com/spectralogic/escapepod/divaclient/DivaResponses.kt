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

/**
 * <ns4:getSourceDestinationListResponse xmlns:ns4="http://interaction.api.ws.diva.fpdigital.com/xsd">
<ns4:return xmlns:ns1="http://response.model.api.ws.diva.fpdigital.com/xsd" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:type="ns1:DivaSourceDestinationListResponse">
<ns1:divaStatus>1000</ns1:divaStatus>
<ns1:arraysInfo>
<ns2:serversAddress xmlns:ns2="http://model.api.ws.diva.fpdigital.com/xsd">serversAddress</ns2:serversAddress>
<ns2:serversConnectOption xmlns:ns2="http://model.api.ws.diva.fpdigital.com/xsd">serversConnectOption</ns2:serversConnectOption>
<ns2:serversMaxAccess xmlns:ns2="http://model.api.ws.diva.fpdigital.com/xsd">serversMaxAccess</ns2:serversMaxAccess>
<ns2:serversMaxReadAccess xmlns:ns2="http://model.api.ws.diva.fpdigital.com/xsd">serversMaxReadAccess</ns2:serversMaxReadAccess>
<ns2:serversMaxThroughput xmlns:ns2="http://model.api.ws.diva.fpdigital.com/xsd">serversMaxThroughput</ns2:serversMaxThroughput>
<ns2:serversMaxWriteAccess xmlns:ns2="http://model.api.ws.diva.fpdigital.com/xsd">serversMaxWriteAccess</ns2:serversMaxWriteAccess>
<ns2:serversName xmlns:ns2="http://model.api.ws.diva.fpdigital.com/xsd">serversName</ns2:serversName>
<ns2:serversProductionSystem xmlns:ns2="http://model.api.ws.diva.fpdigital.com/xsd">serversProductionSystem</ns2:serversProductionSystem>
<ns2:serversRootPath xmlns:ns2="http://model.api.ws.diva.fpdigital.com/xsd">/serversRootPath</ns2:serversRootPath>
<ns2:serversSourceType xmlns:ns2="http://model.api.ws.diva.fpdigital.com/xsd">serversSourceType</ns2:serversSourceType>
</ns1:arraysInfo>
<ns1:arraysInfo>
<ns2:serversAddress xmlns:ns2="http://model.api.ws.diva.fpdigital.com/xsd">serversAddress1</ns2:serversAddress>
<ns2:serversConnectOption xmlns:ns2="http://model.api.ws.diva.fpdigital.com/xsd">serversConnectOption1</ns2:serversConnectOption>
<ns2:serversMaxAccess xmlns:ns2="http://model.api.ws.diva.fpdigital.com/xsd">serversMaxAccess</ns2:serversMaxAccess>
<ns2:serversMaxReadAccess xmlns:ns2="http://model.api.ws.diva.fpdigital.com/xsd">serversMaxReadAccess</ns2:serversMaxReadAccess>
<ns2:serversMaxThroughput xmlns:ns2="http://model.api.ws.diva.fpdigital.com/xsd">serversMaxThroughput</ns2:serversMaxThroughput>
<ns2:serversMaxWriteAccess xmlns:ns2="http://model.api.ws.diva.fpdigital.com/xsd">serversMaxWriteAccess</ns2:serversMaxWriteAccess>
<ns2:serversName xmlns:ns2="http://model.api.ws.diva.fpdigital.com/xsd">serversName</ns2:serversName>
<ns2:serversProductionSystem xmlns:ns2="http://model.api.ws.diva.fpdigital.com/xsd">serversProductionSystem</ns2:serversProductionSystem>
<ns2:serversRootPath xmlns:ns2="http://model.api.ws.diva.fpdigital.com/xsd"/>
<ns2:serversSourceType xmlns:ns2="http://model.api.ws.diva.fpdigital.com/xsd">serversSourceType</ns2:serversSourceType>
</ns1:arraysInfo>
</ns4:return>
</ns4:getSourceDestinationListResponse>
 */

@Namespace(reference = "http://interaction.api.ws.diva.fpdigital.com/xsd", prefix = "ns4")
internal class GetSourceDestinationListResponse {

    @field:Element(name = "return")
    var sourceReturn: GetSourceDestinationResult = GetSourceDestinationResult()
}

@NamespaceList(
            Namespace(reference = "http://response.model.api.ws.diva.fpdigital.com/xsd", prefix = "ns1"),
            Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi")
    )
internal class GetSourceDestinationResult {
    @field:Namespace(reference = "http://interaction.api.ws.diva.fpdigital.com/xsd")
    @field:Element
    var divaStatus : String = ""

    @field:Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance")
    @field:Attribute
    var type : String = ""

    @field:Namespace(reference = "http://interaction.api.ws.diva.fpdigital.com/xsd")
    @field:ElementList(inline = true)
    var arraysInfo : List<ArraysInfo> = ArrayList()
}

internal class ArraysInfo {

    @field:Namespace(reference = "http://model.api.ws.diva.fpdigital.com/xsd", prefix = "ns2")
    @field:Element
    var serversAddress: String = ""

    @field:Namespace(reference = "http://model.api.ws.diva.fpdigital.com/xsd", prefix = "ns2")
    @field:Element
    var serversConnectOption: String = ""

    @field:Namespace(reference = "http://model.api.ws.diva.fpdigital.com/xsd", prefix = "ns2")
    @field:Element
    var serversMaxAccess: String = ""

    @field:Namespace(reference = "http://model.api.ws.diva.fpdigital.com/xsd", prefix = "ns2")
    @field:Element
    var serversMaxReadAccess: String = ""

    @field:Namespace(reference = "http://model.api.ws.diva.fpdigital.com/xsd", prefix = "ns2")
    @field:Element
    var serversMaxThroughput: String = ""

    @field:Namespace(reference = "http://model.api.ws.diva.fpdigital.com/xsd", prefix = "ns2")
    @field:Element
    var serversMaxWriteAccess: String = ""

    @field:Namespace(reference = "http://model.api.ws.diva.fpdigital.com/xsd", prefix = "ns2")
    @field:Element
    var serversName: String = ""

    @field:Namespace(reference = "http://model.api.ws.diva.fpdigital.com/xsd", prefix = "ns2")
    @field:Element
    var serversProductionSystem: String = ""

    @field:Namespace(reference = "http://model.api.ws.diva.fpdigital.com/xsd", prefix = "ns2")
    @field:Element(required = false)
    var serversRootPath: String = ""

    @field:Namespace(reference = "http://model.api.ws.diva.fpdigital.com/xsd", prefix = "ns2")
    @field:Element
    var serversSourceType: String = ""
}

