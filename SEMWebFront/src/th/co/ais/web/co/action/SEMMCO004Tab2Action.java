package th.co.ais.web.co.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import th.co.ais.domain.co.Mco001SrchFileSP;
import th.co.ais.domain.si.Contract;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.rpt.util.DataUtil;
import th.co.ais.service.co.IContractFileService;
import th.co.ais.service.si.ISiteContractService;
import th.co.ais.util.ELovType;
import th.co.ais.util.ELovVal;
import th.co.ais.util.EQueryName;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.co.bean.SEMMCO004Bean;
import th.co.ais.web.co.bean.SEMMCO004Tab1Bean;
import th.co.ais.web.co.bean.SEMMCO004Tab2Bean;
import th.co.ais.web.ir.bean.FileUploadBean;
import th.co.ais.web.report.bean.SEMECO001Bean;
import th.co.ais.web.report.util.ExportFileUtil;

public class SEMMCO004Tab2Action extends AbstractAction{

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
		semmco004tab2Bean = getSemmco004tab2Bean();
		IContractFileService service = (IContractFileService)getBean("contractFileService");
		try{
			if(semmco004tab2Bean.getContractFile() != null){
				service.deleteContractFile(semmco004tab2Bean.getContractFile());
				addMessageInfo("M0002");
				// do search contract file
				this.searchContractFile();
			}
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0002");
		}
		setSemmco004tab2Bean(semmco004tab2Bean);
		return flag;
	}

	private boolean initDeleteContractFile() {
		boolean flag = false;
		semmco004tab2Bean = getSemmco004tab2Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		IContractFileService service = (IContractFileService)getBean("contractFileService");
		try{
			if(rowId != null){
				semmco004tab2Bean.setContractFile(service.queryContractFileByRowId(rowId));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco004tab2Bean(semmco004tab2Bean);
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
		SEMMCO004Tab2Bean semmco004tab2Bean = new SEMMCO004Tab2Bean();
		semmco004tab2Bean.setContractDocType(new ArrayList<SelectItem>());
		semmco004tab2Bean.setContractFileSPList(new ArrayList<Mco001SrchFileSP>());
		setSemmco004tab2Bean(semmco004tab2Bean);
	}
	
	public boolean initTab2() {
		boolean flag = false;
		ISiteContractService service = null;
		Contract contract = null;
		semmco004tab2Bean = getSemmco004tab2Bean();
		semeco001Bean = new SEMECO001Bean();
		semmco004Bean = getSemmco004Bean();
		
		try {
			service = (ISiteContractService) getBean("siteContractService");
			contract = service.queryContractByRowId(semmco004Bean.getContractIdParam());
			if (contract != null) {
				semeco001Bean.setContractDocType(contract.getContractDocType());
			}
			// drop down contract doc type if company = AIS where LOV_COND1 = AIS else where LOV_COND2 = FLX
//			if(semmco004Bean.getCompanyParam() != null && semmco004Bean.getCompanyParam().equals("AIS")){
//				semmco004tab2Bean.setContractDocType(getLovItemsByType(ELovType.T_SI_CONTRACT_DOC_TYPE.name, EX_AND,  ELovVal.V_CO_AIS.name, null, null));
//			}else{
				semmco004tab2Bean.setContractDocType(getLovItemsByType(ELovType.T_SI_CONTRACT_DOC_TYPE.name, EX_AND, null, null, ELovVal.V_CO_INTERNAL.name));
//			}
			this.searchContractFile();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		setSemeco001Bean(semeco001Bean);
		setSemmco004tab2Bean(semmco004tab2Bean);
		
		return flag;
		
	}

	private boolean searchContractFile() {
		boolean flag = false;
		semmco004tab2Bean = getSemmco004tab2Bean();
		List<Mco001SrchFileSP> to = null;
		semmco004tab2Bean.setContractFileSPList(null);
		semmco004Bean = getSemmco004Bean();
		try{
			IContractFileService service = (IContractFileService)getBean("contractFileService");
			Mco001SrchFileSP criteria = new Mco001SrchFileSP();
			criteria.setContractId(getSemmco004Bean().getContractIdParam());
			criteria.setInternalFlag("Y");
			criteria.setGroupNo(semmco004Bean.getGroupNumber());
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
				semmco004tab2Bean.setContractFileSPList(list);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco004tab2Bean(semmco004tab2Bean);
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
		getSemmco004tab2Bean().setTmpRowId(rowId);
	}

	private SEMMCO004Tab2Bean semmco004tab2Bean;
	
	public SEMMCO004Tab2Bean getSemmco004tab2Bean() {
		return (SEMMCO004Tab2Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco004tab2Bean");
	}
	
	public void setSemmco004tab2Bean(SEMMCO004Tab2Bean semmco004tab2Bean) {
		this.semmco004tab2Bean = semmco004tab2Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco004tab2Bean", this.semmco004tab2Bean);
	}

	private SEMMCO004Bean semmco004Bean;
	
	public SEMMCO004Bean getSemmco004Bean() {
		return (SEMMCO004Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco004Bean");
	}

	public void setSemmco004Bean(SEMMCO004Bean semmco004Bean) {
		this.semmco004Bean = semmco004Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco004Bean", this.semmco004Bean);
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
	
	private SEMMCO004Tab1Bean semmco004tab1Bean;
	
	public SEMMCO004Tab1Bean getSemmco004tab1Bean() {
		return (SEMMCO004Tab1Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco004tab1Bean");
	}

	public void setSemmco004tab1Bean(SEMMCO004Tab1Bean semmco004tab1Bean) {
		this.semmco004tab1Bean = semmco004tab1Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco004tab1Bean", this.semmco004tab1Bean);
	}
	
	private SEMMCO004Tab1Action semmco004tab1Action;

	public SEMMCO004Tab1Action getSemmco004tab1Action() {
		if(semmco004tab1Action == null){
			semmco004tab1Action = new SEMMCO004Tab1Action();
		}
		return semmco004tab1Action;
	}

	public void setSemmco004tab1Action(SEMMCO004Tab1Action semmco004tab1Action) {
		this.semmco004tab1Action = semmco004tab1Action;
	}
}
