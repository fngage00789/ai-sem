package th.co.ais.domain.sa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Msa003ReportParam extends AbstractDomain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2960256732811707335L;
	
	private String rowId;
	private String siteAppId;
	private String contractId;
	private BigDecimal contractTime;
	private BigDecimal contractTimeSeq;
	private String contractNo;
	private String reqType;
	private String reqDocType;
	private String docTypeText;
	private String title;
	private String reqOfficer;
	private String reqOfficerManual;
	private String company;
	private String region;
	private String docNo;
	private Date docDt;
	private String docDtStr;
	private String docStatus;
	private String needLegApprove;
	private String needAVPApprove;
	private String locationId;
	private String locationZone;
	private String IsCoLocate;
	private String coContractNo;
	private String terminateReason;
	private String terminateRemove;
	private String terminateRemoveFlag;
	private Date terminateRemoveDt;
	private String terminateRemoveDtStr;
	private String terminateCancelRelateData;
	private String terminateNote;
	private String locationType;
	private String locationAddressNo;
	private String locationBuilding;
	private String locationFloor;
	private String locationRoomNo;
	private String locationStreet;
	private String locationTambon;
	private String locationAmphurId;
	private String locationProvinceId;
	private String locationPostcode;
	private BigDecimal landArea;
	private String landAreaType;
	private BigDecimal deckArea;
	private BigDecimal buildingArea;
	private BigDecimal roomArea;
	private String areaRemark;
	private Date effectiveDt;
	private String effectiveDtStr;
	private Date expireDt;
	private String expireDtStr;
	private BigDecimal ageYear;
	private BigDecimal ageMonth;
	private BigDecimal ageDay;
	private String contractWanted;
	private BigDecimal promiseRenewTime;
	private BigDecimal promiseRenewPeriod;
	private String promiseRenewPeriodType;
	private String lessorName;
	private String lessorHouseNo;
	private String lessorBuilding;
	private String lessorFloor;
	private String lessorRoomNo;
	private String lessorStreet;
	private String lessorTambon;
	private String lessorAmphurId;
	private String lessorProvinceId;
	private String postCode;
	private String contractName;
	private String contractTel;
	private String contractMobile;
	private String contractFax;
	private String contractEmail;
	private BigDecimal rentAMT;
	private String rentPeriodType;
	private String rentDetail;
	private String rentWhtType;
	private BigDecimal rentWhtRate;
	private String rentWhtRateMod;
	private BigDecimal rentServiceAmt;
	private String rentServicePeriodType;
	private String rentServiceDetail;
	private String rentServiceVatType;
	private String rentServiceWhtType;
	private BigDecimal rentServiceWhtRate;
	private String rentServiceWhtRateMod;
	private String rentAreaAmtMemo;
	private String rentServiceAmtMemo;
	private String rentSetupAmtMemo;
	private String rentOtherAmtMemo;
	private String rentSpacialAmtMemo;
	private BigDecimal totalRentService;
	private String rentPaymentPeriod;
	private String rentPaymentPeriodOTH;
	private String rentDepositFlag;
	private BigDecimal rentDepositBGAmt;
	private String rentDepositBGVat;
	private BigDecimal rentDepositCashAmt;
	private String rentDepositCashVat;
	private String rentRemark;
	private String elUseMultiResourse;
	private String elUseNewMeter;
	private String elUseOldMeter;
	private String elUseOwner;
	private String elOwnerType;
	private String elPayOnPackage;
	private String elPackagePeriodType;
	private String elPayOnUsed;
	private BigDecimal elUnitPrice;
	private String elVatType;
	private String elRemark;
	private String elDepositFlag;
	private BigDecimal elBGDeposit;
	private String elBGDepositVatType;
	private BigDecimal elCashDeposit;
	private String elCashDepositVatType;
	private String elDepositRemark;
	private String remarkSpacial;
	private String remarkDocuments;
	private String remarkContract;
	private String remarkAQM;
	private String remarkRisk;
	private String remarkLegal;
	private String remarkOther;
	private String PTTaxPayType;
	private String PTRemark;
	private String insFlag;
	private BigDecimal insSumInsured;
	private Date insEffectiveDT;
	private String insEffectiveDTStr;
	private Date insExpireDT;
	private String insExpireDTStr;
	private String insBeneficiary;
	private String mailName;
	private String mailHouseNo;
	private String mailBuilding;
	private String mailFloor;
	private String mailRoomNo;
	private String mailStreet;
	private String mailTambon;
	private String mailAmphurId;
	private String mailProvinceId;
	private String mailPostCode;
	private Date assignDT;
	private String assignDTStr;
	private String assignBy;
	private String assignToUser;
	private Date leaderApproveDT;
	private String leaderApproveDTStr;
	private String leaderApproveBy;
	private String leaderApproveRemark;
	private Date managerApproveDT;
	private String managerApproveDTStr;
	private String managerApproveBy;
	private String managerApproveRemark;
	private Date legalApproveDT;
	private String legalApproveDTStr;
	private String legalApproveBy;
	private String legalApproveRemark;
	private Date avpApproveDT;
	private String avpApproveDTStr;
	private String avpApproveBy;
	private String avpApproveRemark;
	private String FlowStatus;
	private String recordStatus;
	private String batchNo;
	private Date batchDT;
	private String batchDTStr;
	private String locationEditFlag;
	private String contractEditFlag;
	private String rentEditFlag;
	private String rentPositionEditFlag;
	private String elEditFlag;
	private String elPositionEditFlag;
	private String propertyTaxEditFlag;
	private String insuranceEditFlag;
	private String mailEditFlag;
	private Date createDT;
	private String createDTStr;
	private String createBy;
	private Date updateDT;
	private String updateDTStr;
	private String updateBy;
	private BigDecimal version;
	private String coLocateCompany;
	private String flowBy;
	private String flowRemark;
	private Date flowDT;
	private String flowDTStr;
	private String updateLog;
	private String assignToTeam;
	private String lessorTaxId;
	private BigDecimal elPayOnPackageAmt;
	private String filePath;
	
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

	public String getTerminateCancelRelateData() {
		return terminateCancelRelateData;
	}

	public void setTerminateCancelRelateData(String terminateCancelRelateData) {
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

	public Date getExpireDt() {
		return expireDt;
	}

	public void setExpireDt(Date expireDt) {
		this.expireDt = expireDt;
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

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public String getContractTel() {
		return contractTel;
	}

	public void setContractTel(String contractTel) {
		this.contractTel = contractTel;
	}

	public String getContractMobile() {
		return contractMobile;
	}

	public void setContractMobile(String contractMobile) {
		this.contractMobile = contractMobile;
	}

	public String getContractFax() {
		return contractFax;
	}

	public void setContractFax(String contractFax) {
		this.contractFax = contractFax;
	}

	public String getContractEmail() {
		return contractEmail;
	}

	public void setContractEmail(String contractEmail) {
		this.contractEmail = contractEmail;
	}

	public BigDecimal getRentAMT() {
		return rentAMT;
	}

	public void setRentAMT(BigDecimal rentAMT) {
		this.rentAMT = rentAMT;
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

	public Date getInsExpireDT() {
		return insExpireDT;
	}

	public void setInsExpireDT(Date insExpireDT) {
		this.insExpireDT = insExpireDT;
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

	public Date getUpdateDT() {
		return updateDT;
	}

	public void setUpdateDT(Date updateDT) {
		this.updateDT = updateDT;
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

	public String getDocDtStr() {
		return docDtStr;
	}

	public void setDocDtStr(String docDtStr) {
		this.docDtStr = docDtStr;
	}

	public String getTerminateRemoveDtStr() {
		return terminateRemoveDtStr;
	}

	public void setTerminateRemoveDtStr(String terminateRemoveDtStr) {
		this.terminateRemoveDtStr = terminateRemoveDtStr;
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

	public String getInsEffectiveDTStr() {
		return insEffectiveDTStr;
	}

	public void setInsEffectiveDTStr(String insEffectiveDTStr) {
		this.insEffectiveDTStr = insEffectiveDTStr;
	}

	public String getInsExpireDTStr() {
		return insExpireDTStr;
	}

	public void setInsExpireDTStr(String insExpireDTStr) {
		this.insExpireDTStr = insExpireDTStr;
	}

	public String getAssignDTStr() {
		return assignDTStr;
	}

	public void setAssignDTStr(String assignDTStr) {
		this.assignDTStr = assignDTStr;
	}

	public String getLeaderApproveDTStr() {
		return leaderApproveDTStr;
	}

	public void setLeaderApproveDTStr(String leaderApproveDTStr) {
		this.leaderApproveDTStr = leaderApproveDTStr;
	}

	public String getManagerApproveDTStr() {
		return managerApproveDTStr;
	}

	public void setManagerApproveDTStr(String managerApproveDTStr) {
		this.managerApproveDTStr = managerApproveDTStr;
	}

	public String getLegalApproveDTStr() {
		return legalApproveDTStr;
	}

	public void setLegalApproveDTStr(String legalApproveDTStr) {
		this.legalApproveDTStr = legalApproveDTStr;
	}

	public String getAvpApproveDTStr() {
		return avpApproveDTStr;
	}

	public void setAvpApproveDTStr(String avpApproveDTStr) {
		this.avpApproveDTStr = avpApproveDTStr;
	}

	public String getBatchDTStr() {
		return batchDTStr;
	}

	public void setBatchDTStr(String batchDTStr) {
		this.batchDTStr = batchDTStr;
	}

	public String getCreateDTStr() {
		return createDTStr;
	}

	public void setCreateDTStr(String createDTStr) {
		this.createDTStr = createDTStr;
	}

	public String getUpdateDTStr() {
		return updateDTStr;
	}

	public void setUpdateDTStr(String updateDTStr) {
		this.updateDTStr = updateDTStr;
	}

	public String getFlowDTStr() {
		return flowDTStr;
	}

	public void setFlowDTStr(String flowDTStr) {
		this.flowDTStr = flowDTStr;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getDocTypeText() {
		return docTypeText;
	}

	public void setDocTypeText(String docTypeText) {
		this.docTypeText = docTypeText;
	}

	@Override
	public String getCreateBy() {
		// TODO Auto-generated method stub
		return this.createBy;
	}

	@Override
	public Date getCreateDt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUpdateBy() {
		// TODO Auto-generated method stub
		return this.updateBy;
	}

	@Override
	public Date getUpdateDt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCreateDt(Date createDt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUpdateDt(Date updateDt) {
		// TODO Auto-generated method stub
		
	}

}
