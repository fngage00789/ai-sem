package th.co.ais.dao.impl.ir;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.ir.IrLoadClaimLog;

public class IrLoadClaimLogHibernateDAO extends AbstractHibernateDAO<IrLoadClaimLog> {
	
	public List<IrLoadClaimLog> searchIrLoadClaimLogByFileName(IrLoadClaimLog irLoadClaimLog)throws DAOException{
		
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IrLoadClaimLog.class);
		
		if(irLoadClaimLog != null){
			if(StringUtils.isNotEmpty(irLoadClaimLog.getFileName())){
				criteria.add(Restrictions.like("fileName", irLoadClaimLog.getFileName()));
			}
		}
		return criteria.list();
	}
}
