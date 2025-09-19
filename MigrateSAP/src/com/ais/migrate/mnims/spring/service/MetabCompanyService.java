package com.ais.migrate.mnims.spring.service;

import java.util.List;

import com.ais.migrate.mnims.spring.dao.MetabCompanyDAO;
  
public class MetabCompanyService {
	private MetabCompanyDAO metabCompanyDAO;

	public void setMetabCompanyDAO(MetabCompanyDAO metabCompanyDAO) {
		this.metabCompanyDAO = metabCompanyDAO;
	}


	public List getMetabCompanyList(){		
		return metabCompanyDAO.getMetabCompanyList();
	}
	
}
