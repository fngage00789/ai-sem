package th.co.ais.web.gm.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.gm.Attachment;
import th.co.ais.domain.gm.MCT006SrchSP;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMCT006Bean extends AbstractBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 546468869041005858L;
	
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
	
	private int rowPerPage = 20;
	
	private boolean viewMode;
	private String refId;
	
	private boolean renderPopUpDel;
	
	public SEMMCT006Bean(){
		this.moduleList = new ArrayList<SelectItem>();
		this.subModuleList = new ArrayList<SelectItem>();
		this.moduleSrchList = new ArrayList<SelectItem>();
		this.subModuleSrchList = new ArrayList<SelectItem>();
	}
	
	private MCT006SrchSP mct006SrchSP;
	private List<WrapperBeanObject<MCT006SrchSP>> mct006SrchList;
	
	
	public boolean isRenderedColDel() {
		return renderedColDel;
	}

	public void setRenderedColDel(boolean renderedColDel) {
		this.renderedColDel = renderedColDel;
	}

	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public Attachment getTmpAttachment() {
		return tmpAttachment;
	}

	public void setTmpAttachment(Attachment tmpAttachment) {
		this.tmpAttachment = tmpAttachment;
	}

	public String getTmpRefId() {
		return tmpRefId;
	}

	public void setTmpRefId(String tmpRefId) {
		this.tmpRefId = tmpRefId;
	}

	public String getAttachModule() {
		return attachModule;
	}

	public void setAttachModule(String attachModule) {
		this.attachModule = attachModule;
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

	public String getPublicString() {
		return publicString;
	}

	public void setPublicString(String publicString) {
		this.publicString = publicString;
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

	public MCT006SrchSP getMct006SrchSP() {
		return mct006SrchSP;
	}

	public void setMct006SrchSP(MCT006SrchSP mct006SrchSP) {
		this.mct006SrchSP = mct006SrchSP;
	}

	public List<WrapperBeanObject<MCT006SrchSP>> getMct006SrchList() {
		return mct006SrchList;
	}

	public void setMct006SrchList(
			List<WrapperBeanObject<MCT006SrchSP>> mct006SrchList) {
		this.mct006SrchList = mct006SrchList;
	}

	@Override
	public int getRowPerPage() {
		// TODO Auto-generated method stub
		return rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		// TODO Auto-generated method stub
		rowPerPage = 20;
	}

}
