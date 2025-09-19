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
    name="installmentDataDetail",  
    query="call SEM_PG_EL_VALIDATE_PAYMENT_SP_GET_PREVIOUS_DATA(?,:meterInfoId, :termOfPaymentDt)",   
    callable = true, readOnly = true,
    resultClass=InstallmentDataDetail.class 
)  


@Entity 
public class InstallmentDataDetail implements Serializable{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 8598242428046637386L;
	private static final SimpleDateFormat exportFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
	
	
	/*  In parameter
	
	 */
	
	@Id
	@Column(name = "ID")	
	private String id;
	
	@Column(name = "L_DATE")	
	private Date lDate;
	
	@Column(name = "L_READ")	
	private BigDecimal lread;
	
	@Column(name = "UNIT_PRICE")
	private BigDecimal unitPrice;
	
	@Column(name = "UNIT_VAT_TYPE")
	private String unitVatType;		
	
	
	@Transient
	private String meterInfoId;	
	
	@Transient
	private Date termOfPaymentDt ;

	
	public Date getlDate() {
		return lDate;
	}

	public void setlDate(Date lDate) {
		this.lDate = lDate;
	}

	public BigDecimal getLread() {
		return lread;
	}

	public void setLread(BigDecimal lread) {
		this.lread = lread;
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

	public String getMeterInfoId() {
		return meterInfoId;
	}

	public void setMeterInfoId(String meterInfoId) {
		this.meterInfoId = meterInfoId;
	}

	public Date getTermOfPaymentDt() {
		return termOfPaymentDt;
	}

	public void setTermOfPaymentDt(Date termOfPaymentDt) {
		this.termOfPaymentDt = termOfPaymentDt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
	
	
}
