package th.co.ais.domain.rt;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;

/**
 * SemRtDepositDetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SEM_RT_DEPOSIT_DETAIL", schema = "SEM")
public class DepositDetail extends AbstractDomain {

	// Fields

	private String rowId;
	private String company;
	private String rentalMasterId;
	private String depositCondType;
	private String depositType;
	private String expenseType;
	private Double periodYear;
	private Double periodMonth;
	private Double periodDay;
	private Double depositAmt;
	private String vatType;
	private Double vatRate;
	private Double vatAmt;
	private Double depositExcAmt;
	private Double depositIncAmt;
	private String vendorMasterId;
	private String payeeMasterId;
	private String remark;
	private String recordStatus;
	private Long version;
	private Date periodStDt;
	private Date periodEndDt;
	private String bgMasterId;
	private String whtType;
	private Double whtRate;
	private Double whtAmt;
	
	
	private Double depositRentAmt;
	private String bookBankNo;

	// Property accessors
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "DEPOSIT_DETAIL_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "COMPANY", nullable = false, length = 5)
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "RENTAL_MASTER_ID", length = 50)
	public String getRentalMasterId() {
		return this.rentalMasterId;
	}

	public void setRentalMasterId(String rentalMasterId) {
		this.rentalMasterId = rentalMasterId;
	}

	@Column(name = "DEPOSIT_COND_TYPE", length = 20)
	public String getDepositCondType() {
		return this.depositCondType;
	}

	public void setDepositCondType(String depositCondType) {
		this.depositCondType = depositCondType;
	}

	@Column(name = "DEPOSIT_TYPE", length = 20)
	public String getDepositType() {
		return this.depositType;
	}

	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}

	@Column(name = "EXPENSE_TYPE", length = 20)
	public String getExpenseType() {
		return this.expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	@Column(name = "PERIOD_YEAR", precision = 22, scale = 0)
	public Double getPeriodYear() {
		return this.periodYear;
	}

	public void setPeriodYear(Double periodYear) {
		this.periodYear = periodYear;
	}

	@Column(name = "PERIOD_MONTH", precision = 22, scale = 0)
	public Double getPeriodMonth() {
		return this.periodMonth;
	}

	public void setPeriodMonth(Double periodMonth) {
		this.periodMonth = periodMonth;
	}
	
	@Column(name = "PERIOD_DAY", precision = 22, scale = 0)
	public Double getPeriodDay() {
		return periodDay;
	}

	public void setPeriodDay(Double periodDay) {
		this.periodDay = periodDay;
	}

	@Column(name = "DEPOSIT_AMT", precision = 15)
	public Double getDepositAmt() {
		return this.depositAmt;
	}

	public void setDepositAmt(Double depositAmt) {
		this.depositAmt = depositAmt;
	}

	@Column(name = "DEPOSIT_RENT_AMT", precision = 15)
	public Double getDepositRentAmt() {
		return depositRentAmt;
	}

	public void setDepositRentAmt(Double depositRentAmt) {
		this.depositRentAmt = depositRentAmt;
	}

	@Column(name = "VAT_TYPE", length = 20)
	public String getVatType() {
		return this.vatType;
	}

	public void setVatType(String vatType) {
		this.vatType = vatType;
	}

	@Column(name = "VAT_RATE", precision = 4)
	public Double getVatRate() {
		return this.vatRate;
	}

	public void setVatRate(Double vatRate) {
		this.vatRate = vatRate;
	}

	@Column(name = "VAT_AMT", precision = 15)
	public Double getVatAmt() {
		return this.vatAmt;
	}

	public void setVatAmt(Double vatAmt) {
		this.vatAmt = vatAmt;
	}

	@Column(name = "DEPOSIT_EXC_AMT", precision = 15)
	public Double getDepositExcAmt() {
		return this.depositExcAmt;
	}

	public void setDepositExcAmt(Double depositExcAmt) {
		this.depositExcAmt = depositExcAmt;
	}

	@Column(name = "DEPOSIT_INC_AMT", precision = 15)
	public Double getDepositIncAmt() {
		return this.depositIncAmt;
	}

	public void setDepositIncAmt(Double depositIncAmt) {
		this.depositIncAmt = depositIncAmt;
	}

	@Column(name = "VENDOR_MASTER_ID", length = 50)
	public String getVendorMasterId() {
		return this.vendorMasterId;
	}

	public void setVendorMasterId(String vendorMasterId) {
		this.vendorMasterId = vendorMasterId;
	}

	@Column(name = "PAYEE_MASTER_ID", length = 50)
	public String getPayeeMasterId() {
		return this.payeeMasterId;
	}

	public void setPayeeMasterId(String payeeMasterId) {
		this.payeeMasterId = payeeMasterId;
	}

	@Column(name = "REMARK", length = 250)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "RECORD_STATUS", length = 1)
	public String getRecordStatus() {
		return this.recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	@Version
	@Column(name = "VERSION", nullable = false)
	public Long getVersion() {
		return this.version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	@Column(name = "CREATE_DT")
	public Date getCreateDt() {
		return this.createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	@Override
	@Column(name = "CREATE_BY", length = 50)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Override
	@Column(name = "UPDATE_DT")
	public Date getUpdateDt() {
		return this.updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	@Override
	@Column(name = "UPDATE_BY", length = 50)
	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
	@Temporal(TemporalType.DATE)
    @Column(name="PERIOD_START_DT", length=7)
	public Date getPeriodStDt() {
		return periodStDt;
	}

	public void setPeriodStDt(Date periodStDt) {
		this.periodStDt = periodStDt;
	}
	
	@Temporal(TemporalType.DATE)
    @Column(name="PERIOD_END_DT", length=7)
	public Date getPeriodEndDt() {
		return periodEndDt;
	}

	public void setPeriodEndDt(Date periodEndDt) {
		this.periodEndDt = periodEndDt;
	}

	@Column(name = "BG_MASTER_ID", length=50)
	public String getBgMasterId() {
		return bgMasterId;
	}

	public void setBgMasterId(String bgMasterId) {
		this.bgMasterId = bgMasterId;
	}

	@Transient
	public String getBookBankNo() {
		return bookBankNo;
	}

	public void setBookBankNo(String bookBankNo) {
		this.bookBankNo = bookBankNo;
	}
	@Column(name = "WHT_TYPE", length=20)
	public String getWhtType() {
		return whtType;
	}

	public void setWhtType(String whtType) {
		this.whtType = whtType;
	}
	@Column(name = "WHT_RATE", precision = 4)
	public Double getWhtRate() {
		return whtRate;
	}

	public void setWhtRate(Double whtRate) {
		this.whtRate = whtRate;
	}
	@Column(name = "WHT_AMT", precision = 15)
	public Double getWhtAmt() {
		return whtAmt;
	}

	public void setWhtAmt(Double whtAmt) {
		this.whtAmt = whtAmt;
	}

}