package th.co.ais.domain.co;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.annotation.PCell;
import th.co.ais.util.SEMDataUtility;

public class Mco003SearchBorrowSP  extends AbstractDomain{
	private String rowId;
	private String borrowContractId;
	private String returnContractId;
	private String contractNo;
	private String contractNoAdd;
	private String siteName;
	private Date effectiveDt;
	private Date expireDt;
	private String docApproveFlag;
	private String docContractFlag;
	private String remarkDocOther;
	private String borrowForTypeName;
	private String borrowOfficerName;
	private String borrowName;
	private Date borrowDt;
	private String returnName;
	private Date returnDt;
	private String remarkCannotBorrow;
	private String company;
	private String borrowRequestId;
	private int no;
	private String effectiveStr;
	private String expireStr;
	private String borrowStr;
	private String returnStr;
	private String old_contractNo;
	private String cycle;
	private String sequence;
	private String docNo;
	private String lMessage;
	private String cantBorrowFlg;
	private String effDtStr;
	private String expDtStr;
	
	//added by new 21/07/2015
	private String siteAppId;
	private String placeType;
	private String placeTypeRemark;
	private String partiesType;
	private String partiesTypeRemark;
	private String docApproveId;
	private String contractFileType;
	private String result;
	private String borrowStatus;
	private String userId;
	
	private String contractType;
	private String flagSoftfile;
	private String status;
	private String borrowContractType;
	
	@PCell(cellType = String.class, no = 4)
	public String getEffectiveStr() {
		return effectiveStr;
	}
	public void setEffectiveStr(String effectiveStr) {
		this.effectiveStr = effectiveStr;
	}
	@PCell(cellType = String.class, no = 5)
	public String getExpireStr() {
		return expireStr;
	}
	public void setExpireStr(String expireStr) {
		this.expireStr = expireStr;
	}
	@PCell(cellType = String.class, no = 11)
	public String getBorrowStr() {
		return borrowStr;
	}
	public void setBorrowStr(String borrowStr) {
		this.borrowStr = borrowStr;
	}
	@PCell(cellType = String.class, no = 13)
	public String getReturnStr() {
		return returnStr;
	}
	public void setReturnStr(String returnStr) {
		this.returnStr = returnStr;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getBorrowContractId() {
		return borrowContractId;
	}
	public void setBorrowContractId(String borrowContractId) {
		this.borrowContractId = borrowContractId;
	}
	public String getReturnContractId() {
		return returnContractId;
	}
	public void setReturnContractId(String returnContractId) {
		this.returnContractId = returnContractId;
	}
	@PCell(cellType = String.class, no = 2)
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	@PCell(cellType = String.class, no = 3)
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	
	public Date getEffectiveDt() {
		return effectiveDt;
	}
	public void setEffectiveDt(Date effectiveDt) {
		this.effectiveDt = effectiveDt;
	}

	public Date getExpireDt() {
		return expireDt;
	}
	public void setExpireDt(Date expireDt) {
		this.expireDt = expireDt;
	}
	@PCell(cellType = String.class, no = 9)
	public String getDocApproveFlag() {
		return docApproveFlag;
	}
	public void setDocApproveFlag(String docApproveFlag) {
		this.docApproveFlag = docApproveFlag;
	}
	@PCell(cellType = String.class, no = 8)
	public String getDocContractFlag() {
		return docContractFlag;
	}
	public void setDocContractFlag(String docContractFlag) {
		this.docContractFlag = docContractFlag;
	}
	@PCell(cellType = String.class, no = 10)
	public String getRemarkDocOther() {
		return remarkDocOther;
	}
	public void setRemarkDocOther(String remarkDocOther) {
		this.remarkDocOther = remarkDocOther;
	}
	@PCell(cellType = String.class, no = 14)
	public String getBorrowForTypeName() {
		return borrowForTypeName;
	}
	public void setBorrowForTypeName(String borrowForTypeName) {
		this.borrowForTypeName = borrowForTypeName;
	}
	@PCell(cellType = String.class, no = 7)
	public String getBorrowOfficerName() {
		return borrowOfficerName;
	}
	public void setBorrowOfficerName(String borrowOfficerName) {
		this.borrowOfficerName = borrowOfficerName;
	}
	@PCell(cellType = String.class, no = 6)
	public String getBorrowName() {
		return borrowName;
	}
	public void setBorrowName(String borrowName) {
		this.borrowName = borrowName;
	}

	public Date getBorrowDt() {
		return borrowDt;
	}
	public void setBorrowDt(Date borrowDt) {
		this.borrowDt = borrowDt;
	}
	@PCell(cellType = String.class, no = 12)
	public String getReturnName() {
		return returnName;
	}
	public void setReturnName(String returnName) {
		this.returnName = returnName;
	}

	public Date getReturnDt() {
		return returnDt;
	}
	public void setReturnDt(Date returnDt) {
		this.returnDt = returnDt;
	}
	@PCell(cellType = String.class, no = 15)
	public String getRemarkCannotBorrow() {
		return remarkCannotBorrow;
	}
	public void setRemarkCannotBorrow(String remarkCannotBorrow) {
		this.remarkCannotBorrow = remarkCannotBorrow;
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getBorrowRequestId() {
		return borrowRequestId;
	}
	public void setBorrowRequestId(String borrowRequestId) {
		this.borrowRequestId = borrowRequestId;
	}
	public String getContractNoAdd() {
		return contractNoAdd;
	}
	public void setContractNoAdd(String contractNoAdd) {
		this.contractNoAdd = contractNoAdd;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	@PCell(cellType = String.class, no = 0)
	public String getStringNo() {
		return no+"";
	}
	@PCell(cellType = String.class, no = 1)
	public String getOld_contractNo() {
		return old_contractNo;
	}
	public void setOld_contractNo(String oldContractNo) {
		old_contractNo = oldContractNo;
	}
	public String getCycle() {
		return cycle;
	}
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public String getlMessage() {
		return lMessage;
	}
	public void setlMessage(String lMessage) {
		this.lMessage = lMessage;
	}
	public String getCantBorrowFlg() {
		return cantBorrowFlg;
	}
	public void setCantBorrowFlg(String cantBorrowFlg) {
		this.cantBorrowFlg = cantBorrowFlg;
	}
	public String getEffDtStr() {
		try{
			if(effectiveDt != null)
			return SEMDataUtility.converDateToString(effectiveDt);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	public void setEffDtStr(String effDtStr) {
		this.effDtStr = effDtStr;
	}
	public String getExpDtStr() {
		try{
			if(expireDt != null)
			return SEMDataUtility.converDateToString(expireDt);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	public void setExpDtStr(String expDtStr) {
		this.expDtStr = expDtStr;
	}
	public String getSiteAppId() {
		return siteAppId;
	}
	public void setSiteAppId(String siteAppId) {
		this.siteAppId = siteAppId;
	}
	public String getPlaceType() {
		return placeType;
	}
	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}
	public String getPlaceTypeRemark() {
		return placeTypeRemark;
	}
	public void setPlaceTypeRemark(String placeTypeRemark) {
		this.placeTypeRemark = placeTypeRemark;
	}
	public String getPartiesType() {
		return partiesType;
	}
	public void setPartiesType(String partiesType) {
		this.partiesType = partiesType;
	}
	public String getPartiesTypeRemark() {
		return partiesTypeRemark;
	}
	public void setPartiesTypeRemark(String partiesTypeRemark) {
		this.partiesTypeRemark = partiesTypeRemark;
	}
	public String getDocApproveId() {
		return docApproveId;
	}
	public void setDocApproveId(String docApproveId) {
		this.docApproveId = docApproveId;
	}
	public String getContractFileType() {
		return contractFileType;
	}
	public void setContractFileType(String contractFileType) {
		this.contractFileType = contractFileType;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getBorrowStatus() {
		return borrowStatus;
	}
	public void setBorrowStatus(String borrowStatus) {
		this.borrowStatus = borrowStatus;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	public String getFlagSoftfile() {
		return flagSoftfile;
	}
	public void setFlagSoftfile(String flagSoftfile) {
		this.flagSoftfile = flagSoftfile;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBorrowContractType() {
		return borrowContractType;
	}
	public void setBorrowContractType(String borrowContractType) {
		this.borrowContractType = borrowContractType;
	}
	
}
