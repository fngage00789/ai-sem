package th.co.ais.domain.si;

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


@Entity
@Table(name="SEM_SI_SITE_INSURANCE", schema="SEM")
public class Insurance  extends AbstractDomain {

	private static final long serialVersionUID = -8120307616129953572L;
	// Fields    

     private String rowId;
     private String siteInfoId;
     private String insuranceType;
     private String remark;
     private Double plxOldAmt;
     private Double plxAddAmt;
     private Double plxAmt;
     private Date plxEffectiveDt;
     private Date plxExpireDt;
     private Double ownerAmt;
     private String ownerPeriodType;
     private String ownerVatType;
     private String ownerPayPeriodType;
     private Integer ownerPayPeriod;
     private String recordStatus;
 	 private Long version;
 	 
 	private String noInsFlag;
 	private Date effectiveDt;
 	private String plxBeneficiary;

   
    // Property accessors
    @Id
   	@GeneratedValue(generator="system-uuid")
   	@GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="SITE_INSURANCE_ID", unique=true, nullable=false, length=50)

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
    
    @Column(name="INSURANCE_TYPE", length=2)

    public String getInsuranceType() {
        return insuranceType;
    }
    
    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }
    
    @Column(name="REMARK", length=1000)

    public String getRemark() {
        return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    @Column(name="PLX_OLD_AMT", precision=15)

    public Double getPlxOldAmt() {
        return plxOldAmt;
    }
    
    public void setPlxOldAmt(Double plxOldAmt) {
        this.plxOldAmt = plxOldAmt;
    }
    
    @Column(name="PLX_ADD_AMT", precision=15)

    public Double getPlxAddAmt() {
        return plxAddAmt;
    }
    
    public void setPlxAddAmt(Double plxAddAmt) {
        this.plxAddAmt = plxAddAmt;
    }
    
    @Column(name="PLX_AMT", precision=15)

    public Double getPlxAmt() {
        return plxAmt;
    }
    
    public void setPlxAmt(Double plxAmt) {
        this.plxAmt = plxAmt;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="PLX_EFFECTIVE_DT", length=7)

    public Date getPlxEffectiveDt() {
        return plxEffectiveDt;
    }
    
    public void setPlxEffectiveDt(Date plxEffectiveDt) {
        this.plxEffectiveDt = plxEffectiveDt;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="PLX_EXPIRE_DT", length=7)

    public Date getPlxExpireDt() {
        return plxExpireDt;
    }
    
    public void setPlxExpireDt(Date plxExpireDt) {
        this.plxExpireDt = plxExpireDt;
    }
    
    @Column(name="OWNER_AMT", precision=15)

    public Double getOwnerAmt() {
        return ownerAmt;
    }
    
    public void setOwnerAmt(Double ownerAmt) {
        this.ownerAmt = ownerAmt;
    }
    
    @Column(name="OWNER_PERIOD_TYPE", length=2)

    public String getOwnerPeriodType() {
        return ownerPeriodType;
    }
    
    public void setOwnerPeriodType(String ownerPeriodType) {
        this.ownerPeriodType = ownerPeriodType;
    }
    
    @Column(name="OWNER_VAT_TYPE", length=2)

    public String getOwnerVatType() {
        return ownerVatType;
    }
    
    public void setOwnerVatType(String ownerVatType) {
        this.ownerVatType = ownerVatType;
    }
    
    @Column(name="OWNER_PAY_PERIOD_TYPE", length=2)

    public String getOwnerPayPeriodType() {
        return ownerPayPeriodType;
    }
    
    public void setOwnerPayPeriodType(String ownerPayPeriodType) {
        this.ownerPayPeriodType = ownerPayPeriodType;
    }
    
    @Column(name="OWNER_PAY_PERIOD", precision=22, scale=0)

    public Integer getOwnerPayPeriod() {
        return ownerPayPeriod;
    }
    
    public void setOwnerPayPeriod(Integer ownerPayPeriod) {
        this.ownerPayPeriod = ownerPayPeriod;
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

	@Version
	@Column(name = "VERSION", precision = 10, scale = 0 , nullable = false)
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Column(name="NO_OWNER_AMT", length=1)
	public String getNoInsFlag() {
		return noInsFlag;
	}

	public void setNoInsFlag(String noInsFlag) {
		this.noInsFlag = noInsFlag;
	}

	@Temporal(TemporalType.DATE)
    @Column(name="INS_CHE_EFF_DT", length=7)
	public Date getEffectiveDt() {
		return effectiveDt;
	}

	public void setEffectiveDt(Date effectiveDt) {
		this.effectiveDt = effectiveDt;
	}

	@Column(name="PLX_BENEFICIARY", length=500)
	public String getPlxBeneficiary() {
		return plxBeneficiary;
	}

	public void setPlxBeneficiary(String plxBeneficiary) {
		this.plxBeneficiary = plxBeneficiary;
	}



}