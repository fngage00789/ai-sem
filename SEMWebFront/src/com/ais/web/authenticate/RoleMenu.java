package com.ais.web.authenticate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@org.hibernate.annotations.NamedNativeQuery(
	    name="queryBgRoleMenu",
	    query="call SEM.SEM_SP_GET_ROLEMENU(?, :bgEmployee, :bgProgramCode, :bgType)",
	    callable = true, readOnly = true,
	    resultClass=RoleMenu.class
	)  

@Entity
public class RoleMenu implements Serializable {
	private static final long serialVersionUID = 6289640714757328886L;
	
	@Id
	@Column(name="ROWNUM")
	private String rowId;
	
	@Column(name="SCREEN_ID")
	private String screenId;
	
	@Column(name="USER_ID")
	private String userId;
	
	@Column(name="ROLE_ID")
	private String roleId;
	
	@Column(name="PROGRAM_CODE")
	private String programCode;
	
	@Column(name="SCREEN_NAME")
	private String screenName;
	
	@Column(name="SCREEN_LINK")
	private String screenLink;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getScreenId() {
		return screenId;
	}

	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getScreenLink() {
		return screenLink;
	}

	public void setScreenLink(String screenLink) {
		this.screenLink = screenLink;
	}

	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}

	public String getProgramCode() {
		return programCode;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getRowId() {
		return rowId;
	}

}
