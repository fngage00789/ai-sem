package th.co.ais.domain.ac;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mac004Srch extends AbstractDomain{

	private String company;
	private String moduleType;
	private String expenseType;
	private String contractNo;
	private String siteName;
	private String vendorCode;
	private String vendorName;
	private String docNo;
	private String paymentBatchNo;
	private String paymentDocNo;
	
	private String transPaymentId;
	private String paymentGroupNo;
	private String periodNo;
	private Date periodStartDt;
	private Date periodEndDt;
	private String siteInfoId;
	private String preSiteContracNo;
	private String preSiteInfoId;
	private String siteStatus;
	private String networkStatus;
	private String pmsStatus;
	private Double totalAmt;
	private Double payAmt;
	private Integer jobDay;
	private String paymentStatus;
	private String paymentStatusDesc;
	private Date chqDt;
	private Date chqReceiveDt;
	
	private String payeeName;
	private String bankAccNo;
	private Double payVatAmt;
	private Double payWhtAmt;
	private Double payDutyAmt;
	private String paymentType;
	private String paymentMethod;
	private Date transferDt;
	
	private boolean renderedBtnManual;
	private boolean renderedLinkPrecontract;
	private boolean renderedLinkSap;
	private boolean renderedPaymentStatusDesc;
	
	private String refSem;
	
	private String doc68;
	private Date doc68Dt;
	private Date doc68DtDisplay;
	private String docPayment;
	private Date docPaymentDt;
	private Date docPaymentDtDisplay;
	private String docCancel;
	private Date docCancelDt;
	private Date docCancelDtDisplay;
	private String docStatus;
	private String remark;
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getModuleType() {
		return moduleType;
	}
	public void setModuleType(String moduleType) {
		this.moduleType = moduleType;
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
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public String getPaymentBatchNo() {
		return paymentBatchNo;
	}
	public void setPaymentBatchNo(String paymentBatchNo) {
		this.paymentBatchNo = paymentBatchNo;
	}
	public String getPaymentDocNo() {
		return paymentDocNo;
	}
	public void setPaymentDocNo(String paymentDocNo) {
		this.paymentDocNo = paymentDocNo;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public String getBankAccNo() {
		return bankAccNo;
	}
	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}
	public Double getPayVatAmt() {
		return payVatAmt;
	}
	public void setPayVatAmt(Double payVatAmt) {
		this.payVatAmt = payVatAmt;
	}
	public Double getPayWhtAmt() {
		return payWhtAmt;
	}
	public void setPayWhtAmt(Double payWhtAmt) {
		this.payWhtAmt = payWhtAmt;
	}
	public Double getPayDutyAmt() {
		return payDutyAmt;
	}
	public void setPayDutyAmt(Double payDutyAmt) {
		this.payDutyAmt = payDutyAmt;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public Date getTransferDt() {
		return transferDt;
	}
	public void setTransferDt(Date transferDt) {
		this.transferDt = transferDt;
	}
	public String getTransPaymentId() {
		return transPaymentId;
	}
	public void setTransPaymentId(String transPaymentId) {
		this.transPaymentId = transPaymentId;
	}
	public String getPaymentGroupNo() {
		return paymentGroupNo;
	}
	public void setPaymentGroupNo(String paymentGroupNo) {
		this.paymentGroupNo = paymentGroupNo;
	}
	public String getPeriodNo() {
		return periodNo;
	}
	public void setPeriodNo(String periodNo) {
		this.periodNo = periodNo;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public String getPreSiteContracNo() {
		return preSiteContracNo;
	}
	public void setPreSiteContracNo(String preSiteContracNo) {
		this.preSiteContracNo = preSiteContracNo;
	}
	public String getPreSiteInfoId() {
		return preSiteInfoId;
	}
	public void setPreSiteInfoId(String preSiteInfoId) {
		this.preSiteInfoId = preSiteInfoId;
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
	public Double getTotalAmt() {
		return totalAmt;
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
	public String getPaymentStatusDesc() {
		return paymentStatusDesc;
	}
	public void setPaymentStatusDesc(String paymentStatusDesc) {
		this.paymentStatusDesc = paymentStatusDesc;
	}
	public Date getChqDt() {
		return chqDt;
	}
	public void setChqDt(Date chqDt) {
		this.chqDt = chqDt;
	}
	public Date getChqReceiveDt() {
		return chqReceiveDt;
	}
	public void setChqReceiveDt(Date chqReceiveDt) {
		this.chqReceiveDt = chqReceiveDt;
	}
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	public String getVendorCode() {
		return vendorCode;
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
	public boolean isRenderedBtnManual() {
		return renderedBtnManual;
	}
	public void setRenderedBtnManual(boolean renderedBtnManual) {
		this.renderedBtnManual = renderedBtnManual;
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
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public String getDoc68() {
		return doc68;
	}
	public void setDoc68(String doc68) {
		this.doc68 = doc68;
	}
	public Date getDoc68Dt() {
		return doc68Dt;
	}
	public void setDoc68Dt(Date doc68Dt) {
		this.doc68Dt = doc68Dt;
	}
	
	public String getRefSem() {
		return refSem;
	}
	public void setRefSem(String refSem) {
		this.refSem = refSem;
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
	public String getDocPayment() {
		return docPayment;
	}
	public void setDocPayment(String docPayment) {
		this.docPayment = docPayment;
	}
	public Date getDocPaymentDt() {
		return docPaymentDt;
	}
	public void setDocPaymentDt(Date docPaymentDt) {
		this.docPaymentDt = docPaymentDt;
	}
	public String getDocCancel() {
		return docCancel;
	}
	public void setDocCancel(String docCancel) {
		this.docCancel = docCancel;
	}
	public Date getDocCancelDt() {
		return docCancelDt;
	}
	public void setDocCancelDt(Date docCancelDt) {
		this.docCancelDt = docCancelDt;
	}
	public Date getDoc68DtDisplay() {
		return doc68DtDisplay;
	}
	public void setDoc68DtDisplay(Date doc68DtDisplay) {
		this.doc68DtDisplay = doc68DtDisplay;
	}
	public Date getDocPaymentDtDisplay() {
		return docPaymentDtDisplay;
	}
	public void setDocPaymentDtDisplay(Date docPaymentDtDisplay) {
		this.docPaymentDtDisplay = docPaymentDtDisplay;
	}
	public Date getDocCancelDtDisplay() {
		return docCancelDtDisplay;
	}
	public void setDocCancelDtDisplay(Date docCancelDtDisplay) {
		this.docCancelDtDisplay = docCancelDtDisplay;
	}
	public String getDocStatus() {
		return docStatus;
	}
	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
