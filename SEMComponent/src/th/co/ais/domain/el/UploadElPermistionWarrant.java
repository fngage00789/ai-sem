package th.co.ais.domain.el;

import java.math.BigDecimal;
import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class UploadElPermistionWarrant extends AbstractDomain{
	
	private static final long serialVersionUID = -1670581313552324179L;
	
	private String rowId;
	private String lineNo;
	private String contractNo;
	private String company;
	private String siteName;
	private String locationId;
	private String locationCode;
	private String siteCode;
	private String province;
	private String docType;
	private Date docDt;
	private Date printDt;
	private String printSeq;
	private Date reqDt;
	private Date responeDt;
	private Date sentDocDt;
	private Date contractCopyDt;
	private Date sentSamDt;
	private String sentSamUser;
	private String sentSamTel;
	private String user;
	private String fileName;
	private String remark;
	private String result;
	private String status;
	private String logId;
	
	private String docDtStr;
	private String printDtStr;
	private String reqDtStr;
	private String responeDtStr;
	private String sentDocDtStr;
	private String contractCopyDtStr;
	private String sentSamDtStr;
	private String updateDtStr;
	private String errMsg;
	
	public String getLineNo() {
		return lineNo;
	}
	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
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
	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public Date getDocDt() {
		return docDt;
	}
	public void setDocDt(Date docDt) {
		this.docDt = docDt;
	}
	public Date getPrintDt() {
		return printDt;
	}
	public void setPrintDt(Date printDt) {
		this.printDt = printDt;
	}
	public String getPrintSeq() {
		return printSeq;
	}
	public void setPrintSeq(String printSeq) {
		this.printSeq = printSeq;
	}
	public Date getReqDt() {
		return reqDt;
	}
	public void setReqDt(Date reqDt) {
		this.reqDt = reqDt;
	}
	public Date getResponeDt() {
		return responeDt;
	}
	public void setResponeDt(Date responeDt) {
		this.responeDt = responeDt;
	}
	public Date getContractCopyDt() {
		return contractCopyDt;
	}
	public void setContractCopyDt(Date contractCopyDt) {
		this.contractCopyDt = contractCopyDt;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getDocDtStr() {
		return docDtStr;
	}
	public void setDocDtStr(String docDtStr) {
		this.docDtStr = docDtStr;
	}
	public String getPrintDtStr() {
		return printDtStr;
	}
	public void setPrintDtStr(String printDtStr) {
		this.printDtStr = printDtStr;
	}
	public String getReqDtStr() {
		return reqDtStr;
	}
	public void setReqDtStr(String reqDtStr) {
		this.reqDtStr = reqDtStr;
	}
	public String getResponeDtStr() {
		return responeDtStr;
	}
	public void setResponeDtStr(String responeDtStr) {
		this.responeDtStr = responeDtStr;
	}
	public String getContractCopyDtStr() {
		return contractCopyDtStr;
	}
	public void setContractCopyDtStr(String contractCopyDtStr) {
		this.contractCopyDtStr = contractCopyDtStr;
	}
	public String getUpdateDtStr() {
		return updateDtStr;
	}
	public void setUpdateDtStr(String updateDtStr) {
		this.updateDtStr = updateDtStr;
	}
	public Date getSentDocDt() {
		return sentDocDt;
	}
	public void setSentDocDt(Date sentDocDt) {
		this.sentDocDt = sentDocDt;
	}
	public Date getSentSamDt() {
		return sentSamDt;
	}
	public void setSentSamDt(Date sentSamDt) {
		this.sentSamDt = sentSamDt;
	}
	public String getSentSamUser() {
		return sentSamUser;
	}
	public void setSentSamUser(String sentSamUser) {
		this.sentSamUser = sentSamUser;
	}
	public String getSentSamTel() {
		return sentSamTel;
	}
	public void setSentSamTel(String sentSamTel) {
		this.sentSamTel = sentSamTel;
	}
	public String getSentDocDtStr() {
		return sentDocDtStr;
	}
	public void setSentDocDtStr(String sentDocDtStr) {
		this.sentDocDtStr = sentDocDtStr;
	}
	public String getSentSamDtStr() {
		return sentSamDtStr;
	}
	public void setSentSamDtStr(String sentSamDtStr) {
		this.sentSamDtStr = sentSamDtStr;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	
}
