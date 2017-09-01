/**
 * CreateShotlistType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;


/**
 * Parameters for the CreateShotlist operation. The DestinationFolderURI
 * indicates where the shotlist should
 *         be checked in. StartTimecode indicates starting timecode of
 * the shotlist. ShotlistElements is a list
 *         of ShotListElementTypes making up the shotlist. Attributes
 * and Locators optionally set additional metadata
 *         on the shotlist.
 */
public class CreateShotlistType  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType {
    private java.lang.String destinationFolderURI;

    private java.lang.String shotlistName;

    private java.lang.String startTimecode;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ShotlistElementType[] shotlistElements;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[] attributes;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.UMIDLocatorType[] locators;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension;

    private org.apache.axis.message.MessageElement [] _any;

    public CreateShotlistType() {
    }

    public CreateShotlistType(
           java.lang.String destinationFolderURI,
           java.lang.String shotlistName,
           java.lang.String startTimecode,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ShotlistElementType[] shotlistElements,
           com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[] attributes,
           com.spectralogic.escapepod.avidpamclient.soap.ws.UMIDLocatorType[] locators,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension,
           org.apache.axis.message.MessageElement [] _any) {
           this.destinationFolderURI = destinationFolderURI;
           this.shotlistName = shotlistName;
           this.startTimecode = startTimecode;
           this.shotlistElements = shotlistElements;
           this.attributes = attributes;
           this.locators = locators;
           this.extension = extension;
           this._any = _any;
    }


    /**
     * Gets the destinationFolderURI value for this CreateShotlistType.
     * 
     * @return destinationFolderURI
     */
    public java.lang.String getDestinationFolderURI() {
        return destinationFolderURI;
    }


    /**
     * Sets the destinationFolderURI value for this CreateShotlistType.
     * 
     * @param destinationFolderURI
     */
    public void setDestinationFolderURI(java.lang.String destinationFolderURI) {
        this.destinationFolderURI = destinationFolderURI;
    }


    /**
     * Gets the shotlistName value for this CreateShotlistType.
     * 
     * @return shotlistName
     */
    public java.lang.String getShotlistName() {
        return shotlistName;
    }


    /**
     * Sets the shotlistName value for this CreateShotlistType.
     * 
     * @param shotlistName
     */
    public void setShotlistName(java.lang.String shotlistName) {
        this.shotlistName = shotlistName;
    }


    /**
     * Gets the startTimecode value for this CreateShotlistType.
     * 
     * @return startTimecode
     */
    public java.lang.String getStartTimecode() {
        return startTimecode;
    }


    /**
     * Sets the startTimecode value for this CreateShotlistType.
     * 
     * @param startTimecode
     */
    public void setStartTimecode(java.lang.String startTimecode) {
        this.startTimecode = startTimecode;
    }


    /**
     * Gets the shotlistElements value for this CreateShotlistType.
     * 
     * @return shotlistElements
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ShotlistElementType[] getShotlistElements() {
        return shotlistElements;
    }


    /**
     * Sets the shotlistElements value for this CreateShotlistType.
     * 
     * @param shotlistElements
     */
    public void setShotlistElements(com.spectralogic.escapepod.avidpamclient.soap.ws.ShotlistElementType[] shotlistElements) {
        this.shotlistElements = shotlistElements;
    }


    /**
     * Gets the attributes value for this CreateShotlistType.
     * 
     * @return attributes
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[] getAttributes() {
        return attributes;
    }


    /**
     * Sets the attributes value for this CreateShotlistType.
     * 
     * @param attributes
     */
    public void setAttributes(com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[] attributes) {
        this.attributes = attributes;
    }


    /**
     * Gets the locators value for this CreateShotlistType.
     * 
     * @return locators
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.UMIDLocatorType[] getLocators() {
        return locators;
    }


    /**
     * Sets the locators value for this CreateShotlistType.
     * 
     * @param locators
     */
    public void setLocators(com.spectralogic.escapepod.avidpamclient.soap.ws.UMIDLocatorType[] locators) {
        this.locators = locators;
    }


    /**
     * Gets the extension value for this CreateShotlistType.
     * 
     * @return extension
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this CreateShotlistType.
     * 
     * @param extension
     */
    public void setExtension(com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension) {
        this.extension = extension;
    }


    /**
     * Gets the _any value for this CreateShotlistType.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this CreateShotlistType.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CreateShotlistType)) return false;
        CreateShotlistType other = (CreateShotlistType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.destinationFolderURI==null && other.getDestinationFolderURI()==null) || 
             (this.destinationFolderURI!=null &&
              this.destinationFolderURI.equals(other.getDestinationFolderURI()))) &&
            ((this.shotlistName==null && other.getShotlistName()==null) || 
             (this.shotlistName!=null &&
              this.shotlistName.equals(other.getShotlistName()))) &&
            ((this.startTimecode==null && other.getStartTimecode()==null) || 
             (this.startTimecode!=null &&
              this.startTimecode.equals(other.getStartTimecode()))) &&
            ((this.shotlistElements==null && other.getShotlistElements()==null) || 
             (this.shotlistElements!=null &&
              java.util.Arrays.equals(this.shotlistElements, other.getShotlistElements()))) &&
            ((this.attributes==null && other.getAttributes()==null) || 
             (this.attributes!=null &&
              java.util.Arrays.equals(this.attributes, other.getAttributes()))) &&
            ((this.locators==null && other.getLocators()==null) || 
             (this.locators!=null &&
              java.util.Arrays.equals(this.locators, other.getLocators()))) &&
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
        if (getDestinationFolderURI() != null) {
            _hashCode += getDestinationFolderURI().hashCode();
        }
        if (getShotlistName() != null) {
            _hashCode += getShotlistName().hashCode();
        }
        if (getStartTimecode() != null) {
            _hashCode += getStartTimecode().hashCode();
        }
        if (getShotlistElements() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getShotlistElements());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getShotlistElements(), i);
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
        if (getLocators() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLocators());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLocators(), i);
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
        new org.apache.axis.description.TypeDesc(CreateShotlistType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateShotlistType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destinationFolderURI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "DestinationFolderURI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shotlistName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ShotlistName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startTimecode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "StartTimecode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shotlistElements");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ShotlistElements"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ShotlistElementType"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ShotlistElement"));
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
        elemField.setFieldName("locators");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Locators"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UMIDLocatorType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Locator"));
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
