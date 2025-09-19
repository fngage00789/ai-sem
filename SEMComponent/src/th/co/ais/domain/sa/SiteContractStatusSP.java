package th.co.ais.domain.sa;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class SiteContractStatusSP extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected String rowId;
	protected String siteAppId;
	protected String siteContractStatusId;
	protected String seq;
	protected String contractStatus;
	protected String contractStatusText;
	
	protected String recordStatus;
	protected String remark;
	
	protected String strParam;
	protected String userLogin;
	
	protected String updateDtStr;
	
	protected boolean renderedDisplay;
	
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getSiteAppId() {
		return siteAppId;
	}

	public void setSiteAppId(String siteAppId) {
		this.siteAppId = siteAppId;
	}

	public String getSiteContractStatusId() {
		return siteContractStatusId;
	}

	public void setSiteContractStatusId(String siteContractStatusId) {
		this.siteContractStatusId = siteContractStatusId;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	public String getContractStatusText() {
		return contractStatusText;
	}

	public void setContractStatusText(String contractStatusText) {
		this.contractStatusText = contractStatusText;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStrParam() {
		return strParam;
	}

	public void setStrParam(String strParam) {
		this.strParam = strParam;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getUpdateDtStr() {
		return updateDtStr;
	}

	public void setUpdateDtStr(String updateDtStr) {
		this.updateDtStr = updateDtStr;
	}

	public boolean isRenderedDisplay() {
		return renderedDisplay;
	}

	public void setRenderedDisplay(boolean renderedDisplay) {
		this.renderedDisplay = renderedDisplay;
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

}
