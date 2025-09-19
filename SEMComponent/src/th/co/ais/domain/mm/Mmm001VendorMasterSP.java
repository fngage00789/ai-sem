package th.co.ais.domain.mm;

import java.util.Arrays;
import java.util.Date;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.DateUtil;

public class Mmm001VendorMasterSP extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2700235325398503704L;
	
	private String rowId;
	private String actionType;
	private String actionState;
	
	private String idCard;
	private String taxId;
	
	private String contractType;
	private String contractNo;
	private String contractOldNo;
	
	private String contractStatus;
	private String contractName;
	private String region;
	private String siteName;
	private String siteLocation;
	private String siteType;
	
	private String expenseType;
	
	private String locationId;
	private String locationCode;
	private String locationName;
	
	private String vendorId;
	private String vendorCode;
	private String vendorName;
	private String vendorStatus;
	private String vendorFlowStatusCode;
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
	private String contactName;
	private String telephone;
	
	private String siteInfoId;
	
	//added by NEW 02/05/2017
	private String vendorBlock;
	private String payeeNo;
	private String payType;
	private String vendorBookbankId;
	private String payeeBookbankId;
	private String systemType;
	private String payeeBookbankStatus;
	private String company;
	private String payeeBookbankFlowStatus;
	private String batchNo;
	private String arrRegion[];
	
	private String teamName;
	private String userName;
	private String result;
	private String bookbank;
	private String vendor;
	private String payee;
	private String bookbankPayee;
	private String bookbankId;
	private String menuUrl;
	private String userId;
	private boolean renderedCheckbox = true;
	
	//added by NEW 17/05/2017
	private boolean btnEditSapRerendered = false;
	
	private String contractFlag;
	
	// for popup convert vendor
	private String vendorCodeOld;
	private String address;
	
	//added by NEW 27/06/2017
	private String vendorMapPayeeId;
	private String bookbankFlowStatusCode;
	private String payeeFlowStatusCode;
	private String bpFlowStatusCode;
	private String vendorType;
	private String payeeType;
	private String siteCode;
	private String payeeCode;
	private String blockStatus;
	private String blackListStatus;
	
	private String vendorEffectiveDtStr;
	private String expenseTypeId;
	private String payTypeId;
	private String expenseEffectiveDtStr;
	
	//addewd by new 24/07/2017
	private String oldContractNo;
	private String clearBatchFlag;
	private String viewSiteInfoId;
	
	private String vendorChange;
	private String bookbankChange;
	private String payeeChange;
	private String payeeBookbankChange;
	
	private Date vendorEffectiveDt;
	private Date contractEffectiveDt;
	private String contractEffectiveDtStr;
	private Date contractExpireDt;
	private String contractExpireDtStr;
	
	private String vendorBlackList;
	
	
	private String actionDetail;
	private String allStatus;
	private String lotNo;
	private String vendorBranchNo;
	
	private String otherStatus;
	private String actionTypeDisplay;
	
	private boolean renderColumn;
	
	private String groupNo; 
	
	private String historyFlag;
	
	private String rowSpan = "0";
	
	private String countGroupNo;
	
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
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getActionState() {
		return actionState;
	}
	public void setActionState(String actionState) {
		this.actionState = actionState;
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
	public String getVendorFlowStatusCode() {
		return vendorFlowStatusCode;
	}
	public void setVendorFlowStatusCode(String vendorFlowStatusCode) {
		this.vendorFlowStatusCode = vendorFlowStatusCode;
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
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	
	public String getVendorBlock() {
		return vendorBlock;
	}
	public void setVendorBlock(String vendorBlock) {
		this.vendorBlock = vendorBlock;
	}
	public String getPayeeNo() {
		return payeeNo;
	}
	public void setPayeeNo(String payeeNo) {
		this.payeeNo = payeeNo;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getVendorBookbankId() {
		return vendorBookbankId;
	}
	public void setVendorBookbankId(String vendorBookbankId) {
		this.vendorBookbankId = vendorBookbankId;
	}
	public String getPayeeBookbankId() {
		return payeeBookbankId;
	}
	public void setPayeeBookbankId(String payeeBookbankId) {
		this.payeeBookbankId = payeeBookbankId;
	}
	public String getSystemType() {
		return systemType;
	}
	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}
	public String getPayeeBookbankStatus() {
		return payeeBookbankStatus;
	}
	public void setPayeeBookbankStatus(String payeeBookbankStatus) {
		this.payeeBookbankStatus = payeeBookbankStatus;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPayeeBookbankFlowStatus() {
		return payeeBookbankFlowStatus;
	}
	public void setPayeeBookbankFlowStatus(String payeeBookbankFlowStatus) {
		this.payeeBookbankFlowStatus = payeeBookbankFlowStatus;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String[] getArrRegion() {
		return arrRegion;
	}
	public void setArrRegion(String[] arrRegion) {
		this.arrRegion = arrRegion;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getBookbank() {
		return bookbank;
	}
	public void setBookbank(String bookbank) {
		this.bookbank = bookbank;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getPayee() {
		return payee;
	}
	public void setPayee(String payee) {
		this.payee = payee;
	}
	public String getBookbankPayee() {
		return bookbankPayee;
	}
	public void setBookbankPayee(String bookbankPayee) {
		this.bookbankPayee = bookbankPayee;
	}
	public String getBookbankId() {
		return bookbankId;
	}
	public void setBookbankId(String bookbankId) {
		this.bookbankId = bookbankId;
	}
	
	public boolean isBtnEditSapRerendered() {
		return btnEditSapRerendered;
	}
	public void setBtnEditSapRerendered(boolean btnEditSapRerendered) {
		this.btnEditSapRerendered = btnEditSapRerendered;
	}
	
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getContractFlag() {
		return contractFlag;
	}
	public void setContractFlag(String contractFlag) {
		this.contractFlag = contractFlag;
	}
	
	public String getVendorCodeOld() {
		return vendorCodeOld;
	}
	public void setVendorCodeOld(String vendorCodeOld) {
		this.vendorCodeOld = vendorCodeOld;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getVendorMapPayeeId() {
		return vendorMapPayeeId;
	}
	public void setVendorMapPayeeId(String vendorMapPayeeId) {
		this.vendorMapPayeeId = vendorMapPayeeId;
	}
	
	public String getBookbankFlowStatusCode() {
		return bookbankFlowStatusCode;
	}
	public void setBookbankFlowStatusCode(String bookbankFlowStatusCode) {
		this.bookbankFlowStatusCode = bookbankFlowStatusCode;
	}
	public String getPayeeFlowStatusCode() {
		return payeeFlowStatusCode;
	}
	public void setPayeeFlowStatusCode(String payeeFlowStatusCode) {
		this.payeeFlowStatusCode = payeeFlowStatusCode;
	}
	public String getBpFlowStatusCode() {
		return bpFlowStatusCode;
	}
	public void setBpFlowStatusCode(String bpFlowStatusCode) {
		this.bpFlowStatusCode = bpFlowStatusCode;
	}
	public boolean isRenderedCheckbox() {
		return renderedCheckbox;
	}
	public void setRenderedCheckbox(boolean renderedCheckbox) {
		this.renderedCheckbox = renderedCheckbox;
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
	public String getOldContractNo() {
		return oldContractNo;
	}
	public void setOldContractNo(String oldContractNo) {
		this.oldContractNo = oldContractNo;
	}
	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	public String getPayeeCode() {
		return payeeCode;
	}
	public void setPayeeCode(String payeeCode) {
		this.payeeCode = payeeCode;
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
	public String getVendorEffectiveDtStr() {
		return vendorEffectiveDtStr;
	}
	public void setVendorEffectiveDtStr(String vendorEffectiveDtStr) {
		this.vendorEffectiveDtStr = vendorEffectiveDtStr;
	}
	public String getExpenseTypeId() {
		return expenseTypeId;
	}
	public void setExpenseTypeId(String expenseTypeId) {
		this.expenseTypeId = expenseTypeId;
	}
	public String getPayTypeId() {
		return payTypeId;
	}
	public void setPayTypeId(String payTypeId) {
		this.payTypeId = payTypeId;
	}
	public String getClearBatchFlag() {
		return clearBatchFlag;
	}
	public void setClearBatchFlag(String clearBatchFlag) {
		this.clearBatchFlag = clearBatchFlag;
	}
	public String getExpenseEffectiveDtStr() {
		return expenseEffectiveDtStr;
	}
	public void setExpenseEffectiveDtStr(String expenseEffectiveDtStr) {
		this.expenseEffectiveDtStr = expenseEffectiveDtStr;
	}
	public String getViewSiteInfoId() {
		return viewSiteInfoId;
	}
	public void setViewSiteInfoId(String viewSiteInfoId) {
		this.viewSiteInfoId = viewSiteInfoId;
	}
	public String getVendorChange() {
		return vendorChange;
	}
	public void setVendorChange(String vendorChange) {
		this.vendorChange = vendorChange;
	}
	public String getBookbankChange() {
		return bookbankChange;
	}
	public void setBookbankChange(String bookbankChange) {
		this.bookbankChange = bookbankChange;
	}
	public String getPayeeChange() {
		return payeeChange;
	}
	public void setPayeeChange(String payeeChange) {
		this.payeeChange = payeeChange;
	}
	public String getPayeeBookbankChange() {
		return payeeBookbankChange;
	}
	public void setPayeeBookbankChange(String payeeBookbankChange) {
		this.payeeBookbankChange = payeeBookbankChange;
	}
	public Date getContractEffectiveDt() {
		return contractEffectiveDt;
	}
	public void setContractEffectiveDt(Date contractEffectiveDt) {
		this.contractEffectiveDt = contractEffectiveDt;
	}
	public String getContractEffectiveDtStr() {
		return contractEffectiveDtStr;
	}
	public void setContractEffectiveDtStr(String contractEffectiveDtStr) {
		this.contractEffectiveDtStr = contractEffectiveDtStr;
	}
	public Date getContractExpireDt() {
		return contractExpireDt;
	}
	public void setContractExpireDt(Date contractExpireDt) {
		this.contractExpireDt = contractExpireDt;
	}
	public String getContractExpireDtStr() {
		return contractExpireDtStr;
	}
	public void setContractExpireDtStr(String contractExpireDtStr) {
		this.contractExpireDtStr = contractExpireDtStr;
	}
	public String getVendorBlackList() {
		return vendorBlackList;
	}
	public void setVendorBlackList(String vendorBlackList) {
		this.vendorBlackList = vendorBlackList;
	}
	public String getActionDetail() {
		return actionDetail;
	}
	public void setActionDetail(String actionDetail) {
		this.actionDetail = actionDetail;
	}
	public String getAllStatus() {
		return allStatus;
	}
	public void setAllStatus(String allStatus) {
		this.allStatus = allStatus;
	}
	public String getLotNo() {
		return lotNo;
	}
	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}
	public Date getVendorEffectiveDt() {
		return vendorEffectiveDt;
	}
	public void setVendorEffectiveDt(Date vendorEffectiveDt) {
		this.vendorEffectiveDt = vendorEffectiveDt;
	}
	public String getVendorBranchNo() {
		return vendorBranchNo;
	}
	public void setVendorBranchNo(String vendorBranchNo) {
		this.vendorBranchNo = vendorBranchNo;
	}
	public String getOtherStatus() {
		return otherStatus;
	}
	public void setOtherStatus(String otherStatus) {
		this.otherStatus = otherStatus;
	}
	public String getActionTypeDisplay() {
		return actionTypeDisplay;
	}
	public void setActionTypeDisplay(String actionTypeDisplay) {
		this.actionTypeDisplay = actionTypeDisplay;
	}
	public boolean isRenderColumn() {
		return renderColumn;
	}
	public void setRenderColumn(boolean renderColumn) {
		this.renderColumn = renderColumn;
	}
	public String getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}
	public String getHistoryFlag() {
		return historyFlag;
	}
	public void setHistoryFlag(String historyFlag) {
		this.historyFlag = historyFlag;
	}
	public String getRowSpan() {
		return rowSpan;
	}
	public void setRowSpan(String rowSpan) {
		this.rowSpan = rowSpan;
	}
	public String getCountGroupNo() {
		return countGroupNo;
	}
	public void setCountGroupNo(String countGroupNo) {
		this.countGroupNo = countGroupNo;
	}
	@Override
	public String toString() {
		return "Mmm001VendorMasterSP [accountFlowStatus=" + accountFlowStatus
				+ ", accountName=" + accountName + ", accountNo=" + accountNo
				+ ", accountStatus=" + accountStatus + ", actionState="
				+ actionState + ", actionType=" + actionType + ", address="
				+ address + ", arrRegion=" + Arrays.toString(arrRegion)
				+ ", bankBranch=" + bankBranch + ", bankBranchCode="
				+ bankBranchCode + ", bankCode=" + bankCode + ", bankName="
				+ bankName + ", batchNo=" + batchNo + ", blackListStatus="
				+ blackListStatus + ", blockStatus=" + blockStatus
				+ ", bookbank=" + bookbank + ", bookbankBatch=" + bookbankBatch
				+ ", bookbankFlowStatus=" + bookbankFlowStatus
				+ ", bookbankFlowStatusCode=" + bookbankFlowStatusCode
				+ ", bookbankId=" + bookbankId + ", bookbankPayee="
				+ bookbankPayee + ", bookbankPayeeBatch=" + bookbankPayeeBatch
				+ ", bookbankPayeeFlowStatus=" + bookbankPayeeFlowStatus
				+ ", bookbankPayeeStatus=" + bookbankPayeeStatus
				+ ", bookbankStatus=" + bookbankStatus + ", bpFlowStatusCode="
				+ bpFlowStatusCode + ", btnEditSapRerendered="
				+ btnEditSapRerendered + ", company=" + company
				+ ", contactName=" + contactName + ", contractFlag="
				+ contractFlag + ", contractName=" + contractName
				+ ", contractNo=" + contractNo + ", contractOldNo="
				+ contractOldNo + ", contractStatus=" + contractStatus
				+ ", contractType=" + contractType + ", effectiveDt="
				+ effectiveDt + ", effectiveDtStr=" + effectiveDtStr
				+ ", expenseType=" + expenseType + ", expireDt=" + expireDt
				+ ", expireDtStr=" + expireDtStr + ", firstEffectiveDt="
				+ firstEffectiveDt + ", firstEffectiveDtStr="
				+ firstEffectiveDtStr + ", idCard=" + idCard
				+ ", locationCode=" + locationCode + ", locationId="
				+ locationId + ", locationName=" + locationName + ", menuUrl="
				+ menuUrl + ", networkStatus=" + networkStatus
				+ ", oldContractNo=" + oldContractNo + ", ownerName="
				+ ownerName + ", payType=" + payType + ", payee=" + payee
				+ ", payeeAccountFlowStatus=" + payeeAccountFlowStatus
				+ ", payeeAccountName=" + payeeAccountName
				+ ", payeeAccountNo=" + payeeAccountNo
				+ ", payeeAccountStatus=" + payeeAccountStatus
				+ ", payeeBankName=" + payeeBankName + ", payeeBatch="
				+ payeeBatch + ", payeeBookbankFlowStatus="
				+ payeeBookbankFlowStatus + ", payeeBookbankId="
				+ payeeBookbankId + ", payeeBookbankStatus="
				+ payeeBookbankStatus + ", payeeCode=" + payeeCode
				+ ", payeeFlowStatus=" + payeeFlowStatus
				+ ", payeeFlowStatusCode=" + payeeFlowStatusCode + ", payeeId="
				+ payeeId + ", payeeName=" + payeeName + ", payeeNo=" + payeeNo
				+ ", payeeStatus=" + payeeStatus + ", payeeType=" + payeeType
				+ ", pendingStatus=" + pendingStatus + ", region=" + region
				+ ", remark=" + remark + ", renderedCheckbox="
				+ renderedCheckbox + ", result=" + result + ", rowId=" + rowId
				+ ", siteCode=" + siteCode + ", siteInfoId=" + siteInfoId
				+ ", siteLocation=" + siteLocation + ", siteName=" + siteName
				+ ", siteType=" + siteType + ", systemType=" + systemType
				+ ", taxId=" + taxId + ", teamName=" + teamName
				+ ", telephone=" + telephone + ", userId=" + userId
				+ ", userName=" + userName + ", vendor=" + vendor
				+ ", vendorBatch=" + vendorBatch + ", vendorBlock="
				+ vendorBlock + ", vendorBlockStatus=" + vendorBlockStatus
				+ ", vendorBookbankId=" + vendorBookbankId + ", vendorCode="
				+ vendorCode + ", vendorCodeOld=" + vendorCodeOld
				+ ", vendorFlowStatus=" + vendorFlowStatus
				+ ", vendorFlowStatusCode=" + vendorFlowStatusCode
				+ ", vendorId=" + vendorId + ", vendorMapPayeeId="
				+ vendorMapPayeeId + ", vendorName=" + vendorName
				+ ", vendorStatus=" + vendorStatus + ", vendorType="
				+ vendorType + "]";
	}
	
	
}
