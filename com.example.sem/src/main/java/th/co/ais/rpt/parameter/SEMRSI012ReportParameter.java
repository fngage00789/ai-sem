package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;

public class SEMRSI012ReportParameter extends ReportParameter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9146442097844954754L;
	private String p_header_name;
//	private String p_company;
	private String region;
	private String p_username;
	private String p_zone;
	private String p_display_zone;
	
	
	public String getP_display_zone() {
		return p_display_zone;
	}

	public void setP_display_zone(String pDisplayZone) {
		p_display_zone = pDisplayZone;
	}

	public String getP_zone() {
		return p_zone;
	}

	public void setP_zone(String pZone) {
		p_zone = pZone;
	}

	public String getP_header_name() {
		return p_header_name;
	}

	public void setP_header_name(String pHeaderName) {
		p_header_name = pHeaderName;
	}


	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getP_username() {
		return p_username;
	}

	public void setP_username(String pUsername) {
		p_username = pUsername;
	}

	@Override
	public Map getReportParameter() {
		parameters = new HashMap();
		parameters.put("PARAM_REPORT_ENGINE", reportEngine);
		parameters.put("PARAM_HEADER_NAME", p_header_name);
		parameters.put("PARAM_LOCATION_CODE", region);
		parameters.put("PARAM_USERNAME", p_username);
		parameters.put("PARAM_ZONE", p_zone);
		parameters.put("PARAM_DISPLAY_ZONE", p_display_zone);
		return parameters;
	}

}
