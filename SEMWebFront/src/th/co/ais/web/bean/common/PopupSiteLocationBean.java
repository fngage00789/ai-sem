package th.co.ais.web.bean.common;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.si.SiteLocationSP;
import th.co.ais.web.bean.AbstractBean;

public class PopupSiteLocationBean extends AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3096785486904375152L;

	private SiteLocationSP siteLocationCriteria;
	private List<SiteLocationSP> siteLocationList;
	String locationId;
	String locationCode;
	String locationName;
	String region;
	String contractNo;
	String stationType;
	String networkStatus;
	private String province;
	private String address;
	private boolean selected;
	private int rowPerPage = 10;
	// 20110110 For page site approve call popup, Add by Ming
	private boolean pageSiteApprove;
	
	private boolean renderPopup = false;
	
	private String locationStatus;
	private String siteGroup;
	private String system;
	private String locStationType;
	private String company;
	private String siteCode;
	private String siteName;
	private String siteActivity;
	private String towerType;
	private String towerLocation;
	private Integer towerHeight;
	private String zoneDecription;
	private String locationZone;
	private String reLocate;
	private String phase;
	private String locationType;
	private String locAddressNo;
	private String locBuilding;
	private String locFloor;
	private String locStreet;
	private String tumbol;
	private String amphur;
	private String zipCode;
	private String siteId;
	private String locRoomNo;
	
	private List<SelectItem> locationList;
	private List<SelectItem> provinceList;
	private List<SelectItem> amphurList;
	
	public boolean isPageSiteApprove() {
		return pageSiteApprove;
	}
	public void setPageSiteApprove(boolean pageSiteApprove) {
		this.pageSiteApprove = pageSiteApprove;
	}
	public SiteLocationSP getSiteLocationCriteria() {
		return siteLocationCriteria;
	}
	public void setSiteLocationCriteria(SiteLocationSP siteLocationCriteria) {
		this.siteLocationCriteria = siteLocationCriteria;
	}
	public List<SiteLocationSP> getSiteLocationList() {
		return siteLocationList;
	}
	public void setSiteLocationList(List<SiteLocationSP> siteLocationList) {
		this.siteLocationList = siteLocationList;
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
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getStationType() {
		return stationType;
	}
	public void setStationType(String stationType) {
		this.stationType = stationType;
	}
	public boolean isRenderPopup() {
		return renderPopup;
	}
	public void setRenderPopup(boolean renderPopup) {
		this.renderPopup = renderPopup;
	}
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public String getNetworkStatus() {
		return networkStatus;
	}
	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
	}
	public String getLocationStatus() {
		return locationStatus;
	}
	public void setLocationStatus(String locationStatus) {
		this.locationStatus = locationStatus;
	}
	public String getSiteGroup() {
		return siteGroup;
	}
	public void setSiteGroup(String siteGroup) {
		this.siteGroup = siteGroup;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public String getLocStationType() {
		return locStationType;
	}
	public void setLocStationType(String locStationType) {
		this.locStationType = locStationType;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getSiteActivity() {
		return siteActivity;
	}
	public void setSiteActivity(String siteActivity) {
		this.siteActivity = siteActivity;
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
	public Integer getTowerHeight() {
		return towerHeight;
	}
	public void setTowerHeight(Integer towerHeight) {
		this.towerHeight = towerHeight;
	}
	public String getZoneDecription() {
		return zoneDecription;
	}
	public void setZoneDecription(String zoneDecription) {
		this.zoneDecription = zoneDecription;
	}
	public String getReLocate() {
		return reLocate;
	}
	public void setReLocate(String reLocate) {
		this.reLocate = reLocate;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public String getLocationType() {
		return locationType;
	}
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
	public String getLocAddressNo() {
		return locAddressNo;
	}
	public void setLocAddressNo(String locAddressNo) {
		this.locAddressNo = locAddressNo;
	}
	public String getLocBuilding() {
		return locBuilding;
	}
	public void setLocBuilding(String locBuilding) {
		this.locBuilding = locBuilding;
	}
	public String getLocFloor() {
		return locFloor;
	}
	public void setLocFloor(String locFloor) {
		this.locFloor = locFloor;
	}
	public String getLocStreet() {
		return locStreet;
	}
	public void setLocStreet(String locStreet) {
		this.locStreet = locStreet;
	}
	public String getTumbol() {
		return tumbol;
	}
	public void setTumbol(String tumbol) {
		this.tumbol = tumbol;
	}
	public String getAmphur() {
		return amphur;
	}
	public void setAmphur(String amphur) {
		this.amphur = amphur;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getLocationZone() {
		return locationZone;
	}
	public void setLocationZone(String locationZone) {
		this.locationZone = locationZone;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String getLocRoomNo() {
		return locRoomNo;
	}
	public void setLocRoomNo(String locRoomNo) {
		this.locRoomNo = locRoomNo;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public List<SelectItem> getLocationList() {
		return locationList;
	}
	public void setLocationList(List<SelectItem> locationList) {
		this.locationList = locationList;
	}
	public List<SelectItem> getProvinceList() {
		return provinceList;
	}
	public void setProvinceList(List<SelectItem> provinceList) {
		this.provinceList = provinceList;
	}
	public List<SelectItem> getAmphurList() {
		return amphurList;
	}
	public void setAmphurList(List<SelectItem> amphurList) {
		this.amphurList = amphurList;
	}
	
}
