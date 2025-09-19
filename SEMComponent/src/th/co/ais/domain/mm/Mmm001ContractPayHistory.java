package th.co.ais.domain.mm;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mmm001ContractPayHistory extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7836272805128634271L;

	private Date contractPaymentDt;
	private String contractPaymentDtStr;
	private String invoiceNo;
	private String period;
	private String expenseType;
	private String vendorCode;
	private String vendorName;
	private String payeeId;
	private String payeeName;
	private String paymentType;
	private String bookbankNo;
	private String checkNo;
	private String periodType;
	private String periodY;
	private String periodM;
	private String periodD;
	private String totalPaymentAmg;
	private String vat;
	private String wht;
	private String docNoCancel;
	private String docNo;
	private String contractNo;
	private String historyPage;
	private String vendorId;
	private String bookbankId;
	private String bookbankPayeeId;
	
	
	public Date getContractPaymentDt() {
		return contractPaymentDt;
	}

	public void setContractPaymentDt(Date contractPaymentDt) {
		this.contractPaymentDt = contractPaymentDt;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
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

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getBookbankNo() {
		return bookbankNo;
	}

	public void setBookbankNo(String bookbankNo) {
		this.bookbankNo = bookbankNo;
	}

	public String getCheckNo() {
		return checkNo;
	}

	public void setCheckNo(String checkNo) {
		this.checkNo = checkNo;
	}

	public String getPeriodType() {
		return periodType;
	}

	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}

	public String getPeriodY() {
		return periodY;
	}

	public void setPeriodY(String periodY) {
		this.periodY = periodY;
	}

	public String getPeriodM() {
		return periodM;
	}

	public void setPeriodM(String periodM) {
		this.periodM = periodM;
	}

	public String getPeriodD() {
		return periodD;
	}

	public void setPeriodD(String periodD) {
		this.periodD = periodD;
	}

	public String getTotalPaymentAmg() {
		return totalPaymentAmg;
	}

	public void setTotalPaymentAmg(String totalPaymentAmg) {
		this.totalPaymentAmg = totalPaymentAmg;
	}

	public String getVat() {
		return vat;
	}

	public void setVat(String vat) {
		this.vat = vat;
	}

	public String getWht() {
		return wht;
	}

	public void setWht(String wht) {
		this.wht = wht;
	}

	public String getDocNoCancel() {
		return docNoCancel;
	}

	public void setDocNoCancel(String docNoCancel) {
		this.docNoCancel = docNoCancel;
	}

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getHistoryPage() {
		return historyPage;
	}

	public void setHistoryPage(String historyPage) {
		this.historyPage = historyPage;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getBookbankId() {
		return bookbankId;
	}

	public void setBookbankId(String bookbankId) {
		this.bookbankId = bookbankId;
	}

	public String getBookbankPayeeId() {
		return bookbankPayeeId;
	}

	public void setBookbankPayeeId(String bookbankPayeeId) {
		this.bookbankPayeeId = bookbankPayeeId;
	}

	public String getContractPaymentDtStr() {
		return contractPaymentDtStr;
	}

	public void setContractPaymentDtStr(String contractPaymentDtStr) {
		this.contractPaymentDtStr = contractPaymentDtStr;
	}

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

}
