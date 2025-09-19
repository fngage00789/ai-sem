package th.co.ais.domain.sa;

import java.math.BigDecimal;
import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class SiteAppSiteSP extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String rowId;
	private String siteAppSiteId;
	private String siteAppId;
	private String siteId;
	private String siteCode;
	private String siteDetail;
	private String siteGroup;
	private String siteType;
	private String siteNameTh;
	
	private String recordStatus;

	private String version;
	private String locationId;
	
	private String system;
	private String stationType;
	private String company;
	private String remark;
	
	private String checkType;
	
	//popup
	private String locationCode;
	private String locationName;
	private String siteName;
	private String updateBy;
	private Date updateDT;
	private String updateDTStr;
	
	private String towerType;
	private String towerLocation;
	private BigDecimal towerHeight;
    
	private String region;
	private String activityType;
	private String contractNoInfo;
    
    //added by NEW 2016/11/20
	private String locationZone;
	private String reLocateContractNo;
	private String phase;
	
	//added by NEW 06/22/2018
	private String locationStatus;
	private String siteActivity;
	private String action;
	private String slimStatus;
	private String networkStatus;
	private String contractInfo;
	private String contractStatus;
	private String liveNetwork;
	private String serviceId;
	
	private String mainLocalFlag;
	private String newFlag;
	private String locationSlims;
	
	
	public String getSiteAppSiteId() {
		return siteAppSiteId;
	}

	public void setSiteAppSiteId(String siteAppSiteId) {
		this.siteAppSiteId = siteAppSiteId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSiteAppId() {
		return siteAppId;
	}

	public void setSiteAppId(String siteAppId) {
		this.siteAppId = siteAppId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getSiteDetail() {
		return siteDetail;
	}

	public void setSiteDetail(String siteDetail) {
		this.siteDetail = siteDetail;
	}

	public String getSiteGroup() {
		return siteGroup;
	}

	public void setSiteGroup(String siteGroup) {
		this.siteGroup = siteGroup;
	}

	public String getSiteType() {
		return siteType;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	public String getSiteNameTh() {
		return siteNameTh;
	}

	public void setSiteNameTh(String siteNameTh) {
		this.siteNameTh = siteNameTh;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getStationType() {
		return stationType;
	}

	public void setStationType(String stationType) {
		this.stationType = stationType;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCheckType() {
		return checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
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

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public Date getUpdateDT() {
		return updateDT;
	}

	public void setUpdateDT(Date updateDT) {
		this.updateDT = updateDT;
	}

	public String getUpdateDTStr() {
		return updateDTStr;
	}

	public void setUpdateDTStr(String updateDTStr) {
		this.updateDTStr = updateDTStr;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getTowerType() {
		return towerType;
	}

	public void setTowerType(String towerType) {
		this.towerType = towerType;
	}

	public String getTowerLocation() {
		return towerLocation;
	}

	public void setTowerLocation(String towerLocation) {
		this.towerLocation = towerLocation;
	}

	public BigDecimal getTowerHeight() {
		return towerHeight;
	}

	public void setTowerHeight(BigDecimal towerHeight) {
		this.towerHeight = towerHeight;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getContractNoInfo() {
		return contractNoInfo;
	}

	public void setContractNoInfo(String contractNoInfo) {
		this.contractNoInfo = contractNoInfo;
	}

	public String getLocationZone() {
		return locationZone;
	}

	public void setLocationZone(String locationZone) {
		this.locationZone = locationZone;
	}

	public String getReLocateContractNo() {
		return reLocateContractNo;
	}

	public void setReLocateContractNo(String reLocateContractNo) {
		this.reLocateContractNo = reLocateContractNo;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getLocationStatus() {
		return locationStatus;
	}

	public void setLocationStatus(String locationStatus) {
		this.locationStatus = locationStatus;
	}

	public String getSiteActivity() {
		return siteActivity;
	}

	public void setSiteActivity(String siteActivity) {
		this.siteActivity = siteActivity;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getSlimStatus() {
		return slimStatus;
	}

	public void setSlimStatus(String slimStatus) {
		this.slimStatus = slimStatus;
	}

	public String getNetworkStatus() {
		return networkStatus;
	}

	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
	}

	public String getContractInfo() {
		return contractInfo;
	}

	public void setContractInfo(String contractInfo) {
		this.contractInfo = contractInfo;
	}

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	public String getLiveNetwork() {
		return liveNetwork;
	}

	public void setLiveNetwork(String liveNetwork) {
		this.liveNetwork = liveNetwork;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getMainLocalFlag() {
		return mainLocalFlag;
	}

	public void setMainLocalFlag(String mainLocalFlag) {
		this.mainLocalFlag = mainLocalFlag;
	}

	public String getNewFlag() {
		return newFlag;
	}

	public void setNewFlag(String newFlag) {
		this.newFlag = newFlag;
	}

	public String getLocationSlims() {
		return locationSlims;
	}

	public void setLocationSlims(String locationSlims) {
		this.locationSlims = locationSlims;
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

}
