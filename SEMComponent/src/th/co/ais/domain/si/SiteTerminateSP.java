package th.co.ais.domain.si;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class SiteTerminateSP extends AbstractDomain{

	private static final long serialVersionUID = -1484929193127641552L;

	private String rowId;
	
	private String siteTerminateId;
	
	private String docNo;
	
	private String contractNo;
	
	private String reqOfficer;
	
	private String company;
	
	private String title;
	
	private Date docDate;
	
	private String locationId;
	
	private String locationName;
	
	private String region;
	
	private String networkStatus;
	
	private Date effDate;
	
	private Date expDate;
	
	private String siteInfoId;
	
	private Date invalidDate;
	
	private String detail;
	
	private String remark;
	
	private Date docDateFrom;
	
	private Date docDateTo;
	
	
	public Date getDocDateFrom() {
		return docDateFrom;
	}

	public void setDocDateFrom(Date docDateFrom) {
		this.docDateFrom = docDateFrom;
	}

	public Date getDocDateTo() {
		return docDateTo;
	}

	public void setDocDateTo(Date docDateTo) {
		this.docDateTo = docDateTo;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getSiteTerminateId() {
		return siteTerminateId;
	}

	public void setSiteTerminateId(String siteTerminateId) {
		this.siteTerminateId = siteTerminateId;
	}

	public Date getEffDate() {
		return effDate;
	}

	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	public Date getInvalidDate() {
		return invalidDate;
	}

	public void setInvalidDate(Date invalidDate) {
		this.invalidDate = invalidDate;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getReqOfficer() {
		return reqOfficer;
	}

	public void setReqOfficer(String reqOfficer) {
		this.reqOfficer = reqOfficer;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDocDate() {
		return docDate;
	}

	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	

	public String getNetworkStatus() {
		return networkStatus;
	}

	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
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
