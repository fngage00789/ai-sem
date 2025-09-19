package th.co.ais.service.impl.gm;
import java.util.List;
import java.util.Map;

import th.co.ais.dao.impl.gm.AmphurHibernateDAO;
import th.co.ais.domain.gm.Amphur;
import th.co.ais.domain.gm.Province;
import th.co.ais.service.AbstractService;
import th.co.ais.service.gm.IAmphurService;

public class AmphurServiceImpl extends AbstractService implements IAmphurService {
	
	private AmphurHibernateDAO amphurDao;
	
	

	public void setAmphurDao(AmphurHibernateDAO amphurDao) {
		this.amphurDao = amphurDao;
	}

	@Override
	public List<Amphur> getListAmphur() throws Exception {
		Amphur amphur = new Amphur();
		return amphurDao.queryAmphur(amphur);
	}

	@Override
	public List<Amphur> getListAmphurByProvince(Province province)
			throws Exception {
		return amphurDao.queryAmphurByProvince(province);
	}

	@Override
	public List<Amphur> searchAmphur(String amphurCode, String amphurName,
			String Language) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Amphur> searchAmphurByNameEng(String amphurName)
			throws Exception {
		Amphur amphur = new Amphur();
		amphur.setEngName(amphurName);
		return amphurDao.queryAmphur(amphur);
	}

	@Override
	public List<Amphur> searchAmphurByNameThai(String amphurName)
			throws Exception {
		Amphur amphur = new Amphur();
		amphur.setThaiName(amphurName);
		return amphurDao.queryAmphur(amphur);
	}

	@Override
	public Amphur searchAmphurByRowId(String rowId) throws Exception {
		return amphurDao.queryAmphurByRowId(rowId);
	}

	@Override
	public List<Amphur> getAmphurList_SEM(Province province) throws Exception {
		return amphurDao.getAmphurList_SEM(province);
	}

	@Override
	public List<Map<String, Object>> getDistrictList_SEM(Province province, String amphurCode)
			throws Exception {
		return amphurDao.getDistrictList_SEM(province, amphurCode);
	}
	


}
