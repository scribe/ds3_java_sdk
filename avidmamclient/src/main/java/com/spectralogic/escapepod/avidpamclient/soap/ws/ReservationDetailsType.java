/**
 * ReservationDetailsType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;


/**
 * The details of a reservation: who made the reservation, when it
 * expires, and what is the asset causing
 *         the reservation (i.e., the reserved folder in the heirarchy).
 */
public class ReservationDetailsType  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType {
    private java.lang.String reservedBy;

    private java.lang.String expirationDate;

    private java.lang.String reservedAsset;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension;

    private org.apache.axis.message.MessageElement [] _any;

    public ReservationDetailsType() {
    }

    public ReservationDetailsType(
           java.lang.String reservedBy,
           java.lang.String expirationDate,
           java.lang.String reservedAsset,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension,
           org.apache.axis.message.MessageElement [] _any) {
           this.reservedBy = reservedBy;
           this.expirationDate = expirationDate;
           this.reservedAsset = reservedAsset;
           this.extension = extension;
           this._any = _any;
    }


    /**
     * Gets the reservedBy value for this ReservationDetailsType.
     * 
     * @return reservedBy
     */
    public java.lang.String getReservedBy() {
        return reservedBy;
    }


    /**
     * Sets the reservedBy value for this ReservationDetailsType.
     * 
     * @param reservedBy
     */
    public void setReservedBy(java.lang.String reservedBy) {
        this.reservedBy = reservedBy;
    }


    /**
     * Gets the expirationDate value for this ReservationDetailsType.
     * 
     * @return expirationDate
     */
    public java.lang.String getExpirationDate() {
        return expirationDate;
    }


    /**
     * Sets the expirationDate value for this ReservationDetailsType.
     * 
     * @param expirationDate
     */
    public void setExpirationDate(java.lang.String expirationDate) {
        this.expirationDate = expirationDate;
    }


    /**
     * Gets the reservedAsset value for this ReservationDetailsType.
     * 
     * @return reservedAsset
     */
    public java.lang.String getReservedAsset() {
        return reservedAsset;
    }


    /**
     * Sets the reservedAsset value for this ReservationDetailsType.
     * 
     * @param reservedAsset
     */
    public void setReservedAsset(java.lang.String reservedAsset) {
        this.reservedAsset = reservedAsset;
    }


    /**
     * Gets the extension value for this ReservationDetailsType.
     * 
     * @return extension
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this ReservationDetailsType.
     * 
     * @param extension
     */
    public void setExtension(com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension) {
        this.extension = extension;
    }


    /**
     * Gets the _any value for this ReservationDetailsType.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this ReservationDetailsType.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReservationDetailsType)) return false;
        ReservationDetailsType other = (ReservationDetailsType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.reservedBy==null && other.getReservedBy()==null) || 
             (this.reservedBy!=null &&
              this.reservedBy.equals(other.getReservedBy()))) &&
            ((this.expirationDate==null && other.getExpirationDate()==null) || 
             (this.expirationDate!=null &&
              this.expirationDate.equals(other.getExpirationDate()))) &&
            ((this.reservedAsset==null && other.getReservedAsset()==null) || 
             (this.reservedAsset!=null &&
              this.reservedAsset.equals(other.getReservedAsset()))) &&
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
        if (getReservedBy() != null) {
            _hashCode += getReservedBy().hashCode();
        }
        if (getExpirationDate() != null) {
            _hashCode += getExpirationDate().hashCode();
        }
        if (getReservedAsset() != null) {
            _hashCode += getReservedAsset().hashCode();
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
        new org.apache.axis.description.TypeDesc(ReservationDetailsType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ReservationDetailsType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reservedBy");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ReservedBy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expirationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ExpirationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reservedAsset");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ReservedAsset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
