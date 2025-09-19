package th.co.ais.dao.impl.gm;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.domain.gm.GLAccount;

public class GLAccountHibernateDAO extends AbstractHibernateDAO<GLAccount>{
	
	public List<GLAccount> queryByCriteria(GLAccount glAccount){
		Session session = getSessionFactory().getCurrentSession();
		Criteria cri = session.createCriteria(GLAccount.class);
		
		if(glAccount != null){
			
			if(glAccount.getRowId() != null &&  StringUtils.isNotEmpty(glAccount.getRowId())){
				cri.add(Restrictions.eq("rowId", glAccount.getRowId()));
			}
			
			if(glAccount.getCompany() != null && StringUtils.isNotEmpty(glAccount.getCompany().trim())){
				cri.add(Restrictions.eq("company", glAccount.getCompany()));
			}
			
			if(glAccount.getGlAccount() != null &&  StringUtils.isNotEmpty(glAccount.getGlAccount())){
				cri.add(Restrictions.eq("glAccount", glAccount.getGlAccount().trim().replace("*", "%")));
			}
			
			if(glAccount.getExpenseType() != null &&  StringUtils.isNotEmpty(glAccount.getExpenseType().trim())){
				cri.add(Restrictions.like("expenseType", glAccount.getExpenseType()));
			}
			
			if(glAccount.getGlType() != null && StringUtils.isNotEmpty(glAccount.getGlType().trim())){
				cri.add(Restrictions.eq("glType", glAccount.getGlType()));
			}
			
			if(StringUtils.isNotEmpty(glAccount.getRecordStatus().trim()) && !"ALL".equals(glAccount.getRecordStatus().trim())){
				cri.add(Restrictions.eq("recordStatus", glAccount.getRecordStatus().trim()));
			}
			
		}
		cri.addOrder(Order.asc("company"));
		return cri.list();
	}
}
