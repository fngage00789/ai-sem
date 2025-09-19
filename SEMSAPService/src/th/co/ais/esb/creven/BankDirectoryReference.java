package th.co.ais.esb.creven;

import javax.xml.bind.annotation.XmlElement;

public class BankDirectoryReference {
	
	@XmlElement(name = "BankStandardID")
    private String bankStandardID;

    @XmlElement(name = "BankCountryCode")
    private String bankCountryCode;

    @XmlElement(name = "BankInternalID")
    private String bankInternalID;

	public String getBankStandardID() {
		return bankStandardID;
	}

	public void setBankStandardID(String bankStandardID) {
		this.bankStandardID = bankStandardID;
	}

	public String getBankCountryCode() {
		return bankCountryCode;
	}

	public void setBankCountryCode(String bankCountryCode) {
		this.bankCountryCode = bankCountryCode;
	}

	public String getBankInternalID() {
		return bankInternalID;
	}

	public void setBankInternalID(String bankInternalID) {
		this.bankInternalID = bankInternalID;
	}
}
