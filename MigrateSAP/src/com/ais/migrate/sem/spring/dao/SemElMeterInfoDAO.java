package com.ais.migrate.sem.spring.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ais.migrate.sem.hibernate.annotion.SemElMeterInfo;
import com.ais.migrate.sem.spring.dao.iface.ISemElMeterInfoDAO;

@SuppressWarnings("all")
public class SemElMeterInfoDAO extends HibernateDaoSupport implements
ISemElMeterInfoDAO {
	 
	public SemElMeterInfo getSemElMeterInfo(String id) { 
		return (SemElMeterInfo) this.getHibernateTemplate().get(SemElMeterInfo.class, id);
	}
	
	public List<SemElMeterInfo> getSemElMeterInfoList() {
		String hqlQuery = "From SemElMeterInfo";
		return this.getHibernateTemplate().find(hqlQuery);
	}

	public void saveSemElMeterInfo(SemElMeterInfo semElMeterInfo) { 
		this.getHibernateTemplate().save(semElMeterInfo);
	}
	
	public void updateSemElMeterInfo(SemElMeterInfo semElMeterInfo) {	
		this.getHibernateTemplate().update(semElMeterInfo);
	}
		
	public void deleteSemElMeterInfo(SemElMeterInfo semElMeterInfo) {
		this.getHibernateTemplate().delete(semElMeterInfo);
	}
}
