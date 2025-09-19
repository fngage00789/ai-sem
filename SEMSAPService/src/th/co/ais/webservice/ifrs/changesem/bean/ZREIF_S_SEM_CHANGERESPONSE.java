/**
 * ZREIF_S_SEM_CHANGERESPONSE.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package th.co.ais.webservice.ifrs.changesem.bean;


/**
 * SEM CONTRACT CREATION  RESPONSE
 */
public class ZREIF_S_SEM_CHANGERESPONSE  implements java.io.Serializable {
    private java.lang.String FILENAME;

    /* Activity */
    private java.lang.String ACTIVITY;

    /* Reference Id */
    private java.lang.String REFERENCE_ID;

    /* Company Code */
    private java.lang.String COMPANY_CODE;

    /* Number of old contract */
    private java.lang.String CONTRACT_NO;

    /* Contract Number */
    private java.lang.String REFX_NO;

    /* Status Code */
    private java.lang.String STATUS_CODE;

    /* Error Code */
    private java.lang.String ERROR_CODE;

    /* Message */
    private java.lang.String STATUS_MESSAGE;

    public ZREIF_S_SEM_CHANGERESPONSE() {
    }

    public ZREIF_S_SEM_CHANGERESPONSE(
           java.lang.String FILENAME,
           java.lang.String ACTIVITY,
           java.lang.String REFERENCE_ID,
           java.lang.String COMPANY_CODE,
           java.lang.String CONTRACT_NO,
           java.lang.String REFX_NO,
           java.lang.String STATUS_CODE,
           java.lang.String ERROR_CODE,
           java.lang.String STATUS_MESSAGE) {
           this.FILENAME = FILENAME;
           this.ACTIVITY = ACTIVITY;
           this.REFERENCE_ID = REFERENCE_ID;
           this.COMPANY_CODE = COMPANY_CODE;
           this.CONTRACT_NO = CONTRACT_NO;
           this.REFX_NO = REFX_NO;
           this.STATUS_CODE = STATUS_CODE;
           this.ERROR_CODE = ERROR_CODE;
           this.STATUS_MESSAGE = STATUS_MESSAGE;
    }


    /**
     * Gets the FILENAME value for this ZREIF_S_SEM_CHANGERESPONSE.
     * 
     * @return FILENAME
     */
    public java.lang.String getFILENAME() {
        return FILENAME;
    }


    /**
     * Sets the FILENAME value for this ZREIF_S_SEM_CHANGERESPONSE.
     * 
     * @param FILENAME
     */
    public void setFILENAME(java.lang.String FILENAME) {
        this.FILENAME = FILENAME;
    }


    /**
     * Gets the ACTIVITY value for this ZREIF_S_SEM_CHANGERESPONSE.
     * 
     * @return ACTIVITY   * Activity
     */
    public java.lang.String getACTIVITY() {
        return ACTIVITY;
    }


    /**
     * Sets the ACTIVITY value for this ZREIF_S_SEM_CHANGERESPONSE.
     * 
     * @param ACTIVITY   * Activity
     */
    public void setACTIVITY(java.lang.String ACTIVITY) {
        this.ACTIVITY = ACTIVITY;
    }


    /**
     * Gets the REFERENCE_ID value for this ZREIF_S_SEM_CHANGERESPONSE.
     * 
     * @return REFERENCE_ID   * Reference Id
     */
    public java.lang.String getREFERENCE_ID() {
        return REFERENCE_ID;
    }


    /**
     * Sets the REFERENCE_ID value for this ZREIF_S_SEM_CHANGERESPONSE.
     * 
     * @param REFERENCE_ID   * Reference Id
     */
    public void setREFERENCE_ID(java.lang.String REFERENCE_ID) {
        this.REFERENCE_ID = REFERENCE_ID;
    }


    /**
     * Gets the COMPANY_CODE value for this ZREIF_S_SEM_CHANGERESPONSE.
     * 
     * @return COMPANY_CODE   * Company Code
     */
    public java.lang.String getCOMPANY_CODE() {
        return COMPANY_CODE;
    }


    /**
     * Sets the COMPANY_CODE value for this ZREIF_S_SEM_CHANGERESPONSE.
     * 
     * @param COMPANY_CODE   * Company Code
     */
    public void setCOMPANY_CODE(java.lang.String COMPANY_CODE) {
        this.COMPANY_CODE = COMPANY_CODE;
    }


    /**
     * Gets the CONTRACT_NO value for this ZREIF_S_SEM_CHANGERESPONSE.
     * 
     * @return CONTRACT_NO   * Number of old contract
     */
    public java.lang.String getCONTRACT_NO() {
        return CONTRACT_NO;
    }


    /**
     * Sets the CONTRACT_NO value for this ZREIF_S_SEM_CHANGERESPONSE.
     * 
     * @param CONTRACT_NO   * Number of old contract
     */
    public void setCONTRACT_NO(java.lang.String CONTRACT_NO) {
        this.CONTRACT_NO = CONTRACT_NO;
    }


    /**
     * Gets the REFX_NO value for this ZREIF_S_SEM_CHANGERESPONSE.
     * 
     * @return REFX_NO   * Contract Number
     */
    public java.lang.String getREFX_NO() {
        return REFX_NO;
    }


    /**
     * Sets the REFX_NO value for this ZREIF_S_SEM_CHANGERESPONSE.
     * 
     * @param REFX_NO   * Contract Number
     */
    public void setREFX_NO(java.lang.String REFX_NO) {
        this.REFX_NO = REFX_NO;
    }


    /**
     * Gets the STATUS_CODE value for this ZREIF_S_SEM_CHANGERESPONSE.
     * 
     * @return STATUS_CODE   * Status Code
     */
    public java.lang.String getSTATUS_CODE() {
        return STATUS_CODE;
    }


    /**
     * Sets the STATUS_CODE value for this ZREIF_S_SEM_CHANGERESPONSE.
     * 
     * @param STATUS_CODE   * Status Code
     */
    public void setSTATUS_CODE(java.lang.String STATUS_CODE) {
        this.STATUS_CODE = STATUS_CODE;
    }


    /**
     * Gets the ERROR_CODE value for this ZREIF_S_SEM_CHANGERESPONSE.
     * 
     * @return ERROR_CODE   * Error Code
     */
    public java.lang.String getERROR_CODE() {
        return ERROR_CODE;
    }


    /**
     * Sets the ERROR_CODE value for this ZREIF_S_SEM_CHANGERESPONSE.
     * 
     * @param ERROR_CODE   * Error Code
     */
    public void setERROR_CODE(java.lang.String ERROR_CODE) {
        this.ERROR_CODE = ERROR_CODE;
    }


    /**
     * Gets the STATUS_MESSAGE value for this ZREIF_S_SEM_CHANGERESPONSE.
     * 
     * @return STATUS_MESSAGE   * Message
     */
    public java.lang.String getSTATUS_MESSAGE() {
        return STATUS_MESSAGE;
    }


    /**
     * Sets the STATUS_MESSAGE value for this ZREIF_S_SEM_CHANGERESPONSE.
     * 
     * @param STATUS_MESSAGE   * Message
     */
    public void setSTATUS_MESSAGE(java.lang.String STATUS_MESSAGE) {
        this.STATUS_MESSAGE = STATUS_MESSAGE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZREIF_S_SEM_CHANGERESPONSE)) return false;
        ZREIF_S_SEM_CHANGERESPONSE other = (ZREIF_S_SEM_CHANGERESPONSE) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.FILENAME==null && other.getFILENAME()==null) || 
             (this.FILENAME!=null &&
              this.FILENAME.equals(other.getFILENAME()))) &&
            ((this.ACTIVITY==null && other.getACTIVITY()==null) || 
             (this.ACTIVITY!=null &&
              this.ACTIVITY.equals(other.getACTIVITY()))) &&
            ((this.REFERENCE_ID==null && other.getREFERENCE_ID()==null) || 
             (this.REFERENCE_ID!=null &&
              this.REFERENCE_ID.equals(other.getREFERENCE_ID()))) &&
            ((this.COMPANY_CODE==null && other.getCOMPANY_CODE()==null) || 
             (this.COMPANY_CODE!=null &&
              this.COMPANY_CODE.equals(other.getCOMPANY_CODE()))) &&
            ((this.CONTRACT_NO==null && other.getCONTRACT_NO()==null) || 
             (this.CONTRACT_NO!=null &&
              this.CONTRACT_NO.equals(other.getCONTRACT_NO()))) &&
            ((this.REFX_NO==null && other.getREFX_NO()==null) || 
             (this.REFX_NO!=null &&
              this.REFX_NO.equals(other.getREFX_NO()))) &&
            ((this.STATUS_CODE==null && other.getSTATUS_CODE()==null) || 
             (this.STATUS_CODE!=null &&
              this.STATUS_CODE.equals(other.getSTATUS_CODE()))) &&
            ((this.ERROR_CODE==null && other.getERROR_CODE()==null) || 
             (this.ERROR_CODE!=null &&
              this.ERROR_CODE.equals(other.getERROR_CODE()))) &&
            ((this.STATUS_MESSAGE==null && other.getSTATUS_MESSAGE()==null) || 
             (this.STATUS_MESSAGE!=null &&
              this.STATUS_MESSAGE.equals(other.getSTATUS_MESSAGE())));
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
        if (getFILENAME() != null) {
            _hashCode += getFILENAME().hashCode();
        }
        if (getACTIVITY() != null) {
            _hashCode += getACTIVITY().hashCode();
        }
        if (getREFERENCE_ID() != null) {
            _hashCode += getREFERENCE_ID().hashCode();
        }
        if (getCOMPANY_CODE() != null) {
            _hashCode += getCOMPANY_CODE().hashCode();
        }
        if (getCONTRACT_NO() != null) {
            _hashCode += getCONTRACT_NO().hashCode();
        }
        if (getREFX_NO() != null) {
            _hashCode += getREFX_NO().hashCode();
        }
        if (getSTATUS_CODE() != null) {
            _hashCode += getSTATUS_CODE().hashCode();
        }
        if (getERROR_CODE() != null) {
            _hashCode += getERROR_CODE().hashCode();
        }
        if (getSTATUS_MESSAGE() != null) {
            _hashCode += getSTATUS_MESSAGE().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZREIF_S_SEM_CHANGERESPONSE.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZREIF_S_SEM_CHANGERESPONSE"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FILENAME");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FILENAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ACTIVITY");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ACTIVITY"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("REFERENCE_ID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "REFERENCE_ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COMPANY_CODE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "COMPANY_CODE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONTRACT_NO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CONTRACT_NO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("REFX_NO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "REFX_NO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("STATUS_CODE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "STATUS_CODE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERROR_CODE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERROR_CODE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("STATUS_MESSAGE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "STATUS_MESSAGE"));
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
