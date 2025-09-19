package th.co.ais.web.gm.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.gm.ApproveBookBankAct;
import th.co.ais.domain.gm.ApproveBookBankSP;
import th.co.ais.domain.gm.CT001ExportBank;
import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMCT003Bean extends AbstractBean{
	
	private List<SelectItem> payeeStatusList;
	private List<SelectItem> payeeTypeList;
	private List<SelectItem> bankStatusList;
	
	public List<WrapperBeanObject<ApproveBookBankSP>> approveBookBankSPList;
	public ApproveBookBankSP approveBookBankSP;
	
	public ApproveBookBankAct approveBookBankAct;
	
	private boolean chkSelAll = false;
	private boolean disabledBtnExport=true;
	private boolean disableChkAll=false;
	private boolean disabledBtnApproveAndReject=true;
	private boolean disabledBtnCheckerAndReject=true;
	
	private String remark;
	private String btnApproveStatus;
	private boolean renderedCheckBtn = false;
	private boolean renderedApproveBtn = false;
	
	//added by NEW 20151110
	private boolean displayReport = false;
	private List<CT001ExportBank> ct001ExBankList;
	private String tmpBatch;
	private Date tmpBatchDT;
	public List<WrapperBeanObject<VendorMasterSP>> vendorMasterList;
	private boolean disabledExportVendorBtn = true;
	private String status;
	private String actionType;
	
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public List<SelectItem> getPayeeStatusList() {
		return payeeStatusList;
	}
	public void setPayeeStatusList(List<SelectItem> payeeStatusList) {
		this.payeeStatusList = payeeStatusList;
	}
	public List<SelectItem> getPayeeTypeList() {
		return payeeTypeList;
	}
	public void setPayeeTypeList(List<SelectItem> payeeTypeList) {
		this.payeeTypeList = payeeTypeList;
	}
	public List<SelectItem> getBankStatusList() {
		return bankStatusList;
	}
	public void setBankStatusList(List<SelectItem> bankStatusList) {
		this.bankStatusList = bankStatusList;
	}
	public List<WrapperBeanObject<ApproveBookBankSP>> getApproveBookBankSPList() {
		return approveBookBankSPList;
	}
	public void setApproveBookBankSPList(
			List<WrapperBeanObject<ApproveBookBankSP>> approveBookBankSPList) {
		this.approveBookBankSPList = approveBookBankSPList;
	}
	public ApproveBookBankSP getApproveBookBankSP() {
		return approveBookBankSP;
	}
	public void setApproveBookBankSP(ApproveBookBankSP approveBookBankSP) {
		this.approveBookBankSP = approveBookBankSP;
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
	public ApproveBookBankAct getApproveBookBankAct() {
		return approveBookBankAct;
	}
	public void setApproveBookBankAct(ApproveBookBankAct approveBookBankAct) {
		this.approveBookBankAct = approveBookBankAct;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRemark() {
		return remark;
	}
	public String getBtnApproveStatus() {
		return btnApproveStatus;
	}
	public void setBtnApproveStatus(String btnApproveStatus) {
		this.btnApproveStatus = btnApproveStatus;
	}
	public void setDisableChkAll(boolean disableChkAll) {
		this.disableChkAll = disableChkAll;
	}
	public boolean isDisableChkAll() {
		return disableChkAll;
	}
	public boolean isDisabledBtnApproveAndReject() {
		return disabledBtnApproveAndReject;
	}
	public void setDisabledBtnApproveAndReject(boolean disabledBtnApproveAndReject) {
		this.disabledBtnApproveAndReject = disabledBtnApproveAndReject;
	}
	public boolean isRenderedCheckBtn() {
		return renderedCheckBtn;
	}
	public void setRenderedCheckBtn(boolean renderedCheckBtn) {
		this.renderedCheckBtn = renderedCheckBtn;
	}
	public boolean isRenderedApproveBtn() {
		return renderedApproveBtn;
	}
	public void setRenderedApproveBtn(boolean renderedApproveBtn) {
		this.renderedApproveBtn = renderedApproveBtn;
	}
	public boolean isDisabledBtnCheckerAndReject() {
		return disabledBtnCheckerAndReject;
	}
	public void setDisabledBtnCheckerAndReject(boolean disabledBtnCheckerAndReject) {
		this.disabledBtnCheckerAndReject = disabledBtnCheckerAndReject;
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
	public List<WrapperBeanObject<VendorMasterSP>> getVendorMasterList() {
		if(vendorMasterList == null)
			vendorMasterList = new ArrayList<WrapperBeanObject<VendorMasterSP>>();
		return vendorMasterList;
	}
	public void setVendorMasterList(
			List<WrapperBeanObject<VendorMasterSP>> vendorMasterList) {
		this.vendorMasterList = vendorMasterList;
	}
	public boolean isDisabledExportVendorBtn() {
		return disabledExportVendorBtn;
	}
	public void setDisabledExportVendorBtn(boolean disabledExportVendorBtn) {
		this.disabledExportVendorBtn = disabledExportVendorBtn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	
}
