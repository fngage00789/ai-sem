package th.co.ais.service.impl.ir;

import java.util.List;

import th.co.ais.dao.impl.ir.DeductibleHibernateDAO;
import th.co.ais.domain.ir.Deduct;
import th.co.ais.service.AbstractService;
import th.co.ais.service.ir.IDeductibleService;

public class DeductibleServiceImpl extends AbstractService implements IDeductibleService{

	private DeductibleHibernateDAO deductibleDao;
	
	public void setDeductibleDao(DeductibleHibernateDAO deductibleDao) {
		this.deductibleDao = deductibleDao;
	}

	@Override
	public Boolean checkDeductibleDuplicate(Deduct deduct) throws Exception {
		List<Deduct> deducts = queryDeductibleByCriteria(deduct);
		if(deducts != null && !deducts.isEmpty()){
			return Boolean.TRUE;
		}else{
			return Boolean.FALSE;
		}
	}

	@Override
	public void createDeductible(Deduct deduct) throws Exception {
		deductibleDao.save(deduct);
		
	}

	@Override
	public void deleteDeduct(Deduct deduct) throws Exception {
		deduct.setRecordStatus("N");
		deductibleDao.mergeFlush(deduct);
	}

	@Override
	public List<Deduct> queryDeductibleByCriteria(Deduct deduct)throws Exception {
		return deductibleDao.queryDeductible(deduct);
	}

	@Override
	public Deduct queryDeductibleByRowId(String rowId) throws Exception {
		return deductibleDao.findByRowId(rowId);
	}

	@Override
	public void updateDeductible(Deduct deduct) throws Exception {
		List<Deduct> deducts = queryDeductibleByCriteria(deduct);
		if(deducts != null && !deducts.isEmpty()){
			for(Deduct dct : deducts){
				dct.setRecordStatus("N");
				deductibleDao.mergeFlush(dct);
			}
		}
		deduct.setRecordStatus("Y");
		deductibleDao.merge(deduct);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List querySPList(String spName, Object property) throws Exception {
		return deductibleDao.querySPList(spName, property);
	}
}
