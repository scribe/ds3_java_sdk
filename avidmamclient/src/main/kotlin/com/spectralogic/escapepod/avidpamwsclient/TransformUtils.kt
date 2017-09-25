package com.spectralogic.escapepod.avidpamwsclient

import com.google.common.collect.ImmutableMap
import com.spectralogic.escapepod.api.GetProfilesResult
import com.spectralogic.escapepod.api.GetWorkGroupsResult
import com.spectralogic.escapepod.api.JobStatus
import com.spectralogic.escapepod.avidpamclient.soap.ws.*

internal object TransformUtils {
    fun errorTypeToThroable(errors: Array<ErrorType>?): Throwable {
        if (errors == null) {
            return Throwable()
        }

        return Throwable(errors.joinToString("\n") { "${it.message}, ${it.details}"})
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

    fun getConfigurationInformationTypeToGetWorkGroupResult(results: Array<WorkgroupType>?): List<GetWorkGroupsResult> {
        if (results == null) {
            return emptyList()
        }

        return results.map { it->
            GetWorkGroupsResult(it.workgroupName, it.interplayEngineHost, it.archiveEngineHost, it.mediaServicesEngineHost)
        }.toList()
    }
}






