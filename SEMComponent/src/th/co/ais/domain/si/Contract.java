package th.co.ais.domain.si;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
@Table(name="SEM_SI_CONTRACT", schema="SEM")
public class Contract  extends AbstractDomain {


	private static final SimpleDateFormat SDF 	= new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
	
	private static final long serialVersionUID = -8130274780379328047L;
	 private String rowId;
     private String siteInfoId;
     private String contractNo;
     private Integer renewNo;
     private Date firstEffectiveDt;
     private Date effectiveDt;
     private Date expireDt;
     private String noExpireFlag;
     private Double ageYear;
     private Double ageMonth;
     private Double ageDay;
     
     private Integer ageYearInt;
     private Integer ageMonthInt;
     private Integer ageDayInt;
      
	 private Integer promiseRenewTime;
     private Integer promiseRenewPeriod;
     private String promiseRenewPeriodType;
     private String remark;
     private String contractDocType;
     private String ownerGroup;
     private String ownerName;
     private String lessorName;
     private String lessorHouseNo;
     private String lessorStreet;
     private String lessorTambon;
     private String lessorAmphurId;
     private String lessorProvinceId;
     private String lessorPostcode;
     private String lessorTel;
     private String lessorFax;
     private String contactName;
     private String contactHouseNo;
     private String contactStreet;
     private String contactTambon;
     private String contactAmphurId;
     private String contactProvinceId;
     private String contactPostcode;
     private String contractStatus;
     private Double dutyAmt;
     private String dutyPayStatus;
     private String contractRoom;
     private String contractShelf;
     private String totSendFlag;
     private String totRemarkNotSend;
     private String totSendStatus;
     private String recordStatus;
     private String dummyFlag;
     private Integer copyDuty;
     private Double copyDutyAmt;
     private Double otherDutyAmt;
     private Date dutyPayDt;
 	 private Long version;
 	 private String contractAddress;
 	 private String provinceName;
 	 private String amphurName;
 	 private String ownerContractFlag;
 	 private boolean selected;
 	 private String contactTel;
 	 private String noFormat;
 	 private String receivePersonCode;
 	 private String createPersonCode;
 	 private String effectDtStr;
 	 private String expireDtStr;
 	 private Date effDt;
 	 private Date expDt;
 	 
 	 //added by NEW 2018/09/05
 	 private String leaseholdRights;
 	 private String contractWanted;
 	 private String contractWantedRemark;
 	 private String license;
 	 private String remarkSpacial;
 	 
 	private String ownerTitleName;
 	private String lessorTitleName;	
 	private String lessorTaxId;
 		
 	private Date lessorBirthday;
 	private String lessorBuilding;
 	private String lessorFloor;
 	private String lessorRoomNo;	
 	private String lessorMobile;
 	private String lessorEmail;
 	
 	private String contactTitleName;
 	private String contactIdCard;
 	private Date contactBirthday;
 	private String contactbuilding;
 	private String contactFloor;
 	private String contactRoomNo;	
 	private String contactMobile;	
 	private String contactFax;
 	private String contactEmail;
 	private String ownerCategory;
 	private String ownerSubCategory;
 	
 	private String rentAdj;
 	private String renewRentFlag;
    private String rentAdjPeriodType;
    
    private String promiseRenewRemark;
    
    private String emerContactName;
    private String emerContactTel;
   
    // Property accessors
    @Id
  	@GeneratedValue(generator="system-uuid")
  	@GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="CONTRACT_ID", unique=true, nullable=false, length=50)
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
    
    @Column(name="CONTRACT_NO", length=20)

    public String getContractNo() {
       return contractNo;
    }
    
    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }
    
    @Column(name="RENEW_NO",precision=22, scale=0)
    public Integer getRenewNo() {
       return renewNo;
    }
    
    public void setRenewNo(Integer renewNo) {
        this.renewNo = renewNo;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="FIRST_EFFECTIVE_DT", length=7)

    public Date getFirstEffectiveDt() {
       return firstEffectiveDt;
    }
    
    public void setFirstEffectiveDt(Date firstEffectiveDt) {
        this.firstEffectiveDt = firstEffectiveDt;
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
    
    @Column(name="NO_EXPIRE_FLAG", length=1)

    public String getNoExpireFlag() {
       return noExpireFlag;
    }
    
    public void setNoExpireFlag(String noExpireFlag) {
        this.noExpireFlag = noExpireFlag;
    }
    
    @Column(name="AGE_YEAR" , precision=10)
    public Double getAgeYear() {
  		if(ageYear != null && ageYear == 0){
    		return null;
    	}
       return ageYear;
    }
    
    public void setAgeYear(Double ageYear) {
        this.ageYear = ageYear;       
       // setAgeYearInt(ageYear.intValue());
    }
 
    
  	 @Column(name="AGE_MONTH", precision=10 )
    public Double getAgeMonth() {
    	if(ageMonth != null && ageMonth == 0){
    		return null;
    	}
       return ageMonth;
    }
    
    public void setAgeMonth(Double ageMonth) {
        this.ageMonth = ageMonth;
    }
         
  
  	 @Column(name="AGE_DAY" , precision=10)
    public Double getAgeDay() {
  		if(ageDay != null && ageDay == 0){
    		return null;
    	}
        return ageDay;
     }
     
     public void setAgeDay(Double ageDay) {
         this.ageDay = ageDay;
     }
     
     
     @Transient
    public Integer getAgeYearInt() {
    	 
    	 //(ageYearInt==null?this.ageYear.intValue():ageYearInt);
    // setAgeYearInt(this.ageYear.intValue());
    	 
    	  if(this.ageYear != null){
    	        setAgeYearInt(this.ageYear.intValue());    	        
    	        }
    	
		return ageYearInt;
	}
     

	public void setAgeYearInt(Integer ageYearInt) {
		this.ageYearInt = ageYearInt;
	}
     
     @Transient
	public Integer getAgeMonthInt() {
    	 
    	  if(this.ageMonth != null){
  	        setAgeMonthInt(this.ageMonth.intValue());
  	        ageMonthInt = this.ageMonth.intValue();
  	        }
		return ageMonthInt;
		
	}

	public void setAgeMonthInt(Integer ageMonthInt) {
		this.ageMonthInt = ageMonthInt;
	}
	
	@Transient
	public Integer getAgeDayInt() {
		  if(this.ageDay != null ){
	  	        setAgeDayInt(this.ageDay.intValue());
	  	        ageDayInt= this.ageDay.intValue();
	  	        }
		  
			return ageDayInt;
	}

	public void setAgeDayInt(Integer ageDayInt) {
		this.ageDayInt = ageDayInt;
	}

	@Column(name="PROMISE_RENEW_TIME",precision=22, scale=0)
    public Integer getPromiseRenewTime() {
    	if(promiseRenewTime != null && promiseRenewTime == 0){
    		return null;
    	}
       return promiseRenewTime;
    }
    
    public void setPromiseRenewTime(Integer promiseRenewTime) {
        this.promiseRenewTime = promiseRenewTime;
    }
    
    @Column(name="PROMISE_RENEW_PERIOD",precision=22, scale=0)
    public Integer getPromiseRenewPeriod() {
    	if(promiseRenewPeriod != null && promiseRenewPeriod == 0){
    		return null;
    	}
       return promiseRenewPeriod;
    }
    
    public void setPromiseRenewPeriod(Integer promiseRenewPeriod) {
        this.promiseRenewPeriod = promiseRenewPeriod;
    }
    
    @Column(name="PROMISE_RENEW_PERIOD_TYPE", length=2)
    public String getPromiseRenewPeriodType() {
       return promiseRenewPeriodType;
    }
    
    public void setPromiseRenewPeriodType(String promiseRenewPeriodType) {
        this.promiseRenewPeriodType = promiseRenewPeriodType;
    }
    
    @Column(name="REMARK", length=1000)

    public String getRemark() {
       return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    @Column(name="CONTRACT_DOC_TYPE", length=2)

    public String getContractDocType() {
       return contractDocType;
    }
    
    public void setContractDocType(String contractDocType) {
        this.contractDocType = contractDocType;
    }
    
    @Column(name="OWNER_GROUP", length=2)

    public String getOwnerGroup() {
       return ownerGroup;
    }
    
    public void setOwnerGroup(String ownerGroup) {
        this.ownerGroup = ownerGroup;
    }
    
    @Column(name="OWNER_NAME", length=1000)

    public String getOwnerName() {
       return ownerName;
    }
    
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    
    @Column(name="LESSOR_NAME", length=1000)

   public String getLessorName() {
		return lessorName;
	}

	public void setLessorName(String lessorName) {
		this.lessorName = lessorName;
	}
    
    @Column(name="LESSOR_HOUSE_NO", length=500)
    public String getLessorHouseNo() {
		return lessorHouseNo;
	}

	public void setLessorHouseNo(String lessorHouseNo) {
		this.lessorHouseNo = lessorHouseNo;
	}
   
    
    @Column(name="LESSOR_STREET", length=100)

   	public String getLessorStreet() {
		return lessorStreet;
	}

	public void setLessorStreet(String lessorStreet) {
		this.lessorStreet = lessorStreet;
	}
    
    @Column(name="LESSOR_TAMBON", length=100)
	public String getLessorTambon() {
		return lessorTambon;
	}

	public void setLessorTambon(String lessorTambon) {
		this.lessorTambon = lessorTambon;
	}
  
    
    @Column(name="LESSOR_AMPHUR_ID", length=20)
	public String getLessorAmphurId() {
		return lessorAmphurId;
	}

	public void setLessorAmphurId(String lessorAmphurId) {
		this.lessorAmphurId = lessorAmphurId;
	}
    
    @Column(name="LESSOR_PROVINCE_ID", length=20)

 	public String getLessorProvinceId() {
		return lessorProvinceId;
	}

	public void setLessorProvinceId(String lessorProvinceId) {
		this.lessorProvinceId = lessorProvinceId;
	}
    
    @Column(name="LESSOR_TEL", length=500)
    public String getLessorTel() {
		return lessorTel;
	}

	public void setLessorTel(String lessorTel) {
		this.lessorTel = lessorTel;
	}

    @Column(name="LESSOR_FAX", length=50)
	public String getLessorFax() {
		return lessorFax;
	}

	public void setLessorFax(String lessorFax) {
		this.lessorFax = lessorFax;
	}
    
    @Column(name="CONTACT_NAME", length=100)

    public String getContactName() {
       return contactName;
    }

	public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    
    @Column(name="CONTACT_HOUSE_NO", length=500)

    public String getContactHouseNo() {
       return contactHouseNo;
    }
    
    public void setContactHouseNo(String contactHouseNo) {
        this.contactHouseNo = contactHouseNo;
    }
    
    @Column(name="CONTACT_STREET", length=100)

    public String getContactStreet() {
       return contactStreet;
    }
    
    public void setContactStreet(String contactStreet) {
        this.contactStreet = contactStreet;
    }
    
    @Column(name="CONTACT_TAMBON", length=100)

    public String getContactTambon() {
       return contactTambon;
    }
    
    public void setContactTambon(String contactTambon) {
        this.contactTambon = contactTambon;
    }
    
    @Column(name="CONTACT_AMPHUR_ID", length=20)

    public String getContactAmphurId() {
       return contactAmphurId;
    }
    
    public void setContactAmphurId(String contactAmphurId) {
        this.contactAmphurId = contactAmphurId;
    }
    
    @Column(name="CONTACT_PROVINCE_ID", length=20)

    public String getContactProvinceId() {
       return contactProvinceId;
    }
    
    public void setContactProvinceId(String contactProvinceId) {
        this.contactProvinceId = contactProvinceId;
    }
    
    @Column(name="CONTACT_POSTCODE", length=10)

    public String getContactPostcode() {
       return contactPostcode;
    }
    
    public void setContactPostcode(String contactPostcode) {
        this.contactPostcode = contactPostcode;
    }
    
    @Column(name="CONTRACT_STATUS", length=2)

    public String getContractStatus() {
       return contractStatus;
    }
    
    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }
    
    
    @Column(name="DUTY_AMT", precision=15)

    public Double getDutyAmt() {
       return dutyAmt;
    }
    
    public void setDutyAmt(Double dutyAmt) {
        this.dutyAmt = dutyAmt;
    }
    
    
    @Column(name="DUTY_PAY_STATUS", length=2)

    public String getDutyPayStatus() {
       return dutyPayStatus;
    }
    
    public void setDutyPayStatus(String dutyPayStatus) {
        this.dutyPayStatus = dutyPayStatus;
    }
    
    @Column(name="CONTRACT_ROOM", length=20)

    public String getContractRoom() {
       return contractRoom;
    }
    
    public void setContractRoom(String contractRoom) {
        this.contractRoom = contractRoom;
    }
    
    @Column(name="CONTRACT_SHELF", length=20)

    public String getContractShelf() {
       return contractShelf;
    }
    
    public void setContractShelf(String contractShelf) {
        this.contractShelf = contractShelf;
    }
    
    @Column(name="TOT_SEND_FLAG", length=2)

    public String getTotSendFlag() {
       return totSendFlag;
    }
    
    public void setTotSendFlag(String totSendFlag) {
        this.totSendFlag = totSendFlag;
    }
    
    @Column(name="TOT_REMARK_NOT_SEND", length=200)

    public String getTotRemarkNotSend() {
       return totRemarkNotSend;
    }
    
    public void setTotRemarkNotSend(String totRemarkNotSend) {
        this.totRemarkNotSend = totRemarkNotSend;
    }
    
    @Column(name="TOT_SEND_STATUS", length=2)

    public String getTotSendStatus() {
       return totSendStatus;
    }
    
    public void setTotSendStatus(String totSendStatus) {
        this.totSendStatus = totSendStatus;
    }
  
    
    @Column(name="RECORD_STATUS", nullable=false, length=1)
    public String getRecordStatus() {
       return recordStatus;
    }
    
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Column(name="DUMMY_FLAG", length=1)

	public String getDummyFlag() {
		return dummyFlag;
	}

	public void setDummyFlag(String dummyFlag) {
		this.dummyFlag = dummyFlag;
	}
	
	

	@Column(name="COPY_DUTY", precision=15)	
	public Integer getCopyDuty() {
		return copyDuty;
	}

	public void setCopyDuty(Integer copyDuty) {
		this.copyDuty = copyDuty;
	}

	@Column(name="COPY_DUTY_AMT", precision=15)
	public Double getCopyDutyAmt() {
		return copyDutyAmt;
	}

	public void setCopyDutyAmt(Double copyDutyAmt) {
		this.copyDutyAmt = copyDutyAmt;
	}


	@Column(name="OTHER_DUTY_AMT", precision=15)
	public Double getOtherDutyAmt() {
		return otherDutyAmt;
	}

	public void setOtherDutyAmt(Double otherDutyAmt) {
		this.otherDutyAmt = otherDutyAmt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="DUTY_PAY_DT", length=7)
	public Date getDutyPayDt() {
		return dutyPayDt;
	}

	public void setDutyPayDt(Date dutyPayDt) {
		this.dutyPayDt = dutyPayDt;
	}

	@Column(name="NO_FORMAT", length=1)
	public String getNoFormat() {
		return noFormat;
	}

	public void setNoFormat(String noFormat) {
		this.noFormat = noFormat;
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
	public String getContractAddress() {
		return contractAddress;
	}

	public void setContractAddress(String contractAddress) {
		this.contractAddress = contractAddress;
	}
	@Transient
	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	@Transient
	public String getAmphurName() {
		return amphurName;
	}

	public void setAmphurName(String amphurName) {
		this.amphurName = amphurName;
	}

	@Column(name="OWNER_CONTRACT_FLAG", length=1)
	public String getOwnerContractFlag() {
		return ownerContractFlag;
	}

	public void setOwnerContractFlag(String ownerContractFlag) {
		this.ownerContractFlag = ownerContractFlag;
	}
	
	@Transient
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	@Column(name="CONTACT_TEL", length=500)
	public String getContactTel() {
		return contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	@Column(name="LESSOR_POSTCODE", length=10)
	public String getLessorPostcode() {
		return lessorPostcode;
	}

	public void setLessorPostcode(String lessorPostcode) {
		this.lessorPostcode = lessorPostcode;
	}

	@Column(name="RECEIVE_PERSON_CODE", length=2)
	public String getReceivePersonCode() {
		return receivePersonCode;
	}

	public void setReceivePersonCode(String receivePersonCode) {
		this.receivePersonCode = receivePersonCode;
	}
	
	@Column(name="CREATE_PERSON_CODE", length=2)
	public String getCreatePersonCode() {
		return createPersonCode;
	}

	public void setCreatePersonCode(String createPersonCode) {
		this.createPersonCode = createPersonCode;
	}

	@Transient
	public String getEffectDtStr() {
		effectDtStr = (null != effectiveDt) ? SDF.format(effectiveDt) : "";
		return effectDtStr;
	}

	public void setEffectDtStr(String effectDtStr) {
		this.effectDtStr = effectDtStr;
	}

	@Transient
	public String getExpireDtStr() {
		expireDtStr = (null != expireDt) ? SDF.format(expireDt) : "";
		return expireDtStr;
	}

	public void setExpireDtStr(String expireDtStr) {
		this.expireDtStr = expireDtStr;
	}
	@Transient
	public Date getEffDt() {
		return effDt;
	}

	public void setEffDt(Date effDt) {
		this.effDt = effDt;
	}
	@Transient
	public Date getExpDt() {
		return expDt;
	}

	public void setExpDt(Date expDt) {
		this.expDt = expDt;
	}

	@Column(name="LEASEHOLD_RIGHTS", length=500)
	public String getLeaseholdRights() {
		return leaseholdRights;
	}

	public void setLeaseholdRights(String leaseholdRights) {
		this.leaseholdRights = leaseholdRights;
	}

	@Column(name="CONTACT_WANTED", length=500)
	public String getContractWanted() {
		return contractWanted;
	}

	public void setContractWanted(String contractWanted) {
		this.contractWanted = contractWanted;
	}

	@Column(name="CONTACT_WANTED_REMARK", length=500)
	public String getContractWantedRemark() {
		return contractWantedRemark;
	}

	public void setContractWantedRemark(String contractWantedRemark) {
		this.contractWantedRemark = contractWantedRemark;
	}

	@Column(name="LICENSE", length=500)
	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	@Column(name="REMARK_SPECIAL", length=500)
	public String getRemarkSpacial() {
		return remarkSpacial;
	}

	public void setRemarkSpacial(String remarkSpacial) {
		this.remarkSpacial = remarkSpacial;
	}

	@Column(name="OWNER_TITLE_NAME", length=500)
	public String getOwnerTitleName() {
		return ownerTitleName;
	}

	public void setOwnerTitleName(String ownerTitleName) {
		this.ownerTitleName = ownerTitleName;
	}

	@Column(name="LESSOR_TITLE_NAME", length=500)
	public String getLessorTitleName() {
		return lessorTitleName;
	}

	public void setLessorTitleName(String lessorTitleName) {
		this.lessorTitleName = lessorTitleName;
	}

	@Column(name="LESSOR_TAX_ID", length=500)
	public String getLessorTaxId() {
		return lessorTaxId;
	}

	public void setLessorTaxId(String lessorTaxId) {
		this.lessorTaxId = lessorTaxId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="LESSOR_BIRTHDAY", length=7)
	public Date getLessorBirthday() {
		return lessorBirthday;
	}

	public void setLessorBirthday(Date lessorBirthday) {
		this.lessorBirthday = lessorBirthday;
	}

	@Column(name="LESSOR_BUILDING", length=500)
	public String getLessorBuilding() {
		return lessorBuilding;
	}

	public void setLessorBuilding(String lessorBuilding) {
		this.lessorBuilding = lessorBuilding;
	}

	@Column(name="LESSOR_FLOOR", length=500)
	public String getLessorFloor() {
		return lessorFloor;
	}

	public void setLessorFloor(String lessorFloor) {
		this.lessorFloor = lessorFloor;
	}

	@Column(name="LESSOR_ROOM_NO", length=500)
	public String getLessorRoomNo() {
		return lessorRoomNo;
	}

	public void setLessorRoomNo(String lessorRoomNo) {
		this.lessorRoomNo = lessorRoomNo;
	}

	@Column(name="LESSOR_MOBILE", length=500)
	public String getLessorMobile() {
		return lessorMobile;
	}

	public void setLessorMobile(String lessorMobile) {
		this.lessorMobile = lessorMobile;
	}

	@Column(name="LESSOR_EMAIL", length=500)
	public String getLessorEmail() {
		return lessorEmail;
	}

	public void setLessorEmail(String lessorEmail) {
		this.lessorEmail = lessorEmail;
	}

	@Column(name="CONTACT_TITLE_NAME", length=500)
	public String getContactTitleName() {
		return contactTitleName;
	}

	public void setContactTitleName(String contactTitleName) {
		this.contactTitleName = contactTitleName;
	}

	@Column(name="CONTACT_ID_CARD", length=500)
	public String getContactIdCard() {
		return contactIdCard;
	}

	public void setContactIdCard(String contactIdCard) {
		this.contactIdCard = contactIdCard;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="CONTACT_BIRTHDAY", length=7)
	public Date getContactBirthday() {
		return contactBirthday;
	}

	public void setContactBirthday(Date contactBirthday) {
		this.contactBirthday = contactBirthday;
	}

	@Column(name="CONTACT_BUILDING", length=500)
	public String getContactbuilding() {
		return contactbuilding;
	}

	public void setContactbuilding(String contactbuilding) {
		this.contactbuilding = contactbuilding;
	}

	@Column(name="CONTACT_FLOOR", length=500)
	public String getContactFloor() {
		return contactFloor;
	}

	public void setContactFloor(String contactFloor) {
		this.contactFloor = contactFloor;
	}

	@Column(name="CONTACT_ROOM_NO", length=500)
	public String getContactRoomNo() {
		return contactRoomNo;
	}

	public void setContactRoomNo(String contactRoomNo) {
		this.contactRoomNo = contactRoomNo;
	}

	@Column(name="CONTACT_MOBILE", length=500)
	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	@Column(name="CONTACT_FAX", length=500)
	public String getContactFax() {
		return contactFax;
	}

	public void setContactFax(String contactFax) {
		this.contactFax = contactFax;
	}

	@Column(name="CONTACT_EMAIL", length=500)
	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	@Column(name="OWNER_CATEGORY", length=500)
	public String getOwnerCategory() {
		return ownerCategory;
	}

	public void setOwnerCategory(String ownerCategory) {
		this.ownerCategory = ownerCategory;
	}

	@Column(name="OWNER_SUB_CATEGORY", length=500)
	public String getOwnerSubCategory() {
		return ownerSubCategory;
	}

	public void setOwnerSubCategory(String ownerSubCategory) {
		this.ownerSubCategory = ownerSubCategory;
	}
	@Column(name="RENEW_RENT_PERCENT", length=10)
	public String getRentAdj() {
		return rentAdj;
	}

	public void setRentAdj(String rentAdj) {
		this.rentAdj = rentAdj;
	}
	@Transient
	public String getRentAdjPeriodType() {
		return rentAdjPeriodType;
	}

	public void setRentAdjPeriodType(String rentAdjPeriodType) {
		this.rentAdjPeriodType = rentAdjPeriodType;
	}
	@Column(name="RENEW_RENT_FLAG", length=1) 
	public String getRenewRentFlag() {
		return renewRentFlag;
	}

	public void setRenewRentFlag(String renewRentFlag) {
		this.renewRentFlag = renewRentFlag;
	}
	@Column(name="PROMISE_RENEW_REMARK", length=1000)
	public String getPromiseRenewRemark() {
		return promiseRenewRemark;
	}

	public void setPromiseRenewRemark(String promiseRenewRemark) {
		this.promiseRenewRemark = promiseRenewRemark;
	}
	@Column(name="EMER_CONTACT_NAME", length=200)
	public String getEmerContactName() {
		return emerContactName;
	}

	public void setEmerContactName(String emerContactName) {
		this.emerContactName = emerContactName;
	}
	@Column(name="EMER_CONTACT_PHONE", length=100)
	public String getEmerContactTel() {
		return emerContactTel;
	}

	public void setEmerContactTel(String emerContactTel) {
		this.emerContactTel = emerContactTel;
	}


	
}