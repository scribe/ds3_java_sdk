package com.spectralogic.escapepod.api

import io.reactivex.Observable
import io.reactivex.Single

interface AvidPamWsClient {
    fun getChildren(interplayURI: String): Observable<GetChildrenResult>
    fun getFolders(interplayURI: String): Observable<GetFoldersResult>
    fun getProfiles(workgroupURI: String, services: Array<String>, showParameters: Boolean): Single<GetProfilesResponse>
    fun getJobsStatus(jobsURI: Array<String>): Single<JobsStatusResponse>
    fun getMaxArchiveAssetSize(interplayURI: String): Single<GetMaxArchiveAssetSize>
    fun getWorkGroups(): Single<GetWorkGroupsResponse>

    fun restore(profile: String, interplayURI: String): Single<JobResponse>
    fun archive(profile: String, interplayURI: String): Single<JobResponse>
}

data class GetChildrenResult(
        val interplayURI: String,
        val mobid: String,
        val path: String,
        val displayName: String,
        val mediaSize: String,
        val mediaStatus: String,
        val type: String
)

data class GetProfilesResponse(
        val results: List<GetProfilesResult>
)

data class GetProfilesResult(
        val name: String,
        val service: String
)

data class JobResponse(
        val interplayURI: String,
        val jobURI: String
)

data class JobsStatusResponse(
        val results: List<JobStatus>
)

data class JobStatus(
        val jobURI: String,
        val jobStatus: String,
        val percentComplete: Int?
)

data class GetMaxArchiveAssetSize(
        val size: Long
)

data class GetFoldersResult(
        val name: String
)

data class GetWorkGroupsResponse(
        val results: List<GetWorkGroupsResult>
)

data class GetWorkGroupsResult(
        val workgroupName: String,
        val interplayEngineHost: String,
        val archiveEngineHost: String,
        val mediaServicesEngineHost: String
)