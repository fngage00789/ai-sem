package th.co.ais.web.ir.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.ir.AcquisitionCostSP;

public class SEMIR001Bean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2359355352402848631L;
	
	private List<SelectItem> companyList;
	private List<SelectItem> networkTypeList;
	private List<SelectItem> transferTypeList;
	private String rowId;
	private String month;
	private String year;
	
	private List<AcquisitionCostSP> acquisitionCostList;
	private AcquisitionCostSP acquisitionCost;
		
	private int rowPerPage = 10;
	private int maxPage = 10;
	private int maxSearchResult = 100;
	
	public void setDateToCriteria() {
		if (!"".equals(month) && !"".equals(year)) {
			acquisitionCost.setAsOfMonth("");
		}
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public int getRowPerPage() {
		return rowPerPage;
	}
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getMaxSearchResult() {
		return maxSearchResult;
	}
	public void setMaxSearchResult(int maxSearchResult) {
		this.maxSearchResult = maxSearchResult;
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
	public List<SelectItem> getTransferTypeList() {
		return transferTypeList;
	}
	public void setTransferTypeList(List<SelectItem> transferTypeList) {
		this.transferTypeList = transferTypeList;
	}
	public List<AcquisitionCostSP> getAcquisitionCostList() {
		return acquisitionCostList;
	}
	public void setAcquisitionCostList(List<AcquisitionCostSP> acqisitionCostList) {
		this.acquisitionCostList = acqisitionCostList;
	}
	public AcquisitionCostSP getAcquisitionCost() {
		return acquisitionCost;
	}
	public void setAcquisitionCost(AcquisitionCostSP acqisitionCost) {
		this.acquisitionCost = acqisitionCost;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
}
