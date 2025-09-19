package com.ais.web.authenticate;

import java.util.List;

import Permission.bean.ais.com.SSOProgDesc;
import Permission.bean.ais.com.SSOResponse;

public interface AuthenticateService {
	
	public AuthenSSOResponse verifyUserProgramCodesSSO(UserLoginParam userParam) throws Exception;
	
	public List<RoleMenu> verifyUserRoleMenu(String userName, List<SSOProgDesc> ssoProgramCodes) throws Exception;
	
	public AuthenCompCodeResponse getComponentPermissions(String token, String programCode) throws Exception;
	
	public SSOResponse login(String userName, String password) throws Exception;
	
	public SSOResponse logout(String token) throws Exception;
	
	public SSOResponse reactiveSession(String token) throws Exception;
}
