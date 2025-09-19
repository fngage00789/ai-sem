package th.co.ais.rpt.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SEMMRT003Domain extends ReportDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7752665633434685796L;
	private String PAYMENT_ID;
	private String PAYMENT_DOC_NO;
	private String SITE_NAME;
	private String CONTRACT_NO;
	private String PAYEE_NAME;
	private String ID_CARD;
	private String COMPANY_NAME;
	private String EXPENSE_TYPE;
	private Date EFFECTIVE_DT;
	private Date EXPIRE_DT;
	private String PAYMENT_TYPE;
	private String PAYEMNT_TYPE_DESC;
	private String CHQ_NO;
	private BigDecimal TOTAL_AMT;
	private String COMPANY_DESC;
	private String CONTACT_NAME;
	private String FAX;
	private String OUR_TELEPHONE;
	private String OUR_FAX_NO;
	private Date TRANSFER_DT;
	private String COMPANY_ADDRESS;
	private String USER_ADDRESS;
	private String USER_NAME;

	public String getPAYMENT_ID() {
		return PAYMENT_ID;
	}

	public void setPAYMENT_ID(String pAYMENTID) {
		PAYMENT_ID = pAYMENTID;
	}

	public String getPAYMENT_DOC_NO() {
		return PAYMENT_DOC_NO;
	}

	public void setPAYMENT_DOC_NO(String pAYMENTDOCNO) {
		PAYMENT_DOC_NO = pAYMENTDOCNO;
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

	public String getPAYEE_NAME() {
		return PAYEE_NAME;
	}

	public void setPAYEE_NAME(String pAYEENAME) {
		PAYEE_NAME = pAYEENAME;
	}

	public String getID_CARD() {
		return ID_CARD;
	}

	public void setID_CARD(String iDCARD) {
		ID_CARD = iDCARD;
	}

	public String getCOMPANY_NAME() {
		return COMPANY_NAME;
	}

	public void setCOMPANY_NAME(String cOMPANYNAME) {
		COMPANY_NAME = cOMPANYNAME;
	}

	public String getEXPENSE_TYPE() {
		return EXPENSE_TYPE;
	}

	public void setEXPENSE_TYPE(String eXPENSETYPE) {
		EXPENSE_TYPE = eXPENSETYPE;
	}

	public Date getEFFECTIVE_DT() {
		return EFFECTIVE_DT;
	}

	public void setEFFECTIVE_DT(Date eFFECTIVEDT) {
		EFFECTIVE_DT = eFFECTIVEDT;
	}

	public Date getEXPIRE_DT() {
		return EXPIRE_DT;
	}

	public void setEXPIRE_DT(Date eXPIREDT) {
		EXPIRE_DT = eXPIREDT;
	}

	public String getPAYMENT_TYPE() {
		return PAYMENT_TYPE;
	}

	public void setPAYMENT_TYPE(String pAYMENTTYPE) {
		PAYMENT_TYPE = pAYMENTTYPE;
	}

	public String getPAYEMNT_TYPE_DESC() {
		return PAYEMNT_TYPE_DESC;
	}

	public void setPAYEMNT_TYPE_DESC(String pAYEMNTTYPEDESC) {
		PAYEMNT_TYPE_DESC = pAYEMNTTYPEDESC;
	}

	public String getCHQ_NO() {
		return CHQ_NO;
	}

	public void setCHQ_NO(String cHQNO) {
		CHQ_NO = cHQNO;
	}

	public BigDecimal getTOTAL_AMT() {
		return TOTAL_AMT;
	}

	public void setTOTAL_AMT(BigDecimal tOTALAMT) {
		TOTAL_AMT = tOTALAMT;
	}

	public String getCOMPANY_DESC() {
		return COMPANY_DESC;
	}

	public void setCOMPANY_DESC(String cOMPANYDESC) {
		COMPANY_DESC = cOMPANYDESC;
	}

	public String getCONTACT_NAME() {
		return CONTACT_NAME;
	}

	public void setCONTACT_NAME(String cONTACTNAME) {
		CONTACT_NAME = cONTACTNAME;
	}

	public String getFAX() {
		return FAX;
	}

	public void setFAX(String fAX) {
		FAX = fAX;
	}

	public String getOUR_TELEPHONE() {
		return OUR_TELEPHONE;
	}

	public void setOUR_TELEPHONE(String oURTELEPHONE) {
		OUR_TELEPHONE = oURTELEPHONE;
	}

	public String getOUR_FAX_NO() {
		return OUR_FAX_NO;
	}

	public void setOUR_FAX_NO(String oURFAXNO) {
		OUR_FAX_NO = oURFAXNO;
	}

	public Date getTRANSFER_DT() {
		return TRANSFER_DT;
	}

	public void setTRANSFER_DT(Date tRANSFERDT) {
		TRANSFER_DT = tRANSFERDT;
	}

	public String getCOMPANY_ADDRESS() {
		return COMPANY_ADDRESS;
	}

	public void setCOMPANY_ADDRESS(String cOMPANYADDRESS) {
		COMPANY_ADDRESS = cOMPANYADDRESS;
	}

	public String getUSER_ADDRESS() {
		return USER_ADDRESS;
	}

	public void setUSER_ADDRESS(String uSERADDRESS) {
		USER_ADDRESS = uSERADDRESS;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSERNAME) {
		USER_NAME = uSERNAME;
	}

}
