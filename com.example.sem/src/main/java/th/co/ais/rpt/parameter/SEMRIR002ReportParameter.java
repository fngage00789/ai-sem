package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;

public class SEMRIR002ReportParameter extends ReportParameter {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7480050598247185358L;
	private String p_header_name;
	private String p_company;
	private String p_year;
	private String p_display_year;
	private String p_network_type;
	private String p_display_network_type;
	private String p_policy;
	private String p_display_policy;
	private String p_region;
	private String p_loss_type;
	private String p_display_loss_type;
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
	

	public String getP_network_type() {
		return p_network_type;
	}

	public void setP_network_type(String pNetworkType) {
		p_network_type = pNetworkType;
	}

	public String getP_display_network_type() {
		return p_display_network_type;
	}

	public void setP_display_network_type(String pDisplayNetworkType) {
		p_display_network_type = pDisplayNetworkType;
	}

	public String getP_loss_type() {
		return p_loss_type;
	}

	public void setP_loss_type(String pLossType) {
		p_loss_type = pLossType;
	}

	public String getP_display_loss_type() {
		return p_display_loss_type;
	}

	public void setP_display_loss_type(String pDisplayLossType) {
		p_display_loss_type = pDisplayLossType;
	}

	public String getP_username() {
		return p_username;
	}

	public void setP_username(String pUsername) {
		p_username = pUsername;
	}

	public String getP_display_year() {
		return p_display_year;
	}

	public void setP_display_year(String pDisplayYear) {
		p_display_year = pDisplayYear;
	}
	
	public String getP_policy() {
		return p_policy;
	}

	public void setP_policy(String pPolicy) {
		p_policy = pPolicy;
	}

	public String getP_display_policy() {
		return p_display_policy;
	}

	public void setP_display_policy(String pDisplayPolicy) {
		p_display_policy = pDisplayPolicy;
	}

	public String getP_region() {
		return p_region;
	}

	public void setP_region(String pRegion) {
		p_region = pRegion;
	}


	@Override
	public Map getReportParameter() {
		parameters = new HashMap();
		parameters.put("PARAM_REPORT_ENGINE", reportEngine);
		parameters.put("PARAM_HEADER_NAME", p_header_name);
		parameters.put("PARAM_COMPANY", p_company);
		parameters.put("PARAM_IR_YEAR", p_year);
		parameters.put("PARAM_DISPLAY_IR_YEAR", p_display_year);
		parameters.put("PARAM_NETWORK_TYPE", p_network_type);
		parameters.put("PARAM_DISPLAY_NETWORK_TYPE", p_display_network_type);
		parameters.put("PARAM_POLICY_TYPE", p_policy);
		parameters.put("PARAM_DISPLAY_POLICY_TYPE", p_display_policy);
		parameters.put("PARAM_REGION", p_region);
		parameters.put("PARAM_LOSS_TYPE", p_loss_type);
		parameters.put("PARAM_DISPLAY_LOSS_TYPE", p_display_loss_type);
		parameters.put("PARAM_USERNAME", p_username);
		return parameters;
	}

}
