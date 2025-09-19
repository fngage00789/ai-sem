package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;


public class SEMRPT002ReportParameter extends ReportParameter{
	
	private static final long serialVersionUID = -4716931509620197569L;
	//Criteria For Jsp Input Parameters
	private String p_header_name;
	private String p_company;
	private String p_ptax_year;
	private String p_display_year_tax;
	private String p_expense_type;
	private String p_display_expense_type;
	private String p_pico_flg;
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

	public String getP_ptax_year() {
		return p_ptax_year;
	}

	public void setP_ptax_year(String pPtaxYear) {
		p_ptax_year = pPtaxYear;
	}

	public String getP_expense_type() {
		return p_expense_type;
	}

	public void setP_expense_type(String pExpenseType) {
		p_expense_type = pExpenseType;
	}

	public String getP_display_expense_type() {
		return p_display_expense_type;
	}

	public void setP_display_expense_type(String pDisplayExpenseType) {
		p_display_expense_type = pDisplayExpenseType;
	}
	
	public String getP_display_year_tax() {
		return p_display_year_tax;
	}

	public void setP_display_year_tax(String pDisplayYearTax) {
		p_display_year_tax = pDisplayYearTax;
	}

	public String getP_pico_flg() {
		return p_pico_flg;
	}

	public void setP_pico_flg(String pPicoFlg) {
		p_pico_flg = pPicoFlg;
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
		parameters.put("PARAM_PTAX_YEAR", p_ptax_year);
		parameters.put("PARAM_EXPENSE_TYPE", p_expense_type);
		parameters.put("PARAM_PICO_FLG", p_pico_flg);
		parameters.put("PARAM_DISPLAY_YEAR", p_display_year_tax);
		parameters.put("PARAM_DISPLAY_EXPENSE_TYPE", p_display_expense_type);
		parameters.put("PARAM_USERNAME", p_username);
		return parameters;
	}

}
