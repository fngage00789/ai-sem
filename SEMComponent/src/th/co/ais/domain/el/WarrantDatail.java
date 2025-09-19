package th.co.ais.domain.el;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.domain.gm.Province;

@Entity
@Table(name="SEM_EL_WARRANT_DATAIL", schema="SEM")
public class WarrantDatail extends AbstractDomain {

	private static final long serialVersionUID = 1922034166279698539L;
	
	private String rowId;
	private Management electricId;
	private BigDecimal printTimes;
	private String contractNo;
	private String company;
	private String siteName;
	private String locationId;
	private String locationCode;
	private Province province;
	private String warrantType;
	private String meterId;
	private Date receivedDt;
	private Date printDt;
	private Date printDtFrom;
	private Date printDtTo;
	private Date sentSighDt;
	private Date signDt;
	private Date sentWarrantDt;
	private Date sentContractDt;
	private Date sentSamuserDt;
	private Date sentSamuserDtFrom;
	private Date sentSamuserDtTo;
	private String samuserName;
	private String samuserTel;
	private String exportFlag;
	private Date exportDt;
	private BigDecimal version;
	private String recordStatus;
	private String remark;
	private boolean selected = false;
	private boolean disableCheckbox = false;
	private boolean isMaxPrintTimes = false;
	private String siteCode;
	private String region;//WT###Add 20110127
	
	private Date terminateCutoffDt;
	private Date expandCutoffDt;
	private Date expandNewOnmeterDt;
	private Date transferMeterDt;
	private Date transferCutoffDt;
	
	  
	
	@Id
   	@GeneratedValue(generator="system-uuid")
   	@GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="WARRANT_ID")	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "ELECTRIC_ID", nullable = false)
	@JoinColumn(name = "ELECTRIC_ID")
	public Management getElectricId() {
		return electricId;
	}
	public void setElectricId(Management electricId) {
		this.electricId = electricId;
	}
	
	@Column(name="PRINT_TIMES")
	public BigDecimal getPrintTimes() {
		return printTimes;
	}
	public void setPrintTimes(BigDecimal printTimes) {
		this.printTimes = printTimes;
	}
	
	@Column(name="CONTRACT_NO")
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	
	@Column(name="COMPANY")
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Column(name="SITE_NAME")
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	
	@Column(name="LOCATION_ID")
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	
	@Column(name="LOCATION_CODE")
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name = "PROVINCE", nullable = false)
	@JoinColumn(name = "PROVINCE")
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	
	@Column(name="WARRANT_TYPE")
	public String getWarrantType() {
		return warrantType;
	}
	public void setWarrantType(String warrantType) {
		this.warrantType = warrantType;
	}
	
	@Column(name="METER_ID")
	public String getMeterId() {
		return meterId;
	}
	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}
	
	@Column(name="RECEIVED_DT")
	public Date getReceivedDt() {
		return receivedDt;
	}
	public void setReceivedDt(Date receivedDt) {
		this.receivedDt = receivedDt;
	}
	
	@Column(name="PRINT_DT")
	public Date getPrintDt() {
		return printDt;
	}
	public void setPrintDt(Date printDt) {
		this.printDt = printDt;
	}
	
	@Column(name="SENT_SIGN_DT")
	public Date getSentSighDt() {
		return sentSighDt;
	}
	public void setSentSighDt(Date sentSighDt) {
		this.sentSighDt = sentSighDt;
	}
	
	@Column(name="SIGN_DT")
	public Date getSignDt() {
		return signDt;
	}
	public void setSignDt(Date signDt) {
		this.signDt = signDt;
	}
	
	@Column(name="SENT_WARRANT_DT")
	public Date getSentWarrantDt() {
		return sentWarrantDt;
	}
	public void setSentWarrantDt(Date sentWarrantDt) {
		this.sentWarrantDt = sentWarrantDt;
	}
	
	@Column(name="SENT_CONTRACT_DT")
	public Date getSentContractDt() {
		return sentContractDt;
	}
	public void setSentContractDt(Date sentContractDt) {
		this.sentContractDt = sentContractDt;
	}
	
	@Column(name="SENT_SAMUSER_DT")
	public Date getSentSamuserDt() {
		return sentSamuserDt;
	}
	public void setSentSamuserDt(Date sentSamuserDt) {
		this.sentSamuserDt = sentSamuserDt;
	}
	
	@Column(name="SAMUSER_NAME")
	public String getSamuserName() {
		return samuserName;
	}
	public void setSamuserName(String samuserName) {
		this.samuserName = samuserName;
	}
	
	@Column(name="SAMUSER_TEL")
	public String getSamuserTel() {
		return samuserTel;
	}
	public void setSamuserTel(String samuserTel) {
		this.samuserTel = samuserTel;
	}
	
	@Column(name="EXPORT_FLAG")
	public String getExportFlag() {
		return exportFlag;
	}
	public void setExportFlag(String exportFlag) {
		this.exportFlag = exportFlag;
	}
	
	@Column(name="EXPORT_DT")
	public Date getExportDt() {
		return exportDt;
	}
	public void setExportDt(Date exportDt) {
		this.exportDt = exportDt;
	}
	@Column(name="VERSION")
	public BigDecimal getVersion() {
		return version;
	}
	public void setVersion(BigDecimal version) {
		this.version = version;
	}
	
	@Column(name="RECORD_STATUS")
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	
	@Column(name="REMARK")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
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
	
	@Transient
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	@Transient
	public boolean isDisableCheckbox() {
		return disableCheckbox;
	}
	public void setDisableCheckbox(boolean disableCheckbox) {
		this.disableCheckbox = disableCheckbox;
	}
	
	@Transient
	public Date getPrintDtFrom() {
		return printDtFrom;
	}
	public void setPrintDtFrom(Date printDtFrom) {
		this.printDtFrom = printDtFrom;
	}
	
	@Transient
	public Date getPrintDtTo() {
		return printDtTo;
	}
	public void setPrintDtTo(Date printDtTo) {
		this.printDtTo = printDtTo;
	}
	
	@Transient
	public Date getSentSamuserDtFrom() {
		return sentSamuserDtFrom;
	}
	public void setSentSamuserDtFrom(Date sentSamuserDtFrom) {
		this.sentSamuserDtFrom = sentSamuserDtFrom;
	}
	
	@Transient
	public Date getSentSamuserDtTo() {
		return sentSamuserDtTo;
	}
	public void setSentSamuserDtTo(Date sentSamuserDtTo) {
		this.sentSamuserDtTo = sentSamuserDtTo;
	}
	
	public String toString(){		
		String returnStr = "exportFlag="+this.exportFlag+", isMaxPrintTimes="+this.isMaxPrintTimes;
		System.out.println(returnStr);
		return returnStr;
	}
	
	@Transient
	public boolean isMaxPrintTimes() {
		return isMaxPrintTimes;
	}
	public void setMaxPrintTimes(boolean isMaxPrintTimes) {
		this.isMaxPrintTimes = isMaxPrintTimes;
	}
	
	@Column(name="REGION")	
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	@Transient
	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	
	@Column(name="terminate_cutoff_dt")
	public Date getTerminateCutoffDt() {
		return terminateCutoffDt;
	}
	public void setTerminateCutoffDt(Date terminateCutoffDt) {
		this.terminateCutoffDt = terminateCutoffDt;
	}
	
	@Column(name="expand_cutoff_dt")
	public Date getExpandCutoffDt() {
		return expandCutoffDt;
	}
	public void setExpandCutoffDt(Date expandCutoffDt) {
		this.expandCutoffDt = expandCutoffDt;
	}
	
	@Column(name="expand_new_onmeter_dt")
	public Date getExpandNewOnmeterDt() {
		return expandNewOnmeterDt;
	}
	public void setExpandNewOnmeterDt(Date expandNewOnmeterDt) {
		this.expandNewOnmeterDt = expandNewOnmeterDt;
	}
	
	@Column(name="transfer_meter_dt")
	public Date getTransferMeterDt() {
		return transferMeterDt;
	}
	public void setTransferMeterDt(Date transferMeterDt) {
		this.transferMeterDt = transferMeterDt;
	}
	
	@Column(name="transfer_cutoff_dt")
	public Date getTransferCutoffDt() {
		return transferCutoffDt;
	}
	public void setTransferCutoffDt(Date transferCutoffDt) {
		this.transferCutoffDt = transferCutoffDt;
	}
	
}
