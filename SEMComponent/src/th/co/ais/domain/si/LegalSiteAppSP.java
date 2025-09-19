package th.co.ais.domain.si;

import java.util.Date;
import java.lang.Float;
import java.lang.Integer;

import th.co.ais.domain.AbstractDomain;

public class LegalSiteAppSP extends AbstractDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected String rowId;
	protected String siteAppId;
	
	protected String contractId;
	protected String contractNo;
	protected Float contractTime;
	protected Float contractTimeSeq;
	protected String contractWanted;
	protected String contractEditFlag;
	
	protected String reqType;
	protected String reqDocType;
	protected String reqOfficer;
	protected String reqOfficerManual;
	
	protected String docNo;
	protected String docId;
	protected String docStatus;
	protected Date docDt;
	protected Date docDtStr;
	protected String docTypeText;
	protected String docStatusText;
	protected String docTypeDesc;
	
	protected String title;
	protected String region;
	protected String company;

	protected String needLegalApprove;
	protected String needAvpApprove;
	
	protected String isCoLocate;
	protected String coLocateCompany;
	protected String coContractNo;
	
	protected String terminateReason;
	protected String terminateRemoveFlag;
	protected Date terminateRemoveDt;
	protected String terminateCancelRelateData;
	protected String terminateNote;
	
	protected String locationId;
	protected String locationName;
	protected String locationZone;
	protected String locationType;
	protected String locationCode;
	protected String locationTypeText;
	protected String locationNameTh;
	protected String locationAddressNo;
	protected String locationBuilding;
	protected String locationFloor;
	protected String locationRoomNo;
	protected String locationStreet;
	protected String locationTambon;
	protected String locationAmphurId;
	protected String locationProvinceId;
	protected String locationPostCode;
	protected String locationEditFlag;
	protected String locationPhase;
	
	protected Float landArea;
	protected String landAreaType;
	protected Float deckArea;
	protected String deckAreaType;
	protected Float buildingArea;
	protected Float roomArea;
	protected String areaRemark;
	protected String areaRemarkBG;
	
	
	protected Integer no;
	protected String expireDetail;
	protected Integer ageYear;
	protected Integer ageMonth;
	protected Integer ageDay;
	protected Integer promiseRenewTime;
	protected Integer promiseRenewPeriod;
	
	protected String promiseRenewPeriodType;
	
	protected String lessorName;
	protected String lessorNameBG;
	protected String lessorHouseNo;
	protected String lessorHouseNoBG;
	protected String lessorBuilding;
	protected String lessorBuildingBG;
	protected String lessorFloor;
	protected String lessorFloorBG;
	protected String lessorRoomNo;
	protected String lessorRoomNoBG;
	protected String lessorStreet;
	protected String lessorStreetBG;
	protected String lessorTambon;
	protected String lessorTambonBG;
	protected String lessorAmphurId;
	protected String lessorProvinceId;
	protected String lessorPostCode;
	protected String lessorPostCodeBG;
	protected String lessorTaxId;
	protected String lessorTaxIdBG;
	
	protected String contactName;
	protected String contactNameBG;
	protected String contactTel;
	protected String contactTelBG;
	protected String contactMobile;
	protected String contactMobileBG;
	protected String contactFax;
	protected String contactFaxBG;
	protected String contactEmail;
	protected String contactEmailBG;
	
	protected Float rentAmt;
	protected String rentAmtBG;
	protected Float rentAmtPerYear;
	protected String rentPeriodType;
	protected String rentDetail;
	protected String rentDetailBG;
	protected String rentWhtDetail;
	protected String rentWhtDetailBG;
	protected String rentWhtType;
	protected Float rentWhtRate;
	protected String rentWhtRateMod;
	protected Float rentServiceAmt;
	protected String rentServiceAmtBG;
	protected String rentServicePeriodType;
	protected String rentServiceDetail;
	protected String rentServiceDetailBG;
	protected String rentServiceVatType;
	protected String rentServiceVatTypeBG;
	protected String rentServiceWht;
	protected String rentServiceWhtBG;
	protected String rentServiceWhtType;
	protected Float rentServiceWhtRate;
	protected String rentServiceWhtRateMod;
	protected String rentServiceAmtMemo;
	protected String rentServiceAmtMemoBG;
	protected String rentAreaAmtMemo;
	protected String rentAreaAmtMemoBG;
	protected String rentSetupAmtMemo;
	protected String rentSetupAmtMemoBG;
	protected String rentOtherAmtMemo;
	protected String rentOtherAmtMemoBG;
	protected String rentSpecialAmtMemo;
	protected String rentSpecialAmtMemoBG;
	protected String rentPaymentPeriod;
	protected String rentPaymentPeriodBG;
	protected String rentPaymentPeriodOth;
	protected String rentDepositFlag;
	protected Float rentDepositBgAmt;
	protected String rentDepositBgVat;
	protected Float rentDepositCashAmt;
	protected String rentDepositCashVat;
	protected String rentRemark;
	protected String rentEditFlag;
	protected String rentDepositEditFlag;
	
	protected Float totalRentService;
	protected String totalRentServiceBG;
	
	protected String elUseMultiResourse;
	protected String elUseNewMeter;
	protected String elUseOldMeter;
	protected String elUseOwner;
	protected String elOwnerType;
	
	protected String elPayOnPackage;
	protected Float elPayOnPackageAmt;
	protected String elPackagePeriodType;
	protected String elPayOnUsed;
	protected Float elUnitPrice;
	protected String elVatType;
	protected String payOnUsedDesc;
	protected String payOnUsedDescBG;
	protected String elRemark;
	protected String elRemarkBG;
	protected String elDepositFlag;
	protected Float elBgDeposit;
	protected String elBgDepositVatType;
	protected Float elCashDeposit;
	protected String elCashDepositVatType;
	protected String elDepositRemark;
	protected String elEditFlag;
	protected String elDepositEditFlag;
	
	protected String remarkSpecial;
	protected String remarkDocuments;
	protected String remarkContract;
	protected String remarkAqm;
	protected String remarkRisk;
	protected String remarkLegal;
	protected String remarkOther;
	
	protected String ptTaxPayType;
	protected String ptRemark;
	protected String ptRemarkBG;

	protected String insFlag;
	protected String insFlagBG;
	protected Float insSumInsured;
	protected String insSumInsuredBG;
	protected Date insEffectiveDt;
	protected String insEffectiveDtStr;
	protected String insEffectiveDtBG;
	protected Date insExpireDt;
	protected String insExpireDtStr;
	protected String insExpireDtBG;
	protected String insBeneficiary;
	protected String insBeneficiaryBG;
	
	protected String mailName;
	protected String mailHouseNo;
	protected String mailBuilding;
	protected String mailFloor;
	protected String mailRoomNo;
	protected String mailStreet;
	protected String mailTambon;
	protected String mailAmphurId;
	protected String mailProvinceId;
	protected String mailPostCode;
	protected String mailEditFlag;
	
	
	protected String assignBy;
	protected String assignToTeam;
	protected String assignToUser;
	
	protected Date leaderApproveDt;
	protected String leaderApproveDtStr;
	protected String leaderApproveBy;
	protected String leaderApproveRemark;
	protected String leaderApproveStatus; //
	protected Date managerApproveDt;
	protected String managerApproveDtStr;
	protected String managerApproveBy;
	protected String managerApproveRemark;
	protected String managerApproveStatus; //
	protected Date legalApproveDt;
	protected String legalApproveDtStr;
	protected String legalApproveBy;
	protected String legalApproveRemark;
	protected String legalApproveStatus; //
	protected Date avpApproveDt;
	protected String avpApproveDtStr;
	protected String avpApproveBy;
	protected String avpApproveRemark;
	protected String avpApproveStatus; //
	
	protected String flowStatus;
	protected String flowBy;
	protected String flowRemark;
	protected String user;
	protected Date flowDt;
	protected String flowDtStr;
	protected String flowStatusId;
	protected String address;
	protected Date effectiveDtFrom;
	protected Date effectiveDtTo;
	protected Date expireDtFrom;
	protected Date expireDtTo;
	
	protected String recordStatus;
	
	protected String batchNo;
	protected Date batchDt;
	protected String batchDtStr;
	protected String batchSum;
	
	protected String propertyTaxEditFlag;
	protected String insuranceEditFlag;
	
	
	protected Float version;
	protected String system;
	protected String siteCode;
	protected String siteId;
	protected String siteGroup;
	protected String siteType;
	protected String siteNameTh;
	protected String siteZone;
	protected String siteDetail;
	protected String stationType;
	
	protected String teamName;
	protected String menuGroup;
	
	protected String userId;
	protected String userName;
	protected String userLogin;
	protected String status;
	protected String retResult;
	
	protected String sumNewSite;
	protected String sumReNewSite;
	protected String sumEditSite;
	protected String sumWaitTerminate;
	protected String sumterminate;
	protected String sumTotal;
	
	protected String toTeam;
	protected String toUser;

	protected String strDataList;
	protected String strParam;

	protected String networkStatus;
	
	protected Date effectiveDt;
	protected String effectiveDtStr;
	protected Date expireDt;
	protected String expireDtStr;
	protected Date assignDt;
	protected String assignDtStr;
	protected Date statusDt;
	protected String statusDtStr;
	protected Date approveDt;
	protected String approveDtStr;
	protected Date updateDt;
	protected String updateDtStr;
	
	protected String approveBy;
	protected String costPerYear;
	protected String modifiedDetail;
	protected String nearSiteCost;
	protected String growingCost;
	
	protected String placeType;
	protected String partiesType;
	
	protected String stationName;
	
	protected Date terminateCancelContractDt;
	protected Date terminateRemoveEndDt;
	protected String phase;
	protected String remark;
    protected String revenue;
    
    protected String retResultMsg;

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

	@Override
	public String toString() {
		return "LegalSiteAppSP [address=" + address + ", ageDay=" + ageDay
				+ ", ageMonth=" + ageMonth + ", ageYear=" + ageYear
				+ ", approveBy=" + approveBy + ", approveDt=" + approveDt
				+ ", approveDtStr=" + approveDtStr + ", areaRemark="
				+ areaRemark + ", areaRemarkBG=" + areaRemarkBG + ", assignBy="
				+ assignBy + ", assignDt=" + assignDt + ", assignDtStr="
				+ assignDtStr + ", assignToTeam=" + assignToTeam
				+ ", assignToUser=" + assignToUser + ", avpApproveBy="
				+ avpApproveBy + ", avpApproveDt=" + avpApproveDt
				+ ", avpApproveDtStr=" + avpApproveDtStr
				+ ", avpApproveRemark=" + avpApproveRemark
				+ ", avpApproveStatus=" + avpApproveStatus + ", batchDt="
				+ batchDt + ", batchDtStr=" + batchDtStr + ", batchNo="
				+ batchNo + ", batchSum=" + batchSum + ", buildingArea="
				+ buildingArea + ", coContractNo=" + coContractNo
				+ ", coLocateCompany=" + coLocateCompany + ", company="
				+ company + ", contactEmail=" + contactEmail
				+ ", contactEmailBG=" + contactEmailBG + ", contactFax="
				+ contactFax + ", contactFaxBG=" + contactFaxBG
				+ ", contactMobile=" + contactMobile + ", contactMobileBG="
				+ contactMobileBG + ", contactName=" + contactName
				+ ", contactNameBG=" + contactNameBG + ", contactTel="
				+ contactTel + ", contactTelBG=" + contactTelBG
				+ ", contractEditFlag=" + contractEditFlag + ", contractId="
				+ contractId + ", contractNo=" + contractNo + ", contractTime="
				+ contractTime + ", contractTimeSeq=" + contractTimeSeq
				+ ", contractWanted=" + contractWanted + ", costPerYear="
				+ costPerYear + ", deckArea=" + deckArea + ", deckAreaType="
				+ deckAreaType + ", docDt=" + docDt + ", docDtStr=" + docDtStr
				+ ", docId=" + docId + ", docNo=" + docNo + ", docStatus="
				+ docStatus + ", docStatusText=" + docStatusText
				+ ", docTypeDesc=" + docTypeDesc + ", docTypeText="
				+ docTypeText + ", effectiveDt=" + effectiveDt
				+ ", effectiveDtFrom=" + effectiveDtFrom + ", effectiveDtStr="
				+ effectiveDtStr + ", effectiveDtTo=" + effectiveDtTo
				+ ", elBgDeposit=" + elBgDeposit + ", elBgDepositVatType="
				+ elBgDepositVatType + ", elCashDeposit=" + elCashDeposit
				+ ", elCashDepositVatType=" + elCashDepositVatType
				+ ", elDepositEditFlag=" + elDepositEditFlag
				+ ", elDepositFlag=" + elDepositFlag + ", elDepositRemark="
				+ elDepositRemark + ", elEditFlag=" + elEditFlag
				+ ", elOwnerType=" + elOwnerType + ", elPackagePeriodType="
				+ elPackagePeriodType + ", elPayOnPackage=" + elPayOnPackage
				+ ", elPayOnPackageAmt=" + elPayOnPackageAmt + ", elPayOnUsed="
				+ elPayOnUsed + ", elRemark=" + elRemark + ", elRemarkBG="
				+ elRemarkBG + ", elUnitPrice=" + elUnitPrice
				+ ", elUseMultiResourse=" + elUseMultiResourse
				+ ", elUseNewMeter=" + elUseNewMeter + ", elUseOldMeter="
				+ elUseOldMeter + ", elUseOwner=" + elUseOwner + ", elVatType="
				+ elVatType + ", expireDetail=" + expireDetail + ", expireDt="
				+ expireDt + ", expireDtFrom=" + expireDtFrom
				+ ", expireDtStr=" + expireDtStr + ", expireDtTo=" + expireDtTo
				+ ", flowBy=" + flowBy + ", flowDt=" + flowDt + ", flowDtStr="
				+ flowDtStr + ", flowRemark=" + flowRemark + ", flowStatus="
				+ flowStatus + ", flowStatusId=" + flowStatusId
				+ ", growingCost=" + growingCost + ", insBeneficiary="
				+ insBeneficiary + ", insBeneficiaryBG=" + insBeneficiaryBG
				+ ", insEffectiveDt=" + insEffectiveDt + ", insEffectiveDtBG="
				+ insEffectiveDtBG + ", insEffectiveDtStr=" + insEffectiveDtStr
				+ ", insExpireDt=" + insExpireDt + ", insExpireDtBG="
				+ insExpireDtBG + ", insExpireDtStr=" + insExpireDtStr
				+ ", insFlag=" + insFlag + ", insFlagBG=" + insFlagBG
				+ ", insSumInsured=" + insSumInsured + ", insSumInsuredBG="
				+ insSumInsuredBG + ", insuranceEditFlag=" + insuranceEditFlag
				+ ", isCoLocate=" + isCoLocate + ", landArea=" + landArea
				+ ", landAreaType=" + landAreaType + ", leaderApproveBy="
				+ leaderApproveBy + ", leaderApproveDt=" + leaderApproveDt
				+ ", leaderApproveDtStr=" + leaderApproveDtStr
				+ ", leaderApproveRemark=" + leaderApproveRemark
				+ ", leaderApproveStatus=" + leaderApproveStatus
				+ ", legalApproveBy=" + legalApproveBy + ", legalApproveDt="
				+ legalApproveDt + ", legalApproveDtStr=" + legalApproveDtStr
				+ ", legalApproveRemark=" + legalApproveRemark
				+ ", legalApproveStatus=" + legalApproveStatus
				+ ", lessorAmphurId=" + lessorAmphurId + ", lessorBuilding="
				+ lessorBuilding + ", lessorBuildingBG=" + lessorBuildingBG
				+ ", lessorFloor=" + lessorFloor + ", lessorFloorBG="
				+ lessorFloorBG + ", lessorHouseNo=" + lessorHouseNo
				+ ", lessorHouseNoBG=" + lessorHouseNoBG + ", lessorName="
				+ lessorName + ", lessorNameBG=" + lessorNameBG
				+ ", lessorPostCode=" + lessorPostCode + ", lessorPostCodeBG="
				+ lessorPostCodeBG + ", lessorProvinceId=" + lessorProvinceId
				+ ", lessorRoomNo=" + lessorRoomNo + ", lessorRoomNoBG="
				+ lessorRoomNoBG + ", lessorStreet=" + lessorStreet
				+ ", lessorStreetBG=" + lessorStreetBG + ", lessorTambon="
				+ lessorTambon + ", lessorTambonBG=" + lessorTambonBG
				+ ", lessorTaxId=" + lessorTaxId + ", lessorTaxIdBG="
				+ lessorTaxIdBG + ", locationAddressNo=" + locationAddressNo
				+ ", locationAmphurId=" + locationAmphurId
				+ ", locationBuilding=" + locationBuilding + ", locationCode="
				+ locationCode + ", locationEditFlag=" + locationEditFlag
				+ ", locationFloor=" + locationFloor + ", locationId="
				+ locationId + ", locationName=" + locationName
				+ ", locationNameTh=" + locationNameTh + ", locationPhase="
				+ locationPhase + ", locationPostCode=" + locationPostCode
				+ ", locationProvinceId=" + locationProvinceId
				+ ", locationRoomNo=" + locationRoomNo + ", locationStreet="
				+ locationStreet + ", locationTambon=" + locationTambon
				+ ", locationType=" + locationType + ", locationTypeText="
				+ locationTypeText + ", locationZone=" + locationZone
				+ ", mailAmphurId=" + mailAmphurId + ", mailBuilding="
				+ mailBuilding + ", mailEditFlag=" + mailEditFlag
				+ ", mailFloor=" + mailFloor + ", mailHouseNo=" + mailHouseNo
				+ ", mailName=" + mailName + ", mailPostCode=" + mailPostCode
				+ ", mailProvinceId=" + mailProvinceId + ", mailRoomNo="
				+ mailRoomNo + ", mailStreet=" + mailStreet + ", mailTambon="
				+ mailTambon + ", managerApproveBy=" + managerApproveBy
				+ ", managerApproveDt=" + managerApproveDt
				+ ", managerApproveDtStr=" + managerApproveDtStr
				+ ", managerApproveRemark=" + managerApproveRemark
				+ ", managerApproveStatus=" + managerApproveStatus
				+ ", menuGroup=" + menuGroup + ", modifiedDetail="
				+ modifiedDetail + ", nearSiteCost=" + nearSiteCost
				+ ", needAvpApprove=" + needAvpApprove + ", needLegalApprove="
				+ needLegalApprove + ", networkStatus=" + networkStatus
				+ ", no=" + no + ", partiesType=" + partiesType
				+ ", payOnUsedDesc=" + payOnUsedDesc + ", payOnUsedDescBG="
				+ payOnUsedDescBG + ", phase=" + phase + ", placeType="
				+ placeType + ", promiseRenewPeriod=" + promiseRenewPeriod
				+ ", promiseRenewPeriodType=" + promiseRenewPeriodType
				+ ", promiseRenewTime=" + promiseRenewTime
				+ ", propertyTaxEditFlag=" + propertyTaxEditFlag
				+ ", ptRemark=" + ptRemark + ", ptRemarkBG=" + ptRemarkBG
				+ ", ptTaxPayType=" + ptTaxPayType + ", recordStatus="
				+ recordStatus + ", region=" + region + ", remark=" + remark
				+ ", remarkAqm=" + remarkAqm + ", remarkContract="
				+ remarkContract + ", remarkDocuments=" + remarkDocuments
				+ ", remarkLegal=" + remarkLegal + ", remarkOther="
				+ remarkOther + ", remarkRisk=" + remarkRisk
				+ ", remarkSpecial=" + remarkSpecial + ", rentAmt=" + rentAmt
				+ ", rentAmtBG=" + rentAmtBG + ", rentAmtPerYear="
				+ rentAmtPerYear + ", rentAreaAmtMemo=" + rentAreaAmtMemo
				+ ", rentAreaAmtMemoBG=" + rentAreaAmtMemoBG
				+ ", rentDepositBgAmt=" + rentDepositBgAmt
				+ ", rentDepositBgVat=" + rentDepositBgVat
				+ ", rentDepositCashAmt=" + rentDepositCashAmt
				+ ", rentDepositCashVat=" + rentDepositCashVat
				+ ", rentDepositEditFlag=" + rentDepositEditFlag
				+ ", rentDepositFlag=" + rentDepositFlag + ", rentDetail="
				+ rentDetail + ", rentDetailBG=" + rentDetailBG
				+ ", rentEditFlag=" + rentEditFlag + ", rentOtherAmtMemo="
				+ rentOtherAmtMemo + ", rentOtherAmtMemoBG="
				+ rentOtherAmtMemoBG + ", rentPaymentPeriod="
				+ rentPaymentPeriod + ", rentPaymentPeriodBG="
				+ rentPaymentPeriodBG + ", rentPaymentPeriodOth="
				+ rentPaymentPeriodOth + ", rentPeriodType=" + rentPeriodType
				+ ", rentRemark=" + rentRemark + ", rentServiceAmt="
				+ rentServiceAmt + ", rentServiceAmtBG=" + rentServiceAmtBG
				+ ", rentServiceAmtMemo=" + rentServiceAmtMemo
				+ ", rentServiceAmtMemoBG=" + rentServiceAmtMemoBG
				+ ", rentServiceDetail=" + rentServiceDetail
				+ ", rentServiceDetailBG=" + rentServiceDetailBG
				+ ", rentServicePeriodType=" + rentServicePeriodType
				+ ", rentServiceVatType=" + rentServiceVatType
				+ ", rentServiceVatTypeBG=" + rentServiceVatTypeBG
				+ ", rentServiceWht=" + rentServiceWht + ", rentServiceWhtBG="
				+ rentServiceWhtBG + ", rentServiceWhtRate="
				+ rentServiceWhtRate + ", rentServiceWhtRateMod="
				+ rentServiceWhtRateMod + ", rentServiceWhtType="
				+ rentServiceWhtType + ", rentSetupAmtMemo=" + rentSetupAmtMemo
				+ ", rentSetupAmtMemoBG=" + rentSetupAmtMemoBG
				+ ", rentSpecialAmtMemo=" + rentSpecialAmtMemo
				+ ", rentSpecialAmtMemoBG=" + rentSpecialAmtMemoBG
				+ ", rentWhtDetail=" + rentWhtDetail + ", rentWhtDetailBG="
				+ rentWhtDetailBG + ", rentWhtRate=" + rentWhtRate
				+ ", rentWhtRateMod=" + rentWhtRateMod + ", rentWhtType="
				+ rentWhtType + ", reqDocType=" + reqDocType + ", reqOfficer="
				+ reqOfficer + ", reqOfficerManual=" + reqOfficerManual
				+ ", reqType=" + reqType + ", retResult=" + retResult
				+ ", retResultMsg=" + retResultMsg + ", revenue=" + revenue
				+ ", roomArea=" + roomArea + ", rowId=" + rowId
				+ ", siteAppId=" + siteAppId + ", siteCode=" + siteCode
				+ ", siteDetail=" + siteDetail + ", siteGroup=" + siteGroup
				+ ", siteId=" + siteId + ", siteNameTh=" + siteNameTh
				+ ", siteType=" + siteType + ", siteZone=" + siteZone
				+ ", stationName=" + stationName + ", stationType="
				+ stationType + ", status=" + status 
				+ ", statusDt=" + statusDt + ", statusDtStr=" + statusDtStr
				+ ", strDataList=" + strDataList + ", strParam=" + strParam
				+ ", sumEditSite=" + sumEditSite + ", sumNewSite=" + sumNewSite
				+ ", sumReNewSite=" + sumReNewSite + ", sumTotal=" + sumTotal
				+ ", sumWaitTerminate=" + sumWaitTerminate + ", sumterminate="
				+ sumterminate + ", system=" + system + ", teamName="
				+ teamName + ", terminateCancelContractDt="
				+ terminateCancelContractDt + ", terminateCancelRelateData="
				+ terminateCancelRelateData + ", terminateNote="
				+ terminateNote + ", terminateReason=" + terminateReason
				+ ", terminateRemoveDt=" + terminateRemoveDt
				+ ", terminateRemoveEndDt=" + terminateRemoveEndDt
				+ ", terminateRemoveFlag=" + terminateRemoveFlag + ", title="
				+ title + ", toTeam=" + toTeam + ", toUser=" + toUser
				+ ", totalRentService=" + totalRentService
				+ ", totalRentServiceBG=" + totalRentServiceBG + ", updateDt="
				+ updateDt + ", updateDtStr=" + updateDtStr + ", user=" + user
				+ ", userId=" + userId + ", userLogin=" + userLogin
				+ ", userName=" + userName + ", version=" + version + "]";
	}

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

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public Float getContractTime() {
		return contractTime;
	}

	public void setContractTime(Float contractTime) {
		this.contractTime = contractTime;
	}

	public Float getContractTimeSeq() {
		return contractTimeSeq;
	}

	public void setContractTimeSeq(Float contractTimeSeq) {
		this.contractTimeSeq = contractTimeSeq;
	}

	public String getContractWanted() {
		return contractWanted;
	}

	public void setContractWanted(String contractWanted) {
		this.contractWanted = contractWanted;
	}

	public String getContractEditFlag() {
		return contractEditFlag;
	}

	public void setContractEditFlag(String contractEditFlag) {
		this.contractEditFlag = contractEditFlag;
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

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getDocStatus() {
		return docStatus;
	}

	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}

	public Date getDocDt() {
		return docDt;
	}

	public void setDocDt(Date docDt) {
		this.docDt = docDt;
	}

	public Date getDocDtStr() {
		return docDtStr;
	}

	public void setDocDtStr(Date docDtStr) {
		this.docDtStr = docDtStr;
	}

	public String getDocTypeText() {
		return docTypeText;
	}

	public void setDocTypeText(String docTypeText) {
		this.docTypeText = docTypeText;
	}

	public String getDocStatusText() {
		return docStatusText;
	}

	public void setDocStatusText(String docStatusText) {
		this.docStatusText = docStatusText;
	}

	public String getDocTypeDesc() {
		return docTypeDesc;
	}

	public void setDocTypeDesc(String docTypeDesc) {
		this.docTypeDesc = docTypeDesc;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getNeedLegalApprove() {
		return needLegalApprove;
	}

	public void setNeedLegalApprove(String needLegalApprove) {
		this.needLegalApprove = needLegalApprove;
	}

	public String getNeedAvpApprove() {
		return needAvpApprove;
	}

	public void setNeedAvpApprove(String needAvpApprove) {
		this.needAvpApprove = needAvpApprove;
	}

	public String getIsCoLocate() {
		return isCoLocate;
	}

	public void setIsCoLocate(String isCoLocate) {
		this.isCoLocate = isCoLocate;
	}

	public String getCoLocateCompany() {
		return coLocateCompany;
	}

	public void setCoLocateCompany(String coLocateCompany) {
		this.coLocateCompany = coLocateCompany;
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

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationZone() {
		return locationZone;
	}

	public void setLocationZone(String locationZone) {
		this.locationZone = locationZone;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getLocationTypeText() {
		return locationTypeText;
	}

	public void setLocationTypeText(String locationTypeText) {
		this.locationTypeText = locationTypeText;
	}

	public String getLocationNameTh() {
		return locationNameTh;
	}

	public void setLocationNameTh(String locationNameTh) {
		this.locationNameTh = locationNameTh;
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

	public String getLocationPostCode() {
		return locationPostCode;
	}

	public void setLocationPostCode(String locationPostCode) {
		this.locationPostCode = locationPostCode;
	}

	public String getLocationEditFlag() {
		return locationEditFlag;
	}

	public void setLocationEditFlag(String locationEditFlag) {
		this.locationEditFlag = locationEditFlag;
	}

	public String getLocationPhase() {
		return locationPhase;
	}

	public void setLocationPhase(String locationPhase) {
		this.locationPhase = locationPhase;
	}

	public Float getLandArea() {
		return landArea;
	}

	public void setLandArea(Float landArea) {
		this.landArea = landArea;
	}

	public String getLandAreaType() {
		return landAreaType;
	}

	public void setLandAreaType(String landAreaType) {
		this.landAreaType = landAreaType;
	}

	public Float getDeckArea() {
		return deckArea;
	}

	public void setDeckArea(Float deckArea) {
		this.deckArea = deckArea;
	}

	public String getDeckAreaType() {
		return deckAreaType;
	}

	public void setDeckAreaType(String deckAreaType) {
		this.deckAreaType = deckAreaType;
	}

	public Float getBuildingArea() {
		return buildingArea;
	}

	public void setBuildingArea(Float buildingArea) {
		this.buildingArea = buildingArea;
	}

	public Float getRoomArea() {
		return roomArea;
	}

	public void setRoomArea(Float roomArea) {
		this.roomArea = roomArea;
	}

	public String getAreaRemark() {
		return areaRemark;
	}

	public void setAreaRemark(String areaRemark) {
		this.areaRemark = areaRemark;
	}

	public String getAreaRemarkBG() {
		return areaRemarkBG;
	}

	public void setAreaRemarkBG(String areaRemarkBG) {
		this.areaRemarkBG = areaRemarkBG;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getExpireDetail() {
		return expireDetail;
	}

	public void setExpireDetail(String expireDetail) {
		this.expireDetail = expireDetail;
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

	public Integer getPromiseRenewTime() {
		return promiseRenewTime;
	}

	public void setPromiseRenewTime(Integer promiseRenewTime) {
		this.promiseRenewTime = promiseRenewTime;
	}

	public Integer getPromiseRenewPeriod() {
		return promiseRenewPeriod;
	}

	public void setPromiseRenewPeriod(Integer promiseRenewPeriod) {
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

	public String getLessorNameBG() {
		return lessorNameBG;
	}

	public void setLessorNameBG(String lessorNameBG) {
		this.lessorNameBG = lessorNameBG;
	}

	public String getLessorHouseNo() {
		return lessorHouseNo;
	}

	public void setLessorHouseNo(String lessorHouseNo) {
		this.lessorHouseNo = lessorHouseNo;
	}

	public String getLessorHouseNoBG() {
		return lessorHouseNoBG;
	}

	public void setLessorHouseNoBG(String lessorHouseNoBG) {
		this.lessorHouseNoBG = lessorHouseNoBG;
	}

	public String getLessorBuilding() {
		return lessorBuilding;
	}

	public void setLessorBuilding(String lessorBuilding) {
		this.lessorBuilding = lessorBuilding;
	}

	public String getLessorBuildingBG() {
		return lessorBuildingBG;
	}

	public void setLessorBuildingBG(String lessorBuildingBG) {
		this.lessorBuildingBG = lessorBuildingBG;
	}

	public String getLessorFloor() {
		return lessorFloor;
	}

	public void setLessorFloor(String lessorFloor) {
		this.lessorFloor = lessorFloor;
	}

	public String getLessorFloorBG() {
		return lessorFloorBG;
	}

	public void setLessorFloorBG(String lessorFloorBG) {
		this.lessorFloorBG = lessorFloorBG;
	}

	public String getLessorRoomNo() {
		return lessorRoomNo;
	}

	public void setLessorRoomNo(String lessorRoomNo) {
		this.lessorRoomNo = lessorRoomNo;
	}

	public String getLessorRoomNoBG() {
		return lessorRoomNoBG;
	}

	public void setLessorRoomNoBG(String lessorRoomNoBG) {
		this.lessorRoomNoBG = lessorRoomNoBG;
	}

	public String getLessorStreet() {
		return lessorStreet;
	}

	public void setLessorStreet(String lessorStreet) {
		this.lessorStreet = lessorStreet;
	}

	public String getLessorStreetBG() {
		return lessorStreetBG;
	}

	public void setLessorStreetBG(String lessorStreetBG) {
		this.lessorStreetBG = lessorStreetBG;
	}

	public String getLessorTambon() {
		return lessorTambon;
	}

	public void setLessorTambon(String lessorTambon) {
		this.lessorTambon = lessorTambon;
	}

	public String getLessorTambonBG() {
		return lessorTambonBG;
	}

	public void setLessorTambonBG(String lessorTambonBG) {
		this.lessorTambonBG = lessorTambonBG;
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

	public String getLessorPostCode() {
		return lessorPostCode;
	}

	public void setLessorPostCode(String lessorPostCode) {
		this.lessorPostCode = lessorPostCode;
	}

	public String getLessorPostCodeBG() {
		return lessorPostCodeBG;
	}

	public void setLessorPostCodeBG(String lessorPostCodeBG) {
		this.lessorPostCodeBG = lessorPostCodeBG;
	}

	public String getLessorTaxId() {
		return lessorTaxId;
	}

	public void setLessorTaxId(String lessorTaxId) {
		this.lessorTaxId = lessorTaxId;
	}

	public String getLessorTaxIdBG() {
		return lessorTaxIdBG;
	}

	public void setLessorTaxIdBG(String lessorTaxIdBG) {
		this.lessorTaxIdBG = lessorTaxIdBG;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactNameBG() {
		return contactNameBG;
	}

	public void setContactNameBG(String contactNameBG) {
		this.contactNameBG = contactNameBG;
	}

	public String getContactTel() {
		return contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public String getContactTelBG() {
		return contactTelBG;
	}

	public void setContactTelBG(String contactTelBG) {
		this.contactTelBG = contactTelBG;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getContactMobileBG() {
		return contactMobileBG;
	}

	public void setContactMobileBG(String contactMobileBG) {
		this.contactMobileBG = contactMobileBG;
	}

	public String getContactFax() {
		return contactFax;
	}

	public void setContactFax(String contactFax) {
		this.contactFax = contactFax;
	}

	public String getContactFaxBG() {
		return contactFaxBG;
	}

	public void setContactFaxBG(String contactFaxBG) {
		this.contactFaxBG = contactFaxBG;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactEmailBG() {
		return contactEmailBG;
	}

	public void setContactEmailBG(String contactEmailBG) {
		this.contactEmailBG = contactEmailBG;
	}

	public Float getRentAmt() {
		return rentAmt;
	}

	public void setRentAmt(Float rentAmt) {
		this.rentAmt = rentAmt;
	}

	public String getRentAmtBG() {
		return rentAmtBG;
	}

	public void setRentAmtBG(String rentAmtBG) {
		this.rentAmtBG = rentAmtBG;
	}

	public Float getRentAmtPerYear() {
		return rentAmtPerYear;
	}

	public void setRentAmtPerYear(Float rentAmtPerYear) {
		this.rentAmtPerYear = rentAmtPerYear;
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

	public String getRentDetailBG() {
		return rentDetailBG;
	}

	public void setRentDetailBG(String rentDetailBG) {
		this.rentDetailBG = rentDetailBG;
	}

	public String getRentWhtDetail() {
		return rentWhtDetail;
	}

	public void setRentWhtDetail(String rentWhtDetail) {
		this.rentWhtDetail = rentWhtDetail;
	}

	public String getRentWhtDetailBG() {
		return rentWhtDetailBG;
	}

	public void setRentWhtDetailBG(String rentWhtDetailBG) {
		this.rentWhtDetailBG = rentWhtDetailBG;
	}

	public String getRentWhtType() {
		return rentWhtType;
	}

	public void setRentWhtType(String rentWhtType) {
		this.rentWhtType = rentWhtType;
	}

	public Float getRentWhtRate() {
		return rentWhtRate;
	}

	public void setRentWhtRate(Float rentWhtRate) {
		this.rentWhtRate = rentWhtRate;
	}

	public String getRentWhtRateMod() {
		return rentWhtRateMod;
	}

	public void setRentWhtRateMod(String rentWhtRateMod) {
		this.rentWhtRateMod = rentWhtRateMod;
	}

	public Float getRentServiceAmt() {
		return rentServiceAmt;
	}

	public void setRentServiceAmt(Float rentServiceAmt) {
		this.rentServiceAmt = rentServiceAmt;
	}

	public String getRentServiceAmtBG() {
		return rentServiceAmtBG;
	}

	public void setRentServiceAmtBG(String rentServiceAmtBG) {
		this.rentServiceAmtBG = rentServiceAmtBG;
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

	public String getRentServiceDetailBG() {
		return rentServiceDetailBG;
	}

	public void setRentServiceDetailBG(String rentServiceDetailBG) {
		this.rentServiceDetailBG = rentServiceDetailBG;
	}

	public String getRentServiceVatType() {
		return rentServiceVatType;
	}

	public void setRentServiceVatType(String rentServiceVatType) {
		this.rentServiceVatType = rentServiceVatType;
	}

	public String getRentServiceVatTypeBG() {
		return rentServiceVatTypeBG;
	}

	public void setRentServiceVatTypeBG(String rentServiceVatTypeBG) {
		this.rentServiceVatTypeBG = rentServiceVatTypeBG;
	}

	public String getRentServiceWht() {
		return rentServiceWht;
	}

	public void setRentServiceWht(String rentServiceWht) {
		this.rentServiceWht = rentServiceWht;
	}

	public String getRentServiceWhtBG() {
		return rentServiceWhtBG;
	}

	public void setRentServiceWhtBG(String rentServiceWhtBG) {
		this.rentServiceWhtBG = rentServiceWhtBG;
	}

	public String getRentServiceWhtType() {
		return rentServiceWhtType;
	}

	public void setRentServiceWhtType(String rentServiceWhtType) {
		this.rentServiceWhtType = rentServiceWhtType;
	}

	public Float getRentServiceWhtRate() {
		return rentServiceWhtRate;
	}

	public void setRentServiceWhtRate(Float rentServiceWhtRate) {
		this.rentServiceWhtRate = rentServiceWhtRate;
	}

	public String getRentServiceWhtRateMod() {
		return rentServiceWhtRateMod;
	}

	public void setRentServiceWhtRateMod(String rentServiceWhtRateMod) {
		this.rentServiceWhtRateMod = rentServiceWhtRateMod;
	}

	public String getRentServiceAmtMemo() {
		return rentServiceAmtMemo;
	}

	public void setRentServiceAmtMemo(String rentServiceAmtMemo) {
		this.rentServiceAmtMemo = rentServiceAmtMemo;
	}

	public String getRentServiceAmtMemoBG() {
		return rentServiceAmtMemoBG;
	}

	public void setRentServiceAmtMemoBG(String rentServiceAmtMemoBG) {
		this.rentServiceAmtMemoBG = rentServiceAmtMemoBG;
	}

	public String getRentAreaAmtMemo() {
		return rentAreaAmtMemo;
	}

	public void setRentAreaAmtMemo(String rentAreaAmtMemo) {
		this.rentAreaAmtMemo = rentAreaAmtMemo;
	}

	public String getRentAreaAmtMemoBG() {
		return rentAreaAmtMemoBG;
	}

	public void setRentAreaAmtMemoBG(String rentAreaAmtMemoBG) {
		this.rentAreaAmtMemoBG = rentAreaAmtMemoBG;
	}

	public String getRentSetupAmtMemo() {
		return rentSetupAmtMemo;
	}

	public void setRentSetupAmtMemo(String rentSetupAmtMemo) {
		this.rentSetupAmtMemo = rentSetupAmtMemo;
	}

	public String getRentSetupAmtMemoBG() {
		return rentSetupAmtMemoBG;
	}

	public void setRentSetupAmtMemoBG(String rentSetupAmtMemoBG) {
		this.rentSetupAmtMemoBG = rentSetupAmtMemoBG;
	}

	public String getRentOtherAmtMemo() {
		return rentOtherAmtMemo;
	}

	public void setRentOtherAmtMemo(String rentOtherAmtMemo) {
		this.rentOtherAmtMemo = rentOtherAmtMemo;
	}

	public String getRentOtherAmtMemoBG() {
		return rentOtherAmtMemoBG;
	}

	public void setRentOtherAmtMemoBG(String rentOtherAmtMemoBG) {
		this.rentOtherAmtMemoBG = rentOtherAmtMemoBG;
	}

	public String getRentSpecialAmtMemo() {
		return rentSpecialAmtMemo;
	}

	public void setRentSpecialAmtMemo(String rentSpecialAmtMemo) {
		this.rentSpecialAmtMemo = rentSpecialAmtMemo;
	}

	public String getRentSpecialAmtMemoBG() {
		return rentSpecialAmtMemoBG;
	}

	public void setRentSpecialAmtMemoBG(String rentSpecialAmtMemoBG) {
		this.rentSpecialAmtMemoBG = rentSpecialAmtMemoBG;
	}

	public String getRentPaymentPeriod() {
		return rentPaymentPeriod;
	}

	public void setRentPaymentPeriod(String rentPaymentPeriod) {
		this.rentPaymentPeriod = rentPaymentPeriod;
	}

	public String getRentPaymentPeriodBG() {
		return rentPaymentPeriodBG;
	}

	public void setRentPaymentPeriodBG(String rentPaymentPeriodBG) {
		this.rentPaymentPeriodBG = rentPaymentPeriodBG;
	}

	public String getRentPaymentPeriodOth() {
		return rentPaymentPeriodOth;
	}

	public void setRentPaymentPeriodOth(String rentPaymentPeriodOth) {
		this.rentPaymentPeriodOth = rentPaymentPeriodOth;
	}

	public String getRentDepositFlag() {
		return rentDepositFlag;
	}

	public void setRentDepositFlag(String rentDepositFlag) {
		this.rentDepositFlag = rentDepositFlag;
	}

	public Float getRentDepositBgAmt() {
		return rentDepositBgAmt;
	}

	public void setRentDepositBgAmt(Float rentDepositBgAmt) {
		this.rentDepositBgAmt = rentDepositBgAmt;
	}

	public String getRentDepositBgVat() {
		return rentDepositBgVat;
	}

	public void setRentDepositBgVat(String rentDepositBgVat) {
		this.rentDepositBgVat = rentDepositBgVat;
	}

	public Float getRentDepositCashAmt() {
		return rentDepositCashAmt;
	}

	public void setRentDepositCashAmt(Float rentDepositCashAmt) {
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

	public String getRentEditFlag() {
		return rentEditFlag;
	}

	public void setRentEditFlag(String rentEditFlag) {
		this.rentEditFlag = rentEditFlag;
	}

	public String getRentDepositEditFlag() {
		return rentDepositEditFlag;
	}

	public void setRentDepositEditFlag(String rentDepositEditFlag) {
		this.rentDepositEditFlag = rentDepositEditFlag;
	}

	public Float getTotalRentService() {
		return totalRentService;
	}

	public void setTotalRentService(Float totalRentService) {
		this.totalRentService = totalRentService;
	}

	public String getTotalRentServiceBG() {
		return totalRentServiceBG;
	}

	public void setTotalRentServiceBG(String totalRentServiceBG) {
		this.totalRentServiceBG = totalRentServiceBG;
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

	public Float getElPayOnPackageAmt() {
		return elPayOnPackageAmt;
	}

	public void setElPayOnPackageAmt(Float elPayOnPackageAmt) {
		this.elPayOnPackageAmt = elPayOnPackageAmt;
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

	public Float getElUnitPrice() {
		return elUnitPrice;
	}

	public void setElUnitPrice(Float elUnitPrice) {
		this.elUnitPrice = elUnitPrice;
	}

	public String getElVatType() {
		return elVatType;
	}

	public void setElVatType(String elVatType) {
		this.elVatType = elVatType;
	}

	public String getPayOnUsedDesc() {
		return payOnUsedDesc;
	}

	public void setPayOnUsedDesc(String payOnUsedDesc) {
		this.payOnUsedDesc = payOnUsedDesc;
	}

	public String getPayOnUsedDescBG() {
		return payOnUsedDescBG;
	}

	public void setPayOnUsedDescBG(String payOnUsedDescBG) {
		this.payOnUsedDescBG = payOnUsedDescBG;
	}

	public String getElRemark() {
		return elRemark;
	}

	public void setElRemark(String elRemark) {
		this.elRemark = elRemark;
	}

	public String getElRemarkBG() {
		return elRemarkBG;
	}

	public void setElRemarkBG(String elRemarkBG) {
		this.elRemarkBG = elRemarkBG;
	}

	public String getElDepositFlag() {
		return elDepositFlag;
	}

	public void setElDepositFlag(String elDepositFlag) {
		this.elDepositFlag = elDepositFlag;
	}

	public Float getElBgDeposit() {
		return elBgDeposit;
	}

	public void setElBgDeposit(Float elBgDeposit) {
		this.elBgDeposit = elBgDeposit;
	}

	public String getElBgDepositVatType() {
		return elBgDepositVatType;
	}

	public void setElBgDepositVatType(String elBgDepositVatType) {
		this.elBgDepositVatType = elBgDepositVatType;
	}

	public Float getElCashDeposit() {
		return elCashDeposit;
	}

	public void setElCashDeposit(Float elCashDeposit) {
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

	public String getElEditFlag() {
		return elEditFlag;
	}

	public void setElEditFlag(String elEditFlag) {
		this.elEditFlag = elEditFlag;
	}

	public String getElDepositEditFlag() {
		return elDepositEditFlag;
	}

	public void setElDepositEditFlag(String elDepositEditFlag) {
		this.elDepositEditFlag = elDepositEditFlag;
	}

	public String getRemarkSpecial() {
		return remarkSpecial;
	}

	public void setRemarkSpecial(String remarkSpecial) {
		this.remarkSpecial = remarkSpecial;
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

	public String getRemarkAqm() {
		return remarkAqm;
	}

	public void setRemarkAqm(String remarkAqm) {
		this.remarkAqm = remarkAqm;
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

	public String getPtTaxPayType() {
		return ptTaxPayType;
	}

	public void setPtTaxPayType(String ptTaxPayType) {
		this.ptTaxPayType = ptTaxPayType;
	}

	public String getPtRemark() {
		return ptRemark;
	}

	public void setPtRemark(String ptRemark) {
		this.ptRemark = ptRemark;
	}

	public String getPtRemarkBG() {
		return ptRemarkBG;
	}

	public void setPtRemarkBG(String ptRemarkBG) {
		this.ptRemarkBG = ptRemarkBG;
	}

	public String getInsFlag() {
		return insFlag;
	}

	public void setInsFlag(String insFlag) {
		this.insFlag = insFlag;
	}

	public String getInsFlagBG() {
		return insFlagBG;
	}

	public void setInsFlagBG(String insFlagBG) {
		this.insFlagBG = insFlagBG;
	}

	public Float getInsSumInsured() {
		return insSumInsured;
	}

	public void setInsSumInsured(Float insSumInsured) {
		this.insSumInsured = insSumInsured;
	}

	public String getInsSumInsuredBG() {
		return insSumInsuredBG;
	}

	public void setInsSumInsuredBG(String insSumInsuredBG) {
		this.insSumInsuredBG = insSumInsuredBG;
	}

	public Date getInsEffectiveDt() {
		return insEffectiveDt;
	}

	public void setInsEffectiveDt(Date insEffectiveDt) {
		this.insEffectiveDt = insEffectiveDt;
	}

	public String getInsEffectiveDtStr() {
		return insEffectiveDtStr;
	}

	public void setInsEffectiveDtStr(String insEffectiveDtStr) {
		this.insEffectiveDtStr = insEffectiveDtStr;
	}

	public String getInsEffectiveDtBG() {
		return insEffectiveDtBG;
	}

	public void setInsEffectiveDtBG(String insEffectiveDtBG) {
		this.insEffectiveDtBG = insEffectiveDtBG;
	}

	public Date getInsExpireDt() {
		return insExpireDt;
	}

	public void setInsExpireDt(Date insExpireDt) {
		this.insExpireDt = insExpireDt;
	}

	public String getInsExpireDtStr() {
		return insExpireDtStr;
	}

	public void setInsExpireDtStr(String insExpireDtStr) {
		this.insExpireDtStr = insExpireDtStr;
	}

	public String getInsExpireDtBG() {
		return insExpireDtBG;
	}

	public void setInsExpireDtBG(String insExpireDtBG) {
		this.insExpireDtBG = insExpireDtBG;
	}

	public String getInsBeneficiary() {
		return insBeneficiary;
	}

	public void setInsBeneficiary(String insBeneficiary) {
		this.insBeneficiary = insBeneficiary;
	}

	public String getInsBeneficiaryBG() {
		return insBeneficiaryBG;
	}

	public void setInsBeneficiaryBG(String insBeneficiaryBG) {
		this.insBeneficiaryBG = insBeneficiaryBG;
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

	public String getMailEditFlag() {
		return mailEditFlag;
	}

	public void setMailEditFlag(String mailEditFlag) {
		this.mailEditFlag = mailEditFlag;
	}

	public String getAssignBy() {
		return assignBy;
	}

	public void setAssignBy(String assignBy) {
		this.assignBy = assignBy;
	}

	public String getAssignToTeam() {
		return assignToTeam;
	}

	public void setAssignToTeam(String assignToTeam) {
		this.assignToTeam = assignToTeam;
	}

	public String getAssignToUser() {
		return assignToUser;
	}

	public void setAssignToUser(String assignToUser) {
		this.assignToUser = assignToUser;
	}

	public Date getLeaderApproveDt() {
		return leaderApproveDt;
	}

	public void setLeaderApproveDt(Date leaderApproveDt) {
		this.leaderApproveDt = leaderApproveDt;
	}

	public String getLeaderApproveDtStr() {
		return leaderApproveDtStr;
	}

	public void setLeaderApproveDtStr(String leaderApproveDtStr) {
		this.leaderApproveDtStr = leaderApproveDtStr;
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

	public String getLeaderApproveStatus() {
		return leaderApproveStatus;
	}

	public void setLeaderApproveStatus(String leaderApproveStatus) {
		this.leaderApproveStatus = leaderApproveStatus;
	}

	public Date getManagerApproveDt() {
		return managerApproveDt;
	}

	public void setManagerApproveDt(Date managerApproveDt) {
		this.managerApproveDt = managerApproveDt;
	}

	public String getManagerApproveDtStr() {
		return managerApproveDtStr;
	}

	public void setManagerApproveDtStr(String managerApproveDtStr) {
		this.managerApproveDtStr = managerApproveDtStr;
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

	public String getManagerApproveStatus() {
		return managerApproveStatus;
	}

	public void setManagerApproveStatus(String managerApproveStatus) {
		this.managerApproveStatus = managerApproveStatus;
	}

	public Date getLegalApproveDt() {
		return legalApproveDt;
	}

	public void setLegalApproveDt(Date legalApproveDt) {
		this.legalApproveDt = legalApproveDt;
	}

	public String getLegalApproveDtStr() {
		return legalApproveDtStr;
	}

	public void setLegalApproveDtStr(String legalApproveDtStr) {
		this.legalApproveDtStr = legalApproveDtStr;
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

	public String getLegalApproveStatus() {
		return legalApproveStatus;
	}

	public void setLegalApproveStatus(String legalApproveStatus) {
		this.legalApproveStatus = legalApproveStatus;
	}

	public Date getAvpApproveDt() {
		return avpApproveDt;
	}

	public void setAvpApproveDt(Date avpApproveDt) {
		this.avpApproveDt = avpApproveDt;
	}

	public String getAvpApproveDtStr() {
		return avpApproveDtStr;
	}

	public void setAvpApproveDtStr(String avpApproveDtStr) {
		this.avpApproveDtStr = avpApproveDtStr;
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

	public String getAvpApproveStatus() {
		return avpApproveStatus;
	}

	public void setAvpApproveStatus(String avpApproveStatus) {
		this.avpApproveStatus = avpApproveStatus;
	}

	public String getFlowStatus() {
		return flowStatus;
	}

	public void setFlowStatus(String flowStatus) {
		this.flowStatus = flowStatus;
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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getFlowDt() {
		return flowDt;
	}

	public void setFlowDt(Date flowDt) {
		this.flowDt = flowDt;
	}

	public String getFlowDtStr() {
		return flowDtStr;
	}

	public void setFlowDtStr(String flowDtStr) {
		this.flowDtStr = flowDtStr;
	}

	public String getFlowStatusId() {
		return flowStatusId;
	}

	public void setFlowStatusId(String flowStatusId) {
		this.flowStatusId = flowStatusId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getEffectiveDtFrom() {
		return effectiveDtFrom;
	}

	public void setEffectiveDtFrom(Date effectiveDtFrom) {
		this.effectiveDtFrom = effectiveDtFrom;
	}

	public Date getEffectiveDtTo() {
		return effectiveDtTo;
	}

	public void setEffectiveDtTo(Date effectiveDtTo) {
		this.effectiveDtTo = effectiveDtTo;
	}

	public Date getExpireDtFrom() {
		return expireDtFrom;
	}

	public void setExpireDtFrom(Date expireDtFrom) {
		this.expireDtFrom = expireDtFrom;
	}

	public Date getExpireDtTo() {
		return expireDtTo;
	}

	public void setExpireDtTo(Date expireDtTo) {
		this.expireDtTo = expireDtTo;
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

	public Date getBatchDt() {
		return batchDt;
	}

	public void setBatchDt(Date batchDt) {
		this.batchDt = batchDt;
	}

	public String getBatchDtStr() {
		return batchDtStr;
	}

	public void setBatchDtStr(String batchDtStr) {
		this.batchDtStr = batchDtStr;
	}

	public String getBatchSum() {
		return batchSum;
	}

	public void setBatchSum(String batchSum) {
		this.batchSum = batchSum;
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

	public Float getVersion() {
		return version;
	}

	public void setVersion(Float version) {
		this.version = version;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
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

	public String getSiteZone() {
		return siteZone;
	}

	public void setSiteZone(String siteZone) {
		this.siteZone = siteZone;
	}

	public String getSiteDetail() {
		return siteDetail;
	}

	public void setSiteDetail(String siteDetail) {
		this.siteDetail = siteDetail;
	}

	public String getStationType() {
		return stationType;
	}

	public void setStationType(String stationType) {
		this.stationType = stationType;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getMenuGroup() {
		return menuGroup;
	}

	public void setMenuGroup(String menuGroup) {
		this.menuGroup = menuGroup;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRetResult() {
		return retResult;
	}

	public void setRetResult(String retResult) {
		this.retResult = retResult;
	}

	public String getSumNewSite() {
		return sumNewSite;
	}

	public void setSumNewSite(String sumNewSite) {
		this.sumNewSite = sumNewSite;
	}

	public String getSumReNewSite() {
		return sumReNewSite;
	}

	public void setSumReNewSite(String sumReNewSite) {
		this.sumReNewSite = sumReNewSite;
	}

	public String getSumEditSite() {
		return sumEditSite;
	}

	public void setSumEditSite(String sumEditSite) {
		this.sumEditSite = sumEditSite;
	}

	public String getSumWaitTerminate() {
		return sumWaitTerminate;
	}

	public void setSumWaitTerminate(String sumWaitTerminate) {
		this.sumWaitTerminate = sumWaitTerminate;
	}

	public String getSumterminate() {
		return sumterminate;
	}

	public void setSumterminate(String sumterminate) {
		this.sumterminate = sumterminate;
	}

	public String getSumTotal() {
		return sumTotal;
	}

	public void setSumTotal(String sumTotal) {
		this.sumTotal = sumTotal;
	}

	public String getToTeam() {
		return toTeam;
	}

	public void setToTeam(String toTeam) {
		this.toTeam = toTeam;
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getStrDataList() {
		return strDataList;
	}

	public void setStrDataList(String strDataList) {
		this.strDataList = strDataList;
	}

	public String getStrParam() {
		return strParam;
	}

	public void setStrParam(String strParam) {
		this.strParam = strParam;
	}

	public String getNetworkStatus() {
		return networkStatus;
	}

	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
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

	public Date getAssignDt() {
		return assignDt;
	}

	public void setAssignDt(Date assignDt) {
		this.assignDt = assignDt;
	}

	public String getAssignDtStr() {
		return assignDtStr;
	}

	public void setAssignDtStr(String assignDtStr) {
		this.assignDtStr = assignDtStr;
	}

	public Date getStatusDt() {
		return statusDt;
	}

	public void setStatusDt(Date statusDt) {
		this.statusDt = statusDt;
	}

	public String getStatusDtStr() {
		return statusDtStr;
	}

	public void setStatusDtStr(String statusDtStr) {
		this.statusDtStr = statusDtStr;
	}

	public Date getApproveDt() {
		return approveDt;
	}

	public void setApproveDt(Date approveDt) {
		this.approveDt = approveDt;
	}

	public String getApproveDtStr() {
		return approveDtStr;
	}

	public void setApproveDtStr(String approveDtStr) {
		this.approveDtStr = approveDtStr;
	}

	public String getUpdateDtStr() {
		return updateDtStr;
	}

	public void setUpdateDtStr(String updateDtStr) {
		this.updateDtStr = updateDtStr;
	}

	public String getApproveBy() {
		return approveBy;
	}

	public void setApproveBy(String approveBy) {
		this.approveBy = approveBy;
	}

	public String getCostPerYear() {
		return costPerYear;
	}

	public void setCostPerYear(String costPerYear) {
		this.costPerYear = costPerYear;
	}

	public String getModifiedDetail() {
		return modifiedDetail;
	}

	public void setModifiedDetail(String modifiedDetail) {
		this.modifiedDetail = modifiedDetail;
	}

	public String getNearSiteCost() {
		return nearSiteCost;
	}

	public void setNearSiteCost(String nearSiteCost) {
		this.nearSiteCost = nearSiteCost;
	}

	public String getGrowingCost() {
		return growingCost;
	}

	public void setGrowingCost(String growingCost) {
		this.growingCost = growingCost;
	}

	public String getPlaceType() {
		return placeType;
	}

	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}

	public String getPartiesType() {
		return partiesType;
	}

	public void setPartiesType(String partiesType) {
		this.partiesType = partiesType;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public Date getTerminateCancelContractDt() {
		return terminateCancelContractDt;
	}

	public void setTerminateCancelContractDt(Date terminateCancelContractDt) {
		this.terminateCancelContractDt = terminateCancelContractDt;
	}

	public Date getTerminateRemoveEndDt() {
		return terminateRemoveEndDt;
	}

	public void setTerminateRemoveEndDt(Date terminateRemoveEndDt) {
		this.terminateRemoveEndDt = terminateRemoveEndDt;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRevenue() {
		return revenue;
	}

	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}

	public String getRetResultMsg() {
		return retResultMsg;
	}

	public void setRetResultMsg(String retResultMsg) {
		this.retResultMsg = retResultMsg;
	}

}
