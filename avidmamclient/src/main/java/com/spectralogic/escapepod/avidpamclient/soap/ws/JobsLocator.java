/**
 * JobsLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;

public class JobsLocator extends org.apache.axis.client.Service implements com.spectralogic.escapepod.avidpamclient.soap.ws.Jobs {

/**
 * The Jobs Service is a SOAP-based entry point into the Avid Interplay
 * Media Services Engine as well as
 *       a control interface for Media Services and Transfer jobs.
 */

    public JobsLocator() {
    }


    public JobsLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public JobsLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for JobsPort
    private java.lang.String JobsPort_address = "http://localhost/services/Jobs";

    public java.lang.String getJobsPortAddress() {
        return JobsPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String JobsPortWSDDServiceName = "JobsPort";

    public java.lang.String getJobsPortWSDDServiceName() {
        return JobsPortWSDDServiceName;
    }

    public void setJobsPortWSDDServiceName(java.lang.String name) {
        JobsPortWSDDServiceName = name;
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.JobsPortType getJobsPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(JobsPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getJobsPort(endpoint);
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.JobsPortType getJobsPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.spectralogic.escapepod.avidpamclient.soap.ws.JobsPortBindingStub _stub = new com.spectralogic.escapepod.avidpamclient.soap.ws.JobsPortBindingStub(portAddress, this);
            _stub.setPortName(getJobsPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setJobsPortEndpointAddress(java.lang.String address) {
        JobsPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.spectralogic.escapepod.avidpamclient.soap.ws.JobsPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.spectralogic.escapepod.avidpamclient.soap.ws.JobsPortBindingStub _stub = new com.spectralogic.escapepod.avidpamclient.soap.ws.JobsPortBindingStub(new java.net.URL(JobsPort_address), this);
                _stub.setPortName(getJobsPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("JobsPort".equals(inputPortName)) {
            return getJobsPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs", "Jobs");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs", "JobsPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("JobsPort".equals(portName)) {
            setJobsPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
