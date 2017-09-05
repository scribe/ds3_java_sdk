/**
 * FolderACLType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;


/**
 * An object representing an Interplay folder, its owner, and specified
 * permissions for specific
 *         users or groups.
 */
public class FolderACLType  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType {
    private java.lang.String folderURI;

    private java.lang.String ownerURI;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.PermissionType[] permissions;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension;

    private org.apache.axis.message.MessageElement [] _any;

    public FolderACLType() {
    }

    public FolderACLType(
           java.lang.String folderURI,
           java.lang.String ownerURI,
           com.spectralogic.escapepod.avidpamclient.soap.ws.PermissionType[] permissions,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension,
           org.apache.axis.message.MessageElement [] _any) {
           this.folderURI = folderURI;
           this.ownerURI = ownerURI;
           this.permissions = permissions;
           this.extension = extension;
           this._any = _any;
    }


    /**
     * Gets the folderURI value for this FolderACLType.
     * 
     * @return folderURI
     */
    public java.lang.String getFolderURI() {
        return folderURI;
    }


    /**
     * Sets the folderURI value for this FolderACLType.
     * 
     * @param folderURI
     */
    public void setFolderURI(java.lang.String folderURI) {
        this.folderURI = folderURI;
    }


    /**
     * Gets the ownerURI value for this FolderACLType.
     * 
     * @return ownerURI
     */
    public java.lang.String getOwnerURI() {
        return ownerURI;
    }


    /**
     * Sets the ownerURI value for this FolderACLType.
     * 
     * @param ownerURI
     */
    public void setOwnerURI(java.lang.String ownerURI) {
        this.ownerURI = ownerURI;
    }


    /**
     * Gets the permissions value for this FolderACLType.
     * 
     * @return permissions
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.PermissionType[] getPermissions() {
        return permissions;
    }


    /**
     * Sets the permissions value for this FolderACLType.
     * 
     * @param permissions
     */
    public void setPermissions(com.spectralogic.escapepod.avidpamclient.soap.ws.PermissionType[] permissions) {
        this.permissions = permissions;
    }


    /**
     * Gets the extension value for this FolderACLType.
     * 
     * @return extension
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this FolderACLType.
     * 
     * @param extension
     */
    public void setExtension(com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension) {
        this.extension = extension;
    }


    /**
     * Gets the _any value for this FolderACLType.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this FolderACLType.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FolderACLType)) return false;
        FolderACLType other = (FolderACLType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.folderURI==null && other.getFolderURI()==null) || 
             (this.folderURI!=null &&
              this.folderURI.equals(other.getFolderURI()))) &&
            ((this.ownerURI==null && other.getOwnerURI()==null) || 
             (this.ownerURI!=null &&
              this.ownerURI.equals(other.getOwnerURI()))) &&
            ((this.permissions==null && other.getPermissions()==null) || 
             (this.permissions!=null &&
              java.util.Arrays.equals(this.permissions, other.getPermissions()))) &&
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
        if (getFolderURI() != null) {
            _hashCode += getFolderURI().hashCode();
        }
        if (getOwnerURI() != null) {
            _hashCode += getOwnerURI().hashCode();
        }
        if (getPermissions() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPermissions());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPermissions(), i);
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
        new org.apache.axis.description.TypeDesc(FolderACLType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FolderACLType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("folderURI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FolderURI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerURI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "OwnerURI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("permissions");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Permissions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "PermissionType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Permission"));
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
