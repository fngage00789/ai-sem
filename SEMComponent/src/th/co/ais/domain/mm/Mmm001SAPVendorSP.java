package th.co.ais.domain.mm;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mmm001SAPVendorSP extends AbstractDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3711453279292730005L;
	
	private String rowId;
	private String company;
	private String idCard;
	private String taxId;
	private String vendorId;
	private String vendorCode;
	private String vendorName;
	private String vendorStatus;
	private String vendorFlowStatus;
	private String vendorBlockStatus;
	private String vendorBranchNo;
	private String bookbankId;
	private String bookbankStatus;
	private String bookbankFlowStatus;
	private String bankName;
	private String accountNo;
	private String accountName;
	private String accountStatus;
	private String activeStatus;
	private String remark;
	private String callSapFlag;
	private String role;
	private String roleType;
	private String result;
	private String vendorMapPayeeId;
	
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
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
	public String getVendorBranchNo() {
		return vendorBranchNo;
	}
	public void setVendorBranchNo(String vendorBranchNo) {
		this.vendorBranchNo = vendorBranchNo;
	}
	public String getBookbankId() {
		return bookbankId;
	}
	public void setBookbankId(String bookbankId) {
		this.bookbankId = bookbankId;
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
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
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
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public String getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCallSapFlag() {
		return callSapFlag;
	}
	public void setCallSapFlag(String callSapFlag) {
		this.callSapFlag = callSapFlag;
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
	
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getVendorMapPayeeId() {
		return vendorMapPayeeId;
	}
	public void setVendorMapPayeeId(String vendorMapPayeeId) {
		this.vendorMapPayeeId = vendorMapPayeeId;
	}
	@Override
	public String toString() {
		return "Mmm001SAPVendorSP [accountName=" + accountName + ", accountNo="
				+ accountNo + ", accountStatus=" + accountStatus
				+ ", activeStatus=" + activeStatus + ", bankName=" + bankName
				+ ", bookbankFlowStatus=" + bookbankFlowStatus
				+ ", bookbankId=" + bookbankId + ", bookbankStatus="
				+ bookbankStatus + ", callSapFlag=" + callSapFlag
				+ ", company=" + company + ", idCard=" + idCard + ", remark="
				+ remark + ", role=" + role + ", roleType=" + roleType
				+ ", rowId=" + rowId + ", taxId=" + taxId
				+ ", vendorBlockStatus=" + vendorBlockStatus
				+ ", vendorBranchNo=" + vendorBranchNo + ", vendorCode="
				+ vendorCode + ", vendorFlowStatus=" + vendorFlowStatus
				+ ", vendorId=" + vendorId + ", vendorName=" + vendorName
				+ ", vendorStatus=" + vendorStatus + "]";
	}

	
}
