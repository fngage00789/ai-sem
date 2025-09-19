package th.co.ais.domain.gm;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class MCT006SrchSP extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8427510102200583629L;

	private String rowId;
	private String attachmentId;
	private String attModule;
	private String attSubModule;
	private String attaPublic;
	private String attaPublicName;
	private String attaPath;
	private String contractNo;
	private String fileName;
	private String createDtStr;
	private String updateDtStr;
	
	
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}

	public String getAttModule() {
		return attModule;
	}

	public void setAttModule(String attModule) {
		this.attModule = attModule;
	}

	public String getAttSubModule() {
		return attSubModule;
	}

	public void setAttSubModule(String attSubModule) {
		this.attSubModule = attSubModule;
	}

	public String getAttaPublic() {
		return attaPublic;
	}

	public void setAttaPublic(String attaPublic) {
		this.attaPublic = attaPublic;
	}

	public String getAttaPublicName() {
		return attaPublicName;
	}

	public void setAttaPublicName(String attaPublicName) {
		this.attaPublicName = attaPublicName;
	}

	public String getAttaPath() {
		return attaPath;
	}

	public void setAttaPath(String attaPath) {
		this.attaPath = attaPath;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getCreateDtStr() {
		return createDtStr;
	}

	public void setCreateDtStr(String createDtStr) {
		this.createDtStr = createDtStr;
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
		return createBy;
	}

	@Override
	public Date getCreateDt() {
		// TODO Auto-generated method stub
		return createDt;
	}

	@Override
	public String getUpdateBy() {
		// TODO Auto-generated method stub
		return updateBy;
	}

	@Override
	public Date getUpdateDt() {
		// TODO Auto-generated method stub
		return updateDt;
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
