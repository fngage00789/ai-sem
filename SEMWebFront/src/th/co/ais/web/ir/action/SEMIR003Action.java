package th.co.ais.web.ir.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import th.co.ais.domain.ir.Replacement;
import th.co.ais.domain.ir.ReplacementValueSP;
import th.co.ais.service.gm.ILovMasterService;
import th.co.ais.service.ir.IReplacementService;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.ir.bean.SEMIR003Bean;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.MSGCacheUtil;

public class SEMIR003Action extends AbstractAction{
	
	private static final long serialVersionUID = 970948454478321422L;
	private Logger LOG = Logger.getLogger(getClass());
	private FrontMessageUtils msg = new FrontMessageUtils();
	
	private SEMIR003Bean semir003Bean;

	public SEMIR003Bean getSems003Bean() {
		return (SEMIR003Bean) getFacesUtils().getSessionMapValue("semir003Bean");
	}

	public void setSems003Bean(SEMIR003Bean semir003Bean) {
		this.semir003Bean = semir003Bean;
		getFacesUtils().setSessionMapValue("semir003Bean", semir003Bean);
	}
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("initEdit")){
			flag = initEdit();
		}else if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		}else if(methodWithNavi.equalsIgnoreCase("doUpdate")){
			flag = doUpdate();
		}else if(methodWithNavi.equalsIgnoreCase("initDelete")){
			flag = initDelete();
		}else if(methodWithNavi.equalsIgnoreCase("doDelete")){
			flag = doDelete();
		}else if(methodWithNavi.equalsIgnoreCase("doClear")){
			flag = doClear();
		}
		return flag;
	}
	
	public boolean doSearch(){
		
		boolean flag = false;
		if(!validate())
			return flag;
		
		SEMIR003Bean semir003Bean = getSems003Bean();
		ILovMasterService lovMasterService = (ILovMasterService)getBean("lovMasterService");
		List<ReplacementValueSP> replValSPList = null;
		
		semir003Bean.setReplacementValueSPList(new ArrayList<WrapperBeanObject<ReplacementValueSP>>());
		try {
			replValSPList = lovMasterService.querySPList(EQueryName.Q_REPLACEMENT_VALUE.name, semir003Bean.getReplacementValueSP());
			 if(replValSPList != null && !replValSPList.isEmpty()){
				 for(int i=0; i<replValSPList.size(); i++){
					ReplacementValueSP replValSP = replValSPList.get(i);
					WrapperBeanObject<ReplacementValueSP> tmpWrapperBean = new WrapperBeanObject<ReplacementValueSP>();
					tmpWrapperBean.setDataObj(replValSP);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					semir003Bean.getReplacementValueSPList().add(tmpWrapperBean);
				 }
					//semir003Bean.setReplacementValueSPList(to);
			 }
			 //semir003Bean.setReplacementValueSPList(getList());
			 setSems003Bean(semir003Bean);
			 flag = true;
		} catch (Exception e) {
			LOG.error(e);
		}
		return flag;
	}
	
	public List<ReplacementValueSP> getList(){
		List<ReplacementValueSP> rpll = new ArrayList<ReplacementValueSP>();
		ReplacementValueSP rpl = new ReplacementValueSP();
		rpl.setRowId("1234567");
		rpl.setNetworkType("networkType Test");
		rpl.setNetworkCode("networkCode Test");
		rpl.setCompany("AIS");
		rpll.add(rpl);
		return rpll;
	}
	
	public boolean initEdit(){
		boolean flag = false;
		semir003Bean = getSems003Bean();
		IReplacementService replacementService = (IReplacementService)getBean("replacementService");
		String replRowId = (String)getFacesUtils().getRequestParameter("replRowId");
		String replCompany = (String)getFacesUtils().getRequestParameter("replCompany");
		String replNtType = (String)getFacesUtils().getRequestParameter("replNtType");
		String replTfType = (String)getFacesUtils().getRequestParameter("replTfType");		
		Replacement replment = new Replacement();
		if(StringUtils.isEmpty(replRowId)){
			replment.setCompany(replCompany);
			replment.setNetworkType(replNtType);
			replment.setTransferType(replTfType);
			semir003Bean.setEditReplacement(replment);
		}else {
			try {
				semir003Bean.setEditReplacement(replacementService.queryReplacementByRowId(replRowId));
			} catch (Exception e) {
				LOG.error(e);
			}
		}		
		
		return flag;
	}
	
	public boolean initDelete(){
		boolean flag = false;
		IReplacementService replacementService = (IReplacementService)getBean("replacementService");
		String replRowId = (String)getFacesUtils().getRequestParameter("replRowId");
		semir003Bean = getSems003Bean();
		try {
			semir003Bean.setEditReplacement(replacementService.queryReplacementByRowId(replRowId));
		} catch (Exception e) {
			LOG.error(e);
		}
		return flag;
	}
	
	
	public void doExportExcel(){
		LOG.info("doExportExcel");
		
		try{
			
			HSSFWorkbook wb = new HSSFWorkbook();   
			HSSFSheet sheet = wb.createSheet();   
			HSSFCellStyle style = wb.createCellStyle();		
			HSSFRow row;  
		    HSSFCell cell;
		    HSSFDataFormat format = wb.createDataFormat();
	
			short line = 0;
			row = sheet.createRow(line);      
			row.createCell((short)0).setCellValue(new HSSFRichTextString("ID"));   
			row.createCell((short)1).setCellValue(new HSSFRichTextString("Network Type"));
			row.createCell((short)2).setCellValue(new HSSFRichTextString("Company"));
			row.createCell((short)3).setCellValue(new HSSFRichTextString("Tranfer Type"));
			row.createCell((short)4).setCellValue(new HSSFRichTextString("Replacement Rate"));
			row.createCell((short)5).setCellValue(new HSSFRichTextString("Effective Date"));
			           
			List<WrapperBeanObject<ReplacementValueSP>> detailList = new ArrayList<WrapperBeanObject<ReplacementValueSP>>();
			detailList = getSems003Bean().getReplacementValueSPList();
			
			for(int i=0; i<detailList.size(); i++){
				WrapperBeanObject<ReplacementValueSP> detail = new WrapperBeanObject<ReplacementValueSP>();
				detail = detailList.get(i);
				if(detail.isCheckBox()){
					ReplacementValueSP tmp = new ReplacementValueSP();
					tmp = (ReplacementValueSP)detail.getDataObj();
					
					String rowId = "";
					if(tmp.getRowId()!= null){
						rowId = tmp.getReplRowId();
					}
					String networkCode = "";
					if(tmp.getNetworkCode() != null){
						networkCode = tmp.getNetworkCode();
					}
					String company = "";
					if(tmp.getCompany() !=null){
						company = tmp.getCompany();
					}
					String tranferType = "";
					if(tmp.getTfType() != null){
						tranferType = tmp.getTfType();
					}
					Double replVal = 0d;
					if(tmp.getReplRate() != null){
						replVal = tmp.getReplRate();
					}
					String effDt = null;
					if(tmp.getEffDt()!=null){
						effDt = SEMDataUtility.toStringCustomDateFormat(tmp.getEffDt(), "dd/MM/yyyy HH:mm:ss", SEMDataUtility.enLocale);
					}
					
					row = sheet.createRow(++line);
					
					cell = row.createCell((short)0);
					cell.setCellValue(new HSSFRichTextString(rowId));
										
					cell = row.createCell((short)1);
					cell.setCellValue(new HSSFRichTextString(networkCode));
										
					cell = row.createCell((short)2);
					cell.setCellValue(new HSSFRichTextString(company));
					
					cell = row.createCell((short)3);
					cell.setCellValue(new HSSFRichTextString(tranferType));
					
					cell = row.createCell((short)4);
					cell.setCellValue(replVal);
					style.setDataFormat(format.getFormat("#,##0"));
					cell.setCellStyle(style);
					
					cell = row.createCell((short)5);
					cell.setCellValue(new HSSFRichTextString(effDt));
					
				}
			}
			
			sheet.autoSizeColumn((short)0);
			sheet.autoSizeColumn((short)1);
			sheet.autoSizeColumn((short)2);
			sheet.autoSizeColumn((short)3);
			sheet.autoSizeColumn((short)4);
			sheet.autoSizeColumn((short)5);

			HttpServletResponse res = FacesUtils.getInstance().getHttpResponse();   
			res.setContentType("application/vnd.ms-excel");   
			res.setHeader("Content-disposition",  "attachment;filename=replacementValue.xls");   
          
            ServletOutputStream out = res.getOutputStream();   
     
            wb.write(out);   
            out.flush();   
            out.close();   
       
            FacesContext faces = FacesContext.getCurrentInstance();   
            faces.responseComplete(); 
		}catch(NullPointerException ne){
			LOG.error(ne);
		}catch(Exception e){
			LOG.error(e);
		}
	}
	
	@Override
	public void clearSessionNotUsed() {
		clearAllSessionNotUsed();

	}

	@Override
	public void init() {
		SEMIR003Bean semir003Bean = new SEMIR003Bean();
		semir003Bean.setReplacementValueSP(new ReplacementValueSP());
		semir003Bean.setCompanyList(LOVCacheUtil.getInstance().getCompanySelList());
		semir003Bean.setNetworkTypeList(LOVCacheUtil.getInstance().getNetworkTypeSelList());
		semir003Bean.setTransferTypeList(LOVCacheUtil.getInstance().getTransferTypeSelList());
		setSems003Bean(semir003Bean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSems003Bean().getReplacementValueSP().getCompany())){
			FrontMessageUtils.addMessageError("incContent:frmSearch:ddlCompany", 
											  SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), "Company"));
			flgValid = false;
		}
		return flgValid;
	}

	
	public boolean doUpdate(){
		boolean flag = false;
		IReplacementService replacementService = (IReplacementService)getBean("replacementService");
		semir003Bean = getSems003Bean();
		try {
			replacementService.updateReplacement(semir003Bean.getEditReplacement());
			doSearch();
		} catch (Exception e) {
			LOG.error(e);
		}
		return flag;
	}
	
	public boolean doDelete(){
		boolean flag = false;
		IReplacementService replacementService = (IReplacementService)getBean("replacementService");
		semir003Bean = getSems003Bean();
		try {
			replacementService.deleteReplacement(semir003Bean.getEditReplacement());
			doSearch();
		} catch (Exception e) {
			LOG.error(e);
		}
		return flag;
	}
	
	public boolean doClear() {
		boolean flag = false;
		semir003Bean = getSems003Bean();
		semir003Bean.setEditReplacement(new Replacement());
		semir003Bean.setReplacementValueSP(new ReplacementValueSP());
		semir003Bean.setReplacementValueSPList(null);
		semir003Bean.setRowId(null);
		setSems003Bean(semir003Bean);
		return flag;
	}
	
	public void selectAllRow(){
		LOG.info("select row all");
		try{
			boolean chkAll = getSems003Bean().isChkSelAll();
			List<WrapperBeanObject<ReplacementValueSP>> detailList = new ArrayList<WrapperBeanObject<ReplacementValueSP>>();
			detailList = getSems003Bean().getReplacementValueSPList();
			for(int i=0; i<detailList.size(); i++){
				detailList.get(i).setCheckBox(chkAll);
			}
			
			onRenderExportButton();
		}catch(NullPointerException ne){
			LOG.error(ne);
		}catch(Exception e){
			LOG.error(e);
		}
	}
	
	public void onRenderExportButton(){
		if(isCheckSELBox())
		getSems003Bean().setDisabledBtnExport(false);
		else
		getSems003Bean().setDisabledBtnExport(true);
	}
	
	private boolean isCheckSELBox(){
		boolean isCheck = false;
		List<WrapperBeanObject<ReplacementValueSP>> replValSP = getSems003Bean().getReplacementValueSPList();
		for (WrapperBeanObject<ReplacementValueSP> wrapperBeanObject : replValSP) {
			if(wrapperBeanObject.isCheckBox()){
				return true;
			}
		}
		return isCheck;
	}
}
