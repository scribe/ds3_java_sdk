/**
 * CheckInAAFType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;


/**
 * Parameters for the CheckInAAF operation. If InterplayURI is a path,
 * the Avid AAF file will be
 *         added to the Interplay system. If InterplayURI is a valid
 * moniker or MOBID, the corresponding asset will be
 *         updated with the Avid AAF file. A Headframe file and a set
 * of Attributes to be stored can also be optionally
 *         specified. The Headframe must be a JPEG, GIF, PNG, or BMP
 * image. It will be converted and resized to a 400x300
 *         JPEG.
 */
public class CheckInAAFType  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType {
    private java.lang.String interplayURI;

    private byte[] AAF;

    private byte[] headframe;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[] attributes;

    private java.lang.Boolean overrideUserProp;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension;

    private org.apache.axis.message.MessageElement [] _any;

    public CheckInAAFType() {
    }

    public CheckInAAFType(
           java.lang.String interplayURI,
           byte[] AAF,
           byte[] headframe,
           com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[] attributes,
           java.lang.Boolean overrideUserProp,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension,
           org.apache.axis.message.MessageElement [] _any) {
           this.interplayURI = interplayURI;
           this.AAF = AAF;
           this.headframe = headframe;
           this.attributes = attributes;
           this.overrideUserProp = overrideUserProp;
           this.extension = extension;
           this._any = _any;
    }


    /**
     * Gets the interplayURI value for this CheckInAAFType.
     * 
     * @return interplayURI
     */
    public java.lang.String getInterplayURI() {
        return interplayURI;
    }


    /**
     * Sets the interplayURI value for this CheckInAAFType.
     * 
     * @param interplayURI
     */
    public void setInterplayURI(java.lang.String interplayURI) {
        this.interplayURI = interplayURI;
    }


    /**
     * Gets the AAF value for this CheckInAAFType.
     * 
     * @return AAF
     */
    public byte[] getAAF() {
        return AAF;
    }


    /**
     * Sets the AAF value for this CheckInAAFType.
     * 
     * @param AAF
     */
    public void setAAF(byte[] AAF) {
        this.AAF = AAF;
    }


    /**
     * Gets the headframe value for this CheckInAAFType.
     * 
     * @return headframe
     */
    public byte[] getHeadframe() {
        return headframe;
    }


    /**
     * Sets the headframe value for this CheckInAAFType.
     * 
     * @param headframe
     */
    public void setHeadframe(byte[] headframe) {
        this.headframe = headframe;
    }


    /**
     * Gets the attributes value for this CheckInAAFType.
     * 
     * @return attributes
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[] getAttributes() {
        return attributes;
    }


    /**
     * Sets the attributes value for this CheckInAAFType.
     * 
     * @param attributes
     */
    public void setAttributes(com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[] attributes) {
        this.attributes = attributes;
    }


    /**
     * Gets the overrideUserProp value for this CheckInAAFType.
     * 
     * @return overrideUserProp
     */
    public java.lang.Boolean getOverrideUserProp() {
        return overrideUserProp;
    }


    /**
     * Sets the overrideUserProp value for this CheckInAAFType.
     * 
     * @param overrideUserProp
     */
    public void setOverrideUserProp(java.lang.Boolean overrideUserProp) {
        this.overrideUserProp = overrideUserProp;
    }


    /**
     * Gets the extension value for this CheckInAAFType.
     * 
     * @return extension
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this CheckInAAFType.
     * 
     * @param extension
     */
    public void setExtension(com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension) {
        this.extension = extension;
    }


    /**
     * Gets the _any value for this CheckInAAFType.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this CheckInAAFType.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CheckInAAFType)) return false;
        CheckInAAFType other = (CheckInAAFType) obj;
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
            ((this.AAF==null && other.getAAF()==null) || 
             (this.AAF!=null &&
              java.util.Arrays.equals(this.AAF, other.getAAF()))) &&
            ((this.headframe==null && other.getHeadframe()==null) || 
             (this.headframe!=null &&
              java.util.Arrays.equals(this.headframe, other.getHeadframe()))) &&
            ((this.attributes==null && other.getAttributes()==null) || 
             (this.attributes!=null &&
              java.util.Arrays.equals(this.attributes, other.getAttributes()))) &&
            ((this.overrideUserProp==null && other.getOverrideUserProp()==null) || 
             (this.overrideUserProp!=null &&
              this.overrideUserProp.equals(other.getOverrideUserProp()))) &&
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
        if (getAAF() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAAF());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAAF(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getHeadframe() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getHeadframe());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getHeadframe(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAttributes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAttributes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAttributes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOverrideUserProp() != null) {
            _hashCode += getOverrideUserProp().hashCode();
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
        new org.apache.axis.description.TypeDesc(CheckInAAFType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CheckInAAFType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interplayURI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "InterplayURI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAF");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AAF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("headframe");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Headframe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attributes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Attributes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AttributeType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Attribute"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("overrideUserProp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "OverrideUserProp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
