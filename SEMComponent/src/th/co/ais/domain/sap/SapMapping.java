package th.co.ais.domain.sap;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SEM_CT_SAP_MAPPING", schema="SEM")
public class SapMapping implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4833720385895342272L;
	
	private String rowId;
	private String templateId;
	private Integer sequence;
	private String fieldName;
	private Integer mandatory;
	private String sapCode;
	private String description;
	private String detail;
	private String remark;
	private String tableName;
	private String className;
	private String fieldDbName;
	private String type;
	private Integer length;
	private String format;
	private String locale;

	@Id
	@Column(name = "ROWID", unique=true)
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	@Column(name = "TEMPLATE_ID", length = 100)
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	
	@Column(name = "SEQUENCE", precision = 5)
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	
	@Column(name = "FIELD_NAME", length = 50)
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	@Column(name = "MANDATORY", precision = 1)
	public Integer getMandatory() {
		return mandatory;
	}
	public void setMandatory(Integer mandatory) {
		this.mandatory = mandatory;
	}
	
	@Column(name = "SAP_CODE", length = 50)
	public String getSapCode() {
		return sapCode;
	}
	public void setSapCode(String sapCode) {
		this.sapCode = sapCode;
	}
	
	@Column(name = "DESCRIPTION", length = 250)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "DETAIL", length = 250)
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	@Column(name = "REMARK", length = 250)
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "TABLE_NAME", length = 50)
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	@Column(name = "FIELD_DB_NAME", length = 50)
	public String getFieldDbName() {
		return fieldDbName;
	}
	public void setFieldDbName(String fieldDbName) {
		this.fieldDbName = fieldDbName;
	}
	
	@Column(name = "CLASS_NAME", length = 100)
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@Column(name = "TYPE", length = 50)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name = "LENGTH", precision = 5, scale = 0)
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	
	@Column(name = "FORMAT", length = 100)
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	
	@Column(name = "LOCALE", length = 100)
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}

}