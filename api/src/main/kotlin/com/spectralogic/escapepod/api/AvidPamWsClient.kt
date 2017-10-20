package com.spectralogic.escapepod.api

import io.reactivex.Observable
import io.reactivex.Single

interface AvidPamWsClient {
    fun getPamAssets(folder: String): Observable<PamAsset>
    fun getPamFolders(): Observable<PamFolder>
    fun getPamProfiles(): Observable<PamProfile>
    fun getPamJobStatus(jobId: String): Single<PamJobStatus>
    fun getPamMaxArchiveAssetSize(): Single<PamMaxArchiveAssetSize>
    fun getPamWorkGroups(): Observable<PamWorkGroup>
    fun getFileLocations(mobid: String): Observable<FileLocation>
    fun getSequenceRelatives(mobid: String): Observable<SequenceRelative>
    fun getAssetType(mobid: String): Single<AssetType>

    fun restorePamAsset(profile: String, mobid: String): Single<PamJob>
    fun archivePamAsset(profile: String, mobid: String): Single<PamJob>
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

enum class AssetType {
    MASTERCLIP, SEQUENCE, UNKNOWN
}


open class PamNotFoundException(override val message: String) : RuntimeException(message)

open class PamExistsException(override val message: String) : RuntimeException(message)

interface AvidPamWsClientBuilder {
    fun buildAvidPamWsClient(name: String): Single<AvidPamWsClient>
}

