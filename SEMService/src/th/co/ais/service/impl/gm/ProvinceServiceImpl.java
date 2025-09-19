package th.co.ais.service.impl.gm;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import th.co.ais.dao.impl.gm.ProvinceHibernateDAO;
import th.co.ais.domain.gm.Amphur;
import th.co.ais.domain.gm.Province;
import th.co.ais.service.AbstractService;
import th.co.ais.service.gm.IProvinceService;

public class ProvinceServiceImpl extends AbstractService implements IProvinceService {
	
	private ProvinceHibernateDAO provinceDao;
	
	public void setProvinceDao(ProvinceHibernateDAO provinceDao) {
		this.provinceDao = provinceDao;
	}

	@Override
	public List<Province> searchProvinceByCode(String provinceCode) throws Exception {
		Province province = new Province();
		province.setProvinceCode(provinceCode);
		return provinceDao.queryProvince(province);
	}

	@Override
	public List<Province> searchProvinceByNameThai(String provinceName) throws Exception {
		Province province = new Province();
		province.setThaiName(provinceName);
		return provinceDao.queryProvince(province);
	}
	
	@Override
	public List<Province> searchProvinceByNameEng(String provinceName) throws Exception {
		Province province = new Province();
		province.setEngName(provinceName);
		return provinceDao.queryProvince(province);
	}

	@Override
	public List<Province> searchProvince(String provinceCode, String provinceName, String Language) throws Exception {
		Province province = new Province();
		province.setProvinceCode(provinceCode);
		if(StringUtils.equals(Language, "TH"))
		province.setThaiName(provinceName);
		else if(StringUtils.equals(provinceName, "EN"))
		province.setEngName(provinceName);
		return provinceDao.queryProvince(province);
	}

	@Override
	public List<Province> getListProvince() throws Exception {
		Province province = new Province();
		return provinceDao.queryProvince(province);
	}

	@Override
	public List<Province> getListProvinceByRegions(Object[] regions) throws Exception {
		return provinceDao.queryProvinceByRegions(regions);
	}
	
	@Override
	public List<Province> getListProvinceBySamRegions(Object[] samRegions) throws Exception {
		
//		return provinceDao.queryProvinceBySamRegions(samRegions);
		
		List<Province> provinceList = new ArrayList<Province>();
		Province provinceTmp = new Province();
		List<Object[]> objProvinceList = provinceDao.queryProvinceBySamRegions(samRegions);
		try{
		for(Object[] provinceObj : objProvinceList){
			provinceTmp = new Province();
			if(provinceObj[0] != null){
				provinceTmp.setRowId(provinceObj[0].toString());
			}
			if(provinceObj[1] != null){
				provinceTmp.setProvinceCode(provinceObj[1].toString());
			}
			if(provinceObj[2] != null){
				provinceTmp.setThaiName(provinceObj[2].toString());
			}
			if(provinceObj[3] != null){
				provinceTmp.setEngName(provinceObj[3].toString());
			}
			if(provinceObj[4] != null){
				provinceTmp.setAreaCode(provinceObj[4].toString());
			}
			if(provinceObj[5] != null){
				provinceTmp.setRegion(provinceObj[5].toString());
			}
			if(provinceObj[6] != null){
				provinceTmp.setSamRegion(provinceObj[6].toString());
			}
			if(provinceObj[7] != null){
				provinceTmp.setZone(provinceObj[7].toString());
			}
			if(provinceObj[8] != null){
				provinceTmp.setLacCode(provinceObj[8].toString());
			}	
			
			provinceList.add(provinceTmp);
			
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return provinceList;
	}

	@Override
	public Province queryProvinceByRowId(String rowId) throws Exception {
		
		return provinceDao.queryByRowId(rowId);
	}

	@Override
	public List<String> getSamRegionAll() throws Exception {
		return provinceDao.queryAllSamRegions();
	}
	
	@Override
	public List<Province> searchProvince(Province Province) throws Exception {
		return provinceDao.queryProvince(Province);
	}

	@Override
	public List<Province> getProvinceList_SEM() throws Exception {
		return provinceDao.getProvinceList_SEM();
	}
	
}
