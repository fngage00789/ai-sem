package th.co.ais.rpt.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import th.co.ais.rpt.util.DataUtil;
import th.co.ais.util.SEMDataUtility;

public class SEMECO005Domain extends ReportDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8339595088997826423L;
	private String SITE_INFO_ID;
	private String SITE_NAME;
	private String CONTRACT_NO;
	private Date DOC_DT;
	private String COMPANY_ADDR;
	private String COMPANY_HOUSE_NO;
	private String COMPANY_STREET;
	private String COMPANY_TAMBON;
	private String COMPANY_AMPHUR;
	private String COMPANY_PROVINCE;
	private String LESSOR_ADS_AMPHER;
	private String LESSOR_ADS_PROV;
	
	private String BY_NAME;

	private String OWNER_NAME;
	private String LESSOR_NAME;
	private String LESSOR_ADDR;
	private String TOT_BY_NAME;
	private String TOT_BY_POSITION1;
	private String TOT_BY_POSITION2;
	private String TOT_BY_POSITION3;
	private String TOT_SEND_FLAG;
	private String SITE_ADDR;
	private boolean IS_PERSON;
	
	private String GROUP_NO;
	
	private BigDecimal DECK_AREA;
	private String DECK_AREA_TYPE_DESC;
	private String BUILDING_AREA;
	private String BUILDING_AREA_TYPE_DESC;

	private BigDecimal ROOM_AREA;
	private String ROOM_AREA_TYPE_DESC;
	private BigDecimal LAND_AREA;
	private String LAND_AREA_TYPE_DESC;
	private String LAND_AREA_UNIT_TYPE_DESC;

	private String AREA_DESC;

	private String CONTRACT_AGE;
	private String CONTRACT_AGE_DESC;
	private Date EFFECTIVE_DT;
	private Date EXPIRE_DT;
	private BigDecimal AGE_YEAR;
	private BigDecimal AGE_MONTH;
	private BigDecimal AGE_DAY;

	private String RENT_PERIOD_TYPE;
	private BigDecimal RENT_AMT;
	private String RENT_WHT_TYPE_DESC;
	private BigDecimal RENT_WHT_RATE;
	private String RENT_AMT_X_TIME;
	private BigDecimal TOTAL_RENT_AMT;

	private BigDecimal RENT_PAY_PERIOD;
	private String RENT_PAY_PERIOD_TYPE;
	private String RENT_PAY_PERIOD_TYPE_NAME;
	private String RENT_PAY_DUE_DESC;

	private String RENT_DEPOSIT_FLAG;
	private BigDecimal RENT_DEPOSIT_AMT;

	private String SERVICE_DEPOSIT_FLAG;
	private BigDecimal SERVICE_DEPOSIT_AMT;

	private BigDecimal ET_UNIT_PRICE_AMT;
	private String ET_VAT_TYPE_NAME;
	private BigDecimal ET_TAKE_ALL_AMT;
	private String ET_TAKE_ALL_PERIOD_TYPE_NAME;

	private BigDecimal PROMISE_RENEW_TIME;
	private BigDecimal PROMISE_RENEW_PERIOD;
	private String PROMISE_RENEW_PERIOD_TYPE;

	private String PLACE_TYPE;
	
	private String RENT_COND_TYPE;
	private String RENT_DETAIL;
     
	private String COMPANY_NAME;
	
	// Add by Kanchai Writed 11 Feb 2011
	private BigDecimal RENT_PAY_PERIOD_AMT;
	private String SIGN_NAME;
	private String PERIOD_TYPE_PER;
	/*
	 * All below declare for expression to control SEMECO001, SEMECO003 Report Author
	 * Warawit Kitmongkonsak Writed 21 December 2010
	 */
	private String CONTRACT_AGE_DESC_;
	
	private String RENT_AMT_DESC;
	private String RENT_PAY_PERIOD_DESC;
	private String RENT_DEPOSIT_AMT_DESC;
	private String TOTAL_RENT_AMT_DESC;
	
	private String ET_UNIT_PRICE_AMT_DESC;
	private String ET_TAKE_ALL_AMT_DESC;
	
	private String SERVICE_AMT_DESC;
	private String TOTAL_SERVICE_AMT_DESC;
	
	private String MONTH_NUM;
	private String PROMISE_RENEW_PERIOD_DESC;

	private String S_RENT_PAY_PERIOD_TYPE_01;
	private String S_RENT_PAY_PERIOD_TYPE_02;
	private String S_ELECTIRC_TYPE_01;
	private String S_PROMISE_RENEW_TIME;
	
	private String RENT_PAY_PERIOD_AMT_DESC;
	private String SERVICE_AMT_STR;
	private String ET_UNIT_PRICE_AMT_STR;
	private String ET_TAKE_ALL_AMT_STR;
	private String MONTH_NUM_SERVICE;
	
	private String WITNESS_1;
	private String LESSER_NAME;
	
	private BigDecimal SERVICE_AMT;
	private String REGION;

	public String getSITE_INFO_ID() {
		return SITE_INFO_ID;
	}

	public void setSITE_INFO_ID(String sITEINFOID) {
		SITE_INFO_ID = sITEINFOID;
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

	public Date getDOC_DT() {
		return DOC_DT;
	}

	public void setDOC_DT(Date dOCDT) {
		DOC_DT = dOCDT;
	}

	public String getBY_NAME() {
		return BY_NAME;
	}

	public void setBY_NAME(String bYNAME) {
		BY_NAME = bYNAME;
	}

	public String getOWNER_NAME() {
		return OWNER_NAME;
	}

	public void setOWNER_NAME(String oWNERNAME) {
		OWNER_NAME = oWNERNAME;
	}

	public String getLESSOR_NAME() {
		return LESSOR_NAME;
	}

	public void setLESSOR_NAME(String lESSORNAME) {
		LESSOR_NAME = lESSORNAME;
	}

	public String getLESSOR_ADDR() {
		return LESSOR_ADDR;
	}

	public void setLESSOR_ADDR(String lESSORADDR) {
		LESSOR_ADDR = lESSORADDR;
	}

	public String getTOT_BY_NAME() {
		return TOT_BY_NAME;
	}

	public void setTOT_BY_NAME(String tOTBYNAME) {
		TOT_BY_NAME = tOTBYNAME;
	}

	public String getTOT_BY_POSITION1() {
		return TOT_BY_POSITION1;
	}

	public void setTOT_BY_POSITION1(String tOTBYPOSITION1) {
		TOT_BY_POSITION1 = tOTBYPOSITION1;
	}

	public String getTOT_BY_POSITION2() {
		return TOT_BY_POSITION2;
	}

	public void setTOT_BY_POSITION2(String tOTBYPOSITION2) {
		TOT_BY_POSITION2 = tOTBYPOSITION2;
	}

	public String getTOT_BY_POSITION3() {
		return TOT_BY_POSITION3;
	}

	public void setTOT_BY_POSITION3(String tOTBYPOSITION3) {
		TOT_BY_POSITION3 = tOTBYPOSITION3;
	}

	public String getTOT_SEND_FLAG() {
		return TOT_SEND_FLAG;
	}

	public void setTOT_SEND_FLAG(String tOTSENDFLAG) {
		TOT_SEND_FLAG = tOTSENDFLAG;
	}

	public String getSITE_ADDR() {
		return SITE_ADDR;
	}

	public void setSITE_ADDR(String sITEADDR) {
		SITE_ADDR = sITEADDR;
	}

	public BigDecimal getDECK_AREA() {
		return DECK_AREA;
	}

	public void setDECK_AREA(BigDecimal dECKAREA) {
		DECK_AREA = dECKAREA;
	}

	public String getDECK_AREA_TYPE_DESC() {
		return DECK_AREA_TYPE_DESC;
	}

	public void setDECK_AREA_TYPE_DESC(String dECKAREATYPEDESC) {
		DECK_AREA_TYPE_DESC = dECKAREATYPEDESC;
	}

	public String getBUILDING_AREA() {
		return BUILDING_AREA;
	}

	public void setBUILDING_AREA(String bUILDINGAREA) {
		BUILDING_AREA = bUILDINGAREA;
	}

	public String getBUILDING_AREA_TYPE_DESC() {
		return BUILDING_AREA_TYPE_DESC;
	}

	public void setBUILDING_AREA_TYPE_DESC(String bUILDINGAREATYPEDESC) {
		BUILDING_AREA_TYPE_DESC = bUILDINGAREATYPEDESC;
	}

	public BigDecimal getROOM_AREA() {
		return ROOM_AREA;
	}

	public void setROOM_AREA(BigDecimal rOOMAREA) {
		ROOM_AREA = rOOMAREA;
	}

	public String getROOM_AREA_TYPE_DESC() {
		return ROOM_AREA_TYPE_DESC;
	}

	public void setROOM_AREA_TYPE_DESC(String rOOMAREATYPEDESC) {
		ROOM_AREA_TYPE_DESC = rOOMAREATYPEDESC;
	}

	public BigDecimal getLAND_AREA() {
		return LAND_AREA;
	}

	public void setLAND_AREA(BigDecimal lANDAREA) {
		LAND_AREA = lANDAREA;
	}

	public String getLAND_AREA_TYPE_DESC() {
		return LAND_AREA_TYPE_DESC;
	}

	public void setLAND_AREA_TYPE_DESC(String lANDAREATYPEDESC) {
		LAND_AREA_TYPE_DESC = lANDAREATYPEDESC;
	}

	public String getLAND_AREA_UNIT_TYPE_DESC() {
		return LAND_AREA_UNIT_TYPE_DESC;
	}

	public void setLAND_AREA_UNIT_TYPE_DESC(String lANDAREAUNITTYPEDESC) {
		LAND_AREA_UNIT_TYPE_DESC = lANDAREAUNITTYPEDESC;
	}

	public String getAREA_DESC() {
		return AREA_DESC;
	}

	public void setAREA_DESC(String aREADESC) {
		AREA_DESC = aREADESC;
	}

	public String getCONTRACT_AGE() {
		return CONTRACT_AGE;
	}

	public void setCONTRACT_AGE(String cONTRACTAGE) {
		CONTRACT_AGE = cONTRACTAGE;
	}

	public String getCONTRACT_AGE_DESC() {
		return CONTRACT_AGE_DESC;
	}

	public void setCONTRACT_AGE_DESC(String cONTRACTAGEDESC) {
		CONTRACT_AGE_DESC = cONTRACTAGEDESC;
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

	public BigDecimal getAGE_YEAR() {
		return AGE_YEAR;
	}

	public void setAGE_YEAR(BigDecimal aGEYEAR) {
		AGE_YEAR = aGEYEAR;
	}

	public BigDecimal getAGE_MONTH() {
		return AGE_MONTH;
	}

	public void setAGE_MONTH(BigDecimal aGEMONTH) {
		AGE_MONTH = aGEMONTH;
	}

	public BigDecimal getAGE_DAY() {
		return AGE_DAY;
	}

	public void setAGE_DAY(BigDecimal aGEDAY) {
		AGE_DAY = aGEDAY;
	}

	public String getRENT_PERIOD_TYPE() {
		return DataUtil.convert2Abridgement(RENT_PERIOD_TYPE);
	}

	public void setRENT_PERIOD_TYPE(String rENTPERIODTYPE) {
		RENT_PERIOD_TYPE = rENTPERIODTYPE;
	}

	public BigDecimal getRENT_AMT() {
		return RENT_AMT;
	}

	public void setRENT_AMT(BigDecimal rENTAMT) {
		RENT_AMT = rENTAMT;
	}

	public String getRENT_WHT_TYPE_DESC() {
		return RENT_WHT_TYPE_DESC;
	}

	public void setRENT_WHT_TYPE_DESC(String rENTWHTTYPEDESC) {
		RENT_WHT_TYPE_DESC = rENTWHTTYPEDESC;
	}

	public BigDecimal getRENT_WHT_RATE() {
		return RENT_WHT_RATE;
	}

	public void setRENT_WHT_RATE(BigDecimal rENTWHTRATE) {
		RENT_WHT_RATE = rENTWHTRATE;
	}

	public String getRENT_AMT_X_TIME() {
		return RENT_AMT_X_TIME;
	}

	public void setRENT_AMT_X_TIME(String rENTAMTXTIME) {
		RENT_AMT_X_TIME = rENTAMTXTIME;
	}

	public BigDecimal getTOTAL_RENT_AMT() {
		return TOTAL_RENT_AMT;
	}

	public void setTOTAL_RENT_AMT(BigDecimal tOTALRENTAMT) {
		TOTAL_RENT_AMT = tOTALRENTAMT;
	}

	public BigDecimal getRENT_PAY_PERIOD() {
		return RENT_PAY_PERIOD;
	}

	public void setRENT_PAY_PERIOD(BigDecimal rENTPAYPERIOD) {
		RENT_PAY_PERIOD = rENTPAYPERIOD;
	}

	public String getRENT_PAY_PERIOD_TYPE() {
		StringBuilder sb = new StringBuilder();
		if (StringUtils.isNotEmpty(RENT_PAY_PERIOD_TYPE)
				&& "03".equals(RENT_PAY_PERIOD_TYPE)) {
			sb.append("\u0E07\u0E27\u0E14");
			sb.append(" ");
			sb.append(getRENT_PAY_PERIOD());
			sb.append(" ");
			sb.append("\u0E25\u0E30");
		} else {
			sb.append(DataUtil.convert2Abridgement(RENT_PAY_PERIOD_TYPE));
		}
		return sb.toString();
	}

	public void setRENT_PAY_PERIOD_TYPE(String rENTPAYPERIODTYPE) {
		RENT_PAY_PERIOD_TYPE = rENTPAYPERIODTYPE;
	}

	public String getRENT_PAY_PERIOD_TYPE_NAME() {
		return RENT_PAY_PERIOD_TYPE_NAME;
	}

	public void setRENT_PAY_PERIOD_TYPE_NAME(String rENTPAYPERIODTYPENAME) {
		RENT_PAY_PERIOD_TYPE_NAME = rENTPAYPERIODTYPENAME;
	}

	public String getRENT_PAY_DUE_DESC() {
		return RENT_PAY_DUE_DESC;
	}

	public void setRENT_PAY_DUE_DESC(String rENTPAYDUEDESC) {
		RENT_PAY_DUE_DESC = rENTPAYDUEDESC;
	}

	public String getRENT_DEPOSIT_FLAG() {
		return RENT_DEPOSIT_FLAG;
	}

	public void setRENT_DEPOSIT_FLAG(String rENTDEPOSITFLAG) {
		RENT_DEPOSIT_FLAG = rENTDEPOSITFLAG;
	}

	public BigDecimal getRENT_DEPOSIT_AMT() {
		return RENT_DEPOSIT_AMT;
	}

	public void setRENT_DEPOSIT_AMT(BigDecimal rENTDEPOSITAMT) {
		RENT_DEPOSIT_AMT = rENTDEPOSITAMT;
	}

	public String getSERVICE_DEPOSIT_FLAG() {
		return SERVICE_DEPOSIT_FLAG;
	}

	public void setSERVICE_DEPOSIT_FLAG(String sERVICEDEPOSITFLAG) {
		SERVICE_DEPOSIT_FLAG = sERVICEDEPOSITFLAG;
	}

	public BigDecimal getSERVICE_DEPOSIT_AMT() {
		return SERVICE_DEPOSIT_AMT;
	}

	public void setSERVICE_DEPOSIT_AMT(BigDecimal sERVICEDEPOSITAMT) {
		SERVICE_DEPOSIT_AMT = sERVICEDEPOSITAMT;
	}

	public BigDecimal getET_UNIT_PRICE_AMT() {
		return ET_UNIT_PRICE_AMT;
	}

	public void setET_UNIT_PRICE_AMT(BigDecimal eTUNITPRICEAMT) {
		ET_UNIT_PRICE_AMT = eTUNITPRICEAMT;
	}

	public String getET_VAT_TYPE_NAME() {
		return ET_VAT_TYPE_NAME;
	}

	public void setET_VAT_TYPE_NAME(String eTVATTYPENAME) {
		ET_VAT_TYPE_NAME = eTVATTYPENAME;
	}

	public BigDecimal getPROMISE_RENEW_TIME() {
		return PROMISE_RENEW_TIME;
	}

	public void setPROMISE_RENEW_TIME(BigDecimal pROMISERENEWTIME) {
		PROMISE_RENEW_TIME = pROMISERENEWTIME;
	}

	public BigDecimal getPROMISE_RENEW_PERIOD() {
		return PROMISE_RENEW_PERIOD;
	}

	public void setPROMISE_RENEW_PERIOD(BigDecimal pROMISERENEWPERIOD) {
		PROMISE_RENEW_PERIOD = pROMISERENEWPERIOD;
	}

	public String getPROMISE_RENEW_PERIOD_TYPE() {
		return DataUtil.convert2Abridgement(PROMISE_RENEW_PERIOD_TYPE);
	}

	public void setPROMISE_RENEW_PERIOD_TYPE(String pROMISERENEWPERIODTYPE) {
		PROMISE_RENEW_PERIOD_TYPE = pROMISERENEWPERIODTYPE;
	}

	public String getCONTRACT_AGE_DESC_() {
		return DataUtil.convertDate2ThaiWord(getAGE_YEAR(), getAGE_MONTH(),
				getAGE_DAY());
	}

	public void setCONTRACT_AGE_DESC_(String cONTRACTAGEDESC) {
		CONTRACT_AGE_DESC_ = cONTRACTAGEDESC;
	}

	public String getRENT_AMT_DESC() {
		return DataUtil.convert2ThaiBath(getRENT_AMT());
	}

	public void setRENT_AMT_DESC(String rENTAMTDESC) {
		RENT_AMT_DESC = rENTAMTDESC;
	}

	public String getTOTAL_RENT_AMT_DESC() {
		return DataUtil.convert2ThaiBath(getTOTAL_RENT_AMT());
	}

	public void setTOTAL_RENT_AMT_DESC(String tOTALRENTAMTDESC) {
		TOTAL_RENT_AMT_DESC = tOTALRENTAMTDESC;
	}

	public String getS_RENT_PAY_PERIOD_TYPE_01() {
		if (StringUtils.isNotEmpty(RENT_PAY_PERIOD_TYPE)) {
			if (RENT_PAY_PERIOD_TYPE.equals("01")
					|| RENT_PAY_PERIOD_TYPE.equals("03")) {
				return "T";
			} 
		}
		return "F";
	}

	public void setS_RENT_PAY_PERIOD_TYPE_01(String sRENTPAYPERIODTYPE_01) {
		S_RENT_PAY_PERIOD_TYPE_01 = sRENTPAYPERIODTYPE_01;
	}

	public String getS_RENT_PAY_PERIOD_TYPE_02() {
		if (StringUtils.isNotEmpty(RENT_PAY_PERIOD_TYPE)) {
			if (RENT_PAY_PERIOD_TYPE.equals("02")
					|| RENT_PAY_PERIOD_TYPE.equals("04")) {
				return "T";
			} 
		}
		return "F";
	}

	public void setS_RENT_PAY_PERIOD_TYPE_02(String sRENTPAYPERIODTYPE_02) {
		S_RENT_PAY_PERIOD_TYPE_02 = sRENTPAYPERIODTYPE_02;
	}

	public String getRENT_PAY_PERIOD_DESC() {
		return DataUtil.convertDate2ThaiWord(getRENT_PAY_PERIOD());
	}

	public void setRENT_PAY_PERIOD_DESC(String rENTPAYPERIODDESC) {
		RENT_PAY_PERIOD_DESC = rENTPAYPERIODDESC;
	}

	public String getET_UNIT_PRICE_AMT_DESC() {
		return DataUtil.convert2ThaiBath(getET_UNIT_PRICE_AMT());
	}

	public void setET_UNIT_PRICE_AMT_DESC(String eTUNITPRICEAMTDESC) {
		ET_UNIT_PRICE_AMT_DESC = eTUNITPRICEAMTDESC;
	}

	public String getPROMISE_RENEW_PERIOD_DESC() {
		return DataUtil.convertDate2ThaiWord(getPROMISE_RENEW_PERIOD());
	}

	public void setPROMISE_RENEW_PERIOD_DESC(String pROMISERENEWPERIODDESC) {
		PROMISE_RENEW_PERIOD_DESC = pROMISERENEWPERIODDESC;
	}

	public void setS_ELECTIRC_TYPE_01(String sELECTIRCTYPE_01) {
		S_ELECTIRC_TYPE_01 = sELECTIRCTYPE_01;
	}

	public String getS_PROMISE_RENEW_TIME() {
		if (getPROMISE_RENEW_TIME() != null
				&& getPROMISE_RENEW_TIME().intValue() != 0) {
			return "T";
		} 
		return "F";
	}

	public void setS_PROMISE_RENEW_TIME(String sPROMISERENEWTIME) {
		S_PROMISE_RENEW_TIME = sPROMISERENEWTIME;
	}

	public void setTOTAL_SERVICE_AMT_DESC(String tOTALSERVICEAMTDESC) {
		TOTAL_SERVICE_AMT_DESC = tOTALSERVICEAMTDESC;
	}

	public String getRENT_DEPOSIT_AMT_DESC() {
		return DataUtil.convert2ThaiBath(RENT_DEPOSIT_AMT);
	}

	public void setRENT_DEPOSIT_AMT_DESC(String rENTDEPOSITAMTDESC) {
		RENT_DEPOSIT_AMT_DESC = rENTDEPOSITAMTDESC;
	}

	public String getMONTH_NUM() {
		StringBuilder sb = new StringBuilder();
		BigDecimal sum = new BigDecimal(0);
		
		if (StringUtils.isNotEmpty(RENT_PERIOD_TYPE) && "Y".equals(RENT_PERIOD_TYPE)) {
			if (AGE_YEAR != null && AGE_YEAR.intValue() != 0) {
				sb.append(" ");
				sb.append(AGE_YEAR);
				if(AGE_MONTH != null || AGE_DAY != null){
					sb.append(" ");
					sb.append(DataUtil.th_year);
				}
			}
			
			if (AGE_MONTH != null && AGE_MONTH.intValue() != 0) {
				sb.append(" ");
				sb.append(AGE_MONTH);
				sb.append(" ");
				sb.append(DataUtil.th_month);
			}
			
			if (AGE_DAY != null && AGE_DAY.intValue() != 0) {
				sb.append(" ");
				sb.append(AGE_DAY);
				sb.append(" ");
				sb.append(DataUtil.th_day);
			}
			
		} else if (StringUtils.isNotEmpty(RENT_PERIOD_TYPE) && "M".equals(RENT_PERIOD_TYPE)) {			
			if (AGE_DAY != null && AGE_DAY.intValue() != 0) {
				if (AGE_YEAR != null && AGE_YEAR.intValue() != 0) {
					sb.append(" ");
					sb.append(AGE_YEAR);
					sb.append(" ");
					sb.append(DataUtil.th_year);
				}
				
				if (AGE_MONTH != null && AGE_MONTH.intValue() != 0) {
					sb.append(" ");
					sb.append(AGE_MONTH);
					sb.append(" ");
					sb.append(DataUtil.th_month);
				}
				
				if (AGE_DAY != null && AGE_DAY.intValue() != 0) {
					sb.append(" ");
					sb.append(AGE_DAY);
					sb.append(" ");
					sb.append(DataUtil.th_day);
				}
				
			} else {		
				if (AGE_YEAR != null && AGE_YEAR.intValue() != 0) {
					sum = AGE_YEAR.multiply(new BigDecimal(12));
				}
				
				if (AGE_MONTH != null && AGE_MONTH.intValue() != 0) {
					sum = sum.add(AGE_MONTH);
				}
				
				sb.append(" ");
				sb.append(sum);
//				sb.append(" ");
//				sb.append(DataUtil.th_month);
			}
		}
		return sb.toString();
	}

	public void setMONTH_NUM(String mONTHNUM) {
		MONTH_NUM = mONTHNUM;
	}

	public BigDecimal getET_TAKE_ALL_AMT() {
		return ET_TAKE_ALL_AMT;
	}

	public void setET_TAKE_ALL_AMT(BigDecimal eTTAKEALLAMT) {
		ET_TAKE_ALL_AMT = eTTAKEALLAMT;
	}

	public String getET_TAKE_ALL_PERIOD_TYPE_NAME() {
		return ET_TAKE_ALL_PERIOD_TYPE_NAME;
	}

	public void setET_TAKE_ALL_PERIOD_TYPE_NAME(String eTTAKEALLPERIODTYPENAME) {
		ET_TAKE_ALL_PERIOD_TYPE_NAME = eTTAKEALLPERIODTYPENAME;
	}

	public String getET_TAKE_ALL_AMT_DESC() {
		return DataUtil.convert2ThaiBath(getET_TAKE_ALL_AMT());
	}

	public void setET_TAKE_ALL_AMT_DESC(String eTTAKEALLAMTDESC) {
		ET_TAKE_ALL_AMT_DESC = eTTAKEALLAMTDESC;
	}

	public String getRENT_COND_TYPE() {
		return RENT_COND_TYPE;
	}

	public void setRENT_COND_TYPE(String rENTCONDTYPE) {
		RENT_COND_TYPE = rENTCONDTYPE;
	}

	public String getRENT_DETAIL() {
		return RENT_DETAIL;
	}

	public void setRENT_DETAIL(String rENTDETAIL) {
		RENT_DETAIL = rENTDETAIL;
	}

	public String getCOMPANY_ADDR() {
		return COMPANY_ADDR;
	}

	public void setCOMPANY_ADDR(String cOMPANYADDR) {
		COMPANY_ADDR = cOMPANYADDR;
	}

	public String getCOMPANY_NAME() {
		return COMPANY_NAME;
	}

	public void setCOMPANY_NAME(String cOMPANYNAME) {
		COMPANY_NAME = cOMPANYNAME;
	}

	public BigDecimal getRENT_PAY_PERIOD_AMT() {
		return RENT_PAY_PERIOD_AMT;
	}

	public void setRENT_PAY_PERIOD_AMT(BigDecimal rENTPAYPERIODAMT) {
		RENT_PAY_PERIOD_AMT = rENTPAYPERIODAMT;
	}

	public String getSIGN_NAME() {
		return SIGN_NAME;
	}

	public void setSIGN_NAME(String sIGNNAME) {
		SIGN_NAME = sIGNNAME;
	}

	public String getRENT_PAY_PERIOD_AMT_DESC() {
		return DataUtil.convert2ThaiBath(getRENT_PAY_PERIOD_AMT());
	}

	public void setRENT_PAY_PERIOD_AMT_DESC(String rENTPAYPERIODAMTDESC) {
		RENT_PAY_PERIOD_AMT_DESC = rENTPAYPERIODAMTDESC;
	}

	public boolean isIS_PERSON() {
		return IS_PERSON;
	}

	public void setIS_PERSON(boolean iSPERSON) {
		IS_PERSON = iSPERSON;
	}

	public String getCOMPANY_HOUSE_NO() {
		return COMPANY_HOUSE_NO;
	}

	public void setCOMPANY_HOUSE_NO(String cOMPANYHOUSENO) {
		COMPANY_HOUSE_NO = cOMPANYHOUSENO;
	}

	public String getCOMPANY_STREET() {
		return COMPANY_STREET;
	}

	public void setCOMPANY_STREET(String cOMPANYSTREET) {
		COMPANY_STREET = cOMPANYSTREET;
	}

	public String getCOMPANY_TAMBON() {
		return COMPANY_TAMBON;
	}

	public void setCOMPANY_TAMBON(String cOMPANYTAMBON) {
		COMPANY_TAMBON = cOMPANYTAMBON;
	}

	public String getCOMPANY_AMPHUR() {
		return COMPANY_AMPHUR;
	}

	public void setCOMPANY_AMPHUR(String cOMPANYAMPHUR) {
		COMPANY_AMPHUR = cOMPANYAMPHUR;
	}

	public String getCOMPANY_PROVINCE() {
		return COMPANY_PROVINCE;
	}

	public void setCOMPANY_PROVINCE(String cOMPANYPROVINCE) {
		COMPANY_PROVINCE = cOMPANYPROVINCE;
	}

	public String getPLACE_TYPE() {
		return PLACE_TYPE;
	}

	public void setPLACE_TYPE(String pLACETYPE) {
		PLACE_TYPE = pLACETYPE;
	}

	public String getPERIOD_TYPE_PER() {
		return PERIOD_TYPE_PER;
	}

	public void setPERIOD_TYPE_PER(String pERIODTYPEPER) {
		PERIOD_TYPE_PER = pERIODTYPEPER;
	}

	public String getLESSOR_ADS_AMPHER() {
		return LESSOR_ADS_AMPHER;
	}

	public void setLESSOR_ADS_AMPHER(String lESSORADSAMPHER) {
		LESSOR_ADS_AMPHER = lESSORADSAMPHER;
	}

	public String getLESSOR_ADS_PROV() {
		return LESSOR_ADS_PROV;
	}

	public void setLESSOR_ADS_PROV(String lESSORADSPROV) {
		LESSOR_ADS_PROV = lESSORADSPROV;
	}

	public void setSERVICE_AMT_STR(String sERVICEAMTSTR) {
		SERVICE_AMT_STR = sERVICEAMTSTR;
	}

	public String getET_UNIT_PRICE_AMT_STR() {
		if (null==getET_UNIT_PRICE_AMT()||getET_UNIT_PRICE_AMT().equals("")){
			setET_UNIT_PRICE_AMT_STR("");
		}
		else setET_UNIT_PRICE_AMT_STR(SEMDataUtility.convertNumberToStringByFormat(getET_UNIT_PRICE_AMT(), "#,##0.00"));
		return ET_UNIT_PRICE_AMT_STR;
	}

	public void setET_UNIT_PRICE_AMT_STR(String eTUNITPRICEAMTSTR) {
		ET_UNIT_PRICE_AMT_STR = eTUNITPRICEAMTSTR;
	}

	public String getET_TAKE_ALL_AMT_STR() {
		if (null==getET_TAKE_ALL_AMT()||getET_TAKE_ALL_AMT().equals("")){
			setET_TAKE_ALL_AMT_STR("");
		}
		else setET_TAKE_ALL_AMT_STR(SEMDataUtility.convertNumberToStringByFormat(getET_TAKE_ALL_AMT(), "#,##0.00"));
		return ET_TAKE_ALL_AMT_STR;
	}

	public void setET_TAKE_ALL_AMT_STR(String eTTAKEALLAMTSTR) {
		ET_TAKE_ALL_AMT_STR = eTTAKEALLAMTSTR;
	}

	public void setMONTH_NUM_SERVICE(String mONTHNUMSERVICE) {
		MONTH_NUM_SERVICE = mONTHNUMSERVICE;
	}

	public String getGROUP_NO() {
		return GROUP_NO;
	}

	public void setGROUP_NO(String gROUPNO) {
		GROUP_NO = gROUPNO;
	}

	public String getWITNESS_1() {
		return WITNESS_1;
	}

	public void setWITNESS_1(String wITNESS_1) {
		WITNESS_1 = wITNESS_1;
	}

	public String getLESSER_NAME() {
		return LESSER_NAME;
	}

	public void setLESSER_NAME(String lESSERNAME) {
		LESSER_NAME = lESSERNAME;
	}

	public String getSERVICE_AMT_DESC() {
		return DataUtil.convert2ThaiBath(getSERVICE_AMT());
	}

	public void setSERVICE_AMT_DESC(String sERVICEAMTDESC) {
		SERVICE_AMT_DESC = sERVICEAMTDESC;
	}

	public BigDecimal getSERVICE_AMT() {
		return SERVICE_AMT;
	}

	public void setSERVICE_AMT(BigDecimal sERVICEAMT) {
		SERVICE_AMT = sERVICEAMT;
	}

	public String getREGION() {
		return REGION;
	}

	public void setREGION(String rEGION) {
		REGION = rEGION;
	}

	public String getSERVICE_AMT_STR() {
		if (null==getSERVICE_AMT()||getSERVICE_AMT().equals("")){
			setSERVICE_AMT_STR("");
		}
		else setSERVICE_AMT_STR(SEMDataUtility.convertNumberToStringByFormat(getSERVICE_AMT(), "#,##0.00"));
		return SERVICE_AMT_STR;
	}
	
}
