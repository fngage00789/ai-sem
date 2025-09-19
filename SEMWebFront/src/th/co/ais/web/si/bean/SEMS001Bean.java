package th.co.ais.web.si.bean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import Permission.bean.ais.com.SSOCompCode;
import Permission.bean.ais.com.SSOResponse;

import com.jcraft.jsch.UserInfo;
import common.bean.ais.com.Message;

import th.co.ais.domain.gm.TransPayment;
import th.co.ais.domain.si.PopupContractSearchSP;
import th.co.ais.domain.si.SiteApprove;
import th.co.ais.domain.si.SiteApproveDisplaySP;
import th.co.ais.domain.si.SiteApproveMapLoc;
import th.co.ais.domain.si.SiteApproveMapLocSP;
import th.co.ais.domain.si.SiteLocationSP;
import th.co.ais.util.SAPUtility;
import th.co.ais.web.bean.AbstractBean;
import th.co.ais.web.bean.SsoBean;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.WebUtil;

public class SEMS001Bean extends AbstractBean {

	private static final long serialVersionUID = 1419068899710599385L;

	public SEMS001Bean(){
		
		try {
			SsoBean ssoBean = (SsoBean)FacesUtils.getInstance().getSessionMapValue("ssoBean");
			if(ssoBean!=null){
				
				setToken(ssoBean.getToken());
				
				String ssoSerlzePath = WebUtil.getResources("resources.application_th", "ssoSerializePath").concat(ssoBean.getUserName()+"*");
				List<File> files = SAPUtility.listFile(ssoSerlzePath);
				if(files!=null){
					System.out.println("Loop Sso xml");
					List<SelectItem> items = new ArrayList<SelectItem>();
					for(File file : files){
						System.out.println(" - "+file.getName());
						items.add(new SelectItem(file.getName(), file.getName()));
					}
					setSsoXmlList(items);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//check null
		List<SelectItem> emptyList = new ArrayList<SelectItem>();
		setCompanyList(emptyList);
		setRegionList(emptyList);
		setReqTypeList(emptyList);
		setSiteApproveStatusList(emptyList);
		setListFileSAP(emptyList);
		setListFileSEM(emptyList);
		setSsoXmlList(getSsoXmlList()!=null?getSsoXmlList():emptyList);
		setProcesses(new ArrayList<Process>());
		
	}
	
	// data dropdown list
	private List<SelectItem> companyList;
	private List<SelectItem> reqTypeList;
	private List<SelectItem> siteApproveStatusList;
	private List<SelectItem> regionList;
	private List<SelectItem> reqDocTypeList;
	
	//Dropdown Xml Serialize
	private boolean ssoXmlSelected;
	private List<SelectItem> ssoXmlList;
	
	//Dropdown SEM, SAP
	private List<SelectItem> listFileSAP;
	private List<SelectItem> listFileSEM;
	
	private String semPath = SAPUtility.SEM_PATH;
	private String sapPath = SAPUtility.SAP_PATH;
	public String getSemPath() {return semPath;}
	public void setSemPath(String semPath) {this.semPath=semPath;}
	public String getSapPath() {return sapPath;}
	public void setSapPath(String sapPath) { this.sapPath=sapPath;}
	
	/* Exec shell script */
	private String user;
	public void setUser(String user) {	this.user = user;	}
	public String getUser() {	return user;	}
	
	private String password;
	public void setPassword(String password) {	this.password = password;	}
	public String getPassword() {	return password;	}
	
	private String port;
	public void setPort(String port) {	this.port = port;	}
	public String getPort() {	return port;	}
	
	private List<Process> processes;
	public void setProcesses(List<Process> processes) { this.processes = processes;	}
	public List<Process> getProcesses() {	return processes;	}
	
	private String command;
	public void setCommand(String command) {	this.command = command;	}
	public String getCommand() {	return command;	}
	
	private String commandOutput;
	public void setCommandOutput(String commandOutput) {this.commandOutput = commandOutput;	}
	public String getCommandOutput() {	return commandOutput;	}
	
	private String commandError;
	public void setCommandError(String commandError) {this.commandError = commandError;	}
	public String getCommandError() {	return commandError;	}
	/* End Exec shell script */
	
	/* Sync Session SSO */
	private String token;
	public void setToken(String token) {this.token = token;	}
	public String getToken() {	return token;	}
	
	private Message syncSsoMsg;
	public void setSyncSsoMsg(Message syncSsoMsg) {this.syncSsoMsg = syncSsoMsg;	}
	public Message getSyncSsoMsg() {	return syncSsoMsg;	}
	
	private String syncSsoOutput;
	public void setSyncSsoOutput(String syncSsoOutput) {	this.syncSsoOutput = syncSsoOutput;	}
	public String getSyncSsoOutput() {	return syncSsoOutput;	}
	/* End Sync Session SSO */
	
	/* Test Component */
	private String programCode;
	public void setProgramCode(String programCode) {this.programCode = programCode.toUpperCase().trim();	}
	public String getProgramCode() {	return programCode;	}
	
	private String componentCode;
	public void setComponentCode(String componentCode) {	this.componentCode = componentCode.trim();	}
	public String getComponentCode() {		return componentCode;	}
	
	private List<SSOCompCode> compCodes;
	public void setCompCodes(List<SSOCompCode> compCodes) { this.compCodes = compCodes;	}
	public List<SSOCompCode> getCompCodes() {	return compCodes;	}
	/* End Test Component */
	
	private Map<String, Boolean> renderer;
	private Map<String, Boolean> disabler;
	public Map<String, Boolean> getRenderer() {return WebUtil.getRenders();	}
	public Map<String, Boolean> getDisabler() {	return WebUtil.getDisables();	}

	
	// page semmsi001-1
	private boolean chkSelAll;
	private SiteApproveDisplaySP searchCriteria;
	private List<SiteApproveDisplaySP> siteApproveList;
	private List<TransPayment> transPayments;

	// page semmsi001-2
	private SiteApprove siteSP;
	private SiteLocationSP siteMapLoc;
	private SiteApproveMapLoc tempSiteMapLoc;
	private List<SiteApproveMapLocSP> siteMapLocList;
	
	// popup contract
	private PopupContractSearchSP popupContractCriteria;
	private List<PopupContractSearchSP> contractList;

	// popup site location
	private SiteLocationSP siteLocationCriteria;
	private List<SiteLocationSP> siteLocationList;

	private String pageStatus;
	private String txtContent;
	private String txtContent2;
	private String txtAlert;
	private String cssTxtAlert;
	private String txtAlertSiteLoc;
	private String cssTxtAlertSiteLoc;
	private boolean visibleModeEdit;
	private boolean visibleModeView;
	private boolean visibleBtnModeView;
	private boolean reqContractNo;
	
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
	public List<SelectItem> getSiteApproveStatusList() {
		return siteApproveStatusList;
	}
	public void setSiteApproveStatusList(List<SelectItem> siteApproveStatusList) {
		this.siteApproveStatusList = siteApproveStatusList;
	}
	public List<SelectItem> getRegionList() {
		return regionList;
	}
	public void setRegionList(List<SelectItem> regionList) {
		this.regionList = regionList;
	}
	public SiteApproveDisplaySP getSearchCriteria() {
		return searchCriteria;
	}
	public void setSearchCriteria(SiteApproveDisplaySP searchCriteria) {
		this.searchCriteria = searchCriteria;
	}
	public List<SiteApproveDisplaySP> getSiteApproveList() {
		return siteApproveList;
	}
	public void setSiteApproveList(List<SiteApproveDisplaySP> siteApproveList) {
		this.siteApproveList = siteApproveList;
	}
	public List<TransPayment> getTransPayments() {
		return transPayments;
	}
	public void setTransPayments(List<TransPayment> transPayments) {
		this.transPayments = transPayments;
	}
	public List<SelectItem> getReqDocTypeList() {
		return reqDocTypeList;
	}
	public void setReqDocTypeList(List<SelectItem> reqDocTypeList) {
		this.reqDocTypeList = reqDocTypeList;
	}
	
	public String getPageStatus() {
		return pageStatus;
	}
	public void setPageStatus(String pageStatus) {
		this.pageStatus = pageStatus;
	}
	public SiteApprove getSiteSP() {
		return siteSP;
	}
	public void setSiteSP(SiteApprove siteSP) {
		this.siteSP = siteSP;
	}
	public PopupContractSearchSP getPopupContractCriteria() {
		return popupContractCriteria;
	}
	public void setPopupContractCriteria(PopupContractSearchSP popupContractCriteria) {
		this.popupContractCriteria = popupContractCriteria;
	}
	public List<PopupContractSearchSP> getContractList() {
		return contractList;
	}
	public void setContractList(List<PopupContractSearchSP> contractList) {
		this.contractList = contractList;
	}
	public String getTxtAlert() {
		return txtAlert;
	}
	public void setTxtAlert(String txtAlert) {
		this.txtAlert = txtAlert;
	}
	public SiteLocationSP getSiteLocationCriteria() {
		return siteLocationCriteria;
	}
	public void setSiteLocationCriteria(SiteLocationSP siteLocationCriteria) {
		this.siteLocationCriteria = siteLocationCriteria;
	}
	public List<SiteLocationSP> getSiteLocationList() {
		return siteLocationList;
	}
	public void setSiteLocationList(List<SiteLocationSP> siteLocationList) {
		this.siteLocationList = siteLocationList;
	}
	public SiteLocationSP getSiteMapLoc() {
		return siteMapLoc;
	}
	public void setSiteMapLoc(SiteLocationSP siteMapLoc) {
		this.siteMapLoc = siteMapLoc;
	}
	public List<SiteApproveMapLocSP> getSiteMapLocList() {
		return siteMapLocList;
	}
	public void setSiteMapLocList(List<SiteApproveMapLocSP> siteMapLocList) {
		this.siteMapLocList = siteMapLocList;
	}
	public String getCssTxtAlert() {
		return cssTxtAlert;
	}
	public void setCssTxtAlert(String cssTxtAlert) {
		this.cssTxtAlert = cssTxtAlert;
	}
	public String getTxtAlertSiteLoc() {
		return txtAlertSiteLoc;
	}
	public void setTxtAlertSiteLoc(String txtAlertSiteLoc) {
		this.txtAlertSiteLoc = txtAlertSiteLoc;
	}
	public String getCssTxtAlertSiteLoc() {
		return cssTxtAlertSiteLoc;
	}
	public void setCssTxtAlertSiteLoc(String cssTxtAlertSiteLoc) {
		this.cssTxtAlertSiteLoc = cssTxtAlertSiteLoc;
	}
	public String getTxtContent() {
		return txtContent;
	}
	public void setTxtContent(String txtContent) {
		this.txtContent = txtContent;
	}
	public SiteApproveMapLoc getTempSiteMapLoc() {
		return tempSiteMapLoc;
	}
	public void setTempSiteMapLoc(SiteApproveMapLoc tempSiteMapLoc) {
		this.tempSiteMapLoc = tempSiteMapLoc;
	}
	public boolean isVisibleModeEdit() {
		return visibleModeEdit;
	}
	public void setVisibleModeEdit(boolean visibleModeEdit) {
		this.visibleModeEdit = visibleModeEdit;
	}
	public boolean isChkSelAll() {
		return chkSelAll;
	}
	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}
	public boolean isVisibleModeView() {
		return visibleModeView;
	}
	public void setVisibleModeView(boolean visibleModeView) {
		this.visibleModeView = visibleModeView;
	}
	public boolean isVisibleBtnModeView() {
		return visibleBtnModeView;
	}
	public void setVisibleBtnModeView(boolean visibleBtnModeView) {
		this.visibleBtnModeView = visibleBtnModeView;
	}
	public boolean isReqContractNo() {
		return reqContractNo;
	}
	public void setReqContractNo(boolean reqContractNo) {
		this.reqContractNo = reqContractNo;
	}
	public String getTxtContent2() {
		return txtContent2;
	}
	public void setTxtContent2(String txtContent2) {
		this.txtContent2 = txtContent2;
	}	
	public List<SelectItem> getListFileSAP() {
		return listFileSAP;
	}
	public void setListFileSAP(List<SelectItem> listFileSAP) {
		this.listFileSAP = listFileSAP;
	}
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public void setListFileSEM(List<SelectItem> listFileSEM) {
		this.listFileSEM = listFileSEM;
	}
	public List<SelectItem> getListFileSEM() {
		return listFileSEM;
	}
	public void setSsoXmlList(List<SelectItem> ssoXmlList) {
		this.ssoXmlList = ssoXmlList;
	}
	public List<SelectItem> getSsoXmlList() {
		return ssoXmlList;
	}
	public void setSsoXmlSelected(boolean ssoXmlSelected) {
		this.ssoXmlSelected = ssoXmlSelected;
	}
	public boolean isSsoXmlSelected() {
		return ssoXmlSelected;
	}
	
}