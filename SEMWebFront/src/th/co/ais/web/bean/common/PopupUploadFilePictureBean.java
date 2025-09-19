package th.co.ais.web.bean.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.gm.Attachment;
import th.co.ais.web.bean.AbstractBean;

public class PopupUploadFilePictureBean extends AbstractBean {
	
	private static final long serialVersionUID = 6909615740636416423L;
	
	private boolean renderedColDel = true;
	
	//data table attachment.
	private List<Attachment> attachmentList;
	//keep attachment obj when delete.
	private Attachment tmpAttachment;
	//for query data for displaying.
	private String tmpRefId;
	
	private String attachModule;
	private List<SelectItem> moduleList;
	private List<SelectItem> subModuleList;
	private List<SelectItem> moduleSrchList;
	private List<SelectItem> subModuleSrchList;
	private String module;
	private String subModule;
	private String publicString;
	private String contractNo;
	
	private Attachment attachCri;
	
	private int rowPerPage = 10;
	
	private boolean viewMode;
	private String refId;
	
	private boolean renderPopUpDel;
	
	public PopupUploadFilePictureBean(){
		this.moduleList = new ArrayList<SelectItem>();
		this.subModuleList = new ArrayList<SelectItem>();
		this.moduleSrchList = new ArrayList<SelectItem>();
		this.subModuleSrchList = new ArrayList<SelectItem>();
	}
	
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public List<Attachment> getAttachmentList() {
		if(attachmentList == null)
			attachmentList = new ArrayList<Attachment>();
		return attachmentList;
	}

	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public String getTmpRefId() {
		return tmpRefId;
	}

	public void setTmpRefId(String tmpRefId) {
		this.tmpRefId = tmpRefId;
	}

	public Attachment getTmpAttachment() {
		return tmpAttachment;
	}

	public void setTmpAttachment(Attachment tmpAttachment) {
		this.tmpAttachment = tmpAttachment;
	}

	public boolean isRenderedColDel() {
		return renderedColDel;
	}

	public void setRenderedColDel(boolean renderedColDel) {
		this.renderedColDel = renderedColDel;
	}

	public String getAttachModule() {
		return attachModule;
	}

	public void setAttachModule(String attachModule) {
		this.attachModule = attachModule;
	}

	public String getPublicString() {
		return publicString;
	}

	public void setPublicString(String publicString) {
		this.publicString = publicString;
	}

	public List<SelectItem> getModuleList() {
		return moduleList;
	}

	public void setModuleList(List<SelectItem> moduleList) {
		this.moduleList = moduleList;
	}

	public List<SelectItem> getSubModuleList() {
		return subModuleList;
	}

	public void setSubModuleList(List<SelectItem> subModuleList) {
		this.subModuleList = subModuleList;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getSubModule() {
		return subModule;
	}

	public void setSubModule(String subModule) {
		this.subModule = subModule;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public Attachment getAttachCri() {
		return attachCri;
	}

	public void setAttachCri(Attachment attachCri) {
		this.attachCri = attachCri;
	}

	public boolean isViewMode() {
		return viewMode;
	}

	public void setViewMode(boolean viewMode) {
		this.viewMode = viewMode;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public boolean isRenderPopUpDel() {
		return renderPopUpDel;
	}

	public void setRenderPopUpDel(boolean renderPopUpDel) {
		this.renderPopUpDel = renderPopUpDel;
	}

	public List<SelectItem> getModuleSrchList() {
		return moduleSrchList;
	}

	public void setModuleSrchList(List<SelectItem> moduleSrchList) {
		this.moduleSrchList = moduleSrchList;
	}

	public List<SelectItem> getSubModuleSrchList() {
		return subModuleSrchList;
	}

	public void setSubModuleSrchList(List<SelectItem> subModuleSrchList) {
		this.subModuleSrchList = subModuleSrchList;
	}

}
