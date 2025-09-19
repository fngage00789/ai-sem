package com.ais.web.authenticate;

import Permission.bean.ais.com.SSOCompCode;
import common.bean.ais.com.Message;

public class AuthenCompCodeResponse {
	
	private Message message;
	private SSOCompCode[] componentCodes;

	public void setMessage(Message message) {
		this.message = message;
	}

	public Message getMessage() {
		return message;
	}

	public void setComponentCodes(SSOCompCode[] componentCodes) {
		this.componentCodes = componentCodes;
	}

	public SSOCompCode[] getComponentCodes() {
		return componentCodes;
	}
	
	public boolean isNotError() {
		return message != null && message.isFlag();
	}
}
