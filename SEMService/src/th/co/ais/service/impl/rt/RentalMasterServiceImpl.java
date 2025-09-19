package th.co.ais.service.impl.rt;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleTypes;

import org.hibernate.HibernateException;

import th.co.ais.dao.impl.rt.RentalMasterHibernateDAO;
import th.co.ais.domain.rt.Mrt010IfrsInterface;
import th.co.ais.domain.rt.RentalMaster;

import th.co.ais.service.AbstractService;
import th.co.ais.service.rt.IRentalMasterService;

public class RentalMasterServiceImpl extends AbstractService implements IRentalMasterService {

	private RentalMasterHibernateDAO rentalMasterDao;

	public void setRentalMasterDao(RentalMasterHibernateDAO rentalMasterDao) {
		this.rentalMasterDao = rentalMasterDao;
	}

	@Override
	public RentalMaster createRentalMaster(RentalMaster rentalMaster) throws Exception {
		rentalMaster.setRecordStatus("Y");
		return rentalMasterDao.merge(rentalMaster);
	}

	@Override
	public void deleteRentalMaster(RentalMaster rentalMaster) throws Exception {
		rentalMaster.setRecordStatus("N");
		rentalMasterDao.mergeFlush(rentalMaster);
	}

	@Override
	public RentalMaster updateRentalMaster(RentalMaster rentalMaster) throws Exception {
		return rentalMasterDao.merge(rentalMaster);
	}

	@Override
	public RentalMaster queryByRowId(String rowId) throws Exception {
		return rentalMasterDao.findByRowId(rowId);
	}

	@Override
	public List querySPList(String spName, Object property) throws Exception {
		return rentalMasterDao.querySPList(spName, property);
	}

	@Override
	public String callSemIfrsChkSendToSap(String siteInfoId, String rentalMasterId) {
		
		String rs =null ;
		try {
			CallableStatement stmt = rentalMasterDao.getSessionFactory().getCurrentSession().connection().prepareCall(
					"{? = call SEM_IFRS_CHK_SENDTOSAP(?,?)}");
			//stmt.registerOutParameter(1, Types.CHAR);
			stmt.registerOutParameter(1, Types.VARCHAR);
			stmt.setString(2, siteInfoId);
			stmt.setString(3, rentalMasterId);
			stmt.execute();
			rs = stmt.getString(1);
		} catch (Exception e) {
			e.printStackTrace();
			//return "N";
		}
		//return "N";
		return rs ;
	}
	
	@Override
	public String callSemIfrsChkChange(String contractNo)throws Exception{
		String result = null;
		ResultSet rs = null;
		try {
			CallableStatement stmt = rentalMasterDao.getSessionFactory().getCurrentSession().connection().prepareCall(
					"CALL SEM.SEM_IFRS_20_CHK_NEW(?,?)");
			//stmt.registerOutParameter(1, OracleTypes.CURSOR);
			stmt.registerOutParameter(1, Types.OTHER);
			stmt.setString(2, contractNo);
			stmt.execute();
			
			rs = (ResultSet) stmt.getObject(1);
			
			if(rs.next()){
				
				System.out.println("RESULT : " + rs.getString("NEW_FLAG"));
				result = rs.getString("NEW_FLAG");
			}
			
			//System.out.println("####" + stmt.getString("NEW_FLAG"));
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public String callSemIfrsChkDelay(String contractType)throws Exception{
		try {
			CallableStatement stmt = rentalMasterDao.getSessionFactory().getCurrentSession().connection().prepareCall(
					"{? = call SEM_IFRS_CHECK_DELAY(?)}");
			//stmt.registerOutParameter(1, Types.CHAR);
			stmt.registerOutParameter(1, Types.VARCHAR);
			stmt.setString(2, contractType);
			stmt.execute();
			System.out.println("#### Check Delay : " + stmt.getString(1));
			return stmt.getString(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "N";
		
	}
	
	/*============ 01/06/2023 New Call PL  custom for get Multiple Output Parameter PL sem_ifrs_20_online */
	@Override
	public List<Mrt010IfrsInterface> callSemIfrs20online(Mrt010IfrsInterface ifrsPrepare) throws Exception{
		
		List<Mrt010IfrsInterface> IsrfInterfacesList = new ArrayList<Mrt010IfrsInterface>();
		ResultSet rs = null;
		String oResult = null;
		String oRemark = null;
		
		try {
			CallableStatement stmt = rentalMasterDao.getSessionFactory().getCurrentSession().connection().prepareCall(
					"call SEM.sem_ifrs_20_online(?,?,?,?,?)");
			stmt.registerOutParameter(1, Types.OTHER);
			stmt.registerOutParameter(2, Types.VARCHAR);
			stmt.registerOutParameter(3, Types.VARCHAR);
			stmt.setString(4, ifrsPrepare.getContractNo());
			stmt.setString(5, ifrsPrepare.getUserId());
			stmt.execute();
			
			rs = (ResultSet) stmt.getObject(1);
			oResult = (String)stmt.getObject(2);
			oRemark = (String)stmt.getObject(3);
			
			System.out.println("#### call SEM.sem_ifrs_20_online ==> Result : " + oResult +" , Remark :"+oRemark );
			
			if(rs.next()){				
				System.out.println("REFERENCE_ID : " + rs.getString("REFERENCE_ID"));
				//result = rs.getString("NEW_FLAG");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsrfInterfacesList;
		
	}

}
