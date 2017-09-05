/**
 * AssetsPortBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;

public class AssetsPortBindingStub extends org.apache.axis.client.Stub implements com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsPortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[44];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
        _initOperationDesc4();
        _initOperationDesc5();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetStreamingURL");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetStreamingURL"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetStreamingURLType"), com.spectralogic.escapepod.avidpamclient.soap.ws.GetStreamingURLType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetStreamingURLResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.GetStreamingURLResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetStreamingURLResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetSegmentsFromComposition");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetSegmentsFromComposition"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetSegmentsFromCompositionType"), com.spectralogic.escapepod.avidpamclient.soap.ws.GetSegmentsFromCompositionType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetSegmentsFromCompositionResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.GetSegmentsFromCompositionResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetSegmentsFromCompositionResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddReservation");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AddReservation"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AddReservationType"), com.spectralogic.escapepod.avidpamclient.soap.ws.AddReservationType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AddReservationResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.AddReservationResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AddReservationResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddRestrictions");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AddRestrictions"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AddRestrictionsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.AddRestrictionsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AddRestrictionsResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.AddRestrictionsResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AddRestrictionsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddFileMobs");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AddFileMobs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AddFileMobsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.AddFileMobsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AddFileMobsResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.AddFileMobsResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AddFileMobsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CheckInAMAAAF");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CheckInAMAAAF"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CheckInAAFType"), com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInAAFType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CheckInAAFResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInAAFResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CheckInAMAAAFResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CheckIn");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CheckIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CheckInType"), com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CheckInResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CheckInResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CheckInAAF");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CheckInAAF"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CheckInAAFType"), com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInAAFType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CheckInAAFResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInAAFResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CheckInAAFResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CreateFolder");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateFolder"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateFolderType"), com.spectralogic.escapepod.avidpamclient.soap.ws.CreateFolderType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateFolderResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.CreateFolderResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateFolderResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CreateFolders");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateFolders"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateFoldersType"), com.spectralogic.escapepod.avidpamclient.soap.ws.CreateFoldersType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateFoldersResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.CreateFoldersResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateFoldersResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CreateSubclip");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateSubclip"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateSubclipType"), com.spectralogic.escapepod.avidpamclient.soap.ws.CreateSubclipType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateSubclipResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.CreateSubclipResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateSubclipResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeleteAssets");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "DeleteAssets"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "DeleteAssetsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.DeleteAssetsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "DeleteAssetsResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.DeleteAssetsResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "DeleteAssetsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Duplicate");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Duplicate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "DuplicateType"), com.spectralogic.escapepod.avidpamclient.soap.ws.DuplicateType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "DuplicateResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.DuplicateResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "DuplicateResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("FindLinks");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FindLinks"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FindLinksType"), com.spectralogic.escapepod.avidpamclient.soap.ws.FindLinksType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FindLinksResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.FindLinksResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FindLinksResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("FindRelatives");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FindRelatives"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FindRelativesType"), com.spectralogic.escapepod.avidpamclient.soap.ws.FindRelativesType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FindRelativesResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.FindRelativesResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FindRelativesResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAttributes");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetAttributes"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetAttributesType"), com.spectralogic.escapepod.avidpamclient.soap.ws.GetAttributesType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetAttributesResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.GetAttributesResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetAttributesResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAttributesInternal");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetAttributesInternal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetAttributesInternalType"), com.spectralogic.escapepod.avidpamclient.soap.ws.GetAttributesInternalType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetAttributesInternalResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.GetAttributesInternalResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetAttributesInternalResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCategories");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetCategories"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetCategoriesType"), com.spectralogic.escapepod.avidpamclient.soap.ws.GetCategoriesType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetCategoriesResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.GetCategoriesResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetCategoriesResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetChildren");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetChildren"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetChildrenType"), com.spectralogic.escapepod.avidpamclient.soap.ws.GetChildrenType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetChildrenResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.GetChildrenResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetChildrenResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetFileDetails");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetFileDetails"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetFileDetailsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.GetFileDetailsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetFileDetailsResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.GetFileDetailsResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetFileDetailsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetHeadframe");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetHeadframe"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetHeadframeType"), com.spectralogic.escapepod.avidpamclient.soap.ws.GetHeadframeType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetHeadframeResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.GetHeadframeResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetHeadframeResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetLatest");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetLatest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetLatestType"), com.spectralogic.escapepod.avidpamclient.soap.ws.GetLatestType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetLatestResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.GetLatestResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetLatestResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetLocators");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetLocators"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetLocatorsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.GetLocatorsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetLocatorsResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.GetLocatorsResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetLocatorsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetUMIDLocators");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetUMIDLocators"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetLocatorsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.GetLocatorsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetUMIDLocatorsResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.GetUMIDLocatorsResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetUMIDLocatorsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetMetaSyncXML");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetMetaSyncXML"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetMetaSyncXMLType"), com.spectralogic.escapepod.avidpamclient.soap.ws.GetMetaSyncXMLType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetMetaSyncXMLResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.GetMetaSyncXMLResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetMetaSyncXMLResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetReservations");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetReservations"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetReservationsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.GetReservationsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetReservationsResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.GetReservationsResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetReservationsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetResolutions");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetResolutions"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetResolutionsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.GetResolutionsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetResolutionsResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.GetResolutionsResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetResolutionsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetRestrictions");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetRestrictions"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetRestrictionsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.GetRestrictionsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetRestrictionsResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.GetRestrictionsResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetRestrictionsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("LinkToMOB");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "LinkToMOB"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "LinkToMOBType"), com.spectralogic.escapepod.avidpamclient.soap.ws.LinkToMOBType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "LinkToMOBResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.LinkToMOBResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "LinkToMOBResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ModifyFolderACLs");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ModifyFolderACLs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ModifyFolderACLsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.ModifyFolderACLsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ModifyFolderACLsResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.ModifyFolderACLsResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ModifyFolderACLsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[29] = oper;

    }

    private static void _initOperationDesc4(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Move");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Move"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "MoveType"), com.spectralogic.escapepod.avidpamclient.soap.ws.MoveType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "MoveResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.MoveResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "MoveResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[30] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Rename");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Rename"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RenameType"), com.spectralogic.escapepod.avidpamclient.soap.ws.RenameType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RenameResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.RenameResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RenameResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[31] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RemoveLocators");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RemoveLocators"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RemoveLocatorsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveLocatorsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RemoveLocatorsResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveLocatorsResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RemoveLocatorsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[32] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RemoveUMIDLocators");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RemoveUMIDLocators"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RemoveUMIDLocatorsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveUMIDLocatorsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RemoveLocatorsResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveLocatorsResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RemoveUMIDLocatorsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[33] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RemoveReservations");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RemoveReservations"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RemoveReservationsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveReservationsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RemoveReservationsResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveReservationsResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RemoveReservationsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[34] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SaveLocators");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SaveLocators"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SaveLocatorsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.SaveLocatorsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SaveLocatorsResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.SaveLocatorsResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SaveLocatorsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[35] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SaveUMIDLocators");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SaveUMIDLocators"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SaveUMIDLocatorsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.SaveUMIDLocatorsType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SaveUMIDLocatorsResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.SaveUMIDLocatorsResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SaveUMIDLocatorsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[36] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Search");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Search"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SearchType"), com.spectralogic.escapepod.avidpamclient.soap.ws.SearchType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SearchResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.SearchResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SearchResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[37] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SetAttributes");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SetAttributes"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SetAttributesType"), com.spectralogic.escapepod.avidpamclient.soap.ws.SetAttributesType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SetAttributesResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.SetAttributesResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SetAttributesResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[38] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SetCategories");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SetCategories"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SetCategoriesType"), com.spectralogic.escapepod.avidpamclient.soap.ws.SetCategoriesType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SetCategoriesResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.SetCategoriesResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SetCategoriesResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[39] = oper;

    }

    private static void _initOperationDesc5(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SetHeadframe");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SetHeadframe"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SetHeadframeType"), com.spectralogic.escapepod.avidpamclient.soap.ws.SetHeadframeType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SetHeadframeResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.SetHeadframeResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SetHeadframeResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[40] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CreateShotlist");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateShotlist"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateShotlistType"), com.spectralogic.escapepod.avidpamclient.soap.ws.CreateShotlistType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateShotlistResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.CreateShotlistResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateShotlistResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[41] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CreateMasterClip");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateMasterClip"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateMasterClipType"), com.spectralogic.escapepod.avidpamclient.soap.ws.CreateMasterClipType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateMasterClipResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.CreateMasterClipResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateMasterClipResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[42] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCustomUserAttributes");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetCustomUserAttributes"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetCustomUserAttributesType"), com.spectralogic.escapepod.avidpamclient.soap.ws.GetCustomUserAttributesType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType"), com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class, true, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetCustomUserAttributesResponseType"));
        oper.setReturnClass(com.spectralogic.escapepod.avidpamclient.soap.ws.GetCustomUserAttributesResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetCustomUserAttributesResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetsFaultType"),
                      "com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType",
                      new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType"), 
                      true
                     ));
        _operations[43] = oper;

    }

    public AssetsPortBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public AssetsPortBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public AssetsPortBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
        addBindings0();
        addBindings1();
    }

    private void addBindings0() {
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
            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", ">AssetsFaultType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AddFileMobsResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.AddFileMobsResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AddFileMobsType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.AddFileMobsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AddReservationResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.AddReservationResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AddReservationType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.AddReservationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AddRestrictionsResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.AddRestrictionsResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AddRestrictionsType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.AddRestrictionsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetCategoriesListType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.AssetCategoriesType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetCategoriesType");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetCategories");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetCategoriesType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.AssetCategoriesType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

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

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CategoriesListType");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Category");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CategoryConditionType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.CategoryConditionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CheckInAAFResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInAAFResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CheckInAAFType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInAAFType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CheckInResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CheckInType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateFolderResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.CreateFolderResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateFoldersResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.CreateFoldersResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateFoldersType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.CreateFoldersType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateFolderType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.CreateFolderType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateMasterClipResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.CreateMasterClipResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateMasterClipType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.CreateMasterClipType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateShotlistResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.CreateShotlistResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateShotlistType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.CreateShotlistType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateSubclipResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.CreateSubclipResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateSubclipType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.CreateSubclipType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "DeleteAssetsResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.DeleteAssetsResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "DeleteAssetsType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.DeleteAssetsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "DuplicateResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.DuplicateResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "DuplicateType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.DuplicateType.class;
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

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FindLinksResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.FindLinksResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FindLinksType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.FindLinksType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FindRelativesResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.FindRelativesResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FindRelativesType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.FindRelativesType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FolderACLListType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.FolderACLType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FolderACLType");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Folder");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FolderACLType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.FolderACLType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetAttributesInternalResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetAttributesInternalResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetAttributesInternalType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetAttributesInternalType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetAttributesResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetAttributesResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetAttributesType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetAttributesType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetCategoriesResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetCategoriesResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetCategoriesType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetCategoriesType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetChildrenResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetChildrenResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetChildrenType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetChildrenType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetCustomUserAttributesResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetCustomUserAttributesResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetCustomUserAttributesType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetCustomUserAttributesType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetFileDetailsResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetFileDetailsResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetFileDetailsType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetFileDetailsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetHeadframeResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetHeadframeResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetHeadframeType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetHeadframeType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetLatestResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetLatestResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetLatestType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetLatestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetLocatorsResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetLocatorsResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetLocatorsType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetLocatorsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetMetaSyncXMLResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetMetaSyncXMLResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetMetaSyncXMLType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetMetaSyncXMLType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetReservationsResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetReservationsResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetReservationsType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetReservationsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetResolutionsResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetResolutionsResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetResolutionsType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetResolutionsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetRestrictionsResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetRestrictionsResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetRestrictionsType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetRestrictionsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetSegmentsFromCompositionResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetSegmentsFromCompositionResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetSegmentsFromCompositionType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetSegmentsFromCompositionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetStreamingURLResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetStreamingURLResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetStreamingURLType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetStreamingURLType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetUMIDLocatorsResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.GetUMIDLocatorsResponseType.class;
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

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "LinkToMOBResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.LinkToMOBResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "LinkToMOBType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.LinkToMOBType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "LocatorIDListType");
            cachedSerQNames.add(qName);
            cls = int[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "LocatorID");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "LocatorListType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.LocatorType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "LocatorType");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Locator");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "LocatorType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.LocatorType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "LocatorURIListType");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "LocatorURI");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "MediaDetailsListType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.MediaDetailsType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "MediaDetailsType");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "MediaDetails");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "MediaDetailsType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.MediaDetailsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ModifyFolderACLsResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.ModifyFolderACLsResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ModifyFolderACLsType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.ModifyFolderACLsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "MoveResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.MoveResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "MoveType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.MoveType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "NewMasterClipURLType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.NewMasterClipURLType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "PermissionListType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.PermissionType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "PermissionType");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Permission");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "PermissionType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.PermissionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RemoveLocatorsResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveLocatorsResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RemoveLocatorsType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveLocatorsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RemoveReservationsResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveReservationsResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RemoveReservationsType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveReservationsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RemoveUMIDLocatorsType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveUMIDLocatorsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }
    private void addBindings1() {
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
            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RenameResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.RenameResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RenameType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.RenameType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ReservationDetailsType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.ReservationDetailsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ReservationInformationType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.ReservationInformationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ReservationListType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.ReservationInformationType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ReservationInformationType");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ReservationInformation");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ResolutionConditionType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.ResolutionConditionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ResolutionDetailsListType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.ResolutionDetailsType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ResolutionDetailsType");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ResolutionDetails");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ResolutionDetailsType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.ResolutionDetailsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ResolutionListType");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Resolution");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RestrictionDetailsListType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.RestrictionDetailsType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RestrictionDetailsType");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RestrictionDetails");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RestrictionDetailsType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.RestrictionDetailsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RestrictionListType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.RestrictionType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RestrictionType");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Restriction");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RestrictionType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.RestrictionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SaveLocatorsResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.SaveLocatorsResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SaveLocatorsType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.SaveLocatorsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SaveUMIDLocatorsResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.SaveUMIDLocatorsResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SaveUMIDLocatorsType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.SaveUMIDLocatorsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SearchGroupType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.SearchGroupType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SearchResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.SearchResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SearchType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.SearchType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SegmentDescriptionListType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.SegmentDescriptionType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SegmentDescriptionType");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Segment");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SegmentDescriptionType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.SegmentDescriptionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SetAttributesResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.SetAttributesResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SetAttributesType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.SetAttributesType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SetCategoriesResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.SetCategoriesResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SetCategoriesType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.SetCategoriesType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SetHeadframeResponseType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.SetHeadframeResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SetHeadframeType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.SetHeadframeType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ShotlistElementListType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.ShotlistElementType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ShotlistElementType");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ShotlistElement");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ShotlistElementType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.ShotlistElementType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UMIDLocatorListType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.UMIDLocatorType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UMIDLocatorType");
            qName2 = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Locator");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UMIDLocatorType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.UMIDLocatorType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UserCredentialsType");
            cachedSerQNames.add(qName);
            cls = com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType.class;
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

    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetStreamingURLResponseType getStreamingURL(com.spectralogic.escapepod.avidpamclient.soap.ws.GetStreamingURLType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
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
        _call.setOperationName(new javax.xml.namespace.QName("", "GetStreamingURL"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetStreamingURLResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetStreamingURLResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.GetStreamingURLResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetSegmentsFromCompositionResponseType getSegmentsFromComposition(com.spectralogic.escapepod.avidpamclient.soap.ws.GetSegmentsFromCompositionType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
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
        _call.setOperationName(new javax.xml.namespace.QName("", "GetSegmentsFromComposition"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetSegmentsFromCompositionResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetSegmentsFromCompositionResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.GetSegmentsFromCompositionResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.AddReservationResponseType addReservation(com.spectralogic.escapepod.avidpamclient.soap.ws.AddReservationType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
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
        _call.setOperationName(new javax.xml.namespace.QName("", "AddReservation"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.AddReservationResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.AddReservationResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.AddReservationResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.AddRestrictionsResponseType addRestrictions(com.spectralogic.escapepod.avidpamclient.soap.ws.AddRestrictionsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
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
        _call.setOperationName(new javax.xml.namespace.QName("", "AddRestrictions"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.AddRestrictionsResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.AddRestrictionsResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.AddRestrictionsResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.AddFileMobsResponseType addFileMobs(com.spectralogic.escapepod.avidpamclient.soap.ws.AddFileMobsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
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
        _call.setOperationName(new javax.xml.namespace.QName("", "AddFileMobs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.AddFileMobsResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.AddFileMobsResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.AddFileMobsResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInAAFResponseType checkInAMAAAF(com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInAAFType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
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
        _call.setOperationName(new javax.xml.namespace.QName("", "CheckInAMAAAF"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInAAFResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInAAFResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInAAFResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInResponseType checkIn(com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
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
        _call.setOperationName(new javax.xml.namespace.QName("", "CheckIn"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInAAFResponseType checkInAAF(com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInAAFType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
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
        _call.setOperationName(new javax.xml.namespace.QName("", "CheckInAAF"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInAAFResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInAAFResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.CheckInAAFResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.CreateFolderResponseType createFolder(com.spectralogic.escapepod.avidpamclient.soap.ws.CreateFolderType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
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
        _call.setOperationName(new javax.xml.namespace.QName("", "CreateFolder"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.CreateFolderResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.CreateFolderResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.CreateFolderResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.CreateFoldersResponseType createFolders(com.spectralogic.escapepod.avidpamclient.soap.ws.CreateFoldersType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "CreateFolders"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.CreateFoldersResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.CreateFoldersResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.CreateFoldersResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.CreateSubclipResponseType createSubclip(com.spectralogic.escapepod.avidpamclient.soap.ws.CreateSubclipType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "CreateSubclip"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.CreateSubclipResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.CreateSubclipResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.CreateSubclipResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.DeleteAssetsResponseType deleteAssets(com.spectralogic.escapepod.avidpamclient.soap.ws.DeleteAssetsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "DeleteAssets"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.DeleteAssetsResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.DeleteAssetsResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.DeleteAssetsResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.DuplicateResponseType duplicate(com.spectralogic.escapepod.avidpamclient.soap.ws.DuplicateType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "Duplicate"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.DuplicateResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.DuplicateResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.DuplicateResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.FindLinksResponseType findLinks(com.spectralogic.escapepod.avidpamclient.soap.ws.FindLinksType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "FindLinks"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.FindLinksResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.FindLinksResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.FindLinksResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.FindRelativesResponseType findRelatives(com.spectralogic.escapepod.avidpamclient.soap.ws.FindRelativesType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "FindRelatives"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.FindRelativesResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.FindRelativesResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.FindRelativesResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetAttributesResponseType getAttributes(com.spectralogic.escapepod.avidpamclient.soap.ws.GetAttributesType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetAttributes"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetAttributesResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetAttributesResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.GetAttributesResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetAttributesInternalResponseType getAttributesInternal(com.spectralogic.escapepod.avidpamclient.soap.ws.GetAttributesInternalType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetAttributesInternal"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetAttributesInternalResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetAttributesInternalResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.GetAttributesInternalResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetCategoriesResponseType getCategories(com.spectralogic.escapepod.avidpamclient.soap.ws.GetCategoriesType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetCategories"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetCategoriesResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetCategoriesResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.GetCategoriesResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetChildrenResponseType getChildren(com.spectralogic.escapepod.avidpamclient.soap.ws.GetChildrenType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetChildren"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetChildrenResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetChildrenResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.GetChildrenResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetFileDetailsResponseType getFileDetails(com.spectralogic.escapepod.avidpamclient.soap.ws.GetFileDetailsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetFileDetails"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetFileDetailsResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetFileDetailsResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.GetFileDetailsResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetHeadframeResponseType getHeadframe(com.spectralogic.escapepod.avidpamclient.soap.ws.GetHeadframeType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetHeadframe"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetHeadframeResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetHeadframeResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.GetHeadframeResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetLatestResponseType getLatest(com.spectralogic.escapepod.avidpamclient.soap.ws.GetLatestType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetLatest"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetLatestResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetLatestResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.GetLatestResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetLocatorsResponseType getLocators(com.spectralogic.escapepod.avidpamclient.soap.ws.GetLocatorsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetLocators"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetLocatorsResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetLocatorsResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.GetLocatorsResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetUMIDLocatorsResponseType getUMIDLocators(com.spectralogic.escapepod.avidpamclient.soap.ws.GetLocatorsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetUMIDLocators"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetUMIDLocatorsResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetUMIDLocatorsResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.GetUMIDLocatorsResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetMetaSyncXMLResponseType getMetaSyncXML(com.spectralogic.escapepod.avidpamclient.soap.ws.GetMetaSyncXMLType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetMetaSyncXML"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetMetaSyncXMLResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetMetaSyncXMLResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.GetMetaSyncXMLResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetReservationsResponseType getReservations(com.spectralogic.escapepod.avidpamclient.soap.ws.GetReservationsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetReservations"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetReservationsResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetReservationsResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.GetReservationsResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetResolutionsResponseType getResolutions(com.spectralogic.escapepod.avidpamclient.soap.ws.GetResolutionsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetResolutions"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetResolutionsResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetResolutionsResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.GetResolutionsResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetRestrictionsResponseType getRestrictions(com.spectralogic.escapepod.avidpamclient.soap.ws.GetRestrictionsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetRestrictions"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetRestrictionsResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetRestrictionsResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.GetRestrictionsResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.LinkToMOBResponseType linkToMOB(com.spectralogic.escapepod.avidpamclient.soap.ws.LinkToMOBType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "LinkToMOB"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.LinkToMOBResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.LinkToMOBResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.LinkToMOBResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.ModifyFolderACLsResponseType modifyFolderACLs(com.spectralogic.escapepod.avidpamclient.soap.ws.ModifyFolderACLsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ModifyFolderACLs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.ModifyFolderACLsResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.ModifyFolderACLsResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.ModifyFolderACLsResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.MoveResponseType move(com.spectralogic.escapepod.avidpamclient.soap.ws.MoveType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "Move"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.MoveResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.MoveResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.MoveResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.RenameResponseType rename(com.spectralogic.escapepod.avidpamclient.soap.ws.RenameType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[31]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "Rename"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.RenameResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.RenameResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.RenameResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveLocatorsResponseType removeLocators(com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveLocatorsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[32]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "RemoveLocators"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveLocatorsResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveLocatorsResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveLocatorsResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveLocatorsResponseType removeUMIDLocators(com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveUMIDLocatorsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[33]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "RemoveUMIDLocators"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveLocatorsResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveLocatorsResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveLocatorsResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveReservationsResponseType removeReservations(com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveReservationsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[34]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "RemoveReservations"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveReservationsResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveReservationsResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.RemoveReservationsResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.SaveLocatorsResponseType saveLocators(com.spectralogic.escapepod.avidpamclient.soap.ws.SaveLocatorsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[35]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "SaveLocators"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.SaveLocatorsResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.SaveLocatorsResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.SaveLocatorsResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.SaveUMIDLocatorsResponseType saveUMIDLocators(com.spectralogic.escapepod.avidpamclient.soap.ws.SaveUMIDLocatorsType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[36]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "SaveUMIDLocators"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.SaveUMIDLocatorsResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.SaveUMIDLocatorsResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.SaveUMIDLocatorsResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.SearchResponseType search(com.spectralogic.escapepod.avidpamclient.soap.ws.SearchType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[37]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "Search"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.SearchResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.SearchResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.SearchResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.SetAttributesResponseType setAttributes(com.spectralogic.escapepod.avidpamclient.soap.ws.SetAttributesType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[38]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "SetAttributes"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.SetAttributesResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.SetAttributesResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.SetAttributesResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.SetCategoriesResponseType setCategories(com.spectralogic.escapepod.avidpamclient.soap.ws.SetCategoriesType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[39]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "SetCategories"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.SetCategoriesResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.SetCategoriesResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.SetCategoriesResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.SetHeadframeResponseType setHeadframe(com.spectralogic.escapepod.avidpamclient.soap.ws.SetHeadframeType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[40]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "SetHeadframe"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.SetHeadframeResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.SetHeadframeResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.SetHeadframeResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.CreateShotlistResponseType createShotlist(com.spectralogic.escapepod.avidpamclient.soap.ws.CreateShotlistType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[41]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "CreateShotlist"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.CreateShotlistResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.CreateShotlistResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.CreateShotlistResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.CreateMasterClipResponseType createMasterClip(com.spectralogic.escapepod.avidpamclient.soap.ws.CreateMasterClipType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[42]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "CreateMasterClip"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.CreateMasterClipResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.CreateMasterClipResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.CreateMasterClipResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.GetCustomUserAttributesResponseType getCustomUserAttributes(com.spectralogic.escapepod.avidpamclient.soap.ws.GetCustomUserAttributesType body, com.spectralogic.escapepod.avidpamclient.soap.ws.UserCredentialsType credentialsHeader) throws java.rmi.RemoteException, com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[43]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetCustomUserAttributes"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, credentialsHeader});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetCustomUserAttributesResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spectralogic.escapepod.avidpamclient.soap.ws.GetCustomUserAttributesResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.spectralogic.escapepod.avidpamclient.soap.ws.GetCustomUserAttributesResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) {
              throw (com.spectralogic.escapepod.avidpamclient.soap.ws.AssetsFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
