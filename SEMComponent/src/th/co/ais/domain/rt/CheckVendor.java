package th.co.ais.domain.rt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class CheckVendor extends AbstractDomain{

	private String vendorMasterId;
	private String payeeMasterId;
	private String expenseType;
	private String contractNo;
	private String msgWarning;
	
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
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	/**
	 * @param msgWarning the msgWarning to set
	 */
	public void setMsgWarning(String msgWarning) {
		this.msgWarning = msgWarning;
	}
	/**
	 * @return the msgWarning
	 */
	public String getMsgWarning() {
		return msgWarning;
	}
}
