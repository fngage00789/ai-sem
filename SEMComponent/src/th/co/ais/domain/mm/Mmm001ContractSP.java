package th.co.ais.domain.mm;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.DateUtil;

public class Mmm001ContractSP extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9083775798460187938L;
	
	private String rowId;
	private String actionType;
	
	private String idCard;
	private String taxId;
	
	private String company;
	
	private String contractType;
	private String contractNo;
	private String contractOldNo;
	
	private String contractStatus;
	private String contractName;
	private String region;
	private String siteName;
	private String siteLocation;
	private String siteType;
	
	private String expenseTypeId;
	private String expenseType;
	
	private String locationId;
	private String locationCode;
	private String locationName;
	
	private String vendorId;
	private String vendorCode;
	private String vendorName;
	private String vendorStatus;
	private String vendorFlowStatus;
	private String vendorBlockStatus;
	
	private String bookbankStatus;
	private String bookbankFlowStatus;
	
	private String payeeId;
	private String payeeName;
	private String payeeStatus;
	private String payeeFlowStatus;
	private String payeeBankName;
	private String payeeAccountNo;
	private String payeeAccountName;
	private String payeeAccountStatus;
	private String payeeAccountFlowStatus;
	
	private String bookbankPayeeStatus;
	private String bookbankPayeeFlowStatus;
	
	private String bankCode;
	private String bankName;
	private String bankBranchCode;
	private String bankBranch;
	
	private String accountNo;
	private String accountName;
	private String accountStatus;
	private String accountFlowStatus;
	
	private String vendorBatch;
	private String bookbankBatch;
	private String payeeBatch;
	private String bookbankPayeeBatch;
	private String remark;
	
	private Date firstEffectiveDt;
	private String firstEffectiveDtStr;
	private Date effectiveDt;
	private String effectiveDtStr;
	private Date expireDt;
	private String expireDtStr;
	
	private String networkStatus;
	private String pendingStatus;
	
	private String ownerName;
	private String contactNo;
	private String contactName;
	private String telephone;
	private String payTypeId;
	private String payType;
	
	private String payeeEffectiveDt;
	private String payeeEffectiveDtStr;
	
	private String vendorEffectiveDtStr;
	private Date vendorEffectiveDt;
	
	private String siteInfoId;
	
	private String vendorMapPayeeId;
	
	
	private String contractNoOld;
	
	private String expenseSelectFlag;
	private String expenseDeleteFlag;
	
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
	public String getBookbankPayeeBatch() {
		return bookbankPayeeBatch;
	}
	public void setBookbankPayeeBatch(String bookbankPayeeBatch) {
		this.bookbankPayeeBatch = bookbankPayeeBatch;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getSiteLocation() {
		return siteLocation;
	}
	public void setSiteLocation(String siteLocation) {
		this.siteLocation = siteLocation;
	}
	public String getSiteType() {
		return siteType;
	}
	public void setSiteType(String siteType) {
		this.siteType = siteType;
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
	public String getNetworkStatus() {
		return networkStatus;
	}
	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
	}
	public String getPendingStatus() {
		return pendingStatus;
	}
	public void setPendingStatus(String pendingStatus) {
		this.pendingStatus = pendingStatus;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
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
	public String getPayTypeId() {
		return payTypeId;
	}
	public void setPayTypeId(String payTypeId) {
		this.payTypeId = payTypeId;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public String getExpenseTypeId() {
		return expenseTypeId;
	}
	public void setExpenseTypeId(String expenseTypeId) {
		this.expenseTypeId = expenseTypeId;
	}
	public String getVendorMapPayeeId() {
		return vendorMapPayeeId;
	}
	public void setVendorMapPayeeId(String vendorMapPayeeId) {
		this.vendorMapPayeeId = vendorMapPayeeId;
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
	public String getVendorEffectiveDtStr() {
		return vendorEffectiveDtStr;
	}
	public void setVendorEffectiveDtStr(String vendorEffectiveDtStr) {
		this.vendorEffectiveDtStr = vendorEffectiveDtStr;
	}
	public Date getVendorEffectiveDt() throws Exception {
		if(vendorEffectiveDtStr != null){
			vendorEffectiveDt = DateUtil.getDate(vendorEffectiveDtStr, DateUtil.SIMPLE_DATE_PATTERN);
		}
		return vendorEffectiveDt;
	}
	public void setVendorEffectiveDt(Date vendorEffectiveDt) {
		this.vendorEffectiveDt = vendorEffectiveDt;
	}
	
	
	public String getContractNoOld() {
		return contractNoOld;
	}
	public void setContractNoOld(String contractNoOld) {
		this.contractNoOld = contractNoOld;
	}
	public String getExpenseSelectFlag() {
		return expenseSelectFlag;
	}
	public void setExpenseSelectFlag(String expenseSelectFlag) {
		this.expenseSelectFlag = expenseSelectFlag;
	}
	public String getExpenseDeleteFlag() {
		return expenseDeleteFlag;
	}
	public void setExpenseDeleteFlag(String expenseDeleteFlag) {
		this.expenseDeleteFlag = expenseDeleteFlag;
	}
	@Override
	public String toString() {
		return "Mmm001ContractSP [accountFlowStatus=" + accountFlowStatus
				+ ", accountName=" + accountName + ", accountNo=" + accountNo
				+ ", accountStatus=" + accountStatus + ", actionType="
				+ actionType + ", bankBranch=" + bankBranch
				+ ", bankBranchCode=" + bankBranchCode + ", bankCode="
				+ bankCode + ", bankName=" + bankName + ", bookbankBatch="
				+ bookbankBatch + ", bookbankFlowStatus=" + bookbankFlowStatus
				+ ", bookbankPayeeBatch=" + bookbankPayeeBatch
				+ ", bookbankPayeeFlowStatus=" + bookbankPayeeFlowStatus
				+ ", bookbankPayeeStatus=" + bookbankPayeeStatus
				+ ", bookbankStatus=" + bookbankStatus + ", company=" + company
				+ ", contactName=" + contactName + ", contactNo=" + contactNo
				+ ", contractName=" + contractName + ", contractNo="
				+ contractNo + ", contractOldNo=" + contractOldNo
				+ ", contractStatus=" + contractStatus + ", contractType="
				+ contractType + ", effectiveDt=" + effectiveDt
				+ ", effectiveDtStr=" + effectiveDtStr + ", expenseType="
				+ expenseType + ", expenseTypeId=" + expenseTypeId
				+ ", expireDt=" + expireDt + ", expireDtStr=" + expireDtStr
				+ ", firstEffectiveDt=" + firstEffectiveDt
				+ ", firstEffectiveDtStr=" + firstEffectiveDtStr + ", idCard="
				+ idCard + ", locationCode=" + locationCode + ", locationId="
				+ locationId + ", locationName=" + locationName
				+ ", networkStatus=" + networkStatus + ", ownerName="
				+ ownerName + ", payType=" + payType + ", payTypeId="
				+ payTypeId + ", payeeAccountFlowStatus="
				+ payeeAccountFlowStatus + ", payeeAccountName="
				+ payeeAccountName + ", payeeAccountNo=" + payeeAccountNo
				+ ", payeeAccountStatus=" + payeeAccountStatus
				+ ", payeeBankName=" + payeeBankName + ", payeeBatch="
				+ payeeBatch + ", payeeEffectiveDt=" + payeeEffectiveDt
				+ ", payeeEffectiveDtStr=" + payeeEffectiveDtStr
				+ ", payeeFlowStatus=" + payeeFlowStatus + ", payeeId="
				+ payeeId + ", payeeName=" + payeeName + ", payeeStatus="
				+ payeeStatus + ", pendingStatus=" + pendingStatus
				+ ", region=" + region + ", remark=" + remark + ", rowId="
				+ rowId + ", siteInfoId=" + siteInfoId + ", siteLocation="
				+ siteLocation + ", siteName=" + siteName + ", siteType="
				+ siteType + ", taxId=" + taxId + ", telephone=" + telephone
				+ ", vendorBatch=" + vendorBatch + ", vendorBlockStatus="
				+ vendorBlockStatus + ", vendorCode=" + vendorCode
				+ ", vendorEffectiveDt=" + vendorEffectiveDt
				+ ", vendorEffectiveDtStr=" + vendorEffectiveDtStr
				+ ", vendorFlowStatus=" + vendorFlowStatus + ", vendorId="
				+ vendorId + ", vendorMapPayeeId=" + vendorMapPayeeId
				+ ", vendorName=" + vendorName + ", vendorStatus="
				+ vendorStatus + "]";
	}
	
	
}
