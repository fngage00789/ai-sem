package th.co.ais.domain.co;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mco003SrchBorrowRequestSP extends AbstractDomain{
	
	private static final long serialVersionUID = 5019054055976337755L;
	
	private String rowId;
	private String company;
	private String docNo;
	private String contractNo;
	private Date receiveDt;
	private Date samSendDt;
	private Date samAssignSendDt;
	private String remark;
	private Integer siteNum;
	private Integer siteBorrowNum;
	private Integer siteRemainNum;
	
	private String receiveDtStr;
	private String samSendDtStr;
	private String samAssignSendDtStr;
	
	private Integer siteSendNum;
	private Integer siteNotSendNum;
	private Integer siteApproveNum;
	private Integer siteRejectNum;
	
	private String status;
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
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

	public Date getReceiveDt() {
		return receiveDt;
	}

	public void setReceiveDt(Date receiveDt) {
		this.receiveDt = receiveDt;
	}

	public Date getSamSendDt() {
		return samSendDt;
	}

	public void setSamSendDt(Date samSendDt) {
		this.samSendDt = samSendDt;
	}

	public Date getSamAssignSendDt() {
		return samAssignSendDt;
	}

	public void setSamAssignSendDt(Date samAssignSendDt) {
		this.samAssignSendDt = samAssignSendDt;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getSiteNum() {
		return siteNum;
	}

	public void setSiteNum(Integer siteNum) {
		this.siteNum = siteNum;
	}

	public Integer getSiteBorrowNum() {
		return siteBorrowNum;
	}

	public void setSiteBorrowNum(Integer siteBorrowNum) {
		this.siteBorrowNum = siteBorrowNum;
	}

	public Integer getSiteRemainNum() {
		return siteRemainNum;
	}

	public void setSiteRemainNum(Integer siteRemainNum) {
		this.siteRemainNum = siteRemainNum;
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

	public String getReceiveDtStr() {
		return receiveDtStr;
	}

	public void setReceiveDtStr(String receiveDtStr) {
		this.receiveDtStr = receiveDtStr;
	}

	public String getSamSendDtStr() {
		return samSendDtStr;
	}

	public void setSamSendDtStr(String samSendDtStr) {
		this.samSendDtStr = samSendDtStr;
	}

	public String getSamAssignSendDtStr() {
		return samAssignSendDtStr;
	}

	public void setSamAssignSendDtStr(String samAssignSendDtStr) {
		this.samAssignSendDtStr = samAssignSendDtStr;
	}

	public Integer getSiteSendNum() {
		return siteSendNum;
	}

	public void setSiteSendNum(Integer siteSendNum) {
		this.siteSendNum = siteSendNum;
	}

	public Integer getSiteNotSendNum() {
		return siteNotSendNum;
	}

	public void setSiteNotSendNum(Integer siteNotSendNum) {
		this.siteNotSendNum = siteNotSendNum;
	}

	public Integer getSiteApproveNum() {
		return siteApproveNum;
	}

	public void setSiteApproveNum(Integer siteApproveNum) {
		this.siteApproveNum = siteApproveNum;
	}

	public Integer getSiteRejectNum() {
		return siteRejectNum;
	}

	public void setSiteRejectNum(Integer siteRejectNum) {
		this.siteRejectNum = siteRejectNum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
