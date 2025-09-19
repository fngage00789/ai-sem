package th.co.ais.domain.rt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class RentalPayNormalEditSaveSP extends AbstractDomain{
	
	private String rentalPaymentId;
	private Integer calYear;
	private Integer calMonth;
	private String vatType;
	private Double excAmt;
	private Double vatRate;
	private Double vatAmt;
	private Double incAmt;
	private Double whtRate;
	private Double whtAmt;
	private String resultMsg;
	private String userId;
	private Integer discountRate;
	private Double discountAmt;
	private String fineFlag;
	private String extraFlag;
	private String deleteFlag;
	private String expenseType;
	private Date dueDt;
	private String payPeriodType;
	private String whtType;
	private String pRemark;
	
	private String discountFlag;
	private String discountCond;
	
	
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
	
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public String getRentalPaymentId() {
		return rentalPaymentId;
	}
	public void setRentalPaymentId(String rentalPaymentId) {
		this.rentalPaymentId = rentalPaymentId;
	}
	public Integer getCalYear() {
		return calYear;
	}
	public void setCalYear(Integer calYear) {
		this.calYear = calYear;
	}
	public Integer getCalMonth() {
		return calMonth;
	}
	public void setCalMonth(Integer calMonth) {
		this.calMonth = calMonth;
	}
	public String getVatType() {
		return vatType;
	}
	public void setVatType(String vatType) {
		this.vatType = vatType;
	}
	public Double getExcAmt() {
		return excAmt;
	}
	public void setExcAmt(Double excAmt) {
		this.excAmt = excAmt;
	}
	public Double getVatRate() {
		return vatRate;
	}
	public void setVatRate(Double vatRate) {
		this.vatRate = vatRate;
	}
	public Double getVatAmt() {
		return vatAmt;
	}
	public void setVatAmt(Double vatAmt) {
		this.vatAmt = vatAmt;
	}
	public Double getIncAmt() {
		return incAmt;
	}
	public void setIncAmt(Double incAmt) {
		this.incAmt = incAmt;
	}
	public Double getWhtRate() {
		return whtRate;
	}
	public void setWhtRate(Double whtRate) {
		this.whtRate = whtRate;
	}
	public Double getWhtAmt() {
		return whtAmt;
	}
	public void setWhtAmt(Double whtAmt) {
		this.whtAmt = whtAmt;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserId() {
		return userId;
	}
	public Integer getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(Integer discountRate) {
		this.discountRate = discountRate;
	}
	public Double getDiscountAmt() {
		return discountAmt;
	}
	public void setDiscountAmt(Double discountAmt) {
		this.discountAmt = discountAmt;
	}
	public String getFineFlag() {
		return fineFlag;
	}
	public void setFineFlag(String fineFlag) {
		this.fineFlag = fineFlag;
	}
	public String getExtraFlag() {
		return extraFlag;
	}
	public void setExtraFlag(String extraFlag) {
		this.extraFlag = extraFlag;
	}
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public Date getDueDt() {
		return dueDt;
	}
	public void setDueDt(Date dueDt) {
		this.dueDt = dueDt;
	}
	public String getPayPeriodType() {
		return payPeriodType;
	}
	public void setPayPeriodType(String payPeriodType) {
		this.payPeriodType = payPeriodType;
	}
	public String getWhtType() {
		return whtType;
	}
	public void setWhtType(String whtType) {
		this.whtType = whtType;
	}
	public String getDiscountFlag() {
		return discountFlag;
	}
	public void setDiscountFlag(String discountFlag) {
		this.discountFlag = discountFlag;
	}
	public String getDiscountCond() {
		return discountCond;
	}
	public void setDiscountCond(String discountCond) {
		this.discountCond = discountCond;
	}
	
}
