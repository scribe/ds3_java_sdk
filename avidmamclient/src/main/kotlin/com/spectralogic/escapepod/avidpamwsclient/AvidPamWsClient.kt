package com.spectralogic.escapepod.avidpamwsclient

import com.google.common.collect.ImmutableMap
import com.spectralogic.ds3client.Ds3Client
import com.spectralogic.ds3client.helpers.Ds3ClientHelpers
import com.spectralogic.ds3client.models.bulk.Ds3Object
import com.spectralogic.escapepod.api.*
import com.spectralogic.escapepod.api.AvidPamWsClient
import com.spectralogic.escapepod.avidpamclient.soap.ws.*
import com.spectralogic.escapepod.util.maxLong
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.Single
import org.slf4j.LoggerFactory
import java.nio.channels.FileChannel
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption
import java.util.*
import java.util.concurrent.Executor
import java.util.concurrent.ForkJoinPool

class AvidPamWsClient
constructor(username: String, password: String, endpoint: String,
            blackPealClient: Ds3Client,
            private val executor: Executor = ForkJoinPool.commonPool()) : AvidPamWsClient {
    private companion object {
        private val LOG = LoggerFactory.getLogger(AvidPamWsClient::class.java)
        private val JOBS = "Jobs"
        private val ASSETS = "Assets"
        private val INFRASTRUCTURE = "Infrastructure"
    }
    private val credentials = UserCredentialsType()

    private val jobsLocator = JobsLocator()

    private val assetsLocator = AssetsLocator()
    private val infrastructureLocator = InfrastructureLocator()
    private var jobsEndpointUrl: String

    private var assetsEndpointUrl: String
    private var infrastructureEndpointUrl: String
    private var jobsSoapClient: JobsPortType

    private var assetsSoapClient: AssetsPortType
    private var infrastructureSoapClient: InfrastructurePortType
    private var blackPearlClientHelpers: Ds3ClientHelpers

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

        blackPearlClientHelpers = Ds3ClientHelpers.wrap(blackPealClient)
    }

    override fun getPamAssets(interplayURI: String): Observable<PamAssets> {
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

    override fun getPamProfiles(workgroupURI: String, services: Array<String>, showParameters: Boolean):
            Single<PamProfiles> {

        return Single.create { emitter ->
            executor.execute {
                try {
                    val profiles = GetProfilesType()
                    profiles.workgroupURI = workgroupURI
                    profiles.services = services
                    profiles.showParameters = showParameters

                    val res = jobsSoapClient.getProfiles(profiles, credentials)

                    if (res.errors != null) {
                        emitter.onError(TransformUtils.errorTypeToThrowable(res.errors))
                    } else {
                        emitter.onSuccess(PamProfiles(TransformUtils.profileTypeToPamProfile(res.results)))
                    }
                } catch (t: Throwable) {
                    emitter.onError(t)
                }
            }
        }
    }

    override fun restorePamAsset(profile: String, interplayURI: String): Single<PamJob> {
        return Single.create { emitter ->
            executor.execute {
                try {
                    val submitJobUsingProfileType = SubmitJobUsingProfileType()
                    submitJobUsingProfileType.service = "com.avid.dms.restore"
                    submitJobUsingProfileType.profile = profile
                    submitJobUsingProfileType.interplayURI = interplayURI

                    val res = jobsSoapClient.submitJobUsingProfile(submitJobUsingProfileType, credentials)

                    if (res.errors != null) {
                        emitter.onError(TransformUtils.errorTypeToThrowable(res.errors))
                    } else {
                        emitter.onSuccess(PamJob(interplayURI, res.jobURI))
                    }
                } catch (t: Throwable) {
                    emitter.onError(t)
                }
            }
        }
    }

    override fun archivePamAsset(profile: String, interplayURI: String): Single<PamJob> {
        return Single.create { emitter ->
            executor.execute {
                try {
                    val submitJobUsingProfileType = SubmitJobUsingProfileType()
                    submitJobUsingProfileType.service = "com.avid.dms.archive"
                    submitJobUsingProfileType.profile = profile
                    submitJobUsingProfileType.interplayURI = interplayURI

                    val res = jobsSoapClient.submitJobUsingProfile(submitJobUsingProfileType, credentials)

                    if (res.errors != null) {
                        emitter.onError(TransformUtils.errorTypeToThrowable(res.errors))
                    } else {
                        emitter.onSuccess(PamJob(interplayURI, res.jobURI))
                    }
                } catch (t: Throwable) {
                    emitter.onError(t)
                }
            }
        }
    }

    override fun getPamJobStatus(jobURI: String): Single<PamJobStatus> {
        return Single.create { emitter ->
            executor.execute {
                try {
                    val getJobStatusType = GetJobStatusType()
                    getJobStatusType.jobURIs = arrayOf(jobURI)
                    val res = jobsSoapClient.getJobStatus(getJobStatusType, credentials)

                    if (res.errors != null) {
                        emitter.onError(TransformUtils.errorTypeToThrowable(res.errors))
                    } else {
                        emitter.onSuccess(
                                TransformUtils.jobStatusTypeToPamJobStatus(res.jobStatusTypes))
                    }
                } catch (t: Throwable) {
                    emitter.onError(t)
                }
            }
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

    override fun getPamWorkGroups(): Single<PamWorkGroups> {
        return Single.create { emitter ->
            executor.execute {
                try {
                    val getConfigurationInformationType = GetConfigurationInformationType()

                    val res = infrastructureSoapClient.getConfigurationInformation(getConfigurationInformationType)

                    if (res.errors != null) {
                        emitter.onError(TransformUtils.errorTypeToThrowable(res.errors))
                    } else {
                        emitter.onSuccess(PamWorkGroups(
                                TransformUtils.getConfigurationInformationTypeToPamWorkGroup(res.results)))
                    }
                } catch (t: Throwable) {
                    emitter.onError(t)
                }
            }
        }
    }

    private fun getChildrenHelper(interplayURI: String, emitter: ObservableEmitter<PamAssets>) {
        val foldersQueue: Queue<String> = LinkedList<String>()

        val getChildrenType = GetChildrenType()
        getChildrenType.interplayURI = interplayURI
        getChildrenType.includeFolders = true
        getChildrenType.includeFiles = true
        getChildrenType.includeMOBs = true

        var res = assetsSoapClient.getChildren(getChildrenType, credentials)

        if (res.errors != null) {
            emitter.onError(Throwable(res.errors.joinToString("\n") { it -> "${it.message}, ${it.details}" }))
            return
        }

        for (r in res.results) {
            val uri = r.interplayURI
            val attributeMap = TransformUtils.attributeTypeToAttributeMap(r.attributes)

            if (attributeMap.getOrDefault("Path", "N/A").endsWith("/")) {
                foldersQueue.add(uri)
            } else {
                emitter.onNext(PamAssets(
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
                emitter.onError(Throwable(res.errors.joinToString("\n") { it -> "${it.message}, ${it.details}" }))
                return
            }

            for (r in res.results) {
                val uri = r.interplayURI
                val attributeMap = TransformUtils.attributeTypeToAttributeMap(r.attributes)

                if (attributeMap.getOrDefault("Path", "N/A").endsWith("/")) {
                    foldersQueue.add(uri)
                } else {
                    emitter.onNext(PamAssets(
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
            emitter.onError(Throwable(res.errors.joinToString("\n") { it -> "${it.message}, ${it.details}" }))
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
                emitter.onError(Throwable(res.errors.joinToString("\n") { it -> "${it.message}, ${it.details}" }))
                return
            }

            for (r in res.results) {
                val uri = r.interplayURI
                foldersQueue.add(uri)
                emitter.onNext(PamFolder(uri))
            }
        }
    }

    //TODO test using masterclip (BP job per master clip), Sequence (1 BP job for all the sequence)
    override fun archivePamAssetToBlackPearl(bucket: String, interplayURI: String): Completable {
        val mapBuilder = ImmutableMap.builder<String, String>()
        val pamMetadataAccess = PamMetadataAccess()
        return getFileLocations(interplayURI)
                .map { fileLocation ->
                    val mobid = fileLocation.interplayURI.substring(fileLocation.interplayURI.indexOf("=") + 1)
                    mapBuilder.put(mobid, fileLocation.filePath)

                    pamMetadataAccess.addMetadataValue(mobid,
                            ImmutableMap.of(
                                    "clipid", interplayURI.substring(interplayURI.indexOf("=") + 1),
                                    "filename", fileLocation.filePath,
                                    "filesize", fileLocation.size.toString(),
                                    "fileid", mobid,
                                    "fileresolution", fileLocation.format
                            ))


                    Ds3Object(mobid, fileLocation.size)
                }.toList()
                .flatMapCompletable { objectsToTransfer ->
                    try {
                        val fileMap = mapBuilder.build()

                        LOG.info("Ensure bucket '$bucket' exists")
                        blackPearlClientHelpers.ensureBucketExists(bucket)

                        val job = blackPearlClientHelpers.startWriteJob(bucket, objectsToTransfer)
                        LOG.info("Job ${job.jobId} was created")

                        job.attachObjectCompletedListener { it ->
                            LOG.info("Finished archiving $it")
                        }

                        job.withMetadata(pamMetadataAccess)

                        job.transfer { key ->
                            FileChannel.open(Paths.get(fileMap[key]), StandardOpenOption.READ)
                        }

                        Completable.complete()
                    } catch (t: Throwable) {
                        Completable.error(t)
                    }
                }
    }

    override fun getFileLocations(interplayURI: String): Observable<FileLocation> {
        return Observable.create { emitter ->
            try {
                val getFilesDetailsType = GetFileDetailsType()
                getFilesDetailsType.interplayURIs = arrayOf(interplayURI)

                val res = assetsSoapClient.getFileDetails(getFilesDetailsType, credentials)

                if (res.errors != null) {
                    emitter.onError(Throwable(res.errors.joinToString("\n") { it -> "${it.message}, ${it.details}" }))
                } else {
                    res.results[0].fileLocations.forEach { fl ->
                        emitter.onNext(FileLocation(fl.filePath, fl.interplayURI, Files.size(Paths.get(fl.filePath)), fl.status, fl.format))
                    }
                    emitter.onComplete()
                }
            } catch (t: Throwable) {
                emitter.onError(t)
            }
        }
    }

    override fun getSequenceRelatives(interplayURI: String): Observable<SequenceRelative> {
        return Observable.create {emitter ->
            try {
                val findRelativeType = FindRelativesType()
                findRelativeType.interplayURI = interplayURI

                val res = assetsSoapClient.findRelatives(findRelativeType, credentials)

                if (res.errors != null) {
                    emitter.onError(Throwable(res.errors.joinToString("\n") { it -> "${it.message}, ${it.details}" }))
                } else {
                    res.results.forEach { asset ->
                        emitter.onNext(SequenceRelative(asset.interplayURI))
                    }
                    emitter.onComplete()
                }
            } catch (t: Throwable) {
                emitter.onError(t)
            }
        }
    }
}


