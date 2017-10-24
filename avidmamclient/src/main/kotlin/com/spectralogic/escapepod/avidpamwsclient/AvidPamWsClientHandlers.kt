package com.spectralogic.escapepod.avidpamwsclient

import com.spectralogic.escapepod.api.*
import io.reactivex.Observable
import io.reactivex.Single
import org.slf4j.LoggerFactory

import javax.inject.Inject

internal class AvidPamWsClientHandlers
@Inject constructor(private val avidPamWsClientBuilder: AvidPamWsClientBuilder) {
    private val LOG = LoggerFactory.getLogger(AvidPamWsClientHandlers::class.java)

    fun getWorkGroups(name: String): Observable<PamWorkGroup> {
        return avidPamWsClientBuilder.buildAvidPamWsClient(name)
                .flatMapObservable { avidPamWsClient ->
                    avidPamWsClient.getPamWorkGroups()
                }
    }

    fun getFolders(name: String): Observable<PamFolder> {
        return avidPamWsClientBuilder.buildAvidPamWsClient(name)
                .flatMapObservable { avidPamWsClient ->
                    avidPamWsClient.getPamFolders()
                }
    }

    fun getProfiles(name: String): Observable<PamProfile> {
        return avidPamWsClientBuilder.buildAvidPamWsClient(name)
                .flatMapObservable { avidPamWsClient ->
                    avidPamWsClient.getPamProfiles()
                }
    }

    fun getPamAssets(name: String, folder: String): Observable<PamAsset> {
        return avidPamWsClientBuilder.buildAvidPamWsClient(name)
                .flatMapObservable { avidPamWsClient ->
                    avidPamWsClient.getPamAssets(folder)
                }
    }


    fun getJobStatus(name: String, jobId: String): Single<PamJobStatus> {
        return avidPamWsClientBuilder.buildAvidPamWsClient(name)
                .flatMap { avidPamWsClient ->
                    avidPamWsClient.getPamJobStatus(jobId)
                }
    }

    fun getMaxArchiveAssetSize(name: String): Single<PamMaxArchiveAssetSize> {
        return avidPamWsClientBuilder.buildAvidPamWsClient(name)
                .flatMap { avidPamWsClient ->
                    avidPamWsClient.getPamMaxArchiveAssetSize()
                }
    }

    fun getFileLocations(name: String, mobid: String): Observable<FileLocation> {
        return avidPamWsClientBuilder.buildAvidPamWsClient(name)
                .flatMapObservable { avidPamWsClient ->
                    avidPamWsClient.getFileLocations(mobid)
                }
    }

    fun getSequenceRelatives(name: String, mobid: String): Observable<SequenceRelative> {
        return avidPamWsClientBuilder.buildAvidPamWsClient(name)
                .flatMapObservable { avidPamWsClient ->
                    avidPamWsClient.getSequenceRelatives(mobid)
                }
    }


    fun getAssetType(name: String, mobid: String): Single<AssetType> {
        return avidPamWsClientBuilder.buildAvidPamWsClient(name)
                .flatMap { avidPamWsClient ->
                    avidPamWsClient.getAssetType(mobid)
                }
    }


    fun restoreFile(name: String, profile: String, mobid: String): Single<PamJob> {
        return avidPamWsClientBuilder.buildAvidPamWsClient(name)
                .flatMap { avidPamWsClient ->
                    avidPamWsClient.restorePamAsset(profile, mobid)
                }
    }

    fun archiveFile(name: String, profile: String, mobid: String): Single<PamJob> {
        return avidPamWsClientBuilder.buildAvidPamWsClient(name)
                .flatMap { avidPamWsClient ->
                    avidPamWsClient.archivePamAsset(profile, mobid)
                }
    }
}