package th.co.ais.web.report.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.report.AbstractReportBean;

public class SEMREL005Bean extends AbstractReportBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8621663925471015690L;
	
	private List<SelectItem> companyList;	
	private List<SelectItem> regionList;
	private List<SelectItem> yearList;
	private List<SelectItem> electricUseTypeList;
	private List<SelectItem> siteStatusList;
	private String company;
	private String region;
	private String electricUseType;
	private String year;	
	private String reportEngine;
	private String warrantType;
	private String numMonthType;
	private String siteStatus;
	
	public SEMREL005Bean() {
		super(ServiceConstants.TYPE_XLS);
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


	public List<SelectItem> getYearList() {
		return yearList;
	}


	public void setYearList(List<SelectItem> yearList) {
		this.yearList = yearList;
	}

	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
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


	public String getWarrantType() {
		return warrantType;
	}


	public void setWarrantType(String warrantType) {
		this.warrantType = warrantType;
	}


	public String getNumMonthType() {
		return numMonthType;
	}


	public void setNumMonthType(String numMonthType) {
		this.numMonthType = numMonthType;
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
	
}
