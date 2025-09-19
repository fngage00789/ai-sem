package th.co.ais.web.ir.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.gm.LocationMaster;
import th.co.ais.domain.ir.Insured;
import th.co.ais.domain.ir.InsuredSP;

public class SEMIR005Bean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -136035976102306220L;
	
	private List<SelectItem> companyList;
	private List<SelectItem> networkTypeList;
	
	private List<LocationMaster> locations;
	private LocationMaster location;
	private boolean renderBtnLocationAdd = true;
	private LocationMaster locationSelected;
	private String selectedRadio = "";
	
	private String rowId;
	private String popUpHeader;
	private String tempCompanyName;
	
	private List<InsuredSP> insuredList;
	private InsuredSP insuredCriteria;
	private Insured insured;
		
	private int rowPerPage = 10;
	private int maxPage = 10;
	private int maxSearchResult = 100;
	private String btnCheck;
	
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
	public List<InsuredSP> getInsuredList() {
		return insuredList;
	}
	public void setInsuredList(List<InsuredSP> insuredList) {
		this.insuredList = insuredList;
	}
	public InsuredSP getInsuredCriteria() {
		return insuredCriteria;
	}
	public void setInsuredCriteria(InsuredSP insuredCriteria) {
		this.insuredCriteria = insuredCriteria;
	}
	public Insured getInsured() {
		return insured;
	}
	public void setInsured(Insured insured) {
		this.insured = insured;
	}
	public String getPopUpHeader() {
		return popUpHeader;
	}
	public void setPopUpHeader(String popUpHeader) {
		this.popUpHeader = popUpHeader;
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
			this.location.setLocationCode("");
			this.location.setLocationName("");
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
	public LocationMaster getLocationSelected() {
		if (this.locationSelected == null)
			this.locationSelected = new LocationMaster();
		return locationSelected;
	}
	public void setLocationSelected(LocationMaster locationSelected) {
		this.locationSelected = locationSelected;
	}
	public String getSelectedRadio() {
		return selectedRadio;
	}
	public void setSelectedRadio(String selectedRadio) {
		this.selectedRadio = selectedRadio;
	}
	public void setBtnCheck(String btnCheck) {
		this.btnCheck = btnCheck;
	}
	public String getBtnCheck() {
		return btnCheck;
	}
	public void setTempCompanyName(String tempCompanyName) {
		this.tempCompanyName = tempCompanyName;
	}
	public String getTempCompanyName() {
		return tempCompanyName;
	}
	
}
