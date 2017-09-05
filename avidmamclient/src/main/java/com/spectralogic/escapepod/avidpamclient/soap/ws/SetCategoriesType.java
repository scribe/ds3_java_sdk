/**
 * SetCategoriesType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;


/**
 * Parameters for the SetCategories operation. InterplayURI must represent
 * a valid asset.
 *         CategoriesToAdd is a list of categories to set on the asset.
 * CategoriesToRemove is a list of categories to unset
 *         on the asset.
 */
public class SetCategoriesType  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType {
    private java.lang.String interplayURI;

    private java.lang.String[] categoriesToAdd;

    private java.lang.String[] categoriesToRemove;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension;

    private org.apache.axis.message.MessageElement [] _any;

    public SetCategoriesType() {
    }

    public SetCategoriesType(
           java.lang.String interplayURI,
           java.lang.String[] categoriesToAdd,
           java.lang.String[] categoriesToRemove,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension,
           org.apache.axis.message.MessageElement [] _any) {
           this.interplayURI = interplayURI;
           this.categoriesToAdd = categoriesToAdd;
           this.categoriesToRemove = categoriesToRemove;
           this.extension = extension;
           this._any = _any;
    }


    /**
     * Gets the interplayURI value for this SetCategoriesType.
     * 
     * @return interplayURI
     */
    public java.lang.String getInterplayURI() {
        return interplayURI;
    }


    /**
     * Sets the interplayURI value for this SetCategoriesType.
     * 
     * @param interplayURI
     */
    public void setInterplayURI(java.lang.String interplayURI) {
        this.interplayURI = interplayURI;
    }


    /**
     * Gets the categoriesToAdd value for this SetCategoriesType.
     * 
     * @return categoriesToAdd
     */
    public java.lang.String[] getCategoriesToAdd() {
        return categoriesToAdd;
    }


    /**
     * Sets the categoriesToAdd value for this SetCategoriesType.
     * 
     * @param categoriesToAdd
     */
    public void setCategoriesToAdd(java.lang.String[] categoriesToAdd) {
        this.categoriesToAdd = categoriesToAdd;
    }


    /**
     * Gets the categoriesToRemove value for this SetCategoriesType.
     * 
     * @return categoriesToRemove
     */
    public java.lang.String[] getCategoriesToRemove() {
        return categoriesToRemove;
    }


    /**
     * Sets the categoriesToRemove value for this SetCategoriesType.
     * 
     * @param categoriesToRemove
     */
    public void setCategoriesToRemove(java.lang.String[] categoriesToRemove) {
        this.categoriesToRemove = categoriesToRemove;
    }


    /**
     * Gets the extension value for this SetCategoriesType.
     * 
     * @return extension
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this SetCategoriesType.
     * 
     * @param extension
     */
    public void setExtension(com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension) {
        this.extension = extension;
    }


    /**
     * Gets the _any value for this SetCategoriesType.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this SetCategoriesType.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SetCategoriesType)) return false;
        SetCategoriesType other = (SetCategoriesType) obj;
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
            ((this.categoriesToAdd==null && other.getCategoriesToAdd()==null) || 
             (this.categoriesToAdd!=null &&
              java.util.Arrays.equals(this.categoriesToAdd, other.getCategoriesToAdd()))) &&
            ((this.categoriesToRemove==null && other.getCategoriesToRemove()==null) || 
             (this.categoriesToRemove!=null &&
              java.util.Arrays.equals(this.categoriesToRemove, other.getCategoriesToRemove()))) &&
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
        if (getCategoriesToAdd() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCategoriesToAdd());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCategoriesToAdd(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCategoriesToRemove() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCategoriesToRemove());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCategoriesToRemove(), i);
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
        new org.apache.axis.description.TypeDesc(SetCategoriesType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SetCategoriesType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interplayURI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "InterplayURI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categoriesToAdd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CategoriesToAdd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Category"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categoriesToRemove");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CategoriesToRemove"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Category"));
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
