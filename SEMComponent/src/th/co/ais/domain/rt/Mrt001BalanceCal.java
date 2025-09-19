package th.co.ais.domain.rt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mrt001BalanceCal extends AbstractDomain {
	
	private String result;
	private String remark;
	private Double balanceAmt;
	private Double rentalAmt;
	private String rentPeriodType;
	private Date effectiveDt;
	private Date expireDt;
	private String payPeriodType;
	private Integer payPeriod;
	private Date periodStartDt;
	private Date periodEndDt;
	private Double periodAmt;
	private String siteRentCondId;
	private String vendorMasterId;
	private String payeeMasterId;
	
	private String code;
	private String topicSeq;
	private String topic;
	private String detail;
	
	
	public Double getRentalAmt() {
		return rentalAmt;
	}

	public void setRentalAmt(Double rentalAmt) {
		this.rentalAmt = rentalAmt;
	}

	public String getRentPeriodType() {
		return rentPeriodType;
	}

	public void setRentPeriodType(String rentPeriodType) {
		this.rentPeriodType = rentPeriodType;
	}

	public Date getEffectiveDt() {
		return effectiveDt;
	}

	public void setEffectiveDt(Date effectiveDt) {
		this.effectiveDt = effectiveDt;
	}

	public Date getExpireDt() {
		return expireDt;
	}

	public void setExpireDt(Date expireDt) {
		this.expireDt = expireDt;
	}

	public String getPayPeriodType() {
		return payPeriodType;
	}

	public void setPayPeriodType(String payPeriodType) {
		this.payPeriodType = payPeriodType;
	}

	public Integer getPayPeriod() {
		return payPeriod;
	}

	public void setPayPeriod(Integer payPeriod) {
		this.payPeriod = payPeriod;
	}

	public Date getPeriodStartDt() {
		return periodStartDt;
	}

	public void setPeriodStartDt(Date periodStartDt) {
		this.periodStartDt = periodStartDt;
	}

	public Date getPeriodEndDt() {
		return periodEndDt;
	}

	public void setPeriodEndDt(Date periodEndDt) {
		this.periodEndDt = periodEndDt;
	}

	public Double getPeriodAmt() {
		return periodAmt;
	}

	public void setPeriodAmt(Double periodAmt) {
		this.periodAmt = periodAmt;
	}

	public String getSiteRentCondId() {
		return siteRentCondId;
	}

	public void setSiteRentCondId(String siteRentCondId) {
		this.siteRentCondId = siteRentCondId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getBalanceAmt() {
		return balanceAmt;
	}

	public void setBalanceAmt(Double balanceAmt) {
		this.balanceAmt = balanceAmt;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTopicSeq() {
		return topicSeq;
	}

	public void setTopicSeq(String topicSeq) {
		this.topicSeq = topicSeq;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	
	
}
