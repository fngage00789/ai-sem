package th.co.ais.web.sa.bean;

import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.sa.MSA001LovSP;
import th.co.ais.domain.sa.Msa003ReportParam;
import th.co.ais.domain.sa.SiteAcqSP;
import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.domain.sa.SiteContractStatusSP;
import th.co.ais.domain.si.SiteInfoSP;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.report.AbstractReportBean;

public class SEMMSA003Bean extends AbstractReportBean {

	public SEMMSA003Bean() {
		super(ServiceConstants.TYPE_DOC);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -145008350786374521L;
	
	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> reqTypeList;
	private List<SelectItem> docStatusList;
	private List<SelectItem> siteTypeList;
	private List<SelectItem> provinceList;
	private List<SelectItem> teamList;
	private List<SelectItem> memberList;
	
	private boolean disabledBtnExport;
	private boolean disabledBtnPopupNew;
	private boolean disabledBtnClearBatch;
	private boolean disabledBtnSendToApprove;
	private boolean disabledBtnReassign;
	private boolean chkSelAll;
	private boolean expireStatus;
	private boolean pendingStatus;
	private boolean chkCurrentFlag;
	private boolean chkNoExpireFlag;
	private boolean showReport;
	private boolean displayShowExcel;
	private boolean displayShowPopup;
	private boolean redirectFlag;
	private boolean disabledAssignBtn;
	private boolean renderedMsgAlert;

	//flag check export
	private Boolean displayBtn;
	
	private String rowId;
	private String popupSelectMode;
	private String popupMenuGroup;
	private String batchNoTmp;
	private String docNo;
	private String contractNo;
	private String docTypeText;
	private String updateDT;

	private List<WrapperBeanObject<SiteAcqSP>> siteAcqSPList;
	private List<WrapperBeanObject<SiteAppSP>> nearestSiteAcqSPList;
	private SiteAcqSP siteAcqSP;
	private SiteAcqSP siteAcqSelect;
	public List<WrapperBeanObject<SiteAppSP>> siteAppList;
	
	private SiteAppSP siteAppSP;
	
	private List<WrapperBeanObject<Msa003ReportParam>> msa003ReportParamList;
	private Msa003ReportParam msa003ReportParam;
	private String batchNo;
	
	//for search criteria
	private SiteAppSP siteAppObjParam; 
	private MSA001LovSP lovObjParam;
	private SiteContractStatusSP siteCntrctSttsObjParam; 
	
	//Render message form Popup
	private boolean renderedMsgFormPopup = true;
	
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

	public List<SelectItem> getReqTypeList() {
		return reqTypeList;
	}

	public void setReqTypeList(List<SelectItem> reqTypeList) {
		this.reqTypeList = reqTypeList;
	}
	
	public List<SelectItem> getDocStatusList() {
		return docStatusList;
	}

	public void setDocStatusList(List<SelectItem> docStatusList) {
		this.docStatusList = docStatusList;
	}

	public List<SelectItem> getSiteTypeList() {
		return siteTypeList;
	}

	public void setSiteTypeList(List<SelectItem> siteTypeList) {
		this.siteTypeList = siteTypeList;
	}

	public List<SelectItem> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<SelectItem> provinceList) {
		this.provinceList = provinceList;
	}

	public boolean isDisabledBtnExport() {
		return disabledBtnExport;
	}

	public void setDisabledBtnExport(boolean disabledBtnExport) {
		this.disabledBtnExport = disabledBtnExport;
	}

	public List<WrapperBeanObject<SiteAcqSP>> getSiteAcqSPList() {
		return siteAcqSPList;
	}

	public void setSiteAcqSPList(List<WrapperBeanObject<SiteAcqSP>> siteAcqSPList) {
		this.siteAcqSPList = siteAcqSPList;
	}

	public boolean isChkSelAll() {
		return chkSelAll;
	}

	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}

	public SiteAcqSP getSiteAcqSP() {
		return siteAcqSP;
	}

	public void setSiteAcqSP(SiteAcqSP siteAcqSP) {
		this.siteAcqSP = siteAcqSP;
	}

	public boolean isExpireStatus() {
		return expireStatus;
	}

	public void setExpireStatus(boolean expireStatus) {
		this.expireStatus = expireStatus;
	}

	public boolean isPendingStatus() {
		return pendingStatus;
	}

	public boolean isChkCurrentFlag() {
		return chkCurrentFlag;
	}

	public void setChkCurrentFlag(boolean chkCurrentFlag) {
		this.chkCurrentFlag = chkCurrentFlag;
	}

	public boolean isChkNoExpireFlag() {
		return chkNoExpireFlag;
	}

	public void setChkNoExpireFlag(boolean chkNoExpireFlag) {
		this.chkNoExpireFlag = chkNoExpireFlag;
	}

	public void setPendingStatus(boolean pendingStatus) {
		this.pendingStatus = pendingStatus;
	}

	public List<WrapperBeanObject<Msa003ReportParam>> getMsa003ReportParamList() {
		return msa003ReportParamList;
	}

	public void setMsa003ReportParamList(
			List<WrapperBeanObject<Msa003ReportParam>> msa003ReportParamList) {
		this.msa003ReportParamList = msa003ReportParamList;
	}

	public Msa003ReportParam getMsa003ReportParam() {
		return msa003ReportParam;
	}

	public void setMsa003ReportParam(Msa003ReportParam msa003ReportParam) {
		this.msa003ReportParam = msa003ReportParam;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public boolean isShowReport() {
		return showReport;
	}

	public void setShowReport(boolean showReport) {
		this.showReport = showReport;
	}

	public boolean isDisplayShowExcel() {
		return displayShowExcel;
	}

	public void setDisplayShowExcel(boolean displayShowExcel) {
		this.displayShowExcel = displayShowExcel;
	}

	public SiteAcqSP getSiteAcqSelect() {
		return siteAcqSelect;
	}

	public void setSiteAcqSelect(SiteAcqSP siteAcqSelect) {
		this.siteAcqSelect = siteAcqSelect;
	}

	public boolean isDisplayShowPopup() {
		return displayShowPopup;
	}

	public void setDisplayShowPopup(boolean displayShowPopup) {
		this.displayShowPopup = displayShowPopup;
	}

	public String getPopupSelectMode() {
		return popupSelectMode;
	}

	public void setPopupSelectMode(String popupSelectMode) {
		this.popupSelectMode = popupSelectMode;
	}

	public SiteAppSP getSiteAppSP() {
		return siteAppSP;
	}

	public void setSiteAppSP(SiteAppSP siteAppSP) {
		this.siteAppSP = siteAppSP;
	}

	public boolean isRenderedMsgFormPopup() {
		return renderedMsgFormPopup;
	}

	public void setRenderedMsgFormPopup(boolean renderedMsgFormPopup) {
		this.renderedMsgFormPopup = renderedMsgFormPopup;
	}

	public Boolean getDisplayBtn() {
		return displayBtn;
	}

	public void setDisplayBtn(Boolean displayBtn) {
		this.displayBtn = displayBtn;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public boolean isRedirectFlag() {
		return redirectFlag;
	}

	public void setRedirectFlag(boolean redirectFlag) {
		this.redirectFlag = redirectFlag;
	}

	public boolean isDisabledBtnPopupNew() {
		return disabledBtnPopupNew;
	}

	public void setDisabledBtnPopupNew(boolean disabledBtnPopupNew) {
		this.disabledBtnPopupNew = disabledBtnPopupNew;
	}

	public boolean isDisabledBtnClearBatch() {
		return disabledBtnClearBatch;
	}

	public void setDisabledBtnClearBatch(boolean disabledBtnClearBatch) {
		this.disabledBtnClearBatch = disabledBtnClearBatch;
	}

	public boolean isDisabledBtnSendToApprove() {
		return disabledBtnSendToApprove;
	}

	public void setDisabledBtnSendToApprove(boolean disabledBtnSendToApprove) {
		this.disabledBtnSendToApprove = disabledBtnSendToApprove;
	}

	public String getBatchNoTmp() {
		return batchNoTmp;
	}

	public void setBatchNoTmp(String batchNoTmp) {
		this.batchNoTmp = batchNoTmp;
	}

	public List<WrapperBeanObject<SiteAppSP>> getNearestSiteAcqSPList() {
		return nearestSiteAcqSPList;
	}

	public void setNearestSiteAcqSPList(
			List<WrapperBeanObject<SiteAppSP>> nearestSiteAcqSPList) {
		this.nearestSiteAcqSPList = nearestSiteAcqSPList;
	}

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getDocTypeText() {
		return docTypeText;
	}

	public void setDocTypeText(String docTypeText) {
		this.docTypeText = docTypeText;
	}

	public String getUpdateDT() {
		return updateDT;
	}

	public void setUpdateDT(String updateDT) {
		this.updateDT = updateDT;
	}

	public List<SelectItem> getTeamList() {
		return teamList;
	}

	public void setTeamList(List<SelectItem> teamList) {
		this.teamList = teamList;
	}

	public List<SelectItem> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<SelectItem> memberList) {
		this.memberList = memberList;
	}

	public SiteAppSP getSiteAppObjParam() {
		return siteAppObjParam;
	}

	public void setSiteAppObjParam(SiteAppSP siteAppObjParam) {
		this.siteAppObjParam = siteAppObjParam;
	}

	public MSA001LovSP getLovObjParam() {
		return lovObjParam;
	}

	public void setLovObjParam(MSA001LovSP lovObjParam) {
		this.lovObjParam = lovObjParam;
	}

	public SiteContractStatusSP getSiteCntrctSttsObjParam() {
		return siteCntrctSttsObjParam;
	}

	public void setSiteCntrctSttsObjParam(
			SiteContractStatusSP siteCntrctSttsObjParam) {
		this.siteCntrctSttsObjParam = siteCntrctSttsObjParam;
	}

	public boolean isDisabledAssignBtn() {
		return disabledAssignBtn;
	}

	public void setDisabledAssignBtn(boolean disabledAssignBtn) {
		this.disabledAssignBtn = disabledAssignBtn;
	}

	public List<WrapperBeanObject<SiteAppSP>> getSiteAppList() {
		return siteAppList;
	}

	public void setSiteAppList(List<WrapperBeanObject<SiteAppSP>> siteAppList) {
		this.siteAppList = siteAppList;
	}

	public boolean isRenderedMsgAlert() {
		return renderedMsgAlert;
	}

	public void setRenderedMsgAlert(boolean renderedMsgAlert) {
		this.renderedMsgAlert = renderedMsgAlert;
	}

	public boolean isDisabledBtnReassign() {
		return disabledBtnReassign;
	}

	public void setDisabledBtnReassign(boolean disabledBtnReassign) {
		this.disabledBtnReassign = disabledBtnReassign;
	}

	public String getPopupMenuGroup() {
		return popupMenuGroup;
	}

	public void setPopupMenuGroup(String popupMenuGroup) {
		this.popupMenuGroup = popupMenuGroup;
	}

	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;

	}

}
