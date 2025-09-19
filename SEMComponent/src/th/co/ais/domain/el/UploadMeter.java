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

@Entity(name="th.co.ais.domain.el.UploadMeter")
@Table(name="SEM_EL_UPLOAD_METER", schema="SEM")
public class UploadMeter extends AbstractDomain {

	private static final long serialVersionUID = 1720699415597678797L;
	
	private String rowId;
	private UploadMeterFile meterFile;
	private BigDecimal itemNo;
	private String contractNo;	
	private String siteName;	
	private String locationId;
	private String locationCode;	
	private String transformerLabel;
	private String transformerSize;
	private String transformerSerial;	
	private Date transformerDt;
	private String meterSize;
	private String meterWire;
	private Date onMeterDt;
	private String areaCode;
	private String meterId;
	private String areaName;
	private String remark;
	private String status;
	private String errorCode;
	private String errorDesc;
	private String recordStatus;
	private String processStatusCode;
	private String processStatusDesc;
	//update by new 18/11/2014
	private String meterType;
	
	//update by new 28/08/2018
	
	private String supSendDt;
	private String rate;
	private String siteCode;
	private String supplier;
		
	@Id
  	@GeneratedValue(generator="system-uuid")
  	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "UPLOAD_METER_ID")
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
		
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "METER_FILE_ID")
	public UploadMeterFile getMeterFile() {
		return meterFile;
	}
	public void setMeterFile(UploadMeterFile meterFile) {
		this.meterFile = meterFile;
	}
	
	@Column(name = "ITEM_NO")
	public BigDecimal getItemNo() {
		return itemNo;
	}
	public void setItemNo(BigDecimal itemNo) {
		this.itemNo = itemNo;
	}
	
	@Column(name = "CONTRACT_NO")
	public String getContractNo() {
		return contractNo;
	}	
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	
	@Column(name = "SITE_NAME")
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	
	@Column(name = "LOCATION_ID")
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	
	@Column(name = "METER_TYPE")
	public String getMeterType() {
		return meterType;
	}
	public void setMeterType(String meterType) {
		this.meterType = meterType;
	}
	
	@Column(name = "LOCATION_CODE")
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	
	@Column(name = "TRANSFORMER_LABEL")
	public String getTransformerLabel() {
		return transformerLabel;
	}
	public void setTransformerLabel(String transformerLabel) {
		this.transformerLabel = transformerLabel;
	}
	
	@Column(name = "TRANSFORMER_SIZE")	
	public String getTransformerSize() {
		return transformerSize;
	}
	public void setTransformerSize(String transformerSize) {
		this.transformerSize = transformerSize;
	}
	
	@Column(name = "TRANSFORMER_SERIAL")
	public String getTransformerSerial() {
		return transformerSerial;
	}
	public void setTransformerSerial(String transformerSerial) {
		this.transformerSerial = transformerSerial;
	}
	
	@Column(name = "TRANSFORMER_DT")
	public Date getTransformerDt() {
		return transformerDt;
	}
	public void setTransformerDt(Date transformerDt) {
		this.transformerDt = transformerDt;
	}
	
	@Column(name = "METER_SIZE")
	public String getMeterSize() {
		return meterSize;
	}
	public void setMeterSize(String meterSize) {
		this.meterSize = meterSize;
	}
	
	@Column(name = "METER_WIRE")
	public String getMeterWire() {
		return meterWire;
	}
	public void setMeterWire(String meterWire) {
		this.meterWire = meterWire;
	}
	
	@Column(name = "ON_METER_DT")
	public Date getOnMeterDt() {
		return onMeterDt;
	}
	public void setOnMeterDt(Date onMeterDt) {
		this.onMeterDt = onMeterDt;
	}
	
	@Column(name = "AREA_CODE")
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	
	@Column(name = "METER_ID")
	public String getMeterId() {
		return meterId;
	}
	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}
	
	@Column(name = "AREA_NAME")
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "ERROR_CODE")
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	@Column(name = "ERROR_DESC")
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	
	@Column(name = "RECORD_STATUS")
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
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
	
	@Column(name="PROCESS_STATUS_CODE")
	public String getProcessStatusCode() {
		return processStatusCode;
	}
	public void setProcessStatusCode(String processStatusCode) {
		this.processStatusCode = processStatusCode;
	}
	
	@Transient
	public String getProcessStatusDesc() {
		return processStatusDesc;
	}
	public void setProcessStatusDesc(String processStatusDesc) {
		this.processStatusDesc = processStatusDesc;
	}
	
	@Column(name = "SUP_SEND_DT")
	public String getSupSendDt() {
		return supSendDt;
	}
	public void setSupSendDt(String supSendDt) {
		this.supSendDt = supSendDt;
	}
	

	
	@Column(name = "SITE_CODE")
	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	
	@Column(name = "SUPPLIER")
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	@Column(name = "RATE")
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	
}
