package th.co.ais.domain.gm;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.transaction.annotation.Transactional;

import th.co.ais.domain.AbstractDomain;

@Entity
@Table(name="SEM_CT_ATTACHMENT", schema="SEM")
public class Attachment extends AbstractDomain {

	// Fields

	private String rowId;
	private String attachmentModule;
	private String refferenceId;
	private String attachmentPath;
	private String fileName;
	private String recordStatus;
	private Long version;
	private Calendar c;
	private String attachmentSubModule;
	private String attachmentPublic;
	private String contractNo;
	private String[] publicArr;

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "ATTACHMENT_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "ATTACHMENT_MODULE", length = 20)
	public String getAttachmentModule() {
		return attachmentModule;
	}

	public void setAttachmentModule(String attachmentModule) {
		this.attachmentModule = attachmentModule;
	}

	@Column(name = "REFFERENCE_ID", length = 50)
	public String getRefferenceId() {
		return refferenceId;
	}

	public void setRefferenceId(String refferenceId) {
		this.refferenceId = refferenceId;
	}

	@Column(name = "ATTACHMENT_PATH", length = 250)
	public String getAttachmentPath() {
		return attachmentPath;
	}

	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}

	@Column(name = "FILE_NAME", length = 100)
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "RECORD_STATUS", length = 5)
	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	
	@Version
	@Column(name = "VERSION", precision = 10, scale = 0)
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	@Override
	@Column(name = "CREATE_DT")
	public Date getCreateDt() {
		return createDt;
	}
	
	@Transient
	public Date getCreateThDt() {
		if(createDt != null){
			c = Calendar.getInstance();
			c.setTime(createDt);
			c.add(Calendar.YEAR, 543);
			return c.getTime();
		}
		return null;
	}
	
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	@Override
	@Column(name = "CREATE_BY", length = 50)
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	
	@Override
	@Column(name = "UPDATE_DT")
	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}
	
	@Override
	@Column(name = "UPDATE_BY", length = 50)
	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Column(name = "ATTACHMENT_SUB_MODULE", length = 20)
	public String getAttachmentSubModule() {
		return attachmentSubModule;
	}

	public void setAttachmentSubModule(String attachmentSubModule) {
		this.attachmentSubModule = attachmentSubModule;
	}

	@Column(name = "ATTACHMENT_PUBLIC", length = 2)
	public String getAttachmentPublic() {
		return attachmentPublic;
	}

	public void setAttachmentPublic(String attachmentPublic) {
		this.attachmentPublic = attachmentPublic;
	}

	@Column(name = "CONTRACT_NO", length = 50)
	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	@Transient
	public String[] getPublicArr() {
		return publicArr;
	}

	public void setPublicArr(String[] publicArr) {
		this.publicArr = publicArr;
	}

}