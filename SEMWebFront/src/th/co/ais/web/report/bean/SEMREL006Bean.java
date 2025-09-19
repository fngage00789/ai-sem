package th.co.ais.web.report.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.report.AbstractReportBean;

public class SEMREL006Bean extends AbstractReportBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8621663925471015690L;
	
	private List<SelectItem> companyList;
	private List<SelectItem> electricUseTypeList;
	private List<SelectItem> expenseTypeList;
	private String company;
	private String electricUseType;
	private String expenseType;
	private String reportEngine;
	
	public SEMREL006Bean() {
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


	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}


	public List<SelectItem> getElectricUseTypeList() {
		return electricUseTypeList;
	}


	public void setElectricUseTypeList(List<SelectItem> electricUseTypeList) {
		this.electricUseTypeList = electricUseTypeList;
	}


	public String getElectricUseType() {
		return electricUseType;
	}


	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}


	public String getReportEngine() {
		return reportEngine;
	}


	public void setReportEngine(String reportEngine) {
		this.reportEngine = reportEngine;
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
	
}
