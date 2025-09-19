package th.co.ais.domain.el;

import java.math.BigDecimal;
import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class ElectricPermissionUploadFile extends AbstractDomain{
	
	private static final long serialVersionUID = -5918093381275530731L;
	private BigDecimal itemNo;
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
	private String processStatusCode;
	private String uploadDtStr;
	private String user;
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

	public BigDecimal getItemNo() {
		return itemNo;
	}

	public void setItemNo(BigDecimal itemNo) {
		this.itemNo = itemNo;
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

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
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

	public String getProcessStatusCode() {
		return processStatusCode;
	}

	public void setProcessStatusCode(String processStatusCode) {
		this.processStatusCode = processStatusCode;
	}

	public String getUploadDtStr() {
		return uploadDtStr;
	}

	public void setUploadDtStr(String uploadDtStr) {
		this.uploadDtStr = uploadDtStr;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	
}
