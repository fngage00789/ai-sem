package th.co.ais.domain.gm;

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

@org.hibernate.annotations.NamedNativeQuery(
		name="queryCT007Search",
		query="call SEM.SEM_SP_MCT007_SRCH(?, :lovType, :lovName, :recordStatus, :lovCond1)",
		callable = true, 
//		readOnly = true,
		resultClass=LovMaster.class
) 

@Entity
@Table(name = "SEM_CT_LOV_MASTER", schema = "SEM")
public class LovMaster extends AbstractDomain {

	// Fields

	private String rowId;
	private String lovType;
	private String lovCode;
	private String lovVal;
	private String lovName;
	private String lovVal2;
	private String lovName2;
	private String lovVal3;
	private String lovName3;
	private Integer lovOrder;
	private String remark;
	private String lovCond1;
	private String lovCond2;
	private String lovCond3;
	private String insertFlag;
	private String updateFlag;
	private String recordStatus;
	private Long version;
	private String strLovOrder;

	// Property accessors
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "LOV_MASTER_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "LOV_TYPE", nullable = false, length = 50)
	public String getLovType() {
		return this.lovType;
	}

	public void setLovType(String lovType) {
		this.lovType = lovType;
	}

	@Column(name = "LOV_CODE", nullable = false, length = 50)
	public String getLovCode() {
		return this.lovCode;
	}

	public void setLovCode(String lovCode) {
		this.lovCode = lovCode;
	}

	@Column(name = "LOV_VAL", length = 50)
	public String getLovVal() {
		return this.lovVal;
	}

	public void setLovVal(String lovVal) {
		this.lovVal = lovVal;
	}

	@Column(name = "LOV_NAME", length = 250)
	public String getLovName() {
		return this.lovName;
	}

	public void setLovName(String lovName) {
		this.lovName = lovName;
	}

	@Column(name = "LOV_VAL2", length = 50)
	public String getLovVal2() {
		return this.lovVal2;
	}

	public void setLovVal2(String lovVal2) {
		this.lovVal2 = lovVal2;
	}

	@Column(name = "LOV_NAME2", length = 250)
	public String getLovName2() {
		return this.lovName2;
	}

	public void setLovName2(String lovName2) {
		this.lovName2 = lovName2;
	}

	@Column(name = "LOV_VAL3", length = 50)
	public String getLovVal3() {
		return this.lovVal3;
	}

	public void setLovVal3(String lovVal3) {
		this.lovVal3 = lovVal3;
	}

	@Column(name = "LOV_NAME3", length = 250)
	public String getLovName3() {
		return this.lovName3;
	}

	public void setLovName3(String lovName3) {
		this.lovName3 = lovName3;
	}

	@Column(name = "LOV_ORDER", precision = 5, scale = 0)
	public Integer getLovOrder() {
		return this.lovOrder;
	}

	public void setLovOrder(Integer lovOrder) {
		this.lovOrder = lovOrder;
	}

	@Column(name = "REMARK", length = 500)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "LOV_COND1", length = 50)
	public String getLovCond1() {
		return this.lovCond1;
	}

	public void setLovCond1(String lovCond1) {
		this.lovCond1 = lovCond1;
	}

	@Column(name = "LOV_COND2", length = 50)
	public String getLovCond2() {
		return this.lovCond2;
	}

	public void setLovCond2(String lovCond2) {
		this.lovCond2 = lovCond2;
	}

	@Column(name = "LOV_COND3", length = 50)
	public String getLovCond3() {
		return this.lovCond3;
	}

	public void setLovCond3(String lovCond3) {
		this.lovCond3 = lovCond3;
	}

	@Column(name = "INSERT_FLAG", length = 1)
	public String getInsertFlag() {
		return this.insertFlag;
	}

	public void setInsertFlag(String insertFlag) {
		this.insertFlag = insertFlag;
	}

	@Column(name = "UPDATE_FLAG", nullable = false, length = 1)
	public String getUpdateFlag() {
		return this.updateFlag;
	}

	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
	}

	@Column(name = "RECORD_STATUS", nullable = false, length = 1)
	public String getRecordStatus() {
		return this.recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	
	@Version
	@Column(name = "VERSION", precision = 10, scale = 0)
	public Long getVersion() {
		return this.version;
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
	
	@Transient
	public String getStrLovOrder() {
		return strLovOrder;
	}

	public void setStrLovOrder(String strLovOrder) {
		this.strLovOrder = strLovOrder;
	}

	@Override
	public String toString() {
		return "LovMaster [insertFlag=" + insertFlag + ", lovCode=" + lovCode
				+ ", lovCond1=" + lovCond1 + ", lovCond2=" + lovCond2
				+ ", lovCond3=" + lovCond3 + ", lovName=" + lovName
				+ ", lovName2=" + lovName2 + ", lovName3=" + lovName3
				+ ", lovOrder=" + lovOrder + ", lovType=" + lovType
				+ ", lovVal=" + lovVal + ", lovVal2=" + lovVal2 + ", lovVal3="
				+ lovVal3 + ", recordStatus=" + recordStatus + ", remark="
				+ remark + ", rowId=" + rowId + ", strLovOrder=" + strLovOrder
				+ ", updateFlag=" + updateFlag + ", version=" + version + "]";
	}
	
}