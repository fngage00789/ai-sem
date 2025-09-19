package th.co.ais.web.ir.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.ir.PolicyDtl;
import th.co.ais.domain.ir.PolicySP;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMIRPopupBean extends AbstractBean {
	
	private List<SelectItem> companyList;
	private List<SelectItem> networkTypeList;
	private List<SelectItem> transferTypeList;
	private List<SelectItem> policyTypeList;
	private String rowId;
	
	private int rowPerPage = 10;
	private int maxPage = 10;
	private int maxSearchResult = 100;
	
	private String networkType;
	private String tranferType;
	private String company;
	private String policyType;
	
	private String draftStatus;
	private String selectedRadio;	
	private List<PolicyDtl> policyDtlList;
	private PolicySP policySP;
	private PolicySP policySPPop;
	private String msCount;
	
	private boolean insuredFlg;
	private String draftID;
	private List<WrapperBeanObject<PolicySP>> policySPList;
	private String currentPage;
	
	private boolean disableBtnSelect = true;
	
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public List<SelectItem> getCompanyList() {
		return (companyList == null)?new ArrayList<SelectItem>():companyList;
	}

	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}

	public List<SelectItem> getNetworkTypeList() {
		return (networkTypeList == null)?new ArrayList<SelectItem>(): networkTypeList;
	}

	public void setNetworkTypeList(List<SelectItem> networkTypeList) {
		this.networkTypeList = networkTypeList;
	}

	public List<SelectItem> getTransferTypeList() {
		return (transferTypeList == null)?new ArrayList<SelectItem>():transferTypeList;
	}

	public void setTransferTypeList(List<SelectItem> transferTypeList) {
		this.transferTypeList = transferTypeList;
	}

	public List<SelectItem> getPolicyTypeList() {
		return (policyTypeList == null)?new ArrayList<SelectItem>():policyTypeList;
	}

	public void setPolicyTypeList(List<SelectItem> policyTypeList) {
		this.policyTypeList = policyTypeList;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
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

	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	public String getTranferType() {
		return tranferType;
	}

	public void setTranferType(String tranferType) {
		this.tranferType = tranferType;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getDraftStatus() {
		return draftStatus;
	}

	public void setDraftStatus(String draftStatus) {
		this.draftStatus = draftStatus;
	}

	public String getSelectedRadio() {
		return selectedRadio;
	}

	public void setSelectedRadio(String selectedRadio) {
		this.selectedRadio = selectedRadio;
	}

	public List<PolicyDtl> getPolicyDtlList() {
		return policyDtlList;
	}

	public void setPolicyDtlList(List<PolicyDtl> policyDtlList) {
		this.policyDtlList = policyDtlList;
	}

	public PolicySP getPolicySP() {
		return policySP;
	}

	public void setPolicySP(PolicySP policySP) {
		this.policySP = policySP;
	}

	public PolicySP getPolicySPPop() {
		return policySPPop;
	}

	public void setPolicySPPop(PolicySP policySPPop) {
		this.policySPPop = policySPPop;
	}

	public String getMsCount() {
		return msCount;
	}

	public void setMsCount(String msCount) {
		this.msCount = msCount;
	}

	public boolean isInsuredFlg() {
		return insuredFlg;
	}

	public void setInsuredFlg(boolean insuredFlg) {
		this.insuredFlg = insuredFlg;
	}

	public String getDraftID() {
		return draftID;
	}

	public void setDraftID(String draftID) {
		this.draftID = draftID;
	}

	public List<WrapperBeanObject<PolicySP>> getPolicySPList() {
		return policySPList;
	}

	public void setPolicySPList(List<WrapperBeanObject<PolicySP>> policySPList) {
		this.policySPList = policySPList;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public boolean isDisableBtnSelect() {
		return disableBtnSelect;
	}

	public void setDisableBtnSelect(boolean disableBtnSelect) {
		this.disableBtnSelect = disableBtnSelect;
	}
	

}
