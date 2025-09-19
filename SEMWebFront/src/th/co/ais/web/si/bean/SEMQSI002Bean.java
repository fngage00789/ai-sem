package th.co.ais.web.si.bean;

import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.si.QueryNetworkStatusSearchSP;
import th.co.ais.web.bean.AbstractBean;

public class SEMQSI002Bean extends AbstractBean{

	
	private static final long serialVersionUID = -3578155470405023645L;

	private List<SelectItem> siteStatusList;
	private List<SelectItem> networkStatusList;
	private List<SelectItem> pmsStatusList;
	
	private List<QueryNetworkStatusSearchSP> queryNetworkStatusSearchSPList;
	private QueryNetworkStatusSearchSP queryNetworkStatusSearchSP;
	
	private String confirmDeleteMsg;
	private Boolean buttonAdd;
	private Date sendRenewBackDt;
	private String validatePopup;
	
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public List<SelectItem> getNetworkStatusList() {
		return networkStatusList;
	}
	public void setNetworkStatusList(List<SelectItem> networkStatusList) {
		this.networkStatusList = networkStatusList;
	}
	public List<SelectItem> getPmsStatusList() {
		return pmsStatusList;
	}
	public void setPmsStatusList(List<SelectItem> pmsStatusList) {
		this.pmsStatusList = pmsStatusList;
	}
	public List<QueryNetworkStatusSearchSP> getQueryNetworkStatusSearchSPList() {
		return queryNetworkStatusSearchSPList;
	}
	public void setQueryNetworkStatusSearchSPList(List<QueryNetworkStatusSearchSP> queryNetworkStatusSearchSPList) {
		this.queryNetworkStatusSearchSPList = queryNetworkStatusSearchSPList;
	}
	public QueryNetworkStatusSearchSP getQueryNetworkStatusSearchSP() {
		return queryNetworkStatusSearchSP;
	}
	public void setQueryNetworkStatusSearchSP(
			QueryNetworkStatusSearchSP queryNetworkStatusSearchSP) {
		this.queryNetworkStatusSearchSP = queryNetworkStatusSearchSP;
	}
	public List<SelectItem> getSiteStatusList() {
		return siteStatusList;
	}
	public void setSiteStatusList(List<SelectItem> siteStatusList) {
		this.siteStatusList = siteStatusList;
	}
	public void setConfirmDeleteMsg(String confirmDeleteMsg) {
		this.confirmDeleteMsg = confirmDeleteMsg;
	}
	public String getConfirmDeleteMsg() {
		return confirmDeleteMsg;
	}
	public void setButtonAdd(Boolean buttonAdd) {
		this.buttonAdd = buttonAdd;
	}
	public Boolean getButtonAdd() {
		return buttonAdd;
	}
	public void setSendRenewBackDt(Date sendRenewBackDt) {
		this.sendRenewBackDt = sendRenewBackDt;
	}
	public Date getSendRenewBackDt() {
		return sendRenewBackDt;
	}
	public void setValidatePopup(String validatePopup) {
		this.validatePopup = validatePopup;
	}
	public String getValidatePopup() {
		return validatePopup;
	}

}
