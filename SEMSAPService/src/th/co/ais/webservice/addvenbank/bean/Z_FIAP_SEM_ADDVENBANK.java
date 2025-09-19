/**
 * Z_FIAP_SEM_ADDVENBANK.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package th.co.ais.webservice.addvenbank.bean;

public class Z_FIAP_SEM_ADDVENBANK  implements java.io.Serializable {
    private java.lang.String CHECKMODUS;

    private java.lang.String CONFIRM_CHANGES;

    private th.co.ais.webservice.addvenbank.bean.ZSEM_BANKDATA_STRUC[] i_BANKDATA;

    private java.lang.String KOART;

    private th.co.ais.webservice.addvenbank.bean.ZSEM_MESSAGES_STRUC[] t_MESSAGES;

    public Z_FIAP_SEM_ADDVENBANK() {
    }

    public Z_FIAP_SEM_ADDVENBANK(
           java.lang.String CHECKMODUS,
           java.lang.String CONFIRM_CHANGES,
           th.co.ais.webservice.addvenbank.bean.ZSEM_BANKDATA_STRUC[] i_BANKDATA,
           java.lang.String KOART,
           th.co.ais.webservice.addvenbank.bean.ZSEM_MESSAGES_STRUC[] t_MESSAGES) {
           this.CHECKMODUS = CHECKMODUS;
           this.CONFIRM_CHANGES = CONFIRM_CHANGES;
           this.i_BANKDATA = i_BANKDATA;
           this.KOART = KOART;
           this.t_MESSAGES = t_MESSAGES;
    }


    /**
     * Gets the CHECKMODUS value for this Z_FIAP_SEM_ADDVENBANK.
     * 
     * @return CHECKMODUS
     */
    public java.lang.String getCHECKMODUS() {
        return CHECKMODUS;
    }


    /**
     * Sets the CHECKMODUS value for this Z_FIAP_SEM_ADDVENBANK.
     * 
     * @param CHECKMODUS
     */
    public void setCHECKMODUS(java.lang.String CHECKMODUS) {
        this.CHECKMODUS = CHECKMODUS;
    }


    /**
     * Gets the CONFIRM_CHANGES value for this Z_FIAP_SEM_ADDVENBANK.
     * 
     * @return CONFIRM_CHANGES
     */
    public java.lang.String getCONFIRM_CHANGES() {
        return CONFIRM_CHANGES;
    }


    /**
     * Sets the CONFIRM_CHANGES value for this Z_FIAP_SEM_ADDVENBANK.
     * 
     * @param CONFIRM_CHANGES
     */
    public void setCONFIRM_CHANGES(java.lang.String CONFIRM_CHANGES) {
        this.CONFIRM_CHANGES = CONFIRM_CHANGES;
    }


    /**
     * Gets the i_BANKDATA value for this Z_FIAP_SEM_ADDVENBANK.
     * 
     * @return i_BANKDATA
     */
    public th.co.ais.webservice.addvenbank.bean.ZSEM_BANKDATA_STRUC[] getI_BANKDATA() {
        return i_BANKDATA;
    }


    /**
     * Sets the i_BANKDATA value for this Z_FIAP_SEM_ADDVENBANK.
     * 
     * @param i_BANKDATA
     */
    public void setI_BANKDATA(th.co.ais.webservice.addvenbank.bean.ZSEM_BANKDATA_STRUC[] i_BANKDATA) {
        this.i_BANKDATA = i_BANKDATA;
    }


    /**
     * Gets the KOART value for this Z_FIAP_SEM_ADDVENBANK.
     * 
     * @return KOART
     */
    public java.lang.String getKOART() {
        return KOART;
    }


    /**
     * Sets the KOART value for this Z_FIAP_SEM_ADDVENBANK.
     * 
     * @param KOART
     */
    public void setKOART(java.lang.String KOART) {
        this.KOART = KOART;
    }


    /**
     * Gets the t_MESSAGES value for this Z_FIAP_SEM_ADDVENBANK.
     * 
     * @return t_MESSAGES
     */
    public th.co.ais.webservice.addvenbank.bean.ZSEM_MESSAGES_STRUC[] getT_MESSAGES() {
        return t_MESSAGES;
    }


    /**
     * Sets the t_MESSAGES value for this Z_FIAP_SEM_ADDVENBANK.
     * 
     * @param t_MESSAGES
     */
    public void setT_MESSAGES(th.co.ais.webservice.addvenbank.bean.ZSEM_MESSAGES_STRUC[] t_MESSAGES) {
        this.t_MESSAGES = t_MESSAGES;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Z_FIAP_SEM_ADDVENBANK)) return false;
        Z_FIAP_SEM_ADDVENBANK other = (Z_FIAP_SEM_ADDVENBANK) obj;
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
            ((this.i_BANKDATA==null && other.getI_BANKDATA()==null) || 
             (this.i_BANKDATA!=null &&
              java.util.Arrays.equals(this.i_BANKDATA, other.getI_BANKDATA()))) &&
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
        if (getI_BANKDATA() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getI_BANKDATA());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getI_BANKDATA(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        new org.apache.axis.description.TypeDesc(Z_FIAP_SEM_ADDVENBANK.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", ">Z_FIAP_SEM_ADDVENBANK"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CHECKMODUS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CHECKMODUS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONFIRM_CHANGES");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CONFIRM_CHANGES"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("i_BANKDATA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "I_BANKDATA"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZSEM_BANKDATA_STRUC"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("KOART");
        elemField.setXmlName(new javax.xml.namespace.QName("", "KOART"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("t_MESSAGES");
        elemField.setXmlName(new javax.xml.namespace.QName("", "T_MESSAGES"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZSEM_MESSAGES_STRUC"));
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
