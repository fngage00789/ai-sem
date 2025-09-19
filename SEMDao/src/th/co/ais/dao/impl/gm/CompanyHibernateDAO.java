package th.co.ais.dao.impl.gm;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.gm.Company;
import th.co.ais.domain.gm.SsoCompanyUser;

public class CompanyHibernateDAO extends AbstractHibernateDAO<Company>{

	@SuppressWarnings("unchecked")
	public List<Company> getCompanyAll() throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Company.class);
		// criteria.add(Restrictions.like("recordStatus", "Y"));
		criteria.addOrder(Order.asc("rowId"));
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Company> getCompanyByRole(SsoCompanyUser c) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria _cCom = session.createCriteria(Company.class);
		Criteria _cSso = session.createCriteria(SsoCompanyUser.class);
		if(c!=null){
			if(c.getId()!=null){
				if(c.getId().getCompanyCode()!=null && c.getId().getCompanyCode().length()>0)
					_cSso.add(Restrictions.eq("id.companyCode", c.getId().getCompanyCode()));
				if(c.getId().getUserGroup()!=null && c.getId().getUserGroup().length()>0)
					_cSso.add(Restrictions.eq("id.userGroup", c.getId().getUserGroup()));
			}
			if(c.getSubModule()!=null && c.getSubModule().length()>0)
				_cSso.add(Restrictions.eq("subModule", c.getSubModule()));
		}
		
		List<SsoCompanyUser> lcSso = _cSso.list();
		List<String> companies = new ArrayList<String>();
		for(SsoCompanyUser ssoC : lcSso){
			companies.add(ssoC.getId().getCompanyCode());
		}
		
		if(companies.size()>0){
			_cCom.add(Restrictions.in("rowId", companies.toArray(new String[0])));	
		}
		List<Company> listCompany = _cCom.list();			
		return listCompany;
	}
	
	@SuppressWarnings("unchecked")
	public List<SsoCompanyUser> getSsoCompanyUser(SsoCompanyUser c) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria _cSso = session.createCriteria(SsoCompanyUser.class);
		if(c!=null){
			if(c.getId()!=null){
				if(c.getId().getCompanyCode()!=null && c.getId().getCompanyCode().length()>0)
					_cSso.add(Restrictions.eq("id.companyCode", c.getId().getCompanyCode()));
				if(c.getId().getUserGroup()!=null && c.getId().getUserGroup().length()>0)
					_cSso.add(Restrictions.eq("id.userGroup", c.getId().getUserGroup()));
			}
			if(c.getSubModule()!=null && c.getSubModule().length()>0)
				_cSso.add(Restrictions.eq("subModule", c.getSubModule()));			
		}
		_cSso.addOrder(Order.asc("id.companyCode"));
		return _cSso.list();
	}
	
	public Company queryContract(final Company company) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Company.class);
		
		if (company != null) {
			if (StringUtils.isNotEmpty(company.getRowId())) {
				criteria.add(Restrictions.like("rowId", company.getRowId().replace("*", "%")));
			}
		}
		
		return (Company) criteria.uniqueResult();
	}
}
