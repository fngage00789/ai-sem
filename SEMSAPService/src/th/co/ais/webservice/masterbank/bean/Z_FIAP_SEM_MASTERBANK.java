/**
 * Z_FIAP_SEM_MASTERBANK.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package th.co.ais.webservice.masterbank.bean;

public class Z_FIAP_SEM_MASTERBANK  implements java.io.Serializable {
    private java.lang.String BANKCOUNTRY;

    private java.lang.String BANKKEY;

    private th.co.ais.webservice.masterbank.bean.BAPI1011_ADDRESS[] BANK_ADDRESS;

    private th.co.ais.webservice.masterbank.bean.BAPI1011_DETAIL[] BANK_DETAIL;

    private th.co.ais.webservice.masterbank.bean.ZSEM_MASTER_BANK_MSG[] t_MESSAGES;

    public Z_FIAP_SEM_MASTERBANK() {
    }

    public Z_FIAP_SEM_MASTERBANK(
           java.lang.String BANKCOUNTRY,
           java.lang.String BANKKEY,
           th.co.ais.webservice.masterbank.bean.BAPI1011_ADDRESS[] BANK_ADDRESS,
           th.co.ais.webservice.masterbank.bean.BAPI1011_DETAIL[] BANK_DETAIL,
           th.co.ais.webservice.masterbank.bean.ZSEM_MASTER_BANK_MSG[] t_MESSAGES) {
           this.BANKCOUNTRY = BANKCOUNTRY;
           this.BANKKEY = BANKKEY;
           this.BANK_ADDRESS = BANK_ADDRESS;
           this.BANK_DETAIL = BANK_DETAIL;
           this.t_MESSAGES = t_MESSAGES;
    }


    /**
     * Gets the BANKCOUNTRY value for this Z_FIAP_SEM_MASTERBANK.
     * 
     * @return BANKCOUNTRY
     */
    public java.lang.String getBANKCOUNTRY() {
        return BANKCOUNTRY;
    }


    /**
     * Sets the BANKCOUNTRY value for this Z_FIAP_SEM_MASTERBANK.
     * 
     * @param BANKCOUNTRY
     */
    public void setBANKCOUNTRY(java.lang.String BANKCOUNTRY) {
        this.BANKCOUNTRY = BANKCOUNTRY;
    }


    /**
     * Gets the BANKKEY value for this Z_FIAP_SEM_MASTERBANK.
     * 
     * @return BANKKEY
     */
    public java.lang.String getBANKKEY() {
        return BANKKEY;
    }


    /**
     * Sets the BANKKEY value for this Z_FIAP_SEM_MASTERBANK.
     * 
     * @param BANKKEY
     */
    public void setBANKKEY(java.lang.String BANKKEY) {
        this.BANKKEY = BANKKEY;
    }


    /**
     * Gets the BANK_ADDRESS value for this Z_FIAP_SEM_MASTERBANK.
     * 
     * @return BANK_ADDRESS
     */
    public th.co.ais.webservice.masterbank.bean.BAPI1011_ADDRESS[] getBANK_ADDRESS() {
        return BANK_ADDRESS;
    }


    /**
     * Sets the BANK_ADDRESS value for this Z_FIAP_SEM_MASTERBANK.
     * 
     * @param BANK_ADDRESS
     */
    public void setBANK_ADDRESS(th.co.ais.webservice.masterbank.bean.BAPI1011_ADDRESS[] BANK_ADDRESS) {
        this.BANK_ADDRESS = BANK_ADDRESS;
    }


    /**
     * Gets the BANK_DETAIL value for this Z_FIAP_SEM_MASTERBANK.
     * 
     * @return BANK_DETAIL
     */
    public th.co.ais.webservice.masterbank.bean.BAPI1011_DETAIL[] getBANK_DETAIL() {
        return BANK_DETAIL;
    }


    /**
     * Sets the BANK_DETAIL value for this Z_FIAP_SEM_MASTERBANK.
     * 
     * @param BANK_DETAIL
     */
    public void setBANK_DETAIL(th.co.ais.webservice.masterbank.bean.BAPI1011_DETAIL[] BANK_DETAIL) {
        this.BANK_DETAIL = BANK_DETAIL;
    }


    /**
     * Gets the t_MESSAGES value for this Z_FIAP_SEM_MASTERBANK.
     * 
     * @return t_MESSAGES
     */
    public th.co.ais.webservice.masterbank.bean.ZSEM_MASTER_BANK_MSG[] getT_MESSAGES() {
        return t_MESSAGES;
    }


    /**
     * Sets the t_MESSAGES value for this Z_FIAP_SEM_MASTERBANK.
     * 
     * @param t_MESSAGES
     */
    public void setT_MESSAGES(th.co.ais.webservice.masterbank.bean.ZSEM_MASTER_BANK_MSG[] t_MESSAGES) {
        this.t_MESSAGES = t_MESSAGES;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Z_FIAP_SEM_MASTERBANK)) return false;
        Z_FIAP_SEM_MASTERBANK other = (Z_FIAP_SEM_MASTERBANK) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.BANKCOUNTRY==null && other.getBANKCOUNTRY()==null) || 
             (this.BANKCOUNTRY!=null &&
              this.BANKCOUNTRY.equals(other.getBANKCOUNTRY()))) &&
            ((this.BANKKEY==null && other.getBANKKEY()==null) || 
             (this.BANKKEY!=null &&
              this.BANKKEY.equals(other.getBANKKEY()))) &&
            ((this.BANK_ADDRESS==null && other.getBANK_ADDRESS()==null) || 
             (this.BANK_ADDRESS!=null &&
              java.util.Arrays.equals(this.BANK_ADDRESS, other.getBANK_ADDRESS()))) &&
            ((this.BANK_DETAIL==null && other.getBANK_DETAIL()==null) || 
             (this.BANK_DETAIL!=null &&
              java.util.Arrays.equals(this.BANK_DETAIL, other.getBANK_DETAIL()))) &&
            ((this.t_MESSAGES==null && other.getT_MESSAGES()==null) || 
             (this.t_MESSAGES!=null &&
              java.util.Arrays.equals(this.t_MESSAGES, other.getT_MESSAGES())));
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
        if (getBANKCOUNTRY() != null) {
            _hashCode += getBANKCOUNTRY().hashCode();
        }
        if (getBANKKEY() != null) {
            _hashCode += getBANKKEY().hashCode();
        }
        if (getBANK_ADDRESS() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBANK_ADDRESS());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBANK_ADDRESS(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getBANK_DETAIL() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBANK_DETAIL());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBANK_DETAIL(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getT_MESSAGES() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getT_MESSAGES());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getT_MESSAGES(), i);
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
        new org.apache.axis.description.TypeDesc(Z_FIAP_SEM_MASTERBANK.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", ">Z_FIAP_SEM_MASTERBANK"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BANKCOUNTRY");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BANKCOUNTRY"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BANKKEY");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BANKKEY"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BANK_ADDRESS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BANK_ADDRESS"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "BAPI1011_ADDRESS"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BANK_DETAIL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BANK_DETAIL"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "BAPI1011_DETAIL"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("t_MESSAGES");
        elemField.setXmlName(new javax.xml.namespace.QName("", "T_MESSAGES"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZSEM_MASTER_BANK_MSG"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
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
