package th.co.ais.web.servlet;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import th.co.ais.web.bean.ReActivateSsoStored;
import th.co.ais.web.bean.SsoBean;

import com.ais.web.authenticate.AuthenticateService;

public class SessionListener implements HttpSessionListener {

	private static final Logger logger = Logger.getLogger(SessionListener.class);

	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = null;

		try {
			session = event.getSession();

			logger.debug("Current Session created : " + session.getId()
					+ " at " + new Date());

		} catch (Exception e) {
			logger.debug("Error while session created : " + e.getMessage());
		}
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = null;
		SsoBean ssoBean = null;
		String sessionId = null;
		String userName = null;
		
		try {
			session = event.getSession();
			ssoBean = getSSOBean(session);
			
			if(ssoBean == null) {
				logger.info("Cannot find ssoBean from Session!");
				return;
			}
			
			logger.debug("Current Session destroyed :" + session.getId() + " Logging out user!");
			
			sessionId = ssoBean.getSessionId();
			userName = ssoBean.getUserName();
			
			AuthenticateService authenticateService = getAuthenticateService(session.getServletContext());
			try {
				authenticateService.logout(ssoBean.getToken());
			} catch (Exception e) {
				logger.error("An error occour while logout from servlet!", e);
			}

		} catch (Exception e) {
			logger.debug("Error while logging out at session destroyed : "+ e.getMessage());
		
		} finally {
			ReActivateSsoStored.getInstance().removeItem(sessionId, userName);	
		}
	}
	
	private AuthenticateService getAuthenticateService(ServletContext servletContext) {
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		return webApplicationContext.getBean("authenticateService", AuthenticateService.class);
	}
	
	private SsoBean getSSOBean(HttpSession session) {
		Object ssoBeanObj = session.getAttribute("ssoBean");
		return ssoBeanObj != null ? (SsoBean) ssoBeanObj : null;
	}

}
