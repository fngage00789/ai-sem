package th.co.ais.domain.el;


import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class MeterInfoSP extends AbstractDomain implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8068015538988477632L;
	/**
	 * 
	 */
	private String eMeterRate;
	private String eTransformerType;
	private String eMeterType;
	private String electricUseType;
	private String fileType;
	private String pResult;
	private String pRemark;
	private String meterTypeFlag;
	private String meterRate;
	private String transformerType;
	
	private String electricId;
	private String warrantId;
	private String warrntType;
	private Date receivedDt;
	private Date printDt;
	private Date sentWarrantDt;
	private Date sentContractDt;
	private Date terminateCutoffDt;
	private Date expandCutoffDt;
	private Date expandNewOnmeterDt;
	private Date transferMeterDt;
	private Date transfercutoffDt;
	
	
	public String geteMeterRate() {
		return eMeterRate;
	}

	public void seteMeterRate(String eMeterRate) {
		this.eMeterRate = eMeterRate;
	}

	public String geteTransformerType() {
		return eTransformerType;
	}

	public void seteTransformerType(String eTransformerType) {
		this.eTransformerType = eTransformerType;
	}

	public String geteMeterType() {
		return eMeterType;
	}

	public void seteMeterType(String eMeterType) {
		this.eMeterType = eMeterType;
	}

	public String getElectricUseType() {
		return electricUseType;
	}

	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getpResult() {
		return pResult;
	}

	public void setpResult(String pResult) {
		this.pResult = pResult;
	}

	public String getpRemark() {
		return pRemark;
	}

	public void setpRemark(String pRemark) {
		this.pRemark = pRemark;
	}

	public String getMeterTypeFlag() {
		return meterTypeFlag;
	}

	public void setMeterTypeFlag(String meterTypeFlag) {
		this.meterTypeFlag = meterTypeFlag;
	}

	public String getMeterRate() {
		return meterRate;
	}

	public void setMeterRate(String meterRate) {
		this.meterRate = meterRate;
	}

	public String getTransformerType() {
		return transformerType;
	}

	public void setTransformerType(String transformerType) {
		this.transformerType = transformerType;
	}

	@Override
	public String getCreateBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getCreateDt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUpdateBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getUpdateDt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCreateBy(String createBy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCreateDt(Date createDt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUpdateBy(String updateBy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUpdateDt(Date updateDt) {
		// TODO Auto-generated method stub
		
	}

	public String getElectricId() {
		return electricId;
	}

	public void setElectricId(String electricId) {
		this.electricId = electricId;
	}

	public String getWarrantId() {
		return warrantId;
	}

	public void setWarrantId(String warrantId) {
		this.warrantId = warrantId;
	}

	public String getWarrntType() {
		return warrntType;
	}

	public void setWarrntType(String warrntType) {
		this.warrntType = warrntType;
	}

	public Date getReceivedDt() {
		return receivedDt;
	}

	public void setReceivedDt(Date receivedDt) {
		this.receivedDt = receivedDt;
	}

	public Date getPrintDt() {
		return printDt;
	}

	public void setPrintDt(Date printDt) {
		this.printDt = printDt;
	}

	public Date getSentWarrantDt() {
		return sentWarrantDt;
	}

	public void setSentWarrantDt(Date sentWarrantDt) {
		this.sentWarrantDt = sentWarrantDt;
	}

	public Date getSentContractDt() {
		return sentContractDt;
	}

	public void setSentContractDt(Date sentContractDt) {
		this.sentContractDt = sentContractDt;
	}

	public Date getTerminateCutoffDt() {
		return terminateCutoffDt;
	}

	public void setTerminateCutoffDt(Date terminateCutoffDt) {
		this.terminateCutoffDt = terminateCutoffDt;
	}

	public Date getExpandCutoffDt() {
		return expandCutoffDt;
	}

	public void setExpandCutoffDt(Date expandCutoffDt) {
		this.expandCutoffDt = expandCutoffDt;
	}

	public Date getExpandNewOnmeterDt() {
		return expandNewOnmeterDt;
	}

	public void setExpandNewOnmeterDt(Date expandNewOnmeterDt) {
		this.expandNewOnmeterDt = expandNewOnmeterDt;
	}

	public Date getTransferMeterDt() {
		return transferMeterDt;
	}

	public void setTransferMeterDt(Date transferMeterDt) {
		this.transferMeterDt = transferMeterDt;
	}

	public Date getTransfercutoffDt() {
		return transfercutoffDt;
	}

	public void setTransfercutoffDt(Date transfercutoffDt) {
		this.transfercutoffDt = transfercutoffDt;
	}
	
	
}
