package com.spectralogic.escapepod.avidpamwsclient

import com.google.common.collect.ImmutableMap
import com.spectralogic.escapepod.api.PamJobStatus
import com.spectralogic.escapepod.api.PamWorkGroup
import com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType
import com.spectralogic.escapepod.avidpamclient.soap.ws.ErrorType
import com.spectralogic.escapepod.avidpamclient.soap.ws.JobStatusType
import com.spectralogic.escapepod.avidpamclient.soap.ws.WorkgroupType

internal object TransformUtils {
    fun errorTypeToThrowable(errors: Array<ErrorType>): Throwable {
        return Throwable(errors.joinToString("\n") { "${it.message}, ${it.details}"})
    }

    fun jobStatusTypeToPamJobStatus(results: Array<JobStatusType>?): PamJobStatus {
        if (results == null) {
            return PamJobStatus("", "", 0)
        }

        val it = results[0]
        return PamJobStatus(it.jobURI, it.status, it.percentComplete)
    }

    fun attributeTypeToAttributeMap(attributes: Array<AttributeType>?): ImmutableMap<String, String> {

        if (attributes == null || attributes.isEmpty()) {
            return ImmutableMap.of<String, String>()
        }

        return ImmutableMap.copyOf(attributes.associateBy({ it.name }, { it._value }))
    }

    fun getConfigurationInformationTypeToPamWorkGroup(results: Array<WorkgroupType>?): List<PamWorkGroup> {
        if (results == null) {
            return emptyList()
        }

        return results.map { it->
            PamWorkGroup(it.workgroupName, it.interplayEngineHost, it.archiveEngineHost, it.mediaServicesEngineHost)
        }.toList()
    }
}






