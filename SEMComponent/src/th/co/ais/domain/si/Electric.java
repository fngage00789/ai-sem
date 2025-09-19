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
@Table(name="SEM_SI_SITE_ELECTRIC", schema="SEM")
public class Electric  extends AbstractDomain {

	private static final long serialVersionUID = -8991024677288035343L;
	// Fields    

     private String rowId;
     private String siteInfoId;
     private String fromSiteInfoId;
     private String remark;
     private String electricOwnerType;
     private Double takeAllAmt;
     private String takeAllPeriodType;
     private Double unitPriceAmt;
     private String vatType;
     private String payPeriodType;
     private Integer payPeriod;
     private String depositCondType;
     private String recordStatus;
     private String multiElectricTypeFlag;
     private String electricType1;
     private String electricType2;
     private String electricType3;
     private String electricType4;
     private String electricType5;
 	 private String electricType6;
 	 private String electricOthDetail;
     private String noUnitPriceFlag;
     private String fromContractNo;
 	 private Long version;
 	 private Double totalDepositBgAmt;
 	 private Double totalDepositCashAmt;
 	 private String noDeposit;
 	 private Date effectiveDt;

   
    // Property accessors
    @Id
   	@GeneratedValue(generator="system-uuid")
   	@GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="SITE_ELECTRIC_ID", unique=true, nullable=false, length=50)

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
    
    @Column(name="FROM_SITE_INFO_ID", precision=50, scale=0)
    public String getFromSiteInfoId() {
		return fromSiteInfoId;
	}

	public void setFromSiteInfoId(String fromSiteInfoId) {
		this.fromSiteInfoId = fromSiteInfoId;
	}
    
    @Column(name="REMARK", length=1000)

    public String getRemark() {
        return remark;
    }
    
	public void setRemark(String remark) {
        this.remark = remark;
    }
    
    @Column(name="ELECTRIC_OWNER_TYPE", length=2)

    public String getElectricOwnerType() {
        return electricOwnerType;
    }
    
    public void setElectricOwnerType(String electricOwnerType) {
        this.electricOwnerType = electricOwnerType;
    }
    
    @Column(name="TAKE_ALL_AMT", precision=15)

    public Double getTakeAllAmt() {
        return takeAllAmt;
    }
    
    public void setTakeAllAmt(Double takeAllAmt) {
        this.takeAllAmt = takeAllAmt;
    }
    
    @Column(name="TAKE_ALL_PERIOD_TYPE", length=2)

    public String getTakeAllPeriodType() {
        return takeAllPeriodType;
    }
    
    public void setTakeAllPeriodType(String takeAllPeriodType) {
        this.takeAllPeriodType = takeAllPeriodType;
    }
    
    @Column(name="UNIT_PRICE_AMT", precision=15)

    public Double getUnitPriceAmt() {
        return unitPriceAmt;
    }
    
    public void setUnitPriceAmt(Double unitPriceAmt) {
        this.unitPriceAmt = unitPriceAmt;
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
    
    @Column(name="DEPOSIT_COND_TYPE", length=2)

    public String getDepositCondType() {
        return depositCondType;
    }
    
    public void setDepositCondType(String depositCondType) {
        this.depositCondType = depositCondType;
    }
    
    @Column(name="RECORD_STATUS", nullable=false, length=1)

    public String getRecordStatus() {
        return recordStatus;
    }
    
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }
    
    @Column(name="MULTI_ELECTRIC_TYPE_FLAG", length=1)

    public String getMultiElectricTypeFlag() {
        return multiElectricTypeFlag;
    }
    
    public void setMultiElectricTypeFlag(String multiElectricTypeFlag) {
        this.multiElectricTypeFlag = multiElectricTypeFlag;
    }
    
    @Column(name="ELECTRIC_TYPE_1", length=1)

    public String getElectricType1() {
        return electricType1;
    }
    
    public void setElectricType1(String electricType1) {
        this.electricType1 = electricType1;
    }
    
    @Column(name="ELECTRIC_TYPE_2", length=1)

    public String getElectricType2() {
        return electricType2;
    }
    
    public void setElectricType2(String electricType2) {
        this.electricType2 = electricType2;
    }
    
    @Column(name="ELECTRIC_TYPE_3", length=1)

    public String getElectricType3() {
        return electricType3;
    }
    
    public void setElectricType3(String electricType3) {
        this.electricType3 = electricType3;
    }
    
    @Column(name="ELECTRIC_TYPE_4", length=1)

    public String getElectricType4() {
        return electricType4;
    }
    
    public void setElectricType4(String electricType4) {
        this.electricType4 = electricType4;
    }
    
    @Column(name="ELECTRIC_TYPE_5", length=1)
    public String getElectricType5() {
		return electricType5;
	}

	public void setElectricType5(String electricType5) {
		this.electricType5 = electricType5;
	}

	@Column(name="ELECTRIC_TYPE_6", length=1)
	public String getElectricType6() {
		return electricType6;
	}

	public void setElectricType6(String electricType6) {
		this.electricType6 = electricType6;
	}

	@Column(name="ELECTRIC_OTH_DETAIL", length=500)
	public String getElectricOthDetail() {
		return electricOthDetail;
	}

	public void setElectricOthDetail(String electricOthDetail) {
		this.electricOthDetail = electricOthDetail;
	}

	@Column(name="NO_UNIT_PRICE_FLAG", length=1)

    public String getNoUnitPriceFlag() {
        return noUnitPriceFlag;
    }
    
    public void setNoUnitPriceFlag(String noUnitPriceFlag) {
        this.noUnitPriceFlag = noUnitPriceFlag;
    }
   
    @Column(name="FROM_CONTRACT_NO", length=20)
    public String getFromContractNo() {
		return fromContractNo;
	}

	public void setFromContractNo(String fromContractNo) {
		this.fromContractNo = fromContractNo;
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

	@Column(name="TOTAL_DEPOSIT_BG_AMT", precision=15)
	public Double getTotalDepositBgAmt() {
		if(totalDepositBgAmt != null && totalDepositBgAmt == 0.00){
			return null;
		}
		return totalDepositBgAmt;
	}

	public void setTotalDepositBgAmt(Double totalDepositBgAmt) {
		this.totalDepositBgAmt = totalDepositBgAmt;
	}

	@Column(name="TOTAL_DEPOSIT_CASH_AMT", precision=15)
	public Double getTotalDepositCashAmt() {
		if(totalDepositCashAmt != null && totalDepositCashAmt == 0.00){
			return null;
		}
		return totalDepositCashAmt;
	}

	public void setTotalDepositCashAmt(Double totalDepositCashAmt) {
		this.totalDepositCashAmt = totalDepositCashAmt;
	}

	@Column(name="NO_DEPOSIT",  length=1)
	public String getNoDeposit() {
		return noDeposit;
	}

	public void setNoDeposit(String noDeposit) {
		this.noDeposit = noDeposit;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="EFFECTIVE_DT", length=7)
	public Date getEffectiveDt() {
		return effectiveDt;
	}

	public void setEffectiveDt(Date effectiveDt) {
		this.effectiveDt = effectiveDt;
	}

	


}