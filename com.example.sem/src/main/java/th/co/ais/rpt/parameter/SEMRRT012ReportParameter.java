package th.co.ais.rpt.parameter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;

/**
 * @author Warawit Kitmongkonsak
 * 
 */
public class SEMRRT012ReportParameter extends ReportParameter{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9090039256027959205L;
	//Criteria For Jsp Input Parameters
	private String p_header_name;
	private String p_company;
	private String p_contract_no;
	private String p_location_code;
	private String p_region;
	private String p_vendor_code;
	private String p_deposit_type;
	private Date p_deposit_datet_from;
	private Date p_deposit_date_to;
	private String p_bg_no;
	private String p_bank;
	private String p_expense_type;
	private String p_contract_status;
	private String p_network_status;
	private String p_username;
	private String p_deposit_status;
	private String p_display_bank;
	private String p_display_expense_type;
	private String p_display_contract_status;
	private String p_display_network_status;
	private String[] p_sheet_name;
	
	
	public String getP_deposit_status() {
		return p_deposit_status;
	}

	public void setP_deposit_status(String pDepositStatus) {
		p_deposit_status = pDepositStatus;
	}

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

	public String getP_contract_no() {
		return p_contract_no;
	}

	public void setP_contract_no(String pContractNo) {
		p_contract_no = pContractNo;
	}

	public String getP_region() {
		return p_region;
	}

	public void setP_region(String pRegion) {
		p_region = pRegion;
	}

	public String getP_deposit_type() {
		return p_deposit_type;
	}

	public void setP_deposit_type(String pDepositType) {
		p_deposit_type = pDepositType;
	}
	

	public String getP_location_code() {
		return p_location_code;
	}

	public void setP_location_code(String pLocationCode) {
		p_location_code = pLocationCode;
	}

	public String getP_vendor_code() {
		return p_vendor_code;
	}

	public void setP_vendor_code(String pVendorCode) {
		p_vendor_code = pVendorCode;
	}


	public String getP_bg_no() {
		return p_bg_no;
	}

	public void setP_bg_no(String pBgNo) {
		p_bg_no = pBgNo;
	}

	public String getP_bank() {
		return p_bank;
	}

	public void setP_bank(String pBank) {
		p_bank = pBank;
	}

	public String getP_expense_type() {
		return p_expense_type;
	}

	public void setP_expense_type(String pExpenseType) {
		p_expense_type = pExpenseType;
	}

	public String getP_contract_status() {
		return p_contract_status;
	}

	public void setP_contract_status(String pContractStatus) {
		p_contract_status = pContractStatus;
	}

	public String getP_network_status() {
		return p_network_status;
	}

	public void setP_network_status(String pNetworkStatus) {
		p_network_status = pNetworkStatus;
	}

	public Date getP_deposit_datet_from() {
		return p_deposit_datet_from;
	}

	public void setP_deposit_datet_from(Date pDepositDatetFrom) {
		p_deposit_datet_from = pDepositDatetFrom;
	}

	public Date getP_deposit_date_to() {
		return p_deposit_date_to;
	}

	public void setP_deposit_date_to(Date pDepositDateTo) {
		p_deposit_date_to = pDepositDateTo;
	}
	
	

	public String getP_username() {
		return p_username;
	}

	public void setP_username(String pUsername) {
		p_username = pUsername;
	}
	
	public String getP_display_bank() {
		return p_display_bank;
	}

	public void setP_display_bank(String pDisplayBank) {
		p_display_bank = pDisplayBank;
	}

	public String getP_display_expense_type() {
		return p_display_expense_type;
	}

	public void setP_display_expense_type(String pDisplayExpenseType) {
		p_display_expense_type = pDisplayExpenseType;
	}

	public String getP_display_contract_status() {
		return p_display_contract_status;
	}

	public void setP_display_contract_status(String pDisplayContractStatus) {
		p_display_contract_status = pDisplayContractStatus;
	}

	public String getP_display_network_status() {
		return p_display_network_status;
	}

	public void setP_display_network_status(String pDisplayNetworkStatus) {
		p_display_network_status = pDisplayNetworkStatus;
	}

	public String[] getP_sheet_name() {
		return p_sheet_name;
	}

	public void setP_sheet_name(String[] pSheetName) {
		p_sheet_name = pSheetName;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map getReportParameter() {
		parameters = new HashMap();
		parameters.put("PARAM_REPORT_ENGINE", reportEngine);
		parameters.put("PARAM_HEADER_NAME", p_header_name);
//		parameters.put("PARAM_COMPANY", p_company);
//		parameters.put("PARAM_CONTRACT_NO", p_contract_no);
//		parameters.put("PARAM_LOCATION_ID", p_location_id);
//		parameters.put("PARAM_REGION", p_region);
//		parameters.put("PARAM_VENDOR", p_vendor);
//		parameters.put("PARAM_DEPOSIT_TYPE", p_deposit_type);
//		parameters.put("PARAM_PAY_DT", p_pay_dt);
//		parameters.put("PARAM_AS_OF_DT", p_as_of_dt);
		parameters.put("PARAM_COMPANY",p_company);
		parameters.put("PARAM_BG_NO",p_bg_no);
		parameters.put("PARAM_BANK",p_bank);
		parameters.put("PARAM_CONTRACT_NO",p_contract_no);
		parameters.put("PARAM_VENDOR_CODE",p_vendor_code);
		parameters.put("PARAM_LOCATION_CODE",p_location_code);
		parameters.put("PARAM_REGION",p_region);
		parameters.put("PARAM_EXPENSE_TYPE",p_expense_type);
		parameters.put("PARAM_CONTRACT_STATUS",p_contract_status);
		parameters.put("PARAM_NETWORK_STATUS",p_network_status);
		parameters.put("PARAM_DEPOSIT_DT_FROM",p_deposit_datet_from);
		parameters.put("PARAM_DEPOSIT_DT_TO",p_deposit_date_to);
		parameters.put("PARAM_DEPOSIT_TYPE", p_deposit_type);
		parameters.put("PARAM_DEPOSIT_STATUS", p_deposit_status);
		parameters.put("PARAM_USERNAME", p_username);
		parameters.put("PARAM_DISPLAY_EXPENSE_TYPE", p_display_expense_type);
		parameters.put("PARAM_DISPLAY_NETWORK_STATUS", p_display_network_status);
		parameters.put("PARAM_DISPLAY_BANK", p_display_bank);
		parameters.put("PARAM_DISPLAY_CONTRACT_STATUS", p_display_contract_status);
		parameters.put(JRXlsAbstractExporterParameter.SHEET_NAMES, p_sheet_name);
		return parameters;
	}

}
