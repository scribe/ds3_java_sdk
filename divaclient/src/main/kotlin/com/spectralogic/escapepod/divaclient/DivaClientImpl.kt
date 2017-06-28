package com.spectralogic.escapepod.divaclient

import com.google.inject.assistedinject.Assisted
import com.spectralogic.escapepod.api.*
import com.spectralogic.escapepod.divaclient.retrofit.DivaRetrofitClient
import com.spectralogic.escapepod.divaclient.retrofit.DivaRetrofitClientFactory
import com.spectralogic.escapepod.divaclient.retrofit.RestoreObject
import com.spectralogic.escapepod.divaclient.session.DivaSession
import com.spectralogic.escapepod.divaclient.session.DivaSessionFactory
import io.reactivex.Completable
import io.reactivex.Observable
import org.slf4j.LoggerFactory
import javax.inject.Inject

internal class DivaClientImpl @Inject constructor(@Assisted val endpoint: String, @Assisted clientName : String, divaRetrofitClientFactory: DivaRetrofitClientFactory, divaSessionFactory: DivaSessionFactory): DivaClient {

    private companion object {
        private val LOG = LoggerFactory.getLogger(DivaClientImpl::class.java)
    }

    private val divaClient : DivaRetrofitClient = divaRetrofitClientFactory.createDivaClient(endpoint)
    private val divaSession : DivaSession = divaSessionFactory.createDivaSession(divaClient)

    override fun tapeGroups(): Observable<DivaTapeGroup> {
        return Observable.empty()
    }

    override fun objects(tapeGroupName: String): Observable<DivaObject> {
        return Observable.empty()
    }

    override fun restore(objectName: String, objectCategory: String, destination: String, destinationPath: String) : Completable {
        return divaSession.getSession().map { sessionId ->
            val restoreObject = RestoreObject()
            restoreObject.sessionId = sessionId
            restoreObject.destination = destination
            restoreObject.objectName = objectName
            restoreObject.objectCategory = objectCategory
            restoreObject.filesPathRoot = destinationPath
            restoreObject.qualityOfService = "0"
            restoreObject.priorityLevel = "-1"
            restoreObject
        }.flatMap { restoreObject ->
            divaClient.restoreObject(restoreObject)
        }.doOnSuccess { restoreResponse ->
            LOG.info("Restore operation successfully submitted with id of {}", restoreResponse.restoreReturn.requestNumber)
        }.toCompletable()
    }

    override fun objectInfo(objectName: String): Observable<DivaObjectInfo> {
        return Observable.empty()
    }

    override fun sourceList() : Observable<DivaSource> {
        return Observable.empty()
    }
}
