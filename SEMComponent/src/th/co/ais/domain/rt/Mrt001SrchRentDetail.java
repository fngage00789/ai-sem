package th.co.ais.domain.rt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

@SuppressWarnings("serial")
public class Mrt001SrchRentDetail extends AbstractDomain{

	private String rowId;
	private String rentalMasterId;
	private String expenseType;
	private String vendorMasterId;
	private String payeeMasterId;
	private String whtType;
	private String vatType;
	
	private String expenseTypeName;
	private String whtTypeName;
	private String vendorCode;
	private String vendorName;
	private String payeeName;
	private String whtTypeDetail;
	private String whtRate;
	private String vatTypeDetail;
	private String vatTypeName;
	private String vatRate;
	private String payPeriodTypeAName;
	private String payPeriodDetail;
	private Double periodAmt;
	private String periodYear;
	private String periodMonth;
	private String rentPeriodType;
	private String remark;
	private Date effDate;
	private Date periodStartDt;
	private Date periodEndDt;
	private Integer totPeriodNo;
	
	private String mSiteRentCond;
	
	private String periodStartDtStr;
	private String periodEndDtStr;
	
    private Double amtPerMonth;
    private Double amtPerYear;
    private Double amtOneTime;
  
    private Integer cntVendor;
    
    private String rentalCalName;
    private String serviceName;
    
    private String serviceNametbl;
    private String serviceCalType;
    
    private String serviceId;
    private String rentalCalCode;
    
    private String expenseDesc;
	
	public String getmSiteRentCond() {
		return mSiteRentCond;
	}
	public void setmSiteRentCond(String mSiteRentCond) {
		this.mSiteRentCond = mSiteRentCond;
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
	public Integer getTotPeriodNo() {
		return totPeriodNo;
	}
	public void setTotPeriodNo(Integer totPeriodNo) {
		this.totPeriodNo = totPeriodNo;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getRentalMasterId() {
		return rentalMasterId;
	}
	public void setRentalMasterId(String rentalMasterId) {
		this.rentalMasterId = rentalMasterId;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
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
	public String getWhtType() {
		return whtType;
	}
	public void setWhtType(String whtType) {
		this.whtType = whtType;
	}
	public String getVatType() {
		return vatType;
	}
	public void setVatType(String vatType) {
		this.vatType = vatType;
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
	public String getWhtTypeDetail() {
		return whtTypeDetail;
	}
	public void setWhtTypeDetail(String whtTypeDetail) {
		this.whtTypeDetail = whtTypeDetail;
	}
	public String getWhtRate() {
		return whtRate;
	}
	public void setWhtRate(String whtRate) {
		this.whtRate = whtRate;
	}
	public String getVatTypeDetail() {
		return vatTypeDetail;
	}
	public void setVatTypeDetail(String vatTypeDetail) {
		this.vatTypeDetail = vatTypeDetail;
	}
	public String getVatRate() {
		return vatRate;
	}
	public void setVatRate(String vatRate) {
		this.vatRate = vatRate;
	}
	public String getPayPeriodDetail() {
		return payPeriodDetail;
	}
	public void setPayPeriodDetail(String payPeriodDetail) {
		this.payPeriodDetail = payPeriodDetail;
	}
	public Double getPeriodAmt() {
		return periodAmt;
	}
	public void setPeriodAmt(Double periodAmt) {
		this.periodAmt = periodAmt;
	}
	public String getPeriodYear() {
		return periodYear;
	}
	public void setPeriodYear(String periodYear) {
		this.periodYear = periodYear;
	}
	public String getPeriodMonth() {
		return periodMonth;
	}
	public void setPeriodMonth(String periodMonth) {
		this.periodMonth = periodMonth;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getEffDate() {
		return effDate;
	}
	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}
	public String getWhtTypeName() {
		return whtTypeName;
	}
	public void setWhtTypeName(String whtTypeName) {
		this.whtTypeName = whtTypeName;
	}
	public String getVatTypeName() {
		return vatTypeName;
	}
	public void setVatTypeName(String vatTypeName) {
		this.vatTypeName = vatTypeName;
	}
	public String getPayPeriodTypeAName() {
		return payPeriodTypeAName;
	}
	public void setPayPeriodTypeAName(String payPeriodTypeAName) {
		this.payPeriodTypeAName = payPeriodTypeAName;
	}
	public String getRentPeriodType() {
		return rentPeriodType;
	}
	public void setRentPeriodType(String rentPeriodType) {
		this.rentPeriodType = rentPeriodType;
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
	public Double getAmtPerMonth() {
		return amtPerMonth;
	}
	public void setAmtPerMonth(Double amtPerMonth) {
		this.amtPerMonth = amtPerMonth;
	}
	public Double getAmtPerYear() {
		return amtPerYear;
	}
	public void setAmtPerYear(Double amtPerYear) {
		this.amtPerYear = amtPerYear;
	}
	public Double getAmtOneTime() {
		return amtOneTime;
	}
	public void setAmtOneTime(Double amtOneTime) {
		this.amtOneTime = amtOneTime;
	}
	public Integer getCntVendor() {
		return cntVendor;
	}
	public void setCntVendor(Integer cntVendor) {
		this.cntVendor = cntVendor;
	}
	public String getRentalCalName() {
		return rentalCalName;
	}
	public void setRentalCalName(String rentalCalName) {
		this.rentalCalName = rentalCalName;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceNametbl() {
		return serviceNametbl;
	}
	public void setServiceNametbl(String serviceNametbl) {
		this.serviceNametbl = serviceNametbl;
	}
	public String getServiceCalType() {
		return serviceCalType;
	}
	public void setServiceCalType(String serviceCalType) {
		this.serviceCalType = serviceCalType;
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
	public String getExpenseDesc() {
		return expenseDesc;
	}
	public void setExpenseDesc(String expenseDesc) {
		this.expenseDesc = expenseDesc;
	}

	
}
