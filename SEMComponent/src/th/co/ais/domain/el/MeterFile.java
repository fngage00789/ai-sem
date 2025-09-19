package th.co.ais.domain.el;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class MeterFile extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2366449713302303977L;
	
	public MeterFile(String fileName){
		
		this.fileName = fileName;
	}
	
	// data
	private String fileName;
	private boolean saved;
	
	// business logic method
	@Override
	public boolean equals(Object obj) {
		
		if(this.fileName == null) return false;
		
		if(obj != null && obj instanceof MeterFile){
			
			return this.fileName.equals(((MeterFile)obj).getFileName());
		}
		
		return false;
	}
	
	// getter & setter
	public String getFileName() {
		return fileName;
	}

	public boolean isSaved() {
		return saved;
	}

	public void setSaved(boolean saved) {
		this.saved = saved;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public String getCreateBy() {
		return this.createBy;
	}

	@Override
	public Date getCreateDt() {
		return this.createDt;
	}
	
	@Override
	public String getUpdateBy() {
		return this.updateBy;
	}
	
	@Override
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
}
