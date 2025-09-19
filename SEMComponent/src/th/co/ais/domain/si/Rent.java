package th.co.ais.domain.si;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;


@Entity
@Table(name="SEM_SI_SITE_RENT", schema="SEM")
public class Rent  extends AbstractDomain {

	private static final long serialVersionUID = 2004430553270025550L;
	// Fields    

     private String rowId;
     private String siteInfoId;
     private String rentCondType;
     private String depositCondType;
     private String recordStatus;
     private Long version;
     private Double totalRentAmt;
     private String totalRentPeriodType;
     private Double totalServiceAmt;
     private String totalServicePeriodType;
     private Double totalRentServiceAmt;
     private String totalRentServicePeriodType;
     private Double totalRentAddAmt;
     private String totalRentAddPeriodType;
     private Double totalServiceAddAmt;
     private String totalServiceAddPeriodType;
     private Double totalDepositBgAmt;
     private Double totalDepositCashAmt;
     private Double totalAgeRentServiceAmt;
     private Double totalAgeRentAmt;
     private Double totalAgeServiceAmt;
     private String noRent;
     private String noDeposit;
     
     //added by NEW 23/02/2016
     private String fix5Percent;
     
     //added 24/02/2023
     private Double totalAgeDonateAmt;
     

    // Property accessors
    @Id
   	@GeneratedValue(generator="system-uuid")
   	@GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="SITE_RENT_ID", unique=true, nullable=false, length=50)

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
    
    @Column(name="RENT_COND_TYPE", length=2)

    public String getRentCondType() {
        return rentCondType;
    }
    
    public void setRentCondType(String rentCondType) {
        this.rentCondType = rentCondType;
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

	@Column(name="TOTAL_RENT_AMT", precision=15)
	public Double getTotalRentAmt() {
		return totalRentAmt;
	}

	public void setTotalRentAmt(Double totalRentAmt) {
		this.totalRentAmt = totalRentAmt;
	}

	@Column(name="TOTAL_RENT_PERIOD_TYPE", length=1)
	public String getTotalRentPeriodType() {
		return totalRentPeriodType;
	}

	public void setTotalRentPeriodType(String totalRentPeriodType) {
		this.totalRentPeriodType = totalRentPeriodType;
	}

	@Column(name="TOTAL_SERVICE_AMT", precision=15)
	public Double getTotalServiceAmt() {
		return totalServiceAmt;
	}

	public void setTotalServiceAmt(Double totalServiceAmt) {
		this.totalServiceAmt = totalServiceAmt;
	}

	@Column(name="TOTAL_SERVICE_PERIOD_TYPE", length=1)
	public String getTotalServicePeriodType() {
		return totalServicePeriodType;
	}

	public void setTotalServicePeriodType(String totalServicePeriodType) {
		this.totalServicePeriodType = totalServicePeriodType;
	}

	@Column(name="TOTAL_RENT_SERVICE_AMT", precision=15)
	public Double getTotalRentServiceAmt() {
		return totalRentServiceAmt;
	}

	public void setTotalRentServiceAmt(Double totalRentServiceAmt) {
		this.totalRentServiceAmt = totalRentServiceAmt;
	}

	@Column(name="TOTAL_RENT_SERVICE_PERIOD_TYPE", length=1)
	public String getTotalRentServicePeriodType() {
		return totalRentServicePeriodType;
	}

	public void setTotalRentServicePeriodType(String totalRentServicePeriodType) {
		this.totalRentServicePeriodType = totalRentServicePeriodType;
	}

	@Column(name="TOTAL_RENT_ADD_AMT", precision=15)
	public Double getTotalRentAddAmt() {
		return totalRentAddAmt;
	}

	public void setTotalRentAddAmt(Double totalRentAddAmt) {
		this.totalRentAddAmt = totalRentAddAmt;
	}

	@Column(name="TOTAL_RENT_ADD_PERIOD_TYPE", length=1)
	public String getTotalRentAddPeriodType() {
		return totalRentAddPeriodType;
	}

	public void setTotalRentAddPeriodType(String totalRentAddPeriodType) {
		this.totalRentAddPeriodType = totalRentAddPeriodType;
	}

	@Column(name="TOTAL_SERVICE_ADD_AMT", precision=15)
	public Double getTotalServiceAddAmt() {
		return totalServiceAddAmt;
	}

	public void setTotalServiceAddAmt(Double totalServiceAddAmt) {
		this.totalServiceAddAmt = totalServiceAddAmt;
	}

	@Column(name="TOTAL_SERVICE_ADD_PERIOD_TYPE", length=1)
	public String getTotalServiceAddPeriodType() {
		return totalServiceAddPeriodType;
	}

	public void setTotalServiceAddPeriodType(String totalServiceAddPeriodType) {
		this.totalServiceAddPeriodType = totalServiceAddPeriodType;
	}

	@Column(name="TOTAL_DEPOSIT_BG_AMT", precision=15)
	public Double getTotalDepositBgAmt() {
		return totalDepositBgAmt;
	}

	public void setTotalDepositBgAmt(Double totalDepositBgAmt) {
		this.totalDepositBgAmt = totalDepositBgAmt;
	}

	@Column(name="TOTAL_DEPOSIT_CASH_AMT", precision=15)
	public Double getTotalDepositCashAmt() {
		return totalDepositCashAmt;
	}

	public void setTotalDepositCashAmt(Double totalDepositCashAmt) {
		this.totalDepositCashAmt = totalDepositCashAmt;
	}

	@Column(name="TOTAL_AGE_RENT_SERVICE_AMT", precision=15)
	public Double getTotalAgeRentServiceAmt() {
		return totalAgeRentServiceAmt;
	}

	public void setTotalAgeRentServiceAmt(Double totalAgeRentServiceAmt) {
		this.totalAgeRentServiceAmt = totalAgeRentServiceAmt;
	}

	@Column(name="TOTAL_AGE_RENT_AMT", precision=15)
	public Double getTotalAgeRentAmt() {
		return totalAgeRentAmt;
	}

	public void setTotalAgeRentAmt(Double totalAgeRentAmt) {
		this.totalAgeRentAmt = totalAgeRentAmt;
	}

	@Column(name="TOTAL_AGE_SERVICE_AMT", precision=15)
	public Double getTotalAgeServiceAmt() {
		return totalAgeServiceAmt;
	}

	public void setTotalAgeServiceAmt(Double totalAgeServiceAmt) {
		this.totalAgeServiceAmt = totalAgeServiceAmt;
	}

	@Column(name="NO_RENT",  length=1)
	public String getNoRent() {
		return noRent;
	}

	public void setNoRent(String noRent) {
		this.noRent = noRent;
	}

	@Column(name="NO_DEPOSIT",  length=1)
	public String getNoDeposit() {
		return noDeposit;
	}

	public void setNoDeposit(String noDeposit) {
		this.noDeposit = noDeposit;
	}

	@Column(name="FIX5_PERCENT",  length=1)
	public String getFix5Percent() {
		return fix5Percent;
	}

	public void setFix5Percent(String fix5Percent) {
		this.fix5Percent = fix5Percent;
	}
	
	//added 24/02/2023
	@Column(name="TOTAL_AGE_DONATE_AMT", precision=15)
	public Double getTotalAgeDonateAmt() {
		return totalAgeDonateAmt;
	}
    
	//added 24/02/2023
	public void setTotalAgeDonateAmt(Double totalAgeDonateAmt) {
		this.totalAgeDonateAmt = totalAgeDonateAmt;
	}
	
	
}