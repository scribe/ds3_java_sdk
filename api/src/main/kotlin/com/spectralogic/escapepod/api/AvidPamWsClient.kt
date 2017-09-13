package com.spectralogic.escapepod.api

import io.reactivex.Single

interface AvidPamWsClient {
    fun getChildren(interplayURI: String): Single<GetChildrenResponse>
    fun getProfiles(workgroupURI: String, services: Array<String>, showParameters: Boolean): Single<GetProfilesResponse>
    fun getJobsStatus(jobsURI: Array<String>): Single<JobsStatusResponse>

    fun restore(profile: String, interplayURI: String): Single<JobResponse>
    fun archive(profile: String, interplayURI: String): Single<JobResponse>
    fun cancelJobs(jobsURI: Array<String>): Single<CancelJobsResponse>
}

data class GetChildrenResponse(val results: Sequence<GetChildrenResult>, val errors: Sequence<WsError>)

data class WsError(val interplayURI: String, val message: String, val details: String)

data class GetChildrenResult(val interplayURI: String, val attributes: Map<String, String>)

data class GetProfilesResponse(val results: Sequence<GetProfilesResult>, val errors: Sequence<WsError>)

data class GetProfilesResult(val name: String, val service: String, val parameters: Map<String, String>)

data class JobResponse(val jobURI: String, val errors: Sequence<WsError>)

data class JobsStatusResponse(val results: Sequence<JobStatus>, val errors: Sequence<WsError>)

data class JobStatus(val jobURI: String, val jobStatus: String, val percentComplete: Int?)

data class CancelJobsResponse(val errors: Sequence<WsError>)