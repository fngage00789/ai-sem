package th.co.ais.domain.el;


import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class MeterInfoHistory extends AbstractDomain implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8068015538988477632L;
	/**
	 * 
	 */
	private String electricId;
	private String warrantId;
	private String warrantType;
	private Date receivedDt;
	private Date printDt;
	private Date sentWarrantDt;
	private Date sentContractDt;
	private Date terminateCutoffDt;
	private Date expandCutoffDt;
	private Date expandNewOnmeterDt;
	private Date transferMeterDt;
	private Date transfercutoffDt;


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

	public String getWarrantId() {
		return warrantId;
	}

	public void setWarrantId(String warrantId) {
		this.warrantId = warrantId;
	}


	public String getElectricId() {
		return electricId;
	}

	public void setElectricId(String electricId) {
		this.electricId = electricId;
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

	public String getWarrantType() {
		return warrantType;
	}

	public void setWarrantType(String warrantType) {
		this.warrantType = warrantType;
	}

}