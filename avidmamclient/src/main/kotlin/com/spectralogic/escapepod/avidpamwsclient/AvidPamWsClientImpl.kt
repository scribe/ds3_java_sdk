package com.spectralogic.escapepod.avidpamwsclient

import com.spectralogic.escapepod.api.*
import com.spectralogic.escapepod.avidpamclient.soap.ws.*
import com.spectralogic.escapepod.util.maxLong
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.slf4j.LoggerFactory
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*
import java.util.concurrent.Executor
import java.util.concurrent.ForkJoinPool

class AvidPamWsClientImpl
constructor(val name: String, username: String, password: String, endpoint: String, private val workGroup: String,
            private val executor: Executor = ForkJoinPool.commonPool()) : AvidPamWsClient {

    private companion object {
        private val LOG = LoggerFactory.getLogger(AvidPamWsClient::class.java)
        private val RESTORE_SERVICE = "com.avid.dms.restore"
        private val ARCHIVE_SERVICE = "com.avid.dms.archive"
        private val JOBS = "Jobs"
        private val ASSETS = "Assets"
        private val INFRASTRUCTURE = "Infrastructure"
        private val credentials = UserCredentialsType()
        private val jobsLocator = JobsLocator()
        private val assetsLocator = AssetsLocator()
        private val infrastructureLocator = InfrastructureLocator()
    }

    private var jobsEndpointUrl: String
    private var assetsEndpointUrl: String
    private var infrastructureEndpointUrl: String

    private var jobsSoapClient: JobsPortType
    private var assetsSoapClient: AssetsPortType
    private var infrastructureSoapClient: InfrastructurePortType

    init {
        LOG.info("Init AvidPamWsClientImpl")

        credentials.username = username
        credentials.password = password

        jobsEndpointUrl = "http://$endpoint/services/$JOBS"
        jobsLocator.setEndpointAddress("JobsPort", jobsEndpointUrl)
        jobsSoapClient = jobsLocator.jobsPort

        assetsEndpointUrl = "http://$endpoint/services/$ASSETS"
        assetsLocator.setEndpointAddress("AssetsPort", assetsEndpointUrl)
        assetsSoapClient = assetsLocator.assetsPort

        infrastructureEndpointUrl = "http://$endpoint/services/$INFRASTRUCTURE"
        infrastructureLocator.setEndpointAddress("InfrastructurePort", infrastructureEndpointUrl)
        infrastructureSoapClient = infrastructureLocator.infrastructurePort

    }

    override fun getPamAssets(folder: String): Observable<PamAsset> {
        return Observable.create { emitter ->
            executor.execute {
                try {
                    val folderUri = "interplay://$workGroup/$folder"
                    LOG.info("Getting all the assets in folder '$folderUri'")
                    getChildrenHelper(folderUri, emitter)
                    emitter.onComplete()
                } catch (t: Throwable) {
                    emitter.onError(t)
                }
            }
        }
    }

    override fun getPamFolders(): Observable<PamFolder> {
        return Observable.create { emitter ->
            executor.execute {
                try {
                    val interplayURI = "interplay://$workGroup/"
                    LOG.info("Getting AVID Pam '$name' folders for: $interplayURI")
                    getFoldersHelper(interplayURI, emitter)
                    emitter.onComplete()
                } catch (t: Throwable) {
                    emitter.onError(t)
                }
            }
        }
    }

    override fun getPamProfiles(): Observable<PamProfile> {

        val profiles = GetProfilesType()
        profiles.workgroupURI = "interplay://$workGroup"
        profiles.services = arrayOf(ARCHIVE_SERVICE, RESTORE_SERVICE)
        profiles.showParameters = false

        return Single.just(jobsSoapClient.getProfiles(profiles, credentials))
                .observeOn(Schedulers.from(executor))
                .flatMapObservable { res ->
                    LOG.info("Getting pam system '$name' profiles for: ${profiles.workgroupURI}")

                    if (res.errors != null) {
                        throw Throwable(TransformUtils.errorTypeToThrowable(res.errors))
                    }

                    Observable.fromIterable(
                            res.results
                                    .map { it ->
                                        PamProfile(it.name, it.service)
                                    })
                }
    }

    override fun restorePamAsset(profile: String, mobid: String): Single<PamJob> {
        val fileUri = "interplay://$workGroup?mobid=$mobid"
        val submitJobUsingProfileType = SubmitJobUsingProfileType()
        submitJobUsingProfileType.service = "com.avid.dms.restore"
        submitJobUsingProfileType.profile = profile
        submitJobUsingProfileType.interplayURI = fileUri

        return Single.just(jobsSoapClient.submitJobUsingProfile(submitJobUsingProfileType, credentials))
                .observeOn(Schedulers.from(executor))
                .map { res ->
                    LOG.info("Restoring '$fileUri' using '$profile' profile on pam system '$name'")
                    if (res.errors != null) {
                        throw Throwable(TransformUtils.errorTypeToThrowable(res.errors))
                    }

                    PamJob(fileUri, res.jobURI)
                }
    }

    override fun archivePamAsset(profile: String, mobid: String): Single<PamJob> {
        val fileUri = "interplay://$workGroup?mobid=$mobid"
        val submitJobUsingProfileType = SubmitJobUsingProfileType()
        submitJobUsingProfileType.service = ARCHIVE_SERVICE
        submitJobUsingProfileType.profile = profile
        submitJobUsingProfileType.interplayURI = fileUri

        return Single.just(jobsSoapClient.submitJobUsingProfile(submitJobUsingProfileType, credentials))
                .observeOn(Schedulers.from(executor))
                .map { res ->
                    LOG.info("Archiving '$fileUri' using '$profile' profile on pam system '$name'")
                    if (res.errors != null) {
                        throw Throwable(TransformUtils.errorTypeToThrowable(res.errors))
                    }

                    PamJob(fileUri, res.jobURI)
                }
    }

    override fun getPamJobStatus(jobId: String): Single<PamJobStatus> {

        val jobUri = "interplay://$workGroup/DMS?jobid=$jobId"
        val getJobStatusType = GetJobStatusType()
        getJobStatusType.jobURIs = arrayOf(jobUri)

        return Single.just(jobsSoapClient.getJobStatus(getJobStatusType, credentials))
                .observeOn(Schedulers.from(executor))
                .map { res ->
                    LOG.info("Getting pam system '$name' job status for: $jobUri")

                    if (res.errors != null) {
                        throw Throwable(TransformUtils.errorTypeToThrowable(res.errors))
                    }

                    TransformUtils.jobStatusTypeToPamJobStatus(res.jobStatusTypes)
                }
    }

    override fun getPamMaxArchiveAssetSize(): Single<PamMaxArchiveAssetSize> {
        val workGroupUri = "interplay://$workGroup/"

        return getPamAssets(workGroupUri).map { it ->
            LOG.info("Finding pam system '$name' max archived asset size in workgoup '$workGroupUri'")

            if (it.mediaSize != "N/A") {
                it.mediaSize.toLong()
            } else {
                0L
            }
        }.maxLong().map { max -> PamMaxArchiveAssetSize(max) }
    }

    override fun getPamWorkGroups(): Observable<PamWorkGroup> {
        val getConfigurationInformationType = GetConfigurationInformationType()

        return Single.just(infrastructureSoapClient.getConfigurationInformation(getConfigurationInformationType))
                .observeOn(Schedulers.from(executor))
                .flatMapObservable { res ->
                    LOG.info("Getting all the work groups in the pam system '$name'")

                    if (res.errors != null) {
                        throw Throwable(TransformUtils.errorTypeToThrowable(res.errors))
                    }

                    Observable.fromIterable(
                            res.results.map { it ->
                                PamWorkGroup(it.workgroupName, it.interplayEngineHost, it.archiveEngineHost, it.mediaServicesEngineHost)

                            })
                }
    }

    private fun getChildrenHelper(interplayURI: String, emitter: ObservableEmitter<PamAsset>) {
        val foldersQueue: Queue<String> = LinkedList<String>()

        val getChildrenType = GetChildrenType()
        getChildrenType.interplayURI = interplayURI
        getChildrenType.includeFolders = true
        getChildrenType.includeFiles = true
        getChildrenType.includeMOBs = true

        var res = assetsSoapClient.getChildren(getChildrenType, credentials)

        if (res.errors != null) {
            emitter.onError(Throwable(TransformUtils.errorTypeToThrowable(res.errors)))
            return
        }

        for (r in res.results) {
            val uri = r.interplayURI
            val attributeMap = TransformUtils.attributeTypeToAttributeMap(r.attributes)

            if (attributeMap.getOrDefault("Path", "N/A").endsWith("/")) {
                foldersQueue.add(uri)
            } else {
                emitter.onNext(PamAsset(
                        uri,
                        attributeMap.getOrDefault("MOB ID", "N/A"),
                        attributeMap.getOrDefault("Path", "N/A"),
                        attributeMap.getOrDefault("Display Name", "N/A"),
                        attributeMap.getOrDefault("Media Size", "N/A"),
                        attributeMap.getOrDefault("Media Status", "N/A"),
                        attributeMap.getOrDefault("Type", "N/A")
                ))
            }
        }

        while (foldersQueue.isNotEmpty() && !emitter.isDisposed) {
            getChildrenType.interplayURI = foldersQueue.poll()
            res = assetsSoapClient.getChildren(getChildrenType, credentials)

            if (res.errors != null) {
                emitter.onError(Throwable(TransformUtils.errorTypeToThrowable(res.errors)))
                return
            }

            for (r in res.results) {
                val uri = r.interplayURI
                val attributeMap = TransformUtils.attributeTypeToAttributeMap(r.attributes)

                if (attributeMap.getOrDefault("Path", "N/A").endsWith("/")) {
                    foldersQueue.add(uri)
                } else {
                    emitter.onNext(PamAsset(
                            uri,
                            attributeMap.getOrDefault("MOB ID", "N/A"),
                            attributeMap.getOrDefault("Path", "N/A"),
                            attributeMap.getOrDefault("Display Name", "N/A"),
                            attributeMap.getOrDefault("Media Size", "N/A"),
                            attributeMap.getOrDefault("Media Status", "N/A"),
                            attributeMap.getOrDefault("Type", "N/A")
                    ))
                }
            }
        }
    }

    private fun getFoldersHelper(interplayURI: String, emitter: ObservableEmitter<PamFolder>) {
        val foldersQueue: Queue<String> = LinkedList<String>()

        val getChildrenType = GetChildrenType()
        getChildrenType.interplayURI = interplayURI
        getChildrenType.includeFolders = true
        getChildrenType.includeFiles = false
        getChildrenType.includeMOBs = false

        var res = assetsSoapClient.getChildren(getChildrenType, credentials)

        if (res.errors != null) {
            emitter.onError(Throwable(TransformUtils.errorTypeToThrowable(res.errors)))
            return
        }

        for (r in res.results) {
            val uri = r.interplayURI
            foldersQueue.add(uri)
            emitter.onNext(PamFolder(uri))
        }

        while (foldersQueue.isNotEmpty() && !emitter.isDisposed) {
            getChildrenType.interplayURI = foldersQueue.poll()
            res = assetsSoapClient.getChildren(getChildrenType, credentials)

            if (res.errors != null) {
                emitter.onError(Throwable(TransformUtils.errorTypeToThrowable(res.errors)))
                return
            }

            for (r in res.results) {
                val uri = r.interplayURI
                foldersQueue.add(uri)
                emitter.onNext(PamFolder(uri))
            }
        }
    }

    override fun getFileLocations(mobid: String): Observable<FileLocation> {
        val fileUri = "interplay://$workGroup?mobid=$mobid"
        val getFilesDetailsType = GetFileDetailsType()
        getFilesDetailsType.interplayURIs = arrayOf(fileUri)

        return Single.just(getFilesDetailsType)
                .observeOn(Schedulers.from(executor))
                .map {
                    assetsSoapClient.getFileDetails(getFilesDetailsType, credentials)
                }
                .flatMapObservable { res ->
                    LOG.info("Getting pam system '$name' file locations for: '$fileUri'")

                    if (res.errors != null) {
                        throw Throwable(TransformUtils.errorTypeToThrowable(res.errors))
                    }

                    Observable.fromIterable(
                            res.results[0].fileLocations
                                    .map { fl ->
                                        FileLocation(fl.filePath, fl.interplayURI, Files.size(Paths.get(fl.filePath)), fl.status, fl.format, mobid)
                                    })
                }
    }

    override fun getSequenceRelatives(mobid: String): Observable<SequenceRelative> {
        val fileUri = "interplay://$workGroup?mobid=$mobid"
        val findRelativeType = FindRelativesType()
        findRelativeType.interplayURI = fileUri

        return Single.just(findRelativeType)
                .observeOn(Schedulers.from(executor))
                .map {
                    assetsSoapClient.findRelatives(findRelativeType, credentials)
                }
                .flatMapObservable { res ->
                    LOG.info("Getting pam system '$name' sequence relatives for: '$fileUri'")

                    if (res.errors != null) {
                        throw Throwable(TransformUtils.errorTypeToThrowable(res.errors))
                    }

                    Observable.fromIterable(
                            res.results
                                    .map { asset -> SequenceRelative(asset.interplayURI) }
                    )
                }
    }

    override fun getAssetType(mobid: String): Single<AssetType> {
        val fileUri = "interplay://$workGroup?mobid=$mobid"
        val getAttributeType = GetAttributesType()
        getAttributeType.interplayURIs = arrayOf(fileUri)

        return Single.just(assetsSoapClient.getAttributes(getAttributeType, credentials))
                .observeOn(Schedulers.from(executor))
                .map { res ->
                    LOG.info("Getting pam system '$name' asset type for: '$fileUri'")

                    if (res.errors != null) {
                        throw Throwable(TransformUtils.errorTypeToThrowable(res.errors))
                    }

                    val attributeMap = TransformUtils.attributeTypeToAttributeMap(res.results[0].attributes)
                    val type = attributeMap.getOrDefault("Type", "N/A")
                    when (type) {
                        "masterclip" -> AssetType.MASTERCLIP
                        "sequence" -> AssetType.SEQUENCE
                        else -> throw Throwable("Could not get asset type")
                    }
                }
    }
}


