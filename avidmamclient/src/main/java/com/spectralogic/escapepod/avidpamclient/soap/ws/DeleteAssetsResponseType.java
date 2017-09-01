/**
 * DeleteAssetsResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;


/**
 * The response from the CreateUser operation. Errors contains a list
 * of errors that occurred. If
 *         there are no errors, the Errors element is omitted entirely.
 * Deleted Assets contains a list of the InterplayURIs
 *         representing the metadata objects deleted from the database.
 * DeletedMedia contains a list of file paths and
 *         resolutions of media that was deleted. If the request was
 * sent in "Simulation" mode, then the reports
 *         only indicate what would have been deleted.
 */
public class DeleteAssetsResponseType  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType {
    private com.spectralogic.escapepod.avidpamclient.soap.ws.ErrorType[] errors;

    private java.lang.String[] deletedAssets;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.MediaDetailsType[] deletedMedia;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension;

    private org.apache.axis.message.MessageElement [] _any;

    public DeleteAssetsResponseType() {
    }

    public DeleteAssetsResponseType(
           com.spectralogic.escapepod.avidpamclient.soap.ws.ErrorType[] errors,
           java.lang.String[] deletedAssets,
           com.spectralogic.escapepod.avidpamclient.soap.ws.MediaDetailsType[] deletedMedia,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension,
           org.apache.axis.message.MessageElement [] _any) {
           this.errors = errors;
           this.deletedAssets = deletedAssets;
           this.deletedMedia = deletedMedia;
           this.extension = extension;
           this._any = _any;
    }


    /**
     * Gets the errors value for this DeleteAssetsResponseType.
     * 
     * @return errors
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ErrorType[] getErrors() {
        return errors;
    }


    /**
     * Sets the errors value for this DeleteAssetsResponseType.
     * 
     * @param errors
     */
    public void setErrors(com.spectralogic.escapepod.avidpamclient.soap.ws.ErrorType[] errors) {
        this.errors = errors;
    }


    /**
     * Gets the deletedAssets value for this DeleteAssetsResponseType.
     * 
     * @return deletedAssets
     */
    public java.lang.String[] getDeletedAssets() {
        return deletedAssets;
    }


    /**
     * Sets the deletedAssets value for this DeleteAssetsResponseType.
     * 
     * @param deletedAssets
     */
    public void setDeletedAssets(java.lang.String[] deletedAssets) {
        this.deletedAssets = deletedAssets;
    }


    /**
     * Gets the deletedMedia value for this DeleteAssetsResponseType.
     * 
     * @return deletedMedia
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.MediaDetailsType[] getDeletedMedia() {
        return deletedMedia;
    }


    /**
     * Sets the deletedMedia value for this DeleteAssetsResponseType.
     * 
     * @param deletedMedia
     */
    public void setDeletedMedia(com.spectralogic.escapepod.avidpamclient.soap.ws.MediaDetailsType[] deletedMedia) {
        this.deletedMedia = deletedMedia;
    }


    /**
     * Gets the extension value for this DeleteAssetsResponseType.
     * 
     * @return extension
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this DeleteAssetsResponseType.
     * 
     * @param extension
     */
    public void setExtension(com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension) {
        this.extension = extension;
    }


    /**
     * Gets the _any value for this DeleteAssetsResponseType.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this DeleteAssetsResponseType.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DeleteAssetsResponseType)) return false;
        DeleteAssetsResponseType other = (DeleteAssetsResponseType) obj;
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
            ((this.deletedAssets==null && other.getDeletedAssets()==null) || 
             (this.deletedAssets!=null &&
              java.util.Arrays.equals(this.deletedAssets, other.getDeletedAssets()))) &&
            ((this.deletedMedia==null && other.getDeletedMedia()==null) || 
             (this.deletedMedia!=null &&
              java.util.Arrays.equals(this.deletedMedia, other.getDeletedMedia()))) &&
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
        if (getDeletedAssets() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDeletedAssets());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDeletedAssets(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDeletedMedia() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDeletedMedia());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDeletedMedia(), i);
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
        new org.apache.axis.description.TypeDesc(DeleteAssetsResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "DeleteAssetsResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errors");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Errors"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ErrorType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Error"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deletedAssets");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "DeletedAssets"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "InterplayURI"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deletedMedia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "DeletedMedia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "MediaDetailsType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "MediaDetails"));
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
