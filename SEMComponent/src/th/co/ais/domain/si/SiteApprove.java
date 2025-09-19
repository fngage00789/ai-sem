package th.co.ais.domain.si;

import java.util.Date;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.persistence.Version;

import javax.persistence.Table;
import javax.persistence.Temporal;

import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;


import th.co.ais.domain.AbstractDomain;


@Entity
@Table(name="SEM_SI_SITE_APPROVE", schema="SEM")
public class SiteApprove  extends AbstractDomain {

	private static final long serialVersionUID = -7309112343710715210L;
	// Fields    

     private String rowId;
     private String company;
     private String region;
     private String docNo;
     private Date docDt;
     private Date outDt;
     private String reqOfficer;
     private String reqDocType;
     private String reqType;
     private String title;
     private String siteInfoId;
     private String contractNo;
     private String detail;
     private String siteApproveStatus;
     private String recordStatus;
     private Long version;
     private Date invalidDt;
     private String siteInfoFlag;
     private Integer seqNo;

     private String sendRenewId;
     private Date inDt;
     private String reqTypeTmp;
     
     private Date approveDt;
     
    // Property accessors
    @Id
   	@GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="SITE_APPROVE_ID", unique=true, nullable=false, length=20)

    public String getRowId() {
        return rowId;
    }
    
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }
    
    @Column(name="COMPANY", length=20)

    public String getCompany() {
        return company;
    }
    
    public void setCompany(String company) {
        this.company = company;
    }
    
    @Column(name="REGION", length=10)

    public String getRegion() {
        return region;
    }
    
    public void setRegion(String region) {
        this.region = region;
    }
    
    @Column(name="DOC_NO", length=20)

    public String getDocNo() {
        return docNo;
    }
    
    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="DOC_DT", length=7)

    public Date getDocDt() {
        return docDt;
    }
    
    public void setDocDt(Date docDt) {
        this.docDt = docDt;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="OUT_DT", length=7)

    public Date getOutDt() {
        return outDt;
    }
    
    public void setOutDt(Date outDt) {
        this.outDt = outDt;
    }
    
    @Column(name="REQ_OFFICER", length=100)

    public String getReqOfficer() {
        return reqOfficer;
    }
    
    public void setReqOfficer(String reqOfficer) {
        this.reqOfficer = reqOfficer;
    }
    
    @Column(name="REQ_DOC_TYPE", length=2)

    public String getReqDocType() {
        return reqDocType;
    }
    
    public void setReqDocType(String reqDocType) {
        this.reqDocType = reqDocType;
    }
    
    @Column(name="REQ_TYPE", length=2)

    public String getReqType() {
        return reqType;
    }
    
    public void setReqType(String reqType) {
        this.reqType = reqType;
    }
    
    @Column(name="TITLE", length=200)

    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Column(name="SITE_INFO_ID", length=20)

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
    
    @Column(name="DETAIL", length=2000)

    public String getDetail() {
        return detail;
    }
    
    public void setDetail(String detail) {
        this.detail = detail;
    }
    
    @Column(name="SITE_APPROVE_STATUS", length=2)

    public String getSiteApproveStatus() {
        return siteApproveStatus;
    }
    
    public void setSiteApproveStatus(String siteApproveStatus) {
        this.siteApproveStatus = siteApproveStatus;
    }
    
    @Column(name="CREATE_DT")
    public Date getCreateDt() {
        return createDt;
    }
    
    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }
    
    @Column(name="CREATE_BY", length=20)
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
    
    @Column(name="UPDATE_BY", length=20)
    public String getUpdateBy() {
        return updateBy;
    }
    
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    
    @Column(name="RECORD_STATUS", nullable=false, length=1)

    public String getRecordStatus() {
        return recordStatus;
    }
    
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }
   
    @Version
	@Column(name = "VERSION", precision = 10, scale = 0 , nullable = false)
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	@Temporal(TemporalType.DATE)
    @Column(name="INVALID_DT", length=7)
	public Date getInvalidDt() {
		return invalidDt;
	}

	public void setInvalidDt(Date invalidDt) {
		this.invalidDt = invalidDt;
	}

	@Column(name="SITE_INFO_FLAG", length=2)
	public String getSiteInfoFlag() {
		return siteInfoFlag;
	}

	public void setSiteInfoFlag(String siteInfoFlag) {
		this.siteInfoFlag = siteInfoFlag;
	}

	@Column(name = "SEQ_NO")
	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	@Column(name = "SEND_RENEW_ID")
	public String getSendRenewId() {
		return sendRenewId;
	}

	public void setSendRenewId(String sendRenewId) {
		this.sendRenewId = sendRenewId;
	}

	@Column(name = "IN_DT")
	public Date getInDt() {
		return inDt;
	}

	public void setInDt(Date inDt) {
		this.inDt = inDt;
	}
	@Transient
	public String getReqTypeTmp() {
		return reqTypeTmp;
	}

	public void setReqTypeTmp(String reqTypeTmp) {
		this.reqTypeTmp = reqTypeTmp;
	}

	 @Temporal(TemporalType.DATE)
	 @Column(name="APPROVE_DT", length=7)
	public Date getApproveDt() {
		return approveDt;
	}

	public void setApproveDt(Date approveDt) {
		this.approveDt = approveDt;
	}
	
	
}