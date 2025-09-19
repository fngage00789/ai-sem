package th.co.ais.domain.mm;

import java.math.BigDecimal;
import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mmm001VendorPayHistSP extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 506895897495291972L;

	private String company;
	private String rowId;
	private String paymentGroupNo;
	private String contractNo;
	private String siteName;
	private Date effDt;
	private Date expDt;
	private Date dueDt;
	private String effDtStr;
	private String expDtStr;
	private String dueDtStr;
	private Integer periodNo;
	private String expenseType;
	private String expenseTypeDesc;
	private String vendorCode;
	private String vendorName;
	private String payeeId;
	private String payeeName;
	private String payPeriodType;
	private Integer periodY;
	private Integer periodM;
	private Integer periodD;
	private Double dueAmt;
	private Double vatAmt;
	private Double whtRate;
	private Double whtAmt;
	private Double chqAmt;
	private String siteStatus;
	private String networkStatus;
	private String expStatus;
	private String expApprove;
	private Date paymentRequestDt;
	private String paymentRequestDtStr;
	private String paymentStatus;
	private String paymentType;
	private String bankName;
	private Date chqDt;
	private Date chqReceiveDt;
	private Date transferDt;
	private String chqDtStr;
	private String chqReceiveDtStr;
	private String transferDtStr;
	private Double depositAmt;
	private Double pettyAmt;
	private Double totalAmt;
	private String bankAccNo;
	private String remark;
	private String paymentDocno;
	private String whtType;
	private String paymentTypeDesc;
	private String paymentStatusDesc;
	private String vendorMasterId;
	private String paymentMethod;
	private String whtTypeDesc;
	private String siteInfoId;
	private Double excAmt;
	private String paymentBatchNo;
	private String oldContractNo;
	private String oldSiteInfoId;
	private String statusPay;
	private String docSettingDebt;
	private String docCuttingDebt;
	private String docCancel;
	private String payPeriod;
	private String remarkVerify;
	private String remarkPending;
	private String remarkOther;
	private String reqType;
	private String rentalDetailId;
	private Double rcptPayCutAmount;
	private String sendInfoStatus;
	private String pmsStatus;
	
	private String vendorId;
	private String batchNo;
	private String doc68;
	private String doc92;
	private Date createDate;
	private String createDateStr;
	private String siteStatusShow;
	private String netWorkStatus;
	private String netWorkStatusShow;
	private String expenseTypeShow;
	private String paymentStatusShow;
	private String docType;
	private String docTypeShow;
	private String docNo;
	private Date docDt;
	private String docDtStr;
	private BigDecimal payAmt;
	private String vatType;
	private BigDecimal excludeVatAmt;
	private BigDecimal vatElAmt;
	private BigDecimal includeVatAmt;
	private BigDecimal whtElAmt;
	private BigDecimal chqElAmt;
	private String paymentTypeShow;
	private String paymentMethodShow;
	private String bankAccount;
	private Date chqPostingDt;
	private Date chqReceivedDt;
	private String chqPostingDtStr;
	private String chqReceivedDtStr;
	private String rejectReason;
	private String chqNo;
	private Date chqClearingDt;
	private String chqClearingDtStr;
	private String doc69;
	private String payment_channel;
	private String collectiveDbNo;
	private String paymentId;
	
	private String siteContructId;
	private String siteApproveId;
	private String reqId;
	private String locationId;
	private String siteConstructStatus;
	private String siteConstructStatusName;
	private String supplierName;
	private String conPermissionDocNo;
	private String conBuildDocNo;
	private String constructType;
	private String constructTypeName;
	private String constructStatus;
	private String constructStatusName;
	private String conBillNo;
	private String conBillPayStatus;
	private String conBillPayStatusName;
	private String companyCri;
	private String siteStatusName;
	private String flowStatus;
	private String totSendDocNo;
	private String totRefDocNo;
	private String siteAmphurId;
	private String siteProvinceId;
	private String editableFlag;
	private String migrateFlag;
	private String contractId;
	private String terminateFlag;
	
	private Integer pTaxYear;
	private Double diffAmt;
	private String exportFlag;
	private Date exportDt;
	private String exportDtStr;
	private String paymentDocNo;
	private String region;
	private String docTypeDesc;
	private String paymentStatusId;
	private String diffRemark;
	
	
	private String networkType;
	private String networkTypeDesc;
	private String transferType;
	private String transferTypeDesc;
	private String policyType;
	private String policyTypeDesc;
	private String policyNo;
	private Date dueDtFrom;
	private String dueDtFromStr;
	private Double dutyAmt;
	private Double totalPayAmt;
	private String invoiceNo;
	private Date paymentDt;
	private String paymentDtStr;
	private String paymentMethodDesc;
	private String updateBy;
	private Date updateDt;
	private String updateDtStr;
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
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

	public Date getEffDt() {
		return effDt;
	}

	public void setEffDt(Date effDt) {
		this.effDt = effDt;
	}

	public Date getExpDt() {
		return expDt;
	}

	public void setExpDt(Date expDt) {
		this.expDt = expDt;
	}

	public Date getDueDt() {
		return dueDt;
	}

	public void setDueDt(Date dueDt) {
		this.dueDt = dueDt;
	}

	public Integer getPeriodNo() {
		return periodNo;
	}

	public void setPeriodNo(Integer periodNo) {
		this.periodNo = periodNo;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getExpenseTypeDesc() {
		return expenseTypeDesc;
	}

	public void setExpenseTypeDesc(String expenseTypeDesc) {
		this.expenseTypeDesc = expenseTypeDesc;
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

	public String getPayPeriodType() {
		return payPeriodType;
	}

	public void setPayPeriodType(String payPeriodType) {
		this.payPeriodType = payPeriodType;
	}

	public Integer getPeriodY() {
		return periodY;
	}

	public void setPeriodY(Integer periodY) {
		this.periodY = periodY;
	}

	public Integer getPeriodM() {
		return periodM;
	}

	public void setPeriodM(Integer periodM) {
		this.periodM = periodM;
	}

	public Integer getPeriodD() {
		return periodD;
	}

	public void setPeriodD(Integer periodD) {
		this.periodD = periodD;
	}

	public Double getDueAmt() {
		return dueAmt;
	}

	public void setDueAmt(Double dueAmt) {
		this.dueAmt = dueAmt;
	}

	public Double getVatAmt() {
		return vatAmt;
	}

	public void setVatAmt(Double vatAmt) {
		this.vatAmt = vatAmt;
	}

	public Double getWhtRate() {
		return whtRate;
	}

	public void setWhtRate(Double whtRate) {
		this.whtRate = whtRate;
	}

	public Double getWhtAmt() {
		return whtAmt;
	}

	public void setWhtAmt(Double whtAmt) {
		this.whtAmt = whtAmt;
	}

	public Double getChqAmt() {
		return chqAmt;
	}

	public void setChqAmt(Double chqAmt) {
		this.chqAmt = chqAmt;
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

	public String getExpStatus() {
		return expStatus;
	}

	public void setExpStatus(String expStatus) {
		this.expStatus = expStatus;
	}

	public String getExpApprove() {
		return expApprove;
	}

	public void setExpApprove(String expApprove) {
		this.expApprove = expApprove;
	}

	public Date getPaymentRequestDt() {
		return paymentRequestDt;
	}

	public void setPaymentRequestDt(Date paymentRequestDt) {
		this.paymentRequestDt = paymentRequestDt;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
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

	public Date getTransferDt() {
		return transferDt;
	}

	public void setTransferDt(Date transferDt) {
		this.transferDt = transferDt;
	}

	public Double getDepositAmt() {
		return depositAmt;
	}

	public void setDepositAmt(Double depositAmt) {
		this.depositAmt = depositAmt;
	}

	public Double getPettyAmt() {
		return pettyAmt;
	}

	public void setPettyAmt(Double pettyAmt) {
		this.pettyAmt = pettyAmt;
	}

	public Double getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}

	public String getBankAccNo() {
		return bankAccNo;
	}

	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPaymentDocno() {
		return paymentDocno;
	}

	public void setPaymentDocno(String paymentDocno) {
		this.paymentDocno = paymentDocno;
	}

	public String getWhtType() {
		return whtType;
	}

	public void setWhtType(String whtType) {
		this.whtType = whtType;
	}

	public String getPaymentTypeDesc() {
		return paymentTypeDesc;
	}

	public void setPaymentTypeDesc(String paymentTypeDesc) {
		this.paymentTypeDesc = paymentTypeDesc;
	}

	public String getPaymentStatusDesc() {
		return paymentStatusDesc;
	}

	public void setPaymentStatusDesc(String paymentStatusDesc) {
		this.paymentStatusDesc = paymentStatusDesc;
	}

	public String getVendorMasterId() {
		return vendorMasterId;
	}

	public void setVendorMasterId(String vendorMasterId) {
		this.vendorMasterId = vendorMasterId;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getWhtTypeDesc() {
		return whtTypeDesc;
	}

	public void setWhtTypeDesc(String whtTypeDesc) {
		this.whtTypeDesc = whtTypeDesc;
	}

	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	public Double getExcAmt() {
		return excAmt;
	}

	public void setExcAmt(Double excAmt) {
		this.excAmt = excAmt;
	}

	public String getPaymentBatchNo() {
		return paymentBatchNo;
	}

	public void setPaymentBatchNo(String paymentBatchNo) {
		this.paymentBatchNo = paymentBatchNo;
	}

	public String getOldContractNo() {
		return oldContractNo;
	}

	public void setOldContractNo(String oldContractNo) {
		this.oldContractNo = oldContractNo;
	}

	public String getOldSiteInfoId() {
		return oldSiteInfoId;
	}

	public void setOldSiteInfoId(String oldSiteInfoId) {
		this.oldSiteInfoId = oldSiteInfoId;
	}

	public String getStatusPay() {
		return statusPay;
	}

	public void setStatusPay(String statusPay) {
		this.statusPay = statusPay;
	}

	public String getDocSettingDebt() {
		return docSettingDebt;
	}

	public void setDocSettingDebt(String docSettingDebt) {
		this.docSettingDebt = docSettingDebt;
	}

	public String getDocCuttingDebt() {
		return docCuttingDebt;
	}

	public void setDocCuttingDebt(String docCuttingDebt) {
		this.docCuttingDebt = docCuttingDebt;
	}

	public String getDocCancel() {
		return docCancel;
	}

	public void setDocCancel(String docCancel) {
		this.docCancel = docCancel;
	}

	public String getPayPeriod() {
		return payPeriod;
	}

	public void setPayPeriod(String payPeriod) {
		this.payPeriod = payPeriod;
	}

	public String getRemarkVerify() {
		return remarkVerify;
	}

	public void setRemarkVerify(String remarkVerify) {
		this.remarkVerify = remarkVerify;
	}

	public String getRemarkPending() {
		return remarkPending;
	}

	public void setRemarkPending(String remarkPending) {
		this.remarkPending = remarkPending;
	}

	public String getRemarkOther() {
		return remarkOther;
	}

	public void setRemarkOther(String remarkOther) {
		this.remarkOther = remarkOther;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public String getRentalDetailId() {
		return rentalDetailId;
	}

	public void setRentalDetailId(String rentalDetailId) {
		this.rentalDetailId = rentalDetailId;
	}

	public Double getRcptPayCutAmount() {
		return rcptPayCutAmount;
	}

	public void setRcptPayCutAmount(Double rcptPayCutAmount) {
		this.rcptPayCutAmount = rcptPayCutAmount;
	}

	public String getSendInfoStatus() {
		return sendInfoStatus;
	}

	public void setSendInfoStatus(String sendInfoStatus) {
		this.sendInfoStatus = sendInfoStatus;
	}

	public String getPmsStatus() {
		return pmsStatus;
	}

	public void setPmsStatus(String pmsStatus) {
		this.pmsStatus = pmsStatus;
	}
	
	

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getDoc68() {
		return doc68;
	}

	public void setDoc68(String doc68) {
		this.doc68 = doc68;
	}

	public String getDoc92() {
		return doc92;
	}

	public void setDoc92(String doc92) {
		this.doc92 = doc92;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getSiteStatusShow() {
		return siteStatusShow;
	}

	public void setSiteStatusShow(String siteStatusShow) {
		this.siteStatusShow = siteStatusShow;
	}

	public String getNetWorkStatus() {
		return netWorkStatus;
	}

	public void setNetWorkStatus(String netWorkStatus) {
		this.netWorkStatus = netWorkStatus;
	}

	public String getNetWorkStatusShow() {
		return netWorkStatusShow;
	}

	public void setNetWorkStatusShow(String netWorkStatusShow) {
		this.netWorkStatusShow = netWorkStatusShow;
	}

	public String getExpenseTypeShow() {
		return expenseTypeShow;
	}

	public void setExpenseTypeShow(String expenseTypeShow) {
		this.expenseTypeShow = expenseTypeShow;
	}

	public String getPaymentStatusShow() {
		return paymentStatusShow;
	}

	public void setPaymentStatusShow(String paymentStatusShow) {
		this.paymentStatusShow = paymentStatusShow;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getDocTypeShow() {
		return docTypeShow;
	}

	public void setDocTypeShow(String docTypeShow) {
		this.docTypeShow = docTypeShow;
	}

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public Date getDocDt() {
		return docDt;
	}

	public void setDocDt(Date docDt) {
		this.docDt = docDt;
	}

	public BigDecimal getPayAmt() {
		return payAmt;
	}

	public void setPayAmt(BigDecimal payAmt) {
		this.payAmt = payAmt;
	}

	public String getVatType() {
		return vatType;
	}

	public void setVatType(String vatType) {
		this.vatType = vatType;
	}

	public BigDecimal getExcludeVatAmt() {
		return excludeVatAmt;
	}

	public void setExcludeVatAmt(BigDecimal excludeVatAmt) {
		this.excludeVatAmt = excludeVatAmt;
	}

	public BigDecimal getVatElAmt() {
		return vatElAmt;
	}

	public void setVatElAmt(BigDecimal vatElAmt) {
		this.vatElAmt = vatElAmt;
	}

	public BigDecimal getIncludeVatAmt() {
		return includeVatAmt;
	}

	public void setIncludeVatAmt(BigDecimal includeVatAmt) {
		this.includeVatAmt = includeVatAmt;
	}

	public BigDecimal getWhtElAmt() {
		return whtElAmt;
	}

	public void setWhtElAmt(BigDecimal whtElAmt) {
		this.whtElAmt = whtElAmt;
	}

	public BigDecimal getChqElAmt() {
		return chqElAmt;
	}

	public void setChqElAmt(BigDecimal chqElAmt) {
		this.chqElAmt = chqElAmt;
	}

	public String getPaymentTypeShow() {
		return paymentTypeShow;
	}

	public void setPaymentTypeShow(String paymentTypeShow) {
		this.paymentTypeShow = paymentTypeShow;
	}

	public String getPaymentMethodShow() {
		return paymentMethodShow;
	}

	public void setPaymentMethodShow(String paymentMethodShow) {
		this.paymentMethodShow = paymentMethodShow;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Date getChqPostingDt() {
		return chqPostingDt;
	}

	public void setChqPostingDt(Date chqPostingDt) {
		this.chqPostingDt = chqPostingDt;
	}

	public Date getChqReceivedDt() {
		return chqReceivedDt;
	}

	public void setChqReceivedDt(Date chqReceivedDt) {
		this.chqReceivedDt = chqReceivedDt;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public String getChqNo() {
		return chqNo;
	}

	public void setChqNo(String chqNo) {
		this.chqNo = chqNo;
	}

	public Date getChqClearingDt() {
		return chqClearingDt;
	}

	public void setChqClearingDt(Date chqClearingDt) {
		this.chqClearingDt = chqClearingDt;
	}

	public String getDoc69() {
		return doc69;
	}

	public void setDoc69(String doc69) {
		this.doc69 = doc69;
	}

	public String getPayment_channel() {
		return payment_channel;
	}

	public void setPayment_channel(String paymentChannel) {
		payment_channel = paymentChannel;
	}

	public String getCollectiveDbNo() {
		return collectiveDbNo;
	}

	public void setCollectiveDbNo(String collectiveDbNo) {
		this.collectiveDbNo = collectiveDbNo;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getSiteContructId() {
		return siteContructId;
	}

	public void setSiteContructId(String siteContructId) {
		this.siteContructId = siteContructId;
	}

	public String getSiteApproveId() {
		return siteApproveId;
	}

	public void setSiteApproveId(String siteApproveId) {
		this.siteApproveId = siteApproveId;
	}

	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getSiteConstructStatus() {
		return siteConstructStatus;
	}

	public void setSiteConstructStatus(String siteConstructStatus) {
		this.siteConstructStatus = siteConstructStatus;
	}

	public String getSiteConstructStatusName() {
		return siteConstructStatusName;
	}

	public void setSiteConstructStatusName(String siteConstructStatusName) {
		this.siteConstructStatusName = siteConstructStatusName;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getConPermissionDocNo() {
		return conPermissionDocNo;
	}

	public void setConPermissionDocNo(String conPermissionDocNo) {
		this.conPermissionDocNo = conPermissionDocNo;
	}

	public String getConBuildDocNo() {
		return conBuildDocNo;
	}

	public void setConBuildDocNo(String conBuildDocNo) {
		this.conBuildDocNo = conBuildDocNo;
	}

	public String getConstructType() {
		return constructType;
	}

	public void setConstructType(String constructType) {
		this.constructType = constructType;
	}

	public String getConstructTypeName() {
		return constructTypeName;
	}

	public void setConstructTypeName(String constructTypeName) {
		this.constructTypeName = constructTypeName;
	}

	public String getConstructStatus() {
		return constructStatus;
	}

	public void setConstructStatus(String constructStatus) {
		this.constructStatus = constructStatus;
	}

	public String getConstructStatusName() {
		return constructStatusName;
	}

	public void setConstructStatusName(String constructStatusName) {
		this.constructStatusName = constructStatusName;
	}

	public String getConBillNo() {
		return conBillNo;
	}

	public void setConBillNo(String conBillNo) {
		this.conBillNo = conBillNo;
	}

	public String getConBillPayStatus() {
		return conBillPayStatus;
	}

	public void setConBillPayStatus(String conBillPayStatus) {
		this.conBillPayStatus = conBillPayStatus;
	}

	public String getConBillPayStatusName() {
		return conBillPayStatusName;
	}

	public void setConBillPayStatusName(String conBillPayStatusName) {
		this.conBillPayStatusName = conBillPayStatusName;
	}

	public String getCompanyCri() {
		return companyCri;
	}

	public void setCompanyCri(String companyCri) {
		this.companyCri = companyCri;
	}

	public String getSiteStatusName() {
		return siteStatusName;
	}

	public void setSiteStatusName(String siteStatusName) {
		this.siteStatusName = siteStatusName;
	}

	public String getFlowStatus() {
		return flowStatus;
	}

	public void setFlowStatus(String flowStatus) {
		this.flowStatus = flowStatus;
	}

	public String getTotSendDocNo() {
		return totSendDocNo;
	}

	public void setTotSendDocNo(String totSendDocNo) {
		this.totSendDocNo = totSendDocNo;
	}

	public String getTotRefDocNo() {
		return totRefDocNo;
	}

	public void setTotRefDocNo(String totRefDocNo) {
		this.totRefDocNo = totRefDocNo;
	}

	public String getSiteAmphurId() {
		return siteAmphurId;
	}

	public void setSiteAmphurId(String siteAmphurId) {
		this.siteAmphurId = siteAmphurId;
	}

	public String getSiteProvinceId() {
		return siteProvinceId;
	}

	public void setSiteProvinceId(String siteProvinceId) {
		this.siteProvinceId = siteProvinceId;
	}

	public String getEditableFlag() {
		return editableFlag;
	}

	public void setEditableFlag(String editableFlag) {
		this.editableFlag = editableFlag;
	}

	public String getMigrateFlag() {
		return migrateFlag;
	}

	public void setMigrateFlag(String migrateFlag) {
		this.migrateFlag = migrateFlag;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getTerminateFlag() {
		return terminateFlag;
	}

	public void setTerminateFlag(String terminateFlag) {
		this.terminateFlag = terminateFlag;
	}

	public Integer getpTaxYear() {
		return pTaxYear;
	}

	public void setpTaxYear(Integer pTaxYear) {
		this.pTaxYear = pTaxYear;
	}

	public Double getDiffAmt() {
		return diffAmt;
	}

	public void setDiffAmt(Double diffAmt) {
		this.diffAmt = diffAmt;
	}

	public String getExportFlag() {
		return exportFlag;
	}

	public void setExportFlag(String exportFlag) {
		this.exportFlag = exportFlag;
	}

	public Date getExportDt() {
		return exportDt;
	}

	public void setExportDt(Date exportDt) {
		this.exportDt = exportDt;
	}

	public String getPaymentDocNo() {
		return paymentDocNo;
	}

	public void setPaymentDocNo(String paymentDocNo) {
		this.paymentDocNo = paymentDocNo;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDocTypeDesc() {
		return docTypeDesc;
	}

	public void setDocTypeDesc(String docTypeDesc) {
		this.docTypeDesc = docTypeDesc;
	}

	public String getPaymentStatusId() {
		return paymentStatusId;
	}

	public void setPaymentStatusId(String paymentStatusId) {
		this.paymentStatusId = paymentStatusId;
	}

	public String getDiffRemark() {
		return diffRemark;
	}

	public void setDiffRemark(String diffRemark) {
		this.diffRemark = diffRemark;
	}

	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	public String getNetworkTypeDesc() {
		return networkTypeDesc;
	}

	public void setNetworkTypeDesc(String networkTypeDesc) {
		this.networkTypeDesc = networkTypeDesc;
	}

	public String getTransferType() {
		return transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	public String getTransferTypeDesc() {
		return transferTypeDesc;
	}

	public void setTransferTypeDesc(String transferTypeDesc) {
		this.transferTypeDesc = transferTypeDesc;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getPolicyTypeDesc() {
		return policyTypeDesc;
	}

	public void setPolicyTypeDesc(String policyTypeDesc) {
		this.policyTypeDesc = policyTypeDesc;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public Date getDueDtFrom() {
		return dueDtFrom;
	}

	public void setDueDtFrom(Date dueDtFrom) {
		this.dueDtFrom = dueDtFrom;
	}

	public Double getDutyAmt() {
		return dutyAmt;
	}

	public void setDutyAmt(Double dutyAmt) {
		this.dutyAmt = dutyAmt;
	}

	public Double getTotalPayAmt() {
		return totalPayAmt;
	}

	public void setTotalPayAmt(Double totalPayAmt) {
		this.totalPayAmt = totalPayAmt;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Date getPaymentDt() {
		return paymentDt;
	}

	public void setPaymentDt(Date paymentDt) {
		this.paymentDt = paymentDt;
	}

	public String getPaymentMethodDesc() {
		return paymentMethodDesc;
	}

	public void setPaymentMethodDesc(String paymentMethodDesc) {
		this.paymentMethodDesc = paymentMethodDesc;
	}

	public String getEffDtStr() {
		return effDtStr;
	}

	public void setEffDtStr(String effDtStr) {
		this.effDtStr = effDtStr;
	}

	public String getExpDtStr() {
		return expDtStr;
	}

	public void setExpDtStr(String expDtStr) {
		this.expDtStr = expDtStr;
	}

	public String getDueDtStr() {
		return dueDtStr;
	}

	public void setDueDtStr(String dueDtStr) {
		this.dueDtStr = dueDtStr;
	}

	public String getPaymentRequestDtStr() {
		return paymentRequestDtStr;
	}

	public void setPaymentRequestDtStr(String paymentRequestDtStr) {
		this.paymentRequestDtStr = paymentRequestDtStr;
	}

	public String getChqDtStr() {
		return chqDtStr;
	}

	public void setChqDtStr(String chqDtStr) {
		this.chqDtStr = chqDtStr;
	}

	public String getChqReceiveDtStr() {
		return chqReceiveDtStr;
	}

	public void setChqReceiveDtStr(String chqReceiveDtStr) {
		this.chqReceiveDtStr = chqReceiveDtStr;
	}

	public String getTransferDtStr() {
		return transferDtStr;
	}

	public void setTransferDtStr(String transferDtStr) {
		this.transferDtStr = transferDtStr;
	}

	public String getCreateDateStr() {
		return createDateStr;
	}

	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}

	public String getDocDtStr() {
		return docDtStr;
	}

	public void setDocDtStr(String docDtStr) {
		this.docDtStr = docDtStr;
	}

	public String getChqPostingDtStr() {
		return chqPostingDtStr;
	}

	public void setChqPostingDtStr(String chqPostingDtStr) {
		this.chqPostingDtStr = chqPostingDtStr;
	}

	public String getChqReceivedDtStr() {
		return chqReceivedDtStr;
	}

	public void setChqReceivedDtStr(String chqReceivedDtStr) {
		this.chqReceivedDtStr = chqReceivedDtStr;
	}

	public String getChqClearingDtStr() {
		return chqClearingDtStr;
	}

	public void setChqClearingDtStr(String chqClearingDtStr) {
		this.chqClearingDtStr = chqClearingDtStr;
	}

	public String getExportDtStr() {
		return exportDtStr;
	}

	public void setExportDtStr(String exportDtStr) {
		this.exportDtStr = exportDtStr;
	}

	public String getDueDtFromStr() {
		return dueDtFromStr;
	}

	public void setDueDtFromStr(String dueDtFromStr) {
		this.dueDtFromStr = dueDtFromStr;
	}

	public String getUpdateDtStr() {
		return updateDtStr;
	}

	public void setUpdateDtStr(String updateDtStr) {
		this.updateDtStr = updateDtStr;
	}

	public String getPaymentDtStr() {
		return paymentDtStr;
	}

	public void setPaymentDtStr(String paymentDtStr) {
		this.paymentDtStr = paymentDtStr;
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
