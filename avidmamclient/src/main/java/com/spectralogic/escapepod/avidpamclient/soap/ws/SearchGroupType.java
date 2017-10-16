/**
 * SearchGroupType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;

public class SearchGroupType  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType {
    private com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeConditionType[] attributeCondition;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.CategoryConditionType[] categoryCondition;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.FileInUseConditionType fileInUseCondition;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ResolutionConditionType[] resolutionCondition;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.SearchGroupType[] searchGroup;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension;

    private org.apache.axis.message.MessageElement [] _any;

    private java.lang.String operator;  // attribute

    private java.lang.Boolean negated;  // attribute

    public SearchGroupType() {
    }

    public SearchGroupType(
           com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeConditionType[] attributeCondition,
           com.spectralogic.escapepod.avidpamclient.soap.ws.CategoryConditionType[] categoryCondition,
           com.spectralogic.escapepod.avidpamclient.soap.ws.FileInUseConditionType fileInUseCondition,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ResolutionConditionType[] resolutionCondition,
           com.spectralogic.escapepod.avidpamclient.soap.ws.SearchGroupType[] searchGroup,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension,
           org.apache.axis.message.MessageElement [] _any,
           java.lang.String operator,
           java.lang.Boolean negated) {
           this.attributeCondition = attributeCondition;
           this.categoryCondition = categoryCondition;
           this.fileInUseCondition = fileInUseCondition;
           this.resolutionCondition = resolutionCondition;
           this.searchGroup = searchGroup;
           this.extension = extension;
           this._any = _any;
           this.operator = operator;
           this.negated = negated;
    }


    /**
     * Gets the attributeCondition value for this SearchGroupType.
     * 
     * @return attributeCondition
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeConditionType[] getAttributeCondition() {
        return attributeCondition;
    }


    /**
     * Sets the attributeCondition value for this SearchGroupType.
     * 
     * @param attributeCondition
     */
    public void setAttributeCondition(com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeConditionType[] attributeCondition) {
        this.attributeCondition = attributeCondition;
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeConditionType getAttributeCondition(int i) {
        return this.attributeCondition[i];
    }

    public void setAttributeCondition(int i, com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeConditionType _value) {
        this.attributeCondition[i] = _value;
    }


    /**
     * Gets the categoryCondition value for this SearchGroupType.
     * 
     * @return categoryCondition
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.CategoryConditionType[] getCategoryCondition() {
        return categoryCondition;
    }


    /**
     * Sets the categoryCondition value for this SearchGroupType.
     * 
     * @param categoryCondition
     */
    public void setCategoryCondition(com.spectralogic.escapepod.avidpamclient.soap.ws.CategoryConditionType[] categoryCondition) {
        this.categoryCondition = categoryCondition;
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.CategoryConditionType getCategoryCondition(int i) {
        return this.categoryCondition[i];
    }

    public void setCategoryCondition(int i, com.spectralogic.escapepod.avidpamclient.soap.ws.CategoryConditionType _value) {
        this.categoryCondition[i] = _value;
    }


    /**
     * Gets the fileInUseCondition value for this SearchGroupType.
     * 
     * @return fileInUseCondition
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.FileInUseConditionType getFileInUseCondition() {
        return fileInUseCondition;
    }


    /**
     * Sets the fileInUseCondition value for this SearchGroupType.
     * 
     * @param fileInUseCondition
     */
    public void setFileInUseCondition(com.spectralogic.escapepod.avidpamclient.soap.ws.FileInUseConditionType fileInUseCondition) {
        this.fileInUseCondition = fileInUseCondition;
    }


    /**
     * Gets the resolutionCondition value for this SearchGroupType.
     * 
     * @return resolutionCondition
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ResolutionConditionType[] getResolutionCondition() {
        return resolutionCondition;
    }


    /**
     * Sets the resolutionCondition value for this SearchGroupType.
     * 
     * @param resolutionCondition
     */
    public void setResolutionCondition(com.spectralogic.escapepod.avidpamclient.soap.ws.ResolutionConditionType[] resolutionCondition) {
        this.resolutionCondition = resolutionCondition;
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.ResolutionConditionType getResolutionCondition(int i) {
        return this.resolutionCondition[i];
    }

    public void setResolutionCondition(int i, com.spectralogic.escapepod.avidpamclient.soap.ws.ResolutionConditionType _value) {
        this.resolutionCondition[i] = _value;
    }


    /**
     * Gets the searchGroup value for this SearchGroupType.
     * 
     * @return searchGroup
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.SearchGroupType[] getSearchGroup() {
        return searchGroup;
    }


    /**
     * Sets the searchGroup value for this SearchGroupType.
     * 
     * @param searchGroup
     */
    public void setSearchGroup(com.spectralogic.escapepod.avidpamclient.soap.ws.SearchGroupType[] searchGroup) {
        this.searchGroup = searchGroup;
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.SearchGroupType getSearchGroup(int i) {
        return this.searchGroup[i];
    }

    public void setSearchGroup(int i, com.spectralogic.escapepod.avidpamclient.soap.ws.SearchGroupType _value) {
        this.searchGroup[i] = _value;
    }


    /**
     * Gets the extension value for this SearchGroupType.
     * 
     * @return extension
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this SearchGroupType.
     * 
     * @param extension
     */
    public void setExtension(com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension) {
        this.extension = extension;
    }


    /**
     * Gets the _any value for this SearchGroupType.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this SearchGroupType.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }


    /**
     * Gets the operator value for this SearchGroupType.
     * 
     * @return operator
     */
    public java.lang.String getOperator() {
        return operator;
    }


    /**
     * Sets the operator value for this SearchGroupType.
     * 
     * @param operator
     */
    public void setOperator(java.lang.String operator) {
        this.operator = operator;
    }


    /**
     * Gets the negated value for this SearchGroupType.
     * 
     * @return negated
     */
    public java.lang.Boolean getNegated() {
        return negated;
    }


    /**
     * Sets the negated value for this SearchGroupType.
     * 
     * @param negated
     */
    public void setNegated(java.lang.Boolean negated) {
        this.negated = negated;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchGroupType)) return false;
        SearchGroupType other = (SearchGroupType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.attributeCondition==null && other.getAttributeCondition()==null) || 
             (this.attributeCondition!=null &&
              java.util.Arrays.equals(this.attributeCondition, other.getAttributeCondition()))) &&
            ((this.categoryCondition==null && other.getCategoryCondition()==null) || 
             (this.categoryCondition!=null &&
              java.util.Arrays.equals(this.categoryCondition, other.getCategoryCondition()))) &&
            ((this.fileInUseCondition==null && other.getFileInUseCondition()==null) || 
             (this.fileInUseCondition!=null &&
              this.fileInUseCondition.equals(other.getFileInUseCondition()))) &&
            ((this.resolutionCondition==null && other.getResolutionCondition()==null) || 
             (this.resolutionCondition!=null &&
              java.util.Arrays.equals(this.resolutionCondition, other.getResolutionCondition()))) &&
            ((this.searchGroup==null && other.getSearchGroup()==null) || 
             (this.searchGroup!=null &&
              java.util.Arrays.equals(this.searchGroup, other.getSearchGroup()))) &&
            ((this.extension==null && other.getExtension()==null) || 
             (this.extension!=null &&
              this.extension.equals(other.getExtension()))) &&
            ((this._any==null && other.get_any()==null) || 
             (this._any!=null &&
              java.util.Arrays.equals(this._any, other.get_any()))) &&
            ((this.operator==null && other.getOperator()==null) || 
             (this.operator!=null &&
              this.operator.equals(other.getOperator()))) &&
            ((this.negated==null && other.getNegated()==null) || 
             (this.negated!=null &&
              this.negated.equals(other.getNegated())));
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
        if (getAttributeCondition() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAttributeCondition());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAttributeCondition(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCategoryCondition() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCategoryCondition());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCategoryCondition(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFileInUseCondition() != null) {
            _hashCode += getFileInUseCondition().hashCode();
        }
        if (getResolutionCondition() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getResolutionCondition());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getResolutionCondition(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSearchGroup() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSearchGroup());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSearchGroup(), i);
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
        if (getOperator() != null) {
            _hashCode += getOperator().hashCode();
        }
        if (getNegated() != null) {
            _hashCode += getNegated().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchGroupType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SearchGroupType"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("operator");
        attrField.setXmlName(new javax.xml.namespace.QName("", "Operator"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("negated");
        attrField.setXmlName(new javax.xml.namespace.QName("", "Negated"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attributeCondition");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AttributeCondition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AttributeConditionType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categoryCondition");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CategoryCondition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CategoryConditionType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileInUseCondition");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FileInUseCondition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FileInUseConditionType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resolutionCondition");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ResolutionCondition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ResolutionConditionType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SearchGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SearchGroupType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
