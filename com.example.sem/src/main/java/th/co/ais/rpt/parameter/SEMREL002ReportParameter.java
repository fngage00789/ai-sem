package th.co.ais.rpt.parameter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SEMREL002ReportParameter extends ReportParameter{
	
	private static final long serialVersionUID = -4716931509620197569L;
	//Criteria For Jsp Input Parameters
	private String p_header_name;
	private String p_company;
	private String p_electricUseType;
	private String p_electricUseTypeDisplay;
	private String p_region;
	private String p_month;
	private String p_year;
	private Date p_date;
	
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
	
	public String getP_header_name() {
		return p_header_name;
	}

	public void setP_header_name(String pHeaderName) {
		p_header_name = pHeaderName;
	}
	

	public String getP_month() {
		return p_month;
	}

	public void setP_month(String pMonth) {
		p_month = pMonth;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map getReportParameter() {
		parameters = new HashMap();
		parameters.put("PARAM_REPORT_ENGINE", reportEngine);
		parameters.put("PARAM_HEADER_NAME", p_header_name);
		parameters.put("PARAM_COMPANY", p_company);
		parameters.put("PARAM_REGION", p_region);
		parameters.put("PARAM_MONTH", p_month);
		parameters.put("PARAM_YEAR", p_year);
		parameters.put("PARAM_DATE", p_date);
		parameters.put("PARAM_ELECTRIC_USE_TYPE_DISPLAY", p_electricUseTypeDisplay);
		parameters.put("PARAM_ELECTRIC_USE_TYPE", p_electricUseType);
		return parameters;
	}

	public Date getP_date() {
		return p_date;
	}

	public void setP_date(Date pDate) {
		p_date = pDate;
	}

	public String getP_electricUseType() {
		return p_electricUseType;
	}

	public void setP_electricUseType(String pElectricUseType) {
		p_electricUseType = pElectricUseType;
	}

	public String getP_electricUseTypeDisplay() {
		return p_electricUseTypeDisplay;
	}

	public void setP_electricUseTypeDisplay(String pElectricUseTypeDisplay) {
		p_electricUseTypeDisplay = pElectricUseTypeDisplay;
	}

}
