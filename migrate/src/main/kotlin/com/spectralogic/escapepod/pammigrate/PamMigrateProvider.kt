package com.spectralogic.escapepod.pammigrate

import com.spectralogic.escapepod.api.*
import com.spectralogic.escapepod.avidpamwsclient.AvidPamWsClient
import io.reactivex.Observable
import io.reactivex.Single
import org.slf4j.LoggerFactory

class PamMigrateProvider {

    companion object {
        private val LOG = LoggerFactory.getLogger(PamMigrateProvider::class.java)
        private val RESTORE_SERVICE = "com.avid.dms.restore"
        private val ARCHIVE_SERVICE = "com.avid.dms.archive"

        //TODO needs to be configurable
        private val USERNAME = "spectra"
        private val PASSWORD = ""
        private val ENDPOINT = "10.1.2.164:80"
    }

    private var avidPamWsClient: AvidPamWsClient

    init {
        avidPamWsClient = AvidPamWsClient(USERNAME, PASSWORD, ENDPOINT)
    }

    fun getProfiles(workGroup: String): Single<PamProfiles> {
        val workGroupUri = "interplay://$workGroup"
        val services = arrayOf(ARCHIVE_SERVICE, RESTORE_SERVICE)
        LOG.info("Getting profiles for: $workGroupUri")

        return avidPamWsClient.getPamProfiles(workGroupUri, services, false)
    }

    fun getFiles(workGroup: String, folder: String): Observable<PamAssets> {
        val folderUri = "interplay://$workGroup/$folder"
        LOG.info("Getting all the assets in folder '$folderUri'")

        return avidPamWsClient.getPamAssets(folderUri)
    }

    fun getFolders(workGroup: String): Observable<PamFolder> {
        val interplayWorkGroup = "interplay://$workGroup/"
        LOG.info("Getting AVID Pam folders for: $interplayWorkGroup")

        return avidPamWsClient.getPamFolders(interplayWorkGroup)
    }

    fun getJobStatus(workGroup: String, jobId: String): Single<PamJobStatus> {
        val jobUri = "interplay://$workGroup/DMS?jobid=$jobId"
        LOG.info("Getting job status for: $jobUri")

        return avidPamWsClient.getPamJobStatus(jobUri)
    }

    fun getMaxArchiveAssetSize(workGroup: String): Single<PamMaxArchiveAssetSize> {
        val workGroupUri = "interplay://$workGroup/"
        LOG.info("Finding the max archived asset size in workgoup '$workGroupUri'")

        return avidPamWsClient.getPamMaxArchiveAssetSize(workGroupUri)
    }

    fun getWorkGroups(): Single<PamWorkGroups> {
        LOG.info("Getting all the work groups in the system")

        return avidPamWsClient.getPamWorkGroups()
    }

    fun restoreFile(workGroup: String, profile:String, mobid: String): Single<PamJob> {
        val fileUri = "interplay://$workGroup?mobid=$mobid"
        LOG.info("Restoring '$fileUri' using '$profile' profile")

        return avidPamWsClient.restorePamAsset(profile, fileUri)
    }

    fun archiveFile(workGroup: String, profile:String, mobid: String): Single<PamJob> {
        val fileUri = "interplay://$workGroup?mobid=$mobid"
        LOG.info("Archiving '$fileUri' using '$profile' profile")

        return avidPamWsClient.archivePamAsset(profile, fileUri)
    }
}