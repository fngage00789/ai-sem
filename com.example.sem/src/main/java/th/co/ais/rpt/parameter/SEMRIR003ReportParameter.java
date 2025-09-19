package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;

public class SEMRIR003ReportParameter extends ReportParameter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 411243359674291324L;
	private String p_header_name;
	private String p_username;
	private String p_company;
	private String p_ir_year;
	private String p_display_ir_year;
	private String p_region;
	private String p_zone;
	private String p_display_zone;
	private String p_loss_type;
	private String p_display_loss_type;

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

	public String getP_ir_year() {
		return p_ir_year;
	}

	public void setP_ir_year(String pIrYear) {
		p_ir_year = pIrYear;
	}

	public String getP_display_ir_year() {
		return p_display_ir_year;
	}

	public void setP_display_ir_year(String pDisplayIrYear) {
		p_display_ir_year = pDisplayIrYear;
	}

	public String getP_region() {
		return p_region;
	}

	public void setP_region(String pRegion) {
		p_region = pRegion;
	}

	public String getP_zone() {
		return p_zone;
	}

	public void setP_zone(String pZone) {
		p_zone = pZone;
	}

	public String getP_display_zone() {
		return p_display_zone;
	}

	public void setP_display_zone(String pDisplayZone) {
		p_display_zone = pDisplayZone;
	}

	public String getP_loss_type() {
		return p_loss_type;
	}

	public void setP_loss_type(String pLossType) {
		p_loss_type = pLossType;
	}

	public String getP_display_loss_type() {
		return p_display_loss_type;
	}

	public void setP_display_loss_type(String pDisplayLossType) {
		p_display_loss_type = pDisplayLossType;
	}

	@Override
	public Map getReportParameter() {
		parameters = new HashMap();
		parameters.put("PARAM_REPORT_ENGINE", reportEngine);
		parameters.put("PARAM_HEADER_NAME", p_header_name);
		parameters.put("PARAM_USERNAME", p_username);
		parameters.put("PARAM_COMPANY", p_company);
		parameters.put("PARAM_IR_YEAR", p_ir_year);
		parameters.put("PARAM_DISPLAY_IR_YEAR", p_display_ir_year);
		parameters.put("PARAM_REGION", p_region);
		parameters.put("PARAM_ZONE", p_zone);
		parameters.put("PARAM_DISPLAY_ZONE", p_display_zone);
		parameters.put("PARAM_LOSS_TYPE", p_loss_type);
		parameters.put("PARAM_DISPLAY_LOSS_TYPE", p_display_loss_type);

		return parameters;
	}

}
