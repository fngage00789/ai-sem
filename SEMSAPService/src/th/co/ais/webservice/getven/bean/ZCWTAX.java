/**
 * ZCWTAX.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package th.co.ais.webservice.getven.bean;

public class ZCWTAX  implements java.io.Serializable {
    private java.lang.String WITHT;

    private java.lang.String WT_WITHCD;

    private java.lang.String QSREC;

    public ZCWTAX() {
    }

    public ZCWTAX(
           java.lang.String WITHT,
           java.lang.String WT_WITHCD,
           java.lang.String QSREC) {
           this.WITHT = WITHT;
           this.WT_WITHCD = WT_WITHCD;
           this.QSREC = QSREC;
    }


    /**
     * Gets the WITHT value for this ZCWTAX.
     * 
     * @return WITHT
     */
    public java.lang.String getWITHT() {
        return WITHT;
    }


    /**
     * Sets the WITHT value for this ZCWTAX.
     * 
     * @param WITHT
     */
    public void setWITHT(java.lang.String WITHT) {
        this.WITHT = WITHT;
    }


    /**
     * Gets the WT_WITHCD value for this ZCWTAX.
     * 
     * @return WT_WITHCD
     */
    public java.lang.String getWT_WITHCD() {
        return WT_WITHCD;
    }


    /**
     * Sets the WT_WITHCD value for this ZCWTAX.
     * 
     * @param WT_WITHCD
     */
    public void setWT_WITHCD(java.lang.String WT_WITHCD) {
        this.WT_WITHCD = WT_WITHCD;
    }


    /**
     * Gets the QSREC value for this ZCWTAX.
     * 
     * @return QSREC
     */
    public java.lang.String getQSREC() {
        return QSREC;
    }


    /**
     * Sets the QSREC value for this ZCWTAX.
     * 
     * @param QSREC
     */
    public void setQSREC(java.lang.String QSREC) {
        this.QSREC = QSREC;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZCWTAX)) return false;
        ZCWTAX other = (ZCWTAX) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.WITHT==null && other.getWITHT()==null) || 
             (this.WITHT!=null &&
              this.WITHT.equals(other.getWITHT()))) &&
            ((this.WT_WITHCD==null && other.getWT_WITHCD()==null) || 
             (this.WT_WITHCD!=null &&
              this.WT_WITHCD.equals(other.getWT_WITHCD()))) &&
            ((this.QSREC==null && other.getQSREC()==null) || 
             (this.QSREC!=null &&
              this.QSREC.equals(other.getQSREC())));
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
        if (getWITHT() != null) {
            _hashCode += getWITHT().hashCode();
        }
        if (getWT_WITHCD() != null) {
            _hashCode += getWT_WITHCD().hashCode();
        }
        if (getQSREC() != null) {
            _hashCode += getQSREC().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZCWTAX.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZCWTAX"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("WITHT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "WITHT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("WT_WITHCD");
        elemField.setXmlName(new javax.xml.namespace.QName("", "WT_WITHCD"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("QSREC");
        elemField.setXmlName(new javax.xml.namespace.QName("", "QSREC"));
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
