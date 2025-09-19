package th.co.ais.web.gm.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import th.co.ais.domain.gm.GLAccount;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMCT005Bean extends AbstractBean{

	private static final String DEFAULT_STATUS_SEARCH = "ALL";
	private boolean editMode = false;
	private boolean viewMode = false;
	private boolean disableUser =  true;
	
	// obj for search
	private GLAccount glAccSearch;
	
	// obj for create
	private GLAccount glAccount;
	
	//Render Message Data not found
	private boolean renderedMsgDataNotFound = false;
	
	//Render message form search
	private boolean renderedMsgFormSearch = false;
	
	private boolean renderedMsgFormCreate = false;
	
	private String[][] statusItems = {{"ALL","ทั้งหมด"},{"Y","ปกติ"},{"N","ยกเลิก"}};
	private String[][] statusItems2 = {{"ALL","ทั้งหมด"},{"Prepaid","Prepaid"},{"Postpaid","Postpaid"}};
	
	private List<SelectItem> companyList;
	private List<SelectItem> placeTypeList;
	private List<SelectItem> statusList;	
	private List<SelectItem> statusListForCreate;
	private List<SelectItem> statusListForGL;
	private List<SelectItem> expenseList;
	
	//update by new 26/11/2014
	private List<SelectItem> glTypeList;
	
	private List<WrapperBeanObject<GLAccount>> glAccList;

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	public boolean isViewMode() {
		return viewMode;
	}

	public void setViewMode(boolean viewMode) {
		this.viewMode = viewMode;
	}

	public boolean isDisableUser() {
		return disableUser;
	}

	public void setDisableUser(boolean disableUser) {
		this.disableUser = disableUser;
	}

	public GLAccount getGlAccSearch() {
		return glAccSearch;
	}

	public void setGlAccSearch(GLAccount glAccSearch) {
		this.glAccSearch = glAccSearch;
		setDefaultDataForSearch();
	}

	public GLAccount getGlAccount() {
		return glAccount;
	}

	public void setGlAccount(GLAccount glAccount) {
		this.glAccount = glAccount;
		setDefaultDataForCreate();
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

	public boolean isRenderedMsgFormCreate() {
		return renderedMsgFormCreate;
	}

	public void setRenderedMsgFormCreate(boolean renderedMsgFormCreate) {
		this.renderedMsgFormCreate = renderedMsgFormCreate;
	}

	public String[][] getStatusItems() {
		return statusItems;
	}

	public void setStatusItems(String[][] statusItems) {
		this.statusItems = statusItems;
	}

	public List<SelectItem> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}

	public List<SelectItem> getPlaceTypeList() {
		return placeTypeList;
	}

	public void setPlaceTypeList(List<SelectItem> placeTypeList) {
		this.placeTypeList = placeTypeList;
	}

	public List<SelectItem> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<SelectItem> statusList) {
		this.statusList = statusList;
	}

	public List<SelectItem> getStatusListForCreate() {
		return statusListForCreate;
	}

	public void setStatusListForCreate(List<SelectItem> statusListForCreate) {
		this.statusListForCreate = statusListForCreate;
	}

	public List<SelectItem> getExpenseList() {
		return expenseList;
	}

	public void setExpenseList(List<SelectItem> expenseList) {
		this.expenseList = expenseList;
	}

	public List<WrapperBeanObject<GLAccount>> getGlAccList() {
		return glAccList;
	}

	public void setGlAccList(List<WrapperBeanObject<GLAccount>> glAccList) {
		this.glAccList = glAccList;
	}

	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	
	private void setDefaultDataForSearch(){
		statusList = new ArrayList<SelectItem>();
		for(byte i =0;i< statusItems.length;i++){
			SelectItem selItem = new SelectItem();
			selItem.setLabel(statusItems[i][1]);
			selItem.setValue(statusItems[i][0]);
			statusList.add(selItem);
		}
		if(glAccSearch != null){
			glAccSearch.setRecordStatus(DEFAULT_STATUS_SEARCH);
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
		if(glAccount != null){
			glAccount.setRecordStatus("Y");
		}
	}
	
	private void setDefaultDataForGL(){
		statusListForGL = new ArrayList<SelectItem>();
		for(byte i =1;i< statusItems2.length;i++){
			SelectItem selItem = new SelectItem();
			selItem.setLabel(statusItems2[i][1]);
			selItem.setValue(statusItems2[i][0]);
			statusListForGL.add(selItem);
		}
		if(glAccount != null){
			//glAccount.setRecordStatus("Y");
		}
	}
	
	public void resetData(){
		editMode = false;
		viewMode = false;
		disableUser =  true;
		glAccount = null;
		glAccSearch = null;
		glAccList = null;
		renderedMsgDataNotFound = false;
		renderedMsgFormSearch = false;
	}

	public List<SelectItem> getGlTypeList() {
		return glTypeList;
	}

	public void setGlTypeList(List<SelectItem> glTypeList) {
		this.glTypeList = glTypeList;
	}

	public List<SelectItem> getStatusListForGL() {
		return statusListForGL;
	}

	public void setStatusListForGL(List<SelectItem> statusListForGL) {
		this.statusListForGL = statusListForGL;
		setDefaultDataForGL();
	}
	
	

}
