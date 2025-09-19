package th.co.ais.domain.mm;

import java.util.Date;
import th.co.ais.domain.AbstractDomain;

public class Mmm001BookbankSP extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 866372253119194110L;

	private String rowId;
	
	private String vendorBookbankId;
	
	private String accountNo;
	private String accountName;
	private String accountType;
	private String accountTypeTxt;
	private String bankCode;
	private String bankId;
	private String bankName;
	private String bankBranchCode;
	private String bankBranch;
	private String province;
	private String remark;
	private String bookbankStatus;
	private String bookbankFlowStatus;
	private String activeStatus;
	
	private String contractNo;
	private String vendorId;
	private String vendorCode;
	private String bookbankBatch;
	
	private String saveFlag;
	
	private String validateFlag;
	private String validateCaseId;
	

	private String provinceTxt;
	private String activeStatusTxt;
	private String bookbankFlowStatusTxt;
	
	private String updateDtStr;
	
	private String confirmFlag;
	private String deleteFlag;
	private String sendManagerFlag;
	
	private String confirmTxt;
	
	private String result;
	
	public Mmm001BookbankSP(){}
	
	public Mmm001BookbankSP(Mmm001BookbankSP bookbank) {
		// TODO Auto-generated constructor stub
		
		vendorBookbankId = bookbank.getVendorBookbankId();
		
		accountNo = bookbank.getAccountNo();
		accountName = bookbank.getAccountName();
		accountType = bookbank.getAccountType();
		bankCode = bookbank.getBankCode();
		bankName = bookbank.getBankName();
		bankBranchCode = bookbank.getBankBranchCode();
		bankBranch = bookbank.getBankBranch();
		province = bookbank.getProvince();
		remark = bookbank.getRemark();
		bookbankStatus = bookbank.getBookbankStatus();
		bookbankFlowStatus = bookbank.getBookbankFlowStatus();
		activeStatus = bookbank.getActiveStatus();
		
		contractNo = bookbank.getContractNo();
		vendorId = bookbank.getVendorId();
		
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
	public String getVendorBookbankId() {
		return vendorBookbankId;
	}
	public void setVendorBookbankId(String vendorBookbankId) {
		this.vendorBookbankId = vendorBookbankId;
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
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
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
	public String getVendorCode() {
		return vendorCode;
	}
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	public String getSaveFlag() {
		return saveFlag;
	}
	public void setSaveFlag(String saveFlag) {
		this.saveFlag = saveFlag;
	}

	
	public String getBookbankBatch() {
		return bookbankBatch;
	}

	public void setBookbankBatch(String bookbankBatch) {
		this.bookbankBatch = bookbankBatch;
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

	public String getAccountTypeTxt() {
		return accountTypeTxt;
	}

	public void setAccountTypeTxt(String accountTypeTxt) {
		this.accountTypeTxt = accountTypeTxt;
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

	public String getConfirmTxt() {
		return confirmTxt;
	}

	public void setConfirmTxt(String confirmTxt) {
		this.confirmTxt = confirmTxt;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Mmm001BookbankSP [accountName=" + accountName + ", accountNo="
				+ accountNo + ", accountType=" + accountType
				+ ", activeStatus=" + activeStatus + ", bankBranch="
				+ bankBranch + ", bankBranchCode=" + bankBranchCode
				+ ", bankCode=" + bankCode + ", bankId=" + bankId
				+ ", bankName=" + bankName + ", bookbankFlowStatus="
				+ bookbankFlowStatus + ", bookbankStatus=" + bookbankStatus
				+ ", contractNo=" + contractNo + ", province=" + province
				+ ", remark=" + remark + ", rowId=" + rowId + ", saveFlag="
				+ saveFlag + ", vendorBookbankId=" + vendorBookbankId
				+ ", vendorCode=" + vendorCode + ", vendorId=" + vendorId + "]";
	}

	
}
