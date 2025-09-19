package th.co.ais.web.rt.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.rt.CheckVendor;
import th.co.ais.domain.rt.MrtGetRunningNo;
import th.co.ais.domain.rt.RentalPayNormalEditSaveSP;
import th.co.ais.domain.rt.RentalPayNormalSaveActSP;
import th.co.ais.domain.rt.RentalPayNormalSaveSP;
import th.co.ais.domain.rt.RentalPayNormalSearchDSP;
import th.co.ais.domain.rt.RentalPayNormalSearchSP;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMRT001PayBean extends AbstractBean{

	private List<SelectItem> paymentTypeList;
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
	private CheckVendor checkVendor;
	
	//Render message form Popup
	private boolean renderedMsgFormPopup = true;
	private boolean disabledBtnExport=true;
	private boolean chkSelAll = false;
	private boolean chkDeposit;
	private String paymentGroupno;
	private String validatePopup;
	private String rowId;
	private String btnApproveStatus;
	private String btnStatus;
	private MrtGetRunningNo mrtGetRunningNo;
	
	private String tmpContractNo;
	private String pageMode;
	
	//excAmt vatAmt whtAmt for (+ - 1)
	private Double oldExcAmt;
	private Double oldVatAmt;
	private Double oldWhtAmt;
	private Double oldIncAmt;
	private Double oldTotalAmt;
	
	//Render Calender chqDt or TransferDT
	private boolean renderedChqDt;
	private boolean renderedTransferDt;
	private boolean renderedPaymentMethod;
	
	//Render DepositAmt
	private boolean renderedDepositAmt;
	
	//Render Date Month Year
	private boolean renderedMonth;
	private boolean renderedYear;
	
	//Render VatRat and WhtRate
	private boolean renderedvatRate;
	private boolean renderedWhtRate;
	
	private String remark;
	
	private Double tmpDepositAmt;
	private String msgHeaderPopup1;
	private String msgHeaderPopup2;
	
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public List<SelectItem> getPaymentTypeList() {
		return paymentTypeList;
	}
	public void setPaymentTypeList(List<SelectItem> paymentTypeList) {
		this.paymentTypeList = paymentTypeList;
	}
	public List<SelectItem> getPaymentMethodList() {
		return paymentMethodList;
	}
	public void setPaymentMethodList(List<SelectItem> paymentMethodList) {
		this.paymentMethodList = paymentMethodList;
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
	public void setDayPermonthList(List<SelectItem> dayPermonthList) {
		this.dayPermonthList = dayPermonthList;
	}
	public List<SelectItem> getVatTypeList() {
		return vatTypeList;
	}
	public void setVatTypeList(List<SelectItem> vatTypeList) {
		this.vatTypeList = vatTypeList;
	}
	public List<WrapperBeanObject<RentalPayNormalSearchSP>> getRentalPayNormalSearchSPList() {
		return rentalPayNormalSearchSPList;
	}
	public void setRentalPayNormalSearchSPList(
			List<WrapperBeanObject<RentalPayNormalSearchSP>> rentalPayNormalSearchSPList) {
		this.rentalPayNormalSearchSPList = rentalPayNormalSearchSPList;
	}
	public RentalPayNormalSearchSP getRentalPayNormalSearchSP() {
		return rentalPayNormalSearchSP;
	}
	public void setRentalPayNormalSearchSP(
			RentalPayNormalSearchSP rentalPayNormalSearchSP) {
		this.rentalPayNormalSearchSP = rentalPayNormalSearchSP;
	}
	public void setDisabledBtnExport(boolean disabledBtnExport) {
		this.disabledBtnExport = disabledBtnExport;
	}
	public boolean isDisabledBtnExport() {
		return disabledBtnExport;
	}
	public boolean isChkSelAll() {
		return chkSelAll;
	}
	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
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
	public void setChkDeposit(boolean chkDeposit) {
		this.chkDeposit = chkDeposit;
	}
	public boolean isChkDeposit() {
		return chkDeposit;
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
	public boolean isRenderedDepositAmt() {
		return renderedDepositAmt;
	}
	public void setRenderedDepositAmt(boolean renderedDepositAmt) {
		this.renderedDepositAmt = renderedDepositAmt;
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
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRemark() {
		return remark;
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
	public List<RentalPayNormalEditSaveSP> getRentalPayNormalEditSaveSPList() {
		return rentalPayNormalEditSaveSPList;
	}
	public void setRentalPayNormalEditSaveSPList(
			List<RentalPayNormalEditSaveSP> rentalPayNormalEditSaveSPList) {
		this.rentalPayNormalEditSaveSPList = rentalPayNormalEditSaveSPList;
	}
	public RentalPayNormalEditSaveSP getRentalPayNormalEditSaveSP() {
		return rentalPayNormalEditSaveSP;
	}
	public void setRentalPayNormalEditSaveSP(
			RentalPayNormalEditSaveSP rentalPayNormalEditSaveSP) {
		this.rentalPayNormalEditSaveSP = rentalPayNormalEditSaveSP;
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
	public void setRentalPayNormalSaveActSP(
			RentalPayNormalSaveActSP rentalPayNormalSaveActSP) {
		this.rentalPayNormalSaveActSP = rentalPayNormalSaveActSP;
	}
	public void setPaymentGroupno(String paymentGroupno) {
		this.paymentGroupno = paymentGroupno;
	}
	public String getPaymentGroupno() {
		return paymentGroupno;
	}
	public void setValidatePopup(String validatePopup) {
		this.validatePopup = validatePopup;
	}
	public String getValidatePopup() {
		return validatePopup;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getRowId() {
		return rowId;
	}
	public void setBtnApproveStatus(String btnApproveStatus) {
		this.btnApproveStatus = btnApproveStatus;
	}
	public String getBtnApproveStatus() {
		return btnApproveStatus;
	}
	public void setBtnStatus(String btnStatus) {
		this.btnStatus = btnStatus;
	}
	public String getBtnStatus() {
		return btnStatus;
	}
	public void setTmpContractNo(String tmpContractNo) {
		this.tmpContractNo = tmpContractNo;
	}
	public String getTmpContractNo() {
		return tmpContractNo;
	}
	public void setPageMode(String pageMode) {
		this.pageMode = pageMode;
	}
	public String getPageMode() {
		return pageMode;
	}
	public void setTmpDepositAmt(Double tmpDepositAmt) {
		this.tmpDepositAmt = tmpDepositAmt;
	}
	public Double getTmpDepositAmt() {
		return tmpDepositAmt;
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
	public void setRenderedMsgFormPopup(boolean renderedMsgFormPopup) {
		this.renderedMsgFormPopup = renderedMsgFormPopup;
	}
	public boolean isRenderedMsgFormPopup() {
		return renderedMsgFormPopup;
	}
	public MrtGetRunningNo getMrtGetRunningNo() {
		return mrtGetRunningNo;
	}
	public void setMrtGetRunningNo(MrtGetRunningNo mrtGetRunningNo) {
		this.mrtGetRunningNo = mrtGetRunningNo;
	}
}
