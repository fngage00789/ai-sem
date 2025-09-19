package th.co.ais.domain.mm;

import java.util.Date;
import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.DateUtil;

public class Mmm001BookbankPayeeSP extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8288933363114628912L;

	private String rowId;
	
	private String bookbankPayeeId;
	private String bookbankPayeeStatus;
	private String bookbankPayeeFlowStatus;
	private String bookbankStatus;
	private String bookbankFlowStatus;
	private String contractNo;
	private String expenseType;
	
	private Date firstEffectiveDt;
	private String firstEffectiveDtStr;
	private Date effectiveDt;
	private String effectiveDtStr;
	private Date expireDt;
	private String expireDtStr;
	
	private String payType;
	private String accountNo;
	private String accountName;
	private String accountType;
	private String bankCode;
	private String bankId;
	private String bankName;
	private String bankBranchCode;
	private String bankBranch;

	private String tambol;		//same like tambolCode
	private String tambolName;
	private String amphur;		//same like amphurCode
	private String amphurName;
	private String province;	//same like provinceCode
	private String provinceName;
	
	private String remark;
	
	private String payeeEffectiveDt;
	private String payeeEffectiveDtStr;
	
	private String payeeId;
	
	private String vendorId;
	private String saveFlag;
	
	private String activeStatus;
	
	private String vendorMapPayeeId;
	
	private String payeeBookbankBatch;
	
	private String validateFlag;
	private String validateCaseId;
	
	private String provinceTxt;
	private String activeStatusTxt;
	private String bookbankFlowStatusTxt;
	
	private String confirmFlag;
	
	private String deleteFlag;
	private String sendManagerFlag;
	
	private String accountTypeTxt;
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
	public String getBookbankPayeeFlowStatus() {
		return bookbankPayeeFlowStatus;
	}
	public void setBookbankPayeeFlowStatus(String bookbankPayeeFlowStatus) {
		this.bookbankPayeeFlowStatus = bookbankPayeeFlowStatus;
	}
	public String getBookbankStatus() {
		return bookbankStatus;
	}
	public void setBookbankStatus(String bookbankStatus) {
		this.bookbankStatus = bookbankStatus;
	}
	public String getBookbankFlowStatus() {
		return bookbankFlowStatus;
	}
	public void setBookbankFlowStatus(String bookbankFlowStatus) {
		this.bookbankFlowStatus = bookbankFlowStatus;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public Date getFirstEffectiveDt() throws Exception {
		if(firstEffectiveDtStr != null){
			firstEffectiveDt = DateUtil.getDate(firstEffectiveDtStr, DateUtil.SIMPLE_DATE_PATTERN);
		}
		return firstEffectiveDt;
	}
	public void setFirstEffectiveDt(Date firstEffectiveDt) {
		this.firstEffectiveDt = firstEffectiveDt;
	}
	public String getFirstEffectiveDtStr() {
		return firstEffectiveDtStr;
	}
	public void setFirstEffectiveDtStr(String firstEffectiveDtStr) {
		this.firstEffectiveDtStr = firstEffectiveDtStr;
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
	public Date getExpireDt() throws Exception {
		if(expireDtStr != null){
			expireDt = DateUtil.getDate(expireDtStr, DateUtil.SIMPLE_DATE_PATTERN);
		}
		return expireDt;
	}
	public void setExpireDt(Date expireDt) {
		this.expireDt = expireDt;
	}
	public String getExpireDtStr() {
		return expireDtStr;
	}
	public void setExpireDtStr(String expireDtStr) {
		this.expireDtStr = expireDtStr;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
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
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
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
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPayeeEffectiveDt() {
		return payeeEffectiveDt;
	}
	public void setPayeeEffectiveDt(String payeeEffectiveDt) {
		this.payeeEffectiveDt = payeeEffectiveDt;
	}
	public String getPayeeEffectiveDtStr() {
		return payeeEffectiveDtStr;
	}
	public void setPayeeEffectiveDtStr(String payeeEffectiveDtStr) {
		this.payeeEffectiveDtStr = payeeEffectiveDtStr;
	}
	public String getPayeeId() {
		return payeeId;
	}
	public void setPayeeId(String payeeId) {
		this.payeeId = payeeId;
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
	public String getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	public String getTambol() {
		return tambol;
	}
	public void setTambol(String tambol) {
		this.tambol = tambol;
	}
	public String getTambolName() {
		return tambolName;
	}
	public void setTambolName(String tambolName) {
		this.tambolName = tambolName;
	}
	public String getAmphur() {
		return amphur;
	}
	public void setAmphur(String amphur) {
		this.amphur = amphur;
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
	public String getVendorMapPayeeId() {
		return vendorMapPayeeId;
	}
	public void setVendorMapPayeeId(String vendorMapPayeeId) {
		this.vendorMapPayeeId = vendorMapPayeeId;
	}
	
	
	public String getPayeeBookbankBatch() {
		return payeeBookbankBatch;
	}
	public void setPayeeBookbankBatch(String payeeBookbankBatch) {
		this.payeeBookbankBatch = payeeBookbankBatch;
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
	public String getProvinceTxt() {
		return provinceTxt;
	}
	public void setProvinceTxt(String provinceTxt) {
		this.provinceTxt = provinceTxt;
	}
	public String getActiveStatusTxt() {
		return activeStatusTxt;
	}
	public void setActiveStatusTxt(String activeStatusTxt) {
		this.activeStatusTxt = activeStatusTxt;
	}
	public String getBookbankFlowStatusTxt() {
		return bookbankFlowStatusTxt;
	}
	public void setBookbankFlowStatusTxt(String bookbankFlowStatusTxt) {
		this.bookbankFlowStatusTxt = bookbankFlowStatusTxt;
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
	public String getAccountTypeTxt() {
		return accountTypeTxt;
	}
	public void setAccountTypeTxt(String accountTypeTxt) {
		this.accountTypeTxt = accountTypeTxt;
	}
	public String getConfirmTxt() {
		return confirmTxt;
	}
	public void setConfirmTxt(String confirmTxt) {
		this.confirmTxt = confirmTxt;
	}
	@Override
	public String toString() {
		return "Mmm001BookbankPayeeSP [accountName=" + accountName
				+ ", accountNo=" + accountNo + ", accountType=" + accountType
				+ ", activeStatus=" + activeStatus + ", amphur=" + amphur
				+ ", amphurName=" + amphurName + ", bankBranch=" + bankBranch
				+ ", bankBranchCode=" + bankBranchCode + ", bankCode="
				+ bankCode + ", bankId=" + bankId + ", bankName=" + bankName
				+ ", bookbankFlowStatus=" + bookbankFlowStatus
				+ ", bookbankPayeeFlowStatus=" + bookbankPayeeFlowStatus
				+ ", bookbankPayeeId=" + bookbankPayeeId
				+ ", bookbankPayeeStatus=" + bookbankPayeeStatus
				+ ", bookbankStatus=" + bookbankStatus + ", contractNo="
				+ contractNo + ", effectiveDt=" + effectiveDt
				+ ", effectiveDtStr=" + effectiveDtStr + ", expenseType="
				+ expenseType + ", expireDt=" + expireDt + ", expireDtStr="
				+ expireDtStr + ", firstEffectiveDt=" + firstEffectiveDt
				+ ", firstEffectiveDtStr=" + firstEffectiveDtStr + ", payType="
				+ payType + ", payeeEffectiveDt=" + payeeEffectiveDt
				+ ", payeeEffectiveDtStr=" + payeeEffectiveDtStr + ", payeeId="
				+ payeeId + ", province=" + province + ", provinceName="
				+ provinceName + ", remark=" + remark + ", rowId=" + rowId
				+ ", saveFlag=" + saveFlag + ", tambol=" + tambol
				+ ", tambolName=" + tambolName + ", vendorId=" + vendorId
				+ ", vendorMapPayeeId=" + vendorMapPayeeId + "]";
	}

	
}
