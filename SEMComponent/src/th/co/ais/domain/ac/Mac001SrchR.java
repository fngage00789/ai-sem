package th.co.ais.domain.ac;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mac001SrchR extends AbstractDomain{
	
	private String transPaymemtId;
	private String paymentStatusDesc;
	private Date paymentStatusDt;
	private String reason;
	
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
	public String getTransPaymemtId() {
		return transPaymemtId;
	}
	public void setTransPaymemtId(String transPaymemtId) {
		this.transPaymemtId = transPaymemtId;
	}
	public String getPaymentStatusDesc() {
		return paymentStatusDesc;
	}
	public void setPaymentStatusDesc(String paymentStatusDesc) {
		this.paymentStatusDesc = paymentStatusDesc;
	}
	public Date getPaymentStatusDt() {
		return paymentStatusDt;
	}
	public void setPaymentStatusDt(Date paymentStatusDt) {
		this.paymentStatusDt = paymentStatusDt;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}
