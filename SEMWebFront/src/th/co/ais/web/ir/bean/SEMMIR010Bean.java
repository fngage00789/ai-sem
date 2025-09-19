package th.co.ais.web.ir.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.el.PaymentWrapper;
import th.co.ais.domain.el.VendorMapPayeeEL;
import th.co.ais.domain.gm.CT001SrchMSP;
import th.co.ais.domain.gm.PayeeBookbank;
import th.co.ais.domain.gm.VendorBookbank;
import th.co.ais.domain.gm.VendorMapPayee;
import th.co.ais.domain.gm.VendorMaster;
import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.domain.ir.InsurancePayActSP;
import th.co.ais.domain.ir.InsurancePayEditSaveSP;
import th.co.ais.domain.ir.MirGetRunningNo;
import th.co.ais.domain.ir.Policy;
import th.co.ais.domain.ir.PolicyDtl;
import th.co.ais.domain.ir.PolicySP;
import th.co.ais.domain.rt.MrtGetRunningNo;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMIR010Bean extends AbstractBean{
	
	private List<SelectItem> companyList;
	private List<SelectItem> networkTypeList;
	private List<SelectItem> transferTypeList;
	private List<SelectItem> policyTypeList;
	private List<SelectItem> docTypeList;
	private List<SelectItem> paymentStatusList;
	private List<SelectItem> payTypeList;
	private List<SelectItem> paymentTypeList;
	private List<SelectItem> paymentMethodList;
	
	private String rowId;
	
	private int rowPerPage = 10;
	private int maxPage = 10;
	private int maxSearchResult = 100;
	
	private PolicySP policySP;
	private List<WrapperBeanObject<PolicySP>> policySPList;
	private PolicySP popupPolicySP;
	private InsurancePayEditSaveSP insurancePayEditSaveSP;
	
	private boolean chkSelAll = false;
	private boolean disabledBtnExport=true;
	private boolean renderedBtnExportShowError = false;
	private boolean renderedBtnHExport;
	private boolean renderedBtnA4JExport;
	private boolean displayShowExcel;
	private boolean renderedChqDt;
	private boolean renderedChqReceiveDt;
	private boolean renderedTransferDt;
	private String confirmCoppyDateMsg;
	private String btnApproveStatus;
	private String btnStatus;
	private String remark;
	private InsurancePayActSP insurancePayActSP;
	private List<MirGetRunningNo> mirGetRunningNoList;
	private MirGetRunningNo mirGetRunningNo;
	private String PopupName;
	private Date tmpChqDt;
	private Date tmpChqReceiveDt;
	private Date tmpTransferDt;
	private String tmpPaymentMethod;
	private boolean renderBtnVendorMaster = false;
	
	//Vendor Master
	private List<VendorMapPayeeEL> vendorMapPayeeList;	
	private String navModuleFrom2;
	private String navProgramFrom2;
	private String actionWithNaviFrom2;
	private String selectedRadio;
	private VendorMaster vendorMaster;
	private VendorBookbank vendorBookBank;
	private VendorMapPayee vendorMapPayee;
	private CT001SrchMSP ct001SrchMSP;
	public List<WrapperBeanObject<CT001SrchMSP>> ct001SrchMSPList;
	private String tmpContractNo;
	
	private List<VendorMasterSP> vendorMasterSPList;
	
	//added by NEW 09/04/2015
	private boolean renderedOnToDoList = false;
	private boolean commandButtonEnable = true;
	private List<PaymentWrapper> paymentWrapperList;
	private boolean displayReportFlag = false;
	
	// popup add vendor
	public List<WrapperBeanObject<VendorMasterSP>> vendorMasterPopupList;
	private VendorMasterSP vendorMasterPopupObjParam;
	
	//added by NEW 2019/01/10
	private boolean payFlag;
	
	@Override
	public int getRowPerPage() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		// TODO Auto-generated method stub

	}

	public List<SelectItem> getCompanyList() {
		if(companyList == null)
			companyList = new ArrayList<SelectItem>();
		return companyList;
	}

	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}

	public List<SelectItem> getNetworkTypeList() {
		if(networkTypeList == null)
			networkTypeList = new ArrayList<SelectItem>();
		return networkTypeList;
	}

	public void setNetworkTypeList(List<SelectItem> networkTypeList) {
		this.networkTypeList = networkTypeList;
	}

	public List<SelectItem> getTransferTypeList() {
		if(transferTypeList == null)
			transferTypeList = new ArrayList<SelectItem>();
		return transferTypeList;
	}

	public void setTransferTypeList(List<SelectItem> transferTypeList) {
		this.transferTypeList = transferTypeList;
	}

	public List<SelectItem> getPolicyTypeList() {
		if(policyTypeList == null)
			policyTypeList = new ArrayList<SelectItem>();
		return policyTypeList;
	}

	public void setPolicyTypeList(List<SelectItem> policyTypeList) {
		this.policyTypeList = policyTypeList;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getMaxSearchResult() {
		return maxSearchResult;
	}

	public void setMaxSearchResult(int maxSearchResult) {
		this.maxSearchResult = maxSearchResult;
	}

	public List<SelectItem> getDocTypeList() {
		return docTypeList;
	}

	public void setDocTypeList(List<SelectItem> docTypeList) {
		this.docTypeList = docTypeList;
	}

	public List<SelectItem> getPaymentStatusList() {
		return paymentStatusList;
	}

	public void setPaymentStatusList(List<SelectItem> paymentStatusList) {
		this.paymentStatusList = paymentStatusList;
	}

	public List<SelectItem> getPayTypeList() {
		return payTypeList;
	}

	public void setPayTypeList(List<SelectItem> payTypeList) {
		this.payTypeList = payTypeList;
	}

	public boolean isDisabledBtnExport() {
		return disabledBtnExport;
	}

	public void setDisabledBtnExport(boolean disabledBtnExport) {
		this.disabledBtnExport = disabledBtnExport;
	}

	public boolean isRenderedBtnHExport() {
		return renderedBtnHExport;
	}

	public void setRenderedBtnHExport(boolean renderedBtnHExport) {
		this.renderedBtnHExport = renderedBtnHExport;
	}

	public boolean isRenderedBtnA4JExport() {
		return renderedBtnA4JExport;
	}

	public void setRenderedBtnA4JExport(boolean renderedBtnA4JExport) {
		this.renderedBtnA4JExport = renderedBtnA4JExport;
	}

	public boolean isRenderedBtnExportShowError() {
		return renderedBtnExportShowError;
	}

	public void setRenderedBtnExportShowError(boolean renderedBtnExportShowError) {
		this.renderedBtnExportShowError = renderedBtnExportShowError;
	}

	public boolean isDisplayShowExcel() {
		return displayShowExcel;
	}

	public void setDisplayShowExcel(boolean displayShowExcel) {
		this.displayShowExcel = displayShowExcel;
	}

	public String getConfirmCoppyDateMsg() {
		return confirmCoppyDateMsg;
	}

	public void setConfirmCoppyDateMsg(String confirmCoppyDateMsg) {
		this.confirmCoppyDateMsg = confirmCoppyDateMsg;
	}

	public boolean isChkSelAll() {
		return chkSelAll;
	}

	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}

	public PolicySP getPolicySP() {
		return policySP;
	}

	public void setPolicySP(PolicySP policySP) {
		this.policySP = policySP;
	}

	public List<WrapperBeanObject<PolicySP>> getPolicySPList() {
		return policySPList;
	}

	public void setPolicySPList(List<WrapperBeanObject<PolicySP>> policySPList) {
		this.policySPList = policySPList;
	}

	public String getBtnApproveStatus() {
		return btnApproveStatus;
	}

	public void setBtnApproveStatus(String btnApproveStatus) {
		this.btnApproveStatus = btnApproveStatus;
	}

	public String getBtnStatus() {
		return btnStatus;
	}

	public void setBtnStatus(String btnStatus) {
		this.btnStatus = btnStatus;
	}

	public InsurancePayActSP getInsurancePayActSP() {
		return insurancePayActSP;
	}

	public void setInsurancePayActSP(InsurancePayActSP insurancePayActSP) {
		this.insurancePayActSP = insurancePayActSP;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<MirGetRunningNo> getMirGetRunningNoList() {
		return mirGetRunningNoList;
	}

	public void setMirGetRunningNoList(List<MirGetRunningNo> mirGetRunningNoList) {
		this.mirGetRunningNoList = mirGetRunningNoList;
	}

	public MirGetRunningNo getMirGetRunningNo() {
		return mirGetRunningNo;
	}

	public void setMirGetRunningNo(MirGetRunningNo mirGetRunningNo) {
		this.mirGetRunningNo = mirGetRunningNo;
	}

	public String getPopupName() {
		return PopupName;
	}

	public void setPopupName(String popupName) {
		PopupName = popupName;
	}

	public Date getTmpChqDt() {
		return tmpChqDt;
	}

	public void setTmpChqDt(Date tmpChqDt) {
		this.tmpChqDt = tmpChqDt;
	}

	public Date getTmpChqReceiveDt() {
		return tmpChqReceiveDt;
	}

	public void setTmpChqReceiveDt(Date tmpChqReceiveDt) {
		this.tmpChqReceiveDt = tmpChqReceiveDt;
	}

	public Date getTmpTransferDt() {
		return tmpTransferDt;
	}

	public void setTmpTransferDt(Date tmpTransferDt) {
		this.tmpTransferDt = tmpTransferDt;
	}

	public String getTmpPaymentMethod() {
		return tmpPaymentMethod;
	}

	public List<SelectItem> getPaymentTypeList() {
		return paymentTypeList;
	}

	public void setPaymentTypeList(List<SelectItem> paymentTypeList) {
		this.paymentTypeList = paymentTypeList;
	}

	public List<SelectItem> getPaymentMethodList() {
		return paymentMethodList;
	}

	public void setPaymentMethodList(List<SelectItem> paymentMethodList) {
		this.paymentMethodList = paymentMethodList;
	}

	public void setTmpPaymentMethod(String tmpPaymentMethod) {
		this.tmpPaymentMethod = tmpPaymentMethod;
	}

	public PolicySP getPopupPolicySP() {
		return popupPolicySP;
	}

	public void setPopupPolicySP(PolicySP popupPolicySP) {
		this.popupPolicySP = popupPolicySP;
	}

	public InsurancePayEditSaveSP getInsurancePayEditSaveSP() {
		return insurancePayEditSaveSP;
	}

	public void setInsurancePayEditSaveSP(
			InsurancePayEditSaveSP insurancePayEditSaveSP) {
		this.insurancePayEditSaveSP = insurancePayEditSaveSP;
	}

	public boolean isRenderBtnVendorMaster() {
		return renderBtnVendorMaster;
	}

	public void setRenderBtnVendorMaster(boolean renderBtnVendorMaster) {
		this.renderBtnVendorMaster = renderBtnVendorMaster;
	}

	public List<VendorMapPayeeEL> getVendorMapPayeeList() {
		return vendorMapPayeeList;
	}

	public void setVendorMapPayeeList(List<VendorMapPayeeEL> vendorMapPayeeList) {
		this.vendorMapPayeeList = vendorMapPayeeList;
	}

	public String getNavModuleFrom2() {
		return navModuleFrom2;
	}

	public void setNavModuleFrom2(String navModuleFrom2) {
		this.navModuleFrom2 = navModuleFrom2;
	}

	public String getNavProgramFrom2() {
		return navProgramFrom2;
	}

	public void setNavProgramFrom2(String navProgramFrom2) {
		this.navProgramFrom2 = navProgramFrom2;
	}

	public String getActionWithNaviFrom2() {
		return actionWithNaviFrom2;
	}

	public void setActionWithNaviFrom2(String actionWithNaviFrom2) {
		this.actionWithNaviFrom2 = actionWithNaviFrom2;
	}

	public String getSelectedRadio() {
		return selectedRadio;
	}

	public void setSelectedRadio(String selectedRadio) {
		this.selectedRadio = selectedRadio;
	}

	public VendorMaster getVendorMaster() {
		return vendorMaster;
	}

	public void setVendorMaster(VendorMaster vendorMaster) {
		this.vendorMaster = vendorMaster;
	}

	public VendorBookbank getVendorBookBank() {
		return vendorBookBank;
	}

	public void setVendorBookBank(VendorBookbank vendorBookBank) {
		this.vendorBookBank = vendorBookBank;
	}

	public VendorMapPayee getVendorMapPayee() {
		return vendorMapPayee;
	}

	public void setVendorMapPayee(VendorMapPayee vendorMapPayee) {
		this.vendorMapPayee = vendorMapPayee;
	}

	public CT001SrchMSP getCt001SrchMSP() {
		return ct001SrchMSP;
	}

	public void setCt001SrchMSP(CT001SrchMSP ct001SrchMSP) {
		this.ct001SrchMSP = ct001SrchMSP;
	}

	public List<WrapperBeanObject<CT001SrchMSP>> getCt001SrchMSPList() {
		return ct001SrchMSPList;
	}

	public void setCt001SrchMSPList(
			List<WrapperBeanObject<CT001SrchMSP>> ct001SrchMSPList) {
		this.ct001SrchMSPList = ct001SrchMSPList;
	}

	public String getTmpContractNo() {
		return tmpContractNo;
	}

	public void setTmpContractNo(String tmpContractNo) {
		this.tmpContractNo = tmpContractNo;
	}

	public List<VendorMasterSP> getVendorMasterSPList() {
		return vendorMasterSPList;
	}

	public void setVendorMasterSPList(List<VendorMasterSP> vendorMasterSPList) {
		this.vendorMasterSPList = vendorMasterSPList;
	}

	public boolean getRenderedChqDt() {
		return renderedChqDt;
	}

	public void setRenderedChqDt(boolean renderedChqDt) {
		this.renderedChqDt = renderedChqDt;
	}

	public boolean getRenderedTransferDt() {
		return renderedTransferDt;
	}

	public void setRenderedTransferDt(boolean renderedTransferDt) {
		this.renderedTransferDt = renderedTransferDt;
	}

	public boolean isRenderedOnToDoList() {
		return renderedOnToDoList;
	}

	public void setRenderedOnToDoList(boolean renderedOnToDoList) {
		this.renderedOnToDoList = renderedOnToDoList;
	}

	public boolean isCommandButtonEnable() {
		return commandButtonEnable;
	}

	public void setCommandButtonEnable(boolean commandButtonEnable) {
		this.commandButtonEnable = commandButtonEnable;
	}

	public List<PaymentWrapper> getPaymentWrapperList() {
		return paymentWrapperList;
	}

	public void setPaymentWrapperList(List<PaymentWrapper> paymentWrapperList) {
		this.paymentWrapperList = paymentWrapperList;
	}

	public boolean isDisplayReportFlag() {
		return displayReportFlag;
	}

	public void setDisplayReportFlag(boolean displayReportFlag) {
		this.displayReportFlag = displayReportFlag;
	}

	public boolean isRenderedChqReceiveDt() {
		return renderedChqReceiveDt;
	}

	public void setRenderedChqReceiveDt(boolean renderedChqReceiveDt) {
		this.renderedChqReceiveDt = renderedChqReceiveDt;
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

	public boolean isPayFlag() {
		return payFlag;
	}

	public void setPayFlag(boolean payFlag) {
		this.payFlag = payFlag;
	}
	
}
