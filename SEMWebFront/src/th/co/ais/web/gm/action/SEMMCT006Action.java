package th.co.ais.web.gm.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import th.co.ais.domain.gm.Attachment;
import th.co.ais.domain.gm.MCT006SrchSP;
import th.co.ais.service.gm.IAttachmentService;
import th.co.ais.service.gm.ILovMasterService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupUploadFilePictureBean;
import th.co.ais.web.gm.bean.SEMMCT006Bean;
import th.co.ais.web.gm.bean.SEMMCT007Bean;
import th.co.ais.web.ir.bean.FileUploadBean;

public class SEMMCT006Action extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3392035372898601944L;
	
	private Logger LOG = Logger.getLogger(getClass());
	
	private SEMMCT006Bean semmct006Bean;
	
	public SEMMCT006Bean getSemmct006Bean() {
		
		SEMMCT006Bean ct006Bean =(SEMMCT006Bean)getFacesUtils().getSessionMapValue("semmct006Bean");
		if(ct006Bean == null)
			ct006Bean = new SEMMCT006Bean();
		return ct006Bean;
	}

	public void setSemmct006Bean(SEMMCT006Bean semmct006Bean) {
		this.semmct006Bean = semmct006Bean;
		getFacesUtils().setSessionMapValue("semmct006Bean", semmct006Bean);
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
	

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		// TODO Auto-generated method stub
		boolean flag = false;
		LOG.info("- - actionWithNavi - -");
		
		if (methodWithNavi.equalsIgnoreCase("doSearch")) {
			flag = doSearch();
		}
//		else if (methodWithNavi.equalsIgnoreCase("doClear")) {
//			flag = doClear();
//		}else if(methodWithNavi.equalsIgnoreCase("initDelete")){
//			flag = initDelete();
//		}else if(methodWithNavi.equalsIgnoreCase("doDelete")){
//			flag = doDelete();
//		}else if(methodWithNavi.equalsIgnoreCase("pageLoad")){
//			flag = pageLoad();
//		}else if(methodWithNavi.equalsIgnoreCase("doSave")){
//			flag = doSave();
//		}else if(methodWithNavi.equalsIgnoreCase("doBackPage")){
//			flag = doBackPage();
//		}else if(methodWithNavi.equalsIgnoreCase("getLovTypeByGroup")){
////			flag = getLovTypeByGroup();
//			flag = false;
//			init();
//		}
		return flag;
	}
	
	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		semmct006Bean = new SEMMCT006Bean();
		
		try{
			semmct006Bean.setModuleSrchList(getLovItemsByType(ELovType.T_CT_ATTACH_MODULE.name));
			semmct006Bean.setSubModuleSrchList(getLovItemsByType(ELovType.T_CT_ATTACH_SUB_MODULE.name));
			
			semmct006Bean.setMct006SrchList(new ArrayList<WrapperBeanObject<MCT006SrchSP>>());
			semmct006Bean.setMct006SrchSP(new MCT006SrchSP());
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug(" Error SEMMCT006Action init : "+e);
		}
		setSemmct006Bean(semmct006Bean);
	}
	
	private void queryAttachmentByRefID(String refID) throws Exception{
		List<Attachment> attachmentList = new ArrayList<Attachment>();
		IAttachmentService atchService = (IAttachmentService)getBean("attachmentService");
		Attachment attachment = new Attachment();
		attachment.setRefferenceId(refID);
		attachmentList = atchService.queryAttachmentByCriteria(attachment);
		getPopupUploadFilePictureBean().setAttachmentList(attachmentList);
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}


	private boolean doSearch(){
		boolean flag = true;
		semmct006Bean = getSemmct006Bean();
		List<MCT006SrchSP> to = new ArrayList<MCT006SrchSP>();
		
		try{
			ILovMasterService lovMasterService = (ILovMasterService)getBean("lovMasterService");
			
			to = lovMasterService.querySPList(EQueryName.Q_CT006_SRCH.name, semmct006Bean.getMct006SrchSP());
			
			if(to != null){
				semmct006Bean.setMct006SrchList(new ArrayList<WrapperBeanObject<MCT006SrchSP>>());
				
				for(MCT006SrchSP obj : to){
					WrapperBeanObject<MCT006SrchSP> wrapRes = new WrapperBeanObject<MCT006SrchSP>();
					
					
					if(obj.getCreateDt() != null){
						obj.setCreateDtStr(convertYearENtoTHStr(obj.getCreateDt()));
					}
					
					wrapRes.setDataObj(obj);
					semmct006Bean.getMct006SrchList().add(wrapRes);
				}
			}else{
				semmct006Bean.setMct006SrchList(new ArrayList<WrapperBeanObject<MCT006SrchSP>>());
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug(" ERROR SEMMCT006Action doSearch : "+e);
			flag = false;
		}finally{
			setSemmct006Bean(semmct006Bean);
		}
		return flag;
	}
	
	public boolean doClear(){
		boolean flag = true;
		semmct006Bean = getSemmct006Bean();
		try{
			
			semmct006Bean.setMct006SrchList(new ArrayList<WrapperBeanObject<MCT006SrchSP>>());
			semmct006Bean.setMct006SrchSP(new MCT006SrchSP());
			
			setSemmct006Bean(semmct006Bean);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug(" Error SEMMCT006Bean doClear : "+e);
		}
		return flag;
	}
	
	public boolean getSubModule(){
		semmct006Bean = getSemmct006Bean();
		boolean flag = true;
		try{
			
			semmct006Bean.setSubModuleSrchList(getLovItemsByType(ELovType.T_CT_ATTACH_SUB_MODULE.name, EX_AND, semmct006Bean.getMct006SrchSP().getAttModule(), null, null));
			
			setSemmct006Bean(semmct006Bean);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("  Error SEMMCT006Action getSubModule : "+e);
			flag = false;
		}
		return flag;
	}
	
	

}
