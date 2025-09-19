package com.ais.migrate.sem.spring.service;

import java.util.List;
import com.ais.migrate.sem.spring.dao.SemElMeterInfoDAO;
  
public class SemElMeterInfoService {
	private SemElMeterInfoDAO semElMeterInfoDAO; 


	public void setSemElMeterInfoDAO(SemElMeterInfoDAO semElMeterInfoDAO) {
		this.semElMeterInfoDAO = semElMeterInfoDAO;
	}


	public List getsemElMeterInfoList(){		
		return semElMeterInfoDAO.getSemElMeterInfoList();
	}
	
}
