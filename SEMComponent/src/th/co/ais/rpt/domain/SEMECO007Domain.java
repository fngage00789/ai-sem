package th.co.ais.rpt.domain;

import java.math.BigDecimal;
import java.util.List;

import th.co.ais.domain.co.Mco007MasterContractDetailSP;
import th.co.ais.domain.co.Mco007MasterContractSP;
import th.co.ais.util.WrapperBeanObject;

public class SEMECO007Domain extends SEMECO001Domain  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4629716279894191670L;
	
	private String rowId;
	private String contractFormId;
	private String contractFormName;
	private String contractFormTitle;
	private String recordStatus;

	private String contractFormDetailId;
	private String contractFormDetail;
	private BigDecimal contractFormOrder;
	private String contractBold;
	private String contractUnderline;
	private String contractNewline;
	private String mode;
	
	private String createDtStr;
	private String updateDtStr;
	private String userId;
	
	private String retResult;
	private String retRemark; 
	
	private Mco007MasterContractSP masterContractTitleSP;
	private Mco007MasterContractSP masterContractDetailSP;
	private List<Mco007MasterContractSP> masterContractDetailList;
	private List<Mco007MasterContractDetailSP> masterContractRentalList;
	private List<Mco007MasterContractDetailSP> masterContractELList;

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

	public BigDecimal getContractFormOrder() {
		return contractFormOrder;
	}

	public void setContractFormOrder(BigDecimal contractFormOrder) {
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

	public String getContractNewline() {
		return contractNewline;
	}

	public void setContractNewline(String contractNewline) {
		this.contractNewline = contractNewline;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getCreateDtStr() {
		return createDtStr;
	}

	public void setCreateDtStr(String createDtStr) {
		this.createDtStr = createDtStr;
	}

	public String getUpdateDtStr() {
		return updateDtStr;
	}

	public void setUpdateDtStr(String updateDtStr) {
		this.updateDtStr = updateDtStr;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRetResult() {
		return retResult;
	}

	public void setRetResult(String retResult) {
		this.retResult = retResult;
	}

	public String getRetRemark() {
		return retRemark;
	}

	public void setRetRemark(String retRemark) {
		this.retRemark = retRemark;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}


	public List<Mco007MasterContractSP> getMasterContractDetailList() {
		return masterContractDetailList;
	}

	public void setMasterContractDetailList(
			List<Mco007MasterContractSP> masterContractDetailList) {
		this.masterContractDetailList = masterContractDetailList;
	}

	public Mco007MasterContractSP getMasterContractTitleSP() {
		return masterContractTitleSP;
	}

	public void setMasterContractTitleSP(
			Mco007MasterContractSP masterContractTitleSP) {
		this.masterContractTitleSP = masterContractTitleSP;
	}

	public Mco007MasterContractSP getMasterContractDetailSP() {
		return masterContractDetailSP;
	}

	public void setMasterContractDetailSP(
			Mco007MasterContractSP masterContractDetailSP) {
		this.masterContractDetailSP = masterContractDetailSP;
	}

	public List<Mco007MasterContractDetailSP> getMasterContractRentalList() {
		return masterContractRentalList;
	}

	public void setMasterContractRentalList(
			List<Mco007MasterContractDetailSP> masterContractRentalList) {
		this.masterContractRentalList = masterContractRentalList;
	}

	public List<Mco007MasterContractDetailSP> getMasterContractELList() {
		return masterContractELList;
	}

	public void setMasterContractELList(
			List<Mco007MasterContractDetailSP> masterContractELList) {
		this.masterContractELList = masterContractELList;
	}
	
	

}
