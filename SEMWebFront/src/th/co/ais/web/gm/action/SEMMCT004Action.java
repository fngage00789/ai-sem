package th.co.ais.web.gm.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.gm.CostCenter;
import th.co.ais.service.gm.ICostCenterService;
import th.co.ais.util.ELovType;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.gm.bean.SEMMCT004Bean;
import th.co.ais.web.util.CompanyCacheUtil;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;

public class SEMMCT004Action extends AbstractAction{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String STATUS_YES = "Y";
	private static final String STATUS_NO = "N";
	private static final String MODE_EDIT = "EDIT";
	private static final String MODE_VIEW = "VIEW";
	private static final String MODE_ADD = "ADD";
	
	private Logger LOG = Logger.getLogger(getClass());
	
	SEMMCT004Bean semmct004Bean;
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		LOG.debug("CT004--action NAV");
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
		LOG.debug("CT004--init");
		SEMMCT004Bean semmct004Bean = new SEMMCT004Bean();
		setSemmct004Bean(semmct004Bean);
		semmct004Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmct004Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		semmct004Bean.setCostCenterSearch(new CostCenter());
		semmct004Bean.setCostCenter(new CostCenter());
	}

	public boolean doSearch(){
		boolean flag = false;
		ICostCenterService costCenterService = (ICostCenterService)getBean("costCenterService"); 
		List<CostCenter> costCenterList = null;
		SEMMCT004Bean semmct004Bean =  getSemmct004Bean();
		
		if(validateBeforeSearch()){
			semmct004Bean.setRenderedMsgFormSearch(true);
			return flag;
		}
		
		try {
			semmct004Bean.setCostCenterList(new ArrayList<WrapperBeanObject<CostCenter>>());
			costCenterList = costCenterService.searchCostCenterByCriteria(semmct004Bean.getCostCenterSearch());
			if(costCenterList.isEmpty()){
				semmct004Bean.setRenderedMsgDataNotFound(true);
			}else{
				for(CostCenter cost : costCenterList){
					WrapperBeanObject<CostCenter> wCost = new WrapperBeanObject<CostCenter>();
					cost.setEffectiveDate(convertYearENtoTH(cost.getEffectiveDate()));
					cost.setCreateDt(convertYearENtoTH(cost.getCreateDt()));
					cost.setUpdateDt(convertYearENtoTH(cost.getUpdateDt()));
					if(STATUS_YES.equals(cost.getRecordStatus())){
						cost.setRecordStatus(msg("massage.normal"));
					}else{
						if(STATUS_NO.equals(cost.getRecordStatus())){
							cost.setRecordStatus(msg("massage.cancel"));
						}else{
							cost.setRecordStatus(msg("Unknown"));
						}
					}
					
					cost.getRecordStatus();
					wCost.setDataObj(cost);
					semmct004Bean.getCostCenterList().add(wCost);
				}
				semmct004Bean.setRenderedMsgFormSearch(false);
				semmct004Bean.setRenderedMsgDataNotFound(false);
			}
			setSemmct004Bean(semmct004Bean);
		} catch (DAOException e) {
			e.printStackTrace();
		}

		return flag;
	}
	
	private boolean pageLoad() {
		boolean flag = true;
		ICostCenterService costCenterService = (ICostCenterService)getBean("costCenterService"); 
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		String id = (String)getFacesUtils().getRequestParameter("costId");
		SEMMCT004Bean semmct004Bean =  getSemmct004Bean();
		try {
			if(mode != null) {
				if(MODE_ADD.equals(mode)){
					doCreate();
				}else{
						if(MODE_VIEW.equals(mode)){
							semmct004Bean.setEditMode(false);
							semmct004Bean.setViewMode(true);
						}else{
							if(MODE_EDIT.equals(mode)){
								semmct004Bean.setViewMode(false);
								semmct004Bean.setEditMode(true);
							}
						}
						semmct004Bean.setCostCenter(costCenterService.searchCostCenterById(id).get(0));
				}
				semmct004Bean.setRenderedMsgFormCreate(false);
			}
			setSemmct004Bean(semmct004Bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean doCreate(){
		SEMMCT004Bean semmct004Bean =  getSemmct004Bean();
		semmct004Bean.setCostCenter(new CostCenter());
		semmct004Bean.setViewMode(false);
		semmct004Bean.setEditMode(false);
		setSemmct004Bean(semmct004Bean);
		return true;
	}
	
	public boolean doClear(){
		SEMMCT004Bean semmct004Bean =  getSemmct004Bean();
		semmct004Bean.resetData();
		semmct004Bean.setCostCenterSearch(new CostCenter());
		semmct004Bean.setRenderedMsgFormCreate(false);
		setSemmct004Bean(semmct004Bean);
		return false;
	}
	
	
	public boolean doSave(){
		boolean flag = false;
		ICostCenterService costCenterService = (ICostCenterService)getBean("costCenterService"); 
		SEMMCT004Bean semmct004Bean =  getSemmct004Bean();
		if(validateBeforeSave()){
			semmct004Bean.setRenderedMsgFormCreate(true);
			return flag;
		}
		try {
			semmct004Bean.getCostCenter().setCurrentUser(semmct004Bean.getUserLogin());
			if(!semmct004Bean.isEditMode()){
				semmct004Bean.getCostCenter().setCreateDt(new Date());
				semmct004Bean.getCostCenter().setUpdateDt(new Date());
				semmct004Bean.setCostCenter(costCenterService.createCostCenter(semmct004Bean.getCostCenter()));
				semmct004Bean.setEditMode(true);
				addMessageInfo("M0001");
			}else{
				semmct004Bean.getCostCenter().setUpdateDt(new Date());
				costCenterService.updateCostCenter(semmct004Bean.getCostCenter());
				addMessageInfo("M0001");
			}
		} catch (DAOException e) {
			addMessageError("E0001");
			e.printStackTrace();
		}finally{
			semmct004Bean.setRenderedMsgFormCreate(true);
			setSemmct004Bean(semmct004Bean);
		}

		return flag;
	}
	
	public boolean goBack(){
		SEMMCT004Bean semmct004Bean =  getSemmct004Bean();
		semmct004Bean.setEditMode(false);
		semmct004Bean.setViewMode(false);
		setSemmct004Bean(semmct004Bean);
		doSearch();
		return true;
	}
	
	@Override
	public boolean validate() {
		
		return false;
	}

	public SEMMCT004Bean getSemmct004Bean() {
		return (SEMMCT004Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmct004Bean");
	}

	public void setSemmct004Bean(SEMMCT004Bean semmct004Bean) {
		this.semmct004Bean = semmct004Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmct004Bean", semmct004Bean);
	}
	
	public boolean validateBeforeSearch(){
		if(StringUtils.isEmpty(getSemmct004Bean().getCostCenterSearch().getCompany())){
			addMessageError("W0001", msg("message.company"));
			return true;
		}
		
		return false;
	}
	
	public boolean validateBeforeSave(){
		boolean flag = false;
		
		if(StringUtils.isEmpty(getSemmct004Bean().getCostCenter().getCompany())){
			addMessageError("W0001", msg("message.company"));
			flag = true;
		}
		
		if(StringUtils.isEmpty(getSemmct004Bean().getCostCenter().getCostCenter())){
			addMessageError("W0001", msg("message.costCenter"));
			flag = true;
		}
		
		if(getSemmct004Bean().getCostCenter().getEffectiveDate() == null){
			addMessageError("W0001", msg("message.effectiveDt"));
			flag = true;
		}
		
		if(StringUtils.isEmpty(getSemmct004Bean().getCostCenter().getRecordStatus())){
			addMessageError("W0001", msg("message.recStatus"));
			flag = true;
		}
			
		return flag;
	}
	
	public boolean doDelete() throws DAOException{
		ICostCenterService costCenterService = (ICostCenterService)getBean("costCenterService"); 
		//do Delete
		costCenterService.deleteCostCenterByCriteria(getSemmct004Bean().getCostCenter());
		//select new item again
		doSearch();
		return false;
	}

	public boolean initDel() throws DAOException{
		ICostCenterService costCenterService = (ICostCenterService)getBean("costCenterService"); 
		SEMMCT004Bean semmct004Bean =  getSemmct004Bean();
		String id = (String)getFacesUtils().getRequestParameter("costId");
		semmct004Bean.setCostCenter(costCenterService.searchCostCenterById(id).get(0));
		setSemmct004Bean(semmct004Bean);
		return false; 
	}
	
	public String getComfirmMsg(){
		return MSGCacheUtil.getInstance().getMessageByCode("Q0001");
	}
}
