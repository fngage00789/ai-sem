package th.co.ais.web.report.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.report.AbstractReportBean;

public class SEMRRT013Bean extends AbstractReportBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3404626579306918920L;
	private List<SelectItem> companyList;
	private List<SelectItem> yearList;
	private List<SelectItem> quaterList;
	private String company;
	private String year;
	private String quater;
	private String vendorCode;
	
	public SEMRRT013Bean() {
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

	public List<SelectItem> getQuaterList() {
		return quaterList;
	}

	public void setQuaterList(List<SelectItem> quaterList) {
		this.quaterList = quaterList;
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

	public String getQuater() {
		return quater;
	}

	public void setQuater(String quater) {
		this.quater = quater;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
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
