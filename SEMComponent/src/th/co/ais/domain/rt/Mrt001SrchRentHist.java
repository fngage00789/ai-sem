package th.co.ais.domain.rt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mrt001SrchRentHist extends AbstractDomain {

	private String rentalMasterId;
	
	private String rentalDetailId;
	private String expenseTypeName;
	private String vendorCode;
	private String vendorName;
	private String payeeName;
	private String whtType;
	private String whtRate;
	private String whtTypeName;
	private String vatType;
	private String vatRate;
	private String vatTypeName;
	private String payPeriodTypeName;
	private Double periodAmt;
	private String remark;
	private Date effDt;
	private Date expiredDt;
	private Date periodStartDt;
	private Date periodEndDt;
	
	private String periodStartDtStr;
	private String periodEndDtStr;
	
	private String serviceId;
	private String serviceName;
	
	//added 20/03/2023
	private String expenseDesc;
	
	
	public String getRentalMasterId() {
		return rentalMasterId;
	}

	public void setRentalMasterId(String rentalMasterId) {
		this.rentalMasterId = rentalMasterId;
	}

	public String getRentalDetailId() {
		return rentalDetailId;
	}

	public void setRentalDetailId(String rentalDetailId) {
		this.rentalDetailId = rentalDetailId;
	}

	public String getExpenseTypeName() {
		return expenseTypeName;
	}

	public void setExpenseTypeName(String expenseTypeName) {
		this.expenseTypeName = expenseTypeName;
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

	public String getWhtType() {
		return whtType;
	}

	public void setWhtType(String whtType) {
		this.whtType = whtType;
	}

	public String getWhtRate() {
		return whtRate;
	}

	public void setWhtRate(String whtRate) {
		this.whtRate = whtRate;
	}

	public String getWhtTypeName() {
		return whtTypeName;
	}

	public void setWhtTypeName(String whtTypeName) {
		this.whtTypeName = whtTypeName;
	}

	public String getVatType() {
		return vatType;
	}

	public void setVatType(String vatType) {
		this.vatType = vatType;
	}

	public String getVatRate() {
		return vatRate;
	}

	public void setVatRate(String vatRate) {
		this.vatRate = vatRate;
	}

	public String getVatTypeName() {
		return vatTypeName;
	}

	public void setVatTypeName(String vatTypeName) {
		this.vatTypeName = vatTypeName;
	}

	public String getPayPeriodTypeName() {
		return payPeriodTypeName;
	}

	public void setPayPeriodTypeName(String payPeriodTypeName) {
		this.payPeriodTypeName = payPeriodTypeName;
	}

	public Double getPeriodAmt() {
		return periodAmt;
	}

	public void setPeriodAmt(Double periodAmt) {
		this.periodAmt = periodAmt;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getEffDt() {
		return effDt;
	}

	public void setEffDt(Date effDt) {
		this.effDt = effDt;
	}

	public Date getExpiredDt() {
		return expiredDt;
	}

	public void setExpiredDt(Date expiredDt) {
		this.expiredDt = expiredDt;
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

	public String getPeriodEndDtStr() {
		return periodEndDtStr;
	}

	public void setPeriodEndDtStr(String periodEndDtStr) {
		this.periodEndDtStr = periodEndDtStr;
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
