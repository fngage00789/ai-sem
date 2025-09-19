package th.co.ais.domain.el;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.domain.gm.Province;
import th.co.ais.domain.gm.Region;

@Entity
@Table(name="SEM_EL_PRIVATE_PREPAID", schema="SEM")
public class PrivatePrepaid extends AbstractDomain {

	//private static final long serialVersionUID = -8588805686766738860L;
	private static final SimpleDateFormat exportFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));

	private String rowId;
	private MeterInfo meterInfoId;
	private String contractNo;
	private String electricUseType;
	private String company;
	private String locationId;
	private String locationCode;
	private String siteType;
	private String siteName;
	private Region region;
	private Province province;
	private String meterId;
	private String referMeterId;
	private Date termOfPaymentDt;
	private Date formTermOfPaymentDt;
	private Date toTermOfPaymentDt;
	private BigDecimal periodNo;
	private BigDecimal periodAmt;
	private String periodName;
	private Date dueDt;
	private Date pDate;
	private Date lDate;
	private BigDecimal pRead;
	private BigDecimal lRead;
	private BigDecimal kwhTotal;
	private String docType;
	private String docNo;
	private Date docDt;
	private BigDecimal payAMt;
	private String vatType;
	private BigDecimal vatRate;
	private BigDecimal vatAmt;
	private String whtType;
	private BigDecimal whtRate;
	private BigDecimal whtAmt;
	private BigDecimal excludeVatAmt;
	private BigDecimal includeVatAmt;
	private BigDecimal chqAmt;
	private BigDecimal accureAmt;
	private String remark;
	private String prepaidFlag;
	private String paidFlag;	
	private String recordStatus;
	
	
	private String regionTxt;
	private String provinceTxt;
	private String formTermOfPaymentMonth;
	private String toTermOfPaymentMonth;
	private String formTermOfPaymentYear;
	private String toTermOfPaymentYear;
	private String termOfPaymentDisplay;
	private String electricUseTypeDisplay;
	private boolean selected;
	private String termOfPaymentDtStr;
	
	private BigDecimal groupNo;
	
	private String dueDtTH;
	private String toTermOfPaymentDtTH;
	private String fromTermOfPaymentDtTH;
	
	@Id
  	@GeneratedValue(generator="system-uuid")
  	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "PRIVATE_PREPAID_ID")	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "METER_INFO_ID", nullable = false)
	public MeterInfo getMeterInfoId() {
		return meterInfoId;
	}
	public void setMeterInfoId(MeterInfo meterInfoId) {
		this.meterInfoId = meterInfoId;
	}
	
	@Column(name = "GROUP_NO")
	public BigDecimal getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(BigDecimal groupNo) {
		this.groupNo = groupNo;
	}
	@Column(name = "CONTRACT_NO")
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	
	@Column(name = "ELECTRIC_USE_TYPE")
	public String getElectricUseType() {
		return electricUseType;
	}
	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}
	
	@Column(name = "COMPANY")
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Column(name = "LOCATION_ID")
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	
	@Column(name = "LOCATION_CODE")
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	
	@Column(name = "SITE_TYPE")
	public String getSiteType() {
		return siteType;
	}
	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}
	
	@Column(name = "SITE_NAME")
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REGION", nullable = false)
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROVINCE", nullable = false)
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	
	@Column(name = "METER_ID")
	public String getMeterId() {
		return meterId;
	}
	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}
	
	@Column(name = "REFER_METER_ID")
	public String getReferMeterId() {
		return referMeterId;
	}
	public void setReferMeterId(String referMeterId) {
		this.referMeterId = referMeterId;
	}
	
	@Column(name = "TERM_OF_PAYMENT_DT")
	public Date getTermOfPaymentDt() {
		return termOfPaymentDt;
	}
	public void setTermOfPaymentDt(Date termOfPaymentDt) {
		this.termOfPaymentDt = termOfPaymentDt;
	}
	
	@Column(name = "FROM_TERM_OF_PAYMENT_DT")
	public Date getFormTermOfPaymentDt() {
		return formTermOfPaymentDt;
	}
	public void setFormTermOfPaymentDt(Date formTermOfPaymentDt) {
		this.formTermOfPaymentDt = formTermOfPaymentDt;
	}
	
	@Column(name = "TO_TERM_OF_PAYMENT_DT")
	public Date getToTermOfPaymentDt() {
		return toTermOfPaymentDt;
	}
	public void setToTermOfPaymentDt(Date toTermOfPaymentDt) {
		this.toTermOfPaymentDt = toTermOfPaymentDt;
	}
	
	@Column(name = "PERIOD_NO")
	public BigDecimal getPeriodNo() {
		return periodNo;
	}
	public void setPeriodNo(BigDecimal periodNo) {
		this.periodNo = periodNo;
	}
	
	@Column(name = "PERIOD_AMT")
	public BigDecimal getPeriodAmt() {
		return periodAmt;
	}
	public void setPeriodAmt(BigDecimal periodAmt) {
		this.periodAmt = periodAmt;
	}
	
	@Column(name = "PERIOD_NAME")
	public String getPeriodName() {
		return periodName;
	}
	public void setPeriodName(String periodName) {
		this.periodName = periodName;
	}
	
	@Column(name = "DUE_DT")
	public Date getDueDt() {
		return dueDt;
	}
	public void setDueDt(Date dueDt) {
		this.dueDt = dueDt;
	}
	
	@Column(name = "P_DATE")
	public Date getpDate() {
		return pDate;
	}
	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}
	
	@Column(name = "L_DATE")
	public Date getlDate() {
		return lDate;
	}
	public void setlDate(Date lDate) {
		this.lDate = lDate;
	}
	
	@Column(name = "P_READ")
	public BigDecimal getpRead() {
		return pRead;
	}
	public void setpRead(BigDecimal pRead) {
		this.pRead = pRead;
	}
	
	@Column(name = "L_READ")
	public BigDecimal getlRead() {
		return lRead;
	}
	public void setlRead(BigDecimal lRead) {
		this.lRead = lRead;
	}
	
	@Column(name = "KWH_TOTAL")
	public BigDecimal getKwhTotal() {
		return kwhTotal;
	}
	public void setKwhTotal(BigDecimal kwhTotal) {
		this.kwhTotal = kwhTotal;
	}
	
	@Column(name = "DOC_TYPE")
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	
	@Column(name = "DOC_NO")
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	
	@Column(name = "DOC_DT")
	public Date getDocDt() {
		return docDt;
	}
	public void setDocDt(Date docDt) {
		this.docDt = docDt;
	}
	
	@Column(name = "PAY_AMT")
	public BigDecimal getPayAMt() {
		return payAMt;
	}
	public void setPayAMt(BigDecimal payAMt) {
		this.payAMt = payAMt;
	}
	
	@Column(name = "VAT_TYPE")
	public String getVatType() {
		return vatType;
	}
	public void setVatType(String vatType) {
		this.vatType = vatType;
	}
	
	@Column(name = "VAT_RATE")
	public BigDecimal getVatRate() {
		return vatRate;
	}
	public void setVatRate(BigDecimal vatRate) {
		this.vatRate = vatRate;
	}
	
	@Column(name = "VAT_AMT")
	public BigDecimal getVatAmt() {
		return vatAmt;
	}
	public void setVatAmt(BigDecimal vatAmt) {
		this.vatAmt = vatAmt;
	}
	
	@Column(name = "WHT_TYPE")
	public String getWhtType() {
		return whtType;
	}
	public void setWhtType(String whtType) {
		this.whtType = whtType;
	}
	
	@Column(name = "WHT_RATE")
	public BigDecimal getWhtRate() {
		return whtRate;
	}
	public void setWhtRate(BigDecimal whtRate) {
		this.whtRate = whtRate;
	}
	
	@Column(name = "WHT_AMT")
	public BigDecimal getWhtAmt() {
		return whtAmt;
	}
	public void setWhtAmt(BigDecimal whtAmt) {
		this.whtAmt = whtAmt;
	}
	
	@Column(name = "EXCLUDE_VAT_AMT")
	public BigDecimal getExcludeVatAmt() {
		return excludeVatAmt;
	}
	public void setExcludeVatAmt(BigDecimal excludeVatAmt) {
		this.excludeVatAmt = excludeVatAmt;
	}
	
	@Column(name = "INCLUDE_VAT_AMT")
	public BigDecimal getIncludeVatAmt() {
		return includeVatAmt;
	}
	public void setIncludeVatAmt(BigDecimal includeVatAmt) {
		this.includeVatAmt = includeVatAmt;
	}
	
	@Column(name = "CHQ_AMT")
	public BigDecimal getChqAmt() {
		return chqAmt;
	}
	public void setChqAmt(BigDecimal chqAmt) {
		this.chqAmt = chqAmt;
	}
	
	@Column(name = "ACCRUE_AMT")
	public BigDecimal getAccureAmt() {
		return accureAmt;
	}
	public void setAccureAmt(BigDecimal accureAmt) {
		this.accureAmt = accureAmt;
	}
	
	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "PREPAID_FLAG")
	public String getPrepaidFlag() {
		return prepaidFlag;
	}
	
	public void setPrepaidFlag(String prepaidFlag) {
		this.prepaidFlag = prepaidFlag;
	}
	
	@Column(name = "PAID_FLAG")
	public String getPaidFlag() {
		return paidFlag;
	}
	public void setPaidFlag(String paidFlag) {
		this.paidFlag = paidFlag;
	}
	
	@Column(name = "RECORD_STATUS")
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	@Override
	@Column(name="CREATE_BY")
	public String getCreateBy() {
		return this.createBy;
	}
	@Override
	@Column(name="CREATE_DT")
	public Date getCreateDt() {
		return this.createDt;
	}

	@Override
	@Column(name="UPDATE_BY")
	public String getUpdateBy() {
		return this.updateBy;
	}

	@Override
	@Column(name="UPDATE_DT")
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
	
	@Transient
	public String getRegionTxt() {
		return regionTxt;
	}
	public void setRegionTxt(String regionTxt) {
		this.regionTxt = regionTxt;
	}
	
	@Transient
	public String getProvinceTxt() {
		return provinceTxt;
	}
	public void setProvinceTxt(String provinceTxt) {
		this.provinceTxt = provinceTxt;
	}
	
	@Transient
	public String getFormTermOfPaymentMonth() {
		return formTermOfPaymentMonth;
	}
	public void setFormTermOfPaymentMonth(String formTermOfPaymentMonth) {
		this.formTermOfPaymentMonth = formTermOfPaymentMonth;
	}
	
	@Transient
	public String getToTermOfPaymentMonth() {
		return toTermOfPaymentMonth;
	}
	public void setToTermOfPaymentMonth(String toTermOfPaymentMonth) {
		this.toTermOfPaymentMonth = toTermOfPaymentMonth;
	}
	
	@Transient
	public String getFormTermOfPaymentYear() {
		return formTermOfPaymentYear;
	}	
	public void setFormTermOfPaymentYear(String formTermOfPaymentYear) {
		this.formTermOfPaymentYear = formTermOfPaymentYear;
	}
	
	@Transient
	public String getToTermOfPaymentYear() {
		return toTermOfPaymentYear;
	}
	public void setToTermOfPaymentYear(String toTermOfPaymentYear) {
		this.toTermOfPaymentYear = toTermOfPaymentYear;
	}
	
	@Transient
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	@Transient
	public String getTermOfPaymentDisplay() {
		return termOfPaymentDisplay;
	}
	public void setTermOfPaymentDisplay(String termOfPaymentDisplay) {
		this.termOfPaymentDisplay = termOfPaymentDisplay;
	}
	
	@Transient
	public String getElectricUseTypeDisplay() {
		return electricUseTypeDisplay;
	}
	
	public void setElectricUseTypeDisplay(String electricUseTypeDisplay) {
		this.electricUseTypeDisplay = electricUseTypeDisplay;
	}
	
	@Transient
	public String getTermOfPaymentDtStr() {
		return termOfPaymentDtStr;
	}
	
	public void setTermOfPaymentDtStr(String termOfPaymentDtStr) {
		this.termOfPaymentDtStr = termOfPaymentDtStr;
	}
	@Transient
	public String getDueDtTH() {	
		return dueDt!=null?exportFormat.format(dueDt):"";
	}
	public void setDueDtTH(String dueDtTH) {
		this.dueDtTH = dueDtTH;
	}
	@Transient
	public String getToTermOfPaymentDtTH() {
		//return toTermOfPaymentDtTH;
		return toTermOfPaymentDt!=null?exportFormat.format(toTermOfPaymentDt):"";
	}
	public void setToTermOfPaymentDtTH(String toTermOfPaymentDtTH) {
		this.toTermOfPaymentDtTH = toTermOfPaymentDtTH;
	}
	@Transient
	public String getFromTermOfPaymentDtTH() {
		//return fromTermOfPaymentDtTH;
		return formTermOfPaymentDt!=null?exportFormat.format(formTermOfPaymentDt):"";
	}
	public void setFromTermOfPaymentDtTH(String fromTermOfPaymentDtTH) {
		this.fromTermOfPaymentDtTH = fromTermOfPaymentDtTH;
	}
	
	
	
}
