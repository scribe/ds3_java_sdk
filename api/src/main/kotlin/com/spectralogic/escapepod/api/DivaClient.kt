package com.spectralogic.escapepod.api

import io.reactivex.Completable
import io.reactivex.Observable

interface DivaClientFactory {
    fun create(endpoint: String, clientName: String) : DivaClient
}

interface DivaClient {
    fun tapeGroups() : Observable<DivaTapeGroup>

    /**
     * Returns a list of objects for the given tape group
     */
    fun objects(tapeGroupName: String) : Observable<DivaObject>

    /**
     * TODO make destinationPath a Path object instead of a string
     */
    fun restore(objectName: String, objectCategory: String, destination: String, destinationPath: String) : Completable

    fun objectInfo(objectName: String) : Observable<DivaObjectInfo>

    fun sourceList() : Observable<DivaSource>
}

data class DivaTapeGroup(val name: String)
data class DivaObject(val name: String)
data class DivaObjectInfo(val name: String, val size: Long)
data class DivaSource(val address: String, val name: String)