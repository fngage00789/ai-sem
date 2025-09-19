package th.co.ais.web.ir.bean;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import th.co.ais.domain.ir.Mir013Edt;
import th.co.ais.domain.ir.Mir013Sch;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;
import th.co.ais.web.bean.common.PopupMultiZoneBean;

public class SEMMIR014Bean extends AbstractBean {
	
	private List<SelectItem> companyList;
	private List<SelectItem> networkTypeList;
	private List<SelectItem> transferTypeList;
	private List<SelectItem> policyTypeList;
	private List<SelectItem> claimStatusList;
	private List<SelectItem> lossTypeList;
	
	private Mir013Sch mir013SchSP;
	private List<WrapperBeanObject<Mir013Sch>> mir013SchSPList;
	
	
	private PopupMultiZoneBean popupMultiZoneBean;
	
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

	public PopupMultiZoneBean getPopupMultiZoneBean() {
		return (PopupMultiZoneBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupMultiZoneBean");
	}

	public void setPopupMultiZoneBean(
			PopupMultiZoneBean popupMultiZoneBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupMultiZoneBean", popupMultiZoneBean);
	}

	public Mir013Sch getMir013SchSP() {
		return mir013SchSP;
	}

	public void setMir013SchSP(Mir013Sch mir013SchSP) {
		this.mir013SchSP = mir013SchSP;
	}

	public List<WrapperBeanObject<Mir013Sch>> getMir013SchSPList() {
		return mir013SchSPList;
	}

	public void setMir013SchSPList(
			List<WrapperBeanObject<Mir013Sch>> mir013SchSPList) {
		this.mir013SchSPList = mir013SchSPList;
	}

}
