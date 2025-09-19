package th.co.ais.domain.el;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class ElectricUploadMeterPermissionWarrant extends AbstractDomain{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8979954717847780991L;
	private String rowId;
	private String itemNo;
	private String lineNo;
	private String contractNo;	
	private String siteName;	
	private String locationId;
	private String locationCode;	
	private String transformerLabel;
	private String transformerSize;
	private String transformerSerial;	
	private String transformerDt;
	private String meterSize;
	private String meterWire;
	private String onMeterDt;
	private String areaCode;
	private String meterId;
	private String areaName;
	private String remark;
	private String status;
	private String errorCode;
	private String errorDesc;
	private String recordStatus;
	private String processStatusCode;
	private String processStatusDesc;
	private String meterType;
	private String rate;
	private String siteCode;
	private String fee;
	private String user;
	private String fileName;
	private String result;
	private String logId;
	private String subSentDetailDt;
	private String supplier;
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
	public String getItemNo() {
		return itemNo;
	}
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}
	public String getLineNo() {
		return lineNo;
	}
	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	public String getTransformerLabel() {
		return transformerLabel;
	}
	public void setTransformerLabel(String transformerLabel) {
		this.transformerLabel = transformerLabel;
	}
	public String getTransformerSize() {
		return transformerSize;
	}
	public void setTransformerSize(String transformerSize) {
		this.transformerSize = transformerSize;
	}
	public String getTransformerSerial() {
		return transformerSerial;
	}
	public void setTransformerSerial(String transformerSerial) {
		this.transformerSerial = transformerSerial;
	}
	public String getTransformerDt() {
		return transformerDt;
	}
	public void setTransformerDt(String transformerDt) {
		this.transformerDt = transformerDt;
	}
	public String getMeterSize() {
		return meterSize;
	}
	public void setMeterSize(String meterSize) {
		this.meterSize = meterSize;
	}
	public String getMeterWire() {
		return meterWire;
	}
	public void setMeterWire(String meterWire) {
		this.meterWire = meterWire;
	}
	public String getOnMeterDt() {
		return onMeterDt;
	}
	public void setOnMeterDt(String onMeterDt) {
		this.onMeterDt = onMeterDt;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getMeterId() {
		return meterId;
	}
	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	public String getProcessStatusCode() {
		return processStatusCode;
	}
	public void setProcessStatusCode(String processStatusCode) {
		this.processStatusCode = processStatusCode;
	}
	public String getProcessStatusDesc() {
		return processStatusDesc;
	}
	public void setProcessStatusDesc(String processStatusDesc) {
		this.processStatusDesc = processStatusDesc;
	}
	public String getMeterType() {
		return meterType;
	}
	public void setMeterType(String meterType) {
		this.meterType = meterType;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public String getSubSentDetailDt() {
		return subSentDetailDt;
	}
	public void setSubSentDetailDt(String subSentDetailDt) {
		this.subSentDetailDt = subSentDetailDt;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	
}
