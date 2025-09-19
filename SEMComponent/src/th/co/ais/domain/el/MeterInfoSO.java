package th.co.ais.domain.el;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;

@Entity
@Table(name="SEM_EL_METER_INFO", schema="SEM")
public class MeterInfoSO extends AbstractDomain {

	private static final long serialVersionUID = 2012527641400710253L;
	private static final SimpleDateFormat SDF 	= new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));

	private String rowId;
	private Management electricId;
	private String referMeterId;
	private String meterId;
	private String eOldMeterId;
	private String eAreaCode;
	private String eAreaName;
	private String eMeterRate;
	private String eMeterSize;
	private String eMeterWire;
	private Date eOnMeterDt;
	private Date eOneBillDt;
	private Date eOneBillDtFrom;
	private Date eOneBillDtTo;
	private String eTransformerLabel;
	private String eTransformerType;
	private String eTransformerSize;
	private String eTransformerSerial;
	private Date eTransformerDt;
	private String eCheckArea;
	private String eMeterType;
	private String pMeterOwnerName;
	private String pAreaName;
	private String pMeterAddress;
	private BigDecimal pMeterUnitPrice;
	private String pMeterVatType;
	private BigDecimal pFirstKwh;
	private String pMeterStatus;
	private Date pOnMeterDt;
	private Date pOffMeterDt;
	private String pMeterRemark;

	private String oneBillFlag;
	private String oneBillAddFlag;
	private String oneBillRemark;
	private Date uploadMeterDt;
	private Date uploadMeterDtFrom;
	private Date uploadMeterDtTo;
	private BigDecimal version;
	private String recordStatus;
	private boolean selected = false;
	private boolean disableCheckbox = false;
	private String oneBillAddFlagDisplay;
	private String electricUseType;
	private String eOneBillDtLabel;
	private String eOnMeterDtLabel;
	private String transformerDtLabel;
	private String updateDtLabel;
	private String createDtLabel;
	private boolean editButtonVisible = true;
	private String pOnMeterDtLabel;
	private String pOffMeterDtLabel;
	private String pMeterVatTypeLabel;
	private String pMeterStatusLabel;
	private String eCheckAreaLabel;
	private boolean editPrivateRendered;
	private String firstPaidFlag;
	private Set<MeterInstallment> meterInstallments;
	//WT###Add 20110208 Start
	private String eAreaDistrict;
	private Date lastTermOfPaymentDt;
	private BigDecimal lastInvAmt;
	private BigDecimal lastLKwh;
	//WT###Add 20110208 End
	
	private String outstandingFlag;
	
	
	private BigDecimal lastKWHTotal;
	private BigDecimal lastUnitAmt;
	private String lastUnitVatType;
	// Display 
	
	private String eMeterTypeDisplay;
	private String elecTricUstTypeDisplay;
	@Transient
	private String nullString = "N/A";
	
	private String uploadMeterDtStr;
	private String eOnMeterDtStr;
	private String eOneBillDtStr;
	
	@Column(name = "OUTSTANDING_FLAG")	
	public String getOutstandingFlag() {
		return outstandingFlag;
	}

	public void setOutstandingFlag(String outstandingFlag) {
		this.outstandingFlag = outstandingFlag;
	}

	@Transient
	public boolean isOneBillFlagBoolean() {
		return oneBillFlag != null && oneBillFlag.equalsIgnoreCase("y");
	}

	public void setOneBillFlagBoolean(boolean oneBillFlagBoolean) {

		if(oneBillFlagBoolean) setOneBillFlag("Y");
		else setOneBillFlag("N");
	}
	
	@Transient
	public boolean isEditButtonVisible() {
		return editButtonVisible;
	}

	public void setEditButtonVisible(boolean editButtonVisible) {
		this.editButtonVisible = editButtonVisible;
	}
	
	@Transient
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	@Transient
	public boolean getDisableCheckbox() {
		if("Y".equals(oneBillAddFlag)){
			disableCheckbox = true;
		}
		return disableCheckbox;
	}
	
	public void setDisableCheckbox(boolean disableCheckbox) {
		this.disableCheckbox = disableCheckbox;
	}
	
	@Id
  	@GeneratedValue(generator="system-uuid")
  	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "METER_INFO_ID")	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	@OneToMany(mappedBy="meterInfoId", fetch=FetchType.LAZY)
	public Set<MeterInstallment> getMeterInstallments() {
		return meterInstallments;
	}

	public void setMeterInstallments(Set<MeterInstallment> meterInstallments) {
		this.meterInstallments = meterInstallments;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ELECTRIC_ID")
	public Management getElectricId() {
		return electricId;
	}
	public void setElectricId(Management electricId) {
		this.electricId = electricId;
	}
	
	@Column(name = "REFER_METER_ID")	
	public String getReferMeterId() {
		return referMeterId;
	}
	public void setReferMeterId(String referMeterId) {
		this.referMeterId = referMeterId;
	}
	
	@Column(name = "METER_ID")
	public String getMeterId() {
		return meterId;
	}
	public void setMeterId(String meterId) {
		if(nullString.equals(meterId)){
			meterId = null;
		}
		this.meterId = meterId;
	}
	
	@Column(name = "E_OLD_METER_ID")
	public String geteOldMeterId() {
		return eOldMeterId;
	}
	public void seteOldMeterId(String eOldMeterId) {
		if(nullString.equals(eOldMeterId)){
			eOldMeterId = null;
		}
		this.eOldMeterId = eOldMeterId;
	}
	
	@Column(name = "E_AREA_CODE")
	public String geteAreaCode() {
		return eAreaCode;
	}
	public void seteAreaCode(String eAreaCode) {
		if(nullString.equals(eAreaCode)){
			eAreaCode = null;
		}
		this.eAreaCode = eAreaCode;
	}
	
	@Column(name = "E_AREA_NAME")
	public String geteAreaName() {
		return eAreaName;
	}
	public void seteAreaName(String eAreaName) {
		if(nullString.equals(eAreaName)){
			eAreaName = null;
		}
		this.eAreaName = eAreaName;
	}
	
	@Column(name = "E_METER_RATE")
	public String geteMeterRate() {
		return eMeterRate;
	}
	public void seteMeterRate(String eMeterRate) {
		this.eMeterRate = eMeterRate;
	}
	
	@Column(name = "E_METER_SIZE")
	public String geteMeterSize() {
		return eMeterSize;
	}
	public void seteMeterSize(String eMeterSize) {
		if(nullString.equals(eMeterSize)){
			eMeterSize = null;
		}
		this.eMeterSize = eMeterSize;
	}
	
	@Column(name = "E_METER_WIRE")
	public String geteMeterWire() {
		return eMeterWire;
	}
	public void seteMeterWire(String eMeterWire) {
		if(nullString.equals(eMeterWire)){
			eMeterWire = null;
		}
		this.eMeterWire = eMeterWire;
	}
	
	@Column(name = "E_ON_METER_DT")
	public Date geteOnMeterDt() {
		return eOnMeterDt;
	}
	public void seteOnMeterDt(Date eOnMeterDt) {
		this.eOnMeterDt = eOnMeterDt;
	}
	
	@Column(name = "E_ONE_BILL_DT")
	public Date geteOneBillDt() {
		return eOneBillDt;
	}
	public void seteOneBillDt(Date eOneBillDt) {
		this.eOneBillDt = eOneBillDt;
	}
	
	@Column(name = "E_TRANSFORMER_LABEL")
	public String geteTransformerLabel() {
		return eTransformerLabel;
	}
	public void seteTransformerLabel(String eTransformerLabel) {
		if(nullString.equals(eTransformerLabel)){
			eTransformerLabel = null;
		}
		this.eTransformerLabel = eTransformerLabel;
	}
	
	@Column(name = "E_TRANSFORMER_TYPE")
	public String geteTransformerType() {
		return eTransformerType;
	}
	public void seteTransformerType(String eTransformerType) {
		this.eTransformerType = eTransformerType;
	}
	
	@Column(name = "E_TRANSFORMER_SIZE")
	public String geteTransformerSize() {
		return eTransformerSize;
	}
	public void seteTransformerSize(String eTransformerSize) {
		if(nullString.equals(eTransformerSize)){
			eTransformerSize = null;
		}
		this.eTransformerSize = eTransformerSize;
	}
	
	@Column(name = "E_TRANSFORMER_SERIAL")
	public String geteTransformerSerial() {
		return eTransformerSerial;
	}
	public void seteTransformerSerial(String eTransformerSerial) {
		if(nullString.equals(eTransformerSerial)){
			eTransformerSerial = null;
		}
		this.eTransformerSerial = eTransformerSerial;
	}
	
	@Column(name = "E_TRANSFORMER_DT")
	public Date geteTransformerDt() {
		return eTransformerDt;
	}
	public void seteTransformerDt(Date eTransformerDt) {
		this.eTransformerDt = eTransformerDt;
	}
	
	@Column(name = "E_CHECK_AREA")
	public String geteCheckArea() {
		return eCheckArea;
	}
	public void seteCheckArea(String eCheckArea) {
		this.eCheckArea = eCheckArea;
	}
	
	@Column(name = "E_METER_TYPE")
	public String geteMeterType() {
		return eMeterType;
	}
	public void seteMeterType(String eMeterType) {
		this.eMeterType = eMeterType;
	}
	
	@Column(name = "P_METER_OWNER_NAME")
	public String getpMeterOwnerName() {
		return pMeterOwnerName;
	}
	public void setpMeterOwnerName(String pMeterOwnerName) {
		this.pMeterOwnerName = pMeterOwnerName;
	}
	
	@Column(name = "P_AREA_NAME")
	public String getpAreaName() {
		return pAreaName;
	}
	public void setpAreaName(String pAreaName) {
		this.pAreaName = pAreaName;
	}
	
	@Column(name = "P_METER_ADDRESS")
	public String getpMeterAddress() {
		return pMeterAddress;
	}
	public void setpMeterAddress(String pMeterAddress) {
		this.pMeterAddress = pMeterAddress;
	}
	
	@Column(name = "P_METER_UNIT_PRICE")
	public BigDecimal getpMeterUnitPrice() {
		return pMeterUnitPrice;
	}
	public void setpMeterUnitPrice(BigDecimal pMeterUnitPrice) {
		this.pMeterUnitPrice = pMeterUnitPrice;
	}
	
	@Column(name = "P_METER_VAT_TYPE")
	public String getpMeterVatType() {
		return pMeterVatType;
	}
	public void setpMeterVatType(String pMeterVatType) {
		this.pMeterVatType = pMeterVatType;
	}
	
	@Column(name = "P_FIRST_KWH")
	public BigDecimal getpFirstKwh() {
		return pFirstKwh;
	}
	public void setpFirstKwh(BigDecimal pFirstKwh) {
		this.pFirstKwh = pFirstKwh;
	}
	
	@Column(name = "P_METER_STATUS")
	public String getpMeterStatus() {
		return pMeterStatus;
	}
	public void setpMeterStatus(String pMeterStatus) {
		this.pMeterStatus = pMeterStatus;
	}
	
	@Column(name = "P_ON_METER_DT")
	public Date getpOnMeterDt() {
		return pOnMeterDt;
	}
	public void setpOnMeterDt(Date pOnMeterDt) {
		this.pOnMeterDt = pOnMeterDt;
	}
	
	@Column(name = "P_OFF_METER_DT")
	public Date getpOffMeterDt() {
		return pOffMeterDt;
	}
	public void setpOffMeterDt(Date pOffMeterDt) {
		this.pOffMeterDt = pOffMeterDt;
	}
	
	@Column(name = "P_METER_REMARK")
	public String getpMeterRemark() {
		return pMeterRemark;
	}
	public void setpMeterRemark(String pMeterRemark) {
		this.pMeterRemark = pMeterRemark;
	}
	
	@Column(name = "ONE_BILL_FLAG")
	public String getOneBillFlag() {
		return oneBillFlag;
	}
	public void setOneBillFlag(String oneBillFlag) {
		this.oneBillFlag = oneBillFlag;
	}
	
	@Column(name = "ONE_BILL_ADD_FLAG")
	public String getOneBillAddFlag() {
		return oneBillAddFlag;
	}
	public void setOneBillAddFlag(String oneBillAddFlag) {
		this.oneBillAddFlag = oneBillAddFlag;
	}
	
	@Column(name = "ONE_BILL_REMARK")
	public String getOneBillRemark() {
		return oneBillRemark;
	}
	public void setOneBillRemark(String oneBillRemark) {
		this.oneBillRemark = oneBillRemark;
	}
	
	@Column(name = "UPLOAD_METER_DT")
	public Date getUploadMeterDt() {
		return uploadMeterDt;
	}
	public void setUploadMeterDt(Date uploadMeterDt) {
		this.uploadMeterDt = uploadMeterDt;
	}
	
	@Column(name = "VERSION")
	public BigDecimal getVersion() {
		return version;
	}
	public void setVersion(BigDecimal version) {
		this.version = version;
	}
	
	@Column(name = "RECORD_STATUS")
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	@Transient
	public String getMeterStatus(){
		String strReturn = "Active";
		if("N".equals(recordStatus)){
			strReturn = "Inactive";
		}
		
		return strReturn;
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
	public Date getUploadMeterDtFrom() {
		return uploadMeterDtFrom;
	}

	public void setUploadMeterDtFrom(Date uploadMeterDtFrom) {
		this.uploadMeterDtFrom = uploadMeterDtFrom;
	}

	@Transient
	public Date getUploadMeterDtTo() {
		return uploadMeterDtTo;
	}

	public void setUploadMeterDtTo(Date uploadMeterDtTo) {
		this.uploadMeterDtTo = uploadMeterDtTo;
	}	

	@Transient
	public String getOneBillAddFlagDisplay() {
		return oneBillAddFlagDisplay;
	}

	public void setOneBillAddFlagDisplay(String oneBillAddFlagDisplay) {
		this.oneBillAddFlagDisplay = oneBillAddFlagDisplay;
	}
	
	@Transient
	public String getAreaName(){
		if(null==electricId){
			return "";
		}
		if("MEA".equalsIgnoreCase(electricId.getElectricUseType())){
			return eAreaName;
		}else{
			return pAreaName;
		}
	}
	
	@Transient
	public String geteMeterTypeDisplay() {
		return eMeterTypeDisplay;
	}

	public void seteMeterTypeDisplay(String eMeterTypeDisplay) {
		this.eMeterTypeDisplay = eMeterTypeDisplay;
	}
	
	@Column(name = "ELECTRIC_USE_TYPE")
	public String getElectricUseType() {
		return electricUseType;
	}

	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}
	
	@Transient
	public String geteOneBillDtLabel() {
		return eOneBillDtLabel;
	}

	public void seteOneBillDtLabel(String eOneBillDtLabel) {
		this.eOneBillDtLabel = eOneBillDtLabel;
	}

	@Transient
	public String geteOnMeterDtLabel() {
		return eOnMeterDtLabel;
	}

	public void seteOnMeterDtLabel(String eOnMeterDtLabel) {
		this.eOnMeterDtLabel = eOnMeterDtLabel;
	}

	@Transient
	public String getTransformerDtLabel() {
		return transformerDtLabel;
	}

	public void setTransformerDtLabel(String transformerDtLabel) {
		this.transformerDtLabel = transformerDtLabel;
	}

	@Transient
	public String getUpdateDtLabel() {
		return updateDtLabel;
	}

	public void setUpdateDtLabel(String updateDtLabel) {
		this.updateDtLabel = updateDtLabel;
	}

	@Transient
	public String getElecTricUstTypeDisplay() {
		return elecTricUstTypeDisplay;
	}

	public void setElecTricUstTypeDisplay(String elecTricUstTypeDisplay) {
		this.elecTricUstTypeDisplay = elecTricUstTypeDisplay;
	}

	@Transient
	public String getpOnMeterDtLabel() {
		return pOnMeterDtLabel;
	}

	public void setpOnMeterDtLabel(String pOnMeterDtLabel) {
		this.pOnMeterDtLabel = pOnMeterDtLabel;
	}

	@Transient
	public String getpOffMeterDtLabel() {
		return pOffMeterDtLabel;
	}

	public void setpOffMeterDtLabel(String pOffMeterDtLabel) {
		this.pOffMeterDtLabel = pOffMeterDtLabel;
	}

	@Transient
	public String getpMeterVatTypeLabel() {
		return pMeterVatTypeLabel;
	}

	public void setpMeterVatTypeLabel(String pMeterVatTypeLabel) {
		this.pMeterVatTypeLabel = pMeterVatTypeLabel;
	}

	@Transient
	public String getpMeterStatusLabel() {
		return pMeterStatusLabel;
	}

	public void setpMeterStatusLabel(String pMeterStatusLabel) {
		this.pMeterStatusLabel = pMeterStatusLabel;
	}
	
	@Transient
	public String geteCheckAreaLabel() {
		return eCheckAreaLabel;
	}

	public void seteCheckAreaLabel(String eCheckAreaLabel) {
		this.eCheckAreaLabel = eCheckAreaLabel;
	}

	@Transient
	public String getCreateDtLabel() {
		return createDtLabel;
	}

	public void setCreateDtLabel(String createDtLabel) {
		this.createDtLabel = createDtLabel;
	}

	@Transient
	public boolean isEditPrivateRendered() {
		return editPrivateRendered;
	}

	public void setEditPrivateRendered(boolean editPrivateRendered) {
		this.editPrivateRendered = editPrivateRendered;
	}

	@Column(name = "FIRST_PAID_FLAG")
	public String getFirstPaidFlag() {
		return firstPaidFlag;
	}

	public void setFirstPaidFlag(String firstPaidFlag) {
		this.firstPaidFlag = firstPaidFlag;
	}

	@Transient
	public boolean isFirstPaid() {
		boolean result = false;
		if(this.firstPaidFlag != null && "Y".equalsIgnoreCase(this.firstPaidFlag)){
			result = true;
		}
		return result;
	}

	//Use for display only
	@Transient
	public String getUploadMeterDtStr() {
		return uploadMeterDtStr;
	}

	public void setUploadMeterDtStr(String uploadMeterDtStr) {
		this.uploadMeterDtStr = uploadMeterDtStr;
	}

	@Transient
	public String geteOnMeterDtStr() {
		return eOnMeterDtStr;
	}

	public void seteOnMeterDtStr(String eOnMeterDtStr) {
		this.eOnMeterDtStr = eOnMeterDtStr;
	}

	@Transient
	public String geteOneBillDtStr() {
		return eOneBillDtStr;
	}

	public void seteOneBillDtStr(String eOneBillDtStr) {
		this.eOneBillDtStr = eOneBillDtStr;
	}
	@Column(name = "LAST_KWH_TOTAL")
	public BigDecimal getLastKWHTotal() {
		return lastKWHTotal;
	}

	public void setLastKWHTotal(BigDecimal lastKWHTotal) {
		this.lastKWHTotal = lastKWHTotal;
	}
	@Column(name = "LAST_UNIT_AMT")
	public BigDecimal getLastUnitAmt() {
		return lastUnitAmt;
	}

	public void setLastUnitAmt(BigDecimal lastUnitAmt) {
		this.lastUnitAmt = lastUnitAmt;
	}
	@Column(name = "LAST_UNIT_VAT_TYPE")
	public String getLastUnitVatType() {
		return lastUnitVatType;
	}

	public void setLastUnitVatType(String lastUnitVatType) {
		this.lastUnitVatType = lastUnitVatType;
	}

	@Transient
	public Date geteOneBillDtFrom() {
		return eOneBillDtFrom;
	}

	public void seteOneBillDtFrom(Date eOneBillDtFrom) {
		this.eOneBillDtFrom = eOneBillDtFrom;
	}

	@Transient
	public Date geteOneBillDtTo() {
		return eOneBillDtTo;
	}

	public void seteOneBillDtTo(Date eOneBillDtTo) {
		this.eOneBillDtTo = eOneBillDtTo;
	}

	@Column(name="E_AREA_DISTRICT")
	public String geteAreaDistrict() {
		return eAreaDistrict;
	}
	public void seteAreaDistrict(String eAreaDistrict) {
		this.eAreaDistrict = eAreaDistrict;
	}

	@Column(name="LAST_TERM_OF_PAYMENT_DT")
	public Date getLastTermOfPaymentDt() {
		return lastTermOfPaymentDt;
	}
	public void setLastTermOfPaymentDt(Date lastTermOfPaymentDt) {
		this.lastTermOfPaymentDt = lastTermOfPaymentDt;
	}
	@Transient
	public String getLastTermOfPaymentDtLabel() {
		String dtStrReturn = (null != lastTermOfPaymentDt) ? SDF.format(lastTermOfPaymentDt) : "";
		return dtStrReturn;
	}

	@Column(name="LAST_INV_AMT")
	public BigDecimal getLastInvAmt() {
		return lastInvAmt;
	}

	public void setLastInvAmt(BigDecimal lastInvAmt) {
		this.lastInvAmt = lastInvAmt;
	}

	@Column(name="LAST_L_KWH")
	public BigDecimal getLastLKwh() {
		return lastLKwh;
	}

	public void setLastLKwh(BigDecimal lastLKwh) {
		this.lastLKwh = lastLKwh;
	}

	
}
