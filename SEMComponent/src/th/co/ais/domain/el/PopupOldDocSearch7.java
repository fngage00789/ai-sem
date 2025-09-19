package th.co.ais.domain.el;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;


@org.hibernate.annotations.NamedNativeQuery(
    name="querySearchELOldDoc7",  
    query="call SEM_PG_EL_VENDOR_PAYEE_SP_REFER_DOC_SRCH(?,:company, :electricUseType,:expenseType, :docNo," +
    		                                             ":fromDocDt,:toDocDt,:meterId,:fromTermOfPaymentDt,:toTermOfPaymentDt,:contractNo)",   
    callable = true, readOnly = true,
    resultClass=PopupOldDocSearch7.class 
)  


@Entity 
public class PopupOldDocSearch7 implements Serializable{
	private static final long serialVersionUID = 1137928449676053552L;	
	private static final SimpleDateFormat exportFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
	
	
	/*  In parameter
	P_IN_COMPANY IN VARCHAR2,
	P_IN_ELECTRIC_USE_TYPE IN VARCHAR2,
	P_IN_EXPENSE_TYPE IN VARCHAR2,
	P_IN_DOC_NO IN VARCHAR2,
	P_IN_FROM_DOC_DT IN DATE,
	P_IN_TO_DOC_DT IN DATE,
	P_IN_METER_ID IN VARCHAR2,
	P_IN_FROM_TERM_OF_PAYMENT_DT IN DATE,
	P_IN_TO_TERM_OF_PAYMENT_DT IN DATE

	 */
	
	@Id
	@Column(name = "PAYMENT_ID")	
	private String paymentID;
	
	@Column(name = "DOC_NO")	
	private String docNo;
	
	@Column(name = "DOC_DT")
	private Date docDt;
	
	@Column(name = "METER_ID")
	private String meterId;		
	
	@Column(name = "REFER_METER_ID")
	private String refMeterId;
	
	@Column(name = "TREM_OF_PAYMENT_DT")
	private Date termOfPaymentDt;
	
	@Column(name = "METER_INFO_ID")
	private String meterInfoId;	
	
	@Column(name = "VENDOR_ID")
	private String vendorId;	
	
	@Column(name = "VENDOR_NAME")
	private String vendorName;	
	
	@Column(name = "PAYEE_ID")
	private String payeeId;	
	
	@Column(name = "PAYEE_NAME")
	private String payeeName;	
	
	
	@Column(name = "FROM_TERM_OF_PAYMENT_DT")
	private Date outFromTermOfPaymentDt;
	
	@Column(name = "TO_TERM_OF_PAYMENT_DT")
	private Date outToTermOfPaymentDt;
	
	@Transient
	private String company;	
	
	@Transient
	private String electricUseType;
	
	@Transient
	private String electricUseTypeDisplay;
	
	@Transient
	private String expenseType;	
	
	@Transient
	private Date fromTermOfPaymentDt;
	
	@Transient
	private Date toTermOfPaymentDt;

	@Transient
	private Date fromDocDt;
	
	@Transient
	private Date toDocDt;
	
	@Transient
	private boolean checkBoxSelected;
	
	@Transient
	private String contractNo;
	
	
	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public Date getFromDocDt() {
		return fromDocDt;
	}

	public void setFromDocDt(Date fromDocDt) {
		this.fromDocDt = fromDocDt;
	}

	public Date getToDocDt() {
		return toDocDt;
	}

	public void setToDocDt(Date toDocDt) {
		this.toDocDt = toDocDt;
	}

	public String getElectricUseType() {
		return electricUseType;
	}

	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getMeterId() {
		return meterId;
	}

	public void setMeterId(String meterId) {
		this.meterId = meterId;
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

	public static SimpleDateFormat getExportformat() {
		return exportFormat;
	}

	public String getElectricUseTypeDisplay() {
		return electricUseTypeDisplay;
	}

	public void setElectricUseTypeDisplay(String electricUseTypeDisplay) {
		this.electricUseTypeDisplay = electricUseTypeDisplay;
	}

	public String getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}

	public Date getDocDt() {
		return docDt;
	}

	public void setDocDt(Date docDt) {
		docDt = docDt;
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

	public boolean isCheckBoxSelected() {
		return checkBoxSelected;
	}

	public void setCheckBoxSelected(boolean checkBoxSelected) {
		this.checkBoxSelected = checkBoxSelected;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contract) {
		this.contractNo = contract;
	}

	public String getMeterInfoId() {
		return meterInfoId;
	}

	public void setMeterInfoId(String meterInfoId) {
		this.meterInfoId = meterInfoId;
	}	
	
	@Transient
	public String gettermOfPaymentDtTH() {
		return termOfPaymentDt!=null?exportFormat.format(termOfPaymentDt):"";
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getPayeeId() {
		return payeeId;
	}

	public void setPayeeId(String payeeId) {
		this.payeeId = payeeId;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public Date getOutFromTermOfPaymentDt() {
		return outFromTermOfPaymentDt;
	}

	public void setOutFromTermOfPaymentDt(Date outFromTermOfPaymentDt) {
		this.outFromTermOfPaymentDt = outFromTermOfPaymentDt;
	}
    
	@Transient
	public String getOutFromTermOfPaymentDtTH() {
		return outFromTermOfPaymentDt!=null?exportFormat.format(outFromTermOfPaymentDt):"";
	}
	
	public Date getOutToTermOfPaymentDt() {
		return outToTermOfPaymentDt;
	}

	public void setOutToTermOfPaymentDt(Date outToTermOfPaymentDt) {
		this.outToTermOfPaymentDt = outToTermOfPaymentDt;
	}
	@Transient
	public String getOutToTermOfPaymentDtTH() {
		return outToTermOfPaymentDt!=null?exportFormat.format(outToTermOfPaymentDt):"";
	}
	
}
