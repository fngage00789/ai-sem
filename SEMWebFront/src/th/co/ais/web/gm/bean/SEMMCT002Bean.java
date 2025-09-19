package th.co.ais.web.gm.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.gm.Attachment;
import th.co.ais.domain.gm.BgMaster;
import th.co.ais.domain.gm.BgMasterSP;
import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMCT002Bean extends AbstractBean {

	private static final long serialVersionUID = -257004826763506625L;
	
	//For edit data
	private BgMaster bgMaster;
	private Attachment attachment;
	//data table attachment
	private List<Attachment> attachmentList;
	
	private List<SelectItem> companyList;
	private List<SelectItem> bankNameList;
	private List<SelectItem> bgStatusList;
	private List<SelectItem> expenseTypeList;
	
	private boolean visibleModeEdit;
	//disabled text box in case view mode.
	private boolean disabled = false;
	private boolean disabledCompany = false;
	//disabled upload module in case view mode.
	private boolean disabledUpload = true;
	
	//For search criteria
	private BgMasterSP tmpBgMaster;
	//Delete attachment
	private Attachment tmpAttachment;
	//For pop up reject reason
	private String txtRejectReason;
	
	//Export Excel
	private boolean chkSelAll = false;
	private boolean disabledBtnExport=true;
	public List<WrapperBeanObject<BgMasterSP>> bgMasterList;
	
	//Display column Delete
	private boolean renderedColDel = true;
	
	//Render message form search
	private boolean renderedMsgFormSearch = true;
	
	//Render txtArea Reason
	private boolean renderedTxtAreaReason = false;
	
	private boolean isCheckSM = false;
	
	//Highlight whole row.
	private String tmpRowId;
	
	private String valueFrom;
	
	private boolean renderedPanelBGInfo = false;
	
	// popup add vendor
	public List<WrapperBeanObject<VendorMasterSP>> vendorMasterPopupList;
	private VendorMasterSP vendorMasterPopupObjParam;
	
	public boolean isRenderedTxtAreaReason() {
		return renderedTxtAreaReason;
	}
	public void setRenderedTxtAreaReason(boolean renderedTxtAreaReason) {
		this.renderedTxtAreaReason = renderedTxtAreaReason;
	}
	public boolean isRenderedColDel() {
		return renderedColDel;
	}
	public void setRenderedColDel(boolean renderedColDel) {
		this.renderedColDel = renderedColDel;
	}
	public String getTmpRowId() {
		return tmpRowId;
	}
	public void setTmpRowId(String tmpRowId) {
		this.tmpRowId = tmpRowId;
	}
	public String getTxtRejectReason() {
		return txtRejectReason;
	}
	public void setTxtRejectReason(String txtRejectReason) {
		this.txtRejectReason = txtRejectReason;
	}
	
	public BgMasterSP getTmpBgMaster() {
		if(tmpBgMaster == null)
			tmpBgMaster = new BgMasterSP();
		return tmpBgMaster;
	}
	public void setTmpBgMaster(BgMasterSP tmpBgMaster) {
		this.tmpBgMaster = tmpBgMaster;
	}
	public Attachment getTmpAttachment() {
		if(tmpAttachment == null)
			tmpAttachment = new Attachment();
		return tmpAttachment;
	}
	public void setTmpAttachment(Attachment tmpAttachment) {
		this.tmpAttachment = tmpAttachment;
	}
	
	
	public boolean isDisabledUpload() {
		return disabledUpload;
	}
	public void setDisabledUpload(boolean disabledUpload) {
		this.disabledUpload = disabledUpload;
	}
	public boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	public boolean isVisibleModeEdit() {
		return visibleModeEdit;
	}
	public void setVisibleModeEdit(boolean visibleModeEdit) {
		this.visibleModeEdit = visibleModeEdit;
	}
	public Attachment getAttachment() {
		if(attachment == null)
			attachment = new  Attachment();
		return attachment;
	}
	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}
	public List<Attachment> getAttachmentList() {
		if(attachmentList == null)
			attachmentList = new ArrayList<Attachment>();
		return attachmentList;
	}
	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}
	public BgMaster getBgMaster() {
		if(bgMaster == null)
			bgMaster = new BgMaster();
		return bgMaster;
	}
	public void setBgMaster(BgMaster bgMaster) {
		this.bgMaster = bgMaster;
	}
	public List<SelectItem> getExpenseTypeList() {
		return expenseTypeList;
	}
	public void setExpenseTypeList(List<SelectItem> expenseTypeList) {
		this.expenseTypeList = expenseTypeList;
	}
	public List<SelectItem> getCompanyList() {
		if(companyList == null)
			companyList = new ArrayList<SelectItem>();
		return companyList;
	}
	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}
	public List<SelectItem> getBankNameList() {
		if(bankNameList == null)
			bankNameList = new ArrayList<SelectItem>();
		return bankNameList;
	}
	public void setBankNameList(List<SelectItem> bankNameList) {
		this.bankNameList = bankNameList;
	}
	public List<SelectItem> getBgStatusList() {
		if(bgStatusList == null)
			bgStatusList = new ArrayList<SelectItem>();
		return bgStatusList;
	}
	public void setBgStatusList(List<SelectItem> bgStatusList) {
		this.bgStatusList = bgStatusList;
	}
	
	//Export Excel
	public List<WrapperBeanObject<BgMasterSP>> getBgMasterList() {
		if (bgMasterList == null) {
			bgMasterList = new  ArrayList<WrapperBeanObject<BgMasterSP>>();
		}
		return bgMasterList;
	}
	public void setBgMasterList(List<WrapperBeanObject<BgMasterSP>> bgMasterList) {
		this.bgMasterList = bgMasterList;
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
	//End Export Excel
	
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	
	public boolean isRenderedMsgFormSearch() {
		return renderedMsgFormSearch;
	}
	public void setRenderedMsgFormSearch(boolean renderedMsgFormSearch) {
		this.renderedMsgFormSearch = renderedMsgFormSearch;
	}
	
	public boolean isDisabledCompany() {
		return disabledCompany;
	}
	public void setDisabledCompany(boolean disabledCompany) {
		this.disabledCompany = disabledCompany;
	}
	public boolean isCheckSM() {
		return isCheckSM;
	}
	public void setCheckSM(boolean isCheckSM) {
		this.isCheckSM = isCheckSM;
	}
	public boolean isRenderedPanelBGInfo() {
		return renderedPanelBGInfo;
	}
	public void setRenderedPanelBGInfo(boolean renderedPanelBGInfo) {
		this.renderedPanelBGInfo = renderedPanelBGInfo;
	}
	public String getValueFrom() {
		return valueFrom;
	}
	public void setValueFrom(String valueFrom) {
		this.valueFrom = valueFrom;
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
