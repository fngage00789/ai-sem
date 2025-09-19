package th.co.ais.domain.el;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import th.co.ais.domain.gm.BgMasterSP;

public class ManagementWrapper implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -621681872820458776L;

	public ManagementWrapper(Management electricManage){
		
		this.electricManage = electricManage;
	}
	
	public ManagementWrapper(ManagementSP electricManageSP){
		
		this.electricManageSP = electricManageSP;
	}
	
	public ManagementWrapper(ManagementSO electricManageSO){
		
		this.electricManageSO = electricManageSO;
	}
	
	public ManagementWrapper(Management electricManage, BgMaster bgMaster){
		
		this.electricManage = electricManage;
		this.bgMaster = bgMaster;
	}
	
	public ManagementWrapper(ManagementSP electricManage, ElBgMasterSP bgMasterSP){
		
		this.electricManageSP = electricManage;
		this.bgMasterSP = bgMasterSP;
	}
	
	public ManagementWrapper(Payment electricPayment){	
		
		this.electricPayment = electricPayment;
	}

	public ManagementWrapper(Payment electricPayment, PaymentDetail electricPaymentDetail){
	
		this.electricPayment = electricPayment;
		this.electricPaymentDetail = electricPaymentDetail;
	}
	
	public ManagementWrapper(ELVerifyCondSP verifyCondSP) {
		this.verifyCondSP = verifyCondSP;
	}
	
	public ManagementWrapper(ELDpstCondSP dpstCondSP) {
		this.dpstCondSP = dpstCondSP;
	}
	
	// page 1
	private Management electricManage;
	private ManagementSP electricManageSP;
	private ManagementSO electricManageSO;
	private ELVerifyCondSP verifyCondSP;
	private ELDpstCondSP dpstCondSP;
	
	private boolean selected;
	
	private String regionLabel;
	private String provinceLabel;
	private String siteStatusLabel;
	private String electricUseTypeLabel;
	private String processStatusLabel;
	private String networkStatusLabel;
	private String amphurLabel;
	private String contractNoUrl;
	private String bgUrl;
	private String depositTypeBgNo;
	private String verifyNavProgram;
	private String verifyPage;
	private String zoneLabel;
	private boolean receiveJobButtonVisible;
	private boolean verifyButtonVisible;
	private boolean depositTypeLabelVisible;
	private boolean saveDepositButtonVisible;
	private boolean printButtonVisible;
	private boolean rePrintButtonVisible;
	private boolean privateCaseFlagCheckboxVisible;
	private boolean updateStatusButtonVisible;
	private boolean expandFlagCheckboxVisible;
	private boolean withdrawalButtonVisible;
	private boolean updateMeterInfoButtonVisible;
	
	// page 2
	private BgMaster bgMaster;
	private ElBgMasterSP bgMasterSP;
	private String createBy;
	private String createDt;
	private String updateDt;
	private String updateBy;
	
	private boolean transferFlagCheckboxDisable;
	private boolean bgNoFullVisible;
	private boolean newReceivedDtCalendarDisable;
	private boolean newReceivedDtCalendarMandatory;
	private boolean terminateReceivedDtCalendarDisable;
	private boolean terminateReceivedDtCalendarMandatory;
	private boolean electricUseTypeSelectDisable;
	
	// page 3
	private List<BgMaster> bgDepositDetailList;
	private List<DepositDetail> cashDepositDetailList;
	private List<MeterInstallment> meterInstallmentList;
	private List<MeterInstallment> selectedMeterInstallmentList;
	
	private boolean transferMeterDtCalendarDisable;
	
	// page 4
	private PrivateDepositDetail privateDepositDetail;
	private List<PrivateDepositDetail> bgPrivateDepositList;
	private List<PrivateDepositDetail> cashPrivateDepositList;
	
	private boolean pPeriodTypePerMonthInputTextVisible;
	private boolean pPeriodTypePerYearInputTextVisible;
	private boolean pTakeAllPeriodTypeYearVisible;
	
	// page 7-12
	private String editItemId;
	private List<Payment> electricPaymentList;
	private Payment electricPayment;
	private PaymentDetail electricPaymentDetail;	
	private List<PaymentDetail> paymentDetailList;
	private String expenseTypeDisplay;
	private String paymentDetailPeriodMonth;
	private String paymentDetailPeriodYear;
	private String approveDtDisplay;
	private WarrantDatail warrantDatail;
	private MeterInfo meterInfo;
	private String vatTypeTxt;
	private String selectedPrivateDepositIndex;
	private PrivateDeposit privateDeposit;
	
	// page 8
	private String bgTypeLabel;
	private List<PrivateDeposit> privateDepositList;
	private ManagementMaster managementMaster;
	
	// page 13
	private String newReceivedDtLabel;
	private String newPrintDtLabel;
	private String terminatedReceivedDtLabel;
	private String terminatePrintDtLabel;
	private String expandReceivedDtLabel;
	private String expandPrintDtLabel;
	private String transferReceivedDtLabel;
	private String transferPrintDtLabel;
	private MeterInfo meterInfoMeaPea;
	private MeterInfo meterInfoPrivate;
	private String lastTermOfPaymentDtLabel;
	
	private boolean disableMeaPeaUpdateButton;
	private boolean disableMeaPeaAddButton;
	private boolean disablePrivateUpdateButton;
	private boolean disablePrivateAddButton;
	private boolean disableElectricCloseDt;
	private boolean disableElectricTerminateDt;
	private boolean disableMeaPea;
	private boolean disablePrivate;
	private boolean disablePrivateEditMode;
	private boolean disablePOffMeterDt;
	private boolean firstPaidFlag;
	//WT###Add 20110220 Start
	private boolean disableTransferMeterDt;
	private boolean disableTerminateCutoffDt;
	private boolean disableExpandOldCutoffDt;
	private boolean disableExpandNewOnmeterDt;
	private boolean disableTransferCutoffDt;
	private boolean disablePOnMeterDt;
	//WT###Add 20110220 End

	private Payment histPayment;
	private PaymentDetail histPaymentDetail;
	//---------------------------------------
	private String meterIdDisplay;
	private String eAreaCodeDisplay;
	private String eAreaNameDisplay;
	private String recordStatusDisplay;
	private String meterRefIdDisplay;
	private String amphurDisplay;
	
	
	private String contractStatus;
	
	
	public String getExpandReceivedDtLabel() {
		return expandReceivedDtLabel;
	}

	public void setExpandReceivedDtLabel(String expandReceivedDtLabel) {
		this.expandReceivedDtLabel = expandReceivedDtLabel;
	}

	public String getExpandPrintDtLabel() {
		return expandPrintDtLabel;
	}

	public void setExpandPrintDtLabel(String expandPrintDtLabel) {
		this.expandPrintDtLabel = expandPrintDtLabel;
	}

	public String getTransferReceivedDtLabel() {
		return transferReceivedDtLabel;
	}

	public void setTransferReceivedDtLabel(String transferReceivedDtLabel) {
		this.transferReceivedDtLabel = transferReceivedDtLabel;
	}

	public String getTransferPrintDtLabel() {
		return transferPrintDtLabel;
	}

	public void setTransferPrintDtLabel(String transferPrintDtLabel) {
		this.transferPrintDtLabel = transferPrintDtLabel;
	}

	public String getTerminatedReceivedDtLabel() {
		return terminatedReceivedDtLabel;
	}

	public void setTerminatedReceivedDtLabel(String terminatedReceivedDtLabel) {
		this.terminatedReceivedDtLabel = terminatedReceivedDtLabel;
	}

	public String getTerminatePrintDtLabel() {
		return terminatePrintDtLabel;
	}

	public void setTerminatePrintDtLabel(String terminatePrintDtLabel) {
		this.terminatePrintDtLabel = terminatePrintDtLabel;
	}

	public String getNewReceivedDtLabel() {
		return newReceivedDtLabel;
	}

	public void setNewReceivedDtLabel(String newReceivedDtLabel) {
		this.newReceivedDtLabel = newReceivedDtLabel;
	}

	public String getNewPrintDtLabel() {
		return newPrintDtLabel;
	}

	public void setNewPrintDtLabel(String newPrintDtLabel) {
		this.newPrintDtLabel = newPrintDtLabel;
	}

	public String getSelectedPrivateDepositIndex() {
		return selectedPrivateDepositIndex;
	}

	public void setSelectedPrivateDepositIndex(String selectedPrivateDepositIndex) {
		this.selectedPrivateDepositIndex = selectedPrivateDepositIndex;
	}

	public String getVatTypeTxt() {
		return vatTypeTxt;
	}

	public void setVatTypeTxt(String vatTypeTxt) {
		this.vatTypeTxt = vatTypeTxt;
	}

	public boolean isDisableElectricCloseDt() {
		return disableElectricCloseDt;
	}

	public void setDisableElectricCloseDt(boolean disableElectricCloseDt) {
		this.disableElectricCloseDt = disableElectricCloseDt;
	}

	public boolean isDisableElectricTerminateDt() {
		return disableElectricTerminateDt;
	}

	public void setDisableElectricTerminateDt(boolean disableElectricTerminateDt) {
		this.disableElectricTerminateDt = disableElectricTerminateDt;
	}

	public String getDepositTypeBgNo() {
		return depositTypeBgNo;
	}

	public void setDepositTypeBgNo(String depositTypeBgNo) {
		this.depositTypeBgNo = depositTypeBgNo;
	}
	
	public String getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}

	public String getVerifyNavProgram() {
		return verifyNavProgram;
	}

	public void setVerifyNavProgram(String verifyNavProgram) {
		this.verifyNavProgram = verifyNavProgram;
	}

	public String getVerifyPage() {
		return verifyPage;
	}

	public void setVerifyPage(String verifyPage) {
		this.verifyPage = verifyPage;
	}

	public String getCreateDt() {
		return createDt;
	}

	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}

	public ManagementMaster getManagementMaster() {
		return managementMaster;
	}

	public void setManagementMaster(ManagementMaster managementMaster) {
		this.managementMaster = managementMaster;
	}

	public boolean ispTakeAllPeriodTypeYearVisible() {
		return pTakeAllPeriodTypeYearVisible;
	}

	public void setpTakeAllPeriodTypeYearVisible(
			boolean pTakeAllPeriodTypeYearVisible) {
		this.pTakeAllPeriodTypeYearVisible = pTakeAllPeriodTypeYearVisible;
	}

	public WarrantDatail getWarrantDatail() {
		return warrantDatail;
	}

	public void setWarrantDatail(WarrantDatail warrantDatail) {
		this.warrantDatail = warrantDatail;
	}

	public boolean isElectricUseTypeSelectDisable() {
		return electricUseTypeSelectDisable;
	}

	public void setElectricUseTypeSelectDisable(boolean electricUseTypeSelectDisable) {
		this.electricUseTypeSelectDisable = electricUseTypeSelectDisable;
	}

	public String getContractNoUrl() {
		return contractNoUrl;
	}

	public void setContractNoUrl(String contractNoUrl) {
		this.contractNoUrl = contractNoUrl;
	}

	public String getBgUrl() {
		return bgUrl;
	}

	public void setBgUrl(String bgUrl) {
		this.bgUrl = bgUrl;
	}

	public String getNetworkStatusLabel() {
		return networkStatusLabel;
	}

	public void setNetworkStatusLabel(String networkStatusLabel) {
		this.networkStatusLabel = networkStatusLabel;
	}

	public List<PaymentDetail> getPaymentDetailList() {
		return paymentDetailList;
	}

	public void setPaymentDetailList(List<PaymentDetail> paymentDetailList) {
		this.paymentDetailList = paymentDetailList;
	}

	public String getExpenseTypeDisplay() {
		return expenseTypeDisplay;
	}

	public void setExpenseTypeDisplay(String expenseTypeDisplay) {
		this.expenseTypeDisplay = expenseTypeDisplay;
	}

	public String getPaymentDetailPeriodMonth() {
		return paymentDetailPeriodMonth;
	}

	public void setPaymentDetailPeriodMonth(String paymentDetailPeriodMonth) {
		this.paymentDetailPeriodMonth = paymentDetailPeriodMonth;
	}

	public String getPaymentDetailPeriodYear() {
		return paymentDetailPeriodYear;
	}

	public void setPaymentDetailPeriodYear(String paymentDetailPeriodYear) {
		this.paymentDetailPeriodYear = paymentDetailPeriodYear;
	}

	public String getApproveDtDisplay() {
		return approveDtDisplay;
	}

	public void setApproveDtDisplay(String approveDtDisplay) {
		this.approveDtDisplay = approveDtDisplay;
	}

	public String getProvinceLabel() {
		return provinceLabel;
	}

	public void setProvinceLabel(String provinceLabel) {
		this.provinceLabel = provinceLabel;
	}

	public String getProcessStatusLabel() {
		return processStatusLabel;
	}

	public void setProcessStatusLabel(String processStatusLabel) {
		this.processStatusLabel = processStatusLabel;
	}

	public String getEditItemId() {
		return editItemId;
	}

	public void setEditItemId(String editItemId) {
		this.editItemId = editItemId;
	}

	public List<Payment> getElectricPaymentList() {
		return electricPaymentList;
	}

	public void setElectricPaymentList(List<Payment> electricPaymentList) {
		this.electricPaymentList = electricPaymentList;
	}

	public Payment getElectricPayment() {
		return electricPayment;
	}

	public void setElectricPayment(Payment electricPayment) {
		this.electricPayment = electricPayment;
	}

	public PaymentDetail getElectricPaymentDetail() {
		return electricPaymentDetail;
	}
	
	//WT###Add 20110112 Start
	public PaymentDetail cloneElectricPaymentDetail(){
		PaymentDetail paymentDetail = new PaymentDetail();
		paymentDetail.setRowId(electricPaymentDetail.getRowId());
		paymentDetail.setPaymentId(electricPaymentDetail.getPaymentId());
		paymentDetail.setExpenseType(electricPaymentDetail.getExpenseType());
		paymentDetail.setFeeAreaCode(electricPaymentDetail.getFeeAreaCode());
		paymentDetail.setFeeMeterId(electricPaymentDetail.getFeeMeterId());
		paymentDetail.setFeeCheckArea(electricPaymentDetail.getFeeCheckArea());
		paymentDetail.setFeeWbsCode(electricPaymentDetail.getFeeWbsCode());
		paymentDetail.setInvNo(electricPaymentDetail.getInvNo());
		paymentDetail.setInvSiteName(electricPaymentDetail.getInvSiteName());
		paymentDetail.setInvAreaCode(electricPaymentDetail.getInvAreaCode());
		paymentDetail.setInvAreaName(electricPaymentDetail.getInvAreaName());
		paymentDetail.setInvMeterId(electricPaymentDetail.getInvMeterId());
		paymentDetail.setInvTermOfPaymentDt(electricPaymentDetail.getInvTermOfPaymentDt());
		paymentDetail.setInvExcludeVatAmt(electricPaymentDetail.getInvExcludeVatAmt());
		paymentDetail.setInvVatAmt(electricPaymentDetail.getInvVatAmt());
		paymentDetail.setInvIncludeVatAmt(electricPaymentDetail.getInvIncludeVatAmt());
		paymentDetail.setReferMeterId(electricPaymentDetail.getReferMeterId());
		paymentDetail.setMeterId(electricPaymentDetail.getMeterId());
		paymentDetail.setpDate(electricPaymentDetail.getpDate());
		paymentDetail.setlDate(electricPaymentDetail.getlDate());
		paymentDetail.setpRead(electricPaymentDetail.getpRead());
		paymentDetail.setlRead(electricPaymentDetail.getlRead());
		paymentDetail.setKwhTotal(electricPaymentDetail.getKwhTotal());
		paymentDetail.setUnitPrice(electricPaymentDetail.getUnitPrice());
		paymentDetail.setUnitVatType(electricPaymentDetail.getUnitVatType());
		paymentDetail.setUnitVatRate(electricPaymentDetail.getUnitVatRate());
		paymentDetail.setTermOfPaymentDt(electricPaymentDetail.getTermOfPaymentDt());
		paymentDetail.setFromTermOfPaymentDt(electricPaymentDetail.getFromTermOfPaymentDt());
		paymentDetail.setToTermOfPaymentDt(electricPaymentDetail.getToTermOfPaymentDt());
		paymentDetail.setPayAmt(electricPaymentDetail.getPayAmt());
		paymentDetail.setVatType(electricPaymentDetail.getVatType());
		paymentDetail.setVatRate(electricPaymentDetail.getVatRate());
		paymentDetail.setVatAmt(electricPaymentDetail.getVatAmt());
		paymentDetail.setWhtType(electricPaymentDetail.getWhtType());
		paymentDetail.setWhtRate(electricPaymentDetail.getWhtRate());
		paymentDetail.setWhtAmt(electricPaymentDetail.getWhtAmt());
		paymentDetail.setExcludeVatAmt(electricPaymentDetail.getExcludeVatAmt());
		paymentDetail.setIncludeVatAmt(electricPaymentDetail.getIncludeVatAmt());
		paymentDetail.setChqAmt(electricPaymentDetail.getChqAmt());
		paymentDetail.setPeriodNo(electricPaymentDetail.getPeriodNo());
		paymentDetail.setPeriodType(electricPaymentDetail.getPeriodType());
		paymentDetail.setPeriodInterval(electricPaymentDetail.getPeriodInterval());
		paymentDetail.setPeriodStartDt(electricPaymentDetail.getPeriodStartDt());
		paymentDetail.setPeriodEndDt(electricPaymentDetail.getPeriodEndDt());
		paymentDetail.setPeriodDay(electricPaymentDetail.getPeriodDay());
		paymentDetail.setPeriodMonth(electricPaymentDetail.getPeriodMonth());
		paymentDetail.setPeriodYear(electricPaymentDetail.getPeriodYear());
		paymentDetail.setPeriodAmt(electricPaymentDetail.getPeriodAmt());
		paymentDetail.setRemark(electricPaymentDetail.getRemark());
		paymentDetail.setRecordStatus(electricPaymentDetail.getRecordStatus());
		paymentDetail.setCreateBy(electricPaymentDetail.getCreateBy());
		paymentDetail.setCreateDt(electricPaymentDetail.getCreateDt());
		paymentDetail.setUpdateBy(electricPaymentDetail.getUpdateBy());
		paymentDetail.setUpdateDt(electricPaymentDetail.getUpdateDt());
		
		return paymentDetail;
	}
	//WT###Add 20110112 End

	public void setElectricPaymentDetail(PaymentDetail electricPaymentDetail) {
		this.electricPaymentDetail = electricPaymentDetail;
	}

	public String getBgTypeLabel() {
		return bgTypeLabel;
	}

	public void setBgTypeLabel(String bgTypeLabel) {
		this.bgTypeLabel = bgTypeLabel;
	}

	public List<PrivateDeposit> getPrivateDepositList() {
		return privateDepositList;
	}

	public void setPrivateDepositList(
			List<PrivateDeposit> privateDepositList) {
		this.privateDepositList = privateDepositList;
	}

	public PrivateDepositDetail getPrivateDepositDetail() {
		return privateDepositDetail;
	}

	public void setPrivateDepositDetail(PrivateDepositDetail privateDepositDetail) {
		this.privateDepositDetail = privateDepositDetail;
	}

	public List<PrivateDepositDetail> getBgPrivateDepositList() {
		return bgPrivateDepositList;
	}

	public void setBgPrivateDepositList(
			List<PrivateDepositDetail> bgPrivateDepositList) {
		this.bgPrivateDepositList = bgPrivateDepositList;
	}

	public List<PrivateDepositDetail> getCashPrivateDepositList() {
		return cashPrivateDepositList;
	}

	public void setCashPrivateDepositList(
			List<PrivateDepositDetail> cashPrivateDepositList) {
		this.cashPrivateDepositList = cashPrivateDepositList;
	}

	public boolean ispPeriodTypePerMonthInputTextVisible() {
		return pPeriodTypePerMonthInputTextVisible;
	}

	public void setpPeriodTypePerMonthInputTextVisible(
			boolean pPeriodTypePerMonthInputTextVisible) {
		this.pPeriodTypePerMonthInputTextVisible = pPeriodTypePerMonthInputTextVisible;
	}

	public boolean ispPeriodTypePerYearInputTextVisible() {
		return pPeriodTypePerYearInputTextVisible;
	}

	public void setpPeriodTypePerYearInputTextVisible(
			boolean pPeriodTypePerYearInputTextVisible) {
		this.pPeriodTypePerYearInputTextVisible = pPeriodTypePerYearInputTextVisible;
	}

	public boolean isTransferMeterDtCalendarDisable() {
		return transferMeterDtCalendarDisable;
	}

	public void setTransferMeterDtCalendarDisable(
			boolean transferMeterDtCalendarDisable) {
		this.transferMeterDtCalendarDisable = transferMeterDtCalendarDisable;
	}

	public List<MeterInstallment> getSelectedMeterInstallmentList() {
		return selectedMeterInstallmentList;
	}

	public void setSelectedMeterInstallmentList(
			List<MeterInstallment> selectedMeterInstallmentList) {
		this.selectedMeterInstallmentList = selectedMeterInstallmentList;
	}

	public List<MeterInstallment> getMeterInstallmentList() {
		return meterInstallmentList;
	}

	public void setMeterInstallmentList(List<MeterInstallment> meterInstallmentList) {
		this.meterInstallmentList = meterInstallmentList;
	}

	public List<BgMaster> getBgDepositDetailList() {
		if(bgDepositDetailList == null)
			bgDepositDetailList = new ArrayList<BgMaster>();
		return bgDepositDetailList;
	}

	public void setBgDepositDetailList(List<BgMaster> bgDepositDetailList) {
		this.bgDepositDetailList = bgDepositDetailList;
	}

	public List<DepositDetail> getCashDepositDetailList() {
		return cashDepositDetailList;
	}

	public void setCashDepositDetailList(
			List<DepositDetail> cashDepositDetailList) {
		this.cashDepositDetailList = cashDepositDetailList;
	}

	public String getElectricUseTypeLabel() {
		return electricUseTypeLabel;
	}

	public void setElectricUseTypeLabel(String electricUseTypeLabel) {
		this.electricUseTypeLabel = electricUseTypeLabel;
	}

	public boolean isNewReceivedDtCalendarDisable() {
		return newReceivedDtCalendarDisable;
	}

	public void setNewReceivedDtCalendarDisable(boolean newReceivedDtCalendarDisable) {
		this.newReceivedDtCalendarDisable = newReceivedDtCalendarDisable;
	}

	public boolean isNewReceivedDtCalendarMandatory() {
		return newReceivedDtCalendarMandatory;
	}

	public void setNewReceivedDtCalendarMandatory(
			boolean newReceivedDtCalendarMandatory) {
		this.newReceivedDtCalendarMandatory = newReceivedDtCalendarMandatory;
	}

	public boolean isTerminateReceivedDtCalendarDisable() {
		return terminateReceivedDtCalendarDisable;
	}

	public void setTerminateReceivedDtCalendarDisable(
			boolean terminateReceivedDtCalendarDisable) {
		this.terminateReceivedDtCalendarDisable = terminateReceivedDtCalendarDisable;
	}

	public boolean isTerminateReceivedDtCalendarMandatory() {
		return terminateReceivedDtCalendarMandatory;
	}

	public void setTerminateReceivedDtCalendarMandatory(
			boolean terminateReceivedDtCalendarMandatory) {
		this.terminateReceivedDtCalendarMandatory = terminateReceivedDtCalendarMandatory;
	}

	public BgMaster getBgMaster() {
		return bgMaster;
	}

	public void setBgMaster(BgMaster bgMaster) {
		this.bgMaster = bgMaster;
	}

	public boolean isBgNoFullVisible() {
		return bgNoFullVisible;
	}

	public void setBgNoFullVisible(boolean bgNoFullVisible) {
		this.bgNoFullVisible = bgNoFullVisible;
	}

	public boolean isTransferFlagCheckboxDisable() {
		return transferFlagCheckboxDisable;
	}

	public void setTransferFlagCheckboxDisable(boolean transferFlagCheckboxDisable) {
		this.transferFlagCheckboxDisable = transferFlagCheckboxDisable;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Management getElectricManage() {
		return electricManage;
	}

	public void setElectricManage(Management electricManage) {
		this.electricManage = electricManage;
	}

	public boolean isUpdateMeterInfoButtonVisible() {
		return updateMeterInfoButtonVisible;
	}

	public void setUpdateMeterInfoButtonVisible(boolean updateMeterInfoButtonVisible) {
		this.updateMeterInfoButtonVisible = updateMeterInfoButtonVisible;
	}

	
	public boolean isWithdrawalButtonVisible() {
		return withdrawalButtonVisible;
	}

	public void setWithdrawalButtonVisible(boolean withdrawalButtonVisible) {
		this.withdrawalButtonVisible = withdrawalButtonVisible;
	}

	
	public boolean isPrivateCaseFlagCheckboxVisible() {
		return privateCaseFlagCheckboxVisible;
	}

	public void setPrivateCaseFlagCheckboxVisible(
			boolean privateCaseFlagCheckboxVisible) {
		this.privateCaseFlagCheckboxVisible = privateCaseFlagCheckboxVisible;
	}

	
	public boolean isExpandFlagCheckboxVisible() {
		return expandFlagCheckboxVisible;
	}

	public void setExpandFlagCheckboxVisible(boolean expandFlagCheckboxVisible) {
		this.expandFlagCheckboxVisible = expandFlagCheckboxVisible;
	}
	
	
	public boolean isUpdateStatusButtonVisible() {
		return updateStatusButtonVisible;
	}

	public void setUpdateStatusButtonVisible(boolean updateStatusButtonVisible) {
		this.updateStatusButtonVisible = updateStatusButtonVisible;
	}

	
	public boolean isSaveDepositButtonVisible() {
		return saveDepositButtonVisible;
	}

	public void setSaveDepositButtonVisible(boolean saveDepositButtonVisible) {
		this.saveDepositButtonVisible = saveDepositButtonVisible;
	}

	
	public boolean isDepositTypeLabelVisible() {
		return depositTypeLabelVisible;
	}

	public void setDepositTypeLabelVisible(boolean depositTypeLabelVisible) {
		this.depositTypeLabelVisible = depositTypeLabelVisible;
	}

	
	public boolean isVerifyButtonVisible() {
		return verifyButtonVisible;
	}

	public void setVerifyButtonVisible(boolean verifyButtonVisible) {
		this.verifyButtonVisible = verifyButtonVisible;
	}

	
	public boolean isReceiveJobButtonVisible() {
		return receiveJobButtonVisible;
	}

	public void setReceiveJobButtonVisible(boolean receiveJobButtonVisible) {
		this.receiveJobButtonVisible = receiveJobButtonVisible;
	}

	
	public boolean isPrintButtonVisible() {
		return printButtonVisible;
	}

	public void setPrintButtonVisible(boolean printButtonVisible) {
		this.printButtonVisible = printButtonVisible;
	}

	
	public boolean isRePrintButtonVisible() {
		return rePrintButtonVisible;
	}

	public void setRePrintButtonVisible(boolean rePrintButtonVisible) {
		this.rePrintButtonVisible = rePrintButtonVisible;
	}
	
	
	public String getRegionLabel() {
		return regionLabel;
	}

	public void setRegionLabel(String regionLabel) {
		this.regionLabel = regionLabel;
	}
	
	
	public String getSiteStatusLabel() {
		return siteStatusLabel;
	}

	public void setSiteStatusLabel(String siteStatusLabel) {
		this.siteStatusLabel = siteStatusLabel;
	}

	public MeterInfo getMeterInfo() {
		return meterInfo;
	}

	public void setMeterInfo(MeterInfo meterInfo) {
		this.meterInfo = meterInfo;
	}

	public MeterInfo getMeterInfoPrivate() {
		return meterInfoPrivate;
	}

	public void setMeterInfoPrivate(MeterInfo meterInfoPrivate) {
		this.meterInfoPrivate = meterInfoPrivate;
	}

	public MeterInfo getMeterInfoMeaPea() {
		return meterInfoMeaPea;
	}

	public void setMeterInfoMeaPea(MeterInfo meterInfoMeaPea) {
		this.meterInfoMeaPea = meterInfoMeaPea;
	}

	public boolean isDisableMeaPeaUpdateButton() {
		return disableMeaPeaUpdateButton;
	}

	public void setDisableMeaPeaUpdateButton(boolean disableMeaPeaUpdateButton) {
		this.disableMeaPeaUpdateButton = disableMeaPeaUpdateButton;
	}

	public boolean isDisableMeaPeaAddButton() {
		return disableMeaPeaAddButton;
	}

	public void setDisableMeaPeaAddButton(boolean disableMeaPeaAddButton) {
		this.disableMeaPeaAddButton = disableMeaPeaAddButton;
	}

	public boolean isDisablePrivateUpdateButton() {
		return disablePrivateUpdateButton;
	}

	public void setDisablePrivateUpdateButton(boolean disablePrivateUpdateButton) {
		this.disablePrivateUpdateButton = disablePrivateUpdateButton;
	}

	public boolean isDisablePrivateAddButton() {
		return disablePrivateAddButton;
	}

	public void setDisablePrivateAddButton(boolean disablePrivateAddButton) {
		this.disablePrivateAddButton = disablePrivateAddButton;
	}

	public boolean isDisableMeaPea() {
		return disableMeaPea;
	}

	public void setDisableMeaPea(boolean disableMeaPea) {
		this.disableMeaPea = disableMeaPea;
	}

	public boolean isDisablePrivate() {
		return disablePrivate;
	}

	public void setDisablePrivate(boolean disablePrivate) {
		this.disablePrivate = disablePrivate;
	}

	public boolean isDisablePrivateEditMode() {
		return disablePrivateEditMode;
	}

	public void setDisablePrivateEditMode(boolean disablePrivateEditMode) {
		this.disablePrivateEditMode = disablePrivateEditMode;
	}

	public boolean isDisablePOffMeterDt() {
		return disablePOffMeterDt;
	}

	public void setDisablePOffMeterDt(boolean disablePOffMeterDt) {
		this.disablePOffMeterDt = disablePOffMeterDt;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getLastTermOfPaymentDtLabel() {
		return lastTermOfPaymentDtLabel;
	}

	public void setLastTermOfPaymentDtLabel(String lastTermOfPaymentDtLabel) {
		this.lastTermOfPaymentDtLabel = lastTermOfPaymentDtLabel;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public boolean isFirstPaidFlag() {
		return firstPaidFlag;
	}

	public void setFirstPaidFlag(boolean firstPaidFlag) {
		this.firstPaidFlag = firstPaidFlag;
	}

	public PrivateDeposit getPrivateDeposit() {
		return privateDeposit;
	}

	public void setPrivateDeposit(PrivateDeposit privateDeposit) {
		this.privateDeposit = privateDeposit;
	}

	public Payment getHistPayment() {
		return histPayment;
	}

	public void setHistPayment(Payment histPayment) {
		this.histPayment = histPayment;
	}

	public PaymentDetail getHistPaymentDetail() {
		return histPaymentDetail;
	}

	public void setHistPaymentDetail(PaymentDetail histPaymentDetail) {
		this.histPaymentDetail = histPaymentDetail;
	}

	public boolean isDisableTerminateCutoffDt() {
		return disableTerminateCutoffDt;
	}

	public void setDisableTerminateCutoffDt(boolean disableTerminateCutoffDt) {
		this.disableTerminateCutoffDt = disableTerminateCutoffDt;
	}

	public boolean isDisableExpandOldCutoffDt() {
		return disableExpandOldCutoffDt;
	}

	public void setDisableExpandOldCutoffDt(boolean disableExpandOldCutoffDt) {
		this.disableExpandOldCutoffDt = disableExpandOldCutoffDt;
	}

	public boolean isDisableExpandNewOnmeterDt() {
		return disableExpandNewOnmeterDt;
	}

	public void setDisableExpandNewOnmeterDt(boolean disableExpandNewOnmeterDt) {
		this.disableExpandNewOnmeterDt = disableExpandNewOnmeterDt;
	}

	public boolean isDisableTransferCutoffDt() {
		return disableTransferCutoffDt;
	}

	public void setDisableTransferCutoffDt(boolean disableTransferCutoffDt) {
		this.disableTransferCutoffDt = disableTransferCutoffDt;
	}

	public boolean isDisableTransferMeterDt() {
		return disableTransferMeterDt;
	}

	public void setDisableTransferMeterDt(boolean disableTransferMeterDt) {
		this.disableTransferMeterDt = disableTransferMeterDt;
	}

	public boolean isDisablePOnMeterDt() {
		return disablePOnMeterDt;
	}

	public void setDisablePOnMeterDt(boolean disablePOnMeterDt) {
		this.disablePOnMeterDt = disablePOnMeterDt;
	}

	public String getAmphurLabel() {
		return amphurLabel;
	}

	public void setAmphurLabel(String amphurLabel) {
		this.amphurLabel = amphurLabel;
	}

	public ManagementSO getElectricManageSO() {
		return electricManageSO;
	}

	public void setElectricManageSO(ManagementSO electricManageSO) {
		this.electricManageSO = electricManageSO;
	}

	public String getZoneLabel() {
		return zoneLabel;
	}

	public void setZoneLabel(String zoneLabel) {
		this.zoneLabel = zoneLabel;
	}

	public String getMeterIdDisplay() {
		return meterIdDisplay;
	}

	public void setMeterIdDisplay(String meterIdDisplay) {
		this.meterIdDisplay = meterIdDisplay;
	}

	public String geteAreaCodeDisplay() {
		return eAreaCodeDisplay;
	}

	public void seteAreaCodeDisplay(String eAreaCodeDisplay) {
		this.eAreaCodeDisplay = eAreaCodeDisplay;
	}

	public String geteAreaNameDisplay() {
		return eAreaNameDisplay;
	}

	public void seteAreaNameDisplay(String eAreaNameDisplay) {
		this.eAreaNameDisplay = eAreaNameDisplay;
	}

	public String getRecordStatusDisplay() {
		return recordStatusDisplay;
	}

	public void setRecordStatusDisplay(String recordStatusDisplay) {
		this.recordStatusDisplay = recordStatusDisplay;
	}

	public String getMeterRefIdDisplay() {
		return meterRefIdDisplay;
	}

	public void setMeterRefIdDisplay(String meterRefIdDisplay) {
		this.meterRefIdDisplay = meterRefIdDisplay;
	}

	public String getAmphurDisplay() {
		return amphurDisplay;
	}

	public void setAmphurDisplay(String amphurDisplay) {
		this.amphurDisplay = amphurDisplay;
	}

	public ManagementSP getElectricManageSP() {
		return electricManageSP;
	}

	public void setElectricManageSP(ManagementSP electricManageSP) {
		this.electricManageSP = electricManageSP;
	}

	public ElBgMasterSP getBgMasterSP() {
		return bgMasterSP;
	}

	public void setBgMasterSP(ElBgMasterSP bgMasterSP) {
		this.bgMasterSP = bgMasterSP;
	}

	public ELVerifyCondSP getVerifyCondSP() {
		return verifyCondSP;
	}

	public void setVerifyCondSP(ELVerifyCondSP verifyCondSP) {
		this.verifyCondSP = verifyCondSP;
	}

	public ELDpstCondSP getDpstCondSP() {
		return dpstCondSP;
	}

	public void setDpstCondSP(ELDpstCondSP dpstCondSP) {
		this.dpstCondSP = dpstCondSP;
	}

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	
}
