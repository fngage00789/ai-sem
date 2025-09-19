package th.co.ais.domain.ac;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mac001Srch extends AbstractDomain{

	private boolean selected;
	private String rowId;
	private String paymentGroupNo;
	private String paymentDocNo;
	private String expenseType;
	private String contractNo;
	private String siteStatus;
	private String networkStatus;
	private String pmsStatus;
	private String invoiceNo;
	private Double totalAmt;
	private Double payAmt;
	private Integer jobDay;
	private String paymentStatus;
	private Date chqDt;
	private Date chqReceiveDt;
	
	private String company;
	private Date paymentDtFrom;
	private Date paymentDtTo;
	private Date chqReceiveDtFrom;
	private Date chqReceiveDtTo;
	private Date transferDtFrom;
	private Date transferDtTo;
	private String policyNo;
	private String paymentDocType;
	private String vendorCode;
	private String vendorName;
	private String siteName;
	private String moduleType;
	private String paymentType;
	private String paymentMethod;
	
	private boolean renderCheckBox;
	
	private String siteInfoId;
	private String paymentBatchNo;
	private String paymentDocnoSrch;
	
	private String periodNo;
	private Date periodStartDt;
	private Date periodEndDt;
	private String preContractNo;
	private String preSiteInfoId;
	private String paymentStatusDesc;
	private String fileName;
	
	private boolean renderedLinkPrecontract;
	private boolean renderedLinkSap;
	private boolean renderedPaymentStatusDesc;
	private String reqType;
	
	private Double chequeAmt = 0.00d;
	private Double whtAmt = 0.00d;
	
	private String expenseDesc;
	
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
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
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
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getContractNo() {
		return contractNo;
	}
	public Date getChqReceiveDt() {
		return chqReceiveDt;
	}
	public void setChqReceiveDt(Date chqReceiveDt) {
		this.chqReceiveDt = chqReceiveDt;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getSiteStatus() {
		return siteStatus;
	}
	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}
	public String getNetworkStatus() {
		return networkStatus;
	}
	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
	}
	public String getPmsStatus() {
		return pmsStatus;
	}
	public void setPmsStatus(String pmsStatus) {
		this.pmsStatus = pmsStatus;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public Double getTotalAmt() {
		return totalAmt;
	}
	public String getModuleType() {
		return moduleType;
	}
	public void setModuleType(String moduleType) {
		this.moduleType = moduleType;
	}
	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}
	public Double getPayAmt() {
		return payAmt;
	}
	public void setPayAmt(Double payAmt) {
		this.payAmt = payAmt;
	}
	public Integer getJobDay() {
		return jobDay;
	}
	public void setJobDay(Integer jobDay) {
		this.jobDay = jobDay;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Date getChqDt() {
		return chqDt;
	}
	public void setChqDt(Date chqDt) {
		this.chqDt = chqDt;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Date getPaymentDtFrom() {
		return paymentDtFrom;
	}
	public void setPaymentDtFrom(Date paymentDtFrom) {
		this.paymentDtFrom = paymentDtFrom;
	}
	public Date getPaymentDtTo() {
		return paymentDtTo;
	}
	public void setPaymentDtTo(Date paymentDtTo) {
		this.paymentDtTo = paymentDtTo;
	}
	public Date getChqReceiveDtFrom() {
		return chqReceiveDtFrom;
	}
	public void setChqReceiveDtFrom(Date chqReceiveDtFrom) {
		this.chqReceiveDtFrom = chqReceiveDtFrom;
	}
	public Date getChqReceiveDtTo() {
		return chqReceiveDtTo;
	}
	public void setChqReceiveDtTo(Date chqReceiveDtTo) {
		this.chqReceiveDtTo = chqReceiveDtTo;
	}
	public Date getTransferDtFrom() {
		return transferDtFrom;
	}
	public void setTransferDtFrom(Date transferDtFrom) {
		this.transferDtFrom = transferDtFrom;
	}
	public Date getTransferDtTo() {
		return transferDtTo;
	}
	public void setTransferDtTo(Date transferDtTo) {
		this.transferDtTo = transferDtTo;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getPaymentDocType() {
		return paymentDocType;
	}
	public void setPaymentDocType(String paymentDocType) {
		this.paymentDocType = paymentDocType;
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
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setRenderCheckBox(boolean renderCheckBox) {
		this.renderCheckBox = renderCheckBox;
	}
	public boolean isRenderCheckBox() {
		return renderCheckBox;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setPaymentBatchNo(String paymentBatchNo) {
		this.paymentBatchNo = paymentBatchNo;
	}
	public String getPaymentBatchNo() {
		return paymentBatchNo;
	}
	public void setPaymentDocnoSrch(String paymentDocnoSrch) {
		this.paymentDocnoSrch = paymentDocnoSrch;
	}
	public String getPaymentDocnoSrch() {
		return paymentDocnoSrch;
	}
	public String getPeriodNo() {
		return periodNo;
	}
	public void setPeriodNo(String periodNo) {
		this.periodNo = periodNo;
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
	public String getPreContractNo() {
		return preContractNo;
	}
	public void setPreContractNo(String preContractNo) {
		this.preContractNo = preContractNo;
	}
	public String getPreSiteInfoId() {
		return preSiteInfoId;
	}
	public void setPreSiteInfoId(String preSiteInfoId) {
		this.preSiteInfoId = preSiteInfoId;
	}
	public String getPaymentStatusDesc() {
		return paymentStatusDesc;
	}
	public void setPaymentStatusDesc(String paymentStatusDesc) {
		this.paymentStatusDesc = paymentStatusDesc;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setRenderedLinkPrecontract(boolean renderedLinkPrecontract) {
		this.renderedLinkPrecontract = renderedLinkPrecontract;
	}
	public boolean isRenderedLinkPrecontract() {
		return renderedLinkPrecontract;
	}
	public void setRenderedLinkSap(boolean renderedLinkSap) {
		this.renderedLinkSap = renderedLinkSap;
	}
	public boolean isRenderedLinkSap() {
		return renderedLinkSap;
	}
	/**
	 * @param renderedPaymentStatusDesc the renderedPaymentStatusDesc to set
	 */
	public void setRenderedPaymentStatusDesc(boolean renderedPaymentStatusDesc) {
		this.renderedPaymentStatusDesc = renderedPaymentStatusDesc;
	}
	/**
	 * @return the renderedPaymentStatusDesc
	 */
	public boolean isRenderedPaymentStatusDesc() {
		return renderedPaymentStatusDesc;
	}
	public String getReqType() {
		return reqType;
	}
	public void setReqType(String reqType) {
		this.reqType = reqType;
	}
	public Double getChequeAmt() {
		return chequeAmt;
	}
	public void setChequeAmt(Double chequeAmt) {
		this.chequeAmt = chequeAmt;
	}
	public Double getWhtAmt() {
		return whtAmt;
	}
	public void setWhtAmt(Double whtAmt) {
		this.whtAmt = whtAmt;
	}
	public String getExpenseDesc() {
		return expenseDesc;
	}
	public void setExpenseDesc(String expenseDesc) {
		this.expenseDesc = expenseDesc;
	}
	
	
}
