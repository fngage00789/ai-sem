package th.co.ais.domain.gm;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import th.co.ais.domain.AbstractDomain;

public class BankMasterSP extends AbstractDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4177940511847754923L;

	protected String rowId; //BANK_ID
	
	protected String bankGroupCode;
	protected String bankCode;
	protected String bankName;
	protected String bankBranchCode;
	protected String bankBranch;
	protected String provinceId;
	protected String provinceTh;
	
	protected String actionType;
	protected String retResult;
	
	protected String createDtStr;
	protected String UpdateDtStr;
	
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
	
	public String getCreateDtStr() {
		return createDtStr;
	}
	public void setCreateDtStr(String createDtStr) {
		this.createDtStr = createDtStr;
	}
	public String getUpdateDtStr() {
		return UpdateDtStr;
	}
	public void setUpdateDtStr(String updateDtStr) {
		UpdateDtStr = updateDtStr;
	}
	
	@Override
	public String toString() {
		return "BankMasterSP [UpdateDtStr=" + UpdateDtStr + ", actionType="
				+ actionType + ", bankBranch=" + bankBranch
				+ ", bankBranchCode=" + bankBranchCode + ", bankCode="
				+ bankCode + ", bankGroupCode=" + bankGroupCode + ", bankName="
				+ bankName + ", createDtStr=" + createDtStr + ", provinceId="
				+ provinceId + ", provinceTh=" + provinceTh + ", retResult="
				+ retResult + ", rowId=" + rowId + ", createBy=" + createBy
				+ ", createDt=" + createDt + ", currentUser=" + currentUser
				+ ", updateBy=" + updateBy + ", updateDt=" + updateDt + "]";
	}
	
	public String getBankGroupCode() {
		return bankGroupCode;
	}
	public void setBankGroupCode(String bankGroupCode) {
		this.bankGroupCode = bankGroupCode;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
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
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getProvinceTh() {
		return provinceTh;
	}
	public void setProvinceTh(String provinceTh) {
		this.provinceTh = provinceTh;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getRetResult() {
		return retResult;
	}
	public void setRetResult(String retResult) {
		this.retResult = retResult;
	}

	@Override
	public boolean equals(Object other) {
		if(!(other instanceof BankMasterSP))
			return false;
		
		if(other == this)
			return true;
		
		BankMasterSP otherBank = (BankMasterSP) other;
		
		EqualsBuilder builder = new EqualsBuilder()
		.append(bankGroupCode, otherBank.getBankGroupCode())
		.append(bankName, otherBank.getBankName());
		
		if(otherBank.getBankBranchCode() != null && otherBank.getBankBranch() != null && otherBank.getProvinceId() != null) { 
			builder.append(bankBranchCode, otherBank.getBankBranchCode())
			.append(bankBranch, otherBank.getBankBranch())
			.append(provinceId, otherBank.getProvinceId());
		}
		
		return builder.isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
		.append(bankGroupCode)
		.append(bankName)
		.toHashCode();
	}
	
}
