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
@Table(name="SEM_SI_LEGAL_APPROVE", schema="SEM")
public class LegalApprove  extends AbstractDomain {


	private static final long serialVersionUID = -5071443965310927678L;
	private String rowId;
     private String siteApproveId;
     private Date checkDt;
     private Date receiveDt;
     private Date outDt;
     private String legalApproveStatus;
     private String remark;
     private String riskType1;
     private String riskType1Remark;
     private String riskType2;
     private String riskType2Remark;
     private String riskType3;
     private String riskType3Remark;
     private String riskTypeOther;
     private String riskTypeOtherRemark;
     private String rentType;
     private String rentTypeOtherRemark;
     private String doc1;
     private String doc2;
     private String doc3;
     private String doc4;
     private String doc5;
     private String docOther;
     private String docOtherRemark;
     private String latestFlag;
     private Date createDt;
     private String createBy;
     private Date updateDt;
     private String updateBy;
     private String recordStatus;
     private String doc6;
     private String doc7;
     private String doc8;
     private String doc9;
     private String doc10;
     private Integer seqNo;
     private Long version;

	// Property accessors
    @Id
   	@GeneratedValue(generator="system-uuid")
   	@GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="LEGAL_APPROVE_ID", unique=true, nullable=false, length=50)

    public String getRowId() {
        return rowId;
    }
    
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }
    
    @Column(name="SITE_APPROVE_ID", length=50)

    public String getSiteApproveId() {
        return siteApproveId;
    }
    
    public void setSiteApproveId(String siteApproveId) {
        this.siteApproveId = siteApproveId;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="CHECK_DT", length=7)

    public Date getCheckDt() {
        return checkDt;
    }
    
    public void setCheckDt(Date checkDt) {
        this.checkDt = checkDt;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="OUT_DT", length=7)

    public Date getOutDt() {
        return outDt;
    }
    
    public void setOutDt(Date outDt) {
        this.outDt = outDt;
    }
    
    @Column(name="LEGAL_APPROVE_STATUS", length=2)

    public String getLegalApproveStatus() {
        return legalApproveStatus;
    }
    
    public void setLegalApproveStatus(String legalApproveStatus) {
        this.legalApproveStatus = legalApproveStatus;
    }
    
    @Column(name="REMARK", length=1000)

    public String getRemark() {
        return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    @Column(name="RISK_TYPE_1", length=1)

    public String getRiskType1() {
        return riskType1;
    }
    
    public void setRiskType1(String riskType1) {
        this.riskType1 = riskType1;
    }
    
    @Column(name="RISK_TYPE_1_REMARK", length=300)

    public String getRiskType1Remark() {
        return riskType1Remark;
    }
    
    public void setRiskType1Remark(String riskType1Remark) {
        this.riskType1Remark = riskType1Remark;
    }
    
    @Column(name="RISK_TYPE_2", length=1)

    public String getRiskType2() {
        return riskType2;
    }
    
    public void setRiskType2(String riskType2) {
        this.riskType2 = riskType2;
    }
    
    @Column(name="RISK_TYPE_2_REMARK", length=300)

    public String getRiskType2Remark() {
        return riskType2Remark;
    }
    
    public void setRiskType2Remark(String riskType2Remark) {
        this.riskType2Remark = riskType2Remark;
    }
    
    @Column(name="RISK_TYPE_3", length=1)

    public String getRiskType3() {
        return riskType3;
    }
    
    public void setRiskType3(String riskType3) {
        this.riskType3 = riskType3;
    }
    
    @Column(name="RISK_TYPE_3_REMARK", length=300)

    public String getRiskType3Remark() {
        return riskType3Remark;
    }
    
    public void setRiskType3Remark(String riskType3Remark) {
        this.riskType3Remark = riskType3Remark;
    }
    
    @Column(name="RISK_TYPE_OTHER", length=1)

    public String getRiskTypeOther() {
        return riskTypeOther;
    }
    
    public void setRiskTypeOther(String riskTypeOther) {
        this.riskTypeOther = riskTypeOther;
    }
    
    @Column(name="RISK_TYPE_OTHER_REMARK", length=300)

    public String getRiskTypeOtherRemark() {
        return riskTypeOtherRemark;
    }
    
    public void setRiskTypeOtherRemark(String riskTypeOtherRemark) {
        this.riskTypeOtherRemark = riskTypeOtherRemark;
    }
    
    @Column(name="RENT_TYPE", length=2)

    public String getRentType() {
        return rentType;
    }
    
    public void setRentType(String rentType) {
        this.rentType = rentType;
    }
    
    @Column(name="RENT_TYPE_OTHER_REMARK", length=300)

    public String getRentTypeOtherRemark() {
        return rentTypeOtherRemark;
    }
    
    public void setRentTypeOtherRemark(String rentTypeOtherRemark) {
        this.rentTypeOtherRemark = rentTypeOtherRemark;
    }
    
    @Column(name="DOC_1", length=1)

    public String getDoc1() {
        return doc1;
    }
    
    public void setDoc1(String doc1) {
        this.doc1 = doc1;
    }
    
    @Column(name="DOC_2", length=1)

    public String getDoc2() {
        return doc2;
    }
    
    public void setDoc2(String doc2) {
        this.doc2 = doc2;
    }
    
    @Column(name="DOC_3", length=1)

    public String getDoc3() {
        return doc3;
    }
    
    public void setDoc3(String doc3) {
        this.doc3 = doc3;
    }
    
    @Column(name="DOC_4", length=1)

    public String getDoc4() {
        return doc4;
    }
    
    public void setDoc4(String doc4) {
        this.doc4 = doc4;
    }
    
    @Column(name="DOC_5", length=1)

    public String getDoc5() {
        return doc5;
    }
    
    public void setDoc5(String doc5) {
        this.doc5 = doc5;
    }
    
    @Column(name="DOC_OTHER", length=1)

    public String getDocOther() {
        return docOther;
    }
    
    public void setDocOther(String docOther) {
        this.docOther = docOther;
    }
    
    @Column(name="DOC_OTHER_REMARK", length=300)

    public String getDocOtherRemark() {
        return docOtherRemark;
    }
    
    public void setDocOtherRemark(String docOtherRemark) {
        this.docOtherRemark = docOtherRemark;
    }
    
    @Column(name="LATEST_FLAG", nullable=false, length=1)

    public String getLatestFlag() {
        return latestFlag;
    }
    
    public void setLatestFlag(String latestFlag) {
        this.latestFlag = latestFlag;
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
    
    @Column(name="DOC_6", length=1)
    public String getDoc6() {
		return doc6;
	}

	public void setDoc6(String doc6) {
		this.doc6 = doc6;
	}

	@Column(name="DOC_7", length=1)
	public String getDoc7() {
		return doc7;
	}

	public void setDoc7(String doc7) {
		this.doc7 = doc7;
	}
	
	@Column(name="DOC_8", length=1)
	public String getDoc8() {
		return doc8;
	}

	public void setDoc8(String doc8) {
		this.doc8 = doc8;
	}
	@Column(name="DOC_9", length=1)
	public String getDoc9() {
		return doc9;
	}

	public void setDoc9(String doc9) {
		this.doc9 = doc9;
	}
	@Column(name="DOC_10", length=1)
	public String getDoc10() {
		return doc10;
	}

	public void setDoc10(String doc10) {
		this.doc10 = doc10;
	}

	@Column(name="SEQ_NO", length=22)
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
	
	@Temporal(TemporalType.DATE)
    @Column(name="RECEIVE_DT", length=7)
	public Date getReceiveDt() {
		return receiveDt;
	}


	public void setReceiveDt(Date receiveDt) {
		this.receiveDt = receiveDt;
	}
	
	
	
}