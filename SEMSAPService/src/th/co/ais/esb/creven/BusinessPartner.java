package th.co.ais.esb.creven;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class BusinessPartner {
	
	@JacksonXmlProperty(isAttribute = true, localName = "changeOrdinalNumberValue")
    private String changeOrdinalNumberValue = "1";
	
	@JacksonXmlProperty(isAttribute = true, localName = "reconciliationPeriodCounterValue")
    private String reconciliationPeriodCounterValue = "1";
	
	@JacksonXmlProperty(isAttribute = true, localName = "multipleAssignmentListCompleteTransmissionIndicator")
    private String multipleAssignmentListCompleteTransmissionIndicator = "true";
	
	@JacksonXmlProperty(isAttribute = true, localName = "addressInformationListCompleteTransmissionIndicator")
    private String addressInformationListCompleteTransmissionIndicator = "true";
	
	@JacksonXmlProperty(isAttribute = true, localName = "addressIndependentInfoCompleteTransmissionIndicator")
    private String addressIndependentInfoCompleteTransmissionIndicator = "true";
	
	@JacksonXmlProperty(isAttribute = true, localName = "bankDetailsListCompleteTransmissionIndicator")
    private String bankDetailsListCompleteTransmissionIndicator = "true";
	
	@JacksonXmlProperty(isAttribute = true, localName = "paymentCardDetailsCompleteTransmissionIndicator")
    private String paymentCardDetailsCompleteTransmissionIndicator = "true";
	
	@JacksonXmlProperty(isAttribute = true, localName = "commonListCompleteTransmissionIndicator")
    private String commonListCompleteTransmissionIndicator = "true";
	
	@JacksonXmlProperty(isAttribute = true, localName = "roleListCompleteTransmissionIndicator")
    private String roleListCompleteTransmissionIndicator = "true";
	
	@JacksonXmlProperty(isAttribute = true, localName = "identificationListCompleteTransmissionIndicator")
    private String identificationListCompleteTransmissionIndicator = "true";
	
	@JacksonXmlProperty(isAttribute = true, localName = "industrySectorListCompleteTransmissionIndicator")
    private String industrySectorListCompleteTransmissionIndicator = "true";
	
	@JacksonXmlProperty(isAttribute = true, localName = "taxNumberListCompleteTransmissionIndicator")
    private String taxNumberListCompleteTransmissionIndicator = "true";
	
	@JacksonXmlProperty(isAttribute = true, localName = "financialServicesCompanyCodeInformationCompleteTransmissionIndicator")
    private String financialServicesCompanyCodeInformationCompleteTransmissionIndicator = "true";
	
	@JacksonXmlProperty(isAttribute = true, localName = "creditManagementCustomInformationListCompleteTransmissionIndicator")
    private String creditManagementCustomInformationListCompleteTransmissionIndicator = "true";
	
	@JacksonXmlProperty(isAttribute = true, localName = "creditManagementExternalCreditInformationListCompleteTransmissionIndicator")
    private String creditManagementExternalCreditInformationListCompleteTransmissionIndicator = "true";
	
	@JacksonXmlProperty(isAttribute = true, localName = "documentListCompleteTransmissionIndicator")
    private String documentListCompleteTransmissionIndicator = "true";

    @JacksonXmlProperty(localName = "UUID")
    private String uuid;

    @JacksonXmlProperty(localName = "InternalID")
    private String internalID;

    @JacksonXmlProperty(localName = "CategoryCode")
    private String categoryCode;

    @JacksonXmlProperty(localName = "NumberRangeIntervalBusinessPartnerGroupCode")
    private String numberRangeIntervalBusinessPartnerGroupCode;
    
    @JacksonXmlProperty(localName = "Supplier")
    private Supplier supplier;
    
    @JacksonXmlProperty(localName = "AddressInformation")
    private AddressInformation addressInformation;
    
    @JacksonXmlProperty(localName = "AddressIndependentCommInfo")
    private AddressIndependentCommInfo addressIndependentCommInfo;
    
    @JacksonXmlProperty(localName = "BankDetails")
    private BankDetails bankDetails;
    
    @JacksonXmlProperty(localName = "Common")
    private Common common;
    
    @JacksonXmlProperty(localName = "Role")
    private Role role;
    
    @JacksonXmlProperty(localName = "Identification")
    private Identification identification;
    
    @JacksonXmlProperty(localName = "TaxNumber")
    private TaxNumber taxNumber;
    
    @JacksonXmlProperty(localName = "CreditManagementCreditWorthiness")
    private CreditManagementCreditWorthiness creditManagementCreditWorthiness;
    
    @XmlElement(name = "n1:ZZBRANCHCODE")
    private ZZBRANCHCODE zzBranchCode;

	public String getChangeOrdinalNumberValue() {
		return changeOrdinalNumberValue;
	}

	public void setChangeOrdinalNumberValue(String changeOrdinalNumberValue) {
		this.changeOrdinalNumberValue = changeOrdinalNumberValue;
	}

	public String getReconciliationPeriodCounterValue() {
		return reconciliationPeriodCounterValue;
	}

	public void setReconciliationPeriodCounterValue(String reconciliationPeriodCounterValue) {
		this.reconciliationPeriodCounterValue = reconciliationPeriodCounterValue;
	}

	public String getMultipleAssignmentListCompleteTransmissionIndicator() {
		return multipleAssignmentListCompleteTransmissionIndicator;
	}

	public void setMultipleAssignmentListCompleteTransmissionIndicator(
			String multipleAssignmentListCompleteTransmissionIndicator) {
		this.multipleAssignmentListCompleteTransmissionIndicator = multipleAssignmentListCompleteTransmissionIndicator;
	}

	public String getAddressInformationListCompleteTransmissionIndicator() {
		return addressInformationListCompleteTransmissionIndicator;
	}

	public void setAddressInformationListCompleteTransmissionIndicator(
			String addressInformationListCompleteTransmissionIndicator) {
		this.addressInformationListCompleteTransmissionIndicator = addressInformationListCompleteTransmissionIndicator;
	}

	public String getAddressIndependentInfoCompleteTransmissionIndicator() {
		return addressIndependentInfoCompleteTransmissionIndicator;
	}

	public void setAddressIndependentInfoCompleteTransmissionIndicator(
			String addressIndependentInfoCompleteTransmissionIndicator) {
		this.addressIndependentInfoCompleteTransmissionIndicator = addressIndependentInfoCompleteTransmissionIndicator;
	}

	public String getBankDetailsListCompleteTransmissionIndicator() {
		return bankDetailsListCompleteTransmissionIndicator;
	}

	public void setBankDetailsListCompleteTransmissionIndicator(String bankDetailsListCompleteTransmissionIndicator) {
		this.bankDetailsListCompleteTransmissionIndicator = bankDetailsListCompleteTransmissionIndicator;
	}

	public String getPaymentCardDetailsCompleteTransmissionIndicator() {
		return paymentCardDetailsCompleteTransmissionIndicator;
	}

	public void setPaymentCardDetailsCompleteTransmissionIndicator(String paymentCardDetailsCompleteTransmissionIndicator) {
		this.paymentCardDetailsCompleteTransmissionIndicator = paymentCardDetailsCompleteTransmissionIndicator;
	}

	public String getCommonListCompleteTransmissionIndicator() {
		return commonListCompleteTransmissionIndicator;
	}

	public void setCommonListCompleteTransmissionIndicator(String commonListCompleteTransmissionIndicator) {
		this.commonListCompleteTransmissionIndicator = commonListCompleteTransmissionIndicator;
	}

	public String getRoleListCompleteTransmissionIndicator() {
		return roleListCompleteTransmissionIndicator;
	}

	public void setRoleListCompleteTransmissionIndicator(String roleListCompleteTransmissionIndicator) {
		this.roleListCompleteTransmissionIndicator = roleListCompleteTransmissionIndicator;
	}

	public String getIdentificationListCompleteTransmissionIndicator() {
		return identificationListCompleteTransmissionIndicator;
	}

	public void setIdentificationListCompleteTransmissionIndicator(String identificationListCompleteTransmissionIndicator) {
		this.identificationListCompleteTransmissionIndicator = identificationListCompleteTransmissionIndicator;
	}

	public String getIndustrySectorListCompleteTransmissionIndicator() {
		return industrySectorListCompleteTransmissionIndicator;
	}

	public void setIndustrySectorListCompleteTransmissionIndicator(String industrySectorListCompleteTransmissionIndicator) {
		this.industrySectorListCompleteTransmissionIndicator = industrySectorListCompleteTransmissionIndicator;
	}

	public String getTaxNumberListCompleteTransmissionIndicator() {
		return taxNumberListCompleteTransmissionIndicator;
	}

	public void setTaxNumberListCompleteTransmissionIndicator(String taxNumberListCompleteTransmissionIndicator) {
		this.taxNumberListCompleteTransmissionIndicator = taxNumberListCompleteTransmissionIndicator;
	}

	public String getFinancialServicesCompanyCodeInformationCompleteTransmissionIndicator() {
		return financialServicesCompanyCodeInformationCompleteTransmissionIndicator;
	}

	public void setFinancialServicesCompanyCodeInformationCompleteTransmissionIndicator(
			String financialServicesCompanyCodeInformationCompleteTransmissionIndicator) {
		this.financialServicesCompanyCodeInformationCompleteTransmissionIndicator = financialServicesCompanyCodeInformationCompleteTransmissionIndicator;
	}

	public String getCreditManagementCustomInformationListCompleteTransmissionIndicator() {
		return creditManagementCustomInformationListCompleteTransmissionIndicator;
	}

	public void setCreditManagementCustomInformationListCompleteTransmissionIndicator(
			String creditManagementCustomInformationListCompleteTransmissionIndicator) {
		this.creditManagementCustomInformationListCompleteTransmissionIndicator = creditManagementCustomInformationListCompleteTransmissionIndicator;
	}

	public String getCreditManagementExternalCreditInformationListCompleteTransmissionIndicator() {
		return creditManagementExternalCreditInformationListCompleteTransmissionIndicator;
	}

	public void setCreditManagementExternalCreditInformationListCompleteTransmissionIndicator(
			String creditManagementExternalCreditInformationListCompleteTransmissionIndicator) {
		this.creditManagementExternalCreditInformationListCompleteTransmissionIndicator = creditManagementExternalCreditInformationListCompleteTransmissionIndicator;
	}

	public String getDocumentListCompleteTransmissionIndicator() {
		return documentListCompleteTransmissionIndicator;
	}

	public void setDocumentListCompleteTransmissionIndicator(String documentListCompleteTransmissionIndicator) {
		this.documentListCompleteTransmissionIndicator = documentListCompleteTransmissionIndicator;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getInternalID() {
		return internalID;
	}

	public void setInternalID(String internalID) {
		this.internalID = internalID;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getNumberRangeIntervalBusinessPartnerGroupCode() {
		return numberRangeIntervalBusinessPartnerGroupCode;
	}

	public void setNumberRangeIntervalBusinessPartnerGroupCode(String numberRangeIntervalBusinessPartnerGroupCode) {
		this.numberRangeIntervalBusinessPartnerGroupCode = numberRangeIntervalBusinessPartnerGroupCode;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public AddressInformation getAddressInformation() {
		return addressInformation;
	}

	public void setAddressInformation(AddressInformation addressInformation) {
		this.addressInformation = addressInformation;
	}

	public AddressIndependentCommInfo getAddressIndependentCommInfo() {
		return addressIndependentCommInfo;
	}

	public void setAddressIndependentCommInfo(AddressIndependentCommInfo addressIndependentCommInfo) {
		this.addressIndependentCommInfo = addressIndependentCommInfo;
	}

	public BankDetails getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(BankDetails bankDetails) {
		this.bankDetails = bankDetails;
	}

	public Common getCommon() {
		return common;
	}

	public void setCommon(Common common) {
		this.common = common;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Identification getIdentification() {
		return identification;
	}

	public void setIdentification(Identification identification) {
		this.identification = identification;
	}

	public TaxNumber getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(TaxNumber taxNumber) {
		this.taxNumber = taxNumber;
	}

	public ZZBRANCHCODE getZzBranchCode() {
		return zzBranchCode;
	}

	public void setZzBranchCode(ZZBRANCHCODE zzBranchCode) {
		this.zzBranchCode = zzBranchCode;
	}

	public CreditManagementCreditWorthiness getCreditManagementCreditWorthiness() {
		return creditManagementCreditWorthiness;
	}

	public void setCreditManagementCreditWorthiness(CreditManagementCreditWorthiness creditManagementCreditWorthiness) {
		this.creditManagementCreditWorthiness = creditManagementCreditWorthiness;
	}
}
