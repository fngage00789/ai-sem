package th.co.ais.web.report.bean;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.bean.common.PopupMultiVendorBean;
import th.co.ais.web.bean.common.PopupSiteMultiContractBean;
import th.co.ais.web.bean.common.PopupSiteMultiLocationBean;
import th.co.ais.web.bean.common.PopupSiteMultiRegionBean;
import th.co.ais.web.report.AbstractReportBean;

public class SEMRRT017Bean extends AbstractReportBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8800629180536303683L;
	private List<SelectItem> companyList;
	private List<SelectItem> yearList;
	private List<SelectItem> monthList;
	private String company;
	private String year;
	private String month;
	private String region;

	private PopupSiteMultiRegionBean popupSiteMultiRegionBean;
	
	public SEMRRT017Bean() {
		super(ServiceConstants.TYPE_XLS);
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

	public List<SelectItem> getYearList() {
		return yearList;
	}

	public void setYearList(List<SelectItem> yearList) {
		this.yearList = yearList;
	}

	public List<SelectItem> getMonthList() {
		return monthList;
	}

	public void setMonthList(List<SelectItem> monthList) {
		this.monthList = monthList;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
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
