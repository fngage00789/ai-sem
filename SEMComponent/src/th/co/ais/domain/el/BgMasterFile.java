package th.co.ais.domain.el;

import java.io.Serializable;
import java.util.Date;

public class BgMasterFile implements Serializable{

	private static final long serialVersionUID = 3161819883514236788L;
	
	private String fileName;
	private String createBy;
	private Date createDt;
	private String filePath;
	
	
	public BgMasterFile(String fileName){
		
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}
