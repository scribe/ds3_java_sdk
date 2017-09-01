/**
 * SegmentDescriptionType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;


/**
 * Represents an SegmentDescription.
 */
public class SegmentDescriptionType  implements java.io.Serializable {
    private com.spectralogic.escapepod.avidpamclient.soap.ws.AssetDescriptionType assetDescription;

    private long segmentMarkIn;

    private long segmentDuration;

    private java.lang.String segmentTrack;

    private java.lang.String segmentFileMOB;

    private long segmentStartOffset;

    private long compositionPosition;

    private java.lang.String compositionTrack;

    private long compositionDuration;

    public SegmentDescriptionType() {
    }

    public SegmentDescriptionType(
           com.spectralogic.escapepod.avidpamclient.soap.ws.AssetDescriptionType assetDescription,
           long segmentMarkIn,
           long segmentDuration,
           java.lang.String segmentTrack,
           java.lang.String segmentFileMOB,
           long segmentStartOffset,
           long compositionPosition,
           java.lang.String compositionTrack,
           long compositionDuration) {
           this.assetDescription = assetDescription;
           this.segmentMarkIn = segmentMarkIn;
           this.segmentDuration = segmentDuration;
           this.segmentTrack = segmentTrack;
           this.segmentFileMOB = segmentFileMOB;
           this.segmentStartOffset = segmentStartOffset;
           this.compositionPosition = compositionPosition;
           this.compositionTrack = compositionTrack;
           this.compositionDuration = compositionDuration;
    }


    /**
     * Gets the assetDescription value for this SegmentDescriptionType.
     * 
     * @return assetDescription
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.AssetDescriptionType getAssetDescription() {
        return assetDescription;
    }


    /**
     * Sets the assetDescription value for this SegmentDescriptionType.
     * 
     * @param assetDescription
     */
    public void setAssetDescription(com.spectralogic.escapepod.avidpamclient.soap.ws.AssetDescriptionType assetDescription) {
        this.assetDescription = assetDescription;
    }


    /**
     * Gets the segmentMarkIn value for this SegmentDescriptionType.
     * 
     * @return segmentMarkIn
     */
    public long getSegmentMarkIn() {
        return segmentMarkIn;
    }


    /**
     * Sets the segmentMarkIn value for this SegmentDescriptionType.
     * 
     * @param segmentMarkIn
     */
    public void setSegmentMarkIn(long segmentMarkIn) {
        this.segmentMarkIn = segmentMarkIn;
    }


    /**
     * Gets the segmentDuration value for this SegmentDescriptionType.
     * 
     * @return segmentDuration
     */
    public long getSegmentDuration() {
        return segmentDuration;
    }


    /**
     * Sets the segmentDuration value for this SegmentDescriptionType.
     * 
     * @param segmentDuration
     */
    public void setSegmentDuration(long segmentDuration) {
        this.segmentDuration = segmentDuration;
    }


    /**
     * Gets the segmentTrack value for this SegmentDescriptionType.
     * 
     * @return segmentTrack
     */
    public java.lang.String getSegmentTrack() {
        return segmentTrack;
    }


    /**
     * Sets the segmentTrack value for this SegmentDescriptionType.
     * 
     * @param segmentTrack
     */
    public void setSegmentTrack(java.lang.String segmentTrack) {
        this.segmentTrack = segmentTrack;
    }


    /**
     * Gets the segmentFileMOB value for this SegmentDescriptionType.
     * 
     * @return segmentFileMOB
     */
    public java.lang.String getSegmentFileMOB() {
        return segmentFileMOB;
    }


    /**
     * Sets the segmentFileMOB value for this SegmentDescriptionType.
     * 
     * @param segmentFileMOB
     */
    public void setSegmentFileMOB(java.lang.String segmentFileMOB) {
        this.segmentFileMOB = segmentFileMOB;
    }


    /**
     * Gets the segmentStartOffset value for this SegmentDescriptionType.
     * 
     * @return segmentStartOffset
     */
    public long getSegmentStartOffset() {
        return segmentStartOffset;
    }


    /**
     * Sets the segmentStartOffset value for this SegmentDescriptionType.
     * 
     * @param segmentStartOffset
     */
    public void setSegmentStartOffset(long segmentStartOffset) {
        this.segmentStartOffset = segmentStartOffset;
    }


    /**
     * Gets the compositionPosition value for this SegmentDescriptionType.
     * 
     * @return compositionPosition
     */
    public long getCompositionPosition() {
        return compositionPosition;
    }


    /**
     * Sets the compositionPosition value for this SegmentDescriptionType.
     * 
     * @param compositionPosition
     */
    public void setCompositionPosition(long compositionPosition) {
        this.compositionPosition = compositionPosition;
    }


    /**
     * Gets the compositionTrack value for this SegmentDescriptionType.
     * 
     * @return compositionTrack
     */
    public java.lang.String getCompositionTrack() {
        return compositionTrack;
    }


    /**
     * Sets the compositionTrack value for this SegmentDescriptionType.
     * 
     * @param compositionTrack
     */
    public void setCompositionTrack(java.lang.String compositionTrack) {
        this.compositionTrack = compositionTrack;
    }


    /**
     * Gets the compositionDuration value for this SegmentDescriptionType.
     * 
     * @return compositionDuration
     */
    public long getCompositionDuration() {
        return compositionDuration;
    }


    /**
     * Sets the compositionDuration value for this SegmentDescriptionType.
     * 
     * @param compositionDuration
     */
    public void setCompositionDuration(long compositionDuration) {
        this.compositionDuration = compositionDuration;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SegmentDescriptionType)) return false;
        SegmentDescriptionType other = (SegmentDescriptionType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.assetDescription==null && other.getAssetDescription()==null) || 
             (this.assetDescription!=null &&
              this.assetDescription.equals(other.getAssetDescription()))) &&
            this.segmentMarkIn == other.getSegmentMarkIn() &&
            this.segmentDuration == other.getSegmentDuration() &&
            ((this.segmentTrack==null && other.getSegmentTrack()==null) || 
             (this.segmentTrack!=null &&
              this.segmentTrack.equals(other.getSegmentTrack()))) &&
            ((this.segmentFileMOB==null && other.getSegmentFileMOB()==null) || 
             (this.segmentFileMOB!=null &&
              this.segmentFileMOB.equals(other.getSegmentFileMOB()))) &&
            this.segmentStartOffset == other.getSegmentStartOffset() &&
            this.compositionPosition == other.getCompositionPosition() &&
            ((this.compositionTrack==null && other.getCompositionTrack()==null) || 
             (this.compositionTrack!=null &&
              this.compositionTrack.equals(other.getCompositionTrack()))) &&
            this.compositionDuration == other.getCompositionDuration();
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
        if (getAssetDescription() != null) {
            _hashCode += getAssetDescription().hashCode();
        }
        _hashCode += new Long(getSegmentMarkIn()).hashCode();
        _hashCode += new Long(getSegmentDuration()).hashCode();
        if (getSegmentTrack() != null) {
            _hashCode += getSegmentTrack().hashCode();
        }
        if (getSegmentFileMOB() != null) {
            _hashCode += getSegmentFileMOB().hashCode();
        }
        _hashCode += new Long(getSegmentStartOffset()).hashCode();
        _hashCode += new Long(getCompositionPosition()).hashCode();
        if (getCompositionTrack() != null) {
            _hashCode += getCompositionTrack().hashCode();
        }
        _hashCode += new Long(getCompositionDuration()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SegmentDescriptionType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SegmentDescriptionType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("assetDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AssetDescriptionType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segmentMarkIn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SegmentMarkIn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segmentDuration");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SegmentDuration"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segmentTrack");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SegmentTrack"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segmentFileMOB");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SegmentFileMOB"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segmentStartOffset");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SegmentStartOffset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("compositionPosition");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CompositionPosition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("compositionTrack");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CompositionTrack"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("compositionDuration");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CompositionDuration"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
