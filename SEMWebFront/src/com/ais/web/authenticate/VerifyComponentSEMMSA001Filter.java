package com.ais.web.authenticate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

import th.co.ais.web.bean.SsoBean;
import th.co.ais.web.util.WebUtil;

import static com.ais.web.authenticate.VerifyComponentFilter.SCREEN_SEMMSA0010;
import static com.ais.web.authenticate.VerifyComponentFilter.SCREEN_SEMMSA0031;

import static com.ais.web.authenticate.VerifyComponentFilter.isScreenFromSMMSA001;

public class VerifyComponentSEMMSA001Filter implements Filter {
	
	private static final Logger log = Logger.getLogger(VerifyComponentSEMMSA001Filter.class);
	
	private static final String[] SSO_PROG_CODES_SEMMSA0010 = new String[]{"mnuSMMSA001", "mnuSMMSA002", "mnuSMMSA003", "mnuSMMSA004"};
	private static final String[] SSO_PROG_CODES_SEMMSA0031 = new String[]{"mnuSMMSA001", "mnuSMMSA002"};
	
	private FilterConfig filterConfig; 
	
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
		AuthenticateService authenticateService = getAuthenticateService(filterConfig.getServletContext());
		String progCodeSCR = toProgramCodeScreen(request);
		String[] ssoProgCodes = getProgCodes(progCodeSCR);
		
		log.debug(ssoBean.getUserName()+" | SSO Program code :"+ssoProgCodes);
		
		for (int i = 0; i < getProgCodes(progCodeSCR).length; i++) {
			String ssoProgCode = ssoProgCodes[i];
			try {
				AuthenCompCodeResponse response = authenticateService.getComponentPermissions(ssoBean.getToken(), ssoProgCodes[i]);
				if(response.isNotError()) {
					putComponents(progCodeSCR, response.getComponentCodes(), ssoBean);
					putRenderers(progCodeSCR, response.getComponentCodes(), ssoBean);
				} else {
					log.error(ssoBean.getUserName()+" | Cannot get component from SSO's Service from program code ["+ssoProgCode+"]");
					log.debug(ssoBean.getUserName()+" | Token:"+ssoBean.getToken()+", Program Code: "+ssoProgCode+", Message Code: "+ReflectionToStringBuilder.toString(response.getMessage()));
				}
			} catch (Exception e) {
				log.error(ssoBean.getUserName()+" | An error occur while get component from SSO's Service", e);
			}
		}
		
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}
	
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
		
		log.debug(ssoBean.getUserName()+" | Page Renderers SEMMSA001 : "+ pageRenderer);
		
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
		if(!isScreenFromSMMSA001(programCodeScreen)) {
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
	
	private String toProgramCodeScreen(HttpServletRequest request) {
		String progCodeRequest = request.getParameter("progCode");
		boolean removeDat = Boolean.parseBoolean(WebUtil.getResources("resources.application_th","removeDat"));
		
		progCodeRequest = progCodeRequest.replace("-", "");
		
		if (removeDat) {
			progCodeRequest = WebUtil.PREFIX_COMP_CODE + progCodeRequest;
		}
		return progCodeRequest;
	}
	
	private String[] getProgCodes(String programCodeScreen) {
		if(SCREEN_SEMMSA0010.equals(programCodeScreen))
			return SSO_PROG_CODES_SEMMSA0010;
		
		if(SCREEN_SEMMSA0031.equals(programCodeScreen))
			return SSO_PROG_CODES_SEMMSA0031;
		
		return null;
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
