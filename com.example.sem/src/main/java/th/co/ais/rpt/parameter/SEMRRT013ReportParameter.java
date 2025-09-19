package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Warawit Kitmongkonsak
 * 
 */
public class SEMRRT013ReportParameter extends ReportParameter{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3098209424731256555L;
	//Criteria For Jsp Input Parameters
	private String p_header_name;
	private String p_company;
	private String p_year;
	private String p_quater;
	private String p_vendor_code;
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

	public String getP_quater() {
		return p_quater;
	}

	public void setP_quater(String pQuater) {
		p_quater = pQuater;
	}

	public String getP_vendor_code() {
		return p_vendor_code;
	}

	public void setP_vendor_code(String pVendorCode) {
		p_vendor_code = pVendorCode;
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
		parameters.put("PARAM_YEAR", p_year);
		parameters.put("PARAM_QUARTER", p_quater);
		parameters.put("PARAM_VENDOR_CODE", p_vendor_code);
		parameters.put("PARAM_USERNAME", p_username);
		return parameters;
	}

}
