package th.co.ais.web.servlet;

import static com.ais.web.authenticate.VerifyComponentFilter.SCREEN_SEMMSA0010;
import static com.ais.web.authenticate.VerifyComponentFilter.SCREEN_SEMMSA0031;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.faces.application.ViewExpiredException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import Permission.bean.ais.com.SSOCompCode;
import Permission.bean.ais.com.SSOProgCode;

import com.ais.web.authenticate.AuthenCompCodeResponse;
import com.ais.web.authenticate.AuthenticateService;

import th.co.ais.domain.common.CommonUtils;
import th.co.ais.web.bean.SsoBean;
import th.co.ais.web.util.WebUtil;

import common.bean.ais.com.Message;


public class SessionSecurityFilter implements Filter {

	private static final Logger logger = Logger.getLogger(SessionSecurityFilter.class);
	private final String SCREEN_SEMMSA0010 = "scrSEMMSA0010";
	private final String SCREEN_SEMMSA0031 = "scrSEMMSA0031";
	private final String[] SSO_PROG_CODES_SEMMSA0010 = new String[]{"mnuSMMSA001", "mnuSMMSA002", "mnuSMMSA003", "mnuSMMSA004"};
	private final String[] SSO_PROG_CODES_SEMMSA0031 = new String[]{"mnuSMMSA001", "mnuSMMSA002"};
	
	private String timeoutPage = "error.jsp";//"sso.jsp";//private String timeoutPage = "login.jsf";
	private String indexPage = "index.jsp";
	private String ajaxskiprequest = "a4j";
	
	private FilterConfig filterConfig;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)  throws ServletException, IOException {
		if ((request instanceof HttpServletRequest) && (response instanceof HttpServletResponse)) {
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			HttpSession httpSession = httpServletRequest.getSession();
			// is session expire control required for this request?
			if (isSessionControlRequiredForThisResource(httpServletRequest)) {
				/** syncUserSession <SSO> **/
				try {
					boolean syncSession = Boolean.parseBoolean(WebUtil.getResources("resources.application_th","syncSession"));
					boolean sessIsValid = true;
					
					if(syncSession){
						Message msg = WebUtil.syncUserSession(httpServletRequest);
						if("Success".equals(msg.getErrorMesg())){
							
						} else {
							logger.debug("syncUserSession is not Success! redirecting to error.jsp : " + msg.getErrorMesg());
							
							sessIsValid = false;
							/*
							 * Current session in SSO is incomplete!!
							 */
							httpSession.invalidate();
						}
					}
					
					if (sessIsValid) {
						
						SsoBean ssoBean = (SsoBean) httpServletRequest.getSession().getAttribute("ssoBean");
						
						if (validateDataBeforeGetComponent(httpServletRequest, ssoBean)) {
							
							try {
								
								String progCodeScrn = getProgCodeScrn(httpServletRequest, ssoBean);
								String compCodeScrn = getCompCodeScrn(httpServletRequest, ssoBean);
//								System.out.println("SessionSecurityFilter in validateDataBeforeGetComponent progCodeScrn = "+progCodeScrn);
//								System.out.println("SessionSecurityFilter in validateDataBeforeGetComponent compCodeScrn = "+compCodeScrn);
								String[] ssoProgCodes = null;

								if (SCREEN_SEMMSA0010.equals(compCodeScrn)) {
									ssoProgCodes = SSO_PROG_CODES_SEMMSA0010;
									
								} else if (SCREEN_SEMMSA0031.equals(compCodeScrn)) {
									ssoProgCodes = SSO_PROG_CODES_SEMMSA0031;
									
								} else {
									SSOProgCode ssoProgCode = ssoBean.getSsoProgCodes().get(progCodeScrn);
									String strSSOProgCode = ssoProgCode != null ? ssoProgCode.getProgCodeName() : null;
									
									if (CommonUtils.isNotBlankValue(strSSOProgCode)) {
										
										ssoProgCodes = new String[]{strSSOProgCode}; 
									}
								}
//								System.out.println("SessionSecurityFilter in validateDataBeforeGetComponent ssoProgCodes = "+ssoProgCodes);
								if (ssoProgCodes != null && ssoProgCodes.length > 0) {
									
									for (int arrIndex = 0; arrIndex < ssoProgCodes.length; arrIndex++) {
										
										logger.debug(ssoBean.getUserName()+" | SSO Program code : " + ssoProgCodes[arrIndex]);
										
										AuthenCompCodeResponse authenCompCodeResponse = getAuthenticateService(filterConfig.getServletContext())
												.getComponentPermissions(ssoBean.getToken(), 
														ssoProgCodes[arrIndex]);
										
										if(authenCompCodeResponse != null && authenCompCodeResponse.isNotError()) {
											
//											String progCodeScrn = getProgCodeScrn(httpServletRequest);
											
											putComponents(compCodeScrn, authenCompCodeResponse.getComponentCodes(), ssoBean);
											
											putRenderers(compCodeScrn, authenCompCodeResponse.getComponentCodes(), ssoBean);
											
										} else {
											
											logger.error(ssoBean.getUserName() + " | Cannot get component from SSO's Service from program code [" + ssoProgCodes[arrIndex] + "]");
											logger.debug(ssoBean.getUserName() + " | Token : " +ssoBean.getToken() + ", Program Code: " + ssoProgCodes[arrIndex] + ", Message Code: " +ReflectionToStringBuilder.toString(authenCompCodeResponse.getMessage()));
											
											if (authenCompCodeResponse != null 
													&& authenCompCodeResponse.getMessage().getErrorCode().equals("BAV010")) {
												
												httpSession.invalidate();
											}
										}
									}
								} else {
									logger.error("ssoProgCodes is null:  "+ssoProgCodes+", ssoProgCodes.length < 0: "+ssoProgCodes.length+", Token: "+ssoBean.getToken()+", Username:"+ssoBean.getUserName());
								}
								
							} catch (Exception e) {
								logger.error(ssoBean.getUserName()+" | An error occur while get component from SSO's Service"+", Token: "+ssoBean.getToken()+", Username:"+ssoBean.getUserName(), e);
							}
						} else {
							logger.error("validateDataBeforeGetComponent Fail compCodeScrn, getSsoCompCodes, compCodeScrn"+", Token: "+ssoBean.getToken()+", Username:"+ssoBean.getUserName());
						}
					}
					
				} catch (Exception e) {
					String str = e.getMessage();
					logger.error("An errorgetComponentPermissions from SSO's Service: "+str);
				}
			} else {
				logger.error("An error occur isSessionControlRequiredForThisResource");
			}
		} else {
			logger.error("request instanceof HttpServletRequest AND response instanceof HttpServletResponse");
		}
		try {
			filterChain.doFilter(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
			HttpServletResponse httpServletResponse2 = (HttpServletResponse) response;
			httpServletResponse2.sendRedirect("error-timeout.jsf");
		}
	}
	
	private boolean isSessionControlRequiredForThisResource(HttpServletRequest httpServletRequest) {
		String requestPath = httpServletRequest.getRequestURI();
		boolean controlRequired = !(StringUtils.contains(requestPath, getTimeoutPage()) 
				|| StringUtils.contains(requestPath, getAjaxskiprequest())
				|| StringUtils.contains(requestPath, getIndexPage()));
		return controlRequired;
	}
	
	private boolean isSessionInvalid(HttpServletRequest httpServletRequest) {
		boolean sessionInValid = (httpServletRequest.getRequestedSessionId() != null)
			&& !httpServletRequest.isRequestedSessionIdValid();
		return sessionInValid;
	}
	
	private boolean isLoginUser(HttpServletRequest httpServletRequest){
		boolean loginValid = (httpServletRequest.getSession(true).getAttribute(WebUtil.USER_SESSION)!=null);
		return loginValid;
	}
	
	private AuthenticateService getAuthenticateService(ServletContext servletContext) {
		return WebApplicationContextUtils
					.getWebApplicationContext(servletContext)
					.getBean("authenticateService", AuthenticateService.class);
	}
	
	private boolean validateDataBeforeGetComponent(HttpServletRequest request, SsoBean ssoBean) {
		
		boolean isValid = false;
		SSOCompCode[] scc = null;
		String compCodeScrn = getCompCodeScrn(request, ssoBean);
		try {
//			logger.debug("SESSIONSAECURITY validateDataBeforeGetComponent compCodeScrn = "+compCodeScrn);
//			System.out.println("SESSIONSAECURITY validateDataBeforeGetComponent ssoBean.getSsoCompCodes() = "+ssoBean.getSsoCompCodes());
//			if(ssoBean.getSsoCompCodes() != null)System.out.println("SESSIONSAECURITY validateDataBeforeGetComponent ssoBean.getSsoCompCodes().get(compCodeScrn)= "+ ssoBean.getSsoCompCodes().get(compCodeScrn));
//			if(ssoBean.getSsoCompCodes() != null)scc = ssoBean.getSsoCompCodes().get(compCodeScrn);
//			if(scc != null)System.out.println("SESSIONSAECURITY validateDataBeforeGetComponent  scc = "+ scc.toString());
			//System.out.println("SESSIONSAECURITY validateDataBeforeGetComponent ssoBean.getSsoCompCodes().get(compCodeScrn)= "+ ssoBean.getSsoCompCodes().get(compCodeScrn));
//			compCode
//			System.out.println("!(ssoBean.getSsoCompCodes() != null) = "+!(ssoBean.getSsoCompCodes() != null));
//			if(ssoBean.getSsoCompCodes() != null)System.out.println("ssoBean.getSsoCompCodes().containsKey(compCodeScrn) = "+!(ssoBean.getSsoCompCodes().containsKey(compCodeScrn)));
//			if(ssoBean.getSsoCompCodes() != null)System.out.println("ssoBean.getSsoCompCodes().containsKey(compCodeScrn) = "+ssoBean.getSsoCompCodes().toString());
//			System.out.println("3"+!(ssoBean.getSsoCompCodes() != null && ssoBean.getSsoCompCodes().containsKey(compCodeScrn)));
			if (CommonUtils.isNotBlankValue(compCodeScrn)
					&& !(ssoBean.getSsoCompCodes() != null && ssoBean.getSsoCompCodes().containsKey(compCodeScrn))) {
				
				isValid = true;
				
			} else {
				
				logger.error("validateDataBeforeGetComponent Fail compCodeScrn: "+compCodeScrn+", compCodeScrn: "+compCodeScrn+", Token: "+ssoBean.getToken()+", Username:"+ssoBean.getUserName());
				
			}
//			System.out.println("SESSIONSAECURITY validateDataBeforeGetComponent isValid = "+isValid);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.debug(e);
		}
		
		return isValid;
	}
	
	private String getProgCodeScrn(HttpServletRequest request, SsoBean ssoBean) {
		
		String progCodeRequest = request.getParameter("progCode");
		
		if(progCodeRequest == null) {
			logger.debug("getProgCodeScrn progCodeRequest: "+progCodeRequest+", Token: "+ssoBean.getToken()+", Username:"+ssoBean.getUserName());
		}
		
		
		if (CommonUtils.isNotBlankValue(progCodeRequest)) {
			
			boolean removeDat = Boolean.parseBoolean(WebUtil.getResources("resources.application_th", "removeDat"));
			
			progCodeRequest = StringUtils.remove(progCodeRequest, "-");
			progCodeRequest = removeDat ? (WebUtil.PREFIX_PROG_CODE + progCodeRequest) : progCodeRequest;
		}
		
		return progCodeRequest;
	}
	
	private String getCompCodeScrn(HttpServletRequest request, SsoBean ssoBean) {
		
		String compCodeRequest = request.getParameter("progCode");
		
		if(compCodeRequest == null) {
			logger.debug("getCompCodeScrn compCodeRequest: "+compCodeRequest+", Token: "+ssoBean.getToken()+", Username:"+ssoBean.getUserName());
		}
		
		if (CommonUtils.isNotBlankValue(compCodeRequest)) {
			
			boolean removeDat = Boolean.parseBoolean(WebUtil.getResources("resources.application_th", "removeDat"));
			
			compCodeRequest = StringUtils.remove(compCodeRequest, "-");
			compCodeRequest = removeDat ? (WebUtil.PREFIX_COMP_CODE + compCodeRequest) : compCodeRequest;
		}
		
		return compCodeRequest;
	}
	
//	private void putRenderers(String progCode, SSOCompCode[] componentCodes, SsoBean ssoBean) {
//		if(componentCodes == null || componentCodes.length < 1)
//			return;
//		
//		HashMap<String, HashMap<String, Boolean>> ssoRenders = ssoBean.getSsoRenders();
//		
//		HashMap<String, Boolean> pageRenderer = new HashMap<String, Boolean>();
//		for(SSOCompCode comp : componentCodes) {
//			pageRenderer.put(comp.getCompCode(), !"0".equals(comp.getVisible()));
//		}
//		
//		ssoRenders.put(progCode, pageRenderer);
//	}
//
//	private void putComponents(String progCode, SSOCompCode[] componentCodes, SsoBean ssoBean) {
//		HashMap<String, SSOCompCode[]> ssoCompCodes = ssoBean.getSsoCompCodes();
//		
//		if(ssoCompCodes == null) {
//			ssoCompCodes = new HashMap<String, SSOCompCode[]>();
//			ssoBean.setSsoCompCodes(ssoCompCodes);
//		}
//		
//		ssoCompCodes.put(progCode, componentCodes);
//	}
	private void putRenderers(String progCode, SSOCompCode[] componentCodes, SsoBean ssoBean) {
		if(componentCodes == null || componentCodes.length < 1)
			return;
		
		HashMap<String, HashMap<String, Boolean>> ssoRenders = ssoBean.getSsoRenders();
		
		HashMap<String, Boolean> pageRenderer = null;
		if(ssoRenders.containsKey(progCode)) {
			pageRenderer = ssoRenders.get(progCode);
		} else {
			pageRenderer = new HashMap<String, Boolean>();
		}
		
		for(SSOCompCode comp : componentCodes) {
			pageRenderer.put(comp.getCompCode(), !"0".equals(comp.getVisible()));
		}
		
		logger.debug(ssoBean.getUserName()+" | Page Renderers SEMMSA001 : "+ pageRenderer);
		
		if(!ssoRenders.containsKey(progCode)) {
			ssoRenders.put(progCode, pageRenderer);
		}
	}

	private void putComponents(String progCode, SSOCompCode[] componentCodes, SsoBean ssoBean) {
		if(componentCodes == null || componentCodes.length == 0)
			return;
		
		HashMap<String, SSOCompCode[]> ssoCompCodes = ssoBean.getSsoCompCodes();
		
		if(ssoCompCodes == null) {
			ssoCompCodes = new HashMap<String, SSOCompCode[]>();
			ssoBean.setSsoCompCodes(ssoCompCodes);
		}
		
		if(ssoCompCodes.containsKey(progCode)) {
			List<SSOCompCode> componentCodeList = Arrays.asList(componentCodes);
			List<SSOCompCode> componentCodeListAdded = new ArrayList<SSOCompCode>(Arrays.asList(ssoCompCodes.get(progCode)));
			
			for (SSOCompCode ssoCompCode : componentCodeList) {
				componentCodeListAdded.add(ssoCompCode);
			}
			
			componentCodes = componentCodeListAdded.toArray(new SSOCompCode[componentCodeListAdded.size()]);
		}
		
		ssoCompCodes.put(progCode, componentCodes);
	}
	
	public void destroy() {
	
	}
	
	public String getIndexPage() {
		return indexPage;
	}

	public void setIndexPage(String indexPage) {
		this.indexPage = indexPage;
	}

	public String getTimeoutPage() {
		return timeoutPage;
	}
	
	public void setTimeoutPage(String timeoutPage) {
		this.timeoutPage = timeoutPage;
	}

	public String getAjaxskiprequest() {
		return ajaxskiprequest;
	}

	public void setAjaxskiprequest(String ajaxskiprequest) {
		this.ajaxskiprequest = ajaxskiprequest;
	}

}