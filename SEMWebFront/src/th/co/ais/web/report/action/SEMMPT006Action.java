package th.co.ais.web.report.action;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.pt.Mpt006Srch;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.pt.IPTaxMasterService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.report.bean.SEMMPT006Bean;
import th.co.ais.web.report.util.DocumentExportManager;

public class SEMMPT006Action extends AbstractAction{

	private Logger log = Logger.getLogger(getClass());
//	private String showBtnBack = null;
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doClearSession")){
			flag = doClearSession();
		}else if(methodWithNavi.equalsIgnoreCase("doDefaultDate")){
			flag = doDefaultDate();
		}else if(methodWithNavi.equalsIgnoreCase("pageLoad")){
			flag = pageLoad();
		}  
		
		return flag;
	}

	public boolean ClearReport(){
		setSemmpt006Bean(new SEMMPT006Bean());
		return false;
	}
	
	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		SEMMPT006Bean semmpt006Bean = new SEMMPT006Bean();
		
		semmpt006Bean.setPropertyTaxTypeList(getLovItemsByType(ELovType.T_PT_PROPERTY_TAX_PAY_TYPE.name));
		semmpt006Bean.setMpt006Srch(new Mpt006Srch());
		semmpt006Bean.setMpt006SrchList(new ArrayList());
		setSemmpt006Bean(semmpt006Bean);
	}
	
	private boolean doDefaultDate(){
		boolean flagValid = false;
		semmpt006Bean  = getSemmpt006Bean();
		
		Date dueDtFrom = getSemmpt006Bean().getMpt006Srch().getCreateDateFrom();
		if(dueDtFrom != null){
			log.info("dueDtDtFrom :" + dueDtFrom);
			semmpt006Bean.getMpt006Srch().setCreateDateTo(dueDtFrom);
			flagValid = false;
		}
		setSemmpt006Bean(semmpt006Bean);
		return flagValid; 
	}
	
	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	private SEMMPT006Bean semmpt006Bean;
	
	public SEMMPT006Bean getSemmpt006Bean() {
		return (SEMMPT006Bean)getFacesUtils().getSessionMapValue("semmpt006Bean");
	}

	public void setSemmpt006Bean(SEMMPT006Bean semmpt006Bean) {
		this.semmpt006Bean = semmpt006Bean;
		getFacesUtils().setSessionMapValue("semmpt006Bean", semmpt006Bean);
	}
	
	public boolean exportPropertyTax(){
		
		boolean flag = false;
		List<Mpt006Srch>  result = null;
		semmpt006Bean  = getSemmpt006Bean();
		
		try {
			result = doSearch();
			semmpt006Bean.setMpt006SrchList(result);
			/*System.out.println("result :  "+result);
			for(Mpt006Srch data : result ){
				System.out.println("---------------xxxxx-----------------");
				System.out.println("pTaxHistId : "+data.getpTaxHistId());
				System.out.println("contractNo : "+data.getContractNo());
				System.out.println("changeAmt : "+data.getChangeAmt());
				System.out.println("pTaxPayDesc : "+data.getpTaxPayDesc());
				System.out.println("updateBy : "+data.getUpdateBy());
				System.out.println("updateDate : "+data.getUpdateDt());
				System.out.println("----------------xxxxx-----------------");
			}*/
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public boolean doClearSession(){
		boolean flag = false;
		semmpt006Bean  = getSemmpt006Bean();
		semmpt006Bean.setMpt006Srch(new Mpt006Srch());
		semmpt006Bean.setMpt006SrchList(new ArrayList());
		setSemmpt006Bean(semmpt006Bean);
		
		return flag; 
	}
	public List<Mpt006Srch> doSearch(){
		boolean flag = false;
		semmpt006Bean = getSemmpt006Bean();
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		List<Mpt006Srch> to = null;
		try {
			to = pTaxMasterService.querySPList(EQueryName.SP_MPT006_SRCH.name, semmpt006Bean.getMpt006Srch());
			if (null == to || to.isEmpty()) {
				addMessageError("M0004");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			addMessageError(("E0003"));
		
		}
		return to;
	}
	
	public void runReport(){
		try {
			short line = 0;
			SEMMPT006Bean semmpt006Bean = getSemmpt006Bean();
			List<Mpt006Srch> listSp = doSearch();
			DocumentExportManager<Mpt006Srch> docManager = new DocumentExportManager<Mpt006Srch>(Mpt006Srch.class, EnumDocumentType.XLS);
			docManager.setRowStart(line);
			
			RowDomain row1 = new RowDomain(0);
			row1.setCell(new CellDomain(0, 4, null, String.class, new EnumDocStyleDomain(EnumDocStyle.HEADER_TOPIC_LEFT), msg("mpt006.rpt.header"),null));
			docManager.putDetailRow(row1);
			
			RowDomain row2 = new RowDomain(1);
			DateFormat df =  new SimpleDateFormat("dd/MM/yyyy"); 
			row2.setCell(new CellDomain(0, 4, null, String.class, new EnumDocStyleDomain(EnumDocStyle.HEADER_TOPIC_LEFT), msg("export.col.date")+ " : " + df.format(new Date()),null));
			docManager.putDetailRow(row2);
			
			RowDomain row3 = new RowDomain(2);
			StringBuilder sb = new StringBuilder();
			sb.append(msg("export.label.criteria"));
			sb.append(" : ");
			sb.append(msg("export.label.payTax"));
			sb.append(" : ");
			sb.append(semmpt006Bean.getMpt006Srch().getPtTaxPayType() != null ? semmpt006Bean.getPropertyTaxTypeList().get(new Integer(semmpt006Bean.getMpt006Srch().getPtTaxPayType())+1).getLabel() :"");
			sb.append(" , ");
			sb.append(msg("export.label.updateDt")+" From ");
			sb.append(semmpt006Bean.getMpt006Srch().getCreateDateFrom()!= null ? df.format(semmpt006Bean.getMpt006Srch().getCreateDateFrom()) : "");
			sb.append(" To ");
			sb.append(semmpt006Bean.getMpt006Srch().getCreateDateTo() != null ? df.format(semmpt006Bean.getMpt006Srch().getCreateDateTo()) : "");
			sb.append(" , ");
			sb.append(msg("export.label.updater"));
			sb.append(" : ");
			sb.append(semmpt006Bean.getMpt006Srch().getCreateBy() != null ? semmpt006Bean.getMpt006Srch().getCreateBy() : "");
			row3.setCell(new CellDomain(0,4, null, String.class, new EnumDocStyleDomain(EnumDocStyle.HEADER_TOPIC_LEFT), sb,null));
			docManager.putDetailRow(row3);
			
			
			RowDomain row4 = new RowDomain(3);
			EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
			
			row4.setCell(new CellDomain(0, null, String.class, headerStyle, msg("export.col.contractNo"),null));
			row4.setCell(new CellDomain(1, null, String.class, headerStyle, msg("export.label.editCount"),null));
			row4.setCell(new CellDomain(2, null, String.class, headerStyle, msg("export.label.payTax"),null));
			row4.setCell(new CellDomain(3, null, String.class, headerStyle, msg("export.label.lastUpdater"),null));
			row4.setCell(new CellDomain(4, null, String.class, headerStyle, msg("export.label.lastUpdateDt"),null));
			docManager.putDetailRow(row4);
			
			docManager.setListHeader(row4);
			docManager.seteObjectList(listSp);
			docManager.setModule("EXPORT_PT_HISTORY_");
			docManager.getObjectFromDocument();
			docManager.exportServletFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean pageLoad(){
		boolean flag = true;
		String showBtnBack = (String)getFacesUtils().getRequestParameter("showBtnBack") != null ? (String)getFacesUtils().getRequestParameter("showBtnBack") : "";
		String navModule  = (String)getFacesUtils().getRequestParameter("paramNavModule") != null ? (String)getFacesUtils().getRequestParameter("paramNavModule") : "";
		String navProgram = (String)getFacesUtils().getRequestParameter("paramNavProgram") != null ? (String)getFacesUtils().getRequestParameter("paramNavProgram") : "";
		String moduleWithNavi = (String)getFacesUtils().getRequestParameter("paramModuleWithNavi") != null ? (String)getFacesUtils().getRequestParameter("paramModuleWithNavi") : "";
		String actionWithNavi = (String)getFacesUtils().getRequestParameter("paramActionWithNavi") != null ? (String)getFacesUtils().getRequestParameter("paramActionWithNavi") : "";
		String methodWithNavi = (String)getFacesUtils().getRequestParameter("ParamMethodWithNavi") != null ? (String)getFacesUtils().getRequestParameter("ParamMethodWithNavi") : "";
		
//		semmpt006Bean  = getSemmpt006Bean();
		SEMMPT006Bean semmpt006Bean = new SEMMPT006Bean();
		if(!StringUtils.isEmpty(showBtnBack)){
			
			semmpt006Bean.setDisPlaybtnBack(true); // display Button
			semmpt006Bean.setParamNavModule(navModule);
			semmpt006Bean.setParamNavProgram(navProgram);
			semmpt006Bean.setParamModuleWithNavi(moduleWithNavi);
			semmpt006Bean.setParamActionWithNavi(actionWithNavi);
			semmpt006Bean.setParamMethodWithNavi(methodWithNavi);
			
		}else{
			
			semmpt006Bean.setDisPlaybtnBack(false);
		}
		semmpt006Bean.setPropertyTaxTypeList(getLovItemsByType(ELovType.T_PT_PROPERTY_TAX_PAY_TYPE.name));
		semmpt006Bean.setMpt006Srch(new Mpt006Srch());
		semmpt006Bean.setMpt006SrchList(new ArrayList());
		setSemmpt006Bean(semmpt006Bean);
//		init();
		return flag;
	}
	
}
