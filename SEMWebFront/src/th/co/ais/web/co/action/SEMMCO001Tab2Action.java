package th.co.ais.web.co.action;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import th.co.ais.domain.co.Mco001Exp;
import th.co.ais.domain.co.Mco001SrchFileSP;
import th.co.ais.domain.sa.MSA001LovSP;
import th.co.ais.domain.si.Contract;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.rpt.util.DataUtil;
import th.co.ais.service.co.IContractFileService;
import th.co.ais.service.si.ISiteContractService;
import th.co.ais.util.ELovType;
import th.co.ais.util.ELovVal;
import th.co.ais.util.EQueryName;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.co.bean.SEMMCO001Bean;
import th.co.ais.web.co.bean.SEMMCO001Tab1Bean;
import th.co.ais.web.co.bean.SEMMCO001Tab2Bean;
import th.co.ais.web.ir.bean.FileUploadBean;
import th.co.ais.web.report.bean.SEMECO001Bean;
import th.co.ais.web.report.util.ExportFileUtil;

public class SEMMCO001Tab2Action extends AbstractAction{

	private static final long serialVersionUID = 5934806069385322547L;

	private Logger log = Logger.getLogger(getClass());
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		
		if (methodWithNavi.equalsIgnoreCase("initDeleteContractFile")) {
			flag = initDeleteContractFile();
		}
		if (methodWithNavi.equalsIgnoreCase("doDeleteContractFile")) {
			flag = doDeleteContractFile();
		}
		if (methodWithNavi.equalsIgnoreCase("doSearchContractFile")) {
			flag = searchContractFile();
		}
		return flag;
	}
	
	private boolean doDeleteContractFile() {
		boolean flag = false;
		semmco001tab2Bean = getSemmco001tab2Bean();
		IContractFileService service = (IContractFileService)getBean("contractFileService");
		try{
			if(semmco001tab2Bean.getContractFile() != null){
				service.deleteContractFile(semmco001tab2Bean.getContractFile());
				addMessageInfo("M0002");
				// do search contract file
				this.searchContractFile();
			}
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0002");
		}
		setSemmco001tab2Bean(semmco001tab2Bean);
		return flag;
	}

	private boolean initDeleteContractFile() {
		boolean flag = false;
		semmco001tab2Bean = getSemmco001tab2Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		IContractFileService service = (IContractFileService)getBean("contractFileService");
		try{
			if(rowId != null){
				semmco001tab2Bean.setContractFile(service.queryContractFileByRowId(rowId));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco001tab2Bean(semmco001tab2Bean);
		return flag;
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
		SEMMCO001Tab2Bean semmco001tab2Bean = new SEMMCO001Tab2Bean();
		semmco001tab2Bean.setContractDocType(new ArrayList<SelectItem>());
		semmco001tab2Bean.setContractFileSPList(new ArrayList<Mco001SrchFileSP>());
		setSemmco001tab2Bean(semmco001tab2Bean);
	}
	
	public boolean initTab2() {
		boolean flag = false;
		ISiteContractService service = null;
		Contract contract = null;
		semmco001tab2Bean = getSemmco001tab2Bean();
		semeco001Bean = new SEMECO001Bean();
		semmco001Bean = getSemmco001Bean();
		List<Mco001Exp> docLst = null;
		SelectItem selItem = null;
		List<SelectItem> selList = new ArrayList<SelectItem>();
		try {
			service = (ISiteContractService) getBean("siteContractService");
			contract = service.queryContractByRowId(semmco001Bean.getContractIdParam());
			Mco001Exp criteria = new Mco001Exp();
			criteria.setCompany(semmco001Bean.getCompanyParam());
			if (contract != null) {
				semeco001Bean.setContractDocType(contract.getContractDocType());
			}
			// drop down contract doc type if company = AIS where LOV_COND1 = AIS else where LOV_COND2 = FLX
//			if(semmco001Bean.getCompanyParam() != null && (semmco001Bean.getCompanyParam().equals("AIS") || semmco001Bean.getCompanyParam().equals("AWN")) ){
//				semmco001tab2Bean.setContractDocType(getLovItemsByType(ELovType.T_SI_CONTRACT_DOC_TYPE.name, EX_AND,  ELovVal.V_CO_AIS.name, null, null));
//			}else{
//				semmco001tab2Bean.setContractDocType(getLovItemsByType(ELovType.T_SI_CONTRACT_DOC_TYPE.name, EX_AND,  null, ELovVal.V_CO_FXL.name, null));
//			}
			docLst = service.querySPList(EQueryName.SP_MCO001_SRCH_DDL_DOC.name, criteria);
			
			
			//List<MSA001LovSP> retLst = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA001_SRCH_TEAM.name, semmsa003Bean.getLovObjParam());
			
			if(docLst != null && !docLst.isEmpty()){
				for(Mco001Exp lov : docLst){
					selItem = new SelectItem();
					selItem.setLabel(lov.getTitle());
					selItem.setValue(lov.getRowId());
					selList.add(selItem);
				
				
					// -- insert label '-- select --' at index 0
					if(selList.size() == 1) {
						SelectItem selItem_idx0 = new SelectItem();
						selItem_idx0.setLabel("-- Select --");
						selItem_idx0.setValue("");
						
						SelectItem selItem_idx1 = new SelectItem();
						selItem_idx1.setLabel(selList.get(0).getLabel());
						selItem_idx1.setValue(selList.get(0).getValue());
	
						selList = new ArrayList<SelectItem>();
						selList.add(selItem_idx0);
						selList.add(selItem_idx1);
					}
				}
				// --
			} else {
				selItem = new SelectItem();
				selItem.setLabel("-- not found --");
				selItem.setValue("");
				selList.add(selItem);
			}
			semmco001tab2Bean.setContractDocType(selList);
			this.doGetDDLDocNew();
			this.searchContractFile();
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("ERROR FROM SEMMCO001Tab2Action initTab2");
			log.error(e.getMessage());
		}finally{
			docLst = null;
			selItem = null;
			selList = null;
			setSemeco001Bean(semeco001Bean);
			setSemmco001tab2Bean(semmco001tab2Bean);
		}
		return flag;
		
	}
	
	private void doGetDDLDocNew(){
		log.debug("####### Start SEMMCO001Tab2Action doGetDDLDocNew ########");
		ISiteContractService service = null;
		Contract contract = null;
		semmco001tab2Bean = getSemmco001tab2Bean();
		semeco001Bean = new SEMECO001Bean();
		semmco001Bean = getSemmco001Bean();
		List<Mco001Exp> docLst = null;
		SelectItem selItem = null;
		List<SelectItem> selList = new ArrayList<SelectItem>();
		try {
			service = (ISiteContractService) getBean("siteContractService");
			
			Mco001Exp criteria = new Mco001Exp();
			criteria.setCompany(semmco001Bean.getCompanyParam());
	
			docLst = service.querySPList(EQueryName.SP_MCO001_SRCH_DDL_DOC_NEW.name, criteria);
			
			
			//List<MSA001LovSP> retLst = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA001_SRCH_TEAM.name, semmsa003Bean.getLovObjParam());
			
			if(docLst != null && !docLst.isEmpty()){
				for(Mco001Exp lov : docLst){
					selItem = new SelectItem();
					selItem.setLabel(lov.getTitle());
					selItem.setValue(lov.getRowId());
					selList.add(selItem);
				
				
					// -- insert label '-- select --' at index 0
					if(selList.size() == 1) {
						SelectItem selItem_idx0 = new SelectItem();
						selItem_idx0.setLabel("-- Select --");
						selItem_idx0.setValue("");
						
						SelectItem selItem_idx1 = new SelectItem();
						selItem_idx1.setLabel(selList.get(0).getLabel());
						selItem_idx1.setValue(selList.get(0).getValue());
	
						selList = new ArrayList<SelectItem>();
						selList.add(selItem_idx0);
						selList.add(selItem_idx1);
					}
				}
				// --
			} else {
				selItem = new SelectItem();
				selItem.setLabel("-- not found --");
				selItem.setValue("");
				selList.add(selItem);
			}
			semmco001tab2Bean.setContractDocTypeNew(selList);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("######### Error SEMMCO001Tab2Action doGetDDLDocNew : "+e);
		}
		log.debug("####### End SEMMCO001Tab2Action doGetDDLDocNew ########");
	}

	private boolean searchContractFile() {
		boolean flag = false;
		semmco001tab2Bean = getSemmco001tab2Bean();
		List<Mco001SrchFileSP> to = null;
		semmco001tab2Bean.setContractFileSPList(null);
		try{
			IContractFileService service = (IContractFileService)getBean("contractFileService");
			Mco001SrchFileSP criteria = new Mco001SrchFileSP();
			criteria.setContractId(getSemmco001Bean().getContractIdParam());
			to = service.querySPList(EQueryName.SP_MCO001_SRCH_FILE.name, criteria);
			if(to != null && !to.isEmpty()){
				List<Mco001SrchFileSP> list = new ArrayList<Mco001SrchFileSP>();
				for(Mco001SrchFileSP file : to){
					Mco001SrchFileSP f = new Mco001SrchFileSP();
					f.setRowId(file.getRowId());
					f.setContractDocType(file.getContractDocType());
					f.setContractDocTypeName(file.getContractDocTypeName());
					f.setSeqNo(file.getSeqNo());
					f.setFilePath(file.getFilePath());
					f.setFileName(file.getFileName());
					f.setUpdateBy(file.getUpdateBy());
					if(file.getUpdateDt() != null) f.setUpdateDt(convertYearENtoTH(file.getUpdateDt()));
					list.add(f);
				}
				semmco001tab2Bean.setContractFileSPList(list);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco001tab2Bean(semmco001tab2Bean);
		return flag;
	}
	
	public void doDownloadContractFile() {
		IContractFileService service = null;
		ExportFileUtil exportFileUtil = null;
		String message = msg("message.fileNotFound");
		String filePath = null;
		String rowId = null;
		byte[] bytes = null;
		
		try{
			exportFileUtil = new ExportFileUtil();
			rowId = getFacesUtils().getRequestParameter("rowId").toString();
			service = (IContractFileService) getBean("contractFileService");
			filePath = service.queryContractFileByRowId(rowId).getFilePath();
			log.debug("doDownloadContractFile filePath : "+filePath);
			bytes = exportFileUtil.readFileContent(filePath, null);
			if(bytes != null && bytes.length > 0) {
				exportFileUtil.exportFile(filePath, bytes);
			} else {
				exportFileUtil.exportFile("OMS:"+ 
						DataUtil.separator4OS() + message + 
						DataUtil.separator4OS() + "." + 
						ServiceConstants.TYPE_DOC, message.getBytes());
				addMessageWarn("M0004");
			}
		}catch(Exception e){
			log.error("ERROR IN CLASS " + getClass() + ".doDownloadContractFile : " + e);
			e.printStackTrace();
		}finally{
			exportFileUtil = null;
			filePath = null;
			rowId = null;
			bytes = null;	
		}		
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmco001tab2Bean().setTmpRowId(rowId);
	}

	private SEMMCO001Tab2Bean semmco001tab2Bean;
	
	public SEMMCO001Tab2Bean getSemmco001tab2Bean() {
		return (SEMMCO001Tab2Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco001tab2Bean");
	}
	
	public void setSemmco001tab2Bean(SEMMCO001Tab2Bean semmco001tab2Bean) {
		this.semmco001tab2Bean = semmco001tab2Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco001tab2Bean", this.semmco001tab2Bean);
	}

	private SEMMCO001Bean semmco001Bean;
	
	public SEMMCO001Bean getSemmco001Bean() {
		return (SEMMCO001Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco001Bean");
	}

	public void setSemmco001Bean(SEMMCO001Bean semmco001Bean) {
		this.semmco001Bean = semmco001Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco001Bean", this.semmco001Bean);
	}
	
	private FileUploadBean fileUploadBean;
	
	public FileUploadBean getFileUploadBean() {
		return (FileUploadBean)getFacesUtils().getSessionMapValue("fileUploadBean");
	}
	
	public void setFileUploadBean(FileUploadBean fileUploadBean) {
		getFacesUtils().setSessionMapValue("fileUploadBean", fileUploadBean);
	}

	private SEMECO001Bean semeco001Bean;
	
	public SEMECO001Bean getSemeco001Bean() {
		return (SEMECO001Bean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semeco001Bean");
	}

	public void setSemeco001Bean(SEMECO001Bean semeco001Bean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semeco001Bean", semeco001Bean);
	}
	
	private SEMMCO001Tab1Bean semmco001tab1Bean;
	
	public SEMMCO001Tab1Bean getSemmco001tab1Bean() {
		return (SEMMCO001Tab1Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco001tab1Bean");
	}

	public void setSemmco001tab1Bean(SEMMCO001Tab1Bean semmco001tab1Bean) {
		this.semmco001tab1Bean = semmco001tab1Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco001tab1Bean", this.semmco001tab1Bean);
	}
	
	private SEMMCO001Tab1Action semmco001tab1Action;

	public SEMMCO001Tab1Action getSemmco001tab1Action() {
		if(semmco001tab1Action == null){
			semmco001tab1Action = new SEMMCO001Tab1Action();
		}
		return semmco001tab1Action;
	}

	public void setSemmco001tab1Action(SEMMCO001Tab1Action semmco001tab1Action) {
		this.semmco001tab1Action = semmco001tab1Action;
	}
}
