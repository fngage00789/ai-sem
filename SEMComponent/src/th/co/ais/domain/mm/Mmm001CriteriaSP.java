package th.co.ais.domain.mm;

import java.util.Arrays;
import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mmm001CriteriaSP extends AbstractDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8560295643908736143L;
	 
	private String rowId;
	private String company;
	private String region;
	private String arrRegion[];
	private String systemType;
	private String contractType;
	
	private String expenseType;
	private String batchNo;
	private String vendorCode;
	private String vendorName;
	private String payeeId;
	private String payeeCode;
	private String payeeName;
	private String idCard;
	private String taxId;
	private String contractNo;
	private String siteName;
	private String locationId;
	private String locationCode;
	
	private String bankCode;
	private String bankName;
	private String bankBranchCode;
	private String bankBranch;
	private String accountNo;
	private String accountName;
	
	private String vendorStatus;
	private String vendorFlowStatus;
	private String bookbankStatus;
	private String bookbankFlowStatus;
	private String payeeStatus;
	private String payeeFlowStatus;
	private String bookbankPayeeId;
	private String bookbankPayeeStatus;
	private String bookbankPayeeFlowStatus;
	
	private String vendorId;
	private String vendorBookbankId;
	private String bookbankId;
	
	private String saveFlag;
	private String vendorBranchNo;
	
	private String contractName;
	
	private String vendorMapPayeeId;
	
	//added by NEW 16/05/2016
	private String pageFlag;
	private String menuGroup;
	private String strParam;
	private String createById;
	private String groupType;
	private String payeeBookbankId;
	
	private String contractFlag; // A=Active, T=Terminate
	
	private String userLogin;
	private String userRole;
	private String historyPage;
	
	//added by NEW 2017/07/21
	private String siteCode;
	private String vendorType;
	private String payeeType;
	private String blockStatus;
	private String blackListStatus;
	
	private String currentFlag;
	
	private String paymentType;
	
	private String dummyFlag;
	
	private String noExportBatch;
	
	private String lessorId;
	
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
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
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
	public String getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	public String getBankBranchCode() {
		return bankBranchCode;
	}
	public void setBankBranchCode(String bankBranchCode) {
		this.bankBranchCode = bankBranchCode;
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
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorBookbankId() {
		return vendorBookbankId;
	}
	public void setVendorBookbankId(String vendorBookbankId) {
		this.vendorBookbankId = vendorBookbankId;
	}
	public String getBookbankId() {
		return bookbankId;
	}
	public void setBookbankId(String bookbankId) {
		this.bookbankId = bookbankId;
	}
	public String getSaveFlag() {
		return saveFlag;
	}
	public void setSaveFlag(String saveFlag) {
		this.saveFlag = saveFlag;
	}
	public String getVendorBranchNo() {
		return vendorBranchNo;
	}
	public void setVendorBranchNo(String vendorBranchNo) {
		this.vendorBranchNo = vendorBranchNo;
	}
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public String getVendorMapPayeeId() {
		return vendorMapPayeeId;
	}
	public void setVendorMapPayeeId(String vendorMapPayeeId) {
		this.vendorMapPayeeId = vendorMapPayeeId;
	}
	public String getPageFlag() {
		return pageFlag;
	}
	public void setPageFlag(String pageFlag) {
		this.pageFlag = pageFlag;
	}
	public String getMenuGroup() {
		return menuGroup;
	}
	public void setMenuGroup(String menuGroup) {
		this.menuGroup = menuGroup;
	}
	public String getStrParam() {
		return strParam;
	}
	public void setStrParam(String strParam) {
		this.strParam = strParam;
	}
	public String getCreateById() {
		return createById;
	}
	public void setCreateById(String createById) {
		this.createById = createById;
	}
	
	public String getGroupType() {
		return groupType;
	}
	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}
	
	public String getPayeeBookbankId() {
		return payeeBookbankId;
	}
	public void setPayeeBookbankId(String payeeBookbankId) {
		this.payeeBookbankId = payeeBookbankId;
	}
	public String getContractFlag() {
		return contractFlag;
	}
	public void setContractFlag(String contractFlag) {
		this.contractFlag = contractFlag;
	}
	
	
	public String getHistoryPage() {
		return historyPage;
	}
	public void setHistoryPage(String historyPage) {
		this.historyPage = historyPage;
	}
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	
	public String getBlockStatus() {
		return blockStatus;
	}
	public void setBlockStatus(String blockStatus) {
		this.blockStatus = blockStatus;
	}
	public String getBlackListStatus() {
		return blackListStatus;
	}
	public void setBlackListStatus(String blackListStatus) {
		this.blackListStatus = blackListStatus;
	}
	public String getVendorType() {
		return vendorType;
	}
	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}
	public String getPayeeType() {
		return payeeType;
	}
	public void setPayeeType(String payeeType) {
		this.payeeType = payeeType;
	}
	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	public String getCurrentFlag() {
		return currentFlag;
	}
	public void setCurrentFlag(String currentFlag) {
		this.currentFlag = currentFlag;
	}
	
	
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getDummyFlag() {
		return dummyFlag;
	}
	public void setDummyFlag(String dummyFlag) {
		this.dummyFlag = dummyFlag;
	}
	public String getNoExportBatch() {
		return noExportBatch;
	}
	public void setNoExportBatch(String noExportBatch) {
		this.noExportBatch = noExportBatch;
	}
	public String getLessorId() {
		return lessorId;
	}
	public void setLessorId(String lessorId) {
		this.lessorId = lessorId;
	}
	@Override
	public String toString() {
		return "Mmm001CriteriaSP [accountName=" + accountName + ", accountNo="
				+ accountNo + ", arrRegion=" + Arrays.toString(arrRegion)
				+ ", bankBranch=" + bankBranch + ", bankBranchCode="
				+ bankBranchCode + ", bankCode=" + bankCode + ", bankName="
				+ bankName + ", batchNo=" + batchNo + ", blackListStatus="
				+ blackListStatus + ", blockStatus=" + blockStatus
				+ ", bookbankFlowStatus=" + bookbankFlowStatus
				+ ", bookbankId=" + bookbankId + ", bookbankPayeeFlowStatus="
				+ bookbankPayeeFlowStatus + ", bookbankPayeeId="
				+ bookbankPayeeId + ", bookbankPayeeStatus="
				+ bookbankPayeeStatus + ", bookbankStatus=" + bookbankStatus
				+ ", company=" + company + ", contractFlag=" + contractFlag
				+ ", contractName=" + contractName + ", contractNo="
				+ contractNo + ", contractType=" + contractType
				+ ", createById=" + createById + ", currentFlag=" + currentFlag
				+ ", expenseType=" + expenseType + ", groupType=" + groupType
				+ ", historyPage=" + historyPage + ", idCard=" + idCard
				+ ", locationCode=" + locationCode + ", locationId="
				+ locationId + ", menuGroup=" + menuGroup + ", pageFlag="
				+ pageFlag + ", payeeBookbankId=" + payeeBookbankId
				+ ", payeeCode=" + payeeCode + ", payeeFlowStatus="
				+ payeeFlowStatus + ", payeeId=" + payeeId + ", payeeName="
				+ payeeName + ", payeeStatus=" + payeeStatus + ", payeeType="
				+ payeeType + ", region=" + region + ", rowId=" + rowId
				+ ", saveFlag=" + saveFlag + ", siteCode=" + siteCode
				+ ", siteName=" + siteName + ", strParam=" + strParam
				+ ", systemType=" + systemType + ", taxId=" + taxId
				+ ", userLogin=" + userLogin + ", userRole=" + userRole
				+ ", vendorBookbankId=" + vendorBookbankId
				+ ", vendorBranchNo=" + vendorBranchNo + ", vendorCode="
				+ vendorCode + ", vendorFlowStatus=" + vendorFlowStatus
				+ ", vendorId=" + vendorId + ", vendorMapPayeeId="
				+ vendorMapPayeeId + ", vendorName=" + vendorName
				+ ", vendorStatus=" + vendorStatus + ", vendorType="
				+ vendorType + "]";
	}
	
	
}
