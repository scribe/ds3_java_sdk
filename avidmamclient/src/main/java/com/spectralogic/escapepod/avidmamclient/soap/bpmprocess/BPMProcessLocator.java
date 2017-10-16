/**
 * BPMProcessLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidmamclient.soap.bpmprocess;

public class BPMProcessLocator extends org.apache.axis.client.Service implements com.spectralogic.escapepod.avidmamclient.soap.bpmprocess.BPMProcess {

    public BPMProcessLocator() {
    }


    public BPMProcessLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BPMProcessLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BPMProcessSoap
    private java.lang.String BPMProcessSoap_address = "http://win-pa6n293ucm0:9900/WorkflowLibraryWS/BPMProcess.asmx";

    public java.lang.String getBPMProcessSoapAddress() {
        return BPMProcessSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BPMProcessSoapWSDDServiceName = "BPMProcessSoap";

    public java.lang.String getBPMProcessSoapWSDDServiceName() {
        return BPMProcessSoapWSDDServiceName;
    }

    public void setBPMProcessSoapWSDDServiceName(java.lang.String name) {
        BPMProcessSoapWSDDServiceName = name;
    }

    public com.spectralogic.escapepod.avidmamclient.soap.bpmprocess.BPMProcessSoap_PortType getBPMProcessSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BPMProcessSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBPMProcessSoap(endpoint);
    }

    public com.spectralogic.escapepod.avidmamclient.soap.bpmprocess.BPMProcessSoap_PortType getBPMProcessSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.spectralogic.escapepod.avidmamclient.soap.bpmprocess.BPMProcessSoap_BindingStub _stub = new com.spectralogic.escapepod.avidmamclient.soap.bpmprocess.BPMProcessSoap_BindingStub(portAddress, this);
            _stub.setPortName(getBPMProcessSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBPMProcessSoapEndpointAddress(java.lang.String address) {
        BPMProcessSoap_address = address;
    }


    // Use to get a proxy class for BPMProcessSoap12
    private java.lang.String BPMProcessSoap12_address = "http://win-pa6n293ucm0:9900/WorkflowLibraryWS/BPMProcess.asmx";

    public java.lang.String getBPMProcessSoap12Address() {
        return BPMProcessSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BPMProcessSoap12WSDDServiceName = "BPMProcessSoap12";

    public java.lang.String getBPMProcessSoap12WSDDServiceName() {
        return BPMProcessSoap12WSDDServiceName;
    }

    public void setBPMProcessSoap12WSDDServiceName(java.lang.String name) {
        BPMProcessSoap12WSDDServiceName = name;
    }

    public com.spectralogic.escapepod.avidmamclient.soap.bpmprocess.BPMProcessSoap_PortType getBPMProcessSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BPMProcessSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBPMProcessSoap12(endpoint);
    }

    public com.spectralogic.escapepod.avidmamclient.soap.bpmprocess.BPMProcessSoap_PortType getBPMProcessSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.spectralogic.escapepod.avidmamclient.soap.bpmprocess.BPMProcessSoap12Stub _stub = new com.spectralogic.escapepod.avidmamclient.soap.bpmprocess.BPMProcessSoap12Stub(portAddress, this);
            _stub.setPortName(getBPMProcessSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBPMProcessSoap12EndpointAddress(java.lang.String address) {
        BPMProcessSoap12_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.spectralogic.escapepod.avidmamclient.soap.bpmprocess.BPMProcessSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.spectralogic.escapepod.avidmamclient.soap.bpmprocess.BPMProcessSoap_BindingStub _stub = new com.spectralogic.escapepod.avidmamclient.soap.bpmprocess.BPMProcessSoap_BindingStub(new java.net.URL(BPMProcessSoap_address), this);
                _stub.setPortName(getBPMProcessSoapWSDDServiceName());
                return _stub;
            }
            if (com.spectralogic.escapepod.avidmamclient.soap.bpmprocess.BPMProcessSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.spectralogic.escapepod.avidmamclient.soap.bpmprocess.BPMProcessSoap12Stub _stub = new com.spectralogic.escapepod.avidmamclient.soap.bpmprocess.BPMProcessSoap12Stub(new java.net.URL(BPMProcessSoap12_address), this);
                _stub.setPortName(getBPMProcessSoap12WSDDServiceName());
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
        if ("BPMProcessSoap".equals(inputPortName)) {
            return getBPMProcessSoap();
        }
        else if ("BPMProcessSoap12".equals(inputPortName)) {
            return getBPMProcessSoap12();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.blue-order.com/ma/workflowlibraryws/bpmprocess", "BPMProcess");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.blue-order.com/ma/workflowlibraryws/bpmprocess", "BPMProcessSoap"));
            ports.add(new javax.xml.namespace.QName("http://www.blue-order.com/ma/workflowlibraryws/bpmprocess", "BPMProcessSoap12"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BPMProcessSoap".equals(portName)) {
            setBPMProcessSoapEndpointAddress(address);
        }
        else 
if ("BPMProcessSoap12".equals(portName)) {
            setBPMProcessSoap12EndpointAddress(address);
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
