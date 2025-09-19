package th.co.ais.web.ac.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.ac.Mac001Srch;
import th.co.ais.domain.ac.Mac001SrchD;
import th.co.ais.domain.sap.SapTrxHdr;
import th.co.ais.domain.sap.SapTrxLog;
import th.co.ais.domain.sap.SapTrxLogSrch;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMAC002Bean extends AbstractBean{

	private List<SelectItem> companyList;
	private List<SelectItem> sapStatusList;
	
	private SapTrxLogSrch sapTrxLogSrch;
	//private List<SapTrxLog> sapTrxLogSrchList;
	private List<WrapperBeanObject<SapTrxLog>> sapTrxLogSrchList;
	private SapTrxLog sapTrxLogSelected;
	
	private boolean chkSelAll;
	private boolean disabledBtnRegenerate;
	private boolean renderedMsgFormSearch = true;
	
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
	public void setRenderedMsgFormSearch(boolean renderedMsgFormSearch) {
		this.renderedMsgFormSearch = renderedMsgFormSearch;
	}
	
	/*public void setSapTrxLogSrchList(List<SapTrxLog> sapTrxLogSrchList) {
		this.sapTrxLogSrchList = sapTrxLogSrchList;
	}
	public List<SapTrxLog> getSapTrxLogSrchList() {
		return sapTrxLogSrchList;
	}*/
	public void setSapTrxLogSrch(SapTrxLogSrch sapTrxLogSrch) {
		this.sapTrxLogSrch = sapTrxLogSrch;
	}
	public SapTrxLogSrch getSapTrxLogSrch() {
		return sapTrxLogSrch;
	}
	public void setSapStatusList(List<SelectItem> sapStatusList) {
		this.sapStatusList = sapStatusList;
	}
	public List<SelectItem> getSapStatusList() {
		return sapStatusList;
	}
	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}
	public boolean isChkSelAll() {
		return chkSelAll;
	}
	public void setSapTrxLogSelected(SapTrxLog sapTrxLogSelected) {
		this.sapTrxLogSelected = sapTrxLogSelected;
	}
	public SapTrxLog getSapTrxLogSelected() {
		return sapTrxLogSelected;
	}
	public void setSapTrxLogSrchList(List<WrapperBeanObject<SapTrxLog>> sapTrxLogSrchList) {
		this.sapTrxLogSrchList = sapTrxLogSrchList;
	}
	public List<WrapperBeanObject<SapTrxLog>> getSapTrxLogSrchList() {
		return sapTrxLogSrchList;
	}
	public void setDisabledBtnRegenerate(boolean disabledBtnRegenerate) {
		this.disabledBtnRegenerate = disabledBtnRegenerate;
	}
	public boolean isDisabledBtnRegenerate() {
		return disabledBtnRegenerate;
	}
}
