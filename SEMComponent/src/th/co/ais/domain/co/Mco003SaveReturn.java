package th.co.ais.domain.co;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mco003SaveReturn extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2028676449381390506L;
	// Parameter OUT
	private String result;

	// Parameter IN
	private String borrowContractId;
	private String returnName;
	private Date returnDt;
	private String returnOfficer;
	private String returnNotAllFlag;
	private Date returnNotAllDt;
	private String docApproveFlag;
	private String docContractFlag;
	private String docContractDetail;
	private String docOtherFlag;
	private String remarkDocOther;
	private String docOtherAddFlag;
	private String rentType;
	private String rentTypeOtherRemark;
	private String doc1;
	private String doc2;
	private String doc3;
	private String doc4;
	private String doc5;
	private String doc6;
	private String doc7;
	private String doc8;
	private String doc9;
	private String doc10;
	private String docOther;
	private String docOtherRemark;
	//added by new 2015/07/19
	private String docRemark;
	
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

	public String getReturnOfficer() {
		return returnOfficer;
	}

	public void setReturnOfficer(String returnOfficer) {
		this.returnOfficer = returnOfficer;
	}

	public String getReturnNotAllFlag() {
		return returnNotAllFlag;
	}

	public void setReturnNotAllFlag(String returnNotAllFlag) {
		this.returnNotAllFlag = returnNotAllFlag;
	}

	public Date getReturnNotAllDt() {
		return returnNotAllDt;
	}

	public void setReturnNotAllDt(Date returnNotAllDt) {
		this.returnNotAllDt = returnNotAllDt;
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

	public String getDocOtherAddFlag() {
		return docOtherAddFlag;
	}

	public void setDocOtherAddFlag(String docOtherAddFlag) {
		this.docOtherAddFlag = docOtherAddFlag;
	}

	public String getRentType() {
		return rentType;
	}

	public void setRentType(String rentType) {
		this.rentType = rentType;
	}

	public String getRentTypeOtherRemark() {
		return rentTypeOtherRemark;
	}

	public void setRentTypeOtherRemark(String rentTypeOtherRemark) {
		this.rentTypeOtherRemark = rentTypeOtherRemark;
	}

	public String getDoc1() {
		return doc1;
	}

	public void setDoc1(String doc1) {
		this.doc1 = doc1;
	}

	public String getDoc2() {
		return doc2;
	}

	public void setDoc2(String doc2) {
		this.doc2 = doc2;
	}

	public String getDoc3() {
		return doc3;
	}

	public void setDoc3(String doc3) {
		this.doc3 = doc3;
	}

	public String getDoc4() {
		return doc4;
	}

	public void setDoc4(String doc4) {
		this.doc4 = doc4;
	}

	public String getDoc5() {
		return doc5;
	}

	public void setDoc5(String doc5) {
		this.doc5 = doc5;
	}

	public String getDoc6() {
		return doc6;
	}

	public void setDoc6(String doc6) {
		this.doc6 = doc6;
	}

	public String getDoc7() {
		return doc7;
	}

	public void setDoc7(String doc7) {
		this.doc7 = doc7;
	}

	public String getDoc8() {
		return doc8;
	}

	public void setDoc8(String doc8) {
		this.doc8 = doc8;
	}

	public String getDoc9() {
		return doc9;
	}

	public void setDoc9(String doc9) {
		this.doc9 = doc9;
	}

	public String getDoc10() {
		return doc10;
	}

	public void setDoc10(String doc10) {
		this.doc10 = doc10;
	}

	public String getDocOther() {
		return docOther;
	}

	public void setDocOther(String docOther) {
		this.docOther = docOther;
	}

	public String getDocOtherRemark() {
		return docOtherRemark;
	}

	public void setDocOtherRemark(String docOtherRemark) {
		this.docOtherRemark = docOtherRemark;
	}

	public String getDocRemark() {
		return docRemark;
	}

	public void setDocRemark(String docRemark) {
		this.docRemark = docRemark;
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
