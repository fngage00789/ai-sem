package th.co.ais.domain.si;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class ApproveRenewSearchSP extends AbstractDomain{

	private boolean selected;
	private String rowId;
	private String renewAgeCode;
	private String renewAgeDesc;
	private String contractNo;
	private String siteName;
	private String locationId;
	private String locationCode;
	private String networkStatus;
	private String address;
	private Date effDt;
	private Date expDt;
	private String sendRenewType;
	private String approveStatus;
	private String sendRenewStatus;
	private Date sendRenewDt;
	private Date approveDt;
	private Date approveBackDt;
	private Date sendRenewBackDt;
	private String company;
	private Date contractStartDt;
	private Date contractEndDt;
	private String contractNoEndFlag;
	private String zone;
	private Date sendRenewDtFrom;
	private Date sendRenewDtTo;
	private Date approveBackDtFrom;
	private Date approveBackDtTo;
	private String remark;
	
	private String region;
	private String siteType;
	private Date expireDtFrom;
	private Date expireDtTo;
	private String approveStatusDesc;
	
	private String flowStatus;
	private String siteStatus;
	
	private String effDtStr;
	private String expDtStr;
	private String approveBackDtStr;
	private String sendRenewBackDtStr;
	
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
	public String getRenewAgeCode() {
		return renewAgeCode;
	}
	public void setRenewAgeCode(String renewAgeCode) {
		this.renewAgeCode = renewAgeCode;
	}
	public String getRenewAgeDesc() {
		return renewAgeDesc;
	}
	public void setRenewAgeDesc(String renewAgeDesc) {
		this.renewAgeDesc = renewAgeDesc;
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
	public String getNetworkStatus() {
		return networkStatus;
	}
	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getEffDt() {
		return effDt;
	}
	public void setEffDt(Date effDt) {
		this.effDt = effDt;
	}
	public Date getExpDt() {
		return expDt;
	}
	public void setExpDt(Date expDt) {
		this.expDt = expDt;
	}
	public String getSendRenewType() {
		return sendRenewType;
	}
	public void setSendRenewType(String sendRenewType) {
		this.sendRenewType = sendRenewType;
	}
	public String getApproveStatus() {
		return approveStatus;
	}
	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}
	public String getSendRenewStatus() {
		return sendRenewStatus;
	}
	public void setSendRenewStatus(String sendRenewStatus) {
		this.sendRenewStatus = sendRenewStatus;
	}
	public Date getSendRenewDt() {
		return sendRenewDt;
	}
	public void setSendRenewDt(Date sendRenewDt) {
		this.sendRenewDt = sendRenewDt;
	}
	public Date getApproveBackDt() {
		return approveBackDt;
	}
	public void setApproveBackDt(Date approveBackDt) {
		this.approveBackDt = approveBackDt;
	}
	public Date getSendRenewBackDt() {
		return sendRenewBackDt;
	}
	public void setSendRenewBackDt(Date sendRenewBackDt) {
		this.sendRenewBackDt = sendRenewBackDt;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Date getContractStartDt() {
		return contractStartDt;
	}
	public void setContractStartDt(Date contractStartDt) {
		this.contractStartDt = contractStartDt;
	}
	public Date getContractEndDt() {
		return contractEndDt;
	}
	public void setContractEndDt(Date contractEndDt) {
		this.contractEndDt = contractEndDt;
	}
	public String getContractNoEndFlag() {
		return contractNoEndFlag;
	}
	public void setContractNoEndFlag(String contractNoEndFlag) {
		this.contractNoEndFlag = contractNoEndFlag;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public Date getSendRenewDtFrom() {
		return sendRenewDtFrom;
	}
	public void setSendRenewDtFrom(Date sendRenewDtFrom) {
		this.sendRenewDtFrom = sendRenewDtFrom;
	}
	public Date getSendRenewDtTo() {
		return sendRenewDtTo;
	}
	public void setSendRenewDtTo(Date sendRenewDtTo) {
		this.sendRenewDtTo = sendRenewDtTo;
	}
	public Date getApproveBackDtFrom() {
		return approveBackDtFrom;
	}
	public void setApproveBackDtFrom(Date approveBackDtFrom) {
		this.approveBackDtFrom = approveBackDtFrom;
	}
	public Date getApproveBackDtTo() {
		return approveBackDtTo;
	}
	public void setApproveBackDtTo(Date approveBackDtTo) {
		this.approveBackDtTo = approveBackDtTo;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRemark() {
		return remark;
	}
	public void setApproveDt(Date approveDt) {
		this.approveDt = approveDt;
	}
	public Date getApproveDt() {
		return approveDt;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public boolean getSelected() {
		return selected;
	}
	public String getSiteType() {
		return siteType;
	}
	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}
	public Date getExpireDtFrom() {
		return expireDtFrom;
	}
	public void setExpireDtFrom(Date expireDtFrom) {
		this.expireDtFrom = expireDtFrom;
	}
	public Date getExpireDtTo() {
		return expireDtTo;
	}
	public void setExpireDtTo(Date expireDtTo) {
		this.expireDtTo = expireDtTo;
	}
	/**
	 * @param approveStatusDesc the approveStatusDesc to set
	 */
	public void setApproveStatusDesc(String approveStatusDesc) {
		this.approveStatusDesc = approveStatusDesc;
	}
	/**
	 * @return the approveStatusDesc
	 */
	public String getApproveStatusDesc() {
		return approveStatusDesc;
	}
	public String getFlowStatus() {
		return flowStatus;
	}
	public void setFlowStatus(String flowStatus) {
		this.flowStatus = flowStatus;
	}
	public String getSiteStatus() {
		return siteStatus;
	}
	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getEffDtStr() {
		return effDtStr;
	}
	public void setEffDtStr(String effDtStr) {
		this.effDtStr = effDtStr;
	}
	public String getExpDtStr() {
		return expDtStr;
	}
	public void setExpDtStr(String expDtStr) {
		this.expDtStr = expDtStr;
	}
	public String getApproveBackDtStr() {
		return approveBackDtStr;
	}
	public void setApproveBackDtStr(String approveBackDtStr) {
		this.approveBackDtStr = approveBackDtStr;
	}
	public String getSendRenewBackDtStr() {
		return sendRenewBackDtStr;
	}
	public void setSendRenewBackDtStr(String sendRenewBackDtStr) {
		this.sendRenewBackDtStr = sendRenewBackDtStr;
	}
}
