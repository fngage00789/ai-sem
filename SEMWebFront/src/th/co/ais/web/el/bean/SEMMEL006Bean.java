package th.co.ais.web.el.bean;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.el.ElUseTypeDetailSP;
import th.co.ais.domain.el.InstallmentDataDetail;
import th.co.ais.domain.el.InstallmentSearch7;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.ManagementWrapper;
import th.co.ais.domain.el.MeterInfo;
import th.co.ais.domain.el.MeterInstallment;
import th.co.ais.domain.el.Payment;
import th.co.ais.domain.el.PaymentDetail;
import th.co.ais.domain.el.PaymentSearch;
import th.co.ais.domain.el.PopupOldDocSearch;
import th.co.ais.domain.el.PopupOldDocSearch7;
import th.co.ais.domain.el.PopupSiteSearch;
import th.co.ais.domain.el.PopupSiteSearch7;
import th.co.ais.domain.el.PrivatePrepaid;
import th.co.ais.domain.el.ElGroupSP;
import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMEL006Bean extends AbstractBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5024155468436141223L;

	
	// dropdown  EL_EXPENSE_TYPE,EL_DOC_TYPE
	private List<SelectItem> companyList;
	private List<SelectItem> electricUseTypeList;
	private List<SelectItem> elExpenseTypeList;
	private List<SelectItem> elDocTypeList;
	
	
	// CT
	private List<SelectItem> ctPaymentTypeList;
	private List<SelectItem> ctPaymentMethodList;
	

	private List<SelectItem> regionList;
	private List<SelectItem> siteTypeList;
	private List<SelectItem> reqTypeList;
	private List<SelectItem> verifyStatusList;
	private List<SelectItem> vendorTypeList;//WT###Add 20110202
	
	private List<SelectItem> recordStatusList;
	
	private List<SelectItem> vendorIdList;
	
	// Search Main Page
	private PaymentSearch criteria;
	private List  resultList;
	
	private Payment payment;
	private PaymentDetail paymentDetail;
	private List<Payment> paymentList;
	private List<PaymentDetail> paymentDetailList;	
	
	// ***** added by bestnaja *****
	private PaymentDetail paymentDetailMeterInfoSection;
	// *****	
	
	// Not Expense Site
	private PaymentDetail notExpenseSite;
	private List<PaymentDetail> notExpenseSiteList;
	private PaymentDetail specialExpenseSite;
	
	private List<SelectItem> monthList;
	private List<SelectItem> yearList;
	private List<SelectItem> meterIdList;
	
	private String deleteNotExpenseId;
	private int deletePaymentId;
	private boolean disabledBtnExport;
	private boolean viewMode;
	
	private boolean disableMode = true;
	
	
	
	
	private Management management;
	private MeterInfo meterInfo;
	private Payment elPostpaidPayment;	
	private Payment meterPayment;
	private String expenseType;
	
	// Popup
	
	private PopupSiteSearch popupSiteCriteria;
	private List<PopupSiteSearch> popupSiteList;
	private List <Management> managePopUpSearchResult;
	private Management managementPopUpCriteria;	
	
	private PopupOldDocSearch popupOldDocCriteria;
	private List<PopupOldDocSearch> popupOldDocList;
	private List<PopupOldDocSearch7> popupOldDoc7List;
	
	private List<MeterInstallment> installmentSearchResult;
	
	public List<PrivatePrepaid> getPrivatePrepaidResult() {
		return privatePrepaidResult;
	}
	public void setPrivatePrepaidResult(List<PrivatePrepaid> privatePrepaidResult) {
		this.privatePrepaidResult = privatePrepaidResult;
	}
	private List<PrivatePrepaid> privatePrepaidResult;

	private String searchDisplayMode;	
	private String selectedRadio = "";
	
	
	private boolean bankNameMandatory;
	private boolean bankAccountMandatory;
	private boolean refDocNoMandatory;
	
	private boolean chqPostingDtDisable;
	private boolean chqReceivedDtDisable;
	private boolean transferDtDisable;

	private boolean addNewSiteDisable;
	private boolean savePopupSiteDisable;
	private boolean elExpentypeDisable;

	private boolean savePopupOldDocDisable;	
	private String confirmDeleteMsg;
	private boolean transferDtMandatory;
	
	//  Payment Disable  
    private boolean expenseTypeDisable;
    private boolean docTypeDisable;
    private boolean docNoDisable;
    private boolean docDtDisable;
	private boolean refDocNoDisable;
	private boolean refDocDtDisable;
    private boolean vendorIdDisable;
    private boolean vendorNameDisable;
    private boolean payeeIdDisable;
    private boolean payeeNameDisable;
    private boolean paymentTypeDisable;
    private boolean paymentMethodDisable;
    private boolean bankNameDisable;
    private boolean bankAccountDisable;
    private boolean remarkDisable;
    private boolean  meterIdDisable;
  
    
//  Payment Detail Disable  
    private boolean whtRateDisable; 
    private boolean whtTypeMandatory; 
    private boolean whtTypeDisable;
    private boolean whtAmtDisable; 
    private boolean whtAmtMandatory; 
    
    private boolean  paymentTypeMandatory;
    private boolean  paymentMethodMandatory;
    
    private boolean  vatAmtDisable;
    
    private BigDecimal previosVatAmt;
    private BigDecimal previosWhtAmt;
    private String popupMsg;	
    private String popupDelMsg;
    private String popupEditMsg;
    
    private String removeItemId;
    private String editItemId;
    
    private boolean disableAddModelButton;
    private boolean disableUpdateModelButton;
    //WT###Add 20110127 Start
    private boolean disableTermOfPaymentDtMonth;
    private boolean disableTermOfPaymentDtYear;
    private boolean disableSearchSite;
    //WT###Add 20110127 End
    //WT###Add 20110202 Start
    private boolean disableViewExpenseHisButton;
    private boolean disableViewMeterInfoButton;
    //WT###Add 20110202 End
    
    private boolean disableMoreThanOneDetail;
    
    private boolean chkSelAll;
    private boolean disableFromTermOfPaymentDt;
    private boolean disableToTermOfPaymentDt;
    
    //WT###Add 20110112 Start
    private boolean isComeFromPage8;
    private boolean isComeFromPage9;
    private boolean isFromAction;
    private boolean isComeFromPage7;
    private boolean isComeFromOtherPage;
    private List<PaymentDetail> deletedPaymentDetailList = new ArrayList<PaymentDetail>(0);
    //WT###Add 20110112 End    
    //WT###Add 20110203 Start
    private boolean disableVendorTypeButton;
    private boolean oldPaymentMethodDisableTypeV;
    private boolean oldPaymentMethodDisableTypeS;
    //WT###Add 20110203 End
    //WT###Add 20110207 Start
    private boolean disableInvTotalVat;
    private boolean displayPopupNotExpenseSite = true;
    //WT###Add 20110207 End
    String methodWithNaviFrom;//WT###Add 20110216
    private InstallmentSearch7 installment;
    private List<InstallmentSearch7> installmentSearch7lList;
    private String meterInstallmentId;
    private InstallmentSearch7 installmentEdit;
    // Add new 20110218
    private String navModuleFrom;
    private String navProgramFrom;
    private String actionWithNaviFrom;    
    private List<SelectItem>  crBankNameList;
    
    
    private boolean creditFlagDisable;
    private boolean payInFlagDisable;
    private boolean isSave;
    private PopupSiteSearch7 popupSiteSearch7;
    private List<PopupSiteSearch7> popupSite7List;
    private PopupOldDocSearch7 popupOldDocCriteria7;
    private int    notExpenseSiteListSize = 0;
    private boolean hidePopup;
    
    private boolean renderPage7;
    private boolean disablePage7;
    //
    private boolean disableValidateELPostPaidPaymentDetail = false;
    private InstallmentDataDetail installmentDataDetail;
    
    private boolean editPrivateTermOfPayment = false;
    
	private List<ManagementWrapper> paymentHistoryWrapperList = new ArrayList();
	
	private boolean byPassValidationELTempTermOfPayment = true;
	
	private boolean disableBtnPercent = true;
	private boolean disableBtnElGroup = true;
	private ElGroupSP elGroupSP;
	private List<ElGroupSP> elGroupSPList;
	private ElUseTypeDetailSP elUseType;
	private List<ElUseTypeDetailSP> elUseTypeList; 
	private String pageFrom;
	
	//added by NEW 2015/12/04
	private VendorMasterSP vendorMasterPopupObjParam;
	private String styleClassName = "ms7";
	public List<WrapperBeanObject<VendorMasterSP>> vendorMasterPopupList;
	
	public PaymentDetail getPaymentDetailMeterInfoSection() {
		return paymentDetailMeterInfoSection;
	}
	public void setPaymentDetailMeterInfoSection(
			PaymentDetail paymentDetailMeterInfoSection) {
		this.paymentDetailMeterInfoSection = paymentDetailMeterInfoSection;
	}
	public boolean isChkSelAll() {
		return chkSelAll;
	}
	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public List<SelectItem> getMeterIdList() {
		return meterIdList;
	}
	public void setMeterIdList(List<SelectItem> meterIdList) {
		this.meterIdList = meterIdList;
	}
	public boolean isDisableMoreThanOneDetail() {
		//WT###Add 20110131 Start
		if(!isComeFromOtherPage){
			if(paymentDetailList==null||paymentDetailList.size()<=0){
				//semmel006Bean.setDisableMoreThanOneDetail(false);
				disableMoreThanOneDetail = false;
			}else{
				//semmel006Bean.setDisableMoreThanOneDetail(true);
				disableMoreThanOneDetail = true;
			}
		}		
		//WT###Add 20110131 End
		return disableMoreThanOneDetail;
	}
	public void setDisableMoreThanOneDetail(boolean disableMoreThanOneDetail) {
		this.disableMoreThanOneDetail = disableMoreThanOneDetail;
	}
	public List<MeterInstallment> getInstallmentSearchResult() {
		return installmentSearchResult;
	}
	public void setInstallmentSearchResult(
			List<MeterInstallment> installmentSearchResult) {
		this.installmentSearchResult = installmentSearchResult;
	}
	
	public boolean isDisableAddModelButton() {
		return disableAddModelButton;
	}
	public void setDisableAddModelButton(boolean disableAddModelButton) {
		this.disableAddModelButton = disableAddModelButton;
	}
	public boolean isDisableUpdateModelButton() {
		return disableUpdateModelButton;
	}
	public void setDisableUpdateModelButton(boolean disableUpdateModelButton) {
		this.disableUpdateModelButton = disableUpdateModelButton;
	}
	public String getPopupDelMsg() {
		return popupDelMsg;
	}
	public void setPopupDelMsg(String popupDelMsg) {
		this.popupDelMsg = popupDelMsg;
	}
	public String getPopupEditMsg() {
		return popupEditMsg;
	}
	public void setPopupEditMsg(String popupEditMsg) {
		this.popupEditMsg = popupEditMsg;
	}
	public String getEditItemId() {
		return editItemId;
	}
	public void setEditItemId(String editItemId) {
		this.editItemId = editItemId;
	}
	public String getRemoveItemId() {
		return removeItemId;
	}
	public void setRemoveItemId(String removeItemId) {
		this.removeItemId = removeItemId;
	}
	public String getPopupMsg() {
		return popupMsg;
	}
	public void setPopupMsg(String popupMsg) {
		this.popupMsg = popupMsg;
	}
	public String getConfirmDeleteMsg() {
		return confirmDeleteMsg;
	}
	public void setConfirmDeleteMsg(String confirmDeleteMsg) {
		this.confirmDeleteMsg = confirmDeleteMsg;
	}
	public int getDeletePaymentId() {
		return deletePaymentId;
	}
	public void setDeletePaymentId(int deletePaymentId) {
		this.deletePaymentId = deletePaymentId;
	}
	public boolean isSavePopupOldDocDisable() {
		return savePopupOldDocDisable;
	}
	public void setSavePopupOldDocDisable(boolean savePopupOldDocDisable) {
		this.savePopupOldDocDisable = savePopupOldDocDisable;
	}
	public boolean isRefDocDtDisable() {
		return refDocDtDisable;
	}
	public void setRefDocDtDisable(boolean refDocDtDisable) {
		this.refDocDtDisable = refDocDtDisable;
	}
	public boolean isRefDocNoMandatory() {
		return refDocNoMandatory;
	}
	public void setRefDocNoMandatory(boolean refDocNoMandatory) {
		this.refDocNoMandatory = refDocNoMandatory;
	}
	public boolean isRefDocNoDisable() {
		return refDocNoDisable;
	}
	public void setRefDocNoDisable(boolean refDocNoDisable) {
		this.refDocNoDisable = refDocNoDisable;
	}
	public boolean isElExpentypeDisable() {
		return elExpentypeDisable;
	}
	public void setElExpentypeDisable(boolean elExpentypeDisable) {
		this.elExpentypeDisable = elExpentypeDisable;
	}
	public boolean isSavePopupSiteDisable() {
		return savePopupSiteDisable;
	}
	public void setSavePopupSiteDisable(boolean savePopupSiteDisable) {
		this.savePopupSiteDisable = savePopupSiteDisable;
	}
	public boolean isAddNewSiteDisable() {
		return addNewSiteDisable;
	}
	public void setAddNewSiteDisable(boolean addNewSiteDisable) {
		this.addNewSiteDisable = addNewSiteDisable;
	}
	public List<SelectItem> getMonthList() {
		return monthList;
	}
	public void setMonthList(List<SelectItem> monthList) {
		this.monthList = monthList;
	}
	public List<SelectItem> getYearList() {
		return yearList;
	}
	public void setYearList(List<SelectItem> yearList) {
		this.yearList = yearList;
	}
	public boolean isChqPostingDtDisable() {
		return chqPostingDtDisable;
	}
	public void setChqPostingDtDisable(boolean chqPostingDtDisable) {
		this.chqPostingDtDisable = chqPostingDtDisable;
	}
	public boolean isChqReceivedDtDisable() {
		return chqReceivedDtDisable;
	}
	public void setChqReceivedDtDisable(boolean chqReceivedDtDisable) {
		this.chqReceivedDtDisable = chqReceivedDtDisable;
	}
	public boolean isTransferDtDisable() {
		return transferDtDisable;
	}
	public void setTransferDtDisable(boolean transferDtDisable) {
		this.transferDtDisable = transferDtDisable;
	}

	public boolean isBankNameMandatory() {
		return bankNameMandatory;
	}
	public void setBankNameMandatory(boolean bankNameMandatory) {
		this.bankNameMandatory = bankNameMandatory;
	}
	public boolean isBankAccountMandatory() {
		return bankAccountMandatory;
	}
	public void setBankAccountMandatory(boolean bankAccountMandatory) {
		this.bankAccountMandatory = bankAccountMandatory;
	}
	public boolean isPaymentMethodDisable() {
		return paymentMethodDisable;
	}
	public void setPaymentMethodDisable(boolean paymentMethodDisable) {
		this.paymentMethodDisable = paymentMethodDisable;
	}
	public boolean isDisabledBtnExport() {
		return disabledBtnExport;
	}
	public void setDisabledBtnExport(boolean disabledBtnExport) {
		this.disabledBtnExport = disabledBtnExport;
	}
	public PaymentDetail getNotExpenseSite() {
		return notExpenseSite;
	}
	public void setNotExpenseSite(PaymentDetail notExpenseSite) {
		this.notExpenseSite = notExpenseSite;
	}
	public List<PaymentDetail> getNotExpenseSiteList() {
		return notExpenseSiteList;
	}
	public void setNotExpenseSiteList(List<PaymentDetail> notExpenseSiteList) {
		this.notExpenseSiteList = notExpenseSiteList;
	}
	public List<SelectItem> getCtPaymentMethodList() {
		return ctPaymentMethodList;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public PaymentDetail getPaymentDetail() {
		return paymentDetail;
	}
	public void setPaymentDetail(PaymentDetail paymentDetail) {
		this.paymentDetail = paymentDetail;
	}
	public List<SelectItem> getElectricUseTypeList() {
		return electricUseTypeList;
	}
	public void setElectricUseTypeList(List<SelectItem> electricUseTypeList) {
		this.electricUseTypeList = electricUseTypeList;
	}

	public PopupOldDocSearch getPopupOldDocCriteria() {
		return popupOldDocCriteria;
	}
	public void setPopupOldDocCriteria(PopupOldDocSearch popupOldDocCriteria) {
		this.popupOldDocCriteria = popupOldDocCriteria;
	}
	public List<PopupOldDocSearch> getPopupOldDocList() {
		return popupOldDocList;
	}
	public void setPopupOldDocList(List<PopupOldDocSearch> popupOldDocList) {
		this.popupOldDocList = popupOldDocList;
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
	public List<SelectItem> getSiteTypeList() {
		return siteTypeList;
	}
	public void setSiteTypeList(List<SelectItem> siteTypeList) {
		this.siteTypeList = siteTypeList;
	}
	public List<SelectItem> getReqTypeList() {
		return reqTypeList;
	}
	public void setReqTypeList(List<SelectItem> reqTypeList) {
		this.reqTypeList = reqTypeList;
	}
	public List<SelectItem> getVerifyStatusList() {
		return verifyStatusList;
	}
	public void setVerifyStatusList(List<SelectItem> verifyStatusList) {
		this.verifyStatusList = verifyStatusList;
	}

	public PopupSiteSearch getPopupSiteCriteria() {
		return popupSiteCriteria;
	}
	public void setPopupSiteCriteria(PopupSiteSearch popupSiteCriteria) {
		this.popupSiteCriteria = popupSiteCriteria;
	}
	public Payment getElPostpaidPayment() {
		return elPostpaidPayment;
	}
	public void setElPostpaidPayment(Payment elPostpaidPayment) {
		this.elPostpaidPayment = elPostpaidPayment;
	}
	public MeterInfo getMeterInfo() {
		return meterInfo;
	}
	public void setMeterInfo(MeterInfo meterInfo) {
		this.meterInfo = meterInfo;
	}
	public String getDeleteNotExpenseId() {
		return deleteNotExpenseId;
	}
	public void setDeleteNotExpenseId(String deleteNotExpenseId) {
		this.deleteNotExpenseId = deleteNotExpenseId;
	}
	public List<PaymentDetail> getPaymentDetailList() {
		return paymentDetailList;
	}
	public void setPaymentDetailList(List<PaymentDetail> paymentDetailList) {
		this.paymentDetailList = paymentDetailList;
	}
	public List<SelectItem> getCtPaymentTypeList() {
		return ctPaymentTypeList;
	}
	public void setCtPaymentTypeList(List<SelectItem> ctPaymentTypeList) {
		this.ctPaymentTypeList = ctPaymentTypeList;
	}
	public List<SelectItem> paymentMethod() {
		return ctPaymentMethodList;
	}
	public void setCtPaymentMethodList(List<SelectItem> ctPaymentMethodList) {
		this.ctPaymentMethodList = ctPaymentMethodList;
	}
	public List<SelectItem> getElExpenseTypeList() {
		return elExpenseTypeList;
	}
	public void setElExpenseTypeList(List<SelectItem> elExpenseTypeList) {
		this.elExpenseTypeList = elExpenseTypeList;
	}
	public List<SelectItem> getElDocTypeList() {
		return elDocTypeList;
	}
	public void setElDocTypeList(List<SelectItem> elDocTypeList) {
		this.elDocTypeList = elDocTypeList;
	}



	public List<Payment> getPaymentList() {
		return paymentList;
	}
	public void setPaymentList(List<Payment> paymentList) {
		this.paymentList = paymentList;
	}

	public List getResultList() {
		return resultList;
	}
	public void setResultList(List resultList) {
		this.resultList = resultList;
	}
	public String getSelectedRadio() {
		return selectedRadio;
	}
	public void setSelectedRadio(String selectedRadio) {
		this.selectedRadio = selectedRadio;
	}
	public PaymentSearch getCriteria() {
		return criteria;
	}
	public void setCriteria(PaymentSearch criteria) {
		this.criteria = criteria;
	}
	public List<PopupSiteSearch> getPopupSiteList() {
		return popupSiteList;
	}
	public void setPopupSiteList(List<PopupSiteSearch> popupSiteList) {
		this.popupSiteList = popupSiteList;
	}

	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public Management getManagement() {
		return management;
	}
	public void setManagement(Management management) {
		this.management = management;
	}
	public String getSearchDisplayMode() {
		return searchDisplayMode;
	}
	public void setSearchDisplayMode(String searchDisplayMode) {
		this.searchDisplayMode = searchDisplayMode;
	}
	public List<SelectItem> getRecordStatusList() {
		return recordStatusList;
	}
	public void setRecordStatusList(List<SelectItem> recordStatusList) {
		this.recordStatusList = recordStatusList;
	}
	public List<Management> getManagePopUpSearchResult() {
		return managePopUpSearchResult;
	}
	public void setManagePopUpSearchResult(List<Management> managePopUpSearchResult) {
		this.managePopUpSearchResult = managePopUpSearchResult;
	}
	public Management getManagementPopUpCriteria() {
		return managementPopUpCriteria;
	}
	public void setManagementPopUpCriteria(Management managementPopUpCriteria) {
		this.managementPopUpCriteria = managementPopUpCriteria;
	}
	public boolean isExpenseTypeDisable() {
		return expenseTypeDisable;
	}
	public void setExpenseTypeDisable(boolean expenseTypeDisable) {
		this.expenseTypeDisable = expenseTypeDisable;
	}
	public boolean isDocTypeDisable() {
		return docTypeDisable;
	}
	public void setDocTypeDisable(boolean docTypeDisable) {
		this.docTypeDisable = docTypeDisable;
	}
	public boolean isDocNoDisable() {
		return docNoDisable;
	}
	public void setDocNoDisable(boolean docNoDisable) {
		this.docNoDisable = docNoDisable;
	}
	public boolean isDocDtDisable() {
		return docDtDisable;
	}
	public void setDocDtDisable(boolean docDtDisable) {
		this.docDtDisable = docDtDisable;
	}
	public boolean isVendorIdDisable() {
		return vendorIdDisable;
	}
	public void setVendorIdDisable(boolean vendorIdDisable) {
		this.vendorIdDisable = vendorIdDisable;
	}
	public boolean isVendorNameDisable() {
		return vendorNameDisable;
	}
	public void setVendorNameDisable(boolean vendorNameDisable) {
		this.vendorNameDisable = vendorNameDisable;
	}
	public boolean isPayeeIdDisable() {
		return payeeIdDisable;
	}
	public void setPayeeIdDisable(boolean payeeIdDisable) {
		this.payeeIdDisable = payeeIdDisable;
	}
	public boolean isPayeeNameDisable() {
		return payeeNameDisable;
	}
	public void setPayeeNameDisable(boolean payeeNameDisable) {
		this.payeeNameDisable = payeeNameDisable;
	}

	public boolean isBankNameDisable() {
		return bankNameDisable;
	}
	public void setBankNameDisable(boolean bankNameDisable) {
		this.bankNameDisable = bankNameDisable;
	}
	public boolean isBankAccountDisable() {
		return bankAccountDisable;
	}
	public void setBankAccountDisable(boolean bankAccountDisable) {
		this.bankAccountDisable = bankAccountDisable;
	}
	public boolean isRemarkDisable() {
		return remarkDisable;
	}
	public void setRemarkDisable(boolean remarkDisable) {
		this.remarkDisable = remarkDisable;
	}
	public boolean isPaymentTypeDisable() {
		return paymentTypeDisable;
	}
	public void setPaymentTypeDisable(boolean paymentTypeDisable) {
		this.paymentTypeDisable = paymentTypeDisable;
	}
	public boolean isViewMode() {
		return viewMode;
	}
	public void setViewMode(boolean viewMode) {
		this.viewMode = viewMode;
	}
	public List<ManagementWrapper> getPaymentHistoryWrapperList() {
		return paymentHistoryWrapperList;
	}
	public void setPaymentHistoryWrapperList(
			List<ManagementWrapper> paymentHistoryWrapperList) {
		this.paymentHistoryWrapperList = paymentHistoryWrapperList;
	}
	public boolean isWhtRateDisable() {
		return whtRateDisable;
	}
	public void setWhtRateDisable(boolean whtRateDisable) {
		this.whtRateDisable = whtRateDisable;
	}
	public boolean isWhtTypeMandatory() {
		return whtTypeMandatory;
	}
	public void setWhtTypeMandatory(boolean whtTypeMandatory) {
		this.whtTypeMandatory = whtTypeMandatory;
	}
	public boolean isWhtAmtDisable() {
		return whtAmtDisable;
	}
	public void setWhtAmtDisable(boolean whtAmtDisable) {
		this.whtAmtDisable = whtAmtDisable;
	}
	public boolean isWhtAmtMandatory() {
		return whtAmtMandatory;
	}
	public void setWhtAmtMandatory(boolean whtAmtMandatory) {
		this.whtAmtMandatory = whtAmtMandatory;
	}
	public boolean isWhtTypeDisable() {
		return whtTypeDisable;
	}
	public void setWhtTypeDisable(boolean whtTypeDisable) {
		this.whtTypeDisable = whtTypeDisable;
	}
	public boolean isVatAmtDisable() {
		return vatAmtDisable;
	}
	public void setVatAmtDisable(boolean vatAmtDisable) {
		this.vatAmtDisable = vatAmtDisable;
	}
	public boolean isPaymentTypeMandatory() {
		return paymentTypeMandatory;
	}
	public void setPaymentTypeMandatory(boolean paymentTypeMandatory) {
		this.paymentTypeMandatory = paymentTypeMandatory;
	}
	public BigDecimal getPreviosVatAmt() {
		return previosVatAmt;
	}
	public void setPreviosVatAmt(BigDecimal previosVatAmt) {
		this.previosVatAmt = previosVatAmt;
	}
	public boolean isTransferDtMandatory() {
		return transferDtMandatory;
	}
	public void setTransferDtMandatory(boolean transferDtMandatory) {
		this.transferDtMandatory = transferDtMandatory;
	}
	public BigDecimal getPreviosWhtAmt() {
		return previosWhtAmt;
	}
	public void setPreviosWhtAmt(BigDecimal previosWhtAmt) {
		this.previosWhtAmt = previosWhtAmt;
	}
	public boolean isMeterIdDisable() {
		return meterIdDisable;
	}
	public void setMeterIdDisable(boolean meterIdDisable) {
		this.meterIdDisable = meterIdDisable;
	}
	public boolean isPaymentMethodMandatory() {
		return paymentMethodMandatory;
	}
	public void setPaymentMethodMandatory(boolean paymentMethodMandatory) {
		this.paymentMethodMandatory = paymentMethodMandatory;
	}
	public boolean isComeFromPage8() {
		return isComeFromPage8;
	}
	public void setComeFromPage8(boolean isComeFromPage8) {
		this.isComeFromPage8 = isComeFromPage8;
		this.isComeFromOtherPage = true;
	}	
	public boolean isComeFromPage7() {
		return isComeFromPage7;
	}
	public void setComeFromPage7(boolean isComeFromPage7) {
		this.isComeFromPage7 = isComeFromPage7;
		this.isComeFromOtherPage = true;
	}
	public List<PaymentDetail> getDeletedPaymentDetailList() {
		return deletedPaymentDetailList;
	}
	public void setDeletedPaymentDetailList(
			List<PaymentDetail> deletedPaymentDetailList) {
		this.deletedPaymentDetailList = deletedPaymentDetailList;
	}
	public boolean isComeFromOtherPage() {
		return isComeFromOtherPage;
	}
	public void setComeFromOtherPage(boolean isComeFromOtherPage) {
		this.isComeFromOtherPage = isComeFromOtherPage;
	}
	public boolean isDisableFromTermOfPaymentDt() {
		return disableFromTermOfPaymentDt;
	}
	public void setDisableFromTermOfPaymentDt(boolean disableFromTermOfPaymentDt) {
		this.disableFromTermOfPaymentDt = disableFromTermOfPaymentDt;
	}
	public boolean isDisableToTermOfPaymentDt() {
		return disableToTermOfPaymentDt;
	}
	public void setDisableToTermOfPaymentDt(boolean disableToTermOfPaymentDt) {
		this.disableToTermOfPaymentDt = disableToTermOfPaymentDt;
	}
	public boolean isDisableTermOfPaymentDtMonth() {
		return disableTermOfPaymentDtMonth;
	}
	public void setDisableTermOfPaymentDtMonth(boolean disableTermOfPaymentDtMonth) {
		this.disableTermOfPaymentDtMonth = disableTermOfPaymentDtMonth;
	}
	public boolean isDisableTermOfPaymentDtYear() {
		return disableTermOfPaymentDtYear;
	}
	public void setDisableTermOfPaymentDtYear(boolean disableTermOfPaymentDtYear) {
		this.disableTermOfPaymentDtYear = disableTermOfPaymentDtYear;
	}
	public boolean isDisableSearchSite() {
		return disableSearchSite;
	}
	public void setDisableSearchSite(boolean disableSearchSite) {
		this.disableSearchSite = disableSearchSite;
	}
	public boolean isDisableViewExpenseHisButton() {
		return disableViewExpenseHisButton;
	}
	public void setDisableViewExpenseHisButton(boolean disableViewExpenseHisButton) {
		this.disableViewExpenseHisButton = disableViewExpenseHisButton;
	}
	public boolean isDisableViewMeterInfoButton() {
		return disableViewMeterInfoButton;
	}
	public void setDisableViewMeterInfoButton(boolean disableViewMeterInfoButton) {
		this.disableViewMeterInfoButton = disableViewMeterInfoButton;
	}
	public List<SelectItem> getVendorTypeList() {
		return vendorTypeList;
	}
	public void setVendorTypeList(List<SelectItem> vendorTypeList) {
		this.vendorTypeList = vendorTypeList;
	}
    
	public boolean isDisableMode() {
		return disableMode;
	}
	public void setDisableMode(boolean disableMode) {
		this.disableMode = true;
	}
	public boolean isDisableVendorTypeButton() {
		return disableVendorTypeButton;
	}
	public void setDisableVendorTypeButton(boolean disableVendorTypeButton) {
		this.disableVendorTypeButton = disableVendorTypeButton;
	}
	public boolean isOldPaymentMethodDisableTypeV() {
		return oldPaymentMethodDisableTypeV;
	}
	public void setOldPaymentMethodDisableTypeV(boolean oldPaymentMethodDisableTypeV) {
		this.oldPaymentMethodDisableTypeV = oldPaymentMethodDisableTypeV;
	}
	public boolean isOldPaymentMethodDisableTypeS() {
		return oldPaymentMethodDisableTypeS;
	}
	public void setOldPaymentMethodDisableTypeS(boolean oldPaymentMethodDisableTypeS) {
		this.oldPaymentMethodDisableTypeS = oldPaymentMethodDisableTypeS;
	}
	public boolean isDisableInvTotalVat() {
		return disableInvTotalVat;
	}
	public void setDisableInvTotalVat(boolean disableInvTotalVat) {
		this.disableInvTotalVat = disableInvTotalVat;
	}
	public boolean isMorethanOneNotExpenseSite(){
		if(this.notExpenseSiteList!=null && this.notExpenseSiteList.size()>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean isDisplayPopupNotExpenseSite() {
		return displayPopupNotExpenseSite;
	}
	public void setDisplayPopupNotExpenseSite(boolean displayPopupNotExpenseSite) {
		this.displayPopupNotExpenseSite = displayPopupNotExpenseSite;
	}
	public PaymentDetail getSpecialExpenseSite() {
		return specialExpenseSite;
	}
	public void setSpecialExpenseSite(PaymentDetail specialExpenseSite) {
		this.specialExpenseSite = specialExpenseSite;
	}
	public String getMethodWithNaviFrom() {
		return methodWithNaviFrom;
	}
	public void setMethodWithNaviFrom(String methodWithNaviFrom) {
		this.methodWithNaviFrom = methodWithNaviFrom;
	}
	public String getNavModuleFrom() {
		return navModuleFrom;
	}
	public void setNavModuleFrom(String navModuleFrom) {
		this.navModuleFrom = navModuleFrom;
	}
	public String getNavProgramFrom() {
		return navProgramFrom;
	}
	public void setNavProgramFrom(String navProgramFrom) {
		this.navProgramFrom = navProgramFrom;
	}
	public String getActionWithNaviFrom() {
		return actionWithNaviFrom;
	}
	public void setActionWithNaviFrom(String actionWithNaviFrom) {
		this.actionWithNaviFrom = actionWithNaviFrom;
	}
	public List<SelectItem> getCrBankNameList() {
		return crBankNameList;
	}
	public void setCrBankNameList(List<SelectItem> crBankNameList) {
		this.crBankNameList = crBankNameList;
	}
	public boolean isCreditFlagDisable() {
		return creditFlagDisable;
	}
	public void setCreditFlagDisable(boolean creditFlagDisable) {
		this.creditFlagDisable = creditFlagDisable;
	}
	public boolean isPayInFlagDisable() {
		return payInFlagDisable;
	}
	public void setPayInFlagDisable(boolean payInFlagDisable) {
		this.payInFlagDisable = payInFlagDisable;
	}
	public boolean isFromAction() {
		return isFromAction;
	}
	public void setFromAction(boolean isFromAction) {
		this.isFromAction = isFromAction;
	}
	public boolean isSave() {
		return isSave;
	}
	public void setSave(boolean isSave) {
		this.isSave = isSave;
	}
	public PopupSiteSearch7 getPopupSiteSearch7() {
		return popupSiteSearch7;
	}
	public void setPopupSiteSearch7(PopupSiteSearch7 popupSiteSearch7) {
		this.popupSiteSearch7 = popupSiteSearch7;
	}
	public List<PopupSiteSearch7> getPopupSite7List() {
		return popupSite7List;
	}
	public void setPopupSite7List(List<PopupSiteSearch7> popupSite7List) {
		this.popupSite7List = popupSite7List;
	}
	public PopupOldDocSearch7 getPopupOldDocCriteria7() {
		return popupOldDocCriteria7;
	}
	public void setPopupOldDocCriteria7(PopupOldDocSearch7 popupOldDocCriteria7) {
		this.popupOldDocCriteria7 = popupOldDocCriteria7;
	}
	public int getNotExpenseSiteListSize() {
		return notExpenseSiteListSize;
	}
	public void setNotExpenseSiteListSize(int notExpenseSiteListSize) {
		this.notExpenseSiteListSize = notExpenseSiteListSize;
	}
	public List<PopupOldDocSearch7> getPopupOldDoc7List() {
		return popupOldDoc7List;
	}
	public void setPopupOldDoc7List(List<PopupOldDocSearch7> popupOldDoc7List) {
		this.popupOldDoc7List = popupOldDoc7List;
	}
	public boolean isHidePopup() {
		return hidePopup;
	}
	public void setHidePopup(boolean hidePopup) {
		this.hidePopup = hidePopup;
	}
	public boolean isRenderPage7() {
		return renderPage7;
	}
	public void setRenderPage7(boolean renderPage7) {
		this.renderPage7 = renderPage7;
	}
	public boolean isDisablePage7() {
		return disablePage7;
	}
	public void setDisablePage7(boolean disablePage7) {
		this.disablePage7 = disablePage7;
	}
	public boolean isDisableValidateELPostPaidPaymentDetail() {
		return disableValidateELPostPaidPaymentDetail;
	}
	public void setDisableValidateELPostPaidPaymentDetail(
			boolean disableValidateELPostPaidPaymentDetail) {
		this.disableValidateELPostPaidPaymentDetail = disableValidateELPostPaidPaymentDetail;
	}
	public InstallmentDataDetail getInstallmentDataDetail() {
		return installmentDataDetail;
	}
	public void setInstallmentDataDetail(InstallmentDataDetail installmentDataDetail) {
		this.installmentDataDetail = installmentDataDetail;
	}
	public boolean isEditPrivateTermOfPayment() {
		return editPrivateTermOfPayment;
	}
	public void setEditPrivateTermOfPayment(boolean editPrivateTermOfPayment) {
		this.editPrivateTermOfPayment = editPrivateTermOfPayment;
	}
	public boolean isByPassValidationELTempTermOfPayment() {
		return byPassValidationELTempTermOfPayment;
	}
	public void setByPassValidationELTempTermOfPayment(
			boolean byPassValidationELTempTermOfPayment) {
		this.byPassValidationELTempTermOfPayment = byPassValidationELTempTermOfPayment;
	}
	public InstallmentSearch7 getInstallment() {
		return installment;
	}
	public void setInstallment(InstallmentSearch7 installment) {
		this.installment = installment;
	}
	public List<InstallmentSearch7> getInstallmentSearch7lList() {
		return installmentSearch7lList;
	}
	public void setInstallmentSearch7lList(
			List<InstallmentSearch7> installmentSearch7lList) {
		this.installmentSearch7lList = installmentSearch7lList;
	}
	public String getMeterInstallmentId() {
		return meterInstallmentId;
	}
	public void setMeterInstallmentId(String meterInstallmentId) {
		this.meterInstallmentId = meterInstallmentId;
	}
	public InstallmentSearch7 getInstallmentEdit() {
		return installmentEdit;
	}
	public void setInstallmentEdit(InstallmentSearch7 installmentEdit) {
		this.installmentEdit = installmentEdit;
	}
	public Payment getMeterPayment() {
		return meterPayment;
	}
	public void setMeterPayment(Payment meterPayment) {
		this.meterPayment = meterPayment;
	}
	
	@Override
	public void setScrollerPage(String scrollerPage) {
		// TODO Auto-generated method stub
		super.setScrollerPage(scrollerPage);
	}
	
	public List<SelectItem> getVendorIdList() {
		return vendorIdList;
	}
	public void setVendorIdList(List<SelectItem> vendorIdList) {
		this.vendorIdList = vendorIdList;
	}
	public boolean isDisableBtnPercent() {
		return disableBtnPercent;
	}
	public void setDisableBtnPercent(boolean disableBtnPercent) {
		this.disableBtnPercent = disableBtnPercent;
	}
	public boolean isDisableBtnElGroup() {
		return disableBtnElGroup;
	}
	public void setDisableBtnElGroup(boolean disableBtnElGroup) {
		this.disableBtnElGroup = disableBtnElGroup;
	}
	public ElGroupSP getElGroupSP() {
		return elGroupSP;
	}
	public void setElGroupSP(ElGroupSP elGroupSP) {
		this.elGroupSP = elGroupSP;
	}
	public List<ElGroupSP> getElGroupSPList() {
		return elGroupSPList;
	}
	public void setElGroupSPList(List<ElGroupSP> elGroupSPList) {
		this.elGroupSPList = elGroupSPList;
	}
	public ElUseTypeDetailSP getElUseType() {
		return elUseType;
	}
	public void setElUseType(ElUseTypeDetailSP elUseType) {
		this.elUseType = elUseType;
	}
	public List<ElUseTypeDetailSP> getElUseTypeList() {
		return elUseTypeList;
	}
	public void setElUseTypeList(List<ElUseTypeDetailSP> elUseTypeList) {
		this.elUseTypeList = elUseTypeList;
	}
	public String getPageFrom() {
		return pageFrom;
	}
	public void setPageFrom(String pageFrom) {
		this.pageFrom = pageFrom;
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
	public String getStyleClassName() {
		return styleClassName;
	}
	public void setStyleClassName(String styleClassName) {
		this.styleClassName = styleClassName;
	}
	public boolean isComeFromPage9() {
		return isComeFromPage9;
	}
	public void setComeFromPage9(boolean isComeFromPage9) {
		this.isComeFromPage9 = isComeFromPage9;
		this.isComeFromOtherPage = true;
	}
	
}
