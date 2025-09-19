package th.co.ais.service.impl.ir;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateOptimisticLockingFailureException;

import th.co.ais.dao.exception.DAOException;
import th.co.ais.dao.impl.ir.ReplacementHibernateDAO;
import th.co.ais.domain.ir.Replacement;
import th.co.ais.service.AbstractService;
import th.co.ais.service.ir.IReplacementService;

public class ReplacementServiceImpl extends AbstractService implements IReplacementService {

	private ReplacementHibernateDAO replacementDao;
	
	public void setReplacementDao(ReplacementHibernateDAO replacementDao) {
		this.replacementDao = replacementDao;
	}

	@Override
	public void createReplacement(Replacement replacement) throws Exception {
		replacementDao.save(replacement);
	}

	@Override
	public void updateReplacement(Replacement replacement) throws Exception {
		
		try{
			List<Replacement> replacments = queryReplacementByCriteria(replacement);
			if( replacments != null && !replacments.isEmpty()){
				for (Replacement repl : replacments) {
					repl.setRecordStatus("N");
					replacementDao.mergeFlush(repl);
				}
			}
			replacement.setRecordStatus("Y");
			replacementDao.merge(replacement);
		}catch(DAOException e){
			if(e.getCause() instanceof HibernateOptimisticLockingFailureException)
			throw new Exception("Row was updated or deleted by another transaction.");
		}
	}
	
	@Override
	public void deleteReplacement(Replacement replacement) throws Exception {
		replacement.setRecordStatus("N");
		replacementDao.mergeFlush(replacement);		
	}

	
	@Override
	public List<Replacement> queryReplacementByCriteria(Replacement replacement) throws Exception {
		return replacementDao.queryReplacement(replacement);
	}

	@Override
	public Boolean checkReplacementDuplicate(Replacement replacement) throws Exception {
		List<Replacement> replacments = queryReplacementByCriteria(replacement);
		if(replacments != null && !replacments.isEmpty()){
			return Boolean.TRUE;
		}else{
			return Boolean.FALSE;
		}
	}

	@Override
	public Replacement queryReplacementByRowId(String rowId) throws Exception {
		return replacementDao.findByRowId(rowId);
	}	

	@Override
	@SuppressWarnings("unchecked")
	public List querySPList(String spName, Object property) throws Exception {
		return replacementDao.querySPList(spName, property);
	}
}
