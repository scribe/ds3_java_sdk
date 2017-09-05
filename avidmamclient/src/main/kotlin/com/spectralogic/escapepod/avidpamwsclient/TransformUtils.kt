package com.spectralogic.escapepod.avidpamwsclient

import com.spectralogic.escapepod.api.GetChildrenResult
import com.spectralogic.escapepod.api.GetProfilesResult
import com.spectralogic.escapepod.api.JobStatus
import com.spectralogic.escapepod.api.WsError
import com.spectralogic.escapepod.avidpamclient.soap.ws.AssetDescriptionType
import com.spectralogic.escapepod.avidpamclient.soap.ws.ErrorType
import com.spectralogic.escapepod.avidpamclient.soap.ws.JobStatusType
import com.spectralogic.escapepod.avidpamclient.soap.ws.ProfileType

internal object TransformUtils {
    fun errorTypeToWsError(errors: Array<ErrorType>?): Sequence<WsError> {
        if (errors == null) {
            return emptySequence()
        }

        return errors.map { it -> WsError(it.interplayURI, it.message, it.details) }.asSequence()
    }

    fun assetDescriptionTypeToGetChildrenResult(results: Array<AssetDescriptionType>?):
            Sequence<GetChildrenResult> {
        if (results == null) {
            return emptySequence()
        }

        return results.map { it ->
            GetChildrenResult(
                    it.interplayURI,
                    it.attributes.associateBy({ it.name }, { it._value }))
        }.asSequence()
    }

    fun profileTypeToGetProfileResult(results: Array<ProfileType>?): Sequence<GetProfilesResult> {
        if (results == null) {
            return emptySequence()
        }

        return results.map { it ->
            GetProfilesResult(it.name, it.service, it.parameters.associateBy({ it.name }, { it._value }))
        }.asSequence()
    }

    fun jobStatusTypeToJobStatusResult(results: Array<JobStatusType>?): Sequence<JobStatus> {
        if (results == null) {
            return emptySequence()
        }

        return results.map { it ->
            JobStatus(it.jobURI, it.status, it.percentComplete)
        }.asSequence()
    }
}






