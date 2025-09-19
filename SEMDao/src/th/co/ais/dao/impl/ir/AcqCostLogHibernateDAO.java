package th.co.ais.dao.impl.ir;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.ir.AcqCostLog;
import th.co.ais.domain.ir.InsurancePayment;

public class AcqCostLogHibernateDAO extends AbstractHibernateDAO<AcqCostLog> {
	
	public List<AcqCostLog> searchAcqCostLogByFileName(AcqCostLog acqCostLog)throws DAOException{
		
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(AcqCostLog.class);
		
		if(acqCostLog != null){
			if(StringUtils.isNotEmpty(acqCostLog.getFileName())){
				criteria.add(Restrictions.like("fileName", acqCostLog.getFileName()));
			}
			if(StringUtils.isNotEmpty(acqCostLog.getAcqType())){
				criteria.add(Restrictions.like("acqType", acqCostLog.getAcqType()));
			}
			if(StringUtils.isNotEmpty(acqCostLog.getAsOfMonth())){
				criteria.add(Restrictions.like("asOfMonth", acqCostLog.getAsOfMonth()));
			}
			if(StringUtils.isNotEmpty(acqCostLog.getReNewFlg())){
				criteria.add(Restrictions.like("reNewFlg", acqCostLog.getReNewFlg()));
			}
			if(StringUtils.isNotEmpty(acqCostLog.getNetworkType())){
				criteria.add(Restrictions.like("networkType", acqCostLog.getNetworkType()));
			}
		}
		return criteria.list();
	}
	
}
