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

public class SEMRRT021Bean extends AbstractReportBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8800629180536303683L;
	private List<SelectItem> companyList;
	private List<SelectItem> contractStatusList;
	private String company;
	private String username;
	private String monthYear;
	private String region;
	private String contractNo;
	private String contractStatus;
	private boolean checkDiff1 = false;
	private boolean checkDiff2 = false;
	private String diff1;
	private String diff2;
	
	public SEMRRT021Bean() {
		super(ServiceConstants.TYPE_XLS);
	}
	

	public List<SelectItem> getCompanyList() {
		return companyList;
	}


	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}

	public List<SelectItem> getContractStatusList() {
		return contractStatusList;
	}


	public void setContractStatusList(List<SelectItem> contractStatusList) {
		this.contractStatusList = contractStatusList;
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


	public String getContractNo() {
		return contractNo;
	}


	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}


	public boolean isCheckDiff1() {
		return checkDiff1;
	}


	public void setCheckDiff1(boolean checkDiff1) {
		this.checkDiff1 = checkDiff1;
	}


	public boolean isCheckDiff2() {
		return checkDiff2;
	}


	public void setCheckDiff2(boolean checkDiff2) {
		this.checkDiff2 = checkDiff2;
	}


	public String getDiff1() {
		return diff1;
	}


	public void setDiff1(String diff1) {
		this.diff1 = diff1;
	}


	public String getDiff2() {
		return diff2;
	}


	public void setDiff2(String diff2) {
		this.diff2 = diff2;
	}
	
	public String getContractStatus() {
		return contractStatus;
	}


	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	public String getMonthYear() {
		return monthYear;
	}


	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}


	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getUsername() {
		return username;
	}
	
	
}
