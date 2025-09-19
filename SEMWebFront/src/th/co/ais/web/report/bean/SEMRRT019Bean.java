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

public class SEMRRT019Bean extends AbstractReportBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8800629180536303683L;
	private List<SelectItem> companyList;
	private List<SelectItem> masterGroupList;
//	private List<SelectItem> contractList;
//	private List<SelectItem> yearList;
//	private List<SelectItem> monthList;
	private String company;
//	private String year;
//	private String month;
//	private String region;
	private String monthYear;
	private String[] masterGroups;
	private String contract;

	private PopupSiteMultiRegionBean popupSiteMultiRegionBean;
	
	public SEMRRT019Bean() {
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
	
	public List<SelectItem> getMasterGroupList() {
		return masterGroupList;
	}

	public void setMasterGroupList(List<SelectItem> masterGroupList) {
		this.masterGroupList = masterGroupList;
	}
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getMonthYear() {
		return monthYear;
	}

	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}

	public String[] getMasterGroups() {
		return masterGroups;
	}

	public void setMasterGroups(String[] masterGroups) {
		this.masterGroups = masterGroups;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
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
