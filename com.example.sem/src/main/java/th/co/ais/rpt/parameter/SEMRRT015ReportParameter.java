package th.co.ais.rpt.parameter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Warawit Kitmongkonsak
 * 
 */
public class SEMRRT015ReportParameter extends ReportParameter{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2619214920684407458L;
	//Criteria For Jsp Input Parameters
	private String p_header_name;
	private String p_company;
	private String p_contract_no;
	private String p_location_id;
	private String p_region;
	private Date p_as_of_mmyyyy;
	private String p_username;
	
	public String getP_company() {
		return p_company;
	}

	public void setP_company(String pCompany) {
		p_company = pCompany;
	}

	public String getP_contract_no() {
		return p_contract_no;
	}

	public void setP_contract_no(String pContractNo) {
		p_contract_no = pContractNo;
	}

	public String getP_location_id() {
		return p_location_id;
	}

	public void setP_location_id(String pLocationId) {
		p_location_id = pLocationId;
	}

	public String getP_region() {
		return p_region;
	}

	public void setP_region(String pRegion) {
		p_region = pRegion;
	}

	public Date getP_as_of_mmyyyy() {
		return p_as_of_mmyyyy;
	}

	public void setP_as_of_mmyyyy(Date pAsOfMmyyyy) {
		p_as_of_mmyyyy = pAsOfMmyyyy;
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

	@SuppressWarnings("unchecked")
	@Override
	public Map getReportParameter() {
		parameters = new HashMap();
		parameters.put("PARAM_REPORT_ENGINE", reportEngine);
		parameters.put("PARAM_HEADER_NAME", p_header_name);
		parameters.put("PARAM_COMPANY", p_company);
		parameters.put("PARAM_CONTRACT_NO", p_contract_no);
		parameters.put("PARAM_LOCATION_ID", p_location_id);
		parameters.put("PARAM_REGION", p_region); 
		parameters.put("PARAM_AS_OF_MMYYYY", p_as_of_mmyyyy);
		parameters.put("PARAM_USERNAME", p_username);
		return parameters;
	}

}
