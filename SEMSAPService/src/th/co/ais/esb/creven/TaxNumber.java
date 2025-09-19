package th.co.ais.esb.creven;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class TaxNumber {

	@XmlAttribute(name = "actionCode")
    private String actionCode;

    @XmlElement(name = "CountryCode")
    private String countryCode;

    @XmlElement(name = "TaxIdentificationNumberTypeCode")
    private String taxIdentificationNumberTypeCode;

    @XmlElement(name = "LONG_TaxIdentificationNumberTypeCode")
    private String longTaxIdentificationNumberTypeCode;

    @XmlElement(name = "PartyTaxID")
    private PartyTaxID partyTaxID;

    @XmlElement(name = "LONG_PartyTaxID", nillable = true)
    private LongPartyTaxID longPartyTaxID;

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getTaxIdentificationNumberTypeCode() {
		return taxIdentificationNumberTypeCode;
	}

	public void setTaxIdentificationNumberTypeCode(String taxIdentificationNumberTypeCode) {
		this.taxIdentificationNumberTypeCode = taxIdentificationNumberTypeCode;
	}

	public String getLongTaxIdentificationNumberTypeCode() {
		return longTaxIdentificationNumberTypeCode;
	}

	public void setLongTaxIdentificationNumberTypeCode(String longTaxIdentificationNumberTypeCode) {
		this.longTaxIdentificationNumberTypeCode = longTaxIdentificationNumberTypeCode;
	}

	public PartyTaxID getPartyTaxID() {
		return partyTaxID;
	}

	public void setPartyTaxID(PartyTaxID partyTaxID) {
		this.partyTaxID = partyTaxID;
	}

	public LongPartyTaxID getLongPartyTaxID() {
		return longPartyTaxID;
	}

	public void setLongPartyTaxID(LongPartyTaxID longPartyTaxID) {
		this.longPartyTaxID = longPartyTaxID;
	}
}
