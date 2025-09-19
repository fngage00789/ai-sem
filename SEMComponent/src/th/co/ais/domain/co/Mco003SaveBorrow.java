package th.co.ais.domain.co;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mco003SaveBorrow extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7673854637806178826L;
	// Parameter OUT
	private String result;
	private String message;
	// Parameter IN
	private String borrowContractId;
	private String borrowName;
	private Date borrowDt;
	private String borrowOfficer;
	private String borrowForType;
	private String remarkBorrowFor;
	private String docApproveFlag;
	private String docContractFlag;
	private String docContractDetail;
	private String docOtherFlag;
	private String remarkDocOther;
	private String cannotBorrowFlag;
	private String remarkCannotBorrow;
	
	private String contractType;
	private String status;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getBorrowContractId() {
		return borrowContractId;
	}

	public void setBorrowContractId(String borrowContractId) {
		this.borrowContractId = borrowContractId;
	}

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

	public String getBorrowOfficer() {
		return borrowOfficer;
	}

	public void setBorrowOfficer(String borrowOfficer) {
		this.borrowOfficer = borrowOfficer;
	}

	public String getBorrowForType() {
		return borrowForType;
	}

	public void setBorrowForType(String borrowForType) {
		this.borrowForType = borrowForType;
	}

	public String getRemarkBorrowFor() {
		return remarkBorrowFor;
	}

	public void setRemarkBorrowFor(String remarkBorrowFor) {
		this.remarkBorrowFor = remarkBorrowFor;
	}

	public String getDocApproveFlag() {
		return docApproveFlag;
	}

	public void setDocApproveFlag(String docApproveFlag) {
		this.docApproveFlag = docApproveFlag;
	}

	public String getDocContractFlag() {
		return docContractFlag;
	}

	public void setDocContractFlag(String docContractFlag) {
		this.docContractFlag = docContractFlag;
	}

	public String getDocContractDetail() {
		return docContractDetail;
	}

	public void setDocContractDetail(String docContractDetail) {
		this.docContractDetail = docContractDetail;
	}

	public String getDocOtherFlag() {
		return docOtherFlag;
	}

	public void setDocOtherFlag(String docOtherFlag) {
		this.docOtherFlag = docOtherFlag;
	}

	public String getRemarkDocOther() {
		return remarkDocOther;
	}

	public void setRemarkDocOther(String remarkDocOther) {
		this.remarkDocOther = remarkDocOther;
	}

	public String getCannotBorrowFlag() {
		return cannotBorrowFlag;
	}

	public void setCannotBorrowFlag(String cannotBorrowFlag) {
		this.cannotBorrowFlag = cannotBorrowFlag;
	}

	public String getRemarkCannotBorrow() {
		return remarkCannotBorrow;
	}

	public void setRemarkCannotBorrow(String remarkCannotBorrow) {
		this.remarkCannotBorrow = remarkCannotBorrow;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
