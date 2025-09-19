package th.co.ais.web.si.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.rt.MrtGetRunningNo;
import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.domain.si.LegalSiteAppSP;
import th.co.ais.domain.si.PopupContractSearchSP;
import th.co.ais.domain.si.SiteApprove;
import th.co.ais.domain.si.SiteApproveDisplaySP;
import th.co.ais.domain.si.SiteApproveMapLoc;
import th.co.ais.domain.si.SiteApproveMapLocSP;
import th.co.ais.domain.si.SiteLocationSP;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMSI001Bean extends AbstractBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1419068899710599385L;

	// data dropdown list
	private List<SelectItem> companyList;
	private List<SelectItem> reqTypeList;
	private List<SelectItem> siteApproveStatusList;
	private List<SelectItem> regionList;
	private List<SelectItem> reqDocTypeList;
	private List<SelectItem> reqOfficerList;
	private List<SelectItem> zoneList;

	// page semmsi001-1
	private boolean chkSelAll;
	private SiteApproveDisplaySP searchCriteria;
	private List<WrapperBeanObject<SiteApproveDisplaySP>> siteApproveList;
	
	private String siteApproveIdDel;

	// page semmsi001-2
	private SiteApprove siteSP;
	private String otherReqOfficer;
	private SiteLocationSP siteMapLoc;
	private SiteApproveMapLoc tempSiteMapLoc;
	private List<SiteApproveMapLocSP> siteMapLocList;
	
	// popup contract
	private PopupContractSearchSP popupContractCriteria;
	private List<PopupContractSearchSP> contractList;

	// popup site location
	private SiteLocationSP siteLocationCriteria;
	private List<SiteLocationSP> siteLocationList;

	private String siteApproveIdStr;
	private String firstSiteMapLocId;
	
	private String pageStatus;
	private String txtContent2;
	private String txtAlert;
	private String cssTxtAlert;
	private String txtAlertSiteLoc;
	private String cssTxtAlertSiteLoc;
	private boolean visibleModeEdit;
	private boolean visibleModeView;
	private boolean visibleBtnModeView;
	private boolean visibleApproveStatus;
	private boolean reqContractNo;
	private boolean disBtnExport;
	private boolean disTxtReqOfficer;
	private String modeDelPopup;
	
	private boolean displayShowExcel;
	private boolean renderDate = false;
	private String tmpBatch;
	private List<MrtGetRunningNo> mrtGetRunningNoList;
	private MrtGetRunningNo mrtGetRunningNo;
	private boolean validateExportFlag = false;
	private boolean btnExportFlag = false;
	private String tmpChkBatch;
	private boolean dupBatchNo = false;

	public String getModeDelPopup() {
		return modeDelPopup;
	}
	public void setModeDelPopup(String modeDelPopup) {
		this.modeDelPopup = modeDelPopup;
	}
	//flag check export
	private Boolean displayBtn;
	
	// 20110120 tmpDocNo mode edit
	private String tmpDocNo;
	
	public String getOtherReqOfficer() {
		return otherReqOfficer;
	}
	public void setOtherReqOfficer(String otherReqOfficer) {
		this.otherReqOfficer = otherReqOfficer;
	}
	public boolean isDisTxtReqOfficer() {
		return disTxtReqOfficer;
	}
	public void setDisTxtReqOfficer(boolean disTxtReqOfficer) {
		this.disTxtReqOfficer = disTxtReqOfficer;
	}
	public boolean isVisibleApproveStatus() {
		return visibleApproveStatus;
	}
	public void setVisibleApproveStatus(boolean visibleApproveStatus) {
		this.visibleApproveStatus = visibleApproveStatus;
	}
	public String getTmpDocNo() {
		return tmpDocNo;
	}
	public void setTmpDocNo(String tmpDocNo) {
		this.tmpDocNo = tmpDocNo;
	}
	public List<SelectItem> getReqOfficerList() {
		return reqOfficerList;
	}
	public void setReqOfficerList(List<SelectItem> reqOfficerList) {
		this.reqOfficerList = reqOfficerList;
	}
	public String getFirstSiteMapLocId() {
		return firstSiteMapLocId;
	}
	public void setFirstSiteMapLocId(String firstSiteMapLocId) {
		this.firstSiteMapLocId = firstSiteMapLocId;
	}
	public String getSiteApproveIdDel() {
		return siteApproveIdDel;
	}
	public void setSiteApproveIdDel(String siteApproveIdDel) {
		this.siteApproveIdDel = siteApproveIdDel;
	}
	public String getSiteApproveIdStr() {
		return siteApproveIdStr;
	}
	public void setSiteApproveIdStr(String siteApproveIdStr) {
		this.siteApproveIdStr = siteApproveIdStr;
	}
	public boolean isDisBtnExport() {
		return disBtnExport;
	}
	public void setDisBtnExport(boolean disBtnExport) {
		this.disBtnExport = disBtnExport;
	}
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
	public List<WrapperBeanObject<SiteApproveDisplaySP>> getSiteApproveList() {
		return siteApproveList;
	}
	public void setSiteApproveList(List<WrapperBeanObject<SiteApproveDisplaySP>> siteApproveList) {
		this.siteApproveList = siteApproveList;
	}
	public List<SelectItem> getReqDocTypeList() {
		return reqDocTypeList;
	}
	public void setReqDocTypeList(List<SelectItem> reqDocTypeList) {
		this.reqDocTypeList = reqDocTypeList;
	}
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
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
	public void setDisplayBtn(Boolean displayBtn) {
		this.displayBtn = displayBtn;
	}
	public Boolean getDisplayBtn() {
		return displayBtn;
	}
	public boolean isDisplayShowExcel() {
		return displayShowExcel;
	}
	public void setDisplayShowExcel(boolean displayShowExcel) {
		this.displayShowExcel = displayShowExcel;
	}
	public boolean isRenderDate() {
		return renderDate;
	}
	public void setRenderDate(boolean renderDate) {
		this.renderDate = renderDate;
	}
	public String getTmpBatch() {
		return tmpBatch;
	}
	public void setTmpBatch(String tmpBatch) {
		this.tmpBatch = tmpBatch;
	}
	public List<MrtGetRunningNo> getMrtGetRunningNoList() {
		return mrtGetRunningNoList;
	}
	public void setMrtGetRunningNoList(List<MrtGetRunningNo> mrtGetRunningNoList) {
		this.mrtGetRunningNoList = mrtGetRunningNoList;
	}
	public MrtGetRunningNo getMrtGetRunningNo() {
		return mrtGetRunningNo;
	}
	public void setMrtGetRunningNo(MrtGetRunningNo mrtGetRunningNo) {
		this.mrtGetRunningNo = mrtGetRunningNo;
	}
	public boolean isValidateExportFlag() {
		return validateExportFlag;
	}
	public void setValidateExportFlag(boolean validateExportFlag) {
		this.validateExportFlag = validateExportFlag;
	}
	public boolean isBtnExportFlag() {
		return btnExportFlag;
	}
	public void setBtnExportFlag(boolean btnExportFlag) {
		this.btnExportFlag = btnExportFlag;
	}
	public String getTmpChkBatch() {
		return tmpChkBatch;
	}
	public void setTmpChkBatch(String tmpChkBatch) {
		this.tmpChkBatch = tmpChkBatch;
	}
	public boolean isDupBatchNo() {
		return dupBatchNo;
	}
	public void setDupBatchNo(boolean dupBatchNo) {
		this.dupBatchNo = dupBatchNo;
	}
	public List<SelectItem> getZoneList() {
		return zoneList;
	}
	public void setZoneList(List<SelectItem> zoneList) {
		this.zoneList = zoneList;
	}
	
}
