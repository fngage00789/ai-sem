package th.co.ais.web.ir.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.gm.LocationMaster;
import th.co.ais.domain.ir.AcquisitionCostDetailSP;

public class SEMIR002Bean implements Serializable {
	
	private static final long serialVersionUID = 2359355352402848631L;

	
	private List<LocationMaster> locations;
	private LocationMaster location;
	private boolean renderBtnLocationAdd = true;
	private LocationMaster locationSelected;
	private String selectedRadio = "";
	
	private List<SelectItem> companyList;
	private List<SelectItem> networkTypeList;
	private List<SelectItem> transferTypeList;
	private List<AcquisitionCostDetailSP> acqCostDetailList;
	private AcquisitionCostDetailSP acqCostDetail;

	private int rowPerPage = 10;
	private int maxPage = 10;
	private int maxSearchResult = 100;
	
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
	
	public List<AcquisitionCostDetailSP> getAcqCostDetailList() {
		return acqCostDetailList;
	}
	public void setAcqCostDetailList(List<AcquisitionCostDetailSP> acqCostDetailList) {
		this.acqCostDetailList = acqCostDetailList;
	}
	public AcquisitionCostDetailSP getAcqCostDetail() {
		return acqCostDetail;
	}
	public void setAcqCostDetail(AcquisitionCostDetailSP acqCostDetail) {
		this.acqCostDetail = acqCostDetail;
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
	public String getSelectedRadio() {
		return selectedRadio;
	}
	public void setSelectedRadio(String selectedRadio) {
		this.selectedRadio = selectedRadio;
	}

	public List<LocationMaster> getLocations() {
		if (this.locations == null)
			this.locations = new ArrayList<LocationMaster>();
		return locations;
	}
	public void setLocations(List<LocationMaster> locations) {
		this.locations = locations;
	}
	public LocationMaster getLocation() {
		if (this.location == null) {
			this.location = new LocationMaster();
		}
		return location;
	}
	public void setLocation(LocationMaster location) {
		this.location = location;
	}
	public boolean isRenderBtnLocationAdd() {
		return renderBtnLocationAdd;
	}
	public void setRenderBtnLocationAdd(boolean renderBtnLocationAdd) {
		this.renderBtnLocationAdd = renderBtnLocationAdd;
	}
	public LocationMaster getlocationSelected() {
		if (this.locationSelected == null)
			this.locationSelected = new LocationMaster();
		return locationSelected;
	}
	public void setLocationSelected(LocationMaster locationSelected) {
		this.locationSelected = locationSelected;
	}
	
}
