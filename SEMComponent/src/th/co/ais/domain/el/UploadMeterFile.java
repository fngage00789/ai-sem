package th.co.ais.domain.el;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;

@Entity(name="th.co.ais.domain.el.UploadMeterFile")
@Table(name="SEM_EL_UPLOAD_METER_FILE", schema="SEM")
public class UploadMeterFile extends AbstractDomain {

	private static final long serialVersionUID = 5096582549841295206L;
	
	private String rowId;	
	private String fileName;	
	private String filePath;
	private String successNo;
	private String failedNo;
	private String recordStatus;	
	private String failedLine;
	private String totalNo;
	
	private Set<UploadMeter> uploadMeters = new TreeSet<UploadMeter>();
	private Set<UploadMeterTemp> uploadMeterTemps = new TreeSet<UploadMeterTemp>();
	
	@Id
  	@GeneratedValue(generator="system-uuid")
  	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "METER_FILE_ID")
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	@Column(name = "FILE_NAME")
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Column(name = "FILE_PATH")
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	@Column(name = "SUCCESS_NO")
	public String getSuccessNo() {
		return successNo;
	}
	public void setSuccessNo(String successNo) {
		this.successNo = successNo;
	}
	
	@Column(name = "RECORD_STATUS")
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	
	@Column(name = "FAILED_NO")
	public String getFailedNo() {
		return failedNo;
	}
	public void setFailedNo(String failedNo) {
		this.failedNo = failedNo;
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
	
	@org.hibernate.annotations.OrderBy(clause = "ITEM_NO asc")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "meterFile")
	public Set<UploadMeter> getUploadMeters() {
		return uploadMeters;
	}
	public void setUploadMeters(Set<UploadMeter> uploadMeters) {
		this.uploadMeters = uploadMeters;
	}	
	
	@Transient
	public String getAllRecord(){
		String strReturn = "";
		try {
			int successNo = new Integer(this.successNo).intValue();
			int failedNo = new Integer(this.failedNo).intValue();
			int allRecord = successNo+failedNo;
			strReturn = allRecord+"";
		} catch (NumberFormatException e) {
			
		}
		return strReturn;
	}
	
	@Transient
	public List<UploadMeter> getUploadMeterList(){
		if(null==uploadMeters || uploadMeters.size()==0){
			return null;
		}
		List<UploadMeter> list = new ArrayList<UploadMeter>(uploadMeters);
		return list;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "meterFile")
	public Set<UploadMeterTemp> getUploadMeterTemps() {
		return uploadMeterTemps;
	}
	public void setUploadMeterTemps(Set<UploadMeterTemp> uploadMeterTemps) {
		this.uploadMeterTemps = uploadMeterTemps;
	}
	
	@Column(name = "FAILED_LINE")
	public String getFailedLine() {
		return failedLine;
	}
	public void setFailedLine(String failedLine) {
		this.failedLine = failedLine;
	}
	
	@Transient
	public boolean isError(){
		
		boolean booleanReturn = false;
		if(null!=failedLine && !"".equals(failedLine)){
			booleanReturn = true;
		}
		
		return booleanReturn;
	}
	
	@Column(name = "TOTAL_NO")
	public String getTotalNo() {
		return totalNo;
	}
	public void setTotalNo(String totalNo) {
		this.totalNo = totalNo;
	}

}
