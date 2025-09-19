package com.ais.sem.ifrs16.resend.bean;

import java.util.Date;

import com.ais.sem.ifrs16.resend.domain.AbstractDomain;

public class Mrt010IfrsInterface extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -245038059249464637L;
	

	private String result;
	private String message;
	private String remark;
	private String userId;

	// collumn
	private String ifrsInterfaceId;
	private String semConditionId;
	private String splitCase;
	private String fileName;
	private String referenceId;
	private String activity;
	private String companyCode1;
	private String contractNo;
	private String companyCodeMain;
	private String MainContractNo;
	private String OldContractNo;
	private String contractType;
	private String objectDesc;
	private String contractName;
	private String dateContractConclusion;
	private String dateContractStart;
	private String dateFirstContractEnd;
	private String authorizationGroup;
	private String industry;
	private String personResponsible;
	private String casFlowStartingOn;
	private String firstPostingFrom1;
	private String currencyForContract;
	private String typeOfRenewal;
	private String renewalRulw;
	private String sequenceNo;
	private String noOfRenewals;
	private String contractRenewedYears;
	private String contractRenewedMonths;
	private String contractRenewedDays;
	private String typeOfAutomaticRenewal;
	private String renewalExecution;
	private String termNo1;
	private String paymentMethod;
	private String pmtMethsupl;
	private String individSet;
	private String paymentBlockKey;
	private String termsOfPaymentKey;
	private String keyForHouseBank;
	private String bankDetailsId;
	private String noteToPayee;
	private String dunningArea;
	private String dunningBlock;
	private String accountDetermination;
	private String taxType;
	private String taxGroup;
	private String businessPartnerNo1;
	private String termNo2;
	private String noFrequencyPeriod;
	private String frequencyUnit;
	private String frequencyStart;
	private String paymentForm;
	private String prorated;
	private String calculateMethod;
	private String factoryCalenda;
	private String businessPartnerNo2;
	private String businessPartnerRole;
	private String dateStartRelationship;
	private String dateEndRelationship;
	private String addressType;
	private String conditionSplit;
	private String conditionType;
	private String conditionPurpose1;
	private String dateFromCondition;
	private String dateUpToCondition;
	private String currencyCondition;
	private String noPostingTerm;
	private String noFrequencyTerm;
	private String noOrganizationalTerm;
	private String costCenter;
	private String profitCenter;
	private String currencyUnitPrice;
	private Double currencyUnitPriceFormatter;
	private String calculationFormula;
	private String distributionFormla;
	private String conditionsExternalPurpose;
	private String conditionOneTime;
	private String statisticalInfoCondition;
	private String firstPostingFrom2;
	private String NoOfWhtTerm;
	private String differentDueDateOneTime;
	private String gradingTermInMonths;
	private String gradingIntervalInMonths;
	private String gradingPercentIncrease;
	private String gradingAbsoluteIncrease;
	private String contractStatus;
	private String valuationRule;
	private String objectId;
	private String objectType;
	private String objectValidFrom;
	private String objectValidTo;
	private String startOfConsideration;
	private String firstPostingFrom3;
	private String classification;
	private String interestRate;
	private String frequencyTerm;
	private String distributFormula;
	private String distribFormulaParameter;
	private String probableEnd;
	private String endOfUsageRou;
	private String valuationStatus;
	private String valuationBehavior;
	private String companyCode2;
	private String asset;
	private String subno;
	private String objectDescription;
	private String acctasgobjtype;
	private String absoluteStart;
	private String absoluteEnd;
	private String condValProperty;
	private String condConsideration;
	private String considerCondition;
	private String percentage;
	private String absoluteShare;
	private String currency;
	private String conditionPurpose2;
	private String unitPrice;
	private String sapFilename;
	private String sapActivity;
	private String sapReferenceId;
	private String sapCompanyCode;
	private String sapContractNo;
	private String sapRefxNo;
	private String sapStatusCode;
	private String sapErrorCode;
	private String sapStatusMessage;
	private String recordStatus;
	private String resendSeq;
	private String region;
	private Date firstPostingFromFormatter;
	private Date dateFirstContractEndFormatter;
	private Date interfaceDateFrom;
	private Date interfaceDateTo;

	public Mrt010IfrsInterface() {
		super();
	}

	public Mrt010IfrsInterface(String referenceId) {
		super();
		this.referenceId = referenceId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getIfrsInterfaceId() {
		return ifrsInterfaceId;
	}

	public void setIfrsInterfaceId(String ifrsInterfaceId) {
		this.ifrsInterfaceId = ifrsInterfaceId;
	}

	public String getSemConditionId() {
		return semConditionId;
	}

	public void setSemConditionId(String semConditionId) {
		this.semConditionId = semConditionId;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getResendSeq() {
		return resendSeq;
	}

	public void setResendSeq(String resendSeq) {
		this.resendSeq = resendSeq;
	}

	public String getSplitCase() {
		return splitCase;
	}

	public void setSplitCase(String splitCase) {
		this.splitCase = splitCase;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getCompanyCode1() {
		return companyCode1;
	}

	public void setCompanyCode1(String companyCode1) {
		this.companyCode1 = companyCode1;
	}

	public String getCompanyCodeMain() {
		return companyCodeMain;
	}

	public void setCompanyCodeMain(String companyCodeMain) {
		this.companyCodeMain = companyCodeMain;
	}

	public String getMainContractNo() {
		return MainContractNo;
	}

	public void setMainContractNo(String mainContractNo) {
		MainContractNo = mainContractNo;
	}

	public String getOldContractNo() {
		return OldContractNo;
	}

	public void setOldContractNo(String oldContractNo) {
		OldContractNo = oldContractNo;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getObjectDesc() {
		return objectDesc;
	}

	public void setObjectDesc(String objectDesc) {
		this.objectDesc = objectDesc;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public String getDateContractConclusion() {
		return dateContractConclusion;
	}

	public void setDateContractConclusion(String dateContractConclusion) {
		this.dateContractConclusion = dateContractConclusion;
	}

	public String getDateContractStart() {
		return dateContractStart;
	}

	public void setDateContractStart(String dateContractStart) {
		this.dateContractStart = dateContractStart;
	}

	public String getDateFirstContractEnd() {
		return dateFirstContractEnd;
	}

	public void setDateFirstContractEnd(String dateFirstContractEnd) {
		this.dateFirstContractEnd = dateFirstContractEnd;
	}

	public String getAuthorizationGroup() {
		return authorizationGroup;
	}

	public void setAuthorizationGroup(String authorizationGroup) {
		this.authorizationGroup = authorizationGroup;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getPersonResponsible() {
		return personResponsible;
	}

	public void setPersonResponsible(String personResponsible) {
		this.personResponsible = personResponsible;
	}

	public String getCasFlowStartingOn() {
		return casFlowStartingOn;
	}

	public void setCasFlowStartingOn(String casFlowStartingOn) {
		this.casFlowStartingOn = casFlowStartingOn;
	}

	public String getFirstPostingFrom1() {
		return firstPostingFrom1;
	}

	public void setFirstPostingFrom1(String firstPostingFrom1) {
		this.firstPostingFrom1 = firstPostingFrom1;
	}

	public String getCurrencyForContract() {
		return currencyForContract;
	}

	public void setCurrencyForContract(String currencyForContract) {
		this.currencyForContract = currencyForContract;
	}

	public String getTypeOfRenewal() {
		return typeOfRenewal;
	}

	public void setTypeOfRenewal(String typeOfRenewal) {
		this.typeOfRenewal = typeOfRenewal;
	}

	public String getRenewalRulw() {
		return renewalRulw;
	}

	public void setRenewalRulw(String renewalRulw) {
		this.renewalRulw = renewalRulw;
	}

	public String getSequenceNo() {
		return sequenceNo;
	}

	public void setSequenceNo(String sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public String getNoOfRenewals() {
		return noOfRenewals;
	}

	public void setNoOfRenewals(String noOfRenewals) {
		this.noOfRenewals = noOfRenewals;
	}

	public String getContractRenewedYears() {
		return contractRenewedYears;
	}

	public void setContractRenewedYears(String contractRenewedYears) {
		this.contractRenewedYears = contractRenewedYears;
	}

	public String getContractRenewedMonths() {
		return contractRenewedMonths;
	}

	public void setContractRenewedMonths(String contractRenewedMonths) {
		this.contractRenewedMonths = contractRenewedMonths;
	}

	public String getContractRenewedDays() {
		return contractRenewedDays;
	}

	public void setContractRenewedDays(String contractRenewedDays) {
		this.contractRenewedDays = contractRenewedDays;
	}

	public String getTypeOfAutomaticRenewal() {
		return typeOfAutomaticRenewal;
	}

	public void setTypeOfAutomaticRenewal(String typeOfAutomaticRenewal) {
		this.typeOfAutomaticRenewal = typeOfAutomaticRenewal;
	}

	public String getRenewalExecution() {
		return renewalExecution;
	}

	public void setRenewalExecution(String renewalExecution) {
		this.renewalExecution = renewalExecution;
	}

	public String getTermNo1() {
		return termNo1;
	}

	public void setTermNo1(String termNo1) {
		this.termNo1 = termNo1;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPmtMethsupl() {
		return pmtMethsupl;
	}

	public void setPmtMethsupl(String pmtMethsupl) {
		this.pmtMethsupl = pmtMethsupl;
	}

	public String getIndividSet() {
		return individSet;
	}

	public void setIndividSet(String individSet) {
		this.individSet = individSet;
	}

	public String getPaymentBlockKey() {
		return paymentBlockKey;
	}

	public void setPaymentBlockKey(String paymentBlockKey) {
		this.paymentBlockKey = paymentBlockKey;
	}

	public String getTermsOfPaymentKey() {
		return termsOfPaymentKey;
	}

	public void setTermsOfPaymentKey(String termsOfPaymentKey) {
		this.termsOfPaymentKey = termsOfPaymentKey;
	}

	public String getKeyForHouseBank() {
		return keyForHouseBank;
	}

	public void setKeyForHouseBank(String keyForHouseBank) {
		this.keyForHouseBank = keyForHouseBank;
	}

	public String getBankDetailsId() {
		return bankDetailsId;
	}

	public void setBankDetailsId(String bankDetailsId) {
		this.bankDetailsId = bankDetailsId;
	}

	public String getNoteToPayee() {
		return noteToPayee;
	}

	public void setNoteToPayee(String noteToPayee) {
		this.noteToPayee = noteToPayee;
	}

	public String getDunningArea() {
		return dunningArea;
	}

	public void setDunningArea(String dunningArea) {
		this.dunningArea = dunningArea;
	}

	public String getDunningBlock() {
		return dunningBlock;
	}

	public void setDunningBlock(String dunningBlock) {
		this.dunningBlock = dunningBlock;
	}

	public String getAccountDetermination() {
		return accountDetermination;
	}

	public void setAccountDetermination(String accountDetermination) {
		this.accountDetermination = accountDetermination;
	}

	public String getTaxType() {
		return taxType;
	}

	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}

	public String getTaxGroup() {
		return taxGroup;
	}

	public void setTaxGroup(String taxGroup) {
		this.taxGroup = taxGroup;
	}

	public String getBusinessPartnerNo1() {
		return businessPartnerNo1;
	}

	public void setBusinessPartnerNo1(String businessPartnerNo1) {
		this.businessPartnerNo1 = businessPartnerNo1;
	}

	public String getTermNo2() {
		return termNo2;
	}

	public void setTermNo2(String termNo2) {
		this.termNo2 = termNo2;
	}

	public String getNoFrequencyPeriod() {
		return noFrequencyPeriod;
	}

	public void setNoFrequencyPeriod(String noFrequencyPeriod) {
		this.noFrequencyPeriod = noFrequencyPeriod;
	}

	public String getFrequencyUnit() {
		return frequencyUnit;
	}

	public void setFrequencyUnit(String frequencyUnit) {
		this.frequencyUnit = frequencyUnit;
	}

	public String getFrequencyStart() {
		return frequencyStart;
	}

	public void setFrequencyStart(String frequencyStart) {
		this.frequencyStart = frequencyStart;
	}

	public String getPaymentForm() {
		return paymentForm;
	}

	public void setPaymentForm(String paymentForm) {
		this.paymentForm = paymentForm;
	}

	public String getProrated() {
		return prorated;
	}

	public void setProrated(String prorated) {
		this.prorated = prorated;
	}

	public String getCalculateMethod() {
		return calculateMethod;
	}

	public void setCalculateMethod(String calculateMethod) {
		this.calculateMethod = calculateMethod;
	}

	public String getFactoryCalenda() {
		return factoryCalenda;
	}

	public void setFactoryCalenda(String factoryCalenda) {
		this.factoryCalenda = factoryCalenda;
	}

	public String getBusinessPartnerNo2() {
		return businessPartnerNo2;
	}

	public void setBusinessPartnerNo2(String businessPartnerNo2) {
		this.businessPartnerNo2 = businessPartnerNo2;
	}

	public String getBusinessPartnerRole() {
		return businessPartnerRole;
	}

	public void setBusinessPartnerRole(String businessPartnerRole) {
		this.businessPartnerRole = businessPartnerRole;
	}

	public String getDateStartRelationship() {
		return dateStartRelationship;
	}

	public void setDateStartRelationship(String dateStartRelationship) {
		this.dateStartRelationship = dateStartRelationship;
	}

	public String getDateEndRelationship() {
		return dateEndRelationship;
	}

	public void setDateEndRelationship(String dateEndRelationship) {
		this.dateEndRelationship = dateEndRelationship;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getConditionSplit() {
		return conditionSplit;
	}

	public void setConditionSplit(String conditionSplit) {
		this.conditionSplit = conditionSplit;
	}

	public String getConditionType() {
		return conditionType;
	}

	public void setConditionType(String conditionType) {
		this.conditionType = conditionType;
	}

	public String getConditionPurpose1() {
		return conditionPurpose1;
	}

	public void setConditionPurpose1(String conditionPurpose1) {
		this.conditionPurpose1 = conditionPurpose1;
	}

	public String getDateFromCondition() {
		return dateFromCondition;
	}

	public void setDateFromCondition(String dateFromCondition) {
		this.dateFromCondition = dateFromCondition;
	}

	public String getDateUpToCondition() {
		return dateUpToCondition;
	}

	public void setDateUpToCondition(String dateUpToCondition) {
		this.dateUpToCondition = dateUpToCondition;
	}

	public String getCurrencyCondition() {
		return currencyCondition;
	}

	public void setCurrencyCondition(String currencyCondition) {
		this.currencyCondition = currencyCondition;
	}

	public String getNoPostingTerm() {
		return noPostingTerm;
	}

	public void setNoPostingTerm(String noPostingTerm) {
		this.noPostingTerm = noPostingTerm;
	}

	public String getNoFrequencyTerm() {
		return noFrequencyTerm;
	}

	public void setNoFrequencyTerm(String noFrequencyTerm) {
		this.noFrequencyTerm = noFrequencyTerm;
	}

	public String getNoOrganizationalTerm() {
		return noOrganizationalTerm;
	}

	public void setNoOrganizationalTerm(String noOrganizationalTerm) {
		this.noOrganizationalTerm = noOrganizationalTerm;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getProfitCenter() {
		return profitCenter;
	}

	public void setProfitCenter(String profitCenter) {
		this.profitCenter = profitCenter;
	}

	public String getCurrencyUnitPrice() {
		return currencyUnitPrice;
	}

	public void setCurrencyUnitPrice(String currencyUnitPrice) {
		this.currencyUnitPrice = currencyUnitPrice;
	}

	public Double getCurrencyUnitPriceFormatter() {
		return currencyUnitPriceFormatter;
	}

	public void setCurrencyUnitPriceFormatter(Double currencyUnitPriceFormatter) {
		this.currencyUnitPriceFormatter = currencyUnitPriceFormatter;
	}

	public String getCalculationFormula() {
		return calculationFormula;
	}

	public void setCalculationFormula(String calculationFormula) {
		this.calculationFormula = calculationFormula;
	}

	public String getDistributionFormla() {
		return distributionFormla;
	}

	public void setDistributionFormla(String distributionFormla) {
		this.distributionFormla = distributionFormla;
	}

	public String getConditionsExternalPurpose() {
		return conditionsExternalPurpose;
	}

	public void setConditionsExternalPurpose(String conditionsExternalPurpose) {
		this.conditionsExternalPurpose = conditionsExternalPurpose;
	}

	public String getConditionOneTime() {
		return conditionOneTime;
	}

	public void setConditionOneTime(String conditionOneTime) {
		this.conditionOneTime = conditionOneTime;
	}

	public String getStatisticalInfoCondition() {
		return statisticalInfoCondition;
	}

	public void setStatisticalInfoCondition(String statisticalInfoCondition) {
		this.statisticalInfoCondition = statisticalInfoCondition;
	}

	public String getFirstPostingFrom2() {
		return firstPostingFrom2;
	}

	public void setFirstPostingFrom2(String firstPostingFrom2) {
		this.firstPostingFrom2 = firstPostingFrom2;
	}

	public String getNoOfWhtTerm() {
		return NoOfWhtTerm;
	}

	public void setNoOfWhtTerm(String noOfWhtTerm) {
		NoOfWhtTerm = noOfWhtTerm;
	}

	public String getDifferentDueDateOneTime() {
		return differentDueDateOneTime;
	}

	public void setDifferentDueDateOneTime(String differentDueDateOneTime) {
		this.differentDueDateOneTime = differentDueDateOneTime;
	}

	public String getGradingTermInMonths() {
		return gradingTermInMonths;
	}

	public void setGradingTermInMonths(String gradingTermInMonths) {
		this.gradingTermInMonths = gradingTermInMonths;
	}

	public String getGradingIntervalInMonths() {
		return gradingIntervalInMonths;
	}

	public void setGradingIntervalInMonths(String gradingIntervalInMonths) {
		this.gradingIntervalInMonths = gradingIntervalInMonths;
	}

	public String getGradingPercentIncrease() {
		return gradingPercentIncrease;
	}

	public void setGradingPercentIncrease(String gradingPercentIncrease) {
		this.gradingPercentIncrease = gradingPercentIncrease;
	}

	public String getGradingAbsoluteIncrease() {
		return gradingAbsoluteIncrease;
	}

	public void setGradingAbsoluteIncrease(String gradingAbsoluteIncrease) {
		this.gradingAbsoluteIncrease = gradingAbsoluteIncrease;
	}

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	public String getValuationRule() {
		return valuationRule;
	}

	public void setValuationRule(String valuationRule) {
		this.valuationRule = valuationRule;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public String getObjectValidFrom() {
		return objectValidFrom;
	}

	public void setObjectValidFrom(String objectValidFrom) {
		this.objectValidFrom = objectValidFrom;
	}

	public String getObjectValidTo() {
		return objectValidTo;
	}

	public void setObjectValidTo(String objectValidTo) {
		this.objectValidTo = objectValidTo;
	}

	public String getStartOfConsideration() {
		return startOfConsideration;
	}

	public void setStartOfConsideration(String startOfConsideration) {
		this.startOfConsideration = startOfConsideration;
	}

	public String getFirstPostingFrom3() {
		return firstPostingFrom3;
	}

	public void setFirstPostingFrom3(String firstPostingFrom3) {
		this.firstPostingFrom3 = firstPostingFrom3;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}

	public String getFrequencyTerm() {
		return frequencyTerm;
	}

	public void setFrequencyTerm(String frequencyTerm) {
		this.frequencyTerm = frequencyTerm;
	}

	public String getDistributFormula() {
		return distributFormula;
	}

	public void setDistributFormula(String distributFormula) {
		this.distributFormula = distributFormula;
	}

	public String getDistribFormulaParameter() {
		return distribFormulaParameter;
	}

	public void setDistribFormulaParameter(String distribFormulaParameter) {
		this.distribFormulaParameter = distribFormulaParameter;
	}

	public String getProbableEnd() {
		return probableEnd;
	}

	public void setProbableEnd(String probableEnd) {
		this.probableEnd = probableEnd;
	}

	public String getEndOfUsageRou() {
		return endOfUsageRou;
	}

	public void setEndOfUsageRou(String endOfUsageRou) {
		this.endOfUsageRou = endOfUsageRou;
	}

	public String getValuationStatus() {
		return valuationStatus;
	}

	public void setValuationStatus(String valuationStatus) {
		this.valuationStatus = valuationStatus;
	}

	public String getValuationBehavior() {
		return valuationBehavior;
	}

	public void setValuationBehavior(String valuationBehavior) {
		this.valuationBehavior = valuationBehavior;
	}

	public String getCompanyCode2() {
		return companyCode2;
	}

	public void setCompanyCode2(String companyCode2) {
		this.companyCode2 = companyCode2;
	}

	public String getAsset() {
		return asset;
	}

	public void setAsset(String asset) {
		this.asset = asset;
	}

	public String getSubno() {
		return subno;
	}

	public void setSubno(String subno) {
		this.subno = subno;
	}

	public String getObjectDescription() {
		return objectDescription;
	}

	public void setObjectDescription(String objectDescription) {
		this.objectDescription = objectDescription;
	}

	public String getAcctasgobjtype() {
		return acctasgobjtype;
	}

	public void setAcctasgobjtype(String acctasgobjtype) {
		this.acctasgobjtype = acctasgobjtype;
	}

	public String getAbsoluteStart() {
		return absoluteStart;
	}

	public void setAbsoluteStart(String absoluteStart) {
		this.absoluteStart = absoluteStart;
	}

	public String getAbsoluteEnd() {
		return absoluteEnd;
	}

	public void setAbsoluteEnd(String absoluteEnd) {
		this.absoluteEnd = absoluteEnd;
	}

	public String getCondValProperty() {
		return condValProperty;
	}

	public void setCondValProperty(String condValProperty) {
		this.condValProperty = condValProperty;
	}

	public String getCondConsideration() {
		return condConsideration;
	}

	public void setCondConsideration(String condConsideration) {
		this.condConsideration = condConsideration;
	}

	public String getConsiderCondition() {
		return considerCondition;
	}

	public void setConsiderCondition(String considerCondition) {
		this.considerCondition = considerCondition;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getAbsoluteShare() {
		return absoluteShare;
	}

	public void setAbsoluteShare(String absoluteShare) {
		this.absoluteShare = absoluteShare;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getConditionPurpose2() {
		return conditionPurpose2;
	}

	public void setConditionPurpose2(String conditionPurpose2) {
		this.conditionPurpose2 = conditionPurpose2;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getSapFilename() {
		return sapFilename;
	}

	public void setSapFilename(String sapFilename) {
		this.sapFilename = sapFilename;
	}

	public String getSapActivity() {
		return sapActivity;
	}

	public void setSapActivity(String sapActivity) {
		this.sapActivity = sapActivity;
	}

	public String getSapReferenceId() {
		return sapReferenceId;
	}

	public void setSapReferenceId(String sapReferenceId) {
		this.sapReferenceId = sapReferenceId;
	}

	public String getSapCompanyCode() {
		return sapCompanyCode;
	}

	public void setSapCompanyCode(String sapCompanyCode) {
		this.sapCompanyCode = sapCompanyCode;
	}

	public String getSapContractNo() {
		return sapContractNo;
	}

	public void setSapContractNo(String sapContractNo) {
		this.sapContractNo = sapContractNo;
	}

	public String getSapRefxNo() {
		return sapRefxNo;
	}

	public void setSapRefxNo(String sapRefxNo) {
		this.sapRefxNo = sapRefxNo;
	}

	public String getSapStatusCode() {
		return sapStatusCode;
	}

	public void setSapStatusCode(String sapStatusCode) {
		this.sapStatusCode = sapStatusCode;
	}

	public String getSapErrorCode() {
		return sapErrorCode;
	}

	public void setSapErrorCode(String sapErrorCode) {
		this.sapErrorCode = sapErrorCode;
	}

	public String getSapStatusMessage() {
		return sapStatusMessage;
	}

	public void setSapStatusMessage(String sapStatusMessage) {
		this.sapStatusMessage = sapStatusMessage;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Date getFirstPostingFromFormatter() {
		return firstPostingFromFormatter;
	}

	public void setFirstPostingFromFormatter(Date firstPostingFromFormatter) {
		this.firstPostingFromFormatter = firstPostingFromFormatter;
	}

	public Date getDateFirstContractEndFormatter() {
		return dateFirstContractEndFormatter;
	}

	public void setDateFirstContractEndFormatter(Date dateFirstContractEndFormatter) {
		this.dateFirstContractEndFormatter = dateFirstContractEndFormatter;
	}

	public Date getInterfaceDateFrom() {
		return interfaceDateFrom;
	}

	public void setInterfaceDateFrom(Date interfaceDateFrom) {
		this.interfaceDateFrom = interfaceDateFrom;
	}

	public Date getInterfaceDateTo() {
		return interfaceDateTo;
	}

	public void setInterfaceDateTo(Date interfaceDateTo) {
		this.interfaceDateTo = interfaceDateTo;
	}

	@Override
	public String getCreateBy() {
		return this.createBy;
	}

	@Override
	public Date getCreateDt() {
		return this.createDt;
	}

	@Override
	public String getUpdateBy() {
		return this.updateBy;
	}

	@Override
	public Date getUpdateDt() {
		return this.updateDt;
	}

	@Override
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Override
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	@Override
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Override
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	@Override
	public String toString() {
		return "Mrt010IfrsInterface [MainContractNo=" + MainContractNo + ", NoOfWhtTerm=" + NoOfWhtTerm
				+ ", OldContractNo=" + OldContractNo + ", absoluteEnd=" + absoluteEnd + ", absoluteShare="
				+ absoluteShare + ", absoluteStart=" + absoluteStart + ", accountDetermination=" + accountDetermination
				+ ", acctasgobjtype=" + acctasgobjtype + ", activity=" + activity + ", addressType=" + addressType
				+ ", asset=" + asset + ", authorizationGroup=" + authorizationGroup + ", bankDetailsId="
				+ bankDetailsId + ", businessPartnerNo1=" + businessPartnerNo1 + ", businessPartnerNo2="
				+ businessPartnerNo2 + ", businessPartnerRole=" + businessPartnerRole + ", calculateMethod="
				+ calculateMethod + ", calculationFormula=" + calculationFormula + ", casFlowStartingOn="
				+ casFlowStartingOn + ", classification=" + classification + ", companyCode1=" + companyCode1
				+ ", companyCode2=" + companyCode2 + ", companyCodeMain=" + companyCodeMain + ", condConsideration="
				+ condConsideration + ", condValProperty=" + condValProperty + ", conditionOneTime=" + conditionOneTime
				+ ", conditionPurpose1=" + conditionPurpose1 + ", conditionPurpose2=" + conditionPurpose2
				+ ", conditionSplit=" + conditionSplit + ", conditionType=" + conditionType
				+ ", conditionsExternalPurpose=" + conditionsExternalPurpose + ", considerCondition="
				+ considerCondition + ", contractName=" + contractName + ", contractNo=" + contractNo
				+ ", contractRenewedDays=" + contractRenewedDays + ", contractRenewedMonths=" + contractRenewedMonths
				+ ", contractRenewedYears=" + contractRenewedYears + ", contractStatus=" + contractStatus
				+ ", contractType=" + contractType + ", costCenter=" + costCenter + ", currency=" + currency
				+ ", currencyCondition=" + currencyCondition + ", currencyForContract=" + currencyForContract
				+ ", currencyUnitPrice=" + currencyUnitPrice + ", currencyUnitPriceFormatter="
				+ currencyUnitPriceFormatter + ", dateContractConclusion=" + dateContractConclusion
				+ ", dateContractStart=" + dateContractStart + ", dateEndRelationship=" + dateEndRelationship
				+ ", dateFirstContractEnd=" + dateFirstContractEnd + ", dateFirstContractEndFormatter="
				+ dateFirstContractEndFormatter + ", dateFromCondition=" + dateFromCondition
				+ ", dateStartRelationship=" + dateStartRelationship + ", dateUpToCondition=" + dateUpToCondition
				+ ", differentDueDateOneTime=" + differentDueDateOneTime + ", distribFormulaParameter="
				+ distribFormulaParameter + ", distributFormula=" + distributFormula + ", distributionFormla="
				+ distributionFormla + ", dunningArea=" + dunningArea + ", dunningBlock=" + dunningBlock
				+ ", endOfUsageRou=" + endOfUsageRou + ", factoryCalenda=" + factoryCalenda + ", fileName=" + fileName
				+ ", firstPostingFrom1=" + firstPostingFrom1 + ", firstPostingFrom2=" + firstPostingFrom2
				+ ", firstPostingFrom3=" + firstPostingFrom3 + ", firstPostingFromFormatter="
				+ firstPostingFromFormatter + ", frequencyStart=" + frequencyStart + ", frequencyTerm=" + frequencyTerm
				+ ", frequencyUnit=" + frequencyUnit + ", gradingAbsoluteIncrease=" + gradingAbsoluteIncrease
				+ ", gradingIntervalInMonths=" + gradingIntervalInMonths + ", gradingPercentIncrease="
				+ gradingPercentIncrease + ", gradingTermInMonths=" + gradingTermInMonths + ", individSet="
				+ individSet + ", industry=" + industry + ", interestRate=" + interestRate + ", interfaceDateFrom="
				+ interfaceDateFrom + ", interfaceDateTo=" + interfaceDateTo + ", keyForHouseBank=" + keyForHouseBank
				+ ", message=" + message + ", noFrequencyPeriod=" + noFrequencyPeriod + ", noFrequencyTerm="
				+ noFrequencyTerm + ", noOfRenewals=" + noOfRenewals + ", noOrganizationalTerm=" + noOrganizationalTerm
				+ ", noPostingTerm=" + noPostingTerm + ", noteToPayee=" + noteToPayee + ", objectDesc=" + objectDesc
				+ ", objectDescription=" + objectDescription + ", objectId=" + objectId + ", objectType=" + objectType
				+ ", objectValidFrom=" + objectValidFrom + ", objectValidTo=" + objectValidTo + ", paymentBlockKey="
				+ paymentBlockKey + ", paymentForm=" + paymentForm + ", paymentMethod=" + paymentMethod
				+ ", percentage=" + percentage + ", personResponsible=" + personResponsible + ", pmtMethsupl="
				+ pmtMethsupl + ", probableEnd=" + probableEnd + ", profitCenter=" + profitCenter + ", prorated="
				+ prorated + ", recordStatus=" + recordStatus + ", referenceId=" + referenceId + ", remark=" + remark
				+ ", renewalExecution=" + renewalExecution + ", renewalRulw=" + renewalRulw + ", resendSeq="
				+ resendSeq + ", result=" + result + ", sapActivity=" + sapActivity + ", sapCompanyCode="
				+ sapCompanyCode + ", sapContractNo=" + sapContractNo + ", sapErrorCode=" + sapErrorCode
				+ ", sapFilename=" + sapFilename + ", sapReferenceId=" + sapReferenceId + ", sapRefxNo=" + sapRefxNo
				+ ", sapStatusCode=" + sapStatusCode + ", sapStatusMessage=" + sapStatusMessage + ", sequenceNo="
				+ sequenceNo + ", splitCase=" + splitCase + ", startOfConsideration=" + startOfConsideration
				+ ", statisticalInfoCondition=" + statisticalInfoCondition + ", subno=" + subno + ", taxGroup="
				+ taxGroup + ", taxType=" + taxType + ", termNo1=" + termNo1 + ", termNo2=" + termNo2
				+ ", termsOfPaymentKey=" + termsOfPaymentKey + ", typeOfAutomaticRenewal=" + typeOfAutomaticRenewal
				+ ", typeOfRenewal=" + typeOfRenewal + ", unitPrice=" + unitPrice + ", userId=" + userId
				+ ", valuationBehavior=" + valuationBehavior + ", valuationRule=" + valuationRule
				+ ", valuationStatus=" + valuationStatus + "]";
	}

}
