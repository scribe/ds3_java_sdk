/**
 * SubmitJobUsingParametersType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;


/**
 * The parameters for the SubmitJobUsingParameters operation. Service
 * represents the service to submit to
 *         (ex., com.avid.dms.archive). InterplayURI references the asset
 * to perform the service on. Parameters
 *         is the list of name/value parameters that define the job.
 * SourceServerType determines the source server
 *         for the asset. Valid values are "Archive" and "Assets" (default).
 */
public class SubmitJobUsingParametersType  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType {
    private java.lang.String service;

    private java.lang.String interplayURI;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ParameterType[] parameters;

    private java.lang.String sourceServerType;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension;

    private org.apache.axis.message.MessageElement [] _any;

    public SubmitJobUsingParametersType() {
    }

    public SubmitJobUsingParametersType(
           java.lang.String service,
           java.lang.String interplayURI,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ParameterType[] parameters,
           java.lang.String sourceServerType,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension,
           org.apache.axis.message.MessageElement [] _any) {
           this.service = service;
           this.interplayURI = interplayURI;
           this.parameters = parameters;
           this.sourceServerType = sourceServerType;
           this.extension = extension;
           this._any = _any;
    }


    /**
     * Gets the service value for this SubmitJobUsingParametersType.
     * 
     * @return service
     */
    public java.lang.String getService() {
        return service;
    }


    /**
     * Sets the service value for this SubmitJobUsingParametersType.
     * 
     * @param service
     */
    public void setService(java.lang.String service) {
        this.service = service;
    }


    /**
     * Gets the interplayURI value for this SubmitJobUsingParametersType.
     * 
     * @return interplayURI
     */
    public java.lang.String getInterplayURI() {
        return interplayURI;
    }


    /**
     * Sets the interplayURI value for this SubmitJobUsingParametersType.
     * 
     * @param interplayURI
     */
    public void setInterplayURI(java.lang.String interplayURI) {
        this.interplayURI = interplayURI;
    }


    /**
     * Gets the parameters value for this SubmitJobUsingParametersType.
     * 
     * @return parameters
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ParameterType[] getParameters() {
        return parameters;
    }


    /**
     * Sets the parameters value for this SubmitJobUsingParametersType.
     * 
     * @param parameters
     */
    public void setParameters(com.spectralogic.escapepod.avidpamclient.soap.ws.ParameterType[] parameters) {
        this.parameters = parameters;
    }


    /**
     * Gets the sourceServerType value for this SubmitJobUsingParametersType.
     * 
     * @return sourceServerType
     */
    public java.lang.String getSourceServerType() {
        return sourceServerType;
    }


    /**
     * Sets the sourceServerType value for this SubmitJobUsingParametersType.
     * 
     * @param sourceServerType
     */
    public void setSourceServerType(java.lang.String sourceServerType) {
        this.sourceServerType = sourceServerType;
    }


    /**
     * Gets the extension value for this SubmitJobUsingParametersType.
     * 
     * @return extension
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this SubmitJobUsingParametersType.
     * 
     * @param extension
     */
    public void setExtension(com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension) {
        this.extension = extension;
    }


    /**
     * Gets the _any value for this SubmitJobUsingParametersType.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this SubmitJobUsingParametersType.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SubmitJobUsingParametersType)) return false;
        SubmitJobUsingParametersType other = (SubmitJobUsingParametersType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.service==null && other.getService()==null) || 
             (this.service!=null &&
              this.service.equals(other.getService()))) &&
            ((this.interplayURI==null && other.getInterplayURI()==null) || 
             (this.interplayURI!=null &&
              this.interplayURI.equals(other.getInterplayURI()))) &&
            ((this.parameters==null && other.getParameters()==null) || 
             (this.parameters!=null &&
              java.util.Arrays.equals(this.parameters, other.getParameters()))) &&
            ((this.sourceServerType==null && other.getSourceServerType()==null) || 
             (this.sourceServerType!=null &&
              this.sourceServerType.equals(other.getSourceServerType()))) &&
            ((this.extension==null && other.getExtension()==null) || 
             (this.extension!=null &&
              this.extension.equals(other.getExtension()))) &&
            ((this._any==null && other.get_any()==null) || 
             (this._any!=null &&
              java.util.Arrays.equals(this._any, other.get_any())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getService() != null) {
            _hashCode += getService().hashCode();
        }
        if (getInterplayURI() != null) {
            _hashCode += getInterplayURI().hashCode();
        }
        if (getParameters() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getParameters());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getParameters(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSourceServerType() != null) {
            _hashCode += getSourceServerType().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        if (get_any() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(get_any());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(get_any(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SubmitJobUsingParametersType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "SubmitJobUsingParametersType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("service");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "Service"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interplayURI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "InterplayURI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parameters");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "Parameters"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "ParameterType"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "Parameter"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sourceServerType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "SourceServerType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extension");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "Extension"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ExtensionType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
