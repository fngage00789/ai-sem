package th.co.ais.domain.rt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class VerifyRentalSearchSiteInfoSP extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2262244069754672107L;
	
	private String siteInfoId;
	private String siteName;
	private String contractNo;
	private String region;
	private Date effDate;
	private Date expireDate;
	private Date pendingDate;
	private Date terminateDt;
	
	private String strEffDate;
	private String strExpireDate;
	
	private String reqTypeName;
	private String title;
	private String verifyStatus;
	private String verifyStatusName;
	private String siteLessorId;
	private String lessorName;
	private String vendorMasterId;
	private String vendorCode;
	private String vendorName;
	private String vendorStatus;
	private String vendorStatusName;
	private String payeeName;
	private String siteLastFlag;
	private String assignSiteInfoId;
	private String siteSeqNo;
	private String rentalMasterId;
	private String rentalLastestFlag;
	private String condType;
	private String rentCondType;
	private String depositCondType;
	private String rentalJobStatus;
	private String rentalJobStatusName;
	private String expenseType;
	private String progressStatus;
	
	private String company;
	private String siteType;
	private String reqType;
	private String noVendorCode;
	private String currentFlag;
	private String picoFlag;
	private String viewFlag;
	
	private String pendingDateStr;
	private String createDtStr;
	private String updateDtStr;
	
	private boolean chkNoVendorId;
	private boolean chkPico;
	private boolean renderColumn;
	private boolean renderSave;
	
	private String remark;
	private boolean specialFlag = false;
	private String specialFlagStr;
	private String oldContractNo;
	private String oldSiteInfoId;
	private String locationId;
	private Double cycleNo;
	private Double seqNo;
	private String siteStatusName;
	private String networkStatus;
	
	private String effDateStr;
	private String expireDateStr;	
	private String terminateDtStr;
	
	// 2015/01/26 added by.. YUT
	private String strParam;
	
	private String vendorId;
	
	public String getViewFlag() {
		return viewFlag;
	}
	public void setViewFlag(String viewFlag) {
		this.viewFlag = viewFlag;
	}
	public String getProgressStatus() {
		return progressStatus;
	}
	public void setProgressStatus(String progressStatus) {
		this.progressStatus = progressStatus;
	}
	public String getCondType() {
		return condType;
	}
	public void setCondType(String condType) {
		this.condType = condType;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getPicoFlag() {
		return picoFlag;
	}
	public void setPicoFlag(String picoFlag) {
		this.picoFlag = picoFlag;
	}
	public boolean isChkPico() {
		return chkPico;
	}
	public void setChkPico(boolean chkPico) {
		this.chkPico = chkPico;
	}
	public String getVendorStatusName() {
		return vendorStatusName;
	}
	public void setVendorStatusName(String vendorStatusName) {
		this.vendorStatusName = vendorStatusName;
	}
	public String getVendorStatus() {
		return vendorStatus;
	}
	public void setVendorStatus(String vendorStatus) {
		this.vendorStatus = vendorStatus;
	}
	public Date getPendingDate() {
		return pendingDate;
	}
	public void setPendingDate(Date pendingDate) {
		this.pendingDate = pendingDate;
	}
	public String getPendingDateStr() {
		return pendingDateStr;
	}
	public void setPendingDateStr(String pendingDateStr) {
		this.pendingDateStr = pendingDateStr;
	}
	public boolean isRenderSave() {
		return renderSave;
	}
	public void setRenderSave(boolean renderSave) {
		this.renderSave = renderSave;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public boolean isRenderColumn() {
		return renderColumn;
	}
	public void setRenderColumn(boolean renderColumn) {
		this.renderColumn = renderColumn;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Date getEffDate() {
		return effDate;
	}
	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	public String getReqTypeName() {
		return reqTypeName;
	}
	public void setReqTypeName(String reqTypeName) {
		this.reqTypeName = reqTypeName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getVerifyStatus() {
		return verifyStatus;
	}
	public void setVerifyStatus(String verifyStatus) {
		this.verifyStatus = verifyStatus;
	}
	public String getVerifyStatusName() {
		return verifyStatusName;
	}
	public void setVerifyStatusName(String verifyStatusName) {
		this.verifyStatusName = verifyStatusName;
	}
	public String getLessorName() {
		return lessorName;
	}
	public void setLessorName(String lessorName) {
		this.lessorName = lessorName;
	}
	public String getVendorMasterId() {
		return vendorMasterId;
	}
	public void setVendorMasterId(String vendorMasterId) {
		this.vendorMasterId = vendorMasterId;
	}
	public String getSiteLastFlag() {
		return siteLastFlag;
	}
	public void setSiteLastFlag(String siteLastFlag) {
		this.siteLastFlag = siteLastFlag;
	}
	public String getAssignSiteInfoId() {
		return assignSiteInfoId;
	}
	public void setAssignSiteInfoId(String assignSiteInfoId) {
		this.assignSiteInfoId = assignSiteInfoId;
	}
	public String getSiteSeqNo() {
		return siteSeqNo;
	}
	public void setSiteSeqNo(String siteSeqNo) {
		this.siteSeqNo = siteSeqNo;
	}
	public String getRentalMasterId() {
		return rentalMasterId;
	}
	public void setRentalMasterId(String rentalMasterId) {
		this.rentalMasterId = rentalMasterId;
	}
	public String getRentalLastestFlag() {
		return rentalLastestFlag;
	}
	public void setRentalLastestFlag(String rentalLastestFlag) {
		this.rentalLastestFlag = rentalLastestFlag;
	}
	public String getVendorCode() {
		return vendorCode;
	}
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	public String getSiteLessorId() {
		return siteLessorId;
	}
	public void setSiteLessorId(String siteLessorId) {
		this.siteLessorId = siteLessorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public String getRentCondType() {
		return rentCondType;
	}
	public void setRentCondType(String rentCondType) {
		this.rentCondType = rentCondType;
	}
	public String getDepositCondType() {
		return depositCondType;
	}
	public void setDepositCondType(String depositCondType) {
		this.depositCondType = depositCondType;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getSiteType() {
		return siteType;
	}
	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}
	public String getReqType() {
		return reqType;
	}
	public void setReqType(String reqType) {
		this.reqType = reqType;
	}
	public String getNoVendorCode() {
		return noVendorCode;
	}
	public void setNoVendorCode(String noVendorCode) {
		this.noVendorCode = noVendorCode;
	}
	public String getCurrentFlag() {
		return currentFlag;
	}
	public void setCurrentFlag(String currentFlag) {
		this.currentFlag = currentFlag;
	}
	public boolean isChkNoVendorId() {
		return chkNoVendorId;
	}
	public void setChkNoVendorId(boolean chkNoVendorId) {
		this.chkNoVendorId = chkNoVendorId;
	}
	public String getRentalJobStatus() {
		return rentalJobStatus;
	}
	public void setRentalJobStatus(String rentalJobStatus) {
		this.rentalJobStatus = rentalJobStatus;
	}
	public String getRentalJobStatusName() {
		return rentalJobStatusName;
	}
	public void setRentalJobStatusName(String rentalJobStatusName) {
		this.rentalJobStatusName = rentalJobStatusName;
	}
	public String getCreateDtStr() {
		return createDtStr;
	}
	public void setCreateDtStr(String createDtStr) {
		this.createDtStr = createDtStr;
	}
	public String getUpdateDtStr() {
		return updateDtStr;
	}
	public void setUpdateDtStr(String updateDtStr) {
		this.updateDtStr = updateDtStr;
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
	public String getStrEffDate() {
		return strEffDate;
	}
	public void setStrEffDate(String strEffDate) {
		this.strEffDate = strEffDate;
	}
	public String getStrExpireDate() {
		return strExpireDate;
	}
	public void setStrExpireDate(String strExpireDate) {
		this.strExpireDate = strExpireDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public boolean isSpecialFlag() {
		return specialFlag;
	}
	public void setSpecialFlag(boolean specialFlag) {
		this.specialFlag = specialFlag;
	}
	public String getSpecialFlagStr() {
		return specialFlagStr;
	}
	public void setSpecialFlagStr(String specialFlagStr) {
		this.specialFlagStr = specialFlagStr;
	}
	public String getOldContractNo() {
		return oldContractNo;
	}
	public void setOldContractNo(String oldContractNo) {
		this.oldContractNo = oldContractNo;
	}
	public String getOldSiteInfoId() {
		return oldSiteInfoId;
	}
	public void setOldSiteInfoId(String oldSiteInfoId) {
		this.oldSiteInfoId = oldSiteInfoId;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getSiteStatusName() {
		return siteStatusName;
	}
	public void setSiteStatusName(String siteStatusName) {
		this.siteStatusName = siteStatusName;
	}
	public String getNetworkStatus() {
		return networkStatus;
	}
	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
	}
	public String getEffDateStr() {
		return effDateStr;
	}
	public void setEffDateStr(String effDateStr) {
		this.effDateStr = effDateStr;
	}
	public String getExpireDateStr() {
		return expireDateStr;
	}
	public void setExpireDateStr(String expireDateStr) {
		this.expireDateStr = expireDateStr;
	}
	public Double getCycleNo() {
		return cycleNo;
	}
	public void setCycleNo(Double cycleNo) {
		this.cycleNo = cycleNo;
	}
	public Double getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(Double seqNo) {
		this.seqNo = seqNo;
	}
	public Date getTerminateDt() {
		return terminateDt;
	}
	public void setTerminateDt(Date terminateDt) {
		this.terminateDt = terminateDt;
	}
	public String getTerminateDtStr() {
		return terminateDtStr;
	}
	public void setTerminateDtStr(String terminateDtStr) {
		this.terminateDtStr = terminateDtStr;
	}
	
	public String getStrParam() {
		return strParam;
	}
	public void setStrParam(String strParam) {
		this.strParam = strParam;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	
}
