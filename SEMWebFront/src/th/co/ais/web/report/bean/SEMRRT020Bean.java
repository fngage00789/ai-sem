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

public class SEMRRT020Bean extends AbstractReportBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8800629180536303683L;
	private List<SelectItem> companyList;
	private List<SelectItem> masterGroupList;
	private String company;
	private String monthYear;
	private String[] masterGroup;
	
	public SEMRRT020Bean() {
		super(ServiceConstants.TYPE_XLS);
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

	public List<SelectItem> getMasterGroupList() {
		return masterGroupList;
	}

	public void setMasterGroupList(List<SelectItem> masterGroupList) {
		this.masterGroupList = masterGroupList;
	}

	public String getMonthYear() {
		return monthYear;
	}

	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}


	public String[] getMasterGroup() {
		return masterGroup;
	}

	public void setMasterGroup(String[] masterGroup) {
		this.masterGroup = masterGroup;
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
