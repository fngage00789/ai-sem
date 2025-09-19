package th.co.ais.esb.creven;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class BusinessPartnerSUITEReplicateRequestMessage {

    @JacksonXmlProperty(localName = "MessageHeader")
    private MessageHeader messageHeader;

    @JacksonXmlProperty(localName = "BusinessPartner")
    private BusinessPartner businessPartner;

	public MessageHeader getMessageHeader() {
		return messageHeader;
	}

	public void setMessageHeader(MessageHeader messageHeader) {
		this.messageHeader = messageHeader;
	}

	public BusinessPartner getBusinessPartner() {
		return businessPartner;
	}

	public void setBusinessPartner(BusinessPartner businessPartner) {
		this.businessPartner = businessPartner;
	}
}
