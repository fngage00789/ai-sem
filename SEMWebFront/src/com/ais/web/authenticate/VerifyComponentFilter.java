package com.ais.web.authenticate;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import Permission.bean.ais.com.SSOCompCode;
import Permission.bean.ais.com.SSOProgCode;

import th.co.ais.web.bean.SsoBean;
import th.co.ais.web.util.WebUtil;

public class VerifyComponentFilter implements Filter {
	
	private static final Logger log = Logger.getLogger(VerifyComponentFilter.class);
	
	public static final String SCREEN_SEMMSA0010 = "scrSEMMSA0010";
	public static final String SCREEN_SEMMSA0031 = "scrSEMMSA0031";
	
	private FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		
		if(!validateDataBeforeGetComponent(request)) {
			chain.doFilter(req, resp);
			return;
		}
		
		SsoBean ssoBean = getSSOBean(request);
		String ssoProgCode = getSSOProgramCode(request);
		
		log.debug(ssoBean.getUserName()+" | SSO Program code :"+ssoProgCode);
		
		AuthenticateService authenticateService = getAuthenticateService(filterConfig.getServletContext());
		try {
			AuthenCompCodeResponse response = authenticateService.getComponentPermissions(ssoBean.getToken(), ssoProgCode);
			if(response.isNotError()) {
				String progCodeSCR = toProgramCodeScreen(request);
				System.out.println("VerifyComponentFilter doFilter progCodeSCR == "+progCodeSCR);
				System.out.println("progCodeSCR");
				putComponents(progCodeSCR, response.getComponentCodes(), ssoBean);
				putRenderers(progCodeSCR, response.getComponentCodes(), ssoBean);
			} else {
				log.error(ssoBean.getUserName()+" | Cannot get component from SSO's Service from program code ["+ssoProgCode+"]");
				log.debug(ssoBean.getUserName()+" | Token:"+ssoBean.getToken()+", Program Code: "+ssoProgCode+", Message Code: "+ReflectionToStringBuilder.toString(response.getMessage()));
			}
		} catch (Exception e) {
			log.error(ssoBean.getUserName()+" | An error occur while get component from SSO's Service", e);
		}
		
		chain.doFilter(req, resp);
	}

	private String getSSOProgramCode(HttpServletRequest request) {	
		String progCodeRequest = request.getParameter("progCode");
		boolean removeDat = Boolean.parseBoolean(WebUtil.getResources("resources.application_th","removeDat"));
		String programCodeMNU = progCodeRequest.replace("-", "");
		
		if(removeDat) {
			programCodeMNU = WebUtil.PREFIX_PROG_CODE + programCodeMNU;
		}
		log.debug("Program Code from reqeuest :"+progCodeRequest+ " -> "+programCodeMNU);
		
		SsoBean ssoBean = getSSOBean(request);
		SSOProgCode ssoProgCode = ssoBean.getSsoProgCodes().get(programCodeMNU);
		
		return ssoProgCode != null ? ssoProgCode.getProgCodeName() : null;
	}

	private String toProgramCodeScreen(HttpServletRequest request) {
		String progCodeRequest = request.getParameter("progCode");
		System.out.println("VerifyComponentFilter getProgCodeScrn progCodeRequest = "+progCodeRequest);
		boolean removeDat = Boolean.parseBoolean(WebUtil.getResources("resources.application_th","removeDat"));
		
		progCodeRequest = progCodeRequest.replace("-", "");
		
		if (removeDat) {
			progCodeRequest = WebUtil.PREFIX_COMP_CODE + progCodeRequest;
		}
		System.out.println("VerifyComponentFilter getProgCodeScrn progCodeRequest = "+progCodeRequest);
		return progCodeRequest;
	}
	
	private void putRenderers(String progCode, SSOCompCode[] componentCodes, SsoBean ssoBean) {
		if(componentCodes == null || componentCodes.length < 1)
			return;
		
		HashMap<String, HashMap<String, Boolean>> ssoRenders = ssoBean.getSsoRenders();
		
		HashMap<String, Boolean> pageRenderer = new HashMap<String, Boolean>();
		for(SSOCompCode comp : componentCodes) {
			pageRenderer.put(comp.getCompCode(), !"0".equals(comp.getVisible()));
		}
		
		ssoRenders.put(progCode, pageRenderer);
	}

	private void putComponents(String progCode, SSOCompCode[] componentCodes, SsoBean ssoBean) {
		HashMap<String, SSOCompCode[]> ssoCompCodes = ssoBean.getSsoCompCodes();
		
		if(ssoCompCodes == null) {
			ssoCompCodes = new HashMap<String, SSOCompCode[]>();
			ssoBean.setSsoCompCodes(ssoCompCodes);
		}
		
		ssoCompCodes.put(progCode, componentCodes);
		System.out.println("VerifyComponentFilter putComponents ssoCompCodes = "+ssoCompCodes);
	}

	private boolean validateDataBeforeGetComponent(HttpServletRequest request) {
		SsoBean ssoBean = getSSOBean(request);
		if(ssoBean == null) {
			return false;
		}
		
		String progCodeParam = request.getParameter("progCode");
		if(StringUtils.isEmpty(progCodeParam)) {
			return false;
		}
		
		String programCodeScreen = toProgramCodeScreen(request);
		if(isScreenFromSMMSA001(programCodeScreen)) {
			return false;
		}
		
		String progCodeSCR = toProgramCodeScreen(request);
		boolean existCompCodeInSessionCache = ssoBean.getSsoCompCodes() != null && ssoBean.getSsoCompCodes().containsKey(progCodeSCR);
		if(existCompCodeInSessionCache) {
			log.debug(ssoBean.getUserName()+" | exist components in screen ->"+progCodeSCR);
			return false;
		}
		
		return true;
	}
	
	public static boolean isScreenFromSMMSA001(String programCodeScreen) {
		return SCREEN_SEMMSA0010.equals(programCodeScreen) || SCREEN_SEMMSA0031.equals(programCodeScreen);
	}
	
	private SsoBean getSSOBean(HttpServletRequest request) {
		Object ssoBeanObj = request.getSession().getAttribute("ssoBean");
		return ssoBeanObj != null ? (SsoBean) ssoBeanObj : null;
	}
	
	private AuthenticateService getAuthenticateService(ServletContext servletContext) {
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		return webApplicationContext.getBean("authenticateService", AuthenticateService.class);
	}

}
