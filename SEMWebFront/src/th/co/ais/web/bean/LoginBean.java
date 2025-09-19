package th.co.ais.web.bean;

import java.io.Serializable;

public class LoginBean implements Serializable {
	private String username;
	private String password;
	private String errorMsg;
	private boolean displayErrorMsg = false;
	
	public LoginBean() {
		super();
		this.displayErrorMsg = false;
	}

	public boolean isDisplayErrorMsg() {
		return displayErrorMsg;
	}

	public void setDisplayErrorMsg(boolean displayErrorMsg) {
		this.displayErrorMsg = displayErrorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
