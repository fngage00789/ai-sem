package th.co.ais.web.co.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.co.ContractStatus;
import th.co.ais.domain.co.Mco001CheckAddAbleSP;
import th.co.ais.domain.co.Mco001SeqStatusSP;
import th.co.ais.domain.co.Mco001SrchLovStatusSP;
import th.co.ais.domain.co.Mco001SrchStatusSP;
import th.co.ais.domain.co.Mco001UpdateStatusSP;
import th.co.ais.domain.co.Mco002CheckNoFileSP;
import th.co.ais.domain.co.Mco002UpdateContractStatusSP;
import th.co.ais.domain.co.Mco004SrchLovStatusSP;
import th.co.ais.domain.co.Mco004SrchStatusSP;
import th.co.ais.domain.co.Mco005UpdateContractStatusSP;
import th.co.ais.domain.gm.LovMaster;
import th.co.ais.domain.si.Contract;
import th.co.ais.domain.si.SiteInfo;
import th.co.ais.service.co.IContractStatusService;
import th.co.ais.service.gm.ILovMasterService;
import th.co.ais.service.si.ISiteContractService;
import th.co.ais.service.si.ISiteInfoService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.co.bean.SEMMCO005Bean;
import th.co.ais.web.co.bean.SEMMCO005Tab1Bean;
import th.co.ais.web.util.FacesUtils;

public class SEMMCO005Tab1Action extends AbstractAction{

	private static final long serialVersionUID = 5934806069385322547L;

	private Logger log = Logger.getLogger(getClass());
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		
		if(methodWithNavi.equalsIgnoreCase("initDeleteContractStatusHistory")){
			flag = initDeleteContractStatusHistory();
		}
		if(methodWithNavi.equalsIgnoreCase("initUpdateContractStatusHistory")){
			flag = initUpdateContractStatusHistory();
		}
		if(methodWithNavi.equalsIgnoreCase("doAddContractStatusHistory")){
			flag = doAddContractStatusHistory();
		}
		if(methodWithNavi.equalsIgnoreCase("doUpdateContractStatusHistory")){
			flag = doUpdateContractStatusHistory();
		}
		if(methodWithNavi.equalsIgnoreCase("doClearContractStatusHistory")){
			flag = doClearContractStatusHistory();
		}
		if(methodWithNavi.equalsIgnoreCase("doDeleteContractStatusHistory")){
			flag = doDeleteContractStatusHistory();
		}
		
		return flag;
	}
	
	private boolean doDeleteContractStatusHistory() {
		boolean flag = false;
		semmco005tab1Bean = getSemmco005tab1Bean();
		semmco005Bean = getSemmco005Bean();
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		try{
			if(semmco005tab1Bean.getContractStatus() != null){
				service.deleteContractStatus(semmco005tab1Bean.getContractStatus());
				addMessageInfo("M0002");
				// update site contract
				this.updateSiteContract();
				// clear data
				this.doClearContractStatusHistory();
				// do search contract status history
				this.searchContractStatusHistory();
				// get drop down contractStatusList
				this.getContractStatusListByContractId();
			}
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0002");
		}
		semmco005Bean.setRenderedMsgFormTop(false);
		semmco005tab1Bean.setRenderedMsgFormMiddle(true);
		setSemmco005Bean(semmco005Bean);
		setSemmco005tab1Bean(semmco005tab1Bean);
		return flag;
	}
	
	private boolean doUpdateContractStatusHistory() {
		boolean flag = false;
		semmco005tab1Bean = getSemmco005tab1Bean();
		semmco005Bean = getSemmco005Bean();
		if(!validateUpdateContractStatus()){
			semmco005Bean.setRenderedMsgFormTop(false);
			semmco005tab1Bean.setRenderedMsgFormMiddle(true);
			setSemmco005Bean(semmco005Bean);
			setSemmco005tab1Bean(semmco005tab1Bean);
			return flag;
		}
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			semmco005tab1Bean.getContractStatus().setCurrentUser(semmco005tab1Bean.getUserLogin());
			semmco005tab1Bean.setContractStatus(service.updateContractStatus(semmco005tab1Bean.getContractStatus()));
			addMessageInfo("M0001");
			// update site contract
			this.updateSiteContract();
			// do search contract status history
			this.searchContractStatusHistory();
			this.doClearContractStatusHistory();
			// get drop down contractStatusList
			this.getContractStatusListByContractId();
		}catch(Exception e){
			e.printStackTrace();
		}
		semmco005Bean.setChkContractLost(false);
		semmco005Bean.setRenderedMsgFormTop(false);
		semmco005tab1Bean.setRenderedMsgFormMiddle(true);
		setSemmco005Bean(semmco005Bean);
		setSemmco005tab1Bean(semmco005tab1Bean);
		return flag;
	}
	/* OLD
	private boolean doAddContractStatusHistory() {
		boolean flag = false;
		semmco005tab1Bean = getSemmco005tab1Bean();
		semmco005Bean = getSemmco005Bean();
		if(!validateUpdateContractStatus()){
			semmco005Bean.setRenderedMsgFormTop(false);
			semmco005tab1Bean.setRenderedMsgFormMiddle(true);
			setSemmco005Bean(semmco005Bean);
			setSemmco005tab1Bean(semmco005tab1Bean);
			return flag;
		}
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		// add contract status
		try{
			semmco005tab1Bean.getContractStatus().setContractId(getSemmco005Bean().getContractIdParam());
			semmco005tab1Bean.getContractStatus().setCurrentUser(semmco005tab1Bean.getUserLogin());
			semmco005tab1Bean.getContractStatus().setSeqNo(this.getContractStatusSeqNo());
			semmco005tab1Bean.setContractStatus(service.createContractStatus(semmco005tab1Bean.getContractStatus()));
			addMessageInfo("M0001");
			// update site contract 
			this.updateSiteContract();
			// do search contract status history
			this.searchContractStatusHistory();
			this.doClearContractStatusHistory();
			// get drop down contractStatusList
			this.getContractStatusListByContractId();
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		semmco005Bean.setRenderedMsgFormTop(false);
		semmco005tab1Bean.setRenderedMsgFormMiddle(true);
		setSemmco005Bean(semmco005Bean);
		setSemmco005tab1Bean(semmco005tab1Bean);
		return flag;
	}
	*/
	private boolean doAddContractStatusHistory() {
		boolean flag = false;
		semmco005tab1Bean = getSemmco005tab1Bean();
		semmco005Bean = getSemmco005Bean();
		if(!validateUpdateContractStatus()){
			semmco005Bean.setRenderedMsgFormTop(false);
			semmco005tab1Bean.setRenderedMsgFormMiddle(true);
			setSemmco005Bean(semmco005Bean);
			setSemmco005tab1Bean(semmco005tab1Bean);
			return flag;
		}
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		// add contract status
		try{
			List<Mco005UpdateContractStatusSP> to = null;
			Mco005UpdateContractStatusSP contract = new Mco005UpdateContractStatusSP();
			contract.setContractId(semmco005Bean.getContractIdParam());
			contract.setContractStatus(semmco005tab1Bean.getContractStatus().getContractStatus());
			contract.setChangeStatusDate(semmco005tab1Bean.getContractStatus().getChangeStatusDt());
			contract.setRemark(semmco005tab1Bean.getContractStatus().getRemark());
			contract.setCurrentUser(semmco005tab1Bean.getUserLogin());
			contract.setCompany(semmco005Bean.getCompanyParam());
			//Adding by mr.John from (mr.Surasit) 27/04/2011
			contract.setReceivePersonCode(semmco005tab1Bean.getContract().getReceivePersonCode());
			contract.setCreatePersonCode(semmco005tab1Bean.getContract().getCreatePersonCode());
			contract.setGroupNo(semmco005Bean.getGroupNo());
			to = service.querySPList(EQueryName.SP_MCO005_UPD_STATUS_LIST.name, contract);
				
			if(to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")){
				addMessageInfo("M0001");
			}
		
			// do search contract status history
			this.searchContractStatusHistory();
			this.doClearContractStatusHistory();
			// get drop down contractStatusList
			this.getContractStatusListByContractId();
			// reRender duty
			this.getContractByRowId();
			
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		semmco005Bean.setChkContractLost(false);
		semmco005Bean.setRenderedMsgFormTop(false);
		semmco005tab1Bean.setRenderedMsgFormMiddle(true);
		setSemmco005Bean(semmco005Bean);
		setSemmco005tab1Bean(semmco005tab1Bean);
		return flag;
	}
	private Integer getContractStatusSeqNo() {
		// SEM_SP_MCO001_SEQ_STATUS (parameter = contractId)
		semmco005tab1Bean = getSemmco005tab1Bean();
		ISiteContractService service = (ISiteContractService)getBean("siteContractService");
		List<Mco001SeqStatusSP> to = null;
		Integer seqNo = 0;
		try{
			Mco001SeqStatusSP criteria = new Mco001SeqStatusSP();
			criteria.setRowId(getSemmco005Bean().getContractIdParam());
			to = service.querySPList(EQueryName.SP_MCO001_SEQ_STATUS.name, criteria);
			if(to != null && to.size() > 0){
				seqNo = Integer.parseInt(to.get(0).getSeqNo());
				log.debug("seqNo contract status [" + seqNo + "]");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return seqNo;
	}
	
	private void updateSiteContract() {
		semmco005tab1Bean = getSemmco005tab1Bean();
		List<Mco001UpdateStatusSP> to = null;
		try{
			ISiteContractService service = (ISiteContractService)getBean("siteContractService");
			Mco001UpdateStatusSP status = new Mco001UpdateStatusSP();
			status.setContractId(getSemmco005Bean().getContractIdParam());
			status.setCurrentUser(semmco005tab1Bean.getUserLogin());
			status.setCurrentUser(semmco005Bean.getGroupNo());
			to = service.querySPList(EQueryName.SP_MCO001_UPD_STATUS.name, status);
			if(to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")){
				log.debug("update site contract result [" + to.get(0).getResultMsg() + "]");
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco005tab1Bean(semmco005tab1Bean);
		
	}

	private boolean initUpdateContractStatusHistory() {
		boolean flag = false;
		semmco005tab1Bean = getSemmco005tab1Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		ISiteContractService conService = (ISiteContractService)getBean("siteContractService");
		try{
			if(rowId != null){
				semmco005tab1Bean.setContractStatus(service.queryContractStatusByRowId(rowId));
				semmco005tab1Bean.setContract(conService.queryContractByRowId(getSemmco005Bean().getContractIdParam()));
				semmco005tab1Bean.setDisabledBtnAddContractStatusHistory(true);
				semmco005tab1Bean.setDisabledBtnUpdateContractStatusHistory(false);
				semmco005tab1Bean.setRenderedAddHistory(true);
				this.updateContractStatusList(rowId);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		setSemmco005tab1Bean(semmco005tab1Bean);
		return flag;
	}
	private void updateContractStatusList(String rowId) {
		semmco005Bean = getSemmco005Bean();
		List<Mco004SrchLovStatusSP> to = null;
		List<SelectItem> selList = new LinkedList<SelectItem>();
		SelectItem selItem = null;
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			Mco004SrchLovStatusSP criteria = new Mco004SrchLovStatusSP();
			criteria.setContractId(semmco005Bean.getContractIdParam());
			criteria.setContractStatusId(rowId);
			to = service.querySPList(EQueryName.SP_MCO004_SRCH_LOV_STATUS.name, criteria);
			selItem = new SelectItem("" , msg("value.selectItem"));
			selList.add(selItem);
			if(to != null && to.size() > 0){
				for (Mco004SrchLovStatusSP lov : to) {
					selItem = new SelectItem();
					selItem.setLabel(lov.getLovName());
					selItem.setValue(lov.getLovCode());
					selList.add(selItem);
				}
				semmco005Bean.setContractStatusTab1List(selList);
			}else{
				semmco005Bean.setContractStatusTab1List(getEmptyDropDown());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco005Bean(semmco005Bean);
		
	}

	private boolean initDeleteContractStatusHistory() {
		boolean flag = false;
		semmco005tab1Bean = getSemmco005tab1Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		try{
			if(rowId != null){
				semmco005tab1Bean.setContractStatus(service.queryContractStatusByRowId(rowId));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco005tab1Bean(semmco005tab1Bean);
		return flag;
	}
	
	private boolean validateUpdateContractStatus() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemmco005tab1Bean().getContractStatus().getContractStatus())){
			addMessageError("W0001", msg("message.contractStatus"));
			flgValid = false;
		}else{
			// contract status = 03 (send legal) call SP_MCO002_CHK_NO_FILE
			if(getSemmco005tab1Bean().getContractStatus().getContractStatus().equals("03")){
				if(!checkNoFile()){
					flgValid = false;
				}
			}
		}
		
		if(getSemmco005tab1Bean().getContractStatus().getChangeStatusDt() == null){
			addMessageError("W0001", msg("message.changeStatusDt"));
			flgValid = false;
		}
		
		return flgValid;
	}
	
	private boolean checkNoFile() {
		boolean flgValid = true;
		try{
			List<Mco002CheckNoFileSP> fileList = null;
			Mco002CheckNoFileSP criteria = new Mco002CheckNoFileSP();
			criteria.setContractId(getSemmco005Bean().getContractIdParam());
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			fileList = service.querySPList(EQueryName.SP_MCO002_CHK_NO_FILE.name, criteria);
			if(fileList != null && fileList.size() > 0){
				if(fileList.get(0).getContractNo() != null){
					addMessageErrorWithArgument("W0088" ,fileList.get(0).getContractNo());
					flgValid = false;
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
			
		return flgValid;
	}

	public void initTab1(String siteInfoId){
		semmco005tab1Bean = getSemmco005tab1Bean();
		semmco005tab1Bean.getContract().setDutyPayStatus("00");
		semmco005tab1Bean.getContract().setTotSendFlag("Y");
		semmco005tab1Bean.getContractStatus().setChangeStatusDt(new Date());
		setSemmco005tab1Bean(semmco005tab1Bean);
		semmco005Bean = getSemmco005Bean();
		semmco005Bean.setTabHeader(msg("message.tab.contract"));
		semmco005Bean.setRenderBtnSave(true);
		semmco005Bean.setTabNo("1");
		setSemmco005Bean(semmco005Bean);
		this.searchContractStatusHistory();
		this.doClearContractStatusHistory();
		this.getSiteInfo();
		this.getContractByRowId();
		this.getContractStatusListByContractId();
		getContractLostStatusList();
		getSemmco005Action().checkScreenName();
	}
	
	private void getContractLostStatusList() {
		semmco005Bean = getSemmco005Bean();
		LovMaster tmp = null;
		SelectItem selItem = null;
		List<SelectItem> selList = new LinkedList<SelectItem>();
		try {
			ILovMasterService lovService = (ILovMasterService)FacesUtils.getInstance().getBean("lovMasterService");
			tmp = lovService.getContractLostStatus();
			
			if (tmp != null) {
				selItem = new SelectItem("" , msg("value.selectItem"));
				selList.add(selItem);
				selItem = new SelectItem();
				selItem.setLabel(tmp.getLovName());
				selItem.setValue(tmp.getLovCode());
				selList.add(selItem);
				semmco005Bean.setContractLostStatusList(selList);
			} else {
				semmco005Bean.setContractLostStatusList(getEmptyDropDown());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		semmco005Bean.setChkContractLost(false);
		setSemmco005Bean(semmco005Bean);
	}
	
	private void getContractStatusListByContractId() {
		semmco005Bean = getSemmco005Bean();
		List<Mco004SrchLovStatusSP> to = null;
		List<SelectItem> selList = new LinkedList<SelectItem>();
		SelectItem selItem = null;
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			Mco004SrchLovStatusSP criteria = new Mco004SrchLovStatusSP();
			criteria.setContractId(semmco005Bean.getContractIdParam());
			criteria.setContractStatusId(null);
			to = service.querySPList(EQueryName.SP_MCO004_SRCH_LOV_STATUS.name, criteria);
			selItem = new SelectItem("" , msg("value.selectItem"));
			selList.add(selItem);
			if(to != null && to.size() > 0){
				for (Mco004SrchLovStatusSP lov : to) {
					selItem = new SelectItem();
					selItem.setLabel(lov.getLovName());
					selItem.setValue(lov.getLovCode());
					selList.add(selItem);
				}
				semmco005Bean.setContractStatusTab1List(selList);
			}else{
				semmco005Bean.setContractStatusTab1List(getEmptyDropDown());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco005Bean(semmco005Bean);
		
	}

	private void getContractByRowId() {
		semmco005tab1Bean = getSemmco005tab1Bean();
		semmco005Bean = getSemmco005Bean();
		try{
			ISiteContractService service = (ISiteContractService)getBean("siteContractService");
			String contractId = getSemmco005Bean().getContractIdParam();
			if(contractId != null && !contractId.equals("")){
				semmco005tab1Bean.setContract(service.queryContractByRowId(contractId));
				if(semmco005tab1Bean.getContract() != null){
					if(semmco005tab1Bean.getContract().getDutyPayStatus() == null){
						semmco005tab1Bean.getContract().setDutyPayStatus("00");
					}
					if(semmco005tab1Bean.getContract().getTotSendFlag() == null){
						semmco005tab1Bean.getContract().setTotSendFlag("Y");
					}
				}else{
					semmco005tab1Bean.setContract(new Contract());
					semmco005tab1Bean.getContract().setDutyPayStatus("00");
					semmco005tab1Bean.getContract().setTotSendFlag("Y");
				}
				semmco005Bean.setCreateBy(semmco005tab1Bean.getContract().getCreateBy());
				semmco005Bean.setUpdateBy(semmco005tab1Bean.getContract().getUpdateBy());
				semmco005Bean.setCreateDate(semmco005tab1Bean.getContract().getCreateDt());
				semmco005Bean.setUpdateDate(semmco005tab1Bean.getContract().getUpdateDt());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco005tab1Bean(semmco005tab1Bean);
		setSemmco005Bean(semmco005Bean);
		
	}

	private void getSiteInfo() {
		semmco005Bean = getSemmco005Bean();
		semmco005tab1Bean = getSemmco005tab1Bean();
		try{
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			if(semmco005Bean.getSiteInfoParam() != null && !semmco005Bean.getSiteInfoParam().equals("")){
				SiteInfo siteInfo = service.querySiteInfoByRowId(semmco005Bean.getSiteInfoParam());
				if(siteInfo != null){
					semmco005tab1Bean.setSiteInfo(siteInfo);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco005Bean(semmco005Bean);
		setSemmco005tab1Bean(semmco005tab1Bean);
		
	}

	private void searchContractStatusHistory() {
		semmco005tab1Bean = getSemmco005tab1Bean();
		List<Mco004SrchStatusSP> to = null;
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			Mco004SrchStatusSP criteria = new Mco004SrchStatusSP();
			criteria.setContractId(getSemmco005Bean().getContractIdParam());
			to = service.querySPList(EQueryName.SP_MCO004_SRCH_STATUS.name, criteria);
			List<Mco004SrchStatusSP> list = new ArrayList<Mco004SrchStatusSP>();
			// check add able
			this.checkAddAbleContractStatus();
			if(to != null && to.size() > 0){
				int index = 0;
				for(Mco004SrchStatusSP status : to){
					index++;
//					if(status.getChangeStatusDate() != null) status.setChangeStatusDate(convertYearENtoTH(status.getChangeStatusDate()));
					if(status.getChangeStatusDate() != null) status.setChangeStatusDateStr(convertYearENtoTHStr(status.getChangeStatusDate()));
					// check last record;
					if(index == to.size()){
						status.setLastRecord(true);
					}else{
						status.setLastRecord(false);
					}
					list.add(status);
				}
			}
			semmco005tab1Bean.setContractStatusHistoryList(list);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco005tab1Bean(semmco005tab1Bean);
	}
	
	private void checkAddAbleContractStatus() {
		semmco005tab1Bean = getSemmco005tab1Bean();
		List<Mco001CheckAddAbleSP> to = null;
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			Mco001CheckAddAbleSP criteria = new Mco001CheckAddAbleSP();
			criteria.setContractId(getSemmco005Bean().getContractIdParam());
			String screenName = getSemmco005Bean().getScreenName();
//			if(screenName != null && screenName.equals("LEGAL")){
				criteria.setRole("LEGAL");
//			}else{
//				criteria.setRole("CONTRACT");
//			}
			to = service.querySPList(EQueryName.SP_MCO001_CHK_ADDABLE.name, criteria);
			if(to != null && to.size() > 0){
				Mco001CheckAddAbleSP addAble = to.get(0);
				if(addAble.getAddAbleFlag() != null && addAble.getAddAbleFlag().equals("Y")){
					semmco005tab1Bean.setRenderedAddHistory(true);
				}else{
					semmco005tab1Bean.setRenderedAddHistory(false);
				}
				
				if(addAble.getEditAbleFlag() != null && addAble.getEditAbleFlag().equals("Y")){
					semmco005tab1Bean.setRenderedUpdateHistory(true);
				}else{
					semmco005tab1Bean.setRenderedUpdateHistory(false);
				}
				
				if(addAble.getDeleteAbleFlag() != null && addAble.getDeleteAbleFlag().equals("Y")){
					semmco005tab1Bean.setRenderedDeleteHistory(true);
				}else{
					semmco005tab1Bean.setRenderedDeleteHistory(false);
				}
				
				if(addAble.getEditDutyFlag() != null && addAble.getEditDutyFlag().equals("Y")){
					semmco005tab1Bean.setRenderedEditDuty(true);
				}else{
					semmco005tab1Bean.setRenderedEditDuty(false);
				}
				
				if(addAble.getEditTotFlag() != null && addAble.getEditTotFlag().equals("Y")){
					semmco005tab1Bean.setRenderedEditTot(true);
				}else{
					semmco005tab1Bean.setRenderedEditTot(false);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco005tab1Bean(semmco005tab1Bean);
	}

	private boolean doClearContractStatusHistory() {
		boolean flag = false;
		semmco005Bean = getSemmco005Bean();
		semmco005tab1Bean = getSemmco005tab1Bean();
		semmco005tab1Bean.setContractStatus(new ContractStatus());
		semmco005tab1Bean.getContractStatus().setContractStatus("");
		semmco005tab1Bean.getContractStatus().setRemark("");
		semmco005tab1Bean.getContractStatus().setChangeStatusDt(new Date());
		semmco005tab1Bean.setDisabledBtnAddContractStatusHistory(false);
		semmco005tab1Bean.setDisabledBtnUpdateContractStatusHistory(true);
		semmco005Bean.setChkContractLost(false);
		setSemmco005Bean(semmco005Bean);
		setSemmco005tab1Bean(semmco005tab1Bean);
		return flag;
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmco005tab1Bean().setTmpRowId(rowId);
	}
	
	public void doUpdateTab1() {
		semmco005tab1Bean = getSemmco005tab1Bean();
		semmco005Bean = getSemmco005Bean();
		try{
			if(validateTabUpdate()){
				this.updateContract();
				this.updateSiteInfo();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		semmco005Bean.setRenderedMsgFormTop(true);
		semmco005tab1Bean.setRenderedMsgFormMiddle(false);
		setSemmco005Bean(semmco005Bean);
		setSemmco005tab1Bean(semmco005tab1Bean);
	}
	
	private void updateContract() {
		semmco005tab1Bean = getSemmco005tab1Bean();
		semmco005Bean = getSemmco005Bean();
		try{
			ISiteContractService service = (ISiteContractService)getBean("siteContractService");
			Contract con = service.queryContractByRowId(getSemmco005Bean().getContractIdParam());
			if(con != null){
				if(semmco005Bean.getTabNo().equals("1")){
					con.setDutyAmt(semmco005tab1Bean.getContract().getDutyAmt());
					con.setCopyDuty(semmco005tab1Bean.getContract().getCopyDuty());
					con.setCopyDutyAmt(semmco005tab1Bean.getContract().getCopyDutyAmt());
					con.setDutyPayDt(semmco005tab1Bean.getContract().getDutyPayDt());
					con.setOtherDutyAmt(semmco005tab1Bean.getContract().getOtherDutyAmt());
					con.setDutyPayStatus(semmco005tab1Bean.getContract().getDutyPayStatus());
					con.setContractRoom(semmco005tab1Bean.getContract().getContractRoom());
					con.setContractShelf(semmco005tab1Bean.getContract().getContractShelf());
					//Adding by mr.John from (mr.Surasit)
					con.setReceivePersonCode(semmco005tab1Bean.getContract().getReceivePersonCode());
					con.setCreatePersonCode(semmco005tab1Bean.getContract().getCreatePersonCode());
				}
				if(semmco005Bean.getTabNo().equals("2")){
					con.setTotSendFlag(semmco005tab1Bean.getContract().getTotSendFlag());
					if(semmco005tab1Bean.getContract().getTotSendFlag().equals("N")){
						con.setTotRemarkNotSend(semmco005tab1Bean.getContract().getTotRemarkNotSend());
					}else{
						con.setTotRemarkNotSend(null);
					}
				}
				con.setCurrentUser(semmco005tab1Bean.getUserLogin());
				semmco005tab1Bean.setContract(service.updateContract(con));
				semmco005Bean.setCreateBy(semmco005tab1Bean.getContract().getCreateBy());
				semmco005Bean.setUpdateBy(semmco005tab1Bean.getContract().getUpdateBy());
				semmco005Bean.setCreateDate(semmco005tab1Bean.getContract().getCreateDt());
				semmco005Bean.setUpdateDate(semmco005tab1Bean.getContract().getUpdateDt());
				addMessageInfo("M0001");
			}
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		setSemmco005Bean(semmco005Bean);
		setSemmco005tab1Bean(semmco005tab1Bean);
		
	}

	private void updateSiteInfo() {
		semmco005tab1Bean = getSemmco005tab1Bean();
		try{
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			if(semmco005tab1Bean.getSiteInfo() != null){
				semmco005tab1Bean.getSiteInfo().setCurrentUser(semmco005tab1Bean.getUserLogin());
				semmco005tab1Bean.setSiteInfo(service.updateSiteInfo(semmco005tab1Bean.getSiteInfo()));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco005tab1Bean(semmco005tab1Bean);
		
	}

	@Override
	public boolean validate() {
		return false;
	}
	
	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void init() {
		SEMMCO005Tab1Bean semmco005tab1Bean = new SEMMCO005Tab1Bean();
		semmco005tab1Bean.setRightAmphurList(getEmptyDropDown());
		semmco005tab1Bean.setContract(new Contract());
		semmco005tab1Bean.setSiteInfo(new SiteInfo());
		semmco005tab1Bean.setContractStatus(new ContractStatus());
		semmco005tab1Bean.setContractStatusHistoryList(new ArrayList<Mco004SrchStatusSP>());
		semmco005tab1Bean.setBorrowOfficerList(getLovItemsByType(ELovType.T_CO_BORROW_OFFICER.name));
		setSemmco005tab1Bean(semmco005tab1Bean);
		
	}

	private SEMMCO005Tab1Bean semmco005tab1Bean;
	
	public SEMMCO005Tab1Bean getSemmco005tab1Bean() {
		return (SEMMCO005Tab1Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco005tab1Bean");
	}
	
	public void setSemmco005tab1Bean(SEMMCO005Tab1Bean semmco005tab1Bean) {
		this.semmco005tab1Bean = semmco005tab1Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco005tab1Bean", this.semmco005tab1Bean);
	}

	private SEMMCO005Bean semmco005Bean;
	
	public SEMMCO005Bean getSemmco005Bean() {
		return (SEMMCO005Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco005Bean");
	}

	public void setSemmco005Bean(SEMMCO005Bean semmco005Bean) {
		this.semmco005Bean = semmco005Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco005Bean", this.semmco005Bean);
	}

	private SEMMCO005Action semmco005Action;
	
	public SEMMCO005Action getSemmco005Action() {
		if(semmco005Action == null){
			semmco005Action = new SEMMCO005Action();
		}
		return semmco005Action;
	}

	public void setSemmco005Action(SEMMCO005Action semmco005Action) {
		this.semmco005Action = semmco005Action;
	}
	
	private boolean validateTabUpdate(){
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemmco005tab1Bean().getContract().getDutyPayStatus())){
			addMessageError("W0001", msg("message.dutyAmt"));
			flgValid = false;
		}
		
		if(getSemmco005tab1Bean().getContract().getDutyPayStatus().equals("01")
		   && getSemmco005tab1Bean().getContract().getDutyPayDt() == null){
			addMessageError("W0001", msg("export.col.requestDtFrom"));
			flgValid = false;
		}
		return flgValid;
	}
	
	public void doUpdateTab2(){
		semmco005tab1Bean = getSemmco005tab1Bean();
		semmco005Bean = getSemmco005Bean();
		try{
			if(validateTab2()){
				this.updateContract();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		semmco005Bean.setRenderedMsgFormTop(true);
		semmco005tab1Bean.setRenderedMsgFormMiddle(false);
		setSemmco005Bean(semmco005Bean);
		setSemmco005tab1Bean(semmco005tab1Bean);
	}
	
	private boolean validateTab2(){
		boolean flgValid = true;
		if("N".equals(getSemmco005tab1Bean().getContract().getTotSendFlag())){
			if(StringUtils.isEmpty(getSemmco005tab1Bean().getContract().getTotRemarkNotSend())){
				addMessageError("W0001", msg("message.notSendRemark"));
				flgValid = false;
			}
		}
		return flgValid;
	}
	
}
