package th.co.ais.web.rt.bean;

import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import th.co.ais.domain.ac.Mac004Act;
import th.co.ais.domain.ac.Mac004Srch;
import th.co.ais.domain.rt.CheckVendor;
import th.co.ais.domain.rt.Mrt003Cal;
import th.co.ais.domain.rt.Mrt003Exp;
import th.co.ais.domain.rt.Mrt003PopPaySP;
import th.co.ais.domain.rt.Mrt003Srch;
import th.co.ais.domain.rt.Mrt003UpdateRemark;
import th.co.ais.domain.rt.MrtGetRunningNo;
import th.co.ais.domain.rt.RentalPayNormalEditSaveSP;
import th.co.ais.domain.rt.RentalPayNormalSaveActSP;
import th.co.ais.domain.rt.RentalPayNormalSaveSP;
import th.co.ais.domain.rt.RentalPayNormalSearchDSP;
import th.co.ais.domain.rt.RentalPayNormalSearchSP;
import th.co.ais.domain.rt.RentalPayment;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;
import th.co.ais.web.bean.common.PopupRentalPayBean;

public class SEMMRT009Bean extends AbstractBean{
	
	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> jobTypeList;
	private List<SelectItem> paymentStatusList;
	private List<SelectItem> paymentTypeList;
	private List<SelectItem> siteTypeList;
	private List<SelectItem> paymentMethodList;
	private List<SelectItem> dayPerYearList;
	private List<SelectItem> dayPermonthList;
	private List<SelectItem> vatTypeList;
	private List<SelectItem> networkStatusList;
	private List<SelectItem> paymentList;
	private List<SelectItem> siteStatusList;
	private List<SelectItem> rentalPayExpenseTypeList;
	private List<SelectItem> periodTypeList;
	private List<SelectItem> whtTypeList;
	private List<SelectItem> expenseTypeList;
	private List<SelectItem> expenseTypeListCreate;
	
	private List<WrapperBeanObject<RentalPayNormalSearchSP>> rentalPayNormalSearchSPList;
	private RentalPayNormalSearchSP rentalPayNormalSearchSP;
	
	private List<RentalPayNormalSearchDSP> rentalPayNormalSearchDSPList;
	private RentalPayNormalSearchDSP rentalPayNormalSearchDSP;
	
	private List<RentalPayNormalSaveSP> rentalPayNormalSaveSPList;
	private RentalPayNormalSaveSP rentalPayNormalSaveSP;
	
	private List<RentalPayNormalEditSaveSP> rentalPayNormalEditSaveSPList;
	private RentalPayNormalEditSaveSP rentalPayNormalEditSaveSP;
	
	private List<RentalPayNormalSaveActSP> rentalPayNormalSaveActSPList;
	private RentalPayNormalSaveActSP rentalPayNormalSaveActSP;
	
	private List<MrtGetRunningNo> mrtGetRunningNoList;
	private MrtGetRunningNo mrtGetRunningNo;
	private CheckVendor checkVendor; 
	
	private Mrt003Cal mrt003Cal;
	
	private Mrt003Exp mrt003Exp;
	
	private RentalPayment rentalPayment;
	
	private boolean chkDeposit;
	private String validatePopup;
	private String rowId;
	private String paymentGroupno;
	private boolean validateBtn;
	private Date tmpChqDt;
	private Date tmpChqReceiveDt;
	private Date tmpTransferDt;
	private String tmpPaymentMethod;
	private String btnApproveStatus;
	private String remark;
	private String popupName;
	private String periodNo;
	private boolean displayShowExcel;
	private boolean displayShowExcelReport = false;	
	
	private boolean chkSelAll = false;
	private boolean disabledBtnExport=true;
	private boolean renderedBtnExportShowError = false;
	
	private PopupRentalPayBean popupRentalPayBean;
	
	private String confirmCoppyDateMsg;
	
	private String btnStatus;
	
	//Render message form search
	private boolean renderedMsgFormSearch = true;
	
	//Render message form Popup
	private boolean renderedMsgFormPopup = true;
	
	//Render DepositAmt
	private boolean renderedDepositAmt;
	
	//Render Calender chqDt or TransferDT
	private boolean renderedChqDt;
	private boolean renderedTransferDt;
	private boolean renderedPaymentMethod;
	
	//Render Date Month Year
	private boolean renderedMonth;
	private boolean renderedYear;
	
	//Render VatRat and WhtRate
	private boolean renderedvatRate;
	private boolean renderedWhtRate;
	
	//excAmt vatAmt whtAmt for (+ - 1)
	private Double oldExcAmt;
	private Double oldVatAmt;
	private Double oldWhtAmt;
	private Double oldIncAmt;
	private Double oldTotalAmt;
	
	private Double tmpDepositAmt;
	private Double tmpPaymentAmt;
	
	//for rendered field Seacrh 3 feild
	private boolean tmpGroup1;
	
	//for rendered field Seacrh 1 feild
	private boolean tmpGroup2;
	
	private boolean renderedBtnHExport;
	private boolean renderedBtnA4JExport;
	
	private String msgHeaderPopup1;
	private String msgHeaderPopup2;
	private List<Mrt003Exp> mrt003ExpsList;
	private String pAction;
	private boolean pExportChq;
	private String disableExportChq;
	
	private boolean RenderedMsgDataNotFound2 = false;
	private List<RentalPayNormalSearchSP> rentalPaySSearchSpList;
	private boolean hasCheckExtraFine = true;
	
	private boolean disableSMSBtn = true;
	
	private List<Mac004Srch> mac004SrchList;
	private Mac004Act mac004Act; 
	private List<SelectItem> pamentStatusList;
	private String paymentStatus;
	private Mrt003PopPaySP manualSettleSP;
	private boolean popupCloseSave = false;
	private Mrt003UpdateRemark mrt003UpdateRemark;
	private boolean popupEditRemarkClose;
	private boolean renderMessagePopup = false;
	private boolean exportFlagRemark = false;
	private boolean renderEditCreatNewMessage = false;
	private boolean disWhtRate = false;
	private boolean viewMode = false;
	private double tmpWhtRate;
	private  boolean requireFlag = false;
	private List<SelectItem> vendorList;
	private List<SelectItem> payeeList;
	private boolean chkClickCal = false;
	
	//update by new 26/11/2014
	private Mrt003Srch mrt003Srch; 
	private boolean displayReportFlag = false;
	
	
	// added by.. YUT
	private boolean renderedOnToDoList = false;
	
	
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
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
	public List<SelectItem> getJobTypeList() {
		return jobTypeList;
	}
	public void setJobTypeList(List<SelectItem> jobTypeList) {
		this.jobTypeList = jobTypeList;
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
	public List<SelectItem> getSiteTypeList() {
		return siteTypeList;
	}
	public void setSiteTypeList(List<SelectItem> siteTypeList) {
		this.siteTypeList = siteTypeList;
	}
	public RentalPayNormalSearchSP getRentalPayNormalSearchSP() {
		return rentalPayNormalSearchSP;
	}
	public void setRentalPayNormalSearchSP(
			RentalPayNormalSearchSP rentalPayNormalSearchSP) {
		this.rentalPayNormalSearchSP = rentalPayNormalSearchSP;
	}
	public List<RentalPayNormalSaveActSP> getRentalPayNormalSaveActSPList() {
		return rentalPayNormalSaveActSPList;
	}
	public void setRentalPayNormalSaveActSPList(
			List<RentalPayNormalSaveActSP> rentalPayNormalSaveActSPList) {
		this.rentalPayNormalSaveActSPList = rentalPayNormalSaveActSPList;
	}
	public RentalPayNormalSaveActSP getRentalPayNormalSaveActSP() {
		return rentalPayNormalSaveActSP;
	}
	public Date getTmpChqDt() {
		return tmpChqDt;
	}
	public void setTmpChqDt(Date tmpChqDt) {
		this.tmpChqDt = tmpChqDt;
	}
	public Date getTmpChqReceiveDt() {
		return tmpChqReceiveDt;
	}
	public void setTmpChqReceiveDt(Date tmpChqReceiveDt) {
		this.tmpChqReceiveDt = tmpChqReceiveDt;
	}
	public Date getTmpTransferDt() {
		return tmpTransferDt;
	}
	public void setTmpTransferDt(Date tmpTransferDt) {
		this.tmpTransferDt = tmpTransferDt;
	}
	public void setRentalPayNormalSaveActSP(
			RentalPayNormalSaveActSP rentalPayNormalSaveActSP) {
		this.rentalPayNormalSaveActSP = rentalPayNormalSaveActSP;
	}
	public List<SelectItem> getDayPerYearList() {
		return dayPerYearList;
	}
	public void setDayPerYearList(List<SelectItem> dayPerYearList) {
		this.dayPerYearList = dayPerYearList;
	}
	public List<SelectItem> getDayPermonthList() {
		return dayPermonthList;
	}
	public List<RentalPayNormalEditSaveSP> getRentalPayNormalEditSaveSPList() {
		return rentalPayNormalEditSaveSPList;
	}
	public void setRentalPayNormalEditSaveSPList(
			List<RentalPayNormalEditSaveSP> rentalPayNormalEditSaveSPList) {
		this.rentalPayNormalEditSaveSPList = rentalPayNormalEditSaveSPList;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getPaymentGroupno() {
		return paymentGroupno;
	}
	public void setPaymentGroupno(String paymentGroupno) {
		this.paymentGroupno = paymentGroupno;
	}
	public RentalPayNormalEditSaveSP getRentalPayNormalEditSaveSP() {
		return rentalPayNormalEditSaveSP;
	}
	public void setRentalPayNormalEditSaveSP(
			RentalPayNormalEditSaveSP rentalPayNormalEditSaveSP) {
		this.rentalPayNormalEditSaveSP = rentalPayNormalEditSaveSP;
	}
	public void setDayPermonthList(List<SelectItem> dayPermonthList) {
		this.dayPermonthList = dayPermonthList;
	}
	public List<RentalPayNormalSaveSP> getRentalPayNormalSaveSPList() {
		return rentalPayNormalSaveSPList;
	}
	public void setRentalPayNormalSaveSPList(
			List<RentalPayNormalSaveSP> rentalPayNormalSaveSPList) {
		this.rentalPayNormalSaveSPList = rentalPayNormalSaveSPList;
	}
	public RentalPayNormalSaveSP getRentalPayNormalSaveSP() {
		return rentalPayNormalSaveSP;
	}
	public void setRentalPayNormalSaveSP(RentalPayNormalSaveSP rentalPayNormalSaveSP) {
		this.rentalPayNormalSaveSP = rentalPayNormalSaveSP;
	}
	public List<SelectItem> getVatTypeList() {
		return vatTypeList;
	}
	public void setVatTypeList(List<SelectItem> vatTypeList) {
		this.vatTypeList = vatTypeList;
	}
	public void setPaymentMethodList(List<SelectItem> paymentMethodList) {
		this.paymentMethodList = paymentMethodList;
	}
	public List<RentalPayNormalSearchDSP> getRentalPayNormalSearchDSPList() {
		return rentalPayNormalSearchDSPList;
	}
	public void setRentalPayNormalSearchDSPList(
			List<RentalPayNormalSearchDSP> rentalPayNormalSearchDSPList) {
		this.rentalPayNormalSearchDSPList = rentalPayNormalSearchDSPList;
	}
	public RentalPayNormalSearchDSP getRentalPayNormalSearchDSP() {
		return rentalPayNormalSearchDSP;
	}
	public void setRentalPayNormalSearchDSP(
			RentalPayNormalSearchDSP rentalPayNormalSearchDSP) {
		this.rentalPayNormalSearchDSP = rentalPayNormalSearchDSP;
	}
	public List<SelectItem> getPaymentMethodList() {
		return paymentMethodList;
	}
	public void setValidatePopup(String validatePopup) {
		this.validatePopup = validatePopup;
	}
	public String getValidatePopup() {
		return validatePopup;
	}
	public void setBtnApproveStatus(String btnApproveStatus) {
		this.btnApproveStatus = btnApproveStatus;
	}
	public String getBtnApproveStatus() {
		return btnApproveStatus;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRemark() {
		return remark;
	}
	public void setChkDeposit(boolean chkDeposit) {
		this.chkDeposit = chkDeposit;
	}
	public boolean isChkDeposit() {
		return chkDeposit;
	}
	public void setValidateBtn(boolean validateBtn) {
		this.validateBtn = validateBtn;
	}
	public boolean isValidateBtn() {
		return validateBtn;
	}
	public void setPopupName(String popupName) {
		this.popupName = popupName;
	}
	public String getPopupName() {
		return popupName;
	}
	public void setConfirmCoppyDateMsg(String confirmCoppyDateMsg) {
		this.confirmCoppyDateMsg = confirmCoppyDateMsg;
	}
	public String getConfirmCoppyDateMsg() {
		return confirmCoppyDateMsg;
	}
	public void setRentalPayment(RentalPayment rentalPayment) {
		this.rentalPayment = rentalPayment;
	}
	public RentalPayment getRentalPayment() {
		return rentalPayment;
	}
	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}
	public boolean isChkSelAll() {
		return chkSelAll;
	}
	public void setRentalPayNormalSearchSPList(
			List<WrapperBeanObject<RentalPayNormalSearchSP>> rentalPayNormalSearchSPList) {
		this.rentalPayNormalSearchSPList = rentalPayNormalSearchSPList;
	}
	public List<WrapperBeanObject<RentalPayNormalSearchSP>> getRentalPayNormalSearchSPList() {
		return rentalPayNormalSearchSPList;
	}
	public void setDisabledBtnExport(boolean disabledBtnExport) {
		this.disabledBtnExport = disabledBtnExport;
	}
	public boolean isDisabledBtnExport() {
		return disabledBtnExport;
	}
	public void setBtnStatus(String btnStatus) {
		this.btnStatus = btnStatus;
	}
	public String getBtnStatus() {
		return btnStatus;
	}
	public void setRenderedMsgFormSearch(boolean renderedMsgFormSearch) {
		this.renderedMsgFormSearch = renderedMsgFormSearch;
	}
	public boolean isRenderedMsgFormSearch() {
		return renderedMsgFormSearch;
	}
	public void setRenderedDepositAmt(boolean renderedDepositAmt) {
		this.renderedDepositAmt = renderedDepositAmt;
	}
	public boolean isRenderedDepositAmt() {
		return renderedDepositAmt;
	}
	public boolean isRenderedChqDt() {
		return renderedChqDt;
	}
	public void setRenderedChqDt(boolean renderedChqDt) {
		this.renderedChqDt = renderedChqDt;
	}
	public boolean isRenderedTransferDt() {
		return renderedTransferDt;
	}
	public void setRenderedTransferDt(boolean renderedTransferDt) {
		this.renderedTransferDt = renderedTransferDt;
	}
	public void setRenderedPaymentMethod(boolean renderedPaymentMethod) {
		this.renderedPaymentMethod = renderedPaymentMethod;
	}
	public boolean isRenderedPaymentMethod() {
		return renderedPaymentMethod;
	}
	public void setRenderedMsgFormPopup(boolean renderedMsgFormPopup) {
		this.renderedMsgFormPopup = renderedMsgFormPopup;
	}
	public boolean isRenderedMsgFormPopup() {
		return renderedMsgFormPopup;
	}
	public boolean isRenderedMonth() {
		return renderedMonth;
	}
	public void setRenderedMonth(boolean renderedMonth) {
		this.renderedMonth = renderedMonth;
	}
	public boolean isRenderedYear() {
		return renderedYear;
	}
	public void setRenderedYear(boolean renderedYear) {
		this.renderedYear = renderedYear;
	}
	public void setMrtGetRunningNo(MrtGetRunningNo mrtGetRunningNo) {
		this.mrtGetRunningNo = mrtGetRunningNo;
	}
	public MrtGetRunningNo getMrtGetRunningNo() {
		return mrtGetRunningNo;
	}
	public void setMrtGetRunningNoList(List<MrtGetRunningNo> mrtGetRunningNoList) {
		this.mrtGetRunningNoList = mrtGetRunningNoList;
	}
	public List<MrtGetRunningNo> getMrtGetRunningNoList() {
		return mrtGetRunningNoList;
	}
	public Mrt003Cal getMrt003Cal() {
		return mrt003Cal;
	}
	public void setMrt003Cal(Mrt003Cal mrt003Cal) {
		this.mrt003Cal = mrt003Cal;
	}
	public boolean isRenderedvatRate() {
		return renderedvatRate;
	}
	public void setRenderedvatRate(boolean renderedvatRate) {
		this.renderedvatRate = renderedvatRate;
	}
	public boolean isRenderedWhtRate() {
		return renderedWhtRate;
	}
	public void setRenderedWhtRate(boolean renderedWhtRate) {
		this.renderedWhtRate = renderedWhtRate;
	}
	public Double getOldExcAmt() {
		return oldExcAmt;
	}
	public void setOldExcAmt(Double oldExcAmt) {
		this.oldExcAmt = oldExcAmt;
	}
	public Double getOldVatAmt() {
		return oldVatAmt;
	}
	public void setOldVatAmt(Double oldVatAmt) {
		this.oldVatAmt = oldVatAmt;
	}
	public Double getOldWhtAmt() {
		return oldWhtAmt;
	}
	public void setOldWhtAmt(Double oldWhtAmt) {
		this.oldWhtAmt = oldWhtAmt;
	}
	public Double getOldIncAmt() {
		return oldIncAmt;
	}
	public void setOldIncAmt(Double oldIncAmt) {
		this.oldIncAmt = oldIncAmt;
	}
	public void setOldTotalAmt(Double oldTotalAmt) {
		this.oldTotalAmt = oldTotalAmt;
	}
	public Double getOldTotalAmt() {
		return oldTotalAmt;
	}
	public void setTmpDepositAmt(Double tmpDepositAmt) {
		this.tmpDepositAmt = tmpDepositAmt;
	}
	public Double getTmpDepositAmt() {
		return tmpDepositAmt;
	}
	public Double getTmpPaymentAmt() {
		return tmpPaymentAmt;
	}
	public void setTmpPaymentAmt(Double tmpPaymentAmt) {
		this.tmpPaymentAmt = tmpPaymentAmt;
	}
	public boolean isTmpGroup1() {
		return tmpGroup1;
	}
	public void setTmpGroup1(boolean tmpGroup1) {
		this.tmpGroup1 = tmpGroup1;
	}
	public boolean isTmpGroup2() {
		return tmpGroup2;
	}
	public void setTmpGroup2(boolean tmpGroup2) {
		this.tmpGroup2 = tmpGroup2;
	}
	public boolean isRenderedBtnHExport() {
		return renderedBtnHExport;
	}
	public void setRenderedBtnHExport(boolean renderedBtnHExport) {
		this.renderedBtnHExport = renderedBtnHExport;
	}
	public boolean isRenderedBtnA4JExport() {
		return renderedBtnA4JExport;
	}
	public void setRenderedBtnA4JExport(boolean renderedBtnA4JExport) {
		this.renderedBtnA4JExport = renderedBtnA4JExport;
	}
	/**
	 * @param checkVendor the checkVendor to set
	 */
	public void setCheckVendor(CheckVendor checkVendor) {
		this.checkVendor = checkVendor;
	}
	/**
	 * @return the checkVendor
	 */
	public CheckVendor getCheckVendor() {
		return checkVendor;
	}
	public String getMsgHeaderPopup1() {
		return msgHeaderPopup1;
	}
	public void setMsgHeaderPopup1(String msgHeaderPopup1) {
		this.msgHeaderPopup1 = msgHeaderPopup1;
	}
	public String getMsgHeaderPopup2() {
		return msgHeaderPopup2;
	}
	public void setMsgHeaderPopup2(String msgHeaderPopup2) {
		this.msgHeaderPopup2 = msgHeaderPopup2;
	}
	/**
	 * @param tmpPaymentMethod the tmpPaymentMethod to set
	 */
	public void setTmpPaymentMethod(String tmpPaymentMethod) {
		this.tmpPaymentMethod = tmpPaymentMethod;
	}
	/**
	 * @return the tmpPaymentMethod
	 */
	public String getTmpPaymentMethod() {
		return tmpPaymentMethod;
	}
	public String getPeriodNo() {
		return periodNo;
	}
	public void setPeriodNo(String periodNo) {
		this.periodNo = periodNo;
	}
	public boolean isDisplayShowExcel() {
		return displayShowExcel;
	}
	public void setDisplayShowExcel(boolean displayShowExcel) {
		this.displayShowExcel = displayShowExcel;
	}
	public boolean isRenderedBtnExportShowError() {
		return renderedBtnExportShowError;
	}
	public void setRenderedBtnExportShowError(boolean renderedBtnExportShowError) {
		this.renderedBtnExportShowError = renderedBtnExportShowError;
	}
	
	public PopupRentalPayBean getPopupRentalPayBean() {
		return (PopupRentalPayBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupRentalPayBean");
	}
	public void setPopupRentalPayBean(PopupRentalPayBean popupRentalPayBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupRentalPayBean", popupRentalPayBean);
	}
	public Mrt003Exp getMrt003Exp() {
		return mrt003Exp;
	}
	public void setMrt003Exp(Mrt003Exp mrt003Exp) {
		this.mrt003Exp = mrt003Exp;
	}
	public List<Mrt003Exp> getMrt003ExpsList() {
		return mrt003ExpsList;
	}
	public void setMrt003ExpsList(List<Mrt003Exp> mrt003ExpsList) {
		this.mrt003ExpsList = mrt003ExpsList;
	}
	public String getpAction() {
		return pAction;
	}
	public void setpAction(String pAction) {
		this.pAction = pAction;
	}
	public boolean ispExportChq() {
		return pExportChq;
	}
	public void setpExportChq(boolean pExportChq) {
		this.pExportChq = pExportChq;
	}
	public String getDisableExportChq() {
		return disableExportChq;
	}
	public void setDisableExportChq(String disableExportChq) {
		this.disableExportChq = disableExportChq;
	}
	public List<SelectItem> getNetworkStatusList() {
		return networkStatusList;
	}
	public void setNetworkStatusList(List<SelectItem> networkStatusList) {
		this.networkStatusList = networkStatusList;
	}
	public List<SelectItem> getPaymentList() {
		return paymentList;
	}
	public void setPaymentList(List<SelectItem> paymentList) {
		this.paymentList = paymentList;
	}
	public List<SelectItem> getSiteStatusList() {
		return siteStatusList;
	}
	public void setSiteStatusList(List<SelectItem> siteStatusList) {
		this.siteStatusList = siteStatusList;
	}
	public List<SelectItem> getRentalPayExpenseTypeList() {
		return rentalPayExpenseTypeList;
	}
	public void setRentalPayExpenseTypeList(
			List<SelectItem> rentalPayExpenseTypeList) {
		this.rentalPayExpenseTypeList = rentalPayExpenseTypeList;
	}
	public boolean isRenderedMsgDataNotFound2() {
		return RenderedMsgDataNotFound2;
	}
	public void setRenderedMsgDataNotFound2(boolean renderedMsgDataNotFound2) {
		RenderedMsgDataNotFound2 = renderedMsgDataNotFound2;
	}
	public List<RentalPayNormalSearchSP> getRentalPaySSearchSpList() {
		return rentalPaySSearchSpList;
	}
	public void setRentalPaySSearchSpList(
			List<RentalPayNormalSearchSP> rentalPaySSearchSpList) {
		this.rentalPaySSearchSpList = rentalPaySSearchSpList;
	}
	public List<SelectItem> getPeriodTypeList() {
		return periodTypeList;
	}
	public void setPeriodTypeList(List<SelectItem> periodTypeList) {
		this.periodTypeList = periodTypeList;
	}
	public List<SelectItem> getWhtTypeList() {
		return whtTypeList;
	}
	public void setWhtTypeList(List<SelectItem> whtTypeList) {
		this.whtTypeList = whtTypeList;
	}
	public boolean isHasCheckExtraFine() {
		return hasCheckExtraFine;
	}
	public void setHasCheckExtraFine(boolean hasCheckExtraFine) {
		this.hasCheckExtraFine = hasCheckExtraFine;
	}
	public boolean isDisableSMSBtn() {
		return disableSMSBtn;
	}
	public void setDisableSMSBtn(boolean disableSMSBtn) {
		this.disableSMSBtn = disableSMSBtn;
	}
	public boolean isDisplayShowExcelReport() {
		return displayShowExcelReport;
	}
	public void setDisplayShowExcelReport(boolean displayShowExcelReport) {
		this.displayShowExcelReport = displayShowExcelReport;
	}
	public List<Mac004Srch> getMac004SrchList() {
		return mac004SrchList;
	}
	public void setMac004SrchList(List<Mac004Srch> mac004SrchList) {
		this.mac004SrchList = mac004SrchList;
	}
	public Mac004Act getMac004Act() {
		return mac004Act;
	}
	public void setMac004Act(Mac004Act mac004Act) {
		this.mac004Act = mac004Act;
	}
	public List<SelectItem> getPamentStatusList() {
		return pamentStatusList;
	}
	public void setPamentStatusList(List<SelectItem> pamentStatusList) {
		this.pamentStatusList = pamentStatusList;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Mrt003PopPaySP getManualSettleSP() {
		return manualSettleSP;
	}
	public void setManualSettleSP(Mrt003PopPaySP manualSettleSP) {
		this.manualSettleSP = manualSettleSP;
	}
	public Mrt003UpdateRemark getMrt003UpdateRemark() {
		return mrt003UpdateRemark;
	}
	public void setMrt003UpdateRemark(Mrt003UpdateRemark mrt003UpdateRemark) {
		this.mrt003UpdateRemark = mrt003UpdateRemark;
	}
	public boolean isPopupEditRemarkClose() {
		return popupEditRemarkClose;
	}
	public void setPopupEditRemarkClose(boolean popupEditRemarkClose) {
		this.popupEditRemarkClose = popupEditRemarkClose;
	}
	public boolean isPopupCloseSave() {
		return popupCloseSave;
	}
	public void setPopupCloseSave(boolean popupCloseSave) {
		this.popupCloseSave = popupCloseSave;
	}
	public boolean isRenderMessagePopup() {
		return renderMessagePopup;
	}
	public void setRenderMessagePopup(boolean renderMessagePopup) {
		this.renderMessagePopup = renderMessagePopup;
	}
	public boolean isExportFlagRemark() {
		return exportFlagRemark;
	}
	public void setExportFlagRemark(boolean exportFlagRemark) {
		this.exportFlagRemark = exportFlagRemark;
	}
	public boolean isRenderEditCreatNewMessage() {
		return renderEditCreatNewMessage;
	}
	public void setRenderEditCreatNewMessage(boolean renderEditCreatNewMessage) {
		this.renderEditCreatNewMessage = renderEditCreatNewMessage;
	}
	public boolean isDisWhtRate() {
		return disWhtRate;
	}
	public void setDisWhtRate(boolean disWhtRate) {
		this.disWhtRate = disWhtRate;
	}
	public boolean isViewMode() {
		return viewMode;
	}
	public void setViewMode(boolean viewMode) {
		this.viewMode = viewMode;
	}
	public double getTmpWhtRate() {
		return tmpWhtRate;
	}
	public void setTmpWhtRate(double tmpWhtRate) {
		this.tmpWhtRate = tmpWhtRate;
	}
	public boolean isRequireFlag() {
		return requireFlag;
	}
	public void setRequireFlag(boolean requireFlag) {
		this.requireFlag = requireFlag;
	}
	public List<SelectItem> getVendorList() {
		return vendorList;
	}
	public void setVendorList(List<SelectItem> vendorList) {
		this.vendorList = vendorList;
	}
	public List<SelectItem> getPayeeList() {
		return payeeList;
	}
	public void setPayeeList(List<SelectItem> payeeList) {
		this.payeeList = payeeList;
	}
	public List<SelectItem> getExpenseTypeList() {
		return expenseTypeList;
	}
	public void setExpenseTypeList(List<SelectItem> expenseTypeList) {
		this.expenseTypeList = expenseTypeList;
	}
	public List<SelectItem> getExpenseTypeListCreate() {
		return expenseTypeListCreate;
	}
	public void setExpenseTypeListCreate(List<SelectItem> expenseTypeListCreate) {
		this.expenseTypeListCreate = expenseTypeListCreate;
	}
	public boolean isChkClickCal() {
		return chkClickCal;
	}
	public void setChkClickCal(boolean chkClickCal) {
		this.chkClickCal = chkClickCal;
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
	public boolean isRenderedOnToDoList() {
		return renderedOnToDoList;
	}
	public void setRenderedOnToDoList(boolean renderedOnToDoList) {
		this.renderedOnToDoList = renderedOnToDoList;
	}

}
