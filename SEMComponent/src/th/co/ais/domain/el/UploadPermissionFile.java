package th.co.ais.domain.el;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Transient;

import th.co.ais.domain.AbstractDomain;

public class UploadPermissionFile extends AbstractDomain implements Serializable{

	private static final long serialVersionUID = -2860999448787683893L;
	
	private String rowId;	
	private String fileName;	
	private String filePath;
	private String successNo;
	private String failedNo;
	private String recordStatus;	
	private String failedLine;
	private String totalNo;
	
	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getSuccessNo() {
		return successNo;
	}
	public void setSuccessNo(String successNo) {
		this.successNo = successNo;
	}
	public String getFailedNo() {
		return failedNo;
	}
	public void setFailedNo(String failedNo) {
		this.failedNo = failedNo;
	}
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	public String getFailedLine() {
		return failedLine;
	}
	public void setFailedLine(String failedLine) {
		this.failedLine = failedLine;
	}
	public String getTotalNo() {
		return totalNo;
	}
	public void setTotalNo(String totalNo) {
		this.totalNo = totalNo;
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
	
	@Transient
	public boolean isError(){
		
		boolean booleanReturn = false;
		if(null!=failedLine && !"".equals(failedLine)){
			booleanReturn = true;
		}
		
		return booleanReturn;
	}
}
