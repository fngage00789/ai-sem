package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;

public class SEMRSI004ReportParameter extends ReportParameter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9146442097844954754L;
	private String p_header_name;
	private String p_company;
	private String p_year;
	private String p_month_from;
	private String p_month_to;
	private String p_year_display;
	private String p_month_from_display;
	private String p_month_to_display;
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
	
	public String getP_month_from() {
		return p_month_from;
	}

	public void setP_month_from(String pMonthFrom) {
		p_month_from = pMonthFrom;
	}

	public String getP_month_to() {
		return p_month_to;
	}

	public void setP_month_to(String pMonthTo) {
		p_month_to = pMonthTo;
	}
	
	

	public String getP_year_display() {
		return p_year_display;
	}

	public void setP_year_display(String pYearDisplay) {
		p_year_display = pYearDisplay;
	}

	
	public String getP_month_from_display() {
		return p_month_from_display;
	}

	public void setP_month_from_display(String pMonthFromDisplay) {
		p_month_from_display = pMonthFromDisplay;
	}

	public String getP_month_to_display() {
		return p_month_to_display;
	}

	public void setP_month_to_display(String pMonthToDisplay) {
		p_month_to_display = pMonthToDisplay;
	}
	

	public String getP_username() {
		return p_username;
	}

	public void setP_username(String pUsername) {
		p_username = pUsername;
	}

	@Override
	public Map getReportParameter() {
		parameters = new HashMap();
		parameters.put("PARAM_REPORT_ENGINE", reportEngine);
		parameters.put("PARAM_HEADER_NAME", p_header_name);
		parameters.put("PARAM_COMPANY", p_company);
		parameters.put("PARAM_YEAR", p_year);
		parameters.put("PARAM_YEAR_DISPLAY", p_year_display);
		parameters.put("PARAM_MONTH_FROM", p_month_from);
		parameters.put("PARAM_MONTH_FROM_DISPLAY", p_month_from_display);
		parameters.put("PARAM_MONTH_TO", p_month_to);
		parameters.put("PARAM_MONTH_TO_DISPLAY", p_month_to_display);
		parameters.put("PARAM_USERNAME", p_username);
		return parameters;
	}

}
