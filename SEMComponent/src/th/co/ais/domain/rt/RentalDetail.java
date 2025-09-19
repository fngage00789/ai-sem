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


@Entity
@Table(name="SEM_RT_RENTAL_DETAIL", schema="SEM")
public class RentalDetail  extends AbstractDomain {


    // Fields    

     private String rowId;
     private String company;
     private String rentalMasterId;
     private String rentalCondType;
     private String expenseType;
     private Double rentalAmt;
     private String rentPeriodType;
     private Date periodStartDt;
     private Date periodEndDt;
     private String payPeriodType;
     private Integer payPeriod;
     private Integer periodYear;
     private Integer periodMonth;
     private Integer periodDay;
     private Double periodAmt;
     private String whtType;
     private Double whtRate;
     private String vatType;
     private Double vatRate;
     private String prorateFlag;
     private Long calYear;
     private Long calMonth;
     private String vendorMasterId;
     private String payeeMasterId;
     private String bookBankNo;
     private String remark;
     private Date effectiveDt;
     private Date expiredDt;
     private String expiredFlag;
     private String recordStatus;
     private Long version;
     private Integer totPeriodNo;
     
     private Double verifyAmt;
     private Double verifyBalanceAmt;
     private boolean prorate;
     private String specialRentPeriodType;
     
     private Double balanceAmt;
     private Double tmpBalanceAmt;
     private String siteRentCondId;
     private Double amtPerMonth;
     private Double amtPerYear;
     private Double amtOneTime;
   
     private Integer cntVendor;
     private Double defaultWht;
     private Double defaultVat;
     private Date pendingDt;
     
     private String expenseDesc;
     
     
    // Property accessors
    @Id
 	@GeneratedValue(generator="system-uuid")
 	@GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="RENTAL_DETAIL_ID", unique=true, nullable=false, length=50)

    public String getRowId() {
        return rowId;
    }
    
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }
    
    @Column(name="COMPANY", nullable=false, length=5)

    public String getCompany() {
        return company;
    }
    
    public void setCompany(String company) {
        this.company = company;
    }
    
    @Column(name="RENTAL_MASTER_ID", length=50)

    public String getRentalMasterId() {
        return rentalMasterId;
    }
    
    public void setRentalMasterId(String rentalMasterId) {
        this.rentalMasterId = rentalMasterId;
    }
    
    @Column(name="RENTAL_COND_TYPE", length=5)

    public String getRentalCondType() {
        return rentalCondType;
    }
    
    public void setRentalCondType(String rentalCondType) {
        this.rentalCondType = rentalCondType;
    }
    
    @Column(name="EXPENSE_TYPE", length=20)

    public String getExpenseType() {
        return expenseType;
    }
    
    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }
    
    @Column(name="RENTAL_AMT", precision=15)

    public Double getRentalAmt() {
        return rentalAmt;
    }
    
    public void setRentalAmt(Double rentalAmt) {
        this.rentalAmt = rentalAmt;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="PERIOD_START_DT", length=7)

    public Date getPeriodStartDt() {
        return periodStartDt;
    }
    
    public void setPeriodStartDt(Date periodStartDt) {
        this.periodStartDt = periodStartDt;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="PERIOD_END_DT", length=7)

    public Date getPeriodEndDt() {
        return periodEndDt;
    }
    
    public void setPeriodEndDt(Date periodEndDt) {
        this.periodEndDt = periodEndDt;
    }
    
    @Column(name="PAY_PERIOD_TYPE", length=20)

    public String getPayPeriodType() {
        return payPeriodType;
    }
    
    public void setPayPeriodType(String payPeriodType) {
        this.payPeriodType = payPeriodType;
    }
    
    @Column(name="PAY_PERIOD", precision=10, scale=0)

    public Integer getPayPeriod() {
        return payPeriod;
    }
    
    public void setPayPeriod(Integer payPeriod) {
        this.payPeriod = payPeriod;
    }
    
    @Column(name="PERIOD_YEAR")
    public Integer getPeriodYear() {
        return periodYear;
    }
    
    public void setPeriodYear(Integer periodYear) {
        this.periodYear = periodYear;
    }
    
    @Column(name="PERIOD_MONTH")
    public Integer getPeriodMonth() {
        return periodMonth;
    }
    
    public void setPeriodMonth(Integer periodMonth) {
        this.periodMonth = periodMonth;
    }
    
    @Column(name="PERIOD_DAY")
    public Integer getPeriodDay() {
		return periodDay;
	}

	public void setPeriodDay(Integer periodDay) {
		this.periodDay = periodDay;
	}

	@Column(name="PERIOD_AMT", precision=15)
    public Double getPeriodAmt() {
        return periodAmt;
    }
    
    public void setPeriodAmt(Double periodAmt) {
        this.periodAmt = periodAmt;
    }
    
    @Column(name="WHT_TYPE", length=20)

    public String getWhtType() {
        return whtType;
    }
    
    public void setWhtType(String whtType) {
        this.whtType = whtType;
    }
    
    @Column(name="WHT_RATE", precision=4)

    public Double getWhtRate() {
        return whtRate;
    }
    
    public void setWhtRate(Double whtRate) {
        this.whtRate = whtRate;
    }
    
    @Column(name="VAT_TYPE", length=20)

    public String getVatType() {
        return vatType;
    }
    
    public void setVatType(String vatType) {
        this.vatType = vatType;
    }
    
    @Column(name="VAT_RATE", precision=4)

    public Double getVatRate() {
        return vatRate;
    }
    
    public void setVatRate(Double vatRate) {
        this.vatRate = vatRate;
    }
    
    @Column(name="PRORATE_FLAG", length=1)

    public String getProrateFlag() {
        return prorateFlag;
    }
    
    public void setProrateFlag(String prorateFlag) {
        this.prorateFlag = prorateFlag;
    }
    
    @Column(name="CAL_YEAR", precision=10, scale=0)

    public Long getCalYear() {
        return calYear;
    }
    
    public void setCalYear(Long calYear) {
        this.calYear = calYear;
    }
    
    @Column(name="CAL_MONTH", precision=10, scale=0)

    public Long getCalMonth() {
        return calMonth;
    }
    
    public void setCalMonth(Long calMonth) {
        this.calMonth = calMonth;
    }
    
    @Column(name="VENDOR_MASTER_ID", length=50)

    public String getVendorMasterId() {
        return vendorMasterId;
    }
    
    public void setVendorMasterId(String vendorMasterId) {
        this.vendorMasterId = vendorMasterId;
    }
    
    @Column(name="PAYEE_MASTER_ID", length=50)

    public String getPayeeMasterId() {
        return payeeMasterId;
    }
    
    public void setPayeeMasterId(String payeeMasterId) {
        this.payeeMasterId = payeeMasterId;
    }
    
    @Column(name="REMARK", length=250)

    public String getRemark() {
        return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="EFFECTIVE_DT", length=7)

    public Date getEffectiveDt() {
        return effectiveDt;
    }
    
    public void setEffectiveDt(Date effectiveDt) {
        this.effectiveDt = effectiveDt;
    }
    
    @Column(name="RECORD_STATUS", length=1)

    public String getRecordStatus() {
        return recordStatus;
    }
    
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }
    
    @Version
	@Column(name = "VERSION", nullable = false)
    public Long getVersion() {
        return version;
    }
    
    public void setVersion(Long version) {
        this.version = version;
    }
    
    @Column(name="CREATE_DT")
    public Date getCreateDt() {
        return createDt;
    }
    
    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }
    
    @Column(name="CREATE_BY", length=50)
    public String getCreateBy() {
        return createBy;
    }
    
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Column(name="UPDATE_DT")
    public Date getUpdateDt() {
        return updateDt;
    }
    
    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }
    
    @Column(name="UPDATE_BY", length=50)
    public String getUpdateBy() {
        return updateBy;
    }
    
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Column(name="RENT_PERIOD_TYPE", length=2)
	public String getRentPeriodType() {
		return rentPeriodType;
	}

	public void setRentPeriodType(String rentPeriodType) {
		this.rentPeriodType = rentPeriodType;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="EXPIRED_DT", length=7)
	public Date getExpiredDt() {
		return expiredDt;
	}

	public void setExpiredDt(Date expiredDt) {
		this.expiredDt = expiredDt;
	}

	@Column(name="EXPIRED_FLAG", length=1)
	public String getExpiredFlag() {
		return expiredFlag;
	}

	public void setExpiredFlag(String expiredFlag) {
		this.expiredFlag = expiredFlag;
	}
	
	@Column(name="TOT_PERIOD_NO", precision=4)
	public Integer getTotPeriodNo() {
		return totPeriodNo;
	}

	public void setTotPeriodNo(Integer totPeriodNo) {
		this.totPeriodNo = totPeriodNo;
	}

	@Transient
	public Double getVerifyAmt() {
		return verifyAmt;
	}

	public void setVerifyAmt(Double verifyAmt) {
		this.verifyAmt = verifyAmt;
	}

	@Transient
	public Double getVerifyBalanceAmt() {
		return verifyBalanceAmt;
	}

	public void setVerifyBalanceAmt(Double verifyBalanceAmt) {
		this.verifyBalanceAmt = verifyBalanceAmt;
	}

	@Transient
	public boolean isProrate() {
		return prorate;
	}

	public void setProrate(boolean prorate) {
		this.prorate = prorate;
	}
    
    @Transient
    public String getBookBankNo() {
        return bookBankNo;
    }
    
    public void setBookBankNo(String bookBankNo) {
        this.bookBankNo = bookBankNo;
    }

    @Transient
	public String getSpecialRentPeriodType() {
		return specialRentPeriodType;
	}

	public void setSpecialRentPeriodType(String specialRentPeriodType) {
		this.specialRentPeriodType = specialRentPeriodType;
	}

	@Transient
	public Double getBalanceAmt() {
		return balanceAmt;
	}

	public void setBalanceAmt(Double balanceAmt) {
		this.balanceAmt = balanceAmt;
	}

	@Transient
	public Double getTmpBalanceAmt() {
		return tmpBalanceAmt;
	}

	public void setTmpBalanceAmt(Double tmpBalanceAmt) {
		this.tmpBalanceAmt = tmpBalanceAmt;
	}

	@Transient
	public String getSiteRentCondId() {
		return siteRentCondId;
	}

	public void setSiteRentCondId(String siteRentCondId) {
		this.siteRentCondId = siteRentCondId;
	}

	@Transient
	public Double getAmtPerMonth() {
		return amtPerMonth;
	}

	public void setAmtPerMonth(Double amtPerMonth) {
		this.amtPerMonth = amtPerMonth;
	}

	@Transient
	public Double getAmtPerYear() {
		return amtPerYear;
	}

	public void setAmtPerYear(Double amtPerYear) {
		this.amtPerYear = amtPerYear;
	}

	@Transient
	public Integer getCntVendor() {
		return cntVendor;
	}

	public void setCntVendor(Integer cntVendor) {
		this.cntVendor = cntVendor;
	}
	@Transient
	public Double getAmtOneTime() {
		return amtOneTime;
	}

	public void setAmtOneTime(Double amtOneTime) {
		this.amtOneTime = amtOneTime;
	}
	@Transient
	public Double getDefaultWht() {
		return defaultWht;
	}

	public void setDefaultWht(Double defaultWht) {
		this.defaultWht = defaultWht;
	}
	@Transient
	public Double getDefaultVat() {
		return defaultVat;
	}

	public void setDefaultVat(Double defaultVat) {
		this.defaultVat = defaultVat;
	}
	
	@Temporal(TemporalType.DATE)
    @Column(name="PENDING_DT", length=7)
	public Date getPendingDt() {
		return pendingDt;
	}

	public void setPendingDt(Date pendingDt) {
		this.pendingDt = pendingDt;
	}

	 @Column(name="EXPENSE_DESC", length=100)
	public String getExpenseDesc() {
		return expenseDesc;
	}

	public void setExpenseDesc(String expenseDesc) {
		this.expenseDesc = expenseDesc;
	}
	
	
}