package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;

public class SEMRRT023ReportParameter extends ReportParameter{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4716931509620197569L;
	//Criteria For Jsp Input Parameters
	private String p_header_name;
	private String p_company;
	private String p_region;
	private String p_year;
	private String p_payment_type;
	private String p_module;
	private String p_expense_type;
	private String p_username;

	

	public String getP_payment_type() {
		return p_payment_type;
	}



	public void setP_payment_type(String pPaymentType) {
		p_payment_type = pPaymentType;
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



	public String getP_region() {
		return p_region;
	}



	public void setP_region(String pRegion) {
		p_region = pRegion;
	}



	public String getP_year() {
		return p_year;
	}



	public void setP_year(String pYear) {
		p_year = pYear;
	}



	


	public String getP_module() {
		return p_module;
	}



	public void setP_module(String pModule) {
		p_module = pModule;
	}



	public String getP_expense_type() {
		return p_expense_type;
	}



	public void setP_expense_type(String pExpenseType) {
		p_expense_type = pExpenseType;
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
		parameters.put("PARAM_REGION", p_region);
		parameters.put("PARAM_PAY_TYPE", p_payment_type);
		parameters.put("PARAM_YEAR", p_year);
		parameters.put("PARAM_MODULE", p_module);
		parameters.put("PARAM_EXPENSE_TYPE", p_expense_type);
		parameters.put("PARAM_USERNAME", p_username);

		return parameters;
	}

}
