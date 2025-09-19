package th.co.ais.web.el.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.persistence.Transient;

import th.co.ais.domain.el.MeterInstallment;
import th.co.ais.web.bean.AbstractBean;

public class SEMMEL009Bean extends AbstractBean{

	private static final long serialVersionUID = 6133888824127329045L;
	
	// Search
	private MeterInstallment criteria;
	private List<MeterInstallment> resultList;
	
	// DropDown
	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> provinceList;
	private List<SelectItem> electricUseTypeList;
	private List<SelectItem> monthList;
	private List<SelectItem> yearList;
	private List<SelectItem> accureStatusList;
	private boolean chkSelAll = false;
	private boolean disableBtn = true;
	
	// detail
	private MeterInstallment meterInstallment;
	private List<MeterInstallment> meterInstallmentList;
	private List<MeterInstallment> popupList;
	
	//Optional message description
	private String headerSearchResult;
	private String disableMonthYear;
	private String msgErrorTmpSuccess;
	private String msgErrorTmpFail;
	
	private String expenseType;
	private String paymentId;
	private String message;
	private String electricUseType;
	private String specialFlag;
	private String targetPaymentId;
	
	private boolean visibleEditYesBtn;
	private boolean visibleNoBtn;
	
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
	private boolean visibleEditYesBtnForCredit;
	private boolean displayExportExcel;
	private boolean disableBtnExport = true;
	private boolean disableBtnSendSms = true;
	private boolean disableBtnSendEmail = true;
	private boolean chkPico;
	private String picoFalg;
	private List<SelectItem> siteTypeList;
	
	private List<MeterInstallment> exportExcelList;
	
	public List<SelectItem> getElectricUseTypeList() {
		return electricUseTypeList;
	}

	public void setElectricUseTypeList(List<SelectItem> electricUseTypeList) {
		this.electricUseTypeList = electricUseTypeList;
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

	public List<SelectItem> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<SelectItem> provinceList) {
		this.provinceList = provinceList;
	}

	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public MeterInstallment getCriteria() {
		return criteria;
	}

	public void setCriteria(MeterInstallment criteria) {
		this.criteria = criteria;
	}

	public List<MeterInstallment> getResultList() {
		return resultList;
	}

	public void setResultList(List<MeterInstallment> resultList) {
		this.resultList = resultList;
	}

	public MeterInstallment getMeterInstallment() {
		return meterInstallment;
	}

	public void setMeterInstallment(MeterInstallment meterInstallment) {
		this.meterInstallment = meterInstallment;
	}

	public List<MeterInstallment> getMeterInstallmentList() {
		return meterInstallmentList;
	}

	public void setMeterInstallmentList(
			List<MeterInstallment> meterInstallmentList) {
		this.meterInstallmentList = meterInstallmentList;
	}

	public int getMaxPage() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setMaxPage(int maxPage) {
		// TODO Auto-generated method stub
	}

	public int getMaxSearchResult() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setMaxSearchResult(int maxSearchResult) {
		// TODO Auto-generated method stub
	}

	public String getHeaderSearchResult() {
		return headerSearchResult;
	}

	public void setHeaderSearchResult(String headerSearchResult) {
		this.headerSearchResult = headerSearchResult;
	}

	public String getDisableMonthYear() {
		return disableMonthYear;
	}

	public void setDisableMonthYear(String disableMonthYear) {
		this.disableMonthYear = disableMonthYear;
	}

	public List<SelectItem> getAccureStatusList() {
		return accureStatusList;
	}

	public void setAccureStatusList(List<SelectItem> accureStatusList) {
		this.accureStatusList = accureStatusList;
	}

	public boolean isChkSelAll() {
		return chkSelAll;
	}

	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}

	public boolean isDisableBtn() {
		return disableBtn;
	}

	public void setDisableBtn(boolean disableBtn) {
		this.disableBtn = disableBtn;
	}

	public List<MeterInstallment> getPopupList() {
		return popupList;
	}

	public void setPopupList(List<MeterInstallment> popupList) {
		this.popupList = popupList;
	}

	public String getMsgErrorTmpSuccess() {
		return msgErrorTmpSuccess;
	}

	public void setMsgErrorTmpSuccess(String msgErrorTmpSuccess) {
		this.msgErrorTmpSuccess = msgErrorTmpSuccess;
	}

	public String getMsgErrorTmpFail() {
		return msgErrorTmpFail;
	}

	public void setMsgErrorTmpFail(String msgErrorTmpFail) {
		this.msgErrorTmpFail = msgErrorTmpFail;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getElectricUseType() {
		return electricUseType;
	}

	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}

	public String getSpecialFlag() {
		return specialFlag;
	}

	public void setSpecialFlag(String specialFlag) {
		this.specialFlag = specialFlag;
	}

	public boolean isVisibleEditYesBtn() {
		return visibleEditYesBtn;
	}

	public void setVisibleEditYesBtn(boolean visibleEditYesBtn) {
		this.visibleEditYesBtn = visibleEditYesBtn;
	}

	public boolean isVisibleNoBtn() {
		return visibleNoBtn;
	}

	public void setVisibleNoBtn(boolean visibleNoBtn) {
		this.visibleNoBtn = visibleNoBtn;
	}

	public String getTargetPaymentId() {
		return targetPaymentId;
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

	public void setTargetPaymentId(String targetPaymentId) {
		this.targetPaymentId = targetPaymentId;
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

	public boolean isVisibleCancelPaymentYesBtn() {
		return visibleCancelPaymentYesBtn;
	}

	public void setVisibleCancelPaymentYesBtn(boolean visibleCancelPaymentYesBtn) {
		this.visibleCancelPaymentYesBtn = visibleCancelPaymentYesBtn;
	}

	public boolean isVisibleEditYesBtnForCredit() {
		return visibleEditYesBtnForCredit;
	}

	public void setVisibleEditYesBtnForCredit(boolean visibleEditYesBtnForCredit) {
		this.visibleEditYesBtnForCredit = visibleEditYesBtnForCredit;
	}

	public boolean isDisplayExportExcel() {
		return displayExportExcel;
	}

	public void setDisplayExportExcel(boolean displayExportExcel) {
		this.displayExportExcel = displayExportExcel;
	}

	public List<MeterInstallment> getExportExcelList() {
		return exportExcelList;
	}

	public void setExportExcelList(List<MeterInstallment> exportExcelList) {
		this.exportExcelList = exportExcelList;
	}

	public boolean isDisableBtnExport() {
		return disableBtnExport;
	}

	public void setDisableBtnExport(boolean disableBtnExport) {
		this.disableBtnExport = disableBtnExport;
	}

	public boolean isDisableBtnSendSms() {
		return disableBtnSendSms;
	}

	public void setDisableBtnSendSms(boolean disableBtnSendSms) {
		this.disableBtnSendSms = disableBtnSendSms;
	}

	public boolean isDisableBtnSendEmail() {
		return disableBtnSendEmail;
	}

	public void setDisableBtnSendEmail(boolean disableBtnSendEmail) {
		this.disableBtnSendEmail = disableBtnSendEmail;
	}
	@Transient
	public boolean isChkPico() {
		return chkPico;
	}

	public void setChkPico(boolean chkPico) {
		this.chkPico = chkPico;
	}
	@Transient
	public String getPicoFalg() {
		return picoFalg;
	}

	public void setPicoFalg(String picoFalg) {
		this.picoFalg = picoFalg;
	}

	public List<SelectItem> getSiteTypeList() {
		return siteTypeList;
	}

	public void setSiteTypeList(List<SelectItem> siteTypeList) {
		this.siteTypeList = siteTypeList;
	}
	

}
