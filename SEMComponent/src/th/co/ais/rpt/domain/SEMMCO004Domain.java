package th.co.ais.rpt.domain;

import java.math.BigDecimal;
import java.util.Date;

import th.co.ais.rpt.util.DataUtil;
import th.co.ais.util.SEMDataUtility;

public class SEMMCO004Domain extends ReportDomain {
	
	private String SITE_NAME;
	private String CONTRACT_NO;
	private String LOCATION_ID;
	private String AREA_DESC;
	private String SITE_ADDR;
	private String EFFECTIVE_DT;
	private String EXPIRE_DT;
	private BigDecimal RENT_AMT;
	private BigDecimal SERVICE_AMT;
	private String RENT_AMT_DESC;
	private String SERVICE_AMT_DESC;
	private String RENT_AMT_STR;
	private String SERVICE_AMT_STR;
	private String GROUP_NO;
	private String DOC_NO;
	
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
	public String getLOCATION_ID() {
		return LOCATION_ID;
	}
	public void setLOCATION_ID(String lOCATIONID) {
		LOCATION_ID = lOCATIONID;
	}
	public String getAREA_DESC() {
		return AREA_DESC;
	}
	public void setAREA_DESC(String aREADESC) {
		AREA_DESC = aREADESC;
	}
	public String getSITE_ADDR() {
		return SITE_ADDR;
	}
	public void setSITE_ADDR(String sITEADDR) {
		SITE_ADDR = sITEADDR;
	}
	public String getEFFECTIVE_DT() {
		return EFFECTIVE_DT;
	}
	public void setEFFECTIVE_DT(String eFFECTIVEDT) {
		EFFECTIVE_DT = eFFECTIVEDT;
	}
	public String getEXPIRE_DT() {
		return EXPIRE_DT;
	}
	public void setEXPIRE_DT(String eXPIREDT) {
		EXPIRE_DT = eXPIREDT;
	}
	public BigDecimal getRENT_AMT() {
		return RENT_AMT;
	}
	public void setRENT_AMT(BigDecimal rENTAMT) {
		RENT_AMT = rENTAMT;
	}
	public BigDecimal getSERVICE_AMT() {
		return SERVICE_AMT;
	}
	public void setSERVICE_AMT(BigDecimal sERVICEAMT) {
		SERVICE_AMT = sERVICEAMT;
	}
	public String getRENT_AMT_DESC() {
		return DataUtil.convert2ThaiBath(getRENT_AMT());
	}
	public void setRENT_AMT_DESC(String rENTAMTDESC) {
		RENT_AMT_DESC = rENTAMTDESC;
	}
	public String getSERVICE_AMT_DESC() {
		return DataUtil.convert2ThaiBath(getSERVICE_AMT());
	}
	public void setSERVICE_AMT_DESC(String sERVICEAMTDESC) {
		SERVICE_AMT_DESC = sERVICEAMTDESC;
	}
	public String getRENT_AMT_STR() {
		String result = null;
		if(getRENT_AMT() != null){
			result = SEMDataUtility.convertNumberToStringByFormat(getRENT_AMT().doubleValue(), "#,##0.00");
			result = result.replace(".00", "");
		}
		return result;
	}
	public void setRENT_AMT_STR(String rENTAMTSTR) {
		RENT_AMT_STR = rENTAMTSTR;
	}
	public String getSERVICE_AMT_STR() {
		String result = null;
		if(getSERVICE_AMT() != null){
			result = SEMDataUtility.convertNumberToStringByFormat(getSERVICE_AMT().doubleValue(), "#,##0.00");
			result = result.replace(".00", "");
		}
		return result;
	}
	public void setSERVICE_AMT_STR(String sERVICEAMTSTR) {
		SERVICE_AMT_STR = sERVICEAMTSTR;
	}
	public String getGROUP_NO() {
		return GROUP_NO;
	}
	public void setGROUP_NO(String gROUPNO) {
		GROUP_NO = gROUPNO;
	}
	public String getDOC_NO() {
		return DOC_NO;
	}
	public void setDOC_NO(String dOCNO) {
		DOC_NO = dOCNO;
	}
	
	
	
}
