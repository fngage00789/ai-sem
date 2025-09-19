package th.co.ais.web.bean;

import java.io.Serializable;

public class UserSession implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1416678821907119223L;
	private String loginDateTime; 
	private String navModule = "home";
	private String navProgram = "SEMH001";
	private String progCode;
	private String screenName;
	private String refId;
	
	public String getNavModule() {
		return navModule;
	}

	public void setNavModule(String navModule) {
		this.navModule = navModule;
	}

	public String getNavProgram() {
		return navProgram;
	}

	public void setNavProgram(String navProgram) {
		this.navProgram = navProgram;
	}

	public String getLoginDateTime() {
		return loginDateTime;
	}
	
	public void setLoginDateTime(String loginDateTime) {
		this.loginDateTime = loginDateTime;
	}

	public String getProgCode() {
		return progCode;
	}

	public void setProgCode(String progCode) {
		this.progCode = progCode;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}	
	
}
