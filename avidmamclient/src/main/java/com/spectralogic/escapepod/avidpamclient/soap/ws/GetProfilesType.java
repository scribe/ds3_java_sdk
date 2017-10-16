/**
 * GetProfilesType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;


/**
 * The parameters for the GetProfiles operation. The WorkgroupURI
 * represents the workgroup to query the
 *         Media Services Engine on. Services is a list of services to
 * get profiles for (ex. com.avid.dms.archive).
 *         If ShowParameters is true, a list of name/value parameters
 * defining the profile will also be returned.
 */
public class GetProfilesType  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType {
    private java.lang.String workgroupURI;

    private java.lang.String[] services;

    private java.lang.Boolean showParameters;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension;

    private org.apache.axis.message.MessageElement [] _any;

    public GetProfilesType() {
    }

    public GetProfilesType(
           java.lang.String workgroupURI,
           java.lang.String[] services,
           java.lang.Boolean showParameters,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension,
           org.apache.axis.message.MessageElement [] _any) {
           this.workgroupURI = workgroupURI;
           this.services = services;
           this.showParameters = showParameters;
           this.extension = extension;
           this._any = _any;
    }


    /**
     * Gets the workgroupURI value for this GetProfilesType.
     * 
     * @return workgroupURI
     */
    public java.lang.String getWorkgroupURI() {
        return workgroupURI;
    }


    /**
     * Sets the workgroupURI value for this GetProfilesType.
     * 
     * @param workgroupURI
     */
    public void setWorkgroupURI(java.lang.String workgroupURI) {
        this.workgroupURI = workgroupURI;
    }


    /**
     * Gets the services value for this GetProfilesType.
     * 
     * @return services
     */
    public java.lang.String[] getServices() {
        return services;
    }


    /**
     * Sets the services value for this GetProfilesType.
     * 
     * @param services
     */
    public void setServices(java.lang.String[] services) {
        this.services = services;
    }


    /**
     * Gets the showParameters value for this GetProfilesType.
     * 
     * @return showParameters
     */
    public java.lang.Boolean getShowParameters() {
        return showParameters;
    }


    /**
     * Sets the showParameters value for this GetProfilesType.
     * 
     * @param showParameters
     */
    public void setShowParameters(java.lang.Boolean showParameters) {
        this.showParameters = showParameters;
    }


    /**
     * Gets the extension value for this GetProfilesType.
     * 
     * @return extension
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this GetProfilesType.
     * 
     * @param extension
     */
    public void setExtension(com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension) {
        this.extension = extension;
    }


    /**
     * Gets the _any value for this GetProfilesType.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this GetProfilesType.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetProfilesType)) return false;
        GetProfilesType other = (GetProfilesType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.workgroupURI==null && other.getWorkgroupURI()==null) || 
             (this.workgroupURI!=null &&
              this.workgroupURI.equals(other.getWorkgroupURI()))) &&
            ((this.services==null && other.getServices()==null) || 
             (this.services!=null &&
              java.util.Arrays.equals(this.services, other.getServices()))) &&
            ((this.showParameters==null && other.getShowParameters()==null) || 
             (this.showParameters!=null &&
              this.showParameters.equals(other.getShowParameters()))) &&
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
        if (getWorkgroupURI() != null) {
            _hashCode += getWorkgroupURI().hashCode();
        }
        if (getServices() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getServices());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getServices(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getShowParameters() != null) {
            _hashCode += getShowParameters().hashCode();
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
        new org.apache.axis.description.TypeDesc(GetProfilesType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "GetProfilesType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workgroupURI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "WorkgroupURI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("services");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "Services"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "Name"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("showParameters");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/jobs/types", "ShowParameters"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
