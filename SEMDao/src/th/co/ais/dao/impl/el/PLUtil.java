package th.co.ais.dao.impl.el;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import th.co.ais.domain.el.BgMaster;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.PrivateDeposit;
import th.co.ais.domain.gm.Attachment;
import th.co.ais.service.exception.ServiceException;
import th.co.ais.util.BeanUtils;

public class PLUtil extends HibernateDaoSupport{

	public static int IN_PARAM_TYPE_VARCHAR = 1;
	public static int IN_PARAM_TYPE_DATE = 2;
	public static int IN_PARAM_TYPE_NUMBER = 3;
	public static int IN_PARAM_TYPE_DOUBLE = 4;
	
	private static final Logger LOG = Logger.getLogger(PLUtil.class);
	
	@SuppressWarnings("deprecation")
	public void callPL(String plName, int []inParamType, Object []inParamValue) throws Exception{
		
		try {
			
			LOG.debug("WT### plName="+plName);
			
			Session session = getSessionFactory().getCurrentSession();
			session.flush();
			PreparedStatement pstmt = null;
			if(null==inParamType){
				pstmt = session.connection().prepareStatement("call SEM."+plName+"() ");
			}else{
				StringBuffer params = new StringBuffer();
				for(int i=0,j=inParamType.length;i<j;i++){
					
					params.append("?,");
				}
				
				if(params.length() > 0) params.deleteCharAt(params.length()-1);
				
				pstmt = session.connection().prepareStatement("call SEM."+plName+"("+params.toString()+") ");

				for(int i=0,j=inParamType.length;i<j;i++){
					
					int paramType = inParamType[i];
					Object paramValue = inParamValue[i];
					
					if(paramType == IN_PARAM_TYPE_VARCHAR) pstmt.setString(i+1, (String)paramValue);
					if(paramType == IN_PARAM_TYPE_DATE) pstmt.setDate(i+1, (Date)paramValue);
					if(paramType == IN_PARAM_TYPE_NUMBER) pstmt.setLong(i+1, (Long)paramValue);
				}
			}
			pstmt.execute();
			/*StringBuffer params = new StringBuffer();
			for(int i=0,j=inParamType.length;i<j;i++){
				
				params.append("?,");
			}
			
			if(params.length() > 0) params.deleteCharAt(params.length()-1);
			
			PreparedStatement pstmt = session.connection().prepareStatement("{call SEM."+plName+"("+params.toString()+") }");

			for(int i=0,j=inParamType.length;i<j;i++){
				
				int paramType = inParamType[i];
				Object paramValue = inParamValue[i];
				
				if(paramType == IN_PARAM_TYPE_VARCHAR) pstmt.setString(i+1, (String)paramValue);
				if(paramType == IN_PARAM_TYPE_DATE) pstmt.setDate(i+1, (Date)paramValue);
				if(paramType == IN_PARAM_TYPE_NUMBER) pstmt.setLong(i+1, (Long)paramValue);
			}

			pstmt.execute();*/
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			throw new ServiceException("Error occured while calling PL '"+plName+"' : "+e);
		}
	}
	
	@SuppressWarnings("deprecation")
	public Object[] callPLWithReturnValue(String plName, int []inParamType, int []outParamType, Object []inParamValue) throws Exception{
		
		try {
			
			LOG.debug("WT###plName : "+plName);
			
			Session session = getSessionFactory().getCurrentSession();
			session.flush();
			
			StringBuffer params = new StringBuffer();
			// in
			for(int i=0,j=inParamType.length;i<j;i++){
				
				params.append("?,");
			}
			
			// out
			for(int i=0,j=outParamType.length;i<j;i++){
				
				params.append("?,");
			}
			
			if(params.length() > 0) params.deleteCharAt(params.length()-1);
			
			CallableStatement callable = session.connection().prepareCall("call SEM."+plName+"("+params.toString()+") ");

			// in
			for(int i=0,j=inParamType.length;i<j;i++){
				
				int paramType = inParamType[i];
				Object paramValue = inParamValue[i];
				
				if(paramType == IN_PARAM_TYPE_VARCHAR) callable.setString(i+1, (String)paramValue);
				if(paramType == IN_PARAM_TYPE_DATE) callable.setDate(i+1, (Date)paramValue);
				if(paramType == IN_PARAM_TYPE_NUMBER) callable.setLong(i+1, (Long)paramValue);
				
			}
			
			// out
			for(int i=inParamType.length,j=inParamType.length+outParamType.length;i<j;i++){
				
				int paramType = outParamType[i-inParamType.length];
				
				if(paramType == IN_PARAM_TYPE_VARCHAR) callable.registerOutParameter(i+1, Types.VARCHAR);
				if(paramType == IN_PARAM_TYPE_DATE) callable.registerOutParameter(i+1, Types.DATE);
				if(paramType == IN_PARAM_TYPE_NUMBER) callable.registerOutParameter(i+1, Types.NUMERIC);
			}

			callable.execute();
			
			// prepare result
			Object []result = new Object[outParamType.length];
			for(int i=inParamType.length,j=inParamType.length+outParamType.length;i<j;i++){
				
				int paramType = outParamType[i-inParamType.length];
				
				if(paramType == IN_PARAM_TYPE_VARCHAR) result[i-inParamType.length] = callable.getString(i+1);
				if(paramType == IN_PARAM_TYPE_DATE) result[i-inParamType.length] = callable.getDate(i+1);
				//if(paramType == IN_PARAM_TYPE_NUMBER) result[i-inParamType.length] = callable.getInt(i+1);
				if(paramType == IN_PARAM_TYPE_NUMBER) result[i-inParamType.length] = callable.getBigDecimal(i+1);
			}
			
			return result;
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			throw new ServiceException("Error occured while calling PL '"+plName+"' : "+e);
		}
	}
	
	@SuppressWarnings("deprecation")
	public Object callFNWithReturnValue(String plName, int []inParamType, int outParamType, Object []inParamValue) throws Exception{
		
		try {
			
			Session session = getSessionFactory().getCurrentSession();
			session.flush();
			
			StringBuffer params = new StringBuffer();
			// in
			for(int i=0,j=inParamType.length;i<j;i++){
				
				params.append("?,");
			}
			
			if(params.length() > 0) params.deleteCharAt(params.length()-1);
			
			CallableStatement callable = session.connection().prepareCall("? = call SEM."+plName+"("+params.toString()+") ");

			// in
			for(int i=0,j=inParamType.length;i<j;i++){
				
				int paramType = inParamType[i];
				Object paramValue = inParamValue[i];
				
				if(paramType == IN_PARAM_TYPE_VARCHAR) callable.setString(i+2, (String)paramValue);
				if(paramType == IN_PARAM_TYPE_DATE) callable.setDate(i+2, (Date)paramValue);
				if(paramType == IN_PARAM_TYPE_NUMBER) callable.setLong(i+2, (Long)paramValue);
			}
			
			// out
			if(outParamType == IN_PARAM_TYPE_VARCHAR) callable.registerOutParameter(1, Types.VARCHAR);
			if(outParamType == IN_PARAM_TYPE_DATE) callable.registerOutParameter(1, Types.DATE);
			if(outParamType == IN_PARAM_TYPE_NUMBER) callable.registerOutParameter(1, Types.NUMERIC);

			callable.execute();
			
			// prepare result
			Object result = null;
			
			if(outParamType == IN_PARAM_TYPE_VARCHAR) result = callable.getString(1);
			if(outParamType == IN_PARAM_TYPE_DATE) result = callable.getDate(1);
			//if(outParamType == IN_PARAM_TYPE_NUMBER) result = callable.getInt(1);
			if(outParamType == IN_PARAM_TYPE_NUMBER) result = callable.getBigDecimal(1);
			
			return result;
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			throw new ServiceException("Error occured while calling FN '"+plName+"' : "+e);
		}
	}

	public void callPLOnSequence(BgMaster bgMaster, Management manage,
			List<PrivateDeposit> privateDepositList, String plName,
			List<Attachment> attachmentList, BgMasterHibernateDAO bgMasterDao, PrivateDepositHibernateDAO privateDepositDao)  throws Exception{
		System.out.println("WT###Tommmmmmm callPLOnSequenceflush##############################");
		
		
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{manage.getRowId(), manage.getDepositType()};
		try {
			Session session = getSessionFactory().getCurrentSession();
			//bgMasterDao.tomSave(bgMaster);
			session.save(bgMaster);	
			PrivateDeposit privateDeposit = privateDepositList.get(0);
			String rowId = privateDeposit.getRowId();
//			PrivateDeposit privateDeposit0 = privateDepositDao.findByRowId(rowId);
//			System.out.println("WT###privateDeposit0="+BeanUtils.getBeanString(privateDeposit0));
			for(PrivateDeposit obj : privateDepositList){
				session.update(obj);
			}
			session.flush();
//			PrivateDeposit privateDeposit2 = privateDepositDao.findByRowId(rowId);
//			System.out.println("WT###privateDeposit2="+BeanUtils.getBeanString(privateDeposit2));
			
			StringBuffer params = new StringBuffer();
			
			for(int i=0,j=inParamType.length;i<j;i++){
				
				params.append("?,");
			}			
			
			if(params.length() > 0) params.deleteCharAt(params.length()-1);
						
			PreparedStatement pstmt = session.connection().prepareStatement("call SEM."+plName+"("+params.toString()+") ");
			for(int i=0,j=inParamType.length;i<j;i++){
				
				int paramType = inParamType[i];
				Object paramValue = inParamValue[i];
				
				if(paramType == IN_PARAM_TYPE_VARCHAR) pstmt.setString(i+1, (String)paramValue);
				if(paramType == IN_PARAM_TYPE_DATE) pstmt.setDate(i+1, (Date)paramValue);
				if(paramType == IN_PARAM_TYPE_NUMBER) pstmt.setLong(i+1, (Long)paramValue);
			}
			pstmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Call PL "+plName+" Error : "+e);
		}
	}
	
	public void tomCallPL(BgMaster bgMaster, Management manage,
			List<PrivateDeposit> privateDepositList, String plName,
			List<Attachment> attachmentList, BgMasterHibernateDAO bgMasterDao, PrivateDepositHibernateDAO privateDepositDao)  throws Exception{
		System.out.println("WT###Tommmmmmm 77777callPLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL##############################");
		
		
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{manage.getRowId(), manage.getDepositType()};
		try {
			Session session = getSessionFactory().getCurrentSession();
			//bgMasterDao.tomSave(bgMaster);
			session.save(bgMaster);	
			PrivateDeposit privateDeposit = privateDepositList.get(0);
			String rowId = privateDeposit.getRowId();
//			PrivateDeposit privateDeposit0 = privateDepositDao.findByRowId(rowId);
//			System.out.println("WT###privateDeposit0="+BeanUtils.getBeanString(privateDeposit));
			for(PrivateDeposit obj : privateDepositList){
				session.update(obj);
			}
			//session.update(privateDeposit);
			PrivateDeposit privateDeposit2 = privateDepositDao.findByRowId(rowId);
			//System.out.println("WT###privateDeposit2="+BeanUtils.getBeanString(privateDeposit2));
			
			StringBuffer params = new StringBuffer();
			
			for(int i=0,j=inParamType.length;i<j;i++){
				
				params.append("?,");
			}			
			
			if(params.length() > 0) params.deleteCharAt(params.length()-1);
			
			
			String sql = "select PRIVATE_DEROSIT_ID, NEW_FLAG from SEM_EL_PRIVATE_DEPOSIT where PRIVATE_DEROSIT_ID = '"+rowId+"'";
			System.out.println("WT###Print sql="+sql);
			PreparedStatement pstmtQuery = session.connection().prepareStatement(sql);
			ResultSet rs = pstmtQuery.executeQuery();
			while (rs.next()) {
				String NEW_FLAG = rs.getString("NEW_FLAG");
				String PRIVATE_DEROSIT_ID = rs.getString("PRIVATE_DEROSIT_ID");
				System.out.println("WT###Print NEW_FLAG = "+NEW_FLAG);
				System.out.println("WT###Print PRIVATE_DEROSIT_ID = "+PRIVATE_DEROSIT_ID);
			}
			
			
			
			PreparedStatement pstmt = session.connection().prepareStatement("call SEM."+plName+"("+params.toString()+") ");
			for(int i=0,j=inParamType.length;i<j;i++){
				
				int paramType = inParamType[i];
				Object paramValue = inParamValue[i];
				
				if(paramType == IN_PARAM_TYPE_VARCHAR) pstmt.setString(i+1, (String)paramValue);
				if(paramType == IN_PARAM_TYPE_DATE) pstmt.setDate(i+1, (Date)paramValue);
				if(paramType == IN_PARAM_TYPE_NUMBER) pstmt.setLong(i+1, (Long)paramValue);
			}
			pstmt.execute();
			
			String sql2 = "select PRIVATE_DEROSIT_ID, NEW_FLAG from SEM_EL_PRIVATE_DEPOSIT where PRIVATE_DEROSIT_ID = '"+rowId+"'";
			System.out.println("WT###Print sql="+sql);
			PreparedStatement pstmtQuery2 = session.connection().prepareStatement(sql);
			ResultSet rs2 = pstmtQuery.executeQuery();
			while (rs2.next()) {
				String NEW_FLAG = rs2.getString("NEW_FLAG");
				String PRIVATE_DEROSIT_ID = rs2.getString("PRIVATE_DEROSIT_ID");
				System.out.println("WT###Print NEW_FLAG2 = "+NEW_FLAG);
				System.out.println("WT###Print PRIVATE_DEROSIT_ID2 = "+PRIVATE_DEROSIT_ID);
			}
			
			PrivateDeposit privateDeposit3 = privateDepositDao.findByRowId(rowId);
			//System.out.println("WT###privateDeposit3="+BeanUtils.getBeanString(privateDeposit3));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Call PL "+plName+" Error : "+e);
		}
	}
	
	@SuppressWarnings("deprecation")
	public Object[] callPLWithReturnValueInstallment(String plName, int []inParamType, int []outParamType, Object []inParamValue) throws Exception{
		
		try {
			
			LOG.debug("WT###plName : "+plName);
			
			Session session = getSessionFactory().getCurrentSession();
			session.flush();
			
			StringBuffer params = new StringBuffer();
			// in
			for(int i=0,j=inParamType.length;i<j;i++){
				
				params.append("?,");
			}
			
			// out
			for(int i=0,j=outParamType.length;i<j;i++){
				
				params.append("?,");
			}
			
			if(params.length() > 0) params.deleteCharAt(params.length()-1);
			
			CallableStatement callable = session.connection().prepareCall("call SEM."+plName+"("+params.toString()+") ");

			// in
			for(int i=0,j=inParamType.length;i<j;i++){
				
				int paramType = inParamType[i];
				Object paramValue = inParamValue[i];
				
				if(paramType == IN_PARAM_TYPE_VARCHAR) callable.setString(i+1, (String)paramValue);
				if(paramType == IN_PARAM_TYPE_DATE) callable.setDate(i+1, (Date)paramValue);
				if(paramType == IN_PARAM_TYPE_NUMBER) callable.setLong(i+1, (Long)paramValue);
				if(paramType == IN_PARAM_TYPE_DOUBLE) callable.setBigDecimal(i+1, (BigDecimal)paramValue);
				
				
			}
			
			// out
			for(int i=inParamType.length,j=inParamType.length+outParamType.length;i<j;i++){
				
				int paramType = outParamType[i-inParamType.length];
				
				if(paramType == IN_PARAM_TYPE_VARCHAR) callable.registerOutParameter(i+1, Types.VARCHAR);
				if(paramType == IN_PARAM_TYPE_DATE) callable.registerOutParameter(i+1, Types.DATE);
				if(paramType == IN_PARAM_TYPE_NUMBER) callable.registerOutParameter(i+1, Types.NUMERIC);
				
			}

			callable.execute();
			
			// prepare result
			Object []result = new Object[outParamType.length];
			for(int i=inParamType.length,j=inParamType.length+outParamType.length;i<j;i++){
				
				int paramType = outParamType[i-inParamType.length];
				
				if(paramType == IN_PARAM_TYPE_VARCHAR) result[i-inParamType.length] = callable.getString(i+1);
				if(paramType == IN_PARAM_TYPE_DATE) result[i-inParamType.length] = callable.getDate(i+1);
				//if(paramType == IN_PARAM_TYPE_NUMBER) result[i-inParamType.length] = callable.getInt(i+1);
				if(paramType == IN_PARAM_TYPE_NUMBER) result[i-inParamType.length] = callable.getBigDecimal(i+1);
			}
			
			return result;
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			throw new ServiceException("Error occured while calling PL '"+plName+"' : "+e);
		}
	}
}
