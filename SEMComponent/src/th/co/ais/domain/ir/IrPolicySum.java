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
@Table(name="SEM_IR_POLICY_SUM", schema="SEM")
public class IrPolicySum extends AbstractDomain implements Serializable {


//	private String rowId;
	private String draftNo;
	private String policyNo;
	private String company;
	private String networkType;
	private String policyType;
	private String transferType;
	private String region;
	private Double total;
	private Double insureAmount;
	private Double premiumAmount;
	private String recordStatus;
	private Double version;
	private Double vatAmt;
	private Double dutyAmt;
	
	
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "POLICY_SUM_ID", unique = true, nullable = false, length = 50)
	@Override
	public String getRowId() {
		return rowId;
	}
	@Column(name = "DRAFT_NO", length = 20)
	public String getDraftNo() {
		return draftNo;
	}
	@Column(name = "POLICY_NO", length = 20)
	public String getPolicyNo() {
		return policyNo;
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
	@Column(name = "REGION", length = 5)
	public String getRegion() {
		return region;
	}
	@Column(name = "TOTAL", precision = 10, scale = 0)
	public Double getTotal() {
		return total;
	}
	@Column(name = "INSURED_AMT", precision = 15)
	public Double getInsureAmount() {
		return insureAmount;
	}
	@Column(name = "PREMIUM_AMT", precision = 15)
	public Double getPremiumAmount() {
		return premiumAmount;
	}
	@Column(name = "RECORD_STATUS", length = 5)
	public String getRecordStatus() {
		return recordStatus;
	}
	@Column(name = "VERSION", precision = 10, scale = 0)
	public Double getVersion() {
		return version;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public void setDraftNo(String draftNo) {
		this.draftNo = draftNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	
	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}
	public void setRegion(String region) {
		this.region = region;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public void setInsureAmount(Double insureAmount) {
		this.insureAmount = insureAmount;
	}

	public void setPremiumAmount(Double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public void setVersion(Double version) {
		this.version = version;
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
	
	@Column(name = "VAT_AMT", precision = 15)
	public Double getVatAmt() {
		return vatAmt;
	}
	public void setVatAmt(Double vatAmt) {
		this.vatAmt = vatAmt;
	}
	
	@Column(name = "DUTY_AMT", precision = 15)
	public Double getDutyAmt() {
		return dutyAmt;
	}
	public void setDutyAmt(Double dutyAmt) {
		this.dutyAmt = dutyAmt;
	}

}
