package com.ais.migrate.sem.spring.service.tran;

import java.util.Collection;
import java.util.List;

import com.ais.migrate.sem.hibernate.annotion.SapMapping;
import com.ais.migrate.sem.spring.dao.MigrateDAO;
import com.ais.migrate.sem.spring.dao.exception.DAOException;

public class MigrateService {
	private MigrateDAO migrateDAO;

	public MigrateDAO getMigrateDAO() {
		return migrateDAO;
	}

	public void setMigrateDAO(MigrateDAO migrateDAO) {
		this.migrateDAO = migrateDAO;
	}
	
	public void save(Object input) throws DAOException {
		migrateDAO.save(input);
	}
	
	public Object querySingleBySP(String spName, Object property) throws DAOException {
		return migrateDAO.querySingleBySP(spName, property);
	}
	
	public List<SapMapping> querySapMapping(final String templateId) throws DAOException{
		return migrateDAO.querySapMapping(templateId);
	}
	
	/*public List getMpContractCleans(int rowStart, int rowEnd)throws DAOException{
		return migrateDAO.getMpContractCleans(rowStart, rowEnd);
	}*/
}
