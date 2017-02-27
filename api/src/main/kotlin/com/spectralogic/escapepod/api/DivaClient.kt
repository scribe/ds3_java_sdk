package com.spectralogic.escapepod.api

interface DivaClient {
    fun tapeGroups() : Sequence<DivaTapeGroup>

    /**
     * Returns a list of objects for the given tape group
     */
    fun objects(tapeGroupName: String) : Sequence<DivaObject>

    fun transfer(objects: Sequence<String>, path: String)

    fun objectInfo(objectName: String) : Sequence<DivaObjectInfo>
}

data class DivaTapeGroup(val name: String)
data class DivaObject(val name: String)
data class DivaObjectInfo(val name: String, val size: Long)