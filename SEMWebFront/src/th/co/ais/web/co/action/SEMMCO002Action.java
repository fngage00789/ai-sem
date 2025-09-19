package th.co.ais.web.co.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;

import com.sun.rowset.internal.Row;

import th.co.ais.domain.co.ContractStatus;
import th.co.ais.domain.co.Mco001CheckAddAbleSP;
import th.co.ais.domain.co.Mco001ContractStatusSP;
import th.co.ais.domain.co.Mco001SeqStatusSP;
import th.co.ais.domain.co.Mco001SrchLovStatusSP;
import th.co.ais.domain.co.Mco001SrchStatusSP;
import th.co.ais.domain.co.Mco001UpdateStatusSP;
import th.co.ais.domain.co.Mco002CheckNoFileSP;
import th.co.ais.domain.co.Mco002DefaultDutySP;
import th.co.ais.domain.co.Mco002SrchContractStatusSP;
import th.co.ais.domain.co.Mco002SrchNoFoundSP;
import th.co.ais.domain.co.Mco002UpdateContractStatusSP;
import th.co.ais.domain.si.Contract;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.co.IContractCheckDocService;
import th.co.ais.service.co.IContractStatusService;
import th.co.ais.service.si.ISiteContractService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.co.bean.SEMMCO002Bean;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.RegionCacheUtil;

public class SEMMCO002Action extends AbstractAction{

	private static final long serialVersionUID = 5934806069385322547L;

	private Logger log = Logger.getLogger(getClass());
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if (methodWithNavi.equalsIgnoreCase("doSearch")) {
			flag = doSearch();
		}
		if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();
		}
		if (methodWithNavi.equalsIgnoreCase("pageLoad")) {
			flag = pageLoad();
		}
		if (methodWithNavi.equalsIgnoreCase("initAddContractStatus")) {
			flag = initAddContractStatus();
		}
		if(methodWithNavi.equalsIgnoreCase("doSaveContractStatus")){
			flag = doSaveContractStatus();
		}
		if(methodWithNavi.equalsIgnoreCase("initUpdateContractStatus")){
			flag = initUpdateContractStatus();
		}
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
		if(methodWithNavi.equalsIgnoreCase("initUpdateDuty")){
			flag = initUpdateDuty();
		}
		if(methodWithNavi.equalsIgnoreCase("doUpdateDutyContract")){
			flag = doUpdateDutyContract();
		}
		

		return flag;
	}


	private boolean doUpdateDutyContract() {
		boolean flag = false;
		semmco002Bean = getSemmco002Bean();
		log.info("doUpdateDutyContract");
		if(!validateDuty()){
			log.info("validateDuty");
			semmco002Bean.setRenderedMsgFormSearch(true);
			return flag;
		}
		try{
			ISiteContractService service = (ISiteContractService)getBean("siteContractService");
			if(semmco002Bean.getContract() != null){
				log.info("starting updateContract...");
				semmco002Bean.getContract().setCurrentUser(semmco002Bean.getUserLogin());
				semmco002Bean.setContract(service.updateContract(semmco002Bean.getContract()));
				semmco002Bean.setPopupClose(true);
				semmco002Bean.setRenderedMsgFormSearch(true);
				log.info("end updateContract...");
				log.info("starting doSearch...");
				this.doSearch();
				log.info("end doSearch...");
				addMessageInfo("M0001");
			}
		}catch(Exception e){
			log.info("Exception in doUpdateDutyContract()...");
			e.printStackTrace();
			addMessageError("E0001");
		}
		
		setSemmco002Bean(semmco002Bean);
		return flag;
	}

	private boolean validateDuty(){
		boolean flgValid = true;
		if("01".equals(semmco002Bean.getContract().getDutyPayStatus())){
			if(semmco002Bean.getContract().getDutyAmt() == null || semmco002Bean.getContract().getDutyAmt() < 0){
				addMessageError("W0001", msg("message.dutyAmt"));
				flgValid = false;
			}
			
			if(semmco002Bean.getContract().getDutyPayDt() == null){
				addMessageError("W0001", msg("export.col.requestDtFrom"));
				flgValid = false;
			}
		}
		
		return flgValid;
	}

	private boolean initUpdateDuty() {
		boolean flag = false;
		semmco002Bean = getSemmco002Bean();
		try{
			String rowId = (String)getFacesUtils().getRequestParameter("rowId");
			String siteInfoId = (String)getFacesUtils().getRequestParameter("siteInfoId");
			if(rowId != null){
				ISiteContractService service = (ISiteContractService)getBean("siteContractService");
				Contract contract = service.queryContractByRowId(rowId);
				semmco002Bean.setContract(contract);
				if(contract.getDutyAmt() == null && contract.getDutyPayDt() == null &&
						contract.getCopyDuty() == null && contract.getCopyDutyAmt() == null){
					// SEM_SP_MCO002_DEFUALT_DUTY
					List<Mco002DefaultDutySP> to = null;
					Mco002DefaultDutySP criteria = new Mco002DefaultDutySP();
					criteria.setSiteInfoId(siteInfoId);
					to = service.querySPList(EQueryName.SP_MCO002_DEFAULT_DUTY.name, criteria);
					if(to != null && !to.isEmpty()){
						Mco002DefaultDutySP def = to.get(0);
						semmco002Bean.getContract().setDutyAmt(def.getDutyAmt());
						semmco002Bean.getContract().setCopyDuty(def.getCopyDuty());
						semmco002Bean.getContract().setCopyDutyAmt(def.getCopyDutyAmt());
//						if(def.getDutyPayDate() != null) semmco002Bean.getContract().setDutyPayDt(convertYearENtoTH(def.getDutyPayDate()));
					}
				}
				
				if(semmco002Bean.getContract().getDutyPayStatus() == null){
					semmco002Bean.getContract().setDutyPayStatus("00");
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco002Bean(semmco002Bean);
		//Adding by mr.john 21/04/2011 from SA (Surasit).
		checkAddAbleContractStatus();
		return flag;
	}


	private boolean doDeleteContractStatusHistory() {
		boolean flag = false;
		semmco002Bean = getSemmco002Bean();
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		try{
			if(semmco002Bean.getContractStatus() != null){
				service.deleteContractStatus(semmco002Bean.getContractStatus());
				addMessageInfo("M0002");
				// update site contract
				this.updateSiteContract();
				this.doClearContractStatusHistory();
				// do search contract status history
				this.searchContractStatusHistory();
				this.doSearch();
			}
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0002");
		}
		semmco002Bean.setRenderedMsgFormSearchPopup(true);
		setSemmco002Bean(semmco002Bean);
		return flag;
	}

	private boolean doClearContractStatusHistory() {
		boolean flag = false;
		semmco002Bean = getSemmco002Bean();
		semmco002Bean.setContractStatus(new ContractStatus());
		semmco002Bean.getContractStatus().setContractStatus("");
		semmco002Bean.getContractStatus().setChangeStatusDt(new Date());
		semmco002Bean.getContractStatus().setRemark("");
		semmco002Bean.setDisabledBtnAddContractStatusHistory(false);
		semmco002Bean.setDisabledBtnUpdateContractStatusHistory(true);
		setSemmco002Bean(semmco002Bean);
		return flag;
	}

	private boolean doUpdateContractStatusHistory() {
		boolean flag = false;
		semmco002Bean = getSemmco002Bean();
		if(!validateUpdateContractStatus("doAdd")){
			semmco002Bean.setRenderedMsgFormSearch(false);
			semmco002Bean.setRenderedMsgFormMiddle(true);
			setSemmco002Bean(semmco002Bean);
			return flag;
		}
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			ISiteContractService conService = (ISiteContractService)getBean("siteContractService");
			
			semmco002Bean.getContractStatus().setCurrentUser(semmco002Bean.getUserLogin());
			service.updateContractStatus(semmco002Bean.getContractStatus());
			addMessageInfo("M0001");
			
			Contract contract = conService.updateContract(semmco002Bean.getContract());
			semmco002Bean.setContract(contract);
			// update site contract
			this.updateSiteContract();
			// do search contract status history
			this.searchContractStatusHistory();
			this.doClearContractStatusHistory();
			this.doSearch();
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		semmco002Bean.setRenderedMsgFormSearchPopup(true);
		setSemmco002Bean(semmco002Bean);
		return flag;
	}

	private void updateSiteContract() {
		semmco002Bean = getSemmco002Bean();
		List<Mco001UpdateStatusSP> to = null;
		try{
			ISiteContractService service = (ISiteContractService)getBean("siteContractService");
			Mco001UpdateStatusSP status = new Mco001UpdateStatusSP();
			status.setContractId(semmco002Bean.getContractId());
			status.setCurrentUser(semmco002Bean.getUserLogin());
			
			to = service.querySPList(EQueryName.SP_MCO001_UPD_STATUS.name, status);
			if(to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")){
				log.debug("update site contract result [" + to.get(0).getResultMsg());
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		setSemmco002Bean(semmco002Bean);
		
	}

	/*
	private boolean doAddContractStatusHistory() {
		boolean flag = false;
		semmco002Bean = getSemmco002Bean();
		if(!validateUpdateContractStatus()){
			semmco002Bean.setRenderedMsgFormSearch(false);
			semmco002Bean.setRenderedMsgFormMiddle(true);
			setSemmco002Bean(semmco002Bean);
			return flag;
		}
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		// add contract status
		try{
			semmco002Bean.getContractStatus().setContractId(semmco002Bean.getContractId());
			semmco002Bean.getContractStatus().setCurrentUser(semmco002Bean.getUserLogin());
			semmco002Bean.getContractStatus().setSeqNo(this.getContractStatusSeqNo());
			service.createContractStatus(semmco002Bean.getContractStatus());
			addMessageInfo("M0001");
			// update site contract 
			this.updateSiteContract();
			// do search contract status history
			this.searchContractStatusHistory();
			this.doClearContractStatusHistory();
			this.doSearch();
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		semmco002Bean.setRenderedMsgFormSearch(false);
		semmco002Bean.setRenderedMsgFormMiddle(true);
		setSemmco002Bean(semmco002Bean);
		return flag;
	}
*/
	private boolean doAddContractStatusHistory() {
		boolean flag = false;
		semmco002Bean = getSemmco002Bean();
		if(!validateUpdateContractStatus("doAdd")){
			semmco002Bean.setRenderedMsgFormSearch(false);
			semmco002Bean.setRenderedMsgFormMiddle(true);
			setSemmco002Bean(semmco002Bean);
			return flag;
		}
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		// add contract status
		try{
			List<Mco002UpdateContractStatusSP> to = null;
			Mco002UpdateContractStatusSP contract = new Mco002UpdateContractStatusSP();
			contract.setContractId(semmco002Bean.getContractId());
			contract.setContractStatus(semmco002Bean.getContractStatus().getContractStatus());
			contract.setChangeStatusDate(semmco002Bean.getContractStatus().getChangeStatusDt());
			contract.setRemark(semmco002Bean.getContractStatus().getRemark());
			contract.setCurrentUser(semmco002Bean.getUserLogin());
			contract.setCompany(semmco002Bean.getCompany());
			//Adding by mr.John from (mr.Surasit) 27/04/2011
			contract.setReceivePersonCode(semmco002Bean.getContract().getReceivePersonCode());
			contract.setCreatePersonCode(semmco002Bean.getContract().getCreatePersonCode());
			to = service.querySPList(EQueryName.SP_MCO002_UPD_STATUS_LIST.name, contract);
				
			if(to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")){
				semmco002Bean.setPopupClose(true);
				addMessageInfo("M0001");
			}
			// do search contract status history
			this.searchContractStatusHistory();
			this.doClearContractStatusHistory();
			this.doSearch();
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		semmco002Bean.setRenderedMsgFormSearch(false);
		semmco002Bean.setRenderedMsgFormMiddle(true);
		setSemmco002Bean(semmco002Bean);
		return flag;
	}
	private Integer getContractStatusSeqNo() {
		// SEM_SP_MCO001_SEQ_STATUS (parameter = contractId)
		semmco002Bean = getSemmco002Bean();
		ISiteContractService service = (ISiteContractService)getBean("siteContractService");
		List<Mco001SeqStatusSP> to = null;
		Integer seqNo = 0;
		try{
			Mco001SeqStatusSP criteria = new Mco001SeqStatusSP();
			criteria.setRowId(semmco002Bean.getContractId());
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

	private boolean initUpdateContractStatusHistory() {
		boolean flag = false;
		semmco002Bean = getSemmco002Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		ISiteContractService conService = (ISiteContractService)getBean("siteContractService");
		try{
			if(rowId != null){
				semmco002Bean.setContractStatus(service.queryContractStatusByRowId(rowId));
				semmco002Bean.setContract(conService.queryContractByRowId(semmco002Bean.getContractId()));
				semmco002Bean.setDisabledBtnAddContractStatusHistory(true);
				semmco002Bean.setDisabledBtnUpdateContractStatusHistory(false);
				semmco002Bean.setRenderedAddHistory(true);
				this.updateContractStatusList(rowId);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		setSemmco002Bean(semmco002Bean);
		return flag;
	}
	
	private void updateContractStatusList(String rowId) {
		semmco002Bean = getSemmco002Bean();
		List<Mco001SrchLovStatusSP> to = null;
		List<SelectItem> selList = new LinkedList<SelectItem>();
		SelectItem selItem = null;
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			Mco001SrchLovStatusSP criteria = new Mco001SrchLovStatusSP();
			criteria.setContractId(semmco002Bean.getContractId());
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
				semmco002Bean.setContractStatusList(selList);
			}else{
				semmco002Bean.setContractStatusList(getEmptyDropDown());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco002Bean(semmco002Bean);
		
	}

	private boolean initDeleteContractStatusHistory() {
		boolean flag = false;
		semmco002Bean = getSemmco002Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		try{
			if(rowId != null){
				semmco002Bean.setContractStatus(service.queryContractStatusByRowId(rowId));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco002Bean(semmco002Bean);
		return flag;
	}

	private boolean initUpdateContractStatus() {
		boolean flag = false;
		semmco002Bean = getSemmco002Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		String company = (String)getFacesUtils().getRequestParameter("company");
		semmco002Bean.setContractId(rowId);
		semmco002Bean.setCompany(company);
		this.doClearContractStatusHistory();
		this.searchContractStatusHistory();
		setSemmco002Bean(semmco002Bean);
		return flag;
	}

	private void getContractStatusListByContractId() {
		semmco002Bean = getSemmco002Bean();
		List<Mco001SrchLovStatusSP> to = null;
		List<SelectItem> selList = new LinkedList<SelectItem>();
		SelectItem selItem = null;
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			Mco001SrchLovStatusSP criteria = new Mco001SrchLovStatusSP();
			criteria.setContractId(semmco002Bean.getContractId());
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
				semmco002Bean.setContractStatusList(selList);
			}else{
				semmco002Bean.setContractStatusList(getEmptyDropDown());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco002Bean(semmco002Bean);
		
	}


	private void searchContractStatusHistory() {
		semmco002Bean = getSemmco002Bean();
		List<Mco001SrchStatusSP> to = null;
		semmco002Bean.setContractStatusHistoryList(null);
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			Mco001SrchStatusSP criteria = new Mco001SrchStatusSP();
			criteria.setContractId(semmco002Bean.getContractId());
			to = service.querySPList(EQueryName.SP_MCO001_SRCH_STATUS.name, criteria);
			List<Mco001SrchStatusSP> list = new ArrayList<Mco001SrchStatusSP>();
			// check add able
			this.checkAddAbleContractStatus();
			if(to != null && to.size() > 0){
				int index = 0;
				for(Mco001SrchStatusSP status : to){
					index++;
					if(status.getChangeStatusDate() != null) status.setChangeStatusDate(convertYearENtoTH(status.getChangeStatusDate()));
					// check last record;
					if(index == to.size()){
						status.setLastRecord(true);
					}else{
						status.setLastRecord(false);
					}
					list.add(status);
				}
			}
			
			semmco002Bean.setContractStatusHistoryList(list);
			// get drop down list contract status
			this.getContractStatusListByContractId();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco002Bean(semmco002Bean);
	}

	private void checkAddAbleContractStatus() {
		semmco002Bean = getSemmco002Bean();
		List<Mco001CheckAddAbleSP> to = null;
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			Mco001CheckAddAbleSP criteria = new Mco001CheckAddAbleSP();
			criteria.setContractId(semmco002Bean.getContractId());
			criteria.setRole("CONTRACT");
			to = service.querySPList(EQueryName.SP_MCO001_CHK_ADDABLE.name, criteria);
			if(to != null && to.size() > 0){
				Mco001CheckAddAbleSP addAble = to.get(0);
				if(addAble.getAddAbleFlag() != null && addAble.getAddAbleFlag().equals("Y")){
					semmco002Bean.setRenderedAddHistory(true);
				}else{
					semmco002Bean.setRenderedAddHistory(false);
				}
				
				if(addAble.getEditAbleFlag() != null && addAble.getEditAbleFlag().equals("Y")){
					semmco002Bean.setRenderedUpdateHistory(true);
				}else{
					semmco002Bean.setRenderedUpdateHistory(false);
				}
				
				if(addAble.getDeleteAbleFlag() != null && addAble.getDeleteAbleFlag().equals("Y")){
					semmco002Bean.setRenderedDeleteHistory(true);
				}else{
					semmco002Bean.setRenderedDeleteHistory(false);
				}
				//Adding by mr.john 21/04/2011 from SA (Surasit)
				if(addAble.getEditDutyFlag() != null && addAble.getEditDutyFlag().equals("Y")){
					semmco002Bean.setDisabledBtnExportDuty(true);
				}else{
					semmco002Bean.setDisabledBtnExportDuty(false);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco002Bean(semmco002Bean);
		
	}


	private boolean doSaveContractStatus() {
		boolean flag = false;
		semmco002Bean = getSemmco002Bean();
		if(!validateUpdateContractStatus("doSave")){
			semmco002Bean.setRenderedMsgFormSearchPopup(true);
			semmco002Bean.setRenderedMsgFormSearch(false);
			semmco002Bean.setPopupClose(false);
			setSemmco002Bean(semmco002Bean);
			return flag;
		}
		try{
			List<Mco002UpdateContractStatusSP> to = null;
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
				Mco002UpdateContractStatusSP contract = new Mco002UpdateContractStatusSP();
				contract.setContractId(semmco002Bean.getRowsIdConcat());
				contract.setContractStatus(semmco002Bean.getContractStatus().getContractStatus());
				contract.setChangeStatusDate(semmco002Bean.getContractStatus().getChangeStatusDt());
				contract.setRemark(semmco002Bean.getContractStatus().getRemark());
				contract.setCurrentUser(semmco002Bean.getUserLogin());
				contract.setCompany(semmco002Bean.getCompany());
				//Adding by mr.John from (mr.Surasit) 27/04/2011
				contract.setReceivePersonCode(semmco002Bean.getContract().getReceivePersonCode());
				contract.setCreatePersonCode(semmco002Bean.getContract().getCreatePersonCode());
				
				to = service.querySPList(EQueryName.SP_MCO002_UPD_STATUS_LIST.name, contract);
				
				if(to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")){
					semmco002Bean.setPopupClose(true);
					addMessageInfo("M0001");
				}
				
				// search contractStatus
				semmco002Bean.setContractStatusSPList(null);
				this.doSearch();
//			}
			
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		semmco002Bean.setRenderedMsgFormSearchPopup(false);
		semmco002Bean.setRenderedMsgFormSearch(true);
		setSemmco002Bean(semmco002Bean);
		return flag;
	}

	private boolean validateUpdateContractStatus(String method) {
		boolean flgValid = true;
		
		if(StringUtils.isEmpty(getSemmco002Bean().getContractStatus().getContractStatus())){
			addMessageError("W0001", msg("message.contractStatus"));
			flgValid = false;
		}else{
			// contract status = 03 (send legal) call SP_MCO002_CHK_NO_FILE
			if(getSemmco002Bean().getContractStatus().getContractStatus().equals("03")){
				// @contractId
				if(method.equals("doAdd")){
					if(!checkNoFile()){
						flgValid = false;
					}
				}else{
				// @contractIdList
					if(!checkNoFileList()){
						flgValid = false;
					}
				}
			}
		}
		
		if(getSemmco002Bean().getContractStatus().getChangeStatusDt() == null){
			addMessageError("W0001", msg("message.changeStatusDate"));
			flgValid = false;
		}
		
		return flgValid;
	}
	
	private boolean checkNoFile() {
		boolean flgValid = true;
		try{
			List<Mco002CheckNoFileSP> fileList = null;
			Mco002CheckNoFileSP criteria = new Mco002CheckNoFileSP();
			criteria.setContractId(getSemmco002Bean().getContractId());
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
	
	private boolean checkNoFileList() {
		boolean flgValid = true;
		try{
			List<Mco002CheckNoFileSP> fileList = null;
			Mco002CheckNoFileSP criteria = new Mco002CheckNoFileSP();
			criteria.setContractId(getSemmco002Bean().getRowsIdConcat());
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			fileList = service.querySPList(EQueryName.SP_MCO002_CHK_NO_FILE.name, criteria);
			if(fileList != null && fileList.size() > 0){
				if(fileList.get(0).getContractNo() != null){
					String contractNoConCat = "";
					for(Mco002CheckNoFileSP file : fileList){
						if(contractNoConCat.equals("")){
							contractNoConCat = file.getContractNo();
						}else{
							contractNoConCat = (contractNoConCat + ",".trim()+ file.getContractNo());
						}
					}
					log.debug("contractNoConCat [" + contractNoConCat + "]" );
					addMessageErrorWithArgument("W0088" ,contractNoConCat);
					flgValid = false;
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
			
		return flgValid;
	}

	public void selectAllRow(){
		semmco002Bean = getSemmco002Bean();
		try{
			boolean chkAll = getSemmco002Bean().isChkSelAll();
			List<WrapperBeanObject<Mco002SrchContractStatusSP>> contractList = new ArrayList<WrapperBeanObject<Mco002SrchContractStatusSP>>();
			contractList = getSemmco002Bean().getContractStatusSPList();
			
			for(int i = 0; i < contractList.size(); i++) {
				Mco002SrchContractStatusSP o = (Mco002SrchContractStatusSP)contractList.get(i).getDataObj();
				if(StringUtils.isNotEmpty(o.getRowId())){
					if(chkAll){
						if (semmco002Bean.getSelectedStatus().equals(o.getContractStatusName()) && chkAll) {
							contractList.get(i).setCheckBox(true);
						}else{
							contractList.get(i).setCheckBox(false);
						}
					}else{
						contractList.get(i).setDisableCheckBox(true);
						contractList.get(i).setCheckBox(false);
					}
				}
			}
			if(!chkAll){
				semmco002Bean.setDisableSelectAll(true);
				semmco002Bean.setSelectedStatus(null);
			}else{
				onRenderButton();
			}
			
		}catch(NullPointerException ne){
			// TODO
			
		}catch(Exception e){
			//TODO
		}
		setSemmco002Bean(semmco002Bean);
	}
	
	public void closePopup(){
		semmco002Bean = getSemmco002Bean();
		semmco002Bean.setRenderedMsgFormSearch(true);
		setSemmco002Bean(semmco002Bean);
	}
	
	
	public void onRenderButton() {
		semmco002Bean = getSemmco002Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		String status = (String)getFacesUtils().getRequestParameter("status");
		Boolean checked = new Boolean((String)getFacesUtils().getRequestParameter("checked"));
		
		semmco002Bean.setTmpRowId(rowId);
		
		setSelectRowWithSameStatus(status, checked);
		
		if (isCheckSELBox()) {
			semmco002Bean.setDisabledBtnAdd(false);
			semmco002Bean.setDisabledBtnExport(false);
			semmco002Bean.setDisabledBtnExportDuty(false);
		} else {
			semmco002Bean.setDisabledBtnAdd(true);
			semmco002Bean.setDisabledBtnExport(true);
			semmco002Bean.setDisabledBtnExportDuty(true);
		}
		setSemmco002Bean(semmco002Bean);
		
	}
	
	private boolean isCheckSELBox() {
		boolean isCheck = false;
		
		List<WrapperBeanObject<Mco002SrchContractStatusSP>> contractStatusList = getSemmco002Bean().getContractStatusSPList();
		for (WrapperBeanObject<Mco002SrchContractStatusSP> wrapperBeanObject : contractStatusList) {
			if (wrapperBeanObject.isCheckBox()) {
				return true;
			}
		}
		
		return isCheck;
	}
	
	private boolean initAddContractStatus() {
		boolean flag = false;
		semmco002Bean = getSemmco002Bean();
		semmco002Bean.setRowsIdConcat("");
		semmco002Bean.getContract().setReceivePersonCode("");
		semmco002Bean.getContract().setCreatePersonCode("");
		this.doClearPopupAddContractStatus();
		try{
			List<WrapperBeanObject<Mco002SrchContractStatusSP>> contractList = semmco002Bean.getContractStatusSPList();
			if(contractList != null && contractList.size() > 0){
				for(WrapperBeanObject<Mco002SrchContractStatusSP> contract : contractList){
					WrapperBeanObject<Mco002SrchContractStatusSP> tmpWrapperBean = new WrapperBeanObject<Mco002SrchContractStatusSP>();
					if(contract.isCheckBox()){
						Mco002SrchContractStatusSP temp = (Mco002SrchContractStatusSP)contract.getDataObj();
						if(semmco002Bean.getRowsIdConcat().equals("")){
							semmco002Bean.setRowsIdConcat(temp.getRowId());
							// get drop down contract status list by fist contractId
							semmco002Bean.setContractId(temp.getRowId());
							this.getContractStatusListByContractId();
						}else{
							semmco002Bean.setRowsIdConcat(semmco002Bean.getRowsIdConcat() +",".trim()+ temp.getRowId());
						}
						semmco002Bean.setCompany(temp.getCompany());
					}
				}
				semmco002Bean.setDisabledBtnAdd(false);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		checkAddAbleContractStatus();
		setSemmco002Bean(semmco002Bean);
		
		return flag;
	}

	private void doClearPopupAddContractStatus() {
		semmco002Bean = getSemmco002Bean();
		semmco002Bean.setContractStatus(new ContractStatus());
		semmco002Bean.getContractStatus().setContractStatus("");
		semmco002Bean.getContractStatus().setChangeStatusDt(new Date());
		semmco002Bean.getContractStatus().setRemark("");
		setSemmco002Bean(semmco002Bean);
	}


	private boolean doClear() {
		boolean flag = false;
		semmco002Bean = getSemmco002Bean();
		semmco002Bean.setCriteria(new Mco002SrchContractStatusSP());
		semmco002Bean.getCriteria().setCompany("");
		semmco002Bean.getCriteria().setReqType("");
		semmco002Bean.getCriteria().setContractNo("");
		semmco002Bean.setContractStatusSPList(new ArrayList<WrapperBeanObject<Mco002SrchContractStatusSP>>());
		semmco002Bean.setDisabledBtnAdd(true);
		semmco002Bean.setDisabledBtnExport(true);
		semmco002Bean.setDisabledBtnExportDuty(true);
		semmco002Bean.setChkSelAll(false);
		semmco002Bean.setRenderedMsgDataNotFound(false);
		semmco002Bean.setChkTerminateFlag(false);
		semmco002Bean.setRenderedTerminateFlag(false);
		setSemmco002Bean(semmco002Bean);
		this.setDisabledButton();
		
		return flag;
	}

	private void setDisabledButton() {
		semmco002Bean = getSemmco002Bean();
		semmco002Bean.setDisabledBtnAdd(true);
		semmco002Bean.setDisabledBtnExport(true);
		semmco002Bean.setDisabledBtnExportDuty(true);
		setSemmco002Bean(semmco002Bean);
	}


	private boolean pageLoad() {
		boolean flag = false;
		return flag;
	}
	
	private boolean doSearch() {
		boolean flag = false;
		semmco002Bean = getSemmco002Bean();
		if(!validateSearch()){
			log.info("validate Search pass");
			semmco002Bean.setRenderedMsgFormSearch(true);
			return flag;
		}
		List<Mco002SrchContractStatusSP> to = null;
		try{
			log.info("Starting Do Searching1 ...");
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			if(semmco002Bean.isChkTerminateFlag()){
				semmco002Bean.getCriteria().setTerminateFlag("Y");
			}else{
				semmco002Bean.getCriteria().setTerminateFlag(null);
			}
			
			String pico = "N";
			//Adding by mr.john 22/04/2011 from SA (Surasit)
			if(semmco002Bean.getCriteria().isPico()){
				pico = "Y";
			}else{
				pico = "N";
			}
			//set pico.
			semmco002Bean.getCriteria().setStrPico(pico);
			to = service.querySPList(EQueryName.SP_MCO002_SRCH.name, semmco002Bean.getCriteria());
			if(to == null || to.size() == 0){
				semmco002Bean.setRenderedMsgDataNotFound(true);
				semmco002Bean.setContractStatusSPList(null);
			}
			if(to != null && to.size() > 0){
				semmco002Bean.setRenderedMsgDataNotFound(false);
				semmco002Bean.setContractStatusSPList(new ArrayList<WrapperBeanObject<Mco002SrchContractStatusSP>>());
				for (int i = 0; i < to.size(); i++) {
					Mco002SrchContractStatusSP contract = to.get(i);
					if(contract != null){
						WrapperBeanObject<Mco002SrchContractStatusSP> tmpWrapperBean = new WrapperBeanObject<Mco002SrchContractStatusSP>();
//						if(contract.getEffDate() != null) contract.setEffDate(convertYearENtoTH(contract.getEffDate()));
//						if(contract.getExpDate() != null) contract.setExpDate(convertYearENtoTH(contract.getExpDate()));
//						if(contract.getD1() != null) contract.setD1(convertYearENtoTH(contract.getD1()));
//						if(contract.getD2() != null) contract.setD2(convertYearENtoTH(contract.getD2()));
//						if(contract.getD3() != null) contract.setD3(convertYearENtoTH(contract.getD3()));
//						if(contract.getD4() != null) contract.setD4(convertYearENtoTH(contract.getD4()));
//						if(contract.getD5() != null) contract.setD5(convertYearENtoTH(contract.getD5()));
//						if(contract.getD6() != null) contract.setD6(convertYearENtoTH(contract.getD6()));
//						if(contract.getD7() != null) contract.setD7(convertYearENtoTH(contract.getD7()));
//						if(contract.getD8() != null) contract.setD8(convertYearENtoTH(contract.getD8()));
						log.debug("convertYearENtoTHStr(contract.getEffDate()) = "+convertYearENtoTHStr(contract.getEffDate()));
						log.debug("convertYearENtoTHStr(contract.getExpDate()) = "+convertYearENtoTHStr(contract.getExpDate()));
						
						if(contract.getEffDate() != null) contract.setEffDtStr(convertYearENtoTHStr(contract.getEffDate()));
						if(contract.getExpDate() != null) contract.setExpDtStr(convertYearENtoTHStr(contract.getExpDate()));
						if(contract.getD1() != null) contract.setD1Str1(convertYearENtoTHStr(contract.getD1()));
						if(contract.getD2() != null) contract.setD2Str(convertYearENtoTHStr(contract.getD2()));
						if(contract.getD3() != null) contract.setD3Str(convertYearENtoTHStr(contract.getD3()));
						if(contract.getD4() != null) contract.setD4Str(convertYearENtoTHStr(contract.getD4()));
						if(contract.getD5() != null) contract.setD5Str(convertYearENtoTHStr(contract.getD5()));
						if(contract.getD6() != null) contract.setD6Str(convertYearENtoTHStr(contract.getD6()));
						if(contract.getD7() != null) contract.setD7Str(convertYearENtoTHStr(contract.getD7()));
						if(contract.getD8() != null) contract.setD8Str(convertYearENtoTHStr(contract.getD8()));
						if(contract.getD9() != null) contract.setD9Str(convertYearENtoTHStr(contract.getD9()));
						log.debug("contract.getEffDateStr() = "+contract.getEffDateStr());
						log.debug("contract.getExpDateStr() = "+contract.getExpDateStr());
						
						tmpWrapperBean.setDataObj(contract);
						tmpWrapperBean.setMessage("");
						tmpWrapperBean.setCheckBox(false);
						semmco002Bean.getContractStatusSPList().add(tmpWrapperBean);
						
					}
				}
				
				log.info("Starting Do Searching2 ...");
				// call SEM_SP_MCO002_SRCH_NO_FOUND
				List<Mco002SrchNoFoundSP> list = null;
				Mco002SrchNoFoundSP criteria = new Mco002SrchNoFoundSP();
				criteria.setCompany(semmco002Bean.getCriteria().getCompany());
				criteria.setReqType(semmco002Bean.getCriteria().getReqType());
				criteria.setContractNo(semmco002Bean.getCriteria().getContractNo());
				criteria.setRegion(semmco002Bean.getCriteria().getRegion());
				criteria.setContractStatus(semmco002Bean.getCriteria().getContractStatus());
				
				//Adding by mr.john
				criteria.setReceiveDateFrom(semmco002Bean.getCriteria().getReceiveDateFrom());
				criteria.setReceiveDateTo(semmco002Bean.getCriteria().getReceiveDateTo());
				criteria.setTerminateFlag(semmco002Bean.getCriteria().getTerminateFlag());
				criteria.setStrPico(pico);
				
				list = service.querySPList(EQueryName.SP_MCO002_SRCH_NO_FOUND.name, criteria);
				if(list != null && list.size() > 0){
					String contractNoConCat = "";
					for(Mco002SrchNoFoundSP contractSearch : list){
						if(contractNoConCat.equals("")){
							contractNoConCat = contractSearch.getContractNo();
						}else{
							contractNoConCat = (contractNoConCat + ",".trim()+ contractSearch.getContractNo());
						}
					}
					log.info("contractNoConCat [" + contractNoConCat + "]" );
					addMessageErrorWithArgument("W0087" ,contractNoConCat);
					semmco002Bean.setRenderedMsgFormSearch(true);
				}
				
				this.setDisabledButton();
			}
			
		}catch(Exception e){
			log.info("Exception doSearch() ...");
			e.printStackTrace();
		}
		setSemmco002Bean(semmco002Bean);
		return flag;
	}
	

	private boolean validateSearch() {
		boolean flgValid = true;
		
		if(StringUtils.isEmpty(getSemmco002Bean().getCriteria().getContractNo()) &&
				StringUtils.isEmpty(getSemmco002Bean().getCriteria().getCompany()) &&
				StringUtils.isEmpty(getSemmco002Bean().getCriteria().getLocationId())){
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		/*if(StringUtils.isEmpty(getSemmco002Bean().getCriteria().getReqType())){
			addMessageError("W0001", msg("message.reqType"));
			flgValid = false;
		}*/
		/*if(StringUtils.isEmpty(getSemmco002Bean().getCriteria().getContractNo())){
			addMessageError("W0001", msg("message.contractNo"));
			flgValid = false;
		}*/
		return flgValid;
	}

	@Override
	public void clearSessionNotUsed() {
	}

	@Override
	public void init() {
		SEMMCO002Bean semmco002Bean = new SEMMCO002Bean();
		semmco002Bean.setCriteria(new Mco002SrchContractStatusSP());
		semmco002Bean.setContract(new Contract());
		semmco002Bean.setContractStatusSPList(new ArrayList<WrapperBeanObject<Mco002SrchContractStatusSP>>());
		semmco002Bean.setReqTypeList(getLovItemsByType(ELovType.T_CO_CONTRACT_STATUS_REQ_TYPE.name));
		semmco002Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmco002Bean.setContractStatusList(getLovItemsByType(ELovType.T_CO_CONTRACT_STATUS.name));
		semmco002Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		semmco002Bean.setContractStatList(getEmptyDropDown());
		semmco002Bean.setRenderedMsgFormSearch(false);
		semmco002Bean.setRenderedMsgFormSearchPopup(false);
		semmco002Bean.setChkTerminateFlag(false);
		semmco002Bean.setRenderedTerminateFlag(false);
		semmco002Bean.setBorrowOfficerList(getLovItemsByType(ELovType.T_CO_BORROW_OFFICER.name));
		setSemmco002Bean(semmco002Bean);
		this.setDisabledButton();
		
	}
	
	public void renderCompany(){
		semmco002Bean = getSemmco002Bean();
		String company = semmco002Bean.getCriteria().getCompany();
		if(company != null && !company.equals("")){
			try {
				semmco002Bean.setContractStatusList(getContractStatusSPList());
				semmco002Bean.setContractStatList(getContractStatusSPList());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			semmco002Bean.setContractStatusList(getEmptyDropDown());
			semmco002Bean.setContractStatList(getEmptyDropDown());
		}
		setSemmco002Bean(semmco002Bean);
	}
	
	public void renderTerminateFlag(){
		semmco002Bean = getSemmco002Bean();
		String reqType = semmco002Bean.getCriteria().getReqType();
		//if(reqType != null && reqType.equals("04")){
		if(reqType != null && reqType.equals("99")){
			semmco002Bean.setRenderedTerminateFlag(true);
		}else{
 			semmco002Bean.setRenderedTerminateFlag(false);
		}
		semmco002Bean.setChkTerminateFlag(false);
		setSemmco002Bean(semmco002Bean);
	}
	
	private List<SelectItem> getContractStatusSPList() throws Exception{
		IContractCheckDocService service = (IContractCheckDocService)getBean("contractCheckDocService");
		Mco001ContractStatusSP conStatus = new Mco001ContractStatusSP();
		conStatus.setCompany(getSemmco002Bean().getCriteria().getCompany());
		conStatus.setCurrentFlag("N");
		conStatus.setRole("CONTRACT");
		List<Mco001ContractStatusSP> list = service.querySPList(EQueryName.SP_MCO001_SRCH_DDL_STATUS.name, conStatus);
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(null, "-- Select --"));
		for(Mco001ContractStatusSP con : list){
			items.add(new SelectItem(con.getLovCode(), con.getLovName()));
		}
		return items;
	}
	

	@Override
	public boolean validate() {
		return false;
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmco002Bean().setTmpRowId(rowId);
	}

	private SEMMCO002Bean semmco002Bean;
	
	public SEMMCO002Bean getSemmco002Bean() {
		return (SEMMCO002Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco002Bean");
	}
	
	public void setSemmco002Bean(SEMMCO002Bean semmco002Bean) {
		this.semmco002Bean = semmco002Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco002Bean", this.semmco002Bean);
	}
	
	public void doExportDutyExcel() {
		semmco002Bean = new SEMMCO002Bean();
		try {
			/***********************************************/
			short line = 0;
			Collection<Mco002SrchContractStatusSP> exList = new ArrayList<Mco002SrchContractStatusSP>();
			//PDocumentManager export to excel
			DocumentExportManager<Mco002SrchContractStatusSP> docManager =
				new DocumentExportManager<Mco002SrchContractStatusSP>(Mco002SrchContractStatusSP.class, EnumDocumentType.XLS);
			// set current configuration of work book.	
				docManager.setRowStart(line);
			/***********************************************/
				int no = 0;
				
				EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
				
				RowDomain row = new RowDomain(0,true);
				row.setCell(new CellDomain(0,9, null, String.class, new EnumDocStyleDomain(EnumDocStyle.TITLE), msg("export.header.duty"),null));
				
				RowDomain rowD = new RowDomain(1,true);
				rowD.setCell(new CellDomain(0, null, String.class, headerStyle, msg("export.col.order"),-1, 2000));
				rowD.setCell(new CellDomain(1, null, String.class, headerStyle, msg("export.column.company"),-1, 2500));
				rowD.setCell(new CellDomain(2, null, String.class, headerStyle, msg("export.column.region"),-1, 2500));
				rowD.setCell(new CellDomain(3, null, String.class, headerStyle, msg("export.column.reqTypeName"),-1, 4000));
				rowD.setCell(new CellDomain(4, null, String.class, headerStyle.setWrapTxt(true), msg("export.col.oldNew"),-1, 3000));
				rowD.setCell(new CellDomain(5, null, String.class, headerStyle, msg("export.col.contractNo"),-1, 3000));
				rowD.setCell(new CellDomain(6, null, String.class, headerStyle, msg("export.col.siteName"),-1, 8000));
				rowD.setCell(new CellDomain(7, null, String.class, headerStyle, msg("export.column.contract.effDt"),-1,3000));
				rowD.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.column.contract.expDt"),-1,3000));
				rowD.setCell(new CellDomain(9, null, String.class, headerStyle, msg("export.col.dutyAmt"),-1, 2500));
				
				List<WrapperBeanObject<Mco002SrchContractStatusSP>> contractStatusList = new ArrayList<WrapperBeanObject<Mco002SrchContractStatusSP>>();
				contractStatusList = getSemmco002Bean().getContractStatusSPList();
				int index = 0;
				EnumDocStyleDomain defaultStyle = new EnumDocStyleDomain(EnumDocStyle.CELL_DEFAULT);
				double tempTotal = 0.00;
				for(int i = 0; i < contractStatusList.size(); i++){
			
				WrapperBeanObject<Mco002SrchContractStatusSP> contract = new WrapperBeanObject<Mco002SrchContractStatusSP>();
				contract = contractStatusList.get(i);
				if(contract.isCheckBox()){
					Mco002SrchContractStatusSP tmp = new Mco002SrchContractStatusSP();
					tmp = (Mco002SrchContractStatusSP)contract.getDataObj();
					
					RowDomain rowE = new RowDomain(index + 2,true);
					rowE.setCell(new CellDomain(0, null, String.class, defaultStyle, Integer.toString(index+1),-1, 2000));
					rowE.setCell(new CellDomain(1, null, String.class, defaultStyle, tmp.getCompany(),-1, 2500));
					rowE.setCell(new CellDomain(2, null, String.class, defaultStyle, tmp.getRegion(),-1, 2500));
					rowE.setCell(new CellDomain(3, null, String.class, defaultStyle, tmp.getReqTypeName(),-1, 4000));
					rowE.setCell(new CellDomain(4, null, String.class, defaultStyle, tmp.getOld_contractNo(),-1, 3000));
					rowE.setCell(new CellDomain(5, null, String.class, defaultStyle, tmp.getContractNo(),-1, 3000));
					rowE.setCell(new CellDomain(6, null, String.class, defaultStyle, tmp.getSiteName(),-1, 10000));
					rowE.setCell(new CellDomain(7, null, String.class, defaultStyle, tmp.getEffDateStr(),-1,3000));
					rowE.setCell(new CellDomain(8, null, String.class, defaultStyle, tmp.getExpDateStr(),-1,3000));
					rowE.setCell(new CellDomain(9, null, Double.class, new EnumDocStyleDomain(EnumDocStyle.CELL_MONEY), tmp.getDutyAmt(),-1, 2500));
					if(tmp.getDutyAmt() != null){
						tempTotal += tmp.getDutyAmt();
					}
					docManager.putDetailRow(rowE);
					++index;
				}
	
			}
				
				--index;
				RowDomain rowF = new RowDomain(index+ 3,true);
				rowF.setCell(new CellDomain(9, null, Double.class, new EnumDocStyleDomain(EnumDocStyle.CELL_MONEY), tempTotal,-1, 2500));
		
//				log.debug("TOTAL DUE AMOUNT ++++++"+ totalDutyAmt);
			docManager.putDetailRow(rowD);	
			docManager.putDetailRow(row);	
			docManager.putDetailRow(rowF);
			docManager.setModule("CONTRACT_STATUS_DUTY_");
			docManager.setPrintPageLandScape(true);
			docManager.setFitWidth((short)1);
			docManager.setMargin(0, 0, 0.5, 0);
			docManager.getObjectFromDocument();
			docManager.exportServletFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doExportExcel() {
		try {
			List<WrapperBeanObject<Mco002SrchContractStatusSP>> contractStatusList = new ArrayList<WrapperBeanObject<Mco002SrchContractStatusSP>>();
			contractStatusList = getSemmco002Bean().getContractStatusSPList();
			
			/***********************************************/
			short line = 0;
			Collection<Mco002SrchContractStatusSP> exList = new ArrayList<Mco002SrchContractStatusSP>();
			//PDocumentManager export to excel
			DocumentExportManager<Mco002SrchContractStatusSP> docManager =
				new DocumentExportManager<Mco002SrchContractStatusSP>(Mco002SrchContractStatusSP.class, EnumDocumentType.XLS);
			// set current configuration of work book.	
				docManager.setRowStart(line);
			/***********************************************/
				int no = 0;
				if(contractStatusList != null && contractStatusList.size() > 0){
					for(int i=0; i < contractStatusList.size(); i++){
						WrapperBeanObject<Mco002SrchContractStatusSP> detail = new WrapperBeanObject<Mco002SrchContractStatusSP>();
						detail = contractStatusList.get(i);
						if(detail.isCheckBox()){
							Mco002SrchContractStatusSP tmp = new Mco002SrchContractStatusSP();
							tmp = (Mco002SrchContractStatusSP)detail.getDataObj();
							no++;
							tmp.setNo(no);
							exList.add(tmp);
						}
					}
				}
				EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
				RowDomain rowD = new RowDomain(0);
				rowD.setCell(new CellDomain(0, null, String.class, headerStyle, msg("export.col.no"),-1,1000));
				rowD.setCell(new CellDomain(1, null, String.class, headerStyle, msg("export.column.company"),-1, 1800));
				rowD.setCell(new CellDomain(2, null, String.class, headerStyle, msg("export.col.shotregion"),-1, 1500));
				rowD.setCell(new CellDomain(3, null, String.class, headerStyle, msg("export.col.typeTH"),-1,4000));
				rowD.setCell(new CellDomain(4, null, String.class, headerStyle, msg("export.col.year"),-1,1500));
				rowD.setCell(new CellDomain(5, null, String.class, headerStyle, msg("export.col.month"),-1, 1500));
				rowD.setCell(new CellDomain(6, null, String.class, headerStyle, msg("export.col.locationId"),-1, 3000));
				rowD.setCell(new CellDomain(7, null, String.class, headerStyle.setWrapTxt(true), msg("export.col.oldNew"),-1, 3000));
				rowD.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.col.contractNo"),-1, 3000));
				rowD.setCell(new CellDomain(9, null, String.class, headerStyle, msg("export.column.siteName"),-1,8000));
				rowD.setCell(new CellDomain(10, null, String.class, headerStyle, msg("export.column.contract.effDt"),-1,3000));
				rowD.setCell(new CellDomain(11, null, String.class, headerStyle, msg("export.column.contract.expDt"),-1,3000));
				rowD.setCell(new CellDomain(12, null, String.class, headerStyle, msg("export.col.age"),-1,1300));
				rowD.setCell(new CellDomain(13, null, String.class, headerStyle, msg("export.col.dutyAmt"),-1,1300));
				rowD.setCell(new CellDomain(14, null, String.class, headerStyle, msg("export.col.recieveBy"),-1, 2500));
				rowD.setCell(new CellDomain(15, null, String.class, headerStyle, msg("export.col.createBy"),-1,2500));
				rowD.setCell(new CellDomain(16, null, String.class, headerStyle, msg("export.col.maintainBy"),-1,3800));
				rowD.setCell(new CellDomain(17, null, String.class, headerStyle, msg("export.col.d1"),-1,3000));
				rowD.setCell(new CellDomain(18, null, String.class, headerStyle, msg("export.col.exportDate"),-1,3000));
				rowD.setCell(new CellDomain(19, null, String.class, headerStyle, msg("export.col.legalApprove"),-1, 2000));
				rowD.setCell(new CellDomain(20, null, String.class, headerStyle, msg("export.col.work"),-1,2000));
				rowD.setCell(new CellDomain(21, null, String.class, headerStyle, msg("export.col.return"),-1,3000));
				rowD.setCell(new CellDomain(22, null, String.class, headerStyle, msg("export.col.maintain"),-1,3000));

//				RowDomain rowE = new RowDomain(1);
//				rowE.setCell(new CellDomain(0, null, String.class, headerStyle, null,null));
//				rowE.setCell(new CellDomain(1, null, String.class, headerStyle, null,null));
//				rowE.setCell(new CellDomain(2, null, String.class, headerStyle, null,null));
//				rowE.setCell(new CellDomain(3, null, String.class, headerStyle, null,null));
//				rowE.setCell(new CellDomain(4, null, String.class, headerStyle, null,null));
//				rowE.setCell(new CellDomain(5, null, String.class, headerStyle, null,null));
//				rowE.setCell(new CellDomain(6, null, String.class, headerStyle, null,null));
//				rowE.setCell(new CellDomain(7, null, String.class, headerStyle, null,null));
//				rowE.setCell(new CellDomain(8, null, String.class, headerStyle, null,null));
//				rowE.setCell(new CellDomain(9, null, String.class, headerStyle, null,null));
//				rowE.setCell(new CellDomain(10, null, String.class, headerStyle,null,null));
//				rowE.setCell(new CellDomain(11, null, String.class, headerStyle,null,null));
//				rowE.setCell(new CellDomain(12, null, String.class, headerStyle,null,null));
//				rowE.setCell(new CellDomain(13, null, String.class, headerStyle,null,null));
//				rowE.setCell(new CellDomain(14, null, String.class, headerStyle,null,null));
//				rowE.setCell(new CellDomain(15, null, String.class, headerStyle,null,null));
//				rowE.setCell(new CellDomain(16, null, String.class, headerStyle,null,null));
//				rowE.setCell(new CellDomain(17, null, String.class, headerStyle,null,null));
//				rowE.setCell(new CellDomain(18, null, String.class, headerStyle,null,null));
//				rowE.setCell(new CellDomain(19, null, String.class, headerStyle,null,null));
//				rowE.setCell(new CellDomain(20, null, String.class, headerStyle,null,null));
//				rowE.setCell(new CellDomain(21, null, String.class, headerStyle,null,null));
//				rowE.setCell(new CellDomain(22, null, String.class, headerStyle,null,null));
//				
				docManager.setListHeader(rowD);
//				docManager.putDetailRow(rowE);
				docManager.seteObjectList(exList);
				docManager.setModule("CONTRACT_CHANGE_STATUS_");
				docManager.setPrintPageLandScape(true);
				docManager.setFitWidth((short)1);
				docManager.setMargin(0, 0, 0.5, 0);
				docManager.getObjectFromDocument();
				docManager.exportServletFile();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setSelectRowWithSameStatus(String status, boolean checked){
		semmco002Bean = getSemmco002Bean();
		boolean flag = true;
		List<WrapperBeanObject<Mco002SrchContractStatusSP>> contractList = semmco002Bean.getContractStatusSPList();
		boolean select = isNonSelected();
		
			if(status != null){
				semmco002Bean.setSelectedStatus(status);
			}
			for(WrapperBeanObject<Mco002SrchContractStatusSP> contract : contractList){
				// set check box all.
				if(flag){
					if(!select){
						if(semmco002Bean.isChkSelAll()){
							if(contract.isCheckBox() == true){
								semmco002Bean.setDisableSelectAll(false);
								flag = false;
							}else{
								semmco002Bean.setDisableSelectAll(true);
							}
						}else{
							semmco002Bean.setDisableSelectAll(false);
							flag = false;
						}
					}else{
						semmco002Bean.setDisableSelectAll(true);
						flag = false;
					}
				}
					if((semmco002Bean.isChkSelAll() && checked) && !select){
						if(((Mco002SrchContractStatusSP)contract.getDataObj()).getRowId().equals(semmco002Bean.getTmpRowId())){
							contract.setCheckBox(false);
							semmco002Bean.setDisableSelectAll(false);
							semmco002Bean.setChkSelAll(false);
							break;
						}
					}else{
						if((semmco002Bean.isChkSelAll() && checked) || select){
							contract.setCheckBox(false);
							contract.setDisableCheckBox(true);
						}else{
							// replace check box status with rowId.
								if(semmco002Bean.getSelectedStatus().equals(((Mco002SrchContractStatusSP)contract.getDataObj()).getContractStatusName())){
									if(semmco002Bean.isChkSelAll()){
										contract.setCheckBox(true);
									}
									contract.setDisableCheckBox(true);
								}else{
									contract.setCheckBox(false);
									contract.setDisableCheckBox(false);
								}
						}	
					}
			}
		setSemmco002Bean(semmco002Bean);
	}
	
	private boolean isNonSelected(){
		List<WrapperBeanObject<Mco002SrchContractStatusSP>> contractList = semmco002Bean.getContractStatusSPList();
		for(WrapperBeanObject<Mco002SrchContractStatusSP> contract : contractList){
			if(contract.isCheckBox()){
				return false;
			}
		}
		return true;
	}
	
}
