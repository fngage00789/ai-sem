package th.co.ais.domain.el;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;

@Entity
@Table(name="SEM_EL_IMPORT_MASTER_DATA", schema="SEM")
public class ImportMasterData extends AbstractDomain {
	
	private static final long serialVersionUID = -2015922448059369841L;
	
	private String rowId;
	private String electrictUseTypeTh;	
	private String electrictUseTypeEn;
	private String fileTypeTh;
	private String fileTpeEn;
	private String soucePath;
	private String destPath;
	private String backupPath;
	private String processPath;
	
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
	
	@Id
  	@GeneratedValue(generator="system-uuid")
  	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "PROCESS_ID")	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	@Column(name = "ELECTRIC_USE_TYPE_TH")
	public String getElectrictUseTypeTh() {
		return electrictUseTypeTh;
	}
	public void setElectrictUseTypeTh(String electrictUseTypeTh) {
		this.electrictUseTypeTh = electrictUseTypeTh;
	}
	
	@Column(name = "ELECTRIC_USE_TYPE_EN")
	public String getElectrictUseTypeEn() {
		return electrictUseTypeEn;
	}
	public void setElectrictUseTypeEn(String electrictUseTypeEn) {
		this.electrictUseTypeEn = electrictUseTypeEn;
	}
	
	@Column(name = "FILE_TYPE_TH")
	public String getFileTypeTh() {
		return fileTypeTh;
	}
	public void setFileTypeTh(String fileTypeTh) {
		this.fileTypeTh = fileTypeTh;
	}
	
	@Column(name = "FILE_TYPE_EN")
	public String getFileTpeEn() {
		return fileTpeEn;
	}
	public void setFileTpeEn(String fileTpeEn) {
		this.fileTpeEn = fileTpeEn;
	}
	
	@Column(name = "SOURCE_PATH")
	public String getSoucePath() {
		return soucePath;
	}
	public void setSoucePath(String soucePath) {
		this.soucePath = soucePath;
	}
	
	@Column(name = "DEST_PATH")
	public String getDestPath() {
		return destPath;
	}
	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}
	
	@Column(name = "BACKUP_PATH")
	public String getBackupPath() {
		return backupPath;
	}
	public void setBackupPath(String backupPath) {
		this.backupPath = backupPath;
	}
	
	@Column(name = "PROCESS_PATH")
	public String getProcessPath() {
		return processPath;
	}
	public void setProcessPath(String processPath) {
		this.processPath = processPath;
	}

}
