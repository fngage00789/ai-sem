package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;

public class SEMRIR004ReportParameter extends ReportParameter {
	
	private String p_header_name;
	private String p_username;
	private String p_company;
	private String p_ir_year;
	private String p_network_type;
	private String p_transfer_type;
	private String p_policy_type;
	private String p_display_year;
	private String p_display_type;
	private String p_display_transfer_type;
	
	public String getP_display_transfer_type() {
		return p_display_transfer_type;
	}

	public void setP_display_transfer_type(String pDisplayTransferType) {
		p_display_transfer_type = pDisplayTransferType;
	}


	private String p_display_policy;
	private String p_region;

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

	public String getP_ir_year() {
		return p_ir_year;
	}

	public void setP_ir_year(String pIrYear) {
		p_ir_year = pIrYear;
	}

	public String getP_network_type() {
		return p_network_type;
	}

	public void setP_network_type(String pNetworkType) {
		p_network_type = pNetworkType;
	}

	public String getP_transfer_type() {
		return p_transfer_type;
	}

	public void setP_transfer_type(String pTransferType) {
		p_transfer_type = pTransferType;
	}

	public String getP_policy_type() {
		return p_policy_type;
	}

	public void setP_policy_type(String pPolicyType) {
		p_policy_type = pPolicyType;
	}

	public String getP_display_year() {
		return p_display_year;
	}

	public void setP_display_year(String pDisplayYear) {
		p_display_year = pDisplayYear;
	}

	public String getP_display_type() {
		return p_display_type;
	}

	public void setP_display_type(String pDisplayType) {
		p_display_type = pDisplayType;
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
		parameters.put("PARAM_USERNAME", p_username);
		parameters.put("PARAM_COMPANY", p_company);
		parameters.put("PARAM_IR_YEAR", p_ir_year);
		parameters.put("PARAM_NETWORK_TYPE", p_network_type);
		parameters.put("PARAM_POLICY_TYPE", p_policy_type);
		parameters.put("PARAM_DISPLAY_YEAR", p_display_year);
		parameters.put("PARAM_DISPLAY_POLICY", p_display_policy);
		parameters.put("PARAM_DISPLAY_TYPE", p_display_type);
		parameters.put("PARAM_REGION", p_region);
		parameters.put("PARAM_TRANSFER_TYPE", p_transfer_type);
		parameters.put("PARAM_DISPLAY_TRANSFER_TYPE", p_display_transfer_type);


	
		return parameters;
	}	
}
