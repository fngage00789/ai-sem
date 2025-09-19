package th.co.ais.domain.co;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mco005ContractStatusSP extends AbstractDomain{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1940784793982724084L;
	private String rowId;
	private String role;
	private String company;
	private String currentFlag;
	private String contractMode;
	private String contractName;
	private String lovName;
	private String lovCode;
	private String contractId;
	
	public String getContractMode() {
		return contractMode;
	}
	public void setContractMode(String contractMode) {
		this.contractMode = contractMode;
	}
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCurrentFlag() {
		return currentFlag;
	}
	public void setCurrentFlag(String currentFlag) {
		this.currentFlag = currentFlag;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getLovName() {
		return lovName;
	}
	public void setLovName(String lovName) {
		this.lovName = lovName;
	}
	public String getLovCode() {
		return lovCode;
	}
	public void setLovCode(String lovCode) {
		this.lovCode = lovCode;
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

}
