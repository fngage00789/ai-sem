package th.co.ais.web.rt.bean;

import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.rt.CheckVendor;
import th.co.ais.domain.rt.Mrt003Cal;
import th.co.ais.domain.rt.MrtGetRunningNo;
import th.co.ais.domain.rt.RentalPayNormalEditSaveSP;
import th.co.ais.domain.rt.RentalPayNormalSaveActSP;
import th.co.ais.domain.rt.RentalPayNormalSaveSP;
import th.co.ais.domain.rt.RentalPayNormalSearchSP;
import th.co.ais.domain.rt.RentalPayNormalSearchDSP;
import th.co.ais.domain.rt.RentalPayment;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMRT004Bean extends AbstractBean{
	
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
	
	private RentalPayment rentalPayment;
	private CheckVendor checkVendor;
	
	private boolean chkDeposit;
	private String validatePopup;
	private String rowId;
	private String paymentGroupno;
	private boolean validateBtn;
	private Date tmpChqDt;
	private Date tmpChqReceiveDt;
	private Date tmpTransferDt;
	private String btnApproveStatus;
	private String remark;
	private String popupName;
	private String periodNo;
	private String btnStatus;
	private boolean displayShowExcel;
	
	private String confirmCoppyDateMsg;
	
	private boolean chkSelAll = false;
	private boolean disabledBtnExport=true;
	
	private List<MrtGetRunningNo> mrtGetRunningNoList;
	private MrtGetRunningNo mrtGetRunningNo;
	
	private Mrt003Cal mrt003Cal;
	private Double tmpPaymentAmt;
	
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
	
	private boolean renderedBtnHExport;
	private boolean renderedBtnA4JExport;
	private String msgHeaderPopup1;
	private String msgHeaderPopup2;
	
	//for rendered field Seacrh 3 feild
	private boolean tmpGroup1;
	
	//for rendered field Seacrh 1 feild
	private boolean tmpGroup2;
	
	private boolean renderedBtnExportShowError = false;
	
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
	public List<RentalPayNormalSearchDSP> getRentalPayNormalSearchDSPList() {
		return rentalPayNormalSearchDSPList;
	}
	public void setRentalPayNormalSearchDSPList(
			List<RentalPayNormalSearchDSP> rentalPayNormalSearchDSPList) {
		this.rentalPayNormalSearchDSPList = rentalPayNormalSearchDSPList;
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
	public RentalPayNormalSearchDSP getRentalPayNormalSearchDSP() {
		return rentalPayNormalSearchDSP;
	}
	public void setRentalPayNormalSearchDSP(
			RentalPayNormalSearchDSP rentalPayNormalSearchDSP) {
		this.rentalPayNormalSearchDSP = rentalPayNormalSearchDSP;
	}
	public void setPaymentMethodList(List<SelectItem> paymentMethodList) {
		this.paymentMethodList = paymentMethodList;
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
	public void setRentalPayNormalSearchSPList(
			List<WrapperBeanObject<RentalPayNormalSearchSP>> rentalPayNormalSearchSPList) {
		this.rentalPayNormalSearchSPList = rentalPayNormalSearchSPList;
	}
	public List<WrapperBeanObject<RentalPayNormalSearchSP>> getRentalPayNormalSearchSPList() {
		return rentalPayNormalSearchSPList;
	}
	public boolean isRenderedMsgFormSearch() {
		return renderedMsgFormSearch;
	}
	public void setRenderedMsgFormSearch(boolean renderedMsgFormSearch) {
		this.renderedMsgFormSearch = renderedMsgFormSearch;
	}
	public boolean isRenderedMsgFormPopup() {
		return renderedMsgFormPopup;
	}
	public void setRenderedMsgFormPopup(boolean renderedMsgFormPopup) {
		this.renderedMsgFormPopup = renderedMsgFormPopup;
	}
	public boolean isRenderedDepositAmt() {
		return renderedDepositAmt;
	}
	public void setRenderedDepositAmt(boolean renderedDepositAmt) {
		this.renderedDepositAmt = renderedDepositAmt;
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
	public boolean isRenderedPaymentMethod() {
		return renderedPaymentMethod;
	}
	public void setRenderedPaymentMethod(boolean renderedPaymentMethod) {
		this.renderedPaymentMethod = renderedPaymentMethod;
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
	public void setBtnStatus(String btnStatus) {
		this.btnStatus = btnStatus;
	}
	public String getBtnStatus() {
		return btnStatus;
	}
	public List<MrtGetRunningNo> getMrtGetRunningNoList() {
		return mrtGetRunningNoList;
	}
	public void setMrtGetRunningNoList(List<MrtGetRunningNo> mrtGetRunningNoList) {
		this.mrtGetRunningNoList = mrtGetRunningNoList;
	}
	public MrtGetRunningNo getMrtGetRunningNo() {
		return mrtGetRunningNo;
	}
	public void setMrtGetRunningNo(MrtGetRunningNo mrtGetRunningNo) {
		this.mrtGetRunningNo = mrtGetRunningNo;
	}
	public Mrt003Cal getMrt003Cal() {
		return mrt003Cal;
	}
	public void setMrt003Cal(Mrt003Cal mrt003Cal) {
		this.mrt003Cal = mrt003Cal;
	}
	public boolean isChkSelAll() {
		return chkSelAll;
	}
	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}
	public boolean isDisabledBtnExport() {
		return disabledBtnExport;
	}
	public void setDisabledBtnExport(boolean disabledBtnExport) {
		this.disabledBtnExport = disabledBtnExport;
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
	public Double getOldTotalAmt() {
		return oldTotalAmt;
	}
	public void setOldTotalAmt(Double oldTotalAmt) {
		this.oldTotalAmt = oldTotalAmt;
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
	
	
}
