package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;

public class SEMRSI008ReportParameter extends ReportParameter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9146442097844954754L;
	private String p_header_name;
	private String p_company;
	private String p_delay_month;
	private String p_contract_no;
	private String p_site_name;
	private String p_region;
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

	public String getP_delay_month() {
		return p_delay_month;
	}

	public void setP_delay_month(String pDelayMonth) {
		p_delay_month = pDelayMonth;
	}

	public String getP_contract_no() {
		return p_contract_no;
	}

	public void setP_contract_no(String pContractNo) {
		p_contract_no = pContractNo;
	}

	public String getP_site_name() {
		return p_site_name;
	}

	public void setP_site_name(String pSiteName) {
		p_site_name = pSiteName;
	}

	public String getP_region() {
		return p_region;
	}

	public void setP_region(String pRegion) {
		p_region = pRegion;
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
		parameters.put("PARAM_REGION_CODE", p_region);
		parameters.put("PARAM_DELAY", p_delay_month);
		parameters.put("PARAM_SITE_NAME", p_site_name);
		parameters.put("PARAM_CONTRACT_NO", p_contract_no);
		parameters.put("PARAM_USERNAME", p_username);
		return parameters;
	}

}
