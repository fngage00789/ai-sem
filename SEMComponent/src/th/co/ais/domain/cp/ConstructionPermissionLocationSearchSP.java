package th.co.ais.domain.cp;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;
 
public class ConstructionPermissionLocationSearchSP extends AbstractDomain{

	private static final long serialVersionUID = 6636113475771022070L;
	

	private String rowId;
	private String siteInfoMapLocId; //SITE_INFO_MAP_LOC_ID
	private String siteInfoId;	//SITE_INFO_ID
	private String seqNo; //SEQ_NO
	private String locationId; //LOCATION_ID	
	private String locationCode;// LOCATION_CODE
	private String locationName; //LOCATION_NAME  
	private String region; //REGION     
	private String stationType; //STATION_TYPE   
	private String networkStatus; //NETWORK_STATUS 
	private String rentAMT; //RENT_AMT
	private String mainLocFlag;  //  MAIN_LOC_FLAG
	
	
	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getSiteInfoMapLocId() {
		return siteInfoMapLocId;
	}
	public void setSiteInfoMapLocId(String siteInfoMapLocId) {
		this.siteInfoMapLocId = siteInfoMapLocId;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public String getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
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
	public String getStationType() {
		return stationType;
	}
	public void setStationType(String stationType) {
		this.stationType = stationType;
	}
	public String getNetworkStatus() {
		return networkStatus;
	}
	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
	}
	public String getRentAMT() {
		return rentAMT;
	}
	public void setRentAMT(String rentAMT) {
		this.rentAMT = rentAMT;
	}
	public String getMainLocFlag() {
		return mainLocFlag;
	}
	public void setMainLocFlag(String mainLocFlag) {
		this.mainLocFlag = mainLocFlag;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getRegion() {
		return region;
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
	
		
}
