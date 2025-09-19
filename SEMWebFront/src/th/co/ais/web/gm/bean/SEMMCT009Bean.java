package th.co.ais.web.gm.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.gm.BankMasterSP;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMCT009Bean extends AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1426291697901042288L;
	

	// --- LOVs ---
	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> siteStatusList;
	private List<SelectItem> electricUseTypeList;
	private List<SelectItem> electricUseTypeList2;
	private List<SelectItem> processStatusNameList;
	private List<SelectItem> depositTypeList;
	private List<SelectItem> provinceList;
	private List<SelectItem> amphurList;
	private List<SelectItem> bgStatusList;
	private List<SelectItem> refDocTypeList;
	private List<SelectItem> paymentMethodList;
	private List<SelectItem> paymentTypeList;
	private List<SelectItem> monthList;
	private List<SelectItem> bankCodeList;
	private List<SelectItem> bankNameList;
	private List<SelectItem> bankSelectionSearchList;
	
	//for search criteria
	private BankMasterSP criteriaBankMasterSP;
	private BankMasterSP popupCriteriaBankMasterSP;
	private BankMasterSP itemBankMasterSP;
	private BankMasterSP bankSearchSelected;
	
	//data table
	public List<WrapperBeanObject<BankMasterSP>> bankMasterList;
	public List<BankMasterSP> bankMasterSlctList;

	private String rowId;
	
	private boolean chkSelAll = false;
	
	private boolean chkForEdit = false;
	private boolean disbledDialogField = true;
	
	private String doMode;
	
	
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
	public List<SelectItem> getSiteStatusList() {
		return siteStatusList;
	}
	public void setSiteStatusList(List<SelectItem> siteStatusList) {
		this.siteStatusList = siteStatusList;
	}
	public List<SelectItem> getElectricUseTypeList() {
		return electricUseTypeList;
	}
	public void setElectricUseTypeList(List<SelectItem> electricUseTypeList) {
		this.electricUseTypeList = electricUseTypeList;
	}
	public List<SelectItem> getElectricUseTypeList2() {
		return electricUseTypeList2;
	}
	public void setElectricUseTypeList2(List<SelectItem> electricUseTypeList2) {
		this.electricUseTypeList2 = electricUseTypeList2;
	}
	public List<SelectItem> getProcessStatusNameList() {
		return processStatusNameList;
	}
	public void setProcessStatusNameList(List<SelectItem> processStatusNameList) {
		this.processStatusNameList = processStatusNameList;
	}
	public List<SelectItem> getDepositTypeList() {
		return depositTypeList;
	}
	public void setDepositTypeList(List<SelectItem> depositTypeList) {
		this.depositTypeList = depositTypeList;
	}
	public List<SelectItem> getProvinceList() {
		return provinceList;
	}
	public void setProvinceList(List<SelectItem> provinceList) {
		this.provinceList = provinceList;
	}
	public List<SelectItem> getAmphurList() {
		return amphurList;
	}
	public void setAmphurList(List<SelectItem> amphurList) {
		this.amphurList = amphurList;
	}
	public List<SelectItem> getBgStatusList() {
		return bgStatusList;
	}
	public void setBgStatusList(List<SelectItem> bgStatusList) {
		this.bgStatusList = bgStatusList;
	}
	public List<SelectItem> getRefDocTypeList() {
		return refDocTypeList;
	}
	public void setRefDocTypeList(List<SelectItem> refDocTypeList) {
		this.refDocTypeList = refDocTypeList;
	}
	public List<SelectItem> getPaymentMethodList() {
		return paymentMethodList;
	}
	public void setPaymentMethodList(List<SelectItem> paymentMethodList) {
		this.paymentMethodList = paymentMethodList;
	}
	public List<SelectItem> getPaymentTypeList() {
		return paymentTypeList;
	}
	public void setPaymentTypeList(List<SelectItem> paymentTypeList) {
		this.paymentTypeList = paymentTypeList;
	}
	public List<SelectItem> getMonthList() {
		return monthList;
	}
	public void setMonthList(List<SelectItem> monthList) {
		this.monthList = monthList;
	}
	public BankMasterSP getCriteriaBankMasterSP() {
		if(criteriaBankMasterSP == null) criteriaBankMasterSP = new BankMasterSP();
		return criteriaBankMasterSP;
	}
	public void setCriteriaBankMasterSP(BankMasterSP criteriaBankMasterSP) {
		this.criteriaBankMasterSP = criteriaBankMasterSP;
	}
	public BankMasterSP getPopupCriteriaBankMasterSP() {
		if(popupCriteriaBankMasterSP == null) popupCriteriaBankMasterSP = new BankMasterSP();
		return popupCriteriaBankMasterSP;
	}
	public void setPopupCriteriaBankMasterSP(BankMasterSP popupCriteriaBankMasterSP) {
		this.popupCriteriaBankMasterSP = popupCriteriaBankMasterSP;
	}
	public List<WrapperBeanObject<BankMasterSP>> getBankMasterList() {
		return bankMasterList;
	}
	public void setBankMasterList(
			List<WrapperBeanObject<BankMasterSP>> bankMasterList) {
		this.bankMasterList = bankMasterList;
	}
	public List<BankMasterSP> getBankMasterSlctList() {
		return bankMasterSlctList;
	}
	public void setBankMasterSlctList(List<BankMasterSP> bankMasterSlctList) {
		this.bankMasterSlctList = bankMasterSlctList;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public boolean isChkSelAll() {
		return chkSelAll;
	}
	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}
	public BankMasterSP getItemBankMasterSP() {
		if(itemBankMasterSP == null) itemBankMasterSP = new BankMasterSP();
		return itemBankMasterSP;
	}
	public void setItemBankMasterSP(BankMasterSP itemBankMasterSP) {
		this.itemBankMasterSP = itemBankMasterSP;
	}
	public boolean isChkForEdit() {
		return chkForEdit;
	}
	public void setChkForEdit(boolean chkForEdit) {
		this.chkForEdit = chkForEdit;
	}
	public boolean isDisbledDialogField() {
		return disbledDialogField;
	}
	public void setDisbledDialogField(boolean disbledDialogField) {
		this.disbledDialogField = disbledDialogField;
	}
	public String getDoMode() {
		return doMode;
	}
	public void setDoMode(String doMode) {
		this.doMode = doMode;
	}
	public List<SelectItem> getBankCodeList() {
		return bankCodeList;
	}
	public void setBankCodeList(List<SelectItem> bankCodeList) {
		this.bankCodeList = bankCodeList;
	}
	public List<SelectItem> getBankNameList() {
		return bankNameList;
	}
	public void setBankNameList(List<SelectItem> bankNameList) {
		this.bankNameList = bankNameList;
	}
	public List<SelectItem> getBankSelectionSearchList() {
		return bankSelectionSearchList;
	}
	public void setBankSelectionSearchList(List<SelectItem> bankSelectionSearchList) {
		this.bankSelectionSearchList = bankSelectionSearchList;
	}
	public BankMasterSP getBankSearchSelected() {
		return bankSearchSelected;
	}
	public void setBankSearchSelected(BankMasterSP bankSearchSelected) {
		this.bankSearchSelected = bankSearchSelected;
	}


}
