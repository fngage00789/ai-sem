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

@Entity(name = "th.co.ais.domain.el.ImportPeaNewExt")
@Table(name = "SEM_EL_IMPORT_PEA_NEW_EXT")
public class ImportPeaNewExt extends AbstractDomain {

	private static final long serialVersionUID = 549665332613753090L;

	private String rowId;
	private ImportTransaction importTransId;
	private String item;
	private String morTor;
	private String mru;
	private String custNo;
	private String name;
	private String address;
	private String voltageLevel;
	private String kw;
	private String multiply;
	private String pmrdate;
	private String mrdate;
	private String pmr;
	private String mr;
	private String unit;
	private String amt;
	private String vatAmt;
	private String rateCat;
	private String invoiceNo;
	private String ftAmt;
	private String tou;
	private String peacode;
	private String peaname;
	private String billperiod;
	private String pkpmr;
	private String pkmr;
	private String pkunit;
	private String opkpmr;
	private String opkmr;
	private String opkunit;
	private String hldpmr;
	private String hldmr;
	private String hldunit;
	private BigDecimal lineNo; 
	private String kvar;
	private String research1;
	private String research2;
	private String research3;
	private String research4;
	private String research5;

	public ImportPeaNewExt(String data, String transId, String delimiter) {
		ImportTransaction importTrans = new ImportTransaction();
		importTrans.setRowId(transId);
		this.importTransId = importTrans;
		data = data.replace(" ", "");
		String[] dataArr = data.split(delimiter);
		try{
			this.item = dataArr[0];
			this.morTor = dataArr[1];
			this.mru = dataArr[2];
			this.custNo = dataArr[3];
			this.name = dataArr[4];
			this.address = dataArr[5];
			this.voltageLevel = dataArr[6];
			this.kw = dataArr[7];
			this.multiply = dataArr[8];
			this.pmrdate = dataArr[9];
			this.mrdate = dataArr[10];
			this.pmr = dataArr[11];
			this.mr = dataArr[12];
			this.unit = dataArr[13];
			this.amt = dataArr[14];
			this.vatAmt = dataArr[15];
			this.rateCat = dataArr[16];
			this.invoiceNo = dataArr[17];
			this.ftAmt = dataArr[18];
			this.tou = dataArr[19];
			this.peacode = dataArr[20];
			this.peaname = dataArr[21];
			this.billperiod = dataArr[22];
			this.pkpmr = dataArr[23];
			this.pkmr = dataArr[24];
			this.pkunit = dataArr[25];
			this.opkpmr = dataArr[26];
			this.opkmr = dataArr[27];
			this.opkunit = dataArr[28];
			this.hldpmr = dataArr[29];
			this.hldmr = dataArr[30];
			this.hldunit = dataArr[31];
			this.kvar = dataArr[32];
			this.research1 = dataArr[33];
			this.research2 = dataArr[34];
			this.research3 = dataArr[35];
			this.research4 = dataArr[36];
			this.research5 = dataArr[37];
		}catch (IndexOutOfBoundsException e){
			e.printStackTrace();
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public ImportPeaNewExt() {

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
	@Column(name = "SEM_EL_PEA_NEW_TMP_ID")
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

	@Column(name = "ITEM")
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Column(name = "MOR_TOR")
	public String getMorTor() {
		return morTor;
	}

	public void setMorTor(String morTor) {
		this.morTor = morTor;
	}

	@Column(name = "MRU")
	public String getMru() {
		return mru;
	}

	public void setMru(String mru) {
		this.mru = mru;
	}

	@Column(name = "CUST_NO")
	public String getCustNo() {
		return custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "VOLTAGE_LEVEL")
	public String getVoltageLevel() {
		return voltageLevel;
	}

	public void setVoltageLevel(String voltageLevel) {
		this.voltageLevel = voltageLevel;
	}

	@Column(name = "KW")
	public String getKw() {
		return kw;
	}

	public void setKw(String kw) {
		this.kw = kw;
	}

	@Column(name = "MULTIPLY")
	public String getMultiply() {
		return multiply;
	}

	public void setMultiply(String multiply) {
		this.multiply = multiply;
	}

	@Column(name = "PMRDATE")
	public String getPmrdate() {
		return pmrdate;
	}

	public void setPmrdate(String pmrdate) {
		this.pmrdate = pmrdate;
	}

	@Column(name = "MRDATE")
	public String getMrdate() {
		return mrdate;
	}

	public void setMrdate(String mrdate) {
		this.mrdate = mrdate;
	}

	@Column(name = "PMR")
	public String getPmr() {
		return pmr;
	}

	public void setPmr(String pmr) {
		this.pmr = pmr;
	}

	@Column(name = "MR")
	public String getMr() {
		return mr;
	}

	public void setMr(String mr) {
		this.mr = mr;
	}

	@Column(name = "UNIT")
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name = "AMT")
	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}

	@Column(name = "VAT_AMT")
	public String getVatAmt() {
		return vatAmt;
	}

	public void setVatAmt(String vatAmt) {
		this.vatAmt = vatAmt;
	}

	@Column(name = "RATE_CAT")
	public String getRateCat() {
		return rateCat;
	}

	public void setRateCat(String rateCat) {
		this.rateCat = rateCat;
	}

	@Column(name = "INVOICE_NO")
	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	@Column(name = "FT_AMT")
	public String getFtAmt() {
		return ftAmt;
	}

	public void setFtAmt(String ftAmt) {
		this.ftAmt = ftAmt;
	}

	@Column(name = "TOU")
	public String getTou() {
		return tou;
	}

	public void setTou(String tou) {
		this.tou = tou;
	}

	@Column(name = "PEACODE")
	public String getPeacode() {
		return peacode;
	}

	public void setPeacode(String peacode) {
		this.peacode = peacode;
	}

	@Column(name = "PEANAME")
	public String getPeaname() {
		return peaname;
	}

	public void setPeaname(String peaname) {
		this.peaname = peaname;
	}

	@Column(name = "BILLPERIOD")
	public String getBillperiod() {
		return billperiod;
	}

	public void setBillperiod(String billperiod) {
		this.billperiod = billperiod;
	}

	@Column(name = "PKPMR")
	public String getPkpmr() {
		return pkpmr;
	}

	public void setPkpmr(String pkpmr) {
		this.pkpmr = pkpmr;
	}

	@Column(name = "PKMR")
	public String getPkmr() {
		return pkmr;
	}

	public void setPkmr(String pkmr) {
		this.pkmr = pkmr;
	}

	@Column(name = "PKUNIT")
	public String getPkunit() {
		return pkunit;
	}

	public void setPkunit(String pkunit) {
		this.pkunit = pkunit;
	}

	@Column(name = "OPKPMR")
	public String getOpkpmr() {
		return opkpmr;
	}

	public void setOpkpmr(String opkpmr) {
		this.opkpmr = opkpmr;
	}

	@Column(name = "OPKMR")
	public String getOpkmr() {
		return opkmr;
	}

	public void setOpkmr(String opkmr) {
		this.opkmr = opkmr;
	}

	@Column(name = "OPKUNIT")
	public String getOpkunit() {
		return opkunit;
	}

	public void setOpkunit(String opkunit) {
		this.opkunit = opkunit;
	}

	@Column(name = "HLDPMR")
	public String getHldpmr() {
		return hldpmr;
	}

	public void setHldpmr(String hldpmr) {
		this.hldpmr = hldpmr;
	}

	@Column(name = "HLDMR")
	public String getHldmr() {
		return hldmr;
	}

	public void setHldmr(String hldmr) {
		this.hldmr = hldmr;
	}

	@Column(name = "HLDUNIT")
	public String getHldunit() {
		return hldunit;
	}

	public void setHldunit(String hldunit) {
		this.hldunit = hldunit;
	}
	@Column(name = "LINE_NO")
	public BigDecimal getLineNo() {
		return lineNo;
	}

	public void setLineNo(BigDecimal lineNo) {
		this.lineNo = lineNo;
	}
	@Column(name = "KVAR")
	public String getKvar() {
		return kvar;
	}

	public void setKvar(String kvar) {
		this.kvar = kvar;
	}
	@Column(name = "RESEARCH_1")
	public String getResearch1() {
		return research1;
	}

	public void setResearch1(String research1) {
		this.research1 = research1;
	}
	@Column(name = "RESEARCH_2")
	public String getResearch2() {
		return research2;
	}

	public void setResearch2(String research2) {
		this.research2 = research2;
	}
	@Column(name = "RESEARCH_3")
	public String getResearch3() {
		return research3;
	}

	public void setResearch3(String research3) {
		this.research3 = research3;
	}
	@Column(name = "RESEARCH_4")
	public String getResearch4() {
		return research4;
	}

	public void setResearch4(String research4) {
		this.research4 = research4;
	}
	@Column(name = "RESEARCH_5")
	public String getResearch5() {
		return research5;
	}

	public void setResearch5(String research5) {
		this.research5 = research5;
	}
	

}
