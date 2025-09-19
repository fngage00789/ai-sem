package th.co.ais.web.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import th.co.ais.domain.gm.Employee;
import th.co.ais.domain.gm.SsoCompanyUser;
import Permission.bean.ais.com.SSOCompCode;
import Permission.bean.ais.com.SSOProgCode;

public class SsoBean implements Serializable {

	private static final long serialVersionUID = 8703779561978484841L;

	private String token;
	private String rid;
	private String sid;
	private String rn;
	private String sn;
	private String fn;
	private String ln;
	private String theme;
	private String template;
	private String host;
	private String url;
	private String connectType;
	private String lc;
	private String gl;
	private String dc;
	private String sc;
	private String pt;

	/** split token **/
	private String tokenId; // token[0]
	private String userName; // token[1]
	private String groupId; // token[2]
	private String subModuleId; // token[3]
	private String clientIpAddress; // token[4]

	/** เพิ่มเติม **/
	// private SSOProgCode[] ssoProgCodes;
	private HashMap<String, SSOProgCode> ssoProgCodes;
	private HashMap<String, SSOCompCode[]> ssoCompCodes;
	private HashMap<String, HashMap<String, Boolean>> ssoRenders = new HashMap<String, HashMap<String, Boolean>>();
	private HashMap<String, HashMap<String, Boolean>> ssoDisables = new HashMap<String, HashMap<String, Boolean>>();
	private ArrayList<SsoCompanyUser> semSsoCompanyUsers;
	private Employee employee;
	
	private String sessionId;
	private Timestamp loginDt;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getRn() {
		return rn;
	}

	public void setRn(String rn) {
		this.rn = rn;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getConnectType() {
		return connectType;
	}

	public void setConnectType(String connectType) {
		this.connectType = connectType;
	}

	public String getLc() {
		return lc;
	}

	public void setLc(String lc) {
		this.lc = lc;
	}

	public String getGl() {
		return gl;
	}

	public void setGl(String gl) {
		this.gl = gl;
	}

	public String getDc() {
		return dc;
	}

	public void setDc(String dc) {
		this.dc = dc;
	}

	public String getSc() {
		return sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
	}

	public String getPt() {
		return pt;
	}

	public void setPt(String pt) {
		this.pt = pt;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getSubModuleId() {
		return subModuleId;
	}

	public void setSubModuleId(String subModuleId) {
		this.subModuleId = subModuleId;
	}

	public String getClientIpAddress() {
		return clientIpAddress;
	}

	public void setClientIpAddress(String clientIpAddress) {
		this.clientIpAddress = clientIpAddress;
	}

	/*
	 * public SSOProgCode[] getSsoProgCodes() { return ssoProgCodes; } public
	 * void setSsoProgCodes(SSOProgCode[] ssoProgCodes) { this.ssoProgCodes =
	 * ssoProgCodes; }
	 */
	public HashMap<String, SSOCompCode[]> getSsoCompCodes() {
		return ssoCompCodes;
	}

	public void setSsoCompCodes(HashMap<String, SSOCompCode[]> ssoCompCodes) {
		this.ssoCompCodes = ssoCompCodes;
	}

	public List<SsoCompanyUser> getSemSsoCompanyUsers() {
		return semSsoCompanyUsers;
	}

	public void setSemSsoCompanyUsers(
			ArrayList<SsoCompanyUser> semSsoCompanyUsers) {
		this.semSsoCompanyUsers = semSsoCompanyUsers;
	}

	public HashMap<String, HashMap<String, Boolean>> getSsoRenders() {
		return ssoRenders;
	}

	public void setSsoRenders(
			HashMap<String, HashMap<String, Boolean>> ssoRenders) {
		this.ssoRenders = ssoRenders;
	}

	public HashMap<String, HashMap<String, Boolean>> getSsoDisables() {
		return ssoDisables;
	}

	public void setSsoDisables(
			HashMap<String, HashMap<String, Boolean>> ssoDisables) {
		this.ssoDisables = ssoDisables;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setSsoProgCodes(HashMap<String, SSOProgCode> ssoProgCodes) {
		this.ssoProgCodes = ssoProgCodes;
	}

	public HashMap<String, SSOProgCode> getSsoProgCodes() {
		return ssoProgCodes;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Timestamp getLoginDt() {
		return loginDt;
	}

	public void setLoginDt(Timestamp loginDt) {
		this.loginDt = loginDt;
	}

}
