package th.co.ais.web.ir.bean;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import th.co.ais.domain.ir.Mir013Edt;
import th.co.ais.domain.ir.Mir013Sch;
import th.co.ais.domain.ir.Policy;
import th.co.ais.domain.ir.PolicySP;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;
import th.co.ais.web.bean.common.PopupMultiZoneBean;

public class SEMMIR013Bean extends AbstractBean {
	
	private List<SelectItem> companyList;
	private List<SelectItem> networkTypeList;
	private List<SelectItem> transferTypeList;
	private List<SelectItem> policyTypeList;
	private List<SelectItem> claimStatusList;
	private List<SelectItem> lossTypeList;
	private List<SelectItem> policySelectList;
	
	private Mir013Sch mir013Sch;
	private List<WrapperBeanObject<Mir013Sch>> mir013SchList;
	
	private Mir013Edt mir013Edt;
	
	private PopupMultiZoneBean popupMultiZoneBean;
	
	private List<PolicySP> policyList;
	
	private boolean renderConfirm = false;
	private boolean renderMsgFromImport = false;
	private boolean renderLoadExcel = false;
	private String confirmLoadExcelMsg;
	
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

	public List<SelectItem> getPolicyTypeList() {
		return policyTypeList;
	}

	public void setPolicyTypeList(List<SelectItem> policyTypeList) {
		this.policyTypeList = policyTypeList;
	}

	public List<SelectItem> getClaimStatusList() {
		return claimStatusList;
	}

	public void setClaimStatusList(List<SelectItem> claimStatusList) {
		this.claimStatusList = claimStatusList;
	}

	public List<SelectItem> getLossTypeList() {
		return lossTypeList;
	}

	public void setLossTypeList(List<SelectItem> lossTypeList) {
		this.lossTypeList = lossTypeList;
	}

	public Mir013Sch getMir013Sch() {
		return mir013Sch;
	}

	public void setMir013Sch(Mir013Sch mir013Sch) {
		this.mir013Sch = mir013Sch;
	}

	public List<WrapperBeanObject<Mir013Sch>> getMir013SchList() {
		return mir013SchList;
	}

	public void setMir013SchList(List<WrapperBeanObject<Mir013Sch>> mir013SchList) {
		this.mir013SchList = mir013SchList;
	}

	public PopupMultiZoneBean getPopupMultiZoneBean() {
		return (PopupMultiZoneBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupMultiZoneBean");
	}


	public void setPopupMultiZoneBean(
			PopupMultiZoneBean popupMultiZoneBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupMultiZoneBean", popupMultiZoneBean);
	}

	public Mir013Edt getMir013Edt() {
		return mir013Edt;
	}

	public void setMir013Edt(Mir013Edt mir013Edt) {
		this.mir013Edt = mir013Edt;
	}

	public List<SelectItem> getPolicySelectList() {
		return policySelectList;
	}

	public void setPolicySelectList(List<SelectItem> policySelectList) {
		this.policySelectList = policySelectList;
	}

	public List<PolicySP> getPolicyList() {
		return policyList;
	}

	public void setPolicyList(List<PolicySP> policyList) {
		this.policyList = policyList;
	}

	public boolean isRenderConfirm() {
		return renderConfirm;
	}

	public void setRenderConfirm(boolean renderConfirm) {
		this.renderConfirm = renderConfirm;
	}

	public boolean isRenderMsgFromImport() {
		return renderMsgFromImport;
	}

	public void setRenderMsgFromImport(boolean renderMsgFromImport) {
		this.renderMsgFromImport = renderMsgFromImport;
	}

	public boolean isRenderLoadExcel() {
		return renderLoadExcel;
	}

	public void setRenderLoadExcel(boolean renderLoadExcel) {
		this.renderLoadExcel = renderLoadExcel;
	}

	public String getConfirmLoadExcelMsg() {
		return confirmLoadExcelMsg;
	}

	public void setConfirmLoadExcelMsg(String confirmLoadExcelMsg) {
		this.confirmLoadExcelMsg = confirmLoadExcelMsg;
	}

}
