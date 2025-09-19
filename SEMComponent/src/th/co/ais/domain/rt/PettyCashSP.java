package th.co.ais.domain.rt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class PettyCashSP extends AbstractDomain {

	private String rowId;
	private String pettyCashType;
	private Date receiveDt;
	private Double pettyCashAmt;
	private Date clearDt;
	private Double clearAmt;
	private Double balanceAmt;
	private Double bfAmt;
	private String remark;
	private String editFlag;
	
	private String company;
	private Date clearDtFrom;
	private Date clearDtTo;
	private Date receiveDtFrom;
	private Date receiveDtTo;
	
	private String statusResult;
	private String refClrBatchNo; 
	
	
	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getPettyCashType() {
		return pettyCashType;
	}
	public void setPettyCashType(String pettyCashType) {
		this.pettyCashType = pettyCashType;
	}
	
	public Double getPettyCashAmt() {
		return pettyCashAmt;
	}
	public void setPettyCashAmt(Double pettyCashAmt) {
		this.pettyCashAmt = pettyCashAmt;
	}
	public Date getClearDt() {
		return clearDt;
	}
	public void setClearDt(Date clearDt) {
		this.clearDt = clearDt;
	}
	public Double getClearAmt() {
		return clearAmt;
	}
	public void setClearAmt(Double clearAmt) {
		this.clearAmt = clearAmt;
	}
	public Double getBalanceAmt() {
		return balanceAmt;
	}
	public void setBalanceAmt(Double balanceAmt) {
		this.balanceAmt = balanceAmt;
	}
	public Double getBfAmt() {
		return bfAmt;
	}
	public void setBfAmt(Double bfAmt) {
		this.bfAmt = bfAmt;
	}
	
	public Date getReceiveDt() {
		return receiveDt;
	}
	public void setReceiveDt(Date receiveDt) {
		this.receiveDt = receiveDt;
	}
	public Date getReceiveDtTo() {
		return receiveDtTo;
	}
	public void setReceiveDtTo(Date receiveDtTo) {
		this.receiveDtTo = receiveDtTo;
	}
	
	public Date getClearDtFrom() {
		return clearDtFrom;
	}
	public void setClearDtFrom(Date clearDtFrom) {
		this.clearDtFrom = clearDtFrom;
	}
	public Date getReceiveDtFrom() {
		return receiveDtFrom;
	}
	public void setReceiveDtFrom(Date receiveDtFrom) {
		this.receiveDtFrom = receiveDtFrom;
	}
	public Date getClearDtTo() {
		return clearDtTo;
	}
	public void setClearDtTo(Date clearDtTo) {
		this.clearDtTo = clearDtTo;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getEditFlag() {
		return editFlag;
	}
	public void setEditFlag(String editFlag) {
		this.editFlag = editFlag;
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
	public String getStatusResult() {
		return statusResult;
	}
	public void setStatusResult(String statusResult) {
		this.statusResult = statusResult;
	}
	public String getRefClrBatchNo() {
		return refClrBatchNo;
	}
	public void setRefClrBatchNo(String refClrBatchNo) {
		this.refClrBatchNo = refClrBatchNo;
	}
	
}
