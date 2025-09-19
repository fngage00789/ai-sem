package th.co.ais.web.pt.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import th.co.ais.domain.co.Mco001SrchSP;
import th.co.ais.domain.co.Mco003SearchBorrowSP;
import th.co.ais.domain.gm.Province;
import th.co.ais.domain.gm.VendorMaster;
import th.co.ais.domain.pt.Mpt002Edt;
import th.co.ais.domain.pt.Mpt002SrchHist;
import th.co.ais.domain.pt.Mpt003Act;
import th.co.ais.domain.pt.Mpt003ExpLetter;
import th.co.ais.domain.pt.Mpt003Srch;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.pt.IPTaxMasterService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.pt.bean.SEMMPT001Bean;
import th.co.ais.web.pt.bean.SEMMPT002Bean;
import th.co.ais.web.pt.bean.SEMMPT003Bean;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.ProvinceCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;
import th.co.ais.web.util.SemUtils;

public class SEMMPT003Action extends AbstractAction{

	private Logger log = Logger.getLogger(getClass());
	boolean flagDisableMsgSrch = true;
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		}else if (methodWithNavi.equalsIgnoreCase("doClearSession")) {
			flag = doClearSession();
		}else if(methodWithNavi.equalsIgnoreCase("doShow")){
			flag = doShow();
		}else if(methodWithNavi.equalsIgnoreCase("doUpdate")){
			flag = doUpdate();
		}else if(methodWithNavi.equalsIgnoreCase("doUpdatePropertyTax")) {
			flag = doUpdatePropertyTax();
		}else if(methodWithNavi.equalsIgnoreCase("initEditPropertyTax")) {
			flag = initEditPropertyTax();
		}else if(methodWithNavi.equalsIgnoreCase("doSavePropertyTax")) {
			flag = doSavePropertyTax();
		}else if(methodWithNavi.equalsIgnoreCase("doExportLetter")) {
			flag = doExportLetter();
		}else if(methodWithNavi.equalsIgnoreCase("initExportExcel")) {
			flag = initExportExcel();
		}
		// 2015/01/22 added by.. YUT 
		else if(methodWithNavi.equalsIgnoreCase("doInitialForSearchPropertyTax")) {
			flag = this.doInitialForSearchPropertyTax();
		}
		
		return flag;
	}


	


	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		SEMMPT003Bean semmpt003Bean = new SEMMPT003Bean();
		semmpt003Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmpt003Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		semmpt003Bean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		semmpt003Bean.setAmphurList(getEmptyDropDown());
		semmpt003Bean.setGovtList(getEmptyDropDown());
		semmpt003Bean.setpTaxPayTypeList(getLovItemsByType(ELovType.T_PT_PROPERTY_TAX_PAY_TYPE.name));
		semmpt003Bean.setpTaxEstmStatusList(getLovItemsByType(ELovType.T_PT_PTAX_ESTM_STATUS.name));
		semmpt003Bean.setPaymentStatusList(getLovItemsByType(ELovType.T_CT_PAYMENT_STATUS.name, EX_IN, null, "NOTPAY", null));
		semmpt003Bean.setMpt003Srch(new Mpt003Srch());
		semmpt003Bean.setMpt002Edt(new Mpt002Edt());
		semmpt003Bean.getMpt003Srch().setpTaxStatus("02");
		semmpt003Bean.getMpt003Srch().setpTaxPayType("01");
		semmpt003Bean.setValidateBtn(true);
		semmpt003Bean.setChkPayGovtFlag(true);
		semmpt003Bean.setDisabledBtnEstimate(true);
		List<SelectItem> listYearSelect = SemUtils.getYearSelect();
		semmpt003Bean.setpTaxYearFromList(listYearSelect);
    	semmpt003Bean.setpTaxYearToList(listYearSelect);
    	semmpt003Bean.setRenderedOnToDoList(false);
		setSemmpt003Bean(semmpt003Bean);
//		doAddYearDropDown();
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private SEMMPT003Bean semmpt003Bean;
	
	public SEMMPT003Bean getSemmpt003Bean() {
		return (SEMMPT003Bean)getFacesUtils().getSessionMapValue("semmpt003Bean");
	}

	public void setSemmpt003Bean(SEMMPT003Bean semmpt003Bean) {
		this.semmpt003Bean = semmpt003Bean;
		getFacesUtils().setSessionMapValue("semmpt003Bean", semmpt003Bean);
	}

	public void doAddYearDropDown(){
		semmpt003Bean = getSemmpt003Bean();
		SelectItem selItem = null;
		Date dt = new Date();
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy", Locale.ENGLISH);
        Integer tmpPTaxYear = Integer.parseInt(dateformatter.format(dt));
        Integer tmpPTaxYearThai = Integer.parseInt(dateformatter.format(dt));
        List<SelectItem> list = new LinkedList<SelectItem>();
        selItem = new SelectItem("" , msg("value.selectItem"));
		list.add(selItem);
		setSemmpt003Bean(semmpt003Bean);
        for(int i = 0; i<11; i++){
        	selItem = new SelectItem();
        	if(i!=0){
        	   tmpPTaxYear = tmpPTaxYear-1;
        	   tmpPTaxYearThai = tmpPTaxYear - 1;
        	}
            tmpPTaxYearThai = tmpPTaxYear + 543;        	
        	selItem.setLabel(String.valueOf(tmpPTaxYearThai));
        	selItem.setValue(tmpPTaxYear);
        	list.add(selItem);
        	semmpt003Bean.setpTaxYearFromList(list);
        	semmpt003Bean.setpTaxYearToList(list);
        }
        setSemmpt003Bean(semmpt003Bean);
	}
	
	public boolean doSearch(){
		boolean flag = false;
		semmpt003Bean = getSemmpt003Bean();
		semmpt003Bean.setDisabledBtnExport(true);
		semmpt003Bean.setDisabledBtnEstimate(true);
		if(semmpt003Bean.getMpt003Srch().getStrParam() == null){
			if(!validateSearch()){
				return flag;
			}
		}
		
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		List<Mpt003Srch> to = null;
		semmpt003Bean.setMpt003SrchList(new ArrayList<WrapperBeanObject<Mpt003Srch>>());
		if(semmpt003Bean.isChkPayGovtFlag()){
			semmpt003Bean.getMpt003Srch().setPayGovtFlag("Y");
		}else{
			semmpt003Bean.getMpt003Srch().setPayGovtFlag("N");
		}
		
		try {

			to = pTaxMasterService.querySPList(EQueryName.SP_MPT003_SRCH.name, semmpt003Bean.getMpt003Srch());
			if(to == null || to.size() == 0){
				if(flagDisableMsgSrch == true){
					semmpt003Bean.setRenderedMsgDataNotFound(true);
				}
			}else{
				semmpt003Bean.setRenderedMsgDataNotFound(false);
				 for(int i=0; i<to.size(); i++){
					 Mpt003Srch mpt003Srch = (Mpt003Srch)to.get(i);
					 WrapperBeanObject<Mpt003Srch> tmpWrapperBean = new WrapperBeanObject<Mpt003Srch>();
					 if(mpt003Srch.getContractEffDt() != null){
						 mpt003Srch.setContractEffDt(SEMDataUtility.convertToThYear(mpt003Srch.getContractEffDt()));
						}
						if(mpt003Srch.getContractExpDt() != null){
							mpt003Srch.setContractExpDt(SEMDataUtility.convertToThYear(mpt003Srch.getContractExpDt()));
						}
						if(mpt003Srch.getpTaxStartDt() != null){
							mpt003Srch.setpTaxStartDt(SEMDataUtility.convertToThYear(mpt003Srch.getpTaxStartDt()));
						}
						if(mpt003Srch.getpTaxEndDt() != null){
							mpt003Srch.setpTaxEndDt(SEMDataUtility.convertToThYear(mpt003Srch.getpTaxEndDt()));
						}
						if(mpt003Srch.getpTaxYear() != null){
							mpt003Srch.setpTaxYear(mpt003Srch.getpTaxYear()+543);
						}
						if(StringUtils.isEmpty(mpt003Srch.getPreContractNo())){
							mpt003Srch.setRenderedPreContractNo(false);
						}else{
							mpt003Srch.setRenderedPreContractNo(true);
						}
						if(mpt003Srch.getEstmDt() != null){
							mpt003Srch.setEstmDt(SEMDataUtility.convertToThYear(mpt003Srch.getEstmDt()));
						}
						tmpWrapperBean.setDataObj(mpt003Srch);
						 tmpWrapperBean.setMessage("");
						 tmpWrapperBean.setCheckBox(false);
						 semmpt003Bean.getMpt003SrchList().add(tmpWrapperBean);
				 }
			}
			setSemmpt003Bean(semmpt003Bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			addMessageError(("E0003"));
		} 
		return flag;
	}
	
	private boolean validateSearch(){
		boolean flagValid = true;
		validateRenderSearch();
		if(StringUtils.isEmpty(getSemmpt003Bean().getMpt003Srch().getCompany()) && getSemmpt003Bean().isTmpGroup1() == true){
			addMessageError(("W0001"), msg("message.company"));
			flagValid = false;
		}
		if(getSemmpt003Bean().isTmpGroup1() == true && 
		   getSemmpt003Bean().getMpt003Srch().getpTaxYearFrom() == 0){
			addMessageError(("W0001"), msg("massage.pTaxYearFrom"));
			flagValid = false;
		}
		if(getSemmpt003Bean().isTmpGroup1() == true && 
		   getSemmpt003Bean().getMpt003Srch().getpTaxYearTo() == 0){
			addMessageError(("W0001"), msg("massage.pTaxYearTo"));
			flagValid = false;
		}
		if(getSemmpt003Bean().isTmpGroup2() == true && StringUtils.isEmpty(getSemmpt003Bean().getMpt003Srch().getContractNo())){
			addMessageError(("W0001"), msg("message.contractNo"));
			flagValid = false;
		}
		if(getSemmpt003Bean().isTmpGroup1() == true && StringUtils.isEmpty(getSemmpt003Bean().getMpt003Srch().getRegion())){
			addMessageError(("W0001"), msg("message.region"));
			flagValid = false;
		}
		if(getSemmpt003Bean().getMpt003Srch().getpTaxYearTo() < getSemmpt003Bean().getMpt003Srch().getpTaxYearFrom()){
			addMessageErrorWithArgument("W0006", ("To")  ,msg("massage.pTaxYearFrom"));
			flagValid = false;
		}
		return flagValid;
	}
	
	public boolean doUpdate(){
		boolean flag = false;
		semmpt003Bean = getSemmpt003Bean();
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		List<Mpt002Edt> to = null;
		try {
			for(WrapperBeanObject<Mpt003Srch> mpts : semmpt003Bean.getMpt003SrchList()){
				Mpt003Srch mpt003Srch = (Mpt003Srch)mpts.getDataObj(); 
				if(mpts.isCheckBox() || mpts.isCheckBox() == true){
					if(!mpt003Srch.getpTaxEstmFlag().equals("N")){
						semmpt003Bean.getMpt002Edt().setRowId(mpt003Srch.getRowId());
						semmpt003Bean.getMpt002Edt().setEstmFlag("N");
						semmpt003Bean.getMpt002Edt().setUserId(getUserLogIn());
						to = pTaxMasterService.querySPList(EQueryName.SP_MPT002_EDT.name, semmpt003Bean.getMpt002Edt());
					}else{
						addMessageWarn("W0017");
						return flag;
					}					
				}
			}
			if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
				addMessageInfo("M0001");
			}else if(to != null && !to.isEmpty()){
				FrontMessageUtils.addMessageError(to.get(0).getpRemark());
			}
			flagDisableMsgSrch = false;
			doSearch();
		} catch (Exception e) {
			log.error(e);
				addMessageError("E0001");
		}
		return flag;
	}
	
	public boolean doClearSession(){
		boolean flag = false;
		semmpt003Bean = getSemmpt003Bean();
		semmpt003Bean.setMpt002Edt(new Mpt002Edt());
		semmpt003Bean.setMpt002EdtList(new ArrayList());
		semmpt003Bean.setMpt003Srch(new Mpt003Srch());
		semmpt003Bean.setMpt003SrchList(new ArrayList());
		semmpt003Bean.setDisabledBtnExport(true);
		semmpt003Bean.setDisabledBtnEstimate(true);
		semmpt003Bean.getMpt003Srch().setpTaxPayType("02");
		semmpt003Bean.setRenderedMsgDataNotFound(false);
		setSemmpt003Bean(semmpt003Bean);
		return flag;
	}
	
	public void selectAllRow(){
		try{
			boolean chkAll = getSemmpt003Bean().isChkSelAll();
			List<WrapperBeanObject<Mpt003Srch>> detailList = new ArrayList<WrapperBeanObject<Mpt003Srch>>();
			detailList = getSemmpt003Bean().getMpt003SrchList();
			for(int i=0; i<detailList.size(); i++){
				detailList.get(i).setCheckBox(chkAll);
			}
			onRenderExportButton();
		}catch(NullPointerException ne){
			// TODO
			
		}catch(Exception e){
			//TODO
			
		}
	}
	
	public void onRenderExportButton(){
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		log.info("tmpRowId :" + rowId);
		getSemmpt003Bean().setTmpRowId(rowId);
		
		if(isCheckSELBox() && !getSemmpt003Bean().getMpt003Srch().getpTaxStatus().equals("01")){
			getSemmpt003Bean().setDisabledBtnExport(false);
			getSemmpt003Bean().setDisabledBtnEstimate(true);
		}else if(isCheckSELBox() && getSemmpt003Bean().getMpt003Srch().getpTaxStatus().equals("01")){
			getSemmpt003Bean().setDisabledBtnExport(true);
			getSemmpt003Bean().setDisabledBtnEstimate(false);
		}else{
			getSemmpt003Bean().setDisabledBtnExport(true);
			getSemmpt003Bean().setDisabledBtnEstimate(true);
		}
	}
	
	private boolean isCheckSELBox(){
		boolean isCheck = false;
		List<WrapperBeanObject<Mpt003Srch>> rentalPayNormalSearchSP = getSemmpt003Bean().getMpt003SrchList();
		for (WrapperBeanObject<Mpt003Srch> wrapperBeanObject : rentalPayNormalSearchSP) {
			if(wrapperBeanObject.isCheckBox()){
				return true;
			}
		}
		return isCheck;
	}
	
	private SEMMPT002Bean semmpt002Bean;
	
	public SEMMPT002Bean getSemmpt002Bean() {
		return (SEMMPT002Bean)getFacesUtils().getSessionMapValue("semmpt002Bean");
	}

	public void setSemmct002Bean(SEMMPT002Bean semmpt002Bean) {
		this.semmpt002Bean = semmpt002Bean;
		getFacesUtils().setSessionMapValue("semmpt002Bean", semmpt002Bean);
	}
	
	public boolean doShow(){
		boolean flag = false;
		semmpt002Bean = new SEMMPT002Bean();
		semmpt003Bean = getSemmpt003Bean();
		String contractNo = (String)getFacesUtils().getRequestParameter("contractNo");
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		semmpt002Bean.setMpt002SrchHist(new Mpt002SrchHist());
		semmpt002Bean.getMpt002SrchHist().setContractNo(contractNo);
		List<Mpt002SrchHist> to = null;
		try {
			to = pTaxMasterService.querySPList(EQueryName.SP_MPT002_SRCH_HIST.name, semmpt002Bean.getMpt002SrchHist());
			if(to == null || to.isEmpty()){
				semmpt003Bean.setRenderedMsgDataNotFound(true);
				semmpt002Bean.setPopupClose(false);
			}else{
				semmpt003Bean.setRenderedMsgDataNotFound(false);
				for(Mpt002SrchHist mp : to){
					if(mp.getEstimateDt() != null){
						mp.setEstimateDt(SEMDataUtility.convertToThYear(mp.getEstimateDt()));
					}
					if(mp.getPaymentDt() != null){
						mp.setPaymentDt(SEMDataUtility.convertToThYear(mp.getPaymentDt()));
					}
					if(mp.getpTaxYear() != null){
						mp.setpTaxYear(mp.getpTaxYear()+543);
					}
				}
				semmpt002Bean.setPopupClose(true);
			}
			semmpt002Bean.setMpt002SrchHistList(to);
			setSemmct002Bean(semmpt002Bean);
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError(("E0003"));
			semmpt002Bean.setPopupClose(false);
		}
		return flag;
	}
	
	private boolean initExportExcel(){
		log.info("initExportExcel");
		semmpt003Bean = getSemmpt003Bean();
		// Date Format
	    DateFormat df =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
	    String tmpCompany = "";
	    boolean pass = false;
	    String token = null;
	    String govtName = "";
	  //for loop get company from List Mpt003Srch
		for(WrapperBeanObject<Mpt003Srch> mpts : semmpt003Bean.getMpt003SrchList()){
			Mpt003Srch mpt003Srch = (Mpt003Srch)mpts.getDataObj(); 
			if(mpts.isCheckBox()){
				tmpCompany = mpt003Srch.getCompany();
				if(!pass){
					token = mpt003Srch.getVendorCode();
//					govtName = mpt003Srch.getGovtName();
					pass = true;
				}
				
				if(!StringUtils.isEmpty(token)){
					if(!token.equals(mpt003Srch.getVendorCode())){
						addMessageError("W0075");
						return false;
					}
				}
			}
			
		}
		semmpt003Bean.setDisplayReportExcelFlag(true);
		setSemmpt003Bean(semmpt003Bean);
		return false;
	}

	public boolean doExportExcel(){
		log.info("doExportExcel");
		semmpt003Bean = getSemmpt003Bean();
		getSemmpt003Bean().setDisplayReportExcelFlag(false);
		// Date Format
	    DateFormat df =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
	    String tmpCompany = "";
	    boolean pass = false;
	    String token = null;
	    String govtName = "";
	  //for loop get company from List Mpt003Srch
		for(WrapperBeanObject<Mpt003Srch> mpts : semmpt003Bean.getMpt003SrchList()){
			Mpt003Srch mpt003Srch = (Mpt003Srch)mpts.getDataObj(); 
			if(mpts.isCheckBox()){
				tmpCompany = mpt003Srch.getCompany();
				if(!pass){
					token = mpt003Srch.getVendorCode();
					govtName = mpt003Srch.getGovtName();
					pass = true;
				}
				
//				if(!StringUtils.isEmpty(token)){
//					if(!token.equals(mpt003Srch.getVendorCode())){
//						addMessageError("W0075");
//						return false;
//					}
//				}
			}
			
		}
	    
		try{
			
			List<WrapperBeanObject<Mpt003Srch>> detailList = new ArrayList<WrapperBeanObject<Mpt003Srch>>();
			detailList = getSemmpt003Bean().getMpt003SrchList();
			
			/***********************************************/
			short line = 0;
			Collection<Mpt003Srch> exList = new ArrayList<Mpt003Srch>();
			//PDocumentManager export to excel
			DocumentExportManager<Mpt003Srch> docManager =
				new DocumentExportManager<Mpt003Srch>(Mpt003Srch.class, EnumDocumentType.XLS);
			// set current configuration of work book.	
				docManager.setRowStart(line);
			/***********************************************/
			
			for(int i=0; i<detailList.size(); i++){
				WrapperBeanObject<Mpt003Srch> detail = new WrapperBeanObject<Mpt003Srch>();
				detail = detailList.get(i);
				if(detail.isCheckBox()){
					Mpt003Srch tmp = new Mpt003Srch();
					tmp = (Mpt003Srch)detail.getDataObj();
					int no =1+i;
					tmp.setNo(no);
					exList.add(tmp);
				}
			}
			EnumDocStyleDomain titleStyle = new EnumDocStyleDomain(EnumDocStyle.TITLE);
			
			RowDomain rowDeTail = new RowDomain(0);
			rowDeTail.setCell(new CellDomain(0,19, null, String.class, titleStyle, govtName,null));
			
			RowDomain rowDeTail0 = new RowDomain(1);
			rowDeTail0.setCell(new CellDomain(0,19, null, String.class, titleStyle, 
					msg("export.col.headPropertyTax")+" "+msg("export.col.date")+" "+df.format(SEMDataUtility.convertToThYear(new Date())),null));
			
			RowDomain rowDeTail1 = new RowDomain(2);
			rowDeTail1.setCell(new CellDomain(0,19, null, String.class, titleStyle,
					msg("export.col.headPropertyTax2")+" "+tmpCompany,null));
			
			RowDomain rowDeTail2 = new RowDomain(3);
			rowDeTail2.setCell(new CellDomain(0,19, null, String.class, titleStyle,msg("export.col.headPropertyTax3"),null));
			
			RowDomain rowDeTail3 = new RowDomain(4);
			EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
			RowDomain rowD = new RowDomain(5);
			rowD.setCell(new CellDomain(0, null, String.class, headerStyle, msg("export.col.pTaxYear"), null));
			rowD.setCell(new CellDomain(1, null, String.class, headerStyle, msg("export.col.contractNo"),null));
			rowD.setCell(new CellDomain(2, null, String.class, headerStyle, msg("export.col.siteName"), -1, 7000));
			rowD.setCell(new CellDomain(3, null, String.class, headerStyle, msg("export.col.siteAddress"), -1,5000));
			rowD.setCell(new CellDomain(4, null, String.class, headerStyle, msg("export.col.january"), -1,2500));
			rowD.setCell(new CellDomain(5, null, String.class, headerStyle, msg("export.col.february"), -1,2500));
			rowD.setCell(new CellDomain(6, null, String.class, headerStyle, msg("export.col.march"), -1,2500));
			rowD.setCell(new CellDomain(7, null, String.class, headerStyle, msg("export.col.april"), -1,2500));
			rowD.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.col.may"), -1,2500));
			rowD.setCell(new CellDomain(9, null, String.class, headerStyle, msg("export.col.june"), -1,2500));
			rowD.setCell(new CellDomain(10, null, String.class, headerStyle, msg("export.col.july"), -1,2500));
			rowD.setCell(new CellDomain(11, null, String.class, headerStyle, msg("export.col.august"), -1,2500));
			rowD.setCell(new CellDomain(12, null, String.class, headerStyle, msg("export.col.september"), -1,2500));
			rowD.setCell(new CellDomain(13, null, String.class, headerStyle, msg("export.col.october"), -1,2500));
			rowD.setCell(new CellDomain(14, null, String.class, headerStyle, msg("export.col.november"), -1,2500));
			rowD.setCell(new CellDomain(15, null, String.class, headerStyle, msg("export.col.december"), -1,2500));
			rowD.setCell(new CellDomain(16, null, String.class, headerStyle, msg("export.col.rentAmt"), -1,5000));
			rowD.setCell(new CellDomain(17, null, String.class, headerStyle, msg("export.col.pTaxAmt"),null));
			rowD.setCell(new CellDomain(18, null, String.class, headerStyle, msg("export.col.siteStatus"),null));
			rowD.setCell(new CellDomain(19, null, String.class, headerStyle, msg("export.col.estmDt"), -1,4000));
			
			docManager.putDetailRow(rowDeTail);
			docManager.putDetailRow(rowDeTail0);
			docManager.putDetailRow(rowDeTail1);
			docManager.putDetailRow(rowDeTail2);
			docManager.putDetailRow(rowDeTail3);
			docManager.setListHeader(rowD);
			docManager.seteObjectList(exList);
			docManager.setModule("PropertyTAX_"+ SEMDataUtility.getCurrentDateDefaultForFileName());
			docManager.getObjectFromDocument();
			docManager.exportServletFile();
			
		}catch(NullPointerException ne){
			log.error(ne);
		}catch(Exception e){
			log.error(e);
		}
		return true;
	}
	
	public void validateRenderSearch(){
		semmpt003Bean = getSemmpt003Bean();
		semmpt003Bean.setTmpGroup1(true);
		semmpt003Bean.setTmpGroup2(true);
		if(!StringUtils.isEmpty(semmpt003Bean.getMpt003Srch().getCompany()) && !StringUtils.isEmpty(semmpt003Bean.getMpt003Srch().getRegion())){
			if(semmpt003Bean.getMpt003Srch().getpTaxYearFrom() != null || semmpt003Bean.getMpt003Srch().getpTaxYearFrom() > 0
				&& semmpt003Bean.getMpt003Srch().getpTaxYearTo() != null || semmpt003Bean.getMpt003Srch().getpTaxYearTo() > 0){
				semmpt003Bean.setTmpGroup2(false);
			}
		}
		if(!StringUtils.isEmpty(semmpt003Bean.getMpt003Srch().getContractNo())){
			semmpt003Bean.setTmpGroup1(false);
		}
		setSemmpt003Bean(semmpt003Bean);
	}
	
	public void renderProvinceList(){
		semmpt003Bean = getSemmpt003Bean();
		String samRegion = semmpt003Bean.getMpt003Srch().getRegion();
		Object[] objSamRegions = {samRegion};
		semmpt003Bean.setProvinceList(this.getProvinceBySamRegion(objSamRegions));
		setSemmpt003Bean(semmpt003Bean);
	}
	
	public void renderAmphurList(){
		semmpt003Bean = getSemmpt003Bean();
		Province province = new Province();
		province.setRowId(semmpt003Bean.getMpt003Srch().getProvince());
		semmpt003Bean.setAmphurList(this.getAmphurByProvince(province));
		setSemmpt003Bean(semmpt003Bean);
	}
	
	public void renderGovtList(){
		semmpt003Bean = getSemmpt003Bean();
		VendorMaster vendorMaster = new VendorMaster();
		vendorMaster.setRecordStatus("Y");
		vendorMaster.setPtaxFlag("Y");
		vendorMaster.setProvince(semmpt003Bean.getMpt003Srch().getProvince());
		semmpt003Bean.setGovtList(this.getGovtByProvince(vendorMaster));
		setSemmpt003Bean(semmpt003Bean);
	}
	
	public void doDefaultPtaxYearFrom(){
		semmpt003Bean = getSemmpt003Bean();
		if(semmpt003Bean.getMpt003Srch().getpTaxYearFrom() != null || semmpt003Bean.getMpt003Srch().getpTaxYearFrom() != 0){
			semmpt003Bean.getMpt003Srch().setpTaxYearTo(semmpt003Bean.getMpt003Srch().getpTaxYearFrom());
		}
		setSemmpt003Bean(semmpt003Bean);
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmpt003Bean().setTmpRowId(rowId);
	}

	
	public boolean doUpdatePropertyTax(){
		boolean flag = false;
		semmpt003Bean = getSemmpt003Bean();
		boolean flagException = true;
		String estmFlag = (String)getFacesUtils().getRequestParameter("estmFlag");
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		List<Mpt002Edt> to = null;
		String rowsIdConcat = "";
		try {
			for(WrapperBeanObject<Mpt003Srch> temp : semmpt003Bean.getMpt003SrchList()){
				Mpt003Srch mpts = (Mpt003Srch)temp.getDataObj();
				
				if(temp.isCheckBox() && rowsIdConcat.equals("")){
					rowsIdConcat = mpts.getRowId();
				}
				else if(temp.isCheckBox() && !rowsIdConcat.equals("")){
					rowsIdConcat = rowsIdConcat+",".trim()+mpts.getRowId();
				}			
			}
			semmpt003Bean.getMpt002Edt().setRowId(rowsIdConcat);
			semmpt003Bean.getMpt002Edt().setEstmFlag(estmFlag);
			semmpt003Bean.getMpt002Edt().setUserId(getUserLogIn());	
			to = pTaxMasterService.querySPList(EQueryName.SP_MPT002_EDT.name, semmpt003Bean.getMpt002Edt());
			if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
				addMessageInfo("M0001");
			}else if(to != null && !to.isEmpty()){
				FrontMessageUtils.addMessageError(to.get(0).getpRemark());
			}
			semmpt003Bean.setRenderedMsgFormTop(false);
			semmpt003Bean.setRenderedMsgFormMiddle(true);
			doSearch();
		} catch (Exception e) {
			log.error(e);
			semmpt003Bean.setRenderedMsgFormTop(true);
			semmpt003Bean.setRenderedMsgFormMiddle(false);
			addMessageError("E0001");
		}
		return flag;
	}
	
	public boolean initEditPropertyTax(){
		semmpt003Bean = getSemmpt003Bean();
		semmpt003Bean.setDisableEditPropertyTax(true); 
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		if(semmpt003Bean.getMpt003Srch()!=null){
			for(WrapperBeanObject<Mpt003Srch> temp : semmpt003Bean.getMpt003SrchList()){
				Mpt003Srch mpts = (Mpt003Srch)temp.getDataObj();
				if (StringUtils.equalsIgnoreCase(rowId, mpts.getRowId())){
					semmpt003Bean.getMpt003Srch().setEditPtaxMasterId(rowId);
					semmpt003Bean.getMpt003Srch().setEditContractNo(mpts.getContractNo());
					semmpt003Bean.getMpt003Srch().setEditPTaxYear(mpts.getpTaxYear());
					semmpt003Bean.getMpt003Srch().setEditRentPreAmt(mpts.getRentPreAmt());
					semmpt003Bean.getMpt003Srch().setEditRentAmt(mpts.getRentAmt());
					semmpt003Bean.getMpt003Srch().setEditPtaxAmt(mpts.getpTaxAmt());
					semmpt003Bean.getMpt003Srch().setEditRemark("");
					semmpt003Bean.setChkEditBox(false);
				}
			}
		}
		setSemmpt003Bean(semmpt003Bean);
		return false;
	}
	
	public void chkDisablePropertyTax(){
		semmpt003Bean = getSemmpt003Bean();
		
		if(semmpt003Bean.isChkEditBox()){
			semmpt003Bean.setDisableEditPropertyTax(false);
		}else {
			semmpt003Bean.setDisableEditPropertyTax(true);
		}
		setSemmpt003Bean(semmpt003Bean);
	}
	
	private boolean doSavePropertyTax() {
		semmpt003Bean = getSemmpt003Bean();
		semmpt003Bean.setPopupClose(false);
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		List<Mpt003Act> result = null;
		try{
		
			Mpt003Act act = new Mpt003Act();
			act.setEditPtaxMasterId(semmpt003Bean.getMpt003Srch().getEditPtaxMasterId());
			act.setEditPtaxAmt(semmpt003Bean.getMpt003Srch().getEditPtaxAmt());
			act.setEditRemark(semmpt003Bean.getMpt003Srch().getEditRemark());
			act.setEditUsername(getUserLogIn());
			//added by NEW 2019/01/09
			act.setEditRentAmt(semmpt003Bean.getMpt003Srch().getEditRentAmt());
			result = pTaxMasterService.querySPList(EQueryName.SP_MPT003_ACT.name,act);
		
			if(StringUtils.equalsIgnoreCase("Success", result.get(0).getpResult())){
				addMessageInfo("M0001");
				semmpt003Bean.setRenderedMsgFormTop(true);
				semmpt003Bean.setPopupClose(true);
			}else{
				semmpt003Bean.setRenderedMsgFormTop(true);
				addGeneralMessageError(result.get(0).getpRemark());
			}
			doSearch();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	private boolean doExportLetter() {
		 semmpt003Bean = getSemmpt003Bean();
		 semmpt003Bean.setRenderedMsgFormTop(false);
		 semmpt003Bean.setRenderedMsgDataNotFound(false);
			if(!validateSearch()){
				semmpt003Bean.setRenderedMsgFormTop(true);
				semmpt003Bean.setDisplayReportFlag(false);
				return false;
			}else{
				
				semmpt003Bean.setRenderedMsgFormTop(true);
				IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
				List<Mpt003Srch> to = null;
				semmpt003Bean.setMpt003SrchList(new ArrayList<WrapperBeanObject<Mpt003Srch>>());
				if(semmpt003Bean.isChkPayGovtFlag()){
					semmpt003Bean.getMpt003Srch().setPayGovtFlag("Y");
				}else{
					semmpt003Bean.getMpt003Srch().setPayGovtFlag("N");
				}
				
				try {

					to = pTaxMasterService.querySPList(EQueryName.SP_MPT003_SRCH.name, semmpt003Bean.getMpt003Srch());
					if(to == null || to.size() == 0){
							semmpt003Bean.setDisplayReportFlag(false);
							semmpt003Bean.setRenderedMsgFormTop(true);
							addMessageError("M0004");
					}else{
						semmpt003Bean.setRenderedMsgFormTop(false);
						semmpt003Bean.setDisplayReportFlag(true);
					}
				}catch (Exception e) {
					e.printStackTrace();
				}	
				
			}
		return false;
	}
	public void doExportExcelLetter(){
		semmpt003Bean = getSemmpt003Bean();
		semmpt003Bean.setDisplayReportFlag(false);
		semmpt003Bean.setRenderedMsgFormTop(false);
		List<Mpt003ExpLetter> to = null;
		if(semmpt003Bean.isChkPayGovtFlag()){
			semmpt003Bean.getMpt003Srch().setPayGovtFlag("Y");
		}else{
			semmpt003Bean.getMpt003Srch().setPayGovtFlag("N");
		}

		
		try {
			
		Mpt003ExpLetter expLetter = new Mpt003ExpLetter();
		expLetter.setpTaxYearFrom(semmpt003Bean.getMpt003Srch().getpTaxYearFrom().toString());
		expLetter.setpTaxYearTo(semmpt003Bean.getMpt003Srch().getpTaxYearTo().toString());
		expLetter.setContractNo(semmpt003Bean.getMpt003Srch().getContractNo());
		expLetter.setCompany(semmpt003Bean.getMpt003Srch().getCompany());
		expLetter.setRegion(semmpt003Bean.getMpt003Srch().getRegion());
		expLetter.setProvince(semmpt003Bean.getMpt003Srch().getProvince());
		expLetter.setAmphure(semmpt003Bean.getMpt003Srch().getAmphure());
//		expLetter.setpTaxPayType(semmpt003Bean.getMpt003Srch().getpTaxPayType());
		expLetter.setPayGovtFlag(semmpt003Bean.getMpt003Srch().getPayGovtFlag());
		expLetter.setLessorName(semmpt003Bean.getMpt003Srch().getLessorName());
		expLetter.setGovtName(semmpt003Bean.getMpt003Srch().getGovtName());
		expLetter.setpTaxStatus(semmpt003Bean.getMpt003Srch().getpTaxStatus());
		expLetter.setPayeeName(semmpt003Bean.getMpt003Srch().getPayeeName());
		expLetter.setpTaxEstmStatus(semmpt003Bean.getMpt003Srch().getpTaxEstmStatus());
		expLetter.setPaymentStatus(semmpt003Bean.getMpt003Srch().getPaymentStatus());
		
			IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");

			to = pTaxMasterService.querySPList(EQueryName.SP_MPT003_EXP.name, expLetter);
			
			
		if (to.size()>0 && to != null){
			try {
				int numberOfContract = 0;
				int rowNo = 0;	
				int widthCell = 13350;
				short line = 0;
				int columnCount = 0;
				int maxColumn = to.size();
				DocumentExportManager<Mpt003ExpLetter> docManager =
					new DocumentExportManager<Mpt003ExpLetter>(Mpt003ExpLetter.class, EnumDocumentType.XLS);
					docManager.setRowStart(line);
				
				EnumDocStyleDomain fieldStyleTLR = docManager.getStyle("pt003FieldTLR");
				EnumDocStyleDomain fieldStyleLR = docManager.getStyle("pt003FieldLR");
				EnumDocStyleDomain fieldStyleLRB = docManager.getStyle("pt003FieldLRB");
				EnumDocStyleDomain normalField = docManager.getStyle("normalField");
				
				for (Mpt003ExpLetter export : to){
					 
					RowDomain row0 = new RowDomain(rowNo++,true);
					row0.setCell(new CellDomain(0, null, String.class, fieldStyleTLR, export.getVendorCode(),-1,widthCell));
					row0.setCell(new CellDomain(1, null, String.class, normalField, "",-1,1200));
					docManager.putDetailRow(row0);
					
					RowDomain row1 = new RowDomain(rowNo++,true);
					row1.setCell(new CellDomain(0, null, String.class, fieldStyleLR, export.getVendorName(),-1,widthCell));
					docManager.putDetailRow(row1);
					
					RowDomain row2 = new RowDomain(rowNo++,true);
					row2.setCell(new CellDomain(0, null, String.class, fieldStyleLR, export.getVendorAddress1(),-1,widthCell));
					docManager.putDetailRow(row2);
					
					RowDomain row3 = new RowDomain(rowNo++,true);
					row3.setCell(new CellDomain(0, null, String.class, fieldStyleLR, export.getVendorAddress2(),-1,widthCell));
					docManager.putDetailRow(row3);
					
					String contractStr = export.getContractNo();
					String[] contractNo = null;
					contractNo = contractStr.split(",");
//					log.debug("ContractNo : "+contractNo);
					String contractNoStrCount = "";
					int chk = 1;
					int lenghtContract = contractNo.length;
					columnCount++;
						for (int i = 0; i<contractNo.length;i++){	
							if(columnCount==maxColumn){
							log.debug("i ="+i);
							log.debug("contractNo.length ="+(contractNo.length-1));
							}
							if(StringUtils.isEmpty(contractNoStrCount)){
								contractNoStrCount = contractNo[i];
							}else{
								contractNoStrCount = contractNoStrCount+","+contractNo[i];
							}
							if(chk%5 == 0 ){
								
								RowDomain row4 = new RowDomain(rowNo++,true);
								
								if(i == (contractNo.length-1)){
									log.debug("Last");
									row4.setCell(new CellDomain(0, null, String.class, fieldStyleLRB, contractNoStrCount,-1,widthCell));
								}else{
									row4.setCell(new CellDomain(0, null, String.class, fieldStyleLR, contractNoStrCount,-1,widthCell));
								}
								
								docManager.putDetailRow(row4);
								contractNoStrCount = "";
							}
							
							if(lenghtContract%5 != 0 && (chk==lenghtContract)){
								RowDomain row4 = new RowDomain(rowNo++,true);
//								row4.setCell(new CellDomain(0, null, String.class, fieldStyle, contractNoStrCount,-1,widthCell));
								if(i == (contractNo.length-1)){
									log.debug("Last");
									row4.setCell(new CellDomain(0, null, String.class, fieldStyleLRB, contractNoStrCount,-1,widthCell));
								}else{
									row4.setCell(new CellDomain(0, null, String.class, fieldStyleLR, contractNoStrCount,-1,widthCell));
								}
								docManager.putDetailRow(row4);
								contractNoStrCount = "";
							}
							chk++;
						}
					
						
				}
				log.debug("columnCount = "+columnCount);
				log.debug("maxColumn = "+maxColumn);
					docManager.seteObjectList(null);
					docManager.setModule("CONTRACT_LETTER");
					docManager.setPrintPageLandScape(true);
					docManager.setMargin(0.05, 0.05, 0.5, 0.05);
					docManager.getObjectFromDocument();
					docManager.exportServletFile();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			semmpt003Bean.setRenderedMsgDataNotFound(true);
		}
			setSemmpt003Bean(semmpt003Bean);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	// added by.. YUT
	public boolean doInitialForSearchPropertyTax() {
		log.info("::: SEMMPT003Action :: doInitialForSearchSiteInfo >> BEGIN :::");
		boolean flag = true;
		SEMMPT001Action semmpt001Action = new SEMMPT001Action();
		try {
			this.init();
			semmpt003Bean = getSemmpt003Bean();

			String paramUrl = getFacesUtils().getRequestParameter("paramUrl") == null ? "" : (String) getFacesUtils().getRequestParameter("paramUrl");
	        String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuGroup");
	        String paramMenuSubGroup = getFacesUtils().getRequestParameter("paramMenuSubGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuSubGroup");
	        String paramParameter = getFacesUtils().getRequestParameter("paramParameter") == null ? "" : (String) getFacesUtils().getRequestParameter("paramParameter");
	       
	        System.out.println("paramUrl: " + paramUrl);
	        System.out.println("paramMenuGroup: " + paramMenuGroup);
	        System.out.println("paramMenuSubGroup: " + paramMenuSubGroup);
	        System.out.println("paramParameter: " + paramParameter);
	        
//	        semmpt001Bean.getSiteInfoSP().setStrParam(paramParameter);
	        semmpt003Bean.setRenderedOnToDoList(true); //
	        semmpt003Bean.getMpt003Srch().setStrParam(paramParameter);

			setSemmpt003Bean(semmpt003Bean);
			semmpt001Action.doInitTodoList();
			
			this.doSearch();

		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMPT003Action");
			flag = false;
			
		} finally {
			semmpt001Action = null;
			log.info("::: SEMMPT003Action :: doInitialForSearchSiteInfo >> END :::");
		}
		return flag;
	}

}
