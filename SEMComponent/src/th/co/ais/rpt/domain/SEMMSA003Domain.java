package th.co.ais.rpt.domain;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Date;
import java.util.List;

import th.co.ais.domain.sa.SiteAppReportObj;
import th.co.ais.rpt.util.DataUtil;

public class SEMMSA003Domain extends ReportDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 208011463913007912L;
	
	private String rowId = "";
	private String siteAppId = "";
	private String contractId = "";
	private BigDecimal contractTime;
	private BigDecimal contractTimeSeq;
	private String contractNo = "";
	private Date contractCancelDT;
	private String reqType = "";
	private String reqDocType = "";
	private String title = "";
	private String reqOfficer = "";
	private String reqOfficerManual = "";
	private String company = "";
	private String region = "";
	private String docNo = "";
	private Date docDt;
	private String docDtStr = "";
	private String docStatus = "";
	private String needLegApprove = "";
	private String needAVPApprove = "";
	private String locationId = "";
	private String locationCode = "";
	private String locationZone = "";
	private String IsCoLocate = "";
	private String coContractNo;
	private String terminateReason = "";
	private String terminateRemove = "";
	private String terminateRemoveFlag = "";
	private Date terminateRemoveDt;
	private Date terminateRemoveEndDt;
	private String terminateRemoveDtStr = "";
	private String terminateCancelRelateData = "";
	private String terminateNote = "";
	private String locationType = "";
	private String locationTypeText = "";
	private String locationAddressNo = "";
	private String locationBuilding = "";
	private String locationFloor = "";
	private String locationRoomNo = "";
	private String locationStreet = "";
	private String locationTambon = "";
	private String locationAmphurId = "";
	private String locationProvinceId = "";
	private String locationPostcode = "";
	private BigDecimal landArea = new BigDecimal(0);
	private String landAreaType = "";
	private String landAreaTypeStr = "";
	private BigDecimal deckArea = new BigDecimal(0);
	private BigDecimal buildingArea = new BigDecimal(0);
	private BigDecimal roomArea = new BigDecimal(0);
	private String areaRemark = "";
	private Date changeEffectiveDt;
	private String changeEffectiveDtStr;
	private Date effectiveDt;
	private String effectiveDtStr = "";
	private Date expireDt;
	private String expireDtTxt = "";
	private String expireDtStr = "";
	private BigDecimal ageYear = new BigDecimal(0);
	private BigDecimal ageMonth = new BigDecimal(0);
	private BigDecimal ageDay = new BigDecimal(0);
	private String contractWanted = "";
	private BigDecimal promiseRenewTime = new BigDecimal(0);
	private BigDecimal promiseRenewPeriod = new BigDecimal(0);
	private String promiseRenewPeriodType = "";
	private String lessorName = "";
	private String lessorHouseNo = "";
	private String lessorBuilding = "";
	private String lessorFloor = "";
	private String lessorRoomNo = "";
	private String lessorStreet = "";
	private String lessorTambon = "";
	private String lessorAmphurId = "";
	private String lessorProvinceId = "";
	private String postCode = "";
	private String contactName = "";
	private String contactTel = "";
	private String contactMobile = "";
	private String contactFax = "";
	private String contactEmail = "";
	private String contractTypeText = "";
	private BigDecimal rentAMT = new BigDecimal(0);
	private String rentAMTDesc = "";
	private String rentPeriodType = "";
	private String rentDetail = "";
	private String rentWhtType = "";
	private BigDecimal rentWhtRate = new BigDecimal(0);
	private String rentWhtRateMod = "";
	private BigDecimal rentServiceAmt = new BigDecimal(0);
	private String rentServiceAmtDesc = "";
	private String rentServicePeriodType = "";
	private String rentServiceDetail = "";
	private String rentServiceVatType = "";
	private String rentServiceWhtType = "";
	private BigDecimal rentServiceWhtRate = new BigDecimal(0);
	private String rentServiceWhtRateMod = "";
	private String rentAreaAmtMemo = "";
	private String rentServiceAmtMemo = "";
	private String rentSetupAmtMemo = "";
	private String rentOtherAmtMemo = "";
	private String rentSpacialAmtMemo = "";
	private BigDecimal totalRentService = new BigDecimal(0);
	private String rentPaymentPeriod = "";
	private String rentPaymentPeriodOTH = "";
	private String servPaymentPeriod = "";
	private String servPaymentPeriodOTH = "";
	private String rentDepositFlag = "";
	private BigDecimal rentDepositBGAmt = new BigDecimal(0);
	private String rentDepositBGVat = "";
	private BigDecimal rentDepositCashAmt = new BigDecimal(0);
	private String rentDepositCashVat = "";
	private String rentRemark = "";
	private String elUseMultiResourse = "";
	private String elUseNewMeter = "";
	private String elUseOldMeter = "";
	private String elUseOwner = "";
	private String elOwnerType = "";
	private String elPayOnPackage = "";
	private String elPackagePeriodType = "";
	private String elPayOnUsed = "";
	private BigDecimal elUnitPrice = new BigDecimal(0);
	private String elUnitPriceStr = "";
	private String elUnitPriceDesc = "";
	private String elVatType = "";
	private String elRemark = "";
	private String elDepositFlag = "";
	private BigDecimal elBGDeposit = new BigDecimal(0);
	private String elBGDepositVatType = "";
	private BigDecimal elCashDeposit = new BigDecimal(0);
	private String elCashDepositVatType = "";
	private String elDepositRemark = "";
	private String remarkSpacial = "";
	private String remarkDocuments = "";
	private String remarkContract = "";
	private String remarkAQM = "";
	private String remarkRisk = "";
	private String remarkLegal = "";
	private String remarkOther = "";
	private String PTTaxPayType = "";
	private String PTRemark = "";
	private String insFlag = "";
	private BigDecimal insSumInsured = new BigDecimal(0);
	private Date insEffectiveDT;
	private String insEffectiveDTStr = "";
	private Date insExpireDT;
	private String insExpireDTStr = "";
	private String insBeneficiary = "";
	private String mailName = "";
	private String mailHouseNo = "";
	private String mailBuilding = "";
	private String mailFloor = "";
	private String mailRoomNo = "";
	private String mailStreet = "";
	private String mailTambon = "";
	private String mailAmphurId = "";
	private String mailProvinceId = "";
	private String mailPostCode = "";
	private Date assignDT;
	private String assignDTStr = "";
	private String assignBy = "";
	private String assignToUser = "";
	private Date leaderApproveDT;
	private String leaderApproveDTStr = "";
	private String leaderApproveBy = "";
	private String leaderApproveRemark = "";
	private Date managerApproveDT;
	private String managerApproveDTStr = "";
	private String managerApproveBy = "";
	private String managerApproveRemark = "";
	private Date legalApproveDT;
	private String legalApproveDTStr = "";
	private String legalApproveBy = "";
	private String legalApproveRemark = "";
	private Date avpApproveDT;
	private String avpApproveDTStr = "";
	private String avpApproveBy = "";
	private String avpApproveRemark = "";
	private String FlowStatus = "";
	private String recordStatus = "";
	private String batchNo = "";
	private Date batchDT;
	private String batchDTStr = "";
	private String locationEditFlag = "";
	private String contractEditFlag = "";
	private String rentEditFlag = "";
	private String rentPositionEditFlag = "";
	private String elEditFlag = "";
	private String elPositionEditFlag = "";
	private String propertyTaxEditFlag = "";
	private String insuranceEditFlag = "";
	private String mailEditFlag = "";
	private Date createDT;
	private String createDTStr = "";
	private String createBy = "";
	private Date updateDT;
	private String updateDTStr = "";
	private String updateBy = "";
	private BigDecimal version = new BigDecimal(0);
	private String coLocateCompany = "";
	private String flowBy = "";
	private String flowRemark = "";
	private Date flowDT;
	private String flowDTStr = "";
	private String updateLog = "";
	private String assignToTeam = "";
	private String lessorTaxId = "";
	private BigDecimal elPayOnPackageAmt = new BigDecimal(0);
	private String elPayOnPackageAmtStr = "";
	private String elPayOnPackageAmtDesc = "";
	private String stationName = "";
	private String toAvpRemarkSpecial = "";
	private String phase = "";
	private String stationType = "";
	private String hadEleDeposit = "";
	private String electricDepositDetail = "";
	private String hadInsurance = "";
	private String insuranceDetail = "";
	private String attachDocument1 = "";
	private String attachDocument2 = "";
	private String landAndAreaTypeText;
	private boolean testCB;
	private BigDecimal rentAMTOld = new BigDecimal(0); 
	private String remarkAfterApprove = "";
	private String attachPlaceType = "";
	private String tickRentVatType = "";
	private String tickRentWhtType = "";
	private String tickServRenewCheckbox = "";
	private String tickServNewCheckbox = "";
	private String serviceFlag = "";
	private String tickRentServVatType = "";
	private String tickRentServWhtType = "";
	private String ptTaxPayType = "";
	private String docTypeHeader = "";
	private BigDecimal rentDepositAmt = new BigDecimal(0);
	private String rentDepositAmtStr = "";
	private BigDecimal rentDepositAmtRenew = new BigDecimal(0);
	private String rentDepositAmtRenewStr = "";
	private BigDecimal rentDepositAmtOld = new BigDecimal(0);
	private String rentDepositAmtOldStr = "";
	private BigDecimal rentDepositAmtAdd = new BigDecimal(0);
	private String rentDepositAmtAddStr = "";
	private String macro = "";
	private String micro = "";
	private String pico = "";
	private String repeater = "";
	private String towerType = "";
	private String wifi = "";
	private String fbb = "";
	private String ofc = "";
	private String fttx = "";
	private String otherType = "";
	private String otherTypeDetail = "";
	
	private String toPosition1 = "";
	private String toPosition2 = "";
	private String sitesTxt = "";
	private String changedSiteTxt = "";
	private String changedContractTxt = "";
	private String changedRentalTxt = "";
	private String changedElectricTxt = "";
	private String changedOtherTxt = "";
	private String coCompany = "";
	private String coCompanyContractNo = "";
	private String isSmallcellType = "";
	
	private BigDecimal rentOldAmt = new BigDecimal(0);
	private String rentOldAmtDesc = "";
	private BigDecimal rentServAmtOld = new BigDecimal(0);
	private String rentServAmtOldDesc = "";
	private BigDecimal rentServAmtRenew = new BigDecimal(0);
	private String servRenewPeriodType = "";
	private BigDecimal rentServAmtAdd = new BigDecimal(0);
	private String rentServAmtAddDesc = "";
	private BigDecimal rentAmtAddPerc = new BigDecimal(0);
	private String ServRenewPeriodTypeOld = "";
	
	private String rentAmtOldStr = "";
	private BigDecimal rentAmtAddPercStr = new BigDecimal(0);
	private String rentAmtAddPercTxt = "";
	private String rentAmtAddStr = "";
	private String rentAmtRenewStr = "";
	private BigDecimal rentAmtRenew = new BigDecimal(0);
	private String rentPeriodTypeRenew = "";
	private BigDecimal rentAmtAdd = new BigDecimal(0);
	private String rentAmtAddDesc = "";
	private BigDecimal rentAmtNew = new BigDecimal(0);
	private String rentAmtNewStr = "";
	private String rentAmtNewDesc = "";
	private BigDecimal servAmtOld = new BigDecimal(0);
	private String servAmtOldStr = "";
	private BigDecimal servAmtAddPercStr = new BigDecimal(0);
	private String servAmtAddPercTxt = "";
	private BigDecimal servAmtAdd = new BigDecimal(0);
	private String servAmtAddStr = "";
	private BigDecimal servAmtRenew = new BigDecimal(0);
	private String servAmtRenewStr = "";
	private String servAmtRenewStrDesc = "";
	private BigDecimal servAmtNew = new BigDecimal(0);
	private String servAmtNewStr = "";
	private String servAmtNewDesc = "";
	private String servNewPeriodType = "";
	private String tickRentNewCheckbox = "";
	private String rentCheckboxFlag = "";
	private String locationName = "";
	private String chkRtDeposBg = "";
	private String chkRtDeposCash = "";
	private String chkRtNoDepos = "";
	private String chkRtDeposNew = "";
	private String chkRtDeposRenew = "";
	private String tickRentRenewCheckbox = "";
	private String rentPeriodTypeNew = "";
	private String elUseOthSite = "";
	private String signPosition = "";
	private String elUseOthSiteContractNo = "";
	private String companyName = "";
	private String locationAddressText = "";
	private String areaText = "";
	private String approveRent = "";
	private String elNoExpenses = "";
	
	private String rentPeriodTypeOld = "";
	
	private String RENT_AREA_MEMO_VAT_TYPE = "";
	private String RENT_AREA_MEMO_WHT_TYPE = "";
	private String RENT_AREA_MEMO_WHT_RATE = "";
	private String RENT_SERV_MEMO_VAT_TYPE = "";
	private String RENT_SERV_MEMO_WHT_TYPE = "";
	private String RENT_SERV_MEMO_WHT_RATE = "";
	private String RENT_SETUP_MEMO_VAT_TYPE = "";
	private String RENT_SETUP_MEMO_WHT_TYPE = "";
	private String RENT_SETUP_MEMO_WHT_RATE = "";
	private String RENT_OTHER_MEMO_VAT_TYPE = "";
	private String RENT_OTHER_MEMO_WHT_TYPE = "";
	private String RENT_OTHER_MEMO_WHT_RATE = "";
	private String RENT_WHT_RATE = "";
	private String RENT_SERVICE_WHT_RATE = "";
	
//	Added by NEW 2018/11/02
	private Date TERMINATE_RENT_DT;
	private String RETURN_DEPOSIT_FLAG = "";	
	private BigDecimal RETURN_DEPOSIT_AMT =  new BigDecimal(0);	
	private Date RETURN_DEPOSIT_DT;	
	private String NO_RETURN_DEPOSIT_FLAG = "";	
	private String CANCEL_METER_FLAG = "";	
	private String TERMINATE_EL_FLAG = "";	
	private String OTHER_TERMINATE_FLAG = "";	
	private String OTHER_TERMINATE_NOTE = "";	
	private String OTHER_WAITING_FLAG = "";
	
	private List<SiteAppReportObj> rentalPaymentList;
	private List<SiteAppReportObj> servicePaymentList;
	private List<SiteAppReportObj> rtServDepositPaymentList;
	private List<SiteAppReportObj> bgDepositPaymentList;
	private List<SiteAppReportObj> cashDepositPaymentList;
	private List<SiteAppReportObj> elPaymentList;
	private List<SiteAppReportObj> elDepositPaymentList;
	private List<SiteAppReportObj> otherPaymentList;

	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getSiteAppId() {
		return siteAppId;
	}
	public void setSiteAppId(String siteAppId) {
		this.siteAppId = siteAppId;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public BigDecimal getContractTime() {
		return contractTime;
	}
	public void setContractTime(BigDecimal contractTime) {
		this.contractTime = contractTime;
	}
	public BigDecimal getContractTimeSeq() {
		return contractTimeSeq;
	}
	public void setContractTimeSeq(BigDecimal contractTimeSeq) {
		this.contractTimeSeq = contractTimeSeq;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getReqType() {
		return reqType;
	}
	public void setReqType(String reqType) {
		this.reqType = reqType;
	}
	public String getReqDocType() {
		return reqDocType;
	}
	public void setReqDocType(String reqDocType) {
		this.reqDocType = reqDocType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReqOfficer() {
		return reqOfficer;
	}
	public void setReqOfficer(String reqOfficer) {
		this.reqOfficer = reqOfficer;
	}
	public String getReqOfficerManual() {
		return reqOfficerManual;
	}
	public void setReqOfficerManual(String reqOfficerManual) {
		this.reqOfficerManual = reqOfficerManual;
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
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public Date getDocDt() {
		return docDt;
	}
	public void setDocDt(Date docDt) {
		this.docDt = docDt;
	}
	public String getDocDtStr() {
		return docDtStr;
	}
	public void setDocDtStr(String docDtStr) {
		this.docDtStr = docDtStr;
	}
	public String getDocStatus() {
		return docStatus;
	}
	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}
	public String getNeedLegApprove() {
		return needLegApprove;
	}
	public void setNeedLegApprove(String needLegApprove) {
		this.needLegApprove = needLegApprove;
	}
	public String getNeedAVPApprove() {
		return needAVPApprove;
	}
	public void setNeedAVPApprove(String needAVPApprove) {
		this.needAVPApprove = needAVPApprove;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getLocationZone() {
		return locationZone;
	}
	public void setLocationZone(String locationZone) {
		this.locationZone = locationZone;
	}
	public String getIsCoLocate() {
		return IsCoLocate;
	}
	public void setIsCoLocate(String isCoLocate) {
		IsCoLocate = isCoLocate;
	}
	public String getCoContractNo() {
		return coContractNo;
	}
	public void setCoContractNo(String coContractNo) {
		this.coContractNo = coContractNo;
	}
	public String getTerminateReason() {
		return terminateReason;
	}
	public void setTerminateReason(String terminateReason) {
		this.terminateReason = terminateReason;
	}
	public String getTerminateRemove() {
		return terminateRemove;
	}
	public void setTerminateRemove(String terminateRemove) {
		this.terminateRemove = terminateRemove;
	}
	public String getTerminateRemoveFlag() {
		return terminateRemoveFlag;
	}
	public void setTerminateRemoveFlag(String terminateRemoveFlag) {
		this.terminateRemoveFlag = terminateRemoveFlag;
	}
	public Date getTerminateRemoveDt() {
		return terminateRemoveDt;
	}
	public void setTerminateRemoveDt(Date terminateRemoveDt) {
		this.terminateRemoveDt = terminateRemoveDt;
	}
	public String getTerminateRemoveDtStr() {
		return terminateRemoveDtStr;
	}
	public void setTerminateRemoveDtStr(String terminateRemoveDtStr) {
		this.terminateRemoveDtStr = terminateRemoveDtStr;
	}
	public String getTerminateCancelRalateData() {
		return terminateCancelRelateData;
	}
	public void setTerminateCancelRalateData(String terminateCancelRelateData) {
		this.terminateCancelRelateData = terminateCancelRelateData;
	}
	public String getTerminateNote() {
		return terminateNote;
	}
	public void setTerminateNote(String terminateNote) {
		this.terminateNote = terminateNote;
	}
	public String getLocationType() {
		return locationType;
	}
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
	public String getLocationAddressNo() {
		return locationAddressNo;
	}
	public void setLocationAddressNo(String locationAddressNo) {
		this.locationAddressNo = locationAddressNo;
	}
	public String getLocationBuilding() {
		return locationBuilding;
	}
	public void setLocationBuilding(String locationBuilding) {
		this.locationBuilding = locationBuilding;
	}
	public String getLocationFloor() {
		return locationFloor;
	}
	public void setLocationFloor(String locationFloor) {
		this.locationFloor = locationFloor;
	}
	public String getLocationRoomNo() {
		return locationRoomNo;
	}
	public void setLocationRoomNo(String locationRoomNo) {
		this.locationRoomNo = locationRoomNo;
	}
	public String getLocationStreet() {
		return locationStreet;
	}
	public void setLocationStreet(String locationStreet) {
		this.locationStreet = locationStreet;
	}
	public String getLocationTambon() {
		return locationTambon;
	}
	public void setLocationTambon(String locationTambon) {
		this.locationTambon = locationTambon;
	}
	public String getLocationAmphurId() {
		return locationAmphurId;
	}
	public void setLocationAmphurId(String locationAmphurId) {
		this.locationAmphurId = locationAmphurId;
	}
	public String getLocationProvinceId() {
		return locationProvinceId;
	}
	public void setLocationProvinceId(String locationProvinceId) {
		this.locationProvinceId = locationProvinceId;
	}
	public String getLocationPostcode() {
		return locationPostcode;
	}
	public void setLocationPostcode(String locationPostcode) {
		this.locationPostcode = locationPostcode;
	}
	public BigDecimal getLandArea() {
		return landArea;
	}
	public void setLandArea(BigDecimal landArea) {
		this.landArea = landArea;
	}
	public String getLandAreaType() {
		return landAreaType;
	}
	public void setLandAreaType(String landAreaType) {
		this.landAreaType = landAreaType;
	}
	public BigDecimal getDeckArea() {
		return deckArea;
	}
	public void setDeckArea(BigDecimal deckArea) {
		this.deckArea = deckArea;
	}
	public BigDecimal getBuildingArea() {
		return buildingArea;
	}
	public void setBuildingArea(BigDecimal buildingArea) {
		this.buildingArea = buildingArea;
	}
	public BigDecimal getRoomArea() {
		return roomArea;
	}
	public void setRoomArea(BigDecimal roomArea) {
		this.roomArea = roomArea;
	}
	public String getAreaRemark() {
		return areaRemark;
	}
	public void setAreaRemark(String areaRemark) {
		this.areaRemark = areaRemark;
	}
	public Date getEffectiveDt() {
		return effectiveDt;
	}
	public void setEffectiveDt(Date effectiveDt) {
		this.effectiveDt = effectiveDt;
	}
	public String getEffectiveDtStr() {
		return effectiveDtStr;
	}
	public void setEffectiveDtStr(String effectiveDtStr) {
		this.effectiveDtStr = effectiveDtStr;
	}
	public Date getExpireDt() {
		return expireDt;
	}
	public void setExpireDt(Date expireDt) {
		this.expireDt = expireDt;
	}
	public String getExpireDtStr() {
		return expireDtStr;
	}
	public void setExpireDtStr(String expireDtStr) {
		this.expireDtStr = expireDtStr;
	}
	public BigDecimal getAgeYear() {
		return ageYear;
	}
	public void setAgeYear(BigDecimal ageYear) {
		this.ageYear = ageYear;
	}
	public BigDecimal getAgeMonth() {
		return ageMonth;
	}
	public void setAgeMonth(BigDecimal ageMonth) {
		this.ageMonth = ageMonth;
	}
	public BigDecimal getAgeDay() {
		return ageDay;
	}
	public void setAgeDay(BigDecimal ageDay) {
		this.ageDay = ageDay;
	}
	public String getContractWanted() {
		return contractWanted;
	}
	public void setContractWanted(String contractWanted) {
		this.contractWanted = contractWanted;
	}
	public BigDecimal getPromiseRenewTime() {
		return promiseRenewTime;
	}
	public void setPromiseRenewTime(BigDecimal promiseRenewTime) {
		this.promiseRenewTime = promiseRenewTime;
	}
	public BigDecimal getPromiseRenewPeriod() {
		return promiseRenewPeriod;
	}
	public void setPromiseRenewPeriod(BigDecimal promiseRenewPeriod) {
		this.promiseRenewPeriod = promiseRenewPeriod;
	}
	public String getPromiseRenewPeriodType() {
		return promiseRenewPeriodType;
	}
	public void setPromiseRenewPeriodType(String promiseRenewPeriodType) {
		this.promiseRenewPeriodType = promiseRenewPeriodType;
	}
	public String getLessorName() {
		return lessorName;
	}
	public void setLessorName(String lessorName) {
		this.lessorName = lessorName;
	}
	public String getLessorHouseNo() {
		return lessorHouseNo;
	}
	public void setLessorHouseNo(String lessorHouseNo) {
		this.lessorHouseNo = lessorHouseNo;
	}
	public String getLessorBuilding() {
		return lessorBuilding;
	}
	public void setLessorBuilding(String lessorBuilding) {
		this.lessorBuilding = lessorBuilding;
	}
	public String getLessorFloor() {
		return lessorFloor;
	}
	public void setLessorFloor(String lessorFloor) {
		this.lessorFloor = lessorFloor;
	}
	public String getLessorRoomNo() {
		return lessorRoomNo;
	}
	public void setLessorRoomNo(String lessorRoomNo) {
		this.lessorRoomNo = lessorRoomNo;
	}
	public String getLessorStreet() {
		return lessorStreet;
	}
	public void setLessorStreet(String lessorStreet) {
		this.lessorStreet = lessorStreet;
	}
	public String getLessorTambon() {
		return lessorTambon;
	}
	public void setLessorTambon(String lessorTambon) {
		this.lessorTambon = lessorTambon;
	}
	public String getLessorAmphurId() {
		return lessorAmphurId;
	}
	public void setLessorAmphurId(String lessorAmphurId) {
		this.lessorAmphurId = lessorAmphurId;
	}
	public String getLessorProvinceId() {
		return lessorProvinceId;
	}
	public void setLessorProvinceId(String lessorProvinceId) {
		this.lessorProvinceId = lessorProvinceId;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	public BigDecimal getRentAMT() {
		return rentAMT;
	}
	public void setRentAMT(BigDecimal rentAMT) {
		this.rentAMT = rentAMT;
	}
	
	public String getRentAMTDesc() {
		return DataUtil.convert2ThaiBathSA(getRentAMT());
	}
	public void setRentAMTDesc(String rentAMTDesc) {
		this.rentAMTDesc = rentAMTDesc;
	}
	
	public String getRentPeriodType() {
		return rentPeriodType;
	}
	public void setRentPeriodType(String rentPeriodType) {
		this.rentPeriodType = rentPeriodType;
	}
	public String getRentDetail() {
		return rentDetail;
	}
	public void setRentDetail(String rentDetail) {
		this.rentDetail = rentDetail;
	}
	public String getRentWhtType() {
		return rentWhtType;
	}
	public void setRentWhtType(String rentWhtType) {
		this.rentWhtType = rentWhtType;
	}
	public BigDecimal getRentWhtRate() {
		return rentWhtRate;
	}
	public void setRentWhtRate(BigDecimal rentWhtRate) {
		this.rentWhtRate = rentWhtRate;
	}
	public String getRentWhtRateMod() {
		return rentWhtRateMod;
	}
	public void setRentWhtRateMod(String rentWhtRateMod) {
		this.rentWhtRateMod = rentWhtRateMod;
	}
	public BigDecimal getRentServiceAmt() {
		return rentServiceAmt;
	}
	public void setRentServiceAmt(BigDecimal rentServiceAmt) {
		this.rentServiceAmt = rentServiceAmt;
	}
	
	public String getRentServiceAmtDesc() {
		return DataUtil.convert2ThaiBathSA(getRentServiceAmt());
	}
	public void setRentServiceAmtDesc(String rentServiceAmtDesc) {
		this.rentServiceAmtDesc = rentServiceAmtDesc;
	}
	public String getRentServicePeriodType() {
		return rentServicePeriodType;
	}
	public void setRentServicePeriodType(String rentServicePeriodType) {
		this.rentServicePeriodType = rentServicePeriodType;
	}
	public String getRentServiceDetail() {
		return rentServiceDetail;
	}
	public void setRentServiceDetail(String rentServiceDetail) {
		this.rentServiceDetail = rentServiceDetail;
	}
	public String getRentServiceVatType() {
		return rentServiceVatType;
	}
	public void setRentServiceVatType(String rentServiceVatType) {
		this.rentServiceVatType = rentServiceVatType;
	}
	public String getRentServiceWhtType() {
		return rentServiceWhtType;
	}
	public void setRentServiceWhtType(String rentServiceWhtType) {
		this.rentServiceWhtType = rentServiceWhtType;
	}
	public BigDecimal getRentServiceWhtRate() {
		return rentServiceWhtRate;
	}
	public void setRentServiceWhtRate(BigDecimal rentServiceWhtRate) {
		this.rentServiceWhtRate = rentServiceWhtRate;
	}
	public String getRentServiceWhtRateMod() {
		return rentServiceWhtRateMod;
	}
	public void setRentServiceWhtRateMod(String rentServiceWhtRateMod) {
		this.rentServiceWhtRateMod = rentServiceWhtRateMod;
	}
	public String getRentAreaAmtMemo() {
		return rentAreaAmtMemo;
	}
	public void setRentAreaAmtMemo(String rentAreaAmtMemo) {
		this.rentAreaAmtMemo = rentAreaAmtMemo;
	}
	public String getRentServiceAmtMemo() {
		return rentServiceAmtMemo;
	}
	public void setRentServiceAmtMemo(String rentServiceAmtMemo) {
		this.rentServiceAmtMemo = rentServiceAmtMemo;
	}
	public String getRentSetupAmtMemo() {
		return rentSetupAmtMemo;
	}
	public void setRentSetupAmtMemo(String rentSetupAmtMemo) {
		this.rentSetupAmtMemo = rentSetupAmtMemo;
	}
	public String getRentOtherAmtMemo() {
		return rentOtherAmtMemo;
	}
	public void setRentOtherAmtMemo(String rentOtherAmtMemo) {
		this.rentOtherAmtMemo = rentOtherAmtMemo;
	}
	public String getRentSpacialAmtMemo() {
		return rentSpacialAmtMemo;
	}
	public void setRentSpacialAmtMemo(String rentSpacialAmtMemo) {
		this.rentSpacialAmtMemo = rentSpacialAmtMemo;
	}
	public BigDecimal getTotalRentService() {
		return totalRentService;
	}
	public void setTotalRentService(BigDecimal totalRentService) {
		this.totalRentService = totalRentService;
	}
	public String getRentPaymentPeriod() {
		return rentPaymentPeriod;
	}
	public void setRentPaymentPeriod(String rentPaymentPeriod) {
		this.rentPaymentPeriod = rentPaymentPeriod;
	}
	public String getRentPaymentPeriodOTH() {
		return rentPaymentPeriodOTH;
	}
	public void setRentPaymentPeriodOTH(String rentPaymentPeriodOTH) {
		this.rentPaymentPeriodOTH = rentPaymentPeriodOTH;
	}
	public String getRentDepositFlag() {
		return rentDepositFlag;
	}
	public void setRentDepositFlag(String rentDepositFlag) {
		this.rentDepositFlag = rentDepositFlag;
	}
	public BigDecimal getRentDepositBGAmt() {
		return rentDepositBGAmt;
	}
	public void setRentDepositBGAmt(BigDecimal rentDepositBGAmt) {
		this.rentDepositBGAmt = rentDepositBGAmt;
	}
	public String getRentDepositBGVat() {
		return rentDepositBGVat;
	}
	public void setRentDepositBGVat(String rentDepositBGVat) {
		this.rentDepositBGVat = rentDepositBGVat;
	}
	public BigDecimal getRentDepositCashAmt() {
		return rentDepositCashAmt;
	}
	public void setRentDepositCashAmt(BigDecimal rentDepositCashAmt) {
		this.rentDepositCashAmt = rentDepositCashAmt;
	}
	public String getRentDepositCashVat() {
		return rentDepositCashVat;
	}
	public void setRentDepositCashVat(String rentDepositCashVat) {
		this.rentDepositCashVat = rentDepositCashVat;
	}
	public String getRentRemark() {
		return rentRemark;
	}
	public void setRentRemark(String rentRemark) {
		this.rentRemark = rentRemark;
	}
	public String getElUseMultiResourse() {
		return elUseMultiResourse;
	}
	public void setElUseMultiResourse(String elUseMultiResourse) {
		this.elUseMultiResourse = elUseMultiResourse;
	}
	public String getElUseNewMeter() {
		return elUseNewMeter;
	}
	public void setElUseNewMeter(String elUseNewMeter) {
		this.elUseNewMeter = elUseNewMeter;
	}
	public String getElUseOldMeter() {
		return elUseOldMeter;
	}
	public void setElUseOldMeter(String elUseOldMeter) {
		this.elUseOldMeter = elUseOldMeter;
	}
	public String getElUseOwner() {
		return elUseOwner;
	}
	public void setElUseOwner(String elUseOwner) {
		this.elUseOwner = elUseOwner;
	}
	public String getElOwnerType() {
		return elOwnerType;
	}
	public void setElOwnerType(String elOwnerType) {
		this.elOwnerType = elOwnerType;
	}
	public String getElPayOnPackage() {
		return elPayOnPackage;
	}
	public void setElPayOnPackage(String elPayOnPackage) {
		this.elPayOnPackage = elPayOnPackage;
	}
	public String getElPackagePeriodType() {
		return elPackagePeriodType;
	}
	public void setElPackagePeriodType(String elPackagePeriodType) {
		this.elPackagePeriodType = elPackagePeriodType;
	}
	public String getElPayOnUsed() {
		return elPayOnUsed;
	}
	public void setElPayOnUsed(String elPayOnUsed) {
		this.elPayOnUsed = elPayOnUsed;
	}
	public BigDecimal getElUnitPrice() {
		return elUnitPrice;
	}
	public void setElUnitPrice(BigDecimal elUnitPrice) {
		this.elUnitPrice = elUnitPrice;
	}
	public String getElUnitPriceStr() {
		return DataUtil.setFormatDecmal(getElUnitPrice());
	}
	public void setElUnitPriceStr(String elUnitPriceStr) {
		this.elUnitPriceStr = elUnitPriceStr;
	}
	public String getElVatType() {
		return elVatType;
	}
	public void setElVatType(String elVatType) {
		this.elVatType = elVatType;
	}
	public String getElRemark() {
		return elRemark;
	}
	public void setElRemark(String elRemark) {
		this.elRemark = elRemark;
	}
	public String getElDepositFlag() {
		return elDepositFlag;
	}
	public void setElDepositFlag(String elDepositFlag) {
		this.elDepositFlag = elDepositFlag;
	}
	public BigDecimal getElBGDeposit() {
		return elBGDeposit;
	}
	public void setElBGDeposit(BigDecimal elBGDeposit) {
		this.elBGDeposit = elBGDeposit;
	}
	public String getElBGDepositVatType() {
		return elBGDepositVatType;
	}
	public void setElBGDepositVatType(String elBGDepositVatType) {
		this.elBGDepositVatType = elBGDepositVatType;
	}
	public BigDecimal getElCashDeposit() {
		return elCashDeposit;
	}
	public void setElCashDeposit(BigDecimal elCashDeposit) {
		this.elCashDeposit = elCashDeposit;
	}
	public String getElCashDepositVatType() {
		return elCashDepositVatType;
	}
	public void setElCashDepositVatType(String elCashDepositVatType) {
		this.elCashDepositVatType = elCashDepositVatType;
	}
	public String getElDepositRemark() {
		return elDepositRemark;
	}
	public void setElDepositRemark(String elDepositRemark) {
		this.elDepositRemark = elDepositRemark;
	}
	public String getRemarkSpacial() {
		return remarkSpacial;
	}
	public void setRemarkSpacial(String remarkSpacial) {
		this.remarkSpacial = remarkSpacial;
	}
	public String getRemarkDocuments() {
		return remarkDocuments;
	}
	public void setRemarkDocuments(String remarkDocuments) {
		this.remarkDocuments = remarkDocuments;
	}
	public String getRemarkContract() {
		return remarkContract;
	}
	public void setRemarkContract(String remarkContract) {
		this.remarkContract = remarkContract;
	}
	public String getRemarkAQM() {
		return remarkAQM;
	}
	public void setRemarkAQM(String remarkAQM) {
		this.remarkAQM = remarkAQM;
	}
	public String getRemarkRisk() {
		return remarkRisk;
	}
	public void setRemarkRisk(String remarkRisk) {
		this.remarkRisk = remarkRisk;
	}
	public String getRemarkLegal() {
		return remarkLegal;
	}
	public void setRemarkLegal(String remarkLegal) {
		this.remarkLegal = remarkLegal;
	}
	public String getRemarkOther() {
		return remarkOther;
	}
	public void setRemarkOther(String remarkOther) {
		this.remarkOther = remarkOther;
	}
	public String getPTTaxPayType() {
		return PTTaxPayType;
	}
	public void setPTTaxPayType(String pTTaxPayType) {
		PTTaxPayType = pTTaxPayType;
	}
	public String getPTRemark() {
		return PTRemark;
	}
	public void setPTRemark(String pTRemark) {
		PTRemark = pTRemark;
	}
	public String getInsFlag() {
		return insFlag;
	}
	public void setInsFlag(String insFlag) {
		this.insFlag = insFlag;
	}
	public BigDecimal getInsSumInsured() {
		return insSumInsured;
	}
	public void setInsSumInsured(BigDecimal insSumInsured) {
		this.insSumInsured = insSumInsured;
	}
	public Date getInsEffectiveDT() {
		return insEffectiveDT;
	}
	public void setInsEffectiveDT(Date insEffectiveDT) {
		this.insEffectiveDT = insEffectiveDT;
	}
	public String getInsEffectiveDTStr() {
		return insEffectiveDTStr;
	}
	public void setInsEffectiveDTStr(String insEffectiveDTStr) {
		this.insEffectiveDTStr = insEffectiveDTStr;
	}
	public Date getInsExpireDT() {
		return insExpireDT;
	}
	public void setInsExpireDT(Date insExpireDT) {
		this.insExpireDT = insExpireDT;
	}
	public String getInsExpireDTStr() {
		return insExpireDTStr;
	}
	public void setInsExpireDTStr(String insExpireDTStr) {
		this.insExpireDTStr = insExpireDTStr;
	}
	public String getInsBeneficiary() {
		return insBeneficiary;
	}
	public void setInsBeneficiary(String insBeneficiary) {
		this.insBeneficiary = insBeneficiary;
	}
	public String getMailName() {
		return mailName;
	}
	public void setMailName(String mailName) {
		this.mailName = mailName;
	}
	public String getMailHouseNo() {
		return mailHouseNo;
	}
	public void setMailHouseNo(String mailHouseNo) {
		this.mailHouseNo = mailHouseNo;
	}
	public String getMailBuilding() {
		return mailBuilding;
	}
	public void setMailBuilding(String mailBuilding) {
		this.mailBuilding = mailBuilding;
	}
	public String getMailFloor() {
		return mailFloor;
	}
	public void setMailFloor(String mailFloor) {
		this.mailFloor = mailFloor;
	}
	public String getMailRoomNo() {
		return mailRoomNo;
	}
	public void setMailRoomNo(String mailRoomNo) {
		this.mailRoomNo = mailRoomNo;
	}
	public String getMailStreet() {
		return mailStreet;
	}
	public void setMailStreet(String mailStreet) {
		this.mailStreet = mailStreet;
	}
	public String getMailTambon() {
		return mailTambon;
	}
	public void setMailTambon(String mailTambon) {
		this.mailTambon = mailTambon;
	}
	public String getMailAmphurId() {
		return mailAmphurId;
	}
	public void setMailAmphurId(String mailAmphurId) {
		this.mailAmphurId = mailAmphurId;
	}
	public String getMailProvinceId() {
		return mailProvinceId;
	}
	public void setMailProvinceId(String mailProvinceId) {
		this.mailProvinceId = mailProvinceId;
	}
	public String getMailPostCode() {
		return mailPostCode;
	}
	public void setMailPostCode(String mailPostCode) {
		this.mailPostCode = mailPostCode;
	}
	public Date getAssignDT() {
		return assignDT;
	}
	public void setAssignDT(Date assignDT) {
		this.assignDT = assignDT;
	}
	public String getAssignDTStr() {
		return assignDTStr;
	}
	public void setAssignDTStr(String assignDTStr) {
		this.assignDTStr = assignDTStr;
	}
	public String getAssignBy() {
		return assignBy;
	}
	public void setAssignBy(String assignBy) {
		this.assignBy = assignBy;
	}
	public String getAssignToUser() {
		return assignToUser;
	}
	public void setAssignToUser(String assignToUser) {
		this.assignToUser = assignToUser;
	}
	public Date getLeaderApproveDT() {
		return leaderApproveDT;
	}
	public void setLeaderApproveDT(Date leaderApproveDT) {
		this.leaderApproveDT = leaderApproveDT;
	}
	public String getLeaderApproveDTStr() {
		return leaderApproveDTStr;
	}
	public void setLeaderApproveDTStr(String leaderApproveDTStr) {
		this.leaderApproveDTStr = leaderApproveDTStr;
	}
	public String getLeaderApproveBy() {
		return leaderApproveBy;
	}
	public void setLeaderApproveBy(String leaderApproveBy) {
		this.leaderApproveBy = leaderApproveBy;
	}
	public String getLeaderApproveRemark() {
		return leaderApproveRemark;
	}
	public void setLeaderApproveRemark(String leaderApproveRemark) {
		this.leaderApproveRemark = leaderApproveRemark;
	}
	public Date getManagerApproveDT() {
		return managerApproveDT;
	}
	public void setManagerApproveDT(Date managerApproveDT) {
		this.managerApproveDT = managerApproveDT;
	}
	public String getManagerApproveDTStr() {
		return managerApproveDTStr;
	}
	public void setManagerApproveDTStr(String managerApproveDTStr) {
		this.managerApproveDTStr = managerApproveDTStr;
	}
	public String getManagerApproveBy() {
		return managerApproveBy;
	}
	public void setManagerApproveBy(String managerApproveBy) {
		this.managerApproveBy = managerApproveBy;
	}
	public String getManagerApproveRemark() {
		return managerApproveRemark;
	}
	public void setManagerApproveRemark(String managerApproveRemark) {
		this.managerApproveRemark = managerApproveRemark;
	}
	public Date getLegalApproveDT() {
		return legalApproveDT;
	}
	public void setLegalApproveDT(Date legalApproveDT) {
		this.legalApproveDT = legalApproveDT;
	}
	public String getLegalApproveDTStr() {
		return legalApproveDTStr;
	}
	public void setLegalApproveDTStr(String legalApproveDTStr) {
		this.legalApproveDTStr = legalApproveDTStr;
	}
	public String getLegalApproveBy() {
		return legalApproveBy;
	}
	public void setLegalApproveBy(String legalApproveBy) {
		this.legalApproveBy = legalApproveBy;
	}
	public String getLegalApproveRemark() {
		return legalApproveRemark;
	}
	public void setLegalApproveRemark(String legalApproveRemark) {
		this.legalApproveRemark = legalApproveRemark;
	}
	public Date getAvpApproveDT() {
		return avpApproveDT;
	}
	public void setAvpApproveDT(Date avpApproveDT) {
		this.avpApproveDT = avpApproveDT;
	}
	public String getAvpApproveDTStr() {
		return avpApproveDTStr;
	}
	public void setAvpApproveDTStr(String avpApproveDTStr) {
		this.avpApproveDTStr = avpApproveDTStr;
	}
	public String getAvpApproveBy() {
		return avpApproveBy;
	}
	public void setAvpApproveBy(String avpApproveBy) {
		this.avpApproveBy = avpApproveBy;
	}
	public String getAvpApproveRemark() {
		return avpApproveRemark;
	}
	public void setAvpApproveRemark(String avpApproveRemark) {
		this.avpApproveRemark = avpApproveRemark;
	}
	public String getFlowStatus() {
		return FlowStatus;
	}
	public void setFlowStatus(String flowStatus) {
		FlowStatus = flowStatus;
	}
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public Date getBatchDT() {
		return batchDT;
	}
	public void setBatchDT(Date batchDT) {
		this.batchDT = batchDT;
	}
	public String getBatchDTStr() {
		return batchDTStr;
	}
	public void setBatchDTStr(String batchDTStr) {
		this.batchDTStr = batchDTStr;
	}
	public String getLocationEditFlag() {
		return locationEditFlag;
	}
	public void setLocationEditFlag(String locationEditFlag) {
		this.locationEditFlag = locationEditFlag;
	}
	public String getContractEditFlag() {
		return contractEditFlag;
	}
	public void setContractEditFlag(String contractEditFlag) {
		this.contractEditFlag = contractEditFlag;
	}
	public String getRentEditFlag() {
		return rentEditFlag;
	}
	public void setRentEditFlag(String rentEditFlag) {
		this.rentEditFlag = rentEditFlag;
	}
	public String getRentPositionEditFlag() {
		return rentPositionEditFlag;
	}
	public void setRentPositionEditFlag(String rentPositionEditFlag) {
		this.rentPositionEditFlag = rentPositionEditFlag;
	}
	public String getElEditFlag() {
		return elEditFlag;
	}
	public void setElEditFlag(String elEditFlag) {
		this.elEditFlag = elEditFlag;
	}
	public String getElPositionEditFlag() {
		return elPositionEditFlag;
	}
	public void setElPositionEditFlag(String elPositionEditFlag) {
		this.elPositionEditFlag = elPositionEditFlag;
	}
	public String getPropertyTaxEditFlag() {
		return propertyTaxEditFlag;
	}
	public void setPropertyTaxEditFlag(String propertyTaxEditFlag) {
		this.propertyTaxEditFlag = propertyTaxEditFlag;
	}
	public String getInsuranceEditFlag() {
		return insuranceEditFlag;
	}
	public void setInsuranceEditFlag(String insuranceEditFlag) {
		this.insuranceEditFlag = insuranceEditFlag;
	}
	public String getMailEditFlag() {
		return mailEditFlag;
	}
	public void setMailEditFlag(String mailEditFlag) {
		this.mailEditFlag = mailEditFlag;
	}
	public Date getCreateDT() {
		return createDT;
	}
	public void setCreateDT(Date createDT) {
		this.createDT = createDT;
	}
	public String getCreateDTStr() {
		return createDTStr;
	}
	public void setCreateDTStr(String createDTStr) {
		this.createDTStr = createDTStr;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
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
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public BigDecimal getVersion() {
		return version;
	}
	public void setVersion(BigDecimal version) {
		this.version = version;
	}
	public String getCoLocateCompany() {
		return coLocateCompany;
	}
	public void setCoLocateCompany(String coLocateCompany) {
		this.coLocateCompany = coLocateCompany;
	}
	public String getFlowBy() {
		return flowBy;
	}
	public void setFlowBy(String flowBy) {
		this.flowBy = flowBy;
	}
	public String getFlowRemark() {
		return flowRemark;
	}
	public void setFlowRemark(String flowRemark) {
		this.flowRemark = flowRemark;
	}
	public Date getFlowDT() {
		return flowDT;
	}
	public void setFlowDT(Date flowDT) {
		this.flowDT = flowDT;
	}
	public String getFlowDTStr() {
		return flowDTStr;
	}
	public void setFlowDTStr(String flowDTStr) {
		this.flowDTStr = flowDTStr;
	}
	public String getUpdateLog() {
		return updateLog;
	}
	public void setUpdateLog(String updateLog) {
		this.updateLog = updateLog;
	}
	public String getAssignToTeam() {
		return assignToTeam;
	}
	public void setAssignToTeam(String assignToTeam) {
		this.assignToTeam = assignToTeam;
	}
	public String getLessorTaxId() {
		return lessorTaxId;
	}
	public void setLessorTaxId(String lessorTaxId) {
		this.lessorTaxId = lessorTaxId;
	}
	public BigDecimal getElPayOnPackageAmt() {
		return elPayOnPackageAmt;
	}
	public void setElPayOnPackageAmt(BigDecimal elPayOnPackageAmt) {
		this.elPayOnPackageAmt = elPayOnPackageAmt;
	}
	public String getElPayOnPackageAmtStr() {
		return DataUtil.setFormatDecmal(getElPayOnPackageAmt());
	}
	public void setElPayOnPackageAmtStr(String elPayOnPackageAmtStr) {
		this.elPayOnPackageAmtStr = elPayOnPackageAmtStr;
	}
	public String getElPayOnPackageAmtDesc() {
		return DataUtil.convert2ThaiBathSA(getElPayOnPackageAmt());
	}
	public void setElPayOnPackageAmtDesc(String elPayOnPackageAmtDesc) {
		this.elPayOnPackageAmtDesc = elPayOnPackageAmtDesc;
	}
	public Date getContractCancelDT() {
		return contractCancelDT;
	}
	public void setContractCancelDT(Date contractCancelDT) {
		this.contractCancelDT = contractCancelDT;
	}
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	public String getTerminateCancelRelateData() {
		return terminateCancelRelateData;
	}
	public void setTerminateCancelRelateData(String terminateCancelRelateData) {
		this.terminateCancelRelateData = terminateCancelRelateData;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getLocationTypeText() {
		return locationTypeText;
	}
	public void setLocationTypeText(String locationTypeText) {
		this.locationTypeText = locationTypeText;
	}
	
	public String getToAvpRemarkSpecial() {
		return toAvpRemarkSpecial;
	}
	public void setToAvpRemarkSpecial(String toAvpRemarkSpecial) {
		this.toAvpRemarkSpecial = toAvpRemarkSpecial;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public String getStationType() {
		return stationType;
	}
	public void setStationType(String stationType) {
		this.stationType = stationType;
	}
	public String getHadEleDeposit() {
		return hadEleDeposit;
	}
	public void setHadEleDeposit(String hadEleDeposit) {
		this.hadEleDeposit = hadEleDeposit;
	}
	public String getElectricDepositDetail() {
		return electricDepositDetail;
	}
	public void setElectricDepositDetail(String electricDepositDetail) {
		this.electricDepositDetail = electricDepositDetail;
	}
	public String getHadInsurance() {
		return hadInsurance;
	}
	public void setHadInsurance(String hadInsurance) {
		this.hadInsurance = hadInsurance;
	}
	public String getInsuranceDetail() {
		return insuranceDetail;
	}
	public void setInsuranceDetail(String insuranceDetail) {
		this.insuranceDetail = insuranceDetail;
	}
	public String getAttachDocument1() {
		return attachDocument1;
	}
	public void setAttachDocument1(String attachDocument1) {
		this.attachDocument1 = attachDocument1;
	}
	public String getAttachDocument2() {
		return attachDocument2;
	}
	public void setAttachDocument2(String attachDocument2) {
		this.attachDocument2 = attachDocument2;
	}
	public String getLandAndAreaTypeText() {
		return landAndAreaTypeText;
	}
	public void setLandAndAreaTypeText(String landAndAreaTypeText) {
		this.landAndAreaTypeText = landAndAreaTypeText;
	}
	public boolean isTestCB() {
		testCB = true;
		return testCB;
	}
	public void setTestCB(boolean testCB) {
		this.testCB = testCB;
	}
	
	public String getRemarkAfterApprove() {
		return remarkAfterApprove;
	}
	public void setRemarkAfterApprove(String remarkAfterApprove) {
		this.remarkAfterApprove = remarkAfterApprove;
	}
	public String getAttachPlaceType() {
		return attachPlaceType;
	}
	public void setAttachPlaceType(String attachPlaceType) {
		this.attachPlaceType = attachPlaceType;
	}
	public String getTickRentVatType() {
		return tickRentVatType;
	}
	public void setTickRentVatType(String tickRentVatType) {
		this.tickRentVatType = tickRentVatType;
	}
	public String getTickRentWhtType() {
		return tickRentWhtType;
	}
	public void setTickRentWhtType(String tickRentWhtType) {
		this.tickRentWhtType = tickRentWhtType;
	}
	public String getTickServRenewCheckbox() {
		return tickServRenewCheckbox;
	}
	public void setTickServRenewCheckbox(String tickServRenewCheckboox) {
		this.tickServRenewCheckbox = tickServRenewCheckboox;
	}
	public String getTickServNewCheckboox() {
		return tickServNewCheckbox;
	}
	public void setTickServNewCheckbox(String tickServNewCheckboox) {
		this.tickServNewCheckbox = tickServNewCheckboox;
	}
	public String getTickRentServVatType() {
		return tickRentServVatType;
	}
	public void setTickRentServVatType(String tickRentServVatType) {
		this.tickRentServVatType = tickRentServVatType;
	}
	public String getTickRentServWhtType() {
		return tickRentServWhtType;
	}
	public void setTickRentServWhtType(String tickRentServWhtType) {
		this.tickRentServWhtType = tickRentServWhtType;
	}
	public String getPtTaxPayType() {
		return ptTaxPayType;
	}
	public void setPtTaxPayType(String ptTaxPayType) {
		this.ptTaxPayType = ptTaxPayType;
	}
	public String getDocTypeHeader() {
		return docTypeHeader;
	}
	public void setDocTypeHeader(String docTypeHeader) {
		this.docTypeHeader = docTypeHeader;
	}
	
	public String getTickServNewCheckbox() {
		return tickServNewCheckbox;
	}
	public String getMacro() {
		return macro;
	}
	public void setMacro(String macro) {
		this.macro = macro;
	}
	public String getMicro() {
		return micro;
	}
	public void setMicro(String micro) {
		this.micro = micro;
	}
	public String getPico() {
		return pico;
	}
	public void setPico(String pico) {
		this.pico = pico;
	}
	public String getRepeater() {
		return repeater;
	}
	public void setRepeater(String repeater) {
		this.repeater = repeater;
	}
	public String getTowerType() {
		return towerType;
	}
	public void setTowerType(String towerType) {
		this.towerType = towerType;
	}
	public String getWifi() {
		return wifi;
	}
	public void setWifi(String wifi) {
		this.wifi = wifi;
	}
	public String getOtherType() {
		return otherType;
	}
	public void setOtherType(String otherType) {
		this.otherType = otherType;
	}
	public String getOtherTypeDetail() {
		return otherTypeDetail;
	}
	public void setOtherTypeDetail(String otherTypeDetail) {
		this.otherTypeDetail = otherTypeDetail;
	}
	public String getToPosition1() {
		return toPosition1;
	}
	public void setToPosition1(String toPosition1) {
		this.toPosition1 = toPosition1;
	}
	public String getToPosition2() {
		return toPosition2;
	}
	public void setToPosition2(String toPosition2) {
		this.toPosition2 = toPosition2;
	}
	public String getSitesTxt() {
		return sitesTxt;
	}
	public void setSitesTxt(String sitesTxt) {
		this.sitesTxt = sitesTxt;
	}
	public String getChangedSiteTxt() {
		return changedSiteTxt;
	}
	public void setChangedSiteTxt(String changedSiteTxt) {
		this.changedSiteTxt = changedSiteTxt;
	}
	public String getChangedContractTxt() {
		return changedContractTxt;
	}
	public void setChangedContractTxt(String changedContractTxt) {
		this.changedContractTxt = changedContractTxt;
	}
	public String getChangedRentalTxt() {
		return changedRentalTxt;
	}
	public void setChangedRentalTxt(String changedRentalTxt) {
		this.changedRentalTxt = changedRentalTxt;
	}
	public String getChangedElectricTxt() {
		return changedElectricTxt;
	}
	public void setChangedElectricTxt(String changedElectricTxt) {
		this.changedElectricTxt = changedElectricTxt;
	}
	public String getCoCompany() {
		return coCompany;
	}
	public void setCoCompany(String coCompany) {
		this.coCompany = coCompany;
	}
	public String getCoCompanyContractNo() {
		return coCompanyContractNo;
	}
	public void setCoCompanyContractNo(String coCompanyContractNo) {
		this.coCompanyContractNo = coCompanyContractNo;
	}
	public String getIsSmallcellType() {
		return isSmallcellType;
	}
	public void setIsSmallcellType(String isSmallcellType) {
		this.isSmallcellType = isSmallcellType;
	}
	public BigDecimal getRentOldAmt() {
		return rentOldAmt;
	}
	public void setRentOldAmt(BigDecimal rentOldAmt) {
		this.rentOldAmt = rentOldAmt;
	}
	public BigDecimal getRentServAmtOld() {
		return rentServAmtOld;
	}
	public void setRentServAmtOld(BigDecimal rentServAmtOld) {
		this.rentServAmtOld = rentServAmtOld;
	}
	public BigDecimal getRentServAmtRenew() {
		return rentServAmtRenew;
	}
	public void setRentServAmtRenew(BigDecimal rentServAmtRenew) {
		this.rentServAmtRenew = rentServAmtRenew;
	}
	public BigDecimal getRentServAmtAdd() {
		return rentServAmtAdd;
	}
	public void setRentServAmtAdd(BigDecimal rentServAmtAdd) {
		this.rentServAmtAdd = rentServAmtAdd;
	}
	public BigDecimal getRentAmtAddPerc() {
		return rentAmtAddPerc;
	}
	public void setRentAmtAddPerc(BigDecimal rentAmtAddPerc) {
		this.rentAmtAddPerc = rentAmtAddPerc;
	}
	public String getServRenewPeriodTypeOld() {
		return ServRenewPeriodTypeOld;
	}
	public void setServRenewPeriodTypeOld(String servRenewPeriodTypeOld) {
		ServRenewPeriodTypeOld = servRenewPeriodTypeOld;
	}
	public String getServRenewPeriodType() {
		return servRenewPeriodType;
	}
	public void setServRenewPeriodType(String servRenewPeriodType) {
		this.servRenewPeriodType = servRenewPeriodType;
	}
	
	public String getRentPeriodTypeRenew() {
		return rentPeriodTypeRenew;
	}
	public void setRentPeriodTypeRenew(String rentPeriodTypeRenew) {
		this.rentPeriodTypeRenew = rentPeriodTypeRenew;
	}
	public BigDecimal getRentAmtAdd() {
		return rentAmtAdd;
	}
	public void setRentAmtAdd(BigDecimal rentAmtAdd) {
		this.rentAmtAdd = rentAmtAdd;
	}
	
	public String getServNewPeriodType() {
		return servNewPeriodType;
	}
	public void setServNewPeriodType(String servNewPeriodType) {
		this.servNewPeriodType = servNewPeriodType;
	}
	public String getTickRentNewCheckbox() {
		return tickRentNewCheckbox;
	}
	public void setTickRentNewCheckbox(String tickRentNewCheckbox) {
		this.tickRentNewCheckbox = tickRentNewCheckbox;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	public String getRentOldAmtDesc() {
		return DataUtil.convert2ThaiBathSA(getRentOldAmt());
	}
	public void setRentOldAmtDesc(String rentOldAmtDesc) {
		this.rentOldAmtDesc = rentOldAmtDesc;
	}
	public String getChkRtDeposBg() {
		return chkRtDeposBg;
	}
	public void setChkRtDeposBg(String chkRtDeposBg) {
		this.chkRtDeposBg = chkRtDeposBg;
	}
	public String getChkRtDeposCash() {
		return chkRtDeposCash;
	}
	public void setChkRtDeposCash(String chkRtDeposCash) {
		this.chkRtDeposCash = chkRtDeposCash;
	}
	public String getChkRtNoDepos() {
		return chkRtNoDepos;
	}
	public void setChkRtNoDepos(String chkRtNoDepos) {
		this.chkRtNoDepos = chkRtNoDepos;
	}
	public String getChkRtDeposNew() {
		return chkRtDeposNew;
	}
	public void setChkRtDeposNew(String chkRtDeposNew) {
		this.chkRtDeposNew = chkRtDeposNew;
	}
	public String getRentServAmtOldDesc() {
		return DataUtil.convert2ThaiBathSA(getRentServAmtOld());
	}
	public void setRentServAmtOldDesc(String rentServAmtOldDesc) {
		this.rentServAmtOldDesc = rentServAmtOldDesc;
	}
	public String getRentServAmtAddDesc() {
		return DataUtil.convert2ThaiBathSA(getRentServAmtAdd());
	}
	public void setRentServAmtAddDesc(String rentServAmtAddDesc) {
		this.rentServAmtAddDesc = rentServAmtAddDesc;
	}
	public String getRentAmtAddDesc() {
		return DataUtil.convert2ThaiBathSA(getRentAmtAdd());
	}
	public void setRentAmtAddDesc(String rentAmtAddDesc) {
		this.rentAmtAddDesc = rentAmtAddDesc;
	}
	public BigDecimal getRentAMTOld() {
		return rentAMTOld;
	}
	public void setRentAMTOld(BigDecimal rentAMTOld) {
		this.rentAMTOld = rentAMTOld;
	}
	public BigDecimal getRentDepositAmt() {
		return rentDepositAmt;
	}
	public void setRentDepositAmt(BigDecimal rentDepositAmt) {
		this.rentDepositAmt = rentDepositAmt;
	}
	public String getRentDepositAmtStr() {
		return DataUtil.setFormatDecmal(getRentDepositAmt());
	}
	public void setRentDepositAmtStr(String rentDepositAmtStr) {
		this.rentDepositAmtStr = rentDepositAmtStr;
	}
	public BigDecimal getRentDepositAmtOld() {
		return rentDepositAmtOld;
	}
	public void setRentDepositAmtOld(BigDecimal rentDepositAmtOld) {
		this.rentDepositAmtOld = rentDepositAmtOld;
	}
	public String getRentDepositAmtOldStr() {
		return DataUtil.setFormatDecmal(getRentDepositAmtOld());
	}
	public void setRentDepositAmtOldStr(String rentDepositAmtOldStr) {
		this.rentDepositAmtOldStr = rentDepositAmtOldStr;
	}
	public BigDecimal getRentDepositAmtAdd() {
		return rentDepositAmtAdd;
	}
	public void setRentDepositAmtAdd(BigDecimal rentDepositAmtAdd) {
		this.rentDepositAmtAdd = rentDepositAmtAdd;
	}
	public String getRentDepositAmtAddStr() {
		return DataUtil.setFormatDecmal(getRentDepositAmtAdd());
	}
	public void setRentDepositAmtAddStr(String rentDepositAmtAddStr) {
		this.rentDepositAmtAddStr = rentDepositAmtAddStr;
	}
	public String getRentAmtOldStr() {
		return DataUtil.setFormatDecmal(getRentAMTOld());
	}
	public void setRentAmtOldStr(String rentAmtOldStr) {
		this.rentAmtOldStr = rentAmtOldStr;
	}
	public BigDecimal getRentAmtAddPercStr() {
		return rentAmtAddPercStr;
	}
	public void setRentAmtAddPercStr(BigDecimal rentAmtAddPercStr) {
		this.rentAmtAddPercStr = rentAmtAddPercStr;
	}
	public String getRentAmtAddPercTxt() {
		return DataUtil.setFormatDecmal(getRentAmtAddPercStr());
	}
	public void setRentAmtAddPercTxt(String rentAmtAddPercTxt) {
		this.rentAmtAddPercTxt = rentAmtAddPercTxt;
	}
	public String getRentAmtAddStr() {
		return DataUtil.setFormatDecmal(getRentAmtAdd());
	}
	public void setRentAmtAddStr(String rentAmtAddStr) {
		this.rentAmtAddStr = rentAmtAddStr;
	}
	public String getRentAmtRenewStr() {
		return DataUtil.setFormatDecmal(getRentAmtRenew());
	}
	public void setRentAmtRenewStr(String rentAmtRenewStr) {
		this.rentAmtRenewStr = rentAmtRenewStr;
	}
	public BigDecimal getRentAmtRenew() {
		return rentAmtRenew;
	}
	public void setRentAmtRenew(BigDecimal rentAmtRenew) {
		this.rentAmtRenew = rentAmtRenew;
	}
	public BigDecimal getRentAmtNew() {
		return rentAmtNew;
	}
	public void setRentAmtNew(BigDecimal rentAmtNew) {
		this.rentAmtNew = rentAmtNew;
	}
	public String getRentAmtNewStr() {
		return DataUtil.setFormatDecmal(getRentAmtNew());
	}
	public void setRentAmtNewStr(String rentAmtNewStr) {
		this.rentAmtNewStr = rentAmtNewStr;
	}
	public String getRentAmtNewDesc() {
		return DataUtil.convert2ThaiBathSA(getRentAmtNew());
	}
	public void setRentAmtNewDesc(String rentAmtNewDesc) {
		this.rentAmtNewDesc = rentAmtNewDesc;
	}
	public BigDecimal getServAmtOld() {
		return servAmtOld;
	}
	public void setServAmtOld(BigDecimal servAmtOld) {
		this.servAmtOld = servAmtOld;
	}
	public String getServAmtOldStr() {
		return DataUtil.setFormatDecmal(getServAmtOld());
	}
	public void setServAmtOldStr(String servAmtOldStr) {
		this.servAmtOldStr = servAmtOldStr;
	}
	public BigDecimal getServAmtAddPercStr() {
		return servAmtAddPercStr;
	}
	public void setServAmtAddPercStr(BigDecimal servAmtAddPercStr) {
		this.servAmtAddPercStr = servAmtAddPercStr;
	}
	public String getServAmtAddPercTxt() {
		return DataUtil.setFormatDecmal(getServAmtAddPercStr());
	}
	public void setServAmtAddPercTxt(String servAmtAddPercTxt) {
		this.servAmtAddPercTxt = servAmtAddPercTxt;
	}
	public BigDecimal getServAmtAdd() {
		return servAmtAdd;
	}
	public void setServAmtAdd(BigDecimal servAmtAdd) {
		this.servAmtAdd = servAmtAdd;
	}
	public String getServAmtAddStr() {
		return DataUtil.setFormatDecmal(getServAmtAdd());
	}
	public void setServAmtAddStr(String servAmtAddStr) {
		this.servAmtAddStr = servAmtAddStr;
	}
	public BigDecimal getServAmtRenew() {
		return servAmtRenew;
	}
	public void setServAmtRenew(BigDecimal servAmtRenew) {
		this.servAmtRenew = servAmtRenew;
	}
	public String getServAmtRenewStr() {
		return DataUtil.setFormatDecmal(getServAmtRenew());
	}
	public void setServAmtRenewStr(String servAmtRenewStr) {
		this.servAmtRenewStr = servAmtRenewStr;
	}
	public BigDecimal getServAmtNew() {
		return servAmtNew;
	}
	public void setServAmtNew(BigDecimal servAmtNew) {
		this.servAmtNew = servAmtNew;
	}
	public String getServAmtNewStr() {
		return DataUtil.setFormatDecmal(getServAmtNew());
	}
	public void setServAmtNewStr(String servAmtNewStr) {
		this.servAmtNewStr = servAmtNewStr;
	}
	public String getServAmtNewDesc() {
		return DataUtil.convert2ThaiBathSA(getServAmtNew());
	}
	public void setServAmtNewDesc(String servAmtNewDesc) {
		this.servAmtNewDesc = servAmtNewDesc;
	}
	public String getTickRentRenewCheckbox() {
		return tickRentRenewCheckbox;
	}
	public void setTickRentRenewCheckbox(String tickRentRenewCheckbox) {
		this.tickRentRenewCheckbox = tickRentRenewCheckbox;
	}
	public String getRentPeriodTypeNew() {
		return rentPeriodTypeNew;
	}
	public void setRentPeriodTypeNew(String rentPeriodTypeNew) {
		this.rentPeriodTypeNew = rentPeriodTypeNew;
	}
	public String getElUseOthSite() {
		return elUseOthSite;
	}
	public void setElUseOthSite(String elUseOthSite) {
		this.elUseOthSite = elUseOthSite;
	}
	public String getSignPosition() {
		return signPosition;
	}
	public void setSignPosition(String signPosition) {
		this.signPosition = signPosition;
	}
	public String getElUseOthSiteContractNo() {
		return elUseOthSiteContractNo;
	}
	public void setElUseOthSiteContractNo(String elUseOthSiteContractNo) {
		this.elUseOthSiteContractNo = elUseOthSiteContractNo;
	}
	public String getElUnitPriceDesc() {
		return DataUtil.convert2ThaiBathSA(getElUnitPrice());
	}
	public void setElUnitPriceDesc(String elUnitPriceDesc) {
		this.elUnitPriceDesc = elUnitPriceDesc;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactTel() {
		return contactTel;
	}
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}
	public String getContactMobile() {
		return contactMobile;
	}
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}
	public String getContactFax() {
		return contactFax;
	}
	public void setContactFax(String contactFax) {
		this.contactFax = contactFax;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getContractTypeText() {
		return contractTypeText;
	}
	public void setContractTypeText(String contractTypeText) {
		this.contractTypeText = contractTypeText;
	}
	public String getServAmtRenewStrDesc() {
		return DataUtil.convert2ThaiBathSA(getServAmtRenew());
	}
	public void setServAmtRenewStrDesc(String servAmtRenewStrDesc) {
		this.servAmtRenewStrDesc = servAmtRenewStrDesc;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getChangedOtherTxt() {
		return changedOtherTxt;
	}
	public void setChangedOtherTxt(String changedOtherTxt) {
		this.changedOtherTxt = changedOtherTxt;
	}
	public String getServPaymentPeriod() {
		return servPaymentPeriod;
	}
	public void setServPaymentPeriod(String servPaymentPeriod) {
		this.servPaymentPeriod = servPaymentPeriod;
	}
	public String getServPaymentPeriodOTH() {
		return servPaymentPeriodOTH;
	}
	public void setServPaymentPeriodOTH(String servPaymentPeriodOTH) {
		this.servPaymentPeriodOTH = servPaymentPeriodOTH;
	}
	public String getFbb() {
		return fbb;
	}
	public void setFbb(String fbb) {
		this.fbb = fbb;
	}
	public String getOfc() {
		return ofc;
	}
	public void setOfc(String ofc) {
		this.ofc = ofc;
	}
	public String getFttx() {
		return fttx;
	}
	public void setFttx(String fttx) {
		this.fttx = fttx;
	}
	public Date getChangeEffectiveDt() {
		return changeEffectiveDt;
	}
	public void setChangeEffectiveDt(Date changeEffectiveDt) {
		this.changeEffectiveDt = changeEffectiveDt;
	}
	public String getChangeEffectiveDtStr() {
		return changeEffectiveDtStr;
	}
	public void setChangeEffectiveDtStr(String changeEffectiveDtStr) {
		this.changeEffectiveDtStr = changeEffectiveDtStr;
	}
	public String getLandAreaTypeStr() {
		if(landAreaType != null){
			if("01".equals(landAreaType))
				landAreaTypeStr = "ตารางวา";
			else if("02".equals(landAreaType))
				landAreaTypeStr = "ตารางเมตร";
		}
		return landAreaTypeStr;
	}
	public void setLandAreaTypeStr(String landAreaTypeStr) {
		this.landAreaTypeStr = landAreaTypeStr;
	}
	public String getLocationAddressText() {
		return locationAddressText;
	}
	public void setLocationAddressText(String locationAddressText) {
		this.locationAddressText = locationAddressText;
	}
	public String getAreaText() {
		return areaText;
	}
	public void setAreaText(String areaText) {
		this.areaText = areaText;
	}
	public String getChkRtDeposRenew() {
		return chkRtDeposRenew;
	}
	public void setChkRtDeposRenew(String chkRtDeposRenew) {
		this.chkRtDeposRenew = chkRtDeposRenew;
	}
	public BigDecimal getRentDepositAmtRenew() {
		return rentDepositAmtRenew;
	}
	public void setRentDepositAmtRenew(BigDecimal rentDepositAmtRenew) {
		this.rentDepositAmtRenew = rentDepositAmtRenew;
	}
	public String getRentDepositAmtRenewStr() {
		return DataUtil.setFormatDecmal(getRentDepositAmtRenew());
	}
	public void setRentDepositAmtRenewStr(String rentDepositAmtRenewStr) {
		this.rentDepositAmtRenewStr = rentDepositAmtRenewStr;
	}
	public String getExpireDtTxt() {
		return expireDtTxt;
	}
	public void setExpireDtTxt(String expireDtTxt) {
		this.expireDtTxt = expireDtTxt;
	}
	public String getApproveRent() {
		return approveRent;
	}
	public void setApproveRent(String approveRent) {
		this.approveRent = approveRent;
	}
	public Date getTerminateRemoveEndDt() {
		return terminateRemoveEndDt;
	}
	public void setTerminateRemoveEndDt(Date terminateRemoveEndDt) {
		this.terminateRemoveEndDt = terminateRemoveEndDt;
	}
	public String getElNoExpenses() {
		return elNoExpenses;
	}
	public void setElNoExpenses(String elNoExpenses) {
		this.elNoExpenses = elNoExpenses;
	}
	public BigDecimal setFormatDecmal(BigDecimal num){
		String strange = "#,###.00";
		DecimalFormatSymbols decimal_format_symbols = new DecimalFormatSymbols ();
		BigDecimal fn = new BigDecimal(0);
		try{
			DecimalFormat weirdFormatter = new DecimalFormat(strange, decimal_format_symbols);
			weirdFormatter.setGroupingSize(4);
			String bizarre = weirdFormatter.format(num);
			System.out.println("bizarre.indexOf = "+num.toString().indexOf("."));
			if(bizarre.indexOf(".") > 0){
				fn = new BigDecimal(Double.parseDouble(bizarre));
				System.out.println("fn = "+fn);
			}else{
				System.out.println("num = "+num);
				return num;
			}
			fn = new BigDecimal(Double.parseDouble(bizarre));
			System.out.println("fn = "+fn);
		}catch (Exception e) {
			e.printStackTrace();
			
			// TODO: handle exception
		}
		return fn;
	}
	public String getRentPeriodTypeOld() {
		return rentPeriodTypeOld;
	}
	public void setRentPeriodTypeOld(String rentPeriodTypeOld) {
		this.rentPeriodTypeOld = rentPeriodTypeOld;
	}
	public String getServiceFlag() {
		serviceFlag = "";
		if(!"Y".equals(getTickServNewCheckbox()) && !"Y".equals(getTickServRenewCheckbox())){
			serviceFlag = "Y";
		}
		return serviceFlag;
	}
	public void setServiceFlag(String serviceFlag) {
		this.serviceFlag = serviceFlag;
	}
	public String getRentCheckboxFlag() {
		rentCheckboxFlag = "";
		if(!"Y".equals(getTickRentNewCheckbox()) && !"Y".equals(getTickRentRenewCheckbox())){
			rentCheckboxFlag = "Y";
		}
		return rentCheckboxFlag;
	}
	public void setRentCheckboxFlag(String rentCheckboxFlag) {
		this.rentCheckboxFlag = rentCheckboxFlag;
	}
	public String getRENT_AREA_MEMO_VAT_TYPE() {
		return RENT_AREA_MEMO_VAT_TYPE;
	}
	public void setRENT_AREA_MEMO_VAT_TYPE(String rENTAREAMEMOVATTYPE) {
		RENT_AREA_MEMO_VAT_TYPE = rENTAREAMEMOVATTYPE;
	}
	public String getRENT_AREA_MEMO_WHT_TYPE() {
		return RENT_AREA_MEMO_WHT_TYPE;
	}
	public void setRENT_AREA_MEMO_WHT_TYPE(String rENTAREAMEMOWHTTYPE) {
		RENT_AREA_MEMO_WHT_TYPE = rENTAREAMEMOWHTTYPE;
	}
	public String getRENT_AREA_MEMO_WHT_RATE() {
		return RENT_AREA_MEMO_WHT_RATE;
	}
	public void setRENT_AREA_MEMO_WHT_RATE(String rENTAREAMEMOWHTRATE) {
		RENT_AREA_MEMO_WHT_RATE = rENTAREAMEMOWHTRATE;
	}
	public String getRENT_SERV_MEMO_VAT_TYPE() {
		return RENT_SERV_MEMO_VAT_TYPE;
	}
	public void setRENT_SERV_MEMO_VAT_TYPE(String rENTSERVMEMOVATTYPE) {
		RENT_SERV_MEMO_VAT_TYPE = rENTSERVMEMOVATTYPE;
	}
	public String getRENT_SERV_MEMO_WHT_TYPE() {
		return RENT_SERV_MEMO_WHT_TYPE;
	}
	public void setRENT_SERV_MEMO_WHT_TYPE(String rENTSERVMEMOWHTTYPE) {
		RENT_SERV_MEMO_WHT_TYPE = rENTSERVMEMOWHTTYPE;
	}
	public String getRENT_SERV_MEMO_WHT_RATE() {
		return RENT_SERV_MEMO_WHT_RATE;
	}
	public void setRENT_SERV_MEMO_WHT_RATE(String rENTSERVMEMOWHTRATE) {
		RENT_SERV_MEMO_WHT_RATE = rENTSERVMEMOWHTRATE;
	}
	public String getRENT_SETUP_MEMO_VAT_TYPE() {
		return RENT_SETUP_MEMO_VAT_TYPE;
	}
	public void setRENT_SETUP_MEMO_VAT_TYPE(String rENTSETUPMEMOVATTYPE) {
		RENT_SETUP_MEMO_VAT_TYPE = rENTSETUPMEMOVATTYPE;
	}
	public String getRENT_SETUP_MEMO_WHT_TYPE() {
		return RENT_SETUP_MEMO_WHT_TYPE;
	}
	public void setRENT_SETUP_MEMO_WHT_TYPE(String rENTSETUPMEMOWHTTYPE) {
		RENT_SETUP_MEMO_WHT_TYPE = rENTSETUPMEMOWHTTYPE;
	}
	public String getRENT_SETUP_MEMO_WHT_RATE() {
		return RENT_SETUP_MEMO_WHT_RATE;
	}
	public void setRENT_SETUP_MEMO_WHT_RATE(String rENTSETUPMEMOWHTRATE) {
		RENT_SETUP_MEMO_WHT_RATE = rENTSETUPMEMOWHTRATE;
	}
	public String getRENT_OTHER_MEMO_VAT_TYPE() {
		return RENT_OTHER_MEMO_VAT_TYPE;
	}
	public void setRENT_OTHER_MEMO_VAT_TYPE(String rENTOTHERMEMOVATTYPE) {
		RENT_OTHER_MEMO_VAT_TYPE = rENTOTHERMEMOVATTYPE;
	}
	public String getRENT_OTHER_MEMO_WHT_TYPE() {
		return RENT_OTHER_MEMO_WHT_TYPE;
	}
	public void setRENT_OTHER_MEMO_WHT_TYPE(String rENTOTHERMEMOWHTTYPE) {
		RENT_OTHER_MEMO_WHT_TYPE = rENTOTHERMEMOWHTTYPE;
	}
	public String getRENT_OTHER_MEMO_WHT_RATE() {
		return RENT_OTHER_MEMO_WHT_RATE;
	}
	public void setRENT_OTHER_MEMO_WHT_RATE(String rENTOTHERMEMOWHTRATE) {
		RENT_OTHER_MEMO_WHT_RATE = rENTOTHERMEMOWHTRATE;
	}
	public String getRENT_WHT_RATE() {
		return RENT_WHT_RATE;
	}
	public void setRENT_WHT_RATE(String rENTWHTRATE) {
		RENT_WHT_RATE = rENTWHTRATE;
	}
	public String getRENT_SERVICE_WHT_RATE() {
		return RENT_SERVICE_WHT_RATE;
	}
	public void setRENT_SERVICE_WHT_RATE(String rENTSERVICEWHTRATE) {
		RENT_SERVICE_WHT_RATE = rENTSERVICEWHTRATE;
	}
	public Date getTERMINATE_RENT_DT() {
		return TERMINATE_RENT_DT;
	}
	public void setTERMINATE_RENT_DT(Date tERMINATERENTDT) {
		TERMINATE_RENT_DT = tERMINATERENTDT;
	}
	public String getRETURN_DEPOSIT_FLAG() {
		return RETURN_DEPOSIT_FLAG;
	}
	public void setRETURN_DEPOSIT_FLAG(String rETURNDEPOSITFLAG) {
		RETURN_DEPOSIT_FLAG = rETURNDEPOSITFLAG;
	}
	public BigDecimal getRETURN_DEPOSIT_AMT() {
		return RETURN_DEPOSIT_AMT;
	}
	public void setRETURN_DEPOSIT_AMT(BigDecimal rETURNDEPOSITAMT) {
		RETURN_DEPOSIT_AMT = rETURNDEPOSITAMT;
	}
	public Date getRETURN_DEPOSIT_DT() {
		return RETURN_DEPOSIT_DT;
	}
	public void setRETURN_DEPOSIT_DT(Date rETURNDEPOSITDT) {
		RETURN_DEPOSIT_DT = rETURNDEPOSITDT;
	}
	public String getNO_RETURN_DEPOSIT_FLAG() {
		return NO_RETURN_DEPOSIT_FLAG;
	}
	public void setNO_RETURN_DEPOSIT_FLAG(String nORETURNDEPOSITFLAG) {
		NO_RETURN_DEPOSIT_FLAG = nORETURNDEPOSITFLAG;
	}
	public String getCANCEL_METER_FLAG() {
		return CANCEL_METER_FLAG;
	}
	public void setCANCEL_METER_FLAG(String cANCELMETERFLAG) {
		CANCEL_METER_FLAG = cANCELMETERFLAG;
	}
	public String getTERMINATE_EL_FLAG() {
		return TERMINATE_EL_FLAG;
	}
	public void setTERMINATE_EL_FLAG(String tERMINATEELFLAG) {
		TERMINATE_EL_FLAG = tERMINATEELFLAG;
	}
	public String getOTHER_TERMINATE_FLAG() {
		return OTHER_TERMINATE_FLAG;
	}
	public void setOTHER_TERMINATE_FLAG(String oTHERTERMINATEFLAG) {
		OTHER_TERMINATE_FLAG = oTHERTERMINATEFLAG;
	}
	public String getOTHER_TERMINATE_NOTE() {
		return OTHER_TERMINATE_NOTE;
	}
	public void setOTHER_TERMINATE_NOTE(String oTHERTERMINATENOTE) {
		OTHER_TERMINATE_NOTE = oTHERTERMINATENOTE;
	}
	public String getOTHER_WAITING_FLAG() {
		return OTHER_WAITING_FLAG;
	}
	public void setOTHER_WAITING_FLAG(String oTHERWAITINGFLAG) {
		OTHER_WAITING_FLAG = oTHERWAITINGFLAG;
	}
	public List<SiteAppReportObj> getRentalPaymentList() {
		return rentalPaymentList;
	}
	public void setRentalPaymentList(List<SiteAppReportObj> rentalPaymentList) {
		this.rentalPaymentList = rentalPaymentList;
	}
	public List<SiteAppReportObj> getServicePaymentList() {
		return servicePaymentList;
	}
	public void setServicePaymentList(List<SiteAppReportObj> servicePaymentList) {
		this.servicePaymentList = servicePaymentList;
	}
	public List<SiteAppReportObj> getBgDepositPaymentList() {
		return bgDepositPaymentList;
	}
	public void setBgDepositPaymentList(List<SiteAppReportObj> bgDepositPaymentList) {
		this.bgDepositPaymentList = bgDepositPaymentList;
	}
	public List<SiteAppReportObj> getCashDepositPaymentList() {
		return cashDepositPaymentList;
	}
	public void setCashDepositPaymentList(
			List<SiteAppReportObj> cashDepositPaymentList) {
		this.cashDepositPaymentList = cashDepositPaymentList;
	}
	public List<SiteAppReportObj> getElDepositPaymentList() {
		return elDepositPaymentList;
	}
	public void setElDepositPaymentList(List<SiteAppReportObj> elDepositPaymentList) {
		this.elDepositPaymentList = elDepositPaymentList;
	}
	public List<SiteAppReportObj> getRtServDepositPaymentList() {
		return rtServDepositPaymentList;
	}
	public void setRtServDepositPaymentList(
			List<SiteAppReportObj> rtServDepositPaymentList) {
		this.rtServDepositPaymentList = rtServDepositPaymentList;
	}
	public List<SiteAppReportObj> getElPaymentList() {
		return elPaymentList;
	}
	public void setElPaymentList(List<SiteAppReportObj> elPaymentList) {
		this.elPaymentList = elPaymentList;
	}
	public List<SiteAppReportObj> getOtherPaymentList() {
		return otherPaymentList;
	}
	public void setOtherPaymentList(List<SiteAppReportObj> otherPaymentList) {
		this.otherPaymentList = otherPaymentList;
	}
	
}
