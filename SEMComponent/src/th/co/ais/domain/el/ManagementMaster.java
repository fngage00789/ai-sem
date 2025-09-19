package th.co.ais.domain.el;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;

@Entity
@Table(name="SEM_EL_MANAGEMENT_MASTER", schema="SEM")
public class ManagementMaster extends AbstractDomain {

	private static final long serialVersionUID = -5270984253073174313L;
	
	@Id
  	@GeneratedValue(generator="system-uuid")
  	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="MANAGEMENT_MASTER_ID")
	private String rowId;
	@Column(name="PROCESS_STATUS_CODE")
	private String processStatusCode = "H";
	@Column(name="CHANGE_TYPE_FLAG")
	private String changeTypeFlag = "H";
	@Column(name="RECEIVE_JOB_FLAG")
	private String receiveJobFlag = "H";
	@Column(name="VERIFY_FLAG")
	private String verifyFlag = "H";
	@Column(name="DEPOSIT_TYPE_FLAG")
	private String depositTypeFlag = "H";
	@Column(name="WARRANT_PRINT_FLAG")
	private String warrantPrintFlag = "H";
	@Column(name="WARRANT_REPRINT_FLAG")
	private String warrantReprintFlag = "H";
	@Column(name="PRIVATE_SPECIAL_FLAG")
	private String privateSpecialFlag = "H";
	@Column(name="WARRANT_DETAIL_FLAG")
	private String warrantDetailFlag = "H";
	@Column(name="EXPAND_FLAG")
	private String expandFlag = "H";
	@Column(name="FEE_FLAG")
	private String feeFlag = "H";
	@Column(name="UPDATE_METER_FLAG")
	private String updateMeterFlag = "H";
	
	@Override
	@Column(name="CREATE_BY")
	public String getCreateBy() {
		return this.createBy;
	}
	@Override
	@Column(name="CREATE_DT")
	public Date getCreateDt() {
		return this.createDt;
	}

	@Override
	@Column(name="UPDATE_BY")
	public String getUpdateBy() {
		return this.updateBy;
	}

	@Override
	@Column(name="UPDATE_DT")
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
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getChangeTypeFlag() {
		return changeTypeFlag;
	}
	public void setChangeTypeFlag(String changeTypeFlag) {
		this.changeTypeFlag = changeTypeFlag;
	}	
	public String getDepositTypeFlag() {		
		return depositTypeFlag;
	}
	public void setDepositTypeFlag(String depositTypeFlag) {
		this.depositTypeFlag = depositTypeFlag;
	}
	public String getWarrantPrintFlag() {
		return warrantPrintFlag;
	}
	public void setWarrantPrintFlag(String warrantPrintFlag) {
		this.warrantPrintFlag = warrantPrintFlag;
	}
	public String getPrivateSpecialFlag() {
		return privateSpecialFlag;
	}
	public void setPrivateSpecialFlag(String privateSpecialFlag) {
		this.privateSpecialFlag = privateSpecialFlag;
	}
	public String getWarrantDetailFlag() {
		return warrantDetailFlag;
	}
	public void setWarrantDetailFlag(String warrantDetailFlag) {
		this.warrantDetailFlag = warrantDetailFlag;
	}
	public String getExpandFlag() {
		return expandFlag;
	}
	public void setExpandFlag(String expandFlag) {
		this.expandFlag = expandFlag;
	}
	public String getFeeFlag() {
		return feeFlag;
	}
	public void setFeeFlag(String feeFlag) {
		this.feeFlag = feeFlag;
	}
	public String getUpdateMeterFlag() {
		return updateMeterFlag;
	}
	public void setUpdateMeterFlag(String updateMeterFlag) {
		this.updateMeterFlag = updateMeterFlag;
	}
	public String getProcessStatusCode() {
		return processStatusCode;
	}
	public void setProcessStatusCode(String processStatusCode) {
		this.processStatusCode = processStatusCode;
	}
	public String getReceiveJobFlag() {
		return receiveJobFlag;
	}
	public void setReceiveJobFlag(String receiveJobFlag) {
		this.receiveJobFlag = receiveJobFlag;
	}
	public String getWarrantReprintFlag() {
		return warrantReprintFlag;
	}
	public void setWarrantReprintFlag(String warrantReprintFlag) {
		this.warrantReprintFlag = warrantReprintFlag;
	}
	public String getVerifyFlag() {
		return verifyFlag;
	}
	public void setVerifyFlag(String verifyFlag) {
		this.verifyFlag = verifyFlag;
	}
	
}
