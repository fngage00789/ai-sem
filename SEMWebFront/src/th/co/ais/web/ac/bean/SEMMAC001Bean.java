package th.co.ais.web.ac.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.ac.Mac001Act;
import th.co.ais.domain.ac.Mac001Pay;
import th.co.ais.domain.ac.Mac001ReFile;
import th.co.ais.domain.ac.Mac001Sap;
import th.co.ais.domain.ac.Mac001Srch;
import th.co.ais.domain.ac.Mac001SrchD;
import th.co.ais.domain.ac.Mac001SrchR;
import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.domain.rt.CheckVendor;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMAC001Bean extends AbstractBean{

	private List<SelectItem> companyList;
	private List<SelectItem> siteStatusList;
	private List<SelectItem> moduleTypeList;
	private List<SelectItem> expenseTypeList;
	private List<SelectItem> paymentStatusList;
	private List<SelectItem> paymentTypeList;
	private List<SelectItem> paymentMethodList;
	private List<SelectItem> paymentDocType;
	
	
	private List<WrapperBeanObject<Mac001Srch>> mac001SrchList;
	private Mac001Srch mac001Srch;
	
	private List<Mac001SrchD> mac001SrchDList;
	private Mac001SrchD mac001SrchD;
	
	private List<Mac001Sap> mac001SapList;
	private Mac001Sap mac001Sap;
	
	private Mac001SrchR mac001SrchR;
	private Mac001ReFile mac001ReFile;
	
	private Mac001Act mac001Act;
	private Mac001Pay mac001pay;
	private CheckVendor checkVendor;
	
	private boolean chkSelAll = false;
	private boolean disabledBtnExport=true;
	private boolean disableChkAll=false;
	
	//render Button
	private boolean renderButton;
	
	//Render message form search
	private boolean renderedMsgFormSearch = true;
	
	private String remark;
	private String btnApproveStatus;
	
	//Render Calender chqDt or TransferDT
	private boolean renderedChqDt;
	private boolean renderedTransferDt;
	private boolean renderedPaymentMethod;
	
	private String tmpStatusPage;
	private String tmpChkRowId;
	
	private String tmpNavModuleFrom;
	private String tmpNavProgramFrom;
	private String tmpModuleWithNavi;
	private String tmpActionWithNavi;
	private String tmpMethodWithNavi;
	private boolean disablePaymentMethod;
	private boolean renderedLinkContract;
	private String msgHeaderPopup1;
	private String msgHeaderPopup2;
	
	private String messageErrorDate = "Date Format is Invalid";
	
	// popup add vendor
	public List<WrapperBeanObject<VendorMasterSP>> vendorMasterPopupList;
	private VendorMasterSP vendorMasterPopupObjParam;
	
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
	public List<SelectItem> getSiteStatusList() {
		return siteStatusList;
	}
	public void setSiteStatusList(List<SelectItem> siteStatusList) {
		this.siteStatusList = siteStatusList;
	}
	public List<SelectItem> getModuleTypeList() {
		return moduleTypeList;
	}
	public void setModuleTypeList(List<SelectItem> moduleTypeList) {
		this.moduleTypeList = moduleTypeList;
	}
	public List<SelectItem> getExpenseTypeList() {
		return expenseTypeList;
	}
	public void setExpenseTypeList(List<SelectItem> expenseTypeList) {
		this.expenseTypeList = expenseTypeList;
	}
	public List<SelectItem> getPaymentStatusList() {
		return paymentStatusList;
	}
	public void setPaymentStatusList(List<SelectItem> paymentStatusList) {
		this.paymentStatusList = paymentStatusList;
	}
	public List<SelectItem> getPaymentTypeList() {
		return paymentTypeList;
	}
	public void setPaymentTypeList(List<SelectItem> paymentTypeList) {
		this.paymentTypeList = paymentTypeList;
	}
	public List<SelectItem> getPaymentDocType() {
		return paymentDocType;
	}
	public void setPaymentDocType(List<SelectItem> paymentDocType) {
		this.paymentDocType = paymentDocType;
	}
	public Mac001Srch getMac001Srch() {
		return mac001Srch;
	}
	public void setMac001Srch(Mac001Srch mac001Srch) {
		this.mac001Srch = mac001Srch;
	}
	public void setRenderedMsgFormSearch(boolean renderedMsgFormSearch) {
		this.renderedMsgFormSearch = renderedMsgFormSearch;
	}
	public boolean isRenderedMsgFormSearch() {
		return renderedMsgFormSearch;
	}
	public void setRenderButton(boolean renderButton) {
		this.renderButton = renderButton;
	}
	public boolean isRenderButton() {
		return renderButton;
	}
	public List<Mac001SrchD> getMac001SrchDList() {
		return mac001SrchDList;
	}
	public void setMac001SrchDList(List<Mac001SrchD> mac001SrchDList) {
		this.mac001SrchDList = mac001SrchDList;
	}
	public Mac001SrchD getMac001SrchD() {
		return mac001SrchD;
	}
	public void setMac001SrchD(Mac001SrchD mac001SrchD) {
		this.mac001SrchD = mac001SrchD;
	}
	public void setMac001Act(Mac001Act mac001Act) {
		this.mac001Act = mac001Act;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTmpModuleWithNavi() {
		return tmpModuleWithNavi;
	}
	public void setTmpModuleWithNavi(String tmpModuleWithNavi) {
		this.tmpModuleWithNavi = tmpModuleWithNavi;
	}
	public String getTmpActionWithNavi() {
		return tmpActionWithNavi;
	}
	public void setTmpActionWithNavi(String tmpActionWithNavi) {
		this.tmpActionWithNavi = tmpActionWithNavi;
	}
	public String getTmpMethodWithNavi() {
		return tmpMethodWithNavi;
	}
	public void setTmpMethodWithNavi(String tmpMethodWithNavi) {
		this.tmpMethodWithNavi = tmpMethodWithNavi;
	}
	public Mac001Act getMac001Act() {
		return mac001Act;
	}
	public String getBtnApproveStatus() {
		return btnApproveStatus;
	}
	public void setBtnApproveStatus(String btnApproveStatus) {
		this.btnApproveStatus = btnApproveStatus;
	}
	public void setMac001SrchList(List<WrapperBeanObject<Mac001Srch>> mac001SrchList) {
		this.mac001SrchList = mac001SrchList;
	}
	public List<WrapperBeanObject<Mac001Srch>> getMac001SrchList() {
		return mac001SrchList;
	}
	public boolean isChkSelAll() {
		return chkSelAll;
	}
	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}
	public boolean isDisabledBtnExport() {
		return disabledBtnExport;
	}
	public void setDisabledBtnExport(boolean disabledBtnExport) {
		this.disabledBtnExport = disabledBtnExport;
	}
	public void setMac001pay(Mac001Pay mac001pay) {
		this.mac001pay = mac001pay;
	}
	public Mac001Pay getMac001pay() {
		return mac001pay;
	}
	public void setPaymentMethodList(List<SelectItem> paymentMethodList) {
		this.paymentMethodList = paymentMethodList;
	}
	public List<SelectItem> getPaymentMethodList() {
		return paymentMethodList;
	}
	public boolean isRenderedChqDt() {
		return renderedChqDt;
	}
	public void setRenderedChqDt(boolean renderedChqDt) {
		this.renderedChqDt = renderedChqDt;
	}
	public boolean isRenderedTransferDt() {
		return renderedTransferDt;
	}
	public void setRenderedTransferDt(boolean renderedTransferDt) {
		this.renderedTransferDt = renderedTransferDt;
	}
	public boolean isRenderedPaymentMethod() {
		return renderedPaymentMethod;
	}
	public void setRenderedPaymentMethod(boolean renderedPaymentMethod) {
		this.renderedPaymentMethod = renderedPaymentMethod;
	}
	public void setDisableChkAll(boolean disableChkAll) {
		this.disableChkAll = disableChkAll;
	}
	public boolean isDisableChkAll() {
		return disableChkAll;
	}
	public List<Mac001Sap> getMac001SapList() {
		return mac001SapList;
	}
	public void setMac001SapList(List<Mac001Sap> mac001SapList) {
		this.mac001SapList = mac001SapList;
	}
	public Mac001Sap getMac001Sap() {
		return mac001Sap;
	}
	public void setMac001Sap(Mac001Sap mac001Sap) {
		this.mac001Sap = mac001Sap;
	}
	public void setMac001SrchR(Mac001SrchR mac001SrchR) {
		this.mac001SrchR = mac001SrchR;
	}
	public Mac001SrchR getMac001SrchR() {
		return mac001SrchR;
	}
	public void setTmpStatusPage(String tmpStatusPage) {
		this.tmpStatusPage = tmpStatusPage;
	}
	public String getTmpStatusPage() {
		return tmpStatusPage;
	}
	public void setTmpChkRowId(String tmpChkRowId) {
		this.tmpChkRowId = tmpChkRowId;
	}
	public String getTmpChkRowId() {
		return tmpChkRowId;
	}
	public String getTmpNavModuleFrom() {
		return tmpNavModuleFrom;
	}
	public void setTmpNavModuleFrom(String tmpNavModuleFrom) {
		this.tmpNavModuleFrom = tmpNavModuleFrom;
	}
	public String getTmpNavProgramFrom() {
		return tmpNavProgramFrom;
	}
	public void setTmpNavProgramFrom(String tmpNavProgramFrom) {
		this.tmpNavProgramFrom = tmpNavProgramFrom;
	}
	/**
	 * @param disablePaymentMethod the disablePaymentMethod to set
	 */
	public void setDisablePaymentMethod(boolean disablePaymentMethod) {
		this.disablePaymentMethod = disablePaymentMethod;
	}
	/**
	 * @return the disablePaymentMethod
	 */
	public boolean isDisablePaymentMethod() {
		return disablePaymentMethod;
	}
	/**
	 * @param renderedLinkContract the renderedLinkContract to set
	 */
	public void setRenderedLinkContract(boolean renderedLinkContract) {
		this.renderedLinkContract = renderedLinkContract;
	}
	/**
	 * @return the renderedLinkContract
	 */
	public boolean isRenderedLinkContract() {
		return renderedLinkContract;
	}
	/**
	 * @param checkVendor the checkVendor to set
	 */
	public void setCheckVendor(CheckVendor checkVendor) {
		this.checkVendor = checkVendor;
	}
	/**
	 * @return the checkVendor
	 */
	public CheckVendor getCheckVendor() {
		return checkVendor;
	}
	public String getMsgHeaderPopup1() {
		return msgHeaderPopup1;
	}
	public void setMsgHeaderPopup1(String msgHeaderPopup1) {
		this.msgHeaderPopup1 = msgHeaderPopup1;
	}
	public String getMsgHeaderPopup2() {
		return msgHeaderPopup2;
	}
	public void setMsgHeaderPopup2(String msgHeaderPopup2) {
		this.msgHeaderPopup2 = msgHeaderPopup2;
	}
	/**
	 * @param mac001ReFile the mac001ReFile to set
	 */
	public void setMac001ReFile(Mac001ReFile mac001ReFile) {
		this.mac001ReFile = mac001ReFile;
	}
	/**
	 * @return the mac001ReFile
	 */
	public Mac001ReFile getMac001ReFile() {
		return mac001ReFile;
	}
	/**
	 * @param messageErrorDate the messageErrorDate to set
	 */
	public void setMessageErrorDate(String messageErrorDate) {
		this.messageErrorDate = messageErrorDate;
	}
	/**
	 * @return the messageErrorDate
	 */
	public String getMessageErrorDate() {
		return messageErrorDate;
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
	
}
