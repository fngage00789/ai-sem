package th.co.ais.domain.rt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

@SuppressWarnings("serial")
public class Mrt001UpdRentPay extends AbstractDomain {

	private String expenseType;
	private String rentCondType;
	private String rentalDetailId;
	private String mode;
	
	private String siteInfoId;
	private String serviceName;
	private String serviceId;
	private Double configRate;
	private String result;
	private Double periodAmt;
	
	private String rentalCalCode;  // Type to cal
	
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getRentCondType() {
		return rentCondType;
	}
	public void setRentCondType(String rentCondType) {
		this.rentCondType = rentCondType;
	}
	public String getRentalDetailId() {
		return rentalDetailId;
	}
	public void setRentalDetailId(String rentalDetailId) {
		this.rentalDetailId = rentalDetailId;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
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
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public Double getConfigRate() {
		return configRate;
	}
	public void setConfigRate(Double configRate) {
		this.configRate = configRate;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getRentalCalCode() {
		return rentalCalCode;
	}
	public void setRentalCalCode(String rentalCalCode) {
		this.rentalCalCode = rentalCalCode;
	}
	public Double getPeriodAmt() {
		return periodAmt;
	}
	public void setPeriodAmt(Double periodAmt) {
		this.periodAmt = periodAmt;
	}

}
