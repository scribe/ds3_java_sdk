package com.spectralogic.escapepod.flashnetclient.responses

import org.simpleframework.xml.Attribute

data class Group(
        @field:Attribute(name = "GroupName", required = false)
        @param:Attribute(name = "GroupName", required = false)
        val GroupName : String?,

        @field:Attribute(name = "GroupAge.DWD", required = false)
        @param:Attribute(name = "GroupAge.DWD", required = false)
        val GroupAge : Int?
)
