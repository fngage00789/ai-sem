package th.co.ais.domain.mm;

import java.util.Arrays;
import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mmm002ContractSP extends AbstractDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8910504301410302376L;
	
	private String rowId;
	private String company;
	private String region;
	private String arrRegion[];
	private String systemType;
	private String contractType;
	
	private String locationId;
	private String locationCode;
	private String vendorCode;
	private String vendorName;
	private String vendorType;
	private String idCard;
	private String taxId;
	private String contractNo;
	private String bankName;
	private String siteName;
	private String siteAddress;
	private String bankBranch;
	private String accountNo;
	private String accountName;
	private String expenseType;
	private String batchNo;
	private String vendorStatus;
	private String vendorFlowStatus;
	private String bookbankStatus;
	private String bookbankFlowStatus;
	private String payeeId;
	private String payeeStatus;
	private String payeeFlowStatus;
	private String payeeBookbankStatus;
	private String payeeBookbankFlowStatus;
	
	private String contractOldNo;
	private String locationName;
	private String vendorBlock;
	private String payeeName;
	private String payeeBankName;
	private String payeeAccountNo;
	private String payeeAccountName;
	
	private String vendorBatch;
	private String bookbankBatch;
	private String payeeBatch;
	private String bookbanPayeekBatch;
	private String remark;
	
	private Date firstEffectiveDt;
	private String firstEffectiveDtStr;
	private Date effectiveDt;
	private String effectiveDtStr;
	private Date expireDt;
	private String expireDtStr;
	private Date bookbankEffectiveDt;
	private String bookbankEffectiveDtStr;
	
	private String networkStatus;
	private String contractStatus;
	private String ownerName;
	private String lessorName;
	private String contactName;
	private String telephone;
	private String pendingStatus;
	
	private String blockFlag;
	
	private String accountType;
	private String bankCode;
	private String province;
	private String activeStatus;
	
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
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String[] getArrRegion() {
		return arrRegion;
	}
	public void setArrRegion(String[] arrRegion) {
		this.arrRegion = arrRegion;
	}
	public String getSystemType() {
		return systemType;
	}
	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
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
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
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
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
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
	public String getPayeeBookbankStatus() {
		return payeeBookbankStatus;
	}
	public void setPayeeBookbankStatus(String payeeBookbankStatus) {
		this.payeeBookbankStatus = payeeBookbankStatus;
	}
	public String getPayeeBookbankFlowStatus() {
		return payeeBookbankFlowStatus;
	}
	public void setPayeeBookbankFlowStatus(String payeeBookbankFlowStatus) {
		this.payeeBookbankFlowStatus = payeeBookbankFlowStatus;
	}
	public String getContractOldNo() {
		return contractOldNo;
	}
	public void setContractOldNo(String contractOldNo) {
		this.contractOldNo = contractOldNo;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getVendorBlock() {
		return vendorBlock;
	}
	public void setVendorBlock(String vendorBlock) {
		this.vendorBlock = vendorBlock;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
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
	public String getVendorBatch() {
		return vendorBatch;
	}
	public void setVendorBatch(String vendorBatch) {
		this.vendorBatch = vendorBatch;
	}
	public String getBookbankBatch() {
		return bookbankBatch;
	}
	public void setBookbankBatch(String bookbankBatch) {
		this.bookbankBatch = bookbankBatch;
	}
	public String getPayeeBatch() {
		return payeeBatch;
	}
	public void setPayeeBatch(String payeeBatch) {
		this.payeeBatch = payeeBatch;
	}
	public String getBookbanPayeekBatch() {
		return bookbanPayeekBatch;
	}
	public void setBookbanPayeekBatch(String bookbanPayeekBatch) {
		this.bookbanPayeekBatch = bookbanPayeekBatch;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSiteAddress() {
		return siteAddress;
	}
	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
	}
	public Date getFirstEffectiveDt() {
		return firstEffectiveDt;
	}
	public void setFirstEffectiveDt(Date firstEffectiveDt) {
		this.firstEffectiveDt = firstEffectiveDt;
	}
	public Date getEffectiveDt() {
		return effectiveDt;
	}
	public void setEffectiveDt(Date effectiveDt) {
		this.effectiveDt = effectiveDt;
	}
	public Date getExpireDt() {
		return expireDt;
	}
	public void setExpireDt(Date expireDt) {
		this.expireDt = expireDt;
	}
	public String getFirstEffectiveDtStr() {
		return firstEffectiveDtStr;
	}
	public void setFirstEffectiveDtStr(String firstEffectiveDtStr) {
		this.firstEffectiveDtStr = firstEffectiveDtStr;
	}
	public String getEffectiveDtStr() {
		return effectiveDtStr;
	}
	public void setEffectiveDtStr(String effectiveDtStr) {
		this.effectiveDtStr = effectiveDtStr;
	}
	public String getExpireDtStr() {
		return expireDtStr;
	}
	public void setExpireDtStr(String expireDtStr) {
		this.expireDtStr = expireDtStr;
	}
	public Date getBookbankEffectiveDt() {
		return bookbankEffectiveDt;
	}
	public void setBookbankEffectiveDt(Date bookbankEffectiveDt) {
		this.bookbankEffectiveDt = bookbankEffectiveDt;
	}
	public String getBookbankEffectiveDtStr() {
		return bookbankEffectiveDtStr;
	}
	public void setBookbankEffectiveDtStr(String bookbankEffectiveDtStr) {
		this.bookbankEffectiveDtStr = bookbankEffectiveDtStr;
	}
	public String getNetworkStatus() {
		return networkStatus;
	}
	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
	}
	public String getContractStatus() {
		return contractStatus;
	}
	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getLessorName() {
		return lessorName;
	}
	public void setLessorName(String lessorName) {
		this.lessorName = lessorName;
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
	public String getPendingStatus() {
		return pendingStatus;
	}
	public void setPendingStatus(String pendingStatus) {
		this.pendingStatus = pendingStatus;
	}
	public String getBlockFlag() {
		return blockFlag;
	}
	public void setBlockFlag(String blockFlag) {
		this.blockFlag = blockFlag;
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
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	
	@Override
	public String toString() {
		return "Mmm002ContractSP [accountName=" + accountName + ", accountNo=" + accountNo + ", accountType=" + accountType + ", activeStatus=" + activeStatus + ", arrRegion=" + Arrays.toString(arrRegion) + ", bankBranch=" + bankBranch + ", bankCode=" + bankCode + ", bankName=" + bankName + ", batchNo=" + batchNo + ", blockFlag=" + blockFlag + ", bookbanPayeekBatch=" + bookbanPayeekBatch + ", bookbankBatch=" + bookbankBatch + ", bookbankEffectiveDt=" + bookbankEffectiveDt + ", bookbankEffectiveDtStr=" + bookbankEffectiveDtStr + ", bookbankFlowStatus=" + bookbankFlowStatus + ", bookbankStatus=" + bookbankStatus + ", company=" + company + ", contactName=" + contactName + ", contractNo=" + contractNo + ", contractOldNo=" + contractOldNo + ", contractStatus=" + contractStatus + ", contractType=" + contractType + ", effectiveDt=" + effectiveDt + ", effectiveDtStr="
				+ effectiveDtStr + ", expenseType=" + expenseType + ", expireDt=" + expireDt + ", expireDtStr=" + expireDtStr + ", firstEffectiveDt=" + firstEffectiveDt + ", firstEffectiveDtStr=" + firstEffectiveDtStr + ", idCard=" + idCard + ", lessorName=" + lessorName + ", locationCode=" + locationCode + ", locationId=" + locationId + ", locationName=" + locationName + ", networkStatus=" + networkStatus + ", ownerName=" + ownerName + ", payeeAccountName=" + payeeAccountName + ", payeeAccountNo=" + payeeAccountNo + ", payeeBankName=" + payeeBankName + ", payeeBatch=" + payeeBatch + ", payeeBookbankFlowStatus=" + payeeBookbankFlowStatus + ", payeeBookbankStatus=" + payeeBookbankStatus + ", payeeFlowStatus=" + payeeFlowStatus + ", payeeId=" + payeeId + ", payeeName=" + payeeName + ", payeeStatus=" + payeeStatus + ", pendingStatus=" + pendingStatus + ", province="
				+ province + ", region=" + region + ", remark=" + remark + ", rowId=" + rowId + ", siteAddress=" + siteAddress + ", siteName=" + siteName + ", systemType=" + systemType + ", taxId=" + taxId + ", telephone=" + telephone + ", vendorBatch=" + vendorBatch + ", vendorBlock=" + vendorBlock + ", vendorCode=" + vendorCode + ", vendorFlowStatus=" + vendorFlowStatus + ", vendorName=" + vendorName + ", vendorStatus=" + vendorStatus + ", vendorType=" + vendorType + "]";
	}
	
}
