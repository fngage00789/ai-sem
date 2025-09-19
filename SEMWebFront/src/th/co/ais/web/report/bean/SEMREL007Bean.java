package th.co.ais.web.report.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.report.AbstractReportBean;

public class SEMREL007Bean extends AbstractReportBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8621663925471015690L;
	
	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> yearList;
	private List<SelectItem> electricUseTypeList;
	private List<SelectItem> expenseTypeList;
	private List<SelectItem> siteStatusList;
	private String company;
	private String region;
	private String year;
	private String electricUseType;
	private String expenseType;
	private String reportEngine;
	private String siteStatus;
	private boolean groupBylocation =false ;
	
	public SEMREL007Bean() {
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


	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}


	public List<SelectItem> getElectricUseTypeList() {
		return electricUseTypeList;
	}


	public void setElectricUseTypeList(List<SelectItem> electricUseTypeList) {
		this.electricUseTypeList = electricUseTypeList;
	}


	public String getElectricUseType() {
		return electricUseType;
	}


	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}


	public String getReportEngine() {
		return reportEngine;
	}


	public void setReportEngine(String reportEngine) {
		this.reportEngine = reportEngine;
	}


	public List<SelectItem> getExpenseTypeList() {
		return expenseTypeList;
	}


	public void setExpenseTypeList(List<SelectItem> expenseTypeList) {
		this.expenseTypeList = expenseTypeList;
	}


	public String getExpenseType() {
		return expenseType;
	}


	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}


	public List<SelectItem> getRegionList() {
		return regionList;
	}


	public void setRegionList(List<SelectItem> regionList) {
		this.regionList = regionList;
	}


	public List<SelectItem> getYearList() {
		return yearList;
	}


	public void setYearList(List<SelectItem> yearList) {
		this.yearList = yearList;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public List<SelectItem> getSiteStatusList() {
		return siteStatusList;
	}


	public void setSiteStatusList(List<SelectItem> siteStatusList) {
		this.siteStatusList = siteStatusList;
	}


	public String getSiteStatus() {
		return siteStatus;
	}


	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}


	public boolean isGroupBylocation() {
		return groupBylocation;
	}


	public void setGroupBylocation(boolean groupBylocation) {
		this.groupBylocation = groupBylocation;
	}
	
}
