package th.co.ais.rpt.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import th.co.ais.rpt.util.DataUtil;
import th.co.ais.util.SEMDataUtility;

public class SEMECO001Domain extends ReportDomain {

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
	private String LESSOR_COMPANY;
	private String LESSOR_ADDR;
	private String TOT_BY_NAME;
	private String TOT_BY_POSITION1;
	private String TOT_BY_POSITION2;
	private String TOT_BY_POSITION3;
	private String TOT_SEND_FLAG;
	private String SITE_ADDR;
	private boolean IS_PERSON;
	
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
	private String RENT_PERIOD_TYPE_NAME;
	private BigDecimal RENT_AMT;
	private String RENT_AMT_STR;
	private String RENT_WHT_TYPE_DESC;
	private String RENT_WHT_FLAG;
	private BigDecimal RENT_WHT_RATE;
	private String RENT_AMT_X_TIME;
	private BigDecimal TOTAL_RENT_AMT;
	private String TOTAL_RENT_AMT_STR;

	private BigDecimal RENT_PAY_PERIOD;
	private String RENT_PAY_PERIOD_TYPE;
	private String RENT_PAY_PERIOD_TYPE_NAME;
	private String RENT_PAY_DUE_DESC;

	private String SERVICE_PERIOD_TYPE;
	private String SERVICE_PERIOD_TYPE_NAME;
	private BigDecimal SERVICE_AMT;
	private String SERVICE_WHT_TYPE_DESC;
	private String SERVICE_WHT_FLAG;
	private BigDecimal SERVICE_WHT_RATE;
	private String SERVICE_AMT_X_TIME;
	private String SERVICE_VAT_TYPE;
	private String SERVICE_VAT_TYPE_NAME;
	private BigDecimal TOTAL_SERVICE_AMT;
	private String TOTAL_SERVICE_AMT_STR;

	private BigDecimal SERVICE_PAY_PERIOD;
	private String SERVICE_PAY_PERIOD_TYPE;
	private String SERVICE_PAY_PERIOD_TYPE_NAME;
	private String SERVICE_PAY_DUE_DESC;

	private String RENT_DEPOSIT_FLAG;
	private BigDecimal RENT_DEPOSIT_AMT;
	private String RENT_DEPOSIT_AMT_STR;

	private String SERVICE_DEPOSIT_FLAG;
	private BigDecimal SERVICE_DEPOSIT_AMT;
	private String SERVICE_DEPOSIT_AMT_STR;

	private String ELETRIC_TYPE_1;
	private String ELETRIC_TYPE_2;
	private String ELETRIC_TYPE_3;
	private String ELETRIC_TYPE_4;
	private String ELETRIC_OWNER_TYPE;

	private BigDecimal ET_UNIT_PRICE_AMT;
	private String ET_VAT_TYPE_NAME;
	private BigDecimal ET_TAKE_ALL_AMT;
	private String ET_TAKE_ALL_PERIOD_TYPE_NAME = "";

	private BigDecimal PROMISE_RENEW_TIME;
	private BigDecimal PROMISE_RENEW_PERIOD;
	private String PROMISE_RENEW_PERIOD_TYPE;

	private String PROPERTY_TAX_PAY_TYPE;
	private String PLACE_TYPE;
	
	private String RENT_COND_TYPE;
	private String DEPOSIT_COND_TYPE_R;
	private String RENT_DETAIL;
	private String SERVICE_DETAIL;
     
	private String DEPOSIT_R_BG_DETAIL;
	private String DEPOSIT_R_CASH_DETAIL;
	
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
	
	private String AGE_YEAR_DESC;
	private String AGE_MONTH_DESC;
	private String AGE_DAY_DESC;
	
	//update by new 
	private String SERVICE_DEPOSIT_AMT_DESC;
	private String LOCATION_ID;
	private String WIFI_FLAG;
	
	//for pico report SEMECO001P SEMECO003P SEMECO004P
	private String SERVICE_FLAG;
	private String ELECTRIC_FLAG;
	private String ELECTRIC_INTRO_FLAG;
	private String INSURANCE_FLAG;
	private String RENT_FLAG;
	private String RENT_ELECTRIC_FLAG;
	private String RENT_ELECTRIC_INTRO_FLAG;
	private String RENT_INSURANCE_FLAG;
	private String RENT_SERVICE_NO;
	private String RENT_ELECTRIC_NO;
	private String RENT_INSURANCE_NO;
	private String HEADER_RENT_FLAG;
	private String SERVICE_NO;
	private String ELECTRIC_NO;
	private String INSURANCE_NO;
	private String HEADER_SERVICE_FLAG;
	private String FIX5_PERCENT_TXT;
	//added by NEW 10/03/2016
	private String ET_PAY_PERIOD_TYPE_NAME;
	
	private BigDecimal RENT_SMALL_CELL;
	private String RENT_SMALL_CELL_DESC;
	private BigDecimal TOTAL_RENT_SMALL_CELL;
	private String TOTAL_RENT_SMALL_CELL_DESC;
	private BigDecimal VAT_SMALL_CELL;
	private BigDecimal WHT_SMALL_CELL;
    private String PAY_PERIOD_SMALL_CELL;
    private String DOC_DT_STR;
	//
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
		if(RENT_AMT == null)
			RENT_AMT = new BigDecimal(0);
		return RENT_AMT;
	}

	public void setRENT_AMT(BigDecimal rENTAMT) {
		RENT_AMT = rENTAMT;
	}

	public String getRENT_AMT_STR() {
		if (null==getRENT_AMT()||getRENT_AMT().equals("")){
			setRENT_AMT_STR("");
		}
		String amtStr = getRENT_AMT().toString();
		if(amtStr.indexOf(".0")>0 || amtStr.indexOf(".")<0){
			setRENT_AMT_STR(SEMDataUtility.convertNumberToStringByFormat(getRENT_AMT(), "#,##0"));
		}else{
			setRENT_AMT_STR(SEMDataUtility.convertNumberToStringByFormat(getRENT_AMT(), "#,##0.00"));
		}
		return RENT_AMT_STR;
	}

	public void setRENT_AMT_STR(String rENTAMTSTR) {
		RENT_AMT_STR = rENTAMTSTR;
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

	public String getTOTAL_RENT_AMT_STR() {
		if (null==getTOTAL_RENT_AMT() || getTOTAL_RENT_AMT().equals("")){
			setTOTAL_RENT_AMT_STR("");
		}else{
			String amtStr = getTOTAL_RENT_AMT().toString();
			if(amtStr.indexOf(".0")>0 || amtStr.indexOf(".")<0){
				setTOTAL_RENT_AMT_STR(SEMDataUtility.convertNumberToStringByFormat(getTOTAL_RENT_AMT(), "#,##0"));
			}else{
				setTOTAL_RENT_AMT_STR(SEMDataUtility.convertNumberToStringByFormat(getTOTAL_RENT_AMT(), "#,##0.00"));
			}
		}
		
		return TOTAL_RENT_AMT_STR;
	}

	public void setTOTAL_RENT_AMT_STR(String tOTALRENTAMTSTR) {
		TOTAL_RENT_AMT_STR = tOTALRENTAMTSTR;
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

	public String getSERVICE_PERIOD_TYPE() {
		return DataUtil.convert2Abridgement(SERVICE_PERIOD_TYPE);
	}

	public void setSERVICE_PERIOD_TYPE(String sERVICEPERIODTYPE) {
		SERVICE_PERIOD_TYPE = sERVICEPERIODTYPE;
	}

	public BigDecimal getSERVICE_AMT() {
		if(SERVICE_AMT==null)
			SERVICE_AMT = new BigDecimal(0);
		return SERVICE_AMT;
	}

	public void setSERVICE_AMT(BigDecimal sERVICEAMT) {
		SERVICE_AMT = sERVICEAMT;
	}

	public String getSERVICE_WHT_TYPE_DESC() {
		return SERVICE_WHT_TYPE_DESC;
	}

	public void setSERVICE_WHT_TYPE_DESC(String sERVICEWHTTYPEDESC) {
		SERVICE_WHT_TYPE_DESC = sERVICEWHTTYPEDESC;
	}

	public BigDecimal getSERVICE_WHT_RATE() {
		if(SERVICE_WHT_RATE==null)
			SERVICE_WHT_RATE = new BigDecimal(0);
		return SERVICE_WHT_RATE;
	}

	public void setSERVICE_WHT_RATE(BigDecimal sERVICEWHTRATE) {
		SERVICE_WHT_RATE = sERVICEWHTRATE;
	}

	public String getSERVICE_AMT_X_TIME() {
		return SERVICE_AMT_X_TIME;
	}

	public void setSERVICE_AMT_X_TIME(String sERVICEAMTXTIME) {
		SERVICE_AMT_X_TIME = sERVICEAMTXTIME;
	}

	public String getSERVICE_VAT_TYPE() {
		return SERVICE_VAT_TYPE;
	}

	public void setSERVICE_VAT_TYPE(String sERVICEVATTYPE) {
		SERVICE_VAT_TYPE = sERVICEVATTYPE;
	}

	public String getSERVICE_VAT_TYPE_NAME() {
		return SERVICE_VAT_TYPE_NAME;
	}

	public void setSERVICE_VAT_TYPE_NAME(String sERVICEVATTYPENAME) {
		SERVICE_VAT_TYPE_NAME = sERVICEVATTYPENAME;
	}

	public BigDecimal getTOTAL_SERVICE_AMT() {
		return TOTAL_SERVICE_AMT;
	}

	public void setTOTAL_SERVICE_AMT(BigDecimal tOTALSERVICEAMT) {
		TOTAL_SERVICE_AMT = tOTALSERVICEAMT;
	}

	public String getTOTAL_SERVICE_AMT_STR() {
		if (null==getTOTAL_SERVICE_AMT()||getTOTAL_SERVICE_AMT().equals("")){
			setTOTAL_SERVICE_AMT_STR("");
		}else{
			String amtStr = getTOTAL_SERVICE_AMT().toString();
			if(amtStr.indexOf(".0")>0 || amtStr.indexOf(".")<0){
				setTOTAL_SERVICE_AMT_STR(SEMDataUtility.convertNumberToStringByFormat(getTOTAL_SERVICE_AMT(), "#,##0"));
			}else{
				setTOTAL_SERVICE_AMT_STR(SEMDataUtility.convertNumberToStringByFormat(getTOTAL_SERVICE_AMT(), "#,##0.00"));
			}
		}
		return TOTAL_SERVICE_AMT_STR;
	}

	public void setTOTAL_SERVICE_AMT_STR(String tOTALSERVICEAMTSTR) {
		TOTAL_SERVICE_AMT_STR = tOTALSERVICEAMTSTR;
	}

	public BigDecimal getSERVICE_PAY_PERIOD() {
		return SERVICE_PAY_PERIOD;
	}

	public void setSERVICE_PAY_PERIOD(BigDecimal sERVICEPAYPERIOD) {
		SERVICE_PAY_PERIOD = sERVICEPAYPERIOD;
	}

	public String getSERVICE_PAY_PERIOD_TYPE() {
		return DataUtil.convert2Abridgement(SERVICE_PAY_PERIOD_TYPE);
	}

	public void setSERVICE_PAY_PERIOD_TYPE(String sERVICEPAYPERIODTYPE) {
		SERVICE_PAY_PERIOD_TYPE = sERVICEPAYPERIODTYPE;
	}

	public String getSERVICE_PAY_PERIOD_TYPE_NAME() {
		return SERVICE_PAY_PERIOD_TYPE_NAME;
	}

	public void setSERVICE_PAY_PERIOD_TYPE_NAME(String sERVICEPAYPERIODTYPENAME) {
		SERVICE_PAY_PERIOD_TYPE_NAME = sERVICEPAYPERIODTYPENAME;
	}

	public String getSERVICE_PAY_DUE_DESC() {
		return SERVICE_PAY_DUE_DESC;
	}

	public void setSERVICE_PAY_DUE_DESC(String sERVICEPAYDUEDESC) {
		SERVICE_PAY_DUE_DESC = sERVICEPAYDUEDESC;
	}

	public String getRENT_DEPOSIT_FLAG() {
		return RENT_DEPOSIT_FLAG;
	}

	public void setRENT_DEPOSIT_FLAG(String rENTDEPOSITFLAG) {
		RENT_DEPOSIT_FLAG = rENTDEPOSITFLAG;
	}

	public BigDecimal getRENT_DEPOSIT_AMT() {
		if(RENT_DEPOSIT_AMT==null)
			RENT_DEPOSIT_AMT = new BigDecimal(0);
		return RENT_DEPOSIT_AMT;
	}

	public void setRENT_DEPOSIT_AMT(BigDecimal rENTDEPOSITAMT) {
		RENT_DEPOSIT_AMT = rENTDEPOSITAMT;
	}

	public String getRENT_DEPOSIT_AMT_STR() {
		if (null==getRENT_DEPOSIT_AMT()||getRENT_DEPOSIT_AMT().equals("")){
			setRENT_DEPOSIT_AMT_STR("");
		}
		String amtStr = getRENT_DEPOSIT_AMT().toString();
		if(amtStr.indexOf(".0")>0 || amtStr.indexOf(".")<0){
			setRENT_DEPOSIT_AMT_STR(SEMDataUtility.convertNumberToStringByFormat(getRENT_DEPOSIT_AMT(), "#,##0"));
		}else{
			setRENT_DEPOSIT_AMT_STR(SEMDataUtility.convertNumberToStringByFormat(getRENT_DEPOSIT_AMT(), "#,##0.00"));
		}
		return RENT_DEPOSIT_AMT_STR;
	}

	public void setRENT_DEPOSIT_AMT_STR(String rENTDEPOSITAMTSTR) {
		RENT_DEPOSIT_AMT_STR = rENTDEPOSITAMTSTR;
	}

	public String getSERVICE_DEPOSIT_FLAG() {
		return SERVICE_DEPOSIT_FLAG;
	}

	public void setSERVICE_DEPOSIT_FLAG(String sERVICEDEPOSITFLAG) {
		SERVICE_DEPOSIT_FLAG = sERVICEDEPOSITFLAG;
	}

	public BigDecimal getSERVICE_DEPOSIT_AMT() {
		if(SERVICE_DEPOSIT_AMT==null)
			SERVICE_DEPOSIT_AMT = new BigDecimal(0);
		return SERVICE_DEPOSIT_AMT;
	}

	public void setSERVICE_DEPOSIT_AMT(BigDecimal sERVICEDEPOSITAMT) {
		SERVICE_DEPOSIT_AMT = sERVICEDEPOSITAMT;
	}

	public String getSERVICE_DEPOSIT_AMT_STR() {
		if (null==getSERVICE_DEPOSIT_AMT()||getSERVICE_DEPOSIT_AMT().equals("")){
			setSERVICE_DEPOSIT_AMT_STR("");
		}else{
			String amtStr = getSERVICE_DEPOSIT_AMT().toString();
			if(amtStr.indexOf(".0")>0 || amtStr.indexOf(".")<0){
				setSERVICE_DEPOSIT_AMT_STR(SEMDataUtility.convertNumberToStringByFormat(getSERVICE_DEPOSIT_AMT(), "#,##0"));
			}else{
				setSERVICE_DEPOSIT_AMT_STR(SEMDataUtility.convertNumberToStringByFormat(getSERVICE_DEPOSIT_AMT(), "#,##0.00"));
			}
		}
		return SERVICE_DEPOSIT_AMT_STR;
	}

	public void setSERVICE_DEPOSIT_AMT_STR(String sERVICEDEPOSITAMTSTR) {
		SERVICE_DEPOSIT_AMT_STR = sERVICEDEPOSITAMTSTR;
	}

	public String getELETRIC_TYPE_1() {
		return ELETRIC_TYPE_1;
	}

	public void setELETRIC_TYPE_1(String eLETRICTYPE_1) {
		ELETRIC_TYPE_1 = eLETRICTYPE_1;
	}

	public String getELETRIC_TYPE_2() {
		return ELETRIC_TYPE_2;
	}

	public void setELETRIC_TYPE_2(String eLETRICTYPE_2) {
		ELETRIC_TYPE_2 = eLETRICTYPE_2;
	}

	public String getELETRIC_TYPE_3() {
		return ELETRIC_TYPE_3;
	}

	public void setELETRIC_TYPE_3(String eLETRICTYPE_3) {
		ELETRIC_TYPE_3 = eLETRICTYPE_3;
	}

	public String getELETRIC_TYPE_4() {
		return ELETRIC_TYPE_4;
	}

	public void setELETRIC_TYPE_4(String eLETRICTYPE_4) {
		ELETRIC_TYPE_4 = eLETRICTYPE_4;
	}

	public String getELETRIC_OWNER_TYPE() {
		return ELETRIC_OWNER_TYPE;
	}

	public void setELETRIC_OWNER_TYPE(String eLETRICOWNERTYPE) {
		ELETRIC_OWNER_TYPE = eLETRICOWNERTYPE;
	}

	public BigDecimal getET_UNIT_PRICE_AMT() {
		if(ET_UNIT_PRICE_AMT==null)
			ET_UNIT_PRICE_AMT = new BigDecimal(0);
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

	public String getPROPERTY_TAX_PAY_TYPE() {
		return PROPERTY_TAX_PAY_TYPE;
	}

	public void setPROPERTY_TAX_PAY_TYPE(String pROPERTYTAXPAYTYPE) {
		PROPERTY_TAX_PAY_TYPE = pROPERTYTAXPAYTYPE;
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

	public String getS_ELECTIRC_TYPE_01() {
		if (StringUtils.isNotEmpty(getELETRIC_TYPE_1()) && getELETRIC_TYPE_1().equals("Y")) {
			return "T";
		} else if (StringUtils.isNotEmpty(getELETRIC_TYPE_2()) && getELETRIC_TYPE_2().equals("Y")) {
			return "T";
		} else {
			return "F";
		}
//		return S_ELECTIRC_TYPE_01;
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

	public String getSERVICE_AMT_DESC() {
		return DataUtil.convert2ThaiBath(getSERVICE_AMT());
	}

	public void setSERVICE_AMT_DESC(String sERVICEAMTDESC) {
		SERVICE_AMT_DESC = sERVICEAMTDESC;
	}

	public String getTOTAL_SERVICE_AMT_DESC() {
		return DataUtil.convert2ThaiBath(getTOTAL_SERVICE_AMT());
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
		}else{
			sb.append("1");
		}
		return sb.toString();
	}

	public void setMONTH_NUM(String mONTHNUM) {
		MONTH_NUM = mONTHNUM;
	}

	public BigDecimal getET_TAKE_ALL_AMT() {
		if(ET_TAKE_ALL_AMT==null)
			ET_TAKE_ALL_AMT = new BigDecimal(0);
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

	public String getDEPOSIT_COND_TYPE_R() {
		return DEPOSIT_COND_TYPE_R;
	}

	public void setDEPOSIT_COND_TYPE_R(String dEPOSITCONDTYPER) {
		DEPOSIT_COND_TYPE_R = dEPOSITCONDTYPER;
	}

	public String getRENT_DETAIL() {
		return RENT_DETAIL;
	}

	public void setRENT_DETAIL(String rENTDETAIL) {
		RENT_DETAIL = rENTDETAIL;
	}

	public String getSERVICE_DETAIL() {
		return SERVICE_DETAIL;
	}

	public void setSERVICE_DETAIL(String sERVICEDETAIL) {
		SERVICE_DETAIL = sERVICEDETAIL;
	}

	public String getDEPOSIT_R_BG_DETAIL() {
		return DEPOSIT_R_BG_DETAIL;
	}

	public String getCOMPANY_ADDR() {
		return COMPANY_ADDR;
	}

	public void setCOMPANY_ADDR(String cOMPANYADDR) {
		COMPANY_ADDR = cOMPANYADDR;
	}

	public void setDEPOSIT_R_BG_DETAIL(String dEPOSITRBGDETAIL) {
		DEPOSIT_R_BG_DETAIL = dEPOSITRBGDETAIL;
	}

	public String getDEPOSIT_R_CASH_DETAIL() {
		return DEPOSIT_R_CASH_DETAIL;
	}

	public void setDEPOSIT_R_CASH_DETAIL(String dEPOSITRCASHDETAIL) {
		DEPOSIT_R_CASH_DETAIL = dEPOSITRCASHDETAIL;
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

	public String getSERVICE_AMT_STR() {
		if (null==getSERVICE_AMT()||getSERVICE_AMT().equals("")){
			setSERVICE_AMT_STR("");
		}else{
			String amtStr = getSERVICE_AMT().toString();
			if(amtStr.indexOf(".0")>0 || amtStr.indexOf(".")<0){
				setSERVICE_AMT_STR(SEMDataUtility.convertNumberToStringByFormat(getSERVICE_AMT(), "#,##0"));
			}else{
				setSERVICE_AMT_STR(SEMDataUtility.convertNumberToStringByFormat(getSERVICE_AMT(), "#,##0.00"));
			}
		}
//		else setSERVICE_AMT_STR(SEMDataUtility.convertNumberToStringByFormat(getSERVICE_AMT(), "#,##0.00"));
		return SERVICE_AMT_STR;
	}

	public void setSERVICE_AMT_STR(String sERVICEAMTSTR) {
		SERVICE_AMT_STR = sERVICEAMTSTR;
	}

	public String getET_UNIT_PRICE_AMT_STR() {
		if (null==getET_UNIT_PRICE_AMT()||getET_UNIT_PRICE_AMT().equals("")){
			setET_UNIT_PRICE_AMT_STR("");
		}
		else {
			String amtStr = getET_UNIT_PRICE_AMT().toString();
			if(amtStr.indexOf(".0")>0 || amtStr.indexOf(".")<0){
				setET_UNIT_PRICE_AMT_STR(SEMDataUtility.convertNumberToStringByFormat(getET_UNIT_PRICE_AMT(), "#,##0"));
			}else{
				setET_UNIT_PRICE_AMT_STR(SEMDataUtility.convertNumberToStringByFormat(getET_UNIT_PRICE_AMT(), "#,##0.00"));
			}
		}
		return ET_UNIT_PRICE_AMT_STR;
	}

	public void setET_UNIT_PRICE_AMT_STR(String eTUNITPRICEAMTSTR) {
		ET_UNIT_PRICE_AMT_STR = eTUNITPRICEAMTSTR;
	}

	public String getET_TAKE_ALL_AMT_STR() {
		if (null==getET_TAKE_ALL_AMT()||getET_TAKE_ALL_AMT().equals("")){
			setET_TAKE_ALL_AMT_STR("");
		}
		String amtStr = getET_TAKE_ALL_AMT().toString();
		if(amtStr.indexOf(".0")>0 || amtStr.indexOf(".")<0){
			setET_TAKE_ALL_AMT_STR(SEMDataUtility.convertNumberToStringByFormat(getET_TAKE_ALL_AMT(), "#,##0"));
		}else{
			setET_TAKE_ALL_AMT_STR(SEMDataUtility.convertNumberToStringByFormat(getET_TAKE_ALL_AMT(), "#,##0.00"));
		}
//		else setET_TAKE_ALL_AMT_STR(SEMDataUtility.convertNumberToStringByFormat(getET_TAKE_ALL_AMT(), "#,##0.00"));
		return ET_TAKE_ALL_AMT_STR;
	}

	public void setET_TAKE_ALL_AMT_STR(String eTTAKEALLAMTSTR) {
		ET_TAKE_ALL_AMT_STR = eTTAKEALLAMTSTR;
	}

	public String getMONTH_NUM_SERVICE() {
		StringBuilder stb = new StringBuilder();
		BigDecimal sum = new BigDecimal(0);
		
		if (StringUtils.isNotEmpty(SERVICE_PERIOD_TYPE) && "Y".equals(SERVICE_PERIOD_TYPE)) {
			if (AGE_YEAR != null && AGE_YEAR.intValue() != 0) {
				stb.append(" ");
				stb.append(AGE_YEAR);
				if(AGE_MONTH != null || AGE_DAY != null){
					stb.append(" ");
					stb.append(DataUtil.th_year);
				}
			}
			
			if (AGE_MONTH != null && AGE_MONTH.intValue() != 0) {
				stb.append(" ");
				stb.append(AGE_MONTH);
				stb.append(" ");
				stb.append(DataUtil.th_month);
			}
			
			if (AGE_DAY != null && AGE_DAY.intValue() != 0) {
				stb.append(" ");
				stb.append(AGE_DAY);
				stb.append(" ");
				stb.append(DataUtil.th_day);
			}
			
		} else if (StringUtils.isNotEmpty(SERVICE_PERIOD_TYPE) && "M".equals(SERVICE_PERIOD_TYPE)) {			
			if (AGE_DAY != null && AGE_DAY.intValue() != 0) {
				if (AGE_YEAR != null && AGE_YEAR.intValue() != 0) {
					stb.append(" ");
					stb.append(AGE_YEAR);
					stb.append(" ");
					stb.append(DataUtil.th_year);
				}
				
				if (AGE_MONTH != null && AGE_MONTH.intValue() != 0) {
					stb.append(" ");
					stb.append(AGE_MONTH);
					stb.append(" ");
					stb.append(DataUtil.th_month);
				}
				
				if (AGE_DAY != null && AGE_DAY.intValue() != 0) {
					stb.append(" ");
					stb.append(AGE_DAY);
					stb.append(" ");
					stb.append(DataUtil.th_day);
				}
				
			} else {		
				if (AGE_YEAR != null && AGE_YEAR.intValue() != 0) {
					sum = AGE_YEAR.multiply(new BigDecimal(12));
				}
				
				if (AGE_MONTH != null && AGE_MONTH.intValue() != 0) {
					sum = sum.add(AGE_MONTH);
				}
				
				stb.append(" ");
				stb.append(sum);
//				sb.append(" ");
//				sb.append(DataUtil.th_month);
			}
		}else{
			stb.append("1");
		}
		return stb.toString();
	
	}

	public void setMONTH_NUM_SERVICE(String mONTHNUMSERVICE) {
		MONTH_NUM_SERVICE = mONTHNUMSERVICE;
	}

	public String getAGE_YEAR_DESC() {
		return DataUtil.convert2ThaiLanguage(getAGE_YEAR());
	}

	public void setAGE_YEAR_DESC(String aGEYEARDESC) {
		AGE_YEAR_DESC = aGEYEARDESC;
	}

	public String getAGE_MONTH_DESC() {
		return DataUtil.convert2ThaiLanguage(getAGE_MONTH());
	}

	public void setAGE_MONTH_DESC(String aGEMONTHDESC) {
		AGE_MONTH_DESC = aGEMONTHDESC;
	}

	public String getAGE_DAY_DESC() {
		return DataUtil.convert2ThaiLanguage(getAGE_DAY());
	}

	public void setAGE_DAY_DESC(String aGEDAYDESC) {
		AGE_DAY_DESC = aGEDAYDESC;
	}

	public String getSERVICE_DEPOSIT_AMT_DESC() {
		return DataUtil.convert2ThaiBath(getSERVICE_DEPOSIT_AMT());
	}

	public void setSERVICE_DEPOSIT_AMT_DESC(String sERVICEDEPOSITAMTDESC) {
		SERVICE_DEPOSIT_AMT_DESC = sERVICEDEPOSITAMTDESC;
	}

	public String getLOCATION_ID(){
		return LOCATION_ID;
	}

	public void setLOCATION_ID(String lOCATIONID){
		this.LOCATION_ID = lOCATIONID;
	}

	public String getSERVICE_FLAG() {
		SERVICE_FLAG = "Y";
		if(getET_TAKE_ALL_AMT().toString().equals("0") && 
				getET_UNIT_PRICE_AMT().toString().equals("0") && getSERVICE_DEPOSIT_AMT().toString().equals("0")){
				SERVICE_FLAG = "N";
		}
		
		return SERVICE_FLAG;
	}

	public void setSERVICE_FLAG(String sERVICEFLAG) {
		SERVICE_FLAG = sERVICEFLAG;
	}

	public String getELECTRIC_FLAG() {
		ELECTRIC_FLAG = "Y";
		if(getSERVICE_AMT().toString().equals("0") && getSERVICE_DEPOSIT_AMT().toString().equals("0")){
			ELECTRIC_FLAG = "N";
		}
		return ELECTRIC_FLAG;
	}

	public void setELECTRIC_FLAG(String eLECTRICFLAG) {
		ELECTRIC_FLAG = eLECTRICFLAG;
	}

	public String getELECTRIC_INTRO_FLAG() {
		ELECTRIC_INTRO_FLAG = "Y";
		if(!getSERVICE_AMT().toString().equals("0") || !getSERVICE_DEPOSIT_AMT().toString().equals("0")){
			ELECTRIC_INTRO_FLAG = "N";
		}
		
		if(getSERVICE_AMT().toString().equals("0") && 
				getET_TAKE_ALL_AMT().toString().equals("0") && getET_UNIT_PRICE_AMT().toString().equals("0") &&
				getSERVICE_DEPOSIT_AMT().toString().equals("0")){
			ELECTRIC_INTRO_FLAG = "N";
		}
		return ELECTRIC_INTRO_FLAG;
	}

	public void setELECTRIC_INTRO_FLAG(String eLECTRICINTROFLAG) {
		ELECTRIC_INTRO_FLAG = eLECTRICINTROFLAG;
	}

	public String getINSURANCE_FLAG() {
		INSURANCE_FLAG = "Y";
		if(getSERVICE_AMT().toString().equals("0") &&
				getET_TAKE_ALL_AMT().toString().equals("0") && getET_UNIT_PRICE_AMT().toString().equals("0")){
			INSURANCE_FLAG = "N";
		}
		return INSURANCE_FLAG;
	}

	public void setINSURANCE_FLAG(String iNSURANCEFLAG) {
		INSURANCE_FLAG = iNSURANCEFLAG;
	}

	public String getRENT_ELECTRIC_FLAG() {
		RENT_ELECTRIC_FLAG = "Y";
		if(getRENT_AMT().toString().equals("0") && getRENT_DEPOSIT_AMT().toString().equals("0")){
			RENT_ELECTRIC_FLAG = "N";
		}
		return RENT_ELECTRIC_FLAG;
	}

	public void setRENT_ELECTRIC_FLAG(String rENTELECTRICFLAG) {
		RENT_ELECTRIC_FLAG = rENTELECTRICFLAG;
	}

	public String getRENT_ELECTRIC_INTRO_FLAG() {
		RENT_ELECTRIC_INTRO_FLAG = "Y";
		if(!getRENT_AMT().toString().equals("0") || !getRENT_DEPOSIT_AMT().toString().equals("0")){
			RENT_ELECTRIC_INTRO_FLAG = "N";
		}
		
		if(getRENT_AMT().toString().equals("0") && 
				getET_TAKE_ALL_AMT().toString().equals("0") && getET_UNIT_PRICE_AMT().toString().equals("0") &&
				getRENT_DEPOSIT_AMT().toString().equals("0")){
			RENT_ELECTRIC_INTRO_FLAG = "N";
		}
		return RENT_ELECTRIC_INTRO_FLAG;
	}

	public void setRENT_ELECTRIC_INTRO_FLAG(String rENTELECTRICINTROFLAG) {
		RENT_ELECTRIC_INTRO_FLAG = rENTELECTRICINTROFLAG;
	}

	public String getRENT_INSURANCE_FLAG() {
		RENT_INSURANCE_FLAG = "Y";
		if(getRENT_AMT().toString().equals("0") &&
				getET_TAKE_ALL_AMT().toString().equals("0") && getET_UNIT_PRICE_AMT().toString().equals("0")){
			RENT_INSURANCE_FLAG = "N";
		}
		return RENT_INSURANCE_FLAG;
	}

	public void setRENT_INSURANCE_FLAG(String rENTINSURANCEFLAG) {
		RENT_INSURANCE_FLAG = rENTINSURANCEFLAG;
	}

	public String getRENT_SERVICE_NO() {
		return RENT_SERVICE_NO;
	}

	public void setRENT_SERVICE_NO(String rENTSERVICENO) {
		RENT_SERVICE_NO = rENTSERVICENO;
	}

	public String getSERVICE_NO() {
		return SERVICE_NO;
	}

	public void setSERVICE_NO(String sERVICENO) {
		SERVICE_NO = sERVICENO;
	}

	public String getELECTRIC_NO() {
		ELECTRIC_NO = "4.2";
		if(getSERVICE_AMT().toString().equals("0")){
			ELECTRIC_NO = "4.1";
		}
		return ELECTRIC_NO;
	}

	public void setELECTRIC_NO(String eLECTRICNO) {
		ELECTRIC_NO = eLECTRICNO;
	}

	public String getINSURANCE_NO() {
		INSURANCE_NO = "4.3";
		if(getSERVICE_AMT().toString().equals("0") ||
				getET_TAKE_ALL_AMT().toString().equals("0") && getET_UNIT_PRICE_AMT().toString().equals("0")){
			INSURANCE_NO = "4.2";
		}
		return INSURANCE_NO;
	}

	public void setINSURANCE_NO(String iNSURANCENO) {
		INSURANCE_NO = iNSURANCENO;
	}

	public String getRENT_ELECTRIC_NO() {
		RENT_ELECTRIC_NO = "4.2";
		if(getRENT_AMT().toString().equals("0")){
			RENT_ELECTRIC_NO = "4.1";
		}
		return RENT_ELECTRIC_NO;
	}

	public void setRENT_ELECTRIC_NO(String rENTELECTRICNO) {
		RENT_ELECTRIC_NO = rENTELECTRICNO;
	}

	public String getRENT_INSURANCE_NO() {
		RENT_INSURANCE_NO = "4.3";
		if(getRENT_AMT().toString().equals("0") ||
				getET_TAKE_ALL_AMT().toString().equals("0") && getET_UNIT_PRICE_AMT().toString().equals("0")){
			RENT_INSURANCE_NO = "4.2";
		}
		return RENT_INSURANCE_NO;
	}

	public void setRENT_INSURANCE_NO(String rENTINSURANCENO) {
		RENT_INSURANCE_NO = rENTINSURANCENO;
	}

	public String getWIFI_FLAG() {
		return WIFI_FLAG;
	}

	public void setWIFI_FLAG(String wIFIFLAG) {
		WIFI_FLAG = wIFIFLAG;
	}

	public String getHEADER_SERVICE_FLAG() {
		HEADER_SERVICE_FLAG = "00";
		if(!getSERVICE_AMT().toString().equals("0")){
			HEADER_SERVICE_FLAG = "01";
		}
		
		if(getSERVICE_AMT().toString().equals("0")){
			if(!getET_TAKE_ALL_AMT().toString().equals("0") || !getET_UNIT_PRICE_AMT().toString().equals("0")){
				HEADER_SERVICE_FLAG = "02";
			}else{
				if(!getRENT_DEPOSIT_AMT().toString().equals("0")){
					HEADER_SERVICE_FLAG = "03";
				}
			}
		}
		
		return HEADER_SERVICE_FLAG;
	}

	public void setHEADER_SERVICE_FLAG(String hEADERFLAG) {
		HEADER_SERVICE_FLAG = hEADERFLAG;
	}

	public String getRENT_FLAG() {
		RENT_FLAG = "Y";
//		System.out.print("getET_TAKE_ALL_AMT : "+getET_TAKE_ALL_AMT());
//		System.out.print("getET_UNIT_PRICE_AMT : "+getET_UNIT_PRICE_AMT());
//		System.out.print("getRENT_DEPOSIT_AMT : "+getRENT_DEPOSIT_AMT());
		if(getET_TAKE_ALL_AMT().toString().equals("0") && 
				getET_UNIT_PRICE_AMT().toString().equals("0") && getRENT_DEPOSIT_AMT().toString().equals("0")){
			RENT_FLAG = "N";
		}
		return RENT_FLAG;
	}

	public void setRENT_FLAG(String rENTFLAG) {
		RENT_FLAG = rENTFLAG;
	}

	public String getHEADER_RENT_FLAG() {
		HEADER_RENT_FLAG = "00";
		if(!getRENT_AMT().toString().equals("0")){
			HEADER_RENT_FLAG = "01";
		}
		BigDecimal t = getRENT_AMT();
//		System.out.print("getRENT_AMT : "+getRENT_AMT());
		
		if(getRENT_AMT().toString().equals("0")){
			if(!getET_TAKE_ALL_AMT().toString().equals("0") || !getET_UNIT_PRICE_AMT().toString().equals("0")){
				HEADER_RENT_FLAG = "02";
			}else{
				if(!getRENT_DEPOSIT_AMT().toString().equals("0")){
					HEADER_RENT_FLAG = "03";
				}
			}
		}
		
		
		return HEADER_RENT_FLAG;
	}

	public void setHEADER_RENT_FLAG(String hEADERRENTFLAG) {
		HEADER_RENT_FLAG = hEADERRENTFLAG;
	}

	public String getLESSOR_COMPANY() {
		return LESSOR_COMPANY;
	}

	public void setLESSOR_COMPANY(String lESSORCOMPANY) {
		LESSOR_COMPANY = lESSORCOMPANY;
	}

	public String getRENT_WHT_FLAG() {
		return RENT_WHT_FLAG;
	}

	public void setRENT_WHT_FLAG(String rENTWHTFLAG) {
		RENT_WHT_FLAG = rENTWHTFLAG;
	}

	public String getSERVICE_WHT_FLAG() {
		return SERVICE_WHT_FLAG;
	}

	public void setSERVICE_WHT_FLAG(String sERVICEWHTFLAG) {
		SERVICE_WHT_FLAG = sERVICEWHTFLAG;
	}

	public String getFIX5_PERCENT_TXT() {
		return FIX5_PERCENT_TXT;
	}

	public void setFIX5_PERCENT_TXT(String fIX5PERCENTTXT) {
		FIX5_PERCENT_TXT = fIX5PERCENTTXT;
	}

	public String getET_PAY_PERIOD_TYPE_NAME() {
		return ET_PAY_PERIOD_TYPE_NAME;
	}

	public void setET_PAY_PERIOD_TYPE_NAME(String eTPAYPERIODTYPENAME) {
		ET_PAY_PERIOD_TYPE_NAME = eTPAYPERIODTYPENAME;
	}

	public BigDecimal getRENT_SMALL_CELL() {
		return RENT_SMALL_CELL;
	}

	public void setRENT_SMALL_CELL(BigDecimal rENTSMALLCELL) {
		RENT_SMALL_CELL = rENTSMALLCELL;
	}

	public BigDecimal getTOTAL_RENT_SMALL_CELL() {
		return TOTAL_RENT_SMALL_CELL;
	}

	public void setTOTAL_RENT_SMALL_CELL(BigDecimal tOTALRENTSMALLCELL) {
		TOTAL_RENT_SMALL_CELL = tOTALRENTSMALLCELL;
	}

	public BigDecimal getVAT_SMALL_CELL() {
		return VAT_SMALL_CELL;
	}

	public void setVAT_SMALL_CELL(BigDecimal vATSMALLCELL) {
		VAT_SMALL_CELL = vATSMALLCELL;
	}

	public BigDecimal getWHT_SMALL_CELL() {
		return WHT_SMALL_CELL;
	}

	public void setWHT_SMALL_CELL(BigDecimal wHTSMALLCELL) {
		WHT_SMALL_CELL = wHTSMALLCELL;
	}

	public String getPAY_PERIOD_SMALL_CELL() {
		return PAY_PERIOD_SMALL_CELL;
	}

	public void setPAY_PERIOD_SMALL_CELL(String pAYPERIODSMALLCELL) {
		PAY_PERIOD_SMALL_CELL = pAYPERIODSMALLCELL;
	}

	public String getRENT_SMALL_CELL_DESC() {
		return DataUtil.convert2ThaiBath(getRENT_SMALL_CELL());
	}

	public void setRENT_SMALL_CELL_DESC(String rENTSMALLCELLDESC) {
		RENT_SMALL_CELL_DESC = rENTSMALLCELLDESC;
	}

	public String getTOTAL_RENT_SMALL_CELL_DESC() {
		return DataUtil.convert2ThaiBath(getTOTAL_RENT_SMALL_CELL());
	}

	public void setTOTAL_RENT_SMALL_CELL_DESC(String tOTALRENTSMALLCELLDESC) {
		TOTAL_RENT_SMALL_CELL_DESC = tOTALRENTSMALLCELLDESC;
	}

	public String getRENT_PERIOD_TYPE_NAME() {
		return RENT_PERIOD_TYPE_NAME;
	}

	public void setRENT_PERIOD_TYPE_NAME(String rENTPERIODTYPENAME) {
		RENT_PERIOD_TYPE_NAME = rENTPERIODTYPENAME;
	}

	public String getSERVICE_PERIOD_TYPE_NAME() {
		return SERVICE_PERIOD_TYPE_NAME;
	}

	public void setSERVICE_PERIOD_TYPE_NAME(String sERVICEPERIODTYPENAME) {
		SERVICE_PERIOD_TYPE_NAME = sERVICEPERIODTYPENAME;
	}

	public String getDOC_DT_STR() {
		return DOC_DT_STR;
	}

	public void setDOC_DT_STR(String dOCDTSTR) {
		DOC_DT_STR = dOCDTSTR;
	}
	
}
