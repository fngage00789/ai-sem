package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;

public class SEMRSI013ReportParameter extends ReportParameter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9146442097844954754L;
	private String p_header_name;
	private String p_company;
	private String p_year;
	private String p_year_display;
	private String p_region_code;
	private String p_month;
	private String p_month_display;
	private String p_username;
	private String p_site_type;
	private String p_display_site_type;

	public String getP_display_site_type() {
		return p_display_site_type;
	}

	public void setP_display_site_type(String pDisplaySiteType) {
		p_display_site_type = pDisplaySiteType;
	}

	public String getP_site_type() {
		return p_site_type;
	}

	public void setP_site_type(String pSiteType) {
		p_site_type = pSiteType;
	}

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

	public String getP_year_display() {
		return p_year_display;
	}
	
	public String getP_username() {
		return p_username;
	}

	public void setP_username(String pUsername) {
		p_username = pUsername;
	}

	public void setP_year_display(String pYearDisplay) {
		p_year_display = pYearDisplay;
	}

	public String getP_region_code() {
		return p_region_code;
	}

	public void setP_region_code(String pRegionCode) {
		p_region_code = pRegionCode;
	}

	public String getP_month() {
		return p_month;
	}

	public void setP_month(String pMonth) {
		p_month = pMonth;
	}

	public String getP_month_display() {
		return p_month_display;
	}

	public void setP_month_display(String pMonthDisplay) {
		p_month_display = pMonthDisplay;
	}

	@Override
	public Map getReportParameter() {
		parameters = new HashMap();
		parameters.put("PARAM_REPORT_ENGINE", reportEngine);
		parameters.put("PARAM_HEADER_NAME", p_header_name);
		parameters.put("PARAM_COMPANY", p_company);
		parameters.put("PARAM_YEAR", p_year);
		parameters.put("PARAM_DISPLAY_YEAR", p_year_display);
		parameters.put("PARAM_DISPLAY_SITE_TYPE", p_display_site_type);
		parameters.put("PARAM_REGION_CODE", p_region_code);
		parameters.put("PARAM_MONTH", p_month);
		parameters.put("PARAM_SITE_TYPE", p_site_type);
		parameters.put("PARAM_DISPLAY_MONTH", p_month_display);
		parameters.put("PARAM_USERNAME", p_username);
		return parameters;
	}

}
