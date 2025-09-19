package th.co.ais.rpt.parameter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SEMESI001ReportParameter extends ReportParameter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8725360699084037577L;
	private String docNo;
	private String company;
	private String region;
	private String reqType;
	private String title;
	private String assignContractNo;
	private String legalApproveStatus;
	private String locationId;
	private String locationCode;
	private String siteName;
	private String siteType;
	private String siteInfoStatus;
	private String siteStatus;
	private String contractNo;
	private String pendingStatus;
	private String expireStatus;
	private Date effectiveDtFrom;
	private Date effectiveDtTo;
	private Date expireDtFrom;
	private Date expireDtTo;
	private String noExpireFlag;
	private String lessorName;
	private String currentFlag;

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAssignContractNo() {
		return assignContractNo;
	}

	public void setAssignContractNo(String assignContractNo) {
		this.assignContractNo = assignContractNo;
	}

	public String getLegalApproveStatus() {
		return legalApproveStatus;
	}

	public void setLegalApproveStatus(String legalApproveStatus) {
		this.legalApproveStatus = legalApproveStatus;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getSiteType() {
		return siteType;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	public String getSiteInfoStatus() {
		return siteInfoStatus;
	}

	public void setSiteInfoStatus(String siteInfoStatus) {
		this.siteInfoStatus = siteInfoStatus;
	}

	public String getSiteStatus() {
		return siteStatus;
	}

	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getPendingStatus() {
		return pendingStatus;
	}

	public void setPendingStatus(String pendingStatus) {
		this.pendingStatus = pendingStatus;
	}

	public String getExpireStatus() {
		return expireStatus;
	}

	public void setExpireStatus(String expireStatus) {
		this.expireStatus = expireStatus;
	}

	public Date getEffectiveDtFrom() {
		return effectiveDtFrom;
	}

	public void setEffectiveDtFrom(Date effectiveDtFrom) {
		this.effectiveDtFrom = effectiveDtFrom;
	}

	public Date getEffectiveDtTo() {
		return effectiveDtTo;
	}

	public void setEffectiveDtTo(Date effectiveDtTo) {
		this.effectiveDtTo = effectiveDtTo;
	}

	public Date getExpireDtFrom() {
		return expireDtFrom;
	}

	public void setExpireDtFrom(Date expireDtFrom) {
		this.expireDtFrom = expireDtFrom;
	}

	public Date getExpireDtTo() {
		return expireDtTo;
	}

	public void setExpireDtTo(Date expireDtTo) {
		this.expireDtTo = expireDtTo;
	}

	public String getNoExpireFlag() {
		return noExpireFlag;
	}

	public void setNoExpireFlag(String noExpireFlag) {
		this.noExpireFlag = noExpireFlag;
	}

	public String getLessorName() {
		return lessorName;
	}

	public void setLessorName(String lessorName) {
		this.lessorName = lessorName;
	}

	public String getCurrentFlag() {
		return currentFlag;
	}

	public void setCurrentFlag(String currentFlag) {
		this.currentFlag = currentFlag;
	}

	@Override
	public Map getReportParameter() {
		parameters = new HashMap();
		parameters.put("PARAM_REPORT_ENGINE", reportEngine);
		parameters.put("PARAM_DOC_NO", docNo);
		parameters.put("PARAM_COMPANY", company);
		parameters.put("PARAM_REGION", region);
		parameters.put("PARAM_REQ_TYPE", reqType);
		parameters.put("PARAM_TITLE", title);
		parameters.put("PARAM_ASSIGN_CONTRACT_NO", assignContractNo);
		parameters.put("PARAM_LEGAL_APPROVE_STATUS", legalApproveStatus);
		parameters.put("PARAM_LOCATION_ID", locationId);
		parameters.put("PARAM_LOCATION_CODE", locationCode);
		parameters.put("PARAM_SITE_NAME", siteName);
		parameters.put("PARAM_SITE_TYPE", siteType);
		parameters.put("PARAM_SITE_INFO_STATUS", siteInfoStatus);
		parameters.put("PARAM_SITE_STATUS", siteStatus);
		parameters.put("PARAM_CONTRACT_NO", contractNo);
		parameters.put("PARAM_PENDING_STATUS", pendingStatus);
		parameters.put("PARAM_EXPIRE_STATUS", expireStatus);
		parameters.put("PARAM_EFFECTIVE_DT_FROM", effectiveDtFrom);
		parameters.put("PARAM_EFFECTIVE_DT_TO", effectiveDtTo);
		parameters.put("PARAM_EXPIRE_DT_FROM", expireDtFrom);
		parameters.put("PARAM_EXPIRE_DT_TO", expireDtTo);
		parameters.put("PARAM_NO_EXPIRE_FLAG", noExpireFlag);
		parameters.put("PARAM_LESSOR_NAME", lessorName);
		parameters.put("PARAM_CURRENT_FLAG", currentFlag);
		return parameters;
	}

}
