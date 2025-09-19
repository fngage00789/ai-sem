package th.co.ais.web.report.bean;



import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.report.AbstractReportBean;

public class SEMRSI003Bean extends AbstractReportBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6604217151494921257L;
	private String contractNo;
	private String site;
	private String company;
	private String region;
	private String approveType;
	
	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> approveTypeList;

	public SEMRSI003Bean() {
		super(ServiceConstants.TYPE_XLS);
	}

	

	public String getContractNo() {
		return contractNo;
	}



	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}



	public String getSite() {
		return site;
	}



	public String getApproveType() {
		return approveType;
	}



	public void setApproveType(String approveType) {
		this.approveType = approveType;
	}



	public List<SelectItem> getApproveTypeList() {
		return approveTypeList;
	}



	public void setApproveTypeList(List<SelectItem> approveTypeList) {
		this.approveTypeList = approveTypeList;
	}



	public void setSite(String site) {
		this.site = site;
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


	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

}
