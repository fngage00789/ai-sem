package th.co.ais.web.ac.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.ac.Mac001Srch;
import th.co.ais.domain.sap.SapTrxLog;
import th.co.ais.domain.sap.SapTrxLogSrch;
import th.co.ais.service.sap.ISAPService;
import th.co.ais.util.ELovType;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.ac.bean.SEMMAC002Bean;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.util.CompanyCacheUtil;

public class SEMMAC002Action extends AbstractAction {

	private Logger log = Logger.getLogger(getClass());
	
	private ISAPService getSAPService(){ return (ISAPService)getBean("sapService");}
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("pageLoad")){
			flag = pageLoad();
		}else if(methodWithNavi.equalsIgnoreCase("doBack")){
			flag = doBack();
		}else if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		}else if(methodWithNavi.equalsIgnoreCase("doDefaultDate")){
			flag = doDefaultDate();
		}else if (methodWithNavi.equalsIgnoreCase("doClearSession")) {
			flag = doClearSession();
		}else if (methodWithNavi.equalsIgnoreCase("doRegenerate")) {
			flag = doRegenerate();
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {		
		SEMMAC002Bean semmac002Bean = new SEMMAC002Bean();
		semmac002Bean.setCompanyList(CompanyCacheUtil.getInstance().getCompanySelItemsByRole());
		semmac002Bean.setSapStatusList(getLovItemsByType(ELovType.T_SAP_TRX_LOG.name,EX_IN,"STATUS",null,null));
		semmac002Bean.setSapTrxLogSrch(new SapTrxLogSrch());
		semmac002Bean.setSapTrxLogSrchList(new ArrayList<WrapperBeanObject<SapTrxLog>>());
		semmac002Bean.setDisabledBtnRegenerate(true);
		setSemmac002Bean(semmac002Bean);
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	private SEMMAC002Bean semmac002Bean;	
	public SEMMAC002Bean getSemmac002Bean() { return (SEMMAC002Bean)getFacesUtils().getSessionMapValue("semmac002Bean");	}
	public void setSemmac002Bean(SEMMAC002Bean semmac002Bean) {
		this.semmac002Bean = semmac002Bean;
		getFacesUtils().setSessionMapValue("semmac002Bean", semmac002Bean);
	}
	
	public boolean pageLoad(){
		boolean flag = true;
		/*semmac002Bean  = getSemmac001Bean();
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		List<Mac001SrchD> to = null;
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		try {
			semmac002Bean.getSapTrxLogSrch().setRowId(rowId);						
			setSemmac001Bean(semmac002Bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return flag;
	}
	
	public boolean doBack(){
		boolean flag = true;

		return flag;
	}
	
	public boolean doSearch(){
		boolean flag = false;
		semmac002Bean = getSemmac002Bean();
		semmac002Bean.setRenderedMsgFormSearch(true);
		if(!validateSearch()){
			return flag;
		}
		ISAPService sapService = getSAPService();
		List<SapTrxLog> sapTrxLogSrch;
		semmac002Bean.setSapTrxLogSrchList(new ArrayList<WrapperBeanObject<SapTrxLog>>());
		try {
			SapTrxLogSrch param = getSemmac002Bean().getSapTrxLogSrch();
			param.setLoadChild(true);
			sapTrxLogSrch = sapService.querySapTrxLog(param);
			if(null==sapTrxLogSrch || sapTrxLogSrch.size()==0){
				addMessageError("M0004");
			}else{
				for(SapTrxLog log : sapTrxLogSrch){
					log.setDisableCheckBox(!"FAIL".equals(log.getStatus()));
					WrapperBeanObject<SapTrxLog> tmpWrapLog = new WrapperBeanObject<SapTrxLog>();
					tmpWrapLog.setDataObj(log);
					tmpWrapLog.setCheckBox(false);
					tmpWrapLog.setMessage("");
					semmac002Bean.getSapTrxLogSrchList().add(tmpWrapLog);
				}				
				semmac002Bean.setDisabledBtnRegenerate(false);								
			}
			semmac002Bean.setRenderedMsgDataNotFound(true);
			setSemmac002Bean(semmac002Bean);
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError(("E0004"));
		}
		return flag;
	}
	
	private boolean doDefaultDate(){
		boolean flagValid = false;
		semmac002Bean  = getSemmac002Bean();
		SapTrxLogSrch param = semmac002Bean.getSapTrxLogSrch();
		if(param.getCreateDtFrom() != null){
			log.info("createDtFrom :" + param.getCreateDtFrom());
			semmac002Bean.getSapTrxLogSrch().setCreateDtFrom(param.getCreateDtFrom());
			flagValid = false;
		}
		if(param.getCreateDtTo() != null){
			log.info("createDtTo :" + param.getCreateDtTo());
			semmac002Bean.getSapTrxLogSrch().setCreateDtTo(param.getCreateDtTo());
			flagValid = false;
		}
		if(param.getUpdateDtFrom() != null){
			log.info("updateDtFrom :" + param.getUpdateDtFrom());
			semmac002Bean.getSapTrxLogSrch().setUpdateDtFrom(param.getUpdateDtFrom());
			flagValid = false;
		}
		if(param.getUpdateDtTo() != null){
			log.info("updateDtTo :" + param.getUpdateDtTo());
			semmac002Bean.getSapTrxLogSrch().setUpdateDtTo(param.getUpdateDtTo());
			flagValid = false;
		}
		setSemmac002Bean(semmac002Bean);
		return flagValid; 
	}
	
	private boolean validateSearch() {
		boolean flagValid = true;
		if(StringUtils.isEmpty(getSemmac002Bean().getSapTrxLogSrch().getCompany())){
			addMessageError("W0001", msg("message.company"));
			flagValid = false;
		}
		SapTrxLogSrch param = getSemmac002Bean().getSapTrxLogSrch();
		try{
			log.info("createDtFrom" + param.getCreateDtFrom());
			log.info("createDtTo" + param.getCreateDtTo());
			log.info("updateDtFrom" + param.getUpdateDtFrom());
			log.info("updateDtTo" + param.getUpdateDtTo());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(StringUtils.isNotEmpty(param.getFileName().trim())){
			param.setFileName(param.getFileName().trim());
			param.setFileName("%".concat(param.getFileName()).concat("%"));	
		}					
		if(StringUtils.isNotEmpty(param.getCreateBy().trim())){
			param.setCreateBy(param.getCreateBy().trim());
			param.setCreateBy("%".concat(param.getCreateBy()).concat("%"));	
		}
		if(StringUtils.isNotEmpty(param.getUpdateBy().trim())){
			param.setUpdateBy(param.getUpdateBy().trim());
			param.setUpdateBy("%".concat(param.getUpdateBy()).concat("%"));
		}					
		if(param.getCreateDtFrom() != null && param.getCreateDtTo() != null){
			if(param.getCreateDtFrom().after(param.getCreateDtTo())){
				addMessageErrorWithArgument("W0006" ,msg("message.createDtFrom"), msg("massage.dateTo"));
				flagValid = false;
			}
		}
		if(param.getUpdateDtFrom() != null && param.getUpdateDtTo() != null){
			if(param.getUpdateDtFrom().after(param.getUpdateDtTo())){
				addMessageErrorWithArgument("W0006" ,msg("message.updateDtFrom"), msg("massage.dateTo"));
				flagValid = false;
			}
		}
		return flagValid;
	}
	
	public boolean doClearSession(){
		boolean flagValid = false;
		semmac002Bean = getSemmac002Bean();
		semmac002Bean.setSapTrxLogSrch(new SapTrxLogSrch());
		semmac002Bean.setDisabledBtnRegenerate(true);		
		setSemmac002Bean(semmac002Bean);
		return flagValid;
	}
	
	public void selectAllRow(){
		try{
			boolean chkAll = getSemmac002Bean().isChkSelAll();
			for(WrapperBeanObject<SapTrxLog> wrapLog : getSemmac002Bean().getSapTrxLogSrchList()){
				SapTrxLog log = (SapTrxLog)wrapLog.getDataObj();
				if(!log.isDisableCheckBox()){
					wrapLog.setCheckBox(chkAll);	
				}				
			}
			onRenderAddButton();
		}catch(NullPointerException ne){
			ne.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// Method render Button onclick checkBox 
	public void onRenderAddButton(){
		semmac002Bean  = getSemmac002Bean();
		semmac002Bean.setDisabledBtnRegenerate(true);
		for(WrapperBeanObject<SapTrxLog> log : semmac002Bean.getSapTrxLogSrchList()){
			if(log.isCheckBox()){
				semmac002Bean.setDisabledBtnRegenerate(false);
				break;
			}
		}
		setSemmac002Bean(semmac002Bean);
	}
	
	public boolean doRegenerate(){
		boolean flagValid = false;
		semmac002Bean = getSemmac002Bean();
		ISAPService sapService = (ISAPService)getBean("sapService");
		try {
			//sapService.regenerateTransactionToSAP(semmac002Bean.getSapTrxLogSrchList(), getEmployee());
			
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("E0001");
		}		
		return flagValid;
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		semmac002Bean = getSemmac002Bean();
		semmac002Bean.setTmpRowId(rowId);		
		
		//binarySearch 4 selected Log 
		List<WrapperBeanObject<SapTrxLog>> logList = semmac002Bean.getSapTrxLogSrchList();
		Comparator<WrapperBeanObject<SapTrxLog>> c = new Comparator<WrapperBeanObject<SapTrxLog>>() {
	      public int compare(WrapperBeanObject<SapTrxLog> c1, WrapperBeanObject<SapTrxLog> c2) {
	    	  SapTrxLog log1 = (SapTrxLog)c1.getDataObj();
	    	  SapTrxLog log2 = (SapTrxLog)c2.getDataObj();
	    	  return log1.getRowId().compareTo(log2.getRowId());
	      }
		};
		WrapperBeanObject<SapTrxLog> key = new WrapperBeanObject<SapTrxLog>();
		SapTrxLog logKey = new SapTrxLog();
		logKey.setRowId(rowId);
		key.setDataObj(logKey);
		int index = Collections.binarySearch(logList, key, c);
		if(index>-1){
			SapTrxLog logFound = (SapTrxLog)logList.get(index).getDataObj();
			semmac002Bean.setSapTrxLogSelected(logFound);
		}		
		setSemmac002Bean(semmac002Bean);
	}
}
