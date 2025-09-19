package th.co.ais.domain.el;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ELDpstCondSP implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 430172563819182031L;
	private static final SimpleDateFormat SDF 	= new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));

	private String mode;
	private String contractNo;
	private String electricId;
	private String depositCondType;
	private String siteDepositId;
	private String siteInfoId;
	private BigDecimal seqNo;
	private String expenseType;
	private String epenseTypeName;
	private String depositType;
	private String depositTypeName;
	private String detail;
	private String remark;
	private String service;
	private BigDecimal condDepositAmt;
	private String whtType;
	private String whtTypeName;
	private String whtRate;
	private String vatType;
	private String vatTypeName;
	private String vatRate;
	private String newStatus;
	private String newStatusName;
	private Date periodStartDt;
	private Date periodEndDt;
	private String vendorMasterId;
	private String payeeMasterId;
	private String bankAccNo;
	private String bankName;
	
	private String meterId;
	private String privateDepositId;
	private String electricOwnerType;
	private String serviceName;
	private String vendorCode;
	private String vendorName;
	private String payeeCode;
	private String payeeName;
	private String bgNo;
	private BigDecimal depositAmt;
	private String depositDetail;
	
	private String periodStartDtStr;
	private String periodEndDtStr;
	
	private String newFlag;
	
	private String user;
	
	private String result;
	private String message;
	
	private BigDecimal pKwh;
	private BigDecimal lKwh;
	private BigDecimal totalKwh;
	private BigDecimal unitPrice;
	
	private String serviceId;
	private String verFlag;
	
	private String depositDetailId;
	private String bgMasterId;
	
	public ELDpstCondSP() {}
	
	public ELDpstCondSP(String electricId) {
		this.electricId = electricId;
	}
	
	public ELDpstCondSP(ELDpstCondSP obj) {
		this.mode = obj.getMode();
		this.contractNo = obj.getContractNo();
		this.electricId = obj.getElectricId();
		this.depositCondType = obj.getDepositCondType();
		this.siteDepositId = obj.getSiteDepositId();
		this.siteInfoId = obj.getSiteInfoId();
		this.seqNo = obj.getSeqNo();
		this.expenseType = obj.getExpenseType();
		this.epenseTypeName = obj.getEpenseTypeName();
		this.depositType = obj.getDepositType();
		this.depositTypeName = obj.getDepositTypeName();
		this.detail = obj.getDetail();
		this.remark = obj.getRemark();
		this.service = obj.getService();
		this.condDepositAmt = obj.getCondDepositAmt();
		this.whtType = obj.getWhtType();
		this.whtTypeName = obj.getWhtTypeName();
		this.whtRate = obj.getWhtRate();
		this.vatType = obj.getVatType();
		this.vatTypeName = obj.getVatTypeName();
		this.vatRate = obj.getVatRate();
		this.newStatus = obj.getNewStatus();
		this.newStatusName = obj.getNewStatusName();
		this.periodStartDt = obj.getPeriodStartDt();
		this.periodEndDt = obj.getPeriodEndDt();
		this.vendorMasterId = obj.getVendorMasterId();
		this.payeeMasterId = obj.getPayeeMasterId();
		this.bankAccNo = obj.getBankAccNo();
		this.bankName = obj.getBankName();
		this.meterId = obj.getMeterId();
		this.privateDepositId = obj.getPrivateDepositId();
		this.electricOwnerType = obj.getElectricOwnerType();
		this.serviceName = obj.getServiceName();
		this.vendorCode = obj.getVendorCode();
		this.vendorName = obj.getVendorName();
		this.payeeCode = obj.getPayeeCode();
		this.payeeName = obj.getPayeeName();
		this.bgNo = obj.getBgNo();
		this.depositAmt = obj.getDepositAmt();
		this.depositDetail = obj.getDepositDetail();
		this.periodStartDtStr = obj.getPeriodStartDtStr();
		this.periodEndDtStr = obj.getPeriodEndDtStr();
		this.newFlag = obj.getNewFlag();
		this.user = obj.getUser();
		this.result = obj.getResult();
		this.message = obj.getMessage();
		this.depositDetailId = obj.getDepositDetailId();
		this.bgMasterId = obj.getBgMasterId();
	}
	
	public String getDepositCondType() {
		return depositCondType;
	}
	public void setDepositCondType(String depositCondType) {
		this.depositCondType = depositCondType;
	}
	public String getSiteDepositId() {
		return siteDepositId;
	}
	public void setSiteDepositId(String siteDepositId) {
		this.siteDepositId = siteDepositId;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public BigDecimal getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(BigDecimal seqNo) {
		this.seqNo = seqNo;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getEpenseTypeName() {
		return epenseTypeName;
	}
	public void setEpenseTypeName(String epenseTypeName) {
		this.epenseTypeName = epenseTypeName;
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
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public BigDecimal getCondDepositAmt() {
		return condDepositAmt;
	}
	public void setCondDepositAmt(BigDecimal condDepositAmt) {
		this.condDepositAmt = condDepositAmt;
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
	public String getNewStatus() {
		return newStatus;
	}
	public void setNewStatus(String newStatus) {
		this.newStatus = newStatus;
	}
	public String getNewStatusName() {
		return newStatusName;
	}
	public void setNewStatusName(String newStatusName) {
		this.newStatusName = newStatusName;
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
	public String getElectricId() {
		return electricId;
	}
	public void setElectricId(String electricId) {
		this.electricId = electricId;
	}

	public String getPeriodStartDtStr() {
		return (null != periodStartDt) ? SDF.format(periodStartDt) : "";
	}

	public void setPeriodStartDtStr(String periodStartDtStr) {
		this.periodStartDtStr = periodStartDtStr;
	}

	public String getPeriodEndDtStr() {
		return (null != periodEndDt) ? SDF.format(periodEndDt) : "";
	}

	public void setPeriodEndDtStr(String periodEndDtStr) {
		this.periodEndDtStr = periodEndDtStr;
	}

	public String getPrivateDepositId() {
		return privateDepositId;
	}

	public void setPrivateDepositId(String privateDepositId) {
		this.privateDepositId = privateDepositId;
	}

	public String getElectricOwnerType() {
		return electricOwnerType;
	}

	public void setElectricOwnerType(String electricOwnerType) {
		this.electricOwnerType = electricOwnerType;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
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

	public String getBgNo() {
		return bgNo;
	}

	public void setBgNo(String bgNo) {
		this.bgNo = bgNo;
	}

	public BigDecimal getDepositAmt() {
		return depositAmt;
	}

	public void setDepositAmt(BigDecimal depositAmt) {
		this.depositAmt = depositAmt;
	}

	public String getDepositDetail() {
		return depositDetail;
	}

	public void setDepositDetail(String depositDetail) {
		this.depositDetail = depositDetail;
	}

	public String getMeterId() {
		return meterId;
	}

	public void setMeterId(String meterId) {
		this.meterId = meterId;
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
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
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
	
	public String getNewFlag() {
		return newFlag;
	}

	public void setNewFlag(String newFlag) {
		this.newFlag = newFlag;
	}
	
	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
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

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getVerFlag() {
		return verFlag;
	}

	public void setVerFlag(String verFlag) {
		this.verFlag = verFlag;
	}

	public String getDepositDetailId() {
		return depositDetailId;
	}

	public void setDepositDetailId(String depositDetailId) {
		this.depositDetailId = depositDetailId;
	}

	public String getBgMasterId() {
		return bgMasterId;
	}

	public void setBgMasterId(String bgMasterId) {
		this.bgMasterId = bgMasterId;
	}

	@Override
	public String toString() {
		return "ELDpstCondSP [mode=" + mode + ", contractNo=" + contractNo + ", electricId=" + electricId
				+ ", depositCondType=" + depositCondType + ", siteDepositId=" + siteDepositId + ", siteInfoId="
				+ siteInfoId + ", seqNo=" + seqNo + ", expenseType=" + expenseType + ", epenseTypeName="
				+ epenseTypeName + ", depositType=" + depositType + ", depositTypeName=" + depositTypeName + ", detail="
				+ detail + ", remark=" + remark + ", service=" + service + ", condDepositAmt=" + condDepositAmt
				+ ", whtType=" + whtType + ", whtTypeName=" + whtTypeName + ", whtRate=" + whtRate + ", vatType="
				+ vatType + ", vatTypeName=" + vatTypeName + ", vatRate=" + vatRate + ", newStatus=" + newStatus
				+ ", newStatusName=" + newStatusName + ", periodStartDt=" + periodStartDt + ", periodEndDt="
				+ periodEndDt + ", vendorMasterId=" + vendorMasterId + ", payeeMasterId=" + payeeMasterId
				+ ", bankAccNo=" + bankAccNo + ", bankName=" + bankName + ", meterId=" + meterId + ", privateDepositId="
				+ privateDepositId + ", electricOwnerType=" + electricOwnerType + ", serviceName=" + serviceName
				+ ", vendorCode=" + vendorCode + ", vendorName=" + vendorName + ", payeeCode=" + payeeCode
				+ ", payeeName=" + payeeName + ", bgNo=" + bgNo + ", depositAmt=" + depositAmt + ", depositDetail="
				+ depositDetail + ", periodStartDtStr=" + periodStartDtStr + ", periodEndDtStr=" + periodEndDtStr
				+ ", newFlag=" + newFlag + ", user=" + user + ", result=" + result + ", message=" + message + "]";
	}

	

	
}
