package th.co.ais.util;

public enum EParamName {P_REP_SITE_STATUS("REP_SITE_STATUS"),
					    P_REP_MASTER_DATA("REP_MASTER_DATA"),
					    P_REP_DUP_MASTER_DATA("REP_DUP_MASTER_DATA");

public String name = "";

EParamName(String name) {
this.name = name;
}
}