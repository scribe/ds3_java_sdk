/**
 * JobsPortBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;

public class JobsPortBindingStub extends org.apache.axis.client.Stub implements com.spectralogic.escapepod.avidpamclient.soap.ws.JobsPortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[9];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CancelJobs");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "CancelJobs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "CancelJobsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.CancelJobsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "CancelJobsResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.CancelJobsResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "CancelJobsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "JobsFault"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "JobsFaultType"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeleteJobs");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "DeleteJobs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "DeleteJobsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.DeleteJobsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "DeleteJobsResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.DeleteJobsResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "DeleteJobsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "JobsFault"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "JobsFaultType"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetJobStatus");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "GetJobStatus"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "GetJobStatusType"), com.spectralogic.escapepod.avidpamclient.soap.ws.GetJobStatusType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "GetJobStatusResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.GetJobStatusResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "GetJobStatusResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "JobsFault"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "JobsFaultType"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetProfiles");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "GetProfiles"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "GetProfilesType"), com.spectralogic.escapepod.avidpamclient.soap.ws.GetProfilesType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "GetProfilesResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.GetProfilesResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "GetProfilesResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "JobsFault"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "JobsFaultType"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("PauseJobs");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "PauseJobs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "PauseJobsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.PauseJobsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "PauseJobsResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.PauseJobsResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "PauseJobsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "JobsFault"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "JobsFaultType"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ResumeJobs");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "ResumeJobs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "ResumeJobsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.ResumeJobsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "ResumeJobsResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.ResumeJobsResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "ResumeJobsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "JobsFault"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "JobsFaultType"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RetryJobs");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "RetryJobs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "RetryJobsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.RetryJobsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "RetryJobsResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.RetryJobsResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "RetryJobsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "JobsFault"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "JobsFaultType"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SubmitJobUsingParameters");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "SubmitJobUsingParameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "SubmitJobUsingParametersType"), com.spectralogic.escapepod.avidpamclient.soap.ws.SubmitJobUsingParametersType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "SubmitJobUsingParametersResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.SubmitJobUsingParametersResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "SubmitJobUsingParametersResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "JobsFault"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "JobsFaultType"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SubmitJobUsingProfile");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "SubmitJobUsingProfile"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "SubmitJobUsingProfileType"), com.spectralogic.escapepod.avidpamclient.soap.ws.SubmitJobUsingProfileType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "SubmitJobUsingProfileResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.SubmitJobUsingProfileResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "SubmitJobUsingProfileResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "JobsFault"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "JobsFaultType"), 
                      true
                     ));
        _operations[8] = oper;

    }

    public JobsPortBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public JobsPortBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public JobsPortBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "CancelJobsResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.CancelJobsResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "CancelJobsType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.CancelJobsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "DeleteJobsResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.DeleteJobsResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "DeleteJobsType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.DeleteJobsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "GetJobStatusResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetJobStatusResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "GetJobStatusType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetJobStatusType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "GetProfilesResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetProfilesResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "GetProfilesType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetProfilesType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "JobsFaultType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "JobStatusListType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.JobStatusType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "JobStatusType");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "JobStatus");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "JobStatusType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.JobStatusType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "JobURIListType");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "JobURI");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "ParameterType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.ParameterType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "PauseJobsResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.PauseJobsResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "PauseJobsType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.PauseJobsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "ProfileListType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.ProfileType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "ProfileType");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "Profile");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "ProfileParameterType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.ParameterType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "ParameterType");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "Parameter");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "ProfileType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.ProfileType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "ResumeJobsResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.ResumeJobsResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "ResumeJobsType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.ResumeJobsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "RetryJobsResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.RetryJobsResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "RetryJobsType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.RetryJobsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "ServiceListType");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "Name");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "SubmitJobUsingParametersResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.SubmitJobUsingParametersResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "SubmitJobUsingParametersType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.SubmitJobUsingParametersType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "SubmitJobUsingProfileResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.SubmitJobUsingProfileResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "SubmitJobUsingProfileType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.SubmitJobUsingProfileType.class;
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

    public com.spectralogic.escapepod.avidpamclient.soap.ws.CancelJobsResponseType cancelJobs(com.spectralogic.escapepod.avidpamclient.soap.ws.CancelJobsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType {
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
        _call.setOperationName(new javax.xml.namespace.QName("", "CancelJobs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.CancelJobsResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.CancelJobsResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.CancelJobsResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.DeleteJobsResponseType deleteJobs(com.spectralogic.escapepod.avidpamclient.soap.ws.DeleteJobsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType {
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
        _call.setOperationName(new javax.xml.namespace.QName("", "DeleteJobs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.DeleteJobsResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.DeleteJobsResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.DeleteJobsResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetJobStatusResponseType getJobStatus(com.spectralogic.escapepod.avidpamclient.soap.ws.GetJobStatusType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetJobStatus"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetJobStatusResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetJobStatusResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.GetJobStatusResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetProfilesResponseType getProfiles(com.spectralogic.escapepod.avidpamclient.soap.ws.GetProfilesType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetProfiles"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetProfilesResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetProfilesResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.GetProfilesResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.PauseJobsResponseType pauseJobs(com.spectralogic.escapepod.avidpamclient.soap.ws.PauseJobsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "PauseJobs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.PauseJobsResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.PauseJobsResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.PauseJobsResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.ResumeJobsResponseType resumeJobs(com.spectralogic.escapepod.avidpamclient.soap.ws.ResumeJobsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ResumeJobs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.ResumeJobsResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.ResumeJobsResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.ResumeJobsResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.RetryJobsResponseType retryJobs(com.spectralogic.escapepod.avidpamclient.soap.ws.RetryJobsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "RetryJobs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.RetryJobsResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.RetryJobsResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.RetryJobsResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.SubmitJobUsingParametersResponseType submitJobUsingParameters(com.spectralogic.escapepod.avidpamclient.soap.ws.SubmitJobUsingParametersType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "SubmitJobUsingParameters"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.SubmitJobUsingParametersResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.SubmitJobUsingParametersResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.SubmitJobUsingParametersResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.SubmitJobUsingProfileResponseType submitJobUsingProfile(com.spectralogic.escapepod.avidpamclient.soap.ws.SubmitJobUsingProfileType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "SubmitJobUsingProfile"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.SubmitJobUsingProfileResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.SubmitJobUsingProfileResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.SubmitJobUsingProfileResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.JobsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
