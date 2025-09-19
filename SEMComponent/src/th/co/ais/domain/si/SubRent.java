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
@Table(name="SEM_SI_SITE_SUB_RENT", schema="SEM")
public class SubRent  extends AbstractDomain {


    // Fields    
	 private static final long serialVersionUID = -3334042482709107267L;
	 private String rowId;
     private String siteInfoId;
     private String subCompany;
     private String subContractNo;
     private Date effectiveDt;
     private Date expireDt;
     private String rentType;
     private String detail;
     private String recordStatus;
     private Long version;
     private Integer seqNo;
     private Double rentAmt;
     private String rentPeriodType;


   
    @Id
   	@GeneratedValue(generator="system-uuid")
   	@GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="SITE_SUB_RENT_ID", unique=true, nullable=false, length=50)

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
    
    @Column(name="SUB_COMPANY", precision=22, scale=0)

    public String getSubCompany() {
        return subCompany;
    }
    
    public void setSubCompany(String subCompany) {
        this.subCompany = subCompany;
    }
    
    @Column(name="SUB_CONTRACT_NO", length=20)

    public String getSubContractNo() {
        return subContractNo;
    }
    
    public void setSubContractNo(String subContractNo) {
        this.subContractNo = subContractNo;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="EFFECTIVE_DT", length=7)

    public Date getEffectiveDt() {
        return effectiveDt;
    }
    
    public void setEffectiveDt(Date effectiveDt) {
        this.effectiveDt = effectiveDt;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="EXPIRE_DT", length=7)

    public Date getExpireDt() {
        return expireDt;
    }
    
    public void setExpireDt(Date expireDt) {
        this.expireDt = expireDt;
    }
    
    @Column(name="RENT_TYPE", length=2)

    public String getRentType() {
        return rentType;
    }
    
    public void setRentType(String rentType) {
        this.rentType = rentType;
    }
    
    @Column(name="DETAIL", length=2000)

    public String getDetail() {
        return detail;
    }
    
    public void setDetail(String detail) {
        this.detail = detail;
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

	@Column(name = "SEQ_NO", precision = 22, scale = 0)
	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	@Column(name="RENT_AMT", precision=15)
	public Double getRentAmt() {
		if(rentAmt != null && rentAmt == 0.00){
			return null;
		}
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







}