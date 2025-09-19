package th.co.ais.domain.pt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mpt001SrchHist extends AbstractDomain{

	private String rowId;
	private String contractNo;
	private String pTaxPayDescHist;
	private String pTaxPayDesc;
	private String payGovtFlagHist;
	private String payGovtFlag;
	
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
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getpTaxPayDescHist() {
		return pTaxPayDescHist;
	}
	public void setpTaxPayDescHist(String pTaxPayDescHist) {
		this.pTaxPayDescHist = pTaxPayDescHist;
	}
	public String getpTaxPayDesc() {
		return pTaxPayDesc;
	}
	public void setpTaxPayDesc(String pTaxPayDesc) {
		this.pTaxPayDesc = pTaxPayDesc;
	}
	public String getPayGovtFlagHist() {
		return payGovtFlagHist;
	}
	public void setPayGovtFlagHist(String payGovtFlagHist) {
		this.payGovtFlagHist = payGovtFlagHist;
	}
	public String getPayGovtFlag() {
		return payGovtFlag;
	}
	public void setPayGovtFlag(String payGovtFlag) {
		this.payGovtFlag = payGovtFlag;
	}
}
