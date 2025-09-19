package th.co.ais.domain.el;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class FirstPageProxyPermissionUploadFile  extends AbstractDomain{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4485444388639823853L;
	private String rowId;
	private String company;
	private String fileType;
	private String fileName;
	private String recordTotal;
	private String recordSuccess;
	private String recordfail;
	private String print;
	private String waitPrint;
	private String uploadBy;
	private Date uploadDt;
	private String region;
	private String typeUseElectric;
	private String reqType;
	private Date uploadFileDtTo;
	private Date uploadFileDtFrom;
	private String remark;
	private String result;
	
	private String province;
	private String contractNo;
	private String siteName;
	private String locationId;
	private String locationCode;
	private String statusContract;
	
	//new var
	private Date ctStartDt;
	private Date ctFinishDt;
	private String areaType;
	private String address;
	private String tumbon;
	private String amphur;
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
    private String batchNo;
	private String lineNo;
	private String siteCode;
	private String user;
	private String logId;
	private String flagPrint;
	
	private String ctStartDtStr;
	private String ctFinishDtStr;
	
	 private String typeAttenna;
	    private String hightAttenna;
	    private String department;
	    
	    
	    
		private String docType;
		private Date docDt;
		private Date printDt;
		private String printSeq;
		private Date reqDt;
		private Date responeDt;
		private Date contractCopyDt;
		private String docDtStr;
		private String printDtStr;
		private String reqDtStr;
		private String responeDtStr;
		private String contractCopyDtStr;
		
	    private String departmentCode;
	    private String subDtStr;
	    
	    
	    
	    //for print doc
	    private String typePermission;
	    private Date newPrintDt;
	    private Date expandPrintDt;
	    private Date transferPrintDt;
	    private Date terminatePrintDt;
	    private String processStatusCode;
	    
	    
	    
		public String getProcessStatusCode() {
			return processStatusCode;
		}
		public void setProcessStatusCode(String processStatusCode) {
			this.processStatusCode = processStatusCode;
		}
		public Date getExpandPrintDt() {
			return expandPrintDt;
		}
		public void setExpandPrintDt(Date expandPrintDt) {
			this.expandPrintDt = expandPrintDt;
		}
		public Date getTransferPrintDt() {
			return transferPrintDt;
		}
		public void setTransferPrintDt(Date transferPrintDt) {
			this.transferPrintDt = transferPrintDt;
		}
		public Date getTerminatePrintDt() {
			return terminatePrintDt;
		}
		public void setTerminatePrintDt(Date terminatePrintDt) {
			this.terminatePrintDt = terminatePrintDt;
		}
		public Date getNewPrintDt() {
			return newPrintDt;
		}
		public void setNewPrintDt(Date newPrintDt) {
			this.newPrintDt = newPrintDt;
		}
		public String getTypePermission() {
			return typePermission;
		}
		public void setTypePermission(String typePermission) {
			this.typePermission = typePermission;
		}
		public String getRowId() {
			return rowId;
		}
		public void setRowId(String rowId) {
			this.rowId = rowId;
		}
		public String getCompany() {
			return company;
		}
		public void setCompany(String company) {
			this.company = company;
		}
		public String getFileType() {
			return fileType;
		}
		public void setFileType(String fileType) {
			this.fileType = fileType;
		}
		public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
		public String getRecordTotal() {
			return recordTotal;
		}
		public void setRecordTotal(String recordTotal) {
			this.recordTotal = recordTotal;
		}
		public String getRecordSuccess() {
			return recordSuccess;
		}
		public void setRecordSuccess(String recordSuccess) {
			this.recordSuccess = recordSuccess;
		}
		public String getRecordfail() {
			return recordfail;
		}
		public void setRecordfail(String recordfail) {
			this.recordfail = recordfail;
		}
		public String getPrint() {
			return print;
		}
		public void setPrint(String print) {
			this.print = print;
		}
		public String getWaitPrint() {
			return waitPrint;
		}
		public void setWaitPrint(String waitPrint) {
			this.waitPrint = waitPrint;
		}
		public String getUploadBy() {
			return uploadBy;
		}
		public void setUploadBy(String uploadBy) {
			this.uploadBy = uploadBy;
		}
		public Date getUploadDt() {
			return uploadDt;
		}
		public void setUploadDt(Date uploadDt) {
			this.uploadDt = uploadDt;
		}
		public String getRegion() {
			return region;
		}
		public void setRegion(String region) {
			this.region = region;
		}
		public String getTypeUseElectric() {
			return typeUseElectric;
		}
		public void setTypeUseElectric(String typeUseElectric) {
			this.typeUseElectric = typeUseElectric;
		}
		public String getReqType() {
			return reqType;
		}
		public void setReqType(String reqType) {
			this.reqType = reqType;
		}
		public Date getUploadFileDtTo() {
			return uploadFileDtTo;
		}
		public void setUploadFileDtTo(Date uploadFileDtTo) {
			this.uploadFileDtTo = uploadFileDtTo;
		}
		public Date getUploadFileDtFrom() {
			return uploadFileDtFrom;
		}
		public void setUploadFileDtFrom(Date uploadFileDtFrom) {
			this.uploadFileDtFrom = uploadFileDtFrom;
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
		public String getProvince() {
			return province;
		}
		public void setProvince(String province) {
			this.province = province;
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
		public String getUser() {
			return user;
		}
		public void setUser(String user) {
			this.user = user;
		}
		public String getLogId() {
			return logId;
		}
		public void setLogId(String logId) {
			this.logId = logId;
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
		public String getDocDtStr() {
			return docDtStr;
		}
		public String getStatusContract() {
			return statusContract;
		}
		public void setStatusContract(String statusContract) {
			this.statusContract = statusContract;
		}
		
		public String getFlagPrint() {
			return flagPrint;
		}
		public void setFlagPrint(String flagPrint) {
			this.flagPrint = flagPrint;
		}
		public String getBatchNo() {
			return batchNo;
		}
		public void setBatchNo(String batchNo) {
			this.batchNo = batchNo;
		}
	    
	    
}
