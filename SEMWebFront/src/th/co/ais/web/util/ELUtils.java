package th.co.ais.web.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TimeZone;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;

import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.MeterInfo;
import th.co.ais.domain.el.Payment;
import th.co.ais.domain.el.PaymentDetail;
import th.co.ais.domain.el.PaymentSearch;
import th.co.ais.domain.el.PopupSiteSearch;
import th.co.ais.domain.gm.ParameterConfig;
import th.co.ais.domain.gm.Province;
import th.co.ais.util.ELovType;
import th.co.ais.web.el.bean.SEMMEL006Bean;
import th.co.ais.web.util.config.ParameterConfigUtil;

public class ELUtils {
	
	
	
	public static BigDecimal VAT_RATE = new BigDecimal(7);
	
	/*
		EL_BILL	ค่าไฟฟ้าบิลรวม	
		EL_POSTPAID	ค่าไฟฟ้าการไฟฟ้า	
		EL_TEMP	ค่าไฟฟ้าชั่วคราว	
		PR_POSTPAID	ค่าไฟฟ้าเอกชน	
		PR_PREPAID	ค่าไฟฟ้าเหมาจ่าย	
	*/
		
		public static String EL_BILL ="EL_BILL";
		public static String EL_POSTPAID ="EL_POSTPAID";
		public static String EL_TEMP ="EL_TEMP";
		public static String PR_POSTPAID ="PR_POSTPAID";
		public static String PR_PREPAID ="PR_PREPAID";
		
		
		
		

		/*
		 * 	EL_ELECTRIC_TYPE
		 	MEA	:	การไฟฟ้านครหลวง
			PEA	:	การไฟฟ้าส่วนภูมิภาค
		 */
		public static String ELECTRIC_TYPE_MEA ="MEA";
		public static String ELECTRIC_TYPE_PEA ="PEA";		
		public static String ELECTRIC_TYPE_PRIVATE ="PRIVATE";	
		
		/*
		 * Parameter
		 */
		public static String EL_MEA_VENDOR_ID ="EL_MEA_VENDOR_ID";
		public static String EL_PEA_VENDOR_ID ="EL_PEA_VENDOR_ID";

		public static String EL_MEA_VENDOR_NAME ="EL_MEA_VENDOR_NAME";
		public static String EL_PEA_VENDOR_NAME ="EL_PEA_VENDOR_NAME";
		
		public static String EL_MEA_PAYEE_ID ="EL_MEA_PAYEE_ID";
		public static String EL_PEA_PAYEE_ID ="EL_PEA_PAYEE_ID";
		
		public static String EL_MEA_PAYEE_NAME ="EL_MEA_PAYEE_NAME";
		public static String EL_PEA_PAYEE_NAME ="EL_PEA_PAYEE_NAME";
		
		
		public static String EL_MEA_PAYEE_MASTER_ID ="EL_MEA_PAYEE_MASTER_ID";
		
		public static String EL_PEA_PAYEE_MASTER_ID ="EL_PEA_PAYEE_MASTER_ID";
		/*
		 * PaymentType
		 * 	CT_PAYMENT_TYPE	01		เช็ค
			CT_PAYMENT_TYPE	02		โอน
		 */
		
		public static String PAYMENT_TYPE_01 ="01";
		public static String PAYMENT_TYPE_02 ="02";
		public static String PAYMENT_TYPE_03 ="03"; 
		
		
	    // Expense Type
		//EL_POSTPAID	:	ค่าไฟฟ้าการไฟฟ้า
		//EL_DEBIT	1|4	เบิกเพิ่มค่าไฟฟ้าการไฟฟ้า
		//EL_CREDIT	1|4	ขอคืนค่าไฟฟ้าการไฟฟ้า
		public static String EXPENSE_TYPE_EL_POSPAID ="EL_POSTPAID";
		public static String EXPENSE_TYPE_EL_DEBIT ="EL_DEBIT";
		public static String EXPENSE_TYPE_EL_CREDIT ="EL_CREDIT";
		
		// Doc Type		
		//DR: Debit Note (LOV_CODE = DR)
		//CR: Credit Note (LOV_CODE = CR)
		public static String DOC_TYPE_DR ="DR";
		public static String DOC_TYPE_CR ="CR";
		
		public static String PAYMENT_METHOD_01 ="01";
		public static String PAYMENT_METHOD_02 ="02";
		public static String PAYMENT_METHOD_03 ="03";
		public static String PAYMENT_METHOD_04 ="04";
		public static String PAYMENT_METHOD_05 ="05";
		

		public static String EL_PEA_BANK_NAME ="EL_PEA_BANK_NAME";
		public static String EL_MEA_BANK_NAME = "EL_MEA_BANK_NAME";
		public static String EL_MEA_BANK_ACCOUNT ="EL_MEA_BANK_ACCOUNT";
		public static String EL_PEA_BANK_ACCOUNT ="EL_PEA_BANK_ACCOUNT";
		public static String EL_PATH_UPLOAD_METER = "EL_PATH_UPLOAD_METER";
		public static String EL_ROWID_UPLOAD_METER = "EL_ROWID_UPLOAD_METER";
		public static String EL_SHEETID_UPLOAD_METER = "EL_SHEETID_UPLOAD_METER";
		public static String EL_CT_DEPOSIT_CASH = "EL_CT_DEPOSIT_CASH";
		public static String EL_CT_EXPENSE_DEPOSIT = "EL_CT_EXPENSE_DEPOSIT";
		public static String RECORD_STATUS_Y= "Y";
		public static String EL_CT_BG_SPECIAL = "EL_CT_BG_SPECIAL";
		public static String EL_CT_BG_STATUS_DRAFT = "D";
		public static String EL_CT_BG_STATUS_NEW = "N";
		public static String EL_CT_BG_STATUS_FINANCE = "F";
		public static String EL_CT_BG_STATUS_REJECT = "R";
		public static String EL_CT_BG_STATUS_ACTIVE = "A";
		public static String EL_CT_BG_STATUS_EXPIRE = "E";
		public static String ELECTRIC_USE_TYPE_MEA_NEW = "10001";
		public static String ELECTRIC_USE_TYPE_MEA_OLD = "10002";
		public static String ELECTRIC_USE_TYPE_PEA_NEW = "10003";
		public static String ELECTRIC_USE_TYPE_PEA_OLD = "10004";
		public static String EL_ROWID_UPLOAD_TXT_MN = "EL_ROWID_UPLOAD_TXT_MN";
		public static String EL_ROWID_UPLOAD_TXT_MO = "EL_ROWID_UPLOAD_TXT_MO";
		public static String EL_ROWID_UPLOAD_TXT_PN = "EL_ROWID_UPLOAD_TXT_PN";
		public static String EL_ROWID_UPLOAD_TXT_PO = "EL_ROWID_UPLOAD_TXT_PO";
		public static String EL_PG_RENEW_R001 = "EL_PG_RENEW_R001";
		public static String EL_PG_RENEW_R002 = "EL_PG_RENEW_R002";
		public static String EL_PG_SITEINFO_S001 = "EL_PG_SITEINFO_S001";
		public static String PL_TEXTFILE_UPDATE_TRANSACTION = "EL_PG_UPLOAD_T001";
		public static String PL_TEXTFILE_VALIDATE_UPLOAD_TEXT = "EL_PG_UPLOAD_T002";
		public static String IMPORT_TRANSACTION_STATUS_SUCCESS = "90";
		public static String IMPORT_TRANSACTION_STATUS_FAIL = "91";
		public static String EL_CT_PBOOK_STATUS_ACTIVE = "EL_CT_PBOOK_STATUS_ACTIVE";
		public static String EL_CT_VBOOK_STATUS_ACTIVE = "EL_CT_VBOOK_STATUS_ACTIVE";
		public static String EL_CT_VENDOR_STATUS_ACTIVE = "EL_CT_VENDOR_STATUS_ACTIVE";
		public static String EL_CT_PAYEE_STATUS_ACTIVE = "EL_CT_PAYEE_STATUS_ACTIVE";
		public static String SEM_PG_EL_VALIDATE_TEXT_UPD = "SEM_PG_EL_VALIDATE_TEXT_UPD";
		public static String EL_PG_METER_INFO = "EL_PG_METER_INFO";
		public static String EL_CT_BG_SPECIAL_TYPE = "02";
		public static String EL_PG_RENEW_R004 = "EL_PG_RENEW_R004";
		public static String EL_PG_RENEW_R003 = "EL_PG_RENEW_R003";
		public static String EL_FEE_CHECK_AREA = "01";
		public static String EL_EXPENSE_TYPE_FEE = "EL_EXPENSE_TYPE_FEE";
		public static String EL_EXPENSE_TYPE_FEE_METER = "FEE_METER";
		public static String EL_EXPENSE_TYPE_FEE_SURVEY = "FEE_SURVEY";
		public static String EL_PG_FEE_F001 = "EL_PG_FEE_F001";
		public static String EL_PG_UPLOAD_M003 = "EL_PG_UPLOAD_M003";
		public static String EL_PG_UPLOAD_M013 = "EL_PG_UPLOAD_M013";
		public static String EL_PG_FEE_F002 = "EL_PG_FEE_F002";
		public static String EL_CT_F_DEUTSCHE_BANK = "EL_CT_F_DEUTSCHE_BANK";//WT###Add 20110207
		public static String EL_PG_CANCEL_C001 = "EL_PG_CANCEL_C001";//WT###Add 20110207
		//---------------------------------------------------------------------
		public static String EL_PG_FEE_F003 = "EL_PG_FEE_F003";
		//---------------------------------------------------------------------
		
		public static String EL_CT_PAYMENT_STATUS_01 = "EL_CT_PAYMENT_STATUS_01";
		public static String EL_CT_PAYMENT_STATUS_02 = "EL_CT_PAYMENT_STATUS_02";
		public static String EL_PG_DISBURSED_D003 = "EL_PG_DISBURSED_D003";
		//------------------------------------------------------------------------
		
		public static String EL_PG_DISBURSED_D004 = "EL_PG_DISBURSED_D004";
		
		public static String EL_PG_DEPOSIT_D001  = "EL_PG_DEPOSIT_D001";
		public static String EL_PG_SITEINFO_S009 = "EL_PG_SITEINFO_S001";
		
		// Error Message and Warning Message
		public static String E0001  = "E0001";
		public static String EL0013  = "EL0013";
		public static String EL0040  = "EL0040";
		
		public static String CT_PAYMENT_METHOD = "CT_DEFAULT_PAYMENT_METHOD";//WT###Add 20190417
		
	public static String getExPenseType(String expenTypeIn){
		
		String expenseTypeReturn = ELUtils.EL_BILL;
		
		if(ELUtils.EL_POSTPAID.equals(expenTypeIn)){
			expenseTypeReturn = ELUtils.EL_POSTPAID;
		}else if(ELUtils.EL_TEMP.equals(expenTypeIn)){
			expenseTypeReturn = ELUtils.EL_TEMP;
		}else if(ELUtils.PR_POSTPAID.equals(expenTypeIn)){
			expenseTypeReturn = ELUtils.PR_POSTPAID;
		}if(ELUtils.PR_PREPAID.equals(expenTypeIn)){
			expenseTypeReturn = ELUtils.PR_PREPAID;
		}
		
		return expenseTypeReturn;
	}
		
	public static String getLOVNameByLOVCode(List<SelectItem> lovList,String lovCode){
		String lovNameReturn ="";		
		for(SelectItem itemtmp:lovList){			
			try {
				if(StringUtils.isEmpty(lovCode)){
					return "";
				}
				if(lovCode.equals(itemtmp.getValue())){
					lovNameReturn = itemtmp.getLabel();
				}
			} catch (Exception e) {
			}			
		}		
		return lovNameReturn;
	}
	
	public static List getLOVBtLOVCodeList(List<SelectItem> lovList,Map  lovCodeMap){
		List<SelectItem> lovNameReturnList = new ArrayList();	
		SelectItem tmp0 = new SelectItem();
		tmp0.setLabel("-- Select --");
		tmp0.setValue(null);
		lovNameReturnList.add(tmp0);		
		for(SelectItem itemtmp:lovList){
			String tmpcode = (String)itemtmp.getValue();			
			if(lovCodeMap.get(tmpcode)!=null){
				lovNameReturnList.add(itemtmp);
			}
		}		
		return lovNameReturnList;
	}
	
	
	public static List<SelectItem> filterLOVByLOVValue(String lovValue,List<SelectItem> selList) {
		List<SelectItem> selListReturn = new ArrayList<SelectItem>();
		
		
		SelectItem tmp0 = new SelectItem();
		tmp0.setLabel("-- Select --");
		tmp0.setValue(null);
		selListReturn.add(tmp0);
		
		if(selList!=null&&selList.size()>0){
			//System.out.println(" Size In :"+selList.size());
			for(SelectItem temptmp: selList){
				//System.out.println("lovValue : desc>> "+lovValue+":"+temptmp.getDescription());		
				String desc = temptmp.getDescription();
				boolean isMatch = false;
				if(desc!=null){
					StringTokenizer st = new StringTokenizer(desc, "|");
				       while (st.hasMoreElements()){
				    	   String stValue = (String)st.nextElement();
				    	   //System.out.println(" lovValue: st "+lovValue +":"+stValue);
//							if(lovValue.equals(stValue)){							
//								isMatch = true;
//							}
				    	   if(stValue.equals(lovValue)){							
								isMatch = true;
				    	   }
			        	}
				}else{
					//selListReturn.add(temptmp);
				}
				if(isMatch){
					selListReturn.add(temptmp);
					//System.out.println(" Match LOVCODE:LABEL>>"+temptmp.getValue()+":"+temptmp.getLabel());
				}
			
			}
			//System.out.println(" Size out :"+selListReturn.size());
		}
		return selListReturn;
	}
	
	public static List<SelectItem> getExpenseTyeMEAList(List<SelectItem> selList) {
		List<SelectItem> selListReturn = new ArrayList<SelectItem>();		
		
		SelectItem tmp0 = new SelectItem();
		tmp0.setLabel("-- Select --");
		tmp0.setValue(null);
		selListReturn.add(tmp0);
		//MEA>> EL_BILL,		EL_POSTPAID,		EL_TEMP		
		//PEA >>PR_POSTPAID ,PR_PREPAID
		if(selList!=null&&selList.size()>0){
			//System.out.println(" Size In :"+selList.size());
			for(SelectItem temptmp: selList){
				if(temptmp.getValue().equals("EL_BILL")||temptmp.getValue().equals("EL_POSTPAID")||temptmp.getValue().equals("EL_TEMP")){
				selListReturn.add(temptmp);								
			}			
			}
			//System.out.println(" Size out :"+selListReturn.size());
		}
		return selListReturn;
	}
	public static List<SelectItem> getExpenseTyePEAList(List<SelectItem> selList) {
		List<SelectItem> selListReturn = new ArrayList<SelectItem>();		
		
		SelectItem tmp0 = new SelectItem();
		tmp0.setLabel("-- Select --");
		tmp0.setValue(null);
		selListReturn.add(tmp0);	
		//PEA >>PR_POSTPAID ,PR_PREPAID
		if(selList!=null&&selList.size()>0){
			//System.out.println(" Size In :"+selList.size());
			for(SelectItem temptmp: selList){
				if(temptmp.getValue().equals("PR_POSTPAID")||temptmp.getValue().equals("PR_PREPAID")){
				selListReturn.add(temptmp);								
			}			
			}
			//System.out.println(" Size out :"+selListReturn.size());
		}
		return selListReturn;
	}	
	
	public static List<SelectItem> getEmptyList() {
		List<SelectItem> selListReturn = new ArrayList<SelectItem>();
		
		
		SelectItem tmp0 = new SelectItem();
		tmp0.setLabel("-- Select --");
		tmp0.setValue(null);
		selListReturn.add(tmp0);

		return selListReturn;
	}
	
	public static List<SelectItem> filterProvinceByRegionCode(String regionCode) {
		List<SelectItem> selListReturn = new ArrayList<SelectItem>();
		
		
		SelectItem tmp0 = new SelectItem();
		tmp0.setLabel("-- Select --");
		tmp0.setValue(null);
		selListReturn.add(tmp0);
		
	//	@Override
	//	public List<Province> getListProvinceByRegions(Object[] regions) throws Exception {
	//		return provinceDao.queryProvinceByRegions(regions);
	//	}
		List<SelectItem> selList = new ArrayList();
		if(selList!=null&&selList.size()>0){
			System.out.println(" Size In :"+selList.size());
			for(SelectItem temptmp: selList){
				//System.out.println("regionCode : desc>> "+regionCode+":"+BeanUtils.getBeanString(temptmp));		
				String desc = temptmp.getDescription();
				boolean isMatch = false;
				if(desc!=null){
					StringTokenizer st = new StringTokenizer(desc, "|");
				       while (st.hasMoreElements()){			              
							if(regionCode.equals(st.nextElement())){							
								isMatch = true;
							}	
			        	}
				}else{
					//selListReturn.add(temptmp);
				}
				if(isMatch){
					selListReturn.add(temptmp);
				}
				// Please comment out this for test 
				selListReturn.add(temptmp);
			}
			//System.out.println(" Size out :"+selListReturn.size());
		}
		return selListReturn;
	}
	
	
	public static List<SelectItem> addProvinceToList(List<Province> listIn) {
		List<SelectItem> selListReturn = new ArrayList<SelectItem>();
		
		
		SelectItem tmp0 = new SelectItem();
		tmp0.setLabel("-- Select --");
		tmp0.setValue(null);
		selListReturn.add(tmp0);
		if(listIn!=null&&listIn.size()>0){
			System.out.println(" Size In :"+listIn.size());
			for(Province temptmp: listIn){
				SelectItem tmpsel = new SelectItem();
				tmpsel.setLabel(temptmp.getThaiName());
				tmpsel.setValue(temptmp.getProvinceCode());
				selListReturn.add(tmpsel);
			}
			
		}
		return selListReturn;
	}
	

	public  static List<SelectItem> getYearDropDownList(){
		List<SelectItem> returnList = new ArrayList();
		try{			
			SelectItem tmp0 = new SelectItem();
			tmp0.setLabel("-- Select --");
			tmp0.setValue(null);
			returnList.add(tmp0);
			for(int i=-5;i<=5;i++){
				Calendar cal = Calendar.getInstance(new Locale("th", "TH")); 
				
				//cal.set
				SelectItem tmp = new SelectItem();
				cal.add(Calendar.YEAR, i);
				int year = cal.get(Calendar.YEAR);
				tmp.setLabel(year+"");
				tmp.setValue(year+"");
				returnList.add(tmp);
			}	
			
			
			/*SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy", new Locale("th", "TH"));
			String periodTxt = "01"+meterInstallment.getFormTermOfPaymentMonth()+meterInstallment.getFormTermOfPaymentYear();
			Date fromTermOfPaymentDt =sdf.parse(periodTxt);
			
			periodTxt = "01"+meterInstallment.getToTermOfPaymentMonth()+meterInstallment.getToTermOfPaymentYear();
			Date ToTermOfPaymentDt =sdf.parse(periodTxt);*/
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return returnList;
	}
	
	
	public  static List<SelectItem> getMonthDropDownList(){
		List<SelectItem> returnList = new ArrayList();
		try{			
			SelectItem tmp0 = new SelectItem();
			tmp0.setValue(null);
			tmp0.setLabel("-- Select --");
			SelectItem tmp1 = new SelectItem();
			tmp1.setValue("01");
			tmp1.setLabel("01");
			SelectItem tmp2 = new SelectItem();
			tmp2.setValue("02");
			tmp2.setLabel("02");			
			SelectItem tmp3 = new SelectItem();
			tmp3.setValue("03");
			tmp3.setLabel("03");			
			SelectItem tmp4 = new SelectItem();
			tmp4.setValue("04");
			tmp4.setLabel("04");			
			SelectItem tmp5 = new SelectItem();
			tmp5.setValue("05");
			tmp5.setLabel("05");			
			SelectItem tmp6 = new SelectItem();
			tmp6.setValue("06");
			tmp6.setLabel("06");		
			SelectItem tmp7 = new SelectItem();
			tmp7.setValue("07");
			tmp7.setLabel("07");		
			SelectItem tmp8 = new SelectItem();
			tmp8.setValue("08");
			tmp8.setLabel("08");			
			SelectItem tmp9 = new SelectItem();
			tmp9.setValue("09");
			tmp9.setLabel("09");			
			SelectItem tmp10 = new SelectItem();
			tmp10.setValue("10");
			tmp10.setLabel("10");			
			SelectItem tmp11 = new SelectItem();
			tmp11.setValue("11");
			tmp11.setLabel("11");
			SelectItem tmp12 = new SelectItem();
			tmp12.setValue("12");
			tmp12.setLabel("12");
			
			returnList.add(tmp0);
			returnList.add(tmp1);
			returnList.add(tmp2);
			returnList.add(tmp3);
			returnList.add(tmp4);
			returnList.add(tmp5);
			returnList.add(tmp6);
			returnList.add(tmp7);
			returnList.add(tmp8);
			returnList.add(tmp9);
			returnList.add(tmp10);
			returnList.add(tmp11);
			returnList.add(tmp12);
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return returnList;
	}
	
	// ***** modified by bestnaja *****
	public static List<SelectItem> getMeterIdList(List <MeterInfo> listIn) throws Exception{
		
		List<SelectItem> returnList = new ArrayList<SelectItem>();
		
		// default
		SelectItem tmp0 = new SelectItem();
		tmp0.setLabel("-- Select --");
		tmp0.setValue(null);
		
		returnList.add(tmp0);
		
		// prepare list
		for(MeterInfo tmp : listIn){
			
			SelectItem tmpItem = new SelectItem();
			
			String meterIdStr = tmp.getMeterId();
			String refMeterIdstr = tmp.getReferMeterId();
			
			//WT###Edit 20110118 Start
			//if(meterIdStr != null && meterIdStr.indexOf('-') > -1){
			if(meterIdStr != null){
			//WT###Edit 20110118 End
				
				tmpItem.setLabel(meterIdStr);
				tmpItem.setValue(tmp.getRowId());
				
			}else{
				
				tmpItem.setLabel(refMeterIdstr);
				tmpItem.setValue(tmp.getRowId());
			}
			returnList.add(tmpItem);
		}	
			
		return returnList;
	}	
	
	public static Date getDateByMonthandYear(String month, String year){
	Date returnDate= new Date();	
	SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));

	 String dateIn = "01/"+month+"/"+year+"";
	try{
		returnDate = dateformat.parse(dateIn);
	}catch(Exception ex){
		ex.printStackTrace();
	}
	return returnDate; 
}


	
	public static String getParaValueStringbyCode(String codeIn){
		
		String valuestr = "";
		try{
			ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode(codeIn);
			valuestr = parameter.getParamValue();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return valuestr;
	}
	
	public static String getMonthNumberByDate(Date dateIn){
		String returnStr= "";		
		SimpleDateFormat monthFormat = new SimpleDateFormat("MM");	
		try{
			returnStr = monthFormat.format(dateIn);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return returnStr; 
	}
	 
	public static String getYearNumberByDate(Date dateIn){
		String returnStr= null;	
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
		try{
			returnStr = yearFormat.format(dateIn);			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return returnStr; 
	}
	//WT###Add 20110119 Start
	public static String getYearNumberByDate(Date dateIn, String locale){
		String returnStr= null;	
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy",  new Locale(locale.toLowerCase(), locale.toUpperCase()));
		try{
			returnStr = yearFormat.format(dateIn);			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return returnStr; 
	}
	
	public static String getMonthNumberByDate(Date dateIn, String locale){
		String returnStr= null;	
		SimpleDateFormat monthFormat = new SimpleDateFormat("MM",  new Locale(locale.toLowerCase(), locale.toUpperCase()));
		try{
			returnStr = monthFormat.format(dateIn);			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return returnStr; 
	}
	
	//WT###Add 20110119 End
	public static void setManagementDisplayField(Management managementIn){
		try{			
			//managementIn.seteMeterTypeDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name), 
			//		managementIn.));
		}catch(Exception ex){
			ex.printStackTrace();
		}		
	}

	public static void setPamentDisplayField(Payment beanIn){
		try{		
	
		
			beanIn.setPaymentTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_TYPE.name), 
					beanIn.getPaymentType()));		
			beanIn.setPaymentMethodTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name), 
					beanIn.getPaymentMethod()));	
			beanIn.setElectricUseTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name), 
					beanIn.getElectricUseType()));				
			beanIn.setExpenseTypeDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name), 
					beanIn.getExpenseType()));	
			//beanIn.setRefDocTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType..name), 					beanIn.getRefDocType()));	
			beanIn.setDocTypeDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name), 
					beanIn.getDocType()));
		 
			beanIn.setVatTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_VAT_TYPE.name), beanIn.getVatType()));
 
		}catch(Exception ex){
			ex.printStackTrace();
		}		
	}
	public static void setPamentSearchDisplayField(PaymentSearch beanIn){
		try{			
		
			beanIn.setPaymentTypeDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_TYPE.name), 
					beanIn.getPaymentType()));		
			beanIn.setPaymentMethodDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name), 
					beanIn.getPaymentMethod()));	
			beanIn.setElectricUseTypeDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name), 
					beanIn.getElectricUseType()));				
			beanIn.setExpenseTypeDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name), 
					beanIn.getExpenseType()));	
			beanIn.setVatTypeDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_VAT_TYPE.name), beanIn.getVatType()));
 
		}catch(Exception ex){
			ex.printStackTrace();
		}		
	}	
	public static void setPamentDetailDisplayField(PaymentDetail beanIn) throws Exception{
		
		beanIn.setVatTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_VAT_TYPE.name), beanIn.getVatType()));
		beanIn.setUnitVatTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_VAT_TYPE.name), beanIn.getUnitVatType()));
		beanIn.setExpenseTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name), beanIn.getExpenseType()));
		//WT###20110119 Start
		beanIn.setWhtTypeTxt(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.CT_WHT_TYPE.name), beanIn.getWhtType()));
		//WT###20110119 End

	}
	
	public static void setPopupSearchsiteDisplayField(PopupSiteSearch beanIn){
		try{		
         //   ,(select LOV_NAME from SEM_CT_LOV_MASTER where  LOV_TYPE = 'EL_ELECTRIC_TYPE' and  LOV_CODE=M.ELECTRIC_USE_TYPE) as ELECTRIC_USE_TYPE_DISPLAY
        
        //    ,(select LOV_NAME from SEM_CT_LOV_MASTER where  LOV_TYPE = 'EL_OUTSTANDING_FLAG' and  LOV_CODE=M.RECORD_STATUS) as RECORD_STATUS_DISPLAY

      //      ,(select LOV_NAME from SEM_CT_LOV_MASTER where  LOV_TYPE = 'SI_SITE_STATUS' and  LOV_CODE=M.SITE_STATUS) as SITE_STATUS_DISPLAY

         
      //       ,(select LOV_NAME from SEM_CT_LOV_MASTER where  LOV_TYPE = 'CT_NETWORK_STATUS' and  LOV_CODE=M.NETWORK_STATUS) as NETWORK_STATUS_DISPLAY

			beanIn.setElectricUseTypeDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType("EL_ELECTRIC_TYPE"), 
					beanIn.getElectricUseType()));		
			beanIn.setRecordStatusDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType("EL_OUTSTANDING_FLAG"), 
					beanIn.getRecordStatus()));	
			beanIn.setSiteStatusDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType("SI_SITE_STATUS"), 
					beanIn.getSiteStatus()));	
			beanIn.setNetworkStatusDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType("CT_NETWORK_STATUS"), 
					beanIn.getNetworkStatus()));				
 
		}catch(Exception ex){
			ex.printStackTrace();
		}		
	}
	
	public static void copyPropertyManagementToPayment(Management mag,Payment pay){
		try{
			
			pay.setElectricUseType(mag.getElectricUseType());
			pay.setDocType(mag.getDepositType());
			//pay.setDocNo(mag.getD)
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void copySearchsiteToPayment(PopupSiteSearch popupSite,Payment payment){		
		payment.setCompany(popupSite.getCompany());
		payment.setOldContractNo(popupSite.getOldContractNo());
		payment.setContractNo(popupSite.getContractNo());
		payment.setElectricUseType(popupSite.getElectricUseType());
		payment.setSiteName(popupSite.getSiteName());
		payment.setSiteStatus(popupSite.getSiteStatus());
		payment.setNetWorkStatus(popupSite.getNetworkStatus());
		payment.setLocationId(popupSite.getLocationId());
		payment.setLocationCode(popupSite.getLocationCode());	
		payment.setVatType(popupSite.getpVatType());
		payment.setPayment_channel(popupSite.getPayment_channel());
		
		//payment.setExpenseType(popupSite.get);
	}
	public static void copyPaymentToPopupSiteSearch(Payment payment,PopupSiteSearch popupSite){		
		popupSite.setCompany(payment.getCompany());
		popupSite.setOldContractNo(payment.getOldContractNo());
		popupSite.setContractNo(payment.getContractNo());
		popupSite.setElectricUseType(payment.getElectricUseType());
		popupSite.setSiteName(payment.getSiteName());
		//popupSite.seteAreaCode(payment.g)
		popupSite.setSiteStatus(payment.getSiteStatus());
		popupSite.setNetworkStatus(payment.getNetWorkStatus());
		popupSite.setLocationId(payment.getLocationId());
		popupSite.setLocationCode(payment.getLocationCode());	
		
		String meterId = "";
		//String eAreaCode ="";
		Set paymetSet = payment.getDetails();
		List detailList = new ArrayList();
		if(paymetSet!=null){
			Object [] detailarray = paymetSet.toArray();
			for(Object tmp:detailarray){
				PaymentDetail detail = (PaymentDetail)tmp;
				meterId =detail.getMeterId();				
			}				
		}	
		popupSite.setMeterId(meterId);	
		
	}	
	
	public static String getMeterId(Payment payment){		
	
		String meterId = "";
		//String eAreaCode ="";
		Set paymetSet = payment.getDetails();
		List detailList = new ArrayList();
		if(paymetSet!=null){
			Object [] detailarray = paymetSet.toArray();
			for(Object tmp:detailarray){
				PaymentDetail detail = (PaymentDetail)tmp;
				meterId =detail.getMeterId();				
			}				
		}	
		return meterId;
		
	}		
	public static void copySearchsiteToPaymentDetail(PopupSiteSearch popupSite,PaymentDetail paymentDetail){
		
		paymentDetail.setMeterId(popupSite.getMeterId());		
	}
	
	
	public static void setAllDisablePayment(SEMMEL006Bean beanIn){
		
		/*
		 * 	//  Payment Disable  
    private boolean expenseTypeDisable;
    private boolean docTypeDisable;
    private boolean docNoDisable;
    private boolean docDtDisable;
	private boolean refDocNoDisable;
	private boolean refDocDtDisable;
    private boolean vendorIdDisable;
    private boolean vendorNameDisable;
    
    
    */
		
		beanIn.setExpenseTypeDisable(true);
		beanIn.setDocTypeDisable(true);
		beanIn.setDocNoDisable(true);
		beanIn.setDocDtDisable(true);
		beanIn.setRefDocNoDisable(true);
		beanIn.setRefDocDtDisable(true);
		beanIn.setVendorIdDisable(true);
		beanIn.setVendorNameDisable(true);		
		
		/*
    private boolean payeeIdDisable;
    private boolean payeeNameDisable;
    private boolean paymentTypeDisable;
    private boolean paymentMethodDisable;
    private boolean bankNameDisable;
    private boolean bankAccountDisable;
    private boolean remarkDisable;
	*/			
		beanIn.setPayeeIdDisable(true);
		beanIn.setPayeeNameDisable(true);
		beanIn.setPaymentTypeDisable(true);
		beanIn.setPaymentMethodDisable(true);
		beanIn.setBankNameDisable(true);
		beanIn.setBankAccountDisable(true);
		beanIn.setRemarkDisable(true);
		
		beanIn.setTransferDtDisable(true);
		beanIn.setChqReceivedDtDisable(true);
		beanIn.setChqPostingDtDisable(true);
		
	}
	
	public static void setAllEnablePayment(SEMMEL006Bean beanIn){
		
		/*
		 * 	//  Payment Disable  
    private boolean expenseTypeDisable;
    private boolean docTypeDisable;
    private boolean docNoDisable;
    private boolean docDtDisable;
	private boolean refDocNoDisable;
	private boolean refDocDtDisable;
    private boolean vendorIdDisable;
    private boolean vendorNameDisable;
    
    
    */
		
		beanIn.setExpenseTypeDisable(false);
		beanIn.setDocTypeDisable(false);
		beanIn.setDocNoDisable(false);
		beanIn.setDocDtDisable(false);
		beanIn.setRefDocNoDisable(false);
		beanIn.setRefDocDtDisable(false);
		beanIn.setVendorIdDisable(false);
		beanIn.setVendorNameDisable(false);		
		
		/*
    private boolean payeeIdDisable;
    private boolean payeeNameDisable;
    private boolean paymentTypeDisable;
    private boolean paymentMethodDisable;
    private boolean bankNameDisable;
    private boolean bankAccountDisable;
    private boolean remarkDisable;
	*/			
		beanIn.setPayeeIdDisable(false);
		beanIn.setPayeeNameDisable(false);
		beanIn.setPaymentTypeDisable(false);
		beanIn.setPaymentMethodDisable(false);
		beanIn.setBankNameDisable(false);
		beanIn.setBankAccountDisable(false);
		beanIn.setRemarkDisable(false);
		beanIn.setTransferDtDisable(false);
		beanIn.setChqReceivedDtDisable(false);
		beanIn.setChqPostingDtDisable(false);
		
	}
		
	public static String getMonthYearFromDate(Date dateIn){
		String returnStr = "";
		
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
			try{
				returnStr = sf.format(dateIn);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		return returnStr;
	}
	
	public static String getNumberToString(BigDecimal numberIn){
		NumberFormat formatter = new DecimalFormat("#0.00"); 
		String returnStr = "";
			try{
				returnStr = formatter.format(numberIn);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		return returnStr;
	}
	
	public static List<SelectItem> addProvinceToSelectItem(List<Province> provinces) {
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem("","-- Select --"));
		
		if ((provinces != null) && (!provinces.isEmpty())) {
			for (Province province : provinces) {
				SelectItem tmpsel = new SelectItem();
				tmpsel.setLabel(province.getThaiName());
				tmpsel.setValue(province.getRowId());
				
				items.add(tmpsel);
			}

		}
		return items;
	}
	
	public static BigDecimal getExcludeVatFromVatRate(BigDecimal finalPrice){
		BigDecimal returnExVatAmt  = new BigDecimal(0);		
		try{			 //100 - ((100 * 7) / 107)] 
			BigDecimal onehundred = new BigDecimal(100);			
			BigDecimal onePluVatRate = onehundred.add(ELUtils.VAT_RATE);
			BigDecimal onehundredDivideonePluVatRate = onehundred.divide(onePluVatRate,2,BigDecimal.ROUND_HALF_UP);
			returnExVatAmt = finalPrice.multiply(onehundredDivideonePluVatRate);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return returnExVatAmt;
	}
	public static BigDecimal getExcludeVatFromTotalPay(BigDecimal totalPay){
		BigDecimal returnExVatAmt  = new BigDecimal(0);		
		try{			 //100 - ((100 * 7) / 107)] 
			BigDecimal onehundred = new BigDecimal(100);			
			BigDecimal onePluVatRate = onehundred.add(ELUtils.VAT_RATE);
			BigDecimal oneMultiplyVat = totalPay.multiply(ELUtils.VAT_RATE);
			BigDecimal onehundredDivideonePluVatRate = oneMultiplyVat.divide(onePluVatRate,2,BigDecimal.ROUND_HALF_UP);
			returnExVatAmt = totalPay.subtract(onehundredDivideonePluVatRate);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return returnExVatAmt;
	}
	
	
		public static BigDecimal getVatAmtFromTotalPay(BigDecimal totalPay){
		BigDecimal returnExVatAmt  = new BigDecimal(0);		
		try{			
			BigDecimal onehundred = new BigDecimal(100);			
			BigDecimal onePluVatRate = onehundred.add(ELUtils.VAT_RATE);
			BigDecimal oneMultiplyVat = totalPay.multiply(ELUtils.VAT_RATE);
			returnExVatAmt = oneMultiplyVat.divide(onePluVatRate,2,BigDecimal.ROUND_HALF_UP);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return returnExVatAmt;
	}
		
	public static BigDecimal getNoVatAmtFromTotalPay(BigDecimal totalPay){
			BigDecimal returnExVatAmt  = new BigDecimal(0);		
			try{			
				BigDecimal onehundred = new BigDecimal(100);			
				BigDecimal onePluVatRate = onehundred;
				BigDecimal oneMultiplyVat = totalPay.multiply(ELUtils.VAT_RATE);
				returnExVatAmt = oneMultiplyVat.divide(onePluVatRate,2,BigDecimal.ROUND_HALF_UP);
			}catch(Exception ex){
				ex.printStackTrace();
			}
			return returnExVatAmt;
		}
	public static BigDecimal getVatFromVatRate(BigDecimal totalPayAmt){
		BigDecimal returnVatAmt  = new BigDecimal(0);		
		try{			 
			BigDecimal exVat = getExcludeVatFromVatRate(totalPayAmt);			
			returnVatAmt = totalPayAmt.subtract(exVat).setScale(2,BigDecimal.ROUND_HALF_UP);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return returnVatAmt;
	}
	
	public static BigDecimal getNoVatFromVatRate(BigDecimal totalPayAmt){
		BigDecimal returnVatAmt  = new BigDecimal(0);		
		try{			 
			 
			returnVatAmt = totalPayAmt.multiply(ELUtils.VAT_RATE).divide(new BigDecimal(100),2,BigDecimal.ROUND_HALF_UP);
			 
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return returnVatAmt;
	}
	
	public static BigDecimal getAmtPercent(BigDecimal amtIn,BigDecimal percent){
		BigDecimal returnAmt  = new BigDecimal(0);		
		try{			 
			if(amtIn==null||amtIn.intValue()==0){
				returnAmt  = new BigDecimal(0);	
			}else{
				BigDecimal onePlusPercent = new BigDecimal(100);//.add(percent);
				returnAmt = amtIn.multiply(percent).divide(onePlusPercent,2,BigDecimal.ROUND_HALF_UP);
			}
					
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return returnAmt;
	}
	
	public static BigDecimal getSevenVAtAmtFromOriginalPrice(BigDecimal originalPrice){
		BigDecimal returnAmt  = new BigDecimal(0);		
		try{			 
			if(originalPrice==null||originalPrice.intValue()==0){
				returnAmt  = new BigDecimal(0);	
			}else{
				BigDecimal vatPercent = new BigDecimal(7).divide(new BigDecimal(100),2,BigDecimal.ROUND_HALF_UP);		
				returnAmt = originalPrice.multiply(vatPercent);
			
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return returnAmt;
	}
	
	public static Date getEndDateByMonthandYear(String month, String year){
		Date returnDate= new Date();	
		Date inputDate= new Date();	
		
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
		Calendar calendar = Calendar.getInstance(new Locale("th", "TH"));
		inputDate = getDateByDateMonthandYear("01",month,year);
		calendar.setTime(inputDate);
		//calendar.set(Calendar.MONTH,Integer.parseInt(month)-1);
		//calendar.set(Calendar.YEAR,Integer.parseInt(year));
		
		int lastDate = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); 
		String dateIn = lastDate+ "/"+month+"/"+year+"";
		try{
			returnDate = dateformat.parse(dateIn);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return returnDate; 
	}
	public static String getYearNumberByDateTH(Date dateIn){
		String returnStr= null;	
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy", new Locale("th", "TH"));
		try{
			returnStr = yearFormat.format(dateIn);			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return returnStr; 
	}
	
	public static int compare(Date d1, Date d2) {     
		if (d1.getYear() != d2.getYear())          
			return d1.getYear() - d2.getYear();     
		if (d1.getMonth() != d2.getMonth())          
			return d1.getMonth() - d2.getMonth();     
		return d1.getDate() - d2.getDate();   
	} 
	
	public static Date getDateByDateMonthandYear(String date,String month, String year){
		Date returnDate= new Date();	
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));

		 String dateIn = date+"/"+month+"/"+year+"";
		try{
			returnDate = dateformat.parse(dateIn);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return returnDate; 
	}
	public static Date previousMonthLastDate(Date referenceDate) {     
		Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));     
		calendar.setTime(referenceDate);     
		calendar.add(Calendar.MONTH, -1); 
		// move to the previous month     
		int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);     
		calendar.set(Calendar.DAY_OF_MONTH, lastDay);     
		// set the time to be the end of the day     
		calendar.set(Calendar.HOUR_OF_DAY, 23);    
		calendar.set(Calendar.MINUTE, 59);    
		calendar.set(Calendar.SECOND, 59);      
		return calendar.getTime();  
	}
	
	public static Date getEndDateByMonthandYear(Date dateData){
		Date returnDate= new Date();	
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
		
		Calendar calendar = Calendar.getInstance(new Locale("th", "TH"));
		calendar.setTime(dateData);
		//calendar.set(Calendar.MONTH,Integer.parseInt(month)-1);
		//calendar.set(Calendar.YEAR,Integer.parseInt(year));
		
		int lastDate = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); 
		
		System.out.println("lastDate:"+lastDate);
		
		//String dateIn = lastDate+ "/"+month+"/"+year+"";
		try{
			//returnDate = dateformat.parse(dateIn);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return returnDate; 
	}
	public static List<SelectItem> filterLOVByLOVValueReport(String lovValue,List<SelectItem> selList) {
		List<SelectItem> selListReturn = new ArrayList<SelectItem>();
		
		
		SelectItem tmp0 = new SelectItem();
		tmp0.setLabel("-- Select --");
		tmp0.setValue(null);
		selListReturn.add(tmp0);
		
		if(selList!=null&&selList.size()>0){
			//System.out.println(" Size In :"+selList.size());
			for(SelectItem temptmp: selList){
				//System.out.println("lovValue : desc>> "+lovValue+":"+temptmp.getDescription());		
				String desc = temptmp.getDescription();
				boolean isMatch = false;
				if(desc!=null){
					StringTokenizer st = new StringTokenizer(desc, "|");
				       while (st.hasMoreElements()){
				    	   String stValue = (String)st.nextElement();
				    	   //System.out.println(" lovValue: st "+lovValue +":"+stValue);
							if(lovValue.equals(stValue)){							
								isMatch = true;
							}	
			        	}
				}else{
					//selListReturn.add(temptmp);
				}
				if(isMatch){
					selListReturn.add(temptmp);
					//System.out.println(" Match LOVCODE:LABEL>>"+temptmp.getValue()+":"+temptmp.getLabel());
				}
			
			}
			
			//System.out.println(" Size out :"+selListReturn.size());
		}
		return selListReturn;
	}
}
