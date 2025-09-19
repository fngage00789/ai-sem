package th.co.ais.web.ir.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.SelectItem;

//import com.arjuna.ats.internal.jdbc.drivers.modifiers.list;

import th.co.ais.domain.ir.Mir007Act;
import th.co.ais.domain.ir.PolicyDtl;
import th.co.ais.domain.ir.PolicySP;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;


public class SEMMIR007Bean extends AbstractBean implements Serializable {

	private static final long serialVersionUID = 2359355352402848631L;
	
	private List<SelectItem> companyList;
	private List<SelectItem> networkTypeList;
	private List<SelectItem> transferTypeList;
	private List<SelectItem> policyTypeList;
	private List<SelectItem> draftStatusList;
	private List<SelectItem> refPolicyList;
	private List<SelectItem> premiumList;
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
	private List<WrapperBeanObject<PolicySP>> policySPList;	
	private List<PolicyDtl> policyDtlList;
	private PolicySP policySP;
	private PolicySP policySPPop;
	private String msCount;
	
	private boolean insuredFlg;
	private PolicySP searchCriteria;
	private String draftID;
	private List<PolicySP> policySPPopUpList;
	
	private boolean renderedMsgFormSearchPopup;
	private boolean renderedMsgDataNotFoundPopup;
	
	private boolean chkSelAll;
	private boolean disBtnSave = true;
	private boolean disBtnRemove = true;
	
	private Mir007Act policySPPopAdd;
	private boolean disableRefPolicy = true;
	
	private boolean renderReqTransferType = false;
	private boolean renderReqRefPolicy = false;
	private boolean popupCloseValidAdd = false;
	private boolean renderPopupSave = false;
	private boolean renderContractNo = false;
	
	private String confirmPopupAddMsg;
	private String tmpGenType;
	
	
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
	public void setNetworkTypeList(List<SelectItem> networkTypeList) {
		this.networkTypeList = networkTypeList;
	}
	public List<SelectItem> getNetworkTypeList() {
		return networkTypeList;
	}
	
	public void setTransferTypeList(List<SelectItem> transferTypeList) {
		this.transferTypeList = transferTypeList;
	}
	public List<SelectItem> getTransferTypeList() {
		return transferTypeList;
	}	
	public void setPolicyTypeList(List<SelectItem> policyTypeList) {
		this.policyTypeList = policyTypeList;
	}
	public List<SelectItem> getPolicyTypeList() {
		return policyTypeList;
	}
	public void setDraftStatusList(List<SelectItem> draftStatusList) {
		this.draftStatusList = draftStatusList;
	}
	public List<SelectItem> getDraftStatusList() {
		return draftStatusList;
	}
	public void setDraftStatus(String draftStatus) {
		this.draftStatus = draftStatus;
	}
	public String getDraftStatus() {
		return draftStatus;
	}
	public void setSelectedRadio(String selectedRadio) {
		this.selectedRadio = selectedRadio;
	}
	public String getSelectedRadio() {
		return selectedRadio;
	}
	public PolicySP getPolicySP() {
		return policySP;
	}
	public void setPolicySP(PolicySP policySP) {
		this.policySP = policySP;
	}
	public void setMsCount(String msCount) {
		this.msCount = msCount;
	}
	public String getMsCount() {
		return msCount;
	}
	public void setPolicyDtlList(List<PolicyDtl> policyDtlList) {
		this.policyDtlList = policyDtlList;
	}
	public List<PolicyDtl> getPolicyDtlList() {
		return policyDtlList;
	}
	public boolean isInsuredFlg() {
		return insuredFlg;
	}
	public void setInsuredFlg(boolean insuredFlg) {
		this.insuredFlg = insuredFlg;
	}
	public PolicySP getSearchCriteria() {
		return searchCriteria;
	}
	public void setSearchCriteria(PolicySP searchCriteria) {
		this.searchCriteria = searchCriteria;
	}
	public String getDraftID() {
		return draftID;
	}
	public void setDraftID(String draftID) {
		this.draftID = draftID;
	}
	public PolicySP getPolicySPPop() {
		return policySPPop;
	}
	public void setPolicySPPop(PolicySP policySPPop) {
		this.policySPPop = policySPPop;
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
	public List<WrapperBeanObject<PolicySP>> getPolicySPList() {
		return policySPList;
	}
	public void setPolicySPList(List<WrapperBeanObject<PolicySP>> policySPList) {
		this.policySPList = policySPList;
	}
	public boolean isChkSelAll() {
		return chkSelAll;
	}
	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}
	public boolean isDisBtnSave() {
		return disBtnSave;
	}
	public void setDisBtnSave(boolean disBtnSave) {
		this.disBtnSave = disBtnSave;
	}
	public boolean isDisBtnRemove() {
		return disBtnRemove;
	}
	public void setDisBtnRemove(boolean disBtnRemove) {
		this.disBtnRemove = disBtnRemove;
	}
	public Mir007Act getPolicySPPopAdd() {
		return policySPPopAdd;
	}
	public void setPolicySPPopAdd(Mir007Act policySPPopAdd) {
		this.policySPPopAdd = policySPPopAdd;
	}
	public List<SelectItem> getRefPolicyList() {
		return refPolicyList;
	}
	public boolean isDisableRefPolicy() {
		return disableRefPolicy;
	}
	public void setRefPolicyList(List<SelectItem> refPolicyList) {
		this.refPolicyList = refPolicyList;
	}
	public void setDisableRefPolicy(boolean disableRefPolicy) {
		this.disableRefPolicy = disableRefPolicy;
	}
	public boolean isRenderReqTransferType() {
		return renderReqTransferType;
	}
	public void setRenderReqTransferType(boolean renderReqTransferType) {
		this.renderReqTransferType = renderReqTransferType;
	}
	public boolean isRenderReqRefPolicy() {
		return renderReqRefPolicy;
	}
	public void setRenderReqRefPolicy(boolean renderReqRefPolicy) {
		this.renderReqRefPolicy = renderReqRefPolicy;
	}
	public boolean isPopupCloseValidAdd() {
		return popupCloseValidAdd;
	}
	public void setPopupCloseValidAdd(boolean popupCloseValidAdd) {
		this.popupCloseValidAdd = popupCloseValidAdd;
	}
	public String getConfirmPopupAddMsg() {
		return confirmPopupAddMsg;
	}
	public void setConfirmPopupAddMsg(String confirmPopupAddMsg) {
		this.confirmPopupAddMsg = confirmPopupAddMsg;
	}
	public boolean isRenderPopupSave() {
		return renderPopupSave;
	}
	public void setRenderPopupSave(boolean renderPopupSave) {
		this.renderPopupSave = renderPopupSave;
	}
	public boolean isRenderContractNo() {
		return renderContractNo;
	}
	public void setRenderContractNo(boolean renderContractNo) {
		this.renderContractNo = renderContractNo;
	}
	public List<SelectItem> getPremiumList() {
		return premiumList;
	}
	public void setPremiumList(List<SelectItem> premiumList) {
		this.premiumList = premiumList;
	}
	public String getTmpGenType() {
		return tmpGenType;
	}
	public void setTmpGenType(String tmpGenType) {
		this.tmpGenType = tmpGenType;
	}
	
	
}
