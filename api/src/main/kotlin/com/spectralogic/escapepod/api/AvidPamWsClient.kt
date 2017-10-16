package com.spectralogic.escapepod.api

import io.reactivex.Observable
import io.reactivex.Single

interface AvidPamWsClient {
    fun getPamAssets(interplayURI: String): Observable<PamAssets>
    fun getPamFolders(interplayURI: String): Observable<PamFolder>
    fun getPamProfiles(workgroupURI: String, services: Array<String>, showParameters: Boolean): Single<PamProfiles>
    fun getPamJobStatus(jobURI: String): Single<PamJobStatus>
    fun getPamMaxArchiveAssetSize(interplayURI: String): Single<PamMaxArchiveAssetSize>
    fun getPamWorkGroups(): Single<PamWorkGroups>

    fun restorePamAsset(profile: String, interplayURI: String): Single<PamJob>
    fun archivePamAsset(profile: String, interplayURI: String): Single<PamJob>
}

data class PamAssets(
        val interplayURI: String,
        val mobid: String,
        val path: String,
        val displayName: String,
        val mediaSize: String,
        val mediaStatus: String,
        val type: String
)

data class PamProfiles(
        val results: List<PamProfile>
)

data class PamProfile(
        val name: String,
        val service: String
)

data class PamJob(
        val interplayURI: String,
        val jobURI: String
)

data class PamJobStatus(
        val jobURI: String,
        val jobStatus: String,
        val percentComplete: Int?
)

data class PamMaxArchiveAssetSize(
        val size: Long
)

data class PamFolder(
        val name: String
)

data class PamWorkGroups(
        val results: List<PamWorkGroup>
)

data class PamWorkGroup(
        val workgroupName: String,
        val interplayEngineHost: String,
        val archiveEngineHost: String,
        val mediaServicesEngineHost: String
)