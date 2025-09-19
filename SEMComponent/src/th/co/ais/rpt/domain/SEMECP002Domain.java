package th.co.ais.rpt.domain;


public class SEMECP002Domain extends ReportDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6767358920134397064L;
	private String SITE_NAME;
	private String CONTRACT_NO;
	private String COMPANY_NAME;
	private String COMPANY_ADDR;
	private String BY_NAME;
	private String BY_AGE;
	private String BY_ADDR;
	private String SITE_ADDR;
	private String WITNESS_1;
	private String WITNESS_2;
	private String CON_PERMISSION_DOC_NO;

	public String getCON_PERMISSION_DOC_NO() {
		return CON_PERMISSION_DOC_NO;
	}

	public void setCON_PERMISSION_DOC_NO(String cONPERMISSIONDOCNO) {
		CON_PERMISSION_DOC_NO = cONPERMISSIONDOCNO;
	}

	public String getSITE_NAME() {
		return SITE_NAME;
	}

	public void setSITE_NAME(String sITENAME) {
		SITE_NAME = sITENAME;
	}

	public String getCONTRACT_NO() {
		return CONTRACT_NO;
	}

	public void setCONTRACT_NO(String cONTRACTNO) {
		CONTRACT_NO = cONTRACTNO;
	}

	public String getCOMPANY_NAME() {
		return COMPANY_NAME;
	}

	public void setCOMPANY_NAME(String cOMPANYNAME) {
		COMPANY_NAME = cOMPANYNAME;
	}

	public String getCOMPANY_ADDR() {
		return COMPANY_ADDR;
	}

	public void setCOMPANY_ADDR(String cOMPANYADDR) {
		COMPANY_ADDR = cOMPANYADDR;
	}

	public String getBY_NAME() {
		return BY_NAME;
	}

	public void setBY_NAME(String bYNAME) {
		BY_NAME = bYNAME;
	}

	public String getBY_AGE() {
		return BY_AGE;
	}

	public void setBY_AGE(String bYAGE) {
		BY_AGE = bYAGE;
	}

	public String getBY_ADDR() {
		return BY_ADDR;
	}

	public void setBY_ADDR(String bYADDR) {
		BY_ADDR = bYADDR;
	}

	public String getSITE_ADDR() {
		return SITE_ADDR;
	}

	public void setSITE_ADDR(String sITEADDR) {
		SITE_ADDR = sITEADDR;
	}

	public String getWITNESS_1() {
		return WITNESS_1;
	}

	public void setWITNESS_1(String wITNESS_1) {
		WITNESS_1 = wITNESS_1;
	}

	public String getWITNESS_2() {
		return WITNESS_2;
	}

	public void setWITNESS_2(String wITNESS_2) {
		WITNESS_2 = wITNESS_2;
	}

}
