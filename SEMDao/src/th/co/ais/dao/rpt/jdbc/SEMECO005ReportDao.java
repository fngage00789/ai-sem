package th.co.ais.dao.rpt.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.rpt.domain.SEMECO001Domain;
import th.co.ais.rpt.domain.SEMECO005Domain;

public class SEMECO005ReportDao extends AbstractHibernateDAO<SEMECO001Domain>{

	public ResultSet executeRS(Map<String, Object> criteria) throws Exception{
		Connection connection = getSessionFactory().getCurrentSession().connection();
		String query = "SELECT * FROM SEM_PG_ECO005_GET_DATA(?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, (String) criteria.get("PARAM_CONTRACT_ID"));
        return ps.executeQuery();
	}

	public SEMECO005Domain execute(Map<String, Object> criteria) throws Exception {
		ResultSet rs = this.executeRS(criteria);
		SEMECO005Domain vo = null;

		if (rs != null) {
			rs.next();
			vo = new SEMECO005Domain();
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
			
			vo.setGROUP_NO(rs.getString("GROUP_NO"));

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
		    
		    vo.setRENT_AMT(rs.getBigDecimal("RENT_AMT"));

		                     
		    vo.setPROMISE_RENEW_TIME(rs.getBigDecimal("PROMISE_RENEW_TIME"));
		    vo.setPROMISE_RENEW_PERIOD(rs.getBigDecimal("PROMISE_RENEW_PERIOD"));
		    vo.setPROMISE_RENEW_PERIOD_TYPE(rs.getString("PROMISE_RENEW_PERIOD_TYPE"));
		    
		    vo.setCOMPANY_NAME(rs.getString("COMPANY_NAME"));
		    
		    vo.setSIGN_NAME(rs.getString("SIGN_NAME"));
		    vo.setWITNESS_1(rs.getString("WITNESS_1"));
		    vo.setLESSER_NAME(rs.getString("LESSER_NAME"));
		    vo.setSERVICE_AMT(rs.getBigDecimal("SERVICE_AMT"));
		    vo.setREGION(rs.getString("REGION"));
		}
		
		return vo;
	}
	
}
