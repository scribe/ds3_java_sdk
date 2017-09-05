/**
 * RestrictionDetailsType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;


/**
 * A RestrictionDetailsType contains an Interplay URI and a list of
 * RestrictionType objects.
 */
public class RestrictionDetailsType  implements java.io.Serializable {
    private java.lang.String interplayURI;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.RestrictionType[] restrictions;

    public RestrictionDetailsType() {
    }

    public RestrictionDetailsType(
           java.lang.String interplayURI,
           com.spectralogic.escapepod.avidpamclient.soap.ws.RestrictionType[] restrictions) {
           this.interplayURI = interplayURI;
           this.restrictions = restrictions;
    }


    /**
     * Gets the interplayURI value for this RestrictionDetailsType.
     * 
     * @return interplayURI
     */
    public java.lang.String getInterplayURI() {
        return interplayURI;
    }


    /**
     * Sets the interplayURI value for this RestrictionDetailsType.
     * 
     * @param interplayURI
     */
    public void setInterplayURI(java.lang.String interplayURI) {
        this.interplayURI = interplayURI;
    }


    /**
     * Gets the restrictions value for this RestrictionDetailsType.
     * 
     * @return restrictions
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.RestrictionType[] getRestrictions() {
        return restrictions;
    }


    /**
     * Sets the restrictions value for this RestrictionDetailsType.
     * 
     * @param restrictions
     */
    public void setRestrictions(com.spectralogic.escapepod.avidpamclient.soap.ws.RestrictionType[] restrictions) {
        this.restrictions = restrictions;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RestrictionDetailsType)) return false;
        RestrictionDetailsType other = (RestrictionDetailsType) obj;
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
            ((this.restrictions==null && other.getRestrictions()==null) || 
             (this.restrictions!=null &&
              java.util.Arrays.equals(this.restrictions, other.getRestrictions())));
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
        if (getRestrictions() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRestrictions());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRestrictions(), i);
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
        new org.apache.axis.description.TypeDesc(RestrictionDetailsType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RestrictionDetailsType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interplayURI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "InterplayURI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("restrictions");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Restrictions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RestrictionType"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Restriction"));
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
