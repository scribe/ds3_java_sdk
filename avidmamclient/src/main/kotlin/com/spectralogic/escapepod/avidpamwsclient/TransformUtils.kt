package com.spectralogic.escapepod.avidpamwsclient

import com.google.common.collect.ImmutableMap
import com.spectralogic.escapepod.api.GetProfilesResult
import com.spectralogic.escapepod.api.JobStatus
import com.spectralogic.escapepod.api.WsError
import com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType
import com.spectralogic.escapepod.avidpamclient.soap.ws.ErrorType
import com.spectralogic.escapepod.avidpamclient.soap.ws.JobStatusType
import com.spectralogic.escapepod.avidpamclient.soap.ws.ProfileType

internal object TransformUtils {
    fun errorTypeToWsError(errors: Array<ErrorType>?): List<WsError> {
        if (errors == null) {
            return emptyList()
        }

        return errors.map { it -> WsError(it.message, it.details) }.toList()
    }

    fun profileTypeToGetProfileResult(results: Array<ProfileType>?): List<GetProfilesResult> {
        if (results == null) {
            return emptyList()
        }

        return results.map { it ->
            GetProfilesResult(it.name, it.service)
        }.toList()
    }

    fun jobStatusTypeToJobStatusResult(results: Array<JobStatusType>?): List<JobStatus> {
        if (results == null) {
            return emptyList()
        }

        return results.map { it ->
            JobStatus(it.jobURI, it.status, it.percentComplete)
        }.toList()
    }

    fun attributeTypeToAttributeMap(attributes: Array<AttributeType>?): ImmutableMap<String, String> {

        if (attributes == null || attributes.isEmpty()) {
            return ImmutableMap.of<String, String>()
        }

        return ImmutableMap.copyOf(attributes.associateBy({ it.name }, { it._value }))
    }
}






