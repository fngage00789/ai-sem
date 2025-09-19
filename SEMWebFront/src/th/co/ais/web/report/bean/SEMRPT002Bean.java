package th.co.ais.web.report.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.report.AbstractReportBean;

public class SEMRPT002Bean extends AbstractReportBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 465467581653139777L;
	/**
	 * 
	 */
	
	private List<SelectItem> companyList;
	private List<SelectItem> expenseTypeList;
	private boolean pico;
	private String company;
	private String yearTax;
	private String expenseType;
	
	public SEMRPT002Bean() {
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


	


	public List<SelectItem> getExpenseTypeList() {
		return expenseTypeList;
	}


	public void setExpenseTypeList(List<SelectItem> expenseTypeList) {
		this.expenseTypeList = expenseTypeList;
	}


	public String getExpenseType() {
		return expenseType;
	}


	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
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
