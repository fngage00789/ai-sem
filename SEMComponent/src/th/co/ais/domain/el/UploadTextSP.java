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

public class UploadTextSP extends AbstractDomain implements java.io.Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2952177123480041398L;
	private String rowId;
	
	private String uploadTextId;
	
	private String elImportTranId;
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
	private String region;
	private Province province;
	private Amphur amphur;
	private String meterRate;
	private String meterType;
	private Date billperiod;
	private Date pDt;	
	private Date lDt;
	private Double invAmtNumber;
	private String invAmt;
	private Double invVatAmtNumber;
	private String invVatAmt;
	private Double sysAmtNumber;
	private String sysAmt;
	private Double diffAmtNumber;
	private String diffAmt;
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
	private String kwhTotal;
	private Double kwhTotalNumber;
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
	//private String txtBillDateTH;
	//
	
	private String termOfPayment;
	private String currentTermOfPaymentDetail;
	private String nextTermOfPaymentDetail;
	private String termOfPaymentDetail;
	private String remarkPaymentDetail;
	private String processId;
	private String elGroup;
	private String elGroupName;
	
	
	
	//add By Noom
	private String amphurId;
	private String engName;
	private String provinceId;
	private String thaiName;
	private String zipCode;
	private String zone;

	private String lacCode;
	private String provinceCode;

	private String samRegion;
	
	private String engDesc;
	private String thaiDesc;

	private String company;

	private String dbTotalSize;
	private String endProcessDt;
		
	private String failPaid;
	private String fileName;
	private String invTotalSize;
	private String noDbTotalSize;
	private String paymentId;
	private Date processDt;

	private String refDocId;
	private String successNoPaid;
	private String successPaid;
	private String techErrorCode;
	private String totalFileRecord;

	private Date uploadDt;
	private String uploadFail;
	private String uploadSuccess;
	private String validateFail;
	private String validateRecord;
	private String validateSuccess;
	private String ownerGroup;
	private String ownerGroupName;
	private String billperiodPDtStr;
	
	
	private String month1M;	
	private String kwh1M;
	private String amount1M;
	private String unit1M;	
	private String kwhAvg1M;	
	private String amountAvg1M;	
	private String unitAvg1M;
	
	private String month3M;	
	private String kwh3M;
	private String amount3M;
	private String unit3M;	
	private String kwhAvg3M;	
	private String amountAvg3M;	
	private String unitAvg3M;
	
	private String month6M;	
	private String kwh6M;
	private String amount6M;
	private String unit6M;	
	private String kwhAvg6M;	
	private String amountAvg6M;	
	private String unitAvg6M;
	
	private String month12M;	
	private String kwh12M;
	private String amount12M;
	private String unit12M;	
	private String kwhAvg12M;	
	private String amountAvg12M;	
	private String unitAvg12M;
	
	private Date effDate;
	private Date expDate;
	private String siteStats2;
	private String networkStatus;
	private String meterStatus;
	
	private String percentGrowth;
	private String month;
	private String type;
	
	private String effDateStr;
	private String expDateStr;
	
	private Date billPeriodFromPDt;
	private String billPeriodFromPDtStr;
	private String amphurStr;	
	private String electricIdStr;
	private String dupPaidFlag;
	private String provinceStr;
	private String textBillPeriod;
	private String failNoPaid;
	private String techErrorDesc;
	private String uploadBy;
	private String improtDataDetailId;
	private String networkStatusDesc;
	
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
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getElImportTranId() {
		return elImportTranId;
	}
	public void setElImportTranId(String elImportTranId) {
		this.elImportTranId = elImportTranId;
	}
	public ImportTransaction getTextFileId() {
		return textFileId;
	}
	public void setTextFileId(ImportTransaction textFileId) {
		this.textFileId = textFileId;
	}
	public String getElectricUseType() {
		return electricUseType;
	}
	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public BigDecimal getPnItem() {
		return pnItem;
	}
	public void setPnItem(BigDecimal pnItem) {
		this.pnItem = pnItem;
	}
	public String getPnMorTor() {
		return pnMorTor;
	}
	public void setPnMorTor(String pnMorTor) {
		this.pnMorTor = pnMorTor;
	}
	public String getPnMru() {
		return pnMru;
	}
	public void setPnMru(String pnMru) {
		this.pnMru = pnMru;
	}
	public String getPnMeterId() {
		return pnMeterId;
	}
	public void setPnMeterId(String pnMeterId) {
		this.pnMeterId = pnMeterId;
	}
	public String getPnName() {
		return pnName;
	}
	public void setPnName(String pnName) {
		this.pnName = pnName;
	}
	public String getPnAddress() {
		return pnAddress;
	}
	public void setPnAddress(String pnAddress) {
		this.pnAddress = pnAddress;
	}
	public String getPnVoltage() {
		return pnVoltage;
	}
	public void setPnVoltage(String pnVoltage) {
		this.pnVoltage = pnVoltage;
	}
	public String getPnKw() {
		return pnKw;
	}
	public void setPnKw(String pnKw) {
		this.pnKw = pnKw;
	}
	public BigDecimal getPnMultiply() {
		return pnMultiply;
	}
	public void setPnMultiply(BigDecimal pnMultiply) {
		this.pnMultiply = pnMultiply;
	}
	public Date getPnPmrDt() {
		return pnPmrDt;
	}
	public void setPnPmrDt(Date pnPmrDt) {
		this.pnPmrDt = pnPmrDt;
	}
	public Date getPnMrDt() {
		return pnMrDt;
	}
	public void setPnMrDt(Date pnMrDt) {
		this.pnMrDt = pnMrDt;
	}
	public BigDecimal getPnPmr() {
		return pnPmr;
	}
	public void setPnPmr(BigDecimal pnPmr) {
		this.pnPmr = pnPmr;
	}
	public BigDecimal getPnMr() {
		return pnMr;
	}
	public void setPnMr(BigDecimal pnMr) {
		this.pnMr = pnMr;
	}
	public BigDecimal getPnUnit() {
		return pnUnit;
	}
	public void setPnUnit(BigDecimal pnUnit) {
		this.pnUnit = pnUnit;
	}
	public BigDecimal getPnAmt() {
		return pnAmt;
	}
	public void setPnAmt(BigDecimal pnAmt) {
		this.pnAmt = pnAmt;
	}
	public BigDecimal getPnVatAmt() {
		return pnVatAmt;
	}
	public void setPnVatAmt(BigDecimal pnVatAmt) {
		this.pnVatAmt = pnVatAmt;
	}
	public String getPnRateCat() {
		return pnRateCat;
	}
	public void setPnRateCat(String pnRateCat) {
		this.pnRateCat = pnRateCat;
	}
	public String getPnInvNo() {
		return pnInvNo;
	}
	public void setPnInvNo(String pnInvNo) {
		this.pnInvNo = pnInvNo;
	}
	public BigDecimal getPnFt() {
		return pnFt;
	}
	public void setPnFt(BigDecimal pnFt) {
		this.pnFt = pnFt;
	}
	public BigDecimal getPnTou() {
		return pnTou;
	}
	public void setPnTou(BigDecimal pnTou) {
		this.pnTou = pnTou;
	}
	public String getPnPeaCode() {
		return pnPeaCode;
	}
	public void setPnPeaCode(String pnPeaCode) {
		this.pnPeaCode = pnPeaCode;
	}
	public String getPnPeaname() {
		return pnPeaname;
	}
	public void setPnPeaname(String pnPeaname) {
		this.pnPeaname = pnPeaname;
	}
	public String getPnBillperiod() {
		return pnBillperiod;
	}
	public void setPnBillperiod(String pnBillperiod) {
		this.pnBillperiod = pnBillperiod;
	}
	public BigDecimal getPnPkpmrNew() {
		return pnPkpmrNew;
	}
	public void setPnPkpmrNew(BigDecimal pnPkpmrNew) {
		this.pnPkpmrNew = pnPkpmrNew;
	}
	public BigDecimal getPnPkmrNew() {
		return pnPkmrNew;
	}
	public void setPnPkmrNew(BigDecimal pnPkmrNew) {
		this.pnPkmrNew = pnPkmrNew;
	}
	public BigDecimal getPnPkunitNew() {
		return pnPkunitNew;
	}
	public void setPnPkunitNew(BigDecimal pnPkunitNew) {
		this.pnPkunitNew = pnPkunitNew;
	}
	public BigDecimal getPnOpkpmrNew() {
		return pnOpkpmrNew;
	}
	public void setPnOpkpmrNew(BigDecimal pnOpkpmrNew) {
		this.pnOpkpmrNew = pnOpkpmrNew;
	}
	public BigDecimal getPnOpkmrNew() {
		return pnOpkmrNew;
	}
	public void setPnOpkmrNew(BigDecimal pnOpkmrNew) {
		this.pnOpkmrNew = pnOpkmrNew;
	}
	public BigDecimal getPnOpkunitNew() {
		return pnOpkunitNew;
	}
	public void setPnOpkunitNew(BigDecimal pnOpkunitNew) {
		this.pnOpkunitNew = pnOpkunitNew;
	}
	public BigDecimal getPnHldpmrNew() {
		return pnHldpmrNew;
	}
	public void setPnHldpmrNew(BigDecimal pnHldpmrNew) {
		this.pnHldpmrNew = pnHldpmrNew;
	}
	public BigDecimal getPnHldmrNew() {
		return pnHldmrNew;
	}
	public void setPnHldmrNew(BigDecimal pnHldmrNew) {
		this.pnHldmrNew = pnHldmrNew;
	}
	public BigDecimal getPnhldunitNew() {
		return pnhldunitNew;
	}
	public void setPnhldunitNew(BigDecimal pnhldunitNew) {
		this.pnhldunitNew = pnhldunitNew;
	}
	public BigDecimal getPoItem() {
		return poItem;
	}
	public void setPoItem(BigDecimal poItem) {
		this.poItem = poItem;
	}
	public String getPoArea() {
		return poArea;
	}
	public void setPoArea(String poArea) {
		this.poArea = poArea;
	}
	public String getPoMru() {
		return poMru;
	}
	public void setPoMru(String poMru) {
		this.poMru = poMru;
	}
	public String getPoMeterId() {
		return poMeterId;
	}
	public void setPoMeterId(String poMeterId) {
		this.poMeterId = poMeterId;
	}
	public String getPoName() {
		return poName;
	}
	public void setPoName(String poName) {
		this.poName = poName;
	}
	public String getPoAddress() {
		return poAddress;
	}
	public void setPoAddress(String poAddress) {
		this.poAddress = poAddress;
	}
	public String getPoVoltage() {
		return poVoltage;
	}
	public void setPoVoltage(String poVoltage) {
		this.poVoltage = poVoltage;
	}
	public BigDecimal getPoKw() {
		return poKw;
	}
	public void setPoKw(BigDecimal poKw) {
		this.poKw = poKw;
	}
	public BigDecimal getPoCt() {
		return poCt;
	}
	public void setPoCt(BigDecimal poCt) {
		this.poCt = poCt;
	}
	public Date getPoPDt() {
		return poPDt;
	}
	public void setPoPDt(Date poPDt) {
		this.poPDt = poPDt;
	}
	public Date getPoLDt() {
		return poLDt;
	}
	public void setPoLDt(Date poLDt) {
		this.poLDt = poLDt;
	}
	public BigDecimal getPoPread() {
		return poPread;
	}
	public void setPoPread(BigDecimal poPread) {
		this.poPread = poPread;
	}
	public BigDecimal getPoLread() {
		return poLread;
	}
	public void setPoLread(BigDecimal poLread) {
		this.poLread = poLread;
	}
	public BigDecimal getPoKwhTotal() {
		return poKwhTotal;
	}
	public void setPoKwhTotal(BigDecimal poKwhTotal) {
		this.poKwhTotal = poKwhTotal;
	}
	public BigDecimal getPoInvAmt() {
		return poInvAmt;
	}
	public void setPoInvAmt(BigDecimal poInvAmt) {
		this.poInvAmt = poInvAmt;
	}
	public BigDecimal getPoVatAmt() {
		return poVatAmt;
	}
	public void setPoVatAmt(BigDecimal poVatAmt) {
		this.poVatAmt = poVatAmt;
	}
	public String getPoRateCat() {
		return poRateCat;
	}
	public void setPoRateCat(String poRateCat) {
		this.poRateCat = poRateCat;
	}
	public String getPoInvNo() {
		return poInvNo;
	}
	public void setPoInvNo(String poInvNo) {
		this.poInvNo = poInvNo;
	}
	public BigDecimal getPoFtAmt() {
		return poFtAmt;
	}
	public void setPoFtAmt(BigDecimal poFtAmt) {
		this.poFtAmt = poFtAmt;
	}
	public BigDecimal getPoFtRate() {
		return poFtRate;
	}
	public void setPoFtRate(BigDecimal poFtRate) {
		this.poFtRate = poFtRate;
	}
	public BigDecimal getPoDemandAmt() {
		return poDemandAmt;
	}
	public void setPoDemandAmt(BigDecimal poDemandAmt) {
		this.poDemandAmt = poDemandAmt;
	}
	public BigDecimal getPoPfAmt() {
		return poPfAmt;
	}
	public void setPoPfAmt(BigDecimal poPfAmt) {
		this.poPfAmt = poPfAmt;
	}
	public String getPoFiller2() {
		return poFiller2;
	}
	public void setPoFiller2(String poFiller2) {
		this.poFiller2 = poFiller2;
	}
	public String getPoPeacode() {
		return poPeacode;
	}
	public void setPoPeacode(String poPeacode) {
		this.poPeacode = poPeacode;
	}
	public String getPoCollection() {
		return poCollection;
	}
	public void setPoCollection(String poCollection) {
		this.poCollection = poCollection;
	}
	public String getPoUserNo() {
		return poUserNo;
	}
	public void setPoUserNo(String poUserNo) {
		this.poUserNo = poUserNo;
	}
	public Date getPoBillperiod() {
		return poBillperiod;
	}
	public void setPoBillperiod(Date poBillperiod) {
		this.poBillperiod = poBillperiod;
	}
	public BigDecimal getMnSeq() {
		return mnSeq;
	}
	public void setMnSeq(BigDecimal mnSeq) {
		this.mnSeq = mnSeq;
	}
	public String getMnMru() {
		return mnMru;
	}
	public void setMnMru(String mnMru) {
		this.mnMru = mnMru;
	}
	public String getMnMeterId() {
		return mnMeterId;
	}
	public void setMnMeterId(String mnMeterId) {
		this.mnMeterId = mnMeterId;
	}
	public String getMnName() {
		return mnName;
	}
	public void setMnName(String mnName) {
		this.mnName = mnName;
	}
	public String getMnAddress() {
		return mnAddress;
	}
	public void setMnAddress(String mnAddress) {
		this.mnAddress = mnAddress;
	}
	public Date getMnPDt() {
		return mnPDt;
	}
	public void setMnPDt(Date mnPDt) {
		this.mnPDt = mnPDt;
	}
	public Date getMnLDt() {
		return mnLDt;
	}
	public void setMnLDt(Date mnLDt) {
		this.mnLDt = mnLDt;
	}
	public BigDecimal getMnPread() {
		return mnPread;
	}
	public void setMnPread(BigDecimal mnPread) {
		this.mnPread = mnPread;
	}
	public BigDecimal getMnLread() {
		return mnLread;
	}
	public void setMnLread(BigDecimal mnLread) {
		this.mnLread = mnLread;
	}
	public String getMnRateCat() {
		return mnRateCat;
	}
	public void setMnRateCat(String mnRateCat) {
		this.mnRateCat = mnRateCat;
	}
	public BigDecimal getMnCt() {
		return mnCt;
	}
	public void setMnCt(BigDecimal mnCt) {
		this.mnCt = mnCt;
	}
	public BigDecimal getMnKwhTotal() {
		return mnKwhTotal;
	}
	public void setMnKwhTotal(BigDecimal mnKwhTotal) {
		this.mnKwhTotal = mnKwhTotal;
	}
	public BigDecimal getMnMaxKw() {
		return mnMaxKw;
	}
	public void setMnMaxKw(BigDecimal mnMaxKw) {
		this.mnMaxKw = mnMaxKw;
	}
	public String getMnInvNo() {
		return mnInvNo;
	}
	public void setMnInvNo(String mnInvNo) {
		this.mnInvNo = mnInvNo;
	}
	public BigDecimal getMnInvAmt() {
		return mnInvAmt;
	}
	public void setMnInvAmt(BigDecimal mnInvAmt) {
		this.mnInvAmt = mnInvAmt;
	}
	public BigDecimal getMnVatAmt() {
		return mnVatAmt;
	}
	public void setMnVatAmt(BigDecimal mnVatAmt) {
		this.mnVatAmt = mnVatAmt;
	}
	public BigDecimal getMnFtAmt() {
		return mnFtAmt;
	}
	public void setMnFtAmt(BigDecimal mnFtAmt) {
		this.mnFtAmt = mnFtAmt;
	}
	public BigDecimal getMnFtRate() {
		return mnFtRate;
	}
	public void setMnFtRate(BigDecimal mnFtRate) {
		this.mnFtRate = mnFtRate;
	}
	public BigDecimal getMnDemandAmt() {
		return mnDemandAmt;
	}
	public void setMnDemandAmt(BigDecimal mnDemandAmt) {
		this.mnDemandAmt = mnDemandAmt;
	}
	public BigDecimal getMnPfAmt() {
		return mnPfAmt;
	}
	public void setMnPfAmt(BigDecimal mnPfAmt) {
		this.mnPfAmt = mnPfAmt;
	}
	public BigDecimal getMnOnKwh() {
		return mnOnKwh;
	}
	public void setMnOnKwh(BigDecimal mnOnKwh) {
		this.mnOnKwh = mnOnKwh;
	}
	public BigDecimal getMnOffKwh() {
		return mnOffKwh;
	}
	public void setMnOffKwh(BigDecimal mnOffKwh) {
		this.mnOffKwh = mnOffKwh;
	}
	public BigDecimal getMnKvar() {
		return mnKvar;
	}
	public void setMnKvar(BigDecimal mnKvar) {
		this.mnKvar = mnKvar;
	}
	public BigDecimal getMoItem() {
		return moItem;
	}
	public void setMoItem(BigDecimal moItem) {
		this.moItem = moItem;
	}
	public String getMoArea() {
		return moArea;
	}
	public void setMoArea(String moArea) {
		this.moArea = moArea;
	}
	public String getMoMru() {
		return moMru;
	}
	public void setMoMru(String moMru) {
		this.moMru = moMru;
	}
	public String getMoMeterId() {
		return moMeterId;
	}
	public void setMoMeterId(String moMeterId) {
		this.moMeterId = moMeterId;
	}
	public String getMoName() {
		return moName;
	}
	public void setMoName(String moName) {
		this.moName = moName;
	}
	public String getMoAddress() {
		return moAddress;
	}
	public void setMoAddress(String moAddress) {
		this.moAddress = moAddress;
	}
	public String getMoVoltage() {
		return moVoltage;
	}
	public void setMoVoltage(String moVoltage) {
		this.moVoltage = moVoltage;
	}
	public BigDecimal getMoKw() {
		return moKw;
	}
	public void setMoKw(BigDecimal moKw) {
		this.moKw = moKw;
	}
	public BigDecimal getMoCt() {
		return moCt;
	}
	public void setMoCt(BigDecimal moCt) {
		this.moCt = moCt;
	}
	public Date getMoPDt() {
		return moPDt;
	}
	public void setMoPDt(Date moPDt) {
		this.moPDt = moPDt;
	}
	public Date getMoLDt() {
		return moLDt;
	}
	public void setMoLDt(Date moLDt) {
		this.moLDt = moLDt;
	}
	public BigDecimal getMoPread() {
		return moPread;
	}
	public void setMoPread(BigDecimal moPread) {
		this.moPread = moPread;
	}
	public BigDecimal getMoLread() {
		return moLread;
	}
	public void setMoLread(BigDecimal moLread) {
		this.moLread = moLread;
	}
	public BigDecimal getMoKwhTotal() {
		return moKwhTotal;
	}
	public void setMoKwhTotal(BigDecimal moKwhTotal) {
		this.moKwhTotal = moKwhTotal;
	}
	public BigDecimal getMoInvAmt() {
		return moInvAmt;
	}
	public void setMoInvAmt(BigDecimal moInvAmt) {
		this.moInvAmt = moInvAmt;
	}
	public BigDecimal getMoVatAmt() {
		return moVatAmt;
	}
	public void setMoVatAmt(BigDecimal moVatAmt) {
		this.moVatAmt = moVatAmt;
	}
	public String getMoRateCat() {
		return moRateCat;
	}
	public void setMoRateCat(String moRateCat) {
		this.moRateCat = moRateCat;
	}
	public String getMoInvNo() {
		return moInvNo;
	}
	public void setMoInvNo(String moInvNo) {
		this.moInvNo = moInvNo;
	}
	public BigDecimal getMoFtAmt() {
		return moFtAmt;
	}
	public void setMoFtAmt(BigDecimal moFtAmt) {
		this.moFtAmt = moFtAmt;
	}
	public BigDecimal getMoFtRate() {
		return moFtRate;
	}
	public void setMoFtRate(BigDecimal moFtRate) {
		this.moFtRate = moFtRate;
	}
	public BigDecimal getMoDemandAmt() {
		return moDemandAmt;
	}
	public void setMoDemandAmt(BigDecimal moDemandAmt) {
		this.moDemandAmt = moDemandAmt;
	}
	public BigDecimal getMoPfAmt() {
		return moPfAmt;
	}
	public void setMoPfAmt(BigDecimal moPfAmt) {
		this.moPfAmt = moPfAmt;
	}
	public String getMoFiller() {
		return moFiller;
	}
	public void setMoFiller(String moFiller) {
		this.moFiller = moFiller;
	}
	public String getProcessStatus() {
		return processStatus;
	}
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	public String getLoadStatus() {
		return loadStatus;
	}
	public void setLoadStatus(String loadStatus) {
		this.loadStatus = loadStatus;
	}
	public String getCalStatus() {
		return calStatus;
	}
	public void setCalStatus(String calStatus) {
		this.calStatus = calStatus;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	public BigDecimal getVersion() {
		return version;
	}
	public void setVersion(BigDecimal version) {
		this.version = version;
	}
	public String getInvNo() {
		return invNo;
	}
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	public String getMeterId() {
		return meterId;
	}
	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	public Amphur getAmphur() {
		return amphur;
	}
	public void setAmphur(Amphur amphur) {
		this.amphur = amphur;
	}
	public String getMeterRate() {
		return meterRate;
	}
	public void setMeterRate(String meterRate) {
		this.meterRate = meterRate;
	}
	public String getMeterType() {
		return meterType;
	}
	public void setMeterType(String meterType) {
		this.meterType = meterType;
	}
	public Date getBillperiod() {
		return billperiod;
	}
	public void setBillperiod(Date billperiod) {
		this.billperiod = billperiod;
	}
	public Date getpDt() {
		return pDt;
	}
	public void setpDt(Date pDt) {
		this.pDt = pDt;
	}
	public Date getlDt() {
		return lDt;
	}
	public void setlDt(Date lDt) {
		this.lDt = lDt;
	}

	public String getInvAmt() {
		return invAmt;
	}
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	public String getInvVatAmt() {
		return invVatAmt;
	}
	public void setInvVatAmt(String invVatAmt) {
		this.invVatAmt = invVatAmt;
	}
	
	public String getSysAmt() {
		return sysAmt;
	}
	public void setSysAmt(String sysAmt) {
		this.sysAmt = sysAmt;
	}

	public String getDiffAmt() {
		return diffAmt;
	}
	public void setDiffAmt(String diffAmt) {
		this.diffAmt = diffAmt;
	}
	public String getPaidFlag() {
		return paidFlag;
	}
	public void setPaidFlag(String paidFlag) {
		this.paidFlag = paidFlag;
	}
	public String getClearingFlag() {
		return clearingFlag;
	}
	public void setClearingFlag(String clearingFlag) {
		this.clearingFlag = clearingFlag;
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
	public BigDecimal getUnit() {
		return unit;
	}
	public void setUnit(BigDecimal unit) {
		this.unit = unit;
	}
	public BigDecimal getElectOnpeak() {
		return electOnpeak;
	}
	public void setElectOnpeak(BigDecimal electOnpeak) {
		this.electOnpeak = electOnpeak;
	}
	public BigDecimal getElectOffpeak() {
		return electOffpeak;
	}
	public void setElectOffpeak(BigDecimal electOffpeak) {
		this.electOffpeak = electOffpeak;
	}
	public BigDecimal getElectDemandOn() {
		return electDemandOn;
	}
	public void setElectDemandOn(BigDecimal electDemandOn) {
		this.electDemandOn = electDemandOn;
	}
	public BigDecimal getElectDemandOff() {
		return electDemandOff;
	}
	public void setElectDemandOff(BigDecimal electDemandOff) {
		this.electDemandOff = electDemandOff;
	}
	public BigDecimal getReactive() {
		return reactive;
	}
	public void setReactive(BigDecimal reactive) {
		this.reactive = reactive;
	}
	
	public String getKwhTotal() {
		return kwhTotal;
	}
	public void setKwhTotal(String kwhTotal) {
		this.kwhTotal = kwhTotal;
	}
	public BigDecimal getElectDemandPart() {
		return electDemandPart;
	}
	public void setElectDemandPart(BigDecimal electDemandPart) {
		this.electDemandPart = electDemandPart;
	}
	public BigDecimal getKwhOn() {
		return kwhOn;
	}
	public void setKwhOn(BigDecimal kwhOn) {
		this.kwhOn = kwhOn;
	}
	public BigDecimal getKwhOff() {
		return kwhOff;
	}
	public void setKwhOff(BigDecimal kwhOff) {
		this.kwhOff = kwhOff;
	}
	public BigDecimal getElectDemand() {
		return electDemand;
	}
	public void setElectDemand(BigDecimal electDemand) {
		this.electDemand = electDemand;
	}
	public String getMeterTypeFlag() {
		return meterTypeFlag;
	}
	public void setMeterTypeFlag(String meterTypeFlag) {
		this.meterTypeFlag = meterTypeFlag;
	}
	public String getTodtouFlag() {
		return todtouFlag;
	}
	public void setTodtouFlag(String todtouFlag) {
		this.todtouFlag = todtouFlag;
	}
	public String getKwhFlag() {
		return kwhFlag;
	}
	public void setKwhFlag(String kwhFlag) {
		this.kwhFlag = kwhFlag;
	}
	public String getServiceFlag() {
		return serviceFlag;
	}
	public void setServiceFlag(String serviceFlag) {
		this.serviceFlag = serviceFlag;
	}
	public String getDataFlag() {
		return dataFlag;
	}
	public void setDataFlag(String dataFlag) {
		this.dataFlag = dataFlag;
	}
	public String getCalFlag() {
		return calFlag;
	}
	public void setCalFlag(String calFlag) {
		this.calFlag = calFlag;
	}
	public String getpRead() {
		return pRead;
	}
	public void setpRead(String pRead) {
		this.pRead = pRead;
	}
	public String getlRead() {
		return lRead;
	}
	public void setlRead(String lRead) {
		this.lRead = lRead;
	}
	public Management getElectricId() {
		return electricId;
	}
	public void setElectricId(Management electricId) {
		this.electricId = electricId;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public String getSiteStatus() {
		return siteStatus;
	}
	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}
	public String getProcessStatusCode() {
		return processStatusCode;
	}
	public void setProcessStatusCode(String processStatusCode) {
		this.processStatusCode = processStatusCode;
	}
	public String getSiteStatusDesc() {
		return siteStatusDesc;
	}
	public void setSiteStatusDesc(String siteStatusDesc) {
		this.siteStatusDesc = siteStatusDesc;
	}
	public String getProcessStatusCodeDesc() {
		return processStatusCodeDesc;
	}
	public void setProcessStatusCodeDesc(String processStatusCodeDesc) {
		this.processStatusCodeDesc = processStatusCodeDesc;
	}
	public String getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	public BigDecimal getCt() {
		return ct;
	}
	public void setCt(BigDecimal ct) {
		this.ct = ct;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyFlag() {
		return companyFlag;
	}
	public void setCompanyFlag(String companyFlag) {
		this.companyFlag = companyFlag;
	}
	public String getCtFlag() {
		return ctFlag;
	}
	public void setCtFlag(String ctFlag) {
		this.ctFlag = ctFlag;
	}
	public String getPaidStatus() {
		return paidStatus;
	}
	public void setPaidStatus(String paidStatus) {
		this.paidStatus = paidStatus;
	}
	public String getOldContractNo() {
		return oldContractNo;
	}
	public void setOldContractNo(String oldContractNo) {
		this.oldContractNo = oldContractNo;
	}
	public Date getInstallmentPDate() {
		return installmentPDate;
	}
	public void setInstallmentPDate(Date installmentPDate) {
		this.installmentPDate = installmentPDate;
	}
	public Date getInstallmenLDate() {
		return installmenLDate;
	}
	public void setInstallmenLDate(Date installmenLDate) {
		this.installmenLDate = installmenLDate;
	}
	public String getInstallmenPRead() {
		return installmenPRead;
	}
	public void setInstallmenPRead(String installmenPRead) {
		this.installmenPRead = installmenPRead;
	}
	public String getInstallmenLRead() {
		return installmenLRead;
	}
	public void setInstallmenLRead(String installmenLRead) {
		this.installmenLRead = installmenLRead;
	}
	public BigDecimal getInstallmenKWH() {
		return installmenKWH;
	}
	public void setInstallmenKWH(BigDecimal installmenKWH) {
		this.installmenKWH = installmenKWH;
	}
	public BigDecimal getInstallmenVatAmount() {
		return installmenVatAmount;
	}
	public void setInstallmenVatAmount(BigDecimal installmenVatAmount) {
		this.installmenVatAmount = installmenVatAmount;
	}
	public BigDecimal getInstallmenIncVatAmount() {
		return installmenIncVatAmount;
	}
	public void setInstallmenIncVatAmount(BigDecimal installmenIncVatAmount) {
		this.installmenIncVatAmount = installmenIncVatAmount;
	}
	public Date getTxtBillDate() {
		return txtBillDate;
	}
	public void setTxtBillDate(Date txtBillDate) {
		this.txtBillDate = txtBillDate;
	}
	public Date getBillperiodPDt() {
		return billperiodPDt;
	}
	public void setBillperiodPDt(Date billperiodPDt) {
		this.billperiodPDt = billperiodPDt;
	}
	public Date getBillperiodLDt() {
		return billperiodLDt;
	}
	public void setBillperiodLDt(Date billperiodLDt) {
		this.billperiodLDt = billperiodLDt;
	}
	public String getTermOfPayment() {
		return termOfPayment;
	}
	public void setTermOfPayment(String termOfPayment) {
		this.termOfPayment = termOfPayment;
	}
	public String getCurrentTermOfPaymentDetail() {
		return currentTermOfPaymentDetail;
	}
	public void setCurrentTermOfPaymentDetail(String currentTermOfPaymentDetail) {
		this.currentTermOfPaymentDetail = currentTermOfPaymentDetail;
	}
	public String getNextTermOfPaymentDetail() {
		return nextTermOfPaymentDetail;
	}
	public void setNextTermOfPaymentDetail(String nextTermOfPaymentDetail) {
		this.nextTermOfPaymentDetail = nextTermOfPaymentDetail;
	}
	public String getTermOfPaymentDetail() {
		return termOfPaymentDetail;
	}
	public void setTermOfPaymentDetail(String termOfPaymentDetail) {
		this.termOfPaymentDetail = termOfPaymentDetail;
	}
	public String getRemarkPaymentDetail() {
		return remarkPaymentDetail;
	}
	public void setRemarkPaymentDetail(String remarkPaymentDetail) {
		this.remarkPaymentDetail = remarkPaymentDetail;
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public String getElGroup() {
		return elGroup;
	}
	public void setElGroup(String elGroup) {
		this.elGroup = elGroup;
	}
	public String getElGroupName() {
		return elGroupName;
	}
	public void setElGroupName(String elGroupName) {
		this.elGroupName = elGroupName;
	}
	public String getAmphurId() {
		return amphurId;
	}
	public void setAmphurId(String amphurId) {
		this.amphurId = amphurId;
	}
	public String getEngName() {
		return engName;
	}
	public void setEngName(String engName) {
		this.engName = engName;
	}
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getThaiName() {
		return thaiName;
	}
	public void setThaiName(String thaiName) {
		this.thaiName = thaiName;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getLacCode() {
		return lacCode;
	}
	public void setLacCode(String lacCode) {
		this.lacCode = lacCode;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getSamRegion() {
		return samRegion;
	}
	public void setSamRegion(String samRegion) {
		this.samRegion = samRegion;
	}
	public String getEngDesc() {
		return engDesc;
	}
	public void setEngDesc(String engDesc) {
		this.engDesc = engDesc;
	}
	public String getThaiDesc() {
		return thaiDesc;
	}
	public void setThaiDesc(String thaiDesc) {
		this.thaiDesc = thaiDesc;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDbTotalSize() {
		return dbTotalSize;
	}
	public void setDbTotalSize(String dbTotalSize) {
		this.dbTotalSize = dbTotalSize;
	}
	public String getEndProcessDt() {
		return endProcessDt;
	}
	public void setEndProcessDt(String endProcessDt) {
		this.endProcessDt = endProcessDt;
	}
	public String getFailPaid() {
		return failPaid;
	}
	public void setFailPaid(String failPaid) {
		this.failPaid = failPaid;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getInvTotalSize() {
		return invTotalSize;
	}
	public void setInvTotalSize(String invTotalSize) {
		this.invTotalSize = invTotalSize;
	}
	public String getNoDbTotalSize() {
		return noDbTotalSize;
	}
	public void setNoDbTotalSize(String noDbTotalSize) {
		this.noDbTotalSize = noDbTotalSize;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public Date getProcessDt() {
		return processDt;
	}
	public void setProcessDt(Date processDt) {
		this.processDt = processDt;
	}
	public String getRefDocId() {
		return refDocId;
	}
	public void setRefDocId(String refDocId) {
		this.refDocId = refDocId;
	}
	public String getSuccessNoPaid() {
		return successNoPaid;
	}
	public void setSuccessNoPaid(String successNoPaid) {
		this.successNoPaid = successNoPaid;
	}
	public String getSuccessPaid() {
		return successPaid;
	}
	public void setSuccessPaid(String successPaid) {
		this.successPaid = successPaid;
	}
	public String getTechErrorCode() {
		return techErrorCode;
	}
	public void setTechErrorCode(String techErrorCode) {
		this.techErrorCode = techErrorCode;
	}
	public String getTotalFileRecord() {
		return totalFileRecord;
	}
	public void setTotalFileRecord(String totalFileRecord) {
		this.totalFileRecord = totalFileRecord;
	}
	public Date getUploadDt() {
		return uploadDt;
	}
	public void setUploadDt(Date uploadDt) {
		this.uploadDt = uploadDt;
	}
	public String getUploadFail() {
		return uploadFail;
	}
	public void setUploadFail(String uploadFail) {
		this.uploadFail = uploadFail;
	}
	public String getUploadSuccess() {
		return uploadSuccess;
	}
	public void setUploadSuccess(String uploadSuccess) {
		this.uploadSuccess = uploadSuccess;
	}
	public String getValidateFail() {
		return validateFail;
	}
	public void setValidateFail(String validateFail) {
		this.validateFail = validateFail;
	}
	public String getValidateRecord() {
		return validateRecord;
	}
	public void setValidateRecord(String validateRecord) {
		this.validateRecord = validateRecord;
	}
	public String getValidateSuccess() {
		return validateSuccess;
	}
	public void setValidateSuccess(String validateSuccess) {
		this.validateSuccess = validateSuccess;
	}
	public String getOwnerGroup() {
		return ownerGroup;
	}
	public void setOwnerGroup(String ownerGroup) {
		this.ownerGroup = ownerGroup;
	}
	public String getOwnerGroupName() {
		return ownerGroupName;
	}
	public void setOwnerGroupName(String ownerGroupName) {
		this.ownerGroupName = ownerGroupName;
	}
	public String getBillperiodPDtStr() {
		return billperiodPDtStr;
	}
	public void setBillperiodPDtStr(String billperiodPDtStr) {
		this.billperiodPDtStr = billperiodPDtStr;
	}
	public String getMonth1M() {
		return month1M;
	}
	public void setMonth1M(String month1m) {
		month1M = month1m;
	}
	public String getKwh1M() {
		return kwh1M;
	}
	public void setKwh1M(String kwh1m) {
		kwh1M = kwh1m;
	}
	public String getAmount1M() {
		return amount1M;
	}
	public void setAmount1M(String amount1m) {
		amount1M = amount1m;
	}
	public String getUnit1M() {
		return unit1M;
	}
	public void setUnit1M(String unit1m) {
		unit1M = unit1m;
	}
	public String getKwhAvg1M() {
		return kwhAvg1M;
	}
	public void setKwhAvg1M(String kwhAvg1M) {
		this.kwhAvg1M = kwhAvg1M;
	}
	public String getAmountAvg1M() {
		return amountAvg1M;
	}
	public void setAmountAvg1M(String amountAvg1M) {
		this.amountAvg1M = amountAvg1M;
	}
	public String getUnitAvg1M() {
		return unitAvg1M;
	}
	public void setUnitAvg1M(String unitAvg1M) {
		this.unitAvg1M = unitAvg1M;
	}
	public String getMonth3M() {
		return month3M;
	}
	public void setMonth3M(String month3m) {
		month3M = month3m;
	}
	public String getKwh3M() {
		return kwh3M;
	}
	public void setKwh3M(String kwh3m) {
		kwh3M = kwh3m;
	}
	public String getAmount3M() {
		return amount3M;
	}
	public void setAmount3M(String amount3m) {
		amount3M = amount3m;
	}
	public String getUnit3M() {
		return unit3M;
	}
	public void setUnit3M(String unit3m) {
		unit3M = unit3m;
	}
	public String getKwhAvg3M() {
		return kwhAvg3M;
	}
	public void setKwhAvg3M(String kwhAvg3M) {
		this.kwhAvg3M = kwhAvg3M;
	}
	public String getAmountAvg3M() {
		return amountAvg3M;
	}
	public void setAmountAvg3M(String amountAvg3M) {
		this.amountAvg3M = amountAvg3M;
	}
	public String getUnitAvg3M() {
		return unitAvg3M;
	}
	public void setUnitAvg3M(String unitAvg3M) {
		this.unitAvg3M = unitAvg3M;
	}
	public String getMonth6M() {
		return month6M;
	}
	public void setMonth6M(String month6m) {
		month6M = month6m;
	}
	public String getKwh6M() {
		return kwh6M;
	}
	public void setKwh6M(String kwh6m) {
		kwh6M = kwh6m;
	}
	public String getAmount6M() {
		return amount6M;
	}
	public void setAmount6M(String amount6m) {
		amount6M = amount6m;
	}
	public String getUnit6M() {
		return unit6M;
	}
	public void setUnit6M(String unit6m) {
		unit6M = unit6m;
	}
	public String getKwhAvg6M() {
		return kwhAvg6M;
	}
	public void setKwhAvg6M(String kwhAvg6M) {
		this.kwhAvg6M = kwhAvg6M;
	}
	public String getAmountAvg6M() {
		return amountAvg6M;
	}
	public void setAmountAvg6M(String amountAvg6M) {
		this.amountAvg6M = amountAvg6M;
	}
	public String getUnitAvg6M() {
		return unitAvg6M;
	}
	public void setUnitAvg6M(String unitAvg6M) {
		this.unitAvg6M = unitAvg6M;
	}
	public String getMonth12M() {
		return month12M;
	}
	public void setMonth12M(String month12m) {
		month12M = month12m;
	}
	public String getKwh12M() {
		return kwh12M;
	}
	public void setKwh12M(String kwh12m) {
		kwh12M = kwh12m;
	}
	public String getAmount12M() {
		return amount12M;
	}
	public void setAmount12M(String amount12m) {
		amount12M = amount12m;
	}
	public String getUnit12M() {
		return unit12M;
	}
	public void setUnit12M(String unit12m) {
		unit12M = unit12m;
	}
	public String getKwhAvg12M() {
		return kwhAvg12M;
	}
	public void setKwhAvg12M(String kwhAvg12M) {
		this.kwhAvg12M = kwhAvg12M;
	}
	public String getAmountAvg12M() {
		return amountAvg12M;
	}
	public void setAmountAvg12M(String amountAvg12M) {
		this.amountAvg12M = amountAvg12M;
	}
	public String getUnitAvg12M() {
		return unitAvg12M;
	}
	public void setUnitAvg12M(String unitAvg12M) {
		this.unitAvg12M = unitAvg12M;
	}
	public void setSiteStats2(String siteStats2) {
		this.siteStats2 = siteStats2;
	}
	public String getNetworkStatus() {
		return networkStatus;
	}
	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
	}
	public String getMeterStatus() {
		return meterStatus;
	}
	public void setMeterStatus(String meterStatus) {
		this.meterStatus = meterStatus;
	}
	public String getPercentGrowth() {
		return percentGrowth;
	}
	public void setPercentGrowth(String percentGrowth) {
		this.percentGrowth = percentGrowth;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getEffDate() {
		return effDate;
	}
	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public String getEffDateStr() {
		return effDateStr;
	}
	public void setEffDateStr(String effDateStr) {
		this.effDateStr = effDateStr;
	}
	public String getExpDateStr() {
		return expDateStr;
	}
	public void setExpDateStr(String expDateStr) {
		this.expDateStr = expDateStr;
	}
	public String getSiteStats2() {
		return siteStats2;
	}
	public Date getBillPeriodFromPDt() {
		return billPeriodFromPDt;
	}
	public void setBillPeriodFromPDt(Date billPeriodFromPDt) {
		this.billPeriodFromPDt = billPeriodFromPDt;
	}
	public String getBillPeriodFromPDtStr() {
		return billPeriodFromPDtStr;
	}
	public void setBillPeriodFromPDtStr(String billPeriodFromPDtStr) {
		this.billPeriodFromPDtStr = billPeriodFromPDtStr;
	}
	public Double getKwhTotalNumber() {
		return kwhTotalNumber;
	}
	public void setKwhTotalNumber(Double kwhTotalNumber) {
		this.kwhTotalNumber = kwhTotalNumber;
	}
	public Double getInvAmtNumber() {
		return invAmtNumber;
	}
	public void setInvAmtNumber(Double invAmtNumber) {
		this.invAmtNumber = invAmtNumber;
	}
	public Double getInvVatAmtNumber() {
		return invVatAmtNumber;
	}
	public void setInvVatAmtNumber(Double invVatAmtNumber) {
		this.invVatAmtNumber = invVatAmtNumber;
	}
	public Double getSysAmtNumber() {
		return sysAmtNumber;
	}
	public void setSysAmtNumber(Double sysAmtNumber) {
		this.sysAmtNumber = sysAmtNumber;
	}
	public Double getDiffAmtNumber() {
		return diffAmtNumber;
	}
	public void setDiffAmtNumber(Double diffAmtNumber) {
		this.diffAmtNumber = diffAmtNumber;
	}
	public String getUploadTextId() {
		return uploadTextId;
	}
	public void setUploadTextId(String uploadTextId) {
		this.uploadTextId = uploadTextId;
	}
	public String getAmphurStr() {
		return amphurStr;
	}
	public void setAmphurStr(String amphurStr) {
		this.amphurStr = amphurStr;
	}
	public String getElectricIdStr() {
		return electricIdStr;
	}
	public void setElectricIdStr(String electricIdStr) {
		this.electricIdStr = electricIdStr;
	}
	public String getDupPaidFlag() {
		return dupPaidFlag;
	}
	public void setDupPaidFlag(String dupPaidFlag) {
		this.dupPaidFlag = dupPaidFlag;
	}
	public String getProvinceStr() {
		return provinceStr;
	}
	public void setProvinceStr(String provinceStr) {
		this.provinceStr = provinceStr;
	}
	public String getTextBillPeriod() {
		return textBillPeriod;
	}
	public void setTextBillPeriod(String textBillPeriod) {
		this.textBillPeriod = textBillPeriod;
	}
	public String getFailNoPaid() {
		return failNoPaid;
	}
	public void setFailNoPaid(String failNoPaid) {
		this.failNoPaid = failNoPaid;
	}
	public String getTechErrorDesc() {
		return techErrorDesc;
	}
	public void setTechErrorDesc(String techErrorDesc) {
		this.techErrorDesc = techErrorDesc;
	}
	public String getUploadBy() {
		return uploadBy;
	}
	public void setUploadBy(String uploadBy) {
		this.uploadBy = uploadBy;
	}
	public String getImprotDataDetailId() {
		return improtDataDetailId;
	}
	public void setImprotDataDetailId(String improtDataDetailId) {
		this.improtDataDetailId = improtDataDetailId;
	}
	public String getNetworkStatusDesc() {
		return networkStatusDesc;
	}
	public void setNetworkStatusDesc(String networkStatusDesc) {
		this.networkStatusDesc = networkStatusDesc;
	}
	
	
}
