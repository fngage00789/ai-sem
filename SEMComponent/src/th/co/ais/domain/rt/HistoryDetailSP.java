package th.co.ais.domain.rt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class HistoryDetailSP extends AbstractDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2780567199424408811L;
	private String siteChangeId;
	private String docNo;
	private String siteChangeCode;
	private String siteChangeDesc;
	private String detail;
	private String siteinfoId;
	
	
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
	public String getSiteChangeId() {
		return siteChangeId;
	}
	public void setSiteChangeId(String siteChangeId) {
		this.siteChangeId = siteChangeId;
	}
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public String getSiteChangeCode() {
		return siteChangeCode;
	}
	public void setSiteChangeCode(String siteChangeCode) {
		this.siteChangeCode = siteChangeCode;
	}
	public String getSiteChangeDesc() {
		return siteChangeDesc;
	}
	public void setSiteChangeDesc(String siteChangeDesc) {
		this.siteChangeDesc = siteChangeDesc;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getSiteinfoId() {
		return siteinfoId;
	}
	public void setSiteinfoId(String siteinfoId) {
		this.siteinfoId = siteinfoId;
	}
		
	
}
