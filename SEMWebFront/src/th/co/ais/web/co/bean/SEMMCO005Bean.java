package th.co.ais.web.co.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.co.ContractStatus;
import th.co.ais.domain.co.Mco005SrchSP;
import th.co.ais.domain.gm.Attachment;
import th.co.ais.domain.si.Contract;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMCO005Bean extends AbstractBean {

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
	private Mco005SrchSP criteriaSP;
	private List<WrapperBeanObject<Mco005SrchSP>> contractSPList;
	private boolean disabledBtnPrint;
	private boolean disabledBtnExport;
	private String tabHeader;
	private String tabNo;
	private boolean renderBtnSiteInfo;
	private boolean renderBtnSave;
	private String siteInfoParam;
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
	private boolean disabledBtnAdd = false;
	private String rowsIdConcat;
	private Contract contract;
	private ContractStatus contractStatus;
	private String company;
	private String contractId;
	private List<SelectItem> contractStatusPopupList;
	private boolean renderedAddHistory;
	private boolean renderedUpdateHistory;
	private boolean renderedDeleteHistory;
	private boolean disabledBtnExportDuty;
	private boolean renderedMsgFormSearchPopup;
	private String selectedStatus;
	private boolean disableSelectAll;
	private String groupNo;
	private String groupNoParam;
	
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

	public Mco005SrchSP getCriteriaSP() {
		return criteriaSP;
	}

	public void setCriteriaSP(Mco005SrchSP criteriaSP) {
		this.criteriaSP = criteriaSP;
	}

	public List<WrapperBeanObject<Mco005SrchSP>> getContractSPList() {
		return contractSPList;
	}

	public void setContractSPList(
			List<WrapperBeanObject<Mco005SrchSP>> contractSPList) {
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

	public boolean isDisabledBtnAdd() {
		return disabledBtnAdd;
	}

	public void setDisabledBtnAdd(boolean disabledBtnAdd) {
		this.disabledBtnAdd = disabledBtnAdd;
	}

	public String getRowsIdConcat() {
		return rowsIdConcat;
	}

	public void setRowsIdConcat(String rowsIdConcat) {
		this.rowsIdConcat = rowsIdConcat;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public ContractStatus getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(ContractStatus contractStatus) {
		this.contractStatus = contractStatus;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public List<SelectItem> getContractStatusPopupList() {
		return contractStatusPopupList;
	}

	public void setContractStatusPopupList(List<SelectItem> contractStatusPopupList) {
		this.contractStatusPopupList = contractStatusPopupList;
	}

	public boolean isRenderedAddHistory() {
		return renderedAddHistory;
	}

	public void setRenderedAddHistory(boolean renderedAddHistory) {
		this.renderedAddHistory = renderedAddHistory;
	}

	public boolean isRenderedUpdateHistory() {
		return renderedUpdateHistory;
	}

	public void setRenderedUpdateHistory(boolean renderedUpdateHistory) {
		this.renderedUpdateHistory = renderedUpdateHistory;
	}

	public boolean isRenderedDeleteHistory() {
		return renderedDeleteHistory;
	}

	public void setRenderedDeleteHistory(boolean renderedDeleteHistory) {
		this.renderedDeleteHistory = renderedDeleteHistory;
	}

	public boolean isDisabledBtnExportDuty() {
		return disabledBtnExportDuty;
	}

	public void setDisabledBtnExportDuty(boolean disabledBtnExportDuty) {
		this.disabledBtnExportDuty = disabledBtnExportDuty;
	}

	public boolean isRenderedMsgFormSearchPopup() {
		return renderedMsgFormSearchPopup;
	}

	public void setRenderedMsgFormSearchPopup(boolean renderedMsgFormSearchPopup) {
		this.renderedMsgFormSearchPopup = renderedMsgFormSearchPopup;
	}

	public String getSelectedStatus() {
		return selectedStatus;
	}

	public void setSelectedStatus(String selectedStatus) {
		this.selectedStatus = selectedStatus;
	}

	public boolean isDisableSelectAll() {
		return disableSelectAll;
	}

	public void setDisableSelectAll(boolean disableSelectAll) {
		this.disableSelectAll = disableSelectAll;
	}

	public String getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}

	public String getGroupNoParam() {
		return groupNoParam;
	}

	public void setGroupNoParam(String groupNoParam) {
		this.groupNoParam = groupNoParam;
	}
	
}
