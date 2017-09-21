package com.spectralogic.escapepod.avidpamwsclient

import com.spectralogic.escapepod.api.*
import com.spectralogic.escapepod.api.AvidPamWsClient
import com.spectralogic.escapepod.avidpamclient.soap.ws.*
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.Single
import io.reactivex.SingleEmitter
import org.slf4j.LoggerFactory
import java.util.*
import java.util.concurrent.Executor
import java.util.concurrent.ForkJoinPool

class AvidPamWsClient
constructor(username: String, password: String, endpoint: String,
            private val executor: Executor = ForkJoinPool.commonPool()) : AvidPamWsClient {
    companion object {


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
    }

    override fun getChildren(interplayURI: String): Observable<GetChildrenResult> {
        return Observable.create { emitter ->
            executor.execute {
                try {
                    getChildrenHelper(interplayURI, emitter)
                    emitter.onComplete()
                } catch (t: Throwable) {
                    LOG.error("Failed to get children", t)
                    emitter.onError(t)
                }
            }
        }
    }

    override fun getFolders(interplayURI: String): Observable<GetFoldersResult> {
        return Observable.create { emitter ->
            executor.execute {
                try {
                    getFoldersHelper(interplayURI, emitter)
                    emitter.onComplete()
                } catch (t: Throwable) {
                    LOG.error("Failed to get folders", t)
                    emitter.onError(t)
                }
            }
        }
    }

    override fun getProfiles(workgroupURI: String, services: Array<String>, showParameters: Boolean):
            Single<GetProfilesResponse> {

        return Single.create { emitter ->
            executor.execute {
                try {
                    val profiles = GetProfilesType()
                    profiles.workgroupURI = workgroupURI
                    profiles.services = services
                    profiles.showParameters = showParameters

                    val res = jobsSoapClient.getProfiles(profiles, credentials)

                    emitter.onSuccess(GetProfilesResponse(
                            TransformUtils.profileTypeToGetProfileResult(res.results),
                            TransformUtils.errorTypeToWsError(res.errors)))
                } catch (t: Throwable) {
                    LOG.error("Failed to get profiles", t)
                    emitter.onError(t)
                }
            }
        }
    }

    override fun restore(profile: String, interplayURI: String): Single<JobResponse> {
        return Single.create { emitter ->
            executor.execute {
                try {
                    val submitJobUsingProfileType = SubmitJobUsingProfileType()
                    submitJobUsingProfileType.service = "com.avid.dms.restore"
                    submitJobUsingProfileType.profile = profile
                    submitJobUsingProfileType.interplayURI = interplayURI

                    val res = jobsSoapClient.submitJobUsingProfile(submitJobUsingProfileType, credentials)

                    emitter.onSuccess(JobResponse(interplayURI, res.jobURI, TransformUtils.errorTypeToWsError(res.errors)))
                } catch (t: Throwable) {
                    LOG.error("Failed to restore", t)
                    emitter.onError(t)
                }
            }
        }
    }

    override fun archive(profile: String, interplayURI: String): Single<JobResponse> {
        return Single.create { emitter ->
            executor.execute {
                try {
                    val submitJobUsingProfileType = SubmitJobUsingProfileType()
                    submitJobUsingProfileType.service = "com.avid.dms.archive"
                    submitJobUsingProfileType.profile = profile
                    submitJobUsingProfileType.interplayURI = interplayURI

                    val res = jobsSoapClient.submitJobUsingProfile(submitJobUsingProfileType, credentials)

                    emitter.onSuccess(JobResponse(interplayURI, res.jobURI, TransformUtils.errorTypeToWsError(res.errors)))
                } catch (t: Throwable) {
                    LOG.error("Failed to archive", t)
                    emitter.onError(t)
                }
            }
        }
    }

    override fun getJobsStatus(jobsURI: Array<String>): Single<JobsStatusResponse> {
        return Single.create { emitter ->
            executor.execute {
                try {
                    val getJobStatusType = GetJobStatusType()
                    getJobStatusType.jobURIs = jobsURI
                    val res = jobsSoapClient.getJobStatus(getJobStatusType, credentials)

                    emitter.onSuccess(JobsStatusResponse(
                            TransformUtils.jobStatusTypeToJobStatusResult(res.jobStatusTypes),
                            TransformUtils.errorTypeToWsError(res.errors)))
                } catch (t: Throwable) {
                    LOG.error("Failed to query job status", t)
                    emitter.onError(t)
                }
            }
        }
    }

    override fun getMaxArchiveAssetSize(interplayURI: String): Single<GetMaxArchiveAssetSize> {
        return Single.create { emitter ->
            executor.execute {
                try {
                    getMaxArchiveAssetSizeHelper(interplayURI, emitter)
                } catch (t: Throwable) {
                    LOG.error("Failed to get the max archive asset size", t)
                    emitter.onError(t)
                }
            }
        }
    }

    override fun getWorkGroups(): Single<GetWorkGroupsResponse> {
        return Single.create { emitter ->
            executor.execute {
                try {
                    val getConfigurationInformationType = GetConfigurationInformationType()

                    val res = infrastructureSoapClient.getConfigurationInformation(getConfigurationInformationType)
                    emitter.onSuccess(GetWorkGroupsResponse(
                            TransformUtils.getConfigurationInformationTypeToGetWorkGroupResult(res.results),
                            TransformUtils.errorTypeToWsError(res.errors)
                    ))
                } catch (t: Throwable) {
                    LOG.error("Failed to get the system work groups", t)
                    emitter.onError(t)
                }
            }
        }
    }

    private fun getChildrenHelper(interplayURI: String, emitter: ObservableEmitter<GetChildrenResult>) {

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

//            attributeMap.forEach { it -> LOG.debug("${it.key}, ${it.value}") }
//            LOG.debug("\n")

            if (attributeMap.getOrDefault("Path", "N/A").endsWith("/")) {
                foldersQueue.add(uri)
            } else {
                emitter.onNext(GetChildrenResult(
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

        while (foldersQueue.isNotEmpty()) {
            getChildrenType.interplayURI = foldersQueue.poll()
            res = assetsSoapClient.getChildren(getChildrenType, credentials)

            if (res.errors != null) {
                emitter.onError(Throwable(res.errors.joinToString("\n") { it -> "${it.message}, ${it.details}" }))
                return
            }

            for (r in res.results) {
                val uri = r.interplayURI
                val attributeMap = TransformUtils.attributeTypeToAttributeMap(r.attributes)

//                attributeMap.forEach { it -> LOG.debug("${it.key}, ${it.value}") }
//                LOG.debug("\n")

                if (attributeMap.getOrDefault("Path", "N/A").endsWith("/")) {
                    foldersQueue.add(uri)
                } else {
                    emitter.onNext(GetChildrenResult(
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

    private fun getFoldersHelper(interplayURI: String, emitter: ObservableEmitter<GetFoldersResult>) {

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
            emitter.onNext(GetFoldersResult(uri))
        }

        while (foldersQueue.isNotEmpty()) {
            getChildrenType.interplayURI = foldersQueue.poll()
            res = assetsSoapClient.getChildren(getChildrenType, credentials)

            if (res.errors != null) {
                emitter.onError(Throwable(res.errors.joinToString("\n") { it -> "${it.message}, ${it.details}" }))
                return
            }

            for (r in res.results) {
                val uri = r.interplayURI
                foldersQueue.add(uri)
                emitter.onNext(GetFoldersResult(uri))
            }
        }
    }

    private fun getMaxArchiveAssetSizeHelper(interplayURI: String, emitter: SingleEmitter<GetMaxArchiveAssetSize>) {
        var max: Long = 0
        getChildren(interplayURI)
                .doOnNext { it ->
                    if (it.mediaSize != "N/A" && max < it.mediaSize.toLong()) {
                        max = it.mediaSize.toLong()
                    }
                }
                .doOnComplete {
                    //TODO remove empty list
                    emitter.onSuccess(GetMaxArchiveAssetSize(max, emptyList()))
                }
                .doOnError { t ->
                    emitter.onError(t)
                }
                .subscribe()
    }
}
