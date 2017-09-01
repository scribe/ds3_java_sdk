/**
 * MoveType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;


/**
 * Parameters for the Move operation. InterplayAssetURI must reference
 * the asset that you wish to
 *         move. It must be in the full path form. InterplayFolderURI
 * references the folder to move the asset to.
 *         Override reservations specifies if the asset should be moved
 * even if it is reserved.  OverrideReservations
 *         defaults to false.
 */
public class MoveType  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType {
    private java.lang.String interplayAssetURI;

    private java.lang.String interplayFolderURI;

    private java.lang.Boolean overrideReservations;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension;

    private org.apache.axis.message.MessageElement [] _any;

    public MoveType() {
    }

    public MoveType(
           java.lang.String interplayAssetURI,
           java.lang.String interplayFolderURI,
           java.lang.Boolean overrideReservations,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension,
           org.apache.axis.message.MessageElement [] _any) {
           this.interplayAssetURI = interplayAssetURI;
           this.interplayFolderURI = interplayFolderURI;
           this.overrideReservations = overrideReservations;
           this.extension = extension;
           this._any = _any;
    }


    /**
     * Gets the interplayAssetURI value for this MoveType.
     * 
     * @return interplayAssetURI
     */
    public java.lang.String getInterplayAssetURI() {
        return interplayAssetURI;
    }


    /**
     * Sets the interplayAssetURI value for this MoveType.
     * 
     * @param interplayAssetURI
     */
    public void setInterplayAssetURI(java.lang.String interplayAssetURI) {
        this.interplayAssetURI = interplayAssetURI;
    }


    /**
     * Gets the interplayFolderURI value for this MoveType.
     * 
     * @return interplayFolderURI
     */
    public java.lang.String getInterplayFolderURI() {
        return interplayFolderURI;
    }


    /**
     * Sets the interplayFolderURI value for this MoveType.
     * 
     * @param interplayFolderURI
     */
    public void setInterplayFolderURI(java.lang.String interplayFolderURI) {
        this.interplayFolderURI = interplayFolderURI;
    }


    /**
     * Gets the overrideReservations value for this MoveType.
     * 
     * @return overrideReservations
     */
    public java.lang.Boolean getOverrideReservations() {
        return overrideReservations;
    }


    /**
     * Sets the overrideReservations value for this MoveType.
     * 
     * @param overrideReservations
     */
    public void setOverrideReservations(java.lang.Boolean overrideReservations) {
        this.overrideReservations = overrideReservations;
    }


    /**
     * Gets the extension value for this MoveType.
     * 
     * @return extension
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this MoveType.
     * 
     * @param extension
     */
    public void setExtension(com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension) {
        this.extension = extension;
    }


    /**
     * Gets the _any value for this MoveType.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this MoveType.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MoveType)) return false;
        MoveType other = (MoveType) obj;
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
            ((this.overrideReservations==null && other.getOverrideReservations()==null) || 
             (this.overrideReservations!=null &&
              this.overrideReservations.equals(other.getOverrideReservations()))) &&
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
        if (getOverrideReservations() != null) {
            _hashCode += getOverrideReservations().hashCode();
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
        new org.apache.axis.description.TypeDesc(MoveType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "MoveType"));
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
        elemField.setFieldName("overrideReservations");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "OverrideReservations"));
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
