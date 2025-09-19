package th.co.ais.web.ir.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import th.co.ais.domain.ir.Policy;
import th.co.ais.domain.ir.PolicyDtl;
import th.co.ais.domain.ir.PolicySP;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;
import th.co.ais.web.bean.common.PopupMultiZoneBean;
import th.co.ais.web.bean.common.PopupSiteMultiContractBean;

public class SEMMIR009Bean extends AbstractBean{
	
	private List<SelectItem> companyList;
	private List<SelectItem> networkTypeList;
	private List<SelectItem> transferTypeList;
	private List<SelectItem> policyTypeList;
	private List<SelectItem> draftStatusList;
	private List<SelectItem> docTypeList;
	
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
	private List<PolicySP> policySPPopUpList;
	
	private boolean renderedMsgFormSearchPopup;
	private boolean renderedMsgDataNotFoundPopup;
	private Policy policyInfo;
	
	private PopupMultiZoneBean popupMultiZoneBean;
	
	// page semmir008-1
	private PolicySP searchCriteria;
	private List<WrapperBeanObject<PolicySP>> policySPList;
	
	private List<SelectItem> hourList;
	private List<SelectItem> minuteList;
	private List<SelectItem> monthList;
	private List<SelectItem> yearList;
	
	
	@Override
	public int getRowPerPage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		// TODO Auto-generated method stub

	}

	public List<SelectItem> getCompanyList() {
		if(companyList == null)
			companyList = new ArrayList<SelectItem>();
		return companyList;
	}

	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}

	public List<SelectItem> getNetworkTypeList() {
		if(networkTypeList == null)
			networkTypeList = new ArrayList<SelectItem>();
		return networkTypeList;
	}

	public void setNetworkTypeList(List<SelectItem> networkTypeList) {
		this.networkTypeList = networkTypeList;
	}

	public List<SelectItem> getTransferTypeList() {
		if(transferTypeList == null)
			transferTypeList = new ArrayList<SelectItem>();
		return transferTypeList;
	}

	public void setTransferTypeList(List<SelectItem> transferTypeList) {
		this.transferTypeList = transferTypeList;
	}

	public List<SelectItem> getPolicyTypeList() {
		if(policyTypeList == null)
			policyTypeList = new ArrayList<SelectItem>();
		return policyTypeList;
	}

	public void setPolicyTypeList(List<SelectItem> policyTypeList) {
		this.policyTypeList = policyTypeList;
	}

	public List<SelectItem> getDraftStatusList() {
		if(draftStatusList == null)
			draftStatusList = new ArrayList<SelectItem>();
		return draftStatusList;
	}

	public void setDraftStatusList(List<SelectItem> draftStatusList) {
		this.draftStatusList = draftStatusList;
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

	public List<PolicySP> getPolicySPPopUpList() {
		return policySPPopUpList;
	}

	public void setPolicySPPopUpList(List<PolicySP> policySPPopUpList) {
		this.policySPPopUpList = policySPPopUpList;
	}

	public boolean isRenderedMsgFormSearchPopup() {
		return renderedMsgFormSearchPopup;
	}

	public void setRenderedMsgFormSearchPopup(boolean renderedMsgFormSearchPopup) {
		this.renderedMsgFormSearchPopup = renderedMsgFormSearchPopup;
	}

	public boolean isRenderedMsgDataNotFoundPopup() {
		return renderedMsgDataNotFoundPopup;
	}

	public void setRenderedMsgDataNotFoundPopup(boolean renderedMsgDataNotFoundPopup) {
		this.renderedMsgDataNotFoundPopup = renderedMsgDataNotFoundPopup;
	}

	public PolicySP getSearchCriteria() {
		return searchCriteria;
	}

	public void setSearchCriteria(PolicySP searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	public List<WrapperBeanObject<PolicySP>> getPolicySPList() {
		return policySPList;
	}

	public void setPolicySPList(List<WrapperBeanObject<PolicySP>> policySPList) {
		this.policySPList = policySPList;
	}

	public Policy getPolicyInfo() {
		return policyInfo;
	}

	public void setPolicyInfo(Policy policyInfo) {
		this.policyInfo = policyInfo;
	}

	public List<SelectItem> getHourList() {
		return hourList;
	}

	public void setHourList(List<SelectItem> hourList) {
		this.hourList = hourList;
	}

	public List<SelectItem> getMinuteList() {
		return minuteList;
	}

	public void setMinuteList(List<SelectItem> minuteList) {
		this.minuteList = minuteList;
	}

	public List<SelectItem> getMonthList() {
		return monthList;
	}

	public void setMonthList(List<SelectItem> monthList) {
		this.monthList = monthList;
	}

	public List<SelectItem> getYearList() {
		return yearList;
	}

	public void setYearList(List<SelectItem> yearList) {
		this.yearList = yearList;
	}

	public List<SelectItem> getDocTypeList() {
		return docTypeList;
	}

	public void setDocTypeList(List<SelectItem> docTypeList) {
		this.docTypeList = docTypeList;
	}
	
	public PopupMultiZoneBean getPopupMultiZoneBean() {
		return (PopupMultiZoneBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupMultiZoneBean");
	}


	public void setPopupMultiZoneBean(
			PopupMultiZoneBean popupMultiZoneBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupMultiZoneBean", popupMultiZoneBean);
	}
	

}
