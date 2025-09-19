package th.co.ais.dao.rpt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.impl.ir.InsurancePaymentHibernateDAO;
import th.co.ais.rpt.domain.SEMMIR008Domain;
import th.co.ais.rpt.domain.SEMMRT003Domain;
import th.co.ais.util.SEMDataUtility;

public class SEMMIR008ReportDao extends AbstractHibernateDAO<SEMMIR008Domain>{
	
	public ResultSet executeRS(Map<String, Object> criteria) throws Exception {
		Connection connection = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		try{
			connection = getSessionFactory().getCurrentSession().connection();
			
			cstmt = connection.prepareCall("call SEM_SP_MIR008_DRAFT(?, ?)");
			cstmt.setFetchSize(100);
			cstmt.registerOutParameter(1, Types.OTHER);
			cstmt.setString(2, (String) criteria.get("PARAM_DRAFT_NO"));
			//cstmt.executeQuery();
			cstmt.execute();
			
			rs = (ResultSet) cstmt.getObject(1);			
			
			
		}catch (Exception e) {				
			e.printStackTrace();
		}finally{
			if(connection != null) connection.close();
		}

		return rs;
	}	

	public List<SEMMIR008Domain> executeList(Map<String, Object> criteria) throws Exception {
		ResultSet rs = this.executeRS(criteria);
		SEMMIR008Domain vo = null;
		List<SEMMIR008Domain> voList = new ArrayList<SEMMIR008Domain>();		
		try{
			if (rs != null) {
				while (rs.next()) {
					vo = new SEMMIR008Domain();	
					vo.setROW_ID(rs.getString("ROW_ID"));
					vo.setDRAFT_NO(rs.getString("DRAFT_NO"));
					vo.setNETWORK_TYPE_DESC(rs.getString("NETWORK_TYPE_DESC"));
					vo.setTRANSFER_TYPE_DESC(rs.getString("TRANSFER_TYPE_DESC"));
					vo.setPOLICY_TYPE(rs.getString("POLICY_TYPE"));
					vo.setPOLICY_TYPE_DESC(rs.getString("POLICY_TYPE_DESC"));
					vo.setCOMPANY_DESC(rs.getString("COMPANY_DESC"));
					vo.setADDRESS(rs.getString("ADDRESS"));
					vo.setTOTAL_LOCATION(rs.getString("TOTAL_LOCATION"));
					vo.setPOLICY_START_DT((rs.getDate("POLICY_START_DT") != null) ? SEMDataUtility.toStringThaiDateSimpleFormat(rs.getDate("POLICY_START_DT")):"" );
					vo.setPOLICY_START_TM1(rs.getString("POLICY_START_TM1"));
					vo.setPOLICY_START_TM2(rs.getString("POLICY_START_TM2"));
					vo.setPOLICY_END_DT((rs.getDate("POLICY_END_DT") != null) ? SEMDataUtility.toStringThaiDateSimpleFormat(rs.getDate("POLICY_END_DT")): "");
					vo.setPOLICY_END_TM1(rs.getString("POLICY_END_TM1"));
					vo.setPOLICY_END_TM2(rs.getString("POLICY_END_TM2"));
					vo.setINSURED_AMT(SEMDataUtility.convertNumberToStringByFormat(rs.getDouble("INSURED_AMT"), "#,##0.00"));
					vo.setLIMIT_LOST(rs.getString("LIMIT_LOST"));
					vo.setLIMIT_LOST_AMT(rs.getDouble("LIMIT_LOST_AMT"));
					vo.setDEDUCT_AMT(SEMDataUtility.convertNumberToStringByFormat(rs.getDouble("DEDUCT_AMT"), "#,##0.00"));
					vo.setPREMIUM_RATE(rs.getDouble("PREMIUM_RATE"));
					vo.setPREMIUM_AMT(SEMDataUtility.convertNumberToStringByFormat(rs.getDouble("PREMIUM_AMT"), "#,##0.00"));
					vo.setDUTY_AMT(SEMDataUtility.convertNumberToStringByFormat(rs.getDouble("DUTY_AMT"), "#,##0.00"));
					vo.setVAT_AMT(SEMDataUtility.convertNumberToStringByFormat(rs.getDouble("VAT_AMT"), "#,##0.00"));
					vo.setTOTAL_PREMIUM_AMT(SEMDataUtility.convertNumberToStringByFormat(rs.getDouble("TOTAL_PREMIUM_AMT"), "#,##0.00"));
					vo.setINSURED_NAME(rs.getString("INSURED_NAME"));
					vo.setDOC_DT((rs.getDate("DOC_DT") != null)?SEMDataUtility.toStringThaiDateSimpleFormat(rs.getDate("DOC_DT")):"");
					vo.setPOLICY_DT((rs.getDate("POLICY_DT") != null )? SEMDataUtility.toStringThaiDateSimpleFormat(rs.getDate("POLICY_DT")): "");
					vo.setREMARK(rs.getString("REMARK"));
					vo.setFOR_MONTH(rs.getString("FOR_MONTH"));
					vo.setFOR_YEAR(rs.getString("FOR_YEAR"));
					vo.setREF_NO(rs.getString("REF_NO"));
					vo.setREF_DT((rs.getDate("REF_DT") != null) ? SEMDataUtility.toStringThaiDateSimpleFormat(rs.getDate("REF_DT")) : "");
					vo.setPOLICY_DAY(rs.getString("POLICY_DAY"));

					
					voList.add(vo);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(rs != null) rs.close();
		}
		
		return voList;
	}

}
