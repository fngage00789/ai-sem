/**
 * Z_FIAP_SEM_GETVENBANK.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package th.co.ais.webservice.getvenbank.bean;

public class Z_FIAP_SEM_GETVENBANK  implements java.io.Serializable {
    private th.co.ais.webservice.getvenbank.bean.ZSEM_BANKDATA_STRUC[] e_BANKDATA;

    private th.co.ais.webservice.getvenbank.bean.ZSEM_BNKA_STRUC[] e_BNKA;

    private java.lang.String i_ACCOUNT;

    private java.lang.String i_KOART;

    private java.lang.String i_XTECH_ACCNO;

    private th.co.ais.webservice.getvenbank.bean.EBPP_MESSAGES[] t_MESSAGES;

    public Z_FIAP_SEM_GETVENBANK() {
    }

    public Z_FIAP_SEM_GETVENBANK(
           th.co.ais.webservice.getvenbank.bean.ZSEM_BANKDATA_STRUC[] e_BANKDATA,
           th.co.ais.webservice.getvenbank.bean.ZSEM_BNKA_STRUC[] e_BNKA,
           java.lang.String i_ACCOUNT,
           java.lang.String i_KOART,
           java.lang.String i_XTECH_ACCNO,
           th.co.ais.webservice.getvenbank.bean.EBPP_MESSAGES[] t_MESSAGES) {
           this.e_BANKDATA = e_BANKDATA;
           this.e_BNKA = e_BNKA;
           this.i_ACCOUNT = i_ACCOUNT;
           this.i_KOART = i_KOART;
           this.i_XTECH_ACCNO = i_XTECH_ACCNO;
           this.t_MESSAGES = t_MESSAGES;
    }


    /**
     * Gets the e_BANKDATA value for this Z_FIAP_SEM_GETVENBANK.
     * 
     * @return e_BANKDATA
     */
    public th.co.ais.webservice.getvenbank.bean.ZSEM_BANKDATA_STRUC[] getE_BANKDATA() {
        return e_BANKDATA;
    }


    /**
     * Sets the e_BANKDATA value for this Z_FIAP_SEM_GETVENBANK.
     * 
     * @param e_BANKDATA
     */
    public void setE_BANKDATA(th.co.ais.webservice.getvenbank.bean.ZSEM_BANKDATA_STRUC[] e_BANKDATA) {
        this.e_BANKDATA = e_BANKDATA;
    }


    /**
     * Gets the e_BNKA value for this Z_FIAP_SEM_GETVENBANK.
     * 
     * @return e_BNKA
     */
    public th.co.ais.webservice.getvenbank.bean.ZSEM_BNKA_STRUC[] getE_BNKA() {
        return e_BNKA;
    }


    /**
     * Sets the e_BNKA value for this Z_FIAP_SEM_GETVENBANK.
     * 
     * @param e_BNKA
     */
    public void setE_BNKA(th.co.ais.webservice.getvenbank.bean.ZSEM_BNKA_STRUC[] e_BNKA) {
        this.e_BNKA = e_BNKA;
    }


    /**
     * Gets the i_ACCOUNT value for this Z_FIAP_SEM_GETVENBANK.
     * 
     * @return i_ACCOUNT
     */
    public java.lang.String getI_ACCOUNT() {
        return i_ACCOUNT;
    }


    /**
     * Sets the i_ACCOUNT value for this Z_FIAP_SEM_GETVENBANK.
     * 
     * @param i_ACCOUNT
     */
    public void setI_ACCOUNT(java.lang.String i_ACCOUNT) {
        this.i_ACCOUNT = i_ACCOUNT;
    }


    /**
     * Gets the i_KOART value for this Z_FIAP_SEM_GETVENBANK.
     * 
     * @return i_KOART
     */
    public java.lang.String getI_KOART() {
        return i_KOART;
    }


    /**
     * Sets the i_KOART value for this Z_FIAP_SEM_GETVENBANK.
     * 
     * @param i_KOART
     */
    public void setI_KOART(java.lang.String i_KOART) {
        this.i_KOART = i_KOART;
    }


    /**
     * Gets the i_XTECH_ACCNO value for this Z_FIAP_SEM_GETVENBANK.
     * 
     * @return i_XTECH_ACCNO
     */
    public java.lang.String getI_XTECH_ACCNO() {
        return i_XTECH_ACCNO;
    }


    /**
     * Sets the i_XTECH_ACCNO value for this Z_FIAP_SEM_GETVENBANK.
     * 
     * @param i_XTECH_ACCNO
     */
    public void setI_XTECH_ACCNO(java.lang.String i_XTECH_ACCNO) {
        this.i_XTECH_ACCNO = i_XTECH_ACCNO;
    }


    /**
     * Gets the t_MESSAGES value for this Z_FIAP_SEM_GETVENBANK.
     * 
     * @return t_MESSAGES
     */
    public th.co.ais.webservice.getvenbank.bean.EBPP_MESSAGES[] getT_MESSAGES() {
        return t_MESSAGES;
    }


    /**
     * Sets the t_MESSAGES value for this Z_FIAP_SEM_GETVENBANK.
     * 
     * @param t_MESSAGES
     */
    public void setT_MESSAGES(th.co.ais.webservice.getvenbank.bean.EBPP_MESSAGES[] t_MESSAGES) {
        this.t_MESSAGES = t_MESSAGES;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Z_FIAP_SEM_GETVENBANK)) return false;
        Z_FIAP_SEM_GETVENBANK other = (Z_FIAP_SEM_GETVENBANK) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.e_BANKDATA==null && other.getE_BANKDATA()==null) || 
             (this.e_BANKDATA!=null &&
              java.util.Arrays.equals(this.e_BANKDATA, other.getE_BANKDATA()))) &&
            ((this.e_BNKA==null && other.getE_BNKA()==null) || 
             (this.e_BNKA!=null &&
              java.util.Arrays.equals(this.e_BNKA, other.getE_BNKA()))) &&
            ((this.i_ACCOUNT==null && other.getI_ACCOUNT()==null) || 
             (this.i_ACCOUNT!=null &&
              this.i_ACCOUNT.equals(other.getI_ACCOUNT()))) &&
            ((this.i_KOART==null && other.getI_KOART()==null) || 
             (this.i_KOART!=null &&
              this.i_KOART.equals(other.getI_KOART()))) &&
            ((this.i_XTECH_ACCNO==null && other.getI_XTECH_ACCNO()==null) || 
             (this.i_XTECH_ACCNO!=null &&
              this.i_XTECH_ACCNO.equals(other.getI_XTECH_ACCNO()))) &&
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
        if (getE_BANKDATA() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getE_BANKDATA());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getE_BANKDATA(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getE_BNKA() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getE_BNKA());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getE_BNKA(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getI_ACCOUNT() != null) {
            _hashCode += getI_ACCOUNT().hashCode();
        }
        if (getI_KOART() != null) {
            _hashCode += getI_KOART().hashCode();
        }
        if (getI_XTECH_ACCNO() != null) {
            _hashCode += getI_XTECH_ACCNO().hashCode();
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
        new org.apache.axis.description.TypeDesc(Z_FIAP_SEM_GETVENBANK.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", ">Z_FIAP_SEM_GETVENBANK"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("e_BANKDATA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "E_BANKDATA"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZSEM_BANKDATA_STRUC"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("e_BNKA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "E_BNKA"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZSEM_BNKA_STRUC"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("i_ACCOUNT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "I_ACCOUNT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("i_KOART");
        elemField.setXmlName(new javax.xml.namespace.QName("", "I_KOART"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("i_XTECH_ACCNO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "I_XTECH_ACCNO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("t_MESSAGES");
        elemField.setXmlName(new javax.xml.namespace.QName("", "T_MESSAGES"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "EBPP_MESSAGES"));
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
