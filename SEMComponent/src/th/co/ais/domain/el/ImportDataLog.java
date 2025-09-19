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

@Entity(name="th.co.ais.domain.el.ImportDataLog")
@Table(name="SEM_EL_IMPORT_DATA_LOG")
public class ImportDataLog extends AbstractDomain {

	private static final long serialVersionUID = -1259859340715879556L;
	
	private String rowId;
	private ImportTransaction importTransId;
	private ImportMasterData processId;
	private BigDecimal lineNo;
	private String meterId;
	private String mnInvNo;
	private String errorCode;
	private String errorDesc;
	private String processDetail;
	
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
	@Column(name = "SEM_EL_IMPORT_DATA_LOG_ID")
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROCESS_ID")
	public ImportMasterData getProcessId() {
		return processId;
	}
	public void setProcessId(ImportMasterData processId) {
		this.processId = processId;
	}
	
	@Column(name = "LINE_NO")
	public BigDecimal getLineNo() {
		return lineNo;
	}
	public void setLineNo(BigDecimal lineNo) {
		this.lineNo = lineNo;
	}
	
	@Column(name = "METER_ID")
	public String getMeterId() {
		return meterId;
	}
	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}
	
	@Column(name = "MN_INV_NO")
	public String getMnInvNo() {
		return mnInvNo;
	}
	public void setMnInvNo(String mnInvNo) {
		this.mnInvNo = mnInvNo;
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
	
	@Column(name = "PROCESS_DETAIL")
	public String getProcessDetail() {
		return processDetail;
	}
	public void setProcessDetail(String processDetail) {
		this.processDetail = processDetail;
	}
	
}
