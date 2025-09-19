package com.ais.sem.vendor.model;

public class VendorMaster {
	private String fileName;
	private String userId;
	private String email;
	
	@Override
	public String toString() {
		return "VendorMaster [email=" + email + ", fileName=" + fileName
				+ ", userId=" + userId + "]";
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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
	
}
