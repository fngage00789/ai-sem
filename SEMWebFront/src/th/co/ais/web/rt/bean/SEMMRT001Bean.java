package th.co.ais.web.rt.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.richfaces.model.TreeNode;
import org.springframework.util.StringUtils;

import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.domain.rt.DepositDetail;
import th.co.ais.domain.rt.Mrt001BalanceCal;
import th.co.ais.domain.rt.Mrt001BookBank;
import th.co.ais.domain.rt.Mrt001RentCal;
import th.co.ais.domain.rt.Mrt001SrchDpstCond;
import th.co.ais.domain.rt.Mrt001SrchDpstDetail;
import th.co.ais.domain.rt.Mrt001SrchRentDetail;
import th.co.ais.domain.rt.Mrt001SrchRentHist;
import th.co.ais.domain.rt.Mrt001SrchRentPay;
import th.co.ais.domain.rt.RentalDetail;
import th.co.ais.domain.rt.VerifyRentalSearchSiteInfoSP;
import th.co.ais.domain.rt.VerifyRentalSearchSiteRentCondSP;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;
import th.co.ais.web.bean.TreeUtilBean;

public class SEMMRT001Bean extends AbstractBean{ 

	private static final long serialVersionUID = -5462254467010903309L;

	private List<SelectItem> companyList;
	private List<SelectItem> siteTypeList;
	private List<SelectItem> reqTypeList;
	private List<SelectItem> rentalStatusList;
	private List<SelectItem> verifyStatusList;
	private List<SelectItem> verifyStatusSpecialList;
	private List<SelectItem> expenseTypeList;
	private List<SelectItem> vendorList;
	private List<SelectItem> payeeList;
	private List<SelectItem> depositTypeList;
	private List<SelectItem> periodTypeList;
	 
	private VerifyRentalSearchSiteInfoSP criteria, displayFrmRental;
	private List<WrapperBeanObject<VerifyRentalSearchSiteInfoSP>> resultList;
	private boolean chkCurrentFlg;
	
	// Rental detail
	private List<VerifyRentalSearchSiteRentCondSP> rentCondList;
	private VerifyRentalSearchSiteRentCondSP rentCondSpecial;
	private VerifyRentalSearchSiteRentCondSP servCondSpecial;
	private VerifyRentalSearchSiteRentCondSP servCondSpecial2;
	private VerifyRentalSearchSiteRentCondSP servCondSpecial3;
	private VerifyRentalSearchSiteRentCondSP donateCondSpecial;
	
	private RentalDetail rentDetail;
	private RentalDetail rentDetailDel;
	private List<Mrt001SrchRentDetail> rentDetailList;
	
	private List<Mrt001SrchRentHist> rentHistList;
	
	// Deposit
	private List<Mrt001SrchDpstCond> dpstCondList;
	private Mrt001SrchDpstCond dpstCondSpecialBG;
	private Mrt001SrchDpstCond dpstCondSpecial;
	private boolean selectedBGSpecial;
	private boolean selectedCashSpecial;
	
	private DepositDetail dpstDetail;
	private DepositDetail dpstDetailDel;
	
	private List<Mrt001SrchDpstDetail> dpstDetailList;
	// Use for updating in ct002 
	private DepositDetail selectedDpstDetail;
	
	private String pageRentalSetupStatus;
	
	private String mode;
	private String modePage;
	private String modeRentalDetail;
	private String modeDpstDetail;
	private String txtContent;
	private String txtSavePending;
	private String txtWarning;
	private Mrt001BookBank mrt001BookBank;
	private String condType;
	
	private int countDataSelect;
	
	private String period;
	private String period3;
	private String period4;
	private Double tmpWhtRate;
	private Double tmpVatRate;
	private Double balanceAmt;
	private Integer payPeriodMonth;
	private Integer payPeriodYear;
	
	private boolean disChkSpecial;
	private boolean disApprove;
	private boolean disBtnAdd;
	private boolean renderedModeApprove;
	private boolean disDdlpayee;
	private boolean disWhtRate;
	private boolean disVat;
	private boolean disMonth;
	private boolean chkSelAll = false;
	private boolean popupWarning;
	private boolean renderedBtnExport = false;
	private boolean chkBtnAddSpecial;
	
	private boolean disRentAmt;
	private boolean disDpstAmt;
	private boolean disPendingDt;
	
	private boolean disDepositDetail = true;
	
	private boolean specialChk1 = false;
	private boolean specialChk2 = false;
	private boolean specialChk3 = false;
	private boolean specialChk4 = false;
	private boolean disabledSpacialChk = true;
	private boolean requireFlag = true;
	private RentalDetail tmpRentalDetail;
	private String checkMode;
	
	private boolean renderedMsgFormPopup = false;
	
	private boolean disableBtnSave = false;
	
	
	//for Popup Edit Period
	private String contractNo;
	private Date effDt;
	private Date expDt;
	private String expenseType;
	private String periodType;
	private Date periodStartDt;
	private Double periodNo;
	private String rentalMasterId;
	
	private List<Mrt001BalanceCal> modelList;
	private boolean popupClose = false;
	private String rentalPaymentId;
	
	private Double defaultVat;
	private Double defaultWht;
	
	//Tab Check Premium
	private List<Mrt001SrchRentPay> rentPayList;
	
	// added by.. YUT
	private boolean renderedOnToDoList = false;
	
	// added by.. NEW 17/03/2015
	private TreeUtilBean treeUtilBean;
	private List<SelectItem> regionList;
	private boolean disabledExpenseType = true;
	private TreeNode rootNode = null;
	
	//added by NEW 20151030
	public boolean treeMacroFlag = false;
	public String headerTreeMacro;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreeMacroList;
	
	//added by Kanruethai.T 20180905 
	public List<SelectItem> serviceNameList;
	public String serviceCalTypeId;
	public String serviceCalTypeIdToCal; 
	public String serviceCalTypeIdToCalName;
	public ArrayList<Double> servicePercent;
	public ArrayList<Double> serviceCustom;
	public List<SelectItem> serviceTypeToCalList;
	public List<Mrt001RentCal> serviceNameListShowTbl;
	public Double configRate;
	public String inputPercent;
	public String inputAmt;
	public String vResult;
	public String vMessage;
	public String serviceList;
	public String serviceShowTbl;
	public String serviceCalTypeTbl;
	public String showAmt;
	
	
	public boolean treePicoFlag = false;
	public String headerTreePico;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreePicoList;
	
	public boolean treeExcFlag = false;
	public String headerTreeExc;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreeExcList;
	public boolean disabledVerify = false;
	
	// popup add vendor
	public List<WrapperBeanObject<VendorMasterSP>> vendorMasterPopupList;
	private VendorMasterSP vendorMasterPopupObjParam;
	
	
	public boolean disabledExpenseDesc =true;
	
	public boolean isChkBtnAddSpecial() {
		return chkBtnAddSpecial;
	}
	public void setChkBtnAddSpecial(boolean chkBtnAddSpecial) {
		this.chkBtnAddSpecial = chkBtnAddSpecial;
	}
	public VerifyRentalSearchSiteRentCondSP getDonateCondSpecial() {
		return donateCondSpecial;
	}
	public void setDonateCondSpecial(
			VerifyRentalSearchSiteRentCondSP donateCondSpecial) {
		this.donateCondSpecial = donateCondSpecial;
	}
	public List<SelectItem> getPeriodTypeList() {
		return periodTypeList;
	}
	public void setPeriodTypeList(List<SelectItem> periodTypeList) {
		this.periodTypeList = periodTypeList;
	}
	public boolean isChkCurrentFlg() {
		return chkCurrentFlg;
	}
	public void setChkCurrentFlg(boolean chkCurrentFlg) {
		this.chkCurrentFlg = chkCurrentFlg;
	}
	public boolean isDisDpstAmt() {
		return disDpstAmt;
	}
	public void setDisDpstAmt(boolean disDpstAmt) {
		this.disDpstAmt = disDpstAmt;
	}
	public boolean isDisRentAmt() {
		return disRentAmt;
	}
	public void setDisRentAmt(boolean disRentAmt) {
		this.disRentAmt = disRentAmt;
	}
	public String getCondType() {
		return condType;
	}
	public void setCondType(String condType) {
		this.condType = condType;
	}
	public String getTxtWarning() {
		return txtWarning;
	}
	public void setTxtWarning(String txtWarning) {
		this.txtWarning = txtWarning;
	}
	public boolean isPopupWarning() {
		return popupWarning;
	}
	public void setPopupWarning(boolean popupWarning) {
		this.popupWarning = popupWarning;
	}
	public Mrt001BookBank getMrt001BookBank() {
		return mrt001BookBank;
	}
	public void setMrt001BookBank(Mrt001BookBank mrt001BookBank) {
		this.mrt001BookBank = mrt001BookBank;
	}
	public String getTxtSavePending() {
		return txtSavePending;
	}
	public void setTxtSavePending(String txtSavePending) {
		this.txtSavePending = txtSavePending;
	}
	public DepositDetail getSelectedDpstDetail() {
		return selectedDpstDetail;
	}
	public void setSelectedDpstDetail(DepositDetail selectedDpstDetail) {
		this.selectedDpstDetail = selectedDpstDetail;
	}
	public boolean isDisChkSpecial() {
		return disChkSpecial;
	}
	public void setDisChkSpecial(boolean disChkSpecial) {
		this.disChkSpecial = disChkSpecial;
	}
	public boolean isSelectedBGSpecial() {
		return selectedBGSpecial;
	}
	public void setSelectedBGSpecial(boolean selectedBGSpecial) {
		this.selectedBGSpecial = selectedBGSpecial;
	}
	public boolean isSelectedCashSpecial() {
		return selectedCashSpecial;
	}
	public void setSelectedCashSpecial(boolean selectedCashSpecial) {
		this.selectedCashSpecial = selectedCashSpecial;
	}
	public Mrt001SrchDpstCond getDpstCondSpecialBG() {
		return dpstCondSpecialBG;
	}
	public void setDpstCondSpecialBG(Mrt001SrchDpstCond dpstCondSpecialBG) {
		this.dpstCondSpecialBG = dpstCondSpecialBG;
	}
	public Integer getPayPeriodMonth() {
		return payPeriodMonth;
	}
	public void setPayPeriodMonth(Integer payPeriodMonth) {
		this.payPeriodMonth = payPeriodMonth;
	}
	public Integer getPayPeriodYear() {
		return payPeriodYear;
	}
	public void setPayPeriodYear(Integer payPeriodYear) {
		this.payPeriodYear = payPeriodYear;
	}
	public boolean isDisBtnAdd() {
		return disBtnAdd;
	}
	public void setDisBtnAdd(boolean disBtnAdd) {
		this.disBtnAdd = disBtnAdd;
	}
	public boolean isRenderedModeApprove() {
		return renderedModeApprove;
	}
	public void setRenderedModeApprove(boolean renderedModeApprove) {
		this.renderedModeApprove = renderedModeApprove;
	}
	public List<SelectItem> getVerifyStatusSpecialList() {
		return verifyStatusSpecialList;
	}
	public void setVerifyStatusSpecialList(List<SelectItem> verifyStatusSpecialList) {
		this.verifyStatusSpecialList = verifyStatusSpecialList;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public boolean isDisApprove() {
		return disApprove;
	}
	public void setDisApprove(boolean disApprove) {
		this.disApprove = disApprove;
	}
	public Double getBalanceAmt() {
		return balanceAmt;
	}
	public void setBalanceAmt(Double balanceAmt) {
		this.balanceAmt = balanceAmt;
	}
	public Double getTmpVatRate() {
		return tmpVatRate;
	}
	public void setTmpVatRate(Double tmpVatRate) {
		this.tmpVatRate = tmpVatRate;
	}
	public Double getTmpWhtRate() {
		return tmpWhtRate;
	}
	public void setTmpWhtRate(Double tmpWhtRate) {
		this.tmpWhtRate = tmpWhtRate;
	}
	public boolean isChkSelAll() {
		return chkSelAll;
	}
	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}
	public List<Mrt001SrchDpstDetail> getDpstDetailList() {
		return dpstDetailList;
	}
	public void setDpstDetailList(List<Mrt001SrchDpstDetail> dpstDetailList) {
		this.dpstDetailList = dpstDetailList;
	}
	public List<SelectItem> getDepositTypeList() {
		return depositTypeList;
	}
	public void setDepositTypeList(List<SelectItem> depositTypeList) {
		this.depositTypeList = depositTypeList;
	}
	public String getModeDpstDetail() {
		return modeDpstDetail;
	}
	public void setModeDpstDetail(String modeDpstDetail) {
		this.modeDpstDetail = modeDpstDetail;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getPeriod3() {
		return period3;
	}
	public void setPeriod3(String period3) {
		this.period3 = period3;
	}
	public String getPeriod4() {
		return period4;
	}
	public void setPeriod4(String period4) {
		this.period4 = period4;
	}
	public List<SelectItem> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<SelectItem> companyList) {
		Logger LOG = Logger.getLogger(getClass());
		
		LOG.info("size == > "+companyList.size());
		int i = 0;
		for(i = 0;i < companyList.size(); i++){
			SelectItem test = companyList.get(i);
			LOG.info("companyList "+test.getValue());
		}
		
		this.companyList = companyList;
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
	public VerifyRentalSearchSiteInfoSP getCriteria() {
		return criteria;
	}
	public void setCriteria(VerifyRentalSearchSiteInfoSP criteria) {
		this.criteria = criteria;
	}
	public List<WrapperBeanObject<VerifyRentalSearchSiteInfoSP>> getResultList() {
		return resultList;
	}
	public void setResultList(List<WrapperBeanObject<VerifyRentalSearchSiteInfoSP>> resultList) {
		this.resultList = resultList;
	}
	public VerifyRentalSearchSiteInfoSP getDisplayFrmRental() {
		return displayFrmRental;
	}
	public void setDisplayFrmRental(VerifyRentalSearchSiteInfoSP displayFrmRental) {
		this.displayFrmRental = displayFrmRental;
	}
	public List<VerifyRentalSearchSiteRentCondSP> getRentCondList() {
		return rentCondList;
	}
	public void setRentCondList(List<VerifyRentalSearchSiteRentCondSP> rentCondList) {
		this.rentCondList = rentCondList;
	}
	public String getPageRentalSetupStatus() {
		return pageRentalSetupStatus;
	}
	public void setPageRentalSetupStatus(String pageRentalSetupStatus) {
		this.pageRentalSetupStatus = pageRentalSetupStatus;
	}
	public List<SelectItem> getExpenseTypeList() {
		return expenseTypeList;
	}
	public void setExpenseTypeList(List<SelectItem> expenseTypeList) {
		this.expenseTypeList = expenseTypeList;
	}
	public RentalDetail getRentDetail() {
		return rentDetail;
	}
	public void setRentDetail(RentalDetail rentDetail) {
		this.rentDetail = rentDetail;
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
	public String getModePage() {
		return modePage;
	}
	public void setModePage(String modePage) {
		this.modePage = modePage;
	}
	public int getCountDataSelect() {
		return countDataSelect;
	}
	public void setCountDataSelect(int countDataSelect) {
		this.countDataSelect = countDataSelect;
	}
	public List<SelectItem> getRentalStatusList() {
		return rentalStatusList;
	}
	public void setRentalStatusList(List<SelectItem> rentalStatusList) {
		this.rentalStatusList = rentalStatusList;
	}
	public List<Mrt001SrchRentDetail> getRentDetailList() {
		return rentDetailList;
	}
	public void setRentDetailList(List<Mrt001SrchRentDetail> rentDetailList) {
		this.rentDetailList = rentDetailList;
	}
	public List<Mrt001SrchRentHist> getRentHistList() {
		return rentHistList;
	}
	public void setRentHistList(List<Mrt001SrchRentHist> rentHistList) {
		this.rentHistList = rentHistList;
	}
	public boolean isDisDdlpayee() {
		return disDdlpayee;
	}
	public void setDisDdlpayee(boolean disDdlpayee) {
		this.disDdlpayee = disDdlpayee;
	}
	public VerifyRentalSearchSiteRentCondSP getRentCondSpecial() {
		return rentCondSpecial;
	}
	public void setRentCondSpecial(VerifyRentalSearchSiteRentCondSP rentCondSpecial) {
		this.rentCondSpecial = rentCondSpecial;
	}
	public VerifyRentalSearchSiteRentCondSP getServCondSpecial() {
		return servCondSpecial;
	}
	public void setServCondSpecial(VerifyRentalSearchSiteRentCondSP servCondSpecial) {
		this.servCondSpecial = servCondSpecial;
	}
	public boolean isDisWhtRate() {
		return disWhtRate;
	}
	public void setDisWhtRate(boolean disWhtRate) {
		this.disWhtRate = disWhtRate;
	}
	public boolean isDisVat() {
		return disVat;
	}
	public void setDisVat(boolean disVat) {
		this.disVat = disVat;
	}
	public boolean isDisMonth() {
		return disMonth;
	}
	public void setDisMonth(boolean disMonth) {
		this.disMonth = disMonth;
	}
	public String getModeRentalDetail() {
		return modeRentalDetail;
	}
	public void setModeRentalDetail(String modeRentalDetail) {
		this.modeRentalDetail = modeRentalDetail;
	}
	public String getTxtContent() {
		return txtContent;
	}
	public void setTxtContent(String txtContent) {
		this.txtContent = txtContent;
	}
	public RentalDetail getRentDetailDel() {
		return rentDetailDel;
	}
	public void setRentDetailDel(RentalDetail rentDetailDel) {
		this.rentDetailDel = rentDetailDel;
	}
	public List<Mrt001SrchDpstCond> getDpstCondList() {
		return dpstCondList;
	}
	public void setDpstCondList(List<Mrt001SrchDpstCond> dpstCondList) {
		this.dpstCondList = dpstCondList;
	}
	public Mrt001SrchDpstCond getDpstCondSpecial() {
		return dpstCondSpecial;
	}
	public void setDpstCondSpecial(Mrt001SrchDpstCond dpstCondSpecial) {
		this.dpstCondSpecial = dpstCondSpecial;
	}
	public DepositDetail getDpstDetail() {
		return dpstDetail;
	}
	public void setDpstDetail(DepositDetail dpstDetail) {
		this.dpstDetail = dpstDetail;
	}
	public DepositDetail getDpstDetailDel() {
		return dpstDetailDel;
	}
	public void setDpstDetailDel(DepositDetail dpstDetailDel) {
		this.dpstDetailDel = dpstDetailDel;
	}
	public boolean isRenderedBtnExport() {
		return renderedBtnExport;
	}
	public void setRenderedBtnExport(boolean renderedBtnExport) {
		this.renderedBtnExport = renderedBtnExport;
	}
	public boolean isDisPendingDt() {
		return disPendingDt;
	}
	public void setDisPendingDt(boolean disPendingDt) {
		this.disPendingDt = disPendingDt;
	}
	
	public List<Mrt001SrchRentPay> getRentPayList() {
		return rentPayList;
	}
	public void setRentPayList(List<Mrt001SrchRentPay> rentPayList) {
		this.rentPayList = rentPayList;
	}
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public boolean isDisDepositDetail() {
		return disDepositDetail;
	}
	public void setDisDepositDetail(boolean disDepositDetail) {
		this.disDepositDetail = disDepositDetail;
	}
	public boolean isSpecialChk1() {
		return specialChk1;
	}
	public void setSpecialChk1(boolean specialChk1) {
		this.specialChk1 = specialChk1;
	}
	public boolean isSpecialChk2() {
		return specialChk2;
	}
	public void setSpecialChk2(boolean specialChk2) {
		this.specialChk2 = specialChk2;
	}
	public boolean isRequireFlag() {
		return requireFlag;
	}
	public void setRequireFlag(boolean requireFlag) {
		this.requireFlag = requireFlag;
	}
	public RentalDetail getTmpRentalDetail() {
		return tmpRentalDetail;
	}
	public void setTmpRentalDetail(RentalDetail tmpRentalDetail) {
		this.tmpRentalDetail = tmpRentalDetail;
	}
	public String getCheckMode() {
		return checkMode;
	}
	public void setCheckMode(String checkMode) {
		this.checkMode = checkMode;
	}
	public boolean isRenderedMsgFormPopup() {
		return renderedMsgFormPopup;
	}
	public void setRenderedMsgFormPopup(boolean renderedMsgFormPopup) {
		this.renderedMsgFormPopup = renderedMsgFormPopup;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public Date getEffDt() {
		return effDt;
	}
	public void setEffDt(Date effDt) {
		this.effDt = effDt;
	}
	public Date getExpDt() {
		return expDt;
	}
	public void setExpDt(Date expDt) {
		this.expDt = expDt;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getPeriodType() {
		return periodType;
	}
	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}
	public Date getPeriodStartDt() {
		return periodStartDt;
	}
	public void setPeriodStartDt(Date periodStartDt) {
		this.periodStartDt = periodStartDt;
	}
	public Double getPeriodNo() {
		return periodNo;
	}
	public void setPeriodNo(Double periodNo) {
		this.periodNo = periodNo;
	}
	public List<Mrt001BalanceCal> getModelList() {
		return modelList;
	}
	public void setModelList(List<Mrt001BalanceCal> modelList) {
		this.modelList = modelList;
	}
	public boolean isPopupClose() {
		return popupClose;
	}
	public void setPopupClose(boolean popupClose) {
		this.popupClose = popupClose;
	}
	public String getRentalMasterId() {
		return rentalMasterId;
	}
	public void setRentalMasterId(String rentalMasterId) {
		this.rentalMasterId = rentalMasterId;
	}
	public String getRentalPaymentId() {
		return rentalPaymentId;
	}
	public void setRentalPaymentId(String rentalPaymentId) {
		this.rentalPaymentId = rentalPaymentId;
	}
	public Double getDefaultVat() {
		return defaultVat;
	}
	public void setDefaultVat(Double defaultVat) {
		this.defaultVat = defaultVat;
	}
	public Double getDefaultWht() {
		return defaultWht;
	}
	public void setDefaultWht(Double defaultWht) {
		this.defaultWht = defaultWht;
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
	public List<SelectItem> getRegionList() {
		return regionList;
	}
	public void setRegionList(List<SelectItem> regionList) {
		this.regionList = regionList;
	}
	public VerifyRentalSearchSiteRentCondSP getServCondSpecial2() {
		return servCondSpecial2;
	}
	public void setServCondSpecial2(
			VerifyRentalSearchSiteRentCondSP servCondSpecial2) {
		this.servCondSpecial2 = servCondSpecial2;
	}
	public VerifyRentalSearchSiteRentCondSP getServCondSpecial3() {
		return servCondSpecial3;
	}
	public void setServCondSpecial3(
			VerifyRentalSearchSiteRentCondSP servCondSpecial3) {
		this.servCondSpecial3 = servCondSpecial3;
	}
	public boolean isSpecialChk3() {
		return specialChk3;
	}
	public void setSpecialChk3(boolean specialChk3) {
		this.specialChk3 = specialChk3;
	}
	public boolean isSpecialChk4() {
		return specialChk4;
	}
	public void setSpecialChk4(boolean specialChk4) {
		this.specialChk4 = specialChk4;
	}
	public boolean isDisabledExpenseType() {
		return disabledExpenseType;
	}
	public void setDisabledExpenseType(boolean disabledExpenseType) {
		this.disabledExpenseType = disabledExpenseType;
	}
	public boolean isDisabledSpacialChk() {
		return disabledSpacialChk;
	}
	public void setDisabledSpacialChk(boolean disabledSpacialChk) {
		this.disabledSpacialChk = disabledSpacialChk;
	}
	public TreeNode getRootNode() {
		return rootNode;
	}
	public void setRootNode(TreeNode rootNode) {
		this.rootNode = rootNode;
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
	public boolean isTreeExcFlag() {
		return treeExcFlag;
	}
	public void setTreeExcFlag(boolean treeExcFlag) {
		this.treeExcFlag = treeExcFlag;
	}
	public String getHeaderTreeExc() {
		return headerTreeExc;
	}
	public void setHeaderTreeExc(String headerTreeExc) {
		this.headerTreeExc = headerTreeExc;
	}
	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreeExcList() {
		return menuTreeExcList;
	}
	public void setMenuTreeExcList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreeExcList) {
		this.menuTreeExcList = menuTreeExcList;
	}
	public boolean isDisabledVerify() {
		return disabledVerify;
	}
	public void setDisabledVerify(boolean disabledVerify) {
		this.disabledVerify = disabledVerify;
	}
	public String getServiceCalTypeId() {
		return serviceCalTypeId;
	}
	public void setServiceCalTypeId(String serviceCalTypeId) {
		this.serviceCalTypeId = serviceCalTypeId;
	}

	public String getServiceCalTypeIdToCal() {
		return serviceCalTypeIdToCal;
	}
	public void setServiceCalTypeIdToCal(String serviceCalTypeIdToCal) {
		this.serviceCalTypeIdToCal = serviceCalTypeIdToCal;
	}
	public ArrayList<Double> getServicePercent() {
		return servicePercent;
	}
	public void setServicePercent(ArrayList<Double> servicePercent) {
		this.servicePercent = servicePercent;
	}
	public ArrayList<Double> getServiceCustom() {
		return serviceCustom;
	}
	public void setServiceCustom(ArrayList<Double> serviceCustom) {
		this.serviceCustom = serviceCustom;
	}
	public List<SelectItem> getServiceNameList() {
		return serviceNameList;
	}
	public void setServiceNameList(List<SelectItem> serviceNameList) {
		this.serviceNameList = serviceNameList;
	}
	public List<SelectItem> getServiceTypeToCalList() {
		return serviceTypeToCalList;
	}
	public void setServiceTypeToCalList(List<SelectItem> serviceTypeToCalList) {
		this.serviceTypeToCalList = serviceTypeToCalList;
	}
	public String getServiceCalTypeIdToCalName() {
		return serviceCalTypeIdToCalName;
	}
	public void setServiceCalTypeIdToCalName(String serviceCalTypeIdToCalName) {
		this.serviceCalTypeIdToCalName = serviceCalTypeIdToCalName;
	}
	public Double getConfigRate() {
		return configRate;
	}
	public void setConfigRate(Double configRate) {
		this.configRate = configRate;
	}

	public String getInputPercent() {
		return inputPercent;
	}
	public void setInputPercent(String inputPercent) {
		this.inputPercent = inputPercent;
	}
	public String getInputAmt() {
		return inputAmt;
	}
	public void setInputAmt(String inputAmt) {
		this.inputAmt = inputAmt;
	}
	public List<Mrt001RentCal> getServiceNameListShowTbl() {
		return serviceNameListShowTbl;
	}
	public void setServiceNameListShowTbl(List<Mrt001RentCal> serviceNameListShowTbl) {
		this.serviceNameListShowTbl = serviceNameListShowTbl;
	}
	public String getvResult() {
		return vResult;
	}
	public void setvResult(String vResult) {
		this.vResult = vResult;
	}
	public String getvMessage() {
		return vMessage;
	}
	public void setvMessage(String vMessage) {
		this.vMessage = vMessage;
	}
	public String getServiceList() {
		return serviceList;
	}
	public void setServiceList(String serviceList) {
		this.serviceList = serviceList;
	}
	public String getServiceShowTbl() {
		return serviceShowTbl;
	}
	public void setServiceShowTbl(String serviceShowTbl) {
		this.serviceShowTbl = serviceShowTbl;
	}
	public String getServiceCalTypeTbl() {
		return serviceCalTypeTbl;
	}
	public void setServiceCalTypeTbl(String serviceCalTypeTbl) {
		this.serviceCalTypeTbl = serviceCalTypeTbl;
	}
	public String getShowAmt() {
		return showAmt;
	}
	public void setShowAmt(String showAmt) {
		this.showAmt = showAmt;
	}
	public boolean isDisableBtnSave() {
		return disableBtnSave;
	}
	public void setDisableBtnSave(boolean disableBtnSave) {
		this.disableBtnSave = disableBtnSave;
	}
	public boolean isDisabledExpenseDesc() {
		return disabledExpenseDesc;
	}
	public void setDisabledExpenseDesc(boolean disabledExpenseDesc) {
		this.disabledExpenseDesc = disabledExpenseDesc;
	}
	
	

}
