package th.co.ais.web.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class ReActivateSsoToken implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8185636934308030210L;

	private String sessionId;
	private String username;
	private String tokenId;

	private Timestamp loginDt;
	private Timestamp activateDt;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public Timestamp getLoginDt() {
		return loginDt;
	}

	public void setLoginDt(Timestamp loginDt) {
		this.loginDt = loginDt;
	}

	public Timestamp getActivateDt() {
		return activateDt;
	}

	public void setActivateDt(Timestamp activateDt) {
		this.activateDt = activateDt;
	}

}
