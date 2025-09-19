package com.ais.sem.ifrs16.resend.tranfer;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.Call;

import org.apache.commons.lang.StringUtils;


import com.ais.sem.ifrs16.http.EngineUtilities;
import com.ais.sem.ifrs16.resend.bean.Mrt010IfrsInterface;
import com.ais.sem.ifrs16.resend.util.Utilities;
import com.ais.sem.ifrs16.webservice.cresem.SI_OB_Z_RE_IF_SEM_CREATE;
import com.ais.sem.ifrs16.webservice.cresem.SI_OB_Z_RE_IF_SEM_CREATEServiceLocator;
import com.ais.sem.ifrs16.webservice.cresem.bean.ZREIF_S_CONTRACTRESPONSE;
import com.ais.sem.ifrs16.webservice.cresem.bean.ZREIF_S_CONTRACTTEMPLATE_INTER;
import com.ais.sem.ifrs16.webservice.cresem.bean.Z_RE_IF_SEM_CREATE;
import com.ais.sem.ifrs16.webservice.cresem.bean.Z_RE_IF_SEM_CREATEResponse;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class IFRS16Webservice {
	
	private static String _user_ifrs = Utilities.getResources("ws_ifrs_user");
	private static String _pass_ifrs = Utilities.getResources("ws_ifrs_pass");
	
	public List<Mrt010IfrsInterface> callWS(List<Mrt010IfrsInterface> interfaceList){
		
		List<Mrt010IfrsInterface> interfaceResponseList = null;
		try{
			
			
			SI_OB_Z_RE_IF_SEM_CREATEServiceLocator locator = new SI_OB_Z_RE_IF_SEM_CREATEServiceLocator(EngineUtilities
					.getEngineConfiguration());
			locator.setHTTPS_PortEndpointAddress(Utilities.getResources("ws_sap_enpoint"));
			System.out.println("End point : " + Utilities.getResources("ws_sap_enpoint"));
			SI_OB_Z_RE_IF_SEM_CREATE service = locator.getHTTPS_Port();

			// to use Basic HTTP Authentication:
			((javax.xml.rpc.Stub) service)._setProperty(Call.USERNAME_PROPERTY, _user_ifrs);
			((javax.xml.rpc.Stub) service)._setProperty(Call.PASSWORD_PROPERTY, _pass_ifrs);

			// Prepare parameter before send.
			Z_RE_IF_SEM_CREATE params = new Z_RE_IF_SEM_CREATE();
			
			
			List<ZREIF_S_CONTRACTTEMPLATE_INTER> itemList = convertListToRequest(interfaceList);
			
			XStream xstream = new XStream(new DomDriver());
			xstream.alias("item", ZREIF_S_CONTRACTTEMPLATE_INTER.class);
			String xmlRequest = xstream.toXML(itemList).replaceAll("__","_").replaceAll("__hashCodeCalc","_hashCodeCalc");
			System.out.println("xmlRequest : ");
			System.out.println(xmlRequest);
			
			ZREIF_S_CONTRACTTEMPLATE_INTER[] items = new ZREIF_S_CONTRACTTEMPLATE_INTER[itemList.size()];
			items = itemList.toArray(items);
			
			params.setCONTRACT_DETAILS1(items);

			// Send data to SAP web service.
			Z_RE_IF_SEM_CREATEResponse response = service.SI_OB_Z_RE_IF_SEM_CREATE(params);
			
			// Response from SAP web service.
			com.ais.sem.ifrs16.webservice.cresem.bean.ZREIF_S_CONTRACTRESPONSE[] res = response.getCONTRACTRESPONSE();

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
				System.out.println("xmlResponse : ");
				System.out.println(xmlResponse);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
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
	
	private List<ZREIF_S_CONTRACTTEMPLATE_INTER> convertListToRequest(List<Mrt010IfrsInterface> interfaceList){
		
		List<ZREIF_S_CONTRACTTEMPLATE_INTER> itemList = new ArrayList<ZREIF_S_CONTRACTTEMPLATE_INTER>();
		
		for(int i=0 ;i<interfaceList.size() ;i++) {
			
			Mrt010IfrsInterface interfaceObj = interfaceList.get(i);
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
			
		return itemList;
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
}
