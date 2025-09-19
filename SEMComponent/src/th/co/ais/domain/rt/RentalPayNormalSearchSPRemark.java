package th.co.ais.domain.rt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.annotation.PCell;
import th.co.ais.rpt.util.enums.EnumDocStyle;

public class RentalPayNormalSearchSPRemark extends AbstractDomain{
	
	private String rowId;
	private String paymentGroupNo;
	private String contractNo;
	private String siteName;
	private Date effDt;
	private Date expDt;
	private Date dueDt;
	private Integer periodNo;
	private String expenseType;
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
	private Double excAmt;
	private String siteStatus;
	private String networkStatus;
	private String expStatus;
	private String expApprove;
	private Date paymentRequestDt;
	private String paymentStatus;
	private String paymentType;
	private String bankName;
	private String whtTypeDesc;
	private String siteInfoId;
	
	private Date chqReceiveDt;
	private Date chqReceiveDtDisplay;
	
	private Date chqDt;
	private Date chqDtDisplay;
	
	private Date transferDt;
	private Date transferDtDisplay;
	
	private Double depositAmt;
	private Double pettyAmt;
	private Double totalAmt;
	private String bankAccNo;
	private String remark;
	private String remarkVerify;
	private String remarkPending;
	private String remarkOther;
	private String reqType;
	private String jobType;
	private String company;
	private String region;
	private Date dueDtFrom;
	private Date dueDtTo;
	private String siteType;
	private String picoFlag;
	
	private String paymentTypeDesc;
	private String paymentStatusDesc;
	private String paymentMethod;
	private String paymentBatchNo;
	
	//parameter for Export Excel
	private String paymentDocno;
	private String whtType;
	
	private boolean renderColumn;
	private boolean chkPico;
	
	private String vendorMasterId;
	private String expenseTypeDesc;
	private int no;
	
	private String batchNo;
	private String pAction;
	private boolean pExportChq;
	private String exportChqFlag;
	private String oldContractNo;
	private String oldSiteInfoId;
	
	
	private String vendorNameSch;
	private Date chqReceiveDtSch;
	private Date chqReceiveToDtSch;
	private String networkStatusSch;
	private Date paymentRequestDtSch;
	private Date paymentRequestToDtSch;
	private String siteStatusSch;
	private Date paymentDt;
	private Date paymentToDt;
	private String vendorId;
	private String expenseTypeSch;
	private boolean pendingStatus = false;
	private boolean expireStatus = false;
	private String pendingFlag;
	private String expireFlag;
	private String bank;
	private boolean historyFlag = false;
	
	private String regionName;
	private Integer payExportTotal;
	private Integer payNoExportTotal;
	private Integer payTotal;
	private Integer noPayTotal;
	private Integer grandTotal;
	private String statusPay;
	private String docSettingDebt;
	private String docCuttingDebt;
	private String docCancel;
	private String docNo;
	private String payPeriod;
	private String historyFlg;
	
	private String effDtStr;
	private String expDtStr;
	private String dueDtStr;
	private String paymentRequestDtStr;
	private String chqDtDisplayStr;
	private String chqReceiveDtDisplayStr;
	private String transferDtDisplayStr;
	private String noPay;
	private boolean noPayFlag = false;
	
	private Double totalExcAmt;
	private Double totalVatAmt;
	private Double totalWhtAmt;
	private Double totalChqAmt;
	private String sheetName;
	
	public String getPicoFlag() {
		return picoFlag;
	}
	public void setPicoFlag(String picoFlag) {
		this.picoFlag = picoFlag;
	}
	public boolean isChkPico() {
		return chkPico;
	}
	public void setChkPico(boolean chkPico) {
		this.chkPico = chkPico;
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
	@PCell(cellType = String.class ,no = 3, manualStyleName ="rt003Field")
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	@PCell(cellType = String.class ,no = 4, manualStyleName ="rt003Field")
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
	@PCell(cellType = Date.class ,no = 5, manualStyleName = "rt003Field")
	public Date getDueDt() {
		return dueDt;
	}
	public void setDueDt(Date dueDt) {
		this.dueDt = dueDt;
	}
	@PCell(cellType = Integer.class ,no = 7, manualStyleName = "rt003Field")
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
	@PCell(cellType = String.class ,no = 2, manualStyleName = "rt003Field")
	public String getVendorCode() {
		return vendorCode;
	}
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	@PCell(cellType = String.class ,no = 8, manualStyleName = "rt003Field")
	public String getVendorName() {
		return vendorName;
	}
//	@PCell(cellType = String.class ,no = 6)
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
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
	public String getSiteType() {
		return siteType;
	}
	public void setSiteType(String siteType) {
		this.siteType = siteType;
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
	@PCell(cellType = String.class ,no = 9, manualStyleName = "rt003Field")
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	@PCell(cellType = String.class ,no = 6, manualStyleName = "rt003Field")
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
	//@PCell(cellType = Double.class ,no = 11, manualStyleName = "rt003FieldMoney")
	public Double getDueAmt() {
		return dueAmt;
	}
	public void setDueAmt(Double dueAmt) {
		this.dueAmt = dueAmt;
	}
	@PCell(cellType = Double.class ,no = 12, manualStyleName = "rt003FieldMoney")
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
	@PCell(cellType = Double.class ,no = 11, manualStyleName = "rt003FieldMoney")
	public Double getExcAmt() {
		return excAmt;
	}
	public void setExcAmt(Double excAmt) {
		this.excAmt = excAmt;
	}
	@PCell(cellType = Double.class ,no = 13, manualStyleName = "rt003FieldMoney")
	public Double getWhtAmt() {
		return whtAmt;
	}
	public void setWhtAmt(Double whtAmt) {
		this.whtAmt = whtAmt;
	}
	@PCell(cellType = Double.class ,no = 14, manualStyleName = "rt003FieldMoney")
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
	public Date getChqReceiveDt() {
		return chqReceiveDt;
	}
	public void setChqReceiveDt(Date chqReceiveDt) {
		this.chqReceiveDt = chqReceiveDt;
	}
	public Date getChqDt() {
		return chqDt;
	}
	public void setChqDt(Date chqDt) {
		this.chqDt = chqDt;
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
	@PCell(cellType = String.class ,no = 17, manualStyleName = "rt003Field")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setRenderColumn(boolean renderColumn) {
		this.renderColumn = renderColumn;
	}
	public void setPaymentDocno(String paymentDocno) {
		this.paymentDocno = paymentDocno;
	}
	@PCell(cellType = String.class ,no = 1, manualStyleName = "rt003Field")
	public String getPaymentDocno() {
		return paymentDocno;
	}
	public boolean isRenderColumn() {
		return renderColumn;
	}
	public void setWhtType(String whtType) {
		this.whtType = whtType;
	}
	
	public String getWhtType() {
		return whtType;
	}
	public void setPaymentTypeDesc(String paymentTypeDesc) {
		this.paymentTypeDesc = paymentTypeDesc;
	}
//	@PCell(cellType = String.class ,no = 15)
	public String getPaymentTypeDesc() {
		return paymentTypeDesc;
	}
	public void setPaymentStatusDesc(String paymentStatusDesc) {
		this.paymentStatusDesc = paymentStatusDesc;
	}
	public String getPaymentStatusDesc() {
		return paymentStatusDesc;
	}
	/**
	 * @param vendorMasterId the vendorMasterId to set
	 */
	public void setVendorMasterId(String vendorMasterId) {
		this.vendorMasterId = vendorMasterId;
	}
	/**
	 * @return the vendorMasterId
	 */
	public String getVendorMasterId() {
		return vendorMasterId;
	}
	/**
	 * @param expenseTypeDesc the expenseTypeDesc to set
	 */
	public void setExpenseTypeDesc(String expenseTypeDesc) {
		this.expenseTypeDesc = expenseTypeDesc;
	}
	/**
	 * @return the expenseTypeDesc
	 */
	public String getExpenseTypeDesc() {
		return expenseTypeDesc;
	}
	/**
	 * @param paymentMethod the paymentMethod to set
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	/**
	 * @return the paymentMethod
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public Date getChqReceiveDtDisplay() {
		return chqReceiveDtDisplay;
	}
	public void setChqReceiveDtDisplay(Date chqReceiveDtDisplay) {
		this.chqReceiveDtDisplay = chqReceiveDtDisplay;
	}
	public Date getChqDtDisplay() {
		return chqDtDisplay;
	}
	public void setChqDtDisplay(Date chqDtDisplay) {
		this.chqDtDisplay = chqDtDisplay;
	}
	public Date getTransferDtDisplay() {
		return transferDtDisplay;
	}
	public void setTransferDtDisplay(Date transferDtDisplay) {
		this.transferDtDisplay = transferDtDisplay;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	@PCell(cellType = String.class ,no = 0, manualStyleName = "rt003Field")
	public String getStringNo() {
		return no + "";
	}
	@PCell(cellType = String.class ,no = 10, manualStyleName = "rt003Field")
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
	public String getPaymentBatchNo() {
		return paymentBatchNo;
	}
	public void setPaymentBatchNo(String paymentBatchNo) {
		this.paymentBatchNo = paymentBatchNo;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getpAction() {
		return pAction;
	}
	public void setpAction(String pAction) {
		this.pAction = pAction;
	}
	public boolean ispExportChq() {
		return pExportChq;
	}
	public void setpExportChq(boolean pExportChq) {
		this.pExportChq = pExportChq;
	}
	public String getExportChqFlag() {
		return exportChqFlag;
	}
	public void setExportChqFlag(String exportChqFlag) {
		this.exportChqFlag = exportChqFlag;
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
	public String getVendorNameSch() {
		return vendorNameSch;
	}
	public void setVendorNameSch(String vendorNameSch) {
		this.vendorNameSch = vendorNameSch;
	}
	public Date getChqReceiveDtSch() {
		return chqReceiveDtSch;
	}
	public void setChqReceiveDtSch(Date chqReceiveDtSch) {
		this.chqReceiveDtSch = chqReceiveDtSch;
	}
	public String getNetworkStatusSch() {
		return networkStatusSch;
	}
	public void setNetworkStatusSch(String networkStatusSch) {
		this.networkStatusSch = networkStatusSch;
	}
	public Date getPaymentRequestDtSch() {
		return paymentRequestDtSch;
	}
	public void setPaymentRequestDtSch(Date paymentRequestDtSch) {
		this.paymentRequestDtSch = paymentRequestDtSch;
	}
	public String getSiteStatusSch() {
		return siteStatusSch;
	}
	public void setSiteStatusSch(String siteStatusSch) {
		this.siteStatusSch = siteStatusSch;
	}
	public Date getPaymentDt() {
		return paymentDt;
	}
	public void setPaymentDt(Date paymentDt) {
		this.paymentDt = paymentDt;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getExpenseTypeSch() {
		return expenseTypeSch;
	}
	public void setExpenseTypeSch(String expenseTypeSch) {
		this.expenseTypeSch = expenseTypeSch;
	}
	public boolean isPendingStatus() {
		return pendingStatus;
	}
	public void setPendingStatus(boolean pendingStatus) {
		this.pendingStatus = pendingStatus;
	}
	public boolean isExpireStatus() {
		return expireStatus;
	}
	public void setExpireStatus(boolean expireStatus) {
		this.expireStatus = expireStatus;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public boolean isHistoryFlag() {
		return historyFlag;
	}
	public void setHistoryFlag(boolean historyFlag) {
		this.historyFlag = historyFlag;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public Integer getPayExportTotal() {
		return payExportTotal;
	}
	public void setPayExportTotal(Integer payExportTotal) {
		this.payExportTotal = payExportTotal;
	}
	public Integer getPayNoExportTotal() {
		return payNoExportTotal;
	}
	public void setPayNoExportTotal(Integer payNoExportTotal) {
		this.payNoExportTotal = payNoExportTotal;
	}
	public Integer getPayTotal() {
		return payTotal;
	}
	public void setPayTotal(Integer payTotal) {
		this.payTotal = payTotal;
	}
	public Integer getNoPayTotal() {
		return noPayTotal;
	}
	public void setNoPayTotal(Integer noPayTotal) {
		this.noPayTotal = noPayTotal;
	}
	public Integer getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(Integer grandTotal) {
		this.grandTotal = grandTotal;
	}
	public String getStatusPay() {
		return statusPay;
	}
	public void setStatusPay(String statusPay) {
		this.statusPay = statusPay;
	}
	public Date getPaymentToDt() {
		return paymentToDt;
	}
	public void setPaymentToDt(Date paymentToDt) {
		this.paymentToDt = paymentToDt;
	}
	public Date getChqReceiveToDtSch() {
		return chqReceiveToDtSch;
	}
	public void setChqReceiveToDtSch(Date chqReceiveToDtSch) {
		this.chqReceiveToDtSch = chqReceiveToDtSch;
	}
	public Date getPaymentRequestToDtSch() {
		return paymentRequestToDtSch;
	}
	public void setPaymentRequestToDtSch(Date paymentRequestToDtSch) {
		this.paymentRequestToDtSch = paymentRequestToDtSch;
	}
	public String getPendingFlag() {
		return pendingFlag;
	}
	public void setPendingFlag(String pendingFlag) {
		this.pendingFlag = pendingFlag;
	}
	public String getExpireFlag() {
		return expireFlag;
	}
	public void setExpireFlag(String expireFlag) {
		this.expireFlag = expireFlag;
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
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public String getPayPeriod() {
		return payPeriod;
	}
	public void setPayPeriod(String payPeriod) {
		this.payPeriod = payPeriod;
	}
	public String getHistoryFlg() {
		return historyFlg;
	}
	public void setHistoryFlg(String historyFlg) {
		this.historyFlg = historyFlg;
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
	public String getChqDtDisplayStr() {
		return chqDtDisplayStr;
	}
	public void setChqDtDisplayStr(String chqDtDisplayStr) {
		this.chqDtDisplayStr = chqDtDisplayStr;
	}
	public String getChqReceiveDtDisplayStr() {
		return chqReceiveDtDisplayStr;
	}
	public void setChqReceiveDtDisplayStr(String chqReceiveDtDisplayStr) {
		this.chqReceiveDtDisplayStr = chqReceiveDtDisplayStr;
	}
	public String getTransferDtDisplayStr() {
		return transferDtDisplayStr;
	}
	public void setTransferDtDisplayStr(String transferDtDisplayStr) {
		this.transferDtDisplayStr = transferDtDisplayStr;
	}
	public String getNoPay() {
		return noPay;
	}
	public void setNoPay(String noPay) {
		this.noPay = noPay;
	}
	public boolean isNoPayFlag() {
		return noPayFlag;
	}
	public void setNoPayFlag(boolean noPayFlag) {
		this.noPayFlag = noPayFlag;
	}
	public Double getTotalExcAmt() {
		return totalExcAmt;
	}
	public void setTotalExcAmt(Double totalExcAmt) {
		this.totalExcAmt = totalExcAmt;
	}
	public Double getTotalVatAmt() {
		return totalVatAmt;
	}
	public void setTotalVatAmt(Double totalVatAmt) {
		this.totalVatAmt = totalVatAmt;
	}
	public Double getTotalWhtAmt() {
		return totalWhtAmt;
	}
	public void setTotalWhtAmt(Double totalWhtAmt) {
		this.totalWhtAmt = totalWhtAmt;
	}
	public Double getTotalChqAmt() {
		return totalChqAmt;
	}
	public void setTotalChqAmt(Double totalChqAmt) {
		this.totalChqAmt = totalChqAmt;
	}
	public String getSheetName() {
		return sheetName;
	}
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
	@PCell(cellType = String.class ,no = 15, manualStyleName = "rt003Field")
	public String getRemarkVerify() {
		return remarkVerify;
	}
	public void setRemarkVerify(String remarkVerify) {
		this.remarkVerify = remarkVerify;
	}
	@PCell(cellType = String.class ,no = 16, manualStyleName = "rt003Field")
	public String getRemarkPending() {
		return remarkPending;
	}
	public void setRemarkPending(String remarkPending) {
		this.remarkPending = remarkPending;
	}
	@PCell(cellType = String.class ,no = 18, manualStyleName = "rt003Field")
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
	
}
