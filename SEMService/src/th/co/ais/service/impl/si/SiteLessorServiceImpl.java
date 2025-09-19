package th.co.ais.service.impl.si;

import java.util.List;

import th.co.ais.dao.impl.si.SiteLessorHibernateDAO;
import th.co.ais.domain.gm.CT001Export;
import th.co.ais.domain.si.Lessor;
import th.co.ais.domain.si.LessorInfo;
import th.co.ais.service.AbstractService;
import th.co.ais.service.si.ISiteLessorService;
import th.co.ais.util.EQueryName;

public class SiteLessorServiceImpl extends AbstractService implements ISiteLessorService {

	private SiteLessorHibernateDAO siteLessorDao;

	public void setSiteLessorDao(SiteLessorHibernateDAO siteLessorDao) {
		this.siteLessorDao = siteLessorDao;
	}

	@Override
	public Lessor createSiteLessor(Lessor siteLessor) throws Exception {
		siteLessor.setRowId(null);
		siteLessor.setRecordStatus("Y");
		return siteLessorDao.merge(siteLessor);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List querySPList(String spName, Object property) throws Exception {
		return siteLessorDao.querySPList(spName, property);
	}

	@Override
	public List<Lessor> queryLessorBySiteInfoId(String assignSiteInfoId)
			throws Exception {
		return siteLessorDao.queryLessorBySiteInfoId(assignSiteInfoId);
	}

	@Override
	public void createSiteLessorList(List<Lessor> siteLessorList, String siteInfoId, String user)
			throws Exception {
		if(siteLessorList != null && !siteLessorList.isEmpty()){
			Integer seqNo = 0;
			for(Lessor lessor : siteLessorList){
				lessor.setSiteInfoId(siteInfoId);
				lessor.setSeqNo(seqNo + 1); 
				lessor.setCurrentUser(user);
				this.createSiteLessor(lessor);
			}
		}
	}

	@Override
	public void deleteLessor(Lessor siteLessor) throws Exception {
		siteLessor.setRecordStatus("N");
		siteLessorDao.mergeFlush(siteLessor);
	}

	@Override
	public Lessor queryLessorByRowId(String rowId) throws Exception {
		return siteLessorDao.findByRowId(rowId);
	}

	@Override
	public Lessor updateLessor(Lessor siteLessor) throws Exception {
		return siteLessorDao.merge(siteLessor);
	}

	@Override
	public LessorInfo queryLessorInfoByRowId(String rowId) throws Exception {
		LessorInfo property = new LessorInfo();
		property.setSiteLessorId(rowId);
		List l = siteLessorDao.querySPList(EQueryName.Q_CT001_L_SRCH.name, property);
		if(l != null & !l.isEmpty()){
			return (LessorInfo)l.get(0);
		}
		return null;
	}

	@Override
	public void deleteLessorList(List<Lessor> siteLessorList) throws Exception {
		if(siteLessorList != null && !siteLessorList.isEmpty()){
			for(Lessor lessor : siteLessorList){
				this.deleteLessor(lessor);
			}
		}
		
	}
	
	
}
