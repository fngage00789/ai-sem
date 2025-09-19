package th.co.ais.web.report.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.report.AbstractReportBean;;

public class SEMRRT023Bean extends AbstractReportBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6296821860362797846L;
	
	
	private String company;
	private String region;
	private String year;
	private String paymentType;
	private String module;
	private String expenseType;
	
	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> paymentTypeList;
	private List<SelectItem> moduleList;
	private List<SelectItem> expenseTypeList;
	
	public SEMRRT023Bean() {
		super(ServiceConstants.TYPE_XLS);
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

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
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

	public List<SelectItem> getPaymentTypeList() {
		return paymentTypeList;
	}

	public void setPaymentTypeList(List<SelectItem> paymentTypeList) {
		this.paymentTypeList = paymentTypeList;
	}

	public List<SelectItem> getModuleList() {
		return moduleList;
	}

	public void setModuleList(List<SelectItem> moduleList) {
		this.moduleList = moduleList;
	}

	public List<SelectItem> getExpenseTypeList() {
		return expenseTypeList;
	}

	public void setExpenseTypeList(List<SelectItem> expenseTypeList) {
		this.expenseTypeList = expenseTypeList;
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


	
	
	

}
