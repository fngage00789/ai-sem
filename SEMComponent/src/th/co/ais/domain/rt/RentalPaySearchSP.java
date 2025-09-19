package th.co.ais.domain.rt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class RentalPaySearchSP extends AbstractDomain{
	
	
	private String rowId;
	private String contractNo;
	private String siteName;
	private Date efftDt;
	private Date expDt;
	private Date dueDt;
	private Integer periodNo;
	private String expenseType;
	private String vendorId;
	private String vendorName;
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
	private String paymentStatus;
	private String paymentType;
	private String bankName;
	private Date chqReceiveDt;
	private Date chqDt;
	private Date transferDt;
	private Double depositAmt;
	private Double pettyAmt;
	private Double totalAmt;
	private String bankAccNo;
	private String remark;
	private String siteType;
	private Date dueDtFrom;
	private Date dueDtTo;
	private String paymentMethod;
	private Date paymentDt;
	private String region;
	private String company;
	private String jobType;
	private String picoFlag;
	private boolean chkPico;
	private String batchNo;
	private String siteInfoId;
	private Date efftThDt;
	private Date expThDt;
	private Date dueThDt;
	private Date paymentRequestThDt;
	private Date chqThDt;
	private Date chqReceiveThDt;
	private Date transferThDt;
	private String oldContractNo;
	private String doc68;
	private String doc92;
	private String oldSiteInfoId;
	
	private String efftThDtStr;
	private String expThDtStr;
	private String dueThDtStr;
	private String paymentRequestThDtStr;
	private String chqThDtStr;
	private String chqReceiveThDtStr;
	private String transferThDtStr;
	
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
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public Date getEfftDt() {
		return efftDt;
	}
	public void setEfftDt(Date efftDt) {
		this.efftDt = efftDt;
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
	public String getSiteType() {
		return siteType;
	}
	public void setSiteType(String siteType) {
		this.siteType = siteType;
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
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Date getPaymentDt() {
		return paymentDt;
	}
	public void setPaymentDt(Date paymentDt) {
		this.paymentDt = paymentDt;
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
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getRegion() {
		return region;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCompany() {
		return company;
	}
	public void setChqDt(Date chqDt) {
		this.chqDt = chqDt;
	}
	public Date getChqDt() {
		return chqDt;
	}
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
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public Date getEfftThDt() {
		return efftThDt;
	}
	public void setEfftThDt(Date efftThDt) {
		this.efftThDt = efftThDt;
	}
	public Date getExpThDt() {
		return expThDt;
	}
	public void setExpThDt(Date expThDt) {
		this.expThDt = expThDt;
	}
	public Date getDueThDt() {
		return dueThDt;
	}
	public void setDueThDt(Date dueThDt) {
		this.dueThDt = dueThDt;
	}
	public Date getChqThDt() {
		return chqThDt;
	}
	public void setChqThDt(Date chqThDt) {
		this.chqThDt = chqThDt;
	}
	public Date getChqReceiveThDt() {
		return chqReceiveThDt;
	}
	public void setChqReceiveThDt(Date chqReceiveThDt) {
		this.chqReceiveThDt = chqReceiveThDt;
	}
	public Date getTransferThDt() {
		return transferThDt;
	}
	public void setTransferThDt(Date transferThDt) {
		this.transferThDt = transferThDt;
	}
	public Date getPaymentRequestThDt() {
		return paymentRequestThDt;
	}
	public void setPaymentRequestThDt(Date paymentRequestThDt) {
		this.paymentRequestThDt = paymentRequestThDt;
	}
	public String getOldContractNo() {
		return oldContractNo;
	}
	public void setOldContractNo(String oldContractNo) {
		this.oldContractNo = oldContractNo;
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
	public String getOldSiteInfoId() {
		return oldSiteInfoId;
	}
	public void setOldSiteInfoId(String oldSiteInfoId) {
		this.oldSiteInfoId = oldSiteInfoId;
	}
	public String getEfftThDtStr() {
		return efftThDtStr;
	}
	public void setEfftThDtStr(String efftThDtStr) {
		this.efftThDtStr = efftThDtStr;
	}
	public String getExpThDtStr() {
		return expThDtStr;
	}
	public void setExpThDtStr(String expThDtStr) {
		this.expThDtStr = expThDtStr;
	}
	public String getDueThDtStr() {
		return dueThDtStr;
	}
	public void setDueThDtStr(String dueThDtStr) {
		this.dueThDtStr = dueThDtStr;
	}
	public String getPaymentRequestThDtStr() {
		return paymentRequestThDtStr;
	}
	public void setPaymentRequestThDtStr(String paymentRequestThDtStr) {
		this.paymentRequestThDtStr = paymentRequestThDtStr;
	}
	public String getChqThDtStr() {
		return chqThDtStr;
	}
	public void setChqThDtStr(String chqThDtStr) {
		this.chqThDtStr = chqThDtStr;
	}
	public String getChqReceiveThDtStr() {
		return chqReceiveThDtStr;
	}
	public void setChqReceiveThDtStr(String chqReceiveThDtStr) {
		this.chqReceiveThDtStr = chqReceiveThDtStr;
	}
	public String getTransferThDtStr() {
		return transferThDtStr;
	}
	public void setTransferThDtStr(String transferThDtStr) {
		this.transferThDtStr = transferThDtStr;
	}
}
