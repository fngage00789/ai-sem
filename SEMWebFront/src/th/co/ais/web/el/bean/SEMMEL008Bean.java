package th.co.ais.web.el.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.el.Mel008ReportSP;
import th.co.ais.domain.el.Payment;
import th.co.ais.domain.el.PaymentSP;
import th.co.ais.domain.el.PaymentWrapper;
import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.domain.rt.Mrt003Srch;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMEL008Bean extends AbstractBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6188063163415609890L;
	
	
	// --- LOVs ---
	private List<SelectItem> companyList;
	private List<SelectItem> electricUseTypeList;
	private List<SelectItem> regionList;
	private List<SelectItem> expenseTypeList;
	private List<SelectItem> paymentStatusList;
	private List<SelectItem> paymentTypeList;
	private List<SelectItem> paymentMethodList;
	private List<SelectItem> bankNameList;
	private List<SelectItem> orderByList;//WT###Add 20110426
	
	// --- variable ---
	private Payment searchCriteria;
	private boolean siteType;
	private int payment0102Count;
	private int payment01Count;
	private int payment02Count;
	private String companyBigLabel;
	private List<Payment> selectedPayments;
	private List<PaymentSP> selectedPaymentSPList;
	private Payment selectedPayment;
	private PaymentSP selectedPaymentSP;
	private PaymentWrapper selectedWrapper;
	private String message;
	private String message2;
	private List<PaymentWrapper> paymentWrapperList;
	private String targetPaymentId;
	private String tmpBankName;
	private String tmpBankAccount;
	private String exportBatchNo;
	
	private boolean chkSelAll;
	private boolean commandButtonEnable;
	private boolean disablePaymentMethodList;
	private boolean chqRequired;
	private boolean transferRequired;
	private boolean visibleEditYesBtn;
	private boolean visibleEditYesBtnForDepositMeaPea;
	private boolean visibleEditYesBtnForDepositPrivate;	
	private boolean visibleEditYesBtnForDepositPrivate10;//WT###Add 20110113
	private boolean visibleEditYesBtnForDepositPrivate62;//WT###Add 20110117
	private boolean visibleEditYesBtnForFee;
	private boolean visibleEditYesBtnForElBill;
	private boolean visibleEditYesBtnForElPostPaid;
	private boolean visibleEditYesBtnForElTemp;
	private boolean visibleEditYesBtnForPrPostPaid;
	private boolean visibleEditYesBtnForPrPrePaid;
	private boolean visibleCancelPaymentYesBtn;
	private boolean visibleSaveBtn;
	private boolean visibleCancelBtn;
	private boolean visibleNoBtn;
	private boolean visibleOkBtn;
	private boolean visibleExportBtn;
	private boolean visibleCancelExportBtn;
	private boolean visibleExportRemarkBtn;
	private boolean visibleCancelExportRemarkBtn;
	private boolean visibleEditYesBtnForCredit;
	
	// added by.. YUT 2014/09/10
	private boolean chkRcptPay;
	
	//update by new 26/11/2014
	private Mrt003Srch mrt003Srch; 
	private boolean displayReportFlag = false;
	private String styleClassName = "ms7";
	// popup add vendor
	public List<WrapperBeanObject<VendorMasterSP>> vendorMasterPopupList;
	private VendorMasterSP vendorMasterPopupObjParam;
	
	private Mel008ReportSP expReportSP;
	private List<Mel008ReportSP> expReportList;
	private boolean displayReportChqFlag = false;
	
	private List<SelectItem> elCondSubTypeList;
	private List<SelectItem> serviceList;
	
	private boolean renderedOnToDoList;
	
	// --- method ---
	public boolean isVisibleCancelExportBtn() {
		return visibleCancelExportBtn;
	}

	public String getExportBatchNo() {
		return exportBatchNo;
	}

	public void setExportBatchNo(String exportBatchNo) {
		this.exportBatchNo = exportBatchNo;
	}

	public String getTargetPaymentId() {
		return targetPaymentId;
	}

	public void setTargetPaymentId(String targetPaymentId) {
		this.targetPaymentId = targetPaymentId;
	}

	public boolean isVisibleEditYesBtnForDepositMeaPea() {
		return visibleEditYesBtnForDepositMeaPea;
	}

	public void setVisibleEditYesBtnForDepositMeaPea(
			boolean visibleEditYesBtnForDepositMeaPea) {
		this.visibleEditYesBtnForDepositMeaPea = visibleEditYesBtnForDepositMeaPea;
	}

	public boolean isVisibleEditYesBtnForDepositPrivate() {
		return visibleEditYesBtnForDepositPrivate;
	}

	public void setVisibleEditYesBtnForDepositPrivate(
			boolean visibleEditYesBtnForDepositPrivate) {
		this.visibleEditYesBtnForDepositPrivate = visibleEditYesBtnForDepositPrivate;
	}

	public boolean isVisibleEditYesBtnForFee() {
		return visibleEditYesBtnForFee;
	}

	public void setVisibleEditYesBtnForFee(boolean visibleEditYesBtnForFee) {
		this.visibleEditYesBtnForFee = visibleEditYesBtnForFee;
	}

	public boolean isVisibleEditYesBtnForElBill() {
		return visibleEditYesBtnForElBill;
	}

	public void setVisibleEditYesBtnForElBill(boolean visibleEditYesBtnForElBill) {
		this.visibleEditYesBtnForElBill = visibleEditYesBtnForElBill;
	}

	public boolean isVisibleEditYesBtnForElPostPaid() {
		return visibleEditYesBtnForElPostPaid;
	}

	public void setVisibleEditYesBtnForElPostPaid(
			boolean visibleEditYesBtnForElPostPaid) {
		this.visibleEditYesBtnForElPostPaid = visibleEditYesBtnForElPostPaid;
	}

	public boolean isVisibleEditYesBtnForElTemp() {
		return visibleEditYesBtnForElTemp;
	}

	public void setVisibleEditYesBtnForElTemp(boolean visibleEditYesBtnForElTemp) {
		this.visibleEditYesBtnForElTemp = visibleEditYesBtnForElTemp;
	}

	public boolean isVisibleEditYesBtnForPrPostPaid() {
		return visibleEditYesBtnForPrPostPaid;
	}

	public void setVisibleEditYesBtnForPrPostPaid(
			boolean visibleEditYesBtnForPrPostPaid) {
		this.visibleEditYesBtnForPrPostPaid = visibleEditYesBtnForPrPostPaid;
	}

	public boolean isVisibleEditYesBtnForPrPrePaid() {
		return visibleEditYesBtnForPrPrePaid;
	}

	public void setVisibleEditYesBtnForPrPrePaid(
			boolean visibleEditYesBtnForPrPrePaid) {
		this.visibleEditYesBtnForPrPrePaid = visibleEditYesBtnForPrPrePaid;
	}

	public void setVisibleCancelExportBtn(boolean visibleCancelExportBtn) {
		this.visibleCancelExportBtn = visibleCancelExportBtn;
	}
	
	public boolean isSiteType() {
		return siteType;
	}

	public boolean isVisibleExportBtn() {
		return visibleExportBtn;
	}

	public void setVisibleExportBtn(boolean visibleExportBtn) {
		this.visibleExportBtn = visibleExportBtn;
	}

	public boolean isVisibleSaveBtn() {
		return visibleSaveBtn;
	}

	public void setVisibleSaveBtn(boolean visibleSaveBtn) {
		this.visibleSaveBtn = visibleSaveBtn;
	}

	public boolean isVisibleCancelBtn() {
		return visibleCancelBtn;
	}

	public void setVisibleCancelBtn(boolean visibleCancelBtn) {
		this.visibleCancelBtn = visibleCancelBtn;
	}

	public boolean isVisibleCancelPaymentYesBtn() {
		return visibleCancelPaymentYesBtn;
	}

	public void setVisibleCancelPaymentYesBtn(boolean visibleCancelPaymentYesBtn) {
		this.visibleCancelPaymentYesBtn = visibleCancelPaymentYesBtn;
	}

	public boolean isVisibleEditYesBtn() {
		return visibleEditYesBtn;
	}

	public void setVisibleEditYesBtn(boolean visibleEditYesBtn) {
		this.visibleEditYesBtn = visibleEditYesBtn;
	}

	public List<SelectItem> getBankNameList() {
		return bankNameList;
	}

	public void setBankNameList(List<SelectItem> bankNameList) {
		this.bankNameList = bankNameList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isVisibleNoBtn() {
		return visibleNoBtn;
	}

	public void setVisibleNoBtn(boolean visibleNoBtn) {
		this.visibleNoBtn = visibleNoBtn;
	}

	public boolean isVisibleOkBtn() {
		return visibleOkBtn;
	}

	public void setVisibleOkBtn(boolean visibleOkBtn) {
		this.visibleOkBtn = visibleOkBtn;
	}

	public PaymentWrapper getSelectedWrapper() {
		return selectedWrapper;
	}

	public void setSelectedWrapper(PaymentWrapper selectedWrapper) {
		this.selectedWrapper = selectedWrapper;
	}

	public Payment getSelectedPayment() {
		return selectedPayment;
	}

	public void setSelectedPayment(Payment selectedPayment) {
		this.selectedPayment = selectedPayment;
	}

	public List<Payment> getSelectedPayments() {
		return selectedPayments;
	}

	public void setSelectedPayments(List<Payment> selectedPayments) {
		this.selectedPayments = selectedPayments;
	}

	public boolean isChqRequired() {
		return chqRequired;
	}

	public void setChqRequired(boolean chqRequired) {
		this.chqRequired = chqRequired;
	}

	public boolean isTransferRequired() {
		return transferRequired;
	}

	public void setTransferRequired(boolean transferRequired) {
		this.transferRequired = transferRequired;
	}

	public boolean isDisablePaymentMethodList() {
		return disablePaymentMethodList;
	}

	public void setDisablePaymentMethodList(boolean disablePaymentMethodList) {
		this.disablePaymentMethodList = disablePaymentMethodList;
	}

	public List<SelectItem> getPaymentMethodList() {
		return paymentMethodList;
	}

	public void setPaymentMethodList(List<SelectItem> paymentMethodList) {
		this.paymentMethodList = paymentMethodList;
	}

	public boolean isChkSelAll() {
		return chkSelAll;
	}

	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}

	public boolean isCommandButtonEnable() {
		return commandButtonEnable;
	}

	public void setCommandButtonEnable(boolean commandButtonEnable) {
		this.commandButtonEnable = commandButtonEnable;
	}

	public String getCompanyBigLabel() {
		return companyBigLabel;
	}

	public void setCompanyBigLabel(String companyBigLabel) {
		this.companyBigLabel = companyBigLabel;
	}

	public void setSiteType(boolean siteType) {
		this.siteType = siteType;
	}
	
	public List<SelectItem> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}

	public List<SelectItem> getElectricUseTypeList() {
		return electricUseTypeList;
	}

	public void setElectricUseTypeList(List<SelectItem> electricUseTypeList) {
		this.electricUseTypeList = electricUseTypeList;
	}

	public List<SelectItem> getRegionList() {
		return regionList;
	}

	public void setRegionList(List<SelectItem> regionList) {
		this.regionList = regionList;
	}

	public List<SelectItem> getExpenseTypeList() {
		return expenseTypeList;
	}

	public void setExpenseTypeList(List<SelectItem> expenseTypeList) {
		this.expenseTypeList = expenseTypeList;
	}

	public List<SelectItem> getPaymentStatusList() {
		return paymentStatusList;
	}

	public void setPaymentStatusList(List<SelectItem> paymentStatusList) {
		this.paymentStatusList = paymentStatusList;
	}

	public List<SelectItem> getPaymentTypeList() {
		return paymentTypeList;
	}

	public void setPaymentTypeList(List<SelectItem> paymentTypeList) {
		this.paymentTypeList = paymentTypeList;
	}

	public Payment getSearchCriteria() {
		return searchCriteria;
	}

	public void setSearchCriteria(Payment searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	public List<PaymentWrapper> getPaymentWrapperList() {
		return paymentWrapperList;
	}

	public void setPaymentWrapperList(List<PaymentWrapper> paymentWrapperList) {
		this.paymentWrapperList = paymentWrapperList;
	}

	public int getPayment0102Count() {
		return payment0102Count;
	}

	public void setPayment0102Count(int payment0102Count) {
		this.payment0102Count = payment0102Count;
	}

	public int getPayment01Count() {
		return payment01Count;
	}

	public void setPayment01Count(int payment01Count) {
		this.payment01Count = payment01Count;
	}

	public int getPayment02Count() {
		return payment02Count;
	}

	public void setPayment02Count(int payment02Count) {
		this.payment02Count = payment02Count;
	}

	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public String getTmpBankName() {
		return tmpBankName;
	}

	public void setTmpBankName(String tmpBankName) {
		this.tmpBankName = tmpBankName;
	}

	public String getTmpBankAccount() {
		return tmpBankAccount;
	}

	public void setTmpBankAccount(String tmpBankAccount) {
		this.tmpBankAccount = tmpBankAccount;
	}

	public boolean isVisibleEditYesBtnForDepositPrivate10() {
		return visibleEditYesBtnForDepositPrivate10;
	}

	public void setVisibleEditYesBtnForDepositPrivate10(
			boolean visibleEditYesBtnForDepositPrivate10) {
		this.visibleEditYesBtnForDepositPrivate10 = visibleEditYesBtnForDepositPrivate10;
	}

	public boolean isVisibleEditYesBtnForDepositPrivate62() {
		return visibleEditYesBtnForDepositPrivate62;
	}

	public void setVisibleEditYesBtnForDepositPrivate62(
			boolean visibleEditYesBtnForDepositPrivate62) {
		this.visibleEditYesBtnForDepositPrivate62 = visibleEditYesBtnForDepositPrivate62;
	}

	public boolean isVisibleEditYesBtnForCredit() {
		return visibleEditYesBtnForCredit;
	}

	public void setVisibleEditYesBtnForCredit(boolean visibleEditYesBtnForCredit) {
		this.visibleEditYesBtnForCredit = visibleEditYesBtnForCredit;
	}

	public List<SelectItem> getOrderByList() {
		return orderByList;
	}

	public void setOrderByList(List<SelectItem> orderByList) {
		this.orderByList = orderByList;
	}

	public String getMessage2() {
		return message2;
	}

	public void setMessage2(String message2) {
		this.message2 = message2;
	}

	public boolean isChkRcptPay() {
		return chkRcptPay;
	}

	public void setChkRcptPay(boolean chkRcptPay) {
		this.chkRcptPay = chkRcptPay;
	}

	public Mrt003Srch getMrt003Srch() {
		return mrt003Srch;
	}

	public void setMrt003Srch(Mrt003Srch mrt003Srch) {
		this.mrt003Srch = mrt003Srch;
	}

	public boolean isDisplayReportFlag() {
		return displayReportFlag;
	}

	public void setDisplayReportFlag(boolean displayReportFlag) {
		this.displayReportFlag = displayReportFlag;
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
	public VendorMasterSP getVendorMasterPopupObjParam() {
		if(vendorMasterPopupObjParam == null)
			vendorMasterPopupObjParam = new VendorMasterSP();
		return vendorMasterPopupObjParam;
	}
	public void setVendorMasterPopupObjParam(
			VendorMasterSP vendorMasterPopupObjParam) {
		this.vendorMasterPopupObjParam = vendorMasterPopupObjParam;
	}

	public String getStyleClassName() {
		return styleClassName;
	}

	public void setStyleClassName(String styleClassName) {
		this.styleClassName = styleClassName;
	}

	public List<PaymentSP> getSelectedPaymentSPList() {
		return selectedPaymentSPList;
	}

	public void setSelectedPaymentSPList(List<PaymentSP> selectedPaymentSPList) {
		this.selectedPaymentSPList = selectedPaymentSPList;
	}

	public PaymentSP getSelectedPaymentSP() {
		return selectedPaymentSP;
	}

	public void setSelectedPaymentSP(PaymentSP selectedPaymentSP) {
		this.selectedPaymentSP = selectedPaymentSP;
	}

	public Mel008ReportSP getExpReportSP() {
		return expReportSP;
	}

	public void setExpReportSP(Mel008ReportSP expReportSP) {
		this.expReportSP = expReportSP;
	}

	public List<Mel008ReportSP> getExpReportList() {
		return expReportList;
	}

	public void setExpReportList(List<Mel008ReportSP> expReportList) {
		this.expReportList = expReportList;
	}

	public boolean isDisplayReportChqFlag() {
		return displayReportChqFlag;
	}

	public void setDisplayReportChqFlag(boolean displayReportChqFlag) {
		this.displayReportChqFlag = displayReportChqFlag;
	}

	public boolean isVisibleExportRemarkBtn() {
		return visibleExportRemarkBtn;
	}

	public void setVisibleExportRemarkBtn(boolean visibleExportRemarkBtn) {
		this.visibleExportRemarkBtn = visibleExportRemarkBtn;
	}

	public boolean isVisibleCancelExportRemarkBtn() {
		return visibleCancelExportRemarkBtn;
	}

	public void setVisibleCancelExportRemarkBtn(boolean visibleCancelExportRemarkBtn) {
		this.visibleCancelExportRemarkBtn = visibleCancelExportRemarkBtn;
	}

	public List<SelectItem> getElCondSubTypeList() {
		return elCondSubTypeList;
	}

	public void setElCondSubTypeList(List<SelectItem> elCondSubTypeList) {
		this.elCondSubTypeList = elCondSubTypeList;
	}

	public List<SelectItem> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<SelectItem> serviceList) {
		this.serviceList = serviceList;
	}

	public boolean isRenderedOnToDoList() {
		return renderedOnToDoList;
	}

	public void setRenderedOnToDoList(boolean renderedOnToDoList) {
		this.renderedOnToDoList = renderedOnToDoList;
	}
	
}
