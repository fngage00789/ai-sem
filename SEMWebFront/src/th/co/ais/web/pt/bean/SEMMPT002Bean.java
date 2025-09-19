package th.co.ais.web.pt.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.pt.Mpt002Edt;
import th.co.ais.domain.pt.Mpt002Srch;
import th.co.ais.domain.pt.Mpt002SrchHist;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMPT002Bean extends AbstractBean {

	private List<SelectItem> pTaxYearFromList;
	private List<SelectItem> pTaxYearToList;
	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> provinceList;
	private List<SelectItem> amphurList;
	private List<SelectItem> pTaxPayTypeList;
	private List<SelectItem> govtList;

	private List<WrapperBeanObject<Mpt002Srch>> mpt002SrchList;
	private Mpt002Srch mpt002Srch;

	private List<Mpt002Edt> mpt002EdtList;
	private Mpt002Edt mpt002Edt;

	private List<Mpt002SrchHist> mpt002SrchHistList;
	private Mpt002SrchHist mpt002SrchHist;

	private boolean chkSelAll = false;
	private boolean disabledBtnExport = true;

	// for rendered field Seacrh 3 feild
	private boolean tmpGroup1;

	// for rendered field Seacrh 1 feild
	private boolean tmpGroup2;

	private boolean chkPayGovtFlag;

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

	public Mpt002Srch getMpt002Srch() {
		return mpt002Srch;
	}

	public void setMpt002Srch(Mpt002Srch mpt002Srch) {
		this.mpt002Srch = mpt002Srch;
	}

	public List<Mpt002Edt> getMpt002EdtList() {
		return mpt002EdtList;
	}

	public List<Mpt002SrchHist> getMpt002SrchHistList() {
		return mpt002SrchHistList;
	}

	public void setMpt002SrchHistList(List<Mpt002SrchHist> mpt002SrchHistList) {
		this.mpt002SrchHistList = mpt002SrchHistList;
	}

	public Mpt002SrchHist getMpt002SrchHist() {
		return mpt002SrchHist;
	}

	public void setMpt002SrchHist(Mpt002SrchHist mpt002SrchHist) {
		this.mpt002SrchHist = mpt002SrchHist;
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

	public void setMpt002SrchList(
			List<WrapperBeanObject<Mpt002Srch>> mpt002SrchList) {
		this.mpt002SrchList = mpt002SrchList;
	}

	public List<WrapperBeanObject<Mpt002Srch>> getMpt002SrchList() {
		return mpt002SrchList;
	}

	public boolean isChkSelAll() {
		return chkSelAll;
	}

	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
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

	public List<SelectItem> getGovtList() {
		return govtList;
	}

	public void setGovtList(List<SelectItem> govtList) {
		this.govtList = govtList;
	}

}
