package com.ais.migrate.sem.model;

import java.io.Serializable;
import java.util.Date;

public class SyncFile implements Serializable{
	
	private Exception ex;	
	private String fileName;
	private Integer totalRecord;
	private Double totalAmount;
	private String userId;
	private String email;
	private Date createDate;
	private Date time;
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}
	public Integer getTotalRecord() {
		return totalRecord;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Date getTime() {
		return time;
	}
	public void setEx(Exception ex) {
		this.ex = ex;
	}
	public Exception getEx() {
		return ex;
	}
	
}
