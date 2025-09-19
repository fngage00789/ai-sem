package th.co.ais.domain.pt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mpt001Edt extends AbstractDomain{
	
	private String actionType;
	private String contractNo;
	private String pTaxPayType;
	private String payGovtFlag;
	private String userID;
	
	private String resultMsg;
	private String pRemark;
	
	public String getpRemark() {
		return pRemark;
	}
	public void setpRemark(String pRemark) {
		this.pRemark = pRemark;
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
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getPayGovtFlag() {
		return payGovtFlag;
	}
	public void setPayGovtFlag(String payGovtFlag) {
		this.payGovtFlag = payGovtFlag;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setpTaxPayType(String pTaxPayType) {
		this.pTaxPayType = pTaxPayType;
	}
	public String getpTaxPayType() {
		return pTaxPayType;
	}
}
