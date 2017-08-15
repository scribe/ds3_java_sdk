package com.spectralogic.escapepod.flashnetclient.requests

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "FlashNetXML")
data class Request<out T>(
        @field:Attribute(name = "APIVersion")
        @param:Attribute(name = "APIVersion")
        val APIVersion : String,

        @field:Attribute(name = "SourceServer")
        @param:Attribute(name = "SourceServer")
        val SourceServer : String,

        @field:Attribute(name = "UserName")
        @param:Attribute(name = "UserName")
        val UserName : String?,

        @field:Attribute(name = "CallingApplication")
        @param:Attribute(name = "CallingApplication")
        val CallingApplication : String,

        @field:Attribute(name = "Operation")
        @param:Attribute(name = "Operation")
        val Operation : String,

        @field:Element(name = "requestSpecificElement", required = false)
        @param:Element(name = "requestSpecificElement", required = false)
        val requestSpecificElement : T?
)