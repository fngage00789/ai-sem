/**
 * BAPI1011_DETAIL.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package th.co.ais.webservice.masterbank.bean;

public class BAPI1011_DETAIL  implements java.io.Serializable {
    private java.lang.String CREAT_DATE;

    private java.lang.String CREATOR;

    private java.lang.String METHOD;

    private java.lang.String FORMATTING;

    private java.lang.String BANK_DELETE;

    private java.lang.String IBAN_RULE;

    private java.lang.String b2B_SUPPORTED;

    private java.lang.String COR1_SUPPORTED;

    private java.lang.String r_TRANSACTION_SUPPORTED;

    public BAPI1011_DETAIL() {
    }

    public BAPI1011_DETAIL(
           java.lang.String CREAT_DATE,
           java.lang.String CREATOR,
           java.lang.String METHOD,
           java.lang.String FORMATTING,
           java.lang.String BANK_DELETE,
           java.lang.String IBAN_RULE,
           java.lang.String b2B_SUPPORTED,
           java.lang.String COR1_SUPPORTED,
           java.lang.String r_TRANSACTION_SUPPORTED) {
           this.CREAT_DATE = CREAT_DATE;
           this.CREATOR = CREATOR;
           this.METHOD = METHOD;
           this.FORMATTING = FORMATTING;
           this.BANK_DELETE = BANK_DELETE;
           this.IBAN_RULE = IBAN_RULE;
           this.b2B_SUPPORTED = b2B_SUPPORTED;
           this.COR1_SUPPORTED = COR1_SUPPORTED;
           this.r_TRANSACTION_SUPPORTED = r_TRANSACTION_SUPPORTED;
    }


    /**
     * Gets the CREAT_DATE value for this BAPI1011_DETAIL.
     * 
     * @return CREAT_DATE
     */
    public java.lang.String getCREAT_DATE() {
        return CREAT_DATE;
    }


    /**
     * Sets the CREAT_DATE value for this BAPI1011_DETAIL.
     * 
     * @param CREAT_DATE
     */
    public void setCREAT_DATE(java.lang.String CREAT_DATE) {
        this.CREAT_DATE = CREAT_DATE;
    }


    /**
     * Gets the CREATOR value for this BAPI1011_DETAIL.
     * 
     * @return CREATOR
     */
    public java.lang.String getCREATOR() {
        return CREATOR;
    }


    /**
     * Sets the CREATOR value for this BAPI1011_DETAIL.
     * 
     * @param CREATOR
     */
    public void setCREATOR(java.lang.String CREATOR) {
        this.CREATOR = CREATOR;
    }


    /**
     * Gets the METHOD value for this BAPI1011_DETAIL.
     * 
     * @return METHOD
     */
    public java.lang.String getMETHOD() {
        return METHOD;
    }


    /**
     * Sets the METHOD value for this BAPI1011_DETAIL.
     * 
     * @param METHOD
     */
    public void setMETHOD(java.lang.String METHOD) {
        this.METHOD = METHOD;
    }


    /**
     * Gets the FORMATTING value for this BAPI1011_DETAIL.
     * 
     * @return FORMATTING
     */
    public java.lang.String getFORMATTING() {
        return FORMATTING;
    }


    /**
     * Sets the FORMATTING value for this BAPI1011_DETAIL.
     * 
     * @param FORMATTING
     */
    public void setFORMATTING(java.lang.String FORMATTING) {
        this.FORMATTING = FORMATTING;
    }


    /**
     * Gets the BANK_DELETE value for this BAPI1011_DETAIL.
     * 
     * @return BANK_DELETE
     */
    public java.lang.String getBANK_DELETE() {
        return BANK_DELETE;
    }


    /**
     * Sets the BANK_DELETE value for this BAPI1011_DETAIL.
     * 
     * @param BANK_DELETE
     */
    public void setBANK_DELETE(java.lang.String BANK_DELETE) {
        this.BANK_DELETE = BANK_DELETE;
    }


    /**
     * Gets the IBAN_RULE value for this BAPI1011_DETAIL.
     * 
     * @return IBAN_RULE
     */
    public java.lang.String getIBAN_RULE() {
        return IBAN_RULE;
    }


    /**
     * Sets the IBAN_RULE value for this BAPI1011_DETAIL.
     * 
     * @param IBAN_RULE
     */
    public void setIBAN_RULE(java.lang.String IBAN_RULE) {
        this.IBAN_RULE = IBAN_RULE;
    }


    /**
     * Gets the b2B_SUPPORTED value for this BAPI1011_DETAIL.
     * 
     * @return b2B_SUPPORTED
     */
    public java.lang.String getB2B_SUPPORTED() {
        return b2B_SUPPORTED;
    }


    /**
     * Sets the b2B_SUPPORTED value for this BAPI1011_DETAIL.
     * 
     * @param b2B_SUPPORTED
     */
    public void setB2B_SUPPORTED(java.lang.String b2B_SUPPORTED) {
        this.b2B_SUPPORTED = b2B_SUPPORTED;
    }


    /**
     * Gets the COR1_SUPPORTED value for this BAPI1011_DETAIL.
     * 
     * @return COR1_SUPPORTED
     */
    public java.lang.String getCOR1_SUPPORTED() {
        return COR1_SUPPORTED;
    }


    /**
     * Sets the COR1_SUPPORTED value for this BAPI1011_DETAIL.
     * 
     * @param COR1_SUPPORTED
     */
    public void setCOR1_SUPPORTED(java.lang.String COR1_SUPPORTED) {
        this.COR1_SUPPORTED = COR1_SUPPORTED;
    }


    /**
     * Gets the r_TRANSACTION_SUPPORTED value for this BAPI1011_DETAIL.
     * 
     * @return r_TRANSACTION_SUPPORTED
     */
    public java.lang.String getR_TRANSACTION_SUPPORTED() {
        return r_TRANSACTION_SUPPORTED;
    }


    /**
     * Sets the r_TRANSACTION_SUPPORTED value for this BAPI1011_DETAIL.
     * 
     * @param r_TRANSACTION_SUPPORTED
     */
    public void setR_TRANSACTION_SUPPORTED(java.lang.String r_TRANSACTION_SUPPORTED) {
        this.r_TRANSACTION_SUPPORTED = r_TRANSACTION_SUPPORTED;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BAPI1011_DETAIL)) return false;
        BAPI1011_DETAIL other = (BAPI1011_DETAIL) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.CREAT_DATE==null && other.getCREAT_DATE()==null) || 
             (this.CREAT_DATE!=null &&
              this.CREAT_DATE.equals(other.getCREAT_DATE()))) &&
            ((this.CREATOR==null && other.getCREATOR()==null) || 
             (this.CREATOR!=null &&
              this.CREATOR.equals(other.getCREATOR()))) &&
            ((this.METHOD==null && other.getMETHOD()==null) || 
             (this.METHOD!=null &&
              this.METHOD.equals(other.getMETHOD()))) &&
            ((this.FORMATTING==null && other.getFORMATTING()==null) || 
             (this.FORMATTING!=null &&
              this.FORMATTING.equals(other.getFORMATTING()))) &&
            ((this.BANK_DELETE==null && other.getBANK_DELETE()==null) || 
             (this.BANK_DELETE!=null &&
              this.BANK_DELETE.equals(other.getBANK_DELETE()))) &&
            ((this.IBAN_RULE==null && other.getIBAN_RULE()==null) || 
             (this.IBAN_RULE!=null &&
              this.IBAN_RULE.equals(other.getIBAN_RULE()))) &&
            ((this.b2B_SUPPORTED==null && other.getB2B_SUPPORTED()==null) || 
             (this.b2B_SUPPORTED!=null &&
              this.b2B_SUPPORTED.equals(other.getB2B_SUPPORTED()))) &&
            ((this.COR1_SUPPORTED==null && other.getCOR1_SUPPORTED()==null) || 
             (this.COR1_SUPPORTED!=null &&
              this.COR1_SUPPORTED.equals(other.getCOR1_SUPPORTED()))) &&
            ((this.r_TRANSACTION_SUPPORTED==null && other.getR_TRANSACTION_SUPPORTED()==null) || 
             (this.r_TRANSACTION_SUPPORTED!=null &&
              this.r_TRANSACTION_SUPPORTED.equals(other.getR_TRANSACTION_SUPPORTED())));
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
        if (getCREAT_DATE() != null) {
            _hashCode += getCREAT_DATE().hashCode();
        }
        if (getCREATOR() != null) {
            _hashCode += getCREATOR().hashCode();
        }
        if (getMETHOD() != null) {
            _hashCode += getMETHOD().hashCode();
        }
        if (getFORMATTING() != null) {
            _hashCode += getFORMATTING().hashCode();
        }
        if (getBANK_DELETE() != null) {
            _hashCode += getBANK_DELETE().hashCode();
        }
        if (getIBAN_RULE() != null) {
            _hashCode += getIBAN_RULE().hashCode();
        }
        if (getB2B_SUPPORTED() != null) {
            _hashCode += getB2B_SUPPORTED().hashCode();
        }
        if (getCOR1_SUPPORTED() != null) {
            _hashCode += getCOR1_SUPPORTED().hashCode();
        }
        if (getR_TRANSACTION_SUPPORTED() != null) {
            _hashCode += getR_TRANSACTION_SUPPORTED().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BAPI1011_DETAIL.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "BAPI1011_DETAIL"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CREAT_DATE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CREAT_DATE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CREATOR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CREATOR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("METHOD");
        elemField.setXmlName(new javax.xml.namespace.QName("", "METHOD"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FORMATTING");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FORMATTING"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BANK_DELETE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BANK_DELETE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IBAN_RULE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IBAN_RULE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("b2B_SUPPORTED");
        elemField.setXmlName(new javax.xml.namespace.QName("", "B2B_SUPPORTED"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COR1_SUPPORTED");
        elemField.setXmlName(new javax.xml.namespace.QName("", "COR1_SUPPORTED"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("r_TRANSACTION_SUPPORTED");
        elemField.setXmlName(new javax.xml.namespace.QName("", "R_TRANSACTION_SUPPORTED"));
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

    
	@Override
	public String toString() {
		return "BAPI1011_DETAIL [BANK_DELETE=" + BANK_DELETE
				+ ", COR1_SUPPORTED=" + COR1_SUPPORTED + ", CREATOR=" + CREATOR
				+ ", CREAT_DATE=" + CREAT_DATE + ", FORMATTING=" + FORMATTING
				+ ", IBAN_RULE=" + IBAN_RULE + ", METHOD=" + METHOD
				+ ", __equalsCalc=" + __equalsCalc + ", __hashCodeCalc="
				+ __hashCodeCalc + ", b2B_SUPPORTED=" + b2B_SUPPORTED
				+ ", r_TRANSACTION_SUPPORTED=" + r_TRANSACTION_SUPPORTED + "]";
	}

	
}
