package th.co.ais.domain.si;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class SiteInfoRegHistSrch extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4968904415270343894L;
	
	private String rowId;
	private String contractNo;
	private Date effectiveDt;	
	private Date expireDt;	
	private String reqOffOld;
	private String reqOffNew;	
	private String remark;
	private String modifyBy;
	private Date modifyDt;	
	private String contractStatus;
	private String slimsStatus;
	private String networkStatus;
	
	private String siteAppServId;
	private String siteInfoServId;
	private String servName;
	private String action;
	private String seq;
	
	private String createDtStr;
	private String updateDtStr;
	
	private String reqOfficerOld;
	private String reqOfficerNew;
	
	private String effectiveDtStr;	
	private String expireDtStr;	
	private String modifyDtStr;	
	private String serviceId;
	
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public Date getEffectiveDt() {
		return effectiveDt;
	}

	public void setEffectiveDt(Date effectiveDt) {
		this.effectiveDt = effectiveDt;
	}

	public Date getExpireDt() {
		return expireDt;
	}

	public void setExpireDt(Date expireDt) {
		this.expireDt = expireDt;
	}

	public String getReqOffOld() {
		return reqOffOld;
	}

	public void setReqOffOld(String reqOffOld) {
		this.reqOffOld = reqOffOld;
	}

	public String getReqOffNew() {
		return reqOffNew;
	}

	public void setReqOffNew(String reqOffNew) {
		this.reqOffNew = reqOffNew;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyDt() {
		return modifyDt;
	}

	public void setModifyDt(Date modifyDt) {
		this.modifyDt = modifyDt;
	}

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	public String getSlimsStatus() {
		return slimsStatus;
	}

	public void setSlimsStatus(String slimsStatus) {
		this.slimsStatus = slimsStatus;
	}

	public String getNetworkStatus() {
		return networkStatus;
	}

	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
	}

	public String getSiteAppServId() {
		return siteAppServId;
	}

	public void setSiteAppServId(String siteAppServId) {
		this.siteAppServId = siteAppServId;
	}

	public String getServName() {
		return servName;
	}

	public void setServName(String servName) {
		this.servName = servName;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getCreateDtStr() {
		return createDtStr;
	}

	public void setCreateDtStr(String createDtStr) {
		this.createDtStr = createDtStr;
	}

	public String getUpdateDtStr() {
		return updateDtStr;
	}

	public void setUpdateDtStr(String updateDtStr) {
		this.updateDtStr = updateDtStr;
	}

	public String getReqOfficerOld() {
		return reqOfficerOld;
	}

	public void setReqOfficerOld(String reqOfficerOld) {
		this.reqOfficerOld = reqOfficerOld;
	}

	public String getReqOfficerNew() {
		return reqOfficerNew;
	}

	public void setReqOfficerNew(String reqOfficerNew) {
		this.reqOfficerNew = reqOfficerNew;
	}

	public String getEffectiveDtStr() {
		return effectiveDtStr;
	}

	public void setEffectiveDtStr(String effectiveDtStr) {
		this.effectiveDtStr = effectiveDtStr;
	}

	public String getExpireDtStr() {
		return expireDtStr;
	}

	public void setExpireDtStr(String expireDtStr) {
		this.expireDtStr = expireDtStr;
	}

	public String getModifyDtStr() {
		return modifyDtStr;
	}

	public void setModifyDtStr(String modifyDtStr) {
		this.modifyDtStr = modifyDtStr;
	}

	public String getSiteInfoServId() {
		return siteInfoServId;
	}

	public void setSiteInfoServId(String siteInfoServId) {
		this.siteInfoServId = siteInfoServId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	@Override
	public String getCreateBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getCreateDt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUpdateBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getUpdateDt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCreateBy(String createBy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCreateDt(Date createDt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUpdateBy(String updateBy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUpdateDt(Date updateDt) {
		// TODO Auto-generated method stub
		
	}

}
