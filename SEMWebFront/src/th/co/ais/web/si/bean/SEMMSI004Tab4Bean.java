package th.co.ais.web.si.bean;

import java.util.List;

import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.domain.si.Msi004SrchPtHistSP;
import th.co.ais.domain.si.PropertyTax;
import th.co.ais.domain.si.SiteInfoMapSiteAcqSP;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMSI004Tab4Bean extends AbstractBean {

	private static final long serialVersionUID = -1717297485875053106L;

	private PropertyTax propertyTax;
	private List<Msi004SrchPtHistSP> propertyTaxHistSPList;
	
	private SiteInfoMapSiteAcqSP siteAppPTObj;
	private SiteInfoMapSiteAcqSP siteAppPTObjParam;
	private List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteAppPTHistList;
	private boolean chkEditPt;
	
	private boolean chkPTEditFlag;
	private String propertyTaxEditFlag = "N";
	
	
	public List<Msi004SrchPtHistSP> getPropertyTaxHistSPList() {
		return propertyTaxHistSPList;
	}

	public void setPropertyTaxHistSPList(
			List<Msi004SrchPtHistSP> propertyTaxHistSPList) {
		this.propertyTaxHistSPList = propertyTaxHistSPList;
	}

	public PropertyTax getPropertyTax() {
		return propertyTax;
	}

	public void setPropertyTax(PropertyTax propertyTax) {
		this.propertyTax = propertyTax;
	}

	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
		
	}

	public SiteInfoMapSiteAcqSP getSiteAppPTObj() {
		return siteAppPTObj;
	}

	public void setSiteAppPTObj(SiteInfoMapSiteAcqSP siteAppPTObj) {
		this.siteAppPTObj = siteAppPTObj;
	}

	public SiteInfoMapSiteAcqSP getSiteAppPTObjParam() {
		return siteAppPTObjParam;
	}

	public void setSiteAppPTObjParam(SiteInfoMapSiteAcqSP siteAppPTObjParam) {
		this.siteAppPTObjParam = siteAppPTObjParam;
	}

	public List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> getSiteAppPTHistList() {
		return siteAppPTHistList;
	}

	public void setSiteAppPTHistList(
			List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteAppPTHistList) {
		this.siteAppPTHistList = siteAppPTHistList;
	}

	public boolean isChkEditPt() {
		return chkEditPt;
	}

	public void setChkEditPt(boolean chkEditPt) {
		this.chkEditPt = chkEditPt;
	}

	public boolean isChkPTEditFlag() {
		return chkPTEditFlag;
	}

	public void setChkPTEditFlag(boolean chkPTEditFlag) {
		this.chkPTEditFlag = chkPTEditFlag;
	}

	public String getPropertyTaxEditFlag() {
		return propertyTaxEditFlag;
	}

	public void setPropertyTaxEditFlag(String propertyTaxEditFlag) {
		this.propertyTaxEditFlag = propertyTaxEditFlag;
	}

}
