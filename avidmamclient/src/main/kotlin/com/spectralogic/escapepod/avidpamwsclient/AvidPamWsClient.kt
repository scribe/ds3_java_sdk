package com.spectralogic.escapepod.avidpamwsclient

import com.spectralogic.escapepod.api.*
import com.spectralogic.escapepod.api.AvidPamWsClient
import com.spectralogic.escapepod.avidpamclient.soap.ws.*
import io.reactivex.Single
import org.slf4j.LoggerFactory
import java.util.concurrent.Executor
import java.util.concurrent.ForkJoinPool

internal class AvidPamWsClient
constructor(username: String, password: String, endpoint: String,
            private val executor: Executor = ForkJoinPool.commonPool()) : AvidPamWsClient {


    companion object {
        private val LOG = LoggerFactory.getLogger(AvidPamWsClient::class.java)
        private val JOBS = "Jobs"
        private val ASSETS = "Assets"
    }

    private val credentials = UserCredentialsType()
    private val jobsLocator = JobsLocator()
    private val assetsLocator = AssetsLocator()

    private var jobsEndpointUrl: String
    private var assetsEndpointUrl: String

    private var jobsSoapClient: JobsPortType
    private var assetsSoapClient: AssetsPortType

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
    }

    override fun getChildren(interplayURI: String): Single<GetChildrenResponse> {
        return Single.create { emitter ->
            executor.execute {
                try {
                    val getChildrenType = GetChildrenType()
                    getChildrenType.interplayURI = interplayURI

                    val res = assetsSoapClient.getChildren(getChildrenType, credentials)

                    emitter.onSuccess(GetChildrenResponse(
                            TransformUtils.assetDescriptionTypeToGetChildrenResult(res.results),
                            TransformUtils.errorTypeToWsError(res.errors)))
                } catch (t: Throwable) {
                    LOG.error("Failed to get children", t)
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

                    emitter.onSuccess(JobResponse(res.jobURI, TransformUtils.errorTypeToWsError(res.errors)))
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

                    emitter.onSuccess(JobResponse(res.jobURI, TransformUtils.errorTypeToWsError(res.errors)))
                } catch (t: Throwable) {
                    LOG.error("Failed to archive", t)
                    emitter.onError(t)
                }
            }
        }
    }

    override fun getJobStatus(jobURIs: Array<String>): Single<JobStatusResponse> {
        return Single.create { emitter ->
            executor.execute {
                try {
                    val getJobStatusType = GetJobStatusType()
                    getJobStatusType.jobURIs = jobURIs
                    val res = jobsSoapClient.getJobStatus(getJobStatusType, credentials)

                    emitter.onSuccess(JobStatusResponse(
                            TransformUtils.jobStatusTypeToJobStatusResult(res.jobStatusTypes),
                            TransformUtils.errorTypeToWsError(res.errors)))
                } catch (t: Throwable) {
                    LOG.error("Failed to query job status", t)
                    emitter.onError(t)
                }
            }
        }
    }
}