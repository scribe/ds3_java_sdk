/**
 * RestrictionType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;


/**
 * A restriction object containing an inpoint, outpoint, and comment.
 * Inpoint must be represented
 *         as InFrameNumber or InTimecode (choose one). Outpoint must
 * be represented as OutFrameNumber or OutTimecode
 *         (choose one).
 */
public class RestrictionType  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType {
    private java.lang.Long inFrameNumber;

    private java.lang.String inTimecode;

    private java.lang.Long outFrameNumber;

    private java.lang.String outTimecode;

    private java.lang.String comment;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension;

    private org.apache.axis.message.MessageElement [] _any;

    public RestrictionType() {
    }

    public RestrictionType(
           java.lang.Long inFrameNumber,
           java.lang.String inTimecode,
           java.lang.Long outFrameNumber,
           java.lang.String outTimecode,
           java.lang.String comment,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension,
           org.apache.axis.message.MessageElement [] _any) {
           this.inFrameNumber = inFrameNumber;
           this.inTimecode = inTimecode;
           this.outFrameNumber = outFrameNumber;
           this.outTimecode = outTimecode;
           this.comment = comment;
           this.extension = extension;
           this._any = _any;
    }


    /**
     * Gets the inFrameNumber value for this RestrictionType.
     * 
     * @return inFrameNumber
     */
    public java.lang.Long getInFrameNumber() {
        return inFrameNumber;
    }


    /**
     * Sets the inFrameNumber value for this RestrictionType.
     * 
     * @param inFrameNumber
     */
    public void setInFrameNumber(java.lang.Long inFrameNumber) {
        this.inFrameNumber = inFrameNumber;
    }


    /**
     * Gets the inTimecode value for this RestrictionType.
     * 
     * @return inTimecode
     */
    public java.lang.String getInTimecode() {
        return inTimecode;
    }


    /**
     * Sets the inTimecode value for this RestrictionType.
     * 
     * @param inTimecode
     */
    public void setInTimecode(java.lang.String inTimecode) {
        this.inTimecode = inTimecode;
    }


    /**
     * Gets the outFrameNumber value for this RestrictionType.
     * 
     * @return outFrameNumber
     */
    public java.lang.Long getOutFrameNumber() {
        return outFrameNumber;
    }


    /**
     * Sets the outFrameNumber value for this RestrictionType.
     * 
     * @param outFrameNumber
     */
    public void setOutFrameNumber(java.lang.Long outFrameNumber) {
        this.outFrameNumber = outFrameNumber;
    }


    /**
     * Gets the outTimecode value for this RestrictionType.
     * 
     * @return outTimecode
     */
    public java.lang.String getOutTimecode() {
        return outTimecode;
    }


    /**
     * Sets the outTimecode value for this RestrictionType.
     * 
     * @param outTimecode
     */
    public void setOutTimecode(java.lang.String outTimecode) {
        this.outTimecode = outTimecode;
    }


    /**
     * Gets the comment value for this RestrictionType.
     * 
     * @return comment
     */
    public java.lang.String getComment() {
        return comment;
    }


    /**
     * Sets the comment value for this RestrictionType.
     * 
     * @param comment
     */
    public void setComment(java.lang.String comment) {
        this.comment = comment;
    }


    /**
     * Gets the extension value for this RestrictionType.
     * 
     * @return extension
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this RestrictionType.
     * 
     * @param extension
     */
    public void setExtension(com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension) {
        this.extension = extension;
    }


    /**
     * Gets the _any value for this RestrictionType.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this RestrictionType.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RestrictionType)) return false;
        RestrictionType other = (RestrictionType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.inFrameNumber==null && other.getInFrameNumber()==null) || 
             (this.inFrameNumber!=null &&
              this.inFrameNumber.equals(other.getInFrameNumber()))) &&
            ((this.inTimecode==null && other.getInTimecode()==null) || 
             (this.inTimecode!=null &&
              this.inTimecode.equals(other.getInTimecode()))) &&
            ((this.outFrameNumber==null && other.getOutFrameNumber()==null) || 
             (this.outFrameNumber!=null &&
              this.outFrameNumber.equals(other.getOutFrameNumber()))) &&
            ((this.outTimecode==null && other.getOutTimecode()==null) || 
             (this.outTimecode!=null &&
              this.outTimecode.equals(other.getOutTimecode()))) &&
            ((this.comment==null && other.getComment()==null) || 
             (this.comment!=null &&
              this.comment.equals(other.getComment()))) &&
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
        if (getInFrameNumber() != null) {
            _hashCode += getInFrameNumber().hashCode();
        }
        if (getInTimecode() != null) {
            _hashCode += getInTimecode().hashCode();
        }
        if (getOutFrameNumber() != null) {
            _hashCode += getOutFrameNumber().hashCode();
        }
        if (getOutTimecode() != null) {
            _hashCode += getOutTimecode().hashCode();
        }
        if (getComment() != null) {
            _hashCode += getComment().hashCode();
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
        new org.apache.axis.description.TypeDesc(RestrictionType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "RestrictionType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inFrameNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "InFrameNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inTimecode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "InTimecode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("outFrameNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "OutFrameNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("outTimecode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "OutTimecode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Comment"));
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
