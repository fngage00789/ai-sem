package th.co.ais.rpt.parameter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SEMREL001ReportParameter extends ReportParameter{
	
	private static final long serialVersionUID = -4716931509620197569L;
	//Criteria For Jsp Input Parameters
	private String p_header_name;
	private String p_company;
	private String p_electricUseType;
	private String p_region;
	private Date p_month;
	private String p_year;
	private Date p_date;
	private String p_meterReqType;
	private String p_meterData;
	private String p_period;
	private String p_monthType;
	private String p_electricUseTypeDisplay;
	private String p_meterReqTypeDisplay;
	private String p_companyDisplay;
	private String p_monthDisplay;
	private String p_onService;
	
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
	

	public Date getP_month() {
		return p_month;
	}

	public void setP_month(Date pMonth) {
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
		parameters.put("PARAM_ELECTRIC_USE_TYPE", p_electricUseType);
		parameters.put("PARAM_METER_REQ_TYPE", p_meterReqType);
		parameters.put("PARAM_METER_DATA", p_meterData);
		parameters.put("PARAM_ON_SERVICE", p_onService);
		parameters.put("PARAM_MONTH_TYPE", p_monthType);
		parameters.put("PARAM_MONTH", p_month);
		parameters.put("PARAM_PERIOD", p_period);
		parameters.put("PARAM_ELECTRIC_USE_TYPE_DISPLAY", p_electricUseTypeDisplay);
		parameters.put("PARAM_METER_REQ_TYPE_DISPLAY", p_meterReqTypeDisplay);
		parameters.put("PARAM_COMPANY_DISPLAY", p_companyDisplay);
		parameters.put("PARAM_MONTH_DISPLAY", p_monthDisplay);
		
		
		
		
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

	public String getP_period() {
		return p_period;
	}

	public void setP_period(String pPeriod) {
		p_period = pPeriod;
	}

	public String getP_electricUseTypeDisplay() {
		return p_electricUseTypeDisplay;
	}

	public void setP_electricUseTypeDisplay(String pElectricUseTypeDisplay) {
		p_electricUseTypeDisplay = pElectricUseTypeDisplay;
	}

	public String getP_meterReqType() {
		return p_meterReqType;
	}

	public void setP_meterReqType(String pMeterReqType) {
		p_meterReqType = pMeterReqType;
	}

	public String getP_meterData() {
		return p_meterData;
	}

	public void setP_meterData(String pMeterData) {
		p_meterData = pMeterData;
	}

	public String getP_monthType() {
		return p_monthType;
	}

	public void setP_monthType(String pMonthType) {
		p_monthType = pMonthType;
	}

	public String getP_meterReqTypeDisplay() {
		return p_meterReqTypeDisplay;
	}

	public void setP_meterReqTypeDisplay(String pMeterReqTypeDisplay) {
		p_meterReqTypeDisplay = pMeterReqTypeDisplay;
	}

	public String getP_companyDisplay() {
		return p_companyDisplay;
	}

	public void setP_companyDisplay(String pCompanyDisplay) {
		p_companyDisplay = pCompanyDisplay;
	}

	public String getP_monthDisplay() {
		return p_monthDisplay;
	}

	public void setP_monthDisplay(String pMonthDisplay) {
		p_monthDisplay = pMonthDisplay;
	}

	public String getP_onService() {
		return p_onService;
	}

	public void setP_onService(String pOnService) {
		p_onService = pOnService;
	}

	

}
