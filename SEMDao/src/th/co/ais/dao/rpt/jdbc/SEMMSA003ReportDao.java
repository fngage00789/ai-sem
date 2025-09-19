package th.co.ais.dao.rpt.jdbc;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.domain.sa.SiteAppReportObj;
import th.co.ais.rpt.domain.SEMECO001Domain;
import th.co.ais.rpt.domain.SEMMSA003Domain;
import th.co.ais.util.EQueryName;

public class SEMMSA003ReportDao extends AbstractHibernateDAO<SEMMSA003Domain>{
	private Logger log = Logger.getLogger(getClass());
	
	public ResultSet executeRS(Map<String, Object> criteria) throws Exception{
		Connection connection = null;
		CallableStatement cstmt = null;
		ResultSet rs = null ;
		try{
			connection = getSessionFactory().getCurrentSession().connection();
			
			cstmt = connection.prepareCall("call SEM_PG_MSA003_SEARCH_FOR_PRINT(?, ?)");
			cstmt.setFetchSize(100);
			cstmt.setObject(1, null);
			cstmt.registerOutParameter(1, Types.OTHER);
			cstmt.setString(2, (String) criteria.get("PARAM_CONTRACT_ID"));
			//cstmt.executeQuery();
			cstmt.execute();
			rs = (ResultSet) cstmt.getObject(1);
			System.out.println("SEMMSA003ReportDao PARAM_CONTRACT_ID "+criteria.get("PARAM_CONTRACT_ID"));
		
		}catch (Exception e) {	
			
			e.printStackTrace();
		}finally{
			if(connection != null) connection.close();
			//if(cstmt != null) cstmt.close();
		}

		//return  (ResultSet) cstmt.getObject(1);
		return  rs;
	}
	
	public SEMMSA003Domain execute(Map<String, Object> criteria) throws Exception {
		ResultSet rs = this.executeRS(criteria);
		String siteAppId = (String) criteria.get("PARAM_CONTRACT_ID");
		String docType = (String) criteria.get("PARAM_CONTRACT_TYPE");
		SEMMSA003Domain vo = null;

		if (rs != null) {
			rs.next();
			vo = new SEMMSA003Domain();
			if(rs.getString("SITE_APP_ID")!=null)vo.setRowId(rs.getString("SITE_APP_ID"));
			if(rs.getString("SITE_APP_ID")!=null)vo.setSiteAppId(rs.getString("SITE_APP_ID"));
			if(rs.getString("CONTRACT_ID")!=null)vo.setContractId(rs.getString("CONTRACT_ID"));
			if(rs.getBigDecimal("CONTRACT_TIME")!=null)vo.setContractTime(rs.getBigDecimal("CONTRACT_TIME"));
			if(rs.getBigDecimal("CONTRACT_TIME_SEQ")!=null)vo.setContractTimeSeq(rs.getBigDecimal("CONTRACT_TIME_SEQ"));
			if(rs.getString("CONTRACT_NO")!=null)vo.setContractNo(rs.getString("CONTRACT_NO"));
			if(rs.getString("REQ_TYPE")!=null)vo.setReqType(rs.getString("REQ_TYPE"));
			if(rs.getString("REQ_DOC_TYPE")!=null)vo.setReqDocType(rs.getString("REQ_DOC_TYPE"));
			if(rs.getString("TITLE")!=null)vo.setTitle(rs.getString("TITLE"));
			if(rs.getString("REQ_OFFICER")!=null)vo.setReqOfficer(rs.getString("REQ_OFFICER"));
			if(rs.getString("REQ_OFFICER_MANUAL")!=null)vo.setReqOfficerManual(rs.getString("REQ_OFFICER_MANUAL"));
			if(rs.getString("COMPANY")!=null)vo.setCompany(rs.getString("COMPANY"));
			if(rs.getString("REGION")!=null)vo.setRegion(rs.getString("REGION"));
			if(rs.getString("DOC_NO")!=null)vo.setDocNo(rs.getString("DOC_NO"));
			if(rs.getDate("DOC_DT")!=null)vo.setDocDt(rs.getDate("DOC_DT"));
			if(rs.getString("DOC_STATUS")!=null)vo.setDocStatus(rs.getString("DOC_STATUS"));
			if(rs.getString("NEED_LEGAL_APPROVE")!=null)vo.setNeedLegApprove(rs.getString("NEED_LEGAL_APPROVE"));
			if(rs.getString("NEED_AVP_APPROVE")!=null)vo.setNeedAVPApprove(rs.getString("NEED_AVP_APPROVE"));
			if(rs.getString("LOCATION_ID")!=null)vo.setLocationId(rs.getString("LOCATION_ID"));
			if(rs.getString("LOCATION_ZONE")!=null)vo.setLocationZone(rs.getString("LOCATION_ZONE"));
			if(rs.getString("IS_CO_LOCATE")!=null)vo.setIsCoLocate(rs.getString("IS_CO_LOCATE"));
			if(rs.getString("CO_CONTRACT_NO")!=null)vo.setCoContractNo(rs.getString("CO_CONTRACT_NO"));
			if(rs.getString("TERMINATE_REASON")!=null)vo.setTerminateReason(rs.getString("TERMINATE_REASON"));
			if(rs.getString("TERMINATE_REMOVE_FLAG")!=null)vo.setTerminateRemoveFlag(rs.getString("TERMINATE_REMOVE_FLAG"));
			if(rs.getDate("TERMINATE_REMOVE_DT")!=null)vo.setTerminateRemoveDt(rs.getDate("TERMINATE_REMOVE_DT"));
			if(rs.getDate("TERMINATE_REMOVE_END_DT")!=null)vo.setTerminateRemoveEndDt(rs.getDate("TERMINATE_REMOVE_END_DT"));
			if(rs.getString("TERMINATE_CANCEL_RELATE_DATA")!=null)vo.setTerminateCancelRalateData(rs.getString("TERMINATE_CANCEL_RELATE_DATA"));
			if(rs.getString("TERMINATE_NOTE")!=null)vo.setTerminateNote(rs.getString("TERMINATE_NOTE"));
			if(rs.getString("LOCATION_CODE")!=null)vo.setLocationCode(rs.getString("LOCATION_CODE"));
			if(rs.getString("LOCATION_TYPE")!=null)vo.setLocationType(rs.getString("LOCATION_TYPE"));
			if(rs.getString("LOCATION_ADDRESS_NO")!=null)vo.setLocationAddressNo(rs.getString("LOCATION_ADDRESS_NO"));
			if(rs.getString("LOCATION_BUILDING")!=null)vo.setLocationBuilding(rs.getString("LOCATION_BUILDING"));
			if(rs.getString("LOCATION_FLOOR")!=null)vo.setLocationFloor(rs.getString("LOCATION_FLOOR"));
			if(rs.getString("LOCATION_ROOM_NO")!=null)vo.setLocationRoomNo(rs.getString("LOCATION_ROOM_NO"));
			if(rs.getString("LOCATION_STREET")!=null)vo.setLocationStreet(rs.getString("LOCATION_STREET"));
			if(rs.getString("LOCATION_TAMBON")!=null)vo.setLocationTambon(rs.getString("LOCATION_TAMBON"));
			if(rs.getString("LOCATION_AMPHUR_ID")!=null)vo.setLocationAmphurId(rs.getString("LOCATION_AMPHUR_ID"));
			if(rs.getString("LOCATION_PROVINCE_ID")!=null)vo.setLocationProvinceId(rs.getString("LOCATION_PROVINCE_ID"));
			if(rs.getString("LOCATION_POSTCODE")!=null)vo.setLocationPostcode(rs.getString("LOCATION_POSTCODE"));
			if(rs.getBigDecimal("LAND_AREA")!=null)vo.setLandArea(rs.getBigDecimal("LAND_AREA"));
			if(rs.getString("LAND_AREA_TYPE")!=null)vo.setLandAreaType(rs.getString("LAND_AREA_TYPE"));
			if(rs.getBigDecimal("DECK_AREA")!=null)vo.setDeckArea(rs.getBigDecimal("DECK_AREA"));
			if(rs.getBigDecimal("BUILDING_AREA")!=null)vo.setBuildingArea(rs.getBigDecimal("BUILDING_AREA"));
			if(rs.getBigDecimal("ROOM_AREA")!=null)vo.setRoomArea(rs.getBigDecimal("ROOM_AREA"));
			if(rs.getString("AREA_REMARK")!=null)vo.setAreaRemark(rs.getString("AREA_REMARK"));
			if(rs.getString("CHANGE_EFFECTIVE_DT")!=null)vo.setChangeEffectiveDtStr(rs.getString("CHANGE_EFFECTIVE_DT"));
			if(rs.getDate("EFFECTIVE_DT")!=null)vo.setEffectiveDt(rs.getDate("EFFECTIVE_DT"));
			if(rs.getDate("EXPIRE_DT")!=null)vo.setExpireDt(rs.getDate("EXPIRE_DT"));
			if(rs.getString("EXPIRE_TXT")!=null)vo.setExpireDtTxt(rs.getString("EXPIRE_TXT"));
			if(rs.getBigDecimal("AGE_YEAR")!=null)vo.setAgeYear(rs.getBigDecimal("AGE_YEAR"));
			if(rs.getBigDecimal("AGE_MONTH")!=null)vo.setAgeMonth(rs.getBigDecimal("AGE_MONTH"));
			if(rs.getBigDecimal("AGE_DAY")!=null)vo.setAgeDay(rs.getBigDecimal("AGE_DAY"));
			if(rs.getString("CONTRACT_WANTED")!=null)vo.setContractWanted(rs.getString("CONTRACT_WANTED"));
			if(rs.getBigDecimal("PROMISE_RENEW_TIME")!=null)vo.setPromiseRenewTime(rs.getBigDecimal("PROMISE_RENEW_TIME"));
			if(rs.getBigDecimal("PROMISE_RENEW_PERIOD")!=null)vo.setPromiseRenewPeriod(rs.getBigDecimal("PROMISE_RENEW_PERIOD"));
			if(rs.getString("PROMISE_RENEW_PERIOD_TYPE")!=null)vo.setPromiseRenewPeriodType(rs.getString("PROMISE_RENEW_PERIOD_TYPE"));
			if(rs.getString("LESSOR_NAME")!=null)vo.setLessorName(rs.getString("LESSOR_NAME"));
			if(rs.getString("LESSOR_HOUSE_NO")!=null)vo.setLessorHouseNo(rs.getString("LESSOR_HOUSE_NO"));
			if(rs.getString("LESSOR_BUILDING")!=null)vo.setLessorBuilding(rs.getString("LESSOR_BUILDING"));
			if(rs.getString("LESSOR_FLOOR")!=null)vo.setLessorFloor(rs.getString("LESSOR_FLOOR"));
			if(rs.getString("LESSOR_ROOM_NO")!=null)vo.setLessorRoomNo(rs.getString("LESSOR_ROOM_NO"));
			if(rs.getString("LESSOR_STREET")!=null)vo.setLessorStreet(rs.getString("LESSOR_STREET"));
			if(rs.getString("LESSOR_TAMBON")!=null)vo.setLessorTambon(rs.getString("LESSOR_TAMBON"));
			if(rs.getString("LESSOR_AMPHUR_ID")!=null)vo.setLessorAmphurId(rs.getString("LESSOR_AMPHUR_ID"));
			if(rs.getString("LESSOR_PROVINCE_ID")!=null)vo.setLessorProvinceId(rs.getString("LESSOR_PROVINCE_ID"));
			if(rs.getString("LESSOR_POSTCODE")!=null)vo.setPostCode(rs.getString("LESSOR_POSTCODE"));
			if(rs.getString("CONTACT_NAME")!=null)vo.setContactName(rs.getString("CONTACT_NAME"));
			if(rs.getString("CONTACT_TEL")!=null)vo.setContactTel(rs.getString("CONTACT_TEL"));
			if(rs.getString("CONTACT_MOBILE")!=null)vo.setContactMobile(rs.getString("CONTACT_MOBILE"));
			if(rs.getString("CONTACT_FAX")!=null)vo.setContactFax(rs.getString("CONTACT_FAX"));
			if(rs.getString("CONTACT_EMAIL")!=null)vo.setContactEmail(rs.getString("CONTACT_EMAIL"));
			if(rs.getBigDecimal("RENT_AMT")!=null)vo.setRentAMT(rs.getBigDecimal("RENT_AMT"));
			if(rs.getString("RENT_PERIOD_TYPE")!=null)vo.setRentPeriodType(rs.getString("RENT_PERIOD_TYPE"));
			if(rs.getString("RENT_DETAIL")!=null)vo.setRentDetail(rs.getString("RENT_DETAIL"));
			if(rs.getString("RENT_WHT_TYPE")!=null)vo.setRentWhtType(rs.getString("RENT_WHT_TYPE"));
			if(rs.getBigDecimal("RENT_WHT_RATE")!=null)vo.setRentWhtRate(rs.getBigDecimal("RENT_WHT_RATE"));
			if(rs.getString("RENT_WHT_RATE_MOD")!=null)vo.setRentWhtRateMod(rs.getString("RENT_WHT_RATE_MOD"));
			if(rs.getBigDecimal("RENT_SERVICE_AMT")!=null)vo.setRentServiceAmt(rs.getBigDecimal("RENT_SERVICE_AMT"));
			if(rs.getString("RENT_SERVICE_PERIOD_TYPE")!=null)vo.setRentServicePeriodType(rs.getString("RENT_SERVICE_PERIOD_TYPE"));
			if(rs.getString("RENT_SERVICE_DETAIL")!=null)vo.setRentServiceDetail(rs.getString("RENT_SERVICE_DETAIL"));
			if(rs.getString("RENT_SERVICE_VAT_TYPE")!=null)vo.setRentServiceVatType(rs.getString("RENT_SERVICE_VAT_TYPE"));
			if(rs.getString("RENT_SERVICE_WHT_TYPE")!=null)vo.setRentServiceWhtType(rs.getString("RENT_SERVICE_WHT_TYPE"));
			if(rs.getBigDecimal("RENT_SERVICE_WHT_RATE")!=null)vo.setRentServiceWhtRate(rs.getBigDecimal("RENT_SERVICE_WHT_RATE"));
			if(rs.getString("RENT_SERVICE_WHT_RATE_MOD")!=null)vo.setRentServiceWhtRateMod(rs.getString("RENT_SERVICE_WHT_RATE_MOD"));
			if(rs.getString("RENT_AREA_AMT_MEMO")!=null)vo.setRentAreaAmtMemo(rs.getString("RENT_AREA_AMT_MEMO"));
			if(rs.getString("RENT_SERVICE_AMT_MEMO")!=null)vo.setRentServiceAmtMemo(rs.getString("RENT_SERVICE_AMT_MEMO"));
			if(rs.getString("RENT_SETUP_AMT_MEMO")!=null)vo.setRentSetupAmtMemo(rs.getString("RENT_SETUP_AMT_MEMO"));
			if(rs.getString("RENT_OTHER_AMT_MEMO")!=null)vo.setRentOtherAmtMemo(rs.getString("RENT_OTHER_AMT_MEMO"));
			if(rs.getString("RENT_SPECIAL_AMT_MEMO")!=null)vo.setRentSpacialAmtMemo(rs.getString("RENT_SPECIAL_AMT_MEMO"));
			if(rs.getBigDecimal("TOTAL_RENT_SERVICE")!=null)vo.setTotalRentService(rs.getBigDecimal("TOTAL_RENT_SERVICE"));
			if(rs.getString("RENT_PAYMENT_PERIOD")!=null)vo.setRentPaymentPeriod(rs.getString("RENT_PAYMENT_PERIOD"));
			if(rs.getString("RENT_PAYMENT_PERIOD_OTH")!=null)vo.setRentPaymentPeriodOTH(rs.getString("RENT_PAYMENT_PERIOD_OTH"));
			if(rs.getString("SERVICE_PAYMENT_PERIOD")!=null)vo.setServPaymentPeriod(rs.getString("SERVICE_PAYMENT_PERIOD"));
			if(rs.getString("SERVICE_PAYMENT_PERIOD_OTH")!=null)vo.setServPaymentPeriodOTH(rs.getString("SERVICE_PAYMENT_PERIOD_OTH"));
			if(rs.getString("RENT_DEPOSIT_FLAG")!=null)vo.setRentDepositFlag(rs.getString("RENT_DEPOSIT_FLAG"));
			if(rs.getBigDecimal("RENT_DEPOSIT_BG_AMT")!=null)vo.setRentDepositBGAmt(rs.getBigDecimal("RENT_DEPOSIT_BG_AMT"));
			if(rs.getString("RENT_DEPOSIT_BG_VAT")!=null)vo.setRentDepositBGVat(rs.getString("RENT_DEPOSIT_BG_VAT"));
			if(rs.getBigDecimal("RENT_DEPOSIT_CASH_AMT")!=null)vo.setRentDepositCashAmt(rs.getBigDecimal("RENT_DEPOSIT_CASH_AMT"));
			if(rs.getString("RENT_DEPOSIT_CASH_VAT")!=null)vo.setRentDepositCashVat(rs.getString("RENT_DEPOSIT_CASH_VAT"));
			if(rs.getString("RENT_REMARK")!=null)vo.setRentRemark(rs.getString("RENT_REMARK"));
			if(rs.getString("EL_USE_MULTI_RESOURSE")!=null)vo.setElUseMultiResourse(rs.getString("EL_USE_MULTI_RESOURSE"));
			if(rs.getString("EL_USE_NEW_METER")!=null)vo.setElUseNewMeter(rs.getString("EL_USE_NEW_METER"));
			if(rs.getString("EL_USE_OLD_METER")!=null)vo.setElUseOldMeter(rs.getString("EL_USE_OLD_METER"));
			if(rs.getString("EL_USE_OWNER")!=null)vo.setElUseOwner(rs.getString("EL_USE_OWNER"));
			if(rs.getString("EL_OWNER_TYPE")!=null)vo.setElOwnerType(rs.getString("EL_OWNER_TYPE"));
			if(rs.getString("EL_PAY_ON_PACKAGE")!=null)vo.setElPayOnPackage(rs.getString("EL_PAY_ON_PACKAGE"));
			if(rs.getString("EL_PACKAGE_PERIOD_TYPE")!=null)vo.setElPackagePeriodType(rs.getString("EL_PACKAGE_PERIOD_TYPE"));
			if(rs.getString("EL_PAY_ON_USED")!=null)vo.setElPayOnUsed(rs.getString("EL_PAY_ON_USED"));
			if(rs.getBigDecimal("EL_UNIT_PRICE")!=null)vo.setElUnitPrice(rs.getBigDecimal("EL_UNIT_PRICE"));
			if(rs.getString("EL_VAT_TYPE")!=null)vo.setElVatType(rs.getString("EL_VAT_TYPE"));
			if(rs.getString("EL_REMARK")!=null)vo.setElRemark(rs.getString("EL_REMARK"));
			if(rs.getString("EL_DEPOSIT_FLAG")!=null)vo.setElDepositFlag(rs.getString("EL_DEPOSIT_FLAG"));
			if(rs.getBigDecimal("EL_BG_DEPOSIT")!=null)vo.setElBGDeposit(rs.getBigDecimal("EL_BG_DEPOSIT"));
			if(rs.getString("EL_BG_DEPOSIT_VAT_TYPE")!=null)vo.setElBGDepositVatType(rs.getString("EL_BG_DEPOSIT_VAT_TYPE"));
			if(rs.getBigDecimal("EL_CASH_DEPOSIT")!=null)vo.setElCashDeposit(rs.getBigDecimal("EL_CASH_DEPOSIT"));
			if(rs.getString("EL_CASH_DEPOSIT_VAT_TYPE")!=null)vo.setElCashDepositVatType(rs.getString("EL_CASH_DEPOSIT_VAT_TYPE"));
			if(rs.getString("EL_DEPOSIT_REMARK")!=null)vo.setElDepositRemark(rs.getString("EL_DEPOSIT_REMARK"));
			if(rs.getString("REMARK_SPECIAL")!=null)vo.setRemarkSpacial(rs.getString("REMARK_SPECIAL"));
			if(rs.getString("REMARK_DOCUMENTS")!=null)vo.setRemarkDocuments(rs.getString("REMARK_DOCUMENTS"));
			if(rs.getString("REMARK_CONTRACT")!=null)vo.setRemarkContract(rs.getString("REMARK_CONTRACT"));
			if(rs.getString("REMARK_AQM")!=null)vo.setRemarkAQM(rs.getString("REMARK_AQM"));
			if(rs.getString("REMARK_RISK")!=null)vo.setRemarkRisk(rs.getString("REMARK_RISK"));
			if(rs.getString("REMARK_LEGAL")!=null)vo.setRemarkLegal(rs.getString("REMARK_LEGAL"));
			if(rs.getString("REMARK_OTHER")!=null)vo.setRemarkOther(rs.getString("REMARK_OTHER"));
			if(rs.getString("PT_TAX_PAY_TYPE")!=null)vo.setPtTaxPayType(rs.getString("PT_TAX_PAY_TYPE"));
			if(rs.getString("PT_REMARK")!=null)vo.setPTRemark(rs.getString("PT_REMARK"));
			if(rs.getString("INS_FLAG")!=null)vo.setInsFlag(rs.getString("INS_FLAG"));
			if(rs.getBigDecimal("INS_SUM_INSURED")!=null)vo.setInsSumInsured(rs.getBigDecimal("INS_SUM_INSURED"));
			if(rs.getDate("INS_EFFECTIVE_DT")!=null)vo.setInsEffectiveDT(rs.getDate("INS_EFFECTIVE_DT"));
			if(rs.getDate("INS_EXPIRE_DT")!=null)vo.setInsExpireDT(rs.getDate("INS_EXPIRE_DT"));
			if(rs.getString("INS_BENEFICIARY")!=null)vo.setInsBeneficiary(rs.getString("INS_BENEFICIARY"));
			if(rs.getDate("ASSIGN_DT")!=null)vo.setAssignDT(rs.getDate("ASSIGN_DT"));
			if(rs.getString("ASSIGN_BY")!=null)vo.setAssignBy(rs.getString("ASSIGN_BY"));
			if(rs.getString("ASSIGN_TO_USER")!=null)vo.setAssignToUser(rs.getString("ASSIGN_TO_USER"));
			if(rs.getDate("LEADER_APPROVE_DT")!=null)vo.setLeaderApproveDT(rs.getDate("LEADER_APPROVE_DT"));
			if(rs.getString("LEADER_APPROVE_BY")!=null)vo.setLeaderApproveBy(rs.getString("LEADER_APPROVE_BY"));
			if(rs.getString("LEADER_APPROVE_REMARK")!=null)vo.setLeaderApproveRemark(rs.getString("LEADER_APPROVE_REMARK"));
			if(rs.getDate("MANAGER_APPROVE_DT")!=null)vo.setManagerApproveDT(rs.getDate("MANAGER_APPROVE_DT"));
			if(rs.getString("MANAGER_APPROVE_BY")!=null)vo.setManagerApproveBy(rs.getString("MANAGER_APPROVE_BY"));
			if(rs.getString("MANAGER_APPROVE_REMARK")!=null)vo.setManagerApproveRemark(rs.getString("MANAGER_APPROVE_REMARK"));
			if(rs.getDate("LEGAL_APPROVE_DT")!=null)vo.setLegalApproveDT(rs.getDate("LEGAL_APPROVE_DT"));
			if(rs.getString("LEGAL_APPROVE_BY")!=null)vo.setLegalApproveBy(rs.getString("LEGAL_APPROVE_BY"));
			if(rs.getString("LEGAL_APPROVE_REMARK")!=null)vo.setLegalApproveRemark(rs.getString("LEGAL_APPROVE_REMARK"));
			if(rs.getDate("AVP_APPROVE_DT")!=null)vo.setAvpApproveDT(rs.getDate("AVP_APPROVE_DT"));
			if(rs.getString("AVP_APPROVE_BY")!=null)vo.setAvpApproveBy(rs.getString("AVP_APPROVE_BY"));
			if(rs.getString("AVP_APPROVE_REMARK")!=null)vo.setAvpApproveRemark(rs.getString("AVP_APPROVE_REMARK"));
			if(rs.getString("FLOW_STATUS")!=null)vo.setFlowStatus(rs.getString("FLOW_STATUS"));
			if(rs.getString("RECORD_STATUS")!=null)vo.setRecordStatus(rs.getString("RECORD_STATUS"));
			if(rs.getString("BATCH_NO")!=null)vo.setBatchNo(rs.getString("BATCH_NO"));
			if(rs.getDate("BATCH_DT")!=null)vo.setBatchDT(rs.getDate("BATCH_DT"));
			if(rs.getString("LOCATION_EDIT_FLAG")!=null)vo.setLocationEditFlag(rs.getString("LOCATION_EDIT_FLAG"));
			if(rs.getString("CONTRACT_EDIT_FLAG")!=null)vo.setContractEditFlag(rs.getString("CONTRACT_EDIT_FLAG"));
			if(rs.getString("RENT_EDIT_FLAG")!=null)vo.setRentEditFlag(rs.getString("RENT_EDIT_FLAG"));
			if(rs.getString("RENT_DEPOSIT_EDIT_FLAG")!=null)vo.setRentPositionEditFlag(rs.getString("RENT_DEPOSIT_EDIT_FLAG"));
			if(rs.getString("EL_EDIT_FLAG")!=null)vo.setElEditFlag(rs.getString("EL_EDIT_FLAG"));
			if(rs.getString("EL_DEPOSIT_EDIT_FLAG")!=null)vo.setElPositionEditFlag(rs.getString("EL_DEPOSIT_EDIT_FLAG"));
			if(rs.getString("PROPERTY_TAX_EDIT_FLAG")!=null)vo.setPropertyTaxEditFlag(rs.getString("PROPERTY_TAX_EDIT_FLAG"));
			if(rs.getString("INSURANCE_EDIT_FLAG")!=null)vo.setInsuranceEditFlag(rs.getString("INSURANCE_EDIT_FLAG"));
			//if(rs.getString("MAIL_EDIT_FLAG")!=null)vo.setMailEditFlag(rs.getString("MAIL_EDIT_FLAG"));
			if(rs.getDate("CREATE_DT")!=null)vo.setCreateDT(rs.getDate("CREATE_DT"));
			if(rs.getString("CREATE_BY")!=null)vo.setCreateBy(rs.getString("CREATE_BY"));
			if(rs.getDate("UPDATE_DT")!=null)vo.setUpdateDT(rs.getDate("UPDATE_DT"));
			if(rs.getString("UPDATE_BY")!=null)vo.setUpdateBy(rs.getString("UPDATE_BY"));
			if(rs.getBigDecimal("VERSION")!=null)vo.setVersion(rs.getBigDecimal("VERSION"));
			if(rs.getString("CO_LOCATE_COMPANY")!=null)vo.setCoLocateCompany(rs.getString("CO_LOCATE_COMPANY"));
			if(rs.getString("FLOW_BY")!=null)vo.setFlowBy(rs.getString("FLOW_BY"));
			if(rs.getString("FLOW_REMARK")!=null)vo.setFlowRemark(rs.getString("FLOW_REMARK"));
			if(rs.getDate("FLOW_DT")!=null)vo.setFlowDT(rs.getDate("FLOW_DT"));
			if(rs.getString("ASSIGN_TO_TEAM")!=null)vo.setAssignToTeam(rs.getString("ASSIGN_TO_TEAM"));
			if(rs.getString("LESSOR_TAX_ID")!=null)vo.setLessorTaxId(rs.getString("LESSOR_TAX_ID"));
			if(rs.getBigDecimal("EL_PAY_ON_PACKAGE_AMT")!=null)vo.setElPayOnPackageAmt(rs.getBigDecimal("EL_PAY_ON_PACKAGE_AMT"));
			if(rs.getString("TO_AVP_REMARK_SPECIAL")!=null)vo.setToAvpRemarkSpecial(rs.getString("TO_AVP_REMARK_SPECIAL"));
			if(rs.getString("PHASE")!=null)vo.setPhase(rs.getString("PHASE"));
			if(rs.getString("STATION_TYPE")!=null)vo.setStationType(rs.getString("STATION_TYPE"));
			if(rs.getString("CONTRACT_TYPE_TEXT")!=null)vo.setContractTypeText(rs.getString("CONTRACT_TYPE_TEXT"));
			if(rs.getString("LOCATION_TYPE_TEXT")!=null)vo.setLocationTypeText(rs.getString("LOCATION_TYPE_TEXT"));
			if(rs.getString("HAD_ELE_DEPOSIT")!=null)vo.setHadEleDeposit(rs.getString("HAD_ELE_DEPOSIT"));
			if(rs.getString("ELECTRIC_DEPOSIT_DETAIL")!=null)vo.setElectricDepositDetail(rs.getString("ELECTRIC_DEPOSIT_DETAIL"));
			if(rs.getString("HAD_INSURANCE")!=null)vo.setHadInsurance(rs.getString("HAD_INSURANCE"));
			if(rs.getString("INSURANCE_DETAIL")!=null)vo.setInsuranceDetail(rs.getString("INSURANCE_DETAIL"));
			if(rs.getString("ATTACH_DOCUMENTS1")!=null)vo.setAttachDocument1(rs.getString("ATTACH_DOCUMENTS1"));
			if(rs.getString("ATTACH_DOCUMENTS2")!=null)vo.setAttachDocument2(rs.getString("ATTACH_DOCUMENTS2"));
			if(rs.getString("remark_after_approve")!=null)vo.setRemarkAfterApprove(rs.getString("remark_after_approve"));
			if(rs.getString("attachPlaceType")!=null)vo.setAttachPlaceType(rs.getString("attachPlaceType"));
			if(rs.getString("tickRentVatType")!=null)vo.setTickRentVatType(rs.getString("tickRentVatType"));
			if(rs.getString("tickRentWhtType")!=null)vo.setTickRentWhtType(rs.getString("tickRentWhtType"));
			if(rs.getString("tickServRenewCheckbox")!=null)vo.setTickServRenewCheckbox(rs.getString("tickServRenewCheckbox"));
			if(rs.getString("tickServNewCheckbox")!=null)vo.setTickServNewCheckbox(rs.getString("tickServNewCheckbox"));
			if(rs.getString("tickRentServVatType")!=null)vo.setTickRentServVatType(rs.getString("tickRentServVatType"));
			if(rs.getString("tickRentServWhtType")!=null)vo.setTickRentServWhtType(rs.getString("tickRentServWhtType"));
			if(rs.getString("DOC_TYPE_HEADER")!=null)vo.setDocTypeHeader(rs.getString("DOC_TYPE_HEADER"));
			if(rs.getBigDecimal("rentDepositAmt")!=null)vo.setRentDepositAmt(rs.getBigDecimal("rentDepositAmt"));
			if(rs.getBigDecimal("rentDepositAmtRenew")!=null)vo.setRentDepositAmtRenew(rs.getBigDecimal("rentDepositAmtRenew"));
			if(rs.getBigDecimal("rentDepositAmtOld")!=null)vo.setRentDepositAmtOld(rs.getBigDecimal("rentDepositAmtOld"));
			if(rs.getBigDecimal("rentDepositAmtAdd")!=null)vo.setRentDepositAmtAdd(rs.getBigDecimal("rentDepositAmtAdd"));
			if(rs.getString("IS_MACRO_TYPE")!=null)vo.setMacro(rs.getString("IS_MACRO_TYPE"));
			if(rs.getString("IS_MICRO_TYPE")!=null)vo.setMicro(rs.getString("IS_MICRO_TYPE"));
			if(rs.getString("IS_PICO_TYPE")!=null)vo.setPico(rs.getString("IS_PICO_TYPE"));
			if(rs.getString("IS_REPEATER_TYPE")!=null)vo.setRepeater(rs.getString("IS_REPEATER_TYPE"));
			if(rs.getString("IS_TOWER_TYPE")!=null)vo.setTowerType(rs.getString("IS_TOWER_TYPE"));
			if(rs.getString("IS_OTHER_TYPE")!=null)vo.setOtherType(rs.getString("IS_OTHER_TYPE"));
			if(rs.getString("IS_WIFI_TYPE")!=null)vo.setWifi(rs.getString("IS_WIFI_TYPE"));
			if(rs.getString("IS_FBB_TYPE")!=null)vo.setFbb(rs.getString("IS_FBB_TYPE"));
			if(rs.getString("IS_OFC_TYPE")!=null)vo.setOfc(rs.getString("IS_OFC_TYPE"));
			if(rs.getString("IS_FTTX_TYPE")!=null)vo.setFttx(rs.getString("IS_FTTX_TYPE"));
			if(rs.getString("IS_OTHER_TYPE_DETAIL")!=null)vo.setOtherTypeDetail(rs.getString("IS_OTHER_TYPE_DETAIL"));
			if(rs.getString("TO_POSITION1")!=null)vo.setToPosition1(rs.getString("TO_POSITION1"));
			if(rs.getString("TO_POSITION2")!=null)vo.setToPosition2(rs.getString("TO_POSITION2"));
			if(rs.getString("SITES_TXT")!=null)vo.setSitesTxt(rs.getString("SITES_TXT"));
			if(rs.getString("CHANGED_SITE_TXT")!=null)vo.setChangedSiteTxt(rs.getString("CHANGED_SITE_TXT"));
			if(rs.getString("CHANGED_CONTRACT_TXT")!=null)vo.setChangedContractTxt(rs.getString("CHANGED_CONTRACT_TXT"));
			if(rs.getString("CHANGED_RENTAL_TXT")!=null)vo.setChangedRentalTxt(rs.getString("CHANGED_RENTAL_TXT"));
			if(rs.getString("CHANGED_ELECTRIC_TXT")!=null)vo.setChangedElectricTxt(rs.getString("CHANGED_ELECTRIC_TXT"));
			if(rs.getString("CHANGED_OTHER_TXT")!=null)vo.setChangedOtherTxt(rs.getString("CHANGED_OTHER_TXT"));
			if(rs.getString("CO_COMPANY")!=null)vo.setCoCompany(rs.getString("CO_COMPANY"));
			if(rs.getString("CO_COMPANY_CONTRACT_NO")!=null)vo.setCoCompanyContractNo(rs.getString("CO_COMPANY_CONTRACT_NO"));
			if(rs.getString("IS_SMALLCELL_TYPE")!=null)vo.setIsSmallcellType(rs.getString("IS_SMALLCELL_TYPE"));
			if(rs.getBigDecimal("rentOldAmt")!=null)vo.setRentOldAmt(rs.getBigDecimal("rentOldAmt"));
			if(rs.getBigDecimal("rentServAmtOld")!=null)vo.setRentServAmtOld(rs.getBigDecimal("rentServAmtOld"));
			if(rs.getBigDecimal("rentServAmtRenew")!=null)vo.setRentServAmtRenew(rs.getBigDecimal("rentServAmtRenew"));
			if(rs.getBigDecimal("rentServAmtAdd")!=null)vo.setRentServAmtAdd(rs.getBigDecimal("rentServAmtAdd"));
			if(rs.getBigDecimal("rentAmtAddPerc")!=null)vo.setRentAmtAddPerc(rs.getBigDecimal("rentAmtAddPerc"));
			if(rs.getString("ServRenewPeriodTypeOld")!=null)vo.setServRenewPeriodTypeOld(rs.getString("ServRenewPeriodTypeOld"));
			if(rs.getString("ServRenewPeriodType")!=null)vo.setServRenewPeriodType(rs.getString("ServRenewPeriodType"));
			if(rs.getBigDecimal("rentAmtOldStr")!=null)vo.setRentAMTOld(rs.getBigDecimal("rentAmtOldStr"));
			if(rs.getBigDecimal("rentAmtAddPercStr")!=null)vo.setRentAmtAddPercStr(rs.getBigDecimal("rentAmtAddPercStr"));
//			if(rs.getBigDecimal("rentAmtAddStr")!=null)vo.setRentAmtAddStr(rs.getBigDecimal("rentAmtAddStr"));
			if(rs.getBigDecimal("rentAmtRenewStr")!=null)vo.setRentAmtRenew(rs.getBigDecimal("rentAmtRenewStr"));
			if(rs.getString("rentPeriodTypeRenew")!=null)vo.setRentPeriodTypeRenew(rs.getString("rentPeriodTypeRenew"));
			if(rs.getBigDecimal("rentAmtAdd")!=null)vo.setRentAmtAdd(rs.getBigDecimal("rentAmtAdd"));
			if(rs.getBigDecimal("rentAmtNewStr")!=null)vo.setRentAmtNew(rs.getBigDecimal("rentAmtNewStr"));
			if(rs.getBigDecimal("servAmtOldStr")!=null)vo.setServAmtOld(rs.getBigDecimal("servAmtOldStr"));
			if(rs.getBigDecimal("servAmtAddPercStr")!=null)vo.setServAmtAddPercStr(rs.getBigDecimal("servAmtAddPercStr"));
			if(rs.getBigDecimal("servAmtAddStr")!=null)vo.setServAmtAdd(rs.getBigDecimal("servAmtAddStr"));
			if(rs.getBigDecimal("servAmtRenewStr")!=null)vo.setServAmtRenew(rs.getBigDecimal("servAmtRenewStr"));
			if(rs.getBigDecimal("servAmtNewStr")!=null)vo.setServAmtNew(rs.getBigDecimal("servAmtNewStr"));
			if(rs.getString("servNewPeriodType")!=null)vo.setServNewPeriodType(rs.getString("servNewPeriodType"));
			if(rs.getDate("TERMINATE_CANCEL_CONTRACT_DT")!=null)vo.setContractCancelDT(rs.getDate("TERMINATE_CANCEL_CONTRACT_DT"));
			if(rs.getString("LOCATION_NAME")!=null)vo.setLocationName(rs.getString("LOCATION_NAME"));
			if(rs.getString("TICKRENTNEWCHECKBOX")!=null)vo.setTickRentNewCheckbox(rs.getString("TICKRENTNEWCHECKBOX"));
			if(rs.getString("CHKRTDEPOSBG")!=null)vo.setChkRtDeposBg(rs.getString("CHKRTDEPOSBG"));
			if(rs.getString("CHKRTDEPOSCASH")!=null)vo.setChkRtDeposCash(rs.getString("CHKRTDEPOSCASH"));
			if(rs.getString("CHKRTNODEPOS")!=null)vo.setChkRtNoDepos(rs.getString("CHKRTNODEPOS"));
			if(rs.getString("CHKRTDEPOSNEW")!=null)vo.setChkRtDeposNew(rs.getString("CHKRTDEPOSNEW"));
			if(rs.getString("CHKRTDEPOSRENEW")!=null)vo.setChkRtDeposRenew(rs.getString("CHKRTDEPOSRENEW"));
			if(rs.getString("TICKRENTRENEWCHECKBOX")!=null)vo.setTickRentRenewCheckbox(rs.getString("TICKRENTRENEWCHECKBOX"));
			if(rs.getString("CO_COMPANY_CONTRACT_NO")!=null)vo.setCoCompanyContractNo(rs.getString("CO_COMPANY_CONTRACT_NO"));
			if(rs.getString("rentPeriodTypeNew")!=null)vo.setRentPeriodTypeNew(rs.getString("rentPeriodTypeNew"));
			if(rs.getString("EL_USE_OTH_SITE")!=null)vo.setElUseOthSite(rs.getString("EL_USE_OTH_SITE"));
			if(rs.getString("SIGN_POSITION")!=null)vo.setSignPosition(rs.getString("SIGN_POSITION"));
			if(rs.getString("EL_USE_OTH_SITE_CONTRACT_NO")!=null)vo.setElUseOthSiteContractNo(rs.getString("EL_USE_OTH_SITE_CONTRACT_NO"));
			
			if(rs.getString("COMPANY_NAME")!=null)vo.setCompanyName(rs.getString("COMPANY_NAME"));
			
			if(rs.getString("LOCATION_ADDRESS_TEXT")!=null)vo.setLocationAddressText(rs.getString("LOCATION_ADDRESS_TEXT"));
			if(rs.getString("AREA_TEXT")!=null)vo.setAreaText(rs.getString("AREA_TEXT"));
			if(rs.getString("APPROVE_RENT")!=null)vo.setApproveRent(rs.getString("APPROVE_RENT"));
			
			if(rs.getString("EL_NO_EXPENSES")!=null)vo.setElNoExpenses(rs.getString("EL_NO_EXPENSES"));
			if(rs.getString("rentPeriodTypeOld")!=null)vo.setRentPeriodTypeOld(rs.getString("rentPeriodTypeOld"));
			
			if(rs.getString("RENT_AREA_MEMO_VAT_TYPE")!=null)vo.setRENT_AREA_MEMO_VAT_TYPE(rs.getString("RENT_AREA_MEMO_VAT_TYPE"));
			if(rs.getString("RENT_AREA_MEMO_WHT_TYPE")!=null)vo.setRENT_AREA_MEMO_WHT_TYPE(rs.getString("RENT_AREA_MEMO_WHT_TYPE"));
			if(rs.getString("RENT_AREA_MEMO_WHT_RATE")!=null)vo.setRENT_AREA_MEMO_WHT_RATE(rs.getString("RENT_AREA_MEMO_WHT_RATE"));
			if(rs.getString("RENT_SERV_MEMO_VAT_TYPE")!=null)vo.setRENT_SERV_MEMO_VAT_TYPE(rs.getString("RENT_SERV_MEMO_VAT_TYPE"));
			if(rs.getString("RENT_SERV_MEMO_WHT_TYPE")!=null)vo.setRENT_SERV_MEMO_WHT_TYPE(rs.getString("RENT_SERV_MEMO_WHT_TYPE"));
			if(rs.getString("RENT_SERV_MEMO_WHT_RATE")!=null)vo.setRENT_SERV_MEMO_WHT_RATE(rs.getString("RENT_SERV_MEMO_WHT_RATE"));
			if(rs.getString("RENT_SETUP_MEMO_VAT_TYPE")!=null)vo.setRENT_SETUP_MEMO_VAT_TYPE(rs.getString("RENT_SETUP_MEMO_VAT_TYPE"));
			if(rs.getString("RENT_SETUP_MEMO_WHT_TYPE")!=null)vo.setRENT_SETUP_MEMO_WHT_TYPE(rs.getString("RENT_SETUP_MEMO_WHT_TYPE"));
			if(rs.getString("RENT_SETUP_MEMO_WHT_RATE")!=null)vo.setRENT_SETUP_MEMO_WHT_RATE(rs.getString("RENT_SETUP_MEMO_WHT_RATE"));
			if(rs.getString("RENT_OTHER_MEMO_VAT_TYPE")!=null)vo.setRENT_OTHER_MEMO_VAT_TYPE(rs.getString("RENT_OTHER_MEMO_VAT_TYPE"));
			if(rs.getString("RENT_OTHER_MEMO_WHT_TYPE")!=null)vo.setRENT_OTHER_MEMO_WHT_TYPE(rs.getString("RENT_OTHER_MEMO_WHT_TYPE"));
			if(rs.getString("RENT_OTHER_MEMO_WHT_RATE")!=null)vo.setRENT_OTHER_MEMO_WHT_RATE(rs.getString("RENT_OTHER_MEMO_WHT_RATE"));
			if(rs.getString("RENT_WHT_RATE")!=null)vo.setRENT_WHT_RATE(rs.getString("RENT_WHT_RATE"));
			if(rs.getString("RENT_SERVICE_WHT_RATE")!=null)vo.setRENT_SERVICE_WHT_RATE(rs.getString("RENT_SERVICE_WHT_RATE"));
			
			if(rs.getDate("TERMINATE_RENT_DT")!=null)vo.setTERMINATE_RENT_DT(rs.getDate("TERMINATE_RENT_DT"));
			if(rs.getString("RETURN_DEPOSIT_FLAG")!=null)vo.setRETURN_DEPOSIT_FLAG(rs.getString("RETURN_DEPOSIT_FLAG"));
			if(rs.getBigDecimal("RETURN_DEPOSIT_AMT")!=null)vo.setRETURN_DEPOSIT_AMT(rs.getBigDecimal("RETURN_DEPOSIT_AMT"));
			if(rs.getDate("RETURN_DEPOSIT_DT")!=null)vo.setRETURN_DEPOSIT_DT(rs.getDate("RETURN_DEPOSIT_DT"));
			if(rs.getString("NO_RETURN_DEPOSIT_FLAG")!=null)vo.setNO_RETURN_DEPOSIT_FLAG(rs.getString("NO_RETURN_DEPOSIT_FLAG"));
			if(rs.getString("CANCEL_METER_FLAG")!=null)vo.setCANCEL_METER_FLAG(rs.getString("CANCEL_METER_FLAG"));
			if(rs.getString("TERMINATE_EL_FLAG")!=null)vo.setTERMINATE_EL_FLAG(rs.getString("TERMINATE_EL_FLAG"));
			if(rs.getString("OTHER_TERMINATE_FLAG")!=null)vo.setOTHER_TERMINATE_FLAG(rs.getString("OTHER_TERMINATE_FLAG"));
			if(rs.getString("OTHER_TERMINATE_NOTE")!=null)vo.setOTHER_TERMINATE_NOTE(rs.getString("OTHER_TERMINATE_NOTE"));
			if(rs.getString("OTHER_WAITING_FLAG")!=null)vo.setOTHER_WAITING_FLAG(rs.getString("OTHER_WAITING_FLAG"));
//			
			
			System.out.println("vo.getvo.setTERMINATE_RENT_DT() : "+vo.getTERMINATE_RENT_DT());
			System.out.println("rs.getDate TERMINATE_RENT_D : "+rs.getDate("TERMINATE_RENT_DT"));
			
			System.out.println("vo.getContractCancelDT() : "+vo.getContractCancelDT());
			System.out.println("rs.getDate(TERMINATE_CANCEL_CONTRACT_DT) : "+rs.getDate("TERMINATE_CANCEL_CONTRACT_DT"));
			
			
//		    log.debug("======LOCATION ID======== "+vo.getLocationId());
//		    log.debug("======getRentAmtNewStr======== "+vo.getRentAmtNewStr());
//		    System.out.println("RentPaymentPeriod = "+vo.getRentPaymentPeriod());
		    System.out.println("docType = "+docType); 
		    System.out.println("getSitesTxt = "+vo.getSitesTxt()); 
//		    System.out.println("======== EL_PAY_ON_PACKAGE_AMT ==========="+rs.getBigDecimal("EL_PAY_ON_PACKAGE_AMT"));
		    if(StringUtils.equals("01", docType) || StringUtils.equals("02", docType)){
		    	 vo.setRentalPaymentList(this.getPaymentList(siteAppId, "01"));
		    	 vo.setServicePaymentList(this.getServicePaymentList(siteAppId, "02"));
		    	 vo.setOtherPaymentList(this.getOthPaymentList(siteAppId, "03"));
		    	 vo.setElPaymentList(this.getELPaymentList(siteAppId));
//		    	 vo.setBgDepositPaymentList(getDepositList(siteAppId, "", "01"));
//		    	 vo.setCashDepositPaymentList(getDepositList(siteAppId, "", "02"));
		    	 vo.setRtServDepositPaymentList(getDepositList(siteAppId, "", ""));
		    	 vo.setElDepositPaymentList(getElDepositList(siteAppId, "08", ""));
		    }
		   
		}
		
		return vo;
	}
	
	public List<SiteAppReportObj> getPaymentList(String siteAppId, String expenseType){
		SiteAppReportObj rtObj = new SiteAppReportObj();
		String spName = "queryMsaPaymentReportParam";
		List<SiteAppReportObj> to = new ArrayList<SiteAppReportObj>();
		rtObj.setRowId(siteAppId);
		rtObj.setParamStr1(expenseType);
		try{
			to = querySPList(EQueryName.Q_SEARCH_SITE_ACQ_PAYMENT_REPORT.name, rtObj);
			
			if(to != null && to.size() > 0){
//				String t1 = to.get(0).getParamStr1();
//				String t2 = to.get(0).getPaymentDetail();
//				String t3 = to.get(0).getRentAmt().toString();
//				System.out.println("siteAppId : "+siteAppId);
//				System.out.println("expenseType : "+expenseType);
//				System.out.println("getParamStr1 : "+t1);
//				System.out.println("getPaymentDetail : "+t2);
//				System.out.println("getRentAmt : "+t3);
				return to;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Logger.getLogger("Error : "+e);
		}
		return to;
	}
	
	public List<SiteAppReportObj> getServicePaymentList(String siteAppId, String expenseType){
		SiteAppReportObj rtObj = new SiteAppReportObj();
		String spName = "queryMsaServicePaymentReportParam";
		List<SiteAppReportObj> to = new ArrayList<SiteAppReportObj>();
		rtObj.setRowId(siteAppId);
		rtObj.setParamStr2(expenseType);
		try{
			to = querySPList(spName, rtObj);
//			rtObj.setParamStr1("T1");
//			rtObj.setPaymentDetail("T2");
//			rtObj.setRentAmt(new BigDecimal(200));
//			to.add(rtObj);
			if(to != null && to.size() > 0){
//				String t1 = to.get(0).getParamStr1();
//				String t2 = to.get(0).getPaymentDetail();
//				String t3 = to.get(0).getRentAmt().toString();
//				System.out.println("siteAppId : "+siteAppId);
//				System.out.println("expenseType : "+expenseType);
//				System.out.println("getParamStr1 : "+t1);
//				System.out.println("getPaymentDetail : "+t2);
//				System.out.println("getRentAmt : "+t3);
				return to;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Logger.getLogger("Error : "+e);
		}
		return to;
	}
	
	public List<SiteAppReportObj> getOthPaymentList(String siteAppId, String expenseType) throws Exception{
		Connection connection = null;
		CallableStatement cstmt = null;
		List<SiteAppReportObj> to = new ArrayList<SiteAppReportObj>();
		ResultSet rs = null ; 
		SiteAppReportObj siteAppObj = new SiteAppReportObj();
		try{
			connection = getSessionFactory().getCurrentSession().connection();
			
			cstmt = connection.prepareCall("call SEM_PG_MSA003_SEARCH_PAYMENT_FOR_PRINT(?, ?, ? )");
			cstmt.setFetchSize(100);
			cstmt.setObject(1, null);
			cstmt.registerOutParameter(1, Types.OTHER);
			cstmt.setString(2, siteAppId);
			cstmt.setString(3, expenseType);
//			cstmt.executeQuery();
			cstmt.executeUpdate();
			rs = (java.sql.ResultSet)cstmt.getObject(1);                            
			while (rs.next()) {                  // Retrieve result set rows       
			  String hvEmpName=rs.getString("ROW_ID");
			  log.debug("hvEmpName");
			  siteAppObj = new SiteAppReportObj();
			  
			  if(rs.getString("ROW_ID") != null) siteAppObj.setRowId(rs.getString("ROW_ID"));
			  if(rs.getString("SITE_APP_ID") != null) siteAppObj.setSiteAppId(rs.getString("SITE_APP_ID"));
			  if(rs.getString("PAYMENT_DETAIL") != null)siteAppObj.setPaymentDetail(rs.getString("PAYMENT_DETAIL"));
	          if(rs.getBigDecimal("RENT_AMT") != null)siteAppObj.setRentAmt(rs.getBigDecimal("RENT_AMT"));
	          if(rs.getString("BAHT_TXT") != null)siteAppObj.setBahtTxt(rs.getString("BAHT_TXT"));
	          if(rs.getString("RENT_PERIOD_TYPE") != null)siteAppObj.setRentPreiodType(rs.getString("RENT_PERIOD_TYPE"));
	          if(rs.getString("RENT_PERIOD_TYPE_NAME") != null)siteAppObj.setRentPreiodTypeName(rs.getString("RENT_PERIOD_TYPE_NAME"));
	          if(rs.getBigDecimal("WHT_RATE") != null)siteAppObj.setWhtRate(rs.getBigDecimal("WHT_RATE"));
	          if(rs.getString("WHT_TYPE") != null) 	siteAppObj.setWhtType(rs.getString("WHT_TYPE"));
	          if(rs.getString("VAT_RATE") != null)siteAppObj.setVatRate(rs.getString("VAT_RATE"));
	          if( rs.getString("VAT_TYPE") != null)siteAppObj.setVatType(rs.getString("VAT_TYPE"));
	          if(rs.getString("PAY_PERIOD_COND") != null)siteAppObj.setPayPeriodCond(rs.getString("PAY_PERIOD_COND"));
	          if(rs.getString("PAY_PERIOD_TYPE") != null)siteAppObj.setPayPeriodType(rs.getString("PAY_PERIOD_TYPE"));
	          if(rs.getString("PAY_PERIOD_TYPE_NAME") != null)siteAppObj.setPayPeriodTypeName(rs.getString("PAY_PERIOD_TYPE_NAME"));
	          if(rs.getString("RENT_AMT_TXT") != null)siteAppObj.setRentAmtTxt(rs.getString("RENT_AMT_TXT"));
	          if(rs.getBigDecimal("RENT_OLD_AMT") != null)siteAppObj.setRentOldAmt(rs.getBigDecimal("RENT_OLD_AMT"));
	          if( rs.getString("RENT_OLD_PERIOD_TYPE") != null)siteAppObj.setRentOldPeriodType(rs.getString("RENT_OLD_PERIOD_TYPE"));
	          if( rs.getString("INC_DEC") != null)siteAppObj.setIncDec(rs.getString("INC_DEC"));
	          if( rs.getBigDecimal("RENT_ADD_PERCENT") != null)siteAppObj.setRentAddPercent(rs.getBigDecimal("RENT_ADD_PERCENT"));
	          if( rs.getString("RENT_ADD_CONCLUSION") != null)siteAppObj.setRentAddConclusion(rs.getString("RENT_ADD_CONCLUSION"));
	          if(rs.getBigDecimal("RENT_ADD_AMT") != null)siteAppObj.setRentAddAmt(rs.getBigDecimal("RENT_ADD_AMT"));
	          if(rs.getString("RENEW_FLAG") != null)siteAppObj.setRenewFlag(rs.getString("RENEW_FLAG"));
	          if( rs.getString("DETAIL") != null)siteAppObj.setDetail(rs.getString("DETAIL"));
	          to.add(siteAppObj) ;
	          System.out.println("Employee name for "  
	  			    + ": " + siteAppObj.getPaymentDetail());
			}
			
			
		}catch (Exception e) {		
			
			e.printStackTrace();
		}finally{
			if(connection != null) connection.close();
		}

		return to;
	}
	
	public List<SiteAppReportObj> getOthPaymentList2(String siteAppId, String expenseType){
		SiteAppReportObj rtObj = new SiteAppReportObj();
		String spName = "queryMsaPaymentReportParam";
		List<SiteAppReportObj> to = new ArrayList<SiteAppReportObj>();
		rtObj.setRowId(siteAppId);
		rtObj.setParamStr1(expenseType);
		try{
			to = querySPList(EQueryName.Q_SEARCH_SITE_ACQ_PAYMENT_REPORT.name, rtObj);
			
			if(to != null && to.size() > 0){
//				String t1 = to.get(0).getParamStr1();
//				String t2 = to.get(0).getPaymentDetail();
//				String t3 = to.get(0).getRentAmt().toString();
//				System.out.println("siteAppId : "+siteAppId);
//				System.out.println("expenseType : "+expenseType);
//				System.out.println("getParamStr1 : "+t1);
//				System.out.println("getPaymentDetail : "+t2);
//				System.out.println("getRentAmt : "+t3);
				return to;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Logger.getLogger("Error : "+e);
		}
		return to;
	}
	
	public List<SiteAppReportObj> getELPaymentList(String siteAppId){
		SiteAppReportObj rtObj = new SiteAppReportObj();
		String spName = "queryMsaELReportParam";
		List<SiteAppReportObj> to = new ArrayList<SiteAppReportObj>();
		rtObj.setRowId(siteAppId);
		try{
			to = querySPList(spName, rtObj);
			
			if(to != null && to.size() > 0){
//				String t1 = to.get(0).getParamStr1();
//				String t2 = to.get(0).getPaymentDetail();
//				String t3 = to.get(0).getElAmt().toString();
//				System.out.println("getParamStr1 : "+t1);
//				System.out.println("getPaymentDetail : "+t2);
//				System.out.println("getElAmt : "+t3);
				return to;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Logger.getLogger("Error : "+e);
		}
		return to;
	}
	
	
	public List<SiteAppReportObj> getDepositList(String siteAppId, String expenseType, String depositType){
		
		SiteAppReportObj rtObj = new SiteAppReportObj();
		String spName = "queryMsaDepositReportParam";
		List<SiteAppReportObj> to = new ArrayList<SiteAppReportObj>();
		rtObj.setRowId(siteAppId);
		rtObj.setParamStr1(expenseType);
		rtObj.setParamStr2(depositType);
		try{
			to = querySPList(spName, rtObj);
			
			if(to != null && to.size() > 0){
				String t1 = to.get(0).getSiteAppDepositId();
				String t2 = to.get(0).getExpenseType();
				String t3 = to.get(0).getDepositTypeName();
				System.out.println("siteAppId : "+siteAppId);
				System.out.println("expenseType : "+expenseType);
				System.out.println("depositType : "+depositType);
				System.out.println("getSiteAppDepositId : "+t1);
				System.out.println("getExpenseType : "+t2);
				System.out.println("getDepositTypeName : "+t3);
				return to;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Logger.getLogger("Error : "+e);
		}
		return to;
	}
	
	public List<SiteAppReportObj> getElDepositList(String siteAppId, String expenseType, String depositType){
		
		SiteAppReportObj rtObj = new SiteAppReportObj();
		String spName = "queryMsaELDepositReportParam";
		List<SiteAppReportObj> to = new ArrayList<SiteAppReportObj>();
		rtObj.setRowId(siteAppId);
		rtObj.setParamStr1(expenseType);
		rtObj.setParamStr2(depositType);
		try{
			to = querySPList(spName, rtObj);
			
			if(to != null && to.size() > 0){
				String t1 = to.get(0).getDetail();
				String t2 = to.get(0).getExpenseType();
				String t3 = to.get(0).getDepositTypeName();
				System.out.println("---------------------------- getElDepositList : ");
//				System.out.println("siteAppId : "+siteAppId);
//				System.out.println("expenseType : "+expenseType);
//				System.out.println("depositType : "+depositType);
				System.out.println("getSiteAppDepositId : "+t1);
				System.out.println("getExpenseType : "+t2);
				System.out.println("getDepositTypeName : "+t3);
				return to;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Logger.getLogger("Error : "+e);
		}
		return to;
	}
}
