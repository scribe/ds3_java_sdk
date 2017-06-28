package com.spectralogic.escapepod.api

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface DivaClientFactory {
    fun create(endpoint: String) : DivaClient
}

interface DivaClient {
    fun tapeGroups() : Observable<DivaTapeGroup>

    /**
     * Returns a list of objects for the given tape group
     */
    fun objects(tapeGroupName: String) : Observable<DivaObject>

    /**
     * TODO make destinationPath a Path object instead of a string
     *
     * @return Returns a Single that contains the diva request id if the request completed successfully
     */
    fun restore(objectName: String, objectCategory: String, destination: String, destinationPath: String) : Single<Int>

    fun restoreStatus(requestId : Int) : Single<DivaRestoreStatus>

    fun objectInfo(objectName: String) : Observable<DivaObjectInfo>

    fun sourceList() : Observable<DivaSource>
}

data class DivaTapeGroup(val name: String)
data class DivaObject(val name: String)
data class DivaObjectInfo(val name: String, val size: Long)
data class DivaSource(val address: String, val name: String)
data class DivaRestoreStatus(val requestState : String)