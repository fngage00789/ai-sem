package th.co.ais.domain.ir;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;

@Entity
@Table(name = "SEM_IR_DRAFT", schema = "SEM")
public class IrDraft extends AbstractDomain implements Serializable {

	private String rowId;
	private String draftNo;
	private String draftType;
	private String company;
	private String networkType;
	private String transferType;
	private String policyType;
	private Date effectDt;
	private Date expireDt;
	private Double insuredAmt;
	private String limitLostFlg;
	private Double limitLost;
	private Double deductAmt;
	private Double premiumRate;
	private Double estPremiumAmt;
	private Double dutyRate;
	private Double dutyAmt;
	private Double vatRate;
	private Double vatAmt;
	private String insuredName;
	private Date agreementDt;
	private Date docDt;
	private String remark;
	private String refMonth;
	private String refYear;
	private String refDocNo;
	private Date refDate;
	private String draftStatus;
	private String recordStatus;
	private Long version;
	private String policyNo;
	private Date policyStartDt;
	private Date policyEndDt;
	private Date policyDt;
	private String policyStartTM1;
	private String policyStartTM2;
	private String policyEndTM1;
	private String policyEndTM2;
	private Double premiumAmt;
	private String contractNo;
	private String refPolicyNo;
	private Long policySeq;
	
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "DRAFT_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return rowId;
	}
	
	@Column(name = "DRAFT_NO", length = 20)
	public String getDraftNo() {
		return draftNo;
	}

	@Column(name = "DRAFT_TYPE", length = 5)
	public String getDraftType() {
		return draftType;
	}
	
	@Column(name = "COMPANY", length = 5)
	public String getCompany() {
		return company;
	}

	@Column(name = "NETWORK_TYPE", length = 5)
	public String getNetworkType() {
		return networkType;
	}

	@Column(name = "TRANSFER_TYPE", length = 5)
	public String getTransferType() {
		return transferType;
	}
	
	@Column(name = "POLICY_TYPE", length = 5)
	public String getPolicyType() {
		return policyType;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EFFECTIVE_DT",  length = 7)
	public Date getEffectDt() {
		return effectDt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EXPIRE_DT",  length = 7)
	public Date getExpireDt() {
		return expireDt;
	}

	@Column(name = "INSURED_AMT", precision = 15)
	public Double getInsuredAmt() {
		return insuredAmt;
	}

	@Column(name = "LIMIT_LOST_FLG",  length = 5)
	public String getLimitLostFlg() {
		return limitLostFlg;
	}

	@Column(name = "LIMIT_LOST",  precision = 15)
	public Double getLimitLost() {
		return limitLost;
	}

	@Column(name = "DEDUCT_AMT",  precision = 15)
	public Double getDeductAmt() {
		return deductAmt;
	}

	@Column(name = "PREMIUM_RATE",  precision = 15)
	public Double getPremiumRate() {
		return premiumRate;
	}

	@Column(name = "EST_PREMIUM_AMT",  precision = 15)
	public Double getEstPremiumAmt() {
		return estPremiumAmt;
	}

	@Column(name = "DUTY_RATE",  precision = 15)
	public Double getDutyRate() {
		return dutyRate;
	}

	@Column(name = "DUTY_AMT",  precision = 15)
	public Double getDutyAmt() {
		return dutyAmt;
	}

	@Column(name = "VAT_RATE",  precision = 15)
	public Double getVatRate() {
		return vatRate;
	}

	@Column(name = "VAT_AMT",  precision = 15)
	public Double getVatAmt() {
		return vatAmt;
	}

	@Column(name = "INSURED_NAME",  length = 250)
	public String getInsuredName() {
		return insuredName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AGREEMENT_DATE",  length = 7)
	public Date getAgreementDt() {
		return agreementDt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DOC_DT",  length = 7)
	public Date getDocDt() {
		return docDt;
	}

	@Column(name = "REMARK",  length = 250)
	public String getRemark() {
		return remark;
	}

	@Column(name = "REF_MONTH",  length = 2)
	public String getRefMonth() {
		return refMonth;
	}

	@Column(name = "REF_YEAR",  length = 4)
	public String getRefYear() {
		return refYear;
	}

	@Column(name = "REF_DOC_NO",  length = 20)
	public String getRefDocNo() {
		return refDocNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "REF_DOC_DT",  length = 7)
	public Date getRefDate() {
		return refDate;
	}

	@Column(name = "DRAFT_STATUS",  length = 5)
	public String getDraftStatus() {
		return draftStatus;
	}

	@Column(name = "RECORD_STATUS",  length = 5)
	public String getRecordStatus() {
		return recordStatus;
	}

	@Column(name = "VERSION", precision = 10, scale = 0)
	public Long getVersion() {
		return version;
	}

	@Column(name = "POLICY_NO",  length = 50)
	public String getPolicyNo() {
		return policyNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "POLICY_START_DT",  length = 7)
	public Date getPolicyStartDt() {
		return policyStartDt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "POLICY_END_DT",  length = 7)
	public Date getPolicyEndDt() {
		return policyEndDt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "POLICY_DT",  length = 7)
	public Date getPolicyDt() {
		return policyDt;
	}

	@Column(name = "POLICY_START_TM1",  length = 2)
	public String getPolicyStartTM1() {
		return policyStartTM1;
	}

	@Column(name = "POLICY_START_TM2",  length = 2)
	public String getPolicyStartTM2() {
		return policyStartTM2;
	}

	@Column(name = "POLICY_END_TM1",  length = 2)
	public String getPolicyEndTM1() {
		return policyEndTM1;
	}

	@Column(name = "POLICY_END_TM2",  length = 2)
	public String getPolicyEndTM2() {
		return policyEndTM2;
	}

	@Column(name = "PREMIUM_AMT",  precision = 15)
	public Double getPremiumAmt() {
		return premiumAmt;
	}

	@Column(name = "CONTRACT_NO",  length = 50)
	public String getContractNo() {
		return contractNo;
	}

	@Column(name = "REF_POLICY_NO",  length = 50)
	public String getRefPolicyNo() {
		return refPolicyNo;
	}

	@Column(name = "POLICY_SEQ", precision = 10, scale = 0)
	public Long getPolicySeq() {
		return policySeq;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public void setDraftNo(String draftNo) {
		this.draftNo = draftNo;
	}

	public void setDraftType(String draftType) {
		this.draftType = draftType;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public void setEffectDt(Date effectDt) {
		this.effectDt = effectDt;
	}

	public void setExpireDt(Date expireDt) {
		this.expireDt = expireDt;
	}

	public void setInsuredAmt(Double insuredAmt) {
		this.insuredAmt = insuredAmt;
	}

	public void setLimitLostFlg(String limitLostFlg) {
		this.limitLostFlg = limitLostFlg;
	}

	public void setLimitLost(Double limitLost) {
		this.limitLost = limitLost;
	}

	public void setDeductAmt(Double deductAmt) {
		this.deductAmt = deductAmt;
	}

	public void setPremiumRate(Double premiumRate) {
		this.premiumRate = premiumRate;
	}

	public void setEstPremiumAmt(Double estPremiumAmt) {
		this.estPremiumAmt = estPremiumAmt;
	}

	public void setDutyRate(Double dutyRate) {
		this.dutyRate = dutyRate;
	}

	public void setDutyAmt(Double dutyAmt) {
		this.dutyAmt = dutyAmt;
	}

	public void setVatRate(Double vatRate) {
		this.vatRate = vatRate;
	}

	public void setVatAmt(Double vatAmt) {
		this.vatAmt = vatAmt;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public void setAgreementDt(Date agreementDt) {
		this.agreementDt = agreementDt;
	}

	public void setDocDt(Date docDt) {
		this.docDt = docDt;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setRefMonth(String refMonth) {
		this.refMonth = refMonth;
	}

	public void setRefYear(String refYear) {
		this.refYear = refYear;
	}

	public void setRefDocNo(String refDocNo) {
		this.refDocNo = refDocNo;
	}

	public void setRefDate(Date refDate) {
		this.refDate = refDate;
	}

	public void setDraftStatus(String draftStatus) {
		this.draftStatus = draftStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public void setPolicyStartDt(Date policyStartDt) {
		this.policyStartDt = policyStartDt;
	}

	public void setPolicyEndDt(Date policyEndDt) {
		this.policyEndDt = policyEndDt;
	}

	public void setPolicyDt(Date policyDt) {
		this.policyDt = policyDt;
	}

	public void setPolicyStartTM1(String policyStartTM1) {
		this.policyStartTM1 = policyStartTM1;
	}

	public void setPolicyStartTM2(String policyStartTM2) {
		this.policyStartTM2 = policyStartTM2;
	}

	public void setPolicyEndTM1(String policyEndTM1) {
		this.policyEndTM1 = policyEndTM1;
	}

	public void setPolicyEndTM2(String policyEndTM2) {
		this.policyEndTM2 = policyEndTM2;
	}

	public void setPremiumAmt(Double premiumAmt) {
		this.premiumAmt = premiumAmt;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public void setRefPolicyNo(String refPolicyNo) {
		this.refPolicyNo = refPolicyNo;
	}

	public void setPolicySeq(Long policySeq) {
		this.policySeq = policySeq;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DT",  length = 7)
	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	
	@Column(name = "CREATE_BY",  length = 50)
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DT",  length = 7)
	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}
	
	@Column(name = "UPDATE_BY",  length = 50)
	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

}
