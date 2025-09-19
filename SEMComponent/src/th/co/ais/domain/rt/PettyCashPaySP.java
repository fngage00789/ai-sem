package th.co.ais.domain.rt;

import java.math.BigDecimal;
import java.util.Date;
import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.annotation.PCell;
import th.co.ais.rpt.util.enums.EnumDocStyle;

public class PettyCashPaySP extends AbstractDomain {

	private String rowId;
	private Double requestAmt;
	private String vatTypeName;
	private String vatType;
	private Double vatRate;
	private Double vatAmt;
	private Double incRequestAmt;
	private Double excRequestAmt;
	private String receiptTaxFlag;
	//private String receiptTaxFlagName;
	private String clrReceiptTaxFlag;
	private String clrReceiptTaxFlagName;
	private Date requestDt;
	private Date effectiveDt;
	private Date expireDt;
	private String expenseType;
	private String expenseTypeName;
	private Date dueDt;
	private String pettyCashPayStatusName;
	private String remark;
	private String rentalPaymentId;
	private String recordStatus;
	private Long version;
	private String exportFlag;
	
	//properties for searching 
	private String company;
	private String pettyCashPayNo;
	private String region;
	private String requestName;
	private String requestType;
	private String requestSubject;
	private Date requestDtFrom;
	private Date requestDtTo;
	private String contractNo;
	private String siteName;
	private Date dueDtFrom;
	private Date dueDtTo;
	private String pettyCashPayStatus;
	private String category;
	
	//for update petty cash pay
	private String pettyCashPayIds;
	private String username;
	private String statusResult;
	
	private String refClrBatchNo;
	private String taxInvoiceNo;
	private Date taxInvoiceDt;
	private Date exportDt;
	
	// row on for excel
	private int no;
	private Double totalAmount;
	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getCompany() {
		return company;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@PCell(cellType = String.class, no = 1)
	public String getPettyCashPayNo() {
		return pettyCashPayNo;
	}
//	@PCell(cellType = String.class, no = 2)
	public String getRefClrBatchNo() {
		return refClrBatchNo;
	}
//	@PCell(cellType = Date.class, no = 3)
	public Date getExportDt() {
		return exportDt;
	}
	@PCell(cellType = String.class, no = 2)
	public String getRequestName() {
		return requestName;
	}
	@PCell(cellType = String.class, no = 3)
	public String getRequestSubject() {
		return requestSubject;
	}
	@PCell(cellType = Double.class, no = 4, styleName = EnumDocStyle.CELL_MONEY)
	public Double getRequestAmt() {
		return requestAmt;
	}
	@PCell(cellType = String.class, no = 5)
	public String getVatTypeName() {
		return vatTypeName;
	}
	@PCell(cellType = Double.class, no = 6, styleName = EnumDocStyle.CELL_MONEY)
	public Double getVatAmt() {
		return vatAmt;
	}
	@PCell(cellType = Double.class, no = 7, styleName = EnumDocStyle.CELL_MONEY)
	public Double getIncRequestAmt() {
		return incRequestAmt;
	}
	@PCell(cellType = String.class, no = 8)
	public String getTaxInvoiceNo() {
		return taxInvoiceNo;
	}
	@PCell(cellType = Date.class, no =9)
	public Date getTaxInvoiceDt() {
		return taxInvoiceDt;
	}
	@PCell(cellType = Date.class, no = 10)
	public Date getRequestDt() {
		return requestDt;
	}
	@PCell(cellType = String.class, no = 11)
	public String getContractNo() {
		return contractNo;
	}
	@PCell(cellType = String.class, no = 12)
	public String getSiteName() {
		return siteName;
	}
	@PCell(cellType = String.class, no = 13)
	public Date getEffectiveDt() {
		return effectiveDt;
	}
	@PCell(cellType = String.class, no = 14)
	public Date getExpireDt() {
		return expireDt;
	}
	@PCell(cellType = String.class, no = 15)
	public String getExpenseType() {
		return expenseType;
	}
	@PCell(cellType = String.class, no = 16)
	public Date getDueDt() {
		return dueDt;
	}
	@PCell(cellType = String.class, no = 17)
	public String getPettyCashPayStatusName() {
		return pettyCashPayStatusName;
	}
	public void setEffectiveDt(Date effectiveDt) {
		this.effectiveDt = effectiveDt;
	}
	public void setTaxInvoiceDt(Date taxInvoiceDt) {
		this.taxInvoiceDt = taxInvoiceDt;
	}
	public void setPettyCashPayNo(String pettyCashPayNo) {
		this.pettyCashPayNo = pettyCashPayNo;
	}
	
	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	
	public void setRequestSubject(String requestSubject) {
		this.requestSubject = requestSubject;
	}
	
	public void setRequestAmt(Double requestAmt) {
		this.requestAmt = requestAmt;
	}
	
	public void setVatTypeName(String vatTypeName) {
		this.vatTypeName = vatTypeName;
	}
	public String getVatType() {
		return vatType;
	}
	public void setVatType(String vatType) {
		this.vatType = vatType;
	}
	public Double getVatRate() {
		return vatRate;
	}
	public void setVatRate(Double vatRate) {
		this.vatRate = vatRate;
	}
	public void setVatAmt(Double vatAmt) {
		this.vatAmt = vatAmt;
	}
	public void setIncRequestAmt(Double incRequestAmt) {
		this.incRequestAmt = incRequestAmt;
	}
	public Double getExcRequestAmt() {
		return excRequestAmt;
	}
	public void setExcRequestAmt(Double excRequestAmt) {
		this.excRequestAmt = excRequestAmt;
	}
	public String getReceiptTaxFlag() {
		return receiptTaxFlag;
	}
	public void setReceiptTaxFlag(String receiptTaxFlag) {
		this.receiptTaxFlag = receiptTaxFlag;
	}
//	public String getReceiptTaxFlagName() {
//		return receiptTaxFlagName;
//	}
//	public void setReceiptTaxFlagName(String receiptTaxFlagName) {
//		this.receiptTaxFlagName = receiptTaxFlagName;
//	}
	public String getClrReceiptTaxFlag() {
		return clrReceiptTaxFlag;
	}
	public void setClrReceiptTaxFlag(String clrReceiptTaxFlag) {
		this.clrReceiptTaxFlag = clrReceiptTaxFlag;
	}
	public String getClrReceiptTaxFlagName() {
		return clrReceiptTaxFlagName;
	}
	public void setClrReceiptTaxFlagName(String clrReceiptTaxFlagName) {
		this.clrReceiptTaxFlagName = clrReceiptTaxFlagName;
	}
	
	public void setRequestDt(Date requestDt) {
		this.requestDt = requestDt;
	}
	
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public void setExpireDt(Date expireDt) {
		this.expireDt = expireDt;
	}
	
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getExpenseTypeName() {
		return expenseTypeName;
	}
	public void setExpenseTypeName(String expenseTypeName) {
		this.expenseTypeName = expenseTypeName;
	}
	
	public void setDueDt(Date dueDt) {
		this.dueDt = dueDt;
	}
	public String getPettyCashPayStatus() {
		return pettyCashPayStatus;
	}
	public void setPettyCashPayStatus(String pettyCashPayStatus) {
		this.pettyCashPayStatus = pettyCashPayStatus;
	}
	public void setPettyCashPayStatusName(String pettyCashPayStatusName) {
		this.pettyCashPayStatusName = pettyCashPayStatusName;
	}
	public Date getRequestDtFrom() {
		return requestDtFrom;
	}
	public void setRequestDtFrom(Date requestDtFrom) {
		this.requestDtFrom = requestDtFrom;
	}
	public Date getRequestDtTo() {
		return requestDtTo;
	}
	public void setRequestDtTo(Date requestDtTo) {
		this.requestDtTo = requestDtTo;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRentalPaymentId() {
		return rentalPaymentId;
	}
	public void setRentalPaymentId(String rentalPaymentId) {
		this.rentalPaymentId = rentalPaymentId;
	}
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	
	public String getPettyCashPayIds() {
		return pettyCashPayIds;
	}
	public void setPettyCashPayIds(String pettyCashPayIds) {
		this.pettyCashPayIds = pettyCashPayIds;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStatusResult() {
		return statusResult;
	}
	public void setStatusResult(String statusResult) {
		this.statusResult = statusResult;
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
	public void setRefClrBatchNo(String refClrBatchNo) {
		this.refClrBatchNo = refClrBatchNo;
	}
	
	public void setTaxInvoiceNo(String taxInvoiceNo) {
		this.taxInvoiceNo = taxInvoiceNo;
	}
	
	public void setExportDt(Date exportDt) {
		this.exportDt = exportDt;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@PCell(cellType = String.class, no = 0)
	public String getStringNo() {
		return no + "";
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getExportFlag() {
		return exportFlag;
	}
	public void setExportFlag(String exportFlag) {
		this.exportFlag = exportFlag;
	}
	
	
}
