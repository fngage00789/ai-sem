package th.co.ais.domain.si;

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
@Table(name="SEM_SI_SITE_RENT_COND", schema="SEM")
public class RentCond extends AbstractDomain {

	private static final long serialVersionUID = 1652091362867912596L;
	// Fields    

     private String rowId;
     private String siteInfoId;
     private String expenseType;
     private String placeName;
     private String detail;
     private Double rentOldAmt;
     private Double rentAddPercent;
     private Double rentAddAmt;
     private Double rentAmt;
     private String rentPeriodType;
     private String whtType;
     private Double whtRate;
     private String vatType;
     private String payPeriodType;
     private Integer payPeriod;
     private Date effectiveDt;
     private String recordStatus;
     private Integer seqNo;
     private Long version;
     private String rentCondType;
     private String rentOldPeriodType;
     private String rentAddPeriodType;
     private String refSiteRentCondId;
     private String overFlag;
     
     //added by NEW 20150429
     private String subExpenseType;

     //added By OUM 20160915
     private String whtTypeTemp;
     private Double whtRateTemp;
     private String vatTypeTemp;
     
     //added by NEW 2081/09/06 New SEM4G
     private Date periodStartDt;
     private Date periodEndDt;
     private String rentAdj;
     private String rentAdjPeriodType;
     private String serviceId;
     
     //added 2023/03/03
     private String expenseDesc;
   
    // Property accessors
    @Id
   	@GeneratedValue(generator="system-uuid")
   	@GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="SITE_RENT_COND_ID", unique=true, nullable=false, length=50)

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
    
    @Column(name="PLACE_NAME", length=200)

    public String getPlaceName() {
        return placeName;
    }
    
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
    
    @Column(name="DETAIL", length=500)

    public String getDetail() {
        return detail;
    }
    
    public void setDetail(String detail) {
        this.detail = detail;
    }
    
    @Column(name="RENT_OLD_AMT", precision=15)

    public Double getRentOldAmt() {
        return rentOldAmt;
    }
    
    public void setRentOldAmt(Double rentOldAmt) {
        this.rentOldAmt = rentOldAmt;
    }
    
    @Column(name="RENT_ADD_PERCENT", precision=7)

    public Double getRentAddPercent() {
        return rentAddPercent;
    }
    
    public void setRentAddPercent(Double rentAddPercent) {
        this.rentAddPercent = rentAddPercent;
    }
    
    @Column(name="RENT_ADD_AMT", precision=15)

    public Double getRentAddAmt() {
        return rentAddAmt;
    }
    
    public void setRentAddAmt(Double rentAddAmt) {
        this.rentAddAmt = rentAddAmt;
    }
    
    @Column(name="RENT_AMT", precision=15)

    public Double getRentAmt() {
        return rentAmt;
    }
    
    public void setRentAmt(Double rentAmt) {
        this.rentAmt = rentAmt;
    }
    
    @Column(name="RENT_PERIOD_TYPE", length=2)

    public String getRentPeriodType() {
        return rentPeriodType;
    }
    
    public void setRentPeriodType(String rentPeriodType) {
        this.rentPeriodType = rentPeriodType;
    }
    
    @Column(name="WHT_TYPE", length=2)
    
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

	@Column(name="VAT_TYPE", length=2)

    public String getVatType() {
        return vatType;
    }
    
    public void setVatType(String vatType) {
        this.vatType = vatType;
    }
    
    @Column(name="PAY_PERIOD_TYPE", length=2)

    public String getPayPeriodType() {
        return payPeriodType;
    }
    
    public void setPayPeriodType(String payPeriodType) {
        this.payPeriodType = payPeriodType;
    }
    
    @Column(name="PAY_PERIOD", precision=22, scale=0)

    public Integer getPayPeriod() {
        return payPeriod;
    }
    
    public void setPayPeriod(Integer payPeriod) {
        this.payPeriod = payPeriod;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="EFFECTIVE_DT", length=7)

    public Date getEffectiveDt() {
        return effectiveDt;
    }
    
    public void setEffectiveDt(Date effectiveDt) {
        this.effectiveDt = effectiveDt;
    }
    
    @Column(name="RECORD_STATUS", nullable=false, length=1)

    public String getRecordStatus() {
        return recordStatus;
    }
    
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Column(name="SEQ_NO", precision=22, scale=0)
	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	@Version
	@Column(name = "VERSION", precision = 10, scale = 0 , nullable = false)
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	@Column(name="RENT_COND_TYPE", length=2)
	public String getRentCondType() {
		return rentCondType;
	}

	public void setRentCondType(String rentCondType) {
		this.rentCondType = rentCondType;
	}

	@Column(name="RENT_OLD_PERIOD_TYPE", length=2)
	public String getRentOldPeriodType() {
		return rentOldPeriodType;
	}

	public void setRentOldPeriodType(String rentOldPeriodType) {
		this.rentOldPeriodType = rentOldPeriodType;
	}

	@Column(name="RENT_ADD_PERIOD_TYPE", length=2)
	public String getRentAddPeriodType() {
		return rentAddPeriodType;
	}

	public void setRentAddPeriodType(String rentAddPeriodType) {
		this.rentAddPeriodType = rentAddPeriodType;
	}
	
	
	@Column(name="REF_SITE_RENT_COND_ID", length=50)
	public String getRefSiteRentCondId() {
		return refSiteRentCondId;
	}

	public void setRefSiteRentCondId(String refSiteRentCondId) {
		this.refSiteRentCondId = refSiteRentCondId;
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

	@Column(name="OVER_FLAG", length=1)
	public String getOverFlag() {
		return overFlag;
	}

	public void setOverFlag(String overFlag) {
		this.overFlag = overFlag;
	}

	@Column(name="SUB_EXPENSE_TYPE")
	public String getSubExpenseType() {
		return subExpenseType;
	}

	public void setSubExpenseType(String subExpenseType) {
		this.subExpenseType = subExpenseType;
	}

	@Transient
	public String getWhtTypeTemp() {
		return whtTypeTemp;
	}

	public void setWhtTypeTemp(String whtTypeTemp) {
		this.whtTypeTemp = whtTypeTemp;
	}

	@Transient
	public Double getWhtRateTemp() {
		return whtRateTemp;
	}

	public void setWhtRateTemp(Double whtRateTemp) {
		this.whtRateTemp = whtRateTemp;
	}

	@Transient
	public String getVatTypeTemp() {
		return vatTypeTemp;
	}

	public void setVatTypeTemp(String vatTypeTemp) {
		this.vatTypeTemp = vatTypeTemp;
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

	@Column(name="RENT_ADJ", length=50)
	public String getRentAdj() {
		return rentAdj;
	}

	public void setRentAdj(String rentAdj) {
		this.rentAdj = rentAdj;
	}

	@Column(name="RENT_ADJ_PERIOD_TYPE", length=50)
	public String getRentAdjPeriodType() {
		return rentAdjPeriodType;
	}

	public void setRentAdjPeriodType(String rentAdjPeriodType) {
		this.rentAdjPeriodType = rentAdjPeriodType;
	}

	@Column(name="SERVICE_ID", length=50)
	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	@Column(name="EXPENSE_DESC", length=100)
	public String getExpenseDesc() {
		return expenseDesc;
	}

	public void setExpenseDesc(String expenseDesc) {
		this.expenseDesc = expenseDesc;
	}
	
	
}