package th.co.ais.util;

public enum ELovVal {
					 //module ct	
					 V_CT_RENT("RENT"),
					 V_CT_DEPOSIT_RENT("DEPOSIT_RENT"),
					 V_CT_DEPOSIT_ELECTRIC("DEPOSIT_ELECTRIC"),

					 //module si
					 V_SI_APPROVE_TYPE("SITE_APPROVE"), 
					 V_SI_TERMINATE_TYPE("SITE_TERMINATE"), 
					 V_SI_TERMINATE_REQ_TYPE("99"),
					 V_SI_REQ_TYPE_OTHER("07"),
					 
					 // module co
					 V_CO_ROLE("LEGAL"),
					 V_CO_CONTRACT("CONTRACT"),
					 V_CO_LEGAL("FXL"),
					 V_CO_FXL("FXL"),
					 V_CO_AIS("AIS"),
					 V_CO_INTERNAL("INTERNAL");


	public String name = "";
	
	ELovVal(String name) {
		this.name = name;
	}
}