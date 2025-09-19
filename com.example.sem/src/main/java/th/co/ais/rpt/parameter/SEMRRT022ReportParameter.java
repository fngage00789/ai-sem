package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;

public class SEMRRT022ReportParameter extends ReportParameter {
	
	private String p_header_name;
	private String p_company;
	private String p_username;
	private String p_previousMonthFrom;
	private String p_previousMonthTo;
	private String p_currentMonthFrom;
	private String p_currentMonthTo;
	private String p_expenseType;
	private String p_contractNo;
	private String p_percentDiffType;
	private String p_percentDiffAmt;
	private String p_display_previousMonthFrom;
	private String p_display_previousMonthTo;
	private String p_display_currentMonthFrom;
	private String p_display_currentMonthTo;
	private String p_display_expenseType;
	
	
	public String getP_display_previousMonthFrom() {
		return p_display_previousMonthFrom;
	}

	public void setP_display_previousMonthFrom(String pDisplayPreviousMonthFrom) {
		p_display_previousMonthFrom = pDisplayPreviousMonthFrom;
	}

	public String getP_display_previousMonthTo() {
		return p_display_previousMonthTo;
	}

	public void setP_display_previousMonthTo(String pDisplayPreviousMonthTo) {
		p_display_previousMonthTo = pDisplayPreviousMonthTo;
	}

	public String getP_display_currentMonthFrom() {
		return p_display_currentMonthFrom;
	}

	public void setP_display_currentMonthFrom(String pDisplayCurrentMonthFrom) {
		p_display_currentMonthFrom = pDisplayCurrentMonthFrom;
	}

	public String getP_display_currentMonthTo() {
		return p_display_currentMonthTo;
	}

	public void setP_display_currentMonthTo(String pDisplayCurrentMonthTo) {
		p_display_currentMonthTo = pDisplayCurrentMonthTo;
	}

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

	public String getP_previousMonthFrom() {
		return p_previousMonthFrom;
	}

	public void setP_previousMonthFrom(String pPreviousMonthFrom) {
		p_previousMonthFrom = pPreviousMonthFrom;
	}

	public String getP_previousMonthTo() {
		return p_previousMonthTo;
	}

	public void setP_previousMonthTo(String pPreviousMonthTo) {
		p_previousMonthTo = pPreviousMonthTo;
	}

	public String getP_currentMonthFrom() {
		return p_currentMonthFrom;
	}

	public void setP_currentMonthFrom(String pCurrentMonthFrom) {
		p_currentMonthFrom = pCurrentMonthFrom;
	}

	public String getP_currentMonthTo() {
		return p_currentMonthTo;
	}

	public void setP_currentMonthTo(String pCurrentMonthTo) {
		p_currentMonthTo = pCurrentMonthTo;
	}

	public String getP_expenseType() {
		return p_expenseType;
	}

	public void setP_expenseType(String pExpenseType) {
		p_expenseType = pExpenseType;
	}

	public String getP_contractNo() {
		return p_contractNo;
	}

	public void setP_contractNo(String pContractNo) {
		p_contractNo = pContractNo;
	}

	public String getP_percentDiffType() {
		return p_percentDiffType;
	}

	public void setP_percentDiffType(String pPercentDiffType) {
		p_percentDiffType = pPercentDiffType;
	}



	public String getP_percentDiffAmt() {
		return p_percentDiffAmt;
	}

	public void setP_percentDiffAmt(String pPercentDiffAmt) {
		p_percentDiffAmt = pPercentDiffAmt;
	}

	public String getP_display_expenseType() {
		return p_display_expenseType;
	}

	public void setP_display_expenseType(String pDisplayExpenseType) {
		p_display_expenseType = pDisplayExpenseType;
	}

	@Override
	public Map getReportParameter() {
		parameters = new HashMap();
		parameters.put("PARAM_REPORT_ENGINE", reportEngine);
		parameters.put("PARAM_HEADER_NAME", p_header_name);
		parameters.put("PARAM_USERNAME", p_username);
		parameters.put("PARAM_COMPANY", p_company);
		parameters.put("PARAM_PREVIOUS_MONTH_FROM", p_previousMonthFrom);
		parameters.put("PARAM_PREVIOUS_MONTH_TO", p_previousMonthTo);
		parameters.put("PARAM_CURRENT_MONTH_FROM", p_currentMonthFrom);
		parameters.put("PARAM_CURRENT_MONTH_TO", p_currentMonthTo);
		parameters.put("PARAM_DISPLAY_PREVIOUS_MONTH_FROM", p_display_previousMonthFrom);
		parameters.put("PARAM_DISPLAY_PREVIOUS_MONTH_TO", p_display_previousMonthTo);
		parameters.put("PARAM_DISPLAY_CURRENT_MONTH_FROM", p_display_currentMonthFrom);
		parameters.put("PARAM_DISPLAY_CURRENT_MONTH_TO", p_display_currentMonthTo);
		parameters.put("PARAM_DISPLAY_EXPENSE_TYPE", p_display_expenseType);
		parameters.put("PARAM_EXPENSE_TYPE", p_expenseType);
		parameters.put("PARAM_CONTRACT_NO", p_contractNo);
		parameters.put("PARAM_PERCENT_DIFF_TYPE", p_percentDiffType);
		parameters.put("PARAM_PERCENT_DIFF_AMT", p_percentDiffAmt);
		return parameters;
	}	
}
