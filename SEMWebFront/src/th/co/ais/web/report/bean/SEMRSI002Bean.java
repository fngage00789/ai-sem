package th.co.ais.web.report.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.report.AbstractReportBean;

public class SEMRSI002Bean extends AbstractReportBean {

	private List<SelectItem> companyList;
	private String company;
	private String year;
	private String processFrom;
	private String processTo;
	private String slaType;
	
	private List<SelectItem> processFromList;
	private List<SelectItem> processToList;
	private List<SelectItem> slaTypeList;

	public SEMRSI002Bean() {
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


	public String getProcessFrom() {
		return processFrom;
	}

	public void setProcessFrom(String processFrom) {
		this.processFrom = processFrom;
	}

	public String getProcessTo() {
		return processTo;
	}

	public void setProcessTo(String processTo) {
		this.processTo = processTo;
	}

	public String getSlaType() {
		return slaType;
	}

	public void setSlaType(String slaType) {
		this.slaType = slaType;
	}

	public List<SelectItem> getProcessFromList() {
		return processFromList;
	}

	public void setProcessFromList(List<SelectItem> processFromList) {
		this.processFromList = processFromList;
	}

	public List<SelectItem> getProcessToList() {
		return processToList;
	}

	public void setProcessToList(List<SelectItem> processToList) {
		this.processToList = processToList;
	}

	public List<SelectItem> getSlaTypeList() {
		return slaTypeList;
	}

	public void setSlaTypeList(List<SelectItem> slaTypeList) {
		this.slaTypeList = slaTypeList;
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
