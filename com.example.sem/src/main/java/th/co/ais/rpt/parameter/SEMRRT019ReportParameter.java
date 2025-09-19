package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;

public class SEMRRT019ReportParameter extends ReportParameter{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 814475240158161628L;
	private String p_header_name;
	private String p_username;
	private String p_company;
	private String p_month_year;
	private String p_master_group;
	private String p_contract_no;
	private String p_display_month_year;
	

	public String getP_display_month_year() {
		return p_display_month_year;
	}


	public void setP_display_month_year(String pDisplayMonthYear) {
		p_display_month_year = pDisplayMonthYear;
	}


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
	
	
	
	public String getP_month_year() {
		return p_month_year;
	}


	public void setP_month_year(String pMonthYear) {
		p_month_year = pMonthYear;
	}


	


	public String getP_master_group() {
		return p_master_group;
	}


	public void setP_master_group(String pMasterGroup) {
		p_master_group = pMasterGroup;
	}


	public String getP_contract_no() {
		return p_contract_no;
	}


	public void setP_contract_no(String pContractNo) {
		p_contract_no = pContractNo;
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
		parameters.put("PARAM_USERNAME", p_username);
		parameters.put("PARAM_COMPANY", p_company);
		parameters.put("PARAM_MONTH_YEAR", p_month_year);
		parameters.put("PARAM_MASTER_GROUP", p_master_group);
		parameters.put("PARAM_CONTRACT_NO", p_contract_no); 
		parameters.put("PARAM_DISPLAY_MONTH_YEAR", p_display_month_year); 
		return parameters;
	}	

}
