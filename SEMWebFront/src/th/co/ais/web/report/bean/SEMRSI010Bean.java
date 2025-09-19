package th.co.ais.web.report.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.report.AbstractReportBean;

public class SEMRSI010Bean extends AbstractReportBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2570515210601914421L;
	private List<SelectItem> companyList;
	private List<SelectItem> siteList;
	//private List<SelectItem> yearList;
	private String company;
	private String year;
	private String siteType;
	private String calType;

	public SEMRSI010Bean() {
		super(ServiceConstants.TYPE_XLS);
	}

	public List<SelectItem> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}

//	public List<SelectItem> getYearList() {
//		return yearList;
//	}
//
//	public void setYearList(List<SelectItem> yearList) {
//		this.yearList = yearList;
//	}

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

	public String getSiteType() {
		return siteType;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	public List<SelectItem> getSiteList() {
		return siteList;
	}

	public void setSiteList(List<SelectItem> siteList) {
		this.siteList = siteList;
	}

	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public String getCalType() {
		return calType;
	}

	public void setCalType(String calType) {
		this.calType = calType;
	}

}
