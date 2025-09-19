package th.co.ais.service.impl.ir;

import java.util.List;

import th.co.ais.dao.impl.ir.GenerateDraftHibernateDAO;
import th.co.ais.domain.ir.ExGenerateDraftSP;
import th.co.ais.service.AbstractService;
import th.co.ais.service.ir.IGenerateDraft;
import th.co.ais.util.EQueryName;

public class GenerateDraftServiceImpl extends AbstractService implements IGenerateDraft {
	
	private GenerateDraftHibernateDAO generateDraftDao;
	
	public void setGenerateDraftDao(GenerateDraftHibernateDAO generateDraftDao) {
		this.generateDraftDao = generateDraftDao;
	}

	@Override
	public List<ExGenerateDraftSP> queryMIR008Ex1(String draftNo) throws Exception {
		ExGenerateDraftSP property = new ExGenerateDraftSP();
		property.setDraftNo(draftNo);
		return generateDraftDao.querySPList(EQueryName.Q_MIR008_EX1.name, property);
	}

	@Override
	public List<ExGenerateDraftSP> queryMIR008Ex2(String draftNo) throws Exception {
		ExGenerateDraftSP property = new ExGenerateDraftSP();
		property.setDraftNo(draftNo);
		return generateDraftDao.querySPList(EQueryName.Q_MIR008_EX2.name, property);
	}

	@Override
	public List<ExGenerateDraftSP> queryMIR008Ex3(String draftNo) throws Exception {
		ExGenerateDraftSP property = new ExGenerateDraftSP();
		property.setDraftNo(draftNo);
		return generateDraftDao.querySPList(EQueryName.Q_MIR008_EX3.name, property);
	}

}
