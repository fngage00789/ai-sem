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

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;

@Entity(name = "th.co.ais.domain.el.ImportMeaNewTmp")
@Table(name = "SEM_EL_IMPORT_MEA_NEW_EXT")
public class ImportMeaNewTmp extends AbstractDomain {

	private static final long serialVersionUID = -4487640889593248895L;

	private String rowId;
	private ImportTransaction importTransId;
	private String mnSeq;
	private String mnMru;
	private String meterId;
	private String mnName;
	private String mnAddress;
	private String mnPDt;
	private String mnLDt;
	private String mnPread;
	private String mnLread;
	private String mnRateCat;
	private String mnCt;
	private String mnKwhTotal;
	private String mnMaxKw;
	private String mnInvNo;
	private String mnInvAmt;
	private String mnVatAmt;
	private String mnFtAmt;
	private String mnFtRate;
	private String mnDemandAmt;
	private String mnPfAmt;
	private String mnOnKwh;
	private String mnOffKwh;
	private String mnKvar;
	private BigDecimal lineNo;
	
	

	// private String loadStatus;
	// private BigDecimal lineNo;
	// private String errorCode;
	// private String errorDesc;
	// private String recordStatus;

	public ImportMeaNewTmp(String data, String transId) {
		System.out.println("WT###Print data=" + data);
		
		ImportTransaction importTrans = new ImportTransaction();
		importTrans.setRowId(transId);
		this.importTransId = importTrans;
		data = data.replace(" ", "");
		String[] dataArr = data.split("\\;");
		try{
			this.mnSeq = dataArr[0];
			this.mnMru = dataArr[1];
			this.meterId = dataArr[2];
			this.mnName = dataArr[3];
			this.mnAddress = dataArr[4];
			this.mnPDt = dataArr[5];
			this.mnLDt = dataArr[6];
			this.mnPread = dataArr[7];
			this.mnLread = dataArr[8];
			this.mnRateCat = dataArr[9];
			this.mnCt = dataArr[10];
			this.mnKwhTotal = dataArr[11];
			this.mnMaxKw = dataArr[12];
			this.mnInvNo = dataArr[13];
			this.mnInvAmt = dataArr[14];
			this.mnVatAmt = dataArr[15];
			this.mnFtAmt = dataArr[16];
			this.mnFtRate = dataArr[17];
			this.mnDemandAmt = dataArr[18];
			this.mnPfAmt = dataArr[19];
			this.mnOnKwh = dataArr[20];
			this.mnOffKwh = dataArr[21];
			this.mnKvar = dataArr[22];
		}catch (Exception e){
			e.printStackTrace();
		}

	}

	public ImportMeaNewTmp() {

	}

	@Override
	@Column(name = "CREATE_BY")
	public String getCreateBy() {
		return this.createBy;
	}

	@Override
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Override
	@Column(name = "CREATE_DT")
	public Date getCreateDt() {
		return this.createDt;
	}

	@Override
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	@Override
	@Column(name = "UPDATE_BY")
	public String getUpdateBy() {
		return this.updateBy;
	}

	@Override
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Override
	@Column(name = "UPDATE_DT")
	public Date getUpdateDt() {
		return this.updateDt;
	}

	@Override
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;

	}

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "SEM_EL_MEA_NEW_TMP_ID")
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SEM_EL_IMPORT_TRANS_ID")
	public ImportTransaction getImportTransId() {
		return importTransId;
	}

	public void setImportTransId(ImportTransaction importTransId) {
		this.importTransId = importTransId;
	}

	@Column(name = "SEQUENCE")
	public String getMnSeq() {
		return mnSeq;
	}

	public void setMnSeq(String mnSeq) {
		this.mnSeq = mnSeq;
	}

	@Column(name = "MRU")
	public String getMnMru() {
		return mnMru;
	}

	public void setMnMru(String mnMru) {
		this.mnMru = mnMru;
	}

	@Column(name = "INSTALLATION")
	public String getMeterId() {
		return meterId;
	}

	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}

	@Column(name = "NAME")
	public String getMnName() {
		return mnName;
	}

	public void setMnName(String mnName) {
		this.mnName = mnName;
	}

	@Column(name = "ADDRESS")
	public String getMnAddress() {
		return mnAddress;
	}

	public void setMnAddress(String mnAddress) {
		this.mnAddress = mnAddress;
	}

	@Column(name = "PDATE")
	public String getMnPDt() {
		return mnPDt;
	}

	public void setMnPDt(String mnPDt) {
		this.mnPDt = mnPDt;
	}

	@Column(name = "LDATE")
	public String getMnLDt() {
		return mnLDt;
	}

	public void setMnLDt(String mnLDt) {
		this.mnLDt = mnLDt;
	}

	@Column(name = "PREAD")
	public String getMnPread() {
		return mnPread;
	}

	public void setMnPread(String mnPread) {
		this.mnPread = mnPread;
	}

	@Column(name = "LREAD")
	public String getMnLread() {
		return mnLread;
	}

	public void setMnLread(String mnLread) {
		this.mnLread = mnLread;
	}

	@Column(name = "RATECATEGORY")
	public String getMnRateCat() {
		return mnRateCat;
	}

	public void setMnRateCat(String mnRateCat) {
		this.mnRateCat = mnRateCat;
	}

	@Column(name = "BILLINGFACTOR")
	public String getMnCt() {
		return mnCt;
	}

	public void setMnCt(String mnCt) {
		this.mnCt = mnCt;
	}

	@Column(name = "KWH_TOTAL")
	public String getMnKwhTotal() {
		return mnKwhTotal;
	}

	public void setMnKwhTotal(String mnKwhTotal) {
		this.mnKwhTotal = mnKwhTotal;
	}

	@Column(name = "MAX_KW")
	public String getMnMaxKw() {
		return mnMaxKw;
	}

	public void setMnMaxKw(String mnMaxKw) {
		this.mnMaxKw = mnMaxKw;
	}

	@Column(name = "INVOICE_NUMBER")
	public String getMnInvNo() {
		return mnInvNo;
	}

	public void setMnInvNo(String mnInvNo) {
		this.mnInvNo = mnInvNo;
	}

	@Column(name = "INVOICE_AMT")
	public String getMnInvAmt() {
		return mnInvAmt;
	}

	public void setMnInvAmt(String mnInvAmt) {
		this.mnInvAmt = mnInvAmt;
	}

	@Column(name = "VAT_AMT")
	public String getMnVatAmt() {
		return mnVatAmt;
	}

	public void setMnVatAmt(String mnVatAmt) {
		this.mnVatAmt = mnVatAmt;
	}

	@Column(name = "FT_AMT")
	public String getMnFtAmt() {
		return mnFtAmt;
	}

	public void setMnFtAmt(String mnFtAmt) {
		this.mnFtAmt = mnFtAmt;
	}

	@Column(name = "FT_RATE")
	public String getMnFtRate() {
		return mnFtRate;
	}

	public void setMnFtRate(String mnFtRate) {
		this.mnFtRate = mnFtRate;
	}

	@Column(name = "DEMAND_AMT")
	public String getMnDemandAmt() {
		return mnDemandAmt;
	}

	public void setMnDemandAmt(String mnDemandAmt) {
		this.mnDemandAmt = mnDemandAmt;
	}

	@Column(name = "POWER_FACTOR_AMT")
	public String getMnPfAmt() {
		return mnPfAmt;
	}

	public void setMnPfAmt(String mnPfAmt) {
		this.mnPfAmt = mnPfAmt;
	}

	@Column(name = "ON_KWH")
	public String getMnOnKwh() {
		return mnOnKwh;
	}

	public void setMnOnKwh(String mnOnKwh) {
		this.mnOnKwh = mnOnKwh;
	}

	@Column(name = "OFF_KWH")
	public String getMnOffKwh() {
		return mnOffKwh;
	}

	public void setMnOffKwh(String mnOffKwh) {
		this.mnOffKwh = mnOffKwh;
	}

	@Column(name = "KVAR")
	public String getMnKvar() {
		return mnKvar;
	}

	public void setMnKvar(String mnKvar) {
		this.mnKvar = mnKvar;
	}
	
	@Column(name = "LINE_NO")
	public BigDecimal getLineNo() {
		return lineNo;
	}

	public void setLineNo(BigDecimal lineNo) {
		this.lineNo = lineNo;
	}

	// @Column(name = "LOAD_STATUS")
	// public String getLoadStatus() {
	// return loadStatus;
	// }
	// public void setLoadStatus(String loadStatus) {
	// this.loadStatus = loadStatus;
	// }
	//	
	// @Column(name = "LINE_NO")
	// public BigDecimal getLineNo() {
	// return lineNo;
	// }
	// public void setLineNo(BigDecimal lineNo) {
	// this.lineNo = lineNo;
	// }
	//	
	// @Column(name = "ERROR_CODE")
	// public String getErrorCode() {
	// return errorCode;
	// }
	// public void setErrorCode(String errorCode) {
	// this.errorCode = errorCode;
	// }
	//	
	// @Column(name = "ERROR_DESC")
	// public String getErrorDesc() {
	// return errorDesc;
	// }
	// public void setErrorDesc(String errorDesc) {
	// this.errorDesc = errorDesc;
	// }
	//	
	// @Column(name = "RECORD_STATUS")
	// public String getRecordStatus() {
	// return recordStatus;
	// }
	// public void setRecordStatus(String recordStatus) {
	// this.recordStatus = recordStatus;
	// }

}
