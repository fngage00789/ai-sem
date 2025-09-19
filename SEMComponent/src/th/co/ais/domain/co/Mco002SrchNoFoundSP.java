package th.co.ais.domain.co;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mco002SrchNoFoundSP extends AbstractDomain{
	private static final long serialVersionUID = -7563082147781224969L;
	
	private String rowId;
	private String company;
	private String reqType;
	private String contractNo;
	private String region;
	private String contractStatus;
	private Date receiveDateFrom;
	private Date receiveDateTo;
	private String terminateFlag;
	private String strPico;
	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getReqType() {
		return reqType;
	}
	public void setReqType(String reqType) {
		this.reqType = reqType;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
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
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getContractStatus() {
		return contractStatus;
	}
	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}
	public Date getReceiveDateFrom() {
		return receiveDateFrom;
	}
	public void setReceiveDateFrom(Date receiveDateFrom) {
		this.receiveDateFrom = receiveDateFrom;
	}
	public Date getReceiveDateTo() {
		return receiveDateTo;
	}
	public void setReceiveDateTo(Date receiveDateTo) {
		this.receiveDateTo = receiveDateTo;
	}
	public String getTerminateFlag() {
		return terminateFlag;
	}
	public void setTerminateFlag(String terminateFlag) {
		this.terminateFlag = terminateFlag;
	}
	public String getStrPico() {
		return strPico;
	}
	public void setStrPico(String strPico) {
		this.strPico = strPico;
	}
	
}
