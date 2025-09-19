package com.ais.migrate.mnims.spring.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ais.migrate.mnims.hibernate.annotion.MetabCompany;
import com.ais.migrate.mnims.spring.dao.iface.IMetabCompanyDAO;

@SuppressWarnings("all")
public class MetabCompanyDAO extends HibernateDaoSupport implements
IMetabCompanyDAO {
	
	public MetabCompany getMetabCompany(String id) {
		return (MetabCompany) this.getHibernateTemplate().get(MetabCompany.class, id);
	}
	
	public List<MetabCompany> getMetabCompanyList() {
		String hqlQuery = "From MetabCompany";
		return this.getHibernateTemplate().find(hqlQuery);
	}

	public void saveMetabCompany(MetabCompany metabCompany) {
		this.getHibernateTemplate().save(metabCompany);
	}
	
	public void updateMetabCompany(
			MetabCompany metabCompany) {	
		this.getHibernateTemplate().update(metabCompany);
	}
		
	public void deleteMetabCompany(MetabCompany metabCompany) {
		this.getHibernateTemplate().delete(metabCompany);
	}
}
