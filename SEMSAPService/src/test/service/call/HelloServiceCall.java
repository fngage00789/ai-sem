package test.service.call;

import javax.xml.rpc.Call;

import th.co.ais.domain.mm.Mmm001VendorSP;
import th.co.ais.http.EngineUtilities;
import th.co.ais.resource.utilities.Utilities;
import th.co.ais.webservice.getven.SI_Z_FIAP_SEM_GET_VEN;
import th.co.ais.webservice.getven.SI_Z_FIAP_SEM_GET_VENServiceLocator;
import th.co.ais.webservice.getven.bean.Z_FIAP_SEM_GET_VEN;
import th.co.ais.webservice.getven.bean.Z_FIAP_SEM_GET_VENResponse;
import th.co.ais.webservice.masterbank.SI_Z_FIAP_SEM_MASTERBANK;
import th.co.ais.webservice.masterbank.SI_Z_FIAP_SEM_MASTERBANKServiceLocator;
import th.co.ais.webservice.masterbank.bean.BAPI1011_ADDRESS;
import th.co.ais.webservice.masterbank.bean.BAPI1011_DETAIL;
import th.co.ais.webservice.masterbank.bean.ZSEM_MASTER_BANK_MSG;
import th.co.ais.webservice.masterbank.bean.Z_FIAP_SEM_MASTERBANK;




public class HelloServiceCall {
	
//	private static String _user = Utilities.getResources("WS_USERNAME");
//	private static String _pass = Utilities.getResources("WS_PASSWORD");
	private static String _user = Utilities.getResources("ws_sap_user");
	private static String _pass = Utilities.getResources("ws_sap_pw");

	
	
	static String _endpoint_ADDVENBANK = "https://pidev.itas.co.th:443/XISOAPAdapter/MessageServlet?senderParty=&senderService=BS_SEM&receiverParty=&receiverService=&interface=SI_Z_FIAP_SEM_ADDVENBANK&interfaceNamespace=urn%3Aais.co.th%3AFI%3ASEM%3AZ_FIAP_SEM_ADDVENBANK";	// look up SI_Z_FIAP_SEM_ADDVENBANKServiceLocator
	static String _endpoint_CHGVENBANK = "https://pidev.itas.co.th:443/XISOAPAdapter/MessageServlet?senderParty=&senderService=BS_SEM&receiverParty=&receiverService=&interface=SI_Z_FIAP_SEM_CHGVENBANK&interfaceNamespace=urn%3Aais.co.th%3AFI%3ASEM%3AZ_FIAP_SEM_CHGVENBANK";	// look up SI_Z_FIAP_SEM_CHGVENBANKServiceLocator
	static String _endpoint_CRE_VEN = "https://pidev.itas.co.th:443/XISOAPAdapter/MessageServlet?senderParty=&senderService=BS_SEM&receiverParty=&receiverService=&interface=SI_Z_FIAP_SEM_CRE_VEN&interfaceNamespace=urn%3Aais.co.th%3AFI%3ASEM%3AZ_FIAP_SEM_CRE_VEN";				// look up SI_Z_FIAP_SEM_CRE_VENServiceLocator
	static String _endpoint_DELVENBANK = "https://pidev.itas.co.th:443/XISOAPAdapter/MessageServlet?senderParty=&senderService=BS_SEM&receiverParty=&receiverService=&interface=SI_Z_FIAP_SEM_DELVENBANK&interfaceNamespace=urn%3Aais.co.th%3AFI%3ASEM%3AZ_FIAP_SEM_DELVENBANK";	// look up SI_Z_FIAP_SEM_DELVENBANKServiceLocator 
	static String _endpoint_GETVENBANK = "https://pidev.itas.co.th:443/XISOAPAdapter/MessageServlet?senderParty=&senderService=BS_SEM&receiverParty=&receiverService=&interface=SI_Z_FIAP_SEM_GETVENBANK&interfaceNamespace=urn%3Aais.co.th%3AFI%3ASEM%3AZ_FIAP_SEM_GETVENBANK";	// look up SI_Z_FIAP_SEM_GETVENBANKServiceLocator
	
	//static String _endpoint_MASTERBANK = "https://pidev.itas.co.th:443/XISOAPAdapter/MessageServlet?senderParty=&senderService=BS_SEM&receiverParty=&receiverService=&interface=SI_Z_FIAP_SEM_MASTERBANK&interfaceNamespace=urn%3Aais.co.th%3AFI%3ASEM%3AZ_FIAP_SEM_MASTERBANK";	// look up SI_Z_FIAP_SEM_MASTERBANKServiceLocator
	//static String _endpoint_MASTERBANK = "https://pidev.itas.co.th:443/XISOAPAdapter/MessageServlet?senderParty=&senderService=BS_SEM&receiverParty=&receiverService=&interface=SI_Z_FIAP_SEM_MASTERBANK&interfaceNamespace=urn:ais.co.th:FI:SEM:Z_FIAP_SEM_MASTERBANK";
	//static String _endpoint_GET_VEN = "https://pidev.itas.co.th:443/XISOAPAdapter/MessageServlet?senderParty=&senderService=BS_SEM&receiverParty=&receiverService=&interface=SI_Z_FIAP_SEM_GET_VEN&interfaceNamespace=urn:ais.co.th:FI:SEM:Z_FIAP_SEM_GET_VEN";
	
	public static void main(String[] args) throws Exception {
		
		new EngineUtilities();
		System.out.println(" Start Test Call Webservice !!! ");
		testCall_GETVEN();
		//testCall_GETVENBANK();
		
//		testCall_ADDVENBANK();
//		testCall_CHGVENBANK();
//		testCall_CRE_VEN();
//		testCall_DELVENBANK();
//		testCall_MASTERBANK();
	}
	
	static public void testCall_GETVEN(){
		
		try{
			SI_Z_FIAP_SEM_GET_VENServiceLocator locator = new SI_Z_FIAP_SEM_GET_VENServiceLocator(EngineUtilities.getEngineConfiguration());
			SI_Z_FIAP_SEM_GET_VEN service = locator.getHTTPS_Port();
			
			// to use Basic HTTP Authentication:
			((javax.xml.rpc.Stub) service)._setProperty(Call.USERNAME_PROPERTY, _user);
			((javax.xml.rpc.Stub) service)._setProperty(Call.PASSWORD_PROPERTY, _pass);

			//((javax.xml.rpc.Stub) service)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint_GET_VEN);
			((javax.xml.rpc.Stub) service)._setProperty("javax.xml.rpc.service.endpoint.address", locator.getHTTPS_PortAddress());
			
			Z_FIAP_SEM_GET_VEN params = new Z_FIAP_SEM_GET_VEN();
			params.setBRANCH("");	
			params.setBUKRS("1100");	
			params.setLIFNR("6100010005");	
			params.setROLE("RNT0200");		
			params.setROLETYPE("M");	
			params.setSTCD3("");
			
//			System.out.println("GET VEN RESP >>> " + service.SI_Z_FIAP_SEM_GET_VEN(params));
			
			Z_FIAP_SEM_GET_VENResponse resp = service.SI_Z_FIAP_SEM_GET_VEN(params);
			System.out.println("GET_VEN RESP >>> " + resp.toString());
			System.out.println("resp.getE_RETURNCODE() : "+resp.getE_RETURNCODE());
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			if(resp.getE_RETURNCODE().equalsIgnoreCase("S")){
				Mmm001VendorSP tmpVedorObj = new Mmm001VendorSP();
				
				// G_TAX
				if(resp.getC_WTAX().length > 0){
					tmpVedorObj.setWhtType(resp.getC_WTAX()[0].getWITHT());
					tmpVedorObj.setWhtCode(resp.getC_WTAX()[0].getWT_WITHCD());
					tmpVedorObj.setRecipientType(resp.getC_WTAX()[0].getQSREC());
					
					System.out.println("resp.getC_WTAX()[0].getWITHT() : "+resp.getC_WTAX()[0].getWITHT());
					System.out.println("resp.getC_WTAX()[0].getWT_WITHCD() : "+resp.getC_WTAX()[0].getWT_WITHCD());
					System.out.println("resp.getC_WTAX()[0].getQSREC() : "+resp.getC_WTAX()[0].getQSREC());
				}
				
				// C_VENDOR
				if(resp.getC_VENDOR().length > 0){
					tmpVedorObj.setHqFlag(resp.getC_VENDOR()[0].getLNRZE());
					tmpVedorObj.setRole(resp.getC_VENDOR()[0].getROLE());
					tmpVedorObj.setVendorBlockStatus(resp.getC_VENDOR()[0].getZAHLS());
					
					System.out.println("resp.getC_VENDOR()[0].getLNRZE() : "+resp.getC_VENDOR()[0].getLNRZE());
					System.out.println("resp.getC_VENDOR()[0].getROLE() : "+resp.getC_VENDOR()[0].getROLE());
					System.out.println("resp.getC_VENDOR()[0].getZAHLS() : "+resp.getC_VENDOR()[0].getZAHLS());
				}
				
				// G_PROFILE
				int gProLngth = resp.getG_PROFILE().length;
				if(gProLngth > 0){
					int row = 1;
					for(th.co.ais.webservice.getven.bean.ZGPROFILE obj : resp.getG_PROFILE()){
						Mmm001VendorSP vedorObj = new Mmm001VendorSP();
						
						vedorObj.setRowId(Integer.toString(row));
						//vedorObj.setVendorId(itemParams.getVendorId());	//
						vedorObj.setVendorCode(obj.getLIFNR());
						vedorObj.setVendorName(obj.getNAME1());
						vedorObj.setVendorName1(obj.getNAME1());
						vedorObj.setVendorName2(obj.getNAME2());
						vedorObj.setVendorName3(obj.getNAME3());
						vedorObj.setVendorName4(obj.getNAME4());
						vedorObj.setTitleName(obj.getTITLE_NAME());
						vedorObj.setIdCard(obj.getSTCD3());
						vedorObj.setAddress(obj.getSTRAS());
						vedorObj.setAddress1(obj.getSTRAS());
						vedorObj.setAddress2(obj.getSTR_SUPPL1());
						vedorObj.setAddress3(obj.getSTR_SUPPL2());
						vedorObj.setAddress4(obj.getSTR_SUPPL3());
						vedorObj.setTambol(obj.getORT02());
						vedorObj.setTambolName(obj.getORT02());
						vedorObj.setAmphur(obj.getORT01());
						vedorObj.setAmphurName(obj.getORT01());
						vedorObj.setProvince(obj.getLAND1());
						vedorObj.setProvinceName(obj.getLAND1());
						vedorObj.setPostCode(obj.getPSTLZ());
						vedorObj.setRegion(obj.getREGIO());
						vedorObj.setRegionName(obj.getREGIO());
						vedorObj.setTaxId(obj.getSTCD3());
						vedorObj.setVendorType(obj.getSTKZN());
						vedorObj.setNotPayeeFlag(obj.getXZEMP());
						
						//vedorObj.setExpenseType("");
						vedorObj.setVendorBlockStatus(tmpVedorObj.getVendorBlockStatus());
						vedorObj.setVendorStatus("");
//						vedorObj.setCompany(itemParams.getCompany());
						vedorObj.setHqFlag(tmpVedorObj.getHqFlag());
						vedorObj.setWhtType(tmpVedorObj.getWhtType());
						vedorObj.setWhtCode(tmpVedorObj.getWhtCode());
						vedorObj.setRecipientType(tmpVedorObj.getRecipientType());
						vedorObj.setRole(tmpVedorObj.getRole());
						
						
						vedorObj.setSapReturnCode(resp.getE_RETURNCODE());
						
//						vendorResultList.add(vedorObj);
						row++;
					}
				}
			} else {
				Mmm001VendorSP vedorObj = new Mmm001VendorSP();
				vedorObj.setSapReturnCode(resp.getE_RETURNCODE());
				System.out.println("resp.getE_RETURNCODE() : "+resp.getE_RETURNCODE());
//				vendorResultList.add(vedorObj);
			}
			
			System.out.println("=================================================================");
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("Error testCall_GETVEN : "+e);
		}
	}
	
	static public void testCall_ADDVENBANK(){
		
		try{
			
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	static public void testCall_CHGVENBANK(){
		
		try{
			
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	static public void testCall_CRE_VEN(){
	
		try{
			
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	static public void testCall_DELVENBANK(){
		
		try{
			
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	static public void testCall_GETVENBANK(){
		
		try{
			/*
			SI_Z_FIAP_SEM_GETVENBANKServiceLocator locator = new SI_Z_FIAP_SEM_GETVENBANKServiceLocator(EngineUtilities.getEngineConfiguration());
			SI_Z_FIAP_SEM_GETVENBANK service = locator.getHTTPS_Port();

			// to use Basic HTTP Authentication:
			((javax.xml.rpc.Stub) service)._setProperty(Call.USERNAME_PROPERTY, _user);
			((javax.xml.rpc.Stub) service)._setProperty(Call.PASSWORD_PROPERTY, _pass);

			((javax.xml.rpc.Stub) service)._setProperty("javax.xml.rpc.service.endpoint.address", locator.getHTTPS_PortAddress());

			
			Z_FIAP_SEM_GETVENBANK params = new Z_FIAP_SEM_GETVENBANK();
			params.setI_ACCOUNT("6100010415");
			params.setI_KOART("K");
			params.setI_XTECH_ACCNO("");
			
			System.out.println("GETVENBANK RESP >>> " + service.SI_Z_FIAP_SEM_GETVENBANK(params).toString());
			*/
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	static public void testCall_MASTERBANK(){
		
		try{
			
			SI_Z_FIAP_SEM_MASTERBANKServiceLocator locator = new SI_Z_FIAP_SEM_MASTERBANKServiceLocator(EngineUtilities.getEngineConfiguration());
			SI_Z_FIAP_SEM_MASTERBANK service = locator.getHTTPS_Port();

			// to use Basic HTTP Authentication:
			((javax.xml.rpc.Stub) service)._setProperty(Call.USERNAME_PROPERTY, _user);
			((javax.xml.rpc.Stub) service)._setProperty(Call.PASSWORD_PROPERTY, _pass);

			//((javax.xml.rpc.Stub) service)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint_MASTERBANK);
			((javax.xml.rpc.Stub) service)._setProperty("javax.xml.rpc.service.endpoint.address", locator.getHTTPS_PortAddress());

			
			BAPI1011_ADDRESS[] bankAddr = new BAPI1011_ADDRESS[0];
			BAPI1011_DETAIL[] bankDtl = new BAPI1011_DETAIL[0];
			ZSEM_MASTER_BANK_MSG[] bankMsg = new ZSEM_MASTER_BANK_MSG[0];
			Z_FIAP_SEM_MASTERBANK params = new Z_FIAP_SEM_MASTERBANK();
			
			params.setBANKCOUNTRY("TH");
			params.setBANKKEY("0650661");
			params.setBANK_ADDRESS(bankAddr);
			params.setBANK_DETAIL(bankDtl);
			params.setT_MESSAGES(bankMsg);
			
			System.out.println("MASTERBANK RESP >>> " + service.SI_Z_FIAP_SEM_MASTERBANK(params).toString());
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	

}
