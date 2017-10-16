/**
 * ReservationInformationType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;


/**
 * An Interplay URI and a list of ReservationDetails.
 */
public class ReservationInformationType  implements java.io.Serializable {
    private java.lang.String interplayURI;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ReservationDetailsType[] reservationDetails;

    public ReservationInformationType() {
    }

    public ReservationInformationType(
           java.lang.String interplayURI,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ReservationDetailsType[] reservationDetails) {
           this.interplayURI = interplayURI;
           this.reservationDetails = reservationDetails;
    }


    /**
     * Gets the interplayURI value for this ReservationInformationType.
     * 
     * @return interplayURI
     */
    public java.lang.String getInterplayURI() {
        return interplayURI;
    }


    /**
     * Sets the interplayURI value for this ReservationInformationType.
     * 
     * @param interplayURI
     */
    public void setInterplayURI(java.lang.String interplayURI) {
        this.interplayURI = interplayURI;
    }


    /**
     * Gets the reservationDetails value for this ReservationInformationType.
     * 
     * @return reservationDetails
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ReservationDetailsType[] getReservationDetails() {
        return reservationDetails;
    }


    /**
     * Sets the reservationDetails value for this ReservationInformationType.
     * 
     * @param reservationDetails
     */
    public void setReservationDetails(com.spectralogic.escapepod.avidpamclient.soap.ws.ReservationDetailsType[] reservationDetails) {
        this.reservationDetails = reservationDetails;
    }

    public com.spectralogic.escapepod.avidpamclient.soap.ws.ReservationDetailsType getReservationDetails(int i) {
        return this.reservationDetails[i];
    }

    public void setReservationDetails(int i, com.spectralogic.escapepod.avidpamclient.soap.ws.ReservationDetailsType _value) {
        this.reservationDetails[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReservationInformationType)) return false;
        ReservationInformationType other = (ReservationInformationType) obj;
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
            ((this.reservationDetails==null && other.getReservationDetails()==null) || 
             (this.reservationDetails!=null &&
              java.util.Arrays.equals(this.reservationDetails, other.getReservationDetails())));
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
        if (getReservationDetails() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getReservationDetails());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getReservationDetails(), i);
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
        new org.apache.axis.description.TypeDesc(ReservationInformationType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ReservationInformationType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interplayURI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "InterplayURI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reservationDetails");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ReservationDetails"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ReservationDetailsType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
