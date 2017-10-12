package com.spectralogic.escapepod.api

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface AvidPamWsClient {
    fun getPamAssets(interplayURI: String): Observable<PamAsset>
    fun getPamFolders(interplayURI: String): Observable<PamFolder>
    fun getPamProfiles(workgroupURI: String, services: Array<String>, showParameters: Boolean): Observable<PamProfile>
    fun getPamJobStatus(jobURI: String): Single<PamJobStatus>
    fun getPamMaxArchiveAssetSize(interplayURI: String): Single<PamMaxArchiveAssetSize>
    fun getPamWorkGroups(): Single<PamWorkGroups>
    fun getFileLocations(interplayURI: String): Observable<FileLocation>
    fun getSequenceRelatives(interplayURI: String): Observable<SequenceRelative>
    fun getAssetType(interplayURI: String): Single<String>

    fun restorePamAsset(profile: String, interplayURI: String): Single<PamJob>
    fun archivePamAsset(profile: String, interplayURI: String): Single<PamJob>
    fun archivePamAssetToBlackPearl(bucket: String, interplayURI: String): Completable
}

data class PamAsset(
        val interplayURI: String,
        val mobid: String,
        val path: String,
        val displayName: String,
        val mediaSize: String,
        val mediaStatus: String,
        val type: String
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
data class FileLocation(
        val filePath: String,
        val interplayURI: String,
        val size: Long,
        val status: String,
        val format: String,
        val clipId: String
)

data class SequenceRelative(
        val interplayURI: String
)
