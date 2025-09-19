package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Warawit Kitmongkonsak
 * 
 */
public class SEMRRT016ReportParameter extends ReportParameter{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 865475240158161628L;
	//Criteria For Jsp Input Parameters
	private String p_header_name;
	private String p_company;
	private String p_year;
	private String p_month;
	private String p_region;
	private String p_cost_center;
	private String p_gl_code;
	private String p_username;
	
	private String p_month_display;
	private String p_region_display;
	
	public String getP_header_name() {
		return p_header_name;
	}


	public void setP_header_name(String pHeaderName) {
		p_header_name = pHeaderName;
	}
	

	public String getP_username() {
		return p_username;
	}


	public void setP_username(String pUsername) {
		p_username = pUsername;
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


	public String getP_cost_center() {
		return p_cost_center;
	}


	public void setP_cost_center(String pCostCenter) {
		p_cost_center = pCostCenter;
	}


	public String getP_gl_code() {
		return p_gl_code;
	}


	public void setP_gl_code(String pGlCode) {
		p_gl_code = pGlCode;
	}


	public String getP_month_display() {
		return p_month_display;
	}


	public void setP_month_display(String pMonthDisplay) {
		p_month_display = pMonthDisplay;
	}


	public String getP_region_display() {
		return p_region_display;
	}


	public void setP_region_display(String pRegionDisplay) {
		p_region_display = pRegionDisplay;
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
		parameters.put("PARAM_COST_CENTER", p_cost_center);
		parameters.put("PARAM_GL_CODE", p_gl_code);
		parameters.put("PARAM_MONTH_DISPLAY", p_month_display);
		parameters.put("PARAM_REGION_DISPLAY", p_region_display);
		parameters.put("PARAM_USERNAME", p_username);
		return parameters;
	}

}
