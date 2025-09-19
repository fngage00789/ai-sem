package th.co.ais.rpt.parameter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SEMREL006ReportParameter extends ReportParameter{
	
	private static final long serialVersionUID = -4716931509620197569L;
	//Criteria For Jsp Input Parameters
	private String p_header_name;
	private String p_company;
	private String p_electricUseType;
	private String p_electricUseTypeDisplay;
	private String p_inType;
	private String p_yearPrepaidDisplay;
	private String p_yearCurrentDisplay;
	private String p_yearPreviousDisplay;
	
	public String getP_company() {
		return p_company;
	}

	public void setP_company(String pCompany) {
		p_company = pCompany;
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
		parameters.put("PARAM_ELECTRIC_TYPE", p_electricUseType);
		parameters.put("PARAM_ELECTRIC_TYPE_DISPLAY", p_electricUseTypeDisplay);
		parameters.put("PARAM_IN_TYPE", p_inType);
		parameters.put("PARAM_YEAR_PREPAID_DISPLAY", p_yearPrepaidDisplay);
		parameters.put("PARAM_YEAR_CURRENT_DISPLAY", p_yearCurrentDisplay);
		parameters.put("PARAM_YEAR_PREV_DISPLAY", p_yearPreviousDisplay);
		
		return parameters;
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

	public String getP_inType() {
		return p_inType;
	}

	public void setP_inType(String pInType) {
		p_inType = pInType;
	}

	public String getP_yearPrepaidDisplay() {
		return p_yearPrepaidDisplay;
	}

	public void setP_yearPrepaidDisplay(String pYearPrepaidDisplay) {
		p_yearPrepaidDisplay = pYearPrepaidDisplay;
	}

	public String getP_yearCurrentDisplay() {
		return p_yearCurrentDisplay;
	}

	public void setP_yearCurrentDisplay(String pYearCurrentDisplay) {
		p_yearCurrentDisplay = pYearCurrentDisplay;
	}

	public String getP_yearPreviousDisplay() {
		return p_yearPreviousDisplay;
	}

	public void setP_yearPreviousDisplay(String pYearPreviousDisplay) {
		p_yearPreviousDisplay = pYearPreviousDisplay;
	}

}
