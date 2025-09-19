package th.co.ais.domain.cp;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class ConstructionPermissionSavePay extends AbstractDomain{

	private String conResultStatus;
	private String conBuildDocno;
	private String conBillNo;
	private Double conBillAmt;
	private String conWbs;
	private String conBillPayFlag;
	private String conBillPayStatus;
	
	private String resultMsg;
	private String pRemark;
	
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
	public String getConResultStatus() {
		return conResultStatus;
	}
	public void setConResultStatus(String conResultStatus) {
		this.conResultStatus = conResultStatus;
	}
	public String getConBuildDocno() {
		return conBuildDocno;
	}
	public void setConBuildDocno(String conBuildDocno) {
		this.conBuildDocno = conBuildDocno;
	}
	public String getConBillNo() {
		return conBillNo;
	}
	public void setConBillNo(String conBillNo) {
		this.conBillNo = conBillNo;
	}
	public Double getConBillAmt() {
		return conBillAmt;
	}
	public void setConBillAmt(Double conBillAmt) {
		this.conBillAmt = conBillAmt;
	}
	public String getConWbs() {
		return conWbs;
	}
	public void setConWbs(String conWbs) {
		this.conWbs = conWbs;
	}
	public String getConBillPayFlag() {
		return conBillPayFlag;
	}
	public void setConBillPayFlag(String conBillPayFlag) {
		this.conBillPayFlag = conBillPayFlag;
	}
	public String getConBillPayStatus() {
		return conBillPayStatus;
	}
	public void setConBillPayStatus(String conBillPayStatus) {
		this.conBillPayStatus = conBillPayStatus;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public String getpRemark() {
		return pRemark;
	}
	public void setpRemark(String pRemark) {
		this.pRemark = pRemark;
	}
}
