/**
 * Assets.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;

public interface Assets extends javax.xml.rpc.Service {

/**
 * The Assets service is a SOAP-based entry point into the Avid Interplay
 * assets system.
 */
    public java.lang.String getAssetsPortAddress();

    public com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsPortType getAssetsPort() throws javax.xml.rpc.ServiceException;

    public com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsPortType getAssetsPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
