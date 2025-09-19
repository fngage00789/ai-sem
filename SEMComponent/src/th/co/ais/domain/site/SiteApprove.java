package th.co.ais.domain.site;

import java.io.Serializable;
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
@Table(name="SITE_APPROVE", schema="SEM")
public class SiteApprove extends AbstractDomain implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6020769786953992637L;
	private String rowId;
	private String siteApproveNo;
	private Date docDate;
	private String siteApproveFrom;
	private String company;
	private String approveType;
	private String subject;
	private String withContractNo;
	private String docStatus;
	private String locationId;
	private String cellSiteName;
	private String region;
	private Integer version;
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="ROW_ID",nullable=false,length=50)
	public String getRowId() {
		return rowId;
	}
	
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	@Version
	@Column(name="VERSION")
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	
	@Column(name="SITE_APPROVE_FROM")
	public String getSiteApproveFrom() {
		return siteApproveFrom;
	}
	
	public void setSiteApproveFrom(String siteApproveFrom) {
		this.siteApproveFrom = siteApproveFrom;
	}
	
	@Transient
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Column(name="SITE_APPROVE_NO")
	public String getSiteApproveNo() {
		return siteApproveNo;
	}
	
	public void setSiteApproveNo(String siteApproveNo) {
		this.siteApproveNo = siteApproveNo;
	}
	
	@Column(name="DOC_DATE")
	public Date getDocDate() {
		return docDate;
	}
	
	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}
	
	@Transient
	public String getApproveType() {
		return approveType;
	}
	
	public void setApproveType(String approveType) {
		this.approveType = approveType;
	}
	
	@Transient
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Transient
	public String getWithContractNo() {
		return withContractNo;
	}
	
	public void setWithContractNo(String withContractNo) {
		this.withContractNo = withContractNo;
	}
	
	@Transient
	public String getDocStatus() {
		return docStatus;
	}
	
	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}
	
	@Transient
	public String getLocationId() {
		return locationId;
	}
	
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	
	@Transient
	public String getCellSiteName() {
		return cellSiteName;
	}
	
	public void setCellSiteName(String cellSiteName) {
		this.cellSiteName = cellSiteName;
	}
	
	@Transient
	public String getRegion() {
		return region;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	@Column(name="CREATE_BY")
	public String getCreateBy() {
		return super.createBy;
	}

	@Override
	@Column(name="CREATE_DATE")
	public Date getCreateDt() {
		return super.createDt;
	}

	@Override
	@Column(name="UPDATE_BY")
	public String getUpdateBy() {
		return super.updateBy;
	}

	@Override
	@Column(name="UPDATE_DATE")
	public Date getUpdateDt() {
		return super.updateDt;
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
	
	

}
