/**
 * ResolutionConditionType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;

public class ResolutionConditionType  implements java.io.Serializable {
    private java.lang.String resolution;  // attribute

    private java.lang.String condition;  // attribute

    public ResolutionConditionType() {
    }

    public ResolutionConditionType(
           java.lang.String resolution,
           java.lang.String condition) {
           this.resolution = resolution;
           this.condition = condition;
    }


    /**
     * Gets the resolution value for this ResolutionConditionType.
     * 
     * @return resolution
     */
    public java.lang.String getResolution() {
        return resolution;
    }


    /**
     * Sets the resolution value for this ResolutionConditionType.
     * 
     * @param resolution
     */
    public void setResolution(java.lang.String resolution) {
        this.resolution = resolution;
    }


    /**
     * Gets the condition value for this ResolutionConditionType.
     * 
     * @return condition
     */
    public java.lang.String getCondition() {
        return condition;
    }


    /**
     * Sets the condition value for this ResolutionConditionType.
     * 
     * @param condition
     */
    public void setCondition(java.lang.String condition) {
        this.condition = condition;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResolutionConditionType)) return false;
        ResolutionConditionType other = (ResolutionConditionType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.resolution==null && other.getResolution()==null) || 
             (this.resolution!=null &&
              this.resolution.equals(other.getResolution()))) &&
            ((this.condition==null && other.getCondition()==null) || 
             (this.condition!=null &&
              this.condition.equals(other.getCondition())));
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
        if (getResolution() != null) {
            _hashCode += getResolution().hashCode();
        }
        if (getCondition() != null) {
            _hashCode += getCondition().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResolutionConditionType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ResolutionConditionType"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("resolution");
        attrField.setXmlName(new javax.xml.namespace.QName("", "Resolution"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("condition");
        attrField.setXmlName(new javax.xml.namespace.QName("", "Condition"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
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
