/**
 * Z_FIAP_SEM_BLKUNBLKVEN.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package th.co.ais.webservice.blkunblkven.bean;

public class Z_FIAP_SEM_BLKUNBLKVEN  implements java.io.Serializable {
    private java.lang.String BRANCH;

    private java.lang.String BUKRS;

    private java.lang.String LIFNR;

    private java.lang.String LOEVM;

    private java.lang.String ROLE;

    private java.lang.String ROLETYPE;

    private java.lang.String SPERR;

    private java.lang.String STCD3;

    private th.co.ais.webservice.blkunblkven.bean.EBPP_MESSAGES[] t_MESSAGES;

    public Z_FIAP_SEM_BLKUNBLKVEN() {
    }

    public Z_FIAP_SEM_BLKUNBLKVEN(
           java.lang.String BRANCH,
           java.lang.String BUKRS,
           java.lang.String LIFNR,
           java.lang.String LOEVM,
           java.lang.String ROLE,
           java.lang.String ROLETYPE,
           java.lang.String SPERR,
           java.lang.String STCD3,
           th.co.ais.webservice.blkunblkven.bean.EBPP_MESSAGES[] t_MESSAGES) {
           this.BRANCH = BRANCH;
           this.BUKRS = BUKRS;
           this.LIFNR = LIFNR;
           this.LOEVM = LOEVM;
           this.ROLE = ROLE;
           this.ROLETYPE = ROLETYPE;
           this.SPERR = SPERR;
           this.STCD3 = STCD3;
           this.t_MESSAGES = t_MESSAGES;
    }


    /**
     * Gets the BRANCH value for this Z_FIAP_SEM_BLKUNBLKVEN.
     * 
     * @return BRANCH
     */
    public java.lang.String getBRANCH() {
        return BRANCH;
    }


    /**
     * Sets the BRANCH value for this Z_FIAP_SEM_BLKUNBLKVEN.
     * 
     * @param BRANCH
     */
    public void setBRANCH(java.lang.String BRANCH) {
        this.BRANCH = BRANCH;
    }


    /**
     * Gets the BUKRS value for this Z_FIAP_SEM_BLKUNBLKVEN.
     * 
     * @return BUKRS
     */
    public java.lang.String getBUKRS() {
        return BUKRS;
    }


    /**
     * Sets the BUKRS value for this Z_FIAP_SEM_BLKUNBLKVEN.
     * 
     * @param BUKRS
     */
    public void setBUKRS(java.lang.String BUKRS) {
        this.BUKRS = BUKRS;
    }


    /**
     * Gets the LIFNR value for this Z_FIAP_SEM_BLKUNBLKVEN.
     * 
     * @return LIFNR
     */
    public java.lang.String getLIFNR() {
        return LIFNR;
    }


    /**
     * Sets the LIFNR value for this Z_FIAP_SEM_BLKUNBLKVEN.
     * 
     * @param LIFNR
     */
    public void setLIFNR(java.lang.String LIFNR) {
        this.LIFNR = LIFNR;
    }


    /**
     * Gets the LOEVM value for this Z_FIAP_SEM_BLKUNBLKVEN.
     * 
     * @return LOEVM
     */
    public java.lang.String getLOEVM() {
        return LOEVM;
    }


    /**
     * Sets the LOEVM value for this Z_FIAP_SEM_BLKUNBLKVEN.
     * 
     * @param LOEVM
     */
    public void setLOEVM(java.lang.String LOEVM) {
        this.LOEVM = LOEVM;
    }


    /**
     * Gets the ROLE value for this Z_FIAP_SEM_BLKUNBLKVEN.
     * 
     * @return ROLE
     */
    public java.lang.String getROLE() {
        return ROLE;
    }


    /**
     * Sets the ROLE value for this Z_FIAP_SEM_BLKUNBLKVEN.
     * 
     * @param ROLE
     */
    public void setROLE(java.lang.String ROLE) {
        this.ROLE = ROLE;
    }


    /**
     * Gets the ROLETYPE value for this Z_FIAP_SEM_BLKUNBLKVEN.
     * 
     * @return ROLETYPE
     */
    public java.lang.String getROLETYPE() {
        return ROLETYPE;
    }


    /**
     * Sets the ROLETYPE value for this Z_FIAP_SEM_BLKUNBLKVEN.
     * 
     * @param ROLETYPE
     */
    public void setROLETYPE(java.lang.String ROLETYPE) {
        this.ROLETYPE = ROLETYPE;
    }


    /**
     * Gets the SPERR value for this Z_FIAP_SEM_BLKUNBLKVEN.
     * 
     * @return SPERR
     */
    public java.lang.String getSPERR() {
        return SPERR;
    }


    /**
     * Sets the SPERR value for this Z_FIAP_SEM_BLKUNBLKVEN.
     * 
     * @param SPERR
     */
    public void setSPERR(java.lang.String SPERR) {
        this.SPERR = SPERR;
    }


    /**
     * Gets the STCD3 value for this Z_FIAP_SEM_BLKUNBLKVEN.
     * 
     * @return STCD3
     */
    public java.lang.String getSTCD3() {
        return STCD3;
    }


    /**
     * Sets the STCD3 value for this Z_FIAP_SEM_BLKUNBLKVEN.
     * 
     * @param STCD3
     */
    public void setSTCD3(java.lang.String STCD3) {
        this.STCD3 = STCD3;
    }


    /**
     * Gets the t_MESSAGES value for this Z_FIAP_SEM_BLKUNBLKVEN.
     * 
     * @return t_MESSAGES
     */
    public th.co.ais.webservice.blkunblkven.bean.EBPP_MESSAGES[] getT_MESSAGES() {
        return t_MESSAGES;
    }


    /**
     * Sets the t_MESSAGES value for this Z_FIAP_SEM_BLKUNBLKVEN.
     * 
     * @param t_MESSAGES
     */
    public void setT_MESSAGES(th.co.ais.webservice.blkunblkven.bean.EBPP_MESSAGES[] t_MESSAGES) {
        this.t_MESSAGES = t_MESSAGES;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Z_FIAP_SEM_BLKUNBLKVEN)) return false;
        Z_FIAP_SEM_BLKUNBLKVEN other = (Z_FIAP_SEM_BLKUNBLKVEN) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.BRANCH==null && other.getBRANCH()==null) || 
             (this.BRANCH!=null &&
              this.BRANCH.equals(other.getBRANCH()))) &&
            ((this.BUKRS==null && other.getBUKRS()==null) || 
             (this.BUKRS!=null &&
              this.BUKRS.equals(other.getBUKRS()))) &&
            ((this.LIFNR==null && other.getLIFNR()==null) || 
             (this.LIFNR!=null &&
              this.LIFNR.equals(other.getLIFNR()))) &&
            ((this.LOEVM==null && other.getLOEVM()==null) || 
             (this.LOEVM!=null &&
              this.LOEVM.equals(other.getLOEVM()))) &&
            ((this.ROLE==null && other.getROLE()==null) || 
             (this.ROLE!=null &&
              this.ROLE.equals(other.getROLE()))) &&
            ((this.ROLETYPE==null && other.getROLETYPE()==null) || 
             (this.ROLETYPE!=null &&
              this.ROLETYPE.equals(other.getROLETYPE()))) &&
            ((this.SPERR==null && other.getSPERR()==null) || 
             (this.SPERR!=null &&
              this.SPERR.equals(other.getSPERR()))) &&
            ((this.STCD3==null && other.getSTCD3()==null) || 
             (this.STCD3!=null &&
              this.STCD3.equals(other.getSTCD3()))) &&
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
        if (getBRANCH() != null) {
            _hashCode += getBRANCH().hashCode();
        }
        if (getBUKRS() != null) {
            _hashCode += getBUKRS().hashCode();
        }
        if (getLIFNR() != null) {
            _hashCode += getLIFNR().hashCode();
        }
        if (getLOEVM() != null) {
            _hashCode += getLOEVM().hashCode();
        }
        if (getROLE() != null) {
            _hashCode += getROLE().hashCode();
        }
        if (getROLETYPE() != null) {
            _hashCode += getROLETYPE().hashCode();
        }
        if (getSPERR() != null) {
            _hashCode += getSPERR().hashCode();
        }
        if (getSTCD3() != null) {
            _hashCode += getSTCD3().hashCode();
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
        new org.apache.axis.description.TypeDesc(Z_FIAP_SEM_BLKUNBLKVEN.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", ">Z_FIAP_SEM_BLKUNBLKVEN"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BRANCH");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BRANCH"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BUKRS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BUKRS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LIFNR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LIFNR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LOEVM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LOEVM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ROLE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ROLE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ROLETYPE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ROLETYPE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SPERR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SPERR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("STCD3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "STCD3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
