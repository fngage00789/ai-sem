package th.co.ais.domain.el;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MeterInstallmentSearch implements Serializable {

	private static final long serialVersionUID = -748599263289088321L;
	
	private String rowId;
	private String contractNo;
	private String company;
	private String siteName;
	private String region;
	private String province;
	private String locationId;
	private String locationCode;
	private Date fromTermOfPaymentDt;
	private Date toTermOfPaymentDt;
	private String siteType;
	private String periodName;
	private Date dueDt;
	private BigDecimal periodAmt;
	private String paidFlag;
	private BigDecimal periodNo;
	private Double alertDay;
	private String prepaidFlag;
	private String recordStatus;
	private String dueDateStr;
	private boolean checkSite = false;
	private BigDecimal excAmt;
	private BigDecimal vatAmt;
	private BigDecimal incAmt;
	private BigDecimal whtAmt;
	private BigDecimal chqAmt;
	
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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
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

	public String getSiteType() {
		return siteType;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	public String getPeriodName() {
		return periodName;
	}

	public void setPeriodName(String periodName) {
		this.periodName = periodName;
	}

	public Date getDueDt() {
		return dueDt;
	}

	public void setDueDt(Date dueDt) {
		this.dueDt = dueDt;
	}

	public BigDecimal getPeriodAmt() {
		return periodAmt;
	}

	public void setPeriodAmt(BigDecimal periodAmt) {
		this.periodAmt = periodAmt;
	}

	public String getPaidFlag() {
		return paidFlag;
	}

	public void setPaidFlag(String paidFlag) {
		this.paidFlag = paidFlag;
	}

	public BigDecimal getPeriodNo() {
		return periodNo;
	}

	public void setPeriodNo(BigDecimal periodNo) {
		this.periodNo = periodNo;
	}

	public Double getAlertDay() {
		return alertDay;
	}

	public void setAlertDay(Double alertDay) {
		this.alertDay = alertDay;
	}

	
	public String getPrepaidFlag() {
		return prepaidFlag;
	}

	public void setPrepaidFlag(String prepaidFlag) {
		this.prepaidFlag = prepaidFlag;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getDueDateStr() {
		return dueDateStr;
	}

	public void setDueDateStr(String dueDateStr) {
		this.dueDateStr = dueDateStr;
	}

	@Override
	public String toString() {
		StringBuffer sbuf = new StringBuffer();
		sbuf.append("[" + this.getClass().getName() + " = ");
		sbuf.append("rowId = " + this.rowId + ",");
		sbuf.append("contractNo = " + this.contractNo + ",");
		sbuf.append("company = " + this.company + ",");
		sbuf.append("siteName = " + this.siteName + ",");
		sbuf.append("region = " + this.region + ",");
		sbuf.append("province = " + this.province + ",");
		sbuf.append("locationId = " + this.locationId + ",");
		sbuf.append("locationCode = " + this.locationCode + ",");
		sbuf.append("fromTermOfPaymentDt = " + this.fromTermOfPaymentDt + ",");
		sbuf.append("toTermOfPaymentDt = " + this.toTermOfPaymentDt + ",");
		sbuf.append("siteType = " + this.siteType + ",");
		sbuf.append("periodName = " + this.periodName + ",");
		sbuf.append("dueDt = " + this.dueDt + ",");
		sbuf.append("periodAmt = " + this.periodAmt + ",");
		sbuf.append("paidFlag = " + this.paidFlag + ",");
		sbuf.append("periodNo = " + this.periodNo + ",");
		sbuf.append("alertDay = " + this.alertDay + ",");
		sbuf.append("prepaidFlag = " + this.prepaidFlag + ",");
		sbuf.append("recordStatus = " + this.recordStatus + ",");
		sbuf.append("dueDateStr = " + this.dueDateStr);
		sbuf.append("]");
		
		return sbuf.toString();
	}

	public boolean isCheckSite() {
		return checkSite;
	}

	public void setCheckSite(boolean checkSite) {
		this.checkSite = checkSite;
	}

	public BigDecimal getExcAmt() {
		return excAmt;
	}

	public void setExcAmt(BigDecimal excAmt) {
		this.excAmt = excAmt;
	}

	public BigDecimal getVatAmt() {
		return vatAmt;
	}

	public void setVatAmt(BigDecimal vatAmt) {
		this.vatAmt = vatAmt;
	}

	public BigDecimal getIncAmt() {
		return incAmt;
	}

	public void setIncAmt(BigDecimal incAmt) {
		this.incAmt = incAmt;
	}

	public BigDecimal getWhtAmt() {
		return whtAmt;
	}

	public void setWhtAmt(BigDecimal whtAmt) {
		this.whtAmt = whtAmt;
	}

	public BigDecimal getChqAmt() {
		return chqAmt;
	}

	public void setChqAmt(BigDecimal chqAmt) {
		this.chqAmt = chqAmt;
	}

}
