package th.co.ais.domain.ir;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mir004SP extends AbstractDomain{

	private static final long serialVersionUID = -4764652728306674596L;
	
	private String company;
	private String networkType;
	private String transferType;
	private Date effDateFrom;
	private Date effDateTo;
	
	private String networkTypeDesc;
	private String transferTypeDesc;
	private String lossType;
	private String lossTypeDesc;
	private Double deductAmt;
	private Date effDate;
	
	private String result;
	private String msgError;

	private String effDateStr;
	private String updateDtStr;
	
	public Mir004SP() {
		this.rowId = null;
	}
	
	public Mir004SP(Mir004SP tmp) {
		this.rowId = tmp.getRowId();
		this.company = tmp.getCompany();
		this.networkType = tmp.getNetworkType();
		this.transferType = tmp.getTransferType();
		this.lossType = tmp.getLossType();
		this.deductAmt = tmp.getDeductAmt();
		this.effDate = tmp.getEffDate();
	}
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	public String getTransferType() {
		return transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	public String getNetworkTypeDesc() {
		return networkTypeDesc;
	}

	public void setNetworkTypeDesc(String networkTypeDesc) {
		this.networkTypeDesc = networkTypeDesc;
	}

	public String getTransferTypeDesc() {
		return transferTypeDesc;
	}

	public void setTransferTypeDesc(String transferTypeDesc) {
		this.transferTypeDesc = transferTypeDesc;
	}

	public Date getEffDateFrom() {
		return effDateFrom;
	}

	public void setEffDateFrom(Date effDateFrom) {
		this.effDateFrom = effDateFrom;
	}

	public Date getEffDateTo() {
		return effDateTo;
	}

	public void setEffDateTo(Date effDateTo) {
		this.effDateTo = effDateTo;
	}
	
	public String getLossType() {
		return lossType;
	}

	public void setLossType(String lossType) {
		this.lossType = lossType;
	}

	public String getLossTypeDesc() {
		return lossTypeDesc;
	}

	public void setLossTypeDesc(String lossTypeDesc) {
		this.lossTypeDesc = lossTypeDesc;
	}

	public Double getDeductAmt() {
		return deductAmt;
	}

	public void setDeductAmt(Double deductAmt) {
		this.deductAmt = deductAmt;
	}

	public Date getEffDate() {
		return effDate;
	}

	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMsgError() {
		return msgError;
	}

	public void setMsgError(String msgError) {
		this.msgError = msgError;
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

	public String getEffDateStr() {
		return effDateStr;
	}

	public void setEffDateStr(String effDateStr) {
		this.effDateStr = effDateStr;
	}

	public String getUpdateDtStr() {
		return updateDtStr;
	}

	public void setUpdateDtStr(String updateDtStr) {
		this.updateDtStr = updateDtStr;
	}

}
