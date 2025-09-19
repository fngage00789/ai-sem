package th.co.ais.dao.impl.sap;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.sap.SapTrxLog;
import th.co.ais.domain.sap.SapTrxLogSrch;
import th.co.ais.util.SEMDataUtility;

public class SapTrxLogHibernateDAO extends AbstractHibernateDAO<SapTrxLog> {
	
	@SuppressWarnings("unchecked")
	public List<SapTrxLog> querySapTrxLog(final SapTrxLogSrch filter) throws DAOException{
		Session session = getSessionFactory().getCurrentSession();
		Criteria c = session.createCriteria(SapTrxLog.class);
		if(null!=filter){
			if(filter.getLogid() != null)
				c.add(Restrictions.eq("logid", filter.getLogid()));
			if(StringUtils.isNotEmpty(filter.getFileName())){
				if(filter.getFileName().indexOf('%')>-1)
					c.add(Restrictions.like("fileName", filter.getFileName()));	
				else
					c.add(Restrictions.eq("fileName", filter.getFileName().trim()));				
			}
			if(StringUtils.isNotEmpty(filter.getStatus()))
				c.add(Restrictions.eq("status", filter.getStatus()));
			if(StringUtils.isNotEmpty(filter.getCompany()))
				c.add(Restrictions.eq("company", filter.getCompany()));
			
			if(StringUtils.isNotEmpty(filter.getCreateBy())){
				if(filter.getCreateBy().indexOf('%')>-1)
					c.add(Restrictions.like("createBy", filter.getCreateBy()));
				else
					c.add(Restrictions.eq("createBy", filter.getCreateBy()));
			}
			if(StringUtils.isNotEmpty(filter.getUpdateBy())){
				if(filter.getUpdateBy().indexOf('%')>-1)
					c.add(Restrictions.like("updateBy", filter.getUpdateBy()));
				else
					c.add(Restrictions.eq("updateBy", filter.getUpdateBy()));
			}
			
			if(filter.getCreateDtFrom()!=null)
				c.add(Restrictions.ge("createDt", SEMDataUtility.convertToStartDate(filter.getCreateDtFrom())));
			if(filter.getCreateDtTo()!=null)
				c.add(Restrictions.le("createDt", SEMDataUtility.convertToEndDate(filter.getCreateDtTo())));
						
			//UpdateDate from - to 
			if(filter.getUpdateDtFrom()!=null)
				c.add(Restrictions.ge("updateDt", SEMDataUtility.convertToStartDate(filter.getUpdateDtFrom())));
			if(filter.getUpdateDtTo()!=null)
				c.add(Restrictions.le("updateDt", SEMDataUtility.convertToEndDate(filter.getUpdateDtTo())));
		}
		c.addOrder(Order.asc("logid"));
		return c.list();
	}
	
	public SapTrxLog createSapTrxLog(final SapTrxLog input)throws DAOException{
		Integer nextLogid = getNextLogid(null);
		input.setLogid(nextLogid);
		save(input);
		return input;
	}
		
	public Integer getNextLogid(final SapTrxLog filter) throws DAOException{
		Integer max = null;		
		Session session = getSessionFactory().getCurrentSession();
		Criteria c = session.createCriteria(SapTrxLog.class).setProjection(Projections.max("logid"));
		try {
			if(null!=filter){
				if(filter.getFileName() != null){
					if(filter.getFileName().indexOf('%')>-1){
						c.add(Restrictions.like("fileName", filter.getFileName()));	
					}else{
						c.add(Restrictions.eq("fileName", filter.getFileName()));	
					}
				}
				if(filter.getCreateBy() != null){
					c.add(Restrictions.eq("createBy", filter.getCreateBy()));
				}
				if(filter.getUpdateBy() != null){
					c.add(Restrictions.eq("updateBy", filter.getUpdateBy()));
				}
			}
			Object objMax = c.uniqueResult();
			if(objMax==null) max = 0;				
			else max = (Integer)c.uniqueResult();
			
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return (max + 1);
	}
}
