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
import th.co.ais.web.co.bean.SEMMCO004Bean;
import th.co.ais.web.co.bean.SEMMCO004Tab1Bean;
import th.co.ais.web.util.FacesUtils;

public class SEMMCO004Tab1Action extends AbstractAction{

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
		semmco004tab1Bean = getSemmco004tab1Bean();
		semmco004Bean = getSemmco004Bean();
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		try{
			if(semmco004tab1Bean.getContractStatus() != null){
				service.deleteContractStatus(semmco004tab1Bean.getContractStatus());
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
		semmco004Bean.setRenderedMsgFormTop(false);
		semmco004tab1Bean.setRenderedMsgFormMiddle(true);
		setSemmco004Bean(semmco004Bean);
		setSemmco004tab1Bean(semmco004tab1Bean);
		return flag;
	}
	
	private boolean doUpdateContractStatusHistory() {
		boolean flag = false;
		semmco004tab1Bean = getSemmco004tab1Bean();
		semmco004Bean = getSemmco004Bean();
		if(!validateUpdateContractStatus()){
			semmco004Bean.setRenderedMsgFormTop(false);
			semmco004tab1Bean.setRenderedMsgFormMiddle(true);
			setSemmco004Bean(semmco004Bean);
			setSemmco004tab1Bean(semmco004tab1Bean);
			return flag;
		}
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			semmco004tab1Bean.getContractStatus().setCurrentUser(semmco004tab1Bean.getUserLogin());
			semmco004tab1Bean.setContractStatus(service.updateContractStatus(semmco004tab1Bean.getContractStatus()));
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
		semmco004Bean.setChkContractLost(false);
		semmco004Bean.setRenderedMsgFormTop(false);
		semmco004tab1Bean.setRenderedMsgFormMiddle(true);
		setSemmco004Bean(semmco004Bean);
		setSemmco004tab1Bean(semmco004tab1Bean);
		return flag;
	}
	/* OLD
	private boolean doAddContractStatusHistory() {
		boolean flag = false;
		semmco004tab1Bean = getSemmco004tab1Bean();
		semmco004Bean = getSemmco004Bean();
		if(!validateUpdateContractStatus()){
			semmco004Bean.setRenderedMsgFormTop(false);
			semmco004tab1Bean.setRenderedMsgFormMiddle(true);
			setSemmco004Bean(semmco004Bean);
			setSemmco004tab1Bean(semmco004tab1Bean);
			return flag;
		}
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		// add contract status
		try{
			semmco004tab1Bean.getContractStatus().setContractId(getSemmco004Bean().getContractIdParam());
			semmco004tab1Bean.getContractStatus().setCurrentUser(semmco004tab1Bean.getUserLogin());
			semmco004tab1Bean.getContractStatus().setSeqNo(this.getContractStatusSeqNo());
			semmco004tab1Bean.setContractStatus(service.createContractStatus(semmco004tab1Bean.getContractStatus()));
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
		semmco004Bean.setRenderedMsgFormTop(false);
		semmco004tab1Bean.setRenderedMsgFormMiddle(true);
		setSemmco004Bean(semmco004Bean);
		setSemmco004tab1Bean(semmco004tab1Bean);
		return flag;
	}
	*/
	private boolean doAddContractStatusHistory() {
		boolean flag = false;
		semmco004tab1Bean = getSemmco004tab1Bean();
		semmco004Bean = getSemmco004Bean();
		if(!validateUpdateContractStatus()){
			semmco004Bean.setRenderedMsgFormTop(false);
			semmco004tab1Bean.setRenderedMsgFormMiddle(true);
			setSemmco004Bean(semmco004Bean);
			setSemmco004tab1Bean(semmco004tab1Bean);
			return flag;
		}
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		// add contract status
		try{
			
			
			List<Mco005UpdateContractStatusSP> to = null;
			Mco005UpdateContractStatusSP contract = new Mco005UpdateContractStatusSP();
			contract.setContractId(semmco004Bean.getContractIdParam());
			contract.setContractStatus(semmco004tab1Bean.getContractStatus().getContractStatus());
			contract.setChangeStatusDate(semmco004tab1Bean.getContractStatus().getChangeStatusDt());
			contract.setRemark(semmco004tab1Bean.getContractStatus().getRemark());
			contract.setCurrentUser(semmco004tab1Bean.getUserLogin());
			contract.setReceivePersonCode(semmco004tab1Bean.getContract().getReceivePersonCode());
			contract.setCreatePersonCode(semmco004tab1Bean.getContract().getCreatePersonCode());
			contract.setGroupNo(semmco004Bean.getGroupNumber());
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
		semmco004Bean.setChkContractLost(false);
		semmco004Bean.setRenderedMsgFormTop(false);
		semmco004tab1Bean.setRenderedMsgFormMiddle(true);
		setSemmco004Bean(semmco004Bean);
		setSemmco004tab1Bean(semmco004tab1Bean);
		return flag;
	}
	private Integer getContractStatusSeqNo() {
		// SEM_SP_MCO001_SEQ_STATUS (parameter = contractId)
		semmco004tab1Bean = getSemmco004tab1Bean();
		ISiteContractService service = (ISiteContractService)getBean("siteContractService");
		List<Mco001SeqStatusSP> to = null;
		Integer seqNo = 0;
		try{
			Mco001SeqStatusSP criteria = new Mco001SeqStatusSP();
			criteria.setRowId(getSemmco004Bean().getContractIdParam());
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
		semmco004tab1Bean = getSemmco004tab1Bean();
		List<Mco001UpdateStatusSP> to = null;
		try{
			ISiteContractService service = (ISiteContractService)getBean("siteContractService");
			Mco001UpdateStatusSP status = new Mco001UpdateStatusSP();
			status.setContractId(getSemmco004Bean().getContractIdParam());
			status.setCurrentUser(semmco004tab1Bean.getUserLogin());
			status.setGroupNo(semmco004Bean.getGroupNumber());
			
			to = service.querySPList(EQueryName.SP_MCO001_UPD_STATUS.name, status);
			if(to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")){
				log.debug("update site contract result [" + to.get(0).getResultMsg() + "]");
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco004tab1Bean(semmco004tab1Bean);
		
	}

	private boolean initUpdateContractStatusHistory() {
		boolean flag = false;
		semmco004tab1Bean = getSemmco004tab1Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		ISiteContractService conService = (ISiteContractService)getBean("siteContractService");
		try{
			if(rowId != null){
				semmco004tab1Bean.setContractStatus(service.queryContractStatusByRowId(rowId));
				semmco004tab1Bean.setContract(conService.queryContractByRowId(getSemmco004Bean().getContractIdParam()));
				semmco004tab1Bean.setDisabledBtnAddContractStatusHistory(true);
				semmco004tab1Bean.setDisabledBtnUpdateContractStatusHistory(false);
				semmco004tab1Bean.setRenderedAddHistory(true);
				this.updateContractStatusList(rowId);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		setSemmco004tab1Bean(semmco004tab1Bean);
		return flag;
	}
	private void updateContractStatusList(String rowId) {
		semmco004Bean = getSemmco004Bean();
		List<Mco004SrchLovStatusSP> to = null;
		List<SelectItem> selList = new LinkedList<SelectItem>();
		SelectItem selItem = null;
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			Mco004SrchLovStatusSP criteria = new Mco004SrchLovStatusSP();
			criteria.setContractId(semmco004Bean.getContractIdParam());
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
				semmco004Bean.setContractStatusTab1List(selList);
			}else{
				semmco004Bean.setContractStatusTab1List(getEmptyDropDown());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco004Bean(semmco004Bean);
		
	}

	private boolean initDeleteContractStatusHistory() {
		boolean flag = false;
		semmco004tab1Bean = getSemmco004tab1Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		try{
			if(rowId != null){
				semmco004tab1Bean.setContractStatus(service.queryContractStatusByRowId(rowId));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco004tab1Bean(semmco004tab1Bean);
		return flag;
	}
	
	private boolean validateUpdateContractStatus() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemmco004tab1Bean().getContractStatus().getContractStatus())){
			addMessageError("W0001", msg("message.contractStatus"));
			flgValid = false;
		}else{
			// contract status = 03 (send legal) call SP_MCO002_CHK_NO_FILE
			if(getSemmco004tab1Bean().getContractStatus().getContractStatus().equals("03")){
				if(!checkNoFile()){
					flgValid = false;
				}
			}
		}
		
		if(getSemmco004tab1Bean().getContractStatus().getChangeStatusDt() == null){
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
			criteria.setContractId(getSemmco004Bean().getContractIdParam());
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
		semmco004tab1Bean = getSemmco004tab1Bean();
		semmco004tab1Bean.getContract().setDutyPayStatus("00");
		semmco004tab1Bean.getContract().setTotSendFlag("Y");
		semmco004tab1Bean.getContractStatus().setChangeStatusDt(new Date());
		setSemmco004tab1Bean(semmco004tab1Bean);
		semmco004Bean = getSemmco004Bean();
		semmco004Bean.setTabHeader(msg("message.tab.contract"));
		semmco004Bean.setRenderBtnSave(true);
		semmco004Bean.setTabNo("1");
		setSemmco004Bean(semmco004Bean);
		this.searchContractStatusHistory();
		this.doClearContractStatusHistory();
		this.getSiteInfo();
		this.getContractByRowId();
		this.getContractStatusListByContractId();
		getContractLostStatusList();
		getSemmco004Action().checkScreenName();
	}
	
	private void getContractLostStatusList() {
		semmco004Bean = getSemmco004Bean();
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
				semmco004Bean.setContractLostStatusList(selList);
			} else {
				semmco004Bean.setContractLostStatusList(getEmptyDropDown());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		semmco004Bean.setChkContractLost(false);
		setSemmco004Bean(semmco004Bean);
	}
	
	private void getContractStatusListByContractId() {
		semmco004Bean = getSemmco004Bean();
		List<Mco004SrchLovStatusSP> to = null;
		List<SelectItem> selList = new LinkedList<SelectItem>();
		SelectItem selItem = null;
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			Mco004SrchLovStatusSP criteria = new Mco004SrchLovStatusSP();
			criteria.setContractId(semmco004Bean.getContractIdParam());
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
				semmco004Bean.setContractStatusTab1List(selList);
			}else{
				semmco004Bean.setContractStatusTab1List(getEmptyDropDown());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco004Bean(semmco004Bean);
		
	}

	private void getContractByRowId() {
		semmco004tab1Bean = getSemmco004tab1Bean();
		semmco004Bean = getSemmco004Bean();
		try{
			ISiteContractService service = (ISiteContractService)getBean("siteContractService");
			String contractId = getSemmco004Bean().getContractIdParam();
			if(contractId != null && !contractId.equals("")){
				semmco004tab1Bean.setContract(service.queryContractByRowId(contractId));
				if(semmco004tab1Bean.getContract() != null){
					if(semmco004tab1Bean.getContract().getDutyPayStatus() == null){
						semmco004tab1Bean.getContract().setDutyPayStatus("00");
					}
					if(semmco004tab1Bean.getContract().getTotSendFlag() == null){
						semmco004tab1Bean.getContract().setTotSendFlag("Y");
					}
				}else{
					semmco004tab1Bean.setContract(new Contract());
					semmco004tab1Bean.getContract().setDutyPayStatus("00");
					semmco004tab1Bean.getContract().setTotSendFlag("Y");
				}
				semmco004Bean.setCreateBy(semmco004tab1Bean.getContract().getCreateBy());
				semmco004Bean.setUpdateBy(semmco004tab1Bean.getContract().getUpdateBy());
				semmco004Bean.setCreateDate(semmco004tab1Bean.getContract().getCreateDt());
				semmco004Bean.setUpdateDate(semmco004tab1Bean.getContract().getUpdateDt());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco004tab1Bean(semmco004tab1Bean);
		setSemmco004Bean(semmco004Bean);
		
	}

	private void getSiteInfo() {
		semmco004Bean = getSemmco004Bean();
		semmco004tab1Bean = getSemmco004tab1Bean();
		try{
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			if(semmco004Bean.getSiteInfoParam() != null && !semmco004Bean.getSiteInfoParam().equals("")){
				SiteInfo siteInfo = service.querySiteInfoByRowId(semmco004Bean.getSiteInfoParam());
				if(siteInfo != null){
					semmco004tab1Bean.setSiteInfo(siteInfo);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco004Bean(semmco004Bean);
		setSemmco004tab1Bean(semmco004tab1Bean);
		
	}

	private void searchContractStatusHistory() {
		semmco004tab1Bean = getSemmco004tab1Bean();
		List<Mco004SrchStatusSP> to = null;
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			Mco004SrchStatusSP criteria = new Mco004SrchStatusSP();
			criteria.setContractId(getSemmco004Bean().getContractIdParam());
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
			semmco004tab1Bean.setContractStatusHistoryList(list);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco004tab1Bean(semmco004tab1Bean);
	}
	
	private void checkAddAbleContractStatus() {
		semmco004tab1Bean = getSemmco004tab1Bean();
		List<Mco001CheckAddAbleSP> to = null;
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			Mco001CheckAddAbleSP criteria = new Mco001CheckAddAbleSP();
			criteria.setContractId(getSemmco004Bean().getContractIdParam());
//			String screenName = getSemmco004Bean().getScreenName();
//			if(screenName != null && screenName.equals("LEGAL")){
//				criteria.setRole("LEGAL");
//			}else{
				criteria.setRole("CONTRACT");
//			}
			to = service.querySPList(EQueryName.SP_MCO001_CHK_ADDABLE.name, criteria);
			if(to != null && to.size() > 0){
				Mco001CheckAddAbleSP addAble = to.get(0);
				if(addAble.getAddAbleFlag() != null && addAble.getAddAbleFlag().equals("Y")){
					semmco004tab1Bean.setRenderedAddHistory(true);
				}else{
					semmco004tab1Bean.setRenderedAddHistory(false);
				}
				
				if(addAble.getEditAbleFlag() != null && addAble.getEditAbleFlag().equals("Y")){
					semmco004tab1Bean.setRenderedUpdateHistory(true);
				}else{
					semmco004tab1Bean.setRenderedUpdateHistory(false);
				}
				
				if(addAble.getDeleteAbleFlag() != null && addAble.getDeleteAbleFlag().equals("Y")){
					semmco004tab1Bean.setRenderedDeleteHistory(true);
				}else{
					semmco004tab1Bean.setRenderedDeleteHistory(false);
				}
				
				if(addAble.getEditDutyFlag() != null && addAble.getEditDutyFlag().equals("Y")){
					semmco004tab1Bean.setRenderedEditDuty(true);
				}else{
					semmco004tab1Bean.setRenderedEditDuty(false);
				}
				
				if(addAble.getEditTotFlag() != null && addAble.getEditTotFlag().equals("Y")){
					semmco004tab1Bean.setRenderedEditTot(true);
				}else{
					semmco004tab1Bean.setRenderedEditTot(false);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco004tab1Bean(semmco004tab1Bean);
	}

	private boolean doClearContractStatusHistory() {
		boolean flag = false;
		semmco004Bean = getSemmco004Bean();
		semmco004tab1Bean = getSemmco004tab1Bean();
		semmco004tab1Bean.setContractStatus(new ContractStatus());
		semmco004tab1Bean.getContractStatus().setContractStatus("");
		semmco004tab1Bean.getContractStatus().setRemark("");
		semmco004tab1Bean.getContractStatus().setChangeStatusDt(new Date());
		semmco004tab1Bean.setDisabledBtnAddContractStatusHistory(false);
		semmco004tab1Bean.setDisabledBtnUpdateContractStatusHistory(true);
		semmco004Bean.setChkContractLost(false);
		setSemmco004Bean(semmco004Bean);
		setSemmco004tab1Bean(semmco004tab1Bean);
		return flag;
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmco004tab1Bean().setTmpRowId(rowId);
	}
	
	public void doUpdateTab1() {
		semmco004tab1Bean = getSemmco004tab1Bean();
		semmco004Bean = getSemmco004Bean();
		try{
			if(validateTabUpdate()){
				this.updateContract();
				this.updateSiteInfo();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		semmco004Bean.setRenderedMsgFormTop(true);
		semmco004tab1Bean.setRenderedMsgFormMiddle(false);
		setSemmco004Bean(semmco004Bean);
		setSemmco004tab1Bean(semmco004tab1Bean);
	}
	
	private void updateContract() {
		semmco004tab1Bean = getSemmco004tab1Bean();
		semmco004Bean = getSemmco004Bean();
		try{
			ISiteContractService service = (ISiteContractService)getBean("siteContractService");
			Contract con = service.queryContractByRowId(getSemmco004Bean().getContractIdParam());
			if(con != null){
				if(semmco004Bean.getTabNo().equals("1")){
					con.setDutyAmt(semmco004tab1Bean.getContract().getDutyAmt());
					con.setCopyDuty(semmco004tab1Bean.getContract().getCopyDuty());
					con.setCopyDutyAmt(semmco004tab1Bean.getContract().getCopyDutyAmt());
					con.setDutyPayDt(semmco004tab1Bean.getContract().getDutyPayDt());
					con.setOtherDutyAmt(semmco004tab1Bean.getContract().getOtherDutyAmt());
					con.setDutyPayStatus(semmco004tab1Bean.getContract().getDutyPayStatus());
					con.setContractRoom(semmco004tab1Bean.getContract().getContractRoom());
					con.setContractShelf(semmco004tab1Bean.getContract().getContractShelf());
					//Adding by mr.John from (mr.Surasit)
					con.setReceivePersonCode(semmco004tab1Bean.getContract().getReceivePersonCode());
					con.setCreatePersonCode(semmco004tab1Bean.getContract().getCreatePersonCode());
				}
				if(semmco004Bean.getTabNo().equals("2")){
					con.setTotSendFlag(semmco004tab1Bean.getContract().getTotSendFlag());
					if(semmco004tab1Bean.getContract().getTotSendFlag().equals("N")){
						con.setTotRemarkNotSend(semmco004tab1Bean.getContract().getTotRemarkNotSend());
					}else{
						con.setTotRemarkNotSend(null);
					}
				}
				con.setCurrentUser(semmco004tab1Bean.getUserLogin());
				semmco004tab1Bean.setContract(service.updateContract(con));
				semmco004Bean.setCreateBy(semmco004tab1Bean.getContract().getCreateBy());
				semmco004Bean.setUpdateBy(semmco004tab1Bean.getContract().getUpdateBy());
				semmco004Bean.setCreateDate(semmco004tab1Bean.getContract().getCreateDt());
				semmco004Bean.setUpdateDate(semmco004tab1Bean.getContract().getUpdateDt());
				addMessageInfo("M0001");
			}
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		setSemmco004Bean(semmco004Bean);
		setSemmco004tab1Bean(semmco004tab1Bean);
		
	}

	private void updateSiteInfo() {
		semmco004tab1Bean = getSemmco004tab1Bean();
		try{
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			if(semmco004tab1Bean.getSiteInfo() != null){
				semmco004tab1Bean.getSiteInfo().setCurrentUser(semmco004tab1Bean.getUserLogin());
				semmco004tab1Bean.setSiteInfo(service.updateSiteInfo(semmco004tab1Bean.getSiteInfo()));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco004tab1Bean(semmco004tab1Bean);
		
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
		SEMMCO004Tab1Bean semmco004tab1Bean = new SEMMCO004Tab1Bean();
		semmco004tab1Bean.setRightAmphurList(getEmptyDropDown());
		semmco004tab1Bean.setContract(new Contract());
		semmco004tab1Bean.setSiteInfo(new SiteInfo());
		semmco004tab1Bean.setContractStatus(new ContractStatus());
		semmco004tab1Bean.setContractStatusHistoryList(new ArrayList<Mco004SrchStatusSP>());
		semmco004tab1Bean.setBorrowOfficerList(getLovItemsByType(ELovType.T_CO_BORROW_OFFICER.name));
		setSemmco004tab1Bean(semmco004tab1Bean);
		
	}

	private SEMMCO004Tab1Bean semmco004tab1Bean;
	
	public SEMMCO004Tab1Bean getSemmco004tab1Bean() {
		return (SEMMCO004Tab1Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco004tab1Bean");
	}
	
	public void setSemmco004tab1Bean(SEMMCO004Tab1Bean semmco004tab1Bean) {
		this.semmco004tab1Bean = semmco004tab1Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco004tab1Bean", this.semmco004tab1Bean);
	}

	private SEMMCO004Bean semmco004Bean;
	
	public SEMMCO004Bean getSemmco004Bean() {
		return (SEMMCO004Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco004Bean");
	}

	public void setSemmco004Bean(SEMMCO004Bean semmco004Bean) {
		this.semmco004Bean = semmco004Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco004Bean", this.semmco004Bean);
	}

	private SEMMCO004Action semmco004Action;
	
	public SEMMCO004Action getSemmco004Action() {
		if(semmco004Action == null){
			semmco004Action = new SEMMCO004Action();
		}
		return semmco004Action;
	}

	public void setSemmco004Action(SEMMCO004Action semmco004Action) {
		this.semmco004Action = semmco004Action;
	}
	
	private boolean validateTabUpdate(){
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemmco004tab1Bean().getContract().getDutyPayStatus())){
			addMessageError("W0001", msg("message.dutyAmt"));
			flgValid = false;
		}
		
		if(getSemmco004tab1Bean().getContract().getDutyPayStatus().equals("01")
		   && getSemmco004tab1Bean().getContract().getDutyPayDt() == null){
			addMessageError("W0001", msg("export.col.requestDtFrom"));
			flgValid = false;
		}
		return flgValid;
	}
	
	public void doUpdateTab2(){
		semmco004tab1Bean = getSemmco004tab1Bean();
		semmco004Bean = getSemmco004Bean();
		try{
			if(validateTab2()){
				this.updateContract();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		semmco004Bean.setRenderedMsgFormTop(true);
		semmco004tab1Bean.setRenderedMsgFormMiddle(false);
		setSemmco004Bean(semmco004Bean);
		setSemmco004tab1Bean(semmco004tab1Bean);
	}
	
	private boolean validateTab2(){
		boolean flgValid = true;
		if("N".equals(getSemmco004tab1Bean().getContract().getTotSendFlag())){
			if(StringUtils.isEmpty(getSemmco004tab1Bean().getContract().getTotRemarkNotSend())){
				addMessageError("W0001", msg("message.notSendRemark"));
				flgValid = false;
			}
		}
		return flgValid;
	}
	
	public void clickDutyPay(){
		semmco004tab1Bean = getSemmco004tab1Bean();
		if (StringUtils.equalsIgnoreCase("01", semmco004tab1Bean.getContract().getDutyPayStatus())){
			semmco004tab1Bean.getContract().setDutyPayDt(new Date());
		} else{
			semmco004tab1Bean.getContract().setDutyPayDt(null);
		}
		setSemmco004tab1Bean(semmco004tab1Bean);
	}
}
