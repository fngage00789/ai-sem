package com.ais.sem.ifrs16.resend.tranfer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleTypes;

import com.ais.sem.ifrs16.resend.bean.Mrt010IfrsInterface;
import com.ais.sem.ifrs16.resend.db.ConnectDb;
import com.ais.sem.ifrs16.resend.util.Utilities;


public class IFRS16ResendSAP {
	
	private static String system = Utilities.getResources("system");
	
	public static void main(String[] args) {
		
		IFRS16ResendSAP test = new IFRS16ResendSAP();
		
		test.doProcess();
	}
	
	public void doProcess(){
		
		try {
			
			System.out.println("system : " + system);
			resendBatch();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void resendBatch(){
		try{
			
			String contractNo = null;
			List<String> contractList = null;
			List<Mrt010IfrsInterface> interfaceList = null;
			
			contractList = getContractToResend(contractNo);
			
			if(contractList != null && contractList.size() >0) {
				IFRS16Webservice service = new IFRS16Webservice();
				
				for(int i=0 ; i< contractList.size() ;i++) {
					interfaceList = getTransactionToResend(contractList.get(i));
					
					List<Mrt010IfrsInterface> interfacrResponse = service.callWS(interfaceList);
					if (!interfacrResponse.isEmpty()) {
						for (int m = 0; m < interfacrResponse.size(); m++) {
							try {
								interfacrResponse.get(m).setUserId("BATCH");
								
								updateResponse(interfacrResponse.get(m));
								
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private List<String> getContractToResend(String contractNo){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> contractList = new ArrayList<String>();
		try{
			con = ConnectDb.dbConnectSEM();
			
			String command = "{CALL SEM_IFRS_20_BATCH_RESEND_REFX(?,?)}";
			CallableStatement stmt = con.prepareCall (command);
			stmt.setString(2, contractNo);
			stmt.registerOutParameter(1, OracleTypes.CURSOR);
			stmt.execute();
			
			rs = (ResultSet) stmt.getObject(1);
			
			while(rs.next()){
				
				contractList.add(rs.getString("CONTRACT_NO"));
				
			}
			
		}catch (Exception e) {
			System.out.println("error : " + e);
			e.printStackTrace();		
		}finally {
			try {
				if (rs != null)	rs.close();
				if (pstmt != null)	pstmt.close();
				if (con != null){
					con.close();
				}
			} catch (Exception e) {
				System.out.println("error : " + e);
			} 
		}
		return contractList;
		
	}
	
	private List<Mrt010IfrsInterface> getTransactionToResend(String contractNo){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Mrt010IfrsInterface> interfaceList = new ArrayList<Mrt010IfrsInterface>();
		try{
			System.out.println("send contract no : " + contractNo);
			con = ConnectDb.dbConnectSEM();
			
			String command = "{CALL SEM_IFRS_20_BATCH_RESEND_REFX(?,?)}";
			CallableStatement stmt = con.prepareCall (command);
			stmt.setString(2, contractNo);
			stmt.registerOutParameter(1, OracleTypes.CURSOR);
			stmt.execute();
			
			rs = (ResultSet) stmt.getObject(1);
			
			while(rs.next()){
				
				Mrt010IfrsInterface obj = new Mrt010IfrsInterface();
				obj.setIfrsInterfaceId(rs.getString("IFRS_INTERFACE_ID"));
				obj.setSemConditionId(rs.getString("SEM_CONDITION_ID"));
				obj.setReferenceId(rs.getString("REFERENCE_ID"));
				obj.setSplitCase(rs.getString("SPLIT_CASE"));
				obj.setFileName(rs.getString("FILENAME"));
				obj.setActivity(rs.getString("ACTIVITY"));
				obj.setCompanyCode1(rs.getString("COMPANY_CODE1"));
				obj.setContractNo(rs.getString("CONTRACT_NO"));
				obj.setCompanyCodeMain(rs.getString("COMPANY_CODE_MAIN"));
				obj.setMainContractNo(rs.getString("MAIN_CONTRACT_NO"));
				obj.setOldContractNo(rs.getString("OLD_CONTRACT_NO"));
				obj.setContractType(rs.getString("CONTRACT_TYPE"));
				obj.setObjectDesc(rs.getString("OBJECT_DESC"));
				obj.setContractName(rs.getString("CONTRACT_NAME"));
				obj.setDateContractConclusion(rs.getString("DATE_CONTRACT_CONCLUSION"));
				obj.setDateContractStart(rs.getString("DATE_CONTRACT_START"));
				obj.setDateFirstContractEnd(rs.getString("DATE_FIRST_CONTRACT_END"));
				obj.setAuthorizationGroup(rs.getString("AUTHORIZATION_GROUP"));
				obj.setIndustry(rs.getString("INDUSTRY"));
				obj.setPersonResponsible(rs.getString("PERSON_RESPONSIBLE"));
				obj.setCasFlowStartingOn(rs.getString("CASH_FLOW_STARTING_ON"));
				obj.setFirstPostingFrom1(rs.getString("FIRST_POSTING_FROM1"));
				obj.setCurrencyForContract(rs.getString("CURRENCY_FOR_CONTRACT"));
				obj.setTypeOfRenewal(rs.getString("TYPE_OF_RENEWAL"));
				obj.setRenewalRulw(rs.getString("RENEWAL_RULE"));
				obj.setSequenceNo(rs.getString("SEQUENCE_NO"));
				obj.setNoOfRenewals(rs.getString("NO_OF_RENEWALS"));
				obj.setContractRenewedYears(rs.getString("CONTRACT_RENEWED_YEARS"));
				obj.setContractRenewedMonths(rs.getString("CONTRACT_RENEWED_MONTHS"));
				obj.setContractRenewedDays(rs.getString("CONTRACT_RENEWED_DAYS"));
				obj.setTypeOfAutomaticRenewal(rs.getString("TYPE_OF_AUTOMATIC_RENEWAL"));
				obj.setRenewalExecution(rs.getString("RENEWAL_EXECUTION"));
				obj.setTermNo1(rs.getString("TERM_NO1"));
				obj.setPaymentMethod(rs.getString("PAYMENT_METHOD"));
				obj.setPmtMethsupl(rs.getString("PMT_METHSUPL"));
				obj.setIndividSet(rs.getString("INDIVID_SET"));
				obj.setPaymentBlockKey(rs.getString("PAYMENT_BLOCK_KEY"));
				obj.setTermsOfPaymentKey(rs.getString("TERMS_OF_PAYMENT_KEY"));
				obj.setKeyForHouseBank(rs.getString("KEY_FOR_HOUSE_BANK"));
				obj.setBankDetailsId(rs.getString("BANK_DETAILS_ID"));
				obj.setNoteToPayee(rs.getString("NOTE_TO_PAYEE"));
				obj.setDunningArea(rs.getString("DUNNING_AREA"));
				obj.setDunningBlock(rs.getString("DUNNING_BLOCK"));
				obj.setAccountDetermination(rs.getString("ACCOUNT_DETERMINATION"));
				obj.setTaxType(rs.getString("TAX_TYPE"));
				obj.setTaxGroup(rs.getString("TAX_GROUP"));
				obj.setBusinessPartnerNo1(rs.getString("BUSINESS_PARTNER_NO1"));
				obj.setTermNo2(rs.getString("TERM_NO2"));
				obj.setNoFrequencyPeriod(rs.getString("NO_FREQUENCY_PERIOD"));
				obj.setFrequencyUnit(rs.getString("FREQUENCY_UNIT"));
				obj.setFrequencyStart(rs.getString("FREQUENCY_START"));
				obj.setPaymentForm(rs.getString("PAYMENT_FORM"));
				obj.setProrated(rs.getString("PRORATED"));
				obj.setCalculateMethod(rs.getString("CALCULATE_METHOD"));
				obj.setFactoryCalenda(rs.getString("FACTORY_CALENDAR"));
				obj.setBusinessPartnerNo2(rs.getString("BUSINESS_PARTNER_NO2"));
				obj.setBusinessPartnerRole(rs.getString("BUSINESS_PARTNER_ROLE"));
				obj.setDateStartRelationship(rs.getString("DATE_START_RELATIONSHIP"));
				obj.setDateEndRelationship(rs.getString("DATE_END_RELATIONSHIP"));
				obj.setAddressType(rs.getString("ADDRESS_TYPE"));
				obj.setConditionSplit(rs.getString("CONDITION_SPLIT"));
				obj.setConditionType(rs.getString("CONDITION_TYPE"));
				obj.setConditionPurpose1(rs.getString("CONDITION_PURPOSE1"));
				obj.setDateFromCondition(rs.getString("DATE_FROM_CONDITION"));
				obj.setDateUpToCondition(rs.getString("DATE_UP_TO_CONDITION"));
				obj.setCurrencyCondition(rs.getString("CURRENCY_CONDITION"));
				obj.setNoPostingTerm(rs.getString("NO_POSTING_TERM"));
				obj.setNoFrequencyTerm(rs.getString("NO_FREQUENCY_TERM"));
				obj.setNoOrganizationalTerm(rs.getString("NO_ORGANIZATIONAL_TERM"));
				obj.setCostCenter(rs.getString("COST_CENTER"));
				obj.setProfitCenter(rs.getString("PROFIT_CENTER"));
				obj.setCurrencyUnitPrice(rs.getString("CURRENCY_UNIT_PRICE"));
				obj.setCalculationFormula(rs.getString("CALCULATION_FORMULA"));
				obj.setDistributionFormla(rs.getString("DISTRIBUTION_FORMULA"));
				obj.setConditionsExternalPurpose(rs.getString("CONDITIONS_EXTERNAL_PURPOSE"));
				obj.setConditionOneTime(rs.getString("CONDITION_ONE_TIME"));
				obj.setStatisticalInfoCondition(rs.getString("STATISTICAL_INFO_CONDITION"));
				obj.setFirstPostingFrom2(rs.getString("FIRST_POSTING_FROM2"));
				obj.setNoOfWhtTerm(rs.getString("NO_OF_WHT_TERM"));
				obj.setDifferentDueDateOneTime(rs.getString("DIFFERENT_DUE_DATE_ONE_TIME"));
				obj.setGradingTermInMonths(rs.getString("GRADING_TERM_IN_MONTHS"));
				obj.setGradingIntervalInMonths(rs.getString("GRADING_INTERVAL_IN_MONTHS"));
				obj.setGradingPercentIncrease(rs.getString("GRADING_PERCENT_INCREASE"));
				obj.setGradingAbsoluteIncrease(rs.getString("GRADING_ABSOLUTE_INCREASE"));
				obj.setContractStatus(rs.getString("CONTRACT_STATUS"));
				obj.setValuationRule(rs.getString("VALUATION_RULE"));
				obj.setObjectId(rs.getString("OBJECT_ID"));
				obj.setObjectType(rs.getString("OBJECT_TYPE"));
				obj.setObjectValidFrom(rs.getString("OBJECT_VALID_FROM"));
				obj.setObjectValidTo(rs.getString("OBJECT_VALID_TO"));
				obj.setStartOfConsideration(rs.getString("START_OF_CONSIDERATION"));
				obj.setFirstPostingFrom3(rs.getString("FIRST_POSTING_FROM3"));
				obj.setClassification(rs.getString("CLASSIFICATION"));
				obj.setInterestRate(rs.getString("INTEREST_RATE"));
				obj.setFrequencyTerm(rs.getString("FREQUENCY_TERM"));
				obj.setDistributFormula(rs.getString("DISTRIBUT_FORMULA"));
				obj.setDistribFormulaParameter(rs.getString("DISTRIB_FORMULA_PARAMETER"));
				obj.setProbableEnd(rs.getString("PROBABLE_END"));
				obj.setEndOfUsageRou(rs.getString("END_OF_USAGE_ROU"));
				obj.setValuationStatus(rs.getString("VALUATION_STATUS"));
				obj.setValuationBehavior(rs.getString("VALUATION_BEHAVIOR"));
				obj.setCompanyCode2(rs.getString("COMPANY_CODE2"));
				obj.setAsset(rs.getString("ASSET"));
				obj.setSubno(rs.getString("SUBNO"));
				obj.setObjectDescription(rs.getString("OBJECT_DESCRIPTION"));
				obj.setAcctasgobjtype(rs.getString("ACCTASGOBJTYPE"));
				obj.setAbsoluteStart(rs.getString("ABSOLUTE_START"));
				obj.setAbsoluteEnd(rs.getString("ABSOLUTE_END"));
				obj.setCondValProperty(rs.getString("COND_VAL_PROPERTY"));
				obj.setCondConsideration(rs.getString("COND_CONSIDERATION"));
				obj.setConsiderCondition(rs.getString("CONSIDER_CONDITION"));
				obj.setPercentage(rs.getString("PERCENTAGE"));
				obj.setAbsoluteShare(rs.getString("ABSOLUTE_SHARE"));
				obj.setCurrency(rs.getString("CURRENCY"));
				obj.setConditionPurpose2(rs.getString("CONDITION_PURPOSE2"));
				obj.setUnitPrice(rs.getString("UNIT_PRICE"));
				obj.setUpdateBy(rs.getString("UPDATE_BY"));
				obj.setUpdateDt(rs.getDate("UPDATE_DT"));
				obj.setSapFilename(rs.getString("SAP_FILENAME"));
				obj.setSapActivity(rs.getString("SAP_ACTIVITY"));
				obj.setSapReferenceId(rs.getString("SAP_REFERENCE_ID"));
				obj.setSapCompanyCode(rs.getString("SAP_COMPANY_CODE"));
				obj.setSapContractNo(rs.getString("SAP_CONTRACT_NO"));
				obj.setSapRefxNo(rs.getString("SAP_REFX_NO"));
				obj.setSapStatusCode(rs.getString("SAP_STATUS_CODE"));
				obj.setSapErrorCode(rs.getString("SAP_ERROR_CODE"));
				obj.setSapStatusMessage(rs.getString("SAP_STATUS_MESSAGE"));
				obj.setRecordStatus(rs.getString("RECORD_STATUS"));
				obj.setResendSeq(rs.getString("RESEND_SEQ"));
				
				interfaceList.add(obj);
			}
			
		}catch (Exception e) {
			System.out.println("error : " + e);
			e.printStackTrace();		
		}finally {
			try {
				if (rs != null)	rs.close();
				if (pstmt != null)	pstmt.close();
				if (con != null){
					con.close();
				}
			} catch (Exception e) {
				System.out.println("error : " + e);
			} 
		}
		return interfaceList;
		
	}
	
	private void updateResponse (Mrt010IfrsInterface obj){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			System.out.println("Update interface contract no : " + obj.getSapContractNo());
			con = ConnectDb.dbConnectSEM();
			
			String command = "{CALL SEM_IFRS_20_UPD_INTERFACE(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			CallableStatement stmt = con.prepareCall (command);
			
			stmt.registerOutParameter(1, OracleTypes.CURSOR);
			stmt.setString(2, obj.getReferenceId());
			stmt.setString(3, obj.getUserId());
			stmt.setString(4, obj.getSapFilename());
			stmt.setString(5, obj.getSapActivity());
			stmt.setString(6, obj.getSapReferenceId());
			stmt.setString(7, obj.getSapCompanyCode());
			stmt.setString(8, obj.getSapContractNo());
			stmt.setString(9, obj.getSapRefxNo());
			stmt.setString(10, obj.getSapStatusCode());
			stmt.setString(11, obj.getSapErrorCode());
			stmt.setString(12, obj.getSapStatusMessage());
			stmt.setString(13, obj.getRecordStatus());
			stmt.setString(14, obj.getResendSeq());
			
			stmt.execute();
			
			rs = (ResultSet) stmt.getObject(1);
			
			while(rs.next()){
				
				System.out.println("RESULT : " + rs.getString("P_RESULT"));
				System.out.println("REMARK : " + rs.getString("P_REMARK"));
				
			}
			
		}catch (Exception e) {
			System.out.println("error : " + e);
			e.printStackTrace();		
		}finally {
			try {
				if (rs != null)	rs.close();
				if (pstmt != null)	pstmt.close();
				if (con != null){
					con.close();
				}
			} catch (Exception e) {
				System.out.println("error : " + e);
			} 
		}
		
	}
	
}
