package th.co.ais.domain.el;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@org.hibernate.annotations.NamedNativeQuery(
		name = "queryWarrantDetailSP", 
		//query = "call SEM.SEM_SP_EL_WARRANT_SRCH(?, :company, :contractNo, :siteName, :locationId, :locationCode, :warrantType, :exportFlag, :printDtFrom, :printDtTo, :sentSamuserDtFrom, :sentSamuserDtTo, :maxPrintTimesFlag)",
		query = "call SEM_PG_EL_WARRANT_MANAGE_SP_WARRANT_SRCH(?, :company, :region, :province, :contractNo, :siteName, :locationId, " +
				":locationCode, :warrantType, :exportFlag, :warrantStatus, :printDtFrom, :printDtTo, " +
				":sighDtFrom, :sighDtTo, :sentWarrantDtFrom, :sentWarrantDtTo, :sentContractDtFrom, :sentContractDtTo, " +
				":compleateDtFrom, :compleateDtTo, :exportDtFrom, :exportDtTo, :maxPrintTimesFlag, :batchNo, :supplier)",
		callable = true, 
		readOnly = true,
		resultClass = WarrantDetailSP.class)
		
@Entity
public class WarrantDetailSP implements Serializable {

	private static final long serialVersionUID = 1137928449676053552L;
	private static final SimpleDateFormat SDF 	= new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
	
	@Id
	@Column(name = "WARRANT_ID")
	private String rowId;
	
	@Column(name = "REGION")
	private String region;
	
	@Column(name = "ELECTRIC_ID")
	private String electricId;

	@Column(name = "PRINT_TIMES")
	private BigDecimal printTimes;

	@Column(name = "CONTRACT_NO")
	private String contractNo;

	@Column(name = "COMPANY")
	private String company;

	@Column(name = "SITE_NAME")
	private String siteName;

	@Column(name = "LOCATION_ID")
	private String locationId;

	@Column(name = "LOCATION_CODE")
	private String locationCode;

	@Column(name = "PROVINCE")
	private String province;

	@Column(name = "WARRANT_TYPE")
	private String warrantType;

	@Column(name = "METER_ID")
	private String meterId;

	@Column(name = "RECEIVED_DT")
	private Date receivedDt;

	@Column(name = "PRINT_DT")
	private Date printDt;

	@Column(name = "SENT_SIGN_DT")
	private Date sentSignDt;

	@Column(name = "SIGN_DT")
	private Date signDt;

	@Column(name = "SENT_WARRANT_DT")
	private Date sentWarrantDt;

	@Column(name = "SENT_CONTRACT_DT")
	private Date sentContractDt;

	@Column(name = "SENT_SAMUSER_DT")
	private Date sentSamuserDt;

	@Column(name = "SAMUSER_NAME")
	private String samuserName;

	@Column(name = "SAMUSER_TEL")
	private String samuserTel;

	@Column(name = "EXPORT_FLAG")
	private String exportFlag;

	@Column(name = "EXPORT_DT")
	private Date exportDt;

	@Column(name = "VERSION")
	private BigDecimal version;

	@Column(name = "RECORD_STATUS")
	private String recordStatus;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "CREATE_BY")
	private String createBy;

	@Column(name = "CREATE_DT")
	private Date createDt;

	@Column(name = "UPDATE_BY")
	private String updateBy;

	@Column(name = "UPDATE_DT")
	private Date updateDt;
	
	@Column(name = "WARRANT_PROCESS")
	private String warrantProcess;
	
	@Column(name = "WARRANT_PROCESS_CODE")
	private String warrantProcessCode;
	
	@Column(name = "SITE_CODE")
	private String siteCode;
	
	@Column(name = "ELECTRIC_USE_TYPE")
	private String electricUseType;

	@Transient
	private Date printDtFrom;
	@Transient
	private Date printDtTo;
	@Transient
	private Date sentSamuserDtFrom;
	@Transient
	private Date sentSamuserDtTo;
	@Transient
	private boolean selected = false;
	@Transient
	private boolean disableCheckbox = false;
	@Transient
	private boolean isMaxPrintTimes = false;
	@Transient
	private String maxPrintTimesFlag = "N";
	@Transient
	private String warrantStatus;
	// start add by oum 20160616
	@Transient
	private String supplier;
	@Transient
	private String batchNo;
	// end add by oum 20160616
	@Transient
	private String sentSignDtStr;
	@Transient
	private String signDtStr;
	@Transient
	private String sentWarrantDtStr;
	@Transient
	private String sentContractDtStr;
	@Transient
	private String sentSamuserDtStr;
	@Transient
	private String receivedDtStr;
	@Transient
	private String printDtStr;
	@Transient
	private String updateDtStr;
	@Transient
	private Date sentSighDtFrom;
	@Transient
	private Date sentSighDtTo;
	@Transient
	private Date sighDtFrom;
	@Transient
	private Date sighDtTo;
	@Transient
	private Date sentWarrantDtFrom;
	@Transient
	private Date sentWarrantDtTo;
	@Transient
	private Date sentContractDtFrom;
	@Transient
	private Date sentContractDtTo;
	//WT###Add 20110207 Start
	@Transient
	private Date compleateDtFrom;
	@Transient
	private Date compleateDtTo;
	@Transient
	private Date exportDtFrom;
	@Transient
	private Date exportDtTo;
	//WT###Add 20110207 End
	
	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean isDisableCheckbox() {
		return disableCheckbox;
	}

	public void setDisableCheckbox(boolean disableCheckbox) {
		this.disableCheckbox = disableCheckbox;
	}

	public boolean isMaxPrintTimes() {
		return isMaxPrintTimes;
	}

	public void setMaxPrintTimes(boolean isMaxPrintTimes) {
		this.isMaxPrintTimes = isMaxPrintTimes;
	}

	public String getExportFlag() {
		return exportFlag;
	}

	public void setExportFlag(String exportFlag) {
		this.exportFlag = exportFlag;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getElectricId() {
		return electricId;
	}

	public void setElectricId(String electricId) {
		this.electricId = electricId;
	}

	public BigDecimal getPrintTimes() {
		return printTimes;
	}

	public void setPrintTimes(BigDecimal printTimes) {
		this.printTimes = printTimes;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getWarrantType() {
		return warrantType;
	}

	public void setWarrantType(String warrantType) {
		this.warrantType = warrantType;
	}

	public String getMeterId() {
		return meterId;
	}

	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}

	public Date getReceivedDt() {
		return receivedDt;
	}

	public void setReceivedDt(Date receivedDt) {
		this.receivedDt = receivedDt;
	}

	public Date getPrintDt() {
		return printDt;
	}

	public void setPrintDt(Date printDt) {
		this.printDt = printDt;
	}

	public Date getSentSignDt() {
		return sentSignDt;
	}

	public void setSentSignDt(Date sentSignDt) {
		this.sentSignDt = sentSignDt;
	}

	public Date getSignDt() {
		return signDt;
	}

	public void setSignDt(Date signDt) {
		this.signDt = signDt;
	}

	public Date getSentWarrantDt() {
		return sentWarrantDt;
	}

	public void setSentWarrantDt(Date sentWarrantDt) {
		this.sentWarrantDt = sentWarrantDt;
	}

	public Date getSentContractDt() {
		return sentContractDt;
	}

	public void setSentContractDt(Date sentContractDt) {
		this.sentContractDt = sentContractDt;
	}

	public Date getSentSamuserDt() {
		return sentSamuserDt;
	}

	public void setSentSamuserDt(Date sentSamuserDt) {
		this.sentSamuserDt = sentSamuserDt;
	}

	public String getSamuserName() {
		return samuserName;
	}

	public void setSamuserName(String samuserName) {
		this.samuserName = samuserName;
	}

	public String getSamuserTel() {
		return samuserTel;
	}

	public void setSamuserTel(String samuserTel) {
		this.samuserTel = samuserTel;
	}

	public Date getExportDt() {
		return exportDt;
	}

	public void setExportDt(Date exportDt) {
		this.exportDt = exportDt;
	}

	public BigDecimal getVersion() {
		return version;
	}

	public void setVersion(BigDecimal version) {
		this.version = version;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	public String getMaxPrintTimesFlag() {
		return maxPrintTimesFlag;
	}

	public void setMaxPrintTimesFlag(String maxPrintTimesFlag) {
		this.maxPrintTimesFlag = maxPrintTimesFlag;
	}

	public Date getPrintDtFrom() {
		return printDtFrom;
	}

	public void setPrintDtFrom(Date printDtFrom) {
		this.printDtFrom = printDtFrom;
	}

	public Date getPrintDtTo() {
		return printDtTo;
	}

	public void setPrintDtTo(Date printDtTo) {
		this.printDtTo = printDtTo;
	}

	public Date getSentSamuserDtFrom() {
		return sentSamuserDtFrom;
	}

	public void setSentSamuserDtFrom(Date sentSamuserDtFrom) {
		this.sentSamuserDtFrom = sentSamuserDtFrom;
	}

	public Date getSentSamuserDtTo() {
		return sentSamuserDtTo;
	}

	public void setSentSamuserDtTo(Date sentSamuserDtTo) {
		this.sentSamuserDtTo = sentSamuserDtTo;
	}
	//optional
	public String getSentSignDtStr() {
		sentSignDtStr = (null != sentSignDt) ? SDF.format(sentSignDt) : "";
		return sentSignDtStr;
	}

	public String getSignDtStr() {
		signDtStr = (null != signDt) ? SDF.format(signDt) : "";
		return signDtStr;
	}

	public String getSentWarrantDtStr() {
		sentWarrantDtStr = (null != sentWarrantDt) ? SDF.format(sentWarrantDt) : "";
		return sentWarrantDtStr;
	}

	public String getSentContractDtStr() {
		sentContractDtStr = (null != sentContractDt) ? SDF.format(sentContractDt) : "";
		return sentContractDtStr;
	}

	public String getSentSamuserDtStr() {
		sentSamuserDtStr = (null != sentSamuserDt) ? SDF.format(sentSamuserDt) : "";
		return sentSamuserDtStr;
	}
	
	public String getReceivedDtStr(){
		receivedDtStr = (null != receivedDt) ? SDF.format(receivedDt) : "";
		return receivedDtStr;
	}
	
	public String getPrintDtStr(){
		printDtStr = (null != printDt) ? SDF.format(printDt) : "";
		return printDtStr;
	}
	
	public String getUpdateDtStr(){
		updateDtStr = (null != updateDt) ? SDF.format(updateDt) : "";
		return updateDtStr;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setSentSignDtStr(String sentSignDtStr) {
		this.sentSignDtStr = sentSignDtStr;
	}

	public void setSignDtStr(String signDtStr) {
		this.signDtStr = signDtStr;
	}

	public void setSentWarrantDtStr(String sentWarrantDtStr) {
		this.sentWarrantDtStr = sentWarrantDtStr;
	}

	public void setSentContractDtStr(String sentContractDtStr) {
		this.sentContractDtStr = sentContractDtStr;
	}

	public void setSentSamuserDtStr(String sentSamuserDtStr) {
		this.sentSamuserDtStr = sentSamuserDtStr;
	}

	public void setReceivedDtStr(String receivedDtStr) {
		this.receivedDtStr = receivedDtStr;
	}

	public void setPrintDtStr(String printDtStr) {
		this.printDtStr = printDtStr;
	}

	public void setUpdateDtStr(String updateDtStr) {
		this.updateDtStr = updateDtStr;
	}

	public String getWarrantStatus() {
		return warrantStatus;
	}

	public void setWarrantStatus(String warrantStatus) {
		this.warrantStatus = warrantStatus;
	}

	public Date getSentSighDtFrom() {
		return sentSighDtFrom;
	}

	public void setSentSighDtFrom(Date sentSighDtFrom) {
		this.sentSighDtFrom = sentSighDtFrom;
	}

	public Date getSentSighDtTo() {
		return sentSighDtTo;
	}

	public void setSentSighDtTo(Date sentSighDtTo) {
		this.sentSighDtTo = sentSighDtTo;
	}

	public Date getSighDtFrom() {
		return sighDtFrom;
	}

	public void setSighDtFrom(Date sighDtFrom) {
		this.sighDtFrom = sighDtFrom;
	}

	public Date getSighDtTo() {
		return sighDtTo;
	}

	public void setSighDtTo(Date sighDtTo) {
		this.sighDtTo = sighDtTo;
	}

	public Date getSentWarrantDtFrom() {
		return sentWarrantDtFrom;
	}

	public void setSentWarrantDtFrom(Date sentWarrantDtFrom) {
		this.sentWarrantDtFrom = sentWarrantDtFrom;
	}

	public Date getSentWarrantDtTo() {
		return sentWarrantDtTo;
	}

	public void setSentWarrantDtTo(Date sentWarrantDtTo) {
		this.sentWarrantDtTo = sentWarrantDtTo;
	}

	public Date getSentContractDtFrom() {
		return sentContractDtFrom;
	}

	public void setSentContractDtFrom(Date sentContractDtFrom) {
		this.sentContractDtFrom = sentContractDtFrom;
	}

	public Date getSentContractDtTo() {
		return sentContractDtTo;
	}

	public void setSentContractDtTo(Date sentContractDtTo) {
		this.sentContractDtTo = sentContractDtTo;
	}

	public String getWarrantProcess() {
		return warrantProcess;
	}

	public void setWarrantProcess(String warrantProcess) {
		this.warrantProcess = warrantProcess;
	}

	public String getWarrantProcessCode() {
		return warrantProcessCode;
	}

	public void setWarrantProcessCode(String warrantProcessCode) {
		this.warrantProcessCode = warrantProcessCode;
	}

	public Date getCompleateDtFrom() {
		return compleateDtFrom;
	}

	public void setCompleateDtFrom(Date compleateDtFrom) {
		this.compleateDtFrom = compleateDtFrom;
	}

	public Date getCompleateDtTo() {
		return compleateDtTo;
	}

	public void setCompleateDtTo(Date compleateDtTo) {
		this.compleateDtTo = compleateDtTo;
	}

	public Date getExportDtFrom() {
		return exportDtFrom;
	}

	public void setExportDtFrom(Date exportDtFrom) {
		this.exportDtFrom = exportDtFrom;
	}

	public Date getExportDtTo() {
		return exportDtTo;
	}

	public void setExportDtTo(Date exportDtTo) {
		this.exportDtTo = exportDtTo;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getElectricUseType() {
		return electricUseType;
	}

	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}


	
	
}
