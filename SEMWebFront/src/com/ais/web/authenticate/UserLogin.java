package com.ais.web.authenticate;

import java.io.Serializable;
import java.util.List;

public class UserLogin implements Serializable {
	private static final long serialVersionUID = 1645767834543338118L;

	private UserLoginStatus status;
	private String errorMessage;
	private String mainPage;

	private String userName;
	private String password;
	private boolean ssoLogin;

	private List<RoleMenu> roleMenues;
	private List<String> userSSOProgramCodes;

	private String token;
	private String roleId;
	private String subModuleId;
	private String roleName;
	private String subModuleName;
	private String firstName;
	private String lastName;
	private String theme;
	private String template;
	private String host;

	private String locationCode;
	private String groupLocation;
	private String departmentCode;
	private String sectionCode;
	private String positionByJob;

	public List<String> getUserSSOProgramCodes() {
		return userSSOProgramCodes;
	}

	public void setUserSSOProgramCodes(List<String> userSSOProgramCodes) {
		this.userSSOProgramCodes = userSSOProgramCodes;
	}

	public UserLoginStatus getStatus() {
		return status;
	}

	public void setStatus(UserLoginStatus status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getMainPage() {
		return mainPage;
	}

	public void setMainPage(String mainPage) {
		this.mainPage = mainPage;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isSsoLogin() {
		return ssoLogin;
	}

	public void setSsoLogin(boolean ssoLogin) {
		this.ssoLogin = ssoLogin;
	}

	public List<RoleMenu> getRoleMenues() {
		return roleMenues;
	}

	public void setRoleMenues(List<RoleMenu> roleMenues) {
		this.roleMenues = roleMenues;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getSubModuleId() {
		return subModuleId;
	}

	public void setSubModuleId(String subModuleId) {
		this.subModuleId = subModuleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getSubModuleName() {
		return subModuleName;
	}

	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getGroupLocation() {
		return groupLocation;
	}

	public void setGroupLocation(String groupLocation) {
		this.groupLocation = groupLocation;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getSectionCode() {
		return sectionCode;
	}

	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	public String getPositionByJob() {
		return positionByJob;
	}

	public void setPositionByJob(String positionByJob) {
		this.positionByJob = positionByJob;
	}

}
