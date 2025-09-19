/**
 * ZSEM_CRE_VEN_MOBILE_STRUC.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package th.co.ais.webservice.creven.bean;

public class ZSEM_CRE_VEN_MOBILE_STRUC  implements java.io.Serializable {
    private java.lang.String COUNTRY;

    private java.lang.String TEL_NUMBER;

    private java.lang.String FLGDEFAULT;

    private java.lang.String DFT_RECEIV;

    private java.lang.String FLG_NOUSE;

    private java.lang.String REMARK;

    public ZSEM_CRE_VEN_MOBILE_STRUC() {
    }

    public ZSEM_CRE_VEN_MOBILE_STRUC(
           java.lang.String COUNTRY,
           java.lang.String TEL_NUMBER,
           java.lang.String FLGDEFAULT,
           java.lang.String DFT_RECEIV,
           java.lang.String FLG_NOUSE,
           java.lang.String REMARK) {
           this.COUNTRY = COUNTRY;
           this.TEL_NUMBER = TEL_NUMBER;
           this.FLGDEFAULT = FLGDEFAULT;
           this.DFT_RECEIV = DFT_RECEIV;
           this.FLG_NOUSE = FLG_NOUSE;
           this.REMARK = REMARK;
    }


    /**
     * Gets the COUNTRY value for this ZSEM_CRE_VEN_MOBILE_STRUC.
     * 
     * @return COUNTRY
     */
    public java.lang.String getCOUNTRY() {
        return COUNTRY;
    }


    /**
     * Sets the COUNTRY value for this ZSEM_CRE_VEN_MOBILE_STRUC.
     * 
     * @param COUNTRY
     */
    public void setCOUNTRY(java.lang.String COUNTRY) {
        this.COUNTRY = COUNTRY;
    }


    /**
     * Gets the TEL_NUMBER value for this ZSEM_CRE_VEN_MOBILE_STRUC.
     * 
     * @return TEL_NUMBER
     */
    public java.lang.String getTEL_NUMBER() {
        return TEL_NUMBER;
    }


    /**
     * Sets the TEL_NUMBER value for this ZSEM_CRE_VEN_MOBILE_STRUC.
     * 
     * @param TEL_NUMBER
     */
    public void setTEL_NUMBER(java.lang.String TEL_NUMBER) {
        this.TEL_NUMBER = TEL_NUMBER;
    }


    /**
     * Gets the FLGDEFAULT value for this ZSEM_CRE_VEN_MOBILE_STRUC.
     * 
     * @return FLGDEFAULT
     */
    public java.lang.String getFLGDEFAULT() {
        return FLGDEFAULT;
    }


    /**
     * Sets the FLGDEFAULT value for this ZSEM_CRE_VEN_MOBILE_STRUC.
     * 
     * @param FLGDEFAULT
     */
    public void setFLGDEFAULT(java.lang.String FLGDEFAULT) {
        this.FLGDEFAULT = FLGDEFAULT;
    }


    /**
     * Gets the DFT_RECEIV value for this ZSEM_CRE_VEN_MOBILE_STRUC.
     * 
     * @return DFT_RECEIV
     */
    public java.lang.String getDFT_RECEIV() {
        return DFT_RECEIV;
    }


    /**
     * Sets the DFT_RECEIV value for this ZSEM_CRE_VEN_MOBILE_STRUC.
     * 
     * @param DFT_RECEIV
     */
    public void setDFT_RECEIV(java.lang.String DFT_RECEIV) {
        this.DFT_RECEIV = DFT_RECEIV;
    }


    /**
     * Gets the FLG_NOUSE value for this ZSEM_CRE_VEN_MOBILE_STRUC.
     * 
     * @return FLG_NOUSE
     */
    public java.lang.String getFLG_NOUSE() {
        return FLG_NOUSE;
    }


    /**
     * Sets the FLG_NOUSE value for this ZSEM_CRE_VEN_MOBILE_STRUC.
     * 
     * @param FLG_NOUSE
     */
    public void setFLG_NOUSE(java.lang.String FLG_NOUSE) {
        this.FLG_NOUSE = FLG_NOUSE;
    }


    /**
     * Gets the REMARK value for this ZSEM_CRE_VEN_MOBILE_STRUC.
     * 
     * @return REMARK
     */
    public java.lang.String getREMARK() {
        return REMARK;
    }


    /**
     * Sets the REMARK value for this ZSEM_CRE_VEN_MOBILE_STRUC.
     * 
     * @param REMARK
     */
    public void setREMARK(java.lang.String REMARK) {
        this.REMARK = REMARK;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZSEM_CRE_VEN_MOBILE_STRUC)) return false;
        ZSEM_CRE_VEN_MOBILE_STRUC other = (ZSEM_CRE_VEN_MOBILE_STRUC) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.COUNTRY==null && other.getCOUNTRY()==null) || 
             (this.COUNTRY!=null &&
              this.COUNTRY.equals(other.getCOUNTRY()))) &&
            ((this.TEL_NUMBER==null && other.getTEL_NUMBER()==null) || 
             (this.TEL_NUMBER!=null &&
              this.TEL_NUMBER.equals(other.getTEL_NUMBER()))) &&
            ((this.FLGDEFAULT==null && other.getFLGDEFAULT()==null) || 
             (this.FLGDEFAULT!=null &&
              this.FLGDEFAULT.equals(other.getFLGDEFAULT()))) &&
            ((this.DFT_RECEIV==null && other.getDFT_RECEIV()==null) || 
             (this.DFT_RECEIV!=null &&
              this.DFT_RECEIV.equals(other.getDFT_RECEIV()))) &&
            ((this.FLG_NOUSE==null && other.getFLG_NOUSE()==null) || 
             (this.FLG_NOUSE!=null &&
              this.FLG_NOUSE.equals(other.getFLG_NOUSE()))) &&
            ((this.REMARK==null && other.getREMARK()==null) || 
             (this.REMARK!=null &&
              this.REMARK.equals(other.getREMARK())));
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
        if (getCOUNTRY() != null) {
            _hashCode += getCOUNTRY().hashCode();
        }
        if (getTEL_NUMBER() != null) {
            _hashCode += getTEL_NUMBER().hashCode();
        }
        if (getFLGDEFAULT() != null) {
            _hashCode += getFLGDEFAULT().hashCode();
        }
        if (getDFT_RECEIV() != null) {
            _hashCode += getDFT_RECEIV().hashCode();
        }
        if (getFLG_NOUSE() != null) {
            _hashCode += getFLG_NOUSE().hashCode();
        }
        if (getREMARK() != null) {
            _hashCode += getREMARK().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZSEM_CRE_VEN_MOBILE_STRUC.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZSEM_CRE_VEN_MOBILE_STRUC"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COUNTRY");
        elemField.setXmlName(new javax.xml.namespace.QName("", "COUNTRY"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TEL_NUMBER");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TEL_NUMBER"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLGDEFAULT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FLGDEFAULT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DFT_RECEIV");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DFT_RECEIV"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLG_NOUSE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FLG_NOUSE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("REMARK");
        elemField.setXmlName(new javax.xml.namespace.QName("", "REMARK"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
