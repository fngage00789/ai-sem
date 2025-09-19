package th.co.ais.util;

public enum EParamCode {P_PATH_UPLOAD_CONTRACT("PATH_UPLOAD_CONTRACT"),
					    P_ROW_PER_PAGE("ROW_PER_PAGE"),
					    P_CO_COPY_CONTRACT_AIS("CO_COPY_CONTRACT_AIS"), 
					    P_CO_COPY_CONTRACT_FXL("CO_COPY_CONTRACT_FXL"), 
					    P_CO_COPY_DUTY_AMT("CO_COPY_DUTY_AMT"),
					    P_SSO_AUTHORIZE_MENU("SSO_AUTHORIZE_MENU"),
					    P_SSO_AUTHORIZE_COMPONENT("SSO_AUTHORIZE_COMPONENT");

	public String name = "";
	
	EParamCode(String name) {
		this.name = name;
	}
}