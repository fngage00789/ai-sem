package com.ais.web.authenticate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.util.DateUtil;
import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import th.co.ais.web.action.LogoutAction;
import th.co.ais.web.bean.SsoBean;

public class ReActiveSSOSessionFilter implements Filter {
	
	private static final Logger log = Logger.getLogger(ReActiveSSOSessionFilter.class);
	private static final String LAST_ACTIVE_TIME = "lastActiveTimeSSO";
	private static final long TIME_REACTIVE_MINUITE = 5*60*1000;

	private FilterConfig filterConfig;
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		System.out.println("strat doFilter()"+DateUtil.formatDate(new Date(), "dd/MM/yyyy HH:mm:ss"));
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		Date tempDate = new Date();
		
		//check session timeout 8hour
//		log.debug("checkUserSessionTimeOut(request) : "+checkUserSessionTimeOut(request));
		if(checkUserSessionTimeOut(request,resp)){
			SsoBean ssoBean = getSSOBean(request);
			if(ssoBean == null) {
				log.debug("Not found sso bean to re-active sso's session.");
				chain.doFilter(req, resp);
				return;
			}
			
			Date previous = getActiveLastTime(session);
			Date now = new GregorianCalendar().getTime();
			
			long diff = now.getTime() - previous.getTime();
			
			log.debug(ssoBean.getUserName()+" | now->"+now+" | previous->"+previous+" | diff(millisec)->"+diff);
			if(diff >= TIME_REACTIVE_MINUITE) {
				AuthenticateService authenticateService = getAuthenticateService(filterConfig.getServletContext());
				try {
					authenticateService.reactiveSession(ssoBean.getToken());
					session.setAttribute(LAST_ACTIVE_TIME, now);
				} catch (Exception e) {
					log.error(ssoBean.getUserName()+" | Error while re-active sso's session", e);
				}
			}
			
			if(session.getAttribute(LAST_ACTIVE_TIME) == null) {
				session.setAttribute(LAST_ACTIVE_TIME, now);
			}
		}
	}

	private Date getActiveLastTime(HttpSession session) {
		Object obj = session.getAttribute(LAST_ACTIVE_TIME);
		return (obj != null) ? (Date) obj : new GregorianCalendar().getTime();
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}
	
	private SsoBean getSSOBean(HttpServletRequest request) {
		Object ssoBeanObj = request.getSession().getAttribute("ssoBean");
		return ssoBeanObj != null ? (SsoBean) ssoBeanObj : null;
	}
	
	private AuthenticateService getAuthenticateService(ServletContext servletContext) {
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		return webApplicationContext.getBean("authenticateService", AuthenticateService.class);
	}

	private boolean checkUserSessionTimeOut(HttpServletRequest request,ServletResponse response){
		boolean flag = false;
		HttpSession session = request.getSession();
		Date tempDate = null;
		Date curDate = new Date();
		try{
			if(session.getAttribute("tempDateSST") != null){
				tempDate = (Date) session.getAttribute("tempDateSST");
//				log.debug("befor set hours : "+tempDate);
//				curDate.setDate(4);
				session.setAttribute("tempDateSST", tempDate);
			}else{
				tempDate = new Date();
				log.debug("befor set hours : "+tempDate);
//				Calendar cal = Calendar.getInstance();
//				cal.setTime(tempDate);
//				cal.add(Calendar.MINUTE, 3);
//				tempDate = cal.getTime();
//				log.debug("after set hours : "+tempDate);
				
				session.setAttribute("tempDateSST", tempDate);
			}
			log.debug("test get date : "+tempDate.getDate());
			if(curDate.getDate() == tempDate.getDate()){
				flag = true;
			}else{
//				
				log.debug("this Session is timeout");
			}
		}catch (Exception e) {
			e.printStackTrace();
			log.debug(e);
			// TODO: handle exception
		}
		return flag;
	}

}
