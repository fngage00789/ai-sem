package th.co.ais.rpt.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SEMMIR012Domain extends ReportDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7752665633434685796L;

	private String CLAIM_ID;
	private String CLAIM_NO;
	private Date CLAIM_DT;
	private String REQ_BY;
	private String REQ_DEP_BY;
	private String REQ_TEL;
	private String REQ_EMAIL;
	private String LOCATION_ID;
	private String LOCATION_NAME;
	private String LOSS_PLACE_NAME;
	private String SAME_LOCATION_FLG;
	private String LOSS_PROVINCE_ID;
	private String LOSS_REGION;
	private String TRANSFER_TYPE;
	private String LOSS_ADDRESS;
	private Date LOSS_DT;
	private String LOSS_TIME;
	private String LOSS_TYPE;
	private String LOSS_SUB_TYPE;
	private String LOSS_DESC;
	private Double ESTIMATE_AMT;
	private String PRE_ACT;
	private String LITIGANT_FLG;
	private String LITIGANT_NAME;
	private String LITIGANT_ADDRESS;
	private String LITIGANT_TEL;
	private String DOC_01; 
	private String DOC_02;
	private String DOC_03;
	private String DOC_04;
	private String DOC_05;
	private String DOC_05_DESC;
	private String CLAIM_STATUS;
	private String REMARK;
	private String RECORD_STATUS;
	private String VERSION;
	private Date CREATE_DT;
	private String CREATE_BY;
	private Date UPDATE_DT;
	private String UPDATE_BY;
	public String getCLAIM_ID() {
		return CLAIM_ID;
	}
	public void setCLAIM_ID(String cLAIMID) {
		CLAIM_ID = cLAIMID;
	}
	public String getCLAIM_NO() {
		return CLAIM_NO;
	}
	public void setCLAIM_NO(String cLAIMNO) {
		CLAIM_NO = cLAIMNO;
	}
	public Date getCLAIM_DT() {
		return CLAIM_DT;
	}
	public void setCLAIM_DT(Date cLAIMDT) {
		CLAIM_DT = cLAIMDT;
	}
	public String getREQ_BY() {
		return REQ_BY;
	}
	public void setREQ_BY(String rEQBY) {
		REQ_BY = rEQBY;
	}
	public String getREQ_DEP_BY() {
		return REQ_DEP_BY;
	}
	public void setREQ_DEP_BY(String rEQDEPBY) {
		REQ_DEP_BY = rEQDEPBY;
	}
	public String getREQ_TEL() {
		return REQ_TEL;
	}
	public void setREQ_TEL(String rEQTEL) {
		REQ_TEL = rEQTEL;
	}
	public String getREQ_EMAIL() {
		return REQ_EMAIL;
	}
	public void setREQ_EMAIL(String rEQEMAIL) {
		REQ_EMAIL = rEQEMAIL;
	}
	public String getLOCATION_ID() {
		return LOCATION_ID;
	}
	public void setLOCATION_ID(String lOCATIONID) {
		LOCATION_ID = lOCATIONID;
	}
	public String getLOCATION_NAME() {
		return LOCATION_NAME;
	}
	public void setLOCATION_NAME(String lOCATIONNAME) {
		LOCATION_NAME = lOCATIONNAME;
	}
	public String getLOSS_PLACE_NAME() {
		return LOSS_PLACE_NAME;
	}
	public void setLOSS_PLACE_NAME(String lOSSPLACENAME) {
		LOSS_PLACE_NAME = lOSSPLACENAME;
	}
	public String getSAME_LOCATION_FLG() {
		return SAME_LOCATION_FLG;
	}
	public void setSAME_LOCATION_FLG(String sAMELOCATIONFLG) {
		SAME_LOCATION_FLG = sAMELOCATIONFLG;
	}
	public String getLOSS_PROVINCE_ID() {
		return LOSS_PROVINCE_ID;
	}
	public void setLOSS_PROVINCE_ID(String lOSSPROVINCEID) {
		LOSS_PROVINCE_ID = lOSSPROVINCEID;
	}
	public String getLOSS_REGION() {
		return LOSS_REGION;
	}
	public void setLOSS_REGION(String lOSSREGION) {
		LOSS_REGION = lOSSREGION;
	}
	public String getTRANSFER_TYPE() {
		return TRANSFER_TYPE;
	}
	public void setTRANSFER_TYPE(String tRANSFERTYPE) {
		TRANSFER_TYPE = tRANSFERTYPE;
	}
	public String getLOSS_ADDRESS() {
		return LOSS_ADDRESS;
	}
	public void setLOSS_ADDRESS(String lOSSADDRESS) {
		LOSS_ADDRESS = lOSSADDRESS;
	}
	public Date getLOSS_DT() {
		return LOSS_DT;
	}
	public void setLOSS_DT(Date lOSSDT) {
		LOSS_DT = lOSSDT;
	}
	public String getLOSS_TIME() {
		return LOSS_TIME;
	}
	public void setLOSS_TIME(String lOSSTIME) {
		LOSS_TIME = lOSSTIME;
	}
	public String getLOSS_TYPE() {
		return LOSS_TYPE;
	}
	public void setLOSS_TYPE(String lOSSTYPE) {
		LOSS_TYPE = lOSSTYPE;
	}
	public String getLOSS_SUB_TYPE() {
		return LOSS_SUB_TYPE;
	}
	public void setLOSS_SUB_TYPE(String lOSSSUBTYPE) {
		LOSS_SUB_TYPE = lOSSSUBTYPE;
	}
	public String getLOSS_DESC() {
		return LOSS_DESC;
	}
	public void setLOSS_DESC(String lOSSDESC) {
		LOSS_DESC = lOSSDESC;
	}
	public Double getESTIMATE_AMT() {
		return ESTIMATE_AMT;
	}
	public void setESTIMATE_AMT(Double eSTIMATEAMT) {
		ESTIMATE_AMT = eSTIMATEAMT;
	}
	public String getPRE_ACT() {
		return PRE_ACT;
	}
	public void setPRE_ACT(String pREACT) {
		PRE_ACT = pREACT;
	}
	public String getLITIGANT_FLG() {
		return LITIGANT_FLG;
	}
	public void setLITIGANT_FLG(String lITIGANTFLG) {
		LITIGANT_FLG = lITIGANTFLG;
	}
	public String getLITIGANT_NAME() {
		return LITIGANT_NAME;
	}
	public void setLITIGANT_NAME(String lITIGANTNAME) {
		LITIGANT_NAME = lITIGANTNAME;
	}
	public String getLITIGANT_ADDRESS() {
		return LITIGANT_ADDRESS;
	}
	public void setLITIGANT_ADDRESS(String lITIGANTADDRESS) {
		LITIGANT_ADDRESS = lITIGANTADDRESS;
	}
	public String getLITIGANT_TEL() {
		return LITIGANT_TEL;
	}
	public void setLITIGANT_TEL(String lITIGANTTEL) {
		LITIGANT_TEL = lITIGANTTEL;
	}
	public String getDOC_01() {
		return DOC_01;
	}
	public void setDOC_01(String dOC_01) {
		DOC_01 = dOC_01;
	}
	public String getDOC_02() {
		return DOC_02;
	}
	public void setDOC_02(String dOC_02) {
		DOC_02 = dOC_02;
	}
	public String getDOC_03() {
		return DOC_03;
	}
	public void setDOC_03(String dOC_03) {
		DOC_03 = dOC_03;
	}
	public String getDOC_04() {
		return DOC_04;
	}
	public void setDOC_04(String dOC_04) {
		DOC_04 = dOC_04;
	}
	public String getDOC_05() {
		return DOC_05;
	}
	public void setDOC_05(String dOC_05) {
		DOC_05 = dOC_05;
	}
	public String getDOC_05_DESC() {
		return DOC_05_DESC;
	}
	public void setDOC_05_DESC(String dOC_05DESC) {
		DOC_05_DESC = dOC_05DESC;
	}
	public String getCLAIM_STATUS() {
		return CLAIM_STATUS;
	}
	public void setCLAIM_STATUS(String cLAIMSTATUS) {
		CLAIM_STATUS = cLAIMSTATUS;
	}
	public String getREMARK() {
		return REMARK;
	}
	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}
	public String getRECORD_STATUS() {
		return RECORD_STATUS;
	}
	public void setRECORD_STATUS(String rECORDSTATUS) {
		RECORD_STATUS = rECORDSTATUS;
	}
	public String getVERSION() {
		return VERSION;
	}
	public void setVERSION(String vERSION) {
		VERSION = vERSION;
	}
	public Date getCREATE_DT() {
		return CREATE_DT;
	}
	public void setCREATE_DT(Date cREATEDT) {
		CREATE_DT = cREATEDT;
	}
	public String getCREATE_BY() {
		return CREATE_BY;
	}
	public void setCREATE_BY(String cREATEBY) {
		CREATE_BY = cREATEBY;
	}
	public Date getUPDATE_DT() {
		return UPDATE_DT;
	}
	public void setUPDATE_DT(Date uPDATEDT) {
		UPDATE_DT = uPDATEDT;
	}
	public String getUPDATE_BY() {
		return UPDATE_BY;
	}
	public void setUPDATE_BY(String uPDATEBY) {
		UPDATE_BY = uPDATEBY;
	}
	
	
	
}
