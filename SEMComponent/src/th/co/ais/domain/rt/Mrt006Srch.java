package th.co.ais.domain.rt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mrt006Srch extends AbstractDomain{

	private String company;
	private String contractNo;
	private String siteName;
	private String region;
	private String siteType;
	private String depositType;
	private String bgNo;
	private String bgBank;
	private String reqType;
	private String expenseType;
	private String returnDpsStatus;

	private String depType;
	private String depositDetailId;
	private String returnDepositId;
	private String siteInfoId;
	private String reqTypeName;
	private String expenseTypeName;
	private String depositTypeName;
	private String bgBankName;
	private String vendorMasterId;
	private String vendorCode;
	private String vendorName;
	private Double depositAmt;
	private String vatType;
	private String vatTypeName;
	private Double vatAmt;
	private Double depositExcAmt;
	private Double depositIncAmt;
	private Double depositRentAmt;
	private Double depositBalanceAmt;
	private Double depositReturnAmt;
	private Double returnBalanceAmt;
	private String remark;
	private String returnDepositStatus;
	private String returnDpsStatusName;
	private String reason;
	private String receiptNo;
	private String taxInvoiceNo;
	private String picoFlag;
	private Date bgExpireFrom;
	private Date bgExpireTo;
	private String siteStatus;
	
	private Date bgStartDt;
	private Date bgEndDt;
	private Date bgReturnDt;
	private Date bgStartDtTh;
	private Date bgEndDtTh;
	private Date bgReturnDtTh;
	private String bgStartDtStr;
	private String bgEndDtStr;
	
	//added by NEW 2015/05/08
	private String strParam;
	
	private boolean chkPico;
	
	public String getSiteStatus() {
		return siteStatus;
	}
	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}
	public Date getBgExpireFrom() {
		return bgExpireFrom;
	}
	public void setBgExpireFrom(Date bgExpireFrom) {
		this.bgExpireFrom = bgExpireFrom;
	}
	public Date getBgExpireTo() {
		return bgExpireTo;
	}
	public void setBgExpireTo(Date bgExpireTo) {
		this.bgExpireTo = bgExpireTo;
	}
	public String getPicoFlag() {
		return picoFlag;
	}
	public void setPicoFlag(String picoFlag) {
		this.picoFlag = picoFlag;
	}
	public boolean isChkPico() {
		return chkPico;
	}
	public void setChkPico(boolean chkPico) {
		this.chkPico = chkPico;
	}
	public Date getBgReturnDtTh() {
		return bgReturnDtTh;
	}
	public void setBgReturnDtTh(Date bgReturnDtTh) {
		this.bgReturnDtTh = bgReturnDtTh;
	}
	public Date getBgStartDtTh() {
		return bgStartDtTh;
	}
	public void setBgStartDtTh(Date bgStartDtTh) {
		this.bgStartDtTh = bgStartDtTh;
	}
	public Date getBgEndDtTh() {
		return bgEndDtTh;
	}
	public void setBgEndDtTh(Date bgEndDtTh) {
		this.bgEndDtTh = bgEndDtTh;
	}
	public String getBgStartDtStr() {
		return bgStartDtStr;
	}
	public void setBgStartDtStr(String bgStartDtStr) {
		this.bgStartDtStr = bgStartDtStr;
	}
	public String getBgEndDtStr() {
		return bgEndDtStr;
	}
	public void setBgEndDtStr(String bgEndDtStr) {
		this.bgEndDtStr = bgEndDtStr;
	}
	public Date getBgStartDt() {
		return bgStartDt;
	}
	public void setBgStartDt(Date bgStartDt) {
		this.bgStartDt = bgStartDt;
	}
	public Date getBgEndDt() {
		return bgEndDt;
	}
	public void setBgEndDt(Date bgEndDt) {
		this.bgEndDt = bgEndDt;
	}
	public Date getBgReturnDt() {
		return bgReturnDt;
	}
	public void setBgReturnDt(Date bgReturnDt) {
		this.bgReturnDt = bgReturnDt;
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
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getSiteType() {
		return siteType;
	}
	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}
	public String getDepositType() {
		return depositType;
	}
	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}
	public String getBgNo() {
		return bgNo;
	}
	public void setBgNo(String bgNo) {
		this.bgNo = bgNo;
	}
	public String getBgBank() {
		return bgBank;
	}
	public void setBgBank(String bgBank) {
		this.bgBank = bgBank;
	}
	public String getReqType() {
		return reqType;
	}
	public void setReqType(String reqType) {
		this.reqType = reqType;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getReturnDpsStatus() {
		return returnDpsStatus;
	}
	public void setReturnDpsStatus(String returnDpsStatus) {
		this.returnDpsStatus = returnDpsStatus;
	}
	public String getDepType() {
		return depType;
	}
	public void setDepType(String depType) {
		this.depType = depType;
	}
	public String getDepositDetailId() {
		return depositDetailId;
	}
	public void setDepositDetailId(String depositDetailId) {
		this.depositDetailId = depositDetailId;
	}
	public String getReturnDepositId() {
		return returnDepositId;
	}
	public void setReturnDepositId(String returnDepositId) {
		this.returnDepositId = returnDepositId;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public String getReqTypeName() {
		return reqTypeName;
	}
	public void setReqTypeName(String reqTypeName) {
		this.reqTypeName = reqTypeName;
	}
	public String getExpenseTypeName() {
		return expenseTypeName;
	}
	public void setExpenseTypeName(String expenseTypeName) {
		this.expenseTypeName = expenseTypeName;
	}
	public String getDepositTypeName() {
		return depositTypeName;
	}
	public void setDepositTypeName(String depositTypeName) {
		this.depositTypeName = depositTypeName;
	}
	public String getBgBankName() {
		return bgBankName;
	}
	public void setBgBankName(String bgBankName) {
		this.bgBankName = bgBankName;
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
	public Double getDepositAmt() {
		return depositAmt;
	}
	public void setDepositAmt(Double depositAmt) {
		this.depositAmt = depositAmt;
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
	public Double getVatAmt() {
		return vatAmt;
	}
	public void setVatAmt(Double vatAmt) {
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
	public Double getDepositRentAmt() {
		return depositRentAmt;
	}
	public void setDepositRentAmt(Double depositRentAmt) {
		this.depositRentAmt = depositRentAmt;
	}
	public Double getDepositBalanceAmt() {
		return depositBalanceAmt;
	}
	public void setDepositBalanceAmt(Double depositBalanceAmt) {
		this.depositBalanceAmt = depositBalanceAmt;
	}
	public Double getDepositReturnAmt() {
		return depositReturnAmt;
	}
	public void setDepositReturnAmt(Double depositReturnAmt) {
		this.depositReturnAmt = depositReturnAmt;
	}
	public Double getReturnBalanceAmt() {
		return returnBalanceAmt;
	}
	public void setReturnBalanceAmt(Double returnBalanceAmt) {
		this.returnBalanceAmt = returnBalanceAmt;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getReturnDepositStatus() {
		return returnDepositStatus;
	}
	public void setReturnDepositStatus(String returnDepositStatus) {
		this.returnDepositStatus = returnDepositStatus;
	}
	public String getReturnDpsStatusName() {
		return returnDpsStatusName;
	}
	public void setReturnDpsStatusName(String returnDpsStatusName) {
		this.returnDpsStatusName = returnDpsStatusName;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getReceiptNo() {
		return receiptNo;
	}
	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}
	public String getTaxInvoiceNo() {
		return taxInvoiceNo;
	}
	public void setTaxInvoiceNo(String taxInvoiceNo) {
		this.taxInvoiceNo = taxInvoiceNo;
	}
	
	public String getStrParam() {
		return strParam;
	}
	public void setStrParam(String strParam) {
		this.strParam = strParam;
	}
	@Override
	public String getRowId() {
		return this.rowId;
	}
	@Override
	public void setRowId(String rowId) {
		this.rowId = rowId;
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
}
