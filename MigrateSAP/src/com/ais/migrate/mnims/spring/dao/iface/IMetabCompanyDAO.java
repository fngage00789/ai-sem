package com.ais.migrate.mnims.spring.dao.iface;

import java.util.List;

import com.ais.migrate.mnims.hibernate.annotion.MetabCompany;

public interface IMetabCompanyDAO {
	
	public List<MetabCompany>  getMetabCompanyList();
	public MetabCompany getMetabCompany(String Id);
	public void saveMetabCompany(MetabCompany metabCompany);
	public void updateMetabCompany(MetabCompany metabCompany);
	public void deleteMetabCompany(MetabCompany metabCompany);
	
}