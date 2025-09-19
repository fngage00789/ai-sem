package th.co.ais.service.impl.gm;

import java.util.List;

import th.co.ais.dao.impl.el.PLUtil;
import th.co.ais.dao.impl.gm.BgMasterHibernateDAO;
import th.co.ais.domain.gm.BgMaster;
import th.co.ais.domain.gm.CT002UpdateRentSP;
import th.co.ais.service.AbstractService;
import th.co.ais.service.gm.IBgMasterService;

public class BgMasterServiceImpl extends AbstractService implements IBgMasterService{

	private BgMasterHibernateDAO bgMasterDao;
	private PLUtil plUtil;
	
	public void setPlUtil(PLUtil plUtil) {
		this.plUtil = plUtil;
	}
	public void setBgMasterDao(BgMasterHibernateDAO bgMasterDao) {
		this.bgMasterDao = bgMasterDao;
	}
	
	@Override
	public void updateBgMaster(BgMaster bgMaster) throws Exception {
		bgMasterDao.update(bgMaster);
	}
	
	@Override
	public void deleteBgMasterRecord(BgMaster bgMaster) throws Exception {
		bgMaster.setRecordStatus(STATUS_N);
		bgMasterDao.merge(bgMaster);
	}

	@Override
	public List<BgMaster> queryBgMasterByCriteria(BgMaster criteria) throws Exception {
		criteria.setRecordStatus(STATUS_Y);
		return bgMasterDao.queryBgMaster(criteria);
	}

	@Override
	public BgMaster getBgMasterByRowId(String rowId) throws Exception {
		return bgMasterDao.findByRowId(rowId);
	}

	@Override
	public BgMaster createBgMaster(BgMaster bgMaster) throws Exception {
		bgMaster.setRecordStatus(STATUS_Y);
		return bgMasterDao.merge(bgMaster);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List queryBGMasterSPList(String spName, Object property) throws Exception {
		return bgMasterDao.querySPList(spName, property);
	}
	
	@Override
	public CT002UpdateRentSP updateMCT002Rent(CT002UpdateRentSP property) throws Exception {
		return bgMasterDao.updateCT002Rent(property);
	}

}
