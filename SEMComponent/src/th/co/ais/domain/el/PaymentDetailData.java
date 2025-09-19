package th.co.ais.domain.el;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;


@org.hibernate.annotations.NamedNativeQuery(
    name="querySearchPaymentDetailData",  
    query="call SEM_PG_EL_SITE_INFO_PROCESS_SP_INSTALLMENT_SRCH(?,:contractNo,:meterInfoId,:fromTermOfPayment,:toTermOfPayment)",   
    callable = true, readOnly = true,
    resultClass=InstallmentSearch7.class 
)  


@Entity 
public class PaymentDetailData implements Serializable{
	private static final long serialVersionUID = 1137928449676053552L;	
	private static final SimpleDateFormat exportFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
	
	
	/*  In parameter
	

	 */
	
	@Id
	@Column(name = "METER_INSTALLMENT_ID")	
	private String meterInstallmentID;
	
	
	//@Transient
	@Column(name = "METER_ID")	
	private String meterId;
	
	//@Transient
	@Column(name = "REFER_METER_ID")	
	private String refMeterId;
	
	//@Transient
	@Column(name = "TERM_OF_PAYMENT_DT")
	private Date termOfPaymentDt;
	
	//@Transient
	@Column(name = "FROM_TERM_OF_PAYMENT_DT")
	private Date fromTermOfPaymentDt;
	
	//@Transient
	@Column(name = "TO_TERM_OF_PAYMENT_DT")
	private Date toTermOfPaymentDt;
	
	//@Transient
	@Column(name = "INCLUDE_VAT_AMT")
	private BigDecimal inculdeVat;
	
	@Column(name = "EXCLUDE_VAT_AMT")
	private BigDecimal exculdeVat;
	//@Transient
	@Column(name = "VAT_AMT")
	private BigDecimal vatAmt;
	
	//@Transient
	@Column(name = "DEBIT_AMT")
	private BigDecimal debitAmt;
	
	@Column(name = "PAY_AMT")
	private BigDecimal payAmt;
	//@Transient
	@Column(name = "SUM_AMT")
	private BigDecimal sumAmt;
	
	//@Transient
	@Column(name = "P_DATE")
	private Date pDate;
	
	//@Transient
	@Column(name = "L_DATE")
	private Date lDate;
	
	//@Transient
	@Column(name = "P_READ")
	private BigDecimal pRaed;
	
	//@Transient
	@Column(name = "L_READ")
	private BigDecimal lRaed;
	
	//@Transient
	@Column(name = "KWH_TOTAL")
	private BigDecimal kwh;
	
	@Column(name = "VAT_TYPE")	
	private String vatType;
	
	@Transient
	private String meterInfoId;	
	
	@Transient
	private Date fromTermOfPayment;
	
	@Transient
	private Date toTermOfPayment;

	@Transient
	private String contractNo;
	

	public String getMeterInstallmentID() {
		return meterInstallmentID;
	}

	public void setMeterInstallmentID(String meterInstallmentID) {
		this.meterInstallmentID = meterInstallmentID;
	}

	public String getMeterId() {
		return meterId;
	}

	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}

	public String getRefMeterId() {
		return refMeterId;
	}

	public void setRefMeterId(String refMeterId) {
		this.refMeterId = refMeterId;
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

	public BigDecimal getInculdeVat() {
		return inculdeVat;
	}

	public void setInculdeVat(BigDecimal inculdeVat) {
		this.inculdeVat = inculdeVat;
	}

	public BigDecimal getVatAmt() {
		return vatAmt;
	}

	public void setVatAmt(BigDecimal vatAmt) {
		this.vatAmt = vatAmt;
	}

	public BigDecimal getDebitAmt() {
		return debitAmt;
	}

	public void setDebitAmt(BigDecimal debitAmt) {
		this.debitAmt = debitAmt;
	}

	public BigDecimal getSumAmt() {
		return sumAmt;
	}

	public void setSumAmt(BigDecimal sumAmt) {
		this.sumAmt = sumAmt;
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

	public BigDecimal getpRaed() {
		return pRaed;
	}

	public void setpRaed(BigDecimal pRaed) {
		this.pRaed = pRaed;
	}

	public BigDecimal getlRaed() {
		return lRaed;
	}

	public void setlRaed(BigDecimal lRaed) {
		this.lRaed = lRaed;
	}

	public BigDecimal getKwh() {
		return kwh;
	}

	public void setKwh(BigDecimal kwh) {
		this.kwh = kwh;
	}

	public String getMeterInfoId() {
		return meterInfoId;
	}

	public void setMeterInfoId(String meterInfoId) {
		this.meterInfoId = meterInfoId;
	}

	public Date getFromTermOfPayment() {
		return fromTermOfPayment;
	}

	public void setFromTermOfPayment(Date fromTermOfPayment) {
		this.fromTermOfPayment = fromTermOfPayment;
	}

	public Date getToTermOfPayment() {
		return toTermOfPayment;
	}

	public void setToTermOfPayment(Date toTermOfPayment) {
		this.toTermOfPayment = toTermOfPayment;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public BigDecimal getExculdeVat() {
		return exculdeVat;
	}

	public void setExculdeVat(BigDecimal exculdeVat) {
		this.exculdeVat = exculdeVat;
	}

	public String getVatType() {
		return vatType;
	}

	public void setVatType(String vatType) {
		this.vatType = vatType;
	}

	public BigDecimal getPayAmt() {
		return payAmt;
	}

	public void setPayAmt(BigDecimal payAmt) {
		this.payAmt = payAmt;
	}
	
	
	
	
}
