package th.co.ais.domain.ir;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mir013Edt extends AbstractDomain {

	private String ResultMsg;
	private String pRemark;
	private String claimId;
	private Double claimAmt;
	private String insurChqNo;
	private Date insurChqDt;
	private String insurRecpNo;
	private Date insurRecpDt;
	private String transferFlg;
	private Double tfChqAmt;
	private String tfChqNo;
	private Date tfChqDt;
	private String litigantFlg;
	private Double litigantAmt;
	private String litigantRecpNo;
	private Date litigantRecpDt;
	private String claimStatus;
	private String remark;
	private String policyNo;
	private String draftNo;
	private Date effDt;
	private Date expDt;
	
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

	public String getResultMsg() {
		return ResultMsg;
	}

	public void setResultMsg(String resultMsg) {
		ResultMsg = resultMsg;
	}

	public String getpRemark() {
		return pRemark;
	}

	public void setpRemark(String pRemark) {
		this.pRemark = pRemark;
	}

	public String getClaimId() {
		return claimId;
	}

	public void setClaimId(String claimId) {
		this.claimId = claimId;
	}

	public Double getClaimAmt() {
		return claimAmt;
	}

	public void setClaimAmt(Double claimAmt) {
		this.claimAmt = claimAmt;
	}

	public String getInsurChqNo() {
		return insurChqNo;
	}

	public void setInsurChqNo(String insurChqNo) {
		this.insurChqNo = insurChqNo;
	}

	public Date getInsurChqDt() {
		return insurChqDt;
	}

	public void setInsurChqDt(Date insurChqDt) {
		this.insurChqDt = insurChqDt;
	}

	public String getInsurRecpNo() {
		return insurRecpNo;
	}

	public void setInsurRecpNo(String insurRecpNo) {
		this.insurRecpNo = insurRecpNo;
	}

	public Date getInsurRecpDt() {
		return insurRecpDt;
	}

	public void setInsurRecpDt(Date insurRecpDt) {
		this.insurRecpDt = insurRecpDt;
	}

	public String getTransferFlg() {
		return transferFlg;
	}

	public void setTransferFlg(String transferFlg) {
		this.transferFlg = transferFlg;
	}

	public Double getTfChqAmt() {
		return tfChqAmt;
	}

	public void setTfChqAmt(Double tfChqAmt) {
		this.tfChqAmt = tfChqAmt;
	}

	public String getTfChqNo() {
		return tfChqNo;
	}

	public void setTfChqNo(String tfChqNo) {
		this.tfChqNo = tfChqNo;
	}

	public Date getTfChqDt() {
		return tfChqDt;
	}

	public void setTfChqDt(Date tfChqDt) {
		this.tfChqDt = tfChqDt;
	}

	public String getLitigantFlg() {
		return litigantFlg;
	}

	public void setLitigantFlg(String litigantFlg) {
		this.litigantFlg = litigantFlg;
	}

	public Double getLitigantAmt() {
		return litigantAmt;
	}

	public void setLitigantAmt(Double litigantAmt) {
		this.litigantAmt = litigantAmt;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLitigantRecpNo() {
		return litigantRecpNo;
	}

	public void setLitigantRecpNo(String litigantRecpNo) {
		this.litigantRecpNo = litigantRecpNo;
	}

	public Date getLitigantRecpDt() {
		return litigantRecpDt;
	}

	public void setLitigantRecpDt(Date litigantRecpDt) {
		this.litigantRecpDt = litigantRecpDt;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getDraftNo() {
		return draftNo;
	}

	public void setDraftNo(String draftNo) {
		this.draftNo = draftNo;
	}

	public Date getEffDt() {
		return effDt;
	}

	public void setEffDt(Date effDt) {
		this.effDt = effDt;
	}

	public Date getExpDt() {
		return expDt;
	}

	public void setExpDt(Date expDt) {
		this.expDt = expDt;
	}

}
