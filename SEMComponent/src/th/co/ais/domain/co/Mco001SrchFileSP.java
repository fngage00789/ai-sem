package th.co.ais.domain.co;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mco001SrchFileSP extends AbstractDomain{
	private static final long serialVersionUID = -7563082147781224969L;
	
	private String rowId;
	private String seqNo;
	private String contractDocType;
	private String contractDocTypeName;
	private String filePath;
	private String fileName;
	private String contractId;
	private String internalFlag;
	private String groupNo;
	
	public String getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	public String getContractDocType() {
		return contractDocType;
	}
	public void setContractDocType(String contractDocType) {
		this.contractDocType = contractDocType;
	}
	
	public String getContractDocTypeName() {
		return contractDocTypeName;
	}
	public void setContractDocTypeName(String contractDocTypeName) {
		this.contractDocTypeName = contractDocTypeName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	@Override
	public String getCreateBy() {
		return this.createBy;
	}
	@Override
	public Date getCreateDt() {
		return this.createDt;
	}
	@Override
	public String getUpdateBy() {
		return this.updateBy;
	}
	@Override
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
	public String getInternalFlag() {
		return internalFlag;
	}
	public void setInternalFlag(String internalFlag) {
		this.internalFlag = internalFlag;
	}
	public String getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}
	
}
