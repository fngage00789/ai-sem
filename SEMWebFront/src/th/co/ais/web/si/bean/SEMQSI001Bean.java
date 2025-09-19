package th.co.ais.web.si.bean;

import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.si.QueryRenewSAMSearchSP;
import th.co.ais.web.bean.AbstractBean;

public class SEMQSI001Bean extends AbstractBean{

	
	private static final long serialVersionUID = -3578155470405023645L;
	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> sendRenewTypeList;
	private List<SelectItem> approveStatusList;
	private List<SelectItem> siteStatusList;
	private List<SelectItem> siteTypeList;
	
	private List<QueryRenewSAMSearchSP> queryRenewSAMSearchSPList;
	private QueryRenewSAMSearchSP queryRenewSAMSearchSP;
	
	private String confirmDeleteMsg;
	private Boolean buttonAdd;
	private Date sendRenewBackDt;
	private String validatePopup;
	
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
	
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	
	public List<SelectItem> getSendRenewTypeList() {
		return sendRenewTypeList;
	}
	public void setSendRenewTypeList(List<SelectItem> sendRenewTypeList) {
		this.sendRenewTypeList = sendRenewTypeList;
	}
	public List<QueryRenewSAMSearchSP> getQueryRenewSAMSearchSPList() {
		return queryRenewSAMSearchSPList;
	}
	public void setQueryRenewSAMSearchSPList(
			List<QueryRenewSAMSearchSP> queryRenewSAMSearchSPList) {
		this.queryRenewSAMSearchSPList = queryRenewSAMSearchSPList;
	}
	public QueryRenewSAMSearchSP getQueryRenewSAMSearchSP() {
		return queryRenewSAMSearchSP;
	}
	public void setQueryRenewSAMSearchSP(QueryRenewSAMSearchSP queryRenewSAMSearchSP) {
		this.queryRenewSAMSearchSP = queryRenewSAMSearchSP;
	}
	public List<SelectItem> getApproveStatusList() {
		return approveStatusList;
	}
	public void setApproveStatusList(List<SelectItem> approveStatusList) {
		this.approveStatusList = approveStatusList;
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
	public void setSiteTypeList(List<SelectItem> siteTypeList) {
		this.siteTypeList = siteTypeList;
	}
	public List<SelectItem> getSiteTypeList() {
		return siteTypeList;
	}

}
