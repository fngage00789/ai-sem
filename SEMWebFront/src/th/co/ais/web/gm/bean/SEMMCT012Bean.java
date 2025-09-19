package th.co.ais.web.gm.bean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.faces.model.SelectItem;

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

public class SEMMCT012Bean extends AbstractBean {
private static final long serialVersionUID = -257004826763506625L;
	
	//for search criteria
	private VendorMasterSP criteriaVendorSP;
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

}
