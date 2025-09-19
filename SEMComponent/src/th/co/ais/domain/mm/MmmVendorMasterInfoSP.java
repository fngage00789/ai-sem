package th.co.ais.domain.mm;

import java.util.Date;


import th.co.ais.domain.AbstractDomain;

public class MmmVendorMasterInfoSP extends AbstractDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 467490341092970285L;

	private String rowId;

	private String vendorId;
	private String vendorCode;
	private String vendorName;
	private String vendorType;
	private String vendorStatus;
	private String vendorFlowStatus;
	private String vendorBlockStatus;
	
	private String vendorBookbankId;
	
	private String vendorName1;
	private String vendorName2;
	private String vendorName3;
	private String vendorName4;
	
	private String idCard;
	private String taxId;
	private String taxIdOld;
	
	private String bankCode;
	private String bankName;
	private String bankBranchCode;
	private String bankBranch;
	
	private String company;
	private String expenseType;
	private String hqFlag;
	private String branchNo;
	
	private String contractNo;
	private String saveFlag;
	
	private String typeFlag;
	private String groupType;
	

	private String branch;
	private String name1;
	private String name2;
	private String name3;
	private String name4;
	private String street;
	private String street2;
	private String street3;
	private String street4;
	private String district;
	private String city;
	private String postalCode;
	private String country;
	private String region;
	
	private String telNo;
	
	private String mobileNo;
	
	private String faxNo;
	
	private String email;
	
	private String headOffice;
	private String paymentBlock;
	
	private String whtType;
	private String whtCode;
	private String whtActionFlag;
	private String recipientType;
	private String whtType2;
	private String whtCode2;
	private String whtActionFlag2;
	private String recipientType2;
	private String result;
	private String remark;
	private String actionType;
	private String searchTeam;
	private String paymentTerm;
	private String paymentMethod;
	private String chkDoubleInv;
	private String role;
	private String roleType;
	private String address;
	private String amphur;
	private String postCode;
	private String accountGroup;
	private String reconAcct;
	private String sperr;
	private String loevm;
	private String confirmNoTax;
	
	private String userId;
	private String stkzn;
	
	private String consNumberTel;
	private String updateFlagTel;
	
	private String consNumberMobile;
	private String updateFlagMobile;
	
	private String consNumberFax;
	private String updateFlagFax;
	
	private String consNumberEmail;
	private String updateFlagEmail;
	
	private String notPayeeFlag;
	
	private String validateFlag;
	private String validateCaseId;
	
	private String vendorMapPayeeId;
	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorCode() {
		return vendorCode;
	}
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorType() {
		return vendorType;
	}
	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}
	public String getVendorStatus() {
		return vendorStatus;
	}
	public void setVendorStatus(String vendorStatus) {
		this.vendorStatus = vendorStatus;
	}
	public String getVendorFlowStatus() {
		return vendorFlowStatus;
	}
	public void setVendorFlowStatus(String vendorFlowStatus) {
		this.vendorFlowStatus = vendorFlowStatus;
	}
	public String getVendorBlockStatus() {
		return vendorBlockStatus;
	}
	public void setVendorBlockStatus(String vendorBlockStatus) {
		this.vendorBlockStatus = vendorBlockStatus;
	}
	public String getVendorBookbankId() {
		return vendorBookbankId;
	}
	public void setVendorBookbankId(String vendorBookbankId) {
		this.vendorBookbankId = vendorBookbankId;
	}
	public String getVendorName1() {
		return vendorName1;
	}
	public void setVendorName1(String vendorName1) {
		this.vendorName1 = vendorName1;
	}
	public String getVendorName2() {
		return vendorName2;
	}
	public void setVendorName2(String vendorName2) {
		this.vendorName2 = vendorName2;
	}
	public String getVendorName3() {
		return vendorName3;
	}
	public void setVendorName3(String vendorName3) {
		this.vendorName3 = vendorName3;
	}
	public String getVendorName4() {
		return vendorName4;
	}
	public void setVendorName4(String vendorName4) {
		this.vendorName4 = vendorName4;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getTaxId() {
		return taxId;
	}
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankBranchCode() {
		return bankBranchCode;
	}
	public void setBankBranchCode(String bankBranchCode) {
		this.bankBranchCode = bankBranchCode;
	}
	public String getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getHqFlag() {
		return hqFlag;
	}
	public void setHqFlag(String hqFlag) {
		this.hqFlag = hqFlag;
	}
	public String getBranchNo() {
		return branchNo;
	}
	public void setBranchNo(String branchNo) {
		this.branchNo = branchNo;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getSaveFlag() {
		return saveFlag;
	}
	public void setSaveFlag(String saveFlag) {
		this.saveFlag = saveFlag;
	}
	public String getTypeFlag() {
		return typeFlag;
	}
	public void setTypeFlag(String typeFlag) {
		this.typeFlag = typeFlag;
	}
	public String getGroupType() {
		return groupType;
	}
	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}
	
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getName3() {
		return name3;
	}
	public void setName3(String name3) {
		this.name3 = name3;
	}
	public String getName4() {
		return name4;
	}
	public void setName4(String name4) {
		this.name4 = name4;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public String getStreet3() {
		return street3;
	}
	public void setStreet3(String street3) {
		this.street3 = street3;
	}
	public String getStreet4() {
		return street4;
	}
	public void setStreet4(String street4) {
		this.street4 = street4;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getFaxNo() {
		return faxNo;
	}
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHeadOffice() {
		return headOffice;
	}
	public void setHeadOffice(String headOffice) {
		this.headOffice = headOffice;
	}
	public String getPaymentBlock() {
		return paymentBlock;
	}
	public void setPaymentBlock(String paymentBlock) {
		this.paymentBlock = paymentBlock;
	}
	
	public String getWhtType() {
		return whtType;
	}
	public void setWhtType(String whtType) {
		this.whtType = whtType;
	}
	public String getWhtCode() {
		return whtCode;
	}
	public void setWhtCode(String whtCode) {
		this.whtCode = whtCode;
	}
	public String getRecipientType() {
		return recipientType;
	}
	public void setRecipientType(String recipientType) {
		this.recipientType = recipientType;
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	
	public String getSearchTeam() {
		return searchTeam;
	}
	public void setSearchTeam(String searchTeam) {
		this.searchTeam = searchTeam;
	}
	public String getPaymentTerm() {
		return paymentTerm;
	}
	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getChkDoubleInv() {
		return chkDoubleInv;
	}
	public void setChkDoubleInv(String chkDoubleInv) {
		this.chkDoubleInv = chkDoubleInv;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAmphur() {
		return amphur;
	}
	public void setAmphur(String amphur) {
		this.amphur = amphur;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	public String getAccountGroup() {
		return accountGroup;
	}
	public void setAccountGroup(String accountGroup) {
		this.accountGroup = accountGroup;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getReconAcct() {
		return reconAcct;
	}
	public void setReconAcct(String reconAcct) {
		this.reconAcct = reconAcct;
	}
	
	public String getSperr() {
		return sperr;
	}
	public void setSperr(String sperr) {
		this.sperr = sperr;
	}
	public String getLoevm() {
		return loevm;
	}
	public void setLoevm(String loevm) {
		this.loevm = loevm;
	}
	
	public String getConfirmNoTax() {
		return confirmNoTax;
	}
	public void setConfirmNoTax(String confirmNoTax) {
		this.confirmNoTax = confirmNoTax;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStkzn() {
		return stkzn;
	}
	public void setStkzn(String stkzn) {
		this.stkzn = stkzn;
	}
	public String getConsNumberTel() {
		return consNumberTel;
	}
	public void setConsNumberTel(String consNumberTel) {
		this.consNumberTel = consNumberTel;
	}
	public String getUpdateFlagTel() {
		return updateFlagTel;
	}
	public void setUpdateFlagTel(String updateFlagTel) {
		this.updateFlagTel = updateFlagTel;
	}
	public String getConsNumberMobile() {
		return consNumberMobile;
	}
	public void setConsNumberMobile(String consNumberMobile) {
		this.consNumberMobile = consNumberMobile;
	}
	public String getUpdateFlagMobile() {
		return updateFlagMobile;
	}
	public void setUpdateFlagMobile(String updateFlagMobile) {
		this.updateFlagMobile = updateFlagMobile;
	}
	public String getConsNumberFax() {
		return consNumberFax;
	}
	public void setConsNumberFax(String consNumberFax) {
		this.consNumberFax = consNumberFax;
	}
	public String getUpdateFlagFax() {
		return updateFlagFax;
	}
	public void setUpdateFlagFax(String updateFlagFax) {
		this.updateFlagFax = updateFlagFax;
	}
	public String getConsNumberEmail() {
		return consNumberEmail;
	}
	public void setConsNumberEmail(String consNumberEmail) {
		this.consNumberEmail = consNumberEmail;
	}
	public String getUpdateFlagEmail() {
		return updateFlagEmail;
	}
	public void setUpdateFlagEmail(String updateFlagEmail) {
		this.updateFlagEmail = updateFlagEmail;
	}
	public String getNotPayeeFlag() {
		return notPayeeFlag;
	}
	public void setNotPayeeFlag(String notPayeeFlag) {
		this.notPayeeFlag = notPayeeFlag;
	}
	public String getValidateFlag() {
		return validateFlag;
	}
	public void setValidateFlag(String validateFlag) {
		this.validateFlag = validateFlag;
	}
	public String getValidateCaseId() {
		return validateCaseId;
	}
	public void setValidateCaseId(String validateCaseId) {
		this.validateCaseId = validateCaseId;
	}
	public String getTaxIdOld() {
		return taxIdOld;
	}
	public void setTaxIdOld(String taxIdOld) {
		this.taxIdOld = taxIdOld;
	}
	public String getVendorMapPayeeId() {
		return vendorMapPayeeId;
	}
	public void setVendorMapPayeeId(String vendorMapPayeeId) {
		this.vendorMapPayeeId = vendorMapPayeeId;
	}
	public String getWhtType2() {
		return whtType2;
	}
	public void setWhtType2(String whtType2) {
		this.whtType2 = whtType2;
	}
	public String getWhtCode2() {
		return whtCode2;
	}
	public void setWhtCode2(String whtCode2) {
		this.whtCode2 = whtCode2;
	}
	public String getRecipientType2() {
		return recipientType2;
	}
	public void setRecipientType2(String recipientType2) {
		this.recipientType2 = recipientType2;
	}
	public String getWhtActionFlag() {
		return whtActionFlag;
	}
	public void setWhtActionFlag(String whtActionFlag) {
		this.whtActionFlag = whtActionFlag;
	}
	public String getWhtActionFlag2() {
		return whtActionFlag2;
	}
	public void setWhtActionFlag2(String whtActionFlag2) {
		this.whtActionFlag2 = whtActionFlag2;
	}
	@Override
	public String getCreateBy() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Date getCreateDt() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUpdateBy() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Date getUpdateDt() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setCreateBy(String createBy) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setCreateDt(Date createDt) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setUpdateBy(String updateBy) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setUpdateDt(Date updateDt) {
		// TODO Auto-generated method stub
		
	}

}
