package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;

//import th.co.ais.domain.ir.IrClaim;

/**
 * @author Warawit Kitmongkonsak
 * 
 */
public class SEMMIR012ReportParameter extends ReportParameter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4966565200855117162L;
	// Criteria For Jsp Input Parameters
	private String irClaimId;
	private String userName;
	private String provinceName;
	private String TransferTypeDesc;
	private String lossTypeDesc;
	private String lossSubTypeDesc;
	private String claimStatusDescl;

	public String getIrClaimId() {
		return irClaimId;
	}

	public void setIrClaimId(String irClaimId) {
		this.irClaimId = irClaimId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getTransferTypeDesc() {
		return TransferTypeDesc;
	}

	public void setTransferTypeDesc(String transferTypeDesc) {
		TransferTypeDesc = transferTypeDesc;
	}

	public String getLossTypeDesc() {
		return lossTypeDesc;
	}

	public void setLossTypeDesc(String lossTypeDesc) {
		this.lossTypeDesc = lossTypeDesc;
	}

	public String getLossSubTypeDesc() {
		return lossSubTypeDesc;
	}

	public void setLossSubTypeDesc(String lossSubTypeDesc) {
		this.lossSubTypeDesc = lossSubTypeDesc;
	}

	public String getClaimStatusDescl() {
		return claimStatusDescl;
	}

	public void setClaimStatusDescl(String claimStatusDescl) {
		this.claimStatusDescl = claimStatusDescl;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map getReportParameter() {
		parameters = new HashMap();
		parameters.put("PARAM_REPORT_ENGINE", reportEngine);
		parameters.put("PARAM_IR_CLAIM_ID", irClaimId);
		parameters.put("PARAM_user_name", userName);
		parameters.put("PARAM_PROVINCE_NAME", provinceName);
		parameters.put("PARAM_TRANSFER_TYPE", TransferTypeDesc);
		parameters.put("PARAM_LOSS_TYPE", lossTypeDesc);
		parameters.put("PARAM_LOSS_SUB_TYPE", lossSubTypeDesc);
		parameters.put("PARAM_CLAIM_STATUS", claimStatusDescl);
	
		
		return parameters;
	}
}
