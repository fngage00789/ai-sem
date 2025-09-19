/**
 * Z_FIAP_SEM_GET_VEN.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package th.co.ais.webservice.getven.bean;

public class Z_FIAP_SEM_GET_VEN  implements java.io.Serializable {
    private java.lang.String BRANCH;

    private java.lang.String BUKRS;

    private th.co.ais.webservice.getven.bean.ZCVENDOR[] c_VENDOR;

    private th.co.ais.webservice.getven.bean.ZCWTAX[] c_WTAX;

    private th.co.ais.webservice.getven.bean.ZGEMAIL[] g_EMAIL;

    private th.co.ais.webservice.getven.bean.ZGFAX[] g_FAX;

    private th.co.ais.webservice.getven.bean.ZGMOBILE[] g_MOBILE;

    private th.co.ais.webservice.getven.bean.ZGPROFILE[] g_PROFILE;

    private th.co.ais.webservice.getven.bean.ZGTEL[] g_TEL;

    private java.lang.String LIFNR;

    private java.lang.String ROLE;

    private java.lang.String ROLETYPE;

    private java.lang.String STCD3;

    private th.co.ais.webservice.getven.bean.EBPP_MESSAGES[] t_MESSAGES;

    public Z_FIAP_SEM_GET_VEN() {
    }

    public Z_FIAP_SEM_GET_VEN(
           java.lang.String BRANCH,
           java.lang.String BUKRS,
           th.co.ais.webservice.getven.bean.ZCVENDOR[] c_VENDOR,
           th.co.ais.webservice.getven.bean.ZCWTAX[] c_WTAX,
           th.co.ais.webservice.getven.bean.ZGEMAIL[] g_EMAIL,
           th.co.ais.webservice.getven.bean.ZGFAX[] g_FAX,
           th.co.ais.webservice.getven.bean.ZGMOBILE[] g_MOBILE,
           th.co.ais.webservice.getven.bean.ZGPROFILE[] g_PROFILE,
           th.co.ais.webservice.getven.bean.ZGTEL[] g_TEL,
           java.lang.String LIFNR,
           java.lang.String ROLE,
           java.lang.String ROLETYPE,
           java.lang.String STCD3,
           th.co.ais.webservice.getven.bean.EBPP_MESSAGES[] t_MESSAGES) {
           this.BRANCH = BRANCH;
           this.BUKRS = BUKRS;
           this.c_VENDOR = c_VENDOR;
           this.c_WTAX = c_WTAX;
           this.g_EMAIL = g_EMAIL;
           this.g_FAX = g_FAX;
           this.g_MOBILE = g_MOBILE;
           this.g_PROFILE = g_PROFILE;
           this.g_TEL = g_TEL;
           this.LIFNR = LIFNR;
           this.ROLE = ROLE;
           this.ROLETYPE = ROLETYPE;
           this.STCD3 = STCD3;
           this.t_MESSAGES = t_MESSAGES;
    }


    /**
     * Gets the BRANCH value for this Z_FIAP_SEM_GET_VEN.
     * 
     * @return BRANCH
     */
    public java.lang.String getBRANCH() {
        return BRANCH;
    }


    /**
     * Sets the BRANCH value for this Z_FIAP_SEM_GET_VEN.
     * 
     * @param BRANCH
     */
    public void setBRANCH(java.lang.String BRANCH) {
        this.BRANCH = BRANCH;
    }


    /**
     * Gets the BUKRS value for this Z_FIAP_SEM_GET_VEN.
     * 
     * @return BUKRS
     */
    public java.lang.String getBUKRS() {
        return BUKRS;
    }


    /**
     * Sets the BUKRS value for this Z_FIAP_SEM_GET_VEN.
     * 
     * @param BUKRS
     */
    public void setBUKRS(java.lang.String BUKRS) {
        this.BUKRS = BUKRS;
    }


    /**
     * Gets the c_VENDOR value for this Z_FIAP_SEM_GET_VEN.
     * 
     * @return c_VENDOR
     */
    public th.co.ais.webservice.getven.bean.ZCVENDOR[] getC_VENDOR() {
        return c_VENDOR;
    }


    /**
     * Sets the c_VENDOR value for this Z_FIAP_SEM_GET_VEN.
     * 
     * @param c_VENDOR
     */
    public void setC_VENDOR(th.co.ais.webservice.getven.bean.ZCVENDOR[] c_VENDOR) {
        this.c_VENDOR = c_VENDOR;
    }


    /**
     * Gets the c_WTAX value for this Z_FIAP_SEM_GET_VEN.
     * 
     * @return c_WTAX
     */
    public th.co.ais.webservice.getven.bean.ZCWTAX[] getC_WTAX() {
        return c_WTAX;
    }


    /**
     * Sets the c_WTAX value for this Z_FIAP_SEM_GET_VEN.
     * 
     * @param c_WTAX
     */
    public void setC_WTAX(th.co.ais.webservice.getven.bean.ZCWTAX[] c_WTAX) {
        this.c_WTAX = c_WTAX;
    }


    /**
     * Gets the g_EMAIL value for this Z_FIAP_SEM_GET_VEN.
     * 
     * @return g_EMAIL
     */
    public th.co.ais.webservice.getven.bean.ZGEMAIL[] getG_EMAIL() {
        return g_EMAIL;
    }


    /**
     * Sets the g_EMAIL value for this Z_FIAP_SEM_GET_VEN.
     * 
     * @param g_EMAIL
     */
    public void setG_EMAIL(th.co.ais.webservice.getven.bean.ZGEMAIL[] g_EMAIL) {
        this.g_EMAIL = g_EMAIL;
    }


    /**
     * Gets the g_FAX value for this Z_FIAP_SEM_GET_VEN.
     * 
     * @return g_FAX
     */
    public th.co.ais.webservice.getven.bean.ZGFAX[] getG_FAX() {
        return g_FAX;
    }


    /**
     * Sets the g_FAX value for this Z_FIAP_SEM_GET_VEN.
     * 
     * @param g_FAX
     */
    public void setG_FAX(th.co.ais.webservice.getven.bean.ZGFAX[] g_FAX) {
        this.g_FAX = g_FAX;
    }


    /**
     * Gets the g_MOBILE value for this Z_FIAP_SEM_GET_VEN.
     * 
     * @return g_MOBILE
     */
    public th.co.ais.webservice.getven.bean.ZGMOBILE[] getG_MOBILE() {
        return g_MOBILE;
    }


    /**
     * Sets the g_MOBILE value for this Z_FIAP_SEM_GET_VEN.
     * 
     * @param g_MOBILE
     */
    public void setG_MOBILE(th.co.ais.webservice.getven.bean.ZGMOBILE[] g_MOBILE) {
        this.g_MOBILE = g_MOBILE;
    }


    /**
     * Gets the g_PROFILE value for this Z_FIAP_SEM_GET_VEN.
     * 
     * @return g_PROFILE
     */
    public th.co.ais.webservice.getven.bean.ZGPROFILE[] getG_PROFILE() {
        return g_PROFILE;
    }


    /**
     * Sets the g_PROFILE value for this Z_FIAP_SEM_GET_VEN.
     * 
     * @param g_PROFILE
     */
    public void setG_PROFILE(th.co.ais.webservice.getven.bean.ZGPROFILE[] g_PROFILE) {
        this.g_PROFILE = g_PROFILE;
    }


    /**
     * Gets the g_TEL value for this Z_FIAP_SEM_GET_VEN.
     * 
     * @return g_TEL
     */
    public th.co.ais.webservice.getven.bean.ZGTEL[] getG_TEL() {
        return g_TEL;
    }


    /**
     * Sets the g_TEL value for this Z_FIAP_SEM_GET_VEN.
     * 
     * @param g_TEL
     */
    public void setG_TEL(th.co.ais.webservice.getven.bean.ZGTEL[] g_TEL) {
        this.g_TEL = g_TEL;
    }


    /**
     * Gets the LIFNR value for this Z_FIAP_SEM_GET_VEN.
     * 
     * @return LIFNR
     */
    public java.lang.String getLIFNR() {
        return LIFNR;
    }


    /**
     * Sets the LIFNR value for this Z_FIAP_SEM_GET_VEN.
     * 
     * @param LIFNR
     */
    public void setLIFNR(java.lang.String LIFNR) {
        this.LIFNR = LIFNR;
    }


    /**
     * Gets the ROLE value for this Z_FIAP_SEM_GET_VEN.
     * 
     * @return ROLE
     */
    public java.lang.String getROLE() {
        return ROLE;
    }


    /**
     * Sets the ROLE value for this Z_FIAP_SEM_GET_VEN.
     * 
     * @param ROLE
     */
    public void setROLE(java.lang.String ROLE) {
        this.ROLE = ROLE;
    }


    /**
     * Gets the ROLETYPE value for this Z_FIAP_SEM_GET_VEN.
     * 
     * @return ROLETYPE
     */
    public java.lang.String getROLETYPE() {
        return ROLETYPE;
    }


    /**
     * Sets the ROLETYPE value for this Z_FIAP_SEM_GET_VEN.
     * 
     * @param ROLETYPE
     */
    public void setROLETYPE(java.lang.String ROLETYPE) {
        this.ROLETYPE = ROLETYPE;
    }


    /**
     * Gets the STCD3 value for this Z_FIAP_SEM_GET_VEN.
     * 
     * @return STCD3
     */
    public java.lang.String getSTCD3() {
        return STCD3;
    }


    /**
     * Sets the STCD3 value for this Z_FIAP_SEM_GET_VEN.
     * 
     * @param STCD3
     */
    public void setSTCD3(java.lang.String STCD3) {
        this.STCD3 = STCD3;
    }


    /**
     * Gets the t_MESSAGES value for this Z_FIAP_SEM_GET_VEN.
     * 
     * @return t_MESSAGES
     */
    public th.co.ais.webservice.getven.bean.EBPP_MESSAGES[] getT_MESSAGES() {
        return t_MESSAGES;
    }


    /**
     * Sets the t_MESSAGES value for this Z_FIAP_SEM_GET_VEN.
     * 
     * @param t_MESSAGES
     */
    public void setT_MESSAGES(th.co.ais.webservice.getven.bean.EBPP_MESSAGES[] t_MESSAGES) {
        this.t_MESSAGES = t_MESSAGES;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Z_FIAP_SEM_GET_VEN)) return false;
        Z_FIAP_SEM_GET_VEN other = (Z_FIAP_SEM_GET_VEN) obj;
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
            ((this.c_VENDOR==null && other.getC_VENDOR()==null) || 
             (this.c_VENDOR!=null &&
              java.util.Arrays.equals(this.c_VENDOR, other.getC_VENDOR()))) &&
            ((this.c_WTAX==null && other.getC_WTAX()==null) || 
             (this.c_WTAX!=null &&
              java.util.Arrays.equals(this.c_WTAX, other.getC_WTAX()))) &&
            ((this.g_EMAIL==null && other.getG_EMAIL()==null) || 
             (this.g_EMAIL!=null &&
              java.util.Arrays.equals(this.g_EMAIL, other.getG_EMAIL()))) &&
            ((this.g_FAX==null && other.getG_FAX()==null) || 
             (this.g_FAX!=null &&
              java.util.Arrays.equals(this.g_FAX, other.getG_FAX()))) &&
            ((this.g_MOBILE==null && other.getG_MOBILE()==null) || 
             (this.g_MOBILE!=null &&
              java.util.Arrays.equals(this.g_MOBILE, other.getG_MOBILE()))) &&
            ((this.g_PROFILE==null && other.getG_PROFILE()==null) || 
             (this.g_PROFILE!=null &&
              java.util.Arrays.equals(this.g_PROFILE, other.getG_PROFILE()))) &&
            ((this.g_TEL==null && other.getG_TEL()==null) || 
             (this.g_TEL!=null &&
              java.util.Arrays.equals(this.g_TEL, other.getG_TEL()))) &&
            ((this.LIFNR==null && other.getLIFNR()==null) || 
             (this.LIFNR!=null &&
              this.LIFNR.equals(other.getLIFNR()))) &&
            ((this.ROLE==null && other.getROLE()==null) || 
             (this.ROLE!=null &&
              this.ROLE.equals(other.getROLE()))) &&
            ((this.ROLETYPE==null && other.getROLETYPE()==null) || 
             (this.ROLETYPE!=null &&
              this.ROLETYPE.equals(other.getROLETYPE()))) &&
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
        if (getC_VENDOR() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getC_VENDOR());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getC_VENDOR(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getC_WTAX() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getC_WTAX());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getC_WTAX(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getG_EMAIL() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getG_EMAIL());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getG_EMAIL(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getG_FAX() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getG_FAX());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getG_FAX(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getG_MOBILE() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getG_MOBILE());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getG_MOBILE(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getG_PROFILE() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getG_PROFILE());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getG_PROFILE(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getG_TEL() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getG_TEL());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getG_TEL(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLIFNR() != null) {
            _hashCode += getLIFNR().hashCode();
        }
        if (getROLE() != null) {
            _hashCode += getROLE().hashCode();
        }
        if (getROLETYPE() != null) {
            _hashCode += getROLETYPE().hashCode();
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
        new org.apache.axis.description.TypeDesc(Z_FIAP_SEM_GET_VEN.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", ">Z_FIAP_SEM_GET_VEN"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BRANCH");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BRANCH"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BUKRS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BUKRS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("c_VENDOR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "C_VENDOR"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZCVENDOR"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("c_WTAX");
        elemField.setXmlName(new javax.xml.namespace.QName("", "C_WTAX"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZCWTAX"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("g_EMAIL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "G_EMAIL"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZGEMAIL"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("g_FAX");
        elemField.setXmlName(new javax.xml.namespace.QName("", "G_FAX"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZGFAX"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("g_MOBILE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "G_MOBILE"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZGMOBILE"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("g_PROFILE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "G_PROFILE"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZGPROFILE"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("g_TEL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "G_TEL"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZGTEL"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LIFNR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LIFNR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ROLE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ROLE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ROLETYPE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ROLETYPE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("STCD3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "STCD3"));
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
