package th.co.ais.domain.cp;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class ProxyConStructionUploadElPermistionWarrant  extends AbstractDomain{

	private static final long serialVersionUID = 232311304691074117L;
	private String rowId;
	private String contractNo;
	private String company;
	private String siteName;
	private String locationId;
	private String locationCode;
	
	//new var
	private Date ctStartDt;
	private Date ctFinishDt;
	private String areaType;
	private String address;
	private String tumbon;
	private String amphur;
	private String province;
	private String electricType;
	private String state;
	private String status;
    private Date subDt;
    private String subCon;
    private String subConCode;
    private String phase;
    private String postCode;
    private String supplier;
    private String printFlag;
    private String msg;
    private String errMsg;
    
	private String lineNo;
	private String siteCode;
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
	private String logId;
	
	private String docDtStr;
	private String printDtStr;
	private String reqDtStr;
	private String responeDtStr;
	private String sentDocDtStr;
	private String contractCopyDtStr;
	private String sentSamDtStr;
	
	private String ctStartDtStr;
	private String ctFinishDtStr;
	private String region;
    private String typeAttenna;
    private String hightAttenna;
    private String department;
    private String departmentCode;
    private String subDtStr;
    private String updateDtStr;
    
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

	public Date getCtStartDt() {
		return ctStartDt;
	}

	public void setCtStartDt(Date ctStartDt) {
		this.ctStartDt = ctStartDt;
	}

	public Date getCtFinishDt() {
		return ctFinishDt;
	}

	public void setCtFinishDt(Date ctFinishDt) {
		this.ctFinishDt = ctFinishDt;
	}

	public String getAreaType() {
		return areaType;
	}

	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTumbon() {
		return tumbon;
	}

	public void setTumbon(String tumbon) {
		this.tumbon = tumbon;
	}

	public String getAmphur() {
		return amphur;
	}

	public void setAmphur(String amphur) {
		this.amphur = amphur;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getElectricType() {
		return electricType;
	}

	public void setElectricType(String electricType) {
		this.electricType = electricType;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getSubDt() {
		return subDt;
	}

	public void setSubDt(Date subDt) {
		this.subDt = subDt;
	}

	public String getSubCon() {
		return subCon;
	}

	public void setSubCon(String subCon) {
		this.subCon = subCon;
	}

	public String getSubConCode() {
		return subConCode;
	}

	public void setSubConCode(String subConCode) {
		this.subConCode = subConCode;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getPrintFlag() {
		return printFlag;
	}

	public void setPrintFlag(String printFlag) {
		this.printFlag = printFlag;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getLineNo() {
		return lineNo;
	}

	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
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

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
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

	public String getCtStartDtStr() {
		return ctStartDtStr;
	}

	public void setCtStartDtStr(String ctStartDtStr) {
		this.ctStartDtStr = ctStartDtStr;
	}

	public String getCtFinishDtStr() {
		return ctFinishDtStr;
	}

	public void setCtFinishDtStr(String ctFinishDtStr) {
		this.ctFinishDtStr = ctFinishDtStr;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getTypeAttenna() {
		return typeAttenna;
	}

	public void setTypeAttenna(String typeAttenna) {
		this.typeAttenna = typeAttenna;
	}

	public String getHightAttenna() {
		return hightAttenna;
	}

	public void setHightAttenna(String hightAttenna) {
		this.hightAttenna = hightAttenna;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getSubDtStr() {
		return subDtStr;
	}

	public void setSubDtStr(String subDtStr) {
		this.subDtStr = subDtStr;
	}

	public String getUpdateDtStr() {
		return updateDtStr;
	}

	public void setUpdateDtStr(String updateDtStr) {
		this.updateDtStr = updateDtStr;
	}

	
	
}
