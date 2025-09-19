package sap.client.service.call;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.Call;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

import th.co.ais.domain.gm.ApproveBookBankAct;
import th.co.ais.domain.gm.ApproveBookBankSP;
import th.co.ais.domain.mm.ItemParamsSP;
import th.co.ais.domain.mm.ItemResultSP;
import th.co.ais.domain.mm.Mmm001BookbankSP;
import th.co.ais.domain.mm.Mmm001SAPBookbankSP;
import th.co.ais.domain.mm.Mmm001SAPVendorSP;
import th.co.ais.domain.mm.Mmm001VendorSP;
import th.co.ais.domain.mm.MmmVendorMasterInfoSP;
import th.co.ais.domain.rt.Mrt010IfrsInterface;
import th.co.ais.http.EngineUtilities;
import th.co.ais.resource.utilities.Utilities;
import th.co.ais.service.rt.IRentalMasterService;
import th.co.ais.util.SAPUtility;
import th.co.ais.webservice.addvenbank.SI_Z_FIAP_SEM_ADDVENBANK;
import th.co.ais.webservice.addvenbank.SI_Z_FIAP_SEM_ADDVENBANKServiceLocator;
import th.co.ais.webservice.addvenbank.bean.Z_FIAP_SEM_ADDVENBANK;
import th.co.ais.webservice.addvenbank.bean.Z_FIAP_SEM_ADDVENBANKResponse;
import th.co.ais.webservice.blkunblkven.SI_Z_FIAP_SEM_BLKUNBLKVEN;
import th.co.ais.webservice.blkunblkven.SI_Z_FIAP_SEM_BLKUNBLKVENServiceLocator;
import th.co.ais.webservice.blkunblkven.bean.Z_FIAP_SEM_BLKUNBLKVEN;
import th.co.ais.webservice.blkunblkven.bean.Z_FIAP_SEM_BLKUNBLKVENResponse;
import th.co.ais.webservice.chgven.SI_Z_FIAP_SEM_CHG_VEN;
import th.co.ais.webservice.chgven.SI_Z_FIAP_SEM_CHG_VENServiceLocator;
import th.co.ais.webservice.chgven.bean.Z_FIAP_SEM_CHG_VEN;
import th.co.ais.webservice.chgven.bean.Z_FIAP_SEM_CHG_VENResponse;
import th.co.ais.webservice.chgvenbank.SI_Z_FIAP_SEM_CHGVENBANK;
import th.co.ais.webservice.chgvenbank.SI_Z_FIAP_SEM_CHGVENBANKServiceLocator;
import th.co.ais.webservice.chgvenbank.bean.Z_FIAP_SEM_CHGVENBANK;
import th.co.ais.webservice.chgvenbank.bean.Z_FIAP_SEM_CHGVENBANKResponse;
import th.co.ais.webservice.creven.SI_Z_FIAP_SEM_CRE_VEN;
import th.co.ais.webservice.creven.SI_Z_FIAP_SEM_CRE_VENServiceLocator;
import th.co.ais.webservice.creven.bean.Z_FIAP_SEM_CRE_VEN;
import th.co.ais.webservice.creven.bean.Z_FIAP_SEM_CRE_VENResponse;
import th.co.ais.webservice.delvenbank.SI_Z_FIAP_SEM_DELVENBANK;
import th.co.ais.webservice.delvenbank.SI_Z_FIAP_SEM_DELVENBANKServiceLocator;
import th.co.ais.webservice.delvenbank.bean.Z_FIAP_SEM_DELVENBANK;
import th.co.ais.webservice.delvenbank.bean.Z_FIAP_SEM_DELVENBANKResponse;
import th.co.ais.webservice.getven.SI_Z_FIAP_SEM_GET_VEN;
import th.co.ais.webservice.getven.SI_Z_FIAP_SEM_GET_VENServiceLocator;
import th.co.ais.webservice.getven.bean.Z_FIAP_SEM_GET_VEN;
import th.co.ais.webservice.getven.bean.Z_FIAP_SEM_GET_VENResponse;
import th.co.ais.webservice.getvenbank.SI_Z_FIAP_SEM_GETVENBANK;
import th.co.ais.webservice.getvenbank.SI_Z_FIAP_SEM_GETVENBANKServiceLocator;
import th.co.ais.webservice.getvenbank.bean.Z_FIAP_SEM_GETVENBANK;
import th.co.ais.webservice.getvenbank.bean.Z_FIAP_SEM_GETVENBANKResponse;
import th.co.ais.webservice.ifrs.changesem.SI_OB_Z_RE_IF_SEM_CHANGE;
import th.co.ais.webservice.ifrs.changesem.SI_OB_Z_RE_IF_SEM_CHANGEServiceLocator;
import th.co.ais.webservice.ifrs.changesem.bean.ZREIF_S_SEM_CHANGERESPONSE;
import th.co.ais.webservice.ifrs.changesem.bean.ZREIF_S_SEM_CONTRACT_CHANGE_IN;
import th.co.ais.webservice.ifrs.changesem.bean.Z_RE_IF_SEM_CHANGE;
import th.co.ais.webservice.ifrs.changesem.bean.Z_RE_IF_SEM_CHANGEResponse;
import th.co.ais.webservice.ifrs.cresem.SI_OB_Z_RE_IF_SEM_CREATE;
import th.co.ais.webservice.ifrs.cresem.SI_OB_Z_RE_IF_SEM_CREATEServiceLocator;
import th.co.ais.webservice.ifrs.cresem.bean.ZREIF_S_CONTRACTRESPONSE;
import th.co.ais.webservice.ifrs.cresem.bean.ZREIF_S_CONTRACTTEMPLATE_INTER;
import th.co.ais.webservice.ifrs.cresem.bean.Z_RE_IF_SEM_CREATE;
import th.co.ais.webservice.ifrs.cresem.bean.Z_RE_IF_SEM_CREATEResponse;
import th.co.ais.webservice.masterbank.SI_Z_FIAP_SEM_MASTERBANK;
import th.co.ais.webservice.masterbank.SI_Z_FIAP_SEM_MASTERBANKServiceLocator;
import th.co.ais.webservice.masterbank.bean.ZSEM_MASTER_BANK_MSG;
import th.co.ais.webservice.masterbank.bean.Z_FIAP_SEM_MASTERBANK;
import th.co.ais.webservice.masterbank.bean.Z_FIAP_SEM_MASTERBANKResponse;

public class WsClientService {

	public WsClientService() {
		new EngineUtilities();
	}

//	private static String _user = Utilities.getResources("WS_USERNAME");
//	private static String _pass = Utilities.getResources("WS_PASSWORD");
	private static String _user = Utilities.getResources("ws_sap_user");
	private static String _pass = Utilities.getResources("ws_sap_pw");
	//private static String _user_ifrs = Utilities.getResources("WS_IFRS_USERNAME");
	//private static String _pass_ifrs = Utilities.getResources("WS_IFRS_PASSWORD");
	/*private static String _endpoint_create = Utilities.getResources("WS_ENDPOINT_IFRS_CREATE");
	private static String _endpoint_change = Utilities.getResources("WS_ENDPOINT_IFRS_CHANGE");*/
	public boolean flagChange = true;
	private static final Log LOG = LogFactory.getLog(WsClientService.class);

	// private static String _user = SAPUtility.ws_sap_user;
	// private static String _pass = SAPUtility.ws_sap_pw;

	/*
	 * public static void main(String[] args) throws Exception { WsClientService
	 * service = new WsClientService(); ItemParamsSP objParams = new
	 * ItemParamsSP();
	 * 
	 * //service.addVenBank(objParams); //service.blkUnBlkVen(objParams);
	 * //service.chgVen(objParams); //service.chgVenBank(objParams);
	 * //service.creven(objParams); //service.delvenbank(objParams);
	 * //service.getven(objParams); //service.getvenbank(objParams);
	 * //service.masterBank(objParams); }
	 */


	public ItemResultSP addVenBank(ItemParamsSP itemParams) {

		ItemResultSP itemRetObj = new ItemResultSP();

		try {

			SI_Z_FIAP_SEM_ADDVENBANKServiceLocator locator = new SI_Z_FIAP_SEM_ADDVENBANKServiceLocator(EngineUtilities
					.getEngineConfiguration());
			SI_Z_FIAP_SEM_ADDVENBANK service = locator.getHTTPS_Port();

			// to use Basic HTTP Authentication:
			((javax.xml.rpc.Stub) service)._setProperty(Call.USERNAME_PROPERTY, _user);
			((javax.xml.rpc.Stub) service)._setProperty(Call.PASSWORD_PROPERTY, _pass);

			((javax.xml.rpc.Stub) service)._setProperty("javax.xml.rpc.service.endpoint.address", locator
					.getHTTPS_PortAddress());

			// parameter --
			th.co.ais.webservice.addvenbank.bean.ZSEM_BANKDATA_STRUC[] bankDataStruc = new th.co.ais.webservice.addvenbank.bean.ZSEM_BANKDATA_STRUC[0];
			th.co.ais.webservice.addvenbank.bean.ZSEM_MESSAGES_STRUC[] msgStruc = new th.co.ais.webservice.addvenbank.bean.ZSEM_MESSAGES_STRUC[0];
			Z_FIAP_SEM_ADDVENBANK params = new Z_FIAP_SEM_ADDVENBANK();

			params.setCHECKMODUS("M");
			params.setCONFIRM_CHANGES("X");
			params.setKOART("K");
			params.setI_BANKDATA(bankDataStruc);
			params.setT_MESSAGES(msgStruc);

			// response --
			Z_FIAP_SEM_ADDVENBANKResponse resp = service.SI_Z_FIAP_SEM_ADDVENBANK(params);
			System.out.println("ADDVENBANK RESP >>> " + resp.toString());

			// TODO something
			/*
			 * 
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemRetObj;
	}

	public ItemResultSP blkUnBlkVen(ItemParamsSP itemParams) {

		ItemResultSP itemRetObj = new ItemResultSP();

		try {

			SI_Z_FIAP_SEM_BLKUNBLKVENServiceLocator locator = new SI_Z_FIAP_SEM_BLKUNBLKVENServiceLocator(
					EngineUtilities.getEngineConfiguration());
			SI_Z_FIAP_SEM_BLKUNBLKVEN service = locator.getHTTPS_Port();

			// to use Basic HTTP Authentication:
			((javax.xml.rpc.Stub) service)._setProperty(Call.USERNAME_PROPERTY, _user);
			((javax.xml.rpc.Stub) service)._setProperty(Call.PASSWORD_PROPERTY, _pass);

			((javax.xml.rpc.Stub) service)._setProperty("javax.xml.rpc.service.endpoint.address", locator
					.getHTTPS_PortAddress());

			// parameter --
			th.co.ais.webservice.blkunblkven.bean.EBPP_MESSAGES[] messages = new th.co.ais.webservice.blkunblkven.bean.EBPP_MESSAGES[0];
			Z_FIAP_SEM_BLKUNBLKVEN params = new Z_FIAP_SEM_BLKUNBLKVEN();

			params.setBRANCH("00000");
			params.setBUKRS("1100");
			params.setLIFNR("6100009483");
			params.setLOEVM("X");
			params.setROLE("RNT0200");
			params.setROLETYPE("M");
			params.setSPERR("X");
			params.setSTCD3("0315535000024");
			params.setT_MESSAGES(messages);

			// response --
			Z_FIAP_SEM_BLKUNBLKVENResponse resp = service.SI_Z_FIAP_SEM_BLKUNBLKVEN(params);
			System.out.println("BLKUNBLKVEN RESP >>> " + resp.toString());

			// TODO something
			/*
			 * 
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemRetObj;
	}

	public ItemResultSP chgVen(ItemParamsSP itemParams) {

		ItemResultSP itemRetObj = new ItemResultSP();

		try {

			SI_Z_FIAP_SEM_CHG_VENServiceLocator locator = new SI_Z_FIAP_SEM_CHG_VENServiceLocator(EngineUtilities
					.getEngineConfiguration());
			SI_Z_FIAP_SEM_CHG_VEN service = locator.getHTTPS_Port();

			// to use Basic HTTP Authentication:
			((javax.xml.rpc.Stub) service)._setProperty(Call.USERNAME_PROPERTY, _user);
			((javax.xml.rpc.Stub) service)._setProperty(Call.PASSWORD_PROPERTY, _pass);

			((javax.xml.rpc.Stub) service)._setProperty("javax.xml.rpc.service.endpoint.address", locator
					.getHTTPS_PortAddress());

			// parameter --
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_COMP_STRUC compStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_COMP_STRUC();
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_COMPX_STRUC compxStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_COMPX_STRUC();
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_WTAX_STRUC[] wtxStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_WTAX_STRUC[0];
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_WTAXX_STRUC[] wtxxStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_WTAXX_STRUC[0];
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_EMAIL_STRUC[] emailStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_EMAIL_STRUC[0];
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_EMAILX_STRUC[] emailxStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_EMAILX_STRUC[0];
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_FAX_STRUC[] faxStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_FAX_STRUC[0];
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_FAXX_STRUC[] faxxStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_FAXX_STRUC[0];
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_MOBILE_STRUC[] mobileStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_MOBILE_STRUC[0];
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_MOBIX_STRUC[] mobixStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_MOBIX_STRUC[0];
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_PRF_STRUC prfStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_PRF_STRUC();
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_PRFX_STRUC prfxStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_PRFX_STRUC();
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_TELE_STRUC[] teleStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_TELE_STRUC[0];
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_TELX_STRUC[] telxStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_TELX_STRUC[0];
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_MSG_STRUC[] msgStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_MSG_STRUC[0];
			Z_FIAP_SEM_CHG_VEN params = new Z_FIAP_SEM_CHG_VEN();

			params.setBRANCH("00000");
			params.setBUKRS("1100");
			params.setLIFNR("6100009483");
			params.setROLE("RNT0200");
			params.setROLETYPE("M");
			params.setSTCD3("0315535000024");
			params.setC_VENDOR(compStruc);
			params.setC_VENDORX(compxStruc);
			params.setC_WTAX(wtxStruc);
			params.setC_WTAXX(wtxxStruc);
			params.setG_EMAIL(emailStruc);
			params.setG_EMAILX(emailxStruc);
			params.setG_FAX(faxStruc);
			params.setG_FAXX(faxxStruc);
			params.setG_MOBILE(mobileStruc);
			params.setG_MOBILEX(mobixStruc);
			params.setG_PROFILE(prfStruc);
			params.setG_PROFILEX(prfxStruc);
			params.setG_TEL(teleStruc);
			params.setG_TELX(telxStruc);
			params.setT_MESSAGES(msgStruc);

			// response --
			Z_FIAP_SEM_CHG_VENResponse resp = service.SI_Z_FIAP_SEM_CHG_VEN(params);
			System.out.println("CHG_VEN RESP >>> " + resp.toString());

			// TODO something
			/*
			 * 
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemRetObj;
	}

	public ItemResultSP chgVenBank(ItemParamsSP itemParams) {

		ItemResultSP itemRetObj = new ItemResultSP();

		try {

			SI_Z_FIAP_SEM_CHGVENBANKServiceLocator locator = new SI_Z_FIAP_SEM_CHGVENBANKServiceLocator(EngineUtilities
					.getEngineConfiguration());
			SI_Z_FIAP_SEM_CHGVENBANK service = locator.getHTTPS_Port();

			// to use Basic HTTP Authentication:
			((javax.xml.rpc.Stub) service)._setProperty(Call.USERNAME_PROPERTY, _user);
			((javax.xml.rpc.Stub) service)._setProperty(Call.PASSWORD_PROPERTY, _pass);

			((javax.xml.rpc.Stub) service)._setProperty("javax.xml.rpc.service.endpoint.address", locator
					.getHTTPS_PortAddress());

			// parameter --
			th.co.ais.webservice.chgvenbank.bean.ZSEM_BANKDATA_STRUC bankDataNew = new th.co.ais.webservice.chgvenbank.bean.ZSEM_BANKDATA_STRUC();
			th.co.ais.webservice.chgvenbank.bean.ZSEM_BANKDATA_STRUC bankDataOld = new th.co.ais.webservice.chgvenbank.bean.ZSEM_BANKDATA_STRUC();
			th.co.ais.webservice.chgvenbank.bean.EBPP_MESSAGES[] messages = new th.co.ais.webservice.chgvenbank.bean.EBPP_MESSAGES[0];
			Z_FIAP_SEM_CHGVENBANK params = new Z_FIAP_SEM_CHGVENBANK();

			params.setCHECKMODUS("");
			params.setCONFIRM_CHANGES("X");
			params.setKOART("K");
			params.setT_MESSAGES(messages);

			// response --
			Z_FIAP_SEM_CHGVENBANKResponse resp = service.SI_Z_FIAP_SEM_CHGVENBANK(params);
			System.out.println("CHGVENBANK RESP >>> " + resp.toString());

			// TODO something
			/*
			 * 
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemRetObj;
	}

	public ItemResultSP creven(ItemParamsSP itemParams) {

		ItemResultSP itemRetObj = new ItemResultSP();

		try {

			SI_Z_FIAP_SEM_CRE_VENServiceLocator locator = new SI_Z_FIAP_SEM_CRE_VENServiceLocator(EngineUtilities
					.getEngineConfiguration());
			SI_Z_FIAP_SEM_CRE_VEN service = locator.getHTTPS_Port();

			// to use Basic HTTP Authentication:
			((javax.xml.rpc.Stub) service)._setProperty(Call.USERNAME_PROPERTY, _user);
			((javax.xml.rpc.Stub) service)._setProperty(Call.PASSWORD_PROPERTY, _pass);

			((javax.xml.rpc.Stub) service)._setProperty("javax.xml.rpc.service.endpoint.address", locator
					.getHTTPS_PortAddress());

			// parameter --
			th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_COMPANY_STRUC companyStruc = new th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_COMPANY_STRUC();
			th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_PROFILE_STRUC profileStruc = new th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_PROFILE_STRUC();
			th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_WHTAX_STRUC[] whTaxStruc = new th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_WHTAX_STRUC[0];
			th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_EMAIL_STRUC[] emailStruc = new th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_EMAIL_STRUC[0];
			th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_FAX_STRUC[] faxStruc = new th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_FAX_STRUC[0];
			th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_MOBILE_STRUC[] mobileStruc = new th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_MOBILE_STRUC[0];
			th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_TELE_STRUC[] teleStruc = new th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_TELE_STRUC[0];
			th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_MSG_STRUC[] msgStruc = new th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_MSG_STRUC[0];
			Z_FIAP_SEM_CRE_VEN params = new Z_FIAP_SEM_CRE_VEN();

			// params.setREQUNAME("");
			// params.setC_VENDOR(companyStruc);
			// params.setG_PROFILE(profileStruc);
			// params.setC_WTAX(whTaxStruc);
			// params.setG_EMAIL(emailStruc);
			// params.setG_FAX(faxStruc);
			// params.setG_MOBILE(mobileStruc);
			// params.setG_TEL(teleStruc);
			// params.setT_MESSAGES(msgStruc);

			params.setREQUNAME("");
			params.setCONFIRM_NO_TAX("");
			params.setCOMPANY(companyStruc);
			params.setPROFILE(profileStruc);
			params.setT_EMAIL(emailStruc);
			params.setT_FAX(faxStruc);
			params.setT_MESSAGES(msgStruc);
			params.setT_MOBILE(mobileStruc);
			params.setT_TELE(teleStruc);
			params.setT_WHTAX(whTaxStruc);

			// response --
			Z_FIAP_SEM_CRE_VENResponse resp = service.SI_Z_FIAP_SEM_CRE_VEN(params);
			System.out.println("CRE_VEN RESP >>> " + resp.toString());

			// TODO something
			/*
			 * 
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemRetObj;
	}

	public ItemResultSP delvenbank(ItemParamsSP itemParams) {

		ItemResultSP itemRetObj = new ItemResultSP();

		try {

			SI_Z_FIAP_SEM_DELVENBANKServiceLocator locator = new SI_Z_FIAP_SEM_DELVENBANKServiceLocator(EngineUtilities
					.getEngineConfiguration());
			SI_Z_FIAP_SEM_DELVENBANK service = locator.getHTTPS_Port();

			// to use Basic HTTP Authentication:
			((javax.xml.rpc.Stub) service)._setProperty(Call.USERNAME_PROPERTY, _user);
			((javax.xml.rpc.Stub) service)._setProperty(Call.PASSWORD_PROPERTY, _pass);

			((javax.xml.rpc.Stub) service)._setProperty("javax.xml.rpc.service.endpoint.address", locator
					.getHTTPS_PortAddress());

			// parameter --
			th.co.ais.webservice.delvenbank.bean.ZSEM_DEL_BANKDATA_STRUC[] bankDataStruc = new th.co.ais.webservice.delvenbank.bean.ZSEM_DEL_BANKDATA_STRUC[0];
			th.co.ais.webservice.delvenbank.bean.EBPP_MESSAGES[] msgStruc = new th.co.ais.webservice.delvenbank.bean.EBPP_MESSAGES[0];
			Z_FIAP_SEM_DELVENBANK params = new Z_FIAP_SEM_DELVENBANK();

			params.setCHECKMODUS("M");
			params.setCONFIRM_CHANGES("X");
			params.setKOART("K");
			params.setI_BANKDATA(bankDataStruc);
			params.setT_MESSAGES(msgStruc);

			// response --
			Z_FIAP_SEM_DELVENBANKResponse resp = service.SI_Z_FIAP_SEM_DELVENBANK(params);
			System.out.println("DELVENBANK RESP >>> " + resp.toString());

			// TODO something
			/*
			 * 
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemRetObj;
	}

	public List getven(Mmm001SAPVendorSP itemParams) {

		List<Mmm001VendorSP> vendorResultList = new ArrayList<Mmm001VendorSP>();

		try {

			SI_Z_FIAP_SEM_GET_VENServiceLocator locator = new SI_Z_FIAP_SEM_GET_VENServiceLocator(EngineUtilities
					.getEngineConfiguration());
			SI_Z_FIAP_SEM_GET_VEN service = locator.getHTTPS_Port();

			// to use Basic HTTP Authentication:
			((javax.xml.rpc.Stub) service)._setProperty(Call.USERNAME_PROPERTY, _user);
			((javax.xml.rpc.Stub) service)._setProperty(Call.PASSWORD_PROPERTY, _pass);

			((javax.xml.rpc.Stub) service)._setProperty("javax.xml.rpc.service.endpoint.address", locator
					.getHTTPS_PortAddress());

			// parameter --
			th.co.ais.webservice.getven.bean.ZCVENDOR[] vendor = new th.co.ais.webservice.getven.bean.ZCVENDOR[0];
			th.co.ais.webservice.getven.bean.ZCWTAX[] wtax = new th.co.ais.webservice.getven.bean.ZCWTAX[0];
			th.co.ais.webservice.getven.bean.ZGEMAIL[] email = new th.co.ais.webservice.getven.bean.ZGEMAIL[0];
			th.co.ais.webservice.getven.bean.ZGFAX[] fax = new th.co.ais.webservice.getven.bean.ZGFAX[0];
			th.co.ais.webservice.getven.bean.ZGMOBILE[] mobile = new th.co.ais.webservice.getven.bean.ZGMOBILE[0];
			th.co.ais.webservice.getven.bean.ZGPROFILE[] profile = new th.co.ais.webservice.getven.bean.ZGPROFILE[0];
			th.co.ais.webservice.getven.bean.ZGTEL[] tel = new th.co.ais.webservice.getven.bean.ZGTEL[0];
			th.co.ais.webservice.getven.bean.EBPP_MESSAGES[] messages = new th.co.ais.webservice.getven.bean.EBPP_MESSAGES[0];
			Z_FIAP_SEM_GET_VEN params = new Z_FIAP_SEM_GET_VEN();

			params.setBRANCH(itemParams.getVendorBranchNo()); // required
			params.setBUKRS(itemParams.getCompany()); // required
			params.setLIFNR(itemParams.getVendorCode()); // required
			params.setROLE(itemParams.getRole()); // required
			params.setROLETYPE(itemParams.getRoleType()); // required
			params.setSTCD3(itemParams.getTaxId()); // required
			params.setC_VENDOR(vendor);
			params.setC_WTAX(wtax);
			params.setG_EMAIL(email);
			params.setG_FAX(fax);
			params.setG_MOBILE(mobile);
			params.setG_PROFILE(profile);
			params.setG_TEL(tel);
			params.setT_MESSAGES(messages);

			// response --
			Z_FIAP_SEM_GET_VENResponse resp = service.SI_Z_FIAP_SEM_GET_VEN(params);
			System.out.println("GET_VEN RESP >>> " + resp.toString());

			if (resp.getE_RETURNCODE().equalsIgnoreCase("S")) {
				Mmm001VendorSP tmpVedorObj = new Mmm001VendorSP();

				// G_TAX
				if (resp.getC_WTAX().length > 0) {
					tmpVedorObj.setWhtType(resp.getC_WTAX()[0].getWITHT());
					tmpVedorObj.setWhtCode(resp.getC_WTAX()[0].getWT_WITHCD());
					tmpVedorObj.setRecipientType(resp.getC_WTAX()[0].getQSREC());
				}

				// C_VENDOR
				if (resp.getC_VENDOR().length > 0) {
					tmpVedorObj.setHqFlag(resp.getC_VENDOR()[0].getLNRZE());
					tmpVedorObj.setRole(resp.getC_VENDOR()[0].getROLE());
					tmpVedorObj.setVendorBlockStatus(resp.getC_VENDOR()[0].getZAHLS());
				}

				// G_PROFILE
				int gProLngth = resp.getG_PROFILE().length;
				if (gProLngth > 0) {
					int row = 1;
					for (th.co.ais.webservice.getven.bean.ZGPROFILE obj : resp.getG_PROFILE()) {
						Mmm001VendorSP vedorObj = new Mmm001VendorSP();

						vedorObj.setRowId(Integer.toString(row));
						// vedorObj.setVendorId(itemParams.getVendorId()); //
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
						vedorObj.setProvince(obj.getREGIO());
						vedorObj.setProvinceName(obj.getREGIO());
						vedorObj.setPostCode(obj.getPSTLZ());
						vedorObj.setRegion(obj.getREGIO());
						vedorObj.setRegionName(obj.getREGIO());
						vedorObj.setTaxId(obj.getSTCD3());
						vedorObj.setVendorType(obj.getSTKZN());
						vedorObj.setNotPayeeFlag(obj.getXZEMP());

						// vedorObj.setExpenseType("");
						vedorObj.setVendorBlockStatus(tmpVedorObj.getVendorBlockStatus());
						vedorObj.setVendorStatus("");
						vedorObj.setCompany(itemParams.getCompany());
						vedorObj.setHqFlag(tmpVedorObj.getHqFlag());
						vedorObj.setWhtType(tmpVedorObj.getWhtType());
						vedorObj.setWhtCode(tmpVedorObj.getWhtCode());
						vedorObj.setRecipientType(tmpVedorObj.getRecipientType());
						vedorObj.setRole(tmpVedorObj.getRole());

						vedorObj.setSapReturnCode(resp.getE_RETURNCODE());

						vendorResultList.add(vedorObj);
						row++;
					}
				}
			} else {
				Mmm001VendorSP vedorObj = new Mmm001VendorSP();
				vedorObj.setSapReturnCode(resp.getE_RETURNCODE());
				vendorResultList.add(vedorObj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return vendorResultList;
	}

	public List getvenbank(Mmm001SAPBookbankSP itemParams) {

		List<Mmm001SAPBookbankSP> bookbankResultList = new ArrayList<Mmm001SAPBookbankSP>();

		try {

			SI_Z_FIAP_SEM_GETVENBANKServiceLocator locator = new SI_Z_FIAP_SEM_GETVENBANKServiceLocator(EngineUtilities
					.getEngineConfiguration());
			SI_Z_FIAP_SEM_GETVENBANK service = locator.getHTTPS_Port();

			// to use Basic HTTP Authentication:
			((javax.xml.rpc.Stub) service)._setProperty(Call.USERNAME_PROPERTY, _user);
			((javax.xml.rpc.Stub) service)._setProperty(Call.PASSWORD_PROPERTY, _pass);

			((javax.xml.rpc.Stub) service)._setProperty("javax.xml.rpc.service.endpoint.address", locator
					.getHTTPS_PortAddress());

			// parameter --
			th.co.ais.webservice.getvenbank.bean.ZSEM_BANKDATA_STRUC[] bankDataStruc = new th.co.ais.webservice.getvenbank.bean.ZSEM_BANKDATA_STRUC[0];
			th.co.ais.webservice.getvenbank.bean.ZSEM_BNKA_STRUC[] bnkaStruc = new th.co.ais.webservice.getvenbank.bean.ZSEM_BNKA_STRUC[0];
			th.co.ais.webservice.getvenbank.bean.EBPP_MESSAGES[] messages = new th.co.ais.webservice.getvenbank.bean.EBPP_MESSAGES[0];
			Z_FIAP_SEM_GETVENBANK params = new Z_FIAP_SEM_GETVENBANK();

			params.setI_ACCOUNT(itemParams.getAccountNo()); // required
			params.setI_KOART(itemParams.getKoart()); // required
			params.setI_XTECH_ACCNO(itemParams.getxTechAccNo()); // required
			params.setE_BANKDATA(bankDataStruc);
			params.setE_BNKA(bnkaStruc);
			params.setT_MESSAGES(messages);

			// response --
			Z_FIAP_SEM_GETVENBANKResponse resp = service.SI_Z_FIAP_SEM_GETVENBANK(params);
			System.out.println("GETVENBANK RESP >>> " + resp.toString());

			if (resp.getE_RETURNCODE().equalsIgnoreCase("S")) {

				// E_BNKA
				int eBNKALngth = resp.getE_BNKA().length;
				if (eBNKALngth > 0) {
					int row = 1;
					for (th.co.ais.webservice.getvenbank.bean.ZSEM_BNKA_STRUC obj : resp.getE_BNKA()) {
						// if(row == 1) {row++; continue;} // ignore default
						// record
						Mmm001SAPBookbankSP bookbankObj = new Mmm001SAPBookbankSP();
						bookbankObj.setRowId(Integer.toString(row - 1));
						bookbankObj.setAccountNo(resp.getE_BANKDATA()[row - 1].getBANKN());
						bookbankObj.setAccountName(resp.getE_BANKDATA()[row - 1].getKOINH());
						bookbankObj.setAccountType(itemParams.getKoart());
						bookbankObj.setBankCode(obj.getBANKL());
						bookbankObj.setBankName(obj.getBANKA());
						bookbankObj.setBankBranch(obj.getBRNCH());
						bookbankObj.setProvince(obj.getORT01());
						bookbankObj.setRemark("");
						bookbankObj.setBookbankStatus("");
						bookbankObj.setActiveStatus("");

						bookbankResultList.add(bookbankObj);
						row++;
					}
				}

				// E_BANKDATA
				/*
				 * int eBankLngth = resp.getE_BANKDATA().length; if(eBankLngth >
				 * 0){
				 * 
				 * }
				 */

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookbankResultList;
	}

	public Mmm001BookbankSP masterBank(ItemParamsSP itemParams) {

		Mmm001BookbankSP bbRetObj = new Mmm001BookbankSP();

		try {

			SI_Z_FIAP_SEM_MASTERBANKServiceLocator locator = new SI_Z_FIAP_SEM_MASTERBANKServiceLocator(EngineUtilities
					.getEngineConfiguration());
			SI_Z_FIAP_SEM_MASTERBANK service = locator.getHTTPS_Port();

			// to use Basic HTTP Authentication:
			((javax.xml.rpc.Stub) service)._setProperty(Call.USERNAME_PROPERTY, _user);
			((javax.xml.rpc.Stub) service)._setProperty(Call.PASSWORD_PROPERTY, _pass);

			((javax.xml.rpc.Stub) service)._setProperty("javax.xml.rpc.service.endpoint.address", locator
					.getHTTPS_PortAddress());

			// parameter --
			th.co.ais.webservice.masterbank.bean.BAPI1011_ADDRESS[] bankAddr = new th.co.ais.webservice.masterbank.bean.BAPI1011_ADDRESS[0];
			th.co.ais.webservice.masterbank.bean.BAPI1011_DETAIL[] bankDtl = new th.co.ais.webservice.masterbank.bean.BAPI1011_DETAIL[0];
			ZSEM_MASTER_BANK_MSG[] bankMsg = new ZSEM_MASTER_BANK_MSG[0];
			Z_FIAP_SEM_MASTERBANK params = new Z_FIAP_SEM_MASTERBANK();

			params.setBANKCOUNTRY("TH");
			params.setBANKKEY("0650661");
			params.setBANK_ADDRESS(bankAddr);
			params.setBANK_DETAIL(bankDtl);
			params.setT_MESSAGES(bankMsg);

			// response --
			Z_FIAP_SEM_MASTERBANKResponse resp = service.SI_Z_FIAP_SEM_MASTERBANK(params);
			System.out.println("MASTERBANK RESP >>> " + resp.toString());

			// TODO something
			int gBnkDetLngth = resp.getBANK_DETAIL().length;
			for (th.co.ais.webservice.masterbank.bean.BAPI1011_DETAIL obj : resp.getBANK_DETAIL()) {
				System.out.println("BAPI1011_DETAIL: " + obj.toString());
			}

			int gBnkAddrLngth = resp.getBANK_ADDRESS().length;
			for (th.co.ais.webservice.masterbank.bean.BAPI1011_ADDRESS obj : resp.getBANK_ADDRESS()) {
				System.out.println("BAPI1011_ADDRESS: " + obj.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bbRetObj;
	}

	public ApproveBookBankAct checkMasterBank(ItemParamsSP itemParams) {

		ApproveBookBankAct bbRetObj = new ApproveBookBankAct();

		try {

			SI_Z_FIAP_SEM_MASTERBANKServiceLocator locator = new SI_Z_FIAP_SEM_MASTERBANKServiceLocator(EngineUtilities
					.getEngineConfiguration());
			SI_Z_FIAP_SEM_MASTERBANK service = locator.getHTTPS_Port();

			// to use Basic HTTP Authentication:
			((javax.xml.rpc.Stub) service)._setProperty(Call.USERNAME_PROPERTY, _user);
			((javax.xml.rpc.Stub) service)._setProperty(Call.PASSWORD_PROPERTY, _pass);

			((javax.xml.rpc.Stub) service)._setProperty("javax.xml.rpc.service.endpoint.address", locator
					.getHTTPS_PortAddress());

			// parameter --
			th.co.ais.webservice.masterbank.bean.BAPI1011_ADDRESS[] bankAddr = new th.co.ais.webservice.masterbank.bean.BAPI1011_ADDRESS[1];
			th.co.ais.webservice.masterbank.bean.BAPI1011_DETAIL[] bankDtl = new th.co.ais.webservice.masterbank.bean.BAPI1011_DETAIL[0];
			ZSEM_MASTER_BANK_MSG[] bankMsg = new ZSEM_MASTER_BANK_MSG[0];
			Z_FIAP_SEM_MASTERBANK params = new Z_FIAP_SEM_MASTERBANK();

			th.co.ais.webservice.masterbank.bean.BAPI1011_ADDRESS oo = new th.co.ais.webservice.masterbank.bean.BAPI1011_ADDRESS();
			oo.setBANK_NAME(itemParams.getParam2());
			oo.setCITY("");
			oo.setSWIFT_CODE("");

			bankAddr[0] = oo;

			params.setBANKCOUNTRY("TH");
			params.setBANKKEY(itemParams.getParam1());
			params.setBANK_ADDRESS(bankAddr);
			params.setBANK_DETAIL(bankDtl);
			params.setT_MESSAGES(bankMsg);

			// response --
			Z_FIAP_SEM_MASTERBANKResponse resp = service.SI_Z_FIAP_SEM_MASTERBANK(params);
			System.out.println("MASTERBANK RESP >>> " + resp.toString());
			bbRetObj.setResultMsg(resp.getE_RETURNCODE());
			bbRetObj.setRemark(resp.getT_MESSAGES()[resp.getT_MESSAGES().length - 1].getMSGTX());
			// bbRetObj.setpRemark(resp.getT_MESSAGES());
			// TODO something
			/*
			 * 
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bbRetObj;
	}

	public ApproveBookBankSP getSapVendorbank(ItemParamsSP itemParams) {

		ApproveBookBankSP vdMstRetObj = new ApproveBookBankSP();

		try {

			SI_Z_FIAP_SEM_GETVENBANKServiceLocator locator = new SI_Z_FIAP_SEM_GETVENBANKServiceLocator(EngineUtilities
					.getEngineConfiguration());
			SI_Z_FIAP_SEM_GETVENBANK service = locator.getHTTPS_Port();

			// to use Basic HTTP Authentication:
			((javax.xml.rpc.Stub) service)._setProperty(Call.USERNAME_PROPERTY, _user);
			((javax.xml.rpc.Stub) service)._setProperty(Call.PASSWORD_PROPERTY, _pass);

			((javax.xml.rpc.Stub) service)._setProperty("javax.xml.rpc.service.endpoint.address", locator
					.getHTTPS_PortAddress());

			// parameter --
			th.co.ais.webservice.getvenbank.bean.ZSEM_BANKDATA_STRUC[] bankDataStruc = new th.co.ais.webservice.getvenbank.bean.ZSEM_BANKDATA_STRUC[1];
			th.co.ais.webservice.getvenbank.bean.ZSEM_BNKA_STRUC[] bnkaStruc = new th.co.ais.webservice.getvenbank.bean.ZSEM_BNKA_STRUC[0];
			th.co.ais.webservice.getvenbank.bean.EBPP_MESSAGES[] messages = new th.co.ais.webservice.getvenbank.bean.EBPP_MESSAGES[0];
			Z_FIAP_SEM_GETVENBANK params = new Z_FIAP_SEM_GETVENBANK();

			th.co.ais.webservice.getvenbank.bean.ZSEM_BANKDATA_STRUC oo = new th.co.ais.webservice.getvenbank.bean.ZSEM_BANKDATA_STRUC();
			oo.setLIFNR("");
			oo.setBANKS("");
			oo.setBANKL("");
			oo.setBANKN("");
			bankDataStruc[0] = oo;

			params.setI_ACCOUNT(itemParams.getParam1());
			params.setI_KOART("K");
			params.setI_XTECH_ACCNO("");
			params.setE_BANKDATA(bankDataStruc);
			params.setE_BNKA(bnkaStruc);
			params.setT_MESSAGES(messages);

			// response --
			Z_FIAP_SEM_GETVENBANKResponse resp = service.SI_Z_FIAP_SEM_GETVENBANK(params);
			System.out.println("GETVENBANK RESP >>> " + resp.toString());
			vdMstRetObj.setResult(resp.getE_RETURNCODE());
			vdMstRetObj.setRemark(resp.getT_MESSAGES()[resp.getT_MESSAGES().length - 1].getMSGTX());
			// vdMstRetObj.setBANKS
			th.co.ais.webservice.getvenbank.bean.ZSEM_BANKDATA_STRUC[] bankDataList = resp.getE_BANKDATA();
			th.co.ais.webservice.getvenbank.bean.ZSEM_BANKDATA_STRUC bankdata = new th.co.ais.webservice.getvenbank.bean.ZSEM_BANKDATA_STRUC();
			if (bankDataList != null) {
				bankdata = bankDataList[bankDataList.length - 1];
			}

			vdMstRetObj.setVendorCode(bankdata.getLIFNR());
			vdMstRetObj.setBankCode(bankdata.getBANKL());
			vdMstRetObj.setBankAccNo(bankdata.getBANKN());
			vdMstRetObj.setBankAccName(bankdata.getKOINH());

			System.out.println("GETVENBANK RESP T_MESS >>> " + resp.getT_MESSAGES());
			// TODO something
			/*
			 * 
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		return vdMstRetObj;
	}

	public ApproveBookBankAct addSapVenBank(ItemParamsSP itemParams) {

		ApproveBookBankAct itemRetObj = new ApproveBookBankAct();

		try {

			SI_Z_FIAP_SEM_ADDVENBANKServiceLocator locator = new SI_Z_FIAP_SEM_ADDVENBANKServiceLocator(EngineUtilities
					.getEngineConfiguration());
			SI_Z_FIAP_SEM_ADDVENBANK service = locator.getHTTPS_Port();

			// to use Basic HTTP Authentication:
			((javax.xml.rpc.Stub) service)._setProperty(Call.USERNAME_PROPERTY, _user);
			((javax.xml.rpc.Stub) service)._setProperty(Call.PASSWORD_PROPERTY, _pass);

			((javax.xml.rpc.Stub) service)._setProperty("javax.xml.rpc.service.endpoint.address", locator
					.getHTTPS_PortAddress());

			// parameter --
			th.co.ais.webservice.addvenbank.bean.ZSEM_BANKDATA_STRUC[] bankDataStruc = new th.co.ais.webservice.addvenbank.bean.ZSEM_BANKDATA_STRUC[1];
			th.co.ais.webservice.addvenbank.bean.ZSEM_MESSAGES_STRUC[] msgStruc = new th.co.ais.webservice.addvenbank.bean.ZSEM_MESSAGES_STRUC[0];
			Z_FIAP_SEM_ADDVENBANK params = new Z_FIAP_SEM_ADDVENBANK();

			th.co.ais.webservice.addvenbank.bean.ZSEM_BANKDATA_STRUC oo = new th.co.ais.webservice.addvenbank.bean.ZSEM_BANKDATA_STRUC();
			oo.setLIFNR(itemParams.getParam1());
			oo.setBANKS("TH");
			oo.setBANKL(itemParams.getParam2());
			oo.setBANKN(itemParams.getParam3());
			oo.setBVTYP("SEM1");
			oo.setKOINH(itemParams.getParam4());
			bankDataStruc[0] = oo;

			params.setCHECKMODUS("M");
			params.setCONFIRM_CHANGES("X");
			params.setKOART("K");
			params.setI_BANKDATA(bankDataStruc);
			params.setT_MESSAGES(msgStruc);

			// response --
			Z_FIAP_SEM_ADDVENBANKResponse resp = service.SI_Z_FIAP_SEM_ADDVENBANK(params);
			System.out.println("ADDVENBANK RESP >>> " + resp.toString());
			itemRetObj.setResultMsg(resp.getE_RETURNCODE());
			itemRetObj.setpRemark(resp.getT_MESSAGES()[resp.getT_MESSAGES().length - 1].getMSGTX());
			// TODO something
			/*
			 * 
			 */

		} catch (Exception e) {
			e.printStackTrace();
			itemRetObj = null;
		}
		return itemRetObj;
	}

	public ApproveBookBankAct chgSapVenBank(ItemParamsSP[] itemParams) {

		ApproveBookBankAct itemRetObj = new ApproveBookBankAct();

		try {

			SI_Z_FIAP_SEM_CHGVENBANKServiceLocator locator = new SI_Z_FIAP_SEM_CHGVENBANKServiceLocator(EngineUtilities
					.getEngineConfiguration());
			SI_Z_FIAP_SEM_CHGVENBANK service = locator.getHTTPS_Port();

			// to use Basic HTTP Authentication:
			((javax.xml.rpc.Stub) service)._setProperty(Call.USERNAME_PROPERTY, _user);
			((javax.xml.rpc.Stub) service)._setProperty(Call.PASSWORD_PROPERTY, _pass);

			((javax.xml.rpc.Stub) service)._setProperty("javax.xml.rpc.service.endpoint.address", locator
					.getHTTPS_PortAddress());

			// parameter --
			th.co.ais.webservice.chgvenbank.bean.ZSEM_BANKDATA_STRUC bankDataNew = new th.co.ais.webservice.chgvenbank.bean.ZSEM_BANKDATA_STRUC();
			th.co.ais.webservice.chgvenbank.bean.ZSEM_BANKDATA_STRUC bankDataOld = new th.co.ais.webservice.chgvenbank.bean.ZSEM_BANKDATA_STRUC();
			th.co.ais.webservice.chgvenbank.bean.EBPP_MESSAGES[] messages = new th.co.ais.webservice.chgvenbank.bean.EBPP_MESSAGES[0];
			Z_FIAP_SEM_CHGVENBANK params = new Z_FIAP_SEM_CHGVENBANK();

			bankDataNew.setLIFNR(itemParams[0].getParam1());
			bankDataNew.setBANKS("TH");
			bankDataNew.setBANKL(itemParams[0].getParam2());
			bankDataNew.setBANKN(itemParams[0].getParam3());
			bankDataNew.setBVTYP("SEM");
			bankDataNew.setKOINH(itemParams[0].getParam4());

			bankDataOld.setLIFNR(itemParams[1].getParam1());
			bankDataOld.setBANKS("TH");
			bankDataOld.setBANKL(itemParams[1].getParam2());
			bankDataOld.setBANKN(itemParams[1].getParam3());
			bankDataOld.setBVTYP("SEM");
			bankDataOld.setKOINH(itemParams[1].getParam4());

			params.setCHECKMODUS("");
			params.setCONFIRM_CHANGES("X");
			params.setKOART("K");
			params.setI_BANKDATA_NEW(bankDataNew);
			params.setI_BANKDATA_OLD(bankDataOld);
			params.setT_MESSAGES(messages);

			// response --
			Z_FIAP_SEM_CHGVENBANKResponse resp = service.SI_Z_FIAP_SEM_CHGVENBANK(params);
			System.out.println("CHGVENBANK RESP >>> " + resp.toString());
			itemRetObj.setResultMsg(resp.getE_RETURNCODE());
			itemRetObj.setpRemark(resp.getT_MESSAGES()[resp.getT_MESSAGES().length - 1].getMSGTX());
			// TODO something
			/*
			 * 
			 */

		} catch (Exception e) {
			e.printStackTrace();
			itemRetObj = null;
		}
		return itemRetObj;
	}

	public ApproveBookBankAct delSapVenbank(ItemParamsSP itemParams) {

		ApproveBookBankAct itemRetObj = new ApproveBookBankAct();

		try {

			SI_Z_FIAP_SEM_DELVENBANKServiceLocator locator = new SI_Z_FIAP_SEM_DELVENBANKServiceLocator(EngineUtilities
					.getEngineConfiguration());
			SI_Z_FIAP_SEM_DELVENBANK service = locator.getHTTPS_Port();

			// to use Basic HTTP Authentication:
			((javax.xml.rpc.Stub) service)._setProperty(Call.USERNAME_PROPERTY, _user);
			((javax.xml.rpc.Stub) service)._setProperty(Call.PASSWORD_PROPERTY, _pass);

			((javax.xml.rpc.Stub) service)._setProperty("javax.xml.rpc.service.endpoint.address", locator
					.getHTTPS_PortAddress());

			// parameter --
			th.co.ais.webservice.delvenbank.bean.ZSEM_DEL_BANKDATA_STRUC[] bankDataStruc = new th.co.ais.webservice.delvenbank.bean.ZSEM_DEL_BANKDATA_STRUC[1];
			th.co.ais.webservice.delvenbank.bean.EBPP_MESSAGES[] msgStruc = new th.co.ais.webservice.delvenbank.bean.EBPP_MESSAGES[0];
			Z_FIAP_SEM_DELVENBANK params = new Z_FIAP_SEM_DELVENBANK();

			th.co.ais.webservice.delvenbank.bean.ZSEM_DEL_BANKDATA_STRUC oo = new th.co.ais.webservice.delvenbank.bean.ZSEM_DEL_BANKDATA_STRUC();
			oo.setLIFNR(itemParams.getParam1());
			oo.setBANKS("TH");
			oo.setBANKL(itemParams.getParam2());
			oo.setBANKN(itemParams.getParam3());
			oo.setBVTYP("SEM");
			oo.setKOINH(itemParams.getParam4());
			bankDataStruc[0] = oo;

			params.setCHECKMODUS("M");
			params.setCONFIRM_CHANGES("X");
			params.setKOART("K");
			params.setI_BANKDATA(bankDataStruc);
			params.setT_MESSAGES(msgStruc);

			// response --
			Z_FIAP_SEM_DELVENBANKResponse resp = service.SI_Z_FIAP_SEM_DELVENBANK(params);
			System.out.println("DELVENBANK RESP >>> " + resp.toString());
			itemRetObj.setResultMsg(resp.getE_RETURNCODE());
			itemRetObj.setpRemark(resp.getT_MESSAGES()[resp.getT_MESSAGES().length - 1].getMSGTX());
			// TODO something
			/*
			 * 
			 */

		} catch (Exception e) {
			e.printStackTrace();
			itemRetObj = null;
		}
		return itemRetObj;
	}

	public MmmVendorMasterInfoSP getvendor(MmmVendorMasterInfoSP itemParams) {

		MmmVendorMasterInfoSP vdMstRetObj = new MmmVendorMasterInfoSP();

		try {

			SI_Z_FIAP_SEM_GET_VENServiceLocator locator = new SI_Z_FIAP_SEM_GET_VENServiceLocator(EngineUtilities
					.getEngineConfiguration());
			SI_Z_FIAP_SEM_GET_VEN service = locator.getHTTPS_Port();

			// to use Basic HTTP Authentication:
			((javax.xml.rpc.Stub) service)._setProperty(Call.USERNAME_PROPERTY, _user);
			((javax.xml.rpc.Stub) service)._setProperty(Call.PASSWORD_PROPERTY, _pass);

			((javax.xml.rpc.Stub) service)._setProperty("javax.xml.rpc.service.endpoint.address", locator
					.getHTTPS_PortAddress());

			// parameter --
			th.co.ais.webservice.getven.bean.ZCVENDOR[] vendor = new th.co.ais.webservice.getven.bean.ZCVENDOR[1];
			th.co.ais.webservice.getven.bean.ZCVENDOR ven = new th.co.ais.webservice.getven.bean.ZCVENDOR();
			th.co.ais.webservice.getven.bean.ZCWTAX[] wtax = new th.co.ais.webservice.getven.bean.ZCWTAX[1];
			th.co.ais.webservice.getven.bean.ZCWTAX wht = new th.co.ais.webservice.getven.bean.ZCWTAX();
			th.co.ais.webservice.getven.bean.ZGEMAIL[] email = new th.co.ais.webservice.getven.bean.ZGEMAIL[1];
			th.co.ais.webservice.getven.bean.ZGFAX[] fax = new th.co.ais.webservice.getven.bean.ZGFAX[1];
			th.co.ais.webservice.getven.bean.ZGFAX faxs = new th.co.ais.webservice.getven.bean.ZGFAX();
			th.co.ais.webservice.getven.bean.ZGMOBILE[] mobile = new th.co.ais.webservice.getven.bean.ZGMOBILE[1];
			th.co.ais.webservice.getven.bean.ZGMOBILE mobi = new th.co.ais.webservice.getven.bean.ZGMOBILE();
			th.co.ais.webservice.getven.bean.ZGPROFILE[] profile = new th.co.ais.webservice.getven.bean.ZGPROFILE[1];
			th.co.ais.webservice.getven.bean.ZGPROFILE pro = new th.co.ais.webservice.getven.bean.ZGPROFILE();
			th.co.ais.webservice.getven.bean.ZGTEL[] tel = new th.co.ais.webservice.getven.bean.ZGTEL[1];
			th.co.ais.webservice.getven.bean.ZGTEL tele = new th.co.ais.webservice.getven.bean.ZGTEL();
			th.co.ais.webservice.getven.bean.EBPP_MESSAGES[] messages = new th.co.ais.webservice.getven.bean.EBPP_MESSAGES[1];
			Z_FIAP_SEM_GET_VEN params = new Z_FIAP_SEM_GET_VEN();

			params.setLIFNR(itemParams.getVendorCode()); // required
			params.setBUKRS(itemParams.getCompany()); // required
			params.setSTCD3(itemParams.getTaxId()); // required
			params.setBRANCH(itemParams.getBranchNo()); // required
			params.setROLE(itemParams.getRole()); // required
			params.setROLETYPE(itemParams.getRoleType()); // required

			// pro.setBRANCH(itemParams.getBranchNo());
			// pro.setNAME1(itemParams.getName1());
			// pro.setSORTL(itemParams.getSearchTeam());
			// pro.setORT01(itemParams.getCity());
			// pro.setLAND1(itemParams.getCountry());
			// pro.setREGIO(itemParams.getRegion());
			// profile[0] = pro;
			//			
			// tele.setTEL_NUMBER(itemParams.getTelNo());
			// tel[0] = tele;
			//			
			// mobi.setTEL_NUMBER(itemParams.getMobileNo());
			// mobile[0] = mobi;
			//			
			// faxs.setFAX_NUMBER(itemParams.getFaxNo());
			// fax[0] = faxs;
			//			
			// ven.setBUKRS(itemParams.getCompany());
			// ven.setLNRZE(itemParams.getHeadOffice());
			// vendor[0] = ven;
			//			
			// wht.setWITHT(itemParams.getWhtType());
			// wht.setWT_WITHCD(itemParams.getWhtCode());
			// wht.setQSREC(itemParams.getRecipientType());
			// wtax[0] = wht;

			params.setC_VENDOR(vendor);
			params.setC_WTAX(wtax);
			params.setG_EMAIL(email);
			params.setG_FAX(fax);
			params.setG_MOBILE(mobile);
			params.setG_PROFILE(profile);
			params.setG_TEL(tel);
			params.setT_MESSAGES(messages);

			// TODO something must be fix

			// response --
			Z_FIAP_SEM_GET_VENResponse resp = service.SI_Z_FIAP_SEM_GET_VEN(params);
			System.out.println("GET_VEN RESP >>> " + resp.toString());
			// System.out.println("CRE_VEN RESP DESC >>> "+resp.getT_MESSAGES()[resp.getT_MESSAGES().length-1].getMSGTX());
			// int gProLngth = resp.getG_PROFILE().length;
			if (resp != null && resp.getG_PROFILE() != null) {
				for (int i = 0; i < resp.getG_PROFILE().length; i++) {
					th.co.ais.webservice.getven.bean.ZGPROFILE gProFile = new th.co.ais.webservice.getven.bean.ZGPROFILE();
					th.co.ais.webservice.getven.bean.ZGTEL gTel = new th.co.ais.webservice.getven.bean.ZGTEL();
					th.co.ais.webservice.getven.bean.ZGMOBILE gMobile = new th.co.ais.webservice.getven.bean.ZGMOBILE();
					th.co.ais.webservice.getven.bean.ZGFAX gFax = new th.co.ais.webservice.getven.bean.ZGFAX();
					th.co.ais.webservice.getven.bean.ZGEMAIL gEMail = new th.co.ais.webservice.getven.bean.ZGEMAIL();
					th.co.ais.webservice.getven.bean.ZCVENDOR gVendor = new th.co.ais.webservice.getven.bean.ZCVENDOR();
					th.co.ais.webservice.getven.bean.ZCWTAX gWTax = new th.co.ais.webservice.getven.bean.ZCWTAX();
					th.co.ais.webservice.getven.bean.ZCWTAX gWTax2 = new th.co.ais.webservice.getven.bean.ZCWTAX();

					gProFile = resp.getG_PROFILE()[0];
					if (resp.getG_TEL() != null && resp.getG_TEL().length > 0 && resp.getG_TEL()[0] != null) {
						gTel = resp.getG_TEL()[0];
						vdMstRetObj.setConsNumberTel(resp.getG_TEL()[0].getCONSNUMBER());
					}
					if (resp.getG_MOBILE() != null && resp.getG_MOBILE().length > 0 && resp.getG_MOBILE()[0] != null) {
						gMobile = resp.getG_MOBILE()[0];
						vdMstRetObj.setConsNumberMobile(resp.getG_MOBILE()[0].getCONSNUMBER());
					}
					if (resp.getG_FAX() != null && resp.getG_FAX().length > 0 && resp.getG_FAX()[0] != null) {
						gFax = resp.getG_FAX()[0];
						vdMstRetObj.setConsNumberFax(resp.getG_FAX()[0].getCONSNUMBER());
					}
					if (resp.getG_EMAIL() != null && resp.getG_EMAIL().length > 0 && resp.getG_EMAIL()[0] != null) {
						gEMail = resp.getG_EMAIL()[0];
						vdMstRetObj.setConsNumberEmail(resp.getG_EMAIL()[0].getCONSNUMBER());
					}

					if (resp.getC_WTAX() != null && resp.getC_WTAX().length >= 1) {
						if (resp.getC_WTAX() != null && resp.getC_WTAX().length > 1) {
							// gVendor = resp.getC_VENDOR()[0];
							if (resp.getC_WTAX() != null && resp.getC_WTAX()[0] != null) {
								gWTax = resp.getC_WTAX()[0];
								vdMstRetObj.setWhtType(gWTax.getWITHT());
								vdMstRetObj.setWhtCode(gWTax.getWT_WITHCD());
								vdMstRetObj.setRecipientType(gWTax.getQSREC());

								System.out.println("******** service get vendor RecipientType : " + gWTax.getQSREC());
							}

							if (resp.getC_WTAX() != null && resp.getC_WTAX()[1] != null) {
								gWTax2 = resp.getC_WTAX()[1];
								vdMstRetObj.setWhtType2(gWTax2.getWITHT());
								vdMstRetObj.setWhtCode2(gWTax2.getWT_WITHCD());
								vdMstRetObj.setRecipientType2(gWTax2.getQSREC());
								System.out.println("******** service get vendor RecipientType2 : " + gWTax2.getQSREC());
							}
						} else {

							// gVendor = resp.getC_VENDOR()[0];
							if (resp.getC_WTAX() != null && resp.getC_WTAX()[0] != null) {
								gWTax = resp.getC_WTAX()[0];
								vdMstRetObj.setWhtType(gWTax.getWITHT());
								vdMstRetObj.setWhtCode(gWTax.getWT_WITHCD());
								vdMstRetObj.setRecipientType(gWTax.getQSREC());

								System.out.println("******** service get vendor RecipientType : " + gWTax.getQSREC());
							}

						}
					}

					vdMstRetObj.setVendorCode(gProFile.getLIFNR());
					vdMstRetObj.setBranch(gProFile.getBRANCH());
					if (gProFile.getNAME1() != null)
						vdMstRetObj.setName1(gProFile.getNAME1());
					// vdMstRetObj.setName2(gProFile.getNAME2());
					// vdMstRetObj.setName3(gProFile.getNAME3());
					// vdMstRetObj.setName4(gProFile.getNAME4());
					// // vdMstRetObj.setStreet(gProFile.getSTRAS());
					// vdMstRetObj.setStreet2(gProFile.getSTR_SUPPL1());
					// vdMstRetObj.setStreet3(gProFile.getSTR_SUPPL2());
					// vdMstRetObj.setStreet4(gProFile.getSTR_SUPPL3());
					// vdMstRetObj.setDistrict(gProFile.getORT02());
					// vdMstRetObj.setCity(gProFile.getORT01());
					// vdMstRetObj.setPostalCode(gProFile.getPSTLZ());
					// vdMstRetObj.setCountry(gProFile.getLAND1());
					// vdMstRetObj.setRegion(gProFile.getREGIO());
					if (gProFile.getSTCD3() != null)
						vdMstRetObj.setTaxId(gProFile.getSTCD3());
					//					
					// vdMstRetObj.setTelNo(gTel.getTEL_NUMBER());
					//					
					// vdMstRetObj.setMobileNo(gMobile.getTEL_NUMBER());
					//					
					// vdMstRetObj.setFaxNo(gFax.getFAX_NUMBER());
					//					
					// vdMstRetObj.setEmail(gEMail.getSMTP_ADDR());
					//					
					// vdMstRetObj.setCompany(gVendor.getBUKRS());
					// vdMstRetObj.setHeadOffice(gVendor.getLNRZE());
					// vdMstRetObj.setPaymentBlock(gVendor.getZAHLS());
					//					
					// vdMstRetObj.setWhtType(gWTax.getWITHT());
					// vdMstRetObj.setWhtCode(gWTax.getWT_WITHCD());
					// vdMstRetObj.setRecipientType(gWTax.getQSREC());
					//					
					// vdMstRetObj.setWhtType2(gWTax2.getWITHT());
					// vdMstRetObj.setWhtCode2(gWTax2.getWT_WITHCD());
					// vdMstRetObj.setRecipientType2(gWTax2.getQSREC());
				}

				vdMstRetObj.setResult(resp.getE_RETURNCODE());
				// String vdCode = resp.getG_PROFILE()[0];
				// LIFNR
				//
				// vdMstRetObj.setVendorCode(vdCode);
			}

		} catch (Exception e) {
			vdMstRetObj = null;
			e.printStackTrace();
		}
		return vdMstRetObj;
	}

	public MmmVendorMasterInfoSP creven(MmmVendorMasterInfoSP itemParams) {

		MmmVendorMasterInfoSP itemRetObj = new MmmVendorMasterInfoSP();

		try {

			SI_Z_FIAP_SEM_CRE_VENServiceLocator locator = new SI_Z_FIAP_SEM_CRE_VENServiceLocator(EngineUtilities
					.getEngineConfiguration());
			SI_Z_FIAP_SEM_CRE_VEN service = locator.getHTTPS_Port();

			// to use Basic HTTP Authentication:
			((javax.xml.rpc.Stub) service)._setProperty(Call.USERNAME_PROPERTY, _user);
			((javax.xml.rpc.Stub) service)._setProperty(Call.PASSWORD_PROPERTY, _pass);

			((javax.xml.rpc.Stub) service)._setProperty("javax.xml.rpc.service.endpoint.address", locator
					.getHTTPS_PortAddress());

			// parameter --
			th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_COMPANY_STRUC companyStruc = new th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_COMPANY_STRUC();
			th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_PROFILE_STRUC profileStruc = new th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_PROFILE_STRUC();
			th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_WHTAX_STRUC[] whTaxStruc = new th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_WHTAX_STRUC[1];
			th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_EMAIL_STRUC[] emailStruc = new th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_EMAIL_STRUC[1];
			th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_FAX_STRUC[] faxStruc = new th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_FAX_STRUC[1];
			th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_MOBILE_STRUC[] mobileStruc = new th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_MOBILE_STRUC[1];
			th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_TELE_STRUC[] teleStruc = new th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_TELE_STRUC[1];
			th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_MSG_STRUC[] msgStruc = new th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_MSG_STRUC[1];
			Z_FIAP_SEM_CRE_VEN params = new Z_FIAP_SEM_CRE_VEN();

			th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_TELE_STRUC gTel = new th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_TELE_STRUC();
			th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_MOBILE_STRUC gMobile = new th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_MOBILE_STRUC();
			th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_FAX_STRUC gFax = new th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_FAX_STRUC();
			th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_EMAIL_STRUC gEMail = new th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_EMAIL_STRUC();
			th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_PROFILE_STRUC cVendor = new th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_PROFILE_STRUC();
			th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_WHTAX_STRUC gWTax = new th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_WHTAX_STRUC();
			th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_WHTAX_STRUC gWTax2 = new th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_WHTAX_STRUC();

			System.out.println("itemParams.getVendorCode() : " + itemParams.getVendorCode());
			profileStruc.setKTOKK(itemParams.getAccountGroup());
			profileStruc.setBRANCH(itemParams.getBranch());
			profileStruc.setORT01(itemParams.getAmphur());
			profileStruc.setLAND1(itemParams.getCountry());
			profileStruc.setREGIO(itemParams.getRegion());
			profileStruc.setLIFNR(itemParams.getVendorCode());
			profileStruc.setBRANCH(itemParams.getBranch());
			profileStruc.setNAME1(itemParams.getVendorName());
			profileStruc.setNAME2(itemParams.getVendorName2());
			profileStruc.setNAME3(itemParams.getVendorName3());
			profileStruc.setNAME4(itemParams.getVendorName4());
			profileStruc.setSTRAS(itemParams.getStreet());
			profileStruc.setSTREET2(itemParams.getStreet2());
			profileStruc.setSTREET3(itemParams.getStreet3());
			profileStruc.setSTREET4(itemParams.getStreet4());
			profileStruc.setORT02(itemParams.getDistrict());
			profileStruc.setPSTLZ(itemParams.getPostCode());
			profileStruc.setSTCD3(itemParams.getTaxId());
			profileStruc.setSORTL(itemParams.getSearchTeam());
			profileStruc.setSTKZN(itemParams.getStkzn());
			profileStruc.setXZEMP(itemParams.getNotPayeeFlag());

			gTel.setTEL_NUMBER(itemParams.getTelNo());
			gTel.setCOUNTRY(itemParams.getCountry());
			teleStruc[0] = gTel;

			gMobile.setTEL_NUMBER(itemParams.getMobileNo());
			gMobile.setCOUNTRY(itemParams.getCountry());
			mobileStruc[0] = gMobile;

			gFax.setFAX_NUMBER(itemParams.getFaxNo());
			gFax.setCOUNTRY(itemParams.getCountry());
			faxStruc[0] = gFax;

			gEMail.setSMTP_ADDR(itemParams.getEmail());
			emailStruc[0] = gEMail;

			companyStruc.setROLE(itemParams.getRole());
			companyStruc.setROLETYPE(itemParams.getRoleType());
			companyStruc.setBUKRS(itemParams.getCompany());
			// companyStruc.setLNRZE(itemParams.getHeadOffice());
			// companyStruc.setZAHLS(itemParams.getPaymentBlock());
			companyStruc.setZTERM(itemParams.getPaymentTerm());
			companyStruc.setZWELS(itemParams.getPaymentMethod());
			companyStruc.setREPRF(itemParams.getChkDoubleInv());
			companyStruc.setAKONT(itemParams.getReconAcct());

			System.out.println("************** service add vendor getReconAcct : " + itemParams.getReconAcct());

			if (itemParams.getWhtType2() != null && itemParams.getWhtCode2() != null
					&& itemParams.getRecipientType2() != null) {
				whTaxStruc = new th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_WHTAX_STRUC[2];
			}

			gWTax.setWITHT(itemParams.getWhtType());
			gWTax.setWT_WITHCD(itemParams.getWhtCode());
			gWTax.setQSREC(itemParams.getRecipientType());
			System.out.println("************** service add vendor RecipientType : " + itemParams.getRecipientType());
			System.out.println("************** service add vendor WhtType() : " + itemParams.getWhtType());
			whTaxStruc[0] = gWTax;

			if (itemParams.getWhtType2() != null && itemParams.getWhtCode2() != null
					&& itemParams.getRecipientType2() != null) {
				gWTax2.setWITHT(itemParams.getWhtType2());
				gWTax2.setWT_WITHCD(itemParams.getWhtCode2());
				gWTax2.setQSREC(itemParams.getRecipientType2());
				whTaxStruc[1] = gWTax2;
				System.out.println("************** service add vendor RecipientType2 : "
						+ itemParams.getRecipientType2());
				System.out.println("************** service add vendor WhtType()2 : " + itemParams.getWhtType2());
			}

			// params.setREQUNAME("");
			// params.setC_VENDOR(companyStruc);
			// params.setG_PROFILE(profileStruc);
			// params.setC_WTAX(whTaxStruc);
			// params.setG_EMAIL(emailStruc);
			// params.setG_FAX(faxStruc);
			// params.setG_MOBILE(mobileStruc);
			// params.setG_TEL(teleStruc);
			// params.setT_MESSAGES(msgStruc);

			params.setREQUNAME("");
			params.setCONFIRM_NO_TAX(itemParams.getConfirmNoTax());
			params.setCOMPANY(companyStruc);
			params.setPROFILE(profileStruc);
			params.setT_EMAIL(emailStruc);
			params.setT_FAX(faxStruc);
			params.setT_MESSAGES(msgStruc);
			params.setT_MOBILE(mobileStruc);
			params.setT_TELE(teleStruc);
			params.setT_WHTAX(whTaxStruc);

			// response --
			Z_FIAP_SEM_CRE_VENResponse resp = service.SI_Z_FIAP_SEM_CRE_VEN(params);
			System.out.println("CRE_VEN RESP >>> " + resp.toString());
			//			
			if (resp != null) {
				itemRetObj.setVendorCode(resp.getE_VENCODE());
				itemRetObj.setResult(resp.getE_RETURNCODE());
				System.out.println("CRE_VEN RESP getE_VENCODE >>> " + resp.getE_VENCODE());
			}
			if (resp != null && StringUtils.equalsIgnoreCase("E", resp.getE_RETURNCODE())) {
				// itemRetObj.setVendorCode(resp.getE_VENCODE());
				itemRetObj.setResult(resp.getE_RETURNCODE());
				itemRetObj.setRemark(resp.getT_MESSAGES()[resp.getT_MESSAGES().length - 1].getMSGTX());
			}

			// TODO something
			/*
			 * 
			 */

		} catch (Exception e) {
			e.printStackTrace();
			itemRetObj = null;
		}
		return itemRetObj;
	}

	public MmmVendorMasterInfoSP chgVendor(MmmVendorMasterInfoSP itemParams) {

		MmmVendorMasterInfoSP itemRetObj = new MmmVendorMasterInfoSP();

		try {

			SI_Z_FIAP_SEM_CHG_VENServiceLocator locator = new SI_Z_FIAP_SEM_CHG_VENServiceLocator(EngineUtilities
					.getEngineConfiguration());
			SI_Z_FIAP_SEM_CHG_VEN service = locator.getHTTPS_Port();

			// to use Basic HTTP Authentication:
			((javax.xml.rpc.Stub) service)._setProperty(Call.USERNAME_PROPERTY, _user);
			((javax.xml.rpc.Stub) service)._setProperty(Call.PASSWORD_PROPERTY, _pass);

			((javax.xml.rpc.Stub) service)._setProperty("javax.xml.rpc.service.endpoint.address", locator
					.getHTTPS_PortAddress());

			// parameter --
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_COMP_STRUC compStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_COMP_STRUC();
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_COMPX_STRUC compxStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_COMPX_STRUC();
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_WTAX_STRUC[] wtxStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_WTAX_STRUC[1];
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_WTAXX_STRUC[] wtxxStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_WTAXX_STRUC[1];
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_EMAIL_STRUC[] emailStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_EMAIL_STRUC[1];
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_EMAILX_STRUC[] emailxStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_EMAILX_STRUC[1];
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_FAX_STRUC[] faxStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_FAX_STRUC[1];
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_FAXX_STRUC[] faxxStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_FAXX_STRUC[1];
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_MOBILE_STRUC[] mobileStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_MOBILE_STRUC[1];
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_MOBIX_STRUC[] mobixStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_MOBIX_STRUC[1];
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_PRF_STRUC prfStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_PRF_STRUC();
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_PRFX_STRUC prfxStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_PRFX_STRUC();
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_TELE_STRUC[] teleStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_TELE_STRUC[1];
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_TELX_STRUC[] telxStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_TELX_STRUC[1];
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_MSG_STRUC[] msgStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_MSG_STRUC[1];
			th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_PROFILE_STRUC profileStruc = new th.co.ais.webservice.creven.bean.ZSEM_CRE_VEN_PROFILE_STRUC();
			Z_FIAP_SEM_CHG_VEN params = new Z_FIAP_SEM_CHG_VEN();

			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_TELE_STRUC gTel = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_TELE_STRUC();
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_MOBILE_STRUC gMobile = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_MOBILE_STRUC();
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_FAX_STRUC gFax = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_FAX_STRUC();
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_EMAIL_STRUC gEMail = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_EMAIL_STRUC();
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_WTAX_STRUC gWTax = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_WTAX_STRUC();
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_WTAX_STRUC gWTax2 = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_WTAX_STRUC();

			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_TELX_STRUC gTelx = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_TELX_STRUC();
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_MOBIX_STRUC gMobilex = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_MOBIX_STRUC();
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_FAXX_STRUC gFaxx = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_FAXX_STRUC();
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_EMAILX_STRUC gEMailx = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_EMAILX_STRUC();
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_WTAXX_STRUC gWTaxx = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_WTAXX_STRUC();
			th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_WTAXX_STRUC gWTaxx2 = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_WTAXX_STRUC();

			prfStruc.setLIFNR(itemParams.getVendorCode());
			prfStruc.setBRANCH(itemParams.getBranch());
			// prfStruc.setNAME1(itemParams.getVendorName());
			prfStruc.setSORTL(itemParams.getSearchTeam());
			prfStruc.setORT01(itemParams.getAmphur());
			prfStruc.setLAND1(itemParams.getCountry());
			prfStruc.setREGIO(itemParams.getRegion());
			prfStruc.setNAME1(itemParams.getVendorName());
			prfStruc.setNAME2(itemParams.getVendorName2());
			prfStruc.setNAME3(itemParams.getVendorName3());
			prfStruc.setNAME4(itemParams.getVendorName4());
			prfStruc.setSTRAS(itemParams.getStreet());
			prfStruc.setSTR_SUPPL1(itemParams.getStreet2());
			prfStruc.setSTR_SUPPL2(itemParams.getStreet3());
			prfStruc.setSTR_SUPPL3(itemParams.getStreet4());
			prfStruc.setORT02(itemParams.getDistrict());
			prfStruc.setPSTLZ(itemParams.getPostCode());
			prfStruc.setSTCD3(itemParams.getTaxId());
			prfStruc.setXZEMP(itemParams.getNotPayeeFlag());
			prfStruc.setSTKZN(itemParams.getStkzn());

			prfxStruc.setLIFNR("X");
			prfxStruc.setBRANCH("X");
			// prfxStruc.setNAME1("X");
			prfxStruc.setSORTL("X");
			prfxStruc.setORT01("X");
			prfxStruc.setLAND1("X");
			prfxStruc.setREGIO("X");
			prfxStruc.setNAME1("X");
			prfxStruc.setNAME2("X");
			prfxStruc.setNAME3("X");
			prfxStruc.setNAME4("X");
			prfxStruc.setSTRAS("X");
			prfxStruc.setSTR_SUPPL1("X");
			prfxStruc.setSTR_SUPPL2("X");
			prfxStruc.setSTR_SUPPL3("X");
			prfxStruc.setORT02("X");
			prfxStruc.setPSTLZ("X");
			prfxStruc.setSTCD3("X");
			prfxStruc.setXZEMP("X");
			prfxStruc.setSTKZN("X");

			// --------------
			gTel.setTEL_NUMBER(itemParams.getTelNo());
			gTel.setCOUNTRY(itemParams.getCountry());
			gTel.setCONSNUMBER(itemParams.getConsNumberTel());
			gTel.setUPDATEFLAG(itemParams.getUpdateFlagTel());
			teleStruc[0] = gTel;

			gTelx.setTEL_NUMBER("X");
			gTelx.setCOUNTRY("X");
			gTelx.setCONSNUMBER("X");
			gTelx.setUPDATEFLAG("X");
			telxStruc[0] = gTelx;
			// ----------------
			gMobile.setTEL_NUMBER(itemParams.getMobileNo());
			gMobile.setCOUNTRY(itemParams.getCountry());
			gMobile.setCONSNUMBER(itemParams.getConsNumberMobile());
			gMobile.setUPDATEFLAG(itemParams.getUpdateFlagMobile());
			mobileStruc[0] = gMobile;

			System.out.println("service change vendor gMobile.getTEL_NUMBER : " + gMobile.getTEL_NUMBER());
			System.out.println("service change vendor gMobile.getCOUNTRY : " + gMobile.getCOUNTRY());
			System.out.println("service change vendor gMobile.getCONSNUMBER : " + gMobile.getCONSNUMBER());
			System.out.println("service change vendor gMobile.getUPDATEFLAG : " + gMobile.getUPDATEFLAG());

			gMobilex.setTEL_NUMBER("X");
			gMobilex.setCOUNTRY("X");
			gMobilex.setCONSNUMBER("X");
			gMobilex.setUPDATEFLAG("X");
			mobixStruc[0] = gMobilex;
			// -----------------
			gFax.setFAX_NUMBER(itemParams.getFaxNo());
			gFax.setCOUNTRY(itemParams.getCountry());
			gFax.setCONSNUMBER(itemParams.getConsNumberFax());
			gFax.setUPDATEFLAG(itemParams.getUpdateFlagFax());
			faxStruc[0] = gFax;

			gFaxx.setFAX_NUMBER("X");
			gFaxx.setCOUNTRY("X");
			gFaxx.setCONSNUMBER("X");
			gFaxx.setUPDATEFLAG("X");
			faxxStruc[0] = gFaxx;
			// ----------------
			gEMail.setSMTP_ADDR(itemParams.getEmail());
			gEMail.setCONSNUMBER(itemParams.getConsNumberEmail());
			gEMail.setUPDATEFLAG(itemParams.getUpdateFlagEmail());
			emailStruc[0] = gEMail;

			gEMailx.setSMTP_ADDR("X");
			gEMailx.setCONSNUMBER("X");
			gEMailx.setUPDATEFLAG("X");
			emailxStruc[0] = gEMailx;
			// -----------------
			compStruc.setROLE(itemParams.getRole());
			compStruc.setROLETYPE(itemParams.getRoleType());
			// compStruc.setBUKRS(itemParams.getCompany());
			compStruc.setLNRZE(itemParams.getHeadOffice());
			compStruc.setZAHLS(itemParams.getPaymentBlock());
			compStruc.setZTERM(itemParams.getPaymentTerm());
			compStruc.setZWELS(itemParams.getPaymentMethod());
			compStruc.setREPRF(itemParams.getChkDoubleInv());

			System.out.println("************** service change vendor getReconAcct : " + itemParams.getReconAcct());

			// compxStruc.setROLE("X");
			// compxStruc.setROLETYPE("X");
			// // compStruc.setBUKRS(itemParams.getCompany());
			// compxStruc.setLNRZE("X");
			// compxStruc.setZAHLS("X");
			// compxStruc.setZTERM("X");
			// compxStruc.setZWELS("X");
			// compxStruc.setREPRF("X");
			// --------------------------
			if (itemParams.getWhtType2() != null && itemParams.getWhtCode2() != null
					&& itemParams.getRecipientType2() != null) {
				wtxStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_WTAX_STRUC[2];
				wtxxStruc = new th.co.ais.webservice.chgven.bean.ZSEM_CHG_VEN_WTAXX_STRUC[2];
			}

			gWTax.setWITHT(itemParams.getWhtType());
			gWTax.setWT_WITHCD(itemParams.getWhtCode());
			gWTax.setQSREC(itemParams.getRecipientType());
			gWTax.setACTION_FLAG(itemParams.getWhtActionFlag());
			wtxStruc[0] = gWTax;
			System.out.println("*************** Service change vendor getWhtType : " + itemParams.getWhtType());
			System.out.println("*************** Service change vendor getWhtCode : " + itemParams.getWhtCode());
			System.out
					.println("*************** Service change vendor RecipientType : " + itemParams.getRecipientType());
			System.out.println("*************** Service change vendor getWhtActionFlag : "
					+ itemParams.getWhtActionFlag());

			gWTaxx.setWITHT("X");
			gWTaxx.setWT_WITHCD("X");
			gWTaxx.setQSREC("X");
			gWTaxx.setACTION_FLAG("X");
			wtxxStruc[0] = gWTaxx;

			if (itemParams.getWhtType2() != null && itemParams.getWhtCode2() != null
					&& itemParams.getRecipientType2() != null) {
				gWTax2.setWITHT(itemParams.getWhtType2());
				gWTax2.setWT_WITHCD(itemParams.getWhtCode2());
				gWTax2.setQSREC(itemParams.getRecipientType2());
				gWTax2.setACTION_FLAG(itemParams.getWhtActionFlag2());
				wtxStruc[1] = gWTax2;
				System.out.println("*************** Service change vendor getWhtType2 : " + itemParams.getWhtType2());
				System.out.println("*************** Service change vendor getWhtCode2 : " + itemParams.getWhtCode2());
				System.out.println("*************** Service change vendor RecipientType2 : "
						+ itemParams.getRecipientType2());
				System.out.println("*************** Service change vendor getWhtActionFlag2 : "
						+ itemParams.getWhtActionFlag2());

				gWTaxx2.setWITHT("X");
				gWTaxx2.setWT_WITHCD("X");
				gWTaxx2.setQSREC("X");
				gWTaxx2.setACTION_FLAG("X");
				wtxxStruc[1] = gWTaxx2;

			}
			// -----------------------------

			params.setLIFNR(itemParams.getVendorCode());
			params.setBRANCH(itemParams.getBranchNo());
			params.setBUKRS(itemParams.getCompany());
			params.setROLE(itemParams.getRole());
			params.setROLETYPE(itemParams.getRoleType());
			params.setSTCD3(itemParams.getTaxIdOld());

			params.setG_PROFILE(prfStruc);
			params.setG_PROFILEX(prfxStruc);

			params.setG_TEL(teleStruc);
			params.setG_TELX(telxStruc);

			params.setG_MOBILE(mobileStruc);
			params.setG_MOBILEX(mobixStruc);

			params.setG_FAX(faxStruc);
			params.setG_FAXX(faxxStruc);

			params.setG_EMAIL(emailStruc);
			params.setG_EMAILX(emailxStruc);

			params.setC_VENDOR(compStruc);
			params.setC_VENDORX(compxStruc);

			params.setC_WTAX(wtxStruc);
			params.setC_WTAXX(wtxxStruc);

			params.setT_MESSAGES(msgStruc);

			// response --
			Z_FIAP_SEM_CHG_VENResponse resp = service.SI_Z_FIAP_SEM_CHG_VEN(params);
			itemRetObj.setResult(resp.getE_RETURNCODE());
			System.out.println("CHG_VEN RESP >>> " + resp.toString());
			// System.out.println("CRE_VEN RESP DESC >>> "+resp.getT_MESSAGES()[resp.getT_MESSAGES().length-1].getMSGTX());

			// TODO something
			/*
			 * 
			 */
			if (resp != null && StringUtils.equalsIgnoreCase("E", resp.getE_RETURNCODE())) {
				itemRetObj.setResult(resp.getE_RETURNCODE());
				itemRetObj.setRemark(resp.getT_MESSAGES()[resp.getT_MESSAGES().length - 1].getMSGTX());
				System.out.println("CRE_VEN RESP DESC >>> "
						+ resp.getT_MESSAGES()[resp.getT_MESSAGES().length - 1].getMSGTX());
			}

		} catch (Exception e) {
			e.printStackTrace();
			itemRetObj = null;
		}
		return itemRetObj;
	}

	public MmmVendorMasterInfoSP blkChangeUnBlkVen(MmmVendorMasterInfoSP itemParams) {

		MmmVendorMasterInfoSP itemRetObj = new MmmVendorMasterInfoSP();

		try {

			SI_Z_FIAP_SEM_BLKUNBLKVENServiceLocator locator = new SI_Z_FIAP_SEM_BLKUNBLKVENServiceLocator(
					EngineUtilities.getEngineConfiguration());
			SI_Z_FIAP_SEM_BLKUNBLKVEN service = locator.getHTTPS_Port();

			// to use Basic HTTP Authentication:
			((javax.xml.rpc.Stub) service)._setProperty(Call.USERNAME_PROPERTY, _user);
			((javax.xml.rpc.Stub) service)._setProperty(Call.PASSWORD_PROPERTY, _pass);

			((javax.xml.rpc.Stub) service)._setProperty("javax.xml.rpc.service.endpoint.address", locator
					.getHTTPS_PortAddress());

			// parameter --
			th.co.ais.webservice.blkunblkven.bean.EBPP_MESSAGES[] messages = new th.co.ais.webservice.blkunblkven.bean.EBPP_MESSAGES[0];
			Z_FIAP_SEM_BLKUNBLKVEN params = new Z_FIAP_SEM_BLKUNBLKVEN();

			params.setBRANCH(itemParams.getBranch());
			params.setBUKRS(itemParams.getCompany());
			params.setLIFNR(itemParams.getVendorCode());
			params.setROLE(itemParams.getRole());
			params.setROLETYPE(itemParams.getRoleType());
			params.setSTCD3(itemParams.getTaxId());

			params.setLOEVM(itemRetObj.getLoevm());
			params.setSPERR(itemRetObj.getSperr());
			params.setT_MESSAGES(messages);

			// response --
			Z_FIAP_SEM_BLKUNBLKVENResponse resp = service.SI_Z_FIAP_SEM_BLKUNBLKVEN(params);
			itemRetObj.setResult(resp.getE_RETURNCODE());
			System.out.println("BLKUNBLKVEN RESP >>> " + resp.toString());

			if (resp != null && StringUtils.equalsIgnoreCase("E", resp.getE_RETURNCODE())) {
				itemRetObj.setResult(resp.getE_RETURNCODE());
				itemRetObj.setRemark(resp.getT_MESSAGES()[resp.getT_MESSAGES().length - 1].getMSGTX());
				System.out.println("CRE_VEN RESP DESC >>> "
						+ resp.getT_MESSAGES()[resp.getT_MESSAGES().length - 1].getMSGTX());
			}
			// TODO something
			/*
			 * 
			 */

		} catch (Exception e) {
			itemRetObj = null;
			e.printStackTrace();
		}
		return itemRetObj;
	}
	
	private String chkNull(String str) {
		
		if(str != null && !str.equals("")) {
			return str;
		}else {
			return "";
		}
		
	}
	
	private String chkDecimal(String str) {
		
		if(str != null && !str.equals("")) {
			return str;
		}else {
			return "0";
		}
		
	}

	public List<Mrt010IfrsInterface> IFRSCreateSEM(List<Mrt010IfrsInterface> interfaceList) {
		List<Mrt010IfrsInterface> interfaceResponseList;
		try {
			LOG.debug("method :: IFRSCreateSEM ");
			SI_OB_Z_RE_IF_SEM_CREATEServiceLocator locator = new SI_OB_Z_RE_IF_SEM_CREATEServiceLocator(EngineUtilities
					.getEngineConfiguration());
			
			//locator.setHTTPS_PortEndpointAddress(_endpoint_create);
			
			SI_OB_Z_RE_IF_SEM_CREATE service = locator.getHTTPS_Port();
			
			LOG.debug("End point : " + locator.getHTTPS_PortAddress());
			LOG.debug("User : " + SAPUtility.WS_IFRS_USERNAME + " , Pass : " + SAPUtility.WS_IFRS_PASSWORD);
			
			
			// to use Basic HTTP Authentication:
			((javax.xml.rpc.Stub) service)._setProperty(Call.USERNAME_PROPERTY, SAPUtility.WS_IFRS_USERNAME);
			((javax.xml.rpc.Stub) service)._setProperty(Call.PASSWORD_PROPERTY, SAPUtility.WS_IFRS_PASSWORD);

			((javax.xml.rpc.Stub) service)._setProperty("javax.xml.rpc.service.endpoint.address", locator
					.getHTTPS_PortAddress());

			// Prepare parameter before send.
			Z_RE_IF_SEM_CREATE params = new Z_RE_IF_SEM_CREATE();
			List<ZREIF_S_CONTRACTTEMPLATE_INTER> itemList = new ArrayList<ZREIF_S_CONTRACTTEMPLATE_INTER>();
			for (int index = 0; index < interfaceList.size(); index++) {
				Mrt010IfrsInterface interfaceObj = interfaceList.get(index);
				ZREIF_S_CONTRACTTEMPLATE_INTER item = new ZREIF_S_CONTRACTTEMPLATE_INTER();
				item.setFILENAME(chkNull(interfaceObj.getFileName()));
				item.setREFERENCE_ID(chkNull(interfaceObj.getReferenceId()));
				item.setACTIVITY(chkNull(interfaceObj.getActivity()));
				item.setCOMP_CODE(chkNull(interfaceObj.getCompanyCode1()));
				item.setCONTRACT_NO(chkNull(interfaceObj.getContractNo()));
				item.setCOMPANY_CODE_MAIN(chkNull(interfaceObj.getCompanyCodeMain()));
				item.setMAIN_CONTRACT_NO(chkNull(interfaceObj.getMainContractNo()));
				item.setOLD_CONTRACT_NO(chkNull(interfaceObj.getOldContractNo()));
				item.setCONTRACT_TYPE(chkNull(interfaceObj.getContractType()));
				item.setOBJECT_DESC(chkNull(interfaceObj.getObjectDesc()));
				item.setCONTRACT_NAME(chkNull(interfaceObj.getContractName()));
				item.setCONTRACT_CONCLUSION_DATE(chkNull(interfaceObj.getDateContractConclusion()));
				item.setDATE_CONTRACT_START(chkNull(interfaceObj.getDateContractStart()));
				item.setDATE_FIRST_CONTRACT_END(chkNull(interfaceObj.getDateFirstContractEnd()));
				item.setAUTHORIZATION_GROUP(chkNull(interfaceObj.getAuthorizationGroup()));
				item.setINDUSTRY(chkNull(interfaceObj.getIndustry()));
				item.setPERSON_RESPONSIBLE(chkNull(interfaceObj.getPersonResponsible()));
				item.setCASH_FLOW_STARTING_ON(chkNull(interfaceObj.getCasFlowStartingOn()));
				item.setFIRST_POSTING_FROM(chkNull(interfaceObj.getFirstPostingFrom1()));
				item.setCURRENCY_FOR_CONTRACT(chkNull(interfaceObj.getCurrencyForContract()));
				item.setTYPE_OF_RENEWAL(chkNull(interfaceObj.getTypeOfRenewal()));
				item.setRENEWAL_RULE(chkNull(interfaceObj.getRenewalRulw()));
				item.setSEQUENCE_NO(chkNull(interfaceObj.getSequenceNo()));
				item.setNO_OF_RENEWALS(chkNull(interfaceObj.getNoOfRenewals()));
				item.setCONTRACT_RENEWED_YEARS(chkNull(interfaceObj.getContractRenewedYears()));
				item.setCONTRACT_RENEWED_MONTHS(chkNull(interfaceObj.getContractRenewedMonths()));
				item.setCONTRACT_RENEWED_DAYS(chkNull(interfaceObj.getContractRenewedDays()));
				item.setTYPE_OF_AUTOMATIC_RENEWAL(chkNull(interfaceObj.getTypeOfAutomaticRenewal()));
				item.setRENEWAL_EXECUTION(chkNull(interfaceObj.getRenewalExecution()));
				item.setTERM_NO(chkNull(interfaceObj.getTermNo1()));
				item.setPAYMENT_METHOD(chkNull(interfaceObj.getPaymentMethod()));
				item.setPMT_METHSUPL(chkNull(interfaceObj.getPmtMethsupl()));
				item.setINDIVID_SET(chkNull(interfaceObj.getIndividSet()));
				item.setPAYMENT_BLOCK_KEY(chkNull(interfaceObj.getPaymentBlockKey()));
				item.setTERMS_OF_PAYMENT_KEY(chkNull(interfaceObj.getTermsOfPaymentKey()));
				item.setKEY_FOR_HOUSE_BANK(chkNull(interfaceObj.getKeyForHouseBank()));
				item.setBANK_DETAILS_ID(chkNull(interfaceObj.getBankDetailsId()));
				item.setNOTE_TO_PAYEE(chkNull(interfaceObj.getNoteToPayee()));
				item.setDUNNING_AREA(chkNull(interfaceObj.getDunningArea()));
				item.setDUNNING_BLOCK(chkNull(interfaceObj.getDunningBlock()));
				item.setACCOUNT_DETERMINATION(chkNull(interfaceObj.getAccountDetermination()));
				item.setTAX_TYPE(chkNull(interfaceObj.getTaxType()));
				item.setTAX_GROUP(chkNull(interfaceObj.getTaxGroup()));
				item.setBUSINESS_PARTNER_NO(chkNull(interfaceObj.getBusinessPartnerNo1()));
				item.setTERM_NO1(chkNull(interfaceObj.getTermNo2()));
				item.setFREQUENCY(chkNull(interfaceObj.getNoFrequencyPeriod()));
				item.setFREQUENCY_UNIT(chkNull(interfaceObj.getFrequencyUnit()));
				item.setSTARTING_MONTH(chkNull(interfaceObj.getFrequencyStart()));
				item.setPAYMENT_FORM(chkNull(interfaceObj.getPaymentForm()));
				item.setPRORATED(chkNull(interfaceObj.getProrated()));
				item.setCALCULATE_METHOD(chkNull(interfaceObj.getCalculateMethod()));
				item.setFACTORY_CALENDAR(chkNull(interfaceObj.getFactoryCalenda()));
				item.setPARTNER_DAT(chkNull(interfaceObj.getBusinessPartnerNo2()));
				item.setROLE_TYPE(chkNull(interfaceObj.getBusinessPartnerRole()));
				item.setDATE_START_RELATIONSHIP(chkNull(interfaceObj.getDateStartRelationship()));
				item.setDATE_END_RELATIONSHIP(chkNull(interfaceObj.getDateEndRelationship()));
				item.setADDRESS_TYPE(chkNull(interfaceObj.getAddressType()));
				item.setCONDITION_SPLIT(chkNull(interfaceObj.getConditionSplit()));
				item.setCONDITION_TYPE(chkNull(interfaceObj.getConditionType()));
				item.setCONDITION_PURPOSE(chkNull(interfaceObj.getConditionPurpose1()));
				item.setDATE_FROM_CONDITION(chkNull(interfaceObj.getDateFromCondition()));
				item.setDATE_UP_TO_CONDITION(chkNull(interfaceObj.getDateUpToCondition()));
				item.setCURRENCY_CONDITION(chkNull(interfaceObj.getCurrencyCondition()));
				item.setNO_POSTING_TERM(chkNull(interfaceObj.getNoPostingTerm()));
				item.setNO_FREQUENCY_TERM(chkNull(interfaceObj.getNoFrequencyTerm()));
				item.setNO_ORGANIZATIONAL_TERM(chkNull(interfaceObj.getNoOrganizationalTerm()));
				item.setCOST_CENTER(chkNull(interfaceObj.getCostCenter()));
				item.setPROFIT_CENTER(chkNull(interfaceObj.getProfitCenter()));
				item.setCALCULATION_FORMULA(chkNull(interfaceObj.getCalculationFormula()));
				item.setCURRENCY_UNIT_PRICE(new BigDecimal(chkDecimal(interfaceObj.getCurrencyUnitPrice())));
				item.setDISTRIBUTION_FORMULA(chkNull(interfaceObj.getDistributionFormla()));
				item.setCONDITIONS_EXTERNAL_PURPOSE(chkNull(interfaceObj.getConditionsExternalPurpose()));
				item.setCONDITION_ONE_TIME1(chkNull(interfaceObj.getConditionOneTime()));
				item.setSTATISTICAL_INFO_CONDITION1(chkNull(interfaceObj.getStatisticalInfoCondition()));
				item.setPOSTING_START_DATE_CONDITION(chkNull(interfaceObj.getFirstPostingFrom2()));
				item.setNO_OF_WHT_TERM(chkNull(interfaceObj.getNoOfWhtTerm()));
				item.setDIFFERENT_DUE_DATE_ONE_TIME(chkNull(interfaceObj.getDifferentDueDateOneTime()));
				item.setGRADING_TERM_IN_MONTHS(new BigInteger(chkDecimal(interfaceObj.getGradingTermInMonths())));
				item.setGRADING_INTERVAL_MONTHS(new BigInteger(chkDecimal(interfaceObj.getGradingIntervalInMonths())));
				item.setGRADING_PERCENT_INCREASE(new BigDecimal(chkDecimal(interfaceObj.getGradingPercentIncrease())));
				item.setGRADING_ABSOLUTE_INCREASE(new BigInteger(chkDecimal(interfaceObj.getGradingAbsoluteIncrease())));
				item.setCONTRACT_STATUS(chkNull(interfaceObj.getContractStatus()));
				item.setVALUATION_RULE(chkNull(interfaceObj.getValuationRule()));
				item.setOBJECT_ID(chkNull(interfaceObj.getObjectId()));
				item.setOBJECT_TYPE(chkNull(interfaceObj.getObjectType()));
				item.setOBJECT_VALID_FROM(chkNull(interfaceObj.getObjectValidFrom()));
				item.setOBJECT_VALID_TO(chkNull(interfaceObj.getObjectValidTo()));
				item.setSTART_DATE_OF_CONSIDERATION(chkNull(interfaceObj.getStartOfConsideration()));
				item.setFIRST_POSTING_FROM1(chkNull(interfaceObj.getFirstPostingFrom3()));
				item.setCLASSIFICATION(chkNull(interfaceObj.getClassification()));
				item.setINTEREST_RATE(new BigDecimal(chkDecimal(interfaceObj.getInterestRate())));
				item.setFREQUENCY_TERM(chkNull(interfaceObj.getFrequencyTerm()));
				item.setDISTRIBUT_FORMULA(chkNull(interfaceObj.getDistributFormula()));
				item.setDISTRIB_FORMULA_PARAMETER(chkNull(interfaceObj.getDistribFormulaParameter()));
				item.setPROBABLE_END(chkNull(interfaceObj.getProbableEnd()));
				item.setEND_OF_USAGE_ROU(chkNull(interfaceObj.getEndOfUsageRou()));
				item.setVALUATION_STATUS(chkNull(interfaceObj.getValuationStatus()));
				item.setVALUATION_BEHAVIOR(chkNull(interfaceObj.getValuationBehavior()));
				item.setCOMPANY_CODE(chkNull(interfaceObj.getCompanyCode2()));
				item.setASSET(chkNull(interfaceObj.getAsset()));
				item.setSUBNO(chkNull(interfaceObj.getSubno()));
				item.setOBJECT_DESCRIPTION(chkNull(interfaceObj.getObjectDescription()));
				item.setACCTASGOBJTYPE(chkNull(interfaceObj.getAcctasgobjtype()));
				item.setABSOLUTE_START(chkNull(interfaceObj.getAbsoluteStart()));
				item.setABSOLUTE_END(chkNull(interfaceObj.getAbsoluteEnd()));
				item.setCOND_VAL_PROPERTY(chkNull(interfaceObj.getCondValProperty()));
				item.setCOND_CONSIDERATION(chkNull(interfaceObj.getCondConsideration()));
				item.setCONSIDER_CONDITION(chkNull(interfaceObj.getConsiderCondition()));
				item.setPERCENTAGE(chkNull(interfaceObj.getPercentage()));
				item.setABSOLUTE_SHARE(chkNull(interfaceObj.getAbsoluteShare()));
				item.setCURRENCY(chkNull(interfaceObj.getCurrency()));
				item.setCONDITION_PURPOSE1(chkNull(interfaceObj.getConditionPurpose2()));
				item.setUNIT_PRICE1(new BigDecimal(chkDecimal(interfaceObj.getUnitPrice())));
				itemList.add(item);
			}
			
			XStream xstream = new XStream(new DomDriver());
			xstream.alias("item", ZREIF_S_CONTRACTTEMPLATE_INTER.class);
			String xmlRequest = xstream.toXML(itemList).replaceAll("__","_").replaceAll("__hashCodeCalc","_hashCodeCalc");
			LOG.debug("xmlRequest : "  + xmlRequest);
			
			
			ZREIF_S_CONTRACTTEMPLATE_INTER[] items = new ZREIF_S_CONTRACTTEMPLATE_INTER[itemList.size()];
			items = itemList.toArray(items);
			
			params.setCONTRACT_DETAILS1(items);

			// Send data to SAP web service.
			Z_RE_IF_SEM_CREATEResponse response = service.SI_OB_Z_RE_IF_SEM_CREATE(params);

			// Response from SAP web service.
			ZREIF_S_CONTRACTRESPONSE[] res = response.getCONTRACTRESPONSE();

			interfaceResponseList = new ArrayList<Mrt010IfrsInterface>();
			if (!interfaceList.isEmpty()) {
				for (int i = 0; i < res.length; i++) {
					String userId = "";
					int seq = 0;
					Mrt010IfrsInterface interfaceResponse = new Mrt010IfrsInterface();

					// Find userId
					for (int j = 0; j < interfaceList.size(); j++) {
						if (interfaceList.get(j).getReferenceId().trim().equals(res[i].getREFERENCE_ID().trim())) {
							userId = interfaceList.get(j).getUserId();
							if (StringUtils.isNotBlank(interfaceList.get(j).getResendSeq())) {
								seq = Integer.valueOf(interfaceList.get(j).getResendSeq());
							}
						}
					}

					interfaceResponse.setReferenceId(res[i].getREFERENCE_ID());
					interfaceResponse.setUserId(userId);
					interfaceResponse.setSapFilename(res[i].getFILENAME());
					interfaceResponse.setSapActivity(res[i].getACTIVITY());
					interfaceResponse.setSapReferenceId(res[i].getREFERENCE_ID());
					interfaceResponse.setSapCompanyCode(res[i].getCOMPANY_CODE());
					interfaceResponse.setSapContractNo(res[i].getCONTRACT_NO());
					interfaceResponse.setSapRefxNo(res[i].getREFX_NO());
					interfaceResponse.setSapStatusCode(res[i].getSTATUS_CODE());
					interfaceResponse.setSapErrorCode(res[i].getERROR_CODE());
					interfaceResponse.setSapStatusMessage(res[i].getSTATUS_MESSAGE());
					interfaceResponse.setRecordStatus("A");
					interfaceResponse.setResendSeq(String.valueOf(seq + 1));
					interfaceResponseList.add(interfaceResponse);
				}
				
				xstream = new XStream(new DomDriver());
				xstream.alias("item", ZREIF_S_CONTRACTRESPONSE.class);
				String xmlResponse = xstream.toXML(res).replaceAll("__","_").replaceAll("__hashCodeCalc","_hashCodeCalc");
				LOG.debug("xmlResponse : "  + xmlResponse);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(),e);
			interfaceResponseList = new ArrayList<Mrt010IfrsInterface>();
			for (int i = 0; i < interfaceList.size(); i++) {
				Mrt010IfrsInterface interfaceResponse = new Mrt010IfrsInterface();
				interfaceResponse.setReferenceId(interfaceList.get(i).getReferenceId());
				interfaceResponse.setUserId(interfaceList.get(i).getUserId());
				interfaceResponse.setSapStatusMessage("Message from java: " + e.getMessage());
				interfaceResponse.setRecordStatus("A");
				if (StringUtils.isNotBlank(interfaceList.get(i).getResendSeq())) {
					int seq = Integer.valueOf(interfaceList.get(i).getResendSeq());
					interfaceResponse.setResendSeq(String.valueOf(seq + 1));
				} else {
					interfaceResponse.setResendSeq(String.valueOf(1));
				}
				interfaceResponseList.add(interfaceResponse);
			}
		}
		return interfaceResponseList;
	}
	

	public List<Mrt010IfrsInterface> IFRSChangeSEM(List<Mrt010IfrsInterface> interfaceList) {
		List<Mrt010IfrsInterface> interfaceResponseList;
		try {
			LOG.debug("method :: IFRSChangeSEM ");
			LOG.debug("request size : " + interfaceList.size());
			
			
			SI_OB_Z_RE_IF_SEM_CHANGEServiceLocator locator = new SI_OB_Z_RE_IF_SEM_CHANGEServiceLocator(EngineUtilities
					.getEngineConfiguration());
			
			//locator.setHTTPS_PortEndpointAddress(_endpoint_change);
			SI_OB_Z_RE_IF_SEM_CHANGE service = locator.getHTTPS_Port();
			
			LOG.debug("End point : " + locator.getHTTPS_PortAddress());
			LOG.debug("User : " + SAPUtility.WS_IFRS_USERNAME + " , Pass : " + SAPUtility.WS_IFRS_PASSWORD);

			// to use Basic HTTP Authentication:
			((javax.xml.rpc.Stub) service)._setProperty(Call.USERNAME_PROPERTY, SAPUtility.WS_IFRS_USERNAME);
			((javax.xml.rpc.Stub) service)._setProperty(Call.PASSWORD_PROPERTY, SAPUtility.WS_IFRS_PASSWORD);

			// Prepare parameter before send.
			Z_RE_IF_SEM_CHANGE params = new Z_RE_IF_SEM_CHANGE();
			List<ZREIF_S_SEM_CONTRACT_CHANGE_IN> itemList = new ArrayList<ZREIF_S_SEM_CONTRACT_CHANGE_IN>();
			for (int index = 0; index < interfaceList.size(); index++) {
				Mrt010IfrsInterface interfaceObj = interfaceList.get(index);
				ZREIF_S_SEM_CONTRACT_CHANGE_IN item = new ZREIF_S_SEM_CONTRACT_CHANGE_IN();
				item.setFILENAME(chkNull(interfaceObj.getFileName()));
				item.setREFERENCE_ID(chkNull(interfaceObj.getReferenceId()));
				item.setACTIVITY(chkNull(interfaceObj.getActivity()));
				item.setCOMP_CODE(chkNull(interfaceObj.getCompanyCode1()));
				item.setCONTRACT_NO(chkNull(interfaceObj.getSapRefxNo()));
				item.setCOMPANY_CODE_MAIN(chkNull(interfaceObj.getCompanyCodeMain()));
				item.setMAIN_CONTRACT_NO(chkNull(interfaceObj.getMainContractNo()));
				item.setOLD_CONTRACT_NO(chkNull(interfaceObj.getOldContractNo()));
				item.setCONTRACT_TYPE(chkNull(interfaceObj.getContractType()));
				item.setOBJECT_DESC(chkNull(interfaceObj.getObjectDesc()));
				item.setCONTRACT_NAME(chkNull(interfaceObj.getContractName()));
				item.setCONTRACT_CONCLUSION_DATE(chkNull(interfaceObj.getDateContractConclusion()));
				item.setDATE_CONTRACT_START(chkNull(interfaceObj.getDateContractStart()));
				item.setDATE_FIRST_CONTRACT_END(chkNull(interfaceObj.getDateFirstContractEnd()));
				item.setAUTHORIZATION_GROUP(chkNull(interfaceObj.getAuthorizationGroup()));
				item.setINDUSTRY(chkNull(interfaceObj.getIndustry()));
				item.setPERSON_RESPONSIBLE(chkNull(interfaceObj.getPersonResponsible()));
				item.setCASH_FLOW_STARTING_ON(chkNull(interfaceObj.getCasFlowStartingOn()));
				item.setFIRST_POSTING_FROM(chkNull(interfaceObj.getFirstPostingFrom1()));
				item.setCURRENCY_FOR_CONTRACT(chkNull(interfaceObj.getCurrencyForContract()));
				item.setTYPE_OF_RENEWAL(chkNull(interfaceObj.getTypeOfRenewal()));
				item.setRENEWAL_RULE(chkNull(interfaceObj.getRenewalRulw()));
				item.setSEQUENCE_NO(chkNull(interfaceObj.getSequenceNo()));
				item.setNO_OF_RENEWALS(chkNull(interfaceObj.getNoOfRenewals()));
				item.setCONTRACT_RENEWED_YEARS(chkNull(interfaceObj.getContractRenewedYears()));
				item.setCONTRACT_RENEWED_MONTHS(chkNull(interfaceObj.getContractRenewedMonths()));
				item.setCONTRACT_RENEWED_DAYS(chkNull(interfaceObj.getContractRenewedDays()));
				item.setTYPE_OF_AUTOMATIC_RENEWAL(chkNull(interfaceObj.getTypeOfAutomaticRenewal()));
				item.setRENEWAL_EXECUTION(chkNull(interfaceObj.getRenewalExecution()));
				item.setTERM_NO(chkNull(interfaceObj.getTermNo1()));
				item.setPAYMENT_METHOD(chkNull(interfaceObj.getPaymentMethod()));
				item.setPMT_METHSUPL(chkNull(interfaceObj.getPmtMethsupl()));
				item.setINDIVID_SET(chkNull(interfaceObj.getIndividSet()));
				item.setPAYMENT_BLOCK_KEY(chkNull(interfaceObj.getPaymentBlockKey()));
				item.setTERMS_OF_PAYMENT_KEY(chkNull(interfaceObj.getTermsOfPaymentKey()));
				item.setKEY_FOR_HOUSE_BANK(chkNull(interfaceObj.getKeyForHouseBank()));
				item.setBANK_DETAILS_ID(chkNull(interfaceObj.getBankDetailsId()));
				item.setNOTE_TO_PAYEE(chkNull(interfaceObj.getNoteToPayee()));
				item.setDUNNING_AREA(chkNull(interfaceObj.getDunningArea()));
				item.setDUNNING_BLOCK(chkNull(interfaceObj.getDunningBlock()));
				item.setACCOUNT_DETERMINATION(chkNull(interfaceObj.getAccountDetermination()));
				item.setTAX_TYPE(chkNull(interfaceObj.getTaxType()));
				item.setTAX_GROUP(chkNull(interfaceObj.getTaxGroup()));
				item.setBUSINESS_PARTNER_NO(chkNull(interfaceObj.getBusinessPartnerNo1()));
				item.setTERM_NO1(chkNull(interfaceObj.getTermNo2()));
				item.setFREQUENCY(chkNull(interfaceObj.getNoFrequencyPeriod()));
				item.setFREQUENCY_UNIT(chkNull(interfaceObj.getFrequencyUnit()));
				item.setSTARTING_MONTH(chkNull(interfaceObj.getFrequencyStart()));
				item.setPAYMENT_FORM(chkNull(interfaceObj.getPaymentForm()));
				item.setPRORATED(chkNull(interfaceObj.getProrated()));
				item.setCALCULATE_METHOD(chkNull(interfaceObj.getCalculateMethod()));
				item.setFACTORY_CALENDAR(chkNull(interfaceObj.getFactoryCalenda()));
				item.setPARTNER_DAT(chkNull(interfaceObj.getBusinessPartnerNo2()));
				item.setROLE_TYPE(chkNull(interfaceObj.getBusinessPartnerRole()));
				item.setDATE_START_RELATIONSHIP(chkNull(interfaceObj.getDateStartRelationship()));
				item.setDATE_END_RELATIONSHIP(chkNull(interfaceObj.getDateEndRelationship()));
				item.setADDRESS_TYPE(chkNull(interfaceObj.getAddressType()));
				item.setCONDITION_SPLIT(chkNull(interfaceObj.getConditionSplit()));
				item.setCONDITION_TYPE(chkNull(interfaceObj.getConditionType()));
				item.setCONDITION_PURPOSE(chkNull(interfaceObj.getConditionPurpose1()));
				item.setDATE_FROM_CONDITION(chkNull(interfaceObj.getDateFromCondition()));
				item.setDATE_UP_TO_CONDITION(chkNull(interfaceObj.getDateUpToCondition()));
				item.setCURRENCY_CONDITION(chkNull(interfaceObj.getCurrencyCondition()));
				item.setNO_POSTING_TERM(chkNull(interfaceObj.getNoPostingTerm()));
				item.setNO_FREQUENCY_TERM(chkNull(interfaceObj.getNoFrequencyTerm()));
				item.setNO_ORGANIZATIONAL_TERM(chkNull(interfaceObj.getNoOrganizationalTerm()));
				item.setCOST_CENTER(chkNull(interfaceObj.getCostCenter()));
				item.setPROFIT_CENTER(chkNull(interfaceObj.getProfitCenter()));
				item.setCALCULATION_FORMULA(chkNull(interfaceObj.getCalculationFormula()));
				item.setCURRENCY_UNIT_PRICE(new BigDecimal(chkDecimal(interfaceObj.getCurrencyUnitPrice())));
				item.setDISTRIBUTION_FORMULA(chkNull(interfaceObj.getDistributionFormla()));
				item.setCONDITIONS_EXTERNAL_PURPOSE(chkNull(interfaceObj.getConditionsExternalPurpose()));
				item.setCONDITION_ONE_TIME1(chkNull(interfaceObj.getConditionOneTime()));
				item.setSTATISTICAL_INFO_CONDITION1(chkNull(interfaceObj.getStatisticalInfoCondition()));
				item.setPOSTING_START_DATE_CONDITION(chkNull(interfaceObj.getFirstPostingFrom2()));
				item.setNO_OF_WHT_TERM(chkNull(interfaceObj.getNoOfWhtTerm()));
				item.setDIFFERENT_DUE_DATE_ONE_TIME(chkNull(interfaceObj.getDifferentDueDateOneTime()));
				item.setGRADING_TERM_IN_MONTHS(new BigInteger(chkDecimal(interfaceObj.getGradingTermInMonths())));
				item.setGRADING_INTERVAL_MONTHS(new BigInteger(chkDecimal(interfaceObj.getGradingIntervalInMonths())));
				item.setGRADING_PERCENT_INCREASE(new BigDecimal(chkDecimal(interfaceObj.getGradingPercentIncrease())));
				item.setGRADING_ABSOLUTE_INCREASE(new BigInteger(chkDecimal(interfaceObj.getGradingAbsoluteIncrease())));
				item.setCONTRACT_STATUS(chkNull(interfaceObj.getContractStatus()));
				item.setVALUATION_RULE(chkNull(interfaceObj.getValuationRule()));
				item.setOBJECT_ID(chkNull(interfaceObj.getObjectId()));
				item.setOBJECT_TYPE(chkNull(interfaceObj.getObjectType()));
				item.setOBJECT_VALID_FROM(chkNull(interfaceObj.getObjectValidFrom()));
				item.setOBJECT_VALID_TO(chkNull(interfaceObj.getObjectValidTo()));
				item.setSTART_DATE_OF_CONSIDERATION(chkNull(interfaceObj.getStartOfConsideration()));
				item.setFIRST_POSTING_FROM1(chkNull(interfaceObj.getFirstPostingFrom3()));
				item.setCLASSIFICATION(chkNull(interfaceObj.getClassification()));
				item.setINTEREST_RATE(new BigDecimal(chkDecimal(interfaceObj.getInterestRate())));
				item.setFREQUENCY_TERM(chkNull(interfaceObj.getFrequencyTerm()));
				item.setDISTRIBUT_FORMULA(chkNull(interfaceObj.getDistributFormula()));
				item.setDISTRIB_FORMULA_PARAMETER(chkNull(interfaceObj.getDistribFormulaParameter()));
				item.setPROBABLE_END(chkNull(interfaceObj.getProbableEnd()));
				item.setEND_OF_USAGE_ROU(chkNull(interfaceObj.getEndOfUsageRou()));
				item.setVALUATION_STATUS(chkNull(interfaceObj.getValuationStatus()));
				item.setVALUATION_BEHAVIOR(chkNull(interfaceObj.getValuationBehavior()));
				item.setCOMPANY_CODE(chkNull(interfaceObj.getCompanyCode2()));
				item.setASSET(chkNull(interfaceObj.getAsset()));
				item.setSUBNO(chkNull(interfaceObj.getSubno()));
				item.setOBJECT_DESCRIPTION(chkNull(interfaceObj.getObjectDescription()));
				item.setACCTASGOBJTYPE(chkNull(interfaceObj.getAcctasgobjtype()));
				item.setABSOLUTE_START(chkNull(interfaceObj.getAbsoluteStart()));
				item.setABSOLUTE_END(chkNull(interfaceObj.getAbsoluteEnd()));
				item.setCOND_VAL_PROPERTY(chkNull(interfaceObj.getCondValProperty()));
				item.setCOND_CONSIDERATION(chkNull(interfaceObj.getCondConsideration()));
				item.setCONSIDER_CONDITION(chkNull(interfaceObj.getConsiderCondition()));
				item.setPERCENTAGE(chkNull(interfaceObj.getPercentage()));
				item.setABSOLUTE_SHARE(chkNull(interfaceObj.getAbsoluteShare()));
				item.setCURRENCY(chkNull(interfaceObj.getCurrency()));
				item.setCONDITION_PURPOSE1(chkNull(interfaceObj.getConditionPurpose2()));
				item.setUNIT_PRICE1(new BigDecimal(chkDecimal(interfaceObj.getUnitPrice())));
				itemList.add(item);
			}
			
			XStream xstream = new XStream(new DomDriver("UTF8", new NoNameCoder()));
			xstream.alias("item", ZREIF_S_SEM_CONTRACT_CHANGE_IN.class);
			String xmlRequest = xstream.toXML(itemList).replaceAll("__","_").replaceAll("__hashCodeCalc","_hashCodeCalc");
			LOG.debug("xmlRequest : "  + xmlRequest);
			
			
			ZREIF_S_SEM_CONTRACT_CHANGE_IN[] items = new ZREIF_S_SEM_CONTRACT_CHANGE_IN[itemList.size()];
			items = itemList.toArray(items);
			
			params.setCONTRACT_DETAILS(items);

			// Send data to SAP web service.
			Z_RE_IF_SEM_CHANGEResponse response = service.SI_OB_Z_RE_IF_SEM_CHANGE(params);

			// Response from SAP web service.
			ZREIF_S_SEM_CHANGERESPONSE[] res = response.getCONTRACTRESPONSE();

			interfaceResponseList = new ArrayList<Mrt010IfrsInterface>();
			if (!interfaceList.isEmpty()) {
				for (int i = 0; i < res.length; i++) {
					String userId = "";
					int seq = 0;
					Mrt010IfrsInterface interfaceResponse = new Mrt010IfrsInterface();

					// Find userId
					for (int j = 0; j < interfaceList.size(); j++) {
						if (interfaceList.get(j).getReferenceId().trim().equals(res[i].getREFERENCE_ID().trim())) {
							userId = interfaceList.get(j).getUserId();
							if (StringUtils.isNotBlank(interfaceList.get(j).getResendSeq())) {
								seq = Integer.valueOf(interfaceList.get(j).getResendSeq());
							}
						}
					}

					interfaceResponse.setReferenceId(res[i].getREFERENCE_ID());
					interfaceResponse.setUserId(userId);
					interfaceResponse.setSapFilename(res[i].getFILENAME());
					interfaceResponse.setSapActivity(res[i].getACTIVITY());
					interfaceResponse.setSapReferenceId(res[i].getREFERENCE_ID());
					interfaceResponse.setSapCompanyCode(res[i].getCOMPANY_CODE());
					interfaceResponse.setSapContractNo(res[i].getCONTRACT_NO());
					interfaceResponse.setSapRefxNo(res[i].getREFX_NO());
					interfaceResponse.setSapStatusCode(res[i].getSTATUS_CODE());
					interfaceResponse.setSapErrorCode(res[i].getERROR_CODE());
					interfaceResponse.setSapStatusMessage(res[i].getSTATUS_MESSAGE());
					interfaceResponse.setRecordStatus("A");
					interfaceResponse.setResendSeq(String.valueOf(seq + 1));
					interfaceResponseList.add(interfaceResponse);
				}
				
				xstream = new XStream(new DomDriver("UTF-8", new NoNameCoder()));
				xstream.alias("item", ZREIF_S_SEM_CHANGERESPONSE.class);
				String xmlResponse = xstream.toXML(res).replaceAll("__","_").replaceAll("__hashCodeCalc","_hashCodeCalc");
				LOG.debug("xmlResponse : "  + xmlResponse);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(),e);
			interfaceResponseList = new ArrayList<Mrt010IfrsInterface>();
			for (int i = 0; i < interfaceList.size(); i++) {
				Mrt010IfrsInterface interfaceResponse = new Mrt010IfrsInterface();
				interfaceResponse.setReferenceId(interfaceList.get(i).getReferenceId());
				interfaceResponse.setUserId(interfaceList.get(i).getUserId());
				interfaceResponse.setSapStatusMessage("Message from java: " + e.getMessage());
				interfaceResponse.setRecordStatus("A");
				if (StringUtils.isNotBlank(interfaceList.get(i).getResendSeq())) {
					int seq = Integer.valueOf(interfaceList.get(i).getResendSeq());
					interfaceResponse.setResendSeq(String.valueOf(seq + 1));
				} else {
					interfaceResponse.setResendSeq(String.valueOf(1));
				}
				interfaceResponseList.add(interfaceResponse);
			}
		}
		return interfaceResponseList;
	}
	


	
	
}
