package th.co.ais.domain.mm;

import java.util.Date;
import th.co.ais.domain.AbstractDomain;

public class Mmm001HistorySP extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4382513449797786451L;

	private String rowId;
	
	private String contentChange;
	private String contentOld;
	private String contentNew;
	private Date lastUpdateDt;
	private String lastUpdateDtStr;
	private String lastUpdateBy;
	
	private String contractNo;
	private String historyPage;
	private String vendorId;
	private String payeeId;
	private String bookbankId;
	private String bookbankPayeeId;
	
	//added by NEW 
	private Date effectiveDt;
	private String effectiveDtStr;
	private Date expireDt;
	private String expireDtStr;
	
	
	@Override
	public String getCreateBy() {
		return createBy;
	}
	@Override
	public Date getCreateDt() {
		return createDt;
	}
	@Override
	public String getUpdateBy() {
		return updateBy;
	}
	@Override
	public Date getUpdateDt() {
		return updateDt;
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
	public String getContentChange() {
		return contentChange;
	}
	public void setContentChange(String contentChange) {
		this.contentChange = contentChange;
	}
	public String getContentOld() {
		return contentOld;
	}
	public void setContentOld(String contentOld) {
		this.contentOld = contentOld;
	}
	public String getContentNew() {
		return contentNew;
	}
	public void setContentNew(String contentNew) {
		this.contentNew = contentNew;
	}
	public String getLastUpdateDtStr() {
		return lastUpdateDtStr;
	}
	public void setLastUpdateDtStr(String lastUpdateDtStr) {
		this.lastUpdateDtStr = lastUpdateDtStr;
	}
	public String getLastUpdateBy() {
		return lastUpdateBy;
	}
	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}
	
	public Date getEffectiveDt() {
		return effectiveDt;
	}
	public void setEffectiveDt(Date effectiveDt) {
		this.effectiveDt = effectiveDt;
	}
	public Date getExpireDt() {
		return expireDt;
	}
	public void setExpireDt(Date expireDt) {
		this.expireDt = expireDt;
	}
	
	public Date getLastUpdateDt() {
		return lastUpdateDt;
	}
	public void setLastUpdateDt(Date lastUpdateDt) {
		this.lastUpdateDt = lastUpdateDt;
	}
	
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getHistoryPage() {
		return historyPage;
	}
	public void setHistoryPage(String historyPage) {
		this.historyPage = historyPage;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getPayeeId() {
		return payeeId;
	}
	public void setPayeeId(String payeeId) {
		this.payeeId = payeeId;
	}
	public String getBookbankId() {
		return bookbankId;
	}
	public void setBookbankId(String bookbankId) {
		this.bookbankId = bookbankId;
	}
	public String getBookbankPayeeId() {
		return bookbankPayeeId;
	}
	public void setBookbankPayeeId(String bookbankPayeeId) {
		this.bookbankPayeeId = bookbankPayeeId;
	}
	
	public String getEffectiveDtStr() {
		return effectiveDtStr;
	}
	public void setEffectiveDtStr(String effectiveDtStr) {
		this.effectiveDtStr = effectiveDtStr;
	}
	public String getExpireDtStr() {
		return expireDtStr;
	}
	public void setExpireDtStr(String expireDtStr) {
		this.expireDtStr = expireDtStr;
	}
	@Override
	public String toString() {
		return "Mmm001HistorySP [contentChange=" + contentChange + ", contentNew=" + contentNew + ", contentOld=" + contentOld + ", lastUpdateBy=" + lastUpdateBy + ", lastUpdateDtStr=" + lastUpdateDtStr + ", rowId=" + rowId + "]";
	}
	
}
