package th.co.ais.domain.ir;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class DeductibleSP extends AbstractDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7868989972351044214L;

	private String rowId;
	private String deductId;
	private String networkType;
	private String company;
	private String tfType;
	private String tfCode;
	private String lsType;
	private String lsCode;
	private String deductAmt;
	private Date effDt;
	private String networkCode;
	private String cCode;
	
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getDeductId() {
		return deductId;
	}

	public void setDeductId(String deductId) {
		this.deductId = deductId;
	}

	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTfType() {
		return tfType;
	}

	public void setTfType(String tfType) {
		this.tfType = tfType;
	}

	public String getTfCode() {
		return tfCode;
	}

	public void setTfCode(String tfCode) {
		this.tfCode = tfCode;
	}

	public String getLsType() {
		return lsType;
	}

	public void setLsType(String lsType) {
		this.lsType = lsType;
	}

	public String getLsCode() {
		return lsCode;
	}

	public void setLsCode(String lsCode) {
		this.lsCode = lsCode;
	}

	public Date getEffDt() {
		return effDt;
	}

	public void setEffDt(Date effDt) {
		this.effDt = effDt;
	}

	public String getcCode() {
		return cCode;
	}

	public void setcCode(String cCode) {
		this.cCode = cCode;
	}

	@Override
	public String getCreateBy() {
		return this.createBy;
	}

	@Override
	public Date getCreateDt() {
		return this.createDt;
	}

	@Override
	public String getUpdateBy() {
		return this.updateBy;
	}

	@Override
	public Date getUpdateDt() {
		return this.updateDt;
	}

	@Override
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Override
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;	
	}

	@Override
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Override
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	public void setNetworkCode(String networkCode) {
		this.networkCode = networkCode;
	}

	public String getNetworkCode() {
		return networkCode;
	}

	public void setDeductAmt(String deductAmt) {
		this.deductAmt = deductAmt;
	}

	public String getDeductAmt() {
		return deductAmt;
	}

	
}
