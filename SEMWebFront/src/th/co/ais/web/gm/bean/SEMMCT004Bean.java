package th.co.ais.web.gm.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import org.apache.commons.collections.map.HashedMap;
import th.co.ais.domain.gm.Company;
import th.co.ais.domain.gm.CostCenter;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMCT004Bean extends AbstractBean{
	
	private static final String DEFAULT_STATUS_SEARCH = "ALL";
	
	private boolean disableEdit;
	private boolean disableView;
	private boolean disableDelete;
	private boolean editMode = false;
	private boolean viewMode = false;
	private boolean disableUser =  true;
	
	// obj for search
	private CostCenter costCenterSearch;
	
	// obj for create
	private CostCenter costCenter;
	
	//Render Message Data not found
	private boolean renderedMsgDataNotFound = false;
	
	//Render message form search
	private boolean renderedMsgFormSearch = false;
	
	private boolean renderedMsgFormCreate = false;
	
	private String[][] statusItems = {{"ALL","ทั้งหมด"},{"Y","ปกติ"},{"N","ยกเลิก"}};
	
	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> statusList;	
	private List<SelectItem> statusListForCreate;
	
	private List<WrapperBeanObject<CostCenter>> costCenterList;

	
	public SEMMCT004Bean(){
		
	}
	
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

	public List<SelectItem> getRegionList() {
		return regionList;
	}

	public void setRegionList(List<SelectItem> regionList) {
		this.regionList = regionList;
	}

	public List<SelectItem> getStatusList() {
		return statusList;
	}
	public void setStatusList(List<SelectItem> statusList) {
		this.statusList = statusList;
	}
	
	public boolean isRenderedMsgDataNotFound() {
		return renderedMsgDataNotFound;
	}

	public void setRenderedMsgDataNotFound(boolean renderedMsgDataNotFound) {
		this.renderedMsgDataNotFound = renderedMsgDataNotFound;
	}

	public boolean isRenderedMsgFormSearch() {
		return renderedMsgFormSearch;
	}

	public void setRenderedMsgFormSearch(boolean renderedMsgFormSearch) {
		this.renderedMsgFormSearch = renderedMsgFormSearch;
	}

	public boolean isDisableEdit() {
		return disableEdit;
	}

	public void setDisableEdit(boolean disableEdit) {
		this.disableEdit = disableEdit;
	}

	public boolean isDisableView() {
		return disableView;
	}

	public void setDisableView(boolean disableView) {
		this.disableView = disableView;
	}

	public boolean isDisableDelete() {
		return disableDelete;
	}

	public void setDisableDelete(boolean disableDelete) {
		this.disableDelete = disableDelete;
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	public CostCenter getCostCenterSearch() {
		return costCenterSearch;
	}

	public void setCostCenterSearch(CostCenter costCenterSearch) {
		this.costCenterSearch = costCenterSearch;
		setDefaultDataForSearch();
	}

	public CostCenter getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(CostCenter costCenter) {
		this.costCenter = costCenter;
		setDefaultDataForCreate();
	}

	public List<WrapperBeanObject<CostCenter>> getCostCenterList() {
		return costCenterList;
	}

	public void setCostCenterList(List<WrapperBeanObject<CostCenter>> costCenterList) {
		this.costCenterList = costCenterList;
	}

	public boolean isViewMode() {
		return viewMode;
	}

	public void setViewMode(boolean viewMode) {
		this.viewMode = viewMode;
	}
	
	private void setDefaultDataForSearch(){
		statusList = new ArrayList<SelectItem>();
		for(byte i =0;i< statusItems.length;i++){
			SelectItem selItem = new SelectItem();
			selItem.setLabel(statusItems[i][1]);
			selItem.setValue(statusItems[i][0]);
			statusList.add(selItem);
		}
		if(costCenterSearch != null){
			costCenterSearch.setRecordStatus(DEFAULT_STATUS_SEARCH);
		}
	}

	private void setDefaultDataForCreate(){
		statusListForCreate = new ArrayList<SelectItem>();
		for(byte i =1;i< statusItems.length;i++){
			SelectItem selItem = new SelectItem();
			selItem.setLabel(statusItems[i][1]);
			selItem.setValue(statusItems[i][0]);
			statusListForCreate.add(selItem);
		}
		if(costCenter != null){
			costCenter.setRecordStatus("Y");
		}
	}
	public boolean isDisableUser() {
		return disableUser;
	}

	public void setDisableUser(boolean disableUser) {
		this.disableUser = disableUser;
	}
	

	public void resetData(){
		editMode = false;
		viewMode = false;
		disableUser =  true;
		costCenterSearch = null;
		costCenter = null;
		costCenterList = null;
		renderedMsgDataNotFound = false;
		renderedMsgFormSearch = false;
	}

	public List<SelectItem> getStatusListForCreate() {
		return statusListForCreate;
	}

	public void setStatusListForCreate(List<SelectItem> statusListForCreate) {
		this.statusListForCreate = statusListForCreate;
	}

	public boolean isRenderedMsgFormCreate() {
		return renderedMsgFormCreate;
	}

	public void setRenderedMsgFormCreate(boolean renderedMsgFormCreate) {
		this.renderedMsgFormCreate = renderedMsgFormCreate;
	}
	
}