package com.spectralogic.escapepod.api

import io.reactivex.Single

interface AvidPamWsClient {
    fun getChildren(interplayURI: String): Single<GetChildrenResponse>
    fun getProfiles(workgroupURI: String, services: Array<String>, showParameters: Boolean): Single<GetProfilesResponse>
    fun restore(service: String, profile: String, interplayURI: String): Single<RestoreResponse>
    fun jobStatus(jobURIs: Array<String>): Single<JobStatusResponse>
}

data class GetChildrenResponse(val results: Array<GetChildrenResult>?, val errors: Array<WsError>?)

data class WsError(val interplayURI: String, val message: String, val details: String)

data class GetChildrenResult(val interplayURI: String, val attributes: Map<String, String>)

data class GetProfilesResponse(val results: Array<GetProfilesResult>?, val errors: Array<WsError>?)

data class GetProfilesResult(val name: String, val service: String, val parameters: Map<String, String>)

data class RestoreResponse(val jobURI: String, val errors: Array<WsError>?)

data class JobStatusResponse(val results: Array<JobStatus>?, val errors: Array<WsError>?)

data class JobStatus(val jobURI: String, val jobStatus: String, val percentComplete: Int?)
