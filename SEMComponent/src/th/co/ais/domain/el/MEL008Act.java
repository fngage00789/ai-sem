package th.co.ais.domain.el;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class MEL008Act extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2401317649857041611L;
	private String paymentId;
	private String pResult;
	private String pRemark;
	private String pBatchNo;
	private String actionType;
	private String userLogin;
	private String payNo;
	private String remark;
	private String collectiveDbNo;
	
	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getpResult() {
		return pResult;
	}

	public void setpResult(String pResult) {
		this.pResult = pResult;
	}

	public String getpRemark() {
		return pRemark;
	}

	public void setpRemark(String pRemark) {
		this.pRemark = pRemark;
	}

	@Override
	public String getCreateBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getCreateDt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUpdateBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getUpdateDt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCreateBy(String createBy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCreateDt(Date createDt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUpdateBy(String updateBy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUpdateDt(Date updateDt) {
		// TODO Auto-generated method stub

	}

	public String getpBatchNo() {
		return pBatchNo;
	}

	public void setpBatchNo(String pBatchNo) {
		this.pBatchNo = pBatchNo;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getPayNo() {
		return payNo;
	}

	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCollectiveDbNo() {
		return collectiveDbNo;
	}

	public void setCollectiveDbNo(String collectiveDbNo) {
		this.collectiveDbNo = collectiveDbNo;
	}

	
}
