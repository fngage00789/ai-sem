package th.co.ais.service.gm;

import java.util.List;
import java.util.Map;

import th.co.ais.domain.gm.Amphur;
import th.co.ais.domain.gm.Province;
import th.co.ais.service.BaseService;

public interface IAmphurService extends BaseService{
	
	public List<Amphur> searchAmphurByNameThai(String amphurName) throws Exception;
	
	public List<Amphur> searchAmphurByNameEng(String amphurName) throws Exception;
	
	public List<Amphur> searchAmphur(String amphurCode, String amphurName, String Language) throws Exception;
	
	public List<Amphur> getListAmphur() throws Exception;
	
	public List<Amphur> getListAmphurByProvince(Province province) throws Exception;
	
	public Amphur searchAmphurByRowId(String rowId) throws Exception;
	
	
	// added by.. YUT 2015/10/12
	public List<Amphur> getAmphurList_SEM(Province province) throws Exception;
	public List<Map<String, Object>> getDistrictList_SEM(Province province, String amphurCode) throws Exception;
}
