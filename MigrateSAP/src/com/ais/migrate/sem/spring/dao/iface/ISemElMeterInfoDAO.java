package com.ais.migrate.sem.spring.dao.iface;

import java.util.List;

import com.ais.migrate.sem.hibernate.annotion.SemElMeterInfo;

public interface ISemElMeterInfoDAO {
	
	public List<SemElMeterInfo>  getSemElMeterInfoList(); 
	public SemElMeterInfo getSemElMeterInfo(String Id);
	public void saveSemElMeterInfo(SemElMeterInfo semElMeterInfo);
	public void updateSemElMeterInfo(SemElMeterInfo semElMeterInfo);
	public void deleteSemElMeterInfo(SemElMeterInfo semElMeterInfo);
	
}