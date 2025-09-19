package th.co.ais.rpt.parameter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SEMREL003ReportParameter extends ReportParameter{
	
	private static final long serialVersionUID = -4716931509620197569L;
	//Criteria For Jsp Input Parameters
	private String p_header_name;
	private String p_company;
	private String p_electricUseType;
	private Date p_year;
	private String p_electricTypeDisplay;
	
	public String getP_company() {
		return p_company;
	}

	public void setP_company(String pCompany) {
		p_company = pCompany;
	}

	public Date getP_year() {
		return p_year;
	}

	public void setP_year(Date pYear) {
		p_year = pYear;
	}
	
	public String getP_header_name() {
		return p_header_name;
	}

	public void setP_header_name(String pHeaderName) {
		p_header_name = pHeaderName;
	}
		
	@SuppressWarnings("unchecked")
	@Override
	public Map getReportParameter() {
		parameters = new HashMap();
		parameters.put("PARAM_REPORT_ENGINE", reportEngine);
		parameters.put("PARAM_HEADER_NAME", p_header_name);
		parameters.put("PARAM_COMPANY", p_company);
		parameters.put("PARAM_YEAR", p_year);
		parameters.put("PARAM_ELECTRIC_TYPE", p_electricUseType);
		parameters.put("PARAM_ELECTRIC_TYPE_DISPLAY", p_electricTypeDisplay);
		return parameters;
	}

	public String getP_electricUseType() {
		return p_electricUseType;
	}

	public void setP_electricUseType(String pElectricUseType) {
		p_electricUseType = pElectricUseType;
	}

	public String getP_electricTypeDisplay() {
		return p_electricTypeDisplay;
	}

	public void setP_electricTypeDisplay(String pElectricTypeDisplay) {
		p_electricTypeDisplay = pElectricTypeDisplay;
	}

}
