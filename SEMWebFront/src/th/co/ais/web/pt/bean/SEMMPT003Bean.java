package th.co.ais.web.pt.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.pt.Mpt002Edt;
import th.co.ais.domain.pt.Mpt003Srch;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;
import th.co.ais.web.report.AbstractReportBean;

public class SEMMPT003Bean extends AbstractBean{

	private List<SelectItem> pTaxYearFromList;
	private List<SelectItem> pTaxYearToList;
	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> provinceList;
	private List<SelectItem> amphurList;
	private List<SelectItem> pTaxPayTypeList;
	private List<SelectItem> pTaxEstmStatusList;
	private List<SelectItem> paymentStatusList;
	private List<SelectItem> govtList;

	private List<WrapperBeanObject<Mpt003Srch>> mpt003SrchList;
	private Mpt003Srch mpt003Srch;

	private List<Mpt002Edt> mpt002EdtList;
	private Mpt002Edt mpt002Edt;

	private boolean validateBtn;

	private boolean chkSelAll = false;
	private boolean disabledBtnExport = true;
	private boolean disabledBtnEstimate = true;

	// Render message form search
	private boolean renderedMsgFormSearch = true;

	// for rendered field Seacrh 3 feild
	private boolean tmpGroup1;

	// for rendered field Seacrh 1 feild
	private boolean tmpGroup2;

	private boolean chkPayGovtFlag;

	private boolean chkEditBox;
	private boolean disableEditPropertyTax = true;
	private boolean displayReportFlag = false;
	private boolean displayReportExcelFlag = false;
	private boolean renderedOnToDoList = false;
	
	private boolean popupClose = false;
	
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
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

	public List<SelectItem> getAmphurList() {
		return amphurList;
	}

	public void setAmphurList(List<SelectItem> amphurList) {
		this.amphurList = amphurList;
	}

	public List<SelectItem> getpTaxPayTypeList() {
		return pTaxPayTypeList;
	}

	public void setpTaxPayTypeList(List<SelectItem> pTaxPayTypeList) {
		this.pTaxPayTypeList = pTaxPayTypeList;
	}

	public List<SelectItem> getpTaxEstmStatusList() {
		return pTaxEstmStatusList;
	}

	public void setpTaxEstmStatusList(List<SelectItem> pTaxEstmStatusList) {
		this.pTaxEstmStatusList = pTaxEstmStatusList;
	}

	public List<SelectItem> getPaymentStatusList() {
		return paymentStatusList;
	}

	public void setPaymentStatusList(List<SelectItem> paymentStatusList) {
		this.paymentStatusList = paymentStatusList;
	}

	public Mpt003Srch getMpt003Srch() {
		return mpt003Srch;
	}

	public void setMpt003Srch(Mpt003Srch mpt003Srch) {
		this.mpt003Srch = mpt003Srch;
	}

	public List<Mpt002Edt> getMpt002EdtList() {
		return mpt002EdtList;
	}

	public void setMpt002EdtList(List<Mpt002Edt> mpt002EdtList) {
		this.mpt002EdtList = mpt002EdtList;
	}

	public Mpt002Edt getMpt002Edt() {
		return mpt002Edt;
	}

	public void setMpt002Edt(Mpt002Edt mpt002Edt) {
		this.mpt002Edt = mpt002Edt;
	}

	public void setValidateBtn(boolean validateBtn) {
		this.validateBtn = validateBtn;
	}

	public boolean isValidateBtn() {
		return validateBtn;
	}

	public void setMpt003SrchList(
			List<WrapperBeanObject<Mpt003Srch>> mpt003SrchList) {
		this.mpt003SrchList = mpt003SrchList;
	}

	public List<WrapperBeanObject<Mpt003Srch>> getMpt003SrchList() {
		return mpt003SrchList;
	}

	public boolean isRenderedMsgFormSearch() {
		return renderedMsgFormSearch;
	}

	public void setRenderedMsgFormSearch(boolean renderedMsgFormSearch) {
		this.renderedMsgFormSearch = renderedMsgFormSearch;
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

	public List<SelectItem> getGovtList() {
		return govtList;
	}

	public void setGovtList(List<SelectItem> govtList) {
		this.govtList = govtList;
	}

	public boolean isDisabledBtnEstimate() {
		return disabledBtnEstimate;
	}

	public void setDisabledBtnEstimate(boolean disabledBtnEstimate) {
		this.disabledBtnEstimate = disabledBtnEstimate;
	}

	public boolean isChkEditBox() {
		return chkEditBox;
	}

	public void setChkEditBox(boolean chkEditBox) {
		this.chkEditBox = chkEditBox;
	}

	public boolean isDisableEditPropertyTax() {
		return disableEditPropertyTax;
	}

	public void setDisableEditPropertyTax(boolean disableEditPropertyTax) {
		this.disableEditPropertyTax = disableEditPropertyTax;
	}

	public boolean isDisplayReportFlag() {
		return displayReportFlag;
	}

	public void setDisplayReportFlag(boolean displayReportFlag) {
		this.displayReportFlag = displayReportFlag;
	}

	public boolean isPopupClose() {
		return popupClose;
	}

	public void setPopupClose(boolean popupClose) {
		this.popupClose = popupClose;
	}

	public boolean isDisplayReportExcelFlag() {
		return displayReportExcelFlag;
	}

	public void setDisplayReportExcelFlag(boolean displayReportExcelFlag) {
		this.displayReportExcelFlag = displayReportExcelFlag;
	}

	public boolean isRenderedOnToDoList() {
		return renderedOnToDoList;
	}

	public void setRenderedOnToDoList(boolean renderedOnToDoList) {
		this.renderedOnToDoList = renderedOnToDoList;
	}
	
}
