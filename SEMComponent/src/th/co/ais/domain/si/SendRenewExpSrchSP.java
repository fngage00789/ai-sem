package th.co.ais.domain.si;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class SendRenewExpSrchSP extends AbstractDomain{

	private static final long serialVersionUID = 6636113475771022070L;
	
	private Boolean selected;
	
	private String rowId;
	private String contractNo;
	private String siteName;
	private Date firstEffDt;
	private Date effDt;
	private Date expDt;
	private Double rentAmt;
	private String locationId;
	private String locationCode;
	private String networkStatus;
	private String sendRenewType;
	private String company;
	private Date contractStartDt;
	private Date contractEndDt;
	private String contractNoEndFlag;
	private Integer contractEndMonth;
	private String region;
	private String siteStatus;
	private String flowStatus;
	private String siteAds;
	private String siteType;
	private Date expireDtFrom;
	private Date expireDtTo;
	private String approveStatusDesc;
	
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
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
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
	public Date getFirstEffDt() {
		return firstEffDt;
	}
	public void setFirstEffDt(Date firstEffDt) {
		this.firstEffDt = firstEffDt;
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
	public String getSendRenewType() {
		return sendRenewType;
	}
	public void setSendRenewType(String sendRenewType) {
		this.sendRenewType = sendRenewType;
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
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCompany() {
		return company;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getRegion() {
		return region;
	}
	public void setRentAmt(Double rentAmt) {
		this.rentAmt = rentAmt;
	}
	public Double getRentAmt() {
		return rentAmt;
	}
	public Integer getContractEndMonth() {
		return contractEndMonth;
	}
	public void setContractEndMonth(Integer contractEndMonth) {
		this.contractEndMonth = contractEndMonth;
	}
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
	public Boolean getSelected() {
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
	public void setApproveStatusDesc(String approveStatusDesc) {
		this.approveStatusDesc = approveStatusDesc;
	}
	public String getApproveStatusDesc() {
		return approveStatusDesc;
	}
	public String getSiteStatus() {
		return siteStatus;
	}
	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}
	public String getFlowStatus() {
		return flowStatus;
	}
	public void setFlowStatus(String flowStatus) {
		this.flowStatus = flowStatus;
	}
	public String getSiteAds() {
		return siteAds;
	}
	public void setSiteAds(String siteAds) {
		this.siteAds = siteAds;
	}
	
}
