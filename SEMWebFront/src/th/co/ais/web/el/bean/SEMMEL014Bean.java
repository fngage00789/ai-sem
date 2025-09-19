package th.co.ais.web.el.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.el.ELDpstCondSP;
import th.co.ais.domain.el.ELVerifyCondSP;
import th.co.ais.domain.el.ElVerifySP;
import th.co.ais.domain.el.ManagementWrapper;
import th.co.ais.domain.el.SchVerMasterSP;
import th.co.ais.domain.rt.Mrt001RentCal;
import th.co.ais.domain.rt.VerifyRentalSearchSiteRentCondSP;
import th.co.ais.web.bean.AbstractBean;
import th.co.ais.web.el.action.SEMMEL014Action;

public class SEMMEL014Bean extends AbstractBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4324026628471709531L;
	
	private String tabIndex;
	private SchVerMasterSP verMaster;
	private List<ManagementWrapper> verifyCondList;
	private List<ManagementWrapper> verifyDtlList;
	private List<ManagementWrapper> verifyHistList;
	private List<ManagementWrapper> dpstCondList;
	private List<ManagementWrapper> dpstDtlList;
	private String selectedIndex;
	private String selectedRowIndex;
	private ELVerifyCondSP verifySP;
	private ELVerifyCondSP verifySPDel;
	private ELDpstCondSP dpstConSP;
	private ELDpstCondSP dpstConSPDel;
	
	private List<SelectItem> periodTypeList;
	private List<SelectItem> vendorList;
	private List<SelectItem> payeeList;
	
	private List<SelectItem> meterList;
	private String electricId;
	
	//added by Kanruethai.T 20180905 
	public List<SelectItem> serviceNameList;
	public String serviceCalTypeId;
	public String serviceCalTypeIdToCal; 
	public String serviceCalTypeIdToCalName;
	public ArrayList<Double> servicePercent;
	public ArrayList<Double> serviceCustom;
	public List<SelectItem> serviceTypeToCalList;
	public List<ElVerifySP> serviceNameListShowTbl;
	public Double configRate;
	public String inputPercent;
	public String inputAmt;
	public String vResult;
	public String vMessage;
	public String serviceList;
	public String serviceShowTbl;
	public String serviceCalTypeTbl;
	public String showAmt;
	
	private List<VerifyRentalSearchSiteRentCondSP> rentCondList;
	private VerifyRentalSearchSiteRentCondSP rentCondSpecial;
	
	private boolean renderedMsgFormPopup = false;
	private String contractNo;
	private String expenseType;
	private Date effDt;
	private Date expDt;
	private String periodType;
	private Date periodStartDt;
	private Double periodNo;
	
	private String paymentId;
	private String rowId;
	
	private Date termOfPaymentDt;
	private Date fromTermOfPaymentDt;
	private Date toTermOfPaymentDt;
	private String meterId;
	private String periodNoStart;
	
	public SchVerMasterSP getVerMaster() {
		return verMaster;
	}

	public void setVerMaster(SchVerMasterSP verMaster) {
		this.verMaster = verMaster;
	}

	public List<ManagementWrapper> getVerifyCondList() {
		return verifyCondList;
	}

	public void setVerifyCondList(List<ManagementWrapper> verifyCondList) {
		this.verifyCondList = verifyCondList;
	}
	

	public String getSelectedIndex() {
		return selectedIndex;
	}

	public void setSelectedIndex(String selectedIndex) {
		this.selectedIndex = selectedIndex;
	}
	
	public List<ManagementWrapper> getVerifyDtlList() {
		return verifyDtlList;
	}

	public void setVerifyDtlList(List<ManagementWrapper> verifyDtlList) {
		this.verifyDtlList = verifyDtlList;
	}

	
	public List<ManagementWrapper> getVerifyHistList() {
		return verifyHistList;
	}

	public void setVerifyHistList(List<ManagementWrapper> verifyHistList) {
		this.verifyHistList = verifyHistList;
	}
	

	public String getSelectedRowIndex() {
		return selectedRowIndex;
	}

	public void setSelectedRowIndex(String selectedRowIndex) {
		this.selectedRowIndex = selectedRowIndex;
	}

	public ELVerifyCondSP getVerifySP() {
		return verifySP;
	}

	public void setVerifySP(ELVerifyCondSP verifySP) {
		this.verifySP = verifySP;
	}

	@Override
	public int getRowPerPage() {
		// TODO Auto-generated method stub
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		// TODO Auto-generated method stub
		this.rowPerPage = rowPerPage;
	}

	public List<SelectItem> getPeriodTypeList() {
		return periodTypeList;
	}

	public void setPeriodTypeList(List<SelectItem> periodTypeList) {
		this.periodTypeList = periodTypeList;
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

	public ELVerifyCondSP getVerifySPDel() {
		return verifySPDel;
	}

	public void setVerifySPDel(ELVerifyCondSP verifySPDel) {
		this.verifySPDel = verifySPDel;
	}

	public List<ManagementWrapper> getDpstCondList() {
		return dpstCondList;
	}

	public void setDpstCondList(List<ManagementWrapper> dpstCondList) {
		this.dpstCondList = dpstCondList;
	}

	public List<ManagementWrapper> getDpstDtlList() {
		return dpstDtlList;
	}

	public void setDpstDtlList(List<ManagementWrapper> dpstDtlList) {
		this.dpstDtlList = dpstDtlList;
	}

	public ELDpstCondSP getDpstConSP() {
		return dpstConSP;
	}

	public void setDpstConSP(ELDpstCondSP dpstConSP) {
		this.dpstConSP = dpstConSP;
	}

	public String getTabIndex() {
		return tabIndex;
	}

	public void setTabIndex(String tabIndex) {
		this.tabIndex = tabIndex;
	}

	public ELDpstCondSP getDpstConSPDel() {
		return dpstConSPDel;
	}

	public void setDpstConSPDel(ELDpstCondSP dpstConSPDel) {
		this.dpstConSPDel = dpstConSPDel;
	}

	public List<SelectItem> getMeterList() {
		return meterList;
	}

	public void setMeterList(List<SelectItem> meterList) {
		this.meterList = meterList;
	}
	
	public void checkMeterIdFormDD(){
		
		verifySP.setMeterId(meterList.get(0).getLabel());
	
	}

	public String getElectricId() {
		return electricId;
	}

	public void setElectricId(String electricId) {
		this.electricId = electricId;
	}

	public List<SelectItem> getServiceNameList() {
		return serviceNameList;
	}

	public void setServiceNameList(List<SelectItem> serviceNameList) {
		this.serviceNameList = serviceNameList;
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

	public String getServiceCalTypeIdToCalName() {
		return serviceCalTypeIdToCalName;
	}

	public void setServiceCalTypeIdToCalName(String serviceCalTypeIdToCalName) {
		this.serviceCalTypeIdToCalName = serviceCalTypeIdToCalName;
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

	public List<SelectItem> getServiceTypeToCalList() {
		return serviceTypeToCalList;
	}

	public void setServiceTypeToCalList(List<SelectItem> serviceTypeToCalList) {
		this.serviceTypeToCalList = serviceTypeToCalList;
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

	public List<VerifyRentalSearchSiteRentCondSP> getRentCondList() {
		return rentCondList;
	}

	public void setRentCondList(List<VerifyRentalSearchSiteRentCondSP> rentCondList) {
		this.rentCondList = rentCondList;
	}

	public VerifyRentalSearchSiteRentCondSP getRentCondSpecial() {
		return rentCondSpecial;
	}

	public void setRentCondSpecial(VerifyRentalSearchSiteRentCondSP rentCondSpecial) {
		this.rentCondSpecial = rentCondSpecial;
	}

	public List<ElVerifySP> getServiceNameListShowTbl() {
		return serviceNameListShowTbl;
	}

	public void setServiceNameListShowTbl(List<ElVerifySP> serviceNameListShowTbl) {
		this.serviceNameListShowTbl = serviceNameListShowTbl;
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

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
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

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public Date getTermOfPaymentDt() {
		return termOfPaymentDt;
	}

	public void setTermOfPaymentDt(Date termOfPaymentDt) {
		this.termOfPaymentDt = termOfPaymentDt;
	}

	public Date getFromTermOfPaymentDt() {
		return fromTermOfPaymentDt;
	}

	public void setFromTermOfPaymentDt(Date fromTermOfPaymentDt) {
		this.fromTermOfPaymentDt = fromTermOfPaymentDt;
	}

	public Date getToTermOfPaymentDt() {
		return toTermOfPaymentDt;
	}

	public void setToTermOfPaymentDt(Date toTermOfPaymentDt) {
		this.toTermOfPaymentDt = toTermOfPaymentDt;
	}

	public String getMeterId() {
		return meterId;
	}

	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}

	public String getPeriodNoStart() {
		return periodNoStart;
	}

	public void setPeriodNoStart(String periodNoStart) {
		this.periodNoStart = periodNoStart;
	}
	
}
