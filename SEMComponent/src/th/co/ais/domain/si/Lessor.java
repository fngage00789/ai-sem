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
@Table(name="SEM_SI_SITE_LESSOR", schema="SEM")
public class Lessor  extends AbstractDomain {
	
	private static final long serialVersionUID = -5214243245304167544L;
	// Fields    

     private String rowId;
     private String siteInfoId;
     private String lessorName;
     private String houseNo;
     private String street;
     private String tambon;
     private String amphurId;
     private String provinceId;
     private String postcode;
     private String tel;
     private String fax;
     private String recordStatus;
     private Integer seqNo;
     private Long version;
     private String vendorMasterId;
     private String overFlag;
     
     
//     private String lessorTitleName;
//     private String lessorIdCard;
//     private Date lessortBirthday;
     private String lessortBuilding;
     private String lessorFloor;
     private String lessorRoomNo;
     private String lessorMobile;
//     private String lessorFax;
     private String lessorEmail;
   
    // Property accessors
    @Id
   	@GeneratedValue(generator="system-uuid")
   	@GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="SITE_LESSOR_ID", unique=true, nullable=false, length=50)

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
    
    @Column(name="LESSOR_NAME", length=1000)

    public String getLessorName() {
        return lessorName;
    }
    
    public void setLessorName(String lessorName) {
        this.lessorName = lessorName;
    }
    
    @Column(name="HOUSE_NO", length=500)

    public String getHouseNo() {
        return houseNo;
    }
    
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }
    
    @Column(name="STREET", length=100)

    public String getStreet() {
        return street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    
    @Column(name="TAMBON", length=100)

    public String getTambon() {
        return tambon;
    }
    
    public void setTambon(String tambon) {
        this.tambon = tambon;
    }
    
    @Column(name="AMPHUR_ID", length=20)

    public String getAmphurId() {
        return amphurId;
    }
    
    public void setAmphurId(String amphurId) {
        this.amphurId = amphurId;
    }
    
    @Column(name="PROVINCE_ID", length=20)

    public String getProvinceId() {
        return provinceId;
    }
    
    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }
    
    @Column(name="POSTCODE", length=10)

    public String getPostcode() {
        return postcode;
    }
    
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    
    @Column(name="TEL", length=50)

    public String getTel() {
        return tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }
    
    @Column(name="FAX", length=50)

    public String getFax() {
        return fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }
    
    @Column(name="RECORD_STATUS", nullable=false, length=1)

    public String getRecordStatus() {
        return recordStatus;
    }
    
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }
    
    @Column(name = "SEQ_NO", precision = 22, scale = 0)
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

	@Column(name="VENDOR_MASTER_ID", length=50)
	public String getVendorMasterId() {
		return vendorMasterId;
	}

	public void setVendorMasterId(String vendorMasterId) {
		this.vendorMasterId = vendorMasterId;
	}

	@Column(name="OVER_FLAG", length=1)
	public String getOverFlag() {
		return overFlag;
	}

	public void setOverFlag(String overFlag) {
		this.overFlag = overFlag;
	}

	@Column(name="LESSOR_BUILDING", length=500)
	public String getLessortBuilding() {
		return lessortBuilding;
	}

	public void setLessortBuilding(String lessortBuilding) {
		this.lessortBuilding = lessortBuilding;
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

	

}