package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;

public class SEMRRT018ReportParameter extends ReportParameter{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6837905009558909966L;
	/**
	 * 
	 */
	//Criteria For Jsp Input Parameters
	private String p_header_name;
	private String p_company;
	private String p_contract_no;
	private String p_location_id;
	private String p_region;
	private String p_vendor;
	private String p_contract_status;
	private String p_network_status;
	private String p_asof;
	private String p_display_contract_status;
	private String p_display_network_status;
	private String p_username;
	private String p_display_as_of;
	public String getP_company() {
		return p_company;
	}

	public void setP_company(String pCompany) {
		p_company = pCompany;
	}

	public String getP_region() {
		return p_region;
	}

	public void setP_region(String pRegion) {
		p_region = pRegion;
	}

	
	public String getP_display_contract_status() {
		return p_display_contract_status;
	}

	public void setP_display_contract_status(String pDisplayContractStatus) {
		p_display_contract_status = pDisplayContractStatus;
	}

	public String getP_display_network_status() {
		return p_display_network_status;
	}

	public void setP_display_network_status(String pDisplayNetworkStatus) {
		p_display_network_status = pDisplayNetworkStatus;
	}

	public String getP_header_name() {
		return p_header_name;
	}

	public void setP_header_name(String pHeaderName) {
		p_header_name = pHeaderName;
	}
	
	public String getP_contract_no() {
		return p_contract_no;
	}

	public void setP_contract_no(String pContractNo) {
		p_contract_no = pContractNo;
	}

	public String getP_location_id() {
		return p_location_id;
	}

	public void setP_location_id(String pLocationId) {
		p_location_id = pLocationId;
	}

	public String getP_vendor() {
		return p_vendor;
	}

	public void setP_vendor(String pVendor) {
		p_vendor = pVendor;
	}

	public String getP_contract_status() {
		return p_contract_status;
	}

	public void setP_contract_status(String pContractStatus) {
		p_contract_status = pContractStatus;
	}

	public String getP_network_status() {
		return p_network_status;
	}

	public void setP_network_status(String pNetworkStatus) {
		p_network_status = pNetworkStatus;
	}

	public String getP_asof() {
		return p_asof;
	}

	public void setP_asof(String pAsof) {
		p_asof = pAsof;
	}
	
	public String getP_username() {
		return p_username;
	}

	public void setP_username(String pUsername) {
		p_username = pUsername;
	}
	
	public String getP_display_as_of() {
		return p_display_as_of;
	}

	public void setP_display_as_of(String pDisplayAsOf) {
		p_display_as_of = pDisplayAsOf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map getReportParameter() {
		parameters = new HashMap();
		parameters.put("PARAM_REPORT_ENGINE", reportEngine);
		parameters.put("PARAM_HEADER_NAME", p_header_name);
		parameters.put("PARAM_COMPANY", p_company);
		parameters.put("PARAM_MULTI_CONTRACT_NO", p_contract_no);
		parameters.put("PARAM_MULTI_LOCATION_ID", p_location_id);
		parameters.put("PARAM_MULTI_REGION", p_region);
		parameters.put("PARAM_MULTI_VENDOR", p_vendor);
		parameters.put("PARAM_MULTI_CONTRACT_STATUS", p_contract_status);
		parameters.put("PARAM_MULTI_NETWORK_STATUS", p_network_status);
		parameters.put("PARAM_DISPLAY_CONTRACT_STATUS", p_display_contract_status);
		parameters.put("PARAM_DISPLAY_NETWORK_STATUS", p_display_network_status);
		parameters.put("PARAM_AS_OF", p_asof);
		parameters.put("PARAM_USERNAME", p_username);
		parameters.put("PARAM_DISPLAY_AS_OF", p_display_as_of);
		return parameters;
	}

}
