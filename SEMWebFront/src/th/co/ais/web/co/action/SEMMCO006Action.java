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
import th.co.ais.domain.co.Mco004DefaultDutySP;
import th.co.ais.domain.co.Mco006SrchContractStatusSP;
import th.co.ais.domain.co.Mco002SrchNoFoundSP;
import th.co.ais.domain.co.Mco002UpdateContractStatusSP;
import th.co.ais.domain.co.Mco004SrchLovStatusSP;
import th.co.ais.domain.co.Mco004SrchStatusSP;
import th.co.ais.domain.co.Mco005ContractStatusSP;
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
import th.co.ais.web.co.bean.SEMMCO006Bean;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.RegionCacheUtil;

public class SEMMCO006Action extends AbstractAction{

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
		semmco006Bean = getSemmco006Bean();
		log.info("doUpdateDutyContract");
		if(!validateDuty()){
			log.info("validateDuty");
			semmco006Bean.setRenderedMsgFormSearch(true);
			return flag;
		}
		try{
			ISiteContractService service = (ISiteContractService)getBean("siteContractService");
			if(semmco006Bean.getContract() != null){
				log.info("starting updateContract...");
				semmco006Bean.getContract().setCurrentUser(semmco006Bean.getUserLogin());
				semmco006Bean.setContract(service.updateContract(semmco006Bean.getContract()));
				semmco006Bean.setPopupClose(true);
				semmco006Bean.setRenderedMsgFormSearch(true);
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
		
		setSemmco006Bean(semmco006Bean);
		return flag;
	}

	private boolean validateDuty(){
		boolean flgValid = true;
		if("01".equals(semmco006Bean.getContract().getDutyPayStatus())){
			if(semmco006Bean.getContract().getDutyAmt() == null || semmco006Bean.getContract().getDutyAmt() < 0){
				addMessageError("W0001", msg("message.dutyAmt"));
				flgValid = false;
			}
			
			if(semmco006Bean.getContract().getDutyPayDt() == null){
				addMessageError("W0001", msg("export.col.requestDtFrom"));
				flgValid = false;
			}
		}
		
		return flgValid;
	}

	private boolean initUpdateDuty() {
		boolean flag = false;
		semmco006Bean = getSemmco006Bean();
		try{
			String rowId = (String)getFacesUtils().getRequestParameter("rowId");
			String siteInfoId = (String)getFacesUtils().getRequestParameter("siteInfoId");
			if(rowId != null){
				ISiteContractService service = (ISiteContractService)getBean("siteContractService");
				Contract contract = service.queryContractByRowId(rowId);
				semmco006Bean.setContract(contract);
				if(contract.getDutyAmt() == null && contract.getDutyPayDt() == null &&
						contract.getCopyDuty() == null && contract.getCopyDutyAmt() == null){
					List<Mco004DefaultDutySP> to = null;
					Mco004DefaultDutySP criteria = new Mco004DefaultDutySP();
					criteria.setSiteInfoId(siteInfoId);
//					to = service.querySPList(EQueryName.SP_MCO006_DEFAULT_DUTY.name, criteria);
					if(to != null && !to.isEmpty()){
						Mco004DefaultDutySP def = to.get(0);
						semmco006Bean.getContract().setDutyAmt(def.getDutyAmt());
						semmco006Bean.getContract().setCopyDuty(def.getCopyDuty());
						semmco006Bean.getContract().setCopyDutyAmt(def.getCopyDutyAmt());
//						if(def.getDutyPayDate() != null) semmco006Bean.getContract().setDutyPayDt(convertYearENtoTH(def.getDutyPayDate()));
					}
				}
				
				if(semmco006Bean.getContract().getDutyPayStatus() == null){
					semmco006Bean.getContract().setDutyPayStatus("00");
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco006Bean(semmco006Bean);
		//Adding by mr.john 21/04/2011 from SA (Surasit).
		checkAddAbleContractStatus();
		return flag;
	}


	private boolean doDeleteContractStatusHistory() {
		boolean flag = false;
		semmco006Bean = getSemmco006Bean();
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		try{
			if(semmco006Bean.getContractStatus() != null){
				service.deleteContractStatus(semmco006Bean.getContractStatus());
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
		semmco006Bean.setRenderedMsgFormSearchPopup(true);
		setSemmco006Bean(semmco006Bean);
		return flag;
	}

	private boolean doClearContractStatusHistory() {
		boolean flag = false;
		semmco006Bean = getSemmco006Bean();
		semmco006Bean.setContractStatus(new ContractStatus());
		semmco006Bean.getContractStatus().setContractStatus("");
		semmco006Bean.getContractStatus().setChangeStatusDt(new Date());
		semmco006Bean.getContractStatus().setRemark("");
		semmco006Bean.setDisabledBtnAddContractStatusHistory(false);
		semmco006Bean.setDisabledBtnUpdateContractStatusHistory(true);
		setSemmco006Bean(semmco006Bean);
		return flag;
	}

	private boolean doUpdateContractStatusHistory() {
		boolean flag = false;
		semmco006Bean = getSemmco006Bean();
		if(!validateUpdateContractStatus("doAdd")){
			semmco006Bean.setRenderedMsgFormSearch(false);
			semmco006Bean.setRenderedMsgFormMiddle(true);
			setSemmco006Bean(semmco006Bean);
			return flag;
		}
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			ISiteContractService conService = (ISiteContractService)getBean("siteContractService");
			
			semmco006Bean.getContractStatus().setCurrentUser(semmco006Bean.getUserLogin());
			service.updateContractStatus(semmco006Bean.getContractStatus());
			addMessageInfo("M0001");
			
			Contract contract = conService.updateContract(semmco006Bean.getContract());
			semmco006Bean.setContract(contract);
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
		semmco006Bean.setRenderedMsgFormSearchPopup(true);
		setSemmco006Bean(semmco006Bean);
		return flag;
	}

	private void updateSiteContract() {
		semmco006Bean = getSemmco006Bean();
		List<Mco001UpdateStatusSP> to = null;
		try{
			ISiteContractService service = (ISiteContractService)getBean("siteContractService");
			Mco001UpdateStatusSP status = new Mco001UpdateStatusSP();
			status.setContractId(semmco006Bean.getContractId());
			status.setCurrentUser(semmco006Bean.getUserLogin());
			
			to = service.querySPList(EQueryName.SP_MCO001_UPD_STATUS.name, status);
			if(to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")){
				log.debug("update site contract result [" + to.get(0).getResultMsg());
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		setSemmco006Bean(semmco006Bean);
		
	}

	/*
	private boolean doAddContractStatusHistory() {
		boolean flag = false;
		semmco006Bean = getSemmco006Bean();
		if(!validateUpdateContractStatus()){
			semmco006Bean.setRenderedMsgFormSearch(false);
			semmco006Bean.setRenderedMsgFormMiddle(true);
			setSemmco006Bean(semmco006Bean);
			return flag;
		}
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		// add contract status
		try{
			semmco006Bean.getContractStatus().setContractId(semmco006Bean.getContractId());
			semmco006Bean.getContractStatus().setCurrentUser(semmco006Bean.getUserLogin());
			semmco006Bean.getContractStatus().setSeqNo(this.getContractStatusSeqNo());
			service.createContractStatus(semmco006Bean.getContractStatus());
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
		semmco006Bean.setRenderedMsgFormSearch(false);
		semmco006Bean.setRenderedMsgFormMiddle(true);
		setSemmco006Bean(semmco006Bean);
		return flag;
	}
*/
	private boolean doAddContractStatusHistory() {
		boolean flag = false;
		semmco006Bean = getSemmco006Bean();
		if(!validateUpdateContractStatus("doAdd")){
			semmco006Bean.setRenderedMsgFormSearch(false);
			semmco006Bean.setRenderedMsgFormMiddle(true);
			setSemmco006Bean(semmco006Bean);
			return flag;
		}
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		// add contract status
		try{
			List<Mco002UpdateContractStatusSP> to = null;
			Mco002UpdateContractStatusSP contract = new Mco002UpdateContractStatusSP();
			contract.setContractId(semmco006Bean.getContractId());
			contract.setContractStatus(semmco006Bean.getContractStatus().getContractStatus());
			contract.setChangeStatusDate(semmco006Bean.getContractStatus().getChangeStatusDt());
			contract.setRemark(semmco006Bean.getContractStatus().getRemark());
			contract.setCurrentUser(semmco006Bean.getUserLogin());
			contract.setCompany(semmco006Bean.getCompany());
			//Adding by mr.John from (mr.Surasit) 27/04/2011
			contract.setReceivePersonCode(semmco006Bean.getContract().getReceivePersonCode());
			contract.setCreatePersonCode(semmco006Bean.getContract().getCreatePersonCode());
			to = service.querySPList(EQueryName.SP_MCO002_UPD_STATUS_LIST.name, contract);
				
			if(to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")){
				semmco006Bean.setPopupClose(true);
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
		semmco006Bean.setRenderedMsgFormSearch(false);
		semmco006Bean.setRenderedMsgFormMiddle(true);
		setSemmco006Bean(semmco006Bean);
		return flag;
	}
	private Integer getContractStatusSeqNo() {
		// SEM_SP_MCO001_SEQ_STATUS (parameter = contractId)
		semmco006Bean = getSemmco006Bean();
		ISiteContractService service = (ISiteContractService)getBean("siteContractService");
		List<Mco001SeqStatusSP> to = null;
		Integer seqNo = 0;
		try{
			Mco001SeqStatusSP criteria = new Mco001SeqStatusSP();
			criteria.setRowId(semmco006Bean.getContractId());
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
		semmco006Bean = getSemmco006Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		ISiteContractService conService = (ISiteContractService)getBean("siteContractService");
		try{
			if(rowId != null){
				semmco006Bean.setContractStatus(service.queryContractStatusByRowId(rowId));
				semmco006Bean.setContract(conService.queryContractByRowId(semmco006Bean.getContractId()));
				semmco006Bean.setDisabledBtnAddContractStatusHistory(true);
				semmco006Bean.setDisabledBtnUpdateContractStatusHistory(false);
				semmco006Bean.setRenderedAddHistory(true);
				this.updateContractStatusList(rowId);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		setSemmco006Bean(semmco006Bean);
		return flag;
	}
	
	private void updateContractStatusList(String rowId) {
		semmco006Bean = getSemmco006Bean();
		List<Mco004SrchLovStatusSP> to = null;
		List<SelectItem> selList = new LinkedList<SelectItem>();
		SelectItem selItem = null;
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			Mco004SrchLovStatusSP criteria = new Mco004SrchLovStatusSP();
			criteria.setContractId(semmco006Bean.getContractId());
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
				semmco006Bean.setContractStatusList(selList);
			}else{
				semmco006Bean.setContractStatusList(getEmptyDropDown());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco006Bean(semmco006Bean);
		
	}

	private boolean initDeleteContractStatusHistory() {
		boolean flag = false;
		semmco006Bean = getSemmco006Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		try{
			if(rowId != null){
				semmco006Bean.setContractStatus(service.queryContractStatusByRowId(rowId));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco006Bean(semmco006Bean);
		return flag;
	}

	private boolean initUpdateContractStatus() {
		boolean flag = false;
		semmco006Bean = getSemmco006Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		String company = (String)getFacesUtils().getRequestParameter("company");
		semmco006Bean.setContractId(rowId);
		semmco006Bean.setCompany(company);
		this.doClearContractStatusHistory();
		this.searchContractStatusHistory();
		setSemmco006Bean(semmco006Bean);
		return flag;
	}

	private void getContractStatusListByContractId() {
		semmco006Bean = getSemmco006Bean();
		List<Mco004SrchLovStatusSP> to = null;
		List<SelectItem> selList = new LinkedList<SelectItem>();
		SelectItem selItem = null;
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			Mco004SrchLovStatusSP criteria = new Mco004SrchLovStatusSP();
			criteria.setContractId(semmco006Bean.getContractId());
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
				semmco006Bean.setContractStatusList(selList);
			}else{
				semmco006Bean.setContractStatusList(getEmptyDropDown());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco006Bean(semmco006Bean);
		
	}


	private void searchContractStatusHistory() {
		semmco006Bean = getSemmco006Bean();
		List<Mco004SrchStatusSP> to = null;
		semmco006Bean.setContractStatusHistoryList(null);
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			Mco004SrchStatusSP criteria = new Mco004SrchStatusSP();
			criteria.setContractId(semmco006Bean.getContractId());
			to = service.querySPList(EQueryName.SP_MCO004_SRCH_STATUS.name, criteria);
			List<Mco004SrchStatusSP> list = new ArrayList<Mco004SrchStatusSP>();
			// check add able
			this.checkAddAbleContractStatus();
			if(to != null && to.size() > 0){
				int index = 0;
				for(Mco004SrchStatusSP status : to){
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
			
			semmco006Bean.setContractStatusHistoryList(list);
			// get drop down list contract status
			this.getContractStatusListByContractId();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco006Bean(semmco006Bean);
	}

	private void checkAddAbleContractStatus() {
		semmco006Bean = getSemmco006Bean();
		List<Mco001CheckAddAbleSP> to = null;
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			Mco001CheckAddAbleSP criteria = new Mco001CheckAddAbleSP();
			criteria.setContractId(semmco006Bean.getContractId());
			criteria.setRole("CONTRACT");
			to = service.querySPList(EQueryName.SP_MCO001_CHK_ADDABLE.name, criteria);
			if(to != null && to.size() > 0){
				Mco001CheckAddAbleSP addAble = to.get(0);
				if(addAble.getAddAbleFlag() != null && addAble.getAddAbleFlag().equals("Y")){
					semmco006Bean.setRenderedAddHistory(true);
				}else{
					semmco006Bean.setRenderedAddHistory(false);
				}
				
				if(addAble.getEditAbleFlag() != null && addAble.getEditAbleFlag().equals("Y")){
					semmco006Bean.setRenderedUpdateHistory(true);
				}else{
					semmco006Bean.setRenderedUpdateHistory(false);
				}
				
				if(addAble.getDeleteAbleFlag() != null && addAble.getDeleteAbleFlag().equals("Y")){
					semmco006Bean.setRenderedDeleteHistory(true);
				}else{
					semmco006Bean.setRenderedDeleteHistory(false);
				}
				//Adding by mr.john 21/04/2011 from SA (Surasit)
				if(addAble.getEditDutyFlag() != null && addAble.getEditDutyFlag().equals("Y")){
					semmco006Bean.setDisabledBtnExportDuty(true);
				}else{
					semmco006Bean.setDisabledBtnExportDuty(false);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco006Bean(semmco006Bean);
		
	}


	private boolean doSaveContractStatus() {
		boolean flag = false;
		semmco006Bean = getSemmco006Bean();
		if(!validateUpdateContractStatus("doSave")){
			semmco006Bean.setRenderedMsgFormSearchPopup(true);
			semmco006Bean.setRenderedMsgFormSearch(false);
			semmco006Bean.setPopupClose(false);
			setSemmco006Bean(semmco006Bean);
			return flag;
		}
		try{
			List<Mco002UpdateContractStatusSP> to = null;
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
				Mco002UpdateContractStatusSP contract = new Mco002UpdateContractStatusSP();
				contract.setContractId(semmco006Bean.getRowsIdConcat());
				contract.setContractStatus(semmco006Bean.getContractStatus().getContractStatus());
				contract.setChangeStatusDate(semmco006Bean.getContractStatus().getChangeStatusDt());
				contract.setRemark(semmco006Bean.getContractStatus().getRemark());
				contract.setCurrentUser(semmco006Bean.getUserLogin());
				contract.setCompany(semmco006Bean.getCompany());
				//Adding by mr.John from (mr.Surasit) 27/04/2011
				contract.setReceivePersonCode(semmco006Bean.getContract().getReceivePersonCode());
				contract.setCreatePersonCode(semmco006Bean.getContract().getCreatePersonCode());
				
				to = service.querySPList(EQueryName.SP_MCO002_UPD_STATUS_LIST.name, contract);
				
				if(to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")){
					semmco006Bean.setPopupClose(true);
					addMessageInfo("M0001");
				}
				
				// search contractStatus
				semmco006Bean.setContractStatusSPList(null);
				this.doSearch();
//			}
			
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		semmco006Bean.setRenderedMsgFormSearchPopup(false);
		semmco006Bean.setRenderedMsgFormSearch(true);
		setSemmco006Bean(semmco006Bean);
		return flag;
	}

	private boolean validateUpdateContractStatus(String method) {
		boolean flgValid = true;
		
		if(StringUtils.isEmpty(getSemmco006Bean().getContractStatus().getContractStatus())){
			addMessageError("W0001", msg("message.contractStatus"));
			flgValid = false;
		}else{
			// contract status = 03 (send legal) call SP_MCO002_CHK_NO_FILE
			if(getSemmco006Bean().getContractStatus().getContractStatus().equals("03")){
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
		
		if(getSemmco006Bean().getContractStatus().getChangeStatusDt() == null){
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
			criteria.setContractId(getSemmco006Bean().getContractId());
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
			criteria.setContractId(getSemmco006Bean().getRowsIdConcat());
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
		semmco006Bean = getSemmco006Bean();
		try{
			boolean chkAll = getSemmco006Bean().isChkSelAll();
			List<WrapperBeanObject<Mco006SrchContractStatusSP>> contractList = new ArrayList<WrapperBeanObject<Mco006SrchContractStatusSP>>();
			contractList = getSemmco006Bean().getContractStatusSPList();
			
			for(int i = 0; i < contractList.size(); i++) {
				Mco006SrchContractStatusSP o = (Mco006SrchContractStatusSP)contractList.get(i).getDataObj();
				if(StringUtils.isNotEmpty(o.getRowId())){
					if(chkAll){
						if (semmco006Bean.getSelectedStatus().equals(o.getContractStatusName()) && chkAll) {
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
				semmco006Bean.setDisableSelectAll(true);
				semmco006Bean.setSelectedStatus(null);
			}else{
				onRenderButton();
			}
			
		}catch(NullPointerException ne){
			// TODO
			
		}catch(Exception e){
			//TODO
		}
		setSemmco006Bean(semmco006Bean);
	}
	
	public void closePopup(){
		semmco006Bean = getSemmco006Bean();
		semmco006Bean.setRenderedMsgFormSearch(true);
		setSemmco006Bean(semmco006Bean);
	}
	
	
	public void onRenderButton() {
		semmco006Bean = getSemmco006Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		String status = (String)getFacesUtils().getRequestParameter("status");
		Boolean checked = new Boolean((String)getFacesUtils().getRequestParameter("checked"));
		
		semmco006Bean.setTmpRowId(rowId);
		
		setSelectRowWithSameStatus(status, checked);
		
		if (isCheckSELBox()) {
			semmco006Bean.setDisabledBtnAdd(false);
			semmco006Bean.setDisabledBtnExport(false);
			semmco006Bean.setDisabledBtnExportDuty(false);
		} else {
			semmco006Bean.setDisabledBtnAdd(true);
			semmco006Bean.setDisabledBtnExport(true);
			semmco006Bean.setDisabledBtnExportDuty(true);
		}
		setSemmco006Bean(semmco006Bean);
		
	}
	
	private boolean isCheckSELBox() {
		boolean isCheck = false;
		
		List<WrapperBeanObject<Mco006SrchContractStatusSP>> contractStatusList = getSemmco006Bean().getContractStatusSPList();
		for (WrapperBeanObject<Mco006SrchContractStatusSP> wrapperBeanObject : contractStatusList) {
			if (wrapperBeanObject.isCheckBox()) {
				return true;
			}
		}
		
		return isCheck;
	}
	
	private boolean initAddContractStatus() {
		boolean flag = false;
		semmco006Bean = getSemmco006Bean();
		semmco006Bean.setRowsIdConcat("");
		semmco006Bean.getContract().setReceivePersonCode("");
		semmco006Bean.getContract().setCreatePersonCode("");
		this.doClearPopupAddContractStatus();
		try{
			List<WrapperBeanObject<Mco006SrchContractStatusSP>> contractList = semmco006Bean.getContractStatusSPList();
			if(contractList != null && contractList.size() > 0){
				for(WrapperBeanObject<Mco006SrchContractStatusSP> contract : contractList){
					WrapperBeanObject<Mco006SrchContractStatusSP> tmpWrapperBean = new WrapperBeanObject<Mco006SrchContractStatusSP>();
					if(contract.isCheckBox()){
						Mco006SrchContractStatusSP temp = (Mco006SrchContractStatusSP)contract.getDataObj();
						if(semmco006Bean.getRowsIdConcat().equals("")){
							semmco006Bean.setRowsIdConcat(temp.getRowId());
							// get drop down contract status list by fist contractId
							semmco006Bean.setContractId(temp.getRowId());
							this.getContractStatusListByContractId();
						}else{
							semmco006Bean.setRowsIdConcat(semmco006Bean.getRowsIdConcat() +",".trim()+ temp.getRowId());
						}
						semmco006Bean.setCompany(temp.getCompany());
					}
				}
				semmco006Bean.setDisabledBtnAdd(false);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		checkAddAbleContractStatus();
		setSemmco006Bean(semmco006Bean);
		
		return flag;
	}

	private void doClearPopupAddContractStatus() {
		semmco006Bean = getSemmco006Bean();
		semmco006Bean.setContractStatus(new ContractStatus());
		semmco006Bean.getContractStatus().setContractStatus("");
		semmco006Bean.getContractStatus().setChangeStatusDt(new Date());
		semmco006Bean.getContractStatus().setRemark("");
		setSemmco006Bean(semmco006Bean);
	}


	private boolean doClear() {
		boolean flag = false;
		semmco006Bean = getSemmco006Bean();
		semmco006Bean.setCriteria(new Mco006SrchContractStatusSP());
		semmco006Bean.getCriteria().setCompany("");
		semmco006Bean.getCriteria().setReqType("");
		semmco006Bean.getCriteria().setContractNo("");
		semmco006Bean.setContractStatusSPList(new ArrayList<WrapperBeanObject<Mco006SrchContractStatusSP>>());
		semmco006Bean.setDisabledBtnAdd(true);
		semmco006Bean.setDisabledBtnExport(true);
		semmco006Bean.setDisabledBtnExportDuty(true);
		semmco006Bean.setChkSelAll(false);
		semmco006Bean.setRenderedMsgDataNotFound(false);
		semmco006Bean.setChkTerminateFlag(false);
		semmco006Bean.setRenderedTerminateFlag(false);
		setSemmco006Bean(semmco006Bean);
		this.setDisabledButton();
		
		return flag;
	}

	private void setDisabledButton() {
		semmco006Bean = getSemmco006Bean();
		semmco006Bean.setDisabledBtnAdd(true);
		semmco006Bean.setDisabledBtnExport(true);
		semmco006Bean.setDisabledBtnExportDuty(true);
		setSemmco006Bean(semmco006Bean);
	}


	private boolean pageLoad() {
		boolean flag = false;
		return flag;
	}
	
	private boolean doSearch() {
		boolean flag = false;
		semmco006Bean = getSemmco006Bean();
		if(!validateSearch()){
			log.info("validate Search pass");
			semmco006Bean.setRenderedMsgFormSearch(true);
			return flag;
		}
		List<Mco006SrchContractStatusSP> to = null;
		try{
			log.info("Starting Do Searching1 ...");
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			if(semmco006Bean.isChkTerminateFlag()){
				semmco006Bean.getCriteria().setTerminateFlag("Y");
			}else{
				semmco006Bean.getCriteria().setTerminateFlag(null);
			}
			
			String pico = "N";
			//Adding by mr.john 22/04/2011 from SA (Surasit)
			if(semmco006Bean.getCriteria().isPico()){
				pico = "Y";
			}else{
				pico = "N";
			}
			//set pico.
			semmco006Bean.getCriteria().setStrPico(pico);
			to = service.querySPList(EQueryName.SP_MCO006_SRCH.name, semmco006Bean.getCriteria());
			if(to == null || to.size() == 0){
				semmco006Bean.setRenderedMsgDataNotFound(true);
				semmco006Bean.setContractStatusSPList(null);
			}
			if(to != null && to.size() > 0){
				semmco006Bean.setRenderedMsgDataNotFound(false);
				semmco006Bean.setContractStatusSPList(new ArrayList<WrapperBeanObject<Mco006SrchContractStatusSP>>());
				for (int i = 0; i < to.size(); i++) {
					Mco006SrchContractStatusSP contract = to.get(i);
					if(contract != null){
						WrapperBeanObject<Mco006SrchContractStatusSP> tmpWrapperBean = new WrapperBeanObject<Mco006SrchContractStatusSP>();
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
						
						log.debug("contract.getEffDateStr() = "+contract.getEffDateStr());
						log.debug("contract.getExpDateStr() = "+contract.getExpDateStr());
						
						tmpWrapperBean.setDataObj(contract);
						tmpWrapperBean.setMessage("");
						tmpWrapperBean.setCheckBox(false);
						semmco006Bean.getContractStatusSPList().add(tmpWrapperBean);
						
					}
				}
				
				log.info("Starting Do Searching2 ...");
				// call SEM_SP_MCO002_SRCH_NO_FOUND
				List<Mco002SrchNoFoundSP> list = null;
				Mco002SrchNoFoundSP criteria = new Mco002SrchNoFoundSP();
				criteria.setCompany(semmco006Bean.getCriteria().getCompany());
				criteria.setReqType(semmco006Bean.getCriteria().getReqType());
				criteria.setContractNo(semmco006Bean.getCriteria().getContractNo());
				criteria.setRegion(semmco006Bean.getCriteria().getRegion());
				criteria.setContractStatus(semmco006Bean.getCriteria().getContractStatus());
				
				//Adding by mr.john
				criteria.setReceiveDateFrom(semmco006Bean.getCriteria().getReceiveDateFrom());
				criteria.setReceiveDateTo(semmco006Bean.getCriteria().getReceiveDateTo());
				criteria.setTerminateFlag(semmco006Bean.getCriteria().getTerminateFlag());
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
					semmco006Bean.setRenderedMsgFormSearch(true);
				}
				
				this.setDisabledButton();
			}
			
		}catch(Exception e){
			log.info("Exception doSearch() ...");
			e.printStackTrace();
		}
		setSemmco006Bean(semmco006Bean);
		return flag;
	}
	

	private boolean validateSearch() {
		boolean flgValid = true;
		
		if(StringUtils.isEmpty(getSemmco006Bean().getCriteria().getContractNo()) &&
				StringUtils.isEmpty(getSemmco006Bean().getCriteria().getCompany())){
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		/*if(StringUtils.isEmpty(getSemmco006Bean().getCriteria().getReqType())){
			addMessageError("W0001", msg("message.reqType"));
			flgValid = false;
		}*/
		/*if(StringUtils.isEmpty(getSemmco006Bean().getCriteria().getContractNo())){
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
		SEMMCO006Bean semmco006Bean = new SEMMCO006Bean();
		semmco006Bean.setCriteria(new Mco006SrchContractStatusSP());
		semmco006Bean.setContract(new Contract());
		semmco006Bean.setContractStatusSPList(new ArrayList<WrapperBeanObject<Mco006SrchContractStatusSP>>());
		semmco006Bean.setReqTypeList(getLovItemsByType(ELovType.T_CO_CONTRACT_STATUS_REQ_TYPE.name));
		semmco006Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmco006Bean.setContractStatusList(getLovItemsByType(ELovType.T_CO_CONTRACT_STATUS.name));
		semmco006Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		semmco006Bean.setContractStatList(getEmptyDropDown());
		semmco006Bean.setRenderedMsgFormSearch(false);
		semmco006Bean.setRenderedMsgFormSearchPopup(false);
		semmco006Bean.setChkTerminateFlag(false);
		semmco006Bean.setRenderedTerminateFlag(false);
		semmco006Bean.setBorrowOfficerList(getLovItemsByType(ELovType.T_CO_BORROW_OFFICER.name));
		setSemmco006Bean(semmco006Bean);
		this.setDisabledButton();
		
	}
	
	public void renderCompany(){
		semmco006Bean = getSemmco006Bean();
		String company = semmco006Bean.getCriteria().getCompany();
		if(company != null && !company.equals("")){
			try {
				semmco006Bean.setContractStatusList(getContractStatusSPList());
				semmco006Bean.setContractStatList(getContractStatusSPList());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			semmco006Bean.setContractStatusList(getEmptyDropDown());
			semmco006Bean.setContractStatList(getEmptyDropDown());
		}
		setSemmco006Bean(semmco006Bean);
	}
	
	public void renderTerminateFlag(){
		semmco006Bean = getSemmco006Bean();
		String reqType = semmco006Bean.getCriteria().getReqType();
		//if(reqType != null && reqType.equals("04")){
		if(reqType != null && reqType.equals("99")){
			semmco006Bean.setRenderedTerminateFlag(true);
		}else{
 			semmco006Bean.setRenderedTerminateFlag(false);
		}
		semmco006Bean.setChkTerminateFlag(false);
		setSemmco006Bean(semmco006Bean);
	}
	
	private List<SelectItem> getContractStatusSPList() throws Exception{
		IContractCheckDocService service = (IContractCheckDocService)getBean("contractCheckDocService");
		Mco005ContractStatusSP conStatus = new Mco005ContractStatusSP();
		conStatus.setCompany(getSemmco006Bean().getCriteria().getCompany());
		conStatus.setCurrentFlag("N");
		conStatus.setRole("CONTRACT");
		List<Mco005ContractStatusSP> list = service.querySPList(EQueryName.SP_MCO005_SRCH_DDL_STATUS.name, conStatus);
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(null, "-- Select --"));
		for(Mco005ContractStatusSP con : list){
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
		getSemmco006Bean().setTmpRowId(rowId);
	}

	private SEMMCO006Bean semmco006Bean;
	
	public SEMMCO006Bean getSemmco006Bean() {
		return (SEMMCO006Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco006Bean");
	}
	
	public void setSemmco006Bean(SEMMCO006Bean semmco006Bean) {
		this.semmco006Bean = semmco006Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco006Bean", this.semmco006Bean);
	}
	
	public void doExportDutyExcel() {
		semmco006Bean = new SEMMCO006Bean();
		try {
			/***********************************************/
			short line = 0;
			Collection<Mco006SrchContractStatusSP> exList = new ArrayList<Mco006SrchContractStatusSP>();
			//PDocumentManager export to excel
			DocumentExportManager<Mco006SrchContractStatusSP> docManager =
				new DocumentExportManager<Mco006SrchContractStatusSP>(Mco006SrchContractStatusSP.class, EnumDocumentType.XLS);
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
				
				List<WrapperBeanObject<Mco006SrchContractStatusSP>> contractStatusList = new ArrayList<WrapperBeanObject<Mco006SrchContractStatusSP>>();
				contractStatusList = getSemmco006Bean().getContractStatusSPList();
				int index = 0;
				EnumDocStyleDomain defaultStyle = new EnumDocStyleDomain(EnumDocStyle.CELL_DEFAULT);
				double tempTotal = 0.00;
				for(int i = 0; i < contractStatusList.size(); i++){
			
				WrapperBeanObject<Mco006SrchContractStatusSP> contract = new WrapperBeanObject<Mco006SrchContractStatusSP>();
				contract = contractStatusList.get(i);
				if(contract.isCheckBox()){
					Mco006SrchContractStatusSP tmp = new Mco006SrchContractStatusSP();
					tmp = (Mco006SrchContractStatusSP)contract.getDataObj();
					
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
			List<WrapperBeanObject<Mco006SrchContractStatusSP>> contractStatusList = new ArrayList<WrapperBeanObject<Mco006SrchContractStatusSP>>();
			contractStatusList = getSemmco006Bean().getContractStatusSPList();
			
			/***********************************************/
			short line = 0;
			Collection<Mco006SrchContractStatusSP> exList = new ArrayList<Mco006SrchContractStatusSP>();
			//PDocumentManager export to excel
			DocumentExportManager<Mco006SrchContractStatusSP> docManager =
				new DocumentExportManager<Mco006SrchContractStatusSP>(Mco006SrchContractStatusSP.class, EnumDocumentType.XLS);
			// set current configuration of work book.	
				docManager.setRowStart(line);
			/***********************************************/
				int no = 0;
				if(contractStatusList != null && contractStatusList.size() > 0){
					for(int i=0; i < contractStatusList.size(); i++){
						WrapperBeanObject<Mco006SrchContractStatusSP> detail = new WrapperBeanObject<Mco006SrchContractStatusSP>();
						detail = contractStatusList.get(i);
						if(detail.isCheckBox()){
							Mco006SrchContractStatusSP tmp = new Mco006SrchContractStatusSP();
							tmp = (Mco006SrchContractStatusSP)detail.getDataObj();
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
		semmco006Bean = getSemmco006Bean();
		boolean flag = true;
		List<WrapperBeanObject<Mco006SrchContractStatusSP>> contractList = semmco006Bean.getContractStatusSPList();
		boolean select = isNonSelected();
		
			if(status != null){
				semmco006Bean.setSelectedStatus(status);
			}
			for(WrapperBeanObject<Mco006SrchContractStatusSP> contract : contractList){
				// set check box all.
				if(flag){
					if(!select){
						if(semmco006Bean.isChkSelAll()){
							if(contract.isCheckBox() == true){
								semmco006Bean.setDisableSelectAll(false);
								flag = false;
							}else{
								semmco006Bean.setDisableSelectAll(true);
							}
						}else{
							semmco006Bean.setDisableSelectAll(false);
							flag = false;
						}
					}else{
						semmco006Bean.setDisableSelectAll(true);
						flag = false;
					}
				}
					if((semmco006Bean.isChkSelAll() && checked) && !select){
						if(((Mco006SrchContractStatusSP)contract.getDataObj()).getRowId().equals(semmco006Bean.getTmpRowId())){
							contract.setCheckBox(false);
							semmco006Bean.setDisableSelectAll(false);
							semmco006Bean.setChkSelAll(false);
							break;
						}
					}else{
						if((semmco006Bean.isChkSelAll() && checked) || select){
							contract.setCheckBox(false);
							contract.setDisableCheckBox(true);
						}else{
							// replace check box status with rowId.
								if(semmco006Bean.getSelectedStatus().equals(((Mco006SrchContractStatusSP)contract.getDataObj()).getContractStatusName())){
									if(semmco006Bean.isChkSelAll()){
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
		setSemmco006Bean(semmco006Bean);
	}
	
	private boolean isNonSelected(){
		List<WrapperBeanObject<Mco006SrchContractStatusSP>> contractList = semmco006Bean.getContractStatusSPList();
		for(WrapperBeanObject<Mco006SrchContractStatusSP> contract : contractList){
			if(contract.isCheckBox()){
				return false;
			}
		}
		return true;
	}
	
}
