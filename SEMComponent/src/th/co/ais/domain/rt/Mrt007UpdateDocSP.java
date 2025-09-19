package th.co.ais.domain.rt;

import java.math.BigDecimal;
import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mrt007UpdateDocSP extends AbstractDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8842733387326111939L;
	private String rowId;
	private String company;
	private String contractNo;
	private String siteName;
	private String locationId;
	private String vendorId;
	private String vendorName;
	private Date fromTermOfPaymentDt;
	private String fromTermOfPaymentDtStr;
	private String fromPeriodNo;
	private BigDecimal paymentAmt;
	private BigDecimal vat;
	private BigDecimal whtAmt;
	private BigDecimal totalAmt;
	private String chqNo;
	private Date chqDt;
	private String chqDtStr;
	private Date transferDt;
	private String transferDtStr;
	private String doc68;
	private Date doc68Dt;
	private String doc68DtStr;
	private String doc92;
	private Date doc92Dt;
	private String doc92DtStr;
	private String siteInfoId;
	
	private BigDecimal payExcAmt;
	private Date periodStartDt;
	private String periodStartDtStr;
	private Date periodEndDt;
	private String periodEndDtStr;
	
	private String transPaymentId;
	
	private BigDecimal periodNoStart;
	private BigDecimal periodNoEnd;
	
	private String result;
	private String remark;
	
	private String clrReceiptStatus;
	private String userId;
	
	private String batchNo;
	

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
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

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
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

	public Date getFromTermOfPaymentDt() {
		return fromTermOfPaymentDt;
	}

	public void setFromTermOfPaymentDt(Date fromTermOfPaymentDt) {
		this.fromTermOfPaymentDt = fromTermOfPaymentDt;
	}

	public String getFromPeriodNo() {
		return fromPeriodNo;
	}

	public void setFromPeriodNo(String fromPeriodNo) {
		this.fromPeriodNo = fromPeriodNo;
	}

	public BigDecimal getVat() {
		return vat;
	}

	public void setVat(BigDecimal vat) {
		this.vat = vat;
	}

	public String getChqNo() {
		return chqNo;
	}

	public void setChqNo(String chqNo) {
		this.chqNo = chqNo;
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

	public String getDoc92() {
		return doc92;
	}

	public void setDoc92(String doc92) {
		this.doc92 = doc92;
	}

	public Date getDoc92Dt() {
		return doc92Dt;
	}

	public void setDoc92Dt(Date doc92Dt) {
		this.doc92Dt = doc92Dt;
	}

	public String getFromTermOfPaymentDtStr() {
		return fromTermOfPaymentDtStr;
	}

	public void setFromTermOfPaymentDtStr(String fromTermOfPaymentDtStr) {
		this.fromTermOfPaymentDtStr = fromTermOfPaymentDtStr;
	}

	public String getDoc68DtStr() {
		return doc68DtStr;
	}

	public void setDoc68DtStr(String doc68DtStr) {
		this.doc68DtStr = doc68DtStr;
	}

	public String getDoc92DtStr() {
		return doc92DtStr;
	}

	public void setDoc92DtStr(String doc92DtStr) {
		this.doc92DtStr = doc92DtStr;
	}

	public String getChqDtStr() {
		return chqDtStr;
	}

	public void setChqDtStr(String chqDtStr) {
		this.chqDtStr = chqDtStr;
	}

	public String getTransferDtStr() {
		return transferDtStr;
	}

	public void setTransferDtStr(String transferDtStr) {
		this.transferDtStr = transferDtStr;
	}

	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	public String getTransPaymentId() {
		return transPaymentId;
	}

	public void setTransPaymentId(String transPaymentId) {
		this.transPaymentId = transPaymentId;
	}

	public BigDecimal getPaymentAmt() {
		return paymentAmt;
	}

	public void setPaymentAmt(BigDecimal paymentAmt) {
		this.paymentAmt = paymentAmt;
	}

	public BigDecimal getWhtAmt() {
		return whtAmt;
	}

	public void setWhtAmt(BigDecimal whtAmt) {
		this.whtAmt = whtAmt;
	}

	public BigDecimal getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(BigDecimal totalAmt) {
		this.totalAmt = totalAmt;
	}

	public BigDecimal getPayExcAmt() {
		return payExcAmt;
	}

	public void setPayExcAmt(BigDecimal payExcAmt) {
		this.payExcAmt = payExcAmt;
	}

	public BigDecimal getPeriodNoStart() {
		return periodNoStart;
	}

	public void setPeriodNoStart(BigDecimal periodNoStart) {
		this.periodNoStart = periodNoStart;
	}

	public BigDecimal getPeriodNoEnd() {
		return periodNoEnd;
	}

	public void setPeriodNoEnd(BigDecimal periodNoEnd) {
		this.periodNoEnd = periodNoEnd;
	}

	public Date getPeriodStartDt() {
		return periodStartDt;
	}

	public void setPeriodStartDt(Date periodStartDt) {
		this.periodStartDt = periodStartDt;
	}

	public String getPeriodStartDtStr() {
		return periodStartDtStr;
	}

	public void setPeriodStartDtStr(String periodStartDtStr) {
		this.periodStartDtStr = periodStartDtStr;
	}

	public Date getPeriodEndDt() {
		return periodEndDt;
	}

	public void setPeriodEndDt(Date periodEndDt) {
		this.periodEndDt = periodEndDt;
	}

	public String getPeriodEndDtStr() {
		return periodEndDtStr;
	}

	public void setPeriodEndDtStr(String periodEndDtStr) {
		this.periodEndDtStr = periodEndDtStr;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getClrReceiptStatus() {
		return clrReceiptStatus;
	}

	public void setClrReceiptStatus(String clrReceiptStatus) {
		this.clrReceiptStatus = clrReceiptStatus;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	@Override
	public String getCreateBy() {
		// TODO Auto-generated method stub
		return createBy;
	}

	@Override
	public Date getCreateDt() {
		// TODO Auto-generated method stub
		return createDt;
	}

	@Override
	public String getUpdateBy() {
		// TODO Auto-generated method stub
		return updateBy;
	}

	@Override
	public Date getUpdateDt() {
		// TODO Auto-generated method stub
		return updateDt;
	}

	@Override
	public void setCreateBy(String createBy) {
		// TODO Auto-generated method stub
		this.createBy = createBy;
	}

	@Override
	public void setCreateDt(Date createDt) {
		// TODO Auto-generated method stub
		this.createDt = createDt;
	}

	@Override
	public void setUpdateBy(String updateBy) {
		// TODO Auto-generated method stub
		this.updateBy = updateBy;
	}

	@Override
	public void setUpdateDt(Date updateDt) {
		// TODO Auto-generated method stub
		this.updateDt = updateDt;
	}

}
