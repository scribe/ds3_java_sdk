/**
 * InfrastructurePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;

public interface InfrastructurePortType extends java.rmi.Remote {

    /**
     * Gets the config info for Interplay Web Services.
     * 
     *         Since: 1.4
     *         Modified: 2.0
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetConfigurationInformationResponseType getConfigurationInformation(com.spectralogic.escapepod.avidpamclient.soap.ws.GetConfigurationInformationType body) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.InfrastructureFaultType;

    /**
     * Gets the version of Interplay Web Services as well as the Interplay
     * Engines
     *         and Archive Engines that are configured on Interplay Web Services.
     * 
     *         Since: 1.4
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetVersionInformationResponseType getVersionInformation(com.spectralogic.escapepod.avidpamclient.soap.ws.GetVersionInformationType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.InfrastructureFaultType;
}
