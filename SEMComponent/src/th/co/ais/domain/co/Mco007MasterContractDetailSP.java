package th.co.ais.domain.co;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mco007MasterContractDetailSP extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -180507059421007623L;
	
	private String rowId;
	private String contractFormId;
	private String contractFormName;
	private String contractFormTitle;
	private String recordStatus;
	
	
	private String contractFormDetailId;
	private String contractFormDetail;
	private String contractFormOrder;
	private String contractBold;
	private String contractUnderline;
	
	private String paramId;
	private String paramCode;
	private String paramName;
	
	private String rentalDetail;
	private String rentalVat;
	private String rentalPayPeriodType;
	
	private String elType;
	private String elDetail;
	private String whtType;
	private String payPeriodType;

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getContractFormId() {
		return contractFormId;
	}

	public void setContractFormId(String contractFormId) {
		this.contractFormId = contractFormId;
	}

	public String getContractFormName() {
		return contractFormName;
	}

	public void setContractFormName(String contractFormName) {
		this.contractFormName = contractFormName;
	}

	public String getContractFormTitle() {
		return contractFormTitle;
	}

	public void setContractFormTitle(String contractFormTitle) {
		this.contractFormTitle = contractFormTitle;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getContractFormDetailId() {
		return contractFormDetailId;
	}

	public void setContractFormDetailId(String contractFormDetailId) {
		this.contractFormDetailId = contractFormDetailId;
	}

	public String getContractFormDetail() {
		return contractFormDetail;
	}

	public void setContractFormDetail(String contractFormDetail) {
		this.contractFormDetail = contractFormDetail;
	}

	public String getContractFormOrder() {
		return contractFormOrder;
	}

	public void setContractFormOrder(String contractFormOrder) {
		this.contractFormOrder = contractFormOrder;
	}

	public String getContractBold() {
		return contractBold;
	}

	public void setContractBold(String contractBold) {
		this.contractBold = contractBold;
	}

	public String getContractUnderline() {
		return contractUnderline;
	}

	public void setContractUnderline(String contractUnderline) {
		this.contractUnderline = contractUnderline;
	}

	public String getParamId() {
		return paramId;
	}

	public void setParamId(String paramId) {
		this.paramId = paramId;
	}

	public String getParamCode() {
		return paramCode;
	}

	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getRentalDetail() {
		return rentalDetail;
	}

	public void setRentalDetail(String rentalDetail) {
		this.rentalDetail = rentalDetail;
	}

	public String getRentalVat() {
		return rentalVat;
	}

	public void setRentalVat(String rentalVat) {
		this.rentalVat = rentalVat;
	}

	public String getRentalPayPeriodType() {
		return rentalPayPeriodType;
	}

	public void setRentalPayPeriodType(String rentalPayPeriodType) {
		this.rentalPayPeriodType = rentalPayPeriodType;
	}

	public String getElType() {
		return elType;
	}

	public void setElType(String elType) {
		this.elType = elType;
	}

	public String getElDetail() {
		return elDetail;
	}

	public void setElDetail(String elDetail) {
		this.elDetail = elDetail;
	}

	public String getWhtType() {
		return whtType;
	}

	public void setWhtType(String whtType) {
		this.whtType = whtType;
	}

	public String getPayPeriodType() {
		return payPeriodType;
	}

	public void setPayPeriodType(String payPeriodType) {
		this.payPeriodType = payPeriodType;
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
