package com.spectralogic.escapepod.flashnetclient.requests

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "Migrate")
data class Migrate(
        @field:Attribute(name = "SourceVolume")
        @param:Attribute(name = "SourceVolume")
        val SourceVolume : String,

        @field:Attribute(name = "SourceArchive.DWD")
        @param:Attribute(name = "SourceArchive.DWD")
        val SourceArchive : Int,

        @field:Attribute(name = "DestVolume")
        @param:Attribute(name = "DestVolume")
        val DestVolume : String,

        @field:Attribute(name = "MoveAssets.DWD", required = false)
        @param:Attribute(name = "MoveAssets.DWD", required = false)
        val MoveAssets : Int?
)
