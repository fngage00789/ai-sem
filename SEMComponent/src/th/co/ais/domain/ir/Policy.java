package th.co.ais.domain.ir;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="SEM_IR_POLICY", schema="SEM")
public class Policy implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5301527076775281637L;
	private String rowId;
	private String company;
	private String networkType;
	private String transferType;
	private String policyType;
	private Date effDt;
	private Date expDt;
	private Double insuredAmt;
	private Double deductAmt;
	private Double premiumRate;
	private Double estPremiumAmt;
	private Double premiumAmt;
	private Double dutyRate;
	private Double dutyAmt;
	private Double vatRate;
	private Double vatAmt;
	private String insuredName;
	private String draftNo;
	private String policyNo;
	private String refPolicyNo;
	private Date irDate;
	private Date docDate;
	private String remark;
	private String recordStatus;
	private Long version;
	private Date createDt;
	private String createBy;
	private Date updateDt;
	private String updateBy;
	
	private String address;
	private String totalLoacation;
	private String networkTypeDesc;
	private String transferTypeDesc;
	private String policyTypeDesc;
	private String companyDesc;
	private Date policyStartDt;
	private String policyStartTM1;
	private String policyStartTM2;
	private Date policyEndDt;
	private String policyEndTM1;
	private String policyEndTM2;
	private String limitLost;
	private Double limitLostAmt;
	private Double totalPremiumAmt;
	private Date policyDt;
	private String forMonth;
	private String forYear;
	private Date refDate;
	private int periodOfInsurance;
	private int daydiff;
	private boolean limitLostFlag;
	private boolean disableInsured;
	private String pResult;
	private String pRemark;
	
	private String userId;
	
	private String deleteFlag;

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "POLICY_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "COMPANY", nullable = false, length = 5)
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "NETWORK_TYPE", length = 5)
	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	@Column(name = "TRANSFER_TYPE", length = 5)
	public String getTransferType() {
		return transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	@Column(name = "POLICY_TYPE", length = 5)
	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EFF_DT", length = 7)
	public Date getEffDt() {
		return effDt;
	}

	public void setEffDt(Date effDt) {
		this.effDt = effDt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EXP_DT", length = 7)
	public Date getExpDt() {
		return expDt;
	}

	public void setExpDt(Date expDt) {
		this.expDt = expDt;
	}

	@Column(name = "INSURED_AMT", precision = 15)
	public Double getInsuredAmt() {
		return insuredAmt;
	}

	public void setInsuredAmt(Double insuredAmt) {
		this.insuredAmt = insuredAmt;
	}

	@Column(name = "DEDUCT_AMT", precision = 15)
	public Double getDeductAmt() {
		return deductAmt;
	}

	public void setDeductAmt(Double deductAmt) {
		this.deductAmt = deductAmt;
	}

	@Column(name = "PREMIUM_RATE", precision = 11, scale = 8)
	public Double getPremiumRate() {
		return premiumRate;
	}

	public void setPremiumRate(Double premiumRate) {
		this.premiumRate = premiumRate;
	}

	@Column(name = "EST_PREMIUM_AMT", precision = 15)
	public Double getEstPremiumAmt() {
		return estPremiumAmt;
	}

	public void setEstPremiumAmt(Double estPremiumAmt) {
		this.estPremiumAmt = estPremiumAmt;
	}

	@Column(name = "PREMIUM_AMT", precision = 15)
	public Double getPremiumAmt() {
		return premiumAmt;
	}

	public void setPremiumAmt(Double premiumAmt) {
		this.premiumAmt = premiumAmt;
	}

	@Column(name = "DUTY_RATE", precision = 6)
	public Double getDutyRate() {
		return dutyRate;
	}

	public void setDutyRate(Double dutyRate) {
		this.dutyRate = dutyRate;
	}

	@Column(name = "DUTY_AMT", precision = 15)
	public Double getDutyAmt() {
		return dutyAmt;
	}

	public void setDutyAmt(Double dutyAmt) {
		this.dutyAmt = dutyAmt;
	}

	@Column(name = "VAT_RATE", precision = 4)
	public Double getVatRate() {
		return vatRate;
	}

	public void setVatRate(Double vatRate) {
		this.vatRate = vatRate;
	}

	@Column(name = "VAT_AMT", precision = 15)
	public Double getVatAmt() {
		return vatAmt;
	}

	public void setVatAmt(Double vatAmt) {
		this.vatAmt = vatAmt;
	}

	@Column(name = "INSURED_NAME", length = 250)
	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	@Column(name = "DRAFT_NO", length = 20)
	public String getDraftNo() {
		return draftNo;
	}

	public void setDraftNo(String draftNo) {
		this.draftNo = draftNo;
	}

	@Column(name = "POLICY_NO", length = 20)
	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	@Column(name = "REF_POLICY_NO", length = 20)
	public String getRefPolicyNo() {
		return refPolicyNo;
	}

	public void setRefPolicyNo(String refPolicyNo) {
		this.refPolicyNo = refPolicyNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "IR_DATE", length = 7)
	public Date getIrDate() {
		return irDate;
	}

	public void setIrDate(Date irDate) {
		this.irDate = irDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DOC_DATE", length = 7)
	public Date getDocDate() {
		return docDate;
	}

	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}

	@Column(name = "REMARK", length = 250)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "RECORD_STATUS", length = 5)
	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	@Column(name = "VERSION", precision = 10, scale = 0)
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DT", length = 7)
	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	@Column(name = "CREATE_BY", length = 50)
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DT", length = 7)
	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	@Column(name = "UPDATE_BY", length = 50)
	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTotalLoacation() {
		return totalLoacation;
	}

	public void setTotalLoacation(String totalLoacation) {
		this.totalLoacation = totalLoacation;
	}

	public String getNetworkTypeDesc() {
		return networkTypeDesc;
	}

	public void setNetworkTypeDesc(String networkTypeDesc) {
		this.networkTypeDesc = networkTypeDesc;
	}

	public String getTransferTypeDesc() {
		return transferTypeDesc;
	}

	public void setTransferTypeDesc(String transferTypeDesc) {
		this.transferTypeDesc = transferTypeDesc;
	}

	public String getPolicyTypeDesc() {
		return policyTypeDesc;
	}

	public void setPolicyTypeDesc(String policyTypeDesc) {
		this.policyTypeDesc = policyTypeDesc;
	}

	public String getCompanyDesc() {
		return companyDesc;
	}

	public void setCompanyDesc(String companyDesc) {
		this.companyDesc = companyDesc;
	}

	public Date getPolicyStartDt() {
		return policyStartDt;
	}

	public void setPolicyStartDt(Date policyStartDt) {
		this.policyStartDt = policyStartDt;
	}

	public String getPolicyStartTM1() {
		return policyStartTM1;
	}

	public void setPolicyStartTM1(String policyStartTM1) {
		this.policyStartTM1 = policyStartTM1;
	}

	public String getPolicyStartTM2() {
		return policyStartTM2;
	}

	public void setPolicyStartTM2(String policyStartTM2) {
		this.policyStartTM2 = policyStartTM2;
	}

	public Date getPolicyEndDt() {
		return policyEndDt;
	}

	public void setPolicyEndDt(Date policyEndDt) {
		this.policyEndDt = policyEndDt;
	}

	public String getPolicyEndTM1() {
		return policyEndTM1;
	}

	public void setPolicyEndTM1(String policyEndTM1) {
		this.policyEndTM1 = policyEndTM1;
	}

	public String getPolicyEndTM2() {
		return policyEndTM2;
	}

	public void setPolicyEndTM2(String policyEndTM2) {
		this.policyEndTM2 = policyEndTM2;
	}

	public String getLimitLost() {
		return limitLost;
	}

	public void setLimitLost(String limitLost) {
		this.limitLost = limitLost;
	}

	public Double getLimitLostAmt() {
		return limitLostAmt;
	}

	public void setLimitLostAmt(Double limitLostAmt) {
		this.limitLostAmt = limitLostAmt;
	}

	public Double getTotalPremiumAmt() {
		return totalPremiumAmt;
	}

	public void setTotalPremiumAmt(Double totalPremiumAmt) {
		this.totalPremiumAmt = totalPremiumAmt;
	}

	public Date getPolicyDt() {
		return policyDt;
	}

	public void setPolicyDt(Date policyDt) {
		this.policyDt = policyDt;
	}

	public String getForMonth() {
		return forMonth;
	}

	public void setForMonth(String forMonth) {
		this.forMonth = forMonth;
	}

	public String getForYear() {
		return forYear;
	}

	public void setForYear(String forYear) {
		this.forYear = forYear;
	}

	public Date getRefDate() {
		return refDate;
	}

	public void setRefDate(Date refDate) {
		this.refDate = refDate;
	}

	public int getPeriodOfInsurance() {
		return periodOfInsurance;
	}

	public void setPeriodOfInsurance(int periodOfInsurance) {
		this.periodOfInsurance = periodOfInsurance;
	}

	public int getDaydiff() {
		return daydiff;
	}

	public void setDaydiff(int daydiff) {
		this.daydiff = daydiff;
	}

	public boolean isLimitLostFlag() {
		return limitLostFlag;
	}

	public void setLimitLostFlag(boolean limitLostFlag) {
		this.limitLostFlag = limitLostFlag;
	}

	public boolean isDisableInsured() {
		return disableInsured;
	}

	public void setDisableInsured(boolean disableInsured) {
		this.disableInsured = disableInsured;
	}

	public String getpResult() {
		return pResult;
	}

	public void setpResult(String pResult) {
		this.pResult = pResult;
	}

	public String getpRemark() {
		return pRemark;
	}

	public void setpRemark(String pRemark) {
		this.pRemark = pRemark;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}




}