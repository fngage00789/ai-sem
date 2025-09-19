package th.co.ais.web.el.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.MeterInfo;
import th.co.ais.domain.gm.ParameterConfig;
import th.co.ais.service.el.IMeterInfoService;
import th.co.ais.util.BeanUtils;
import th.co.ais.util.ELovType;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.SsoBean;
import th.co.ais.web.el.bean.SEMMEL004Bean;
import th.co.ais.web.util.CompanyCacheUtil;
import th.co.ais.web.util.ELUtils;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.config.ParameterConfigUtil;

public class SEMMEL004Action extends AbstractAction {

	private static final long serialVersionUID 		= -3047942377523281188L;
	private static final Locale CURRENT_LOCALE		=  FacesContext.getCurrentInstance().getViewRoot().getLocale();
	private static final ResourceBundle RS_BUNDLE 	= ResourceBundle.getBundle("resources.el.semmel004", CURRENT_LOCALE);
	private static final Logger LOGGER 				= Logger.getLogger(SEMMEL004Action.class);

	private static final String ACT_SEARCH			= "doSearch";
	private static final String ACT_CLEAR			= "doClear";
	
	private SEMMEL004Bean semmel004Bean;
	
	@Override
	public void init() {
		LOGGER.info("START init");
		SEMMEL004Bean semmel004Bean = new SEMMEL004Bean();
		semmel004Bean.setCompanyList(CompanyCacheUtil.getInstance().getCompanySelItemsALL());
		semmel004Bean.setElectricUseTypeList(ELUtils.filterLOVByLOVValue("3",LOVCacheUtil.getInstance().getByLOVType(ELovType.T_EL_ELECTRIC_TYPE.name)));
		semmel004Bean.setElectricUseType("ALL");
		semmel004Bean.setOneBillAddFlagList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_EL_ONEBILL_STATUS.name));
		semmel004Bean.setOneBillAddFlag("N");
		setSemmel004Bean(semmel004Bean);
		LOGGER.info("END init");
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if (ACT_SEARCH.equalsIgnoreCase(methodWithNavi)) {
			flag = doSearch();
		} else if (ACT_CLEAR.equalsIgnoreCase(methodWithNavi)) {
			flag = doClear();
		}
		return flag;
	}

	public boolean doClear() {
		boolean flag = false;
		init();
		return flag;
	}

	public boolean doSearch() {
		LOGGER.info("START Action doSearch");
		boolean flag = false;
		if (validateFrmSearch()) {
			return flag;
		}
		
		try {
			SEMMEL004Bean semmel004Bean = getSemmel004Bean();
			MeterInfo meterInfo = new MeterInfo();
			this.setMeterInfo(semmel004Bean, meterInfo);
			IMeterInfoService meterInfoService = (IMeterInfoService) getBean("meterInfoService");
			List<MeterInfo> meterInfoList = null;

			LOGGER.info("START Service queryMeterInfoByCriteria");
			//LOGGER.info("Parameter : "+BeanUtils.getBeanString(meterInfo));
			meterInfoList = meterInfoService.queryMeterInfoByCriteria(meterInfo);
			LOGGER.info("END Service queryMeterInfoByCriteria");
			if (null == meterInfoList || meterInfoList.isEmpty()) {
				addMessageError("M0004");
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",	new Locale("th", "TH"));
			for (MeterInfo obj : meterInfoList) {
				obj.setOneBillAddFlagDisplay(ELUtils.getLOVNameByLOVCode(
						semmel004Bean.getOneBillAddFlagList(), obj.getOneBillAddFlag()));
				if (null != obj.getElectricId()) {
					obj.setElecTricUstTypeDisplay(ELUtils.getLOVNameByLOVCode(
							semmel004Bean.getElectricUseTypeList(), obj.getElectricId().getElectricUseType()));
				}
				try{
					obj.setUploadMeterDtStr(sdf.format(obj.getUploadMeterDt()));
				}catch (Exception e){}
				try{
					obj.seteOnMeterDtStr(sdf.format(obj.geteOnMeterDt()));
				}catch (Exception e){}
				try{
					obj.seteOneBillDtStr(sdf.format(obj.geteOneBillDt()));
				}catch (Exception e){}
			}
			semmel004Bean.setMeterInfoList(meterInfoList);
			setSemmel004Bean(semmel004Bean);
		} catch (Exception e) {
			LOGGER.error("doSearch() Exception : ", e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL004-1");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		LOGGER.info("END Action doSearch");
		return flag;
	}

	private void setMeterInfo(SEMMEL004Bean semmel004Bean, MeterInfo meterInfo) {
		Management electric = new Management();
		electric.setCompany(semmel004Bean.getCompany());
		electric.setContractNo(semmel004Bean.getContractNo());
		electric.setSiteName(semmel004Bean.getSiteName());
		electric.setElectricUseType(semmel004Bean.getElectricUseType());
		electric.setLocationId(semmel004Bean.getLocationId());
		electric.setLocationCode(semmel004Bean.getLocationCode());
		meterInfo.setElectricId(electric);
		meterInfo.setOneBillFlag("Y");
		meterInfo.setpMeterOwnerName(semmel004Bean.getpMeterOwnerName());
		meterInfo.setOneBillAddFlag(semmel004Bean.getOneBillAddFlag());
		meterInfo.seteOneBillDt(semmel004Bean.geteOneBillDt());
		meterInfo.seteOneBillDtFrom(semmel004Bean.geteOneBillDtFrom());
		meterInfo.seteOneBillDtTo(semmel004Bean.geteOneBillDtTo());
		meterInfo.setUploadMeterDtFrom(semmel004Bean.getUploadMeterDtFrom());
		meterInfo.setUploadMeterDtTo(semmel004Bean.getUploadMeterDtTo());
	}

	private boolean validateFrmSearch() {
		boolean flagValid = false;
		if (StringUtils.isEmpty(getSemmel004Bean().getContractNo())) {
			if (StringUtils.isEmpty(getSemmel004Bean().getCompany())) {
				addMessageError("W0001", msg("message.company"));
				flagValid = true;
			}
		}
		if (StringUtils.isEmpty(getSemmel004Bean().getElectricUseType())) {
			addMessageError("W0001", this.getValidateMessage("label.electricUseType"));
			flagValid = true;
		}
		if (StringUtils.isEmpty(getSemmel004Bean().getOneBillAddFlag())) {
			addMessageError("W0001", this.getValidateMessage("label.oneBillStatus"));
			flagValid = true;
		}
		Date uploadMeterDtFrom = getSemmel004Bean().getUploadMeterDtFrom();
		Date uploadMeterDtTo = getSemmel004Bean().getUploadMeterDtTo();
		if(null!=uploadMeterDtFrom && null==uploadMeterDtTo){
			addMessageError("W0001", this.getValidateMessage("msg.uploadMeterDt"));
			flagValid = true;
		}
		Date eOnebillDtFrom = getSemmel004Bean().geteOneBillDtFrom();
		Date eOnebillDtTo = getSemmel004Bean().geteOneBillDtTo();
		if(null!=eOnebillDtFrom && null==eOnebillDtTo){
			addMessageError("W0001", this.getValidateMessage("msg.oneBillDt"));
			flagValid = true;
		}
		if(null==eOnebillDtTo){
			
		}
		
		return flagValid;
	}

	public SEMMEL004Bean getSemmel004Bean() {
		return (SEMMEL004Bean) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("semmel004Bean");
	}

	public void setSemmel004Bean(SEMMEL004Bean semmel004Bean) {
		this.semmel004Bean = semmel004Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.put("semmel004Bean", this.semmel004Bean);
	}

	@Override
	public void clearSessionNotUsed() {

	}

	@Override
	public boolean validate() {

		return false;
	}

	public void getRowIdOnClick() {
		String rowId = (String) getFacesUtils().getRequestParameter("rowId");
		getSemmel004Bean().setTmpRowId(rowId);
	}

	public void selectAllRow() {
		try {
			boolean chkAll = getSemmel004Bean().isChkSelAll();
			List<MeterInfo> detailList = new ArrayList<MeterInfo>();
			detailList = getSemmel004Bean().getMeterInfoList();
			for (int i = 0; i < detailList.size(); i++) {
				if (!"Y".equals(detailList.get(i).getOneBillAddFlag())) {
					detailList.get(i).setSelected(chkAll);
				}
			}
			onRenderExportButton();
		} catch (NullPointerException ne) {

		} catch (Exception e) {

		}
	}

	public void onRenderExportButton() {
		if (isCheckSELBox())
			getSemmel004Bean().setDisabledBtnExport(false);
		else
			getSemmel004Bean().setDisabledBtnExport(true);
	}

	private boolean isCheckSELBox() {
		boolean isCheck = false;
		List<MeterInfo> meterInfoList = getSemmel004Bean().getMeterInfoList();
		for (MeterInfo obj : meterInfoList) {
			if (obj.isSelected()) {
				return true;
			}
		}
		return isCheck;
	}

	public void doExportExcel() {
		LOGGER.info("START doExportExcel");
		try {
			this.updateMeterInfo();
			
			HSSFWorkbook wb = new HSSFWorkbook(this.getClass().getResourceAsStream("/resources/el/oneBill.xls"));
			HSSFSheet sheet = wb.getSheetAt(0);
			
			HSSFRow row;
			HSSFCell cell;
			short line = 0;
			
			List<MeterInfo> detailList = new ArrayList<MeterInfo>();
			detailList = getSemmel004Bean().getMeterInfoList();

			for (int i = 0; i < detailList.size(); i++) {
				MeterInfo detail = new MeterInfo();
				detail = detailList.get(i);
				if (detail.isSelected()) {

					row = sheet.createRow(++line);
					cell = row.createCell((short) 0);
					int j = i + 1;
					cell.setCellValue(new HSSFRichTextString(j + ""));

					cell = row.createCell((short) 1);
					cell.setCellValue(new HSSFRichTextString(detail.getElectricId().getContractNo()));

					cell = row.createCell((short) 2);
					cell.setCellValue(new HSSFRichTextString(detail.getElectricId().getSiteName()));

					cell = row.createCell((short) 3);
					cell.setCellValue(new HSSFRichTextString(detail.getMeterId()));

					cell = row.createCell((short) 4);
					//cell.setCellValue(new HSSFRichTextString(detail.geteAreaName()));
					cell.setCellValue(new HSSFRichTextString(detail.getAreaName()));

					cell = row.createCell((short) 5);
					cell.setCellValue(new HSSFRichTextString(detail.geteOnMeterDtStr()));

					cell = row.createCell((short) 6);
					cell.setCellValue(new HSSFRichTextString(detail.getOneBillRemark()));

				}
			}
			sheet.autoSizeColumn((short) 0);
			sheet.autoSizeColumn((short) 1);
			sheet.autoSizeColumn((short) 2);
			sheet.autoSizeColumn((short) 3);
			sheet.autoSizeColumn((short) 4);
			sheet.autoSizeColumn((short) 5);
			sheet.autoSizeColumn((short) 6);

			HttpServletResponse res = FacesUtils.getInstance().getHttpResponse();
			String fileName = getSemmel004Bean().getCompany()+"_Onebill_"+SEMDataUtility.getCurrentDateDefaultForFileName()+".xls";
			res.setContentType("application/vnd.ms-excel");
			res.setHeader("Content-disposition","attachment;filename="+fileName);

			ServletOutputStream out = res.getOutputStream();

			wb.write(out);
			out.flush();
			out.close();

			FacesContext faces = FacesContext.getCurrentInstance();
			faces.responseComplete();
		} catch (Exception e) {
			LOGGER.error("ERROR in doExportExcel : ",e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL004-1");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		LOGGER.info("END doExportExcel");
	}

	private void updateMeterInfo() throws Exception {

		IMeterInfoService meterInfoService = (IMeterInfoService) getBean("meterInfoService");
		List<MeterInfo> meterInfoList = getSemmel004Bean().getMeterInfoList();
		if((meterInfoList != null) && (!meterInfoList.isEmpty())){
			List<MeterInfo> updates = new ArrayList<MeterInfo>();
			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			for(MeterInfo mt : meterInfoList){
				if(mt.isSelected()){
					mt.setUpdateBy(ssoBean.getUserName());
					mt.setCurrentUser(ssoBean.getUserName());
					updates.add(mt);
				}
			}
			
			if((updates != null) && (!updates.isEmpty())){
				ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_METER_E008");
				String plName = parameter.getParamValue();
				meterInfoService.updateMeterInfoExport(updates, plName);
			}
		}
	}

	private String getMessage(String key) {
		return RS_BUNDLE.getString(key);
	}
	
	private String getValidateMessage(String key) {
		String msg = this.getMessage(key);
		if(msg != null){
			msg = msg.replaceAll(":", "");
		}else{
			msg = "Properties key[" +key+ "] not found.";
		}
		return msg;
	}
}
