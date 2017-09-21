/**
 * InfrastructurePortBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;

public class InfrastructurePortBindingStub extends org.apache.axis.client.Stub implements com.spectralogic.escapepod.avidpamclient.soap.ws.InfrastructurePortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[2];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetConfigurationInformation");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "GetConfigurationInformation"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "GetConfigurationInformationType"), com.spectralogic.escapepod.avidpamclient.soap.ws.GetConfigurationInformationType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "GetConfigurationInformationResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.GetConfigurationInformationResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "GetConfigurationInformationResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "InfrastructureFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.InfrastructureFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", ">InfrastructureFaultType"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetVersionInformation");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "GetVersionInformation"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "GetVersionInformationType"), com.spectralogic.escapepod.avidpamclient.soap.ws.GetVersionInformationType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "GetVersionInformationResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.GetVersionInformationResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "GetVersionInformationResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "InfrastructureFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.InfrastructureFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", ">InfrastructureFaultType"), 
                      true
                     ));
        _operations[1] = oper;

    }

    public InfrastructurePortBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public InfrastructurePortBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public InfrastructurePortBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetDescriptionListType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.AssetDescriptionType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetDescriptionType");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetDescription");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetDescriptionType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.AssetDescriptionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AttributeConditionType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeConditionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AttributeListType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AttributeType");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Attribute");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AttributeType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CategoryConditionType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.CategoryConditionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ErrorListType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.ErrorType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ErrorType");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Error");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ErrorType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.ErrorType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ExtensionType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FileInUseConditionType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.FileInUseConditionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FileLocationDetailsListType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.FileLocationDetailsType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FileLocationDetailsType");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FileLocationDetails");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FileLocationDetailsType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.FileLocationDetailsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FileLocationListType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.FileLocationType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FileLocationType");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FileLocation");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FileLocationType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.FileLocationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "InterplayURIListType");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "InterplayURI");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ResolutionConditionType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.ResolutionConditionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SearchGroupType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.SearchGroupType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", ">InfrastructureFaultType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.InfrastructureFaultType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "GetConfigurationInformationResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetConfigurationInformationResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "GetConfigurationInformationType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetConfigurationInformationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "GetVersionInformationResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetVersionInformationResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "GetVersionInformationType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetVersionInformationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "WorkGroupDetailsListType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.WorkGroupDetailsType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "WorkGroupDetailsType");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "Workgroup");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "WorkGroupDetailsType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.WorkGroupDetailsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "WorkgroupListType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.WorkgroupType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "WorkgroupType");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "Workgroup");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "WorkgroupType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.WorkgroupType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetConfigurationInformationResponseType getConfigurationInformation(com.spectralogic.escapepod.avidpamclient.soap.ws.GetConfigurationInformationType body) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.InfrastructureFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetConfigurationInformation"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetConfigurationInformationResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetConfigurationInformationResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.GetConfigurationInformationResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.InfrastructureFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.InfrastructureFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetVersionInformationResponseType getVersionInformation(com.spectralogic.escapepod.avidpamclient.soap.ws.GetVersionInformationType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.InfrastructureFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetVersionInformation"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetVersionInformationResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetVersionInformationResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.GetVersionInformationResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.InfrastructureFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.InfrastructureFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
