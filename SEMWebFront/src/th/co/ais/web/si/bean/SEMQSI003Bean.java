package th.co.ais.web.si.bean;

import java.util.Date;
import java.util.List;


import th.co.ais.domain.si.QuerySiteManagementSearchSP;
import th.co.ais.web.bean.AbstractBean;

public class SEMQSI003Bean extends AbstractBean{

	
	private static final long serialVersionUID = -3578155470405023645L;

	
	private List<QuerySiteManagementSearchSP> querySiteManagementSearchSPList;
	private QuerySiteManagementSearchSP querySiteManagementSearchSP;
	
	private String confirmDeleteMsg;
	private Boolean buttonAdd;
	private Date sendRenewBackDt;
	private String validatePopup;
	
	public List<QuerySiteManagementSearchSP> getQuerySiteManagementSearchSPList() {
		return querySiteManagementSearchSPList;
	}
	public void setQuerySiteManagementSearchSPList(
			List<QuerySiteManagementSearchSP> querySiteManagementSearchSPList) {
		this.querySiteManagementSearchSPList = querySiteManagementSearchSPList;
	}
	public QuerySiteManagementSearchSP getQuerySiteManagementSearchSP() {
		return querySiteManagementSearchSP;
	}
	public void setQuerySiteManagementSearchSP(
			QuerySiteManagementSearchSP querySiteManagementSearchSP) {
		this.querySiteManagementSearchSP = querySiteManagementSearchSP;
	}
	
	
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
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
