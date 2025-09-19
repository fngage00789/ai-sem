package th.co.ais.domain.el;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import th.co.ais.domain.AbstractDomain;

public class PaymentDetailSP extends AbstractDomain {


	/**
	 * 
	 */
	private static final long serialVersionUID = 739962858945224445L;
	private static final SimpleDateFormat exportFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
	private static final SimpleDateFormat exportFormatMmYyyy = new SimpleDateFormat("MM/yyyy", new Locale("th", "TH"));
	
	private String rowId;
	private String paymentId;
	private String expenseType;
	private String feeAreaCode;
	private String feeMeterId;
	private String feeCheckArea;
	private String feeWbsCode;
	private BigDecimal invNo;
	private String invSiteName;
	private String invAreaCode;
	private String invAreaName;
	private String invMeterId;
	private Date invTermOfPaymentDt;
	private BigDecimal invExcludeVatAmt;
	private BigDecimal invVatAmt;
	private BigDecimal invIncludeVatAmt;
	private String referMeterId;
	private String meterId;
	private Date pDate;
	private Date lDate;
	private BigDecimal pRead;
	private String pReadStr;//WT###Add 20110331
	private BigDecimal lRead;
	private String lReadStr;//WT###Add 20110331
	private BigDecimal kwhTotal;
	private String kwhTotalStr;//WT###Add 20110331
	private BigDecimal unitPrice;
	private String unitVatType;
	private BigDecimal unitVatRate;
	private Date termOfPaymentDt;
	private Date fromTermOfPaymentDt;
	private Date toTermOfPaymentDt;
	private BigDecimal payAmt;
	private String vatType;
	private BigDecimal vatRate;
	private BigDecimal vatAmt;
	private String whtType;
	private BigDecimal whtRate;
	private BigDecimal whtAmt;
	private BigDecimal excludeVatAmt;
	private BigDecimal includeVatAmt;
	private BigDecimal chqAmt;
	private BigDecimal periodNo;
	private String periodType;
	private BigDecimal periodInterval;
	private Date periodStartDt;
	private Date periodEndDt;
	private BigDecimal periodDay;
	private BigDecimal periodMonth;
	private BigDecimal periodYear;
	private BigDecimal periodAmt;
	private String remark;
	private String recordStatus;
	private String periodName;
	private String invDocNo;	
	private String invMeterIdDisplay;
	private String  termOfPaymentDtMonth;	
	private String  termOfPaymentDtYear;
	private String whtCheck;
	private String multiVendorCheck;
	private int rowNumber;
	private String expenseTypeTxt;	
	private String vatTypeTxt;
	private String detailFlag;
	private String unitVatTypeTxt;
	private String meterInfoId;
	private String meterAddress;
	private String privateDepositId;
	private String invTermOfPaymentDtTH;
	private String pDateTH;
	private String lDateTH;
	private String termOfPaymentDtTH;
	private String fromTermOfPaymentDtTH;
	private String toTermOfPaymentDtTH;
	private String periodStartDtTH;
	private String periodEndDtTH;
	private Date dueDt;
	private String dueDtTH;
	private String createDtTH;
	private boolean disableVatType;
	private String installmentrowId;
	private String whtTypeTxt;//WT###Add 20110119
	private boolean deleted;
	//-------------------------
	private String privatePrepaid;
	//---------------------------
	private String toTermOfPaymentDate;
	private String fromTermOfPaymentDate;
	private String toTermOfPaymentMonth;
	private String fromTermOfPaymentMonth;
	private String toTermOfPaymentYear;
	private String fromTermOfPaymentYear;
	private String validatePaymentDetailFlag;
	private String termOfPaymentDate;
	private String termOfPaymentDateFrom;
	private String paymentDocNo;
	private String depositDetailId;
	private Date createDate;
	private Date updateDate;
	private String whoCreate;
	private String whoUpdate;
	//private boolean validatePaymentDetailFlagBoolean;
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
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getFeeAreaCode() {
		return feeAreaCode;
	}
	public void setFeeAreaCode(String feeAreaCode) {
		this.feeAreaCode = feeAreaCode;
	}
	public String getFeeMeterId() {
		return feeMeterId;
	}
	public void setFeeMeterId(String feeMeterId) {
		this.feeMeterId = feeMeterId;
	}
	public String getFeeCheckArea() {
		return feeCheckArea;
	}
	public void setFeeCheckArea(String feeCheckArea) {
		this.feeCheckArea = feeCheckArea;
	}
	public String getFeeWbsCode() {
		return feeWbsCode;
	}
	public void setFeeWbsCode(String feeWbsCode) {
		this.feeWbsCode = feeWbsCode;
	}
	public BigDecimal getInvNo() {
		return invNo;
	}
	public void setInvNo(BigDecimal invNo) {
		this.invNo = invNo;
	}
	public String getInvSiteName() {
		return invSiteName;
	}
	public void setInvSiteName(String invSiteName) {
		this.invSiteName = invSiteName;
	}
	public String getInvAreaCode() {
		return invAreaCode;
	}
	public void setInvAreaCode(String invAreaCode) {
		this.invAreaCode = invAreaCode;
	}
	public String getInvAreaName() {
		return invAreaName;
	}
	public void setInvAreaName(String invAreaName) {
		this.invAreaName = invAreaName;
	}
	public String getInvMeterId() {
		return invMeterId;
	}
	public void setInvMeterId(String invMeterId) {
		this.invMeterId = invMeterId;
	}
	public Date getInvTermOfPaymentDt() {
		return invTermOfPaymentDt;
	}
	public void setInvTermOfPaymentDt(Date invTermOfPaymentDt) {
		this.invTermOfPaymentDt = invTermOfPaymentDt;
	}
	public BigDecimal getInvExcludeVatAmt() {
		return invExcludeVatAmt;
	}
	public void setInvExcludeVatAmt(BigDecimal invExcludeVatAmt) {
		this.invExcludeVatAmt = invExcludeVatAmt;
	}
	public BigDecimal getInvVatAmt() {
		return invVatAmt;
	}
	public void setInvVatAmt(BigDecimal invVatAmt) {
		this.invVatAmt = invVatAmt;
	}
	public BigDecimal getInvIncludeVatAmt() {
		return invIncludeVatAmt;
	}
	public void setInvIncludeVatAmt(BigDecimal invIncludeVatAmt) {
		this.invIncludeVatAmt = invIncludeVatAmt;
	}
	public String getReferMeterId() {
		return referMeterId;
	}
	public void setReferMeterId(String referMeterId) {
		this.referMeterId = referMeterId;
	}
	public String getMeterId() {
		return meterId;
	}
	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}
	public Date getpDate() {
		return pDate;
	}
	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}
	public Date getlDate() {
		return lDate;
	}
	public void setlDate(Date lDate) {
		this.lDate = lDate;
	}
	public BigDecimal getpRead() {
		return pRead;
	}
	public void setpRead(BigDecimal pRead) {
		this.pRead = pRead;
	}
	public String getpReadStr() {
		return pReadStr;
	}
	public void setpReadStr(String pReadStr) {
		this.pReadStr = pReadStr;
	}
	public BigDecimal getlRead() {
		return lRead;
	}
	public void setlRead(BigDecimal lRead) {
		this.lRead = lRead;
	}
	public String getlReadStr() {
		return lReadStr;
	}
	public void setlReadStr(String lReadStr) {
		this.lReadStr = lReadStr;
	}
	public BigDecimal getKwhTotal() {
		return kwhTotal;
	}
	public void setKwhTotal(BigDecimal kwhTotal) {
		this.kwhTotal = kwhTotal;
	}
	public String getKwhTotalStr() {
		return kwhTotalStr;
	}
	public void setKwhTotalStr(String kwhTotalStr) {
		this.kwhTotalStr = kwhTotalStr;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getUnitVatType() {
		return unitVatType;
	}
	public void setUnitVatType(String unitVatType) {
		this.unitVatType = unitVatType;
	}
	public BigDecimal getUnitVatRate() {
		return unitVatRate;
	}
	public void setUnitVatRate(BigDecimal unitVatRate) {
		this.unitVatRate = unitVatRate;
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
	public BigDecimal getPayAmt() {
		return payAmt;
	}
	public void setPayAmt(BigDecimal payAmt) {
		this.payAmt = payAmt;
	}
	public String getVatType() {
		return vatType;
	}
	public void setVatType(String vatType) {
		this.vatType = vatType;
	}
	public BigDecimal getVatRate() {
		return vatRate;
	}
	public void setVatRate(BigDecimal vatRate) {
		this.vatRate = vatRate;
	}
	public BigDecimal getVatAmt() {
		return vatAmt;
	}
	public void setVatAmt(BigDecimal vatAmt) {
		this.vatAmt = vatAmt;
	}
	public String getWhtType() {
		return whtType;
	}
	public void setWhtType(String whtType) {
		this.whtType = whtType;
	}
	public BigDecimal getWhtRate() {
		return whtRate;
	}
	public void setWhtRate(BigDecimal whtRate) {
		this.whtRate = whtRate;
	}
	public BigDecimal getWhtAmt() {
		return whtAmt;
	}
	public void setWhtAmt(BigDecimal whtAmt) {
		this.whtAmt = whtAmt;
	}
	public BigDecimal getExcludeVatAmt() {
		return excludeVatAmt;
	}
	public void setExcludeVatAmt(BigDecimal excludeVatAmt) {
		this.excludeVatAmt = excludeVatAmt;
	}
	public BigDecimal getIncludeVatAmt() {
		return includeVatAmt;
	}
	public void setIncludeVatAmt(BigDecimal includeVatAmt) {
		this.includeVatAmt = includeVatAmt;
	}
	public BigDecimal getChqAmt() {
		return chqAmt;
	}
	public void setChqAmt(BigDecimal chqAmt) {
		this.chqAmt = chqAmt;
	}
	public BigDecimal getPeriodNo() {
		return periodNo;
	}
	public void setPeriodNo(BigDecimal periodNo) {
		this.periodNo = periodNo;
	}
	public String getPeriodType() {
		return periodType;
	}
	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}
	public BigDecimal getPeriodInterval() {
		return periodInterval;
	}
	public void setPeriodInterval(BigDecimal periodInterval) {
		this.periodInterval = periodInterval;
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
	public BigDecimal getPeriodAmt() {
		return periodAmt;
	}
	public void setPeriodAmt(BigDecimal periodAmt) {
		this.periodAmt = periodAmt;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	public String getPeriodName() {
		return periodName;
	}
	public void setPeriodName(String periodName) {
		this.periodName = periodName;
	}
	public String getInvDocNo() {
		return invDocNo;
	}
	public void setInvDocNo(String invDocNo) {
		this.invDocNo = invDocNo;
	}
	public String getInvMeterIdDisplay() {
		return invMeterIdDisplay;
	}
	public void setInvMeterIdDisplay(String invMeterIdDisplay) {
		this.invMeterIdDisplay = invMeterIdDisplay;
	}
	public String getTermOfPaymentDtMonth() {
		return termOfPaymentDtMonth;
	}
	public void setTermOfPaymentDtMonth(String termOfPaymentDtMonth) {
		this.termOfPaymentDtMonth = termOfPaymentDtMonth;
	}
	public String getTermOfPaymentDtYear() {
		return termOfPaymentDtYear;
	}
	public void setTermOfPaymentDtYear(String termOfPaymentDtYear) {
		this.termOfPaymentDtYear = termOfPaymentDtYear;
	}
	public String getWhtCheck() {
		return whtCheck;
	}
	public void setWhtCheck(String whtCheck) {
		this.whtCheck = whtCheck;
	}
	public String getMultiVendorCheck() {
		return multiVendorCheck;
	}
	public void setMultiVendorCheck(String multiVendorCheck) {
		this.multiVendorCheck = multiVendorCheck;
	}
	public int getRowNumber() {
		return rowNumber;
	}
	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}
	public String getExpenseTypeTxt() {
		return expenseTypeTxt;
	}
	public void setExpenseTypeTxt(String expenseTypeTxt) {
		this.expenseTypeTxt = expenseTypeTxt;
	}
	public String getVatTypeTxt() {
		return vatTypeTxt;
	}
	public void setVatTypeTxt(String vatTypeTxt) {
		this.vatTypeTxt = vatTypeTxt;
	}
	public String getDetailFlag() {
		return detailFlag;
	}
	public void setDetailFlag(String detailFlag) {
		this.detailFlag = detailFlag;
	}
	public String getUnitVatTypeTxt() {
		return unitVatTypeTxt;
	}
	public void setUnitVatTypeTxt(String unitVatTypeTxt) {
		this.unitVatTypeTxt = unitVatTypeTxt;
	}
	public String getMeterInfoId() {
		return meterInfoId;
	}
	public void setMeterInfoId(String meterInfoId) {
		this.meterInfoId = meterInfoId;
	}
	public String getMeterAddress() {
		return meterAddress;
	}
	public void setMeterAddress(String meterAddress) {
		this.meterAddress = meterAddress;
	}
	public String getPrivateDepositId() {
		return privateDepositId;
	}
	public void setPrivateDepositId(String privateDepositId) {
		this.privateDepositId = privateDepositId;
	}
	public String getInvTermOfPaymentDtTH() {
		return invTermOfPaymentDtTH;
	}
	public void setInvTermOfPaymentDtTH(String invTermOfPaymentDtTH) {
		this.invTermOfPaymentDtTH = invTermOfPaymentDtTH;
	}
	public String getpDateTH() {
		return pDateTH;
	}
	public void setpDateTH(String pDateTH) {
		this.pDateTH = pDateTH;
	}
	public String getlDateTH() {
		return lDateTH;
	}
	public void setlDateTH(String lDateTH) {
		this.lDateTH = lDateTH;
	}
	public String getTermOfPaymentDtTH() {
		return termOfPaymentDtTH;
	}
	public void setTermOfPaymentDtTH(String termOfPaymentDtTH) {
		this.termOfPaymentDtTH = termOfPaymentDtTH;
	}
	public String getFromTermOfPaymentDtTH() {
		return fromTermOfPaymentDtTH;
	}
	public void setFromTermOfPaymentDtTH(String fromTermOfPaymentDtTH) {
		this.fromTermOfPaymentDtTH = fromTermOfPaymentDtTH;
	}
	public String getToTermOfPaymentDtTH() {
		return toTermOfPaymentDtTH;
	}
	public void setToTermOfPaymentDtTH(String toTermOfPaymentDtTH) {
		this.toTermOfPaymentDtTH = toTermOfPaymentDtTH;
	}
	public String getPeriodStartDtTH() {
		return periodStartDtTH;
	}
	public void setPeriodStartDtTH(String periodStartDtTH) {
		this.periodStartDtTH = periodStartDtTH;
	}
	public String getPeriodEndDtTH() {
		return periodEndDtTH;
	}
	public void setPeriodEndDtTH(String periodEndDtTH) {
		this.periodEndDtTH = periodEndDtTH;
	}
	public Date getDueDt() {
		return dueDt;
	}
	public void setDueDt(Date dueDt) {
		this.dueDt = dueDt;
	}
	public String getDueDtTH() {
		return dueDtTH;
	}
	public void setDueDtTH(String dueDtTH) {
		this.dueDtTH = dueDtTH;
	}
	public String getCreateDtTH() {
		return createDtTH;
	}
	public void setCreateDtTH(String createDtTH) {
		this.createDtTH = createDtTH;
	}
	public boolean isDisableVatType() {
		return disableVatType;
	}
	public void setDisableVatType(boolean disableVatType) {
		this.disableVatType = disableVatType;
	}
	public String getInstallmentrowId() {
		return installmentrowId;
	}
	public void setInstallmentrowId(String installmentrowId) {
		this.installmentrowId = installmentrowId;
	}
	public String getWhtTypeTxt() {
		return whtTypeTxt;
	}
	public void setWhtTypeTxt(String whtTypeTxt) {
		this.whtTypeTxt = whtTypeTxt;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public String getPrivatePrepaid() {
		return privatePrepaid;
	}
	public void setPrivatePrepaid(String privatePrepaid) {
		this.privatePrepaid = privatePrepaid;
	}
	public String getToTermOfPaymentDate() {
		return toTermOfPaymentDate;
	}
	public void setToTermOfPaymentDate(String toTermOfPaymentDate) {
		this.toTermOfPaymentDate = toTermOfPaymentDate;
	}
	public String getFromTermOfPaymentDate() {
		return fromTermOfPaymentDate;
	}
	public void setFromTermOfPaymentDate(String fromTermOfPaymentDate) {
		this.fromTermOfPaymentDate = fromTermOfPaymentDate;
	}
	public String getToTermOfPaymentMonth() {
		return toTermOfPaymentMonth;
	}
	public void setToTermOfPaymentMonth(String toTermOfPaymentMonth) {
		this.toTermOfPaymentMonth = toTermOfPaymentMonth;
	}
	public String getFromTermOfPaymentMonth() {
		return fromTermOfPaymentMonth;
	}
	public void setFromTermOfPaymentMonth(String fromTermOfPaymentMonth) {
		this.fromTermOfPaymentMonth = fromTermOfPaymentMonth;
	}
	public String getToTermOfPaymentYear() {
		return toTermOfPaymentYear;
	}
	public void setToTermOfPaymentYear(String toTermOfPaymentYear) {
		this.toTermOfPaymentYear = toTermOfPaymentYear;
	}
	public String getFromTermOfPaymentYear() {
		return fromTermOfPaymentYear;
	}
	public void setFromTermOfPaymentYear(String fromTermOfPaymentYear) {
		this.fromTermOfPaymentYear = fromTermOfPaymentYear;
	}
	public String getValidatePaymentDetailFlag() {
		return validatePaymentDetailFlag;
	}
	public void setValidatePaymentDetailFlag(String validatePaymentDetailFlag) {
		this.validatePaymentDetailFlag = validatePaymentDetailFlag;
	}
	public String getTermOfPaymentDate() {
		return termOfPaymentDate;
	}
	public void setTermOfPaymentDate(String termOfPaymentDate) {
		this.termOfPaymentDate = termOfPaymentDate;
	}
	public String getTermOfPaymentDateFrom() {
		return termOfPaymentDateFrom;
	}
	public void setTermOfPaymentDateFrom(String termOfPaymentDateFrom) {
		this.termOfPaymentDateFrom = termOfPaymentDateFrom;
	}
	public String getPaymentDocNo() {
		return paymentDocNo;
	}
	public void setPaymentDocNo(String paymentDocNo) {
		this.paymentDocNo = paymentDocNo;
	}
	public String getDepositDetailId() {
		return depositDetailId;
	}
	public void setDepositDetailId(String depositDetailId) {
		this.depositDetailId = depositDetailId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getWhoCreate() {
		return whoCreate;
	}
	public void setWhoCreate(String whoCreate) {
		this.whoCreate = whoCreate;
	}
	public String getWhoUpdate() {
		return whoUpdate;
	}
	public void setWhoUpdate(String whoUpdate) {
		this.whoUpdate = whoUpdate;
	}
	
		
}
