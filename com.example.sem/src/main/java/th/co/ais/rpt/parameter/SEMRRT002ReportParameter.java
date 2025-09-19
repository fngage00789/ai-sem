package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;

public class SEMRRT002ReportParameter extends ReportParameter{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4716931509620197569L;
	//Criteria For Jsp Input Parameters
	private String p_header_name;
	private String p_company;
	private String p_region;
	private String p_month_year;
	private String p_station_type;
	private String p_display_station_type;
	private String p_pico;
	private String p_username;
	private String p_display_month_year;
	
	public String getP_company() {
		return p_company;
	}

	public void setP_company(String pCompany) {
		p_company = pCompany;
	}


	public String getP_month_year() {
		return p_month_year;
	}

	public void setP_month_year(String pMonthYear) {
		p_month_year = pMonthYear;
	}

	public String getP_pico() {
		return p_pico;
	}

	public void setP_pico(String pPico) {
		p_pico = pPico;
	}

	public String getP_region() {
		return p_region;
	}

	public void setP_region(String pRegion) {
		p_region = pRegion;
	}

	public String getP_station_type() {
		return p_station_type;
	}

	public void setP_station_type(String pStationType) {
		p_station_type = pStationType;
	}

	public String getP_header_name() {
		return p_header_name;
	}

	public void setP_header_name(String pHeaderName) {
		p_header_name = pHeaderName;
	}
	

	public String getP_display_station_type() {
		return p_display_station_type;
	}

	public void setP_display_station_type(String pDisplayStationType) {
		p_display_station_type = pDisplayStationType;
	}

	public String getP_username() {
		return p_username;
	}

	public void setP_username(String pUsername) {
		p_username = pUsername;
	}
	
	public String getP_display_month_year() {
		return p_display_month_year;
	}

	public void setP_display_month_year(String pDisplayMonthYear) {
		p_display_month_year = pDisplayMonthYear;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map getReportParameter() {
		parameters = new HashMap();
		parameters.put("PARAM_REPORT_ENGINE", reportEngine);
		parameters.put("PARAM_HEADER_NAME", p_header_name);
		parameters.put("PARAM_COMPANY", p_company);
		parameters.put("PARAM_REGION", p_region);
		parameters.put("PARAM_MONTH_YEAR", p_month_year);
		parameters.put("PARAM_STATION_TYPE", p_station_type);
		parameters.put("PARAM_DISPLAY_STATION_TYPE", p_display_station_type);
		parameters.put("PARAM_PICO", p_pico);
		parameters.put("PARAM_USERNAME", p_username);
		parameters.put("PARAM_DISPLAY_MONTH_YEAR", p_display_month_year);
		return parameters;
	}

}
