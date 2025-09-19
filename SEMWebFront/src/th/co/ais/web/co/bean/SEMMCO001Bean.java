package th.co.ais.web.co.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import org.richfaces.model.TreeNode;

import th.co.ais.domain.co.Mco001SrchSP;
import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.gm.Attachment;
import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.rpt.domain.SEMECO007Domain;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;
import th.co.ais.web.bean.TreeUtilBean;
import th.co.ais.web.sa.bean.LegalDocComponentBean;

public class SEMMCO001Bean extends AbstractBean {

	private static final long serialVersionUID = 7164670455509692855L;

	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> reqTypeList;
	private List<SelectItem> contractStatusList;
	private List<SelectItem> contractStatusTab1List;
	private List<SelectItem> checkDocStatusList;
	private List<SelectItem> dutyPayStatusList;
	private List<SelectItem> totSendStatusList;
	private List<SelectItem> contractLostStatusList;
	private Mco001SrchSP criteriaSP;
	private List<WrapperBeanObject<Mco001SrchSP>> contractSPList;
	private boolean disabledBtnPrint;
	private boolean disabledBtnExport;
	private String tabHeader;
	private String tabNo;
	private boolean renderBtnSiteInfo;
	private boolean renderBtnSave;
	private String siteInfoParam;
	private String picoFlag;
	private String contractIdParam;
	private String contractNoParam;
	private String siteNameParam;
	private String companyParam;
	private Date effDateParam;
	private Date expDateParam;
	private String createBy;
	private Date createDate;
	private String updateBy;
	private Date updateDate;
	private boolean chkSelAll = false;
	private String screenName;
	private boolean renderedLegal;
	private boolean renderedContract;
	private Attachment tmpAttachment;
	private List<Attachment> attachmentList;
	private boolean disabledUpload;
	private boolean renderedColDel;
	private boolean renderedAttachment;
	private boolean renderedTab2;
	private boolean renderedDataTab1;
	private boolean chkNoExpireFlag;
	private boolean chkContractLost;
	
	private String effDateParamStr;
	private String expDateParamStr;
	
	// added by.. YUT
	private boolean renderedOnToDoList = false;
	
	//added by new 04/02/2015
	private List<SelectItem> legalPlaceTypeList;
	private List<SelectItem> legalPartiesTypeList;
	private SiteAppSP siteAppObjParam;
	public List<WrapperBeanObject<LegalDocComponentBean>> legalDocList;
	private TreeUtilBean treeUtilBean;
	
	//added by NEW 20151030
	public boolean treeMacroFlag = false;
	public String headerTreeMacro;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreeMacroList;
	
	public boolean treePicoFlag = false;
	public String headerTreePico;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreePicoList;
	
	private TreeNode rootNode = null;
	
	private SEMECO007Domain semeco007Domain;
	
	private List<SelectItem> todoReqTypeList;
	
	public boolean isChkContractLost() {
		return chkContractLost;
	}

	public void setChkContractLost(boolean chkContractLost) {
		this.chkContractLost = chkContractLost;
	}

	public boolean isChkNoExpireFlag() {
		return chkNoExpireFlag;
	}

	public void setChkNoExpireFlag(boolean chkNoExpireFlag) {
		this.chkNoExpireFlag = chkNoExpireFlag;
	}

	public boolean isRenderedTab2() {
		return renderedTab2;
	}

	public void setRenderedTab2(boolean renderedTab2) {
		this.renderedTab2 = renderedTab2;
	}

	public boolean isRenderedDataTab1() {
		return renderedDataTab1;
	}

	public void setRenderedDataTab1(boolean renderedDataTab1) {
		this.renderedDataTab1 = renderedDataTab1;
	}

	public String getCompanyParam() {
		return companyParam;
	}

	public void setCompanyParam(String companyParam) {
		this.companyParam = companyParam;
	}

	public boolean isRenderedContract() {
		return renderedContract;
	}

	public void setRenderedContract(boolean renderedContract) {
		this.renderedContract = renderedContract;
	}

	public boolean isRenderedLegal() {
		return renderedLegal;
	}

	public void setRenderedLegal(boolean renderedLegal) {
		this.renderedLegal = renderedLegal;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public boolean isChkSelAll() {
		return chkSelAll;
	}

	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
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

	public String getSiteInfoParam() {
		return siteInfoParam;
	}

	public void setSiteInfoParam(String siteInfoParam) {
		this.siteInfoParam = siteInfoParam;
	}

	public String getContractIdParam() {
		return contractIdParam;
	}

	public void setContractIdParam(String contractIdParam) {
		this.contractIdParam = contractIdParam;
	}

	public String getContractNoParam() {
		return contractNoParam;
	}

	public void setContractNoParam(String contractNoParam) {
		this.contractNoParam = contractNoParam;
	}

	public String getSiteNameParam() {
		return siteNameParam;
	}

	public void setSiteNameParam(String siteNameParam) {
		this.siteNameParam = siteNameParam;
	}

	public Date getEffDateParam() {
		return effDateParam;
	}

	public void setEffDateParam(Date effDateParam) {
		this.effDateParam = effDateParam;
	}

	public Date getExpDateParam() {
		return expDateParam;
	}

	public void setExpDateParam(Date expDateParam) {
		this.expDateParam = expDateParam;
	}

	public boolean isRenderBtnSiteInfo() {
		return renderBtnSiteInfo;
	}

	public void setRenderBtnSiteInfo(boolean renderBtnSiteInfo) {
		this.renderBtnSiteInfo = renderBtnSiteInfo;
	}

	public boolean isRenderBtnSave() {
		return renderBtnSave;
	}

	public void setRenderBtnSave(boolean renderBtnSave) {
		this.renderBtnSave = renderBtnSave;
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

	public boolean isDisabledBtnPrint() {
		return disabledBtnPrint;
	}

	public void setDisabledBtnPrint(boolean disabledBtnPrint) {
		this.disabledBtnPrint = disabledBtnPrint;
	}

	public boolean isDisabledBtnExport() {
		return disabledBtnExport;
	}

	public void setDisabledBtnExport(boolean disabledBtnExport) {
		this.disabledBtnExport = disabledBtnExport;
	}

	public Mco001SrchSP getCriteriaSP() {
		return criteriaSP;
	}

	public void setCriteriaSP(Mco001SrchSP criteriaSP) {
		this.criteriaSP = criteriaSP;
	}

	public List<WrapperBeanObject<Mco001SrchSP>> getContractSPList() {
		return contractSPList;
	}

	public void setContractSPList(
			List<WrapperBeanObject<Mco001SrchSP>> contractSPList) {
		this.contractSPList = contractSPList;
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

	public List<SelectItem> getContractStatusList() {
		return contractStatusList;
	}

	public void setContractStatusList(List<SelectItem> contractStatusList) {
		this.contractStatusList = contractStatusList;
	}

	public List<SelectItem> getCheckDocStatusList() {
		return checkDocStatusList;
	}

	public void setCheckDocStatusList(List<SelectItem> checkDocStatusList) {
		this.checkDocStatusList = checkDocStatusList;
	}

	public List<SelectItem> getDutyPayStatusList() {
		return dutyPayStatusList;
	}

	public void setDutyPayStatusList(List<SelectItem> dutyPayStatusList) {
		this.dutyPayStatusList = dutyPayStatusList;
	}

	public List<SelectItem> getTotSendStatusList() {
		return totSendStatusList;
	}

	public void setTotSendStatusList(List<SelectItem> totSendStatusList) {
		this.totSendStatusList = totSendStatusList;
	}

	public Attachment getTmpAttachment() {
		if (tmpAttachment == null)
			tmpAttachment = new Attachment();
		return tmpAttachment;
	}

	public void setTmpAttachment(Attachment tmpAttachment) {
		this.tmpAttachment = tmpAttachment;
	}

	public List<Attachment> getAttachmentList() {
		if(attachmentList == null)
			attachmentList = new ArrayList<Attachment>();
		return attachmentList;
	}
	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}
	
	public boolean isDisabledUpload() {
		return disabledUpload;
	}

	public void setDisabledUpload(boolean disabledUpload) {
		this.disabledUpload = disabledUpload;
	}

	public boolean isRenderedColDel() {
		return renderedColDel;
	}

	public void setRenderedColDel(boolean renderedColDel) {
		this.renderedColDel = renderedColDel;
	}

	public boolean isRenderedAttachment() {
		return renderedAttachment;
	}

	public void setRenderedAttachment(boolean renderedAttachment) {
		this.renderedAttachment = renderedAttachment;
	}

	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public boolean isRenderSendTotForAis(){
		return ("AIS".equals(this.getCompanyParam()));
	}

	public List<SelectItem> getContractStatusTab1List() {
		return contractStatusTab1List;
	}

	public void setContractStatusTab1List(List<SelectItem> contractStatusTab1List) {
		this.contractStatusTab1List = contractStatusTab1List;
	}

	public List<SelectItem> getContractLostStatusList() {
		return contractLostStatusList;
	}

	public void setContractLostStatusList(List<SelectItem> contractLostStatusList) {
		this.contractLostStatusList = contractLostStatusList;
	}

	public String getEffDateParamStr() {
		return effDateParamStr;
	}

	public void setEffDateParamStr(String effDateParamStr) {
		this.effDateParamStr = effDateParamStr;
	}

	public String getExpDateParamStr() {
		return expDateParamStr;
	}

	public void setExpDateParamStr(String expDateParamStr) {
		this.expDateParamStr = expDateParamStr;
	}

	public String getPicoFlag() {
		return picoFlag;
	}

	public void setPicoFlag(String picoFlag) {
		this.picoFlag = picoFlag;
	}

	public SiteAppSP getSiteAppObjParam() {
		return siteAppObjParam;
	}

	public void setSiteAppObjParam(SiteAppSP siteAppObjParam) {
		this.siteAppObjParam = siteAppObjParam;
	}

	public List<WrapperBeanObject<LegalDocComponentBean>> getLegalDocList() {
		return legalDocList;
	}

	public void setLegalDocList(
			List<WrapperBeanObject<LegalDocComponentBean>> legalDocList) {
		this.legalDocList = legalDocList;
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
	
	public boolean isRenderedOnToDoList() {
		return renderedOnToDoList;
	}

	public void setRenderedOnToDoList(boolean renderedOnToDoList) {
		this.renderedOnToDoList = renderedOnToDoList;
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

	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreeMacroList() {
		return menuTreeMacroList;
	}

	public void setMenuTreeMacroList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreeMacroList) {
		this.menuTreeMacroList = menuTreeMacroList;
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

	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreePicoList() {
		return menuTreePicoList;
	}

	public void setMenuTreePicoList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreePicoList) {
		this.menuTreePicoList = menuTreePicoList;
	}

	public SEMECO007Domain getSemeco007Domain() {
		return semeco007Domain;
	}

	public void setSemeco007Domain(SEMECO007Domain semeco007Domain) {
		this.semeco007Domain = semeco007Domain;
	}

	public List<SelectItem> getTodoReqTypeList() {
		return todoReqTypeList;
	}

	public void setTodoReqTypeList(List<SelectItem> todoReqTypeList) {
		this.todoReqTypeList = todoReqTypeList;
	}
	
}
