package th.co.ais.web.si.bean;

import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import org.richfaces.model.TreeNode;

import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.mm.ItemResultSP;
import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.domain.si.Construct;
import th.co.ais.domain.si.Contract;
import th.co.ais.domain.si.Deposit;
import th.co.ais.domain.si.Electric;
import th.co.ais.domain.si.Insurance;
import th.co.ais.domain.si.LegalSiteAppSP;
import th.co.ais.domain.si.Lessor;
import th.co.ais.domain.si.Msi004SrchExportSP;
import th.co.ais.domain.si.PropertyTax;
import th.co.ais.domain.si.Rent;
import th.co.ais.domain.si.RentCond;
import th.co.ais.domain.si.SiteInfo;
import th.co.ais.domain.si.SiteInfoMapLocSP;
import th.co.ais.domain.si.SiteInfoSP;
import th.co.ais.domain.si.SiteLocationSP;
import th.co.ais.domain.si.SubRent;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.TreeUtilBean;
import th.co.ais.web.report.AbstractReportBean;

public class SEMMSI004Bean extends AbstractReportBean {

	private static final long serialVersionUID = -8820176564897699248L;

	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> reqTypeList;
	private List<SelectItem> siteTypeList;
	private List<SelectItem> siteInfoStatusList;
	private List<SelectItem> legalApproveStatusList;
	private List<SelectItem> siteStatusList;
	private List<SelectItem> provinceList;
	private List<SelectItem> amphurList;
	private SiteInfoSP siteInfoSP;
	private SiteInfoSP siteInfoData;
	private TreeUtilBean treeUtilBean;
	private TreeNode rootNode = null;
	private List<WrapperBeanObject<SiteInfoSP>> siteInfoSPList;
	private boolean expireStatus;
	private boolean pendingStatus;
	private SiteInfo siteInfo;
	private Contract siteContract;
	private SubRent siteSubRent;
	private List<SubRent> siteSubRentList;
	private Deposit siteDeposit;
	private List<Deposit> siteDepositList;
	private RentCond siteRentCond;
	private List<RentCond> siteRentCondList;
	private Lessor siteLessor;
	private List<Lessor> siteLessorList;
	private Insurance siteInsurance;
	private Electric siteElectric;
	private PropertyTax sitePropertyTax;
	private Rent siteRent;
	private Construct siteConstruct;
	private String pageStatus;
	private List<String> itemList;
	private String confirmDeleteMsg;
	private String tabNo;
	private String tabHeader;
	private String reqTypeParam;
	private String siteTypeParam;
	private String companyParam;
	private String regionParam;
	private String docApproveTypeParam;
	private String docApproveIdParam;
	private List<SiteInfoMapLocSP> siteInfoMapLocSPList;
	private String assignContractNoParam;
	private boolean renderBtnSave;
	private String siteInfoId;
	private boolean renderTab1;
	private boolean renderTab2;
	private boolean renderTab3;
	private boolean renderTab4;
	private boolean renderTab5;
	private boolean renderTab6;
	private boolean renderTab7;
	private String createBy;
	private Date createDate;
	private String updateBy;
	private Date updateDate;
	private boolean renderPanelLog;
	private boolean disabledModeView;
	private boolean renderedModeView;
	private boolean renderedBtnBackSiteInfo;
	private boolean renderedBtnBackContract;
	private boolean renderedBtnBackInternalContract;
	private String mode;
	private String page;
	private boolean chkSelAll;
	private boolean disabledBtnExport;
	private SiteLocationSP siteLocationCriteria;
	private List<SiteLocationSP> siteLocationList;
	private List<Msi004SrchExportSP> exportList;
	private boolean disabledEffDate;
	private boolean renderedBtnCopySiteInfo;
	private boolean disabledOldContractNo;
	private boolean disabledSiteType;
	private boolean chkNoRent;
	private boolean chkNoDeposit;
	private boolean disabledLink;
	private String selectedTab;
	private String tempTabNo;
	private boolean valueChange;
	private boolean chkCurrentFlag;
	private boolean renderedBtnApprove;
	private boolean disabledBtnApprove;
	private boolean renderedBtnCancelApprove;
	private boolean disabledBtnCancelApprove;
	private boolean chkNoExpireFlag = false;
	private boolean chkNoExpireFlagSP = false;
	private boolean showMessageSave;
	private String comfirmSiteInfo;
	private boolean popupConfirmSiteInfo = true;
	private SiteInfoSP tmpSiteInfoSP;
	private boolean renderedBtnBackContractSubRent;
	private List<SelectItem> groupRentList;
	
	
	// added by.. YUT
	private String panelDisplay;
	private String menuGroupDisplay;
	private MenuTreeSP menuTreeObjParam;
	public List<WrapperBeanObject<LegalSiteAppSP>> siteInfoToDoList;
	private boolean disabledBtnGenDummy;
	private String dummyContractId;
	
	//added by NEW 22/03/2015
	private boolean renderedOnToDoList = false;
	private boolean disabledTransfer = true;
	private SiteAppSP siteAppObjParam;
	private String siteInfoIdTemp;
	private boolean disabledExpDate;
	
	//added by NEW 20151030
	public boolean treeMacroFlag = false;
	public String headerTreeMacro;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreeMacroList;
	
	public boolean treePicoFlag = false;
	public String headerTreePico;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreePicoList;
	public boolean fix5Percent;
	
	//added by NEW 2081/10/12
	private ItemResultSP retResultObj;
	private boolean renderedMsgPopup;
	private String rentEditFlag;
	
	// added 2023/03/03 
	private boolean disabledExpenseDesc;
	
	private List<SelectItem> todoReqTypeList;
	
	public SEMMSI004Bean() {
		super(ServiceConstants.TYPE_XLS);
	}

	public boolean isShowMessageSave() {
		return showMessageSave;
	}

	public void setShowMessageSave(boolean showMessageSave) {
		this.showMessageSave = showMessageSave;
	}

	public boolean isRenderedBtnCancelApprove() {
		return renderedBtnCancelApprove;
	}

	public void setRenderedBtnCancelApprove(boolean renderedBtnCancelApprove) {
		this.renderedBtnCancelApprove = renderedBtnCancelApprove;
	}

	public boolean isDisabledBtnCancelApprove() {
		return disabledBtnCancelApprove;
	}

	public void setDisabledBtnCancelApprove(boolean disabledBtnCancelApprove) {
		this.disabledBtnCancelApprove = disabledBtnCancelApprove;
	}

	public boolean isChkNoExpireFlag() {
		return chkNoExpireFlag;
	}

	public void setChkNoExpireFlag(boolean chkNoExpireFlag) {
		this.chkNoExpireFlag = chkNoExpireFlag;
	}

	public boolean isDisabledBtnApprove() {
		return disabledBtnApprove;
	}

	public void setDisabledBtnApprove(boolean disabledBtnApprove) {
		this.disabledBtnApprove = disabledBtnApprove;
	}

	public boolean isRenderedBtnApprove() {
		return renderedBtnApprove;
	}

	public void setRenderedBtnApprove(boolean renderedBtnApprove) {
		this.renderedBtnApprove = renderedBtnApprove;
	}

	public boolean isChkCurrentFlag() {
		return chkCurrentFlag;
	}

	public void setChkCurrentFlag(boolean chkCurrentFlag) {
		this.chkCurrentFlag = chkCurrentFlag;
	}

	public boolean isValueChange() {
		return valueChange;
	}

	public void setValueChange(boolean valueChange) {
		this.valueChange = valueChange;
	}

	public String getTempTabNo() {
		return tempTabNo;
	}

	public void setTempTabNo(String tempTabNo) {
		this.tempTabNo = tempTabNo;
	}

	public String getSelectedTab() {
		return selectedTab;
	}

	public void setSelectedTab(String selectedTab) {
		this.selectedTab = selectedTab;
	}

	public boolean isPendingStatus() {
		return pendingStatus;
	}

	public void setPendingStatus(boolean pendingStatus) {
		this.pendingStatus = pendingStatus;
	}

	public boolean isChkNoRent() {
		return chkNoRent;
	}

	public void setChkNoRent(boolean chkNoRent) {
		this.chkNoRent = chkNoRent;
	}

	public boolean isChkNoDeposit() {
		return chkNoDeposit;
	}

	public void setChkNoDeposit(boolean chkNoDeposit) {
		this.chkNoDeposit = chkNoDeposit;
	}

	public boolean isDisabledOldContractNo() {
		return disabledOldContractNo;
	}

	public void setDisabledOldContractNo(boolean disabledOldContractNo) {
		this.disabledOldContractNo = disabledOldContractNo;
	}

	public boolean isDisabledSiteType() {
		return disabledSiteType;
	}

	public void setDisabledSiteType(boolean disabledSiteType) {
		this.disabledSiteType = disabledSiteType;
	}

	public boolean isRenderedBtnCopySiteInfo() {
		return renderedBtnCopySiteInfo;
	}

	public void setRenderedBtnCopySiteInfo(boolean renderedBtnCopySiteInfo) {
		this.renderedBtnCopySiteInfo = renderedBtnCopySiteInfo;
	}

	public boolean isDisabledEffDate() {
		return disabledEffDate;
	}

	public void setDisabledEffDate(boolean disabledEffDate) {
		this.disabledEffDate = disabledEffDate;
	}

	public List<Msi004SrchExportSP> getExportList() {
		return exportList;
	}

	public void setExportList(List<Msi004SrchExportSP> exportList) {
		this.exportList = exportList;
	}

	public boolean isDisabledBtnExport() {
		return disabledBtnExport;
	}

	public void setDisabledBtnExport(boolean disabledBtnExport) {
		this.disabledBtnExport = disabledBtnExport;
	}

	public boolean isChkSelAll() {
		return chkSelAll;
	}

	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public boolean isRenderedBtnBackSiteInfo() {
		return renderedBtnBackSiteInfo;
	}

	public void setRenderedBtnBackSiteInfo(boolean renderedBtnBackSiteInfo) {
		this.renderedBtnBackSiteInfo = renderedBtnBackSiteInfo;
	}

	public boolean isRenderedBtnBackContract() {
		return renderedBtnBackContract;
	}

	public void setRenderedBtnBackContract(boolean renderedBtnBackContract) {
		this.renderedBtnBackContract = renderedBtnBackContract;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public boolean isRenderedModeView() {
		return renderedModeView;
	}

	public void setRenderedModeView(boolean renderedModeView) {
		this.renderedModeView = renderedModeView;
	}

	public boolean isDisabledModeView() {
		return disabledModeView;
	}

	public void setDisabledModeView(boolean disabledModeView) {
		this.disabledModeView = disabledModeView;
	}

	public String getReqTypeParam() {
		return reqTypeParam;
	}

	public void setReqTypeParam(String reqTypeParam) {
		this.reqTypeParam = reqTypeParam;
	}

	public String getSiteTypeParam() {
		return siteTypeParam;
	}

	public void setSiteTypeParam(String siteTypeParam) {
		this.siteTypeParam = siteTypeParam;
	}

	public boolean isRenderPanelLog() {
		return renderPanelLog;
	}

	public void setRenderPanelLog(boolean renderPanelLog) {
		this.renderPanelLog = renderPanelLog;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public boolean isRenderTab1() {
		return renderTab1;
	}

	public void setRenderTab1(boolean renderTab1) {
		this.renderTab1 = renderTab1;
	}

	public boolean isRenderTab2() {
		return renderTab2;
	}

	public void setRenderTab2(boolean renderTab2) {
		this.renderTab2 = renderTab2;
	}

	public boolean isRenderTab3() {
		return renderTab3;
	}

	public void setRenderTab3(boolean renderTab3) {
		this.renderTab3 = renderTab3;
	}

	public boolean isRenderTab4() {
		return renderTab4;
	}

	public void setRenderTab4(boolean renderTab4) {
		this.renderTab4 = renderTab4;
	}

	public boolean isRenderTab5() {
		return renderTab5;
	}

	public void setRenderTab5(boolean renderTab5) {
		this.renderTab5 = renderTab5;
	}

	public boolean isRenderTab6() {
		return renderTab6;
	}

	public void setRenderTab6(boolean renderTab6) {
		this.renderTab6 = renderTab6;
	}

	public boolean isRenderTab7() {
		return renderTab7;
	}

	public void setRenderTab7(boolean renderTab7) {
		this.renderTab7 = renderTab7;
	}

	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	public boolean isRenderBtnSave() {
		return renderBtnSave;
	}

	public void setRenderBtnSave(boolean renderBtnSave) {
		this.renderBtnSave = renderBtnSave;
	}

	public String getAssignContractNoParam() {
		return assignContractNoParam;
	}

	public void setAssignContractNoParam(String assignContractNoParam) {
		this.assignContractNoParam = assignContractNoParam;
	}

	public List<SiteInfoMapLocSP> getSiteInfoMapLocSPList() {
		return siteInfoMapLocSPList;
	}

	public void setSiteInfoMapLocSPList(
			List<SiteInfoMapLocSP> siteInfoMapLocSPList) {
		this.siteInfoMapLocSPList = siteInfoMapLocSPList;
	}

	public Contract getSiteContract() {
		return siteContract;
	}

	public void setSiteContract(Contract siteContract) {
		this.siteContract = siteContract;
	}

	public Lessor getSiteLessor() {
		return siteLessor;
	}

	public void setSiteLessor(Lessor siteLessor) {
		this.siteLessor = siteLessor;
	}

	public String getCompanyParam() {
		return companyParam;
	}

	public void setCompanyParam(String companyParam) {
		this.companyParam = companyParam;
	}

	public String getRegionParam() {
		return regionParam;
	}

	public void setRegionParam(String regionParam) {
		this.regionParam = regionParam;
	}

	public String getDocApproveTypeParam() {
		return docApproveTypeParam;
	}

	public void setDocApproveTypeParam(String docApproveTypeParam) {
		this.docApproveTypeParam = docApproveTypeParam;
	}

	public String getDocApproveIdParam() {
		return docApproveIdParam;
	}

	public void setDocApproveIdParam(String docApproveIdParam) {
		this.docApproveIdParam = docApproveIdParam;
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

	public List<SelectItem> getReqTypeList() {
		return reqTypeList;
	}

	public void setReqTypeList(List<SelectItem> reqTypeList) {
		this.reqTypeList = reqTypeList;
	}

	public List<SelectItem> getSiteTypeList() {
		return siteTypeList;
	}

	public void setSiteTypeList(List<SelectItem> siteTypeList) {
		this.siteTypeList = siteTypeList;
	}

	public List<SelectItem> getSiteInfoStatusList() {
		return siteInfoStatusList;
	}

	public void setSiteInfoStatusList(List<SelectItem> siteInfoStatusList) {
		this.siteInfoStatusList = siteInfoStatusList;
	}

	public List<SelectItem> getLegalApproveStatusList() {
		return legalApproveStatusList;
	}

	public void setLegalApproveStatusList(
			List<SelectItem> legalApproveStatusList) {
		this.legalApproveStatusList = legalApproveStatusList;
	}

	public List<SelectItem> getSiteStatusList() {
		return siteStatusList;
	}

	public void setSiteStatusList(List<SelectItem> siteStatusList) {
		this.siteStatusList = siteStatusList;
	}

	public SiteInfoSP getSiteInfoSP() {
		return siteInfoSP;
	}

	public void setSiteInfoSP(SiteInfoSP siteInfoSP) {
		this.siteInfoSP = siteInfoSP;
	}

	public List<WrapperBeanObject<SiteInfoSP>> getSiteInfoSPList() {
		return siteInfoSPList;
	}

	public void setSiteInfoSPList(
			List<WrapperBeanObject<SiteInfoSP>> siteInfoSPList) {
		this.siteInfoSPList = siteInfoSPList;
	}

	public boolean isExpireStatus() {
		return expireStatus;
	}

	public void setExpireStatus(boolean expireStatus) {
		this.expireStatus = expireStatus;
	}

	public SiteInfo getSiteInfo() {
		return siteInfo;
	}

	public void setSiteInfo(SiteInfo siteInfo) {
		this.siteInfo = siteInfo;
	}

	public SubRent getSiteSubRent() {
		return siteSubRent;
	}

	public void setSiteSubRent(SubRent siteSubRent) {
		this.siteSubRent = siteSubRent;
	}

	public Deposit getSiteDeposit() {
		return siteDeposit;
	}

	public void setSiteDeposit(Deposit siteDeposit) {
		this.siteDeposit = siteDeposit;
	}

	public RentCond getSiteRentCond() {
		return siteRentCond;
	}

	public void setSiteRentCond(RentCond siteRentCond) {
		this.siteRentCond = siteRentCond;
	}

	public Insurance getSiteInsurance() {
		return siteInsurance;
	}

	public void setSiteInsurance(Insurance siteInsurance) {
		this.siteInsurance = siteInsurance;
	}

	public Electric getSiteElectric() {
		return siteElectric;
	}

	public void setSiteElectric(Electric siteElectric) {
		this.siteElectric = siteElectric;
	}

	public PropertyTax getSitePropertyTax() {
		return sitePropertyTax;
	}

	public void setSitePropertyTax(PropertyTax sitePropertyTax) {
		this.sitePropertyTax = sitePropertyTax;
	}

	public Rent getSiteRent() {
		return siteRent;
	}

	public void setSiteRent(Rent siteRent) {
		this.siteRent = siteRent;
	}

	public Construct getSiteConstruct() {
		return siteConstruct;
	}

	public void setSiteConstruct(Construct siteConstruct) {
		this.siteConstruct = siteConstruct;
	}

	public String getPageStatus() {
		return pageStatus;
	}

	public void setPageStatus(String pageStatus) {
		this.pageStatus = pageStatus;
	}

	public List<SubRent> getSiteSubRentList() {
		return siteSubRentList;
	}

	public void setSiteSubRentList(List<SubRent> siteSubRentList) {
		this.siteSubRentList = siteSubRentList;
	}

	public List<Deposit> getSiteDepositList() {
		return siteDepositList;
	}

	public void setSiteDepositList(List<Deposit> siteDepositList) {
		this.siteDepositList = siteDepositList;
	}

	public List<RentCond> getSiteRentCondList() {
		return siteRentCondList;
	}

	public void setSiteRentCondList(List<RentCond> siteRentCondList) {
		this.siteRentCondList = siteRentCondList;
	}

	public List<Lessor> getSiteLessorList() {
		return siteLessorList;
	}

	public void setSiteLessorList(List<Lessor> siteLessorList) {
		this.siteLessorList = siteLessorList;
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

	public List<String> getItemList() {
		return itemList;
	}

	public void setItemList(List<String> itemList) {
		this.itemList = itemList;
	}

	public String getConfirmDeleteMsg() {
		return confirmDeleteMsg;
	}

	public void setConfirmDeleteMsg(String confirmDeleteMsg) {
		this.confirmDeleteMsg = confirmDeleteMsg;
	}

	public String getTabNo() {
		return tabNo;
	}

	public void setTabNo(String tabNo) {
		this.tabNo = tabNo;
	}

	public String getTabHeader() {
		return tabHeader;
	}

	public void setTabHeader(String tabHeader) {
		this.tabHeader = tabHeader;
	}

	public boolean isDisabledLink() {
		return disabledLink;
	}

	public void setDisabledLink(boolean disabledLink) {
		this.disabledLink = disabledLink;
	}

	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;

	}

	public String getComfirmSiteInfo() {
		return comfirmSiteInfo;
	}

	public void setComfirmSiteInfo(String comfirmSiteInfo) {
		this.comfirmSiteInfo = comfirmSiteInfo;
	}

	public boolean isPopupConfirmSiteInfo() {
		return popupConfirmSiteInfo;
	}

	public void setPopupConfirmSiteInfo(boolean popupConfirmSiteInfo) {
		this.popupConfirmSiteInfo = popupConfirmSiteInfo;
	}

	public SiteInfoSP getTmpSiteInfoSP() {
		return tmpSiteInfoSP;
	}

	public void setTmpSiteInfoSP(SiteInfoSP tmpSiteInfoSP) {
		this.tmpSiteInfoSP = tmpSiteInfoSP;
	}

	public boolean isRenderedBtnBackInternalContract() {
		return renderedBtnBackInternalContract;
	}

	public void setRenderedBtnBackInternalContract(
			boolean renderedBtnBackInternalContract) {
		this.renderedBtnBackInternalContract = renderedBtnBackInternalContract;
	}

	public boolean isRenderedBtnBackContractSubRent() {
		return renderedBtnBackContractSubRent;
	}

	public void setRenderedBtnBackContractSubRent(
			boolean renderedBtnBackContractSubRent) {
		this.renderedBtnBackContractSubRent = renderedBtnBackContractSubRent;
	}

	public List<SelectItem> getGroupRentList() {
		return groupRentList;
	}

	public void setGroupRentList(List<SelectItem> groupRentList) {
		this.groupRentList = groupRentList;
	}

	public String getPanelDisplay() {
		return panelDisplay;
	}

	public void setPanelDisplay(String panelDisplay) {
		this.panelDisplay = panelDisplay;
	}

	public String getMenuGroupDisplay() {
		return menuGroupDisplay;
	}

	public void setMenuGroupDisplay(String menuGroupDisplay) {
		this.menuGroupDisplay = menuGroupDisplay;
	}

	public MenuTreeSP getMenuTreeObjParam() {
		return menuTreeObjParam;
	}

	public void setMenuTreeObjParam(MenuTreeSP menuTreeObjParam) {
		this.menuTreeObjParam = menuTreeObjParam;
	}

	public List<WrapperBeanObject<LegalSiteAppSP>> getSiteInfoToDoList() {
		return siteInfoToDoList;
	}

	public void setSiteInfoToDoList(
			List<WrapperBeanObject<LegalSiteAppSP>> siteInfoToDoList) {
		this.siteInfoToDoList = siteInfoToDoList;
	}

	public boolean isRenderedOnToDoList() {
		return renderedOnToDoList;
	}

	public void setRenderedOnToDoList(boolean renderedOnToDoList) {
		this.renderedOnToDoList = renderedOnToDoList;
	}

	public boolean isDisabledBtnGenDummy() {
		return disabledBtnGenDummy;
	}

	public void setDisabledBtnGenDummy(boolean disabledBtnGenDummy) {
		this.disabledBtnGenDummy = disabledBtnGenDummy;
	}

	public String getDummyContractId() {
		return dummyContractId;
	}

	public void setDummyContractId(String dummyContractId) {
		this.dummyContractId = dummyContractId;
	}

	public SiteInfoSP getSiteInfoData() {
		return siteInfoData;
	}

	public void setSiteInfoData(SiteInfoSP siteInfoData) {
		this.siteInfoData = siteInfoData;
	}

	public TreeUtilBean getTreeUtilBean() {
		return treeUtilBean;
	}

	public void setTreeUtilBean(TreeUtilBean treeUtilBean) {
		this.treeUtilBean = treeUtilBean;
	}

	public TreeNode getRootNode() {
		return rootNode;
	}

	public void setRootNode(TreeNode rootNode) {
		this.rootNode = rootNode;
	}

	public SiteAppSP getSiteAppObjParam() {
		return siteAppObjParam;
	}

	public void setSiteAppObjParam(SiteAppSP siteAppObjParam) {
		this.siteAppObjParam = siteAppObjParam;
	}

	public boolean isDisabledTransfer() {
		return disabledTransfer;
	}

	public void setDisabledTransfer(boolean disabledTransfer) {
		this.disabledTransfer = disabledTransfer;
	}

	public String getSiteInfoIdTemp() {
		return siteInfoIdTemp;
	}

	public void setSiteInfoIdTemp(String siteInfoIdTemp) {
		this.siteInfoIdTemp = siteInfoIdTemp;
	}

	public boolean isDisabledExpDate() {
		return disabledExpDate;
	}

	public void setDisabledExpDate(boolean disabledExpDate) {
		this.disabledExpDate = disabledExpDate;
	}

	public boolean isChkNoExpireFlagSP() {
		return chkNoExpireFlagSP;
	}

	public void setChkNoExpireFlagSP(boolean chkNoExpireFlagSP) {
		this.chkNoExpireFlagSP = chkNoExpireFlagSP;
	}

	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreeMacroList() {
		return menuTreeMacroList;
	}

	public void setMenuTreeMacroList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreeMacroList) {
		this.menuTreeMacroList = menuTreeMacroList;
	}

	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreePicoList() {
		return menuTreePicoList;
	}

	public void setMenuTreePicoList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreePicoList) {
		this.menuTreePicoList = menuTreePicoList;
	}

	public boolean isTreeMacroFlag() {
		return treeMacroFlag;
	}

	public void setTreeMacroFlag(boolean treeMacroFlag) {
		this.treeMacroFlag = treeMacroFlag;
	}

	public String getHeaderTreeMacro() {
		return headerTreeMacro;
	}

	public void setHeaderTreeMacro(String headerTreeMacro) {
		this.headerTreeMacro = headerTreeMacro;
	}

	public boolean isTreePicoFlag() {
		return treePicoFlag;
	}

	public void setTreePicoFlag(boolean treePicoFlag) {
		this.treePicoFlag = treePicoFlag;
	}

	public String getHeaderTreePico() {
		return headerTreePico;
	}

	public void setHeaderTreePico(String headerTreePico) {
		this.headerTreePico = headerTreePico;
	}

	public boolean getFix5Percent() {
		return fix5Percent;
	}

	public void setFix5Percent(boolean fix5Percent) {
		this.fix5Percent = fix5Percent;
	}

	public ItemResultSP getRetResultObj() {
		return retResultObj;
	}

	public void setRetResultObj(ItemResultSP retResultObj) {
		this.retResultObj = retResultObj;
	}

	public boolean isRenderedMsgPopup() {
		return renderedMsgPopup;
	}

	public void setRenderedMsgPopup(boolean renderedMsgPopup) {
		this.renderedMsgPopup = renderedMsgPopup;
	}

	public String getRentEditFlag() {
		return rentEditFlag;
	}

	public void setRentEditFlag(String rentEditFlag) {
		this.rentEditFlag = rentEditFlag;
	}

	public List<SelectItem> getTodoReqTypeList() {
		return todoReqTypeList;
	}

	public void setTodoReqTypeList(List<SelectItem> todoReqTypeList) {
		this.todoReqTypeList = todoReqTypeList;
	}

	public boolean isDisabledExpenseDesc() {
		return disabledExpenseDesc;
	}

	public void setDisabledExpenseDesc(boolean disabledExpenseDesc) {
		this.disabledExpenseDesc = disabledExpenseDesc;
	}
	
	
	
}
