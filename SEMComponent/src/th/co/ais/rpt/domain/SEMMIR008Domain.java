package th.co.ais.rpt.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SEMMIR008Domain extends ReportDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7752665633434685796L;

	private String ROW_ID;
	private String DRAFT_NO;
	private String NETWORK_TYPE_DESC;
	private String TRANSFER_TYPE_DESC;
	private String POLICY_TYPE;
	private String POLICY_TYPE_DESC;
	private String COMPANY_DESC;
	private String ADDRESS;
	private String TOTAL_LOCATION;
	private String POLICY_START_DT;
	private String POLICY_START_TM1;
	private String POLICY_START_TM2;
	private String POLICY_END_DT;
	private String POLICY_END_TM1;
	private String POLICY_END_TM2;
	private String INSURED_AMT;
	private String LIMIT_LOST;
	private Double LIMIT_LOST_AMT;
	private String DEDUCT_AMT;
	private Double PREMIUM_RATE;
	private String PREMIUM_AMT;
	private String DUTY_AMT;
	private String VAT_AMT;
	private String TOTAL_PREMIUM_AMT;
	private String INSURED_NAME;
	private String DOC_DT; 
	private String POLICY_DT;
	private String REMARK;
	private String FOR_MONTH;
	private String FOR_YEAR;
	private String REF_NO;
	private String REF_DT;
	private String POLICY_DAY;
	
	
	public String getPOLICY_DAY() {
		return POLICY_DAY;
	}
	public void setPOLICY_DAY(String pOLICYDAY) {
		POLICY_DAY = pOLICYDAY;
	}
	public String getPOLICY_DT() {
		return POLICY_DT;
	}
	public void setPOLICY_DT(String pOLICYDT) {
		POLICY_DT = pOLICYDT;
	}
	public String getPOLICY_START_DT() {
		return POLICY_START_DT;
	}
	public void setPOLICY_START_DT(String pOLICYSTARTDT) {
		POLICY_START_DT = pOLICYSTARTDT;
	}
	
	
	
	
	
	public String getDOC_DT() {
		return DOC_DT;
	}
	public void setDOC_DT(String dOCDT) {
		DOC_DT = dOCDT;
	}
	public String getPOLICY_END_DT() {
		return POLICY_END_DT;
	}
	public void setPOLICY_END_DT(String pOLICYENDDT) {
		POLICY_END_DT = pOLICYENDDT;
	}
	public String getROW_ID() {
		return ROW_ID;
	}
	public void setROW_ID(String rOWID) {
		ROW_ID = rOWID;
	}
	public String getDRAFT_NO() {
		return DRAFT_NO;
	}
	public void setDRAFT_NO(String dRAFTNO) {
		DRAFT_NO = dRAFTNO;
	}
	public String getNETWORK_TYPE_DESC() {
		return NETWORK_TYPE_DESC;
	}
	public void setNETWORK_TYPE_DESC(String nETWORKTYPEDESC) {
		NETWORK_TYPE_DESC = nETWORKTYPEDESC;
	}
	public String getTRANSFER_TYPE_DESC() {
		return TRANSFER_TYPE_DESC;
	}
	public void setTRANSFER_TYPE_DESC(String TRANSFERTYPEDESC) {
		TRANSFER_TYPE_DESC = TRANSFERTYPEDESC;
	}
	public String getPOLICY_TYPE() {
		return POLICY_TYPE;
	}
	public void setPOLICY_TYPE(String pOLICYTYPE) {
		POLICY_TYPE = pOLICYTYPE;
	}
	public String getPOLICY_TYPE_DESC() {
		return POLICY_TYPE_DESC;
	}
	public void setPOLICY_TYPE_DESC(String pOLICYTYPEDESC) {
		POLICY_TYPE_DESC = pOLICYTYPEDESC;
	}
	public String getCOMPANY_DESC() {
		return COMPANY_DESC;
	}
	public void setCOMPANY_DESC(String cOMPANYDESC) {
		COMPANY_DESC = cOMPANYDESC;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public String getTOTAL_LOCATION() {
		return TOTAL_LOCATION;
	}
	public void setTOTAL_LOCATION(String tOTALLOCATION) {
		TOTAL_LOCATION = tOTALLOCATION;
	}

	public String getPOLICY_START_TM1() {
		return POLICY_START_TM1;
	}
	public void setPOLICY_START_TM1(String pOLICYSTARTTM1) {
		POLICY_START_TM1 = pOLICYSTARTTM1;
	}
	public String getPOLICY_START_TM2() {
		return POLICY_START_TM2;
	}
	public void setPOLICY_START_TM2(String pOLICYSTARTTM2) {
		POLICY_START_TM2 = pOLICYSTARTTM2;
	}

	public String getPOLICY_END_TM1() {
		return POLICY_END_TM1;
	}
	public void setPOLICY_END_TM1(String pOLICYENDTM1) {
		POLICY_END_TM1 = pOLICYENDTM1;
	}
	public String getPOLICY_END_TM2() {
		return POLICY_END_TM2;
	}
	public void setPOLICY_END_TM2(String pOLICYENDTM2) {
		POLICY_END_TM2 = pOLICYENDTM2;
	}
	public String getINSURED_AMT() {
		return INSURED_AMT;
	}
	public void setINSURED_AMT(String iNSUREDAMT) {
		INSURED_AMT = iNSUREDAMT;
	}
	public String getLIMIT_LOST() {
		return LIMIT_LOST;
	}
	public void setLIMIT_LOST(String lIMITLOST) {
		LIMIT_LOST = lIMITLOST;
	}
	public Double getLIMIT_LOST_AMT() {
		return LIMIT_LOST_AMT;
	}
	public void setLIMIT_LOST_AMT(Double lIMITLOSTAMT) {
		LIMIT_LOST_AMT = lIMITLOSTAMT;
	}
	public String getDEDUCT_AMT() {
		return DEDUCT_AMT;
	}
	public void setDEDUCT_AMT(String dEDUCTAMT) {
		DEDUCT_AMT = dEDUCTAMT;
	}
	public Double getPREMIUM_RATE() {
		return PREMIUM_RATE;
	}
	public void setPREMIUM_RATE(Double pREMIUMRATE) {
		PREMIUM_RATE = pREMIUMRATE;
	}
	public String getPREMIUM_AMT() {
		return PREMIUM_AMT;
	}
	public void setPREMIUM_AMT(String pREMIUMAMT) {
		PREMIUM_AMT = pREMIUMAMT;
	}
	public String getDUTY_AMT() {
		return DUTY_AMT;
	}
	public void setDUTY_AMT(String dUTYAMT) {
		DUTY_AMT = dUTYAMT;
	}
	public String getVAT_AMT() {
		return VAT_AMT;
	}
	public void setVAT_AMT(String vATAMT) {
		VAT_AMT = vATAMT;
	}
	public String getTOTAL_PREMIUM_AMT() {
		return TOTAL_PREMIUM_AMT;
	}
	public void setTOTAL_PREMIUM_AMT(String tOTALPREMIUMAMT) {
		TOTAL_PREMIUM_AMT = tOTALPREMIUMAMT;
	}
	public String getINSURED_NAME() {
		return INSURED_NAME;
	}
	public void setINSURED_NAME(String iNSUREDNAME) {
		INSURED_NAME = iNSUREDNAME;
	}

	public String getREMARK() {
		return REMARK;
	}
	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}
	public String getFOR_MONTH() {
		return FOR_MONTH;
	}
	public void setFOR_MONTH(String fORMONTH) {
		FOR_MONTH = fORMONTH;
	}
	public String getFOR_YEAR() {
		return FOR_YEAR;
	}
	public void setFOR_YEAR(String fORYEAR) {
		FOR_YEAR = fORYEAR;
	}
	public String getREF_NO() {
		return REF_NO;
	}
	public void setREF_NO(String rEFNO) {
		REF_NO = rEFNO;
	}
	public String getREF_DT() {
		return REF_DT;
	}
	public void setREF_DT(String rEFDT) {
		REF_DT = rEFDT;
	}
	
	
	
}
