package th.co.ais.web.report.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.report.AbstractReportBean;

public class SEMRRT002Bean extends AbstractReportBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8621663925471015690L;
	
	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> stationTypeList;
	
	private String company;
	private String region;
	private String monthYear;
	private String stationType;
	private boolean pico;
	
	public SEMRRT002Bean() {
		super(ServiceConstants.TYPE_XLS);
	}
	
	
	public String getMonthYear() {
		return monthYear;
	}


	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}


	public boolean isPico() {
		return pico;
	}


	public void setPico(boolean pico) {
		this.pico = pico;
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


	public List<SelectItem> getStationTypeList() {
		return stationTypeList;
	}


	public void setStationTypeList(List<SelectItem> stationTypeList) {
		this.stationTypeList = stationTypeList;
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


	public String getStationType() {
		return stationType;
	}


	public void setStationType(String stationType) {
		this.stationType = stationType;
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
