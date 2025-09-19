package com.ais.sem.model;

import java.util.Date;

public class SMSModel {

	private String mobileNo;
	private String vHeader;
	private String vMessage;
	private String pType;
	private String pRowId;
	
	
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getvHeader() {
		return vHeader;
	}

	public void setvHeader(String vHeader) {
		this.vHeader = vHeader;
	}

	public String getvMessage() {
		return vMessage;
	}

	public void setvMessage(String vMessage) {
		this.vMessage = vMessage;
	}

	public String getpType() {
		return pType;
	}

	public void setpType(String pType) {
		this.pType = pType;
	}

	public String getpRowId() {
		return pRowId;
	}

	public void setpRowId(String pRowId) {
		this.pRowId = pRowId;
	}

}
