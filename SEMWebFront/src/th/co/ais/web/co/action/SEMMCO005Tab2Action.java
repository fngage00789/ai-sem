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
import th.co.ais.web.co.bean.SEMMCO005Bean;
import th.co.ais.web.co.bean.SEMMCO005Tab1Bean;
import th.co.ais.web.co.bean.SEMMCO005Tab2Bean;
import th.co.ais.web.ir.bean.FileUploadBean;
import th.co.ais.web.report.bean.SEMECO001Bean;
import th.co.ais.web.report.util.ExportFileUtil;

public class SEMMCO005Tab2Action extends AbstractAction{

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
		semmco005tab2Bean = getSemmco005tab2Bean();
		IContractFileService service = (IContractFileService)getBean("contractFileService");
		try{
			if(semmco005tab2Bean.getContractFile() != null){
				service.deleteContractFile(semmco005tab2Bean.getContractFile());
				addMessageInfo("M0002");
				// do search contract file
				this.searchContractFile();
			}
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0002");
		}
		setSemmco005tab2Bean(semmco005tab2Bean);
		return flag;
	}

	private boolean initDeleteContractFile() {
		boolean flag = false;
		semmco005tab2Bean = getSemmco005tab2Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		IContractFileService service = (IContractFileService)getBean("contractFileService");
		try{
			if(rowId != null){
				semmco005tab2Bean.setContractFile(service.queryContractFileByRowId(rowId));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco005tab2Bean(semmco005tab2Bean);
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
		SEMMCO005Tab2Bean semmco005tab2Bean = new SEMMCO005Tab2Bean();
		semmco005tab2Bean.setContractDocType(new ArrayList<SelectItem>());
		semmco005tab2Bean.setContractFileSPList(new ArrayList<Mco001SrchFileSP>());
		setSemmco005tab2Bean(semmco005tab2Bean);
	}
	
	public boolean initTab2() {
		boolean flag = false;
		ISiteContractService service = null;
		Contract contract = null;
		semmco005tab2Bean = getSemmco005tab2Bean();
		semeco001Bean = new SEMECO001Bean();
		semmco005Bean = getSemmco005Bean();
		
		try {
			service = (ISiteContractService) getBean("siteContractService");
			contract = service.queryContractByRowId(semmco005Bean.getContractIdParam());
			if (contract != null) {
				semeco001Bean.setContractDocType(contract.getContractDocType());
			}
			// drop down contract doc type if company = AIS where LOV_COND1 = AIS else where LOV_COND2 = FLX
			semmco005tab2Bean.setContractDocType(getLovItemsByType(ELovType.T_SI_CONTRACT_DOC_TYPE.name, EX_AND, null, null, ELovVal.V_CO_INTERNAL.name));
			this.searchContractFile();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		setSemeco001Bean(semeco001Bean);
		setSemmco005tab2Bean(semmco005tab2Bean);
		
		return flag;
		
	}

	private boolean searchContractFile() {
		boolean flag = false;
		semmco005tab2Bean = getSemmco005tab2Bean();
		List<Mco001SrchFileSP> to = null;
		semmco005tab2Bean.setContractFileSPList(null);
		try{
			IContractFileService service = (IContractFileService)getBean("contractFileService");
			Mco001SrchFileSP criteria = new Mco001SrchFileSP();
			criteria.setContractId(getSemmco005Bean().getContractIdParam());
			criteria.setInternalFlag("Y");
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
				semmco005tab2Bean.setContractFileSPList(list);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco005tab2Bean(semmco005tab2Bean);
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
		getSemmco005tab2Bean().setTmpRowId(rowId);
	}

	private SEMMCO005Tab2Bean semmco005tab2Bean;
	
	public SEMMCO005Tab2Bean getSemmco005tab2Bean() {
		return (SEMMCO005Tab2Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco005tab2Bean");
	}
	
	public void setSemmco005tab2Bean(SEMMCO005Tab2Bean semmco005tab2Bean) {
		this.semmco005tab2Bean = semmco005tab2Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco005tab2Bean", this.semmco005tab2Bean);
	}

	private SEMMCO005Bean semmco005Bean;
	
	public SEMMCO005Bean getSemmco005Bean() {
		return (SEMMCO005Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco005Bean");
	}

	public void setSemmco005Bean(SEMMCO005Bean semmco005Bean) {
		this.semmco005Bean = semmco005Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco005Bean", this.semmco005Bean);
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
	
	private SEMMCO005Tab1Bean semmco005tab1Bean;
	
	public SEMMCO005Tab1Bean getSemmco005tab1Bean() {
		return (SEMMCO005Tab1Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco005tab1Bean");
	}

	public void setSemmco005tab1Bean(SEMMCO005Tab1Bean semmco005tab1Bean) {
		this.semmco005tab1Bean = semmco005tab1Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco005tab1Bean", this.semmco005tab1Bean);
	}
	
	private SEMMCO005Tab1Action semmco005tab1Action;

	public SEMMCO005Tab1Action getSemmco005tab1Action() {
		if(semmco005tab1Action == null){
			semmco005tab1Action = new SEMMCO005Tab1Action();
		}
		return semmco005tab1Action;
	}

	public void setSemmco005tab1Action(SEMMCO005Tab1Action semmco005tab1Action) {
		this.semmco005tab1Action = semmco005tab1Action;
	}
}
