package com.spectralogic.escapepod.avidpamwsclient

import com.spectralogic.escapepod.api.*
import com.spectralogic.escapepod.avidpamclient.soap.ws.*
import io.reactivex.Single

internal class AvidPamWsSoapClient(username: String, password: String, endpoint: String) : AvidPamWsClient {

    companion object {
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
            val getChildrenType = GetChildrenType()
            getChildrenType.interplayURI = interplayURI

            val res = assetsSoapClient.getChildren(getChildrenType, credentials)

            emitter.onSuccess(GetChildrenResponse(
                    TransformUtils.assetDescriptionTypeToGetChildrenResult(res.results),
                    TransformUtils.errorTypeToWsError(res.errors)))
        }
    }

    override fun getProfiles(workgroupURI: String, services: Array<String>, showParameters: Boolean):
            Single<GetProfilesResponse> {

        return Single.create { emitter ->
            val profiles = GetProfilesType()
            profiles.workgroupURI = workgroupURI
            profiles.services = services
            profiles.showParameters = showParameters

            val res = jobsSoapClient.getProfiles(profiles, credentials)

            emitter.onSuccess(GetProfilesResponse(
                    TransformUtils.profileTypeToGetProfileResult(res.results),
                    TransformUtils.errorTypeToWsError(res.errors)))
        }
    }

    override fun restore(service: String, profile: String, interplayURI: String): Single<RestoreResponse> {
        return Single.create { emitter ->
            val submitJobUsingProfileType = SubmitJobUsingProfileType()
            submitJobUsingProfileType.service = service
            submitJobUsingProfileType.profile = profile
            submitJobUsingProfileType.interplayURI = interplayURI

            val res = jobsSoapClient.submitJobUsingProfile(submitJobUsingProfileType, credentials)

            emitter.onSuccess(RestoreResponse(res.jobURI, TransformUtils.errorTypeToWsError(res.errors)))
        }
    }

    override fun jobStatus(jobURIs: Array<String>): Single<JobStatusResponse> {
        return Single.create { emitter ->
            val getJobStatusType = GetJobStatusType()
            getJobStatusType.jobURIs = jobURIs
            val res = jobsSoapClient.getJobStatus(getJobStatusType, credentials)

            emitter.onSuccess(JobStatusResponse(
                    TransformUtils.jobStatusTypeToJobStatusResult(res.jobStatusTypes),
                    TransformUtils.errorTypeToWsError(res.errors)))
        }
    }
}