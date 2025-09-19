package th.co.ais.domain.si;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class SiteApproveMapLocSeqSP extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5415687623468195762L;
	
	private String siteApproveId;
	private Integer seq;
	
	public String getSiteApproveId() {
		return siteApproveId;
	}
	public void setSiteApproveId(String siteApproveId) {
		this.siteApproveId = siteApproveId;
	}
	
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
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
	
}
