/**
 * ZGEMAIL.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package th.co.ais.webservice.getven.bean;

public class ZGEMAIL  implements java.io.Serializable {
    private java.lang.String SMTP_ADDR;

    private java.lang.String FLGDEFAULT;

    private java.lang.String FLG_NOUSE;

    private java.lang.String REMARK;

    private java.lang.String CONSNUMBER;

    public ZGEMAIL() {
    }

    public ZGEMAIL(
           java.lang.String SMTP_ADDR,
           java.lang.String FLGDEFAULT,
           java.lang.String FLG_NOUSE,
           java.lang.String REMARK,
           java.lang.String CONSNUMBER) {
           this.SMTP_ADDR = SMTP_ADDR;
           this.FLGDEFAULT = FLGDEFAULT;
           this.FLG_NOUSE = FLG_NOUSE;
           this.REMARK = REMARK;
           this.CONSNUMBER = CONSNUMBER;
    }


    /**
     * Gets the SMTP_ADDR value for this ZGEMAIL.
     * 
     * @return SMTP_ADDR
     */
    public java.lang.String getSMTP_ADDR() {
        return SMTP_ADDR;
    }


    /**
     * Sets the SMTP_ADDR value for this ZGEMAIL.
     * 
     * @param SMTP_ADDR
     */
    public void setSMTP_ADDR(java.lang.String SMTP_ADDR) {
        this.SMTP_ADDR = SMTP_ADDR;
    }


    /**
     * Gets the FLGDEFAULT value for this ZGEMAIL.
     * 
     * @return FLGDEFAULT
     */
    public java.lang.String getFLGDEFAULT() {
        return FLGDEFAULT;
    }


    /**
     * Sets the FLGDEFAULT value for this ZGEMAIL.
     * 
     * @param FLGDEFAULT
     */
    public void setFLGDEFAULT(java.lang.String FLGDEFAULT) {
        this.FLGDEFAULT = FLGDEFAULT;
    }


    /**
     * Gets the FLG_NOUSE value for this ZGEMAIL.
     * 
     * @return FLG_NOUSE
     */
    public java.lang.String getFLG_NOUSE() {
        return FLG_NOUSE;
    }


    /**
     * Sets the FLG_NOUSE value for this ZGEMAIL.
     * 
     * @param FLG_NOUSE
     */
    public void setFLG_NOUSE(java.lang.String FLG_NOUSE) {
        this.FLG_NOUSE = FLG_NOUSE;
    }


    /**
     * Gets the REMARK value for this ZGEMAIL.
     * 
     * @return REMARK
     */
    public java.lang.String getREMARK() {
        return REMARK;
    }


    /**
     * Sets the REMARK value for this ZGEMAIL.
     * 
     * @param REMARK
     */
    public void setREMARK(java.lang.String REMARK) {
        this.REMARK = REMARK;
    }


    /**
     * Gets the CONSNUMBER value for this ZGEMAIL.
     * 
     * @return CONSNUMBER
     */
    public java.lang.String getCONSNUMBER() {
        return CONSNUMBER;
    }


    /**
     * Sets the CONSNUMBER value for this ZGEMAIL.
     * 
     * @param CONSNUMBER
     */
    public void setCONSNUMBER(java.lang.String CONSNUMBER) {
        this.CONSNUMBER = CONSNUMBER;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZGEMAIL)) return false;
        ZGEMAIL other = (ZGEMAIL) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.SMTP_ADDR==null && other.getSMTP_ADDR()==null) || 
             (this.SMTP_ADDR!=null &&
              this.SMTP_ADDR.equals(other.getSMTP_ADDR()))) &&
            ((this.FLGDEFAULT==null && other.getFLGDEFAULT()==null) || 
             (this.FLGDEFAULT!=null &&
              this.FLGDEFAULT.equals(other.getFLGDEFAULT()))) &&
            ((this.FLG_NOUSE==null && other.getFLG_NOUSE()==null) || 
             (this.FLG_NOUSE!=null &&
              this.FLG_NOUSE.equals(other.getFLG_NOUSE()))) &&
            ((this.REMARK==null && other.getREMARK()==null) || 
             (this.REMARK!=null &&
              this.REMARK.equals(other.getREMARK()))) &&
            ((this.CONSNUMBER==null && other.getCONSNUMBER()==null) || 
             (this.CONSNUMBER!=null &&
              this.CONSNUMBER.equals(other.getCONSNUMBER())));
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
        if (getSMTP_ADDR() != null) {
            _hashCode += getSMTP_ADDR().hashCode();
        }
        if (getFLGDEFAULT() != null) {
            _hashCode += getFLGDEFAULT().hashCode();
        }
        if (getFLG_NOUSE() != null) {
            _hashCode += getFLG_NOUSE().hashCode();
        }
        if (getREMARK() != null) {
            _hashCode += getREMARK().hashCode();
        }
        if (getCONSNUMBER() != null) {
            _hashCode += getCONSNUMBER().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZGEMAIL.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZGEMAIL"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SMTP_ADDR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SMTP_ADDR"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONSNUMBER");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CONSNUMBER"));
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
