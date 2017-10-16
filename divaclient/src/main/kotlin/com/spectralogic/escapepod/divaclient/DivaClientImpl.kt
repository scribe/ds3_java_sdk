/*
 * *****************************************************************************
 *    Copyright 2014-2017 Spectra Logic Corporation. All Rights Reserved.
 *    Licensed under the Apache License, Version 2.0 (the "License"). You may not use
 *    this file except in compliance with the License. A copy of the License is located at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *    or in the "license" file accompanying this file.
 *    This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *    CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *    specific language governing permissions and limitations under the License.
 *  ****************************************************************************
 */

package com.spectralogic.escapepod.divaclient

import com.google.inject.assistedinject.Assisted
import com.spectralogic.escapepod.api.*
import com.spectralogic.escapepod.divaclient.retrofit.DivaRetrofitClient
import com.spectralogic.escapepod.divaclient.retrofit.GetObjectInfo
import com.spectralogic.escapepod.divaclient.retrofit.GetRequestInfo
import com.spectralogic.escapepod.divaclient.retrofit.RestoreObject
import com.spectralogic.escapepod.divaclient.session.DivaSession
import com.spectralogic.escapepod.divaclient.session.DivaSessionFactory
import com.spectralogic.escapepod.restclientutils.RetrofitClientFactory
import io.reactivex.Observable
import io.reactivex.Single
import org.slf4j.LoggerFactory
import javax.inject.Inject

internal class DivaClientImpl @Inject constructor(
        @Assisted private val endpoint: String,
        retrofitClientFactory: RetrofitClientFactory,
        divaSessionFactory: DivaSessionFactory
) : DivaClient {
    private companion object {
        private val LOG = LoggerFactory.getLogger(DivaClientImpl::class.java)
    }

    private val divaClient: DivaRetrofitClient = retrofitClientFactory.createRestClient(endpoint, DivaRetrofitClient::class.java, "/services/DIVArchiveWS_REST_2.0/")
    private val divaSession: DivaSession = divaSessionFactory.createDivaSession(divaClient)

    override fun tapeGroups(): Observable<DivaTapeGroup> {
        return Observable.empty()
    }

    override fun objects(tapeGroupName: String): Observable<DivaObject> {
        return Observable.empty()
    }

    override fun restore(objectName: String, objectCategory: String, destination: String, destinationPath: String): Single<Long> {
        return divaSession.getSession().map { sessionId ->
            val restoreObject = RestoreObject()
            restoreObject.sessionId = sessionId
            restoreObject.destination = destination
            restoreObject.objectName = objectName
            restoreObject.objectCategory = objectCategory
            restoreObject.filesPathRoot = destinationPath
            restoreObject.qualityOfService = 0
            restoreObject.priorityLevel = -1
            restoreObject
        }.flatMap(divaClient::restoreObject)
                .doOnSuccess { restoreResponse ->
                    LOG.info("Restore operation successfully submitted with id of {}", restoreResponse.restoreReturn.requestNumber)
                }.map { restoreResponse ->
            restoreResponse.restoreReturn.requestNumber
        }
    }

    override fun restoreStatus(requestId: Long): Single<DivaRestoreStatus> {
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

    override fun objectInfo(objectName: String, category: String): Single<DivaObjectInfo> {
        return divaSession.getSession().map { sessionId ->
            val getObjectInfo = GetObjectInfo()
            getObjectInfo.objectName = objectName
            getObjectInfo.sessionId = sessionId
            getObjectInfo.objectCategory = category
            getObjectInfo
        }.flatMap { objectInfoRequest ->
            divaClient.getObjectInfo(objectInfoRequest)
        }.map { objectInfo ->
            val info = objectInfo.sourceReturn.info
            val objectFileList = info.filesList.split(",").asSequence().map { DivaFile(it) }

            DivaObjectInfo(objectName, info.objectSizeBytes, objectFileList)
        }
    }

    override fun sourceList(): Observable<DivaSource> {
        return Observable.empty()
    }
}
