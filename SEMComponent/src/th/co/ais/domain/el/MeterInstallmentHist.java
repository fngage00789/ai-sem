package th.co.ais.domain.el;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;

@Entity
@Table(name="SEM_EL_METER_INSTALLMENT_HIST", schema="SEM")
public class MeterInstallmentHist extends AbstractDomain {
	
	private static final long serialVersionUID = 3231510971148836151L;

	private String rowId;
	private MeterInstallment meterInstallmentId;
	private String electricUseType;
	private Date termOfPaymentDt;
	private Date fromTermOfPaymentDt;
	private Date toTermOfPaymentDt;
	private BigDecimal periodNo;
	private BigDecimal periodAmt;
	private String periodName;
	private Date dueDt;
	private Date pDate;
	private Date lDate;
	private BigDecimal pRead;
	private BigDecimal lRead;
	private BigDecimal kwhTotal;
	private String docType;
	private String docNo;
	private Date docDt;
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
	private BigDecimal accureAmt;
	private String paidFlag;	
	
	@Id
  	@GeneratedValue(generator="system-uuid")
  	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "METER_INSTALLMENT_HIST_ID")
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "METER_INSTALLMENT_ID", nullable = false)
	public MeterInstallment getMeterInstallmentId() {
		return meterInstallmentId;
	}
	public void setMeterInstallmentId(MeterInstallment meterInstallmentId) {
		this.meterInstallmentId = meterInstallmentId;
	}
	
	@Column(name = "ELECTRIC_USE_TYPE")
	public String getElectricUseType() {
		return electricUseType;
	}
	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}
	
	@Column(name = "TERM_OF_PAYMENT_DT")
	public Date getTermOfPaymentDt() {
		return termOfPaymentDt;
	}
	public void setTermOfPaymentDt(Date termOfPaymentDt) {
		this.termOfPaymentDt = termOfPaymentDt;
	}
	
	@Column(name = "FROM_TERM_OF_PAYMENT_DT")
	public Date getFromTermOfPaymentDt() {
		return fromTermOfPaymentDt;
	}
	public void setFromTermOfPaymentDt(Date fromTermOfPaymentDt) {
		this.fromTermOfPaymentDt = fromTermOfPaymentDt;
	}
	
	@Column(name = "TO_TERM_OF_PAYMENT_DT")
	public Date getToTermOfPaymentDt() {
		return toTermOfPaymentDt;
	}
	public void setToTermOfPaymentDt(Date toTermOfPaymentDt) {
		this.toTermOfPaymentDt = toTermOfPaymentDt;
	}
	
	@Column(name = "PERIOD_NO")
	public BigDecimal getPeriodNo() {
		return periodNo;
	}
	public void setPeriodNo(BigDecimal periodNo) {
		this.periodNo = periodNo;
	}
	
	@Column(name = "PERIOD_AMT")
	public BigDecimal getPeriodAmt() {
		return periodAmt;
	}
	public void setPeriodAmt(BigDecimal periodAmt) {
		this.periodAmt = periodAmt;
	}
	
	@Column(name = "PERIOD_NAME")
	public String getPeriodName() {
		return periodName;
	}
	public void setPeriodName(String periodName) {
		this.periodName = periodName;
	}
	
	@Column(name = "DUE_DT")
	public Date getDueDt() {
		return dueDt;
	}
	public void setDueDt(Date dueDt) {
		this.dueDt = dueDt;
	}
	
	@Column(name = "P_DATE")
	public Date getpDate() {
		return pDate;
	}
	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}
	
	@Column(name = "L_DATE")
	public Date getlDate() {
		return lDate;
	}
	public void setlDate(Date lDate) {
		this.lDate = lDate;
	}
	
	@Column(name = "P_READ")
	public BigDecimal getpRead() {
		return pRead;
	}
	public void setpRead(BigDecimal pRead) {
		this.pRead = pRead;
	}
	
	@Column(name = "L_READ")
	public BigDecimal getlRead() {
		return lRead;
	}
	public void setlRead(BigDecimal lRead) {
		this.lRead = lRead;
	}
	
	@Column(name = "KWH_TOTAL")
	public BigDecimal getKwhTotal() {
		return kwhTotal;
	}
	public void setKwhTotal(BigDecimal kwhTotal) {
		this.kwhTotal = kwhTotal;
	}
	
	@Column(name = "DOC_TYPE")
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	
	@Column(name = "DOC_NO")
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	
	@Column(name = "DOC_DT")
	public Date getDocDt() {
		return docDt;
	}
	public void setDocDt(Date docDt) {
		this.docDt = docDt;
	}
	
	@Column(name = "PAY_AMT")
	public BigDecimal getPayAmt() {
		return payAmt;
	}
	public void setPayAmt(BigDecimal payAmt) {
		this.payAmt = payAmt;
	}
	
	@Column(name = "VAT_TYPE")
	public String getVatType() {
		return vatType;
	}
	public void setVatType(String vatType) {
		this.vatType = vatType;
	}
	
	@Column(name = "VAT_RATE")
	public BigDecimal getVatRate() {
		return vatRate;
	}
	public void setVatRate(BigDecimal vatRate) {
		this.vatRate = vatRate;
	}
	
	@Column(name = "VAT_AMT")
	public BigDecimal getVatAmt() {
		return vatAmt;
	}
	public void setVatAmt(BigDecimal vatAmt) {
		this.vatAmt = vatAmt;
	}
	
	@Column(name = "WHT_TYPE")
	public String getWhtType() {
		return whtType;
	}
	public void setWhtType(String whtType) {
		this.whtType = whtType;
	}
	
	@Column(name = "WHT_RATE")
	public BigDecimal getWhtRate() {
		return whtRate;
	}
	public void setWhtRate(BigDecimal whtRate) {
		this.whtRate = whtRate;
	}
	
	@Column(name = "WHT_AMT")
	public BigDecimal getWhtAmt() {
		return whtAmt;
	}
	public void setWhtAmt(BigDecimal whtAmt) {
		this.whtAmt = whtAmt;
	}
	
	@Column(name = "EXCLUDE_VAT_AMT")
	public BigDecimal getExcludeVatAmt() {
		return excludeVatAmt;
	}
	public void setExcludeVatAmt(BigDecimal excludeVatAmt) {
		this.excludeVatAmt = excludeVatAmt;
	}
	
	@Column(name = "INCLUDE_VAT_AMT")
	public BigDecimal getIncludeVatAmt() {
		return includeVatAmt;
	}
	public void setIncludeVatAmt(BigDecimal includeVatAmt) {
		this.includeVatAmt = includeVatAmt;
	}
	
	@Column(name = "CHQ_AMT")
	public BigDecimal getChqAmt() {
		return chqAmt;
	}
	public void setChqAmt(BigDecimal chqAmt) {
		this.chqAmt = chqAmt;
	}
	
	@Column(name = "ACCRUE_AMT")
	public BigDecimal getAccureAmt() {
		return accureAmt;
	}
	public void setAccureAmt(BigDecimal accureAmt) {
		this.accureAmt = accureAmt;
	}
	
	@Column(name = "PAID_FLAG")
	public String getPaidFlag() {
		return paidFlag;
	}
	public void setPaidFlag(String paidFlag) {
		this.paidFlag = paidFlag;
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
	
}
