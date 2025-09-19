package th.co.ais.domain.si;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;


@Entity
@Table(name="SEM_SI_SITE_DEPOSIT", schema="SEM")
public class Deposit   extends AbstractDomain {


    // Fields    
	 private static final long serialVersionUID = -4036761751234048706L;
	 private String rowId;
     private String siteInfoId;
     private String expenseType;
     private String depositType;
     private Double depositAmt;
     private String vatType;
     private String remark;
     private String newStatus;
     private String recordStatus;
     private String detail;
     private Long version;
     private Integer seqNo;
     private String depositCondType;
     
     //added by NEW 2018/09/07
     private Double depositAmtOld;
     private String depositReturnType;
     private Double returnAmt;

     private Double depositBringForward;
     private Double depositAmtNew;
     private String withdrawFlag;
     private String serviceId;
     private Double depositReturnAmt;
     private String rentPaymentPeriod;
     
   //added By OUM 20161010
     private String vatTypeTemp;

     private boolean chkNewStatus;
    // Property accessors
    @Id
   	@GeneratedValue(generator="system-uuid")
   	@GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="SITE_DEPOSIT_ID", unique=true, nullable=false, length=50)

    public String getRowId() {
       return rowId;
    }
    
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }
    
    @Column(name="SITE_INFO_ID", length=50)

    public String getSiteInfoId() {
       return siteInfoId;
    }
    
    public void setSiteInfoId(String siteInfoId) {
        this.siteInfoId = siteInfoId;
    }
    
    @Column(name="EXPENSE_TYPE", length=2)

    public String getExpenseType() {
       return expenseType;
    }
    
    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }
    
    @Column(name="DEPOSIT_TYPE", length=2)

    public String getDepositType() {
       return depositType;
    }
    
    public void setDepositType(String depositType) {
        this.depositType = depositType;
    }
    
    @Column(name="DEPOSIT_AMT", precision=15)

    public Double getDepositAmt() {
    	if(depositAmt != null && depositAmt == 0.00){
    		return null;
    	}
       return depositAmt;
    }
    
    public void setDepositAmt(Double depositAmt) {
        this.depositAmt = depositAmt;
    }
    
    @Column(name="VAT_TYPE", length=2)

    public String getVatType() {
       return vatType;
    }
    
    public void setVatType(String vatType) {
        this.vatType = vatType;
    }
    
    @Column(name="REMARK", length=1000)

    public String getRemark() {
       return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    @Column(name="NEW_STATUS", length=1)

    public String getNewStatus() {
       return newStatus;
    }
    
    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }
    
    @Column(name="RECORD_STATUS", nullable=false, length=1)

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

	 @Column(name="DETAIL", length=4000)
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Version
	@Column(name = "VERSION", precision = 10, scale = 0 , nullable = false)
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Column(name = "SEQ_NO", precision = 22, scale = 0)
	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	@Column(name="DEPOSIT_COND_TYPE", length=2)
	public String getDepositCondType() {
		return depositCondType;
	}

	public void setDepositCondType(String depositCondType) {
		this.depositCondType = depositCondType;
	}
	
	@Transient
	public boolean isChkNewStatus() {
		return chkNewStatus;
	}

	public void setChkNewStatus(boolean chkNewStatus) {
		this.chkNewStatus = chkNewStatus;
	}

	@Transient
	public String getVatTypeTemp() {
		return vatTypeTemp;
	}

	public void setVatTypeTemp(String vatTypeTemp) {
		this.vatTypeTemp = vatTypeTemp;
	}

	@Column(name="DEPOSIT_AMT_OLD", precision=15)
	public Double getDepositAmtOld() {
		return depositAmtOld;
	}

	public void setDepositAmtOld(Double depositAmtOld) {
		this.depositAmtOld = depositAmtOld;
	}

	@Column(name="DEPOSIT_RETURN_TYPE", length=500)
	public String getDepositReturnType() {
		return depositReturnType;
	}

	public void setDepositReturnType(String depositReturnType) {
		this.depositReturnType = depositReturnType;
	}

	@Column(name="RETURN_AMT", precision=15)
	public Double getReturnAmt() {
		return returnAmt;
	}

	public void setReturnAmt(Double returnAmt) {
		this.returnAmt = returnAmt;
	}

	@Column(name="DEPOSIT_BRING_FORWARD", precision=15)
	public Double getDepositBringForward() {
		return depositBringForward;
	}

	public void setDepositBringForward(Double depositBringForward) {
		this.depositBringForward = depositBringForward;
	}

	@Column(name="DEPOSIT_AMT_NEW", precision=15)
	public Double getDepositAmtNew() {
		return depositAmtNew;
	}

	public void setDepositAmtNew(Double depositAmtNew) {
		this.depositAmtNew = depositAmtNew;
	}

	@Column(name="WITHDRAW_FLAG", length=500)
	public String getWithdrawFlag() {
		return withdrawFlag;
	}

	public void setWithdrawFlag(String withdrawFlag) {
		this.withdrawFlag = withdrawFlag;
	}

	@Column(name="SERVICE_ID", length=500)
	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	@Transient
	public Double getDepositReturnAmt() {
		return depositReturnAmt;
	}

	public void setDepositReturnAmt(Double depositReturnAmt) {
		this.depositReturnAmt = depositReturnAmt;
	}

	@Transient
	public String getRentPaymentPeriod() {
		return rentPaymentPeriod;
	}

	public void setRentPaymentPeriod(String rentPaymentPeriod) {
		this.rentPaymentPeriod = rentPaymentPeriod;
	}

}