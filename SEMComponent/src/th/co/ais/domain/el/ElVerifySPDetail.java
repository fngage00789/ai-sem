package th.co.ais.domain.el;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class ElVerifySPDetail extends AbstractDomain implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5976707478808908686L;
	private String rowId;
	private String contractNo;
	private String importTransId;
	private String transId;
	private String username;
	private String result;
	private String remark;
	private String errorCode;
	
	private String siteInfoId;
	private String serviceId;
	private String serviceName;
	private Double configRate;
	private String inputAmt;
	private String inputPercent;
	
	private String rentalCalCode;
	private String periodAmt;
	private String serviceList;
	
	private String vResult;
	private String vMessage;
	
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
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getImportTransId() {
		return importTransId;
	}
	public void setImportTransId(String importTransId) {
		this.importTransId = importTransId;
	}
	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getInputAmt() {
		return inputAmt;
	}
	public void setInputAmt(String inputAmt) {
		this.inputAmt = inputAmt;
	}
	public String getInputPercent() {
		return inputPercent;
	}
	public void setInputPercent(String inputPercent) {
		this.inputPercent = inputPercent;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public Double getConfigRate() {
		return configRate;
	}
	public void setConfigRate(Double configRate) {
		this.configRate = configRate;
	}
	public String getRentalCalCode() {
		return rentalCalCode;
	}
	public void setRentalCalCode(String rentalCalCode) {
		this.rentalCalCode = rentalCalCode;
	}
	public String getPeriodAmt() {
		return periodAmt;
	}
	public void setPeriodAmt(String periodAmt) {
		this.periodAmt = periodAmt;
	}
	public String getServiceList() {
		return serviceList;
	}
	public void setServiceList(String serviceList) {
		this.serviceList = serviceList;
	}
	public String getvResult() {
		return vResult;
	}
	public void setvResult(String vResult) {
		this.vResult = vResult;
	}
	public String getvMessage() {
		return vMessage;
	}
	public void setvMessage(String vMessage) {
		this.vMessage = vMessage;
	}
	
	
	/**
	 * 
	 */

}
