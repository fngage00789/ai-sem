package th.co.ais.domain.el;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mel014UpdatePeriod extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5675950276504461567L;
	private String paymentId;
	private String period;
	private String userId;
	private String pResult;
	
	
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
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

}
