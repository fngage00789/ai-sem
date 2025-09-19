package th.co.ais.domain.mm;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.DateUtil;

public class Mmm001VendorSP extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4110458829638362897L;
	
	private String rowId;

	private String vendorId;
	private String vendorCode;
	private String vendorName; // must be add data same 'vendorName1'
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
	
	private String titleName;
	private String whtType;
	private String whtCode;
	private String whtId;
	private String recipientType;
	
	private String address;
	private String tambol;
	private String tambolName;
	private String amphur;
	private String amphurName;
	private String province;
	private String provinceName;
	private String postCode;
	private String region;
	private String regionName;
	
	private String address1;
	private String address2;
	private String address3;
	private String address4;
	
	private String email;
	private String fax;
	private String telephone;
	private String mobileNo;
	private String sapReturnCode;
	
	private String includeVAT;
	private boolean chkVAT = false;
	
	private String withoutContractRemark;
	
	private String payType;
	private Date effectiveDt;
	private String effectiveDtStr;
	
	
	private String vendorIdChngeFrm; //for support ..SAVE_DRAFT (CHANGE) from old vendor
	
	private String vendorBlackListStatus;
	private String vendorRemark;
	
	private String vendorBatch;
	private String remarkWithoutContract;
	
	//added by NEW 2017/10/02
	private String notPayeeFlag;
	private String otherExpenseFlag;
	private String role;
	
	private String vendorBranchNo;
	
	private String vendorMapPayeeId;
	
	private String validateFlag;
	private String validateCaseId;
	
	private Date contractEffectiveDt;
	private String contractEffectiveDtStr;
	private Date contractExpireDt;
	private String contractExpireDtStr;
	
	private String oldContractNo;
	private String vendorIdCard;
	private String vendorTaxId;
	private String vat;
	private String vendorBlock;
	private String notPayee;
	private String vendorBlackList;
	private String vendorAddress;
	private String vendorAccountNo;
	private String vendorAccountName;
	private String vendorAccountType;
	private String vendorBankName;
	private String payeeCode;
	private String payeeType;
	private String payeeName;
	private String payeeIdCard;
	private String payeeTaxId;
	private String payeeAddress;
	private String payeeAccountNo;
	private String payeeAccountName;
	private String payeeAccountType;
	private String payeeBankName;
	private String activeStatus;
	
	private String vendorTypeTxt;
	private String hqFlagTxt;
	private String vendorFlowStatusTxt;
	private String siteInfoId;
	
	private String payeeId;
	private String bookbankPayeeId;
	
	private String confirmFlag;
	
	private String vendorCompanySap;
	
	private String payeeBookbankId;
	
	private String vendorInfoTxt1;
	private String vendorInfoTxt2;
	private String vendorInfoTxt3;
	private String vendorInfoTxt4;
	
	private String confirmTxt;
	
	public Mmm001VendorSP(){
		
	}
	
	public Mmm001VendorSP(Mmm001VendorSP vendorSp) {
		// TODO Auto-generated constructor stub
//		
		expenseType = vendorSp.getExpenseType();
		vendorType = vendorSp.getVendorType();
		vendorBlockStatus = vendorSp.getVendorBlockStatus();
		vendorCode = vendorSp.getVendorCode();
		vendorName1 = vendorSp.getVendorName1();
		vendorName2 = vendorSp.getVendorName2();
		vendorName3 = vendorSp.getVendorName3();
		vendorName4 = vendorSp.getVendorName4();
		idCard = vendorSp.getIdCard();
		taxId = vendorSp.getTaxId();
		hqFlag = vendorSp.getHqFlag();
		branchNo = vendorSp.getBranchNo();
		vendorStatus = vendorSp.getVendorStatus();
	}
	@Override
	public String getCreateBy() {
		return createBy;
	}
	@Override
	public Date getCreateDt() {
		return createDt;
	}
	@Override
	public String getUpdateBy() {
		return updateBy;
	}
	@Override
	public Date getUpdateDt() {
		return updateDt;
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
		return StringUtils.trim(vendorName);
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
	
	public String getVendorBookbankId() {
		return vendorBookbankId;
	}
	public void setVendorBookbankId(String vendorBookbankId) {
		this.vendorBookbankId = vendorBookbankId;
	}
	public String getVendorName1() {
		return StringUtils.trim(vendorName1);
	}
	public void setVendorName1(String vendorName1) {
		this.vendorName1 = vendorName1;
	}
	public String getVendorName2() {
		return StringUtils.trim(vendorName2);
	}
	public void setVendorName2(String vendorName2) {
		this.vendorName2 = vendorName2;
	}
	public String getVendorName3() {
		return StringUtils.trim(vendorName3);
	}
	public void setVendorName3(String vendorName3) {
		this.vendorName3 = vendorName3;
	}
	public String getVendorName4() {
		return StringUtils.trim(vendorName4);
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
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
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
	public String getWhtId() {
		return whtId;
	}

	public void setWhtId(String whtId) {
		this.whtId = whtId;
	}

	public String getRecipientType() {
		return recipientType;
	}
	public void setRecipientType(String recipientType) {
		this.recipientType = recipientType;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getAddress4() {
		return address4;
	}
	public void setAddress4(String address4) {
		this.address4 = address4;
	}

	public String getTambol() {
		return tambol;
	}
	public void setTambol(String tambol) {
		this.tambol = tambol;
	}
	public String getAmphur() {
		return amphur;
	}
	public void setAmphur(String amphur) {
		this.amphur = amphur;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getTambolName() {
		return tambolName;
	}
	public void setTambolName(String tambolName) {
		this.tambolName = tambolName;
	}
	public String getAmphurName() {
		return amphurName;
	}
	public void setAmphurName(String amphurName) {
		this.amphurName = amphurName;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getRegionName() {
		return regionName;
	}
	public String getWithoutContractRemark() {
		return withoutContractRemark;
	}
	public void setWithoutContractRemark(String withoutContractRemark) {
		this.withoutContractRemark = withoutContractRemark;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getIncludeVAT() {
		return includeVAT;
	}
	public void setIncludeVAT(String includeVAT) {
		this.includeVAT = includeVAT;
	}
	public boolean isChkVAT() {
		return chkVAT;
	}
	public void setChkVAT(boolean chkVAT) {
		this.chkVAT = chkVAT;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getSapReturnCode() {
		return sapReturnCode;
	}
	public void setSapReturnCode(String sapReturnCode) {
		this.sapReturnCode = sapReturnCode;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public Date getEffectiveDt() throws Exception {
		if(effectiveDtStr != null){
			effectiveDt = DateUtil.getDate(effectiveDtStr, DateUtil.SIMPLE_DATE_PATTERN);
		}
		return effectiveDt;
	}
	public void setEffectiveDt(Date effectiveDt) {
		this.effectiveDt = effectiveDt;
	}
	public String getEffectiveDtStr() {
		return effectiveDtStr;
	}
	public void setEffectiveDtStr(String effectiveDtStr) {
		this.effectiveDtStr = effectiveDtStr;
	}
	
	public String getVendorIdChngeFrm() {
		return vendorIdChngeFrm;
	}
	public void setVendorIdChngeFrm(String vendorIdChngeFrm) {
		this.vendorIdChngeFrm = vendorIdChngeFrm;
	}
	public String getVendorRemark() {
		return vendorRemark;
	}
	public void setVendorRemark(String vendorRemark) {
		this.vendorRemark = vendorRemark;
	}
	
	public String getVendorBatch() {
		return vendorBatch;
	}

	public void setVendorBatch(String vendorBatch) {
		this.vendorBatch = vendorBatch;
	}

	public String getRemarkWithoutContract() {
		return remarkWithoutContract;
	}

	public void setRemarkWithoutContract(String remarkWithoutContract) {
		this.remarkWithoutContract = remarkWithoutContract;
	}

	public String getVendorBlockStatus() {
		return vendorBlockStatus;
	}

	public void setVendorBlockStatus(String vendorBlockStatus) {
		this.vendorBlockStatus = vendorBlockStatus;
	}

	public String getVendorBlackListStatus() {
		return vendorBlackListStatus;
	}

	public void setVendorBlackListStatus(String vendorBlackListStatus) {
		this.vendorBlackListStatus = vendorBlackListStatus;
	}

	public String getNotPayeeFlag() {
		return notPayeeFlag;
	}

	public void setNotPayeeFlag(String notPayeeFlag) {
		this.notPayeeFlag = notPayeeFlag;
	}

	public String getOtherExpenseFlag() {
		return otherExpenseFlag;
	}

	public void setOtherExpenseFlag(String otherExpenseFlag) {
		this.otherExpenseFlag = otherExpenseFlag;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getVendorBranchNo() {
		return vendorBranchNo;
	}

	public void setVendorBranchNo(String vendorBranchNo) {
		this.vendorBranchNo = vendorBranchNo;
	}

	public String getVendorMapPayeeId() {
		return vendorMapPayeeId;
	}

	public void setVendorMapPayeeId(String vendorMapPayeeId) {
		this.vendorMapPayeeId = vendorMapPayeeId;
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

	public Date getContractEffectiveDt() {
		return contractEffectiveDt;
	}

	public void setContractEffectiveDt(Date contractEffectiveDt) {
		this.contractEffectiveDt = contractEffectiveDt;
	}

	public String getContractEffectiveDtStr() {
		return contractEffectiveDtStr;
	}

	public void setContractEffectiveDtStr(String contractEffectiveDtStr) {
		this.contractEffectiveDtStr = contractEffectiveDtStr;
	}

	public Date getContractExpireDt() {
		return contractExpireDt;
	}

	public void setContractExpireDt(Date contractExpireDt) {
		this.contractExpireDt = contractExpireDt;
	}

	public String getContractExpireDtStr() {
		return contractExpireDtStr;
	}

	public void setContractExpireDtStr(String contractExpireDtStr) {
		this.contractExpireDtStr = contractExpireDtStr;
	}

	public String getOldContractNo() {
		return oldContractNo;
	}

	public void setOldContractNo(String oldContractNo) {
		this.oldContractNo = oldContractNo;
	}

	public String getVendorIdCard() {
		return vendorIdCard;
	}

	public void setVendorIdCard(String vendorIdCard) {
		this.vendorIdCard = vendorIdCard;
	}

	public String getVendorTaxId() {
		return vendorTaxId;
	}

	public void setVendorTaxId(String vendorTaxId) {
		this.vendorTaxId = vendorTaxId;
	}

	public String getVat() {
		return vat;
	}

	public void setVat(String vat) {
		this.vat = vat;
	}

	public String getVendorBlock() {
		return vendorBlock;
	}

	public void setVendorBlock(String vendorBlock) {
		this.vendorBlock = vendorBlock;
	}

	public String getNotPayee() {
		return notPayee;
	}

	public void setNotPayee(String notPayee) {
		this.notPayee = notPayee;
	}

	public String getVendorBlackList() {
		return vendorBlackList;
	}

	public void setVendorBlackList(String vendorBlackList) {
		this.vendorBlackList = vendorBlackList;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getVendorAccountNo() {
		return vendorAccountNo;
	}

	public void setVendorAccountNo(String vendorAccountNo) {
		this.vendorAccountNo = vendorAccountNo;
	}

	public String getVendorAccountName() {
		return vendorAccountName;
	}

	public void setVendorAccountName(String vendorAccountName) {
		this.vendorAccountName = vendorAccountName;
	}

	public String getVendorAccountType() {
		return vendorAccountType;
	}

	public void setVendorAccountType(String vendorAccountType) {
		this.vendorAccountType = vendorAccountType;
	}

	public String getVendorBankName() {
		return vendorBankName;
	}

	public void setVendorBankName(String vendorBankName) {
		this.vendorBankName = vendorBankName;
	}

	public String getPayeeCode() {
		return payeeCode;
	}

	public void setPayeeCode(String payeeCode) {
		this.payeeCode = payeeCode;
	}

	public String getPayeeType() {
		return payeeType;
	}

	public void setPayeeType(String payeeType) {
		this.payeeType = payeeType;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getPayeeIdCard() {
		return payeeIdCard;
	}

	public void setPayeeIdCard(String payeeIdCard) {
		this.payeeIdCard = payeeIdCard;
	}

	public String getPayeeTaxId() {
		return payeeTaxId;
	}

	public void setPayeeTaxId(String payeeTaxId) {
		this.payeeTaxId = payeeTaxId;
	}

	public String getPayeeAddress() {
		return payeeAddress;
	}

	public void setPayeeAddress(String payeeAddress) {
		this.payeeAddress = payeeAddress;
	}

	public String getPayeeAccountNo() {
		return payeeAccountNo;
	}

	public void setPayeeAccountNo(String payeeAccountNo) {
		this.payeeAccountNo = payeeAccountNo;
	}

	public String getPayeeAccountName() {
		return payeeAccountName;
	}

	public void setPayeeAccountName(String payeeAccountName) {
		this.payeeAccountName = payeeAccountName;
	}

	public String getPayeeAccountType() {
		return payeeAccountType;
	}

	public void setPayeeAccountType(String payeeAccountType) {
		this.payeeAccountType = payeeAccountType;
	}

	public String getPayeeBankName() {
		return payeeBankName;
	}

	public void setPayeeBankName(String payeeBankName) {
		this.payeeBankName = payeeBankName;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getVendorTypeTxt() {
		return vendorTypeTxt;
	}

	public void setVendorTypeTxt(String vendorTypeTxt) {
		this.vendorTypeTxt = vendorTypeTxt;
	}

	public String getHqFlagTxt() {
		return hqFlagTxt;
	}

	public void setHqFlagTxt(String hqFlagTxt) {
		this.hqFlagTxt = hqFlagTxt;
	}

	public String getVendorFlowStatusTxt() {
		return vendorFlowStatusTxt;
	}

	public void setVendorFlowStatusTxt(String vendorFlowStatusTxt) {
		this.vendorFlowStatusTxt = vendorFlowStatusTxt;
	}

	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	public String getPayeeId() {
		return payeeId;
	}

	public void setPayeeId(String payeeId) {
		this.payeeId = payeeId;
	}

	public String getBookbankPayeeId() {
		return bookbankPayeeId;
	}

	public void setBookbankPayeeId(String bookbankPayeeId) {
		this.bookbankPayeeId = bookbankPayeeId;
	}

	public String getConfirmFlag() {
		return confirmFlag;
	}

	public void setConfirmFlag(String confirmFlag) {
		this.confirmFlag = confirmFlag;
	}

	public String getVendorCompanySap() {
		return vendorCompanySap;
	}

	public void setVendorCompanySap(String vendorCompanySap) {
		this.vendorCompanySap = vendorCompanySap;
	}

	public String getPayeeBookbankId() {
		return payeeBookbankId;
	}

	public void setPayeeBookbankId(String payeeBookbankId) {
		this.payeeBookbankId = payeeBookbankId;
	}

	public String getVendorInfoTxt1() {
		return vendorInfoTxt1;
	}

	public void setVendorInfoTxt1(String vendorInfoTxt1) {
		this.vendorInfoTxt1 = vendorInfoTxt1;
	}

	public String getVendorInfoTxt2() {
		return vendorInfoTxt2;
	}

	public void setVendorInfoTxt2(String vendorInfoTxt2) {
		this.vendorInfoTxt2 = vendorInfoTxt2;
	}

	public String getVendorInfoTxt3() {
		return vendorInfoTxt3;
	}

	public void setVendorInfoTxt3(String vendorInfoTxt3) {
		this.vendorInfoTxt3 = vendorInfoTxt3;
	}

	public String getVendorInfoTxt4() {
		return vendorInfoTxt4;
	}

	public void setVendorInfoTxt4(String vendorInfoTxt4) {
		this.vendorInfoTxt4 = vendorInfoTxt4;
	}

	public String getConfirmTxt() {
		return confirmTxt;
	}

	public void setConfirmTxt(String confirmTxt) {
		this.confirmTxt = confirmTxt;
	}

	@Override
	public String toString() {
		return "Mmm001VendorSP [address=" + address + ", address1=" + address1
				+ ", address2=" + address2 + ", address3=" + address3
				+ ", address4=" + address4 + ", amphur=" + amphur
				+ ", amphurName=" + amphurName + ", bankBranch=" + bankBranch
				+ ", bankBranchCode=" + bankBranchCode + ", bankCode="
				+ bankCode + ", bankName=" + bankName + ", branchNo="
				+ branchNo + ", chkVAT=" + chkVAT + ", company=" + company
				+ ", contractNo=" + contractNo + ", effectiveDt=" + effectiveDt
				+ ", effectiveDtStr=" + effectiveDtStr + ", email=" + email
				+ ", expenseType=" + expenseType + ", fax=" + fax
				+ ", groupType=" + groupType + ", hqFlag=" + hqFlag
				+ ", idCard=" + idCard + ", includeVAT=" + includeVAT
				+ ", mobileNo=" + mobileNo + ", payType=" + payType
				+ ", postCode=" + postCode + ", province=" + province
				+ ", provinceName=" + provinceName + ", recipientType="
				+ recipientType + ", region=" + region + ", regionName="
				+ regionName + ", rowId=" + rowId + ", sapReturnCode="
				+ sapReturnCode + ", saveFlag=" + saveFlag + ", tambol="
				+ tambol + ", tambolName=" + tambolName + ", taxId=" + taxId
				+ ", telephone=" + telephone + ", titleName=" + titleName
				+ ", typeFlag=" + typeFlag + ", vendorBlackListStatus="
				+ vendorBlackListStatus + ", vendorBlockStatus="
				+ vendorBlockStatus + ", vendorBookbankId=" + vendorBookbankId
				+ ", vendorCode=" + vendorCode + ", vendorFlowStatus="
				+ vendorFlowStatus + ", vendorId=" + vendorId
				+ ", vendorIdChngeFrm=" + vendorIdChngeFrm + ", vendorName="
				+ vendorName + ", vendorName1=" + vendorName1
				+ ", vendorName2=" + vendorName2 + ", vendorName3="
				+ vendorName3 + ", vendorName4=" + vendorName4
				+ ", vendorRemark=" + vendorRemark + ", vendorStatus="
				+ vendorStatus + ", vendorType=" + vendorType + ", whtCode="
				+ whtCode + ", whtId=" + whtId + ", whtType=" + whtType
				+ ", withoutContractRemark=" + withoutContractRemark + "]";
	}
	
	
}
