/**
 * GetMetaSyncXMLType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;


/**
 * Parameters for the GetMetaSyncXML operation. InterplayURI must
 * reference a valid Avid asset.
 *         EnhancementType, EnhancementSubType, and TrackName all allow
 * the returned data to be filtered
 *         on specific criteria.
 */
public class GetMetaSyncXMLType  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType {
    private java.lang.String interplayURI;

    private java.lang.String enhancementType;

    private java.lang.String enhancementSubType;

    private java.lang.String trackName;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension;

    private org.apache.axis.message.MessageElement [] _any;

    public GetMetaSyncXMLType() {
    }

    public GetMetaSyncXMLType(
           java.lang.String interplayURI,
           java.lang.String enhancementType,
           java.lang.String enhancementSubType,
           java.lang.String trackName,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension,
           org.apache.axis.message.MessageElement [] _any) {
           this.interplayURI = interplayURI;
           this.enhancementType = enhancementType;
           this.enhancementSubType = enhancementSubType;
           this.trackName = trackName;
           this.extension = extension;
           this._any = _any;
    }


    /**
     * Gets the interplayURI value for this GetMetaSyncXMLType.
     * 
     * @return interplayURI
     */
    public java.lang.String getInterplayURI() {
        return interplayURI;
    }


    /**
     * Sets the interplayURI value for this GetMetaSyncXMLType.
     * 
     * @param interplayURI
     */
    public void setInterplayURI(java.lang.String interplayURI) {
        this.interplayURI = interplayURI;
    }


    /**
     * Gets the enhancementType value for this GetMetaSyncXMLType.
     * 
     * @return enhancementType
     */
    public java.lang.String getEnhancementType() {
        return enhancementType;
    }


    /**
     * Sets the enhancementType value for this GetMetaSyncXMLType.
     * 
     * @param enhancementType
     */
    public void setEnhancementType(java.lang.String enhancementType) {
        this.enhancementType = enhancementType;
    }


    /**
     * Gets the enhancementSubType value for this GetMetaSyncXMLType.
     * 
     * @return enhancementSubType
     */
    public java.lang.String getEnhancementSubType() {
        return enhancementSubType;
    }


    /**
     * Sets the enhancementSubType value for this GetMetaSyncXMLType.
     * 
     * @param enhancementSubType
     */
    public void setEnhancementSubType(java.lang.String enhancementSubType) {
        this.enhancementSubType = enhancementSubType;
    }


    /**
     * Gets the trackName value for this GetMetaSyncXMLType.
     * 
     * @return trackName
     */
    public java.lang.String getTrackName() {
        return trackName;
    }


    /**
     * Sets the trackName value for this GetMetaSyncXMLType.
     * 
     * @param trackName
     */
    public void setTrackName(java.lang.String trackName) {
        this.trackName = trackName;
    }


    /**
     * Gets the extension value for this GetMetaSyncXMLType.
     * 
     * @return extension
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this GetMetaSyncXMLType.
     * 
     * @param extension
     */
    public void setExtension(com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension) {
        this.extension = extension;
    }


    /**
     * Gets the _any value for this GetMetaSyncXMLType.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this GetMetaSyncXMLType.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetMetaSyncXMLType)) return false;
        GetMetaSyncXMLType other = (GetMetaSyncXMLType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.interplayURI==null && other.getInterplayURI()==null) || 
             (this.interplayURI!=null &&
              this.interplayURI.equals(other.getInterplayURI()))) &&
            ((this.enhancementType==null && other.getEnhancementType()==null) || 
             (this.enhancementType!=null &&
              this.enhancementType.equals(other.getEnhancementType()))) &&
            ((this.enhancementSubType==null && other.getEnhancementSubType()==null) || 
             (this.enhancementSubType!=null &&
              this.enhancementSubType.equals(other.getEnhancementSubType()))) &&
            ((this.trackName==null && other.getTrackName()==null) || 
             (this.trackName!=null &&
              this.trackName.equals(other.getTrackName()))) &&
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
        if (getInterplayURI() != null) {
            _hashCode += getInterplayURI().hashCode();
        }
        if (getEnhancementType() != null) {
            _hashCode += getEnhancementType().hashCode();
        }
        if (getEnhancementSubType() != null) {
            _hashCode += getEnhancementSubType().hashCode();
        }
        if (getTrackName() != null) {
            _hashCode += getTrackName().hashCode();
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
        new org.apache.axis.description.TypeDesc(GetMetaSyncXMLType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetMetaSyncXMLType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interplayURI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "InterplayURI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enhancementType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "EnhancementType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enhancementSubType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "EnhancementSubType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trackName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "TrackName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extension");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Extension"));
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
