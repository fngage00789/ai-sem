package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;

public class SEMRIR005ReportParameter extends ReportParameter {


	/**
	 * 
	 */
	private static final long serialVersionUID = -309768970697718683L;
	/**
	 * 
	 */
	private String p_header_name;
	private String p_company;
	private String p_ir_year;
	private String p_ir_network_type;
	private String p_display_year;
	private String p_policy_type;
	private String p_regions;
	private String p_username;
	private String p_display_type;
	private String p_display_policy;


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

	public String getP_ir_network_type() {
		return p_ir_network_type;
	}

	public void setP_ir_network_type(String pIrNetworkType) {
		p_ir_network_type = pIrNetworkType;
	}

	public String getP_display_year() {
		return p_display_year;
	}

	public void setP_display_year(String pDisplayYear) {
		p_display_year = pDisplayYear;
	}

	public String getP_policy_type() {
		return p_policy_type;
	}

	public void setP_policy_type(String pPolicyType) {
		p_policy_type = pPolicyType;
	}

	public String getP_display_policy() {
		return p_display_policy;
	}

	public void setP_display_policy(String pDisplayPolicy) {
		p_display_policy = pDisplayPolicy;
	}

	public String getP_regions() {
		return p_regions;
	}

	public void setP_regions(String pRegions) {
		p_regions = pRegions;
	}

	public String getP_create_by() {
		return p_username;
	}

	public void setP_create_by(String pCreateBy) {
		p_username = pCreateBy;
	}

	public String getP_username() {
		return p_username;
	}

	public void setP_username(String pUsername) {
		p_username = pUsername;
	}


	public void setP_ir_year(String p_ir_year) {
		this.p_ir_year = p_ir_year;
	}

	public String getP_ir_year() {
		return p_ir_year;
	}

	public void setP_display_type(String p_display_type) {
		this.p_display_type = p_display_type;
	}

	public String getP_display_type() {
		return p_display_type;
	}

	@Override
	public Map getReportParameter() {
		parameters = new HashMap();
		parameters.put("PARAM_REPORT_ENGINE", reportEngine);
		parameters.put("PARAM_HEADER_NAME", p_header_name);
		parameters.put("PARAM_USERNAME", p_username);
		parameters.put("PARAM_COMPANY", p_company);
		parameters.put("PARAM_IR_YEAR", p_ir_year);
		parameters.put("PARAM_REGION", p_regions);
		parameters.put("PARAM_POLICY_TYPE", p_policy_type);
		parameters.put("PARAM_IR_NETWORK_TYPE", p_ir_network_type);
		parameters.put("PARAM_DISPLAY_YEAR", p_display_year);
		parameters.put("PARAM_DISPLAY_NETWORK_TYPE", p_display_type);
		parameters.put("PARAM_DISPLAY_POLICY_TYPE", p_display_policy);

		return parameters;
	}
}
