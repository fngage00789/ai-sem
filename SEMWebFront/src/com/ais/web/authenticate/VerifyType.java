package com.ais.web.authenticate;

public enum VerifyType {
	SSO, UNKNOW;
	
	public String toString() {
		switch (this) {
		case SSO:
			return "SSO";
		case UNKNOW:
			return "UNKNOW";
		default: 
			throw new IllegalArgumentException("Enum not found :"+ this);
		}
	}
}
