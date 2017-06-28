package com.spectralogic.escapepod.divaclient

import com.google.inject.assistedinject.Assisted
import com.spectralogic.escapepod.api.*
import com.spectralogic.escapepod.divaclient.retrofit.DivaRetrofitClient
import com.spectralogic.escapepod.divaclient.retrofit.DivaRetrofitClientFactory
import com.spectralogic.escapepod.divaclient.retrofit.GetRequestInfo
import com.spectralogic.escapepod.divaclient.retrofit.RestoreObject
import com.spectralogic.escapepod.divaclient.session.DivaSession
import com.spectralogic.escapepod.divaclient.session.DivaSessionFactory
import io.reactivex.Observable
import io.reactivex.Single
import org.slf4j.LoggerFactory
import javax.inject.Inject

internal class DivaClientImpl @Inject constructor(
        @Assisted private val endpoint: String,
        divaRetrofitClientFactory: DivaRetrofitClientFactory,
        divaSessionFactory: DivaSessionFactory
    ): DivaClient {
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

    override fun restore(objectName: String, objectCategory: String, destination: String, destinationPath: String) : Single<Int> {
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
        }.map { restoreResponse ->
            restoreResponse.restoreReturn.requestNumber
        }
    }

    override fun restoreStatus(requestId: Int): Single<DivaRestoreStatus> {
        return divaSession.getSession().map { sessionId ->
            val getRequestInfo = GetRequestInfo()
            getRequestInfo.sessionId = sessionId
            getRequestInfo.requestId = requestId

            getRequestInfo
        }.flatMap { requestInfo ->
            divaClient.getRequestInfo(requestInfo)
        }.map { requestInfoResponse ->
            DivaRestoreStatus(requestInfoResponse.requestResult.divaRequestInfoResponse.requestState)
        }
    }

    override fun objectInfo(objectName: String): Observable<DivaObjectInfo> {
        return Observable.empty()
    }

    override fun sourceList() : Observable<DivaSource> {
        return Observable.empty()
    }
}
