package th.co.ais.web.pt.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.domain.pt.Mpt004Act;
import th.co.ais.domain.pt.Mpt004Cal;
import th.co.ais.domain.pt.Mpt004Chk;
import th.co.ais.domain.pt.Mpt004Edt;
import th.co.ais.domain.pt.Mpt004Pay;
import th.co.ais.domain.pt.Mpt004Srch;
import th.co.ais.domain.pt.Mpt004SrchD;
import th.co.ais.domain.pt.PtaxPayment;
import th.co.ais.domain.pt.Mpt004SrchC;
import th.co.ais.domain.rt.MrtGetRunningNo;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMPT004Bean extends AbstractBean {

	private List<SelectItem> companyList;
	private List<SelectItem> pTaxYearFromList;
	private List<SelectItem> pTaxYearToList;
	private List<SelectItem> periodFromList;
	private List<SelectItem> periodToList;
	private List<SelectItem> pTaxPayTypeList;
	private List<SelectItem> expenseTypeList;
	private List<SelectItem> provinceList;
	private List<SelectItem> paymentTypeList;
	private List<SelectItem> paymentMethodList;
	private List<SelectItem> docTypeList;
	private List<SelectItem> penaltyTypeList;
	private List<SelectItem> monthFromList;
	private List<SelectItem> monthToList;
	private List<SelectItem> whtRateList;
	private List<SelectItem> govtList;
	private List<SelectItem> regionList;
	private List<SelectItem> amphurList;
	private List<SelectItem> paymentStatusList;

	private List<WrapperBeanObject<Mpt004Srch>> mpt004SrchList;
	private Mpt004Srch mpt004Srch;

	private List<Mpt004Pay> mpt004PayList;
	private Mpt004Pay mpt004Pay;

	private List<Mpt004Act> mpt004ActList;
	private Mpt004Act mpt004Act;

	private List<Mpt004SrchD> mpt004SrchDList;
	private Mpt004SrchD mpt004SrchD;

	private Mpt004Chk mpt004Chk;
	private Mpt004Edt mpt004Edt;
	private Mpt004Cal mpt004Cal;
	private Mpt004SrchC mpt004SrchC;

	private PtaxPayment pTaxpayment;
	private boolean chkPayGovtFlag;

	private boolean validateBtn;
	private String btnApproveStatus;
	private String remark;
	private String popupName;
	private String confirmCoppyDateMsg;
	private Date tmpChqDt;
	private Date tmpChqReceiveDt;
	private Date tmpTransferDt;

	private boolean renderLinkPayGovtFlag;
	private boolean renderCldChqDt;
	private boolean renderCldChqReceiveDt;
	private boolean renderCldTransferDt;
	private boolean renderContractNo;
	private boolean renderdateFrom;

	private String payPeriod03;
	private String payPeriod04;
	private String payPeriodType01;
	private String payPeriodType02;
	private String payPeriodType03;
	private String payPeriodType04;

	private String payPeriodType05;
	private boolean displayShowExcel;
	private boolean chkSelAll = false;
	private boolean disabledBtnExport = true;
	private boolean renderedBtnExportShowError = false;
	private boolean renderedBtnHExport;

	// Render Calender chqDt or TransferDT
	private boolean renderedChqDt;
	private boolean renderedChqReceiveDt;
	private boolean renderedTransferDt;
	private boolean renderedPaymentMethod;

	private String btnStatus;

	// get Running No
	private List<MrtGetRunningNo> mrtGetRunningNoList;
	private MrtGetRunningNo mrtGetRunningNo;

	// excAmt vatAmt whtAmt for (+ - 1)
	private Double oldExcAmt;
	private Double oldVatAmt;
	private Double oldWhtAmt;
	private Double oldIncAmt;
	private Double oldchqAmt;

	private boolean renderedBtnSave;

	private boolean disableMonth;
	private boolean disableYear;
	private boolean disableWhtRate;

	// flag check renderMessage for panel
	private boolean msgTop;
	private boolean pnlContractInfo;
	private boolean pnlPayInfo;
	private boolean pnlDetailPay;
	private boolean pnlPayment;

	private boolean showPopupContract;
	private String concatContractNo;
	private boolean disablePaneltyType;
	private boolean disableVatAndWhtType;
	private boolean disablePtaxYear;
	private boolean tmpPayGovtFlag;
	private boolean disableMonthFrom;
	private boolean requireDocVat;
	
	private HashMap tmpChkBox;
	private boolean changeWhtRateFlag = false;
	
	private boolean renderedOnToDoList;

	// popup add vendor
	public List<WrapperBeanObject<VendorMasterSP>> vendorMasterPopupList;
	private VendorMasterSP vendorMasterPopupObjParam;
	
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

	public List<SelectItem> getpTaxYearFromList() {
		return pTaxYearFromList;
	}

	public void setpTaxYearFromList(List<SelectItem> pTaxYearFromList) {
		this.pTaxYearFromList = pTaxYearFromList;
	}

	public List<SelectItem> getpTaxYearToList() {
		return pTaxYearToList;
	}

	public void setpTaxYearToList(List<SelectItem> pTaxYearToList) {
		this.pTaxYearToList = pTaxYearToList;
	}

	public List<SelectItem> getPeriodFromList() {
		return periodFromList;
	}

	public void setPeriodFromList(List<SelectItem> periodFromList) {
		this.periodFromList = periodFromList;
	}

	public List<SelectItem> getPeriodToList() {
		return periodToList;
	}

	public void setPeriodToList(List<SelectItem> periodToList) {
		this.periodToList = periodToList;
	}

	public List<SelectItem> getpTaxPayTypeList() {
		return pTaxPayTypeList;
	}

	public void setpTaxPayTypeList(List<SelectItem> pTaxPayTypeList) {
		this.pTaxPayTypeList = pTaxPayTypeList;
	}

	public List<SelectItem> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<SelectItem> provinceList) {
		this.provinceList = provinceList;
	}

	public Mpt004Srch getMpt004Srch() {
		return mpt004Srch;
	}

	public List<Mpt004SrchD> getMpt004SrchDList() {
		return mpt004SrchDList;
	}

	public void setMpt004SrchDList(List<Mpt004SrchD> mpt004SrchDList) {
		this.mpt004SrchDList = mpt004SrchDList;
	}

	public Mpt004SrchD getMpt004SrchD() {
		return mpt004SrchD;
	}

	public void setMpt004SrchD(Mpt004SrchD mpt004SrchD) {
		this.mpt004SrchD = mpt004SrchD;
	}

	public void setMpt004Srch(Mpt004Srch mpt004Srch) {
		this.mpt004Srch = mpt004Srch;
	}

	public List<SelectItem> getMonthFromList() {
		return monthFromList;
	}

	public void setMonthFromList(List<SelectItem> monthFromList) {
		this.monthFromList = monthFromList;
	}

	public List<SelectItem> getMonthToList() {
		return monthToList;
	}

	public void setMonthToList(List<SelectItem> monthToList) {
		this.monthToList = monthToList;
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

	public void setExpenseTypeList(List<SelectItem> expenseTypeList) {
		this.expenseTypeList = expenseTypeList;
	}

	public List<SelectItem> getExpenseTypeList() {
		return expenseTypeList;
	}

	public void setPaymentTypeList(List<SelectItem> paymentTypeList) {
		this.paymentTypeList = paymentTypeList;
	}

	public List<SelectItem> getPaymentTypeList() {
		return paymentTypeList;
	}

	public List<SelectItem> getPaymentMethodList() {
		return paymentMethodList;
	}

	public void setPaymentMethodList(List<SelectItem> paymentMethodList) {
		this.paymentMethodList = paymentMethodList;
	}

	public void setValidateBtn(boolean validateBtn) {
		this.validateBtn = validateBtn;
	}

	public List<Mpt004Act> getMpt004ActList() {
		return mpt004ActList;
	}

	public void setMpt004ActList(List<Mpt004Act> mpt004ActList) {
		this.mpt004ActList = mpt004ActList;
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

	public String getPopupName() {
		return popupName;
	}

	public void setPopupName(String popupName) {
		this.popupName = popupName;
	}

	public String getConfirmCoppyDateMsg() {
		return confirmCoppyDateMsg;
	}

	public void setConfirmCoppyDateMsg(String confirmCoppyDateMsg) {
		this.confirmCoppyDateMsg = confirmCoppyDateMsg;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Mpt004Act getMpt004Act() {
		return mpt004Act;
	}

	public void setMpt004Act(Mpt004Act mpt004Act) {
		this.mpt004Act = mpt004Act;
	}

	public boolean isValidateBtn() {
		return validateBtn;
	}

	public List<Mpt004Pay> getMpt004PayList() {
		return mpt004PayList;
	}

	public void setMpt004PayList(List<Mpt004Pay> mpt004PayList) {
		this.mpt004PayList = mpt004PayList;
	}

	public Mpt004Pay getMpt004Pay() {
		return mpt004Pay;
	}

	public void setMpt004Pay(Mpt004Pay mpt004Pay) {
		this.mpt004Pay = mpt004Pay;
	}

	public void setpTaxpayment(PtaxPayment pTaxpayment) {
		this.pTaxpayment = pTaxpayment;
	}

	public PtaxPayment getpTaxpayment() {
		return pTaxpayment;
	}

	public void setBtnApproveStatus(String btnApproveStatus) {
		this.btnApproveStatus = btnApproveStatus;
	}

	public String getBtnApproveStatus() {
		return btnApproveStatus;
	}

	public void setDocTypeList(List<SelectItem> docTypeList) {
		this.docTypeList = docTypeList;
	}

	public List<SelectItem> getDocTypeList() {
		return docTypeList;
	}

	public boolean isRenderCldChqDt() {
		return renderCldChqDt;
	}

	public void setRenderCldChqDt(boolean renderCldChqDt) {
		this.renderCldChqDt = renderCldChqDt;
	}

	public boolean isRenderCldTransferDt() {
		return renderCldTransferDt;
	}

	public void setRenderCldTransferDt(boolean renderCldTransferDt) {
		this.renderCldTransferDt = renderCldTransferDt;
	}

	public void setPenaltyTypeList(List<SelectItem> penaltyTypeList) {
		this.penaltyTypeList = penaltyTypeList;
	}

	public List<SelectItem> getPenaltyTypeList() {
		return penaltyTypeList;
	}

	public void setChkPayGovtFlag(boolean chkPayGovtFlag) {
		this.chkPayGovtFlag = chkPayGovtFlag;
	}

	public boolean isChkPayGovtFlag() {
		return chkPayGovtFlag;
	}

	public void setRenderLinkPayGovtFlag(boolean renderLinkPayGovtFlag) {
		this.renderLinkPayGovtFlag = renderLinkPayGovtFlag;
	}

	public boolean isRenderLinkPayGovtFlag() {
		return renderLinkPayGovtFlag;
	}

	public void setRenderContractNo(boolean renderContractNo) {
		this.renderContractNo = renderContractNo;
	}

	public boolean isRenderContractNo() {
		return renderContractNo;
	}

	public void setRenderdateFrom(boolean renderdateFrom) {
		this.renderdateFrom = renderdateFrom;
	}

	public boolean isRenderdateFrom() {
		return renderdateFrom;
	}

	public void setMpt004SrchList(
			List<WrapperBeanObject<Mpt004Srch>> mpt004SrchList) {
		this.mpt004SrchList = mpt004SrchList;
	}

	public List<WrapperBeanObject<Mpt004Srch>> getMpt004SrchList() {
		return mpt004SrchList;
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

	public void setBtnStatus(String btnStatus) {
		this.btnStatus = btnStatus;
	}

	public String getBtnStatus() {
		return btnStatus;
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

	public Mpt004Chk getMpt004Chk() {
		return mpt004Chk;
	}

	public void setMpt004Chk(Mpt004Chk mpt004Chk) {
		this.mpt004Chk = mpt004Chk;
	}

	public Mpt004Edt getMpt004Edt() {
		return mpt004Edt;
	}

	public void setMpt004Edt(Mpt004Edt mpt004Edt) {
		this.mpt004Edt = mpt004Edt;
	}

	public void setRenderedBtnSave(boolean renderedBtnSave) {
		this.renderedBtnSave = renderedBtnSave;
	}

	public boolean isRenderedBtnSave() {
		return renderedBtnSave;
	}

	public Double getOldIncAmt() {
		return oldIncAmt;
	}

	public void setOldIncAmt(Double oldIncAmt) {
		this.oldIncAmt = oldIncAmt;
	}

	public Double getOldchqAmt() {
		return oldchqAmt;
	}

	public void setOldchqAmt(Double oldchqAmt) {
		this.oldchqAmt = oldchqAmt;
	}

	public void setMpt004Cal(Mpt004Cal mpt004Cal) {
		this.mpt004Cal = mpt004Cal;
	}

	public Mpt004Cal getMpt004Cal() {
		return mpt004Cal;
	}

	public boolean isDisableMonth() {
		return disableMonth;
	}

	public void setDisableMonth(boolean disableMonth) {
		this.disableMonth = disableMonth;
	}

	public boolean isDisableYear() {
		return disableYear;
	}

	public void setDisableYear(boolean disableYear) {
		this.disableYear = disableYear;
	}

	public void setDisableWhtRate(boolean disableWhtRate) {
		this.disableWhtRate = disableWhtRate;
	}

	public boolean isDisableWhtRate() {
		return disableWhtRate;
	}

	public void setWhtRateList(List<SelectItem> whtRateList) {
		this.whtRateList = whtRateList;
	}

	public List<SelectItem> getWhtRateList() {
		return whtRateList;
	}

	public String getPayPeriod03() {
		return payPeriod03;
	}

	public void setPayPeriod03(String payPeriod03) {
		this.payPeriod03 = payPeriod03;
	}

	public String getPayPeriod04() {
		return payPeriod04;
	}

	public void setPayPeriod04(String payPeriod04) {
		this.payPeriod04 = payPeriod04;
	}

	public boolean isPnlContractInfo() {
		return pnlContractInfo;
	}

	public void setPnlContractInfo(boolean pnlContractInfo) {
		this.pnlContractInfo = pnlContractInfo;
	}

	public boolean isPnlPayInfo() {
		return pnlPayInfo;
	}

	public void setPnlPayInfo(boolean pnlPayInfo) {
		this.pnlPayInfo = pnlPayInfo;
	}

	public boolean isPnlDetailPay() {
		return pnlDetailPay;
	}

	public void setPnlDetailPay(boolean pnlDetailPay) {
		this.pnlDetailPay = pnlDetailPay;
	}

	public boolean isPnlPayment() {
		return pnlPayment;
	}

	public void setPnlPayment(boolean pnlPayment) {
		this.pnlPayment = pnlPayment;
	}

	public void setMsgTop(boolean msgTop) {
		this.msgTop = msgTop;
	}

	public boolean isMsgTop() {
		return msgTop;
	}

	public void setMpt004SrchC(Mpt004SrchC mpt004SrchC) {
		this.mpt004SrchC = mpt004SrchC;
	}

	public Mpt004SrchC getMpt004SrchC() {
		return mpt004SrchC;
	}

	public void setShowPopupContract(boolean showPopupContract) {
		this.showPopupContract = showPopupContract;
	}

	public boolean isShowPopupContract() {
		return showPopupContract;
	}

	public void setConcatContractNo(String concatContractNo) {
		this.concatContractNo = concatContractNo;
	}

	public String getConcatContractNo() {
		return concatContractNo;
	}

	public void setDisablePaneltyType(boolean disablePaneltyType) {
		this.disablePaneltyType = disablePaneltyType;
	}

	public boolean isDisablePaneltyType() {
		return disablePaneltyType;
	}

	public List<SelectItem> getGovtList() {
		return govtList;
	}

	public void setGovtList(List<SelectItem> govtList) {
		this.govtList = govtList;
	}

	public void setDisableVatAndWhtType(boolean disableVatAndWhtType) {
		this.disableVatAndWhtType = disableVatAndWhtType;
	}

	public boolean isDisableVatAndWhtType() {
		return disableVatAndWhtType;
	}

	public void setDisablePtaxYear(boolean disablePtaxYear) {
		this.disablePtaxYear = disablePtaxYear;
	}

	public boolean isDisablePtaxYear() {
		return disablePtaxYear;
	}

	/**
	 * @param regionList the regionList to set
	 */
	public void setRegionList(List<SelectItem> regionList) {
		this.regionList = regionList;
	}

	/**
	 * @return the regionList
	 */
	public List<SelectItem> getRegionList() {
		return regionList;
	}

	/**
	 * @param amphurList the amphurList to set
	 */
	public void setAmphurList(List<SelectItem> amphurList) {
		this.amphurList = amphurList;
	}

	/**
	 * @return the amphurList
	 */
	public List<SelectItem> getAmphurList() {
		return amphurList;
	}

	/**
	 * @param tmpPayGovtFlag the tmpPayGovtFlag to set
	 */
	public void setTmpPayGovtFlag(boolean tmpPayGovtFlag) {
		this.tmpPayGovtFlag = tmpPayGovtFlag;
	}

	/**
	 * @return the tmpPayGovtFlag
	 */
	public boolean isTmpPayGovtFlag() {
		return tmpPayGovtFlag;
	}

	/**
	 * @param disableMonthFrom the disableMonthFrom to set
	 */
	public void setDisableMonthFrom(boolean disableMonthFrom) {
		this.disableMonthFrom = disableMonthFrom;
	}

	/**
	 * @return the disableMonthFrom
	 */
	public boolean isDisableMonthFrom() {
		return disableMonthFrom;
	}

	public boolean isRequireDocVat() {
		return requireDocVat;
	}

	public void setRequireDocVat(boolean requireDocVat) {
		this.requireDocVat = requireDocVat;
	}

	public boolean isDisplayShowExcel() {
		return displayShowExcel;
	}

	public void setDisplayShowExcel(boolean displayShowExcel) {
		this.displayShowExcel = displayShowExcel;
	}

	public List<SelectItem> getPaymentStatusList() {
		return paymentStatusList;
	}

	public void setPaymentStatusList(List<SelectItem> paymentStatusList) {
		this.paymentStatusList = paymentStatusList;
	}

	public boolean isRenderedBtnExportShowError() {
		return renderedBtnExportShowError;
	}

	public void setRenderedBtnExportShowError(boolean renderedBtnExportShowError) {
		this.renderedBtnExportShowError = renderedBtnExportShowError;
	}

	public HashMap getTmpChkBox() {
		return tmpChkBox;
	}

	public void setTmpChkBox(HashMap tmpChkBox) {
		this.tmpChkBox = tmpChkBox;
	}

	public boolean isRenderedBtnHExport() {
		return renderedBtnHExport;
	}

	public void setRenderedBtnHExport(boolean renderedBtnHExport) {
		this.renderedBtnHExport = renderedBtnHExport;
	}

	public boolean isChangeWhtRateFlag() {
		return changeWhtRateFlag;
	}

	public void setChangeWhtRateFlag(boolean changeWhtRateFlag) {
		this.changeWhtRateFlag = changeWhtRateFlag;
	}

	public boolean isRenderedChqReceiveDt() {
		return renderedChqReceiveDt;
	}

	public void setRenderedChqReceiveDt(boolean renderedChqReceiveDt) {
		this.renderedChqReceiveDt = renderedChqReceiveDt;
	}

	public boolean isRenderCldChqReceiveDt() {
		return renderCldChqReceiveDt;
	}

	public void setRenderCldChqReceiveDt(boolean renderCldChqReceiveDt) {
		this.renderCldChqReceiveDt = renderCldChqReceiveDt;
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

	public boolean isRenderedOnToDoList() {
		return renderedOnToDoList;
	}

	public void setRenderedOnToDoList(boolean renderedOnToDoList) {
		this.renderedOnToDoList = renderedOnToDoList;
	}
	
}
