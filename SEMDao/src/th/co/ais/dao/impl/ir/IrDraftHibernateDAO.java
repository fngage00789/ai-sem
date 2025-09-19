package th.co.ais.dao.impl.ir;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.ir.Insured;
import th.co.ais.domain.ir.IrDraft;

public class IrDraftHibernateDAO extends AbstractHibernateDAO<IrDraft> {
	
	public IrDraft findByRowId(final String rowId) throws DAOException {
		String hql = "FROM IrDraft ir WHERE ir.rowId = ?";
		return querySingleByHQL(hql, rowId);
	}
	
}
