package th.co.ais.domain.rt;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;

/**
 * SemRtReturnDeposit entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SEM_RT_RETURN_DEPOSIT", schema = "SEM")
public class ReturnDeposit extends AbstractDomain {

	// Fields

	private String depositDetailId;
	private String rentalPaymentId;
	private String bgMasterId;
	private String company;
	private String siteInfoId;
	private String expenseType;
	private String depositType;
	private Double depositReturnAmt;
	private String returnDepositStatus;
	private String remark;
	private String docClear;
	private Date docClearDt;
	private String reason;
	private String recordStatus;
	private Long version;
	private Date bgReturnDt;

	// Property accessors
	@Id
	@GeneratedValue(generator="system-uuid")
 	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "RETURN_DEPOSIT_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "DEPOSIT_DETAIL_ID", length = 50)
	public String getDepositDetailId() {
		return this.depositDetailId;
	}

	public void setDepositDetailId(String depositDetailId) {
		this.depositDetailId = depositDetailId;
	}

	@Column(name = "RENTAL_PAYMENT_ID", length = 50)
	public String getRentalPaymentId() {
		return this.rentalPaymentId;
	}

	public void setRentalPaymentId(String rentalPaymentId) {
		this.rentalPaymentId = rentalPaymentId;
	}

	@Column(name = "BG_MASTER_ID", length = 50)
	public String getBgMasterId() {
		return this.bgMasterId;
	}

	public void setBgMasterId(String bgMasterId) {
		this.bgMasterId = bgMasterId;
	}

	@Column(name = "COMPANY", length = 5)
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "SITE_INFO_ID", length = 50)
	public String getSiteInfoId() {
		return this.siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	@Column(name = "EXPENSE_TYPE", length = 5)
	public String getExpenseType() {
		return this.expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	@Column(name = "DEPOSIT_TYPE", length = 20)
	public String getDepositType() {
		return this.depositType;
	}

	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}

	@Column(name = "DEPOSIT_RETURN_AMT", precision = 15)
	public Double getDepositReturnAmt() {
		return this.depositReturnAmt;
	}

	public void setDepositReturnAmt(Double depositReturnAmt) {
		this.depositReturnAmt = depositReturnAmt;
	}

	@Column(name = "RETURN_DEPOSIT_STATUS", length = 20)
	public String getReturnDepositStatus() {
		return this.returnDepositStatus;
	}

	public void setReturnDepositStatus(String returnDepositStatus) {
		this.returnDepositStatus = returnDepositStatus;
	}

	@Column(name = "REMARK", length = 20)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "DOC_CLEAR", length = 10)
	public String getDocClear() {
		return this.docClear;
	}

	public void setDocClear(String docClear) {
		this.docClear = docClear;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "BG_RETURN_DT", length = 7)
	public Date getBgReturnDt() {
		return bgReturnDt;
	}

	public void setBgReturnDt(Date bgReturnDt) {
		this.bgReturnDt = bgReturnDt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DOC_CLEAR_DT", length = 7)
	public Date getDocClearDt() {
		return this.docClearDt;
	}

	public void setDocClearDt(Date docClearDt) {
		this.docClearDt = docClearDt;
	}

	@Column(name = "REASON", length = 250)
	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

}