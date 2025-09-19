package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;

public class SEMRRT017ReportParameter extends ReportParameter{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 865475240158161628L;
	private String p_header_name;
	private String p_company;
	private String p_year;
	private String p_month;
	private String p_region;
	private String p_display_month;
	private String p_display_year;
	private String p_col1_month;
	private String p_col2_month;
	private String p_col3_month;
	private String p_col4_month;
	private String p_col5_month;
	private String p_username;
	
	public String getP_header_name() {
		return p_header_name;
	}


	public void setP_header_name(String pHeaderName) {
		p_header_name = pHeaderName;
	}


	public String getP_company() {
		return p_company;
	}


	public void setP_company(String pCompany) {
		p_company = pCompany;
	}


	public String getP_year() {
		return p_year;
	}


	public void setP_year(String pYear) {
		p_year = pYear;
	}


	public String getP_month() {
		return p_month;
	}


	public void setP_month(String pMonth) {
		p_month = pMonth;
	}


	public String getP_region() {
		return p_region;
	}


	public void setP_region(String pRegion) {
		p_region = pRegion;
	}

	
	public String getP_display_month() {
		return p_display_month;
	}


	public void setP_display_month(String pDisplayMonth) {
		p_display_month = pDisplayMonth;
	}


	public String getP_display_year() {
		return p_display_year;
	}


	public void setP_display_year(String pDisplayYear) {
		p_display_year = pDisplayYear;
	}


	public String getP_col1_month() {
		return p_col1_month;
	}


	public void setP_col1_month(String pCol1Month) {
		p_col1_month = pCol1Month;
	}


	public String getP_col2_month() {
		return p_col2_month;
	}


	public void setP_col2_month(String pCol2Month) {
		p_col2_month = pCol2Month;
	}


	public String getP_col3_month() {
		return p_col3_month;
	}


	public void setP_col3_month(String pCol3Month) {
		p_col3_month = pCol3Month;
	}


	public String getP_col4_month() {
		return p_col4_month;
	}


	public void setP_col4_month(String pCol4Month) {
		p_col4_month = pCol4Month;
	}

	public String getP_col5_month() {
		return p_col5_month;
	}


	public void setP_col5_month(String pCol5Month) {
		p_col5_month = pCol5Month;
	}
	
	

	public String getP_username() {
		return p_username;
	}


	public void setP_username(String pUsername) {
		p_username = pUsername;
	}


	@SuppressWarnings("unchecked")
	@Override
	public Map getReportParameter() {
		parameters = new HashMap();
		parameters.put("PARAM_REPORT_ENGINE", reportEngine);
		parameters.put("PARAM_HEADER_NAME", p_header_name);
		parameters.put("PARAM_COMPANY", p_company);
		parameters.put("PARAM_MONTH", p_month);
		parameters.put("PARAM_YEAR", p_year);
		parameters.put("PARAM_REGION", p_region); 
		parameters.put("PARAM_DISPLAY_MONTH", p_display_month);
		parameters.put("PARAM_DISPLAY_YEAR", p_display_year); 
		parameters.put("PARAM_COL1_MONTH", p_col1_month); 
		parameters.put("PARAM_COL2_MONTH", p_col2_month); 
		parameters.put("PARAM_COL3_MONTH", p_col3_month); 
		parameters.put("PARAM_COL4_MONTH", p_col4_month); 
		parameters.put("PARAM_COL5_MONTH", p_col5_month); 
		parameters.put("PARAM_USERNAME", p_username); 
		return parameters;
	}

}
