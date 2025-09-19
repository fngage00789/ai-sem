package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;

public class SEMRCO002ReportParameter extends ReportParameter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9146442097844954754L;
	private String p_header_name;
	private String p_company;
	private String p_year;
	private String p_display_year;
	private String p_region_code;
	private String p_pico;
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

	public String getP_display_year() {
		return p_display_year;
	}

	public void setP_display_year(String pDisplayYear) {
		p_display_year = pDisplayYear;
	}

	public String getP_region_code() {
		return p_region_code;
	}

	public void setP_region_code(String pRegionCode) {
		p_region_code = pRegionCode;
	}

	public String getP_pico() {
		return p_pico;
	}

	public void setP_pico(String pPico) {
		p_pico = pPico;
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
		parameters.put("PARAM_REGION_CODE", p_region_code);
		parameters.put("PARAM_YEAR", p_year);
		parameters.put("PARAM_YEAR_DISPLAY", p_display_year);
		parameters.put("PARAM_PICO", p_pico);
		parameters.put("PARAM_USERNAME", p_username);
		return parameters;
	}

}
