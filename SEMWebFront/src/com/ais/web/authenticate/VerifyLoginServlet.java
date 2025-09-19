package com.ais.web.authenticate;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import Permission.bean.ais.com.SSOProgCode;
import Permission.bean.ais.com.SSOProgDesc;

import th.co.ais.domain.common.CommonUtils;
import th.co.ais.domain.gm.Employee;
import th.co.ais.service.gm.IEmployeeService;
import th.co.ais.web.bean.SsoBean;
import th.co.ais.web.util.SerializeManager;
import th.co.ais.web.util.WebUtil;

public class VerifyLoginServlet extends HttpServlet {

	private static final long serialVersionUID = -8376336677486151046L;
	private static final Logger log = Logger.getLogger(VerifyLoginValidationFilter.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("enter by get");
		SsoBean userLogin = toSSOBean(req);
		log.debug("SSO Program UserName"+userLogin.getUserName());
		req.getRequestDispatcher("sso2.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("enter by post");
		SsoBean userLogin = toSSOBean(request);
		log.debug("SSO Program UserName "+userLogin.getUserName());
		UserLoginParam userParam = toUserLoginParam(request);
		
		AuthenticateService authenticateService = getAuthenticateService(getServletContext());
		
		try {
			AuthenSSOResponse ssoResponse = authenticateService.verifyUserProgramCodesSSO(userParam);
			List<SSOProgDesc> programCodes = ssoResponse.getSsoProgCodes();
			if(ssoResponse.isError()) {
				sendError(ssoResponse.getMessage().getErrorCode(), ssoResponse.getMessage().getErrorMesg(), request, response);
				return;
			}
			
			List<RoleMenu> roleMenu = authenticateService.verifyUserRoleMenu(userLogin.getUserName(), programCodes);
			if(CommonUtils.isCollectionNotEmpty(roleMenu)) {
				putRoleMenuToUserLogin(userLogin, roleMenu);
			} else {
				sendError("Single Sign On System (SSO)", "Not found role menu.", request, response);
				return;
			}
			
			Employee employee = toEmployee(userLogin, getServletContext());
			log.debug(userLogin.getUserName() + " | Employee->"+ReflectionToStringBuilder.toString(employee));
			
			//edit by NEW 20160422
//			ssoBean = (SsoBean)SerializeManager.read(ssoSerlzePath);
			userLogin.setLoginDt(new Timestamp(Calendar.getInstance(new Locale("th", "TH")).getTimeInMillis()));
			userLogin.setSessionId(request.getSession().getId());
			
			userLogin.setEmployee(employee);
			
			request.getSession().setAttribute("ssoBean", userLogin);
			request.getRequestDispatcher("/pages/home.jsf").forward(request, response);
		} catch (Exception e) {
			log.error("An error occur while authenticate", e);
			sendError("Single Sign On System (SSO)", "An error occur while authenticate", request, response);
		}
		
	}

	private Employee toEmployee(SsoBean ssoBean, ServletContext servletContext) throws Exception {
		IEmployeeService employeeService = getEmployeeSErvice(servletContext);
		Employee param = new Employee();
		param.setUserStamp(ssoBean.getUserName());
		List<Employee> employees = null;
		employees = employeeService.getEmployees(param);
		return employees !=null && employees.size()>0 ? employees.get(0) : null;
	}

	private void putRoleMenuToUserLogin(SsoBean userLogin, List<RoleMenu> roleMenuList) {
		if(roleMenuList == null)
			return;
		
		boolean removeDat = Boolean.parseBoolean(WebUtil.getResources("resources.application_th","removeDat"));
		
		HashMap<String, SSOProgCode> ssoProgCodes = new HashMap<String, SSOProgCode>();
		for(RoleMenu roleMenu : roleMenuList) {
			SSOProgCode ssoProgCode = new SSOProgCode();
			ssoProgCode.setProgCodeName(roleMenu.getProgramCode());
			
			String programCodeMNU = roleMenu.getScreenId().replace("-", "");
			
			if(removeDat) {
				programCodeMNU = WebUtil.PREFIX_PROG_CODE + programCodeMNU;
			}
			
			ssoProgCodes.put(programCodeMNU, ssoProgCode);
		}
		System.out.println("putRoleMenuToUserLogin ssoProgCodes := "+ssoProgCodes);
		userLogin.setSsoProgCodes(ssoProgCodes);
	}
	
	private SsoBean toSSOBean(HttpServletRequest request) {
		SsoBean sso = new SsoBean();
		sso.setToken(request.getParameter("token"));
		sso.setRid(request.getParameter("rid"));
		sso.setSid(request.getParameter("sid"));
		sso.setRn(request.getParameter("rn"));
		sso.setSn(request.getParameter("sn"));
		
		sso.setFn(request.getParameter("fn"));
		sso.setLn(request.getParameter("ln"));
		sso.setTheme(request.getParameter("theme"));
		sso.setTemplate(request.getParameter("template"));
		sso.setHost(request.getParameter("host"));
		
		sso.setLc(request.getParameter("lc"));
		sso.setGl(request.getParameter("gl"));
		sso.setDc(request.getParameter("dc"));
		sso.setSc(request.getParameter("sc"));
		sso.setPt(request.getParameter("pt"));

		if(null!=sso.getToken()){
			String[] tokens = sso.getToken().split(",");
	        sso.setTokenId(tokens[0]);
	        sso.setUserName(tokens[1]);
	        sso.setGroupId(tokens[2]);
	        sso.setSubModuleId(tokens[3]);
	        sso.setClientIpAddress(tokens[4]);
		}
		return sso;
	}

	private UserLoginParam toUserLoginParam(HttpServletRequest request) {
		UserLoginParam userParam = new UserLoginParam();
		userParam.setToken(request.getParameter("token"));
		return userParam;
	}

	private void sendError(String errorCode, String msg, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		log.error("Verify user login failed : " + msg);
		request.setAttribute("errorCode", errorCode);
		request.setAttribute("errorHeader", msg);
		request.setAttribute("errorMessage","");
		request.getRequestDispatcher("/error.jsf").forward(request, response);
	}

	private AuthenticateService getAuthenticateService(ServletContext servletContext) {
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		return webApplicationContext.getBean("authenticateService", AuthenticateService.class);
	}
	
	private IEmployeeService getEmployeeSErvice(ServletContext servletContext) {
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		return webApplicationContext.getBean("employeeService", IEmployeeService.class);
	}
}
