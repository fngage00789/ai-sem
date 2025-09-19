package th.co.ais.domain.si;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;

@Entity
@Table(name="SEM_SI_SITE_INFO_MAP_LOC", schema="SEM")
public class SiteInfoMapLoc extends AbstractDomain {

	// Fields
	private static final long serialVersionUID = 3420142273567791761L;
	private String rowId;
	private String siteInfoId;
	private String locationId;
	private Double rentAmt;
	private String mainLocFlag;
	private String recordStatus;
	private Integer seqNo;
	private Long version;
	private String siteId;
	private String siteCode;
	private String system;
	private String towerType;
	private String towerLocation;
	private Integer towerHeight;
	private String locationCode;
	private String locationName;
	private String zoneDescription;
	private String locationType;
	private String locAddressNo;
	private String locBuilding;
	private String locationFloor;
	private String locationStreet;
	private String locaTumbol;
	private String locAmphur;
	private String locProvince;
	private String locZipCode;
	private String zone;
	private String reLocate;

    @Id
   	@GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "SITE_INFO_MAP_LOC_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "SITE_INFO_ID", length = 20)
	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	@Column(name = "LOCATION_ID", length = 20)
	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	@Column(name = "RENT_AMT", precision = 15)
	public Double getRentAmt() {
		if(rentAmt != null && rentAmt == 0.00){
			return null;
		}
		return rentAmt;
	}

	public void setRentAmt(Double rentAmt) {
		this.rentAmt = rentAmt;
	}

	@Column(name = "MAIN_LOC_FLAG", length = 1)
	public String getMainLocFlag() {
		return mainLocFlag;
	}

	public void setMainLocFlag(String mainLocFlag) {
		this.mainLocFlag = mainLocFlag;
	}


	@Column(name = "RECORD_STATUS", nullable = false, length = 1)
	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	@Column(name = "SEQ_NO", precision = 22, scale = 0)
	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	@Version
	@Column(name = "VERSION", precision = 10, scale = 0 , nullable = false)
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	@Column(name="CREATE_BY")
	public String getCreateBy() {
		return this.createBy;
	}
	@Override
	@Column(name="CREATE_DT")
	public Date getCreateDt() {
		return this.createDt;
	}

	@Override
	@Column(name="UPDATE_BY")
	public String getUpdateBy() {
		return this.updateBy;
	}

	@Override
	@Column(name="UPDATE_DT")
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

	
	@Column(name="SITE_ID", length = 50)
	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	
	@Column(name="SITE_CODE", length = 20)
	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	@Column(name="LOCATION_CODE", length = 20)
	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	@Column(name="LOCATION_NAME", length = 255)
	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}


	@Column(name="TOWER_HEIGHT")
	public Integer getTowerHeight() {
		return towerHeight;
	}

	public void setTowerHeight(Integer towerHeight) {
		this.towerHeight = towerHeight;
	}

	@Column(name="SYSTEM", length = 20)
	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	@Column(name="TOWER_TYPE", length = 20)
	public String getTowerType() {
		return towerType;
	}

	public void setTowerType(String towerType) {
		this.towerType = towerType;
	}

	@Column(name="TOWER_LOCATION", length = 20)
	public String getTowerLocation() {
		return towerLocation;
	}

	public void setTowerLocation(String towerLocation) {
		this.towerLocation = towerLocation;
	}

	@Column(name="ZONE_DESCRIPTION", length = 255)
	public String getZoneDescription() {
		return zoneDescription;
	}

	public void setZoneDescription(String zoneDescription) {
		this.zoneDescription = zoneDescription;
	}

	@Column(name="LOCATION_TYPE", length = 20)
	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	@Column(name="LOCATION_ADDRESSNO", length = 255)
	public String getLocAddressNo() {
		return locAddressNo;
	}

	public void setLocAddressNo(String locAddressNo) {
		this.locAddressNo = locAddressNo;
	}

	@Column(name="LOCATION_BUILDING", length = 255)
	public String getLocBuilding() {
		return locBuilding;
	}

	public void setLocBuilding(String locBuilding) {
		this.locBuilding = locBuilding;
	}

	@Column(name="LOCATION_FLOOR", length = 20)
	public String getLocationFloor() {
		return locationFloor;
	}

	public void setLocationFloor(String locationFloor) {
		this.locationFloor = locationFloor;
	}

	@Column(name="LOCATION_STREET", length = 200)
	public String getLocationStreet() {
		return locationStreet;
	}

	public void setLocationStreet(String locationStreet) {
		this.locationStreet = locationStreet;
	}

	@Column(name="LOCATION_TUMBOL", length = 200)
	public String getLocaTumbol() {
		return locaTumbol;
	}

	public void setLocaTumbol(String locaTumbol) {
		this.locaTumbol = locaTumbol;
	}

	@Column(name="LOCATION_AMPHUR", length = 200)
	public String getLocAmphur() {
		return locAmphur;
	}

	public void setLocAmphur(String locAmphur) {
		this.locAmphur = locAmphur;
	}

	@Column(name="LOCATION_PROVINCE", length = 200)
	public String getLocProvince() {
		return locProvince;
	}

	public void setLocProvince(String locProvince) {
		this.locProvince = locProvince;
	}

	@Column(name="LOCATION_ZIPCODE", length = 10)
	public String getLocZipCode() {
		return locZipCode;
	}

	public void setLocZipCode(String locZipCode) {
		this.locZipCode = locZipCode;
	}

	@Column(name="ZONE", length = 10)
	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	@Column(name="RE_LOCATE", length = 20)
	public String getReLocate() {
		return reLocate;
	}

	public void setReLocate(String reLocate) {
		this.reLocate = reLocate;
	}
	
	
}