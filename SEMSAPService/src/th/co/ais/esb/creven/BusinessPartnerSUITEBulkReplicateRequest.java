package th.co.ais.esb.creven;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "n0:BusinessPartnerSUITEBulkReplicateRequest")
public class BusinessPartnerSUITEBulkReplicateRequest {

    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:n0")
    private String xmlnsN0 = "http://sap.com/xi/SAPGlobal20/Global";

    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:prx")
    private String xmlnsPrx = "urn:sap.com:proxy:S4D:/1SAI/TAE241F043334E5E7703A7F:758";
    
    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:n1")
    private String xmlnsN1 = "http://ais.th/sap/CustomFields/BranchCode";
    
    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:n2")
    private String xmlnsN2 = "http://ais.th/sap/CustomFields/CollectionProfile";
    
    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:n3")
    private String xmlnsN3 = "http://ais.th/sap/CustomFields/CreditSegment";
    
    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:n4")
    private String xmlnsN4 = "http://ais.th/sap/CustomFields/CustWithHoldingTax";
    
    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:n5")
    private String xmlnsN5 = "http://ais.th/sap/CustomFields/Plant";
    
    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:n6")
    private String xmlnsN6 = "http://ais.th/sap/CustomFields/PurchOrgEnhancement";

    @JacksonXmlProperty(localName = "MessageHeader")
    private MessageHeader messageHeader;

    @JacksonXmlProperty(localName = "BusinessPartnerSUITEReplicateRequestMessage")
    private BusinessPartnerSUITEReplicateRequestMessage businessPartnerSUITEReplicateRequestMessage;

	public String getXmlnsN0() {
		return xmlnsN0;
	}

	public void setXmlnsN0(String xmlnsN0) {
		this.xmlnsN0 = xmlnsN0;
	}

	public String getXmlnsPrx() {
		return xmlnsPrx;
	}

	public void setXmlnsPrx(String xmlnsPrx) {
		this.xmlnsPrx = xmlnsPrx;
	}

	public String getXmlnsN1() {
		return xmlnsN1;
	}

	public void setXmlnsN1(String xmlnsN1) {
		this.xmlnsN1 = xmlnsN1;
	}

	public String getXmlnsN2() {
		return xmlnsN2;
	}

	public void setXmlnsN2(String xmlnsN2) {
		this.xmlnsN2 = xmlnsN2;
	}

	public String getXmlnsN3() {
		return xmlnsN3;
	}

	public void setXmlnsN3(String xmlnsN3) {
		this.xmlnsN3 = xmlnsN3;
	}

	public String getXmlnsN4() {
		return xmlnsN4;
	}

	public void setXmlnsN4(String xmlnsN4) {
		this.xmlnsN4 = xmlnsN4;
	}

	public String getXmlnsN5() {
		return xmlnsN5;
	}

	public void setXmlnsN5(String xmlnsN5) {
		this.xmlnsN5 = xmlnsN5;
	}

	public String getXmlnsN6() {
		return xmlnsN6;
	}

	public void setXmlnsN6(String xmlnsN6) {
		this.xmlnsN6 = xmlnsN6;
	}

	public MessageHeader getMessageHeader() {
		return messageHeader;
	}

	public void setMessageHeader(MessageHeader messageHeader) {
		this.messageHeader = messageHeader;
	}

	public BusinessPartnerSUITEReplicateRequestMessage getBusinessPartnerSUITEReplicateRequestMessage() {
		return businessPartnerSUITEReplicateRequestMessage;
	}

	public void setBusinessPartnerSUITEReplicateRequestMessage(
			BusinessPartnerSUITEReplicateRequestMessage businessPartnerSUITEReplicateRequestMessage) {
		this.businessPartnerSUITEReplicateRequestMessage = businessPartnerSUITEReplicateRequestMessage;
	}
}
