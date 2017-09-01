package com.spectralogic.escapepod.avidpamwsclient

import com.spectralogic.escapepod.api.GetChildrenResult
import com.spectralogic.escapepod.api.GetProfilesResult
import com.spectralogic.escapepod.api.JobStatus
import com.spectralogic.escapepod.api.WsError
import com.spectralogic.escapepod.avidpamclient.soap.ws.AssetDescriptionType
import com.spectralogic.escapepod.avidpamclient.soap.ws.ErrorType
import com.spectralogic.escapepod.avidpamclient.soap.ws.JobStatusType
import com.spectralogic.escapepod.avidpamclient.soap.ws.ProfileType

internal class TransformUtils {
    companion object {
        fun errorTypeToWsError(errors: Array<ErrorType>?): Array<WsError>? {
            if (errors == null) {
                return null
            }

            return errors.map { it -> WsError(it.interplayURI, it.message, it.details) }.toTypedArray()
        }

        fun assetDescriptionTypeToGetChildrenResult(results: Array<AssetDescriptionType>?):
                Array<GetChildrenResult>? {
            if (results == null){
                return null
            }

            return results.map {
                it ->
                GetChildrenResult(
                        it.interplayURI,
                        it.attributes.associateBy({ it.name }, { it._value }))
            }.toTypedArray()
        }

        fun profileTypeToGetProfileResult(results: Array<ProfileType>?): Array<GetProfilesResult>? {
            if (results == null) {
                return null
            }

            return results.map {
                it ->
                GetProfilesResult(it.name, it.service, it.parameters.associateBy({it.name}, {it._value}))
            }.toTypedArray()
        }

        fun jobStatusTypeToJobStatusResult(results: Array<JobStatusType>?): Array<JobStatus>? {
            if (results == null) {
                return null
            }

            return results.map {
                it ->
                JobStatus(it.jobURI, it.status, it.percentComplete)
            }.toTypedArray()
        }
    }
}






