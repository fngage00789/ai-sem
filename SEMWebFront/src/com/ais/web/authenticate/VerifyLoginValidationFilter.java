package com.ais.web.authenticate;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.web.bean.SsoBean;

public class VerifyLoginValidationFilter implements Filter {

	private static final Logger LOG = Logger.getLogger(VerifyLoginValidationFilter.class);
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		String method = request.getMethod();
		
		if("GET".equals(method)) {
			chain.doFilter(req, resp);
			return;
		}
		
		lookupPostParameters(request);
		
		String token = request.getParameter("token");
		if(StringUtils.isEmpty(token)) {
			sendError("Single Sign On System (SSO)", "Token is empty", request, response);
			return;
		}
		
		if(existSSOBean(request)) {
			request.getRequestDispatcher("/pages/home.jsf").forward(request, response);
			return;
		}
		System.out.println("req = "+req);
		System.out.println("resp = "+req);
		chain.doFilter(req, resp);
	}
	
	private boolean existSSOBean(HttpServletRequest request) {
		Object ssoBeanObj = request.getSession().getAttribute("ssoBean");
		
		if(ssoBeanObj == null)
			return false;
		
		String token = request.getParameter("token");
		String rn = request.getParameter("rn");
		
		if(StringUtils.isEmpty(rn) || StringUtils.isEmpty(token))
			return false;
		
		SsoBean ssoBean = (SsoBean) ssoBeanObj;
		
		if(token.equals(ssoBean.getToken()) && rn.equals(ssoBean.getRn())) {
			LOG.info("Found exist ssoBean with token and rn.");
			return true;
		} else {
			LOG.info("Found exist ssoBean but not equal token and rn from request parameters.");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	private void lookupPostParameters(HttpServletRequest request) {
		Enumeration paramNames = request.getParameterNames();
	    while(paramNames.hasMoreElements()) {
	      String paramName = (String)paramNames.nextElement();
	      System.out.println(paramName.concat(" >> ").concat(request.getParameter(paramName)));
	    }
	}
	
	private void sendError(String errorCode, String msg, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		LOG.error("Verify user login failed : " + msg);
		request.setAttribute("errorCode", errorCode);
		request.setAttribute("errorHeader", msg);
		request.setAttribute("errorMessage","");
		request.getRequestDispatcher("/error.jsf").forward(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

}
