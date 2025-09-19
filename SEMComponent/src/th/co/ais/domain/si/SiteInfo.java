package th.co.ais.domain.si;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;

@Entity
@Table(name="SEM_SI_SITE_INFO", schema="SEM")
public class SiteInfo extends AbstractDomain {

	private static final long serialVersionUID = -1406129631839309889L;
	// Fields

	private String rowId;
	private String company;
	private String region;
	private String oldContractNo;
	private String docApproveType;
	private String docApproveId;
	private String siteName;
	private String siteType;
	private String siteInfoStatus;
	private String siteStatus;
	private String pendingStatus;
	private Date terminateDt;
	private String placeType;
	private String siteHouseNo;
	private String siteLandNo;
	private String siteBuilding;
	private String siteFloor;
	private String siteRoomNo;
	private String siteStreet;
	private String siteTambon;
	private String siteAmphurId;
	private String siteProvinceId;
	private String sitePostcode;
	private String deckAreaType;
	private Double deckArea;
	private String buildingAreaType;
	private Double buildingArea;
	private Double roomArea;
	private String landAreaUnitType;
	private Double landArea;
	private String rightHouseNo;
	private String rightLandNo;
	private String rightBuilding;
	private String rightFloor;
	private String rightRoomNo;
	private String rightStreet;
	private String rightTambon;
	private String rightAmphur;
	private String rightProvince;
	private String rightPostcode;
	private String migrateFlag;
	private String latestFlag;
	private String recordStatus;
	private String siteEditFlag;
	private String contractEditFlag;
	private String lessorEditFlag;
	private String rentEditFlag;
	private String propertyTaxEditFlag;
	private String electricEditFlag;
	private String insuranceEditFlag;
	private String depositRentEditFlag;
	private String depositElectricEditFlag;
	private Integer seqNo;
	private Long version;
	private String roomAreaType;
	private String landAreaType;
	private Date pendingDt;
	private String oldSiteInfoId;
	private Date approveDt;
	private String groupRent;
	
	//added by NEW 2018/09/05
	private String deckAreaUnitType;
	private Double deckAreaWidth;	
	private Double deckAreaLong;	
	private String deckAreaOther;	
	private String buildingAreaUnitType;	
	private Double buildingAreaWidth;	
	private Double buildingAreaLong;	
	private String buildingAreaOther;	
	private String roomAreaUnitType;	
	private Double roomAreaWidth;	
	private Double roomAreaLong;	
	private String roomAreaOther;	
	private Double landAreaWidth;	
	private Double landAreaLong;	
	private String landAreaOther;
	private String placeTypeOth;
	
	// Property accessors
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "SITE_INFO_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "COMPANY", length = 20)
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "REGION", length = 10)
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Column(name = "OLD_CONTRACT_NO", length = 20)
	public String getOldContractNo() {
		return oldContractNo;
	}

	public void setOldContractNo(String oldContractNo) {
		this.oldContractNo = oldContractNo;
	}

	@Column(name = "DOC_APPROVE_TYPE", length = 2)
	public String getDocApproveType() {
		return docApproveType;
	}

	public void setDocApproveType(String docApproveType) {
		this.docApproveType = docApproveType;
	}

	@Column(name = "DOC_APPROVE_ID", length = 50)
	public String getDocApproveId() {
		return docApproveId;
	}

	public void setDocApproveId(String docApproveId) {
		this.docApproveId = docApproveId;
	}

	@Column(name = "SITE_NAME", length = 200)
	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	@Column(name = "SITE_TYPE", length = 2)
	public String getSiteType() {
		return siteType;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	@Column(name = "SITE_INFO_STATUS", length = 2)
	public String getSiteInfoStatus() {
		return siteInfoStatus;
	}

	public void setSiteInfoStatus(String siteInfoStatus) {
		this.siteInfoStatus = siteInfoStatus;
	}

	@Column(name = "SITE_STATUS", length = 2)
	public String getSiteStatus() {
		return siteStatus;
	}

	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}

	@Column(name = "PENDING_STATUS", length = 1)
	public String getPendingStatus() {
		return pendingStatus;
	}

	public void setPendingStatus(String pendingStatus) {
		this.pendingStatus = pendingStatus;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TERMINATE_DT", length = 7)
	public Date getTerminateDt() {
		return terminateDt;
	}

	public void setTerminateDt(Date terminateDt) {
		this.terminateDt = terminateDt;
	}

	@Column(name = "PLACE_TYPE", length = 2)
	public String getPlaceType() {
		return placeType;
	}

	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}

	@Column(name = "SITE_HOUSE_NO", length = 500)
	public String getSiteHouseNo() {
		return siteHouseNo;
	}

	public void setSiteHouseNo(String siteHouseNo) {
		this.siteHouseNo = siteHouseNo;
	}

	@Column(name = "SITE_LAND_NO", length = 500)
	public String getSiteLandNo() {
		return siteLandNo;
	}

	public void setSiteLandNo(String siteLandNo) {
		this.siteLandNo = siteLandNo;
	}

	@Column(name = "SITE_BUILDING", length = 100)
	public String getSiteBuilding() {
		return siteBuilding;
	}

	public void setSiteBuilding(String siteBuilding) {
		this.siteBuilding = siteBuilding;
	}

	@Column(name = "SITE_FLOOR", length = 10)
	public String getSiteFloor() {
		return siteFloor;
	}

	public void setSiteFloor(String siteFloor) {
		this.siteFloor = siteFloor;
	}

	@Column(name = "SITE_ROOM_NO", length = 10)
	public String getSiteRoomNo() {
		return siteRoomNo;
	}

	public void setSiteRoomNo(String siteRoomNo) {
		this.siteRoomNo = siteRoomNo;
	}

	@Column(name = "SITE_STREET", length = 100)
	public String getSiteStreet() {
		return siteStreet;
	}

	public void setSiteStreet(String siteStreet) {
		this.siteStreet = siteStreet;
	}

	@Column(name = "SITE_TAMBON", length = 100)
	public String getSiteTambon() {
		return siteTambon;
	}

	public void setSiteTambon(String siteTambon) {
		this.siteTambon = siteTambon;
	}

	@Column(name = "SITE_AMPHUR_ID", length = 50)
	public String getSiteAmphurId() {
		return siteAmphurId;
	}

	public void setSiteAmphurId(String siteAmphurId) {
		this.siteAmphurId = siteAmphurId;
	}

	@Column(name = "SITE_PROVINCE_ID", length = 50)
	public String getSiteProvinceId() {
		return siteProvinceId;
	}

	public void setSiteProvinceId(String siteProvinceId) {
		this.siteProvinceId = siteProvinceId;
	}

	@Column(name = "SITE_POSTCODE", length = 10)
	public String getSitePostcode() {
		return sitePostcode;
	}

	public void setSitePostcode(String sitePostcode) {
		this.sitePostcode = sitePostcode;
	}

	@Column(name = "DECK_AREA_TYPE", length = 2)
	public String getDeckAreaType() {
		return deckAreaType;
	}

	public void setDeckAreaType(String deckAreaType) {
		this.deckAreaType = deckAreaType;
	}

	@Column(name = "DECK_AREA", precision = 15)
	public Double getDeckArea() {
		if(deckArea != null && deckArea == 0.00){
			return null;
		}
		return deckArea;
	}

	public void setDeckArea(Double deckArea) {
		this.deckArea = deckArea;
	}

	@Column(name = "BUILDING_AREA_TYPE", length = 2)
	public String getBuildingAreaType() {
		return buildingAreaType;
	}

	public void setBuildingAreaType(String buildingAreaType) {
		this.buildingAreaType = buildingAreaType;
	}

	@Column(name = "BUILDING_AREA", precision = 15)
	public Double getBuildingArea() {
		if(buildingArea != null && buildingArea == 0.00){
			return null;
		}
		return buildingArea;
	}

	public void setBuildingArea(Double buildingArea) {
		this.buildingArea = buildingArea;
	}

	@Column(name = "ROOM_AREA", precision = 15)
	public Double getRoomArea() {
		if(roomArea != null && roomArea == 0.00){
			return null;
		}
		return roomArea;
	}

	public void setRoomArea(Double roomArea) {
		this.roomArea = roomArea;
	}

	@Column(name = "LAND_AREA_UNIT_TYPE", length = 2)
	public String getLandAreaUnitType() {
		return landAreaUnitType;
	}

	public void setLandAreaUnitType(String landAreaUnitType) {
		this.landAreaUnitType = landAreaUnitType;
	}

	@Column(name = "LAND_AREA", precision = 15)
	public Double getLandArea() {
		if(landArea != null && landArea == 0.00){
			return null;
		}
		return landArea;
	}

	public void setLandArea(Double landArea) {
		this.landArea = landArea;
	}

	@Column(name = "RIGHT_HOUSE_NO", length = 500)
	public String getRightHouseNo() {
		return rightHouseNo;
	}

	public void setRightHouseNo(String rightHouseNo) {
		this.rightHouseNo = rightHouseNo;
	}

	@Column(name = "RIGHT_LAND_NO", length = 500)
	public String getRightLandNo() {
		return rightLandNo;
	}

	public void setRightLandNo(String rightLandNo) {
		this.rightLandNo = rightLandNo;
	}

	@Column(name = "RIGHT_BUILDING", length = 100)
	public String getRightBuilding() {
		return rightBuilding;
	}

	public void setRightBuilding(String rightBuilding) {
		this.rightBuilding = rightBuilding;
	}

	@Column(name = "RIGHT_FLOOR", length = 10)
	public String getRightFloor() {
		return rightFloor;
	}

	public void setRightFloor(String rightFloor) {
		this.rightFloor = rightFloor;
	}

	@Column(name = "RIGHT_ROOM_NO", length = 10)
	public String getRightRoomNo() {
		return rightRoomNo;
	}

	public void setRightRoomNo(String rightRoomNo) {
		this.rightRoomNo = rightRoomNo;
	}

	@Column(name = "RIGHT_STREET", length = 100)
	public String getRightStreet() {
		return rightStreet;
	}

	public void setRightStreet(String rightStreet) {
		this.rightStreet = rightStreet;
	}

	@Column(name = "RIGHT_TAMBON", length = 100)
	public String getRightTambon() {
		return rightTambon;
	}

	public void setRightTambon(String rightTambon) {
		this.rightTambon = rightTambon;
	}

	@Column(name = "RIGHT_AMPHUR", length = 100)
	public String getRightAmphur() {
		return rightAmphur;
	}

	public void setRightAmphur(String rightAmphur) {
		this.rightAmphur = rightAmphur;
	}

	@Column(name = "RIGHT_PROVINCE", length = 100)
	public String getRightProvince() {
		return rightProvince;
	}

	public void setRightProvince(String rightProvince) {
		this.rightProvince = rightProvince;
	}

	@Column(name = "RIGHT_POSTCODE", length = 10)
	public String getRightPostcode() {
		return rightPostcode;
	}

	public void setRightPostcode(String rightPostcode) {
		this.rightPostcode = rightPostcode;
	}

	@Column(name = "MIGRATE_FLAG", length = 1)
	public String getMigrateFlag() {
		return migrateFlag;
	}

	public void setMigrateFlag(String migrateFlag) {
		this.migrateFlag = migrateFlag;
	}

	@Column(name = "LATEST_FLAG", length = 1)
	public String getLatestFlag() {
		return latestFlag;
	}

	public void setLatestFlag(String latestFlag) {
		this.latestFlag = latestFlag;
	}

	

	@Column(name = "RECORD_STATUS", nullable = false, length = 1)
	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	@Column(name = "SITE_EDIT_FLAG", length = 1)
	public String getSiteEditFlag() {
		return siteEditFlag;
	}

	public void setSiteEditFlag(String siteEditFlag) {
		this.siteEditFlag = siteEditFlag;
	}

	@Column(name = "CONTRACT_EDIT_FLAG", length = 1)
	public String getContractEditFlag() {
		return contractEditFlag;
	}

	public void setContractEditFlag(String contractEditFlag) {
		this.contractEditFlag = contractEditFlag;
	}

	@Column(name = "LESSOR_EDIT_FLAG", length = 1)
	public String getLessorEditFlag() {
		return lessorEditFlag;
	}

	public void setLessorEditFlag(String lessorEditFlag) {
		this.lessorEditFlag = lessorEditFlag;
	}

	@Column(name = "RENT_EDIT_FLAG", length = 1)
	public String getRentEditFlag() {
		return rentEditFlag;
	}

	public void setRentEditFlag(String rentEditFlag) {
		this.rentEditFlag = rentEditFlag;
	}

	@Column(name = "PROPERTY_TAX_EDIT_FLAG", length = 1)
	public String getPropertyTaxEditFlag() {
		return propertyTaxEditFlag;
	}

	public void setPropertyTaxEditFlag(String propertyTaxEditFlag) {
		this.propertyTaxEditFlag = propertyTaxEditFlag;
	}

	@Column(name = "ELECTRIC_EDIT_FLAG", length = 1)
	public String getElectricEditFlag() {
		return electricEditFlag;
	}

	public void setElectricEditFlag(String electricEditFlag) {
		this.electricEditFlag = electricEditFlag;
	}

	@Column(name = "INSURANCE_EDIT_FLAG", length = 1)
	public String getInsuranceEditFlag() {
		return insuranceEditFlag;
	}

	public void setInsuranceEditFlag(String insuranceEditFlag) {
		this.insuranceEditFlag = insuranceEditFlag;
	}
	
	
	@Column(name = "DEPOSIT_RENT_EDIT_FLAG", length = 1)
	public String getDepositRentEditFlag() {
		return depositRentEditFlag;
	}

	public void setDepositRentEditFlag(String depositRentEditFlag) {
		this.depositRentEditFlag = depositRentEditFlag;
	}
	
	@Column(name = "DEPOSIT_ELECTRIC_EDIT_FLAG", length = 1)
	public String getDepositElectricEditFlag() {
		return depositElectricEditFlag;
	}

	public void setDepositElectricEditFlag(String depositElectricEditFlag) {
		this.depositElectricEditFlag = depositElectricEditFlag;
	}

	@Column(name = "SEQ_NO", precision = 22, scale = 0)
	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
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
	
	@Version
	@Column(name = "VERSION", precision = 10, scale = 0 , nullable = false)
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Column(name = "ROOM_AREA_TYPE", length = 2)
	public String getRoomAreaType() {
		return roomAreaType;
	}

	public void setRoomAreaType(String roomAreaType) {
		this.roomAreaType = roomAreaType;
	}

	@Column(name = "LAND_AREA_TYPE", length = 2)
	public String getLandAreaType() {
		return landAreaType;
	}

	public void setLandAreaType(String landAreaType) {
		this.landAreaType = landAreaType;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PENDING_DT", length = 7)
	public Date getPendingDt() {
		return pendingDt;
	}

	public void setPendingDt(Date pendingDt) {
		this.pendingDt = pendingDt;
	}

	@Column(name = "OLD_SITE_INFO_ID", length = 50)
	public String getOldSiteInfoId() {
		return oldSiteInfoId;
	}

	public void setOldSiteInfoId(String oldSiteInfoId) {
		this.oldSiteInfoId = oldSiteInfoId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "APPROVE_DT", length = 7)
	public Date getApproveDt() {
		return approveDt;
	}

	public void setApproveDt(Date approveDt) {
		this.approveDt = approveDt;
	}
	@Column(name = "SITE_GROUP", length = 255)
	public String getGroupRent() {
		return groupRent;
	}

	public void setGroupRent(String groupRent) {
		this.groupRent = groupRent;
	}

	
	@Column(name = "DECK_AREA_UNIT_TYPE", length = 500)
	public String getDeckAreaUnitType() {
		return deckAreaUnitType;
	}

	public void setDeckAreaUnitType(String deckAreaUnitType) {
		this.deckAreaUnitType = deckAreaUnitType;
	}

	@Column(name = "DECK_AREA_WIDTH", precision = 15)
	public Double getDeckAreaWidth() {
		return deckAreaWidth;
	}

	public void setDeckAreaWidth(Double deckAreaWidth) {
		this.deckAreaWidth = deckAreaWidth;
	}

	@Column(name = "DECK_AREA_LONG", precision = 15)
	public Double getDeckAreaLong() {
		return deckAreaLong;
	}

	public void setDeckAreaLong(Double deckAreaLong) {
		this.deckAreaLong = deckAreaLong;
	}

	@Column(name = "DECK_AREA_OTHER", length = 500)
	public String getDeckAreaOther() {
		return deckAreaOther;
	}

	public void setDeckAreaOther(String deckAreaOther) {
		this.deckAreaOther = deckAreaOther;
	}

	@Column(name = "BUILDING_AREA_UNIT_TYPE", length = 500)
	public String getBuildingAreaUnitType() {
		return buildingAreaUnitType;
	}

	public void setBuildingAreaUnitType(String buildingAreaUnitType) {
		this.buildingAreaUnitType = buildingAreaUnitType;
	}

	@Column(name = "BUILDING_AREA_WIDTH", precision = 15)
	public Double getBuildingAreaWidth() {
		return buildingAreaWidth;
	}

	public void setBuildingAreaWidth(Double buildingAreaWidth) {
		this.buildingAreaWidth = buildingAreaWidth;
	}

	@Column(name = "BUILDING_AREA_LONG", precision = 15)
	public Double getBuildingAreaLong() {
		return buildingAreaLong;
	}

	public void setBuildingAreaLong(Double buildingAreaLong) {
		this.buildingAreaLong = buildingAreaLong;
	}

	@Column(name = "BUILDING_AREA_OTHER", length = 500)
	public String getBuildingAreaOther() {
		return buildingAreaOther;
	}

	public void setBuildingAreaOther(String buildingAreaOther) {
		this.buildingAreaOther = buildingAreaOther;
	}

	@Column(name = "ROOM_AREA_UNIT_TYPE", length = 500)
	public String getRoomAreaUnitType() {
		return roomAreaUnitType;
	}

	public void setRoomAreaUnitType(String roomAreaUnitType) {
		this.roomAreaUnitType = roomAreaUnitType;
	}

	@Column(name = "ROOM_AREA_WIDTH", precision = 15)
	public Double getRoomAreaWidth() {
		return roomAreaWidth;
	}

	public void setRoomAreaWidth(Double roomAreaWidth) {
		this.roomAreaWidth = roomAreaWidth;
	}

	@Column(name = "ROOM_AREA_LONG", precision = 15)
	public Double getRoomAreaLong() {
		return roomAreaLong;
	}

	public void setRoomAreaLong(Double roomAreaLong) {
		this.roomAreaLong = roomAreaLong;
	}

	@Column(name = "ROOM_AREA_OTHER", length = 500)
	public String getRoomAreaOther() {
		return roomAreaOther;
	}

	public void setRoomAreaOther(String roomAreaOther) {
		this.roomAreaOther = roomAreaOther;
	}

	@Column(name = "LAND_AREA_WIDTH", precision = 15)
	public Double getLandAreaWidth() {
		return landAreaWidth;
	}

	public void setLandAreaWidth(Double landAreaWidth) {
		this.landAreaWidth = landAreaWidth;
	}

	@Column(name = "LAND_AREA_LONG", precision = 15)
	public Double getLandAreaLong() {
		return landAreaLong;
	}

	public void setLandAreaLong(Double landAreaLong) {
		this.landAreaLong = landAreaLong;
	}

	@Column(name = "LAND_AREA_OTHER", length = 500)
	public String getLandAreaOther() {
		return landAreaOther;
	}

	public void setLandAreaOther(String landAreaOther) {
		this.landAreaOther = landAreaOther;
	}
	
	@Column(name = "PLACE_TYPE_OTHER", length = 500)
	public String getPlaceTypeOth() {
		return placeTypeOth;
	}

	public void setPlaceTypeOth(String placeTypeOth) {
		this.placeTypeOth = placeTypeOth;
	}
	
	

}