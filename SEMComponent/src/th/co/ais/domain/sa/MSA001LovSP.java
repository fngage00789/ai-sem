package th.co.ais.domain.sa;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class MSA001LovSP extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected String rowId;
	protected String lovType;
	protected String lovCode;
	protected String lovVal;
	protected String lovName;
	protected String lovVal2;
	protected String lovName2;
	protected String lovVal3;
	protected String lovName3;
	protected Integer lovOrder;
	protected String remark;
	protected String lovCond1;
	protected String lovCond2;
	protected String lovCond3;
	protected String insertFlag;
	protected String updateFlag;
	protected String recordStatus;
	protected Long version;
	protected String strLovOrder;

	protected String docFlag;
	protected String docRemark;
	protected String docAmount;
	protected String showRemark;
	private String licenseDocument;
	private Date docEffectiveDt;
	
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getLovType() {
		return lovType;
	}

	public void setLovType(String lovType) {
		this.lovType = lovType;
	}

	public String getLovCode() {
		return lovCode;
	}

	public void setLovCode(String lovCode) {
		this.lovCode = lovCode;
	}

	public String getLovVal() {
		return lovVal;
	}

	public void setLovVal(String lovVal) {
		this.lovVal = lovVal;
	}

	public String getLovName() {
		return lovName;
	}

	public void setLovName(String lovName) {
		this.lovName = lovName;
	}

	public String getLovVal2() {
		return lovVal2;
	}

	public void setLovVal2(String lovVal2) {
		this.lovVal2 = lovVal2;
	}

	public String getLovName2() {
		return lovName2;
	}

	public void setLovName2(String lovName2) {
		this.lovName2 = lovName2;
	}

	public String getLovVal3() {
		return lovVal3;
	}

	public void setLovVal3(String lovVal3) {
		this.lovVal3 = lovVal3;
	}

	public String getLovName3() {
		return lovName3;
	}

	public void setLovName3(String lovName3) {
		this.lovName3 = lovName3;
	}

	public Integer getLovOrder() {
		return lovOrder;
	}

	public void setLovOrder(Integer lovOrder) {
		this.lovOrder = lovOrder;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLovCond1() {
		return lovCond1;
	}

	public void setLovCond1(String lovCond1) {
		this.lovCond1 = lovCond1;
	}

	public String getLovCond2() {
		return lovCond2;
	}

	public void setLovCond2(String lovCond2) {
		this.lovCond2 = lovCond2;
	}

	public String getLovCond3() {
		return lovCond3;
	}

	public void setLovCond3(String lovCond3) {
		this.lovCond3 = lovCond3;
	}

	public String getInsertFlag() {
		return insertFlag;
	}

	public void setInsertFlag(String insertFlag) {
		this.insertFlag = insertFlag;
	}

	public String getUpdateFlag() {
		return updateFlag;
	}

	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getStrLovOrder() {
		return strLovOrder;
	}

	public void setStrLovOrder(String strLovOrder) {
		this.strLovOrder = strLovOrder;
	}

	public String getDocFlag() {
		return docFlag;
	}

	public void setDocFlag(String docFlag) {
		this.docFlag = docFlag;
	}

	public String getDocRemark() {
		return docRemark;
	}

	public void setDocRemark(String docRemark) {
		this.docRemark = docRemark;
	}

	public String getShowRemark() {
		return showRemark;
	}

	public void setShowRemark(String showRemark) {
		this.showRemark = showRemark;
	}

	public String getDocAmount() {
		return docAmount;
	}

	public void setDocAmount(String docAmount) {
		this.docAmount = docAmount;
	}

	public String getLicenseDocument() {
		return licenseDocument;
	}

	public void setLicenseDocument(String licenseDocument) {
		this.licenseDocument = licenseDocument;
	}

	@Override
	public String toString() {
		return "MSA001LovSP [insertFlag=" + insertFlag + ", lovCode=" + lovCode
				+ ", lovCond1=" + lovCond1 + ", lovCond2=" + lovCond2
				+ ", lovCond3=" + lovCond3 + ", lovName=" + lovName
				+ ", lovName2=" + lovName2 + ", lovName3=" + lovName3
				+ ", lovOrder=" + lovOrder + ", lovType=" + lovType
				+ ", lovVal=" + lovVal + ", lovVal2=" + lovVal2 + ", lovVal3="
				+ lovVal3 + ", recordStatus=" + recordStatus + ", remark="
				+ remark + ", rowId=" + rowId + ", strLovOrder=" + strLovOrder
				+ ", updateFlag=" + updateFlag + ", version=" + version + "]";
	}

	@Override
	public String getCreateBy() {
		return createBy;
	}

	@Override
	public Date getCreateDt() {
		return createDt;
	}

	@Override
	public String getUpdateBy() {
		return updateBy;
	}

	@Override
	public Date getUpdateDt() {
		return updateDt;
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

	public Date getDocEffectiveDt() {
		return docEffectiveDt;
	}

	public void setDocEffectiveDt(Date docEffectiveDt) {
		this.docEffectiveDt = docEffectiveDt;
	}

}
