package th.co.ais.web.report.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.report.AbstractReportBean;

public class SEMRRT018Bean extends AbstractReportBean{

 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2012470295880592849L;
	private List<SelectItem> companyList;
	private List<SelectItem> contractStatusList;
	private List<SelectItem> networkStatusList;
	private String company;
	private String multiContractNo;
	private String multiRegion;
	private String multiLocationId;
	private String multiVendor;
	private String contractStatus;
	private String networkStatus;
	private String asOf;
	
	
	public SEMRRT018Bean() {
		super(ServiceConstants.TYPE_XLS);
	}
	
	
	public List<SelectItem> getCompanyList() {
		return companyList;
	}


	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}


	public String getMultiContractNo() {
		return multiContractNo;
	}


	public void setMultiContractNo(String multiContractNo) {
		this.multiContractNo = multiContractNo;
	}


	public String getMultiRegion() {
		return multiRegion;
	}


	public void setMultiRegion(String multiRegion) {
		this.multiRegion = multiRegion;
	}


	public String getMultiLocationId() {
		return multiLocationId;
	}


	public void setMultiLocationId(String multiLocationId) {
		this.multiLocationId = multiLocationId;
	}


	public String getMultiVendor() {
		return multiVendor;
	}


	public void setMultiVendor(String multiVendor) {
		this.multiVendor = multiVendor;
	}


 

	public List<SelectItem> getContractStatusList() {
		return contractStatusList;
	}


	public void setContractStatusList(List<SelectItem> contractStatusList) {
		this.contractStatusList = contractStatusList;
	}


	public List<SelectItem> getNetworkStatusList() {
		return networkStatusList;
	}


	public void setNetworkStatusList(List<SelectItem> networkStatusList) {
		this.networkStatusList = networkStatusList;
	}


	public String getContractStatus() {
		return contractStatus;
	}


	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}


	public String getNetworkStatus() {
		return networkStatus;
	}


	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
	}


	public String getAsOf() {
		return asOf;
	}


	public void setAsOf(String asOf) {
		this.asOf = asOf;
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
	
}
