/**
 * Infrastructure.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;

public interface Infrastructure extends javax.xml.rpc.Service {

/**
 * The Infrastructure service is a SOAP-based entry point for queries
 * regarding general infrastructure
 */
    public java.lang.String getInfrastructurePortAddress();

    public com.spectralogic.escapepod.avidpamclient.soap.ws.InfrastructurePortType getInfrastructurePort() throws javax.xml.rpc.ServiceException;

    public com.spectralogic.escapepod.avidpamclient.soap.ws.InfrastructurePortType getInfrastructurePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
