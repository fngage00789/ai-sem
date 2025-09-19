package th.co.ais.domain.el;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.domain.gm.Amphur;
import th.co.ais.domain.gm.Province;
import th.co.ais.domain.gm.Region;

@Entity(name="th.co.ais.domain.el.UploadText")
//@Table(name="SEM_EL_UPLOAD_TEXT", schema="SEM")
@Table(name="SEM_EL_IMPORT_DATA_DETAIL", schema="SEM")
public class UploadText extends AbstractDomain {

	private static final long serialVersionUID = 3115835332634461331L;
	private static final SimpleDateFormat SDF 	= new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
	
	private String rowId;
	private ImportTransaction textFileId;
	private String electricUseType;
	private String fileType;
	private BigDecimal pnItem;
	private String pnMorTor;
	private String pnMru;
	private String pnMeterId;
	private String pnName;
	private String pnAddress;
	private String pnVoltage;
	private String pnKw;
	private BigDecimal pnMultiply;
	private Date pnPmrDt;
	private Date pnMrDt;
	private BigDecimal pnPmr;
	private BigDecimal pnMr;
	private BigDecimal pnUnit;
	private BigDecimal pnAmt;
	private BigDecimal pnVatAmt;
	private String pnRateCat;
	private String pnInvNo;
	private BigDecimal pnFt;
	private BigDecimal pnTou;
	private String pnPeaCode;
	private String pnPeaname;
	private String pnBillperiod;
	private BigDecimal pnPkpmrNew;
	private BigDecimal pnPkmrNew;
	private BigDecimal pnPkunitNew;
	private BigDecimal pnOpkpmrNew;
	private BigDecimal pnOpkmrNew;
	private BigDecimal pnOpkunitNew;
	private BigDecimal pnHldpmrNew;
	private BigDecimal pnHldmrNew;
	private BigDecimal pnhldunitNew;
	private BigDecimal poItem;
	private String poArea;
	private String poMru;
	private String poMeterId;
	private String poName;
	private String poAddress;
	private String poVoltage;
	private BigDecimal poKw;
	private BigDecimal poCt;
	private Date poPDt;
	private Date poLDt;
	private BigDecimal poPread;
	private BigDecimal poLread;
	private BigDecimal poKwhTotal;
	private BigDecimal poInvAmt;
	private BigDecimal poVatAmt;
	private String poRateCat;
	private String poInvNo;
	private BigDecimal poFtAmt;
	private BigDecimal poFtRate;
	private BigDecimal poDemandAmt;
	private BigDecimal poPfAmt;
	private String poFiller2;
	private String poPeacode;
	private String poCollection;
	private String poUserNo;
	private Date poBillperiod;
	private BigDecimal mnSeq;
	private String mnMru;
	private String mnMeterId;
	private String mnName;
	private String mnAddress;
	private Date mnPDt;
	private Date mnLDt;
	private BigDecimal mnPread;
	private BigDecimal mnLread;
	private String mnRateCat;
	private BigDecimal mnCt;
	private BigDecimal mnKwhTotal;
	private BigDecimal mnMaxKw;
	private String mnInvNo;
	private BigDecimal mnInvAmt;
	private BigDecimal mnVatAmt;
	private BigDecimal mnFtAmt;
	private BigDecimal mnFtRate;
	private BigDecimal mnDemandAmt;
	private BigDecimal mnPfAmt;
	private BigDecimal mnOnKwh;
	private BigDecimal mnOffKwh;
	private BigDecimal mnKvar;
	private BigDecimal moItem;
	private String moArea;
	private String moMru;
	private String moMeterId;
	private String moName;
	private String moAddress;
	private String moVoltage;
	private BigDecimal moKw;
	private BigDecimal moCt;
	private Date moPDt;
	private Date moLDt;
	private BigDecimal moPread;
	private BigDecimal moLread;
	private BigDecimal moKwhTotal;
	private BigDecimal moInvAmt;
	private BigDecimal moVatAmt;
	private String moRateCat;
	private String moInvNo;
	private BigDecimal moFtAmt;
	private BigDecimal moFtRate;
	private BigDecimal moDemandAmt;
	private BigDecimal moPfAmt;
	private String moFiller;
	private String processStatus;
	private String loadStatus;
	private String calStatus;
	private String errorCode;
	private String errorDesc;
	private BigDecimal version;
	private String invNo;
	private String meterId;
	private String contractNo;
	private String siteName;
	private String locationId;
	private String areaCode;
	private String areaName;
	private Region region;
	private Province province;
	private Amphur amphur;
	private String meterRate;
	private String meterType;
	private Date billperiod;
	private Date pDt;	
	private Date lDt;
	private BigDecimal invAmt;
	private BigDecimal invVatAmt;
	private BigDecimal sysAmt;
	private BigDecimal diffAmt;
	private String paidFlag;
	private String clearingFlag;
	private String recordStatus;
	private String remark;
	private BigDecimal unit;
	private BigDecimal electOnpeak;
	private BigDecimal electOffpeak;
	private BigDecimal electDemandOn;
	private BigDecimal electDemandOff;
	private BigDecimal reactive;
	private BigDecimal kwhTotal;
	private BigDecimal electDemandPart;
	private BigDecimal kwhOn;
	private BigDecimal kwhOff;
	private BigDecimal electDemand;
	private String meterTypeFlag;
	private String todtouFlag;
	private String kwhFlag;
	private String serviceFlag;
	private String dataFlag;
	private String calFlag;
	private String pRead;
	private String lRead;
	private Management electricId;
	private boolean selected = false;//WT###Add 20110308
	//WT###Add 20110311 Start
	private String siteStatus;
	private String processStatusCode;
	private String siteStatusDesc;
	private String processStatusCodeDesc;
	//WT###Add 20110311 End
	private String seqNo;//WT###Add 20110323
	private BigDecimal ct;//WT###Add 20110330
	private String companyName;//WT###Add 20110530
	private String companyFlag;//WT###Add 20110530
	private String ctFlag;//WT###Add 20110531
	private String paidStatus;
	private String oldContractNo;
	//Momo------------------------------------
	private Date installmentPDate;
	private Date installmenLDate;
	private String installmenPRead;
	private String installmenLRead;
	private BigDecimal installmenKWH;
	private BigDecimal installmenVatAmount;
	private BigDecimal installmenIncVatAmount;
	//private String installmentPDateTH;
	//private String installmenLDateTH;
	private Date txtBillDate;
	private Date billperiodPDt;
	private Date billperiodLDt;
	private String billperiodPDtStr;
	
	private String ownerGroup;
	private String ownerGroupName;
	//private String txtBillDateTH;
	//
	
	private String termOfPayment;
	private String currentTermOfPaymentDetail;
	private String nextTermOfPaymentDetail;
	private String termOfPaymentDetail;
	private String remarkPaymentDetail;
	private String processId;

	private String effDtStr;
	private String expDtStr;
	private Date effDt;
	private Date expDt;
	private String networkStatusDesc;
	private String meterStatus;
	
	private String periodFlag;
	private String contStatusInactiveFlag;
	private String networkStatusInactiveFlag;
	private String growthFlag;
	private String address;
	private BigDecimal elAmt;
	
	//private String termOfPaymentDetail;
	
	
	@Id
  	@GeneratedValue(generator="system-uuid")
  	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "SEM_EL_IMPORT_DATA_DETAIL_ID")
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SEM_EL_IMPORT_TRANS_ID")	
	public ImportTransaction getTextFileId() {
		return textFileId;
	}
	public void setTextFileId(ImportTransaction textFileId) {
		this.textFileId = textFileId;
	}
		
	@Column(name = "ELECTRIC_USE_TYPE")
	public String getElectricUseType() {
		return electricUseType;
	}
	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}
	
	@Column(name = "FILE_TYPE")
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	@Column(name = "PN_ITEM")
	public BigDecimal getPnItem() {
		return pnItem;
	}
	public void setPnItem(BigDecimal pnItem) {
		this.pnItem = pnItem;
	}
	
	@Column(name = "PN_MOR_TOR")
	public String getPnMorTor() {
		return pnMorTor;
	}
	public void setPnMorTor(String pnMorTor) {
		this.pnMorTor = pnMorTor;
	}
	
	@Column(name = "PN_MRU")
	public String getPnMru() {
		return pnMru;
	}
	public void setPnMru(String pnMru) {
		this.pnMru = pnMru;
	}
	
	@Column(name = "PN_METER_ID")
	public String getPnMeterId() {
		return pnMeterId;
	}
	public void setPnMeterId(String pnMeterId) {
		this.pnMeterId = pnMeterId;
	}
	
	@Column(name = "PN_NAME")
	public String getPnName() {
		return pnName;
	}
	public void setPnName(String pnName) {
		this.pnName = pnName;
	}
	
	@Column(name = "PN_ADDRESS")
	public String getPnAddress() {
		return pnAddress;
	}
	public void setPnAddress(String pnAddress) {
		this.pnAddress = pnAddress;
	}
	
	@Column(name = "PN_VOLTAGE")
	public String getPnVoltage() {
		return pnVoltage;
	}
	public void setPnVoltage(String pnVoltage) {
		this.pnVoltage = pnVoltage;
	}
	
	@Column(name = "PN_KW")
	public String getPnKw() {
		return pnKw;
	}
	public void setPnKw(String pnKw) {
		this.pnKw = pnKw;
	}
	
	@Column(name = "PN_MULTIPLY")
	public BigDecimal getPnMultiply() {
		return pnMultiply;
	}
	public void setPnMultiply(BigDecimal pnMultiply) {
		this.pnMultiply = pnMultiply;
	}
	
	@Column(name = "PN_PMR_DT")
	public Date getPnPmrDt() {
		return pnPmrDt;
	}
	public void setPnPmrDt(Date pnPmrDt) {
		this.pnPmrDt = pnPmrDt;
	}
	
	@Column(name = "PN_MR_DT")
	public Date getPnMrDt() {
		return pnMrDt;
	}
	public void setPnMrDt(Date pnMrDt) {
		this.pnMrDt = pnMrDt;
	}
	
	@Column(name = "PN_PMR")
	public BigDecimal getPnPmr() {
		return pnPmr;
	}
	public void setPnPmr(BigDecimal pnPmr) {
		this.pnPmr = pnPmr;
	}
	
	@Column(name = "PN_MR")
	public BigDecimal getPnMr() {
		return pnMr;
	}
	public void setPnMr(BigDecimal pnMr) {
		this.pnMr = pnMr;
	}
	
	@Column(name = "PN_UNIT")
	public BigDecimal getPnUnit() {
		return pnUnit;
	}
	public void setPnUnit(BigDecimal pnUnit) {
		this.pnUnit = pnUnit;
	}
	
	@Column(name = "PN_AMT")
	public BigDecimal getPnAmt() {
		return pnAmt;
	}
	public void setPnAmt(BigDecimal pnAmt) {
		this.pnAmt = pnAmt;
	}
	
	@Column(name = "PN_VAT_AMT")
	public BigDecimal getPnVatAmt() {
		return pnVatAmt;
	}
	public void setPnVatAmt(BigDecimal pnVatAmt) {
		this.pnVatAmt = pnVatAmt;
	}
	
	@Column(name = "PN_RATE_CAT")
	public String getPnRateCat() {
		return pnRateCat;
	}
	public void setPnRateCat(String pnRateCat) {
		this.pnRateCat = pnRateCat;
	}
	
	@Column(name = "PN_INV_NO")
	public String getPnInvNo() {
		return pnInvNo;
	}
	public void setPnInvNo(String pnInvNo) {
		this.pnInvNo = pnInvNo;
	}
	
	@Column(name = "PN_FT")
	public BigDecimal getPnFt() {
		return pnFt;
	}
	public void setPnFt(BigDecimal pnFt) {
		this.pnFt = pnFt;
	}
	
	@Column(name = "PN_TOU")
	public BigDecimal getPnTou() {
		return pnTou;
	}
	public void setPnTou(BigDecimal pnTou) {
		this.pnTou = pnTou;
	}
	
	@Column(name = "PN_PEACODE")
	public String getPnPeaCode() {
		return pnPeaCode;
	}
	public void setPnPeaCode(String pnPeaCode) {
		this.pnPeaCode = pnPeaCode;
	}
	
	@Column(name = "PN_PEANAME")
	public String getPnPeaname() {
		return pnPeaname;
	}
	public void setPnPeaname(String pnPeaname) {
		this.pnPeaname = pnPeaname;
	}
	
	@Column(name = "PN_BILLPERIOD")
	public String getPnBillperiod() {
		return pnBillperiod;
	}
	public void setPnBillperiod(String pnBillperiod) {
		this.pnBillperiod = pnBillperiod;
	}
	
	@Column(name = "PN_PKPMR_NEW")
	public BigDecimal getPnPkpmrNew() {
		return pnPkpmrNew;
	}
	public void setPnPkpmrNew(BigDecimal pnPkpmrNew) {
		this.pnPkpmrNew = pnPkpmrNew;
	}
	
	@Column(name = "PN_PKMR_NEW")
	public BigDecimal getPnPkmrNew() {
		return pnPkmrNew;
	}
	public void setPnPkmrNew(BigDecimal pnPkmrNew) {
		this.pnPkmrNew = pnPkmrNew;
	}
	
	@Column(name = "PN_PKUNIT_NEW")
	public BigDecimal getPnPkunitNew() {
		return pnPkunitNew;
	}
	public void setPnPkunitNew(BigDecimal pnPkunitNew) {
		this.pnPkunitNew = pnPkunitNew;
	}
	
	@Column(name = "PN_OPKPMR_NEW")
	public BigDecimal getPnOpkpmrNew() {
		return pnOpkpmrNew;
	}
	public void setPnOpkpmrNew(BigDecimal pnOpkpmrNew) {
		this.pnOpkpmrNew = pnOpkpmrNew;
	}
	
	@Column(name = "PN_OPKMR_NEW")
	public BigDecimal getPnOpkmrNew() {
		return pnOpkmrNew;
	}
	public void setPnOpkmrNew(BigDecimal pnOpkmrNew) {
		this.pnOpkmrNew = pnOpkmrNew;
	}
	
	@Column(name = "PN_OPKUNIT_NEW")
	public BigDecimal getPnOpkunitNew() {
		return pnOpkunitNew;
	}
	public void setPnOpkunitNew(BigDecimal pnOpkunitNew) {
		this.pnOpkunitNew = pnOpkunitNew;
	}
	
	@Column(name = "PN_HLDPMR_NEW")
	public BigDecimal getPnHldpmrNew() {
		return pnHldpmrNew;
	}
	public void setPnHldpmrNew(BigDecimal pnHldpmrNew) {
		this.pnHldpmrNew = pnHldpmrNew;
	}
	
	@Column(name = "PN_HLDMR_NEW")
	public BigDecimal getPnHldmrNew() {
		return pnHldmrNew;
	}
	public void setPnHldmrNew(BigDecimal pnHldmrNew) {
		this.pnHldmrNew = pnHldmrNew;
	}
	
	@Column(name = "PN_HLDUNIT_NEW")
	public BigDecimal getPnhldunitNew() {
		return pnhldunitNew;
	}
	public void setPnhldunitNew(BigDecimal pnhldunitNew) {
		this.pnhldunitNew = pnhldunitNew;
	}
	
	@Column(name = "PO_ITEM")
	public BigDecimal getPoItem() {
		return poItem;
	}
	public void setPoItem(BigDecimal poItem) {
		this.poItem = poItem;
	}
	
	@Column(name = "PO_AREA")
	public String getPoArea() {
		return poArea;
	}
	public void setPoArea(String poArea) {
		this.poArea = poArea;
	}
	
	@Column(name = "PO_MRU")
	public String getPoMru() {
		return poMru;
	}
	public void setPoMru(String poMru) {
		this.poMru = poMru;
	}
	
	@Column(name = "PO_METER_ID")
	public String getPoMeterId() {
		return poMeterId;
	}
	public void setPoMeterId(String poMeterId) {
		this.poMeterId = poMeterId;
	}
	
	@Column(name = "PO_NAME")
	public String getPoName() {
		return poName;
	}
	public void setPoName(String poName) {
		this.poName = poName;
	}
	
	@Column(name = "PO_ADDRESS")
	public String getPoAddress() {
		return poAddress;
	}
	public void setPoAddress(String poAddress) {
		this.poAddress = poAddress;
	}
	
	@Column(name = "PO_VOLTAGE")
	public String getPoVoltage() {
		return poVoltage;
	}
	public void setPoVoltage(String poVoltage) {
		this.poVoltage = poVoltage;
	}
	
	@Column(name = "PO_KW")
	public BigDecimal getPoKw() {
		return poKw;
	}
	public void setPoKw(BigDecimal poKw) {
		this.poKw = poKw;
	}
	
	@Column(name = "PO_CT")
	public BigDecimal getPoCt() {
		return poCt;
	}
	public void setPoCt(BigDecimal poCt) {
		this.poCt = poCt;
	}
	
	@Column(name = "PO_P_DT")
	public Date getPoPDt() {
		return poPDt;
	}
	public void setPoPDt(Date poPDt) {
		this.poPDt = poPDt;
	}
	
	@Column(name = "PO_L_DT")
	public Date getPoLDt() {
		return poLDt;
	}
	public void setPoLDt(Date poLDt) {
		this.poLDt = poLDt;
	}
	
	@Column(name = "PO_PREAD")
	public BigDecimal getPoPread() {
		return poPread;
	}
	public void setPoPread(BigDecimal poPread) {
		this.poPread = poPread;
	}
	
	@Column(name = "PO_LREAD")
	public BigDecimal getPoLread() {
		return poLread;
	}
	public void setPoLread(BigDecimal poLread) {
		this.poLread = poLread;
	}
	
	@Column(name = "PO_KWH_TOTAL")
	public BigDecimal getPoKwhTotal() {
		return poKwhTotal;
	}
	public void setPoKwhTotal(BigDecimal poKwhTotal) {
		this.poKwhTotal = poKwhTotal;
	}
	
	@Column(name = "PO_INV_AMT")
	public BigDecimal getPoInvAmt() {
		return poInvAmt;
	}
	public void setPoInvAmt(BigDecimal poInvAmt) {
		this.poInvAmt = poInvAmt;
	}
	
	@Column(name = "PO_VAT_AMT")
	public BigDecimal getPoVatAmt() {
		return poVatAmt;
	}
	public void setPoVatAmt(BigDecimal poVatAmt) {
		this.poVatAmt = poVatAmt;
	}
	
	@Column(name = "PO_RATE_CAT")
	public String getPoRateCat() {
		return poRateCat;
	}
	public void setPoRateCat(String poRateCat) {
		this.poRateCat = poRateCat;
	}
	
	@Column(name = "PO_INV_NO")
	public String getPoInvNo() {
		return poInvNo;
	}
	public void setPoInvNo(String poInvNo) {
		this.poInvNo = poInvNo;
	}
	
	@Column(name = "PO_FT_AMT")
	public BigDecimal getPoFtAmt() {
		return poFtAmt;
	}
	public void setPoFtAmt(BigDecimal poFtAmt) {
		this.poFtAmt = poFtAmt;
	}
	
	@Column(name = "PO_FT_RATE")
	public BigDecimal getPoFtRate() {
		return poFtRate;
	}
	public void setPoFtRate(BigDecimal poFtRate) {
		this.poFtRate = poFtRate;
	}
	
	@Column(name = "PO_DEMAND_AMT")
	public BigDecimal getPoDemandAmt() {
		return poDemandAmt;
	}
	public void setPoDemandAmt(BigDecimal poDemandAmt) {
		this.poDemandAmt = poDemandAmt;
	}
	
	@Column(name = "PO_PF_AMT")
	public BigDecimal getPoPfAmt() {
		return poPfAmt;
	}
	public void setPoPfAmt(BigDecimal poPfAmt) {
		this.poPfAmt = poPfAmt;
	}
	
	@Column(name = "PO_FILLER2")
	public String getPoFiller2() {
		return poFiller2;
	}
	public void setPoFiller2(String poFiller2) {
		this.poFiller2 = poFiller2;
	}
	
	@Column(name = "PO_PEACODE")
	public String getPoPeacode() {
		return poPeacode;
	}
	public void setPoPeacode(String poPeacode) {
		this.poPeacode = poPeacode;
	}
	
	@Column(name = "PO_COLLECTION")
	public String getPoCollection() {
		return poCollection;
	}
	public void setPoCollection(String poCollection) {
		this.poCollection = poCollection;
	}
	
	@Column(name = "PO_USERNO")
	public String getPoUserNo() {
		return poUserNo;
	}
	public void setPoUserNo(String poUserNo) {
		this.poUserNo = poUserNo;
	}
	
	@Column(name = "PO_BILLPERIOD")
	public Date getPoBillperiod() {
		return poBillperiod;
	}
	public void setPoBillperiod(Date poBillperiod) {
		this.poBillperiod = poBillperiod;
	}
	
	@Column(name = "MN_SEQ")
	public BigDecimal getMnSeq() {
		return mnSeq;
	}
	public void setMnSeq(BigDecimal mnSeq) {
		this.mnSeq = mnSeq;
	}
	
	@Column(name = "MN_MRU")
	public String getMnMru() {
		return mnMru;
	}
	public void setMnMru(String mnMru) {
		this.mnMru = mnMru;
	}
	
	@Column(name = "MN_METER_ID")
	public String getMnMeterId() {
		return mnMeterId;
	}
	public void setMnMeterId(String mnMeterId) {
		this.mnMeterId = mnMeterId;
	}
	
	@Column(name = "MN_NAME")
	public String getMnName() {
		return mnName;
	}
	public void setMnName(String mnName) {
		this.mnName = mnName;
	}
	
	@Column(name = "MN_ADDRESS")
	public String getMnAddress() {
		return mnAddress;
	}
	public void setMnAddress(String mnAddress) {
		this.mnAddress = mnAddress;
	}
	
	@Column(name = "MN_P_DT")
	public Date getMnPDt() {
		return mnPDt;
	}
	public void setMnPDt(Date mnPDt) {
		this.mnPDt = mnPDt;
	}
	
	@Column(name = "MN_L_DT")
	public Date getMnLDt() {
		return mnLDt;
	}
	public void setMnLDt(Date mnLDt) {
		this.mnLDt = mnLDt;
	}
	
	@Column(name = "MN_PREAD")
	public BigDecimal getMnPread() {
		return mnPread;
	}
	public void setMnPread(BigDecimal mnPread) {
		this.mnPread = mnPread;
	}
	
	@Column(name = "MN_LREAD")
	public BigDecimal getMnLread() {
		return mnLread;
	}
	public void setMnLread(BigDecimal mnLread) {
		this.mnLread = mnLread;
	}
	
	@Column(name = "MN_RATE_CAT")
	public String getMnRateCat() {
		return mnRateCat;
	}
	public void setMnRateCat(String mnRateCat) {
		this.mnRateCat = mnRateCat;
	}
	
	@Column(name = "MN_CT")
	public BigDecimal getMnCt() {
		return mnCt;
	}
	public void setMnCt(BigDecimal mnCt) {
		this.mnCt = mnCt;
	}
	
	@Column(name = "MN_KWH_TOTAL")
	public BigDecimal getMnKwhTotal() {
		return mnKwhTotal;
	}
	public void setMnKwhTotal(BigDecimal mnKwhTotal) {
		this.mnKwhTotal = mnKwhTotal;
	}
	
	@Column(name = "MN_MAX_KW")
	public BigDecimal getMnMaxKw() {
		return mnMaxKw;
	}
	public void setMnMaxKw(BigDecimal mnMaxKw) {
		this.mnMaxKw = mnMaxKw;
	}
	
	@Column(name = "MN_INV_NO")
	public String getMnInvNo() {
		return mnInvNo;
	}
	public void setMnInvNo(String mnInvNo) {
		this.mnInvNo = mnInvNo;
	}
	
	@Column(name = "MN_INV_AMT")
	public BigDecimal getMnInvAmt() {
		return mnInvAmt;
	}
	public void setMnInvAmt(BigDecimal mnInvAmt) {
		this.mnInvAmt = mnInvAmt;
	}
	
	@Column(name = "MN_VAT_AMT")
	public BigDecimal getMnVatAmt() {
		return mnVatAmt;
	}
	public void setMnVatAmt(BigDecimal mnVatAmt) {
		this.mnVatAmt = mnVatAmt;
	}
	
	@Column(name = "MN_FT_AMT")
	public BigDecimal getMnFtAmt() {
		return mnFtAmt;
	}
	public void setMnFtAmt(BigDecimal mnFtAmt) {
		this.mnFtAmt = mnFtAmt;
	}
	
	@Column(name = "MN_FT_RATE")
	public BigDecimal getMnFtRate() {
		return mnFtRate;
	}
	public void setMnFtRate(BigDecimal mnFtRate) {
		this.mnFtRate = mnFtRate;
	}
	
	@Column(name = "MN_DEMAND_AMT")
	public BigDecimal getMnDemandAmt() {
		return mnDemandAmt;
	}
	public void setMnDemandAmt(BigDecimal mnDemandAmt) {
		this.mnDemandAmt = mnDemandAmt;
	}
	
	@Column(name = "MN_PF_AMT")
	public BigDecimal getMnPfAmt() {
		return mnPfAmt;
	}
	public void setMnPfAmt(BigDecimal mnPfAmt) {
		this.mnPfAmt = mnPfAmt;
	}
	
	@Column(name = "MN_ON_KWH")
	public BigDecimal getMnOnKwh() {
		return mnOnKwh;
	}
	public void setMnOnKwh(BigDecimal mnOnKwh) {
		this.mnOnKwh = mnOnKwh;
	}
	
	@Column(name = "MN_OFF_KWH")
	public BigDecimal getMnOffKwh() {
		return mnOffKwh;
	}
	public void setMnOffKwh(BigDecimal mnOffKwh) {
		this.mnOffKwh = mnOffKwh;
	}
	
	@Column(name = "MN_KVAR")
	public BigDecimal getMnKvar() {
		return mnKvar;
	}
	public void setMnKvar(BigDecimal mnKvar) {
		this.mnKvar = mnKvar;
	}
	
	@Column(name = "MO_ITEM")
	public BigDecimal getMoItem() {
		return moItem;
	}
	public void setMoItem(BigDecimal moItem) {
		this.moItem = moItem;
	}
	
	@Column(name = "MO_AREA")
	public String getMoArea() {
		return moArea;
	}
	public void setMoArea(String moArea) {
		this.moArea = moArea;
	}
	
	@Column(name = "MO_MRU")
	public String getMoMru() {
		return moMru;
	}
	public void setMoMru(String moMru) {
		this.moMru = moMru;
	}
	
	@Column(name = "MO_METER_ID")
	public String getMoMeterId() {
		return moMeterId;
	}
	public void setMoMeterId(String moMeterId) {
		this.moMeterId = moMeterId;
	}
	
	@Column(name = "MO_NAME")
	public String getMoName() {
		return moName;
	}
	public void setMoName(String moName) {
		this.moName = moName;
	}
	
	@Column(name = "MO_ADDRESS")
	public String getMoAddress() {
		return moAddress;
	}
	public void setMoAddress(String moAddress) {
		this.moAddress = moAddress;
	}
	
	@Column(name = "MO_VOLTAGE")
	public String getMoVoltage() {
		return moVoltage;
	}
	public void setMoVoltage(String moVoltage) {
		this.moVoltage = moVoltage;
	}
	
	@Column(name = "MO_KW")
	public BigDecimal getMoKw() {
		return moKw;
	}
	public void setMoKw(BigDecimal moKw) {
		this.moKw = moKw;
	}
	
	@Column(name = "MO_CT")
	public BigDecimal getMoCt() {
		return moCt;
	}
	public void setMoCt(BigDecimal moCt) {
		this.moCt = moCt;
	}
	
	@Column(name = "MO_P_DT")
	public Date getMoPDt() {
		return moPDt;
	}
	public void setMoPDt(Date moPDt) {
		this.moPDt = moPDt;
	}
	
	@Column(name = "MO_L_DT")
	public Date getMoLDt() {
		return moLDt;
	}
	public void setMoLDt(Date moLDt) {
		this.moLDt = moLDt;
	}
	
	@Column(name = "MO_PREAD")
	public BigDecimal getMoPread() {
		return moPread;
	}
	public void setMoPread(BigDecimal moPread) {
		this.moPread = moPread;
	}
	
	@Column(name = "MO_LREAD")
	public BigDecimal getMoLread() {
		return moLread;
	}
	public void setMoLread(BigDecimal moLread) {
		this.moLread = moLread;
	}
	
	@Column(name = "MO_KWH_TOTAL")
	public BigDecimal getMoKwhTotal() {
		return moKwhTotal;
	}
	public void setMoKwhTotal(BigDecimal moKwhTotal) {
		this.moKwhTotal = moKwhTotal;
	}
	
	@Column(name = "MO_INV_AMT")
	public BigDecimal getMoInvAmt() {
		return moInvAmt;
	}
	public void setMoInvAmt(BigDecimal moInvAmt) {
		this.moInvAmt = moInvAmt;
	}
	
	@Column(name = "MO_VAT_AMT")
	public BigDecimal getMoVatAmt() {
		return moVatAmt;
	}
	public void setMoVatAmt(BigDecimal moVatAmt) {
		this.moVatAmt = moVatAmt;
	}
	
	@Column(name = "MO_RATE_CAT")
	public String getMoRateCat() {
		return moRateCat;
	}
	public void setMoRateCat(String moRateCat) {
		this.moRateCat = moRateCat;
	}
	
	@Column(name = "MO_INV_NO")
	public String getMoInvNo() {
		return moInvNo;
	}
	public void setMoInvNo(String moInvNo) {
		this.moInvNo = moInvNo;
	}
	
	@Column(name = "MO_FT_AMT")
	public BigDecimal getMoFtAmt() {
		return moFtAmt;
	}
	public void setMoFtAmt(BigDecimal moFtAmt) {
		this.moFtAmt = moFtAmt;
	}
	
	@Column(name = "MO_FT_RATE")
	public BigDecimal getMoFtRate() {
		return moFtRate;
	}
	public void setMoFtRate(BigDecimal moFtRate) {
		this.moFtRate = moFtRate;
	}
	
	@Column(name = "MO_DEMAND_AMT")
	public BigDecimal getMoDemandAmt() {
		return moDemandAmt;
	}
	public void setMoDemandAmt(BigDecimal moDemandAmt) {
		this.moDemandAmt = moDemandAmt;
	}
	
	@Column(name = "MO_PF_AMT")
	public BigDecimal getMoPfAmt() {
		return moPfAmt;
	}
	public void setMoPfAmt(BigDecimal moPfAmt) {
		this.moPfAmt = moPfAmt;
	}
	
	@Column(name = "MO_FILLER")
	public String getMoFiller() {
		return moFiller;
	}
	public void setMoFiller(String moFiller) {
		this.moFiller = moFiller;
	}
	
	@Column(name = "PROCESS_STATUS")
	public String getProcessStatus() {
		return processStatus;
	}
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	
	@Column(name = "LOAD_STATUS")
	public String getLoadStatus() {
		return loadStatus;
	}
	public void setLoadStatus(String loadStatus) {
		this.loadStatus = loadStatus;
	}
	
	@Column(name = "CAL_STATUS")
	public String getCalStatus() {
		return calStatus;
	}
	public void setCalStatus(String calStatus) {
		this.calStatus = calStatus;
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
	
	@Column(name = "VERSION")
	public BigDecimal getVersion() {
		return version;
	}
	public void setVersion(BigDecimal version) {
		this.version = version;
	}
	
	@Column(name = "INV_NO")
	public String getInvNo() {
		return invNo;
	}
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	@Column(name = "METER_ID")
	public String getMeterId() {
		return meterId;
	}
	public void setMeterId(String meterId) {
		this.meterId = meterId;
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
	
	@Column(name = "AREA_CODE")
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	
	@Column(name = "AREA_NAME")
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "REGION")
	@NotFound(action=NotFoundAction.IGNORE)
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PROVINCE")
	@NotFound(action=NotFoundAction.IGNORE)
	public Province getProvince() {
		return province;
	}	
	public void setProvince(Province province) {
		this.province = province;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AMPHUR")
	@NotFound(action=NotFoundAction.IGNORE)
	public Amphur getAmphur() {
		return amphur;
	}
	public void setAmphur(Amphur amphur) {
		this.amphur = amphur;
	}
	
	@Column(name = "METER_RATE")
	public String getMeterRate() {
		return meterRate;
	}
	public void setMeterRate(String meterRate) {
		this.meterRate = meterRate;
	}
	
	@Column(name = "METER_TYPE")
	public String getMeterType() {
		return meterType;
	}
	public void setMeterType(String meterType) {
		this.meterType = meterType;
	}
	
	@Column(name = "BILLPERIOD")
	public Date getBillperiod() {
		return billperiod;
	}
	public void setBillperiod(Date billperiod) {
		this.billperiod = billperiod;
	}
	
	@Column(name = "P_DT")
	public Date getpDt() {
		return pDt;
	}
	public void setpDt(Date pDt) {
		this.pDt = pDt;
	}
	
	@Column(name = "L_DT")
	public Date getlDt() {
		return lDt;
	}
	public void setlDt(Date lDt) {
		this.lDt = lDt;
	}
	
	@Column(name = "INV_AMT")
	public BigDecimal getInvAmt() {
		return invAmt;
	}
	public void setInvAmt(BigDecimal invAmt) {
		this.invAmt = invAmt;
	}
	
	@Column(name = "INV_VAT_AMT")
	public BigDecimal getInvVatAmt() {
		return invVatAmt;
	}	
	public void setInvVatAmt(BigDecimal invVatAmt) {
		this.invVatAmt = invVatAmt;
	}
	
	@Column(name = "SYS_AMT")
	public BigDecimal getSysAmt() {
		return sysAmt;
	}
	public void setSysAmt(BigDecimal sysAmt) {
		this.sysAmt = sysAmt;
	}
	
	@Column(name = "DIFF_AMT")
	public BigDecimal getDiffAmt() {
		return diffAmt;
	}
	public void setDiffAmt(BigDecimal diffAmt) {
		this.diffAmt = diffAmt;
	}
	
	@Column(name = "PAID_FLAG")
	public String getPaidFlag() {
		return paidFlag;
	}
	public void setPaidFlag(String paidFlag) {
		this.paidFlag = paidFlag;
	}
	
	@Column(name = "CLEARING_FLAG")
	public String getClearingFlag() {
		return clearingFlag;
	}
	public void setClearingFlag(String clearingFlag) {
		this.clearingFlag = clearingFlag;
	}
	
	@Column(name = "RECORD_STATUS")
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	
	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "UNIT")
	public BigDecimal getUnit() {
		return unit;
	}
	public void setUnit(BigDecimal unit) {
		this.unit = unit;
	}
	
	@Column(name = "ELECT_ONPEAK")
	public BigDecimal getElectOnpeak() {
		return electOnpeak;
	}
	public void setElectOnpeak(BigDecimal electOnpeak) {
		this.electOnpeak = electOnpeak;
	}
	
	@Column(name = "ELECT_OFFPEAK")
	public BigDecimal getElectOffpeak() {
		return electOffpeak;
	}
	public void setElectOffpeak(BigDecimal electOffpeak) {
		this.electOffpeak = electOffpeak;
	}
	
	@Column(name = "ELECT_DEMAND_ON")
	public BigDecimal getElectDemandOn() {
		return electDemandOn;
	}
	public void setElectDemandOn(BigDecimal electDemandOn) {
		this.electDemandOn = electDemandOn;
	}
	
	@Column(name = "ELECT_DEMAND_OFF")
	public BigDecimal getElectDemandOff() {
		return electDemandOff;
	}
	public void setElectDemandOff(BigDecimal electDemandOff) {
		this.electDemandOff = electDemandOff;
	}
	
	@Column(name = "REACTIVE")
	public BigDecimal getReactive() {
		return reactive;
	}
	public void setReactive(BigDecimal reactive) {
		this.reactive = reactive;
	}
	
	@Column(name = "KWH_TOTAL")
	public BigDecimal getKwhTotal() {
		return kwhTotal;
	}
	public void setKwhTotal(BigDecimal kwhTotal) {
		this.kwhTotal = kwhTotal;
	}
	
	@Column(name = "ELECT_DEMAND_PART")
	public BigDecimal getElectDemandPart() {
		return electDemandPart;
	}
	public void setElectDemandPart(BigDecimal electDemandPart) {
		this.electDemandPart = electDemandPart;
	}
	
	@Column(name = "KWH_ON")
	public BigDecimal getKwhOn() {
		return kwhOn;
	}
	public void setKwhOn(BigDecimal kwhOn) {
		this.kwhOn = kwhOn;
	}
	
	@Column(name = "KWH_OFF")
	public BigDecimal getKwhOff() {
		return kwhOff;
	}
	public void setKwhOff(BigDecimal kwhOff) {
		this.kwhOff = kwhOff;
	}
	
	@Column(name = "ELECT_DEMAND")
	public BigDecimal getElectDemand() {
		return electDemand;
	}
	public void setElectDemand(BigDecimal electDemand) {
		this.electDemand = electDemand;
	}
	@Override
	@Column(name="CREATE_BY")
	public String getCreateBy() {
		return this.createBy;
	}
		@Override
	public void setCreateBy(String createBy) {		
		this.createBy = createBy;			
	}		
		@Override	
		@Column(name="CREATE_DT")
	public Date getCreateDt() {
		return this.createDt;
	}
		@Override	
		public void setCreateDt(Date createDt) {		
			this.createDt = createDt;			
			}
	@Override
	@Column(name="UPDATE_BY")
	public String getUpdateBy() {
		return this.updateBy;
	}
		@Override	
		public void setUpdateBy(String updateBy) {		
			this.updateBy = updateBy; 			
			}
	@Override
	@Column(name="UPDATE_DT")
	public Date getUpdateDt() {
		return this.updateDt;
	}
	
	@Override
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
		
	}
	
	@Column(name="METER_TYPE_FLAG")
	public String getMeterTypeFlag() {
		return meterTypeFlag;
	}
	public void setMeterTypeFlag(String meterTypeFlag) {
		this.meterTypeFlag = meterTypeFlag;
	}
	
	@Column(name="TODTOU_FLAG")
	public String getTodtouFlag() {
		return todtouFlag;
	}
	public void setTodtouFlag(String todtouFlag) {
		this.todtouFlag = todtouFlag;
	}
	
	@Column(name="KWH_FLAG")
	public String getKwhFlag() {
		return kwhFlag;
	}
	public void setKwhFlag(String kwhFlag) {
		this.kwhFlag = kwhFlag;
	}
	
	@Column(name="SERVICE_FLAG")
	public String getServiceFlag() {
		return serviceFlag;
	}
	public void setServiceFlag(String serviceFlag) {
		this.serviceFlag = serviceFlag;
	}
	
	@Column(name="DATA_FLAG")
	public String getDataFlag() {
		return dataFlag;
	}
	public void setDataFlag(String dataFlag) {
		this.dataFlag = dataFlag;
	}
	
	@Column(name="CAL_FLAG")
	public String getCalFlag() {
		return calFlag;
	}
	public void setCalFlag(String calFlag) {
		this.calFlag = calFlag;
	}
	
	@Column(name="P_READ")
	public String getpRead() {
		return pRead;
	}
	public void setpRead(String pRead) {
		this.pRead = pRead;
	}
	
	@Column(name="L_READ")
	public String getlRead() {
		return lRead;
	}
	public void setlRead(String lRead) {
		this.lRead = lRead;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ELECTRIC_ID")
	public Management getElectricId() {
		return electricId;
	}
	public void setElectricId(Management electricId) {
		this.electricId = electricId;
	}
	
	@Transient
	public String getBillPeriodTH(){
		String dtStrReturn = (null != billperiod) ? SDF.format(billperiod) : "";
		
		return dtStrReturn;
	}
	
	@Transient
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	@Column(name="SITE_STATUS")
	public String getSiteStatus() {
		return siteStatus;
	}
	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}
	
	@Column(name="PROCESS_STATUS_CODE")
	public String getProcessStatusCode() {
		return processStatusCode;
	}
	public void setProcessStatusCode(String processStatusCode) {
		this.processStatusCode = processStatusCode;
	}
	
	@Transient
	public String getSiteStatusDesc() {
		return siteStatusDesc;
	}
	public void setSiteStatusDesc(String siteStatusDesc) {
		this.siteStatusDesc = siteStatusDesc;
	}
	
	
	@Transient
	public String getProcessStatusCodeDesc() {
		return processStatusCodeDesc;
	}
	public void setProcessStatusCodeDesc(String processStatusCodeDesc) {
		this.processStatusCodeDesc = processStatusCodeDesc;
	}
	
	@Column(name="SEQ_NO")
	public String getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	
	@Column(name="CT")
	public BigDecimal getCt() {
		return ct;
	}
	public void setCt(BigDecimal ct) {
		this.ct = ct;
	}
	
	@Column(name = "COMPANY_NAME")
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Column(name = "COMPANY_FLAG")
	public String getCompanyFlag() {
		return companyFlag;
	}
	public void setCompanyFlag(String companyFlag) {
		this.companyFlag = companyFlag;
	}
	
	@Column(name = "CT_FLAG")
	public String getCtFlag() {
		return ctFlag;
	}
	public void setCtFlag(String ctFlag) {
		this.ctFlag = ctFlag;
	}
	@Column(name = "DUP_PAID_FLAG")
	public String getPaidStatus() {
		return paidStatus;
	}
	
	public void setPaidStatus(String paidStatus) {
		this.paidStatus = paidStatus;
	}
	@Column(name = "OLD_CONTRACT_NO")
	public String getOldContractNo() {
		return oldContractNo;
	}
	public void setOldContractNo(String oldContractNo) {
		this.oldContractNo = oldContractNo;
	}
	
	// Momo
	
	@Column(name = "INS_P_DT")
	public Date getInstallmentPDate() {
		return installmentPDate;
	}
	public void setInstallmentPDate(Date installmentPDate) {
		this.installmentPDate = installmentPDate;
	}
	@Column(name = "INS_L_DT")
	public Date getInstallmenLDate() {
		return installmenLDate;
	}
	public void setInstallmenLDate(Date installmenLDate) {
		this.installmenLDate = installmenLDate;
	}
	@Column(name = "INS_P_READ")
	public String getInstallmenPRead() {
		return installmenPRead;
	}
	public void setInstallmenPRead(String installmenPRead) {
		this.installmenPRead = installmenPRead;
	}
	@Column(name = "INS_L_READ")
	public String getInstallmenLRead() {
		return installmenLRead;
	}
	public void setInstallmenLRead(String installmenLRead) {
		this.installmenLRead = installmenLRead;
	}
	@Column(name = "INS_KWH_TOTAL")
	public BigDecimal getInstallmenKWH() {
		return installmenKWH;
	}
	public void setInstallmenKWH(BigDecimal installmenKWH) {
		this.installmenKWH = installmenKWH;
	}
	@Column(name = "INS_VAT_AMT")
	public BigDecimal getInstallmenVatAmount() {
		return installmenVatAmount;
	}
	public void setInstallmenVatAmount(BigDecimal installmenVatAmount) {
		this.installmenVatAmount = installmenVatAmount;
	}
	@Column(name = "INS_INC_VAT_AMT")
	public BigDecimal getInstallmenIncVatAmount() {
		return installmenIncVatAmount;
	}
	public void setInstallmenIncVatAmount(BigDecimal installmenIncVatAmount) {
		this.installmenIncVatAmount = installmenIncVatAmount;
	}
	
	@Transient
	public String getInstallmentPDateTH(){
		String dtStrReturn = (null != installmentPDate) ? SDF.format(installmentPDate) : "";
		
		return dtStrReturn;
	}
	
	@Transient
	public String getInstallmentLDateTH(){
		String dtStrReturn = (null != installmenLDate) ? SDF.format(installmenLDate) : "";
		
		return dtStrReturn;
	}
	@Column(name = "TEXT_BILLPERIOD")
	public Date getTxtBillDate() {
		return txtBillDate;
	}
	public void setTxtBillDate(Date txtBillDate) {
		this.txtBillDate = txtBillDate;
	}
	@Transient
	public String getTxtBillDateTH() {
	String dtStrReturn = (null != txtBillDate) ? SDF.format(txtBillDate) : "";
		
		return dtStrReturn;
	}
	
	
	@Transient
	public String getTxtPDtTH(){
		String dtStrReturn = (null != pDt) ? SDF.format(pDt) : "";
		
		return dtStrReturn; 
	}
	@Transient
	public String getTxtLDtTH(){
		String dtStrReturn = (null != lDt) ? SDF.format(lDt) : "";
		
		return dtStrReturn;
	}
	@Transient
	public String getTermOfPayment() {
		return termOfPayment;
	}
	public void setTermOfPayment(String termOfPayment) {
		this.termOfPayment = termOfPayment;
	}
	@Column(name = "BILLPERIOD_PDT")
	public Date getBillperiodPDt() {
		return billperiodPDt;
	}
	public void setBillperiodPDt(Date billperiodPDt) {
		this.billperiodPDt = billperiodPDt;
	}
	
	@Transient
	public String getTxtBillPDtTH(){
		String dtStrReturn = (null != billperiodPDt) ? SDF.format(billperiodPDt) : "";
		
		return dtStrReturn;
	}
	
	@Column(name = "BILLPERIOD_lDT")
	public Date getBillperiodLDt() {
		return billperiodLDt;
	}
	public void setBillperiodLDt(Date billperiodLDt) {
		this.billperiodLDt = billperiodLDt;
	}
	
	@Transient
	public String getTxtBillLDtTH(){
		String dtStrReturn = (null != billperiodLDt) ? SDF.format(billperiodLDt) : "";
		
		return dtStrReturn;
	}
	@Transient
	public String getCurrentTermOfPaymentDetail() {
		return currentTermOfPaymentDetail;
	}
	public void setCurrentTermOfPaymentDetail(String currentTermOfPaymentDetail) {
		this.currentTermOfPaymentDetail = currentTermOfPaymentDetail;
	}
	@Transient
	public String getNextTermOfPaymentDetail() {
		return nextTermOfPaymentDetail;
	}
	public void setNextTermOfPaymentDetail(String nextTermOfPaymentDetail) {
		this.nextTermOfPaymentDetail = nextTermOfPaymentDetail;
	}
	@Transient
	public String getTermOfPaymentDetail() {
		return termOfPaymentDetail;
	}
	public void setTermOfPaymentDetail(String termOfPaymentDetail) {
		this.termOfPaymentDetail = termOfPaymentDetail;
	}
	@Column(name = "REMARK_PAYMENT")
	public String getRemarkPaymentDetail() {
		return remarkPaymentDetail;
	}
	public void setRemarkPaymentDetail(String remarkPaymentDetail) {
		this.remarkPaymentDetail = remarkPaymentDetail;
	}
	@Column(name = "PROCESS_ID")
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	@Transient
	public String getEffDtStr() {
		return effDtStr;
	}
	public void setEffDtStr(String effDtStr) {
		this.effDtStr = effDtStr;
	}
	@Transient
	public String getExpDtStr() {
		return expDtStr;
	}
	public void setExpDtStr(String expDtStr) {
		this.expDtStr = expDtStr;
	}
	@Transient
	public String getNetworkStatusDesc() {
		return networkStatusDesc;
	}
	public void setNetworkStatusDesc(String networkStatusDesc) {
		this.networkStatusDesc = networkStatusDesc;
	}
	@Transient
	public String getMeterStatus() {
		return meterStatus;
	}
	public void setMeterStatus(String meterStatus) {
		this.meterStatus = meterStatus;
	}
	@Transient
	public Date getEffDt() {
		return effDt;
	}
	public void setEffDt(Date effDt) {
		this.effDt = effDt;
	}
	@Transient
	public Date getExpDt() {
		return expDt;
	}
	public void setExpDt(Date expDt) {
		this.expDt = expDt;
	}
	@Transient
	public String getBillperiodPDtStr() {
		return billperiodPDtStr;
	}
	public void setBillperiodPDtStr(String billperiodPDtStr) {
		this.billperiodPDtStr = billperiodPDtStr;
	}
	@Transient
	public String getOwnerGroup() {
		return ownerGroup;
	}
	public void setOwnerGroup(String ownerGroup) {
		this.ownerGroup = ownerGroup;
	}
	@Transient
	public String getOwnerGroupName() {
		return ownerGroupName;
	}
	public void setOwnerGroupName(String ownerGroupName) {
		this.ownerGroupName = ownerGroupName;
	}
	@Column(name = "PERIOD_FLAG")
	public String getPeriodFlag() {
		return periodFlag;
	}
	public void setPeriodFlag(String periodFlag) {
		this.periodFlag = periodFlag;
	}
	@Column(name = "CONTRACT_STATUS_FLAG")
	public String getContStatusInactiveFlag() {
		return contStatusInactiveFlag;
	}
	public void setContStatusInactiveFlag(String contStatusInactiveFlag) {
		this.contStatusInactiveFlag = contStatusInactiveFlag;
	}
	@Column(name = "NETWORK_STATUS_FLAG")
	public String getNetworkStatusInactiveFlag() {
		return networkStatusInactiveFlag;
	}
	public void setNetworkStatusInactiveFlag(String networkStatusInactiveFlag) {
		this.networkStatusInactiveFlag = networkStatusInactiveFlag;
	}
	@Column(name = "GROWTH_FLAG")
	public String getGrowthFlag() {
		return growthFlag;
	}
	public void setGrowthFlag(String growthFlag) {
		this.growthFlag = growthFlag;
	}
	@Transient
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Transient
	public BigDecimal getElAmt() {
		return elAmt;
	}
	public void setElAmt(BigDecimal elAmt) {
		this.elAmt = elAmt;
	}
	
}
