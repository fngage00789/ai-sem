package th.co.ais.domain.gm;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class VendorMasterSP extends AbstractDomain {
	
	protected String rowId;
	protected String vendorCode;
	protected String vendorName;
	protected String vendorName1;
	protected String idCard;
	protected String taxId;
	protected String contractNo;
	protected String siteName;
	protected String recordStatus;
	protected String bankAccNo;
	protected String bankAccName;
	protected String vendorStatus;
	protected String bookBankStatus;
	protected String vendorPayeeStatus;
	protected String bookBankPayeeStatus;
	protected String remark;
	protected String vendorType;
	protected String address;
	protected String vendorMasterId;
	
	protected String payeeName;
	protected String expenseTypeDesc;
	
	protected String contractNoDesc;
	protected String expenseType;
	
	protected String tax13;
	
	protected String payeeStatus;
	protected String payeeBookBankStatus;
	protected String region;
	protected String company;
	protected String picoFlagStr;
	protected boolean picoFlag;
	protected String vendorMapPayeeId;
	protected String color;
	private String hqFlag;
	private String branchNo;
	private String pResult;
	private String pMessageCode;
	private String pHqFlag;
	private String pBranchNo;
	private String branchId;
	//added by NEW 2015/06/02
	private String payeeMasterId;
	private String payeeCode;
	private String batchNo;
	private String lotNo;
	private String status;
	private String payeeAddress;
	private Date createDT;
	private String approveBy;
	private Date approveDT;
	private String bankAccType;
	private String bankAccCode;
	private String bankName;
	private String bankBranch;
	private String newBankFlag;
	private String recordStatusDesc;
	private String siteInfoId;
	private String exportFlag;
	private String createDtStr;
	private String approveDtStr;
	private String userId;
	private String province;
	private String provinceCode;
	private String amphur;
	private String amphurCode;
	private String district;
	private String districtCode;
	private String payeeTypeDesc;
	private String vendorIdCard;
	private String vendorBookbankStatus;
	private String payeeBankName;
	private String payeeBankNo;
	private boolean renderedChkSelect = true;
	private String expanseType; 
	
	private String bookbankBatchNo;
	private String payeeBatchNo;
	private String payeeBookbankBatchNo;
	
	protected String vendorCodeOld;
	
	private String approveStatus;
	
	private String retResult;
	private String retMessage;
	private String fileName;
	
	//added by NEW
	private boolean renderedVendorRejectPopup = false;
	private boolean renderedVendorBookbankRejectPopup = false;
	private boolean renderedPayeeRejectPopup = false;
	private boolean renderedPayeeBookbankRejectPopup = false;
	
	private String city;
	private String telephone;
	private String mobileNo;
	private String postCode;
	private String strCreateDt;
	private String strUpdateDt;
	
	private String strParam;
	
	//20151111 added by NEW
	private String actionType;
	private String reqType;
	private String payeeBankAccNo;
	private String payeeBankAccName;
 	
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
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

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	

	public String getBankAccNo() {
		return bankAccNo;
	}

	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}

	public String getBankAccName() {
		return bankAccName;
	}

	public void setBankAccName(String bankAccName) {
		this.bankAccName = bankAccName;
	}
	
	public String getVendorStatus() {
		return vendorStatus;
	}

	public void setVendorStatus(String vendorStatus) {
		this.vendorStatus = vendorStatus;
	}

	public String getBookBankStatus() {
		return bookBankStatus;
	}

	public void setBookBankStatus(String bookBankStatus) {
		this.bookBankStatus = bookBankStatus;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getVendorType() {
		return vendorType;
	}

	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getVendorMasterId() {
		return vendorMasterId;
	}

	public void setVendorMasterId(String vendorMasterId) {
		this.vendorMasterId = vendorMasterId;
	}

	public String getVendorName1() {
		return vendorName1;
	}

	public void setVendorName1(String vendorName1) {
		this.vendorName1 = vendorName1;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getExpenseTypeDesc() {
		return expenseTypeDesc;
	}

	public void setExpenseTypeDesc(String expenseTypeDesc) {
		this.expenseTypeDesc = expenseTypeDesc;
	}
	
	public String getContractNoDesc() {
		return contractNoDesc;
	}

	public void setContractNoDesc(String contractNoDesc) {
		this.contractNoDesc = contractNoDesc;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getTax13() {
		return tax13;
	}

	public void setTax13(String tax13) {
		this.tax13 = tax13;
	}

	public String getPayeeStatus() {
		return payeeStatus;
	}

	public void setPayeeStatus(String payeeStatus) {
		this.payeeStatus = payeeStatus;
	}

	public String getPayeeBookBankStatus() {
		return payeeBookBankStatus;
	}

	public void setPayeeBookBankStatus(String payeeBookBankStatus) {
		this.payeeBookBankStatus = payeeBookBankStatus;
	}

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

	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPicoFlagStr() {
		return picoFlagStr;
	}

	public void setPicoFlagStr(String picoFlagStr) {
		this.picoFlagStr = picoFlagStr;
	}

	public boolean isPicoFlag() {
		return picoFlag;
	}

	public void setPicoFlag(boolean picoFlag) {
		this.picoFlag = picoFlag;
	}

	public String getVendorMapPayeeId() {
		return vendorMapPayeeId;
	}

	public void setVendorMapPayeeId(String vendorMapPayeeId) {
		this.vendorMapPayeeId = vendorMapPayeeId;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "VendorMasterSP [address=" + address + ", bankAccName="
				+ bankAccName + ", bankAccNo=" + bankAccNo
				+ ", bookBankStatus=" + bookBankStatus + ", contractNo="
				+ contractNo + ", idCard=" + idCard + ", recordStatus="
				+ recordStatus + ", remark=" + remark + ", rowId=" + rowId
				+ ", siteName=" + siteName + ", taxId=" + taxId
				+ ", vendorCode=" + vendorCode + ", vendorMasterId="
				+ vendorMasterId + ", vendorName=" + vendorName
				+ ", vendorName1=" + vendorName1 + ", vendorStatus="
				+ vendorStatus + ", vendorType=" + vendorType + "]";
	}

	public String getHqFlag() {
		return hqFlag;
	}

	public void setHqFlag(String hqFlag) {
		this.hqFlag = hqFlag;
	}

	public String getBranchNo() {
		return branchNo;
	}

	public void setBranchNo(String branchNo) {
		this.branchNo = branchNo;
	}

	public String getpResult() {
		return pResult;
	}

	public void setpResult(String pResult) {
		this.pResult = pResult;
	}

	public String getpMessageCode() {
		return pMessageCode;
	}

	public void setpMessageCode(String pMessageCode) {
		this.pMessageCode = pMessageCode;
	}

	public String getpHqFlag() {
		return pHqFlag;
	}

	public void setpHqFlag(String pHqFlag) {
		this.pHqFlag = pHqFlag;
	}

	public String getpBranchNo() {
		return pBranchNo;
	}

	public void setpBranchNo(String pBranchNo) {
		this.pBranchNo = pBranchNo;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getPayeeMasterId() {
		return payeeMasterId;
	}

	public void setPayeeMasterId(String payeeMasterId) {
		this.payeeMasterId = payeeMasterId;
	}

	public String getPayeeCode() {
		return payeeCode;
	}

	public void setPayeeCode(String payeeCode) {
		this.payeeCode = payeeCode;
	}

	public String getVendorPayeeStatus() {
		return vendorPayeeStatus;
	}

	public void setVendorPayeeStatus(String vendorPayeeStatus) {
		this.vendorPayeeStatus = vendorPayeeStatus;
	}

	public String getBookBankPayeeStatus() {
		return bookBankPayeeStatus;
	}

	public void setBookBankPayeeStatus(String bookBankPayeeStatus) {
		this.bookBankPayeeStatus = bookBankPayeeStatus;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getLotNo() {
		return lotNo;
	}

	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayeeAddress() {
		return payeeAddress;
	}

	public void setPayeeAddress(String payeeAddress) {
		this.payeeAddress = payeeAddress;
	}

	public Date getCreateDT() {
		return createDT;
	}

	public void setCreateDT(Date createDT) {
		this.createDT = createDT;
	}

	public String getApproveBy() {
		return approveBy;
	}

	public void setApproveBy(String approveBy) {
		this.approveBy = approveBy;
	}

	public Date getApproveDT() {
		return approveDT;
	}

	public void setApproveDT(Date approveDT) {
		this.approveDT = approveDT;
	}

	public String getBankAccType() {
		return bankAccType;
	}

	public void setBankAccType(String bankAccType) {
		this.bankAccType = bankAccType;
	}

	public String getBankAccCode() {
		return bankAccCode;
	}

	public void setBankAccCode(String bankAccCode) {
		this.bankAccCode = bankAccCode;
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

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getNewBankFlag() {
		return newBankFlag;
	}

	public void setNewBankFlag(String newBankFlag) {
		this.newBankFlag = newBankFlag;
	}

	public String getRecordStatusDesc() {
		return recordStatusDesc;
	}

	public void setRecordStatusDesc(String recordStatusDesc) {
		this.recordStatusDesc = recordStatusDesc;
	}

	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	public String getExportFlag() {
		return exportFlag;
	}

	public void setExportFlag(String exportFlag) {
		this.exportFlag = exportFlag;
	}

	public String getCreateDtStr() {
		return createDtStr;
	}

	public void setCreateDtStr(String createDtStr) {
		this.createDtStr = createDtStr;
	}

	public String getApproveDtStr() {
		return approveDtStr;
	}

	public void setApproveDtStr(String approveDtStr) {
		this.approveDtStr = approveDtStr;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getAmphur() {
		return amphur;
	}

	public void setAmphur(String amphur) {
		this.amphur = amphur;
	}

	public String getAmphurCode() {
		return amphurCode;
	}

	public void setAmphurCode(String amphurCode) {
		this.amphurCode = amphurCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getPayeeTypeDesc() {
		return payeeTypeDesc;
	}

	public void setPayeeTypeDesc(String payeeTypeDesc) {
		this.payeeTypeDesc = payeeTypeDesc;
	}

	public String getVendorIdCard() {
		return vendorIdCard;
	}

	public void setVendorIdCard(String vendorIdCard) {
		this.vendorIdCard = vendorIdCard;
	}

	public String getVendorBookbankStatus() {
		return vendorBookbankStatus;
	}

	public void setVendorBookbankStatus(String vendorBookbankStatus) {
		this.vendorBookbankStatus = vendorBookbankStatus;
	}

	public String getPayeeBankName() {
		return payeeBankName;
	}

	public void setPayeeBankName(String payeeBankName) {
		this.payeeBankName = payeeBankName;
	}

	public String getPayeeBankNo() {
		return payeeBankNo;
	}

	public void setPayeeBankNo(String payeeBankNo) {
		this.payeeBankNo = payeeBankNo;
	}

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public boolean isRenderedChkSelect() {
		return renderedChkSelect;
	}

	public void setRenderedChkSelect(boolean renderedChkSelect) {
		this.renderedChkSelect = renderedChkSelect;
	}

	public String getExpanseType() {
		return expanseType;
	}

	public void setExpanseType(String expanseType) {
		this.expanseType = expanseType;
	}

	public String getVendorCodeOld() {
		return vendorCodeOld;
	}

	public void setVendorCodeOld(String vendorCodeOld) {
		this.vendorCodeOld = vendorCodeOld;
	}

	public String getBookbankBatchNo() {
		return bookbankBatchNo;
	}

	public void setBookbankBatchNo(String bookbankBatchNo) {
		this.bookbankBatchNo = bookbankBatchNo;
	}

	public String getPayeeBatchNo() {
		return payeeBatchNo;
	}

	public void setPayeeBatchNo(String payeeBatchNo) {
		this.payeeBatchNo = payeeBatchNo;
	}

	public String getPayeeBookbankBatchNo() {
		return payeeBookbankBatchNo;
	}

	public void setPayeeBookbankBatchNo(String payeeBookbankBatchNo) {
		this.payeeBookbankBatchNo = payeeBookbankBatchNo;
	}

	public String getRetResult() {
		return retResult;
	}

	public void setRetResult(String retResult) {
		this.retResult = retResult;
	}

	public String getRetMessage() {
		return retMessage;
	}

	public void setRetMessage(String retMessage) {
		this.retMessage = retMessage;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public boolean isRenderedVendorRejectPopup() {
		return renderedVendorRejectPopup;
	}

	public void setRenderedVendorRejectPopup(boolean renderedVendorRejectPopup) {
		this.renderedVendorRejectPopup = renderedVendorRejectPopup;
	}

	public boolean isRenderedVendorBookbankRejectPopup() {
		return renderedVendorBookbankRejectPopup;
	}

	public void setRenderedVendorBookbankRejectPopup(
			boolean renderedVendorBookbankRejectPopup) {
		this.renderedVendorBookbankRejectPopup = renderedVendorBookbankRejectPopup;
	}

	public boolean isRenderedPayeeRejectPopup() {
		return renderedPayeeRejectPopup;
	}

	public void setRenderedPayeeRejectPopup(boolean renderedPayeeRejectPopup) {
		this.renderedPayeeRejectPopup = renderedPayeeRejectPopup;
	}

	public boolean isRenderedPayeeBookbankRejectPopup() {
		return renderedPayeeBookbankRejectPopup;
	}

	public void setRenderedPayeeBookbankRejectPopup(
			boolean renderedPayeeBookbankRejectPopup) {
		this.renderedPayeeBookbankRejectPopup = renderedPayeeBookbankRejectPopup;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getStrCreateDt() {
		return strCreateDt;
	}

	public void setStrCreateDt(String strCreateDt) {
		this.strCreateDt = strCreateDt;
	}

	public String getStrUpdateDt() {
		return strUpdateDt;
	}

	public void setStrUpdateDt(String strUpdateDt) {
		this.strUpdateDt = strUpdateDt;
	}

	public String getStrParam() {
		return strParam;
	}

	public void setStrParam(String strParam) {
		this.strParam = strParam;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public String getPayeeBankAccNo() {
		return payeeBankAccNo;
	}

	public void setPayeeBankAccNo(String payeeBankAccNo) {
		this.payeeBankAccNo = payeeBankAccNo;
	}

	public String getPayeeBankAccName() {
		return payeeBankAccName;
	}

	public void setPayeeBankAccName(String payeeBankAccName) {
		this.payeeBankAccName = payeeBankAccName;
	}

	
	
}
