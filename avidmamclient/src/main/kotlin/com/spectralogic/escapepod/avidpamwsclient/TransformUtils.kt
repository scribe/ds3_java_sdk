package com.spectralogic.escapepod.avidpamwsclient

import com.google.common.collect.ImmutableMap
import com.spectralogic.escapepod.api.PamProfile
import com.spectralogic.escapepod.api.PamWorkGroup
import com.spectralogic.escapepod.api.PamJobStatus
import com.spectralogic.escapepod.avidpamclient.soap.ws.*

internal object TransformUtils {
    fun errorTypeToThrowable(errors: Array<ErrorType>): Throwable {
        return Throwable(errors.joinToString("\n") { "${it.message}, ${it.details}"})
    }

    fun profileTypeToGetProfileResult(results: Array<ProfileType>?): List<PamProfile> {
        if (results == null) {
            return emptyList()
        }

        return results.map { it ->
            PamProfile(it.name, it.service)
        }.toList()
    }

    fun jobStatusTypeToJobStatusResult(results: Array<JobStatusType>?): List<PamJobStatus> {
        if (results == null) {
            return emptyList()
        }

        return results.map { it ->
            PamJobStatus(it.jobURI, it.status, it.percentComplete)
        }.toList()
    }

    fun attributeTypeToAttributeMap(attributes: Array<AttributeType>?): ImmutableMap<String, String> {

        if (attributes == null || attributes.isEmpty()) {
            return ImmutableMap.of<String, String>()
        }

        return ImmutableMap.copyOf(attributes.associateBy({ it.name }, { it._value }))
    }

    fun getConfigurationInformationTypeToGetWorkGroupResult(results: Array<WorkgroupType>?): List<PamWorkGroup> {
        if (results == null) {
            return emptyList()
        }

        return results.map { it->
            PamWorkGroup(it.workgroupName, it.interplayEngineHost, it.archiveEngineHost, it.mediaServicesEngineHost)
        }.toList()
    }
}






