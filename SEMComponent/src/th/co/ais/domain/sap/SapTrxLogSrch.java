package th.co.ais.domain.sap;

import java.util.Date;

public class SapTrxLogSrch extends SapTrxLog {

	private static final long serialVersionUID = -5567473122966280421L;
	
	private boolean loadChild;
	private Date createDtFrom;
	private Date createDtTo;
	private Date updateDtFrom;
	private Date updateDtTo;
		
	public boolean isLoadChild() {
		return loadChild;
	}
	
	public void setLoadChild(boolean loadChild) {
		this.loadChild = loadChild;
	}
	public Date getCreateDtFrom() {
		return createDtFrom;
	}
	public void setCreateDtFrom(Date createDtFrom) {
		this.createDtFrom = createDtFrom;
	}
	public Date getCreateDtTo() {
		return createDtTo;
	}
	public void setCreateDtTo(Date createDtTo) {
		this.createDtTo = createDtTo;
	}
	public Date getUpdateDtFrom() {
		return updateDtFrom;
	}
	public void setUpdateDtFrom(Date updateDtFrom) {
		this.updateDtFrom = updateDtFrom;
	}
	public Date getUpdateDtTo() {
		return updateDtTo;
	}
	public void setUpdateDtTo(Date updateDtTo) {
		this.updateDtTo = updateDtTo;
	}
	
}
