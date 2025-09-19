package th.co.ais.domain.rt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mrt001SrchDpstDetail extends AbstractDomain {
	
	private String rentalMasterId;
	
	private String depositDetailId;
	private String expenseType;
	private String expenseTypeName;
	private String depositType;
	private String depositTypeName;
	private String vatType;
	private String vatTypeName;
	private String vatRate;
	private String vatAmt;
	private Double depositExcAmt;
	private Double depositIncAmt;
	private String periodYear;
	private String periodMonth;
	private String remark;
	private Double depositAmt;
	private String vendorMasterId;
	private String vendorCode;
	private String vendorName;
	private String payeeMasterId;
	private String payeeName;
	private String bgMasterId;
	private String bgNo;
	private Date periodStDt;
	private Date periodEndDt;
	
	private String contractNo;
	private String company;
	private Date effectiveDt;
	private Date expireDt;
	private String siteName;
	private String lessorAddress;
	private String siteAddress;
	private String dpstVerifyAmt;
	private String siteInfoId;
	private String dpstStatus;
	
	private String periodStDtStr;
	private String periodEndDtStr;
	private String whtType;
	private String whtTypeName;
	private Double whtRate;
	private Double whtAmt;
	
	public String getDpstStatus() {
		return dpstStatus;
	}
	public void setDpstStatus(String dpstStatus) {
		this.dpstStatus = dpstStatus;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
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
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getLessorAddress() {
		return lessorAddress;
	}
	public void setLessorAddress(String lessorAddress) {
		this.lessorAddress = lessorAddress;
	}
	public String getSiteAddress() {
		return siteAddress;
	}
	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
	}
	public String getDpstVerifyAmt() {
		return dpstVerifyAmt;
	}
	public void setDpstVerifyAmt(String dpstVerifyAmt) {
		this.dpstVerifyAmt = dpstVerifyAmt;
	}
	public String getBgMasterId() {
		return bgMasterId;
	}
	public void setBgMasterId(String bgMasterId) {
		this.bgMasterId = bgMasterId;
	}
	public String getBgNo() {
		return bgNo;
	}
	public void setBgNo(String bgNo) {
		this.bgNo = bgNo;
	}
	public Date getPeriodStDt() {
		return periodStDt;
	}
	public void setPeriodStDt(Date periodStDt) {
		this.periodStDt = periodStDt;
	}
	public Date getPeriodEndDt() {
		return periodEndDt;
	}
	public void setPeriodEndDt(Date periodEndDt) {
		this.periodEndDt = periodEndDt;
	}
	public Double getDepositAmt() {
		return depositAmt;
	}
	public void setDepositAmt(Double depositAmt) {
		this.depositAmt = depositAmt;
	}
	public String getVendorMasterId() {
		return vendorMasterId;
	}
	public void setVendorMasterId(String vendorMasterId) {
		this.vendorMasterId = vendorMasterId;
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
	public String getPayeeMasterId() {
		return payeeMasterId;
	}
	public void setPayeeMasterId(String payeeMasterId) {
		this.payeeMasterId = payeeMasterId;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public String getRentalMasterId() {
		return rentalMasterId;
	}
	public void setRentalMasterId(String rentalMasterId) {
		this.rentalMasterId = rentalMasterId;
	}
	public String getDepositDetailId() {
		return depositDetailId;
	}
	public void setDepositDetailId(String depositDetailId) {
		this.depositDetailId = depositDetailId;
	}
	public String getExpenseTypeName() {
		return expenseTypeName;
	}
	public void setExpenseTypeName(String expenseTypeName) {
		this.expenseTypeName = expenseTypeName;
	}
	public String getDepositType() {
		return depositType;
	}
	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}
	public String getDepositTypeName() {
		return depositTypeName;
	}
	public void setDepositTypeName(String depositTypeName) {
		this.depositTypeName = depositTypeName;
	}
	public String getVatType() {
		return vatType;
	}
	public void setVatType(String vatType) {
		this.vatType = vatType;
	}
	public String getVatTypeName() {
		return vatTypeName;
	}
	public void setVatTypeName(String vatTypeName) {
		this.vatTypeName = vatTypeName;
	}
	public String getVatRate() {
		return vatRate;
	}
	public void setVatRate(String vatRate) {
		this.vatRate = vatRate;
	}
	public String getVatAmt() {
		return vatAmt;
	}
	public void setVatAmt(String vatAmt) {
		this.vatAmt = vatAmt;
	}
	public Double getDepositExcAmt() {
		return depositExcAmt;
	}
	public void setDepositExcAmt(Double depositExcAmt) {
		this.depositExcAmt = depositExcAmt;
	}
	public Double getDepositIncAmt() {
		return depositIncAmt;
	}
	public void setDepositIncAmt(Double depositIncAmt) {
		this.depositIncAmt = depositIncAmt;
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
	public String getPeriodStDtStr() {
		return periodStDtStr;
	}
	public void setPeriodStDtStr(String periodStDtStr) {
		this.periodStDtStr = periodStDtStr;
	}
	public String getPeriodEndDtStr() {
		return periodEndDtStr;
	}
	public void setPeriodEndDtStr(String periodEndDtStr) {
		this.periodEndDtStr = periodEndDtStr;
	}
	public String getWhtType() {
		return whtType;
	}
	public void setWhtType(String whtType) {
		this.whtType = whtType;
	}
	public String getWhtTypeName() {
		return whtTypeName;
	}
	public void setWhtTypeName(String whtTypeName) {
		this.whtTypeName = whtTypeName;
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
	
}
