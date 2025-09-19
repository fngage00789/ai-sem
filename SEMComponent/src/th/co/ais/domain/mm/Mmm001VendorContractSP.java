package th.co.ais.domain.mm;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mmm001VendorContractSP extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4368054319384892352L;
	
	private String rowId;

	private String vendorId;
	private String vendorCode;
	private String vendorName;
	private String idCard;
	private String taxId;
	
	private String expenseType;
	private String siteName;
	private String vendorStatus;
	private String vendorFlowStatus;
	private String vendorBlockStatus;
	
	private String contractType;
	private String contractNo;
	private String contractOldNo;
	
	private String locationId;
	private String locationCode;
	private String locationName;
	
	private String bankCode;
	private String bankName;
	private String bankBranchCode;
	private String bankBranch;
	private String accountNo;
	private String accountName;
	
	private String bookbankStatus;
	private String bookbankFlowStatus;
	
	private String payeeId;
	private String payeeName;
	private String payeeStatus;
	private String payeeFlowStatus;
	private String payeeBankCode;
	private String payeeBankName;
	private String payeeAccountNo;
	private String payeeAccountName;
	
	private String bookbankPayeeStatus;
	private String bookbankPayeeFlowStatus;
	
	private String vendorMapPayeeId;
	
	private String confirmMsg;
	
	@Override
	public String toString() {
		return "Mmm001VendorContractSP [accountName=" + accountName
				+ ", accountNo=" + accountNo + ", bankBranch=" + bankBranch
				+ ", bankBranchCode=" + bankBranchCode + ", bankCode="
				+ bankCode + ", bankName=" + bankName + ", bookbankFlowStatus="
				+ bookbankFlowStatus + ", bookbankPayeeFlowStatus="
				+ bookbankPayeeFlowStatus + ", bookbankPayeeStatus="
				+ bookbankPayeeStatus + ", bookbankStatus=" + bookbankStatus
				+ ", contractNo=" + contractNo + ", contractOldNo="
				+ contractOldNo + ", contractType=" + contractType
				+ ", expenseType=" + expenseType + ", idCard=" + idCard
				+ ", locationCode=" + locationCode + ", locationId="
				+ locationId + ", locationName=" + locationName
				+ ", payeeAccountName=" + payeeAccountName
				+ ", payeeAccountNo=" + payeeAccountNo + ", payeeBankCode="
				+ payeeBankCode + ", payeeBankName=" + payeeBankName
				+ ", payeeFlowStatus=" + payeeFlowStatus + ", payeeId="
				+ payeeId + ", payeeName=" + payeeName + ", payeeStatus="
				+ payeeStatus + ", rowId=" + rowId + ", siteName=" + siteName
				+ ", taxId=" + taxId + ", vendorBlockStatus="
				+ vendorBlockStatus + ", vendorCode=" + vendorCode
				+ ", vendorFlowStatus=" + vendorFlowStatus + ", vendorId="
				+ vendorId + ", vendorMapPayeeId=" + vendorMapPayeeId
				+ ", vendorName=" + vendorName + ", vendorStatus="
				+ vendorStatus + "]";
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
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
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
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
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
	public String getPayeeBankCode() {
		return payeeBankCode;
	}
	public void setPayeeBankCode(String payeeBankCode) {
		this.payeeBankCode = payeeBankCode;
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
	public String getVendorMapPayeeId() {
		return vendorMapPayeeId;
	}
	public void setVendorMapPayeeId(String vendorMapPayeeId) {
		this.vendorMapPayeeId = vendorMapPayeeId;
	}

	public String getConfirmMsg() {
		return confirmMsg;
	}

	public void setConfirmMsg(String confirmMsg) {
		this.confirmMsg = confirmMsg;
	}

}
