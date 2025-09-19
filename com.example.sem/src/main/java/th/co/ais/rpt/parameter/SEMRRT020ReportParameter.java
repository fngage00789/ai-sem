package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;

public class SEMRRT020ReportParameter extends ReportParameter {
	
	private String p_header_name;
	private String p_company;
	private String p_master_group;
	private String p_username;
	private String p_print_date;
	private String p_month_year;
	private String p_display_month_year;
	private String[] p_sheet_name;
	
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

	public String getP_master_group() {
		return p_master_group;
	}

	public void setP_master_group(String strings) {
		p_master_group = strings;
	}

	public String getP_username() {
		return p_username;
	}

	public void setP_username(String pUsername) {
		p_username = pUsername;
	}

	public String getP_print_date() {
		return p_print_date;
	}

	public void setP_print_date(String pPrintDate) {
		p_print_date = pPrintDate;
	}

	public String getP_month_year() {
		return p_month_year;
	}

	public void setP_month_year(String pMonthYear) {
		p_month_year = pMonthYear;
	}
	

	public String getP_display_month_year() {
		return p_display_month_year;
	}

	public void setP_display_month_year(String pDisplayMonthYear) {
		p_display_month_year = pDisplayMonthYear;
	}
	public String[] getP_sheet_name() {
		return p_sheet_name;
	}

	public void setP_sheet_name(String[] pSheetName) {
		p_sheet_name = pSheetName;
	}
	@Override
	public Map getReportParameter() {
		parameters = new HashMap();
		parameters.put("PARAM_REPORT_ENGINE", reportEngine);
		parameters.put("PARAM_HEADER_NAME", p_header_name);
		parameters.put("PARAM_COMPANY", p_company);
		parameters.put("PARAM_MASTER_GROUP", p_master_group);
		parameters.put("PARAM_USERNAME", p_username);
		parameters.put("PARAM_PRINT_DATE", p_print_date);
		parameters.put("PARAM_MONTH_YEAR", p_month_year);
		parameters.put("PARAM_DISPLAY_MONTH_YEAR", p_display_month_year);
		parameters.put(JRXlsAbstractExporterParameter.SHEET_NAMES, p_sheet_name);
		return parameters;
	}	
}
