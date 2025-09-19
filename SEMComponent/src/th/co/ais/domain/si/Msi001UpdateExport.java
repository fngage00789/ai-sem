package th.co.ais.domain.si;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Msi001UpdateExport extends AbstractDomain{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7558424055697302327L;
	private String result;
	private String userId;
	private String siteApproveId;
	private String clearBatch;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSiteApproveId() {
		return siteApproveId;
	}
	public void setSiteApproveId(String siteApproveId) {
		this.siteApproveId = siteApproveId;
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
	public String getClearBatch() {
		return clearBatch;
	}
	public void setClearBatch(String clearBatch) {
		this.clearBatch = clearBatch;
	}
	
	
	
	
}
