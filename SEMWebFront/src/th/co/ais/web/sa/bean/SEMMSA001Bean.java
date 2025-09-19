package th.co.ais.web.sa.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.faces.model.SelectItem;

import org.richfaces.component.UITree;
import org.richfaces.model.TreeNode;

import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.domain.sa.MSA001LovSP;
import th.co.ais.domain.sa.SiteAcqSP;
import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.domain.sa.SiteContractStatusSP;
import th.co.ais.domain.si.Msi004SrchRentCondSP;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMSA001Bean extends AbstractBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// --- LOVs ---
	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> siteStatusList;
	private List<SelectItem> electricUseTypeList;
	private List<SelectItem> electricUseTypeList2;
	private List<SelectItem> processStatusNameList;
	private List<SelectItem> depositTypeList;
	private List<SelectItem> provinceList;
	private List<SelectItem> amphurList;
	private List<SelectItem> bgStatusList;
	private List<SelectItem> refDocTypeList;
	private List<SelectItem> paymentMethodList;
	private List<SelectItem> paymentTypeList;
	private List<SelectItem> monthList;
	
	private List<SelectItem> teamList;
	private List<SelectItem> memberList;
	
	private List<SelectItem> approveStatusList;
	//added by new 
	private List<SelectItem> approveStatusAList;
	private List<SelectItem> contractStatusList;
	
	private String menuGroupDisplay;
	private String menuGroupType;
	private String panelDisplay;
	private String pageForward;
	
	//for search criteria
	private SiteAppSP siteAppObjParam; 
	private MSA001LovSP lovObjParam;
	private SiteContractStatusSP siteCntrctSttsObjParam;
	
	
	private SiteAppSP siteAppObjTmp;
	
	// 
	private boolean chkSelAll;
	
	private boolean disabledChecked;
	private boolean disabledAssignBtn;
	private boolean disabledExceptBtn;
	private boolean disabledClrBtchBtn;
	private boolean disabledApprToLdrBtn;
	private boolean disabledBtnExport;
	
	private boolean renderDisplay01;
	private boolean renderDisplay02;
	private boolean renderDisplay03;
	
	private boolean renderedMsgAlert = false;
	private boolean renderedMsgSearch;
	private boolean renderedMsgSave;
	
	// optional
	private String paramMessageInfo;
	private String paramMode;
	private boolean displayBtn;
	private String batchNo;
	private SiteAcqSP siteAcqSP;
	
	//data table
	public List<WrapperBeanObject<SiteAppSP>> siteAppList;
	public List<WrapperBeanObject<SiteAppSP>> leadAssignList;
	public List<WrapperBeanObject<SiteAppSP>> waitingApprList;
	public List<WrapperBeanObject<SiteAppSP>> assignSummaryList;
	public List<WrapperBeanObject<SiteAppSP>> siteAppSPList;
	
	public List<WrapperBeanObject<SiteAppSP>> managerApprHdList;
	public List<WrapperBeanObject<SiteAppSP>> managerApprDtList;
	
	public List<WrapperBeanObject<SiteAppSP>> avpApprHdList;
	public List<WrapperBeanObject<SiteAppSP>> avpApprDtList;
	
	public List<WrapperBeanObject<SiteContractStatusSP>> coStatusList;
	
	public List<WrapperBeanObject<SiteAppSP>> nearestSiteList;
	
	//export excel
	private SiteAppSP siteAppSP;
	private String batchNoTmp;
	private String reasonOfNotProcess;
	
	//added by new 20150723
	private TreeNode rootNode = null;
	private List<MenuTreeSP> menuTreeList;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreeNewList;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreeReNewList;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreeWaitingList;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreeTerminateList;
	//added by NEW 20150834 for TreeSwapPage
	private String paramUrl;
	private String paramMenuGroup;
	
	//added by NEW 2016/03
	private String selectedTab;
	private String tabNo;
	private boolean renderColumnDiffNearSite = false;
	
	//added by NEW 2016/04/08  for popup nearestSite
	private BigDecimal maxRent;
	private BigDecimal minRent;
	private BigDecimal avgRent;
	
	//added by NEW 2016/04/20
	private List<SelectItem> managerNameList;
	
	//added BY OUM 2016/08/04
	private List<Msi004SrchRentCondSP> rentCondSPList;
	private boolean renderRentCond = false;
	private boolean renderRentCond2 = false;
	private String rentCondType;
	private List<Msi004SrchRentCondSP> rentCondNormList;
	private List<Msi004SrchRentCondSP> rentCondSpecList;
	
	@Override
	public int getRowPerPage() {
		return 10; //this.rowPerPage; // fixed by yut
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

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

	public List<SelectItem> getSiteStatusList() {
		return siteStatusList;
	}

	public void setSiteStatusList(List<SelectItem> siteStatusList) {
		this.siteStatusList = siteStatusList;
	}

	public List<SelectItem> getElectricUseTypeList() {
		return electricUseTypeList;
	}

	public void setElectricUseTypeList(List<SelectItem> electricUseTypeList) {
		this.electricUseTypeList = electricUseTypeList;
	}

	public List<SelectItem> getElectricUseTypeList2() {
		return electricUseTypeList2;
	}

	public void setElectricUseTypeList2(List<SelectItem> electricUseTypeList2) {
		this.electricUseTypeList2 = electricUseTypeList2;
	}

	public List<SelectItem> getProcessStatusNameList() {
		return processStatusNameList;
	}

	public void setProcessStatusNameList(List<SelectItem> processStatusNameList) {
		this.processStatusNameList = processStatusNameList;
	}

	public List<SelectItem> getDepositTypeList() {
		return depositTypeList;
	}

	public void setDepositTypeList(List<SelectItem> depositTypeList) {
		this.depositTypeList = depositTypeList;
	}

	public List<SelectItem> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<SelectItem> provinceList) {
		this.provinceList = provinceList;
	}

	public List<SelectItem> getAmphurList() {
		return amphurList;
	}

	public void setAmphurList(List<SelectItem> amphurList) {
		this.amphurList = amphurList;
	}

	public List<SelectItem> getBgStatusList() {
		return bgStatusList;
	}

	public void setBgStatusList(List<SelectItem> bgStatusList) {
		this.bgStatusList = bgStatusList;
	}

	public List<SelectItem> getRefDocTypeList() {
		return refDocTypeList;
	}

	public void setRefDocTypeList(List<SelectItem> refDocTypeList) {
		this.refDocTypeList = refDocTypeList;
	}

	public List<SelectItem> getPaymentMethodList() {
		return paymentMethodList;
	}

	public void setPaymentMethodList(List<SelectItem> paymentMethodList) {
		this.paymentMethodList = paymentMethodList;
	}

	public List<SelectItem> getPaymentTypeList() {
		return paymentTypeList;
	}

	public void setPaymentTypeList(List<SelectItem> paymentTypeList) {
		this.paymentTypeList = paymentTypeList;
	}

	public List<SelectItem> getMonthList() {
		return monthList;
	}

	public void setMonthList(List<SelectItem> monthList) {
		this.monthList = monthList;
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

	public List<SelectItem> getApproveStatusList() {
		return approveStatusList;
	}

	public void setApproveStatusList(List<SelectItem> approveStatusList) {
		this.approveStatusList = approveStatusList;
	}

	public List<SelectItem> getContractStatusList() {
		return contractStatusList;
	}

	public void setContractStatusList(List<SelectItem> contractStatusList) {
		this.contractStatusList = contractStatusList;
	}

	public String getMenuGroupDisplay() {
		return menuGroupDisplay;
	}

	public void setMenuGroupDisplay(String menuGroupDisplay) {
		this.menuGroupDisplay = menuGroupDisplay;
	}

	public String getPanelDisplay() {
		return panelDisplay;
	}

	public void setPanelDisplay(String panelDisplay) {
		this.panelDisplay = panelDisplay;
	}

	public String getPageForward() {
		return pageForward;
	}

	public void setPageForward(String pageForward) {
		this.pageForward = pageForward;
	}

	public List<WrapperBeanObject<SiteAppSP>> getSiteAppList() {
		return siteAppList;
	}

	public void setSiteAppList(List<WrapperBeanObject<SiteAppSP>> siteAppList) {
		this.siteAppList = siteAppList;
	}

	public List<WrapperBeanObject<SiteAppSP>> getLeadAssignList() {
		return leadAssignList;
	}

	public void setLeadAssignList(List<WrapperBeanObject<SiteAppSP>> leadAssignList) {
		this.leadAssignList = leadAssignList;
	}

	public List<WrapperBeanObject<SiteAppSP>> getWaitingApprList() {
		return waitingApprList;
	}

	public void setWaitingApprList(
			List<WrapperBeanObject<SiteAppSP>> waitingApprList) {
		this.waitingApprList = waitingApprList;
	}

	public List<WrapperBeanObject<SiteAppSP>> getAssignSummaryList() {
		return assignSummaryList;
	}

	public void setAssignSummaryList(
			List<WrapperBeanObject<SiteAppSP>> assignSummaryList) {
		this.assignSummaryList = assignSummaryList;
	}

	public List<WrapperBeanObject<SiteAppSP>> getManagerApprHdList() {
		return managerApprHdList;
	}

	public void setManagerApprHdList(
			List<WrapperBeanObject<SiteAppSP>> managerApprHdList) {
		this.managerApprHdList = managerApprHdList;
	}

	public List<WrapperBeanObject<SiteAppSP>> getManagerApprDtList() {
		return managerApprDtList;
	}

	public void setManagerApprDtList(
			List<WrapperBeanObject<SiteAppSP>> managerApprDtList) {
		this.managerApprDtList = managerApprDtList;
	}

	public List<WrapperBeanObject<SiteAppSP>> getAvpApprHdList() {
		return avpApprHdList;
	}

	public void setAvpApprHdList(List<WrapperBeanObject<SiteAppSP>> avpApprHdList) {
		this.avpApprHdList = avpApprHdList;
	}

	public List<WrapperBeanObject<SiteAppSP>> getAvpApprDtList() {
		return avpApprDtList;
	}

	public void setAvpApprDtList(List<WrapperBeanObject<SiteAppSP>> avpApprDtList) {
		this.avpApprDtList = avpApprDtList;
	}

	public List<WrapperBeanObject<SiteContractStatusSP>> getCoStatusList() {
		return coStatusList;
	}

	public void setCoStatusList(List<WrapperBeanObject<SiteContractStatusSP>> coStatusList) {
		this.coStatusList = coStatusList;
	}

	public List<WrapperBeanObject<SiteAppSP>> getNearestSiteList() {
		return nearestSiteList;
	}

	public void setNearestSiteList(
			List<WrapperBeanObject<SiteAppSP>> nearestSiteList) {
		this.nearestSiteList = nearestSiteList;
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

	public void setSiteCntrctSttsObjParam(SiteContractStatusSP siteCntrctSttsObjParam) {
		this.siteCntrctSttsObjParam = siteCntrctSttsObjParam;
	}

	public SiteAppSP getSiteAppObjTmp() {
		return siteAppObjTmp;
	}

	public void setSiteAppObjTmp(SiteAppSP siteAppObjTmp) {
		this.siteAppObjTmp = siteAppObjTmp;
	}

	public boolean isChkSelAll() {
		return chkSelAll;
	}

	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}

	public boolean isDisabledChecked() {
		return disabledChecked;
	}

	public void setDisabledChecked(boolean disabledChecked) {
		this.disabledChecked = disabledChecked;
	}

	public boolean isDisabledAssignBtn() {
		return disabledAssignBtn;
	}

	public void setDisabledAssignBtn(boolean disabledAssignBtn) {
		this.disabledAssignBtn = disabledAssignBtn;
	}

	public boolean isDisabledExceptBtn() {
		return disabledExceptBtn;
	}

	public void setDisabledExceptBtn(boolean disabledExceptBtn) {
		this.disabledExceptBtn = disabledExceptBtn;
	}

	public boolean isDisabledClrBtchBtn() {
		return disabledClrBtchBtn;
	}

	public void setDisabledClrBtchBtn(boolean disabledClrBtchBtn) {
		this.disabledClrBtchBtn = disabledClrBtchBtn;
	}

	public boolean isDisabledApprToLdrBtn() {
		return disabledApprToLdrBtn;
	}

	public void setDisabledApprToLdrBtn(boolean disabledApprToLdrBtn) {
		this.disabledApprToLdrBtn = disabledApprToLdrBtn;
	}

	public boolean isRenderDisplay01() {
		return renderDisplay01;
	}

	public void setRenderDisplay01(boolean renderDisplay01) {
		this.renderDisplay01 = renderDisplay01;
	}

	public boolean isRenderDisplay02() {
		return renderDisplay02;
	}

	public void setRenderDisplay02(boolean renderDisplay02) {
		this.renderDisplay02 = renderDisplay02;
	}

	public boolean isRenderDisplay03() {
		return renderDisplay03;
	}

	public void setRenderDisplay03(boolean renderDisplay03) {
		this.renderDisplay03 = renderDisplay03;
	}

	public boolean isRenderedMsgAlert() {
		return renderedMsgAlert;
	}

	public void setRenderedMsgAlert(boolean renderedMsgAlert) {
		this.renderedMsgAlert = renderedMsgAlert;
	}

	public boolean isRenderedMsgSearch() {
		return renderedMsgSearch;
	}

	public void setRenderedMsgSearch(boolean renderedMsgSearch) {
		this.renderedMsgSearch = renderedMsgSearch;
	}

	public boolean isRenderedMsgSave() {
		return renderedMsgSave;
	}

	public void setRenderedMsgSave(boolean renderedMsgSave) {
		this.renderedMsgSave = renderedMsgSave;
	}

	public String getParamMessageInfo() {
		return paramMessageInfo;
	}

	public void setParamMessageInfo(String paramMessageInfo) {
		this.paramMessageInfo = paramMessageInfo;
	}

	public String getParamMode() {
		return paramMode;
	}

	public void setParamMode(String paramMode) {
		this.paramMode = paramMode;
	}

	public SiteAppSP getSiteAppSP() {
		return siteAppSP;
	}

	public void setSiteAppSP(SiteAppSP siteAppSP) {
		this.siteAppSP = siteAppSP;
	}

	public String getBatchNoTmp() {
		return batchNoTmp;
	}

	public void setBatchNoTmp(String batchNoTmp) {
		this.batchNoTmp = batchNoTmp;
	}

	public boolean isDisplayBtn() {
		return displayBtn;
	}

	public void setDisplayBtn(boolean displayBtn) {
		this.displayBtn = displayBtn;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public SiteAcqSP getSiteAcqSP() {
		return siteAcqSP;
	}

	public void setSiteAcqSP(SiteAcqSP siteAcqSP) {
		this.siteAcqSP = siteAcqSP;
	}

	public List<WrapperBeanObject<SiteAppSP>> getSiteAppSPList() {
		return siteAppSPList;
	}

	public void setSiteAppSPList(List<WrapperBeanObject<SiteAppSP>> siteAppSPList) {
		this.siteAppSPList = siteAppSPList;
	}

	public boolean isDisabledBtnExport() {
		return disabledBtnExport;
	}

	public void setDisabledBtnExport(boolean disabledBtnExport) {
		this.disabledBtnExport = disabledBtnExport;
	}

	public String getReasonOfNotProcess() {
		return reasonOfNotProcess;
	}

	public void setReasonOfNotProcess(String reasonOfNotProcess) {
		this.reasonOfNotProcess = reasonOfNotProcess;
	}

	public List<SelectItem> getApproveStatusAList() {
		return approveStatusAList;
	}

	public void setApproveStatusAList(List<SelectItem> approveStatusAList) {
		this.approveStatusAList = approveStatusAList;
	}

	public TreeNode getRootNode() {
		return rootNode;
	}

	public void setRootNode(TreeNode rootNode) {
		this.rootNode = rootNode;
	}

	public String getParamUrl() {
		return paramUrl;
	}

	public void setParamUrl(String paramUrl) {
		this.paramUrl = paramUrl;
	}

	public String getParamMenuGroup() {
		return paramMenuGroup;
	}

	public void setParamMenuGroup(String paramMenuGroup) {
		this.paramMenuGroup = paramMenuGroup;
	}

	public boolean nodeExpandAll(UITree tree) {  
    	// can do something
    	return true;
    }

	public List<MenuTreeSP> getMenuTreeList() {
		return menuTreeList;
	}

	public void setMenuTreeList(List<MenuTreeSP> menuTreeList) {
		this.menuTreeList = menuTreeList;
	}

	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreeNewList() {
		return menuTreeNewList;
	}

	public void setMenuTreeNewList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreeNewList) {
		this.menuTreeNewList = menuTreeNewList;
	}

	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreeReNewList() {
		return menuTreeReNewList;
	}

	public void setMenuTreeReNewList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreeReNewList) {
		this.menuTreeReNewList = menuTreeReNewList;
	}

	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreeWaitingList() {
		return menuTreeWaitingList;
	}

	public void setMenuTreeWaitingList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreeWaitingList) {
		this.menuTreeWaitingList = menuTreeWaitingList;
	}

	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreeTerminateList() {
		return menuTreeTerminateList;
	}

	public void setMenuTreeTerminateList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreeTerminateList) {
		this.menuTreeTerminateList = menuTreeTerminateList;
	}

	public String getSelectedTab() {
		return selectedTab;
	}

	public void setSelectedTab(String selectedTab) {
		this.selectedTab = selectedTab;
	}

	public String getTabNo() {
		return tabNo;
	}

	public void setTabNo(String tabNo) {
		this.tabNo = tabNo;
	}

	public boolean isRenderColumnDiffNearSite() {
		return renderColumnDiffNearSite;
	}

	public void setRenderColumnDiffNearSite(boolean renderColumnDiffNearSite) {
		this.renderColumnDiffNearSite = renderColumnDiffNearSite;
	}

	public BigDecimal getMaxRent() {
		return maxRent;
	}

	public void setMaxRent(BigDecimal maxRent) {
		this.maxRent = maxRent;
	}

	public BigDecimal getMinRent() {
		return minRent;
	}

	public void setMinRent(BigDecimal minRent) {
		this.minRent = minRent;
	}

	public BigDecimal getAvgRent() {
		return avgRent;
	}

	public void setAvgRent(BigDecimal avgRent) {
		this.avgRent = avgRent;
	}

	public List<SelectItem> getManagerNameList() {
		return managerNameList;
	}

	public void setManagerNameList(List<SelectItem> managerNameList) {
		this.managerNameList = managerNameList;
	}

	public List<Msi004SrchRentCondSP> getRentCondSPList() {
		return rentCondSPList;
	}

	public void setRentCondSPList(List<Msi004SrchRentCondSP> rentCondSPList) {
		this.rentCondSPList = rentCondSPList;
	}

	public boolean isRenderRentCond() {
		return renderRentCond;
	}

	public void setRenderRentCond(boolean renderRentCond) {
		this.renderRentCond = renderRentCond;
	}

	public boolean isRenderRentCond2() {
		return renderRentCond2;
	}

	public void setRenderRentCond2(boolean renderRentCond2) {
		this.renderRentCond2 = renderRentCond2;
	}

	public String getRentCondType() {
		return rentCondType;
	}

	public void setRentCondType(String rentCondType) {
		this.rentCondType = rentCondType;
	}

	public List<Msi004SrchRentCondSP> getRentCondNormList() {
		return rentCondNormList;
	}

	public void setRentCondNormList(List<Msi004SrchRentCondSP> rentCondNormList) {
		this.rentCondNormList = rentCondNormList;
	}

	public List<Msi004SrchRentCondSP> getRentCondSpecList() {
		return rentCondSpecList;
	}

	public void setRentCondSpecList(List<Msi004SrchRentCondSP> rentCondSpecList) {
		this.rentCondSpecList = rentCondSpecList;
	}

	public String getMenuGroupType() {
		return menuGroupType;
	}

	public void setMenuGroupType(String menuGroupType) {
		this.menuGroupType = menuGroupType;
	}
	
}
