/**
 * CreateMasterClipType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;


/**
 * The parameters of the CreateMasterClip operation. DestinationFolderURI
 * indicates where the new masterclip
 *         should be checked in. Other parameters include ClipName, Timebase
 * (i.e., 25p, 30i, 30i_df, etc),
 *         StartTimecode, Duration or EndTimecode (choose one), whether
 * or not there is a Video track, number of
 *         AudioTracks, an optional SourceID (if blank, one will be generated),
 * and an optional set of Attributes to set.
 */
public class CreateMasterClipType  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType {
    private java.lang.String destinationFolderURI;

    private java.lang.String clipID;

    private java.lang.String clipName;

    private java.lang.String timebase;

    private java.lang.String tapeName;

    private java.lang.String startTimecode;

    private java.lang.Long duration;

    private java.lang.String endTimecode;

    private boolean video;

    private int audioTracks;

    private java.lang.String sourceID;

    private java.lang.String sourceMobType;

    private java.lang.Integer sourceMobOffset;

    private java.lang.Integer boxX;

    private java.lang.Integer boxY;

    private java.lang.Integer boxHeight;

    private java.lang.Integer boxWidth;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[] attributes;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension;

    private org.apache.axis.message.MessageElement [] _any;

    public CreateMasterClipType() {
    }

    public CreateMasterClipType(
           java.lang.String destinationFolderURI,
           java.lang.String clipID,
           java.lang.String clipName,
           java.lang.String timebase,
           java.lang.String tapeName,
           java.lang.String startTimecode,
           java.lang.Long duration,
           java.lang.String endTimecode,
           boolean video,
           int audioTracks,
           java.lang.String sourceID,
           java.lang.String sourceMobType,
           java.lang.Integer sourceMobOffset,
           java.lang.Integer boxX,
           java.lang.Integer boxY,
           java.lang.Integer boxHeight,
           java.lang.Integer boxWidth,
           com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[] attributes,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension,
           org.apache.axis.message.MessageElement [] _any) {
           this.destinationFolderURI = destinationFolderURI;
           this.clipID = clipID;
           this.clipName = clipName;
           this.timebase = timebase;
           this.tapeName = tapeName;
           this.startTimecode = startTimecode;
           this.duration = duration;
           this.endTimecode = endTimecode;
           this.video = video;
           this.audioTracks = audioTracks;
           this.sourceID = sourceID;
           this.sourceMobType = sourceMobType;
           this.sourceMobOffset = sourceMobOffset;
           this.boxX = boxX;
           this.boxY = boxY;
           this.boxHeight = boxHeight;
           this.boxWidth = boxWidth;
           this.attributes = attributes;
           this.extension = extension;
           this._any = _any;
    }


    /**
     * Gets the destinationFolderURI value for this CreateMasterClipType.
     * 
     * @return destinationFolderURI
     */
    public java.lang.String getDestinationFolderURI() {
        return destinationFolderURI;
    }


    /**
     * Sets the destinationFolderURI value for this CreateMasterClipType.
     * 
     * @param destinationFolderURI
     */
    public void setDestinationFolderURI(java.lang.String destinationFolderURI) {
        this.destinationFolderURI = destinationFolderURI;
    }


    /**
     * Gets the clipID value for this CreateMasterClipType.
     * 
     * @return clipID
     */
    public java.lang.String getClipID() {
        return clipID;
    }


    /**
     * Sets the clipID value for this CreateMasterClipType.
     * 
     * @param clipID
     */
    public void setClipID(java.lang.String clipID) {
        this.clipID = clipID;
    }


    /**
     * Gets the clipName value for this CreateMasterClipType.
     * 
     * @return clipName
     */
    public java.lang.String getClipName() {
        return clipName;
    }


    /**
     * Sets the clipName value for this CreateMasterClipType.
     * 
     * @param clipName
     */
    public void setClipName(java.lang.String clipName) {
        this.clipName = clipName;
    }


    /**
     * Gets the timebase value for this CreateMasterClipType.
     * 
     * @return timebase
     */
    public java.lang.String getTimebase() {
        return timebase;
    }


    /**
     * Sets the timebase value for this CreateMasterClipType.
     * 
     * @param timebase
     */
    public void setTimebase(java.lang.String timebase) {
        this.timebase = timebase;
    }


    /**
     * Gets the tapeName value for this CreateMasterClipType.
     * 
     * @return tapeName
     */
    public java.lang.String getTapeName() {
        return tapeName;
    }


    /**
     * Sets the tapeName value for this CreateMasterClipType.
     * 
     * @param tapeName
     */
    public void setTapeName(java.lang.String tapeName) {
        this.tapeName = tapeName;
    }


    /**
     * Gets the startTimecode value for this CreateMasterClipType.
     * 
     * @return startTimecode
     */
    public java.lang.String getStartTimecode() {
        return startTimecode;
    }


    /**
     * Sets the startTimecode value for this CreateMasterClipType.
     * 
     * @param startTimecode
     */
    public void setStartTimecode(java.lang.String startTimecode) {
        this.startTimecode = startTimecode;
    }


    /**
     * Gets the duration value for this CreateMasterClipType.
     * 
     * @return duration
     */
    public java.lang.Long getDuration() {
        return duration;
    }


    /**
     * Sets the duration value for this CreateMasterClipType.
     * 
     * @param duration
     */
    public void setDuration(java.lang.Long duration) {
        this.duration = duration;
    }


    /**
     * Gets the endTimecode value for this CreateMasterClipType.
     * 
     * @return endTimecode
     */
    public java.lang.String getEndTimecode() {
        return endTimecode;
    }


    /**
     * Sets the endTimecode value for this CreateMasterClipType.
     * 
     * @param endTimecode
     */
    public void setEndTimecode(java.lang.String endTimecode) {
        this.endTimecode = endTimecode;
    }


    /**
     * Gets the video value for this CreateMasterClipType.
     * 
     * @return video
     */
    public boolean isVideo() {
        return video;
    }


    /**
     * Sets the video value for this CreateMasterClipType.
     * 
     * @param video
     */
    public void setVideo(boolean video) {
        this.video = video;
    }


    /**
     * Gets the audioTracks value for this CreateMasterClipType.
     * 
     * @return audioTracks
     */
    public int getAudioTracks() {
        return audioTracks;
    }


    /**
     * Sets the audioTracks value for this CreateMasterClipType.
     * 
     * @param audioTracks
     */
    public void setAudioTracks(int audioTracks) {
        this.audioTracks = audioTracks;
    }


    /**
     * Gets the sourceID value for this CreateMasterClipType.
     * 
     * @return sourceID
     */
    public java.lang.String getSourceID() {
        return sourceID;
    }


    /**
     * Sets the sourceID value for this CreateMasterClipType.
     * 
     * @param sourceID
     */
    public void setSourceID(java.lang.String sourceID) {
        this.sourceID = sourceID;
    }


    /**
     * Gets the sourceMobType value for this CreateMasterClipType.
     * 
     * @return sourceMobType
     */
    public java.lang.String getSourceMobType() {
        return sourceMobType;
    }


    /**
     * Sets the sourceMobType value for this CreateMasterClipType.
     * 
     * @param sourceMobType
     */
    public void setSourceMobType(java.lang.String sourceMobType) {
        this.sourceMobType = sourceMobType;
    }


    /**
     * Gets the sourceMobOffset value for this CreateMasterClipType.
     * 
     * @return sourceMobOffset
     */
    public java.lang.Integer getSourceMobOffset() {
        return sourceMobOffset;
    }


    /**
     * Sets the sourceMobOffset value for this CreateMasterClipType.
     * 
     * @param sourceMobOffset
     */
    public void setSourceMobOffset(java.lang.Integer sourceMobOffset) {
        this.sourceMobOffset = sourceMobOffset;
    }


    /**
     * Gets the boxX value for this CreateMasterClipType.
     * 
     * @return boxX
     */
    public java.lang.Integer getBoxX() {
        return boxX;
    }


    /**
     * Sets the boxX value for this CreateMasterClipType.
     * 
     * @param boxX
     */
    public void setBoxX(java.lang.Integer boxX) {
        this.boxX = boxX;
    }


    /**
     * Gets the boxY value for this CreateMasterClipType.
     * 
     * @return boxY
     */
    public java.lang.Integer getBoxY() {
        return boxY;
    }


    /**
     * Sets the boxY value for this CreateMasterClipType.
     * 
     * @param boxY
     */
    public void setBoxY(java.lang.Integer boxY) {
        this.boxY = boxY;
    }


    /**
     * Gets the boxHeight value for this CreateMasterClipType.
     * 
     * @return boxHeight
     */
    public java.lang.Integer getBoxHeight() {
        return boxHeight;
    }


    /**
     * Sets the boxHeight value for this CreateMasterClipType.
     * 
     * @param boxHeight
     */
    public void setBoxHeight(java.lang.Integer boxHeight) {
        this.boxHeight = boxHeight;
    }


    /**
     * Gets the boxWidth value for this CreateMasterClipType.
     * 
     * @return boxWidth
     */
    public java.lang.Integer getBoxWidth() {
        return boxWidth;
    }


    /**
     * Sets the boxWidth value for this CreateMasterClipType.
     * 
     * @param boxWidth
     */
    public void setBoxWidth(java.lang.Integer boxWidth) {
        this.boxWidth = boxWidth;
    }


    /**
     * Gets the attributes value for this CreateMasterClipType.
     * 
     * @return attributes
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[] getAttributes() {
        return attributes;
    }


    /**
     * Sets the attributes value for this CreateMasterClipType.
     * 
     * @param attributes
     */
    public void setAttributes(com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[] attributes) {
        this.attributes = attributes;
    }


    /**
     * Gets the extension value for this CreateMasterClipType.
     * 
     * @return extension
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this CreateMasterClipType.
     * 
     * @param extension
     */
    public void setExtension(com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension) {
        this.extension = extension;
    }


    /**
     * Gets the _any value for this CreateMasterClipType.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this CreateMasterClipType.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CreateMasterClipType)) return false;
        CreateMasterClipType other = (CreateMasterClipType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.destinationFolderURI==null && other.getDestinationFolderURI()==null) || 
             (this.destinationFolderURI!=null &&
              this.destinationFolderURI.equals(other.getDestinationFolderURI()))) &&
            ((this.clipID==null && other.getClipID()==null) || 
             (this.clipID!=null &&
              this.clipID.equals(other.getClipID()))) &&
            ((this.clipName==null && other.getClipName()==null) || 
             (this.clipName!=null &&
              this.clipName.equals(other.getClipName()))) &&
            ((this.timebase==null && other.getTimebase()==null) || 
             (this.timebase!=null &&
              this.timebase.equals(other.getTimebase()))) &&
            ((this.tapeName==null && other.getTapeName()==null) || 
             (this.tapeName!=null &&
              this.tapeName.equals(other.getTapeName()))) &&
            ((this.startTimecode==null && other.getStartTimecode()==null) || 
             (this.startTimecode!=null &&
              this.startTimecode.equals(other.getStartTimecode()))) &&
            ((this.duration==null && other.getDuration()==null) || 
             (this.duration!=null &&
              this.duration.equals(other.getDuration()))) &&
            ((this.endTimecode==null && other.getEndTimecode()==null) || 
             (this.endTimecode!=null &&
              this.endTimecode.equals(other.getEndTimecode()))) &&
            this.video == other.isVideo() &&
            this.audioTracks == other.getAudioTracks() &&
            ((this.sourceID==null && other.getSourceID()==null) || 
             (this.sourceID!=null &&
              this.sourceID.equals(other.getSourceID()))) &&
            ((this.sourceMobType==null && other.getSourceMobType()==null) || 
             (this.sourceMobType!=null &&
              this.sourceMobType.equals(other.getSourceMobType()))) &&
            ((this.sourceMobOffset==null && other.getSourceMobOffset()==null) || 
             (this.sourceMobOffset!=null &&
              this.sourceMobOffset.equals(other.getSourceMobOffset()))) &&
            ((this.boxX==null && other.getBoxX()==null) || 
             (this.boxX!=null &&
              this.boxX.equals(other.getBoxX()))) &&
            ((this.boxY==null && other.getBoxY()==null) || 
             (this.boxY!=null &&
              this.boxY.equals(other.getBoxY()))) &&
            ((this.boxHeight==null && other.getBoxHeight()==null) || 
             (this.boxHeight!=null &&
              this.boxHeight.equals(other.getBoxHeight()))) &&
            ((this.boxWidth==null && other.getBoxWidth()==null) || 
             (this.boxWidth!=null &&
              this.boxWidth.equals(other.getBoxWidth()))) &&
            ((this.attributes==null && other.getAttributes()==null) || 
             (this.attributes!=null &&
              java.util.Arrays.equals(this.attributes, other.getAttributes()))) &&
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
        if (getDestinationFolderURI() != null) {
            _hashCode += getDestinationFolderURI().hashCode();
        }
        if (getClipID() != null) {
            _hashCode += getClipID().hashCode();
        }
        if (getClipName() != null) {
            _hashCode += getClipName().hashCode();
        }
        if (getTimebase() != null) {
            _hashCode += getTimebase().hashCode();
        }
        if (getTapeName() != null) {
            _hashCode += getTapeName().hashCode();
        }
        if (getStartTimecode() != null) {
            _hashCode += getStartTimecode().hashCode();
        }
        if (getDuration() != null) {
            _hashCode += getDuration().hashCode();
        }
        if (getEndTimecode() != null) {
            _hashCode += getEndTimecode().hashCode();
        }
        _hashCode += (isVideo() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getAudioTracks();
        if (getSourceID() != null) {
            _hashCode += getSourceID().hashCode();
        }
        if (getSourceMobType() != null) {
            _hashCode += getSourceMobType().hashCode();
        }
        if (getSourceMobOffset() != null) {
            _hashCode += getSourceMobOffset().hashCode();
        }
        if (getBoxX() != null) {
            _hashCode += getBoxX().hashCode();
        }
        if (getBoxY() != null) {
            _hashCode += getBoxY().hashCode();
        }
        if (getBoxHeight() != null) {
            _hashCode += getBoxHeight().hashCode();
        }
        if (getBoxWidth() != null) {
            _hashCode += getBoxWidth().hashCode();
        }
        if (getAttributes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAttributes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAttributes(), i);
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
        new org.apache.axis.description.TypeDesc(CreateMasterClipType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CreateMasterClipType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destinationFolderURI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "DestinationFolderURI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clipID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ClipID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clipName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ClipName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timebase");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Timebase"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tapeName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "TapeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startTimecode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "StartTimecode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duration");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Duration"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endTimecode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "EndTimecode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("video");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Video"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("audioTracks");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AudioTracks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sourceID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SourceID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sourceMobType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SourceMobType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sourceMobOffset");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SourceMobOffset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("boxX");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "BoxX"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("boxY");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "BoxY"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("boxHeight");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "BoxHeight"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("boxWidth");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "BoxWidth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attributes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Attributes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AttributeType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Attribute"));
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
