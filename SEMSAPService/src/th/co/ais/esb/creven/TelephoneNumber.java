package th.co.ais.esb.creven;

import javax.xml.bind.annotation.XmlElement;

public class TelephoneNumber {
	
	@XmlElement(name = "SubscriberID")
    private String subscriberID;

    @XmlElement(name = "ExtensionID", nillable = true)
    private String extensionID;

    @XmlElement(name = "CountryCode")
    private String countryCode;

	public String getSubscriberID() {
		return subscriberID;
	}

	public void setSubscriberID(String subscriberID) {
		this.subscriberID = subscriberID;
	}

	public String getExtensionID() {
		return extensionID;
	}

	public void setExtensionID(String extensionID) {
		this.extensionID = extensionID;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
}
