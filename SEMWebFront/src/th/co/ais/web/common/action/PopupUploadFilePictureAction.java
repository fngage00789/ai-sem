package th.co.ais.web.common.action;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import sun.util.logging.resources.logging;
import th.co.ais.domain.gm.Attachment;
import th.co.ais.service.gm.IAttachmentService;
import th.co.ais.util.ELovType;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupUploadFilePictureBean;
import th.co.ais.web.ir.bean.FileUploadBean;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.FileUtil;

public class PopupUploadFilePictureAction extends AbstractAction{

	private static final long serialVersionUID = 154181415663741549L;
	private Logger LOG = Logger.getLogger(getClass());

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doCreateAttachment")){
			flag = doCreateAttachment();
		}else if(methodWithNavi.equalsIgnoreCase("doDelAttachment")){
			flag = doDelAttachment();
		}else if(methodWithNavi.equalsIgnoreCase("initDelAttachment")){
			flag = initDelAttachment();
		}else if(methodWithNavi.equalsIgnoreCase("init")){
			init();
		}else if(methodWithNavi.equalsIgnoreCase("initUploadCriteria")){
			initUploadCriteria();
		}else if(methodWithNavi.equalsIgnoreCase("doSearchAttachment")){
			doSearchAttachment();
		}else if(methodWithNavi.equalsIgnoreCase("doClear")){
			doClear();
		}else if(methodWithNavi.equalsIgnoreCase("getSubModule")){
			getSubModule();
		}
		
		return flag;
	}

	
	private boolean initUploadCriteria() {
		String refID = (String)getFacesUtils().getRequestParameter("refId");
		String attachModule = (String)getFacesUtils().getRequestParameter("attachModule");
		String module = (String)getFacesUtils().getRequestParameter("module");
		String contractNo = (String)getFacesUtils().getRequestParameter("contractNo");
		String viewMode = (String)getFacesUtils().getRequestParameter("viewMode");
		PopupUploadFilePictureBean uploadBean = getPopupUploadFilePictureBean();
		try {
			uploadBean.setAttachCri(new Attachment());
			uploadBean.setModule(null);
			uploadBean.setSubModule(null);
			uploadBean.setAttachmentList(null);
			//Set temp ref ID.
			getUserSession().setRefId(refID);
			
			uploadBean.setModuleSrchList(getLovItemsByType(ELovType.T_CT_ATTACH_MODULE.name));
			uploadBean.setSubModuleSrchList(getLovItemsByType(ELovType.T_CT_ATTACH_SUB_MODULE.name, EX_AND, module, null, null));
			
			if(StringUtils.equalsIgnoreCase("Y", viewMode)){
				uploadBean.setViewMode(true);
				uploadBean.setModuleList(getLovItemsByType(ELovType.T_CT_ATTACH_MODULE.name));
				uploadBean.setSubModuleList(getEmptyDropDown());
//				uploadBean.setSubModuleList(getLovItemsByType(ELovType.T_CT_ATTACH_SUB_MODULE.name));
			}else{
				uploadBean.setViewMode(false);
				if(StringUtils.equals("ALL", module)){
					uploadBean.setModuleList(getLovItemsByType(ELovType.T_CT_ATTACH_MODULE.name));
					uploadBean.setSubModuleList(getLovItemsByType(ELovType.T_CT_ATTACH_SUB_MODULE.name));
				}else{
					uploadBean.setModuleList(getLovItemsByType(ELovType.T_CT_ATTACH_MODULE.name, EX_AND, module, null, null));
					uploadBean.setSubModuleList(getLovItemsByType(ELovType.T_CT_ATTACH_SUB_MODULE.name, EX_AND, module, null, null));
					module = "";
				}
				
				
				getPopupUploadFilePictureBean().setModule(module);
			
				Attachment attachment = new Attachment();
				
				attachment.setRefferenceId(refID);
				if(StringUtils.isNotEmpty(contractNo))
					attachment.setContractNo(contractNo);
				if(StringUtils.isNotEmpty(module)){
					attachment.setAttachmentModule(module);
					attachment.setCreateBy(getUserLogIn());
					if(StringUtils.equalsIgnoreCase("Y", viewMode)){
						attachment.setPublicArr(new String[] {"PR"});
					}else{
						attachment.setPublicArr(new String[] {"PB","EX"});
					}
				}
				
	//			queryAttachmentByRefID(refID);
				queryAttachmentByCriteria(attachment);
				uploadBean.setAttachCri(attachment);
				
				//added by NEW 22/03/2016 set public type to public
				if("SA".equals(module))uploadBean.setPublicString("PB");
			}
			LOG.debug("attachModule = "+attachModule);
			LOG.debug("refID = "+refID);
			LOG.debug("module = "+module);
			LOG.debug("contractNo = "+contractNo);
			uploadBean.setRefId(refID);
//			getPopupUploadFilePictureBean().setAttachModule(attachModule);
//			getPopupUploadFilePictureBean().setContractNo(contractNo);
			uploadBean.setAttachModule(attachModule);
			uploadBean.setContractNo(contractNo);
			uploadBean.setRowPerPage(5);
			setPopupUploadFilePictureBean(uploadBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 return false;
	}
	
	private void doClear(){
		PopupUploadFilePictureBean uploadBean = getPopupUploadFilePictureBean();
		uploadBean.setModule(null);
		uploadBean.setSubModule(null);
		uploadBean.setAttachmentList(null);
		setPopupUploadFilePictureBean(uploadBean);
	}
	
	public void getSubModuleList(){
		PopupUploadFilePictureBean uploadBean = getPopupUploadFilePictureBean();
		uploadBean.setSubModuleList(getLovItemsByType(ELovType.T_CT_ATTACH_SUB_MODULE.name, EX_AND, uploadBean.getModule(), null, null));
		setPopupUploadFilePictureBean(uploadBean);
	}
	
	public void getSubModule(){
		PopupUploadFilePictureBean uploadBean = getPopupUploadFilePictureBean();
		uploadBean.setSubModuleSrchList(getLovItemsByType(ELovType.T_CT_ATTACH_SUB_MODULE.name, EX_AND, uploadBean.getAttachCri().getAttachmentModule(), null, null));
		setPopupUploadFilePictureBean(uploadBean);
	}
	
	private boolean doSearchAttachment(){
		PopupUploadFilePictureBean uploadbean = getPopupUploadFilePictureBean();
		try {
			Attachment attachment = new Attachment();
			String lovVal2 = getLovVal2(ELovType.T_CT_ATTACH_MODULE.name, uploadbean.getModule());
			LOG.debug("lovVal2 = "+lovVal2);
			attachment.setContractNo(uploadbean.getContractNo());
			attachment.setAttachmentModule(uploadbean.getAttachCri().getAttachmentModule());
			attachment.setAttachmentSubModule(uploadbean.getAttachCri().getAttachmentSubModule());
//			attachment.setAttachmentPublic("Y");
			attachment.setCreateBy(getUserLogIn());
//			if(StringUtils.equalsIgnoreCase("Y", lovVal2)){
//				attachment.setRefferenceId(uploadbean.getRefId());	
//			}
			
			if(uploadbean.isViewMode()){
				attachment.setPublicArr(new String[] {"EX"});
			}else{
				attachment.setPublicArr(new String[] {"PB","EX"});
			}
			
			LOG.debug("attachment.getContractNo() ="+attachment.getContractNo());
			LOG.debug("attachment.getModule() ="+attachment.getAttachmentModule());
			LOG.debug("attachment.getSubModule() ="+attachment.getAttachmentSubModule());
			LOG.debug("getUserLogIn() ="+getUserLogIn());
//			LOG.debug("uploadbean.getRefId() = "+uploadbean.getRefId());
			getPopupUploadFilePictureBean().setAttachCri(attachment);
			
			queryAttachmentByCriteria(getPopupUploadFilePictureBean().getAttachCri());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}


	private boolean doCreateAttachment() {
		boolean flag = false;
		//REF ID
		//String refId = (String)getFacesUtils().getRequestParameter("refId");
		String refId = getUserSession().getRefId();
		String attachModule = (String)getFacesUtils().getRequestParameter("attachModule");
		LOG.info("refId :" + refId);
		LOG.debug("attachModule = "+attachModule);
		String filename = getFileUploadBean().getFileName();
    	String filePath = getFileUploadBean().getPathName();
    	try {
        	IAttachmentService atchService = (IAttachmentService)FacesUtils.getInstance().getBean("attachmentService");
        	Attachment attachment = new Attachment();
        	if(StringUtils.isNotEmpty(attachModule))
        		attachment.setAttachmentModule(attachModule);
        	else
        		attachment.setAttachmentModule(getPopupUploadFilePictureBean().getModule());
        	
        	attachment.setFileName(filename);
        	attachment.setRefferenceId(refId);
        	attachment.setAttachmentPath(filePath);
        	attachment.setAttachmentSubModule(getPopupUploadFilePictureBean().getSubModule());
        	attachment.setAttachmentPublic(getPopupUploadFilePictureBean().getPublicString());
        	attachment.setContractNo(getPopupUploadFilePictureBean().getContractNo());
        	attachment.setCurrentUser(getPopupUploadFilePictureBean().getUserLogin());
			atchService.createAttachment(attachment);
//			queryAttachmentByRefID(refId);		
			if(getPopupUploadFilePictureBean().getAttachCri() != null)
				queryAttachmentByCriteria(getPopupUploadFilePictureBean().getAttachCri());
			else
				queryAttachmentByRefID(refId);
				
			addMessageInfo("M0001");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				//remove file uploaded.
				FileUtil.getInstance().removeFile(filePath);
				addMessageError("E0001");
			} catch (IOException e1) {
				e1.printStackTrace();
				 //show error message.
	        	addMessageError("E0001");
			}
			 //show error message.
        	addMessageError("E0001");
		} finally{
			//getPopupUploadFilePictureBean().setRenderedMsgFormTop(false);
		}
		return flag;
	}
	
	public boolean initDelAttachment(){
		boolean flag = false;
		IAttachmentService atchService = (IAttachmentService)getBean("attachmentService");
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		String user = (String)getFacesUtils().getRequestParameter("user");
		popupUploadFilePictureBean = getPopupUploadFilePictureBean();
		try {
			if(StringUtils.equalsIgnoreCase(user, getUserLogIn())){
				Attachment attachment = atchService.getAttachmentByRowId(rowId);
				attachment.setCurrentUser(popupUploadFilePictureBean.getUserLogin());
				popupUploadFilePictureBean.setTmpAttachment(attachment);
				popupUploadFilePictureBean.setRenderPopUpDel(true);
			}else{
				popupUploadFilePictureBean.setRenderPopUpDel(false);
				addMessageError("W0172");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		setPopupUploadFilePictureBean(popupUploadFilePictureBean);
		return flag;
	}
	
	private boolean doDelAttachment() {
		boolean flag = false;
		IAttachmentService atchService = (IAttachmentService)getBean("attachmentService");
		popupUploadFilePictureBean = getPopupUploadFilePictureBean();
		try {
			atchService.deleteAttachmentRecord(popupUploadFilePictureBean.getTmpAttachment());
			//addMessageInfo("incContent:frmUploadFile:txtFileUpload", "M0002" , "");
			addMessageInfo("M0002");
			
		} catch (Exception e) {
			e.printStackTrace();
			//addMessageError("incContent:frmUploadFile:txtFileUpload", "E0002" , "");
			addMessageInfo("E0002");
		} finally{
			//pageLoad();
			String rowId = popupUploadFilePictureBean.getTmpAttachment().getRefferenceId();
			try {
//				queryAttachmentByRefID(rowId);
				queryAttachmentByCriteria(getPopupUploadFilePictureBean().getAttachCri());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	private void queryAttachmentByRefID(String refID) throws Exception{
		List<Attachment> attachmentList = new ArrayList<Attachment>();
		IAttachmentService atchService = (IAttachmentService)getBean("attachmentService");
		Attachment attachment = new Attachment();
		attachment.setRefferenceId(refID);
		attachmentList = atchService.queryAttachmentByCriteria(attachment);
		getPopupUploadFilePictureBean().setAttachmentList(attachmentList);
	}
	
	private void queryAttachmentByCriteria(Attachment attachment) throws Exception{
		List<Attachment> attachmentList = new ArrayList<Attachment>();
		IAttachmentService atchService = (IAttachmentService)getBean("attachmentService");
//		Attachment attachment = new Attachment();
//		attachment.setRefferenceId(refID);
		attachmentList = atchService.queryAttachmentByCriteria(attachment);
		//Set Module, Sub Module, Public
		List<SelectItem> s = null;
		for(Attachment tmp : attachmentList){
			if (StringUtils.isNotEmpty(tmp.getAttachmentModule())) {
				s = th.co.ais.web.util.WebUtil.getSelectItemByValue(
						tmp.getAttachmentModule(), getPopupUploadFilePictureBean().getModuleSrchList());
				LOG.debug("s = "+s);
				if (s != null) {
					tmp.setAttachmentModule(s.get(0).getLabel());
				}
			}
			if (StringUtils.isNotEmpty(tmp.getAttachmentSubModule())) {
				s = th.co.ais.web.util.WebUtil.getSelectItemByValue(
						tmp.getAttachmentSubModule(), getPopupUploadFilePictureBean().getSubModuleSrchList());
				if (s != null) {
					tmp.setAttachmentSubModule(s.get(0).getLabel());
				}
			}
			if (StringUtils.isNotEmpty(tmp.getAttachmentPublic())) {
				tmp.setAttachmentPublic((StringUtils.equalsIgnoreCase("PR", tmp.getAttachmentPublic()))?"Private":(StringUtils.equalsIgnoreCase("PB", tmp.getAttachmentPublic()))?"Public":"External");
			}
		}
		
		LOG.debug("attachmentList size = "+attachmentList.size());
		getPopupUploadFilePictureBean().setAttachmentList(attachmentList);
	}
	
	@Override
	public void clearSessionNotUsed() {
		
	}

	@Override
	public void init() {
		String refID = (String)getFacesUtils().getRequestParameter("refId");
		String attachModule = (String)getFacesUtils().getRequestParameter("attachModule");
		try {
			//Set temp ref ID.
			getUserSession().setRefId(refID);
			queryAttachmentByRefID(refID);
			LOG.debug("attachModule = "+attachModule);
			LOG.debug("refID = "+refID);
			getPopupUploadFilePictureBean().setAttachModule(attachModule);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		return flgValid;
	}
	
	
	private PopupUploadFilePictureBean popupUploadFilePictureBean;
	private FileUploadBean fileUploadBean;
	
	public PopupUploadFilePictureBean getPopupUploadFilePictureBean() {
		return (PopupUploadFilePictureBean)getFacesUtils().getSessionMapValue("popupUploadFilePictureBean");
	}

	public void setPopupUploadFilePictureBean(PopupUploadFilePictureBean popupUploadFilePictureBean) {
		this.popupUploadFilePictureBean = popupUploadFilePictureBean;
		getFacesUtils().setSessionMapValue("popupUploadFilePictureBean", popupUploadFilePictureBean);
	}

	public FileUploadBean getFileUploadBean() {
		return (FileUploadBean)getFacesUtils().getSessionMapValue("fileUploadBean");
	}
	public void setFileUploadBean(FileUploadBean fileUploadBean) {
		this.fileUploadBean = fileUploadBean;
		getFacesUtils().setSessionMapValue("fileUploadBean", fileUploadBean);
	}
	

}
