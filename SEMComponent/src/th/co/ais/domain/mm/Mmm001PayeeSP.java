package th.co.ais.domain.mm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.DateUtil;

public class Mmm001PayeeSP extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4093317868240131504L;

	private String rowId;
	
	private String payeeId;
	private String payeeCode;
	private String payeeName;
	private String payeeStatusId;
	private String payeeStatus;
	private String payeeStatusTxt;
	private String payeeType;
	private String payeeFlowStatusId;
	private String payeeFlowStatus;
	private String bankCode;
	private String bankName;
	private String bankBranchCode;
	private String bankBranch;
	
	private String accountNo;
	private String accountName;
	private String bookbankPayeeId;
	private String bookbankPayeeStatus;
	private String bookbankPayeeFlowStatus;
	private String expenseType;
	private String expenseTypeTxt;
	private String remark;
	
	private String idCard;
	private String taxId;
	private String payeeAddress1;
	private String payeeAddress2;
	private String tambol;		//same like tambolCode
	private String tambolName;
	private String amphur;		//same like amphurCode
	private String amphurName;
	private String province;	//same like provinceCode
	private String provinceName;
	private String pTaxFlag;
	private String postCode;
	private String contactName;
	private String telephone;
	private String mobileNo;
	private String fax;
	private String email;
	private String activeStatus;
	
	private String groupType;
	private String payeeBlockStatus;
	private String hqFlag;
	private String branchNo;
	
	private String contractNo;
	private String vendorId;
	private String saveFlag;
	
	// 2107/08/09
	private String vendorMapPayeeId;
	private String payType;
	private String expenseEffectiveDtStr;
	private Date expenseEffectiveDt;
	
	
	private List<SelectItem> tambolList;
	private List<SelectItem> amphurList;
	private List<SelectItem> provinceList;
	
	private boolean chkTambolOther = false;
	private boolean chkAmphurOther = false;
	private boolean chkLocalDepartment = false;
	
	private String  payeeBatch;
	
	private String validateFlag;
	private String validateCaseId;
	
	private String payeeTypeTxt;
	private String payeeFlowStatusTxt;
	
	private String updateDtStr;
	
	private String confirmFlag;
	private String deleteFlag;
	private String sendManagerFlag;
	private String provinceTxt;
	
	private String confirmTxt;
	
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
	public String getPayeeId() {
		return payeeId;
	}
	public void setPayeeId(String payeeId) {
		this.payeeId = payeeId;
	}
	public String getPayeeCode() {
		return payeeCode;
	}
	public void setPayeeCode(String payeeCode) {
		this.payeeCode = payeeCode;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public String getPayeeStatus() {
		return payeeStatus;
	}
	public void setPayeeStatus(String payeeStatus) {
		this.payeeStatus = payeeStatus;
	}
	public String getPayeeType() {
		return payeeType;
	}
	public void setPayeeType(String payeeType) {
		this.payeeType = payeeType;
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
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getBookbankPayeeId() {
		return bookbankPayeeId;
	}
	public void setBookbankPayeeId(String bookbankPayeeId) {
		this.bookbankPayeeId = bookbankPayeeId;
	}
	public String getBookbankPayeeStatus() {
		return bookbankPayeeStatus;
	}
	public void setBookbankPayeeStatus(String bookbankPayeeStatus) {
		this.bookbankPayeeStatus = bookbankPayeeStatus;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public String getPayeeAddress1() {
		return payeeAddress1;
	}
	public void setPayeeAddress1(String payeeAddress1) {
		this.payeeAddress1 = payeeAddress1;
	}
	public String getPayeeAddress2() {
		return payeeAddress2;
	}
	public void setPayeeAddress2(String payeeAddress2) {
		this.payeeAddress2 = payeeAddress2;
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
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
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
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPayeeFlowStatus() {
		return payeeFlowStatus;
	}
	public void setPayeeFlowStatus(String payeeFlowStatus) {
		this.payeeFlowStatus = payeeFlowStatus;
	}
	public String getBookbankPayeeFlowStatus() {
		return bookbankPayeeFlowStatus;
	}
	public void setBookbankPayeeFlowStatus(String bookbankPayeeFlowStatus) {
		this.bookbankPayeeFlowStatus = bookbankPayeeFlowStatus;
	}
	public String getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getSaveFlag() {
		return saveFlag;
	}
	public void setSaveFlag(String saveFlag) {
		this.saveFlag = saveFlag;
	}
	public String getExpenseEffectiveDtStr() {
		return expenseEffectiveDtStr;
	}
	public void setExpenseEffectiveDtStr(String expenseEffectiveDtStr) {
		this.expenseEffectiveDtStr = expenseEffectiveDtStr;
	}
	public Date getExpenseEffectiveDt() throws Exception {
		if(expenseEffectiveDtStr != null){
			expenseEffectiveDt = DateUtil.getDate(expenseEffectiveDtStr, DateUtil.SIMPLE_DATE_PATTERN);
		}
		return expenseEffectiveDt;
	}
	public void setExpenseEffectiveDt(Date expenseEffectiveDt) {
		this.expenseEffectiveDt = expenseEffectiveDt;
	}
	public String getGroupType() {
		return groupType;
	}
	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}
	public String getPayeeBlockStatus() {
		return payeeBlockStatus;
	}
	public void setPayeeBlockStatus(String payeeBlockStatus) {
		this.payeeBlockStatus = payeeBlockStatus;
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
	public List<SelectItem> getTambolList() {
		if(tambolList == null){
			tambolList = new ArrayList<SelectItem>();
		}
		return tambolList;
	}
	public void setTambolList(List<SelectItem> tambolList) {
		this.tambolList = tambolList;
	}
	public List<SelectItem> getAmphurList() {
		if(amphurList == null){
			amphurList = new ArrayList<SelectItem>();
		}
		return amphurList;
	}
	public void setAmphurList(List<SelectItem> amphurList) {
		this.amphurList = amphurList;
	}
	public List<SelectItem> getProvinceList() {
		if(provinceList == null){
			provinceList = new ArrayList<SelectItem>();
		}
		return provinceList;
	}
	public void setProvinceList(List<SelectItem> provinceList) {
		this.provinceList = provinceList;
	}
	public String getPayeeStatusId() {
		return payeeStatusId;
	}
	public void setPayeeStatusId(String payeeStatusId) {
		this.payeeStatusId = payeeStatusId;
	}
	public String getPayeeFlowStatusId() {
		return payeeFlowStatusId;
	}
	public void setPayeeFlowStatusId(String payeeFlowStatusId) {
		this.payeeFlowStatusId = payeeFlowStatusId;
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
	public String getpTaxFlag() {
		return pTaxFlag;
	}
	public void setpTaxFlag(String pTaxFlag) {
		this.pTaxFlag = pTaxFlag;
	}
	public boolean isChkTambolOther() {
		return chkTambolOther;
	}
	public void setChkTambolOther(boolean chkTambolOther) {
		this.chkTambolOther = chkTambolOther;
	}
	public boolean isChkAmphurOther() {
		return chkAmphurOther;
	}
	public void setChkAmphurOther(boolean chkAmphurOther) {
		this.chkAmphurOther = chkAmphurOther;
	}
	public boolean isChkLocalDepartment() {
		return chkLocalDepartment;
	}
	public void setChkLocalDepartment(boolean chkLocalDepartment) {
		this.chkLocalDepartment = chkLocalDepartment;
	}
	public String getVendorMapPayeeId() {
		return vendorMapPayeeId;
	}
	public void setVendorMapPayeeId(String vendorMapPayeeId) {
		this.vendorMapPayeeId = vendorMapPayeeId;
	}
	
	
	public String getPayeeBatch() {
		return payeeBatch;
	}
	public void setPayeeBatch(String payeeBatch) {
		this.payeeBatch = payeeBatch;
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
	public String getPayeeStatusTxt() {
		return payeeStatusTxt;
	}
	public void setPayeeStatusTxt(String payeeStatusTxt) {
		this.payeeStatusTxt = payeeStatusTxt;
	}
	public String getExpenseTypeTxt() {
		return expenseTypeTxt;
	}
	public void setExpenseTypeTxt(String expenseTypeTxt) {
		this.expenseTypeTxt = expenseTypeTxt;
	}
	public String getPayeeTypeTxt() {
		return payeeTypeTxt;
	}
	public void setPayeeTypeTxt(String payeeTypeTxt) {
		this.payeeTypeTxt = payeeTypeTxt;
	}
	public String getPayeeFlowStatusTxt() {
		return payeeFlowStatusTxt;
	}
	public void setPayeeFlowStatusTxt(String payeeFlowStatusTxt) {
		this.payeeFlowStatusTxt = payeeFlowStatusTxt;
	}
	public String getUpdateDtStr() {
		return updateDtStr;
	}
	public void setUpdateDtStr(String updateDtStr) {
		this.updateDtStr = updateDtStr;
	}
	public String getConfirmFlag() {
		return confirmFlag;
	}
	public void setConfirmFlag(String confirmFlag) {
		this.confirmFlag = confirmFlag;
	}
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getSendManagerFlag() {
		return sendManagerFlag;
	}
	public void setSendManagerFlag(String sendManagerFlag) {
		this.sendManagerFlag = sendManagerFlag;
	}
	public String getProvinceTxt() {
		return provinceTxt;
	}
	public void setProvinceTxt(String provinceTxt) {
		this.provinceTxt = provinceTxt;
	}
	public String getConfirmTxt() {
		return confirmTxt;
	}
	public void setConfirmTxt(String confirmTxt) {
		this.confirmTxt = confirmTxt;
	}
	@Override
	public String toString() {
		return "Mmm001PayeeSP [accountName=" + accountName + ", accountNo="
				+ accountNo + ", activeStatus=" + activeStatus + ", amphur="
				+ amphur + ", amphurList=" + amphurList + ", amphurName="
				+ amphurName + ", bankBranch=" + bankBranch
				+ ", bankBranchCode=" + bankBranchCode + ", bankCode="
				+ bankCode + ", bankName=" + bankName
				+ ", bookbankPayeeFlowStatus=" + bookbankPayeeFlowStatus
				+ ", bookbankPayeeId=" + bookbankPayeeId
				+ ", bookbankPayeeStatus=" + bookbankPayeeStatus
				+ ", branchNo=" + branchNo + ", chkAmphurOther="
				+ chkAmphurOther + ", chkLocalDepartment=" + chkLocalDepartment
				+ ", chkTambolOther=" + chkTambolOther + ", contactName="
				+ contactName + ", contractNo=" + contractNo + ", email="
				+ email + ", expenseEffectiveDt=" + expenseEffectiveDt
				+ ", expenseEffectiveDtStr=" + expenseEffectiveDtStr
				+ ", expenseType=" + expenseType + ", fax=" + fax
				+ ", groupType=" + groupType + ", hqFlag=" + hqFlag
				+ ", idCard=" + idCard + ", mobileNo=" + mobileNo
				+ ", payType=" + payType + ", payeeAddress1=" + payeeAddress1
				+ ", payeeAddress2=" + payeeAddress2 + ", payeeBlockStatus="
				+ payeeBlockStatus + ", payeeCode=" + payeeCode
				+ ", payeeFlowStatus=" + payeeFlowStatus
				+ ", payeeFlowStatusId=" + payeeFlowStatusId + ", payeeId="
				+ payeeId + ", payeeName=" + payeeName + ", payeeStatus="
				+ payeeStatus + ", payeeStatusId=" + payeeStatusId
				+ ", payeeType=" + payeeType + ", postCode=" + postCode
				+ ", province=" + province + ", provinceList=" + provinceList
				+ ", provinceName=" + provinceName + ", remark=" + remark
				+ ", rowId=" + rowId + ", saveFlag=" + saveFlag + ", tambol="
				+ tambol + ", tambolList=" + tambolList + ", tambolName="
				+ tambolName + ", taxId=" + taxId + ", telephone=" + telephone
				+ ", vendorId=" + vendorId + ", vendorMapPayeeId="
				+ vendorMapPayeeId + "]";
	}
	
	
}
