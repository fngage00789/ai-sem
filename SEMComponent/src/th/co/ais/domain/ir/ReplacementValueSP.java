package th.co.ais.domain.ir;


import java.util.Date;

import th.co.ais.domain.AbstractDomain;


public class ReplacementValueSP extends AbstractDomain  {

	private static final long serialVersionUID = 5831828957206664291L;

	protected String rowId;
	
	protected String networkType;
	
	protected String company;
	
	protected String tfType;
	
	protected Double replRate;
	
	protected Date effDt;
	
	protected String networkCode;
	
	protected String cCode;
	
	protected String tfCode;
	
	protected String replRowId;

	public String getReplRowId() {
		return replRowId;
	}

	public void setReplRowId(String replRowId) {
		this.replRowId = replRowId;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
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

	
	public Double getReplRate() {
		return replRate;
	}

	public void setReplRate(Double replRate) {
		this.replRate = replRate;
	}


	public String getNetworkCode() {
		return networkCode;
	}

	public void setNetworkCode(String networkCode) {
		this.networkCode = networkCode;
	}

	public String getcCode() {
		return cCode;
	}

	public void setcCode(String cCode) {
		this.cCode = cCode;
	}

	public String getTfCode() {
		return tfCode;
	}

	public void setTfCode(String tfCode) {
		this.tfCode = tfCode;
	}


	public Date getEffDt() {
		return effDt;
	}

	public void setEffDt(Date effDt) {
		this.effDt = effDt;
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
	
	
	
	
	
	
	
	
	
}
