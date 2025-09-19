package th.co.ais.domain.si;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class SiteApproveSP extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5415687623468195762L;
	
	private String siteApproveId;
	private String docNo;
	private Date docDate;
	private String reqOfficer;
	private String company;
	private String reqDocType;
	private String reqType;
	private String title;
	private String siteInfoId;
	private String contractNo;
	private String detail;
	private String siteApproveStatus;
	private Date outDt;
	private String region;
	
	public String getSiteApproveId() {
		return siteApproveId;
	}
	public void setSiteApproveId(String siteApproveId) {
		this.siteApproveId = siteApproveId;
	}
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public Date getDocDate() {
		return docDate;
	}
	public void setDocDate(Date docDate) {
		this.docDate = docDate;
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
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getSiteApproveStatus() {
		return siteApproveStatus;
	}
	public void setSiteApproveStatus(String siteApproveStatus) {
		this.siteApproveStatus = siteApproveStatus;
	}
	public Date getOutDt() {
		return outDt;
	}
	public void setOutDt(Date outDt) {
		this.outDt = outDt;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getReqDocType() {
		return reqDocType;
	}
	public void setReqDocType(String reqDocType) {
		this.reqDocType = reqDocType;
	}
	public String getReqType() {
		return reqType;
	}
	public void setReqType(String reqType) {
		this.reqType = reqType;
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
