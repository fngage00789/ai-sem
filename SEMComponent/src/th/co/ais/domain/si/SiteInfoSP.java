package th.co.ais.domain.si;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class SiteInfoSP extends AbstractDomain implements Serializable {

	private static final long serialVersionUID = 8068478904708959764L;

	private String rowId;
	private String docNo;
	private String company;
	private String region;
	private String reqType;
	private String reqTypeName;
	private String title;
	private String assignContractNo;
	private String legalApproveStatus;
	private String locationId;
	private String locationCode;
	private String locationName;
	private String siteType;
	private String siteTypeName;
	private String siteInfoStatus;
	private String siteInfoStatusName;
	private String siteStatus;
	private String contractNo;
	//added by NEW 20150714 
	private String transferContNo;
	private String transferSiteInfoId;
	private Date effDateFrom;
	private Date effDateTo;
	private Date expDateFrom;
	private Date expDateTo;
	private String lessorName;
	private String currentFlag;
	private String docApproveType;
	private String docApproveId;
	private String assignSiteInfoId;
	private String siteInfoId;
	private String expireStatus;
	private String pendingStatus;
	private Date effDate;
	private Date expDate;
	private String networkStatus;
	private String siteName;
	private String editableFlag;
	private String flowStatus;
	private String noExpireFlag;
	private String viewSiteInfoId;
	private String oldContractNo;
	private String oldSiteInfoId;
	private String batchNo;
	private String province;
	private String tambol;
	private String houseNo;
	private String amphur;
	private String effDateStr;
	private String expDateStr;
	private String borrowStatus;
	
	// 2015/01/26 added by.. YUT
	private String strParam;
	
	// 2015/02/18 added by NEW 
	private String siteAppId;
	private Date fristEffDT;
	private Integer ageYear;
	private Integer ageMonth;
	private Integer ageDay;
	private Date pendingDate;
	private Date terminateDate;
	private String remark;
	private String placeType;
	private String siteHouseNo;
	private String siteBuilding;
	private String siteFloor;
	private String siteRoomNo;
	private String siteStreet;
	private String siteTambon;
	private String siteAmphurId;
	private String siteProvinceId;
	private String sitePostCode;
	private String deckAreaType;
	private BigDecimal deckArea;
	private String buildingAreaType;
	private BigDecimal buildingArea;
	private String roomAreaType;
	private BigDecimal roomArea;
	private String landAreaType;
	private String landAreaUnitType;
	private BigDecimal landArea;
	private BigDecimal landAreaUnit;
	private String rightHouseNo;
	private String rightBuilding;
	private String rightFloor;
	private String rightRoomNo;
	private String rightStreet;
	private String rightTambon;
	private String rightAmphur;
	private String rightProvince;
	private String rightPostCode;
	private String fromSiteInfoId;
	private String fromContractNo;
	private String elRemark;
	private String electricOwnerType;
	private BigDecimal takeAllAmt;
	private String takeAllPeriodType;
	private BigDecimal unitPriceAmt;
	private String vatType;
	private String payPeriodType;
	private Integer payPeriod;
	private String multiElectricTypeFlag;
	private String electricType1;
	private String electricType2;
	private String electricType3;
	private String electricType4;
	private String userId;
	private String pResult;
	private String pRemark;
	private String noUnitPriceFlag;
	private String groupRent;
	
	private String chkNoExpireFlag;
	private String chkOwnerContractFlag;
	private String chkPendingStatus;
	private boolean chkPendingStatusBoolean;
	private String chkNoExpenses;
	private String chkNoUnitPriceFlag;
	private String payPeriodType01;
	private String payPeriodType02;
	private String payPeriodType03;
	private String payPeriod03;
	private String payPeriodType04;
	private String payPeriod04;
	private String payPeriodType05;
	private String dummyFlag;
	private Date firstEffDate;
	private String siteStatusName;
	
	private String transferDummy;
	
	
	public String getViewSiteInfoId() {
		return viewSiteInfoId;
	}

	public void setViewSiteInfoId(String viewSiteInfoId) {
		this.viewSiteInfoId = viewSiteInfoId;
	}

	public String getNoExpireFlag() {
		return noExpireFlag;
	}

	public void setNoExpireFlag(String noExpireFlag) {
		this.noExpireFlag = noExpireFlag;
	}

	public String getEditableFlag() {
		return editableFlag;
	}

	public void setEditableFlag(String editableFlag) {
		this.editableFlag = editableFlag;
	}

	public String getPendingStatus() {
		return pendingStatus;
	}

	public void setPendingStatus(String pendingStatus) {
		this.pendingStatus = pendingStatus;
	}

	public String getSiteInfoStatusName() {
		return siteInfoStatusName;
	}

	public void setSiteInfoStatusName(String siteInfoStatusName) {
		this.siteInfoStatusName = siteInfoStatusName;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
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

	public String getAssignContractNo() {
		return assignContractNo;
	}

	public void setAssignContractNo(String assignContractNo) {
		this.assignContractNo = assignContractNo;
	}

	public String getLegalApproveStatus() {
		return legalApproveStatus;
	}

	public void setLegalApproveStatus(String legalApproveStatus) {
		this.legalApproveStatus = legalApproveStatus;
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

	public String getSiteType() {
		return siteType;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	public String getSiteInfoStatus() {
		return siteInfoStatus;
	}

	public void setSiteInfoStatus(String siteInfoStatus) {
		this.siteInfoStatus = siteInfoStatus;
	}

	public String getSiteStatus() {
		return siteStatus;
	}

	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public Date getEffDateFrom() {
		return effDateFrom;
	}

	public void setEffDateFrom(Date effDateFrom) {
		this.effDateFrom = effDateFrom;
	}

	public Date getEffDateTo() {
		return effDateTo;
	}

	public void setEffDateTo(Date effDateTo) {
		this.effDateTo = effDateTo;
	}

	public Date getExpDateFrom() {
		return expDateFrom;
	}

	public void setExpDateFrom(Date expDateFrom) {
		this.expDateFrom = expDateFrom;
	}

	public Date getExpDateTo() {
		return expDateTo;
	}

	public void setExpDateTo(Date expDateTo) {
		this.expDateTo = expDateTo;
	}

	public String getLessorName() {
		return lessorName;
	}

	public void setLessorName(String lessorName) {
		this.lessorName = lessorName;
	}

	public String getCurrentFlag() {
		return currentFlag;
	}

	public void setCurrentFlag(String currentFlag) {
		this.currentFlag = currentFlag;
	}

	public String getDocApproveType() {
		return docApproveType;
	}

	public void setDocApproveType(String docApproveType) {
		this.docApproveType = docApproveType;
	}

	public String getDocApproveId() {
		return docApproveId;
	}

	public void setDocApproveId(String docApproveId) {
		this.docApproveId = docApproveId;
	}

	public String getAssignSiteInfoId() {
		return assignSiteInfoId;
	}

	public void setAssignSiteInfoId(String assignSiteInfoId) {
		this.assignSiteInfoId = assignSiteInfoId;
	}

	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	public String getExpireStatus() {
		return expireStatus;
	}

	public void setExpireStatus(String expireStatus) {
		this.expireStatus = expireStatus;
	}

	public Date getEffDate() {
		return effDate;
	}

	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public String getNetworkStatus() {
		return networkStatus;
	}

	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
	}

	public String getReqTypeName() {
		return reqTypeName;
	}

	public void setReqTypeName(String reqTypeName) {
		this.reqTypeName = reqTypeName;
	}

	public String getSiteTypeName() {
		return siteTypeName;
	}

	public void setSiteTypeName(String siteTypeName) {
		this.siteTypeName = siteTypeName;
	}

	public String getFlowStatus() {
		return flowStatus;
	}

	public void setFlowStatus(String flowStatus) {
		this.flowStatus = flowStatus;
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
	
	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	@Override
	public String getCreateBy() {
		// TODO Auto-generated method stub
		return createBy;
	}

	@Override
	public Date getCreateDt() {
		// TODO Auto-generated method stub
		return createDt;
	}

	@Override
	public String getUpdateBy() {
		// TODO Auto-generated method stub
		return updateBy;
	}

	@Override
	public Date getUpdateDt() {
		// TODO Auto-generated method stub
		return updateDt;
	}

	@Override
	public void setCreateBy(String createBy) {
		// TODO Auto-generated method stub
		this.createBy = createBy;
	}

	@Override
	public void setCreateDt(Date createDt) {
		// TODO Auto-generated method stub
		this.createDt = createDt;
	}

	@Override
	public void setUpdateBy(String updateBy) {
		// TODO Auto-generated method stub
		this.updateBy = updateBy;
	}

	@Override
	public void setUpdateDt(Date updateDt) {
		// TODO Auto-generated method stub
		this.updateDt = updateDt;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getTambol() {
		return tambol;
	}

	public void setTambol(String tambol) {
		this.tambol = tambol;
	}

	public String getAmphur() {
		return amphur;
	}

	public void setAmphur(String amphur) {
		this.amphur = amphur;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getEffDateStr() {
		return effDateStr;
	}

	public void setEffDateStr(String effDateStr) {
		this.effDateStr = effDateStr;
	}

	public String getExpDateStr() {
		return expDateStr;
	}

	public void setExpDateStr(String expDateStr) {
		this.expDateStr = expDateStr;
	}

	public String getBorrowStatus() {
		return borrowStatus;
	}

	public void setBorrowStatus(String borrowStatus) {
		this.borrowStatus = borrowStatus;
	}

	public String getStrParam() {
		return strParam;
	}

	public void setStrParam(String strParam) {
		this.strParam = strParam;
	}

	public Date getFristEffDT() {
		return fristEffDT;
	}

	public void setFristEffDT(Date fristEffDT) {
		this.fristEffDT = fristEffDT;
	}

	public Integer getAgeYear() {
		return ageYear;
	}

	public void setAgeYear(Integer ageYear) {
		this.ageYear = ageYear;
	}

	public Integer getAgeMonth() {
		return ageMonth;
	}

	public void setAgeMonth(Integer ageMonth) {
		this.ageMonth = ageMonth;
	}

	public Integer getAgeDay() {
		return ageDay;
	}

	public void setAgeDay(Integer ageDay) {
		this.ageDay = ageDay;
	}

	public Date getPendingDate() {
		return pendingDate;
	}

	public void setPendingDate(Date pendingDate) {
		this.pendingDate = pendingDate;
	}

	public Date getTerminateDate() {
		return terminateDate;
	}

	public void setTerminateDate(Date terminateDate) {
		this.terminateDate = terminateDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPlaceType() {
		return placeType;
	}

	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}

	public String getSiteHouseNo() {
		return siteHouseNo;
	}

	public void setSiteHouseNo(String siteHouseNo) {
		this.siteHouseNo = siteHouseNo;
	}

	public String getSiteBuilding() {
		return siteBuilding;
	}

	public void setSiteBuilding(String siteBuilding) {
		this.siteBuilding = siteBuilding;
	}

	public String getSiteFloor() {
		return siteFloor;
	}

	public void setSiteFloor(String siteFloor) {
		this.siteFloor = siteFloor;
	}

	public String getSiteRoomNo() {
		return siteRoomNo;
	}

	public void setSiteRoomNo(String siteRoomNo) {
		this.siteRoomNo = siteRoomNo;
	}

	public String getSiteStreet() {
		return siteStreet;
	}

	public void setSiteStreet(String siteStreet) {
		this.siteStreet = siteStreet;
	}

	public String getSiteTambon() {
		return siteTambon;
	}

	public void setSiteTambon(String siteTambon) {
		this.siteTambon = siteTambon;
	}

	public String getSiteAmphurId() {
		return siteAmphurId;
	}

	public void setSiteAmphurId(String siteAmphurId) {
		this.siteAmphurId = siteAmphurId;
	}

	public String getSiteProvinceId() {
		return siteProvinceId;
	}

	public void setSiteProvinceId(String siteProvinceId) {
		this.siteProvinceId = siteProvinceId;
	}

	public String getSitePostCode() {
		return sitePostCode;
	}

	public void setSitePostCode(String sitePostCode) {
		this.sitePostCode = sitePostCode;
	}

	public String getDeckAreaType() {
		return deckAreaType;
	}

	public void setDeckAreaType(String deckAreaType) {
		this.deckAreaType = deckAreaType;
	}

	public BigDecimal getDeckArea() {
		return deckArea;
	}

	public void setDeckArea(BigDecimal deckArea) {
		this.deckArea = deckArea;
	}

	public String getBuildingAreaType() {
		return buildingAreaType;
	}

	public void setBuildingAreaType(String buildingAreaType) {
		this.buildingAreaType = buildingAreaType;
	}

	public BigDecimal getBuildingArea() {
		return buildingArea;
	}

	public void setBuildingArea(BigDecimal buildingArea) {
		this.buildingArea = buildingArea;
	}

	public String getRoomAreaType() {
		return roomAreaType;
	}

	public void setRoomAreaType(String roomAreaType) {
		this.roomAreaType = roomAreaType;
	}

	public BigDecimal getRoomArea() {
		return roomArea;
	}

	public void setRoomArea(BigDecimal roomArea) {
		this.roomArea = roomArea;
	}

	public String getLandAreaType() {
		return landAreaType;
	}

	public void setLandAreaType(String landAreaType) {
		this.landAreaType = landAreaType;
	}

	public String getLandAreaUnitType() {
		return landAreaUnitType;
	}

	public void setLandAreaUnitType(String landAreaUnitType) {
		this.landAreaUnitType = landAreaUnitType;
	}

	public BigDecimal getLandArea() {
		return landArea;
	}

	public void setLandArea(BigDecimal landArea) {
		this.landArea = landArea;
	}

	public BigDecimal getLandAreaUnit() {
		return landAreaUnit;
	}

	public void setLandAreaUnit(BigDecimal landAreaUnit) {
		this.landAreaUnit = landAreaUnit;
	}

	public String getRightHouseNo() {
		return rightHouseNo;
	}

	public void setRightHouseNo(String rightHouseNo) {
		this.rightHouseNo = rightHouseNo;
	}

	public String getRightBuilding() {
		return rightBuilding;
	}

	public void setRightBuilding(String rightBuilding) {
		this.rightBuilding = rightBuilding;
	}

	public String getRightFloor() {
		return rightFloor;
	}

	public void setRightFloor(String rightFloor) {
		this.rightFloor = rightFloor;
	}

	public String getRightStreet() {
		return rightStreet;
	}

	public void setRightStreet(String rightStreet) {
		this.rightStreet = rightStreet;
	}

	public String getRightTambon() {
		return rightTambon;
	}

	public void setRightTambon(String rightTambon) {
		this.rightTambon = rightTambon;
	}

	public String getRightAmphur() {
		return rightAmphur;
	}

	public void setRightAmphur(String rightAmphur) {
		this.rightAmphur = rightAmphur;
	}

	public String getRightProvince() {
		return rightProvince;
	}

	public void setRightProvince(String rightProvince) {
		this.rightProvince = rightProvince;
	}

	public String getRightPostCode() {
		return rightPostCode;
	}

	public void setRightPostCode(String rightPostCode) {
		this.rightPostCode = rightPostCode;
	}

	public String getFromSiteInfoId() {
		return fromSiteInfoId;
	}

	public void setFromSiteInfoId(String fromSiteInfoId) {
		this.fromSiteInfoId = fromSiteInfoId;
	}

	public String getFromContractNo() {
		return fromContractNo;
	}

	public void setFromContractNo(String fromContractNo) {
		this.fromContractNo = fromContractNo;
	}

	public String getElRemark() {
		return elRemark;
	}

	public void setElRemark(String elRemark) {
		this.elRemark = elRemark;
	}

	public String getElectricOwnerType() {
		return electricOwnerType;
	}

	public void setElectricOwnerType(String electricOwnerType) {
		this.electricOwnerType = electricOwnerType;
	}

	public BigDecimal getTakeAllAmt() {
		return takeAllAmt;
	}

	public void setTakeAllAmt(BigDecimal takeAllAmt) {
		this.takeAllAmt = takeAllAmt;
	}

	public String getTakeAllPeriodType() {
		return takeAllPeriodType;
	}

	public void setTakeAllPeriodType(String takeAllPeriodType) {
		this.takeAllPeriodType = takeAllPeriodType;
	}

	public BigDecimal getUnitPriceAmt() {
		return unitPriceAmt;
	}

	public void setUnitPriceAmt(BigDecimal unitPriceAmt) {
		this.unitPriceAmt = unitPriceAmt;
	}

	public String getVatType() {
		return vatType;
	}

	public void setVatType(String vatType) {
		this.vatType = vatType;
	}

	public String getPayPeriodType() {
		return payPeriodType;
	}

	public void setPayPeriodType(String payPeriodType) {
		this.payPeriodType = payPeriodType;
	}

	public Integer getPayPeriod() {
		return payPeriod;
	}

	public void setPayPeriod(Integer payPeriod) {
		this.payPeriod = payPeriod;
	}

	public String getMultiElectricTypeFlag() {
		return multiElectricTypeFlag;
	}

	public void setMultiElectricTypeFlag(String multiElectricTypeFlag) {
		this.multiElectricTypeFlag = multiElectricTypeFlag;
	}

	public String getElectricType1() {
		return electricType1;
	}

	public void setElectricType1(String electricType1) {
		this.electricType1 = electricType1;
	}

	public String getElectricType2() {
		return electricType2;
	}

	public void setElectricType2(String electricType2) {
		this.electricType2 = electricType2;
	}

	public String getElectricType3() {
		return electricType3;
	}

	public void setElectricType3(String electricType3) {
		this.electricType3 = electricType3;
	}

	public String getElectricType4() {
		return electricType4;
	}

	public void setElectricType4(String electricType4) {
		this.electricType4 = electricType4;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getpResult() {
		return pResult;
	}

	public void setpResult(String pResult) {
		this.pResult = pResult;
	}

	public String getpRemark() {
		return pRemark;
	}

	public void setpRemark(String pRemark) {
		this.pRemark = pRemark;
	}

	public String getRightRoomNo() {
		return rightRoomNo;
	}

	public void setRightRoomNo(String rightRoomNo) {
		this.rightRoomNo = rightRoomNo;
	}

	public String getNoUnitPriceFlag() {
		return noUnitPriceFlag;
	}

	public void setNoUnitPriceFlag(String noUnitPriceFlag) {
		this.noUnitPriceFlag = noUnitPriceFlag;
	}

	public String getGroupRent() {
		return groupRent;
	}

	public void setGroupRent(String groupRent) {
		this.groupRent = groupRent;
	}

	public String getChkNoExpireFlag() {
		return chkNoExpireFlag;
	}

	public void setChkNoExpireFlag(String chkNoExpireFlag) {
		this.chkNoExpireFlag = chkNoExpireFlag;
	}

	public String getChkOwnerContractFlag() {
		return chkOwnerContractFlag;
	}

	public void setChkOwnerContractFlag(String chkOwnerContractFlag) {
		this.chkOwnerContractFlag = chkOwnerContractFlag;
	}

	public String getChkPendingStatus() {
		return chkPendingStatus;
	}

	public void setChkPendingStatus(String chkPendingStatus) {
		this.chkPendingStatus = chkPendingStatus;
	}

	public String getChkNoExpenses() {
		return chkNoExpenses;
	}

	public void setChkNoExpenses(String chkNoExpenses) {
		this.chkNoExpenses = chkNoExpenses;
	}

	public String getChkNoUnitPriceFlag() {
		return chkNoUnitPriceFlag;
	}

	public void setChkNoUnitPriceFlag(String chkNoUnitPriceFlag) {
		this.chkNoUnitPriceFlag = chkNoUnitPriceFlag;
	}

	public String getPayPeriodType01() {
		return payPeriodType01;
	}

	public void setPayPeriodType01(String payPeriodType01) {
		this.payPeriodType01 = payPeriodType01;
	}

	public String getPayPeriodType02() {
		return payPeriodType02;
	}

	public void setPayPeriodType02(String payPeriodType02) {
		this.payPeriodType02 = payPeriodType02;
	}

	public String getPayPeriodType03() {
		return payPeriodType03;
	}

	public void setPayPeriodType03(String payPeriodType03) {
		this.payPeriodType03 = payPeriodType03;
	}

	public String getPayPeriod03() {
		return payPeriod03;
	}

	public void setPayPeriod03(String payPeriod03) {
		this.payPeriod03 = payPeriod03;
	}

	public String getPayPeriodType04() {
		return payPeriodType04;
	}

	public void setPayPeriodType04(String payPeriodType04) {
		this.payPeriodType04 = payPeriodType04;
	}

	public String getPayPeriod04() {
		return payPeriod04;
	}

	public void setPayPeriod04(String payPeriod04) {
		this.payPeriod04 = payPeriod04;
	}

	public String getPayPeriodType05() {
		return payPeriodType05;
	}

	public void setPayPeriodType05(String payPeriodType05) {
		this.payPeriodType05 = payPeriodType05;
	}

	public String getDummyFlag() {
		return dummyFlag;
	}

	public void setDummyFlag(String dummyFlag) {
		this.dummyFlag = dummyFlag;
	}

	public String getSiteAppId() {
		return siteAppId;
	}

	public void setSiteAppId(String siteAppId) {
		this.siteAppId = siteAppId;
	}

	public Date getFirstEffDate() {
		return firstEffDate;
	}

	public void setFirstEffDate(Date firstEffDate) {
		this.firstEffDate = firstEffDate;
	}

	public String getSiteStatusName() {
		return siteStatusName;
	}

	public void setSiteStatusName(String siteStatusName) {
		this.siteStatusName = siteStatusName;
	}

	public String getTransferContNo() {
		return transferContNo;
	}

	public void setTransferContNo(String transferContNo) {
		this.transferContNo = transferContNo;
	}

	public String getTransferSiteInfoId() {
		return transferSiteInfoId;
	}

	public void setTransferSiteInfoId(String transferSiteInfoId) {
		this.transferSiteInfoId = transferSiteInfoId;
	}

	public String getTransferDummy() {
		return transferDummy;
	}

	public void setTransferDummy(String transferDummy) {
		this.transferDummy = transferDummy;
	}

	public boolean isChkPendingStatusBoolean() {
		return chkPendingStatusBoolean;
	}

	public void setChkPendingStatusBoolean(boolean chkPendingStatusBoolean) {
		this.chkPendingStatusBoolean = chkPendingStatusBoolean;
	}

	
	
}
