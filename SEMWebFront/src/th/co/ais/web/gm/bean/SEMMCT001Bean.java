package th.co.ais.web.gm.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.gm.Bank;
import th.co.ais.domain.gm.CT001ExportBank;
import th.co.ais.domain.gm.CT001SrchMSP;
import th.co.ais.domain.gm.PayeeBookbank;
import th.co.ais.domain.gm.PayeeMaster;
import th.co.ais.domain.gm.PayeeMasterSP;
import th.co.ais.domain.gm.VendorBookbank;
import th.co.ais.domain.gm.VendorMapPayee;
import th.co.ais.domain.gm.VendorMaster;
import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.service.util.ServiceConstants;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;
import th.co.ais.web.bean.TreeUtilBean;

public class SEMMCT001Bean extends AbstractBean {

	private static final long serialVersionUID = -257004826763506625L;
	
	//for search criteria
	private VendorMasterSP criteriaVendorSP;
	private VendorMasterSP vendorSP;
	private Bank criteriaBank;
	
	//for edit data
	private VendorMaster vendorMaster;
	private PayeeMaster payeeMaster;
	
	//for display when click edit in payee list ct001-2
	private CT001SrchMSP ct001SrchMSP;
	//for edit data in payee list ct001-2
	private VendorBookbank vendorBookBank;
	//for edit data in payee list ct001-3
	private PayeeBookbank payeeBookBank;
	
	private VendorMapPayee vendorMapPayee;
	
	//select Item ct001-1
	private List<SelectItem> vendorStatusSelList;
	private List<SelectItem> bookbankStatusSelList;
	
	//select Item ct001-2
	private List<SelectItem> vendorTypeStatus;
	private List<SelectItem> provinceSelList;
	private List<SelectItem> amphurSelList;
	private List<SelectItem> expenseTypeSelList;
	private List<SelectItem> bankAccountSelList;
	//added by NEW
	private List<SelectItem> blockFlagSelList;
	private List<SelectItem> dupStatusSelList;
	private String dupStatus;
	
	// fixed by.. YUT ->
	private List<SelectItem> bankProvinceSelList;
	
	private List<SelectItem> amphurVendorSelList;
	private List<SelectItem> amphurRntSelList;
	private List<SelectItem> amphurElcSelList;
	private List<SelectItem> amphurTaxSelList;
	private List<SelectItem> amphurInsSelList;
	
	private List<SelectItem> districtVendorSelList;
	private List<SelectItem> districtRntSelList;
	private List<SelectItem> districtElcSelList;
	private List<SelectItem> districtTaxSelList;
	private List<SelectItem> districtInsSelList;
	
	private boolean chkRenderMstAmphurFreeFill;
	private boolean chkRenderRntAmphurFreeFill;
	private boolean chkRenderElcAmphurFreeFill;
	private boolean chkRenderTaxAmphurFreeFill;
	private boolean chkRenderInsAmphurFreeFill;
	private boolean chkRenderPayeeAmphurFreeFill;
	
	private boolean chkRenderMstDistrictFreeFill;
	private boolean chkRenderRntDistrictFreeFill;
	private boolean chkRenderElcDistrictFreeFill;
	private boolean chkRenderTaxDistrictFreeFill;
	private boolean chkRenderInsDistrictFreeFill;
	private boolean chkRenderPayeeDistrictFreeFill;
	
	public List<WrapperBeanObject<VendorMasterSP>> vendorMasterPopupList;
	private VendorMasterSP vendorMasterPopupObjParam;
	private VendorMasterSP vendorMasterHistorySummary;
	
	public List<WrapperBeanObject<VendorMasterSP>> vendorMasterHistoryList;
	public List<WrapperBeanObject<VendorMasterSP>> bookbankHistoryList;
	
	private boolean disabledButtonHistory = true;
	// <-
	
	//data table
	public List<WrapperBeanObject<VendorMasterSP>> vendorMasterList;
	//data table select vendor in pop up
	public List<VendorMasterSP> vendorMasterSelList;
	//data table select payee in pop up
	public List<PayeeMasterSP> payeeMasterSelList;
	//data table select vendor book bank in pop up
	public List<Bank> bankSelList;
	public List<Bank> bankTmpSelList;
	private String selectedRadio = "";
	
	//data table ct001-2
	public List<WrapperBeanObject<CT001SrchMSP>> ct001SrchMSPList;
	
	//rendered pop up select vendor
	private boolean renderedSelectVendorPopup = false;
	private boolean renderedSelectPayeePopup = false;
	//force to input bank information in case , bank is not found when user kep on.
	private boolean isForceInputBankInfo = false; 
	private boolean isNewBankInfo = false;
	private boolean isDisabledBankInfo = false;
	
	//Export Excel
	private boolean chkSelAll = false;
	
	private String mode = ServiceConstants.MODULE_ACTION_INSERT;
	private String modePanelInfo = ServiceConstants.MODULE_ACTION_INSERT;
	
	
	//rendered require 
	private boolean renderedRequireIdCard = false;
	private boolean renderedRequireTaxId = false;
	//disabled button add alternative payee
	private boolean disabledButtonAddAlter = false;
	private boolean disabledButtonApprove = true;
	private boolean disabledButtonAddPayee = true;
	private boolean disabledButtonDelVendor = true;
	private boolean disabledButtonDelPayee = true;
	
	//for copy vendor address.
	private String tmpVendorMasterId;
	//for set size of table VendorMapPayee size
	private int vendorMapSize = 0;
	
	private boolean isVendorExisted;
	private boolean disbledCheckVendorButton;
	
	private Bank newBank;
	
	//temp lessor Id
	private String tmpLessorId;
	private boolean pTaxFlag = false;
	private boolean pElTaxFlag = false;
	private boolean pPtTaxFlag = false;
	private boolean pRtTaxFlag = false;
	
	//temp Contract No For button OwnerDetail
	private String tmpContractNo;
	private String tmpExpenseType;
	
	//Data Grid popup SearchVendor
	private List<VendorMasterSP> popupVendorList;
	private boolean renderPopupVendorMsg = false;
	
	private String deleteMode;
	
	private boolean backFlag;
	
	private boolean disableSaveBtn;
	private boolean disableSavePayeeBtn;
	private boolean renderSapLabel = false;
	private boolean displayReport = false;
	private List<CT001ExportBank> ct001ExBankList;
	
	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	
	private List<SelectItem> hqList;
	private boolean hqDisable = false;
	private boolean renderedHqFlag = false;
	private boolean reRenderVenderBank = false;
	private boolean reRenderBankAcc = false;
	
	private List<SelectItem> provSelList;
	private List<SelectItem> ampSelList;
	private List<SelectItem> districtSelList;
	
	private String tmpVendorMapPayeeId;
	
	private String tmpBatch;
	private Date tmpBatchDT;
	
	private List<SelectItem> payeeStatusSelList;
	private List<SelectItem> payeeBookbankStatusSelList;
	
	//added by NEW 20511019
	private boolean disabledExportVendorBtn = true;
	private boolean disabledExportVendorBookbankBtn = true;
	private boolean disabledExportPayeeBtn = true;
	private boolean disabledExportPayeeBookbankBtn = true;
	private boolean renderedBackBtn = true;
	private boolean renderedBackCrossPageBtn = false;
	private boolean renderedViewBtn = true;
	private boolean renderedViewCrossPageBtn = false;
	private String type;
	private String status;
	
	private TreeUtilBean treeUtilBean;
	//added by NEW 20151030
	public boolean treeMacroFlag = false;
	public String headerTreeMacro;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreeMacroList;
	
	public boolean treePicoFlag = false;
	public String headerTreePico;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreePicoList;
	
	public List<WrapperBeanObject<CT001ExportBank>> rejectPopupObjParamList;
	public CT001ExportBank rejectPopupObjParam;
	
	public boolean renderedOnToDoList = false;
	
	public String getTmpLessorId() {
		return tmpLessorId;
	}
	public void setTmpLessorId(String tmpLessorId) {
		this.tmpLessorId = tmpLessorId;
	}
	
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	public List<WrapperBeanObject<VendorMasterSP>> getVendorMasterList() {
		if(vendorMasterList == null)
			vendorMasterList = new ArrayList<WrapperBeanObject<VendorMasterSP>>();
		return vendorMasterList;
	}
	public void setVendorMasterList(
			List<WrapperBeanObject<VendorMasterSP>> vendorMasterList) {
		this.vendorMasterList = vendorMasterList;
	}
	
	public List<VendorMasterSP> getVendorMasterSelList() {
		if(vendorMasterSelList == null)
			vendorMasterSelList = new ArrayList<VendorMasterSP>();
		return vendorMasterSelList;
	}
	public void setVendorMasterSelList(List<VendorMasterSP> vendorMasterSelList) {
		this.vendorMasterSelList = vendorMasterSelList;
	}
	
	public List<PayeeMasterSP> getPayeeMasterSelList() {
		if(payeeMasterSelList == null)
			payeeMasterSelList = new ArrayList<PayeeMasterSP>();
		return payeeMasterSelList;
	}
	public void setPayeeMasterSelList(List<PayeeMasterSP> payeeMasterSelList) {
		this.payeeMasterSelList = payeeMasterSelList;
	}
	public List<Bank> getBankSelList() {
		if(bankSelList == null)
			bankSelList = new ArrayList<Bank>();
		return bankSelList;
	}
	public void setBankSelList(List<Bank> bankSelList) {
		this.bankSelList = bankSelList;
	}
	
	public List<Bank> getBankTmpSelList() {
		if(bankTmpSelList == null)
			bankTmpSelList = new ArrayList<Bank>();
		return bankTmpSelList;
	}
	public void setBankTmpSelList(List<Bank> bankTmpSelList) {
		this.bankTmpSelList = bankTmpSelList;
	}
	public VendorMasterSP getCriteriaVendorSP() {
		if(criteriaVendorSP == null)
			criteriaVendorSP = new VendorMasterSP();
		return criteriaVendorSP;
	}
	public void setCriteriaVendorSP(VendorMasterSP criteriaVendorSP) {
		this.criteriaVendorSP = criteriaVendorSP;
	}
	public VendorMaster getVendorMaster() {
		if(vendorMaster == null){
			vendorMaster = new VendorMaster();
		}
		return vendorMaster;
	}
	public void setVendorMaster(VendorMaster vendorMaster) {
		this.vendorMaster = vendorMaster;
	}
	
	public PayeeMaster getPayeeMaster() {
		if(payeeMaster == null){
			payeeMaster = new PayeeMaster();
		}
		return payeeMaster;
	}
	public void setPayeeMaster(PayeeMaster payeeMaster) {
		this.payeeMaster = payeeMaster;
	}
	public List<SelectItem> getVendorStatusSelList() {
		if(vendorStatusSelList == null)
			vendorStatusSelList = new LinkedList<SelectItem>();
		return vendorStatusSelList;
	}
	public void setVendorStatusSelList(List<SelectItem> vendorStatusSelList) {
		this.vendorStatusSelList = vendorStatusSelList;
	}
	public List<SelectItem> getBookbankStatusSelList() {
		if(bookbankStatusSelList == null)
			bookbankStatusSelList = new LinkedList<SelectItem>();
		return bookbankStatusSelList;
	}
	public void setBookbankStatusSelList(List<SelectItem> bookbankStatusSelList) {
		this.bookbankStatusSelList = bookbankStatusSelList;
	}
	
	public boolean isChkSelAll() {
		return chkSelAll;
	}
	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}
	
	public VendorBookbank getVendorBookBank() {
		if(vendorBookBank == null)
			vendorBookBank = new VendorBookbank();
		return vendorBookBank;
	}
	public void setVendorBookBank(VendorBookbank vendorBookBank) {
		this.vendorBookBank = vendorBookBank;
	}
	
	public PayeeBookbank getPayeeBookBank() {
		if(payeeBookBank == null)
			payeeBookBank = new PayeeBookbank();
		return payeeBookBank;
	}
	public void setPayeeBookBank(PayeeBookbank payeeBookBank) {
		this.payeeBookBank = payeeBookBank;
	}
	public VendorMapPayee getVendorMapPayee() {
		if(vendorMapPayee == null)
			vendorMapPayee = new VendorMapPayee();
		return vendorMapPayee;
	}
	public void setVendorMapPayee(VendorMapPayee vendorMapPayee) {
		this.vendorMapPayee = vendorMapPayee;
	}
	
	public List<SelectItem> getVendorTypeStatus() {
		if(vendorTypeStatus == null)
			vendorTypeStatus = new LinkedList<SelectItem>();
		return vendorTypeStatus;
	}
	public void setVendorTypeStatus(List<SelectItem> vendorTypeStatus) {
		this.vendorTypeStatus = vendorTypeStatus;
	}
	public List<SelectItem> getProvinceSelList() {
		if(provinceSelList == null)
			provinceSelList = new LinkedList<SelectItem>();
		return provinceSelList;
	}
	public void setProvinceSelList(List<SelectItem> provinceSelList) {
		this.provinceSelList = provinceSelList;
	}
	public List<SelectItem> getAmphurSelList() {
		if(amphurSelList == null)
			amphurSelList = new LinkedList<SelectItem>();
		return amphurSelList;
	}
	public void setAmphurSelList(List<SelectItem> amphurSelList) {
		this.amphurSelList = amphurSelList;
	}
	public List<SelectItem> getAmphurVendorSelList() {
		if(amphurVendorSelList == null)
			amphurVendorSelList = new LinkedList<SelectItem>();
		return amphurVendorSelList;
	}
	public void setAmphurVendorSelList(List<SelectItem> amphurVendorSelList) {
		this.amphurVendorSelList = amphurVendorSelList;
	}
	public List<SelectItem> getAmphurRntSelList() {
		if(amphurRntSelList == null)
			amphurRntSelList = new LinkedList<SelectItem>();
		return amphurRntSelList;
	}
	public void setAmphurRntSelList(List<SelectItem> amphurRntSelList) {
		this.amphurRntSelList = amphurRntSelList;
	}
	public List<SelectItem> getAmphurElcSelList() {
		if(amphurElcSelList == null)
			amphurElcSelList = new LinkedList<SelectItem>();
		return amphurElcSelList;
	}
	public void setAmphurElcSelList(List<SelectItem> amphurElcSelList) {
		this.amphurElcSelList = amphurElcSelList;
	}
	public List<SelectItem> getAmphurTaxSelList() {
		if(amphurTaxSelList == null)
			amphurTaxSelList = new LinkedList<SelectItem>();
		return amphurTaxSelList;
	}
	public void setAmphurTaxSelList(List<SelectItem> amphurTaxSelList) {
		this.amphurTaxSelList = amphurTaxSelList;
	}
	public List<SelectItem> getAmphurInsSelList() {
		if(amphurInsSelList == null)
			amphurInsSelList = new LinkedList<SelectItem>();
		return amphurInsSelList;
	}
	public void setAmphurInsSelList(List<SelectItem> amphurInsSelList) {
		this.amphurInsSelList = amphurInsSelList;
	}
	public List<SelectItem> getDistrictVendorSelList() {
		if(districtVendorSelList == null)
			districtVendorSelList = new LinkedList<SelectItem>();
		return districtVendorSelList;
	}
	public void setDistrictVendorSelList(List<SelectItem> districtVendorSelList) {
		this.districtVendorSelList = districtVendorSelList;
	}
	public List<SelectItem> getDistrictRntSelList() {
		if(districtRntSelList == null)
			districtRntSelList = new LinkedList<SelectItem>();
		return districtRntSelList;
	}
	public void setDistrictRntSelList(List<SelectItem> districtRntSelList) {
		this.districtRntSelList = districtRntSelList;
	}
	public List<SelectItem> getDistrictElcSelList() {
		if(districtElcSelList == null)
			districtElcSelList = new LinkedList<SelectItem>();
		return districtElcSelList;
	}
	public void setDistrictElcSelList(List<SelectItem> districtElcSelList) {
		this.districtElcSelList = districtElcSelList;
	}
	public List<SelectItem> getDistrictTaxSelList() {
		if(districtTaxSelList == null)
			districtTaxSelList = new LinkedList<SelectItem>();
		return districtTaxSelList;
	}
	public void setDistrictTaxSelList(List<SelectItem> districtTaxSelList) {
		this.districtTaxSelList = districtTaxSelList;
	}
	public List<SelectItem> getDistrictInsSelList() {
		if(districtInsSelList == null)
			districtInsSelList = new LinkedList<SelectItem>();
		return districtInsSelList;
	}
	public void setDistrictInsSelList(List<SelectItem> districtInsSelList) {
		this.districtInsSelList = districtInsSelList;
	}
	public List<SelectItem> getBankProvinceSelList() {
		if(bankProvinceSelList == null)
			bankProvinceSelList = new LinkedList<SelectItem>();
		return bankProvinceSelList;
	}
	public void setBankProvinceSelList(List<SelectItem> bankProvinceSelList) {
		this.bankProvinceSelList = bankProvinceSelList;
	}
	public List<SelectItem> getExpenseTypeSelList() {
		if(expenseTypeSelList == null)
			expenseTypeSelList = new LinkedList<SelectItem>();
		return expenseTypeSelList;
	}
	public void setExpenseTypeSelList(List<SelectItem> expenseTypeSelList) {
		this.expenseTypeSelList = expenseTypeSelList;
	}
	public List<SelectItem> getBankAccountSelList() {
		if(bankAccountSelList == null)
			bankAccountSelList = new LinkedList<SelectItem>();
		return bankAccountSelList;
	}
	public void setBankAccountSelList(List<SelectItem> bankAccountSelList) {
		this.bankAccountSelList = bankAccountSelList;
	}
	
	public CT001SrchMSP getCt001SrchMSP() {
		if(ct001SrchMSP == null)
			ct001SrchMSP = new CT001SrchMSP();
		return ct001SrchMSP;
	}
	public void setCt001SrchMSP(CT001SrchMSP ct001SrchMSP) {
		this.ct001SrchMSP = ct001SrchMSP;
	}
	
	public List<WrapperBeanObject<CT001SrchMSP>> getCt001SrchMSPList() {
		if(ct001SrchMSPList == null)
			ct001SrchMSPList = new ArrayList<WrapperBeanObject<CT001SrchMSP>>();
		return ct001SrchMSPList;
	}
	public void setCt001SrchMSPList(
			List<WrapperBeanObject<CT001SrchMSP>> ct001SrchMSPList) {
		this.ct001SrchMSPList = ct001SrchMSPList;
	}
	
	public boolean isRenderedSelectVendorPopup() {
		return renderedSelectVendorPopup;
	}
	public void setRenderedSelectVendorPopup(boolean renderedSelectVendorPopup) {
		this.renderedSelectVendorPopup = renderedSelectVendorPopup;
	}
	public boolean isRenderedSelectPayeePopup() {
		return renderedSelectPayeePopup;
	}
	public void setRenderedSelectPayeePopup(boolean renderedSelectPayeePopup) {
		this.renderedSelectPayeePopup = renderedSelectPayeePopup;
	}
	
	public boolean isForceInputBankInfo() {
		return isForceInputBankInfo;
	}
	public void setForceInputBankInfo(boolean isForceInputBankInfo) {
		this.isForceInputBankInfo = isForceInputBankInfo;
	}
	public String getSelectedRadio() {
		return selectedRadio;
	}
	public void setSelectedRadio(String selectedRadio) {
		this.selectedRadio = selectedRadio;
	}
	
	public Bank getCriteriaBank() {
		if(criteriaBank == null)
			criteriaBank = new Bank();
		return criteriaBank;
	}
	public void setCriteriaBank(Bank criteriaBank) {
		this.criteriaBank = criteriaBank;
	}
	
	public String getModePanelInfo() {
		return modePanelInfo;
	}
	public void setModePanelInfo(String modePanelInfo) {
		this.modePanelInfo = modePanelInfo;
	}
	
	public boolean isRenderedRequireIdCard() {
		return renderedRequireIdCard;
	}
	public void setRenderedRequireIdCard(boolean renderedRequireIdCard) {
		this.renderedRequireIdCard = renderedRequireIdCard;
	}
	public boolean isRenderedRequireTaxId() {
		return renderedRequireTaxId;
	}
	public void setRenderedRequireTaxId(boolean renderedRequireTaxId) {
		this.renderedRequireTaxId = renderedRequireTaxId;
	}
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public String getTmpVendorMasterId() {
		return tmpVendorMasterId;
	}
	public void setTmpVendorMasterId(String tmpVendorMasterId) {
		this.tmpVendorMasterId = tmpVendorMasterId;
	}
	public int getVendorMapSize() {
		return vendorMapSize;
	}
	public void setVendorMapSize(int vendorMapSize) {
		this.vendorMapSize = vendorMapSize;
	}
	public boolean isVendorExisted() {
		return isVendorExisted;
	}
	public void setVendorExisted(boolean isVendorExisted) {
		this.isVendorExisted = isVendorExisted;
	}
	public boolean isDisbledCheckVendorButton() {
		return disbledCheckVendorButton;
	}
	public void setDisbledCheckVendorButton(boolean disbledCheckVendorButton) {
		this.disbledCheckVendorButton = disbledCheckVendorButton;
	}
	public boolean isDisabledButtonAddAlter() {
		return disabledButtonAddAlter;
	}
	public void setDisabledButtonAddAlter(boolean disabledButtonAddAlter) {
		this.disabledButtonAddAlter = disabledButtonAddAlter;
	}
	public boolean isNewBankInfo() {
		return isNewBankInfo;
	}
	public void setNewBankInfo(boolean isNewBankInfo) {
		this.isNewBankInfo = isNewBankInfo;
	}
	public Bank getNewBank() {
		return newBank;
	}
	public void setNewBank(Bank newBank) {
		this.newBank = newBank;
	}
	public boolean ispTaxFlag() {
		return pTaxFlag;
	}
	public void setpTaxFlag(boolean pTaxFlag) {
		this.pTaxFlag = pTaxFlag;
	}
	public boolean isDisabledButtonApprove() {
		return disabledButtonApprove;
	}
	public void setDisabledButtonApprove(boolean disabledButtonApprove) {
		this.disabledButtonApprove = disabledButtonApprove;
	}
	public boolean isDisabledButtonAddPayee() {
		return disabledButtonAddPayee;
	}
	public void setDisabledButtonAddPayee(boolean disabledButtonAddPayee) {
		this.disabledButtonAddPayee = disabledButtonAddPayee;
	}
	public boolean isDisabledBankInfo() {
		return isDisabledBankInfo;
	}
	public void setDisabledBankInfo(boolean isDisabledBankInfo) {
		this.isDisabledBankInfo = isDisabledBankInfo;
	}
	public String getTmpContractNo() {
		return tmpContractNo;
	}
	public void setTmpContractNo(String tmpContractNo) {
		this.tmpContractNo = tmpContractNo;
	}
	public String getTmpExpenseType() {
		return tmpExpenseType;
	}
	public void setTmpExpenseType(String tmpExpenseType) {
		this.tmpExpenseType = tmpExpenseType;
	}
	public List<VendorMasterSP> getPopupVendorList() {
		return popupVendorList;
	}
	public void setPopupVendorList(List<VendorMasterSP> popupVendorList) {
		this.popupVendorList = popupVendorList;
	}
	public boolean isRenderPopupVendorMsg() {
		return renderPopupVendorMsg;
	}
	public void setRenderPopupVendorMsg(boolean renderPopupVendorMsg) {
		this.renderPopupVendorMsg = renderPopupVendorMsg;
	}
	public String getDeleteMode() {
		return deleteMode;
	}
	public void setDeleteMode(String deleteMode) {
		this.deleteMode = deleteMode;
	}
	public boolean isBackFlag() {
		return backFlag;
	}
	public void setBackFlag(boolean backFlag) {
		this.backFlag = backFlag;
	}
	public boolean isDisableSaveBtn() {
		return disableSaveBtn;
	}
	public void setDisableSaveBtn(boolean disableSaveBtn) {
		this.disableSaveBtn = disableSaveBtn;
	}
	public boolean isDisableSavePayeeBtn() {
		return disableSavePayeeBtn;
	}
	public void setDisableSavePayeeBtn(boolean disableSavePayeeBtn) {
		this.disableSavePayeeBtn = disableSavePayeeBtn;
	}
	public boolean isRenderSapLabel() {
		return renderSapLabel;
	}
	public void setRenderSapLabel(boolean renderSapLabel) {
		this.renderSapLabel = renderSapLabel;
	}
	public boolean isDisplayReport() {
		return displayReport;
	}
	public void setDisplayReport(boolean displayReport) {
		this.displayReport = displayReport;
	}
	public List<CT001ExportBank> getCt001ExBankList() {
		return ct001ExBankList;
	}
	public void setCt001ExBankList(List<CT001ExportBank> ct001ExBankList) {
		this.ct001ExBankList = ct001ExBankList;
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
	public List<SelectItem> getHqList() {
		return hqList;
	}
	public void setHqList(List<SelectItem> hqList) {
		this.hqList = hqList;
	}
	public boolean isHqDisable() {
		return hqDisable;
	}
	public void setHqDisable(boolean hqDisable) {
		this.hqDisable = hqDisable;
	}
	public boolean isRenderedHqFlag() {
		return renderedHqFlag;
	}
	public void setRenderedHqFlag(boolean renderedHqFlag) {
		this.renderedHqFlag = renderedHqFlag;
	}
	public boolean isReRenderVenderBank() {
		return reRenderVenderBank;
	}
	public void setReRenderVenderBank(boolean reRenderVenderBank) {
		this.reRenderVenderBank = reRenderVenderBank;
	}
	public boolean isReRenderBankAcc() {
		return reRenderBankAcc;
	}
	public void setReRenderBankAcc(boolean reRenderBankAcc) {
		this.reRenderBankAcc = reRenderBankAcc;
	}
	public boolean ispElTaxFlag() {
		return pElTaxFlag;
	}
	public void setpElTaxFlag(boolean pElTaxFlag) {
		this.pElTaxFlag = pElTaxFlag;
	}
	public boolean ispPtTaxFlag() {
		return pPtTaxFlag;
	}
	public void setpPtTaxFlag(boolean pPtTaxFlag) {
		this.pPtTaxFlag = pPtTaxFlag;
	}
	public boolean ispRtTaxFlag() {
		return pRtTaxFlag;
	}
	public void setpRtTaxFlag(boolean pRtTaxFlag) {
		this.pRtTaxFlag = pRtTaxFlag;
	}
	public List<SelectItem> getProvSelList() {
		return provSelList;
	}
	public void setProvSelList(List<SelectItem> provSelList) {
		this.provSelList = provSelList;
	}
	public List<SelectItem> getAmpSelList() {
		return ampSelList;
	}
	public void setAmpSelList(List<SelectItem> ampSelList) {
		this.ampSelList = ampSelList;
	}
	public List<SelectItem> getDistrictSelList() {
		return districtSelList;
	}
	public void setDistrictSelList(List<SelectItem> districtSelList) {
		this.districtSelList = districtSelList;
	}
	public VendorMasterSP getVendorSP() {
		return vendorSP;
	}
	public void setVendorSP(VendorMasterSP vendorSP) {
		this.vendorSP = vendorSP;
	}
	public String getTmpVendorMapPayeeId() {
		return tmpVendorMapPayeeId;
	}
	public void setTmpVendorMapPayeeId(String tmpVendorMapPayeeId) {
		this.tmpVendorMapPayeeId = tmpVendorMapPayeeId;
	}
	public String getTmpBatch() {
		return tmpBatch;
	}
	public void setTmpBatch(String tmpBatch) {
		this.tmpBatch = tmpBatch;
	}
	public Date getTmpBatchDT() {
		return tmpBatchDT;
	}
	public void setTmpBatchDT(Date tmpBatchDT) {
		this.tmpBatchDT = tmpBatchDT;
	}
	public List<SelectItem> getPayeeStatusSelList() {
		return payeeStatusSelList;
	}
	public void setPayeeStatusSelList(List<SelectItem> payeeStatusSelList) {
		this.payeeStatusSelList = payeeStatusSelList;
	}
	public List<SelectItem> getPayeeBookbankStatusSelList() {
		return payeeBookbankStatusSelList;
	}
	public void setPayeeBookbankStatusSelList(
			List<SelectItem> payeeBookbankStatusSelList) {
		this.payeeBookbankStatusSelList = payeeBookbankStatusSelList;
	}
	public boolean isChkRenderMstAmphurFreeFill() {
		return chkRenderMstAmphurFreeFill;
	}
	public void setChkRenderMstAmphurFreeFill(boolean chkRenderMstAmphurFreeFill) {
		this.chkRenderMstAmphurFreeFill = chkRenderMstAmphurFreeFill;
	}
	public boolean isChkRenderRntAmphurFreeFill() {
		return chkRenderRntAmphurFreeFill;
	}
	public void setChkRenderRntAmphurFreeFill(boolean chkRenderRntAmphurFreeFill) {
		this.chkRenderRntAmphurFreeFill = chkRenderRntAmphurFreeFill;
	}
	public boolean isChkRenderElcAmphurFreeFill() {
		return chkRenderElcAmphurFreeFill;
	}
	public void setChkRenderElcAmphurFreeFill(boolean chkRenderElcAmphurFreeFill) {
		this.chkRenderElcAmphurFreeFill = chkRenderElcAmphurFreeFill;
	}
	public boolean isChkRenderTaxAmphurFreeFill() {
		return chkRenderTaxAmphurFreeFill;
	}
	public void setChkRenderTaxAmphurFreeFill(boolean chkRenderTaxAmphurFreeFill) {
		this.chkRenderTaxAmphurFreeFill = chkRenderTaxAmphurFreeFill;
	}
	public boolean isChkRenderInsAmphurFreeFill() {
		return chkRenderInsAmphurFreeFill;
	}
	public void setChkRenderInsAmphurFreeFill(boolean chkRenderInsAmphurFreeFill) {
		this.chkRenderInsAmphurFreeFill = chkRenderInsAmphurFreeFill;
	}
	public boolean isChkRenderMstDistrictFreeFill() {
		return chkRenderMstDistrictFreeFill;
	}
	public void setChkRenderMstDistrictFreeFill(boolean chkRenderMstDistrictFreeFill) {
		this.chkRenderMstDistrictFreeFill = chkRenderMstDistrictFreeFill;
	}
	public boolean isChkRenderRntDistrictFreeFill() {
		return chkRenderRntDistrictFreeFill;
	}
	public void setChkRenderRntDistrictFreeFill(boolean chkRenderRntDistrictFreeFill) {
		this.chkRenderRntDistrictFreeFill = chkRenderRntDistrictFreeFill;
	}
	public boolean isChkRenderElcDistrictFreeFill() {
		return chkRenderElcDistrictFreeFill;
	}
	public void setChkRenderElcDistrictFreeFill(boolean chkRenderElcDistrictFreeFill) {
		this.chkRenderElcDistrictFreeFill = chkRenderElcDistrictFreeFill;
	}
	public boolean isChkRenderTaxDistrictFreeFill() {
		return chkRenderTaxDistrictFreeFill;
	}
	public void setChkRenderTaxDistrictFreeFill(boolean chkRenderTaxDistrictFreeFill) {
		this.chkRenderTaxDistrictFreeFill = chkRenderTaxDistrictFreeFill;
	}
	public boolean isChkRenderInsDistrictFreeFill() {
		return chkRenderInsDistrictFreeFill;
	}
	public void setChkRenderInsDistrictFreeFill(boolean chkRenderInsDistrictFreeFill) {
		this.chkRenderInsDistrictFreeFill = chkRenderInsDistrictFreeFill;
	}
	public List<WrapperBeanObject<VendorMasterSP>> getVendorMasterPopupList() {
		if(vendorMasterPopupList == null)
			vendorMasterPopupList = new ArrayList<WrapperBeanObject<VendorMasterSP>>();
		return vendorMasterPopupList;
	}
	public void setVendorMasterPopupList(
			List<WrapperBeanObject<VendorMasterSP>> vendorMasterPopupList) {
		this.vendorMasterPopupList = vendorMasterPopupList;
	}
	public VendorMasterSP getVendorMasterPopupObjParam() {
		if(vendorMasterPopupObjParam == null)
			vendorMasterPopupObjParam = new VendorMasterSP();
		return vendorMasterPopupObjParam;
	}
	public void setVendorMasterPopupObjParam(
			VendorMasterSP vendorMasterPopupObjParam) {
		this.vendorMasterPopupObjParam = vendorMasterPopupObjParam;
	}
	public VendorMasterSP getVendorMasterHistorySummary() {
		if(vendorMasterHistorySummary == null)
			vendorMasterHistorySummary = new VendorMasterSP();
		return vendorMasterHistorySummary;
	}
	public void setVendorMasterHistorySummary(VendorMasterSP vendorMasterHistorySummary) {
		this.vendorMasterHistorySummary = vendorMasterHistorySummary;
	}
	public List<WrapperBeanObject<VendorMasterSP>> getVendorMasterHistoryList() {
		if(vendorMasterHistoryList == null)
			vendorMasterHistoryList = new ArrayList<WrapperBeanObject<VendorMasterSP>>();
		return vendorMasterHistoryList;
	}
	public void setVendorMasterHistoryList(
			List<WrapperBeanObject<VendorMasterSP>> vendorMasterHistoryList) {
		this.vendorMasterHistoryList = vendorMasterHistoryList;
	}
	public List<WrapperBeanObject<VendorMasterSP>> getBookbankHistoryList() {
		if(bookbankHistoryList == null)
			bookbankHistoryList = new ArrayList<WrapperBeanObject<VendorMasterSP>>();
		return bookbankHistoryList;
	}
	public void setBookbankHistoryList(
			List<WrapperBeanObject<VendorMasterSP>> bookbankHistoryList) {
		this.bookbankHistoryList = bookbankHistoryList;
	}
	public boolean isDisabledButtonHistory() {
		return disabledButtonHistory;
	}
	public void setDisabledButtonHistory(boolean disabledButtonHistory) {
		this.disabledButtonHistory = disabledButtonHistory;
	}
	public boolean isDisabledExportVendorBtn() {
		return disabledExportVendorBtn;
	}
	public void setDisabledExportVendorBtn(boolean disabledExportVendorBtn) {
		this.disabledExportVendorBtn = disabledExportVendorBtn;
	}
	public boolean isDisabledExportVendorBookbankBtn() {
		return disabledExportVendorBookbankBtn;
	}
	public void setDisabledExportVendorBookbankBtn(
			boolean disabledExportVendorBookbankBtn) {
		this.disabledExportVendorBookbankBtn = disabledExportVendorBookbankBtn;
	}
	public boolean isDisabledExportPayeeBtn() {
		return disabledExportPayeeBtn;
	}
	public void setDisabledExportPayeeBtn(boolean disabledExportPayeeBtn) {
		this.disabledExportPayeeBtn = disabledExportPayeeBtn;
	}
	public boolean isDisabledExportPayeeBookbankBtn() {
		return disabledExportPayeeBookbankBtn;
	}
	public void setDisabledExportPayeeBookbankBtn(
			boolean disabledExportPayeeBookbankBtn) {
		this.disabledExportPayeeBookbankBtn = disabledExportPayeeBookbankBtn;
	}
	public boolean isChkRenderPayeeAmphurFreeFill() {
		return chkRenderPayeeAmphurFreeFill;
	}
	public void setChkRenderPayeeAmphurFreeFill(boolean chkRenderPayeeAmphurFreeFill) {
		this.chkRenderPayeeAmphurFreeFill = chkRenderPayeeAmphurFreeFill;
	}
	public boolean isChkRenderPayeeDistrictFreeFill() {
		return chkRenderPayeeDistrictFreeFill;
	}
	public void setChkRenderPayeeDistrictFreeFill(
			boolean chkRenderPayeeDistrictFreeFill) {
		this.chkRenderPayeeDistrictFreeFill = chkRenderPayeeDistrictFreeFill;
	}
	public boolean isRenderedBackBtn() {
		return renderedBackBtn;
	}
	public void setRenderedBackBtn(boolean renderedBackBtn) {
		this.renderedBackBtn = renderedBackBtn;
	}
	public boolean isRenderedBackCrossPageBtn() {
		return renderedBackCrossPageBtn;
	}
	public void setRenderedBackCrossPageBtn(boolean renderedBackCrossPageBtn) {
		this.renderedBackCrossPageBtn = renderedBackCrossPageBtn;
	}
	public boolean isRenderedViewBtn() {
		return renderedViewBtn;
	}
	public void setRenderedViewBtn(boolean renderedViewBtn) {
		this.renderedViewBtn = renderedViewBtn;
	}
	public boolean isRenderedViewCrossPageBtn() {
		return renderedViewCrossPageBtn;
	}
	public void setRenderedViewCrossPageBtn(boolean renderedViewCrossPageBtn) {
		this.renderedViewCrossPageBtn = renderedViewCrossPageBtn;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public List<WrapperBeanObject<CT001ExportBank>> getRejectPopupObjParamList() {
		return rejectPopupObjParamList;
	}
	public void setRejectPopupObjParamList(
			List<WrapperBeanObject<CT001ExportBank>> rejectPopupObjParamList) {
		this.rejectPopupObjParamList = rejectPopupObjParamList;
	}
	public CT001ExportBank getRejectPopupObjParam() {
		return rejectPopupObjParam;
	}
	public void setRejectPopupObjParam(CT001ExportBank rejectPopupObjParam) {
		this.rejectPopupObjParam = rejectPopupObjParam;
	}
	public List<SelectItem> getBlockFlagSelList() {
		return blockFlagSelList;
	}
	public void setBlockFlagSelList(List<SelectItem> blockFlagSelList) {
		this.blockFlagSelList = blockFlagSelList;
	}
	public List<SelectItem> getDupStatusSelList() {
		return dupStatusSelList;
	}
	public void setDupStatusSelList(List<SelectItem> dupStatusSelList) {
		this.dupStatusSelList = dupStatusSelList;
	}
	public String getDupStatus() {
		return dupStatus;
	}
	public void setDupStatus(String dupStatus) {
		this.dupStatus = dupStatus;
	}
	public TreeUtilBean getTreeUtilBean() {
		return treeUtilBean;
	}
	public void setTreeUtilBean(TreeUtilBean treeUtilBean) {
		this.treeUtilBean = treeUtilBean;
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
	public boolean isRenderedOnToDoList() {
		return renderedOnToDoList;
	}
	public void setRenderedOnToDoList(boolean renderedOnToDoList) {
		this.renderedOnToDoList = renderedOnToDoList;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isDisabledButtonDelVendor() {
		return disabledButtonDelVendor;
	}
	public void setDisabledButtonDelVendor(boolean disabledButtonDelVendor) {
		this.disabledButtonDelVendor = disabledButtonDelVendor;
	}
	public boolean isDisabledButtonDelPayee() {
		return disabledButtonDelPayee;
	}
	public void setDisabledButtonDelPayee(boolean disabledButtonDelPayee) {
		this.disabledButtonDelPayee = disabledButtonDelPayee;
	}
	
}
