package th.co.ais.domain.co;

import java.math.BigDecimal;
import java.util.Date;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.annotation.PCell;

public class Mco003InsertBorrowSP  extends AbstractDomain{
	private String pResult;
	private String docNo;
	private String contractNo;
	private String mode;
	private String company;
	private Date recievDt;
	private Date samSendDt;
	private Date samAssignSend;
	private String remark;
	private String user;
	private String pOption;
	private String borrowRequestId;
	private BigDecimal siteNum;
	private String siteInfoId;
	
	//added by NEW borrow contract 2018/12/24
	private String fileType;
	private String approveFlag;
	private String status;
	
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

	public String getpResult() {
		return pResult;
	}

	public void setpResult(String pResult) {
		this.pResult = pResult;
	}

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getRecievDt() {
		return recievDt;
	}

	public void setRecievDt(Date recievDt) {
		this.recievDt = recievDt;
	}

	public Date getSamSendDt() {
		return samSendDt;
	}

	public void setSamSendDt(Date samSendDt) {
		this.samSendDt = samSendDt;
	}

	public Date getSamAssignSend() {
		return samAssignSend;
	}

	public void setSamAssignSend(Date samAssignSend) {
		this.samAssignSend = samAssignSend;
	}

	public String getpOption() {
		return pOption;
	}

	public void setpOption(String pOption) {
		this.pOption = pOption;
	}

	public String getBorrowRequestId() {
		return borrowRequestId;
	}

	public void setBorrowRequestId(String borrowRequestId) {
		this.borrowRequestId = borrowRequestId;
	}

	public BigDecimal getSiteNum() {
		return siteNum;
	}

	public void setSiteNum(BigDecimal siteNum) {
		this.siteNum = siteNum;
	}

	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getApproveFlag() {
		return approveFlag;
	}

	public void setApproveFlag(String approveFlag) {
		this.approveFlag = approveFlag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
