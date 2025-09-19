package th.co.ais.domain.si;

import java.util.Date;

import javax.persistence.Transient;
import javax.persistence.criteria.CriteriaBuilder.In;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.annotation.PCell;

public class QuerySiteInfoSearchSP extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7535174118754166309L;

	private Integer rowID;
	private String siteInfoId;
	private String company;
	private String region;
	private String zone;
	private String contractNo;
	private String oldContractNo;
	private String locationId;
	private String locationCode;
	private String siteName;
	private String siteTypeName;
	private String address;
	private Date effectDate;
	private Date expireDate;
	private Double rentAmt;
	private Double serviceAmt;
	private String electrictType;
	private String electrictOwner;
	private String siteStatusName;
	private String networkStatus;
	
	
	private String siteType;
	private String pico;

	private Date fromEffectDt;
	private Date toEffectDt;
	private Date fromExpireDt;
	private Date toExpireDt;
	private String noExpire;
	private String siteStatus;
	private String pending;
	private String expire;
	private boolean noExpireBoolean;
	private boolean pendingBoolean;
	private boolean expireBoolean;
	private String ownerName;
	private String lessorName;
	private String houseNo;
	private String buildingName;
	private String street;
	private String tambon;
	private String amphur;
	private String province;
	private Integer No;
	private String effDt;
	private String expDt;
	private String RntAmount;
	private String ServAmount;
	private String reqType; //Add By Noom
	private String title;
	private String siteInfoStatus;
	
	private String provinceLocation;
	private String tambolLocation;
	private String locationLocation;
	private String amphurLocation;
//	private String lessorName;
	
	
	@PCell(cellType = String.class ,no = 0, manualStyleName = "rt003Field")
	public Integer getNo() {
		return No;
	}

	public void setNo(Integer no) {
		No = no;
	}

	@Transient
	public Integer getRowID() {
		return rowID;
	}

	public void setRowID(Integer rowID) {
		this.rowID = rowID;
	}
	@Transient
	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	@PCell(cellType = String.class ,no = 1, manualStyleName = "rt003Field")
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@PCell(cellType = String.class ,no = 2, manualStyleName = "rt003Field" )
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	@PCell(cellType = String.class ,no = 3, manualStyleName = "rt003Field")
	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}
	@PCell(cellType = String.class ,no = 4, manualStyleName = "rt003Field")
	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	@PCell(cellType = String.class ,no = 5, manualStyleName = "rt003Field")
	public String getOldContractNo() {
		return oldContractNo;
	}

	public void setOldContractNo(String oldContractNo) {
		this.oldContractNo = oldContractNo;
	}
	@PCell(cellType = String.class ,no = 7, manualStyleName = "rt003Field")
	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	@PCell(cellType = String.class ,no = 8, manualStyleName = "rt003Field")
	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	@PCell(cellType = String.class ,no = 6, manualStyleName = "rt003Field")
	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	@PCell(cellType = String.class ,no = 9, manualStyleName = "rt003Field")
	public String getSiteTypeName() {
		return siteTypeName;
	}

	public void setSiteTypeName(String siteTypeName) {
		this.siteTypeName = siteTypeName;
	}
	@PCell(cellType = String.class ,no = 10, manualStyleName = "rt003Field")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@PCell(cellType = Date.class ,no = 11, manualStyleName="si003Field")
	public Date getEffectDate() {
		return effectDate;
	}

	public void setEffectDate(Date effectDate) {
		this.effectDate = effectDate;
	}
	@PCell(cellType = Date.class ,no = 12, manualStyleName="si003Field")
	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	@PCell(cellType = Double.class ,no = 15, manualStyleName="rt003FieldMoney")
	public Double getRentAmt() {
		return rentAmt;
	}

	public void setRentAmt(Double rentAmt) {
		this.rentAmt = rentAmt;
	}
	@PCell(cellType = Double.class ,no = 16, manualStyleName="rt003FieldMoney")
	public Double getServiceAmt() {
		return serviceAmt;
	}

	public void setServiceAmt(Double serviceAmt) {
		this.serviceAmt = serviceAmt;
	}
	@PCell(cellType = String.class ,no = 17, manualStyleName = "rt003Field")
	public String getElectrictType() {
		return electrictType;
	}

	public void setElectrictType(String electrictType) {
		this.electrictType = electrictType;
	}
	@PCell(cellType = String.class ,no = 18, manualStyleName = "rt003Field")
	public String getElectrictOwner() {
		return electrictOwner;
	}

	public void setElectrictOwner(String electrictOwner) {
		this.electrictOwner = electrictOwner;
	}
	@PCell(cellType = String.class ,no = 19, manualStyleName = "rt003Field")
	public String getSiteStatusName() {
		return siteStatusName;
	}

	public void setSiteStatusName(String siteStatusName) {
		this.siteStatusName = siteStatusName;
	}
	@PCell(cellType = String.class ,no = 20, manualStyleName = "rt003Field")
	public String getNetworkStatus() {
		return networkStatus;
	}

	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
	}
	
	public String getSiteType() {
		return siteType;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}
	
	public String getPico() {
		return pico;
	}

	public void setPico(String pico) {
		this.pico = pico;
	}
	
	public Date getFromEffectDt() {
		return fromEffectDt;
	}

	public void setFromEffectDt(Date fromEffectDt) {
		this.fromEffectDt = fromEffectDt;
	}
	
	public Date getToEffectDt() {
		return toEffectDt;
	}

	public void setToEffectDt(Date toEffectDt) {
		this.toEffectDt = toEffectDt;
	}
	
	public Date getFromExpireDt() {
		return fromExpireDt;
	}

	public void setFromExpireDt(Date fromExpireDt) {
		this.fromExpireDt = fromExpireDt;
	}
	
	public Date getToExpireDt() {
		return toExpireDt;
	}

	public void setToExpireDt(Date toExpireDt) {
		this.toExpireDt = toExpireDt;
	}
	
	public String getNoExpire() {
		return noExpire;
	}

	public void setNoExpire(String noExpire) {
		this.noExpire = noExpire;
	}
	
	public String getSiteStatus() {
		return siteStatus;
	}

	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}
	
	public String getPending() {
		return pending;
	}

	public void setPending(String pending) {
		this.pending = pending;
	}
	
	public String getExpire() {
		return expire;
	}

	public void setExpire(String expire) {
		this.expire = expire;
	}
	@PCell(cellType = String.class ,no = 13, manualStyleName = "rt003Field")
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	@PCell(cellType = String.class ,no = 14, manualStyleName = "rt003Field")
	public String getLessorName() {
		return lessorName;
	}

	public void setLessorName(String lessorName) {
		this.lessorName = lessorName;
	}
	
	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	
	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getTambon() {
		return tambon;
	}

	public void setTambon(String tambon) {
		this.tambon = tambon;
	}
	
	public String getAmphur() {
		return amphur;
	}

	public void setAmphur(String amphur) {
		this.amphur = amphur;
	}
	
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getEffDt() {
		return effDt;
	}

	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	public String getExpDt() {
		return expDt;
	}

	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}

	public String getRntAmount() {
		return RntAmount;
	}

	public void setRntAmount(String rntAmount) {
		RntAmount = rntAmount;
	}

	public String getServAmount() {
		return ServAmount;
	}

	public void setServAmount(String servAmount) {
		ServAmount = servAmount;
	}

	@Override
	public String getCreateBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getCreateDt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUpdateBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getUpdateDt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCreateBy(String createBy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCreateDt(Date createDt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUpdateBy(String updateBy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUpdateDt(Date updateDt) {
		// TODO Auto-generated method stub
		
	}

	public Object getDataObj() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSiteInfoStatus() {
		return siteInfoStatus;
	}

	public void setSiteInfoStatus(String siteInfoStatus) {
		this.siteInfoStatus = siteInfoStatus;
	}

	public String getProvinceLocation() {
		return provinceLocation;
	}

	public void setProvinceLocation(String provinceLocation) {
		this.provinceLocation = provinceLocation;
	}

	public String getTambolLocation() {
		return tambolLocation;
	}

	public void setTambolLocation(String tambolLocation) {
		this.tambolLocation = tambolLocation;
	}

	public String getLocationLocation() {
		return locationLocation;
	}

	public void setLocationLocation(String locationLocation) {
		this.locationLocation = locationLocation;
	}

	public String getAmphurLocation() {
		return amphurLocation;
	}

	public void setAmphurLocation(String amphurLocation) {
		this.amphurLocation = amphurLocation;
	}

	public boolean isNoExpireBoolean() {
		return noExpireBoolean;
	}

	public void setNoExpireBoolean(boolean noExpireBoolean) {
		this.noExpireBoolean = noExpireBoolean;
	}

	public boolean isPendingBoolean() {
		return pendingBoolean;
	}

	public void setPendingBoolean(boolean pendingBoolean) {
		this.pendingBoolean = pendingBoolean;
	}

	public boolean isExpireBoolean() {
		return expireBoolean;
	}

	public void setExpireBoolean(boolean expireBoolean) {
		this.expireBoolean = expireBoolean;
	}

	
	
}
