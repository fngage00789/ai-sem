package th.co.ais.web.report.action;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.rpt.parameter.SEMRRT012ReportParameter;
import th.co.ais.util.ELovType;
import th.co.ais.util.EParamName;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRRT012Bean;
import th.co.ais.web.report.util.ReportDataUtil;
import th.co.ais.web.util.ParameterCacheUtil;

public class SEMRRT012Action extends AbstractReportAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2524424552117504744L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRRT012Bean semrrt012Bean;
	
	public SEMRRT012Bean getSemrrt012Bean() {
		return (SEMRRT012Bean) getFacesUtils().getSessionMapValue("semrrt012Bean");
	}

	public void setSemrrt012Bean(SEMRRT012Bean semrrt012Bean) {
		getFacesUtils().setSessionMapValue("semrrt012Bean", semrrt012Bean);
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		
		if(methodWithNavi.equalsIgnoreCase("doRunReport")){
			runReport();
		} else if (methodWithNavi.equalsIgnoreCase("doShowReport")) {
			showReport();
		} else if (methodWithNavi.equalsIgnoreCase("doClearReport")) {
			clearReport();
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		super.clearSessionBean();
	}
	
	private void setDefault() {
		String[] selectItemArray = {"On Service","Off Service","Remove"}; 
		semrrt012Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrrt012Bean.setDepositTypeList(getLovItemsByType(ELovType.CT_DEPOSIT_TYPE.name));
		
		semrrt012Bean.setBankCodeList(getLovItemsByType(ELovType.T_CT_BG_BANK.name));
		semrrt012Bean.setExpenseTypeList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name, EX_IN, "DEPOSIT_RENT,DEPOSIT_ELECTRIC", null, null));
		
		List<SelectItem> selectItemList = new LinkedList<SelectItem>();
		SelectItem selectItem = new SelectItem("",msg("value.selectItem"));
		selectItemList.add(selectItem);
		for(int i=0;i<selectItemArray.length;i++){
			selectItem = new SelectItem();
			selectItem.setLabel(selectItemArray[i]);
			selectItem.setValue(selectItemArray[i]);
			selectItemList.add(selectItem);
		}

		semrrt012Bean.setNetworkStatusList(selectItemList);
		semrrt012Bean.setContactStatusList(ParameterCacheUtil.getInstance().getParamItemsByParamName(EParamName.P_REP_SITE_STATUS.name));
		
		semrrt012Bean.setDepositType("02");
		semrrt012Bean.setDepositStatus("ALL");
		semrrt012Bean.setDepositDtTo(new Date());
	}

	@Override
	public void init() {
		super.clearSessionBean();
		semrrt012Bean = new SEMRRT012Bean();
		
		setDefault();
		
		setSemrrt012Bean(semrrt012Bean);
	}
		
	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		if (StringUtils.isEmpty(getSemrrt012Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemrrt012Bean().getDepositType())) {
			addMessageError("W0001", msg("message.depositeType"));
			flgValid = false;
		}
		
		if (null == getSemrrt012Bean().getDepositDtTo()) {
			addMessageError("W0001", msg("message.depositDtTo"));
			flgValid = false;
		}
		
		Date depositDateFrom = getSemrrt012Bean().getDepositDtFrom();
		Date depositDateTo = getSemrrt012Bean().getDepositDtTo();
		log.debug("depositDateFrom = "+depositDateFrom);
		log.debug("depositDateTo = "+depositDateTo);
		log.debug("depositDateFrom = "+getParameterDateStr(depositDateFrom));
		log.debug("depositDateTo = "+getParameterDateStr(depositDateTo));
		
		if(depositDateFrom != null && depositDateTo != null){
			if (depositDateFrom.after(depositDateTo)) {
				addMessageErrorWithArgument("W0006" ,msg("message.depositDtFrom"), msg("message.depositDtTo"));
				flgValid = false;
			}
		}
		
		return flgValid;
	}
	

	@Override
	public void clearReport() {
		super.clearSessionBean();
		getSemrrt012Bean().clearReportSimple();
		
		getSemrrt012Bean().setCompany(null);
		getSemrrt012Bean().setContractNo(null);
		getSemrrt012Bean().setLocationId(null);
		getSemrrt012Bean().setRegion(null);
		getSemrrt012Bean().setVendor(null);
		getSemrrt012Bean().setDepositType(null);
		getSemrrt012Bean().setPayDate(null);
		getSemrrt012Bean().setAsOfDate(null);
		getSemrrt012Bean().setBgNumber(null);
		getSemrrt012Bean().setBankCode(null);
		getSemrrt012Bean().setExpenseType(null);
		getSemrrt012Bean().setContractNo(null);
		getSemrrt012Bean().setNetworkStatus(null);
		getSemrrt012Bean().setDepositStatus(null);
		getSemrrt012Bean().setMultiContract(null);
		getSemrrt012Bean().setMultiRegion(null);
		getSemrrt012Bean().setMultiVendor(null);
		getSemrrt012Bean().setDepositType("02");
		getSemrrt012Bean().setDepositStatus("ALL");
		
		getSemrrt012Bean().setDisableBank(true);
		getSemrrt012Bean().setDisableBgNo(true);
		getSemrrt012Bean().setDepositDtFrom(null);
		getSemrrt012Bean().setDepositDtTo(null);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrrt012Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrrt012Bean");
	}

	@Override
	public void runReport() {
		// TODO Auto-generated method stub
		semrrt012Bean = getSemrrt012Bean();
		SEMRRT012ReportParameter param = null;
		List<SelectItem> s = null;
		if (validate()) {
			try {
				param = new SEMRRT012ReportParameter();
				log.debug("getSemrrt012Bean().getDepositType() = "+getSemrrt012Bean().getDepositType());
				
				log.debug("semrrt012Bean.getCompany() = "+semrrt012Bean.getCompany());
				log.debug("getParameterDateStr(semrrt012Bean.getDepositDtFrom() = "+getParameterDateStr(semrrt012Bean.getDepositDtFrom()));
				param.setP_header_name(getCompanyHeaderName(semrrt012Bean.getCompany()));
				param.setP_company(semrrt012Bean.getCompany());
				param.setP_bg_no(semrrt012Bean.getBgNumber());
				param.setP_bank(semrrt012Bean.getBankCode());
				param.setP_contract_no(semrrt012Bean.getContractNo());
				param.setP_vendor_code(semrrt012Bean.getMultiVendor());
				param.setP_region(semrrt012Bean.getMultiRegion());
				param.setP_expense_type(semrrt012Bean.getExpenseType());
				param.setP_contract_status(semrrt012Bean.getContactStatus());
				param.setP_network_status(semrrt012Bean.getNetworkStatus());
				param.setP_deposit_datet_from(semrrt012Bean.getDepositDtFrom());
				param.setP_deposit_date_to(semrrt012Bean.getDepositDtTo());
				param.setP_contract_no(semrrt012Bean.getMultiContract());
				param.setP_location_code(semrrt012Bean.getLocationId());
				param.setP_deposit_type(semrrt012Bean.getDepositType()); 
				param.setP_deposit_status(semrrt012Bean.getDepositStatus());
				param.setP_username(getUserLogIn());
				param.setP_location_code(ReportDataUtil.convertSelectItem2StringByValue(
						semrrt012Bean.getPopupSiteMultiLocationBean().getSelectedList()));
				//Set Sheet Name
				
			
				String[] tmp;
				String[] sheetName;
				if(!StringUtils.isEmpty(semrrt012Bean.getDepositType())){
					tmp = semrrt012Bean.getDepositType().split(",");
					log.debug("tmp = "+tmp);
					if(tmp.length>1){
						sheetName = new String[2];
						sheetName[0] = "BG";
						sheetName[1] = "Cash";
					}else{
						sheetName = new String[1];
						if("01".equals(tmp[0]))
							sheetName[0] = "BG";
						else
							sheetName[0] = "Cash";
					}
					param.setP_sheet_name(sheetName);
					
				}
				
				
	
				
				
				if(! semrrt012Bean.isDisableBank()){
					if (StringUtils.isNotEmpty(semrrt012Bean.getBankCode())) {
						s = th.co.ais.web.util.WebUtil.getSelectItemByValue(
								semrrt012Bean.getBankCode()	, semrrt012Bean.getBankCodeList());
						if (s != null) {
							param.setP_display_bank(s.get(0).getLabel());
						}
					}
				}
				
				if (StringUtils.isNotEmpty(semrrt012Bean.getExpenseType())) {
					s = th.co.ais.web.util.WebUtil.getSelectItemByValue(
							semrrt012Bean.getExpenseType()	, semrrt012Bean.getExpenseTypeList());
					if (s != null) {
						param.setP_display_expense_type(s.get(0).getLabel());
					}
				}
				
				if (StringUtils.isNotEmpty(semrrt012Bean.getContactStatus())) {
					s = th.co.ais.web.util.WebUtil.getSelectItemByValue(
							semrrt012Bean.getContactStatus()	, semrrt012Bean.getContactStatusList());
					if (s != null) {
						param.setP_display_contract_status(s.get(0).getLabel());
					}
				}
				
				if (StringUtils.isNotEmpty(semrrt012Bean.getNetworkStatus())) {
					s = th.co.ais.web.util.WebUtil.getSelectItemByValue(
							semrrt012Bean.getNetworkStatus()	, semrrt012Bean.getNetworkStatusList());
					if (s != null) {
						param.setP_display_network_status(s.get(0).getLabel());
					}
				}
				
				
	
//					param.setP_header_name(getCompanyHeaderName(semrrt012Bean.getCompany()));
//					param.setP_company(semrrt012Bean.getCompany());
//					param.setP_contract_no(ReportDataUtil.convertSelectItem2StringByValue(
//							semrrt012Bean.getPopupSiteMultiContractBean().getSelectedList()));
//					param.setP_location_id(ReportDataUtil.convertSelectItem2StringByValue(
//							semrrt012Bean.getPopupSiteMultiLocationBean().getSelectedList()));
//					param.setP_region(ReportDataUtil.convertSelectItem2StringByValue(
//							semrrt012Bean.getPopupSiteMultiRegionBean().getSelectedLgist()));
//					param.setP_vendor(ReportDataUtil.convertSelectItem2StringByValue(
//							semrrt012Bean.getPopupMultiVendorBean().getSelectedList()));
//					param.setP_deposit_type(semrrt012Bean.getDepositType());
//					param.setP_deposit_datet_from(getParameterDateStr(semrrt012Bean.getDepositDtFrom()));
//					param.setP_deposit_date_to(getParameterDateStr(semrrt012Bean.getDepositDtTo()));
				
				
//				if("01".equals(getSemrrt012Bean().getDepositType())){
//					super.runReport("SEMRRT012_1", param, 
//							semrrt012Bean.getReportType(), semrrt012Bean.getRunType(), 
//							semrrt012Bean.getBatchType(), semrrt012Bean.getJobSchedule());
//				}else if("02".equals(getSemrrt012Bean().getDepositType())){
//					super.runReport("SEMRRT012_2", param, 
//							semrrt012Bean.getReportType(), semrrt012Bean.getRunType(), 
//							semrrt012Bean.getBatchType(), semrrt012Bean.getJobSchedule());
//				}else{//if case deposit type = all
//					super.runReport("SEMRRT012_1", param, 
//							semrrt012Bean.getReportType(), semrrt012Bean.getRunType(), 
//							semrrt012Bean.getBatchType(), semrrt012Bean.getJobSchedule());
//					super.runReport("SEMRRT012_2", param, 
//							semrrt012Bean.getReportType(), semrrt012Bean.getRunType(), 
//							semrrt012Bean.getBatchType(), semrrt012Bean.getJobSchedule());
//				}
				super.runReport("SEMRRT012", param, 
						semrrt012Bean.getReportType(), semrrt012Bean.getRunType(), 
						semrrt012Bean.getBatchType(), semrrt012Bean.getJobSchedule());
			
			} catch (Exception e) {
				log.error("RUN REPORT ERROR IN " + getClass() +  " : " + e);
				e.printStackTrace();
			} finally{
				param = null;
			}
		}
		
		
	}

		

//		private String mergArrayByComma(String[] array){
//		
//		if(array == null || array.length==0){
//			return "";
//		}
//		StringBuffer sb = new StringBuffer();
//		for(int i=0;i<array.length;i++){
//			sb.append(array[i]);
//			if(i<array.length-1){
//				sb.append(",");
//			}
//		}
//		
//		return sb.toString();
//		
//	}
	@Override
	public void showReport() {
		
		super.showReport("SEMRRT012", getSemrrt012Bean().getReportType());
	}
	
	public void checkRadioBtn(){
		if("02".equals(getSemrrt012Bean().getDepositType())){
			getSemrrt012Bean().setDisableBank(true);
			getSemrrt012Bean().setDisableBgNo(true);
		}else{
			getSemrrt012Bean().setDisableBank(false);
			getSemrrt012Bean().setDisableBgNo(false);
		}
	}


}
