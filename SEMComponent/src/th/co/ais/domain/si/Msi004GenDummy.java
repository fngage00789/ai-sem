package th.co.ais.domain.si;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Msi004GenDummy extends AbstractDomain {

	private String pResult;
	private String pRemark;
	private String pDocNo;
	private String pSiteApproveId;
	private String pSiteInfoId;
	private String company;
	private String user;
	private String locationId;
	
	
	public String getpResult() {
		return pResult;
	}

	public void setpResult(String pResult) {
		this.pResult = pResult;
	}

	public String getpRemark() {
		return pRemark;
	}

	public void setpRemark(String pRemark) {
		this.pRemark = pRemark;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getpDocNo() {
		return pDocNo;
	}

	public void setpDocNo(String pDocNo) {
		this.pDocNo = pDocNo;
	}

	public String getpSiteApproveId() {
		return pSiteApproveId;
	}

	public void setpSiteApproveId(String pSiteApproveId) {
		this.pSiteApproveId = pSiteApproveId;
	}

	public String getpSiteInfoId() {
		return pSiteInfoId;
	}

	public void setpSiteInfoId(String pSiteInfoId) {
		this.pSiteInfoId = pSiteInfoId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
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
