package th.co.ais.web.el.action;

import org.apache.log4j.Logger;

import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.ManagementSP;



public class SEMMEL001Util {

	private static Logger log = Logger.getLogger(SEMMEL001Util.class);
	
	public static String DUMMY;
	
	public static String PROCESS_STATUS_100101;
	public static String PROCESS_STATUS_100102;
	public static String PROCESS_STATUS_100106;
	public static String PROCESS_STATUS_100201;
	public static String PROCESS_STATUS_100301;	
	public static String PROCESS_STATUS_100401;
	public static String PROCESS_STATUS_100402;
	public static String PROCESS_STATUS_200101;
	public static String PROCESS_STATUS_200102;
	public static String PROCESS_STATUS_200105;
	public static String PROCESS_STATUS_200201;
	public static String PROCESS_STATUS_200301;
	public static String PROCESS_STATUS_200401;
	public static String PROCESS_STATUS_200402;
	public static String PROCESS_STATUS_300101;
	public static String PROCESS_STATUS_300401;
	public static String PROCESS_STATUS_300601;
	public static String PROCESS_STATUS_300701;
	public static String PROCESS_STATUS_400101;
	
	public static String SITE_STATUS_NEW;
	public static String SITE_STATUS_TERMINATE;
	public static String SITE_STATUS_WAITING_FOR_TERMINATE;
	
	public static String ELECTRIC_TYPE_MEA;
	public static String ELECTRIC_TYPE_PEA;
	public static String ELECTRIC_TYPE_PRIVATE;
	public static String ELECTRIC_TYPE_OTHERSITE;
	public static String ELECTRIC_TYPE_MEA_PEA;
	public static String MEA = "MEA";
	public static String PEA = "PEA";
	public static String PRIVATE;
	
	public static String Y;
	public static String N;
	
	public static String EL_DEPOSIT_BG_TYPE;
	public static String EL_DEPOSIT_CASH_TYPE;
	public static String EL_DEPOSIT_MAIN_BG_TYPE;
	public static String EL_DEPOSIT_BG_CASH_TYPE;
	
	public static String CT_DEPOSIT_BG_TYPE;
	public static String CT_DEPOSIT_CASH_TYPE;
	
	public static String PERIOD_TYPE_PER_MONTH;
	public static String PERIOD_TYPE_PER_YEAR;
	
	public static String BG_STATUS_REQUEST_BG;
	
	public static String BG_TYPE_BG;
	public static String BG_TYPE_MAIN;
	
	public static String EXPENSE_TYPE_DEPOSIT;
	public static String PAYMENT_METHOD_TRANSFER;
	public static String PAYMENT_METHOD_CHQ;
	public static String PAYMENT_TYPE_U_CITY;
	
	public static String COMPANY_AIS;
	public static String COMPANY_FXL;
	public static String COMPANY_AWN;
	public static String COMPANY_DPC;
	public static String COMPANY_SBN;
	
	public static String WARRANT_TYPE_NEW;
	public static String WARRANT_TYPE_EXPAND;
	public static String WARRANT_TYPE_TRANSFER;
	public static String WARRANT_TYPE_RTRANSFER;
	public static String WARRANT_TYPE_TERMINATE;
	
	
	public static String NEW = "NEW";
	public static String EXPAND = "EXPAND";
	public static String TRANSFER = "TRANSFER";
	public static String RTRANSFER = "RTRANSFER";
	public static String TERMINATE = "TERMINATE";
	
	public static double VAT_RATE;
	
	public static String EL_PAYMENT_STATUS_01;
	
	public static String EL_EXPENSE_TYPE;
	
	public static String EL_METER_STATUS_OFF;
	public static String EL_METER_STATUS_ON;
	
	public static String ELECTRIC_STATUS_CLOSE;
	public static String EL_SITE_STATUS_TERMINATE;
	
	static{
		
		// mockup
		DUMMY = "DUMMY";
		ELECTRIC_TYPE_MEA = "MEA";
		ELECTRIC_TYPE_PEA = "PEA";
		ELECTRIC_TYPE_PRIVATE = "PRIVATE";
		ELECTRIC_TYPE_OTHERSITE = "OTHERSITE";
		ELECTRIC_TYPE_MEA_PEA = "MEA/PEA";
		
		PROCESS_STATUS_100101 = "100101";
		PROCESS_STATUS_100102 = "100102";
		PROCESS_STATUS_100106 = "100106";
		PROCESS_STATUS_100201 = "100201";
		PROCESS_STATUS_100301 = "100301";
		PROCESS_STATUS_100401 = "100401";
		PROCESS_STATUS_100402 = "100402";
		PROCESS_STATUS_200101 = "200101";
		PROCESS_STATUS_200102 = "200102";
		PROCESS_STATUS_200105 = "200105";
		PROCESS_STATUS_200201 = "200201";
		PROCESS_STATUS_200301 = "200301";
		PROCESS_STATUS_200401 = "200401";
		PROCESS_STATUS_200402 = "200402";
		PROCESS_STATUS_300101 = "300101";
		PROCESS_STATUS_300401 = "300401";
		PROCESS_STATUS_300601 = "300601";
		PROCESS_STATUS_300701 = "300701";
		PROCESS_STATUS_400101 = "400101";
		SITE_STATUS_NEW = "01";
		//WT###Comment 20101216SITE_STATUS_TERMINATE = "05";
		SITE_STATUS_TERMINATE = "04";
		//WT###Comment 20101216SITE_STATUS_WAITING_FOR_TERMINATE= "04";
		SITE_STATUS_WAITING_FOR_TERMINATE= "03";
		Y= "Y";
		N= "N";
		CT_DEPOSIT_BG_TYPE = "01";
		CT_DEPOSIT_CASH_TYPE = "02";
		EL_DEPOSIT_BG_TYPE = "BG";
		EL_DEPOSIT_CASH_TYPE = "Cash";
		EL_DEPOSIT_MAIN_BG_TYPE = "MAIN BG";
		EL_DEPOSIT_BG_CASH_TYPE = "BGCash";
		PERIOD_TYPE_PER_MONTH = "03";
		PERIOD_TYPE_PER_YEAR = "04";
		BG_STATUS_REQUEST_BG = "N";
		BG_TYPE_BG = "BG";
		BG_TYPE_MAIN = "MAIN";
		EXPENSE_TYPE_DEPOSIT = "DEPOSIT";
		COMPANY_AIS = "AIS";
		COMPANY_FXL = "FXL";
		COMPANY_AWN = "AWN";
		COMPANY_DPC = "DPC";
		COMPANY_SBN = "SBN";
		WARRANT_TYPE_NEW = "New";
		WARRANT_TYPE_EXPAND = "Expand";
		WARRANT_TYPE_TRANSFER = "Transfer";
		WARRANT_TYPE_RTRANSFER = "RTransfer";
		WARRANT_TYPE_TERMINATE = "Terminate";
		PAYMENT_METHOD_TRANSFER = "02";
		PAYMENT_METHOD_CHQ = "01";
		PAYMENT_TYPE_U_CITY = "05";
		VAT_RATE = 7.0;
		EL_PAYMENT_STATUS_01 = "01";
		EL_EXPENSE_TYPE = "DEPOSIT";
		EL_METER_STATUS_OFF = "OFF";
		EL_METER_STATUS_ON = "ON";
		ELECTRIC_STATUS_CLOSE = "Close";
		EL_SITE_STATUS_TERMINATE = "05";
	}
	
	// --- page 1 ---
	// verify receiveJobButton
	public static boolean verifyReceiveJobButtonVisible(Management manage){
		
		if(manage.getContractNo().equals(DUMMY)) return false;
		
		return verifyReceiveJobButtonVisibleMeaNew(manage) || verifyReceiveJobButtonVisiblePeaNew(manage)
				|| verifyReceiveJobButtonVisibleMeaTerminate(manage) || verifyReceiveJobButtonVisiblePeaTerminate(manage);
	}
	
	public static boolean verifyReceiveJobButtonVisible(ManagementSP manage){
		
		if(manage.getContractNo().equals(DUMMY)) return false;
		
		return verifyReceiveJobButtonVisibleMeaNew(manage) || verifyReceiveJobButtonVisiblePeaNew(manage)
				|| verifyReceiveJobButtonVisibleMeaTerminate(manage) || verifyReceiveJobButtonVisiblePeaTerminate(manage);
	}
	
	public static boolean verifyReceiveJobButtonVisibleMeaNew(Management manage){								
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.getProcessStatusCode().equals(PROCESS_STATUS_100101);
	}
	
	public static boolean verifyReceiveJobButtonVisibleMeaNew(ManagementSP manage){								
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.getProcessStatusCode().equals(PROCESS_STATUS_100101);
	}
	
	public static boolean verifyReceiveJobButtonVisiblePeaNew(Management manage){								
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.getProcessStatusCode().equals(PROCESS_STATUS_200101);
	}
	
	public static boolean verifyReceiveJobButtonVisiblePeaNew(ManagementSP manage){								
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.getProcessStatusCode().equals(PROCESS_STATUS_200101);
	}
	
	public static boolean verifyReceiveJobButtonVisibleMeaTerminate(Management manage){							
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) && manage.getSiteStatus().equals(SITE_STATUS_TERMINATE) && manage.getProcessStatusCode().equals(PROCESS_STATUS_100401);
	}
	
	public static boolean verifyReceiveJobButtonVisibleMeaTerminate(ManagementSP manage){							
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) && manage.getSiteStatus().equals(SITE_STATUS_TERMINATE) && manage.getProcessStatusCode().equals(PROCESS_STATUS_100401);
	}
	
	public static boolean verifyReceiveJobButtonVisiblePeaTerminate(Management manage){								
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PEA) && manage.getSiteStatus().equals(SITE_STATUS_TERMINATE) && manage.getProcessStatusCode().equals(PROCESS_STATUS_200401);
	}
	
	public static boolean verifyReceiveJobButtonVisiblePeaTerminate(ManagementSP manage){								
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PEA) && manage.getSiteStatus().equals(SITE_STATUS_TERMINATE) && manage.getProcessStatusCode().equals(PROCESS_STATUS_200401);
	}
	
	// verify verify button
	public static boolean verifyVerifyButtonVisible(Management manage){
		
		if(manage.getContractNo().equals(DUMMY)) return false;
		
		return verifyVerifyButtonVisibleMeaWaitTerminate(manage) || verifyVerifyButtonVisiblePeaWaitTerminate(manage)
				|| verifyVerifyButtonVisiblePrivateWaitTerminate(manage) || verifyVerifyButtonVisiblePrivateNew(manage)
				|| verifyVerifyButtonVisiblePrivateTerminate(manage);
	}
	
	public static boolean verifyVerifyButtonVisible(ManagementSP manage){
		
		if(manage.getContractNo().equals(DUMMY)) return false;
		
		return verifyVerifyButtonVisibleMeaWaitTerminate(manage) || verifyVerifyButtonVisiblePeaWaitTerminate(manage)
				|| verifyVerifyButtonVisiblePrivateWaitTerminate(manage) || verifyVerifyButtonVisiblePrivateNew(manage)
				|| verifyVerifyButtonVisiblePrivateTerminate(manage);
	}
	
	public static boolean verifyVerifyButtonVisibleMeaWaitTerminate(Management manage){
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) && manage.getSiteStatus().equals(SITE_STATUS_WAITING_FOR_TERMINATE);
	}
	
	public static boolean verifyVerifyButtonVisibleMeaWaitTerminate(ManagementSP manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) && manage.getSiteStatus().equals(SITE_STATUS_WAITING_FOR_TERMINATE);
	}
	
	public static boolean verifyVerifyButtonVisiblePeaWaitTerminate(Management manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PEA) && manage.getSiteStatus().equals(SITE_STATUS_WAITING_FOR_TERMINATE);
	}
	
	public static boolean verifyVerifyButtonVisiblePeaWaitTerminate(ManagementSP manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PEA) && manage.getSiteStatus().equals(SITE_STATUS_WAITING_FOR_TERMINATE);
	}
	
	public static boolean verifyVerifyButtonVisiblePrivateWaitTerminate(Management manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && manage.getSiteStatus().equals(SITE_STATUS_WAITING_FOR_TERMINATE);
	}
	
	public static boolean verifyVerifyButtonVisiblePrivateWaitTerminate(ManagementSP manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && manage.getSiteStatus().equals(SITE_STATUS_WAITING_FOR_TERMINATE);
	}	
	
	public static boolean verifyVerifyButtonVisiblePrivateNew(Management manage){
		
//		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.getProcessStatusCode().equals(PROCESS_STATUS_300101);
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && manage.getProcessStatusCode().equals(PROCESS_STATUS_300101);
	}
	
	public static boolean verifyVerifyButtonVisiblePrivateNew(ManagementSP manage){
		
//		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.getProcessStatusCode().equals(PROCESS_STATUS_300101);
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && manage.getProcessStatusCode().equals(PROCESS_STATUS_300101);
	}
	
	public static boolean verifyReVerifyButtonVisiblePrivateNew(Management manage){
		//System.out.println("xxxxxxxxxxxxx : verifyReVerifyButtonVisiblePrivateNew :xxxxxxxxxxxxxxxxxx");
		if(manage.getEditFlag()!= null && manage.getEditFlag().equalsIgnoreCase("Y") 
			 && manage.getElectricUseType().equalsIgnoreCase(ELECTRIC_TYPE_PRIVATE)  
			&&( !manage.getProcessStatusCode().equals(PROCESS_STATUS_300101) ||!manage.getProcessStatusCode().equals(PROCESS_STATUS_300701))){
			return true;
		}
		else{
			return false;	
		}
		
		 
	}
	
	public static boolean verifyReVerifyButtonVisiblePrivateNew(ManagementSP manage){
		if(manage.getEditFlag()!= null && manage.getEditFlag().equalsIgnoreCase("Y") 
			 && manage.getElectricUseType().equalsIgnoreCase(ELECTRIC_TYPE_PRIVATE)  
			&&( !manage.getProcessStatusCode().equals(PROCESS_STATUS_300101) ||!manage.getProcessStatusCode().equals(PROCESS_STATUS_300701))){
			return true;
		}
		else{
			return false;	
		}
		
		 
	}
	
	public static boolean verifyVerifyButtonVisiblePrivateChange(Management manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && manage.getProcessStatusCode().equals(PROCESS_STATUS_300601);
	}
	
	public static boolean verifyVerifyButtonVisiblePrivateChange(ManagementSP manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && manage.getProcessStatusCode().equals(PROCESS_STATUS_300601);
	}
	
	public static boolean verifyVerifyButtonVisiblePrivateRenew(Management manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && manage.getProcessStatusCode().equals(PROCESS_STATUS_300701);
	}
	
	public static boolean verifyVerifyButtonVisiblePrivateRenew(ManagementSP manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && manage.getProcessStatusCode().equals(PROCESS_STATUS_300701);
	}
	
	public static boolean verifyVerifyButtonVisiblePrivateTerminate(Management manage){
		
//		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && manage.getSiteStatus().equals(SITE_STATUS_TERMINATE) && manage.getProcessStatusCode().equals(PROCESS_STATUS_300401);
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && manage.getProcessStatusCode().equals(PROCESS_STATUS_300401);
	}
	
	public static boolean verifyVerifyButtonVisiblePrivateTerminate(ManagementSP manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && manage.getProcessStatusCode().equals(PROCESS_STATUS_300401);
	}
	
	// verify depositTypeLabelVisible
	public static boolean verifyDepositTypeLabelVisible(Management manage){
		
		if(manage.getContractNo().equals(DUMMY)) return false;
			
		boolean cond1_2_3_4 = (manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) || manage.getElectricUseType().equals(ELECTRIC_TYPE_PEA));
		boolean cond5 = manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE);
		
		return (cond1_2_3_4 || cond5) && !manage.isDepositFlagBoolean() && manage.getDepositType() != null;
	}
	
	public static boolean verifyDepositTypeLabelVisible(ManagementSP manage){
		
		if(manage.getContractNo().equals(DUMMY)) return false;
			
		boolean cond1_2_3_4 = (manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) || manage.getElectricUseType().equals(ELECTRIC_TYPE_PEA));
		boolean cond5 = manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE);
		
		return (cond1_2_3_4 || cond5) && !manage.isDepositFlagBoolean() && manage.getDepositType() != null;
	}

	// verify saveDepositButtonVisible
	public static boolean verifySaveDepositButtonVisible(Management manage){
		
		if(manage.getContractNo().equals(DUMMY)) return false;
		
		return verifySaveDepositButtonVisibleMea(manage) || verifySaveDepositButtonVisiblePea(manage) || verifySaveDepositButtonVisiblePrivate(manage);
	}
	
	public static boolean verifySaveDepositButtonVisible(ManagementSP manage){
		
		if(manage.getContractNo().equals(DUMMY)) return false;
		
		return verifySaveDepositButtonVisibleMea(manage) || verifySaveDepositButtonVisiblePea(manage) || verifySaveDepositButtonVisiblePrivate(manage);
	}
	
	public static boolean verifySaveDepositButtonVisibleMea(Management manage){
		
		//WT###Edit 20101217
		//return manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.isDepositFlagBoolean();
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW);
		//WT###Edit 20101217 End
	}
	
	public static boolean verifySaveDepositButtonVisibleMea(ManagementSP manage){
		
		//WT###Edit 20101217
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW);
		//WT###Edit 20101217 End
	}
	
	public static boolean verifySaveDepositButtonVisiblePea(Management manage){
		//System.out.println("MOMO: verifySaveDepositButtonVisiblePea ");	
		//System.out.println("MOMO: manage.getSiteStatus() "+manage.getSiteStatus());	
		//System.out.println("MOMO:  manage.isDepositFlagBoolean()() "+ manage.isDepositFlagBoolean());	
		//System.out.println("MOMO: verifySaveDepositButtonVisiblePea ");	
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.isDepositFlagBoolean();
	}
	
	public static boolean verifySaveDepositButtonVisiblePea(ManagementSP manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.isDepositFlagBoolean();
	}
	
	public static boolean verifySaveDepositButtonVisiblePrivate(Management manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.isDepositFlagBoolean();
	}
	
	public static boolean verifySaveDepositButtonVisiblePrivate(ManagementSP manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.isDepositFlagBoolean();
	}
	
	// verify print button
	public static boolean verifyPrintButton(Management manage){
		
		if(manage.getContractNo().equals(DUMMY) || (manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && !manage.isPrivateCaseFlagBoolean())) return false;
		
		return verifyPrintButtonVisibleCaseMeaNewSite(manage) || verifyPrintButtonVisibleCasePeaNewSite(manage)
				|| verifyPrintButtonVisibleCasePrivateNewSite(manage) || verifyPrintButtonVisibleCaseMeaExpandSite(manage)
				|| verifyPrintButtonVisibleCasePeaExpandSite(manage) || verifyPrintButtonVisibleCaseMeaTransferSite(manage)
				|| verifyPrintButtonVisibleCasePeaTransferSite(manage) || verifyPrintButtonVisibleCaseMeaTerminateSite(manage)
				|| verifyPrintButtonVisibleCasePeaTerminateSite(manage);
	}
	
	public static boolean verifyPrintButton(ManagementSP manage){
		
		if(manage.getContractNo().equals(DUMMY) || (manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && !manage.isPrivateCaseFlagBoolean())) return false;
		
		return verifyPrintButtonVisibleCaseMeaNewSite(manage) || verifyPrintButtonVisibleCasePeaNewSite(manage)
				|| verifyPrintButtonVisibleCasePrivateNewSite(manage) || verifyPrintButtonVisibleCaseMeaExpandSite(manage)
				|| verifyPrintButtonVisibleCasePeaExpandSite(manage) || verifyPrintButtonVisibleCaseMeaTransferSite(manage)
				|| verifyPrintButtonVisibleCasePeaTransferSite(manage) || verifyPrintButtonVisibleCaseMeaTerminateSite(manage)
				|| verifyPrintButtonVisibleCasePeaTerminateSite(manage);
	}
	
	public static boolean verifyPrintButtonVisibleCaseMeaNewSite(Management manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.getProcessStatusCode().equals(PROCESS_STATUS_100102);
	}
	
	public static boolean verifyPrintButtonVisibleCaseMeaNewSite(ManagementSP manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.getProcessStatusCode().equals(PROCESS_STATUS_100102);
	}
	
	public static boolean verifyPrintButtonVisibleCasePeaNewSite(Management manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.getProcessStatusCode().equals(PROCESS_STATUS_200102);
	}
	
	public static boolean verifyPrintButtonVisibleCasePeaNewSite(ManagementSP manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.getProcessStatusCode().equals(PROCESS_STATUS_200102);
	}
	
	public static boolean verifyPrintButtonVisibleCasePrivateNewSite(Management manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.getProcessStatusCode().equals(PROCESS_STATUS_400101);
	}
	
	public static boolean verifyPrintButtonVisibleCasePrivateNewSite(ManagementSP manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.getProcessStatusCode().equals(PROCESS_STATUS_400101);
	}
	
	public static boolean verifyPrintButtonVisibleCaseMeaExpandSite(Management manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.getProcessStatusCode().equals(PROCESS_STATUS_100201);
	}
	
	public static boolean verifyPrintButtonVisibleCaseMeaExpandSite(ManagementSP manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.getProcessStatusCode().equals(PROCESS_STATUS_100201);
	}
	
	public static boolean verifyPrintButtonVisibleCasePeaExpandSite(Management manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.getProcessStatusCode().equals(PROCESS_STATUS_200201);
	}
	
	public static boolean verifyPrintButtonVisibleCasePeaExpandSite(ManagementSP manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.getProcessStatusCode().equals(PROCESS_STATUS_200201);
	}
	
	public static boolean verifyPrintButtonVisibleCaseMeaTransferSite(Management manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.getProcessStatusCode().equals(PROCESS_STATUS_100301);
	}
	
	public static boolean verifyPrintButtonVisibleCaseMeaTransferSite(ManagementSP manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.getProcessStatusCode().equals(PROCESS_STATUS_100301);
	}
	
	public static boolean verifyPrintButtonVisibleCasePeaTransferSite(Management manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.getProcessStatusCode().equals(PROCESS_STATUS_200301);
	}
	
	public static boolean verifyPrintButtonVisibleCasePeaTransferSite(ManagementSP manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.getProcessStatusCode().equals(PROCESS_STATUS_200301);
	}
	
	public static boolean verifyPrintButtonVisibleCaseMeaTerminateSite(Management manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) && manage.getSiteStatus().equals(SITE_STATUS_TERMINATE) && manage.getProcessStatusCode().equals(PROCESS_STATUS_100402);
	}
	
	public static boolean verifyPrintButtonVisibleCaseMeaTerminateSite(ManagementSP manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) && manage.getSiteStatus().equals(SITE_STATUS_TERMINATE) && manage.getProcessStatusCode().equals(PROCESS_STATUS_100402);
	}
	
	public static boolean verifyPrintButtonVisibleCasePeaTerminateSite(Management manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PEA) && manage.getSiteStatus().equals(SITE_STATUS_TERMINATE) && manage.getProcessStatusCode().equals(PROCESS_STATUS_200402);
	}
	
	public static boolean verifyPrintButtonVisibleCasePeaTerminateSite(ManagementSP manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PEA) && manage.getSiteStatus().equals(SITE_STATUS_TERMINATE) && manage.getProcessStatusCode().equals(PROCESS_STATUS_200402);
	}

	// verify private case flag checkbox
	public static boolean verifyPrivateCaseFlagCheckBoxVisible(Management manage){
		
		if(manage.getContractNo().equals(DUMMY)) return false;
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.getProcessStatusCode().equals(PROCESS_STATUS_300101);
	}
	
	public static boolean verifyPrivateCaseFlagCheckBoxVisible(ManagementSP manage){
		
		if(manage.getContractNo().equals(DUMMY)) return false;
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.getProcessStatusCode().equals(PROCESS_STATUS_300101);
	}

	// verify update status button
	public static boolean verifyUpdateStatusButtonVisible(Management manage){
		
		if(manage.getContractNo().equals(DUMMY)) return false;
		
		return verifyUpdateStatusButtonVisibleMea(manage) || verifyUpdateStatusButtonVisiblePea(manage) || verifyUpdateStatusButtonVisiblePrivate(manage);
	}
	
	public static boolean verifyUpdateStatusButtonVisible(ManagementSP manage){
		
		if(manage.getContractNo().equals(DUMMY)) return false;
		
		return verifyUpdateStatusButtonVisibleMea(manage) || verifyUpdateStatusButtonVisiblePea(manage) || verifyUpdateStatusButtonVisiblePrivate(manage);
	}
	
	public static boolean verifyUpdateStatusButtonVisibleMea(Management manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) && manage.isPrint();
	}
	
	public static boolean verifyUpdateStatusButtonVisibleMea(ManagementSP manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) && manage.isPrint();
	}
	
	public static boolean verifyUpdateStatusButtonVisiblePea(Management manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PEA) && manage.isPrint();
	}
	
	public static boolean verifyUpdateStatusButtonVisiblePea(ManagementSP manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PEA) && manage.isPrint();
	}
	
	public static boolean verifyUpdateStatusButtonVisiblePrivate(Management manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && manage.isPrivateCaseFlagBoolean() && manage.isPrint();
	}
	
	public static boolean verifyUpdateStatusButtonVisiblePrivate(ManagementSP manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && manage.isPrivateCaseFlagBoolean() && manage.isPrint();
	}

	// verify expand flag checkbox
	public static boolean verifyExpandFlagCheckBoxVisible(Management manage){
		
		if(manage.getContractNo().equals(DUMMY)) return false;
		
		return verifyExpandFlagCheckBoxVisibleMea(manage) || verifyExpandFlagCheckBoxVisiblePea(manage);
	}
	
	public static boolean verifyExpandFlagCheckBoxVisible(ManagementSP manage){
		
		if(manage.getContractNo().equals(DUMMY)) return false;
		
		return verifyExpandFlagCheckBoxVisibleMea(manage) || verifyExpandFlagCheckBoxVisiblePea(manage);
	}
	
	public static boolean verifyExpandFlagCheckBoxVisibleMea(Management manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.getProcessStatusCode().equals(PROCESS_STATUS_100106);
	}
	
	public static boolean verifyExpandFlagCheckBoxVisibleMea(ManagementSP manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.getProcessStatusCode().equals(PROCESS_STATUS_100106);
	}
	
	public static boolean verifyExpandFlagCheckBoxVisiblePea(Management manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.getProcessStatusCode().equals(PROCESS_STATUS_200105);
	}
	
	public static boolean verifyExpandFlagCheckBoxVisiblePea(ManagementSP manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW) && manage.getProcessStatusCode().equals(PROCESS_STATUS_200105);
	}

	// verify withdrawal button
	public static boolean verifyWithdrawalButtonVisible(Management manage){
		
		return verifyWithdrawalButtonVisibleMea(manage) || verifyWithdrawalButtonVisiblePea(manage)
				|| verifyWithdrawalButtonVisiblePrivate(manage) || verifyWithdrawalButtonVisibleDummy(manage);
	}
	
	public static boolean verifyWithdrawalButtonVisible(ManagementSP manage){
		
		return verifyWithdrawalButtonVisibleMea(manage) || verifyWithdrawalButtonVisiblePea(manage)
				|| verifyWithdrawalButtonVisiblePrivate(manage) || verifyWithdrawalButtonVisibleDummy(manage);
	}
	
	public static boolean verifyWithdrawalButtonVisibleMea(Management manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW) 
				&& !manage.getProcessStatusCode().equals(PROCESS_STATUS_100101) && !manage.getProcessStatusCode().equals(PROCESS_STATUS_100102);
	}
	
	public static boolean verifyWithdrawalButtonVisibleMea(ManagementSP manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW) 
				&& !manage.getProcessStatusCode().equals(PROCESS_STATUS_100101) && !manage.getProcessStatusCode().equals(PROCESS_STATUS_100102);
	}
	
	public static boolean verifyWithdrawalButtonVisiblePea(Management manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW) 
				&& !manage.getProcessStatusCode().equals(PROCESS_STATUS_200101) && !manage.getProcessStatusCode().equals(PROCESS_STATUS_200102);
	}
	
	public static boolean verifyWithdrawalButtonVisiblePea(ManagementSP manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) && manage.getSiteStatus().equals(SITE_STATUS_NEW) 
				&& !manage.getProcessStatusCode().equals(PROCESS_STATUS_200101) && !manage.getProcessStatusCode().equals(PROCESS_STATUS_200102);
	}
	
	public static boolean verifyWithdrawalButtonVisiblePrivate(Management manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && manage.getSiteStatus().equals(SITE_STATUS_NEW) 
				&& !manage.getProcessStatusCode().equals(PROCESS_STATUS_400101) && manage.isPrivateCaseFlagBoolean();
	}
	
	public static boolean verifyWithdrawalButtonVisiblePrivate(ManagementSP manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && manage.getSiteStatus().equals(SITE_STATUS_NEW) 
				&& !manage.getProcessStatusCode().equals(PROCESS_STATUS_400101) && manage.isPrivateCaseFlagBoolean();
	}
	
	public static boolean verifyWithdrawalButtonVisibleDummy(Management manage){
		
		return manage.getContractNo().equals(DUMMY);
	}
	
	public static boolean verifyWithdrawalButtonVisibleDummy(ManagementSP manage){
		
		return manage.getContractNo().equals(DUMMY);
	}

	// verify update meter info button
	public static boolean verifyUpdateMeterInfoButton(Management manage){
		
		if(manage.getContractNo().equals(DUMMY) || !manage.getSiteStatus().equals(SITE_STATUS_NEW)) return false;
		
		return verifyUpdateMeterInfoButtonMea(manage) || verifyUpdateMeterInfoButtonPea(manage) || verifyUpdateMeterInfoButtonPrivate(manage);
	}
	
	public static boolean verifyUpdateMeterInfoButton(ManagementSP manage){
		
		if(manage.getContractNo().equals(DUMMY) || !manage.getSiteStatus().equals(SITE_STATUS_NEW)) return false;
		
		return verifyUpdateMeterInfoButtonMea(manage) || verifyUpdateMeterInfoButtonPea(manage) || verifyUpdateMeterInfoButtonPrivate(manage);
	}
	
	public static boolean verifyUpdateMeterInfoButtonMea(Management manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) && !manage.getProcessStatusCode().equals(PROCESS_STATUS_100101) && !manage.getProcessStatusCode().equals(PROCESS_STATUS_100102);
	}
	
	public static boolean verifyUpdateMeterInfoButtonMea(ManagementSP manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_MEA) && !manage.getProcessStatusCode().equals(PROCESS_STATUS_100101) && !manage.getProcessStatusCode().equals(PROCESS_STATUS_100102);
	}
	
	public static boolean verifyUpdateMeterInfoButtonPea(Management manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PEA) && !manage.getProcessStatusCode().equals(PROCESS_STATUS_200101) && !manage.getProcessStatusCode().equals(PROCESS_STATUS_200102);
	}
	
	public static boolean verifyUpdateMeterInfoButtonPea(ManagementSP manage){
		
		return manage.getElectricUseType().equals(ELECTRIC_TYPE_PEA) && !manage.getProcessStatusCode().equals(PROCESS_STATUS_200101) && !manage.getProcessStatusCode().equals(PROCESS_STATUS_200102);
	}
	
	public static boolean verifyUpdateMeterInfoButtonPrivate(Management manage){
		
		boolean cond1 = manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && manage.isPrivateCaseFlagBoolean() && !manage.getProcessStatusCode().equals(PROCESS_STATUS_400101);
		boolean cond2 = manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && !manage.isPrivateCaseFlagBoolean() && !manage.getProcessStatusCode().equals(PROCESS_STATUS_300101);
		
		return  cond1 || cond2;
	}
	
	public static boolean verifyUpdateMeterInfoButtonPrivate(ManagementSP manage){
		
		boolean cond1 = manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && manage.isPrivateCaseFlagBoolean() && !manage.getProcessStatusCode().equals(PROCESS_STATUS_400101);
		boolean cond2 = manage.getElectricUseType().equals(ELECTRIC_TYPE_PRIVATE) && !manage.isPrivateCaseFlagBoolean() && !manage.getProcessStatusCode().equals(PROCESS_STATUS_300101);
		
		return  cond1 || cond2;
	}

	// --- page 2 ---
	// verify transfer flag checkbox 
	public static boolean verifyTransferFlagCheckbox(Management manage){
		
		return manage.getSiteStatus().equals(SITE_STATUS_NEW);
	}
	
	public static boolean verifyTransferFlagCheckbox(ManagementSP manage){
		
		return manage.getSiteStatus().equals(SITE_STATUS_NEW);
	}
	
	// verify new received date calendar
	public static boolean verifyNewReceivedDtCalendar(Management manage){
		
		return manage.getSiteStatus().equals(SITE_STATUS_NEW);
	}
	public static boolean verifyNewReceivedDtCalendar(ManagementSP manage){
		
		return manage.getSiteStatus().equals(SITE_STATUS_NEW);
	}
	
	// verify terminate received date calendar
	public static boolean verifyTerminateReceivedDtCalendar(Management manage){
		
		return manage.getSiteStatus().equals(SITE_STATUS_TERMINATE);
	}
	public static boolean verifyTerminateReceivedDtCalendar(ManagementSP manage){
		
		return manage.getSiteStatus().equals(SITE_STATUS_TERMINATE);
	}
	
	// --- page 4 ---
	// verify transfer meter date calendar
	public static boolean verifyTransferMeterDtCalendar(ManagementSP manage){
		
		return manage.getSiteStatus().equals(SITE_STATUS_NEW);
	}
	
	public static boolean verifyTransferMeterDtCalendar(Management manage){
		
		return manage.getSiteStatus().equals(SITE_STATUS_NEW);
	}
	
	// verify p pay period type per month radio
	public static boolean verifyPPayPeriodTypePerMonth(Management manage){
		
		return manage.getpPayPeriodType() != null && manage.getpPayPeriodType().equals(PERIOD_TYPE_PER_MONTH);
	}
	
	public static boolean verifyPPayPeriodTypePerMonth(ManagementSP manage){
		
		return manage.getpPayPeriodType() != null && manage.getpPayPeriodType().equals(PERIOD_TYPE_PER_MONTH);
	}
	
	// verify p pay period type per year radio
	public static boolean verifyPPayPeriodTypePerYear(Management manage){
		
		return manage.getpPayPeriodType() != null && manage.getpPayPeriodType().equals(PERIOD_TYPE_PER_YEAR);
	}
	
	public static boolean verifyPPayPeriodTypePerYear(ManagementSP manage){
		
		return manage.getpPayPeriodType() != null && manage.getpPayPeriodType().equals(PERIOD_TYPE_PER_YEAR);
	}
}
