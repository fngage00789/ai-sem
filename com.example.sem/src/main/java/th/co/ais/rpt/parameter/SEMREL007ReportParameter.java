package th.co.ais.rpt.parameter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SEMREL007ReportParameter extends ReportParameter{
	
	private static final long serialVersionUID = -4716931509620197569L;
	//Criteria For Jsp Input Parameters
	private String p_header_name;
	private String p_company;
	private String p_electricUseType;
	private String p_electricUseTypeDisplay;
	private String p_region;
	private Date p_year;
	private String p_companyDisplay;
	private String p_regionDisplay;
	private String p_yearDisplay;
	private String p_siteStatus;
	private String p_in_group_location;
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
		parameters.put("PARAM_REGION", p_region);
		parameters.put("PARAM_YEAR", p_year);
		parameters.put("PARAM_ELECTRIC_TYPE", p_electricUseType);
		parameters.put("PARAM_ELECTRIC_TYPE_DISPLAY", p_electricUseTypeDisplay);
		parameters.put("PARAM_COMPANY_DISPLAY", p_company);
		parameters.put("PARAM_REGION_DISPLAY", p_regionDisplay);
		parameters.put("PARAM_YEAR_DISPLAY", p_yearDisplay);
		parameters.put("PARAM_SITE_STATUS", p_siteStatus);
		parameters.put("PARAM_GROUP_BY_LOCATION", p_in_group_location);
		
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

	public Date getP_year() {
		return p_year;
	}

	public void setP_year(Date pYear) {
		p_year = pYear;
	}

	public String getP_companyDisplay() {
		return p_companyDisplay;
	}

	public void setP_companyDisplay(String pCompanyDisplay) {
		p_companyDisplay = pCompanyDisplay;
	}

	public String getP_regionDisplay() {
		return p_regionDisplay;
	}

	public void setP_regionDisplay(String pRegionDisplay) {
		p_regionDisplay = pRegionDisplay;
	}

	public String getP_yearDisplay() {
		return p_yearDisplay;
	}

	public void setP_yearDisplay(String pYearDisplay) {
		p_yearDisplay = pYearDisplay;
	}

	public String getP_siteStatus() {
		return p_siteStatus;
	}

	public void setP_siteStatus(String pSiteStatus) {
		p_siteStatus = pSiteStatus;
	}

	public String getP_in_group_location() {
		return p_in_group_location;
	}

	public void setP_in_group_location(String pInGroupLocation) {
		p_in_group_location = pInGroupLocation;
	}

}
