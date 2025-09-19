package th.co.ais.domain.si;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Psi005Srch extends AbstractDomain {
	
	private String contractId;
	private String contractNo;
	private String siteName;
	private String company;
	private String reqType;
	
	private String region;
	private String siteInfoId;
	private Date effDate;
	private Date expDate;
	private String sendRenewId;
	private String seqNo;
	private String cycleNo;
	private String docNo;
	private Date docDate;
	private String locationId;
	
	private String effDateStr;
	private String expDateStr;
	private String docDateStr;
	private String siInfoId;
	
	public String getSendRenewId() {
		return sendRenewId;
	}
	public void setSendRenewId(String sendRenewId) {
		this.sendRenewId = sendRenewId;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
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
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
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
	public String getCycleNo() {
		return cycleNo;
	}
	public void setCycleNo(String cycleNo) {
		this.cycleNo = cycleNo;
	}
	public String getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
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
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getEffDateStr() {
		return effDateStr;
	}
	public void setEffDateStr(String effDateStr) {
		this.effDateStr = effDateStr;
	}
	public String getExpDateStr() {
		return expDateStr;
	}
	public void setExpDateStr(String expDateStr) {
		this.expDateStr = expDateStr;
	}
	public String getDocDateStr() {
		return docDateStr;
	}
	public void setDocDateStr(String docDateStr) {
		this.docDateStr = docDateStr;
	}
	public String getSiInfoId() {
		return siInfoId;
	}
	public void setSiInfoId(String siInfoId) {
		this.siInfoId = siInfoId;
	}
	
	
}
