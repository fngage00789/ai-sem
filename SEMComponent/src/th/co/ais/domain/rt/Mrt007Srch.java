package th.co.ais.domain.rt;

import java.math.BigDecimal;
import java.util.Date;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.annotation.PCell;

public class Mrt007Srch extends AbstractDomain {
	
	private String rowId;
	private String company;
	private String transPaymentId;
	private String paymentGroupNo;
	private String paymentDocNo;
	private String expenseType;
	private String siteInfoId;
	private String depositDetailId;
	private String rentalClrRecId;
	private String region;
	private String contractNo;
	private String siteName;
	private String vendorCode;
	private String vendorName;
	private Date periodStartDt;
	private Date periodEndDt;
	private Double periodAmt;
	private String payVatType;
	private String payVatTypeName;
	private String payVatRate;
	private String payVatAmt;
	private String payWhtType;
	private String payWhtTypeName;
	private String payWhtRate;
	private String payWhtAmt;
	private String doc68;
	private String doc92;
	private Date chqDt;
	private String chqNo;
	private String chqClearingStatus;
	private Date transferDt;
	private String receiptNo;
	private String taxInvoiceNo;
	private Date taxInvoiceDt;
	private String remark;
	private String clrReceiptStatus;
	private String clrReceiptStatusName;
	private String clrRejectReason;
	private String batchNo;
	private String receiptStatus;
	private String receiptStatusName;
	private String periodNoStart;
	private String periodNoEnd;
	private String payExcAmt;
	private String payIncAmt;
	private String paymentType;
	private String paymentTypeName;
	private String periodNo;
	private String taxId;

	private String amtStr;
	private Double amt;
	private Date dueDtFrom;
	private Date dueDtTo;
	private String receiptType;
	private String lessorName;
	private String lessorHouseNo;
	private String street;
	private String tambon;
	private String amphur;
	private String province;
	
	private String moduleType;
	private String exportStatus;
	private boolean exportStatusFlag;
	private int no;
	private Date currerntDate;
	private Double expAmount;
	private Double vatAmount;
	private Double intAmount;
	private Double netAmout;
	private String strNetAmnt;
	private Double whtAmt;
	
	
	// 2015/01/26 added by.. YUT
	private String strParam;
	private boolean localGovt;
	private String localGovtStr;
	
	
	//2015/11/24 added by NEW
	private String oldContractNo;
	
	//2019/01/11 added by NEW
	private String locationId;
	private String locationCode;
	private String siteCode;
	private String siteAddr;
	private String vendorAddr;
	private String vendorTel;
	private String vendorEmail;
	private String userId;
	
	//2019/01/23 added by NEW
	private String contractName;
	private String reqType;
	private String deposit;
	private boolean depositFlag;
	private String period;
	
	private BigDecimal remainCount;
	private String emailFlag;
	private String smsFlag;
	private String payPeriodType;
	

	private Date smClearFrom;
	private Date smClearTo;
	private String donateFlag;
	private String clearType;
	private String saSiteApprove;
	private String branchNo;
	private String expenseTypeName;
	
	public Mrt007Srch() {
		this.receiptType = "01";
	}
	
	public String getTaxId() {
		return taxId;
	}
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
	public String getPeriodNo() {
		return periodNo;
	}
	public void setPeriodNo(String periodNo) {
		this.periodNo = periodNo;
	}
	public Date getDueDtFrom() {
		return dueDtFrom;
	}
	public void setDueDtFrom(Date dueDtFrom) {
		this.dueDtFrom = dueDtFrom;
	}
	public Date getDueDtTo() {
		return dueDtTo;
	}
	public void setDueDtTo(Date dueDtTo) {
		this.dueDtTo = dueDtTo;
	}
	public String getAmtStr() {
		return amtStr;
	}
	public void setAmtStr(String amtStr) {
		this.amtStr = amtStr;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getReceiptType() {
		return receiptType;
	}
	public void setReceiptType(String receiptType) {
		this.receiptType = receiptType;
	}
	public String getLessorName() {
		return lessorName;
	}
	public void setLessorName(String lessorName) {
		this.lessorName = lessorName;
	}
	public String getLessorHouseNo() {
		return lessorHouseNo;
	}
	public void setLessorHouseNo(String lessorHouseNo) {
		this.lessorHouseNo = lessorHouseNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getTambon() {
		return tambon;
	}
	public void setTambon(String tambon) {
		this.tambon = tambon;
	}
	public String getAmphur() {
		return amphur;
	}
	public void setAmphur(String amphur) {
		this.amphur = amphur;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDepositDetailId() {
		return depositDetailId;
	}
	public void setDepositDetailId(String depositDetailId) {
		this.depositDetailId = depositDetailId;
	}
	public String getRentalClrRecId() {
		return rentalClrRecId;
	}
	public void setRentalClrRecId(String rentalClrRecId) {
		this.rentalClrRecId = rentalClrRecId;
	}
	@PCell(cellType = String.class ,no = 2, manualStyleName ="rt003Field")
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	@PCell(cellType = String.class ,no = 3, manualStyleName ="rt003Field")
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	@PCell(cellType = String.class ,no = 4, manualStyleName ="rt003Field")
	public String getVendorCode() {
		return vendorCode;
	}
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	@PCell(cellType = String.class ,no = 6, manualStyleName ="rt003Field")
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public Double getAmt() {
		return amt;
	}
	public void setAmt(Double amt) {
		this.amt = amt;
	}
	public String getPayVatType() {
		return payVatType;
	}
	public void setPayVatType(String payVatType) {
		this.payVatType = payVatType;
	}
	public String getPayVatTypeName() {
		return payVatTypeName;
	}
	public void setPayVatTypeName(String payVatTypeName) {
		this.payVatTypeName = payVatTypeName;
	}
	public Date getChqDt() {
		return chqDt;
	}
	public void setChqDt(Date chqDt) {
		this.chqDt = chqDt;
	}
	public String getChqNo() {
		return chqNo;
	}
	public void setChqNo(String chqNo) {
		this.chqNo = chqNo;
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
	public Date getTaxInvoiceDt() {
		return taxInvoiceDt;
	}
	public void setTaxInvoiceDt(Date taxInvoiceDt) {
		this.taxInvoiceDt = taxInvoiceDt;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getClrReceiptStatus() {
		return clrReceiptStatus;
	}
	public void setClrReceiptStatus(String clrReceiptStatus) {
		this.clrReceiptStatus = clrReceiptStatus;
	}
	public String getClrReceiptStatusName() {
		return clrReceiptStatusName;
	}
	public void setClrReceiptStatusName(String clrReceiptStatusName) {
		this.clrReceiptStatusName = clrReceiptStatusName;
	}
	public String getClrRejectReason() {
		return clrRejectReason;
	}
	public void setClrRejectReason(String clrRejectReason) {
		this.clrRejectReason = clrRejectReason;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getReceiptStatus() {
		return receiptStatus;
	}
	public void setReceiptStatus(String receiptStatus) {
		this.receiptStatus = receiptStatus;
	}
	public String getReceiptStatusName() {
		return receiptStatusName;
	}
	public void setReceiptStatusName(String receiptStatusName) {
		this.receiptStatusName = receiptStatusName;
	}
	public String getPayExcAmt() {
		return payExcAmt;
	}
	public void setPayExcAmt(String payExcAmt) {
		this.payExcAmt = payExcAmt;
	}
	public String getPayVatAmt() {
		return payVatAmt;
	}
	public void setPayVatAmt(String payVatAmt) {
		this.payVatAmt = payVatAmt;
	}
	public String getPayIncAmt() {
		return payIncAmt;
	}
	public void setPayIncAmt(String payIncAmt) {
		this.payIncAmt = payIncAmt;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getPaymentTypeName() {
		return paymentTypeName;
	}
	public void setPaymentTypeName(String paymentTypeName) {
		this.paymentTypeName = paymentTypeName;
	}
	public String getTransPaymentId() {
		return transPaymentId;
	}
	public void setTransPaymentId(String transPaymentId) {
		this.transPaymentId = transPaymentId;
	}
	public String getPaymentGroupNo() {
		return paymentGroupNo;
	}
	public void setPaymentGroupNo(String paymentGroupNo) {
		this.paymentGroupNo = paymentGroupNo;
	}
	public String getPaymentDocNo() {
		return paymentDocNo;
	}
	public void setPaymentDocNo(String paymentDocNo) {
		this.paymentDocNo = paymentDocNo;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
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
	public Double getPeriodAmt() {
		return periodAmt;
	}
	public void setPeriodAmt(Double periodAmt) {
		this.periodAmt = periodAmt;
	}
	public String getPayVatRate() {
		return payVatRate;
	}
	public void setPayVatRate(String payVatRate) {
		this.payVatRate = payVatRate;
	}
	@PCell(cellType = String.class ,no = 7, manualStyleName ="rt003Field")
	public String getPayWhtType() {
		return payWhtType;
	}
	public void setPayWhtType(String payWhtType) {
		this.payWhtType = payWhtType;
	}
	public String getPayWhtTypeName() {
		return payWhtTypeName;
	}
	public void setPayWhtTypeName(String payWhtTypeName) {
		this.payWhtTypeName = payWhtTypeName;
	}
	public String getPayWhtRate() {
		return payWhtRate;
	}
	public void setPayWhtRate(String payWhtRate) {
		this.payWhtRate = payWhtRate;
	}
	@PCell(cellType = Double.class ,no = 10, manualStyleName ="rt003FieldMoney")
	public String getPayWhtAmt() {
		return payWhtAmt;
	}
	public void setPayWhtAmt(String payWhtAmt) {
		this.payWhtAmt = payWhtAmt;
	}
	public String getDoc68() {
		return doc68;
	}
	public void setDoc68(String doc68) {
		this.doc68 = doc68;
	}
	@PCell(cellType = String.class ,no = 1, manualStyleName ="rt003Field")
	public String getDoc92() {
		return doc92;
	}
	public void setDoc92(String doc92) {
		this.doc92 = doc92;
	}
	public String getChqClearingStatus() {
		return chqClearingStatus;
	}
	public void setChqClearingStatus(String chqClearingStatus) {
		this.chqClearingStatus = chqClearingStatus;
	}
	public Date getTransferDt() {
		return transferDt;
	}
	public void setTransferDt(Date transferDt) {
		this.transferDt = transferDt;
	}
	@PCell(cellType = String.class ,no = 5, manualStyleName ="rt003Field")
	public String getPeriodNoStart() {
		return periodNoStart;
	}
	public void setPeriodNoStart(String periodNoStart) {
		this.periodNoStart = periodNoStart;
	}
	public String getPeriodNoEnd() {
		return periodNoEnd;
	}
	public void setPeriodNoEnd(String periodNoEnd) {
		this.periodNoEnd = periodNoEnd;
	}
	
	
	public String getModuleType() {
		return moduleType;
	}

	public void setModuleType(String moduleType) {
		this.moduleType = moduleType;
	}

	public String getExportStatus() {
		return exportStatus;
	}

	public void setExportStatus(String exportStatus) {
		this.exportStatus = exportStatus;
	}

	public boolean isExportStatusFlag() {
		return exportStatusFlag;
	}

	public void setExportStatusFlag(boolean exportStatusFlag) {
		this.exportStatusFlag = exportStatusFlag;
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
	@PCell(cellType = String.class ,no = 0, manualStyleName ="rt003Field")
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
	//@PCell(cellType = Date.class ,no = 1, manualStyleName ="rt003Field")
	public Date getCurrerntDate() {
		return currerntDate;
	}

	public void setCurrerntDate(Date currerntDate) {
		this.currerntDate = currerntDate;
	}
	@PCell(cellType = Double.class ,no = 8, manualStyleName ="rt003FieldMoney")
	public Double getExpAmount() {
		return expAmount;
	}

	public void setExpAmount(Double expAmount) {
		this.expAmount = expAmount;
	}
	@PCell(cellType = Double.class ,no = 9, manualStyleName ="rt003FieldMoney")
	public Double getVatAmount() {
		return vatAmount;
	}

	public void setVatAmount(Double vatAmount) {
		this.vatAmount = vatAmount;
	}
	@PCell(cellType = Double.class ,no = 11, manualStyleName ="rt003FieldMoney")
	public Double getIntAmount() {
		return intAmount;
	}

	public void setIntAmount(Double intAmount) {
		this.intAmount = intAmount;
	}
	@PCell(cellType = Double.class ,no = 12, manualStyleName ="rt003FieldMoney")
	public Double getNetAmout() {
		return netAmout;
	}

	public void setNetAmout(Double netAmout) {
		this.netAmout = netAmout;
	}

	public String getStrNetAmnt() {
		return strNetAmnt;
	}

	public void setStrNetAmnt(String strNetAmnt) {
		this.strNetAmnt = strNetAmnt;
	}

	public Double getWhtAmt() {
		return whtAmt;
	}

	public void setWhtAmt(Double whtAmt) {
		this.whtAmt = whtAmt;
	}

	public String getStrParam() {
		return strParam;
	}

	public void setStrParam(String strParam) {
		this.strParam = strParam;
	}

	public boolean isLocalGovt() {
		return localGovt;
	}

	public void setLocalGovt(boolean localGovt) {
		this.localGovt = localGovt;
	}

	public String getLocalGovtStr() {
		return localGovtStr;
	}

	public void setLocalGovtStr(String localGovtStr) {
		this.localGovtStr = localGovtStr;
	}

	public String getOldContractNo() {
		return oldContractNo;
	}

	public void setOldContractNo(String oldContractNo) {
		this.oldContractNo = oldContractNo;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getSiteAddr() {
		return siteAddr;
	}

	public void setSiteAddr(String siteAddr) {
		this.siteAddr = siteAddr;
	}

	public String getVendorAddr() {
		return vendorAddr;
	}

	public void setVendorAddr(String vendorAddr) {
		this.vendorAddr = vendorAddr;
	}

	public String getVendorTel() {
		return vendorTel;
	}

	public void setVendorTel(String vendorTel) {
		this.vendorTel = vendorTel;
	}

	public String getVendorEmail() {
		return vendorEmail;
	}

	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public boolean isDepositFlag() {
		return depositFlag;
	}

	public void setDepositFlag(boolean depositFlag) {
		this.depositFlag = depositFlag;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public BigDecimal getRemainCount() {
		return remainCount;
	}

	public void setRemainCount(BigDecimal remainCount) {
		this.remainCount = remainCount;
	}

	public String getEmailFlag() {
		return emailFlag;
	}

	public void setEmailFlag(String emailFlag) {
		this.emailFlag = emailFlag;
	}

	public String getSmsFlag() {
		return smsFlag;
	}

	public void setSmsFlag(String smsFlag) {
		this.smsFlag = smsFlag;
	}

	public String getPayPeriodType() {
		return payPeriodType;
	}

	public void setPayPeriodType(String payPeriodType) {
		this.payPeriodType = payPeriodType;
	}

	public Date getSmClearFrom() {
		return smClearFrom;
	}

	public void setSmClearFrom(Date smClearFrom) {
		this.smClearFrom = smClearFrom;
	}

	public Date getSmClearTo() {
		return smClearTo;
	}

	public void setSmClearTo(Date smClearTo) {
		this.smClearTo = smClearTo;
	}

	public String getDonateFlag() {
		return donateFlag;
	}

	public void setDonateFlag(String donateFlag) {
		this.donateFlag = donateFlag;
	}

	public String getClearType() {
		return clearType;
	}

	public void setClearType(String clearType) {
		this.clearType = clearType;
	}

	public String getSaSiteApprove() {
		return saSiteApprove;
	}

	public void setSaSiteApprove(String saSiteApprove) {
		this.saSiteApprove = saSiteApprove;
	}

	public String getBranchNo() {
		return branchNo;
	}

	public void setBranchNo(String branchNo) {
		this.branchNo = branchNo;
	}

	public String getExpenseTypeName() {
		return expenseTypeName;
	}

	public void setExpenseTypeName(String expenseTypeName) {
		this.expenseTypeName = expenseTypeName;
	}


	
}
