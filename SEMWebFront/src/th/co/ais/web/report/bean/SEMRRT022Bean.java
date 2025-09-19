package th.co.ais.web.report.bean;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.bean.common.PopupMultiVendorBean;
import th.co.ais.web.bean.common.PopupSiteMultiContractBean;
import th.co.ais.web.bean.common.PopupSiteMultiLocationBean;
import th.co.ais.web.bean.common.PopupSiteMultiRegionBean;
import th.co.ais.web.report.AbstractReportBean;

public class SEMRRT022Bean extends AbstractReportBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8800629180536303683L;
	private List<SelectItem> companyList;
	private List<SelectItem> monthList;	
	private List<SelectItem> diffList;
	private List<SelectItem> expenseTypeList;
	private String company;
	private String previousMonthFrom;
	private String previousMonthTo;
	private String currentMonthFrom;
	private String currentMonthTo;
	private String expenseType;
	private String contractNo;
	private String percentDiffType;
	private double percentDiffAmt;
	
	public SEMRRT022Bean() {
		super(ServiceConstants.TYPE_XLS);
	}
	
	public List<SelectItem> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}

	public List<SelectItem> getMonthList() {
		return monthList;
	}

	public void setMonthList(List<SelectItem> monthList) {
		this.monthList = monthList;
	}

	public List<SelectItem> getDiffList() {
		return diffList;
	}

	public void setDiffList(List<SelectItem> diffList) {
		this.diffList = diffList;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPreviousMonthFrom() {
		return previousMonthFrom;
	}

	public void setPreviousMonthFrom(String previousMonthFrom) {
		this.previousMonthFrom = previousMonthFrom;
	}

	public String getPreviousMonthTo() {
		return previousMonthTo;
	}

	public void setPreviousMonthTo(String previousMonthTo) {
		this.previousMonthTo = previousMonthTo;
	}

	public String getCurrentMonthFrom() {
		return currentMonthFrom;
	}

	public void setCurrentMonthFrom(String currentMonthFrom) {
		this.currentMonthFrom = currentMonthFrom;
	}

	public String getCurrentMonthTo() {
		return currentMonthTo;
	}

	public void setCurrentMonthTo(String currentMonthTo) {
		this.currentMonthTo = currentMonthTo;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getPercentDiffType() {
		return percentDiffType;
	}

	public void setPercentDiffType(String percentDiffType) {
		this.percentDiffType = percentDiffType;
	}

	public double getPercentDiffAmt() {
		return percentDiffAmt;
	}

	public void setPercentDiffAmt(double percentDiffAmt) {
		this.percentDiffAmt = percentDiffAmt;
	}

	public List<SelectItem> getExpenseTypeList() {
		return expenseTypeList;
	}

	public void setExpenseTypeList(List<SelectItem> expenseTypeList) {
		this.expenseTypeList = expenseTypeList;
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
