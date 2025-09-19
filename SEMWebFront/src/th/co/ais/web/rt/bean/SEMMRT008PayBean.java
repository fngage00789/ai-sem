package th.co.ais.web.rt.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.rt.PettyCashMapPaymentSP;
import th.co.ais.domain.rt.PettyCashPay;
import th.co.ais.domain.rt.PettyCashPaySP;
import th.co.ais.service.util.ServiceConstants;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMRT008PayBean extends AbstractBean {

	private static final long serialVersionUID = -257004826763506625L;
	
	//for search criteria
	private PettyCashPaySP tmpPettyCashPay;
	//for edit data
	private PettyCashPay pettyCashPay;
	//for showing payment info in edit page
	private List<PettyCashMapPaymentSP> pettyCashMapPaySPList;
	//select Item
	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> expenseTypeList;
	private List<SelectItem> payStatusList;
	private List<SelectItem> requestSubjList;
	private List<SelectItem> categoryList;
	//data table
	public List<WrapperBeanObject<PettyCashPaySP>> pettyCashPayList;
	
	//rendered payment info
	private boolean renderedPanelPaymentInfo = true;
	private boolean readOnlyCompany = true;
	
	private boolean disabledBtnExport=true;
	private boolean disableBtnApprove=true;
	private boolean disableBtnCancel=true;
	private Collection<PettyCashPaySP> exList;
	private PettyCashPaySP pettyCashPaySP;
	private boolean displayReportFlag = false;
	
	//Export Excel
	private boolean chkSelAll = false;
	
	private double totalIncRequestAmt = 0;
	
	private String mode = ServiceConstants.MODULE_ACTION_INSERT;
	
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	public List<SelectItem> getPayStatusList() {
		if(payStatusList == null)
			payStatusList = new ArrayList<SelectItem>();
		return payStatusList;
	}
	public void setPayStatusList(List<SelectItem> payStatusList) {
		this.payStatusList = payStatusList;
	}
	
	public List<SelectItem> getExpenseTypeList() {
		if(expenseTypeList == null)
			expenseTypeList = new ArrayList<SelectItem>();
		return expenseTypeList;
	}
	public void setExpenseTypeList(List<SelectItem> expenseTypeList) {
		this.expenseTypeList = expenseTypeList;
	}
	public List<SelectItem> getRegionList() {
		if(regionList == null)
			regionList = new ArrayList<SelectItem>();
		return regionList;
	}
	public void setRegionList(List<SelectItem> regionList) {
		this.regionList = regionList;
	}
	public List<SelectItem> getCompanyList() {
		if(companyList == null)
			companyList = new ArrayList<SelectItem>();
		return companyList;
	}
	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}
	
	public List<WrapperBeanObject<PettyCashPaySP>> getPettyCashPayList() {
		if(pettyCashPayList == null)
			pettyCashPayList = new ArrayList<WrapperBeanObject<PettyCashPaySP>>();
		return pettyCashPayList;
	}
	public void setPettyCashPayList(
			List<WrapperBeanObject<PettyCashPaySP>> pettyCashPayList) {
		this.pettyCashPayList = pettyCashPayList;
	}
	public PettyCashPaySP getTmpPettyCashPay() {
		if(tmpPettyCashPay == null)
			tmpPettyCashPay = new PettyCashPaySP();
		return tmpPettyCashPay;
	}
	public void setTmpPettyCashPay(PettyCashPaySP tmpPettyCashPay) {
		this.tmpPettyCashPay = tmpPettyCashPay;
	}
	public PettyCashPay getPettyCashPay() {
		if(pettyCashPay == null)
			pettyCashPay = new PettyCashPay();
		return pettyCashPay;
	}
	public void setPettyCashPay(PettyCashPay pettyCashPay) {
		this.pettyCashPay = pettyCashPay;
	}
	
	public boolean isChkSelAll() {
		return chkSelAll;
	}
	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}
	
	public boolean isRenderedPanelPaymentInfo() {
		return renderedPanelPaymentInfo;
	}
	public void setRenderedPanelPaymentInfo(boolean renderedPanelPaymentInfo) {
		this.renderedPanelPaymentInfo = renderedPanelPaymentInfo;
	}
	
	public List<PettyCashMapPaymentSP> getPettyCashMapPaySPList() {
		return pettyCashMapPaySPList;
	}
	public void setPettyCashMapPaySPList(
			List<PettyCashMapPaymentSP> pettyCashMapPaySPList) {
		this.pettyCashMapPaySPList = pettyCashMapPaySPList;
	}
	
	public boolean isReadOnlyCompany() {
		return readOnlyCompany;
	}
	public void setReadOnlyCompany(boolean readOnlyCompany) {
		this.readOnlyCompany = readOnlyCompany;
	}
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public boolean isDisabledBtnExport() {
		return disabledBtnExport;
	}
	public void setDisabledBtnExport(boolean disabledBtnExport) {
		this.disabledBtnExport = disabledBtnExport;
	}
	public boolean isDisableBtnApprove() {
		return disableBtnApprove;
	}
	public void setDisableBtnApprove(boolean disableBtnApprove) {
		this.disableBtnApprove = disableBtnApprove;
	}
	public boolean isDisableBtnCancel() {
		return disableBtnCancel;
	}
	public void setDisableBtnCancel(boolean disableBtnCancel) {
		this.disableBtnCancel = disableBtnCancel;
	}
	public List<SelectItem> getRequestSubjList() {
		return requestSubjList;
	}
	public void setRequestSubjList(List<SelectItem> requestSubjList) {
		this.requestSubjList = requestSubjList;
	}
	public List<SelectItem> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<SelectItem> categoryList) {
		this.categoryList = categoryList;
	}
	public Collection<PettyCashPaySP> getExList() {
		return exList;
	}
	public void setExList(Collection<PettyCashPaySP> exList) {
		this.exList = exList;
	}
	public PettyCashPaySP getPettyCashPaySP() {
		return pettyCashPaySP;
	}
	public void setPettyCashPaySP(PettyCashPaySP pettyCashPaySP) {
		this.pettyCashPaySP = pettyCashPaySP;
	}
	public boolean isDisplayReportFlag() {
		return displayReportFlag;
	}
	public void setDisplayReportFlag(boolean displayReportFlag) {
		this.displayReportFlag = displayReportFlag;
	}
	public double getTotalIncRequestAmt() {
		return totalIncRequestAmt;
	}
	public void setTotalIncRequestAmt(double totalIncRequestAmt) {
		this.totalIncRequestAmt = totalIncRequestAmt;
	}
	
	
}
