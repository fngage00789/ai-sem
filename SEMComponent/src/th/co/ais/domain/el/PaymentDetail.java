package th.co.ais.domain.el;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;

@Entity
@Table(name="SEM_EL_PAYMENT_DETAIL", schema="SEM")



public class PaymentDetail extends AbstractDomain {

	private static final long serialVersionUID = 4510715466573524911L;
	private static final SimpleDateFormat exportFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
	private static final SimpleDateFormat exportFormatMmYyyy = new SimpleDateFormat("MM/yyyy", new Locale("th", "TH"));
	
	private String rowId;
	private Payment paymentId;
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
	private String detailFlag = "Y";
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
	//private boolean validatePaymentDetailFlagBoolean;
	
	//added by new 2015/05/13
	private String processType;
	
	private String remarkPending;
	private String remarkVerify;
	
	@Id
   	@GeneratedValue(generator="system-uuid")
   	@GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="PAYMENT_DETAIL_ID")	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PAYMENT_ID")
	public Payment getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Payment paymentId) {
		this.paymentId = paymentId;
	}
	
	@Column(name="EXPENSE_TYPE")
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}	
	
	
	@Column(name="PERIOD_NAME")
	public String getPeriodName() {
		return periodName;
	}
	public void setPeriodName(String periodName) {
		this.periodName = periodName;
	}
	
	
	@Column(name="METER_INFO_ID")
	public String getMeterInfoId() {
		return meterInfoId;
	}
	public void setMeterInfoId(String meterInfoId) {
		this.meterInfoId = meterInfoId;
	}
	@Column(name="FEE_AREA_CODE")
	public String getFeeAreaCode() {
		return feeAreaCode;
	}
	public void setFeeAreaCode(String feeAreaCode) {
		this.feeAreaCode = feeAreaCode;
	}
	
	@Column(name="FEE_METER_ID")
	public String getFeeMeterId() {
		return feeMeterId;
	}
	public void setFeeMeterId(String feeMeterId) {
		this.feeMeterId = feeMeterId;
	}
	
	
	
	@Column(name="FEE_CHECK_AREA")
	public String getFeeCheckArea() {
		return feeCheckArea;
	}
	public void setFeeCheckArea(String feeCheckArea) {
		this.feeCheckArea = feeCheckArea;
	}
	
	@Column(name="FEE_WBS_CODE")
	public String getFeeWbsCode() {
		return feeWbsCode;
	}
	public void setFeeWbsCode(String feeWbsCode) {
		this.feeWbsCode = feeWbsCode;
	}
	
	@Column(name="INV_NO")
	public BigDecimal getInvNo() {
		return invNo;
	}
	public void setInvNo(BigDecimal invNo) {
		this.invNo = invNo;
	}
	
	@Column(name="INV_SITE_NAME")
	public String getInvSiteName() {
		return invSiteName;
	}
	public void setInvSiteName(String invSiteName) {
		this.invSiteName = invSiteName;
	}
	
	@Column(name="INV_AREA_CODE")
	public String getInvAreaCode() {
		return invAreaCode;
	}
	public void setInvAreaCode(String invAreaCode) {
		this.invAreaCode = invAreaCode;
	}
	
	@Column(name="INV_AREA_NAME")
	public String getInvAreaName() {
		return invAreaName;
	}
	public void setInvAreaName(String invAreaName) {
		this.invAreaName = invAreaName;
	}
	
	@Column(name="INV_METER_ID")
	public String getInvMeterId() {
		return invMeterId;
	}
	public void setInvMeterId(String invMeterId) {
		this.invMeterId = invMeterId;
	}
	
	@Column(name="INV_TERM_OF_PAYMENT_DT")
	public Date getInvTermOfPaymentDt() {
		return invTermOfPaymentDt;
	}
	public void setInvTermOfPaymentDt(Date invTermOfPaymentDt) {
		this.invTermOfPaymentDt = invTermOfPaymentDt;
	}
	
	@Column(name="INV_EXCLUDE_VAT_AMT")
	public BigDecimal getInvExcludeVatAmt() {
		return invExcludeVatAmt;
	}
	public void setInvExcludeVatAmt(BigDecimal invExcludeVatAmt) {
		this.invExcludeVatAmt = invExcludeVatAmt;
	}
	
	@Column(name="INV_VAT_AMT")
	public BigDecimal getInvVatAmt() {
		return invVatAmt;
	}
	public void setInvVatAmt(BigDecimal invVatAmt) {
		this.invVatAmt = invVatAmt;
	}
	
	@Column(name="INV_INCLUDE_VAT_AMT")
	public BigDecimal getInvIncludeVatAmt() {
		return invIncludeVatAmt;
	}
	public void setInvIncludeVatAmt(BigDecimal invIncludeVatAmt) {
		this.invIncludeVatAmt = invIncludeVatAmt;
	}
	
	@Column(name="REFER_METER_ID")
	public String getReferMeterId() {
		return referMeterId;
	}
	public void setReferMeterId(String referMeterId) {
		this.referMeterId = referMeterId;
	}
	
	@Column(name="METER_ID")
	public String getMeterId() {
		return meterId;
	}
	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}
	
	@Column(name="P_DATE")
	public Date getpDate() {
		return pDate;
	}
	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}
	
	@Column(name="L_DATE")
	public Date getlDate() {
		return lDate;
	}
	public void setlDate(Date lDate) {
		this.lDate = lDate;
	}
	
	@Column(name="P_READ")
	public BigDecimal getpRead() {
		return pRead;
	}
	public void setpRead(BigDecimal pRead) {
		this.pRead = pRead;
		if(pRead!=null){
			pReadStr = pRead.toString();
		}
	}
	
	@Column(name="L_READ")
	public BigDecimal getlRead() {
		return lRead;
	}
	public void setlRead(BigDecimal lRead) {
		this.lRead = lRead;
		if(lRead!=null){
			lReadStr = lRead.toString();
		}
	}
	
	@Column(name="KWH_TOTAL")
	public BigDecimal getKwhTotal() {
		return kwhTotal;
	}
	public void setKwhTotal(BigDecimal kwhTotal) {
		this.kwhTotal = kwhTotal;
		if(kwhTotal!=null){
			kwhTotalStr = kwhTotal.toString();
		}
	}
	
	@Column(name="UNIT_PRICE")
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	@Column(name="UNIT_VAT_TYPE")
	public String getUnitVatType() {
		return unitVatType;
	}
	public void setUnitVatType(String unitVatType) {
		this.unitVatType = unitVatType;
	}
	
	@Column(name="UNIT_VAT_RATE")
	public BigDecimal getUnitVatRate() {
		return unitVatRate;
	}
	public void setUnitVatRate(BigDecimal unitVatRate) {
		this.unitVatRate = unitVatRate;
	}
	
	@Column(name="TERM_OF_PAYMENT_DT")
	public Date getTermOfPaymentDt() {
		return termOfPaymentDt;
	}
	public void setTermOfPaymentDt(Date termOfPaymentDt) {
		this.termOfPaymentDt = termOfPaymentDt;
	}
	
	@Column(name="FROM_TERM_OF_PAYMENT_DT")
	public Date getFromTermOfPaymentDt() {
		return fromTermOfPaymentDt;
	}
	public void setFromTermOfPaymentDt(Date fromTermOfPaymentDt) {
		this.fromTermOfPaymentDt = fromTermOfPaymentDt;
	}
	
	@Column(name="TO_TERM_OF_PAYMENT_DT")
	public Date getToTermOfPaymentDt() {
		return toTermOfPaymentDt;
	}
	public void setToTermOfPaymentDt(Date toTermOfPaymentDt) {
		this.toTermOfPaymentDt = toTermOfPaymentDt;
	}
	
	@Column(name="PAY_AMT")
	public BigDecimal getPayAmt() {
		return payAmt;
	}
	public void setPayAmt(BigDecimal payAmt) {
		this.payAmt = payAmt;
	}
	
	@Column(name="VAT_TYPE")
	public String getVatType() {
		return vatType;
	}
	public void setVatType(String vatType) {
		this.vatType = vatType;
	}
	
	@Column(name="VAT_RATE")
	public BigDecimal getVatRate() {
		return vatRate;
	}
	public void setVatRate(BigDecimal vatRate) {
		this.vatRate = vatRate;
	}
	
	@Column(name="VAT_AMT")
	public BigDecimal getVatAmt() {
		return vatAmt;
	}
	public void setVatAmt(BigDecimal vatAmt) {
		this.vatAmt = vatAmt;
	}
	
	@Column(name="WHT_TYPE")
	public String getWhtType() {
		return whtType;
	}
	public void setWhtType(String whtType) {
		this.whtType = whtType;
	}
	
	@Column(name="WHT_RATE")
	public BigDecimal getWhtRate() {
		return whtRate;
	}
	public void setWhtRate(BigDecimal whtRate) {
		this.whtRate = whtRate;
	}
	
	@Column(name="WHT_AMT")
	public BigDecimal getWhtAmt() {
		return whtAmt;
	}
	public void setWhtAmt(BigDecimal whtAmt) {
		this.whtAmt = whtAmt;
	}
	
	@Column(name="EXCLUDE_VAT_AMT")
	public BigDecimal getExcludeVatAmt() {
		return excludeVatAmt;
	}
	public void setExcludeVatAmt(BigDecimal excludeVatAmt) {
		this.excludeVatAmt = excludeVatAmt;
	}
	
	@Column(name="INCLUDE_VAT_AMT")
	public BigDecimal getIncludeVatAmt() {
		return includeVatAmt;
	}
	public void setIncludeVatAmt(BigDecimal includeVatAmt) {
		this.includeVatAmt = includeVatAmt;
	}
	
	@Column(name="CHQ_AMT")
	public BigDecimal getChqAmt() {
		return chqAmt;
	}
	public void setChqAmt(BigDecimal chqAmt) {
		this.chqAmt = chqAmt;
	}
	
	@Column(name="PERIOD_NO")
	public BigDecimal getPeriodNo() {
		return periodNo;
	}
	public void setPeriodNo(BigDecimal periodNo) {
		this.periodNo = periodNo;
	}
	
	@Column(name="PERIOD_TYPE")
	public String getPeriodType() {
		return periodType;
	}
	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}
	
	@Column(name="PERIOD_INTERVAL")
	public BigDecimal getPeriodInterval() {
		return periodInterval;
	}
	public void setPeriodInterval(BigDecimal periodInterval) {
		this.periodInterval = periodInterval;
	}
	
	@Column(name="PERIOD_START_DT")
	public Date getPeriodStartDt() {
		return periodStartDt;
	}
	public void setPeriodStartDt(Date periodStartDt) {
		this.periodStartDt = periodStartDt;
	}
	
	@Column(name="PERIOD_END_DT")
	public Date getPeriodEndDt() {
		return periodEndDt;
	}
	public void setPeriodEndDt(Date periodEndDt) {
		this.periodEndDt = periodEndDt;
	}
	
	@Column(name="PERIOD_DAY")
	public BigDecimal getPeriodDay() {
		return periodDay;
	}
	public void setPeriodDay(BigDecimal periodDay) {
		this.periodDay = periodDay;
	}
	
	@Column(name="PERIOD_MONTH")
	public BigDecimal getPeriodMonth() {
		return periodMonth;
	}
	public void setPeriodMonth(BigDecimal periodMonth) {
		this.periodMonth = periodMonth;
	}
	
	@Column(name="PERIOD_YEAR")
	public BigDecimal getPeriodYear() {
		return periodYear;
	}
	public void setPeriodYear(BigDecimal periodYear) {
		this.periodYear = periodYear;
	}
	
	@Column(name="PERIOD_AMT")
	public BigDecimal getPeriodAmt() {
		return periodAmt;
	}
	public void setPeriodAmt(BigDecimal periodAmt) {
		this.periodAmt = periodAmt;
	}
	
	@Column(name="REMARK")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name="RECORD_STATUS")
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	@Override
	@Column(name="CREATE_BY")
	public String getCreateBy() {
		return this.createBy;
	}
	@Override
	@Column(name="CREATE_DT")
	public Date getCreateDt() {
		return this.createDt;
	}

	@Override
	@Column(name="UPDATE_BY")
	public String getUpdateBy() {
		return this.updateBy;
	}

	@Override
	@Column(name="UPDATE_DT")
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
	
	@Transient
	public String getInvMeterIdDisplay() {
		return invMeterIdDisplay;
	}
	public void setInvMeterIdDisplay(String invMeterIdDisplay) {
		this.invMeterIdDisplay = invMeterIdDisplay;
	}
	@Transient
	public String getTermOfPaymentDtMonth() {
		return termOfPaymentDtMonth;
	}
	public void setTermOfPaymentDtMonth(String termOfPaymentDtMonth) {
		this.termOfPaymentDtMonth = termOfPaymentDtMonth;
	}
	@Transient
	public String getTermOfPaymentDtYear() {
		return termOfPaymentDtYear;
	}
	public void setTermOfPaymentDtYear(String termOfPaymentDtYear) {
		this.termOfPaymentDtYear = termOfPaymentDtYear;
	}
	@Column(name="INV_DOC_NO")	
	public String getInvDocNo() {
		return invDocNo;
	}
	public void setInvDocNo(String invDocNo) {
		this.invDocNo = invDocNo;
	}
	
	@Transient
	public String getWhtCheck() {
		return whtCheck;
	}
	public void setWhtCheck(String whtCheck) {
		this.whtCheck = whtCheck;
	}
		@Transient
	public int getRowNumber() {
		return rowNumber;
	}
	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}
	@Transient
	public String getExpenseTypeTxt() {
		return expenseTypeTxt;
	}
	public void setExpenseTypeTxt(String expenseTypeTxt) {
		this.expenseTypeTxt = expenseTypeTxt;
	}
	@Transient
	public String getVatTypeTxt() {
		return vatTypeTxt;
	}
	public void setVatTypeTxt(String vatTypeTxt) {
		this.vatTypeTxt = vatTypeTxt;
	}

	
	@Transient
	public boolean isWhtCheckBoolean(){		
		return getWhtCheck() != null && getWhtCheck().equalsIgnoreCase("y");
	}

	public void setWhtCheckBoolean(boolean flag){		
		if(flag) setWhtCheck("Y");
		else setWhtCheck("N");
	}
	
	@Column(name="DETAIL_FLAG")	
	public String getDetailFlag() {
		return detailFlag;
	}
	public void setDetailFlag(String detailFlag) {
		this.detailFlag = detailFlag;
	}
	
	@Transient
	public String getInvTermOfPaymentDtTH() {
		
		return invTermOfPaymentDt!=null?exportFormat.format(invTermOfPaymentDt):"";
	}
	@Transient
	public String getpDateTH() {
		
		return pDate!=null?exportFormat.format(pDate):"";
	}
	@Transient
	public String getlDateTH() {
		
		return lDate!=null?exportFormat.format(lDate):"";
	}
	@Transient
	public String getTermOfPaymentDtTH() {
		
		return termOfPaymentDt!=null?exportFormat.format(termOfPaymentDt):"";
	}
	@Transient
	public String getCreateDtTH() {
		return createDt!=null?exportFormat.format(createDt):"";
		
	}
	
	@Transient
	public String getFromTermOfPaymentDtTH() {
		
		return fromTermOfPaymentDt!=null?exportFormat.format(fromTermOfPaymentDt):"";
	}
	@Transient
	public String getToTermOfPaymentDtTH() {
		
		return toTermOfPaymentDt!=null?exportFormat.format(toTermOfPaymentDt):"";
	}
	@Transient
	public String getPeriodStartDtTH() {
		
		return periodStartDt!=null?exportFormat.format(periodStartDt):"";
	}
	@Transient
	public String getPeriodEndDtTH() {
		
		return periodEndDt!=null?exportFormat.format(periodEndDt):"";
	}
	@Transient
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	@Transient
	public String getInstallmentrowId() {
		return installmentrowId;
	}
	
	public void setInstallmentrowId(String installmentrowId) {
		this.installmentrowId = installmentrowId;
	}
	
	@Transient
	public boolean isDisableVatType() {
		return disableVatType;
	}
	public void setDisableVatType(boolean disableVatType) {
		this.disableVatType = disableVatType;
	}
	@Transient
	public String getMeterAddress() {
		return meterAddress;
	}
	public void setMeterAddress(String meterAddress) {
		this.meterAddress = meterAddress;
	}
	
	@Transient
	public String getUnitVatTypeTxt() {
		return unitVatTypeTxt;
	}
	public void setUnitVatTypeTxt(String unitVatTypeTxt) {
		this.unitVatTypeTxt = unitVatTypeTxt;
	}
	
	@Transient
	public Date getDueDt() {
		return dueDt;
	}
	public void setDueDt(Date dueDt) {
		this.dueDt = dueDt;
	}
	
	@Transient
	public String getDueDtTH() {	
		return dueDt!=null?exportFormat.format(dueDt):"";
	}
	public void setDueDtTH(String dueDtTH) {
		this.dueDtTH = dueDtTH;
	}
		
	@Column(name="PRIVATE_DEPOSIT_ID")
	public String getPrivateDepositId() {
		return privateDepositId;
	}
	public void setPrivateDepositId(String privateDepositId) {
		this.privateDepositId = privateDepositId;
	}
	@Transient
	public String getWhtTypeTxt() {
		return whtTypeTxt;
	}
	public void setWhtTypeTxt(String whtTypeTxt) {
		this.whtTypeTxt = whtTypeTxt;
	}
	
	@Column(name="PRIVATE_PREPAID_ID")
	public String getPrivatePrepaid() {
		return privatePrepaid;
	}
	
	public void setPrivatePrepaid(String privatePrepaid) {
		this.privatePrepaid = privatePrepaid;
	}
	
	//WT###Add 20110125 Start
	public PaymentDetail clonePaymentDetail(){
		PaymentDetail newPaymentDetail = new PaymentDetail();
		newPaymentDetail.setRowId(rowId);
		newPaymentDetail.setChqAmt(chqAmt);
		newPaymentDetail.setCreateBy(createBy);
		newPaymentDetail.setCreateDt(createDt);
		newPaymentDetail.setDetailFlag(detailFlag);
		newPaymentDetail.setDueDt(dueDt);
		newPaymentDetail.setExcludeVatAmt(excludeVatAmt);
		newPaymentDetail.setExpenseType(expenseType);
		newPaymentDetail.setFeeAreaCode(feeAreaCode);
		newPaymentDetail.setFeeCheckArea(feeCheckArea);
		newPaymentDetail.setFeeMeterId(feeMeterId);
		newPaymentDetail.setFeeWbsCode(feeWbsCode);
		newPaymentDetail.setIncludeVatAmt(includeVatAmt);
		newPaymentDetail.setInstallmentrowId(installmentrowId);
		newPaymentDetail.setInvAreaCode(invAreaCode);
		newPaymentDetail.setInvAreaName(invAreaName);
		newPaymentDetail.setInvDocNo(invDocNo);
		newPaymentDetail.setInvExcludeVatAmt(invExcludeVatAmt);
		newPaymentDetail.setInvIncludeVatAmt(invIncludeVatAmt);
		newPaymentDetail.setInvMeterId(invMeterId);
		newPaymentDetail.setInvNo(invNo);
		newPaymentDetail.setInvSiteName(invSiteName);
		newPaymentDetail.setInvTermOfPaymentDt(invTermOfPaymentDt);
		newPaymentDetail.setInvVatAmt(invVatAmt);
		newPaymentDetail.setKwhTotal(kwhTotal);
		newPaymentDetail.setlDate(lDate);
		newPaymentDetail.setlRead(lRead);
		newPaymentDetail.setMeterAddress(meterAddress);
		newPaymentDetail.setMeterId(meterId);
		newPaymentDetail.setMeterInfoId(meterInfoId);
		newPaymentDetail.setPayAmt(payAmt);
		newPaymentDetail.setPaymentId(paymentId);
		newPaymentDetail.setpRead(pRead);
		newPaymentDetail.setpDate(pDate);
		newPaymentDetail.setPeriodAmt(periodAmt);
		newPaymentDetail.setPeriodDay(periodDay);
		newPaymentDetail.setPeriodEndDt(periodEndDt);
		newPaymentDetail.setPeriodInterval(periodInterval);
		newPaymentDetail.setPeriodMonth(periodMonth);
		newPaymentDetail.setPeriodName(periodName);
		newPaymentDetail.setPeriodNo(periodNo);
		newPaymentDetail.setPeriodStartDt(periodStartDt);
		newPaymentDetail.setPeriodType(periodType);
		newPaymentDetail.setPeriodYear(periodYear);
		newPaymentDetail.setRecordStatus(recordStatus);
		newPaymentDetail.setReferMeterId(referMeterId);
		newPaymentDetail.setRemark(remark);
		newPaymentDetail.setTermOfPaymentDt(termOfPaymentDt);		
		newPaymentDetail.setTermOfPaymentDtMonth(termOfPaymentDtMonth);
		newPaymentDetail.setTermOfPaymentDtYear(termOfPaymentDtYear);
		newPaymentDetail.setFromTermOfPaymentDt(fromTermOfPaymentDt);
		newPaymentDetail.setToTermOfPaymentDt(toTermOfPaymentDt);
		newPaymentDetail.setUnitPrice(unitPrice);
		newPaymentDetail.setUnitVatRate(unitVatRate);
		newPaymentDetail.setUnitVatType(unitVatType);
		newPaymentDetail.setUpdateBy(updateBy);
		newPaymentDetail.setUpdateDt(updateDt);
		newPaymentDetail.setVatAmt(vatAmt);
		newPaymentDetail.setVatRate(vatRate);
		newPaymentDetail.setVatType(vatType);
		newPaymentDetail.setWhtAmt(whtAmt);
		newPaymentDetail.setWhtCheck(whtCheck);
		newPaymentDetail.setWhtRate(whtRate);
		newPaymentDetail.setWhtType(whtType);
		newPaymentDetail.setFromTermOfPaymentMonth(fromTermOfPaymentMonth);
		newPaymentDetail.setFromTermOfPaymentYear(fromTermOfPaymentYear);
		newPaymentDetail.setToTermOfPaymentMonth(toTermOfPaymentMonth);
		newPaymentDetail.setToTermOfPaymentYear(toTermOfPaymentYear);
		newPaymentDetail.setValidatePaymentDetailFlag(validatePaymentDetailFlag);
		
		return newPaymentDetail;
	}
	//WT###Add 20110125 End
	
	@Transient
	public String getToTermOfPaymentDate() {
		return toTermOfPaymentDate;
	}
	public void setToTermOfPaymentDate(String toTermOfPaymentDate) {
		this.toTermOfPaymentDate = toTermOfPaymentDate;
	}
	@Transient
	public String getFromTermOfPaymentDate() {
		return fromTermOfPaymentDate;
	}
	public void setFromTermOfPaymentDate(String fromTermOfPaymentDate) {
		this.fromTermOfPaymentDate = fromTermOfPaymentDate;
	}
	@Transient
	public String getToTermOfPaymentMonth() {
		return toTermOfPaymentMonth;
	}
	public void setToTermOfPaymentMonth(String toTermOfPaymentMonth) {
		this.toTermOfPaymentMonth = toTermOfPaymentMonth;
	}
	@Transient
	public String getFromTermOfPaymentMonth() {
		return fromTermOfPaymentMonth;
	}
	public void setFromTermOfPaymentMonth(String fromTermOfPaymentMonth) {
		this.fromTermOfPaymentMonth = fromTermOfPaymentMonth;
	}
	@Transient
	public String getToTermOfPaymentYear() {
		return toTermOfPaymentYear;
	}
	public void setToTermOfPaymentYear(String toTermOfPaymentYear) {
		this.toTermOfPaymentYear = toTermOfPaymentYear;
	}
	@Transient
	public String getFromTermOfPaymentYear() {
		return fromTermOfPaymentYear;
	}
	public void setFromTermOfPaymentYear(String fromTermOfPaymentYear) {
		this.fromTermOfPaymentYear = fromTermOfPaymentYear;
	}
	public void setFromTermOfPaymentDtTH(String fromTermOfPaymentDtTH) {
		this.fromTermOfPaymentDtTH = fromTermOfPaymentDtTH;
	}
	public void setToTermOfPaymentDtTH(String toTermOfPaymentDtTH) {
		this.toTermOfPaymentDtTH = toTermOfPaymentDtTH;
	}
	
	@Transient
	public boolean isValidatePaymentDetailFlagBoolean(){
		
		return validatePaymentDetailFlag != null && validatePaymentDetailFlag.equals("Y") ? true : false;
	}
	
	public void setValidatePaymentDetailFlagBoolean(boolean validatePaymentDetailFlagBoolean){
		System.out.println("validatePaymentDetailFlagBoolean:"+validatePaymentDetailFlagBoolean);
		if(validatePaymentDetailFlagBoolean) setValidatePaymentDetailFlag("Y");
		else setValidatePaymentDetailFlag("N");
	}
	
	@Column(name="VALIDATE_PAYMENT_DETAIL")
	public String getValidatePaymentDetailFlag() {
		return validatePaymentDetailFlag;
	}
	public void setValidatePaymentDetailFlag(String validatePaymentDetailFlag) {
		this.validatePaymentDetailFlag = validatePaymentDetailFlag;
	}
	
	@Transient
	public String getpReadStr() {
		return pReadStr;
	}
	public void setpReadStr(String pReadStr) {
		this.pReadStr = pReadStr;
		if(pReadStr!=null && !"".equals(pReadStr)){
			this.pRead = new BigDecimal(pReadStr);
		}
	}
	
	@Transient
	public String getlReadStr() {
		return lReadStr;
	}
	public void setlReadStr(String lReadStr) {
		this.lReadStr = lReadStr;
		if(lReadStr!=null && !"".equals(lReadStr)){
			this.lRead = new BigDecimal(lReadStr);
		}
	}
	
	@Transient
	public String getKwhTotalStr() {
		return kwhTotalStr;
	}
	public void setKwhTotalStr(String kwhTotalStr) {
		this.kwhTotalStr = kwhTotalStr;
		if(kwhTotalStr!=null && !"".equals(kwhTotalStr)){
			this.kwhTotal = new BigDecimal(kwhTotalStr);
		}
	}
	@Column(name="PAYMENT_MULTI_VENDOR")	
	public String getMultiVendorCheck() {
		return multiVendorCheck;
	}
	public void setMultiVendorCheck(String multiVendorCheck) {
		this.multiVendorCheck = multiVendorCheck;
	}	
	@Transient
	public boolean isMultiVendorCheckBoolean(){		
		return getMultiVendorCheck() != null && getMultiVendorCheck().equalsIgnoreCase("Y");
	}

	public void setMultiVendorCheckBoolean(boolean flag){		
		if(flag) setMultiVendorCheck("Y");
		else setMultiVendorCheck("N");
	}
	@Transient
	public String getTermOfPaymentDate() {
		String fromDate = fromTermOfPaymentDt!=null?exportFormatMmYyyy.format(fromTermOfPaymentDt):"";
		String toDate   = toTermOfPaymentDt!=null?exportFormatMmYyyy.format(toTermOfPaymentDt):"";
		if(fromDate.equalsIgnoreCase(toDate)){
			return fromDate;
		}else{
			return fromDate + "-" + toDate;
		}
		
		
	}
	public void setTermOfPaymentDate(String termOfPaymentDate) {
		this.termOfPaymentDate = termOfPaymentDate;
	}
	@Transient
	public String getTermOfPaymentDateFrom() {
		return termOfPaymentDateFrom;
	}
	public void setTermOfPaymentDateFrom(String termOfPaymentDateFrom) {
		this.termOfPaymentDateFrom = termOfPaymentDateFrom;
	}
	@Transient
	public String getPaymentDocNo() {
		return paymentDocNo;
	}
	public void setPaymentDocNo(String paymentDocNo) {
		this.paymentDocNo = paymentDocNo;
	}
	@Transient
	public String getDepositDetailId() {
		return depositDetailId;
	}
	public void setDepositDetailId(String depositDetailId) {
		this.depositDetailId = depositDetailId;
	}
	@Transient
	public String getProcessType() {
		return processType;
	}
	public void setProcessType(String processType) {
		this.processType = processType;
	}
	@Transient
	public String getRemarkPending() {
		return remarkPending;
	}
	public void setRemarkPending(String remarkPending) {
		this.remarkPending = remarkPending;
	}
	@Transient
	public String getRemarkVerify() {
		return remarkVerify;
	}
	public void setRemarkVerify(String remarkVerify) {
		this.remarkVerify = remarkVerify;
	}
	
}
