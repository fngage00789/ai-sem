package th.co.ais.esb.creven;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Common {
	
	@XmlAttribute(name = "actionCode")
    private String actionCode;

    @XmlElement(name = "LocationStandardID")
    private String locationStandardID;

    @XmlElement(name = "BusinessPartnerGroupCode", nillable = true)
    private String businessPartnerGroupCode;

    @XmlElement(name = "DeletedIndicator")
    private boolean deletedIndicator;

    @XmlElement(name = "ReleasedIndicator")
    private boolean releasedIndicator;

    @XmlElement(name = "BlockedIndicator")
    private boolean blockedIndicator;

    @XmlElement(name = "BusinessPartnerAuthorisationGroupCode", nillable = true)
    private String businessPartnerAuthorisationGroupCode;

    @XmlElement(name = "KeyWordsText")
    private String keyWordsText;

    @XmlElement(name = "AdditionalKeyWordsText", nillable = true)
    private String additionalKeyWordsText;

    @XmlElement(name = "VerbalCommunicationLanguageCode", nillable = true)
    private String verbalCommunicationLanguageCode;

    @XmlElement(name = "SalutationText", nillable = true)
    private String salutationText;

    @XmlElement(name = "CorrespondenceBrailleRequiredIndicator")
    private boolean correspondenceBrailleRequiredIndicator;

    @XmlElement(name = "CorrespondenceLargePrintRequiredIndicator")
    private boolean correspondenceLargePrintRequiredIndicator;

    @XmlElement(name = "NaturalPersonIndicator")
    private boolean naturalPersonIndicator;

    @XmlElement(name = "ContactAllowedCode", nillable = true)
    private String contactAllowedCode;

    @XmlElement(name = "LegacyBusinessPartnerID", nillable = true)
    private String legacyBusinessPartnerID;

    @XmlElement(name = "DataOriginTypeCode", nillable = true)
    private String dataOriginTypeCode;

    @XmlElement(name = "Person")
    private Person person;

    @XmlElement(name = "Organisation")
    private Organisation organisation;

    @XmlElement(name = "Group")
    private Group group;

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public String getLocationStandardID() {
		return locationStandardID;
	}

	public void setLocationStandardID(String locationStandardID) {
		this.locationStandardID = locationStandardID;
	}

	public String getBusinessPartnerGroupCode() {
		return businessPartnerGroupCode;
	}

	public void setBusinessPartnerGroupCode(String businessPartnerGroupCode) {
		this.businessPartnerGroupCode = businessPartnerGroupCode;
	}

	public boolean isDeletedIndicator() {
		return deletedIndicator;
	}

	public void setDeletedIndicator(boolean deletedIndicator) {
		this.deletedIndicator = deletedIndicator;
	}

	public boolean isReleasedIndicator() {
		return releasedIndicator;
	}

	public void setReleasedIndicator(boolean releasedIndicator) {
		this.releasedIndicator = releasedIndicator;
	}

	public boolean isBlockedIndicator() {
		return blockedIndicator;
	}

	public void setBlockedIndicator(boolean blockedIndicator) {
		this.blockedIndicator = blockedIndicator;
	}

	public String getBusinessPartnerAuthorisationGroupCode() {
		return businessPartnerAuthorisationGroupCode;
	}

	public void setBusinessPartnerAuthorisationGroupCode(String businessPartnerAuthorisationGroupCode) {
		this.businessPartnerAuthorisationGroupCode = businessPartnerAuthorisationGroupCode;
	}

	public String getKeyWordsText() {
		return keyWordsText;
	}

	public void setKeyWordsText(String keyWordsText) {
		this.keyWordsText = keyWordsText;
	}

	public String getAdditionalKeyWordsText() {
		return additionalKeyWordsText;
	}

	public void setAdditionalKeyWordsText(String additionalKeyWordsText) {
		this.additionalKeyWordsText = additionalKeyWordsText;
	}

	public String getVerbalCommunicationLanguageCode() {
		return verbalCommunicationLanguageCode;
	}

	public void setVerbalCommunicationLanguageCode(String verbalCommunicationLanguageCode) {
		this.verbalCommunicationLanguageCode = verbalCommunicationLanguageCode;
	}

	public String getSalutationText() {
		return salutationText;
	}

	public void setSalutationText(String salutationText) {
		this.salutationText = salutationText;
	}

	public boolean isCorrespondenceBrailleRequiredIndicator() {
		return correspondenceBrailleRequiredIndicator;
	}

	public void setCorrespondenceBrailleRequiredIndicator(boolean correspondenceBrailleRequiredIndicator) {
		this.correspondenceBrailleRequiredIndicator = correspondenceBrailleRequiredIndicator;
	}

	public boolean isCorrespondenceLargePrintRequiredIndicator() {
		return correspondenceLargePrintRequiredIndicator;
	}

	public void setCorrespondenceLargePrintRequiredIndicator(boolean correspondenceLargePrintRequiredIndicator) {
		this.correspondenceLargePrintRequiredIndicator = correspondenceLargePrintRequiredIndicator;
	}

	public boolean isNaturalPersonIndicator() {
		return naturalPersonIndicator;
	}

	public void setNaturalPersonIndicator(boolean naturalPersonIndicator) {
		this.naturalPersonIndicator = naturalPersonIndicator;
	}

	public String getContactAllowedCode() {
		return contactAllowedCode;
	}

	public void setContactAllowedCode(String contactAllowedCode) {
		this.contactAllowedCode = contactAllowedCode;
	}

	public String getLegacyBusinessPartnerID() {
		return legacyBusinessPartnerID;
	}

	public void setLegacyBusinessPartnerID(String legacyBusinessPartnerID) {
		this.legacyBusinessPartnerID = legacyBusinessPartnerID;
	}

	public String getDataOriginTypeCode() {
		return dataOriginTypeCode;
	}

	public void setDataOriginTypeCode(String dataOriginTypeCode) {
		this.dataOriginTypeCode = dataOriginTypeCode;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Organisation getOrganisation() {
		return organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
}
