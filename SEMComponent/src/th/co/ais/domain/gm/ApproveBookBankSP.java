package th.co.ais.domain.gm;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class ApproveBookBankSP extends AbstractDomain{

	private String rowId;
	private String vendorMappayeeId;
	private String payeeTypeDesc;
	private String payeeName;
	private String payeeIdCard;
	private String bankAccType;
	private String bankAccNo;
	private String bankAccName;
	private String bankCode;
	private String bankName;
	private String bankBranch;
	private String province;
	private String newBankFlag;
	private String contractNo;
	private String siteName;
	private String recordStatus;
	private String recordStatusDesc;
	private String remark;
	private String approveBy;
	private Date approveDt;
	private String vendorMasterId;
	private String exportFlag;
	
	private String payeeType;
	private String idCard;
	private String bankStatus;
	
	private boolean renderedCheckBox;
	private String siteInfoId;
	
	//added by NEW 20151018
	private String batchNo;
	private String lotNo;
	
	protected Date checkerDt;
	protected String checkerBy;
	
	private String actionType;
	private String bankType;
	private String vendorCode;
	private String vendorName;
	private String bookbankStatus;
	private String result;
	
	@Override
	public String getCreateBy() {
		return this.createBy;
	}

	@Override
	public Date getCreateDt() {
		return this.createDt;
	}

	@Override
	public String getUpdateBy() {
		return this.updateBy;
	}

	@Override
	public Date getUpdateDt() {
		return this.updateDt;
	}

	@Override
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Override
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	@Override
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Override
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getVendorMappayeeId() {
		return vendorMappayeeId;
	}

	public void setVendorMappayeeId(String vendorMappayeeId) {
		this.vendorMappayeeId = vendorMappayeeId;
	}

	public String getPayeeTypeDesc() {
		return payeeTypeDesc;
	}

	public void setPayeeTypeDesc(String payeeTypeDesc) {
		this.payeeTypeDesc = payeeTypeDesc;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getPayeeIdCard() {
		return payeeIdCard;
	}

	public void setPayeeIdCard(String payeeIdCard) {
		this.payeeIdCard = payeeIdCard;
	}

	public String getBankAccType() {
		return bankAccType;
	}

	public void setBankAccType(String bankAccType) {
		this.bankAccType = bankAccType;
	}

	public String getBankAccNo() {
		return bankAccNo;
	}

	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}

	public String getBankAccName() {
		return bankAccName;
	}

	public void setBankAccName(String bankAccName) {
		this.bankAccName = bankAccName;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getNewBankFlag() {
		return newBankFlag;
	}

	public void setNewBankFlag(String newBankFlag) {
		this.newBankFlag = newBankFlag;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getRecordStatusDesc() {
		return recordStatusDesc;
	}

	public void setRecordStatusDesc(String recordStatusDesc) {
		this.recordStatusDesc = recordStatusDesc;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getApproveBy() {
		return approveBy;
	}

	public void setApproveBy(String approveBy) {
		this.approveBy = approveBy;
	}

	public void setApproveDt(Date approveDt) {
		this.approveDt = approveDt;
	}

	public Date getApproveDt() {
		return approveDt;
	}

	public String getPayeeType() {
		return payeeType;
	}

	public void setPayeeType(String payeeType) {
		this.payeeType = payeeType;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getBankStatus() {
		return bankStatus;
	}

	public void setBankStatus(String bankStatus) {
		this.bankStatus = bankStatus;
	}

	public void setRenderedCheckBox(boolean renderedCheckBox) {
		this.renderedCheckBox = renderedCheckBox;
	}

	public boolean isRenderedCheckBox() {
		return renderedCheckBox;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	public String getSiteInfoId() {
		return siteInfoId;
	}

	public String getVendorMasterId() {
		return vendorMasterId;
	}

	public void setVendorMasterId(String vendorMasterId) {
		this.vendorMasterId = vendorMasterId;
	}

	public String getExportFlag() {
		return exportFlag;
	}

	public void setExportFlag(String exportFlag) {
		this.exportFlag = exportFlag;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getLotNo() {
		return lotNo;
	}

	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}

	public Date getCheckerDt() {
		return checkerDt;
	}

	public void setCheckerDt(Date checkerDt) {
		this.checkerDt = checkerDt;
	}

	public String getCheckerBy() {
		return checkerBy;
	}

	public void setCheckerBy(String checkerBy) {
		this.checkerBy = checkerBy;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getBookbankStatus() {
		return bookbankStatus;
	}

	public void setBookbankStatus(String bookbankStatus) {
		this.bookbankStatus = bookbankStatus;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}
