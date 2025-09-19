package th.co.ais.web.ac.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.ac.Mac004Act;
import th.co.ais.domain.ac.Mac004Srch;
import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.domain.rt.Mrt003PopPaySP;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMAC004Bean extends AbstractBean{

	private List<SelectItem> companyList;
	private List<SelectItem> moduleTypeList;
	private List<SelectItem> expenseTypeList;
	private List<SelectItem> paymentTypeList;
	private List<SelectItem> paymentMethodList;
	private List<SelectItem> paymentStatusList;
	private List<Mac004Srch> mac004SrchList;
	private Mac004Srch mac004Srch;
	
	private Mac004Act mac004Act;
	
	//Render Calender chqDt or TransferDT
	private boolean renderedChqDt;
	private boolean renderedTransferDt;
	private boolean renderedPaymentMethod;
	private boolean disablePaymentMethod;
	
	private String messageErrorDate = "Date Format is Invalid";
	
	private boolean renderMessagePopup = false;
	private Mrt003PopPaySP paySP; 
	private boolean popupCloseSave = false;
	private List<SelectItem> paymentStatusListItems;
	private boolean disableCancelBtn = false;
	
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
	public List<SelectItem> getExpenseTypeList() {
		return expenseTypeList;
	}
	public void setExpenseTypeList(List<SelectItem> expenseTypeList) {
		this.expenseTypeList = expenseTypeList;
	}
	public List<Mac004Srch> getMac004SrchList() {
		return mac004SrchList;
	}
	public void setMac004SrchList(List<Mac004Srch> mac004SrchList) {
		this.mac004SrchList = mac004SrchList;
	}
	public Mac004Srch getMac004Srch() {
		return mac004Srch;
	}
	public void setMac004Srch(Mac004Srch mac004Srch) {
		this.mac004Srch = mac004Srch;
	}
	public void setModuleTypeList(List<SelectItem> moduleTypeList) {
		this.moduleTypeList = moduleTypeList;
	}
	public List<SelectItem> getModuleTypeList() {
		return moduleTypeList;
	}
	public void setMac004Act(Mac004Act mac004Act) {
		this.mac004Act = mac004Act;
	}
	public Mac004Act getMac004Act() {
		return mac004Act;
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
	public List<SelectItem> getPaymentStatusList() {
		return paymentStatusList;
	}
	public void setPaymentStatusList(List<SelectItem> paymentStatusList) {
		this.paymentStatusList = paymentStatusList;
	}
	public boolean isRenderMessagePopup() {
		return renderMessagePopup;
	}
	public void setRenderMessagePopup(boolean renderMessagePopup) {
		this.renderMessagePopup = renderMessagePopup;
	}
	public Mrt003PopPaySP getPaySP() {
		return paySP;
	}
	public void setPaySP(Mrt003PopPaySP paySP) {
		this.paySP = paySP;
	}
	public boolean isPopupCloseSave() {
		return popupCloseSave;
	}
	public void setPopupCloseSave(boolean popupCloseSave) {
		this.popupCloseSave = popupCloseSave;
	}
	public List<SelectItem> getPaymentStatusListItems() {
		return paymentStatusListItems;
	}
	public void setPaymentStatusListItems(List<SelectItem> paymentStatusListItems) {
		this.paymentStatusListItems = paymentStatusListItems;
	}
	public boolean isDisableCancelBtn() {
		return disableCancelBtn;
	}
	public void setDisableCancelBtn(boolean disableCancelBtn) {
		this.disableCancelBtn = disableCancelBtn;
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
