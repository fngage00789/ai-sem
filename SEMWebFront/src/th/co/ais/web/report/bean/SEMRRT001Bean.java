package th.co.ais.web.report.bean;

import java.util.List;
import java.util.SortedSet;

import javax.faces.model.SelectItem;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.report.AbstractReportBean;

public class SEMRRT001Bean extends AbstractReportBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8621663925471015690L;
	
	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> stationTypeList;
	private String company;
	private String region;
	private String year;
	private String stationType;
	private boolean pico;
	
	public SEMRRT001Bean() {
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


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getStationType() {
		return stationType;
	}


	public void setStationType(String stationType) {
		this.stationType = stationType;
	}


	public boolean isPico() {
		return pico;
	}


	public void setPico(boolean pico) {
		this.pico = pico;
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
