package th.co.ais.web.report.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.report.AbstractReportBean;

public class SEMRSI013Bean extends AbstractReportBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3076747029803625776L;
	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> monthList;
	private List<SelectItem> siteTypeList;
	
	
	private String company;
	private String region;
	private String siteType;
	private String year;
	private String month;
	private boolean reportSummaryFlag;

	



	public List<SelectItem> getSiteTypeList() {
		return siteTypeList;
	}


	public void setSiteTypeList(List<SelectItem> siteTypeList) {
		this.siteTypeList = siteTypeList;
	}


	public String getSiteType() {
		return siteType;
	}


	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}


	public SEMRSI013Bean() {
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


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}




	public boolean isReportSummaryFlag() {
		return reportSummaryFlag;
	}


	public void setReportSummaryFlag(boolean reportSummaryFlag) {
		this.reportSummaryFlag = reportSummaryFlag;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public List<SelectItem> getMonthList() {
		return monthList;
	}


	public void setMonthList(List<SelectItem> monthList) {
		this.monthList = monthList;
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

	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

}
