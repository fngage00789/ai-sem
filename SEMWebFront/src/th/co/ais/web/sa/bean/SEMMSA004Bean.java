package th.co.ais.web.sa.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMSA004Bean extends AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// --- LOVs ---
	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> siteStatusList;
	
	// --- result list ---
	public List<WrapperBeanObject<SiteAppSP>> exctApproveList;
	
	// --- criteria object ---
	private SiteAppSP siteAppObjParam; 
	
	// --- true/false renderer ---
	private boolean renderedMsgAlert = false;
	
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

	public List<SelectItem> getSiteStatusList() {
		return siteStatusList;
	}

	public void setSiteStatusList(List<SelectItem> siteStatusList) {
		this.siteStatusList = siteStatusList;
	}

	public List<WrapperBeanObject<SiteAppSP>> getExctApproveList() {
		return exctApproveList;
	}

	public void setExctApproveList(
			List<WrapperBeanObject<SiteAppSP>> exctApproveList) {
		this.exctApproveList = exctApproveList;
	}

	public SiteAppSP getSiteAppObjParam() {
		return siteAppObjParam;
	}

	public void setSiteAppObjParam(SiteAppSP siteAppObjParam) {
		this.siteAppObjParam = siteAppObjParam;
	}

	public boolean isRenderedMsgAlert() {
		return renderedMsgAlert;
	}

	public void setRenderedMsgAlert(boolean renderedMsgAlert) {
		this.renderedMsgAlert = renderedMsgAlert;
	}

	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		// TODO Auto-generated method stub

	}

}
