/**
 * Z_FIAP_SEM_CRE_VEN.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package th.co.ais.webservice.creven.bean;

public class Z_FIAP_SEM_CRE_VEN  implements java.io.Serializable {
    private th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_COMPANY_STRUC COMPANY;

    private java.lang.String CONFIRM_NO_TAX;

    private th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_PROFILE_STRUC PROFILE;

    private java.lang.String REQUNAME;

    private th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_EMAIL_STRUC[] t_EMAIL;

    private th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_FAX_STRUC[] t_FAX;

    private th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_MSG_STRUC[] t_MESSAGES;

    private th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_MOBILE_STRUC[] t_MOBILE;

    private th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_TELE_STRUC[] t_TELE;

    private th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_WHTAX_STRUC[] t_WHTAX;

    public Z_FIAP_SEM_CRE_VEN() {
    }

    public Z_FIAP_SEM_CRE_VEN(
           th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_COMPANY_STRUC COMPANY,
           java.lang.String CONFIRM_NO_TAX,
           th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_PROFILE_STRUC PROFILE,
           java.lang.String REQUNAME,
           th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_EMAIL_STRUC[] t_EMAIL,
           th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_FAX_STRUC[] t_FAX,
           th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_MSG_STRUC[] t_MESSAGES,
           th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_MOBILE_STRUC[] t_MOBILE,
           th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_TELE_STRUC[] t_TELE,
           th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_WHTAX_STRUC[] t_WHTAX) {
           this.COMPANY = COMPANY;
           this.CONFIRM_NO_TAX = CONFIRM_NO_TAX;
           this.PROFILE = PROFILE;
           this.REQUNAME = REQUNAME;
           this.t_EMAIL = t_EMAIL;
           this.t_FAX = t_FAX;
           this.t_MESSAGES = t_MESSAGES;
           this.t_MOBILE = t_MOBILE;
           this.t_TELE = t_TELE;
           this.t_WHTAX = t_WHTAX;
    }


    /**
     * Gets the COMPANY value for this Z_FIAP_SEM_CRE_VEN.
     * 
     * @return COMPANY
     */
    public th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_COMPANY_STRUC getCOMPANY() {
        return COMPANY;
    }


    /**
     * Sets the COMPANY value for this Z_FIAP_SEM_CRE_VEN.
     * 
     * @param COMPANY
     */
    public void setCOMPANY(th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_COMPANY_STRUC COMPANY) {
        this.COMPANY = COMPANY;
    }


    /**
     * Gets the CONFIRM_NO_TAX value for this Z_FIAP_SEM_CRE_VEN.
     * 
     * @return CONFIRM_NO_TAX
     */
    public java.lang.String getCONFIRM_NO_TAX() {
        return CONFIRM_NO_TAX;
    }


    /**
     * Sets the CONFIRM_NO_TAX value for this Z_FIAP_SEM_CRE_VEN.
     * 
     * @param CONFIRM_NO_TAX
     */
    public void setCONFIRM_NO_TAX(java.lang.String CONFIRM_NO_TAX) {
        this.CONFIRM_NO_TAX = CONFIRM_NO_TAX;
    }


    /**
     * Gets the PROFILE value for this Z_FIAP_SEM_CRE_VEN.
     * 
     * @return PROFILE
     */
    public th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_PROFILE_STRUC getPROFILE() {
        return PROFILE;
    }


    /**
     * Sets the PROFILE value for this Z_FIAP_SEM_CRE_VEN.
     * 
     * @param PROFILE
     */
    public void setPROFILE(th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_PROFILE_STRUC PROFILE) {
        this.PROFILE = PROFILE;
    }


    /**
     * Gets the REQUNAME value for this Z_FIAP_SEM_CRE_VEN.
     * 
     * @return REQUNAME
     */
    public java.lang.String getREQUNAME() {
        return REQUNAME;
    }


    /**
     * Sets the REQUNAME value for this Z_FIAP_SEM_CRE_VEN.
     * 
     * @param REQUNAME
     */
    public void setREQUNAME(java.lang.String REQUNAME) {
        this.REQUNAME = REQUNAME;
    }


    /**
     * Gets the t_EMAIL value for this Z_FIAP_SEM_CRE_VEN.
     * 
     * @return t_EMAIL
     */
    public th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_EMAIL_STRUC[] getT_EMAIL() {
        return t_EMAIL;
    }


    /**
     * Sets the t_EMAIL value for this Z_FIAP_SEM_CRE_VEN.
     * 
     * @param t_EMAIL
     */
    public void setT_EMAIL(th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_EMAIL_STRUC[] t_EMAIL) {
        this.t_EMAIL = t_EMAIL;
    }


    /**
     * Gets the t_FAX value for this Z_FIAP_SEM_CRE_VEN.
     * 
     * @return t_FAX
     */
    public th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_FAX_STRUC[] getT_FAX() {
        return t_FAX;
    }


    /**
     * Sets the t_FAX value for this Z_FIAP_SEM_CRE_VEN.
     * 
     * @param t_FAX
     */
    public void setT_FAX(th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_FAX_STRUC[] t_FAX) {
        this.t_FAX = t_FAX;
    }


    /**
     * Gets the t_MESSAGES value for this Z_FIAP_SEM_CRE_VEN.
     * 
     * @return t_MESSAGES
     */
    public th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_MSG_STRUC[] getT_MESSAGES() {
        return t_MESSAGES;
    }


    /**
     * Sets the t_MESSAGES value for this Z_FIAP_SEM_CRE_VEN.
     * 
     * @param t_MESSAGES
     */
    public void setT_MESSAGES(th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_MSG_STRUC[] t_MESSAGES) {
        this.t_MESSAGES = t_MESSAGES;
    }


    /**
     * Gets the t_MOBILE value for this Z_FIAP_SEM_CRE_VEN.
     * 
     * @return t_MOBILE
     */
    public th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_MOBILE_STRUC[] getT_MOBILE() {
        return t_MOBILE;
    }


    /**
     * Sets the t_MOBILE value for this Z_FIAP_SEM_CRE_VEN.
     * 
     * @param t_MOBILE
     */
    public void setT_MOBILE(th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_MOBILE_STRUC[] t_MOBILE) {
        this.t_MOBILE = t_MOBILE;
    }


    /**
     * Gets the t_TELE value for this Z_FIAP_SEM_CRE_VEN.
     * 
     * @return t_TELE
     */
    public th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_TELE_STRUC[] getT_TELE() {
        return t_TELE;
    }


    /**
     * Sets the t_TELE value for this Z_FIAP_SEM_CRE_VEN.
     * 
     * @param t_TELE
     */
    public void setT_TELE(th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_TELE_STRUC[] t_TELE) {
        this.t_TELE = t_TELE;
    }


    /**
     * Gets the t_WHTAX value for this Z_FIAP_SEM_CRE_VEN.
     * 
     * @return t_WHTAX
     */
    public th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_WHTAX_STRUC[] getT_WHTAX() {
        return t_WHTAX;
    }


    /**
     * Sets the t_WHTAX value for this Z_FIAP_SEM_CRE_VEN.
     * 
     * @param t_WHTAX
     */
    public void setT_WHTAX(th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_WHTAX_STRUC[] t_WHTAX) {
        this.t_WHTAX = t_WHTAX;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Z_FIAP_SEM_CRE_VEN)) return false;
        Z_FIAP_SEM_CRE_VEN other = (Z_FIAP_SEM_CRE_VEN) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.COMPANY==null && other.getCOMPANY()==null) || 
             (this.COMPANY!=null &&
              this.COMPANY.equals(other.getCOMPANY()))) &&
            ((this.CONFIRM_NO_TAX==null && other.getCONFIRM_NO_TAX()==null) || 
             (this.CONFIRM_NO_TAX!=null &&
              this.CONFIRM_NO_TAX.equals(other.getCONFIRM_NO_TAX()))) &&
            ((this.PROFILE==null && other.getPROFILE()==null) || 
             (this.PROFILE!=null &&
              this.PROFILE.equals(other.getPROFILE()))) &&
            ((this.REQUNAME==null && other.getREQUNAME()==null) || 
             (this.REQUNAME!=null &&
              this.REQUNAME.equals(other.getREQUNAME()))) &&
            ((this.t_EMAIL==null && other.getT_EMAIL()==null) || 
             (this.t_EMAIL!=null &&
              java.util.Arrays.equals(this.t_EMAIL, other.getT_EMAIL()))) &&
            ((this.t_FAX==null && other.getT_FAX()==null) || 
             (this.t_FAX!=null &&
              java.util.Arrays.equals(this.t_FAX, other.getT_FAX()))) &&
            ((this.t_MESSAGES==null && other.getT_MESSAGES()==null) || 
             (this.t_MESSAGES!=null &&
              java.util.Arrays.equals(this.t_MESSAGES, other.getT_MESSAGES()))) &&
            ((this.t_MOBILE==null && other.getT_MOBILE()==null) || 
             (this.t_MOBILE!=null &&
              java.util.Arrays.equals(this.t_MOBILE, other.getT_MOBILE()))) &&
            ((this.t_TELE==null && other.getT_TELE()==null) || 
             (this.t_TELE!=null &&
              java.util.Arrays.equals(this.t_TELE, other.getT_TELE()))) &&
            ((this.t_WHTAX==null && other.getT_WHTAX()==null) || 
             (this.t_WHTAX!=null &&
              java.util.Arrays.equals(this.t_WHTAX, other.getT_WHTAX())));
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
        if (getCOMPANY() != null) {
            _hashCode += getCOMPANY().hashCode();
        }
        if (getCONFIRM_NO_TAX() != null) {
            _hashCode += getCONFIRM_NO_TAX().hashCode();
        }
        if (getPROFILE() != null) {
            _hashCode += getPROFILE().hashCode();
        }
        if (getREQUNAME() != null) {
            _hashCode += getREQUNAME().hashCode();
        }
        if (getT_EMAIL() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getT_EMAIL());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getT_EMAIL(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getT_FAX() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getT_FAX());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getT_FAX(), i);
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
        if (getT_MOBILE() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getT_MOBILE());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getT_MOBILE(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getT_TELE() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getT_TELE());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getT_TELE(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getT_WHTAX() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getT_WHTAX());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getT_WHTAX(), i);
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
        new org.apache.axis.description.TypeDesc(Z_FIAP_SEM_CRE_VEN.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", ">Z_FIAP_SEM_CRE_VEN"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COMPANY");
        elemField.setXmlName(new javax.xml.namespace.QName("", "COMPANY"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZSEM_CRE_VEN_COMPANY_STRUC"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONFIRM_NO_TAX");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CONFIRM_NO_TAX"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PROFILE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PROFILE"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZSEM_CRE_VEN_PROFILE_STRUC"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("REQUNAME");
        elemField.setXmlName(new javax.xml.namespace.QName("", "REQUNAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("t_EMAIL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "T_EMAIL"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZSEM_CRE_VEN_EMAIL_STRUC"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("t_FAX");
        elemField.setXmlName(new javax.xml.namespace.QName("", "T_FAX"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZSEM_CRE_VEN_FAX_STRUC"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("t_MESSAGES");
        elemField.setXmlName(new javax.xml.namespace.QName("", "T_MESSAGES"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZSEM_CRE_VEN_MSG_STRUC"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("t_MOBILE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "T_MOBILE"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZSEM_CRE_VEN_MOBILE_STRUC"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("t_TELE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "T_TELE"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZSEM_CRE_VEN_TELE_STRUC"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("t_WHTAX");
        elemField.setXmlName(new javax.xml.namespace.QName("", "T_WHTAX"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZSEM_CRE_VEN_WHTAX_STRUC"));
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
