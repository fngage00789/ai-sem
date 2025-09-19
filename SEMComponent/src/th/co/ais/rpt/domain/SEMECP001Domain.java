package th.co.ais.rpt.domain;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SEMECP001Domain extends ReportDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7289179089691862401L;
	private Date DOC_DT;
	private String POST_TYPE;
	private BigDecimal POST_HEIGHT;
	private String SITE_NAME;
	private String TO_NAME;
	private String SITE_ADDR;
	private String BY_NAME;
	private String BY_POSITION;
	private String TOT_SEND_DOC_NO;
	private String DOC_DT_DESC;

	public String getTOT_SEND_DOC_NO() {
		return TOT_SEND_DOC_NO;
	}

	public void setTOT_SEND_DOC_NO(String tOTSENDDOCNO) {
		TOT_SEND_DOC_NO = tOTSENDDOCNO;
	}

	public Date getDOC_DT() {
		return DOC_DT;
	}

	public void setDOC_DT(Date dOCDT) {
		DOC_DT = dOCDT;
	}

	public String getPOST_TYPE() {
		return POST_TYPE;
	}

	public void setPOST_TYPE(String pOSTTYPE) {
		POST_TYPE = pOSTTYPE;
	}

	public BigDecimal getPOST_HEIGHT() {
		return POST_HEIGHT;
	}

	public void setPOST_HEIGHT(BigDecimal pOSTHEIGHT) {
		POST_HEIGHT = pOSTHEIGHT;
	}

	public String getSITE_NAME() {
		return SITE_NAME;
	}

	public void setSITE_NAME(String sITENAME) {
		SITE_NAME = sITENAME;
	}

	public String getTO_NAME() {
		return TO_NAME;
	}

	public void setTO_NAME(String tONAME) {
		TO_NAME = tONAME;
	}

	public String getSITE_ADDR() {
		return SITE_ADDR;
	}

	public void setSITE_ADDR(String sITEADDR) {
		SITE_ADDR = sITEADDR;
	}

	public String getBY_NAME() {
		return BY_NAME;
	}

	public void setBY_NAME(String bYNAME) {
		BY_NAME = bYNAME;
	}

	public String getBY_POSITION() {
		return BY_POSITION;
	}

	public void setBY_POSITION(String bYPOSITION) {
		BY_POSITION = bYPOSITION;
	}

	public String getDOC_DT_DESC() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy", new Locale("th", "TH"));
		return sdf.format(this.DOC_DT);
	}

	public void setDOC_DT_DESC(String dOCDTDESC) {
		DOC_DT_DESC = dOCDTDESC;
	}

}
