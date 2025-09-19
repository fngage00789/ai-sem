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

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@NamedNativeQueries({
	@NamedNativeQuery(   name="searchInstallment",     
			query="call SEM_PG_EL_SITE_INFO_PROCESS_SEM_GET_OUT_PAYMENT_DETAIL(?, :company,:region,:electricUseType,:fromDt,:toDt )",    
			callable = true, readOnly = true,    
			resultClass=PopupSiteSearchInstallment.class ),
	
			
})
@Entity 
public class PopupSiteSearchInstallment implements Serializable{
	private static final long serialVersionUID = 1137928449676053552L;
	private static final SimpleDateFormat exportFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
	

	@Id
	@Column(name = "METER_INSTALLMENT_ID")	
	private String meterInstallmentId;

	@Column(name = "CONTRACT_NO")		
	private String contractNo;
	
	@Column(name = "SITE_NAME")
	private String siteName;
	
	@Column(name = "METER_ID")
	private String meterId;
	
	@Column(name = "REFER_METER_ID")
	private String refMeterId;
	
	
	@Column(name = "TERM_OF_PAYMENT_DT")	
	private Date termOfPaymentDt;
	
	@Column(name = "ACCRUE_AMT")
	private BigDecimal accureAmt;

	public String getMeterInstallmentId() {
		return meterInstallmentId;
	}

	public void setMeterInstallmentId(String meterInstallmentId) {
		this.meterInstallmentId = meterInstallmentId;
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

	public BigDecimal getAccureAmt() {
		return accureAmt;
	}

	public void setAccureAmt(BigDecimal accureAmt) {
		this.accureAmt = accureAmt;
	}
	
	
	
}
