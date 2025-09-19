package th.co.ais.dao.rpt.jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import org.apache.log4j.Logger;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.rpt.domain.SEMECO001Domain;
import th.co.ais.rpt.domain.SEMECO007Domain;

public class SEMECO007ReportDao extends AbstractHibernateDAO<SEMECO001Domain>{

	private Logger log = Logger.getLogger(getClass());

	public ResultSet executeRS(Map<String, Object> criteria) throws Exception{
		Connection connection = getSessionFactory().getCurrentSession().connection();
		String query = "SELECT * FROM SEM_PG_ECO002_GET_DATA(?, ?)";
		System.out.println("======PARAM_CONTRACT_ID ======== "+criteria.get("PARAM_CONTRACT_ID"));
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, (String) criteria.get("PARAM_CONTRACT_ID"));
        ps.setString(2, (String) criteria.get("PARAM_CONTRACT_TYPE_OLD"));
        return ps.executeQuery();
	}
	
	public SEMECO007Domain execute(Map<String, Object> criteria) throws Exception {
		ResultSet rs = this.executeRS(criteria);
		SEMECO007Domain vo = null;

		if (rs != null) {
			rs.next();
			vo = new SEMECO007Domain();
			vo.setSITE_INFO_ID(rs.getString("SITE_INFO_ID"));
			vo.setSITE_NAME(rs.getString("SITE_NAME"));
			vo.setCONTRACT_NO(rs.getString("CONTRACT_NO"));
			vo.setDOC_DT(rs.getDate("DOC_DT"));
			vo.setPLACE_TYPE(rs.getString("PLACE_TYPE"));
			
			vo.setCOMPANY_ADDR(rs.getString("COMPANY_ADDR"));
			vo.setCOMPANY_HOUSE_NO(rs.getString("COMPANY_HOUSE_NO"));
			vo.setCOMPANY_STREET(rs.getString("COMPANY_STREET"));
			vo.setCOMPANY_TAMBON(rs.getString("COMPANY_TAMBON"));
			vo.setCOMPANY_AMPHUR(rs.getString("COMPANY_AMPHUR"));
			vo.setCOMPANY_PROVINCE(rs.getString("COMPANY_PROVINCE"));
			
			vo.setBY_NAME(rs.getString("BY_NAME"));
		    
			vo.setOWNER_NAME(rs.getString("OWNER_NAME"));
			vo.setLESSOR_NAME(rs.getString("LESSOR_NAME"));
			vo.setLESSOR_ADDR(rs.getString("LESSOR_ADDR"));
			vo.setTOT_BY_NAME(rs.getString("TOT_BY_NAME"));
			vo.setTOT_BY_POSITION1(rs.getString("TOT_BY_POSITION1"));
			vo.setTOT_BY_POSITION2(rs.getString("TOT_BY_POSITION2"));
			vo.setTOT_BY_POSITION3(rs.getString("TOT_BY_POSITION3"));
			vo.setTOT_SEND_FLAG(rs.getString("TOT_SEND_FLAG"));
			vo.setSITE_ADDR(rs.getString("SITE_ADDR"));

			vo.setDECK_AREA(rs.getBigDecimal("DECK_AREA"));
			vo.setDECK_AREA_TYPE_DESC(rs.getString("DECK_AREA_TYPE_DESC"));
			vo.setBUILDING_AREA(rs.getString("BUILDING_AREA"));
			vo.setBUILDING_AREA_TYPE_DESC(rs.getString("BUILDING_AREA_TYPE_DESC"));
		    
			vo.setROOM_AREA(rs.getBigDecimal("ROOM_AREA"));
			vo.setROOM_AREA_TYPE_DESC(rs.getString("ROOM_AREA_TYPE_DESC"));
			vo.setLAND_AREA(rs.getBigDecimal("LAND_AREA"));
			vo.setLAND_AREA_TYPE_DESC(rs.getString("LAND_AREA_TYPE_DESC"));
			vo.setLAND_AREA_UNIT_TYPE_DESC(rs.getString("LAND_AREA_UNIT_TYPE_DESC"));
		    
			vo.setAREA_DESC(rs.getString("AREA_DESC"));
		    
			vo.setCONTRACT_AGE(rs.getString("CONTRACT_AGE"));
			vo.setCONTRACT_AGE_DESC(rs.getString("CONTRACT_AGE_DESC"));
			vo.setEFFECTIVE_DT(rs.getDate("EFFECTIVE_DT"));
			vo.setEXPIRE_DT(rs.getDate("EXPIRE_DT"));
			vo.setAGE_YEAR(rs.getBigDecimal("AGE_YEAR"));
		    vo.setAGE_MONTH(rs.getBigDecimal("AGE_MONTH"));
		    vo.setAGE_DAY(rs.getBigDecimal("AGE_DAY"));
		    
		    vo.setRENT_PERIOD_TYPE(rs.getString("RENT_PERIOD_TYPE"));    
		    vo.setRENT_PERIOD_TYPE_NAME(rs.getString("RENT_PERIOD_TYPE_NAME"));
		    vo.setRENT_AMT(rs.getBigDecimal("RENT_AMT"));
		    vo.setRENT_WHT_TYPE_DESC(rs.getString("RENT_WHT_TYPE_DESC"));
		    vo.setRENT_WHT_FLAG(rs.getString("RENT_WHT_FLAG"));
		    vo.setRENT_WHT_RATE(rs.getBigDecimal("RENT_WHT_RATE"));
		    vo.setRENT_AMT_X_TIME(rs.getString("RENT_AMT_X_TIME"));                             
		    vo.setTOTAL_RENT_AMT(rs.getBigDecimal("TOTAL_RENT_AMT"));

		    vo.setRENT_PAY_PERIOD(rs.getBigDecimal("RENT_PAY_PERIOD"));
		    vo.setRENT_PAY_PERIOD_TYPE(rs.getString("RENT_PAY_PERIOD_TYPE"));
		    vo.setRENT_PAY_PERIOD_TYPE_NAME(rs.getString("RENT_PAY_PERIOD_TYPE_NAME"));
		    vo.setRENT_PAY_DUE_DESC(rs.getString("RENT_PAY_DUE_DESC"));

		    vo.setSERVICE_PERIOD_TYPE(rs.getString("SERVICE_PERIOD_TYPE"));
		    vo.setSERVICE_PERIOD_TYPE_NAME(rs.getString("SERVICE_PERIOD_TYPE_NAME"));
		    vo.setSERVICE_AMT(rs.getBigDecimal("SERVICE_AMT"));
		    vo.setSERVICE_WHT_FLAG(rs.getString("SERVICE_WHT_FLAG"));
		    vo.setSERVICE_WHT_TYPE_DESC(rs.getString("SERVICE_WHT_TYPE_DESC"));
		    vo.setSERVICE_WHT_RATE(rs.getBigDecimal("SERVICE_WHT_RATE"));
		    vo.setSERVICE_AMT_X_TIME(rs.getString("SERVICE_AMT_X_TIME"));
		    vo.setSERVICE_VAT_TYPE(rs.getString("SERVICE_VAT_TYPE"));
		    vo.setSERVICE_VAT_TYPE_NAME(rs.getString("SERVICE_VAT_TYPE_NAME"));
		    vo.setTOTAL_SERVICE_AMT(rs.getBigDecimal("TOTAL_SERVICE_AMT"));
		                                                      
		    vo.setSERVICE_PAY_PERIOD(rs.getBigDecimal("SERVICE_PAY_PERIOD"));
		    vo.setSERVICE_PAY_PERIOD_TYPE(rs.getString("SERVICE_PAY_PERIOD_TYPE"));
		    vo.setSERVICE_PAY_PERIOD_TYPE_NAME(rs.getString("SERVICE_PAY_PERIOD_TYPE_NAME"));
		    vo.setSERVICE_PAY_DUE_DESC(rs.getString("SERVICE_PAY_DUE_DESC"));
    
		    vo.setRENT_DEPOSIT_FLAG(rs.getString("RENT_DEPOSIT_FLAG"));
		    vo.setRENT_DEPOSIT_AMT(rs.getBigDecimal("RENT_DEPOSIT_AMT"));

		    vo.setSERVICE_DEPOSIT_FLAG(rs.getString("SERVICE_DEPOSIT_FLAG"));
		    vo.setSERVICE_DEPOSIT_AMT(rs.getBigDecimal("SERVICE_DEPOSIT_AMT"));

		    vo.setELETRIC_TYPE_1(rs.getString("ELECTRIC_TYPE_1"));
		    vo.setELETRIC_TYPE_2(rs.getString("ELECTRIC_TYPE_2"));
		    vo.setELETRIC_TYPE_3(rs.getString("ELECTRIC_TYPE_3"));
		    vo.setELETRIC_TYPE_4(rs.getString("ELECTRIC_TYPE_4"));
		    vo.setELETRIC_OWNER_TYPE(rs.getString("ELECTRIC_OWNER_TYPE"));             
		                    
		    vo.setET_UNIT_PRICE_AMT(rs.getBigDecimal("ET_UNIT_PRICE_AMT"));
		    vo.setET_VAT_TYPE_NAME(rs.getString("ET_VAT_TYPE_NAME"));    
		    vo.setET_TAKE_ALL_AMT(rs.getBigDecimal("ET_TAKE_ALL_AMT"));
		    if(rs.getString("ET_TAKE_ALL_PERIOD_TYPE_NAME") != null)vo.setET_TAKE_ALL_PERIOD_TYPE_NAME(rs.getString("ET_TAKE_ALL_PERIOD_TYPE_NAME"));
		                     
		    vo.setPROMISE_RENEW_TIME(rs.getBigDecimal("PROMISE_RENEW_TIME"));
		    vo.setPROMISE_RENEW_PERIOD(rs.getBigDecimal("PROMISE_RENEW_PERIOD"));
		    vo.setPROMISE_RENEW_PERIOD_TYPE(rs.getString("PROMISE_RENEW_PERIOD_TYPE"));
		    
		    vo.setPROPERTY_TAX_PAY_TYPE(rs.getString("PROPERTY_TAX_PAY_TYPE"));
		    vo.setRENT_COND_TYPE(rs.getString("RENT_COND_TYPE"));
		    vo.setDEPOSIT_COND_TYPE_R(rs.getString("DEPOSIT_COND_TYPE_R"));
		    vo.setRENT_DETAIL(rs.getString("RENT_DETAIL"));
		    vo.setSERVICE_DETAIL(rs.getString("SERVICE_DETAIL"));
		     
		    vo.setDEPOSIT_R_BG_DETAIL(rs.getString("DEPOSIT_R_BG_DETAIL"));
		    vo.setDEPOSIT_R_CASH_DETAIL(rs.getString("DEPOSIT_R_CASH_DETAIL"));
		    
		    vo.setCOMPANY_NAME(rs.getString("COMPANY_NAME"));
		    
		    vo.setRENT_PAY_PERIOD_AMT(rs.getBigDecimal("RENT_PAY_PERIOD_AMT"));
		    vo.setSIGN_NAME(rs.getString("SIGN_NAME"));
		    vo.setLOCATION_ID(rs.getString("LOCATION_ID"));
		    vo.setWIFI_FLAG(rs.getString("WIFI_FLAG"));
		    if(rs.getString("FIX5_PERCENT_TXT") != null)vo.setFIX5_PERCENT_TXT(rs.getString("FIX5_PERCENT_TXT"));
		    if(rs.getString("ET_PAY_PERIOD_TYPE_NAME") != null)vo.setET_PAY_PERIOD_TYPE_NAME(rs.getString("ET_PAY_PERIOD_TYPE_NAME"));
		   
		    System.out.println("======vo.setCOMPANY_PROVINCE ======== "+vo.getCOMPANY_PROVINCE());
		    System.out.println("======getSERVICE_PERIOD_TYPE ======== "+vo.getSERVICE_PERIOD_TYPE());
//		    System.out.println("======TOTAL_SERVICE_AMT ======== "+vo.getTOTAL_SERVICE_AMT());
//		    System.out.println("======TOTAL_SERVICE_AMT_DESC ======== "+vo.getTOTAL_SERVICE_AMT_DESC());
//		    System.out.println("======RENT_PERIOD_TYPE ======== "+vo.getRENT_PERIOD_TYPE());
//		    System.out.println("======RENT_PAY_PERIOD_TYPE_NAME ======== "+vo.getRENT_PAY_PERIOD_TYPE_NAME());
//		    System.out.println("======TOTAL_RENT_AMT ======== "+vo.getTOTAL_RENT_AMT());
//		    System.out.println("======TOTAL_RENT_AMT_DESC ======== "+vo.getTOTAL_RENT_AMT_DESC());
		}
		
		return vo;
	}
	
	public ResultSet executeRS(Map<String, Object> criteria,Connection con) throws Exception{
		Connection connection = con;
		String query = "SELECT * FROM SEM_PG_ECO002_GET_DATA(?, ?)";
		System.out.println("======PARAM_CONTRACT_ID ======== "+criteria.get("PARAM_CONTRACT_ID"));
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, (String) criteria.get("PARAM_CONTRACT_ID"));
        ps.setString(2, (String) criteria.get("PARAM_CONTRACT_TYPE_OLD"));
        return ps.executeQuery();
	}
	
	public SEMECO001Domain execute(Map<String, Object> criteria,Connection con) throws Exception {
		ResultSet rs = this.executeRS(criteria, con);
		SEMECO001Domain vo = null;

		if (rs != null) {
			rs.next();
			vo = new SEMECO001Domain();
			vo.setSITE_INFO_ID(rs.getString("SITE_INFO_ID"));
			vo.setSITE_NAME(rs.getString("SITE_NAME"));
			vo.setCONTRACT_NO(rs.getString("CONTRACT_NO"));
			vo.setDOC_DT(rs.getDate("DOC_DT"));
			vo.setPLACE_TYPE(rs.getString("PLACE_TYPE"));
			
			vo.setCOMPANY_ADDR(rs.getString("COMPANY_ADDR"));
			vo.setCOMPANY_HOUSE_NO(rs.getString("COMPANY_HOUSE_NO"));
			vo.setCOMPANY_STREET(rs.getString("COMPANY_STREET"));
			vo.setCOMPANY_TAMBON(rs.getString("COMPANY_TAMBON"));
			vo.setCOMPANY_AMPHUR(rs.getString("COMPANY_AMPHUR"));
			vo.setCOMPANY_PROVINCE(rs.getString("COMPANY_PROVINCE"));
			
			vo.setBY_NAME(rs.getString("BY_NAME"));
		    
			vo.setOWNER_NAME(rs.getString("OWNER_NAME"));
			vo.setLESSOR_NAME(rs.getString("LESSOR_NAME"));
			vo.setLESSOR_ADDR(rs.getString("LESSOR_ADDR"));
			vo.setTOT_BY_NAME(rs.getString("TOT_BY_NAME"));
			vo.setTOT_BY_POSITION1(rs.getString("TOT_BY_POSITION1"));
			vo.setTOT_BY_POSITION2(rs.getString("TOT_BY_POSITION2"));
			vo.setTOT_BY_POSITION3(rs.getString("TOT_BY_POSITION3"));
			vo.setTOT_SEND_FLAG(rs.getString("TOT_SEND_FLAG"));
			vo.setSITE_ADDR(rs.getString("SITE_ADDR"));

			vo.setDECK_AREA(rs.getBigDecimal("DECK_AREA"));
			vo.setDECK_AREA_TYPE_DESC(rs.getString("DECK_AREA_TYPE_DESC"));
			vo.setBUILDING_AREA(rs.getString("BUILDING_AREA"));
			vo.setBUILDING_AREA_TYPE_DESC(rs.getString("BUILDING_AREA_TYPE_DESC"));
		    
			vo.setROOM_AREA(rs.getBigDecimal("ROOM_AREA"));
			vo.setROOM_AREA_TYPE_DESC(rs.getString("ROOM_AREA_TYPE_DESC"));
			vo.setLAND_AREA(rs.getBigDecimal("LAND_AREA"));
			vo.setLAND_AREA_TYPE_DESC(rs.getString("LAND_AREA_TYPE_DESC"));
			vo.setLAND_AREA_UNIT_TYPE_DESC(rs.getString("LAND_AREA_UNIT_TYPE_DESC"));
		    
			vo.setAREA_DESC(rs.getString("AREA_DESC"));
		    
			vo.setCONTRACT_AGE(rs.getString("CONTRACT_AGE"));
			vo.setCONTRACT_AGE_DESC(rs.getString("CONTRACT_AGE_DESC"));
			vo.setEFFECTIVE_DT(rs.getDate("EFFECTIVE_DT"));
			vo.setEXPIRE_DT(rs.getDate("EXPIRE_DT"));
			vo.setAGE_YEAR(rs.getBigDecimal("AGE_YEAR"));
		    vo.setAGE_MONTH(rs.getBigDecimal("AGE_MONTH"));
		    vo.setAGE_DAY(rs.getBigDecimal("AGE_DAY"));
		    
		    vo.setRENT_PERIOD_TYPE(rs.getString("RENT_PERIOD_TYPE"));
		    vo.setRENT_PERIOD_TYPE_NAME(rs.getString("RENT_PERIOD_TYPE_NAME"));
		    vo.setRENT_AMT(rs.getBigDecimal("RENT_AMT"));
		    vo.setRENT_WHT_TYPE_DESC(rs.getString("RENT_WHT_TYPE_DESC"));
		    vo.setRENT_WHT_FLAG(rs.getString("RENT_WHT_FLAG"));
		    vo.setRENT_WHT_RATE(rs.getBigDecimal("RENT_WHT_RATE"));
		    vo.setRENT_AMT_X_TIME(rs.getString("RENT_AMT_X_TIME"));                             
		    vo.setTOTAL_RENT_AMT(rs.getBigDecimal("TOTAL_RENT_AMT"));

		    vo.setRENT_PAY_PERIOD(rs.getBigDecimal("RENT_PAY_PERIOD"));
		    vo.setRENT_PAY_PERIOD_TYPE(rs.getString("RENT_PAY_PERIOD_TYPE"));
		    vo.setRENT_PAY_PERIOD_TYPE_NAME(rs.getString("RENT_PAY_PERIOD_TYPE_NAME"));
		    vo.setRENT_PAY_DUE_DESC(rs.getString("RENT_PAY_DUE_DESC"));

		    vo.setSERVICE_PERIOD_TYPE(rs.getString("SERVICE_PERIOD_TYPE"));
		    vo.setSERVICE_PERIOD_TYPE_NAME(rs.getString("SERVICE_PERIOD_TYPE_NAME"));
		    vo.setSERVICE_AMT(rs.getBigDecimal("SERVICE_AMT"));
		    vo.setSERVICE_WHT_FLAG(rs.getString("SERVICE_WHT_FLAG"));
		    vo.setSERVICE_WHT_TYPE_DESC(rs.getString("SERVICE_WHT_TYPE_DESC"));
		    vo.setSERVICE_WHT_RATE(rs.getBigDecimal("SERVICE_WHT_RATE"));
		    vo.setSERVICE_AMT_X_TIME(rs.getString("SERVICE_AMT_X_TIME"));
		    vo.setSERVICE_VAT_TYPE(rs.getString("SERVICE_VAT_TYPE"));
		    vo.setSERVICE_VAT_TYPE_NAME(rs.getString("SERVICE_VAT_TYPE_NAME"));
		    vo.setTOTAL_SERVICE_AMT(rs.getBigDecimal("TOTAL_SERVICE_AMT"));
		                                                      
		    vo.setSERVICE_PAY_PERIOD(rs.getBigDecimal("SERVICE_PAY_PERIOD"));
		    vo.setSERVICE_PAY_PERIOD_TYPE(rs.getString("SERVICE_PAY_PERIOD_TYPE"));
		    vo.setSERVICE_PAY_PERIOD_TYPE_NAME(rs.getString("SERVICE_PAY_PERIOD_TYPE_NAME"));
		    vo.setSERVICE_PAY_DUE_DESC(rs.getString("SERVICE_PAY_DUE_DESC"));
    
		    vo.setRENT_DEPOSIT_FLAG(rs.getString("RENT_DEPOSIT_FLAG"));
		    vo.setRENT_DEPOSIT_AMT(rs.getBigDecimal("RENT_DEPOSIT_AMT"));

		    vo.setSERVICE_DEPOSIT_FLAG(rs.getString("SERVICE_DEPOSIT_FLAG"));
		    vo.setSERVICE_DEPOSIT_AMT(rs.getBigDecimal("SERVICE_DEPOSIT_AMT"));

		    vo.setELETRIC_TYPE_1(rs.getString("ELECTRIC_TYPE_1"));
		    vo.setELETRIC_TYPE_2(rs.getString("ELECTRIC_TYPE_2"));
		    vo.setELETRIC_TYPE_3(rs.getString("ELECTRIC_TYPE_3"));
		    vo.setELETRIC_TYPE_4(rs.getString("ELECTRIC_TYPE_4"));
		    vo.setELETRIC_OWNER_TYPE(rs.getString("ELECTRIC_OWNER_TYPE"));             
		                    
		    vo.setET_UNIT_PRICE_AMT(rs.getBigDecimal("ET_UNIT_PRICE_AMT"));
		    vo.setET_VAT_TYPE_NAME(rs.getString("ET_VAT_TYPE_NAME"));    
		    vo.setET_TAKE_ALL_AMT(rs.getBigDecimal("ET_TAKE_ALL_AMT"));
		    vo.setET_TAKE_ALL_PERIOD_TYPE_NAME(rs.getString("ET_TAKE_ALL_PERIOD_TYPE_NAME"));
		                     
		    vo.setPROMISE_RENEW_TIME(rs.getBigDecimal("PROMISE_RENEW_TIME"));
		    vo.setPROMISE_RENEW_PERIOD(rs.getBigDecimal("PROMISE_RENEW_PERIOD"));
		    vo.setPROMISE_RENEW_PERIOD_TYPE(rs.getString("PROMISE_RENEW_PERIOD_TYPE"));
		    
		    vo.setPROPERTY_TAX_PAY_TYPE(rs.getString("PROPERTY_TAX_PAY_TYPE"));
		    vo.setRENT_COND_TYPE(rs.getString("RENT_COND_TYPE"));
		    vo.setDEPOSIT_COND_TYPE_R(rs.getString("DEPOSIT_COND_TYPE_R"));
		    vo.setRENT_DETAIL(rs.getString("RENT_DETAIL"));
		    vo.setSERVICE_DETAIL(rs.getString("SERVICE_DETAIL"));
		     
		    vo.setDEPOSIT_R_BG_DETAIL(rs.getString("DEPOSIT_R_BG_DETAIL"));
		    vo.setDEPOSIT_R_CASH_DETAIL(rs.getString("DEPOSIT_R_CASH_DETAIL"));
		    
		    vo.setCOMPANY_NAME(rs.getString("COMPANY_NAME"));
		    
		    vo.setRENT_PAY_PERIOD_AMT(rs.getBigDecimal("RENT_PAY_PERIOD_AMT"));
		    vo.setSIGN_NAME(rs.getString("SIGN_NAME"));
		    vo.setLOCATION_ID(rs.getString("LOCATION_ID"));
		    vo.setWIFI_FLAG(rs.getString("WIFI_FLAG"));
		    if(rs.getString("FIX5_PERCENT_TXT") != null)vo.setFIX5_PERCENT_TXT(rs.getString("FIX5_PERCENT_TXT"));
		    if(rs.getString("ET_PAY_PERIOD_TYPE_NAME") != null)vo.setET_PAY_PERIOD_TYPE_NAME(rs.getString("ET_PAY_PERIOD_TYPE_NAME"));
//		   
		    System.out.println("======vo.setCOMPANY_PROVINCE ======== "+vo.getCOMPANY_PROVINCE());
		    System.out.println("======getSERVICE_PERIOD_TYPE ======== "+vo.getSERVICE_PERIOD_TYPE());
//		    System.out.println("======TOTAL_SERVICE_AMT ======== "+vo.getTOTAL_SERVICE_AMT());
//		    System.out.println("======TOTAL_SERVICE_AMT_DESC ======== "+vo.getTOTAL_SERVICE_AMT_DESC());
//		    System.out.println("======RENT_PERIOD_TYPE ======== "+vo.getRENT_PERIOD_TYPE());
//		    System.out.println("======TOTAL_RENT_AMT ======== "+vo.getTOTAL_RENT_AMT());
//		    System.out.println("======TOTAL_RENT_AMT_DESC ======== "+vo.getTOTAL_RENT_AMT_DESC());
		}
		
		return vo;
	}
	
}
