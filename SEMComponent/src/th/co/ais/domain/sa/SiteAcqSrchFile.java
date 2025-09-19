package th.co.ais.domain.sa;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class SiteAcqSrchFile extends AbstractDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = -140406877984841285L;

	String attachmentPath;
	String fileName;
	String contractNo;
	
	String updateDtStr;
	
	
	public String getAttachmentPath() {
		return attachmentPath;
	}
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getUpdateDtStr() {
		return updateDtStr;
	}
	public void setUpdateDtStr(String updateDtStr) {
		this.updateDtStr = updateDtStr;
	}
	@Override
	public String getCreateBy() {
		// TODO Auto-generated method stub
		return this.createBy;
	}
	@Override
	public Date getCreateDt() {
		// TODO Auto-generated method stub
		return this.createDt;
	}
	@Override
	public String getUpdateBy() {
		// TODO Auto-generated method stub
		return this.updateBy;
	}
	@Override
	public Date getUpdateDt() {
		// TODO Auto-generated method stub
		return this.updateDt;
	}
	@Override
	public void setCreateBy(String createBy) {
		// TODO Auto-generated method stub
		this.createBy = createBy;
	}
	@Override
	public void setCreateDt(Date createDt) {
		// TODO Auto-generated method stub
		this.createDt = createDt;
	}
	@Override
	public void setUpdateBy(String updateBy) {
		// TODO Auto-generated method stub
		this.updateBy = updateBy;
	}
	@Override
	public void setUpdateDt(Date updateDt) {
		// TODO Auto-generated method stub
		this.updateDt = updateDt;
	}
	
}
