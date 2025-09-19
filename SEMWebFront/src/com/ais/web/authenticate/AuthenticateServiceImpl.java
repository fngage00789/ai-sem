package com.ais.web.authenticate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;

import th.co.ais.domain.common.CommonUtils;
import th.co.ais.web.util.WebUtil;
import Permission.bean.ais.com.SSOCompCode;
import Permission.bean.ais.com.SSOProgDesc;
import Permission.bean.ais.com.SSOResponse;

import com.ais.websrv.EmployeeServiceWebService;
import com.ais.websrv.EmployeeServiceWebServiceProxy;

public class AuthenticateServiceImpl implements AuthenticateService {
	
	private static final Logger LOG = Logger.getLogger(AuthenticateServiceImpl.class);
	
	private RoleMenuDAO roleMenuDAO;

	@Override
	public AuthenSSOResponse verifyUserProgramCodesSSO(UserLoginParam userParam) throws Exception {
		
		EmployeeServiceWebService employeeWebService = getEmployeeServiceWebServiceProxy();
		SSOResponse ssoResponse = null;
		AuthenSSOResponse response = new AuthenSSOResponse();
		
		try {
			LOG.debug("AuthenticateServiceImpl verifyUserProgramCodesSSO userParam.getToken() = "+userParam.getToken());
			ssoResponse = employeeWebService.getProgCode(userParam.getToken());
			if (isSuccess(ssoResponse)) {
				
				SSOProgDesc[] allProgCode = ssoResponse.getSSOProgCodeList();
				
				response.setSsoProgCodes(Arrays.asList(allProgCode));
				response.setMessage(ssoResponse.getMessage());
			} else {
				response.setMessage(ssoResponse.getMessage());
			}
			
		} finally {
			LOG.debug("AuthenticateServiceImpl verifyUserProgramCodesSSO ReflectionToStringBuilder.toString(ssoResponse) = "+ReflectionToStringBuilder.toString(ssoResponse));
			LOG.debug("AuthenticateServiceImpl verifyUserProgramCodesSSO ssoResponse.getMessage() = "+arrayToString(ssoResponse.getMessage()));
			LOG.debug("AuthenticateServiceImpl verifyUserProgramCodesSSO ssoResponse.getSSOProgCodeList() = "+arrayToString(ssoResponse.getSSOProgCodeList()));
			LOG.debug("AuthenticateServiceImpl verifyUserProgramCodesSSO ssoResponse.getSSOProgCodecArr() = "+arrayToString(ssoResponse.getSSOProgCodecArr()));
		}
		
		return response;
	}

	@Override
	public List<RoleMenu> verifyUserRoleMenu(String userName, List<SSOProgDesc> ssoProgramCodes) throws Exception {
		
		List<RoleMenu> roleMenues = null;
		String programCodeString = null;
		List<String> userSSOProgramCodes = toProgramCodeStringList(ssoProgramCodes);
		LOG.debug("AuthenticateServiceImpl verifyUserRoleMenu userName = "+userName);
		LOG.debug("AuthenticateServiceImpl verifyUserRoleMenu ssoProgramCodes = "+ssoProgramCodes);
		try {
			if (CommonUtils.isCollectionNotEmpty(userSSOProgramCodes)) {
				programCodeString = CommonUtils.joinString(userSSOProgramCodes, ",");
				roleMenues = roleMenuDAO.getByProgramCodesAndType(userName, programCodeString, VerifyType.SSO.toString());
			}

		} finally {
			LOG.debug("AuthenticateServiceImpl verifyUserRoleMenu = "+programCodeString);
			LOG.debug("AuthenticateServiceImpl verifyUserRoleMenu = "+arrayToString(roleMenues));
		}
		
		return roleMenues;
	}
	
	@Override
	public AuthenCompCodeResponse getComponentPermissions(String token, String programCode) throws Exception {
		
		EmployeeServiceWebService employeeWebService = getEmployeeServiceWebServiceProxy();
		SSOResponse ssoResponse = null;
		AuthenCompCodeResponse response = new AuthenCompCodeResponse();
		
		try {
			LOG.debug("AuthenticateServiceImpl getComponentPermissions token = "+token);
			LOG.debug("AuthenticateServiceImpl getComponentPermissions programCode = "+programCode);
			ssoResponse = employeeWebService.getPermission(token, programCode);
			if (isSuccess(ssoResponse)) {
				
				SSOCompCode[] ssoCompCodes = ssoResponse.getSSOCompCode();
				
				response.setComponentCodes(ssoCompCodes);
				response.setMessage(ssoResponse.getMessage());
			} else {
				response.setMessage(ssoResponse.getMessage());
			}
			
		} finally { 
			LOG.debug("AuthenticateServiceImpl getComponentPermissions = "+ReflectionToStringBuilder.toString(ssoResponse));
			LOG.debug("AuthenticateServiceImpl getComponentPermissions = "+arrayToString(ssoResponse.getMessage()));
			LOG.debug("AuthenticateServiceImpl getComponentPermissions = "+arrayToString(ssoResponse.getSSOCompCode()));
		}
		
		return response;
	}
	
	@Override
	public SSOResponse login(String userName, String password) throws Exception {
		EmployeeServiceWebService employeeWebService = getEmployeeServiceWebServiceProxy();
		return employeeWebService.getToken(userName, password, "SEM", "2", "SEM");
	}

	@Override
	public SSOResponse logout(String token) throws Exception {
		EmployeeServiceWebService employeeWebService = getEmployeeServiceWebServiceProxy();
		SSOResponse response = null;
		LOG.debug("Start Logout by token->"+token);
		try {
			response = employeeWebService.decreaseCounter(token);
		} finally {
			String responseDebug = (response != null) ? ReflectionToStringBuilder.toString(response.getMessage()) : null;
			LOG.debug("End Logout token->"+token+" | response "+responseDebug);
		}
		return response;
	}
	
	@Override
	public SSOResponse reactiveSession(String token) throws Exception {
		EmployeeServiceWebService employeeWebService = getEmployeeServiceWebServiceProxy();
		SSOResponse response = null;
		LOG.debug("Start Re-active sso's session by token->"+token);
		try {
			response = employeeWebService.syncUserSession(token);
		} finally {
			String responseDebug = (response != null) ? ReflectionToStringBuilder.toString(response.getMessage()) : null;
			LOG.debug("End Re-active sso's session by token->"+token+" | response "+responseDebug);
		}
		return response;
	}
	
	private List<String> toProgramCodeStringList(List<SSOProgDesc> ssoProgramCodes) {
		if(ssoProgramCodes == null)
			return null;
		
		List<String> programCodes = new ArrayList<String>();
		for(SSOProgDesc progCode : ssoProgramCodes) {
			programCodes.add(progCode.getProgCode());
		}
		return programCodes;
	}
	
	private static EmployeeServiceWebService getEmployeeServiceWebServiceProxy() {
		final String ssoServiceEndpoint = WebUtil.getResources("resources.application_th","wsEmployeeURL");
		EmployeeServiceWebServiceProxy proxy = new EmployeeServiceWebServiceProxy();
		proxy.setEndpoint(ssoServiceEndpoint);
		return proxy;
	}
	
	private boolean isSuccess(SSOResponse ssoResponse) {
		return ssoResponse != null && ssoResponse.getMessage() != null && ssoResponse.getMessage().isFlag();
	}

	public void setRoleMenuDAO(RoleMenuDAO roleMenuDAO) {
		this.roleMenuDAO = roleMenuDAO;
	}
	
	@SuppressWarnings("unchecked")
	public static String arrayToString(final Object obj){
	    if (obj == null) {
	        return "<null>";
	    }
	    else {
	        Object array = null;
	        if (obj instanceof Collection) {
	            array = ((Collection) obj).toArray();
	        }
	        else if (obj.getClass().isArray()) {
	            array = obj;
	        }
	        else {
	            return ReflectionToStringBuilder.toString(obj);
	        }
	        int length = Array.getLength(array);
	        int lastItem = length - 1;
	        StringBuffer sb = new StringBuffer("[");
	        for (int i = 0; i < length; i++) {
	            sb.append(arrayToString(Array.get(array, i)));
	            if (i < lastItem) {
	                sb.append(", ");
	            }
	        }
	        sb.append(']');
	        return sb.toString();
	    }
	}
}
