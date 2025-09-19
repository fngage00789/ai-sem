package th.co.ais.domain.rt;

import java.util.ArrayList;
import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mrt001RentCal extends AbstractDomain {

	private Double rentalAmt;
	private String rentPeriodType;
	private Integer payPeriod;
	private String payPeriodType;
	private Integer periodYear;
    private Integer periodMonth;
    private Integer periodDay;
    
	private String siteInfoId;
	private String serviceName;

	private String rentalCalCode;
	private String serviceId;
	private Double configRate;
	
	private String vResult;
	private String vMessage;
	
	private Integer totPeriodNo;
	private Double periodAmt;
	
	private String inputPercent;
	private String inputAmt;
	private String serviceList;
	
	private String rentalDetailId;
	private String user; 
	
	private String rentalCaldetail;
	private Double calAmt;
	
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
	public Integer getPayPeriod() {
		return payPeriod;
	}
	public void setPayPeriod(Integer payPeriod) {
		this.payPeriod = payPeriod;
	}
	public String getPayPeriodType() {
		return payPeriodType;
	}
	public void setPayPeriodType(String payPeriodType) {
		this.payPeriodType = payPeriodType;
	}
	public Integer getPeriodYear() {
		return periodYear;
	}
	public void setPeriodYear(Integer periodYear) {
		this.periodYear = periodYear;
	}
	public Integer getPeriodMonth() {
		return periodMonth;
	}
	public void setPeriodMonth(Integer periodMonth) {
		this.periodMonth = periodMonth;
	}
	public Integer getPeriodDay() {
		return periodDay;
	}
	public void setPeriodDay(Integer periodDay) {
		this.periodDay = periodDay;
	}
	public Integer getTotPeriodNo() {
		return totPeriodNo;
	}
	public void setTotPeriodNo(Integer totPeriodNo) {
		this.totPeriodNo = totPeriodNo;
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
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getRentalCalCode() {
		return rentalCalCode;
	}
	public void setRentalCalCode(String rentalCalCode) {
		this.rentalCalCode = rentalCalCode;
	}

	public String getvResult() {
		return vResult;
	}
	public void setvResult(String vResult) {
		this.vResult = vResult;
	}
	public String getvMessage() {
		return vMessage;
	}
	public void setvMessage(String vMessage) {
		this.vMessage = vMessage;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public Double getConfigRate() {
		return configRate;
	}
	public void setConfigRate(Double configRate) {
		this.configRate = configRate;
	}
	public String getInputPercent() {
		return inputPercent;
	}
	public void setInputPercent(String inputPercent) {
		this.inputPercent = inputPercent;
	}
	public String getInputAmt() {
		return inputAmt;
	}
	public void setInputAmt(String inputAmt) {
		this.inputAmt = inputAmt;
	}
	public void setServiceList(String serviceList) {
		this.serviceList = serviceList;
	}
	public String getServiceList() {
		return serviceList;
	}
	public String getRentalDetailId() {
		return rentalDetailId;
	}
	public void setRentalDetailId(String rentalDetailId) {
		this.rentalDetailId = rentalDetailId;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getRentalCaldetail() {
		return rentalCaldetail;
	}
	public void setRentalCaldetail(String rentalCaldetail) {
		this.rentalCaldetail = rentalCaldetail;
	}
	public Double getCalAmt() {
		return calAmt;
	}
	public void setCalAmt(Double calAmt) {
		this.calAmt = calAmt;
	}
	public Double getPeriodAmt() {
		return periodAmt;
	}
	public void setPeriodAmt(Double periodAmt) {
		this.periodAmt = periodAmt;
	}
}
