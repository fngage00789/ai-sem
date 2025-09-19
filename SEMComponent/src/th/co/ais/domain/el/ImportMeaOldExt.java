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

@Entity(name="th.co.ais.domain.el.ImportMeaOldExt")
@Table(name="SEM_EL_IMPORT_MEA_OLD_EXT")
public class ImportMeaOldExt extends AbstractDomain {

	private static final long serialVersionUID = -9171775388572315421L;
	
	private String rowId;
	private ImportTransaction importTransId;
	private String item;
	private String filler;
	private String mru;
	private String userno;
	private String username;
	private String address;
	private String volt;
	private String kwhTotal;
	private String billingFacTor;
	private String pDate;
	private String lDate;
	private String pread;
	private String lread;
	private String unitused;
	private String invoiceAmt;
	private String vatAmt;
	private String type;
	private String invoiceNumber;
	private String ftAmt;
	private String ftRate;
	private String demandAmt;
	private String powerFactorAmt;
	private String filler2;
	private BigDecimal lineNo; 
	
	
	public ImportMeaOldExt() {
	}
	
	public ImportMeaOldExt(String data, String transId) {
		
		ImportTransaction importTrans = new ImportTransaction();
		importTrans.setRowId(transId);
		this.importTransId = importTrans;
		
		try{
			this.item = data.substring(0, 4);//ITEM   POSITION(1:4) CHAR(4),
			this.filler = data.substring(4, 6);//FILLER   POSITION(5:6) CHAR(2),
			this.mru = data.substring(6, 9);// MRU   POSITION(7:9) CHAR(3),
			this.userno = data.substring(9, 15);//USERNO   POSITION(10:15) CHAR(6),
			this.username = data.substring(15, 60);//USERNAME   POSITION(16:60) CHAR(45),
			this.address = data.substring(60, 110);//ADDRESS   POSITION(61:110) CHAR(50),
			this.volt = data.substring(110,111);//VOLT   POSITION (111) CHAR(1),
			this.kwhTotal = data.substring(111, 117);//KWH_TOTAL   POSITION(113:117) CHAR(5),
			this.billingFacTor = data.substring(117, 121);//BILLING_FACTOR   POSITION(117:121) CHAR(5),
			this.pDate = data.substring(121, 127);// PDATE   POSITION(122:127) CHAR(6),
			this.lDate = data.substring(127, 133);//LDATE   POSITION(128:133) CHAR(6),
			this.pread = data.substring(133, 139);//PREAD   POSITION(134:139) CHAR(6),
			this.lread = data.substring(139, 145);//LREAD   POSITION(140:145) CHAR(6),
			this.unitused = data.substring(145, 153);//UNITUSED   POSITION(146:153) CHAR(8),
			this.invoiceAmt = data.substring(153, 163);//INVOICE_AMT   POSITION(154:163) CHAR(10),
			this.vatAmt = data.substring(163, 172);// VAT_AMT   POSITION(164:172) CHAR(9),
			this.type = data.substring(172, 174);//TYPE   POSITION(173:174) CHAR(2),
			this.invoiceNumber = data.substring(174, 182);// INVOICE_NUMBER   POSITION(175:182) CHAR(8),
			this.ftAmt = data.substring(182, 192);//FT_AMT   POSITION(183:192) CHAR(10),
			this.ftRate = data.substring(192, 197);//FT_RATE   POSITION(193:197) CHAR(5),
			this.demandAmt = data.substring(197, 205);//DEMAND_AMT   POSITION(198:205) CHAR(8),
			this.powerFactorAmt = data.substring(205, 213);// POWER_FACTOR_AMT   POSITION(206:213) CHAR(8),
			this.filler2 = data.substring(213, 214);// FILLER2   POSITION(214:214) CHAR(8)
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean validateImportMeaOldExt(String data) {
		
		System.out.println("WT###Print data="+data);
		System.out.println("WT###Print data.length="+data.length());
		boolean validateFlage = false;
		
		try{
			this.item = data.substring(0, 4);//ITEM   POSITION(1:4) CHAR(4),
			this.filler = data.substring(4, 6);//FILLER   POSITION(5:6) CHAR(2),
			this.mru = data.substring(6, 9);// MRU   POSITION(7:9) CHAR(3),
			this.userno = data.substring(9, 15);//USERNO   POSITION(10:15) CHAR(6),
			this.username = data.substring(15, 60);//USERNAME   POSITION(16:60) CHAR(45),
			this.address = data.substring(60, 110);//ADDRESS   POSITION(61:110) CHAR(50),
			this.volt = data.substring(110,111);//VOLT   POSITION (111) CHAR(1),
			this.kwhTotal = data.substring(111, 117);//KWH_TOTAL   POSITION(113:117) CHAR(5),
			this.billingFacTor = data.substring(117, 121);//BILLING_FACTOR   POSITION(117:121) CHAR(5),
			this.pDate = data.substring(121, 127);// PDATE   POSITION(122:127) CHAR(6),
			this.lDate = data.substring(127, 133);//LDATE   POSITION(128:133) CHAR(6),
			this.pread = data.substring(133, 139);//PREAD   POSITION(134:139) CHAR(6),
			this.lread = data.substring(139, 145);//LREAD   POSITION(140:145) CHAR(6),
			this.unitused = data.substring(145, 153);//UNITUSED   POSITION(146:153) CHAR(8),
			this.invoiceAmt = data.substring(153, 163);//INVOICE_AMT   POSITION(154:163) CHAR(10),
			this.vatAmt = data.substring(163, 172);// VAT_AMT   POSITION(164:172) CHAR(9),
			this.type = data.substring(172, 174);//TYPE   POSITION(173:174) CHAR(2),
			this.invoiceNumber = data.substring(174, 182);// INVOICE_NUMBER   POSITION(175:182) CHAR(8),
			this.ftAmt = data.substring(182, 192);//FT_AMT   POSITION(183:192) CHAR(10),
			this.ftRate = data.substring(192, 197);//FT_RATE   POSITION(193:197) CHAR(5),
			this.demandAmt = data.substring(197, 205);//DEMAND_AMT   POSITION(198:205) CHAR(8),
			this.powerFactorAmt = data.substring(205, 213);// POWER_FACTOR_AMT   POSITION(206:213) CHAR(8),
			this.filler2 = data.substring(213, 214);// FILLER2   POSITION(214:214) CHAR(8)
		}catch (Exception e){
				e.printStackTrace();
				return validateFlage = true;
				
		}
		return validateFlage;
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
		
	@Id
  	@GeneratedValue(generator="system-uuid")
  	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "SEM_EL_MEA_OLD_TMP_ID")
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
	
	@Column(name = "FILLER")
	public String getFiller() {
		return filler;
	}
	public void setFiller(String filler) {
		this.filler = filler;
	}
	
	@Column(name = "MRU")
	public String getMru() {
		return mru;
	}
	public void setMru(String mru) {
		this.mru = mru;
	}
	
	@Column(name = "USERNO")
	public String getUserno() {
		return userno;
	}
	public void setUserno(String userno) {
		this.userno = userno;
	}
	
	@Column(name = "USERNAME")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name = "VOLT")
	public String getVolt() {
		return volt;
	}
	public void setVolt(String volt) {
		this.volt = volt;
	}
	
	@Column(name = "KWH_TOTAL")
	public String getKwhTotal() {
		return kwhTotal;
	}
	public void setKwhTotal(String kwhTotal) {
		this.kwhTotal = kwhTotal;
	}
	
	@Column(name = "BILLING_FACTOR")
	public String getBillingFacTor() {
		return billingFacTor;
	}
	public void setBillingFacTor(String billingFacTor) {
		this.billingFacTor = billingFacTor;
	}
	
	@Column(name = "PDATE")
	public String getpDate() {
		return pDate;
	}
	public void setpDate(String pDate) {
		this.pDate = pDate;
	}
	
	@Column(name = "LDATE")
	public String getlDate() {
		return lDate;
	}
	public void setlDate(String lDate) {
		this.lDate = lDate;
	}
	
	@Column(name = "PREAD")
	public String getPread() {
		return pread;
	}
	public void setPread(String pread) {
		this.pread = pread;
	}
	
	@Column(name = "LREAD")
	public String getLread() {
		return lread;
	}
	public void setLread(String lread) {
		this.lread = lread;
	}
	
	@Column(name = "UNITUSED")
	public String getUnitused() {
		return unitused;
	}
	public void setUnitused(String unitused) {
		this.unitused = unitused;
	}
	
	@Column(name = "INVOICE_AMT")
	public String getInvoiceAmt() {
		return invoiceAmt;
	}
	public void setInvoiceAmt(String invoiceAmt) {
		this.invoiceAmt = invoiceAmt;
	}
	
	@Column(name = "VAT_AMT")
	public String getVatAmt() {
		return vatAmt;
	}
	public void setVatAmt(String vatAmt) {
		this.vatAmt = vatAmt;
	}
	
	@Column(name = "TYPE")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name = "INVOICE_NUMBER")
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	
	@Column(name = "FT_AMT")
	public String getFtAmt() {
		return ftAmt;
	}
	public void setFtAmt(String ftAmt) {
		this.ftAmt = ftAmt;
	}
	
	@Column(name = "FT_RATE")
	public String getFtRate() {
		return ftRate;
	}
	public void setFtRate(String ftRate) {
		this.ftRate = ftRate;
	}
	
	@Column(name = "DEMAND_AMT")
	public String getDemandAmt() {
		return demandAmt;
	}
	public void setDemandAmt(String demandAmt) {
		this.demandAmt = demandAmt;
	}
	
	@Column(name = "POWER_FACTOR_AMT")
	public String getPowerFactorAmt() {
		return powerFactorAmt;
	}
	public void setPowerFactorAmt(String powerFactorAmt) {
		this.powerFactorAmt = powerFactorAmt;
	}
	
	@Column(name = "FILLER2")
	public String getFiller2() {
		return filler2;
	}
	public void setFiller2(String filler2) {
		this.filler2 = filler2;
	}
	
	@Column(name = "LINE_NO")
	public BigDecimal getLineNo() {
		return lineNo;
	}

	public void setLineNo(BigDecimal lineNo) {
		this.lineNo = lineNo;
	}
	
}
