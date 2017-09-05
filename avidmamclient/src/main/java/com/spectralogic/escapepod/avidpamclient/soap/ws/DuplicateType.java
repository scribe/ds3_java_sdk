/**
 * DuplicateType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;


/**
 * Parameters for the Duplicate operation. InterplayAssetURI must
 * reference the asset that you
 *         wish to duplicate. InterplayFolderURI references the folder
 * to create the duplicate in.
 */
public class DuplicateType  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType {
    private java.lang.String interplayAssetURI;

    private java.lang.String interplayFolderURI;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[] attributes;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension;

    private org.apache.axis.message.MessageElement [] _any;

    public DuplicateType() {
    }

    public DuplicateType(
           java.lang.String interplayAssetURI,
           java.lang.String interplayFolderURI,
           com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[] attributes,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension,
           org.apache.axis.message.MessageElement [] _any) {
           this.interplayAssetURI = interplayAssetURI;
           this.interplayFolderURI = interplayFolderURI;
           this.attributes = attributes;
           this.extension = extension;
           this._any = _any;
    }


    /**
     * Gets the interplayAssetURI value for this DuplicateType.
     * 
     * @return interplayAssetURI
     */
    public java.lang.String getInterplayAssetURI() {
        return interplayAssetURI;
    }


    /**
     * Sets the interplayAssetURI value for this DuplicateType.
     * 
     * @param interplayAssetURI
     */
    public void setInterplayAssetURI(java.lang.String interplayAssetURI) {
        this.interplayAssetURI = interplayAssetURI;
    }


    /**
     * Gets the interplayFolderURI value for this DuplicateType.
     * 
     * @return interplayFolderURI
     */
    public java.lang.String getInterplayFolderURI() {
        return interplayFolderURI;
    }


    /**
     * Sets the interplayFolderURI value for this DuplicateType.
     * 
     * @param interplayFolderURI
     */
    public void setInterplayFolderURI(java.lang.String interplayFolderURI) {
        this.interplayFolderURI = interplayFolderURI;
    }


    /**
     * Gets the attributes value for this DuplicateType.
     * 
     * @return attributes
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[] getAttributes() {
        return attributes;
    }


    /**
     * Sets the attributes value for this DuplicateType.
     * 
     * @param attributes
     */
    public void setAttributes(com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[] attributes) {
        this.attributes = attributes;
    }


    /**
     * Gets the extension value for this DuplicateType.
     * 
     * @return extension
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this DuplicateType.
     * 
     * @param extension
     */
    public void setExtension(com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension) {
        this.extension = extension;
    }


    /**
     * Gets the _any value for this DuplicateType.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this DuplicateType.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DuplicateType)) return false;
        DuplicateType other = (DuplicateType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.interplayAssetURI==null && other.getInterplayAssetURI()==null) || 
             (this.interplayAssetURI!=null &&
              this.interplayAssetURI.equals(other.getInterplayAssetURI()))) &&
            ((this.interplayFolderURI==null && other.getInterplayFolderURI()==null) || 
             (this.interplayFolderURI!=null &&
              this.interplayFolderURI.equals(other.getInterplayFolderURI()))) &&
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
        if (getInterplayAssetURI() != null) {
            _hashCode += getInterplayAssetURI().hashCode();
        }
        if (getInterplayFolderURI() != null) {
            _hashCode += getInterplayFolderURI().hashCode();
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
        new org.apache.axis.description.TypeDesc(DuplicateType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "DuplicateType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interplayAssetURI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "InterplayAssetURI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interplayFolderURI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "InterplayFolderURI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
