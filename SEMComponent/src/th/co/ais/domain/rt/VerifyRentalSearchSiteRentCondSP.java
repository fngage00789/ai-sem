package th.co.ais.domain.rt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class VerifyRentalSearchSiteRentCondSP extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2262244069754672107L;
	
	private String rowId;
	private String siteInfoId;
	private String rentalMasterId;
	private String siteRentCondId;
	private String seqNo;
	private String rentCondType;
	private String expenseType;
	private String expenseTypeName;
	private String placeName;
	private String detail;
	private Double rentOldAmt;
	private String rentAddPercent;
	private Double rentAddAmt;
	private Double rentAmt;
	private String rentPeriodType;
	private String rentPeriodTypeName;
	private String whtType;
	private String whtTypeName;
	private String whtRate;
	private String vatType;
	private String vateTypeName;
	private String vatRate;
    private String payPeriodType;
    private String payPeriod;
    private String payPeriodTypeName;
    private Date effectiveDT;
    private Date effectiveDtTh;
    private Double setupPeriodAmt;
    private Double balanceAmt;
    private Date periodStDt;
    private Date periodEndDt;
    private Date expireDt;
    private Double amtPerMonth;
    private Double amtPerYear;
    private Double periodAmt;
    
    private boolean selected;
    private boolean disSelect;
    
    private Integer cntVendor;
    
    private String effectiveDtThStr;
    private Double amtOneTime;
    
    private Double defaultVat;
    private Double defaultWht;
    
    //added by NEW 2015/03/06
    private String subExpenseType;
    
    private String serviceId;
    private String serviceName;
    
    //added 2023/03/17
    private String expenseDesc;
    
	public Integer getCntVendor() {
		return cntVendor;
	}
	public void setCntVendor(Integer cntVendor) {
		this.cntVendor = cntVendor;
	}
	public boolean isDisSelect() {
		return disSelect;
	}
	public void setDisSelect(boolean disSelect) {
		this.disSelect = disSelect;
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
	public Date getEffectiveDtTh() {
		return effectiveDtTh;
	}
	public void setEffectiveDtTh(Date effectiveDtTh) {
		this.effectiveDtTh = effectiveDtTh;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public String getRentalMasterId() {
		return rentalMasterId;
	}
	public void setRentalMasterId(String rentalMasterId) {
		this.rentalMasterId = rentalMasterId;
	}
	public String getSiteRentCondId() {
		return siteRentCondId;
	}
	public void setSiteRentCondId(String siteRentCondId) {
		this.siteRentCondId = siteRentCondId;
	}
	public String getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	public String getRentCondType() {
		return rentCondType;
	}
	public void setRentCondType(String rentCondType) {
		this.rentCondType = rentCondType;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getExpenseTypeName() {
		return expenseTypeName;
	}
	public void setExpenseTypeName(String expenseTypeName) {
		this.expenseTypeName = expenseTypeName;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Double getRentOldAmt() {
		return rentOldAmt;
	}
	public void setRentOldAmt(Double rentOldAmt) {
		this.rentOldAmt = rentOldAmt;
	}
	public String getRentAddPercent() {
		return rentAddPercent;
	}
	public void setRentAddPercent(String rentAddPercent) {
		this.rentAddPercent = rentAddPercent;
	}
	public Double getRentAddAmt() {
		return rentAddAmt;
	}
	public void setRentAddAmt(Double rentAddAmt) {
		this.rentAddAmt = rentAddAmt;
	}
	public Double getRentAmt() {
		return rentAmt;
	}
	public void setRentAmt(Double rentAmt) {
		this.rentAmt = rentAmt;
	}
	public String getRentPeriodType() {
		return rentPeriodType;
	}
	public void setRentPeriodType(String rentPeriodType) {
		this.rentPeriodType = rentPeriodType;
	}
	public String getRentPeriodTypeName() {
		return rentPeriodTypeName;
	}
	public void setRentPeriodTypeName(String rentPeriodTypeName) {
		this.rentPeriodTypeName = rentPeriodTypeName;
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
	public String getWhtRate() {
		return whtRate;
	}
	public void setWhtRate(String whtRate) {
		this.whtRate = whtRate;
	}
	public String getVatType() {
		return vatType;
	}
	public void setVatType(String vatType) {
		this.vatType = vatType;
	}
	public String getVateTypeName() {
		return vateTypeName;
	}
	public void setVateTypeName(String vateTypeName) {
		this.vateTypeName = vateTypeName;
	}
	public String getVatRate() {
		return vatRate;
	}
	public void setVatRate(String vatRate) {
		this.vatRate = vatRate;
	}
	public String getPayPeriodType() {
		return payPeriodType;
	}
	public void setPayPeriodType(String payPeriodType) {
		this.payPeriodType = payPeriodType;
	}
	public String getPayPeriod() {
		return payPeriod;
	}
	public void setPayPeriod(String payPriod) {
		this.payPeriod = payPriod;
	}
	public String getPayPeriodTypeName() {
		return payPeriodTypeName;
	}
	public void setPayPeriodTypeName(String payPeriodTypeName) {
		this.payPeriodTypeName = payPeriodTypeName;
	}
	public Date getEffectiveDT() {
		return effectiveDT;
	}
	public void setEffectiveDT(Date effectiveDT) {
		this.effectiveDT = effectiveDT;
	}
	public Double getSetupPeriodAmt() {
		return setupPeriodAmt;
	}
	public void setSetupPeriodAmt(Double setupPeriodAmt) {
		this.setupPeriodAmt = setupPeriodAmt;
	}
	public Double getBalanceAmt() {
		return balanceAmt;
	}
	public void setBalanceAmt(Double balanceAmt) {
		this.balanceAmt = balanceAmt;
	}
	public Date getExpireDt() {
		return expireDt;
	}
	public void setExpireDt(Date expireDt) {
		this.expireDt = expireDt;
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
	
	public Double getPeriodAmt() {
		return periodAmt;
	}
	public void setPeriodAmt(Double periodAmt) {
		this.periodAmt = periodAmt;
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
	public String getEffectiveDtThStr() {
		return effectiveDtThStr;
	}
	public void setEffectiveDtThStr(String effectiveDtThStr) {
		this.effectiveDtThStr = effectiveDtThStr;
	}
	public Double getAmtOneTime() {
		return amtOneTime;
	}
	public void setAmtOneTime(Double amtOneTime) {
		this.amtOneTime = amtOneTime;
	}
	public Double getDefaultVat() {
		return defaultVat;
	}
	public void setDefaultVat(Double defaultVat) {
		this.defaultVat = defaultVat;
	}
	public Double getDefaultWht() {
		return defaultWht;
	}
	public void setDefaultWht(Double defaultWht) {
		this.defaultWht = defaultWht;
	}
	public String getSubExpenseType() {
		return subExpenseType;
	}
	public void setSubExpenseType(String subExpenseType) {
		this.subExpenseType = subExpenseType;
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
