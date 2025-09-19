package th.co.ais.service.gm;

import java.util.List;

import th.co.ais.domain.gm.Province;
import th.co.ais.service.BaseService;

public interface IProvinceService extends BaseService{
	
	public List<Province> searchProvinceByCode(String provinceCd) throws Exception;
	
	public List<Province> searchProvinceByNameThai(String provinceName) throws Exception;
	
	public List<Province> searchProvinceByNameEng(String provinceName) throws Exception;
	
	public List<Province> searchProvince(String provinceCode, String provinceName, String Language) throws Exception;
	
	public List<Province> getListProvince() throws Exception;
	
	public List<Province> getListProvinceByRegions(Object[] regions) throws Exception;
	
	public List<Province> getListProvinceBySamRegions(Object[] samRegions) throws Exception;
	
	public Province queryProvinceByRowId(String rowId) throws Exception;
	
	public List<String> getSamRegionAll() throws Exception;
	
	public List<Province> searchProvince(Province Province) throws Exception;
	
	// added by.. YUT 2015/10/12
	public List<Province> getProvinceList_SEM() throws Exception;
	
}
