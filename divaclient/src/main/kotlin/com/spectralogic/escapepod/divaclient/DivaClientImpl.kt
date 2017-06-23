package com.spectralogic.escapepod.divaclient

import com.google.inject.assistedinject.Assisted
import com.spectralogic.escapepod.api.DivaClient
import com.spectralogic.escapepod.api.DivaObject
import com.spectralogic.escapepod.api.DivaObjectInfo
import com.spectralogic.escapepod.api.DivaTapeGroup
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

internal class DivaClientImpl @Inject constructor(@Assisted val endpoint: String, @Assisted clientName : String): DivaClient {

    override fun tapeGroups(): Observable<DivaTapeGroup> {
        return Observable.empty()
    }

    override fun objects(tapeGroupName: String): Observable<DivaObject> {
        return Observable.empty()
    }

    override fun transfer(objects: Sequence<String>, path: String) : Completable {
        return Completable.complete()
    }

    override fun objectInfo(objectName: String): Observable<DivaObjectInfo> {
        return Observable.empty()
    }
}
