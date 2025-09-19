package th.co.ais.web.co.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.gm.Attachment;
import th.co.ais.domain.si.Contract;
import th.co.ais.domain.co.ContractStatus;
import th.co.ais.domain.co.Mco004Act;
import th.co.ais.domain.co.Mco004SrchSP;
import th.co.ais.domain.co.Mco004UpdateDuty;
import th.co.ais.util.ELovType;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMCO004Bean extends AbstractBean {
	
	private List<SelectItem> companyList;
	private List<SelectItem> monthList;
	private List<SelectItem> regionList;
	private List<SelectItem> subRentTypeList;
	private List<SelectItem> subRentStatusList;
	private List<SelectItem> subRentSummaryTypeList;
	private List<SelectItem> siteTypeList;
	private List<SelectItem> monthPopupList;
	
	private Mco004SrchSP criteriaSrch;
	private List<WrapperBeanObject<Mco004SrchSP>> mco004SrchSPList;
	private Mco004SrchSP criteriaSummarySrch;
	private List<Mco004SrchSP> summaryList;
	
	private Mco004SrchSP subRentInfo;
	private Mco004SrchSP popupContractNo;
	private boolean chkAll;
	private boolean chkbox;
	private boolean disableExport = true;
	private String rowId;
	private String No;
	
// Add 27/02/2013 By Noom	
	private String contractIdParam;
	private String siteNameParam;
	private String companyParam;
	private String siteInfoParam;
	private String ContractNoParam;
	private Date EffDateParam;
	private Date ExpDateParam;
	private String EffDateParamStr;
	private String ExpDateParamStr;
	private String tabNo;
	private boolean renderedContract;
	private String screenName;
	private boolean renderedLegal;
	private boolean renderedTab2;
	private boolean renderedDataTab1;
	private boolean renderBtnSave;
	private boolean chkContractLost;
	private List<SelectItem> contractStatusTab1List;
	private String tabHeader;
	private List<SelectItem>  contractLostStatusList;
	private Date createDate;
	private Date updateDate;
	private String createBy;
	private String updateBy;
	private Attachment tmpAttachment;
	private List<Attachment>  attachmentList;
	private boolean renderedColDel;
	
	private boolean renderedAttachment;
	private String fromInitPage;
	
	private boolean renderedMsgSummaryPopup = true;
	
	private Mco004Act mco004Act;
	
	
	private String groupNumber;
	private String rowsIdConcat;
	private Contract contract;
	private String contractId;
	private List<SelectItem> contractStatusList;
	private String company;
	private boolean disabledBtnAdd;
	private ContractStatus contractStatus;
	private boolean renderedAddHistory;
	private boolean renderedUpdateHistory;
	private boolean renderedDeleteHistory;
	private boolean disabledBtnExportDuty;
	private boolean renderedMsgFormSearchPopup;
	private List<SelectItem> borrowOfficerList;
	
	private String selectedStatus;
	private boolean chkSelAll;
	private boolean disableSelectAll;
	private Mco004UpdateDuty mco004UpdateDuty;
	private String groupNo;
	
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
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

	public List<SelectItem> getMonthList() {
		return monthList;
	}

	public void setMonthList(List<SelectItem> monthList) {
		this.monthList = monthList;
	}

	public Mco004SrchSP getCriteriaSrch() {
		return criteriaSrch;
	}

	public void setCriteriaSrch(Mco004SrchSP criteriaSrch) {
		this.criteriaSrch = criteriaSrch;
	}

	public List<SelectItem> getRegionList() {
		return regionList;
	}

	public void setRegionList(List<SelectItem> regionList) {
		this.regionList = regionList;
	}

	public List<SelectItem> getSubRentTypeList() {
		return subRentTypeList;
	}

	public void setSubRentTypeList(List<SelectItem> subRentTypeList) {
		this.subRentTypeList = subRentTypeList;
	}

	public List<SelectItem> getSubRentStatusList() {
		return subRentStatusList;
	}

	public void setSubRentStatusList(List<SelectItem> subRentStatusList) {
		this.subRentStatusList = subRentStatusList;
	}

	public List<WrapperBeanObject<Mco004SrchSP>> getMco004SrchSPList() {
		return mco004SrchSPList;
	}

	public void setMco004SrchSPList(
			List<WrapperBeanObject<Mco004SrchSP>> mco004SrchSPList) {
		this.mco004SrchSPList = mco004SrchSPList;
	}

	public Mco004SrchSP getCriteriaSummarySrch() {
		return criteriaSummarySrch;
	}

	public void setCriteriaSummarySrch(Mco004SrchSP criteriaSummarySrch) {
		this.criteriaSummarySrch = criteriaSummarySrch;
	}

	public List<Mco004SrchSP> getSummaryList() {
		return summaryList;
	}

	public void setSummaryList(List<Mco004SrchSP> summaryList) {
		this.summaryList = summaryList;
	}

	public List<SelectItem> getSubRentSummaryTypeList() {
		return subRentSummaryTypeList;
	}

	public void setSubRentSummaryTypeList(List<SelectItem> subRentSummaryTypeList) {
		this.subRentSummaryTypeList = subRentSummaryTypeList;
	}

	public Mco004SrchSP getSubRentInfo() {
		return subRentInfo;
	}

	public void setSubRentInfo(Mco004SrchSP subRentInfo) {
		this.subRentInfo = subRentInfo;
	}

	public Mco004SrchSP getPopupContractNo() {
		return popupContractNo;
	}

	public void setPopupContractNo(Mco004SrchSP popupContractNo) {
		this.popupContractNo = popupContractNo;
	}

	public List<SelectItem> getSiteTypeList() {
		return siteTypeList;
	}

	public void setSiteTypeList(List<SelectItem> siteTypeList) {
		this.siteTypeList = siteTypeList;
	}

	public boolean isChkAll() {
		return chkAll;
	}

	public boolean isChkbox() {
		return chkbox;
	}

	public boolean isDisableExport() {
		return disableExport;
	}

	public void setDisableExport(boolean disableExport) {
		this.disableExport = disableExport;
	}

	public void setChkAll(boolean chkAll) {
		this.chkAll = chkAll;
	}

	public void setChkbox(boolean chkbox) {
		this.chkbox = chkbox;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getNo() {
		return No;
	}

	public void setNo(String no) {
		No = no;
	}

	public boolean isRenderedMsgSummaryPopup() {
		return renderedMsgSummaryPopup;
	}

	public void setRenderedMsgSummaryPopup(boolean renderedMsgSummaryPopup) {
		this.renderedMsgSummaryPopup = renderedMsgSummaryPopup;
	}

	public List<SelectItem> getMonthPopupList() {
		return monthPopupList;
	}

	public void setMonthPopupList(List<SelectItem> monthPopupList) {
		this.monthPopupList = monthPopupList;
	}

	public Mco004Act getMco004Act() {
		return mco004Act;
	}

	public void setMco004Act(Mco004Act mco004Act) {
		this.mco004Act = mco004Act;
	}

	public String getContractIdParam() {
		return contractIdParam;
	}

	public void setContractIdParam(String contractIdParam) {
		this.contractIdParam = contractIdParam;
	}

	public String getSiteNameParam() {
		return siteNameParam;
	}

	public void setSiteNameParam(String siteNameParam) {
		this.siteNameParam = siteNameParam;
	}

	public String getCompanyParam() {
		return companyParam;
	}

	public void setCompanyParam(String companyParam) {
		this.companyParam = companyParam;
	}

	public String getSiteInfoParam() {
		return siteInfoParam;
	}

	public void setSiteInfoParam(String siteInfoParam) {
		this.siteInfoParam = siteInfoParam;
	}

	public String getContractNoParam() {
		return ContractNoParam;
	}

	public void setContractNoParam(String contractNoParam) {
		ContractNoParam = contractNoParam;
	}

	public Date getEffDateParam() {
		return EffDateParam;
	}

	public void setEffDateParam(Date effDateParam) {
		EffDateParam = effDateParam;
	}

	public Date getExpDateParam() {
		return ExpDateParam;
	}

	public void setExpDateParam(Date expDateParam) {
		ExpDateParam = expDateParam;
	}

	public String getEffDateParamStr() {
		return EffDateParamStr;
	}

	public void setEffDateParamStr(String effDateParamStr) {
		EffDateParamStr = effDateParamStr;
	}

	public String getExpDateParamStr() {
		return ExpDateParamStr;
	}

	public void setExpDateParamStr(String expDateParamStr) {
		ExpDateParamStr = expDateParamStr;
	}

	public String getTabNo() {
		return tabNo;
	}

	public void setTabNo(String tabNo) {
		this.tabNo = tabNo;
	}

	public boolean isRenderedContract() {
		return renderedContract;
	}

	public void setRenderedContract(boolean renderedContract) {
		this.renderedContract = renderedContract;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public boolean isRenderedLegal() {
		return renderedLegal;
	}

	public void setRenderedLegal(boolean renderedLegal) {
		this.renderedLegal = renderedLegal;
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

	public boolean isRenderBtnSave() {
		return renderBtnSave;
	}

	public void setRenderBtnSave(boolean renderBtnSave) {
		this.renderBtnSave = renderBtnSave;
	}

	public boolean isChkContractLost() {
		return chkContractLost;
	}

	public void setChkContractLost(boolean chkContractLost) {
		this.chkContractLost = chkContractLost;
	}

	public List<SelectItem> getContractStatusTab1List() {
		return contractStatusTab1List;
	}

	public void setContractStatusTab1List(List<SelectItem> contractStatusTab1List) {
		this.contractStatusTab1List = contractStatusTab1List;
	}

	public String getTabHeader() {
		return tabHeader;
	}

	public void setTabHeader(String tabHeader) {
		this.tabHeader = tabHeader;
	}

	public List<SelectItem> getContractLostStatusList() {
		return contractLostStatusList;
	}

	public void setContractLostStatusList(List<SelectItem> contractLostStatusList) {
		this.contractLostStatusList = contractLostStatusList;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public boolean isRenderedAttachment() {
		return renderedAttachment;
	}

	public void setRenderedAttachment(boolean renderedAttachment) {
		this.renderedAttachment = renderedAttachment;
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

	public boolean isRenderedColDel() {
		return renderedColDel;
	}

	public void setRenderedColDel(boolean renderedColDel) {
		this.renderedColDel = renderedColDel;
	}

	public String getFromInitPage() {
		return fromInitPage;
	}

	public void setFromInitPage(String fromInitPage) {
		this.fromInitPage = fromInitPage;
	}

	public String getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(String groupNumber) {
		this.groupNumber = groupNumber;
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

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public List<SelectItem> getContractStatusList() {
		return contractStatusList;
	}

	public void setContractStatusList(List<SelectItem> contractStatusList) {
		this.contractStatusList = contractStatusList;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public boolean isDisabledBtnAdd() {
		return disabledBtnAdd;
	}

	public void setDisabledBtnAdd(boolean disabledBtnAdd) {
		this.disabledBtnAdd = disabledBtnAdd;
	}

	public ContractStatus getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(ContractStatus contractStatus) {
		this.contractStatus = contractStatus;
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

	public List<SelectItem> getBorrowOfficerList() {
		return borrowOfficerList;
	}

	public void setBorrowOfficerList(List<SelectItem> borrowOfficerList) {
		this.borrowOfficerList = borrowOfficerList;
	}

	public String getSelectedStatus() {
		return selectedStatus;
	}

	public void setSelectedStatus(String selectedStatus) {
		this.selectedStatus = selectedStatus;
	}

	public boolean isChkSelAll() {
		return chkSelAll;
	}

	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}

	public boolean isDisableSelectAll() {
		return disableSelectAll;
	}

	public void setDisableSelectAll(boolean disableSelectAll) {
		this.disableSelectAll = disableSelectAll;
	}

	public Mco004UpdateDuty getMco004UpdateDuty() {
		return mco004UpdateDuty;
	}

	public void setMco004UpdateDuty(Mco004UpdateDuty mco004UpdateDuty) {
		this.mco004UpdateDuty = mco004UpdateDuty;
	}

	public String getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}
  
 	
}
