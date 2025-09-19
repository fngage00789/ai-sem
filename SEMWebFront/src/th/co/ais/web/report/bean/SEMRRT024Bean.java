package th.co.ais.web.report.bean;

import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.report.AbstractReportBean;

public class SEMRRT024Bean extends AbstractReportBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2842680702390308982L;
	/**
	 * 
	 */
	
	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private String company;
	private String region;
	private Date startDate;
	private Date startToDate;
	private Date endDate;
	private Date endToDate;
	private String locationId;
	private String contracNo;
	
	
	public SEMRRT024Bean(){
		super(ServiceConstants.TYPE_XLS);
	}
	
	@Override
	public int getRowPerPage() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		// TODO Auto-generated method stub
		
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getStartToDate() {
		return startToDate;
	}

	public void setStartToDate(Date startToDate) {
		this.startToDate = startToDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getEndToDate() {
		return endToDate;
	}

	public void setEndToDate(Date endToDate) {
		this.endToDate = endToDate;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getContracNo() {
		return contracNo;
	}

	public void setContracNo(String contracNo) {
		this.contracNo = contracNo;
	}
	 
	
	

}
