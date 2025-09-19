package th.co.ais.web.co.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.co.ContractStatus;
import th.co.ais.domain.co.Mco004SrchStatusSP;
import th.co.ais.domain.co.Mco006SrchContractStatusSP;
import th.co.ais.domain.si.Contract;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMCO006Bean extends AbstractBean {

	private static final long serialVersionUID = 7164670455509692855L;
	
	private List<SelectItem> companyList;
	private List<SelectItem> reqTypeList;
	private List<SelectItem> contractStatusList;
	private List<SelectItem> regionList;
	private List<SelectItem> contractStatList;
	//Adding by mr.John from (mr.Surasit).
	private List<SelectItem> borrowOfficerList;
	
	private List<WrapperBeanObject<Mco006SrchContractStatusSP>> contractStatusSPList;
	private Mco006SrchContractStatusSP criteria;
	private boolean disabledBtnAdd;
	private boolean disabledBtnExport;
	private boolean disabledBtnExportDuty;
	private List<String> contractIds;
	private List<WrapperBeanObject<Mco006SrchContractStatusSP>> selectedList;
	private ContractStatus contractStatus;
	private boolean disabledBtnAddContractStatusHistory;
	private boolean disabledBtnUpdateContractStatusHistory;
	private String contractId;
	private List<Mco004SrchStatusSP> contractStatusHistoryList;
	private boolean chkSelAll = false;
	private boolean renderedMsgFormSearchPopup;
	private Contract contract;
	private String rowsIdConcat;
	private String company;
	private boolean renderedUpdateHistory;
	private boolean renderedDeleteHistory;
	private boolean renderedAddHistory;
	private boolean disableSelectAll = true;
	private String selectedStatus;
	private boolean chkTerminateFlag;
	private boolean renderedTerminateFlag;
	
	
	
	public boolean isRenderedTerminateFlag() {
		return renderedTerminateFlag;
	}
	public void setRenderedTerminateFlag(boolean renderedTerminateFlag) {
		this.renderedTerminateFlag = renderedTerminateFlag;
	}
	public boolean isChkTerminateFlag() {
		return chkTerminateFlag;
	}
	public void setChkTerminateFlag(boolean chkTerminateFlag) {
		this.chkTerminateFlag = chkTerminateFlag;
	}
	public boolean isRenderedUpdateHistory() {
		return renderedUpdateHistory;
	}
	public void setRenderedUpdateHistory(boolean renderedUpdateHistory) {
		this.renderedUpdateHistory = renderedUpdateHistory;
	}
	public boolean isRenderedDeleteHistory() {
		return renderedDeleteHistory;
	}
	public void setRenderedDeleteHistory(boolean renderedDeleteHistory) {
		this.renderedDeleteHistory = renderedDeleteHistory;
	}
	public boolean isRenderedAddHistory() {
		return renderedAddHistory;
	}
	public void setRenderedAddHistory(boolean renderedAddHistory) {
		this.renderedAddHistory = renderedAddHistory;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getRowsIdConcat() {
		return rowsIdConcat;
	}
	public void setRowsIdConcat(String rowsIdConcat) {
		this.rowsIdConcat = rowsIdConcat;
	}
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	public boolean isRenderedMsgFormSearchPopup() {
		return renderedMsgFormSearchPopup;
	}
	public void setRenderedMsgFormSearchPopup(boolean renderedMsgFormSearchPopup) {
		this.renderedMsgFormSearchPopup = renderedMsgFormSearchPopup;
	}
	public boolean isChkSelAll() {
		return chkSelAll;
	}
	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}
	public List<Mco004SrchStatusSP> getContractStatusHistoryList() {
		return contractStatusHistoryList;
	}
	public void setContractStatusHistoryList(
			List<Mco004SrchStatusSP> contractStatusHistoryList) {
		this.contractStatusHistoryList = contractStatusHistoryList;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public boolean isDisabledBtnAddContractStatusHistory() {
		return disabledBtnAddContractStatusHistory;
	}
	public void setDisabledBtnAddContractStatusHistory(
			boolean disabledBtnAddContractStatusHistory) {
		this.disabledBtnAddContractStatusHistory = disabledBtnAddContractStatusHistory;
	}
	public boolean isDisabledBtnUpdateContractStatusHistory() {
		return disabledBtnUpdateContractStatusHistory;
	}
	public void setDisabledBtnUpdateContractStatusHistory(
			boolean disabledBtnUpdateContractStatusHistory) {
		this.disabledBtnUpdateContractStatusHistory = disabledBtnUpdateContractStatusHistory;
	}
	public ContractStatus getContractStatus() {
		return contractStatus;
	}
	public void setContractStatus(ContractStatus contractStatus) {
		this.contractStatus = contractStatus;
	}
	public boolean isDisabledBtnExport() {
		return disabledBtnExport;
	}
	public void setDisabledBtnExport(boolean disabledBtnExport) {
		this.disabledBtnExport = disabledBtnExport;
	}
	public boolean isDisabledBtnExportDuty() {
		return disabledBtnExportDuty;
	}
	public void setDisabledBtnExportDuty(boolean disabledBtnExportDuty) {
		this.disabledBtnExportDuty = disabledBtnExportDuty;
	}
	public List<String> getContractIds() {
		return contractIds;
	}
	public void setContractIds(List<String> contractIds) {
		this.contractIds = contractIds;
	}
	public List<SelectItem> getContractStatusList() {
		return contractStatusList;
	}
	public void setContractStatusList(List<SelectItem> contractStatusList) {
		this.contractStatusList = contractStatusList;
	}
	public Mco006SrchContractStatusSP getCriteria() {
		return criteria;
	}
	public void setCriteria(Mco006SrchContractStatusSP criteria) {
		this.criteria = criteria;
	}
	public List<SelectItem> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}
	public List<SelectItem> getReqTypeList() {
		return reqTypeList;
	}
	public void setReqTypeList(List<SelectItem> reqTypeList) {
		this.reqTypeList = reqTypeList;
	}
	
	public boolean isDisabledBtnAdd() {
		return disabledBtnAdd;
	}
	public void setDisabledBtnAdd(boolean disabledBtnAdd) {
		this.disabledBtnAdd = disabledBtnAdd;
	}
	
	public List<WrapperBeanObject<Mco006SrchContractStatusSP>> getContractStatusSPList() {
		return contractStatusSPList;
	}
	public void setContractStatusSPList(
			List<WrapperBeanObject<Mco006SrchContractStatusSP>> contractStatusSPList) {
		this.contractStatusSPList = contractStatusSPList;
	}
	public List<WrapperBeanObject<Mco006SrchContractStatusSP>> getSelectedList() {
		return selectedList;
	}
	public void setSelectedList(
			List<WrapperBeanObject<Mco006SrchContractStatusSP>> selectedList) {
		this.selectedList = selectedList;
	}
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public boolean isDisableSelectAll() {
		return disableSelectAll;
	}
	public void setDisableSelectAll(boolean disableSelectAll) {
		this.disableSelectAll = disableSelectAll;
	}
	public String getSelectedStatus() {
		return selectedStatus;
	}
	public void setSelectedStatus(String selectedStatus) {
		this.selectedStatus = selectedStatus;
	}
	public List<SelectItem> getRegionList() {
		return regionList;
	}
	public void setRegionList(List<SelectItem> regionList) {
		this.regionList = regionList;
	}
	public List<SelectItem> getContractStatList() {
		return contractStatList;
	}
	public void setContractStatList(List<SelectItem> contractStatList) {
		this.contractStatList = contractStatList;
	}
	public List<SelectItem> getBorrowOfficerList() {
		return borrowOfficerList;
	}
	public void setBorrowOfficerList(List<SelectItem> borrowOfficerList) {
		this.borrowOfficerList = borrowOfficerList;
	}
	
}
