package com.ais.web.authenticate;

import java.util.List;

import Permission.bean.ais.com.SSOProgDesc;
import common.bean.ais.com.Message;

public class AuthenSSOResponse {
	
	private Message message;
	
	private List<SSOProgDesc> ssoProgCodes;
	
	public Message getMessage() {
		return message;
	}
	
	public void setMessage(Message message) {
		this.message = message;
	}
	
	public List<SSOProgDesc> getSsoProgCodes() {
		return ssoProgCodes;
	}
	
	public void setSsoProgCodes(List<SSOProgDesc> ssoProgCodes) {
		this.ssoProgCodes = ssoProgCodes;
	}
	
	public boolean notError() {
		return message != null && message.isFlag();
	}
	
	public boolean isError() {
		return !notError();
	}
	
}
