package th.co.ais.esb.creven;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Identification {
	
	@XmlAttribute(name = "actionCode")
    private String actionCode;

    @XmlElement(name = "PartyIdentifierTypeCode")
    private String partyIdentifierTypeCode;

    @XmlElement(name = "BusinessPartnerID")
    private String businessPartnerID;

    @XmlElement(name = "IdentifierIssuingAgencyName", nillable = true)
    private String identifierIssuingAgencyName;

    @XmlElement(name = "EntryDate", nillable = true)
    private String entryDate;

    @XmlElement(name = "AreaOfValidityCountryCode", nillable = true)
    private String areaOfValidityCountryCode;

    @XmlElement(name = "AreaOfValidityRegionCode", nillable = true)
    private String areaOfValidityRegionCode;

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public String getPartyIdentifierTypeCode() {
		return partyIdentifierTypeCode;
	}

	public void setPartyIdentifierTypeCode(String partyIdentifierTypeCode) {
		this.partyIdentifierTypeCode = partyIdentifierTypeCode;
	}

	public String getBusinessPartnerID() {
		return businessPartnerID;
	}

	public void setBusinessPartnerID(String businessPartnerID) {
		this.businessPartnerID = businessPartnerID;
	}

	public String getIdentifierIssuingAgencyName() {
		return identifierIssuingAgencyName;
	}

	public void setIdentifierIssuingAgencyName(String identifierIssuingAgencyName) {
		this.identifierIssuingAgencyName = identifierIssuingAgencyName;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getAreaOfValidityCountryCode() {
		return areaOfValidityCountryCode;
	}

	public void setAreaOfValidityCountryCode(String areaOfValidityCountryCode) {
		this.areaOfValidityCountryCode = areaOfValidityCountryCode;
	}

	public String getAreaOfValidityRegionCode() {
		return areaOfValidityRegionCode;
	}

	public void setAreaOfValidityRegionCode(String areaOfValidityRegionCode) {
		this.areaOfValidityRegionCode = areaOfValidityRegionCode;
	}
}
