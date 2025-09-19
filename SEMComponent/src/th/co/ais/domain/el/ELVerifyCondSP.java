package th.co.ais.domain.el;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ELVerifyCondSP implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8234593253163588336L;
	private static final SimpleDateFormat SDF 	= new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
	
	private String rowId;
	private String electricId;
	private String electricDetailId;
	private String siteInfoId;
	private String siteElectricId;
	private String electricUseType;
	private String electricUseTypeDesc;
	private String electricOwnerType;
	private String electricOwnerTypeDesc;
	private String service;
	private BigDecimal takeAllAmt;
	private String takeAllPeriodType;
	private BigDecimal unitPriceAmt;
	private String noUnitPriceFlag;
	private boolean chkNoUnitPrice;
	private String vatType;
	private String vatTypeDesc;
	private String payPeriodType;
	private String payPeriodTypeDesc;
	private Date effectiveDt;
	private Date expireDt;
	private String remark;
	private String contractNo;
	private String expenseType;
	private String whtType;
	private String whtTypeName;
	private String whtRate;
	private String effectiveDtStr;
	private String expireDtStr;
	
	//Dtl
	private String vendorMasterId;
	private String payeeMasterId;
	private String bankAccNo;
	private String bankName;
	private String meterId;
	private String meterInfoId;
	private BigDecimal totPeriodNo;
	private BigDecimal periodAmt;
	private String periodType;
	private String vatRate;
	private String vendorCode;
	private String vendorName;
	private String payeeCode;
	private String payeeName;
	
	private String periodNo;
	private String period;
	private String period3;
	private String period4;
	private int payPeriod;
	private int payPeriodMonth;
	private int payPeriodYear;
	private BigDecimal periodDay;
	private BigDecimal periodMonth;
	private BigDecimal periodYear;
	private String mode;
	private Date periodStartDt;
	private Date periodEndDt;

	
	private String user;
	
	private String result;
	private String message;
	
	private String pElectricPayType;
	private Date termOfPaymentDt;
	private Date fromTermOfPaymentDt;
	private Date toTermOfPaymentDt;
	private String termOfPaymentDtStr;
	private String fromTermOfPaymentDtStr;
	private String toTermOfPaymentDtStr;
	private BigDecimal excludeVatAmt;
	private BigDecimal vatAmt;
	private BigDecimal includeVatAmt;
	private String paymentStatusDesc;
	
	private String paymentId;
	private BigDecimal payAmt;
	
	private BigDecimal pUnitPrice;
	
	private String serviceId;
	private String serviceName;
	private String electricCalCode;
	private String electricCalDesc;
	
	private String  siteInfoElectriCondId;
	
	private BigDecimal pKwh;
	private BigDecimal lKwh;
	private BigDecimal totalKwh;
	private BigDecimal unitPrice;
	
	private String verFlag;
	
	private BigDecimal unitPriceAmtTemp;

	public ELVerifyCondSP() {}
	
	public ELVerifyCondSP(String electricId) {
		this.electricId = electricId;
	}
	
	public ELVerifyCondSP(ELVerifyCondSP obj) {
		this.rowId = obj.getRowId();
		this.electricId = obj.getElectricId();
		this.electricDetailId = obj.getElectricDetailId();
		this.siteInfoId = obj.getSiteInfoId();
		this.siteElectricId = obj.getSiteElectricId();
		this.electricUseType = obj.getElectricUseType();
		this.electricUseTypeDesc = obj.getElectricOwnerTypeDesc();
		this.electricOwnerType = obj.getElectricOwnerType();
		this.electricOwnerTypeDesc = obj.getElectricOwnerTypeDesc();
		this.service = obj.getService();
		this.takeAllAmt = obj.getTakeAllAmt();
		this.takeAllPeriodType = obj.getTakeAllPeriodType();
		this.unitPriceAmt = obj.getUnitPriceAmt();
		this.noUnitPriceFlag = obj.getNoUnitPriceFlag();
		this.chkNoUnitPrice = obj.isChkNoUnitPrice();
		this.vatType = obj.getVatType();
		this.vatTypeDesc = obj.getVatTypeDesc();
		this.payPeriodType = obj.getPayPeriodType();
		this.payPeriodTypeDesc = obj.getPayPeriodTypeDesc();
		this.effectiveDt = obj.getEffectiveDt();
		this.expireDt = obj.getExpireDt();
		this.remark = obj.getRemark();
		this.contractNo = obj.getContractNo();
		this.expenseType = obj.getExpenseType();
		this.whtType = obj.getWhtType();
		this.whtTypeName = obj.getWhtTypeName();
		this.whtRate = obj.getWhtRate();
		this.effectiveDtStr = obj.getEffectiveDtStr();
		this.expireDtStr = obj.getExpireDtStr();
		this.vendorMasterId = obj.getVendorMasterId();
		this.payeeMasterId = obj.getPayeeMasterId();
		this.bankAccNo = obj.getBankAccNo();
		this.bankName = obj.getBankName();
		this.meterId = obj.getMeterId();
		this.totPeriodNo = obj.getTotPeriodNo();
		this.periodAmt = obj.getPeriodAmt();
		this.periodType = obj.getPeriodType();
		this.vatRate = obj.getVatRate();
		this.vendorCode = obj.getVendorCode();
		this.vendorName = obj.getVendorName();
		this.payeeCode = obj.getPayeeCode();
		this.payeeName = obj.getPayeeName();
		this.period = obj.getPeriod();
		this.period3 = obj.getPeriod3();
		this.period4 = obj.getPeriod4();
		this.payPeriod = obj.getPayPeriod();
		this.payPeriodMonth = obj.getPayPeriodMonth();
		this.payPeriodYear = obj.getPayPeriodYear();
		this.periodDay = obj.getPeriodDay();
		this.periodMonth = obj.getPeriodMonth();
		this.periodYear = obj.getPeriodYear();
		this.mode = obj.getMode();
		this.periodStartDt = obj.getPeriodStartDt();
		this.periodEndDt = obj.getPeriodEndDt();
		this.user = obj.getUser();
		this.result = obj.getResult();
		this.message = obj.getMessage();
		this.pKwh = obj.getpKwh();
		this.lKwh = obj.getlKwh();
		this.totalKwh = obj.getTotalKwh();
		this.unitPrice = obj.getUnitPrice();
		this.termOfPaymentDtStr = obj.getTermOfPaymentDtStr();
		this.fromTermOfPaymentDtStr = obj.getFromTermOfPaymentDtStr();
		this.toTermOfPaymentDtStr = obj.getToTermOfPaymentDtStr();
		this.siteInfoElectriCondId = obj.getSiteInfoElectriCondId();
	}
	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getElectricId() {
		return electricId;
	}
	public void setElectricId(String electricId) {
		this.electricId = electricId;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public String getSiteElectricId() {
		return siteElectricId;
	}
	public void setSiteElectricId(String siteElectricId) {
		this.siteElectricId = siteElectricId;
	}
	public String getElectricUseType() {
		return electricUseType;
	}
	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}
	public String getElectricUseTypeDesc() {
		return electricUseTypeDesc;
	}
	public void setElectricUseTypeDesc(String electricUseTypeDesc) {
		this.electricUseTypeDesc = electricUseTypeDesc;
	}
	public String getElectricOwnerType() {
		return electricOwnerType;
	}
	public void setElectricOwnerType(String electricOwnerType) {
		this.electricOwnerType = electricOwnerType;
	}
	public String getElectricOwnerTypeDesc() {
		return electricOwnerTypeDesc;
	}
	public void setElectricOwnerTypeDesc(String electricOwnerTypeDesc) {
		this.electricOwnerTypeDesc = electricOwnerTypeDesc;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public BigDecimal getTakeAllAmt() {
		return takeAllAmt;
	}
	public void setTakeAllAmt(BigDecimal takeAllAmt) {
		this.takeAllAmt = takeAllAmt;
	}
	public String getTakeAllPeriodType() {
		return takeAllPeriodType;
	}
	public void setTakeAllPeriodType(String takeAllPeriodType) {
		this.takeAllPeriodType = takeAllPeriodType;
	}
	public BigDecimal getUnitPriceAmt() {
		return unitPriceAmt;
	}
	public void setUnitPriceAmt(BigDecimal unitPriceAmt) {
		this.unitPriceAmt = unitPriceAmt;
	}
	public String getNoUnitPriceFlag() {
		return noUnitPriceFlag;
	}
	public void setNoUnitPriceFlag(String noUnitPriceFlag) {
		this.noUnitPriceFlag = noUnitPriceFlag;
	}
	public String getVatType() {
		return vatType;
	}
	public void setVatType(String vatType) {
		this.vatType = vatType;
	}
	public String getVatTypeDesc() {
		return vatTypeDesc;
	}
	public void setVatTypeDesc(String vatTypeDesc) {
		this.vatTypeDesc = vatTypeDesc;
	}
	public String getPayPeriodType() {
		return payPeriodType;
	}
	public void setPayPeriodType(String payPeriodType) {
		this.payPeriodType = payPeriodType;
	}
	public String getPayPeriodTypeDesc() {
		return payPeriodTypeDesc;
	}
	public void setPayPeriodTypeDesc(String payPeriodTypeDesc) {
		this.payPeriodTypeDesc = payPeriodTypeDesc;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getEffectiveDtStr() {
		return (null != effectiveDt) ? SDF.format(effectiveDt) : "";
	}
	public void setEffectiveDtStr(String effectiveDtStr) {
		this.effectiveDtStr = effectiveDtStr;
	}
	public String getExpireDtStr() {
		return (null != expireDt) ? SDF.format(expireDt) : "";
	}
	public void setExpireDtStr(String expireDtStr) {
		this.expireDtStr = expireDtStr;
	}

	public String getMeterId() {
		return meterId;
	}

	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}

	public BigDecimal getPeriodAmt() {
		return periodAmt;
	}

	public void setPeriodAmt(BigDecimal periodAmt) {
		this.periodAmt = periodAmt;
	}

	public String getPeriodType() {
		return periodType;
	}

	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}

	public String getVatRate() {
		return vatRate;
	}

	public void setVatRate(String vatRate) {
		this.vatRate = vatRate;
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

	public String getPayeeCode() {
		return payeeCode;
	}

	public void setPayeeCode(String payeeCode) {
		this.payeeCode = payeeCode;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public boolean isChkNoUnitPrice() {
		return chkNoUnitPrice;
	}

	public void setChkNoUnitPrice(boolean chkNoUnitPrice) {
		this.chkNoUnitPrice = chkNoUnitPrice;
	}

	public int getPayPeriodMonth() {
		return payPeriodMonth;
	}

	public void setPayPeriodMonth(int payPeriodMonth) {
		this.payPeriodMonth = payPeriodMonth;
	}

	public int getPayPeriodYear() {
		return payPeriodYear;
	}

	public void setPayPeriodYear(int payPeriodYear) {
		this.payPeriodYear = payPeriodYear;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getPeriod3() {
		
		return period3;
	}

	public void setPeriod3(String period3) {

		this.period3 = period3;
		
	}

	public String getPeriod4() {
		return period4;
	}

	public void setPeriod4(String period4) {
		this.period4 = period4;
		
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
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

	public String getBankAccNo() {
		return bankAccNo;
	}

	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public BigDecimal getTotPeriodNo() {
		return totPeriodNo;
	}

	public void setTotPeriodNo(BigDecimal totPeriodNo) {
		this.totPeriodNo = totPeriodNo;
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

	public BigDecimal getPeriodDay() {
		return periodDay;
	}

	public void setPeriodDay(BigDecimal periodDay) {
		this.periodDay = periodDay;
	}

	public BigDecimal getPeriodMonth() {
		return periodMonth;
	}

	public void setPeriodMonth(BigDecimal periodMonth) {
		this.periodMonth = periodMonth;
	}

	public BigDecimal getPeriodYear() {
		return periodYear;
	}

	public void setPeriodYear(BigDecimal periodYear) {
		this.periodYear = periodYear;
	}

	
	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getElectricDetailId() {
		return electricDetailId;
	}

	public void setElectricDetailId(String electricDetailId) {
		this.electricDetailId = electricDetailId;
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

	public String getMeterInfoId() {
		return meterInfoId;
	}

	public void setMeterInfoId(String meterInfoId) {
		this.meterInfoId = meterInfoId;
	}

	@Override
	public String toString() {
		return "ELVerifyCondSP [rowId=" + rowId + ", electricId=" + electricId + ", electricDetailId="
				+ electricDetailId + ", siteInfoId=" + siteInfoId + ", siteElectricId=" + siteElectricId
				+ ", siteInfoElectriCondId=" + siteInfoElectriCondId
				+ ", electricUseType=" + electricUseType + ", electricUseTypeDesc=" + electricUseTypeDesc
				+ ", electricOwnerType=" + electricOwnerType + ", electricOwnerTypeDesc=" + electricOwnerTypeDesc
				+ ", service=" + service + ", takeAllAmt=" + takeAllAmt + ", takeAllPeriodType=" + takeAllPeriodType
				+ ", unitPriceAmt=" + unitPriceAmt + ", noUnitPriceFlag=" + noUnitPriceFlag + ", chkNoUnitPrice="
				+ chkNoUnitPrice + ", vatType=" + vatType + ", vatTypeDesc=" + vatTypeDesc + ", payPeriodType="
				+ payPeriodType + ", payPeriodTypeDesc=" + payPeriodTypeDesc + ", effectiveDt=" + effectiveDt
				+ ", expireDt=" + expireDt + ", remark=" + remark + ", contractNo=" + contractNo + ", expenseType="
				+ expenseType + ", whtType=" + whtType + ", whtTypeName=" + whtTypeName + ", whtRate=" + whtRate
				+ ", effectiveDtStr=" + effectiveDtStr + ", expireDtStr=" + expireDtStr + ", vendorMasterId="
				+ vendorMasterId + ", payeeMasterId=" + payeeMasterId + ", bankAccNo=" + bankAccNo + ", bankName="
				+ bankName + ", meterId=" + meterId + ", totPeriodNo=" + totPeriodNo + ", periodAmt=" + periodAmt
				+ ", periodType=" + periodType + ", vatRate=" + vatRate + ", vendorCode=" + vendorCode + ", vendorName="
				+ vendorName + ", payeeCode=" + payeeCode + ", payeeName=" + payeeName + ", period=" + period
				+ ", period3=" + period3 + ", period4=" + period4 + ", payPeriod=" + payPeriod + ", payPeriodMonth="
				+ payPeriodMonth + ", payPeriodYear=" + payPeriodYear + ", periodDay=" + periodDay + ", periodMonth="
				+ periodMonth + ", periodYear=" + periodYear + ", mode=" + mode + ", periodStartDt=" + periodStartDt
				+ ", periodEndDt=" + periodEndDt + ", user=" + user + ", result=" + result + ", message=" + message
				+ "]";
	}

	public String getPeriodNo() {
		return periodNo;
	}

	public void setPeriodNo(String periodNo) {
		this.periodNo = periodNo;
	}

	public String getpElectricPayType() {
		return pElectricPayType;
	}

	public void setpElectricPayType(String pElectricPayType) {
		this.pElectricPayType = pElectricPayType;
	}

	public Date getTermOfPaymentDt() {
		return termOfPaymentDt;
	}

	public void setTermOfPaymentDt(Date termOfPaymentDt) {
		this.termOfPaymentDt = termOfPaymentDt;
	}

	public Date getFromTermOfPaymentDt() {
		return fromTermOfPaymentDt;
	}

	public void setFromTermOfPaymentDt(Date fromTermOfPaymentDt) {
		this.fromTermOfPaymentDt = fromTermOfPaymentDt;
	}

	public Date getToTermOfPaymentDt() {
		return toTermOfPaymentDt;
	}

	public void setToTermOfPaymentDt(Date toTermOfPaymentDt) {
		this.toTermOfPaymentDt = toTermOfPaymentDt;
	}

	public BigDecimal getExcludeVatAmt() {
		return excludeVatAmt;
	}

	public void setExcludeVatAmt(BigDecimal excludeVatAmt) {
		this.excludeVatAmt = excludeVatAmt;
	}

	public BigDecimal getVatAmt() {
		return vatAmt;
	}

	public void setVatAmt(BigDecimal vatAmt) {
		this.vatAmt = vatAmt;
	}

	public BigDecimal getIncludeVatAmt() {
		return includeVatAmt;
	}

	public void setIncludeVatAmt(BigDecimal includeVatAmt) {
		this.includeVatAmt = includeVatAmt;
	}

	public String getPaymentStatusDesc() {
		return paymentStatusDesc;
	}

	public void setPaymentStatusDesc(String paymentStatusDesc) {
		this.paymentStatusDesc = paymentStatusDesc;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public BigDecimal getPayAmt() {
		return payAmt;
	}

	public void setPayAmt(BigDecimal payAmt) {
		this.payAmt = payAmt;
	}

	public BigDecimal getpUnitPrice() {
		return pUnitPrice;
	}

	public void setpUnitPrice(BigDecimal pUnitPrice) {
		this.pUnitPrice = pUnitPrice;
	}

	public int getPayPeriod() {
		return payPeriod;
	}

	public void setPayPeriod(int payPeriod) {
		this.payPeriod = payPeriod;
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

	public String getElectricCalCode() {
		return electricCalCode;
	}

	public void setElectricCalCode(String electricCalCode) {
		this.electricCalCode = electricCalCode;
	}

	public String getElectricCalDesc() {
		return electricCalDesc;
	}

	public void setElectricCalDesc(String electricCalDesc) {
		this.electricCalDesc = electricCalDesc;
	}

	public String getSiteInfoElectriCondId() {
		return siteInfoElectriCondId;
	}

	public void setSiteInfoElectriCondId(String siteInfoElectriCondId) {
		this.siteInfoElectriCondId = siteInfoElectriCondId;
	}

	public BigDecimal getpKwh() {
		return pKwh;
	}

	public void setpKwh(BigDecimal pKwh) {
		this.pKwh = pKwh;
	}

	public BigDecimal getlKwh() {
		return lKwh;
	}

	public void setlKwh(BigDecimal lKwh) {
		this.lKwh = lKwh;
	}

	public BigDecimal getTotalKwh() {
		return totalKwh;
	}

	public void setTotalKwh(BigDecimal totalKwh) {
		this.totalKwh = totalKwh;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getTermOfPaymentDtStr() {
		return termOfPaymentDtStr;
	}

	public void setTermOfPaymentDtStr(String termOfPaymentDtStr) {
		this.termOfPaymentDtStr = termOfPaymentDtStr;
	}

	public String getFromTermOfPaymentDtStr() {
		return fromTermOfPaymentDtStr;
	}

	public void setFromTermOfPaymentDtStr(String fromTermOfPaymentDtStr) {
		this.fromTermOfPaymentDtStr = fromTermOfPaymentDtStr;
	}

	public String getToTermOfPaymentDtStr() {
		return toTermOfPaymentDtStr;
	}

	public void setToTermOfPaymentDtStr(String toTermOfPaymentDtStr) {
		this.toTermOfPaymentDtStr = toTermOfPaymentDtStr;
	}

	public String getVerFlag() {
		return verFlag;
	}

	public void setVerFlag(String verFlag) {
		this.verFlag = verFlag;
	}

	public BigDecimal getUnitPriceAmtTemp() {
		return unitPriceAmtTemp;
	}

	public void setUnitPriceAmtTemp(BigDecimal unitPriceAmtTemp) {
		this.unitPriceAmtTemp = unitPriceAmtTemp;
	}


	
}
