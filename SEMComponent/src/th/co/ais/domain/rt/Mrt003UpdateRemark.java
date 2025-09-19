package th.co.ais.domain.rt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mrt003UpdateRemark extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7450285222937541590L;
	private String rentalPaymentId;
	private String remark;
	private String remarkOther;
	private String userId;
	private String pResult;

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
	public String getRentalPaymentId() {
		return rentalPaymentId;
	}
	public void setRentalPaymentId(String rentalPaymentId) {
		this.rentalPaymentId = rentalPaymentId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getpResult() {
		return pResult;
	}
	public void setpResult(String pResult) {
		this.pResult = pResult;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRemarkOther() {
		return remarkOther;
	}
	public void setRemarkOther(String remarkOther) {
		this.remarkOther = remarkOther;
	}
	
	
}
