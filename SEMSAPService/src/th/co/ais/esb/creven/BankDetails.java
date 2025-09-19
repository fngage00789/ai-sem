package th.co.ais.esb.creven;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class BankDetails {
	
	@XmlAttribute(name = "actionCode")
	private String actionCode;
	
	@XmlElement(name = "ID")
	private String id;
	
	@XmlElement(name = "BankDirectoryReference")
	private BankDirectoryReference bankDirectoryReference;
	
	@XmlElement(name = "BankAccountHolderName")
	private String bankAccountHolderName;
	
	@XmlElement(name = "Name", nillable = true)
	private String name;
	
	@XmlElement(name = "BankAccountID")
	private String bankAccountID;
	
	@XmlElement(name = "BankAccountIDLong")
	private String bankAccountIDLong;
	
	@XmlElement(name = "BankAccountStandardID", nillable = true)
	private String bankAccountStandardID;
	
	@XmlElement(name = "SubstituteBusinessPartnerBankDetailsID", nillable = true)
	private String substituteBusinessPartnerBankDetailsID;
	
	@XmlElement(name = "SubstituteDate", nillable = true)
	private Date substituteDate;
	
	@XmlElement(name = "ValidityPeriod")
	private ValidityPeriod validityPeriod;
	
	@XmlElement(name = "CollectionAuthorisationIndicator", nillable = true)
	private String collectionAuthorisationIndicator;
	
	@XmlElement(name = "BankControlKey", nillable = true)
	private String bankControlKey;
	
	@XmlElement(name = "SpecificationsDescription", nillable = true)
	private String specificationsDescription;
	
	@XmlElement(name = "BankAccountExternalID", nillable = true)
	private String bankAccountExternalID;

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BankDirectoryReference getBankDirectoryReference() {
		return bankDirectoryReference;
	}

	public void setBankDirectoryReference(BankDirectoryReference bankDirectoryReference) {
		this.bankDirectoryReference = bankDirectoryReference;
	}

	public String getBankAccountHolderName() {
		return bankAccountHolderName;
	}

	public void setBankAccountHolderName(String bankAccountHolderName) {
		this.bankAccountHolderName = bankAccountHolderName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBankAccountID() {
		return bankAccountID;
	}

	public void setBankAccountID(String bankAccountID) {
		this.bankAccountID = bankAccountID;
	}

	public String getBankAccountIDLong() {
		return bankAccountIDLong;
	}

	public void setBankAccountIDLong(String bankAccountIDLong) {
		this.bankAccountIDLong = bankAccountIDLong;
	}

	public String getBankAccountStandardID() {
		return bankAccountStandardID;
	}

	public void setBankAccountStandardID(String bankAccountStandardID) {
		this.bankAccountStandardID = bankAccountStandardID;
	}

	public String getSubstituteBusinessPartnerBankDetailsID() {
		return substituteBusinessPartnerBankDetailsID;
	}

	public void setSubstituteBusinessPartnerBankDetailsID(String substituteBusinessPartnerBankDetailsID) {
		this.substituteBusinessPartnerBankDetailsID = substituteBusinessPartnerBankDetailsID;
	}

	public Date getSubstituteDate() {
		return substituteDate;
	}

	public void setSubstituteDate(Date substituteDate) {
		this.substituteDate = substituteDate;
	}

	public ValidityPeriod getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(ValidityPeriod validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public String getCollectionAuthorisationIndicator() {
		return collectionAuthorisationIndicator;
	}

	public void setCollectionAuthorisationIndicator(String collectionAuthorisationIndicator) {
		this.collectionAuthorisationIndicator = collectionAuthorisationIndicator;
	}

	public String getBankControlKey() {
		return bankControlKey;
	}

	public void setBankControlKey(String bankControlKey) {
		this.bankControlKey = bankControlKey;
	}

	public String getSpecificationsDescription() {
		return specificationsDescription;
	}

	public void setSpecificationsDescription(String specificationsDescription) {
		this.specificationsDescription = specificationsDescription;
	}

	public String getBankAccountExternalID() {
		return bankAccountExternalID;
	}

	public void setBankAccountExternalID(String bankAccountExternalID) {
		this.bankAccountExternalID = bankAccountExternalID;
	}
}
