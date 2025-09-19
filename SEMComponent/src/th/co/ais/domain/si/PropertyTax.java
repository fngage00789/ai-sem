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
@Table(name="SEM_SI_SITE_PROPERTY_TAX", schema="SEM")
public class PropertyTax  extends AbstractDomain {

	private static final long serialVersionUID = 2490064272388866689L;
	// Fields    

     private String rowId;
     private String siteInfoId;
     private String propertyTaxPayType;
     private String remark;
     private String recordStatus;
     private Long version;
     private String propertyTaxPayTypeTemp;

    // Property accessors
    @Id
   	@GeneratedValue(generator="system-uuid")
   	@GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="SITE_PROPERTY_TAX_ID", unique=true, nullable=false, length=50)

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
    
    @Column(name="PROPERTY_TAX_PAY_TYPE", length=2)

    public String getPropertyTaxPayType() {
        return propertyTaxPayType;
    }
    
    public void setPropertyTaxPayType(String propertyTaxPayType) {
        this.propertyTaxPayType = propertyTaxPayType;
    }
    
    @Column(name="REMARK", length=1000)

    public String getRemark() {
        return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
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

	@Transient
	public String getPropertyTaxPayTypeTemp() {
		return propertyTaxPayTypeTemp;
	}

	public void setPropertyTaxPayTypeTemp(String propertyTaxPayTypeTemp) {
		this.propertyTaxPayTypeTemp = propertyTaxPayTypeTemp;
	}

	




}