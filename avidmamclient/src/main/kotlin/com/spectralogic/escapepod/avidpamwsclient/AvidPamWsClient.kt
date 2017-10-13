package com.spectralogic.escapepod.avidpamwsclient

import com.spectralogic.escapepod.api.*
import com.spectralogic.escapepod.api.AvidPamWsClient
import com.spectralogic.escapepod.avidpamclient.soap.ws.*
import com.spectralogic.escapepod.util.maxLong
import io.reactivex.Completable
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

class AvidPamWsClient
constructor(username: String, password: String, endpoint: String,
            blackPearlClientFactory: BpClientFactory,
            private val executor: Executor = ForkJoinPool.commonPool()) : AvidPamWsClient {

    private companion object {
        private val LOG = LoggerFactory.getLogger(AvidPamWsClient::class.java)
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

    private val blackPearlPamArchive: BlackPearlPamArchive

    init {
        LOG.info("Init AvidPamWsClient")

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

        blackPearlPamArchive = BlackPearlPamArchive(blackPearlClientFactory)
    }

    override fun getPamAssets(interplayURI: String): Observable<PamAsset> {
        return Observable.create { emitter ->
            executor.execute {
                try {
                    getChildrenHelper(interplayURI, emitter)
                    emitter.onComplete()
                } catch (t: Throwable) {
                    emitter.onError(t)
                }
            }
        }
    }

    override fun getPamFolders(interplayURI: String): Observable<PamFolder> {
        return Observable.create { emitter ->
            executor.execute {
                try {
                    getFoldersHelper(interplayURI, emitter)
                    emitter.onComplete()
                } catch (t: Throwable) {
                    emitter.onError(t)
                }
            }
        }
    }

    override fun getPamProfiles(workgroupURI: String, services: Array<String>, showParameters: Boolean): Observable<PamProfile> {

        val profiles = GetProfilesType()
        profiles.workgroupURI = workgroupURI
        profiles.services = services
        profiles.showParameters = showParameters

        return Single.just(jobsSoapClient.getProfiles(profiles, credentials))
                .observeOn(Schedulers.from(executor))
                .flatMapObservable { res ->
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

    override fun restorePamAsset(profile: String, interplayURI: String): Single<PamJob> {

        val submitJobUsingProfileType = SubmitJobUsingProfileType()
        submitJobUsingProfileType.service = "com.avid.dms.restore"
        submitJobUsingProfileType.profile = profile
        submitJobUsingProfileType.interplayURI = interplayURI

        return Single.just(jobsSoapClient.submitJobUsingProfile(submitJobUsingProfileType, credentials))
                .observeOn(Schedulers.from(executor))
                .map { res ->
                    if (res.errors != null) {
                        throw Throwable(TransformUtils.errorTypeToThrowable(res.errors))
                    }

                    PamJob(interplayURI, res.jobURI)
                }
    }

    override fun archivePamAsset(profile: String, interplayURI: String): Single<PamJob> {

        val submitJobUsingProfileType = SubmitJobUsingProfileType()
        submitJobUsingProfileType.service = "com.avid.dms.archive"
        submitJobUsingProfileType.profile = profile
        submitJobUsingProfileType.interplayURI = interplayURI

        return Single.just(jobsSoapClient.submitJobUsingProfile(submitJobUsingProfileType, credentials))
                .observeOn(Schedulers.from(executor))
                .map { res ->
                    if (res.errors != null) {
                        throw Throwable(TransformUtils.errorTypeToThrowable(res.errors))
                    }

                    PamJob(interplayURI, res.jobURI)
                }
    }

    override fun getPamJobStatus(jobURI: String): Single<PamJobStatus> {

        val getJobStatusType = GetJobStatusType()
        getJobStatusType.jobURIs = arrayOf(jobURI)

        return Single.just(jobsSoapClient.getJobStatus(getJobStatusType, credentials))
                .observeOn(Schedulers.from(executor))
                .map { res ->
                    if (res.errors != null) {
                        throw Throwable(TransformUtils.errorTypeToThrowable(res.errors))
                    }

                    TransformUtils.jobStatusTypeToPamJobStatus(res.jobStatusTypes)
                }
    }

    override fun getPamMaxArchiveAssetSize(interplayURI: String): Single<PamMaxArchiveAssetSize> {
        return getPamAssets(interplayURI).map { it ->
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

    override fun archivePamAssetToBlackPearl(blackPearl: String, bucket: String, interplayURI: String): Completable {
        return blackPearlPamArchive.archivePamToBlackPearl(this, blackPearl, bucket, interplayURI, executor)
    }

    override fun getFileLocations(interplayURI: String): Observable<FileLocation> {
        val getFilesDetailsType = GetFileDetailsType()
        getFilesDetailsType.interplayURIs = arrayOf(interplayURI)

        return Single.just(getFilesDetailsType)
                .observeOn(Schedulers.from(executor))
                .map {
                    assetsSoapClient.getFileDetails(getFilesDetailsType, credentials)
                }
                .flatMapObservable { res ->
                    if (res.errors != null) {
                        throw Throwable(TransformUtils.errorTypeToThrowable(res.errors))
                    }

                    Observable.fromIterable(
                            res.results[0].fileLocations
                                    .map { fl ->
                                        FileLocation(fl.filePath, fl.interplayURI, Files.size(Paths.get(fl.filePath)), fl.status, fl.format, interplayURI.mobid())
                                    })
                }
    }

    override fun getSequenceRelatives(interplayURI: String): Observable<SequenceRelative> {
        val findRelativeType = FindRelativesType()
        findRelativeType.interplayURI = interplayURI

        return Single.just(findRelativeType)
                .observeOn(Schedulers.from(executor))
                .map {
                    assetsSoapClient.findRelatives(findRelativeType, credentials)
                }
                .flatMapObservable { res ->
                    if (res.errors != null) {
                        throw Throwable(TransformUtils.errorTypeToThrowable(res.errors))
                    }

                    Observable.fromIterable(
                            res.results
                                    .map { asset -> SequenceRelative(asset.interplayURI) }
                    )
                }
    }

    override fun getAssetType(interplayURI: String): Single<AssetType> {

        val getAttributeType = GetAttributesType()
        getAttributeType.interplayURIs = arrayOf(interplayURI)

        return Single.just(assetsSoapClient.getAttributes(getAttributeType, credentials))
                .observeOn(Schedulers.from(executor))
                .map { res ->
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


