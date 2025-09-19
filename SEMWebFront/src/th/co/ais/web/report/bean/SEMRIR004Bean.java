package th.co.ais.web.report.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.report.AbstractReportBean;

public class SEMRIR004Bean extends AbstractReportBean {
 
	
	
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 7430352801824986659L;
	private String company;
	private String insuranceYear;
	private String networkType;
	private String insuranceType;
	private String transferType;
	
	private List<SelectItem> companyList;
	private List<SelectItem> networkTypeList;
	private List<SelectItem> insuranceTypeList;
	private List<SelectItem> transferTypeList;

	public SEMRIR004Bean(){
	super(ServiceConstants.TYPE_XLS);
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getInsuranceYear() {
		return insuranceYear;
	}

	public void setInsuranceYear(String insuranceYear) {
		this.insuranceYear = insuranceYear;
	}

	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public List<SelectItem> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}

	public List<SelectItem> getNetworkTypeList() {
		return networkTypeList;
	}

	public void setNetworkTypeList(List<SelectItem> networkTypeList) {
		this.networkTypeList = networkTypeList;
	}

	public List<SelectItem> getInsuranceTypeList() {
		return insuranceTypeList;
	}

	public void setInsuranceTypeList(List<SelectItem> insuranceTypeList) {
		this.insuranceTypeList = insuranceTypeList;
	}

	public String getTransferType() {
		return transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	public List<SelectItem> getTransferTypeList() {
		return transferTypeList;
	}

	public void setTransferTypeList(List<SelectItem> transferTypeList) {
		this.transferTypeList = transferTypeList;
	}

}
