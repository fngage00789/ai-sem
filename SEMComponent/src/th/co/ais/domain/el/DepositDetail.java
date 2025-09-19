package th.co.ais.domain.el;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;

@Entity(name="th.co.ais.domain.el.DepositDetail")
@Table(name="SEM_RT_DEPOSIT_DETAIL", schema="SEM")
public class DepositDetail extends AbstractDomain {

	private static final long serialVersionUID = -7669724841564935866L;

	private String rowId;
	private Management electricId;
//	private String depositDetailFlag;
	private String depositType;
	private String expenseType;
//	private String bookBankNo;
	private String vendorMasterId;
	private String payeeMasterId;
//	private String payeeName;
//	private BigDecimal depositSubtotAmt;
//	private BigDecimal depositNetAmt;
	private BigDecimal vatAmt;
	private BigDecimal vatRat;
	private String vatType;
	private String vatTypeLabel;	
//	private BigDecimal periodAmt;
//	private String payPeriodType;
//	private BigDecimal payPeriod;
//	private String periodType;
//	private Date periodStartDt;
//	private Date periodEndDt;
//	private BigDecimal periodInterval;
	private BigDecimal depositAmt;	
	private BigDecimal version;
//	private BgMaster bgMasterId;
	private String recordStatus;	
	private BigDecimal depositExcludeAmt;	
	private BigDecimal depositIncludeAmt;	
//	private BigDecimal depositExcludeVat;
//	private BigDecimal depositIncludeVat;
	private String depositSpecialFlag;
	private String company;
	private String depositCondType;
	private BigDecimal periodYear;
	private BigDecimal periodMonth;
	private String remark;

	private Set<BgMaster> bgMasters;	
	private boolean selected;		
	
	@Id
  	@GeneratedValue(generator="system-uuid")
  	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "DEPOSIT_DETAIL_ID")
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	@Column(name = "DEPOSIT_EXC_AMT")		
	public BigDecimal getDepositExcludeAmt() {		
		return depositExcludeAmt;	
		}	
	public void setDepositExcludeAmt(BigDecimal depositExcludeAmt) {
		this.depositExcludeAmt = depositExcludeAmt;	
		}	
	@Column(name = "DEPOSIT_INC_AMT")	
	public BigDecimal getDepositIncludeAmt() {
		return depositIncludeAmt;	
		}	
	public void setDepositIncludeAmt(BigDecimal depositIncludeAmt) {
		this.depositIncludeAmt = depositIncludeAmt;	
		}
	
	@OneToMany(mappedBy="depositDetailId", fetch=FetchType.EAGER)
	public Set<BgMaster> getBgMasters() {
		return bgMasters;
	}

	public void setBgMasters(Set<BgMaster> bgMasters) {
		this.bgMasters = bgMasters;
	}
	
//	@Column(name = "DEPOSIT_DETAIL_FLAG")
//	public String getDepositDetailFlag() {
//		return depositDetailFlag;
//	}
//	public void setDepositDetailFlag(String depositDetailFlag) {
//		this.depositDetailFlag = depositDetailFlag;
//	}
	
	@Column(name = "DEPOSIT_TYPE")
	public String getDepositType() {
		return depositType;
	}
	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}
	
	@Column(name = "EXPENSE_TYPE")
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	
//	@Column(name = "BOOK_BANK_NO")
//	public String getBookBankNo() {
//		return bookBankNo;
//	}
//	public void setBookBankNo(String bookBankNo) {
//		this.bookBankNo = bookBankNo;
//	}
	
	@Column(name = "VENDOR_MASTER_ID")
	public String getVendorMasterId() {
		return vendorMasterId;
	}
	public void setVendorMasterId(String vendorMasterId) {
		this.vendorMasterId = vendorMasterId;
	}
	
	@Column(name = "PAYEE_MASTER_ID")
	public String getPayeeMasterId() {
		return payeeMasterId;
	}
	public void setPayeeMasterId(String payeeMasterId) {
		this.payeeMasterId = payeeMasterId;
	}
	
//	@Column(name = "PAYEE_NAME")
//	public String getPayeeName() {
//		return payeeName;
//	}
//	public void setPayeeName(String payeeName) {
//		this.payeeName = payeeName;
//	}
//	
//	@Column(name = "DEPOSIT_SUBTOT_AMT")
//	public BigDecimal getDepositSubtotAmt() {
//		return depositSubtotAmt;
//	}
//	public void setDepositSubtotAmt(BigDecimal depositSubtotAmt) {
//		this.depositSubtotAmt = depositSubtotAmt;
//	}
//	
//	@Column(name = "DEPOSIT_NET_AMT")
//	public BigDecimal getDepositNetAmt() {
//		return depositNetAmt;
//	}
//	public void setDepositNetAmt(BigDecimal depositNetAmt) {
//		this.depositNetAmt = depositNetAmt;
//	}
	
	@Column(name = "VAT_AMT")
	public BigDecimal getVatAmt() {
		return vatAmt;
	}
	public void setVatAmt(BigDecimal vatAmt) {
		this.vatAmt = vatAmt;
	}
	
	@Column(name = "VAT_RATE")
	public BigDecimal getVatRat() {
		return vatRat;
	}
	public void setVatRat(BigDecimal vatRat) {
		this.vatRat = vatRat;
	}
	
	@Column(name = "VAT_TYPE")
	public String getVatType() {
		return vatType;
	}
	public void setVatType(String vatType) {
		this.vatType = vatType;
	}
	
//	@Column(name = "PERIOD_AMT")
//	public BigDecimal getPeriodAmt() {
//		return periodAmt;
//	}
//	public void setPeriodAmt(BigDecimal periodAmt) {
//		this.periodAmt = periodAmt;
//	}
//	
//	@Column(name = "PAY_PERIOD_TYPE")
//	public String getPayPeriodType() {
//		return payPeriodType;
//	}
//	public void setPayPeriodType(String payPeriodType) {
//		this.payPeriodType = payPeriodType;
//	}
//	
//	@Column(name = "PAY_PERIOD")
//	public BigDecimal getPayPeriod() {
//		return payPeriod;
//	}
//	public void setPayPeriod(BigDecimal payPeriod) {
//		this.payPeriod = payPeriod;
//	}
	
	/*@Column(name = "PERIOD_TYPE")
	public String getPeriodType() {
		return periodType;
	}
	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}*/
	
	/*@Column(name = "PERIOD_START_DT")
	public Date getPeriodStartDt() {
		return periodStartDt;
	}
	public void setPeriodStartDt(Date periodStartDt) {
		this.periodStartDt = periodStartDt;
	}
	
	@Column(name = "PERIOD_END_DT")
	public Date getPeriodEndDt() {
		return periodEndDt;
	}
	public void setPeriodEndDt(Date periodEndDt) {
		this.periodEndDt = periodEndDt;
	}
	
	@Column(name = "PERIOD_INTERVAL")
	public BigDecimal getPeriodInterval() {
		return periodInterval;
	}
	public void setPeriodInterval(BigDecimal periodInterval) {
		this.periodInterval = periodInterval;
	}*/
	
	@Column(name = "DEPOSIT_AMT")
	public BigDecimal getDepositAmt() {		
		return depositAmt;	
		}
	public void setDepositAmt(BigDecimal depositAmt) {
		this.depositAmt = depositAmt;	
		}
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "BG_MASTER_ID")
//	public BgMaster getBgMasterId() {
//		return bgMasterId;
//	}
//	public void setBgMasterId(BgMaster bgMasterId) {
//		this.bgMasterId = bgMasterId;
//	}
	
	@Column(name = "VERSION")
	public BigDecimal getVersion() {
		return version;
	}
	public void setVersion(BigDecimal version) {
		this.version = version;
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
	public void setCreateBy(String createBy) {		
		this.createBy = createBy;			
	}		
		@Override	
		@Column(name="CREATE_DT")
	public Date getCreateDt() {
		return this.createDt;
	}
		@Override	
		public void setCreateDt(Date createDt) {		
			this.createDt = createDt;			
			}
	@Override
	@Column(name="UPDATE_BY")
	public String getUpdateBy() {
		return this.updateBy;
	}
		@Override	
		public void setUpdateBy(String updateBy) {		
			this.updateBy = updateBy; 			
			}
	@Override
	@Column(name="UPDATE_DT")
	public Date getUpdateDt() {
		return this.updateDt;
	}
	
	@Override
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
		
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ELECTRIC_ID")	
	public Management getElectricId() {
		return electricId;
	}
		public void setElectricId(Management electricId) {
		this.electricId = electricId;
	}
	
	@Column(name = "COMPANY")
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
//	@Column(name = "DEPOSIT_EXCLUDE_VAT")
//	public BigDecimal getDepositExcludeVat() {
//		return depositExcludeVat;
//	}
//	public void setDepositExcludeVat(BigDecimal depositExcludeVat) {
//		this.depositExcludeVat = depositExcludeVat;
//	}
//	@Column(name = "DEPOSIT_INCLUDE_VAT")
//	public BigDecimal getDepositIncludeVat() {
//		return depositIncludeVat;
//	}
//	public void setDepositIncludeVat(BigDecimal depositIncludeVat) {
//		this.depositIncludeVat = depositIncludeVat;
//	}
	@Column(name = "DEPOSIT_SPECIAL_FLAG")
	public String getDepositSpecialFlag() {
		return depositSpecialFlag;
	}	
	public void setDepositSpecialFlag(String depositSpecialFlag) {
		this.depositSpecialFlag = depositSpecialFlag;
	}
	@Transient
	public String getVatTypeLabel() {
		return vatTypeLabel;
	}
	
	public void setVatTypeLabel(String vatTypeLabel) {
		this.vatTypeLabel = vatTypeLabel;
	}
	
	@Transient
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	@Column(name = "DEPOSIT_COND_TYPE")
	public String getDepositCondType() {
		return depositCondType;
	}
	public void setDepositCondType(String depositCondType) {
		this.depositCondType = depositCondType;
	}
	
	@Column(name = "PERIOD_MONTH")
	public BigDecimal getPeriodMonth() {
		return periodMonth;
	}
	public void setPeriodMonth(BigDecimal periodMonth) {
		this.periodMonth = periodMonth;
	}
	
	@Column(name = "PERIOD_YEAR")
	public BigDecimal getPeriodYear() {
		return periodYear;
	}
	public void setPeriodYear(BigDecimal periodYear) {
		this.periodYear = periodYear;
	}
	
	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}	
}
