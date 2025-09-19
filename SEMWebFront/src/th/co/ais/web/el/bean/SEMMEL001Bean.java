package th.co.ais.web.el.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.faces.model.SelectItem;

import org.richfaces.model.TreeNode;
import org.richfaces.model.UploadItem;

import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.el.DepositDetail;
import th.co.ais.domain.el.ElUseTypeDetailSP;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.ManagementWrapper;
import th.co.ais.domain.el.MeterFile;
import th.co.ais.domain.el.MeterInfo;
import th.co.ais.domain.el.MeterInfoHistory;
import th.co.ais.domain.el.Payment;
import th.co.ais.domain.el.PaymentDetail;
import th.co.ais.domain.el.PopupSiteSearch;
import th.co.ais.domain.el.PrivateDeposit;
import th.co.ais.domain.el.VendorMapPayeeEL;
import th.co.ais.domain.gm.Bank;
import th.co.ais.domain.gm.CT001SrchMSP;
import th.co.ais.domain.gm.PayeeBookbank;
import th.co.ais.domain.gm.PayeeMaster;
import th.co.ais.domain.gm.PayeeMasterSP;
import th.co.ais.domain.gm.VendorBookbank;
import th.co.ais.domain.gm.VendorMapPayee;
import th.co.ais.domain.gm.VendorMaster;
import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.domain.gm.Zone;
import th.co.ais.domain.rt.Mrt001SrchRentPay;
import th.co.ais.domain.rt.VerifyRentalSearchSiteInfoSP;
import th.co.ais.service.util.ServiceConstants;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;
import th.co.ais.web.bean.TreeUtilBean;

public class SEMMEL001Bean extends AbstractBean implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7809909203218562367L;
		
	// --- LOVs ---
	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> siteStatusList;
	private List<SelectItem> electricUseTypeList;
	private List<SelectItem> electricUseTypeList2;
	private List<SelectItem> processStatusNameList;
	private List<SelectItem> depositTypeList;
	private List<SelectItem> provinceList;
	private List<SelectItem> amphurList;
	private List<SelectItem> bgStatusList;
	private List<SelectItem> refDocTypeList;
	private List<SelectItem> paymentMethodList;
	private List<SelectItem> paymentTypeList;
	private List<SelectItem> monthList;
	private List<SelectItem> feeCheckAreaList;
	private List<SelectItem> expenseTypeList;
	private List<SelectItem> elMeterRateList;
	private List<SelectItem> elMeterTypeList;
	private List<SelectItem> elCheckAreaList;
	private List<SelectItem> elMeterStatusList;
	private List<SelectItem> vatTypeList;
	private List<SelectItem> elActionList;//WT###Add 20110225
	private List<SelectItem> zoneList;
	private List<Zone> allZoneList;
	private List<SelectItem> elOwnerGroupList;
	// --- variable ---
	private ManagementWrapper wrapper;
	private int rowIndex;
	private String depositType;
	private boolean chkSelAll;
	private boolean exportButtonEnable;
	private boolean renderedOnToDoList;
	private Management searchCriteria;
	private List<ManagementWrapper> manageWrapperList;
	private String privateCaseFlagAlertMessage;
	private String expandFlagAlertMessage;
	private String terminateFlagAlertMessage;
	private String privateSpecailAlertMessage;
	private List<MeterFile> meterFileList;
	private List<UploadItem> uploadFileList;
	private ManagementWrapper manageWrapper;
	private int tempIndex;
	
	private String companyBigLabel;

	private List<ManagementWrapper> paymentWrapperList;
	private String removeItemId;
	private String selectedIndex;
	private boolean btUpdateVisible = false;
	private boolean btSaveVisible = false;
	private boolean btaddVisible = false;
	private boolean editRow = false;
	
	private boolean fpaymentMethodDisable = false;
	private boolean fremarkDisable =false;
	private boolean fchqPostingDtDisable =false;
	private boolean fchqReceivedDtDisable =false;
	private boolean ftransferDtDisable =false;
	private boolean frefDocTypeDisable= false;
	private boolean frefDocNoDisable= false;
	private boolean frefDocDtDisable= false;
	private boolean fpaymentTypeDisable= false;
	private boolean fbankNameLabelVisible = false;
	private boolean fbankNameInputVisible = false;
	private boolean fvatAmtDisable;
	private boolean ffeeWbsCodeRequireVisible=false;
	private boolean fpaymentRemark = false;
	private boolean fexpenseTypeDisable = false;
	private boolean disableButtonForPaymentPage8;
	private boolean isComeFromOtherPage;//WT###Add 20110113
	private boolean isComeFromPage5;//WT###Add 20110216
	private String methodWithNaviFrom;//WT###Add 20110216
	private boolean displayShowReport;//WT###Add 20110225
	private boolean displayShowPrintButton;//WT###Add 20110307
	private boolean displayDeleteContractButton;
	private boolean isComeFromOtherPage5_5 = false;
	
	// View Meter Info
	private boolean isComeFromVieMeterInfo;
	private String fromPage;
	
	private Integer sumItem;
	private List<PrivateDeposit> privateDepositList;
	private List<PrivateDeposit> oldPrivateDepositList;//WT###Add 20110113
	private List<DepositDetail> eDepositDetailList;
	private List<MeterInfo> meterInfoList;
	private String selectedRowIndex;
	private Management manageInfo;
	private List<Management> manageInfoList;
	private MeterInfo meterInfo;
	private String popupMsg;
	private String manageRowIdEdit;
	private List<MeterInfo> meterInfoMeaPeaList;
	private List<MeterInfo> meterInfoPrivateList;
	private List<MeterInfo> meterInfoOtherList;
	private String selectedMeterId;
	private List<PaymentDetail> deletedPaymentDetailList = new ArrayList<PaymentDetail>(0);
	private List<PaymentDetail> oldPaymentDetailList = new ArrayList<PaymentDetail>(0);
	private List<ManagementWrapper> groupReceiveList;
	private Date groupReceiveDt;
	private boolean displayGroupReceivePopup;
	private String meterId;
	private List<VendorMapPayeeEL> vendorMapPayeeList;//WT###Add 20110210
	private String selectedRadio = "";//WT###Add 20110211
	//WT###Add 20110314 Start
	private String navModuleFrom2;
	private String navProgramFrom2;
	private String actionWithNaviFrom2;
	//WT###Add 20110314 End
	
	//WT###Add 20110214 Start
	//for search criteria
	private VendorMasterSP criteriaVendorSP;
	private Bank criteriaBank;
	
	//for edit data
	private VendorMaster vendorMaster;
	private PayeeMaster payeeMaster;
	
	//for display when click edit in payee list ct001-2
	private CT001SrchMSP ct001SrchMSP;
	//for edit data in payee list ct001-2
	private VendorBookbank vendorBookBank;
	//for edit data in payee list ct001-3
	private PayeeBookbank payeeBookBank;
	
	private VendorMapPayee vendorMapPayee;
	
	//select Item ct001-1
	private List<SelectItem> vendorStatusSelList;
	private List<SelectItem> bookbankStatusSelList;
	
	//select Item ct001-2
	private List<SelectItem> vendorTypeStatus;
	private List<SelectItem> provinceSelList;
	private List<SelectItem> amphurSelList;
	private List<SelectItem> expenseTypeSelList;
	private List<SelectItem> bankAccountSelList;
	
	
	//data table
	public List<WrapperBeanObject<VendorMasterSP>> vendorMasterList;
	//data table select vendor in pop up
	public List<VendorMasterSP> vendorMasterSelList;
	//data table select payee in pop up
	public List<PayeeMasterSP> payeeMasterSelList;
	//data table select vendor book bank in pop up
	public List<Bank> bankSelList;
	public List<Bank> bankTmpSelList;
	//private String selectedRadio = "";
	
	//data table ct001-2
	public List<WrapperBeanObject<CT001SrchMSP>> ct001SrchMSPList;
	
	//rendered pop up select vendor
	private boolean renderedSelectVendorPopup = false;
	private boolean renderedSelectPayeePopup = false;
	//force to input bank information in case , bank is not found when user kep on.
	private boolean isForceInputBankInfo = false; 
	private boolean isNewBankInfo = false;
	
	//Export Excel
	//private boolean chkSelAll = false;
	
	private String mode = ServiceConstants.MODULE_ACTION_INSERT;
	private String modePanelInfo = ServiceConstants.MODULE_ACTION_INSERT;
	
	
	//rendered require 
	private boolean renderedRequireIdCard = false;
	private boolean renderedRequireTaxId = false;
	//disabled button add alternative payee
	private boolean disabledButtonAddAlter = false;
	
	
	//for copy vendor address.
	private String tmpVendorMasterId;
	//for set size of table VendorMapPayee size
	private int vendorMapSize = 0;
	
	private boolean isVendorExisted;
	private boolean disbledCheckVendorButton;
	
	private Bank newBank;
	
	//temp lessor Id
	private String tmpLessorId;
	private boolean pTaxFlag = false;
	private String areaCode;
	private String areaName;
	private String meterStatus;
	
	//WT###Add 20110214 End
	
	//***********************************
	private boolean editFeePayment = true;
	
	//***********************************
	//Momo
	private boolean disableElectricStatus = false;
	private String disableElectricStatusDisplay;
	private String exportMsg;
	private boolean disaplayExport = false;
	private String deleteMsg;
	private List<SelectItem> periodTypeList = new ArrayList<SelectItem>();
	private String periodType;
	private boolean disablePrivatePaymentType = false;
	private boolean disablePrivatePrePaidPaymentType = false;
	private boolean disableCheckUnitType = false;
	private boolean disablePayPerMonth = false;
	private boolean disablePayPerYear = false;
	private String payPeriodType01;
	private String payPeriodType02;
	private String payPeriodType03;
	private String payPeriodType04;
	private String payPeriodType05;
	private Long payPeriod03;
	private Long payPeriod04;
	private boolean disabledPayPeriod03;
	private boolean disabledPayPeriod04;
	private String exportSize;
	private boolean viewMode = false;
	
	private boolean displayReport;
	private HashMap<String, String> mapElId;
	private String elLongStr;
	private boolean renderedELMethod = false;
	private boolean disableVat = false;
	private boolean renderedVat = false;
	private List<ElUseTypeDetailSP> elUseList;
	//added by new 15/10/2014
	private List<ElUseTypeDetailSP> elHistoryList;
	private String rentalMasterId;
	private VerifyRentalSearchSiteInfoSP criteria, displayFrmRental;
	//Tab Check Premium
	private List<Mrt001SrchRentPay> rentPayList;
	
	private ElUseTypeDetailSP elUseSp;
	private Double defaultVatRate;
	private String elTmpId;
	private String modeType;
	private String tmpPayPeriodType;
	
	//added by NEW 17/03/2015
	private TreeUtilBean treeUtilBean;
	private TreeNode rootNode = null;
	
	//added by NEW 20151030
	public boolean treeMacroFlag = false;
	public String headerTreeMacro;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreeMacroList;
	
	public boolean treePicoFlag = false;
	public String headerTreePico;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreePicoList;
	
	//added by NEW 2015/12/04
	private VendorMasterSP vendorMasterPopupObjParam;
	public List<WrapperBeanObject<VendorMasterSP>> vendorMasterPopupList;
	private PopupSiteSearch popupSiteCriteria;
	
	
	public List<MeterInfoHistory> meterHistory;
	
	
	
	// --- method ---
	// getter & setter
	public List<SelectItem> getBgStatusList() {
		return bgStatusList;
	}

	public List<PaymentDetail> getDeletedPaymentDetailList() {
		return deletedPaymentDetailList;
	}

	public void setDeletedPaymentDetailList(
			List<PaymentDetail> deletedPaymentDetailList) {
		this.deletedPaymentDetailList = deletedPaymentDetailList;
	}

	public boolean isDisableButtonForPaymentPage8() {
		return disableButtonForPaymentPage8;
	}

	public void setDisableButtonForPaymentPage8(boolean disableButtonForPaymentPage8) {
		this.disableButtonForPaymentPage8 = disableButtonForPaymentPage8;
	}

	public List<SelectItem> getVatTypeList() {
		return vatTypeList;
	}

	public void setVatTypeList(List<SelectItem> vatTypeList) {
		this.vatTypeList = vatTypeList;
	}

	public boolean isFvatAmtDisable() {
		return fvatAmtDisable;
	}

	public void setFvatAmtDisable(boolean fvatAmtDisable) {
		this.fvatAmtDisable = fvatAmtDisable;
	}

	public Integer getSumItem() {
		return sumItem;
	}

	public void setSumItem(Integer sumItem) {
		this.sumItem = sumItem;
	}

	public String getSelectedRowIndex() {
		return selectedRowIndex;
	}

	public void setSelectedRowIndex(String selectedRowIndex) {
		this.selectedRowIndex = selectedRowIndex;
	}

	public boolean isExportButtonEnable() {
		return exportButtonEnable;
	}

	public void setExportButtonEnable(boolean exportButtonEnable) {
		this.exportButtonEnable = exportButtonEnable;
	}

	public List<SelectItem> getElectricUseTypeList2() {
		return electricUseTypeList2;
	}

	public void setElectricUseTypeList2(List<SelectItem> electricUseTypeList2) {
		this.electricUseTypeList2 = electricUseTypeList2;
	}

	public List<PrivateDeposit> getPrivateDepositList() {
		return privateDepositList;
	}

	public void setPrivateDepositList(List<PrivateDeposit> privateDepositList) {
		this.privateDepositList = privateDepositList;
	}

	public List<MeterInfo> getMeterInfoList() {
		return meterInfoList;
	}

	public void setMeterInfoList(List<MeterInfo> meterInfoList) {
		this.meterInfoList = meterInfoList;
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

	public List<SelectItem> getFeeCheckAreaList() {
		return feeCheckAreaList;
	}

	public void setFeeCheckAreaList(List<SelectItem> feeCheckAreaList) {
		this.feeCheckAreaList = feeCheckAreaList;
	}

	public List<SelectItem> getExpenseTypeList() {
		return expenseTypeList;
	}

	public void setExpenseTypeList(List<SelectItem> expenseTypeList) {
		this.expenseTypeList = expenseTypeList;
	}

	public String getSelectedIndex() {
		return selectedIndex;
	}

	public void setSelectedIndex(String selectedIndex) {
		this.selectedIndex = selectedIndex;
	}

	public boolean isBtUpdateVisible() {
		return btUpdateVisible;
	}

	public void setBtUpdateVisible(boolean btUpdateVisible) {
		this.btUpdateVisible = btUpdateVisible;
	}

	public boolean isBtSaveVisible() {
		return btSaveVisible;
	}

	public void setBtSaveVisible(boolean btSaveVisible) {
		this.btSaveVisible = btSaveVisible;
	}

	public boolean isFpaymentMethodDisable() {
		return fpaymentMethodDisable;
	}

	public void setFpaymentMethodDisable(boolean fpaymentMethodDisable) {
		this.fpaymentMethodDisable = fpaymentMethodDisable;
	}

	public boolean isFremarkDisable() {
		return fremarkDisable;
	}

	public void setFremarkDisable(boolean fremarkDisable) {
		this.fremarkDisable = fremarkDisable;
	}

	public boolean isFchqPostingDtDisable() {
		return fchqPostingDtDisable;
	}

	public void setFchqPostingDtDisable(boolean fchqPostingDtDisable) {
		this.fchqPostingDtDisable = fchqPostingDtDisable;
	}

	public boolean isFchqReceivedDtDisable() {
		return fchqReceivedDtDisable;
	}

	public void setFchqReceivedDtDisable(boolean fchqReceivedDtDisable) {
		this.fchqReceivedDtDisable = fchqReceivedDtDisable;
	}

	public boolean isFtransferDtDisable() {
		return ftransferDtDisable;
	}

	public void setFtransferDtDisable(boolean ftransferDtDisable) {
		this.ftransferDtDisable = ftransferDtDisable;
	}

	public boolean isFrefDocTypeDisable() {
		return frefDocTypeDisable;
	}

	public void setFrefDocTypeDisable(boolean frefDocTypeDisable) {
		this.frefDocTypeDisable = frefDocTypeDisable;
	}

	public boolean isFrefDocNoDisable() {
		return frefDocNoDisable;
	}

	public void setFrefDocNoDisable(boolean frefDocNoDisable) {
		this.frefDocNoDisable = frefDocNoDisable;
	}

	public boolean isFrefDocDtDisable() {
		return frefDocDtDisable;
	}

	public void setFrefDocDtDisable(boolean frefDocDtDisable) {
		this.frefDocDtDisable = frefDocDtDisable;
	}

	public boolean isFpaymentTypeDisable() {
		return fpaymentTypeDisable;
	}

	public void setFpaymentTypeDisable(boolean fpaymentTypeDisable) {
		this.fpaymentTypeDisable = fpaymentTypeDisable;
	}

	public String getCompanyBigLabel() {
		return companyBigLabel;
	}

	public void setCompanyBigLabel(String companyBigLabel) {
		this.companyBigLabel = companyBigLabel;
	}

	public List<DepositDetail> geteDepositDetailList() {
		return eDepositDetailList;
	}

	public void seteDepositDetailList(List<DepositDetail> eDepositDetailList) {
		this.eDepositDetailList = eDepositDetailList;
	}

	public ManagementWrapper getManageWrapper() {
		return manageWrapper;
	}

	public void setManageWrapper(ManagementWrapper manageWrapper) {
		this.manageWrapper = manageWrapper;
	}

	public List<ManagementWrapper> getPaymentWrapperList() {
		return paymentWrapperList;
	}

	public void setPaymentWrapperList(List<ManagementWrapper> paymentWrapperList) {
		this.paymentWrapperList = paymentWrapperList;
	}

	public String getRemoveItemId() {
		return removeItemId;
	}

	public void setRemoveItemId(String removeItemId) {
		this.removeItemId = removeItemId;
	}

	public void setBgStatusList(List<SelectItem> bgStatusList) {
		this.bgStatusList = bgStatusList;
	}
	
	public String getExpandFlagAlertMessage() {
		return expandFlagAlertMessage;
	}

	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	public List<ManagementWrapper> getManageWrapperList() {
		return manageWrapperList;
	}

	public void setManageWrapperList(List<ManagementWrapper> manageWrapperList) {
		this.manageWrapperList = manageWrapperList;
	}

	public ManagementWrapper getWrapper() {
		return wrapper;
	}

	public void setWrapper(ManagementWrapper wrapper) {
		this.wrapper = wrapper;
	}

	public List<SelectItem> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<SelectItem> provinceList) {
		this.provinceList = provinceList;
	}

	public List<MeterFile> getMeterFileList() {
		return meterFileList;
	}

	public void setMeterFileList(List<MeterFile> meterFileList) {
		this.meterFileList = meterFileList;
	}

	public List<UploadItem> getUploadFileList() {
		return uploadFileList;
	}

	public void setUploadFileList(List<UploadItem> uploadFileList) {
		this.uploadFileList = uploadFileList;
	}

	public void setExpandFlagAlertMessage(String expandFlagAlertMessage) {
		this.expandFlagAlertMessage = expandFlagAlertMessage;
	}

	public String getPrivateCaseFlagAlertMessage() {
		return privateCaseFlagAlertMessage;
	}

	public void setPrivateCaseFlagAlertMessage(String privateCaseFlagAlertMessage) {
		this.privateCaseFlagAlertMessage = privateCaseFlagAlertMessage;
	}

	public List<SelectItem> getDepositTypeList() {
		return depositTypeList;
	}

	public void setDepositTypeList(List<SelectItem> depositTypeList) {
		this.depositTypeList = depositTypeList;
	}

	public String getDepositType() {
		return depositType;
	}

	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}

	public List<SelectItem> getProcessStatusNameList() {
		return processStatusNameList;
	}

	public void setProcessStatusNameList(List<SelectItem> processStatusNameList) {
		this.processStatusNameList = processStatusNameList;
	}

	public List<SelectItem> getElectricUseTypeList() {
		return electricUseTypeList;
	}

	public void setElectricUseTypeList(List<SelectItem> electricUseTypeList) {
		this.electricUseTypeList = electricUseTypeList;
	}

	public boolean isChkSelAll() {
		return chkSelAll;
	}

	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
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
	
	public Management getSearchCriteria() {
		return searchCriteria;
	}
	
	public void setSearchCriteria(Management searchCriteria) {
		this.searchCriteria = searchCriteria;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}


	public Management getManageInfo() {
		return manageInfo;
	}

	public void setManageInfo(Management manageInfo) {
		this.manageInfo = manageInfo;
	}

	public List<Management> getManageInfoList() {
		return manageInfoList;
	}

	public void setManageInfoList(List<Management> manageInfoList) {
		this.manageInfoList = manageInfoList;
	}

	public MeterInfo getMeterInfo() {
		return meterInfo;
	}

	public void setMeterInfo(MeterInfo meterInfo) {
		this.meterInfo = meterInfo;
	}

	public String getPopupMsg() {
		return popupMsg;
	}

	public void setPopupMsg(String popupMsg) {
		this.popupMsg = popupMsg;
	}

	public boolean isBtaddVisible() {
		return btaddVisible;
	}

	public void setBtaddVisible(boolean btaddVisible) {
		this.btaddVisible = btaddVisible;
	}

	public boolean isFbankNameLabelVisible() {
		return fbankNameLabelVisible;
	}

	public void setFbankNameLabelVisible(boolean fbankNameLabelVisible) {
		this.fbankNameLabelVisible = fbankNameLabelVisible;
	}

	public boolean isFbankNameInputVisible() {
		return fbankNameInputVisible;
	}

	public void setFbankNameInputVisible(boolean fbankNameInputVisible) {
		this.fbankNameInputVisible = fbankNameInputVisible;
	}

	public List<SelectItem> getElMeterRateList() {
		return elMeterRateList;
	}

	public void setElMeterRateList(List<SelectItem> elMeterRateList) {
		this.elMeterRateList = elMeterRateList;
	}

	public List<SelectItem> getElMeterTypeList() {
		return elMeterTypeList;
	}

	public void setElMeterTypeList(List<SelectItem> elMeterTypeList) {
		this.elMeterTypeList = elMeterTypeList;
	}

	public List<SelectItem> getElCheckAreaList() {
		return elCheckAreaList;
	}

	public void setElCheckAreaList(List<SelectItem> elCheckAreaList) {
		this.elCheckAreaList = elCheckAreaList;
	}

	public String getManageRowIdEdit() {
		return manageRowIdEdit;
	}

	public void setManageRowIdEdit(String manageRowIdEdit) {
		this.manageRowIdEdit = manageRowIdEdit;
	}

	public List<SelectItem> getElMeterStatusList() {
		return elMeterStatusList;
	}

	public void setElMeterStatusList(List<SelectItem> elMeterStatusList) {
		this.elMeterStatusList = elMeterStatusList;
	}

	public List<MeterInfo> getMeterInfoPrivateList() {
		return meterInfoPrivateList;
	}

	public void setMeterInfoPrivateList(List<MeterInfo> meterInfoPrivateList) {
		this.meterInfoPrivateList = meterInfoPrivateList;
	}

	public boolean isFfeeWbsCodeRequireVisible() {
		return ffeeWbsCodeRequireVisible;
	}
	public List<MeterInfo> getMeterInfoMeaPeaList() {
		return meterInfoMeaPeaList;
	}

	public void setFfeeWbsCodeRequireVisible(boolean ffeeWbsCodeRequireVisible) {
		this.ffeeWbsCodeRequireVisible = ffeeWbsCodeRequireVisible;
	}

	public boolean isFpaymentRemark() {
		return fpaymentRemark;
	}

	public void setFpaymentRemark(boolean fpaymentRemark) {
		this.fpaymentRemark = fpaymentRemark;
	}

	
	
	public void setMeterInfoMeaPeaList(List<MeterInfo> meterInfoMeaPeaList) {
		this.meterInfoMeaPeaList = meterInfoMeaPeaList;
	}

	public List<MeterInfo> getMeterInfoOtherList() {
		return meterInfoOtherList;
	}

	public void setMeterInfoOtherList(List<MeterInfo> meterInfoOtherList) {
		this.meterInfoOtherList = meterInfoOtherList;
	}

	public int getTempIndex() {
		return tempIndex;
	}

	public void setTempIndex(int tempIndex) {
		this.tempIndex = tempIndex;
	}

	public boolean isFexpenseTypeDisable() {
		return fexpenseTypeDisable;
	}

	public void setFexpenseTypeDisable(boolean fexpenseTypeDisable) {
		this.fexpenseTypeDisable = fexpenseTypeDisable;
	}

	public boolean isEditRow() {
		return editRow;
	}

	public void setEditRow(boolean editRow) {
		this.editRow = editRow;
	}

	public String getSelectedMeterId() {
		return selectedMeterId;
	}

	public void setSelectedMeterId(String selectedMeterId) {
		this.selectedMeterId = selectedMeterId;
	}

	public List<SelectItem> getAmphurList() {
		return amphurList;
	}

	public void setAmphurList(List<SelectItem> amphurList) {
		this.amphurList = amphurList;
	}

	public List<ManagementWrapper> getGroupReceiveList() {
		return groupReceiveList;
	}

	public void setGroupReceiveList(List<ManagementWrapper> groupReceiveList) {
		this.groupReceiveList = groupReceiveList;
	}

	public Date getGroupReceiveDt() {
		return groupReceiveDt;
	}

	public void setGroupReceiveDt(Date groupReceiveDt) {
		this.groupReceiveDt = groupReceiveDt;
	}

	public boolean isDisplayGroupReceivePopup() {
		return displayGroupReceivePopup;
	}

	public void setDisplayGroupReceivePopup(boolean displayGroupReceivePopup) {
		this.displayGroupReceivePopup = displayGroupReceivePopup;
	}
	public List<PrivateDeposit> getOldPrivateDepositList() {
		return oldPrivateDepositList;
	}

	public void setOldPrivateDepositList(List<PrivateDeposit> oldPrivateDepositList) {
		this.oldPrivateDepositList = oldPrivateDepositList;
	}

	public boolean isComeFromOtherPage() {
		return isComeFromOtherPage;
	}

	public void setComeFromOtherPage(boolean isComeFromOtherPage) {
		this.isComeFromOtherPage = isComeFromOtherPage;
	}

	public boolean isComeFromVieMeterInfo() {
		return isComeFromVieMeterInfo;
	}

	public void setComeFromVieMeterInfo(boolean isComeFromVieMeterInfo) {
		this.isComeFromVieMeterInfo = isComeFromVieMeterInfo;
	}

	public String getFromPage() {
		return fromPage;
	}

	public void setFromPage(String fromPage) {
		this.fromPage = fromPage;
	}
	
	public boolean isDisableRequireField(){
		boolean booleanReturn = false;
		if("02".equals(manageWrapper.getElectricPayment().getPaymentType())){
			booleanReturn = true;
		}
		
		return booleanReturn;
	}

	public List<PaymentDetail> getOldPaymentDetailList() {
		return oldPaymentDetailList;
	}

	public void setOldPaymentDetailList(List<PaymentDetail> oldPaymentDetailList) {
		this.oldPaymentDetailList = oldPaymentDetailList;
	}

	public String getMeterId() {
		return meterId;
	}

	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}

	public List<VendorMapPayeeEL> getVendorMapPayeeList() {
		return vendorMapPayeeList;
	}

	public void setVendorMapPayeeList(List<VendorMapPayeeEL> vendorMapPayeeList) {
		this.vendorMapPayeeList = vendorMapPayeeList;
	}

	public String getSelectedRadio() {
		return selectedRadio;
	}

	public void setSelectedRadio(String selectedRadio) {
		this.selectedRadio = selectedRadio;
	}

	public VendorMasterSP getCriteriaVendorSP() {
		return criteriaVendorSP;
	}

	public void setCriteriaVendorSP(VendorMasterSP criteriaVendorSP) {
		this.criteriaVendorSP = criteriaVendorSP;
	}

	public Bank getCriteriaBank() {
		return criteriaBank;
	}

	public void setCriteriaBank(Bank criteriaBank) {
		this.criteriaBank = criteriaBank;
	}

	public VendorMaster getVendorMaster() {
		return vendorMaster;
	}

	public void setVendorMaster(VendorMaster vendorMaster) {
		this.vendorMaster = vendorMaster;
	}

	public PayeeMaster getPayeeMaster() {
		return payeeMaster;
	}

	public void setPayeeMaster(PayeeMaster payeeMaster) {
		this.payeeMaster = payeeMaster;
	}

	public CT001SrchMSP getCt001SrchMSP() {
		return ct001SrchMSP;
	}

	public void setCt001SrchMSP(CT001SrchMSP ct001SrchMSP) {
		this.ct001SrchMSP = ct001SrchMSP;
	}

	public VendorBookbank getVendorBookBank() {
		return vendorBookBank;
	}

	public void setVendorBookBank(VendorBookbank vendorBookBank) {
		this.vendorBookBank = vendorBookBank;
	}

	public PayeeBookbank getPayeeBookBank() {
		return payeeBookBank;
	}

	public void setPayeeBookBank(PayeeBookbank payeeBookBank) {
		this.payeeBookBank = payeeBookBank;
	}

	public VendorMapPayee getVendorMapPayee() {
		return vendorMapPayee;
	}

	public void setVendorMapPayee(VendorMapPayee vendorMapPayee) {
		this.vendorMapPayee = vendorMapPayee;
	}

	public List<SelectItem> getVendorStatusSelList() {
		return vendorStatusSelList;
	}

	public void setVendorStatusSelList(List<SelectItem> vendorStatusSelList) {
		this.vendorStatusSelList = vendorStatusSelList;
	}

	public List<SelectItem> getBookbankStatusSelList() {
		return bookbankStatusSelList;
	}

	public void setBookbankStatusSelList(List<SelectItem> bookbankStatusSelList) {
		this.bookbankStatusSelList = bookbankStatusSelList;
	}

	public List<SelectItem> getVendorTypeStatus() {
		return vendorTypeStatus;
	}

	public void setVendorTypeStatus(List<SelectItem> vendorTypeStatus) {
		this.vendorTypeStatus = vendorTypeStatus;
	}

	public List<SelectItem> getProvinceSelList() {
		return provinceSelList;
	}

	public void setProvinceSelList(List<SelectItem> provinceSelList) {
		this.provinceSelList = provinceSelList;
	}

	public List<SelectItem> getAmphurSelList() {
		return amphurSelList;
	}

	public void setAmphurSelList(List<SelectItem> amphurSelList) {
		this.amphurSelList = amphurSelList;
	}

	public List<SelectItem> getExpenseTypeSelList() {
		return expenseTypeSelList;
	}

	public void setExpenseTypeSelList(List<SelectItem> expenseTypeSelList) {
		this.expenseTypeSelList = expenseTypeSelList;
	}

	public List<SelectItem> getBankAccountSelList() {
		return bankAccountSelList;
	}

	public void setBankAccountSelList(List<SelectItem> bankAccountSelList) {
		this.bankAccountSelList = bankAccountSelList;
	}

	public List<WrapperBeanObject<VendorMasterSP>> getVendorMasterList() {
		return vendorMasterList;
	}

	public void setVendorMasterList(
			List<WrapperBeanObject<VendorMasterSP>> vendorMasterList) {
		this.vendorMasterList = vendorMasterList;
	}

	public List<VendorMasterSP> getVendorMasterSelList() {
		return vendorMasterSelList;
	}

	public void setVendorMasterSelList(List<VendorMasterSP> vendorMasterSelList) {
		this.vendorMasterSelList = vendorMasterSelList;
	}

	public List<PayeeMasterSP> getPayeeMasterSelList() {
		return payeeMasterSelList;
	}

	public void setPayeeMasterSelList(List<PayeeMasterSP> payeeMasterSelList) {
		this.payeeMasterSelList = payeeMasterSelList;
	}

	public List<Bank> getBankSelList() {
		return bankSelList;
	}

	public void setBankSelList(List<Bank> bankSelList) {
		this.bankSelList = bankSelList;
	}

	public List<Bank> getBankTmpSelList() {
		return bankTmpSelList;
	}

	public void setBankTmpSelList(List<Bank> bankTmpSelList) {
		this.bankTmpSelList = bankTmpSelList;
	}

	public List<WrapperBeanObject<CT001SrchMSP>> getCt001SrchMSPList() {
		return ct001SrchMSPList;
	}

	public void setCt001SrchMSPList(
			List<WrapperBeanObject<CT001SrchMSP>> ct001SrchMSPList) {
		this.ct001SrchMSPList = ct001SrchMSPList;
	}

	public boolean isRenderedSelectVendorPopup() {
		return renderedSelectVendorPopup;
	}

	public void setRenderedSelectVendorPopup(boolean renderedSelectVendorPopup) {
		this.renderedSelectVendorPopup = renderedSelectVendorPopup;
	}

	public boolean isRenderedSelectPayeePopup() {
		return renderedSelectPayeePopup;
	}

	public void setRenderedSelectPayeePopup(boolean renderedSelectPayeePopup) {
		this.renderedSelectPayeePopup = renderedSelectPayeePopup;
	}

	public boolean isForceInputBankInfo() {
		return isForceInputBankInfo;
	}

	public void setForceInputBankInfo(boolean isForceInputBankInfo) {
		this.isForceInputBankInfo = isForceInputBankInfo;
	}

	public boolean isNewBankInfo() {
		return isNewBankInfo;
	}

	public void setNewBankInfo(boolean isNewBankInfo) {
		this.isNewBankInfo = isNewBankInfo;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getModePanelInfo() {
		return modePanelInfo;
	}

	public void setModePanelInfo(String modePanelInfo) {
		this.modePanelInfo = modePanelInfo;
	}

	public boolean isRenderedRequireIdCard() {
		return renderedRequireIdCard;
	}

	public void setRenderedRequireIdCard(boolean renderedRequireIdCard) {
		this.renderedRequireIdCard = renderedRequireIdCard;
	}

	public boolean isRenderedRequireTaxId() {
		return renderedRequireTaxId;
	}

	public void setRenderedRequireTaxId(boolean renderedRequireTaxId) {
		this.renderedRequireTaxId = renderedRequireTaxId;
	}

	public boolean isDisabledButtonAddAlter() {
		return disabledButtonAddAlter;
	}

	public void setDisabledButtonAddAlter(boolean disabledButtonAddAlter) {
		this.disabledButtonAddAlter = disabledButtonAddAlter;
	}

	public String getTmpVendorMasterId() {
		return tmpVendorMasterId;
	}

	public void setTmpVendorMasterId(String tmpVendorMasterId) {
		this.tmpVendorMasterId = tmpVendorMasterId;
	}

	public int getVendorMapSize() {
		return vendorMapSize;
	}

	public void setVendorMapSize(int vendorMapSize) {
		this.vendorMapSize = vendorMapSize;
	}

	public boolean isVendorExisted() {
		return isVendorExisted;
	}

	public void setVendorExisted(boolean isVendorExisted) {
		this.isVendorExisted = isVendorExisted;
	}

	public boolean isDisbledCheckVendorButton() {
		return disbledCheckVendorButton;
	}

	public void setDisbledCheckVendorButton(boolean disbledCheckVendorButton) {
		this.disbledCheckVendorButton = disbledCheckVendorButton;
	}

	public Bank getNewBank() {
		return newBank;
	}

	public void setNewBank(Bank newBank) {
		this.newBank = newBank;
	}

	public String getTmpLessorId() {
		return tmpLessorId;
	}

	public void setTmpLessorId(String tmpLessorId) {
		this.tmpLessorId = tmpLessorId;
	}

	public boolean ispTaxFlag() {
		return pTaxFlag;
	}

	public void setpTaxFlag(boolean pTaxFlag) {
		this.pTaxFlag = pTaxFlag;
	}

	public boolean isComeFromPage5() {
		return isComeFromPage5;
	}

	public void setComeFromPage5(boolean isComeFromPage5) {
		this.isComeFromPage5 = isComeFromPage5;
	}

	public String getMethodWithNaviFrom() {
		return methodWithNaviFrom;
	}

	public void setMethodWithNaviFrom(String methodWithNaviFrom) {
		this.methodWithNaviFrom = methodWithNaviFrom;
	}

	public boolean isDisplayShowReport() {
		return displayShowReport;
	}

	public void setDisplayShowReport(boolean displayShowReport) {
		this.displayShowReport = displayShowReport;
	}

	public List<SelectItem> getElActionList() {
		return elActionList;
	}

	public void setElActionList(List<SelectItem> elActionList) {
		this.elActionList = elActionList;
	}

	public boolean isDisplayShowPrintButton() {
		return displayShowPrintButton;
	}

	public void setDisplayShowPrintButton(boolean displayShowPrintButton) {
		this.displayShowPrintButton = displayShowPrintButton;
	}

	public String getNavModuleFrom2() {
		return navModuleFrom2;
	}

	public void setNavModuleFrom2(String navModuleFrom2) {
		this.navModuleFrom2 = navModuleFrom2;
	}

	public String getNavProgramFrom2() {
		return navProgramFrom2;
	}

	public void setNavProgramFrom2(String navProgramFrom2) {
		this.navProgramFrom2 = navProgramFrom2;
	}

	public String getActionWithNaviFrom2() {
		return actionWithNaviFrom2;
	}

	public void setActionWithNaviFrom2(String actionWithNaviFrom2) {
		this.actionWithNaviFrom2 = actionWithNaviFrom2;
	}

	public boolean isEditFeePayment() {
		return editFeePayment;
	}

	public void setEditFeePayment(boolean editFeePayment) {
		this.editFeePayment = editFeePayment;
	}

	public boolean isDisableElectricStatus() {
		return disableElectricStatus;
	}

	public void setDisableElectricStatus(boolean disableElectricStatus) {
		this.disableElectricStatus = disableElectricStatus;
	}

	public String getDisableElectricStatusDisplay() {
		return disableElectricStatusDisplay;
	}

	public void setDisableElectricStatusDisplay(String disableElectricStatusDisplay) {
		this.disableElectricStatusDisplay = disableElectricStatusDisplay;
	}

	public String getExportMsg() {
		return exportMsg;
	}

	public void setExportMsg(String exportMsg) {
		this.exportMsg = exportMsg;
	}

	public boolean isDisaplayExport() {
		return disaplayExport;
	}

	public void setDisaplayExport(boolean disaplayExport) {
		this.disaplayExport = disaplayExport;
	}

	public List<SelectItem> getZoneList() {
		return zoneList;
	}

	public void setZoneList(List<SelectItem> zoneList) {
		this.zoneList = zoneList;
	}

	public boolean isDisplayDeleteContractButton() {
		return displayDeleteContractButton;
	}

	public void setDisplayDeleteContractButton(boolean displayDeleteContractButton) {
		this.displayDeleteContractButton = displayDeleteContractButton;
	}

	public String getDeleteMsg() {
		return deleteMsg;
	}

	public void setDeleteMsg(String deleteMsg) {
		this.deleteMsg = deleteMsg;
	}

	public List<Zone> getAllZoneList() {
		return allZoneList;
	}

	public void setAllZoneList(List<Zone> allZoneList) {
		this.allZoneList = allZoneList;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public List<SelectItem> getPeriodTypeList() {
		return periodTypeList;
	}

	public void setPeriodTypeList(List<SelectItem> periodTypeList) {
		this.periodTypeList = periodTypeList;
	}

	public String getPeriodType() {
		return periodType;
	}

	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}

	public boolean isDisablePrivatePaymentType() {
		return disablePrivatePaymentType;
	}

	public void setDisablePrivatePaymentType(boolean disablePrivatePaymentType) {
		this.disablePrivatePaymentType = disablePrivatePaymentType;
	}

	public boolean isDisablePrivatePrePaidPaymentType() {
		return disablePrivatePrePaidPaymentType;
	}

	public void setDisablePrivatePrePaidPaymentType(
			boolean disablePrivatePrePaidPaymentType) {
		this.disablePrivatePrePaidPaymentType = disablePrivatePrePaidPaymentType;
	}

	public boolean isDisableCheckUnitType() {
		return disableCheckUnitType;
	}

	public void setDisableCheckUnitType(boolean disableCheckUnitType) {
		this.disableCheckUnitType = disableCheckUnitType;
	}

	public boolean isDisablePayPerMonth() {
		return disablePayPerMonth;
	}

	public void setDisablePayPerMonth(boolean disablePayPerMonth) {
		this.disablePayPerMonth = disablePayPerMonth;
	}

	public boolean isDisablePayPerYear() {
		return disablePayPerYear;
	}

	public void setDisablePayPerYear(boolean disablePayPerYear) {
		this.disablePayPerYear = disablePayPerYear;
	}



	public Long getPayPeriod03() {
		return payPeriod03;
	}

	public void setPayPeriod03(Long payPeriod03) {
		this.payPeriod03 = payPeriod03;
	}

	public Long getPayPeriod04() {
		return payPeriod04;
	}

	public void setPayPeriod04(Long payPeriod04) {
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

	public boolean isComeFromOtherPage5_5() {
		return isComeFromOtherPage5_5;
	}

	public void setComeFromOtherPage5_5(boolean isComeFromOtherPage5_5) {
		this.isComeFromOtherPage5_5 = isComeFromOtherPage5_5;
	}

	public String getTerminateFlagAlertMessage() {
		return terminateFlagAlertMessage;
	}

	public void setTerminateFlagAlertMessage(String terminateFlagAlertMessage) {
		this.terminateFlagAlertMessage = terminateFlagAlertMessage;
	}

	public String getExportSize() {
		return exportSize;
	}

	public void setExportSize(String exportSize) {
		this.exportSize = exportSize;
	}

	public String getMeterStatus() {
		return meterStatus;
	}

	public void setMeterStatus(String meterStatus) {
		this.meterStatus = meterStatus;
	}

	public String getPrivateSpecailAlertMessage() {
		return privateSpecailAlertMessage;
	}

	public void setPrivateSpecailAlertMessage(String privateSpecailAlertMessage) {
		this.privateSpecailAlertMessage = privateSpecailAlertMessage;
	}

	public List<SelectItem> getElOwnerGroupList() {
		return elOwnerGroupList;
	}

	public void setElOwnerGroupList(List<SelectItem> elOwnerGroupList) {
		this.elOwnerGroupList = elOwnerGroupList;
	}

	public boolean isViewMode() {
		return viewMode;
	}

	public void setViewMode(boolean viewMode) {
		this.viewMode = viewMode;
	}

	public boolean isDisplayReport() {
		return displayReport;
	}

	public void setDisplayReport(boolean displayReport) {
		this.displayReport = displayReport;
	}

	public HashMap<String, String> getMapElId() {
		return mapElId;
	}

	public void setMapElId(HashMap<String, String> mapElId) {
		this.mapElId = mapElId;
	}

	public String getElLongStr() {
		return elLongStr;
	}

	public void setElLongStr(String elLongStr) {
		this.elLongStr = elLongStr;
	}

	public boolean isRenderedELMethod() {
		return renderedELMethod;
	}

	public void setRenderedELMethod(boolean renderedELMethod) {
		this.renderedELMethod = renderedELMethod;
	}

	public boolean isDisableVat() {
		return disableVat;
	}

	public void setDisableVat(boolean disableVat) {
		this.disableVat = disableVat;
	}

	public boolean isRenderedVat() {
		return renderedVat;
	}

	public void setRenderedVat(boolean renderedVat) {
		this.renderedVat = renderedVat;
	}

	public List<ElUseTypeDetailSP> getElUseList() {
		return elUseList;
	}

	public void setElUseList(List<ElUseTypeDetailSP> elUseList) {
		this.elUseList = elUseList;
	}

	public ElUseTypeDetailSP getElUseSp() {
		return elUseSp;
	}

	public void setElUseSp(ElUseTypeDetailSP elUseSp) {
		this.elUseSp = elUseSp;
	}

	public Double getDefaultVatRate() {
		return defaultVatRate;
	}

	public void setDefaultVatRate(Double defaultVatRate) {
		this.defaultVatRate = defaultVatRate;
	}

	public String getElTmpId() {
		return elTmpId;
	}

	public void setElTmpId(String elTmpId) {
		this.elTmpId = elTmpId;
	}

	public String getModeType() {
		return modeType;
	}

	public void setModeType(String modeType) {
		this.modeType = modeType;
	}

	public String getTmpPayPeriodType() {
		return tmpPayPeriodType;
	}

	public void setTmpPayPeriodType(String tmpPayPeriodType) {
		this.tmpPayPeriodType = tmpPayPeriodType;
	}

	public List<ElUseTypeDetailSP> getElHistoryList() {
		return elHistoryList;
	}

	public void setElHistoryList(List<ElUseTypeDetailSP> elHistoryList) {
		this.elHistoryList = elHistoryList;
	}

	public List<Mrt001SrchRentPay> getRentPayList() {
		return rentPayList;
	}

	public void setRentPayList(List<Mrt001SrchRentPay> rentPayList) {
		this.rentPayList = rentPayList;
	}

	public String getRentalMasterId() {
		return rentalMasterId;
	}

	public void setRentalMasterId(String rentalMasterId) {
		this.rentalMasterId = rentalMasterId;
	}

	public boolean isRenderedOnToDoList() {
		return renderedOnToDoList;
	}

	public void setRenderedOnToDoList(boolean renderedOnToDoList) {
		this.renderedOnToDoList = renderedOnToDoList;
	}

	public TreeUtilBean getTreeUtilBean() {
		return treeUtilBean;
	}

	public void setTreeUtilBean(TreeUtilBean treeUtilBean) {
		this.treeUtilBean = treeUtilBean;
	}

	public TreeNode getRootNode() {
		return rootNode;
	}

	public void setRootNode(TreeNode rootNode) {
		this.rootNode = rootNode;
	}

	public boolean isTreeMacroFlag() {
		return treeMacroFlag;
	}

	public void setTreeMacroFlag(boolean treeMacroFlag) {
		this.treeMacroFlag = treeMacroFlag;
	}

	public String getHeaderTreeMacro() {
		return headerTreeMacro;
	}

	public void setHeaderTreeMacro(String headerTreeMacro) {
		this.headerTreeMacro = headerTreeMacro;
	}

	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreeMacroList() {
		return menuTreeMacroList;
	}

	public void setMenuTreeMacroList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreeMacroList) {
		this.menuTreeMacroList = menuTreeMacroList;
	}

	public boolean isTreePicoFlag() {
		return treePicoFlag;
	}

	public void setTreePicoFlag(boolean treePicoFlag) {
		this.treePicoFlag = treePicoFlag;
	}

	public String getHeaderTreePico() {
		return headerTreePico;
	}

	public void setHeaderTreePico(String headerTreePico) {
		this.headerTreePico = headerTreePico;
	}

	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreePicoList() {
		return menuTreePicoList;
	}

	public void setMenuTreePicoList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreePicoList) {
		this.menuTreePicoList = menuTreePicoList;
	}

	public VendorMasterSP getVendorMasterPopupObjParam() {
		if(vendorMasterPopupObjParam == null)
			vendorMasterPopupObjParam = new VendorMasterSP();
		return vendorMasterPopupObjParam;
	}
	public void setVendorMasterPopupObjParam(
			VendorMasterSP vendorMasterPopupObjParam) {
		this.vendorMasterPopupObjParam = vendorMasterPopupObjParam;
	}
	
	public List<WrapperBeanObject<VendorMasterSP>> getVendorMasterPopupList() {
		if(vendorMasterPopupList == null)
			vendorMasterPopupList = new ArrayList<WrapperBeanObject<VendorMasterSP>>();
		return vendorMasterPopupList;
	}
	public void setVendorMasterPopupList(
			List<WrapperBeanObject<VendorMasterSP>> vendorMasterPopupList) {
		this.vendorMasterPopupList = vendorMasterPopupList;
	}

	public PopupSiteSearch getPopupSiteCriteria() {
		return popupSiteCriteria;
	}

	public void setPopupSiteCriteria(PopupSiteSearch popupSiteCriteria) {
		this.popupSiteCriteria = popupSiteCriteria;
	}

	public List<MeterInfoHistory> getMeterHistory() {
		return meterHistory;
	}

	public void setMeterHistory(List<MeterInfoHistory> meterHistory) {
		this.meterHistory = meterHistory;
	}
	
}
