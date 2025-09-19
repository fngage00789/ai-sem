package th.co.ais.domain.gm;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
//import org.springframework.format.annotation.DateTimeFormat;

import th.co.ais.domain.AbstractDomain;

@Entity
@Table(name="SEM_CT_GL_ACCOUNT", schema="SEM")
public class GLAccount extends AbstractDomain {

	private String company;
	private String expenseType;
	private String glAccount;
	private String glAccDesc;
	private String recordStatus = "Y";
	private String placeType;
	private Date effectiveDate;
	private String glType;
	protected Long version;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "GL_ACCOUNT_ID", unique = true, nullable = false, length = 50)
	@Override
	public String getRowId() {
		return rowId;
	}

	@Override
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "COMPANY")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "EXPENSE_TYPE")
	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	@Column(name = "GL_ACCOUNT")
	public String getGlAccount() {
		return glAccount;
	}

	public void setGlAccount(String glAccount) {
		this.glAccount = glAccount;
	}

	@Column(name = "GL_ACCOUNT_DESC")
	public String getGlAccDesc() {
		return glAccDesc;
	}

	public void setGlAccDesc(String glAccDesc) {
		this.glAccDesc = glAccDesc;
	}

	@Column(name = "RECORD_STATUS")
	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	@Column(name = "PLACE_TYPE")
	public String getPlaceType() {
		return placeType;
	}

	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}

	@Column(name = "EFFECTIVE_DT")
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	@Version
	@Column(name = "VERSION", precision = 10, scale = 0, nullable = false)
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	@Column(name = "CREATE_DT")
	//@DateTimeFormat(pattern = "dd/MM/yyyy")
	public Date getCreateDt() {
		return this.createDt;
	}

	@Override
	@Column(name = "UPDATE_DT")
	//@DateTimeFormat(pattern = "dd/MM/yyyy")
	public Date getUpdateDt() {
		return this.updateDt;
	}

	@Override
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	@Override
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	@Column(name="CREATE_BY")
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	
	@Column(name="UPDATE_BY")
	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Column(name="GL_TYPE")
	public String getGlType() {
		return glType;
	}

	public void setGlType(String glType) {
		this.glType = glType;
	}
 
	
}
