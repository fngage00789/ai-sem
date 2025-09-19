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
import th.co.ais.web.co.bean.SEMMCO001Bean;
import th.co.ais.web.co.bean.SEMMCO001Tab1Bean;
import th.co.ais.web.util.FacesUtils;

public class SEMMCO001Tab1Action extends AbstractAction{

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
		semmco001tab1Bean = getSemmco001tab1Bean();
		semmco001Bean = getSemmco001Bean();
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		try{
			if(semmco001tab1Bean.getContractStatus() != null){
				service.deleteContractStatus(semmco001tab1Bean.getContractStatus());
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
		semmco001Bean.setRenderedMsgFormTop(false);
		semmco001tab1Bean.setRenderedMsgFormMiddle(true);
		setSemmco001Bean(semmco001Bean);
		setSemmco001tab1Bean(semmco001tab1Bean);
		return flag;
	}
	
	private boolean doUpdateContractStatusHistory() {
		boolean flag = false;
		semmco001tab1Bean = getSemmco001tab1Bean();
		semmco001Bean = getSemmco001Bean();
		if(!validateUpdateContractStatus()){
			semmco001Bean.setRenderedMsgFormTop(false);
			semmco001tab1Bean.setRenderedMsgFormMiddle(true);
			setSemmco001Bean(semmco001Bean);
			setSemmco001tab1Bean(semmco001tab1Bean);
			return flag;
		}
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			semmco001tab1Bean.getContractStatus().setCurrentUser(semmco001tab1Bean.getUserLogin());
			semmco001tab1Bean.setContractStatus(service.updateContractStatus(semmco001tab1Bean.getContractStatus()));
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
		semmco001Bean.setChkContractLost(false);
		semmco001Bean.setRenderedMsgFormTop(false);
		semmco001tab1Bean.setRenderedMsgFormMiddle(true);
		setSemmco001Bean(semmco001Bean);
		setSemmco001tab1Bean(semmco001tab1Bean);
		return flag;
	}
	/* OLD
	private boolean doAddContractStatusHistory() {
		boolean flag = false;
		semmco001tab1Bean = getSemmco001tab1Bean();
		semmco001Bean = getSemmco001Bean();
		if(!validateUpdateContractStatus()){
			semmco001Bean.setRenderedMsgFormTop(false);
			semmco001tab1Bean.setRenderedMsgFormMiddle(true);
			setSemmco001Bean(semmco001Bean);
			setSemmco001tab1Bean(semmco001tab1Bean);
			return flag;
		}
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		// add contract status
		try{
			semmco001tab1Bean.getContractStatus().setContractId(getSemmco001Bean().getContractIdParam());
			semmco001tab1Bean.getContractStatus().setCurrentUser(semmco001tab1Bean.getUserLogin());
			semmco001tab1Bean.getContractStatus().setSeqNo(this.getContractStatusSeqNo());
			semmco001tab1Bean.setContractStatus(service.createContractStatus(semmco001tab1Bean.getContractStatus()));
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
		semmco001Bean.setRenderedMsgFormTop(false);
		semmco001tab1Bean.setRenderedMsgFormMiddle(true);
		setSemmco001Bean(semmco001Bean);
		setSemmco001tab1Bean(semmco001tab1Bean);
		return flag;
	}
	*/
	private boolean doAddContractStatusHistory() {
		boolean flag = false;
		semmco001tab1Bean = getSemmco001tab1Bean();
		semmco001Bean = getSemmco001Bean();
		if(!validateUpdateContractStatus()){
			semmco001Bean.setRenderedMsgFormTop(false);
			semmco001tab1Bean.setRenderedMsgFormMiddle(true);
			setSemmco001Bean(semmco001Bean);
			setSemmco001tab1Bean(semmco001tab1Bean);
			return flag;
		}
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		// add contract status
		try{
			List<Mco002UpdateContractStatusSP> to = null;
			Mco002UpdateContractStatusSP contract = new Mco002UpdateContractStatusSP();
			contract.setContractId(semmco001Bean.getContractIdParam());
			contract.setContractStatus(semmco001tab1Bean.getContractStatus().getContractStatus());
			contract.setChangeStatusDate(semmco001tab1Bean.getContractStatus().getChangeStatusDt());
			contract.setRemark(semmco001tab1Bean.getContractStatus().getRemark());
			contract.setCurrentUser(semmco001tab1Bean.getUserLogin());
			contract.setCompany(semmco001Bean.getCompanyParam());
			//Adding by mr.John from (mr.Surasit) 27/04/2011
			contract.setReceivePersonCode(semmco001tab1Bean.getContract().getReceivePersonCode());
			contract.setCreatePersonCode(semmco001tab1Bean.getContract().getCreatePersonCode());
			
			to = service.querySPList(EQueryName.SP_MCO002_UPD_STATUS_LIST.name, contract);
				
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
		semmco001Bean.setChkContractLost(false);
		semmco001Bean.setRenderedMsgFormTop(false);
		semmco001tab1Bean.setRenderedMsgFormMiddle(true);
		setSemmco001Bean(semmco001Bean);
		setSemmco001tab1Bean(semmco001tab1Bean);
		return flag;
	}
	private Integer getContractStatusSeqNo() {
		// SEM_SP_MCO001_SEQ_STATUS (parameter = contractId)
		semmco001tab1Bean = getSemmco001tab1Bean();
		ISiteContractService service = (ISiteContractService)getBean("siteContractService");
		List<Mco001SeqStatusSP> to = null;
		Integer seqNo = 0;
		try{
			Mco001SeqStatusSP criteria = new Mco001SeqStatusSP();
			criteria.setRowId(getSemmco001Bean().getContractIdParam());
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
		semmco001tab1Bean = getSemmco001tab1Bean();
		List<Mco001UpdateStatusSP> to = null;
		try{
			ISiteContractService service = (ISiteContractService)getBean("siteContractService");
			Mco001UpdateStatusSP status = new Mco001UpdateStatusSP();
			status.setContractId(getSemmco001Bean().getContractIdParam());
			status.setCurrentUser(semmco001tab1Bean.getUserLogin());
			
			to = service.querySPList(EQueryName.SP_MCO001_UPD_STATUS.name, status);
			if(to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")){
				log.debug("update site contract result [" + to.get(0).getResultMsg() + "]");
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco001tab1Bean(semmco001tab1Bean);
		
	}

	private boolean initUpdateContractStatusHistory() {
		boolean flag = false;
		semmco001tab1Bean = getSemmco001tab1Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		ISiteContractService conService = (ISiteContractService)getBean("siteContractService");
		try{
			if(rowId != null){
				semmco001tab1Bean.setContractStatus(service.queryContractStatusByRowId(rowId));
				semmco001tab1Bean.setContract(conService.queryContractByRowId(getSemmco001Bean().getContractIdParam()));
				semmco001tab1Bean.setDisabledBtnAddContractStatusHistory(true);
				semmco001tab1Bean.setDisabledBtnUpdateContractStatusHistory(false);
				semmco001tab1Bean.setRenderedAddHistory(true);
				this.updateContractStatusList(rowId);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		setSemmco001tab1Bean(semmco001tab1Bean);
		return flag;
	}
	private void updateContractStatusList(String rowId) {
		semmco001Bean = getSemmco001Bean();
		List<Mco001SrchLovStatusSP> to = null;
		List<SelectItem> selList = new LinkedList<SelectItem>();
		SelectItem selItem = null;
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			Mco001SrchLovStatusSP criteria = new Mco001SrchLovStatusSP();
			criteria.setContractId(semmco001Bean.getContractIdParam());
			criteria.setContractStatusId(rowId);
			to = service.querySPList(EQueryName.SP_MCO001_SRCH_LOV_STATUS.name, criteria);
			selItem = new SelectItem("" , msg("value.selectItem"));
			selList.add(selItem);
			if(to != null && to.size() > 0){
				for (Mco001SrchLovStatusSP lov : to) {
					selItem = new SelectItem();
					selItem.setLabel(lov.getLovName());
					selItem.setValue(lov.getLovCode());
					selList.add(selItem);
				}
				semmco001Bean.setContractStatusTab1List(selList);
			}else{
				semmco001Bean.setContractStatusTab1List(getEmptyDropDown());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco001Bean(semmco001Bean);
		
	}

	private boolean initDeleteContractStatusHistory() {
		boolean flag = false;
		semmco001tab1Bean = getSemmco001tab1Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		try{
			if(rowId != null){
				semmco001tab1Bean.setContractStatus(service.queryContractStatusByRowId(rowId));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco001tab1Bean(semmco001tab1Bean);
		return flag;
	}
	
	private boolean validateUpdateContractStatus() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemmco001tab1Bean().getContractStatus().getContractStatus())){
			addMessageError("W0001", msg("message.contractStatus"));
			flgValid = false;
		}else{
			// contract status = 03 (send legal) call SP_MCO002_CHK_NO_FILE
			if(getSemmco001tab1Bean().getContractStatus().getContractStatus().equals("03")){
				if(!checkNoFile()){
					flgValid = false;
				}
			}
		}
		
		if(getSemmco001tab1Bean().getContractStatus().getChangeStatusDt() == null){
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
			criteria.setContractId(getSemmco001Bean().getContractIdParam());
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
		semmco001tab1Bean = getSemmco001tab1Bean();
		semmco001tab1Bean.getContract().setDutyPayStatus("00");
		semmco001tab1Bean.getContract().setTotSendFlag("Y");
		semmco001tab1Bean.getContractStatus().setChangeStatusDt(new Date());
		setSemmco001tab1Bean(semmco001tab1Bean);
		semmco001Bean = getSemmco001Bean();
		semmco001Bean.setTabHeader(msg("message.tab.contract"));
		semmco001Bean.setRenderBtnSave(true);
		semmco001Bean.setTabNo("1");
		setSemmco001Bean(semmco001Bean);
		this.searchContractStatusHistory();
		this.doClearContractStatusHistory();
		this.getSiteInfo();
		this.getContractByRowId();
		this.getContractStatusListByContractId();
		getContractLostStatusList();
		getSemmco001Action().checkScreenName();
	}
	
	private void getContractLostStatusList() {
		semmco001Bean = getSemmco001Bean();
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
				semmco001Bean.setContractLostStatusList(selList);
			} else {
				semmco001Bean.setContractLostStatusList(getEmptyDropDown());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		semmco001Bean.setChkContractLost(false);
		setSemmco001Bean(semmco001Bean);
	}
	
	private void getContractStatusListByContractId() {
		semmco001Bean = getSemmco001Bean();
		List<Mco001SrchLovStatusSP> to = null;
		List<SelectItem> selList = new LinkedList<SelectItem>();
		SelectItem selItem = null;
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			Mco001SrchLovStatusSP criteria = new Mco001SrchLovStatusSP();
			criteria.setContractId(semmco001Bean.getContractIdParam());
			criteria.setContractStatusId(null);
			to = service.querySPList(EQueryName.SP_MCO001_SRCH_LOV_STATUS.name, criteria);
			selItem = new SelectItem("" , msg("value.selectItem"));
			selList.add(selItem);
			if(to != null && to.size() > 0){
				for (Mco001SrchLovStatusSP lov : to) {
					selItem = new SelectItem();
					selItem.setLabel(lov.getLovName());
					selItem.setValue(lov.getLovCode());
					selList.add(selItem);
				}
				semmco001Bean.setContractStatusTab1List(selList);
			}else{
				semmco001Bean.setContractStatusTab1List(getEmptyDropDown());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco001Bean(semmco001Bean);
		
	}

	private void getContractByRowId() {
		semmco001tab1Bean = getSemmco001tab1Bean();
		semmco001Bean = getSemmco001Bean();
		try{
			ISiteContractService service = (ISiteContractService)getBean("siteContractService");
			String contractId = getSemmco001Bean().getContractIdParam();
			if(contractId != null && !contractId.equals("")){
				semmco001tab1Bean.setContract(service.queryContractByRowId(contractId));
				if(semmco001tab1Bean.getContract() != null){
					if(semmco001tab1Bean.getContract().getDutyPayStatus() == null){
						semmco001tab1Bean.getContract().setDutyPayStatus("00");
					}
					if(semmco001tab1Bean.getContract().getTotSendFlag() == null){
						semmco001tab1Bean.getContract().setTotSendFlag("Y");
					}
				}else{
					semmco001tab1Bean.setContract(new Contract());
					semmco001tab1Bean.getContract().setDutyPayStatus("00");
					semmco001tab1Bean.getContract().setTotSendFlag("Y");
				}
				semmco001Bean.setCreateBy(semmco001tab1Bean.getContract().getCreateBy());
				semmco001Bean.setUpdateBy(semmco001tab1Bean.getContract().getUpdateBy());
				semmco001Bean.setCreateDate(semmco001tab1Bean.getContract().getCreateDt());
				semmco001Bean.setUpdateDate(semmco001tab1Bean.getContract().getUpdateDt());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco001tab1Bean(semmco001tab1Bean);
		setSemmco001Bean(semmco001Bean);
		
	}

	private void getSiteInfo() {
		semmco001Bean = getSemmco001Bean();
		semmco001tab1Bean = getSemmco001tab1Bean();
		try{
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			if(semmco001Bean.getSiteInfoParam() != null && !semmco001Bean.getSiteInfoParam().equals("")){
				SiteInfo siteInfo = service.querySiteInfoByRowId(semmco001Bean.getSiteInfoParam());
				if(siteInfo != null){
					semmco001tab1Bean.setSiteInfo(siteInfo);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco001Bean(semmco001Bean);
		setSemmco001tab1Bean(semmco001tab1Bean);
		
	}

	private void searchContractStatusHistory() {
		semmco001tab1Bean = getSemmco001tab1Bean();
		List<Mco001SrchStatusSP> to = null;
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			Mco001SrchStatusSP criteria = new Mco001SrchStatusSP();
			criteria.setContractId(getSemmco001Bean().getContractIdParam());
			to = service.querySPList(EQueryName.SP_MCO001_SRCH_STATUS.name, criteria);
			List<Mco001SrchStatusSP> list = new ArrayList<Mco001SrchStatusSP>();
			// check add able
			this.checkAddAbleContractStatus();
			if(to != null && to.size() > 0){
				int index = 0;
				for(Mco001SrchStatusSP status : to){
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
			semmco001tab1Bean.setContractStatusHistoryList(list);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco001tab1Bean(semmco001tab1Bean);
	}
	
	private void checkAddAbleContractStatus() {
		semmco001tab1Bean = getSemmco001tab1Bean();
		List<Mco001CheckAddAbleSP> to = null;
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			Mco001CheckAddAbleSP criteria = new Mco001CheckAddAbleSP();
			criteria.setContractId(getSemmco001Bean().getContractIdParam());
			String screenName = getSemmco001Bean().getScreenName();
			if(screenName != null && screenName.equals("LEGAL")){
				criteria.setRole("LEGAL");
			}else{
				criteria.setRole("CONTRACT");
			}
			to = service.querySPList(EQueryName.SP_MCO001_CHK_ADDABLE.name, criteria);
			if(to != null && to.size() > 0){
				Mco001CheckAddAbleSP addAble = to.get(0);
				if(addAble.getAddAbleFlag() != null && addAble.getAddAbleFlag().equals("Y")){
					semmco001tab1Bean.setRenderedAddHistory(true);
				}else{
					semmco001tab1Bean.setRenderedAddHistory(false);
				}
				
				if(addAble.getEditAbleFlag() != null && addAble.getEditAbleFlag().equals("Y")){
					semmco001tab1Bean.setRenderedUpdateHistory(true);
				}else{
					semmco001tab1Bean.setRenderedUpdateHistory(false);
				}
				
				if(addAble.getDeleteAbleFlag() != null && addAble.getDeleteAbleFlag().equals("Y")){
					semmco001tab1Bean.setRenderedDeleteHistory(true);
				}else{
					semmco001tab1Bean.setRenderedDeleteHistory(false);
				}
				
				if(addAble.getEditDutyFlag() != null && addAble.getEditDutyFlag().equals("Y")){
					semmco001tab1Bean.setRenderedEditDuty(true);
				}else{
					semmco001tab1Bean.setRenderedEditDuty(false);
				}
				
				if(addAble.getEditTotFlag() != null && addAble.getEditTotFlag().equals("Y")){
					semmco001tab1Bean.setRenderedEditTot(true);
				}else{
					semmco001tab1Bean.setRenderedEditTot(false);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco001tab1Bean(semmco001tab1Bean);
	}

	private boolean doClearContractStatusHistory() {
		boolean flag = false;
		semmco001Bean = getSemmco001Bean();
		semmco001tab1Bean = getSemmco001tab1Bean();
		semmco001tab1Bean.setContractStatus(new ContractStatus());
		semmco001tab1Bean.getContractStatus().setContractStatus("");
		semmco001tab1Bean.getContractStatus().setRemark("");
		semmco001tab1Bean.getContractStatus().setChangeStatusDt(new Date());
		semmco001tab1Bean.setDisabledBtnAddContractStatusHistory(false);
		semmco001tab1Bean.setDisabledBtnUpdateContractStatusHistory(true);
		semmco001Bean.setChkContractLost(false);
		setSemmco001Bean(semmco001Bean);
		setSemmco001tab1Bean(semmco001tab1Bean);
		return flag;
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmco001tab1Bean().setTmpRowId(rowId);
	}
	
	public void doUpdateTab1() {
		semmco001tab1Bean = getSemmco001tab1Bean();
		semmco001Bean = getSemmco001Bean();
		try{
			if(validateTabUpdate()){
				this.updateContract();
				this.updateSiteInfo();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		semmco001Bean.setRenderedMsgFormTop(true);
		semmco001tab1Bean.setRenderedMsgFormMiddle(false);
		setSemmco001Bean(semmco001Bean);
		setSemmco001tab1Bean(semmco001tab1Bean);
	}
	
	private void updateContract() {
		semmco001tab1Bean = getSemmco001tab1Bean();
		semmco001Bean = getSemmco001Bean();
		try{
			ISiteContractService service = (ISiteContractService)getBean("siteContractService");
			Contract con = service.queryContractByRowId(getSemmco001Bean().getContractIdParam());
			if(con != null){
				if(semmco001Bean.getTabNo().equals("1")){
					con.setDutyAmt(semmco001tab1Bean.getContract().getDutyAmt());
					con.setCopyDuty(semmco001tab1Bean.getContract().getCopyDuty());
					con.setCopyDutyAmt(semmco001tab1Bean.getContract().getCopyDutyAmt());
					con.setDutyPayDt(semmco001tab1Bean.getContract().getDutyPayDt());
					con.setOtherDutyAmt(semmco001tab1Bean.getContract().getOtherDutyAmt());
					con.setDutyPayStatus(semmco001tab1Bean.getContract().getDutyPayStatus());
					con.setContractRoom(semmco001tab1Bean.getContract().getContractRoom());
					con.setContractShelf(semmco001tab1Bean.getContract().getContractShelf());
					//Adding by mr.John from (mr.Surasit)
					con.setReceivePersonCode(semmco001tab1Bean.getContract().getReceivePersonCode());
					con.setCreatePersonCode(semmco001tab1Bean.getContract().getCreatePersonCode());
				}
				if(semmco001Bean.getTabNo().equals("2")){
					con.setTotSendFlag(semmco001tab1Bean.getContract().getTotSendFlag());
					if(semmco001tab1Bean.getContract().getTotSendFlag().equals("N")){
						con.setTotRemarkNotSend(semmco001tab1Bean.getContract().getTotRemarkNotSend());
					}else{
						con.setTotRemarkNotSend(null);
					}
				}
				con.setCurrentUser(semmco001tab1Bean.getUserLogin());
				semmco001tab1Bean.setContract(service.updateContract(con));
				semmco001Bean.setCreateBy(semmco001tab1Bean.getContract().getCreateBy());
				semmco001Bean.setUpdateBy(semmco001tab1Bean.getContract().getUpdateBy());
				semmco001Bean.setCreateDate(semmco001tab1Bean.getContract().getCreateDt());
				semmco001Bean.setUpdateDate(semmco001tab1Bean.getContract().getUpdateDt());
				addMessageInfo("M0001");
			}
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		setSemmco001Bean(semmco001Bean);
		setSemmco001tab1Bean(semmco001tab1Bean);
		
	}

	private void updateSiteInfo() {
		semmco001tab1Bean = getSemmco001tab1Bean();
		try{
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			if(semmco001tab1Bean.getSiteInfo() != null){
				semmco001tab1Bean.getSiteInfo().setCurrentUser(semmco001tab1Bean.getUserLogin());
				semmco001tab1Bean.setSiteInfo(service.updateSiteInfo(semmco001tab1Bean.getSiteInfo()));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco001tab1Bean(semmco001tab1Bean);
		
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
		SEMMCO001Tab1Bean semmco001tab1Bean = new SEMMCO001Tab1Bean();
		semmco001tab1Bean.setRightAmphurList(getEmptyDropDown());
		semmco001tab1Bean.setContract(new Contract());
		semmco001tab1Bean.setSiteInfo(new SiteInfo());
		semmco001tab1Bean.setContractStatus(new ContractStatus());
		semmco001tab1Bean.setContractStatusHistoryList(new ArrayList<Mco001SrchStatusSP>());
		semmco001tab1Bean.setBorrowOfficerList(getLovItemsByType(ELovType.T_CO_BORROW_OFFICER.name));
		setSemmco001tab1Bean(semmco001tab1Bean);
		
	}

	private SEMMCO001Tab1Bean semmco001tab1Bean;
	
	public SEMMCO001Tab1Bean getSemmco001tab1Bean() {
		return (SEMMCO001Tab1Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco001tab1Bean");
	}
	
	public void setSemmco001tab1Bean(SEMMCO001Tab1Bean semmco001tab1Bean) {
		this.semmco001tab1Bean = semmco001tab1Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco001tab1Bean", this.semmco001tab1Bean);
	}

	private SEMMCO001Bean semmco001Bean;
	
	public SEMMCO001Bean getSemmco001Bean() {
		return (SEMMCO001Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco001Bean");
	}

	public void setSemmco001Bean(SEMMCO001Bean semmco001Bean) {
		this.semmco001Bean = semmco001Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco001Bean", this.semmco001Bean);
	}

	private SEMMCO001Action semmco001Action;
	
	public SEMMCO001Action getSemmco001Action() {
		if(semmco001Action == null){
			semmco001Action = new SEMMCO001Action();
		}
		return semmco001Action;
	}

	public void setSemmco001Action(SEMMCO001Action semmco001Action) {
		this.semmco001Action = semmco001Action;
	}
	
	private boolean validateTabUpdate(){
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemmco001tab1Bean().getContract().getDutyPayStatus())){
			addMessageError("W0001", msg("message.dutyAmt"));
			flgValid = false;
		}
		
		if(getSemmco001tab1Bean().getContract().getDutyPayStatus().equals("01")
		   && getSemmco001tab1Bean().getContract().getDutyPayDt() == null){
			addMessageError("W0001", msg("export.col.requestDtFrom"));
			flgValid = false;
		}
		return flgValid;
	}
	
	public void doUpdateTab2(){
		semmco001tab1Bean = getSemmco001tab1Bean();
		semmco001Bean = getSemmco001Bean();
		try{
			if(validateTab2()){
				this.updateContract();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		semmco001Bean.setRenderedMsgFormTop(true);
		semmco001tab1Bean.setRenderedMsgFormMiddle(false);
		setSemmco001Bean(semmco001Bean);
		setSemmco001tab1Bean(semmco001tab1Bean);
	}
	
	private boolean validateTab2(){
		boolean flgValid = true;
		if("N".equals(getSemmco001tab1Bean().getContract().getTotSendFlag())){
			if(StringUtils.isEmpty(getSemmco001tab1Bean().getContract().getTotRemarkNotSend())){
				addMessageError("W0001", msg("message.notSendRemark"));
				flgValid = false;
			}
		}
		return flgValid;
	}
	
	public void clickDutyPay(){
		semmco001tab1Bean = getSemmco001tab1Bean();
		if (StringUtils.equalsIgnoreCase("01", semmco001tab1Bean.getContract().getDutyPayStatus())){
			semmco001tab1Bean.getContract().setDutyPayDt(new Date());
		} else{
			semmco001tab1Bean.getContract().setDutyPayDt(null);
		}
		setSemmco001tab1Bean(semmco001tab1Bean);
	}
}
