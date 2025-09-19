package th.co.ais.web.gm.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.gm.GLAccount;
import th.co.ais.service.gm.IGLAccountService;
import th.co.ais.util.ELovType;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.gm.bean.SEMMCT004Bean;
import th.co.ais.web.gm.bean.SEMMCT005Bean;
import th.co.ais.web.util.MSGCacheUtil;

public class SEMMCT005Action extends AbstractAction{
	private static final long serialVersionUID = 1L;
	private static final String STATUS_YES = "Y";
	private static final String STATUS_NO = "N";
	private static final String MODE_EDIT = "EDIT";
	private static final String MODE_VIEW = "VIEW";
	private static final String MODE_ADD = "ADD";
	
	private Logger LOG = Logger.getLogger(getClass());
	
	SEMMCT005Bean semmct005Bean;

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		LOG.debug("CT005--action NAV");
		boolean flag = false;
		try{
		if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		}else{
			if(methodWithNavi.equalsIgnoreCase("initDel")){
				flag = initDel();
			}else{
				if(methodWithNavi.equalsIgnoreCase("doDelete")){
					flag = doDelete();
				}else{
					if(methodWithNavi.equalsIgnoreCase("doClear")){
						flag = doClear();
					}else{
						if(methodWithNavi.equalsIgnoreCase("pageLoad")){
							flag = pageLoad();
						}else{
							if(methodWithNavi.equalsIgnoreCase("doCreate")){
								flag = doCreate();
							}else{
								if(methodWithNavi.equalsIgnoreCase("doSave")){
									flag = doSave();
								}else{
									if(methodWithNavi.equalsIgnoreCase("doBack")){
										flag = goBack();
									}
									}
							}
						}
					}
				}
			}
		}
		}catch(Exception e){}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		LOG.debug("CT005--init");
		SEMMCT005Bean semmct005Bean = new SEMMCT005Bean();
		setSemmct005Bean(semmct005Bean);
		semmct005Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmct005Bean.setExpenseList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name));
		semmct005Bean.setPlaceTypeList(getLovItemsByType(ELovType.T_SI_PLACE_TYPE.name));
		semmct005Bean.setGlAccSearch(new GLAccount());
		semmct005Bean.setGlAccount(new GLAccount());
		semmct005Bean.setGlTypeList(getLovItemsByType(ELovType.T_CT_GL_TYPE.name));
		semmct005Bean.setStatusListForGL(semmct005Bean.getGlTypeList());
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	public SEMMCT005Bean getSemmct005Bean() {
		return (SEMMCT005Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmct005Bean");
	}

	public void setSemmct005Bean(SEMMCT005Bean semmct005Bean) {
		this.semmct005Bean = semmct005Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmct005Bean", semmct005Bean);
	}
	
	public boolean doSearch(){
		boolean flag = false;
		IGLAccountService glAccService = (IGLAccountService)getBean("glAccountService"); 
		List<GLAccount> glAccList = null;
		SEMMCT005Bean semmct005Bean =  getSemmct005Bean();
		if(validateBeforeSearch()){
			semmct005Bean.setRenderedMsgFormSearch(true);
			return flag;
		}
		
		try {
			semmct005Bean.setGlAccList(new ArrayList<WrapperBeanObject<GLAccount>>());
			glAccList = glAccService.searchGLAccountByCriteria(semmct005Bean.getGlAccSearch());
			if(glAccList.isEmpty()){
				semmct005Bean.setRenderedMsgDataNotFound(true);
			}else{
				for(GLAccount acc : glAccList){
					WrapperBeanObject<GLAccount> wgl = new WrapperBeanObject<GLAccount>();
					acc.setEffectiveDate(convertYearENtoTH(acc.getEffectiveDate()));
					acc.setCreateDt(convertYearENtoTH(acc.getCreateDt()));
					acc.setUpdateDt(convertYearENtoTH(acc.getUpdateDt()));
					// convert status to display word
					if(STATUS_YES.equals(acc.getRecordStatus())){
						acc.setRecordStatus(msg("massage.normal"));
					}else{
						if(STATUS_NO.equals(acc.getRecordStatus())){
							acc.setRecordStatus(msg("massage.cancel"));
						}else{
							acc.setRecordStatus(msg("Unknown"));
						}
					}
					// convert expense to display word
						acc.setExpenseType(getNameFromSelectItemList(acc.getExpenseType(),semmct005Bean.getExpenseList()));
						acc.setPlaceType(getNameFromSelectItemList(acc.getPlaceType(),semmct005Bean.getPlaceTypeList()));
					
					acc.getRecordStatus();
					wgl.setDataObj(acc);
					semmct005Bean.getGlAccList().add(wgl);
				}
				semmct005Bean.setRenderedMsgFormSearch(false);
				semmct005Bean.setRenderedMsgDataNotFound(false);
			}
			setSemmct005Bean(semmct005Bean);
		} catch (DAOException e) {
			e.printStackTrace();
		}

		return flag;
	}
	
	private boolean pageLoad() {
		boolean flag = true;
		IGLAccountService glAccService = (IGLAccountService)getBean("glAccountService"); 
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		String id = (String)getFacesUtils().getRequestParameter("glId");
		SEMMCT005Bean semmct005Bean =  getSemmct005Bean();
		try {
			if(mode != null) {
				if(MODE_ADD.equals(mode)){
					doCreate();
				}else{
						if(MODE_VIEW.equals(mode)){
							semmct005Bean.setEditMode(false);
							semmct005Bean.setViewMode(true);
						}else{
							if(MODE_EDIT.equals(mode)){
								semmct005Bean.setViewMode(false);
								semmct005Bean.setEditMode(true);
							}
						}
						semmct005Bean.setGlAccount(glAccService.searchGLAccountById(id).get(0));
				}
				semmct005Bean.setRenderedMsgFormCreate(false);
			}
			setSemmct005Bean(semmct005Bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean doCreate(){
		SEMMCT005Bean semmct005Bean =  getSemmct005Bean();
		semmct005Bean.setGlAccount(new GLAccount());
		semmct005Bean.setViewMode(false);
		semmct005Bean.setEditMode(false);
		setSemmct005Bean(semmct005Bean);
		return true;
	}
	
	public boolean doClear(){
		SEMMCT005Bean semmct005Bean =  getSemmct005Bean();
		semmct005Bean.resetData();
		semmct005Bean.setGlAccSearch(new GLAccount());
		semmct005Bean.setRenderedMsgFormCreate(false);
		setSemmct005Bean(semmct005Bean);
		return false;
	}
	
	
	public boolean doSave(){
		boolean flag = false;
		IGLAccountService glAccService = (IGLAccountService)getBean("glAccountService"); 
		SEMMCT005Bean semmct005Bean =  getSemmct005Bean();
		if(validateBeforeSave()){
			semmct005Bean.setRenderedMsgFormCreate(true);
			return flag;
		}
		try {
			semmct005Bean.getGlAccount().setCurrentUser(semmct005Bean.getUserLogin());
			if(!semmct005Bean.isEditMode()){
				semmct005Bean.getGlAccount().setCreateDt(new Date());
				semmct005Bean.getGlAccount().setUpdateDt(new Date());
				semmct005Bean.setGlAccount(glAccService.createGLAccount(semmct005Bean.getGlAccount()));
				semmct005Bean.setEditMode(true);
				addMessageInfo("M0001");
			}else{
				semmct005Bean.getGlAccount().setUpdateDt(new Date());
				glAccService.updateGLAccount(semmct005Bean.getGlAccount());
				addMessageInfo("M0001");
			}
		} catch (DAOException e) {
			addMessageError("E0001");
			e.printStackTrace();
		}finally{
			semmct005Bean.setRenderedMsgFormCreate(true);
			setSemmct005Bean(semmct005Bean);
		}

		return flag;
	}
	
	public boolean goBack(){
		SEMMCT005Bean semmct005Bean =  getSemmct005Bean();
		semmct005Bean.setEditMode(false);
		semmct005Bean.setViewMode(false);
		setSemmct005Bean(semmct005Bean);
		doSearch();
		return true;
	}
	
	public boolean validateBeforeSave(){
		boolean flag = false;
		
		if(StringUtils.isEmpty(getSemmct005Bean().getGlAccount().getCompany())){
			addMessageError("W0001", msg("message.company"));
			flag = true;
		}
		
		if(StringUtils.isEmpty(getSemmct005Bean().getGlAccount().getGlAccount())){
			addMessageError("W0001", msg("message.glAccount"));
			flag = true;
		}
		
		if(StringUtils.isEmpty(getSemmct005Bean().getGlAccount().getExpenseType())){
			addMessageError("W0001", msg("message.expenseType"));
			flag = true;
		}
		
		if(StringUtils.isEmpty(getSemmct005Bean().getGlAccount().getRecordStatus())){
			addMessageError("W0001", msg("message.recStatus"));
			flag = true;
		}
			
		return flag;
	}
	
	public boolean doDelete() throws DAOException{
		IGLAccountService glAccService = (IGLAccountService)getBean("glAccountService"); 
		//do Delete
		glAccService.deleteGLAccountByCriteria(getSemmct005Bean().getGlAccount());
		//select new item again
		doSearch();
		return false;
	}

	public boolean initDel() throws DAOException{
		SEMMCT005Bean semmct005Bean =  getSemmct005Bean();
		IGLAccountService glAccService = (IGLAccountService)getBean("glAccountService"); 
		String id = (String)getFacesUtils().getRequestParameter("glId");
		semmct005Bean.setGlAccount(glAccService.searchGLAccountById(id).get(0));
		setSemmct005Bean(semmct005Bean);
		return false; 
	}
	
	public boolean validateBeforeSearch(){
		boolean flag = false;
		if(StringUtils.isEmpty(getSemmct005Bean().getGlAccSearch().getCompany())){
			addMessageError("W0001", msg("message.company"));
			flag = true;
		}

		return flag;
	}
	
	private String getNameFromSelectItemList(String id, List<SelectItem> itemList){
		for(SelectItem item:itemList){
			if(item.getValue().equals(id)){
				return item.getLabel();
			}
		}
		return null;
	}
	public String getComfirmMsg(){
		return MSGCacheUtil.getInstance().getMessageByCode("Q0001");
	}
}
