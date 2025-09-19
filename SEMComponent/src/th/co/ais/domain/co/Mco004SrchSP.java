package th.co.ais.domain.co;

import java.math.BigDecimal;
import java.util.Date;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.annotation.PCell;
import th.co.ais.util.SEMDataUtility;

public class Mco004SrchSP extends AbstractDomain {
	
	private String month;
	private String year;
	private String company;
	private String region;
	private String contractNo;
	private String siteName;
	private String locationId;
	private String subRentStatus;
	private Date effDateFrom;
	private Date ExpDateTo;
	
	private String subRentId;
	private String lessorSiteInfoId;
	private String lesseeSiteInfoId;
	private String lessorContractNo;
	private String lesseeContractNo;
	private Date effectiveDt;
	private Date expireDt;
	private Double rentAmt;
	private Double serviceAmt;
	private String lesseeCompany;
	private String lesseeRegion;
	private String lesseeSiteType;
	private String subRentType;
	
	//Summary
	private String subRentSummaryType;
	private String monthYear;
	private Double totalAmt;
	private Double createAmt;
	private Double remainAmt;
	
	private String resultMsg;
	private String result;
	
	//Popup New Contract
	private String contractNo1;
	private String contractNo2;
	private String contractNo3;
	
	private String rowID;
	private Integer No;
	
	
	private String groupNo;
	private String pResult;
	private String pRemark;
	private String siteInfoId;
	private String actionType;
	private String userId;
	
	private String contractAge;
	
	private String address;
	private String street;
	private String district;
	private String amphur;
	private String province;
	private String postcode;
	private String deckArea;
	private String buildingArea;
	private String roomArea;
	private String landArea;
	
	private String effectiveDtStr;
	private String expireDtStr;
	private String lesseeContractId;
	private String borrowStatus;
	private Double dutyAmt;
	private String reqTypeName;
	private boolean isPico;
	private String strPico;
	
	public Mco004SrchSP(){
	}
	
	public Mco004SrchSP(Mco004SrchSP mco004SrchSP){
		this.month = mco004SrchSP.getMonth();
		this.year = mco004SrchSP.getYear();
		this.company = mco004SrchSP.getCompany();
		this.region = mco004SrchSP.getRegion();
		this.contractNo = mco004SrchSP.getContractNo();
		this.siteName = mco004SrchSP.getSiteName();
		this.locationId = mco004SrchSP.getLocationId();
		this.subRentStatus = mco004SrchSP.getSubRentStatus();
		this.subRentId = mco004SrchSP.getSubRentId();
		this.lessorSiteInfoId = mco004SrchSP.getLessorSiteInfoId();
		this.lesseeSiteInfoId = mco004SrchSP.getLesseeSiteInfoId();
		this.lessorContractNo = mco004SrchSP.getLessorContractNo();
		this.lesseeContractNo = mco004SrchSP.getLesseeContractNo();
		this.effectiveDt = mco004SrchSP.getEffectiveDt();
		this.expireDt = mco004SrchSP.getExpireDt();
		this.rentAmt = mco004SrchSP.getRentAmt();
		this.serviceAmt = mco004SrchSP.getServiceAmt();
		this.lesseeCompany = mco004SrchSP.getLesseeCompany();
		this.lesseeRegion = mco004SrchSP.getLesseeRegion();
		this.lesseeSiteType = mco004SrchSP.getLesseeSiteType();
		this.subRentType = mco004SrchSP.getSubRentType();
		this.subRentSummaryType = mco004SrchSP.getSubRentSummaryType();
		this.monthYear = mco004SrchSP.getMonthYear();
		this.totalAmt = mco004SrchSP.getTotalAmt();
		this.createAmt = mco004SrchSP.getCreateAmt();
		this.remainAmt = mco004SrchSP.getRemainAmt();
		this.contractAge = mco004SrchSP.getContractAge();
		this.lesseeContractId = mco004SrchSP.getLesseeContractId();
		this.borrowStatus = mco004SrchSP.getBorrowStatus();
	}
	
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
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

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	@PCell(cellType = String.class ,no = 4, manualStyleName="si002Field")
	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	@PCell(cellType = String.class ,no = 3, manualStyleName="si002Field")
	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	@PCell(cellType = String.class ,no = 20, manualStyleName="si002Field")
	public String getSubRentStatus() {
		return subRentStatus;
	}

	public void setSubRentStatus(String subRentStatus) {
		this.subRentStatus = subRentStatus;
	}

	public String getSubRentId() {
		return subRentId;
	}

	public void setSubRentId(String subRentId) {
		this.subRentId = subRentId;
	}

	public String getLessorSiteInfoId() {
		return lessorSiteInfoId;
	}

	public void setLessorSiteInfoId(String lessorSiteInfoId) {
		this.lessorSiteInfoId = lessorSiteInfoId;
	}

	public String getLesseeSiteInfoId() {
		return lesseeSiteInfoId;
	}

	public void setLesseeSiteInfoId(String lesseeSiteInfoId) {
		this.lesseeSiteInfoId = lesseeSiteInfoId;
	}
	@PCell(cellType = String.class ,no = 1, manualStyleName="si002Field")
	public String getLessorContractNo() {
		return lessorContractNo;
	}

	public void setLessorContractNo(String lessorContractNo) {
		this.lessorContractNo = lessorContractNo;
	}
	@PCell(cellType = String.class ,no = 2, manualStyleName="si002Field")
	public String getLesseeContractNo() {
		return lesseeContractNo;
	}

	public void setLesseeContractNo(String lesseeContractNo) {
		this.lesseeContractNo = lesseeContractNo;
	}
	@PCell(cellType = Date.class ,no = 11, manualStyleName="si002Field")
	public Date getEffectiveDt() {
		return effectiveDt;
	}

	public void setEffectiveDt(Date effectiveDt) {
		this.effectiveDt = effectiveDt;
	}
	@PCell(cellType = Date.class ,no = 12, manualStyleName="si002Field")
	public Date getExpireDt() {
		return expireDt;
	}

	public void setExpireDt(Date expireDt) {
		this.expireDt = expireDt;
	}
	@PCell(cellType = Double.class ,no = 18, manualStyleName="rt002FieldMoney")
	public Double getRentAmt() {
		return rentAmt;
	}

	public void setRentAmt(Double rentAmt) {
		this.rentAmt = rentAmt;
	}
	@PCell(cellType = Double.class ,no = 19, manualStyleName="rt002FieldMoney")
	public Double getServiceAmt() {
		return serviceAmt;
	}

	public void setServiceAmt(Double serviceAmt) {
		this.serviceAmt = serviceAmt;
	}

	public String getLesseeCompany() {
		return lesseeCompany;
	}

	public void setLesseeCompany(String lesseeCompany) {
		this.lesseeCompany = lesseeCompany;
	}

	public String getLesseeRegion() {
		return lesseeRegion;
	}

	public void setLesseeRegion(String lesseeRegion) {
		this.lesseeRegion = lesseeRegion;
	}

	public String getLesseeSiteType() {
		return lesseeSiteType;
	}

	public void setLesseeSiteType(String lesseeSiteType) {
		this.lesseeSiteType = lesseeSiteType;
	}
	public String getSubRentType() {
		return subRentType;
	}

	public void setSubRentType(String subRentType) {
		this.subRentType = subRentType;
	}

	public String getMonthYear() {
		return monthYear;
	}

	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}

	public Double getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}

	public Double getCreateAmt() {
		return createAmt;
	}

	public void setCreateAmt(Double createAmt) {
		this.createAmt = createAmt;
	}

	public Double getRemainAmt() {
		return remainAmt;
	}

	public void setRemainAmt(Double remainAmt) {
		this.remainAmt = remainAmt;
	}

	public String getSubRentSummaryType() {
		return subRentSummaryType;
	}

	public void setSubRentSummaryType(String subRentSummaryType) {
		this.subRentSummaryType = subRentSummaryType;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getContractNo1() {
		return contractNo1;
	}

	public void setContractNo1(String contractNo1) {
		this.contractNo1 = contractNo1;
	}

	public String getContractNo2() {
		return contractNo2;
	}

	public void setContractNo2(String contractNo2) {
		this.contractNo2 = contractNo2;
	}

	public String getContractNo3() {
		return contractNo3;
	}

	public void setContractNo3(String contractNo3) {
		this.contractNo3 = contractNo3;
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

	public String getRowID() {
		return rowID;
	}

	public void setRowID(String rowID) {
		this.rowID = rowID;
	}
	
	@PCell(cellType = String.class ,no = 0, manualStyleName="si002Field")
	public Integer getNo() {
		return No;
	}

	public void setNo(Integer no) {
		No = no;
	}

	public Date getEffDateFrom() {
		return effDateFrom;
	}

	public void setEffDateFrom(Date effDateFrom) {
		this.effDateFrom = effDateFrom;
	}

	public Date getExpDateTo() {
		return ExpDateTo;
	}

	public void setExpDateTo(Date expDateTo) {
		ExpDateTo = expDateTo;
	}
	@PCell(cellType = String.class ,no = 17, manualStyleName="si002Field")
	public String getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
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

	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContractAge() {
		return contractAge;
	}

	public void setContractAge(String contractAge) {
		this.contractAge = contractAge;
	}
	
	@PCell(cellType = String.class ,no = 5, manualStyleName="si002Field")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@PCell(cellType = String.class ,no = 6, manualStyleName="si002Field")
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@PCell(cellType = String.class ,no = 7, manualStyleName="si002Field")
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@PCell(cellType = String.class ,no = 8, manualStyleName="si002Field")
	public String getAmphur() {
		return amphur;
	}

	public void setAmphur(String amphur) {
		this.amphur = amphur;
	}

	@PCell(cellType = String.class ,no = 13, manualStyleName="si002Field")
	public String getDeckArea() {
		return deckArea;
	}

	public void setDeckArea(String deckArea) {
		this.deckArea = deckArea;
	}

	@PCell(cellType = String.class ,no = 14, manualStyleName="si002Field")
	public String getBuildingArea() {
		return buildingArea;
	}

	public void setBuildingArea(String buildingArea) {
		this.buildingArea = buildingArea;
	}

	@PCell(cellType = String.class ,no = 15, manualStyleName="si002Field")
	public String getRoomArea() {
		return roomArea;
	}

	public void setRoomArea(String roomArea) {
		this.roomArea = roomArea;
	}

	@PCell(cellType = String.class ,no = 16, manualStyleName="si002Field")
	public String getLandArea() {
		return landArea;
	}

	public void setLandArea(String landArea) {
		this.landArea = landArea;
	}

	@PCell(cellType = String.class ,no = 9, manualStyleName="si002Field")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@PCell(cellType = String.class ,no = 10, manualStyleName="si002Field")
	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getEffectiveDtStr() {
		return effectiveDtStr;
	}

	public void setEffectiveDtStr(String effectiveDtStr) {
		this.effectiveDtStr = effectiveDtStr;
	}

	public String getExpireDtStr() {
		return expireDtStr;
	}

	public void setExpireDtStr(String expireDtStr) {
		this.expireDtStr = expireDtStr;
	}

	public String getLesseeContractId() {
		return lesseeContractId;
	}

	public void setLesseeContractId(String lesseeContractId) {
		this.lesseeContractId = lesseeContractId;
	}

	public String getBorrowStatus() {
		return borrowStatus;
	}

	public void setBorrowStatus(String borrowStatus) {
		this.borrowStatus = borrowStatus;
	}

	public Double getDutyAmt() {
		return dutyAmt;
	}

	public void setDutyAmt(Double dutyAmt) {
		this.dutyAmt = dutyAmt;
	}

	public String getReqTypeName() {
		return reqTypeName;
	}

	public void setReqTypeName(String reqTypeName) {
		this.reqTypeName = reqTypeName;
	}

	public boolean isPico() {
		return isPico;
	}
	public void setPico(boolean isPico) {
		this.isPico = isPico;
	}

	public String getStrPico() {
		return strPico;
	}

	public void setStrPico(String strPico) {
		this.strPico = strPico;
	}
}
