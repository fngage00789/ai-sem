package th.co.ais.web.report.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.report.AbstractReportBean;

public class SEMRSI004Bean extends AbstractReportBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3511727259213038463L;
	private List<SelectItem> companyList;
	private List<SelectItem> monthList;
	private String company;
	private String year;
	private String monthFrom;
	private String monthTo;

	public SEMRSI004Bean() {
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}


	public List<SelectItem> getMonthList() {
		return monthList;
	}

	public void setMonthList(List<SelectItem> monthList) {
		this.monthList = monthList;
	}

	
	public String getMonthFrom() {
		return monthFrom;
	}

	public void setMonthFrom(String monthFrom) {
		this.monthFrom = monthFrom;
	}

	public String getMonthTo() {
		return monthTo;
	}

	public void setMonthTo(String monthTo) {
		this.monthTo = monthTo;
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
