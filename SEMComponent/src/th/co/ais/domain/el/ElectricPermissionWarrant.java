package th.co.ais.domain.el;

import java.math.BigDecimal;
import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class ElectricPermissionWarrant extends AbstractDomain{

	private static final long serialVersionUID = -6267265526111546674L;
	private String rowId;
	private String contractNo;
	private String company;
	private String siteName;
	private String locationId;
	private String locationCode;
	private String siteCode;
	private String province;
	private String docType;
	private String docDt;
	private String printDt;
	private String printSeq;
	private String reqDt;
	private String responeDt;
	private String sentDocDt;
	private String contractCopyDt;
	private String sentSamDt;
	private String sentSamUser;
	private String sentSamTel;
	private String user;
	private String fileName;
	private String remark;
	
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

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
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

	public String getDocDt() {
		return docDt;
	}

	public void setDocDt(String docDt) {
		this.docDt = docDt;
	}

	public String getPrintDt() {
		return printDt;
	}

	public void setPrintDt(String printDt) {
		this.printDt = printDt;
	}

	public String getPrintSeq() {
		return printSeq;
	}

	public void setPrintSeq(String printSeq) {
		this.printSeq = printSeq;
	}

	public String getReqDt() {
		return reqDt;
	}

	public void setReqDt(String reqDt) {
		this.reqDt = reqDt;
	}

	public String getResponeDt() {
		return responeDt;
	}

	public void setResponeDt(String responeDt) {
		this.responeDt = responeDt;
	}

	public String getContractCopyDt() {
		return contractCopyDt;
	}

	public void setContractCopyDt(String contractCopyDt) {
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

	public String getSentDocDt() {
		return sentDocDt;
	}

	public void setSentDocDt(String sentDocDt) {
		this.sentDocDt = sentDocDt;
	}

	public String getSentSamDt() {
		return sentSamDt;
	}

	public void setSentSamDt(String sentSamDt) {
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
