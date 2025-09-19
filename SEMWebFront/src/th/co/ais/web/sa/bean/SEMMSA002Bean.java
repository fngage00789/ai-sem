package th.co.ais.web.sa.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.mm.ItemResultSP;
import th.co.ais.domain.sa.MSA001LovSP;
import th.co.ais.domain.sa.SiteAppMailSP;
import th.co.ais.domain.sa.SiteAppRegHistSrch;
import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.domain.sa.SiteAppSiteSP;
import th.co.ais.util.ELovType;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMSA002Bean extends AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -479160918571282913L;
	
	// --- LOVs ---
	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> siteStatusList;
	private List<SelectItem> electricUseTypeList;
	private List<SelectItem> processStatusNameList;
	private List<SelectItem> depositTypeList;
	private List<SelectItem> provinceList;
	private List<SelectItem> amphurList;
	private List<SelectItem> bgStatusList;
	private List<SelectItem> refDocTypeList;
	private List<SelectItem> paymentMethodList;
	private List<SelectItem> paymentTypeList;
	private List<SelectItem> monthList;
	private List<SelectItem> reqOfficerList;
	private List<SelectItem> zoneList;
	private List<SelectItem> locationList;
	private List<SelectItem> areaUnitTypeList;
	private List<SelectItem> promiseRenewPeriodTypeList;
	private List<SelectItem> rentPeriodTypeList;
	private List<SelectItem> packagePeriodTypeList;
	private List<SelectItem> reqTypeList;
	
	private List<SelectItem> legalPlaceTypeList;
	private List<SelectItem> legalPartiesTypeList;
	
	private List<SelectItem> msa002Tab7ProvinceList;
	private List<SelectItem> msa002Tab7AmphurList;
	
	private List<SelectItem> msa002Tab2ProvinceList;
	private List<SelectItem> msa002Tab2AmphurList;
	
	private List<SelectItem> coOperatorList;
	
	private String panelDisplay;
	private String menuGroupDisplay;
	private String menuGroupType;
	private String pageForward;
	
	private String selectedTab;
	private String tabNo;
	
	//for criteria and object param
	private SiteAppSP siteAppObjParam;
	private SiteAppSP siteAppLocalObjParam;
	private SiteAppSiteSP siteAppSiteObjParam;
	private SiteAppSiteSP siteLocationObjParam;
	
	private SiteAppSP contractElUseObjParam;
	
	//object component
	private SiteAppSP siteAppTab0ObjParam;
	private LegalDocComponentBean legalDocObjparam;
	private SiteAppMailSP siteAppTab7ObjParam;
	
	//data table
	public List<WrapperBeanObject<SiteAppSP>> siteAppList;
	public List<WrapperBeanObject<SiteAppSiteSP>> siteAppSiteList;
	public List<WrapperBeanObject<SiteAppSP>> siteAppPopupHistoryList;
	public List<WrapperBeanObject<LegalDocComponentBean>> legalDocList;
	public List<WrapperBeanObject<SiteAppMailSP>> siteAppMailList;
	public List<WrapperBeanObject<SiteAppSiteSP>> siteLocationList;
	public List<SiteAppMailSP> siteAppMailExpList;
	
	public List<WrapperBeanObject<SiteAppSP>> contractElUseList;
	
	private boolean renderedMsgAlert;
	private boolean renderedPanelDisplay;
	private boolean chkSelAll;
	
	private String paramMessageInfo;
	private String paramMode;
	
	private boolean disabledModeViewOnly = false;
	private boolean disabledModeEditFromLG = false;
	private boolean disabledModeEditSome;
	private boolean disabledModeEditAll;
	
	private boolean disabledGenDocNoBtn;
	
	private boolean disabledTab_0;
	private boolean disabledTab_1;
	
	private String paramSiteMode;
	private boolean chkEditSiteModeINS;
	private boolean chkEditSiteModeRMV;
	private boolean disabledModeINS;
	private boolean disabledModeRMV;
	private boolean disabledSiteModeBtn;
	
	private boolean disabledElctTypeChk1;
	private boolean disabledElctTypeChk2;
	private boolean disabledElctTypeDetail;
	private boolean disabledElctPackageTypeDetail;
	private boolean disabledElctUnitTypeDetail;
	
	//temp param
	private String paramSiteAppId;
	private String paramPlaceType;
	private String paramPartiesType;
	
	public boolean chkReqOfficerManual;
	public boolean chkReqOfficerManualPopup;
	public boolean chkNeedLegalApprove;
	public boolean chkNeedAvpApprove;
	public boolean chkNeedConstruction;
	public boolean chkCoLocate;
	public boolean chkContractWanted;
	public boolean chkRentDepositFlag;
	public boolean chkElUseNewMeter;
	public boolean chkElUseOwner;
	public boolean chkElUseOldMeter;
	public boolean chkElPayOnPackage;
	public boolean chkElDepositFlag;
	public boolean chkElOwnerType;
	public boolean chkTerminateRemoveFlag;
	public boolean chkTerminateCancelRelateData;
	 // Render Message Data not found
	public boolean chkDataNotFound = false;
	
	
	private boolean renderedBtnBack;
	private boolean renderedBtnBackOther;
	
	private boolean uploadFileFlag = false;
	private boolean openPopupUploadFlag = false;
	private boolean openToDoListPageFlag = false;
	private boolean openTabPageFlag = false;
	private boolean backPageFlag = false;
	
	private boolean disabledInsureDetail = true;
	private boolean chkInsureNotHave = false;
	private boolean chkInsureHave = false;
	private boolean disabledChkNoLegal = false;
	private boolean disabledChangeEffDate = false;
	
	
	public boolean chkContractNeverExpire;
	public String contractWantedRemark;
	
	
	// added by.. YUT 2015/02/19
	public boolean chkMacroType;
	public boolean chkMicroType;
	public boolean chkPicoType;
	public boolean chkRepeaterType;
	public boolean chkTowerType;
	public boolean chkWifiType;
	public boolean chkOtherType;
	
	// added by.. YUT 2015/03/10
	public boolean chkSmallcellType;
	public boolean chkFBBType;
	public boolean chkOFCType;
	public boolean chkFTTXType;
	public boolean chkElUseOthSite;
	public boolean disabledElUserOthSite;
	private boolean chkCopySiteInfo = false;
	private boolean renderedMsgFormChkExpire = false;
	private boolean disabledElUseOldMeter = true;
	
	//added by NEW 2015/04/23
	private boolean chkRentalPayOneCond = false;
	private boolean chkRentalPayManyCond = false;
	private boolean chkLeaderFlag = false;
	private boolean chkUserFlag = true;
	private boolean disabledBtnCopySiteInfo = true;
	
	private boolean chkElPayOneCond = false;
	
	//added by NEW 11/02/2016
	private Integer payPeriod03;
	private Integer payPeriod04;
	private String payPeriodType01;
	private String payPeriodType02;
	private String payPeriodType03;
	private String payPeriodType04;
	private String payPeriodType05;
	private String payPeriodType06;
	private String payPeriodType07;
	private boolean disabledPayPeriod03 = true;
	private boolean disabledPayPeriod04 = true;
	
	private Integer servicePayPeriod03;
	private Integer servicePayPeriod04;
	private String servicePayPeriodType01;
	private String servicePayPeriodType02;
	private String servicePayPeriodType03;
	private String servicePayPeriodType04;
	private String servicePayPeriodType05;
	private boolean disabledServicePayPeriod03 = true;
	private boolean disabledServicePayPeriod04 = true;
	private boolean chkNoExpenses;
	
	//added by NEW 16/02/2016
	private boolean chkRentalNoExpenses = false;
	public boolean chkMultiElectricTypeFlag;
	
	private boolean disabledButtonPopupResult = false;
	
	private boolean chkSrchAllDetail = false;
	private String depType;
	
	private SiteAppRegHistSrch siteAppExtServ; 
	private List<WrapperBeanObject<SiteAppRegHistSrch>> siteAppExtServList;
	
	private SiteAppRegHistSrch siteAppCurrServ; 
	private List<WrapperBeanObject<SiteAppRegHistSrch>> siteAppCurrServList;
	
	private SiteAppRegHistSrch siteAppServ; 
	private List<WrapperBeanObject<SiteAppRegHistSrch>> siteAppServList;
	
	private SiteAppSP siteContInfo;
	private boolean noExpFlag;
	private boolean leaseHoldRights;
	private boolean license;
	private boolean llRentalAgreement;
	
	private List<WrapperBeanObject<SiteAppSP>> siteAppRentContExisting;
	private SiteAppSP siteAppRentObjParam;
	private List<WrapperBeanObject<SiteAppSP>> siteAppRentCont;
	private List<WrapperBeanObject<SiteAppSP>> siteAppRentServList;
	
	private List<WrapperBeanObject<SiteAppSiteSP>> siteAppSiteInuseList;
	
	private List<SelectItem> landAreaTypeList;
	private List<SelectItem> placeTypeList;
	private List<SelectItem> deckAreaTypeList;
	private List<SelectItem> roomAreaTypeList;
	private List<SelectItem> buildingAreaTypeList;
	
	private List<SelectItem> docTypeList;
	
	//added by NEW 25/06/2018
	private List<SelectItem> siteTypeList;
	
	private List<SelectItem> provinceLocalList;
	private List<SelectItem> provinceReqDocList;
	
	private List<SelectItem> amphurLocalList;
	private List<SelectItem> amphurReqDocList;
	
	private List<SelectItem> expenseTypeRentList;
	private List<SelectItem> servTypeList;
	
	private String placeTypeTab1;
	private String placeTypeTab7;
	
	private MSA001LovSP lovObjParam;
	private List<SelectItem> teamList;
	private List<SelectItem> memberList;
	
	private SiteAppSP chgReqObjParam;
	private boolean chkRegion;
	
	private List<WrapperBeanObject<SiteAppRegHistSrch>> siteAppRegHistList;
	private List<WrapperBeanObject<SiteAppSP>> siteAppDocRemainList;
	
	private List<SelectItem> msa002Tab2ProvinceLessorList;
	private List<SelectItem> msa002Tab2AmphurLessorList;
	
	private List<SelectItem> msa002Tab2ProvinceContactList;
	private List<SelectItem> msa002Tab2AmphurContactList;
	
	private List<SelectItem> titleList;
	
	private boolean chkService;
	private boolean chkRentAmtAdd;
	private SiteAppSP siteAppRentAmt;
	private List<SelectItem> expenseTypeDepositRentList;
	
	private SiteAppSP siteAppDeptObj;
	private SiteAppSP siteAppDeptCashObj;
	private SiteAppSP siteAppDeptBgObj;
	
	private List<WrapperBeanObject<SiteAppSP>> siteAppDeptBGList;
	private List<WrapperBeanObject<SiteAppSP>> siteAppDeptCashList;
	
	private boolean deptReceiveBg;
	private boolean deptNoBg;
	private boolean deptCancelBg;
	
	private boolean renderedPnlDeptCash;
	private boolean renderedPnlDeptBg;
	
	private String deptReturnType01;
	private String deptReturnType02;
	private String deptReturnType03;
	
	private boolean withdrawFlag;
	
	private boolean chkEditElExistingList = false;
	private List<WrapperBeanObject<SiteAppSP>> siteAppELCondExistingList;
	private List<WrapperBeanObject<SiteAppSP>> siteAppELCondTakeAllList;
	private List<WrapperBeanObject<SiteAppSP>> siteAppELCondAllList;
	private List<WrapperBeanObject<SiteAppSP>> siteAppELCondUnitList;
	private List<WrapperBeanObject<SiteAppSP>> siteAppELCondNoExpenseList;
	private List<WrapperBeanObject<SiteAppSP>> siteAppELCondOtherList;
	
	public boolean chkElUseOth;
	private boolean chkNoUtilPrice;
	
	private String elPayPeriodType01;
	private String elPayPeriodType02;
	private String elPayPeriodType03;
	private String elPayPeriodType04;
	private String elPayPeriodType05;
	private String elPayPeriodType06;
	private String elPayPeriodType07;
	private Integer elPayPeriod03;
	private Integer elPayPeriod04;
	
	private List<SelectItem> elUseTypeList;
	private List<SelectItem> elCondTypeList;
	private List<SelectItem> elCondSubTypeList;
	private boolean disabledElPayPeriod03 = true;
	private boolean disabledElPayPeriod04 = true;
	
	private SiteAppSP siteAppELObjParam;
	
	private SiteAppSP siteAppDeptElObj;
	private SiteAppSP siteAppDeptCashElObj;
	private SiteAppSP siteAppDeptBgElObj;
	
	private List<WrapperBeanObject<SiteAppSP>> siteAppDeptBGElList;
	private List<WrapperBeanObject<SiteAppSP>> siteAppDeptCashElList;
	
	private boolean renderedPnlDeptCashEl;
	private boolean renderedPnlDeptBgEl;
	
	private String deptReturnTypeEl01;
	private String deptReturnTypeEl02;
	private String deptReturnTypeEl03;
	private boolean withdrawFlagEl;
	private List<SelectItem> expenseTypeDepositElList;
	
	private SiteAppSP siteAppPTObj;
	private SiteAppSP siteAppPTObjParam;
	private List<WrapperBeanObject<SiteAppSP>> siteAppPTHistList;
	
	private SiteAppSP siteAppInsuranceObj;
	private List<WrapperBeanObject<SiteAppSP>> siteAppInsuranceList;
	private SiteAppSP siteAppInsuranceObjParam;
	
	private boolean renderedPLX;
	private boolean renderedInsuranceOwner;
	private List<SelectItem> periodTypeList;
	
	private String payPeriodTypeIns01;
	private String payPeriodTypeIns02;
	private String payPeriodTypeIns03;
	private String payPeriodTypeIns04;
	private String payPeriodTypeIns05;
	private String payPeriodTypeIns06;
	private String payPeriodTypeIns07;
	private Integer payPeriodIns03;
	private Integer payPeriodIns04;
	private boolean disabledPayPeriodIns03 = true;
	private boolean disabledPayPeriodIns04 = true;
	
	private boolean propertyTaxEditFlag;
	private boolean insuranceEditFlag;
	private boolean noOwnerAmtFlag;
	
	private List<SelectItem> insuranceTypeList;
	private String irHeaderLabel = "";
	
	private boolean renderedTbElUnit;
	private boolean renderedTbElTakeAll;
	private boolean renderedTbElNoExpense;
	private boolean renderedTbElUseOth;
	
	private List<SelectItem> reqTitleList;
	private boolean chkEditContractInfo = false;
	private boolean chkEditELDeposit = false;
	private boolean chkNoELDeposit;
	
	private boolean chkEditRental = false;
	private boolean chkEditRentalDeposit = false;
	private boolean chkNoRentalDeposit;
	private boolean renderedMsgExpMail = false;
	private List<WrapperBeanObject<SiteAppSP>> siteAppdocExtList;
	private List<WrapperBeanObject<SiteAppSP>> siteAppdocHistList;
	
	private boolean chkEditSiteAppDoc = false;
	
	private boolean renderedMsgDeposit = false;
	
	private int countElTypeList;
	private String msgReqcompanyPopup;
	
	private boolean chkEditFlag;
	private int count;
	
	private ItemResultSP retResultObj;
	private boolean renderedMsgPopup;
	
	private List<SelectItem> ownerCategoryList;
	private List<SelectItem> ownerSubCategoryList;
	
	public boolean disabledBtnExportAddr = true;
	private String mailAddrIdTmp;
	
	public String pRemark;
	public boolean showEditBtn;
	
	//added by NEW 2018/11/01
	public boolean chkOtherWaitingFlag;
	public boolean chkReturnDepositFlag;
	public boolean chkNoReturnDepositFlag;
	public boolean chkCancelMeterFlag;
	public boolean chkTerminateElFlag;
	public boolean chkOtherTerminateFlag;
	
	//added by NEW 2019/04/02
	private boolean chkContRentAdd;
	private List<SelectItem> rentAdjList;
	
	//add by Maa 2023/02/13
	private boolean disabledExpenseDesc = true;
	

	@Override
	public int getRowPerPage() {
		return rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public List<SelectItem> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}

	public List<SelectItem> getRegionList() {
		return regionList;
	}

	public void setRegionList(List<SelectItem> regionList) {
		this.regionList = regionList;
	}

	public List<SelectItem> getSiteStatusList() {
		return siteStatusList;
	}

	public void setSiteStatusList(List<SelectItem> siteStatusList) {
		this.siteStatusList = siteStatusList;
	}

	public List<SelectItem> getElectricUseTypeList() {
		return electricUseTypeList;
	}

	public void setElectricUseTypeList(List<SelectItem> electricUseTypeList) {
		this.electricUseTypeList = electricUseTypeList;
	}

	public List<SelectItem> getProcessStatusNameList() {
		return processStatusNameList;
	}

	public void setProcessStatusNameList(List<SelectItem> processStatusNameList) {
		this.processStatusNameList = processStatusNameList;
	}

	public List<SelectItem> getDepositTypeList() {
		return depositTypeList;
	}

	public void setDepositTypeList(List<SelectItem> depositTypeList) {
		this.depositTypeList = depositTypeList;
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

	public List<SelectItem> getBgStatusList() {
		return bgStatusList;
	}

	public void setBgStatusList(List<SelectItem> bgStatusList) {
		this.bgStatusList = bgStatusList;
	}

	public List<SelectItem> getRefDocTypeList() {
		return refDocTypeList;
	}

	public void setRefDocTypeList(List<SelectItem> refDocTypeList) {
		this.refDocTypeList = refDocTypeList;
	}

	public List<SelectItem> getPaymentMethodList() {
		return paymentMethodList;
	}

	public void setPaymentMethodList(List<SelectItem> paymentMethodList) {
		this.paymentMethodList = paymentMethodList;
	}

	public List<SelectItem> getPaymentTypeList() {
		return paymentTypeList;
	}

	public void setPaymentTypeList(List<SelectItem> paymentTypeList) {
		this.paymentTypeList = paymentTypeList;
	}

	public List<SelectItem> getMonthList() {
		return monthList;
	}

	public void setMonthList(List<SelectItem> monthList) {
		this.monthList = monthList;
	}

	public List<SelectItem> getReqOfficerList() {
		return reqOfficerList;
	}

	public void setReqOfficerList(List<SelectItem> reqOfficerList) {
		this.reqOfficerList = reqOfficerList;
	}

	public List<SelectItem> getZoneList() {
		return zoneList;
	}

	public void setZoneList(List<SelectItem> zoneList) {
		this.zoneList = zoneList;
	}

	public List<SelectItem> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<SelectItem> locationList) {
		this.locationList = locationList;
	}

	public List<SelectItem> getAreaUnitTypeList() {
		return areaUnitTypeList;
	}

	public void setAreaUnitTypeList(List<SelectItem> areaUnitTypeList) {
		this.areaUnitTypeList = areaUnitTypeList;
	}

	public List<SelectItem> getPromiseRenewPeriodTypeList() {
		return promiseRenewPeriodTypeList;
	}

	public void setPromiseRenewPeriodTypeList(
			List<SelectItem> promiseRenewPeriodTypeList) {
		this.promiseRenewPeriodTypeList = promiseRenewPeriodTypeList;
	}

	public List<SelectItem> getRentPeriodTypeList() {
		return rentPeriodTypeList;
	}

	public void setRentPeriodTypeList(List<SelectItem> rentPeriodTypeList) {
		this.rentPeriodTypeList = rentPeriodTypeList;
	}

	public List<SelectItem> getPackagePeriodTypeList() {
		return packagePeriodTypeList;
	}

	public void setPackagePeriodTypeList(List<SelectItem> packagePeriodTypeList) {
		this.packagePeriodTypeList = packagePeriodTypeList;
	}

	public List<SelectItem> getLegalPlaceTypeList() {
		return legalPlaceTypeList;
	}

	public void setLegalPlaceTypeList(List<SelectItem> legalPlaceTypeList) {
		this.legalPlaceTypeList = legalPlaceTypeList;
	}

	public List<SelectItem> getLegalPartiesTypeList() {
		return legalPartiesTypeList;
	}

	public List<SelectItem> getMsa002Tab7ProvinceList() {
		return msa002Tab7ProvinceList;
	}

	public void setMsa002Tab7ProvinceList(List<SelectItem> msa002Tab7ProvinceList) {
		this.msa002Tab7ProvinceList = msa002Tab7ProvinceList;
	}

	public List<SelectItem> getMsa002Tab7AmphurList() {
		return msa002Tab7AmphurList;
	}

	public void setMsa002Tab7AmphurList(List<SelectItem> msa002Tab7AmphurList) {
		this.msa002Tab7AmphurList = msa002Tab7AmphurList;
	}

	public List<SelectItem> getMsa002Tab2ProvinceList() {
		return msa002Tab2ProvinceList;
	}

	public void setMsa002Tab2ProvinceList(List<SelectItem> msa002Tab2ProvinceList) {
		this.msa002Tab2ProvinceList = msa002Tab2ProvinceList;
	}

	public List<SelectItem> getMsa002Tab2AmphurList() {
		return msa002Tab2AmphurList;
	}

	public void setMsa002Tab2AmphurList(List<SelectItem> msa002Tab2AmphurList) {
		this.msa002Tab2AmphurList = msa002Tab2AmphurList;
	}

	public List<SelectItem> getCoOperatorList() {
		return coOperatorList;
	}

	public void setCoOperatorList(List<SelectItem> coOperatorList) {
		this.coOperatorList = coOperatorList;
	}

	public void setLegalPartiesTypeList(List<SelectItem> legalPartiesTypeList) {
		this.legalPartiesTypeList = legalPartiesTypeList;
	}

	public String getPanelDisplay() {
		return panelDisplay;
	}

	public void setPanelDisplay(String panelDisplay) {
		this.panelDisplay = panelDisplay;
	}

	public String getMenuGroupDisplay() {
		return menuGroupDisplay;
	}

	public void setMenuGroupDisplay(String menuGroupDisplay) {
		this.menuGroupDisplay = menuGroupDisplay;
	}

	public String getPageForward() {
		return pageForward;
	}

	public void setPageForward(String pageForward) {
		this.pageForward = pageForward;
	}

	public String getSelectedTab() {
		return selectedTab;
	}

	public void setSelectedTab(String selectedTab) {
		this.selectedTab = selectedTab;
	}

	public String getTabNo() {
		return tabNo;
	}

	public void setTabNo(String tabNo) {
		this.tabNo = tabNo;
	}

	public SiteAppSP getSiteAppObjParam() {
		return siteAppObjParam;
	}

	public void setSiteAppObjParam(SiteAppSP siteAppObjParam) {
		this.siteAppObjParam = siteAppObjParam;
	}

	public SiteAppSiteSP getSiteAppSiteObjParam() {
		return siteAppSiteObjParam;
	}

	public void setSiteAppSiteObjParam(SiteAppSiteSP siteAppSiteObjParam) {
		this.siteAppSiteObjParam = siteAppSiteObjParam;
	}

	public SiteAppSiteSP getSiteLocationObjParam() {
		return siteLocationObjParam;
	}

	public void setSiteLocationObjParam(SiteAppSiteSP siteLocationObjParam) {
		this.siteLocationObjParam = siteLocationObjParam;
	}

	public SiteAppSP getContractElUseObjParam() {
		return contractElUseObjParam;
	}

	public void setContractElUseObjParam(SiteAppSP contractElUseObjParam) {
		this.contractElUseObjParam = contractElUseObjParam;
	}

	public SiteAppSP getSiteAppTab0ObjParam() {
		return siteAppTab0ObjParam;
	}

	public void setSiteAppTab0ObjParam(SiteAppSP siteAppTab0ObjParam) {
		this.siteAppTab0ObjParam = siteAppTab0ObjParam;
	}

	public LegalDocComponentBean getLegalDocObjparam() {
		return legalDocObjparam;
	}

	public void setLegalDocObjparam(LegalDocComponentBean legalDocObjparam) {
		this.legalDocObjparam = legalDocObjparam;
	}

	public SiteAppMailSP getSiteAppTab7ObjParam() {
		return siteAppTab7ObjParam;
	}

	public void setSiteAppTab7ObjParam(SiteAppMailSP siteAppTab7ObjParam) {
		this.siteAppTab7ObjParam = siteAppTab7ObjParam;
	}

	public List<WrapperBeanObject<SiteAppSP>> getSiteAppList() {
		return siteAppList;
	}

	public void setSiteAppList(List<WrapperBeanObject<SiteAppSP>> siteAppList) {
		this.siteAppList = siteAppList;
	}

	public List<WrapperBeanObject<SiteAppSiteSP>> getSiteAppSiteList() {
		return siteAppSiteList;
	}

	public void setSiteAppSiteList(
			List<WrapperBeanObject<SiteAppSiteSP>> siteAppSiteList) {
		this.siteAppSiteList = siteAppSiteList;
	}

	public List<WrapperBeanObject<LegalDocComponentBean>> getLegalDocList() {
		return legalDocList;
	}

	public void setLegalDocList(
			List<WrapperBeanObject<LegalDocComponentBean>> legalDocList) {
		this.legalDocList = legalDocList;
	}

	public List<WrapperBeanObject<SiteAppMailSP>> getSiteAppMailList() {
		return siteAppMailList;
	}

	public void setSiteAppMailList(
			List<WrapperBeanObject<SiteAppMailSP>> siteAppMailList) {
		this.siteAppMailList = siteAppMailList;
	}

	public List<WrapperBeanObject<SiteAppSiteSP>> getSiteLocationList() {
		return siteLocationList;
	}

	public void setSiteLocationList(
			List<WrapperBeanObject<SiteAppSiteSP>> siteLocationList) {
		this.siteLocationList = siteLocationList;
	}

	public List<WrapperBeanObject<SiteAppSP>> getContractElUseList() {
		return contractElUseList;
	}

	public void setContractElUseList(
			List<WrapperBeanObject<SiteAppSP>> contractElUseList) {
		this.contractElUseList = contractElUseList;
	}

	public boolean isRenderedMsgAlert() {
		return renderedMsgAlert;
	}

	public void setRenderedMsgAlert(boolean renderedMsgAlert) {
		this.renderedMsgAlert = renderedMsgAlert;
	}

	public boolean isRenderedPanelDisplay() {
		return renderedPanelDisplay;
	}

	public void setRenderedPanelDisplay(boolean renderedPanelDisplay) {
		this.renderedPanelDisplay = renderedPanelDisplay;
	}

	public String getParamMessageInfo() {
		return paramMessageInfo;
	}

	public void setParamMessageInfo(String paramMessageInfo) {
		this.paramMessageInfo = paramMessageInfo;
	}

	public String getParamMode() {
		return paramMode;
	}

	public void setParamMode(String paramMode) {
		this.paramMode = paramMode;
	}

	public boolean isDisabledModeViewOnly() {
		return disabledModeViewOnly;
	}

	public void setDisabledModeViewOnly(boolean disabledModeViewOnly) {
		this.disabledModeViewOnly = disabledModeViewOnly;
	}

	public boolean isDisabledModeEditSome() {
		return disabledModeEditSome;
	}

	public void setDisabledModeEditSome(boolean disabledModeEditSome) {
		this.disabledModeEditSome = disabledModeEditSome;
	}

	public boolean isDisabledModeEditAll() {
		return disabledModeEditAll;
	}

	public void setDisabledModeEditAll(boolean disabledModeEditAll) {
		this.disabledModeEditAll = disabledModeEditAll;
	}

	public boolean isDisabledGenDocNoBtn() {
		return disabledGenDocNoBtn;
	}

	public void setDisabledGenDocNoBtn(boolean disabledGenDocNoBtn) {
		this.disabledGenDocNoBtn = disabledGenDocNoBtn;
	}

	public boolean isDisabledTab_0() {
		return disabledTab_0;
	}

	public void setDisabledTab_0(boolean disabledTab_0) {
		this.disabledTab_0 = disabledTab_0;
	}

	public boolean isDisabledTab_1() {
		return disabledTab_1;
	}

	public void setDisabledTab_1(boolean disabledTab_1) {
		this.disabledTab_1 = disabledTab_1;
	}

	public boolean isDisabledModeINS() {
		return disabledModeINS;
	}

	public void setDisabledModeINS(boolean disabledModeINS) {
		this.disabledModeINS = disabledModeINS;
	}

	public boolean isDisabledModeRMV() {
		return disabledModeRMV;
	}

	public void setDisabledModeRMV(boolean disabledModeRMV) {
		this.disabledModeRMV = disabledModeRMV;
	}

	public boolean isDisabledSiteModeBtn() {
		return disabledSiteModeBtn;
	}

	public void setDisabledSiteModeBtn(boolean disabledSiteModeBtn) {
		this.disabledSiteModeBtn = disabledSiteModeBtn;
	}

	public boolean isDisabledElctTypeChk1() {
		return disabledElctTypeChk1;
	}

	public void setDisabledElctTypeChk1(boolean disabledElctTypeChk1) {
		this.disabledElctTypeChk1 = disabledElctTypeChk1;
	}

	public boolean isDisabledElctTypeChk2() {
		return disabledElctTypeChk2;
	}

	public void setDisabledElctTypeChk2(boolean disabledElctTypeChk2) {
		this.disabledElctTypeChk2 = disabledElctTypeChk2;
	}

	public boolean isDisabledElctTypeDetail() {
		return disabledElctTypeDetail;
	}

	public void setDisabledElctTypeDetail(boolean disabledElctTypeDetail) {
		this.disabledElctTypeDetail = disabledElctTypeDetail;
	}

	public String getParamSiteMode() {
		return paramSiteMode;
	}

	public void setParamSiteMode(String paramSiteMode) {
		this.paramSiteMode = paramSiteMode;
	}

	public boolean isChkEditSiteModeINS() {
		return chkEditSiteModeINS;
	}

	public void setChkEditSiteModeINS(boolean chkEditSiteModeINS) {
		this.chkEditSiteModeINS = chkEditSiteModeINS;
	}

	public boolean isChkEditSiteModeRMV() {
		return chkEditSiteModeRMV;
	}

	public void setChkEditSiteModeRMV(boolean chkEditSiteModeRMV) {
		this.chkEditSiteModeRMV = chkEditSiteModeRMV;
	}

	public String getParamSiteAppId() {
		return paramSiteAppId;
	}

	public void setParamSiteAppId(String paramSiteAppId) {
		this.paramSiteAppId = paramSiteAppId;
	}

	public String getParamPlaceType() {
		return paramPlaceType;
	}

	public void setParamPlaceType(String paramPlaceType) {
		this.paramPlaceType = paramPlaceType;
	}

	public String getParamPartiesType() {
		return paramPartiesType;
	}

	public void setParamPartiesType(String paramPartiesType) {
		this.paramPartiesType = paramPartiesType;
	}

	public boolean isChkReqOfficerManual() {
		return chkReqOfficerManual;
	}

	public void setChkReqOfficerManual(boolean chkReqOfficerManual) {
		this.chkReqOfficerManual = chkReqOfficerManual;
	}

	public boolean isChkNeedLegalApprove() {
		return chkNeedLegalApprove;
	}

	public void setChkNeedLegalApprove(boolean chkNeedLegalApprove) {
		this.chkNeedLegalApprove = chkNeedLegalApprove;
	}

	public boolean isChkNeedAvpApprove() {
		return chkNeedAvpApprove;
	}

	public void setChkNeedAvpApprove(boolean chkNeedAvpApprove) {
		this.chkNeedAvpApprove = chkNeedAvpApprove;
	}

	public boolean isChkNeedConstruction() {
		return chkNeedConstruction;
	}

	public void setChkNeedConstruction(boolean chkNeedConstruction) {
		this.chkNeedConstruction = chkNeedConstruction;
	}

	public boolean isChkCoLocate() {
		return chkCoLocate;
	}

	public void setChkCoLocate(boolean chkCoLocate) {
		this.chkCoLocate = chkCoLocate;
	}

	public boolean isChkContractWanted() {
		return chkContractWanted;
	}

	public void setChkContractWanted(boolean chkContractWanted) {
		this.chkContractWanted = chkContractWanted;
	}

	public boolean isChkRentDepositFlag() {
		return chkRentDepositFlag;
	}

	public void setChkRentDepositFlag(boolean chkRentDepositFlag) {
		this.chkRentDepositFlag = chkRentDepositFlag;
	}

	public boolean isChkElUseNewMeter() {
		return chkElUseNewMeter;
	}

	public void setChkElUseNewMeter(boolean chkElUseNewMeter) {
		this.chkElUseNewMeter = chkElUseNewMeter;
	}

	public boolean isChkElUseOwner() {
		return chkElUseOwner;
	}

	public void setChkElUseOwner(boolean chkElUseOwner) {
		this.chkElUseOwner = chkElUseOwner;
	}

	public boolean isChkElUseOldMeter() {
		return chkElUseOldMeter;
	}

	public void setChkElUseOldMeter(boolean chkElUseOldMeter) {
		this.chkElUseOldMeter = chkElUseOldMeter;
	}

	public boolean isChkElPayOnPackage() {
		return chkElPayOnPackage;
	}

	public void setChkElPayOnPackage(boolean chkElPayOnPackage) {
		this.chkElPayOnPackage = chkElPayOnPackage;
	}

	public boolean isChkElDepositFlag() {
		return chkElDepositFlag;
	}

	public void setChkElDepositFlag(boolean chkElDepositFlag) {
		this.chkElDepositFlag = chkElDepositFlag;
	}

	public boolean isChkElOwnerType() {
		return chkElOwnerType;
	}

	public void setChkElOwnerType(boolean chkElOwnerType) {
		this.chkElOwnerType = chkElOwnerType;
	}

	public boolean isChkTerminateRemoveFlag() {
		return chkTerminateRemoveFlag;
	}

	public void setChkTerminateRemoveFlag(boolean chkTerminateRemoveFlag) {
		this.chkTerminateRemoveFlag = chkTerminateRemoveFlag;
	}

	public boolean isChkTerminateCancelRelateData() {
		return chkTerminateCancelRelateData;
	}

	public void setChkTerminateCancelRelateData(boolean chkTerminateCancelRelateData) {
		this.chkTerminateCancelRelateData = chkTerminateCancelRelateData;
	}

	public List<WrapperBeanObject<SiteAppSP>> getSiteAppPopupHistoryList() {
		return siteAppPopupHistoryList;
	}

	public void setSiteAppPopupHistoryList(
			List<WrapperBeanObject<SiteAppSP>> siteAppPopupHistoryList) {
		this.siteAppPopupHistoryList = siteAppPopupHistoryList;
	}

	public boolean isChkDataNotFound() {
		return chkDataNotFound;
	}

	public void setChkDataNotFound(boolean chkDataNotFound) {
		this.chkDataNotFound = chkDataNotFound;
	}

	public boolean isChkSelAll() {
		return chkSelAll;
	}

	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}

	public boolean isRenderedBtnBack() {
		return renderedBtnBack;
	}

	public void setRenderedBtnBack(boolean renderedBtnBack) {
		this.renderedBtnBack = renderedBtnBack;
	}

	public boolean isRenderedBtnBackOther() {
		return renderedBtnBackOther;
	}

	public void setRenderedBtnBackOther(boolean renderedBtnBackOther) {
		this.renderedBtnBackOther = renderedBtnBackOther;
	}

	public boolean isDisabledInsureDetail() {
		return disabledInsureDetail;
	}

	public void setDisabledInsureDetail(boolean disabledInsureDetail) {
		this.disabledInsureDetail = disabledInsureDetail;
	}

	public boolean isChkInsureNotHave() {
		return chkInsureNotHave;
	}

	public void setChkInsureNotHave(boolean chkInsureNotHave) {
		this.chkInsureNotHave = chkInsureNotHave;
	}

	public boolean isChkInsureHave() {
		return chkInsureHave;
	}

	public void setChkInsureHave(boolean chkInsureHave) {
		this.chkInsureHave = chkInsureHave;
	}

	public boolean isUploadFileFlag() {
		return uploadFileFlag;
	}

	public void setUploadFileFlag(boolean uploadFileFlag) {
		this.uploadFileFlag = uploadFileFlag;
	}

	public boolean isOpenPopupUploadFlag() {
		return openPopupUploadFlag;
	}

	public void setOpenPopupUploadFlag(boolean openPopupUploadFlag) {
		this.openPopupUploadFlag = openPopupUploadFlag;
	}

	public boolean isOpenToDoListPageFlag() {
		return openToDoListPageFlag;
	}

	public void setOpenToDoListPageFlag(boolean openToDoListPageFlag) {
		this.openToDoListPageFlag = openToDoListPageFlag;
	}

	public boolean isOpenTabPageFlag() {
		return openTabPageFlag;
	}

	public void setOpenTabPageFlag(boolean openTabPageFlag) {
		this.openTabPageFlag = openTabPageFlag;
	}

	public boolean isBackPageFlag() {
		return backPageFlag;
	}

	public void setBackPageFlag(boolean backPageFlag) {
		this.backPageFlag = backPageFlag;
	}

	public boolean isChkContractNeverExpire() {
		return chkContractNeverExpire;
	}

	public void setChkContractNeverExpire(boolean chkContractNeverExpire) {
		this.chkContractNeverExpire = chkContractNeverExpire;
	}

	public String getContractWantedRemark() {
		return contractWantedRemark;
	}

	public void setContractWantedRemark(String contractWantedRemark) {
		this.contractWantedRemark = contractWantedRemark;
	}

	public boolean isChkMacroType() {
		return chkMacroType;
	}

	public void setChkMacroType(boolean chkMacroType) {
		this.chkMacroType = chkMacroType;
	}

	public boolean isChkMicroType() {
		return chkMicroType;
	}

	public void setChkMicroType(boolean chkMicroType) {
		this.chkMicroType = chkMicroType;
	}

	public boolean isChkPicoType() {
		return chkPicoType;
	}

	public void setChkPicoType(boolean chkPicoType) {
		this.chkPicoType = chkPicoType;
	}

	public boolean isChkRepeaterType() {
		return chkRepeaterType;
	}

	public void setChkRepeaterType(boolean chkRepeaterType) {
		this.chkRepeaterType = chkRepeaterType;
	}

	public boolean isChkTowerType() {
		return chkTowerType;
	}

	public void setChkTowerType(boolean chkTowerType) {
		this.chkTowerType = chkTowerType;
	}

	public boolean isChkWifiType() {
		return chkWifiType;
	}

	public void setChkWifiType(boolean chkWifiType) {
		this.chkWifiType = chkWifiType;
	}

	public boolean isChkOtherType() {
		return chkOtherType;
	}

	public void setChkOtherType(boolean chkOtherType) {
		this.chkOtherType = chkOtherType;
	}

	public boolean isChkSmallcellType() {
		return chkSmallcellType;
	}

	public void setChkSmallcellType(boolean chkSmallcellType) {
		this.chkSmallcellType = chkSmallcellType;
	}

	public boolean isChkElUseOthSite() {
		return chkElUseOthSite;
	}

	public void setChkElUseOthSite(boolean chkElUseOthSite) {
		this.chkElUseOthSite = chkElUseOthSite;
	}

	public boolean isChkCopySiteInfo() {
		return chkCopySiteInfo;
	}

	public void setChkCopySiteInfo(boolean chkCopySiteInfo) {
		this.chkCopySiteInfo = chkCopySiteInfo;
	}

	public boolean isDisabledElctUnitTypeDetail() {
		return disabledElctUnitTypeDetail;
	}

	public void setDisabledElctUnitTypeDetail(boolean disabledElctUnitTypeDetail) {
		this.disabledElctUnitTypeDetail = disabledElctUnitTypeDetail;
	}

	public boolean isDisabledElUserOthSite() {
		return disabledElUserOthSite;
	}

	public void setDisabledElUserOthSite(boolean disabledElUserOthSite) {
		this.disabledElUserOthSite = disabledElUserOthSite;
	}

	public boolean isDisabledElctPackageTypeDetail() {
		return disabledElctPackageTypeDetail;
	}

	public void setDisabledElctPackageTypeDetail(
			boolean disabledElctPackageTypeDetail) {
		this.disabledElctPackageTypeDetail = disabledElctPackageTypeDetail;
	}

	public boolean isRenderedMsgFormChkExpire() {
		return renderedMsgFormChkExpire;
	}

	public void setRenderedMsgFormChkExpire(boolean renderedMsgFormChkExpire) {
		this.renderedMsgFormChkExpire = renderedMsgFormChkExpire;
	}

	public boolean isDisabledChkNoLegal() {
		return disabledChkNoLegal;
	}

	public void setDisabledChkNoLegal(boolean disabledChkNoLegal) {
		this.disabledChkNoLegal = disabledChkNoLegal;
	}

	public boolean isChkFBBType() {
		return chkFBBType;
	}

	public void setChkFBBType(boolean chkFBBType) {
		this.chkFBBType = chkFBBType;
	}

	public boolean isChkOFCType() {
		return chkOFCType;
	}

	public void setChkOFCType(boolean chkOFCType) {
		this.chkOFCType = chkOFCType;
	}

	public boolean isChkFTTXType() {
		return chkFTTXType;
	}

	public void setChkFTTXType(boolean chkFTTXType) {
		this.chkFTTXType = chkFTTXType;
	}

	public boolean isDisabledElUseOldMeter() {
		return disabledElUseOldMeter;
	}

	public void setDisabledElUseOldMeter(boolean disabledElUseOldMeter) {
		this.disabledElUseOldMeter = disabledElUseOldMeter;
	}

	public boolean isDisabledChangeEffDate() {
		return disabledChangeEffDate;
	}

	public void setDisabledChangeEffDate(boolean disabledChangeEffDate) {
		this.disabledChangeEffDate = disabledChangeEffDate;
	}

	public boolean isChkRentalPayOneCond() {
		return chkRentalPayOneCond;
	}

	public void setChkRentalPayOneCond(boolean chkRentalPayOneCond) {
		this.chkRentalPayOneCond = chkRentalPayOneCond;
	}

	public boolean isChkRentalPayManyCond() {
		return chkRentalPayManyCond;
	}

	public void setChkRentalPayManyCond(boolean chkRentalPayManyCond) {
		this.chkRentalPayManyCond = chkRentalPayManyCond;
	}

	public boolean isChkLeaderFlag() {
		return chkLeaderFlag;
	}

	public void setChkLeaderFlag(boolean chkLeaderFlag) {
		this.chkLeaderFlag = chkLeaderFlag;
	}

	public boolean isChkUserFlag() {
		return chkUserFlag;
	}

	public void setChkUserFlag(boolean chkUserFlag) {
		this.chkUserFlag = chkUserFlag;
	}

	public boolean isDisabledBtnCopySiteInfo() {
		return disabledBtnCopySiteInfo;
	}

	public void setDisabledBtnCopySiteInfo(boolean disabledBtnCopySiteInfo) {
		this.disabledBtnCopySiteInfo = disabledBtnCopySiteInfo;
	}

	public boolean isDisabledModeEditFromLG() {
		return disabledModeEditFromLG;
	}

	public void setDisabledModeEditFromLG(boolean disabledModeEditFromLG) {
		this.disabledModeEditFromLG = disabledModeEditFromLG;
	}

	public Integer getPayPeriod03() {
		return payPeriod03;
	}

	public void setPayPeriod03(Integer payPeriod03) {
		this.payPeriod03 = payPeriod03;
	}

	public Integer getPayPeriod04() {
		return payPeriod04;
	}

	public void setPayPeriod04(Integer payPeriod04) {
		this.payPeriod04 = payPeriod04;
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

	public String getPayPeriodType04() {
		return payPeriodType04;
	}

	public void setPayPeriodType04(String payPeriodType04) {
		this.payPeriodType04 = payPeriodType04;
	}

	public String getPayPeriodType05() {
		return payPeriodType05;
	}

	public void setPayPeriodType05(String payPeriodType05) {
		this.payPeriodType05 = payPeriodType05;
	}

	public boolean isDisabledPayPeriod03() {
		return disabledPayPeriod03;
	}

	public void setDisabledPayPeriod03(boolean disabledPayPeriod03) {
		this.disabledPayPeriod03 = disabledPayPeriod03;
	}

	public boolean isDisabledPayPeriod04() {
		return disabledPayPeriod04;
	}

	public void setDisabledPayPeriod04(boolean disabledPayPeriod04) {
		this.disabledPayPeriod04 = disabledPayPeriod04;
	}

	public Integer getServicePayPeriod03() {
		return servicePayPeriod03;
	}

	public void setServicePayPeriod03(Integer servicePayPeriod03) {
		this.servicePayPeriod03 = servicePayPeriod03;
	}

	public Integer getServicePayPeriod04() {
		return servicePayPeriod04;
	}

	public void setServicePayPeriod04(Integer servicePayPeriod04) {
		this.servicePayPeriod04 = servicePayPeriod04;
	}

	public String getServicePayPeriodType01() {
		return servicePayPeriodType01;
	}

	public void setServicePayPeriodType01(String servicePayPeriodType01) {
		this.servicePayPeriodType01 = servicePayPeriodType01;
	}

	public String getServicePayPeriodType02() {
		return servicePayPeriodType02;
	}

	public void setServicePayPeriodType02(String servicePayPeriodType02) {
		this.servicePayPeriodType02 = servicePayPeriodType02;
	}

	public String getServicePayPeriodType03() {
		return servicePayPeriodType03;
	}

	public void setServicePayPeriodType03(String servicePayPeriodType03) {
		this.servicePayPeriodType03 = servicePayPeriodType03;
	}

	public String getServicePayPeriodType04() {
		return servicePayPeriodType04;
	}

	public void setServicePayPeriodType04(String servicePayPeriodType04) {
		this.servicePayPeriodType04 = servicePayPeriodType04;
	}

	public String getServicePayPeriodType05() {
		return servicePayPeriodType05;
	}

	public void setServicePayPeriodType05(String servicePayPeriodType05) {
		this.servicePayPeriodType05 = servicePayPeriodType05;
	}

	public boolean isDisabledServicePayPeriod03() {
		return disabledServicePayPeriod03;
	}

	public void setDisabledServicePayPeriod03(boolean disabledServicePayPeriod03) {
		this.disabledServicePayPeriod03 = disabledServicePayPeriod03;
	}

	public boolean isDisabledServicePayPeriod04() {
		return disabledServicePayPeriod04;
	}

	public void setDisabledServicePayPeriod04(boolean disabledServicePayPeriod04) {
		this.disabledServicePayPeriod04 = disabledServicePayPeriod04;
	}

	public boolean isChkNoExpenses() {
		return chkNoExpenses;
	}

	public void setChkNoExpenses(boolean chkNoExpenses) {
		this.chkNoExpenses = chkNoExpenses;
	}

	public boolean isChkRentalNoExpenses() {
		return chkRentalNoExpenses;
	}

	public void setChkRentalNoExpenses(boolean chkRentalNoExpenses) {
		this.chkRentalNoExpenses = chkRentalNoExpenses;
	}

	public boolean isChkMultiElectricTypeFlag() {
		return chkMultiElectricTypeFlag;
	}

	public void setChkMultiElectricTypeFlag(boolean chkMultiElectricTypeFlag) {
		this.chkMultiElectricTypeFlag = chkMultiElectricTypeFlag;
	}

	public boolean isDisabledButtonPopupResult() {
		return disabledButtonPopupResult;
	}

	public void setDisabledButtonPopupResult(boolean disabledButtonPopupResult) {
		this.disabledButtonPopupResult = disabledButtonPopupResult;
	}

	public String getMenuGroupType() {
		return menuGroupType;
	}

	public void setMenuGroupType(String menuGroupType) {
		this.menuGroupType = menuGroupType;
	}

	public boolean isChkSrchAllDetail() {
		return chkSrchAllDetail;
	}

	public void setChkSrchAllDetail(boolean chkSrchAllDetail) {
		this.chkSrchAllDetail = chkSrchAllDetail;
	}

	public List<SelectItem> getReqTypeList() {
		return reqTypeList;
	}

	public void setReqTypeList(List<SelectItem> reqTypeList) {
		this.reqTypeList = reqTypeList;
	}

	public String getPayPeriodType06() {
		return payPeriodType06;
	}

	public void setPayPeriodType06(String payPeriodType06) {
		this.payPeriodType06 = payPeriodType06;
	}

	public String getPayPeriodType07() {
		return payPeriodType07;
	}

	public void setPayPeriodType07(String payPeriodType07) {
		this.payPeriodType07 = payPeriodType07;
	}

	public String getDepType() {
		return depType;
	}

	public void setDepType(String depType) {
		this.depType = depType;
	}

	public SiteAppRegHistSrch getSiteAppExtServ() {
		return siteAppExtServ;
	}

	public void setSiteAppExtServ(SiteAppRegHistSrch siteAppExtServ) {
		this.siteAppExtServ = siteAppExtServ;
	}

	public List<WrapperBeanObject<SiteAppRegHistSrch>> getSiteAppExtServList() {
		return siteAppExtServList;
	}

	public void setSiteAppExtServList(
			List<WrapperBeanObject<SiteAppRegHistSrch>> siteAppExtServList) {
		this.siteAppExtServList = siteAppExtServList;
	}

	public SiteAppRegHistSrch getSiteAppCurrServ() {
		return siteAppCurrServ;
	}

	public void setSiteAppCurrServ(SiteAppRegHistSrch siteAppCurrServ) {
		this.siteAppCurrServ = siteAppCurrServ;
	}

	public List<WrapperBeanObject<SiteAppRegHistSrch>> getSiteAppCurrServList() {
		return siteAppCurrServList;
	}

	public void setSiteAppCurrServList(
			List<WrapperBeanObject<SiteAppRegHistSrch>> siteAppCurrServList) {
		this.siteAppCurrServList = siteAppCurrServList;
	}

	public SiteAppRegHistSrch getSiteAppServ() {
		return siteAppServ;
	}

	public void setSiteAppServ(SiteAppRegHistSrch siteAppServ) {
		this.siteAppServ = siteAppServ;
	}

	public List<WrapperBeanObject<SiteAppRegHistSrch>> getSiteAppServList() {
		return siteAppServList;
	}

	public void setSiteAppServList(
			List<WrapperBeanObject<SiteAppRegHistSrch>> siteAppServList) {
		this.siteAppServList = siteAppServList;
	}

	public SiteAppSP getSiteContInfo() {
		return siteContInfo;
	}

	public void setSiteContInfo(SiteAppSP siteContInfo) {
		this.siteContInfo = siteContInfo;
	}

	public boolean isNoExpFlag() {
		return noExpFlag;
	}

	public void setNoExpFlag(boolean noExpFlag) {
		this.noExpFlag = noExpFlag;
	}

	public boolean isLeaseHoldRights() {
		return leaseHoldRights;
	}

	public void setLeaseHoldRights(boolean leaseHoldRights) {
		this.leaseHoldRights = leaseHoldRights;
	}

	public boolean isLicense() {
		return license;
	}

	public void setLicense(boolean license) {
		this.license = license;
	}

	public boolean isLlRentalAgreement() {
		return llRentalAgreement;
	}

	public void setLlRentalAgreement(boolean llRentalAgreement) {
		this.llRentalAgreement = llRentalAgreement;
	}

	public List<WrapperBeanObject<SiteAppSP>> getSiteAppRentCont() {
		return siteAppRentCont;
	}

	public void setSiteAppRentCont(
			List<WrapperBeanObject<SiteAppSP>> siteAppRentCont) {
		this.siteAppRentCont = siteAppRentCont;
	}

	public List<WrapperBeanObject<SiteAppSP>> getSiteAppRentServList() {
		return siteAppRentServList;
	}

	public void setSiteAppRentServList(
			List<WrapperBeanObject<SiteAppSP>> siteAppRentServList) {
		this.siteAppRentServList = siteAppRentServList;
	}

	public List<WrapperBeanObject<SiteAppSiteSP>> getSiteAppSiteInuseList() {
		return siteAppSiteInuseList;
	}

	public void setSiteAppSiteInuseList(
			List<WrapperBeanObject<SiteAppSiteSP>> siteAppSiteInuseList) {
		this.siteAppSiteInuseList = siteAppSiteInuseList;
	}

	public List<SelectItem> getLandAreaTypeList() {
		return landAreaTypeList;
	}

	public void setLandAreaTypeList(List<SelectItem> landAreaTypeList) {
		this.landAreaTypeList = landAreaTypeList;
	}

	public List<SelectItem> getPlaceTypeList() {
		return placeTypeList;
	}

	public void setPlaceTypeList(List<SelectItem> placeTypeList) {
		this.placeTypeList = placeTypeList;
	}

	public List<SelectItem> getDeckAreaTypeList() {
		return deckAreaTypeList;
	}

	public void setDeckAreaTypeList(List<SelectItem> deckAreaTypeList) {
		this.deckAreaTypeList = deckAreaTypeList;
	}

	public List<SelectItem> getRoomAreaTypeList() {
		return roomAreaTypeList;
	}

	public void setRoomAreaTypeList(List<SelectItem> roomAreaTypeList) {
		this.roomAreaTypeList = roomAreaTypeList;
	}

	public List<SelectItem> getBuildingAreaTypeList() {
		return buildingAreaTypeList;
	}

	public void setBuildingAreaTypeList(List<SelectItem> buildingAreaTypeList) {
		this.buildingAreaTypeList = buildingAreaTypeList;
	}

	public List<SelectItem> getDocTypeList() {
		return docTypeList;
	}

	public void setDocTypeList(List<SelectItem> docTypeList) {
		this.docTypeList = docTypeList;
	}

	public List<SelectItem> getSiteTypeList() {
		return siteTypeList;
	}

	public void setSiteTypeList(List<SelectItem> siteTypeList) {
		this.siteTypeList = siteTypeList;
	}

	public List<SelectItem> getProvinceLocalList() {
		return provinceLocalList;
	}

	public void setProvinceLocalList(List<SelectItem> provinceLocalList) {
		this.provinceLocalList = provinceLocalList;
	}

	public List<SelectItem> getProvinceReqDocList() {
		return provinceReqDocList;
	}

	public void setProvinceReqDocList(List<SelectItem> provinceReqDocList) {
		this.provinceReqDocList = provinceReqDocList;
	}

	public List<SelectItem> getAmphurLocalList() {
		return amphurLocalList;
	}

	public void setAmphurLocalList(List<SelectItem> amphurLocalList) {
		this.amphurLocalList = amphurLocalList;
	}

	public List<SelectItem> getAmphurReqDocList() {
		return amphurReqDocList;
	}

	public void setAmphurReqDocList(List<SelectItem> amphurReqDocList) {
		this.amphurReqDocList = amphurReqDocList;
	}

	public List<SelectItem> getExpenseTypeRentList() {
		return expenseTypeRentList;
	}

	public void setExpenseTypeRentList(List<SelectItem> expenseTypeRentList) {
		this.expenseTypeRentList = expenseTypeRentList;
	}

	public List<SelectItem> getServTypeList() {
		return servTypeList;
	}

	public void setServTypeList(List<SelectItem> servTypeList) {
		this.servTypeList = servTypeList;
	}

	public String getPlaceTypeTab1() {
		return placeTypeTab1;
	}

	public void setPlaceTypeTab1(String placeTypeTab1) {
		this.placeTypeTab1 = placeTypeTab1;
	}

	public String getPlaceTypeTab7() {
		return placeTypeTab7;
	}

	public void setPlaceTypeTab7(String placeTypeTab7) {
		this.placeTypeTab7 = placeTypeTab7;
	}

	public MSA001LovSP getLovObjParam() {
		return lovObjParam;
	}

	public void setLovObjParam(MSA001LovSP lovObjParam) {
		this.lovObjParam = lovObjParam;
	}

	public List<SelectItem> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<SelectItem> memberList) {
		this.memberList = memberList;
	}

	public List<SelectItem> getTeamList() {
		return teamList;
	}

	public void setTeamList(List<SelectItem> teamList) {
		this.teamList = teamList;
	}

	public SiteAppSP getChgReqObjParam() {
		return chgReqObjParam;
	}

	public void setChgReqObjParam(SiteAppSP chgReqObjParam) {
		this.chgReqObjParam = chgReqObjParam;
	}

	public boolean isChkRegion() {
		return chkRegion;
	}

	public void setChkRegion(boolean chkRegion) {
		this.chkRegion = chkRegion;
	}

	public boolean isChkReqOfficerManualPopup() {
		return chkReqOfficerManualPopup;
	}

	public void setChkReqOfficerManualPopup(boolean chkReqOfficerManualPopup) {
		this.chkReqOfficerManualPopup = chkReqOfficerManualPopup;
	}

	public List<WrapperBeanObject<SiteAppRegHistSrch>> getSiteAppRegHistList() {
		return siteAppRegHistList;
	}

	public void setSiteAppRegHistList(
			List<WrapperBeanObject<SiteAppRegHistSrch>> siteAppRegHistList) {
		this.siteAppRegHistList = siteAppRegHistList;
	}

	public List<WrapperBeanObject<SiteAppSP>> getSiteAppDocRemainList() {
		return siteAppDocRemainList;
	}

	public void setSiteAppDocRemainList(
			List<WrapperBeanObject<SiteAppSP>> siteAppDocRemainList) {
		this.siteAppDocRemainList = siteAppDocRemainList;
	}

	public List<SelectItem> getMsa002Tab2ProvinceLessorList() {
		return msa002Tab2ProvinceLessorList;
	}

	public void setMsa002Tab2ProvinceLessorList(
			List<SelectItem> msa002Tab2ProvinceLessorList) {
		this.msa002Tab2ProvinceLessorList = msa002Tab2ProvinceLessorList;
	}

	public List<SelectItem> getMsa002Tab2AmphurLessorList() {
		return msa002Tab2AmphurLessorList;
	}

	public void setMsa002Tab2AmphurLessorList(
			List<SelectItem> msa002Tab2AmphurLessorList) {
		this.msa002Tab2AmphurLessorList = msa002Tab2AmphurLessorList;
	}

	public List<SelectItem> getMsa002Tab2ProvinceContactList() {
		return msa002Tab2ProvinceContactList;
	}

	public void setMsa002Tab2ProvinceContactList(
			List<SelectItem> msa002Tab2ProvinceContactList) {
		this.msa002Tab2ProvinceContactList = msa002Tab2ProvinceContactList;
	}

	public List<SelectItem> getMsa002Tab2AmphurContactList() {
		return msa002Tab2AmphurContactList;
	}

	public void setMsa002Tab2AmphurContactList(
			List<SelectItem> msa002Tab2AmphurContactList) {
		this.msa002Tab2AmphurContactList = msa002Tab2AmphurContactList;
	}

	public List<SelectItem> getTitleList() {
		return titleList;
	}

	public void setTitleList(List<SelectItem> titleList) {
		this.titleList = titleList;
	}

	public boolean isChkService() {
		return chkService;
	}

	public void setChkService(boolean chkService) {
		this.chkService = chkService;
	}

	public boolean isChkRentAmtAdd() {
		return chkRentAmtAdd;
	}

	public void setChkRentAmtAdd(boolean chkRentAmtAdd) {
		this.chkRentAmtAdd = chkRentAmtAdd;
	}

	public SiteAppSP getSiteAppRentAmt() {
		return siteAppRentAmt;
	}

	public void setSiteAppRentAmt(SiteAppSP siteAppRentAmt) {
		this.siteAppRentAmt = siteAppRentAmt;
	}

	public SiteAppSP getSiteAppRentObjParam() {
		return siteAppRentObjParam;
	}

	public void setSiteAppRentObjParam(SiteAppSP siteAppRentObjParam) {
		this.siteAppRentObjParam = siteAppRentObjParam;
	}

	public List<WrapperBeanObject<SiteAppSP>> getSiteAppRentContExisting() {
		return siteAppRentContExisting;
	}

	public void setSiteAppRentContExisting(
			List<WrapperBeanObject<SiteAppSP>> siteAppRentContExisting) {
		this.siteAppRentContExisting = siteAppRentContExisting;
	}

	public List<SelectItem> getExpenseTypeDepositRentList() {
		return expenseTypeDepositRentList;
	}

	public void setExpenseTypeDepositRentList(
			List<SelectItem> expenseTypeDepositRentList) {
		this.expenseTypeDepositRentList = expenseTypeDepositRentList;
	}

	public SiteAppSP getSiteAppDeptObj() {
		return siteAppDeptObj;
	}

	public void setSiteAppDeptObj(SiteAppSP siteAppDeptObj) {
		this.siteAppDeptObj = siteAppDeptObj;
	}

	public List<WrapperBeanObject<SiteAppSP>> getSiteAppDeptBGList() {
		return siteAppDeptBGList;
	}

	public void setSiteAppDeptBGList(
			List<WrapperBeanObject<SiteAppSP>> siteAppDeptBGList) {
		this.siteAppDeptBGList = siteAppDeptBGList;
	}

	public List<WrapperBeanObject<SiteAppSP>> getSiteAppDeptCashList() {
		return siteAppDeptCashList;
	}

	public void setSiteAppDeptCashList(
			List<WrapperBeanObject<SiteAppSP>> siteAppDeptCashList) {
		this.siteAppDeptCashList = siteAppDeptCashList;
	}

	public boolean isDeptReceiveBg() {
		return deptReceiveBg;
	}

	public void setDeptReceiveBg(boolean deptReceiveBg) {
		this.deptReceiveBg = deptReceiveBg;
	}

	public boolean isDeptNoBg() {
		return deptNoBg;
	}

	public void setDeptNoBg(boolean deptNoBg) {
		this.deptNoBg = deptNoBg;
	}

	public boolean isDeptCancelBg() {
		return deptCancelBg;
	}

	public void setDeptCancelBg(boolean deptCancelBg) {
		this.deptCancelBg = deptCancelBg;
	}

	public boolean isRenderedPnlDeptCash() {
		return renderedPnlDeptCash;
	}

	public void setRenderedPnlDeptCash(boolean renderedPnlDeptCash) {
		this.renderedPnlDeptCash = renderedPnlDeptCash;
	}

	public boolean isRenderedPnlDeptBg() {
		return renderedPnlDeptBg;
	}

	public void setRenderedPnlDeptBg(boolean renderedPnlDeptBg) {
		this.renderedPnlDeptBg = renderedPnlDeptBg;
	}

	public SiteAppSP getSiteAppDeptCashObj() {
		return siteAppDeptCashObj;
	}

	public void setSiteAppDeptCashObj(SiteAppSP siteAppDeptCashObj) {
		this.siteAppDeptCashObj = siteAppDeptCashObj;
	}

	public SiteAppSP getSiteAppDeptBgObj() {
		return siteAppDeptBgObj;
	}

	public void setSiteAppDeptBgObj(SiteAppSP siteAppDeptBgObj) {
		this.siteAppDeptBgObj = siteAppDeptBgObj;
	}

	public String getDeptReturnType01() {
		return deptReturnType01;
	}

	public void setDeptReturnType01(String deptReturnType01) {
		this.deptReturnType01 = deptReturnType01;
	}

	public String getDeptReturnType02() {
		return deptReturnType02;
	}

	public void setDeptReturnType02(String deptReturnType02) {
		this.deptReturnType02 = deptReturnType02;
	}

	public String getDeptReturnType03() {
		return deptReturnType03;
	}

	public void setDeptReturnType03(String deptReturnType03) {
		this.deptReturnType03 = deptReturnType03;
	}

	public boolean isWithdrawFlag() {
		return withdrawFlag;
	}

	public void setWithdrawFlag(boolean withdrawFlag) {
		this.withdrawFlag = withdrawFlag;
	}

	public boolean isChkEditElExistingList() {
		return chkEditElExistingList;
	}

	public void setChkEditElExistingList(boolean chkEditElExistingList) {
		this.chkEditElExistingList = chkEditElExistingList;
	}

	public List<WrapperBeanObject<SiteAppSP>> getSiteAppELCondExistingList() {
		return siteAppELCondExistingList;
	}

	public void setSiteAppELCondExistingList(
			List<WrapperBeanObject<SiteAppSP>> siteAppELCondExistingList) {
		this.siteAppELCondExistingList = siteAppELCondExistingList;
	}

	public boolean isChkElUseOth() {
		return chkElUseOth;
	}

	public void setChkElUseOth(boolean chkElUseOth) {
		this.chkElUseOth = chkElUseOth;
	}

	public boolean isChkNoUtilPrice() {
		return chkNoUtilPrice;
	}

	public void setChkNoUtilPrice(boolean chkNoUtilPrice) {
		this.chkNoUtilPrice = chkNoUtilPrice;
	}

	public String getElPayPeriodType01() {
		return elPayPeriodType01;
	}

	public void setElPayPeriodType01(String elPayPeriodType01) {
		this.elPayPeriodType01 = elPayPeriodType01;
	}

	public String getElPayPeriodType02() {
		return elPayPeriodType02;
	}

	public void setElPayPeriodType02(String elPayPeriodType02) {
		this.elPayPeriodType02 = elPayPeriodType02;
	}

	public String getElPayPeriodType03() {
		return elPayPeriodType03;
	}

	public void setElPayPeriodType03(String elPayPeriodType03) {
		this.elPayPeriodType03 = elPayPeriodType03;
	}

	public String getElPayPeriodType04() {
		return elPayPeriodType04;
	}

	public void setElPayPeriodType04(String elPayPeriodType04) {
		this.elPayPeriodType04 = elPayPeriodType04;
	}

	public String getElPayPeriodType05() {
		return elPayPeriodType05;
	}

	public void setElPayPeriodType05(String elPayPeriodType05) {
		this.elPayPeriodType05 = elPayPeriodType05;
	}

	public String getElPayPeriodType06() {
		return elPayPeriodType06;
	}

	public void setElPayPeriodType06(String elPayPeriodType06) {
		this.elPayPeriodType06 = elPayPeriodType06;
	}

	public String getElPayPeriodType07() {
		return elPayPeriodType07;
	}

	public void setElPayPeriodType07(String elPayPeriodType07) {
		this.elPayPeriodType07 = elPayPeriodType07;
	}

	public Integer getElPayPeriod03() {
		return elPayPeriod03;
	}

	public void setElPayPeriod03(Integer elPayPeriod03) {
		this.elPayPeriod03 = elPayPeriod03;
	}

	public Integer getElPayPeriod04() {
		return elPayPeriod04;
	}

	public void setElPayPeriod04(Integer elPayPeriod04) {
		this.elPayPeriod04 = elPayPeriod04;
	}

	public List<SelectItem> getElCondTypeList() {
		return elCondTypeList;
	}

	public void setElCondTypeList(List<SelectItem> elCondTypeList) {
		this.elCondTypeList = elCondTypeList;
	}

	public List<SelectItem> getElCondSubTypeList() {
		return elCondSubTypeList;
	}

	public void setElCondSubTypeList(List<SelectItem> elCondSubTypeList) {
		this.elCondSubTypeList = elCondSubTypeList;
	}

	public boolean isDisabledElPayPeriod03() {
		return disabledElPayPeriod03;
	}

	public void setDisabledElPayPeriod03(boolean disabledElPayPeriod03) {
		this.disabledElPayPeriod03 = disabledElPayPeriod03;
	}

	public boolean isDisabledElPayPeriod04() {
		return disabledElPayPeriod04;
	}

	public void setDisabledElPayPeriod04(boolean disabledElPayPeriod04) {
		this.disabledElPayPeriod04 = disabledElPayPeriod04;
	}

	public SiteAppSP getSiteAppELObjParam() {
		return siteAppELObjParam;
	}

	public void setSiteAppELObjParam(SiteAppSP siteAppELObjParam) {
		this.siteAppELObjParam = siteAppELObjParam;
	}

	public List<WrapperBeanObject<SiteAppSP>> getSiteAppELCondTakeAllList() {
		return siteAppELCondTakeAllList;
	}

	public void setSiteAppELCondTakeAllList(
			List<WrapperBeanObject<SiteAppSP>> siteAppELCondTakeAllList) {
		this.siteAppELCondTakeAllList = siteAppELCondTakeAllList;
	}

	public List<WrapperBeanObject<SiteAppSP>> getSiteAppELCondUnitList() {
		return siteAppELCondUnitList;
	}

	public void setSiteAppELCondUnitList(
			List<WrapperBeanObject<SiteAppSP>> siteAppELCondUnitList) {
		this.siteAppELCondUnitList = siteAppELCondUnitList;
	}

	public List<WrapperBeanObject<SiteAppSP>> getSiteAppELCondOtherList() {
		return siteAppELCondOtherList;
	}

	public void setSiteAppELCondOtherList(
			List<WrapperBeanObject<SiteAppSP>> siteAppELCondOtherList) {
		this.siteAppELCondOtherList = siteAppELCondOtherList;
	}

	public SiteAppSP getSiteAppDeptElObj() {
		return siteAppDeptElObj;
	}

	public void setSiteAppDeptElObj(SiteAppSP siteAppDeptElObj) {
		this.siteAppDeptElObj = siteAppDeptElObj;
	}

	public SiteAppSP getSiteAppDeptCashElObj() {
		return siteAppDeptCashElObj;
	}

	public void setSiteAppDeptCashElObj(SiteAppSP siteAppDeptCashElObj) {
		this.siteAppDeptCashElObj = siteAppDeptCashElObj;
	}

	public SiteAppSP getSiteAppDeptBgElObj() {
		return siteAppDeptBgElObj;
	}

	public void setSiteAppDeptBgElObj(SiteAppSP siteAppDeptBgElObj) {
		this.siteAppDeptBgElObj = siteAppDeptBgElObj;
	}

	public List<WrapperBeanObject<SiteAppSP>> getSiteAppDeptBGElList() {
		return siteAppDeptBGElList;
	}

	public void setSiteAppDeptBGElList(
			List<WrapperBeanObject<SiteAppSP>> siteAppDeptBGElList) {
		this.siteAppDeptBGElList = siteAppDeptBGElList;
	}

	public List<WrapperBeanObject<SiteAppSP>> getSiteAppDeptCashElList() {
		return siteAppDeptCashElList;
	}

	public void setSiteAppDeptCashElList(
			List<WrapperBeanObject<SiteAppSP>> siteAppDeptCashElList) {
		this.siteAppDeptCashElList = siteAppDeptCashElList;
	}

	public boolean isRenderedPnlDeptCashEl() {
		return renderedPnlDeptCashEl;
	}

	public void setRenderedPnlDeptCashEl(boolean renderedPnlDeptCashEl) {
		this.renderedPnlDeptCashEl = renderedPnlDeptCashEl;
	}

	public boolean isRenderedPnlDeptBgEl() {
		return renderedPnlDeptBgEl;
	}

	public void setRenderedPnlDeptBgEl(boolean renderedPnlDeptBgEl) {
		this.renderedPnlDeptBgEl = renderedPnlDeptBgEl;
	}

	public String getDeptReturnTypeEl01() {
		return deptReturnTypeEl01;
	}

	public void setDeptReturnTypeEl01(String deptReturnTypeEl01) {
		this.deptReturnTypeEl01 = deptReturnTypeEl01;
	}

	public String getDeptReturnTypeEl02() {
		return deptReturnTypeEl02;
	}

	public void setDeptReturnTypeEl02(String deptReturnTypeEl02) {
		this.deptReturnTypeEl02 = deptReturnTypeEl02;
	}

	public String getDeptReturnTypeEl03() {
		return deptReturnTypeEl03;
	}

	public void setDeptReturnTypeEl03(String deptReturnTypeEl03) {
		this.deptReturnTypeEl03 = deptReturnTypeEl03;
	}

	public boolean isWithdrawFlagEl() {
		return withdrawFlagEl;
	}

	public void setWithdrawFlagEl(boolean withdrawFlagEl) {
		this.withdrawFlagEl = withdrawFlagEl;
	}

	public List<SelectItem> getExpenseTypeDepositElList() {
		return expenseTypeDepositElList;
	}

	public void setExpenseTypeDepositElList(
			List<SelectItem> expenseTypeDepositElList) {
		this.expenseTypeDepositElList = expenseTypeDepositElList;
	}

	public SiteAppSP getSiteAppPTObj() {
		return siteAppPTObj;
	}

	public void setSiteAppPTObj(SiteAppSP siteAppPTObj) {
		this.siteAppPTObj = siteAppPTObj;
	}

	public SiteAppSP getSiteAppPTObjParam() {
		return siteAppPTObjParam;
	}

	public void setSiteAppPTObjParam(SiteAppSP siteAppPTObjParam) {
		this.siteAppPTObjParam = siteAppPTObjParam;
	}

	public SiteAppSP getSiteAppInsuranceObj() {
		return siteAppInsuranceObj;
	}

	public void setSiteAppInsuranceObj(SiteAppSP siteAppInsuranceObj) {
		this.siteAppInsuranceObj = siteAppInsuranceObj;
	}

	public SiteAppSP getSiteAppInsuranceObjParam() {
		return siteAppInsuranceObjParam;
	}

	public void setSiteAppInsuranceObjParam(SiteAppSP siteAppInsuranceObjParam) {
		this.siteAppInsuranceObjParam = siteAppInsuranceObjParam;
	}

	public List<WrapperBeanObject<SiteAppSP>> getSiteAppPTHistList() {
		return siteAppPTHistList;
	}

	public void setSiteAppPTHistList(
			List<WrapperBeanObject<SiteAppSP>> siteAppPTHistList) {
		this.siteAppPTHistList = siteAppPTHistList;
	}

	public boolean isRenderedPLX() {
		return renderedPLX;
	}

	public void setRenderedPLX(boolean renderedPLX) {
		this.renderedPLX = renderedPLX;
	}

	public boolean isRenderedInsuranceOwner() {
		return renderedInsuranceOwner;
	}

	public void setRenderedInsuranceOwner(boolean renderedInsuranceOwner) {
		this.renderedInsuranceOwner = renderedInsuranceOwner;
	}

	public List<SelectItem> getPeriodTypeList() {
		return periodTypeList;
	}

	public void setPeriodTypeList(List<SelectItem> periodTypeList) {
		this.periodTypeList = periodTypeList;
	}

	public String getPayPeriodTypeIns01() {
		return payPeriodTypeIns01;
	}

	public void setPayPeriodTypeIns01(String payPeriodTypeIns01) {
		this.payPeriodTypeIns01 = payPeriodTypeIns01;
	}

	public String getPayPeriodTypeIns02() {
		return payPeriodTypeIns02;
	}

	public void setPayPeriodTypeIns02(String payPeriodTypeIns02) {
		this.payPeriodTypeIns02 = payPeriodTypeIns02;
	}

	public String getPayPeriodTypeIns03() {
		return payPeriodTypeIns03;
	}

	public void setPayPeriodTypeIns03(String payPeriodTypeIns03) {
		this.payPeriodTypeIns03 = payPeriodTypeIns03;
	}

	public String getPayPeriodTypeIns04() {
		return payPeriodTypeIns04;
	}

	public void setPayPeriodTypeIns04(String payPeriodTypeIns04) {
		this.payPeriodTypeIns04 = payPeriodTypeIns04;
	}

	public String getPayPeriodTypeIns05() {
		return payPeriodTypeIns05;
	}

	public void setPayPeriodTypeIns05(String payPeriodTypeIns05) {
		this.payPeriodTypeIns05 = payPeriodTypeIns05;
	}

	public String getPayPeriodTypeIns06() {
		return payPeriodTypeIns06;
	}

	public void setPayPeriodTypeIns06(String payPeriodTypeIns06) {
		this.payPeriodTypeIns06 = payPeriodTypeIns06;
	}

	public String getPayPeriodTypeIns07() {
		return payPeriodTypeIns07;
	}

	public void setPayPeriodTypeIns07(String payPeriodTypeIns07) {
		this.payPeriodTypeIns07 = payPeriodTypeIns07;
	}

	public boolean isDisabledPayPeriodIns03() {
		return disabledPayPeriodIns03;
	}

	public void setDisabledPayPeriodIns03(boolean disabledPayPeriodIns03) {
		this.disabledPayPeriodIns03 = disabledPayPeriodIns03;
	}

	public boolean isDisabledPayPeriodIns04() {
		return disabledPayPeriodIns04;
	}

	public void setDisabledPayPeriodIns04(boolean disabledPayPeriodIns04) {
		this.disabledPayPeriodIns04 = disabledPayPeriodIns04;
	}

	public Integer getPayPeriodIns03() {
		return payPeriodIns03;
	}

	public void setPayPeriodIns03(Integer payPeriodIns03) {
		this.payPeriodIns03 = payPeriodIns03;
	}

	public Integer getPayPeriodIns04() {
		return payPeriodIns04;
	}

	public void setPayPeriodIns04(Integer payPeriodIns04) {
		this.payPeriodIns04 = payPeriodIns04;
	}

	public List<WrapperBeanObject<SiteAppSP>> getSiteAppInsuranceList() {
		return siteAppInsuranceList;
	}

	public void setSiteAppInsuranceList(
			List<WrapperBeanObject<SiteAppSP>> siteAppInsuranceList) {
		this.siteAppInsuranceList = siteAppInsuranceList;
	}

	public boolean isPropertyTaxEditFlag() {
		return propertyTaxEditFlag;
	}

	public void setPropertyTaxEditFlag(boolean propertyTaxEditFlag) {
		this.propertyTaxEditFlag = propertyTaxEditFlag;
	}

	public boolean isInsuranceEditFlag() {
		return insuranceEditFlag;
	}

	public void setInsuranceEditFlag(boolean insuranceEditFlag) {
		this.insuranceEditFlag = insuranceEditFlag;
	}

	public boolean isNoOwnerAmtFlag() {
		return noOwnerAmtFlag;
	}

	public void setNoOwnerAmtFlag(boolean noOwnerAmtFlag) {
		this.noOwnerAmtFlag = noOwnerAmtFlag;
	}

	public List<SelectItem> getInsuranceTypeList() {
		return insuranceTypeList;
	}

	public void setInsuranceTypeList(List<SelectItem> insuranceTypeList) {
		this.insuranceTypeList = insuranceTypeList;
	}

	public String getIrHeaderLabel() {
		return irHeaderLabel;
	}

	public void setIrHeaderLabel(String irHeaderLabel) {
		this.irHeaderLabel = irHeaderLabel;
	}

	public boolean isRenderedTbElUnit() {
		return renderedTbElUnit;
	}

	public void setRenderedTbElUnit(boolean renderedTbElUnit) {
		this.renderedTbElUnit = renderedTbElUnit;
	}

	public boolean isRenderedTbElTakeAll() {
		return renderedTbElTakeAll;
	}

	public void setRenderedTbElTakeAll(boolean renderedTbElTakeAll) {
		this.renderedTbElTakeAll = renderedTbElTakeAll;
	}

	public boolean isRenderedTbElUseOth() {
		return renderedTbElUseOth;
	}

	public void setRenderedTbElUseOth(boolean renderedTbElUseOth) {
		this.renderedTbElUseOth = renderedTbElUseOth;
	}

	public List<SelectItem> getReqTitleList() {
		return reqTitleList;
	}

	public void setReqTitleList(List<SelectItem> reqTitleList) {
		this.reqTitleList = reqTitleList;
	}

	public boolean isChkEditContractInfo() {
		return chkEditContractInfo;
	}

	public void setChkEditContractInfo(boolean chkEditContractInfo) {
		this.chkEditContractInfo = chkEditContractInfo;
	}

	public boolean isChkEditELDeposit() {
		return chkEditELDeposit;
	}

	public void setChkEditELDeposit(boolean chkEditELDeposit) {
		this.chkEditELDeposit = chkEditELDeposit;
	}

	public boolean isChkNoELDeposit() {
		return chkNoELDeposit;
	}

	public void setChkNoELDeposit(boolean chkNoELDeposit) {
		this.chkNoELDeposit = chkNoELDeposit;
	}

	public boolean isChkNoRentalDeposit() {
		return chkNoRentalDeposit;
	}

	public void setChkNoRentalDeposit(boolean chkNoRentalDeposit) {
		this.chkNoRentalDeposit = chkNoRentalDeposit;
	}

	public boolean isChkEditRentalDeposit() {
		return chkEditRentalDeposit;
	}

	public void setChkEditRentalDeposit(boolean chkEditRentalDeposit) {
		this.chkEditRentalDeposit = chkEditRentalDeposit;
	}

	public List<SiteAppMailSP> getSiteAppMailExpList() {
		return siteAppMailExpList;
	}

	public void setSiteAppMailExpList(List<SiteAppMailSP> siteAppMailExpList) {
		this.siteAppMailExpList = siteAppMailExpList;
	}

	public boolean isRenderedMsgExpMail() {
		return renderedMsgExpMail;
	}

	public void setRenderedMsgExpMail(boolean renderedMsgExpMail) {
		this.renderedMsgExpMail = renderedMsgExpMail;
	}

	public List<WrapperBeanObject<SiteAppSP>> getSiteAppdocExtList() {
		return siteAppdocExtList;
	}

	public void setSiteAppdocExtList(
			List<WrapperBeanObject<SiteAppSP>> siteAppdocExtList) {
		this.siteAppdocExtList = siteAppdocExtList;
	}

	public List<WrapperBeanObject<SiteAppSP>> getSiteAppdocHistList() {
		return siteAppdocHistList;
	}

	public void setSiteAppdocHistList(
			List<WrapperBeanObject<SiteAppSP>> siteAppdocHistList) {
		this.siteAppdocHistList = siteAppdocHistList;
	}

	public boolean isChkEditSiteAppDoc() {
		return chkEditSiteAppDoc;
	}

	public void setChkEditSiteAppDoc(boolean chkEditSiteAppDoc) {
		this.chkEditSiteAppDoc = chkEditSiteAppDoc;
	}

	public List<WrapperBeanObject<SiteAppSP>> getSiteAppELCondNoExpenseList() {
		return siteAppELCondNoExpenseList;
	}

	public void setSiteAppELCondNoExpenseList(
			List<WrapperBeanObject<SiteAppSP>> siteAppELCondNoExpenseList) {
		this.siteAppELCondNoExpenseList = siteAppELCondNoExpenseList;
	}

	public boolean isRenderedTbElNoExpense() {
		return renderedTbElNoExpense;
	}

	public void setRenderedTbElNoExpense(boolean renderedTbElNoExpense) {
		this.renderedTbElNoExpense = renderedTbElNoExpense;
	}

	public boolean isRenderedMsgDeposit() {
		return renderedMsgDeposit;
	}

	public void setRenderedMsgDeposit(boolean renderedMsgDeposit) {
		this.renderedMsgDeposit = renderedMsgDeposit;
	}

	public SiteAppSP getSiteAppLocalObjParam() {
		return siteAppLocalObjParam;
	}

	public void setSiteAppLocalObjParam(SiteAppSP siteAppLocalObjParam) {
		this.siteAppLocalObjParam = siteAppLocalObjParam;
	}
	public int getCountElTypeList() {
		return countElTypeList;
	}

	public void setCountElTypeList(int countElTypeList) {
		this.countElTypeList = countElTypeList;
	}

	public String getMsgReqcompanyPopup() {
		return msgReqcompanyPopup;
	}

	public void setMsgReqcompanyPopup(String msgReqcompanyPopup) {
		this.msgReqcompanyPopup = msgReqcompanyPopup;
	}
	
	public boolean isChkEditFlag() {
		return chkEditFlag;
	}

	public void setChkEditFlag(boolean chkEditFlag) {
		this.chkEditFlag = chkEditFlag;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public ItemResultSP getRetResultObj() {
		if(retResultObj == null){
			retResultObj = new ItemResultSP();
		}
		return retResultObj; 
	}
	public void setRetResultObj(ItemResultSP retResultObj) {
		this.retResultObj = retResultObj;
	}

	public boolean isRenderedMsgPopup() {
		return renderedMsgPopup;
	}

	public void setRenderedMsgPopup(boolean renderedMsgPopup) {
		this.renderedMsgPopup = renderedMsgPopup;
	}

	public boolean isChkEditRental() {
		return chkEditRental;
	}

	public void setChkEditRental(boolean chkEditRental) {
		this.chkEditRental = chkEditRental;
	}

	public boolean isChkElPayOneCond() {
		return chkElPayOneCond;
	}

	public void setChkElPayOneCond(boolean chkElPayOneCond) {
		this.chkElPayOneCond = chkElPayOneCond;
	}

	public List<SelectItem> getOwnerCategoryList() {
		return ownerCategoryList;
	}

	public void setOwnerCategoryList(List<SelectItem> ownerCategoryList) {
		this.ownerCategoryList = ownerCategoryList;
	}
	
	public List<SelectItem> getElUseTypeList() {
		return elUseTypeList;
	}

	public void setElUseTypeList(List<SelectItem> elUseTypeList) {
		this.elUseTypeList = elUseTypeList;
	}

	public List<WrapperBeanObject<SiteAppSP>> getSiteAppELCondAllList() {
		return siteAppELCondAllList;
	}

	public void setSiteAppELCondAllList(
			List<WrapperBeanObject<SiteAppSP>> siteAppELCondAllList) {
		this.siteAppELCondAllList = siteAppELCondAllList;
	}

	public boolean isDisabledBtnExportAddr() {
		return disabledBtnExportAddr;
	}

	public void setDisabledBtnExportAddr(boolean disabledBtnExportAddr) {
		this.disabledBtnExportAddr = disabledBtnExportAddr;
	}

	public String getMailAddrIdTmp() {
		return mailAddrIdTmp;
	}

	public void setMailAddrIdTmp(String mailAddrIdTmp) {
		this.mailAddrIdTmp = mailAddrIdTmp;
	}

	public String getpRemark() {
		return pRemark;
	}

	public void setpRemark(String pRemark) {
		this.pRemark = pRemark;
	}

	public boolean isShowEditBtn() {
		return showEditBtn;
	}

	public void setShowEditBtn(boolean showEditBtn) {
		this.showEditBtn = showEditBtn;
	}

	public boolean isChkReturnDepositFlag() {
		return chkReturnDepositFlag;
	}

	public void setChkReturnDepositFlag(boolean chkReturnDepositFlag) {
		this.chkReturnDepositFlag = chkReturnDepositFlag;
	}

	public boolean isChkNoReturnDepositFlag() {
		return chkNoReturnDepositFlag;
	}

	public void setChkNoReturnDepositFlag(boolean chkNoReturnDepositFlag) {
		this.chkNoReturnDepositFlag = chkNoReturnDepositFlag;
	}

	public boolean isChkCancelMeterFlag() {
		return chkCancelMeterFlag;
	}

	public void setChkCancelMeterFlag(boolean chkCancelMeterFlag) {
		this.chkCancelMeterFlag = chkCancelMeterFlag;
	}

	public boolean isChkTerminateElFlag() {
		return chkTerminateElFlag;
	}

	public void setChkTerminateElFlag(boolean chkTerminateElFlag) {
		this.chkTerminateElFlag = chkTerminateElFlag;
	}

	public boolean isChkOtherTerminateFlag() {
		return chkOtherTerminateFlag;
	}

	public void setChkOtherTerminateFlag(boolean chkOtherTerminateFlag) {
		this.chkOtherTerminateFlag = chkOtherTerminateFlag;
	}

	public boolean isChkOtherWaitingFlag() {
		return chkOtherWaitingFlag;
	}

	public void setChkOtherWaitingFlag(boolean chkOtherWaitingFlag) {
		this.chkOtherWaitingFlag = chkOtherWaitingFlag;
	}

	public List<SelectItem> getOwnerSubCategoryList() {
		return ownerSubCategoryList;
	}

	public void setOwnerSubCategoryList(List<SelectItem> ownerSubCategoryList) {
		this.ownerSubCategoryList = ownerSubCategoryList;
	}

	public boolean isChkContRentAdd() {
		return chkContRentAdd;
	}

	public void setChkContRentAdd(boolean chkContRentAdd) {
		this.chkContRentAdd = chkContRentAdd;
	}

	public List<SelectItem> getRentAdjList() {
		return rentAdjList;
	}

	public void setRentAdjList(List<SelectItem> rentAdjList) {
		this.rentAdjList = rentAdjList;
	}
	
	public boolean isDisabledExpenseDesc() {
		return disabledExpenseDesc;
	}

	public void setDisabledExpenseDesc(boolean disabledExpenseDesc) {
		this.disabledExpenseDesc = disabledExpenseDesc;
	}
}
