package th.co.ais.web.report.bean;

import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.bean.common.PopupMultiVendorBean;
import th.co.ais.web.bean.common.PopupSiteMultiContractBean;
import th.co.ais.web.bean.common.PopupSiteMultiLocationBean;
import th.co.ais.web.bean.common.PopupSiteMultiRegionBean;
import th.co.ais.web.report.AbstractReportBean;

public class SEMRRT015Bean extends AbstractReportBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8621663925471015690L;
	
	private List<SelectItem> companyList;
	private String company;
	private String contractNo;
	private String locationId;
	private String region;
	private Date asOf;
	
	private PopupSiteMultiContractBean popupSiteMultiContractBean;
	private PopupSiteMultiLocationBean popupSiteMultiLocationBean;
	private PopupSiteMultiRegionBean popupSiteMultiRegionBean;
	
	public SEMRRT015Bean() {
		super(ServiceConstants.TYPE_XLS);
	}
	
	
	public PopupSiteMultiContractBean getPopupSiteMultiContractBean() {
		return (PopupSiteMultiContractBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupSiteMultiContractBean");
	}


	public void setPopupSiteMultiContractBean(
			PopupSiteMultiContractBean popupSiteMultiContractBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupSiteMultiContractBean", popupSiteMultiContractBean);
	}
	
	public PopupSiteMultiLocationBean getPopupSiteMultiLocationBean() {
		return (PopupSiteMultiLocationBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupSiteMultiLocationBean");
	}


	public void setPopupSiteMultiLocationBean(
			PopupSiteMultiLocationBean popupSiteMultiLocationBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupSiteMultiLocationBean", popupSiteMultiLocationBean);
	}
	
	public PopupSiteMultiRegionBean getPopupSiteMultiRegionBean() {
		return (PopupSiteMultiRegionBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupSiteMultiRegionBean");
	}


	public void setPopupSiteMultiRegionBean(
			PopupSiteMultiRegionBean popupSiteMultiRegionBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupSiteMultiRegionBean", popupSiteMultiRegionBean);
	}

	public List<SelectItem> getCompanyList() {
		return companyList;
	}


	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getContractNo() {
		return contractNo;
	}


	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}


	public String getLocationId() {
		return locationId;
	}


	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public Date getAsOf() {
		return asOf;
	}


	public void setAsOf(Date asOf) {
		this.asOf = asOf;
	}


	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	
	
}
