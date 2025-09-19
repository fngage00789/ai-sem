package th.co.ais.web.report.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.report.AbstractReportBean;

public class SEMRPT003Bean extends AbstractReportBean{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1476890898229949284L;
	private List<SelectItem> companyList;
	private boolean pico;
	private String company;
	private String yearTax;
	
	public SEMRPT003Bean(){
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

	public boolean isPico() {
		return pico;
	}
	public void setPico(boolean pico) {
		this.pico = pico;
	}
	public void setYearTax(String yearTax) {
		this.yearTax = yearTax;
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
