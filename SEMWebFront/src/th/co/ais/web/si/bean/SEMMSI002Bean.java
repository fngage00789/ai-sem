package th.co.ais.web.si.bean;

import java.util.HashMap;
import java.util.List;

import javax.faces.model.SelectItem;

import org.richfaces.model.TreeNode;

import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.gm.LovMaster;
import th.co.ais.domain.sa.MSA001LovSP;
import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.domain.sa.SiteAppSiteSP;
import th.co.ais.domain.si.LegalApprove;
import th.co.ais.domain.si.LegalApproveDisplaySP;
import th.co.ais.domain.si.LegalApproveSeqSP;
import th.co.ais.domain.si.LegalApproveSrchByAppvSP;
import th.co.ais.domain.si.LegalSiteAppSP;
import th.co.ais.domain.si.Msi002Editable;
import th.co.ais.domain.si.Msi002UpdLatestFlag;
import th.co.ais.domain.si.Msi002UpdOutDt;
import th.co.ais.domain.si.SiteApprove;
import th.co.ais.domain.si.SiteApproveMapLocSP;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;
import th.co.ais.web.sa.bean.LegalDocComponentBean;

public class SEMMSI002Bean extends AbstractBean{

	private static final long serialVersionUID = 5961108850062901238L;
	private boolean displayBtn;
	
	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> legalApproveList;
	private List<SelectItem> reqTypeList;
	private List<SelectItem> reqDocTypeList;
	private List<SelectItem> siteApproveStatusList;
	private List<SelectItem> docStatusList;
	
	private String siteApproveId;
	private String pageStatus;
	private boolean pageMode;
	
	private List riskType1List;
	private List riskType2List;
	private List riskType3List;
	private List riskTypeOtherList;
	private List doc1List;
	private List doc2List;
	private List doc3List;
	private List doc4List;
	private List doc5List;
	private List doc6List;
	private List doc7List;
	private List doc8List;
	private List doc9List;
	private List doc10List;
	private List docOtherList;
	
	private Integer cRound;
	
	private String temp;
	private Integer maxCRound;
	private HashMap pnlRentType;
	private Boolean validateBtn; 
	private Boolean validateBtnSave;
	
	private Boolean disableChk1;
	private Boolean disableChk2;
	private Boolean disableChk3;
	private Boolean disableChk4;
	private Boolean disableChk5;
	private Boolean disableChk6;
	private Boolean disableChk7;
	private Boolean disableChk8;
	private Boolean disableChk9;
	private Boolean disableChk10;
	private LegalApprove legalApprove;

	private String tmpRowId2;
	private String tmpRowId3;
	private String tmpId;
	
	private boolean chkSelAll = false;
	
	private boolean disabledBtnExport;
	private boolean renderDocStatus ;
	private boolean renderLegalDetail;
	private boolean renderedMsgAlert;
	private LegalApproveSrchByAppvSP legalToken;
	
	// init Delete
	private LegalApprove initLegalApprove;
	
	private List<LovMaster> lovMasterRentalList;
	
	private List<WrapperBeanObject<LegalApproveDisplaySP>> legalApproveDisplaySPList;
	private LegalApproveDisplaySP legalApproveDisplaySP;
	private LegalApproveDisplaySP legalApproveSelectSP;
	
	private List<LegalApproveSrchByAppvSP> legalApproveSrchByAppvSPList;
	private LegalApproveSrchByAppvSP legalApproveSrchByAppvSP;
	private SiteApprove siteApprove;
	
	private List<SiteApproveMapLocSP> siteApproveMapLocSPList;
	private SiteApproveMapLocSP siteApproveMapLocSP;
	
	private List<LegalApproveSeqSP> legalApproveSeqSPList;
	private LegalApproveSeqSP legalApproveSeqSP;
	
	private List<Msi002UpdLatestFlag> msi002UpdLatestFlagList;
	private Msi002UpdLatestFlag msi002UpdLatestFlag;
	
	private Msi002UpdOutDt msi002UpdOutDt;
	private Msi002Editable msi002Editable;
	
	//redered Column on Table LegalApproveSrchByAppv
	private boolean renderedColumn;
	
	//flag check export
	private boolean flagChkExport;
	private List rowsIdConcat;
	
	private boolean displayShowExport;
	private boolean renderedEditable;
	private boolean renderedCancletable;
	
	//for criteria
	private SiteAppSP siteAppObjParam;
	private SiteAppSP siteAppObjParamOld;
	private SiteAppSiteSP siteAppSiteObjParam;
	
	private List<SelectItem> legalPlaceTypeList;
	private List<SelectItem> legalPartiesTypeList;
	
	//temp Object
	private String paramSiteAppId;
	private String paramPlaceType;
	private String paramPartiesType;
	
	private MSA001LovSP msa001LovSP;
	
	public List<WrapperBeanObject<LegalDocComponentBean>> legalDocList;
	
	
	//
	private boolean renderedOnToDoList = false;
	
	
	// added by.. YUT
	private String panelDisplay;
	private String menuGroupDisplay;
	private MenuTreeSP menuTreeObjParam;
	public List<WrapperBeanObject<LegalSiteAppSP>> legalSiteAppList;
	private boolean chkContractWanted = false;
	
	private TreeNode rootNode = null;
	
	//added by NEW 20151030
	public boolean treeNewFlag = false;
	public String headerTreeNew;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreeNewList;
	
	public boolean treeRenewFlag = false;
	public String headerTreeRenew;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreeRenewList;
	
	public boolean treeEditFlag = false;
	public String headerTreeEdit;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreeEditList;
	
	public boolean treeTerminateFlag = false;
	public String headerTreeTerminate;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreeTerminateList;
	
	public SiteApproveMapLocSP getSiteApproveMapLocSP() {
		return siteApproveMapLocSP;
	}
	public void setSiteApproveMapLocSP(SiteApproveMapLocSP siteApproveMapLocSP) {
		this.siteApproveMapLocSP = siteApproveMapLocSP;
	}
	public LegalApproveDisplaySP getLegalApproveDisplaySP() {
		return legalApproveDisplaySP;
	}
	public void setLegalApproveDisplaySP(LegalApproveDisplaySP legalApproveDisplaySP) {
		this.legalApproveDisplaySP = legalApproveDisplaySP;
	}
	public List<LegalApproveSrchByAppvSP> getLegalApproveSrchByAppvSPList() {
		return legalApproveSrchByAppvSPList;
	}
	public void setLegalApproveSrchByAppvSPList(
			List<LegalApproveSrchByAppvSP> legalApproveSrchByAppvSPList) {
		this.legalApproveSrchByAppvSPList = legalApproveSrchByAppvSPList;
	}
	public LegalApproveSrchByAppvSP getLegalApproveSrchByAppvSP() {
		return legalApproveSrchByAppvSP;
	}
	public void setLegalApproveSrchByAppvSP(
			LegalApproveSrchByAppvSP legalApproveSrchByAppvSP) {
		this.legalApproveSrchByAppvSP = legalApproveSrchByAppvSP;
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
	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}
	public List<SelectItem> getCompanyList() {
		return companyList;
	}
	public List getDoc1List() {
		return doc1List;
	}
	public void setDoc1List(List doc1List) {
		this.doc1List = doc1List;
	}
	public List getDoc2List() {
		return doc2List;
	}
	public void setDoc2List(List doc2List) {
		this.doc2List = doc2List;
	}
	public List getDoc3List() {
		return doc3List;
	}
	public void setDoc3List(List doc3List) {
		this.doc3List = doc3List;
	}
	public List getDoc4List() {
		return doc4List;
	}
	public List<LegalApproveSeqSP> getLegalApproveSeqSPList() {
		return legalApproveSeqSPList;
	}
	public void setLegalApproveSeqSPList(
			List<LegalApproveSeqSP> legalApproveSeqSPList) {
		this.legalApproveSeqSPList = legalApproveSeqSPList;
	}
	public LegalApproveSeqSP getLegalApproveSeqSP() {
		return legalApproveSeqSP;
	}
	public void setLegalApproveSeqSP(LegalApproveSeqSP legalApproveSeqSP) {
		this.legalApproveSeqSP = legalApproveSeqSP;
	}
	public void setDoc4List(List doc4List) {
		this.doc4List = doc4List;
	}
	public List getDoc5List() {
		return doc5List;
	}
	public List<Msi002UpdLatestFlag> getMsi002UpdLatestFlagList() {
		return msi002UpdLatestFlagList;
	}
	public void setMsi002UpdLatestFlagList(
			List<Msi002UpdLatestFlag> msi002UpdLatestFlagList) {
		this.msi002UpdLatestFlagList = msi002UpdLatestFlagList;
	}
	public Msi002UpdLatestFlag getMsi002UpdLatestFlag() {
		return msi002UpdLatestFlag;
	}
	public void setMsi002UpdLatestFlag(Msi002UpdLatestFlag msi002UpdLatestFlag) {
		this.msi002UpdLatestFlag = msi002UpdLatestFlag;
	}
	public void setDoc5List(List doc5List) {
		this.doc5List = doc5List;
	}
	public List getDocOtherList() {
		return docOtherList;
	}
	public void setDocOtherList(List docOtherList) {
		this.docOtherList = docOtherList;
	}
	public void setLegalApproveList(List<SelectItem> legalApproveList) {
		this.legalApproveList = legalApproveList;
	}
	public List<SelectItem> getLegalApproveList() {
		return legalApproveList;
	}
	public void setReqTypeList(List<SelectItem> reqTypeList) {
		this.reqTypeList = reqTypeList;
	}
	public List<SelectItem> getReqTypeList() {
		return reqTypeList;
	}
	public List<SelectItem> getReqDocTypeList() {
		return reqDocTypeList;
	}
	public void setReqDocTypeList(List<SelectItem> reqDocTypeList) {
		this.reqDocTypeList = reqDocTypeList;
	}
	public List<SelectItem> getSiteApproveStatusList() {
		return siteApproveStatusList;
	}
	public void setSiteApproveStatusList(List<SelectItem> siteApproveStatusList) {
		this.siteApproveStatusList = siteApproveStatusList;
	}
	public LegalApprove getLegalApprove() {
		return legalApprove;
	}
	public void setLegalApprove(LegalApprove legalApprove) {
		this.legalApprove = legalApprove;
	}
	public List getRiskType1List() {
		return riskType1List;
	}
	public void setRiskType1List(List riskType1List) {
		this.riskType1List = riskType1List;
	}
	public List getRiskType2List() {
		return riskType2List;
	}
	public void setRiskType2List(List riskType2List) {
		this.riskType2List = riskType2List;
	}
	public List getRiskType3List() {
		return riskType3List;
	}
	public void setRiskType3List(List riskType3List) {
		this.riskType3List = riskType3List;
	}
	public List getRiskTypeOtherList() {
		return riskTypeOtherList;
	}
	public void setRiskTypeOtherList(List riskTypeOtherList) {
		this.riskTypeOtherList = riskTypeOtherList;
	}
	public void setLovMasterRentalList(List<LovMaster> lovMasterRentalList) {
		this.lovMasterRentalList = lovMasterRentalList;
	}
	public List<LovMaster> getLovMasterRentalList() {
		return lovMasterRentalList;
	}
	public void setDisableChk1(Boolean disableChk1) {
		this.disableChk1 = disableChk1;
	}
	public Boolean getDisableChk1() {
		return disableChk1;
	}
	public void setDisableChk2(Boolean disableChk2) {
		this.disableChk2 = disableChk2;
	}
	public Boolean getDisableChk2() {
		return disableChk2;
	}
	public SiteApprove getSiteApprove() {
		return siteApprove;
	}
	public void setSiteApprove(SiteApprove siteApprove) {
		this.siteApprove = siteApprove;
	}
	public List<SiteApproveMapLocSP> getSiteApproveMapLocSPList() {
		return siteApproveMapLocSPList;
	}
	public void setSiteApproveMapLocSPList(
			List<SiteApproveMapLocSP> siteApproveMapLocSPList) {
		this.siteApproveMapLocSPList = siteApproveMapLocSPList;
	}
	public Boolean getDisableChk3() {
		return disableChk3;
	}
	public void setDisableChk3(Boolean disableChk3) {
		this.disableChk3 = disableChk3;
	}
	public Boolean getDisableChk4() {
		return disableChk4;
	}
	public void setDisableChk4(Boolean disableChk4) {
		this.disableChk4 = disableChk4;
	}
	public Boolean getDisableChk5() {
		return disableChk5;
	}
	public void setDisableChk5(Boolean disableChk5) {
		this.disableChk5 = disableChk5;
	}
	public Boolean getDisableChk6() {
		return disableChk6;
	}
	public void setDisableChk6(Boolean disableChk6) {
		this.disableChk6 = disableChk6;
	}
	public Boolean getDisableChk7() {
		return disableChk7;
	}
	public void setDisableChk7(Boolean disableChk7) {
		this.disableChk7 = disableChk7;
	}
	public List getDoc6List() {
		return doc6List;
	}
	public void setDoc6List(List doc6List) {
		this.doc6List = doc6List;
	}
	public List getDoc7List() {
		return doc7List;
	}
	public void setDoc7List(List doc7List) {
		this.doc7List = doc7List;
	}
	public void setSiteApproveId(String siteApproveId) {
		this.siteApproveId = siteApproveId;
	}
	public String getSiteApproveId() {
		return siteApproveId;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getTemp() {
		return temp;
	}
	public void setcRound(Integer cRound) {
		this.cRound = cRound;
	}
	public Integer getcRound() {
		return cRound;
	}
	public void setPnlRentType(HashMap pnlRentType) {
		this.pnlRentType = pnlRentType;
	}
	public HashMap getPnlRentType() {
		return pnlRentType;
	}
	public void setValidateBtn(Boolean validateBtn) {
		this.validateBtn = validateBtn;
	}
	public Boolean getValidateBtn() {
		return validateBtn;
	}
	public void setValidateBtnSave(Boolean validateBtnSave) {
		this.validateBtnSave = validateBtnSave;
	}
	public Boolean getValidateBtnSave() {
		return validateBtnSave;
	}
	public void setMaxCRound(Integer maxCRound) {
		this.maxCRound = maxCRound;
	}
	public Integer getMaxCRound() {
		return maxCRound;
	}
	public void setPageStatus(String pageStatus) {
		this.pageStatus = pageStatus;
	}
	public String getPageStatus() {
		return pageStatus;
	}
	public void setPageMode(boolean pageMode) {
		this.pageMode = pageMode;
	}
	public boolean getPageMode() {
		return pageMode;
	}
	public void setInitLegalApprove(LegalApprove initLegalApprove) {
		this.initLegalApprove = initLegalApprove;
	}
	public LegalApprove getInitLegalApprove() {
		return initLegalApprove;
	}
	public void setTmpRowId2(String tmpRowId2) {
		this.tmpRowId2 = tmpRowId2;
	}
	public String getTmpRowId2() {
		return tmpRowId2;
	}
	public void setDisabledBtnExport(boolean disabledBtnExport) {
		this.disabledBtnExport = disabledBtnExport;
	}
	public boolean isDisabledBtnExport() {
		return disabledBtnExport;
	}
	public void setLegalApproveDisplaySPList(
			List<WrapperBeanObject<LegalApproveDisplaySP>> legalApproveDisplaySPList) {
		this.legalApproveDisplaySPList = legalApproveDisplaySPList;
	}
	public List<WrapperBeanObject<LegalApproveDisplaySP>> getLegalApproveDisplaySPList() {
		return legalApproveDisplaySPList;
	}
	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}
	public boolean isChkSelAll() {
		return chkSelAll;
	}
	public void setTmpRowId3(String tmpRowId3) {
		this.tmpRowId3 = tmpRowId3;
	}
	public String getTmpRowId3() {
		return tmpRowId3;
	}
	public void setMsi002UpdOutDt(Msi002UpdOutDt msi002UpdOutDt) {
		this.msi002UpdOutDt = msi002UpdOutDt;
	}
	public Msi002UpdOutDt getMsi002UpdOutDt() {
		return msi002UpdOutDt;
	}
	public void setRenderedColumn(boolean renderedColumn) {
		this.renderedColumn = renderedColumn;
	}
	public boolean isRenderedColumn() {
		return renderedColumn;
	}
	public void setFlagChkExport(boolean flagChkExport) {
		this.flagChkExport = flagChkExport;
	}
	public boolean isFlagChkExport() {
		return flagChkExport;
	}
	public List getRowsIdConcat() {
		return rowsIdConcat;
	}
	public void setRowsIdConcat(List rowsIdConcat) {
		this.rowsIdConcat = rowsIdConcat;
	}
	public boolean isDisplayShowExport() {
		return displayShowExport;
	}
	public void setDisplayShowExport(boolean displayShowExport) {
		this.displayShowExport = displayShowExport;
	}
	public void setDisplayBtn(boolean displayBtn) {
		this.displayBtn = displayBtn;
	}
	public boolean isDisplayBtn() {
		return displayBtn;
	}
	public void setMsi002Editable(Msi002Editable msi002Editable) {
		this.msi002Editable = msi002Editable;
	}
	public Msi002Editable getMsi002Editable() {
		return msi002Editable;
	}
	public void setRenderedEditable(boolean renderedEditable) {
		this.renderedEditable = renderedEditable;
	}
	public boolean isRenderedEditable() {
		return renderedEditable;
	}
	public void setRenderedCancletable(boolean renderedCancletable) {
		this.renderedCancletable = renderedCancletable;
	}
	public boolean isRenderedCancletable() {
		return renderedCancletable;
	}
	public List<SelectItem> getDocStatusList() {
		return docStatusList;
	}
	public void setDocStatusList(List<SelectItem> docStatusList) {
		this.docStatusList = docStatusList;
	}
	public boolean isRenderDocStatus() {
		return renderDocStatus;
	}
	public void setRenderDocStatus(boolean renderDocStatus) {
		this.renderDocStatus = renderDocStatus;
	}
	public boolean isRenderLegalDetail() {
		return renderLegalDetail;
	}
	public void setRenderLegalDetail(boolean renderLegalDetail) {
		this.renderLegalDetail = renderLegalDetail;
	}
	public LegalApproveSrchByAppvSP getLegalToken() {
		return legalToken;
	}
	public void setLegalToken(LegalApproveSrchByAppvSP legalToken) {
		this.legalToken = legalToken;
	}
	public String getTmpId() {
		return tmpId;
	}
	public void setTmpId(String tmpId) {
		this.tmpId = tmpId;
	}
	public Boolean getDisableChk8() {
		return disableChk8;
	}
	public void setDisableChk8(Boolean disableChk8) {
		this.disableChk8 = disableChk8;
	}
	public List getDoc8List() {
		return doc8List;
	}
	public void setDoc8List(List doc8List) {
		this.doc8List = doc8List;
	}
	public List getDoc9List() {
		return doc9List;
	}
	public void setDoc9List(List doc9List) {
		this.doc9List = doc9List;
	}
	public List getDoc10List() {
		return doc10List;
	}
	public void setDoc10List(List doc10List) {
		this.doc10List = doc10List;
	}
	public Boolean getDisableChk9() {
		return disableChk9;
	}
	public void setDisableChk9(Boolean disableChk9) {
		this.disableChk9 = disableChk9;
	}
	public Boolean getDisableChk10() {
		return disableChk10;
	}
	public void setDisableChk10(Boolean disableChk10) {
		this.disableChk10 = disableChk10;
	}
	public SiteAppSP getSiteAppObjParam() {
		return siteAppObjParam;
	}
	public void setSiteAppObjParam(SiteAppSP siteAppObjParam) {
		this.siteAppObjParam = siteAppObjParam;
	}
	public SiteAppSiteSP getSiteAppSiteObjParam() {
		return siteAppSiteObjParam;
	}
	public void setSiteAppSiteObjParam(SiteAppSiteSP siteAppSiteObjParam) {
		this.siteAppSiteObjParam = siteAppSiteObjParam;
	}
	public List<SelectItem> getLegalPlaceTypeList() {
		return legalPlaceTypeList;
	}
	public void setLegalPlaceTypeList(List<SelectItem> legalPlaceTypeList) {
		this.legalPlaceTypeList = legalPlaceTypeList;
	}
	public List<SelectItem> getLegalPartiesTypeList() {
		return legalPartiesTypeList;
	}
	public void setLegalPartiesTypeList(List<SelectItem> legalPartiesTypeList) {
		this.legalPartiesTypeList = legalPartiesTypeList;
	}
	public List<WrapperBeanObject<LegalDocComponentBean>> getLegalDocList() {
		return legalDocList;
	}
	public void setLegalDocList(
			List<WrapperBeanObject<LegalDocComponentBean>> legalDocList) {
		this.legalDocList = legalDocList;
	}
	public String getParamSiteAppId() {
		return paramSiteAppId;
	}
	public void setParamSiteAppId(String paramSiteAppId) {
		this.paramSiteAppId = paramSiteAppId;
	}
	public String getParamPlaceType() {
		return paramPlaceType;
	}
	public void setParamPlaceType(String paramPlaceType) {
		this.paramPlaceType = paramPlaceType;
	}
	public String getParamPartiesType() {
		return paramPartiesType;
	}
	public void setParamPartiesType(String paramPartiesType) {
		this.paramPartiesType = paramPartiesType;
	}
	public MSA001LovSP getMsa001LovSP() {
		return msa001LovSP;
	}
	public void setMsa001LovSP(MSA001LovSP msa001LovSP) {
		this.msa001LovSP = msa001LovSP;
	}
	public boolean isRenderedMsgAlert() {
		return renderedMsgAlert;
	}
	public void setRenderedMsgAlert(boolean renderedMsgAlert) {
		this.renderedMsgAlert = renderedMsgAlert;
	}
	public SiteAppSP getSiteAppObjParamOld() {
		return siteAppObjParamOld;
	}
	public void setSiteAppObjParamOld(SiteAppSP siteAppObjParamOld) {
		this.siteAppObjParamOld = siteAppObjParamOld;
	}
	public LegalApproveDisplaySP getLegalApproveSelectSP() {
		return legalApproveSelectSP;
	}
	public void setLegalApproveSelectSP(LegalApproveDisplaySP legalApproveSelectSP) {
		this.legalApproveSelectSP = legalApproveSelectSP;
	}
	public boolean isRenderedOnToDoList() {
		return renderedOnToDoList;
	}
	public void setRenderedOnToDoList(boolean renderedOnToDoList) {
		this.renderedOnToDoList = renderedOnToDoList;
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
	public List<WrapperBeanObject<LegalSiteAppSP>> getLegalSiteAppList() {
		return legalSiteAppList;
	}
	public void setLegalSiteAppList(
			List<WrapperBeanObject<LegalSiteAppSP>> legalSiteAppList) {
		this.legalSiteAppList = legalSiteAppList;
	}
	public boolean isChkContractWanted() {
		return chkContractWanted;
	}
	public void setChkContractWanted(boolean chkContractWanted) {
		this.chkContractWanted = chkContractWanted;
	}
	public TreeNode getRootNode() {
		return rootNode;
	}
	public void setRootNode(TreeNode rootNode) {
		this.rootNode = rootNode;
	}
	public boolean isTreeNewFlag() {
		return treeNewFlag;
	}
	public void setTreeNewFlag(boolean treeNewFlag) {
		this.treeNewFlag = treeNewFlag;
	}
	public String getHeaderTreeNew() {
		return headerTreeNew;
	}
	public void setHeaderTreeNew(String headerTreeNew) {
		this.headerTreeNew = headerTreeNew;
	}
	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreeNewList() {
		return menuTreeNewList;
	}
	public void setMenuTreeNewList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreeNewList) {
		this.menuTreeNewList = menuTreeNewList;
	}
	public boolean isTreeRenewFlag() {
		return treeRenewFlag;
	}
	public void setTreeRenewFlag(boolean treeRenewFlag) {
		this.treeRenewFlag = treeRenewFlag;
	}
	public String getHeaderTreeRenew() {
		return headerTreeRenew;
	}
	public void setHeaderTreeRenew(String headerTreeRenew) {
		this.headerTreeRenew = headerTreeRenew;
	}
	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreeRenewList() {
		return menuTreeRenewList;
	}
	public void setMenuTreeRenewList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreeRenewList) {
		this.menuTreeRenewList = menuTreeRenewList;
	}
	public boolean isTreeEditFlag() {
		return treeEditFlag;
	}
	public void setTreeEditFlag(boolean treeEditFlag) {
		this.treeEditFlag = treeEditFlag;
	}
	public String getHeaderTreeEdit() {
		return headerTreeEdit;
	}
	public void setHeaderTreeEdit(String headerTreeEdit) {
		this.headerTreeEdit = headerTreeEdit;
	}
	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreeEditList() {
		return menuTreeEditList;
	}
	public void setMenuTreeEditList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreeEditList) {
		this.menuTreeEditList = menuTreeEditList;
	}
	public boolean isTreeTerminateFlag() {
		return treeTerminateFlag;
	}
	public void setTreeTerminateFlag(boolean treeTerminateFlag) {
		this.treeTerminateFlag = treeTerminateFlag;
	}
	public String getHeaderTreeTerminate() {
		return headerTreeTerminate;
	}
	public void setHeaderTreeTerminate(String headerTreeTerminate) {
		this.headerTreeTerminate = headerTreeTerminate;
	}
	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreeTerminateList() {
		return menuTreeTerminateList;
	}
	public void setMenuTreeTerminateList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreeTerminateList) {
		this.menuTreeTerminateList = menuTreeTerminateList;
	}	
	
	
}
