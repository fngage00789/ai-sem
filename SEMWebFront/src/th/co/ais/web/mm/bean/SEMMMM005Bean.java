package th.co.ais.web.mm.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.web.bean.AbstractBean;

public class SEMMMM005Bean extends AbstractBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7892937503435556835L;
	
	private List<SelectItem> companyList;
	private List<SelectItem> expenseTypeList;
	private List<SelectItem> bankList;
	private List<SelectItem> statusList;
	
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	
	public List<SelectItem> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}
	
	public List<SelectItem> getExpenseTypeList() {
		return expenseTypeList;
	}
	public void setExpenseTypeList(List<SelectItem> expenseTypeList) {
		this.expenseTypeList = expenseTypeList;
	}
	
	public List<SelectItem> getBankList() {
		return bankList;
	}
	public void setBankList(List<SelectItem> bankList) {
		this.bankList = bankList;
	}
	
	public List<SelectItem> getStatusList() {
		return statusList;
	}
	public void setStatusList(List<SelectItem> statusList) {
		this.statusList = statusList;
	}
	
}
