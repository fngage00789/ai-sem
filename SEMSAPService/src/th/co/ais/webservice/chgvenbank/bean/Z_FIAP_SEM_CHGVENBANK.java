/**
 * Z_FIAP_SEM_CHGVENBANK.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package th.co.ais.webservice.chgvenbank.bean;

public class Z_FIAP_SEM_CHGVENBANK  implements java.io.Serializable {
    private java.lang.String CHECKMODUS;

    private java.lang.String CONFIRM_CHANGES;

    private th.co.ais.webservice.chgvenbank.bean.ZSEM_BANKDATA_STRUC i_BANKDATA_NEW;

    private th.co.ais.webservice.chgvenbank.bean.ZSEM_BANKDATA_STRUC i_BANKDATA_OLD;

    private java.lang.String KOART;

    private th.co.ais.webservice.chgvenbank.bean.EBPP_MESSAGES[] t_MESSAGES;

    public Z_FIAP_SEM_CHGVENBANK() {
    }

    public Z_FIAP_SEM_CHGVENBANK(
           java.lang.String CHECKMODUS,
           java.lang.String CONFIRM_CHANGES,
           th.co.ais.webservice.chgvenbank.bean.ZSEM_BANKDATA_STRUC i_BANKDATA_NEW,
           th.co.ais.webservice.chgvenbank.bean.ZSEM_BANKDATA_STRUC i_BANKDATA_OLD,
           java.lang.String KOART,
           th.co.ais.webservice.chgvenbank.bean.EBPP_MESSAGES[] t_MESSAGES) {
           this.CHECKMODUS = CHECKMODUS;
           this.CONFIRM_CHANGES = CONFIRM_CHANGES;
           this.i_BANKDATA_NEW = i_BANKDATA_NEW;
           this.i_BANKDATA_OLD = i_BANKDATA_OLD;
           this.KOART = KOART;
           this.t_MESSAGES = t_MESSAGES;
    }


    /**
     * Gets the CHECKMODUS value for this Z_FIAP_SEM_CHGVENBANK.
     * 
     * @return CHECKMODUS
     */
    public java.lang.String getCHECKMODUS() {
        return CHECKMODUS;
    }


    /**
     * Sets the CHECKMODUS value for this Z_FIAP_SEM_CHGVENBANK.
     * 
     * @param CHECKMODUS
     */
    public void setCHECKMODUS(java.lang.String CHECKMODUS) {
        this.CHECKMODUS = CHECKMODUS;
    }


    /**
     * Gets the CONFIRM_CHANGES value for this Z_FIAP_SEM_CHGVENBANK.
     * 
     * @return CONFIRM_CHANGES
     */
    public java.lang.String getCONFIRM_CHANGES() {
        return CONFIRM_CHANGES;
    }


    /**
     * Sets the CONFIRM_CHANGES value for this Z_FIAP_SEM_CHGVENBANK.
     * 
     * @param CONFIRM_CHANGES
     */
    public void setCONFIRM_CHANGES(java.lang.String CONFIRM_CHANGES) {
        this.CONFIRM_CHANGES = CONFIRM_CHANGES;
    }


    /**
     * Gets the i_BANKDATA_NEW value for this Z_FIAP_SEM_CHGVENBANK.
     * 
     * @return i_BANKDATA_NEW
     */
    public th.co.ais.webservice.chgvenbank.bean.ZSEM_BANKDATA_STRUC getI_BANKDATA_NEW() {
        return i_BANKDATA_NEW;
    }


    /**
     * Sets the i_BANKDATA_NEW value for this Z_FIAP_SEM_CHGVENBANK.
     * 
     * @param i_BANKDATA_NEW
     */
    public void setI_BANKDATA_NEW(th.co.ais.webservice.chgvenbank.bean.ZSEM_BANKDATA_STRUC i_BANKDATA_NEW) {
        this.i_BANKDATA_NEW = i_BANKDATA_NEW;
    }


    /**
     * Gets the i_BANKDATA_OLD value for this Z_FIAP_SEM_CHGVENBANK.
     * 
     * @return i_BANKDATA_OLD
     */
    public th.co.ais.webservice.chgvenbank.bean.ZSEM_BANKDATA_STRUC getI_BANKDATA_OLD() {
        return i_BANKDATA_OLD;
    }


    /**
     * Sets the i_BANKDATA_OLD value for this Z_FIAP_SEM_CHGVENBANK.
     * 
     * @param i_BANKDATA_OLD
     */
    public void setI_BANKDATA_OLD(th.co.ais.webservice.chgvenbank.bean.ZSEM_BANKDATA_STRUC i_BANKDATA_OLD) {
        this.i_BANKDATA_OLD = i_BANKDATA_OLD;
    }


    /**
     * Gets the KOART value for this Z_FIAP_SEM_CHGVENBANK.
     * 
     * @return KOART
     */
    public java.lang.String getKOART() {
        return KOART;
    }


    /**
     * Sets the KOART value for this Z_FIAP_SEM_CHGVENBANK.
     * 
     * @param KOART
     */
    public void setKOART(java.lang.String KOART) {
        this.KOART = KOART;
    }


    /**
     * Gets the t_MESSAGES value for this Z_FIAP_SEM_CHGVENBANK.
     * 
     * @return t_MESSAGES
     */
    public th.co.ais.webservice.chgvenbank.bean.EBPP_MESSAGES[] getT_MESSAGES() {
        return t_MESSAGES;
    }


    /**
     * Sets the t_MESSAGES value for this Z_FIAP_SEM_CHGVENBANK.
     * 
     * @param t_MESSAGES
     */
    public void setT_MESSAGES(th.co.ais.webservice.chgvenbank.bean.EBPP_MESSAGES[] t_MESSAGES) {
        this.t_MESSAGES = t_MESSAGES;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Z_FIAP_SEM_CHGVENBANK)) return false;
        Z_FIAP_SEM_CHGVENBANK other = (Z_FIAP_SEM_CHGVENBANK) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.CHECKMODUS==null && other.getCHECKMODUS()==null) || 
             (this.CHECKMODUS!=null &&
              this.CHECKMODUS.equals(other.getCHECKMODUS()))) &&
            ((this.CONFIRM_CHANGES==null && other.getCONFIRM_CHANGES()==null) || 
             (this.CONFIRM_CHANGES!=null &&
              this.CONFIRM_CHANGES.equals(other.getCONFIRM_CHANGES()))) &&
            ((this.i_BANKDATA_NEW==null && other.getI_BANKDATA_NEW()==null) || 
             (this.i_BANKDATA_NEW!=null &&
              this.i_BANKDATA_NEW.equals(other.getI_BANKDATA_NEW()))) &&
            ((this.i_BANKDATA_OLD==null && other.getI_BANKDATA_OLD()==null) || 
             (this.i_BANKDATA_OLD!=null &&
              this.i_BANKDATA_OLD.equals(other.getI_BANKDATA_OLD()))) &&
            ((this.KOART==null && other.getKOART()==null) || 
             (this.KOART!=null &&
              this.KOART.equals(other.getKOART()))) &&
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
        if (getCHECKMODUS() != null) {
            _hashCode += getCHECKMODUS().hashCode();
        }
        if (getCONFIRM_CHANGES() != null) {
            _hashCode += getCONFIRM_CHANGES().hashCode();
        }
        if (getI_BANKDATA_NEW() != null) {
            _hashCode += getI_BANKDATA_NEW().hashCode();
        }
        if (getI_BANKDATA_OLD() != null) {
            _hashCode += getI_BANKDATA_OLD().hashCode();
        }
        if (getKOART() != null) {
            _hashCode += getKOART().hashCode();
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
        new org.apache.axis.description.TypeDesc(Z_FIAP_SEM_CHGVENBANK.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", ">Z_FIAP_SEM_CHGVENBANK"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CHECKMODUS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CHECKMODUS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONFIRM_CHANGES");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CONFIRM_CHANGES"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("i_BANKDATA_NEW");
        elemField.setXmlName(new javax.xml.namespace.QName("", "I_BANKDATA_NEW"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZSEM_BANKDATA_STRUC"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("i_BANKDATA_OLD");
        elemField.setXmlName(new javax.xml.namespace.QName("", "I_BANKDATA_OLD"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZSEM_BANKDATA_STRUC"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("KOART");
        elemField.setXmlName(new javax.xml.namespace.QName("", "KOART"));
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
