package th.co.ais.web.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.common.CommonUtils;

public class ReActivateSsoStored implements Serializable {

	private static final Logger logger = Logger.getLogger(ReActivateSsoStored.class);
	private static ReActivateSsoStored instance = null;
	private static Map<String, ReActivateSsoToken> mapReActivateSso = null;

	
	public static ReActivateSsoStored getInstance() {
		if (instance == null) {
			instance = new ReActivateSsoStored();
		}
		return instance;
	}

	public Map<String, ReActivateSsoToken> getMapReActivateSso() {
		if (mapReActivateSso == null) {
			mapReActivateSso = new HashMap<String, ReActivateSsoToken>();
		}
		return mapReActivateSso;
	}
	
	public void addItem(SsoBean ssoBean) {
		try {
			if (ssoBean != null) {
				
				String sessionId = ssoBean.getSessionId();
				
//				logger.debug("Application store session id : " + sessionId);
				ReActivateSsoToken storedObj = getMapReActivateSso().get(sessionId);
				
				if (storedObj != null) {
					
					if (StringUtils.equals(storedObj.getUsername(), ssoBean.getUserName())) {
						
						Timestamp storedObjLoginDt = ssoBean.getLoginDt();
						Timestamp newObjLoginDt = ssoBean.getLoginDt();
						
						if (newObjLoginDt.compareTo(storedObjLoginDt) > 0) {
							
							logger.debug("Application found session id : " + sessionId + ", and user name : " + ssoBean.getUserName() + ", (Restoring)");
							
							ReActivateSsoToken ssoToken = new ReActivateSsoToken();
							ssoToken.setUsername(ssoBean.getUserName());
							ssoToken.setSessionId(ssoBean.getSessionId());
							ssoToken.setTokenId(ssoBean.getToken()); // Don't use token id 
							ssoToken.setLoginDt(ssoBean.getLoginDt());
							
							getMapReActivateSso().put(sessionId, ssoToken);
						}
					
					} else {					
						logger.debug("Application found session id : " + sessionId + ", (Restoring)");
						
						ReActivateSsoToken ssoToken = new ReActivateSsoToken();
						ssoToken.setUsername(ssoBean.getUserName());
						ssoToken.setSessionId(ssoBean.getSessionId());
						ssoToken.setTokenId(ssoBean.getToken());
						ssoToken.setLoginDt(ssoBean.getLoginDt());
						
						getMapReActivateSso().put(sessionId, ssoToken);
					}
					
				} else {
					
					String sessRelateWthUname = null;
					
					if (CommonUtils.isNotBlankValue(ssoBean.getUserName())) {
						
						for (Iterator<ReActivateSsoToken> it = getMapReActivateSso().values().iterator(); it.hasNext();) {
							ReActivateSsoToken _storedObj = it.next();
							
							if (_storedObj != null 
									&&StringUtils.equals(_storedObj.getUsername(), ssoBean.getUserName())) {
								logger.debug("Application found duplicate username : " + ssoBean.getUserName());
								sessRelateWthUname = _storedObj.getSessionId();
								break;
							}
						}
					}
					
					if (CommonUtils.isNotBlankValue(sessRelateWthUname)) {
						logger.debug("Application remove duplicate username : " + ssoBean.getUserName());
						getMapReActivateSso().remove(sessRelateWthUname);
					}
					
					logger.debug("Application put new session id : " + sessionId + ", and user name : " + ssoBean.getUserName());
					
					ReActivateSsoToken ssoToken = new ReActivateSsoToken();
					ssoToken.setUsername(ssoBean.getUserName());
					ssoToken.setSessionId(ssoBean.getSessionId());
					ssoToken.setTokenId(ssoBean.getToken());
					ssoToken.setLoginDt(ssoBean.getLoginDt());
					
					getMapReActivateSso().put(sessionId, ssoToken);
				}
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e.getCause());
			logger.info(e);
			e.printStackTrace();
		}
	}
	
	public void removeItem(String sessionId, String userName) {
		
		boolean sessDiscoved = false;
		String sessRelateWthUname = null;
		
		try {
			if (CommonUtils.isNotBlankValue(sessionId)) {
				
				ReActivateSsoToken storedObj = getMapReActivateSso().get(sessionId);
				
				if (storedObj != null) {
					logger.debug("Application remove session id : " + sessionId);
					getMapReActivateSso().remove(sessionId);
					
					sessDiscoved = true;
				}
			} 
			
			if (!sessDiscoved) {
				
				if (CommonUtils.isNotBlankValue(userName)) {
					for (Iterator<ReActivateSsoToken> it = getMapReActivateSso().values().iterator(); it.hasNext();) {
						ReActivateSsoToken _storedObj = it.next();
						if (_storedObj != null 
								&& StringUtils.equals(_storedObj.getUsername(), userName)) {
							sessRelateWthUname = _storedObj.getSessionId();
							break;
						}
					}
				}
				
				if (CommonUtils.isNotBlankValue(sessRelateWthUname)) {
					logger.debug("Application remove session id : " + sessRelateWthUname + ", is related with username : " + userName);
					getMapReActivateSso().remove(sessRelateWthUname);
				}
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e.getCause());
			e.printStackTrace();
		}
	}
}
