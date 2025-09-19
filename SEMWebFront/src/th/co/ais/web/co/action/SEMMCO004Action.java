package th.co.ais.web.co.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.co.ContractCheckDoc;
import th.co.ais.domain.co.ContractStatus;
import th.co.ais.domain.co.Mco001CheckAddAbleSP;
import th.co.ais.domain.co.Mco001SrchSP;
import th.co.ais.domain.co.Mco001UpdateCheckDocLSP;
import th.co.ais.domain.co.Mco001UpdateCheckDocSP;
import th.co.ais.domain.co.Mco002CheckNoFileSP;
import th.co.ais.domain.co.Mco002SrchContractStatusSP;
import th.co.ais.domain.co.Mco002UpdateContractStatusSP;
import th.co.ais.domain.co.Mco004Act;
import th.co.ais.domain.co.Mco004SrchLovStatusSP;
import th.co.ais.domain.co.Mco004SrchSP;
import th.co.ais.domain.co.Mco004DefaultDutySP;
import th.co.ais.domain.co.Mco004UpdateDuty;
import th.co.ais.domain.co.Mco005UpdateContractStatusSP;
import th.co.ais.domain.co.Mco006SrchContractStatusSP;
import th.co.ais.domain.gm.Attachment;
import th.co.ais.domain.si.Contract;
import th.co.ais.domain.si.Msi004CheckContractNoSP;
import th.co.ais.domain.si.Msi004GenContractNoSP;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.co.IContractCheckDocService;
import th.co.ais.service.co.IContractStatusService;
import th.co.ais.service.gm.IAttachmentService;
import th.co.ais.service.si.ISiteContractService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupUploadFilePictureBean;
import th.co.ais.web.co.bean.SEMMCO002Bean;
import th.co.ais.web.co.bean.SEMMCO004Bean;
import th.co.ais.web.ir.bean.FileUploadBean;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.report.util.ReportDateUtil;
import th.co.ais.web.si.action.SEMMSI004Action;
import th.co.ais.web.si.action.SEMMSI004Tab1Action;
import th.co.ais.web.si.action.SEMMSI004Tab2Action;
import th.co.ais.web.si.action.SEMMSI004Tab3Action;
import th.co.ais.web.si.action.SEMMSI004Tab4Action;
import th.co.ais.web.si.action.SEMMSI004Tab5Action;
import th.co.ais.web.si.action.SEMMSI004Tab6Action;
import th.co.ais.web.si.action.SEMMSI004Tab7Action;
import th.co.ais.web.si.bean.SEMMSI004Bean;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.SemUtils;

public class SEMMCO004Action extends AbstractAction {

	private Logger log = Logger.getLogger(getClass());
	private SEMMCO004Bean semmco004Bean;
	
	private SEMMCO004Bean getSemmco004Bean(){
		SEMMCO004Bean semmco004Bean = (SEMMCO004Bean)getFacesUtils().getSessionMapValue("semmco004Bean");
		if(semmco004Bean == null)
			semmco004Bean = new SEMMCO004Bean();
		return semmco004Bean;
	}
	
	private void setSemmco004Bean(SEMMCO004Bean semmco004Bean){
		this.semmco004Bean = semmco004Bean;
		getFacesUtils().setSessionMapValue("semmco004Bean", semmco004Bean);
	}
	
	private PopupUploadFilePictureBean popupUploadFilePictureBean;
	public PopupUploadFilePictureBean getPopupUploadFilePictureBean() {
		return ((PopupUploadFilePictureBean)getFacesUtils().getSessionMapValue("popupUploadFilePictureBean")!=null)?(PopupUploadFilePictureBean)getFacesUtils().getSessionMapValue("popupUploadFilePictureBean"):new PopupUploadFilePictureBean();
	}

	public void setPopupUploadFilePictureBean(PopupUploadFilePictureBean popupUploadFilePictureBean) {
		this.popupUploadFilePictureBean = popupUploadFilePictureBean;
		getFacesUtils().setSessionMapValue("popupUploadFilePictureBean", popupUploadFilePictureBean);
	}
	
	private SEMMCO004Tab1Action semmco004Tab1Action;
	
	public SEMMCO004Tab1Action getSemmco004Tab1Action() {
		if(semmco004Tab1Action == null){
			semmco004Tab1Action = new SEMMCO004Tab1Action();
		}
		return semmco004Tab1Action;
	}

	public void setSemmco004Tab1Action(SEMMCO004Tab1Action semmco004Tab1Action) {
		this.semmco004Tab1Action = semmco004Tab1Action;
	}
	
	private SEMMCO004Tab2Action semmco004Tab2Action;
	
	public SEMMCO004Tab2Action getSemmco004Tab2Action() {
		if(semmco004Tab2Action == null){
			semmco004Tab2Action = new SEMMCO004Tab2Action();
		}
		return semmco004Tab2Action;
	}

	public void setSemmco004Tab2Action(SEMMCO004Tab2Action semmco004Tab2Action) {
		this.semmco004Tab2Action = semmco004Tab2Action;
	}
	
private SEMMSI004Action semmsi004Action;
	
	public SEMMSI004Action getSemmsi004Action() {
		if(semmsi004Action == null){
			semmsi004Action = new SEMMSI004Action();
		}
		return semmsi004Action;
	}

	public void setSemmsi004Action(SEMMSI004Action semmsi004Action) {
		this.semmsi004Action = semmsi004Action;
	}
	
	private SEMMSI004Bean semmsi004Bean;
	
	public SEMMSI004Bean getSemmsi004Bean() {
		return (SEMMSI004Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004Bean");
	}
	
	public void setSemmsi004Bean(SEMMSI004Bean semmsi004Bean) {
		this.semmsi004Bean = semmsi004Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004Bean", this.semmsi004Bean);
	}

	private FileUploadBean fileUploadBean;
	
	public FileUploadBean getFileUploadBean() {
		return (FileUploadBean)getFacesUtils().getSessionMapValue("fileUploadBean");
	}
	
	public void setFileUploadBean(FileUploadBean fileUploadBean) {
		getFacesUtils().setSessionMapValue("fileUploadBean", fileUploadBean);
	}
	
	private SEMMSI004Tab1Action semmsi004tab1Action;

	public SEMMSI004Tab1Action getSemmsi004tab1Action() {
		if(semmsi004tab1Action == null){
			semmsi004tab1Action = new SEMMSI004Tab1Action();
		}
		return semmsi004tab1Action;
	}

	public void setSemmsi004tab1Action(SEMMSI004Tab1Action semmsi004tab1Action) {
		this.semmsi004tab1Action = semmsi004tab1Action;
	}
	
	private SEMMSI004Tab2Action semmsi004tab2Action;
	
	public SEMMSI004Tab2Action getSemmsi004tab2Action() {
		if(semmsi004tab2Action == null){
			semmsi004tab2Action = new SEMMSI004Tab2Action();
		}
		return semmsi004tab2Action;
	}

	public void setSemmsi004tab2Action(SEMMSI004Tab2Action semmsi004tab2Action) {
		this.semmsi004tab2Action = semmsi004tab2Action;
	}
	
	private SEMMSI004Tab3Action semmsi004tab3Action;

	public SEMMSI004Tab3Action getSemmsi004tab3Action() {
		if(semmsi004tab3Action == null){
			semmsi004tab3Action = new SEMMSI004Tab3Action();
		}
		return semmsi004tab3Action;
	}

	public void setSemmsi004tab3Action(SEMMSI004Tab3Action semmsi004tab3Action) {
		this.semmsi004tab3Action = semmsi004tab3Action;
	}
	
	private SEMMSI004Tab4Action semmsi004tab4Action;

	public SEMMSI004Tab4Action getSemmsi004tab4Action() {
		if(semmsi004tab4Action == null){
			semmsi004tab4Action = new SEMMSI004Tab4Action();
		}
		return semmsi004tab4Action;
	}

	public void setSemmsi004tab4Action(SEMMSI004Tab4Action semmsi004tab4Action) {
		this.semmsi004tab4Action = semmsi004tab4Action;
	}
	
	private SEMMSI004Tab5Action semmsi004tab5Action;

	public SEMMSI004Tab5Action getSemmsi004tab5Action() {
		if(semmsi004tab5Action == null){
			semmsi004tab5Action = new SEMMSI004Tab5Action();
		}
		return semmsi004tab5Action;
	}

	public void setSemmsi004tab5Action(SEMMSI004Tab5Action semmsi004tab5Action) {
		this.semmsi004tab5Action = semmsi004tab5Action;
	}
	
	private SEMMSI004Tab6Action semmsi004tab6Action;

	public SEMMSI004Tab6Action getSemmsi004tab6Action() {
		if(semmsi004tab6Action == null){
			semmsi004tab6Action = new SEMMSI004Tab6Action();
		}
		return semmsi004tab6Action;
	}

	public void setSemmsi004tab6Action(SEMMSI004Tab6Action semmsi004tab6Action) {
		this.semmsi004tab6Action = semmsi004tab6Action;
	}
	private SEMMSI004Tab7Action semmsi004tab7Action;

	public SEMMSI004Tab7Action getSemmsi004tab7Action() {
		if(semmsi004tab7Action == null){
			semmsi004tab7Action = new SEMMSI004Tab7Action();
		}
		return semmsi004tab7Action;
	}

	public void setSemmsi004tab7Action(SEMMSI004Tab7Action semmsi004tab7Action) {
		this.semmsi004tab7Action = semmsi004tab7Action;
	}
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		}else if(methodWithNavi.equalsIgnoreCase("doClear")){
			doClear();
		}else if(methodWithNavi.equalsIgnoreCase("doSearchSummary")){
			flag = doSearchSummary();
		}else if(methodWithNavi.equalsIgnoreCase("doClearSummary")){
			doClearSummary();
		}else if(methodWithNavi.equalsIgnoreCase("initPopUpSummary")){
			initSummaryPopup();
		}else if(methodWithNavi.equalsIgnoreCase("doBack")){
			flag = doBack();
		}else if(methodWithNavi.equalsIgnoreCase("doSave")){
			flag = doSave();
		}else if(methodWithNavi.equalsIgnoreCase("initSubRentInfo")){
			flag = initSubRentInfo();
		}else if(methodWithNavi.equalsIgnoreCase("doOk")){
			doOk();
		}else if(methodWithNavi.equalsIgnoreCase("initNewContractNo")){
			initNewContractNo();
		}else if (methodWithNavi.equalsIgnoreCase("doCheckGroup")){
			doCheckGroup();
		}else if (methodWithNavi.equalsIgnoreCase("initUpdateContract")) {
			flag = initUpdateContract();
		}else if (methodWithNavi.equalsIgnoreCase("initSiteInfo")) {
			flag = initSiteInfo();
		}else if(methodWithNavi.equalsIgnoreCase("doClearSession")){
			flag = doClearSession();
		}else if (methodWithNavi.equalsIgnoreCase("doUpdateTab")) {
			flag = doUpdateTab();
		}else if (methodWithNavi.equalsIgnoreCase("initAddContractStatus")) {
			flag = initAddContractStatus();
		}else if (methodWithNavi.equalsIgnoreCase("doSaveContractStatus")) {
			flag = doSaveContractStatus();
		}else if (methodWithNavi.equalsIgnoreCase("doUpdateDutyContract")) {
			flag = doUpdateDutyContract();
		}else if (methodWithNavi.equalsIgnoreCase("initUpdateDuty")) {
			flag = initUpdateDuty();
		}
		
		return flag;
	}

	
	
	
	
	@Override
	public void clearSessionNotUsed() {

	}

	@Override
	public void init() {
		SEMMCO004Bean semmco004Bean = new SEMMCO004Bean();
		PopupUploadFilePictureBean uploadBean = new PopupUploadFilePictureBean(); 
		semmco004Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmco004Bean.setMonthList(ReportDateUtil.getDDLMonthTH());
		semmco004Bean.setMonthPopupList(ReportDateUtil.getDDLMonthTH());
		semmco004Bean.setRegionList(getRegionItems());
		
		
		semmco004Bean.setContractStatusList(getLovItemsByType(ELovType.T_CO_CONTRACT_STATUS.name));
		semmco004Bean.setContractStatus(new ContractStatus());
		semmco004Bean.setContract(new Contract());
		
		semmco004Bean.setSubRentStatusList(getLovItemsByType(ELovType.INTERNAL_CONTRACT_STATUS.name));
		List<SelectItem> subRentTypeList = getLovItemsByType(ELovType.T_CO_SUB_RENT_TYPE.name);
		List<SelectItem> tmp = new ArrayList<SelectItem>();
		for(int i=1;i<subRentTypeList.size();i++){
			tmp.add(subRentTypeList.get(i));
		}
		semmco004Bean.setSubRentTypeList(tmp);
		semmco004Bean.setCriteriaSrch(new Mco004SrchSP());
		semmco004Bean.setMco004SrchSPList(new ArrayList<WrapperBeanObject<Mco004SrchSP>>());
		semmco004Bean.setSiteTypeList(getLovItemsByType(ELovType.T_SI_SITE_TYPE.name));
		semmco004Bean.setCriteriaSummarySrch(new Mco004SrchSP());
		semmco004Bean.setSummaryList(new ArrayList<Mco004SrchSP>());
		semmco004Bean.setSubRentInfo(new Mco004SrchSP());
		semmco004Bean.setPopupContractNo(new Mco004SrchSP());
		semmco004Bean.setDisableSelectAll(true);
		//Default Value Search Page
		log.debug("ReportDateUtil.getCurrentMonth() = "+ReportDateUtil.getCurrentMonth());
		semmco004Bean.getCriteriaSrch().setMonth((ReportDateUtil.getCurrentMonth()<9)?"0"+(ReportDateUtil.getCurrentMonth()+1)+"":(ReportDateUtil.getCurrentMonth()+1)+"");
		semmco004Bean.getCriteriaSrch().setYear((ReportDateUtil.getCurrentYear()+543)+"");
		semmco004Bean.getCriteriaSrch().setSubRentType("01");
		semmco004Bean.getCriteriaSrch().setSubRentStatus("01");
		//Set and Remove --select-- in subRentSummaryTypeList
		List<SelectItem> subRentSummaryTypeList = getLovItemsByType(ELovType.T_CO_SUB_RENT_SEARCH_SUMMARY.name);
		for(int i=0;i<subRentSummaryTypeList.size();i++){
			SelectItem tmpSelect = subRentSummaryTypeList.get(i);
			if(StringUtils.isEmpty((String)tmpSelect.getValue())){
				subRentSummaryTypeList.remove(i);
			}
		}
		semmco004Bean.setSubRentSummaryTypeList(subRentSummaryTypeList);
		semmco004Bean.setBorrowOfficerList(getLovItemsByType(ELovType.T_CO_BORROW_OFFICER.name));
		semmco004Bean.setRenderedMsgFormSearch(true);
		semmco004Bean.setRenderedAttachment(false);
		semmco004Bean.setRenderedColDel(true);
		semmco004Bean.setRenderedTab2(true);
		semmco004Bean.setRenderedDataTab1(true);
		getSemmco004tab1Action().init();
		getSemmco004tab2Action().init();
		uploadBean.setModuleList(new ArrayList<SelectItem>());
		uploadBean.setSubModuleList(new ArrayList<SelectItem>());
		setPopupUploadFilePictureBean(uploadBean);
		setSemmco004Bean(semmco004Bean);
		
	}

	@Override
	public boolean validate() {
		boolean flag = false;
//		if((null==getSemmco004Bean().getCriteriaSrch().getEffDateFrom()) ||
//				null==getSemmco004Bean().getCriteriaSrch().getExpDateTo()){
//			addMessageError("W0001", msg("message.monthYear"));
//			flag = true;
//		}
//		if(StringUtils.isEmpty(getSemmco004Bean().getCriteriaSrch().getRegion())){
//			addMessageError("W0001", msg("message.region"));
//			flag = true;
//		}
//		
//		if(StringUtils.isEmpty(getSemmco004Bean().getCriteriaSrch().getSubRentType())){
//			addMessageError("W0001", msg("message.networkType"));
//			flag = true;
//		}
//		
//		if(StringUtils.isEmpty(getSemmco004Bean().getCriteriaSrch().getSubRentStatus())){
//			addMessageError("W0001", msg("message.bgStatus"));
//			flag = true;
//		}
		return flag;
	}
	
	public boolean validateSummary() {
		boolean flag = false;
		if(StringUtils.isEmpty(getSemmco004Bean().getCriteriaSummarySrch().getRegion())){
			addMessageError("W0001", msg("message.region"));
			flag = true;
		}
		
		return flag;
	}
	
	public boolean doSearch(){
		boolean flag = false;
		semmco004Bean = getSemmco004Bean();
		semmco004Bean.setDisableExport(true);
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		List<Mco004SrchSP> to = null;
		semmco004Bean.setChkAll(false);
		semmco004Bean.setDisableSelectAll(true);
		try{
			if(validate()){
				semmco004Bean.setRenderedMsgFormSearch(true);
				return flag;
			}else{
				semmco004Bean.setRenderedMsgFormSearch(false);
				Mco004SrchSP crieria = semmco004Bean.getCriteriaSrch();
				if(StringUtils.isNotEmpty(crieria.getYear())){
					crieria.setYear((Integer.parseInt(crieria.getYear())-543)+"");
				}
				
				String pico = "N";
				//Adding by mr.john 22/04/2011 from SA (Surasit)
				if(semmco004Bean.getCriteriaSrch().isPico()){
					pico = "Y";
				}else{
					pico = "N";
				}
				//set pico.
				semmco004Bean.getCriteriaSrch().setStrPico(pico);
				to = service.querySPList(EQueryName.SP_MCO004_SRCH.name, semmco004Bean.getCriteriaSrch());
				
				if(StringUtils.isNotEmpty(crieria.getYear())){
					crieria.setYear((Integer.parseInt(crieria.getYear())+543)+"");
				}
				semmco004Bean.setMco004SrchSPList(new ArrayList<WrapperBeanObject<Mco004SrchSP>>());
				if(to != null && !to.isEmpty()){
					semmco004Bean.setRenderedMsgDataNotFound(false);
					for (int i=0; i<to.size(); i++) {
						Mco004SrchSP o = (Mco004SrchSP)to.get(i);
						WrapperBeanObject<Mco004SrchSP> tmpWrapperBean = new WrapperBeanObject<Mco004SrchSP>();
						
						//convert date to TH year for displaying.
//						o.setUpdateDt(convertYearENtoTH(o.getUpdateDt()));
//						o.setEffectiveDt(convertYearENtoTH(o.getEffectiveDt()));
//						o.setExpireDt(convertYearENtoTH(o.getExpireDt()));
						o.setEffectiveDtStr(convertYearENtoTHStr(o.getEffectiveDt()));
						o.setExpireDtStr(convertYearENtoTHStr(o.getExpireDt()));
						tmpWrapperBean.setDataObj(o);
						tmpWrapperBean.setMessage("");
						tmpWrapperBean.setCheckBox(false);
						semmco004Bean.getMco004SrchSPList().add(tmpWrapperBean);
					}
				}else{
					semmco004Bean.setRenderedMsgDataNotFound(true);
				}
				setSemmco004Bean(semmco004Bean);
				flag = true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public void doClear(){
		semmco004Bean = getSemmco004Bean();
		semmco004Bean.setCriteriaSrch(new Mco004SrchSP());
		semmco004Bean.setMco004SrchSPList(new ArrayList<WrapperBeanObject<Mco004SrchSP>>());
		setSemmco004Bean(semmco004Bean);
	}
	
	public boolean doSearchSummary(){
		boolean flag = false;
		semmco004Bean = getSemmco004Bean();
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		List<Mco004SrchSP> to = null;
		try{
			
			if(StringUtils.isNotEmpty(getSemmco004Bean().getCriteriaSummarySrch().getSubRentSummaryType())){
//				if(validateSummary()){
//					semmco004Bean.setRenderedMsgSummaryPopup(true);
//					return flag;
//				}else{
				
					Mco004SrchSP criteriaSummarySrch =  new Mco004SrchSP();
					criteriaSummarySrch.setSubRentSummaryType(semmco004Bean.getCriteriaSummarySrch().getSubRentSummaryType());
					criteriaSummarySrch.setMonth(semmco004Bean.getCriteriaSummarySrch().getMonth());
					if(StringUtils.isNotEmpty(semmco004Bean.getCriteriaSummarySrch().getYear())){
						criteriaSummarySrch.setYear(Integer.toString(Integer.parseInt(semmco004Bean.getCriteriaSummarySrch().getYear())-543));
					}
					criteriaSummarySrch.setRegion(semmco004Bean.getCriteriaSummarySrch().getRegion());
					to = service.querySPList(EQueryName.SP_MCO004_SRCH_SUMMARY.name, criteriaSummarySrch);
					
					semmco004Bean.setSummaryList(new ArrayList<Mco004SrchSP>());
					if(to != null && !to.isEmpty()){
						semmco004Bean.setRenderedMsgDataNotFound(false);
						for(int i=0;i<to.size();i++){
							if(to.get(i) != null)
								to.get(i).setMonthYear(SemUtils.convertMonthYearEN2MonthYearTH(to.get(i).getMonthYear()));
						}
						semmco004Bean.setSummaryList(to);
	//					for (int i=0; i<to.size(); i++) {
	//						Mco004SrchSP o = (Mco004SrchSP)to.get(i);
	//						
	//						//convert date to TH year for displaying.
	////						o.setUpdateDt(convertYearENtoTH(o.getUpdateDt()));
	//						
	//						semmco004Bean.getSummaryList().add(o);
	//					}
					}
//				}
				setSemmco004Bean(semmco004Bean);
				flag = true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public void doClearSummary(){
		getSemmco004Bean().setCriteriaSummarySrch(new Mco004SrchSP());
		getSemmco004Bean().setSummaryList(new ArrayList<Mco004SrchSP>());
	}
	
	public void initSummaryPopup(){
		doClearSummary();
		getSemmco004Bean().getCriteriaSummarySrch().setSubRentSummaryType("02");
		getSemmco004Bean().getCriteriaSummarySrch().setYear(Integer.toString(Calendar.getInstance(Locale.ENGLISH).get(Calendar.YEAR)+543));
		getSemmco004Bean().setMonthList(ReportDateUtil.getDDLMonthTH());
	}
	
	public boolean doSave(){
		boolean flag = false;
		semmco004Bean = getSemmco004Bean();
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		List<Mco004SrchSP> to = null;
		Mco004SrchSP subRentInfo = semmco004Bean.getSubRentInfo();
		subRentInfo.setCurrentUser(getUserLogIn());
		try{
			//Case Renew
			if("01".equals(subRentInfo.getSubRentType())){
				
				if(StringUtils.isEmpty(subRentInfo.getSubRentId())){
					//Case Sub Rent Id is null
					mco004Insert(subRentInfo);
				}else{
					//Case Sub Rent Id is not null
					mco004Update(subRentInfo);
				}
			}else{
				List<Msi004CheckContractNoSP> result = new ArrayList<Msi004CheckContractNoSP>();
				Msi004CheckContractNoSP criteria = new Msi004CheckContractNoSP();
				criteria.setContractNo(subRentInfo.getLesseeContractNo());
				criteria.setSiteInfoId(subRentInfo.getLesseeSiteInfoId());
				//Check Contract No
				result = service.querySPList(EQueryName.SP_MSI004_CHK_CONTRACT_NO.name, criteria);
				if (result != null && !result.isEmpty() && result.get(0).getResultMsg().equals("Success")) {
					if(StringUtils.isEmpty(subRentInfo.getSubRentId())){
						//Case Sub Rent Id is null
						mco004Insert(subRentInfo);
					}else{
						//Case Sub Rent Id is not null
						mco004Update(subRentInfo);
					}
				}else if(to != null && !to.isEmpty()){
					FrontMessageUtils.addMessageError(result.get(0).getMessage());
				}
			}
			semmco004Bean.setRenderedMsgFormSearch(true);
			if(!StringUtils.equalsIgnoreCase("init", semmco004Bean.getFromInitPage())) {
//				doSearch();
			}
			
			setSemmco004Bean(semmco004Bean);
			flag = true;
			log.debug("Success");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean initSubRentInfo(){
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		semmco004Bean = getSemmco004Bean();
		List<WrapperBeanObject<Mco004SrchSP>> tmpList = semmco004Bean.getMco004SrchSPList();
		Mco004SrchSP tmp = new Mco004SrchSP();
		semmco004Bean.setSubRentInfo(new Mco004SrchSP());
		if(StringUtils.isNotEmpty(rowId)){
			for(int i=0;i<tmpList.size();i++){			
				tmp = (Mco004SrchSP)tmpList.get(i).getDataObj();
				if(rowId.equals(tmp.getRowId())){
					semmco004Bean.setSubRentInfo(new Mco004SrchSP(tmp));
					break;
				}
			}
		}
		setSemmco004Bean(semmco004Bean);
		return true;
	}
	
	public void mco004Insert(Mco004SrchSP subRentInfo){
		List<Mco004SrchSP> to = null;
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		try{
			to = service.querySPList(EQueryName.SP_MCO004_INSERT.name, subRentInfo);
			if (to != null && !to.isEmpty() && to.get(0).getResult().equals("Success")) {
				if(!StringUtils.equalsIgnoreCase("init", semmco004Bean.getFromInitPage())){
					addMessageInfo("M0001");
				}
				semmco004Bean.getSubRentInfo().setSubRentId(to.get(0).getSubRentId());
				semmco004Bean.getSubRentInfo().setLesseeSiteInfoId(to.get(0).getLesseeSiteInfoId());
			}else if(to != null && !to.isEmpty()){
	//			FrontMessageUtils.addMessageError(to.get(0).getResultMsg());
				if(!StringUtils.equalsIgnoreCase("init", semmco004Bean.getFromInitPage())){
					addMessageInfo("E0001");
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void mco004Update(Mco004SrchSP subRentInfo){
		List<Mco004SrchSP> to = null;
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		try{
			to = service.querySPList(EQueryName.SP_MCO004_UPDATE.name, subRentInfo);
			if (to != null && !to.isEmpty() && to.get(0).getResult().equals("Success")) {
				if(!StringUtils.equalsIgnoreCase("init", semmco004Bean.getFromInitPage())){
					addMessageInfo("M0001");
				}	
			}else if(to != null && !to.isEmpty()){
	//			FrontMessageUtils.addMessageError(to.get(0).getResultMsg());
				addMessageInfo("E0001");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doOk(){
		StringBuffer contractNo = new StringBuffer();
		contractNo.append(getSemmco004Bean().getPopupContractNo().getContractNo1()+" "+getSemmco004Bean().getPopupContractNo().getContractNo2());
		if(StringUtils.isNotEmpty(getSemmco004Bean().getPopupContractNo().getContractNo3()))
			contractNo.append("."+getSemmco004Bean().getPopupContractNo().getContractNo3());
		getSemmco004Bean().getSubRentInfo().setLesseeContractNo(contractNo.toString());
		getSemmco004Bean().getSubRentInfo().setLesseeCompany(getSemmco004Bean().getPopupContractNo().getLesseeCompany());
		getSemmco004Bean().getSubRentInfo().setLesseeSiteType(getSemmco004Bean().getPopupContractNo().getLesseeSiteType());
	}
	
	public void initNewContractNo(){
		semmco004Bean = getSemmco004Bean();
		semmco004Bean.setPopupContractNo(new Mco004SrchSP());
		semmco004Bean.getPopupContractNo().setLesseeCompany(semmco004Bean.getSubRentInfo().getLesseeCompany());
		semmco004Bean.getPopupContractNo().setLesseeRegion(semmco004Bean.getSubRentInfo().getLesseeRegion());
		semmco004Bean.getPopupContractNo().setLesseeSiteType(semmco004Bean.getSubRentInfo().getLesseeSiteType());
		setSemmco004Bean(semmco004Bean);
		if(StringUtils.isNotEmpty(semmco004Bean.getSubRentInfo().getLesseeCompany()) &&
			StringUtils.isNotEmpty(semmco004Bean.getSubRentInfo().getLesseeRegion()) &&
			StringUtils.isNotEmpty(semmco004Bean.getSubRentInfo().getLesseeSiteType())){
			getContractNo();
		}
		
	}
	
	public void getContractNo(){
		semmco004Bean = getSemmco004Bean();
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		Msi004GenContractNoSP criteria = new Msi004GenContractNoSP();
		List<Msi004GenContractNoSP> result = new ArrayList<Msi004GenContractNoSP>();
		try{
			criteria.setCompany(semmco004Bean.getPopupContractNo().getLesseeCompany());
			criteria.setRegion(semmco004Bean.getPopupContractNo().getLesseeRegion());
			criteria.setSiteType(semmco004Bean.getPopupContractNo().getLesseeSiteType());
			result = service.querySPList(EQueryName.SP_MSI004_GEN_CONTRACT_NO.name, criteria);
			if(result != null && !result.isEmpty()){
				String contractNo = result.get(0).getContractNo();
				semmco004Bean.getPopupContractNo().setLesseeContractNo(contractNo);
				semmco004Bean.getPopupContractNo().setContractNo1(contractNo.substring(0,contractNo.indexOf(" ")));
				semmco004Bean.getPopupContractNo().setContractNo2(contractNo.substring(contractNo.indexOf(" ")+1, contractNo.length()));
			}
			setSemmco004Bean(semmco004Bean);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean doBack(){
//		semmco004Bean = getSemmco004Bean();
//		List<WrapperBeanObject<Mco004SrchSP>> tmpList = semmco004Bean.getMco004SrchSPList();
//		Mco004SrchSP tmp = new Mco004SrchSP();
//		if(StringUtils.isNotEmpty(semmco004Bean.getSubRentInfo().getRowId())){
//			for(int i=0;i<tmpList.size();i++){			
//				tmp = (Mco004SrchSP)tmpList.get(i).getDataObj();
//				if(semmco004Bean.getSubRentInfo().getRowId().equals(tmp.getRowId())){
//					tmpList.get(i).setDataObj(semmco004Bean.getSubRentInfo());
//					break;
//				}
//			}
//		}
//		setSemmco004Bean(semmco004Bean);
		doSearch();
		return true;
	}
	
	public void selectAll() {
		semmco004Bean = getSemmco004Bean();
		try{
			boolean chkAll = getSemmco004Bean().isChkAll();
			List<WrapperBeanObject<Mco004SrchSP>> mco004SechSPList = new ArrayList<WrapperBeanObject<Mco004SrchSP>>();
			mco004SechSPList = getSemmco004Bean().getMco004SrchSPList();
			for(int i = 0; i < mco004SechSPList.size(); i++) {
				Mco004SrchSP o = (Mco004SrchSP)mco004SechSPList.get(i).getDataObj();
				if (StringUtils.isNotEmpty(o.getRowId())) {
					mco004SechSPList.get(i).setCheckBox(chkAll);
				}
			}
			semmco004Bean.setMco004SrchSPList(mco004SechSPList);
			onRenderButton();
			
		}catch(NullPointerException ne){
			// TODO
			
		}catch(Exception e){
			//TODO
		}
		setSemmco004Bean(semmco004Bean);
	}
	
//	public void onRenderButton(){
//		semmco004Bean = getSemmco004Bean();
//		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
//		semmco004Bean.setTmpRowId(rowId);
//		
//		if (isCheckSELBox()) {
//			semmco004Bean.setDisableExport(false);
//		} else {
//			semmco004Bean.setDisableExport(true);
//		}
//		setSemmco004Bean(semmco004Bean);
//		log.debug(" Row ID : "+semmco004Bean.getTmpRowId());
//	}
	public void onRenderButton() {
		boolean chkall = true;
		semmco004Bean = getSemmco004Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("lesseeContractId");
		String status = (String)getFacesUtils().getRequestParameter("status");
		Boolean checked = new Boolean((String)getFacesUtils().getRequestParameter("checked"));
		
		semmco004Bean.setTmpRowId(rowId);
		
		setSelectRowWithSameStatus(status, checked);
		
		if (isCheckSELBox()) {
			semmco004Bean.setDisableExport(false);
			semmco004Bean.setDisabledBtnExportDuty(false);
		} else {
			semmco004Bean.setDisabledBtnAdd(true);
			semmco004Bean.setDisableExport(true);
			semmco004Bean.setDisabledBtnExportDuty(true);
		}
		Mco004SrchSP mco004Tmp;
		for(WrapperBeanObject<Mco004SrchSP> wrapper:semmco004Bean.getMco004SrchSPList()){
			mco004Tmp = (Mco004SrchSP)wrapper.getDataObj();
			if(!wrapper.isCheckBox() && StringUtils.equals(rowId, mco004Tmp.getLesseeContractId())){
				semmco004Bean.setChkSelAll(false);
				chkall = false;
				break;
			}
		}
//		if(chkall){
//			semmco004Bean.setChkSelAll(true);
//		}
		
		setSemmco004Bean(semmco004Bean);
		
	}
	
	
	private void setSelectRowWithSameStatus(String status, boolean checked){
		semmco004Bean = getSemmco004Bean();
		boolean flag = true;
		List<WrapperBeanObject<Mco004SrchSP>> contractList = semmco004Bean.getMco004SrchSPList();
		boolean select = isNonSelected();
		
			if(status != null){
				semmco004Bean.setSelectedStatus(status);
			}
			for(WrapperBeanObject<Mco004SrchSP> contract : contractList){
				// set check box all.
				if(flag){
					if(!select){
						if(semmco004Bean.isChkSelAll()){
							if(contract.isCheckBox() == true){
								semmco004Bean.setDisableSelectAll(false);
								flag = false;
							}else{
								semmco004Bean.setDisableSelectAll(true);
							}
						}else{
							semmco004Bean.setDisableSelectAll(false);
							flag = false;
						}
					}else{
						semmco004Bean.setDisableSelectAll(true);
						flag = false;
					}
				}
					if((semmco004Bean.isChkSelAll() && checked) && !select){
						if(((Mco004SrchSP)contract.getDataObj()).getRowId().equals(semmco004Bean.getTmpRowId())){
							contract.setCheckBox(false);
							semmco004Bean.setDisableSelectAll(false);
							semmco004Bean.setChkSelAll(false);
							break;
						}
					}else{
						if((semmco004Bean.isChkSelAll() && checked) || select){
							contract.setCheckBox(false);
							contract.setDisableCheckBox(true);
						}else{
							// replace check box status with rowId.
								if(semmco004Bean.getSelectedStatus().equals(((Mco004SrchSP)contract.getDataObj()).getSubRentStatus())){
									if(semmco004Bean.isChkSelAll()){
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
		setSemmco004Bean(semmco004Bean);
	}
	
	private boolean isNonSelected(){
		List<WrapperBeanObject<Mco004SrchSP>> contractList = semmco004Bean.getMco004SrchSPList();
		for(WrapperBeanObject<Mco004SrchSP> contract : contractList){
			if(contract.isCheckBox()){
				return false;
			}
		}
		return true;
	}
	
	private boolean isCheckSELBox() {
		boolean isCheck = false;
		
		List<WrapperBeanObject<Mco004SrchSP>> mco004SrchSPList = getSemmco004Bean().getMco004SrchSPList();
		for (WrapperBeanObject<Mco004SrchSP> wrapperBeanObject : mco004SrchSPList) {
			if (wrapperBeanObject.isCheckBox()) {
				return true;
			}
		}
		
		return isCheck;
	}
	
	public void doExportExcel(){
		try {
			/***********************************************/
			short line = 0;
			double totalRentPerMonth = 0.00;
			double totalServicePerMonth = 0.00;
			Collection<Mco004SrchSP> exList = new ArrayList<Mco004SrchSP>();
			//PDocumentManager export to excel
			DocumentExportManager<Mco004SrchSP> docManager =
				new DocumentExportManager<Mco004SrchSP>(Mco004SrchSP.class, EnumDocumentType.XLS);
			// set current configuration of work book.	
				docManager.setRowStart(line);
		   /***********************************************/
				EnumDocStyleDomain headerStyle = docManager.getStyle("rt003FieldHeader");
				EnumDocStyleDomain	titleStyle	= new EnumDocStyleDomain(EnumDocStyle.TITLE);
//				EnumDocStyleDomain titleStyle = docManager.getStyle("rt003TitleHeader");
				EnumDocStyleDomain field = docManager.getStyle("normalField");
				EnumDocStyleDomain fieldMoney = docManager.getStyle("rt002FieldMoney");
				
				RowDomain row1 = new RowDomain(1,true);
				
				RowDomain row2 = new RowDomain(2,true);
				row2.setCell(new CellDomain(0, null, String.class, headerStyle, msg("export.col.order"),-1,1500));
				row2.setCell(new CellDomain(1, null, String.class, headerStyle, msg("column.rentalContract"),-1,4300));
				row2.setCell(new CellDomain(2, null, String.class, headerStyle, msg("column.rentContract"),-1,4000));
				row2.setCell(new CellDomain(3, null, String.class, headerStyle, msg("export.col.locationId"),-1,2700));
				row2.setCell(new CellDomain(4, null, String.class, headerStyle, msg("export.column.siteName"),-1,8000));
				row2.setCell(new CellDomain(5, null, String.class, headerStyle, msg("export.col.address"),-1,8000));
				row2.setCell(new CellDomain(6, null, String.class, headerStyle, msg("export.col.street"),-1,3000));
				row2.setCell(new CellDomain(7, null, String.class, headerStyle, msg("message.district"),-1,3000));
				row2.setCell(new CellDomain(8, null, String.class, headerStyle, msg("message.amphur"),-1,3000));
				row2.setCell(new CellDomain(9, null, String.class, headerStyle, msg("message.province"),-1,3000));
				row2.setCell(new CellDomain(10, null, String.class, headerStyle, msg("export.col.postcode"),-1,3000));
				row2.setCell(new CellDomain(11, null, String.class, headerStyle, msg("export.column.effDate"),-1,3000));
				row2.setCell(new CellDomain(12, null, String.class, headerStyle, msg("export.column.expDate"),-1,3000));
				row2.setCell(new CellDomain(13, null, String.class, headerStyle, msg("export.col.deckArea"),-1,3000));
				row2.setCell(new CellDomain(14, null, String.class, headerStyle, msg("export.col.buildingArea"),-1,3000));
				row2.setCell(new CellDomain(15, null, String.class, headerStyle, msg("export.col.roomArea"),-1,3000));
				row2.setCell(new CellDomain(16, null, String.class, headerStyle, msg("export.col.landArea"),-1,3000));
				row2.setCell(new CellDomain(17, null, String.class, headerStyle, msg("export.column.groupNo"),-1,2800));
				row2.setCell(new CellDomain(18, null, String.class, headerStyle, msg("column.rentPerMonth"),-1,3000));
				row2.setCell(new CellDomain(19, null, String.class, headerStyle, msg("column.servicePerMonth"),-1,3000));
				row2.setCell(new CellDomain(20, null, String.class, headerStyle, msg("column.status"),-1,3300));
				
				List<WrapperBeanObject<Mco004SrchSP>> Mco004SrchSPList = new ArrayList<WrapperBeanObject<Mco004SrchSP>>();
				Mco004SrchSPList = getSemmco004Bean().getMco004SrchSPList();
				Mco004SrchSP tmp = new Mco004SrchSP();
				boolean firstFlg = true;
				String groupNo = "";
				int no = 0;
				if(Mco004SrchSPList != null && Mco004SrchSPList.size() > 0){
					for(int i=0; i<Mco004SrchSPList.size(); i++){
						WrapperBeanObject<Mco004SrchSP> detail = new WrapperBeanObject<Mco004SrchSP>();
						detail = Mco004SrchSPList.get(i);
						if(detail.isCheckBox()){
							 ++no;
							 tmp = ((Mco004SrchSP)detail.getDataObj());
							 tmp.setNo(no);
							 tmp.setEffectiveDt(SEMDataUtility.convertToThYear(tmp.getEffectiveDt()));
							 tmp.setExpireDt(SEMDataUtility.convertToThYear(tmp.getExpireDt()));
							exList.add((Mco004SrchSP)detail.getDataObj());
							if(tmp.getRentAmt() != null)
								totalRentPerMonth += tmp.getRentAmt();
							if(tmp.getServiceAmt() != null)
								totalServicePerMonth += tmp.getServiceAmt();
							if(firstFlg){
								groupNo = tmp.getGroupNo();
								firstFlg = false;
							}
							
						}
						
					}
				}
					
				//Group No
				RowDomain row0 = new RowDomain(0,true);	
				row0.setCell(new CellDomain(0,10, null, String.class, titleStyle, msg("export.column.headSubRent")+" "+groupNo,null));
				
				//Sum Total Amt
				RowDomain row3 = new RowDomain(0,false);
				row3.setCell(new CellDomain(0, null, String.class, field, null,-1,null));
				row3.setCell(new CellDomain(1, null, String.class, field, null,-1,null));
				row3.setCell(new CellDomain(2, null, String.class, field, null,-1,null));
				row3.setCell(new CellDomain(3, null, String.class, field, null,-1,null));
				row3.setCell(new CellDomain(4, null, String.class, field, null,-1,null));
				row3.setCell(new CellDomain(5, null, String.class, field, null,-1,null));
				row3.setCell(new CellDomain(6, null, String.class, field, null,-1,null));
				row3.setCell(new CellDomain(7, null, String.class, field, null,-1,null));
				row3.setCell(new CellDomain(8, null, String.class, field, null,-1,null));
				row3.setCell(new CellDomain(9, null, String.class, field, null,-1,null));
				row3.setCell(new CellDomain(10, null, String.class, field, null,-1,null));
				row3.setCell(new CellDomain(11, null, String.class, field, null,-1,null));
				row3.setCell(new CellDomain(12, null, String.class, field, null,-1,null));
				row3.setCell(new CellDomain(13, null, String.class, field, null,-1,null));
				row3.setCell(new CellDomain(14, null, String.class, field, null,-1,null));
				row3.setCell(new CellDomain(15, null, String.class, field, null,-1,null));
				row3.setCell(new CellDomain(16, null, String.class, field, null,-1,null));
				row3.setCell(new CellDomain(17, null, String.class, field, null,-1,null));
				row3.setCell(new CellDomain(18, null, Double.class, fieldMoney, totalRentPerMonth,-1,3000));
				row3.setCell(new CellDomain(19, null, Double.class, fieldMoney, totalServicePerMonth,-1,3000));
				row3.setCell(new CellDomain(20, null, String.class, field, null,-1,null));
				
				docManager.putDetailRow(row0);
				docManager.putDetailRow(row1);
				docManager.putDetailRow(row2);
				docManager.seteObjectList(exList);
				docManager.putDetailRow(row3);
				docManager.setModule("CONTRACT_SUB_RENT");
				docManager.setPrintPageLandScape(true);
//				docManager.setMargin(0.05, 0.05, 0.5, 0.05);
				docManager.setMargin(0, 0, 0, 0);
				docManager.getObjectFromDocument();
				docManager.exportServletFile();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	public Boolean doCheckGroup(){
		boolean flag = false;
		semmco004Bean = getSemmco004Bean();
		String userId = "";
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		List<Mco004Act> to;
		List<WrapperBeanObject<Mco004SrchSP>> Mco004SrchSPList = new ArrayList<WrapperBeanObject<Mco004SrchSP>>();
		Mco004SrchSPList = getSemmco004Bean().getMco004SrchSPList();
		semmco004Bean.setMco004Act(new Mco004Act());
		String siteInfoIdTmp = "";
			int no = 0;
			if(Mco004SrchSPList != null && Mco004SrchSPList.size() > 0){
				for(int i=0; i<Mco004SrchSPList.size(); i++){
					WrapperBeanObject<Mco004SrchSP> detail = new WrapperBeanObject<Mco004SrchSP>();
					detail = Mco004SrchSPList.get(i);
//					log.debug(" Size "+i);
					if(detail.isCheckBox()){
						 ++no;
//						 siteInfoIdTmp = siteInfoIdTmp + ((Mco004SrchSP)detail.getDataObj()).getLessorSiteInfoId()+",";
						 //Change to LessorSiteInfoId by Noom
						 siteInfoIdTmp = siteInfoIdTmp + ((Mco004SrchSP)detail.getDataObj()).getRowId()+",";
						 //
						 
//						 String rowId = (String)getFacesUtils().getRequestParameter("rowId");
//						 String actionType = (String)getFacesUtils().getRequestParameter("actionType");
//						 userId = semmco004Bean.getUserLogin();
//						 ((Mco004SrchSP)detail.getDataObj()).setSiteInfoId(rowId);
//						 ((Mco004SrchSP)detail.getDataObj()).setActionType(actionType);
//						 ((Mco004SrchSP)detail.getDataObj()).setActionType(userId);
					}
					
				}
			}
			siteInfoIdTmp = siteInfoIdTmp.substring(0, siteInfoIdTmp.length()-1);
			semmco004Bean.getMco004Act().setSiteInfoId(siteInfoIdTmp);
			semmco004Bean.getMco004Act().setActionType((String)getFacesUtils().getRequestParameter("actionType"));
			semmco004Bean.getMco004Act().setUserId(getUserLogIn());
			try {
				to = service.querySPList(EQueryName.SP_MCO004_ACT.name, semmco004Bean.getMco004Act());
				if (to != null && !to.isEmpty() && to.get(0).getpResult().equals("Success")) {
					if(StringUtils.isNotEmpty(to.get(0).getGroupNo()))
						addMessageInfo("M0006",to.get(0).getGroupNo());
					else
						addMessageInfo("M0001");
				}else if(to != null && !to.isEmpty()){
					FrontMessageUtils.addMessageError(to.get(0).getpRemark());
				}
				log.debug(" RESULT MESSAGE : "+to.get(0).getpResult());
				setSemmco004Bean(semmco004Bean);
				flag = false;
				
				doSearch();
			} catch (Exception e) {
				e.printStackTrace();
				addMessageError("E0001");
			}
			

	return flag;	
	}
	
	
	// Copy from SEMMCO001Action [27/02/2013] By Noom
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
	
	private SEMMCO004Tab2Action semmco004tab2Action;

	public SEMMCO004Tab2Action getSemmco004tab2Action() {
		if(semmco004tab2Action == null){
			semmco004tab2Action = new SEMMCO004Tab2Action();
		}
		return semmco004tab2Action;
	}

	public void setSemmco004tab2Action(SEMMCO004Tab2Action semmco004tab2Action) {
		this.semmco004tab2Action = semmco004tab2Action;
	}
	
	// Copy from SEMMCO001Action [27/02/2013] By Noom
	public boolean initUpdateContract() {
		boolean flag = true;
		try{
			semmco004Bean = getSemmco004Bean();
//			String rowId = (String)getFacesUtils().getRequestParameter("rowId");
			String lesseeId = (String)getFacesUtils().getRequestParameter("lesseeId");
			String siteName = (String)getFacesUtils().getRequestParameter("siteName");
			String company = (String)getFacesUtils().getRequestParameter("company");
			String siteInfoId = (String)getFacesUtils().getRequestParameter("siteInfoId");
			String fromInitPage = (String)getFacesUtils().getRequestParameter("fromInitPage");
			String groupNumber = (String)getFacesUtils().getRequestParameter("groupNumber");
			semmco004Bean.setContractIdParam(lesseeId);
			semmco004Bean.setSiteNameParam(siteName);
			semmco004Bean.setCompanyParam(company);
			semmco004Bean.setRenderedMsgFormSearch(true);
			semmco004Bean.setSiteInfoParam(siteInfoId);
			semmco004Bean.setFromInitPage(fromInitPage);
			semmco004Bean.setGroupNumber(groupNumber);
			setSemmco004Bean(semmco004Bean);
			// get contractNo, siteInfoId, effDate, expDate
			this.getContractByRowId();
				getSemmco004tab1Action().initTab1(semmco004Bean.getSiteInfoParam());
				getSemmco004Bean().setTabNo("2");
				getSemmco004tab2Action().initTab2();
				
				initSubRentInfo();
				doSave();
				semmco004Bean.setFromInitPage("");	
			setSemmco004Bean(semmco004Bean);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
//			getSemmco001tab3Action().init();
		}
		return flag;
	}

	// Copy from SEMMCO001Action [27/02/2013] By Noom
	private void getContractByRowId() {
		semmco004Bean = getSemmco004Bean();
		try{
			ISiteContractService service = (ISiteContractService)getBean("siteContractService");
			Contract contract = service.queryContractByRowId(semmco004Bean.getContractIdParam());
			if(contract != null){
				semmco004Bean.setSiteInfoParam(contract.getSiteInfoId());
				semmco004Bean.setContractNoParam(contract.getContractNo());
//				if(contract.getEffectiveDt() != null) semmco001Bean.setEffDateParam(convertYearENtoTH(contract.getEffectiveDt()));
//				if(contract.getExpireDt() != null) semmco001Bean.setExpDateParam(convertYearENtoTH(contract.getExpireDt()));
				if(contract.getEffectiveDt() != null) semmco004Bean.setEffDateParam(contract.getEffectiveDt());
				if(contract.getExpireDt() != null) semmco004Bean.setExpDateParam(contract.getExpireDt());
				if(contract.getEffectiveDt() != null) semmco004Bean.setEffDateParamStr(convertYearENtoTHStr(contract.getEffectiveDt()));
				if(contract.getExpireDt() != null) semmco004Bean.setExpDateParamStr(convertYearENtoTHStr(contract.getExpireDt()));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco004Bean(semmco004Bean);
	}
	
	// Copy from SEMMCO001Action [27/02/2013] By Noom
	private void createContractCheckDoc() {
		semmco004Bean = getSemmco004Bean();
		List<ContractCheckDoc> list = null;
		try{
			IContractCheckDocService service = (IContractCheckDocService)getBean("contractCheckDocService");
			String contractId = semmco004Bean.getContractIdParam();
			if(contractId != null && !contractId.equals("")){
				list = service.queryContractCheckDocByContractId(contractId);
				ContractCheckDoc contractCheckDoc = new ContractCheckDoc();
				contractCheckDoc.setContractId(contractId);
				contractCheckDoc.setCurrentUser(semmco004Bean.getUserLogin());
				if (list.size()>0){
					List<Mco001UpdateCheckDocLSP> toDocL = null;
					// UPDATE CHECK DOC CALL SEM_SP_MCO001_UPD_CHECK_DOC
					Mco001UpdateCheckDocLSP docL = new Mco001UpdateCheckDocLSP();
					docL.setSiteInfoId(semmco004Bean.getSiteInfoParam());
					docL.setCurrentUser(semmco004Bean.getUserLogin());
					docL.setpOption("DEL");
					toDocL = service.querySPList(EQueryName.SP_MCO001_UPD_CHECK_DOC_L.name, docL);
					if(toDocL != null && !toDocL.isEmpty() && toDocL.get(0).getResultMsg().equals("Success")){
						log.debug("update check doc Legal result [" + toDocL.get(0).getResultMsg());
					}
				}
					ContractCheckDoc checkDoc = service.createContractCheckDoc(contractCheckDoc);
					try{
						if(checkDoc != null){
							List<Mco001UpdateCheckDocSP> to = null;
							// UPDATE CHECK DOC CALL SEM_SP_MCO001_UPD_CHECK_DOC
							Mco001UpdateCheckDocSP criteria = new Mco001UpdateCheckDocSP();
							criteria.setSiteInfoId(semmco004Bean.getSiteInfoParam());
							criteria.setCurrentUser(semmco004Bean.getUserLogin());
							to = service.querySPList(EQueryName.SP_MCO001_UPD_CHECK_DOC.name, criteria);
							if(to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")){
								log.debug("update check doc result [" + to.get(0).getResultMsg());
							}
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco004Bean(semmco004Bean);
		
	}
	
	// Copy from SEMMCO001Action [27/02/2013] By Noom
	public void checkScreenName() {
		semmco004Bean = getSemmco004Bean();
//		if(!semmco004Bean.getScreenName().equals("") 
//		  && semmco004Bean.getScreenName().equals("LEGAL")){
//			// show data table legal
//			semmco004Bean.setRenderedLegal(true);
//			// hide data table contract
//			semmco004Bean.setRenderedContract(false);
//			// hide tab2
//			semmco004Bean.setRenderedTab2(false);
//			// hide right address and contract in tab1
//			semmco004Bean.setRenderedDataTab1(false);
//			// hide button save
//			semmco004Bean.setRenderBtnSave(false);
//		}else{
			semmco004Bean.setRenderedLegal(false);
			semmco004Bean.setRenderedContract(true);
			semmco004Bean.setRenderedTab2(true);
			semmco004Bean.setRenderedDataTab1(true);
			semmco004Bean.setRenderBtnSave(true);
//		}
		setSemmco004Bean(semmco004Bean);
	}
	
	public boolean setTabNo(){
		boolean flag = false;
		semmco004Bean = getSemmco004Bean();
		String tabNo = (String)getFacesUtils().getRequestParameter("tabNo");
		semmco004Bean.setTabNo(tabNo);
		
		try {
			if(tabNo.equals("1")){
				semmco004Bean.setTabHeader(msg("message.tab.contract"));
				semmco004Bean.setRenderBtnSave(true);
				semmco004Bean.setRenderedAttachment(false);
				getSemmco004tab1Action().initTab1(semmco004Bean.getSiteInfoParam());
			}else if(tabNo.equals("2")){
				semmco004Bean.setTabHeader(msg("message.tab.contractFile"));
				semmco004Bean.setRenderBtnSave(false);
				semmco004Bean.setRenderedAttachment(true);
				getSemmco004tab2Action().initTab2();
				queryAttachmentByRefID(semmco004Bean.getContractIdParam());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmco004Bean(semmco004Bean);
		
		return flag;
	}
	
	private void queryAttachmentByRefID(String refID) throws Exception{
		List<Attachment> attachmentList = new ArrayList<Attachment>();
		IAttachmentService atchService = (IAttachmentService)getBean("attachmentService");
		Attachment attachment = new Attachment();
		String tmpRefID = getSemmco004Bean().getTmpAttachment().getRefferenceId();
		attachment.setRefferenceId(StringUtils.isEmpty(tmpRefID) ? refID : tmpRefID);
		attachmentList = atchService.queryAttachmentByCriteria(attachment);
		getSemmco004Bean().setAttachmentList(attachmentList);
		getSemmco004Bean().setTmpAttachment(null);
	}
	
	private boolean initSiteInfo() {
		boolean flag = true;
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		String page = (String)getFacesUtils().getRequestParameter("page");
		try{
			if(rowId != null){
				getSemmsi004Action().init();
				getSemmsi004tab1Action().init();
				getSemmsi004tab2Action().init();
				getSemmsi004tab1Action().initTab1();
				getSemmsi004tab1Action().getDataTab1(rowId);
				getSemmsi004Action().getDataContract(getSemmco004Bean().getSiteInfoParam());
				getSemmsi004Bean().setSiteInfoId(rowId);
				getSemmsi004Bean().setRenderedBtnBackSiteInfo(false);
				getSemmsi004Bean().setRenderedBtnBackContract(false);
				getSemmsi004Bean().setRenderedBtnBackContractSubRent(true);
				getSemmsi004Bean().setRenderBtnSave(false);
				getSemmsi004Bean().setRenderTab1(true);
				getSemmsi004Bean().setRenderPanelLog(true);
				getSemmsi004Bean().setRenderBtnSave(true);
				getSemmsi004Bean().setSelectedTab("tab1");
				getSemmsi004Bean().setTempTabNo("1");
				getSemmsi004Bean().setShowMessageSave(true);
				getSemmsi004Bean().setMode(mode);
				getSemmsi004Bean().setPage(page);
				setSemmsi004Bean(getSemmsi004Bean());
				getSemmsi004tab1Action().checkMode(rowId);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	
	private boolean doClearSession() {
		boolean flag = true;
		try{
		semmco004Bean = getSemmco004Bean();
		getSemmco004tab1Action().initTab1(semmco004Bean.getSiteInfoParam());
		setSemmco004Bean(semmco004Bean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	
	private boolean doUpdateTab() {
		boolean flag = false;
		String tabNo = (String)getFacesUtils().getRequestParameter("tabNo");
		if(tabNo != null && tabNo.equals("1")){
			getSemmco004tab1Action().doUpdateTab1();
		}
		if(tabNo != null && tabNo.equals("2")){
			getSemmco004tab1Action().doUpdateTab2();
		}
//		if(tabNo != null && tabNo.equals("3")){
//			getSemmco001tab3Action().doUpdateTab3();
//		}
		return flag;
	}
	
	
	private boolean initAddContractStatus() {
		boolean flag = false;
		semmco004Bean = getSemmco004Bean();
		semmco004Bean.setRowsIdConcat("");
		semmco004Bean.setGroupNo("");
		semmco004Bean.getContract().setReceivePersonCode("");
		semmco004Bean.getContract().setCreatePersonCode("");
		this.doClearPopupAddContractStatus();
		try{
			List<WrapperBeanObject<Mco004SrchSP>> contractList = semmco004Bean.getMco004SrchSPList();
			if(contractList != null && contractList.size() > 0){
				for(WrapperBeanObject<Mco004SrchSP> contract : contractList){
					WrapperBeanObject<Mco004SrchSP> tmpWrapperBean = new WrapperBeanObject<Mco004SrchSP>();
					if(contract.isCheckBox()){
						Mco004SrchSP temp = (Mco004SrchSP)contract.getDataObj();
						if(semmco004Bean.getRowsIdConcat().equals("")){
							semmco004Bean.setRowsIdConcat(temp.getLesseeContractId());
							// get drop down contract status list by fist contractId
							semmco004Bean.setContractId(temp.getLesseeContractId());
							semmco004Bean.setGroupNo(temp.getGroupNo());
							this.getContractStatusListByContractId();
						}else{
							semmco004Bean.setRowsIdConcat(semmco004Bean.getRowsIdConcat() +",".trim()+ temp.getLesseeContractId());
							semmco004Bean.setGroupNo(semmco004Bean.getGroupNo() +",".trim()+ temp.getGroupNo());
						}
						semmco004Bean.setCompany(temp.getLesseeCompany());
					}
				}
				semmco004Bean.setDisabledBtnAdd(false);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		checkAddAbleContractStatus();
		setSemmco004Bean(semmco004Bean);
		return flag;
	}

	private void doClearPopupAddContractStatus() {
		semmco004Bean = getSemmco004Bean();
		semmco004Bean.setContractStatus(new ContractStatus());
		semmco004Bean.getContractStatus().setContractStatus("");
		semmco004Bean.getContractStatus().setChangeStatusDt(new Date());
		semmco004Bean.getContractStatus().setRemark("");
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
			criteria.setContractId(semmco004Bean.getContractId());
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
				semmco004Bean.setContractStatusList(selList);
			}else{
				semmco004Bean.setContractStatusList(getEmptyDropDown());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco004Bean(semmco004Bean);
		
	}
	
	private void checkAddAbleContractStatus() {
		semmco004Bean = getSemmco004Bean();
		List<Mco001CheckAddAbleSP> to = null;
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			Mco001CheckAddAbleSP criteria = new Mco001CheckAddAbleSP();
			criteria.setContractId(semmco004Bean.getContractId());
			criteria.setRole("CONTRACT");
			to = service.querySPList(EQueryName.SP_MCO001_CHK_ADDABLE.name, criteria);
			if(to != null && to.size() > 0){
				Mco001CheckAddAbleSP addAble = to.get(0);
				if(addAble.getAddAbleFlag() != null && addAble.getAddAbleFlag().equals("Y")){
					semmco004Bean.setRenderedAddHistory(true);
				}else{
					semmco004Bean.setRenderedAddHistory(false);
				}
				
				if(addAble.getEditAbleFlag() != null && addAble.getEditAbleFlag().equals("Y")){
					semmco004Bean.setRenderedUpdateHistory(true);
				}else{
					semmco004Bean.setRenderedUpdateHistory(false);
				}
				
				if(addAble.getDeleteAbleFlag() != null && addAble.getDeleteAbleFlag().equals("Y")){
					semmco004Bean.setRenderedDeleteHistory(true);
				}else{
					semmco004Bean.setRenderedDeleteHistory(false);
				}
				//Adding by mr.john 21/04/2011 from SA (Surasit)
				if(addAble.getEditDutyFlag() != null && addAble.getEditDutyFlag().equals("Y")){
					semmco004Bean.setDisabledBtnExportDuty(true);
				}else{
					semmco004Bean.setDisabledBtnExportDuty(false);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco004Bean(semmco004Bean);
	}
	
	
	private boolean doSaveContractStatus() {
		boolean flag = false;
		semmco004Bean = getSemmco004Bean();
		if(!validateUpdateContractStatus("doSave")){
			semmco004Bean.setRenderedMsgFormSearchPopup(true);
			semmco004Bean.setRenderedMsgFormSearch(false);
			semmco004Bean.setPopupClose(false);
			setSemmco004Bean(semmco004Bean);
			return flag;
		}
		try{
			List<Mco005UpdateContractStatusSP> to = null;
				IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
				Mco005UpdateContractStatusSP contract = new Mco005UpdateContractStatusSP();
				contract.setContractId(semmco004Bean.getRowsIdConcat());
				contract.setContractStatus(semmco004Bean.getContractStatus().getContractStatus());
				contract.setChangeStatusDate(semmco004Bean.getContractStatus().getChangeStatusDt());
				contract.setRemark(semmco004Bean.getContractStatus().getRemark());
				contract.setCurrentUser(semmco004Bean.getUserLogin());
				contract.setCompany(semmco004Bean.getCompany());
				//Adding by mr.John from (mr.Surasit) 27/04/2011
				contract.setReceivePersonCode(semmco004Bean.getContract().getReceivePersonCode());
				contract.setCreatePersonCode(semmco004Bean.getContract().getCreatePersonCode());
				contract.setGroupNo(semmco004Bean.getGroupNo());
				
				to = service.querySPList(EQueryName.SP_MCO005_UPD_STATUS_LIST.name, contract);
				
				if(to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")){
					semmco004Bean.setPopupClose(true);
					addMessageInfo("M0001");
				}
				
				// search contractStatus
				semmco004Bean.setMco004SrchSPList(null);
				this.doSearch();
//			}
			
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		semmco004Bean.setRenderedMsgFormSearchPopup(false);
		semmco004Bean.setRenderedMsgFormSearch(true);
		setSemmco004Bean(semmco004Bean);
		return flag;
	}
	
	private boolean validateUpdateContractStatus(String method) {
		boolean flgValid = true;
		
		if(StringUtils.isEmpty(getSemmco004Bean().getContractStatus().getContractStatus())){
			addMessageError("W0001", msg("message.contractStatus"));
			flgValid = false;
		}else{
			// contract status = 03 (send legal) call SP_MCO002_CHK_NO_FILE
			if(getSemmco004Bean().getContractStatus().getContractStatus().equals("03")){
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
		
		if(getSemmco004Bean().getContractStatus().getChangeStatusDt() == null){
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
			criteria.setContractId(getSemmco004Bean().getContractId());
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
			criteria.setContractId(getSemmco004Bean().getRowsIdConcat());
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
		semmco004Bean = getSemmco004Bean();
		try{
			boolean chkAll = getSemmco004Bean().isChkSelAll();
			List<WrapperBeanObject<Mco004SrchSP>> contractList = new ArrayList<WrapperBeanObject<Mco004SrchSP>>();
			contractList = getSemmco004Bean().getMco004SrchSPList();
			
			for(int i = 0; i < contractList.size(); i++) {
				Mco004SrchSP o = (Mco004SrchSP)contractList.get(i).getDataObj();
				if(StringUtils.isNotEmpty(o.getRowId())){
					if(chkAll){
						if (semmco004Bean.getSelectedStatus().equals(o.getSubRentStatus()) && chkAll) {
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
				semmco004Bean.setDisableSelectAll(true);
				semmco004Bean.setSelectedStatus(null);
			}else{
				onRenderButton();
			}
		}catch(NullPointerException ne){
			// TODO
			
		}catch(Exception e){
			//TODO
		}
		setSemmco004Bean(semmco004Bean);
	}
	
	
	private boolean initUpdateDuty() {
		boolean flag = false;
		semmco004Bean = getSemmco004Bean();
		semmco004Bean.setContractId("");
		try{
			String rowId = (String)getFacesUtils().getRequestParameter("rowId");
			String siteInfoId = (String)getFacesUtils().getRequestParameter("siteInfoId");
			String groupNumber = (String) getFacesUtils().getRequestParameter("groupNumber");
			semmco004Bean.setContractId(rowId);
			semmco004Bean.setGroupNumber(groupNumber);
			if(rowId != null){
				ISiteContractService service = (ISiteContractService)getBean("siteContractService");
				Contract contract = service.queryContractByRowId(rowId);
				semmco004Bean.setContract(contract);
				if(contract!=null){
					if(contract.getDutyAmt() == null && contract.getDutyPayDt() == null &&
							contract.getCopyDuty() == null && contract.getCopyDutyAmt() == null){
						List<Mco004DefaultDutySP> to = null;
						Mco004DefaultDutySP criteria = new Mco004DefaultDutySP();
						criteria.setSiteInfoId(siteInfoId);
						to = service.querySPList(EQueryName.SP_MCO004_DEFAULT_DUTY.name, criteria);
						if(to != null && !to.isEmpty()){
							Mco004DefaultDutySP def = to.get(0);
							semmco004Bean.getContract().setDutyAmt(def.getDutyAmt());
							semmco004Bean.getContract().setCopyDuty(def.getCopyDuty());
							semmco004Bean.getContract().setCopyDutyAmt(def.getCopyDutyAmt());
	//						if(def.getDutyPayDate() != null) semmco006Bean.getContract().setDutyPayDt(convertYearENtoTH(def.getDutyPayDate()));
						}
					}
					if(semmco004Bean.getContract().getDutyPayStatus() == null){
						semmco004Bean.getContract().setDutyPayStatus("00");
					}
				}else{
					semmco004Bean.setContract(new Contract());
					semmco004Bean.getContract().setDutyPayStatus("00");
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco004Bean(semmco004Bean);
		//Adding by mr.john 21/04/2011 from SA (Surasit).
		checkAddAbleContractStatus();
		return flag;
	}
	
	
	private boolean doUpdateDutyContract() {
		boolean flag = false;
		semmco004Bean = getSemmco004Bean();
		log.info("doUpdateDutyContract");
		if(!validateDuty()){
			log.info("validateDuty");
			semmco004Bean.setRenderedMsgFormSearch(true);
			return flag;
		}
		try{
			ISiteContractService service = (ISiteContractService)getBean("siteContractService");
			if(semmco004Bean.getContract() != null){
//				log.info("starting updateContract...");
//				semmco004Bean.getContract().setCurrentUser(semmco004Bean.getUserLogin());
//				semmco004Bean.setContract(service.updateContract(semmco004Bean.getContract()));
				Mco004UpdateDuty updateDuty = new Mco004UpdateDuty();
				updateDuty.setContractId(semmco004Bean.getContract().getRowId());
				updateDuty.setDutyAmt(semmco004Bean.getContract().getDutyAmt());
				updateDuty.setDutyPayDt(semmco004Bean.getContract().getDutyPayDt());
				updateDuty.setDutyPayStatus(semmco004Bean.getContract().getDutyPayStatus());
				updateDuty.setCopyDuty(semmco004Bean.getContract().getCopyDuty());
				updateDuty.setCopyDutyAmt(semmco004Bean.getContract().getCopyDutyAmt());
				updateDuty.setOtherDutyAmt(semmco004Bean.getContract().getOtherDutyAmt());
				updateDuty.setGroupNo(semmco004Bean.getGroupNumber());
				List<Mco004UpdateDuty> to = service.querySPList(EQueryName.SP_MCO004_UPD_DUTY.name, updateDuty);
				if(StringUtils.equalsIgnoreCase("Success", to.get(0).getpResult())){
					semmco004Bean.setPopupClose(true);
					semmco004Bean.setRenderedMsgFormSearch(true);
					log.info("end updateContract...");
					log.info("starting doSearch...");
					this.doSearch();
					log.info("end doSearch...");
					addMessageInfo("M0001");
				}else{
					addMessageError("E0001");
				}
			
			}
		}catch(Exception e){
			log.info("Exception in doUpdateDutyContract()...");
			e.printStackTrace();
			addMessageError("E0001");
		}
		
		setSemmco004Bean(semmco004Bean);
		return flag;
	}
	
	private boolean validateDuty(){
		boolean flgValid = true;
		if("01".equals(semmco004Bean.getContract().getDutyPayStatus())){
			if(semmco004Bean.getContract().getDutyAmt() == null || semmco004Bean.getContract().getDutyAmt() < 0){
				addMessageError("W0001", msg("message.dutyAmt"));
				flgValid = false;
			}
			
			if(semmco004Bean.getContract().getDutyPayDt() == null){
				addMessageError("W0001", msg("export.col.requestDtFrom"));
				flgValid = false;
			}
		}
		
		return flgValid;
	}
	
	public void doExportDutyExcel() {
		semmco004Bean = getSemmco004Bean();
		try {
			/***********************************************/
			short line = 0;
			Collection<Mco004SrchSP> exList = new ArrayList<Mco004SrchSP>();
			//PDocumentManager export to excel
			DocumentExportManager<Mco004SrchSP> docManager =
				new DocumentExportManager<Mco004SrchSP>(Mco004SrchSP.class, EnumDocumentType.XLS);
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
				rowD.setCell(new CellDomain(4, null, String.class, headerStyle.setWrapTxt(true), msg("export.col.lesseeContractNo"),-1, 3000));
				rowD.setCell(new CellDomain(5, null, String.class, headerStyle, msg("export.col.lessorContractNo"),-1, 3000));
				rowD.setCell(new CellDomain(6, null, String.class, headerStyle, msg("export.col.groupNo"),-1, 3000));
				rowD.setCell(new CellDomain(7, null, String.class, headerStyle, msg("export.col.siteName"),-1, 8000));
				rowD.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.column.contract.effDt"),-1,3000));
				rowD.setCell(new CellDomain(9, null, String.class, headerStyle, msg("export.column.contract.expDt"),-1,3000));
				rowD.setCell(new CellDomain(10, null, String.class, headerStyle, msg("export.col.dutyAmt"),-1, 2500));
				
				List<WrapperBeanObject<Mco004SrchSP>> contractStatusList = new ArrayList<WrapperBeanObject<Mco004SrchSP>>();
				contractStatusList = semmco004Bean.getMco004SrchSPList();
				
				int index = 0;
				EnumDocStyleDomain defaultStyle = new EnumDocStyleDomain(EnumDocStyle.CELL_DEFAULT);
				double tempTotal = 0.00;
				for(int i = 0; i < contractStatusList.size(); i++){
				
				WrapperBeanObject<Mco004SrchSP> contract = new WrapperBeanObject<Mco004SrchSP>();
				contract = contractStatusList.get(i);
				if(contract.isCheckBox()){
					Mco004SrchSP tmp = new Mco004SrchSP();
					tmp = (Mco004SrchSP)contract.getDataObj();
					
					RowDomain rowE = new RowDomain(index + 2,true);
					rowE.setCell(new CellDomain(0, null, String.class, defaultStyle, Integer.toString(index+1),-1, 2000));
					rowE.setCell(new CellDomain(1, null, String.class, defaultStyle, tmp.getCompany(),-1, 2500));
					rowE.setCell(new CellDomain(2, null, String.class, defaultStyle, tmp.getRegion(),-1, 2500));
					rowE.setCell(new CellDomain(3, null, String.class, defaultStyle, tmp.getReqTypeName(),-1, 4000));
					rowE.setCell(new CellDomain(4, null, String.class, defaultStyle, tmp.getLesseeContractNo(),-1, 3000));
					rowE.setCell(new CellDomain(5, null, String.class, defaultStyle, tmp.getLessorContractNo(),-1, 3000));
					rowE.setCell(new CellDomain(6, null, String.class, defaultStyle, tmp.getGroupNo(),-1, 3000));
					rowE.setCell(new CellDomain(7, null, String.class, defaultStyle, tmp.getSiteName(),-1, 10000));
					rowE.setCell(new CellDomain(8, null, String.class, defaultStyle, tmp.getEffectiveDtStr(),-1,3000));
					rowE.setCell(new CellDomain(9, null, String.class, defaultStyle, tmp.getExpireDtStr(),-1,3000));
					rowE.setCell(new CellDomain(10, null, Double.class, new EnumDocStyleDomain(EnumDocStyle.CELL_MONEY), tmp.getDutyAmt(),-1, 2500));
					if(tmp.getDutyAmt() != null){
						tempTotal += tmp.getDutyAmt();
					}
					docManager.putDetailRow(rowE);
					++index;
				}
	
			}
				
				--index;
				RowDomain rowF = new RowDomain(index+ 3,true);
				rowF.setCell(new CellDomain(10, null, Double.class, new EnumDocStyleDomain(EnumDocStyle.CELL_MONEY), tempTotal,-1, 2500));
		
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
	
	public void checkDutyPayStatus(){
		semmco004Bean = getSemmco004Bean();
		if(StringUtils.equals("01", semmco004Bean.getContract().getDutyPayStatus())){
			semmco004Bean.getContract().setDutyPayDt(new Date());
		}else{
			semmco004Bean.getContract().setDutyPayDt(null);
		}
	}
	
}
