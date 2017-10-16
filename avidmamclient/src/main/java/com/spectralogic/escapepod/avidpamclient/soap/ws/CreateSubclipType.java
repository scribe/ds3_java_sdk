/**
 * CreateSubclipType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;


/**
 * Parameters for the CreateSubclip operation. The MasterclipURI references
 * the Masterclip that
 *         the subclip is based on. The SubclipPathURI is a path-based
 * URI that represents where the subclip should be
 *         checked in. The Name represents the name of the subclip to
 * check in. StartingOffset or StartingTimecode as well
 *         as Length are used determine the range of the Masterclip that
 * the subclip covers. A Headframe and/or a set of
 *         Attributes can be optionally passed in. The Headframe must
 * be a JPEG, GIF, PNG, or BMP image. It will be
 *         converted and resized to a 400x300 JPEG.
 */
public class CreateSubclipType  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType {
    private java.lang.String masterclipURI;

    private java.lang.String subclipPathURI;

    private java.lang.String name;

    private java.lang.Long startingOffset;

    private java.lang.String startingTimecode;

    private long length;

    private byte[] headframe;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[] attributes;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension;

    private org.apache.axis.message.MessageElement [] _any;

    public CreateSubclipType() {
    }

    public CreateSubclipType(
           java.lang.String masterclipURI,
           java.lang.String subclipPathURI,
           java.lang.String name,
           java.lang.Long startingOffset,
           java.lang.String startingTimecode,
           long length,
           byte[] headframe,
           com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[] attributes,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension,
           org.apache.axis.message.MessageElement [] _any) {
           this.masterclipURI = masterclipURI;
           this.subclipPathURI = subclipPathURI;
           this.name = name;
           this.startingOffset = startingOffset;
           this.startingTimecode = startingTimecode;
           this.length = length;
           this.headframe = headframe;
           this.attributes = attributes;
           this.extension = extension;
           this._any = _any;
    }


    /**
     * Gets the masterclipURI value for this CreateSubclipType.
     * 
     * @return masterclipURI
     */
    public java.lang.String getMasterclipURI() {
        return masterclipURI;
    }


    /**
     * Sets the masterclipURI value for this CreateSubclipType.
     * 
     * @param masterclipURI
     */
    public void setMasterclipURI(java.lang.String masterclipURI) {
        this.masterclipURI = masterclipURI;
    }


    /**
     * Gets the subclipPathURI value for this CreateSubclipType.
     * 
     * @return subclipPathURI
     */
    public java.lang.String getSubclipPathURI() {
        return subclipPathURI;
    }


    /**
     * Sets the subclipPathURI value for this CreateSubclipType.
     * 
     * @param subclipPathURI
     */
    public void setSubclipPathURI(java.lang.String subclipPathURI) {
        this.subclipPathURI = subclipPathURI;
    }


    /**
     * Gets the name value for this CreateSubclipType.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this CreateSubclipType.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the startingOffset value for this CreateSubclipType.
     * 
     * @return startingOffset
     */
    public java.lang.Long getStartingOffset() {
        return startingOffset;
    }


    /**
     * Sets the startingOffset value for this CreateSubclipType.
     * 
     * @param startingOffset
     */
    public void setStartingOffset(java.lang.Long startingOffset) {
        this.startingOffset = startingOffset;
    }


    /**
     * Gets the startingTimecode value for this CreateSubclipType.
     * 
     * @return startingTimecode
     */
    public java.lang.String getStartingTimecode() {
        return startingTimecode;
    }


    /**
     * Sets the startingTimecode value for this CreateSubclipType.
     * 
     * @param startingTimecode
     */
    public void setStartingTimecode(java.lang.String startingTimecode) {
        this.startingTimecode = startingTimecode;
    }


    /**
     * Gets the length value for this CreateSubclipType.
     * 
     * @return length
     */
    public long getLength() {
        return length;
    }


    /**
     * Sets the length value for this CreateSubclipType.
     * 
     * @param length
     */
    public void setLength(long length) {
        this.length = length;
    }


    /**
     * Gets the headframe value for this CreateSubclipType.
     * 
     * @return headframe
     */
    public byte[] getHeadframe() {
        return headframe;
    }


    /**
     * Sets the headframe value for this CreateSubclipType.
     * 
     * @param headframe
     */
    public void setHeadframe(byte[] headframe) {
        this.headframe = headframe;
    }


    /**
     * Gets the attributes value for this CreateSubclipType.
     * 
     * @return attributes
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[] getAttributes() {
        return attributes;
    }


    /**
     * Sets the attributes value for this CreateSubclipType.
     * 
     * @param attributes
     */
    public void setAttributes(com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[] attributes) {
        this.attributes = attributes;
    }


    /**
     * Gets the extension value for this CreateSubclipType.
     * 
     * @return extension
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this CreateSubclipType.
     * 
     * @param extension
     */
    public void setExtension(com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension) {
        this.extension = extension;
    }


    /**
     * Gets the _any value for this CreateSubclipType.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this CreateSubclipType.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CreateSubclipType)) return false;
        CreateSubclipType other = (CreateSubclipType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.masterclipURI==null && other.getMasterclipURI()==null) || 
             (this.masterclipURI!=null &&
              this.masterclipURI.equals(other.getMasterclipURI()))) &&
            ((this.subclipPathURI==null && other.getSubclipPathURI()==null) || 
             (this.subclipPathURI!=null &&
              this.subclipPathURI.equals(other.getSubclipPathURI()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.startingOffset==null && other.getStartingOffset()==null) || 
             (this.startingOffset!=null &&
              this.startingOffset.equals(other.getStartingOffset()))) &&
            ((this.startingTimecode==null && other.getStartingTimecode()==null) || 
             (this.startingTimecode!=null &&
              this.startingTimecode.equals(other.getStartingTimecode()))) &&
            this.length == other.getLength() &&
            ((this.headframe==null && other.getHeadframe()==null) || 
             (this.headframe!=null &&
              java.util.Arrays.equals(this.headframe, other.getHeadframe()))) &&
            ((this.attributes==null && other.getAttributes()==null) || 
             (this.attributes!=null &&
              java.util.Arrays.equals(this.attributes, other.getAttributes()))) &&
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
        if (getMasterclipURI() != null) {
            _hashCode += getMasterclipURI().hashCode();
        }
        if (getSubclipPathURI() != null) {
            _hashCode += getSubclipPathURI().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getStartingOffset() != null) {
            _hashCode += getStartingOffset().hashCode();
        }
        if (getStartingTimecode() != null) {
            _hashCode += getStartingTimecode().hashCode();
        }
        _hashCode += new Long(getLength()).hashCode();
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
        new org.apache.axis.description.TypeDesc(CreateSubclipType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateSubclipType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("masterclipURI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "MasterclipURI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subclipPathURI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SubclipPathURI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startingOffset");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "StartingOffset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startingTimecode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "StartingTimecode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("length");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Length"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
