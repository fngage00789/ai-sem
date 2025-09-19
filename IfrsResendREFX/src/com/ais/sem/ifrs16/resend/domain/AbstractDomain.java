package com.ais.sem.ifrs16.resend.domain;

import java.io.Serializable;
import java.util.Date;


public abstract class AbstractDomain implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//default value//
	protected Date createDt;
	protected String createBy;
	protected Date updateDt;
	protected String updateBy;

	
	public abstract String getCreateBy();
	public abstract void setCreateBy(String createBy);
	public abstract Date getCreateDt();
	public abstract void setCreateDt(Date createDt);
	public abstract String getUpdateBy();
	public abstract void setUpdateBy(String updateBy);
	public abstract Date getUpdateDt();
	public abstract void setUpdateDt(Date updateDt);
	
	protected String rowId;
	protected String currentUser;
	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}
	
}
