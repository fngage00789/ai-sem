package th.co.ais.domain.rt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mrt001SrchRentPay extends AbstractDomain {

	private Date periodStartDt;
	private String periodNoStart;
	private String expenseType;
	private String expenseTypeDesc;
	private String vendorCode;
	private String vendorName;
	private String payeeName;
	private String payPeriodType;
	private String payPeriodY;
	private String payPeriodM;
	private String payPeriodD;
	private Double excAmt;
	private Double vatAmt;
	private Double whtRate;
	private Double whtAmt;
	private Double incAmt;
	private String paymentStatusDesc;
	private String siteStatus;
	private String remark;
	private String periodStartDtStr;
	private String rentalPaymentId;
	
	private String serviceId;
	private String serviceName;
	
	private String expenseDesc;
	
	public Date getPeriodStartDt() {
		return periodStartDt;
	}

	public void setPeriodStartDt(Date periodStartDt) {
		this.periodStartDt = periodStartDt;
	}

	public String getPeriodNoStart() {
		return periodNoStart;
	}

	public void setPeriodNoStart(String periodNoStart) {
		this.periodNoStart = periodNoStart;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getExpenseTypeDesc() {
		return expenseTypeDesc;
	}

	public void setExpenseTypeDesc(String expenseTypeDesc) {
		this.expenseTypeDesc = expenseTypeDesc;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getPayPeriodType() {
		return payPeriodType;
	}

	public void setPayPeriodType(String payPeriodType) {
		this.payPeriodType = payPeriodType;
	}

	public String getPayPeriodY() {
		return payPeriodY;
	}

	public void setPayPeriodY(String payPeriodY) {
		this.payPeriodY = payPeriodY;
	}

	public String getPayPeriodM() {
		return payPeriodM;
	}

	public void setPayPeriodM(String payPeriodM) {
		this.payPeriodM = payPeriodM;
	}

	public String getPayPeriodD() {
		return payPeriodD;
	}

	public void setPayPeriodD(String payPeriodD) {
		this.payPeriodD = payPeriodD;
	}

	public Double getExcAmt() {
		return excAmt;
	}

	public void setExcAmt(Double excAmt) {
		this.excAmt = excAmt;
	}

	public Double getVatAmt() {
		return vatAmt;
	}

	public void setVatAmt(Double vatAmt) {
		this.vatAmt = vatAmt;
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

	public Double getIncAmt() {
		return incAmt;
	}

	public void setIncAmt(Double incAmt) {
		this.incAmt = incAmt;
	}

	public String getPaymentStatusDesc() {
		return paymentStatusDesc;
	}

	public void setPaymentStatusDesc(String paymentStatusDesc) {
		this.paymentStatusDesc = paymentStatusDesc;
	}

	public String getSiteStatus() {
		return siteStatus;
	}

	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getPeriodStartDtStr() {
		return periodStartDtStr;
	}

	public void setPeriodStartDtStr(String periodStartDtStr) {
		this.periodStartDtStr = periodStartDtStr;
	}

	public String getRentalPaymentId() {
		return rentalPaymentId;
	}

	public void setRentalPaymentId(String rentalPaymentId) {
		this.rentalPaymentId = rentalPaymentId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getExpenseDesc() {
		return expenseDesc;
	}

	public void setExpenseDesc(String expenseDesc) {
		this.expenseDesc = expenseDesc;
	}

	
	
}
