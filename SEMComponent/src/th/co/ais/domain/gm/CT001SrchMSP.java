package th.co.ais.domain.gm;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class CT001SrchMSP extends AbstractDomain {
	
	protected String rowId;
	protected String vendorMasterId;
	protected String payeeMasterId;
	protected String bankAccNo;
	protected String payeeName;
	protected String contractNo;
	protected String expenseType;
	protected String expenseTypeDesc;
	protected String paymentType;
	protected String paymentTypeDesc;
	protected Date paymentEffDt;
	protected String payeeStatus;
	protected String payeeStatusDesc;
	protected String bookBankStatus;
	protected String bookBankStatusDesc;
	protected Date effDt;
	protected Date expireDt;
	protected String vendorBookBankId;
	protected String bankAccType;
	protected String bankAccName;
	protected String bankCode;
	protected String bankName;
	protected String bankBranch;
	protected String bankProvince;
	protected String bookBankRemark;
	protected String strPaymentEffDt;
	
	protected String vendorName;
	protected String vendorStatus;
	protected String vendorStatusDesc;
	
	protected String payeeBankAccNo;
	protected String payeeBookBankStatusDesc;
	protected String color;

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getVendorMasterId() {
		return vendorMasterId;
	}

	public void setVendorMasterId(String vendorMasterId) {
		this.vendorMasterId = vendorMasterId;
	}

	public String getPayeeMasterId() {
		return payeeMasterId;
	}

	public void setPayeeMasterId(String payeeMasterId) {
		this.payeeMasterId = payeeMasterId;
	}

	public String getBankAccNo() {
		return bankAccNo;
	}

	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getExpenseTypeDesc() {
		return expenseTypeDesc;
	}

	public void setExpenseTypeDesc(String expenseTypeDesc) {
		this.expenseTypeDesc = expenseTypeDesc;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentTypeDesc() {
		return paymentTypeDesc;
	}

	public void setPaymentTypeDesc(String paymentTypeDesc) {
		this.paymentTypeDesc = paymentTypeDesc;
	}

	public Date getPaymentEffDt() {
		return paymentEffDt;
	}

	public void setPaymentEffDt(Date paymentEffDt) {
		this.paymentEffDt = paymentEffDt;
	}

	public String getPayeeStatus() {
		return payeeStatus;
	}

	public void setPayeeStatus(String payeeStatus) {
		this.payeeStatus = payeeStatus;
	}

	public String getPayeeStatusDesc() {
		return payeeStatusDesc;
	}

	public void setPayeeStatusDesc(String payeeStatusDesc) {
		this.payeeStatusDesc = payeeStatusDesc;
	}

	public String getBookBankStatus() {
		return bookBankStatus;
	}

	public void setBookBankStatus(String bookBankStatus) {
		this.bookBankStatus = bookBankStatus;
	}

	public String getBookBankStatusDesc() {
		return bookBankStatusDesc;
	}

	public void setBookBankStatusDesc(String bookBankStatusDesc) {
		this.bookBankStatusDesc = bookBankStatusDesc;
	}

	public Date getEffDt() {
		return effDt;
	}

	public void setEffDt(Date effDt) {
		this.effDt = effDt;
	}

	public Date getExpireDt() {
		return expireDt;
	}

	public void setExpireDt(Date expireDt) {
		this.expireDt = expireDt;
	}

	public String getVendorBookBankId() {
		return vendorBookBankId;
	}

	public void setVendorBookBankId(String vendorBookBankId) {
		this.vendorBookBankId = vendorBookBankId;
	}

	public String getBankAccType() {
		return bankAccType;
	}

	public void setBankAccType(String bankAccType) {
		this.bankAccType = bankAccType;
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

	public String getBankProvince() {
		return bankProvince;
	}

	public void setBankProvince(String bankProvince) {
		this.bankProvince = bankProvince;
	}

	public String getBookBankRemark() {
		return bookBankRemark;
	}

	public void setBookBankRemark(String bookBankRemark) {
		this.bookBankRemark = bookBankRemark;
	}

	public String getStrPaymentEffDt() {
		return strPaymentEffDt;
	}

	public void setStrPaymentEffDt(String strPaymentEffDt) {
		this.strPaymentEffDt = strPaymentEffDt;
	}
	
	
	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorStatus() {
		return vendorStatus;
	}

	public void setVendorStatus(String vendorStatus) {
		this.vendorStatus = vendorStatus;
	}

	public String getVendorStatusDesc() {
		return vendorStatusDesc;
	}

	public void setVendorStatusDesc(String vendorStatusDesc) {
		this.vendorStatusDesc = vendorStatusDesc;
	}

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

	public String getPayeeBankAccNo() {
		return payeeBankAccNo;
	}

	public void setPayeeBankAccNo(String payeeBankAccNo) {
		this.payeeBankAccNo = payeeBankAccNo;
	}

	public String getPayeeBookBankStatusDesc() {
		return payeeBookBankStatusDesc;
	}

	public void setPayeeBookBankStatusDesc(String payeeBookBankStatusDesc) {
		this.payeeBookBankStatusDesc = payeeBookBankStatusDesc;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "CT001SrchMSP [bankAccName=" + bankAccName + ", bankAccNo="
				+ bankAccNo + ", bankAccType=" + bankAccType + ", bankBranch="
				+ bankBranch + ", bankCode=" + bankCode + ", bankName="
				+ bankName + ", bankProvince=" + bankProvince
				+ ", bookBankRemark=" + bookBankRemark + ", bookBankStatus="
				+ bookBankStatus + ", bookBankStatusDesc=" + bookBankStatusDesc
				+ ", contractNo=" + contractNo + ", effDt=" + effDt
				+ ", expenseType=" + expenseType + ", expenseTypeDesc="
				+ expenseTypeDesc + ", expireDt=" + expireDt
				+ ", payeeMasterId=" + payeeMasterId + ", payeeName="
				+ payeeName + ", payeeStatus=" + payeeStatus
				+ ", payeeStatusDesc=" + payeeStatusDesc + ", paymentEffDt="
				+ paymentEffDt + ", paymentType=" + paymentType
				+ ", paymentTypeDesc=" + paymentTypeDesc + ", rowId=" + rowId
				+ ", strPaymentEffDt=" + strPaymentEffDt
				+ ", vendorBookBankId=" + vendorBookBankId
				+ ", vendorMasterId=" + vendorMasterId + ", vendorName="
				+ vendorName + ", vendorStatus=" + vendorStatus
				+ ", vendorStatusDesc=" + vendorStatusDesc + "]";
	}

}
