package th.co.ais.web.servlet;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import th.co.ais.web.bean.ReActivateSsoStored;
import th.co.ais.web.bean.ReActivateSsoToken;
import Permission.bean.ais.com.SSOResponse;

import com.ais.web.authenticate.AuthenticateService;
import com.ais.web.authenticate.AuthenticateServiceImpl;

public class QuartzJob implements Job {
	
	private static final Logger logger = Logger.getLogger(QuartzJob.class);
	private AuthenticateService authenticateService = null;
//	private static final String APPLICATION_CONTEXT_KEY = "applicationContext";

//	private ApplicationContext getApplicationContext(JobExecutionContext context) throws Exception {
//		
//		ApplicationContext appCtx = (ApplicationContext) context.getScheduler()
//				.getContext().get(APPLICATION_CONTEXT_KEY);
//		
//		if (appCtx == null) {
//			throw new JobExecutionException(
//					"No application context available in scheduler context for key \""
//							+ APPLICATION_CONTEXT_KEY + "\"");
//		}
//		return appCtx;
//	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		logger.info("Executing Quartz Job to reactivate SSO Token");

		
		if (!ReActivateSsoStored.getInstance().getMapReActivateSso().values().isEmpty()) {
			
			List<String> sessRemovedList = new ArrayList<String>();
			
			try {
				
				for (Iterator<ReActivateSsoToken> it = ReActivateSsoStored.getInstance().getMapReActivateSso().values().iterator(); it.hasNext();) {
					
					ReActivateSsoToken _storedObj = it.next();
					
					if (_storedObj != null) {
						
						try {
							
							logger.info("Send Reactivate SSO Token by username : " 
									+ _storedObj.getUsername() + ", and token is : " 
									+ _storedObj.getTokenId());
							
							SSOResponse response = getAuthenticateService().reactiveSession(_storedObj.getTokenId());
							
							if (response != null 
									&& response.getMessage() != null 
									&& response.getMessage().getErrorCode().equals("BAV000")) {
								
								logger.info("SyncUserSession SSO Response : " + response.getMessage());
								logger.info("Reactivate SSO Token is Success by username : " 
										+ _storedObj.getUsername() + ", and token is : " 
										+ _storedObj.getTokenId());
								
								_storedObj.setActivateDt(new Timestamp(Calendar.getInstance(new Locale("th", "TH")).getTimeInMillis()));
								
							} else {
								
								if (response != null && response.getMessage() != null) {
									logger.info("SyncUserSession SSO Response : " + response.getMessage());
								} else {
									logger.info("SyncUserSession SSO Response : is null");
								}
								
								logger.info("Reactivate SSO Token is Incorrect by username : " 
										+ _storedObj.getUsername() + ", and token is : " 
										+ _storedObj.getTokenId());
								
								sessRemovedList.add(_storedObj.getSessionId());
							}
						
						} catch (Exception e) {
							logger.error(e.getMessage(), e.getCause());
							sessRemovedList.add(_storedObj.getSessionId());
						}
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				
			} finally {
				
				if (sessRemovedList != null && !sessRemovedList.isEmpty()) {
					for (String sessRemoved : sessRemovedList) {

						ReActivateSsoStored.getInstance().removeItem(sessRemoved, null);
					}
				}
				
				sessRemovedList = null;
			}
		}
	}

	public AuthenticateService getAuthenticateService() {
		if (authenticateService == null) {
			authenticateService = new AuthenticateServiceImpl(); 
		}
		return authenticateService;
	}
}