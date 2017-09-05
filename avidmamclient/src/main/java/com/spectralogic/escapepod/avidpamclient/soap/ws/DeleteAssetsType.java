/**
 * DeleteAssetsType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;


/**
 * Parameters for the DeleteAssets operation. If DeleteMetadata is
 * set to true, then the system will
 *         attempt to delete the metadata files from the Interplay Engine.
 * If DeleteMedia is set to true, then the system will
 *         attempt to delete the media files from shared storage. If
 * resolutions are specified, only the specified
 *         resolutions of the media files will be deleted; otherwise
 * all resolutions are deleted. If Simulation is set to
 *         true, then nothing will actually be deleted, but a report
 * will be returned indicating what would have been
 *         deleted.
 */
public class DeleteAssetsType  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType {
    private java.lang.String[] interplayURIs;

    private java.lang.Boolean deleteMetadata;

    private boolean deleteMedia;

    private java.lang.String[] resolutions;

    private java.lang.Boolean simulation;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension;

    private org.apache.axis.message.MessageElement [] _any;

    public DeleteAssetsType() {
    }

    public DeleteAssetsType(
           java.lang.String[] interplayURIs,
           java.lang.Boolean deleteMetadata,
           boolean deleteMedia,
           java.lang.String[] resolutions,
           java.lang.Boolean simulation,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension,
           org.apache.axis.message.MessageElement [] _any) {
           this.interplayURIs = interplayURIs;
           this.deleteMetadata = deleteMetadata;
           this.deleteMedia = deleteMedia;
           this.resolutions = resolutions;
           this.simulation = simulation;
           this.extension = extension;
           this._any = _any;
    }


    /**
     * Gets the interplayURIs value for this DeleteAssetsType.
     * 
     * @return interplayURIs
     */
    public java.lang.String[] getInterplayURIs() {
        return interplayURIs;
    }


    /**
     * Sets the interplayURIs value for this DeleteAssetsType.
     * 
     * @param interplayURIs
     */
    public void setInterplayURIs(java.lang.String[] interplayURIs) {
        this.interplayURIs = interplayURIs;
    }


    /**
     * Gets the deleteMetadata value for this DeleteAssetsType.
     * 
     * @return deleteMetadata
     */
    public java.lang.Boolean getDeleteMetadata() {
        return deleteMetadata;
    }


    /**
     * Sets the deleteMetadata value for this DeleteAssetsType.
     * 
     * @param deleteMetadata
     */
    public void setDeleteMetadata(java.lang.Boolean deleteMetadata) {
        this.deleteMetadata = deleteMetadata;
    }


    /**
     * Gets the deleteMedia value for this DeleteAssetsType.
     * 
     * @return deleteMedia
     */
    public boolean isDeleteMedia() {
        return deleteMedia;
    }


    /**
     * Sets the deleteMedia value for this DeleteAssetsType.
     * 
     * @param deleteMedia
     */
    public void setDeleteMedia(boolean deleteMedia) {
        this.deleteMedia = deleteMedia;
    }


    /**
     * Gets the resolutions value for this DeleteAssetsType.
     * 
     * @return resolutions
     */
    public java.lang.String[] getResolutions() {
        return resolutions;
    }


    /**
     * Sets the resolutions value for this DeleteAssetsType.
     * 
     * @param resolutions
     */
    public void setResolutions(java.lang.String[] resolutions) {
        this.resolutions = resolutions;
    }


    /**
     * Gets the simulation value for this DeleteAssetsType.
     * 
     * @return simulation
     */
    public java.lang.Boolean getSimulation() {
        return simulation;
    }


    /**
     * Sets the simulation value for this DeleteAssetsType.
     * 
     * @param simulation
     */
    public void setSimulation(java.lang.Boolean simulation) {
        this.simulation = simulation;
    }


    /**
     * Gets the extension value for this DeleteAssetsType.
     * 
     * @return extension
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this DeleteAssetsType.
     * 
     * @param extension
     */
    public void setExtension(com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension) {
        this.extension = extension;
    }


    /**
     * Gets the _any value for this DeleteAssetsType.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this DeleteAssetsType.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DeleteAssetsType)) return false;
        DeleteAssetsType other = (DeleteAssetsType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.interplayURIs==null && other.getInterplayURIs()==null) || 
             (this.interplayURIs!=null &&
              java.util.Arrays.equals(this.interplayURIs, other.getInterplayURIs()))) &&
            ((this.deleteMetadata==null && other.getDeleteMetadata()==null) || 
             (this.deleteMetadata!=null &&
              this.deleteMetadata.equals(other.getDeleteMetadata()))) &&
            this.deleteMedia == other.isDeleteMedia() &&
            ((this.resolutions==null && other.getResolutions()==null) || 
             (this.resolutions!=null &&
              java.util.Arrays.equals(this.resolutions, other.getResolutions()))) &&
            ((this.simulation==null && other.getSimulation()==null) || 
             (this.simulation!=null &&
              this.simulation.equals(other.getSimulation()))) &&
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
        if (getInterplayURIs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInterplayURIs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInterplayURIs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDeleteMetadata() != null) {
            _hashCode += getDeleteMetadata().hashCode();
        }
        _hashCode += (isDeleteMedia() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getResolutions() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getResolutions());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getResolutions(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSimulation() != null) {
            _hashCode += getSimulation().hashCode();
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
        new org.apache.axis.description.TypeDesc(DeleteAssetsType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "DeleteAssetsType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interplayURIs");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "InterplayURIs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "InterplayURI"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deleteMetadata");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "DeleteMetadata"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deleteMedia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "DeleteMedia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resolutions");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Resolutions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Resolution"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("simulation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Simulation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
