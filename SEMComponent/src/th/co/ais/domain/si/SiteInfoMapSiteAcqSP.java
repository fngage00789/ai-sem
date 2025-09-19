package th.co.ais.domain.si;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.domain.sa.SiteAppSiteSP;
import th.co.ais.util.WrapperBeanObject;

public class SiteInfoMapSiteAcqSP extends AbstractDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = -338722021248166120L;
	
	protected String rowId; 
	protected String siteAppId;
	private String siteInfoId;
	
	protected String contractId;
	protected String contractNo;
	protected String contractStatus;
	protected BigDecimal contractTime;
	protected BigDecimal contractTimeSeq;
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
	protected String docDtStr;
	protected String docTypeText;
	protected String docStatusText;
	protected String docTypeDesc;
	
	protected String title;
	protected String region;
	protected String company;

	protected String needLegalApprove;
	protected String needAvpApprove;
	protected String needConstruction;
	
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
	private String locationAmphur;
	protected String locationAmphurId;
	protected String locationProvinceId;
	protected String locationPostCode;
	protected String locationEditFlag;
	protected String locationPhase;
	
	protected BigDecimal landArea;
	protected String landAreaType;
	protected String landAreaUnitType;
	protected BigDecimal deckArea;
	protected String deckAreaType;
	protected String deckAreaUnitType;
	protected BigDecimal buildingArea;
	private String buildingAreaType;
	protected String buildingAreaUnitType;
	protected BigDecimal roomArea;
	protected String roomAreaType;
	protected String roomAreaUnitType;
	protected String areaRemark;
	protected String areaRemarkBG;
	
	protected Date effectiveDt;
	protected String effectiveDtStr;
	protected Date expireDt;
	protected String expireDtStr;
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
	
	protected BigDecimal rentAmt;
	protected String rentAmtBG;
	protected BigDecimal rentAmtPerYear;
	protected String rentPeriodType;
	protected String rentDetail;
	protected String rentDetailBG;
	protected String rentWhtDetail;
	protected String rentWhtDetailBG;
	protected String rentWhtType;
	protected BigDecimal rentWhtRate;
	protected String rentWhtRateMod;
	protected BigDecimal rentServiceAmt;
	protected String rentServiceAmtBG;
	protected String rentServicePeriodType;
	protected String rentServiceDetail;
	protected String rentServiceDetailBG;
	protected String rentServiceVatType;
	protected String rentServiceVatTypeBG;
	protected String rentServiceWht;
	protected String rentServiceWhtBG;
	protected String rentServiceWhtType;
	protected BigDecimal rentServiceWhtRate;
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
	protected Integer rentPaymentPeriodOth;
	protected Integer rentPaymentPeriodType;
	protected String rentDepositFlag;
	protected BigDecimal rentDepositBgAmt;
	protected String rentDepositBgVat;
	protected BigDecimal rentDepositCashAmt;
	protected String rentDepositCashVat;
	protected String rentRemark;
	protected String rentEditFlag;
	protected String rentDepositEditFlag;
	
	protected BigDecimal totalRentService;
	protected String totalRentServiceBG;
	
	protected String elUseMultiResourse;
	protected String elUseNewMeter;
	protected String elUseOldMeter;
	protected String elUseOwner;
	protected String elOwnerType;
	
	protected String elPayOnPackage;
	protected BigDecimal elPayOnPackageAmt;
	protected String elPackagePeriodType;
	protected String elPayOnUsed;
	protected BigDecimal elUnitPrice;
	protected String elVatType;
	protected String elVatTypeName;
	protected String payOnUsedDesc;
	protected String payOnUsedDescBG;
	protected String elRemark;
	protected String elRemarkBG;
	protected String elDepositFlag;
	protected BigDecimal elBgDeposit;
	protected String elBgDepositVatType;
	protected BigDecimal elCashDeposit;
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
	protected String ptTaxPayTypeName;
	protected String ptRemark;
	protected String ptRemarkBG;

	protected String insFlag;
	protected String insFlagBG;
	protected BigDecimal insSumInsured;
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
	
	protected Date assignDt;
	protected String assignDtStr;
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
	
	
	protected BigDecimal version;
	protected String system;
	protected Date statusDT;
	protected String siteCode;
	protected String siteId;
	protected String siteGroup;
	protected String siteType;
	protected String siteNameTh;
	protected String siteZone;
	protected String siteDetail;
	protected String stationType;
	protected String stationTypeBG;
	
	protected String teamName;
	protected String menuGroup;
	protected String menuGroupType;
	
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
	protected Date statusDt;
	protected Date approveDt;
	protected String statusDtStr;
	protected String approveDtStr;
	protected String approveBy;
	protected Date approveDT;
	protected String costPerYear;
	protected String modifiedDetail;
	protected String nearSiteCost;
	protected String growingCost;
	
	protected String payBy;
	protected String payByBG;
	
	protected String placeType;
	protected String placeTypeOther;
	protected String partiesType;
	protected String partiesTypeOther;
	
	protected String stationName;
	
	protected String locationNameBG;
	protected String coLocateCompanyBG;
	protected String coContractNoBG;
	protected String locationTypeBG;
	protected String locationAddressNoBG;
	protected String locationBuildingBG;
	protected String locationFloorBG;
	protected String locationRoomNoBG;
	protected String locationStreetBG;
	protected String locationTambonBG;
	protected String locationAmphurIdBG;
	protected String amphurName;
	protected String amphurNameBG;
	protected String locationProvinceIdBG;
	protected String provinceName;
	protected String provinceNameBG;
	protected String locationPostCodeBG;
	protected String landAreaBG;
	protected String landAreaTypeBG;
	protected String deckAreaBG;
	protected String buildingAreaBG;
	protected String roomAreaBG;
	protected Date updateDT;
	protected String updateDTStr;
	
	protected Date targetDt;
	protected String value1;
	protected String value2;
	protected String value3;
	protected String value4;
	protected String value5;
	protected String requestType;
	
	protected Date terminateCancelContractDt;
	protected Date terminateRemoveEndDt;
	protected String phase;
	protected String phaseBG;
	
	protected String siteApproveId;
	protected Date checkDt;
	protected Date receiveDt;
	protected Date outDt;
	protected String remark;
	protected String riskType1;
	protected String riskType1Remark;
	protected String riskType2;
	protected String riskType2Remark;
	protected String riskType3;
	protected String riskType3Remark;
	protected String riskTypeOther;
	protected String riskTypeOtherRemark;
	protected String rentType;
	protected String rentTypeOtherRemark;
	protected String doc1;
	protected String doc2;
	protected String doc3;
	protected String doc4;
	protected String doc5;
	protected String docOther;
	protected String docOtherRemark;
	protected String latestFlag;
	protected Date createDt;
	protected String createDtStr;
	protected String createBy;
	protected String updateBy;
	protected String doc6;
    protected String doc7;
    protected String doc8;
    protected String doc9;
    protected String doc10;
    protected Integer seqNo;
    protected String placeTypeRemark;
    protected String partiesTypeRemark;
    protected String mode;
    protected String UserLogin;
    
    protected String elUseType;
    protected BigDecimal elBGDeposit;
    protected String elBGDepositVatType;
    protected String elUseDesc;
    protected String elUseDescBG;
    protected String payDesc;
    protected String payDescBG;
    protected String elPackageDesc;
    protected String elPackageDescBG;
    
    protected String depositFlagDesc;
    protected String depositFlagDescBG;
    protected String bgDepositDesc;
    protected String bgDepositDescBG;
    protected String bgDepositVatDesc;
    protected String bgDepositVatDescBG;
    protected String cashDepositDesc;
    protected String cashDepositDescBG;
    protected String cashDepositvatDesc;
    protected String cashDepositvatDescBG;
    protected String cashDepositVatDesc;
    protected String cashDepositVatDescBG;
    protected String elDepositRemarkBG;
    
    protected String result;
    protected String message;

    protected BigDecimal revenue;
    
    protected String retResultMsg;
    protected String retResultMsgType;
    
    protected String towerType;
    protected String towerLocation;
    protected BigDecimal towerHeight;
    
    protected String contractNeverExpire;
    protected String contractWantedRemark;
    
    protected String rentVatType;
    protected String rentVatRate; //
    protected String rentServiceVatRate; //
    protected String remarkAfterApprove;
    
    protected BigDecimal rentAmtOld;
    protected String rentPeriodTypeOld;
    protected BigDecimal rentAmtAdd;
    protected BigDecimal rentAmtAddPerc;
    protected BigDecimal rentServAmtOld;
    protected String rentServPeriodTypeOld;
    protected BigDecimal rentServAmtAdd;
    protected BigDecimal rentServAmtAddPerc;
    
    
    // added by.. YUT 2015/02/19
    protected String contractNoOld;
    protected String showContractNoOldFlag;
    protected String isMacroType;
    protected String isMicroType;
    protected String isPicoType;
    protected String isRepeaterType;
    protected String isTowerType;
    protected String isWifiType;
    protected String isOtherType;
    protected String isOtherTypeDetail;
    
    protected BigDecimal rentDepositBgAmtOld;
    protected BigDecimal rentDepositBgAmtAdd;
    protected BigDecimal rentDepositCashAmtOld;
    protected BigDecimal rentDepositCashAmtAdd;
    
    protected String rentAreaMemoVatType;
    protected String rentAreaMemoWhtType;
    protected BigDecimal rentAreaMemoWhtRate;
    protected String rentServMemoVatType;
    protected String rentServMemoWhtType;
    protected BigDecimal rentServMemoWhtRate;
    protected String rentSetupMemoVatType;
    protected String rentSetupMemoWhtType;
    protected BigDecimal rentSetupMemoWhtRate;
    protected String rentOtherMemoVatType;
    protected String rentOtherMemoWhtType;
    protected BigDecimal rentOtherMemoWhtRate;
    
    // added by.. YUT 2015/03/10 
    protected String coCompany;
    protected String coCompanyContractNo;
    protected String isSmallcellType;
    protected String elUseOthSite;
    protected String elUseOth;
    protected String elUseOthSiteContractNo;
    //added by NEW 15022016 
    protected String elNoExpenses;
   
    public List<WrapperBeanObject<SiteAppSiteSP>> siteAppSiteList;
    
    // added by.. YUT 2015/03/19
    protected String reqTypeText;
    protected String revenuePerSite;
    protected String maxRent;
    protected String prevCost;
    protected String increasePerc;
    protected String expensivePerc;
    
    protected String reLocateContractNo;
    protected boolean selectFlag = false;
    
    //added by NEW 22/04/2015
    protected String servPaymentPeriod;
	protected String servPaymentPeriodBG;
	protected Integer servPaymentPeriodOth;
	protected Date changeEffectiveDT;
	protected String changeEffectiveDTStr;
	protected String isFBBType;
	protected String isOFCType;
	protected String isFTTXType;
	protected String owner;
	protected String docApproveId;
	
	protected String resultMsg;
    
    //added by NEW 21/05/2015
	protected BigDecimal elDepositBgAmtAdd;
	protected BigDecimal elDepositBgAmtOld;
	protected BigDecimal elDepositCashAmtAdd;
	protected BigDecimal elDepositCashAmtOld;
	
	//added by NEW 11/02/2016
	protected Integer servPaymentPeriodType;
	
	protected Date terminateContractDt;
	
	//added by NEW 16022016 
    protected String rentalNoExpenses;
	
	//added by NEW 12/02/2016
	protected String saveFlag = "N";
	
	protected String legalVatType;
	
	//added by NEW 2016/04/08 for popup nearest site
	private String locationArea;
	private BigDecimal maxRentNearestSite;
	private BigDecimal minRent;
	private BigDecimal avgRent;
	
	//added by NEW 2016/04/20 
	private String managerName;
	private String styleClassName;
	
	protected boolean rentSpecialFlag = false;
	
	private String expenseType;
	private String rentPeriod;
	private Integer cycleNo;

	private String coOperator;
	
	protected Date firstEffDt;
	protected Date effDt;
	private String noExpFlag;
	private String locationThName;
	
	private String leaseHoldRights;
	private String license;
	private String llRentalAgreement;
	
	private String siteAppRentContId;
	private String detail;
	private String rentOldAmt;
	private String rentAddPercent;
	private String rentAddAmt;
	private String whtType;
	private String whtRate;
	private String vatType;
	private String payPeriodType;
	private String payPeriodTypeName;
	private String payPeriod;
	private Date periodStartDt;
	private Date periodEndDt;
	private String periodStartDtStr;
	private String periodEndDtStr;
	private String rentAdj;
	private String rentAjdPeriodType;
	private String serviceId;
	private String rentContType;
	private String rentOldPeriodType;
	private String rentAddPeriodType;
	private String refSiteRentCondId;
	
	private String	siteAppDepositId;
	private String	depositType;
	private BigDecimal	depositAmt;
	private String	 depositReturnType;
	private BigDecimal	depositAmtOld;
	private BigDecimal	depositAmtNew;
	private BigDecimal	returnAmt;
	private BigDecimal	depositBringForward;
	private String	withdrawFlag;
	private String	depositTypeName;
	private String	depositStatus;
	private String	serviceName;
	private String	bgNo;
	private String	bgBang;
	private String	bgAmt;
	private Date	bgEffectiveDt;
	private String	bgEffectiveDtStr;
	private Date bgExpireDt;
	private String bgExpireDtStr;
	private String rentService;
	
	private String donate;
	private String support;
	private String all;
	private String other;
	
	private String rentServiceId;
	
	private String siteAppELContId;
	private String siteInfoELContId;
	private Date chgEffectiveDt;
	private String chgEffectiveDtStr;
	private String elType;
	private String elCondType;
	private String unitPriceAmt;
	private String elPeriodType;
	private String refSiteElCondId;
	private BigDecimal takeAllAmt;
	private Date ptEffectiveDt;
	private String ptEffectiveDtStr;
	
	//added by NEW 22/06/2018
	private String service;
	private String roomNo;
	private String deckAreaWidth;
	private String deckAreaLength;
	private String deckAreaOther;
	
	private String buildingAreaWidth;
	private String buildingAreaLength;
	private String buildingAreaOther;
	
	private String roomAreaWidth;
	private String roomAreaLength;
	private String roomAreaOther;
	
	private String landAreaWidth;
	private String landAreaLength;
	private String landAreaOther;
	
	private String docType;
	private String docTypeOther;
	private String buildingName;
	private String floor;
	
	private String docAreaRemark;
	private String docBuilding;
	private String docStreet;
	private String docFloor;
	private String docTambon;
	private String docAmphur;
	private String docProvince;
	private String docPostCode;
	
	private String specialCond;
	private String ownerTitleName;
	private String ownerName;
	
	private String lessorTitleName;
	private String lessorIdCard;
	private Date lessorBirthday;
	
	private String contactTitleName;
	private String contactIdCard;
	private String contactTaxId;
	private Date contactBirthday;
	
	private String contactHouseNo;
	private String contactHouseNoBG;
	private String contactBuilding;
	private String contactBuildingBG;
	private String contactFloor;
	private String contactFloorBG;
	private String contactRoomNo;
	private String contactRoomNoBG;
	private String contactStreet;
	private String contactStreetBG;
	private String contactTambon;
	private String contactTambonBG;
	private String contactAmphurId;
	private String contactProvinceId;
	private String contactPostCode;
	private String contactPostCodeBG;
	private String contactTaxIdBG;
	
	private Date startDt;
	private Date endDt;
	private String startDtStr;
	private String endDtStr;
	
	private String paymentType;
	private Date startPeriodDt;
	private Date endPeriodDt;
	private String reqKey;
	private String locationStatus;
	private String mainLocation;
	private String liveNetwork;
	
	
	private String locAddressNo;
	private String locBuilding;
	private String locFloor;
	private String locRoomNo;
	private String locStreet;
	private String locTumbol;
	private String locAmphur;
	private String locProvince;
	private String locZipCode;
	private String amphurThaiName;
	private String proviceThaiName;
	private String docLocAddrNo;
	private String docLocBuilding;
	private String docLocFloor;
	private String docLocStreet;
	private String docLocTambon;
	private String docLocAmphurId;
	private String docLocProvinceId;
	private String docLocPostCode;
	
	private Date rtStartPeriodDt;
	private Date rtEndPeriodDt;
	private Date rtStartChangePeriodDt;
	
	private Date changeContEffDt;
	private String changeContEffDtStr;
	
	private String item;
	
	private String reqOfficerOld; 
	private String reqOfficerNew; 
	private String slimsStatus;
	
	private String rentAdjPeriodType;
	private String rentCondType;
	private String rentContMode;
	private String newStatus;
	private String depositCondType;
	
	private String expenseName;
	private String rentPeriodName;
	private String rentWhtName;
	private String rentVatName;
	private String rentPaymentPeriodName;
	private String rentAdjPeriodName;
	private String rentOldPeriodName;
	private String rentAddPeriodName;
	private String vatTypeName;
	private String expenseTypeName;
	
	private BigDecimal depositReturnAmt;
	private String noUtilPrice; 
	private Date elEffectiveDt;
	
	private String elCondSubType;
	private BigDecimal elOldAmt;
	
	private String fromContractNo;
	private String refSiteElCond;
	private BigDecimal totalDepositCashAmt;
	private BigDecimal elAmt;
	private BigDecimal elAddAmt; 
	private String fromSiteInfoId; 
	private String elType2;
	private String elType1; 
	private BigDecimal totalDepositBgAmt; 
	private String elType4;
	private String elAddPeriodType; 
	private String elType3;
	private String elAdj;
	private String elAdjPeriodType; 
	private String takeAllPeriodType; 
	private String takeAllPeriodTypeName; 
	private String noDeposit;
	private String elAddPercent; 
	private String elOldPeriodType;
	private Integer elPayPeriod;
	private String rentalEditFlag;
	
	private String insuranceType;
	private String insuranceTypeName;
	private Double plxOldAmt;
    private Double plxAddAmt;
    private Double plxAmt;
    private Date plxEffectiveDt;
    private Date plxExpireDt;
    private String plxEffectiveDtStr;
    private String plxExpireDtStr;
    private Double ownerAmt;
    private String ownerPeriodType;
    private String ownerPeriodTypeName;
    private String ownerVatType;
    private String ownerVatTypeName;
    private String ownerPayPeriodType;
    private String ownerPayPeriodTypeName;
    private Integer ownerPayPeriod;
 	private Long versionIR;
 	
 	private String pTaxPaymentId;
 	private String pTaxYear;
 	private String periodAmt;
 	private String updateDtStr;
 	
 	private String siteAppInsuranceId;
 	private String siteInsuranceId;
 	private String noOwnerAmt;
 	private String plxBeneficiary;
 	
 	private String lessorTel;
 	private String lessorMobile;
 	private String lessorFax;
 	private String lessorEmail;
 	
 	private String elCondTypeName;
 	private String elCondSubTypeName;
 	
 	private String detail03;
 	private String detail04;
 	
 	private String noUnitPriceFlag;
 	
 	private Date elEffectiveDt03;
 	private Date elEffectiveDt04;
 	
 	private String rentalNoDeposit;
 	private String elNoDeposit;
 	private String legalPlaceType;
 	private String legalPartiesType;
 	private String legalDocType;
 	private String legalDocTypeOth;
 	private Date legalDocEffectiveDt;
 	private String legalDocEffectiveDtStr;
 	
 	private Date changeEffectiveDt;
 	private String changeEffectiveDtStr;
 	private String electricType;
 	private String electricTypeName;
 	private String  electricCondSubtype;
 	private String  electricCondSubtypeName;
 	private BigDecimal electricOldAmt;
 	private BigDecimal electricAddAmt;
 	private BigDecimal electricAmt;
 	private String  electricPeriodType;
 	private String  electricPeriodTypeName;
 	private String  refSiteElectricCondId;
 	private String canAdd;
 	private String canEdit;
 	
 	private String siteAppElContId;
 	private String contractStatusName;
 	private String terminateOfcontractFlag;
 	private String elType5;
 	
 	private String wthType;
 	private String wthTypeName;
 	private BigDecimal wthRate;
 	
 	
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

	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
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

	public String getDocDtStr() {
		return docDtStr;
	}

	public void setDocDtStr(String docDtStr) {
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

	public String getNeedConstruction() {
		return needConstruction;
	}

	public void setNeedConstruction(String needConstruction) {
		this.needConstruction = needConstruction;
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

	public String getLocationAmphur() {
		return locationAmphur;
	}

	public void setLocationAmphur(String locationAmphur) {
		this.locationAmphur = locationAmphur;
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

	public String getLandAreaUnitType() {
		return landAreaUnitType;
	}

	public void setLandAreaUnitType(String landAreaUnitType) {
		this.landAreaUnitType = landAreaUnitType;
	}

	public BigDecimal getDeckArea() {
		return deckArea;
	}

	public void setDeckArea(BigDecimal deckArea) {
		this.deckArea = deckArea;
	}

	public String getDeckAreaType() {
		return deckAreaType;
	}

	public void setDeckAreaType(String deckAreaType) {
		this.deckAreaType = deckAreaType;
	}

	public String getDeckAreaUnitType() {
		return deckAreaUnitType;
	}

	public void setDeckAreaUnitType(String deckAreaUnitType) {
		this.deckAreaUnitType = deckAreaUnitType;
	}

	public BigDecimal getBuildingArea() {
		return buildingArea;
	}

	public void setBuildingArea(BigDecimal buildingArea) {
		this.buildingArea = buildingArea;
	}

	public String getBuildingAreaType() {
		return buildingAreaType;
	}

	public void setBuildingAreaType(String buildingAreaType) {
		this.buildingAreaType = buildingAreaType;
	}

	public String getBuildingAreaUnitType() {
		return buildingAreaUnitType;
	}

	public void setBuildingAreaUnitType(String buildingAreaUnitType) {
		this.buildingAreaUnitType = buildingAreaUnitType;
	}

	public BigDecimal getRoomArea() {
		return roomArea;
	}

	public void setRoomArea(BigDecimal roomArea) {
		this.roomArea = roomArea;
	}

	public String getRoomAreaType() {
		return roomAreaType;
	}

	public void setRoomAreaType(String roomAreaType) {
		this.roomAreaType = roomAreaType;
	}

	public String getRoomAreaUnitType() {
		return roomAreaUnitType;
	}

	public void setRoomAreaUnitType(String roomAreaUnitType) {
		this.roomAreaUnitType = roomAreaUnitType;
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

	public BigDecimal getRentAmt() {
		return rentAmt;
	}

	public void setRentAmt(BigDecimal rentAmt) {
		this.rentAmt = rentAmt;
	}

	public String getRentAmtBG() {
		return rentAmtBG;
	}

	public void setRentAmtBG(String rentAmtBG) {
		this.rentAmtBG = rentAmtBG;
	}

	public BigDecimal getRentAmtPerYear() {
		return rentAmtPerYear;
	}

	public void setRentAmtPerYear(BigDecimal rentAmtPerYear) {
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

	public Integer getRentPaymentPeriodOth() {
		return rentPaymentPeriodOth;
	}

	public void setRentPaymentPeriodOth(Integer rentPaymentPeriodOth) {
		this.rentPaymentPeriodOth = rentPaymentPeriodOth;
	}

	public Integer getRentPaymentPeriodType() {
		return rentPaymentPeriodType;
	}

	public void setRentPaymentPeriodType(Integer rentPaymentPeriodType) {
		this.rentPaymentPeriodType = rentPaymentPeriodType;
	}

	public String getRentDepositFlag() {
		return rentDepositFlag;
	}

	public void setRentDepositFlag(String rentDepositFlag) {
		this.rentDepositFlag = rentDepositFlag;
	}

	public BigDecimal getRentDepositBgAmt() {
		return rentDepositBgAmt;
	}

	public void setRentDepositBgAmt(BigDecimal rentDepositBgAmt) {
		this.rentDepositBgAmt = rentDepositBgAmt;
	}

	public String getRentDepositBgVat() {
		return rentDepositBgVat;
	}

	public void setRentDepositBgVat(String rentDepositBgVat) {
		this.rentDepositBgVat = rentDepositBgVat;
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

	public BigDecimal getTotalRentService() {
		return totalRentService;
	}

	public void setTotalRentService(BigDecimal totalRentService) {
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

	public BigDecimal getElPayOnPackageAmt() {
		return elPayOnPackageAmt;
	}

	public void setElPayOnPackageAmt(BigDecimal elPayOnPackageAmt) {
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

	public String getElVatTypeName() {
		return elVatTypeName;
	}

	public void setElVatTypeName(String elVatTypeName) {
		this.elVatTypeName = elVatTypeName;
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

	public BigDecimal getElBgDeposit() {
		return elBgDeposit;
	}

	public void setElBgDeposit(BigDecimal elBgDeposit) {
		this.elBgDeposit = elBgDeposit;
	}

	public String getElBgDepositVatType() {
		return elBgDepositVatType;
	}

	public void setElBgDepositVatType(String elBgDepositVatType) {
		this.elBgDepositVatType = elBgDepositVatType;
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

	public String getPtTaxPayTypeName() {
		return ptTaxPayTypeName;
	}

	public void setPtTaxPayTypeName(String ptTaxPayTypeName) {
		this.ptTaxPayTypeName = ptTaxPayTypeName;
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

	public BigDecimal getInsSumInsured() {
		return insSumInsured;
	}

	public void setInsSumInsured(BigDecimal insSumInsured) {
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

	public BigDecimal getVersion() {
		return version;
	}

	public void setVersion(BigDecimal version) {
		this.version = version;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public Date getStatusDT() {
		return statusDT;
	}

	public void setStatusDT(Date statusDT) {
		this.statusDT = statusDT;
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

	public String getStationTypeBG() {
		return stationTypeBG;
	}

	public void setStationTypeBG(String stationTypeBG) {
		this.stationTypeBG = stationTypeBG;
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

	public String getMenuGroupType() {
		return menuGroupType;
	}

	public void setMenuGroupType(String menuGroupType) {
		this.menuGroupType = menuGroupType;
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

	public Date getStatusDt() {
		return statusDt;
	}

	public void setStatusDt(Date statusDt) {
		this.statusDt = statusDt;
	}

	public Date getApproveDt() {
		return approveDt;
	}

	public void setApproveDt(Date approveDt) {
		this.approveDt = approveDt;
	}

	public String getStatusDtStr() {
		return statusDtStr;
	}

	public void setStatusDtStr(String statusDtStr) {
		this.statusDtStr = statusDtStr;
	}

	public String getApproveDtStr() {
		return approveDtStr;
	}

	public void setApproveDtStr(String approveDtStr) {
		this.approveDtStr = approveDtStr;
	}

	public String getApproveBy() {
		return approveBy;
	}

	public void setApproveBy(String approveBy) {
		this.approveBy = approveBy;
	}

	public Date getApproveDT() {
		return approveDT;
	}

	public void setApproveDT(Date approveDT) {
		this.approveDT = approveDT;
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

	public String getPayBy() {
		return payBy;
	}

	public void setPayBy(String payBy) {
		this.payBy = payBy;
	}

	public String getPayByBG() {
		return payByBG;
	}

	public void setPayByBG(String payByBG) {
		this.payByBG = payByBG;
	}

	public String getPlaceType() {
		return placeType;
	}

	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}

	public String getPlaceTypeOther() {
		return placeTypeOther;
	}

	public void setPlaceTypeOther(String placeTypeOther) {
		this.placeTypeOther = placeTypeOther;
	}

	public String getPartiesType() {
		return partiesType;
	}

	public void setPartiesType(String partiesType) {
		this.partiesType = partiesType;
	}

	public String getPartiesTypeOther() {
		return partiesTypeOther;
	}

	public void setPartiesTypeOther(String partiesTypeOther) {
		this.partiesTypeOther = partiesTypeOther;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getLocationNameBG() {
		return locationNameBG;
	}

	public void setLocationNameBG(String locationNameBG) {
		this.locationNameBG = locationNameBG;
	}

	public String getCoLocateCompanyBG() {
		return coLocateCompanyBG;
	}

	public void setCoLocateCompanyBG(String coLocateCompanyBG) {
		this.coLocateCompanyBG = coLocateCompanyBG;
	}

	public String getCoContractNoBG() {
		return coContractNoBG;
	}

	public void setCoContractNoBG(String coContractNoBG) {
		this.coContractNoBG = coContractNoBG;
	}

	public String getLocationTypeBG() {
		return locationTypeBG;
	}

	public void setLocationTypeBG(String locationTypeBG) {
		this.locationTypeBG = locationTypeBG;
	}

	public String getLocationAddressNoBG() {
		return locationAddressNoBG;
	}

	public void setLocationAddressNoBG(String locationAddressNoBG) {
		this.locationAddressNoBG = locationAddressNoBG;
	}

	public String getLocationBuildingBG() {
		return locationBuildingBG;
	}

	public void setLocationBuildingBG(String locationBuildingBG) {
		this.locationBuildingBG = locationBuildingBG;
	}

	public String getLocationFloorBG() {
		return locationFloorBG;
	}

	public void setLocationFloorBG(String locationFloorBG) {
		this.locationFloorBG = locationFloorBG;
	}

	public String getLocationRoomNoBG() {
		return locationRoomNoBG;
	}

	public void setLocationRoomNoBG(String locationRoomNoBG) {
		this.locationRoomNoBG = locationRoomNoBG;
	}

	public String getLocationStreetBG() {
		return locationStreetBG;
	}

	public void setLocationStreetBG(String locationStreetBG) {
		this.locationStreetBG = locationStreetBG;
	}

	public String getLocationTambonBG() {
		return locationTambonBG;
	}

	public void setLocationTambonBG(String locationTambonBG) {
		this.locationTambonBG = locationTambonBG;
	}

	public String getLocationAmphurIdBG() {
		return locationAmphurIdBG;
	}

	public void setLocationAmphurIdBG(String locationAmphurIdBG) {
		this.locationAmphurIdBG = locationAmphurIdBG;
	}

	public String getAmphurName() {
		return amphurName;
	}

	public void setAmphurName(String amphurName) {
		this.amphurName = amphurName;
	}

	public String getAmphurNameBG() {
		return amphurNameBG;
	}

	public void setAmphurNameBG(String amphurNameBG) {
		this.amphurNameBG = amphurNameBG;
	}

	public String getLocationProvinceIdBG() {
		return locationProvinceIdBG;
	}

	public void setLocationProvinceIdBG(String locationProvinceIdBG) {
		this.locationProvinceIdBG = locationProvinceIdBG;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getProvinceNameBG() {
		return provinceNameBG;
	}

	public void setProvinceNameBG(String provinceNameBG) {
		this.provinceNameBG = provinceNameBG;
	}

	public String getLocationPostCodeBG() {
		return locationPostCodeBG;
	}

	public void setLocationPostCodeBG(String locationPostCodeBG) {
		this.locationPostCodeBG = locationPostCodeBG;
	}

	public String getLandAreaBG() {
		return landAreaBG;
	}

	public void setLandAreaBG(String landAreaBG) {
		this.landAreaBG = landAreaBG;
	}

	public String getLandAreaTypeBG() {
		return landAreaTypeBG;
	}

	public void setLandAreaTypeBG(String landAreaTypeBG) {
		this.landAreaTypeBG = landAreaTypeBG;
	}

	public String getDeckAreaBG() {
		return deckAreaBG;
	}

	public void setDeckAreaBG(String deckAreaBG) {
		this.deckAreaBG = deckAreaBG;
	}

	public String getBuildingAreaBG() {
		return buildingAreaBG;
	}

	public void setBuildingAreaBG(String buildingAreaBG) {
		this.buildingAreaBG = buildingAreaBG;
	}

	public String getRoomAreaBG() {
		return roomAreaBG;
	}

	public void setRoomAreaBG(String roomAreaBG) {
		this.roomAreaBG = roomAreaBG;
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

	public Date getTargetDt() {
		return targetDt;
	}

	public void setTargetDt(Date targetDt) {
		this.targetDt = targetDt;
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public String getValue3() {
		return value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
	}

	public String getValue4() {
		return value4;
	}

	public void setValue4(String value4) {
		this.value4 = value4;
	}

	public String getValue5() {
		return value5;
	}

	public void setValue5(String value5) {
		this.value5 = value5;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
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

	public String getPhaseBG() {
		return phaseBG;
	}

	public void setPhaseBG(String phaseBG) {
		this.phaseBG = phaseBG;
	}

	public String getSiteApproveId() {
		return siteApproveId;
	}

	public void setSiteApproveId(String siteApproveId) {
		this.siteApproveId = siteApproveId;
	}

	public Date getCheckDt() {
		return checkDt;
	}

	public void setCheckDt(Date checkDt) {
		this.checkDt = checkDt;
	}

	public Date getReceiveDt() {
		return receiveDt;
	}

	public void setReceiveDt(Date receiveDt) {
		this.receiveDt = receiveDt;
	}

	public Date getOutDt() {
		return outDt;
	}

	public void setOutDt(Date outDt) {
		this.outDt = outDt;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRiskType1() {
		return riskType1;
	}

	public void setRiskType1(String riskType1) {
		this.riskType1 = riskType1;
	}

	public String getRiskType1Remark() {
		return riskType1Remark;
	}

	public void setRiskType1Remark(String riskType1Remark) {
		this.riskType1Remark = riskType1Remark;
	}

	public String getRiskType2() {
		return riskType2;
	}

	public void setRiskType2(String riskType2) {
		this.riskType2 = riskType2;
	}

	public String getRiskType2Remark() {
		return riskType2Remark;
	}

	public void setRiskType2Remark(String riskType2Remark) {
		this.riskType2Remark = riskType2Remark;
	}

	public String getRiskType3() {
		return riskType3;
	}

	public void setRiskType3(String riskType3) {
		this.riskType3 = riskType3;
	}

	public String getRiskType3Remark() {
		return riskType3Remark;
	}

	public void setRiskType3Remark(String riskType3Remark) {
		this.riskType3Remark = riskType3Remark;
	}

	public String getRiskTypeOther() {
		return riskTypeOther;
	}

	public void setRiskTypeOther(String riskTypeOther) {
		this.riskTypeOther = riskTypeOther;
	}

	public String getRiskTypeOtherRemark() {
		return riskTypeOtherRemark;
	}

	public void setRiskTypeOtherRemark(String riskTypeOtherRemark) {
		this.riskTypeOtherRemark = riskTypeOtherRemark;
	}

	public String getRentType() {
		return rentType;
	}

	public void setRentType(String rentType) {
		this.rentType = rentType;
	}

	public String getRentTypeOtherRemark() {
		return rentTypeOtherRemark;
	}

	public void setRentTypeOtherRemark(String rentTypeOtherRemark) {
		this.rentTypeOtherRemark = rentTypeOtherRemark;
	}

	public String getDoc1() {
		return doc1;
	}

	public void setDoc1(String doc1) {
		this.doc1 = doc1;
	}

	public String getDoc2() {
		return doc2;
	}

	public void setDoc2(String doc2) {
		this.doc2 = doc2;
	}

	public String getDoc3() {
		return doc3;
	}

	public void setDoc3(String doc3) {
		this.doc3 = doc3;
	}

	public String getDoc4() {
		return doc4;
	}

	public void setDoc4(String doc4) {
		this.doc4 = doc4;
	}

	public String getDoc5() {
		return doc5;
	}

	public void setDoc5(String doc5) {
		this.doc5 = doc5;
	}

	public String getDocOther() {
		return docOther;
	}

	public void setDocOther(String docOther) {
		this.docOther = docOther;
	}

	public String getDocOtherRemark() {
		return docOtherRemark;
	}

	public void setDocOtherRemark(String docOtherRemark) {
		this.docOtherRemark = docOtherRemark;
	}

	public String getLatestFlag() {
		return latestFlag;
	}

	public void setLatestFlag(String latestFlag) {
		this.latestFlag = latestFlag;
	}

	public String getCreateDtStr() {
		return createDtStr;
	}

	public void setCreateDtStr(String createDtStr) {
		this.createDtStr = createDtStr;
	}

	public String getDoc6() {
		return doc6;
	}

	public void setDoc6(String doc6) {
		this.doc6 = doc6;
	}

	public String getDoc7() {
		return doc7;
	}

	public void setDoc7(String doc7) {
		this.doc7 = doc7;
	}

	public String getDoc8() {
		return doc8;
	}

	public void setDoc8(String doc8) {
		this.doc8 = doc8;
	}

	public String getDoc9() {
		return doc9;
	}

	public void setDoc9(String doc9) {
		this.doc9 = doc9;
	}

	public String getDoc10() {
		return doc10;
	}

	public void setDoc10(String doc10) {
		this.doc10 = doc10;
	}

	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	public String getPlaceTypeRemark() {
		return placeTypeRemark;
	}

	public void setPlaceTypeRemark(String placeTypeRemark) {
		this.placeTypeRemark = placeTypeRemark;
	}

	public String getPartiesTypeRemark() {
		return partiesTypeRemark;
	}

	public void setPartiesTypeRemark(String partiesTypeRemark) {
		this.partiesTypeRemark = partiesTypeRemark;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
	
	public String getElUseType() {
		return elUseType;
	}

	public void setElUseType(String elUseType) {
		this.elUseType = elUseType;
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

	public String getElUseDesc() {
		return elUseDesc;
	}

	public void setElUseDesc(String elUseDesc) {
		this.elUseDesc = elUseDesc;
	}

	public String getElUseDescBG() {
		return elUseDescBG;
	}

	public void setElUseDescBG(String elUseDescBG) {
		this.elUseDescBG = elUseDescBG;
	}

	public String getPayDesc() {
		return payDesc;
	}

	public void setPayDesc(String payDesc) {
		this.payDesc = payDesc;
	}

	public String getPayDescBG() {
		return payDescBG;
	}

	public void setPayDescBG(String payDescBG) {
		this.payDescBG = payDescBG;
	}

	public String getElPackageDesc() {
		return elPackageDesc;
	}

	public void setElPackageDesc(String elPackageDesc) {
		this.elPackageDesc = elPackageDesc;
	}

	public String getElPackageDescBG() {
		return elPackageDescBG;
	}

	public void setElPackageDescBG(String elPackageDescBG) {
		this.elPackageDescBG = elPackageDescBG;
	}

	public String getDepositFlagDesc() {
		return depositFlagDesc;
	}

	public void setDepositFlagDesc(String depositFlagDesc) {
		this.depositFlagDesc = depositFlagDesc;
	}

	public String getDepositFlagDescBG() {
		return depositFlagDescBG;
	}

	public void setDepositFlagDescBG(String depositFlagDescBG) {
		this.depositFlagDescBG = depositFlagDescBG;
	}

	public String getBgDepositDesc() {
		return bgDepositDesc;
	}

	public void setBgDepositDesc(String bgDepositDesc) {
		this.bgDepositDesc = bgDepositDesc;
	}

	public String getBgDepositDescBG() {
		return bgDepositDescBG;
	}

	public void setBgDepositDescBG(String bgDepositDescBG) {
		this.bgDepositDescBG = bgDepositDescBG;
	}

	public String getBgDepositVatDesc() {
		return bgDepositVatDesc;
	}

	public void setBgDepositVatDesc(String bgDepositVatDesc) {
		this.bgDepositVatDesc = bgDepositVatDesc;
	}

	public String getBgDepositVatDescBG() {
		return bgDepositVatDescBG;
	}

	public void setBgDepositVatDescBG(String bgDepositVatDescBG) {
		this.bgDepositVatDescBG = bgDepositVatDescBG;
	}

	public String getCashDepositDesc() {
		return cashDepositDesc;
	}

	public void setCashDepositDesc(String cashDepositDesc) {
		this.cashDepositDesc = cashDepositDesc;
	}

	public String getCashDepositDescBG() {
		return cashDepositDescBG;
	}

	public void setCashDepositDescBG(String cashDepositDescBG) {
		this.cashDepositDescBG = cashDepositDescBG;
	}

	public String getCashDepositvatDesc() {
		return cashDepositvatDesc;
	}

	public void setCashDepositvatDesc(String cashDepositvatDesc) {
		this.cashDepositvatDesc = cashDepositvatDesc;
	}

	public String getCashDepositvatDescBG() {
		return cashDepositvatDescBG;
	}

	public void setCashDepositvatDescBG(String cashDepositvatDescBG) {
		this.cashDepositvatDescBG = cashDepositvatDescBG;
	}

	public String getCashDepositVatDesc() {
		return cashDepositVatDesc;
	}

	public void setCashDepositVatDesc(String cashDepositVatDesc) {
		this.cashDepositVatDesc = cashDepositVatDesc;
	}

	public String getCashDepositVatDescBG() {
		return cashDepositVatDescBG;
	}

	public void setCashDepositVatDescBG(String cashDepositVatDescBG) {
		this.cashDepositVatDescBG = cashDepositVatDescBG;
	}

	public String getElDepositRemarkBG() {
		return elDepositRemarkBG;
	}

	public void setElDepositRemarkBG(String elDepositRemarkBG) {
		this.elDepositRemarkBG = elDepositRemarkBG;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BigDecimal getRevenue() {
		return revenue;
	}

	public void setRevenue(BigDecimal revenue) {
		this.revenue = revenue;
	}

	public String getRetResultMsg() {
		return retResultMsg;
	}

	public void setRetResultMsg(String retResultMsg) {
		this.retResultMsg = retResultMsg;
	}

	public String getRetResultMsgType() {
		return retResultMsgType;
	}

	public void setRetResultMsgType(String retResultMsgType) {
		this.retResultMsgType = retResultMsgType;
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

	public BigDecimal getTowerHeight() {
		return towerHeight;
	}

	public void setTowerHeight(BigDecimal towerHeight) {
		this.towerHeight = towerHeight;
	}

	public String getContractNeverExpire() {
		return contractNeverExpire;
	}

	public void setContractNeverExpire(String contractNeverExpire) {
		this.contractNeverExpire = contractNeverExpire;
	}

	public String getContractWantedRemark() {
		return contractWantedRemark;
	}

	public void setContractWantedRemark(String contractWantedRemark) {
		this.contractWantedRemark = contractWantedRemark;
	}

	public String getRentVatType() {
		return rentVatType;
	}

	public void setRentVatType(String rentVatType) {
		this.rentVatType = rentVatType;
	}

	public String getRentVatRate() {
		return rentVatRate;
	}

	public void setRentVatRate(String rentVatRate) {
		this.rentVatRate = rentVatRate;
	}

	public String getRentServiceVatRate() {
		return rentServiceVatRate;
	}

	public void setRentServiceVatRate(String rentServiceVatRate) {
		this.rentServiceVatRate = rentServiceVatRate;
	}

	public String getRemarkAfterApprove() {
		return remarkAfterApprove;
	}

	public void setRemarkAfterApprove(String remarkAfterApprove) {
		this.remarkAfterApprove = remarkAfterApprove;
	}

	public BigDecimal getRentAmtOld() {
		return rentAmtOld;
	}

	public void setRentAmtOld(BigDecimal rentAmtOld) {
		this.rentAmtOld = rentAmtOld;
	}

	public String getRentPeriodTypeOld() {
		return rentPeriodTypeOld;
	}

	public void setRentPeriodTypeOld(String rentPeriodTypeOld) {
		this.rentPeriodTypeOld = rentPeriodTypeOld;
	}

	public BigDecimal getRentAmtAdd() {
		return rentAmtAdd;
	}

	public void setRentAmtAdd(BigDecimal rentAmtAdd) {
		this.rentAmtAdd = rentAmtAdd;
	}

	public BigDecimal getRentAmtAddPerc() {
		return rentAmtAddPerc;
	}

	public void setRentAmtAddPerc(BigDecimal rentAmtAddPerc) {
		this.rentAmtAddPerc = rentAmtAddPerc;
	}

	public BigDecimal getRentServAmtOld() {
		return rentServAmtOld;
	}

	public void setRentServAmtOld(BigDecimal rentServAmtOld) {
		this.rentServAmtOld = rentServAmtOld;
	}

	public String getRentServPeriodTypeOld() {
		return rentServPeriodTypeOld;
	}

	public void setRentServPeriodTypeOld(String rentServPeriodTypeOld) {
		this.rentServPeriodTypeOld = rentServPeriodTypeOld;
	}

	public BigDecimal getRentServAmtAdd() {
		return rentServAmtAdd;
	}

	public void setRentServAmtAdd(BigDecimal rentServAmtAdd) {
		this.rentServAmtAdd = rentServAmtAdd;
	}

	public BigDecimal getRentServAmtAddPerc() {
		return rentServAmtAddPerc;
	}

	public void setRentServAmtAddPerc(BigDecimal rentServAmtAddPerc) {
		this.rentServAmtAddPerc = rentServAmtAddPerc;
	}

	public String getContractNoOld() {
		return contractNoOld;
	}

	public void setContractNoOld(String contractNoOld) {
		this.contractNoOld = contractNoOld;
	}

	public String getShowContractNoOldFlag() {
		return showContractNoOldFlag;
	}

	public void setShowContractNoOldFlag(String showContractNoOldFlag) {
		this.showContractNoOldFlag = showContractNoOldFlag;
	}

	public String getIsMacroType() {
		return isMacroType;
	}

	public void setIsMacroType(String isMacroType) {
		this.isMacroType = isMacroType;
	}

	public String getIsMicroType() {
		return isMicroType;
	}

	public void setIsMicroType(String isMicroType) {
		this.isMicroType = isMicroType;
	}

	public String getIsPicoType() {
		return isPicoType;
	}

	public void setIsPicoType(String isPicoType) {
		this.isPicoType = isPicoType;
	}

	public String getIsRepeaterType() {
		return isRepeaterType;
	}

	public void setIsRepeaterType(String isRepeaterType) {
		this.isRepeaterType = isRepeaterType;
	}

	public String getIsTowerType() {
		return isTowerType;
	}

	public void setIsTowerType(String isTowerType) {
		this.isTowerType = isTowerType;
	}

	public String getIsWifiType() {
		return isWifiType;
	}

	public void setIsWifiType(String isWifiType) {
		this.isWifiType = isWifiType;
	}

	public String getIsOtherType() {
		return isOtherType;
	}

	public void setIsOtherType(String isOtherType) {
		this.isOtherType = isOtherType;
	}

	public String getIsOtherTypeDetail() {
		return isOtherTypeDetail;
	}

	public void setIsOtherTypeDetail(String isOtherTypeDetail) {
		this.isOtherTypeDetail = isOtherTypeDetail;
	}

	public BigDecimal getRentDepositBgAmtOld() {
		return rentDepositBgAmtOld;
	}

	public void setRentDepositBgAmtOld(BigDecimal rentDepositBgAmtOld) {
		this.rentDepositBgAmtOld = rentDepositBgAmtOld;
	}

	public BigDecimal getRentDepositBgAmtAdd() {
		return rentDepositBgAmtAdd;
	}

	public void setRentDepositBgAmtAdd(BigDecimal rentDepositBgAmtAdd) {
		this.rentDepositBgAmtAdd = rentDepositBgAmtAdd;
	}

	public BigDecimal getRentDepositCashAmtOld() {
		return rentDepositCashAmtOld;
	}

	public void setRentDepositCashAmtOld(BigDecimal rentDepositCashAmtOld) {
		this.rentDepositCashAmtOld = rentDepositCashAmtOld;
	}

	public BigDecimal getRentDepositCashAmtAdd() {
		return rentDepositCashAmtAdd;
	}

	public void setRentDepositCashAmtAdd(BigDecimal rentDepositCashAmtAdd) {
		this.rentDepositCashAmtAdd = rentDepositCashAmtAdd;
	}

	public String getRentAreaMemoVatType() {
		return rentAreaMemoVatType;
	}

	public void setRentAreaMemoVatType(String rentAreaMemoVatType) {
		this.rentAreaMemoVatType = rentAreaMemoVatType;
	}

	public String getRentAreaMemoWhtType() {
		return rentAreaMemoWhtType;
	}

	public void setRentAreaMemoWhtType(String rentAreaMemoWhtType) {
		this.rentAreaMemoWhtType = rentAreaMemoWhtType;
	}

	public BigDecimal getRentAreaMemoWhtRate() {
		return rentAreaMemoWhtRate;
	}

	public void setRentAreaMemoWhtRate(BigDecimal rentAreaMemoWhtRate) {
		this.rentAreaMemoWhtRate = rentAreaMemoWhtRate;
	}

	public String getRentServMemoVatType() {
		return rentServMemoVatType;
	}

	public void setRentServMemoVatType(String rentServMemoVatType) {
		this.rentServMemoVatType = rentServMemoVatType;
	}

	public String getRentServMemoWhtType() {
		return rentServMemoWhtType;
	}

	public void setRentServMemoWhtType(String rentServMemoWhtType) {
		this.rentServMemoWhtType = rentServMemoWhtType;
	}

	public BigDecimal getRentServMemoWhtRate() {
		return rentServMemoWhtRate;
	}

	public void setRentServMemoWhtRate(BigDecimal rentServMemoWhtRate) {
		this.rentServMemoWhtRate = rentServMemoWhtRate;
	}

	public String getRentSetupMemoVatType() {
		return rentSetupMemoVatType;
	}

	public void setRentSetupMemoVatType(String rentSetupMemoVatType) {
		this.rentSetupMemoVatType = rentSetupMemoVatType;
	}

	public String getRentSetupMemoWhtType() {
		return rentSetupMemoWhtType;
	}

	public void setRentSetupMemoWhtType(String rentSetupMemoWhtType) {
		this.rentSetupMemoWhtType = rentSetupMemoWhtType;
	}

	public BigDecimal getRentSetupMemoWhtRate() {
		return rentSetupMemoWhtRate;
	}

	public void setRentSetupMemoWhtRate(BigDecimal rentSetupMemoWhtRate) {
		this.rentSetupMemoWhtRate = rentSetupMemoWhtRate;
	}

	public String getRentOtherMemoVatType() {
		return rentOtherMemoVatType;
	}

	public void setRentOtherMemoVatType(String rentOtherMemoVatType) {
		this.rentOtherMemoVatType = rentOtherMemoVatType;
	}

	public String getRentOtherMemoWhtType() {
		return rentOtherMemoWhtType;
	}

	public void setRentOtherMemoWhtType(String rentOtherMemoWhtType) {
		this.rentOtherMemoWhtType = rentOtherMemoWhtType;
	}

	public BigDecimal getRentOtherMemoWhtRate() {
		return rentOtherMemoWhtRate;
	}

	public void setRentOtherMemoWhtRate(BigDecimal rentOtherMemoWhtRate) {
		this.rentOtherMemoWhtRate = rentOtherMemoWhtRate;
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

	public String getElUseOthSite() {
		return elUseOthSite;
	}

	public void setElUseOthSite(String elUseOthSite) {
		this.elUseOthSite = elUseOthSite;
	}

	public String getElUseOth() {
		return elUseOth;
	}

	public void setElUseOth(String elUseOth) {
		this.elUseOth = elUseOth;
	}

	public String getElUseOthSiteContractNo() {
		return elUseOthSiteContractNo;
	}

	public void setElUseOthSiteContractNo(String elUseOthSiteContractNo) {
		this.elUseOthSiteContractNo = elUseOthSiteContractNo;
	}

	public String getElNoExpenses() {
		return elNoExpenses;
	}

	public void setElNoExpenses(String elNoExpenses) {
		this.elNoExpenses = elNoExpenses;
	}

	public List<WrapperBeanObject<SiteAppSiteSP>> getSiteAppSiteList() {
		return siteAppSiteList;
	}

	public void setSiteAppSiteList(
			List<WrapperBeanObject<SiteAppSiteSP>> siteAppSiteList) {
		this.siteAppSiteList = siteAppSiteList;
	}

	public String getReqTypeText() {
		return reqTypeText;
	}

	public void setReqTypeText(String reqTypeText) {
		this.reqTypeText = reqTypeText;
	}

	public String getRevenuePerSite() {
		return revenuePerSite;
	}

	public void setRevenuePerSite(String revenuePerSite) {
		this.revenuePerSite = revenuePerSite;
	}

	public String getMaxRent() {
		return maxRent;
	}

	public void setMaxRent(String maxRent) {
		this.maxRent = maxRent;
	}

	public String getPrevCost() {
		return prevCost;
	}

	public void setPrevCost(String prevCost) {
		this.prevCost = prevCost;
	}

	public String getIncreasePerc() {
		return increasePerc;
	}

	public void setIncreasePerc(String increasePerc) {
		this.increasePerc = increasePerc;
	}

	public String getExpensivePerc() {
		return expensivePerc;
	}

	public void setExpensivePerc(String expensivePerc) {
		this.expensivePerc = expensivePerc;
	}

	public String getReLocateContractNo() {
		return reLocateContractNo;
	}

	public void setReLocateContractNo(String reLocateContractNo) {
		this.reLocateContractNo = reLocateContractNo;
	}

	public boolean isSelectFlag() {
		return selectFlag;
	}

	public void setSelectFlag(boolean selectFlag) {
		this.selectFlag = selectFlag;
	}

	public String getServPaymentPeriod() {
		return servPaymentPeriod;
	}

	public void setServPaymentPeriod(String servPaymentPeriod) {
		this.servPaymentPeriod = servPaymentPeriod;
	}

	public String getServPaymentPeriodBG() {
		return servPaymentPeriodBG;
	}

	public void setServPaymentPeriodBG(String servPaymentPeriodBG) {
		this.servPaymentPeriodBG = servPaymentPeriodBG;
	}

	public Integer getServPaymentPeriodOth() {
		return servPaymentPeriodOth;
	}

	public void setServPaymentPeriodOth(Integer servPaymentPeriodOth) {
		this.servPaymentPeriodOth = servPaymentPeriodOth;
	}

	public Date getChangeEffectiveDT() {
		return changeEffectiveDT;
	}

	public void setChangeEffectiveDT(Date changeEffectiveDT) {
		this.changeEffectiveDT = changeEffectiveDT;
	}

	public String getChangeEffectiveDTStr() {
		return changeEffectiveDTStr;
	}

	public void setChangeEffectiveDTStr(String changeEffectiveDTStr) {
		this.changeEffectiveDTStr = changeEffectiveDTStr;
	}

	public String getIsFBBType() {
		return isFBBType;
	}

	public void setIsFBBType(String isFBBType) {
		this.isFBBType = isFBBType;
	}

	public String getIsOFCType() {
		return isOFCType;
	}

	public void setIsOFCType(String isOFCType) {
		this.isOFCType = isOFCType;
	}

	public String getIsFTTXType() {
		return isFTTXType;
	}

	public void setIsFTTXType(String isFTTXType) {
		this.isFTTXType = isFTTXType;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getDocApproveId() {
		return docApproveId;
	}

	public void setDocApproveId(String docApproveId) {
		this.docApproveId = docApproveId;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public BigDecimal getElDepositBgAmtAdd() {
		return elDepositBgAmtAdd;
	}

	public void setElDepositBgAmtAdd(BigDecimal elDepositBgAmtAdd) {
		this.elDepositBgAmtAdd = elDepositBgAmtAdd;
	}

	public BigDecimal getElDepositBgAmtOld() {
		return elDepositBgAmtOld;
	}

	public void setElDepositBgAmtOld(BigDecimal elDepositBgAmtOld) {
		this.elDepositBgAmtOld = elDepositBgAmtOld;
	}

	public BigDecimal getElDepositCashAmtAdd() {
		return elDepositCashAmtAdd;
	}

	public void setElDepositCashAmtAdd(BigDecimal elDepositCashAmtAdd) {
		this.elDepositCashAmtAdd = elDepositCashAmtAdd;
	}

	public BigDecimal getElDepositCashAmtOld() {
		return elDepositCashAmtOld;
	}

	public void setElDepositCashAmtOld(BigDecimal elDepositCashAmtOld) {
		this.elDepositCashAmtOld = elDepositCashAmtOld;
	}

	public Integer getServPaymentPeriodType() {
		return servPaymentPeriodType;
	}

	public void setServPaymentPeriodType(Integer servPaymentPeriodType) {
		this.servPaymentPeriodType = servPaymentPeriodType;
	}

	public Date getTerminateContractDt() {
		return terminateContractDt;
	}

	public void setTerminateContractDt(Date terminateContractDt) {
		this.terminateContractDt = terminateContractDt;
	}

	public String getRentalNoExpenses() {
		return rentalNoExpenses;
	}

	public void setRentalNoExpenses(String rentalNoExpenses) {
		this.rentalNoExpenses = rentalNoExpenses;
	}

	public String getSaveFlag() {
		return saveFlag;
	}

	public void setSaveFlag(String saveFlag) {
		this.saveFlag = saveFlag;
	}

	public String getLegalVatType() {
		return legalVatType;
	}

	public void setLegalVatType(String legalVatType) {
		this.legalVatType = legalVatType;
	}

	public String getLocationArea() {
		return locationArea;
	}

	public void setLocationArea(String locationArea) {
		this.locationArea = locationArea;
	}

	public BigDecimal getMaxRentNearestSite() {
		return maxRentNearestSite;
	}

	public void setMaxRentNearestSite(BigDecimal maxRentNearestSite) {
		this.maxRentNearestSite = maxRentNearestSite;
	}

	public BigDecimal getMinRent() {
		return minRent;
	}

	public void setMinRent(BigDecimal minRent) {
		this.minRent = minRent;
	}

	public BigDecimal getAvgRent() {
		return avgRent;
	}

	public void setAvgRent(BigDecimal avgRent) {
		this.avgRent = avgRent;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getStyleClassName() {
		return styleClassName;
	}

	public void setStyleClassName(String styleClassName) {
		this.styleClassName = styleClassName;
	}

	public boolean isRentSpecialFlag() {
		return rentSpecialFlag;
	}

	public void setRentSpecialFlag(boolean rentSpecialFlag) {
		this.rentSpecialFlag = rentSpecialFlag;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getRentPeriod() {
		return rentPeriod;
	}

	public void setRentPeriod(String rentPeriod) {
		this.rentPeriod = rentPeriod;
	}

	public Integer getCycleNo() {
		return cycleNo;
	}

	public void setCycleNo(Integer cycleNo) {
		this.cycleNo = cycleNo;
	}

	public String getCoOperator() {
		return coOperator;
	}

	public void setCoOperator(String coOperator) {
		this.coOperator = coOperator;
	}

	public Date getFirstEffDt() {
		return firstEffDt;
	}

	public void setFirstEffDt(Date firstEffDt) {
		this.firstEffDt = firstEffDt;
	}

	public Date getEffDt() {
		return effDt;
	}

	public void setEffDt(Date effDt) {
		this.effDt = effDt;
	}

	public String getNoExpFlag() {
		return noExpFlag;
	}

	public void setNoExpFlag(String noExpFlag) {
		this.noExpFlag = noExpFlag;
	}

	public String getLocationThName() {
		return locationThName;
	}

	public void setLocationThName(String locationThName) {
		this.locationThName = locationThName;
	}

	public String getLeaseHoldRights() {
		return leaseHoldRights;
	}

	public void setLeaseHoldRights(String leaseHoldRights) {
		this.leaseHoldRights = leaseHoldRights;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getLlRentalAgreement() {
		return llRentalAgreement;
	}

	public void setLlRentalAgreement(String llRentalAgreement) {
		this.llRentalAgreement = llRentalAgreement;
	}

	public String getSiteAppRentContId() {
		return siteAppRentContId;
	}

	public void setSiteAppRentContId(String siteAppRentContId) {
		this.siteAppRentContId = siteAppRentContId;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getRentOldAmt() {
		return rentOldAmt;
	}

	public void setRentOldAmt(String rentOldAmt) {
		this.rentOldAmt = rentOldAmt;
	}

	public String getRentAddPercent() {
		return rentAddPercent;
	}

	public void setRentAddPercent(String rentAddPercent) {
		this.rentAddPercent = rentAddPercent;
	}

	public String getRentAddAmt() {
		return rentAddAmt;
	}

	public void setRentAddAmt(String rentAddAmt) {
		this.rentAddAmt = rentAddAmt;
	}

	public String getWhtType() {
		return whtType;
	}

	public void setWhtType(String whtType) {
		this.whtType = whtType;
	}

	public String getWhtRate() {
		return whtRate;
	}

	public void setWhtRate(String whtRate) {
		this.whtRate = whtRate;
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

	public String getPayPeriodTypeName() {
		return payPeriodTypeName;
	}

	public void setPayPeriodTypeName(String payPeriodTypeName) {
		this.payPeriodTypeName = payPeriodTypeName;
	}

	public String getPayPeriod() {
		return payPeriod;
	}

	public void setPayPeriod(String payPeriod) {
		this.payPeriod = payPeriod;
	}

	public Date getPeriodStartDt() {
		return periodStartDt;
	}

	public void setPeriodStartDt(Date periodStartDt) {
		this.periodStartDt = periodStartDt;
	}

	public Date getPeriodEndDt() {
		return periodEndDt;
	}

	public void setPeriodEndDt(Date periodEndDt) {
		this.periodEndDt = periodEndDt;
	}

	public String getPeriodStartDtStr() {
		return periodStartDtStr;
	}

	public void setPeriodStartDtStr(String periodStartDtStr) {
		this.periodStartDtStr = periodStartDtStr;
	}

	public String getPeriodEndDtStr() {
		return periodEndDtStr;
	}

	public void setPeriodEndDtStr(String periodEndDtStr) {
		this.periodEndDtStr = periodEndDtStr;
	}

	public String getRentAdj() {
		return rentAdj;
	}

	public void setRentAdj(String rentAdj) {
		this.rentAdj = rentAdj;
	}

	public String getRentAjdPeriodType() {
		return rentAjdPeriodType;
	}

	public void setRentAjdPeriodType(String rentAjdPeriodType) {
		this.rentAjdPeriodType = rentAjdPeriodType;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getRentContType() {
		return rentContType;
	}

	public void setRentContType(String rentContType) {
		this.rentContType = rentContType;
	}

	public String getRentOldPeriodType() {
		return rentOldPeriodType;
	}

	public void setRentOldPeriodType(String rentOldPeriodType) {
		this.rentOldPeriodType = rentOldPeriodType;
	}

	public String getRentAddPeriodType() {
		return rentAddPeriodType;
	}

	public void setRentAddPeriodType(String rentAddPeriodType) {
		this.rentAddPeriodType = rentAddPeriodType;
	}

	public String getRefSiteRentCondId() {
		return refSiteRentCondId;
	}

	public void setRefSiteRentCondId(String refSiteRentCondId) {
		this.refSiteRentCondId = refSiteRentCondId;
	}

	public String getSiteAppDepositId() {
		return siteAppDepositId;
	}

	public void setSiteAppDepositId(String siteAppDepositId) {
		this.siteAppDepositId = siteAppDepositId;
	}

	public String getDepositType() {
		return depositType;
	}

	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}

	public BigDecimal getDepositAmt() {
		return depositAmt;
	}

	public void setDepositAmt(BigDecimal depositAmt) {
		this.depositAmt = depositAmt;
	}

	public String getDepositReturnType() {
		return depositReturnType;
	}

	public void setDepositReturnType(String depositReturnType) {
		this.depositReturnType = depositReturnType;
	}

	public BigDecimal getDepositAmtOld() {
		return depositAmtOld;
	}

	public void setDepositAmtOld(BigDecimal depositAmtOld) {
		this.depositAmtOld = depositAmtOld;
	}

	public BigDecimal getDepositAmtNew() {
		return depositAmtNew;
	}

	public void setDepositAmtNew(BigDecimal depositAmtNew) {
		this.depositAmtNew = depositAmtNew;
	}

	public BigDecimal getReturnAmt() {
		return returnAmt;
	}

	public void setReturnAmt(BigDecimal returnAmt) {
		this.returnAmt = returnAmt;
	}

	public BigDecimal getDepositBringForward() {
		return depositBringForward;
	}

	public void setDepositBringForward(BigDecimal depositBringForward) {
		this.depositBringForward = depositBringForward;
	}

	public String getWithdrawFlag() {
		return withdrawFlag;
	}

	public void setWithdrawFlag(String withdrawFlag) {
		this.withdrawFlag = withdrawFlag;
	}

	public String getDepositTypeName() {
		return depositTypeName;
	}

	public void setDepositTypeName(String depositTypeName) {
		this.depositTypeName = depositTypeName;
	}

	public String getDepositStatus() {
		return depositStatus;
	}

	public void setDepositStatus(String depositStatus) {
		this.depositStatus = depositStatus;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getBgNo() {
		return bgNo;
	}

	public void setBgNo(String bgNo) {
		this.bgNo = bgNo;
	}

	public String getBgBang() {
		return bgBang;
	}

	public void setBgBang(String bgBang) {
		this.bgBang = bgBang;
	}

	public String getBgAmt() {
		return bgAmt;
	}

	public void setBgAmt(String bgAmt) {
		this.bgAmt = bgAmt;
	}

	public Date getBgEffectiveDt() {
		return bgEffectiveDt;
	}

	public void setBgEffectiveDt(Date bgEffectiveDt) {
		this.bgEffectiveDt = bgEffectiveDt;
	}

	public String getBgEffectiveDtStr() {
		return bgEffectiveDtStr;
	}

	public void setBgEffectiveDtStr(String bgEffectiveDtStr) {
		this.bgEffectiveDtStr = bgEffectiveDtStr;
	}

	public Date getBgExpireDt() {
		return bgExpireDt;
	}

	public void setBgExpireDt(Date bgExpireDt) {
		this.bgExpireDt = bgExpireDt;
	}

	public String getBgExpireDtStr() {
		return bgExpireDtStr;
	}

	public void setBgExpireDtStr(String bgExpireDtStr) {
		this.bgExpireDtStr = bgExpireDtStr;
	}

	public String getRentService() {
		return rentService;
	}

	public void setRentService(String rentService) {
		this.rentService = rentService;
	}

	public String getDonate() {
		return donate;
	}

	public void setDonate(String donate) {
		this.donate = donate;
	}

	public String getSupport() {
		return support;
	}

	public void setSupport(String support) {
		this.support = support;
	}

	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getRentServiceId() {
		return rentServiceId;
	}

	public void setRentServiceId(String rentServiceId) {
		this.rentServiceId = rentServiceId;
	}

	public String getSiteAppELContId() {
		return siteAppELContId;
	}

	public void setSiteAppELContId(String siteAppELContId) {
		this.siteAppELContId = siteAppELContId;
	}

	public Date getChgEffectiveDt() {
		return chgEffectiveDt;
	}

	public void setChgEffectiveDt(Date chgEffectiveDt) {
		this.chgEffectiveDt = chgEffectiveDt;
	}

	public String getChgEffectiveDtStr() {
		return chgEffectiveDtStr;
	}

	public void setChgEffectiveDtStr(String chgEffectiveDtStr) {
		this.chgEffectiveDtStr = chgEffectiveDtStr;
	}

	public String getElType() {
		return elType;
	}

	public void setElType(String elType) {
		this.elType = elType;
	}

	public String getElCondType() {
		return elCondType;
	}

	public void setElCondType(String elCondType) {
		this.elCondType = elCondType;
	}

	public String getUnitPriceAmt() {
		return unitPriceAmt;
	}

	public void setUnitPriceAmt(String unitPriceAmt) {
		this.unitPriceAmt = unitPriceAmt;
	}

	public String getElPeriodType() {
		return elPeriodType;
	}

	public void setElPeriodType(String elPeriodType) {
		this.elPeriodType = elPeriodType;
	}

	public String getRefSiteElCondId() {
		return refSiteElCondId;
	}

	public void setRefSiteElCondId(String refSiteElCondId) {
		this.refSiteElCondId = refSiteElCondId;
	}

	public BigDecimal getTakeAllAmt() {
		return takeAllAmt;
	}

	public void setTakeAllAmt(BigDecimal takeAllAmt) {
		this.takeAllAmt = takeAllAmt;
	}

	public Date getPtEffectiveDt() {
		return ptEffectiveDt;
	}

	public void setPtEffectiveDt(Date ptEffectiveDt) {
		this.ptEffectiveDt = ptEffectiveDt;
	}

	public String getPtEffectiveDtStr() {
		return ptEffectiveDtStr;
	}

	public void setPtEffectiveDtStr(String ptEffectiveDtStr) {
		this.ptEffectiveDtStr = ptEffectiveDtStr;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getDeckAreaWidth() {
		return deckAreaWidth;
	}

	public void setDeckAreaWidth(String deckAreaWidth) {
		this.deckAreaWidth = deckAreaWidth;
	}

	public String getDeckAreaLength() {
		return deckAreaLength;
	}

	public void setDeckAreaLength(String deckAreaLength) {
		this.deckAreaLength = deckAreaLength;
	}

	public String getDeckAreaOther() {
		return deckAreaOther;
	}

	public void setDeckAreaOther(String deckAreaOther) {
		this.deckAreaOther = deckAreaOther;
	}

	public String getBuildingAreaWidth() {
		return buildingAreaWidth;
	}

	public void setBuildingAreaWidth(String buildingAreaWidth) {
		this.buildingAreaWidth = buildingAreaWidth;
	}

	public String getBuildingAreaLength() {
		return buildingAreaLength;
	}

	public void setBuildingAreaLength(String buildingAreaLength) {
		this.buildingAreaLength = buildingAreaLength;
	}

	public String getBuildingAreaOther() {
		return buildingAreaOther;
	}

	public void setBuildingAreaOther(String buildingAreaOther) {
		this.buildingAreaOther = buildingAreaOther;
	}

	public String getRoomAreaWidth() {
		return roomAreaWidth;
	}

	public void setRoomAreaWidth(String roomAreaWidth) {
		this.roomAreaWidth = roomAreaWidth;
	}

	public String getRoomAreaLength() {
		return roomAreaLength;
	}

	public void setRoomAreaLength(String roomAreaLength) {
		this.roomAreaLength = roomAreaLength;
	}

	public String getRoomAreaOther() {
		return roomAreaOther;
	}

	public void setRoomAreaOther(String roomAreaOther) {
		this.roomAreaOther = roomAreaOther;
	}

	public String getLandAreaWidth() {
		return landAreaWidth;
	}

	public void setLandAreaWidth(String landAreaWidth) {
		this.landAreaWidth = landAreaWidth;
	}

	public String getLandAreaLength() {
		return landAreaLength;
	}

	public void setLandAreaLength(String landAreaLength) {
		this.landAreaLength = landAreaLength;
	}

	public String getLandAreaOther() {
		return landAreaOther;
	}

	public void setLandAreaOther(String landAreaOther) {
		this.landAreaOther = landAreaOther;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getDocTypeOther() {
		return docTypeOther;
	}

	public void setDocTypeOther(String docTypeOther) {
		this.docTypeOther = docTypeOther;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getDocAreaRemark() {
		return docAreaRemark;
	}

	public void setDocAreaRemark(String docAreaRemark) {
		this.docAreaRemark = docAreaRemark;
	}

	public String getDocBuilding() {
		return docBuilding;
	}

	public void setDocBuilding(String docBuilding) {
		this.docBuilding = docBuilding;
	}

	public String getDocStreet() {
		return docStreet;
	}

	public void setDocStreet(String docStreet) {
		this.docStreet = docStreet;
	}

	public String getDocFloor() {
		return docFloor;
	}

	public void setDocFloor(String docFloor) {
		this.docFloor = docFloor;
	}

	public String getDocTambon() {
		return docTambon;
	}

	public void setDocTambon(String docTambon) {
		this.docTambon = docTambon;
	}

	public String getDocAmphur() {
		return docAmphur;
	}

	public void setDocAmphur(String docAmphur) {
		this.docAmphur = docAmphur;
	}

	public String getDocProvince() {
		return docProvince;
	}

	public void setDocProvince(String docProvince) {
		this.docProvince = docProvince;
	}

	public String getDocPostCode() {
		return docPostCode;
	}

	public void setDocPostCode(String docPostCode) {
		this.docPostCode = docPostCode;
	}

	public String getSpecialCond() {
		return specialCond;
	}

	public void setSpecialCond(String specialCond) {
		this.specialCond = specialCond;
	}

	public String getOwnerTitleName() {
		return ownerTitleName;
	}

	public void setOwnerTitleName(String ownerTitleName) {
		this.ownerTitleName = ownerTitleName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getLessorTitleName() {
		return lessorTitleName;
	}

	public void setLessorTitleName(String lessorTitleName) {
		this.lessorTitleName = lessorTitleName;
	}

	public String getLessorIdCard() {
		return lessorIdCard;
	}

	public void setLessorIdCard(String lessorIdCard) {
		this.lessorIdCard = lessorIdCard;
	}

	public Date getLessorBirthday() {
		return lessorBirthday;
	}

	public void setLessorBirthday(Date lessorBirthday) {
		this.lessorBirthday = lessorBirthday;
	}

	public String getContactTitleName() {
		return contactTitleName;
	}

	public void setContactTitleName(String contactTitleName) {
		this.contactTitleName = contactTitleName;
	}

	public String getContactIdCard() {
		return contactIdCard;
	}

	public void setContactIdCard(String contactIdCard) {
		this.contactIdCard = contactIdCard;
	}

	public String getContactTaxId() {
		return contactTaxId;
	}

	public void setContactTaxId(String contactTaxId) {
		this.contactTaxId = contactTaxId;
	}

	public Date getContactBirthday() {
		return contactBirthday;
	}

	public void setContactBirthday(Date contactBirthday) {
		this.contactBirthday = contactBirthday;
	}

	public String getContactHouseNo() {
		return contactHouseNo;
	}

	public void setContactHouseNo(String contactHouseNo) {
		this.contactHouseNo = contactHouseNo;
	}

	public String getContactHouseNoBG() {
		return contactHouseNoBG;
	}

	public void setContactHouseNoBG(String contactHouseNoBG) {
		this.contactHouseNoBG = contactHouseNoBG;
	}

	public String getContactBuilding() {
		return contactBuilding;
	}

	public void setContactBuilding(String contactBuilding) {
		this.contactBuilding = contactBuilding;
	}

	public String getContactBuildingBG() {
		return contactBuildingBG;
	}

	public void setContactBuildingBG(String contactBuildingBG) {
		this.contactBuildingBG = contactBuildingBG;
	}

	public String getContactFloor() {
		return contactFloor;
	}

	public void setContactFloor(String contactFloor) {
		this.contactFloor = contactFloor;
	}

	public String getContactFloorBG() {
		return contactFloorBG;
	}

	public void setContactFloorBG(String contactFloorBG) {
		this.contactFloorBG = contactFloorBG;
	}

	public String getContactRoomNo() {
		return contactRoomNo;
	}

	public void setContactRoomNo(String contactRoomNo) {
		this.contactRoomNo = contactRoomNo;
	}

	public String getContactRoomNoBG() {
		return contactRoomNoBG;
	}

	public void setContactRoomNoBG(String contactRoomNoBG) {
		this.contactRoomNoBG = contactRoomNoBG;
	}

	public String getContactStreet() {
		return contactStreet;
	}

	public void setContactStreet(String contactStreet) {
		this.contactStreet = contactStreet;
	}

	public String getContactStreetBG() {
		return contactStreetBG;
	}

	public void setContactStreetBG(String contactStreetBG) {
		this.contactStreetBG = contactStreetBG;
	}

	public String getContactTambon() {
		return contactTambon;
	}

	public void setContactTambon(String contactTambon) {
		this.contactTambon = contactTambon;
	}

	public String getContactTambonBG() {
		return contactTambonBG;
	}

	public void setContactTambonBG(String contactTambonBG) {
		this.contactTambonBG = contactTambonBG;
	}

	public String getContactAmphurId() {
		return contactAmphurId;
	}

	public void setContactAmphurId(String contactAmphurId) {
		this.contactAmphurId = contactAmphurId;
	}

	public String getContactProvinceId() {
		return contactProvinceId;
	}

	public void setContactProvinceId(String contactProvinceId) {
		this.contactProvinceId = contactProvinceId;
	}

	public String getContactPostCode() {
		return contactPostCode;
	}

	public void setContactPostCode(String contactPostCode) {
		this.contactPostCode = contactPostCode;
	}

	public String getContactPostCodeBG() {
		return contactPostCodeBG;
	}

	public void setContactPostCodeBG(String contactPostCodeBG) {
		this.contactPostCodeBG = contactPostCodeBG;
	}

	public String getContactTaxIdBG() {
		return contactTaxIdBG;
	}

	public void setContactTaxIdBG(String contactTaxIdBG) {
		this.contactTaxIdBG = contactTaxIdBG;
	}

	public Date getStartDt() {
		return startDt;
	}

	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}

	public Date getEndDt() {
		return endDt;
	}

	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}

	public String getStartDtStr() {
		return startDtStr;
	}

	public void setStartDtStr(String startDtStr) {
		this.startDtStr = startDtStr;
	}

	public String getEndDtStr() {
		return endDtStr;
	}

	public void setEndDtStr(String endDtStr) {
		this.endDtStr = endDtStr;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Date getStartPeriodDt() {
		return startPeriodDt;
	}

	public void setStartPeriodDt(Date startPeriodDt) {
		this.startPeriodDt = startPeriodDt;
	}

	public Date getEndPeriodDt() {
		return endPeriodDt;
	}

	public void setEndPeriodDt(Date endPeriodDt) {
		this.endPeriodDt = endPeriodDt;
	}

	public String getReqKey() {
		return reqKey;
	}

	public void setReqKey(String reqKey) {
		this.reqKey = reqKey;
	}

	public String getLocationStatus() {
		return locationStatus;
	}

	public void setLocationStatus(String locationStatus) {
		this.locationStatus = locationStatus;
	}

	public String getMainLocation() {
		return mainLocation;
	}

	public void setMainLocation(String mainLocation) {
		this.mainLocation = mainLocation;
	}

	public String getLiveNetwork() {
		return liveNetwork;
	}

	public void setLiveNetwork(String liveNetwork) {
		this.liveNetwork = liveNetwork;
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

	public String getLocRoomNo() {
		return locRoomNo;
	}

	public void setLocRoomNo(String locRoomNo) {
		this.locRoomNo = locRoomNo;
	}

	public String getLocStreet() {
		return locStreet;
	}

	public void setLocStreet(String locStreet) {
		this.locStreet = locStreet;
	}

	public String getLocTumbol() {
		return locTumbol;
	}

	public void setLocTumbol(String locTumbol) {
		this.locTumbol = locTumbol;
	}

	public String getLocAmphur() {
		return locAmphur;
	}

	public void setLocAmphur(String locAmphur) {
		this.locAmphur = locAmphur;
	}

	public String getLocProvince() {
		return locProvince;
	}

	public void setLocProvince(String locProvince) {
		this.locProvince = locProvince;
	}

	public String getLocZipCode() {
		return locZipCode;
	}

	public void setLocZipCode(String locZipCode) {
		this.locZipCode = locZipCode;
	}

	public String getAmphurThaiName() {
		return amphurThaiName;
	}

	public void setAmphurThaiName(String amphurThaiName) {
		this.amphurThaiName = amphurThaiName;
	}

	public String getProviceThaiName() {
		return proviceThaiName;
	}

	public void setProviceThaiName(String proviceThaiName) {
		this.proviceThaiName = proviceThaiName;
	}

	public String getDocLocAddrNo() {
		return docLocAddrNo;
	}

	public void setDocLocAddrNo(String docLocAddrNo) {
		this.docLocAddrNo = docLocAddrNo;
	}

	public String getDocLocBuilding() {
		return docLocBuilding;
	}

	public void setDocLocBuilding(String docLocBuilding) {
		this.docLocBuilding = docLocBuilding;
	}

	public String getDocLocFloor() {
		return docLocFloor;
	}

	public void setDocLocFloor(String docLocFloor) {
		this.docLocFloor = docLocFloor;
	}

	public String getDocLocStreet() {
		return docLocStreet;
	}

	public void setDocLocStreet(String docLocStreet) {
		this.docLocStreet = docLocStreet;
	}

	public String getDocLocTambon() {
		return docLocTambon;
	}

	public void setDocLocTambon(String docLocTambon) {
		this.docLocTambon = docLocTambon;
	}

	public String getDocLocAmphurId() {
		return docLocAmphurId;
	}

	public void setDocLocAmphurId(String docLocAmphurId) {
		this.docLocAmphurId = docLocAmphurId;
	}

	public String getDocLocProvinceId() {
		return docLocProvinceId;
	}

	public void setDocLocProvinceId(String docLocProvinceId) {
		this.docLocProvinceId = docLocProvinceId;
	}

	public String getDocLocPostCode() {
		return docLocPostCode;
	}

	public void setDocLocPostCode(String docLocPostCode) {
		this.docLocPostCode = docLocPostCode;
	}

	public Date getRtStartPeriodDt() {
		return rtStartPeriodDt;
	}

	public void setRtStartPeriodDt(Date rtStartPeriodDt) {
		this.rtStartPeriodDt = rtStartPeriodDt;
	}

	public Date getRtEndPeriodDt() {
		return rtEndPeriodDt;
	}

	public void setRtEndPeriodDt(Date rtEndPeriodDt) {
		this.rtEndPeriodDt = rtEndPeriodDt;
	}

	public Date getRtStartChangePeriodDt() {
		return rtStartChangePeriodDt;
	}

	public void setRtStartChangePeriodDt(Date rtStartChangePeriodDt) {
		this.rtStartChangePeriodDt = rtStartChangePeriodDt;
	}

	public Date getChangeContEffDt() {
		return changeContEffDt;
	}

	public void setChangeContEffDt(Date changeContEffDt) {
		this.changeContEffDt = changeContEffDt;
	}

	public String getChangeContEffDtStr() {
		return changeContEffDtStr;
	}

	public void setChangeContEffDtStr(String changeContEffDtStr) {
		this.changeContEffDtStr = changeContEffDtStr;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getReqOfficerOld() {
		return reqOfficerOld;
	}

	public void setReqOfficerOld(String reqOfficerOld) {
		this.reqOfficerOld = reqOfficerOld;
	}

	public String getReqOfficerNew() {
		return reqOfficerNew;
	}

	public void setReqOfficerNew(String reqOfficerNew) {
		this.reqOfficerNew = reqOfficerNew;
	}

	public String getSlimsStatus() {
		return slimsStatus;
	}

	public void setSlimsStatus(String slimsStatus) {
		this.slimsStatus = slimsStatus;
	}

	public String getRentAdjPeriodType() {
		return rentAdjPeriodType;
	}

	public void setRentAdjPeriodType(String rentAdjPeriodType) {
		this.rentAdjPeriodType = rentAdjPeriodType;
	}

	public String getRentCondType() {
		return rentCondType;
	}

	public void setRentCondType(String rentCondType) {
		this.rentCondType = rentCondType;
	}

	public String getRentContMode() {
		return rentContMode;
	}

	public void setRentContMode(String rentContMode) {
		this.rentContMode = rentContMode;
	}

	public String getNewStatus() {
		return newStatus;
	}

	public void setNewStatus(String newStatus) {
		this.newStatus = newStatus;
	}

	public String getDepositCondType() {
		return depositCondType;
	}

	public void setDepositCondType(String depositCondType) {
		this.depositCondType = depositCondType;
	}

	public String getExpenseName() {
		return expenseName;
	}

	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

	public String getRentPeriodName() {
		return rentPeriodName;
	}

	public void setRentPeriodName(String rentPeriodName) {
		this.rentPeriodName = rentPeriodName;
	}

	public String getRentWhtName() {
		return rentWhtName;
	}

	public void setRentWhtName(String rentWhtName) {
		this.rentWhtName = rentWhtName;
	}

	public String getRentVatName() {
		return rentVatName;
	}

	public void setRentVatName(String rentVatName) {
		this.rentVatName = rentVatName;
	}

	public String getRentPaymentPeriodName() {
		return rentPaymentPeriodName;
	}

	public void setRentPaymentPeriodName(String rentPaymentPeriodName) {
		this.rentPaymentPeriodName = rentPaymentPeriodName;
	}

	public String getRentAdjPeriodName() {
		return rentAdjPeriodName;
	}

	public void setRentAdjPeriodName(String rentAdjPeriodName) {
		this.rentAdjPeriodName = rentAdjPeriodName;
	}

	public String getRentOldPeriodName() {
		return rentOldPeriodName;
	}

	public void setRentOldPeriodName(String rentOldPeriodName) {
		this.rentOldPeriodName = rentOldPeriodName;
	}

	public String getRentAddPeriodName() {
		return rentAddPeriodName;
	}

	public void setRentAddPeriodName(String rentAddPeriodName) {
		this.rentAddPeriodName = rentAddPeriodName;
	}

	public String getVatTypeName() {
		return vatTypeName;
	}

	public void setVatTypeName(String vatTypeName) {
		this.vatTypeName = vatTypeName;
	}

	public String getExpenseTypeName() {
		return expenseTypeName;
	}

	public void setExpenseTypeName(String expenseTypeName) {
		this.expenseTypeName = expenseTypeName;
	}

	public BigDecimal getDepositReturnAmt() {
		return depositReturnAmt;
	}

	public void setDepositReturnAmt(BigDecimal depositReturnAmt) {
		this.depositReturnAmt = depositReturnAmt;
	}

	public String getNoUtilPrice() {
		return noUtilPrice;
	}

	public void setNoUtilPrice(String noUtilPrice) {
		this.noUtilPrice = noUtilPrice;
	}

	public Date getElEffectiveDt() {
		return elEffectiveDt;
	}

	public void setElEffectiveDt(Date elEffectiveDt) {
		this.elEffectiveDt = elEffectiveDt;
	}

	public String getElCondSubType() {
		return elCondSubType;
	}

	public void setElCondSubType(String elCondSubType) {
		this.elCondSubType = elCondSubType;
	}

	public BigDecimal getElOldAmt() {
		return elOldAmt;
	}

	public void setElOldAmt(BigDecimal elOldAmt) {
		this.elOldAmt = elOldAmt;
	}

	public String getFromContractNo() {
		return fromContractNo;
	}

	public void setFromContractNo(String fromContractNo) {
		this.fromContractNo = fromContractNo;
	}

	public String getRefSiteElCond() {
		return refSiteElCond;
	}

	public void setRefSiteElCond(String refSiteElCond) {
		this.refSiteElCond = refSiteElCond;
	}

	public BigDecimal getTotalDepositCashAmt() {
		return totalDepositCashAmt;
	}

	public void setTotalDepositCashAmt(BigDecimal totalDepositCashAmt) {
		this.totalDepositCashAmt = totalDepositCashAmt;
	}

	public BigDecimal getElAmt() {
		return elAmt;
	}

	public void setElAmt(BigDecimal elAmt) {
		this.elAmt = elAmt;
	}

	public BigDecimal getElAddAmt() {
		return elAddAmt;
	}

	public void setElAddAmt(BigDecimal elAddAmt) {
		this.elAddAmt = elAddAmt;
	}

	public String getFromSiteInfoId() {
		return fromSiteInfoId;
	}

	public void setFromSiteInfoId(String fromSiteInfoId) {
		this.fromSiteInfoId = fromSiteInfoId;
	}

	public String getElType2() {
		return elType2;
	}

	public void setElType2(String elType2) {
		this.elType2 = elType2;
	}

	public String getElType1() {
		return elType1;
	}

	public void setElType1(String elType1) {
		this.elType1 = elType1;
	}

	public BigDecimal getTotalDepositBgAmt() {
		return totalDepositBgAmt;
	}

	public void setTotalDepositBgAmt(BigDecimal totalDepositBgAmt) {
		this.totalDepositBgAmt = totalDepositBgAmt;
	}

	public String getElType4() {
		return elType4;
	}

	public void setElType4(String elType4) {
		this.elType4 = elType4;
	}

	public String getElAddPeriodType() {
		return elAddPeriodType;
	}

	public void setElAddPeriodType(String elAddPeriodType) {
		this.elAddPeriodType = elAddPeriodType;
	}

	public String getElType3() {
		return elType3;
	}

	public void setElType3(String elType3) {
		this.elType3 = elType3;
	}

	public String getElAdj() {
		return elAdj;
	}

	public void setElAdj(String elAdj) {
		this.elAdj = elAdj;
	}

	public String getElAdjPeriodType() {
		return elAdjPeriodType;
	}

	public void setElAdjPeriodType(String elAdjPeriodType) {
		this.elAdjPeriodType = elAdjPeriodType;
	}

	public String getTakeAllPeriodType() {
		return takeAllPeriodType;
	}

	public void setTakeAllPeriodType(String takeAllPeriodType) {
		this.takeAllPeriodType = takeAllPeriodType;
	}

	public String getTakeAllPeriodTypeName() {
		return takeAllPeriodTypeName;
	}

	public void setTakeAllPeriodTypeName(String takeAllPeriodTypeName) {
		this.takeAllPeriodTypeName = takeAllPeriodTypeName;
	}

	public String getNoDeposit() {
		return noDeposit;
	}

	public void setNoDeposit(String noDeposit) {
		this.noDeposit = noDeposit;
	}

	public String getElAddPercent() {
		return elAddPercent;
	}

	public void setElAddPercent(String elAddPercent) {
		this.elAddPercent = elAddPercent;
	}

	public String getElOldPeriodType() {
		return elOldPeriodType;
	}

	public void setElOldPeriodType(String elOldPeriodType) {
		this.elOldPeriodType = elOldPeriodType;
	}

	public Integer getElPayPeriod() {
		return elPayPeriod;
	}

	public void setElPayPeriod(Integer elPayPeriod) {
		this.elPayPeriod = elPayPeriod;
	}

	public String getRentalEditFlag() {
		return rentalEditFlag;
	}

	public void setRentalEditFlag(String rentalEditFlag) {
		this.rentalEditFlag = rentalEditFlag;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public String getInsuranceTypeName() {
		return insuranceTypeName;
	}

	public void setInsuranceTypeName(String insuranceTypeName) {
		this.insuranceTypeName = insuranceTypeName;
	}

	public Double getPlxOldAmt() {
		return plxOldAmt;
	}

	public void setPlxOldAmt(Double plxOldAmt) {
		this.plxOldAmt = plxOldAmt;
	}

	public Double getPlxAddAmt() {
		return plxAddAmt;
	}

	public void setPlxAddAmt(Double plxAddAmt) {
		this.plxAddAmt = plxAddAmt;
	}

	public Double getPlxAmt() {
		return plxAmt;
	}

	public void setPlxAmt(Double plxAmt) {
		this.plxAmt = plxAmt;
	}

	public Date getPlxEffectiveDt() {
		return plxEffectiveDt;
	}

	public void setPlxEffectiveDt(Date plxEffectiveDt) {
		this.plxEffectiveDt = plxEffectiveDt;
	}

	public Date getPlxExpireDt() {
		return plxExpireDt;
	}

	public void setPlxExpireDt(Date plxExpireDt) {
		this.plxExpireDt = plxExpireDt;
	}

	public String getPlxEffectiveDtStr() {
		return plxEffectiveDtStr;
	}

	public void setPlxEffectiveDtStr(String plxEffectiveDtStr) {
		this.plxEffectiveDtStr = plxEffectiveDtStr;
	}

	public String getPlxExpireDtStr() {
		return plxExpireDtStr;
	}

	public void setPlxExpireDtStr(String plxExpireDtStr) {
		this.plxExpireDtStr = plxExpireDtStr;
	}

	public Double getOwnerAmt() {
		return ownerAmt;
	}

	public void setOwnerAmt(Double ownerAmt) {
		this.ownerAmt = ownerAmt;
	}

	public String getOwnerPeriodType() {
		return ownerPeriodType;
	}

	public void setOwnerPeriodType(String ownerPeriodType) {
		this.ownerPeriodType = ownerPeriodType;
	}

	public String getOwnerPeriodTypeName() {
		return ownerPeriodTypeName;
	}

	public void setOwnerPeriodTypeName(String ownerPeriodTypeName) {
		this.ownerPeriodTypeName = ownerPeriodTypeName;
	}

	public String getOwnerVatType() {
		return ownerVatType;
	}

	public void setOwnerVatType(String ownerVatType) {
		this.ownerVatType = ownerVatType;
	}

	public String getOwnerVatTypeName() {
		return ownerVatTypeName;
	}

	public void setOwnerVatTypeName(String ownerVatTypeName) {
		this.ownerVatTypeName = ownerVatTypeName;
	}

	public String getOwnerPayPeriodType() {
		return ownerPayPeriodType;
	}

	public void setOwnerPayPeriodType(String ownerPayPeriodType) {
		this.ownerPayPeriodType = ownerPayPeriodType;
	}

	public String getOwnerPayPeriodTypeName() {
		return ownerPayPeriodTypeName;
	}

	public void setOwnerPayPeriodTypeName(String ownerPayPeriodTypeName) {
		this.ownerPayPeriodTypeName = ownerPayPeriodTypeName;
	}

	public Integer getOwnerPayPeriod() {
		return ownerPayPeriod;
	}

	public void setOwnerPayPeriod(Integer ownerPayPeriod) {
		this.ownerPayPeriod = ownerPayPeriod;
	}

	public Long getVersionIR() {
		return versionIR;
	}

	public void setVersionIR(Long versionIR) {
		this.versionIR = versionIR;
	}

	public String getpTaxPaymentId() {
		return pTaxPaymentId;
	}

	public void setpTaxPaymentId(String pTaxPaymentId) {
		this.pTaxPaymentId = pTaxPaymentId;
	}

	public String getpTaxYear() {
		return pTaxYear;
	}

	public void setpTaxYear(String pTaxYear) {
		this.pTaxYear = pTaxYear;
	}

	public String getPeriodAmt() {
		return periodAmt;
	}

	public void setPeriodAmt(String periodAmt) {
		this.periodAmt = periodAmt;
	}

	public String getUpdateDtStr() {
		return updateDtStr;
	}

	public void setUpdateDtStr(String updateDtStr) {
		this.updateDtStr = updateDtStr;
	}

	public String getSiteAppInsuranceId() {
		return siteAppInsuranceId;
	}

	public void setSiteAppInsuranceId(String siteAppInsuranceId) {
		this.siteAppInsuranceId = siteAppInsuranceId;
	}

	public String getNoOwnerAmt() {
		return noOwnerAmt;
	}

	public void setNoOwnerAmt(String noOwnerAmt) {
		this.noOwnerAmt = noOwnerAmt;
	}

	public String getPlxBeneficiary() {
		return plxBeneficiary;
	}

	public void setPlxBeneficiary(String plxBeneficiary) {
		this.plxBeneficiary = plxBeneficiary;
	}

	public String getLessorTel() {
		return lessorTel;
	}

	public void setLessorTel(String lessorTel) {
		this.lessorTel = lessorTel;
	}

	public String getLessorMobile() {
		return lessorMobile;
	}

	public void setLessorMobile(String lessorMobile) {
		this.lessorMobile = lessorMobile;
	}

	public String getLessorFax() {
		return lessorFax;
	}

	public void setLessorFax(String lessorFax) {
		this.lessorFax = lessorFax;
	}

	public String getLessorEmail() {
		return lessorEmail;
	}

	public void setLessorEmail(String lessorEmail) {
		this.lessorEmail = lessorEmail;
	}

	public String getElCondTypeName() {
		return elCondTypeName;
	}

	public void setElCondTypeName(String elCondTypeName) {
		this.elCondTypeName = elCondTypeName;
	}

	public String getElCondSubTypeName() {
		return elCondSubTypeName;
	}

	public void setElCondSubTypeName(String elCondSubTypeName) {
		this.elCondSubTypeName = elCondSubTypeName;
	}

	public String getDetail03() {
		return detail03;
	}

	public void setDetail03(String detail03) {
		this.detail03 = detail03;
	}

	public String getDetail04() {
		return detail04;
	}

	public void setDetail04(String detail04) {
		this.detail04 = detail04;
	}

	public String getNoUnitPriceFlag() {
		return noUnitPriceFlag;
	}

	public void setNoUnitPriceFlag(String noUnitPriceFlag) {
		this.noUnitPriceFlag = noUnitPriceFlag;
	}

	public Date getElEffectiveDt03() {
		return elEffectiveDt03;
	}

	public void setElEffectiveDt03(Date elEffectiveDt03) {
		this.elEffectiveDt03 = elEffectiveDt03;
	}

	public Date getElEffectiveDt04() {
		return elEffectiveDt04;
	}

	public void setElEffectiveDt04(Date elEffectiveDt04) {
		this.elEffectiveDt04 = elEffectiveDt04;
	}

	public String getRentalNoDeposit() {
		return rentalNoDeposit;
	}

	public void setRentalNoDeposit(String rentalNoDeposit) {
		this.rentalNoDeposit = rentalNoDeposit;
	}

	public String getElNoDeposit() {
		return elNoDeposit;
	}

	public void setElNoDeposit(String elNoDeposit) {
		this.elNoDeposit = elNoDeposit;
	}

	public String getLegalPlaceType() {
		return legalPlaceType;
	}

	public void setLegalPlaceType(String legalPlaceType) {
		this.legalPlaceType = legalPlaceType;
	}

	public String getLegalPartiesType() {
		return legalPartiesType;
	}

	public void setLegalPartiesType(String legalPartiesType) {
		this.legalPartiesType = legalPartiesType;
	}

	public String getLegalDocType() {
		return legalDocType;
	}

	public void setLegalDocType(String legalDocType) {
		this.legalDocType = legalDocType;
	}

	public String getLegalDocTypeOth() {
		return legalDocTypeOth;
	}

	public void setLegalDocTypeOth(String legalDocTypeOth) {
		this.legalDocTypeOth = legalDocTypeOth;
	}

	public Date getLegalDocEffectiveDt() {
		return legalDocEffectiveDt;
	}

	public void setLegalDocEffectiveDt(Date legalDocEffectiveDt) {
		this.legalDocEffectiveDt = legalDocEffectiveDt;
	}

	public String getLegalDocEffectiveDtStr() {
		return legalDocEffectiveDtStr;
	}

	public void setLegalDocEffectiveDtStr(String legalDocEffectiveDtStr) {
		this.legalDocEffectiveDtStr = legalDocEffectiveDtStr;
	}

	public String getSiteInsuranceId() {
		return siteInsuranceId;
	}

	public void setSiteInsuranceId(String siteInsuranceId) {
		this.siteInsuranceId = siteInsuranceId;
	}

	public String getSiteInfoELContId() {
		return siteInfoELContId;
	}

	public void setSiteInfoELContId(String siteInfoELContId) {
		this.siteInfoELContId = siteInfoELContId;
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

	public Date getChangeEffectiveDt() {
		return changeEffectiveDt;
	}

	public void setChangeEffectiveDt(Date changeEffectiveDt) {
		this.changeEffectiveDt = changeEffectiveDt;
	}

	public String getElectricType() {
		return electricType;
	}

	public void setElectricType(String electricType) {
		this.electricType = electricType;
	}

	public String getElectricTypeName() {
		return electricTypeName;
	}

	public void setElectricTypeName(String electricTypeName) {
		this.electricTypeName = electricTypeName;
	}

	public String getElectricCondSubtype() {
		return electricCondSubtype;
	}

	public void setElectricCondSubtype(String electricCondSubtype) {
		this.electricCondSubtype = electricCondSubtype;
	}

	public String getElectricCondSubtypeName() {
		return electricCondSubtypeName;
	}

	public void setElectricCondSubtypeName(String electricCondSubtypeName) {
		this.electricCondSubtypeName = electricCondSubtypeName;
	}

	public BigDecimal getElectricOldAmt() {
		return electricOldAmt;
	}

	public void setElectricOldAmt(BigDecimal electricOldAmt) {
		this.electricOldAmt = electricOldAmt;
	}

	public BigDecimal getElectricAddAmt() {
		return electricAddAmt;
	}

	public void setElectricAddAmt(BigDecimal electricAddAmt) {
		this.electricAddAmt = electricAddAmt;
	}

	public BigDecimal getElectricAmt() {
		return electricAmt;
	}

	public void setElectricAmt(BigDecimal electricAmt) {
		this.electricAmt = electricAmt;
	}

	public String getElectricPeriodType() {
		return electricPeriodType;
	}

	public void setElectricPeriodType(String electricPeriodType) {
		this.electricPeriodType = electricPeriodType;
	}

	public String getElectricPeriodTypeName() {
		return electricPeriodTypeName;
	}

	public void setElectricPeriodTypeName(String electricPeriodTypeName) {
		this.electricPeriodTypeName = electricPeriodTypeName;
	}

	public String getRefSiteElectricCondId() {
		return refSiteElectricCondId;
	}

	public void setRefSiteElectricCondId(String refSiteElectricCondId) {
		this.refSiteElectricCondId = refSiteElectricCondId;
	}

	public String getCanAdd() {
		return canAdd;
	}

	public void setCanAdd(String canAdd) {
		this.canAdd = canAdd;
	}

	public String getCanEdit() {
		return canEdit;
	}

	public void setCanEdit(String canEdit) {
		this.canEdit = canEdit;
	}

	public String getSiteAppElContId() {
		return siteAppElContId;
	}

	public void setSiteAppElContId(String siteAppElContId) {
		this.siteAppElContId = siteAppElContId;
	}

	public String getContractStatusName() {
		return contractStatusName;
	}

	public void setContractStatusName(String contractStatusName) {
		this.contractStatusName = contractStatusName;
	}

	public String getTerminateOfcontractFlag() {
		return terminateOfcontractFlag;
	}

	public void setTerminateOfcontractFlag(String terminateOfcontractFlag) {
		this.terminateOfcontractFlag = terminateOfcontractFlag;
	}

	public String getChangeEffectiveDtStr() {
		return changeEffectiveDtStr;
	}

	public void setChangeEffectiveDtStr(String changeEffectiveDtStr) {
		this.changeEffectiveDtStr = changeEffectiveDtStr;
	}

	public String getElType5() {
		return elType5;
	}

	public void setElType5(String elType5) {
		this.elType5 = elType5;
	}

	public String getWthType() {
		return wthType;
	}

	public void setWthType(String wthType) {
		this.wthType = wthType;
	}

	public String getWthTypeName() {
		return wthTypeName;
	}

	public void setWthTypeName(String wthTypeName) {
		this.wthTypeName = wthTypeName;
	}

	public BigDecimal getWthRate() {
		return wthRate;
	}

	public void setWthRate(BigDecimal wthRate) {
		this.wthRate = wthRate;
	}

}
