package th.co.ais.domain.mm;

import java.util.Date;
import th.co.ais.domain.AbstractDomain;

public class Mmm001SAPBookbankSP extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2435418838390544473L;

	private String rowId;
	
	private String vendorBookbankId;
	
	private String accountNo;
	private String accountName;
	private String accountType;
	private String bankCode;
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
	
	private String saveFlag;
	
	
	private String callSapFlag;
	private String koart;
	private String xTechAccNo;
	
	
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
	public String getCallSapFlag() {
		return callSapFlag;
	}
	public void setCallSapFlag(String callSapFlag) {
		this.callSapFlag = callSapFlag;
	}
	public String getKoart() {
		return koart;
	}
	public void setKoart(String koart) {
		this.koart = koart;
	}
	public String getxTechAccNo() {
		return xTechAccNo;
	}
	public void setxTechAccNo(String xTechAccNo) {
		this.xTechAccNo = xTechAccNo;
	}
	
	
	@Override
	public String toString() {
		return "Mmm001SAPBookbankSP [accountName=" + accountName
				+ ", accountNo=" + accountNo + ", accountType=" + accountType
				+ ", activeStatus=" + activeStatus + ", bankBranch="
				+ bankBranch + ", bankBranchCode=" + bankBranchCode
				+ ", bankCode=" + bankCode + ", bankName=" + bankName
				+ ", bookbankFlowStatus=" + bookbankFlowStatus
				+ ", bookbankStatus=" + bookbankStatus + ", callSapFlag="
				+ callSapFlag + ", contractNo=" + contractNo + ", koart="
				+ koart + ", province=" + province + ", remark=" + remark
				+ ", rowId=" + rowId + ", saveFlag=" + saveFlag
				+ ", vendorBookbankId=" + vendorBookbankId + ", vendorCode="
				+ vendorCode + ", vendorId=" + vendorId + ", xTechAccNo="
				+ xTechAccNo + "]";
	}
	
	
}
