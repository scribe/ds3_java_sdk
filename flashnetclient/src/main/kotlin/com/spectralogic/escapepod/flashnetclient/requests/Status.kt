package com.spectralogic.escapepod.flashnetclient.requests

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "Status")
data class Status(
        @field:Attribute(name = "RequestId.DWD")
        @param:Attribute(name = "RequestId.DWD")
        val RequestId : Int,

        @field:Attribute(name = "Guid", required = false)
        @param:Attribute(name = "Guid", required = false)
        val Guid : String?
)