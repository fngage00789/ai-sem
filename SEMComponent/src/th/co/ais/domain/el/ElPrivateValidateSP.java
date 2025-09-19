package th.co.ais.domain.el;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class ElPrivateValidateSP extends AbstractDomain implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8403144180742858277L;

	private String contractNo;
	private String meterId;
	private String fromTermPayment;
	private String toTermPayment;
	private String pKwh;
	private String lKwh;
	private String kwhTotal;
	private String unit;
	private String amtNew;
	
	private String result;
	private String remark;
	
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

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getMeterId() {
		return meterId;
	}

	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}

	public String getFromTermPayment() {
		return fromTermPayment;
	}

	public void setFromTermPayment(String fromTermPayment) {
		this.fromTermPayment = fromTermPayment;
	}

	public String getToTermPayment() {
		return toTermPayment;
	}

	public void setToTermPayment(String toTermPayment) {
		this.toTermPayment = toTermPayment;
	}

	public String getpKwh() {
		return pKwh;
	}

	public void setpKwh(String pKwh) {
		this.pKwh = pKwh;
	}

	public String getlKwh() {
		return lKwh;
	}

	public void setlKwh(String lKwh) {
		this.lKwh = lKwh;
	}

	public String getKwhTotal() {
		return kwhTotal;
	}

	public void setKwhTotal(String kwhTotal) {
		this.kwhTotal = kwhTotal;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getAmtNew() {
		return amtNew;
	}

	public void setAmtNew(String amtNew) {
		this.amtNew = amtNew;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	
	/**
	 * 
	 */
	
}
