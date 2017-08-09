package com.spectralogic.escapepod.flashnetclient.responses

import org.simpleframework.xml.Attribute

data class StatusInfo(
    @field:Attribute(name = "Priority.DWD", required = false)
    @param:Attribute(name = "Priority.DWD", required = false)
    val Priority : Int?,

    @field:Attribute(name = "SourceServer", required = false)
    @param:Attribute(name = "SourceServer", required = false)
    val SourceServer : String?
)

