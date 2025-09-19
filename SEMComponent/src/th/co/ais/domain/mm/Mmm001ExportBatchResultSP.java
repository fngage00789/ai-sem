package th.co.ais.domain.mm;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mmm001ExportBatchResultSP extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4503313130380951833L;
	
	private String rowId;
	private String batchNo;
	private String actionType;
	
	private String idCard;
	private String taxId;
	
	private String vendorCode;
	private String vendorName;
	private String vendorStatus;
	private String vendorFlowStatus;
	private String vendorBlockStatus;
	
	private String contractType;
	private String contractNo;
	private String contractOldNo;
	private String contractStatus;
	private String contractName;
	
	private String expenseType;
	
	private String locationId;
	private String locationCode;
	private String locationName;
	
	private String bankCode;
	private String bankName;
	private String bankBranchCode;
	private String bankBranch;
	
	private String payeeId;
	private String payeeName;
	private String payeeStatus;
	private String payeeFlowStatus;
	private String payeeBankName;
	private String payeeAccountNo;
	private String payeeAccountName;
	private String payeeAccountStatus;
	private String payeeAccountFlowStatus;
	
	private String accountNo;
	private String accountName;
	private String accountStatus;
	private String accountFlowStatus;
	
	private String remark;
	
	
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
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
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
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getContractOldNo() {
		return contractOldNo;
	}
	public void setContractOldNo(String contractOldNo) {
		this.contractOldNo = contractOldNo;
	}
	public String getContractStatus() {
		return contractStatus;
	}
	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
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
	public String getPayeeId() {
		return payeeId;
	}
	public void setPayeeId(String payeeId) {
		this.payeeId = payeeId;
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
	public String getPayeeFlowStatus() {
		return payeeFlowStatus;
	}
	public void setPayeeFlowStatus(String payeeFlowStatus) {
		this.payeeFlowStatus = payeeFlowStatus;
	}
	public String getPayeeBankName() {
		return payeeBankName;
	}
	public void setPayeeBankName(String payeeBankName) {
		this.payeeBankName = payeeBankName;
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
	public String getPayeeAccountStatus() {
		return payeeAccountStatus;
	}
	public void setPayeeAccountStatus(String payeeAccountStatus) {
		this.payeeAccountStatus = payeeAccountStatus;
	}
	public String getPayeeAccountFlowStatus() {
		return payeeAccountFlowStatus;
	}
	public void setPayeeAccountFlowStatus(String payeeAccountFlowStatus) {
		this.payeeAccountFlowStatus = payeeAccountFlowStatus;
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
	public String getAccountFlowStatus() {
		return accountFlowStatus;
	}
	public void setAccountFlowStatus(String accountFlowStatus) {
		this.accountFlowStatus = accountFlowStatus;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "Mmm001ExportBatchResultSP [accountFlowStatus=" + accountFlowStatus + ", accountName=" + accountName + ", accountNo=" + accountNo + ", accountStatus=" + accountStatus + ", actionType=" + actionType + ", bankBranch=" + bankBranch + ", bankBranchCode=" + bankBranchCode + ", bankCode=" + bankCode + ", bankName=" + bankName + ", batchNo=" + batchNo + ", contractName=" + contractName + ", contractNo=" + contractNo + ", contractOldNo=" + contractOldNo + ", contractStatus=" + contractStatus + ", contractType=" + contractType + ", expenseType=" + expenseType + ", idCard=" + idCard + ", locationCode=" + locationCode + ", locationId=" + locationId + ", locationName=" + locationName + ", payeeAccountFlowStatus=" + payeeAccountFlowStatus + ", payeeAccountName=" + payeeAccountName + ", payeeAccountNo=" + payeeAccountNo + ", payeeAccountStatus=" + payeeAccountStatus
				+ ", payeeBankName=" + payeeBankName + ", payeeFlowStatus=" + payeeFlowStatus + ", payeeId=" + payeeId + ", payeeName=" + payeeName + ", payeeStatus=" + payeeStatus + ", remark=" + remark + ", rowId=" + rowId + ", taxId=" + taxId + ", vendorBlockStatus=" + vendorBlockStatus + ", vendorCode=" + vendorCode + ", vendorFlowStatus=" + vendorFlowStatus + ", vendorName=" + vendorName + ", vendorStatus=" + vendorStatus + "]";
	}
	
	
}
