/**
 * JobsPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;

public interface JobsPortType extends java.rmi.Remote {

    /**
     * Cancel a Media Service or Transfer job.
     * 
     *         Since: 2.0
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.CancelJobsResponseType cancelJobs(com.spectralogic.escapepod.avidpamclient.soap.ws.CancelJobsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType;

    /**
     * Delete a Media Services job. If called on a Transfer Job, will
     * pause the job and return an error.
     * 
     *         Since: 2.0
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.DeleteJobsResponseType deleteJobs(com.spectralogic.escapepod.avidpamclient.soap.ws.DeleteJobsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType;

    /**
     * Gets the status of a Media Services or Transfer job.
     * 
     *         Since: 2.0
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetJobStatusResponseType getJobStatus(com.spectralogic.escapepod.avidpamclient.soap.ws.GetJobStatusType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType;

    /**
     * Gets the configured profiles for a list of services in Media
     * Services.
     * 
     *         Since: 2.0
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetProfilesResponseType getProfiles(com.spectralogic.escapepod.avidpamclient.soap.ws.GetProfilesType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType;

    /**
     * Pause one or more Transfer jobs. Not supported for Media Services
     * jobs.
     * 
     *         Since: 2.0
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.PauseJobsResponseType pauseJobs(com.spectralogic.escapepod.avidpamclient.soap.ws.PauseJobsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType;

    /**
     * Resume one or more Transfer jobs. Not supported for Media Services.
     * 
     *         Since: 2.0
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ResumeJobsResponseType resumeJobs(com.spectralogic.escapepod.avidpamclient.soap.ws.ResumeJobsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType;

    /**
     * Retry one or more Transfer jobs. Currently not supported for
     * Media Services (expected in future version).
     * 
     *         Since: 2.0
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.RetryJobsResponseType retryJobs(com.spectralogic.escapepod.avidpamclient.soap.ws.RetryJobsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType;

    /**
     * Submit a Media Services job using a set of parameters.
     * 
     *         Integrators should note: In order to prevent the Media Services
     * Engine from being overloaded by requests, a
     *         threshold has been put in place. No more than 20 jobs per
     * minute may be submitted to the Media Services Engine
     *         via Interplay WS. If the limit is exceeded, the submit job
     * request will be rejected with an error saying that
     *         the limit has been reached.
     * 
     *         Since: 2.0
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.SubmitJobUsingParametersResponseType submitJobUsingParameters(com.spectralogic.escapepod.avidpamclient.soap.ws.SubmitJobUsingParametersType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType;

    /**
     * Submit a Media Services job using a pre-defined profile.
     * 
     *         Integrators should note: In order to prevent the Media Services
     * Engine from being overloaded by requests, a
     *         threshold has been put in place. No more than 20 jobs per
     * minute may be submitted to the Media Services Engine
     *         via Interplay WS. If the limit is exceeded, the submit job
     * request will be rejected with an error saying that
     *         the limit has been reached.
     * 
     *         Since: 2.0
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.SubmitJobUsingProfileResponseType submitJobUsingProfile(com.spectralogic.escapepod.avidpamclient.soap.ws.SubmitJobUsingProfileType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType;
}
