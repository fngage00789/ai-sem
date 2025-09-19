package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;

public class SEMRRT021ReportParameter extends ReportParameter {
	
	private String p_header_name;
	private String p_username;
	private String p_company;
	private String p_month_year;
	private String p_region;
	private String p_contractNo;
	private String p_contractStatus;
	private String p_diffType1;
	private String p_diffType2;
	private String p_display_month_year;
	
	
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

	public String getP_month_year() {
		return p_month_year;
	}


	public void setP_month_year(String pMonthYear) {
		p_month_year = pMonthYear;
	}


	public String getP_region() {
		return p_region;
	}


	public void setP_region(String pRegion) {
		p_region = pRegion;
	}


	public String getP_contractNo() {
		return p_contractNo;
	}


	public void setP_contractNo(String pContractNo) {
		p_contractNo = pContractNo;
	}


	public String getP_contractStatus() {
		return p_contractStatus;
	}


	public void setP_contractStatus(String pContractStatus) {
		p_contractStatus = pContractStatus;
	}


	public String getP_diffType1() {
		return p_diffType1;
	}


	public void setP_diffType1(String pDiffType1) {
		p_diffType1 = pDiffType1;
	}


	public String getP_diffType2() {
		return p_diffType2;
	}


	public void setP_diffType2(String pDiffType2) {
		p_diffType2 = pDiffType2;
	}
	

	public String getP_display_month_year() {
		return p_display_month_year;
	}


	public void setP_display_month_year(String pDisplayMonthYear) {
		p_display_month_year = pDisplayMonthYear;
	}


	@Override
	public Map getReportParameter() {
		parameters = new HashMap();
		parameters.put("PARAM_REPORT_ENGINE", reportEngine);
		parameters.put("PARAM_USERNAME", p_username);
		parameters.put("PARAM_HEADER_NAME", p_header_name);
		parameters.put("PARAM_COMPANY", p_company);
		parameters.put("PARAM_MONTH_YEAR", p_month_year);
		parameters.put("PARAM_REGION", p_region);
		parameters.put("PARAM_CONTRACT_NO", p_contractNo);
		parameters.put("PARAM_CONTRACT_STATUS", p_contractStatus);
		parameters.put("PARAM_DIFF_TYPE_1", p_diffType1);
		parameters.put("PARAM_DIFF_TYPE_2", p_diffType2);
		parameters.put("PARAM_DISPLAY_MONTH_YEAR", p_display_month_year);
		return parameters;
	}	
}
