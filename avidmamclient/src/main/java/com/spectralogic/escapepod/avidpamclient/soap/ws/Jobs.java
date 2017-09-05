/**
 * Jobs.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;

public interface Jobs extends javax.xml.rpc.Service {

/**
 * The Jobs Service is a SOAP-based entry point into the Avid Interplay
 * Media Services Engine as well as
 *       a control interface for Media Services and Transfer jobs.
 */
    public java.lang.String getJobsPortAddress();

    public com.spectralogic.escapepod.avidpamclient.soap.ws.JobsPortType getJobsPort() throws javax.xml.rpc.ServiceException;

    public com.spectralogic.escapepod.avidpamclient.soap.ws.JobsPortType getJobsPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
