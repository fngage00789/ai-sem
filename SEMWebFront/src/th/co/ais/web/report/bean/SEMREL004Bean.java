package th.co.ais.web.report.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.report.AbstractReportBean;

public class SEMREL004Bean extends AbstractReportBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8621663925471015690L;
	
	private List<SelectItem> companyList;
	private List<SelectItem> yearList;
	private List<SelectItem> electricUseTypeList;
	private List<SelectItem> byTypeList;
	private String company;
	private String year;
	private String electricUseType;	
	private String byType;
	private String reportEngine;
	
	public SEMREL004Bean() {
		super(ServiceConstants.TYPE_XLS);
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

	public String getReportEngine() {
		return reportEngine;
	}


	public void setReportEngine(String reportEngine) {
		this.reportEngine = reportEngine;
	}


	public List<SelectItem> getElectricUseTypeList() {
		return electricUseTypeList;
	}


	public void setElectricUseTypeList(List<SelectItem> electricUseTypeList) {
		this.electricUseTypeList = electricUseTypeList;
	}


	public List<SelectItem> getByTypeList() {
		return byTypeList;
	}


	public void setByTypeList(List<SelectItem> byTypeList) {
		this.byTypeList = byTypeList;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getElectricUseType() {
		return electricUseType;
	}


	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}


	public String getByType() {
		return byType;
	}


	public void setByType(String byType) {
		this.byType = byType;
	}
	
}
