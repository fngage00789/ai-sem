package th.co.ais.domain.gm;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class PayeeMasterSP extends AbstractDomain {
	
	protected String rowId;
	protected String payeeName;
	protected String idCard;
	protected String taxId;
	protected String address;
	
	protected String vendorMapPayeeId;
	protected String userId;
	protected String statusResult;
//	protected String contractNo;
//	protected String siteName;
//	protected String recordStatus;
//	protected String bankAccNo;
//	protected String bankAccName;
//	protected String vendorStatus;
//	protected String bookBankStatus;
//	protected String remark;
//	protected String vendorType;
//	protected String vendorMasterId;
	
	protected String taxId13;
	
	
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
//	public String getContractNo() {
//		return contractNo;
//	}
//
//	public void setContractNo(String contractNo) {
//		this.contractNo = contractNo;
//	}
//
//	public String getSiteName() {
//		return siteName;
//	}
//
//	public void setSiteName(String siteName) {
//		this.siteName = siteName;
//	}
//
//	public String getRecordStatus() {
//		return recordStatus;
//	}
//
//	public void setRecordStatus(String recordStatus) {
//		this.recordStatus = recordStatus;
//	}
//	
//
//	public String getBankAccNo() {
//		return bankAccNo;
//	}
//
//	public void setBankAccNo(String bankAccNo) {
//		this.bankAccNo = bankAccNo;
//	}
//
//	public String getBankAccName() {
//		return bankAccName;
//	}
//
//	public void setBankAccName(String bankAccName) {
//		this.bankAccName = bankAccName;
//	}
//	
//	public String getVendorStatus() {
//		return vendorStatus;
//	}
//
//	public void setVendorStatus(String vendorStatus) {
//		this.vendorStatus = vendorStatus;
//	}
//
//	public String getBookBankStatus() {
//		return bookBankStatus;
//	}
//
//	public void setBookBankStatus(String bookBankStatus) {
//		this.bookBankStatus = bookBankStatus;
//	}
//	
//	public String getRemark() {
//		return remark;
//	}
//
//	public void setRemark(String remark) {
//		this.remark = remark;
//	}
//	
//	public String getVendorType() {
//		return vendorType;
//	}
//
//	public void setVendorType(String vendorType) {
//		this.vendorType = vendorType;
//	}
//	public String getVendorMasterId() {
//		return vendorMasterId;
//	}
//
//	public void setVendorMasterId(String vendorMasterId) {
//		this.vendorMasterId = vendorMasterId;
//	}

	
	public String getVendorMapPayeeId() {
		return vendorMapPayeeId;
	}

	public void setVendorMapPayeeId(String vendorMapPayeeId) {
		this.vendorMapPayeeId = vendorMapPayeeId;
	}

	public String getStatusResult() {
		return statusResult;
	}

	public void setStatusResult(String statusResult) {
		this.statusResult = statusResult;
	}

	public String getTaxId13() {
		return taxId13;
	}

	public void setTaxId13(String taxId13) {
		this.taxId13 = taxId13;
	}

	@Override
	public String getCreateBy() {
		return this.createBy;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

}
