package th.co.ais.web.action;

import org.apache.log4j.Logger;

import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.WebUtil;

public class LogoutAction {
	
	private static final Logger log = Logger.getLogger(LogoutAction.class);
	
	public String logout() throws Exception{
		this.clearLOVCache();
		return "logout";
	}
	
	protected void clearLOVCache(){
		LOVCacheUtil.getInstance().setComponentMap(null);
		LOVCacheUtil.getInstance().setLov(null);
		MSGCacheUtil.getInstance().setComponentMap(null);
		MSGCacheUtil.getInstance().setMsg(null);
		WebUtil.clearAllSessionNotUsed();
		WebUtil.clearUserSession();
	}
}
