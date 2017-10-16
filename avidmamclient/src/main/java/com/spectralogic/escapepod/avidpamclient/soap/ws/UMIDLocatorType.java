/**
 * UMIDLocatorType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;


/**
 * A frame locator that can be associated with a frame of a clip.
 * This is the preferred way to represent
 *         locators as it uses a LocatorURI with a unique and enduring
 * UMID.
 */
public class UMIDLocatorType  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType {
    private java.lang.String locatorURI;

    private java.lang.Long frameNumber;

    private java.lang.String timecode;

    private java.lang.String username;

    private java.lang.String comment;

    private java.lang.String color;

    private java.lang.String track;

    private byte[] headframe;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension;

    private org.apache.axis.message.MessageElement [] _any;

    public UMIDLocatorType() {
    }

    public UMIDLocatorType(
           java.lang.String locatorURI,
           java.lang.Long frameNumber,
           java.lang.String timecode,
           java.lang.String username,
           java.lang.String comment,
           java.lang.String color,
           java.lang.String track,
           byte[] headframe,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension,
           org.apache.axis.message.MessageElement [] _any) {
           this.locatorURI = locatorURI;
           this.frameNumber = frameNumber;
           this.timecode = timecode;
           this.username = username;
           this.comment = comment;
           this.color = color;
           this.track = track;
           this.headframe = headframe;
           this.extension = extension;
           this._any = _any;
    }


    /**
     * Gets the locatorURI value for this UMIDLocatorType.
     * 
     * @return locatorURI
     */
    public java.lang.String getLocatorURI() {
        return locatorURI;
    }


    /**
     * Sets the locatorURI value for this UMIDLocatorType.
     * 
     * @param locatorURI
     */
    public void setLocatorURI(java.lang.String locatorURI) {
        this.locatorURI = locatorURI;
    }


    /**
     * Gets the frameNumber value for this UMIDLocatorType.
     * 
     * @return frameNumber
     */
    public java.lang.Long getFrameNumber() {
        return frameNumber;
    }


    /**
     * Sets the frameNumber value for this UMIDLocatorType.
     * 
     * @param frameNumber
     */
    public void setFrameNumber(java.lang.Long frameNumber) {
        this.frameNumber = frameNumber;
    }


    /**
     * Gets the timecode value for this UMIDLocatorType.
     * 
     * @return timecode
     */
    public java.lang.String getTimecode() {
        return timecode;
    }


    /**
     * Sets the timecode value for this UMIDLocatorType.
     * 
     * @param timecode
     */
    public void setTimecode(java.lang.String timecode) {
        this.timecode = timecode;
    }


    /**
     * Gets the username value for this UMIDLocatorType.
     * 
     * @return username
     */
    public java.lang.String getUsername() {
        return username;
    }


    /**
     * Sets the username value for this UMIDLocatorType.
     * 
     * @param username
     */
    public void setUsername(java.lang.String username) {
        this.username = username;
    }


    /**
     * Gets the comment value for this UMIDLocatorType.
     * 
     * @return comment
     */
    public java.lang.String getComment() {
        return comment;
    }


    /**
     * Sets the comment value for this UMIDLocatorType.
     * 
     * @param comment
     */
    public void setComment(java.lang.String comment) {
        this.comment = comment;
    }


    /**
     * Gets the color value for this UMIDLocatorType.
     * 
     * @return color
     */
    public java.lang.String getColor() {
        return color;
    }


    /**
     * Sets the color value for this UMIDLocatorType.
     * 
     * @param color
     */
    public void setColor(java.lang.String color) {
        this.color = color;
    }


    /**
     * Gets the track value for this UMIDLocatorType.
     * 
     * @return track
     */
    public java.lang.String getTrack() {
        return track;
    }


    /**
     * Sets the track value for this UMIDLocatorType.
     * 
     * @param track
     */
    public void setTrack(java.lang.String track) {
        this.track = track;
    }


    /**
     * Gets the headframe value for this UMIDLocatorType.
     * 
     * @return headframe
     */
    public byte[] getHeadframe() {
        return headframe;
    }


    /**
     * Sets the headframe value for this UMIDLocatorType.
     * 
     * @param headframe
     */
    public void setHeadframe(byte[] headframe) {
        this.headframe = headframe;
    }


    /**
     * Gets the extension value for this UMIDLocatorType.
     * 
     * @return extension
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this UMIDLocatorType.
     * 
     * @param extension
     */
    public void setExtension(com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension) {
        this.extension = extension;
    }


    /**
     * Gets the _any value for this UMIDLocatorType.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this UMIDLocatorType.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UMIDLocatorType)) return false;
        UMIDLocatorType other = (UMIDLocatorType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.locatorURI==null && other.getLocatorURI()==null) || 
             (this.locatorURI!=null &&
              this.locatorURI.equals(other.getLocatorURI()))) &&
            ((this.frameNumber==null && other.getFrameNumber()==null) || 
             (this.frameNumber!=null &&
              this.frameNumber.equals(other.getFrameNumber()))) &&
            ((this.timecode==null && other.getTimecode()==null) || 
             (this.timecode!=null &&
              this.timecode.equals(other.getTimecode()))) &&
            ((this.username==null && other.getUsername()==null) || 
             (this.username!=null &&
              this.username.equals(other.getUsername()))) &&
            ((this.comment==null && other.getComment()==null) || 
             (this.comment!=null &&
              this.comment.equals(other.getComment()))) &&
            ((this.color==null && other.getColor()==null) || 
             (this.color!=null &&
              this.color.equals(other.getColor()))) &&
            ((this.track==null && other.getTrack()==null) || 
             (this.track!=null &&
              this.track.equals(other.getTrack()))) &&
            ((this.headframe==null && other.getHeadframe()==null) || 
             (this.headframe!=null &&
              java.util.Arrays.equals(this.headframe, other.getHeadframe()))) &&
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
        if (getLocatorURI() != null) {
            _hashCode += getLocatorURI().hashCode();
        }
        if (getFrameNumber() != null) {
            _hashCode += getFrameNumber().hashCode();
        }
        if (getTimecode() != null) {
            _hashCode += getTimecode().hashCode();
        }
        if (getUsername() != null) {
            _hashCode += getUsername().hashCode();
        }
        if (getComment() != null) {
            _hashCode += getComment().hashCode();
        }
        if (getColor() != null) {
            _hashCode += getColor().hashCode();
        }
        if (getTrack() != null) {
            _hashCode += getTrack().hashCode();
        }
        if (getHeadframe() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getHeadframe());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getHeadframe(), i);
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
        new org.apache.axis.description.TypeDesc(UMIDLocatorType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "UMIDLocatorType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("locatorURI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "LocatorURI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("frameNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "FrameNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timecode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Timecode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("username");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Username"));
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
        elemField.setFieldName("color");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Color"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("track");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Track"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("headframe");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Headframe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
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
