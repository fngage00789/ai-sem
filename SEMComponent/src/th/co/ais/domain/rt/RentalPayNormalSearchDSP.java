package th.co.ais.domain.rt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class RentalPayNormalSearchDSP extends AbstractDomain{

	private String rowId;
	private Double totalAmt;
	private String depositFlag;
	private Double depositAmt;
	private Double paymentAmt;
	private String paymentType;
	private String paymentMethod;
	private String bankAccNo;
	private String bankName;
	private Date chqDt;
	private Date chqReceiveDt;
	private Date transferDt;
	private String remark;
	private String contractNo;
	private String expenseType;
	private Date dueDt;
	private Integer periodNo;
	private String payPeriodType;
	private Integer periodY;
	private Integer periodM;
	private Integer periodD;
	private Integer calYear;
	private Integer calMonth;
	private Double dueAmt;
	private String vatType;
	private Double excAmt;
	private Double vatRate;
	private Double vatAmt;
	private Double incAmt;
	private Double whtRate;
	private Double whtAmt;
	
	private Double maxDepositAmt;
	private String periodType;
	private String whtType;
	
	// Update
	private String resultMsg;
	private String paymentGroupNo;
	private String rentalPaymentId;
	
	//Popup Edit
	private boolean discountFlg = false;
	private Integer discountRate;
	private Double discountAmt;
	private boolean fineFlg = false;
	private boolean extraFlg = false;
	private String fineFlag;
	private String extraFlag;
	private String vatBefore;
	private String whtBefore;
	private Date effDate;
	private Date expDate;
	private String discountFlag;
	
	//popup Edit Create New
	private String siteName;
	private String expense;
	private Double defaultVat;
	private Double defaultWht;
	private Date periodStartDt;
	private Date periodEndDt;
	private Double periodAmt;
	private String vendorMasterId;
	private String vendorName;
	private String vendor;
	private String payeeId;
	private String payeeName;
	private String payee;
	private String bangAccNo;
	private String user;
	private String rentalDetailId;
	
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
	public Double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}
	public String getDepositFlag() {
		return depositFlag;
	}
	public void setDepositFlag(String depositFlag) {
		this.depositFlag = depositFlag;
	}
	public Double getDepositAmt() {
		return depositAmt;
	}
	public void setDepositAmt(Double depositAmt) {
		this.depositAmt = depositAmt;
	}
	public Double getPaymentAmt() {
		return paymentAmt;
	}
	public void setPaymentAmt(Double paymentAmt) {
		this.paymentAmt = paymentAmt;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getBankAccNo() {
		return bankAccNo;
	}
	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
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
	public String getPeriodType() {
		return periodType;
	}
	public void setPeriodType(String periodType) {
		this.periodType = periodType;
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
	public Integer getCalYear() {
		return calYear;
	}
	public void setCalYear(Integer calYear) {
		this.calYear = calYear;
	}
	public Integer getCalMonth() {
		return calMonth;
	}
	public void setCalMonth(Integer calMonth) {
		this.calMonth = calMonth;
	}
	public Double getDueAmt() {
		return dueAmt;
	}
	public void setDueAmt(Double dueAmt) {
		this.dueAmt = dueAmt;
	}
	public String getVatType() {
		return vatType;
	}
	public void setVatType(String vatType) {
		this.vatType = vatType;
	}
	public Double getExcAmt() {
		return excAmt;
	}
	public void setExcAmt(Double excAmt) {
		this.excAmt = excAmt;
	}
	public Double getVatRate() {
		return vatRate;
	}
	public void setVatRate(Double vatRate) {
		this.vatRate = vatRate;
	}
	public Double getVatAmt() {
		return vatAmt;
	}
	public void setVatAmt(Double vatAmt) {
		this.vatAmt = vatAmt;
	}
	public Double getIncAmt() {
		return incAmt;
	}
	public void setIncAmt(Double incAmt) {
		this.incAmt = incAmt;
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
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setPaymentGroupNo(String paymentGroupNo) {
		this.paymentGroupNo = paymentGroupNo;
	}
	public String getPaymentGroupNo() {
		return paymentGroupNo;
	}
	public void setRentalPaymentId(String rentalPaymentId) {
		this.rentalPaymentId = rentalPaymentId;
	}
	public String getRentalPaymentId() {
		return rentalPaymentId;
	}
	public void setMaxDepositAmt(Double maxDepositAmt) {
		this.maxDepositAmt = maxDepositAmt;
	}
	public Double getMaxDepositAmt() {
		return maxDepositAmt;
	}
	public String getPayPeriodType() {
		return payPeriodType;
	}
	public void setPayPeriodType(String payPeriodType) {
		this.payPeriodType = payPeriodType;
	}
	public String getWhtType() {
		return whtType;
	}
	public void setWhtType(String whtType) {
		this.whtType = whtType;
	}
	public Integer getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(Integer discountRate) {
		this.discountRate = discountRate;
	}
	public Double getDiscountAmt() {
		return discountAmt;
	}
	public void setDiscountAmt(Double discountAmt) {
		this.discountAmt = discountAmt;
	}
	public boolean isDiscountFlg() {
		return discountFlg;
	}
	public void setDiscountFlg(boolean discountFlg) {
		this.discountFlg = discountFlg;
	}
	public boolean isFineFlg() {
		return fineFlg;
	}
	public void setFineFlg(boolean fineFlg) {
		this.fineFlg = fineFlg;
	}
	public boolean isExtraFlg() {
		return extraFlg;
	}
	public void setExtraFlg(boolean extraFlg) {
		this.extraFlg = extraFlg;
	}
	public String getFineFlag() {
		return fineFlag;
	}
	public void setFineFlag(String fineFlag) {
		this.fineFlag = fineFlag;
	}
	public String getExtraFlag() {
		return extraFlag;
	}
	public void setExtraFlag(String extraFlag) {
		this.extraFlag = extraFlag;
	}
	public String getVatBefore() {
		return vatBefore;
	}
	public void setVatBefore(String vatBefore) {
		this.vatBefore = vatBefore;
	}
	public String getWhtBefore() {
		return whtBefore;
	}
	public void setWhtBefore(String whtBefore) {
		this.whtBefore = whtBefore;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public Date getEffDate() {
		return effDate;
	}
	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public String getExpense() {
		return expense;
	}
	public void setExpense(String expense) {
		this.expense = expense;
	}
	public Double getDefaultVat() {
		return defaultVat;
	}
	public void setDefaultVat(Double defaultVat) {
		this.defaultVat = defaultVat;
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
	public Double getPeriodAmt() {
		return periodAmt;
	}
	public void setPeriodAmt(Double periodAmt) {
		this.periodAmt = periodAmt;
	}
	public String getVendorMasterId() {
		return vendorMasterId;
	}
	public void setVendorMasterId(String vendorMasterId) {
		this.vendorMasterId = vendorMasterId;
	}
	public String getPayeeId() {
		return payeeId;
	}
	public void setPayeeId(String payeeId) {
		this.payeeId = payeeId;
	}
	public Double getDefaultWht() {
		return defaultWht;
	}
	public void setDefaultWht(Double defaultWht) {
		this.defaultWht = defaultWht;
	}
	public String getBangAccNo() {
		return bangAccNo;
	}
	public void setBangAccNo(String bangAccNo) {
		this.bangAccNo = bangAccNo;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public String getPayee() {
		return payee;
	}
	public void setPayee(String payee) {
		this.payee = payee;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getRentalDetailId() {
		return rentalDetailId;
	}
	public void setRentalDetailId(String rentalDetailId) {
		this.rentalDetailId = rentalDetailId;
	}
	public String getDiscountFlag() {
		return discountFlag;
	}
	public void setDiscountFlag(String discountFlag) {
		this.discountFlag = discountFlag;
	}
	public String getExpenseDesc() {
		return expenseDesc;
	}
	public void setExpenseDesc(String expenseDesc) {
		this.expenseDesc = expenseDesc;
	}
	
	
}
