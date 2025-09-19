package th.co.ais.domain.mm;

import java.util.Date;
import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.DateUtil;

public class Mmm001PaymentSP extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2562220312415010775L;

	private String rowId;
	
	private String contractNo;
	private String payeeStatus;
	private String expenseType;
	
	private String accountType;
	private String accountNo;
	private String accountName;
	
	private String bankCode;
	private String bankName;
	private String bankBranchCode;
	private String bankBranch;
	
	private String province;
	private String remark;
	
	private Date bookbankEffectiveDt;
	private String bookbankEffectiveDtStr;
	private Date effectiveDt;
	private String effectiveDtStr;
	private Date expireDt;
	private String expireDtStr;
	
	@Override
	public String getCreateBy() {
		return createBy;
	}
	@Override
	public Date getCreateDt() {
		return createDt;
	}
	@Override
	public String getUpdateBy() {
		return updateBy;
	}
	@Override
	public Date getUpdateDt() {
		return updateDt;
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
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getPayeeStatus() {
		return payeeStatus;
	}
	public void setPayeeStatus(String payeeStatus) {
		this.payeeStatus = payeeStatus;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
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
	public String getBankBranchCode() {
		return bankBranchCode;
	}
	public void setBankBranchCode(String bankBranchCode) {
		this.bankBranchCode = bankBranchCode;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getBookbankEffectiveDt() throws Exception {
		if(bookbankEffectiveDtStr != null){
			bookbankEffectiveDt = DateUtil.getDate(bookbankEffectiveDtStr, DateUtil.SIMPLE_DATE_PATTERN);
		}
		return bookbankEffectiveDt;
	}
	public void setBookbankEffectiveDt(Date bookbankEffectiveDt) {
		this.bookbankEffectiveDt = bookbankEffectiveDt;
	}
	public String getBookbankEffectiveDtStr() {
		return bookbankEffectiveDtStr;
	}
	public void setBookbankEffectiveDtStr(String bookbankEffectiveDtStr) {
		this.bookbankEffectiveDtStr = bookbankEffectiveDtStr;
	}
	public Date getEffectiveDt() throws Exception {
		if(effectiveDtStr != null){
			effectiveDt = DateUtil.getDate(effectiveDtStr, DateUtil.SIMPLE_DATE_PATTERN);
		}
		return effectiveDt;
	}
	public void setEffectiveDt(Date effectiveDt) {
		this.effectiveDt = effectiveDt;
	}
	public String getEffectiveDtStr() {
		return effectiveDtStr;
	}
	public void setEffectiveDtStr(String effectiveDtStr) {
		this.effectiveDtStr = effectiveDtStr;
	}
	public Date getExpireDt() throws Exception {
		if(expireDtStr != null){
			expireDt = DateUtil.getDate(expireDtStr, DateUtil.SIMPLE_DATE_PATTERN);
		}
		return expireDt;
	}
	public void setExpireDt(Date expireDt) {
		this.expireDt = expireDt;
	}
	public String getExpireDtStr() {
		return expireDtStr;
	}
	public void setExpireDtStr(String expireDtStr) {
		this.expireDtStr = expireDtStr;
	}
	
	@Override
	public String toString() {
		return "Mmm001PaymentSP [accountName=" + accountName + ", accountNo=" + accountNo + ", accountType=" + accountType + ", bankBranch=" + bankBranch + ", bankBranchCode=" + bankBranchCode + ", bankCode=" + bankCode + ", bankName=" + bankName + ", bookbankEffectiveDt=" + bookbankEffectiveDt + ", bookbankEffectiveDtStr=" + bookbankEffectiveDtStr + ", contractNo=" + contractNo + ", effectiveDt=" + effectiveDt + ", effectiveDtStr=" + effectiveDtStr + ", expenseType=" + expenseType + ", expireDt=" + expireDt + ", expireDtStr=" + expireDtStr + ", payeeStatus=" + payeeStatus + ", province=" + province + ", remark=" + remark + ", rowId=" + rowId + "]";
	}

}
