package com.spectralogic.escapepod.api

import com.fasterxml.jackson.annotation.JsonProperty
import io.reactivex.Observable
import io.reactivex.Single

interface AvidPamWsClient {
    fun getChildren(interplayURI: String): Observable<GetChildrenResult>
    fun getFolders(interplayURI: String): Observable<GetFoldersResult>
    fun getProfiles(workgroupURI: String, services: Array<String>, showParameters: Boolean): Single<GetProfilesResponse>
    fun getJobsStatus(jobsURI: Array<String>): Single<JobsStatusResponse>
    fun getMaxArchiveAssetSize(interplayURI: String): Single<GetMaxArchiveAssetSize>

    fun restore(profile: String, interplayURI: String): Single<JobResponse>
    fun archive(profile: String, interplayURI: String): Single<JobResponse>
}

data class WsError(
        @JsonProperty("message")
        val message: String,

        @JsonProperty("details")
        val details: String
)

data class GetChildrenResult(
        @JsonProperty("interplayURI")
        val interplayURI: String,

        @JsonProperty("MobID")
        val mobid: String,

        @JsonProperty("Path")
        val path: String,

        @JsonProperty("DisplayName")
        val displayName: String,

        @JsonProperty("MediaSize")
        val mediaSize: String,

        @JsonProperty("MediaStatus")
        val mediaStatus: String,

        @JsonProperty("Type")
        val type: String
)

data class GetProfilesResponse(
        @JsonProperty("results")
        val results: List<GetProfilesResult>,

        @JsonProperty("errors")
        val errors: List<WsError>
)

data class GetProfilesResult(
        @JsonProperty("name")
        val name: String,

        @JsonProperty("service")
        val service: String
)

data class JobResponse(
        @JsonProperty("jobUri")
        val jobURI: String,

        @JsonProperty("errors")
        val errors: List<WsError>
)

data class JobsStatusResponse(
        @JsonProperty("results")
        val results: List<JobStatus>,

        @JsonProperty("errors")
        val errors: List<WsError>
)

data class JobStatus(
        @JsonProperty("jobUri")
        val jobURI: String,

        @JsonProperty("jobStatus")
        val jobStatus: String,

        @JsonProperty("percentComplete")
        val percentComplete: Int?
)

data class GetMaxArchiveAssetSize(
        @JsonProperty("Size")
        val size: Long,

        @JsonProperty("errors")
        val errors: List<WsError>
)

data class GetFoldersResult(
        @JsonProperty("name")
        val name: String
)