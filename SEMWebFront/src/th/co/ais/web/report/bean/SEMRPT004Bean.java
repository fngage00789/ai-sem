package th.co.ais.web.report.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.report.AbstractReportBean;

public class SEMRPT004Bean extends AbstractReportBean{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -429857090591247015L;
	private List<SelectItem> companyList;
	private boolean pico;
	private String company;
	private String yearTax;
	
	public SEMRPT004Bean() {
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


	public String getYearTax() {
		return yearTax;
	}


	public void setYearTax(String yearTax) {
		this.yearTax = yearTax;
	}

	public boolean getPico() {
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
