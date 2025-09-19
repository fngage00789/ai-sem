package th.co.ais.esb.creven;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Supplier {

    @XmlAttribute(name = "accountingInformationListCompleteTransmissionIndicator")
    private boolean accountingInformationListCompleteTransmissionIndicator;

    @XmlAttribute(name = "procurementCardIssuingInstitutesListCompleteTransmissionIndicator")
    private boolean procurementCardIssuingInstitutesListCompleteTransmissionIndicator;

    @XmlAttribute(name = "qualitiyManagementListCompleteTransmissionIndicator")
    private boolean qualitiyManagementListCompleteTransmissionIndicator;

    @XmlAttribute(name = "procurementArrangementListCompleteTransmissionIndicator")
    private boolean procurementArrangementListCompleteTransmissionIndicator;

    @XmlAttribute(name = "subRangeListCompleteTransmissionIndicator")
    private boolean subRangeListCompleteTransmissionIndicator;

    @XmlAttribute(name = "supplierTextListCompleteTransmissionIndicator")
    private boolean supplierTextListCompleteTransmissionIndicator;

    @XmlAttribute(name = "supplierDocumentListCompleteTransmissionIndicator")
    private boolean supplierDocumentListCompleteTransmissionIndicator;

    @XmlAttribute(name = "propertyListCompleteTransmissionIndicator")
    private boolean propertyListCompleteTransmissionIndicator;

    @XmlAttribute(name = "propertyValuationCompleteTransmissionIndicator")
    private boolean propertyValuationCompleteTransmissionIndicator;

    @XmlAttribute(name = "permittedPayeeListCompleteTransmissionIndicator")
    private boolean permittedPayeeListCompleteTransmissionIndicator;

    @XmlElement(name = "InternalID")
    private String internalID;

    @XmlElement(name = "CreditorInformationNumber", nillable = true)
    private String creditorInformationNumber;

    @XmlElement(name = "MaintenanceProfileCode")
    private String maintenanceProfileCode;

    @XmlElement(name = "ProcurementTransactionBlockingCode", nillable = true)
    private String procurementTransactionBlockingCode;

    @XmlElement(name = "DeletionBlockedIndicator")
    private boolean deletionBlockedIndicator;

    @XmlElement(name = "DeletedIndicator")
    private boolean deletedIndicator;

    @XmlElement(name = "PostingBlockedIndicator")
    private boolean postingBlockedIndicator;

    @XmlElement(name = "PurchasingBlockedIndicator")
    private boolean purchasingBlockedIndicator;

    @XmlElement(name = "TradingPartnerCompanyID", nillable = true)
    private String tradingPartnerCompanyID;

    @XmlElement(name = "ManufacturerPartyID", nillable = true)
    private String manufacturerPartyID;

    @XmlElement(name = "AuthorisationGroupCode", nillable = true)
    private String authorisationGroupCode;

    @XmlElement(name = "CorporateGroupName", nillable = true)
    private String corporateGroupName;

    @XmlElement(name = "ProofOfDeliveryRequirementCode", nillable = true)
    private String proofOfDeliveryRequirementCode;

    @XmlElement(name = "CreditDataLastCheckDate", nillable = true)
    private String creditDataLastCheckDate;

    @XmlElement(name = "AccountingInformation")
    private List<AccountingInformation> accountingInformation;

	public boolean isAccountingInformationListCompleteTransmissionIndicator() {
		return accountingInformationListCompleteTransmissionIndicator;
	}

	public void setAccountingInformationListCompleteTransmissionIndicator(
			boolean accountingInformationListCompleteTransmissionIndicator) {
		this.accountingInformationListCompleteTransmissionIndicator = accountingInformationListCompleteTransmissionIndicator;
	}

	public boolean isProcurementCardIssuingInstitutesListCompleteTransmissionIndicator() {
		return procurementCardIssuingInstitutesListCompleteTransmissionIndicator;
	}

	public void setProcurementCardIssuingInstitutesListCompleteTransmissionIndicator(
			boolean procurementCardIssuingInstitutesListCompleteTransmissionIndicator) {
		this.procurementCardIssuingInstitutesListCompleteTransmissionIndicator = procurementCardIssuingInstitutesListCompleteTransmissionIndicator;
	}

	public boolean isQualitiyManagementListCompleteTransmissionIndicator() {
		return qualitiyManagementListCompleteTransmissionIndicator;
	}

	public void setQualitiyManagementListCompleteTransmissionIndicator(
			boolean qualitiyManagementListCompleteTransmissionIndicator) {
		this.qualitiyManagementListCompleteTransmissionIndicator = qualitiyManagementListCompleteTransmissionIndicator;
	}

	public boolean isProcurementArrangementListCompleteTransmissionIndicator() {
		return procurementArrangementListCompleteTransmissionIndicator;
	}

	public void setProcurementArrangementListCompleteTransmissionIndicator(
			boolean procurementArrangementListCompleteTransmissionIndicator) {
		this.procurementArrangementListCompleteTransmissionIndicator = procurementArrangementListCompleteTransmissionIndicator;
	}

	public boolean isSubRangeListCompleteTransmissionIndicator() {
		return subRangeListCompleteTransmissionIndicator;
	}

	public void setSubRangeListCompleteTransmissionIndicator(boolean subRangeListCompleteTransmissionIndicator) {
		this.subRangeListCompleteTransmissionIndicator = subRangeListCompleteTransmissionIndicator;
	}

	public boolean isSupplierTextListCompleteTransmissionIndicator() {
		return supplierTextListCompleteTransmissionIndicator;
	}

	public void setSupplierTextListCompleteTransmissionIndicator(boolean supplierTextListCompleteTransmissionIndicator) {
		this.supplierTextListCompleteTransmissionIndicator = supplierTextListCompleteTransmissionIndicator;
	}

	public boolean isSupplierDocumentListCompleteTransmissionIndicator() {
		return supplierDocumentListCompleteTransmissionIndicator;
	}

	public void setSupplierDocumentListCompleteTransmissionIndicator(
			boolean supplierDocumentListCompleteTransmissionIndicator) {
		this.supplierDocumentListCompleteTransmissionIndicator = supplierDocumentListCompleteTransmissionIndicator;
	}

	public boolean isPropertyListCompleteTransmissionIndicator() {
		return propertyListCompleteTransmissionIndicator;
	}

	public void setPropertyListCompleteTransmissionIndicator(boolean propertyListCompleteTransmissionIndicator) {
		this.propertyListCompleteTransmissionIndicator = propertyListCompleteTransmissionIndicator;
	}

	public boolean isPropertyValuationCompleteTransmissionIndicator() {
		return propertyValuationCompleteTransmissionIndicator;
	}

	public void setPropertyValuationCompleteTransmissionIndicator(boolean propertyValuationCompleteTransmissionIndicator) {
		this.propertyValuationCompleteTransmissionIndicator = propertyValuationCompleteTransmissionIndicator;
	}

	public boolean isPermittedPayeeListCompleteTransmissionIndicator() {
		return permittedPayeeListCompleteTransmissionIndicator;
	}

	public void setPermittedPayeeListCompleteTransmissionIndicator(
			boolean permittedPayeeListCompleteTransmissionIndicator) {
		this.permittedPayeeListCompleteTransmissionIndicator = permittedPayeeListCompleteTransmissionIndicator;
	}

	public String getInternalID() {
		return internalID;
	}

	public void setInternalID(String internalID) {
		this.internalID = internalID;
	}

	public String getCreditorInformationNumber() {
		return creditorInformationNumber;
	}

	public void setCreditorInformationNumber(String creditorInformationNumber) {
		this.creditorInformationNumber = creditorInformationNumber;
	}

	public String getMaintenanceProfileCode() {
		return maintenanceProfileCode;
	}

	public void setMaintenanceProfileCode(String maintenanceProfileCode) {
		this.maintenanceProfileCode = maintenanceProfileCode;
	}

	public String getProcurementTransactionBlockingCode() {
		return procurementTransactionBlockingCode;
	}

	public void setProcurementTransactionBlockingCode(String procurementTransactionBlockingCode) {
		this.procurementTransactionBlockingCode = procurementTransactionBlockingCode;
	}

	public boolean isDeletionBlockedIndicator() {
		return deletionBlockedIndicator;
	}

	public void setDeletionBlockedIndicator(boolean deletionBlockedIndicator) {
		this.deletionBlockedIndicator = deletionBlockedIndicator;
	}

	public boolean isDeletedIndicator() {
		return deletedIndicator;
	}

	public void setDeletedIndicator(boolean deletedIndicator) {
		this.deletedIndicator = deletedIndicator;
	}

	public boolean isPostingBlockedIndicator() {
		return postingBlockedIndicator;
	}

	public void setPostingBlockedIndicator(boolean postingBlockedIndicator) {
		this.postingBlockedIndicator = postingBlockedIndicator;
	}

	public boolean isPurchasingBlockedIndicator() {
		return purchasingBlockedIndicator;
	}

	public void setPurchasingBlockedIndicator(boolean purchasingBlockedIndicator) {
		this.purchasingBlockedIndicator = purchasingBlockedIndicator;
	}

	public String getTradingPartnerCompanyID() {
		return tradingPartnerCompanyID;
	}

	public void setTradingPartnerCompanyID(String tradingPartnerCompanyID) {
		this.tradingPartnerCompanyID = tradingPartnerCompanyID;
	}

	public String getManufacturerPartyID() {
		return manufacturerPartyID;
	}

	public void setManufacturerPartyID(String manufacturerPartyID) {
		this.manufacturerPartyID = manufacturerPartyID;
	}

	public String getAuthorisationGroupCode() {
		return authorisationGroupCode;
	}

	public void setAuthorisationGroupCode(String authorisationGroupCode) {
		this.authorisationGroupCode = authorisationGroupCode;
	}

	public String getCorporateGroupName() {
		return corporateGroupName;
	}

	public void setCorporateGroupName(String corporateGroupName) {
		this.corporateGroupName = corporateGroupName;
	}

	public String getProofOfDeliveryRequirementCode() {
		return proofOfDeliveryRequirementCode;
	}

	public void setProofOfDeliveryRequirementCode(String proofOfDeliveryRequirementCode) {
		this.proofOfDeliveryRequirementCode = proofOfDeliveryRequirementCode;
	}

	public String getCreditDataLastCheckDate() {
		return creditDataLastCheckDate;
	}

	public void setCreditDataLastCheckDate(String creditDataLastCheckDate) {
		this.creditDataLastCheckDate = creditDataLastCheckDate;
	}

	public List<AccountingInformation> getAccountingInformation() {
		return accountingInformation;
	}

	public void setAccountingInformation(List<AccountingInformation> accountingInformation) {
		this.accountingInformation = accountingInformation;
	}
}
