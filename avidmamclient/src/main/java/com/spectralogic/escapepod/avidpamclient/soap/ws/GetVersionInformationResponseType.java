/**
 * GetVersionInformationResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;


/**
 * The response from the GetVersionInformation operation. Errors contains
 * a list of errors that
 *         occurred. If there are no errors, the Errors element is omitted
 * entirely. If the operation is successful, the
 *         version of Interplay Web Services will be returned along with
 * one or more versions of configured Interplay
 *         Engines and Archive Engines.
 */
public class GetVersionInformationResponseType  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType {
    private com.spectralogic.escapepod.avidpamclient.soap.ws.ErrorType[] errors;

    private java.lang.String interplayWebServicesVersion;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.WorkGroupDetailsType[] workgroups;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension;

    private org.apache.axis.message.MessageElement [] _any;

    public GetVersionInformationResponseType() {
    }

    public GetVersionInformationResponseType(
           com.spectralogic.escapepod.avidpamclient.soap.ws.ErrorType[] errors,
           java.lang.String interplayWebServicesVersion,
           com.spectralogic.escapepod.avidpamclient.soap.ws.WorkGroupDetailsType[] workgroups,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension,
           org.apache.axis.message.MessageElement [] _any) {
           this.errors = errors;
           this.interplayWebServicesVersion = interplayWebServicesVersion;
           this.workgroups = workgroups;
           this.extension = extension;
           this._any = _any;
    }


    /**
     * Gets the errors value for this GetVersionInformationResponseType.
     * 
     * @return errors
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ErrorType[] getErrors() {
        return errors;
    }


    /**
     * Sets the errors value for this GetVersionInformationResponseType.
     * 
     * @param errors
     */
    public void setErrors(com.spectralogic.escapepod.avidpamclient.soap.ws.ErrorType[] errors) {
        this.errors = errors;
    }


    /**
     * Gets the interplayWebServicesVersion value for this GetVersionInformationResponseType.
     * 
     * @return interplayWebServicesVersion
     */
    public java.lang.String getInterplayWebServicesVersion() {
        return interplayWebServicesVersion;
    }


    /**
     * Sets the interplayWebServicesVersion value for this GetVersionInformationResponseType.
     * 
     * @param interplayWebServicesVersion
     */
    public void setInterplayWebServicesVersion(java.lang.String interplayWebServicesVersion) {
        this.interplayWebServicesVersion = interplayWebServicesVersion;
    }


    /**
     * Gets the workgroups value for this GetVersionInformationResponseType.
     * 
     * @return workgroups
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.WorkGroupDetailsType[] getWorkgroups() {
        return workgroups;
    }


    /**
     * Sets the workgroups value for this GetVersionInformationResponseType.
     * 
     * @param workgroups
     */
    public void setWorkgroups(com.spectralogic.escapepod.avidpamclient.soap.ws.WorkGroupDetailsType[] workgroups) {
        this.workgroups = workgroups;
    }


    /**
     * Gets the extension value for this GetVersionInformationResponseType.
     * 
     * @return extension
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this GetVersionInformationResponseType.
     * 
     * @param extension
     */
    public void setExtension(com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension) {
        this.extension = extension;
    }


    /**
     * Gets the _any value for this GetVersionInformationResponseType.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this GetVersionInformationResponseType.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetVersionInformationResponseType)) return false;
        GetVersionInformationResponseType other = (GetVersionInformationResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.errors==null && other.getErrors()==null) || 
             (this.errors!=null &&
              java.util.Arrays.equals(this.errors, other.getErrors()))) &&
            ((this.interplayWebServicesVersion==null && other.getInterplayWebServicesVersion()==null) || 
             (this.interplayWebServicesVersion!=null &&
              this.interplayWebServicesVersion.equals(other.getInterplayWebServicesVersion()))) &&
            ((this.workgroups==null && other.getWorkgroups()==null) || 
             (this.workgroups!=null &&
              java.util.Arrays.equals(this.workgroups, other.getWorkgroups()))) &&
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
        if (getErrors() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getErrors());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getErrors(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getInterplayWebServicesVersion() != null) {
            _hashCode += getInterplayWebServicesVersion().hashCode();
        }
        if (getWorkgroups() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getWorkgroups());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getWorkgroups(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        new org.apache.axis.description.TypeDesc(GetVersionInformationResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "GetVersionInformationResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errors");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "Errors"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ErrorType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Error"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interplayWebServicesVersion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "InterplayWebServicesVersion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workgroups");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "Workgroups"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "WorkGroupDetailsType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "Workgroup"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extension");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "Extension"));
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
