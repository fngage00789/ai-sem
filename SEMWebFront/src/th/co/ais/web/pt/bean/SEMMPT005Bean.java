package th.co.ais.web.pt.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.pt.Mpt004Srch;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMPT005Bean extends AbstractBean {

	private List<SelectItem> companyList;
	private List<SelectItem> pTaxYearFromList;
	private List<SelectItem> pTaxYearToList;
	private List<SelectItem> periodFromList;
	private List<SelectItem> periodToList;
	private List<SelectItem> pTaxPayTypeList;
	private List<SelectItem> expenseTypeList;
	private List<SelectItem> regionList;
	private List<SelectItem> provinceList;
	private List<SelectItem> amphurList;
	private List<SelectItem> paymentTypeList;
	private List<SelectItem> paymentStatusList;
	private List<SelectItem> govtList;

	private List<WrapperBeanObject<Mpt004Srch>> mpt004SrchList;
	private Mpt004Srch mpt004Srch;

	private boolean chkSelAll = false;
	private boolean disabledBtnExport = true;

	// Render message form search
	private boolean renderedMsgFormSearch = true;

	private boolean chkPayGovtFlag;
	private boolean tmpEstimateFlag;
	private boolean tmpPayGovtFlag;

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

	public List<SelectItem> getExpenseTypeList() {
		return expenseTypeList;
	}

	public void setExpenseTypeList(List<SelectItem> expenseTypeList) {
		this.expenseTypeList = expenseTypeList;
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

	public List<SelectItem> getAmphurList() {
		return amphurList;
	}

	public void setAmphurList(List<SelectItem> amphurList) {
		this.amphurList = amphurList;
	}

	public List<SelectItem> getPaymentTypeList() {
		return paymentTypeList;
	}

	public void setPaymentTypeList(List<SelectItem> paymentTypeList) {
		this.paymentTypeList = paymentTypeList;
	}

	public Mpt004Srch getMpt004Srch() {
		return mpt004Srch;
	}

	public void setMpt004Srch(Mpt004Srch mpt004Srch) {
		this.mpt004Srch = mpt004Srch;
	}

	public void setRenderedMsgFormSearch(boolean renderedMsgFormSearch) {
		this.renderedMsgFormSearch = renderedMsgFormSearch;
	}

	public boolean isRenderedMsgFormSearch() {
		return renderedMsgFormSearch;
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

	public void setChkPayGovtFlag(boolean chkPayGovtFlag) {
		this.chkPayGovtFlag = chkPayGovtFlag;
	}

	public boolean isChkPayGovtFlag() {
		return chkPayGovtFlag;
	}

	public void setPaymentStatusList(List<SelectItem> paymentStatusList) {
		this.paymentStatusList = paymentStatusList;
	}

	public List<SelectItem> getPaymentStatusList() {
		return paymentStatusList;
	}

	public List<SelectItem> getGovtList() {
		return govtList;
	}

	public void setGovtList(List<SelectItem> govtList) {
		this.govtList = govtList;
	}

	public boolean isTmpEstimateFlag() {
		return tmpEstimateFlag;
	}

	public void setTmpEstimateFlag(boolean tmpEstimateFlag) {
		this.tmpEstimateFlag = tmpEstimateFlag;
	}

	public boolean isTmpPayGovtFlag() {
		return tmpPayGovtFlag;
	}

	public void setTmpPayGovtFlag(boolean tmpPayGovtFlag) {
		this.tmpPayGovtFlag = tmpPayGovtFlag;
	}

}
